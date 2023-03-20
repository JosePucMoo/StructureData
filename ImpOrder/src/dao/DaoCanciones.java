package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import domain.Song;
import utils.comparadores.ComparadorDeCancionesPorDuracion;
import utils.comparadores.ComparadorDeCancionesPorNombre;
import utils.sortingMethods.BinaryInsertionSort;
import utils.sortingMethods.MergeSort;

public class DaoCanciones {
    String path = "src\\dataBase\\dataset.csv";
    File archivo = new File(path);
    LinkedList<Song> lista;

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

    public LinkedList<Song> ordenarLista( int opcion, Comparator<? super Song> comparator ) throws FileNotFoundException {
        LinkedList<Song> lista = traerCanciones(); //Leer el archivo CSV donde están las canciones
        
        switch(opcion){ //Cada opción representa un método de ordenamiento
            case 1: //Ordenar por metodo binaryInsertionSort
                lista = BinaryInsertionSort.binaryInsertionSort(lista, lista.size(), comparator);
                break;
            case 2:  //Ordenar por metodo mergeSort
                lista = MergeSort.mergeSort(lista, comparator);
                break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida");
                break;
        }

        return lista;
    }

    public void escribirArchivo(int opcion, Comparator<? super Song> comparator ) throws IOException {
        String pathBinary = "src\\orderData\\BinaryInsertionSort_ordenado.csv";
        String pathMerge = "src\\orderData\\MergeSort_ordenado.csv";
        File archivoOrdenado = null;

        switch( opcion) {
            case 1: 
            archivoOrdenado = new File(pathBinary);
                break;
            case 2:  
            archivoOrdenado = new File(pathMerge);
                break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida");
                break;
        }

        lista = ordenarLista(opcion, comparator);
        
        FileWriter fw = new FileWriter(archivoOrdenado);

        for(Song x : lista){
            fw.append(x.getId() + "," + x.getName() + "," + x.getDuration() + "," + x.getEnergy() + "," + x.getKey() + "," + x.getLoudness() + "," + x.getMode() + "," + x.getSpeechiness() + "," + x.getAcousticness() + "," + x.getInstrumentalness() + "," + x.getLiveness() + "," + x.getValence() + "," + x.getTempo() + "," + x.getDanceability() + "\n");
        }

        fw.close();

    }


}
