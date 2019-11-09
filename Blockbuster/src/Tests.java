import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void testStatementEmpty() {
		Customer customer = new Customer("John Snow");

		assertEquals(customer.statement(),"Rental Record for John Snow\nAmount owed is 0.0\nYou earned 0 frequent renter points");
	}
	
	@Test
	void testStatementRentalOne() {
		Customer customer = new Customer("John Snow");

		Movie lotr1 = new Movie("Filme1", 1);
		
		Rental r1 = new Rental(lotr1, 1);
		customer.addRental(r1);

		assertEquals(customer.statement(),"Rental Record for John Snow\n	Filme1	3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points");		
	}
	
	@Test
	void testStatementRentalThree() {
		Customer customer = new Customer("John Snow");

		Movie lotr1 = new Movie("Filme1", 1);
		Movie lotr2 = new Movie("Filme2", 0);
		Movie lotr3 = new Movie("Filme3", 2);
		
		Rental r1 = new Rental(lotr1, 1);
		customer.addRental(r1);
		
		Rental r2 = new Rental(lotr2, 2);
		customer.addRental(r2);
		Rental r3 = new Rental(lotr3, 3);
		customer.addRental(r3);

		assertEquals(customer.statement(), "Rental Record for John Snow\n	Filme1	3.0\n	Filme2	2.0\n	Filme3	1.5\nAmount owed is 6.5\nYou earned 3 frequent renter points");	
	}
}
