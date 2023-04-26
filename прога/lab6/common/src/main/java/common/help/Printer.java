package common.help;


public class Printer {

        public static void print(Object toOut, ServerResponse responseCode) {
            System.out.print(toOut);
            System.out.println(" ");
            System.out.print(responseCode);
            System.out.println(" ");
        }


        public static void println(Object toOut) {
            System.out.println(toOut);
        }

        public static void printError(Object toOut) {
            System.out.println(" ");
            System.out.println("error: " + toOut);
        }

}
