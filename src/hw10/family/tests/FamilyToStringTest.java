package hw10.family.tests;

import hw10.family.DayOfWeek;
import hw10.family.People.Family;
import hw10.family.People.Human;
import hw10.family.People.Man;
import hw10.family.People.Woman;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
//import org.junit.Assert;

public class FamilyToStringTest {
    Family module;
    Human kid1, kid2;
    Map<DayOfWeek, List<String>> schedule = new HashMap<>();


    @Before
    public void setUp() {
        Map<DayOfWeek, List<String>> schedule = new HashMap<>();
        schedule.put(DayOfWeek.SUNDAY, List.of("First day born"));
        schedule.put(DayOfWeek.MONDAY, List.of("Second day born"));
        schedule.put(DayOfWeek.TUESDAY, List.of("Third day born"));
        LocalDate dadBirthDate = LocalDate.of(1974, 3, 11);
        module = new Family(new Woman("blablabla", "Ryab", dadBirthDate.minusYears(17L)),
                new Man("Father", "Ryab", dadBirthDate)
        );
        kid1 = new Man("Kid1", "Kidovich1", dadBirthDate.minusYears(30L),
                1, schedule, module);
        kid2 = new Woman("Kid2", "Kidovich2", dadBirthDate.minusYears(36L),
                2, schedule, module);

        module.setChildren(kid1);
        module.setChildren(kid2);
    }

    @Test
    public void testToStringSuccess() {
        String substr1 = module.getChildren().get(0).toString();
        String substr2 = module.getChildren().get(1).toString();
        boolean k1 = substr1.contains("Kid1")
                && substr1.contains("Kidovich1")
                && substr1.contains("2000");
        boolean k2 = substr2.contains("Kid2")
                && substr2.contains("Kidovich2")
                && substr2.contains("2000");
        boolean kidTestPass = k1 && k2;
        boolean motherTestPass = module.toString().contains("blablabla");
        boolean fatherTestPass = module.toString().contains("Father");
        boolean parentsToStringPass = motherTestPass && fatherTestPass;

        assertTrue(kidTestPass && parentsToStringPass);

    }
    @Test
    public void testToStringFailingChildrenArray() {
        String substr1 = module.getChildren().get(0).toString();
        String substr2 = module.getChildren().get(1).toString();
        boolean k1 = substr1.contains("blablabla")
                && substr1.contains("Kidovich1")
                && substr1.contains("2000");
        boolean k2 = substr2.contains("Kid2")
                && substr2.contains("Kidovich2")
                && substr2.contains("2000");
        boolean kidTestPass = k1 && k2;
        boolean motherTestPass = module.toString().contains("Mother");
        boolean fatherTestPass = module.toString().contains("Father");
        boolean parentsToStringPass = motherTestPass && fatherTestPass;

        assertTrue(!kidTestPass && !parentsToStringPass);
    }

    @Test
    public void testToStringFailingMotherField() {
        String substr1 = module.getChildren().get(0).toString();
        String substr2 = module.getChildren().get(1).toString();
        boolean k1 = substr1.contains("Kid1")
                && substr1.contains("Kidovich1")
                && substr1.contains("2000");
        boolean k2 = substr2.contains("Kid2")
                && substr2.contains("Kidovich2")
                && substr2.contains("2000");
        boolean kidTestPass = k1 && k2;
        boolean motherTestPass = module.toString().contains("Mother");
        boolean fatherTestPass = module.toString().contains("Father");
        boolean parentsToStringPass = motherTestPass && fatherTestPass;

        assertTrue(kidTestPass && !parentsToStringPass);
    }
}
