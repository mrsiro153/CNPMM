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

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id, pass, yourname, dob, phone = "";	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		try {
			ConnectDatabase cn = new ConnectDatabase();
			id = request.getParameter("id");
			pass = request.getParameter("pass");
			yourname = request.getParameter("yourname");
			dob = request.getParameter("dob");
			phone = request.getParameter("phone");
			//
			System.out.println(id);
			int stt = 0;
			String[] program = request.getParameterValues("program");
			String sql = "UPDATE `activity`.`user` SET" + " `password`='" + pass + "'," + " `name`='" + yourname + "',"
					+ " `dob`='" + dob + "'," + " `phonenum`='" + phone + "'" + " WHERE `iduser`='" + id + "'";
			stt = cn.update(sql);
			// delete trong bang user_activity
			sql = "DELETE FROM `activity`.`user_activity` WHERE `user`='" + id + "'";
			stt = cn.update(sql);
			// delete trong bang user_program
			sql = "DELETE FROM `activity`.`user_program` WHERE `user`='" + id + "'";
			stt = cn.update(sql);
			// update lai cac muc ma nguoi dung yeu thich
			if (program != null) {
				for (String s : program) {
					sql = "INSERT INTO `activity`.`user_program`" + " (`user`, `program`)" + " VALUES ('" + id + "', '"
							+ s + "');";
					stt = cn.update(sql);
				}
			}
			if (stt != 0) {
				out.print("<script> alert('Success!') </script>");
				rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
				//response.sendRedirect("index.jsp");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<script> alert('Some thing is wrong!') </script>");
			//response.sendRedirect("edit.jsp");
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}

}
