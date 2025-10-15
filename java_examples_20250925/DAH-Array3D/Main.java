import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args)
    {
        String[] subjects = {
            "Math","Programming","English"
        };

          // Group 0
        String[] stud0 = {
            "John",  "Mark", "Jim","Henry",
            "Peter","Kevin","Jack"
        };
          // three-dimensional array of grades:
          //     first index  - student
          //     second index - subject for a given student
          //     third index  - grade for a given student
          //                    in a given subject
        int[][][] grades0 = {
          //   Math     Programming    English
            { {3,4,3}, {4,3,3,4,4,3}, {4,3,3} }, // stud. 0
            { {3,5},   {5,2,3,3,4},   {2,4}   }, // stud. 1
            { {5,4,4}, {5,5,5,4},     {3}     }, // stud. 2
            { {3,4,3}, {4,3,3,3,3},   {3,3,4} }, // stud. 3
            { {4,3},   {4,3,3},       {5,3}   }, // stud. 4
            { {5,3},   {4,2,3},       {3,3}   }, // stud. 5
            { {3,2},   {4,3,3},       {5,3}   }, // stud. 6
        };
        Group gr0 = new Group(stud0,subjects,grades0);


          // Group 1
        String[] stud1 = {
            "Ann","Katy","Ella","Sue",
            "Maya","Margot","Martha","Maggie"
        };
        int[][][] grades1 = {
          //   Math     Programming    English
            { {3,4,3}, {4,3,3,4,3},   {4,3,3} }, // stud. 0
            { {2,5},   {5,2,4,3,4},   {2,4}   }, // stud. 1
            { {5,4,4}, {5,5,4,4},     {5}     }, // stud. 2
            { {3,4,3}, {4,3,3,3,3},   {3,3,4} }, // stud. 3
            { {5,3},   {4,3,3},       {5,3}   }, // stud. 4
            { {5,5,5}, {4,2},         {3,3,4} }, // stud. 5
            { {3,2},   {4,3,3},       {5,3}   }, // stud. 6
            { {5,4},   {5,5,4},       {5,4}   }, // stud. 7
        };
        Group gr1 = new Group(stud1,subjects,grades1);

          // No '2' grade ====
        System.out.println("No 2 gr0: " + gr0.goodStud());
        System.out.println("No 2 gr1: " + gr1.goodStud());

          // Averages ========

            // select course
        int p = JOptionPane.showOptionDialog(
                     null, "Select course:", "MENU", 0,
                     JOptionPane.QUESTION_MESSAGE, null,
                     subjects,subjects[0]);
        if (p == JOptionPane.CLOSED_OPTION) System.exit(0);
        System.out.println("\nAverages in " +
                          subjects[p] + "\n");

          // averages for students from
          // group 1 in selected subject
        double[] averages = gr1.aveOfSubject(p);
        for (int s = 0; s < gr1.getNumOfStud(); ++s)
            System.out.printf("%10s  %4.2f\n",
                    gr1.getStudent(s),averages[s]);


          // Best students ===

        System.out.print("\nBest from group 0: ");
        String[] best = gr0.getBest();
        for (String b : best) System.out.print(b + " ");
        System.out.println();

        System.out.print("\nBest from group 1: ");
        best = gr1.getBest();
        for (String b : best) System.out.print(b + " ");
        System.out.println();

        System.exit(0);
    }
}
