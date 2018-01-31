package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBAccess;

public class DeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] url = request.getRequestURI().split("/");
		int id = Integer.parseInt(url[url.length - 1]);
		DBAccess dao;
		try {
			dao = new DBAccess();
			dao.deleteProduct(id);
			dao.close();
		} catch (Exception e) {
			System.out.println("exception: " + e);
			e.printStackTrace();
		}
		response.sendRedirect("/inventory-management");

	}
}
