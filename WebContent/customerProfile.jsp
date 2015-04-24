<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="edu.neu.cs5200.hotel.main.service.*, 
    edu.neu.cs5200.hotel.main.entity.*, 
    java.util.*,
    edu.neu.cs5200.hotel.main.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer profile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<%
Customer customer = new Customer();
Integer cId = (Integer)request.getSession().getAttribute("customerId");
CustomerDAO customerDAO = new CustomerDAO();
customer = customerDAO.getCustomerById(cId);
	
%>
<form action="customerProfile.jsp">
	<div class="header clearfix">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header" align="center">
			<p class="navbar-brand">Customer profile</p>
		</div>
		<div class="navbar-form navbar-right">
			<a href="searchHotel.jsp"><button type="button"
					class="btn btn-link">return</button></a> <a href="customerProfile.jsp"><button
					type="button" class="btn btn-link">
					<u><%=customer.getUsername()%></u>
				</button></a>
		</div>
		</nav>
	</div>
	<label>&nbsp;&nbsp;&nbsp;</label>
	<div class="jumbotron">
		<div class="container">


			<div class="form-group">
				<label class="col-sm-4 control-label">Customer name</label>
				<div class="col-sm-8">
					<p class="form-control-static"><%=customer.getFirstName()%>
						<%=customer.getLastName()%></p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">Username</label>
				<div class="col-sm-8">
					<p class="form-control-static"><%=customer.getUsername()%></p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">Password</label>
				<div class="col-sm-8">
					<p class="form-control-static"><%=customer.getPassword()%></p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">Sign up Date</label>
				<div class="col-sm-8">
					<p class="form-control-static"><%=customer.getRegDate()%></p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">Telephone</label>
				<div class="col-sm-8">
					<p class="form-control-static"><%=customer.getTelephone()%></p>
				</div>
			</div>
			<div class="form-group">
				<button type="submit" name="action" value="view"
					class="btn btn-success">View order history</button>
			</div>


		</div>
	</div>
	<% 
			List<Reservation> reservations = customer.getReservations(); 
			if (reservations != null && reservations.size() > 0 && 
					request.getParameter("action") != null
					&& request.getParameter("action").equals("view")) {
				%>
	<div class="jumbotron">
		<div class="container">
		<h3>Order history</h3>
		<table class="table table-striped">
			<tr>
   		 		<th align = "center">Id</th>
    			<th align = "center">Total price</th>
    			<th align = "center">Check-in date</th>
    			<th align = "center">Check-out date</th>
    			<th align = "center">Number of guests</th>
    			<th align = "center">Number of rooms</th>
    			<th align = "center">Hotel name</th>
    			<th align = "center">Room Type</th>
    			<th align = "center">Review</th>
  			</tr>
		<%
			for(Reservation reservation: reservations) 
			{
				Roomtype roomtype = reservation.getRoomtype();
				Hotel hotel = roomtype.getHotel();
				String hotelname = hotel.getHotelName();
		%>
			<tr>	 
				<td><%=  reservation.getId()%></td>
				<td><%=  reservation.getTotalPrice()%></td>
				<td><%=  reservation.getCheckinDate()%></td>
				<td><%=  reservation.getCheckoutDate()%></td>
				<td><%=  reservation.getGuestNumber()%></td>
				<td><%=  reservation.getRoomAmount()%></td>
				<td><%=  hotelname%></td>
				<td><%=  roomtype.getTypename()%>
				<img src="<%= roomtype.getImageURL() %>" style="float:left;margin-right:10px"/></td>
				<%if(reservation.getReview() != "" & reservation.getReview() != null) {%>
					<td><%= reservation.getReview()%></td>
				<%} else {%>
					<td><a href="comment.jsp?id=<%= reservation.getId() %>">Add review</a></td>
				<%} %>
			</tr>
		<%	
			}
		%>
		</table>
		</div>
	</div>
	<%
			}
		%>
		</form>

</body>
</html>