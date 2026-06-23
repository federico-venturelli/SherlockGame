package it.unicatt.sherlock.model.personaggio;

import java.util.Objects;

/** Personaggio con cui il giocatore può parlare */
public abstract class Personaggio {
    private final String nome;
    private final String descrizione;

    /**
     * @param nome nome del personaggio
     * @param descrizione breve presentazione
     */
    public Personaggio(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    /** @return cosa dice il personaggio */
    public abstract String interagisci();

    /** @return nome del personaggio */
    public String getNome() {
        return nome;
    }

    /** @return descrizione del personaggio */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Due personaggi sono uguali se hanno lo stesso nome
     *
     * @param o altro oggetto
     * @return true se è lo stesso personaggio
     */
    @Override
    public boolean equals(Object o) {
        boolean uguale = false;
        if (this == o) {
            uguale = true;
        } else if (o != null && getClass() == o.getClass()) {
            Personaggio altroPersonaggio = (Personaggio) o;
            uguale = Objects.equals(nome, altroPersonaggio.nome);
        }
        return uguale;
    }

    /** Hash basato sul nome, coerente con equals */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
