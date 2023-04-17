package Commands;

import Reader.Loader;

import java.util.SortedMap;

public class Info implements Command{


    @Override
    public void execute() {
        System.out.println("Дата создания коллекции: " + Loader.getCreation());
        System.out.println("Тип коллекции: TreeMap, хранит данные о работниках");
        System.out.println("Количество элементов: " + Loader.repo.map.size());
    }
}
