package domain;

/**
 * Clase que genera un enlace (nodo) que almacena un tipo de dato generico y contiene el enlace siguiente y previo del nodo.
 */
public class DoublyLink<T> {
    private T dData; 
    private DoublyLink next; 
    private DoublyLink previous; 

    
    /**
     * Constructor que inicializa un nodo con el dato que almacenará.
     * @param d Dato por almacenar del nodo.
     */
    public DoublyLink(T d) { 
        dData = d; 
        next = null;
        previous = null;
    }

    /* 
     * Muestra el dato del nodo.
     */
    public void displayLink() { 
        System.out.print(dData + ","); 
    }

    
    /** 
     * Retorna el dato del nodo.
     * @return T
     */
    public T getdData() {
        return dData;
    }

    
    /** 
     * Establecer el elemento del nodo.
     * @param dData Es el dato del nodo.
     */
    public void setdData(T dData) {
        this.dData = dData;
    }

    
    /** 
     * Retorna el nodo siguiente.
     * @return DoublyLink
     */
    public DoublyLink getNext() {
        return next;
    }

    
    /** 
     * Establece el siguiente nodo.
     * @param next Es el siguiente nodo a establecer.
     */
    public void setNext(DoublyLink next) {
        this.next = next;
    }

    
    /** 
     * Retorna el nodo previo.
     * @return DoublyLink
     */
    public DoublyLink getPrevious() {
        return previous;
    }

    
    /** 
     * Establece el nodo previo.
     * @param previous E el nodo previo por enlazar al nodo actual.
     */
    public void setPrevious(DoublyLink previous) {
        this.previous = previous;
    }
}
