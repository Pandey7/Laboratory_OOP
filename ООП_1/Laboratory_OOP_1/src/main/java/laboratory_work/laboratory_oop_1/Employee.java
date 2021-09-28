package laboratory_work.laboratory_oop_1;

public class Employee {
    private IPet pet;
    private ICar car;
    private String name;
    private int age;

    public Employee() {}

    public void setCar(ICar car) {this.car = car;}
    public void setPet(IPet pet) {this.pet = pet;}
    public void setAge(int age) {this.age = age;}
    public void setName(String name) {this.name = name;}
    public ICar getCar() {return car;}
    public IPet getPet() {return pet;}
    public int getAge() {return age;}
    public String getName() {return name;}

    public void StartCar() {
        car.GetStarted();
    }

    public void callYourPet() {
        System.out.println("Hey!");
        pet.say();
    }
}
