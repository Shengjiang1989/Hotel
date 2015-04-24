<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="edu.neu.cs5200.hotel.main.service.*, 
	edu.neu.cs5200.hotel.main.entity.*, java.util.*,
	edu.neu.cs5200.hotel.main.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Information</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<%

		String action = request.getParameter("action");
		String hotelId = request.getParameter("id");
		HotelManagementService hotelManagementService = new HotelManagementService();
		Hotel hotel = new Hotel();
		if (hotelId != null && hotelId != "") {
			hotel = hotelManagementService.getHotelById(Integer
					.parseInt(hotelId));
		}
		Customer customer = new Customer();
		Integer cId = (Integer)request.getSession().getAttribute("customerId");
		CustomerDAO customerDAO = new CustomerDAO();
		customer = customerDAO.getCustomerById(cId);

	%>

	<form action="placeOrder.jsp">
		<div class="header clearfix">
			<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header" align="center">
				<p class="navbar-brand">Hotel Information</p>
			</div>
			<div class="navbar-form navbar-right">
				<a href="searchHotel.jsp?"><button type="button"
						class="btn btn-link">return</button></a> <a href="customerProfile.jsp"><button
						type="button" class="btn btn-link">
						<u><%=customer.getUsername() %></u>
					</button></a>
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
						<td><%=hotel.getHotelName()%></td>
						<td><%=hotel.getCity()%></td>
						<td><%=hotel.getCountry()%></td>
						<td><%=hotel.getState()%></td>
						<td><%=hotel.getAddress()%></td>
					</tr>
					<tr>
						<th>Star</th>
						<th>Check-in time</th>
						<th>Check-out time</th>
						<th>Description</th>
					</tr>
					<tr>
						<td><%=hotel.getStar()%></td>
						<td><%=hotel.getCheckinTime()%></td>
						<td><%=hotel.getCheckoutTime()%></td>
						<td><%=hotel.getDescription()%></td>
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
								<%
								for (Service service : services) {
							%>
								<li><%=service.getServiceconfig().getServiceName()%> <em><%=service.getIfcharge()%></em></li>
								<%
								}
							%>
							</ul>
						</div>
						<div class="col-md-4">
							<h4>Hotel Amenities</h4>
							<ul>
								<%
								for (Amenity amenity : amenities) {
							%>
								<li><%=amenity.getAmenityconfig().getAmenityName()%> <em><%=amenity.getIfCharge()%></em>
									<em><%=amenity.getOpenTime()%></em></li>
								<%
								}
							%>
							</ul>
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
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</tr>
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Amount</th>
						<th>Description</th>
						<th>Facilities</th>
						<th>Nr. rooms</th>
					</tr>
					<%
					for (Roomtype roomtype : roomtypes) {
						List<Facility> facilities = roomtype.getFacility();
				%>
					<tr>
						<td><img src="<%=roomtype.getImageURL()%>"
							style="float: left; margin-right: 10px" /> <%=roomtype.getTypename()%></td>
						<td><%=roomtype.getPrice()%></td>
						<td><%=roomtype.getCapacity()%></td>
						<td><%=roomtype.getDescription()%></td>
						<td>
							<ul>
								<%
								for (Facility facility : facilities) {
							%>
								<li><%=facility.getFacilityconfig().getFacilityName()%></li>
								<%
								}
							%>
							</ul>
						</td>
						<td><select class="form-control" name="room">
								<option></option>
								<option>1 $<%=(1 * roomtype.getPrice()) %></option>
								<option>2 $<%=(2 * roomtype.getPrice())%></option>
								<option>3 $<%=(3 * roomtype.getPrice())%></option>
								<option>4 $<%=(4 * roomtype.getPrice())%></option>
								<option>5 $<%=(5 * roomtype.getPrice())%></option>
						</select></td>
						<td><button type="submit" name="roomtypeId"
								value="<%=roomtype.getId() %>" class="btn btn-success">Reserve</button></td>
					</tr>
					<%} %>

				</table>
				
			</div>
		</div>
		<div class="jumbotron">
					<div class="container">
						<%
							List<Reservation> allReservations = new ArrayList<Reservation>();
							for(Roomtype rt : roomtypes) {
							List<Reservation> reservations = rt.getReservation();
								for(Reservation r : reservations) {
									allReservations.add(r);
								}
							} 
		%>
						<table class="table table-striped">
							<tr>
								<th>Customer Reviews</th>
								<th>&nbsp;</th>
							</tr>
							<tr>
								<th>Username</th>
								<th>Review</th>
							</tr>
							<%
								for(Reservation reservation : allReservations) {
							%>
							<tr>
								<td><%=reservation.getCustomer().getUsername() %></td>
								<td><%=reservation.getReview() %></td>
							</tr>
							<% }%>

						</table>
					</div>
				</div>
	</form>


</body>
</html>