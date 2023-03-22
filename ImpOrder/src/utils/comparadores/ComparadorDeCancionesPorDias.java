package utils.comparadores;

import java.util.Comparator;

import domain.Song;

public class ComparadorDeCancionesPorDias implements Comparator<Song>{

    private int multiplicador;

public ComparadorDeCancionesPorDias(boolean ascendente ){
    if(ascendente){
        multiplicador = 1;
    } else{
        multiplicador = -1;
    }
}

    @Override
    public int compare(Song o1, Song o2) {
        if(o1.getDays() - o2.getDays() > 0) {
            return 1 * multiplicador;
        } else if (o1.getDays() - o2.getDays() < 0) {
            return -1 * multiplicador;
        } else {
            return 0;
        }
    }
    
}
