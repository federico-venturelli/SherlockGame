package it.unicatt.sherlock.controller;

import it.unicatt.sherlock.model.Caso;
import it.unicatt.sherlock.model.Indizio;
import it.unicatt.sherlock.model.Location;
import it.unicatt.sherlock.model.Mappa;
import it.unicatt.sherlock.model.Partita;
import it.unicatt.sherlock.model.personaggio.Personaggio;

import java.util.List;

/** Punto unico tra interfaccia e modello */
public class FacciataSherlock {
    private final Partita partita;

    /** Crea una partita vuota pronta per un nuovo caso */
    public FacciataSherlock() {
        partita = new Partita();
    }

    /**
     * Carica un nuovo caso
     *
     * @param caso caso da giocare
     */
    public void avviaNuovoCaso(Caso caso) {
        partita.avviaNuovoCaso(caso);
    }

    /**
     * Sposta il giocatore in un'altra location
     *
     * @param location location di destinazione
     */
    public void cambiaLocation(Location location) {
        partita.cambiaLocation(location);
    }

    /** Riporta il giocatore sulla mappa generale */
    public void tornaAllaMappa() {
        partita.tornaAllaMappa();
    }

    /**
     * Verifica il codice inserito per un enigma
     *
     * @param indizio indizio con enigma
     * @param tentativo codice provato dal giocatore
     * @return true se il codice è giusto
     */
    public boolean risolviEnigma(Indizio indizio, String tentativo) {
        return indizio.risolviEnigma(tentativo);
    }

    /**
     * Controlla l'accusa finale
     *
     * @param colpevole sospettato scelto
     * @return true se ha indovinato
     */
    public boolean tentaAccusa(Personaggio colpevole) {
        return partita.esprimiAccusa(colpevole);
    }

    /** @return location attuale, null sulla mappa */
    public Location getLocationCorrente() {
        return partita.getLocationCorrente();
    }

    /** @return mappa del caso */
    public Mappa getMappa() {
        return partita.getMappa();
    }

    /** @return caso in corso */
    public Caso getCasoAttuale() {
        return partita.getCasoAttuale();
    }

    /** @return tutti i sospettati della villa */
    public List<Personaggio> getTuttiISospettati() {
        Mappa mappa = partita.getMappa();
        List<Personaggio> sospettati = List.of();
        if (mappa != null) {
            sospettati = mappa.getTuttiIPersonaggi();
        }
        return sospettati;
    }
}
