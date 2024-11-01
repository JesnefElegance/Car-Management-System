package com.carsystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session = new Configuration().configure("carmanagement.cfg.xml")
											 .addAnnotatedClass(Car.class)
											 .buildSessionFactory()
											 .openSession();
		
		Query<Car> query = session.createQuery("from Car");
		
		
		req.setAttribute("cList", query.list());
		
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		
		rd.forward(req, resp);
	}
}
