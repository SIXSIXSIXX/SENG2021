package helper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.Register;

public class createNewAccount {

	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phone");
		Register.RegisterPublicInfo(username, password, phonenumber, address);
		HttpSession session = request.getSession(false);
		String page = null;
		if (session != null) {  
		    page = (String) session.getAttribute("prevpage");
		    request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
