import arraylist.MyArrayList;

/**
 * Created by Artem on 02.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list=new MyArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

    ListIterator<Integer> iter= MyArrayList.listIterator();
        Integer temp=iter.next;
        iter.remove();
        iter.add(3);
        for(Integer i: list){
            System.out.println(i);
        }
    }
}
