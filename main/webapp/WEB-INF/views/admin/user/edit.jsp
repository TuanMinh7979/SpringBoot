<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User edit</title>

<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light px-5">
		<a class="navbar-brand" href="#">Navbar</a>

		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Users</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Categories</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Products</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="mt-5 col-10 offset-1">
		<form:form modelAttribute="userdto" method="Post"
			action="${ pageContext.request.contextPath }/users/update/1">
			<input type="hidden" name="_method" value="put" />
			<div class="form-group mt-3">
				<label for="username">Name</label>
				<form:input path="username" cssClass="form-control" />
				<form:errors path="username" element="span" cssClass="text-danger" />
			</div>
			<div class="form-group mt-3">
				<label for="email">Email</label>
				<form:input path="email" cssClass="form-control" />
				<form:errors path="email" element="span" cssClass="text-danger" />
			</div>
			<div class="form-group mt-3">
				<label for="password">Password</label>
				<form:password path="password" cssClass="form-control" />
				<form:errors path="password" element="span" cssClass="text-danger" />
			</div>
			<div class="form-group mt-3">
				<label for="admin">Role</label>
				<form:select path="admin" cssClass="form-control">
					<form:option value="1">Admin</form:option>
					<form:option value="0">Member</form:option>
				</form:select>
				<form:errors path="admin" element="span" cssClass="text-danger" />
				<%-- <select name="role" id="role" class="form-control" required>
					<option selected disabled>Choose</option>
					<option value="1" ${ user.role == 1 ? "selected" : "" }>User</option>
					<option value="2" ${ user.role == 2 ? "selected" : "" }>Admin</option>
				</select> --%>
			</div>
			<div class="form-group mt-3">
				<label for="photo">Image</label> <input type="file"
					value="${ user.photo }" class="form-control" id="photo"
					name="photo">
			</div>
			<div class="form-group mt-3">
				<label for="activated">Trạng thái</label> <select name="activated"
					id="activated" class="form-control" required>
					<option selected disabled>Choose</option>
					<option value="1" ${ user.activated == 1 ? "selected" : "" }>Đang
						hoạt động</option>
					<option value="0" ${ user.activated == 0 ? "selected" : "" }>Vô
						hiệu hóa</option>
				</select>
			</div>
			<div class="form-group mt-3">
				<button class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-danger">Clear</button>
			</div>
		</form:form>
	</div>

	<script src="${ pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script
		src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.min.js"></script>
	
</body>
</html>