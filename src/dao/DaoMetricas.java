package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que controla el archivo de Metricas.csv
 */
public class DaoMetricas {
    File archivo;
    String path = "src\\orderData\\Metricas.csv";

    /**
     * Escribe en el archivo "Metricas" la lista de Strings enviadas.
     * @param listaMetricas LinkedList que será escrito en el archivo.
     * @throws IOException  Si el archivo no puede ser creado o abierto lanza la excepción.
     */
    public void escribirArchivoMetricas(ArrayList<String> listaMetricas) throws IOException{
        archivo = new File(path);
        
        FileWriter fw = new FileWriter(archivo);
        
        for(int i = 0; i < listaMetricas.size(); i++ ) {
            fw.append(listaMetricas.get(i) + "\n");
        }

        fw.close();
    }
  
}
