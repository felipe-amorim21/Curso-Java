import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products");
        int n = sc.nextInt();
        sc.nextLine();
        List<Product> productList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            System.out.println("Product #" + (i+1) + "data:");
            System.out.print("Comum, usado, importado (c/u/i)? ");
            char type = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (type == 'i'){
                System.out.println("Custom fee: ");
                Double customFee = sc.nextDouble();
                productList.add(new ImportedProduct(name, price, customFee));
            } else if (type == 'u'){
                System.out.print("Data de fabricacao (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                productList.add(new UsedProduct(name, price, date));
            } else {
                productList.add(new Product(name, price));
            }

        }
        System.out.println();
        System.out.println("ETIQUETAS DE PRECO:");
        for (Product prod : productList) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}