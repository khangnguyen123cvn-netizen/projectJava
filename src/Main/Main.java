package Main;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice, subChoice;
        Customermanager customerManager = new Customermanager();
        VipCustomermanager vipCustomerManager = new VipCustomermanager();
        Productmanager productManager = new Productmanager();
        Transaction transactionManager = new Transaction();
        Report report = new Report();

        while (true) {
            System.out.println("\n--------------- MAIN MENU ---------------");
            System.out.println("1. Manage Customer");
            System.out.println("2. Manage VIP Customer");
            System.out.println("3. Manage Product");
            System.out.println("4. Buy Product");
            System.out.println("5. show report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();

            if (mainChoice == 0) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            switch (mainChoice) {
                case 1:
                    System.out.println("\n--- CUSTOMER MANAGEMENT ---");
                    System.out.println("1. Add Customer");
                    System.out.println("2. Update Customer");
                    System.out.println("3. Delete Customer");
                    System.out.println("4. Show Customer Information");
                    System.out.println("5. Search Customer");
                    System.out.println("0. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    subChoice = scanner.nextInt();
                    
                    switch (subChoice) {
                        case 1:
                            customerManager.add();
                        break;
                        case 2: 
                            customerManager.update();
                        break;
                        case 3:
                            customerManager.delete();
                        break;
                        case 4:
                            customerManager.showInfor();
                        break;
                        case 5: 
                            customerManager.search();
                        break;
                        case 0: break;
                        default: System.out.println("Invalid choice!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- VIP CUSTOMER MANAGEMENT ---");
                    System.out.println("1. Add VIP Customer");
                    System.out.println("2. Update VIP Customer");
                    System.out.println("3. Delete VIP Customer");
                    System.out.println("4. Show VIP Customer Information");
                    System.out.println("5. Search VIP Customer");
                    System.out.println("0. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    subChoice = scanner.nextInt();

                    switch (subChoice) {
                        case 1: 
                         vipCustomerManager.add();
                         break;
                        case 2: 
                         vipCustomerManager.update();
                         break;
                        case 3:
                         vipCustomerManager.delete();
                            break;
                        case 4: 
                            vipCustomerManager.showInfor();
                            break;
                        case 5: 
                            vipCustomerManager.search();
                            break;
                        case 0: break;
                        default: System.out.println("Invalid choice!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- PRODUCT MANAGEMENT ---");
                    System.out.println("1. Add Product");
                    System.out.println("2. Update Product");
                    System.out.println("3. Delete Product");
                    System.out.println("4. Show Product Information");
                    System.out.println("5. Search Product");
                    System.out.println("0. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    subChoice = scanner.nextInt();

                    switch (subChoice) {
                        case 1: 
                             productManager.add();
                            break;
                        case 2: 
                             productManager.update();
                            break;
                        case 3: 
                             productManager.delete();
                            break;
                        case 4: 
                             productManager.showInfor();
                            break;
                        case 5: 
                             productManager.search();
                            break;
                        case 0: break;
                        default: System.out.println("Invalid choice!");
                    }
                    break;

                case 4: 
                     System.out.println("\n--- BUY PRODUCT INTERFACE ---");
                     System.out.println("1. Choose Product & Buy");
                     System.out.println("0. Back to Main Menu");
                     System.out.print("Enter your choice: ");
                     subChoice = scanner.nextInt();
                     scanner.nextLine();
                    switch (subChoice) {
                      case 1: 
                        while (true) { 
                           System.out.print("Enter Customer ID to purchase (or type 'exit' to back): ");
                           String buyerId = scanner.nextLine().trim();
                           if (buyerId.equalsIgnoreCase("exit")) {
                               break; 
                           }
                           
                           boolean isCustomerExist = false;
                           String buyerName = "";
                           try (BufferedReader r = new BufferedReader(new FileReader("data.text"))) {
                               String line;
                               while ((line = r.readLine()) != null) {
                                   if (line.trim().isEmpty()) {
                                       continue; 
                                   }   
                                   String[] data = line.split("\\|", -1);
                                   if (data.length >= 2) { 
                                       if (data[0].trim().equals(buyerId)) {
                                           isCustomerExist = true;
                                           buyerName = data[1].trim(); 
                                           break;
                                       }
                                   }
                               }
                           } catch (IOException e) {
                               System.out.println("Error reading customer data file!");
                               break;
                           }
                           if (!isCustomerExist) {
                               System.out.println("Customer ID not found! Access denied.");
                               break;
                           }
                           System.out.println("\n>>> Customer Verified: " + buyerName + " (ID: " + buyerId + ") <<<");
                           try (BufferedReader r = new BufferedReader(new FileReader("product.text"))) {
                               String line;
                               while ((line = r.readLine()) != null) {
                                   String[] data = line.split("\\|", -1);
                                   if (data.length >= 5) {
                                       System.out.format("%-10s | %-20s | %-15s | %-10s | %-10s\n", 
                                           data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
                                   }
                               }
                           } catch (IOException e) {
                               System.out.println("Error reading product catalog! Cannot display products.");
                               break;
                           }
                           System.out.print("\nEnter Product ID to buy: ");
                           String searchProdId = scanner.nextLine().trim();      
                           ArrayList<String> updatedProductLines = new ArrayList<>();
                           boolean isProductExist = false;
                           String boughtProductName = "";
                           double boughtPrice = 0;
                           int buyQty = 0;
                           try (BufferedReader r = new BufferedReader(new FileReader("product.text"))) {
                               String line;
                               while ((line = r.readLine()) != null) {
                                   String[] data = line.split("\\|", -1);
                                   if (data.length >= 5 && data[0].trim().equals(searchProdId)) {
                                       isProductExist = true;
                                       boughtProductName = data[1].trim();
                                       boughtPrice = Double.parseDouble(data[3].trim());
                                       int currentStock = Integer.parseInt(data[4].trim());
                                       System.out.println("Selected: " + boughtProductName + " | Price: " + boughtPrice + " | Current Stock: " + currentStock);
                                       System.out.print("Enter quantity to buy: ");
                                       buyQty = Integer.parseInt(scanner.nextLine());
                                       if (buyQty > currentStock) {
                                           System.out.println("Not enough stock available! Purchase failed.");
                                           break;
                                       }
                                       if (buyQty <= 0) {
                                           System.out.println("Quantity must be greater than 0! Purchase failed.");
                                           break;
                                       }
                                       int newStock = currentStock - buyQty;
                                       data[4] = String.format("%-8d", newStock);
                                       line = String.join("|", data);
                                   }
                                   updatedProductLines.add(line);
                               }
                           } catch (IOException | NumberFormatException e) {
                               System.out.println("Data processing error! Purchase aborted.");
                               break;
                           }

                           if (!isProductExist) {
                               System.out.println("Product ID not found! Purchase failed.");
                               break;
                           }
                           try (FileWriter w = new FileWriter("product.text", false)) {
                               for (String prodLine : updatedProductLines) {
                                   w.write(prodLine + "\n");
                               }
                           } catch (IOException e) {
                               System.out.println(" Could not update product inventory file!");
                               break;
                           }
                           try (FileWriter wTranz = new FileWriter("Transaction.text", true)) {
                               double totalCost = boughtPrice * buyQty;
                               java.time.LocalDateTime now = java.time.LocalDateTime.now();
                               java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                               String timestamp = now.format(formatter);
                               wTranz.write(String.format("%-11s|%-21s|%-16s|%-16s|%-9d|%-17.2f|%s\n", 
                                   buyerId, buyerName, searchProdId, boughtProductName, buyQty, totalCost, timestamp));
                               
                               System.out.println("   PURCHASE SUCCESSFUL!");
                               System.out.println("   Customer: " + buyerName);
                               System.out.println("   Product: " + boughtProductName + " x" + buyQty);
                               System.out.println("   Total Paid: $" + totalCost);
                               System.out.println("   Time: " + timestamp);
                           } catch (IOException e) {
                               System.out.println("Error saving receipt to transaction log!");
                           }
                        } 
                        break;
                      case 0: 
                         break;
                      default: 
                        System.out.println("Invalid choice!");
                    }
                    break;
                case 5:
                    Report finalReport = new Report();
                    finalReport.report(); 
                    break;
            }
        }
    }
}
   

