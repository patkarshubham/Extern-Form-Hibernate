import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/cetpa")
public class HelloWorld extends HttpServlet{
    
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
	//create session
		HttpSession session=req.getSession();
		session.setMaxInactiveInterval(10);
		out.println("SessionTime="+session.getMaxInactiveInterval());
		out.println("<br>");
		out.println("SessionId="+session.getId());
		out.println("<br>");
		out.println("CreatingTime="+new Data(session.getCreationTime()));
		out.println("<br>");
		out.println("ISNew="+session.isNew());
		//destroy session
		//session.invalidate();
		Cookie[] ck=req.getCookies();
		if(ck!=null) {
			for(Cookie c:ck) {
			out.println(c.getName()+" "+c.getValue());	
			}
		}
			
	}
	
}