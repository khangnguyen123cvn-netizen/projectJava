package Main;


public class VipCustomer 
{
      private String customerId;
     private String name;
     private String phone;
     private String email;  
     private double discountRate;

   public void vipcustomer()
   {
       System.out.printf("\n----|%-5s|%-5s|%-5s|%-5s|%-5s|----\n", customerId, name, phone, email, discountRate);
   }

     public VipCustomer(String customerId, String name, String phone, String email, double discountRate) 
    {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.discountRate = discountRate;
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

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
     
}
