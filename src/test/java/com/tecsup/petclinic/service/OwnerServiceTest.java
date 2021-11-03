package com.tecsup.petclinic.service;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.domain.Pet;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;

@SpringBootTest
public class OwnerServiceTest{
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);	
	@Autowired
	private OwnerService ownerService;
	
	/**
	 * 
	 */
	
	@Test
	public void testFindByFirstname() {
		String FIND_NAME = "Harold";
		int SIZE_EXPECTED = 1;
		List<Owner> own = ownerService.findByFirstname(FIND_NAME);

		assertThat(SIZE_EXPECTED, is(own.size()));
	}
	
}
