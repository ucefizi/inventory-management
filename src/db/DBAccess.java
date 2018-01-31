package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Product;

public class DBAccess {
	private Connection connect = null;
	private Statement stat = null;
	private PreparedStatement prstat = null;
	private ResultSet res = null;

	public DBAccess() throws Exception {
		super();
		Class.forName("org.mariadb.jdbc.Driver");
		this.connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "pacuser", "pacuser");
	}

	public List<Product> getAllProducts() throws Exception {
		List<Product> results = new ArrayList<Product>();
		try {
			stat = connect.createStatement();
			res = stat.executeQuery("select * from inventory.product");
			while (res.next()) {
				Product prod = new Product(res.getInt(1), res.getDouble(2), res.getString(3), res.getDate(4));
				results.add(prod);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return results;
	}

	public void addProduct(Product prod) throws Exception {
		try {
			prstat = connect.prepareStatement("insert into inventory.product values(default, ?, ?, ?);");
			prstat.setDouble(1, prod.getPrice());
			prstat.setString(2, prod.getDescription());
			prstat.setDate(3, prod.getCreationDate());
			prstat.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	public void deleteProduct(int prodId) throws Exception {
		try {
			prstat = connect.prepareStatement("delete from inventory.product where id=?;");
			prstat.setInt(1, prodId);
			prstat.executeUpdate();
		} catch (Exception e) {
			System.out.println("exception: " + e);
		}
	}

	public void updateProduct(Product prod) {
		try {
			prstat = connect.prepareStatement(
					"update inventory.product set price=?, description=?, creation_date=? where id=?;");
			prstat.setDouble(1, prod.getPrice());
			prstat.setString(2, prod.getDescription());
			prstat.setDate(3, prod.getCreationDate());
			prstat.setInt(4, prod.getId());
			prstat.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	public Product getProduct(int prodId) {
		List<Product> results = new ArrayList<Product>();
		try {
			prstat = connect.prepareStatement("select * from inventory.product where id=?;");
			prstat.setDouble(1, prodId);
			res = prstat.executeQuery();
			while (res.next()) {
				Product prod = new Product(res.getInt(1), res.getDouble(2), res.getString(3), res.getDate(4));
				results.add(prod);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		if (results.size() == 1)
			return results.get(0);
		return null;
	}

	public void close() {
		try {
			if (res != null)
				res.close();
			if (stat != null)
				stat.close();
			if (connect != null)
				connect.close();
		} catch (Exception e) {
		}
	}
}
