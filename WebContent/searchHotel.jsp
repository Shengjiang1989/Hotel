<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="edu.neu.cs5200.hotel.main.service.*, edu.neu.cs5200.hotel.main.entity.*, java.util.*, edu.neu.cs5200.hotel.main.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find hotels</title>
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

	<form action="searchHotel.jsp" class="form-inline">
		<div class="header clearfix">
			<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header" align="center">
				<p class="navbar-brand">Find your hotels</p>
			</div>
			<div class="navbar-form navbar-right">
				<button type="submit" name="action" value="search"
					class="btn btn-success">Search</button>
				<a href=""><button type="button" class="btn btn-link"><u><%=customer.getUsername() %></u></button></a>
			</div>
			</nav>
		</div>

		<div class="jumbotron">
			<div class="container" class="row">
				<label>&nbsp;&nbsp;&nbsp;</label>


				<div class="row">
					<div class="col-xs-3">
						<input type="text" class="form-control" placeholder="Enter city"
							name="city">
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control"
							placeholder="Enter country" name="country">
					</div>
				</div>
				<div
					class="b-form-flexible-dates b-form-group b-form-group_subgroup ">
					<div class="b-form-flexible-dates__toggler b-checkbox">
						<label class="b-checkbox__container"> <input
							class="b-checkbox__element" type="checkbox" name="idf" /> <span
							class="b-checkbox__label"> I don't have specific dates yet
						</span>
						</label>
					</div>
				</div>
				<div class="b-form-group__content">
					<div
						class="b-form-date-selectors b-form-group b-form-group_subgroup  ">
						<div class="col-xs-3"
							class="b-form-checkin b-form-group b-form-group_subgroup b-form-group_inline "
							data-component="track" data-track="mouseenter"
							data-hash="bLNWBOaJSedZFNbQGNLHYO">
							<label class="b-form-group__title"> Check-in Date </label>
							<div class="b-form-group__controls b-date-selector"
								data-type="checkin">
								<div
									class="b-date-selector__control b-date-selector__control-datepicker b-datepicker"
									data-calendar2-type="checkin" id="first_calendar"
									data-calendar2-title="Check-in Date" type="button">
									<span class="b-datepicker__inner-text"></span>
								</div>
								<div
									class="b-date-selector__control b-date-selector__control-dayselector b-selectbox">
									<select name="checkin_monthday" class="b-selectbox__element">
										<option selected="selected" value="0">Day</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
									</select>
									<div
										class="b-date-selector__control b-date-selector__control-monthselector b-selectbox">
										<select name="checkin_year_month" class="b-selectbox__element">
											<option selected="selected" value="0">Month</option>
											<option class="b_months" value="2015-4">April 2015</option>
											<option class="b_months" value="2015-5">May 2015</option>
											<option class="b_months" value="2015-6">June 2015</option>
											<option class="b_months" value="2015-7">July 2015</option>
											<option class="b_months" value="2015-8">August 2015
											</option>
											<option class="b_months" value="2015-9">September
												2015</option>
											<option class="b_months" value="2015-10">October
												2015</option>
											<option class="b_months" value="2015-11">November
												2015</option>
											<option class="b_months" value="2015-12">December
												2015</option>
											<option class="b_months" value="2016-1">January 2016</option>
											<option class="b_months" value="2016-2">February
												2016</option>
											<option class="b_months" value="2016-3">March 2016</option>
											<option class="b_months" value="2016-4">April 2016</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-3"
							class="b-form-checkout b-form-group b-form-group_subgroup b-form-group_inline "
							data-component="track" data-track="mouseenter"
							data-hash="bLNWBOaJSedZFNbQGNLHYO">
							<label class="b-form-group__title"> Check-out Date </label>
							<div class="b-form-group__controls b-date-selector"
								data-type="checkout">
								<div
									class="b-date-selector__control b-date-selector__control-datepicker b-datepicker"
									data-calendar2-type="checkout"
									data-calendar2-title="Check-out Date" type="button">
									<span class="b-datepicker__inner-text"></span>
								</div>
								<div
									class="b-date-selector__control b-date-selector__control-dayselector b-selectbox">
									<select name="checkout_monthday" class="b-selectbox__element">
										<option selected="selected" value="0">Day</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
									</select>
								</div>
								<div
									class="b-date-selector__control b-date-selector__control-monthselector b-selectbox">
									<select name="checkout_year_month" class="b-selectbox__element">
										<option selected="selected" value="0">Month</option>
										<option class="b_months" value="2015-4">April 2015</option>
										<option class="b_months" value="2015-5">May 2015</option>
										<option class="b_months" value="2015-6">June 2015</option>
										<option class="b_months" value="2015-7">July 2015</option>
										<option class="b_months" value="2015-8">August 2015</option>
										<option class="b_months" value="2015-9">September
											2015</option>
										<option class="b_months" value="2015-10">October 2015</option>
										<option class="b_months" value="2015-11">November
											2015</option>
										<option class="b_months" value="2015-12">December
											2015</option>
										<option class="b_months" value="2016-1">January 2016
										</option>
										<option class="b_months" value="2016-2">February 2016</option>
										<option class="b_months" value="2016-3">March 2016</option>
										<option class="b_months" value="2016-4">April 2016</option>
									</select>
								</div>

							</div>

						</div>
					</div>

				</div>


			</div>
		</div>


		<%
			HotelManagementService hms = new HotelManagementService();
			List<Hotel> hotels = hms.getHotelBySearch(request);
			if (hotels != null && hotels.size() > 0) {
		%>
		<div class="jumbotron">
			<div class="container" class="row">
				<div class="container">
					<table class="table table-striped">
						<tr>
							<th align="center">Id</th>
							<th align="center">Name</th>
							<th align="center">City</th>
							<th align="center">Country</th>
							<th align="center">Description</th>
							<th align="center">Action</th>
							<th align="center">&nbsp;</th>
						</tr>
						<%
							for (Hotel hotel : hotels) {
						%>

						<tr>
							<td><%=hotel.getId()%></td>
							<td><%=hotel.getHotelName()%></td>
							<td><%=hotel.getCity()%></td>
							<td><%=hotel.getCountry()%></td>
							<td><%=hotel.getDescription()%></td>
							<td><a href="hotelInfo.jsp?id=<%=hotel.getId()%>">View</a>
							</td>
						</tr>
						<%
							}
							}
						%>
					</table>
				</div>
			</div>
		</div>
	</form>


</body>
</html>