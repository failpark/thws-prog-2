package L19.Netzwerk_GalgenmännchenMitObjekten;
import java.io.Serializable;


public class Rateversuch implements Serializable{

    private static final long serialVersionUID = 1L;

    // Das einzige Feld: der Buchstabe, den der Spieler geraten hat.
    private final char buchstabe;

    // Konstruktor: Hier übergibt der Client den geratenen Buchstaben.
    public Rateversuch(char buchstabe) {
        this.buchstabe = buchstabe;
    }

    //Server ruft auf um zu wissne welchen Buchstabne der Cielnt getippt hat.
    public char getBuchstabe() {
        return buchstabe;
    }
}
