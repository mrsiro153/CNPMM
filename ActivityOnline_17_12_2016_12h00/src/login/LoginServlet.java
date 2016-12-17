package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectData.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request,response);
		response.sendRedirect("index.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		try{
			
			//out = 
			ConnectDatabase cn= new ConnectDatabase();
			ResultSet rs = null;
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String sql="SELECT * FROM activity.user where iduser='"+id+"'";
			int stt=0;
			rs = cn.GetData(sql);
			//
			if (rs != null) {
				rs.next();
				if (pass.equals(rs.getString("Password"))) {
					stt = 1;
					HttpSession session = request.getSession();
					session.setAttribute("name", rs.getString("name"));
					session.setAttribute("id", id);
					session.setAttribute("pa",rs.getString("password"));
					session.setAttribute("dob",rs.getString("dob"));
					session.setAttribute("phone",rs.getString("phonenum"));
					session.setMaxInactiveInterval(60*60);
				}
			}
			if(stt==1){
				response.sendRedirect("index.jsp");
				return;
			}
					
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			out.print("<script> alert('Wrong username or password!') </script>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		
	}

}
