package helper;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.Makes;
import dataBase.Model;
import searchResult.SearchResult;

public class Recommendation {

	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String transmission = request.getParameter("transmission");
		String bodyType = request.getParameter("body");
		String make = request.getParameter("make");
		
		String price = request.getParameter("price");
		String fuelEfficient = request.getParameter("fuelEfficient");
		String horsepower = request.getParameter("horsepower");
		String torque = request.getParameter("torque");
		if(price.length() ==0 ) price = "0";
		if(fuelEfficient.length() ==0 ) fuelEfficient = "0";
		if(horsepower.length() ==0 ) horsepower = "0";
		if(torque.length() ==0 ) torque = "0";
		System.out.println(transmission);
		System.out.println(bodyType);
		System.out.println(make);
		System.out.println(price);
		System.out.println(fuelEfficient);
		System.out.println(horsepower);
		System.out.println(torque);
		ArrayList<Model> tempList = Makes.XIAJIBASearch(make, "", transmission, bodyType, "", 0, 0);
		SearchResult.setSearchData(Makes.XIAJIBARecommend(tempList,Integer.parseInt(price), Integer.parseInt(fuelEfficient), Integer.parseInt(horsepower), Integer.parseInt(torque)));
		request.setAttribute("hiddenFlag",SearchResult.hiddenButton());
		request.getRequestDispatcher("/recommendationResult.jsp").forward(request, response);
	}

}
