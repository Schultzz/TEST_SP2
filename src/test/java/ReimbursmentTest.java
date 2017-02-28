import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReimbursmentTest {

    private boolean deductible;
    private boolean doctorsVisit;
    private int expected;

    public ReimbursmentTest(boolean deductible, boolean doctorsVisit, int expected) {
        this.deductible = deductible;
        this.doctorsVisit = doctorsVisit;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {true, true, 50},
                {true, false, 80},
                {false, true, 0},
                {false, false, 0}
        });
    }

    @Test
    public void reimbursement(){
        int result = Reimbursment.calcReimbursment(this.deductible, this.doctorsVisit);
        assertEquals(this.expected, result);
    }

}
