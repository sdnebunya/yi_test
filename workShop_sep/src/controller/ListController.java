package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ShohinBean;
import service.ShohinService;

public class ListController extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		try {
			int insertMoney = Integer.parseInt(request.getParameter("money"));

			ArrayList<ShohinBean> shohinList = new ArrayList<ShohinBean>();

			ShohinService ss = new ShohinService();
			shohinList = ss.searchList(insertMoney);

			request.setAttribute("shohinList", shohinList);

		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ServletContext context = this.getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/list.jsp");
	        dispatcher.forward(request, response);
	    }

	}
}
