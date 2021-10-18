package hw10.family.People;

import hw10.family.Animals.Pet;
import hw10.family.DayOfWeek;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

public abstract class Human {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private int iq;
    private Map<DayOfWeek, List<String>> schedule;
    private Family family;

    static {
//        System.out.println("загружается новый класс Human");
    }

    {

        schedule = new HashMap<>();

        for (DayOfWeek weekDay : DayOfWeek.values()) {
            List<String> tasks = new ArrayList<>();
            schedule.put(weekDay, tasks);
        }


//        System.out.println("создается новый объект Human");
        Random rnd = new Random();
        iq = rnd.nextInt(101);
    }

    Human() {
    }

    Human(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    Human(String name, String surname, LocalDate birthDate,
          int iq, Map<DayOfWeek, List<String>> schedule, Family family) {
        this(name, surname, birthDate);
        this.iq = iq;
        this.schedule.putAll(schedule);
        this.family = family;
    }

    // конструктор для усыновленных детей согласно TЗ домашки №9:
    Human(String name, String surname, String birthDateStr,
          int iq){
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));  // 20/03/2016
    }

    public String describeAge(){
        LocalDate now = LocalDate.now();
        String dateString;

        Period period = Period.between(birthDate, now);
        dateString = "full years: "
                + period.getYears()
                + "\n full months: "
                + period.getMonths()
                + "\n full days: "
                + period.getDays();

        System.out.println(dateString);
        return dateString;
    }



    public void greetPet(Pet pet) {
        System.out.println("Привет, " + pet.getNickname());
    }

    public void describePet(Pet pet) {
        String trickVerdict;
        if (pet.getTrickLevel() > 50) {
            trickVerdict = "очень хитрый";
        } else {
            trickVerdict = "почти не хитрый";
        }

        System.out.println("У меня есть " +
                pet.getSpecies() +
                ", ему " +
                pet.getAge() +
                " лет, он +" +
                trickVerdict
        );

    }

    public String getName() {
        return this.name;
    }

    ;

    public void setName(String name) {
        this.name = name;
    }

    ;

    public String getSurname() {
        return this.surname;
    }

    ;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    ;

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    ;

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    ;

    public int getIq() {
        return this.iq;
    }

    ;

    public void setIq(int iq) {
        this.iq = iq;
    }

    ;

    public Map<DayOfWeek, List<String>> getSchedule() {
        return this.schedule;
    }

    ;

    public void setSchedule(Map<DayOfWeek, List<String>> schedule) {
        this.schedule = schedule;
    }

    ;

    public Family getFamily() {
        return this.family;
    }

    ;

    public void setFamily(Family family) {
        this.family = family;
    }


    @Override
    public String toString() {
        return "Human{ name=" + this.getName() + ", surname= " + this.getSurname() +
                ", year=" + this.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", iq=" + this.getIq() +
                "}\n ";
    }

    @Override
    protected void finalize() {
        System.out.println("Deleting an instance of Human");
    }
}
