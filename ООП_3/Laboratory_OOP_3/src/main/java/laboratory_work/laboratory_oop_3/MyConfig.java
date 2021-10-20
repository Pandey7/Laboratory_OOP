package laboratory_work.laboratory_oop_3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("laboratory_work.laboratory_oop_3")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class MyConfig {
}
