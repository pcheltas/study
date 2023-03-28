import Reader.Loader;
import Worker.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import static Reader.Loader.repo;

public class Main {
    public static void main(String[] args) {
        Loader loader = new Loader();
        Coordinates qwecoor = new Coordinates(1.5f, -5157515L);
        Worker qljnv = new Worker( "qljnv", qwecoor, 2f, Status.FIRED);
        Coordinates rtycoor = new Coordinates(1.5f, -5157515L);
        Worker rty = new Worker("q", rtycoor, 2345678f, Status.FIRED);
        Coordinates poicoor = new Coordinates(1.5f, -5157515L);
        Worker poi = new Worker("poi", poicoor, 67890f, Status.FIRED);
        Coordinates updcoor = new Coordinates(1.5f, -5157515L);
        Worker upd = new Worker("upd", updcoor, 456789f, Status.REGULAR);
        Coordinates x = new Coordinates(1.5f, -5157515L);



        Organization org = new Organization("dfghj", 123, 123);
        ZoneId zone = ZoneId.of("Europe/Moscow");
        String date = "2021 12 12";
        LocalDate dates = LocalDate.of(Integer.parseInt(date.trim().split(" ")[0]),
                Integer.parseInt(date.trim().split(" ")[1]),
                Integer.parseInt(date.trim().split(" ")[2]));
        String time = "10 20";
        LocalTime times = LocalTime.of(Integer.parseInt(time.trim().split(" ")[0]),
                Integer.parseInt(time.trim().split(" ")[1]));
        ZonedDateTime startDate = ZonedDateTime.of(dates, times, zone);

        LocalDateTime endD = LocalDateTime.of(Integer.parseInt(date.trim().split(" ")[0]),
                Integer.parseInt(date.trim().split(" ")[1]),
                Integer.parseInt(date.trim().split(" ")[2]),
                Integer.parseInt(time.trim().split(" ")[0]),
                Integer.parseInt(time.trim().split(" ")[0]));
        Worker xx = new Worker(true, 4, "xx", x, 123f, startDate, endD, Status.FIRED, org);


        loader.repo.insert(qljnv);
        loader.repo.insert(rty);
        loader.repo.insert(poi);
        loader.repo.insert(xx);


        loader.working();

    }
}