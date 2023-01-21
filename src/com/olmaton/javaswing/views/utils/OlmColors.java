package com.olmaton.javaswing.views.utils;

import java.awt.Color;

/**
 *
 * @author olmaton
 */
public class OlmColors {

    //Alertas
    private static final int[] ALERT_0 = new int[]{51, 204, 0};
    private static final int[] ALERT_1 = new int[]{0, 204, 255};
    private static final int[] ALERT_2 = new int[]{255, 153, 102};
    private static final int[] ALERT_3 = new int[]{255, 102, 102};
    private static final int[] ALERT_0_DARK = new int[]{51, 175, 59};
    private static final int[] ALERT_1_DARK = new int[]{0, 181, 234};
    private static final int[] ALERT_2_DARK = new int[]{241, 127, 70};
    private static final int[] ALERT_3_DARK = new int[]{230, 73, 73};

    //Texto
    private static final int[] TEXTO_GENERAL = new int[]{60, 60, 60};

    //Bordes
    private static final int[] BORDE_TEXTO = new int[]{150, 150, 150};

    //Gris
    private static final int[] GREY = new int[]{230, 230, 230};
    private static final int[] GREY_DARK = new int[]{210, 210, 210};

    public static Color getAlert0() {
        return new Color(ALERT_0[0], ALERT_0[1], ALERT_0[2]);
    }

    public static Color getAlert1() {
        return new Color(ALERT_1[0], ALERT_1[1], ALERT_1[2]);
    }

    public static Color getAlert2() {
        return new Color(ALERT_2[0], ALERT_2[1], ALERT_2[2]);
    }

    public static Color getAlert3() {
        return new Color(ALERT_3[0], ALERT_3[1], ALERT_3[2]);
    }

    public static Color getAlert3(int t) {
        return new Color(ALERT_3[0], ALERT_3[1], ALERT_3[2], t);
    }

    public static Color getAlert0Dark() {
        return new Color(ALERT_0_DARK[0], ALERT_0_DARK[1], ALERT_0_DARK[2]);
    }

    public static Color getAlert1Dark() {
        return new Color(ALERT_1_DARK[0], ALERT_1_DARK[1], ALERT_1_DARK[2]);
    }

    public static Color getAlert2Dark() {
        return new Color(ALERT_2_DARK[0], ALERT_2_DARK[1], ALERT_2_DARK[2]);
    }

    public static Color getAlert3Dark() {
        return new Color(ALERT_3_DARK[0], ALERT_3_DARK[1], ALERT_3_DARK[2]);
    }

    public static Color getAlert3Dark(int f) {
        return new Color(ALERT_3_DARK[0], ALERT_3_DARK[1], ALERT_3_DARK[2], f);
    }

    public static Color getTextoGeneral() {
        return new Color(TEXTO_GENERAL[0], TEXTO_GENERAL[1], TEXTO_GENERAL[2]);
    }

    public static Color getBordeTexto() {
        return new Color(BORDE_TEXTO[0], BORDE_TEXTO[1], BORDE_TEXTO[2]);
    }
}
