package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ShohinBean;
import service.ShohinService;


public class DetailController extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException{
		try {
			String id = request.getParameter("id");

			ShohinService ss = new ShohinService();
			ShohinBean shohinDetail = ss.showDetail(id);

			request.setAttribute("shohinDetail", shohinDetail);

		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ServletContext context = this.getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/detail.jsp");
	        dispatcher.forward(request, response);
	    }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException{
		try {
			String id = request.getParameter("id");
			int stock = Integer.parseInt(request.getParameter("stock"));

			ShohinService ss = new ShohinService();
			String message = ss.shohinBuy(id, stock);

			request.setAttribute("message", message);

		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ServletContext context = this.getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");
	        dispatcher.forward(request, response);
	    }
	}
}