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
