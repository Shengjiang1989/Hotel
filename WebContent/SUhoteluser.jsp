<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.hotel.main.basedao.*,edu.neu.cs5200.hotel.main.dao.*,edu.neu.cs5200.hotel.main.entity.*, java.text.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"></head>
</head>
<body>
<div class="container">
	<%
	String action=request.getParameter("action");
	String ssn=request.getParameter("ssn");
	String pw=request.getParameter("password");
	String un=request.getParameter("username");
	if("create".equals(action)){
	Hoteluser hoteluser = new Hoteluser();
	hoteluser.setPassword(pw);
	hoteluser.setUsername(un);
	hoteluser.setSsn(ssn);
	hoteluser.setRegDate(new Date());
	HoteluserDAO dao=new HoteluserDAO();
	dao.createHoteluser(hoteluser);
	}
	%>
	

	<h1>
	Sign Up
	</h1>
		<form action="SUhoteluser.jsp">
		<table class="table table-striped">
			<tr>
				<th>password</th>
				<th>ssn</th>
				<th>username</th>
				<th>&nbsp;</th>
		 	</tr>
		 	<tr>
		 		<td><input name="password" class="form-control"/></td>
		 		<td><input name="ssn" class="form-control"/></td>
		 		<td><input name="username" class="form-control"/></td>
		 		<td>
		 			<button class="btn btn-primary" type="submit" name="action" value="create">Create</button>
		 		
		 		</td>
		 	</tr>
				</table >
				
			
		</form>
</div>
				

</body>
</html>