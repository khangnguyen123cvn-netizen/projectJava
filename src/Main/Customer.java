
public class Customer 
{    
     protected String customerId;
     protected String name;
     protected String phone;
     protected String email;
     protected int isDelete;

   public void customer()
   {
       System.out.printf("\n----|%-5s|%-5s|%-5s|%-5s|%-6d|----\n", customerId, name, phone, email, isDelete);
   }

    public Customer(String customerId, String name, String phone, String email, int isDelete) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.isDelete = isDelete;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

     
    
}
