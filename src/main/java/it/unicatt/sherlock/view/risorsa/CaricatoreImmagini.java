package it.unicatt.sherlock.view.risorsa;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/** Carica le immagini dal classpath */
public final class CaricatoreImmagini {

    /**
     * @param percorso path dell'immagine, es. /img/mappa.png
     * @return icona caricata, null se il file non c'è o non si legge
     */
    public ImageIcon caricaIcona(String percorso) {
        ImageIcon icona = null;
        try {
            InputStream stream = CaricatoreImmagini.class.getResourceAsStream(percorso);
            if (stream == null) {
                System.out.println("Immagine non trovata: " + percorso);
            } else {
                try (InputStream input = stream) {
                    BufferedImage immagine = ImageIO.read(input);
                    if (immagine == null) {
                        System.out.println("Formato immagine non valido: " + percorso);
                    } else {
                        icona = new ImageIcon(immagine);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Errore caricamento immagine: " + e.getMessage());
        }
        return icona;
    }

    /**
     * Ridimensiona l'immagine ai pixel indicati
     *
     * @param percorso path dell'immagine
     * @param larghezza larghezza in pixel
     * @param altezza altezza in pixel
     * @return icona scalata, null se il file non c'è o non si legge
     */
    public ImageIcon caricaIconaScalata(String percorso, int larghezza, int altezza) {
        ImageIcon iconaScalata = null;
        ImageIcon icona = caricaIcona(percorso);
        if (icona != null) {
            Image immagine = icona.getImage().getScaledInstance(larghezza, altezza, Image.SCALE_SMOOTH);
            iconaScalata = new ImageIcon(immagine);
        }
        return iconaScalata;
    }
}
