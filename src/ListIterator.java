public interface ListIterator {

    boolean hasNext();
//  Returns true if there is an element after the iterator position

    Object next();
//  Moves the iterator past the next element
//  Returns the traversed element

    void add(Object element);
//  Add the element before the iterator position and move the iterator past the inserted element.
//  Parameter is the element to add.

    Object remove();
//  Removes the last traversed element. This method may only called after a call to the next() method.
//  Throws IllegalStateException if remove() is called without a next().

    void set(Object element);
//  Sets the last traversed  element to a different value.
//  Parameter is the element to set.
//  Throws IllegalStateException if set() is called without a next().
}
