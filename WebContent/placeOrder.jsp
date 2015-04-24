<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="edu.neu.cs5200.hotel.main.service.*, 
    edu.neu.cs5200.hotel.main.entity.*, java.util.*, edu.neu.cs5200.hotel.main.dao.*
    ,edu.neu.cs5200.hotel.main.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirmation</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<%
		String action = request.getParameter("action");
		Reservation reservation = new Reservation();
		if (action != "" && "create".equals(action)) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/orderInfo.jsp");
			dispatcher.forward(request, response);
		}

		Integer customerId = (Integer) request.getSession().getAttribute(
				"customerId");
		String roomtypeId = request.getParameter("roomtypeId");
		String[] rooms = request.getParameterValues("room");
		String no_price = "";
		for (int i = 0; i < rooms.length; ++i) {
			if (rooms[i] != "" && rooms[i] != null) {
				no_price = rooms[i];
				break;
			}
		}
		String numberRoom = "";
		String price = "";
		if (no_price != "") {
			String[] splits = no_price.split(" ");
			numberRoom = splits[0];
			price = splits[1];
			reservation.setRoomAmount(Integer.parseInt(numberRoom));
			reservation.setTotalPrice(Float.parseFloat(price.substring(1)));
		}
		Hotel hotel = new Hotel();
		Roomtype roomtype = new Roomtype();
		if (roomtypeId != null && roomtypeId != "") {
			Integer rId = Integer.parseInt(roomtypeId);
			request.getSession().setAttribute("roomtypeId", rId);
			RoomtypeDAO roomtypeDAO = new RoomtypeDAO();
			roomtype = roomtypeDAO.getRoomTypeBy(rId);
			hotel = roomtype.getHotel();
		}
		reservation.setRoomtype(roomtype);
		Customer customer = new Customer();
		if (customerId != null) {

			CustomerDAO customerDAO = new CustomerDAO();

			customer = customerDAO.getCustomerById(customerId);

		}
		reservation.setCustomer(customer);
		request.getSession().setAttribute("reservation", reservation);
	%>
	<form class="form-horizontal" action="orderInfo.jsp">
		<div class="header clearfix">
			<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header" align="center">
				<p class="navbar-brand">Order Confirmation</p>
			</div>
			<div class="navbar-form navbar-right">
				<button type="submit" name="action" value="create"
					class="btn btn-success">Place Order</button>
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
					<label class="col-sm-4 control-label">Hotel name</label>
					<div class="col-sm-8">
						<p class="form-control-static"><%=hotel.getHotelName()%></p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Room type</label>
					<div class="col-sm-8">
						<p class="form-control-static"><%=roomtype.getTypename()%></p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Number of rooms</label>
					<div class="col-sm-8">
						<p class="form-control-static"><%=numberRoom%></p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Total price</label>
					<div class="col-sm-8">
						<p class="form-control-static"><%=price%></p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Number of guests</label>
					<div class="col-sm-1">
						<input type="text" class="form-control" name="noGuest" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Check-in date</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="checkinDate"
							placeholder="yyyy-mm-dd" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Check-out date</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="checkoutDate"
							placeholder="yyyy-mm-dd" />
					</div>
				</div>

			</div>
		</div>
	</form>
</body>
</html>