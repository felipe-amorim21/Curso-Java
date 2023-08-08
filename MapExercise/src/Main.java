import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        String path = "in.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                if(map.containsKey(fields[0])){
                    map.put(fields[0], map.get(fields[0]) + Integer.valueOf(fields[1]));
                }
                else{
                    map.put(fields[0], Integer.valueOf(fields[1]));
                }
                line = br.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Error Reading");
        }

        for (String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
    }
}