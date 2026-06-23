package it.unicatt.sherlock.model;

import it.unicatt.sherlock.model.enigma.Enigma;
import it.unicatt.sherlock.model.enigma.EnigmaCodice;
import it.unicatt.sherlock.model.personaggio.Personaggio;
import it.unicatt.sherlock.model.personaggio.Sospettato;

/** Crea gli oggetti usati nel gioco */
public class FabbricaGioco {

    /** Costruisce e restituisce il caso Villa Morandi già configurato */
    public Caso creaCaso() {
        CasoVilla caso = new CasoVilla();
        caso.preparaCaso(this);
        return caso;
    }

    /**
     * @param nome etichetta dell'indizio
     * @param descrizione testo letto dal giocatore
     * @return nuovo indizio
     */
    public Indizio creaIndizio(String nome, String descrizione) {
        return new Indizio(nome, descrizione);
    }

    /**
     * @param nome nome del personaggio
     * @param ruolo chi è e cosa fa
     * @param risposta cosa dice quando lo interroghi
     * @return nuovo sospettato
     */
    public Personaggio creaSospettato(String nome, String ruolo, String risposta) {
        return new Sospettato(nome, ruolo, risposta);
    }

    /**
     * @param codiceCorretto password giusta
     * @param testoDaSbloccare messaggio sbloccato dopo il codice
     * @param testoEnigma domanda mostrata al giocatore
     * @return enigma a codice
     */
    public Enigma creaEnigmaCodice(String codiceCorretto, String testoDaSbloccare, String testoEnigma) {
        return new EnigmaCodice(codiceCorretto, testoDaSbloccare, testoEnigma);
    }

    /**
     * @param nome nome della location
     * @return nuova location vuota
     */
    public Location creaLocation(String nome) {
        return new Location(nome);
    }
}
