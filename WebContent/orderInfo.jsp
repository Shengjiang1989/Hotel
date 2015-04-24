<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="edu.neu.cs5200.hotel.main.service.*, 
    edu.neu.cs5200.hotel.main.entity.*, java.util.*, edu.neu.cs5200.hotel.main.dao.*
    ,edu.neu.cs5200.hotel.main.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<%
	Customer customer = new Customer();
	Integer cId = (Integer)request.getSession().getAttribute("customerId");
	CustomerDAO customerDAO = new CustomerDAO();
	customer = customerDAO.getCustomerById(cId);
		Reservation reservation = (Reservation) request.getSession()
				.getAttribute("reservation");
		String action = request.getParameter("action");
		String noGuest = request.getParameter("noGuest");
		String checkinDate = request.getParameter("checkinDate");
		String checkoutDate = request.getParameter("checkoutDate");
		reservation.setCheckinDate(Conversion.string2Date(checkinDate));
		reservation.setCheckoutDate(Conversion.string2Date(checkoutDate));
		if (noGuest != "" && noGuest != null) {
			reservation.setGuestNumber(Integer.parseInt(noGuest));
		}
		ReservationDAO reservationDAO = new ReservationDAO();
		//reservationDAO.createReservation(reservation);
		customer.addReservation(reservation);
		customerDAO.updateCustomer(customer);
	%>
	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">
				<div class="header clearfix">
					<nav class="navbar navbar-default navbar-fixed-top">
					<div class="navbar-header" align="center">
						<p class="navbar-brand">Order Confirmation</p>
					</div>
					<div class="navbar-form navbar-right">
						<a href="searchHotel.jsp"><button type="button"
								class="btn btn-link">Return to search</button></a>
						<a href="customerProfile.jsp"><button
						type="button" class="btn btn-link">
						<u><%=customer.getUsername()%></u>
					</button></a>
					</div>
					</nav>
				</div>

				<p>&nbsp;&nbsp;&nbsp;</p>
				<label>&nbsp;&nbsp;&nbsp;</label>
				<div class="inner cover">
					<h1 class="cover-heading">Thank you</h1>
					<p class="lead">Your reservation is completed</p>
				</div>

			</div>

		</div>
		</div>
</body>
</html>