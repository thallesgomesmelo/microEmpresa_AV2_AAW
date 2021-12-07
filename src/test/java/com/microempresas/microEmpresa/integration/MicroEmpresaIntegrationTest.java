package com.microempresas.microEmpresa.integration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.microempresas.microEmpresa.controller.MicroEmpresaController;
import com.microempresas.microEmpresa.entity.MicroEmpresa;
import com.microempresas.microEmpresa.service.MicroEmpresaService;

@WebMvcTest(MicroEmpresaController.class)
public class MicroEmpresaIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MicroEmpresaService microEmpresaService;
	
	@Test
	void test_create_returnOK() {
		var empresa = new MicroEmpresa();
		
		Mockito.when(microEmpresaService.create(empresa)).thenReturn(empresa);		
	}
	
	@Test
	void test_getById_shouldReturnOk() throws Exception {
		var id = "0001";
		
		Mockito.when(microEmpresaService.get(id)).thenReturn(new MicroEmpresa());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/microempresas/" + id))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(microEmpresaService).get(id);
	}
}
