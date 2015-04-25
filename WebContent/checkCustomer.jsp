<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.neu.cs5200.hotel.main.basedao.*,edu.neu.cs5200.hotel.main.dao.*,edu.neu.cs5200.hotel.main.entity.*,java.text.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"></head>
</head>
<body>
	<div class="container">
		<%
		CustomerDAO dao=new CustomerDAO();
		String action=request.getParameter("action");
		String idStr=request.getParameter("id");
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
		customer.setRegDate(new Date());
		customer.setTelephone(tele);
		customer.setUsername(un);
		dao.createCustomer(customer);
		}
		else if("delete".equals(action))
		{
			Integer id=Integer.parseInt(idStr);
			Customer custom=dao.getCustomerById(id);
			dao.deleteCustomerByUsername(custom);
		}
		List<Customer> customers=dao.getAllCustomer();
		
		%>
	<h1>Customer</h1>
		<form action="checkCustomer.jsp">
		<table class="table table-striped">
			<tr>
				<th>id</th>
				<th>firstName</th>
				<th>lastName</th>
				<th>password</th>
				<th>regDate</th>
				<th>telephone</th>
				<th>username</th>
				<th>&nbsp;</th>
		 	</tr>
		 	<tr>
		 		<td><input name="id" class="form-control"/></td>
		 		<td><input name="firstName" class="form-control"/></td>
		 		<td><input name="lastName" class="form-control"/></td>
		 		<td><input name="password" class="form-control"/></td>
		 		<td><input name="regDate" class="form-control"/></td>
		 		<td><input name="telephone" class="form-control"/></td>
		 		<td><input name="username" class="form-control"/></td>
		 		<td>
		 			<button class="btn btn-primary" type="submit" name="action" value="create">Create</button>
		 		
		 		</td>
		 	</tr>
		 	<%
			for(Customer customer:customers)
			{
		%> <tr>	
			<td>
				<a href="customerProfile.jsp?id=<%=customer.getId() %>">
			<%=customer.getId()%>
				</a>	
			</td>
			<td><%=customer.getFirstName()%></td>
			<td><%=customer.getLastName()%></td>
			<td><%=customer.getPassword()%></td>
			<td><%=customer.getRegDate()%></td>
			<td><%=customer.getTelephone()%></td>
			<td><%=customer.getUsername()%></td>
			<td>
				<a href="checkCustomer.jsp?action=delete&id=<%=customer.getId()%>"class="btn btn-danger">Delete</a>
			</td>
				</tr>
		<%	}
		%>
		
		</table >
		<a href="SignIn.jsp" >return</a>
		</form>
		</div>
		</body>
		</html>