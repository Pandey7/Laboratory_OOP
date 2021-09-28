package laboratory_work.laboratory_oop_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task_2 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Employee employee = context.getBean("myEmployee", Employee.class);
        employee.callYourPet();
        employee.StartCar();
        System.out.println(employee.getAge());
        System.out.println(employee.getName());

        context.close();
    }
}
