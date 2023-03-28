package Worker;

import java.util.TreeMap;

import static Reader.Loader.repo;

public class WorkerRepository {
    private int id = Worker.getCounter();
    public TreeMap<Integer, Worker> map = new TreeMap<>();



    public void insert(Worker worker){
        map.put(id++, worker);
        Worker.setCounter(Worker.getCounter()+1);
    }


}
