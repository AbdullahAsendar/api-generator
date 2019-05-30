/**
 * 
 */
package net.asendar.apigenerator.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author asendar
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface ApiEnabled {

	String name() default "";

}
