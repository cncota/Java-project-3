/*Claudia Cota ID:60341850

Renter class represents a renter object. Contains setters and getters for each attribute.*/

public class Renter{
	private int renterId = 0;
	private String firstName;
	private String lastName;
	
	public void setRenterId(int id){
		//Method sets renter ID.
		this.renterId = id;
	}
	
	public void setFirstName(String fName){
		//Method sets first name.
		this.firstName = fName;
	}
	
	public void setLastName(String LName){
		//Method set last name.
		this.lastName = LName;
	}
	
	public int getRenterId(){
		//Method returns renter ID.
		return this.renterId;
	}
	
	public String getFirstName(){
		//Method returns first name.
		return this.firstName;
	}
	
	public String getLastName(){
		//Method returns last name.
		return this.lastName;
	}

}
