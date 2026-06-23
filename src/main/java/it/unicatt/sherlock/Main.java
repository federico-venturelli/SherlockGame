package it.unicatt.sherlock;

import it.unicatt.sherlock.controller.ApplicazioneSherlock;
import javax.swing.*;

/** Avvio del programma */
public class Main {
    /**
     * Avvia l'applicazione sul thread della GUI
     *
     * @param args non usati
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            /** Apre il menu iniziale */
            @Override
            public void run() {
                ApplicazioneSherlock applicazione = new ApplicazioneSherlock();
                applicazione.apriMenu();
            }
        });
    }
}
