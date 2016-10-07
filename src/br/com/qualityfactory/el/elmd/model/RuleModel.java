package br.com.qualityfactory.el.elmd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.qualityfactory.el.elmd.defaultfc.Model;
import lombok.Data;

@Data
@Entity(name = "rule")
public class RuleModel implements Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(nullable = false, unique = true)
	private String code;
  
  @Column(nullable = false, unique = true)
	private String name;
	
	@Column(name = "val", nullable = false, unique = true)
	private String value;
}
