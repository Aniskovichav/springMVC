package com.websystique.springmvc.model;

import com.websystique.springmvc.dao.OfficeDaoImpl;
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
	@Column(name="name_office", nullable=true)
	private String nameOffice;

	@NotEmpty
	@Column(name="address", nullable=false)
	private String address;

	@NotEmpty
	@Column(name="postal_code", nullable=false)
	private String postalCode;

	public static void main(String[] args) {
		Office office = new Office();
		office.setNameOffice("asda");
		office.setPostalCode("111111");
		office.setAddress("NY");
		OfficeDaoImpl dao = new OfficeDaoImpl();
		dao.save(office);
	}
}
