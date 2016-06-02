package arraylist;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Artem on 02.06.2016.
 */
public class MyArrayList<T> extends AbstractList<T> implements List {
    private int capacity;
    private Object[] array;
    private int size;
    private static final int CAPACITY = 10;
    private static final double EXTENSION = 1.5;

    public MyArrayList() {
        capacity = CAPACITY;
        array = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Object value) {
        if (size < capacity) {
            array[size++] = value;
        } else {
            capacity *= EXTENSION;
            add(value);
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, T value) {

    }

    /*public boolean remove(int index){
       if(index>=size || index<0){
           throw new IndexOutOfBoundsException();
       }else {
           //System.arraycopy(array,index+1,array, index,size-index);
           for(int i=index;i<size;i++){
               array[index]=array[index+1];

           }
           array[size]=null;
           size--;
           return true;
       }
    }*/

    public boolean remove(T value) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                flag = true;
                System.arraycopy(array, i + 1, array, i, size - i);
                for (int j = i; j < size; j++) {
                    //System.arraycopy(array,index+1,array, index,size-index-1);
                    array[j] = array[j + 1];
                }
                break;
            }
        }
        return flag;
    }


    public ListIterator listIterator() {
        return new ListIterator<T>() {
            int index = -1;


            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) array[--index];
            }

            @Override
            public boolean hasPrevious() {
                return index>0;
            }


            @Override
            public T previous() {
                return (T) array[--index];
            }


            @Override
            public int nextIndex() {
                return index+1;
            }

            @Override
            public int previousIndex() {
                return index-1;
            }


            @Override
            public void remove() {
                MyArrayList.this.remove(index--);
            }


            @Override
            public void set(T t) {
                MyArrayList.this.set(index,t);
            }


            @Override
            public void add(T t) {
                MyArrayList.this.add(t);
            }
        }
    }
}
