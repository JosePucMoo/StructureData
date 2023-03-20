
import dao.DaoCanciones;

public class App {
    public static void main(String[] args) throws Exception {
        

        DaoCanciones dao = new DaoCanciones();

        dao.escribirCancionesArchivo(2, true);



        
    }
}
