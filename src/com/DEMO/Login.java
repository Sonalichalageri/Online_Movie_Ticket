package com.DEMO;

import java.util.Scanner;

import com.impl.CustomerDaoimpl;
import com.impl.LoginDaoimpl;
import com.pojo.Customer;

public class Login {

	public static void main(String[] args) {
		CustomerDaoimpl cd=new CustomerDaoimpl();
		LoginDaoimpl ld=new LoginDaoimpl();
		Scanner sc=new Scanner(System.in);
		 String custName;
		 long mobileNo;
		 String emailid;
		 String password;
		 boolean flag1;
		 boolean flag=true;
		 
		 while(flag) {
			 System.out.println("1.Register the user\n2.Login");
			 int op=sc.nextInt();
			 
			 switch(op)
			 {
			 case 1:
			 {
				 System.out.println("enter user name");
				 custName=sc.next();
				 
				 System.out.println("enter mobile number");
				 mobileNo=sc.nextLong();
				 
				 System.out.println("enter emailid ");
				 emailid=sc.next();
				 
				 System.out.println("enter Password");
				 password=sc.next();
				 
				  Customer c= new Customer(custName, mobileNo, emailid, password);
				  flag1=cd.addcustomer(c);
				  if(flag1)
				  {
					  System.out.println("succussfully Registred");
				  }else
				  {
					  System.out.println("please check details");
				  }
				  }break;
			 case 2:
			 {
				 System.out.println("enter your  emailid for login");
				 emailid=sc.next();
				 System.out.println("enter password for login");
				 password=sc.next();
				 flag1 =ld.userlogin(emailid, password);
				 if(flag1)
				 {
					 System.out.println("Logined succussfully");
					 
					 
				 }else
				 {
					 System.out.println("This email not registered");
				 }
				 
			 }break;
			 
				 
				 
			 }
		 }
		 
	}

}
