package helper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.Register;

public class Booking {

	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = (String)request.getSession(false).getAttribute("username");
		
		
		request.getSession().setAttribute("prevpage", "bookingDetail.jsp"); 
		System.out.println("aaa"+username);
		String[] booking = request.getParameter("booking").split(" ");
		request.getSession().setAttribute("bookingNum",booking[0]);
		request.getSession().setAttribute("modelName",booking[1]);

		if(username.equals("")||username == null){
			 response.sendRedirect("login.jsp");
			 System.out.println("aaa"+username);
		}
		else{
			response.sendRedirect("bookingDetail.jsp");
	
		}
		//sSystem.out.println(username);
	}

}
