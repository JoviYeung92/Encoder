package main;

import java.util.Scanner;

import decoder.Decoder;
import encoder.Encoder;

public class Main {
	
	public static void main(String[] args) {
		
	    String output; 
		
	    // Create a scanner to read input from the command line
	    Scanner scanner = new Scanner(System.in);

	    // Prompt the user to enter a plaintext string
	    System.out.print("Enter a plaintext string: ");
	    String plaintext = scanner.nextLine();
	    
	    System.out.print("Enter a offset Char: ");
	    String input = scanner.next();
	    char offsetChar = input.charAt(0);
	    
	    Encoder encoder = new Encoder();
	    Decoder decoder = new Decoder();
	    
	    output = encoder.encode(plaintext,offsetChar);
	    //output = decoder.decode(plaintext, offsetChar);
	    
	    System.out.println(output);
	    
	}
	
	
	
}
