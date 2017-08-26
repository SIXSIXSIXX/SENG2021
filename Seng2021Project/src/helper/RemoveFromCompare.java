package helper;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.Makes;
import dataBase.Model;



public class RemoveFromCompare {

	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("removeFromCompare");
		System.out.println("removeFromList");

		ArrayList<Model> compareList = (ArrayList<Model>) request.getSession().getAttribute("carsCompare");

		if(id!=null){		
			Model car = Makes.getModel(Integer.parseInt(id));
			compareList.remove(car);
		}

		request.getSession().setAttribute("carsCompare", compareList);
		response.sendRedirect("comparisonList.jsp");
		
	}

}
