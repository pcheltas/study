package common.worker;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.*;
import java.util.Date;


public class Worker implements Comparable<Worker>, Serializable {
    private static int counter=0;
    private Integer id;//Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float salary; //Поле не может быть null, Значение поля должно быть больше 0
    private java.time.ZonedDateTime startDate; //Поле не может быть null
    private java.time.LocalDateTime endDate; //Поле может быть null
    private Status status; //Поле не может быть null
    private Organization organization; //Поле может быть null

    private Boolean console = true;

    @JsonCreator
    public Worker(@JsonProperty("id") Integer id, @JsonProperty("name") String name,
                  @JsonProperty("coordinates")Coordinates coordinates, @JsonProperty("creationDate")Date creationDate,
                  @JsonProperty("salary")Float salary, @JsonProperty("startDate")ZonedDateTime startDate,
                  @JsonProperty("endDate")LocalDateTime endDate, @JsonProperty("status") Status status,
                  @JsonProperty("organization") Organization organization){

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
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

    public Organization getOrganization() {
        return organization;
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


    @Override
    public int compareTo(Worker o) {
        return this.name.length()-o.getName().length();
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
}
