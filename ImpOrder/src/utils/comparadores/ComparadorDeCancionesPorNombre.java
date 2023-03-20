package utils.comparadores;

import java.util.Comparator;

import domain.Song;

public class ComparadorDeCancionesPorNombre implements Comparator<Song>{

    private int multiplicador;

    
    //Si el valor enviado al constructor es true entonces el método es ascendente
    //Si el valor enviado al constructor es false entonces el método es descendente
    public ComparadorDeCancionesPorNombre(boolean ascendente) {
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
       return multiplicador* (o1.getName().compareTo(o2.getName()));
    }
    
}
