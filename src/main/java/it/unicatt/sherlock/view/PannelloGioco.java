package it.unicatt.sherlock.view;

import it.unicatt.sherlock.view.risorsa.ApplicatoreStile;

import javax.swing.*;
import java.awt.*;

/** Area centrale dove disegniamo mappa e location */
public class PannelloGioco extends JPanel {
    public static final int LARGHEZZA_FISSATA = 800;
    public static final int ALTEZZA_FISSATA = 600;

    private Image immagineSfondo;

    /** Layout assoluto per posizionare i bottoni sopra l'immagine */
    public PannelloGioco() {
        setLayout(null);
    }

    /**
     * @param nuovaImmagine sfondo da mostrare
     */
    public void setImmagineSfondo(Image nuovaImmagine) {
        immagineSfondo = nuovaImmagine;
    }

    /** Sfondo scuro e immagine centrata e scalata */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int larghezzaAttuale = getWidth();
        int altezzaAttuale = getHeight();

        g.setColor(ApplicatoreStile.COLORE_SFONDO_SCURO);
        g.fillRect(0, 0, larghezzaAttuale, altezzaAttuale);

        if (immagineSfondo != null) {
            double scale = getScale();
            int offsetX = getOffsetX();
            int offsetY = getOffsetY();

            int larghezzaScalata = (int) (LARGHEZZA_FISSATA * scale);
            int altezzaScalata = (int) (ALTEZZA_FISSATA * scale);

            g.drawImage(immagineSfondo, offsetX, offsetY, larghezzaScalata, altezzaScalata, this);
        }
    }

    /** @return quanto rimpicciolire l'immagine rispetto al pannello */
    public double getScale() {
        return Math.min((double) getWidth() / LARGHEZZA_FISSATA, (double) getHeight() / ALTEZZA_FISSATA);
    }

    /** @return margine a sinistra per centrare l'immagine */
    public int getOffsetX() {
        int larghezzaScalata = (int) (LARGHEZZA_FISSATA * getScale());
        return (getWidth() - larghezzaScalata) / 2;
    }

    /** @return margine in alto per centrare l'immagine */
    public int getOffsetY() {
        int altezzaScalata = (int) (ALTEZZA_FISSATA * getScale());
        return (getHeight() - altezzaScalata) / 2;
    }
}
