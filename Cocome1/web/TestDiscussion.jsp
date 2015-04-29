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
<script src="includes/js/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/font-awesome.min.css" />
<script>
	function updateVotes(type) {

		var question_No = document.getElementById("question_No").value;
		//alert("Function entry");
		$.ajax({
			type : "POST",
			url : "updateVotes?question_No=" + question_No + "&type=" + type,
		
			success : function(result) {
				//alert(result);
				if(result==="upvoteFail")
					alert("The question was already up voted by you!!");
				else if(result==="downvoteFail")
					alert("The question was already down voted by you!!");
				else if(result.indexOf("Upvote")!=-1 && result.indexOf("Downvote")!=-1){
					var res=result.split(' ');
					//alert(res[1]);
					//alert(res[3]);
					$('#upvoteElement').html(res[1]);
					$('#downvoteElement').html(res[3]);
					
				}
				else if(result.indexOf("Upvote")!=-1){
					//alert("Correct");
					var res=result.split(" ");
					$('#upvoteElement').html(res[1]);
				}
				else{
					//alert("Incorrect");
					var res=result.split("|");
					$('#downvoteElement').html(res[1]);
				}
				
				
				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	
	function addComment(){
		var question_No = document.getElementById("question_No").value;
		var content=document.getElementById("comment").value;
		var totalComments=document.getElementById("noOfComments").innerText;
		
		$.ajax({
			type : "POST",
			url : "addComment?question_No="+question_No+"&comment="+content+"&no_of_answers="+totalComments,
			success : function(result) {
				
				$('#noOfComments').html(result);
				
				$('#comment').val('');
				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
			
		});
		
		
	}
</script>
<script>
function preventEnterPress(){
	if ($("#commentHref").children()[1].innerHTML == '0'){
		$("#commentHref").removeAttr("href");		
	}

	$('#comment').keypress(function(event) {
	    if (event.keyCode == 13) {
	        event.preventDefault();
	    }
	});
}


</script>
</head>
<body onload="preventEnterPress()">
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
	<div class="row" id="featuresHeading" class="panel-home-above-tiles">
			<div class="col-12">
				<h3>Answer the Question / Click on comments to see answers</h3>

			</div>
		</div>
		<hr class="colorgraph">
			<div class="row commentBox" id="posts">

		<div class="box">
			<div class="icon">
				<div class="image">
					<span class="glyphicon glyphicon-list-alt btn-lg white"></span>
				</div>
				<div class="info">
					<h3 class="title">
						<s:property value="%{content}" />
					</h3>
					
					<div class="text-center">

						<a href="#" name="upVote" onClick="updateVotes('upvote');"><span
							class="glyphicon glyphicon-thumbs-up"></span><span
							id="upvoteElement"> <s:property value="%{upvote}" /></span></a>
						<s:hidden value="%{question_No}" id="question_No" />
						<a href="#" name="downVote"
							onClick="updateVotes('downvote');"><span
							class="glyphicon glyphicon-thumbs-down"></span> <span
							id="downvoteElement"> <s:property value="%{downvote}" /></span></a>
							
						<a id="commentHref" href="viewComments?question_No=<s:property value='%{question_No}'/>""><span class="glyphicon glyphicon-comment"></span>
							<span id="noOfComments"><s:property value="%{no_of_answers}" /></span> Comments</a>
					</div>
					<form role="form">
						<div class="row customPadComment">
							<div class="col-xs-2 col-sm-2 col-md-2"></div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="text" name="comment" id="comment"
									class="form-control input-sm" placeholder="Add Comment" maxlength="500">
							</div>
							<div class="col-xs-2 col-sm-2 col-md-2">
								<input  type="button" value="Comment"
									class="btn btn-info btn-block" onClick="addComment();">
							</div>
							<div class="col-xs-2 col-sm-2 col-md-2"></div>
						</div>



					</form>
					<div class="more">
						<a  title="Title Link"><i class="fa fa-hand-o-up"></i>
							</a>
					</div>
				</div>
			</div>
		</div>
		<div class="space"></div>



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