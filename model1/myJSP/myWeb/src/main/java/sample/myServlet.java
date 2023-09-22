package sample;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

// @WebServlet("/MyServlet")
//<servlet>
//	<servlet-name>MyFirstServlet</servlet-name>
//	<servlet-class>sample.MyFirstServlet</servlet-class>
//</servlet>
//<servlet-mapping>
//	<servlet-name>MyFirstServlet</servlet-name>
//	<url-pattern>/MyFirstServlet</url-pattern>
//</servlet-mapping>
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		try {
			out.println("<html><head><title>My Servlet</title></head><body>");
			out.println("<h2 align='center'>My First Servlet File</h2><br>");
			out.println("<hr color='red'><br><br><font size='5'>지금은 ");
			out.println(new java.util.Date());
			out.println(" 입니다.</font></body></html>");
		} finally {
			out.close();
		}
	}
    

}
