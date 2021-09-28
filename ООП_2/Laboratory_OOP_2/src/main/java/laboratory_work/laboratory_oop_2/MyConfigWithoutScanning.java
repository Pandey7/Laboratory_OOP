package laboratory_work.laboratory_oop_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
public class MyConfigWithoutScanning {

    @Bean
    @Scope("prototype")
    public IPet dogBean(){
        return new Dog();
    }

    @Bean
    @Scope("prototype")
    public  IVehicle carBean(){
        return  new Car();
    }

    @Bean
    @Scope("prototype")
    public Employee employeeBean(){
        return new Employee(dogBean(), carBean());
    }
}
