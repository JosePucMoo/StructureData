package utils.comparadores;

import java.util.Comparator;

import domain.Song;

public class ComparadorDeCancionesPorDuracion implements Comparator<Song>{

    private int multiplicador;

public ComparadorDeCancionesPorDuracion(boolean ascendente ){
    if(ascendente){
        multiplicador = 1;
    } else{
        multiplicador = -1;
    }
}

    @Override
    public int compare(Song o1, Song o2) {
        if(o1.getDuration() - o2.getDuration() > 0) {
            return 1 * multiplicador;
        } else if (o1.getDuration() - o2.getDuration() < 0) {
            return -1 * multiplicador;
        } else {
            return 0;
        }
    }
    
}
