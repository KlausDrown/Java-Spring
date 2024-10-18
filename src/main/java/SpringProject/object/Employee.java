package SpringProject.object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private int id;
    private String name;
    private String login;
    private String password;
    private String department_name;
    private int department_id;

    public Employee() {
    }

    public Employee(int id, String name, String login, String password, int department_id) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.department_id = department_id;
    }

    public Employee(String name, String login, String password, int department_id) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.department_id = department_id;
    }
}
