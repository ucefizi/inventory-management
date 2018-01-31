package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBAccess;
import models.Product;

public class IndexServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBAccess dao;
		List<Product> res = new ArrayList<Product>();
		try {
			dao = new DBAccess();
			res = dao.getAllProducts();
			dao.close();
		} catch (Exception e) {
			System.out.println("exception: " + e);
			e.printStackTrace();
		}
		request.setAttribute("products", res);
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
