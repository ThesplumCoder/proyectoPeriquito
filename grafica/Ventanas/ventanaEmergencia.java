package grafica.Ventanas;

import grafica.Clases.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

public class ventanaEmergencia extends JFrame implements MouseListener{
    private static final long serialVersionUID = 1L;

    private final ArrayList<aristaGrafica> aristasGraficas;
    private final ArrayList<verticeGrafico> verticesGraficos;
    private Point p1,p2;
    private JPanel panel;
    private JLabel caminoCorto;

    //----------CONSTRUCTORES----------

    public ventanaEmergencia() {
        panel = new JPanel();
        caminoCorto = new JLabel("Mostrar camino mas corto" , JLabel.CENTER);

        this.setSize(500 , 500);
        this.setTitle("Constructor de Rutas");
        this.setLocationRelativeTo(ventanaEmergencia.this);
        this.setResizable(true);

        this.getContentPane().add(panel);
        panel.add(caminoCorto);
        this.addMouseListener(this);

        this.verticesGraficos = new ArrayList<>();
        this.aristasGraficas = new ArrayList<>();
        this.p1 = null;
        this.p2 = null;
    }

    public void paint(Graphics g){
        verticesGraficos.forEach(nodos -> {nodos.pnitar(g);});
        aristasGraficas.forEach(enlace -> {enlace.pintar(g);});
    }
    

    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            int temporal1 = e.getX();
            int temporal2 = e.getY();
            this.verticesGraficos.add(new verticeGrafico(temporal1 , temporal2));        
            repaint();
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            for(verticeGrafico nodo : verticesGraficos){
                int temporal1 = nodo.obtenerComponenteX()-verticeGrafico.D/2;
                int temporal2 = nodo.obtenerComponenteY()-verticeGrafico.D/2;
                int temporal3 = verticeGrafico.D;
                int temporal4 = verticeGrafico.D;
                if(new Rectangle(temporal1 , temporal2 , temporal3 , temporal4).contains(e.getPoint())){
                    if(p1 == null){
                        p1 = new Point(nodo.obtenerComponenteX() , nodo.obtenerComponenteY());
                    }
                    else{
                        p2 = new Point (nodo.obtenerComponenteX() , nodo.obtenerComponenteY());
                        this.aristasGraficas.add(new aristaGrafica( p1.x , p1.y , p2.x , p2.y));
                        repaint();
                        p1 = null;
                        p2 = null;
                    }  
                }
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
