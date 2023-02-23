import exceptions.DELinkException;

class DELinkList <T>{
    private DELink<T> first;
    private DELink<T> last; 
    
    public DELinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertFirst(T dd) { 
        DELink<T> newLink = new DELink<T>(dd);
        if(isEmpty())
            last = newLink;
        newLink.setNextLink(first); 
        first = newLink;
    }

    public void insertLast(T dd) { 
        DELink<T> newLink = new DELink<T>(dd);
        if(isEmpty())
            first = newLink;
        else
            last.setNextLink(newLink);     
        last = newLink;
    }

    public T deleteFirst() throws DELinkException{ 
        if(isEmpty())
            throw new DELinkException("The list hasn't elements");     

        T temp = first.getData();
        if(first.getNextLink() == null)
            last = null;
        first = first.getNextLink();
        return temp;    
    }

    public T getLast()throws DELinkException{
        if(isEmpty())
            throw new DELinkException("The list hasn't elements"); 
        return last.getData();
    }

    public T getFirst()throws DELinkException{
        if(isEmpty())
            throw new DELinkException("The list hasn't elements"); 
        return first.getData();
    }

    public int size(){
        DELink<T> current = first;
        int contador = 0;
        while(current != null){
            contador++;
            current = current.getNextLink();
        }
        return contador;
    }


    public void replaceData(int data, T newdata ) throws DELinkException {
        DELink current = first;
        int cont = 0;

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

    public void replaceDataIndex(int index, T data ) throws DELinkException {
        DELink current = this.first;
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

    public void insertOrdered(T data, char order ) throws DELinkException {
        DELink current = first;

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
                            DELink newLink = new DELink<T>(data, current.getNextLink());
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

                    DELink temp = current;
                    while(current != null ) {
                        if( (Integer)data > (Integer)getFirst()) {
                            insertFirst(data);
                            return;
                        }else {
                            System.out.println(current.getData() + " " + data);
                            if((Integer) current.getData() < (Integer)data ){
                                DELink newLink = new DELink<T>(data, current);
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

    public void cleanDELink(){
        first = null;
        last = null;
    }

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