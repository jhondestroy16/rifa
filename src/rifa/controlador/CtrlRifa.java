package rifa.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rifa.modelo.ConsultaRifa;
import rifa.modelo.Rifa;
import rifa.vista.fmrRifa;

public class CtrlRifa implements ActionListener {

    private final Rifa mod;
    private final ConsultaRifa modC;
    private final fmrRifa fmr;

    public CtrlRifa(Rifa mod, ConsultaRifa modC, fmrRifa fmr) {
        this.mod = mod;
        this.modC = modC;
        this.fmr = fmr;
        this.fmr.btnGuardar.addActionListener(this);
        this.fmr.btnModificar.addActionListener(this);
        this.fmr.btnEliminar.addActionListener(this);
        this.fmr.btnLimpiar.addActionListener(this);
        this.fmr.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        fmr.setTitle("Rifa");
        fmr.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fmr.btnGuardar) {
            mod.setNumero(Integer.parseInt(fmr.txtNumero.getText()));
            mod.setNombre(fmr.txtNombre.getText());
            mod.setApellido(fmr.txtApellido.getText());
            mod.setDireccion(fmr.txtDireccion.getText());
            mod.setTelefono(fmr.txtTelefono.getText());
            mod.setPago(fmr.txtPago.getText());

            if (modC.guardar(mod)) {
                System.out.println("Registro guardado");
                limpiar();
            } else {
                System.out.println("Error al guardar");
            }
        }
        if (e.getSource() == fmr.btnModificar) {

            mod.setNombre(fmr.txtNombre.getText());
            mod.setApellido(fmr.txtApellido.getText());
            mod.setDireccion(fmr.txtDireccion.getText());
            mod.setTelefono(fmr.txtTelefono.getText());
            mod.setPago(fmr.txtPago.getText());
            mod.setNumero(Integer.parseInt(fmr.txtNumero.getText()));

            if (modC.modificar(mod)) {
                System.out.println("producto modificado correctamente");
                limpiar();
            } else {
                System.out.println("Error al modificar producto");
            }
        }
        if (e.getSource() == fmr.btnEliminar) {
            mod.setNumero(Integer.parseInt(fmr.txtNumero.getText()));
            if (modC.eliminar(mod)) {
                System.out.println("Producto eliminado correctamente");
                limpiar();
            } else {
                System.out.println("Error al eliminar producto");
            }
        }
        if (e.getSource() == fmr.btnBuscar) {
            mod.setNumero(Integer.parseInt(fmr.txtNumero.getText()));

            if (modC.buscar(mod)) {
                fmr.txtNumero.setText(String.valueOf(mod.getNumero()));
                fmr.txtNombre.setText(mod.getNombre());
                fmr.txtApellido.setText(mod.getApellido());
                fmr.txtDireccion.setText(mod.getDireccion());
                fmr.txtTelefono.setText(mod.getTelefono());
                fmr.txtPago.setText(mod.getPago());
            } else {
                System.out.println("No se encontro registro");
                limpiar();
            }
        }
        if (e.getSource() == fmr.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        fmr.txtNombre.setText(null);
        fmr.txtApellido.setText(null);
        fmr.txtDireccion.setText(null);
        fmr.txtTelefono.setText(null);
        fmr.txtPago.setText(null);
    }
}
