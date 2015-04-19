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
<title>Home Page</title>
<meta name="description" content="">

<!-- Mobile viewport optimized -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Bootstrap CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="includes/css/bootstrap-glyphicons.css" rel="stylesheet">

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
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Services <strong class="caret"></strong></a>

						<ul class="dropdown-menu">
							<li><a href="#">Add something</a></li>

							<li><a href="#">Delete something</a></li>

							<li><a href="#">Edit something</a></li>

							<li class="divider"></li>

							<li class="dropdown-header">More Services</li>

						</ul> <!-- end dropdown-menu --></li>
				</ul>

				<form class="navbar-form pull-left">
					<input type="text" class="form-control"
						placeholder="Search this site..." id="searchInput">
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
							<li><a href="#"><span class="glyphicon glyphicon-wrench"></span>
									Settings</a></li>

							<li action="EditprofLoad"><a
								href=<s:url action="EditprofLoad"/>><span
									class="glyphicon glyphicon-refresh"></span> Update Profile</a></li>

							<li class="divider"></li>

							<li><a href="index.jsp"><span
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

		<div class="row panel">
			<div class="col-md-4 col-xs-4 col-sm-4 bg_blur ">
				
			</div>
			<div class="col-md-8 col-sm-8  col-xs-8">
				<img src="images/nkhetan.jpg"
					class="img-thumbnail picture hidden-xs" /> 
				<div class="header">
					<h1>
 						
					<s:property value="user.getFirst_name()"/>

					</h1>
					<h4><s:property value="user.getProfession()"/></h4>
 					<span><s:property value="user.getStatus()"/></span> 
				</div>
			</div>
		</div>

		<div class="row clearfix">
			



		</div>

		<div class="row" id="featuresHeading">
			<div class="col-12">
				<h2>My Dashboard</h2>
				<p class="lead">Put the status message of user here</p>
			</div>
			<!-- end col-12 -->
		</div>
		<!-- end featuresHeading -->
		<div class="row" id="features">
			<div class="col-sm-3 feature">
				<form role="form" action="callNewsfeedAction" method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">My Newsfeed</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-time glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Can add values here</p>

						<input value="Newsfeed" class="btn btn-warning btn-block"
							type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>
			<!-- end feature -->

			<div class="col-sm-3 feature">
				<form role="form" action="callTimelineAction" method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">My Timeline</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-list-alt glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Can add values here</p>

						<input value="Timeline" class="btn btn-warning btn-block"
							type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>
			<!-- end feature -->

			<div class="col-sm-3 feature">
				<form role="form" action="callSuggestedFriendsAction" method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">Suggested Friends</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-magnet glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Can add values here</p>

						<input value="View Suggested Friends"
							class="btn btn-warning btn-block" type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>

			<div class="col-sm-3 feature">
				<form role="form" action="callFriendsOnlineAction" method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">4 Friends Online</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-comment glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Can add values here</p>

						<input value="Chat" class="btn btn-warning btn-block"
							type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>
			<!-- end feature -->
		</div>
		<hr class="colorgraph">
		<div class="row" id="features">
			<div class="col-sm-3 feature">
				<form role="form" action="callSomething" method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">Something</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-plane glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Can add values here</p>

						<input value="Something" class="btn btn-warning btn-block"
							type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>
			<!-- end feature -->

			<div class="col-sm-3 feature">
				<form role="form" action="callViewDiscussionsAction" method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">Post A Discussion</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-glass glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Start a discussion</p>

						<input value="View Discussions" class="btn btn-warning btn-block"
							type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>
			<!-- end feature -->

			<div class="col-sm-3 feature">
				<form role="form" action="callPostQuestionAction" method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">Questions</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-bullhorn glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Can add values here</p>

						<input value="Post a Question" class="btn btn-warning btn-block"
							type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>

			<div class="col-sm-3 feature">
				<form role="form" action="viewUserPosts" method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">My Discussions</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-flag glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Can add values here</p>

						<input value="Start a Discussion"
							class="btn btn-warning btn-block" type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>

			<div class="col-sm-3 feature">
				<form role="form" action="callMyFriendsAction" method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">My Friends</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-flag glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Can add values here</p>

						<input value="See My Friends" class="btn btn-warning btn-block"
							type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>

			<div class="col-sm-3 feature">
				<form role="form" action="callFriendsNotificationAction"
					method="post">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">Friends Requests</h3>
						</div>
						<!-- end panel-heading -->
						<span class="glyphicon glyphicon-flag glyphicon-tiles"
							aria-hidden="true"></span>

						<p class="tile-notification-text">Can add values here</p>

						<input value="See Pending Requests"
							class="btn btn-warning btn-block" type="submit">
					</div>
				</form>
				<!-- end panel -->
			</div>

			<!-- end feature -->
		</div>
		<div class="row" id="moreInfo"></div>
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

	<!-- Bootstrap JS -->
	<script src="bootstrap/js/bootstrap.min.js"></script>

	<!-- Custom JS -->
	<script src="includes/js/script.js"></script>


</body>
</html>