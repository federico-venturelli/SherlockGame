package it.unicatt.sherlock.model;

import it.unicatt.sherlock.model.enigma.Enigma;
import it.unicatt.sherlock.model.personaggio.Personaggio;

/** Caso giocabile: il delitto di Villa Morandi */
public final class CasoVilla extends Caso {

    /** Crea il caso Villa Morandi con titolo e descrizione già impostati */
    public CasoVilla() {
        super(CostantiCasoVilla.TITOLO, CostantiCasoVilla.DESCRIZIONE);
    }

    /**
     * Monta location, indizi, personaggi e soluzione del caso
     *
     * @param fabbrica crea gli oggetti del gioco
     */
    @Override
    public void preparaCaso(FabbricaGioco fabbrica) {

        Location cucina = fabbrica.creaLocation(CostantiCasoVilla.LOCATION_CUCINA);
        Location salotto = fabbrica.creaLocation(CostantiCasoVilla.LOCATION_SALOTTO);
        Location studio = fabbrica.creaLocation(CostantiCasoVilla.LOCATION_STUDIO);
        Location terrazzo = fabbrica.creaLocation(CostantiCasoVilla.LOCATION_TERRAZZO);
        Location sicurezza = fabbrica.creaLocation(CostantiCasoVilla.LOCATION_SICUREZZA);
        Location cameraOspiti = fabbrica.creaLocation(CostantiCasoVilla.LOCATION_CAMERA_OSPITI);

        Indizio libro = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_LIBRO, CostantiCasoVilla.DESCRIZIONE_INDIZIO_LIBRO);
        Indizio letteraBanca = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_LETTERA_BANCA, CostantiCasoVilla.DESCRIZIONE_INDIZIO_LETTERA_BANCA);
        Indizio bicchiere = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_BICCHIERE, CostantiCasoVilla.DESCRIZIONE_INDIZIO_BICCHIERE);
        Indizio tazzina = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_TAZZINA, CostantiCasoVilla.DESCRIZIONE_INDIZIO_TAZZINA);
        Indizio panno = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_PANNO, CostantiCasoVilla.DESCRIZIONE_INDIZIO_PANNO);
        Indizio chiavi = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_CHIAVI, CostantiCasoVilla.DESCRIZIONE_INDIZIO_CHIAVI);
        Indizio sigaro = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_SIGARO, CostantiCasoVilla.DESCRIZIONE_INDIZIO_SIGARO);
        Indizio premio = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_PREMIO, CostantiCasoVilla.DESCRIZIONE_INDIZIO_PREMIO);
        Indizio postIt = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_POST_IT, CostantiCasoVilla.DESCRIZIONE_INDIZIO_POST_IT);
        Indizio corpo = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_MORANDI, CostantiCasoVilla.DESCRIZIONE_INDIZIO_MORANDI);
        Indizio smartwatch = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_SMARTWATCH, CostantiCasoVilla.DESCRIZIONE_INDIZIO_SMARTWATCH);
        Indizio badge = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_BADGE, CostantiCasoVilla.DESCRIZIONE_INDIZIO_BADGE);

        Indizio portatileBloccato = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_PC_PORTATILE, CostantiCasoVilla.DESCRIZIONE_INDIZIO_PC_PORTATILE);
        Enigma enigmaPortatile = fabbrica.creaEnigmaCodice(
                CostantiCasoVilla.CODICE_ENIGMA_PC,
                CostantiCasoVilla.TESTO_SBLOCCO_ENIGMA_PC,
                CostantiCasoVilla.DOMANDA_ENIGMA_PC
        );
        portatileBloccato.setEnigma(enigmaPortatile);

        Indizio terminaleSicurezzaBloccato = fabbrica.creaIndizio(CostantiCasoVilla.INDIZIO_TERMINALE_SICUREZZA, CostantiCasoVilla.DESCRIZIONE_INDIZIO_TERMINALE_SICUREZZA);
        Enigma enigmaTerminale = fabbrica.creaEnigmaCodice(
                CostantiCasoVilla.CODICE_ENIGMA_TERMINALE,
                CostantiCasoVilla.TESTO_SBLOCCO_ENIGMA_TERMINALE,
                CostantiCasoVilla.DOMANDA_ENIGMA_TERMINALE
        );
        terminaleSicurezzaBloccato.setEnigma(enigmaTerminale);

        cucina.aggiungiIndizio(tazzina);
        cucina.aggiungiIndizio(panno);

        salotto.aggiungiIndizio(smartwatch);
        salotto.aggiungiIndizio(corpo);
        salotto.aggiungiIndizio(bicchiere);
        salotto.aggiungiIndizio(libro);

        cameraOspiti.aggiungiIndizio(badge);
        cameraOspiti.aggiungiIndizio(portatileBloccato);
        cameraOspiti.aggiungiIndizio(letteraBanca);

        sicurezza.aggiungiIndizio(terminaleSicurezzaBloccato);
        sicurezza.aggiungiIndizio(postIt);
        sicurezza.aggiungiIndizio(chiavi);

        studio.aggiungiIndizio(premio);
        terrazzo.aggiungiIndizio(sigaro);

        Personaggio socia = fabbrica.creaSospettato(
                CostantiCasoVilla.PERSONAGGIO_SILVIA,
                CostantiCasoVilla.RUOLO_SILVIA,
                CostantiCasoVilla.DICHIARAZIONE_SILVIA
        );
        Personaggio capoSicurezza = fabbrica.creaSospettato(
                CostantiCasoVilla.PERSONAGGIO_MARCO,
                CostantiCasoVilla.RUOLO_MARCO,
                CostantiCasoVilla.DICHIARAZIONE_MARCO
        );
        Personaggio exMoglie = fabbrica.creaSospettato(
                CostantiCasoVilla.PERSONAGGIO_ELENA,
                CostantiCasoVilla.RUOLO_ELENA,
                CostantiCasoVilla.DICHIARAZIONE_ELENA
        );
        Personaggio maggiordomo = fabbrica.creaSospettato(
                CostantiCasoVilla.PERSONAGGIO_ENEA,
                CostantiCasoVilla.RUOLO_ENEA,
                CostantiCasoVilla.DICHIARAZIONE_ENEA
        );

        cucina.aggiungiPersonaggio(maggiordomo);
        sicurezza.aggiungiPersonaggio(capoSicurezza);
        studio.aggiungiPersonaggio(socia);
        terrazzo.aggiungiPersonaggio(exMoglie);

        getMappa().aggiungiLocation(cucina);
        getMappa().aggiungiLocation(salotto);
        getMappa().aggiungiLocation(sicurezza);
        getMappa().aggiungiLocation(studio);
        getMappa().aggiungiLocation(cameraOspiti);
        getMappa().aggiungiLocation(terrazzo);

        setColpevole(socia);
        setSoluzione(CostantiCasoVilla.SOLUZIONE);
    }
}
