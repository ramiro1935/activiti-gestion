package activiti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

// Controlador Procesos de activiti
// Renderiza la compra si fue satisfactoria
public class PurchaseController extends HttpServlet {
  public void doPost (HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
      PrintWriter out = rp.getWriter();
      PROCESS_SERVICE ps = new PROCESS_SERVICE();
      
      // Lectura de los parámetros del cliente
      String fecha = rq.getParameter("fecha").toString();
      String items = rq.getParameter("items").toString();
      String monto = rq.getParameter("monto").toString();
      
      // Inicialización del proceso
      ps.activitiConnection();
      ps.initProcess(fecha,items,monto);
      
      // Aerta de creación exitosa
      out.println("<script type=\"text/javascript\">");
      out.println("alert('Proceso creado exitosamente.');");
      out.println("location='home.jsp';");
      out.println("</script>");
      


    }
}
