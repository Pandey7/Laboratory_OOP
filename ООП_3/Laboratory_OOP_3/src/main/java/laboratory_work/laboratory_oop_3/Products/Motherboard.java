package laboratory_work.laboratory_oop_3.Products;

import laboratory_work.laboratory_oop_3.Warehouse;

public class Motherboard extends Product {

    public Motherboard(String productName, double price, int yearOfProduction) {
        super(productName, price, yearOfProduction);
    }

    @Override
    public void GoToTheWarehouse(Warehouse warehouse) {
        System.out.println("Материнская плата " + ProductName + " отправлена на склад " + warehouse);
    }

    @Override
    public String toString() {
        return "Motherboard{" +
                "ProductName='" + ProductName + '\'' +
                ", Price=" + Price +
                ", YearOfProduction=" + YearOfProduction +
                '}';
    }
}