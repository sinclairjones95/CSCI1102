import java.util.*;
import junit.framework.TestCase;
class MyPriorityQueue<E> implements PriorityQueueADT<E> {
   
   ArrayList<E> heap;
   Comparator<E> comparator;
      
   MyPriorityQueue(Comparator<E> comparator){
      this.comparator = comparator;
      heap = new ArrayList<E>();
   }
   
   public boolean add(E item){
      heap.add(item);
      siftUp();
      return true;
   }
   
   public E remove(){
     if(!isEmpty()){

        E retVal = heap.remove(0);
        E lastVal = heap.remove(heap.size()-1);
        heap.add(0, lastVal);
        siftDown();
        return retVal;
     } else{
       return null;
     }
   }
   
   public boolean isEmpty(){      
      return !(heap.size()>0);
   }
   
   public String toString(){
      //TODO:  Write this method
      return "";
   }
   
   private void siftUp(){
      int index = heap.size() - 1;                   //initial is the last index on the arraylist

      while (index>0 && (comparator.compare(heap.get(index), heap.get((index-1)/2)) > 0) ){     // while index> 0 and value at node is larger than parent node

        E temp = heap.get( (index-1)/2 );         //temporary variable to store E
        
        heap.set( ((index-1)/2), heap.get(index));   //overwrites parent val with chikd
        heap.set(index, temp);                       //swap
        index = (index-1)/2;                         //new index is parent's index
        
      }
   }
         
   private void siftDown(){
      int index = 0;                                 //initial is the first index on the arraylist
      E largerChild;
      int childIndex;
      E child1;
      E child2;
      if ((2*index + 1) <= heap.size() - 1){
        if((2*index + 2) <= heap.size() - 1){
          child1 = heap.get(2*index + 1);
          child2 = heap.get(2*index + 2);
          if (comparator.compare(child1, child2)>=0){
            largerChild = child1;
            childIndex = 2*index +1;
          } else{
            largerChild = child2;
            childIndex = 2*index +2;
          }
        } else {
          largerChild = heap.get(2*index + 1);
          childIndex = 2*index +1;
        }

      }else {
        return;
      }
     
      while (((2*index + 1) < heap.size()-1) && comparator.compare(heap.get(index), largerChild)<0) {     // while index> 0 and value at node is larger than parent node
        
        heap.set(childIndex, heap.get(index));    //swapping
        
        heap.set(index, largerChild);             //swapping

        index = childIndex;                       //updating values for next iteration
        if ((2*index + 1) <= heap.size() - 1){
          if((2*index + 2) <= heap.size() - 1){
            child1 = heap.get(2*index + 1);
            child2 = heap.get(2*index + 2);
            if (comparator.compare(child1, child2)>=0){
              largerChild = child1;
              childIndex = 2*index +1;
            } else{
              largerChild = child2;
              childIndex = 2*index +2;
            }
          } else {
            largerChild = heap.get(2*index + 1);
            childIndex = 2*index +1;
          }
        } else{
          return;
        }
   
      }
   }   
   
}