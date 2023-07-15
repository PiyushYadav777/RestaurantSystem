package com.Restaurant.POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@NamedQuery(name = "Category.getAllCategory", query="select c from Category c where c.id in (select p.category from Product p where p.status='true')")

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="category")
public class Category implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	 private String name;
	 
	 
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

public Category() {
}
	public Category(Integer id, String name) {
	
		this.id = id;
		this.name = name;
	}
	
}
