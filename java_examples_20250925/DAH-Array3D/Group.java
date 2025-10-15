public class Group {
    String[] students;
    String[] subjects;
    int[][][]  grades;

    public Group(String[] s, String[] c, int[][][] g) {
        students = s;
        subjects = c;
        grades   = g;
    }

    int       getNumOfStud() { return students.length; }
    String getStudent(int s) { return students[s];     }
    String getSubject(int c) { return subjects[c];     }

      // returns number of students with no '2' grade
    int goodStud() {
        int count = 0;
        LOOP:
        for (int s = 0; s < grades.length; ++s) {
            for (int c = 0; c < grades[s].length; ++c)
                for (int g = 0; g < grades[s][c].length;++g)
                    if (grades[s][c][g] < 3) continue LOOP;
            ++count;
        }
        return count;
    }

      // returns array of averages of grades in
      // a selected subject 'c' for all students
      // (assuming that every student has at least
      // one grade in each subject)
    double[] aveOfSubject(int c) {
        double[] averages = new double[grades.length];
        for (int s = 0; s < grades.length; ++s) {
            double average = 0;
            for (int g = 0; g < grades[s][c].length; ++g)
                average += grades[s][c][g];
            averages[s] = average/grades[s][c].length;
        }
        return averages;
    }

      // returns names of students who have
      // the average of all grades above 4
    String[] getBest() {
        String[] pom = new String[students.length];
        int count = 0;
          // over students
        for (int s = 0; s < grades.length; ++s) {
            double ave = 0;
            int    num = 0;
              // over subjects for student s
            for (int c = 0; c < grades[s].length; ++c) {
                num += grades[s][c].length;
                  // over grades for student s, subject c
                for (int g = 0; g < grades[s][c].length;++g)
                    ave += grades[s][c][g];
            }
            ave /= num;
            if (ave > 4) pom[count++] = students[s];
        }

        String[] result = new String[count];
        for (int i = 0; i < count; ++i)
            result[i] = pom[i];
        return result;
    }
}
