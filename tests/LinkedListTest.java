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
    }

    @Test
    public void addFirstElement() {
        List list = new LinkedList();
        list.addFirstElement("Last");
        assertTrue(list.getFirstElement() == "Last");
        assertTrue(list.getLastElement() == "Last");
        list.addFirstElement("First");
        assertTrue(list.getFirstElement() == "First");
        assertTrue(list.getLastElement() == "Last");
    }

    @Test
    public void addLastElement() {
        List list = new LinkedList();
        list.addLastElement("First");
        assertTrue(list.getFirstElement() == "First");
        assertTrue(list.getLastElement() == "First");
        list.addLastElement("Last");
        assertTrue(list.getFirstElement() == "First");
        assertTrue(list.getLastElement() == "Last");
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
        } catch (NoSuchElementException e) { //
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
        } catch (NoSuchElementException e) {
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
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIteratorOnEmptyList() {
        List list = new LinkedList();
        ListIterator i = list.getIterator();
        assertNotNull(i);
        assertFalse(i.hasNext());
        try{
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
    public void testIteratorAdd(){
        List list = new LinkedList();
        Integer first = 1;
        Integer second = 2;
        Integer third = 3;
        Integer fifth = 4;
        ListIterator i = list.getIterator();
        i.add(second);
    }

}