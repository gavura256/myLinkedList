public class Main {

    public static void main(String[] args) {
        // write your code here
        List list = new LinkedList();
        list.addFirstElement(12);
        list.addLastElement(13);
        System.out.println("First elemment is " + list.getFirstElement());
        System.out.println("Last element is " + list.getLastElement());
        System.out.println("List size is " + list.size());
        for (int i = 0; i < 2; i++) {
            System.out.println(list.get(i));

        }


    }
}

