package Commands;

import static Reader.Loader.repo;

public class Clear implements Command{

    @Override
    public void execute() {
        if (repo.map.size() != 0) {
            repo.map.clear();
            System.out.println("Все элементы коллекции успешно удалены. Коллекция пуста");
        } else {
            System.out.println("Коллекция уже пуста");
        }
    }

    @Override
    public String toString(){
        return "clear: очистить коллекцию";
    }

}
