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

public class CountFamilyTest {

    Family module;
    Human kid1, kid2;
    Map<DayOfWeek, List<String>> schedule = new HashMap<>();

    @Before
    public void setUp() {
        schedule.put(DayOfWeek.SUNDAY, List.of("First day born"));
        schedule.put(DayOfWeek.MONDAY, List.of("First day born"));
        schedule.put(DayOfWeek.TUESDAY, List.of("First day born"));
        schedule.put(DayOfWeek.WEDNESDAY, List.of("Third day born"));
        module = new Family(new Woman("Mother", "Ryab", LocalDate.now()),
                new Man("Father", "Ryab", LocalDate.of(1985, 1, 1))
        );
        LocalDate Kid1Birthday = LocalDate.of(2001, 2, 1);
        kid1 = new Man("Kid1", "Kidovich1", Kid1Birthday,
                1, schedule, module);
        kid2 = new Woman("Kid2", "Kidovich2", Kid1Birthday.plusYears(4).plusMonths(2),
                2, schedule, module);

        module.setChildren(kid1);
        module.setChildren(kid2);
    }

    @Test
    public void CountFamilySuccess() {
        assertEquals(5, module.countFamily(3));
    }

}
