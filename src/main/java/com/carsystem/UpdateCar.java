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

@WebServlet("/updateCar")
public class UpdateCar extends HttpServlet {

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

		Session session = getSession();
		Transaction trans = session.beginTransaction();

		session.update(c);

		trans.commit();

		Query<Car> query = session.createQuery("from Car");



		req.setAttribute("cList", query.list());

		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");

		rd.forward(req, resp);

		session.close();	

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));

		Session session = getSession();

		Car car = session.get(Car.class, carId);


		req.setAttribute("car", car);

		RequestDispatcher rd = req.getRequestDispatcher("updateCar.jsp");
		rd.forward(req, resp);

		session.close();
	}
	
	private Session getSession() {
		return new Configuration().configure("carmanagement.cfg.xml")
				.addAnnotatedClass(Car.class)
				.buildSessionFactory()
				.openSession();
	}
}
