<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Website Title & Description for Search Engine purposes -->
<title>Login Page</title>
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

							<li><a href="#"><span
									class="glyphicon glyphicon-refresh"></span> Update Profile</a></li>

							<li class="divider"></li>

							<li><a href="#"><span class="glyphicon glyphicon-off"></span>
									Sign out</a></li>
						</ul></li>
				</ul>
				<!-- end nav pull-right -->
			</div>
			<!-- end nav-collapse -->

		</div>
		<!-- end container -->
	</div>
	<!--end navbar  -->
	<form role="form" action="postQuestion" method="post">
	<div class="container" id="container1">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
				
					<div class="panel-heading">
						<h3 class="panel-title text-center">Submit your question</h3>
						<span class="glyphicon glyphicon-question-sign"></span>
					</div>
					
					<div class="panel-body">
						<form role="form">
							<div class="form-group">
								<input type="text" placeholder="Question" name="content" id="content"
									class="form-control input-sm" >
							</div>
							
									<p>Topic tags : </p>
							

							<div class="panel-body">
								<ul class="list-group">
									<li class="list-group-item">
										<div class="checkbox">
											<label> <input type="checkbox" name="topic" value="Science">
												Science
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox">
											<label> <input type="checkbox" name="topic" value="Politics">
												Politics
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox">
											<label> <input type="checkbox" name="topic" value="Sports">
												Sports
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox">
											<label> <input type="checkbox" name="topic" value="Health">
												Health
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox">
											<label> <input type="checkbox" name="topic" value="Fiction">
												Fiction
											</label>
										</div>
									</li>
								</ul>
							</div>

							<p>Visible to :</p>
							<div class="radio">
								<label><input type="radio" name="Friends">Friends
									</label>
							</div>
							<div class="radio">
								<label><input type="radio" name="Public">Public
									</label>
							</div>
							

							

							<input type="submit" value="Post Question"
								class="btn btn-info btn-block">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
	<style>
#container1 {
	background-color: #e2dada;
}

.centered-form {
	margin-top: 120px;
	margin-left: 300px;
	margin-right: 3000px margin-bottom: 120px;
}

.centered-form .panel {
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
</style>
</body>
</html>