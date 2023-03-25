package utils.sortingMethods;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import domain.Song;

public class RadixSort {

    public static long tiempoTotal = 0;
    public static int numComparaciones = 0;
    public static int numIntercambios = 0;

    public static <T> LinkedList<Song> radixSort(LinkedList<Song> lista, boolean t) {
        long inicio = System.currentTimeMillis();
        int max = getMax(lista);
        for (int exp = 1; max / exp > 0; exp *= 10)
            lista = radixSort(lista, exp, t);

        long fin = System.currentTimeMillis(); 
        tiempoTotal = (fin - inicio);

        return lista;
    }

    public static <T> LinkedList<Song> radixSort(LinkedList<Song> lista, int exp, boolean t) {
        if (lista == null || lista.size() < 2) {
            return lista;
        }

        final int RADIX = 10;
        int maxLength = getMax(lista);

        for (int i = 0; i < maxLength; i++) {
            List<List<Song>> buckets = new ArrayList<>(RADIX);

            for (int j = 0; j < RADIX; j++) {
                buckets.add(new ArrayList<>());
            }

            for (Song song : lista) {
                int digit = getDigit(song, i);
                buckets.get(digit).add(song);
                numIntercambios++;
            }

            lista.clear();
            if(t){
                for (List<Song> bucket : buckets) {
                    lista.addAll(bucket);
                }
            }else{
                for (int j = RADIX - 1; j >= 0; j--) {
                    lista.addAll(buckets.get(j));
                }
            }
        }
        return lista;
    }

    public static int getNumDigits(int num) {
        if (num == 0) {
            return 1;
        }

        int count = 0;

        while (num != 0) {
            count++;
            num /= 10;
        }

        return count;
    }

    public static int getDigit(Song song, int position) {
        int duration = song.getDays();
        return (duration / (int) Math.pow(10, position)) % 10;
    }

    static int getMax(LinkedList<Song> lista) {
        int max = Integer.MIN_VALUE;

        for (Song song : lista) {
            int digits = getNumDigits(song.getDays());
            max = Math.max(max, digits);
        }

        return max;
    }

}
