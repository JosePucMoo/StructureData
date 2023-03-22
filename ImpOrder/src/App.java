import controller.CtrlMain;


public class App {
    public static void main(String[] args) throws Exception {
        
       //if(args.length > 0 ) {

        
           CtrlMain controlMain = new CtrlMain();

           controlMain.mostrarMenu("dataset.csv", "SortMethod_ordenado.csv");
            
       // } else {
            System.out.println("No ha especificado ningún argumento");
        //}
        
        
    }
}
