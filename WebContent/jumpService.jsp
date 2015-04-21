<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.hotel.main.service.*, edu.neu.cs5200.hotel.main.entity.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
		String action = request.getParameter("action");
		String hotelname = request.getParameter("Name");
		String name = request.getParameter("Name");
		String city = request.getParameter("City");
		String country = request.getParameter("Country");
		String state = request.getParameter("State");
		String address = request.getParameter("Address");
		String star = request.getParameter("Star");
		String checkIn = request.getParameter("Check-in time");
		String checkOut = request.getParameter("Check-out time");
		String description = request.getParameter("Description");
		Hotel hotel = new Hotel();
		if("save".equals(action)) {
			HotelManagementService hotelManagementService = new HotelManagementService();
			hotel.setAddress(address);
			hotel.setCheckinTime(checkIn);
			hotel.setCheckoutTime(checkOut);
			hotel.setCity(city);
			hotel.setCountry(country);
			hotel.setDescription(description);
			hotel.setHotelName(name);
			if(star != null && star != ""){
				hotel.setStar(Integer.parseInt(star));
			}
			hotel.setState(state);
			UserManagementService ums = new UserManagementService();
			hotel.setHoteluser(ums.getHoteluserById(1));
			hotel = hotelManagementService.createHotel(hotel);
		}
	%>
<meta http-equiv="refresh" content="1;url=createService.jsp?id=<%= hotel.getId()%>">

</head>
<body>
<h1 align="center">Please wait, Saving Hotel Basic Information...</h1>
</body>
</html>