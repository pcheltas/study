package Worker;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Organization {
    private String fullName; //Длина строки не должна быть больше 1516, Строка не может быть пустой, Поле не может быть null
    private int annualTurnover; //Значение поля должно быть больше 0
    private int employeesCount; //Значение поля должно быть больше 0

    public Organization (String fullName, int annualTurnover, int employeesCount){
        this.fullName = fullName;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
    }
    public Organization (){}


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank())
            throw new IllegalArgumentException("Название организации не может быть пустым");
        if (fullName.length()>1516)
            throw new IllegalArgumentException("Название организации слишком длинное");
        this.fullName = fullName;

    }

    public int getAnnualTurnover() {
        return annualTurnover;
    }
// int annualTurnover
    public void setAnnualTurnover(Scanner scan) {
        String  annualTurnover;
        annualTurnover = scan.nextLine();
        if (annualTurnover.isBlank()) throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
        try{
            if (Integer.parseInt(annualTurnover) <= 0)
                throw new IllegalArgumentException();
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Введенные данные должны быть числом");
        }catch (IllegalStateException e){
            throw new IllegalArgumentException("Введенное число должно быть больше 0");
        }
        this.annualTurnover = Integer.parseInt(annualTurnover);
    }

    public int getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Scanner scan) {
        String employeesCount;
        employeesCount = scan.nextLine();
        if (employeesCount.isBlank()) throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
        try{
            if (Integer.parseInt(employeesCount) == 0)
                throw new IllegalArgumentException("Введенное число должно быть больше 0");
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Введенные данные должны быть числом");
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
        }

        this.employeesCount = Integer.parseInt(employeesCount);
    }

    @Override
    public String toString() {
        return  "\n     Название компании: " + getFullName() +
                "\n     Ежегодный оборот: " + getAnnualTurnover() +
                "\n     Количество сотрудников: " + getEmployeesCount();
    }
}
