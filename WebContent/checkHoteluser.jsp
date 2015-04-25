<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.neu.cs5200.hotel.main.basedao.*,edu.neu.cs5200.hotel.main.dao.*,edu.neu.cs5200.hotel.main.entity.*,java.text.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"></head>
</head>
<body>

	</div>
	<div class="container">
	<%
	HoteluserDAO Dao=new HoteluserDAO();
	String Action=request.getParameter("action");
	String idSt=request.getParameter("id");
	String ssn=request.getParameter("ssn");
	String Pw=request.getParameter("password");
	String Un=request.getParameter("username");
	if("create".equals(Action)){
	Hoteluser hoteluser = new Hoteluser();
	hoteluser.setPassword(Pw);
	hoteluser.setUsername(Un);
	hoteluser.setSsn(ssn);
	hoteluser.setRegDate(new Date());
	Dao.createHoteluser(hoteluser);
	}
	else if("delete".equals(Action))
	{
		Integer idH=Integer.parseInt(idSt);
		Hoteluser hoteluser=Dao.getHoteluserById(idH);
		Dao.deleteHoteluserByUsername(hoteluser);
	}
	List<Hoteluser> hotelusers=Dao.readAllHoteluser();
	
	
	%>
	<h1>Hoteluser</h1>
	<form action="checkHoteluser.jsp">
		<table class="table table-striped">
			<tr>
				<th>id</th>
				<th>password</th>
				<th>regDate</th>
				<th>ssn</th>
				<th>username</th>
				<th>&nbsp;</th>
		 	</tr>
		 	<tr>
		 		<td><input name="id" class="form-control"/></td>
		 		<td><input name="password" class="form-control"/></td>
		 		<td><input name="regDate" class="form-control"/></td>
		 		<td><input name="ssn" class="form-control"/></td>
		 		<td><input name="username" class="form-control"/></td>
		 		<td>
		 			<button class="btn btn-primary" type="submit" name="action" value="create">Create</button>
		 		
		 		</td>
		 	</tr>
		 	<%
			for(Hoteluser hoteluser:hotelusers)
			{
		%> <tr>	
			<td>
				<a href="checkHoteluser.jsp?id=<%=hoteluser.getId() %>">
			<%=hoteluser.getId()%>
				</a>	
			</td>
			<td><%=hoteluser.getPassword()%></td>
			<td><%=hoteluser.getRegDate()%></td>
			<td><%=hoteluser.getSsn()%></td>
			<td><%=hoteluser.getUsername()%></td>
			<td>
				<a href="checkHoteluser.jsp?action=delete&id=<%=hoteluser.getId()%>"class="btn btn-danger">Delete</a>
			</td>
				</tr>
		<%	}
		%>
		
		</table >
		<a href="SignIn.jsp" >return</a>
		</form>
	
	
	
	
	</div>

</body>
</html>