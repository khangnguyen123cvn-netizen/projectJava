package Main;

import java.io.FileWriter;
import java.time.LocalDateTime;
public class Transaction 
{
    private String CustomerId;
    private int quantity;
    private String name;
    private String productName;
    private String productId;
    private double price;
    private LocalDateTime timestamp;

    public Transaction(String CustomerId, String name,String productId, String productName,int quantity, double price, LocalDateTime timestamp) {
        this.CustomerId = CustomerId;
        this.quantity = quantity;
        this.name = name;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.timestamp = timestamp;
    }

    public Transaction() {
        
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    

    
    public void saveTransaction(Transaction t)
{
    try(FileWriter fw = new FileWriter("Transaction.text", true))
    {
        fw.write(String.format(
       "| %-10s | %-20s | %-15s | %-8d | %-10.2f | %-20s %n", t.CustomerId, t.name, t.productName,t.quantity,t.price,t.timestamp));
    }
    catch(Exception e)
    {
        System.out.println("Can't add transaction!!");
    }
}
}
