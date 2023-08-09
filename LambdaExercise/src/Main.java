import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();
        String path = "in.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                list.add(new Employee(fields[0],fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error reading");
        }

        System.out.println("Enter salary: ");
        Double salary = sc.nextDouble();
        System.out.println("Email of people whose salary is more tha 2000.00");
        List<String> emailList = list.stream().filter(x -> x.getSalary() > salary).map(x -> x.getEmail()).collect(Collectors.toList());
        emailList.sort((x,y) -> x.compareTo(y));
        emailList.forEach(System.out::println);
        System.out.println("Sum of salary of people whose name starts with letter 'M': " + list.stream().filter(x -> x.getName().toLowerCase().charAt(0) == 'm').map(x -> x.getSalary()).reduce(0.0, (x,y) -> x+y));
    }
}