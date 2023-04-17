package Reader;


import Worker.Status;

public class NewWorkerChecker {
    public String setName() {
        String name = null;
        try {
            boolean correct = true;
            while (correct) {
                System.out.println("Введите имя работника");
                if (Loader.lineReader.getScanner().nextLine().equals("")){
                    throw new IllegalArgumentException();
                }
                while (name == null || name.length() == 0) {
                    name = Loader.lineReader.read();
                    correct = false;
                }
            }
        } catch (IllegalArgumentException e){
            System.out.println("Введенное имя не может быть пустым, попробуйте снова");
        }
        return name;
    }

    public Status setStatus(){
        try{
            boolean correct = true;
            Status status = null;
            while (correct) {
                while (status == null || status.getDescription().length() == 0) {
                    System.out.println("Введите статус (один из предложенных):");
                    String s = "";
                    for (Status i : Status.values()) {
                        s = s + i.getDescription();
                        System.out.println(i.getDescription());
                    }
                    if (Loader.lineReader.getScanner().nextLine().equals("")){
                        throw new IllegalArgumentException();
                    }
                    String st = Loader.lineReader.read();
                    if (s.contains(st)) {
                        status = Status.fromString(st);
                    }
                }
                correct = false;
            }
            return status;
        } catch (IllegalArgumentException e){
            System.out.println("ошибка в задании статуса");
        }
        return null;
    }




}
