package SpringProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("SpringProject")
@PropertySource("classpath:nameBean.properties")
public class SpringConfig {

}
