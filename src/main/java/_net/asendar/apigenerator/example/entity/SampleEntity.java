/**
 * 
 */
package _net.asendar.apigenerator.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import net.asendar.apigenerator.annotation.ApiEnabled;
import net.asendar.apigenerator.annotation.ApiId;

/**
 * @author asendar
 *
 */
@Setter
@Getter
@Entity
@Table(name = "test")

@ApiEnabled(name = "test")
public class SampleEntity {

	@Id
	@ApiId
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;
}
