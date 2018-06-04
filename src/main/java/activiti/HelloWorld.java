package activiti;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet { 
	   public void doGet (HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
				String id = rq.getParameter("nombre");
				String password = rq.getParameter("password");
				//API Java
				rp.sendRedirect("home.jsp");
	    }
}