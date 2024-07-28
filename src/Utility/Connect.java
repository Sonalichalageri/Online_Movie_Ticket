package Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	public static Connection getConnect()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","admin");
		} 
		catch(Exception e) {
			
			System.out.println(e);
		}
		//if(con!=null)
		//{
	//		System.out.println("connected0");
//		else
	//	{
		//	System.out.println("error");
		//}
		return con;
		
	}
	public static void main(String[] args) {
		getConnect();
	}
}
