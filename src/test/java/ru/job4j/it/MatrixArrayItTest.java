package ru.job4j.it;


import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixArrayItTest {
    @Test
    public void whenHave4Massive() {
        int[][] input = {
                {3, 5, 6, 7},
                {4, 1},
                {0},
                {1, 2, 4, 6}
        };
        MatrixArrayIt arrayIt = new MatrixArrayIt(input);
        assertThat(arrayIt.next(), is(3));
        assertThat(arrayIt.next(), is(5));
        assertThat(arrayIt.next(), is(6));
        assertThat(arrayIt.next(), is(7));
        assertThat(arrayIt.next(), is(4));
        assertThat(arrayIt.next(), is(1));
        assertThat(arrayIt.next(), is(0));
    }

    @Test
    public void whenOneEl() {
        int[][] input = {
                {3, 4},
                {},
                {},
                {}
        };
        MatrixArrayIt arrayIt = new MatrixArrayIt(input);
        assertThat(arrayIt.hasNext(), is(true));
        assertThat(arrayIt.hasNext(), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoNextElement() {
        int[][] input = {
                {},
                {}
        };
        MatrixArrayIt arrayIt = new MatrixArrayIt(input);
        arrayIt.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoHasNext() {
        int[][] input = {
                {},
                {}
        };
        MatrixArrayIt arrayIt = new MatrixArrayIt(input);
        arrayIt.hasNext();
    }
}
