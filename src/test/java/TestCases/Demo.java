package TestCases;

import org.testng.annotations.Test;

import BaseClassess.LoginBaseClass;


public class Demo extends LoginBaseClass{

	@Test
	public void test1()
	{
		logger.info("Test 1");
		System.out.println("Test 1");
	}
	
	@Test
	public void test4()
	{
		logger.info("Test 4");
		System.out.println("Test 4");
	}
	
	@Test
	public void test2()
	{
		logger.info("Test 2");
		System.out.println("Test 2");
	}
	
	@Test
	public void test3()
	{
		logger.info("Test ");
		System.out.println("Test ");
	}
}
