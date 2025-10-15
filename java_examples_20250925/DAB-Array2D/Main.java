import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Person jSmith = new Person("John Smith",1970);
        Person eSmith = new Person("Ella Smith",1973);
        Person[] smith = {jSmith, null, eSmith};
        smith[1] = new Person("Olaf Smith",1943);

        Person[][] families =
            {
                smith,
                null,
                {
                    new Person("Ulla Novak",1971),
                    new Person("Amy Novak",1993),
                    new Person("Charles Novak",1969),
                    new Person("Mark Novak",1995),
                }
            };

        families[1] = new Person[] {
                          new Person("Wally Welch", 1980),
                          new Person("Katy Welch", 1958),
                          new Person("Maggie Welch", 1987)
                      };

        int n = Person.noChildren(families);
        JOptionPane.showMessageDialog(null,
            "Number of families with no children: " + n);

        System.exit(0);
    }
}
