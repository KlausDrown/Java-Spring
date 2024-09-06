package SpringProject;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("nameBean")
public class NameBean {
    @Value("${nameBean.name}")
    public String name;
    @Value("${nameBean.age}")
    private int age;
}
