package activiti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class UserController extends HttpServlet {
	   public void doGet (HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
				String id = rq.getParameter("nombre").toString();
				String password = rq.getParameter("password");
				if(USER_SERVICE.existUser(id)) rp.sendRedirect("home.jsp");
	    }
}
