package pl.ug.javaee.znapierala;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<html><body><h1>Menu</h1><a href=\"http://localhost:8080/servletjspdemo/about\">about</a>"
			+ "<br><a href=\"http://localhost:8080/servletjspdemo/date\">date</a>"
			+ "<br><a href=\"http://localhost:8080/servletjspdemo/sayHello\">sayHello</a>");
	}
}