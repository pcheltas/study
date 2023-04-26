package server.help;

import common.worker.*;
import java.time.ZonedDateTime;
import java.util.Date;


public class WorkerControl {
    private static Worker worker;
    private boolean correct;


    public WorkerControl(Worker worker){
        WorkerControl.worker = worker;
        check();
    }

    public boolean isCorrect() {
        return correct;
    }

    public void check(){
        try{
             this.correct = WorkerControl.idCheck(worker.getId()) && WorkerControl.nameCheck(worker.getName()) &&
                        WorkerControl.coordinatesCheck(worker.getCoordinates()) &&
                        WorkerControl.creationDateCheck(worker.getCreationDate()) &&
                        WorkerControl.salaryCheck(worker.getSalary()) &&
                        WorkerControl.startDateCheck(worker.getStartDate()) &&
                        WorkerControl.statusCheck(worker.getStatus()) &&
                        WorkerControl.organizationCheck(worker.getOrganization());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            this.correct = false;
        }
    }

    private static boolean idCheck(Integer id){
        if (id == null || id <= 0 ) throw new IllegalArgumentException("id работника " +
                    "некорректно");
        return true;
    }

    private static boolean nameCheck(String name){
        if (name.isBlank()) throw new IllegalArgumentException("имя работника некорректно");
        return true;
    }

    private static boolean coordinatesCheck(Coordinates coordinates){
        if (coordinates.getX() == null || coordinates.getX() <= -862 || coordinates.getY() == null || coordinates.getY() > 332) throw new IllegalArgumentException("координаты работника некорректны");
        return true;
    }

    private static boolean creationDateCheck(Date creationDate){
        if (creationDate == null) throw new IllegalArgumentException("дата и время создания работника некорректны");
        return true;
    }

    private static boolean salaryCheck(Float salary){
        if (salary == null || salary <= 0) throw new IllegalArgumentException("зарплата работника некорректна");
        return true;
    }

    private static boolean startDateCheck(ZonedDateTime startDate){
        if (startDate == null) throw new IllegalArgumentException("дата и время принятия работника на работу некорректны");
        return true;
    }

    private static boolean statusCheck(Status status){
        if (status == null) throw new IllegalArgumentException("статус работника некорректен");
        return true;
    }

    private static boolean organizationCheck(Organization organization){
        if (organization.getFullName().length() > 1516 || organization.getFullName().isBlank() ||
                organization.getAnnualTurnover() == null || organization.getAnnualTurnover() <= 0 ||
                organization.getEmployeesCount() == null || organization.getEmployeesCount() <= 0)
            throw new IllegalArgumentException("организация работника некорректна");
        return true;
    }
}
