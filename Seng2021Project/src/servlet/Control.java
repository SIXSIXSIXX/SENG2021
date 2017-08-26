package servlet;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import helper.*;
import Bean.UserBean;
import booking.Request;


/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String prevAction;
	private String prevPage;

       
    /**
     * @see HttpServlet#HttpServlet()
     */

//			XMLReader p = XMLReaderFactory.createXMLReader();
//			p.setContentHandler(new SAXParserCar(this.makes));
//			p.parse(getServletContext().getRealPath("/WEB-INF/cars.xml"));
//			this.makes.findbodyType();
//			this.makes.findMakeNameList();
//			System.out.println("hello");
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		

		
		
	//}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("accept"));
		if(request.getParameter("login")!=null){
			Login.doGet(request, response);

		}
		
		if(request.getParameter("addCar")!=null){
			AddCar.doGet(request, response);

		}
		
		if(request.getParameter("makeList")!=null){
			String make = request.getParameter("makeList");
			System.out.println(make);
			request.getRequestDispatcher("addAvailableCar.jsp").forward(request, response);

		}

		if(request.getParameter("confirm")!=null){
			createNewAccount.doGet(request, response);

		}
		
		if(request.getParameter("pending")!=null){
			UserBean user = (UserBean)request.getSession().getAttribute("userInfo");
			user.setCurrentList("pending");
			user.setPendingRequestList(Request.openlist(user.getUserName(), user.getType(), "PendingRequest.txt"));
			response.sendRedirect("bookingManagement.jsp");
		}
		
		if(request.getParameter("accepted")!=null){
			UserBean user = (UserBean)request.getSession().getAttribute("userInfo");
			user.setCurrentList("accepted");
			user.setAcceptedRequestList(Request.openlist(user.getUserName(), user.getType(), "AcceptedRequest.txt"));
			response.sendRedirect("bookingManagement.jsp");

		}
		if(request.getParameter("rejected")!=null){
			UserBean user = (UserBean)request.getSession().getAttribute("userInfo");
			user.setCurrentList("rejected");
			user.setRejectRequestList(Request.openlist(user.getUserName(), user.getType(), "RejectRequest.txt"));
			response.sendRedirect("bookingManagement.jsp");
		}
		
		if(request.getParameter("accept")!=null){
			System.out.println("accept request");
			Accept.doGet(request, response);


		}
		
		if(request.getParameter("reject")!=null){

			Reject.doGet(request, response);

		}
		
		
		if(request.getParameter("logout")!=null){
			request.getSession().setAttribute("username", "");
			request.getSession().setAttribute("userInfo", null);
			request.getRequestDispatcher("header.jsp").forward(request, response);
			
		}
		
		if(request.getParameter("search")!=null){
			Search.doGet(request, response);
			this.prevAction = "search";
			this.prevPage = "searchResult.jsp";
		}
		
		
		if(request.getParameter("next")!=null){
			Next.doGet(request,response, this.prevAction);
			
		}
		
		
		if(request.getParameter("booking")!=null){
			Booking.doGet(request, response);
			
		}
		
		if(request.getParameter("confirmBooking")!=null){
			BookingConfirm.doGet(request,response);
			
		}
		
		if(request.getParameter("addToCompare")!=null){
			AddToCompare.doGet(request, response, this.prevPage);
			
		}
		
		if(request.getParameter("Compare")!=null){
			AddToCompare.doGet(request, response, "carDetail.jsp?id="+request.getParameter("pick"));
		}
		
		if(request.getParameter("removeFromCompare")!=null){
			RemoveFromCompare.doGet(request, response);
			
		}
		
		if(request.getParameter("prev")!=null){
			Previous.doGet(request, response, this.prevAction);
			
		}
		
		if(request.getParameter("recommendation")!= null){
			Recommendation.doGet(request,response);
			this.prevAction = "recommendation";
			this.prevPage = "recommendationResult.jsp";				
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
}
