package logica;

import logica.vertice;

public class arista {
    private vertice verticeInicial;
    private vertice verticeFinal;

    //----------CONSTRUCTORES----------

    public arista(){
        verticeInicial = null;
        verticeFinal = null;
    }

    public arista(vertice a , vertice b){
        this.verticeInicial = new vertice(a);
        this.verticeFinal = new vertice(b);
    }

    //----------FIN DE CONSTRUCTORES----------

    public vertice obtenerVerticeInicial(){
        return this.verticeInicial;
    }

    public vertice obtenerVerticeFinal(){
        return this.verticeFinal;
    }

    public arista obtenerArista(){
        return this;
    }
}
