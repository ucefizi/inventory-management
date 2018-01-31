package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBAccess;
import models.Product;

public class EditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] url = request.getRequestURI().split("/");
		int id = Integer.parseInt(url[url.length - 1]);
		Product prod = null;
		DBAccess dao;
		try {
			dao = new DBAccess();
			prod = dao.getProduct(id);
			dao.close();
		} catch (Exception e) {
			System.out.println("exception: " + e);
			e.printStackTrace();
		}
		if (!prod.equals(null)) {
			request.setAttribute("product", prod);
			this.getServletContext().getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
		} else
			response.sendRedirect("/inventory-management");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] url = request.getRequestURI().split("/");
		int id = Integer.parseInt(url[url.length - 1]);
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		Calendar currenttime = Calendar.getInstance();
		Date sqldate = new Date((currenttime.getTime()).getTime());
		Product prod = new Product(id, price, description, sqldate);
		DBAccess dao;
		try {
			dao = new DBAccess();
			dao.updateProduct(prod);
			dao.close();
		} catch (Exception e) {
			System.out.println("exception: " + e);
			e.printStackTrace();
		}
		response.sendRedirect("/inventory-management");

	}
}
