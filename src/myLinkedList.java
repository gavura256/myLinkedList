public class myLinkedList<E> implements myList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addFirstElement(E element) {

    }

    @Override
    public void addLastElement(E element) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E getFirstElement() {
        return null;
    }

    @Override
    public E getLastElement() {
        return null;
    }

    @Override
    public E removeFirstElement() {
        return null;
    }

    @Override
    public E removeLastElement() {
        return null;
    }

    @Override
    public myListIterator getIterator() {
        return null;
    }

    private class Node<N> {
        private E currentElement; // The data stored at the node
        private Node<E> nextElement;// The link to the next node or null
        private Node<E> prevElement;// The link to the previous node or null

        Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }

    public myLinkedList() {
        this.firstNode = new Node<>(null, null, lastNode);
        this.lastNode = new Node<>(null, firstNode, null);

    }

}
