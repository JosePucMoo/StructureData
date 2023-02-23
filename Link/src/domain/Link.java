package domain;

/**
 * Clase Link, genera un enlaze (nodo) con tipo de dato genérico y con su enlaze al siguiente nodo.
 */
public class Link<T> {
    private T data; // Stored data 
    private Link nextLink; // Link pointer


    
    /**
     * Constructor que inicializa un nodo mandandole el dato que almacenará dicho nodo;
     * @param dato Dato que guardará el nodo.
     */
    public Link(T dato){
        this.data = dato;
        this.nextLink = null;
    }


    
    /**
     * Constructor de un enlaze (nodo).
     * @param data Dato que almacenará el nodo.
     * @param nextLink Siguiente enlaze del nodo creado.
     */
    public Link (T data, Link nextLink){
        this.data = data;
        this.nextLink = nextLink;

    }


    /** 
     * Retorna el dato del nodo.
     * @return Un dato tipo T
     */
    public T getData() {
        return data;
    }


    
    /** 
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }


    public Link getNextLink() {
        return nextLink;
    }


    public void setNextLink(Link nextLink) {
        this.nextLink = nextLink;
    }
    
    /**
     *Muestra el dato que tiene almacenado el nodo;
     */
    public void printLink( ) {
        System.out.print("{" + data + "} " );
    }
    


}
