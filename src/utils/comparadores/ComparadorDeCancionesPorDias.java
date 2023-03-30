package utils.comparadores;

import java.util.Comparator;

import domain.Song;

/**
 * Esta clase proporciona la funcionalidad para comparar dos objetos de tipo Song con el atributo de días. Implementa Comparator.
 */
public class ComparadorDeCancionesPorDias implements Comparator<Song>{

    private int multiplicador;
    public static boolean ascedente = true;

/**
 * Constructor que crea un objeto ComparadorDeCancionesPorDia. Si se inicializa con true el comparador funciona de manera ascendente, si es false entonces descendente.
 * @param ascendente Booleano que determina el modo del comparador.
 */
public ComparadorDeCancionesPorDias(boolean ascendente ){
    ComparadorDeCancionesPorDias.ascedente = ascendente;

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
