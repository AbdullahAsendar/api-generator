/**
 * 
 */
package _net.asendar.apigenerator.example;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author asendar
 *
 */
@ComponentScan({ "_net.asendar", "net.asendar" })
@EntityScan("_net.asendar.apigenerator.example")
@Configuration
public class SpringConfig {

}
