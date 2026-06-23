package it.unicatt.sherlock.model.personaggio;

/** Sospettato che puoi interrogare */
public final class Sospettato extends Personaggio {
    private final String risposta;

    /**
     * @param nome nome del sospettato
     * @param descrizione ruolo nella villa
     * @param risposta dichiarazione resa al detective
     */
    public Sospettato(String nome, String descrizione, String risposta) {
        super(nome, descrizione);
        this.risposta = risposta;
    }

    /** Restituisce la dichiarazione del sospettato */
    @Override
    public String interagisci() {
        return risposta;
    }
}
