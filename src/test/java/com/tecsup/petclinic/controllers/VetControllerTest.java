package com.tecsup.petclinic.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



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
import com.tecsup.petclinic.dto.VetDTO;


@AutoConfigureMockMvc
@SpringBootTest
public class VetControllerTest {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(VetControllerTest.class);

	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	


		
	/**
	 * @throws Exception
	 */
	
	@Test
    public void testCreateVet() throws Exception {
		
    	String FIRST_NAME_VET = "RenatoY";
    	String LAST_NAME_VET = "PongoY";
		
		VetDTO newVet = new VetDTO(FIRST_NAME_VET, LAST_NAME_VET);
	    
		logger.info(newVet.toString());
		logger.info(om.writeValueAsString(newVet));
	    
	    mockMvc.perform(post("/vets")
	            .content(om.writeValueAsString(newVet))
	            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isCreated())
	            .andExpect(jsonPath("$.firstName", is(FIRST_NAME_VET)))
	            .andExpect(jsonPath("$.lastName", is(LAST_NAME_VET)))
	            ;
    
	}
    

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testDeleteVet() throws Exception {

    	String FIRST_NAME_VET = "Renato3";
    	String LAST_NAME_VET = "Pongo3";
		
    	VetDTO newVet = new VetDTO(FIRST_NAME_VET, LAST_NAME_VET);
		
		ResultActions mvcActions = mockMvc.perform(post("/vets")
	            .content(om.writeValueAsString(newVet))
	            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isCreated());
	            
		String response = mvcActions.andReturn().getResponse().getContentAsString();

		Integer id = JsonPath.parse(response).read("$.id");

        mockMvc.perform(delete("/vets/" + id ))
                 /*.andDo(print())*/
                .andExpect(status().isOk());
    }
}
