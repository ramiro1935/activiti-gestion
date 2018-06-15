package activiti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class UserController extends HttpServlet {
	public void doGet (HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
			PrintWriter out = rp.getWriter();
			String id = rq.getParameter("email").toString();
			MySQL db = new MySQL();
			db.MySQLConnection("root","root");
			if(db.existUser(id)) rp.sendRedirect("home.jsp");
			else {
			   out.println("<meta http-equiv='refresh' content='3;URL=index.jsp'>");
			   out.println("<p style='color:red;'>User or password incorrect!</p>");
			}
		}
}
