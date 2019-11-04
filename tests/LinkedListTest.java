import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void testConstructor() {
        try {
            new LinkedList();
        } catch (RuntimeException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void size() {
        List list = new LinkedList();
        String first = "First";
        String second = "Second";
        String third = "Third";
        String fifth = "Fifth";
        assertEquals(0, list.size()); // Empty list
        list.addFirstElement(first);
        assertEquals(1, list.size());
        list.addLastElement(second);
        assertEquals(2, list.size());
        list.addLastElement(third);
        assertEquals(3, list.size());
        list.addLastElement(fifth);
        assertEquals(4, list.size());

    }

    @Test
    public void addFirstElement() {
        List list = new LinkedList();
        list.addFirstElement("Last");
        assertSame("Last", list.getFirstElement());
        assertSame("Last", list.getLastElement());
        list.addFirstElement("First");
        assertSame("First", list.getFirstElement());
        assertSame("Last", list.getLastElement());
    }

    @Test
    public void addLastElement() {
        List list = new LinkedList();
        list.addLastElement("First");
        assertSame("First", list.getFirstElement());
        assertSame("First", list.getLastElement());
        list.addLastElement("Last");
        assertSame("First", list.getFirstElement());
        assertSame("Last", list.getLastElement());
    }


    @Test
    public void set() {
        List list = new LinkedList();
        String first = "First";
        String second = "Second";
        String third = "Third";
        String fifth = "Fifth";

        list.addFirstElement(first);
        list.addLastElement(second);
        list.addLastElement(third);
        list.addLastElement(fifth);

        //Iterate and reverse the order
        ListIterator i = list.getIterator();
        try {
            i.set(fifth); //Should be exceptions, cause we didn't use next();
        } catch (IllegalStateException e) {//ok
            e.printStackTrace();
        }
        i.next();
        i.set(fifth);
        i.next();
        i.set(third);
        i.next();
        i.set(second);
        i.next();
        i.set(first);
        assertFalse(i.hasNext());

        //Check the order, should be Fifth, Third, Second, First
        i = list.getIterator();
        assertTrue(i.hasNext());
        assertSame(fifth, i.next());
        assertTrue(i.hasNext());
        assertSame(third, i.next());
        assertTrue(i.hasNext());
        assertSame(second, i.next());
        assertTrue(i.hasNext());
        assertSame(first, i.next());
        assertFalse(i.hasNext());
    }

    @Test
    public void get() {
    }

    @Test
    public void getFirstElement() {
        List testList = new LinkedList();
        try {
            testList.getFirstElement();
            fail("An exception should be thrown the empty list");

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getLastElement() {
        List testList = new LinkedList();
        try {
            testList.getLastElement();
            fail("This should throw the exception - empty list");
        } catch (NoSuchElementException e) { //ok
            e.printStackTrace();
        }
    }


    @Test
    public void removeFirstElement() {
        List list = new LinkedList();
        list.addLastElement("First");
        list.addLastElement("Last");
        assertSame("First", list.getFirstElement());
        assertSame("Last", list.getLastElement());
        assertSame("First", list.removeFirstElement());
        assertSame("Last", list.getFirstElement());
        assertSame("Last", list.getLastElement());
        assertSame("Last", list.removeFirstElement());
        try {
            list.removeFirstElement();
            fail("This should throw the exception");
        } catch (NoSuchElementException e) {// ok
            e.printStackTrace();
        }
    }

    @Test
    public void removeLastElement() {
        List list = new LinkedList();
        list.addLastElement("First");
        list.addLastElement("Last");
        assertSame("First", list.getFirstElement());
        assertSame("Last", list.getLastElement());
        assertSame("Last", list.removeLastElement());
        assertSame("First", list.getFirstElement());
        assertSame("First", list.getLastElement());
        assertSame("First", list.removeFirstElement());
        try {
            list.removeFirstElement();
            fail("This should throw the exception");
        } catch (NoSuchElementException e) { //ok
            e.printStackTrace();
        }
    }

    @Test
    public void testIteratorOnEmptyList() {
        List list = new LinkedList();
        ListIterator i = list.getIterator();
        assertNotNull(i);
        assertFalse(i.hasNext());
        try {
            i.next();
            fail("This should throw the exception");
        } catch (NoSuchElementException e) { // ok
            e.printStackTrace();
        }
    }

    @Test
    public void testIteratorOnNotEmptyList() { //Test basic iterator, if it works as expected
        List list = new LinkedList();
        Integer first = 1;
        Integer second = 2;
        Integer third = 3;
        Integer fifth = 4;
        list.addFirstElement(first);
        list.addLastElement(second);
        list.addLastElement(third);
        list.addLastElement(fifth);
        ListIterator i = list.getIterator();
        assertNotNull(i);
        assertTrue(i.hasNext());
        assertSame(i.next(), first);
        assertTrue(i.hasNext());
        assertSame(i.next(), second);
        assertTrue(i.hasNext());
        assertSame(i.next(), third);
        assertTrue(i.hasNext());
        assertSame(i.next(), fifth);
        assertFalse(i.hasNext());
    }

    @Test
    public void testIteratorAdd() {
        List list = new LinkedList();
        Integer first = 1;
        Integer second = 2;
        Integer third = 3;
        Integer fifth = 4;

        ListIterator i = list.getIterator();// Adds first element in the empty list and checks [   ] -> [ 2 ]

        i.add(second);
        assertSame(second, list.getFirstElement());
        assertSame(second, list.getLastElement());
        assertFalse(i.hasNext());

        i = list.getIterator(); //Go to head, add an element after the first  [ 1 ] -> [ 1, 2 ]
        i.add(first);
        assertSame(first, list.getFirstElement());
        assertTrue(i.hasNext());
        assertSame(second, i.next());
        assertFalse(i.hasNext());

        i = list.getIterator(); //Go to beginning, skip and  add an element  [ 1, 2 ] -> [ 1, 2, 3 ]
        assertTrue(i.hasNext());
        assertSame(first, i.next());
        assertTrue(i.hasNext());
        assertSame(second, i.next());
        i.add(third);
        assertFalse(i.hasNext());

        i = list.getIterator(); //Go to beginning, skip 3 times and  add an element  [ 1, 2, 3] -> [ 1, 2, 3, 4 ]
        assertTrue(i.hasNext());
        assertSame(first, i.next());
        assertTrue(i.hasNext());
        assertSame(second, i.next());
        assertTrue(i.hasNext());
        assertSame(third, i.next());
        assertFalse(i.hasNext());
        i.add(fifth);
        assertFalse(i.hasNext());
    }

    @Test
    public void remove() {
        List list = new LinkedList();

        Integer first = 1;
        Integer second = 2;
        Integer third = 3;
        Integer fifth = 4;
        list.addFirstElement(first);
        list.addFirstElement(second);
        list.addFirstElement(third);
        list.addFirstElement(fifth);

        //order is [4 , 3 , 2 , 1]

        ListIterator i = list.getIterator();
        assertTrue(i.hasNext());
        try {
            i.remove();
            fail("Error, cause we didn't call next before remove()");
        } catch (IllegalStateException e) {//ok!
            e.printStackTrace();
        }
        assertSame(fifth, i.next());
        assertSame(fifth, i.remove());
        assertTrue(i.hasNext());
        try {
            i.remove();
            fail("Error, cause we didn't call next() before remove()");
        } catch (IllegalStateException e) {//ok!
            e.printStackTrace();
        }
        assertSame(third, i.next());
        assertSame(third, i.remove());
        assertTrue(i.hasNext());
        assertSame(second, i.next());
        assertSame(second, i.remove());
        assertTrue(i.hasNext());
        assertSame(first, i.next());
        assertSame(first, i.remove());
        assertFalse(i.hasNext()); // The list is empty
    }


}