package it.unicatt.sherlock.controller.listener;

import it.unicatt.sherlock.audio.GestoreAudio;
import it.unicatt.sherlock.view.risorsa.CostantiRisorse;
import it.unicatt.sherlock.view.risorsa.CostantiTesti;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Checkbox musica on/off nel menu */
public class InterruttoreAudioListener implements ActionListener {
    private final JCheckBox checkBoxMusica;

    /**
     * @param checkBoxMusica checkbox della musica
     */
    public InterruttoreAudioListener(JCheckBox checkBoxMusica) {
        this.checkBoxMusica = checkBoxMusica;
        aggiornaGraficaTesto();
    }

    /** Accende o spegne la musica e aggiorna l'etichetta */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (checkBoxMusica.isSelected()) {
            GestoreAudio.getIstanza().avviaMusica(CostantiRisorse.TRACCIA_AUDIO);
        } else {
            GestoreAudio.getIstanza().fermaMusica();
        }
        aggiornaGraficaTesto();
    }

    /** Mostra "Musica: ON" o "Musica: OFF" sulla checkbox */
    private void aggiornaGraficaTesto() {
        if (checkBoxMusica.isSelected()) {
            checkBoxMusica.setText(CostantiTesti.MUSICA_ON);
        } else {
            checkBoxMusica.setText(CostantiTesti.MUSICA_OFF);
        }
    }
}
