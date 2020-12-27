package com.bilisimio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

	@Id
	private Long id;
	@Column
	private String name;
	@Column
	private String lastName;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String phone;

}
