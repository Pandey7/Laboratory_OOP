package laboratory_work.laboratory_oop_3.Products;

import laboratory_work.laboratory_oop_3.Warehouse;

public class Processor extends Product{

    public Processor(String productName, double price, int yearOfProduction) {
        super(productName, price, yearOfProduction);
    }

    @Override
    public void GoToTheWarehouse(Warehouse warehouse) {
        System.out.println("Процессор "+ProductName+" отправлен на склад "+warehouse);
    }

    @Override
    public String toString() {
        return "Processor{" +
                "ProductName='" + ProductName + '\'' +
                ", Price=" + Price +
                ", YearOfProduction=" + YearOfProduction +
                '}';
    }
}