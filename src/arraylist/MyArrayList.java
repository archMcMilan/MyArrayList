package arraylist;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Artem on 02.06.2016.
 */
public class MyArrayList<T> extends AbstractList<T> implements List<T> {
    private int capacity;
    private Object[] array;
    private int size;
    private static final int CAPACITY = 10;
    private static final double EXTENSION = 1.5;
    private int modCount = 0;

    public MyArrayList() {
        capacity = CAPACITY;
        array = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    private void ensureCapacity(int tempSize) {
        if (size + tempSize >= capacity) {
            capacity *= EXTENSION;
            ensureCapacity(tempSize);
        } else {
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array=newArray;
        }
    }

    private void indexCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index might be less than size and bigger than 0. Size: " + size + ".");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Object value) {
        ensureCapacity(1);
        array[size++] = value;
        modCount++;
        return true;
    }

    @Override
    public void add(int index, Object o) {
        indexCheck(index);
        ensureCapacity(1);
        int toAdd = size - index;
        System.arraycopy(array, index, array, index + 1, toAdd);
        array[index] = (T) o;
        size++;
        modCount++;
    }


    @Override
    public boolean addAll(Collection c) {
        Object[] tempArray = c.toArray();
        ensureCapacity(tempArray.length);
        System.arraycopy(tempArray, 0, array, size, tempArray.length);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Object[] tempArray = c.toArray();
        ensureCapacity(tempArray.length - index + 1);
        System.arraycopy(tempArray, index, array, size, tempArray.length);
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    @Override
    public T get(int index) {
        indexCheck(index);
        return (T) array[index];

    }

    @Override
    public Object set(int index, Object element) {
        indexCheck(index);
        array[index] = (T) element;
        modCount++;
        return (T) array[index];
    }


    @Override
    public boolean remove(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                remove(i);
            }
        }
        return true;
    }

    @Override
    public T remove(int index) {
        indexCheck(index);
        T returnValue = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        modCount++;
        return returnValue;
    }


    public ListIterator listIterator() {
        return new ListIterator<T>() {
            int index = 0;
            int modCount = MyArrayList.this.modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }


            @Override
            public T previous() {
                return (T) array[--index];
            }


            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }


            @Override
            public void remove() {
                MyArrayList.this.remove(index--);
            }


            @Override
            public void set(T t) {
                MyArrayList.this.set(index, t);
                modCount++;
            }


            @Override
            public void add(T t) {
                MyArrayList.this.add(index,t);
                modCount++;
            }

            private void checkMods() {
                if (modCount != MyArrayList.this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
