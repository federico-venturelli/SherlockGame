package it.unicatt.sherlock.model.enigma;

/** Enigma da risolvere per sbloccare informazioni */
public abstract class Enigma {
    private boolean risolto;

    /** Enigma non ancora risolto all'avvio */
    protected Enigma() {
        risolto = false;
    }

    /**
     * @param input risposta del giocatore
     * @return true se la risposta è corretta
     */
    public abstract boolean tentativoRisoluzione(String input);

    /** @return testo della finestra di input */
    public abstract String getTestoRichiesta();

    /** @return contenuto sbloccato */
    public abstract String getRisultatoPositivo();

    /** @return true se l'enigma è già stato risolto */
    public boolean isRisolto() {
        return risolto;
    }

    /**
     * @param risolto nuovo stato dell'enigma
     */
    protected void setRisolto(boolean risolto) {
        this.risolto = risolto;
    }
}
