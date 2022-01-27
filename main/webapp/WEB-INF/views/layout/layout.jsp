<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>
<div>
<!-- header -->
<div><tiles:insertAttribute name="header"></tiles:insertAttribute></div>
<!-- end header -->

<div class="row">
<!-- sidebar -->
<div class="col-2"><tiles:insertAttribute name="sidebar"></tiles:insertAttribute></div>
<!-- end sidebar -->

<!-- content -->
<div class="col-10"><tiles:insertAttribute name="content"></tiles:insertAttribute></div>
</div>
<!-- footer -->
<div><tiles:insertAttribute name="footer"></tiles:insertAttribute></div>
<!-- end footer -->


</body>
</html>