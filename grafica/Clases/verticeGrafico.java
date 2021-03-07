
package grafica.Clases;

import java.awt.Graphics;
import logica.vertice;

public class verticeGrafico extends vertice {

    public static final int D = 10; //diametro del vertice
    
    //----------CONSTRUCTORES----------

    public verticeGrafico(int x , int y) {
        super(x, y);
    }

    //----------FIN DE CONSTRUCTORES----------

    //----------METODOS MODIFICADORES Y OBTENEDORES----------

    /*
    public int getX(){
        return this.obtenerComponenteX();
    }

    public void setX(int x){
        this.modificarComponenteX(x);
    }

    public int getY(){
        return this.obtenerComponenteY();
    }

    public void setY(int y){
        this.modificarComponenteY(y);
    }
    */

    //----------FIN DE METODOS MODIFICADORES Y OBTENEDORES----------

    //----------METODOS EN GENERAL----------

    /**
     * Pinta el vertice en (x,y) de la ventana.
     * @param g una instancia de 'Graphics'.
     */
    public void pnitar(Graphics g){
        g.drawOval(this.obtenerComponenteX() - D/2 , this.obtenerComponenteY() - D/2 , D , D);
    }

    void pintar(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //----------FIN DE METODOS EN GENERAL----------



}