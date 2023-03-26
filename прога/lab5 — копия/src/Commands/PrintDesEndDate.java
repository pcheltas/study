package Commands;

import Worker.Worker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

import static Reader.Loader.repo;

public class PrintDesEndDate implements Command{

    @Override
    public void execute() {
        Comparator<LocalDateTime> comparator = Collections.reverseOrder();
        ArrayList<LocalDateTime> endDates = new ArrayList<>();
        for (Worker worker : repo.map.values()) {
            if (worker.getEndDate() != null){
                endDates.add(worker.getEndDate());
            }
        }
        endDates.sort(comparator);
        System.out.println(endDates);
    }

    @Override
    public String toString(){
        return "print_field_descending_end_date : вывести значения поля endDate всех элементов в порядке убывания";
    }



}
