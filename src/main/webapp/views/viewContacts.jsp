<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="confirmDelete().js"></script>
	
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function confirmDelete() {
		return confirm("Are you sure,you want to delete");
	}
</script>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center ">
				<h3>All Contacts</h3>
			</div>
			<div class="card-body">

				<table class="table table-hover ">
					<thead>
						<tr>
							<th>Contact Name</th>
							<th>Contact Number</th>
							<th>Contact Email</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${contacts}" var="c">
							<tr>
								<td>${c.contactName}</td>
								<td>${c.contactNumber}</td>
								<td>${c.contactEmail}</td>
								<td><a href="edit?cid=${c.contactId}">Edit</a> &nbsp; <a
									href="delete?cid=${c.contactId}"
									onclick="return confirmDelete()">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div><br>
		<div>
			<a href="loadForm" class="btn btn-info">+Add New Contact</a>
		</div>

	</div>

</body>
</html>