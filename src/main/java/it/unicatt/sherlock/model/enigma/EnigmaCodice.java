package it.unicatt.sherlock.model.enigma;

/** Enigma che si sblocca digitando un codice esatto */
public final class EnigmaCodice extends Enigma {
    private final String codiceCorretto;
    private final String testoDaSbloccare;
    private final String testoEnigma;

    /**
     * @param codiceCorretto codice giusto
     * @param testoDaSbloccare messaggio mostrato dopo lo sblocco
     * @param testoEnigma domanda per il giocatore
     */
    public EnigmaCodice(String codiceCorretto, String testoDaSbloccare, String testoEnigma) {
        this.codiceCorretto = codiceCorretto;
        this.testoDaSbloccare = testoDaSbloccare;
        this.testoEnigma = testoEnigma;
    }

    /** Confronta il codice inserito con quello corretto */
    @Override
    public boolean tentativoRisoluzione(String input) {
        boolean esito = false;
        if (input != null && input.equals(codiceCorretto)) {
            setRisolto(true);
            esito = true;
        }
        return esito;
    }

    /** @return domanda mostrata nel popup */
    @Override
    public String getTestoRichiesta() {
        return testoEnigma;
    }

    /** @return testo sbloccato dopo il codice giusto */
    @Override
    public String getRisultatoPositivo() {
        return testoDaSbloccare;
    }
}
