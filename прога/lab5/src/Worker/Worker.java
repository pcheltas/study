package Worker;


import Reader.Loader;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Reader.Loader.repo;

public class Worker implements Comparable<Worker>{
    private static int counter=1;
    private int id;//Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float salary; //Поле не может быть null, Значение поля должно быть больше 0
    private java.time.ZonedDateTime startDate; //Поле не может быть null
    private java.time.LocalDateTime endDate; //Поле может быть null
    private Status status; //Поле не может быть null
    private Organization organization; //Поле может быть null

    private Boolean console = true;

    public Worker(String name, Coordinates coordinates, Date creationDate, Float salary, ZonedDateTime startDate,
           LocalDateTime endDate, Status status, Organization organization){
        while (this.id == Integer.parseInt(null) || repo.map.keySet().contains(this.id)){
            this.id = counter++;
            setCounter(counter++);
        }
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.organization = organization;
    }
    public Worker(String name, Coordinates coordinates, Float salary, Status status){
        this.id = counter++;
        setCounter(counter++);
        this.name = name;
        this.coordinates = coordinates;
        this.status = status;
        this.creationDate = new Date();
        this.salary = salary;
    }
    public Worker(Boolean console, int id, String name, Coordinates coordinates, Float salary,
                  java.time.ZonedDateTime startDate, java.time.LocalDateTime endDate, Status status, Organization organization){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.status = status;
        this.creationDate = new Date();
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.organization = organization;
    }

    public Worker() {
    }

    public  int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Float getSalary() {
        return salary;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public String getOrganization() {
        return organization.getFullName();
    }
    public Status getStatus() {
        return status;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public static void setCounter(int counter) {
        Worker.counter = counter;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Введенное имя не может быть пустым");
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null)
            throw new IllegalArgumentException("Координаты не могут быть пустыми");
        this.coordinates = coordinates;
    }


    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public void setSalary(Scanner scan) {
        String salary = null;
        salary = scan.nextLine();
        if (salary.isBlank()) throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
        try{
            if (Float.parseFloat(salary) == 0.0f)
                throw new IllegalArgumentException("Введенное значение не может быть равно 0");
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Введенные данные должны быть числом");
        } catch (IllegalStateException e){
            throw new IllegalArgumentException("Введенное значение не может быть равно 0");
        }
        this.salary = Float.parseFloat(salary);
    }


    public void setStartDate(String date, String time) {
        ZoneId zone = ZoneId.of("Europe/Moscow");
        LocalDate dates = LocalDate.of(Integer.parseInt(date.trim().split(" ")[0]),
                Integer.parseInt(date.trim().split(" ")[1]),
                Integer.parseInt(date.trim().split(" ")[2]));
        LocalTime times = LocalTime.of(Integer.parseInt(time.trim().split(" ")[0]),
                Integer.parseInt(time.trim().split(" ")[1]));
        this.startDate = ZonedDateTime.of(dates, times, zone);
    }


    public void setEndDate(String date, String time) {
        //try {
            LocalDateTime endD = LocalDateTime.of(Integer.parseInt(date.trim().split(" ")[0]),
                    Integer.parseInt(date.trim().split(" ")[1]),
                    Integer.parseInt(date.trim().split(" ")[2]),
                    Integer.parseInt(time.trim().split(" ")[0]),
                    Integer.parseInt(time.trim().split(" ")[0]));
            if (endD.compareTo(startDate.toLocalDateTime()) <= 0)
                throw new IllegalArgumentException("Дата окончания работы в компании должна быть не раньше " +
                        "даты принятия на работу");
            this.endDate = endD;
        //} catch (IllegalArgumentException e){
          //  System.out.println(e.getMessage());
        //}
    }

    public String setDate(String date) {
        String regex = "^\\d{4}\\s(0[1-9]|1[0-2])\\s(0[1-9]|[12]\\d|3[01])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        if (date.isBlank() || !matcher.matches()) throw new IllegalArgumentException("Введенная дата не соответствует формату");
        return date;
    }

    public String setTime(String time) {
        String regex1 = "^([01]\\d|2[0-3])\\s[0-5]\\d$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(time);
        if (!matcher1.matches()) throw new IllegalArgumentException("Введенное время не соотвествует формату");
        return time;
    }


    public void setStatus(String status, ArrayList arrayList) {
            if (status.isBlank())
                throw new IllegalArgumentException("Введенный статус не может быть пустым");
            if (!arrayList.contains(status)) throw new IllegalArgumentException("Такого статуса не существует");
            this.status = Status.fromString(status);
            }


    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString(){
        if (organization == null) {
            return
                    "\nID: " + getId() +
                            "\nNAME: " + getName() +
                            "\nCOORDINATES: " + coordinates.toString() +
                            "\nCREATIONDATE: " + getCreationDate() +
                            "\nSALARY: " + getSalary() +
                            "\nSTARTDATE: " + getStartDate() +
                            "\nENDDATE: " + getEndDate() +
                            "\nSTATUS: " + getStatus().getDescription();
        }else{
            return
                "\nID: " + getId() +
                        "\nNAME: " + getName() +
                        "\nCOORDINATES: " + coordinates.toString() +
                        "\nCREATIONDATE: " + getCreationDate() +
                        "\nSALARY: " + getSalary() +
                        "\nSTARTDATE: " + getStartDate() +
                        "\nENDDATE: " + getEndDate() +
                        "\nORGANIZATION: " + organization.toString() +
                        "\nSTATUS: " + getStatus().getDescription();

        }

    }

    @Override
    public int compareTo(Worker o) {
        return this.name.length()-o.getName().length();
    }
}
