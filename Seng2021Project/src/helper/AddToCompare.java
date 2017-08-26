package helper;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dataBase.Makes;
import dataBase.Model;


public class AddToCompare {
	
	public static void doGet(HttpServletRequest request, HttpServletResponse response, String prevPage) throws ServletException, IOException {
		
		String picks[] = request.getParameterValues("pick");
		
		System.out.println(prevPage);
		ArrayList<Model> carsToCompare = (ArrayList<Model>) request.getSession().getAttribute("carsCompare");
		if (picks != null) {
			if (carsToCompare == null) {
				carsToCompare = new ArrayList<Model>();
			}

			for (String id : picks) {
				Model car = Makes.getModel(Integer
				        .parseInt(id));
				if (!carsToCompare.contains(car)) {
					carsToCompare.add(car);
				}
			}
		}
		request.getSession().setAttribute("carsCompare", carsToCompare);
		response.sendRedirect(prevPage);
		
		
		
	}

}
