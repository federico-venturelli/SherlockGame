package it.unicatt.sherlock.main;

import it.unicatt.sherlock.controller.ApplicazioneSherlock;
import it.unicatt.sherlock.view.risorsa.ApplicatoreStile;
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
                ApplicatoreStile.applicaLookAndFeelCrossPlatform();
                ApplicazioneSherlock applicazione = new ApplicazioneSherlock();
                applicazione.apriMenu();
            }
        });
    }
}
