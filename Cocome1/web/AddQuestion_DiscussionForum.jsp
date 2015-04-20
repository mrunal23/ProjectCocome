<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Website Title & Description for Search Engine purposes -->
<title>Post A Question</title>
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
	">
	<div class="container" id="container1">

		<div class="row">
			<form role="form" action="postQuestion" method="post">
				<div
					class="col-xs-12 col-sm-12 col-md-12 col-sm-offset-0 col-md-offset-0">
					<div class="panel panel-default">

						<div class="panel-heading">
							<h3 class="panel-title text-center">Submit your question</h3>
							<span class="glyphicon glyphicon-question-sign"></span>
						</div>

						<div class="panel-body">
							<form role="form">
								<div class="form-group">
									<input type="text" placeholder="Question" name="content"
										id="content" class="form-control input-sm">
								</div>

								<p>Topic tags :</p>


								<div class="panel-body">
									<ul class="list-group">
										<li class="list-group-item">
											<div class="checkbox">
												<label> <input type="checkbox" name="topic"
													value="Science"> Science
												</label>
											</div>
										</li>
										<li class="list-group-item">
											<div class="checkbox">
												<label> <input type="checkbox" name="topic"
													value="Politics"> Politics
												</label>
											</div>
										</li>
										<li class="list-group-item">
											<div class="checkbox">
												<label> <input type="checkbox" name="topic"
													value="Sports"> Sports
												</label>
											</div>
										</li>
										<li class="list-group-item">
											<div class="checkbox">
												<label> <input type="checkbox" name="topic"
													value="Health"> Health
												</label>
											</div>
										</li>
										<li class="list-group-item">
											<div class="checkbox">
												<label> <input type="checkbox" name="topic"
													value="Fiction"> Fiction
												</label>
											</div>
										</li>
									</ul>
								</div>

								<p>Visible to :</p>
								<div class="radio">
									<label><input type="radio" name="visibility"
										value="Friends">Friends </label>
								</div>
								<div class="radio">
									<label><input type="radio" name="visibility"
										value="Public">Public </label>
								</div>




								<input type="submit" value="Post Question"
									class="btn btn-info btn-block">
							</form>
						</div>
					</div>
				</div>
			</form>
		</div>

	</div>
	<!-- end container -->
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