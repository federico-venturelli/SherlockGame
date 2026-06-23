package it.unicatt.sherlock.view;

import it.unicatt.sherlock.model.Caso;
import it.unicatt.sherlock.model.Indizio;
import it.unicatt.sherlock.model.enigma.Enigma;
import it.unicatt.sherlock.model.personaggio.Personaggio;
import it.unicatt.sherlock.view.risorsa.ApplicatoreStile;
import it.unicatt.sherlock.view.risorsa.CaricatoreImmagini;
import it.unicatt.sherlock.view.risorsa.CostantiRisorse;
import it.unicatt.sherlock.view.risorsa.CostantiTesti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Apre i popup del gioco: intro, regole, indizi, accusa
 */
public class PresentatoreDialoghi {
    private final ApplicatoreStile stile;
    private final CaricatoreImmagini caricatore;

    /**
     * @param stile gestisce colori e font
     * @param caricatore carica le immagini degli indizi
     */
    public PresentatoreDialoghi(ApplicatoreStile stile, CaricatoreImmagini caricatore) {
        this.stile = stile;
        this.caricatore = caricatore;
    }

    /**
     * Messaggio di benvenuto all'inizio della partita
     *
     * @param finestra finestra su cui aprire il popup
     * @param caso caso appena avviato
     */
    public void mostraIntroduzione(Component finestra, Caso caso) {
        mostraMessaggioScrollabile(
                finestra,
                CostantiTesti.TITOLO_INTRO,
                CostantiTesti.testoIntro(caso.getTitolo(), caso.getDescrizione()),
                JOptionPane.INFORMATION_MESSAGE,
                ApplicatoreStile.DIMENSIONE_POPUP_MESSAGGIO
        );
    }

    /**
     * Mostra le istruzioni di gioco
     *
     * @param finestra finestra su cui aprire il popup
     */
    public void mostraRegole(Component finestra) {
        mostraMessaggioScrollabile(
                finestra,
                CostantiTesti.TITOLO_REGOLE,
                CostantiTesti.TESTO_REGOLE,
                JOptionPane.PLAIN_MESSAGE,
                ApplicatoreStile.DIMENSIONE_POPUP_REGOLE
        );
    }

    /**
     * Popup con descrizione e dichiarazione del personaggio
     *
     * @param finestra finestra di gioco
     * @param personaggio chi stai interrogando
     */
    public void mostraPersonaggio(Component finestra, Personaggio personaggio) {
        String testo = personaggio.getDescrizione() + "\n\n" + personaggio.interagisci();
        JScrollPane pannelloScorrimento = creaAreaScrollabile(testo, ApplicatoreStile.DIMENSIONE_POPUP_MESSAGGIO);
        JOptionPane.showMessageDialog(finestra, pannelloScorrimento, personaggio.getNome(), JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Mostra immagine e descrizione dell'indizio
     *
     * @param finestra finestra di gioco
     * @param indizio indizio cliccato
     * @param listenerEnigma gestisce il click sul bottone enigma, null se non c'è enigma
     */
    public void mostraIndizio(Component finestra, Indizio indizio, ActionListener listenerEnigma) {
        JPanel pannelloIspezione = new JPanel(new BorderLayout(12, 12));
        stile.stilizzaPannelloIspezioneIndizio(pannelloIspezione);

        ImageIcon iconaOriginale = caricatore.caricaIcona(CostantiRisorse.immagineIndizio(indizio.getNome()));
        if (iconaOriginale != null) {
            double rapporto = Math.min(
                    (double) ApplicatoreStile.MASSIMA_LARGHEZZA_IMMAGINE_INDIZIO / iconaOriginale.getIconWidth(),
                    (double) ApplicatoreStile.MASSIMA_ALTEZZA_IMMAGINE_INDIZIO / iconaOriginale.getIconHeight()
            );
            int larghezzaImmagine = (int) (iconaOriginale.getIconWidth() * rapporto);
            int altezzaImmagine = (int) (iconaOriginale.getIconHeight() * rapporto);

            Image immagineScalata = iconaOriginale.getImage().getScaledInstance(larghezzaImmagine, altezzaImmagine, Image.SCALE_SMOOTH);
            JLabel labelImmagine = new JLabel(new ImageIcon(immagineScalata));
            stile.stilizzaImmagineIndizio(labelImmagine);
            pannelloIspezione.add(labelImmagine, BorderLayout.CENTER);
        }

        JPanel pannelloInferiore = new JPanel(new BorderLayout(8, 8));
        JScrollPane pannelloScorrimentoDescrizione = creaAreaScrollabile(indizio.getDescrizione(), null);
        pannelloInferiore.add(pannelloScorrimentoDescrizione, BorderLayout.CENTER);

        if (indizio.getEnigma() != null) {
            Enigma enigma = indizio.getEnigma();
            JButton bottoneEnigma = creaBottoneEnigma(enigma);
            if (listenerEnigma != null) {
                bottoneEnigma.addActionListener(listenerEnigma);
            }
            pannelloInferiore.add(bottoneEnigma, BorderLayout.SOUTH);
        }

        pannelloIspezione.add(pannelloInferiore, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(
                finestra,
                pannelloIspezione,
                CostantiTesti.titoloEsaminaIndizio(indizio.getNome()),
                JOptionPane.PLAIN_MESSAGE
        );
    }

    /**
     * Chiede al giocatore chi accusare
     *
     * @param finestra finestra di gioco
     * @param sospettati lista dei possibili colpevoli
     * @return sospettato scelto, null se chiudi il popup
     */
    public Personaggio chiediAccusa(Component finestra, List<Personaggio> sospettati) {
        String[] nomiSospettati = new String[sospettati.size()];
        for (int i = 0; i < sospettati.size(); i++) {
            nomiSospettati[i] = sospettati.get(i).getNome();
        }

        String scelta = (String) JOptionPane.showInputDialog(
                finestra,
                CostantiTesti.DOMANDA_ACCUSA,
                CostantiTesti.TITOLO_ACCUSA,
                JOptionPane.WARNING_MESSAGE,
                null,
                nomiSospettati,
                nomiSospettati[0]
        );

        Personaggio sospettatoScelto = null;
        if (scelta != null) {
            for (Personaggio sospettato : sospettati) {
                if (sospettato.getNome().equals(scelta)) {
                    sospettatoScelto = sospettato;
                }
            }
        }
        return sospettatoScelto;
    }

    /**
     * Popup di vittoria con la soluzione del caso
     *
     * @param finestra finestra di gioco
     * @param soluzione spiegazione del delitto
     */
    public void mostraVittoria(Component finestra, String soluzione) {
        mostraRisultatoFinale(
                finestra,
                CostantiTesti.TITOLO_VITTORIA_GRANDE,
                CostantiTesti.TITOLO_VITTORIA,
                CostantiTesti.messaggioVittoria(soluzione),
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Popup quando l'accusa è sbagliata
     *
     * @param finestra finestra di gioco
     */
    public void mostraSconfitta(Component finestra) {
        mostraRisultatoFinale(
                finestra,
                CostantiTesti.TITOLO_SCONFITTA_GRANDE,
                CostantiTesti.TITOLO_SCONFITTA,
                CostantiTesti.MESSAGGIO_SCONFITTA,
                JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Finestra per inserire il codice dell'enigma
     *
     * @param finestra finestra di gioco
     * @param enigma enigma da risolvere
     * @return codice inserito, null se annulli
     */
    public String chiediTentativoEnigma(Component finestra, Enigma enigma) {
        return JOptionPane.showInputDialog(
                finestra,
                enigma.getTestoRichiesta(),
                CostantiTesti.TITOLO_TENTATIVO_ENIGMA,
                JOptionPane.QUESTION_MESSAGE
        );
    }

    /**
     * Conferma che il codice era giusto e mostra il contenuto sbloccato
     *
     * @param finestra finestra di gioco
     * @param enigma enigma appena risolto
     */
    public void mostraEsitoEnigmaCorretto(Component finestra, Enigma enigma) {
        JOptionPane.showMessageDialog(
                finestra,
                CostantiTesti.PREFISSO_ENIGMA_CORRETTO + enigma.getRisultatoPositivo(),
                CostantiTesti.TITOLO_ENIGMA_CORRETTO,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Avvisa che il codice inserito non va bene
     *
     * @param finestra finestra di gioco
     */
    public void mostraEsitoEnigmaErrato(Component finestra) {
        JOptionPane.showMessageDialog(
                finestra,
                CostantiTesti.MESSAGGIO_ENIGMA_ERRATO,
                CostantiTesti.TITOLO_ENIGMA_ERRATO,
                JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Rilegge il contenuto già sbloccato di un enigma
     *
     * @param finestra finestra di gioco
     * @param indizio indizio collegato all'enigma
     * @param enigma enigma già risolto in precedenza
     */
    public void mostraArchivioSbloccato(Component finestra, Indizio indizio, Enigma enigma) {
        JOptionPane.showMessageDialog(
                finestra,
                enigma.getRisultatoPositivo(),
                CostantiTesti.titoloArchivioSbloccato(indizio.getNome()),
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Cambia testo e colore del bottone dopo aver risolto l'enigma
     *
     * @param bottoneEnigma bottone nel popup dell'indizio
     */
    public void aggiornaBottoneEnigmaRisolto(JButton bottoneEnigma) {
        bottoneEnigma.setText(CostantiTesti.BOTTONE_MOSTRA_FILE_DECIFRATI);
        stile.stilizzaBottoneEnigmaSbloccato(bottoneEnigma);
    }

    /**
     * Crea il bottone giusto se l'enigma è già risolto o no
     *
     * @param enigma enigma collegato all'indizio
     */
    private JButton creaBottoneEnigma(Enigma enigma) {
        JButton bottoneEnigma = new JButton();
        if (!enigma.isRisolto()) {
            bottoneEnigma.setText(CostantiTesti.BOTTONE_RISOLVI_ENIGMA);
            stile.stilizzaBottoneEnigma(bottoneEnigma);
        } else {
            aggiornaBottoneEnigmaRisolto(bottoneEnigma);
        }
        return bottoneEnigma;
    }

    /**
     * @param testo contenuto dell'area
     * @param dimensione dimensione dello scroll, null per lasciare quella di default
     * @return area di testo con scroll già stilizzata
     */
    private JScrollPane creaAreaScrollabile(String testo, Dimension dimensione) {
        JTextArea areaTesto = new JTextArea(testo);
        stile.stilizzaAreaTesto(areaTesto);

        JScrollPane pannelloScorrimento = new JScrollPane(areaTesto);
        if (dimensione != null) {
            pannelloScorrimento.setPreferredSize(dimensione);
        }
        stile.stilizzaScrollPane(pannelloScorrimento);
        return pannelloScorrimento;
    }

    /** Popup generico con testo lungo e scroll */
    private void mostraMessaggioScrollabile(Component finestra, String titolo, String messaggio, int tipo, Dimension dimensione) {
        JScrollPane pannelloScorrimento = creaAreaScrollabile(messaggio, dimensione);
        JOptionPane.showMessageDialog(finestra, pannelloScorrimento, titolo, tipo);
    }

    /** Popup di vittoria o sconfitta con titolo grande */
    private void mostraRisultatoFinale(Component finestra, String titoloGrande, String titoloFinestra, String messaggio, int tipoMessaggio) {
        JPanel pannello = new JPanel(new BorderLayout(15, 15));
        stile.stilizzaPannelloRisultatoFinale(pannello);

        JLabel labelTitolo = new JLabel(titoloGrande, SwingConstants.CENTER);
        boolean vittoria = tipoMessaggio != JOptionPane.ERROR_MESSAGE;
        stile.stilizzaTitoloRisultatoFinale(labelTitolo, vittoria);
        pannello.add(labelTitolo, BorderLayout.NORTH);

        JScrollPane pannelloScorrimento = creaAreaScrollabile(messaggio, ApplicatoreStile.DIMENSIONE_POPUP_RISULTATO);
        pannello.add(pannelloScorrimento, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(finestra, pannello, titoloFinestra, tipoMessaggio);
    }
}
