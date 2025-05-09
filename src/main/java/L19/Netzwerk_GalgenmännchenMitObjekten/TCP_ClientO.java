package L19.Netzwerk_GalgenmännchenMitObjekten;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCP_ClientO {
    public static void main(String[] args) {
        final int PORT = 12;
        final String HOST = "localhost";
        Scanner scanner = new Scanner(System.in);

        try (
                //Socket-Verbindung zum Server
                Socket connectionToServer = new Socket(HOST, PORT);

                //Objekt-Streams statt Text-Streams
                ObjectOutputStream oos   = new ObjectOutputStream(connectionToServer.getOutputStream());
                ObjectInputStream  ois   = new ObjectInputStream(connectionToServer.getInputStream())
        ) {
            // Anfangszustand vom Server empfangen
            Antwort antwort = (Antwort) ois.readObject();
            System.out.println(antwort.getSichtbaresWort());

            // Solange das Spiel nicht vorbei ist, weiterraten
            while (!antwort.isSpielVorbei()) {
                System.out.print("Bitte gib einen Buchstaben ein: ");
                String eingabe = scanner.nextLine().trim();

                //genau ein buchstabe darf eingegeben werden
                if (eingabe.length() != 1 || !Character.isLetter(eingabe.charAt(0))) {
                    System.out.println("Bitte gib nur einen Buchstaben ein.");
                    continue;
                }

                // Objekt mit dem Tipp erzeugen und senden
                Rateversuch versuch = new Rateversuch(eingabe.charAt(0));
                oos.writeObject(versuch);
                oos.flush();

                // Neue Antwort vom Server empfangen
                antwort = (Antwort) ois.readObject();
                System.out.println("-> " + antwort.getSichtbaresWort());

                // Prüfen, ob das Spiel nun vorbei ist
                if (antwort.isSpielVorbei()) {
                    if (antwort.isWortEraten()) {
                        System.out.println("Herzlichen Glückwunsch, du hast das Wort erraten!");
                    } else {
                        System.out.println("Leider verloren! Das Wort war: " + antwort.getLoesung());
                    }
                    //Schleife wirklich beenden, wenn das Spiel vorbei ist.
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
