package hw10.family.People;

import hw10.family.Animals.Pet;
import hw10.family.DayOfWeek;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

final public class Man extends Human {

    Man(){
        super();
    }

    public Man(String name, String surname, LocalDate birthDate){
        super(name, surname, birthDate);
    }
    public Man(String name, String surname, LocalDate birthDate,
               int iq, Map<DayOfWeek, List<String>> schedule, Family family){
        super(name, surname, birthDate, iq, schedule, family);
    }

    public void repairCar(){
        System.out.println("Третий год чиним машину");
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.println(pet.getNickname() + " , почему тапочки несёшь, ты не домашний рабчик, ты - крутецкий пёс");
    }
}
