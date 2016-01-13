/*
 * OrderedLinkedList
 * 
 * This class implements the Java List interface using a doubly-linked list.
 * 
 * Two nested classes are included:  ListNode and OrderedLinkedListIterator.
 * 
 */

/* Edited by Richard S. Jones
 */
import java.util.*;


public class OrderedLinkedList<T extends Comparable<T>> extends AbstractList<T> {
   int size;
   ListNode header, trailer;
   Comparator<T> comparator;
   
   /*
    * ListNode
    * 
    * This class represents one node in a doubly linked list.
    */
   protected class ListNode {
      T datum;
      ListNode prior, next;
      
      ListNode(){
         this(null);
      }
      
      ListNode(T data){
         this(data,null,null);
      }
      
      ListNode(T data, ListNode prior, ListNode next){
         this.datum = data;
         this.prior = prior;
         this.next = next;
      }
   }
   
   /*
    * Constructs an empty list without a Comparator.
    */
   OrderedLinkedList(){
      // TODO:  Write a constructor to construct an empty list.
      // The empty list has two sentinel nodes, a header and a trailer, linked to each other
      header = new ListNode(null,null,null);
      trailer = new ListNode(null,header,null);
      header.next = trailer;
   }

   /*
    * Constructs an empty list with a Comparator.
    */
   OrderedLinkedList(Comparator<T> comparator){
      this();
      this.comparator = comparator;
   }
  
   /*
    * Returns a reference to the nth node in the list.
    */
   private ListNode getNthNode(int n) {
      // scan left to right for the nth node in the list
      // this is a helper method for add, remove, get, set
      if(n<-1 || n>size)
         throw new IndexOutOfBoundsException();
      
      ListNode node = header;
      for(int i=-1; i<n; i++)
         node = node.next;
      return node;
   }
   
   /*
    * Returns a count of the number of elements in the list.
    */
   public int size() {
      return size;
   }
   
   /*
    * Deletes all elements from the list.
    */
   public void clear() {
      size = 0;
      header.next = trailer;
      trailer.prior = header;
   }

   /*
    * Determines if the list is empty.
    */
   public boolean isEmpty() {
      return size==0;
   }

   /*
    * Creates an iterator for the list
    */
   public Iterator<T> iterator(){
      return new Iterator<T>(){
         ListNode current = header.next;
         
         public boolean hasNext(){
            return current!=trailer;
         }
         public T next(){
            T item = current.datum;
            current = current.next;
            return item;
         }
         public void remove(){
            ListNode prior = current.prior.prior;
            prior.next = current;
            current.prior = prior;
            size--;
         }
      };
   }
   
   /*
    * Returns the data item at the given position in the list.
    */
   public T get(int position) {
      if(position>=size || position<0)
         throw new NoSuchElementException();
      return getNthNode(position).datum;
   }
   
   /*
    * This method is not valid for ordered lists.
    */
   public T set(int position, T data) {
      throw new UnsupportedOperationException();
   }
   
   /*
    * This method is not valid for ordered lists.
    */
   public void add(int position, T data) {
      throw new UnsupportedOperationException();
   }
   
   /*
    * Inserts the given data item at the end of the list.
    */
   public boolean add(T data) {    //this is wrong, needs to add the data in the position keeping in order
     
     ListNode n = new ListNode(data,null,null);
     ListNode current = header.next;
     int crit;
     for (int i=0; i<size(); i++){        //iterate through list
       
       if(comparator!=null){                 //to check if the list has a comparator
         crit = comparator.compare(data, current.datum);       //given comparator
       } 
       else {
         Comparable data1 = (Comparable)data;
         Comparable data2 = (Comparable)(current.datum);
         crit = data1.compareTo(data2);             //comparable 
       }
       if (crit<=0){
         n.next=current;
         n.prior=current.prior;
         (current.prior).next=n;
         current.prior=n;
         size++;
         return true;
       }
       current=current.next;
     }                           //at this moment current=trailer, add at the end of the list    
     n.next = current; 
     n.prior = current.prior;
     current.prior.next = n;
     current.prior= n; 
     size++;
      return true;
     
   }
   
   /*
    * Removes the element at a given index in the list.
    */
   public T remove(int index) {
     
     ListNode current = getNthNode(index);     //creates a reference to the ListNode at index
     ListNode priorNode = current.prior;     //calls the prior ListNode from current
     ListNode nextNode = current.next;
     priorNode.next=nextNode;           //overwrittes the pointers
     nextNode.prior=priorNode; 
     size--;
      return current.datum;  
   }
   
   public boolean contains(Object o){
       ListNode current=header.next;
       for (int i=0; i<size(); i++){    //condition to check if iterated thorugh all the list
         if (current.datum.equals(o)){
           return true;
         }
         current=current.next;
       }
      return false;
   }
   
   public boolean remove(Object o){
     ListNode current=header.next;
     for (int i=0; i<size(); i++){
       if (current.datum.equals(o)){
         ListNode previous= current.prior;
         ListNode following = current.next;
         previous.next = following;
         following.prior=previous;
         size--;
         return true;
       }
       current=current.next;
     }
      return false;  // replace this line
   }
   
   public int indexOf(Object o){
      int index = 0;
      ListNode current=header.next;
      for (int i=0; i<size(); i++){
        if (current.datum.equals(o)){
          return index;
        }
        index++;
        current=current.next;
      }
      return -1;
   }

}

