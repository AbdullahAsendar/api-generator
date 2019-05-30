/**
 * 
 */
package net.asendar.apigenerator;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.asendar.apigenerator.annotation.ApiEnabled;
import net.asendar.apigenerator.object.ApiObject;
import net.asendar.apigenerator.util.ApiGeneratorException;

/**
 * @author asendar
 *
 */
@Component
public class ApiProvider {

	private Map<String, ApiObject> clazzMap;

	@PostConstruct
	private void init() {
		clazzMap = Maps.newHashMap();
	}

	public void add(Class<?> clazz) {
		ApiEnabled annotation = clazz.getAnnotation(ApiEnabled.class);

		if (Objects.isNull(annotation))
			ApiGeneratorException.fail("CLass %s is not annotated with %s", clazz.getName(),
					ApiEnabled.class.getName());

		String key = Optional.ofNullable(annotation).map(ApiEnabled::name).orElse(null);

		if (StringUtils.isEmpty(key))
			key = clazz.getName();

		clazzMap.put(key, ApiObject.builder().clazz(clazz).build());
	}

	public void addAll(Collection<Class<?>> clazzes) {
		clazzes.forEach(this::add);
	}

	public Collection<ApiObject> getAll() {
		return Lists.newArrayList(clazzMap.values());
	}

	public ApiObject get(String key) {
		return clazzMap.get(key);
	}
}
