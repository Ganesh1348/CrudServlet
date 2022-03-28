package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dbConnection.infoDbHandler;
import com.model.AddServletModel;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	       
	    }

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		processRequest(request, response);
		 PrintWriter out=response.getWriter(); 
		 
		 int id=Integer. parseInt(request.getParameter("id"));
		 String name=request.getParameter("name");
		 String email=request.getParameter("email");
		 String city=request.getParameter("city");
		 
		 System.out.println(id);
		 System.out.println(name);
		 System.out.println(email);
		 System.out.println(city);
		 
		 AddServletModel e=new AddServletModel();
		 e.setInfoId(id);
		 e.setName(name);
		 e.setGmail(email);
		 e.setCity(city);
		 
		 int status=infoDbHandler.AddEmp(e);
		 if (status>0)
		 {
			 out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("index.html").include(request, response);
		 }
		 else {
			 out.print("<h1>Sorry! unable to save record</h1>");
		 }
	}
}
