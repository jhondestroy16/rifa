package rifa.main;

import rifa.vista.fmrRifa;
import rifa.controlador.CtrlRifa;
import rifa.modelo.ConsultaRifa;
import rifa.modelo.Rifa;

public class main {

    public static void main(String[] args) {
        Rifa mod = new Rifa();
        ConsultaRifa modC = new ConsultaRifa();
        fmrRifa fmr = new fmrRifa();

        CtrlRifa ctrl = new CtrlRifa (mod, modC, fmr);
        ctrl.iniciar();
        fmr.setVisible(true);
    }
}

