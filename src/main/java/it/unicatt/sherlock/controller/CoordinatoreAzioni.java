package it.unicatt.sherlock.controller;

import it.unicatt.sherlock.model.Indizio;
import it.unicatt.sherlock.model.enigma.Enigma;
import it.unicatt.sherlock.model.personaggio.Personaggio;
import it.unicatt.sherlock.view.MainFrame;
import it.unicatt.sherlock.view.PresentatoreDialoghi;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/** Coordina facade, popup e navigazione per le azioni più articolate */
public class CoordinatoreAzioni {
    private final PresentatoreDialoghi presentatore;
    private final ApplicazioneSherlock applicazione;

    /**
     * @param presentatore gestisce i popup di gioco
     * @param applicazione gestisce il ritorno al menu
     */
    public CoordinatoreAzioni(PresentatoreDialoghi presentatore, ApplicazioneSherlock applicazione) {
        this.presentatore = presentatore;
        this.applicazione = applicazione;
    }

    /**
     * Flusso completo dell'accusa finale
     *
     * @param finestra finestra di gioco
     * @param facciata collegamento col modello
     */
    public void gestisciAccusa(MainFrame finestra, FacciataSherlock facciata) {
        List<Personaggio> sospettati = facciata.getTuttiISospettati();
        Personaggio scelto = presentatore.chiediAccusa(finestra, sospettati);

        if (scelto != null) {
            boolean vittoria = facciata.tentaAccusa(scelto);

            if (vittoria) {
                presentatore.mostraVittoria(finestra, facciata.getCasoAttuale().getSoluzione());
            } else {
                presentatore.mostraSconfitta(finestra);
            }

            applicazione.tornaAlMenu(finestra);
        }
    }

    /**
     * Flusso completo della risoluzione di un enigma
     *
     * @param indizio indizio collegato
     * @param enigma enigma da risolvere o già risolto
     * @param facciata collegamento col modello
     * @param finestra finestra su cui aprire i popup
     * @param bottoneEnigma bottone da aggiornare se il codice è giusto
     */
    public void gestisciEnigma(Indizio indizio, Enigma enigma, FacciataSherlock facciata, Component finestra, JButton bottoneEnigma) {
        if (!enigma.isRisolto()) {
            String tentativo = presentatore.chiediTentativoEnigma(finestra, enigma);
            if (tentativo != null) {
                boolean successo = facciata.risolviEnigma(indizio, tentativo);
                if (successo) {
                    presentatore.mostraEsitoEnigmaCorretto(finestra, enigma);
                    presentatore.aggiornaBottoneEnigmaRisolto(bottoneEnigma);
                } else {
                    presentatore.mostraEsitoEnigmaErrato(finestra);
                }
            }
        } else {
            presentatore.mostraArchivioSbloccato(finestra, indizio, enigma);
        }
    }
}
