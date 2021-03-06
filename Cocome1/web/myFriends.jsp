<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="com.cocome.DAO.User"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Website Title & Description for Search Engine purposes -->
<title>My Friends</title>
<meta name="description" content="">

<!-- Mobile viewport optimized -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Bootstrap CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="includes/css/bootstrap-glyphicons.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/font-awesome.min.css" />
<!-- Custom CSS -->
<link href="includes/css/styles.css" rel="stylesheet">

<!-- Include Modernizr in the head, before any other Javascript -->
<script src="includes/js/modernizr-2.6.2.min.js"></script>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="container">

			<!-- .btn-navbar is used as the toggle for collapsed navbar content -->
			<button class="navbar-toggle"
				data-target=".navbar-responsive-collapse" data-toggle="collapse"
				type="button">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="/"><img src="images/logo.png"
				alt="Your Logo"></a>

			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav navbar-nav homeFontWeight">
					<li><a href=<s:url action="LoadProfile"/>>Home</a></li>

				</ul>

				<form class="navbar-form pull-left searchMarginLeft"
					action="searchUser">
					<input type="text" class="form-control"
						placeholder="Enter First Name..." id="searchInput"
						name="searchInput">
					<button type="submit" class="btn btn-default">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
				<!-- end navbar-form -->

				<ul class="nav navbar-nav pull-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
							My Account <strong class="caret"></strong></a>

						<ul class="dropdown-menu">
							<li><a href=<s:url action="AccountSettingsLoad"/>><span
									class="glyphicon glyphicon-wrench"></span> Account Settings</a></li>

							<li action="EditprofLoad"><a
								href=<s:url action="EditprofLoad"/>><span
									class="glyphicon glyphicon-refresh"></span> Update Profile</a></li>

							<li class="divider"></li>

							<li><a href=<s:url action="signout"/>><span
									class="glyphicon glyphicon-off"></span> Sign out</a></li>
						</ul></li>
				</ul>
				<!-- end nav pull-right -->
			</div>
			<!-- end nav-collapse -->

		</div>
		<!-- end container -->
	</div>
	<!--end navbar  -->
	<div class="container" id="main">
		<div class="row clearfix">
			<nav class="navbar navbar-default friendsPanelnavbar">
			<div class="container-fluid">
				<div class="navbar-header">
					<h4 class="friendsPanelFont">
						<s:property value="user.getFirst_name()"/>
						has 
						<s:property value="user.getCount_of_friends()"/>
						Friends
					</h4>
				</div>
			</div>
			</nav>
		</div>





		<div class="row" id="friendsTiles">

			<s:iterator value="friends" status="stat">
				<div class="col-md-12 friends-bar" onclick="location.href='ViewFriendsProfile?friend_id=<s:property value='%{user.user_id}'/>'">
					<div class="well well-sm ">
						<div class="row">
							<div class="col-xs-3 col-md-3 col-sm-3 text-center">
								<span class="glyphicon glyphicon-user glyph-user-style"></span>
							</div>
							<div class="col-xs-9 col-md-9 col-xs-9 section-box">
								<h4>
									<s:label name="friends[%{#stat.index}].user.first_name"
										value="%{user.first_name}" theme="simple" />
									<s:label name="friends[%{#stat.index}].user.last_name"
										value="%{user.last_name}" theme="simple" />
									<a href="http://bootsnipp.com/" target="_blank"><span
										class="glyphicon glyphicon-new-window"> </span></a>
								</h4>
								<hr />
								<p>
									<s:label name="friends[%{#stat.index}].user.location"
										value="%{user.location}" theme="simple" />
									|
									<s:label name="friends[%{#stat.index}].user.about_me"
										value="%{user.about_me}" theme="simple" />
								</p>


							</div>
						</div>
					</div>
				</div>
			</s:iterator>
		</div>

	</div>
	<div class="row" id="moreCourses"></div>
	</div>
	<!-- end container  -->
	<!-- 	<form action="loginaction" method="post"> -->
	<!-- 		User:<br /> <input type="text" name="user" /><br /> Password:<br /> -->
	<!-- 		<input type="password" name="password" /><br /> <input type="submit" -->
	<!-- 			value="Login" /> -->
	<!-- 	</form> -->
	<footer class="footer">
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<h6>Copyright &copy; 2015 Team Cocome</h6>
			</div>
			<!-- end col-sm-4 -->



			<div class="col-sm-3">
				<h6>
					Coded with <span class="glyphicon glyphicon-heart"></span> by
					Nihar, Bipra, Satvik, Mrunal
				</h6>
			</div>
			<!-- end col-sm-4 -->
		</div>
		<!-- end row -->
	</div>
	<!-- end container --> </footer>

	<!-- All Javascript at the bottom of the page for faster page loading -->

	<!-- First try for the online version of jQuery-->
	<script src="http://code.jquery.com/jquery.js"></script>

	<!-- If no online access, fallback to our hardcoded version of jQuery -->
	<script>
		window.jQuery
				|| document
						.write('<script src="includes/js/jquery-1.8.2.min.js"><\/script>')
	</script>
	<script>
		$(document).ready(function() {
			$('#Carousel').carousel({
				interval : 5000
			})
		});
	</script>
	<!-- Bootstrap JS -->
	<script src="bootstrap/js/bootstrap.min.js"></script>

	<!-- Custom JS -->
	<script src="includes/js/script.js"></script>


</body>
</html>