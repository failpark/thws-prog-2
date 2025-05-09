package L19.Netzwerk_GalgenmännchenMitObjekten;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class TCP_ServerO {
    public static void main(String[] args) throws Exception {
        final int PORT = 12;
        System.out.println("Server startet auf Port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket connection = serverSocket.accept();
             ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(connection.getInputStream())) {

            Speillogik spiel = new Speillogik();

            // Initialer Status
            oos.writeObject(spiel.gibInitialenStatus());
            oos.flush();

            while (true) {
                Rateversuch versuch = (Rateversuch) ois.readObject();
                Antwort antwort = spiel.verarbeiteTipp(versuch.getBuchstabe());

                oos.writeObject(antwort);
                oos.flush();

                if (antwort.isSpielVorbei()) {
                    TimeUnit.SECONDS.sleep(1);
                    break;
                }
            }
        }
    }
}