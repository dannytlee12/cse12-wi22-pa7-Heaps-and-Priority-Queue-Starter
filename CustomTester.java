/**
 * 
 * Name: Danny Lee
 * ID: A17209209
 * Email: dtl001@ucsd.edu
 * Sources used: zybooks
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 *
 * 2-4 sentence file description here
 This file contains the CustomTester class which tests the edge cases for the
 MyMinHeap class.
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 This class tests the edge cases for the methods of the MyMinHeap class.
 *
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {


    /**
     * Test the constructor when [theres a null in the collection being
      passed into the constructor]
     */
    @Test
    public void testMyMinHeapConstructor() {
      try{
        ArrayList<Integer> inputList2 = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 5, 4, 1, 7, null, 9, 6, 3 }
            )
        );
        MyMinHeap<Integer> minHeap2 = new MyMinHeap<>(inputList2);
        fail();
      } catch(NullPointerException e) {}
    }

    /**
     * Test the getMinChildIdx method when [used on a leaf]
     */
    @Test
    public void testGetMinChildIdx() {
      ArrayList<Integer> inputList = new ArrayList<Integer>(
          Arrays.asList(
                  new Integer[] { 5, 4, 1, 7, 2, 9, 6, 3 }
          )
      );
      MyMinHeap<Integer> minHeap = new MyMinHeap<>(inputList);
      assertEquals("-1 returned for leaves", -1, minHeap.getMinChildIdx(6));
    }

    /**
     * Test the percolateUp method when [equal to its parent]
     */
    @Test
    public void testPercolateUp() {
      ArrayList<Integer> inputList2 = new ArrayList<Integer>(
          Arrays.asList(
                  new Integer[] { 1,2,1 }
          )
      );
      MyMinHeap<Integer> minHeap2 = new MyMinHeap<>(inputList2);
      minHeap2.percolateUp(2);
      assertEquals((Integer)1, minHeap2.data.get(0));
      assertEquals((Integer)2, minHeap2.data.get(1));
      assertEquals((Integer)1, minHeap2.data.get(2));
    }

    /**
     * Test the percolateDown method when [equal to its child]
     */
    @Test
    public void testPercolateDown() {
      ArrayList<Integer> inputList2 = new ArrayList<Integer>(
          Arrays.asList(
                  new Integer[] { 1,2,1 }
          )
      );
      MyMinHeap<Integer> minHeap2 = new MyMinHeap<>(inputList2);
      minHeap2.percolateDown(0);
      assertEquals((Integer)1, minHeap2.data.get(0));
      assertEquals((Integer)2, minHeap2.data.get(1));
      assertEquals((Integer)1, minHeap2.data.get(2));
    }

    /**
     * Test the deleteIndex method when [deleting the root of the heap]
     */
    @Test
    public void testDeleteIndex() {
      ArrayList<Integer> inputList = new ArrayList<Integer>(
          Arrays.asList(
                  new Integer[] { 5, 4, 1, 7, 2, 9, 6, 3 }
          )
      );
      MyMinHeap<Integer> minHeap = new MyMinHeap<>(inputList);
      minHeap.deleteIndex(0);
      Integer[] expected2 = {2,3,5,7,4,9,6};
      for(int i = 0; i < expected2.length; i++){
        assertEquals(expected2[i], minHeap.data.get(i));
      }
    }

    /**
     * Test the deleteIndex method when [deleting the only element of a heap]
     */
    @Test
    public void testDeleteIndex2() {
      ArrayList<Integer> inputList2 = new ArrayList<Integer>(
          Arrays.asList(
                  new Integer[] { 1 }
          )
      );
      MyMinHeap<Integer> minHeap2 = new MyMinHeap<>(inputList2);
      minHeap2.deleteIndex(0);
      assertEquals(0, minHeap2.size());
    }

    /**
     * Test the insert method when [attempting to insert a null]
     */
    @Test
    public void testInsert(){
      ArrayList<Integer> inputList = new ArrayList<Integer>(
          Arrays.asList(
                  new Integer[] { 5, 4, 1, 7, 2, 9, 6, 3 }
          )
      );
      MyMinHeap<Integer> minHeap = new MyMinHeap<>(inputList);
      try{
        minHeap.insert(null);
        fail();
      } catch(NullPointerException e){}
    }

    /**
     * Test the insert method when [inserting the some less than the
     current root]
     */
    @Test
    public void testInsert2(){
      ArrayList<Integer> inputList = new ArrayList<Integer>(
          Arrays.asList(
                  new Integer[] { 5, 4, 1, 7, 2, 9, 6, 3 }
          )
      );
      MyMinHeap<Integer> minHeap = new MyMinHeap<>(inputList);
      minHeap.insert(-20);
      Integer[] expected2 = {-20,1,5,2,4,9,6,7,3};
      for(int i = 0; i < expected2.length; i++){
        assertEquals(expected2[i], minHeap.data.get(i));
      }
    }


    /**
     * Test remove when [the root's children are equal]
     */
    @Test
    public void testRemove(){
      ArrayList<Integer> inputList2 = new ArrayList<Integer>(
          Arrays.asList(
                  new Integer[] { 1,2,2 }
          )
      );
      MyMinHeap<Integer> minHeap2 = new MyMinHeap<>(inputList2);
      minHeap2.remove();
      assertEquals((Integer)2, minHeap2.data.get(0));
      assertEquals((Integer)2, minHeap2.data.get(1));
      assertEquals(2, minHeap2.size());
    }


    /**
     * Test getMin when [a new min has just been added]
     */
    @Test
    public void testGetMin(){
      ArrayList<Integer> inputList2 = new ArrayList<Integer>(
          Arrays.asList(
                  new Integer[] { 2,2,2 }
          )
      );
      MyMinHeap<Integer> minHeap2 = new MyMinHeap<>(inputList2);
      minHeap2.insert(-20);
      assertEquals((Integer)(-20), minHeap2.getMin());
      assertEquals((Integer)(-20), minHeap2.data.get(0));
      assertEquals((Integer)2, minHeap2.data.get(1));
      assertEquals(4, minHeap2.size());
    }
}
