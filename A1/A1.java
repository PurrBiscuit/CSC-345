/**
 * CSC 345-01 Assignment #1 (version 1.1)
 * 
 * On my honor, Steve Purr, this assignment is my own work.  
 * I, Steve Purr, will follow the instructor's rules and processes 
 * related to academic integrity as directed in the course syllabus.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Students -- Add your import declarations here

public class A1 {
   // set some reusable defaults
   private static String defaultLexeme = "";
   private static boolean defaultLexemeComplete = false;

   // global variables for use throughout analyzer
   private static String lexeme = defaultLexeme;
   private static boolean lexemeComplete = defaultLexemeComplete;
   private static int lexemeType;

	// Students -- Add your constants here
   private static final int
      FLOATDCL = 0,
      INTDCL = 1,
      PRINT = 2,
      ID = 3,
      ASSIGN = 4,
      PLUS = 5,
      MINUS = 6,
      INUM = 7,
      FNUM = 8,
      UNKNOWN = -1;

	public static void main(String[] args) {
		try {
			// Do NOT make any changes to the following TWO lines
			File file = new File(args[0]);		
			Scanner sc = new Scanner(file);		//*** Do not make any other Scanners ***//

			// *** NOTE ***
			// For this assignment, you are NOT allowed to use any member methods of 
			// class java.util.Scanner except hasNextLine and nextLine.  
			// For example, you CANNOT use any of hasNextInt, nextInt, hasNextFloat, nextFloat, 
			// hasNextDouble and nextDouble for this assignment.  
			
			// Students -- Your code and methods calls go here
			while (sc.hasNextLine()) {
            parseLine(sc.nextLine());
         };
			
			
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR - cannot open front.in \n");
		}
	}
	
	// Students -- Add your method declarations here
   private static void analyzeCharacter(char c) {

   }

   private static void parseLine(String line) {
      System.out.println("next line is ->" + line);
      System.out.println("line length is ->" + line.length());
      
      int lineLength = line.length();
      
      for (int i = 0; i < line.length(); i++) {
         // set the lexeme values back to defaults
         // if previous lexeme was successfully processed.
         if (lexemeComplete) {
            lexemeComplete = defaultLexemeComplete;
            String lexeme = defaultLexeme;
         }

         analyzeCharacter(line.charAt(i));

         if (lexemeComplete) printLexeme();
      }
   }
   
   private static void printLexeme() {
      System.out.println("Next token is: " + lexemeType + ", Next lexeme is " + lexeme);
   }
}