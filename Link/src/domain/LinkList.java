package domain;

import exceptions.ErrorDeleteItem;

/**
 * Clase que genera una lista enlazada con tipo de datos Link's.
 */
public class LinkList<T> {
    private Link<T> firstLink;

    /**
     * Constructor que inicializa una lista enlazada con el primer nodo igual a nulo;
     */
    public LinkList(){
        firstLink = null;
    }


    /**
     * Inserta un nuevo elemento al principio de la lista.
     * @param data Dato del nodo que será ingresado a la lista.
     */
    public void insertFirst( T data) {
        firstLink = new Link<T>(data, firstLink);
    }


    /**
     * Inserta un nuevo elemento al final de la listsa.
     * @param data Dato del nodo que será ingresado a la lista.
     */
    public void insertLast ( T data) {
        Link<T> current = this.firstLink;

        if(isEmpty()) {
            insertFirst(data);
        } else {
            while(current != null ) {
                if (current.getNextLink() == null ) {
                    Link<T> newLink = new Link<T>(data, null);
                    current.setNextLink(newLink);
                    current = null;
                } else {
                    current = current.getNextLink();
                }
            }
        }

    }

    /**
     * Elimina el primer elemento de la lista.
     * @throws ErrorDeleteItem Si la lista se encuentra vacía entonces lanza la excepción.
     */
    public void deleteFirst( ) throws ErrorDeleteItem{
        if( firstLink == null){
            throw new ErrorDeleteItem("The list hasn't elements");
        } 

        this.firstLink = this.firstLink.getNextLink();
        
    }

    /**
     * Elimina el último elemento de la lista.
     * @throws ErrorDeleteItem Si la lista se encuentra vacía lanza la excepci+on.
     */
    public void deleteLast( ) throws ErrorDeleteItem{ 
        Link<T> current = this.firstLink;
        if( firstLink == null){
            throw new ErrorDeleteItem("The list hasn't elements");
        } 

        while(current.getNextLink().getNextLink() != null ) {
            current = current.getNextLink();
        }
        current.setNextLink(null);
        //lastLink = current;
    }


    /**
     * Encuentra un elemento de la lista y la retorna. No elimina el elemento de la lista.
     * @param data Elemento por encontrar.
     * @return Link
     * @throws ErrorDeleteItem Si el elemento por encontrar no existe entonces lanza la excepción.
     */
    public Link<T> findLink ( T data) throws ErrorDeleteItem {
        Link<T> current = this.firstLink;

        while(current.getData() != data ) {
            if (current.getNextLink() == null ){
                throw new ErrorDeleteItem("Element doesn't exist in the list");
            } else {
                current = current.getNextLink();
            }
        }

        return current;
    }


    /**
     * Encuentra un elemento y retorna su posición en la lista.
     * @param data Elemento por encontrar.
     * @return int
     * @throws ErrorDeleteItem Si el elemento por encontrar no existe en la lista lanza la excepci+on.
     */
    public int findPosition( T data) throws ErrorDeleteItem{
        Link<T> current = this.firstLink;
        int cont = 0;

        if( isEmpty()) {
            throw new ErrorDeleteItem("Element doesn't exist in the list");
        } else {
            while(current != null ) {
                if( current.getData() == data) {
                    return cont;
                }else {
                    cont++;
                    current = current.getNextLink();
                }
            }
        }
        throw new ErrorDeleteItem("Element doesn't exist in the list");
    }


    /**
     * Elimina un elemento de la lista especificado.
     * @param data Dato por eliminar en la lista.
     * @throws ErrorDeleteItem Si la lista está vacía lanza la excepcióon.
     */
    public void deleteLink ( T data ) throws ErrorDeleteItem {
        if(isEmpty() ) {
            throw new ErrorDeleteItem("List is empty");
        }
        int position = findPosition(data);
        deleteAt(position);
    }


    /**
     * Elimina un elemento de la lista especificado por su posición.
     * @param index Posición del elemento por eliminar.
     * @throws ErrorDeleteItem Si la lista está vacía lanza la excepción.
     */
    public void deleteAt ( int index) throws ErrorDeleteItem {
        Link<T> current = this.firstLink;

        if( isEmpty()){
            throw new ErrorDeleteItem("List is empty");
        } 

        if( index == 0){
            firstLink = current.getNextLink();
        }

        //Almacenar el elemento previo al nodo por eliminar
        for(int i= 0; current != null && i < index - 1; i++ ){
            current = current.getNextLink();
        }

        // Caso cuando index es mayor al número de elementos
        if( current == null || current.getNextLink() == null) {

        }

        //current.getNext() es el elemento a eliminar

        //Almacenar en una variable temporal el elemento anterior
        Link<T> temp = current.getNextLink().getNextLink();
        current.setNextLink(temp);
    } 


    /**
     * Retorna el tamaño de la posición.
     * @return int
     */
    public int size( ) {
        Link<T> current = this.firstLink;
        int cont = 0;
        while(current != null ){
            cont++;
            current = current.getNextLink();
        }

        return cont;
    }
    

    /**
     * Si la lista está vacía retorna true, si no retorna false.
     * @return boolean.
     */
    public boolean isEmpty( ){
        return ( firstLink == null);
    }


    /**
     * Retorna el nodo especificado por una posición.
     * @param index Posición del elemento.
     * @return Link
     * @throws ErrorDeleteItem Si la posición ingresada está fuera del tamaño emtomces lanza la excepción.
     */
    public Link<T> getElementAt( int index) throws ErrorDeleteItem {
        Link<T> current = this.firstLink;
        int cont = 0;
        while(current !=  null ){
            if(cont == index  ){
                return current;
            } else {
                cont++;
                current = current.getNextLink();
            }
        }
        throw new ErrorDeleteItem("Index is out of range");
    }

    
    /**
     * Retorna el primer nodo de la lista.
     * @return Link
     * @throws ErrorDeleteItem Si la lista está vacía lanza la excepción.
     */
    public Link<T> getFirstElement( ) throws ErrorDeleteItem{
        if(isEmpty() ) {
            throw new ErrorDeleteItem("The list is empty");
        } 
        return firstLink;
    }

    
    /**
     * Retorna el último nodo de la lista.
     * @return Link
     * @throws ErrorDeleteItem Si la lista está vacía lanza la excepción.
     */
    public Link<T> getLastElement( ) throws ErrorDeleteItem {
        Link<T> current = this.firstLink;

        if(isEmpty() ) {
            throw new ErrorDeleteItem("The list is empty");
        } 
        
        while(current.getNextLink() != null ){
            current = current.getNextLink();
        }

        return current;
    }

     
    /**
     * Limpia la lista, eliminando cada elemento en él.
     * @throws ErrorDeleteItem Si la lista está vacía lanza la excepción.
     */
    public void cleanList( ) throws ErrorDeleteItem{
        
        while(this.firstLink != null ) {
            deleteFirst();
        }
    }

    
    /**
     * Actualiza el dato de un nodo especificado por la posición.
     * @param index Posición del nodo por actualizar.
     * @param data Nuevo dato para el nodo.
     * @throws ErrorDeleteItem Si está vacía la lista o si el índice propocionado está fuera del rango del la lista lanza la excepción.
     */
    public void replaceDataIndex(int index, T data ) throws ErrorDeleteItem {
        Link<T> current = this.firstLink;
        int cont = 0;

        if(isEmpty() ) {
            throw new ErrorDeleteItem("The list is empty");
        } 

        while(current != null ){
            if(cont == index ) {
                current.setData(data);
                return;
            } else{
                cont++;
                current = current.getNextLink();
            }
        }

        throw new ErrorDeleteItem("The index is over range");

    }

    
    /**
     * Reemplaza el dato existente de un nodo, actualizandolo por otro dato.
     * @param data Dato actual del nodo.
     * @param newdata Dato nuevo del nodo.
     * @throws ErrorDeleteItem  Si la lista está vacía o si el dato no existe en la lista, entonces lanza la excepción.
     */
    public void replaceData(int data, T newdata ) throws ErrorDeleteItem {
        Link<T> current = this.firstLink;

        if(isEmpty() ) {
            throw new ErrorDeleteItem("The list is empty");
        } 
        while(current != null ) {
            if( current.getData() == (Integer)data) {
                current.setData(newdata);
                return;
            } else {
                current = current.getNextLink();
            }
        }
        throw new ErrorDeleteItem("Data doesn't exist");
        
    }


    /**
     * Inserta un nodo en la lista, pasandole el dato y el tipo de ordenamiento. 
     * @param data Dato que almacenará el nodo por insertar.
     * @param order Tipo de ordanamiento, 'a' es ascendente y 'd' es descendente.
     * @throws ErrorDeleteItem Si el ordenamiento no es 'a' o 'd' entonces lanza la excepción,
     */
    public void insertOrdered(T data, char order ) throws ErrorDeleteItem {
        Link<T> current = this.firstLink;

        if(isEmpty() ){
            insertFirst(data);
            return;
        }

        switch(order){
            case 'a':  
                    if( (Integer)this.firstLink.getData() > (Integer)data){
                        insertFirst(data);
                        return;
                    }
                    while(current.getNextLink() != null ) {
                        current = current.getNextLink();
                    }
                    if((Integer)current.getData() < (Integer)data ) {
                        insertLast(data);
                        return;
                    }
                    
                    current = this.firstLink;
                    while(current != null ) {
                        if((Integer) current.getData() < (Integer)data ){
                            Link<T> newLink = new Link<T>(data, current.getNextLink());
                            current.setNextLink(newLink);
                            return;
                        } else {
                            current = current.getNextLink();
                        }
                    }
                break;
            case 'd':
                    if( (Integer)this.firstLink.getData() < (Integer)data){
                        insertFirst(data);
                        return;
                    }
                    while(current.getNextLink() != null ) {
                        current = current.getNextLink();
                    }
                    if((Integer)current.getData() > (Integer)data ) {
                        insertLast(data);
                        return;
                    }
                    
                    Link<T> temp = current;
                    while(current != null ) {
                        if( (Integer)data > (Integer)getFirstElement().getData()) {
                            insertFirst(data);
                            return;
                        }else {
                            if((Integer) current.getData() < (Integer)data ){
                                Link<T> newLink = new Link<T>(data, current);
                                temp.setNextLink(newLink);
                                return;
                            } else {
                                current = current.getNextLink();
                            }
                        }
                        
                    }
                break;
            default:  throw new ErrorDeleteItem("The char wasn't a or d");
        }

    
    }


    /**
     * Muestra el conteniendo de la lista y sus elementos.
     */
    public void showList(){
        Link<T> current = firstLink;

        System.out.print("List = ( first --->");
        while(current != null ){
            current.printLink();
            current = current.getNextLink();
        }
        System.out.print("<--- last)\n");
    }




}
