package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.Makes;
/**
 * Servlet implementation class getList
 */
@WebServlet("/GetModelList")
public class GetModelList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetModelList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<String>();
		String make = request.getParameter("make");
		a.add("MODEL");
		if(!make.equals("")){
			ArrayList<String> temp = Makes.getModelList(make);
			a.addAll(temp);
		}
		String models = toJavascriptArray(a);
		response.setContentType("text/plain"); // sets the content type
		response.setCharacterEncoding("UTF-8"); // sets the encoding
		response.getWriter().write(models); // writes the value of the String to the response
	}
		public String toJavascriptArray(ArrayList<String> arr){
		    StringBuffer sb = new StringBuffer();
		    for(int i=0; i<arr.size(); i++){
		        sb.append(arr.get(i));
		        if(i+1 < arr.size()){
		            sb.append(",");
		        }
		    }
		    return sb.toString();
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
