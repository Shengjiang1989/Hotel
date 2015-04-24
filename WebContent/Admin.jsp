<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="edu.neu.cs5200.hotel.main.service.*, 
    edu.neu.cs5200.hotel.main.entity.*, 
    java.util.*,
    edu.neu.cs5200.hotel.main.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="header clearfix">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header" align="center">
			<p class="navbar-brand">All users</p>
		</div>
		<div class="navbar-form navbar-right">
			<a href="SignIn.jsp"><button type="button" class="btn btn-link">return</button></a>
		</div>
		</nav>
	</div>

	<label>&nbsp;&nbsp;&nbsp;</label>
	<div class="jumbotron">
		<div class="container">
		<label>Hotel users</label>
			<table class="table table-striped">
			<%
				List<Hoteluser> hotelusers = new ArrayList<Hoteluser>();
				HoteluserDAO hoteluserDAO = new HoteluserDAO();
				hotelusers = hoteluserDAO.readAllHoteluser();
			%>
			<tr>
				<th>Id</th>
				<th>Username</th>
				<th>Password</th>
				<th>Sign up date</th>
				<th>SSN</th>
				
			</tr>
			<%for(Hoteluser hoteluser : hotelusers) { %>
				<tr>
					<td><%=hoteluser.getId() %></td>
					<td><%=hoteluser.getUsername() %></td>
					<td><%=hoteluser.getPassword() %></td>
					<td><%=hoteluser.getRegDate() %></td>
					<td><%=hoteluser.getSsn() %></td>
					
				</tr>
			<%} %>
			</table>
		</div>
	</div>

	
	<div class="jumbotron">
		<div class="container">
		<label>Customer</label>
			<table class="table table-striped">
			<%
				List<Customer> customers = new ArrayList<Customer>();
				CustomerDAO customerDAO = new CustomerDAO();
				customers = customerDAO.getAllCustomer();
			%>
			<tr>
				<th>Id</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Username</th>
				<th>Password</th>
				<th>Sign up date</th>
				<th>Telephone</th>
				
			</tr>
			<%for(Customer customer : customers) { %>
				<tr>
					<td><%=customer.getId() %></td>
					<td><%=customer.getFirstName() %></td>
					<td><%=customer.getLastName() %></td>
					<td><%=customer.getUsername() %></td>
					<td><%=customer.getPassword() %></td>
					<td><%=customer.getRegDate() %></td>
					<td><%=customer.getTelephone() %></td>
					
				</tr>
			<%} %>
			</table>
		</div>
	</div>
</body>
</html>