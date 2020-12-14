<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h4>Contact Info</h4>
			</div>
			<div class="card-body">
				<form:form action="saveContact" method="POST"
					modelAttribute="contact">
					<form:hidden path="contactId" />

					<div class="row">
						<div class="col-3">Contact Name</div>
						<div class="col-5">
							<form:input path="contactName" class="form-control" placeholder="Please Enter Name"/>
						<br></div>
					</div>

					<div class="row">
						<div class="col-3">Contact Number</div>
						<div class="col-5">
							<form:input path="contactNumber" class="form-control" placeholder="Please Enter Contact Number"/>
						<br></div>
					</div>

					<div class="row">
						<div class="col-3">Contact Email</div>
						<div class="col-5">
							<form:input path="contactEmail" class="form-control"  placeholder="Please Enter Email"/>
					<br>	</div>
					</div>
            <div class="col-10 text-center">		
            	<input type="submit" value="Submit" class="btn btn-success btn-center"/>
	              </div>
							<div>
						<a href="viewContacts" class="btn btn-info">View All Contacts</a>
					</div>
				</form:form>
			</div>
		</div>
		<div class="card-footer bg-white">
			<font color="blue">${succMsg}</font> <font color="red">${errMsg}</font>
		</div>
	</div>
</body>
</html>