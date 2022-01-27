<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">IT15306-UD</a>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">User</a>
				</li>
				<li class="nav-item active"><a class="nav-link" href="#">Post</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="at-5 border border-primary p-2">
	<form method="GET" action="${pageContext.request.contextPath}/users">
		<div class="row col 12">
			<div class="col-6">
				<label>Sắp xếp theo</label> <select name="sort_by">
					<option value="id">Mac dinh</option>
					<option value="username">Ho ten</option>
					<option value="email">Email</option>
					
				</select>
			</div>

			<div class="col-6">
				<label>Thu tu</label> <select name="sort_direction">
					<option value="asc">Tang dan</option>
					<option value="desc">Giam dan</option>
				</select>
			</div>
		</div>
		
		<button type="submit">Loc</button>
		<input class="btn btn-primary" type="reset" value="Reset">
		</form>

	</div>

	<div class="col-10 offset-1 mt-5">
		<div class="col-10 offset-1 mt-3">
			<a class="btn btn-success"
				href="${ pageContext.request.contextPath }/users/create">Create</a>
		</div>

		<div class="col-10 offset-1 mt-5">
			<table class="table table-strip table-dark">
				<thead>
					<tr>
						<td>Id</td>
						<td>Họ tên</td>
						<td>Email</td>
						<td>Avatar</td>
						<td>Trạng thái</td>
						<td>Phân quyền</td>
						<td colspan="2">Thao tác</td>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${ pageData.content }" var="user">
						<tr>
							<td>${ user.id }</td>
							<td>${ user.username }</td>
							<td>${ user.email }</td>
							<td>${ user.photo }</td>
							<td>${ user.activated == 1 ? "Đang hoạt động" : "Vô hiệu hóa" }</td>
							<td>${ user.admin == 1 ? "Admin" : "Member" }</td>
							<td><a class="btn btn-primary"
								href="${ pageContext.request.contextPath }/users/edit/${ user.id }">Update</a>
							</td>
							<td>
								<form
									action="${ pageContext.request.contextPath }/users/delete/${ user.id }"
									method="POST">
									<button class="btn btn-danger">Delete</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<ul class="pagination">
					<c:forEach begin="0" end="${pageData.totalPages -1}" varStatus="page">
						<li class="page-item">
							<a class="page-link" href="/users?page=${page.index}">${page.index}</a>
						</li>
					</c:forEach>

				</ul>
			</div>
			
			
		</div>
	</div>
</body>
</html>