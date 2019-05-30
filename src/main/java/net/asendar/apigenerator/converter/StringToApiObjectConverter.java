/**
 * 
 */
package net.asendar.apigenerator.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import net.asendar.apigenerator.ApiProvider;
import net.asendar.apigenerator.object.ApiObject;

/**
 * @author asendar
 *
 */
@Component
public class StringToApiObjectConverter implements Converter<String, ApiObject> {

	@Autowired
	private ApiProvider apiProvider;

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public ApiObject convert(String source) {
		return apiProvider.get(source);
	}

}
