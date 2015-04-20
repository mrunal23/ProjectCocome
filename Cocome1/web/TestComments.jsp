<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Web site Title & Description for Search Engine purposes -->
<title>Home Page</title>
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
<script src="includes/js/jquery-1.8.2.min.js"></script>
<script>
	function updateAnswerVotes(uniqueElement, type,answer_no) {
		debugger
		//var answer_no = document.getElementById("answer_no").value;
		//alert(answer_no);	
		//alert(type);
		
		$.ajax({
			type : "POST",
			url : "updateAnswerVotes?answer_no=" + answer_no + "&type=" + type,
		
			success : function(result) {
				//alert(result);
				if (type === "upvote")
					$(uniqueElement).find('label').html(result);
				else
					$(uniqueElement).find('label').html(result);
				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	</script>
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

		
		<div class="row" id="featuresHeading" class="panel-home-above-tiles">
			<div class="col-12">
				<h3>Answers</h3>

			</div>
		</div>
		<hr class="colorgraph">
		
		<div class="row clearfix">

			<ul class="timeline">
				<s:iterator value="answers" status="stat">
					
					<li>
						<!---Time Line Element--->
						<div class="timeline-badge up">
							<i class="fa fa-user"></i>
						</div>

						<div class="timeline-panel">

							<div class="row clearfix">
								<div class="col-md-6 col-xs-6 col-sm-6">
									<div class="timeline-heading">
										<h4 class="timeline-title">
											<s:label name="content" value="%{content}" theme="simple" />
										</h4>
									</div>



									<div class="timeline-body">
											

									</div>

								</div>
							</div>
							<div class="col-md-6 col-xs-6 col-sm-6">
								<ul class="list-inline list-unstyled">
								<li><s:property value="%{user.first_name}" /> <s:property value="%{user.last_name}" /></li>
									<li>|</li>
									<li><span><i class="glyphicon glyphicon-calendar"></i>
											<s:date name="%{timestamp}"
												format="dd-MMM-YYYY hh:mm:ss" /> </span></li>
									<li>|</li>
									<s:hidden value="%{answer_no}" id="answer_no" />
									<li><a href="#"  onClick="updateAnswerVotes(this,'upvote',<s:property value="%{answer_no}" />);"><span
							class="glyphicon glyphicon-thumbs-up"></span><span
							> <s:label id="answers[%{#stat.index}].upvote" value="%{upvote}" /></span></a></li>
									<li>|</li>
									<li><a href="#"  onClick="updateAnswerVotes(this,'downvote',<s:property value="%{answer_no}" />);"><span
							class="glyphicon glyphicon-thumbs-down"></span><span
							> <s:label id="answers[%{#stat.index}].downvote" value="%{downvote}" /></span></a></li>
									<li>
										<!-- Use Font Awesome http://fortawesome.github.io/Font-Awesome/ -->
										<span><i class="fa fa-facebook-square"></i></span> <span><i
											class="fa fa-twitter-square"></i></span> <span><i
											class="fa fa-google-plus-square"></i></span>
									</li>
								</ul>

							</div>

						</div>

					</li>
				</s:iterator>

			</ul>

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