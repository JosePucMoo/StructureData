package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DaoMetricas {
    File archivo;
    String path = "src\\orderData\\Metricas.csv";

    public void escribirArchivoMetricas(ArrayList<String> listaMetricas) throws IOException{
        archivo = new File(path);
        
        FileWriter fw = new FileWriter(archivo);
        
        for(int i = 0; i < listaMetricas.size(); i++ ) {
            fw.append(listaMetricas.get(i) + "\n");
        }

        fw.close();
    }

    public ArrayList<String>  leerArchivo() throws FileNotFoundException {
        ArrayList<String> lista = new ArrayList<>();
        Scanner obj = new Scanner(archivo);
    
        while(obj.hasNextLine()){
            lista.add(obj.nextLine());
        }
        return lista;
    }
    

    public void crearAarchivo(String path ) throws IOException {
        archivo = new File(path);
        if(!archivo.exists())
        {
            archivo.createNewFile();
        }
    }


    
}
