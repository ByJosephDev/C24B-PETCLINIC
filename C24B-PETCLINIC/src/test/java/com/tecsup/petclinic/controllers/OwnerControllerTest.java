package com.tecsup.petclinic.controllers;

import static org.hamcrest.CoreMatchers.is;


//import static org.hamcrest.Matchers.hasSize;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.entities.Owner;

@AutoConfigureMockMvc
@SpringBootTest
public class OwnerControllerTest {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(PetControllerTest.class);

	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetOwners() throws Exception {

		//int SIZE = 216;
		int ID_FIRST = 1;
		//int ID_LAST = 332;  

		this.mockMvc.perform(get("/owners"))
					.andExpect(status().isOk()) // HTTP 200
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
								    // ACTUAL      EXPECTED 
					//.andExpect(jsonPath("$", hasSize(SIZE)))
					.andExpect(jsonPath("$[0].id", is(ID_FIRST)));
					//.andExpect(jsonPath("$[212].id", is(ID_LAST)));
	}
	
	
	
		@Test
	    	public void testDeleteOwner() throws Exception {

		 	String FIRST_NAME="Jeff";
	        String LAST_NAME="Black";
	        String ADDRESS="1450 Oak Blvd.";
	        String CITY="Monona";
	        String TELEPHONE="6085555387'";
			
			Owner newOwner=new Owner( FIRST_NAME,LAST_NAME,ADDRESS,CITY,TELEPHONE);
			
			ResultActions mvcActions = mockMvc.perform(post("/Owners")
		            .content(om.writeValueAsString(newOwner))
		            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		            .andDo(print())
		            .andExpect(status().isCreated());
		            
			String response = mvcActions.andReturn().getResponse().getContentAsString();

			Integer id = JsonPath.parse(response).read("$.id");

	        mockMvc.perform(delete("/owners/" + id ))
	                 /*.andDo(print())*/
	                .andExpect(status().isOk());
	    }
	


	
}
