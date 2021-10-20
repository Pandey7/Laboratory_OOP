package laboratory_work.laboratory_oop_3;

import laboratory_work.laboratory_oop_3.Products.IPossibleToPutInWarehouse;
import laboratory_work.laboratory_oop_3.Products.Motherboard;
import laboratory_work.laboratory_oop_3.Products.Processor;
import laboratory_work.laboratory_oop_3.Products.VideoCard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("warehouseBean")
@Scope("singleton")
public class Warehouse {

    @Value("${warehouse.NumberWarehouse}")
    private String NumberWarehouse;
    private List<IPossibleToPutInWarehouse> Products;
    private String dash;

    public Warehouse() {
        System.out.println("WarehouseBean was created");
        Products = new ArrayList<>();
        dash = "-----------------------------------------------------";
    }

    public String getNumberWarehouse() {
        return NumberWarehouse;
    }

    public void setNumberWarehouse(String numberWarehouse) {
        NumberWarehouse = numberWarehouse;
    }

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 3; i++) {
            Motherboard motherboard = new Motherboard("Motherboard#" + i, i * 10000, 2017 + i);
            Processor processor = new Processor("Processor#" + i, i * 10000, 2017 + i);
            VideoCard videoCard = new VideoCard("VideoCard#" + i, i * 10000, 2017 + i);

            AddToWarehouse(motherboard);
            AddToWarehouse(processor);
            AddToWarehouse(videoCard);
        }
    }

    public int getProductsSize(){
        return  Products.size();
    }

    public void AddToWarehouse(IPossibleToPutInWarehouse product) {
        System.out.println(dash);
        System.out.println("Работа функции AddToWarehouse");
        Products.add(product);
        product.GoToTheWarehouse(this);
        System.out.println(dash);
    }

    public List<IPossibleToPutInWarehouse> getBeforeProducts() {
        System.out.println(dash);
        System.out.println("Работа функции getBeforeProducts");
        System.out.println("Вывод продукции:");
        System.out.println(Products);
        System.out.println(dash);
        return Products;
    }

    public List<IPossibleToPutInWarehouse> getAfterReturningProducts() {
        System.out.println(dash);
        System.out.println("Работа функции getAfterReturningProducts");
        System.out.println("Вывод продукции:");
        System.out.println(Products);
        System.out.println(dash);
        return Products;
    }

    public IPossibleToPutInWarehouse getAfterThrowingProducts() {
        int index = Products.size();
        System.out.println(dash);
        System.out.println("Работа функции getAfterThrowingProducts");
        System.out.println("Получение доступа к прокуции по индексу, которого нет: ");
        System.out.println(Products.get(index));
        System.out.println(dash);
        return Products.get(index);
    }

    public IPossibleToPutInWarehouse getAfterFinallyProducts(int index) {
        System.out.println(dash);
        System.out.println("Работа функции getAfterFinallyProducts");
        System.out.println("Получение доступа к прокуции по индексу " + index + ": ");
        System.out.println(Products.get(index));
        System.out.println(dash);
        return Products.get(index);
    }

    public IPossibleToPutInWarehouse getAroundProducts(int index) {
        System.out.println(dash);
        System.out.println("Работа функции getAroundProducts");
        System.out.println("Получение доступа к прокуции по индексу " + index + ": ");
        System.out.println(Products.get(index));
        System.out.println(dash);
        return Products.get(index);
    }



    @Override
    public String toString() {
        return "Warehouse{" +
                "NumberWarehouse='" + NumberWarehouse + '\'' +
                '}';
    }
}
