/**
 * Load a tree from a text file.  Format is line based, with each line
 * consisting of a String for data, followed by two ints indicating if
 * the node has a left child or right child.  (1 is yes, 0 is no).
 * Ordering of nodes is postorder.
 *
 * @author John Donaldson
 * @author Benjamin Kuperman (Spring 2007)
 * @author Alexa Sharp (Fall 2012)
 */

import java.io.*;
import java.util.*;

public class TreeLoader {

    static BinaryTree<String> loadTreeFromFile(String fname) throws IOException
    {
      boolean first = true;
      BinaryTree<String> root=null;
      
      Scanner scan = new Scanner(new File(fname));
      
      //create an empty stack of binary trees
      List<BinaryTree<String>> list = new ArrayList<BinaryTree<String>>();
      
      while (scan.hasNextLine()){
        String line = scan.nextLine();
        if(line.trim().length()==0)
           continue;
        String[] s = line.split(" ");
        if(first){
           first = false;
           root = new BinaryTree<String>(s[0], new BinaryTree<String>(), new BinaryTree<String>());
           list.add(root);
        }
        else {  
           if(s.length>=3){
              BinaryTree<String> tree = new BinaryTree<String>(s[0], new BinaryTree<String>(), new BinaryTree<String>());
              list.add(tree);
              int parent = Integer.parseInt(s[2]);
              if(s[1].equals("L")){
                 list.get(parent).setLeft(tree);
              }
              else {
                 list.get(parent).setRight(tree);
              }
           }
        }
      }
      if(list.isEmpty())
        return new BinaryTree<String>();
      else
        return root;
    }

    // So you can test your tree loader
    public static void main(String[] args) throws IOException {
        if(args.length!=1){
            System.out.println("Usage:  java TreeLoader filename");
        }
        else {
            TreeLoader tl = new TreeLoader();
            BinaryTree<String> t = tl.loadTreeFromFile(args[0]);
            System.out.println(t);
        }
    }
}
