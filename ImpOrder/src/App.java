
import dao.DaoCanciones;
import utils.comparadores.ComparadorDeCancionesPorDuracion;

public class App {
    public static void main(String[] args) throws Exception {
        

        DaoCanciones dao = new DaoCanciones();

        dao.escribirArchivo(2, new ComparadorDeCancionesPorDuracion(true));



        
    }
}
