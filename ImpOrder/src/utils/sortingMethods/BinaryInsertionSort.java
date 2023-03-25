package utils.sortingMethods;

import java.util.Comparator;
import java.util.LinkedList;
import domain.Song;


/**
 * Clase que crea un objeto para ordenar listas doblemente ligadas.
 */
public class BinaryInsertionSort {

    public static long tiempoTotal = 0;
    public static int numComparaciones = 0;
    public static int numIntercambios = 0;
 
    /**
     * Busca un elemento en la lista proporcionada  retorna su posición.
     * 
     * @param lista Lista donde se hará la busqueda del elemento.
     * @param item  Elemento por buscar en la lista.
     * @param low   Posición del elemento inferior de la lista.
     * @param high  Posición del elemento superior de la lista.
     * @param c     Comparador para los elementos de la lista.
     * @return      Retorna la posición del elemento en la lista.
     */
    private static int binarySearch(LinkedList<Song> lista, Song item, int low, int high,Comparator<? super Song> c){
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (c.compare(item, lista.get(mid)) == 0){
               numComparaciones++; //Comparacion
                return mid + 1;  
            }
            else if (c.compare(item, lista.get(mid)) > 0){
                numComparaciones++; //Comparacion
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return low;
    }

    /**
     * Ordena la lista proporcionada con el método de ordenamiento BinaryInsertionSort
     * @param lista Lista por ordenar.
     * @param n     Tamaño de la lista.
     * @param c     Comparador para los elementos de la lista.
     * @return      Retorna un LinkedList de canciones ordenadas.
     */
    public static LinkedList<Song> binaryInsertionSort(LinkedList<Song> lista, int n, Comparator<? super Song> c ) {
        int i, loc, j;
        Song selected;

        long inicio = System.currentTimeMillis(); //Inicio del conteo
    
        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = lista.get(i);
    
            // Encuentra la posicion donde debe ser insertado el elemento
            loc = binarySearch(lista, selected, 0, j, c);
    
            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {
                lista.set(j + 1, lista.get(j));
                numIntercambios++;// Numeros de intercambios
                j--;
            }
            lista.set(j + 1, selected);
        }

        long fin = System.currentTimeMillis(); // fin del cálculo de la ejecución

        tiempoTotal = (fin - inicio); //Total del cálculo de la ejecución del algoritmo

        return lista;
    }

}