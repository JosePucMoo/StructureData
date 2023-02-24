package domain;

public class DELink <T>{
    private T dData;
    private DELink<T> next; 

    /**
     * Constructor que inicializa un nodo con el dato que almacenará.
     * @param dd Dato por almacenes del nodo.
     **/
    public DELink(T dd) {
        dData = dd;
    }

    /**
     * Este método constructor crea una nueva lista con un dato y uno siguiente
     * @param dd dato para almacenar en la lista
     * @param nextLink siguiente nodo que se va a insertar en la lista
     **/
    public DELink (T dd, DELink<T> nextLink){
        dData = dd;
        next = nextLink;
    }
    
    /**
     * Retorna el dato del nodo.
     * @return T dato genérico que se encuentra en la lista
     **/
    public T getData() {
        return dData;
    }

    /**
    * Establecer el elemento del nodo.
    * @param data Es el dato del nodo.
    **/
    public void setData(T data) {
        this.dData = data;
    }

    /**
     * Retorna el nodo siguiente.
     * @return DELink Enlace doble
     **/
    public DELink<T> getNextLink() {
        return next;
    }

    /**
     * Establece el siguiente nodo.
     * @param nextLink Es el siguiente nodo a establecer.
     **/
    public void setNextLink(DELink<T> nextLink) {
        this.next = nextLink;
    }

    /**
     *Muestra el dato que tiene almacenado el nodo;
     **/
    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }
}