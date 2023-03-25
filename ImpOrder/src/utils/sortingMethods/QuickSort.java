package utils.sortingMethods;

import java.util.Comparator;
import java.util.LinkedList;

import domain.Song;

public class QuickSort {
    public static long tiempoTotal = 0;
    public static int numComparaciones = 0;
    public static int numIntercambios = 0;

    public static <T> LinkedList<Song> quickSort(LinkedList<Song> lista, Comparator<? super Song> c){
        long inicio = System.currentTimeMillis();
        lista = quickSort1(lista, c);
        long fin = System.currentTimeMillis();
        tiempoTotal = fin - inicio;
        return lista;
    }

    public static <T> LinkedList<Song> quickSort1(LinkedList<Song> lista, Comparator<? super Song> c){
        return quickSort2(lista, 0, lista.size() - 1, c);
    }

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
