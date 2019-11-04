import java.util.NoSuchElementException;

public class LinkedList implements List {

    private Node firstNode;
    private Node lastNode;


    LinkedList() { //Constructs an empty LinkedList
        this.lastNode = null;
        this.firstNode = null;
    }

    @Override
    public int size() {
        int count = 0;
        for (ListIterator i = this.getIterator(); i.hasNext(); i.next()) {
            count++;
        }
        return count;
    }

    @Override
    public void addFirstElement(Object element) {
        Node newNode = new Node(element, null, null);
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
    public void addLastElement(Object element) {
        Node newNode = new Node(element, null, null);
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
    public Object get(int index) {
        if (index < 0) {
            throw new NoSuchElementException();
        }
        int count = 0;
        for (ListIterator i = this.getIterator(); i.hasNext(); ) {
            Object element = i.next();
            if (index == count) {
                return element;
            }
            ++count;
        }
        throw new NoSuchElementException();//index was larger than list size.
    }

    @Override
    public Object getFirstElement() {
        if (this.firstNode == null) {
            throw new NoSuchElementException();
        } else {
            return this.firstNode.getData();
        }
    }

    @Override
    public Object getLastElement() {
        if (this.lastNode == null) {
            throw new NoSuchElementException();
        }
        return this.lastNode.getData();
    }

    @Override
    public Object removeFirstElement() {
        if (this.firstNode == null) {           //There is nothing in the list
            throw new NoSuchElementException();
        }
        Object element = this.firstNode.getData();
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
    public Object removeLastElement() {
        if (this.lastNode == null) {            //There is nothing in the list
            throw new NoSuchElementException();
        }
        Object element = this.lastNode.getData();
        if (this.firstNode == this.lastNode) {    //There is one element in the list
            this.firstNode = null;
            this.lastNode = null;
        } else {                                 //There are two or more elements in the list
            this.lastNode = this.lastNode.getPrevElement();
            this.lastNode.setNextElement(null);
        }
        return element;
    }

    @Override
    public ListIterator getIterator() {
        return new LinkedListIterator();
    }

    private class Node {
        private Object data; // The data stored at the node
        private Node nextElement;// The link to the next node or null
        private Node prevElement;// The link to the previous node or null

        Node(Object data, Node prevElement, Node nextElement) {
            super();
            this.data = data;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        Object getData() {
            return data;
        }

        void setData(Object data) {
            this.data = data;
        }

        Node getNextElement() {
            return nextElement;
        }

        void setNextElement(Node nextElement) {
            this.nextElement = nextElement;
        }

        Node getPrevElement() {
            return prevElement;
        }

        void setPrevElement(Node prevElement) {
            this.prevElement = prevElement;
        }
    }

    private class LinkedListIterator implements ListIterator {
        private Node pre;
        private Node post;
        private boolean isAfterNext;// We'll check if ours methods called after next()

        LinkedListIterator() { //Default constructor
            this.pre = null;
            this.post = firstNode;
            this.isAfterNext = false;
        }

        @Override
        public boolean hasNext() {
            return (post != null);
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                this.pre = this.post;
                this.post = this.post.getNextElement();
                this.isAfterNext = true;
                return this.pre.getData();
            }
        }

        @Override
        public void add(Object element) {
            if (this.pre == null) { // Empty list
                addFirstElement(element);
                this.pre = firstNode;
                this.post = firstNode.getNextElement();
            } else if (this.post == null) {// 1 element in the list
                addLastElement(element);
                this.pre = lastNode;
                this.post = lastNode.getNextElement();
            } else {
                Node newNode = new Node(element, this.pre, this.post);
                this.pre.setNextElement(newNode);
                this.post.setPrevElement(newNode);
                this.pre = newNode;
            }
        }

        @Override
        public Object remove() {
            if (!this.isAfterNext) {
                throw new IllegalStateException();
            }
            Object element = this.pre.getData();
            if (firstNode == lastNode) {//There is one element in the list
                this.pre = null;
                this.post = null;
                firstNode = null;
                lastNode = null;
            } else if (this.pre == firstNode) {//Removes the first element
                removeFirstElement();
                this.pre = null;
                this.post = firstNode;
            } else if (this.pre == lastNode) {//Removes the last element
                removeLastElement();
                this.pre = lastNode;
                this.post = null;
            } else {
                this.pre.getPrevElement().setNextElement(this.post);
                this.post.setPrevElement(this.pre.getPrevElement());
            }
            this.isAfterNext = false;
            return element;
        }

        @Override
        public void set(Object element) {
            if (!this.isAfterNext) {
                throw new IllegalStateException();
            }
            this.pre.setData(element);
        }
    }
}
