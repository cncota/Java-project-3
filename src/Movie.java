/*

Movies class represents the a movie object. It contains all the methods that update the renting status and the 
setter and getter methods that change the attributes.*/

public class Movie{
	private String movieCode = "";
	private String movieName = "";
	private int countOfCopies = 10;
	private Renter[] renters = new Renter[10];
	
	public void rentMovie(Renter r)throws RenterLimitException, DuplicateRenterException{
		if (this.countOfCopies == 0){
			throw new RenterLimitException();
		}
		for (int i = 0; i <10; i++){
			if (renters[i] != null && this.renters[i].getRenterId() == r.getRenterId()){
				throw new DuplicateRenterException();
			}
		}
		
		for (int j = 0; j <10; j++){
			if (renters[j] == null){
				this.renters[j] = r;
				this.countOfCopies--;
				break;
			}
		}
	}
	
	public void returnRental(int renterId)throws EmptyRenterListException, RenterNotFoundException{
		int counter = 0;
		if (this.countOfCopies == 10){
			throw new EmptyRenterListException();
		}
		for (int i = 0; i <10; i++){
			if (this.renters[i].getRenterId() == renterId){
				counter++;
				this.renters[i] = null;
				this.countOfCopies++;
				break;
			}
		}
		if (counter == 0){
			throw new RenterNotFoundException();
		}
	}
	
	public void setMovieCode(String code){
		this.movieCode = code;
	}
	
	public void setMovieName(String name){
		this.movieName = name;
	}
	
	public int getCountOfCopies(){
		return this.countOfCopies;
	}
	
	public String getMovieCode(){
		return this.movieCode;
	}
	
	public String getMovieName(){
		return this.movieName;
	}
	
	public Renter[] getRenters(){
		return this.renters;
	}
}
