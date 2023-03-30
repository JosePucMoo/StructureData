package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import domain.Song;

public class DaoCanciones {
    String path = "src\\dataBase\\dataset.csv";
    File archivo = new File(path);
    LinkedList<Song> lista;

    /**
     * Lee el archivo de canciones  y retorna las canciones del documento en una LinkedList
     * 
     * @return LinkedList con las canciones del archivo leído.
     * @throws FileNotFoundException Si el archivo no es encontrado entonces lanza la excepción.
     */
    public LinkedList<Song> traerCanciones() throws FileNotFoundException{
        LinkedList<Song> lista = new LinkedList<>();
        Scanner obj = new Scanner(new FileReader(path));
        StringTokenizer tokenizer;
        
        while(obj.hasNextLine()){
            String linea = obj.nextLine();

            tokenizer = new StringTokenizer(linea, ",");
            
            int position = Integer.parseInt(tokenizer.nextToken()) ;
            String artist = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            int days = Integer.parseInt(tokenizer.nextToken()) ; //Numero de días desde el lanzamiento de la canción
            double top_10 = Double.parseDouble(tokenizer.nextToken());
            int peak_Position = Integer.parseInt(tokenizer.nextToken()) ;
            String peak_Position_xTimes = tokenizer.nextToken();
            int peak_Streams = Integer.parseInt(tokenizer.nextToken()) ;
            double total_Streams = Double.parseDouble(tokenizer.nextToken());

            Song song = new Song(position, artist, name, days, top_10, peak_Position, peak_Position_xTimes, peak_Streams, total_Streams);
            
            
            lista.add(song);

        }

        return lista;
    }

    /**
     * Escribe en el archivo con el nombre proporcionado la lista de canciones enviadas.
     * @param archivoName Nombre del archivo por crear o sobreescribir.
     * @param lista LinkedList de canciones por escribir en archivo.
     * @throws IOException
     */
    public void escribirArchivo(String archivoName, LinkedList<Song> lista  ) throws IOException {
        String path = "src\\orderData\\" + archivoName;

        File archivoOrdenado = new File(path);
        
        FileWriter fw = new FileWriter(archivoOrdenado);

        for(Song x : lista){
            fw.append(x.getPosition() + "," + x.getArtist() + "," + x.getSong() + "," + x.getDays() + "," + x.getTop_10()+ "," + x.getPeak_Position() + "," + x.getPeak_Position_xTimes() + "," + x.getPeak_Streams() + "," + x.getTotal_Streams() + "\n");
        }

        fw.close();

    }

    /**
     * Elimina el archivo Radix.
     */
    public void borrarArchivoRadix(){
        String path = "src\\orderData\\RadixSort_Ordenado.csv";
        File archivoRadix = new File(path);

        archivoRadix.delete();
    }


}
