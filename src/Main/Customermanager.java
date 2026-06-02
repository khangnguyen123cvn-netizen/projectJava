import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
public class Customermanager extends Abstract 
{
     Scanner sc = new Scanner(System.in);

     
     
     
    @Override
    public void add() 
    {
        
        System.out.print("Id: ");
        String id = sc.nextLine(); 
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("phone: ");
        String phone = sc.nextLine();
        System.out.print("gmail: ");
        String mail = sc.nextLine();
        System.out.print("delete: ");
        int isDelete = sc.nextInt();
        try 
        {
            FileWriter w = new FileWriter("data.text", true); 
            w.write(String.format("%-10s|%-25s|%-15s|%-25s|%-6d|\n", id, name, phone, mail, isDelete));
            w.close();   
            System.out.println("Append success");
        } 
        catch (IOException e) 
        {
            System.out.println("Error!Access is denied");
        }
    }

    
    
    @Override
    public void update() {
    System.out.print("chooseId: ");
    String searchId = sc.nextLine().trim();
    boolean find = false;

    ArrayList<String> fileContent = new ArrayList<>();
    try (BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
        String line;
        
        while ((line = r.readLine()) != null) {
            String[] data = line.split("\\|", -1);
            if (data.length > 0 && data[0].trim().equals(searchId)) {
                find = true;
                
                System.out.println("1.change phone");
                System.out.println("2.change email");
                System.out.print("choose your option: ");
                
                
                int choose = Integer.parseInt(sc.nextLine()); 
                
                switch (choose) {
                    case 1:
                        System.out.print("new Phone: ");
                        String phone = sc.nextLine();
                        data[2] = String.format("%-15s", phone);
                        break; 
                    case 2:
                        System.out.print("new Email: ");
                        String email = sc.nextLine();
                        data[3] = String.format("%-25s", email); 
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
    try (FileWriter w = new FileWriter("data.text", false)) { 
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
   System.out.print("chooseId: ");
    String searchId = sc.nextLine();
    boolean find = false;

    ArrayList<String> fileContent = new ArrayList<>();

    try (BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
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
        
    try (BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
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
    System.out.print("chooseId: ");
    String searchId = sc.nextLine();
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
