package lopesBrenda;

class Hamburguesa {
    private Pan[] panes;
    private Carne carne;
    private NodoExtra primerExtra;
    private int tamañoExtras;

    public Hamburguesa(Pan panSuperior, Pan panInferior, Carne carne) {
        this.panes = new Pan[]{panSuperior, panInferior};
        this.carne = carne;
        this.primerExtra = null;
        this.tamañoExtras = 0;
    }

    public void agregarExtra(Extra extra) {
        NodoExtra nuevoExtra = new NodoExtra(extra);

        if (primerExtra == null) {
            primerExtra = nuevoExtra;
        } else {
            NodoExtra actual = primerExtra;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoExtra);
        }
        tamañoExtras++;
    }

    public void actualizarExtra(int index, Extra nuevoExtra) {
        if (index < 0 || index >= tamañoExtras) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        NodoExtra nodoActual = obtenerNodoEnIndice(index);
        nodoActual.setExtra(nuevoExtra);
    }

    public void eliminarExtra(int index) {
        if (index < 0 || index >= tamañoExtras) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (index == 0) {
            primerExtra = primerExtra.getSiguiente();
        } else {
            NodoExtra anterior = obtenerNodoEnIndice(index - 1);
            NodoExtra actual = anterior.getSiguiente();
            anterior.setSiguiente(actual.getSiguiente());
        }
        tamañoExtras--;
    }

    public void agregarExtraIntermedio(int index, Extra extra) {
        if (index < 0 || index > tamañoExtras) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        NodoExtra nuevoExtra = new NodoExtra(extra);

        if (index == 0) {
            nuevoExtra.setSiguiente(primerExtra);
            primerExtra = nuevoExtra;
        } else {
            NodoExtra actual = obtenerNodoEnIndice(index - 1);
            nuevoExtra.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoExtra);
        }
        tamañoExtras++;
    }

    public int encontrarExtraNombre(String nombre) {
        NodoExtra actual = primerExtra;
        int index = 0;
        while (actual != null) {
            if (actual.getExtra().describir().contains(nombre)) {
                return index;
            }
            actual = actual.getSiguiente();
            index++;
        }
        return -1; 
    }

    public void mostrar() {
        panes[0].mostrar();
        carne.mostrar();
        NodoExtra actual = primerExtra;
        while (actual != null) {
            actual.getExtra().mostrar();
            actual = actual.getSiguiente();
        }
        panes[1].mostrar();
    }

    public String describir() {
        String descripcion = panes[0].describir() + ", " + carne.describir();
        NodoExtra actual = primerExtra;
        while (actual != null) {
            descripcion += ", " + actual.getExtra().describir();
            actual = actual.getSiguiente();
        }
        descripcion += "\n";
        return descripcion;
    }

    private NodoExtra obtenerNodoEnIndice(int index) {
        if (index < 0 || index >= tamañoExtras) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        NodoExtra actual = primerExtra;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public static void main(String[] args) {
        Pan panSuperior = new Brioche();
        Pan panInferior = new Brioche();
        Carne carne = new Res("poco hecha");

        Hamburguesa hamburguesa = new Hamburguesa(panSuperior, panInferior, carne);

        hamburguesa.agregarExtra(new Cheddar());
        hamburguesa.agregarExtra(new Ketchup("poco"));
        hamburguesa.agregarExtra(new Mayonesa("mucho"));

        System.out.println("Hamburguesa inicial:");
        hamburguesa.mostrar();
        System.out.println();

        int indexCheddar = hamburguesa.encontrarExtraNombre("Cheddar");
        if (indexCheddar != -1) {
            hamburguesa.actualizarExtra(indexCheddar, new Azul());
            System.out.println("Hamburguesa después de actualizar 'Cheddar' a 'Queso Azul':");
            hamburguesa.mostrar();
            System.out.println();
        } else {
            System.out.println("No se encontró el extra 'Cheddar' en la hamburguesa.");
        }

        int indexMayonesa = hamburguesa.encontrarExtraNombre("Mayonesa");
        if (indexMayonesa != -1) {
            hamburguesa.eliminarExtra(indexMayonesa);
            System.out.println("Hamburguesa después de eliminar 'Mayonesa':");
            hamburguesa.mostrar();
        } else {
            System.out.println("No se encontró el extra 'Mayonesa' en la hamburguesa.");
        }
    }

}
