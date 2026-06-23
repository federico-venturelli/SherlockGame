package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.model.personaggio.Personaggio;
import it.unicatt.sherlock.view.MainFrame;
import it.unicatt.sherlock.view.PresentatoreDialoghi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Click su un personaggio nella location */
public class EsaminaPersonaggioListener implements ActionListener {
    private final PresentatoreDialoghi presentatore;
    private final MainFrame vista;
    private final Personaggio personaggio;

    /**
     * @param presentatore apre il dialogo
     * @param vista finestra di gioco
     * @param personaggio chi stai interrogando
     */
    public EsaminaPersonaggioListener(PresentatoreDialoghi presentatore, MainFrame vista, Personaggio personaggio) {
        this.presentatore = presentatore;
        this.vista = vista;
        this.personaggio = personaggio;
    }

    /** Apre il dialogo del personaggio cliccato */
    @Override
    public void actionPerformed(ActionEvent evento) {
        presentatore.mostraPersonaggio(vista, personaggio);
    }
}
