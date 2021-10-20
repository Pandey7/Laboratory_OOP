package laboratory_work.laboratory_oop_3.Products;

import laboratory_work.laboratory_oop_3.Warehouse;

public class VideoCard extends Product{

    public VideoCard(String productName, double price, int yearOfProduction) {
        super(productName, price, yearOfProduction);
    }

    @Override
    public void GoToTheWarehouse(Warehouse warehouse) {
        System.out.println("Видеокарта "+ProductName+" отправлена на склад "+warehouse);
    }

    @Override
    public String toString() {
        return "VideoCard{" +
                "ProductName='" + ProductName + '\'' +
                ", Price=" + Price +
                ", YearOfProduction=" + YearOfProduction +
                '}';
    }
}
