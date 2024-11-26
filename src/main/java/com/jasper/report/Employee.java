package com.jasper.report;

import java.util.Objects;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Employee {
//	Integer id;
//	String name;
//	Double salary;
//}

//package com.jasper.report;
//
import java.util.Objects;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
public class Employee {
	@Override
	public int hashCode() {
		return Objects.hash(id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(salary, other.salary);
	}

	protected boolean canEqual(Object other) {
	    return other instanceof Employee;
	  }
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	private Integer id;
    public void setId(Integer id) {
		this.id = id;
	}
    
    public Integer getId() {
    	return this.id;
    }

	private String name;
    private Double salary;
    
    public Employee(Integer id, String name, Double salary) {
    	this.id = id;
    	this.name = name;
    	this.salary = salary;
    }
    
    public Employee() {
    	this.id = 999;
    	this.name = "George";
    	this.salary = 2.5;
    }
    
    public static void main(String[] argv) {
    	Employee e1 = new Employee();
    	Employee e2 = new Employee(1, "George", 2.5d);
    }
}
