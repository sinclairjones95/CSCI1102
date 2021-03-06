import java.util.*;

/*
 *Author: Richard S. Jones
 * 
 */

public class LinkedQueue<T> implements QueueADT<T>{
  
  public class ListNode {
    T data;
    ListNode next;
    
    ListNode(T data, ListNode next){
      this.data = data;
      this.next= next;
    }
  }
  
  ListNode front;
  ListNode rear;
  
  public LinkedQueue(){
    front = null;
    rear= null;
  }
  
  public boolean isEmpty(){
    return front==null;
  }
  
  public void clear(){
     front = null;
     rear = null;
  }
   
  public T dequeue(){       //front of the queue
    if (isEmpty()){
      throw new RuntimeException("This queue is empty");
    }
    T oldfront = front.data;       //get the data from old front
    front = front.next;            //front is overwritten by the next front
    if (isEmpty()==true){     //check if the queue is empty 
      rear = null;
    }
    return oldfront;
  }
   
  public void enqueue(T item){      //rear of the queue
     ListNode newrear = new ListNode(item, null);
     ListNode oldrear = rear;    //old rear is stored in variable oldrear
     rear = newrear;    //rear is overwritten by rear
     if (isEmpty()==true){
       front = rear;     
     }
     else {
       oldrear.next = rear;     //pointer to connect the old rear to the new rear
     }
  }
   

  public void append(LinkedQueue<T> q){       //attach q front to this rear
    if (this.isEmpty()){
      this.front = q.front;
    }
    else{
      this.rear = q.front;
    }
  }
  
}