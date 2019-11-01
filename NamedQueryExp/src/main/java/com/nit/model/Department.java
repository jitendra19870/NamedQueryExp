package com.nit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
@NamedQuery(name="get_total_dept", query="select count(1) from Department")

@NamedQueries({
 @NamedQuery(name="getdeptnamebyid", query="select name from Department where id=:id"),
 @NamedQuery(name="getalldept", query="from Department")
})
public class Department {
	@Id
	@Column(name="DEPTID")
	private int id;
	@Column(name="NAME")
	private String name;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="department")
	private List<Employee> employee=new ArrayList<>();
	public Department() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employee=" + employee + "]";
	}
	

}
