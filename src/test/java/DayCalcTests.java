import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DayCalcTests {

    private int month;
    private int years;
    private int expectedDays;

    public DayCalcTests(int month, int years, int expectedDays){
        this.month = month;
        this.years = years;
        this.expectedDays = expectedDays;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                //Months with 31 and 30 days
                {1, 2017, 31},
                {4, 2017, 30},
                //Feb with 28 and 29 days
                {2, 2015, 28},
                {2, 2016, 29},
                //Months with and without leap-year
                {1, 2016, 31},
                {1, 2015, 31},
                {2, 2003, 28},
                {2, 2016, 29},
                //Leap year exceptions
                {2, 2000, 29},
                {2, 2100, 28},
                {2, 2400, 29},
                {1, 0, 31},
                //Invalid equivalence year/Boundary
                {1, -1, 0},
                {1, 0, 31},
                {1, 1, 31},
                {1, Integer.MAX_VALUE/2, 31},
                {1, Integer.MAX_VALUE-1, 31},
                {1, Integer.MAX_VALUE, 31},
                {1, Integer.MAX_VALUE+1, 0},
                //Invalid equivalence for months/Boundary
                {0, 2016, 0},
                {1, 2016, 31},
                {2, 2016, 29},
                {11, 2016, 30},
                {12, 2016, 31},
                {13, 2016, 0}

        });
    }

    @Test
    public void dummyTest(){
        int result = DayCalc.getNumDaysinMonth(this.month, this.years);

        assertEquals(this.expectedDays, result);

    }

}
