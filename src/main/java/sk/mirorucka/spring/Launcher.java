package sk.mirorucka.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sk.mirorucka.service.CardService;

/**
 * @author rucka
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "sk.mirorucka", basePackageClasses = {CardService.class})
public class Launcher {

    public static void main(String[] args) throws Exception {
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        System.setProperty("server.port", webPort);
        SpringApplication.run(Launcher.class, args);
    }
}
