/**
 * CSC 345-01 Assignment #2
 * 
 * On my honor, <Your Full Name>, this assignment is my own work.  
 * I, <Your Full Name>, will follow the instructor's rules and processes 
 * related to academic integrity as directed in the course syllabus.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Students -- Add your import declarations here

public class A2 {
	
	// Students -- Add your constants here
	
	public static void main(String[] args) {
		try {
			// Do NOT make any changes to the following TWO lines
			File file = new File(args[0]);		
			Scanner sc = new Scanner(file);		//*** Do not make any other Scanners ***//
			
			// Students -- Your code and methods calls go here
			
			
			
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR - cannot open front.in \n");
		}
	}
	
	// Students -- Add your method declarations here



}