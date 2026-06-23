package it.unicatt.sherlock.view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/** Coordinate dei bottoni cliccabili su mappa e location di un caso */
public abstract class RegistroLayout {
    private final Map<String, Rectangle> layoutMappa;
    private final Map<String, Rectangle> layoutElementiLocation;

    /** Carica le coordinate definite dalla sottoclasse */
    protected RegistroLayout() {
        layoutMappa = new HashMap<>();
        layoutElementiLocation = new HashMap<>();
        registraCoordinate();
    }

    /** Inserisce i rettangoli del caso specifico */
    protected abstract void registraCoordinate();

    /**
     * @param nome nome della location
     * @param rettangolo area cliccabile sulla mappa
     */
    protected void registraLocation(String nome, Rectangle rettangolo) {
        layoutMappa.put(nome, rettangolo);
    }

    /**
     * @param nome nome di indizio o personaggio
     * @param rettangolo area cliccabile nella location
     */
    protected void registraElemento(String nome, Rectangle rettangolo) {
        layoutElementiLocation.put(nome, rettangolo);
    }

    /**
     * @param nomeLocation nome della location sulla mappa
     * @return rettangolo cliccabile, null se non definito
     */
    public Rectangle getPosizioneLocation(String nomeLocation) {
        return layoutMappa.get(nomeLocation);
    }

    /**
     * @param nomeElemento nome di indizio o personaggio
     * @return rettangolo cliccabile, null se non definito
     */
    public Rectangle getPosizioneElemento(String nomeElemento) {
        return layoutElementiLocation.get(nomeElemento);
    }
}
