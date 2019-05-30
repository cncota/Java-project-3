/*Claudia Cota ID:60341850

MovieManager class represents the highest layer of managing the class roster containing an array of movies and the total number 
of current movies. It has all the methods that change and update the movie and renter arrays by using the user input commands.*/

public class MovieManager{
	private Movie[] movies = new Movie[20];
	private int totalNumOfMovies = 0;
	
	public void run(){
		//Method runs the main loop of the program. It displays menu, accepts user input, and handles each user command.
		boolean run = true;
		do{
			String command = null;
			MovieManagerUI.printMenu();
			command = MovieManagerUI.getCommand();
		
			if (command.equals("am")){
				String c = MovieManagerUI.getMovieInformationCode();
				String n = MovieManagerUI.getMovieInformationName();
				try {		
					Movie m = new Movie();
					m.setMovieCode(c);
					m.setMovieName(n);
					addMovie(m);
					continue;
				}
				
				catch (MovieLimitException e){
					System.out.println("ERROR: Movie limit has been reached. \n");	
				}
				catch (EmptyMovieInfoException e){
					System.out.println("ERROR: Movie name or code is empty.\n");	
				}
				catch (DuplicateMovieException e){
					System.out.println("ERROR: Duplicate code. \n");	
				}			
			}
			
			if (command.equals("dm")){
				//if (this.totalNumOfMovies == 0){
				//	System.out.print("ERROR: Movie list is empty.\n");
				//	continue;
				//}
				String c = MovieManagerUI.getMovieInformationCode();
				try {
					discontinueMovie(c);
					continue;	
				}
				catch (MovieNotFoundException e){
					System.out.println("ERROR: Movie code does not match any in inventory. \n");	
				}
				catch (EmptyMovieListException e){
					System.out.println("ERROR: Movie list is empty.\n");	
				}
				catch (RentedMovieException e){
					System.out.println("ERROR: Copies of movie still out for rental. \n");
					for (int i = 0; i <20; i++){
						if (movies[i].getMovieCode().equals(c)){
							Renter[] r = movies[i].getRenters();
							System.out.print("Renters: \n");
							for (int j = 0; j <10; j++){
								if (r[j] != null){
									System.out.print(" "+r[j].getFirstName() + " " + r[j].getLastName()+ "\n"); 
								}
							}
						}
					}
				}	
			}
			
			if (command.equals("rm")){
				String c = MovieManagerUI.getMovieInformationCode();
				int rId = MovieManagerUI.getRenterId();
				String f = MovieManagerUI.getRenterFirstName();
				String l = MovieManagerUI.getRenterLastName();
				if (rId <= 0){
					System.out.println("ERROR: Invalid Renter ID, must be positive interger greater than 0.");
					continue;
				}
				Renter r = new Renter();
				r.setFirstName(f);
				r.setLastName(l);
				r.setRenterId(rId);
				try {
					rentMovie(c, r);
					continue;	
				}
				
				catch (RenterLimitException e){
					System.out.println("ERROR: No available copies for this movie. \n");	
				}
				catch (DuplicateRenterException e){
					System.out.println("ERROR: Renter ID already exists.\n");	
				}
				catch (MovieNotFoundException e){
					System.out.println("ERROR: Movie code does not match any in inventory. \n");
				}
				catch (EmptyRenterNameException e){
					System.out.println("ERROR: Empty first and/or last name for renter. \n");
				}
			}
			
			if (command.equals("rr")){
				String c = MovieManagerUI.getMovieInformationCode();
				int rId = MovieManagerUI.getRenterId();
				if (rId <= 0){
					System.out.println("ERROR: Invalid Renter ID, must be positive interger greater than 0.");
					continue;
				}
				try {
					returnRental(rId, c);
					continue;	
				}
				
				catch (RenterNotFoundException e){
					System.out.println("ERROR: Renter not found. \n");	
				}
				catch (EmptyRenterListException e){
					System.out.println("ERROR: No copies currently being rented for that movie.\n");	
				}
				catch (MovieNotFoundException e){
					System.out.println("ERROR: Movie code does not match any in inventory. \n");
				}
				
			}
			
			if (command.equals("p")){
				printInventory();
			}
			
			if (command.equals("q")){
				break;
			}	
				
		}while (run == true);
		
	}
	
	public void addMovie(Movie m)throws MovieLimitException, EmptyMovieInfoException, DuplicateMovieException{
		//Method adds a movie to the array of movies.
		if (totalNumOfMovies == 20){
			throw new MovieLimitException();
		}
		if (m.getMovieCode().equals("") || m.getMovieName().equals("")){
			throw new EmptyMovieInfoException();
		}
		for (int i = 0; i <20; i++){
			if (movies[i] != null && movies[i].getMovieCode().equals(m.getMovieCode())){
				throw new DuplicateMovieException();
			}
		}
		for (int i = 0; i <20; i++){
			if (movies[i] == null){
				this.movies[i] = m;
				totalNumOfMovies++;
				break;
			}
		}
		
	}
	
	public void discontinueMovie(String movieCode)throws MovieNotFoundException,EmptyMovieListException, RentedMovieException{
		//Method removes a movie from the array of Movies.
		if (totalNumOfMovies == 0){
			throw new EmptyMovieListException();
		}
		int counter = 0;
		Renter[] ren = new Renter[10];
		for (int i = 0; i <20; i++){
			if (movies[i].getMovieCode().equals(movieCode)){
				counter++;
				ren = movies[i].getRenters();
			}
		}
		if (counter == 0){
			throw new MovieNotFoundException();
		}
		
		
		for (int j = 0; j <10; j++){
			if (ren[j] != null){
				throw new RentedMovieException(); 
			}
		}
		
		for (int i = 0; i <20; i++){
			if (movies[i].getMovieCode().equals(movieCode)){
				movies[i] = null;
				totalNumOfMovies--;
				break;
			}
		}
		
	}
	
	public void rentMovie(String movieCode, Renter s)throws RenterLimitException,DuplicateRenterException, MovieNotFoundException, EmptyRenterNameException{
		//Method adds a renter to an already existing movieCode.
		int counter = 0;
		if (s.getFirstName().equals("") || s.getLastName().equals("")){
			throw new EmptyRenterNameException();
		}
		for (int i = 0; i <20; i++){
			if (movies[i] != null && movies[i].getMovieCode().equals(movieCode)){
				counter++;
				Renter[] ren = movies[i].getRenters();
				for(int j = 0; j <10; j++){
					if (ren[j] != null && s.getRenterId() == ren[j].getRenterId()){
						throw new DuplicateRenterException();
					}
				}
				if (movies[i].getCountOfCopies() == 0){
					throw new RenterLimitException();
				}
			}
		}
		if (counter == 0){
			throw new MovieNotFoundException();
		}
		
		for (int i1 = 0; i1 <20; i1++){
			if (movies[i1].getMovieCode().equals(movieCode)){
				movies[i1].rentMovie(s);
				break;	
				}	
			}
		
	}
	
	public void returnRental(int enterId, String movieCode)throws RenterNotFoundException,EmptyRenterListException, MovieNotFoundException{
		//Method removes a renter from an already existing movieCode.
		int counter = 0;
		int rCounter = 0;
		for (int i = 0; i <20; i++){
			if (movies[i] != null && movies[i].getMovieCode().equals(movieCode)){
				counter++;
				Renter[] ren = movies[i].getRenters();
				if (movies[i].getCountOfCopies() == 10){
					throw new EmptyRenterListException();
				}
				for(int j = 0; j <10; j++){
					if (ren[j] != null && ren[j].getRenterId()== enterId){
						rCounter++;
					}
				}
			}
		}
		if (rCounter == 0){
			throw new RenterNotFoundException();
		}
		if (counter == 0){
			throw new MovieNotFoundException();
		}
				
		for (int i1 = 0; i1 <20; i1++){
			if (movies[i1] != null && movies[i1].getMovieCode().equals(movieCode)){
				Renter[] rens = movies[i1].getRenters();
				for(int j1 = 0; j1 <10; j1++){
					if (rens[j1] != null && rens[j1].getRenterId()== enterId){
						movies[i1].returnRental(enterId);
						break;
					}
				}	
			}
		}
		
		
	}
	
	public void printInventory(){
		//Method prints the information for all movies and their renters.
		String renterString = "Renters: \n";
		System.out.print("\n*********\nInventory of movies: \n");
		int counter = 0;
		for (int i = 0; i <20; i++){
			if (movies[i] != null){
				System.out.print("\n");
				counter++;
				Renter[] ren = movies[i].getRenters();
				System.out.print("Movie code: " + movies[i].getMovieCode()+ "\n"
					+ "Movie name: " + movies[i].getMovieName() + "\n"
					+ "Number of Copies that are rented: " + Integer.toString(10 - movies[i].getCountOfCopies()) + "\n");
				for(int j1 = 0; j1 <10; j1++){
					if (ren[j1] != null){
						renterString += " * ID: "+ren[j1].getRenterId() + ", Name: " + ren[j1].getFirstName() + " " + ren[j1].getLastName()+"\n";
					}
				}
				if (!renterString.equals("Renters: \n")){
					System.out.print(renterString);
					renterString = "Renters: \n";
				}
			}
		}
		
		if (counter == 0){
			System.out.print("**Empty Inventory**\n");
		}
		System.out.print("*********\n");
	}

}
