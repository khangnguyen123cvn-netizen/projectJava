package Main;


public class Product 
{
    private String productId;
    private String productName;
    private String category;
    private double price;
    private int quantityInStock;
    public Product(String productId, String productName,String category, double price, int quantityInStock) 
    {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }
    public void product()
    {
        System.out.printf("\n----|%-5s|%-5s|%-5s|%-5f|%-5d|----\n", productId, productName, category, price, quantityInStock);
    }
    
    public String getProductId() 
    {
        return productId; 
    }
    public void setProductId(String productId) 
    {
        this.productId = productId; 
    }

    public String getProductName() 
    {
        return productName; 
    }
    public void setProductName(String productName) 
    { 
        this.productName = productName; 
    }
    public String getCategory() 
    {
        return category; 
    }
    public void setCategory(String category) 
    { 
        this.category = category; 
    }

    public double getPrice() 
    { 
        return price; 
    }
    public void setPrice(double price) 
    { 
        this.price = price; 
    }

    public int getQuantityInStock() 
    { 
        return quantityInStock; 
    }
    public void setQuantityInStock(int quantityInStock) 
    { 
        this.quantityInStock = quantityInStock; 
    }

}
