public interface List {

    int size();
//  Return size of the ist
//  Throws NoSuchElements Exceptions if the list is empty

    void addFirstElement(Object element);
//  Adds an element to the front of the list
//  Parameter is the element to add

    void addLastElement(Object element);
//  Adds an element to the end in the list
//  Parameter is the element to add

    Object get(int index);
//  Return the element
//  Parameter is the index of the element
//  Throws NoSuchElementsExceptions if the list is empty

    Object getFirstElement();
//  Return first element in the list;
//  Throws NoSuchElementsExceptions if the list is empty

    Object getLastElement();
//  Return last element in the list;
//  Throws NoSuchElementsExceptions if the list is empty

    Object removeFirstElement();
//  Remove first element in the list
//  Return first element in the list;
//  Throws NoSuchElementsExceptions if the list is empty

    Object removeLastElement();
//  Remove last element in the list
//  Return last element in the list;
//  Throws NoSuchElementsExceptions if the list is empty

    ListIterator getIterator();
//  Return an iterator for this list

}

