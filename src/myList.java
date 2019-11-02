public interface myList<E> {

    int size();
//  Return size of the ist
//  Throws NoSuchElements Exceptions if the list is empty

    void addFirstElement(E element);
//  Adds an element to the front of the list
//  Parameter is the element to add

    void addLastElement(E element);
//  Adds an element to the end in the list
//  Parameter is the element to add

    E get(int index);
//  Return the element
//  Parameter is the index of the element
//  Throws NoSuchElementsExceptions if the list is empty

    E getFirstElement();
//  Return first element in the list;
//  Throws NoSuchElementsExceptions if the list is empty

    E getLastElement();
//  Return last element in the list;
//  Throws NoSuchElementsExceptions if the list is empty

    E removeFirstElement();
//  Remove first element in the list
//  Return first element in the list;
//  Throws NoSuchElementsExceptions if the list is empty

    E removeLastElement();
//  Remove last element in the list
//  Return last element in the list;
//  Throws NoSuchElementsExceptions if the list is empty

    myListIterator getIterator();
//  Return an iterator for this list

}

