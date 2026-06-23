package it.unicatt.sherlock.view.risorsa;

/** Path di immagini e audio dentro il progetto */
public final class CostantiRisorse {

    private CostantiRisorse() {
    }

    private static final String CARTELLA_IMMAGINI = "/img/";
    private static final String CARTELLA_AUDIO = "/audio/";
    public static final String MAPPA = CARTELLA_IMMAGINI + "mappa.png";
    public static final String SFONDO_MENU = CARTELLA_IMMAGINI + "sfondo.png";
    public static final String TRACCIA_AUDIO = CARTELLA_AUDIO + "traccia audio gioco.wav";

    private static final String CARTELLA_LOCATION = CARTELLA_IMMAGINI + "stanze/";
    private static final String CARTELLA_INDIZI = CARTELLA_IMMAGINI + "indizi/";
    private static final String CARTELLA_PERSONAGGI = CARTELLA_IMMAGINI + "personaggi/";

    /**
     * @param nomeLocation nome della location
     * @return path dell'immagine in img/stanze/
     */
    public static String immagineLocation(String nomeLocation) {
        return CARTELLA_LOCATION + nomeLocation + ".png";
    }

    /**
     * @param nomeIndizio nome dell'indizio
     * @return path dell'immagine in img/indizi/
     */
    public static String immagineIndizio(String nomeIndizio) {
        return CARTELLA_INDIZI + nomeIndizio + ".png";
    }

    /**
     * @param nomePersonaggio nome del personaggio
     * @return path dell'immagine in img/personaggi/
     */
    public static String immaginePersonaggio(String nomePersonaggio) {
        return CARTELLA_PERSONAGGI + nomePersonaggio + ".png";
    }
}
