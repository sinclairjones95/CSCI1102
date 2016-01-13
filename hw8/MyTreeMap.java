/**
 * An implementation of the MapADT interface using an AVL tree.
 * Empty trees are used to represent children that aren't present.
 * 
 * @author John Donaldson
 */

/*
 * 
 * Edited by Richard S. Jones
 */

// You need to implement the following methods to complete the class:
//  - get()
//  - put()
//  - part of restructure()

import java.util.*;

public class MyTreeMap<K extends Comparable<? super K>,V> 
implements MapADT<K,V> {

   // instance variables
   /** The index by which information is stored */
   K key;
   /** Value associated with the key above */
   V value;
   /** The children of this subtree -- if both null, this tree is empty */
   MyTreeMap<K,V> left,right;
   /** The number of nodes within this subtree (including self) */
   int size;
   /** The height of this subtree */
   int height;
   
   // change this value to true and the rotations will be printed
   private boolean debug = false;
   
   //--------------------------------------------------------------------------
   // Things TODO - I've moved all the methods you need to change up to here
   //--------------------------------------------------------------------------
   
   // TODO - implement me! - and add some comments
   public V get(K searchKey) {
      if (!isEmpty()){
        int compared = searchKey.compareTo(key);
        if (compared==0){        //if they are equal, it returns the value found
          return value;
        } else if (compared<0){         // if searchKey<key calls left recursively
          return left.get(searchKey);
        } else {
          return right.get(searchKey);  // if searchKey>key calls right recursively
        }
      } else {                          //when reaching an empty node, means the key does not exist
        return null;
      }
   }
   
   // TODO - implement me too! - and add some comments
   public V put(K key, V value){
     if(!isEmpty()){
       int compared = key.compareTo(this.key);
        if (compared==0){        //if they are equal, it returns the value found
          V oldvalue = this.value;
          this.value = value;
          return oldvalue;
        } else if (isLeaf()){   //if is Leaf and if not equal to value
          if (compared<0){         
            left.key = key;
            left.value = value;
            left.size = 1;
            left.height = 0;
            left.left = new MyTreeMap<K, V>();
            left.right = new MyTreeMap<K, V>();            
          } else {
            right.key = key;
            right.value = value;
            right.size = 1;
            right.height = 0;
            right.left = new MyTreeMap<K, V>();
            right.right = new MyTreeMap<K, V>();
          }             
        } else {
          if (compared<0){         // if searchKey<key calls left recursively
            left.put(key, value);
          } else {
            right.put(key, value);  // if searchKey>key calls right recursively
          }
        }
        int heightDif = left.getHeight() - right.getHeight();      //ask how are heights changed without setting new heights
        if (heightDif>1 || heightDif<-1) {
            restructure();
        }
        setHeight();
        setSize(); 
        return null;
     } else {
       this.key = key;
       this.value = value;
       this.size = 1;
       this.height = 0;
       this.left = new MyTreeMap<K, V>();
       this.right = new MyTreeMap<K, V>();
       
       return null;
     }
   }
     
   /**
    * Rebalances an AVL internal node using the restructure algorithm from 
    * class. Suppose Z is the node that fails the height balance property,
    * and let Y be Z's tallest child, and X be Y's tallest child.
    * Given these labels, let a, b, and c be the value of X,Y,Z in sorted order,
    * whatever that may be (so, if the tree looks like
    * 
    *                  Z
    *                /   \
    *               Y     o
    *              / \       
    *             o   X        
    *                / \       
    *               o   o
    *
    * then the sorted order is Y,X,Z, and therefore a is Y's value, 
    * b is X's value, and c is Z's value.)
    * Let t0, t1, t2, and t3 be the subtrees from left to right (so in
    * the example above, t0 is Y's left subtree, t1 is X's left subtree,
    * t2 is X's right subtree, and t3 is Z's right subtree.)
    * You will be setting these variables according to the definitions
    * above, and depending on which subtrees are causing the imbalance.
    * Once you've made these assignments, the provided code will return the
    * tree with the final arrangement of
    *
    *                  b
    *                /   \
    *               a     c
    *              / \   / \
    *             t0 t1 t2 t3
    *
    * @param node Internal node failing the height balance property
    */
   private void restructure() {
      // fill in these values such that
      //      a < b < c
      // and
      //      t0->t3 are the left to right trees
      MyTreeMap<K,V> a, b, c, t0, t1, t2, t3;
      
      if (left.height > right.height) {
         // left side taller, right subtree is last
         if (left.left.height > left.right.height) {
            // left->left
            if (debug) System.err.println("Single right rotation at: "+key);
            
            c = this;
            b = left;
            a = left.left;
            t0 = a.left;
            t1 = a.right;
            t2 = b.right;
            t3 = c.right;
            
         } else {
            // left->right turn
            if (debug) System.err.println("Double right rotation at: "+key);
            
            c= this;
            b = left.right;
            a = left;
            t0 = a.left;
            t1 = b.left;
            t2 = b.right;
            t3 = c.right;                   
         }
      } else {
         if (right.right.height > right.left.height) {
            // right->right
            if (debug) System.err.println("Single left rotation at: "+key);
            
            a= this;
            b = right;
            c = right.right;
            t0 = a.left;
            t1 = b.left;
            t2 = c.left;
            t3 = c.right;
                   
         } else {
            // right->left turn
            if (debug) System.err.println("Double left rotation at: "+key);
            
            a = this;
            b = right.left;
            c = right;
            t0 = a.left;
            t1 = b.left;
            t2 = b.right;
            t3 = c.right;
                   
         }
      }
      
      
      // If you've done the above correctly, this should fix your current node
      // Don't change it!!
      MyTreeMap<K, V> newLeft = new MyTreeMap<K, V>(a.key,a.value,t0,t1);
      MyTreeMap<K, V> newRight = new MyTreeMap<K, V>(c.key,c.value,t2,t3);
      a.left = t0;
      a.right = t1;
      c.left = t2;
      c.right = t3;
      // now fix myself
      this.key = b.key;
      this.value = b.value;
      this.left = newLeft;
      this.right = newRight;
   }
   
   //--------------------------------------------------------------------------
   // ** NO CHANGES NEEDED BELOW - BUT YOU MIGHT WANT TO READ AND UNDERSTAND **
   //--------------------------------------------------------------------------
   
   
   //--------------------------------------------------------------------------
   // Constructors - outside users can only make an empty tree
   //--------------------------------------------------------------------------
   
   /**
    * Creates an empty tree.
    */
   public MyTreeMap(){
      this(null,null,null,null);
      this.size = 0;
      this.height = -1;
   }
   
   /**
    * Build a tree from existing components.  To be used only within MyTreeMap
    * and subchildren.  
    * @param key Key to store at this location
    * @param value Value to store at this location (associated with Key)
    * @param left An existing subtree, all Key values should be smaller than key
    * @param right An existing subtree, all Key values should be greater than key
    */
   
   protected MyTreeMap(K key, V value, MyTreeMap<K, V> left, MyTreeMap<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
      // fix the height
      setHeight();
      // and the size
      setSize();
   }
   
   
   /**
    * Used to construct a single leaf element.  Empty subtrees are put in place of
    * children to allow for recursive methods to not have to worry about null
    * pointers.
    * @param key Key to store at this location
    * @param value Value to store at this location (associated with Key)
    */
   
   protected MyTreeMap(K key, V value) {
      this(key,value,new MyTreeMap<K,V>(), new MyTreeMap<K,V>());
      height = 0;
      size = 1;
   }
   
   /**
    * Determine if this is a placeholder subtree for an empty leaf branch.
    * @return true only if this is a placeholder node, false otherwise
    */
   public boolean isEmpty(){
      return left==null && right==null;
   } 
   
   /**
    * Determine if this is a leaf node (not an empty node).
    * @return true if this node is not a placeholder and has no children
    */
   public boolean isLeaf() {
      return !isEmpty() && left.isEmpty() && right.isEmpty();
   }
   
   /**
    * Creates a StringBuffer (String takes too long) and then starts the
    * recursive traversal of nodes.
    * @return String representation of the (Key:Value) pairs
    */
   private String toStringHelper(){
      StringBuilder sbuf = new StringBuilder();
      toStringHelper(sbuf);
      return sbuf.toString();
   }
   
   /**
    * Adds (Key:Value) pairs inorder into the StringBuffer.
    * @param sbuf where to store the string version of the tree
    */
   private void toStringHelper(StringBuilder sbuf) {
      if(isEmpty())
         return;
      else {
         if(!left.isEmpty()) {
            left.toStringHelper(sbuf);
            sbuf.append(",");
         }
         sbuf.append( "("+key+":"+value+")" );
         if(!right.isEmpty()) {
            sbuf.append(",");
            right.toStringHelper(sbuf);
         }
      }
   }
   
   public String toString(){
      return "[" + toStringHelper() + "]";
   }
   
   // helper methods for trees
   private void setHeight() {
      if (isEmpty()) 
         this.height = -1;
      else
         this.height = 1+Math.max(left.height,right.height);
   }
   
   private void setSize(){
      if(isEmpty())
         this.size = 0;
      else
         this.size = 1+left.size+right.size;
   }
   
   public int size() {
      return this.size;
   }
   
   public int getHeight(){
      return this.height;
   }
   
   
   //--------------------------------------------------------------------------
   // Some iterators that you might find useful
   //--------------------------------------------------------------------------
   
   /**
    * Create an inorder iterator of the Keys in the tree.
    * @return inorder iterator of the Keys
    */
   
   public Iterator<K> keys() {
      List<K> list = new LinkedList<K>();
      addKeysToList(list);
      return list.iterator();
   }
   
   private void addKeysToList(List<K> l) {
      if (!isEmpty()){
         this.left.addKeysToList(l);
         l.add(this.key);
         this.right.addKeysToList(l);
      }
   }
   
   //--------------------------------------------------------------------------
   
   public Iterator<Map.Entry<K, V>> entries() {
      List<Map.Entry<K,V>> list = new LinkedList<Map.Entry<K,V>>();
      addEntriesToList(list);
      return list.iterator();
   }
   
   private void addEntriesToList(List<Map.Entry<K, V>> list) {
      if (!isEmpty()){
         this.left.addEntriesToList(list);
         list.add(new AbstractMap.SimpleEntry<K,V>(key,value));
         this.right.addEntriesToList(list);
      }
   }    
}
