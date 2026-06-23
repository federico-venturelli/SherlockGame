package it.unicatt.sherlock.model;

import it.unicatt.sherlock.model.personaggio.Personaggio;

import java.util.ArrayList;
import java.util.List;

/** Location esplorabile con i suoi indizi e personaggi */
public class Location {
    private final String nome;
    private final List<Indizio> indizi;
    private final List<Personaggio> personaggi;

    /**
     * @param nome nome della location
     */
    public Location(String nome) {
        this.nome = nome;
        indizi = new ArrayList<>();
        personaggi = new ArrayList<>();
    }

    /** @return nome della location */
    public String getNome() {
        return nome;
    }

    /** @return indizi presenti nella location */
    public List<Indizio> getIndizi() {
        return new ArrayList<>(indizi);
    }

    /** @return personaggi presenti nella location */
    public List<Personaggio> getPersonaggi() {
        return new ArrayList<>(personaggi);
    }

    /**
     * Mette un indizio nella location
     *
     * @param indizio indizio da aggiungere
     */
    public void aggiungiIndizio(Indizio indizio) {
        indizi.add(indizio);
    }

    /**
     * Mette un personaggio nella location
     *
     * @param personaggio personaggio da aggiungere
     */
    public void aggiungiPersonaggio(Personaggio personaggio) {
        personaggi.add(personaggio);
    }
}
