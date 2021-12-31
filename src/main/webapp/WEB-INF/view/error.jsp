<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Error Details</title>
	</head>
	<body>
		<header>
			<h1>An Error Has Occurred</h1>
		</header>
		<section>
			<br>
			<hr>
			<br>
			<p>
				The server has encountered a problem that has prevented it from fulfilling the request.
			</p>
			<br>
			<hr>
			<br>
			<div>
				<a href="${pageContext.request.contextPath}/" target="_self">Home Page</a>
			</div>
		</section>
	</body>
</html>