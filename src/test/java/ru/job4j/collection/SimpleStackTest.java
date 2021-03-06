package ru.job4j.collection;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    @Test
    public void whenPushThenPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPushPollThenPushPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.pop();
        stack.push(2);
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenPushPushThenPollPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void when4PushThenPollPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenFindLast() {
        SimpleStack<Double> stack = new SimpleStack<>();
        stack.push(20D);
        stack.push(30D);
        stack.push(40D);
        stack.push(50D);
        assertThat(stack.pop(), is(50D));
        assertThat(stack.pop(), is(40D));
        assertThat(stack.pop(), is(30D));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoEl() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.pop();
    }
}