package it.unicatt.sherlock.model;

import it.unicatt.sherlock.model.personaggio.Personaggio;

import java.util.ArrayList;
import java.util.List;

/** Elenco delle location esplorabili */
public class Mappa {
    private final List<Location> locations;

    /** Mappa vuota da riempire con le location del caso */
    public Mappa() {
        locations = new ArrayList<>();
    }

    /** @return tutte le location del caso */
    public List<Location> getTutteLeLocation() {
        return new ArrayList<>(locations);
    }

    /** @return tutti i personaggi sparsi nelle location */
    public List<Personaggio> getTuttiIPersonaggi() {
        List<Personaggio> personaggi = new ArrayList<>();
        for (Location location : locations) {
            personaggi.addAll(location.getPersonaggi());
        }
        return personaggi;
    }

    /**
     * Aggiunge una location alla mappa
     *
     * @param location location da inserire
     */
    public void aggiungiLocation(Location location) {
        locations.add(location);
    }
}
