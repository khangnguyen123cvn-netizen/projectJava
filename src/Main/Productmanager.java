package Main;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
public class Productmanager extends Abstract 
{
     Scanner sc = new Scanner(System.in);

     
     
     
    @Override
    public void add() 
    {
        String id = "", name = " ", category = " ";
        double price = 0.0;

        while (true) {
            System.out.print("Id: ");
            id = sc.nextLine();
            if (id != null) {
                break;
            } else {
                System.out.println("Input cannot be void!!");
            }
        }

        while (true) {
            System.out.print("Name: ");
            name = sc.nextLine();
            if (name != null) {
                break;
            } else {
                System.out.println("Input cannot be void!!");
            }
        }

        while (true) {
            System.out.print("Category: ");
            category = sc.nextLine();
            if (category != null) {
                break;
            } else {
                System.out.println("Input cannot be void!!");
            }
        }

        while (true) {
            System.out.print("Price: ");
            price = sc.nextDouble();
            if (price > 0) {
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }
        System.out.print("Quantity In Stock: ");
        int quantityInStock = sc.nextInt();
        sc.nextLine();
        try {
            FileWriter w = new FileWriter("product.text", true);
            w.write(String.format("%-10s|%-25s|%-15s|%-25.2f|%-8d|\n", id, name, category, price, quantityInStock));
            w.close();
            System.out.println("Append success");
        } catch (IOException e) {
            System.out.println("Error!Access is denied");
        }
    }

    
    
    @Override
    public void update() {
    String searchId = "";
        while (true) {
            System.out.print("chooseId: ");
            searchId = sc.nextLine().trim();
            if (searchId != null) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    boolean find = false;

    ArrayList<String> fileContent = new ArrayList<>();
    try (BufferedReader r = new BufferedReader(new FileReader("product.text"))) {
        String line;
        
        while ((line = r.readLine()) != null) {
            String[] data = line.split("\\|", -1);
            if (data.length > 0 && data[0].trim().equals(searchId)) {
                find = true;
                
                System.out.println("1.change category");
                System.out.println("2.change price");
                System.out.println("3.add stock "); 
                System.out.print("choose your option: ");
                
                int choose = Integer.parseInt(sc.nextLine()); 
                
                switch (choose) {
                    case 1:
                        while(true){
                        System.out.print("new Category: ");
                        String category = sc.nextLine();
                        if(category != null){
                        data[2] = String.format("%-15s", category);
                        break;
                        } else {
                            System.out.println("Input required!!");
                        }
                        }
                        break; 
                    case 2:
                        while(true){
                        System.out.print("new Price: ");
                        double price = Double.parseDouble(sc.nextLine());
                        if(price > 0.0){
                        data[3] = String.format("%-25.2f", price); 
                        break;
                        } else {
                            System.out.println("Invalid pricing!!");
                        }
                        }
                        break;
                    case 3:
                        while(true){
                            int newQty = -1;
                        System.out.print("Enter quantity to add: ");
                        int addedQty = Integer.parseInt(sc.nextLine());
                        if(addedQty>0.0){
                        int oldQty = Integer.parseInt(data[4].trim()); 
                        newQty = oldQty + addedQty; 
                        }
                        data[4] = String.format("%-8d", newQty); 
                        System.out.println("Stock updated successfully! New stock: " + newQty);
                        break;
                        }
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
                
                line = String.join("|", data);  
            }
            
            fileContent.add(line); 
        }
        
        if (!find) {
            System.out.println("can't find ID !!!!");
            return;
        }

    } catch (IOException e) {
        System.out.println("Error reading file!");
        return;
    } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number!");
        return;
    }
    
    try (FileWriter w = new FileWriter("product.text", false)) { 
        for (String updatedLine : fileContent) {
            w.write(updatedLine + "\n");
        }
        System.out.println("Update complete!");
    } catch (IOException e) {
        System.out.println("Error writing file!");
    }
}
    
    
    @Override
    public void delete() 
    {
        String searchId= "";
        while(true){
   System.out.print("chooseId: ");
    searchId = sc.nextLine();
    if(searchId != null){
        break;
    } else {
        System.out.println("Input required!!");
    }
        }
    boolean find = false;

    ArrayList<String> fileContent = new ArrayList<>();

    try (BufferedReader r = new BufferedReader(new FileReader("product.text"))) {
        String line;
        
        while ((line = r.readLine()) != null) {
            if (line.trim().startsWith(searchId.trim())) {
                find = true;
                String[] parts = line.split("\\|");
                String currentStatus = parts[4].trim();
               
                if (currentStatus.equals("0")) {
                    line = line.replace("|" + parts[4] + "|", "|" + parts[4].replace("0", "1") + "|");
                    System.out.println("Deleted successfully (Status changed to 1)!");
                } else {
                    line = line.replace("|" + parts[4] + "|", "|" + parts[4].replace("1", "0") + "|");
                    System.out.println("Restored successfully (Status changed to 0)!");
                }
            }
            fileContent.add(line);
        }
        
        if (!find) {
            System.out.println("can't find ID !!!!");
            return;
        }

    } catch (IOException e) {
        System.out.println("error!!!can read file");
        return;
    }
    try (FileWriter w = new FileWriter("data.text", false)) { 
        for (String updatedLine : fileContent) {
            w.write(updatedLine + "\n");
        }
    } catch (IOException e) {
        System.out.println("Error writing file!");
    }
 }
    
    
    
    
    
    
    @Override
    public void showInfor()
    {
        
    try (BufferedReader r = new BufferedReader(new FileReader("product.text"))) {
        String line;
        while ((line = r.readLine()) != null) {
            System.out.println(line); 
        }
        
    } catch (IOException e) 
    {
        System.out.println("Eror!! file not exist");
    }
    }
    
    
    
    
    @Override
    public void search() 
  {
    String searchId = "";
        while (true) {
            System.out.print("chooseId: ");
            searchId = sc.nextLine();
            if (searchId != null) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    boolean find = false;
    String search = searchId.trim() + "|"; 

    try (BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
        String line;
        
        while ((line = r.readLine()) != null) {
           if (line.trim().startsWith(searchId.trim())) {
                System.out.println(line);
                find = true;
                break; 
            }
        }
        
        if (!find) {
            System.out.println("can't find ID !!!!");
        }

    } catch (IOException e) {
        System.out.println("error!!!can read file");
    }
 }
}
