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

	<div class="container" id="main">
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
</body>
</html>