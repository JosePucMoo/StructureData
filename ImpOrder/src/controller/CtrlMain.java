package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
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

    public void mostrarMenu(String archivoEntrada, String archivoSalida) throws IOException{
        
        boolean salir = false;
        boolean ascedente = true;
        int opcion, tipo, modo; //Guardaremos la opcion del usuario

        System.out.println("El siguiente programa ordena las 100 canciones top de spotify, usted puede elegir el método de ordenamiento, si desea ordenarlo por los nombres de las canciones o por la duración, igualmente si ascedente, descendete, alfabeticamente inverso o normal.");

        while (!salir) {
 
            try {

                opcion = submenu1();

                switch (opcion) {
                    case 1:
                        tipo = submenu2("BinaryInsertionSort", 1);
                        if(tipo == 1){
                            modo = submenu3();
                            if(modo == 2){
                                ascedente = false;
                            }
                            procedimientos(opcion, new ComparadorDeCancionesPorNombre(ascedente), archivoSalida);

                        }else if(tipo == 2) {
                            modo = submenu3();
                            if(modo == 2){
                                ascedente = false;
                            }
                            procedimientos(opcion, new ComparadorDeCancionesPorDias(ascedente), archivoSalida);
                        }
                        
                        break;
                    case 2:
                    tipo = submenu2("MergeSort", 2);
                    if(tipo == 1){
                        modo = submenu3();
                        if(modo == 2){
                            ascedente = false;
                        }
                        procedimientos(opcion, new ComparadorDeCancionesPorNombre(ascedente), archivoSalida);

                    }else if(tipo == 2) {
                        modo = submenu3();
                        if(modo == 2){
                            ascedente = false;
                        }
                        procedimientos(opcion, new ComparadorDeCancionesPorDias(ascedente), archivoSalida);
                    }
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        System.out.println("El ordenamiento será por el método QuickSort");
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        System.out.println("El ordenamiento será por el método RadixSort");
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
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

    public void procedimientos(int opcion, Comparator<? super Song> comparator, String archivoSalida ) throws IOException{
        lista = ordenarLista(opcion, comparator); // Ordenar lista
        daoCanciones.escribirArchivo( archivoSalida, lista); // Escribir en archivo
        String metricas = "";
        switch(opcion){
            case 1: metricas = BinaryInsertionSort.tiempoTotal + "," + BinaryInsertionSort.numComparaciones + "," + BinaryInsertionSort.numIntercambios;
                break;
            case 2: metricas = MergeSort.tiempoTotal + "," + MergeSort.numComparaciones + "," + MergeSort.numIntercambios;
                break;
            case 3:
                break;
            case 4: 
                break;
            default: System.out.println("Error en opción, metodo precedimientos");
                break;
        }
        
        daoMetricas.escribirArchivoMetricas(opcion-1, metricas);
    }
    public int submenu1(){
        System.out.println("1. Opcion 1: método BinaryInsertionSort ");
        System.out.println("2. Opcion 2: método MergeSort");
        System.out.println("3. Opcion 3: método QuickSort");
        System.out.println("4. Opcion 4: método RadixSort"); 
        System.out.println("5. Salir");
        System.out.println("Escribe una de las opciones");
        int opcion = sn.nextInt();
        System.out.println("__________________________________________________________");
        return opcion;
    }
    
    public int submenu2(String metodo, int opcion){
        System.out.println("Has seleccionado la opcion "+ opcion +": "+ metodo);
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
