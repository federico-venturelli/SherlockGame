package it.unicatt.sherlock.view;

import it.unicatt.sherlock.audio.GestoreAudio;
import it.unicatt.sherlock.controller.ApplicazioneSherlock;
import it.unicatt.sherlock.controller.listener.AvviaIndagineListener;
import it.unicatt.sherlock.controller.listener.InterruttoreAudioListener;
import it.unicatt.sherlock.controller.listener.RegoleListener;
import it.unicatt.sherlock.view.risorsa.ApplicatoreStile;
import it.unicatt.sherlock.view.risorsa.CostantiRisorse;
import it.unicatt.sherlock.view.risorsa.CostantiTesti;

import javax.swing.*;
import java.awt.*;

/**
 * Schermata iniziale con pulsanti e musica
 */
public class MenuAvvio extends JFrame {
    private final ApplicazioneSherlock applicazione;
    private final ApplicatoreStile stile;

    /**
     * @param applicazione oggetto che avvia le partite
     */
    public MenuAvvio(ApplicazioneSherlock applicazione) {
        this.applicazione = applicazione;
        this.stile = applicazione.getStile();

        setTitle(CostantiTesti.TITOLO_FINESTRA);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GestoreAudio.getIstanza().avviaMusica(CostantiRisorse.TRACCIA_AUDIO);
        inizializzaInterfaccia();
    }

    /** Costruisce sfondo, titolo e pulsanti del menu */
    private void inizializzaInterfaccia() {
        JPanel pannelloControlli = new JPanel(new GridLayout(4, 1, 0, 15));
        pannelloControlli.setOpaque(false);

        JLabel labelTitolo = new JLabel(CostantiTesti.TITOLO_MENU, SwingConstants.CENTER);
        stile.stilizzaTitoloMenu(labelTitolo);
        pannelloControlli.add(labelTitolo);

        JButton bottoneGioca = new JButton(CostantiTesti.BOTTONE_AVVIA_INDAGINE);
        stile.stilizzaBottonePrincipale(bottoneGioca);
        bottoneGioca.addActionListener(new AvviaIndagineListener(this, applicazione));
        pannelloControlli.add(bottoneGioca);

        JButton bottoneRegole = new JButton(CostantiTesti.BOTTONE_COME_SI_GIOCA);
        stile.stilizzaBottoneSecondario(bottoneRegole);
        bottoneRegole.addActionListener(new RegoleListener(this, applicazione.getPresentatore()));
        pannelloControlli.add(bottoneRegole);

        JCheckBox checkBoxMusica = new JCheckBox();
        stile.stilizzaCheckBoxAudio(checkBoxMusica);
        checkBoxMusica.setSelected(GestoreAudio.getIstanza().isMusicaAttiva());
        checkBoxMusica.addActionListener(new InterruttoreAudioListener(checkBoxMusica));
        pannelloControlli.add(checkBoxMusica);

        ImageIcon sfondo = applicazione.getCaricatoreImmagini().caricaIcona(CostantiRisorse.SFONDO_MENU);
        if (sfondo != null) {
            JLabel etichettaSfondo = new JLabel(sfondo);
            etichettaSfondo.setLayout(new GridBagLayout());
            etichettaSfondo.add(pannelloControlli);
            setContentPane(etichettaSfondo);
        } else {
            JPanel pannelloSfondo = stile.creaPannelloSfondoMenuColore();
            pannelloSfondo.add(pannelloControlli);
            setContentPane(pannelloSfondo);
        }
    }
}
