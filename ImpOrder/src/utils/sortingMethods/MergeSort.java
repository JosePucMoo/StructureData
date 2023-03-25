package utils.sortingMethods;

import java.util.Comparator;
import java.util.LinkedList;
import domain.Song;

/**
 * Clase que crea un objeto MergeSort el cual funciona para ordenar LinkedList con el método de ordenamiento MergeSort.
 */
public class MergeSort{
   private  static LinkedList<Song> theArray;      // ref to array theArray
   public static long tiempoTotal = 0;
   public static int numComparaciones = 0;
   public static int numIntercambios = 0;


   /**
    * @param lista Lista por ordenar con metodo merge sort.
    * @param c Comparador para los elemtos de la lista.
    * @return  Regresa una LinkedList de canciones ordenadas.
    */
   public static LinkedList<Song> mergeSort( LinkedList<Song> lista, Comparator<? super Song> c ) {
      theArray = lista;
      long inicio = System.currentTimeMillis(); //inicio de la ejecución del algoritmo;
      LinkedList<Song> workSpace = new LinkedList<>();
      recMergeSort(workSpace, 0, lista.size()-1, c);

      long fin = System.currentTimeMillis();

      tiempoTotal = fin - inicio;

      return MergeSort.theArray;
   }

   /**
    * Ordena la lista con recursividad.

    * @param workSpace  LinkedList de canciones.
    * @param lowerBound Posición inferior de la lista.
    * @param upperBound Posición superior de la lista.
    * @param c Comparador de elementos de la lista.
    */
   private static void recMergeSort(LinkedList<Song> workSpace, int lowerBound, int upperBound, Comparator<? super Song> c ){
      

      if(lowerBound == upperBound)            // if range is 1,
         return;                              // no use sorting
      else {                                    
         int mid = (lowerBound+upperBound) / 2; // find midpoint        
         recMergeSort(workSpace, lowerBound, mid, c); // sort low half
         recMergeSort(workSpace, mid+1, upperBound, c); // sort high half
         merge(workSpace, lowerBound, mid+1, upperBound, c); // merge them
      }  // end else
   }  // end recMergeSort()

   /**
    * Se encarga de intercalar los elementos de las dos divisiones.

    * @param workSpace  Linkedlist donde se van intercalando las dos listas.
    * @param lowPtr     Posición inferior de la lista.
    * @param highPtr    Posición superior de la lista.
    * @param upperBound Posición superior de la lista.
    * @param c          Comparador para los elementos de la lista.
    */
   private static void merge(LinkedList<Song> workSpace, int lowPtr, int highPtr, int upperBound, Comparator<? super Song> c ) {
      int j = 0;                             // workspace index
      int lowerBound = lowPtr;
      int mid = highPtr-1;
      int n = upperBound-lowerBound+1;       // # of items
      
      workSpace = new LinkedList<>(theArray);

      while(lowPtr <= mid && highPtr <= upperBound){

         if( c.compare(theArray.get(lowPtr), theArray.get(highPtr) ) < 0 ){
            
            workSpace.set(j++, theArray.get(lowPtr++));
             numComparaciones++;
             numIntercambios++;  
         } 
         else{
               workSpace.set(j++, theArray.get(highPtr++));
            numIntercambios++;
         }
      }

      while( lowPtr <= mid){
         workSpace.set(j++, theArray.get(lowPtr++));
         numIntercambios++;
      }
         
      while(highPtr <= upperBound){
         workSpace.set(j++, theArray.get(highPtr++));
         numIntercambios++;
      }
         
      for(j=0; j<n; j++)
      theArray.set(lowerBound+j, workSpace.get(j));
         numIntercambios++;
   }
}
