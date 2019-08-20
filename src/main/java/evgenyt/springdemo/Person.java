package evgenyt.springdemo;

public class Person {
    private String name;

    public Person() {name = "John Doe";}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Setter is necessary or servlet can't pass this field in controller
    public void setName(String name) {
        this.name = name;
    }
}
