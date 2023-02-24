package domain;

import exceptions.DELinkException;

public class DELinkList <T>{
    private DELink<T> first;
    private DELink<T> last; 
    
    public DELinkList() {
        first = null;
        last = null;
    }

    /**
     * Este método devuelve true si la lista está vacio o null si la lista no está vacía
     * @return boolean
     **/
    public boolean isEmpty() {
        return (first==null);
    }

    /**
     * Este método inserta el dato recibido como el primer dato de la lista
     * @param dd 
     **/
    public void insertFirst(T dd) { 
        DELink<T> newLink = new DELink<T>(dd);
        if(isEmpty())
            last = newLink;
        newLink.setNextLink(first); 
        first = newLink;
    }

    /**
     * Este método inserta el dato recibido como el último dato de la lista
     * @param dd 
     **/
    public void insertLast(T dd) { 
        DELink<T> newLink = new DELink<T>(dd);
        if(isEmpty())
            first = newLink;
        else
            last.setNextLink(newLink);     
        last = newLink;
    }

    /**
     * Este método elimina el primer dato de la lista y devuelve el dato eliminado
     * @return T dato genérico que es eliminado de la lista 
     * @exception DELinkException Excepción que menciona si la lista no tiene elementos o que el dato no existe en la lista
     **/
    public T deleteFirst() throws DELinkException{ 
        if(isEmpty())
            throw new DELinkException("The list hasn't elements");     

        T temp = first.getData();
        if(first.getNextLink() == null)
            last = null;
        first = first.getNextLink();
        return temp;    
    }

    /**
     * Este método devuelve el último dato sin eliminarlo de la lista
     * @return T devuelve un dato genérico que es el último de la lista 
     * @exception DELinkException Excepción que menciona si la lista no tiene elementos o que el dato no existe en la lista
     **/
    public T getLast()throws DELinkException{
        if(isEmpty())
            throw new DELinkException("The list hasn't elements"); 
        return last.getData();
    }

    /**
     * Este método devuelve el primer dato sin eliminarlo de la lista
     * @return T devuelve un dato genérico que es el primero de la lista 
     * @exception DELinkException Excepción que menciona si la lista no tiene elementos o que el dato no existe en la lista
     **/
    public T getFirst()throws DELinkException{
        if(isEmpty())
            throw new DELinkException("The list hasn't elements"); 
        return first.getData();
    }

    /**
     * Este método devuelve el primer dato sin eliminarlo de la lista
     * @return int devuelve un número entero que es la cantidad de datos que hay en la lista
     **/
    public int size(){
        DELink<T> current = first;
        int contador = 0;
        while(current != null){
            contador++;
            current = current.getNextLink();
        }
        return contador;
    }

    /**
     * Este método reemplaza un dato que recibe el cual es el que se va a eliminar y va a insertar en esa posición el nuevo dato que recibe.
     * @param data dato que se va a eliminar de la lista
     * @param newdata dato que se va a inserta en la posición del dato eliminado 
     * @exception DELinkException Excepción que menciona si la lista no tiene elementos o que el dato no existe en la lista
     **/
    public void replaceData(T data, T newdata ) throws DELinkException {
        DELink<T> current = first;

        if(isEmpty() ) {
            throw new DELinkException("The list hasn't elements");
        } 
        while(current != null ) {
            if( current.getData() == (Integer)data) {
                current.setData(newdata);
                return;
            } else {
                current = current.getNextLink();
            }
        }
        throw new DELinkException("Data doesn't exist");
        
    }

    /**
     * Este método reemplaza un dato mediante la posición que recibe del dato que se quiere eliminar y va a insertar en esa posición el nuevo dato que recibe.
     * @param index posición del dato que se va a eliminar de la lista
     * @param newdata dato que se va a inserta en la posición del dato eliminado 
     * @exception DELinkException Excepción que menciona si la lista no tiene elementos o que el dato no existe en la lista
     **/
    public void replaceDataIndex(int index, T data ) throws DELinkException {
        DELink<T> current = this.first;
        int cont = 0;

        if(isEmpty() ) {
            throw new DELinkException("The list hasn't elements");
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
    }

    /**
     * Este método ordena los datos de forma ascendente o descendente dependiendo del char que recibe
     * @param data dato que se va a insertar de forma ordena en la lista
     * @param order char que sirve para determinar la forma de ordenamiendo de la lista, "a" si se quiere ordenar de forma ascendente o "d"bsi se quiere ordenar de forma descendente
     * @exception DELinkException Excepción que menciona si la lista no tiene elementos o que el dato no existe en la lista
     **/
    public void insertOrdered(T data, char order ) throws DELinkException {
        DELink<T> current = first;

        if(isEmpty() ){
            insertFirst(data);
            return;
        }

        switch(order){
            case 'a': 
                    if( (Integer)this.first.getData() > (Integer)data){
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
                    while(current != null ) {
                        if((Integer) current.getData() < (Integer)data ){
                            DELink<T> newLink = new DELink<T>(data, current.getNextLink());
                            current.setNextLink(newLink);
                            return;
                        } else {
                            current = current.getNextLink();
                        }
                    }          
                break;
            case 'd':
                    if( (Integer)this.first.getData() < (Integer)data){
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

                    DELink<T> temp = current;
                    while(current != null ) {
                        if( (Integer)data > (Integer)getFirst()) {
                            insertFirst(data);
                            return;
                        }else {
                            System.out.println(current.getData() + " " + data);
                            if((Integer) current.getData() < (Integer)data ){
                                DELink<T> newLink = new DELink<T>(data, current);
                                temp.setNextLink(newLink);
                                return;
                            } else {
                                current = current.getNextLink();
                            }
                        }
                        
                    }      
                break;
            default:  throw new DELinkException("The char wasn't a or d");
        }

    
    }

    /**
     * Este método recibe un dato y elimina ese dato de la lista
     * @param value dato que se va a eliminar de la lista
     * @exception DELinkException Excepción que menciona si la lista no tiene elementos o que el dato no existe en la lista
     **/
    public void deleteDELink(T value) throws DELinkException {
        int pos = 0;
        while (pos != -1) {
            pos = findPosition(value);
            if (pos != -1) {
                deleteAt(pos);
                return;
            }
        }
        throw new DELinkException("Element doesn't exist in the list");
    }

    /**
     * Este método recibe una posicion de la lista y elimina el dato de la posición recibida de la lista
     * @param value dato que se va a eliminar de la lista
     * @exception DELinkException Excepción que menciona si la lista no tiene elementos o que el dato no existe en la lista
     **/
    public void deleteAt(int index)throws DELinkException{
        DELink<T> current = first;
        if( isEmpty())
            throw new DELinkException("List is empty");
            if(size() - 1 < index)
            throw new DELinkException("The position you want to delete doesn't exist in the list");
        
        if(index == 0){
            first = current.getNextLink();
            return;
        }

        for(int i = 0; current != null && i < index -1; i++){
            current = current.getNextLink();
        }

        if(current == null || current.getNextLink() == null)
            return;

        DELink<T> temp = current.getNextLink().getNextLink();
        current.setNextLink(temp);

    }

    /**
     * Este método limpia la lista
     **/
    public void cleanDELink(){
        first = null;
        last = null;
    }

    /**
     * Este método encuenta la posicion de un dato si se encuentra la lista 
     * @param value dato que se va a eliminar de la lista
     * @exception DELinkException Excepción que menciona si la lista no tiene elementos o que el dato no existe en la lista
     * @return int número entero que es la poción del dato
     **/
    public int findPosition(T value)throws DELinkException{
        DELink<T> current = first;
        int contador = 0;
        if(isEmpty())
            throw new DELinkException("List is empty");
        else{
            while(current != null){
                if(current.getData() == value)
                    return contador;
                contador ++;
                current = current.getNextLink();
            }
        }
        throw new DELinkException("Element doesn't exist in the list");
    }

    /**
     * Este método imprime los número que se encuentran en la lista de acuerdo a la posición que se encuentren
     **/
    public void displayList() {
        System.out.print("List (first--> ");
        DELink<T> current = first;
        while(current != null) {
            current.displayLink(); 
            current = current.getNextLink(); 
        }
        System.out.println("<--last)");
    }

}
