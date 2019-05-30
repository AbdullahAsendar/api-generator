/**
 * 
 */
package net.asendar.apigenerator.object;

import java.lang.reflect.Field;
import java.math.BigInteger;

import com.google.common.collect.Lists;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.asendar.apigenerator.annotation.ApiId;

/**
 * @author asendar
 *
 */
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiObject {

	@SuppressWarnings("rawtypes")
	private Class baseClazz;
	private Class<?> primaryKeyClazz;

	@Builder
	private ApiObject(Class<?> clazz) {
		this.baseClazz = clazz;
		this.primaryKeyClazz = Lists.newArrayList(this.baseClazz.getDeclaredFields())//
				.stream()//
				.filter(f -> f.isAnnotationPresent(ApiId.class))//
				.findFirst()//
				.map(Field::getType)//
				.orElse(null);
	}

	public Object castId(String id) {

		if (primaryKeyClazz.equals(Long.class))
			return Long.valueOf(id);

		if (primaryKeyClazz.equals(Integer.class))
			return Integer.valueOf(id);

		if (primaryKeyClazz.equals(Double.class))
			return Double.valueOf(id);

		if (primaryKeyClazz.equals(BigInteger.class))
			return new BigInteger(id);

		return primaryKeyClazz.cast(id);

	}

}
