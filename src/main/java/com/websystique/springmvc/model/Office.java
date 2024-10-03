package com.websystique.springmvc.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="APP_OFFICE")
public class Office implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="NAME_OFFICE", nullable=false)
	private String nameOffice;

	@NotEmpty
	@Column(name="ADDRESS", nullable=false)
	private String address;



	@NotEmpty
	@Column(name="EMAIL", nullable=false)
	private String email;

}
