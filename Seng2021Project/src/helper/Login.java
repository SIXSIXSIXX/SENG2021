package helper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.UserBean;
import users.LoginCheck;

public class Login {

	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String countType = request.getParameter("countType");
		HttpSession session = request.getSession(false);  
		System.out.println("aaadfasfawew");
		String page = null;
		if (session != null) {  
		    page = (String) session.getAttribute("prevpage");  
		}
		if(username == "" || password == "" || countType == "")	request.getRequestDispatcher("login.jsp").forward(request, response);
		
		UserBean userInfo = LoginCheck.check(username, password);
		if(userInfo!=null){
			setSession(username,request,userInfo);
			

			request.getRequestDispatcher(page).forward(request, response);
		}
		else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
		

		

	private static void setSession(String username, HttpServletRequest request, UserBean bean) {
		//Cookie[] cookies = 
		//for(Cookie cookie : cookies){
			//if
		//}
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("userInfo", bean);
	}

}
