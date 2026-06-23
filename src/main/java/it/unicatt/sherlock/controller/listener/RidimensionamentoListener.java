package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.view.MainFrame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/** Ricalcola i bottoni quando allarghi la finestra */
public class RidimensionamentoListener extends ComponentAdapter {
    private final MainFrame vista;

    /**
     * @param vista finestra da ridisegnare
     */
    public RidimensionamentoListener(MainFrame vista) {
        this.vista = vista;
    }

    /** Riallinea i bottoni quando la finestra cambia dimensione */
    @Override
    public void componentResized(ComponentEvent evento) {
        vista.aggiornaSchermo();
    }
}
