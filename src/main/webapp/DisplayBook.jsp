<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="reivax.norac.addressbook.model.*"%>

<%
	// RETRIEVE THE MAIN OBJECT
	Boolean isInError = (Boolean) request.getAttribute("isInError");
	Boolean addSuccess = (Boolean) request.getAttribute("addSuccess");
	Boolean removeSuccess = (Boolean) request.getAttribute("removeSuccess");
	List<Entry> bookList = (List<Entry>) request
			.getAttribute("book");
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
<script type="text/javascript" src="./bootstrap-3.2.0/js/activetab.js"></script>
<script type="text/javascript"
	src="./bootstrap-3.2.0/js/autocomplete.js"></script>
	
<script type="text/javascript">
	var activeTab = 0;
	<% 
	if(addSuccess!=null && addSuccess){
		%>
		activeTab = 1;
		<%
	} else if(removeSuccess!=null && removeSuccess){
		%>
		activeTab = 1;
		<%
	}
	%>
</script>

</head>
<body onload="setActiveTab(activeTab)">

	<div class="container">

		<div class="row">
			<div class="col-xs-12 col-sm-12">
				<div class="jumbotron shadow background-grey">
					<h1>My Address Book</h1>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<% if(isInError) {
				%>
				<div id="error_processing" class="alert alert-danger" role="alert">
					<strong>Oh snap!</strong> Something went wrong, sorry about that.
					Try the service again.
				</div>
				<%} %>
			</div>
		</div>

		<div class="margin20 row">
			<div class="col-xs-12">
				<ul class="nav nav-tabs nav-justified">
					<li id="search_tab" class="active"><a href="#search"
						role="tab" data-toggle="tab"><h1>
								<span class="glyphicon glyphicon-search"></span> Search
							</h1></a></li>
					<li id="manage_tab" ><a href="#manage"
						role="tab" data-toggle="tab"><h1>
								<span class="glyphicon glyphicon-pencil"></span> Manage
							</h1></a></li>
					<li id="compare_tab" ><a href="#compare"
						role="tab" data-toggle="tab"><h1>
								<span class="glyphicon glyphicon-eye-open"></span> Compare
							</h1></a></li>
				</ul>
			</div>
		</div>

		<div class="tab-content">
			<div class="tab-pane active" id="search">

				<div class="page-header">
					<h1>
						Search an Entry <small>By Name</small>
					</h1>
				</div>

				<div class="margin20 row">
					<div class="col-xs-12">
						<form role="form" action="SearchBookAction" id="book_search_form"
							name="book_search_form" method="post"
							onsubmit="return(validateSearchForm());"
							class="shadow padding20 margin20">
							<div class="input-group">
								<span class="input-group-addon">Input a name:</span> <input
									type="text" name="search_name" class="form-control"
									id="search_name" placeholder="i.e., Bob" value=""> <span
									class="input-group-btn">
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-search"></span> Search
									</button>
								</span>
							</div>
							<div id="error_form_search" class="alert alert-warning" role="alert"
							style="display: none">
							<p>
								<strong>Oh snap!</strong> Invalid form format, verify 
								that the input you enter is a name.
							</p>
							</div>
						</form>
					</div>
				</div>

				<hr>
				
				</div>
				
				<div class="tab-pane" id="compare">

				<div class="page-header">
					<h1>
						Compare with another Address Book <small>By Uploading a
							JSON File</small>
					</h1>
				</div>

				<div class="margin20 row">
					<div class="col-xs-12">
						<form role="form" action="CompareBookAction" id="book_compare_form"
							name="book_compare_form" method="post" enctype="multipart/form-data" 
							onsubmit="return(validateCompareForm());"
							class="shadow padding20 margin20">
							<div class="form-group">
								<label for="exampleInputFile">File input</label> <input
									type="file" id="inputFileCompare" name="file">
								<p class="help-block">
									The file must be a JSON file. A sample content example is:<br>
									<kbd>[ {"name": "Bob","phone": "04 78 211 007"}, {"name":
										"Luc","phone": "04 78 222 007"} ]</kbd>
								</p>
							</div>
							<button type="submit" class="btn btn-primary">
								<span class="glyphicon glyphicon-upload"></span> Submit
							</button>
							<div id="error_form_compare" class="alert alert-warning" role="alert"
							style="display: none">
							<p>
								<strong>Oh snap!</strong> Invalid form format, verify 
								that the file you try to upload is a JSON file.
							</p>
						</div>
						</form>
					</div>
				</div>

				<hr>
				
				</div>


			<div class="tab-pane" id="manage">

				<div class="page-header">
					<h1>Add a new Entry</h1>
				</div>

				<div class="margin20 row">
					<div class="col-xs-12">
						<form class="form-inline" role="form" action="AddBookAction"
							id="book_add_form" name="book_add_form" method="post"
							onsubmit="return(validateAddForm());"
							class="shadow padding20 margin20">
							<div class="input-group">
								<span class="input-group-addon">Input a name:</span> <input
									type="text" name="add_name" class="form-control"
									id="book_add_name" placeholder="i.e., Bob" value="">
							</div>
							<div class="input-group">
								<span class="input-group-addon">Input a phone nb:</span> <input
									type="text" name="add_phone" class="form-control"
									id="book_add_phone" placeholder="i.e., 04 88 211 007" value="">
							</div>
							<button type="submit" class="btn btn-primary">
								<span class="glyphicon glyphicon-plus"></span> Add
							</button>
							<div id="error_form_add" class="alert alert-warning" role="alert"
							style="display: none">
							<p>
								<strong>Oh snap!</strong> Invalid form format, verify 
								that the input you enter is a name and a number.
							</p>
							</div>
						</form>
					</div>
				</div>
				
				<%if(addSuccess!=null && addSuccess){ %>
					<div class="alert alert-success" role="alert">
						<strong>Record Successfully Added!</strong>
					</div>
				<%} else if(removeSuccess!=null && removeSuccess){ %>
					<div class="alert alert-success" role="alert">
						<strong>Record Successfully Removed!</strong>
					</div>
				<%} %>
						
				<hr>

				<div class="page-header">
					<h1>Address Book Content</h1>
				</div>

				<div class="row">
					<div class="col-xs-12 ">
						<div id="list_places">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Name</th>
										<th>Phone</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<%for(int i=0; i<bookList.size(); i++){ 
						Entry e = bookList.get(i);
						%>
									<tr id="entry_<%=i%>">
										<td><%=e.getName() %></td>
										<td><%=e.getPhone() %></td>
										<td>
											<form class="form-inline" role="form" action="RemoveBookAction"
												id="book_remove_form"method="post">
												<input type="text" id="remove_id" name="remove_id"
													value="<%=e.getId()%>" style="visibility: hidden" />
												<button type="submit" class="btn btn-danger">
													<span class="glyphicon glyphicon-remove"></span> Delete
												</button>
											</form>
										</td>
									</tr>
									<%} %>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<hr>
				
				</div>

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
