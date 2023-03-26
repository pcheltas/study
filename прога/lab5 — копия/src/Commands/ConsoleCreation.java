package Commands;

import Reader.Loader;
import Worker.*;

import java.util.ArrayList;
import java.util.Date;

import static Reader.Loader.repo;

public class ConsoleCreation implements Command{
        Worker worker = new Worker();
        Coordinates coordinates = new Coordinates();
        Organization org = new Organization();
        Date creationDate = new Date();

    public Worker getWorker() {
        return worker;
    }

    @Override
        public void execute(){
            worker.setCreationDate(creationDate);

            while (worker.getName() == null){
                System.out.println("Введите имя работника");
                try {
                    worker.setName(Loader.lineReader.read());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            }
            while (true){
                while (true){

                    try{
                        System.out.println("Введите float координату x ");
                        coordinates.setX(Loader.lineReader.getScanner());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                }
                while (true){
                    System.out.println("Введите float координату y ");
                    try{
                        coordinates.setY(Loader.lineReader.getScanner());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                }
                worker.setCoordinates(coordinates);
                break;
            }
            while (true){
                System.out.println("Введите размер зарплаты");
                try {
                    worker.setSalary(Loader.lineReader.getScanner());
                    break;
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            }

            while (true){
                String date = null;
                String time = null;
                while (true) {
                    System.out.println("Введите дату принятия на работу в формате 'гггг мм дд' " +
                            "(через пробел, без других символов)");
                    try{
                        date = worker.setDate(Loader.lineReader.read());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                }
                while (true) {
                    System.out.println("Введите время принятия на работу в формате 'чч мм' по московскому времени" +
                            "(через пробел, без других символов)");
                    try{
                        time = worker.setTime(Loader.lineReader.read());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                }
                worker.setStartDate(date, time);
                break;
            }

            while (true){
                String date = null;
                String time = null;
                while (true) {
                    System.out.println("Введите дату увольнения в формате 'гггг мм дд' " +
                            "(через пробел, без других символов)");
                    try{
                        date = worker.setDate(Loader.lineReader.read());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                }
                while (true) {
                    System.out.println("Введите время увольнения в формате 'чч мм' по московскому времени" +
                            "(через пробел, без других символов)");
                    try{
                        time = worker.setTime(Loader.lineReader.read());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                }
                worker.setEndDate(date, time);
                break;
            }

            while (true){
                System.out.println("Введите статус (один из предложенных):");
                ArrayList s = new ArrayList();
                for (Status i : Status.values()) {
                    s.add(i.getDescription());
                    System.out.println(i.getDescription());
                }
                try{
                    worker.setStatus(Loader.lineReader.read(), s);
                    break;
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            }

            while (true){
                while (true){
                    try{
                        System.out.println("Введите полное название комании");
                        org.setFullName(Loader.lineReader.read());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                while (true){
                    try{
                        System.out.println("Введите ежегодный оборот компании");
                        org.setAnnualTurnover(Loader.lineReader.getScanner());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                while (true){
                    try{
                        System.out.println("Введите количество работников в компании");
                        org.setEmployeesCount(Loader.lineReader.getScanner());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                worker.setOrganization(org);
                break;
            }
        }
}
