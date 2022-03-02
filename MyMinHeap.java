/**

 * Name: Danny Lee
 * ID: A17209209
 * Email: dtl001@ucsd.edu
 * Sources used: Zybooks
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 *
 * 2-4 sentence file description here
 This class contains an implementation of the Min Heap ADT. This
 implementation uses an arraylist as the underlying data structure.
 */

// Your import statements
import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO: Add class header
 This is an implementation of the Min heap ADT. The smallest value of the Heap
 is at the root, and each of its children will be larger than it. It uses an
 arraylist as the underlying data structure. 
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface <E>{

    /**
     * TODO: Implement MinHeap
     */

    public ArrayList<E> data;

         /*No-argument constructor that initializes data to an empty ArrayList*/
    public MyMinHeap(){
      data = new ArrayList<E>();
    }

    /*Initializes a min-heap using the elements in collection
    First, initialize data using the ArrayList(Collection<? extends E> c)constructor by directly passing in the collection argument.
    Next, iterate through data backward, percolating each element down. We will soon write the percolateDown() helper method, which we can be used here.
    Throws NullPointerException if collection or any element in collection is null.*/
    public MyMinHeap(Collection<? extends E> collection){
      data = new ArrayList<>(collection);
      for(int i = data.size()-1; i >= 0; i--){
        this.percolateDown(i);
      }
    }


/*     Swap the elements at from and to indices in data.
You do not need to check if from and to are out of bounds. */
     protected void swap(int from, int to){
       E temp1 = data.get(from);
       E temp2 = data.get(to);
       data.set(from, temp2);
       data.set(to, temp1);
     }

/*     Calculate and return the parent index of the parameter index.
This method is irrelevant to what is currently in data and should not make any changes to data.
You do not need to check if index > 0*/


     protected int getParentIdx(int index){
       return (index-1)/2;
     }

/*     Calculate and return the left child index of the parameter index.
This method is irrelevant to what is currently in data and should not make any changes to data.
You do not need to check if index >= 0*/


     protected int getLeftChildIdx(int index){
       return index*2+1;
     }

     /*Calculate and return the right child index of the parameter index.
This method is irrelevant to what is currently in data and should not make any changes to data.
You do not need to check if index >= 0*/


     protected int getRightChildIdx(int index){
       return index*2+2;
     }

     /*Return the index of the smaller child of the element at index. If the two children are equal, return the index of the left child. If the node at index is a leaf (has no children), return -1.
Note that it's also possible for a single node in our heap to have only one child. In this case, return the index of the left child (we know that this is a heap so all nodes are as far left as possible)
You can assume that index will be within bounds
Depends on what is currently in data but does not make any changes to data*/


     protected int getMinChildIdx(int index){
      if(this.getLeftChildIdx(index) > data.size()-1){ //index is a leaf
         return -1;
       }
      if(this.getRightChildIdx(index) > data.size()-1){ //index only has one child
        return this.getLeftChildIdx(index);
      }
      if(data.get(this.getLeftChildIdx(index)).compareTo(
          data.get(this.getRightChildIdx(index))) > 0){ //right smaller than left
            return this.getRightChildIdx(index);
          }
      else{ //left is smaller or they are equal
        return this.getLeftChildIdx(index);
      }
     }

     /*Percolate the element at index up until no heap properties are violated by this element (the heap properties will not be violated once this elements parent is not greater than it). Do this by swapping the element with its parent as needed.
Note the case where the element that you are percolating is equal to the parent. In this case, the heap property requiring that a node be no greater than its children is already satisfied, so you should not swap the element you are percolating with the parent.
You can assume that index will be within bounds
Makes changes in data*/


     protected void percolateUp(int index){
       if(data.get(index).compareTo(data.get(this.getParentIdx(index))) < 0){ //<
         this.swap(index, this.getParentIdx(index));
         this.percolateUp(this.getParentIdx(index));
       }
     }

     /*Percolate the element at index down until no heap properties are violated by this element (the heap properties will not be violated once this element is not greater than its children). If swapping is needed, always swap places with the smaller child. If both children are equal and swapping is needed, swap with the left child.
Note the case where the element that you are percolating is equal to the smaller child. In this case, the heap property requiring that a node be no greater than its children is already satisfied, so you should not swap the element you are percolating with the child.
You can assume that index will be within bounds
Makes changes in data*/
     protected void percolateDown(int index){
       if(this.getMinChildIdx(index) == -1){
         return;
       }

       if(data.get(index).compareTo(data.get(this.getMinChildIdx(index))) > 0){ //>
         int minIdx = this.getMinChildIdx(index);
         this.swap(index, minIdx);
         this.percolateDown(minIdx);

       }
     }


/*     Remove the element at index from data and return it.
If we are removing the last element then the heap properties are maintained.
In other cases, we will replace the deleted element with the last element in the heap (the right-most node in the bottom-most level of the heap) to fix the completeness property.
Then, either percolate this element down or percolate this element up as necessary until no heap properties are violated by this element (only one of these actions will be necessary to maintain the heap property, all fixes to the key order property should be by percolating the replacement element).
The deleteIndex explanation can be found in the Appendix.
You can assume that index will be within bounds
Makes changes in data*/
     protected E deleteIndex(int index){
       E ans = data.get(index);
       data.set(index, data.get(data.size()-1));
       data.remove(data.size()-1);
       this.percolateDown(index);
       return ans;
     }

    /*Add element to the end of the heap (so that it is the right-most element in the bottom-most level) and percolate only the inserted element up until no heap properties are violated (all fixes to the heap properties should be by this percolation)

    Throw a NullPointerException and do not add to the heap if element is null.*/
    public void insert(E element){
      data.add(element);
      this.percolateUp(data.size()-1);
    }

    /*Return the root (this will be the smallest) element of the heap.
If the heap is empty, return null instead.*/
    public E getMin(){
      if(data.size() == 0){
        return null;
      }
      else{
        return data.get(0);
      }
    }

    /*Remove and return the root (this will be the smallest) element in the heap. Use deleteIndex() helper method here.
If the heap is empty return null instead.*/
    public E remove(){
      if(data.size() == 0){
        return null;
      }
      return this.deleteIndex(0);
    }

    /*Return the number of elements in this min-heap.*/
    public int size(){
      return data.size();
    }

    /*Clear out the entire heap (the heap should be empty after this call)*/
    public void clear(){
      data.clear();
    }










}
