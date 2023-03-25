package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import dao.DaoCanciones;
import dao.DaoMetricas;
import domain.Song;
import utils.comparadores.ComparadorDeCancionesPorDias;
import utils.comparadores.ComparadorDeCancionesPorNombre;
import utils.sortingMethods.BinaryInsertionSort;
import utils.sortingMethods.MergeSort;
import utils.sortingMethods.QuickSort;
import utils.sortingMethods.RadixSort;
import vista.VistaMenu;

public class CtrlMain {

    DaoCanciones daoCanciones= new DaoCanciones();
    DaoMetricas daoMetricas = new DaoMetricas();
    VistaMenu vista = new VistaMenu();

    public void ordenarListasDeCanciones( ) throws IOException{
        
        boolean salir = false;
        boolean ascedente = true;
        int opcion, tipo, modo; //Guardaremos la opcion del usuario

        vista.mostrarMenuPrincipal();

        while (!salir) {

            tipo = vista.mostrarMenuColumnas();
            modo = vista.mostrarMenuModo();

            if(modo == 2){ //Si el modo seleccionado es 0 entonces es descendiente  
                ascedente = false;
            }

            Comparator<Song> comparator = null;    

            if(tipo == 1){ // Se define el tipo de comparador par usar
                comparator = new ComparadorDeCancionesPorNombre(ascedente);
            }else {
                comparator = new ComparadorDeCancionesPorDias(ascedente);
            }
                

            LinkedList<Song> lista = new LinkedList<Song>();

            for(int i = 1; i < 5; i++){
                lista = ordenarLista(i, comparator, ascedente);
                escribirListasDocumento(i, lista);
            }

            escribirMetricas(tipo, modo);


            opcion = vista.mostrarMenuSalir();
            
            if( opcion == 2) { //Si es 1 entonces salimos del programa, si no entonces nos mantenemos en el.
                salir = true;
            } 
        }
    }

    public LinkedList<Song> ordenarLista( int opcion, Comparator<? super Song> comparator, boolean ascendente) throws FileNotFoundException {
        LinkedList<Song> lista = daoCanciones.traerCanciones(); //Leer el archivo CSV donde están las canciones

        switch(opcion){ //Cada opción representa un método de ordenamiento
            case 1: //Ordenar por metodo binaryInsertionSort
                lista = BinaryInsertionSort.binaryInsertionSort(lista, lista.size(), comparator);
                break;
            case 2:  //Ordenar por metodo mergeSort
                lista = MergeSort.mergeSort(lista, comparator);
                break;
            case 3:  //Ordenar por metodo mergeSort
                lista = QuickSort.quickSort(lista, comparator);
                break;
            case 4:
                lista = RadixSort.radixSort(lista,ascendente);
                break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida");
                break;
        }

        return lista;
    }


    public void escribirListasDocumento(int opcion, LinkedList<Song> lista ) throws IOException{
        switch(opcion){ //Cada opción representa un método de ordenamiento
            case 1: //Escribir el archivo binaryInsertionSort
                daoCanciones.escribirArchivo( "BinaryInsertionSort.csv", lista); // Escribir en archivo
                break;
            case 2:  //Escribir el archivo mergeSort
                daoCanciones.escribirArchivo( "MergeSorth_Ordenado.csv", lista); // Escribir en archivo
                break;
            case 3:  //Escribir el archivo mergeSort
                daoCanciones.escribirArchivo( "QuickSort_Ordenado.csv", lista); // Escribir en archivo
                break;
            case 4:
                //Escribir el archivo RadixSort
                daoCanciones.escribirArchivo( "RadixSort_Ordenado.csv", lista); // Escribir en archivo
                break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida");
                break;
        }
    }

    public void escribirMetricas(int columna, int modo) throws IOException{
        String metricas = "";
        ArrayList<String> listaMetricas = new ArrayList<>();
        listaMetricas.add("Method, Column, Mode, EjecutionTime(ms), Comparations, Interchanges");

        String linea = "";
        switch(columna){
            case 1: 
                linea = "Nombre de Cancion";
                break;
            case 2:
                linea = "Dias desde el Lanzamiento";
                break;
            default: System.out.println("Tipo inválido");;
                break;
        }

        switch(modo){
            case 1: 
                linea += "Ascendente";
                break;
            case 2:
                linea += "Descendente";
        }


         //Cada opción representa un método de ordenamiento
             //Ordenar por metodo binaryInsertionSort
                metricas =  "BinaryInsertionSort" + "," + linea + "," + BinaryInsertionSort.tiempoTotal + "," + BinaryInsertionSort.numComparaciones + "," + BinaryInsertionSort.numIntercambios;
                listaMetricas.add(metricas);
                
            //Ordenar por metodo mergeSort
                metricas = "MergeSort" + "," +  linea + "," + MergeSort.tiempoTotal + "," + MergeSort.numComparaciones + "," + MergeSort.numIntercambios;
                listaMetricas.add(metricas);
                //Ordenar por metodo mergeSort
                metricas = "QuickSort" + "," +  linea + "," + QuickSort.tiempoTotal + "," + QuickSort.numComparaciones + "," + QuickSort.numIntercambios;
                listaMetricas.add(metricas);
                
                metricas = "RadixSort" + "," +  linea + "," + RadixSort.tiempoTotal + "," + RadixSort.numComparaciones + "," + RadixSort.numIntercambios;
                listaMetricas.add(metricas);
                
        

        daoMetricas.escribirArchivoMetricas( listaMetricas); //Escribe las metricas para el archivo de metricas   
    }

}
