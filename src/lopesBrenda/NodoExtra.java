package lopesBrenda;

class NodoExtra {
    private Extra extra;
    private NodoExtra siguiente;

    public NodoExtra(Extra extra) {
        this.extra = extra;
        this.siguiente = null;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public NodoExtra getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoExtra siguiente) {
        this.siguiente = siguiente;
    }
}
