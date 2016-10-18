import org.junit.Test;

import static org.junit.Assert.*;

/**
<<<<<<< HEAD
 * Created by shuai_mac on 10/13/16.
=======
 * Created by i59034 on 10/13/16.
>>>>>>> 05baba7122c48dc0587c7313f598e1d7f7e91c56
 */
public class FrenchRevolutionaryDateTest {
    @Test
    public void dayOfYear() throws Exception {
<<<<<<< HEAD
    FrenchRevolutionaryDate dayOne = new FrenchRevolutionaryDate(1900,1,1);
=======
        FrenchRevolutionaryDate oneDate = new FrenchRevolutionaryDate(1900,1,1);
        assertEquals(oneDate.dayOfYear(),1);
>>>>>>> 05baba7122c48dc0587c7313f598e1d7f7e91c56
    }

    @Test
    public void nextDate() throws Exception {
<<<<<<< HEAD

    }

=======
        FrenchRevolutionaryDate oneDate = new FrenchRevolutionaryDate(1900,1,30);
        FrenchRevolutionaryDate new_Date = oneDate.nextDate();
        assertEquals(new_Date.dayOfYear(),31);
        assertEquals(new_Date.month(),2);
        oneDate = new FrenchRevolutionaryDate(1900,12,5);
        new_Date = oneDate.nextDate();
        assertEquals(new_Date.year(),1901);
        assertEquals(new_Date.month(),1);
        assertEquals(new_Date.dayOfMonth(),1);
        oneDate = new FrenchRevolutionaryDate(1900,11,30);
        new_Date = oneDate.nextDate();
        assertEquals(new_Date.year(),1900);
        assertEquals(new_Date.month(),12);
        assertEquals(new_Date.dayOfMonth(),1);
    }
>>>>>>> 05baba7122c48dc0587c7313f598e1d7f7e91c56
}