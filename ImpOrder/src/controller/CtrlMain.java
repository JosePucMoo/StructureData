package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dao.DaoCanciones;
import domain.Song;
import utils.comparadores.ComparadorDeCancionesPorDuracion;
import utils.comparadores.ComparadorDeCancionesPorNombre;
import utils.sortingMethods.BinaryInsertionSort;
import utils.sortingMethods.MergeSort;

public class CtrlMain {

    DaoCanciones daoCanciones= new DaoCanciones();

    public void mostrarMenu(String archivoEntrada, String archivoSalida) throws IOException{
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        boolean ascedente = true;
        int opcion; //Guardaremos la opcion del usuario
        LinkedList<Song> lista;

        System.out.println("El siguiente programa ordena las 100 canciones top de spotify, usted puede elegir el método de ordenamiento, si desea ordenarlo por los nombres de las canciones o por la duración, igualmente si ascedente, descendete, alfabeticamente inverso o normal.");

        while (!salir) {
 
            System.out.println("1. Opcion 1: método BinaryInsertionSort ");
            System.out.println("2. Opcion 2: método MergeSort");
            System.out.println("3. Opcion 3: método QuickSort");
            System.out.println("4. Opcion 4: método RadixSort");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                System.out.println("__________________________________________________________");
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1: BinaryInsertionSort");

                        System.out.println("1. Opcion 1: ordenar por nombre ");
                        System.out.println("2. Opcion 2: ordenar por duración ");
                        System.out.println("Escribe una de las opciones");
                        opcion = sn.nextInt();
                        System.out.println("__________________________________________________________");
                        if(opcion == 1){
                            System.out.println("Escribe una de las opciones");
                            System.out.println("1. Opcion 1: ascendente ");
                            System.out.println("2. Opcion 2: descendente");
                            opcion = sn.nextInt();
                            System.out.println("__________________________________________________________");
                            if(opcion == 2){
                                ascedente = false;
                            }
                            lista = ordenarLista(opcion, new ComparadorDeCancionesPorNombre(ascedente));
                            daoCanciones.escribirArchivo( archivoSalida, lista);
                        }else if(opcion == 2) {
                            System.out.println("Escribe una de las opciones");
                            System.out.println("1. Opcion 1: ascendente ");
                            System.out.println("2. Opcion 2: descendente");
                            opcion = sn.nextInt();
                            System.out.println("__________________________________________________________");
                            if(opcion == 2){
                                ascedente = false;
                            }
                            lista = ordenarLista(opcion, new ComparadorDeCancionesPorDuracion(ascedente));
                            daoCanciones.escribirArchivo( archivoSalida, lista);
                        }
                        
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        System.out.println("El ordenamiento será por el método MergeSort");
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

    

}
