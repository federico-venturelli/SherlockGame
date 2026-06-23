package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.controller.FacciataSherlock;
import it.unicatt.sherlock.model.Location;
import it.unicatt.sherlock.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Click su una location della mappa */
public class CambioLocationListener implements ActionListener {
    private final FacciataSherlock facciata;
    private final Location destinazione;
    private final MainFrame finestra;

    /**
     * @param facciata collegamento col modello
     * @param destinazione location dove entrare
     * @param finestra finestra di gioco da aggiornare
     */
    public CambioLocationListener(FacciataSherlock facciata, Location destinazione, MainFrame finestra) {
        this.facciata = facciata;
        this.destinazione = destinazione;
        this.finestra = finestra;
    }

    /** Entra nella location scelta sulla mappa */
    @Override
    public void actionPerformed(ActionEvent evento) {
        facciata.cambiaLocation(destinazione);
        finestra.aggiornaSchermo();
    }
}
