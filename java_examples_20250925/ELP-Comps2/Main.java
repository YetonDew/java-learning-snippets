import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    Main() {
        Person[] list = {
          new Person("K",1980,165),
          new Person("B",1986,171),
          new Person("K",1980,168),
          new Person("H",1980,171),
          new Person("M",1980,171),
          new Person("K",1980,169),
          new Person("B",1979,171),
          new Person("G",1975,171)
        };

          // natural
        Arrays.sort(list);
        writeL(list, "Natural: name, age, height");

          // comparator Comp1
        Arrays.sort(list, new Comp1());
        writeL(list, "Comp1:   height, age, name");

          // comparator Comp2
        Comparator<Person> comp2 = new Comp2();
        Arrays.sort(list, comp2);
        writeL(list, "Comp2:   age, name, height");

          // anonymous comparator
        Arrays.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person p, Person q) {
                int k = p.name.compareToIgnoreCase(q.name);
                if ( k != 0 ) return k;
                k = p.height - q.height;
                if ( k != 0 ) return k;
                return q.birthYear - p.birthYear;
            }
        });
        writeL(list, "Anonym:  name, height, age");

          // lambda
        Arrays.sort(list, (f,s) -> f.height-s.height);
        writeL(list, "Lambda:  name, height, age");
    }

    static void writeL(Person[] list, String header) {
        System.out.println('\n'+header);
        for (Person p : list) System.out.print(p+" ");
        System.out.println();
    }
}
