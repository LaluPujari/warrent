package com.ecom.TestNgpractice;

import java.lang.reflect.Array;

import org.testng.annotations.Test;

public class TestNgTest {

	@Test(enabled=false,invocationCount=-1,priority=-1)
	public void create() {
		
		System.out.println(" account created");
		
	}
	@Test
	public void update() {
	
		
		System.out.println("account updated ");
	}
	@Test(invocationCount=2, dependsOnMethods="create")
	
	public void delet() {
		System.out.println("account deleted");
	}
	
}
