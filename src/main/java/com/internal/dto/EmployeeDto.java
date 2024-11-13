package com.internal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class EmployeeDto {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private Long departmentId;
	public EmployeeDto(long id, String firstName, String lastName, String email, Long departmentId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.departmentId = departmentId;
	}
	public EmployeeDto() {
		super();
	}

	
	
	

}
