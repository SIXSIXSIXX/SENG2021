package helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.Makes;
import dataBase.Model;
import searchResult.SearchResult;

public class Search {


	public static void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String transmission = request.getParameter("transmission");
		String bodyType = request.getParameter("body");
		String make = request.getParameter("make");
		String price = request.getParameter("price");
		String model = request.getParameter("model");
		String driven = request.getParameter("driveType");
	
		
		price = price.replaceAll("\\$", "");
		price = price.replaceAll("-", "");
		String[] priceArray = price.replaceAll("  ", " ").split(" ");
		int minPrice = Integer.parseInt(priceArray[0]);
		int maxPrice = Integer.parseInt(priceArray[1]);
		
		
		request.getSession().setAttribute("make", make);
		request.getSession().setAttribute("transmission", transmission);
		request.getSession().setAttribute("body", bodyType);
		request.getSession().setAttribute("price", price);
		request.getSession().setAttribute("driven", driven);
		request.getSession().setAttribute("model", model);
		request.getSession().setAttribute("min", minPrice);
		request.getSession().setAttribute("max", maxPrice);
		
		SearchResult.setSearchData(Makes.XIAJIBASearch(make, model, transmission, bodyType, driven, minPrice, maxPrice));
		
		request.setAttribute("hiddenFlag",SearchResult.hiddenButton());
		request.getRequestDispatcher("/searchResult.jsp").forward(request, response);

	}

}
