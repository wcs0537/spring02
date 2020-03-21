package config;

import org.springframework.context.annotation.*;

//@Configuration
@ComponentScan("com.asong")
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
