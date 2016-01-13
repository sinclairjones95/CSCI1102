import java.util.*;
import java.io.*;

/*Written by John Donaldson
 * 
 * 
 * Edited by Richard S. Jones and Jacob Martz
 * 
 */


class HuffmanCode {

    TreeNode root;
    Map<Character,String> codeMap;
    Map<Character,Double> freqMap;
    
    
    class TreeNode implements Comparable<TreeNode> {
      double freq;
      char letter;
      TreeNode left,right;

      TreeNode(double freq,TreeNode left,TreeNode right){
        this.freq = freq;
        this.left = left;
        this.right = right;
      }

      TreeNode(double freq){
        this(freq,null,null);
      }

      TreeNode(char letter, double freq){
        this.freq = freq;
        this.letter = letter;
        this.left = this.right = null;
      }

      public boolean isLeaf(){
        return left==null && right==null;
      }

      public int compareTo(TreeNode other){
        if(this.freq==other.freq){
          return 0;
        } 
        else if(this.freq>other.freq){
          return 1;
        }
        else {
          return -1;
        }
      }
    }

   
    HuffmanCode(Map<Character,Double> freqMap){
      this.freqMap = freqMap;

      PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<TreeNode>();
      for(Character x : freqMap.keySet()){
        TreeNode treeNode = new TreeNode(x, freqMap.get(x));
        priorityQueue.add(treeNode);
      }
      
      while(priorityQueue.size()>1){
        TreeNode n1 = priorityQueue.remove();      //takes the lowest freq
        TreeNode n2 = priorityQueue.remove();      // takes new lowest freq
        TreeNode treeNode = new TreeNode(n1.freq + n2.freq, n1, n2);    //creates new node with the sum of frequencies
        priorityQueue.add(treeNode);
      }
      root = priorityQueue.remove();

      codeMap = new TreeMap<Character,String>();
      buildCodeMap(root, codeMap, "");
    }

     public void buildCodeMap(TreeNode node,Map<Character,String> codeMap, String code){
      if(!node.isLeaf()){
        buildCodeMap(node.left, codeMap, code + "0");   //concatinates 0 for going left and 1 for going right
        buildCodeMap(node.right, codeMap, code + "1");
      }
      else {
        codeMap.put(node.letter, code);               //returns string of 01s corresponding to each letter
      }
    }

    

    public String encode(String plain){
      StringBuilder code  = new StringBuilder();
      for(int i=0; i<plain.length(); i++){
        String letterCode = ""+codeMap.get(String.valueOf(plain.charAt(i)));
        
        if(!(letterCode==null)){
          code.append(letterCode);
        }
        else {
          System.out.println("The followind character is invalid: "+plain.charAt(i));
        }
        
      }
      return new String(code);
    }

    public String decode(String code){
      StringBuilder decoded = new StringBuilder();
      TreeNode pos = root;                     //position in treeMap
      for(int i=0; i<code.length(); i++){      //iterates through the length of input
       
        char number = code.charAt(i);      
        String numberComp = "" + number;    //changed to a string to use equals method
        
        if(numberComp.equals("0")){
          pos = pos.left;                     
        }else {
          pos = pos.right;
        }
        if(pos.isLeaf()){      
          char nextchar = (char) (int) pos.letter;
          decoded.append(nextchar);                  //append to StringBuilder
          pos = root;                               //goes back to the root after going down to a leaf
        }
      }
      return new String(decoded);
    }

    public double bitsperchar(){
      double average = 0;
      for(Character charac : codeMap.keySet()){ 
        
        average += codeMap.get(charac).length()*freqMap.get(charac);    //multiplies every length by frequcny 
      
      }
      return average;
    }

    public static void main(String[] args){     //main method
      Scanner scanner = null;
      try {        
        if(args.length>0){
          scanner = new Scanner(new File(args[0]));       //reads from file given
        }
        else {
          scanner = new Scanner(System.in);              //or from system in to use as frequencies
        }
      }
      catch(IOException e){
        System.out.println(e+args[0]);
        System.exit(0);
      }

      Map<Character,Double> freqMap = new TreeMap<Character,Double>();
      while(scanner.hasNext()){
        char value = (char) scanner.nextInt();
        double frequency = scanner.nextDouble();
        freqMap.put(value, frequency);
      }

      HuffmanCode code = new HuffmanCode(freqMap);
      Map<Character,String> codeMap = code.codeMap;
      
      for(Character key : codeMap.keySet()){      
        System.out.println(key+" \t \t "+codeMap.get(key));         
      }
  
      System.out.println("Expected bits per character: "+code.bitsperchar());
    }

}





