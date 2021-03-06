package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class algoritmoPrim {
    
    private ArrayList<vertice> verticesRecorridos;
    private grafoConexo grafo;

    //----------CONSTRUCTORES----------
    
    public algoritmoPrim(){
        verticesRecorridos = new ArrayList<>();
        grafo = new grafoConexo();
    }

    public algoritmoPrim(grafoConexo grafo){
        verticesRecorridos = new ArrayList<>();
        this.grafo = new grafoConexo(grafo);
    }

    //----------FIN DE CONSTRUCTORES----------

    //----------METODOS MODIFICADORES Y OBTENERDORES----------

    /**
     * Accede a los vertices que ya recorrio el algoritmo Prim.
     * @return Devuelve el arreglo de vertices que se tienen.
     */
    public ArrayList<vertice> obtenerVerticesRecorridos(){
        if(verticesRecorridos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay ningun vertice recorrido.");
        }
        else{
            return verticesRecorridos;
        }
        return null;
    }

    //----------FIN DE METODOS MODIFICADORES Y OBTENERDORES----------

    //----------METODOS EN GENERAL----------

    /**
     * Busca la arista con mas chiquita del grafo.
     * @return Devuelve la arista mas chiquita del grafo.
     */
    private arista lineaMasPequena(){
        double menor = 0;
        arista masPequena = new arista();
        for(arista linea : grafo.obtenerAristas()){
            if(linea.peso() < menor){
                menor = linea.peso();
                masPequena = linea;
            }
        }
        return masPequena;
    }

    private ArrayList<arista> mirarVecinos(vertice vecino){
        ArrayList<arista> vecinos = new ArrayList<>();
        for(arista vecina : grafo.obtenerAristas()){
            if(vecina.obtenerVerticeInicial().equals(vecino) || vecina.obtenerVerticeFinal().equals(vecino)){
                vecinos.add(vecina);
            }
        }
        return vecinos;
    }

    private ArrayList<Double> magnitudVecinos(vertice vecino){
        ArrayList<Double> temporal = new ArrayList<>();
        ArrayList<arista> vecinos = new ArrayList<>(mirarVecinos(vecino));
        for(int i = 0 ; i <= vecinos.size() ; i++){
            temporal.add(vecinos.get(i).peso());
        }
        return temporal;
    }

    public void agregarVerticesRecorridos(){
        if(verticesRecorridos.get(0).equals(null)){
            verticesRecorridos.add(0 , lineaMasPequena().obtenerVerticeInicial());
            verticesRecorridos.add(1 , lineaMasPequena().obtenerVerticeFinal());
        }
        else{
            ArrayList<arista> temporal = new ArrayList<>();
        }
    }
    //----------FIN DE METODOS EN GENERAL----------
}
