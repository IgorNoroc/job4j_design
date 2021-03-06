package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * 5.2.1. Реализовать SimpleArray<T> [#279224]
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] data;
    private int index = 0;
    private int availableEl = 0;

    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    public void add(T value) {
        Objects.checkIndex(index, data.length);
        this.data[index++] = value;
    }

    public void set(int position, T value) {
        Objects.checkIndex(position, index);
        this.data[position] = value;
    }

    public T get(int position) {
        Objects.checkIndex(position, index);
        return (T) this.data[position];
    }

    public void remove(int position) {
        Objects.checkIndex(position, index);
        if (position != index) {
            System.arraycopy(data, position + 1, data, position, ((index - 1) - position));
        }
        data[data.length - 1] = null;
        index--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return availableEl < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[availableEl++];
            }
        };
    }
}
