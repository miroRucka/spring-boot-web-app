package sk.mirorucka.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author rucka
 */
@Configuration
@ComponentScan(value = {"sk.mirorucka.service", "sk.mirorucka.domain"})
@ImportResource("classpath:static.xml")
public class SpringConfigurationTest {

}
