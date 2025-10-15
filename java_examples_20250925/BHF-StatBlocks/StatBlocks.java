import java.io.BufferedInputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatBlocks {
    static private double rateUSD = 1;
    static private double rateUAH = 1;

      // static initializer block
    static {
        try {
            URL nbp = new URI(
                "https://static.nbp.pl/dane/kursy/xml/LastA.xml")
                .toURL();
            BufferedInputStream bis =
                new BufferedInputStream(nbp.openStream());
            String txt =
                new String(bis.readAllBytes(),
                           Charset.forName("ISO-8859-2"));
            System.out.println(txt);
            bis.close();
            Matcher m =
                Pattern.compile("(?s).*>USD<[^\\d]+?(\\d+,\\d+)" +
                                    ".*>UAH<[^\\d]+?(\\d+,\\d+).*")
                       .matcher(txt);
            m.matches();
            rateUSD = Double.parseDouble(
                         m.group(1).replace(",","."));
            rateUAH = Double.parseDouble(
                         m.group(2).replace(",","."));
        } catch (Exception e) {
            System.err.println("Fetching data failed.");
            System.exit(1);
        }
    }

    private static int ID = 1;

    private final int id;

      // non-static initializer block
    {
        if (ID % 100 == 13) ++ID;
        id = ID++;
    }

    private double amount;

    public StatBlocks(double a) { amount = a; }
    public StatBlocks()         { this(20);   }

    public static double getRateUSD() { return rateUSD; }
    public static double getRateUAH() { return rateUAH; }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "My id = %d. I have %5.2f " +
                "PLN = $%5.2f = %6.2f UAH",id,
                amount, amount/rateUSD, amount/rateUAH);
    }

    public static void main (String[] args) throws Exception {
        double rUSD = StatBlocks.getRateUSD();
        System.out.println("Current rates are:\n" +
            "    USD/PLN = " + rateUSD + '\n' +
            "    UAH/PLN = " + rateUAH);
        StatBlocks sa = new StatBlocks();
        StatBlocks sb = new StatBlocks(40);
        StatBlocks sc = new StatBlocks(80);
        System.out.println(sc + "\n" + sb + "\n" + sa);
    }
}
