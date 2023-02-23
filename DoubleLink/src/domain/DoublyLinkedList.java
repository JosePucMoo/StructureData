package domain;

import exception.ErrorDoubleLinkedList;

/**
 * Clase que crea una lista doblemente ligada.
 */
public class DoublyLinkedList<T>{
    private DoublyLink<T> first; 
    private DoublyLink<T> last; 
    
    /**
     * Constructor que inicializa una DoublyLinkedList  con un nodo first y last nulos.
     */
    public DoublyLinkedList() {
        first = null; 
        last = null;
    }

    
    /** 
     * Si la lista se encuentra vacía retorna true si no, retorna false
     * @return boolean
     */
    public boolean isEmpty() { 
        return first==null; 
    }
    
    
    /** 
     * Inserta un dato en la posición 0 de la lista, volviendose el primero y desplazando a los demás elementos 
     * una posición.
     * @param dd
     */
    public void insertFirst(T dd){
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        if( isEmpty() ) 
            last = newLink; 
        else
            first.setPrevious(newLink);
        newLink.setNext(this.first);
        this.first = newLink;
    }


    
    /** 
     * Inserta el dato al final de la lista, conviertiendose en el último elemento de la lista.
     * @param dd Dato a ingresar en la lista.
     */
    public void insertLast(T dd) {
        DoublyLink<T> newLink = new DoublyLink<T>(dd); 
        if( isEmpty() ) 
            first = newLink; 
        else {
            last.setNext(newLink);
            newLink.setPrevious(this.last);
        }
        last = newLink; 
    }

    /** 
     * Elimina el primer elemento de la lista.
     * 
     */
    public DoublyLink<T> deleteFirst() { 
        DoublyLink<T> temp = first;
        if(first.getNext() == null) 
            last = null;
        else
            first.getNext().setPrevious(null);
        first = first.getNext(); 
        return temp;
    }

     /** 
     * Elimina el último elemento de la lista
     * 
     */
    public DoublyLink<T> deleteLast(){
        DoublyLink<T> temp = last;
        if(first.getNext() == null) 
            first = null; 
        else
            last.getPrevious().setNext(null); 
        last = last.getPrevious(); 
        return temp;
    }
    

    
    /** 
     * Inserta un elemento despues de otro elemento.
     * @param key Es el elemento referencia.
     * @param dd Es el dato a insertar.
     * @return boolean
     */
    public boolean insertAfter(T key, T dd) { 
        DoublyLink<T> current = first; 
        while(current.getdData() != key) {
            current = current.getNext(); 
            if(current == null)
                return false; 
        }
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        if(current==last) {
            newLink.setNext(null); 
            last = newLink;
        }
        else {
            newLink.setNext(current.getNext());
            current.getNext().setPrevious(newLink);
        }
        newLink.setPrevious(current); 
        current.setNext(newLink); 
        return true; 
    }
    

    
    /** 
     * Elimina el elemento proporcionado.
     * @param key Es el elemento que se desea eliminar.
     * @return DoublyLink
     */
    public DoublyLink<T> deleteKey(T key) { 
        DoublyLink<T> current = first; 
        while(current.getdData() != key) {
            current = current.getNext(); 
            if(current == null)
            return null;
        }
        if(current==first)
            first = current.getNext();
        else
            current.getPrevious().setNext(current.getNext());
        if(current==last) 
            last = current.getPrevious();
        else
            current.getNext().setPrevious(current.getPrevious()); ;
        return current;
    }

    /**
     * Muestra los elementos de la lista enlazada del primer elemento al último.
     */
    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoublyLink<T> current = first;
        while(current != null) {
            current.displayLink(); 
            current = current.getNext(); 
        }
        System.out.println("");
    }

    /**
     * Muestra los elementos de la lista enlazada del ultimo elemento al primero.
     */
    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoublyLink<T> current = last;
        while(current != null) {
            current.displayLink(); 
            current = current.getPrevious(); 
        }
        System.out.println("");
    }

    
    
    /** Retorna el primer elemento de la lista. 
     * @return DoublyLink
     * @throws ErrorDoubleLinkedList Si la lista está vacía retorna la excepción.
     */
    public DoublyLink<T> getFirstDoublyLink( ) throws ErrorDoubleLinkedList {
        if(isEmpty() ) {
            throw new ErrorDoubleLinkedList("The list is empty");
        }
        return first;
    }

    
    
    /** 
     * Retorna el ultimo elemento de la lista.
     * @return DoublyLink
     * @throws ErrorDoubleLinkedList Si la lista está vacía retorna la excepción.
     */
    public DoublyLink<T> getLastDoublyLink( ) throws ErrorDoubleLinkedList {
        if(isEmpty() ) {
            throw new ErrorDoubleLinkedList("The list is empty");
        }
        return last;
    }

    
    
    /** 
     * Retorna el tamaño de la lista.
     * @return int
     */
    public int size( ) {
        DoublyLink<T> current = this.first;
        int cont = 0;

        while(current != null ){
            cont++;
            current = current.getNext();
        }
        return cont;
    }


    
    /** 
     * Retorna la posición en la lista de un elemento.
     * @param data Es el dato del que se desea la posición.
     * @return int
     * @throws ErrorDoubleLinkedList
     */
    public int getPosition( T data) throws ErrorDoubleLinkedList {
        DoublyLink<T> current = this.first;
        int cont = 0;
        while(current != null ) {
            if( current.getdData() == data) {
                return cont;
            }
            current = current.getNext();
            cont++;
        }

        throw new ErrorDoubleLinkedList("Data doesn't exist in the list");
    }

     /** 
     * Limpia la lista.
     */
    public void cleanList( ) {
        int cont = 0;
        int size = size();
        while( cont < size) {
            deleteLast();
            cont++;
        }
    }

    
    
    /** 
     * Elimina el elemento de la lista especificando su índice.
     * @param index Posición del elemento por borrar.
     * @throws ErrorDoubleLinkedList
     */
    public void deleteDoublyLinkPosition(int index) throws ErrorDoubleLinkedList{
        DoublyLink<T> current = this.first;
        int cont = 0;

        if( index == 0) {
            deleteFirst();
            return;
        }
        if( index == size()-1) {
            deleteLast();
            return;
        }
        while(current != null) {
            if( cont == index) {
                current.setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());
                return;
            } 
            current = current.getNext();
            cont++;
        }

        throw new ErrorDoubleLinkedList("Index over range");

    }


    
    /** 
     * Actualiza el dato de un elemento, proporcionando el el dato actual y el nuevo del elemento.
     * @param currentData Dato actual del elemento.
     * @param newData Dato nuevo para sustituir.
     * @throws ErrorDoubleLinkedList
     */
    public void updateData (T currentData, T newData ) throws ErrorDoubleLinkedList {
        DoublyLink<T> current = this.first;

        while(current != null ) {
            if(current.getdData() == currentData ) {
                current.setdData(newData);
                return;
            }
            current = current.getNext();
        }

        throw new ErrorDoubleLinkedList("Data doesn't exist in the list");
    }


    
    /** 
     * Actualiza el dato de un elemento,especificando su indice.
     * @param newData Nuevo dato del elemento.
     * @param index Posición del elemento.
     * @throws ErrorDoubleLinkedList
     */
    public void updateDataIndex(T newData, int index ) throws ErrorDoubleLinkedList {
        DoublyLink<T> current = this.first;
        int cont = 0;

        while(current != null ) {
            if(cont == index ) {
                current.setdData(newData);
                return;
            }
            current = current.getNext();
            cont++;
        }

        throw new ErrorDoubleLinkedList("Data doesn't exist in the list");
    }


    
    /** 
     * Elimina el elemento de una posición especificada.
     * @param index Posicion del elemento por eliminar.
     * @throws ErrorDoubleLinkedList Si la posicion no existe en la lista entonces regresa la excepción.
     */
    public void deleteElementPosition( int index) throws ErrorDoubleLinkedList{
        DoublyLink<T> current = this.first;

        if( index == 0) {
            deleteFirst();
            return;
        } else if ( index == size() ) {
            deleteLast();
            return;
        }

        int cont = 0;
        while(current != null ) {
            if(cont == index ) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                return;
            }
            cont++;
            current = current.getNext();
        }

        throw new ErrorDoubleLinkedList("Position over range");

    }



    
    /** 
     * Inserta un dato de acuerdo al tipo de ordenamiento ingresado.
     * @param data Dato por ingresar.
     * @param order Tipo de ordanamiento. Parametro de tipo char. Puede ser 'a' para ordenar los elementos de forma acendente. Si es 'd' entonces el ordanamiento es de forma descendente.
     */
    public void inserDataOrder(T data, char order ) {
        DoublyLink<T> current = this.first;
        DoublyLink<T> newLink;

        if( isEmpty()) {
            insertFirst(data);
            return;
        }
        
            switch(order ) {
                case 'a':
                    if( (Integer)this.first.getdData() > (Integer)data) {
                        insertFirst(data);
                        return;
                    }
                    if( (Integer)this.last.getdData() < (Integer)data) {
                        insertLast(data);
                        return;
                    }
                    while(current != null) {
                        if( (Integer)current.getdData() > (Integer)data) {
                            newLink = new DoublyLink<T>(data);

                            newLink.setNext(current);
                            newLink.setPrevious(current.getPrevious()); 
                            current.getPrevious().setNext(newLink);
                            current.setPrevious(newLink);
                            
                            return;
                        } else {
                            current = current.getNext();
                        }

                    } 
                    break;
                    
                case 'd':
                if( (Integer)this.first.getdData() < (Integer)data) {
                    insertFirst(data);
                    return;
                } 
                if( (Integer)this.last.getdData() > (Integer)data) {
                    insertLast(data);
                    return;
                } 
                while(current != null) {
                    if( (Integer)current.getdData() < (Integer)data) {
                        newLink = new DoublyLink<T>(data);

                        newLink.setNext(current);
                        newLink.setPrevious(current.getPrevious()); 
                        current.getPrevious().setNext(newLink);
                        current.setPrevious(newLink);
                        return;
                    } else {
                        current = current.getNext();
                    }

                } 
            }

    }
}
