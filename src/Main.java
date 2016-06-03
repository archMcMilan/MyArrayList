import arraylist.MyArrayList;

import java.util.ListIterator;

/**
 * Created by Artem on 02.06.2016.
 */
public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> myArrayList = new MyArrayList();
        myArrayList.add(new Integer(4));
        myArrayList.add(new Integer(10));
        myArrayList.add(new Integer(3));
        myArrayList.add(new Integer(576));
        for (Integer i : myArrayList ) {
            System.out.println(i);
        }
        System.out.println("======================");
        ListIterator<Integer> iter = myArrayList.listIterator();
        Integer tmp = iter.next();
        iter.remove();
        iter.add(3);
        for (Integer i: myArrayList) {
            System.out.println(i);
        }
        System.out.println("======================");
        MyArrayList<Integer> myArrayList2 = new MyArrayList(3);
        myArrayList2.add(new Integer(4));
        myArrayList2.add(new Integer(10));
        myArrayList2.add(new Integer(3));
        myArrayList2.add(new Integer(576));
        myArrayList2.remove(0);
        myArrayList2.remove(myArrayList2.get(0));
        for (Integer i : myArrayList2) {
            System.out.println(i);
        }

    }
}
