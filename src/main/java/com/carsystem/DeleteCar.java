package com.carsystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@WebServlet("/deleteCar")
public class DeleteCar extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));

		Session session = new Configuration().configure("carmanagement.cfg.xml")
				.addAnnotatedClass(Car.class)
				.buildSessionFactory()
				.openSession();

		Transaction trans = session.beginTransaction();
		Car car = session.get(Car.class, carId);
		
		session.delete(car);
		
		trans.commit();
		

		Query<Car> query = session.createQuery("from Car");


		req.setAttribute("cList", query.list());

		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");

		rd.forward(req, resp);

		session.close();	
	}
}
