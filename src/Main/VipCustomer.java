

public class VipCustomer extends Customer
{
        
     private double discountRate;

    public VipCustomer(double discountRate, String customerId, String name, String phone, String email, int isDelete) {
        super(customerId, name, phone, email, isDelete);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
  

   

 
     
     
}
