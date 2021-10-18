package hw10.family.People;

import java.time.LocalDate;
import java.util.Random;


public class BabyFactory {
    static String babyName = "";
    static Sex sex;       // MASCULINE, FEMININE
    static int rndSex, birthYear, birthMonth, birthDay;

    public static Human deliverABaby(Family family) {
        int babyIq = (family.getFather().getIq() + family.getMother().getIq()) / 2;

        Random random = new Random();
        rndSex = random.nextInt(2);
        birthYear = random.nextInt(10) + 2010;
        birthMonth = random.nextInt(12) + 1;
        birthDay = random.nextInt(28)+1;
        sex = (rndSex == 0) ? Sex.MASCULINE : Sex.FEMININE;
        babyName = GenerateRandomName.get(sex);
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);

        switch (sex) {
            case MASCULINE:
                return new Man("мальчик: " + babyName, family.getFather().getSurname(), birthDate, babyIq, family.getFather().getSchedule(), family);
            case FEMININE:
                return new Woman("девочка: " + babyName, family.getFather().getSurname(), birthDate, babyIq, family.getFather().getSchedule(), family);
            default:
                return null;
        }
    }
}
