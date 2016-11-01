package br.com.qualityfactory.el.elmd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "rule")
public class Rule implements Model {
	
	private static final long serialVersionUID = 1L;
	
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
