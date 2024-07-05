package lopesBrenda;

import java.util.ArrayList;
import java.util.List;

class Hamburguesa {
    private Pan[] panes;
    private Carne carne;
    private List<Extra> extras;

    public Hamburguesa(Pan panSuperior, Pan panInferior, Carne carne) {
        this.panes = new Pan[]{panSuperior, panInferior};
        this.carne = carne;
        this.extras = new ArrayList<>();
    }

    public void agregarExtra(Extra extra) {
        extras.add(extra);
    }

    public void actualizarExtra(int index, Extra nuevoExtra) {
        if (index >= 0 && index < extras.size()) {
            extras.set(index, nuevoExtra);
        }
    }

    public void eliminarExtra(int index) {
        if (index >= 0 && index < extras.size()) {
            extras.remove(index);
        }
    }

    public void agregarExtraIntermedio(int index, Extra extra) {
        extras.add(index, extra);
    }

    public int encontrarExtraNombre(String nombre) {
        for (int i = 0; i < extras.size(); i++) {
            if (extras.get(i).describir().contains(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public void mostrar() {
        panes[0].mostrar();
        carne.mostrar();
        for (Extra extra : extras) {
            extra.mostrar();
        }
        panes[1].mostrar();
    }

    public String describir() {   
        String descripcion; 
        descripcion = panes[0].describir() + ", " + carne.describir();
        for (Extra extra : extras) {
            descripcion += ", " + extra.describir();
        }
        descripcion = descripcion + "\n";
        return descripcion;
    }
}
