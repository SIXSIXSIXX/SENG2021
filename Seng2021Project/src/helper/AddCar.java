package helper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import booking.AddCars;
import dataBase.Makes;

public class AddCar {

	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = (String)request.getSession(false).getAttribute("username");
		String make = request.getParameter("makeList");
		String[] makes = new String[100];
		makes[0] = make;
		String model = request.getParameter("select-two");
		System.out.println(makes[0]);
		System.out.println(username);
		System.out.println(model);
		String[] models = new String[100];
		
		models[0] = model;
		
	
		
		AddCars.addCars(username, Makes.getIDByModels(makes, models));
		

		
	}

}
