package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.controller.ApplicazioneSherlock;
import it.unicatt.sherlock.view.MenuAvvio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Pulsante "Avvia Indagine" del menu */
public class AvviaIndagineListener implements ActionListener {
    private final MenuAvvio menuAvvio;
    private final ApplicazioneSherlock applicazione;

    /**
     * @param menuAvvio menu da chiudere
     * @param applicazione avvia la partita
     */
    public AvviaIndagineListener(MenuAvvio menuAvvio, ApplicazioneSherlock applicazione) {
        this.menuAvvio = menuAvvio;
        this.applicazione = applicazione;
    }

    /** Chiude il menu e avvia una nuova partita */
    @Override
    public void actionPerformed(ActionEvent evento) {
        applicazione.avviaPartita();
        menuAvvio.dispose();
    }
}
