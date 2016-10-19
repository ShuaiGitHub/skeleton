public class FrenchRevolutionaryDate extends Date {

    // In a nonleap year in the French Revolutionary Calendar,
    // the first twelve months have 30 days and month 13 has five days.
    public FrenchRevolutionaryDate(int year, int month, int dayOfMonth) {

        super(year, month, dayOfMonth);
    }

    @Override
    public int dayOfYear() {
        return (month() - 1) * 30 + dayOfMonth();
    }
    @Override
    public FrenchRevolutionaryDate nextDate(){
        int old_year = year();
        int old_month = month();
        int old_dayOfMonth = dayOfMonth();
        int new_year = old_year;
        int new_month = old_month;
        int new_dayOfMonth = old_dayOfMonth;

        if (old_month == 12) {
            if (old_dayOfMonth == 5) {

            }
        }
        return new FrenchRevolutionaryDate(year(),month(),dayOfMonth()+1);
    }
}
