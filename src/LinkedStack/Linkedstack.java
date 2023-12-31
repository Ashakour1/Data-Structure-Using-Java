package LinkedStack;

import java.util.EmptyStackException;

public class Linkedstack<T> {
    private Node<T> top;
    private int count;

    Linkedstack(){
        top = null;
        count = 0;
    }

    //push method
    void push( T element){
        Node<T> temp = new Node<>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }
    //size
    int size(){
        return count;
    }
    //Isempty
    boolean isEmpty(){
        //return top == null;
        return count == 0;
    }

    //pop
    T pop () throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    //peek
    T peek () throws EmptyStackException{
        if (isEmpty())
            throw new EmptyStackException();

        return top.getElement();
    }

    //printElements
    void printElements(){
        if(! isEmpty()){
            Node<T> current = top;
            while(current != null){
                System.out.print(current.getElement() +"  ");
                current = current.getNext();
            }
        }
        else{
            System.out.println("[]");
        }
    }

    //searcElement
    Node<T> searchElement(T key) throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        Node<T> current = top;

        Node<T> Count = null;
        while ( current != null){
            if(key.equals(current.getElement()))
                Count = top.getNext();

            current = current.getNext();
        }
        return Count;
    }

    //Counter
    int counter(T key) throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        int times=0;
        Node<T> current = top;
        while(current != null){
            if(key.equals(current.getElement()))
                times++;
            current = current.getNext();
        }
        return times;
    }
}