package Commands;


import static Reader.Loader.repo;

public class Show implements Command{

    @Override
    public void execute() {
        if (repo.map.size() !=0) {
            for (int i : repo.map.keySet()){
                System.out.println(repo.map.get(i).toString());
            }
        } else {
            System.out.println("Коллекция пуста");
        }
    }

    @Override
    public String toString(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}

