<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Website Title & Description for Search Engine purposes -->
<title>View Others Questions</title>
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
<script src="includes/js/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/font-awesome.min.css" />
<script>
	function updateFlagValue(uniqueElement,flagValue,question_No) {

		//var question_No = document.getElementById("question_No").value;
		//alert("Function entry");
		$.ajax({
			type : "POST",
			url : "updateFlagValue?question_No=" + question_No + "&flagValue=" + flagValue,
		
			success : function(result) {
				if(flagValue===1){
					alert("Question Flagged for notification on any answers");
				}
				else{
					alert("Question Un-Flagged for notification on any answers");
				}
				
				
				
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

	<div class="container" id="container1">
		<s:iterator value="questions" status="stat">
			<div class="row commentBox margintopPosts" id="posts">

				<div class="box">
					<div class="icon">
						<div class="image">
							<span class="glyphicon glyphicon-list-alt btn-lg white"></span>
						</div>
						<div class="info">
							<h3 class="title">
								<a
									href="viewDiscussionThreadAction?question_No=<s:property value='%{question_No}'/>"><s:property
										value="%{content}" /></a>

							</h3>

							<div class="text-center">
								<div class="row">
									<div class="col-xs-2 col-sm-2 col-md-2">
										Topic:
										<s:label name="questions[%{#stat.index}].topic"
											value="%{topic}" theme="simple" />

									</div>
									<div class="col-xs-3 col-sm-3 col-md-3">
										Posted By:
										<s:label value="%{user.first_name} %{user.last_name}"
											theme="simple" />
									</div>
									<div class="col-xs-3 col-sm-3 col-md-3">
										Visibility:
										<s:label name="questions[%{#stat.index}].visibility"
											value="%{visibility}" theme="simple" />
									</div>
									<div class="col-xs-4 col-sm-4 col-md-4">
										Posted on:
										<s:date name="%{timestamp}" />
									</div>

								</div>
							</div>
							<hr>
							<div class="text-center">
								<div class="row radioButtonAdjust" >
									<div class="col-xs-2 col-sm-2 col-md-2">
									
									</div>
									<div class="col-xs-1 col-sm-1 col-md-1">
										<div class="radio">
											<label class="pull-right"><input type="radio" name="flagged" onClick="updateFlagValue(this,1,<s:property value="%{question_No}" />);"></label>
										</div>
									</div>
									<div class="col-xs-3 col-sm-3 col-md-3">
										<span class="pull-left radioAdjust">Flag for updates</span>
									</div>
									<div class="col-xs-1 col-sm-1 col-md-1">
										<div class="radio" >
											<label class="pull-right"><input type="radio" name="flagged" checked="checked" onClick="updateFlagValue(this,0,<s:property value="%{question_No}" />);"></label>
										</div>
									</div>
									<div class="col-xs-3 col-sm-3 col-md-3">
										<span class="pull-left radioAdjust">Un-Flag for updates</span>
									</div>
									<div class="col-xs-2 col-sm-2 col-md-2">
									
									</div>
									
									
								</div>
							</div>
							
							
							
							<!-- 					<form role="form"> -->
							<!-- 						<div class="row customPadComment"> -->
							<!-- 							<div class="col-xs-2 col-sm-2 col-md-2"></div> -->
							<!-- 							<div class="col-xs-6 col-sm-6 col-md-6"> -->
							<!-- 								<input type="text" name="comment" id="comment" -->
							<!-- 									class="form-control input-sm" placeholder="Add Comment"> -->
							<!-- 							</div> -->
							<!-- 							<div class="col-xs-2 col-sm-2 col-md-2"> -->
							<!-- 								<input type="button" value="Comment" -->
							<!-- 									class="btn btn-info btn-block" onClick="addComment();"> -->
							<!-- 							</div> -->
							<!-- 							<div class="col-xs-2 col-sm-2 col-md-2"></div> -->
							<!-- 						</div> -->



							<!-- 					</form> -->
							<div class="more">
								<a title="Title Link"><i class="fa fa-hand-o-up"></i> </a>
							</div>
						</div>
					</div>
				</div>
				<div class="space"></div>
			</div>
		</s:iterator>
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