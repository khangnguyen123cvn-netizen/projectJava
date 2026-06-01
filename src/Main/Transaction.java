package Main;

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
}
