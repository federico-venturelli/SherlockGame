package it.unicatt.sherlock.model;

import it.unicatt.sherlock.model.enigma.Enigma;

/** Oggetto cliccabile che il detective può esaminare */
public class Indizio {
    private final String nome;
    private final String descrizione;
    private Enigma enigma;

    /**
     * @param nome nome dell'indizio
     * @param descrizione cosa si vede o si legge
     */
    public Indizio(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        enigma = null;
    }

    /** @return nome dell'indizio */
    public String getNome() {
        return nome;
    }

    /** @return descrizione dell'indizio */
    public String getDescrizione() {
        return descrizione;
    }

    /** @return enigma collegato, se c'è */
    public Enigma getEnigma() {
        return enigma;
    }

    /**
     * Collega un enigma a questo indizio
     *
     * @param enigma enigma da risolvere
     */
    public void setEnigma(Enigma enigma) {
        this.enigma = enigma;
    }

    /**
     * Prova a risolvere l'enigma associato
     *
     * @param input codice inserito dal giocatore
     * @return true se il codice è giusto
     */
    public boolean risolviEnigma(String input) {
        boolean esito = false;
        if (enigma != null) {
            esito = enigma.tentativoRisoluzione(input);
        }
        return esito;
    }
}
