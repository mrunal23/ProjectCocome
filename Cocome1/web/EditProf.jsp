<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Website Title & Description for Search Engine purposes -->
<title>Edit Profile Page</title>
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
						<li class="active"><a href="home.jsp">Home</a></li>

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
								<li><a href="#"><span
										class="glyphicon glyphicon-wrench"></span> Settings</a></li>

								<li><a href="#"><span
										class="glyphicon glyphicon-refresh"></span> Update Profile</a></li>

								<li class="divider"></li>

								<li><a href="index.jsp"><span class="glyphicon glyphicon-off"></span>
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
		<div class="container" id="main">

				<form role="form" action="EditprofUpdate" method="post">
					<fieldset>
						<h2>Edit Profile</h2>
						<hr class="colorgraph">
						<div class="row">
						<div class="form-group col-xs-3 col-sm-3 col-md-3">
							<input name="user.first_name" id="fstname" class="form-control input-lg" placeholder="First Name">
						</div>
						<div class="form-group col-xs-3 col-sm-3 col-md-3">
							<input name="user.last_name" id="lstname" class="form-control input-lg" placeholder="Last Name">
						</div>
						</div>
						<div class="row">
						<div class="form-group col-xs-6 col-sm-6 col-md-6">
							<input name="user.user_id" id="email" class="form-control input-lg" placeholder="Email Address" type="email">
						</div>
						</div>
						<div class="row">
						<div class="form-group col-xs-3 col-sm-3 col-md-3">
							<input name="user.phone_number" id="phone" class="form-control input-lg" placeholder="Phone number">
						</div>
						</div>
						<div class="row">
		                            <div class="form-group col-xs-2 col-sm-2 col-md-2">
		  								<select class="form-control dropdown" name="user.gender" id="gender">
		    									<option value="Male">Male</option><option value="Female">Female</option>
		  								</select>
		  							</div>
		                            <div class="form-group col-xs-2 col-sm-2 col-md-2">
		  								<select class="form-control dropdown" name="user.rel_stat" id="rel_stat">
		    								<option value="">Relationship Sta..</option><option value="Single">Single</option><option value="Committed">Committed</option>
		  								</select>
		  							</div>
		  				</div>
		  				<div class="row">
						<div class="form-group col-xs-4 col-sm-4 col-md-4">
							<input name="user.profession" id="profession" class="form-control input-lg" placeholder="Profession">
						</div>
						<div class="form-group col-xs-4 col-sm-4 col-md-4">
							<input name="user.education" id="edu" class="form-control input-lg" placeholder="Education">
						</div>
						<div class="form-group col-xs-4 col-sm-4 col-md-4">
							<input name="user.location" id="location" class="form-control input-lg" placeholder="Location">
						</div>
						</div>
						<div class="row">
						<div class="form-group col-xs-10 col-sm-10 col-md-10">
							<input name="user.hobby" id="interest" class="form-control input-lg" placeholder="Interests (comma seperated)">
						</div>
						</div>
						<div class="row">
						<div class="form-group col-xs-12 col-sm-12 col-md-12">
						  <textarea name="user.about_me" class="form-control" rows="5" id="about" placeholder="About Me"></textarea>
						</div>
						</div>
						<div class="row">
						<div class="form-group col-xs-6 col-sm-6 col-md-6">
							<input name="user.linkedin_handle" id="lnkdin" class="form-control input-lg" placeholder="LinkedIn Handle">
						</div>
						</div>
						<hr class="colorgraph">
						<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3">
									<input class="btn btn-lg btn-success btn-block" value="Update"
										type="submit">
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a href="RegisterNew.jsp" class="btn btn-lg btn-primary btn-block">Cancel</a>
								</div>
						</div>
					</fieldset>
				</form>
		</div>
		<br/>
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
	
	<script type="text/JavaScript">
	
			
		document.getElementById("fstname").value='<s:property value="user.first_name"/>';
		document.getElementById("lstname").value='<s:property value="user.last_name"/>';
		document.getElementById("email").value='<s:property value="user.user_id"/>';
		document.getElementById("phone").value='<s:property value="user.phone_number"/>';
		document.getElementById("gender").value='<s:property value="user.gender"/>';
		document.getElementById("rel_stat").value='<s:property value="user.rel_stat"/>';
		document.getElementById("profession").value='<s:property value="user.profession"/>';
		document.getElementById("edu").value='<s:property value="user.education"/>';
		document.getElementById("location").value='<s:property value="user.location"/>';
		document.getElementById("interest").value='<s:property value="user.hobby"/>';
		document.getElementById("about").value='<s:property value="user.about_me"/>';
		document.getElementById("lnkdin").value='<s:property value="user.linkedin_handle"/>';
			
  </script>

	<!-- Bootstrap JS -->
	<script src="bootstrap/js/bootstrap.min.js"></script>

	<!-- Custom JS -->
	<script src="includes/js/script.js"></script>
</body>
</html>