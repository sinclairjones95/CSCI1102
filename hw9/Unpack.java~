/*
 Unpack 
 This program reads a binary file from System.in and converts
 each byte of the input into a string of the ASCII characters
 '0' and '1'.  The resulting sequence of characters is written
 to System.out.

 @author John Donaldson
 */
import java.util.*;
import java.io.*;

class Unpack {

    public static void unpack(StringBuilder b, ArrayList<Byte> arr){
	int n = arr.get(0);
	int len = 8*arr.size()-16+(n==0?8:n);

	for(int i=0; i<len; i++){
	    int index = i/8+1;
	    int bitpos = i%8;
	    int bit = (arr.get(index)>>(7-bitpos)) & 1;
	    b.append(bit==0?'0':'1');
	}
    }

    public static void main(String[] args) throws IOException {
	ArrayList<Byte> packed = new ArrayList<Byte>();
	StringBuilder codeBuilder = new StringBuilder();

	int b = System.in.read();
	while(b>=0){
	    packed.add((byte)b);
	    b = System.in.read();
	}
	unpack(codeBuilder,packed);

	System.out.print(codeBuilder);
    }
}
