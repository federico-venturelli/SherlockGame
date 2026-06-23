package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.controller.CoordinatoreAzioni;
import it.unicatt.sherlock.controller.FacciataSherlock;
import it.unicatt.sherlock.model.Indizio;
import it.unicatt.sherlock.model.enigma.Enigma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Bottone "Risolvi enigma" nel popup di un indizio */
public class RisolviEnigmaListener implements ActionListener {
    private final Indizio indizio;
    private final Enigma enigma;
    private final FacciataSherlock facciata;
    private final Component finestra;
    private final CoordinatoreAzioni coordinatore;

    /**
     * @param indizio indizio collegato
     * @param enigma enigma da risolvere
     * @param facciata collegamento col modello
     * @param finestra finestra su cui aprire i popup dell'enigma
     * @param coordinatore coordina popup e verifica sul modello
     */
    public RisolviEnigmaListener(Indizio indizio, Enigma enigma, FacciataSherlock facciata, Component finestra, CoordinatoreAzioni coordinatore) {
        this.indizio = indizio;
        this.enigma = enigma;
        this.facciata = facciata;
        this.finestra = finestra;
        this.coordinatore = coordinatore;
    }

    /** Chiede il codice o mostra di nuovo il contenuto sbloccato */
    @Override
    public void actionPerformed(ActionEvent evento) {
        JButton bottoneEnigma = (JButton) evento.getSource();
        coordinatore.gestisciEnigma(indizio, enigma, facciata, finestra, bottoneEnigma);
    }
}
