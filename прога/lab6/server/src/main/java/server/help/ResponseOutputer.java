package server.help;


public class ResponseOutputer {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void append(Object toOut) {
        stringBuilder.append(toOut);
    }


    public static void appendln() {
        stringBuilder.append("\n");
    }


    public static void appendln(Object toOut) {
        stringBuilder.append(toOut + "\n");
    }

    public static String getString() {
        return stringBuilder.toString();
    }


    public static String getAndClear() {
        String toReturn = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        return toReturn;
    }


    public static void clear() {
        stringBuilder.delete(0, stringBuilder.length());
    }
}
