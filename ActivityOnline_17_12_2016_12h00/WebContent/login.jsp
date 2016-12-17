<%@page import="java.sql.ResultSet"%>
<%@page import="connectData.ConnectDatabase"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Activities</title>
		<link rel="stylesheet" href="css/style.css" type="text/css">
		<script type="text/javascript" src="javascript.js"></script>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Lalezar" rel="stylesheet">
	</head>
	<body>
		<div class="border">
			<div id="bg">
				background
			</div>
			<!---->
			<div class="profile">
				<center><h2>Login </h2></center>
				<form style="padding:5px;" action="login" method="post">
					<div class="form-group">
						<label for="text">Your ID:</label>
						<input type="text" class="form-control" name="id">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						<input type="password" class="form-control" name="pass">
					</div>
					<center>
					<button type="submit" class="btn btn-default">Login</button></center>
				</form>
				<p style="margin-top:20px;">If you don't have an account, <a href="register.jsp">register</a> to use better service</p>
			</div>
			<!---->
			<%
			ConnectDatabase cn=new ConnectDatabase(); 
			String sql="SELECT * FROM activity.program";
			ResultSet rs=cn.GetData(sql);	
			%>
			<div class="page">
				<div class="sidebar">
					<a href="#" id="logo"><img src="images/logo1.png" alt="logo"></a>
					<ul>
						<%
						while(rs.next()){
							String programName=rs.getString("name");
							%>
							<li><p>
							<% out.print(programName);%>
							</p></li>		
						<% }%>
					</ul>
				</div>
				<div class="body">
				<%
					sql="SELECT * FROM activity.activities";
					rs=cn.GetData(sql);
					while(rs.next()){
						out.println("<div>");
						out.println("<h2>");
						out.print(rs.getString("name"));
						out.println("</h2>");
						out.println("<p>");
						out.print(rs.getString("content"));
						out.println("</p>");
						out.println("</div>");
					}
					%>
					<!--  
					<div>
						<h2>Welcome to FineMinds Marketing Solutions</h2>
						<p>
							This website template has been designed by Free Website Templates for you, for free. You can replace all this text with your own text.
						</p>
						<img src="images/tree.jpg" alt="">
					</div>
					-->
				</div>
			</div>
		</div>
	</body>
</html>