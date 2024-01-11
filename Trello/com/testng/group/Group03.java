package com.testng.group;

import org.testng.annotations.Test;

public class Group03 
{
	
	@Test(groups = "aadhoc")
	public void search_box() 
	{
		System.out.println("search box");
	}
	
	@Test(groups = "smoke")
	public void profile_status() 
	{
	  System.out.println("profile status");	
	}
	
	@Test(groups = "system")
	public void profile_view() 
	{
		System.out.println("profile viewed");
	}
	
	@Test(groups = "functional")
	public void logout() 
	{
		System.out.println("logout");
	}

}
