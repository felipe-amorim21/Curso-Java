import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of tax payers: ");
        int n = Integer.parseInt(sc.nextLine());

        List<Pessoa> payers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c): ");
            char p = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Annual income: ");
            double annualIncome = Double.parseDouble(sc.nextLine());

            if (p == 'i' || p == 'I') {
                System.out.print("Health expenditures: ");
                double health = Double.parseDouble(sc.nextLine());

                payers.add(new PessoaFisica(name, annualIncome, health));
            } else {
                System.out.print("Number of employees: ");
                int employees = Integer.parseInt(sc.nextLine());

                payers.add(new PessoaJuridica(name, annualIncome, employees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");

        for (Pessoa payer : payers) {
            System.out.printf("%s: $ %.2f%n", payer.getNome(), payer.taxes());
        }

        sc.close();
    }
}
