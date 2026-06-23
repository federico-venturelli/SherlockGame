package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.controller.FacciataSherlock;
import it.unicatt.sherlock.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Pulsante "< Mappa" per uscire dalla location */
public class TornaAllaMappaListener implements ActionListener {
    private final FacciataSherlock facciata;
    private final MainFrame finestra;

    /**
     * @param facciata collegamento col modello
     * @param finestra finestra di gioco da aggiornare
     */
    public TornaAllaMappaListener(FacciataSherlock facciata, MainFrame finestra) {
        this.facciata = facciata;
        this.finestra = finestra;
    }

    /** Torna alla planimetria della villa */
    @Override
    public void actionPerformed(ActionEvent evento) {
        facciata.tornaAllaMappa();
        finestra.aggiornaSchermo();
    }
}
