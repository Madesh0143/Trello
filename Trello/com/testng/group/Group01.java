package com.testng.group;

import org.testng.annotations.Test;

public class Group01 
{
	@Test(groups = "functional")
	public void login() 
	{
		System.out.println("Login Page");
	}
	
	@Test(groups = "integration")
	public void profile() 
	{
		System.out.println("Profile Page");
	}
	
	@Test(groups = "functional")
	public void home() 
	{
		System.out.println("Home Page");	
	}
	
	@Test(groups = "aadhoc")
	public void product() 
	{
		System.out.println("Product Page");	
	}

}
