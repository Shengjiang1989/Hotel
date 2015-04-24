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
<title>Create a new hotel</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>

<body>
	<form action="createHotel.jsp">

		<div class="header clearfix">
			<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header" align="center">
				<p class="navbar-brand">Add a new Hotel</p>
			</div>
			<div class="navbar-form navbar-right">
				<button type="submit" name="action" value="create"
					class="btn btn-success">create</button>
				<a href="HotelList.jsp"><button type="button" 
					class="btn btn-link">return</button></a>
			</div>
			</nav>
		</div>
		<div class="jumbotron">
			<div class="container">
				<%
					String disabled = request.getParameter("disabled");
					String roomTypeNo = request.getParameter("roomTypeNo");
					String action = request.getParameter("action");
					if ("create".equals(action)) {
						HotelManagementService hotelManagementService = new HotelManagementService();
						//hotel.setServices(services);
						//hotel.setAmenities(amenities);
						//hotel.setRoomtypes(roomTypes);
						Hotel hotel = hotelManagementService.createHotelService(request);
						request.setAttribute("disabled", "disabled");
					}
				%>
				<div>
				<label>&nbsp;&nbsp;&nbsp;<input type="text"
					name="roomTypeNo" class="form-control" placeholder="number of room types" <%=request.getAttribute("disabled") %>></label>
					<button type="submit" name="action" value="save"
					class="btn btn-success" <%=request.getAttribute("disabled") %>>apply</button>
				</div>
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
						<td><input type="text" name="Name" class="form-control" <%=request.getAttribute("disabled") %>>
						</td>
						<td><input type="text" name="City" class="form-control" <%=request.getAttribute("disabled") %>>
						</td>
						<td><input type="text" name="Country" class="form-control" <%=request.getAttribute("disabled") %>>
						</td>
						<td><input type="text" name="State" class="form-control" <%=request.getAttribute("disabled") %>>
						</td>
						<td><input type="text" name="Address" class="form-control" <%=request.getAttribute("disabled") %>>
						</td>
					</tr>
					<tr>
						<th>Star</th>
						<th>Check-in time</th>
						<th>Check-out time</th>
						<th>Description</th>
					</tr>
					<tr>
						<td><input type="text" name="Star" class="form-control"  <%=request.getAttribute("disabled") %>>
						</td>
						<td><input type="text" name="Check-in time"
							class="form-control" <%=request.getAttribute("disabled") %>></td>
						<td><input type="text" name="Check-out time"
							class="form-control" <%=request.getAttribute("disabled") %>></td>
						<td><input type="text" name="Description"
							class="form-control" <%=request.getAttribute("disabled") %>></td>
					</tr>

				</table>

			</div>
		</div>

		<div class="jumbotron">
			<div class="container">
				<%
					
				%>
				<table class="table table-striped">

					<tr>
						<th>Hotel Service</th>
						<th>Charge</th>
					</tr>
					<%
					ServiceconfigDAO serviceconfigDAO = new ServiceconfigDAO();
					List<Serviceconfig> serviceconfigs = serviceconfigDAO
							.getAllServiceconfig();
						for (Serviceconfig serviceconfig : serviceconfigs) {
					%>
					<tr>
						<td><label> <input type="checkbox"
								name="<%=serviceconfig.getId()%>service" value="selected" <%=request.getAttribute("disabled") %>><%=serviceconfig.getServiceName()%>
						</label></td>
						<td><select class="form-control"
							name="<%=serviceconfig.getId()%>serviceFee"  <%=request.getAttribute("disabled") %>>
								<option value="null"></option>
								<option value="free">free</option>
								<option value="charged">charged</option>
						</select></td>
					</tr>
					<%
						}
					%>
				</table>

			</div>
		</div>

		<div class="jumbotron">
			<div class="container">
				<table class="table table-striped">

					<tr>
						<th>Hotel Amenity</th>
						<th>Charge</th>
						<th>Open Time</th>
					</tr>
					<%
					AmenityconfigDAO amenityconfigDAO = new AmenityconfigDAO();
					List<Amenityconfig> amenityconfigs = amenityconfigDAO
							.getAllAmenityconfig();
						for (Amenityconfig amenityconfig : amenityconfigs) {
					%>
					<tr>
						<td><label> <input type="checkbox"
								name="<%=amenityconfig.getId()%>amenity" value="selected"  <%=request.getAttribute("disabled") %>><%=amenityconfig.getAmenityName()%>
						</label></td>
						<td><select class="form-control"
							name="<%=amenityconfig.getId()%>amenityFee" <%=request.getAttribute("disabled") %>>
								<option value="null"></option>
								<option value="free">free</option>
								<option value="charged">charged</option>
						</select></td>
						<td><input type="text"
							name="<%=amenityconfig.getId()%>openTime" class="form-control" <%=request.getAttribute("disabled") %>>
						</td>
					</tr>
					<%
						}
					%>
				</table>

			</div>
		</div>
		<div class="jumbotron">
			<div class="container">

				<table class="table table-striped">

					<tr>
						<th>Room Type</th>
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
					<%
						int roomTypeCount = 0;
						if (roomTypeNo != null && roomTypeNo != "") {
							roomTypeCount = Integer.parseInt(roomTypeNo);
						}
						for (int i = 1; i <= roomTypeCount; ++i) {
					%>
					<tr>
						<td><input type="text" name="typeName<%=i%>"
							class="form-control" <%=request.getAttribute("disabled") %>></td>
						<td><input type="text" name="price<%=i%>"
							class="form-control" <%=request.getAttribute("disabled") %>></td>
						<td><input type="text" name="capacity<%=i%>"
							class="form-control" <%=request.getAttribute("disabled") %>></td>
						<td><input type="text" name="image<%=i%>"
							class="form-control" <%=request.getAttribute("disabled") %>></td>
						<td><textarea class="form-control" rows="3"
								name="roomdescription<%=i%>" class="form-control" <%=request.getAttribute("disabled") %>>
						</textarea></td>
						<td><select multiple class="form-control"
							name="facility<%=i%>" <%=request.getAttribute("disabled") %>>
								<%
									FacilityconfigDAO facilityconfigDAO = new FacilityconfigDAO();
										List<Facilityconfig> facilityconfigs = new ArrayList<Facilityconfig>();
										facilityconfigs = facilityconfigDAO.getAllFacilityconfig();
										for (Facilityconfig facilityconfig : facilityconfigs) {
								%>
								<option value="<%=facilityconfig.getId()%>"><%=facilityconfig.getFacilityName()%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>


	</form>

</body>
</html>