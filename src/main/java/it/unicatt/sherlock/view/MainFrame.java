package it.unicatt.sherlock.view;

import it.unicatt.sherlock.controller.ApplicazioneSherlock;
import it.unicatt.sherlock.controller.FacciataSherlock;
import it.unicatt.sherlock.controller.listener.*;
import it.unicatt.sherlock.model.Indizio;
import it.unicatt.sherlock.model.Location;
import it.unicatt.sherlock.model.personaggio.Personaggio;
import it.unicatt.sherlock.view.risorsa.ApplicatoreStile;
import it.unicatt.sherlock.view.risorsa.CaricatoreImmagini;
import it.unicatt.sherlock.view.risorsa.CostantiRisorse;
import it.unicatt.sherlock.view.risorsa.CostantiTesti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Schermata di gioco con mappa, location e taccuino
 */
public class MainFrame extends JFrame {
    private final FacciataSherlock facciata;
    private final ApplicazioneSherlock applicazione;
    private final ApplicatoreStile stile;
    private final CaricatoreImmagini caricatore;
    private final PresentatoreDialoghi presentatore;
    private final RegistroLayout registroLayout;

    private PannelloGioco pannelloCentrale;
    private JPanel pannelloNord;
    private JLabel etichettaTitolo;

    /**
     * Costruisce la finestra e disegna la prima schermata
     *
     * @param facciata collegamento col modello
     * @param applicazione avvio e utilità condivise
     */
    public MainFrame(FacciataSherlock facciata, ApplicazioneSherlock applicazione) {
        this.facciata = facciata;
        this.applicazione = applicazione;
        stile = applicazione.getStile();
        caricatore = applicazione.getCaricatoreImmagini();
        presentatore = applicazione.getPresentatore();
        registroLayout = new RegistroLayoutCasoVilla();

        configuraFinestraBase();
        inizializzaPannelloNord();
        inizializzaPannelloCentrale();
        inizializzaTaccuino();
        aggiornaSchermo();
    }

    /** Imposta titolo, dimensioni e layout della finestra */
    private void configuraFinestraBase() {
        setTitle(CostantiTesti.TITOLO_FINESTRA);
        setSize(ApplicatoreStile.DIMENSIONE_FINESTRA_GIOCO);
        setMinimumSize(ApplicatoreStile.DIMENSIONE_MINIMA_FINESTRA_GIOCO);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    /** Crea la barra in alto con titolo e pulsanti */
    private void inizializzaPannelloNord() {
        pannelloNord = new JPanel();
        pannelloNord.setLayout(new BorderLayout(10, 10));
        stile.stilizzaPannelloIntestazione(pannelloNord);

        etichettaTitolo = new JLabel("", SwingConstants.CENTER);
        stile.stilizzaTitoloSchermata(etichettaTitolo);

        add(pannelloNord, BorderLayout.NORTH);
    }

    /** Crea il pannello centrale con l'immagine di gioco */
    private void inizializzaPannelloCentrale() {
        pannelloCentrale = new PannelloGioco();
        pannelloCentrale.addComponentListener(new RidimensionamentoListener(this));
        add(pannelloCentrale, BorderLayout.CENTER);
    }

    /** Aggiunge il taccuino modificabile a destra */
    private void inizializzaTaccuino() {
        JPanel pannelloDestro = new JPanel();
        stile.stilizzaPannelloTaccuino(pannelloDestro);

        JTextArea areaTaccuino = new JTextArea();
        stile.stilizzaAreaTaccuino(areaTaccuino);

        JScrollPane pannelloScorrimento = new JScrollPane(areaTaccuino);
        stile.stilizzaScrollPaneTaccuino(pannelloScorrimento, CostantiTesti.TITOLO_TACCUINO);
        pannelloDestro.add(pannelloScorrimento, BorderLayout.CENTER);

        add(pannelloDestro, BorderLayout.EAST);
    }

    /** Ridisegna barra, mappa o location in base allo stato della partita */
    public void aggiornaSchermo() {
        pannelloNord.removeAll();
        pannelloCentrale.removeAll();

        configuraBarraSuperiore();

        Location locationCorrente = facciata.getLocationCorrente();
        if (locationCorrente == null) {
            disegnaMappa();
        } else {
            disegnaInternoLocation(locationCorrente);
        }

        pannelloNord.revalidate();
        pannelloNord.repaint();
        pannelloCentrale.revalidate();
        pannelloCentrale.repaint();
    }

    /** Mette titolo, «Risolvi il caso!» e eventuale «< Mappa» */
    private void configuraBarraSuperiore() {
        Location locationCorrente = facciata.getLocationCorrente();

        JButton bottoneAccusa = new JButton(CostantiTesti.BOTTONE_RISOLVI_CASO);
        stile.stilizzaBottonePrincipale(bottoneAccusa);
        bottoneAccusa.addActionListener(new AccusaListener(this, facciata, applicazione.getCoordinatore()));
        pannelloNord.add(bottoneAccusa, BorderLayout.EAST);

        if (locationCorrente == null) {
            etichettaTitolo.setText(CostantiTesti.TITOLO_MAPPA);
        } else {
            etichettaTitolo.setText(CostantiTesti.titoloLocationCorrente(locationCorrente.getNome()));

            JButton bottoneIndietro = new JButton(CostantiTesti.BOTTONE_TORNA_MAPPA);
            stile.stilizzaBottoneSecondario(bottoneIndietro);
            bottoneIndietro.addActionListener(new TornaAllaMappaListener(facciata, this));
            pannelloNord.add(bottoneIndietro, BorderLayout.WEST);
        }

        pannelloNord.add(etichettaTitolo, BorderLayout.CENTER);
    }

    /** Mostra la planimetria con i bottoni delle location */
    private void disegnaMappa() {
        impostaSfondo(CostantiRisorse.MAPPA);

        for (Location location : facciata.getMappa().getTutteLeLocation()) {
            JButton bottone = new JButton(location.getNome());
            stile.stilizzaBottoneLocation(bottone);
            Rectangle rettangolo = registroLayout.getPosizioneLocation(location.getNome());
            posizionaBottone(bottone, new CambioLocationListener(facciata, location, this), rettangolo, null);
        }
    }

    /** Mostra lo sfondo della location con indizi e personaggi cliccabili */
    private void disegnaInternoLocation(Location location) {
        impostaSfondo(CostantiRisorse.immagineLocation(location.getNome()));

        for (Indizio indizio : location.getIndizi()) {
            JButton bottone = new JButton();
            Rectangle rettangolo = registroLayout.getPosizioneElemento(indizio.getNome());
            ActionListener listener = new EsaminaIndizioListener(facciata, presentatore, applicazione.getCoordinatore(), this, indizio);
            posizionaBottone(bottone, listener, rettangolo, CostantiRisorse.immagineIndizio(indizio.getNome()));
        }

        for (Personaggio personaggio : location.getPersonaggi()) {
            JButton bottone = new JButton();
            Rectangle rettangolo = registroLayout.getPosizioneElemento(personaggio.getNome());
            ActionListener listener = new EsaminaPersonaggioListener(presentatore, this, personaggio);
            posizionaBottone(bottone, listener, rettangolo, CostantiRisorse.immaginePersonaggio(personaggio.getNome()));
        }
    }

    /** Carica l'immagine di sfondo del pannello centrale */
    private void impostaSfondo(String percorso) {
        ImageIcon icona = caricatore.caricaIcona(percorso);
        if (icona != null) {
            pannelloCentrale.setImmagineSfondo(icona.getImage());
        } else {
            pannelloCentrale.setImmagineSfondo(null);
        }
    }

    /**
     * Posiziona un bottone sul pannello; con percorsoIcona mostra l'immagine, altrimenti il testo
     *
     * @param percorsoIcona path PNG, oppure null per solo testo
     */
    private void posizionaBottone(JButton bottone, ActionListener listener, Rectangle rettangolo, String percorsoIcona) {
        if (rettangolo != null) {
            bottone.addActionListener(listener);

            double scale = pannelloCentrale.getScale();
            int offsetX = pannelloCentrale.getOffsetX();
            int offsetY = pannelloCentrale.getOffsetY();

            int coordinataX = (int) (rettangolo.x * scale) + offsetX;
            int coordinataY = (int) (rettangolo.y * scale) + offsetY;
            int larghezzaFisica = (int) (rettangolo.width * scale);
            int altezzaFisica = (int) (rettangolo.height * scale);

            bottone.setBounds(coordinataX, coordinataY, larghezzaFisica, altezzaFisica);

            if (percorsoIcona != null) {
                stile.preparaBottoneIcona(bottone);
                ImageIcon icona = caricatore.caricaIconaScalata(percorsoIcona, larghezzaFisica, altezzaFisica);
                if (icona != null) {
                    bottone.setIcon(icona);
                }
            }

            pannelloCentrale.add(bottone);
        }
    }
}
