package it.unicatt.sherlock.audio;

import javax.sound.sampled.*;
import java.io.InputStream;

/** Gestisce la musica di sottofondo con una sola traccia condivisa */
public final class GestoreAudio {
    private static GestoreAudio istanza;
    private Clip colonnaSonora;

    /** Singleton: costruttore privato */
    private GestoreAudio() {
    }

    /** @return unica istanza del gestore */
    public static GestoreAudio getIstanza() {
        if (istanza == null) {
            istanza = new GestoreAudio();
        }
        return istanza;
    }

    /**
     * Carica il file (solo la prima volta) e avvia il loop
     * Se la musica sta già suonando non fa nulla, così non partono due tracce
     *
     * @param percorsoFile path del file wav, es. /audio/traccia.wav
     */
    public void avviaMusica(String percorsoFile) {
        try {
            if (colonnaSonora == null) {
                InputStream stream = GestoreAudio.class.getResourceAsStream(percorsoFile);
                if (stream == null) {
                    System.out.println("Audio non trovato: " + percorsoFile);
                } else {
                    try (InputStream input = stream) {
                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(input);
                        colonnaSonora = AudioSystem.getClip();
                        colonnaSonora.open(audioStream);
                    }
                }
            }

            if (colonnaSonora != null && !colonnaSonora.isRunning()) {
                colonnaSonora.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            System.out.println("Errore audio: " + e.getMessage());
        }
    }

    /** Ferma la riproduzione */
    public void fermaMusica() {
        if (colonnaSonora != null && colonnaSonora.isRunning()) {
            colonnaSonora.stop();
        }
    }

    /** @return true se la musica sta suonando */
    public boolean isMusicaAttiva() {
        return colonnaSonora != null && colonnaSonora.isRunning();
    }

}
