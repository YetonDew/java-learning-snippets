import static java.lang.System.out;

public class Main {

    public enum City {WA, KR, PO, GD }

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        for (City c : City.values()) {
            out.println(c + " is " +
                (isItWarsaw(c) ? "" : "not ") + "Warsaw");
        }

        for (ECountry c : ECountry.values()) {
            out.println(
                "Country no " + c.ordinal() + ", "
                + c.name() + ", " +  c + "\n    " +
                "area " + c.getArea() +
                "000 km^2, capital " + c.getCapital());

            switch (c) {
                case PL: // <-- n o t  ECountry.PL
                case GE:
                    out.println("    Baltic sea");
                    break;
                case FR:
                case IT:
                    out.println("    Mediterranean sea");
                    break;
                default:
                    out.println("    Sea unknown...");
            }
        }
    }

      // Enumeration 'City' is a type
    boolean isItWarsaw(City city) {
        return city == City.WA; // <-- n o t  just WA
    }
}
