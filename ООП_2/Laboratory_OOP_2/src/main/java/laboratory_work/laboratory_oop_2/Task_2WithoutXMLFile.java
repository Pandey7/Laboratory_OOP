package laboratory_work.laboratory_oop_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task_2WithoutXMLFile {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Employee employee = context.getBean("employeeBean", Employee.class);
        employee.callYourPet();
        employee.StartVehicle();
        System.out.println(employee.getName());
        System.out.println(employee.getAge());

        Employee employee1 = context.getBean("employeeBean", Employee.class);
        employee1.setName("VL");
        employee1.setAge(50);
        employee1.callYourPet();
        employee1.StartVehicle();
        System.out.println(employee1.getName());
        System.out.println(employee1.getAge());

        context.close();
    }
}
