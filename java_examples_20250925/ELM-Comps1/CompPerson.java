import java.util.Comparator;

public class CompPerson implements Comparator<Person> {

    public static enum Comp { BY_NAME,    BY_YEAR,
                              BY_NAMERev, BY_YEARRev };
    private Comp comp;

    public CompPerson(Comp comp) {
        this.comp = comp;
    }

    @Override
    public int compare(Person p1, Person p2) {

        int rYear = p1.getYear() - p2.getYear();
        int rName = p1.getName().compareTo(p2.getName());

        return switch (comp) {
            case BY_NAME    -> rName != 0 ?  rName : rYear;
            case BY_NAMERev -> rName != 0 ? -rName : rYear;
            case BY_YEAR    -> rYear != 0 ?  rYear : rName;
            case BY_YEARRev -> rYear != 0 ? -rYear : rName;
        };
    }
}
