package SpringProject.object;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class Department {

    private int id;
    @NotEmpty
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }
}
