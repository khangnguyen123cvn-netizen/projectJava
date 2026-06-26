package Main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Report {
    public void report() {
        try (BufferedReader r = new BufferedReader(new FileReader("Transaction.text"))) {
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line); 
            }
        } catch (IOException e) {
            System.out.println("Error reading Transaction.text file!");
        }
    }
}