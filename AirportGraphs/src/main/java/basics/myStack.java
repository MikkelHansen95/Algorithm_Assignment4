package basics;

import java.util.Iterator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mikkel
 */
public class myStack<T> {

    private T[] arr;
    private int top;

    public myStack(T[] stack) {
        top = 0;
        arr = stack;
    }

    public void push(T item) {
        arr[top++] = item;
    }

    public T pop() {
        return arr[--top];
    }

    public T peek() {
        return arr[top - 1];
    }

    public int getSize() {
        return top;
    }
    
    public boolean isEmpty(){
        if(top != 0){
            return false;
        }else{
            return true;
        }
    }

    @NotNull
    public Iterator<T> iterator() {
        return null;
    }

}
