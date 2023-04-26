package server.help;

import common.worker.Worker;

import java.util.TreeMap;


public class WorkerRepository {
    private int id = Worker.getCounter();
    private TreeMap<Integer, Worker> map = new TreeMap<>();

    public TreeMap<Integer, Worker> getMap() {
        return map;
    }
}
