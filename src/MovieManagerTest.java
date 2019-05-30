/*Claudia Cota ID:60341850

MovieManagerTest class represents the JUnits testing assertions. It tests the finish program and asserts that it returns what 
its suppose to return.*/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MovieManagerTest{
	private Movie[] movies; 
	private Renter[] renters;
	private Movie m;
	private Renter r;
	
	@Before
	public void excuteBeforeEachTest(){
		movies = new Movie[20];
		renters = new Renter[10];
		m = new Movie();
		r = new Renter();
		
	}
	
	@Test
	public void movieCodeSetTest(){
		movies[0].setMovieCode("HP");
		movies[1].setMovieCode("HP2");
		movies[2].setMovieCode("HP3");
		movies[3].setMovieCode("HP4");
		
		assertEquals(movies[0].getMovieCode(), "HP");
		assertEquals(movies[1].getMovieCode(), "HP2");
		assertEquals(movies[2].getMovieCode(), "HP3");
		assertEquals(movies[3].getMovieCode(), "HP4");
	}
	
	@Test
	public void movieNameSetTest(){
		movies[1].setMovieName("Harry Potter");
		movies[2].setMovieName("Harry Potter 2");
		movies[3].setMovieName("Harry Potter 3");
		movies[4].setMovieName("Harry Potter 4");
		
		assertEquals(movies[1].getMovieName(), "Harry Potter");
		assertEquals(movies[2].getMovieName(), "Harry Potter 2");
		assertEquals(movies[3].getMovieName(), "Harry Potter 3");
		assertEquals(movies[4].getMovieName(), "Harry Potter 4");
	}
	
	@Test
	public void renterNameSetTest(){
		renters[0].setFirstName("Claudia");
		renters[1].setFirstName("Carlos");
		renters[2].setFirstName("Jim");
		renters[3].setFirstName("Pam");
		
		System.out.println(renters[0].getFirstName());
		assertEquals(renters[0].getFirstName().toString(), "Claudia");
		assertEquals(renters[1].getFirstName(), "Carlos");
		assertEquals(renters[2].getFirstName(), "Jim");
		assertEquals(renters[3].getFirstName(), "Pam");
	}
	
	@Test
	public void movieavailablecopiestest(){
		
		assertEquals(m.getCountOfCopies(), 10);
	}
	
	
	
}
