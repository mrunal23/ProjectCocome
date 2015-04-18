<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<div class="container" id="main">
		<div class="row clearfix">


			<div class="qa-message-list" id="wallmessages">

				<s:iterator value="newsfeeds" status="stat">
				<div class="message-item" id="m16">
				
					<div class="message-inner">
						<div class="message-head clearfix">
							<div class="avatar pull-left">
								<a href="./index.php?qa=user&qa_1=Oleg+Kolesnichenko"><img
									src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png"></a>
							</div>
							<div class="user-detail">
								<h5 class="handle">
									<s:label name="newsfeeds[%{#stat.index}].type_of_feed"
										value="%{type_of_feed}" theme="simple" />
								</h5>
								<div class="post-meta">
									<div class="asker-meta">
										<span class="qa-message-what"></span> <span
											class="qa-message-when"> <span
											class="qa-message-when-data"><s:label
													name="newsfeeds[%{#stat.index}].date" value="%{date}" theme="simple" /></span>
										</span> <span class="qa-message-who"> <span
											class="qa-message-who-pad">by </span> <span
											class="qa-message-who-data"><a><s:label
														name="newsfeeds[%{#stat.index}].posted_by"
														value="%{posted_by}" theme="simple"  /></a></span>
										</span>
									</div>
								</div>
							</div>
						</div>
						<div class="qa-message-content">
							<s:label name="newsfeeds[%{#stat.index}].content"
								value="%{content}" theme="simple"  />
						</div>
						<form role="form">
							<div class="row customPadComment">
								<div class="col-xs-4 col-sm-4 col-md-4">
									<div class="text-center">
										<div class="row">
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a class="like" href="#"><span
													class="glyphicon glyphicon-thumbs-up"></span> <s:label
														name="newsfeeds[%{#stat.index}].likes_count"
														value="%{likes_count}" theme="simple"  /> likes</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a class="dislike" href="#"><span
													class="glyphicon glyphicon-thumbs-down"></span> <s:label
														name="newsfeeds[%{#stat.index}].dislikes_count"
														value="%{dislikes_count}" theme="simple"  /> dislikes</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a class="comments" href="#"><span
													class="glyphicon glyphicon-comment"></span> <s:label
														name="newsfeeds[%{#stat.index}].comment_count"
														value="%{comment_count}" theme="simple"  /> comments</a>
											</div>
										</div>


									</div>

								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<input type="text" name="comment" id="comment"
										class="form-control input-sm" placeholder="Add Comment">
								</div>
								<div class="col-xs-2 col-sm-2 col-md-2">
									<input type="submit" value="Comment"
										class="btn btn-info btn-block">
								</div>

							</div>



						</form>
					</div>
					
				</div>


				</s:iterator>
			</div>





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