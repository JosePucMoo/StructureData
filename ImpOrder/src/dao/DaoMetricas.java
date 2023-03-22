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

    public void escribirArchivoMetricas(int opcion, String nuevaLinea) throws IOException{
        archivo = new File(path);

        ArrayList<String> lista = leerArchivo();
        lista.remove(opcion);
        lista.add(opcion, nuevaLinea);

        FileWriter fw = new FileWriter(archivo);
        
        for(int i = 0; i < lista.size(); i++ ) {
            fw.append(lista.get(i) + "\n");
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
