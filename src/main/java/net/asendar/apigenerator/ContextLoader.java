/**
 * 
 */
package net.asendar.apigenerator;

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScanPackages;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.google.common.collect.Iterables;

import net.asendar.apigenerator.annotation.ApiEnabled;
import net.asendar.apigenerator.object.ApiObject;

/**
 * @author asendar
 *
 */
@Component
public class ContextLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContextLoader.class);
	
	@Autowired
	private ApiProvider apiProvider;
	
	@Autowired
	private EntityScanPackages entityScanPackages;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		LOGGER.info("================================================");
		LOGGER.info("Scan api enabled Entities");
		LOGGER.info("================================================");

		Reflections reflections = new Reflections(new ConfigurationBuilder().forPackages(Iterables.toArray(entityScanPackages.getPackageNames(), String.class)));
		apiProvider.addAll(reflections.getTypesAnnotatedWith(ApiEnabled.class));

		apiProvider.getAll()//
				.stream()//
				.map(ApiObject::getBaseClazz)//
				.map(Class::getName)//
				.forEach(LOGGER::info);
	}

}
