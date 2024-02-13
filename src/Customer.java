
public class Customer 
{
	private String name; 
	private int age; 
	
	
	
	public Customer(String name, int age)
	{
		this.name = name; 
		this.age = age;
	}
	
	public Customer(Customer c) 
	{
        this.name = c.getName();
        this.age = c.getAge();
    }
	
	public String toString()
	{
		return name + age; 
	}
	
	
	
	public void setName(String n)
	{
		name = n; 
	}
	
	public void setAge(int a)
	{
		age = a; 
	}
	
	public String getName()
	{
		return name; 
	}
	
	public int getAge()
	{
		return age; 
	}
	
	
	
	
	
}
