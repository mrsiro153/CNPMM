package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connectData.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			
			ConnectDatabase cn = new ConnectDatabase();
			String id, pass, yourname, dob, phone = "";
			id = request.getParameter("id");
			System.out.println(id);
			pass = request.getParameter("pass");
			yourname = request.getParameter("yourname");
			dob = request.getParameter("dob");
			phone = request.getParameter("phone");

			String sql = "INSERT INTO `activity`.`user`" + " (`iduser`, `password`, `name`, `dob`, `phonenum`)"
					+ " VALUES ('" + id + "', '" + pass + "', '" + yourname + "', '" + dob + "', '" + phone + "')";
			int rs = cn.update(sql);
			if (rs == 0) {
				out.print("<script> alert('Wrong username or password!') </script>");
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
				return;
			}
			String[] program = request.getParameterValues("program");
			if (program != null) {
				for (String s : program) {
					sql = "INSERT INTO `activity`.`user_program`" + " (`user`, `program`)" + " VALUES ('" + id + "', '"
							+ s + "');";
					cn.update(sql);
				}
			}
			out.print("<script> alert('Success!') </script>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
