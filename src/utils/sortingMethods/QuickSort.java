package utils.sortingMethods;

import java.util.Comparator;
import java.util.LinkedList;

import domain.Song;

/**
 * Clase que crea un objeto para ordenar listas doblemente ligadas.
 */
public class QuickSort {
    public static long tiempoTotal = 0;
    public static int numComparaciones = 0;
    public static int numIntercambios = 0;

    /**
    * @param lista Lista por ordenar con metodo radix sort.
    * @param c Comparador para los elemtos de la lista.
    * @return  Regresa una LinkedList de canciones ordenadas.
    */
    public static <T> LinkedList<Song> quickSort(LinkedList<Song> lista, Comparator<? super Song> c){
        long inicio = System.currentTimeMillis();
        lista = quickSort1(lista, c);
        long fin = System.currentTimeMillis();
        tiempoTotal = fin - inicio;
        return lista;
    }

    /**
    * @param lista  LinkedList de canciones.
    * @param c Comparador de elementos de la lista.
    * @return  Regresa una LinkedList de canciones ordenadas.
    */
    public static <T> LinkedList<Song> quickSort1(LinkedList<Song> lista, Comparator<? super Song> c){
        return quickSort2(lista, 0, lista.size() - 1, c);
    }

    /**
    * Ordena la lista con recursividad.
    * @param lista  LinkedList de canciones.
    * @param izq Posición inferior de la lista.
    * @param der Posición superior de la lista.
    * @param c Comparador de elementos de la lista.
    * @return  Regresa una LinkedList de canciones ordenadas.
    */
    public static <T> LinkedList<Song> quickSort2(LinkedList<Song> lista, int izq, int der, Comparator<? super Song> c){
        if(izq>=der)
            return lista;
        int i=izq, d=der;
        if(izq!=der){
            int pivote;
            Song aux;
            pivote = izq;
            while (izq!=der){
                while (c.compare(lista.get(der), lista.get(pivote)) >= 0 && izq<der){ 
                    numComparaciones++;
                    der--;
                }
                while (c.compare(lista.get(izq), lista.get(pivote)) < 0 && izq<der){
                    izq++;
                    numComparaciones++;
                }                     
                if (der!=izq){
                aux = lista.get(der);
                lista.set(der, lista.get(izq));
                lista.set(izq, aux);
                numIntercambios++;
                }
            }
            if (izq == der) {
                quickSort2 (lista,i,izq-1,c); 
                quickSort2 (lista, izq+1,d,c);
                }
        }
        else
            return lista;
        return lista;
    }
}
