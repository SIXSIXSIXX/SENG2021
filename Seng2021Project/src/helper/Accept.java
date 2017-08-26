package helper;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.UserBean;
import booking.Request;
import booking.SendToDealers;


public class Accept {

	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String fileName = (String)request.getParameter("accept");
		System.out.println("fileName "+fileName);
		UserBean userInfo = (UserBean)request.getSession().getAttribute("userInfo");
		System.out.println("getType "+userInfo.getType());
		System.out.println("getPhone "+userInfo.getPhone());
		System.out.println("getAddress "+userInfo.getAddress());
		Request newRequest = new Request(userInfo.getUserName(),userInfo.getPhone(),userInfo.getAddress(),fileName);
		newRequest.ModifyFile(fileName);
		userInfo.setPendingRequestList(Request.openlist(userInfo.getUserName(), userInfo.getType(), "PendingRequest.txt"));
		userInfo.setAcceptedRequestList(Request.openlist(userInfo.getUserName(), userInfo.getType(), "AcceptedRequest.txt"));
		userInfo.setRejectRequestList(Request.openlist(userInfo.getUserName(), userInfo.getType(), "RejectRequest.txt"));;
		request.getRequestDispatcher("bookingManagement.jsp").forward(request, response);
	}

}
