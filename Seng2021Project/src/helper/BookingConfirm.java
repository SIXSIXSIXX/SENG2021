package helper;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.UserBean;
import booking.Request;
import booking.SendToDealers;


public class BookingConfirm {

	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String bookingTime = (String)request.getParameter("dt").replace("T", " ");
		String userName = (String)request.getParameter("Name");
		UserBean userInfo = (UserBean)request.getSession().getAttribute("userInfo");
		System.out.println("getType "+userInfo.getType());
		System.out.println("getPhone "+userInfo.getPhone());
		System.out.println("getAddress "+userInfo.getAddress());
		long a = Calendar.getInstance().getTimeInMillis();
		Request newRequest = new Request(userName,userInfo.getUserName(),userInfo.getPhone(),userInfo.getAddress(),(String)request.getSession().getAttribute("modelName"),
							(String)request.getSession().getAttribute("bookingNum"),bookingTime,String.valueOf(Calendar.getInstance().getTimeInMillis()),userInfo.getType(), 0.0);
		SendToDealers.send(SendToDealers.findDealers(newRequest),newRequest);
		request.getRequestDispatcher("bookingManagement.jsp").forward(request, response);
	}

}
