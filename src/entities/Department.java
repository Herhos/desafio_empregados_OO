package entities;

import java.util.ArrayList;
import java.util.List;

public class Department
{
	private String name;
	private Integer payDay;
	
	private Address addresses;
	private List<Employee> employees = new ArrayList<>();
	
	public Department()
	{
		super();
	}

	public Department(String name, Integer payDay, Address addresses)
	{
		super();
		this.name = name;
		this.payDay = payDay;
		this.addresses = addresses;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getPayDay()
	{
		return payDay;
	}

	public void setPayDay(Integer payDay)
	{
		this.payDay = payDay;
	}

	public Address getAddresses()
	{
		return addresses;
	}

	public void setAddresses(Address addresses)
	{
		this.addresses = addresses;
	}
	
	public void addEmployee(Employee employee)
	{
		employees.add(employee);
	}
	
	public void removeEmployee(Employee employee)
	{
		employees.remove(employee);
	}
	
	public double payroll()
	{
		double sum = 0.00;
		for(Employee e : employees)
		{
			sum = sum + e.getSalary();
		}
		return sum;
	}	
	
	@Override
	public String toString()
	{
		StringBuilder sbd = new StringBuilder();
		for(Employee e : employees)
		{
			sbd.append(e.getName().toString() + "\n");			
		}
		return sbd.toString();
	}
}
