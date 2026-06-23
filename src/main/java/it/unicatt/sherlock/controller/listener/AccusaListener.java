package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.controller.CoordinatoreAzioni;
import it.unicatt.sherlock.controller.FacciataSherlock;
import it.unicatt.sherlock.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Gestisce il pulsante "Risolvi il caso!" */
public class AccusaListener implements ActionListener {
    private final MainFrame finestra;
    private final FacciataSherlock facciata;
    private final CoordinatoreAzioni coordinatore;

    /**
     * @param finestra finestra di gioco
     * @param facciata collegamento col modello
     * @param coordinatore coordina popup e ritorno al menu
     */
    public AccusaListener(MainFrame finestra, FacciataSherlock facciata, CoordinatoreAzioni coordinatore) {
        this.finestra = finestra;
        this.facciata = facciata;
        this.coordinatore = coordinatore;
    }

    /** Gestisce il click su "Risolvi il caso!" */
    @Override
    public void actionPerformed(ActionEvent evento) {
        coordinatore.gestisciAccusa(finestra, facciata);
    }
}
