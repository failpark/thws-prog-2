package L19.Netzwerk_GalgenmännchenMitObjekten;

import java.io.Serializable;


/**
 * Dieses DTO fasst alle Informationen zusammen, die der Server nach jedem Tipp an den Client zurückschickt:
 *  1. sichtbaresWort: z. B. "5 Versuche übrig: _a__e"
 *  2. treffer:       ob der letzte Tipp im Wort vorkam
 *  3. spielVorbei:   ob das Spiel jetzt endet (Gewinn oder Verlust)
 *  4. wortEraten:    ob der Gewinnzustand (Wort komplett) erreicht ist
 *  5. verbleibendeVersuche: Anzahl der noch möglichen Fehlversuche
 *  6. loesung:       das echte Wort, aber **nur** wenn verloren (sonst null)
 */

public class Antwort  implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String sichtbaresWort;
    private final boolean treffer;
    private final boolean spielVorbei;
    private  final boolean wortEraten;
    private final int verbleibendeVersuche;

    private final String loesung;

    public Antwort(String sichtbaresWort, boolean treffer, boolean spielVorbei, boolean wortEraten, int verbleibendeVersuche, String loesung) {
        this.sichtbaresWort = sichtbaresWort;
        this.treffer = treffer;
        this.spielVorbei = spielVorbei;
        this.wortEraten = wortEraten;
        this.verbleibendeVersuche = verbleibendeVersuche;
        this.loesung = loesung;
    }

    // Getter-Methoden, damit der Client auf die einzelnen Felder zugreifen kann:
    public String getSichtbaresWort() { return sichtbaresWort; }
    public boolean isTreffer() { return treffer; }
    public boolean isSpielVorbei() { return spielVorbei; }
    public boolean isWortEraten() { return wortEraten; }
    public int getVerbleibendeVersuche() {return verbleibendeVersuche;}
    public String getLoesung() { return loesung; }

}
