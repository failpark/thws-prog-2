package L19.Netzwerk_GalgenmännchenMitObjekten;


/**
 * Diese Klasse enthält die gesamte Galgenmännchen-Logik:
 * - Auswahl eines zufälligen Lösungsworts
 * - Verarbeitung jedes Tipps
 * - Erzeugung des Status-Strings
 *
 * Sie ist völlig unabhängig von Netzwerk- oder I/O-Aspekten
 * und kann deshalb sowohl vom Server als auch (in Zukunft) von einer GUI
 * oder anderen Clients wiederverwendet werden.
 */


public class Speillogik {

    private final String loesung;
    private final char[] teileDerLoesung;
    private final char[] input;
    private int versuche;


    //Konstruktur erzeugen des spieles
    public Speillogik(){
        this.loesung = waehleWort();
        this.teileDerLoesung = loesung.toCharArray();
        this.input = new char[loesung.length()];
        this.versuche = 10;
    }

    //Zufälliges gesuchtes Wort
    private String waehleWort(){
        String[] worte = {
                "Programmiersprache", "Papierflieger", "Krokodil", "Schneeflocke",
                "Wassermelone", "Feuerwehr", "Sandburg", "Raketenstart",
                "Schmetterling", "Zauberspruch", "Hinterhof", "Karamellbonbon",
                "Gespensterhaus", "Unterwasser", "Schatztruhe", "Wasserfall",
                "Luftballon", "Zahnarzt", "Wellenbrecher", "Abenteuer"
        };
        int auswahl = (int) (Math.random() * worte.length);
        return worte[auswahl];
    }

    //Ablauf nach eratenten buchstaben
    public Antwort verarbeiteTipp(char tipp){
        //Trefferprüfen
        boolean gefunden = false;

        for (int i = 0; i < teileDerLoesung.length; i++) {
            if (teileDerLoesung[i] == tipp){
                input[i] = tipp;
                gefunden = true;
            }
        }
        //Nicht geufen verusch abziehen
        if (!gefunden) versuche--;

        // Genearieren des wortes mit Untertrichen
        String status = generiereStatus();

        // Prüfe, ob das Wort komplett erraten wurde:
        boolean wortErraten = !status.contains("_");

        // Prüfe, ob das Spiel vorbei ist (keine Versuche mehr ODER Wort erraten)
        boolean spielVorbei;
        if (versuche == 0) {
            spielVorbei = true;
        } else if (wortErraten) {
            spielVorbei = true;
        } else {
            spielVorbei = false;
        }

        // Nur wenn verloren: echte Lösung mitschicken
        String loesungSenden;
        if (!wortErraten && spielVorbei) {
            // Spiel vorbei und Wort nicht erraten → sende Lösung
            loesungSenden = loesung;
        } else {
            // Sonst: keine Lösung mitschicken
            loesungSenden = null;
        }

        //Antwort-Objekte erstellen und zurücksenden mit allen infos
        return new Antwort(status, gefunden, spielVorbei, wortErraten, versuche, loesungSenden);
    }

    //Status bei spielstart
    public Antwort gibInitialenStatus(){
        return new Antwort(generiereStatus(), false, false,false,versuche, null);
    }


    private String generiereStatus(){
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < teileDerLoesung.length; i++) {
            status.append(input[i] == teileDerLoesung[i] ? teileDerLoesung[i] : '_');
        }
        return versuche + " Versuche übrig: " +status.toString();
    }
}
