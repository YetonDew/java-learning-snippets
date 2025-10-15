import java.util.Calendar;

public class Person {

    final static int thisYear =
        java.util.Calendar.getInstance().
            get(java.util.Calendar.YEAR);

    private final String name;
    private final int birthYear;

    public Person(String n, int y) {
        name      = n;
        birthYear = y;
    }

    public String getName() { return name;               }
    public int    getYear() { return birthYear;          }
    public int    getAge()  { return thisYear-birthYear; }

    public String toString() {
        return name + "(" + birthYear + ")";
    }

    public static int noChildren(Person[][] families) {
        int count = 0;
        BY_FAMILIES:
        for(int r = 0; r < families.length; ++r) {
            for (int c = 0; c < families[r].length; ++c)
                if (families[r][c].getYear() > thisYear-18)
                    continue BY_FAMILIES;
            ++count;
        }
        return count;
    }
}
