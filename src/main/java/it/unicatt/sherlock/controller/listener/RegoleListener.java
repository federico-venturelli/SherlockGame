package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.view.MenuAvvio;
import it.unicatt.sherlock.view.PresentatoreDialoghi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Pulsante "Come si gioca" del menu */
public class RegoleListener implements ActionListener {
    private final MenuAvvio menuAvvio;
    private final PresentatoreDialoghi presentatore;

    /**
     * @param menuAvvio finestra del menu
     * @param presentatore mostra le regole
     */
    public RegoleListener(MenuAvvio menuAvvio, PresentatoreDialoghi presentatore) {
        this.menuAvvio = menuAvvio;
        this.presentatore = presentatore;
    }

    /** Apre il popup con le regole di gioco */
    @Override
    public void actionPerformed(ActionEvent evento) {
        presentatore.mostraRegole(menuAvvio);
    }
}
