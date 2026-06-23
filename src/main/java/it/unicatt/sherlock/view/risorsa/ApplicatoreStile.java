package it.unicatt.sherlock.view.risorsa;

import javax.swing.*;
import java.awt.*;

/** Colori e font dell'interfaccia */
public final class ApplicatoreStile {

    public static final Color COLORE_SFONDO_SCURO = new Color(30, 30, 30);
    public static final Color COLORE_SFONDO_TESTO = new Color(35, 30, 25);
    public static final Color COLORE_TESTO_CHIARO = new Color(245, 235, 210);
    public static final Color COLORE_PRIMARIO = new Color(150, 35, 30);
    public static final Color COLORE_SECONDARIO = new Color(45, 45, 45);
    public static final Color COLORE_BORDO_ORO = new Color(180, 145, 80);
    public static final Color COLORE_BORDO_ORO_CHIARO = new Color(235, 200, 120);

    public static final Font FONT_TITOLO = new Font(Font.SERIF, Font.BOLD, 44);
    public static final Font FONT_TITOLO_SCHERMATA = new Font(Font.SERIF, Font.BOLD, 28);
    public static final Font FONT_BOTTONE_PRINCIPALE = new Font(Font.SANS_SERIF, Font.BOLD, 18);
    public static final Font FONT_BOTTONE_SECONDARIO = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    public static final Font FONT_TESTO = new Font(Font.SERIF, Font.PLAIN, 17);
    public static final Font FONT_TACCUINO = new Font(Font.MONOSPACED, Font.PLAIN, 13);
    public static final Font FONT_CHECKBOX_MENU = new Font(Font.SANS_SERIF, Font.BOLD, 14);

    public static final Dimension DIMENSIONE_FINESTRA_GIOCO = new Dimension(800, 550);
    public static final Dimension DIMENSIONE_MINIMA_FINESTRA_GIOCO = new Dimension(1200, 780);
    public static final Dimension DIMENSIONE_PANNELLO_TACCUINO = new Dimension(260, 0);
    public static final Dimension DIMENSIONE_POPUP_MESSAGGIO = new Dimension(500, 300);
    public static final Dimension DIMENSIONE_POPUP_REGOLE = new Dimension(520, 360);
    public static final Dimension DIMENSIONE_POPUP_RISULTATO = new Dimension(500, 300);
    public static final int MASSIMA_LARGHEZZA_IMMAGINE_INDIZIO = 500;
    public static final int MASSIMA_ALTEZZA_IMMAGINE_INDIZIO = 500;

    public static final Color COLORE_VITTORIA = new Color(40, 140, 40);
    public static final Color COLORE_TESTO_BOTTONE_PRINCIPALE = new Color(255, 245, 220);
    public static final Color COLORE_TESTO_BOTTONE_SECONDARIO = new Color(245, 230, 190);
    public static final Color COLORE_TESTO_BOTTONE_LOCATION = new Color(60, 25, 10);
    public static final Color COLORE_ENIGMA = new Color(180, 110, 25);
    public static final Color COLORE_BORDO_ENIGMA = new Color(100, 60, 10);
    public static final Color COLORE_ENIGMA_SBLOCCATO = new Color(30, 120, 60);
    public static final Color COLORE_BORDO_ENIGMA_SBLOCCATO = new Color(15, 80, 40);

    public static final Font FONT_BOTTONE_LOCATION = new Font(Font.SANS_SERIF, Font.BOLD, 15);

    /**
     * Sfondo a colore se l'immagine del menu non si carica
     *
     * @return pannello da usare come content pane
     */
    public JPanel creaPannelloSfondoMenuColore() {
        JPanel pannello = new JPanel(new GridBagLayout());
        pannello.setBackground(COLORE_SFONDO_SCURO);
        return pannello;
    }

    /**
     * Titolo grande bianco del menu principale
     *
     * @param etichetta label del titolo
     */
    public void stilizzaTitoloMenu(JLabel etichetta) {
        etichetta.setFont(FONT_TITOLO);
        etichetta.setForeground(Color.WHITE);
    }

    /**
     * Checkbox musica on/off sopra lo sfondo del menu
     *
     * @param checkBoxMusica checkbox da stilizzare
     */
    public void stilizzaCheckBoxAudio(JCheckBox checkBoxMusica) {
        checkBoxMusica.setFont(FONT_CHECKBOX_MENU);
        checkBoxMusica.setForeground(Color.WHITE);
        checkBoxMusica.setOpaque(false);
    }

    /**
     * Stile rosso per azioni importanti
     *
     * @param bottone bottone da modificare
     */
    public void stilizzaBottonePrincipale(JButton bottone) {
        bottone.setFont(FONT_BOTTONE_PRINCIPALE);
        bottone.setFocusPainted(false);
        bottone.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bottone.setBackground(COLORE_PRIMARIO);
        bottone.setForeground(COLORE_TESTO_BOTTONE_PRINCIPALE);
        bottone.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLORE_BORDO_ORO_CHIARO, 2),
                BorderFactory.createEmptyBorder(8, 18, 8, 18)
        ));
    }

    /**
     * Stile grigio per pulsanti secondari
     *
     * @param bottone bottone da modificare
     */
    public void stilizzaBottoneSecondario(JButton bottone) {
        bottone.setFont(FONT_BOTTONE_SECONDARIO);
        bottone.setFocusPainted(false);
        bottone.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bottone.setBackground(COLORE_SECONDARIO);
        bottone.setForeground(COLORE_TESTO_BOTTONE_SECONDARIO);
        bottone.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLORE_BORDO_ORO, 1),
                BorderFactory.createEmptyBorder(6, 16, 6, 16)
        ));
    }

    /**
     * Bottone trasparente con solo il nome della location
     *
     * @param bottone bottone sulla mappa
     */
    public void stilizzaBottoneLocation(JButton bottone) {
        bottone.setFont(FONT_BOTTONE_LOCATION);
        bottone.setFocusPainted(false);
        bottone.setRolloverEnabled(false);
        bottone.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bottone.setOpaque(false);
        bottone.setContentAreaFilled(false);
        bottone.setBorderPainted(false);
        bottone.setForeground(COLORE_TESTO_BOTTONE_LOCATION);
        bottone.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
    }

    /**
     * @param areaTesto testo nei popup con scroll
     */
    public void stilizzaAreaTesto(JTextArea areaTesto) {
        areaTesto.setFont(FONT_TESTO);
        areaTesto.setBackground(COLORE_SFONDO_TESTO);
        areaTesto.setForeground(COLORE_TESTO_CHIARO);
        areaTesto.setCaretColor(COLORE_TESTO_CHIARO);
        areaTesto.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        areaTesto.setEditable(false);
        areaTesto.setLineWrap(true);
        areaTesto.setWrapStyleWord(true);
    }

    /**
     * @param etichetta titolo in alto nella finestra di gioco
     */
    public void stilizzaTitoloSchermata(JLabel etichetta) {
        etichetta.setFont(FONT_TITOLO_SCHERMATA);
        etichetta.setForeground(COLORE_TESTO_CHIARO);
        etichetta.setHorizontalAlignment(SwingConstants.CENTER);
        etichetta.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    /**
     * @param pannello barra superiore con i pulsanti
     */
    public void stilizzaPannelloIntestazione(JPanel pannello) {
        pannello.setBackground(COLORE_SECONDARIO);
        pannello.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, COLORE_BORDO_ORO));
    }

    /**
     * Bottone enigma nei popup indizio: sfondo pieno e testo leggibile
     *
     * @param bottone bottone «Risolvi enigma»
     */
    public void stilizzaBottoneEnigma(JButton bottone) {
        bottone.setFont(FONT_BOTTONE_SECONDARIO);
        bottone.setFocusPainted(false);
        bottone.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bottone.setOpaque(true);
        bottone.setContentAreaFilled(true);
        bottone.setBorderPainted(true);
        bottone.setBackground(COLORE_ENIGMA);
        bottone.setForeground(Color.WHITE);
        bottone.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLORE_BORDO_ENIGMA, 2),
                BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));
    }

    /**
     * Bottone enigma già risolto nei popup indizio
     *
     * @param bottone bottone «Mostra file decifrati»
     */
    public void stilizzaBottoneEnigmaSbloccato(JButton bottone) {
        bottone.setFont(FONT_BOTTONE_SECONDARIO);
        bottone.setFocusPainted(false);
        bottone.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bottone.setOpaque(true);
        bottone.setContentAreaFilled(true);
        bottone.setBorderPainted(true);
        bottone.setBackground(COLORE_ENIGMA_SBLOCCATO);
        bottone.setForeground(Color.WHITE);
        bottone.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLORE_BORDO_ENIGMA_SBLOCCATO, 2),
                BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));
    }

    /**
     * @param pannelloScorrimento area scrollabile del taccuino o dei messaggi
     */
    public void stilizzaScrollPane(JScrollPane pannelloScorrimento) {
        pannelloScorrimento.setBorder(BorderFactory.createLineBorder(COLORE_BORDO_ORO, 2));
        pannelloScorrimento.getVerticalScrollBar().setUnitIncrement(16);
    }

    /**
     * Area note del detective a destra nella finestra di gioco
     *
     * @param areaTaccuino testo modificabile dal giocatore
     */
    public void stilizzaAreaTaccuino(JTextArea areaTaccuino) {
        areaTaccuino.setEditable(true);
        areaTaccuino.setLineWrap(true);
        areaTaccuino.setWrapStyleWord(true);
        areaTaccuino.setFont(FONT_TACCUINO);
        areaTaccuino.setBackground(COLORE_SFONDO_TESTO);
        areaTaccuino.setForeground(COLORE_TESTO_CHIARO);
        areaTaccuino.setCaretColor(COLORE_TESTO_CHIARO);
        areaTaccuino.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    /**
     * Scroll del taccuino con bordo titolato
     *
     * @param pannelloScorrimento scroll che contiene il taccuino
     * @param titolo etichetta del bordo
     */
    public void stilizzaScrollPaneTaccuino(JScrollPane pannelloScorrimento, String titolo) {
        stilizzaScrollPane(pannelloScorrimento);
        pannelloScorrimento.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLORE_BORDO_ORO, 2),
                titolo,
                0, 0, null, COLORE_BORDO_ORO
        ));
    }

    /**
     * Colonna laterale che ospita il taccuino
     *
     * @param pannello pannello destro della finestra di gioco
     */
    public void stilizzaPannelloTaccuino(JPanel pannello) {
        pannello.setLayout(new BorderLayout());
        pannello.setPreferredSize(DIMENSIONE_PANNELLO_TACCUINO);
    }

    /**
     * Pannello principale del popup di ispezione indizio
     *
     * @param pannello contenitore del popup
     */
    public void stilizzaPannelloIspezioneIndizio(JPanel pannello) {
        pannello.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    /**
     * Immagine centrata nel popup dell'indizio
     *
     * @param etichetta label con l'immagine scalata
     */
    public void stilizzaImmagineIndizio(JLabel etichetta) {
        etichetta.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Bottone con sola icona sopra mappa o location
     *
     * @param bottone bottone cliccabile sull'immagine
     */
    public void preparaBottoneIcona(JButton bottone) {
        bottone.setFocusPainted(false);
        bottone.setRolloverEnabled(false);
        bottone.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bottone.setOpaque(false);
        bottone.setContentAreaFilled(false);
        bottone.setBorderPainted(false);
        bottone.setText(null);
    }

    /** Look & Feel uguale su Mac e Windows (Metal), così le icone PNG restano trasparenti */
    public static void applicaLookAndFeelCrossPlatform() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Impossibile applicare il Look & Feel cross-platform: " + e.getMessage());
        }
    }

    /**
     * Titolo grande nei popup di vittoria o sconfitta
     *
     * @param etichetta label del titolo
     * @param vittoria true se il giocatore ha vinto
     */
    public void stilizzaTitoloRisultatoFinale(JLabel etichetta, boolean vittoria) {
        etichetta.setFont(FONT_TITOLO_SCHERMATA);
        if (vittoria) {
            etichetta.setForeground(COLORE_VITTORIA);
        } else {
            etichetta.setForeground(COLORE_PRIMARIO);
        }
        etichetta.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Contenitore del popup di vittoria o sconfitta
     *
     * @param pannello pannello del messaggio finale
     */
    public void stilizzaPannelloRisultatoFinale(JPanel pannello) {
        pannello.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}
