package basics;

import utils.ArrayIterator;

import java.util.Iterator;

public class myQueue<T> {
  private T[] items;
  private int start = 0;
  private int end = 0;

  public myQueue(T[] queue) {
    items = queue;
    }

  public int getSize() {
      return end - start; 
  }

  public void enqueue(T item) {
    items[end++] = item;
    end = end%items.length;
    }

  public T dequeue() {
    T item = items[start++];
    start = start%items.length;
    return item;
    }

  public T peek() {
      return items[start]; 
  }

  public boolean isEmpty(){
      if(start == end){
          return true;
      }else{
          return false;
      }
  }
  
  public Iterator<T> iterator() {
    return new ArrayIterator<>(items, start, end);
    }

  }
