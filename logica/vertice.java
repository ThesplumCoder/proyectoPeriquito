package logica;

import java.util.ArrayList;

public class vertice {
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

    public double obtenerComponenteX(){
        return this.x;
    }

    public double obtenerComponenteY(){
        return this.y;
    }
    
    /**
     * Este metodo me construye el par ordenado que constituye el vertice y lo retorna.
     */
    public ArrayList<Double> obtenerVertice(){
        ArrayList<Double> par = new ArrayList<>();
        Double valorX = x;
        Double valorY = y;
        par.add(valorX);
        par.add(valorY);
        return par;
    }
}
