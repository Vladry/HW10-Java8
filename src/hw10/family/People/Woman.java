package hw10.family.People;

import hw10.family.Animals.Pet;
import hw10.family.DayOfWeek;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

final public class Woman extends Human {
    Woman(){
        super();
    }

    public Woman(String name, String surname, LocalDate birthDate){
        super(name, surname, birthDate);
    }
    public Woman(String name, String surname, LocalDate birthDate,
                 int iq, Map<DayOfWeek, List<String>> schedule, Family family){
        super(name, surname, birthDate, iq, schedule, family);
    }

    public void makeup (){
        System.out.println("Запущена утрення процедура краски");
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.println("Хорошая собака, " + pet.getNickname() + ", принеси маме тапочки!");
    }
}
