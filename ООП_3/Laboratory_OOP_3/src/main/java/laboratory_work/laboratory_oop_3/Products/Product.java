package laboratory_work.laboratory_oop_3.Products;

public abstract class Product implements IPossibleToPutInWarehouse {
    protected String ProductName;
    protected double Price;
    protected int YearOfProduction;

    public Product(String productName, double price, int yearOfProduction) {
        ProductName = productName;
        Price = price;
        YearOfProduction = yearOfProduction;
    }

    public String getProductName() {
        return ProductName;
    }

    public double getPrice() {
        return Price;
    }

    public int getYearOfProduction() {
        return YearOfProduction;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setYearOfProduction(int yearOfProduction) {
        YearOfProduction = yearOfProduction;
    }
}