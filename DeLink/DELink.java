public class DELink <T>{
    private T dData;
    private DELink next; 

    public DELink(T dd) {
        dData = dd;
    }

    public DELink (T dd, DELink<T> nextLink){
        dData = dd;
        next = nextLink;

    }
    
    public T getData() {
        return dData;
    }


    public void setData(T data) {
        this.dData = data;
    }


    public DELink getNextLink() {
        return next;
    }


    public void setNextLink(DELink nextLink) {
        this.next = nextLink;
    }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }
}