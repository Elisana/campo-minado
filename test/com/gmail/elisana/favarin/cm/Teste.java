package com.gmail.elisana.favarin.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test //Essa nota��o identifica que o esse m�todo � um de testes.
	void testarSeIgualADois() {
		
		int a = 1 + 1;
		
		assertEquals(2, a);		
	}
	
	@Test 
	void testarSeIgualATres() {
		int x = 2 + 10 - 9;
		assertEquals(3, x);
	}

}
