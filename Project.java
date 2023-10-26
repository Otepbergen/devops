import java.util.Scanner;

public class Project {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int student = 1;
    double max = 0, min = 0, avg = 0;

    String[] Sname = new String[1000];
    int[] Sid = new int[1000];
    int[] Sscore = new int[1000];

    while(true) {
      System.out.print("Main Menu\n" +
              "1. Add student\n" +
              "2. Manage Records\n" +
              "3. Calculate grades\n" +
              "4. View Statistics\n" +
              "5. Generate reports\n" +
              "6. Delete student\n" +
              "7. Logout and exit\n" +
              "Enter your choice: ");
      int choice = input.nextInt();

      if (choice == 1) {
        System.out.print("Enter student name: ");
        String name = input.next();
        Sname[student] = name;
        System.out.print("Enter student ID: ");
        int id = input.nextInt();
        Sid[student] = id;
        System.out.print("Enter test score: ");
        int score = input.nextInt();
        Sscore[student] = score;
        System.out.println("Student added successfully.");

        student++;
      }
      if (choice == 2) {
        System.out.print("Enter student ID to edit: ");
        int id = input.nextInt();
        System.out.print("Enter new test score: ");
        int score = input.nextInt();

        for (int i = 1; i < student; i++) {
          if (id == Sid[i]) {
            Sscore[i] = score;
            break;
          }
        }

        System.out.println("Student record updated successfully.");
      }
      if (choice == 3) {
        double calmax = 0, calmin = Double.MAX_VALUE, calavg = 0;

        for (int i = 1; i < student; i++) {
          calavg += Sscore[i];
          calmax = Math.max(calmax, Sscore[i]);
          calmin = Math.min(calmin, Sscore[i]);
        }

        max = calmax;
        min = calmin;
        avg = calavg / (student - 1);

        System.out.print("Grades calculated.\n" +
                "Grade Details added.\n");
      }
      if (choice == 4) {
        System.out.println("Statistics:");
        System.out.println("Total Student: " + (student - 1));
        System.out.println("Average Score: " + avg);
        System.out.println("Highest Score: " + max);
        System.out.println("Lowest Score: " + min);
      }
      if (choice == 5) {
        System.out.println("Students");
        for (int i = 1; i < student; i++) {
          System.out.println("Name: " + Sname[i] + " ID: " + Sid[i] + " Score: " + Sscore[i]);
        }
      }
      if (choice == 6) {
        System.out.print("Enter student ID to delete: ");
        int id = input.nextInt();

        int indexToDelete = -1;

        for (int i = 1; i <= student; i++) {
          if (id == Sid[i]) {
            indexToDelete = i;
            break;
          }
        }

        if (indexToDelete != -1) {
          for (int i = indexToDelete; i <= student; i++) {
            Sid[i] = Sid[i + 1];
            Sname[i] = Sname[i + 1];
            Sscore[i] = Sscore[i + 1];
          }
          student--;

          System.out.println("Student deleted successfully.");
        } else {
          System.out.println("Student not found.");
        }
      }
      if (choice == 7) {
        break;
      }
    }
  }
}