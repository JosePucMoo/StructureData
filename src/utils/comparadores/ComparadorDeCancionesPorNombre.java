package utils.comparadores;

import java.util.Comparator;

import domain.Song;

/**
 * Esta clase proporciona la funcionalidad para comparar dos objetos de tipo Song con el atributo de nombre. Implementa Comparator.
 */
public class ComparadorDeCancionesPorNombre implements Comparator<Song>{

    private int multiplicador;
    public static boolean ascedente = true;
    

    /** Crea un objeto ComparadorDeCancionesPorNombre. Si se inicializa con true el comparador funciona de manera ascendente, si es false entonces descendente.
     * @ Si el valor enviado al constructor es true entonces el método es ascendente
     * @ Si el valor enviado al constructor es false entonces el método es descendente
     * @param ascendente
     */
    public ComparadorDeCancionesPorNombre(boolean ascendente) {
        ComparadorDeCancionesPorNombre.ascedente = ascendente;
        if(ascendente){
            multiplicador = 1;
        } else{
            multiplicador = -1;
        }
    }

    //Si el 1ro va antes que el 2do, retorna NEGATIVO
    //Si el 1ro va despues que el 2do, retorna POSITIVO
    //Si son iguales retorna 0
    @Override
    public int compare(Song o1, Song o2) {
       return multiplicador* (o1.getSong().toLowerCase().compareTo(o2.getSong().toLowerCase()));
    }
    
}
