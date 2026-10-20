package com.brhmkskn.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	@NotEmpty(message = "FirstName alanı boş bırakılamaz!")
	@Max(value = 15,message = "Bu alan 15 karekterden uzun olamaz")
	private String firstName;
	@Size(min = 3, max = 12,message = "Lastname 3 ile 12 karekter arasında olmalı.")
	private String lastName;
	private Date birthOfDate;
	@Email(message = "Lütfen geçerli bir email adresi giriniz.")
	private String email;
}
