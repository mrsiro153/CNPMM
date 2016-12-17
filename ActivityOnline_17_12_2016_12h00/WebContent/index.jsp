<%@page import="java.sql.ResultSet"%>
<%@page import="javax.websocket.SendResult"%>
<%@page import="connectData.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Activities</title>
		<link rel="stylesheet" href="css/style.css" type="text/css">
		<script type="text/javascript" src="javascript.js"></script>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Lalezar" rel="stylesheet">
	</head>
	<body>
	<%
	if(session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");
	}
	%>
		<div class="border">
			<div id="bg">
				background
			</div>
			<!---->
			<%
			//get notification
			//ConnectDatabase cdGetnoti=new ConnectDatabase();
			//ResultSet resultNoti=null;
			//String idUser="";
			//if(session.getAttribute("name")==null){
			//	idUser=(String)session.getAttribute("name");
			//}
			//String sqlNoti="SELECT * FROM activity.user_program where user='"+idUser+"'";
			%>
			<div class="profile">
				<center style="margin-top:20px;">
					<img src="images/avatar.jpg" style="width:190px;height:190px" class="img-cricle">
					<h3><%=session.getAttribute("name") %></h3>
					<button style="font-size:24px">Notification <i class="material-icons">notifications_active</i></button>
				</center>
				
					<button class="btn btn-default" onclick="location.replace('edit.jsp')" style="float:left; margin-top:10px;margin-left:25px">Edit your infor
					</button>
					<form action="index.jsp" method="get" style="float: left;margin-top:10px;">
						<button class="btn btn-default" name="logout" type="submit" value="logout">Logout</button>				
					</form>				
				
			</div>
			<%
				String s= request.getParameter("logout");
				if(s!=null){
				if(s.equals("logout")){
					session.invalidate();
					response.sendRedirect("login.jsp");
				}
			}
			%>
			<!---->
			<%
			ConnectDatabase cn=new ConnectDatabase(); 
			String sql="SELECT * FROM activity.program";
			ResultSet rs=cn.GetData(sql);	
			%>
			<div class="page">
				<div class="sidebar">
					<a href="index.jsp" id="logo"><img src="images/logo1.png" alt="logo"></a>
					<ul>
						<%
						while(rs.next()){
							String programName=rs.getString("name");
							%>
							<li><p title="<%out.print(rs.getString("idprogram"));  %>" onclick="filterProgram(this)">
							<% out.print(programName);%>
							</p></li>		
						<% }%>
					</ul>
				</div>
				<div class="body" id="contentActivity">
					<%		
					sql="SELECT * FROM activity.activities";
					rs=cn.GetData(sql);
					while(rs.next()){
						out.println("<div>");
						out.println("<h2 title='"+rs.getString("idprogram")+"'>");
						out.print(rs.getString("name"));
						out.println("</h2>");
						out.println("<p>");
						out.print(rs.getString("content"));
						out.println("</p>");
						out.println("</div>");
					}
					%>
				</div>
			</div>
		</div>
	</body>
</html>