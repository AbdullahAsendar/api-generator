/**
 * 
 */
package net.asendar.apigenerator.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author asendar
 *
 */
@Component
public class GenericJpaRepository {

	@Autowired
	private RepositoryBuilder repoBuilder;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> SimpleJpaRepository<T, Object> getRepo(Class clazz) {
		return repoBuilder.getRepo(clazz);
	}

	public List<Object> findAll(@SuppressWarnings("rawtypes") Class clazz) {
		return getRepo(clazz).findAll();
	}

	public Optional<Object> findById(@SuppressWarnings("rawtypes") Class clazz, Object id) {
		return getRepo(clazz).findById(id);
	}

	@Transactional
	public Object saveAndFlush(@SuppressWarnings("rawtypes") Class clazz, Object entity) {
		return getRepo(clazz).saveAndFlush(entity);
	}

}
