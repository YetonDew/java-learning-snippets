public class Person {

    private String name;
    private int    yob;

    public Person(String name, int y) {
        this.name = name;
        yob       = y;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public boolean isYoungerThan(Person other) {
        return yob > other.yob;
    }

    static Person getOldest(Person ... pers) {

        if (pers.length == 0) return null;

        Person p = pers[0];
        for (Person curr : pers)
            if (p.isYoungerThan(curr)) p = curr;

        return p;
    }

    @Override
    public String toString() {
        return name + " (born " + yob + ")";
    }
}
