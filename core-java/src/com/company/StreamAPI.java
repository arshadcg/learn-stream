package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
	
	public static void main(String[] args) {
		// creating objects of Employee class
		//int id, String firstName, String lastName, String dept, String gender, String location,double salary
	
		List<Employee> empList=new ArrayList<>();
		
		empList.add(new Employee(1, "arshad", "shaik", "development", "M","hyderabad" ,55000 ));
		empList.add(new Employee(2, "azeez", "shaik", "development", "M", "hyderabad", 68000));
		empList.add(new Employee(3, "phayaz", "syed", "testing", "M", "chennai", 35000));
		empList.add(new Employee(4, "sulaiman", "shaik", "cyberSecurity", "M", "hyderabad", 45000));
		empList.add(new Employee(5, "althaff", "shaik", "testing", "M", "chennai", 46000));
		empList.add(new Employee(6, "azeem", "shaik", "testing", "M", "banglore", 75000));
		empList.add(new Employee(7, "faheem", "shaik", "analyst", "M", "banglore", 60000));
		empList.add(new Employee(8, "ali", "shaik", "testing", "M", "hyderabad", 45000));
		empList.add(new Employee(9, "sultana", "shaik", "analyst", "F", "hyderabad", 38000));
		empList.add(new Employee(10, "Raheema", "shaik", "hr", "F", "banglore", 25000));
		empList.add(new Employee(11, "Shabnam", "shaik", "hr", "F", "delhi", 66000));
		empList.add(new Employee(12, "Priya", "R", "hr", "F", "banglore", 39000));
		empList.add(new Employee(13, "Rahul", "P", "cyberSecurity", "M", "hyderabad", 45000));
		empList.add(new Employee(14, "Yeswanth", "chatla", "support", "M", "chennai", 31000));
		empList.add(new Employee(15, "tejaswi", "challa", "support", "F", "banglore", 43500));
		empList.add(new Employee(16, "Ramya", "m", "development", "F", "hyderabad", 89000));
		empList.add(new Employee(17, "Ravi", "Reddy", "testing", "M", "delhi", 45000));
		empList.add(new Employee(18, "Faheem", "shaik", "cyberSecurity", "M", "hyderabad", 41500));
		empList.add(new Employee(19, "ali", "pathan", "testing", "M", "hyderabad", 39000));
		empList.add(new Employee(20, "Ramu", "P", "analyst", "M", "hyderabad", 36000));
		empList.add(new Employee(21, "Alex", "P", "development", "M", "hyderabad", 65000));
		empList.add(new Employee(22, "Lalwani", "M", "testing", "M", "hyderabad", 33000));
		
				// 1 : How many male and female employees are there in the organization?
				System.out.println("Solution-1: "+ empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting() )));
			
				// 2 : Print the name of all departments in the organization?
				System.out.println("Solution-2: "+empList.stream().map(Employee::getDept).distinct().sorted().collect(Collectors.toList()));
				
				//  3 : What is the average salary of male and female employees?
				System.out.println("Solution-3: "+ empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary))) );
				
				//  4 : Get the details of highest paid employee in the organization?
				System.out.println("Solution-4: "+empList.stream().max(Comparator.comparing(Employee::getSalary)));
				
				//  5 : Get the names of all employees who have salary grater than 50000?
				System.out.println("Solution-5: " +empList.stream().filter(o->o.getSalary()>=50000).collect(Collectors.toList()));
				List<Employee> above50= empList.stream().filter(e->e.getSalary()>50000).collect(Collectors.toList());
				//above50.stream().forEach(System.out::println);
				
				//  6 : Count the number of employees in each department?
				System.out.println("Solution-6: "+empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting())));
				
				//  7 : What is the average salary of each department?
				System.out.println("Solution-7: "+ empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary))));
				
				//  8 : Get the details of Highest salary male employee in the product
				System.out.println("Solution-8: " +empList.stream().filter(e->e.getGender().equalsIgnoreCase("M")).max(Comparator.comparing(Employee::getSalary)));
				// development department?
				
				//  9 : 
				
				//  10 : How many male and female employees are there
				System.out.println("Solution-10: "+ empList.stream()
						.filter(e->e.getDept().equalsIgnoreCase("development")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));
				
				//  11 : What is the average salary of male and female employees?
				
				//  12 : List down the names of all employees in each department?
				System.out.println("Solution-12: "+ empList.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.mapping(e->String.join(" ", e.getFirstName(), e.getLastName()), Collectors.toList()))));
				
				//  13 : What is the average salary and total salary of the whole
				
				System.out.println("Solution-13: "+ empList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.summingDouble(Employee::getSalary))));
				
				// groupby dept and show id, salary
				System.out.println("Grouby dept and show id, salary"+ empList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.toMap(Employee::getId, Employee::getSalary))));
				
				
				//developers in hyd
				
				System.out.println(empList.stream().filter(e->e.getDept().equalsIgnoreCase("development")).filter(e->e.getLocation().equalsIgnoreCase("hyderabad")).collect(Collectors.toList()));
				
				
				//location wise category count
				
				System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getLocation, Collectors.groupingBy(Employee::getDept, Collectors.summingDouble(Employee::getSalary)))));
				
				// increment development salary by 10% 
				List<Employee> hikeSalaryDevelopmentTen= empList.stream().filter(e->e.getDept().equalsIgnoreCase("development")).collect(Collectors.toList());
				
				//print development team salaries
				System.out.println(empList.stream().filter(e->e.getDept().equalsIgnoreCase("development")).map(e->e.getSalary()).collect(Collectors.toList()));
				for(Employee hike: hikeSalaryDevelopmentTen)
				{
					double oldCtc = hike.getSalary();
					double newCtc = oldCtc*1.10;
					hike.setSalary(newCtc);
				}
				System.out.println(empList.stream().filter(e->e.getDept().equalsIgnoreCase("development")).map(e->e.getSalary()).collect(Collectors.toList()));
				
				// git from arshad/stream1 branch
				
				// filter entry of least salary
				
				System.out.println(empList.stream().min(Comparator.comparing(Employee::getSalary)));
				
				
				
		
		
		
		
		
		
		
	}

}


class Employee
{
	int id;
	String firstName;
	String lastName;
	String dept;
	String gender;
	String location;
	double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(int id, String firstName, String lastName, String dept, String gender, String location,
			double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.gender = gender;
		this.location = location;
		this.salary = salary;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept
				+ ", gender=" + gender + ", location=" + location + ", salary=" + salary + "]";
	}
	
	
	
}