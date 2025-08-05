package com.ps.junittesting;

import org.junit.jupiter.api.*;

public class CalculatorServiceTests {


    //execute the logic before all test cases
    @BeforeAll
    public static void init(){
        System.out.println("Before all test cases logic");
    }

    //execute the logic after all test cases
    @AfterAll
    public static void cleanUp(){
        System.out.println("After all test cases logic");
    }

    //execute the logic before each test cases
    @BeforeEach
    public void beforeEachTestCase(){
        System.out.println("Before each test case");
    }

    //execute the logic after each test cases
    @AfterEach
    public void afterEachTestCase(){
        System.out.println("After each test case");
    }

    @Test
    @DisplayName("This is Custome Name")
    public void addTwoNumbersTest() {
        System.out.println("First Test Case");
        int actualResult = CalculatorService.addTwoNumbers(12, 13);
        int expectedResult = 25;
        Assertions.assertEquals(expectedResult, actualResult, "Test Fail");
    }

    @Test
    @Disabled
    public void sumAnyNumbersTest(){
        System.out.println("Second Test Case");
        int result = CalculatorService.sumAnyNumbers(2, 7, 8, 9);
        int expectedResult = 26;
        Assertions.assertEquals(expectedResult, result);
    }
}
