package laboratory_work.laboratory_oop_2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("carBean")
@Scope("prototype")
public class Car implements IVehicle{

    public Car(){
        System.out.println("Car bean was created");
    }

    @Override
    public void GetStarted() {
        System.out.println("г-р-р-р-р");
    }

    @Override
    @PostConstruct
    public void init() {
        System.out.println("Class Car: init method");
    }

    @Override
    @PreDestroy
    public void destroy() {
        System.out.println("Class Car: destroy method");
    }
}
