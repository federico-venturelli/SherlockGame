package it.unicatt.sherlock.view;

import it.unicatt.sherlock.model.CostantiCasoVilla;

import java.awt.*;

/** Coordinate del caso Villa Morandi, tarate sulle immagini 800x600 */
public final class RegistroLayoutCasoVilla extends RegistroLayout {

    /** Inserisce location, indizi e personaggi del caso Villa */
    @Override
    protected void registraCoordinate() {
        registraLocation(CostantiCasoVilla.LOCATION_SALOTTO, new Rectangle(213, 80, 220, 220));
        registraLocation(CostantiCasoVilla.LOCATION_CUCINA, new Rectangle(80, 80, 127, 230));
        registraLocation(CostantiCasoVilla.LOCATION_STUDIO, new Rectangle(550, 302, 165, 230));
        registraLocation(CostantiCasoVilla.LOCATION_TERRAZZO, new Rectangle(73, 317, 352, 128));
        registraLocation(CostantiCasoVilla.LOCATION_SICUREZZA, new Rectangle(433, 302, 113, 120));
        registraLocation(CostantiCasoVilla.LOCATION_CAMERA_OSPITI, new Rectangle(438, 78, 276, 150));

        registraElemento(CostantiCasoVilla.INDIZIO_SMARTWATCH, new Rectangle(573, 496, 17, 18));
        registraElemento(CostantiCasoVilla.INDIZIO_MORANDI, new Rectangle(530, 390, 160, 80));
        registraElemento(CostantiCasoVilla.INDIZIO_BICCHIERE, new Rectangle(400, 440, 20, 50));

        registraElemento(CostantiCasoVilla.INDIZIO_PANNO, new Rectangle(290, 380, 100, 30));
        registraElemento(CostantiCasoVilla.INDIZIO_TAZZINA, new Rectangle(155, 340, 25, 22));
        registraElemento(CostantiCasoVilla.PERSONAGGIO_ENEA, new Rectangle(560, 190, 180, 400));

        registraElemento(CostantiCasoVilla.INDIZIO_BADGE, new Rectangle(730, 430, 35, 35));
        registraElemento(CostantiCasoVilla.INDIZIO_PC_PORTATILE, new Rectangle(360, 330, 55, 45));
        registraElemento(CostantiCasoVilla.INDIZIO_LIBRO, new Rectangle(450, 450, 40, 40));
        registraElemento(CostantiCasoVilla.INDIZIO_LETTERA_BANCA, new Rectangle(290, 340, 50, 30));
        registraElemento(CostantiCasoVilla.INDIZIO_PREMIO, new Rectangle(750, 240, 40, 60));
        registraElemento(CostantiCasoVilla.PERSONAGGIO_SILVIA, new Rectangle(150, 150, 150, 380));

        registraElemento(CostantiCasoVilla.INDIZIO_SIGARO, new Rectangle(290, 460, 30, 20));
        registraElemento(CostantiCasoVilla.PERSONAGGIO_ELENA, new Rectangle(400, 200, 100, 280));

        registraElemento(CostantiCasoVilla.INDIZIO_TERMINALE_SICUREZZA, new Rectangle(580, 270, 100, 90));
        registraElemento(CostantiCasoVilla.INDIZIO_POST_IT, new Rectangle(335, 210, 30, 30));
        registraElemento(CostantiCasoVilla.INDIZIO_CHIAVI, new Rectangle(95, 265, 25, 25));
        registraElemento(CostantiCasoVilla.PERSONAGGIO_MARCO, new Rectangle(390, 165, 180, 420));
    }
}
