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

public class FamilyAddChildrenTest {
    Family module;
    Human kid1, kid2;
    Map<DayOfWeek, List<String>> schedule = new HashMap<>();

    @Before
    public void setUp() {
        schedule.put(DayOfWeek.SUNDAY, List.of("First day born"));
        schedule.put(DayOfWeek.MONDAY, List.of("First day born"));
        schedule.put(DayOfWeek.TUESDAY, List.of("First day born"));
        schedule.put(DayOfWeek.WEDNESDAY, List.of("Third day born"));
        LocalDate momAge = LocalDate.of(1992, 4, 4);
        module = new Family(new Woman("Mother", "Ryab", momAge),
                new Man("Father", "Ryab", momAge.minusYears(14L).minusMonths(23L).minusDays(23L))
        );
        kid1 = new Man("Kid1", "Kidovich1", momAge.plusYears(25L),
                1, schedule, module);
        kid2 = new Woman("Kid2", "Kidovich2", momAge.plusYears(27L).plusMonths(2L),
                2, schedule, module);

        module.setChildren(kid1);
        module.setChildren(kid2);
    }

    @Test
    public void testAddChildSuccess() {
        Human newChild = new Man("test", "test", LocalDate.of(1986, 1, 4));
        int initialCount = module.getChildren().size();
        module.addChild(newChild);
        int finalCount = module.getChildren().size();
        Human addedChild = module.getChildren().get(initialCount);
        boolean isAdded = (initialCount == finalCount - 1);
        boolean isEqual = addedChild.equals(newChild);
        assertTrue(isAdded && isEqual);
    }

}


