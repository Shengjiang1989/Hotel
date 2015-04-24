<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.hotel.main.service.*, edu.neu.cs5200.hotel.main.entity.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="refresh" content="30">
<title>Hotel List</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<body>
	<div align="left" class="container">
		<%
		HotelManagementService hms = new HotelManagementService();
		String action = request.getParameter("action");
		Integer hotelId = (Integer)request.getSession().getAttribute("hoteluserId");
		String hoteluserId = request.getParameter("hoteluserId");
		if("delete".equals(action)) {
			
				hms.deleteHotel(hotelId, Integer.parseInt(hoteluserId));
			
		}
			List<Hotel> hotels = hms.getAllHotels(1);
			

		%>
		<h1 align="center">Hotels</h1>
		<a href="createHotel.jsp" type="button" class="btn btn-success pull-right">Create</a>
		<table class="table table-striped">
			<tr>
   		 		<th align = "center">Id</th>
    			<th align = "center">Name</th>
    			<th align = "center">City</th>
    			<th align = "center">Country</th>
    			<th align = "center">Description</th>
    			<th align = "center">Action</th>
    			<th align = "center">&nbsp;</th>
  			</tr>
		<%
			for(Hotel hotel: hotels) 
			{
		%>
			<tr>	 
				<td><%=  hotel.getId()%></td>
				<td><%=  hotel.getHotelName()%></td>
				<td><%=  hotel.getCity()%></td>
				<td><%=  hotel.getCountry()%></td>
				<td><%=  hotel.getDescription()%></td>
				<td>
					<a href="HotelList.jsp?action=delete&&hoteluserId=1&id=<%= hotel.getId() %>">Delete</a>
				</td>
				<td>
					<a href="hotelDetail.jsp?id=<%= hotel.getId() %>">View</a>
				</td>
			</tr>
		<%	
			}
		%>
		</table>
	</div>

</body>
</html>