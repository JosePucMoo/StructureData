package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import domain.Song;
import utils.ComparadorDeCancionesPorDuracion;
import utils.ComparadorDeCancionesPorNombre;
import utils.binaryInsertionSort;

public class DaoCanciones {
    String path = "src\\dataBase\\dataset.csv";
    File archivo = new File(path);

    public LinkedList<Song> traerCanciones() throws FileNotFoundException{
        LinkedList<Song> lista = new LinkedList<>();
        Scanner obj = new Scanner(archivo);
        StringTokenizer tokenizer;
        
        while(obj.hasNextLine()){
            String linea = obj.nextLine();

            tokenizer = new StringTokenizer(linea, ",");

            String id = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            double duration = Double.parseDouble(tokenizer.nextToken());
            double energy = Double.parseDouble(tokenizer.nextToken());
            int key = Integer.parseInt(tokenizer.nextToken());
            double loudness = Double.parseDouble(tokenizer.nextToken());
            int mode = Integer.parseInt(tokenizer.nextToken());
            double speechiness = Double.parseDouble(tokenizer.nextToken());
            double acousticness = Double.parseDouble(tokenizer.nextToken());
            String instrumentalness = tokenizer.nextToken();
            String liveness = tokenizer.nextToken();
            String valence = tokenizer.nextToken();
            String tempo = tokenizer.nextToken();
            String danceability = tokenizer.nextToken();

            Song song = new Song(id, name, duration, energy, key, loudness, mode,speechiness, acousticness, instrumentalness, liveness, valence, tempo, danceability );

            lista.add(song);

        }

        return lista;
    }


    public LinkedList<Song> OrdenarlistaPorNombre(boolean asc  ) throws FileNotFoundException{
        LinkedList<Song> lista = new LinkedList<Song>();

        lista = traerCanciones(); //Leer el archivo CSV donde están las canciones


        lista = binaryInsertionSort.binaryInsertionSort(lista, lista.size(), new ComparadorDeCancionesPorNombre(asc));

        return lista;
    }

    public LinkedList<Song> OrdenarlistaPorDuracion(boolean asc  ) throws FileNotFoundException{
        LinkedList<Song> lista = new LinkedList<Song>();

        lista = traerCanciones(); //Leer el archivo CSV donde están las canciones


        lista = binaryInsertionSort.binaryInsertionSort(lista, lista.size(), new ComparadorDeCancionesPorDuracion(asc));

        return lista;
    }


    public void escribirCancionesArchivo(int opcion, boolean asc) throws IOException {
        String pathOrdenado = "src\\orderData\\BinaryInsertionSort_ordenado.csv";
        File archivoOrdenado = new File(pathOrdenado);

        LinkedList<Song> lista = null;

        switch(opcion){
            case 1: //La opción 1 sirve para ordenar de acuerdo a los nombres de las canciones
                lista = OrdenarlistaPorNombre(asc);
                break;
            case 2: //La opción 2 sirve para ordenar de acuerdo a la duracipon de las canciones
                lista = OrdenarlistaPorDuracion(asc);
                break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida");
                break;
        }

        FileWriter fw = new FileWriter(archivoOrdenado);

        for(Song x : lista){
            fw.append(x.getId() + "," + x.getName() + "," + x.getDuration() + "," + x.getEnergy() + "," + x.getKey() + "," + x.getLoudness() + "," + x.getMode() + "," + x.getSpeechiness() + "," + x.getAcousticness() + "," + x.getInstrumentalness() + "," + x.getLiveness() + "," + x.getValence() + "," + x.getTempo() + "," + x.getDanceability() + "\n");
        }

    }


}
