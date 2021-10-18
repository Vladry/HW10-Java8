package hw10.family.service;

import hw10.family.Animals.Dog;
import hw10.family.Animals.Pet;
import hw10.family.Controller.FamilyController;
import hw10.family.DAO.CollectionFamilyDao;
import hw10.family.People.Family;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class FamilyServiceTest {
    private FamilyService module;

    @Before
    public void setUp() {
        List<List<String>> familyData = new ArrayList<>(Arrays.asList(
                Arrays.asList("Leontiy", "Zoya", "Fedotov"),
                Arrays.asList("Petya", "Natasha", "Gandzapety"),
                Arrays.asList("Grigory", "Liza", "Morarik"),
                Arrays.asList("Anton", "Olya", "Glory"),
                Arrays.asList("Pavel", "Tanya", "Primetime"),
                Arrays.asList("Viktor", "Lyuba", "Wonder"),
                Arrays.asList("Marik", "Katya", "Pendik"),
                Arrays.asList("Svyatoslav", "Tonya", "Krutovar"),
                Arrays.asList("Vladik", "Lena", "Mirolyub"),
                Arrays.asList("Sergey", "Nadya", "Rudakov"),
                Arrays.asList("Maks", "Rebekka", "Petrik"),
                Arrays.asList("Vladymir", "Nyura", "Levinsky"),
                Arrays.asList("Yura", "Klavdia", "Shifer"),
                Arrays.asList("Taras", "Marta", "Mirolyub"),
                Arrays.asList("Vovan", "Galya", "Gagik"),
                Arrays.asList("Vertal", "Alla", "Pendiks")
        )
        );

        CollectionFamilyDao<Family> familyMemStorage = new CollectionFamilyDao<>();
        module = new FamilyService(familyMemStorage);
        FamilyController controller = new FamilyController(module);
        //задание прочих входных параметров для создания семей:
        Random rnd = new Random();
        int amntOwn, amntAdopted;
        LocalDate dadBirthDate, momBirthDate;

        for (List<String> names : familyData) {
            amntOwn = 4;
            amntAdopted = 3;
            dadBirthDate = LocalDate.now();
            momBirthDate = LocalDate.now();

            //создание семей и испытании метода createNewFamily():
            module.createNewFamily(names.get(0), names.get(1), names.get(2),
                    dadBirthDate, momBirthDate, amntOwn, amntAdopted);
        }
    }

    @Test
    public void displayAllFamilies() {

    }

    @Test
    public void testCountFamiliesSuccessful() {
        int expected = 16;
        int result = module.countFamiliesWithMemberNumber(9);
        assertEquals(expected, result);
    }

    @Test
    public void testCountFamiliesUnSuccessful() {
        int expected = 16;
        int result = module.countFamiliesWithMemberNumber(6);
        assertNotEquals(expected, result);
    }

    @Test
    public void testCountFamiliesUnSuccessfulNegative() {
        int expected = -1;
        int result = module.countFamiliesWithMemberNumber(-5);
        assertEquals(expected, result);
    }

    @Test
    public void testCreateNewFamilySuccessful() {
        boolean result = module.createNewFamily("Ivan", "Ivanka", "Ivanov",
                LocalDate.of(1983, 2 ,14), LocalDate.of(1991, 4 ,2), 1, 1);
        assertTrue(result);
    }

    @Test
    public void testCreateNewFamilyUnSuccessful1() {
        boolean result = module.createNewFamily(null, "Ivanka", "Ivanov",
                LocalDate.of(1983, 2 ,14), LocalDate.of(1991, 4 ,2), 1, 1);
        assertFalse(result);
    }

    @Test
    public void testCreateNewFamilyUnSuccessful2() {
        boolean result = module.createNewFamily("Ivan", "Ivanka", "Ivanov",
                LocalDate.of(1983, 2 ,14), LocalDate.of(1991, 4 ,2), -1, 1);
        assertFalse(result);
    }

    @Test
    public void testCreateNewFamilyUnSuccessful3() {
        boolean result = module.createNewFamily("Ivan", "Ivanka", "Ivanov",
                LocalDate.of(1983, 2 ,14), LocalDate.of(1991, 4 ,2), 1, -1);
        assertFalse(result);
    }


    @Test
    public void deleteFamilySuccessful() {
        boolean result = module.deleteFamilyByIndex(5);

    }

    @Test
    public void bornChild() {
        Random rnd = new Random();
        int randFamilyIndex = rnd.nextInt(16);
        Family testFam = module.dao.getAllFamilies().get(randFamilyIndex);
        int initCount = 2 + testFam.getChildren().size();
        Family result = module.bornChild(testFam,
                testFam.getFather().getName(), testFam.getMother().getName());
        int finalCount = 2 + testFam.getChildren().size();
        assertEquals(1, finalCount - initCount);
    }

    @Test
    public void adoptChild() {
        int randFamilyIndex = 2;
        Family testFam = module.dao.getAllFamilies().get(randFamilyIndex);
        int initCount = 2 + testFam.getChildren().size();
        Family result = module.bornChild(testFam,
                testFam.getFather().getName(), testFam.getMother().getName());
        int finalCount = 2 + testFam.getChildren().size();
        assertEquals(1, finalCount - initCount);
    }

    @Test
    public void deleteChildrenOlderThenSuccess() {
        boolean result = module.deleteAllChildrenOlderThen(8);
        assertTrue(result);
    }

    @Test
    public void deleteChildrenOlderThenUnSuccess() {
        boolean result = module.deleteAllChildrenOlderThen(-1);
        assertFalse(result);
    }


    @Test
    public void countSuccess() {
        int result = module.count();
        assertEquals(16, result);
    }

    @Test
    public void addPetSuccess() {
        String newPetNickSet = "Joy";
        Pet joy = new Dog(newPetNickSet);
        int familyInd = 5;
        List<Pet> initPetList = module.dao.getAllFamilies().get(familyInd).getPets();
        int initPetListSize = initPetList.size();
        boolean result = module.addPet(familyInd, joy);
        List<Pet> resultPetList = module.dao.getAllFamilies().get(familyInd).getPets();
        int updatedListSize = resultPetList.size();
        boolean petWasAdded = (updatedListSize - initPetListSize == 1);
        Pet newPet = resultPetList.get(updatedListSize - 1);
        String actualNick = newPet.getNickname();
        boolean newPetNameCorrect = (actualNick.equals(newPetNickSet));
        assertTrue(result && petWasAdded && newPetNameCorrect);
    }

    @Test
    public void addPetNameFail() {
        String newPetNickExpected = "Joy";
        String faulthyName = "blablabla";
        Pet joy = new Dog(faulthyName);
        int familyInd = 5;

        List<Pet> initPetList = module.dao.getAllFamilies().get(familyInd).getPets();
        int initPetListSize = initPetList.size();
        boolean result = module.addPet(familyInd, joy);
        List<Pet> resultPetList = module.dao.getAllFamilies().get(familyInd).getPets();
        int finalPetListSize = resultPetList.size();
        boolean petWasAdded = (finalPetListSize - initPetListSize == 1);
        int newListSize = resultPetList.size();
        Pet newPet = resultPetList.get(newListSize - 1);
        String actualNick = newPet.getNickname();
        boolean newPetNameCorrect = (actualNick.equals(newPetNickExpected));
        assertFalse(result && petWasAdded && newPetNameCorrect);
    }
}