package laboratory_work.laboratory_oop_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class LaboratoryOop1Application {

    public static void main(String[] args) {
        SpringApplication.run(LaboratoryOop1Application.class, args);
    }

    @GetMapping("/hello")
    public String Hello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }

    @GetMapping("/about")
    public String About() {
        return "about us";
    }

    @GetMapping("/options")
    public String Options(@RequestParam(value = "myOption", defaultValue = "") String option) {
        if (option.equals("")) {
            return "option";
        } else {
            return "not a option";
        }
    }
}
