import javax.imageio.IIOException;
import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String path = "in.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                String[] arr = line.split(",");
                Product p = new Product(arr[0],Double.valueOf(arr[1]),Integer.valueOf(arr[2]));
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./summary.csv", true))){
                    bw.write(p.getName());
                    bw.write(",");
                    bw.write(String.valueOf(p.getTotalPrice()));
                    bw.newLine();
                }
                catch (IOException e){
                    System.out.println("Error Wrinting");

                }
                line = br.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Error Reading");
        }
    }
}