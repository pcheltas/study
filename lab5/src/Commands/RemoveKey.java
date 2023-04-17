package Commands;

import static Reader.Loader.repo;

public class RemoveKey implements ArgumentCommand{

    private int key;

    @Override
    public void execute(){
        if (repo.map.get(key) != null) {
            repo.map.remove(key);
            System.out.println("Элемент коллекции успешно удален");
        }else {
            System.out.println("Значения по заданному ключу не найдено");
        }
    }

    @Override
    public void getArgument(String arg){
        try {
            if (repo.map.containsKey(Integer.parseInt(arg))) {
                key = Integer.parseInt(arg);
                execute();
            }else{
                System.out.println("Коллекция не имеет элемента по заданному ключу");
            }
        } catch (NumberFormatException e){
            System.err.println("Ключ введен неверно");
        }
    }

    @Override
    public String toString(){
        return "remove_key {key}:  удалить элемент из коллекции по его ключу";
    }
}
