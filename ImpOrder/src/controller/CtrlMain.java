package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dao.DaoCanciones;
import dao.DaoMetricas;
import domain.Song;
import utils.comparadores.ComparadorDeCancionesPorDias;
import utils.comparadores.ComparadorDeCancionesPorNombre;
import utils.sortingMethods.BinaryInsertionSort;
import utils.sortingMethods.MergeSort;

public class CtrlMain {

    DaoCanciones daoCanciones= new DaoCanciones();
    DaoMetricas daoMetricas = new DaoMetricas();
    Scanner sn = new Scanner(System.in);
    LinkedList<Song> lista;

    public void mostrarMenu( ) throws IOException{
        
        boolean salir = false;
        boolean ascedente = true;
        int opcion, tipo, modo; //Guardaremos la opcion del usuario

        System.out.println("El siguiente programa ordena las 100 canciones top de spotify, usted puede elegir el método de ordenamiento, si desea ordenarlo por los nombres de las canciones o por la duración, igualmente si ascedente, descendete, alfabeticamente inverso o normal.");

        while (!salir) {
            
            try {
                tipo = submenu2();
                modo = submenu3();
                String linea;
                String asc = "Ascendente";

                if(modo == 2){
                    ascedente = false;
                    asc = "Descendente";
                }

                Comparator comparator;
                if(tipo == 1){
                    comparator = new ComparadorDeCancionesPorNombre(ascedente);
                    linea = "Nombre de Cancion";
                }else {
                    comparator = new ComparadorDeCancionesPorDias(ascedente);
                    linea = "Dias desde el Lanzamiento";
                }
                
                linea += "," + asc;
                
                procedimientos(linea, comparator);
                     
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
            
            System.out.println("¿Desea continuar?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = sn.nextInt();
            if( opcion == 2) {
                salir = true;
            }
        }
    }

    public LinkedList<Song> ordenarLista( int opcion, Comparator<? super Song> comparator ) throws FileNotFoundException {
        LinkedList<Song> lista = daoCanciones.traerCanciones(); //Leer el archivo CSV donde están las canciones
        
        switch(opcion){ //Cada opción representa un método de ordenamiento
            case 1: //Ordenar por metodo binaryInsertionSort
                lista = BinaryInsertionSort.binaryInsertionSort(lista, lista.size(), comparator);
                break;
            case 2:  //Ordenar por metodo mergeSort
                lista = MergeSort.mergeSort(lista, comparator);
                break;
            default: JOptionPane.showMessageDialog(null, "Opción inválida");
                break;
        }

        return lista;
    }

    public void procedimientos(String linea, Comparator<? super Song> comparator) throws IOException{
        String metricas = "";
        ArrayList<String> listaMetricas = new ArrayList<>();
        listaMetricas.add("Method, Column, Mode, EjecutionTime, Comparations, Interchanges");
        
        lista = ordenarLista(1, comparator); // Ordenar lista por BinaryInsertionSort
        daoCanciones.escribirArchivo( "BinaryInsertionSort.csv", lista); // Escribir en archivo
        metricas =  "BinaryInsertionSort" + "," + linea + "," + BinaryInsertionSort.tiempoTotal + "," + BinaryInsertionSort.numComparaciones + "," + BinaryInsertionSort.numIntercambios;
        listaMetricas.add(metricas);
                
        lista = ordenarLista(2, comparator); // Ordenar lista por BinaryInsertionSort
        daoCanciones.escribirArchivo( "MergeSorth_Ordenado.csv", lista); // Escribir en archivo
        metricas = "MergeSort" + "," +  linea + "," + MergeSort.tiempoTotal + "," + MergeSort.numComparaciones + "," + MergeSort.numIntercambios;
        listaMetricas.add(metricas);



        daoMetricas.escribirArchivoMetricas( listaMetricas); //Manda las metricas para el archivo de metricas
            
        
    }
    
    public int submenu2(){
        System.out.println("1. Opcion 1: ordenar por nombre de la canción");
        System.out.println("2. Opcion 2: ordenar por número de días desde el lanzamiento de la canción");
        System.out.println("Escribe una de las opciones");
        int tipo = sn.nextInt();
        System.out.println("__________________________________________________________");
        return tipo;
    }

    public int submenu3(){
        System.out.println("Escribe una de las opciones");
        System.out.println("1. Opcion 1: ascendente ");
        System.out.println("2. Opcion 2: descendente");
        int modo = sn.nextInt();
        System.out.println("__________________________________________________________");
        return modo;
    }

}
