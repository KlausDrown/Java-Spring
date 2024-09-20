package SpringProject.dao;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpeObject {
    private int id;
    private int age;
    private String name;

    public SimpeObject() {
    }

    public SimpeObject(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public SimpeObject(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

}
