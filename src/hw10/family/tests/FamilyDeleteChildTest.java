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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FamilyDeleteChildTest {
    Family module;
    Human kid1, kid2, kid3, kid4, kid5, kid6;
    Map<DayOfWeek, List<String>> schedule = new HashMap<>();

    @Before
    public void setUp() {
        schedule.put(DayOfWeek.SUNDAY, List.of("First day born"));
        schedule.put(DayOfWeek.MONDAY, List.of("First day born"));
        schedule.put(DayOfWeek.TUESDAY, List.of("First day born"));
        schedule.put(DayOfWeek.WEDNESDAY, List.of("Third day born"));
        LocalDate momAge = LocalDate.of(1988, 1 ,2);
        module = new Family(new Woman("Mother", "Ryab", momAge),
                new Man("Father", "Ryab", momAge.minusYears(14L))
        );
        kid1 = new Man("Kid1", "Kidovich1", momAge.plusYears(21).plusMonths(1L),
                1, schedule, module);
        kid2 = new Man("Kid2", "Kidovich2", momAge.plusYears(22).plusMonths(1L),
                2, schedule, module);
        kid3 = new Man("Kid3", "Kidovich3", momAge.plusYears(24).plusMonths(1L),
                3, schedule, module);
        kid4 = new Woman("Kid4", "Kidovich4", momAge.plusYears(26).plusMonths(1L),
                4, schedule, module);
        kid5 = new Woman("Kid5", "Kidovich5", momAge.plusYears(28).plusMonths(1L),
                5, schedule, module);
        kid6 = new Woman("Kid6", "Kidovich6", momAge.plusYears(29).plusMonths(1L),
                6, schedule, module);
        module.setChildren(kid1);
        module.setChildren(kid2);
        module.setChildren(kid3);
        module.setChildren(kid4);
        module.setChildren(kid5);
        module.setChildren(kid6);
    }

    @Test
    public void testDeleteChildSuccess() {
//        System.out.println(Arrays.toString(module.getChildren()));
        boolean isDeleted = module.deleteChild(1);
        List<Human> freshChildren = module.getChildren();
        boolean remainedFirstElem = freshChildren.get(0).getName().equals("Kid1");
        boolean secondElemDeleted = !freshChildren.get(1).toString().equals("Kid2");
        boolean testResult = isDeleted && remainedFirstElem && secondElemDeleted;
//        System.out.println(Arrays.toString(module.getChildren()));
        assertTrue(testResult);
    }

    @Test
    public void testDeleteChildUnsuccess() {
        int arrInitLength = module.getChildren().size();
        module.deleteChild(56);
        module.deleteChild(-1);
        int arrFinalLength = module.getChildren().size();
        assertEquals(arrInitLength, arrFinalLength);
    }

}
