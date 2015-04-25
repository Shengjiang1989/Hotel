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
<title>Comment</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<%
		String action = request.getParameter("action");
		String reservationId = request.getParameter("id");
		
		Reservation reservation = new Reservation();
		ReservationDAO reservationDAO = new ReservationDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		Integer cId = (Integer) request.getSession().getAttribute(
				"customerId");
		
		customer = customerDAO.getCustomerById(cId);
		if(("create").equals(action)) {
			reservation = (Reservation)request.getSession().getAttribute("reservation");
			String review = request.getParameter("review");
			reservation.setReview(review);
			reservationDAO.updateReservation(reservation);
			customer.addReservation(reservation);
			//customerDAO.updateCustomer(customer);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/customerProfile.jsp");
			//dispatcher.forward(request, response);
		}else {
		
		
		if (reservationId != null && reservationId != ""){
			reservation = reservationDAO.getReservation(Integer.parseInt(reservationId));
		}
		}
		request.getSession().setAttribute("reservation", reservation);
		
	%>
	<form action="comment.jsp">
		<div class="header clearfix">
			<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header" align="center">
				<p class="navbar-brand">Customer profile</p>
			</div>
			<div class="navbar-form navbar-right">

				<button type="submit" name="action" value="create"
					class="btn btn-success">Add comment</button>
				<a href="customerProfile.jsp"><button type="button"
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
				<label for="inputEmail3" class="col-sm-2 control-label">Write
					your review</label>
				<textarea class="form-control" rows="3"
					placeholder="Write your review" name="review"></textarea>
			</div>

		</div>
	</form>
</body>
</html>