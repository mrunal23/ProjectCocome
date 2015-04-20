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
				
				<!-- end nav pull-right -->
			</div>
			<!-- end nav-collapse -->

		</div>
		<!-- end container -->
	</div>
	<!--end navbar  -->
	<div class="container" id="main">
		<div class="row clearfix">

			<div class="col-xs-8 col-sm-8 col-md-8">

				<div class="carousel slide" id="carousel-558858">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-558858"></li>
						<li data-slide-to="1" data-target="#carousel-558858"></li>
						<li data-slide-to="2" data-target="#carousel-558858"></li>


					</ol>

					<div class="carousel-inner">
						<div class="item active">
							<img alt=""
								src="http://i291.photobucket.com/albums/ll317/smellycat206/FriendsWall/Friends-med1.jpg">
							<div class="carousel-caption">
								<h3>Friends are best</h3>
								<p>---------------------------------- Walking with a friend
									in dark is better than walking alone in
									light.----------------------------------</p>
							</div>
						</div>

						<div class="item">
							<img alt=""
								src="http://static.hdw.eweb4.com/media/wallpapers_1920x1200/world/1/4/hong-kong-world-hd-wallpaper-1920x1200-39927.jpg">
							<div class="carousel-caption">
								<h3>Welcome to Beta Version</h3>
								<p>We team Cocome welcome you to the social network. You can
									connect, You can like, dislike, upvote, downvote. Well more
									that that you can ask questions. So we give you Fb, Quora,
									Twitter all in one.. Keep looking for upcoming developments.
									Hope you have nice time at Cocome</p>
							</div>
						</div>

						<div class="item">
							<img alt=""
								src="http://www.4shared.com/download/0-PQ0bZkce/Lego.jpg?lgfp=3000">
							<div class="carousel-caption">
								<h3>Advertisement : Lego</h3>
								<p>Emmet, an ordinary LEGO figurine who always follows the
									rules, is mistakenly identified as the Special an extraordinary
									being and the key to saving the world.</p>
							</div>
						</div>
					</div>

					<a class="left carousel-control" href="#carousel-558858"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-558858"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
			<div class="col-xs-4 col-sm-4 col-md-4">

				<form role="form" action="loginaction" method="post">
					<fieldset>
						<h2>Please Sign In</h2>
						<hr class="colorgraph">
						<div class="form-group">
							<input name="login.user_id" id="user_id"
								class="form-control input-lg" placeholder="Email Address"
								type="email" required />

						</div>
						<div class="form-group">
							<input name="login.password" id="password"
								class="form-control input-lg" placeholder="Password"
								type="password" required />

						</div>
						<a href=<s:url action="forgotpassword"/>
							class="btn btn-link pull-right">Forgot Password?</a> <br />
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input class="btn btn-lg btn-success btn-block" value="Login"
									type="submit">
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<a href="RegisterNew.jsp"
									class="btn btn-lg btn-primary btn-block">Register</a>
							</div>
						</div>
					</fieldset>
				</form>

			</div>
		</div>

		<div class="row" id="featuresHeading"></div>
		<div class="row" id="features"></div>
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