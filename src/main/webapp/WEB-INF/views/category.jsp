<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>infographyl</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

	<link href="/css/mystyles.css" rel="stylesheet" type="text/css" />

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">infographyl</a>
			</div>
			<!-- <div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">home</a></li>
				</ul>
			</div> -->
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/category/technology">technology</a></li>
				</ul>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/category/food">food</a></li>
				</ul>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/category/health">health</a></li>
				</ul>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/category/travel">travel</a></li>
				</ul>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/category/history">history</a></li>
				</ul>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/category/lifehack">lifehack</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container mycontainer">
		<h1 class="title">infographyl<small>:${categoryId}</small></h1>
		<h2 class="subtitle">feed the mind</h2>

		<table>
			<tr>
				<c:forEach items="${igList}" var="item" varStatus="i">
				<c:if test="${not i.first and i.index % 4 == 0}">
			</tr><tr>
		</c:if>
		<div class="col-sm-3">
			<a href="/view/${igList[i.index].id}" class="thumbnail">
					<!-- <div class="caption">
						${igList[i.index].name}
					</div> -->
					<div class="image">
						<img src="${igList[i.index].url}" class="img img-responsive full-width" alt="${igList[i.index].name}" width="300" height="300"/>
					</div>
				</a>
			</div>
		</c:forEach>
	</tr>
</table>
</div>

</body>
</html>
