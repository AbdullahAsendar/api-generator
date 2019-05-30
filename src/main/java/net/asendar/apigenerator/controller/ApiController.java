/**
 * 
 */
package net.asendar.apigenerator.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.asendar.apigenerator.object.ApiObject;

/**
 * @author asendar
 *
 */
@RestController
@RequestMapping("/{apiObject}")
public class ApiController extends AbstractRestController {

	@GetMapping
	public ResponseEntity<List<?>> getObjects(@PathVariable ApiObject apiObject) {
		return ResponseEntity.ok(repository.findAll(apiObject.getBaseClazz()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getObjects(@PathVariable ApiObject apiObject, @PathVariable String id) {
		return ResponseEntity.ok(repository.findById(apiObject.getBaseClazz(), apiObject.castId(id)));
	}

	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity<Object> postObject(@PathVariable ApiObject apiObject, @RequestBody Object payload) {
		Object instance = objectMapper.convertValue(payload, apiObject.getBaseClazz());
		return ResponseEntity.ok(repository.saveAndFlush(apiObject.getBaseClazz(), instance));
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/{id}")
	public ResponseEntity<Object> postObject(@PathVariable ApiObject apiObject, @PathVariable String id,
			@RequestBody Object payload) {

		Object instance = repository.findById(apiObject.getBaseClazz(), apiObject.castId(id)).orElseThrow();
		BeanUtils.copyProperties(objectMapper.convertValue(payload, apiObject.getBaseClazz()), instance);
		return ResponseEntity.ok(repository.saveAndFlush(apiObject.getBaseClazz(), instance));
	}

}
