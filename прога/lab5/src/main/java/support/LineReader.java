package support;

import java.util.Scanner;

/**

 The LineReader class that implements the Read interface and provides a way to read a line of input from the user
 through the console.
 */
public class LineReader implements Read {
    private Scanner scanner;
    /**

     Constructs a LineReader with the default scanner which reads from System.in.
     */
    public LineReader(){
        this.scanner = new Scanner(System.in);
    }
    /**

     Constructs a LineReader with a custom scanner.
     @param scanner a Scanner object to read input from.
     */
    public LineReader(Scanner scanner){
        this.scanner = scanner;
    }
    /**

     Reads a line of input from the user through the console.
     @return a string representing the user's input.
     */
    @Override
    public String read() {
        return scanner.nextLine();
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
