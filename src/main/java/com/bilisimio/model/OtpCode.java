package com.bilisimio.model;

import java.util.Date;

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
@Table(name = "OtpCodes")
public class OtpCode {

	@Id
	private Long id;
	@Column
	private Long userId;
	@Column
	private String code;
	@Column
	private Date createDate;
	@Column
	private Boolean isActive;

}
