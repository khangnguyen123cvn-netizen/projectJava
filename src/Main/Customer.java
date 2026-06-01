
public class Customer 
{    
     private String customerId;
     private String name;
     private String phone;
     private String email;

   public void customer()
   {
       System.out.printf("\n----|%-5s|%-5s|%-5s|%-5s|----\n", customerId, name, phone, email);
   }

     public Customer(String customerId, String name, String phone, String email) 
    {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    } 
   
    public String getCustomerId()
     {
         return customerId;
     }
    public void setCustomerId(String customerId)
    {
        this.customerId = customerId;
    }
    public String getname()
     {
         return name;
     }
    public void setname(String name)
    {
        this.name = name;
    }
    public String getphone()
     {
         return phone;
     }
    public void setphone(String phone)
    {
        this.phone = phone;
    }
    public String getemail()
     {
         return email;
     }
    public void setemail(String email)
    {
        this.email = email;
    }
}
