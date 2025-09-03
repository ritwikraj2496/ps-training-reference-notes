package com.springrest.springrest.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@AllArgsConstructor   //parameterized constructor
//@NoArgsConstructor    //default constructor
//@Getter       //all the getters
//@Setter       //all the setters
//@ToString     //toString will be implemented

@Data
@Entity
@Table(name = "Course_Struc")  //table name
public class Course {
	@Id  //primary key
	@Column  //default
	private long id;
	@Column
	private String title;
	@Column
	private String description;
}
