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
import java.util.HashMap;

class UnknownLexemeException extends Exception {
   public UnknownLexemeException(String message) {
      super(message);
   }
}

public class A1 {
	// Students -- Add your constants here
   private static final String defaultLexeme = "";
   private static final boolean defaultLexemeComplete = false;
   private static final int
      FLOATDCL = 0,
      INTDCL = 1,
      PRINT = 2,
      ID = 3,
      ASSIGN = 4,
      PLUS = 5,
      MINUS = 6,
      INUM = 7,
      FNUM = 8;

   // global variables for use throughout analyzer
   private static char lastChar;
   private static String lexeme = defaultLexeme;
   private static boolean isLexemeComplete = defaultLexemeComplete;
   private static int lexemeType;
   private static boolean unknownLexemeEncountered = false;
   private static HashMap<Character, Integer> reservedLexemes = new HashMap<Character, Integer>();

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
         reservedLexemes.put('f', FLOATDCL);
         reservedLexemes.put('i', INTDCL);
         reservedLexemes.put('p', PRINT);
         reservedLexemes.put('=', ASSIGN);
         reservedLexemes.put('+', PLUS);
         reservedLexemes.put('-', MINUS);

			while (sc.hasNextLine() && !unknownLexemeEncountered) {
            parseLine(sc.nextLine());
         };

			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR - cannot open front.in \n");
		}
	}
	
	// Students -- Add your method declarations here

   // analyzes each character and puts together the
   // appropriate lexemes based on the incoming characters
   private static void analyzeCharacter(char c, String line, int index)
      throws UnknownLexemeException {
      // set all the reserved and id lexemes
      if (reservedLexemes.containsKey(c) || Character.isLowerCase(c)) {
         lexemeType = reservedLexemes.getOrDefault(c, ID);
         lexeme = Character.toString(c);
         isLexemeComplete = true;
         return;
      }

      // set integer lexemes
      if (Character.isDigit(c)) {
         if (lexeme.equals(defaultLexeme)) lexemeType = INUM;
         lexeme += c;
         isLexemeComplete = isDigitLexemeComplete(line, index);

         return;
      }

      // set floating lexemes
      if (c == '.' && Character.isDigit(lastChar)) {
         // throw error if the lexeme already contains a decimal
         if (lexeme.contains("."))
            throw new UnknownLexemeException("Floating lexeme already contains a decimal.");

         lexemeType = FNUM;
         lexeme += c;
         return;
      }

      // throw a new UnknownLexemeException
      // if no conditions above were matched
      throw new UnknownLexemeException("Unknown lexeme encountered.");
   }

   // determines if the digit lexeme is complete or not
   private static boolean isDigitLexemeComplete(String line, int index) {
      try {
         char nextChar = line.charAt(index + 1);

         // if the next char is a digit or .
         // then the digit is incomplete
         return !Character.isDigit(nextChar) && nextChar != '.';
      // end of the string indicates digit is complete
      } catch (StringIndexOutOfBoundsException e) {
         return true;
      }
   }

   // analyze each character from a single line of text from the input file
   private static void parseLine(String line) {
      int lineLength = line.length();

      for (int i = 0; i < lineLength; i++) {
         try {
            char c = line.charAt(i);
            if (Character.isWhitespace(c)) continue;
            analyzeCharacter(c, line, i);
            lastChar = c;

            // set the lexeme values back to defaults and print result
            // if previous lexeme was successfully processed.
            if (isLexemeComplete) {
               printLexeme();
               isLexemeComplete = defaultLexemeComplete;
               lexeme = defaultLexeme;
            }
         } catch (UnknownLexemeException error) {
            // print any lexeme characters leftover before exception encountered
            if (!lexeme.isEmpty()) printLexeme();
            unknownLexemeEncountered = true;
            break;
         }
      }
   }

   // print the lexeme and lexeme type out to the console
   private static void printLexeme() {
      System.out.println("Next token is: " + lexemeType + ", Next lexeme is " + lexeme);
   }
}
