package logica;

import java.util.ArrayList;

public class vertice implements interfazLogica {
    
    private double x;
    private double y;

    //----------CONSTRUCTORES----------

    public vertice(){
        x = 0;
        y = 0;
    }

    public vertice(double x , double y){
        this.x = x;
        this.y = y;
    }

    public vertice(vertice alguno){
        x = alguno.obtenerComponenteX();
        y = alguno.obtenerComponenteY();
    }

    //----------FIN DE CONSTRUCTORES----------

    //----------METODOS MODIFICADORES Y OBTENERDORES----------

    public double obtenerComponenteX(){
        return this.x;
    }

    public double obtenerComponenteY(){
        return this.y;
    }
    
    /**
     * Este metodo construye el par ordenado que constituye el vertice.
     * @return Devuelve el vertice como un par ordenado (ArrayList<Double>).
     */
    public ArrayList<Double> obtenerVertice(){
        ArrayList<Double> par = new ArrayList<>();
        Double valorX = x;
        Double valorY = y;
        par.add(valorX);
        par.add(valorY);
        return par;
    }

    //----------FIN DE METODOS MODIFICADORES Y OBTENERDORES----------

    //----------METODOS EN GENERAL----------

    /**
     * Metodo que verifica si dos instancias de 'vertice' tiene igual contenido.
     * @param elemento una instancia de 'vertice'.
     * @return true: si 'elemento' tiene igual contenido que 'vertice' | false: si no tienen lo mismo.
     */
    public boolean equals(vertice elemento){
        if(this.x == elemento.obtenerComponenteX()){
            if(this.y == elemento.obtenerComponenteY()){
                return true;
            }
        }
        return false;
    }

    //----------FIN DE METODOS EN GENERAL----------

}
