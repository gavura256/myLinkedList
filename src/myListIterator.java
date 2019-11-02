public interface myListIterator<E> {

    boolean hasNext();
//  Returns true if there is an element after the iterator position

    E next();
//  Moves the iterator past the next element
//  Returns the traversed element

    void add(E element);
//  Add the element before the iterator position and move the iterator past the inserted element.
//  Parameter is the element to add.

    E remove();
//  Removes the last traversed element. This method may only called after a call to the next() method.
//  Returns the removed element
//  Throws IllegalStateException if remove() is called without a next().

    void set(E element);
//  Sets the last traversed  element to a different value.
//  Parameter is the element to set.
}
