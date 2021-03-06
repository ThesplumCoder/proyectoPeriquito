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

    public Double buscadorMenorAristaRecorridos(){
        if(verticesRecorridos.get(0).equals(null)){
            verticesRecorridos.add(0 , lineaMasPequena().obtenerVerticeInicial());
            verticesRecorridos.add(1 , lineaMasPequena().obtenerVerticeFinal());
        }
        else{
            Double menor = Double.valueOf(0);
            for(int i = 0 ; i <= verticesRecorridos.size() ; i++){
                ArrayList<Double> temporal = new ArrayList<>(magnitudVecinos(verticesRecorridos.get(i)));
                for(Double magnitud : temporal){
                    if(magnitud < menor){
                        menor = Double.valueOf(magnitud.doubleValue());
                    }
                }
            }
            return menor;
        }
        return null;
    }

    public void marcarPequenaArista(arista menor) {
        if(verticesRecorridos.contains(menor.obtenerVerticeInicial())){
            if(verticesRecorridos.contains(menor.obtenerVerticeFinal())){
                JOptionPane.showMessageDialog(null, "Arista descartada: " + menor.obtenerArista().toString());
            }
        }
        else{
            if(verticesRecorridos.contains(menor.obtenerVerticeFinal())){
                this.verticesRecorridos.add(menor.obtenerVerticeFinal());
            }
            else{
                this.verticesRecorridos.add(menor.obtenerVerticeInicial());
                this.verticesRecorridos.add(menor.obtenerVerticeFinal());
            }
        }
    }
    //----------FIN DE METODOS EN GENERAL----------
}
