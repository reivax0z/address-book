<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="reivax.norac.addressbook.model.*"%>

<%
	// RETRIEVE THE MAIN OBJECT
	Boolean isInError = (Boolean) request.getAttribute("isInError");
	List<Entry> matchedNames = (List<Entry>) request
			.getAttribute("matchedNames");
	List<Entry> closeNames = (List<Entry>) request
			.getAttribute("closeNames");
	String searchedName = (String) request.getAttribute("searchedName");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="title" content="Address Book">
<meta name="description" content="My address book">
<meta name="keywords" content="Address Book">
<meta name="author" content="Xavier CARON">

<title>Address Book</title>

<!-- CSS -->
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<link href="./bootstrap-3.2.0/dist/css/bootstrap.css" rel="stylesheet">

<!-- JQUERY -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.js"></script>

<!-- BOOTSTRAP -->
<script type="text/javascript"
	src="./bootstrap-3.2.0/dist/js/bootstrap.js"></script>

<!-- MY JS FILES -->
<script type="text/javascript" src="./bootstrap-3.2.0/js/formchecker.js"></script>
</head>
<body>

	<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container">
	      <div class="container-fluid">
	        <div class="navbar-header">
	          <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user"></span> Address Book</a>
	        </div>
	        <div class="collapse navbar-collapse">
	          <p class="navbar-text navbar-right">Search, Manage and Compare!</p>
	        </div>
	      </div>
    	</div>
    </nav>

	<div class="container">

		<div class="margin20 row">
			<div class="col-xs-12">
				<h1>
					<a href="./Book"> <span class="glyphicon glyphicon-home"></span>
						Home
					</a>
				</h1>
			</div>
		</div>

		<div class="page-header">
					<h1>
						Search an Entry <small>Results for "<%=searchedName %>"</small>
					</h1>
				</div>

				<div class="page-header">
					<h3>
						Results <small>Exact match</small>
					</h3>
				</div>

				<div class="row">
					<div class="col-xs-12 ">
						<div id="list_places">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Name</th>
										<th>Phone</th>
									</tr>
								</thead>
								<tbody>
									<%for(int i=0; i<matchedNames.size(); i++){ 
									Entry e = matchedNames.get(i);
									%>
									<tr id="entry_<%=i%>">
										<td><%=e.getName() %></td>
										<td><%=e.getPhone() %></td>
									</tr>
									<%} %>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<hr>
				
				<div class="page-header">
					<h3>
						Results <small>Close match</small>
					</h3>
				</div>

				<div class="row">
					<div class="col-xs-12 ">
						<div id="list_places">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Name</th>
										<th>Phone</th>
									</tr>
								</thead>
								<tbody>
									<%for(int i=0; i<closeNames.size(); i++){ 
									Entry e = closeNames.get(i);
									%>
									<tr id="entry_<%=i%>">
										<td><%=e.getName() %></td>
										<td><%=e.getPhone() %></td>
									</tr>
									<%} %>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<hr>
				
				<footer>
				<p class="pull-right">
					<a href="#">Back to top</a>
				</p>
				<p>
					© <a href="http://www.linkedin.com/in/xavierwilfriddimitrycaron"
						target="_blank"><b>Xavier CARON</b></a>, 2014
				</p>
				</footer>

			</div>
			<!--/.container--></body>
</html>
