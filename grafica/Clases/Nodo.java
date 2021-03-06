/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafica.Clases;

import java.awt.Graphics;

public class Nodo {
    private int x,y;
    public static final int d=10; //diametro del vertice

    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;//posicion x,y del vertice
    }
    
    public void pnitar(Graphics g){
        g.drawOval(this.x - d/2, this.y - d/2, d, d);     // pinta en una posicion x,y el vertice
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    void pintar(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}