package com.springrest.springrest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  //spins the controller test
class SpringrestApplicationTests {

	Calculator c = new Calculator();
	
	@BeforeAll
	static void setUpAll() {
		System.out.println("Before all the test cases");
	}
	
	@BeforeEach  //before each test case
	void setUp() {  //tearup
		System.out.println("Before each test case");
	}
	
	@Test   //this annotation is used to specify the given method to be a test code/case
	void contextLoads() {
		System.out.println("calling context load method");
	}
	
	@Test
	void testDoSum() {   //actualresult  expectedresult
		int expectedResult = 20;  //my result
		int actualResult = c.doSum(14,3,3);        //doSum() method result
		assertThat(actualResult).isEqualTo(expectedResult);
		System.out.println("calling sum method");
	}
	
	@Test
	void testDoProduct() {
		int expectedResult = 9;
		int actualResult = c.doProduct(3,3);        //doProduct() method result
		assertThat(actualResult).isEqualTo(expectedResult);
		System.out.println("calling product method");
	}
	
	@Test
	void testCompareNumbers() {
		Boolean actualResult = c.comparingTwoNumbers(4, 4);
		assertThat(actualResult).isTrue();
		System.out.println("calling compare method");
	}
	

	@Test
	void testCalculatorCreation() {
		Calculator calc = new Calculator();
		assertNotNull(calc);
	}
	
	@AfterEach   //after each test case
	void tear() {  //teardown
		System.out.println("After each test case");
	}
	
	
	@AfterAll
	static void tearAll() {
		System.out.println("After all the test cases");
	}
	
}
