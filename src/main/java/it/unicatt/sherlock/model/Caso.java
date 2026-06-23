package it.unicatt.sherlock.model;

import it.unicatt.sherlock.model.personaggio.Personaggio;

/**
 * Caso investigativo
 */
public abstract class Caso {
    private final String titolo;
    private final String descrizione;
    private Personaggio colpevole;
    private String soluzione;
    private final Mappa mappa;

    /**
     * Crea un nuovo caso
     *
     * @param titolo nome del caso
     * @param descrizione testo mostrato all'inizio della partita
     */
    public Caso(String titolo, String descrizione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        mappa = new Mappa();
    }

    /** @return spiegazione finale se il giocatore indovina */
    public String getSoluzione() {
        return soluzione;
    }

    /**
     * Imposta il testo di vittoria
     *
     * @param soluzione ricostruzione del delitto
     */
    protected void setSoluzione(String soluzione) {
        this.soluzione = soluzione;
    }

    /** @return mappa con le location del caso */
    public Mappa getMappa() {
        return mappa;
    }

    /**
     * Costruisce location, indizi e personaggi del caso
     *
     * @param fabbrica oggetto che crea gli elementi di gioco
     */
    public abstract void preparaCaso(FabbricaGioco fabbrica);

    /** @return titolo del caso */
    public String getTitolo() {
        return titolo;
    }

    /** @return descrizione del caso */
    public String getDescrizione() {
        return descrizione;
    }

    /** Usato da Partita per verificare l'accusa */
    Personaggio getColpevole() {
        return colpevole;
    }

    /**
     * Assegna l'assassino
     *
     * @param colpevole sospettato colpevole
     */
    protected void setColpevole(Personaggio colpevole) {
        this.colpevole = colpevole;
    }
}
