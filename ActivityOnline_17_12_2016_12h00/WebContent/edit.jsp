<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<center><h1>Thông tin tài khoản của bạn</h1></center>
		<div style="margin: auto;width: 50%;
			border: 3px solid green;padding: 10px;">
			<div class="personalInfor">
				<form action="edit" method="post">
					<div class="form-group">
						<label for="text">Your ID:</label>
						<input type="text" class="form-control" name="id" readonly value="<%=session.getAttribute("id")%>">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						<input type="password" class="form-control" name="pass" value="<%=session.getAttribute("pa")%>">
					</div>
					<div class="form-group">
						<label for="text">Your name:</label>
						<input type="text" class="form-control" name="yourname" value="<%=session.getAttribute("name")%>">
					</div>
					<div class="form-group">
						<label for="text">Date of birth:</label>
						<input type="text" class="form-control" name="dob" value="<%=session.getAttribute("dob")%>">
					</div>
					<div class="form-group">
						<label for="text">Phone num:</label>
						<input type="text" class="form-control" name="phone" value="<%=session.getAttribute("phone")%>">
					</div>
					<p>Lĩnh vực bạn quan tâm:</p>
					<div class="checkbox">
						<label><input type="checkbox" name="program" value="1">Âm nhạc</label>
						<label><input type="checkbox" name="program" value="2">Việc làm</label>
						<label><input type="checkbox" name="program" value="3">Nghệ thuật</label>
						<label><input type="checkbox" name="program" value="4">Các cuộc thi</label>
						<label><input type="checkbox" name="program" value="5">Học bổng</label>
					</div>
					<p style="color:red">Chúng tôi sẽ gửi thông báo khi có hoạt động mới theo lĩnh vực bạn quan tâm</p>
					<center>
						<button type="button" onclick="location.replace('index.jsp')" class="btn btn-default" >Cancel</button>
						<button type="submit" class="btn btn-default">OK</button>
					</center>
				</form>
			</div>
		</div>
	</body>
</html>