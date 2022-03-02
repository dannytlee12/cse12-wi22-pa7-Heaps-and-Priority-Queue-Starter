/**
 * TODO: Add your file header
 * Name: Danny Lee
 * ID: A17209209
 * Email: dtl001@ucsd.edu
 * Sources used: Zybooks
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 *
 * 2-4 sentence file description here
 This file contains the MyPriorityQueue class that is an implementation of the
 priority queue ADT. This implementation uses a MyMinHeap as the underlying
 data structure.
 */

import java.util.Collection;

/**
 * TODO: Add Class Header
 This class is an implementation of the priority queue which uses a MyMinHeap
 as the underlying data structure. 
 */
public class MyPriorityQueue<E extends Comparable<E>>
{

    //TODO: Add a public instance variable called "heap"
    //"heap" is of a generic MyMinHeap type
    public MyMinHeap<E> heap;


    /**
     * Constructor that creates an empty priority queue
     */
    public MyPriorityQueue(){
        heap = new MyMinHeap<>();
    }

    /**
     * Constructor that creates a priority queue from a collection
     * @param collection The collection used to intialize priority queue
     */
    public MyPriorityQueue(Collection<? extends E> collection){
        heap = new MyMinHeap<>(collection);
    }

    /**
     * Adds an element to the priority queue
     * @param element the element to be added
     */
    public void push(E element){
        heap.insert(element);
    }

    /**
     * Removes the element with the highest priority from the priority queue
     * @return the element with the highest priority
     */
    public E pop(){
        return heap.remove();
    }

    /**
     * Sees the element with the highest priority from the priority queue
     * @return the element with the highest priority
     */
    public E peek(){
        return heap.getMin();
    }

    /**
     * Finds the number of elements in the priority queue
     * @return the number of elements in the priority queue
     */
    public int getLength(){
        return heap.size();
    }

    /**
     * Remove all the elements from the priority queue.
     */
    public void clear(){
        heap.clear();
    }
}
