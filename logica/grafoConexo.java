package logica;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class grafoConexo {

    private ArrayList<vertice> vertices;
    private ArrayList<arista> aristas;

//----------CONSTRUCTORES----------
    
    public grafoConexo(){
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public grafoConexo(grafoConexo alguno){
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
        vertices.addAll(alguno.obtenerVertices());
        aristas.addAll(alguno.obtenerAristas());
    }

//----------FIN DE CONSTRUCTORES----------

//----------METODOS MODIFICADORES Y OBTENERDORES----------

    /**
     * Accede a los vertices del grafo.
     * @return Devuelve el arreglo de vertices del grafo.
     */
    public ArrayList<vertice> obtenerVertices(){
        return this.vertices;
    }

    /**
     * Accede a las aristas del grafo.
     * @return Devuelve el arreglo de aristas del grafo.
     */
    public ArrayList<arista> obtenerAristas(){
        return this.aristas;
    }

    /**
     * Revisa si el grafo esta vacio.
     * @return true: Si el grafo esta vacio. | false: El grafo contiene al menos un o unos vertices.
     */
    public boolean grafoVacio(){
        if(this.obtenerVertices().isEmpty()){
            return true;
        }
        return false;
    }

//----------FIN DE METODOS MODIFICADORES Y OBTENERDORES----------

//----------METODOS EN GENERAL----------
    
    /**
     * Busca entre los objetos del grafo para verificar si es un elemento diferente o ya esta en el grafo.
     * @param elemento un objeto que puede ser 'vertice' o 'arista'.
     * @return true: si el elemento esta ya en alguna lista | false: si es un objeto diferente a los que ya estan.
     */
    private boolean buscarRepetido(Object elemento){
        if(elemento instanceof vertice){
            elemento = (vertice)elemento;
            if(vertices.contains(elemento)){
                return true;
            }
            else{
                return false;
            }
        }
        else if(elemento instanceof arista){
            arista a = (arista)elemento;
            if(aristas.contains(a) || aristas.contains(a.aristaInversa())){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    /**
     * Agrega vertices al grafo con los parametros que se le suministran.
     * @param x Coordenada horizontal del vertice.
     * @param y Coordenada vertical del vertice.
     */
    public void agregarVertice(int x , int y){
        vertice temporal = new vertice(x , y);
        if(buscarRepetido(temporal) == false){
            this.vertices.add(temporal);
        }
        else{
            JOptionPane.showMessageDialog(null , "El vertice ingresado ya esta en el grafo.");
        }
    }

    /**
     * Agrega aristas al grafo con los vertices que se le indican. Los vertices ya deben pertenecer al grafo.
     * @param inicio Vertice donde empieza la arista.
     * @param llegada Vertice donde termina la arista.
     */
    public void agregarArista(vertice inicio , vertice llegada){
        if(vertices.contains(inicio) && vertices.contains(llegada)){
            arista temporal = new arista(inicio , llegada);
            if(buscarRepetido(temporal) == false){
                this.aristas.add(temporal);
            }
            else{
                JOptionPane.showConfirmDialog(null, "La arista ingresada ya esta en el grafo.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Alguno de los vertices ingresados no esta en el grafo.");
        }
    }

    /**
     * Elimina vertices que pertenezcan al grafo.
     * @param objetivo Vertice que se quiere eliminar del grafo.
     */
    public void eliminarVertice(vertice objetivo){
        this.vertices.remove(objetivo);
    }

    /**
     * Elimina aristas que pertenezcan al grafo, no elimina los vertices.
     * @param objetivo Arista que se quiere eliminar del grafo.
     */
    public void eliminarArista(arista objetivo){
        this.aristas.remove(objetivo);
    }

    /**
     * Recorre todos los vertices del grafo y va mirando si tienen alguna arista asociada.
     * @return true: Todos los vertices tienen al menos una arista | false: Hay un o unos vertices sin aristas.
     */
    private boolean verificarConexidad(){
        int caminos = 0;
        boolean bandera = true;
        
        for(vertice nodo : vertices){
            for(arista linea : aristas){
                if(linea.obtenerVerticeInicial().equals(nodo) || linea.obtenerVerticeFinal().equals(nodo)){
                    caminos += 1;
                }
            }
            if(caminos == 0){
                bandera = false;
                return bandera;
            }
            caminos = 0;
        }
        return bandera;
    }

    /**
     * Arregla el grafo para que se convierta en un grafo conexo.
     */
    public void configurarConexidad(){
        if(verificarConexidad() == false){
            for(vertice nodo : vertices){
                int vecinos = 0;
                for(arista linea : aristas){
                    if(linea.obtenerVerticeInicial().equals(nodo) || linea.obtenerVerticeFinal().equals(nodo)){
                        vecinos++;
                    }
                }
                if(vecinos == 0){
                    this.agregarArista(nodo , vertices.get(0));
                }
            }
            JOptionPane.showMessageDialog(null, "Grafo transformado a conexo.");
        }
        else{
            JOptionPane.showMessageDialog(null, "El grafo ya es conexo.");
        }
    }

    //----------FIN DE METODOS EN GENERAL----------

}
