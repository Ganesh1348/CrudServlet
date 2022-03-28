package com.dbConnection;

import com.model.AddServletModel;
import java.sql.*;

public class infoDbHandler {
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javad1","root","@54321");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		//System.out.println("success");
		return con;
	}
	
	public static int AddEmp(AddServletModel e){  
        int status=0;  
        try{  
            Connection con=infoDbHandler.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into userdetails(PersonID,FirstName,Gmail,City) values(?,?,?,?)");  
             
             ps.setInt(1, e.getInfoId());
             ps.setString(2, e.getName());
             ps.setString(3, e.getGmail());
             ps.setString(4, e.getCity());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  

}
