package laboratory_work.laboratory_oop_2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("dogBean")
@Scope("prototype")
public class Dog implements IPet {

    public Dog(){
        System.out.println("Dog bean was created");
    }

    @Override
    public void say() {
        System.out.println("гав");
    }

    @Override
    @PostConstruct
    public void init() {
        System.out.println("Class Dog: init method");
    }

    @Override
    @PreDestroy
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
