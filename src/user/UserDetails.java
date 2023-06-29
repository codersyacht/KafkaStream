package user;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class UserDetails 
{
	
	private String name;
	private String contact;
	private String address;
	
	public UserDetails() 
	{
		name="Mohamed Amirul Azmi";
		contact="+91-9880040372";
		address="A310, Aakruthi Homes, Mahadevapura, Bangalore, KA 560048, IN";
	}
	
	public String toString()
	{
		return "User(" + name + ", " + contact + ", " + address + ")";
	}
	
	public void printValues()
	{
		System.out.println("Name: "+ name );
		System.out.println("Contact: "+ contact );
		System.out.println("Address: "+ address );
		
	}
	

}
