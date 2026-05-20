import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        try {
            File file = new File("tab.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                numbers.add(number);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        for (int number : numbers) {
            if(number >= max)
                max = number;
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println(max);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == max) {
                System.out.print(i + " ");
            }
        }
    }
}