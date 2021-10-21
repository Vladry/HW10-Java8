package hw10.family.Controller;

import hw10.family.Animals.Dog;
import hw10.family.Animals.DomesticCat;
import hw10.family.Animals.Fish;
import hw10.family.service.Services;

public class FamilyController {
    public Services FamilyService ;

    public FamilyController(Services service) {
        this.FamilyService  = service;
    }


    public void doControl(){
        // проверка метода создания животных и метода получения семьи по ID:
        FamilyService.addPet(1, new Dog("Dog_Fam1"));
        FamilyService.addPet(2, new DomesticCat("Cat_Fam2"));
        FamilyService.addPet(3, new Fish("Fish_Fam3"));
        FamilyService.getFamilyById(1);
        FamilyService.getFamilyById(2);
        FamilyService.getFamilyById(3);



//последовательно раскомментируй для проверки остальных методов:

        FamilyService.displayAllFamilies();
        FamilyService.getFamiliesBiggerThan(4);
        FamilyService.getFamiliesLessThan(4);
        FamilyService.countFamiliesWithMemberNumber(4);
        FamilyService.deleteFamilyByIndex(1);
//        FamilyService.deleteAllChildrenOlderThen(9);
        FamilyService.count();

    }


}
