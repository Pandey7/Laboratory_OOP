package laboratory_work.laboratory_oop_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("employeeBean")
@Scope("prototype")
public class Employee {

    private IPet pet;
    private IVehicle vehicle;

    @Value("${employee.name}")
    private String name;

    @Value("${employee.age}")
    private int age;

    @Autowired
    public Employee(@Qualifier("dogBean") IPet pet,
                    @Qualifier("carBean") IVehicle vehicle) {
        this.pet=pet;
        this.vehicle=vehicle;
        System.out.println("Employee bean was created");
    }

    @PostConstruct
    public void init(){
        System.out.println("Class Employee: init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Class Employee: destroy method");
    }

//    @Autowired
//    @Qualifier("carBean")
    public void setVehicle(IVehicle vehicle) {
        this.vehicle = vehicle;
        System.out.println("Class Employee: set Vehicle");
    }

//    @Autowired
//    @Qualifier("dogBean")
    public void setPet(IPet pet) {
        this.pet = pet;
        System.out.println("Class Employee: set Pet");
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("Class Employee: set Age");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Class Employee: set Name");
    }

    public IVehicle getVehicle() {return vehicle;}
    public IPet getPet() {return pet;}
    public int getAge() {return age;}
    public String getName() {return name;}

    public void StartVehicle() {
        vehicle.GetStarted();
    }

    public void callYourPet() {
        System.out.println("Hey!");
        pet.say();
    }
}
