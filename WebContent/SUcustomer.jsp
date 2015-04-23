<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.neu.cs5200.hotel.main.basedao.*,edu.neu.cs5200.hotel.main.dao.*,edu.neu.cs5200.hotel.main.entity.*, java.text.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"></head>
</head>
<body>
<div class="container">
	<%
	String action=request.getParameter("action");
	String first=request.getParameter("firstName");
	String last=request.getParameter("lastName");
	String pw=request.getParameter("password");
	String tele=request.getParameter("telephone");
	String un=request.getParameter("username");
	if("create".equals(action)){
	Customer customer = new Customer();
	customer.setFirstName(first);
	customer.setLastName(last);
	customer.setPassword(pw);
// 	String str_date="2015-04-08";
// 	DateFormat formatter ; 
// 	Date date = new Date(); 
// 	   formatter = new SimpleDateFormat("yyyy-MM-dd");
// 	   try {
// 		date = formatter.parse(str_date);
// 	} catch (ParseException e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	}
	customer.setRegDate(new Date());
	customer.setTelephone(tele);
	customer.setUsername(un);
	CustomerDAO dao=new CustomerDAO();
	dao.createCustomer(customer);
	}
	%>

	<h1>
	Sign Up for customer
	</h1>
		<form action="SUcustomer.jsp">
		<table class="table table-striped">
			<tr>
				<th>firstName</th>
				<th>lastName</th>
				<th>password</th>
				<th>telephone</th>
				<th>username</th>
				<th>&nbsp;</th>
		 	</tr>
		 	<tr>
		 		<td><input name="firstName" class="form-control"/></td>
		 		<td><input name="lastName" class="form-control"/></td>
		 		<td><input name="password" class="form-control"/></td>
		 		<td><input name="telephone" class="form-control"/></td>
		 		<td><input name="username" class="form-control"/></td>
		 		<td>
		 			<button class="btn btn-primary" type="submit" name="action" value="create">Create</button>
		 		
		 		</td>
		 	</tr>
				</table >
				
			
		</form>
</div>
				

</body>
</html>