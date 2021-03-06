package logica;

public class arista implements interfazLogica {
    
    private vertice verticeInicial;
    private vertice verticeFinal;

    //----------CONSTRUCTORES----------

    public arista(){
        this.verticeInicial = new vertice();
        this.verticeFinal = new vertice();
    }

    public arista(vertice a , vertice b){
        this.verticeInicial = new vertice(a);
        this.verticeFinal = new vertice(b);
    }

    public arista(arista alguna){
        this.verticeInicial = new vertice(alguna.obtenerVerticeInicial());
        this.verticeFinal = new vertice(alguna.obtenerVerticeFinal());
    }

    //----------FIN DE CONSTRUCTORES----------

    //----------METODOS MODIFICADORES Y OBTENERDORES----------

    public vertice obtenerVerticeInicial(){
        return this.verticeInicial;
    }

    public vertice obtenerVerticeFinal(){
        return this.verticeFinal;
    }

    public arista obtenerArista(){
        return this;
    }

    //----------FIN DE METODOS MODIFICADORES Y OBTENERDORES----------

    //----------METODOS EN GENERAL----------

    /**
     * Metodo que verifica si dos instancias de 'arista' tienen igual contenido.
     * @param elemento una instancia de 'arista'.
     * @return true: si 'elemento' tiene igual contenido que 'arista' | false: si no tienen lo mismo.
     */
    public boolean equals(arista elemento){
        if(this.verticeInicial.equals(elemento.obtenerVerticeInicial())){
            if(this.verticeFinal.equals(elemento.obtenerVerticeFinal())){
                return true;
            }
        }
        return false;
    }

    public double peso(){
        double deltaX = verticeFinal.obtenerComponenteX() - verticeInicial.obtenerComponenteX();
        double deltaY = verticeFinal.obtenerComponenteY() - verticeInicial.obtenerComponenteY();
        deltaX = Math.pow(deltaX , 2);
        deltaY = Math.pow(deltaY , 2);
        return Math.sqrt(deltaX + deltaY);
    }

    public arista aristaInversa(){
        arista inversa = new arista(verticeFinal , verticeInicial);
        return inversa;
    }

    //----------FIN DE METODOS EN GENERAL----------
}
