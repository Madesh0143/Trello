package com.testng.group;

import org.testng.annotations.Test;

public class Group02 
{
	@Test(groups = "smoke")
	public void admin() 
	{
		System.out.println("admin Page");
	}
	
	@Test(groups = "system")
	public void add_cart() 
	{
		System.out.println("Add To Cart");
	}
	
	@Test(groups = "functional")
	public void payment() 
	{
		System.out.println("PayMent page");
	}
	
	@Test(groups = "integration")
	public void googlepay() 
	{
		System.out.println("google pay");
	}

}
