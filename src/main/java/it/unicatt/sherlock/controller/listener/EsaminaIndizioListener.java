package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.controller.CoordinatoreAzioni;
import it.unicatt.sherlock.controller.FacciataSherlock;
import it.unicatt.sherlock.model.Indizio;
import it.unicatt.sherlock.model.enigma.Enigma;
import it.unicatt.sherlock.view.MainFrame;
import it.unicatt.sherlock.view.PresentatoreDialoghi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Click su un indizio nella location */
public class EsaminaIndizioListener implements ActionListener {
    private final FacciataSherlock facciata;
    private final PresentatoreDialoghi presentatore;
    private final CoordinatoreAzioni coordinatore;
    private final MainFrame finestra;
    private final Indizio indizio;

    /**
     * @param facciata collegamento col modello
     * @param presentatore apre il popup dell'indizio
     * @param coordinatore coordina la risoluzione dell'enigma
     * @param finestra finestra di gioco
     * @param indizio indizio cliccato
     */
    public EsaminaIndizioListener(FacciataSherlock facciata, PresentatoreDialoghi presentatore, CoordinatoreAzioni coordinatore, MainFrame finestra, Indizio indizio) {
        this.facciata = facciata;
        this.presentatore = presentatore;
        this.coordinatore = coordinatore;
        this.finestra = finestra;
        this.indizio = indizio;
    }

    /** Apre il popup dell'indizio cliccato */
    @Override
    public void actionPerformed(ActionEvent evento) {
        ActionListener listenerEnigma = null;
        Enigma enigma = indizio.getEnigma();
        if (enigma != null) {
            listenerEnigma = new RisolviEnigmaListener(indizio, enigma, facciata, finestra, coordinatore);
        }
        presentatore.mostraIndizio(finestra, indizio, listenerEnigma);
    }
}
