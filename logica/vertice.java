package logica;

import java.util.ArrayList;

public class vertice implements interfazLogica {
    
    private int x;
    private int y;

    //----------CONSTRUCTORES----------

    public vertice(){
        x = 0;
        y = 0;
    }

    public vertice(int x , int y){
        this.x = x;
        this.y = y;
    }

    public vertice(vertice alguno){
        x = alguno.obtenerComponenteX();
        y = alguno.obtenerComponenteY();
    }

    //----------FIN DE CONSTRUCTORES----------

    //----------METODOS MODIFICADORES Y OBTENERDORES----------

    public int obtenerComponenteX(){
        return this.x;
    }

    public int obtenerComponenteY(){
        return this.y;
    }

    public void modificarComponenteX(int x){
        this.x = x;
    }
    
    public void modificarComponenteY(int y){
        this.y = y;
    }

    /**
     * Este metodo construye el par ordenado que constituye el vertice.
     * @return Devuelve el vertice como un par ordenado (ArrayList<Double>).
     */
    public ArrayList<Integer> obtenerVertice(){
        ArrayList<Integer> par = new ArrayList<>();
        Integer valorX = Integer.valueOf(x);
        Integer valorY = Integer.valueOf(y);
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
