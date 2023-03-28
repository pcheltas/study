package support;

import worker.Worker;
import worker.Status;
import worker.Organization;
import worker.Coordinates;

import java.time.ZonedDateTime;
import java.util.Date;

/**

 The WorkerControl class is used to control the correctness of the Worker object.

 If all parameters are correct, the 'correct' variable is set to true.

 */
public class WorkerControl {
    private static Worker worker;
    private boolean correct;

    /**

     Constructor that initializes the Worker object and checks all its parameters for correctness.
     If all parameters are correct, the 'correct' variable is set to true.
     @param worker The Worker object to be checked.
     */
    public WorkerControl(Worker worker){
        WorkerControl.worker = worker;
        check();
    }

    public boolean isCorrect() {
        return correct;
    }
    /**

     Returns the 'correct' variable, which is true if all parameters of the Worker object are correct.
     @return boolean value of 'correct' variable.
     */
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
    /**

     Checks if the id of the worker is valid.
     @param id The id of the Worker object.
     @return true if the id is correct.
     @throws IllegalArgumentException if the id is null or less than or equal to 0.
     */
    private static boolean idCheck(Integer id){
        if (id == null || id <= 0 ) throw new IllegalArgumentException("id работника " +
                    "некорректно");
        return true;
    }
    /**

     Checks if the name of the worker is valid.
     @param name the name of the worker to be checked
     @throws IllegalArgumentException if the name is blank
     @return true if the name is valid
     */
    private static boolean nameCheck(String name){
        if (name.isBlank()) throw new IllegalArgumentException("имя работника некорректно");
        return true;
    }
    /**

     Checks if the coordinates of the worker are valid.
     @param coordinates the coordinates of the worker to be checked
     @throws IllegalArgumentException if the X or Y coordinate is null, or if X is less than or equal to -862 or Y is greater than 332
     @return true if the coordinates are valid
     */
    private static boolean coordinatesCheck(Coordinates coordinates){
        if (coordinates.getX() == null || coordinates.getX() <= -862 || coordinates.getY() == null || coordinates.getY() > 332) throw new IllegalArgumentException("координаты работника некорректны");
        return true;
    }
    /**

     Checks if the creation date of the worker is valid.
     @param creationDate the creation date of the worker to be checked
     @throws IllegalArgumentException if the creation date is null
     @return true if the creation date is valid
     */
    private static boolean creationDateCheck(Date creationDate){
        if (creationDate == null) throw new IllegalArgumentException("дата и время создания работника некорректны");
        return true;
    }
    /**

     Checks if the salary of the worker is valid.
     @param salary the salary of the worker to be checked
     @throws IllegalArgumentException if the salary is null or less than or equal to 0
     @return true if the salary is valid
     */
    private static boolean salaryCheck(Float salary){
        if (salary == null || salary <= 0) throw new IllegalArgumentException("зарплата работника некорректна");
        return true;
    }
    /**

     Checks if the start date of the worker is valid.
     @param startDate the start date of the worker to be checked
     @throws IllegalArgumentException if the start date is null
     @return true if the start date is valid
     */
    private static boolean startDateCheck(ZonedDateTime startDate){
        if (startDate == null) throw new IllegalArgumentException("дата и время принятия работника на работу некорректны");
        return true;
    }
    /**

     Checks if the status of the worker is valid.
     @param status the status of the worker to be checked
     @throws IllegalArgumentException if the status is null
     @return true if the status is valid
     */
    private static boolean statusCheck(Status status){
        if (status == null) throw new IllegalArgumentException("статус работника некорректен");
        return true;
    }
    /**

     Checks if the organization of the worker is valid.
     @param organization the organization of the worker to be checked
     @throws IllegalArgumentException if the full name is blank or longer than 1516 characters, or if the annual turnover or employees count is null or less than or equal to 0
     @return true if the organization is valid
     */
    private static boolean organizationCheck(Organization organization){
        if (organization.getFullName().length() > 1516 || organization.getFullName().isBlank() ||
                organization.getAnnualTurnover() == null || organization.getAnnualTurnover() <= 0 ||
                organization.getEmployeesCount() == null || organization.getEmployeesCount() <= 0)
            throw new IllegalArgumentException("организация работника некорректна");
        return true;
    }
}
