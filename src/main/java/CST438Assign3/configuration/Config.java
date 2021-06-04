package CST438Assign3.configuration;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public FanoutExchange fanout() { 
        return new FanoutExchange("city-reservation");
    }
}
