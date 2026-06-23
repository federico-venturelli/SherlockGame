package it.unicatt.sherlock.model;

/** Testi e identificatori del caso Villa Morandi */
public final class CostantiCasoVilla {

    private CostantiCasoVilla() {
    }

    public static final String TITOLO = "Il Delitto di Villa Morandi";
    public static final String DESCRIZIONE = "Risolvi l'omicidio nella villa esplorando le stanze, analizzando gli indizi e interrogando i sospettati.";

    public static final String LOCATION_CUCINA = "Cucina";
    public static final String LOCATION_SALOTTO = "Salotto";
    public static final String LOCATION_STUDIO = "Studio";
    public static final String LOCATION_TERRAZZO = "Terrazzo";
    public static final String LOCATION_SICUREZZA = "Stanza di sicurezza";
    public static final String LOCATION_CAMERA_OSPITI = "Camera ospiti";

    public static final String INDIZIO_LIBRO = "Libro";
    public static final String INDIZIO_LETTERA_BANCA = "Lettera banca";
    public static final String INDIZIO_BICCHIERE = "Bicchiere";
    public static final String INDIZIO_TAZZINA = "Tazzina";
    public static final String INDIZIO_PANNO = "Panno";
    public static final String INDIZIO_CHIAVI = "Chiavi";
    public static final String INDIZIO_SIGARO = "Sigaro";
    public static final String INDIZIO_PREMIO = "Premio";
    public static final String INDIZIO_POST_IT = "Post it";
    public static final String INDIZIO_MORANDI = "Morandi";
    public static final String INDIZIO_SMARTWATCH = "Smartwatch";
    public static final String INDIZIO_BADGE = "Badge";
    public static final String INDIZIO_PC_PORTATILE = "PC portatile";
    public static final String INDIZIO_TERMINALE_SICUREZZA = "Terminale sicurezza";

    public static final String DESCRIZIONE_INDIZIO_LIBRO = "Un volume di logica matematica avanzata.";
    public static final String DESCRIZIONE_INDIZIO_LETTERA_BANCA = "Lettera dalla banca in cui sollecitano il pagamento dei debiti.";
    public static final String DESCRIZIONE_INDIZIO_BICCHIERE = "Bicchiere di cristallo vuoto, non presenta impronte o tracce sospette.";
    public static final String DESCRIZIONE_INDIZIO_TAZZINA = "Tazzina da caffè in ceramica.";
    public static final String DESCRIZIONE_INDIZIO_PANNO = "Panno in microfibra umido e sporco, rilevate microscopiche schegge di vetro.";
    public static final String DESCRIZIONE_INDIZIO_CHIAVI = "Chiavi generiche.";
    public static final String DESCRIZIONE_INDIZIO_SIGARO = "Un sigaro a metà, spento, all'interno del posacenere.";
    public static final String DESCRIZIONE_INDIZIO_PREMIO = "Premio all'innovazione vinto da Morandi lo scorso anno. Pesante scultura geometrica in vetro di Murano. Uno spigolo è scheggiato.";
    public static final String DESCRIZIONE_INDIZIO_POST_IT = "Post it con scritte ambigue.";
    public static final String DESCRIZIONE_INDIZIO_MORANDI = "Corpo senza vita del professore. Presenta un trauma cranico, nessuna traccia di sangue rilevato.";
    public static final String DESCRIZIONE_INDIZIO_SMARTWATCH = "Smartwatch del professor Morandi, è rotto.";
    public static final String DESCRIZIONE_INDIZIO_BADGE = "Badge di sicurezza di Silvia.";
    public static final String DESCRIZIONE_INDIZIO_PC_PORTATILE = "PC portatile bloccato di Silvia.";
    public static final String DESCRIZIONE_INDIZIO_TERMINALE_SICUREZZA = "Terminale di sicurezza bloccato";

    public static final String CODICE_ENIGMA_PC = "13";
    public static final String TESTO_SBLOCCO_ENIGMA_PC = """
            \nGMAIL\n\nDa: p.morandi@villa.it\nA: s.bianchi@tech.it\nOggetto: Chiarimento urgente su gestione algoritmo\nSilvia,\nho analizzato gli ultimi log di compilazione e i dati dell'algoritmo. Ci sono delle problematiche molto gravi che non posso ignorare.\nLa situazione è più seria del previsto e mette in discussione tutto il nostro lavoro. Dobbiamo parlarne faccia a faccia per decidere come procedere con il futuro della nostra collaborazione.\nProf. P. Morandi """;
    public static final String DOMANDA_ENIGMA_PC = "Inserire la password per accedere al PC.\nSuggerimento: il prossimo nodo della rete è: 2,3,5,7,11,...";

    public static final String CODICE_ENIGMA_TERMINALE = "1280";
    public static final String TESTO_SBLOCCO_ENIGMA_TERMINALE = "19:45: shock meccanico rilevato sullo smartwatch\n19:49: ingresso stanza di sicurezza autorizzato via badge N 2\n19:50: esecuzione comando: cripta log\n19:50: esecuzione comando: tpwsbtdsjuuvsb sfhjtusbajpoj";
    public static final String DOMANDA_ENIGMA_TERMINALE = "Inserire la password per accedere ai log del sistema di sicurezza\nSuggerimento: ho scritto la password come promemoria";

    public static final String PERSONAGGIO_SILVIA = "Silvia";
    public static final String PERSONAGGIO_MARCO = "Marco";
    public static final String PERSONAGGIO_ELENA = "Elena";
    public static final String PERSONAGGIO_ENEA = "Enea";

    public static final String RUOLO_SILVIA = "Socia in affari";
    public static final String RUOLO_MARCO = "Capo della sicurezza";
    public static final String RUOLO_ELENA = "Ex moglie";
    public static final String RUOLO_ENEA = "Maggiordomo";

    public static final String DICHIARAZIONE_SILVIA = "Stavo aspettando il professore nello studio dalle 19:30 circa per rivedere insieme l'algoritmo. L'ho visto vivo per l'ultima volta alle 20, poco prima che scendesse in salotto.";
    public static final String DICHIARAZIONE_MARCO = "L'allarme esterno era attivo e non ha rilevato nulla, deve essere stato qualcuno già presente in villa.";
    public static final String DICHIARAZIONE_ELENA = "Sì è vero, io e mio marito abbiamo litigato furiosamente oggi pomeriggio per l'assegno di mantenimento, ma dalle 19 ero fuori in terrazza a fumare per calmarmi.";
    public static final String DICHIARAZIONE_ENEA = "Stavo preparando la cena qui in cucina. Il signor Morandi era molto teso questa sera, ma non ho sentito nulla fino a quando sono andato in salotto per servire il vino e l'ho trovato morto.";

    public static final String SOLUZIONE = """
            Messa di fronte all'irrefutabile logica della tua ricostruzione e alle prove schiaccianti, Silvia Bianchi crolla in un pianto disperato e confessa l'omicidio del Professor Morandi.
            Ecco come sono andati realmente i fatti in quella tragica serata:\n
            Silvia era intrappolata in una situazione finanziaria disastrosa, soffocata dai debiti con la banca che minacciava il pignoramento imminente. La sua unica ancora di salvataggio erano i futuri guadagni legati al brevetto dell'algoritmo. Tuttavia, il Professor Morandi aveva scoperto gravi anomalie e discrepanze nei server, capendo che Silvia non era adatta al ruolo.\n
            Come indicato nella e-mail, Morandi ha preteso un incontro chiarificatore. Durante il confronto, il professore le ha comunicato l'intenzione di estrometterla legalmente dalla società per giusta causa, revocandole ogni diritto economico sul software. Spinta dal panico e dalla prospettiva della rovina totale, Silvia ha afferrato l'oggetto più vicino, il  Premio in vetro di Murano, e ha colpito il professore alla testa, spaccando contemporaneamente il suo smartwatch e congelando l'ora del delitto.\n
            Per coprire le proprie tracce, Silvia ha trascinato il professore in salotto e poi ha usato il proprio badge per introdursi nella stanza di sicurezza e formattare i server, cancellando i filmati delle telecamere per cancellare i passaggi registrati. Subito dopo, è corsa in cucina per ripulire l'arma del delitto, commettendo però l'errore fatale di abbandonare nel lavandino il Panno in microfibra umido, all'interno del quale la scientifica ha rinvenuto le microscopiche schegge del premio in vetro di Murano.\n
            Grazie alla tua straordinaria abilità deduttiva, sei riuscito a incrociare gli orari, a decifrare i sistemi protetti e a smascherare l'alibi della colpevole.\n
            Le volanti della polizia sono appena arrivate a Villa Morandi per scortare Silvia in centrale.
            """;
}
