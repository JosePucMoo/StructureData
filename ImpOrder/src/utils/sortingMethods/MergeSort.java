package utils.sortingMethods;

import java.util.Comparator;
import java.util.LinkedList;

import domain.Song;

public class MergeSort {
   private static Song[] theArray;        // ref to array theArray
   private static int nElems;               // number of data items
   private static long tiempoTotal;

   public MergeSort(int max)   {
      theArray = new Song[max];      // create array
      nElems = 0;
   }
   
   public void insert(Song value){
      theArray[nElems] = value;      // insert it
      nElems++;                      // increment size
   }

   public void display() {
      for(int j=0; j<nElems; j++)    // for each element,
         System.out.print(theArray[j] + " ");  // display it
      System.out.println("");
   }

   public static LinkedList<Song> mergeSort( LinkedList<Song> lista, Comparator<? super Song> c ) {
      theArray = new Song[lista.size()];
      theArray = transformarListToArray(lista);

      long inicio = System.nanoTime(); //inicio de la ejecución del algoritmo;
      Song[] workSpace = new Song[lista.size()];
      recMergeSort(workSpace, 0, lista.size()-1, c);

      long fin = System.nanoTime();

      tiempoTotal = fin - inicio;

      lista = transformarArrayToLista();

      return lista;
   }

   private static void recMergeSort(Song[] workSpace, int lowerBound, int upperBound, Comparator<? super Song> c ){
      if(lowerBound == upperBound)            // if range is 1,
         return;                              // no use sorting
      else {                                    
         int mid = (lowerBound+upperBound) / 2; // find midpoint        
         recMergeSort(workSpace, lowerBound, mid, c); // sort low half
         recMergeSort(workSpace, mid+1, upperBound, c); // sort high half
         merge(workSpace, lowerBound, mid+1, upperBound, c); // merge them
      }  // end else
   }  // end recMergeSort()

   private static void merge(Song[] workSpace, int lowPtr, int highPtr, int upperBound, Comparator<? super Song> c ) {
      int j = 0;                             // workspace index
      int lowerBound = lowPtr;
      int mid = highPtr-1;
      int n = upperBound-lowerBound+1;       // # of items

      while(lowPtr <= mid && highPtr <= upperBound)
         if( c.compare(theArray[lowPtr], theArray[highPtr]) < 0 )
            workSpace[j++] = theArray[lowPtr++];
         else
            workSpace[j++] = theArray[highPtr++];

      while( lowPtr <= mid)
         workSpace[j++] = theArray[lowPtr++];

      while(highPtr <= upperBound)
         workSpace[j++] = theArray[highPtr++];

      for(j=0; j<n; j++)
         theArray[lowerBound+j] = workSpace[j];
   }

   public static LinkedList<Song> transformarArrayToLista( ) {

      LinkedList<Song> lista = new LinkedList<>();
      int cont = 0;

      while(cont < theArray.length ) {
         lista.add(theArray[cont]);
         cont++;
      }

      return lista;
   }

   public static Song[] transformarListToArray(LinkedList<Song> lista ) {

      int cont = 0;

      while(cont < lista.size() ) {
         theArray[cont] = lista.get(cont);
         cont++;
      }

      return theArray;
   }
}
