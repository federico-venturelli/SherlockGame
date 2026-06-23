package it.unicatt.sherlock.controller;

import it.unicatt.sherlock.model.Caso;
import it.unicatt.sherlock.model.FabbricaGioco;
import it.unicatt.sherlock.view.MainFrame;
import it.unicatt.sherlock.view.MenuAvvio;
import it.unicatt.sherlock.view.PresentatoreDialoghi;
import it.unicatt.sherlock.view.risorsa.ApplicatoreStile;
import it.unicatt.sherlock.view.risorsa.CaricatoreImmagini;

import javax.swing.*;

/** Avvia il gioco e tiene insieme i pezzi principali */
public class ApplicazioneSherlock {
    private final FabbricaGioco fabbrica;
    private final ApplicatoreStile stile;
    private final CaricatoreImmagini caricatore;
    private final PresentatoreDialoghi presentatore;
    private final CoordinatoreAzioni coordinatore;

    /** Crea factory, stile, caricatore immagini e presentatore dialoghi */
    public ApplicazioneSherlock() {
        fabbrica = new FabbricaGioco();
        stile = new ApplicatoreStile();
        caricatore = new CaricatoreImmagini();
        presentatore = new PresentatoreDialoghi(stile, caricatore);
        coordinatore = new CoordinatoreAzioni(presentatore, this);
    }

    /** @return stili usati nell'interfaccia */
    public ApplicatoreStile getStile() {
        return stile;
    }

    /** @return caricatore immagini */
    public CaricatoreImmagini getCaricatoreImmagini() {
        return caricatore;
    }

    /** @return gestore dei popup di gioco */
    public PresentatoreDialoghi getPresentatore() {
        return presentatore;
    }

    /** @return coordina le azioni di gioco più articolate */
    public CoordinatoreAzioni getCoordinatore() {
        return coordinatore;
    }

    /** Crea il caso, apre la finestra di gioco e mostra l'intro */
    public void avviaPartita() {
        Caso caso = fabbrica.creaCaso();
        FacciataSherlock facciata = new FacciataSherlock();
        facciata.avviaNuovoCaso(caso);

        MainFrame finestraGioco = new MainFrame(facciata, this);
        finestraGioco.setVisible(true);
        presentatore.mostraIntroduzione(finestraGioco, caso);
    }

    /**
     * Chiude la partita e riapre il menu
     *
     * @param finestraCorrente finestra da chiudere
     */
    public void tornaAlMenu(JFrame finestraCorrente) {
        finestraCorrente.dispose();
        SwingUtilities.invokeLater(new Runnable() {
            /** Riapre il menu dopo la chiusura della partita */
            @Override
            public void run() {
                ApplicazioneSherlock.this.apriMenu();
            }
        });
    }

    /** Apre il menu principale */
    public void apriMenu() {
        MenuAvvio menu = new MenuAvvio(this);
        menu.setVisible(true);
    }
}
