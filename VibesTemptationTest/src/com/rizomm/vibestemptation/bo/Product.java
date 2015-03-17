package com.rizomm.vibestemptation.bo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


public class Product implements Serializable, Comparable<Product> {
	private static final long serialVersionUID = -4773729125526258175L;

	private int id;
	private String label;
	private String description;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String label, String description, int id) {
		this.setLabel(label);
		this.setDescription(description);
		this.setId(id);
	}
	
	public Product(String label, String description) {
		this.setLabel(label);
		this.setDescription(description);
	}
	
	public Product(String label) {
		this.setLabel(label);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int compareTo(Product arg0) {
		// TODO Auto-generated method stub
		return id - arg0.getId();
	}
}
