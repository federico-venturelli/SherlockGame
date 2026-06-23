package it.unicatt.sherlock.model;

import it.unicatt.sherlock.model.personaggio.Personaggio;

/** Tiene traccia di dove sei e di quale caso stai giocando */
public class Partita {
    private Location locationCorrente;
    private Caso casoAttuale;

    /** Partita senza location selezionata */
    public Partita() {
        locationCorrente = null;
    }

    /**
     * Inizia un nuovo caso
     *
     * @param caso caso da giocare
     */
    public void avviaNuovoCaso(Caso caso) {
        casoAttuale = caso;
        locationCorrente = null;
    }

    /**
     * Entra in una location
     *
     * @param location location scelta dal giocatore
     */
    public void cambiaLocation(Location location) {
        locationCorrente = location;
    }

    /** Esce dalla location e torna alla planimetria */
    public void tornaAllaMappa() {
        locationCorrente = null;
    }

    /** @return mappa del caso, null se non hai ancora iniziato */
    public Mappa getMappa() {
        Mappa mappa = null;
        if (casoAttuale != null) {
            mappa = casoAttuale.getMappa();
        }
        return mappa;
    }

    /**
     * Controlla se l'accusa è giusta
     *
     * @param colpevoleScelto sospettato scelto dal giocatore
     * @return true se hai beccato il colpevole
     */
    public boolean esprimiAccusa(Personaggio colpevoleScelto) {
        boolean esito = false;
        if (casoAttuale != null) {
            esito = colpevoleScelto.equals(casoAttuale.getColpevole());
        }
        return esito;
    }

    /** @return location attuale, null se sei sulla mappa */
    public Location getLocationCorrente() {
        return locationCorrente;
    }

    /** @return caso in corso */
    public Caso getCasoAttuale() {
        return casoAttuale;
    }
}
