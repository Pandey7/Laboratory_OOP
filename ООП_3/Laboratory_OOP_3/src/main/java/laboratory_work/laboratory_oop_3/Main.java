package laboratory_work.laboratory_oop_3;

import laboratory_work.laboratory_oop_3.Products.Motherboard;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    private static String dash = "-----------------------------------------------------";
    private static int select = -1;
    private static String prefix = "Вывод в Main\n";
    private static String ends = "\n";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Warehouse warehouse = context.getBean("warehouseBean", Warehouse.class);

        do {
            System.out.println("Выберите какой Advice продемонстрировать:\n" +
                    "1-Before\n" +
                    "2-After Returning\n" +
                    "3-After Throwing\n" +
                    "4-After/After Finally\n" +
                    "5-Around\n" +
                    "6-Все вместе\n" +
                    "0-Никакой\n");
            System.out.println("Введите значение от 0 до 6");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                select = scanner.nextInt();

                System.out.println(dash);
                switch (select) {
                    case 1:
                        DemonstrationBefore(warehouse);
                        break;
                    case 2:
                        DemonstrationAfterReturning(warehouse);
                        break;
                    case 3:
                        DemonstrationAfterThrowing(warehouse);
                        break;
                    case 4:
                        DemonstrationAfterFinally(warehouse);
                        break;
                    case 5:
                        DemonstrationAround(warehouse);
                        break;
                    case 6:
                        DemonstrationAll(warehouse);
                        break;
                    case 0:
                        System.out.println("Ну как хотите:)");
                        break;
                    default:
                        System.out.println("Неверное значение. Надо от 0 до 6");
                        break;
                }
                System.out.println(dash);
            } else {
                System.out.println("Неверное значение. Надо от 0 до 6");
                select = -1;
            }
        } while (select != 0);
        context.close();
    }

    public static void DemonstrationBefore(Warehouse warehouse) {
        System.out.println("Демонстрация Before Advice");
        System.out.println(prefix + warehouse.getBeforeProducts() + ends);
        warehouse.AddToWarehouse(new Motherboard("Motherboard#10", 990000,3010));
        System.out.println(dash);
    }

    public static void DemonstrationAfterReturning(Warehouse warehouse) {
        System.out.println("Демонстрация AfterReturning Advice");
        System.out.println(prefix + warehouse.getAfterReturningProducts() + ends);
        System.out.println(dash);
    }

    public static void DemonstrationAfterThrowing(Warehouse warehouse) {
        try {
            System.out.println("Демонстрация AfterThrowing Advice");
            System.out.println(prefix + warehouse.getAfterThrowingProducts() + ends);
        } catch (Exception e) {
            System.out.println("Exception в Main: было поймано исключение" + e);
        }
        System.out.println(dash);
    }

    public static void DemonstrationAfterFinally(Warehouse warehouse) {
        try {
            System.out.println("Демонстрация AfterFinally Advice");

            System.out.println(dash);
            System.out.println("Демонстрация без исключений: ");
            System.out.println(prefix + warehouse.getAfterFinallyProducts(warehouse.getProductsSize() - 1) + ends);
            System.out.println(dash);

            System.out.println(dash);
            System.out.println("Демонстрация c исключением: ");
            System.out.println(prefix + warehouse.getAfterFinallyProducts(warehouse.getProductsSize()) + ends);
            System.out.println(dash);
        } catch (Exception e) {
            System.out.println("Exception в Main: было поймано исключение" + e);
        }
        System.out.println(dash);
    }

    public static void DemonstrationAround(Warehouse warehouse) {
        try {
            System.out.println("Демонстрация Around Advice");

            System.out.println(dash);
            System.out.println("Демонстрация без исключений: ");
            System.out.println(prefix + warehouse.getAroundProducts(0) + ends);
            System.out.println(dash);

            System.out.println(dash);
            System.out.println("Демонстрация c исключением: ");
            System.out.println(prefix + warehouse.getAroundProducts(warehouse.getProductsSize()) + ends);
            System.out.println(dash);
        } catch (Exception e) {
            System.out.println("Exception в Main: было поймано исключение" + e);
        }
        System.out.println(dash);
    }

    public static void DemonstrationAll(Warehouse warehouse) {
        System.out.println("Демонстрация All Advice");
        System.out.println(dash);
        DemonstrationBefore(warehouse);
        DemonstrationAfterReturning(warehouse);
        DemonstrationAfterThrowing(warehouse);
        DemonstrationAfterFinally(warehouse);
        DemonstrationAround(warehouse);
    }
}
