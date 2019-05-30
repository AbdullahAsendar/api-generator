/**
 * 
 */
package net.asendar.apigenerator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author asendar
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface ApiId {

}