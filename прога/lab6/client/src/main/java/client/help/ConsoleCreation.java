
package client.help;
import common.exceptions.*;
import common.worker.*;

import java.time.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ConsoleCreation {
    public Scanner scanner;
    private boolean loop = true;
    public static boolean scriptWork;


    public ConsoleCreation(Scanner scanner) {
        this.scanner = scanner;
        scriptWork = false;
    }

    public void setFileMode() {
        scriptWork = true;
    }


//    public static boolean containsOnlyDigitsOrLetters(String str, boolean onlyDigits) {
//        if (str.isBlank()) {
//            return false;
//        }
//        String regex = onlyDigits ? "^\\d+$" : "^[a-zA-Z]+$";
//        return str.matches(regex);
//    }


    public String setName() throws InputException {
        String name;
        while (true) {
            try {
                System.out.println("Введите имя работника");
                name = scanner.nextLine().trim();
                String regex = "^[A-Za-zА-Яа-я\\s]+$";
                if (name.equals("")) throw new IllegalArgumentException("Имя не может быть пустым");
                if (!name.matches(regex)) throw new IllegalArgumentException("Имя должно содержать только буквы");
                System.out.println(name);
                scriptWork = true;
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                if ((!loop) && (!scriptWork)) {
                    throw new InputException();

                }
                scriptWork = false;
            }
        }

    }
    public Float setCoodrinateX() throws InputException {
        float coordX;
        String line;
        while (true) {
            try {
                System.out.println("Введите float координату x ");
                line = scanner.nextLine().trim();
                if (line.isBlank()) throw new EmptyInputException("не может быть пустым");
                coordX = Float.parseFloat(line);
                if (coordX > 862) throw new InputException();
                scriptWork = true;
                return coordX;
            } catch (EmptyInputException e) {
                System.out.println(e.getMessage());
            } catch (InputException e) {
                System.out.println("Данные выходят за область определения. Число должно быть больше -862");
            } catch (NumberFormatException e) {
                System.out.println("Данные не могут быть пустыми");
            } finally {
                if ((!loop) && (!scriptWork)) {
                    throw new InputException();

                }
                scriptWork = false;
            }

        }

    }

    public Long setCoodrinateY() throws InputException {
        long coordY;
        String line;
        while (true) {
            try {
                System.out.println("Введите long координату y ");
                line = scanner.nextLine().trim();
                if (line.equals("")) throw new EmptyInputException("Введенные данные не могут быть пустыми");
                coordY = Long.parseLong(line);
                if (coordY > 332) throw new IllegalArgumentException("Введенное число должно быть меньше 332");
                scriptWork = true;
                return coordY;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if ((!loop) && (!scriptWork)) {
                    throw new InputException();

                }
                scriptWork = false;
            }

        }

    }
    public Float setSalary() throws InputException {
        String line;
        Float salary;
        while (true) {
            try {
                System.out.println("Введите размер зарплаты");
                line = scanner.nextLine().trim();
                if (line.isBlank()) throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
                salary = Float.parseFloat(line);
                if (salary <= 0.0f)
                    throw new IllegalArgumentException("Введенное значение не может быть меньше или равно 0");
                scriptWork = true;
                return salary;
            }catch(NumberFormatException e){
                    throw new IllegalArgumentException("Введенные данные должны быть числом");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if ((!loop) && (!scriptWork)) {
                    throw new InputException();

                }
                scriptWork = false;
            }

        }

    }

    public ZonedDateTime setStartDate() throws InputException {
        while (true) {
            try {
                System.out.print("Введите дату принятия на работу в формате 'гггг мм дд' " +
                        "(через пробел, без других символов)");
                String date = scanner.nextLine().trim();
                String regex = "^\\d{4}\\s(0[1-9]|1[0-2])\\s(0[1-9]|[12]\\d|3[01])$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(date);
                if (date.isBlank()) throw new EmptyInputException("Введенная дата не " +
                        "соответствует формату");
                if (date!=null & !matcher.matches()) throw new IllegalArgumentException("Введенная дата не " +
                        "соответствует формату");

                System.out.print("Введите время принятия на работу в формате 'чч мм' по московскому времени" +
                        "(через пробел, без других символов)");
                String time = scanner.nextLine().trim();
                String regex1 = "^([01]\\d|2[0-3])\\s[0-5]\\d$";
                Pattern pattern1 = Pattern.compile(regex1);
                Matcher matcher1 = pattern1.matcher(time);
                if (!matcher1.matches()) throw new IllegalArgumentException("Введенное время не соотвествует формату");

                ZoneId zone = ZoneId.of("Europe/Moscow");
                LocalDate dates = LocalDate.of(Integer.parseInt(date.trim().split(" ")[0]),
                        Integer.parseInt(date.trim().split(" ")[1]),
                        Integer.parseInt(date.trim().split(" ")[2]));
                LocalTime times = LocalTime.of(Integer.parseInt(time.trim().split(" ")[0]),
                        Integer.parseInt(time.trim().split(" ")[1]));
                ZonedDateTime startDate = ZonedDateTime.of(dates, times, zone);

                scriptWork = true;
                return startDate;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if ((!loop) && (!scriptWork)) {
                    throw new InputException();

                }
                scriptWork = false;
            }
        }
    }
    public LocalDateTime setEndDate() throws InputException {
        while (true) {
            try {
                System.out.print("Введите дату увольнения в формате 'гггг мм дд' " +
                        "(через пробел, без других символов)");
                String date = scanner.nextLine().trim();
                String regex = "^\\d{4}\\s(0[1-9]|1[0-2])\\s(0[1-9]|[12]\\d|3[01])$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(date);
                if (date.isBlank() || !matcher.matches()) throw new IllegalArgumentException("Введенная дата не соответствует формату");

                System.out.println("Введите время увольнения в формате 'чч мм' по московскому времени" +
                        "(через пробел, без других символов)");
                String time = scanner.nextLine().trim();
                String regex1 = "^([01]\\d|2[0-3])\\s[0-5]\\d$";
                Pattern pattern1 = Pattern.compile(regex1);
                Matcher matcher1 = pattern1.matcher(time);
                if (!matcher1.matches()) throw new IllegalArgumentException("Введенное время не соотвествует формату");

                LocalDateTime endD = LocalDateTime.of(Integer.parseInt(date.trim().split(" ")[0]),
                        Integer.parseInt(date.trim().split(" ")[1]),
                        Integer.parseInt(date.trim().split(" ")[2]),
                        Integer.parseInt(time.trim().split(" ")[0]),
                        Integer.parseInt(time.trim().split(" ")[0]));

                scriptWork = true;
                return endD;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if ((!loop) && (!scriptWork)) {
                    throw new InputException();

                }
                scriptWork = false;
            }
        }
    }


    public Status setStatus() throws InputException {
        try {
            System.out.println("Введите статус (один из предложенных):");
            ArrayList s = new ArrayList();
            for (Status i : Status.values()) {
                s.add(i.getDescription());
                System.out.println(i.getDescription());
            }
            String status = scanner.nextLine().trim();
            if (status.isBlank())
                throw new IllegalArgumentException("Введенный статус не может быть пустым");
            if (!s.contains(status)) throw new IllegalArgumentException("Такого статуса не существует");
            return Status.fromString(status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InputException();
        }
    }






     public Coordinates setCoordinates() throws InputException {
        try {
            Float x;
            long y;
            x = setCoodrinateX();
            y = setCoodrinateY();

            return new Coordinates(x, y);
        } catch (InputException e) {
            throw new InputException();

        }

    }



    public Organization setOrganization() {
        Organization org = new Organization();
        String name;
        String line;
        float x;
        long y;
        int z;
        try {
            while (true) {
                while (true) {
                    try {
                        System.out.println("Введите полное название комании");
                        org.setFullName(scanner.nextLine().trim());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Введите ежегодный оборот компании");
                        org.setAnnualTurnover(scanner);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Введите количество работников в компании");
                        org.setEmployeesCount(scanner);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            }
            return org;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return org;
    }
    public Date setCreationDate(){
        Date creationDate = new Date();
        return creationDate;
    }
}
