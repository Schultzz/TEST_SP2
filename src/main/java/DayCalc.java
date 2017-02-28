import java.util.Calendar;
import java.util.GregorianCalendar;


public class DayCalc {

    public static int getNumDaysinMonth(int month, int year){

        if(month<1 || month>12) return 0;
        else if(year<0 || year> Integer.MAX_VALUE) return 0;

        Calendar cal = new GregorianCalendar(year, month-1, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

}
