import static java.lang.System.out; // <-- for convenience

public class Main {

    enum Oper { ADD, MUL, MAX, MIN }

                          // this is OK too
    public static void main(String ... args) {
        out.println("Number of arguments: " + args.length);
        new Main();
    }

    private Main() {
        Person ola = new Person("Ola",1990);
        Person ula = new Person("Ula",1992);
        Person[] tab1 = {ola, new Person("Ala",1989), ula};

        Person old = Person.getOldest(tab1);
        out.println("Oldest:   " + old);

        Person joe = new Person("Joe",1985);
        old = Person.getOldest(new Person[]{joe,ula,ola});
        out.println("Oldest:   " + old);

        old = Person.getOldest(
                ula,joe,new Person("Ela",1978),ola);
        out.println("Oldest:   " + old);

        // Autoboxing in action
        int res = action(Oper.ADD,1,5,2,7,4);
        out.println("Sum is:   " + res);

        Integer ires =
            action(Oper.MIN,1,5,7,4,new Integer(-3));
        out.println("Min is:   " + ires);

        // However, int[] is not Integer[].
        // We cannot use new int[]{...} here
        res = action(Oper.MUL,
            new Integer[]{new Integer(-2),
                          new Integer(7),
                          new Integer(2)});
        out.println("Prod is: " + res);

        // this would cause an exception
        // res = action(Oper.MIN);
    }

    static Integer action(Oper op, Integer ... ints) {
        if (ints.length == 0)
            throw new IllegalArgumentException(
                    "empty array in Main.action");
        int res = 0;

        switch (op) {
            case ADD:
                res = 0;
                for (int i : ints) res += i;
                break;
            case MUL:
                res = 1;
                for (int i : ints) res *= i;
                break;
            case MAX:
                res = ints[0];
                for (int i : ints) if ( i > res) res = i;
                break;
            case MIN:
                res = ints[0];
                for (int i : ints) if ( i < res) res = i;
                break;
        }
        return res;
    }
}
