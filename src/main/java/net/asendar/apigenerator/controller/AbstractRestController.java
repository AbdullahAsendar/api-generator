/**
 * 
 */
package net.asendar.apigenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.asendar.apigenerator.repository.GenericJpaRepository;

/**
 * @author asendar
 *
 */
public abstract class AbstractRestController {

	@Autowired
	protected GenericJpaRepository repository;

	protected ObjectMapper objectMapper = new ObjectMapper();

}
