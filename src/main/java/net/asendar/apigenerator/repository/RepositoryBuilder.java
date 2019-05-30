/**
 * 
 */
package net.asendar.apigenerator.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author asendar
 *
 */
@Component
public class RepositoryBuilder {

	@Autowired
	private EntityManager entityManager;

	public <T> SimpleJpaRepository<T, Object> getRepo(Class<T> clazz) {
		return new SimpleJpaRepository<>(clazz, entityManager);
	}

}
