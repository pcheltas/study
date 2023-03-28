import support.Loader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            Loader loader = new Loader();
            loader.working();
        }catch (IllegalArgumentException e){
            System.out.println("Данные в файле не соответствуют области определения. Измените содержимое файла и " +
                    "перезапустите приложение");
            System.exit(1);
        }catch (Exception e){
            System.out.println("Вы вышли из программы. До новых встреч!");
        }
//        Loader loader = new Loader();
//        loader.setLoader(loader);
//        loader.working();

    }
}