import java.util.NoSuchElementException;

public class myLinkedList<E> implements myList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void addFirstElement(E element) {
        Node<E> newNode = new Node<>(element, null, null);
        if (this.firstNode == null) {
            this.firstNode = newNode;
            this.lastNode = newNode;
        } else {
            newNode.setNextElement(this.firstNode);
            this.firstNode.setPrevElement(newNode);
            this.firstNode = newNode;
        }
    }

    @Override
    public void addLastElement(E element) {
        Node<E> newNode = new Node<>(element, null, null);
        if (this.lastNode == null) {
            this.firstNode = newNode;
            this.lastNode = newNode;
        } else {
            newNode.setPrevElement(this.lastNode);
            this.lastNode.setNextElement(newNode);
            this.lastNode = newNode;
        }
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E getFirstElement() {
        if (this.firstNode == null) {
            throw new NoSuchElementException();
        } else {
            return this.firstNode.getData();
        }
    }

    @Override
    public E getLastElement() {
        if (this.lastNode == null) {
            throw new NoSuchElementException();
        }
        return this.lastNode.getData();
    }

    @Override
    public E removeFirstElement() {
        if (this.firstNode == null) {           //There is nothing in the list
            throw new NoSuchElementException();
        }
        E element = firstNode.getData();
        if (this.firstNode == this.lastNode) {  //There is one element in the list
            this.firstNode = null;
            this.lastNode = null;
        } else {                                //There are two or more elements in the list
            this.firstNode = this.firstNode.getNextElement();
            this.firstNode.setPrevElement(null);
        }
        return element;
    }

    @Override
    public E removeLastElement() {
        if (this.lastNode == null) {            //There is nothing in the list
            throw new NoSuchElementException();
        }
        if (this.firstNode == this.lastNode) {    //There is one element in the list
            this.firstNode = null;
            this.lastNode = null;
        } else {                                 //There are two or more elements in the list
            this.lastNode = this.lastNode.getPrevElement();
            this.lastNode.setNextElement(null);
        }
        return null;
    }

    @Override
    public myListIterator getIterator() {
        return null;
    }

    private class Node<N> {
        private N data; // The data stored at the node
        private Node<N> nextElement;// The link to the next node or null
        private Node<N> prevElement;// The link to the previous node or null

        Node(N data, Node<N> prevElement, Node<N> nextElement) {
            this.data = data;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public N getData() {
            return data;
        }

        public void setData(N data) {
            this.data = data;
        }

        public Node<N> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<N> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<N> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<N> prevElement) {
            this.prevElement = prevElement;
        }
    }
    private class myLinkedListIterator implements myListIterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void add(E element) {

        }

        @Override
        public E remove() {
            return null;
        }

        @Override
        public void set(E element) {

        }
    }
    public myLinkedList() {
        this.firstNode = new Node<>(null, null, lastNode);
        this.lastNode = new Node<>(null, firstNode, null);

    }

}
