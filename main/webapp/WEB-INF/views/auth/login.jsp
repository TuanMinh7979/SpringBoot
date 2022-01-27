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
	<div class="col-10 offset-1">
		<c:if test="${not empty sessionScope.error }">
		<div class="alert alert-danger">${sessionScope.error}</div>
		<c:remove var="error" scope="session"/>	
		</c:if>
		<div>
			<form method="post" action="${pageContext.request.contextPath}/login">
			<div>
			<label>Email</label>
			<input type="email" name="email" id="email"/>
			</div>
			
			<div>
			<label>Password</label>
			<input type="password" name="password" id="password"/>
			</div>
			<div>
			<button class="btn btn-primary"> Login </button>
			</div>
			</form>
		</div>
	</div>

</body>
</html>