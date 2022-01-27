<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/admin/users/upload" enctype="multipart/form-data" method="Post">
<input type="file" name="uploadfile"/>
<button>Submit</button>


</form>

</body>
</html>