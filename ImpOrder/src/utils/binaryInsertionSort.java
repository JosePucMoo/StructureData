package utils;

import java.util.Comparator;
import java.util.LinkedList;

import domain.Song;

public class binaryInsertionSort {
    //  implementacion iterativa 
    public static <T> int binarySearch(LinkedList<Song> lista, Song item, int low, int high,Comparator<? super Song> c){
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (c.compare(item, lista.get(mid)) == 0)
                return mid + 1;
            else if (c.compare(item, lista.get(mid)) > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static <T> LinkedList<Song> binaryInsertionSort(LinkedList<Song> lista, int n, Comparator<Song> c ) {
        int i, loc, j, k;
        Song selected;
    
        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = lista.get(i);
    
            // encuentra la posicion donde debe ser insertado el elemento
            loc = binarySearch(lista, selected, 0, j, c);
    
            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, selected);
        }

        return lista;
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
}
