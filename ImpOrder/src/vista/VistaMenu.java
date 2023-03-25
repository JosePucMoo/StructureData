package vista;

import java.util.Scanner;

public class VistaMenu {
    

    public int mostrarMenuColumnas(){
        int tipo = 0;
        Scanner sn = new Scanner(System.in);
        System.out.println("__________________________________________________________");
        System.out.println("1. Opcion 1: ordenar por nombre de la canción");
        System.out.println("2. Opcion 2: ordenar por número de días desde el lanzamiento de la canción");
        System.out.println("Escribe una de las opciones:");
        tipo = sn.nextInt();

        while(tipo != 1 && tipo != 2){
        System.out.println("**********************************************************");
        System.out.println("Opción inválida, ingrese una opción válida.");
        System.out.println("**********************************************************");
        System.out.println("1. Opcion 1: ordenar por nombre de la canción");
        System.out.println("2. Opcion 2: ordenar por número de días desde el lanzamiento de la canción");
        System.out.println("Escribe una de las opciones:");
        tipo = sn.nextInt();
        
        }
        
        return tipo;
    }

    public int mostrarMenuModo(){
        int modo = 0;
        Scanner sn = new Scanner(System.in);
        System.out.println("");
        System.out.println("__________________________________________________________");
        System.out.println("¿En qué modo desea ordenarlo?:");
        System.out.println("1. Opcion 1: ascendente ");
        System.out.println("2. Opcion 2: descendente");
        modo = sn.nextInt();
        
        while(modo != 1 && modo != 2){
        sn = new Scanner(System.in);
        System.out.println("**********************************************************");
        System.out.println("Opción inválida, ingrese una opción válida.");
        System.out.println("**********************************************************");
        System.out.println("¿En qué modo desea ordenarlo?:");
        System.out.println("1. Opcion 1: ascendente ");
        System.out.println("2. Opcion 2: descendente");
        modo = sn.nextInt();
        
        }

        return modo;
    }

    public int mostrarMenuSalir(){
        int opcion = 0;
        Scanner sn = new Scanner(System.in);
        System.out.println("¿Desea continuar?");
        System.out.println("1. Si");
        System.out.println("2. No");
        opcion = sn.nextInt();

        while( opcion  != 2 && opcion != 1){
        System.out.println("Ingrese uno de las dos opciones.");
        System.out.println("¿Desea continuar?");
        System.out.println("1. Si");
        System.out.println("2. No");
        opcion = sn.nextInt();
        }

        return opcion;
    }

    public void mostrarMenuPrincipal( ){
        System.out.println(" __________________________________________________________ ");
        System.out.println("|El siguiente programa ordena 1000 canciones de spotify,   |");
        System.out.println("|usted puede elegir el método de ordenamiento, si desea    |");
        System.out.println("|ordenarlo por los nombres de las canciones o por el número|");
        System.out.println("|de días desde el lanzamiento de la canción, puede hacer el|");
        System.out.println("|orden ascedente o descendete.                             |");
        System.out.println("|__________________________________________________________|");
        System.out.println("");
    }

    
}
