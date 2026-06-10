package Main;

import java.io.FileWriter;
import java.time.LocalDateTime;
public class Transaction 
{
    private String productId;
    private int quantity;
    private String name;
    private LocalDateTime timestamp;
   
      public Transaction( String productId,String name, int quantity) 
        {
          this.productId = productId;
          this.name = name;
          this.quantity = quantity;
          this.timestamp = LocalDateTime.now().withNano(0);
        }
      public LocalDateTime getTimestamp() 
      { 
          return timestamp; 
      }
    public void setTimestamp(LocalDateTime timestamp) 
      { 
        this.timestamp = timestamp; 
      }
    public String getProductId()
    {
        return productId;
    }
    public String getName()
    {
        return name;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public void saveTransaction(Transaction t)
{
    try(FileWriter fw = new FileWriter("Transaction.text", true))
    {
        fw.write(String.format(
    "%-10s|%-25s|%-10d|%-20s%n",t.getProductId(),t.getName(),t.getQuantity(),t.getTimestamp()));
    }
    catch(Exception e)
    {
        System.out.println("Can't add transaction!!");
    }
}
}

