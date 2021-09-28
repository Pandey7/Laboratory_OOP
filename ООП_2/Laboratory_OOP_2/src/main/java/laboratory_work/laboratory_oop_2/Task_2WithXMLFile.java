package laboratory_work.laboratory_oop_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task_2WithXMLFile {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

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
