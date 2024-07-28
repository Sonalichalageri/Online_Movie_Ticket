package com.DEMO;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		boolean flag;
		while(true)
		{
			System.out.println("WELCOME TO ONLINE MOVIE TICKET BOOKING");
			
			System.out.println("1.Admin Login");
			System.out.println("2.Customer login");
			System.out.println("3. Exit");
			Scanner sc=new Scanner(System.in);
			
			int op=sc.nextInt();
			
			AdminLogin a=new AdminLogin();
			CustomerLogin c= new CustomerLogin();
			
			switch(op)
			{
			case 1:
			{
				a.main();
			}break;
			
			case 2:
			{
				c.login();
			}break;
			
			case 3:return;
			}
			
			
			
		}
	}

}
