package it.unicatt.sherlock.view.risorsa;

/** Testi fissi di menu, finestra di gioco e popup */
public final class CostantiTesti {

    private CostantiTesti() {
    }

    public static final String TITOLO_FINESTRA = "Sherlock Game";

    public static final String TITOLO_MENU = "SHERLOCK GAME";
    public static final String BOTTONE_AVVIA_INDAGINE = "Avvia Indagine";
    public static final String BOTTONE_COME_SI_GIOCA = "Come si gioca";
    public static final String MUSICA_ON = "Musica: ON";
    public static final String MUSICA_OFF = "Musica: OFF";

    public static final String BOTTONE_RISOLVI_CASO = "Risolvi il caso!";
    public static final String BOTTONE_TORNA_MAPPA = "< Mappa";
    public static final String TITOLO_MAPPA = "Mappa della villa";
    public static final String PREFISSO_LOCATION_CORRENTE = "Sei in: ";
    public static final String TITOLO_TACCUINO = "Taccuino del detective";

    public static final String BOTTONE_RISOLVI_ENIGMA = "Risolvi enigma";
    public static final String BOTTONE_MOSTRA_FILE_DECIFRATI = "Mostra file decifrati";

    public static final String TITOLO_INTRO = "Incarico Investigativo";
    private static final String TESTO_INTRO_INIZIO = """
            Detective, la polizia ha bisogno del tuo aiuto.

            Ti è stato assegnato il caso: """;
    private static final String TESTO_INTRO_FINE = """

            Usa il taccuino per le tue annotazioni e non tralasciare nulla.\n
            La giustizia conta su di te!
            """;

    public static final String TITOLO_REGOLE = "Regole del gioco";
    public static final String TESTO_REGOLE = """
            COME SI GIOCA

            1. Premi "Avvia Indagine" per entrare nella villa.
            2. Clicca sulle stanze della mappa per esplorarle.
            3. Esamina indizi e personaggi cliccando sugli elementi visibili.
            4. Usa il taccuino per annotare sospetti, prove e collegamenti.
            5. Quando pensi di aver capito la soluzione, premi "Risolvi il caso!".
            6. Formula la tua accusa con attenzione: un bravo detective osserva tutto.

            Suggerimento:
            confronta sempre indizi, moventi e testimonianze prima di accusare.
            """;

    public static final String PREFISSO_ESAMINA_INDIZIO = "Esamina indizio: ";

    public static final String DOMANDA_ACCUSA = "Chi è l'assassino?";
    public static final String TITOLO_ACCUSA = "Fase di accusa";

    public static final String TITOLO_VITTORIA_GRANDE = "ECCELLENTE LAVORO!";
    public static final String TITOLO_VITTORIA = "Vittoria!";
    public static final String PREFISSO_MESSAGGIO_VITTORIA = "Hai risolto brillantemente il caso.\n\n";

    public static final String TITOLO_SCONFITTA_GRANDE = "FALLIMENTO...";
    public static final String TITOLO_SCONFITTA = "Deduzione errata";
    public static final String MESSAGGIO_SCONFITTA = """
            Purtroppo la tua accusa si è rivelata infondata.

            Il vero colpevole è riuscito a far perdere le proprie tracce e ora è a piede libero. \n
            La giustizia ha fallito questa volta e la tua carriera da detective ne risentirà profondamente.""";

    public static final String TITOLO_TENTATIVO_ENIGMA = "Richiesta autenticazione";
    public static final String TITOLO_ENIGMA_CORRETTO = "Sistema decifrato";
    public static final String PREFISSO_ENIGMA_CORRETTO = "Combinazione corretta\n\n";
    public static final String TITOLO_ENIGMA_ERRATO = "Errore di autenticazione";
    public static final String MESSAGGIO_ENIGMA_ERRATO = "Combinazione errata\n\n";
    public static final String PREFISSO_ARCHIVIO_SBLOCCATO = "Archivio sbloccato ";

    /**
     * @param titoloCaso titolo del caso in corso
     * @param descrizioneCaso descrizione del caso in corso
     * @return testo del popup introduttivo
     */
    public static String testoIntro(String titoloCaso, String descrizioneCaso) {
        return TESTO_INTRO_INIZIO + titoloCaso + "\n" + descrizioneCaso + TESTO_INTRO_FINE;
    }

    /**
     * @param nomeIndizio nome dell'indizio esaminato
     * @return titolo del popup
     */
    public static String titoloEsaminaIndizio(String nomeIndizio) {
        return PREFISSO_ESAMINA_INDIZIO + nomeIndizio;
    }

    /**
     * @param soluzione testo della soluzione del delitto
     * @return messaggio completo di vittoria
     */
    public static String messaggioVittoria(String soluzione) {
        return PREFISSO_MESSAGGIO_VITTORIA + soluzione;
    }

    /**
     * @param nomeIndizio nome dell'indizio collegato all'enigma
     * @return titolo del popup archivio
     */
    public static String titoloArchivioSbloccato(String nomeIndizio) {
        return PREFISSO_ARCHIVIO_SBLOCCATO + nomeIndizio;
    }

    /**
     * @param nomeLocation nome della location corrente
     * @return titolo mostrato nella barra superiore
     */
    public static String titoloLocationCorrente(String nomeLocation) {
        return PREFISSO_LOCATION_CORRENTE + nomeLocation;
    }
}
