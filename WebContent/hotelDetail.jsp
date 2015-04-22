<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="edu.neu.cs5200.hotel.main.service.*, edu.neu.cs5200.hotel.main.entity.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<%
		String hotelId = request.getParameter("id");
		HotelManagementService hotelManagementService = new HotelManagementService();
		Hotel hotel = new Hotel();
		if (hotelId != null && hotelId != "") {
			hotel = hotelManagementService.getHotelById(Integer.parseInt(hotelId));
		}
	%>
	<div class="header clearfix">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header" align="center">
			<p class="navbar-brand">Hotel Details</p>
		</div>
		<div class="navbar-form navbar-right">
			<a href="HotelList.jsp"><button type="button"
					class="btn btn-link">return</button></a>
		</div>
		</nav>
	</div>
	<label>&nbsp;&nbsp;&nbsp;</label>
	<div class="jumbotron">
		<div class="container">
			<table class="table table-striped">

				<tr>
					<th>Hotel Basic Information</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th></th>
				</tr>
				<tr>
					<th>Name</th>
					<th>City</th>
					<th>Country</th>
					<th>State</th>
					<th>Address</th>
				</tr>
				<tr>
					<td><%=hotel.getHotelName() %></td>
					<td><%=hotel.getCity() %></td>
					<td><%=hotel.getCountry() %></td>
					<td><%=hotel.getState() %></td>
					<td><%=hotel.getAddress() %></td>
				</tr>
				<tr>
					<th>Star</th>
					<th>Check-in time</th>
					<th>Check-out time</th>
					<th>Description</th>
				</tr>
				<tr>
					<td><%=hotel.getStar() %></td>
					<td><%=hotel.getCheckinTime() %></td>
					<td><%=hotel.getCheckoutTime() %></td>
					<td><%=hotel.getDescription() %></td>
				</tr>
			</table>
		</div>
	</div>

	<div class="jumbotron">
		<div class="container">
			<%
				List<Service> services = hotel.getServices();
				List<Amenity> amenities = hotel.getAmenities();
			%>
			<div class="container">
				<!-- Example row of columns -->
				<div class="row">
					<div class="col-md-4">
						<h4>Hotel Services</h4>
						<ul>
							<% for(Service service : services) { %>
							<li><%=service.getServiceconfig().getServiceName() %></li>
							<%} %>
						</ul>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
					<div class="col-md-4">
						<h4>Hotel Amenities</h4>
						<ul>
							<% for(Amenity amenity : amenities) { %>
							<li><%=amenity.getAmenityconfig().getAmenityName() %></li>
							<%} %>
						</ul>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
				</div>

				<hr>
			</div>
			<!-- /container -->
		</div>
	</div>

	<div class="jumbotron">
		<div class="container">
			<table class="table table-striped">
				<%
					List<Roomtype> roomtypes = hotel.getRoomtypes();
				%>
				<tr>
					<th>Room Type</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Capacity</th>
					<th>Image</th>
					<th>Description</th>
					<th>Facilities</th>
				</tr>
				<% for(Roomtype roomtype : roomtypes) { %>
				<tr>
					<td><%= roomtype.getTypename() %></td>
				</tr>
				<%} %>
			</table>
		</div>
	</div>


</body>
</html>