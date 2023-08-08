import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students for course A? ");
        int courseA = sc.nextInt();
        for (int i =0; i < courseA; i++ ){
            set.add(new Student(sc.nextInt()));
        }
        System.out.print("How many students for course B? ");
        int courseB = sc.nextInt();
        for (int i =0; i < courseB; i++ ){
            set.add(new Student(sc.nextInt()));
        }
        System.out.print("How many students for course C? ");
        int courseC = sc.nextInt();
        for (int i =0; i < courseC; i++ ){
            set.add(new Student(sc.nextInt()));
        }

        System.out.println("Total Students: " + set.size());
    }
}