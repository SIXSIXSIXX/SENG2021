package helper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import searchResult.SearchResult;

public class Next {

	public static void doGet(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
		SearchResult.next();
		request.setAttribute("resultList", SearchResult.getData());
		request.setAttribute("hiddenFlag",SearchResult.hiddenButton());
		if(action.equals("search")) request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
		else request.getRequestDispatcher("/recommendationResult.jsp").forward(request, response);
		
	}

}
