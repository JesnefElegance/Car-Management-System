package com.carsystem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/addCar")
public class AddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		String carModel = req.getParameter("carModel");
		String carBrand = req.getParameter("carBrand");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));
		
		Car c = new Car();
		c.setCarId(carId);
		c.setCarModel(carModel);
		c.setCarBrand(carBrand);
		c.setCarPrice(carPrice);
		
		Session session = new Configuration().configure("carmanagement.cfg.xml")
											 .addAnnotatedClass(Car.class)
											 .buildSessionFactory()
											 .openSession();
		Transaction trans = session.beginTransaction();
		
		session.save(c);
		
		trans.commit();
		
		resp.sendRedirect("index.jsp");
//		session.close();
	}
}