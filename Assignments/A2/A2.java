/**
 * CSC 345-01 Assignment #2
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

public class A2 {
  // Students -- Add your constants here
  private static final String defaultLexeme = "";

  // Character classes
  private static final int
    EOF = -1,
    LETTER = 0,
    DIGIT = 1,
    UNKNOWN = 99;

  // Token codes
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

  private static char nextChar;
  private static HashMap<Character, Integer> reservedLexemes = new HashMap<Character, Integer>();
  private static int charClass, currentLineIndex = 0, nextToken;
  private static String currentLine, lexeme;

  public static void main(String[] args) {
    try {
      // Do NOT make any changes to the following TWO lines
      File file = new File(args[0]);
      Scanner sc = new Scanner(file);   //*** Do not make any other Scanners ***//
      currentLine = sc.nextLine();

      // Students -- Your code and methods calls go here
      reservedLexemes.put('f', FLOATDCL);
      reservedLexemes.put('i', INTDCL);
      reservedLexemes.put('p', PRINT);
      reservedLexemes.put('=', ASSIGN);
      reservedLexemes.put('+', PLUS);
      reservedLexemes.put('-', MINUS);

      getChar();
      getLexeme();
      prog();

      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("ERROR - cannot open front.in \n");
    }
  }

  // Students -- Add your method declarations here
  private static void addChar() {
    lexeme+=nextChar;
  }

  private static void dcl() {
    System.out.println("Enter <Dcl>");

    getLexeme();
    getLexeme();

    System.out.println("Exit <Dcl>");
  }

  private static void dcls() {
    System.out.println("Enter <Dcls>");

    dcl();
    while (nextToken == FLOATDCL || nextToken == INTDCL) dcls();

    System.out.println("Exit <Dcls>");
  }

  private static void expr() {
    System.out.println("Enter <Expr>");

    getLexeme();
    val();
    while (nextToken == PLUS || nextToken == MINUS) expr();

    System.out.println("Leave <Expr>");
  }

  private static void getChar() {
    try {
      nextChar = currentLine.charAt(currentLineIndex);

      charClass = Character.isDigit(nextChar) ? DIGIT : UNKNOWN;

      currentLineIndex++;
    } catch (StringIndexOutOfBoundsException e) {
      charClass = EOF;
    }
  }

  private static void getLexeme() {
    lexeme = "";

    skipWhitespace();

    switch (charClass) {
      case DIGIT:
        do {
          addChar();
          getChar();
        } while (charClass == DIGIT || nextChar == '.');

        nextToken = lexeme.contains(".") ? FNUM : INUM;
        break;
      case EOF:
        nextToken = EOF;
        break;
      default:
        nextToken = reservedLexemes.getOrDefault(nextChar, ID);
        lexeme = Character.toString(nextChar);
        getChar();
        break;
    }

    if (!lexeme.isEmpty()) System.out.println("Next token is: " + nextToken + ", Next lexeme is " + lexeme);
  }

  private static void prog() {
    System.out.println("Enter <Prog>");

    if (nextToken == FLOATDCL || nextToken == INTDCL) dcls();
    if (nextToken == ID || nextToken == PRINT) stmts();

    System.out.println("Exit <Prog>");
  }

  private static void stmt() {
    System.out.println("Enter <Stmt>");

    getLexeme();
    getLexeme();
    if (nextToken == ID || nextToken == INUM || nextToken == FNUM) val();
    if (nextToken == PLUS || nextToken == MINUS) expr();

    System.out.println("Leave <Stmt>");
  }

  private static void stmts() {
    System.out.println("Enter <Stmts>");

    stmt();
    while (nextToken == ID || nextToken == PRINT) stmts();

    System.out.println("Exit <Stmts>");
  }

  private static void skipWhitespace() {
    while (Character.isWhitespace(nextChar)) {
      getChar();
    }
  }

  private static void val() {
    System.out.println("Enter <Val>");

    getLexeme();

    System.out.println("Leave <Val>");
  }
}
