package Reader;

import java.util.Scanner;
/** Класс, считывающий данные, введеные пользователем */
public class LineReader implements Read {
    private Scanner scanner;
    public LineReader(){
        this.scanner = new Scanner(System.in);
    }
    public LineReader(Scanner scanner){
        this.scanner = scanner;
    }

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
