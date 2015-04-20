<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="s" uri="/struts-tags"%><%@ page
	import="com.opensymphony.xwork2.ActionContext"%><%@ page
	import="com.cocome.DAO.User"%><%@ page import="java.util.Map"%>

<!-- @Coded by Mrunal -->
<!-- Chat window for the user -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- @Coded by Mrunal -->
<!-- Chat window for the user -->
<html>
<head>

<!-- Website Title & Description for Search Engine purposes -->
<title>Chat Window</title>
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
	<div class="container" id="main">

		<div class="row clearfix"></div>
		<!-- ROW 2 TILES -->
		<div class="row" id="featuresHeading" class="panel-home-above-tiles">
			<div class="col-12">
				<h3 style="display: none;">Chat with Friends</h3>

				<%!Map session = ActionContext.getContext().getSession();
	User user = (User) session.get("user");
	//java.sql.Timestamp currentTimestamp;%>
				<div>
					<h4 style="display: none;">
						UUID is ::
						<s:property value="uuid" />
						<br>
					</h4>
					<h4>
						Chatting with
						<s:property value="chatWithUser" />
					</h4>
					<input type="hidden" id="chatwithuser"
						value="<s:property value="chatWithUser"/>" /> <br />
				</div>
				<div id="messages"
					style="margin-bottom: 20px; overflow: auto; max-width: 400px; max-height: 600px;">
					<div></div>
					<script id="messageTemplate" type="text/html">
				<div class="chat" style="min-width:150px;">
			  	<span style="color: #2C69BF;"></span>
				<div class="chatsender" style="font-size: 11px; font-style: italic;color: lightgrey;">
			  	
			  	</div>
		  		<div class="msgtime"  style="font-size: 11px; color: lightgrey;"></div>
				</div>				
			</script>

					<div class="hdnMessages" style="display: none">
						<s:iterator value="msg_from_user" var="mesg">
							<div class="servermsgs">
								<s:property value="#mesg.message" />
								#
								<s:property value="#mesg.last_send" />
								<br />
							</div>
						</s:iterator>
					</div>
				</div>
				<form class="msg .form-border-mm" style="max-width: 400px">
					<input type="hidden" name="chatWithUser" id="chatWithUser"
						value="<s:property value="chatWithUser"/>" /> <input type="hidden"
						name="uuid" id="uuid" value='<s:property value="uuid"/>' /> <input
						type="hidden" name="currentTimeStamp" id="currentTimeStamp"
						value="" /> <input type="hidden" name="message_id" id="message_id"
						value="<s:property value="message_id"/>" />
					<div class="form-group">
						<input type="text" id="msg_input" class="form-control"
							name="userMessage" maxlength="500" />
					</div>

					<div style="float: right">
						<button type="button" id="SendMsg">Send</button>
					</div>
				</form>

				<!-- Server responses get written here -->
				<br />
				<br />


			</div>
			<!-- end col-12 -->
		</div>






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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="web/includes/js/jquery-1.8.2.min.js"
		type="text/javascript"></script>
	<!-- Custom JS -->
	<script src="includes/js/script.js"></script>
	<script type="text/javascript">
		function PollMessage() {
			$
					.ajax({
						url : "fetchChatsOfUser",
						data : $('.msg').serialize(),
						success : function(data) {
							//console.log(data); 
							var jsonObj = JSON.parse(data);
							//console.log(jsonObj);	

							$
									.each(
											jsonObj,
											function(index, value) {

												var splitMsg = value.messages
														.split("~");
												console.log(value.messages);
												var sender = splitMsg[0];
												console.log("Ajax" + sender);
												var msgTimestampArray = splitMsg[1]
														.split("#");
												var message = msgTimestampArray[0];
												var time = msgTimestampArray[1];
												console.log("Ajax " + message);
												console.log("Ajax" + time);
												$('#message_id').val(
														value.lastId);
												var template = $(
														'#messageTemplate')
														.html();
												var phtml = $
														.parseHTML(template);

												$
														.each(
																phtml,
																function(i, v) {
																	var tag = $(
																			v)
																			.prop(
																					'tagName');
																	if (tag == "DIV") {
																		$(v)
																				.find(
																						'span')
																				.html(
																						message);
																		$(v)
																				.find(
																						'.chatsender')
																				.html(
																						sender);
																		$(v)
																				.find(
																						'.msgtime')
																				.html(
																						time);
																		//if chatWithUser is not equal to the sender here, float right
																		var chatwithuser = $(
																				"#chatwithuser")
																				.val();
																		if ($
																				.trim(chatwithuser) == $
																				.trim(sender)) {
																			$(
																					'#messages')
																					.append(
																							"<div style='margin-right:15px;float:left;border: solid 1px;border-radius: 4px;margin-top:5px;margin-bottom:5px;max-width:210px;padding: 5px;border-color: lightseagreen;'>"
																									+ $(
																											v)
																											.html()
																									+ "</div>");
																			$(
																					'#messages')
																					.append(
																							'<div style="clear:both;"></div>');
																			$(
																					"#messages")
																					.animate(
																							{
																								scrollTop : $(
																										document)
																										.height()
																							},
																							"slow");
																		} else {
																			$(
																					'#messages')
																					.append(
																							"<div style='margin-right:15px;float:right;border: solid 1px;border-radius: 4px;margin-top:5px;margin-bottom:5px;max-width:210px;padding: 5px;border-color: lightseagreen;'>"
																									+ $(
																											v)
																											.html()
																									+ "</div>");
																			$(
																					'#messages')
																					.append(
																							'<div style="clear:both;"></div>');
																			$(
																					"#messages")
																					.animate(
																							{
																								scrollTop : $(
																										document)
																										.height()
																							},
																							"slow");
																		}
																	}
																});

												/*
												$('#messages').append(value.messages + "<br/>");
												console.log($('#message_id'));
												console.log(jsonObj.lastId);
												$('#message_id').val(value.lastId);
												 */});
							setTimeout(PollMessage, 1000);
						}
					});
		}
		$(document)
				.ready(
						function() {

							$(".hdnMessages div.servermsgs")
									.each(
											function() {
												//Load all messages in the chat windows. 
												var value = $(this).html();
												var splitMsg = value.split("~");
												var sender = splitMsg[0];
												console.log("Sender is "
														+ sender);
												var msgTimestampArray = splitMsg[1]
														.split("#");
												var message = msgTimestampArray[0];
												var time = msgTimestampArray[1];
												console.log("Message is "
														+ message);
												console.log("Tiem is " + time);

												var template = $(
														'#messageTemplate')
														.html();
												var phtml = $
														.parseHTML(template);

												$
														.each(
																phtml,
																function(i, v) {
																	var tag = $(
																			v)
																			.prop(
																					'tagName');
																	if (tag == "DIV") {
																		$(v)
																				.find(
																						'span')
																				.html(
																						message);
																		$(v)
																				.find(
																						'.chatsender')
																				.html(
																						sender);
																		$(v)
																				.find(
																						'.msgtime')
																				.html(
																						time);
																		//if chatWithUser is not equal to the sender here, float right
																		var chatwithuser = $(
																				"#chatwithuser")
																				.val();
																		if ($
																				.trim(chatwithuser) == $
																				.trim(sender)) {
																			$(
																					'#messages')
																					.append(
																							"<div style='margin-right:15px;float:left;text-align:left;border: solid 1px;border-radius: 4px;margin-top:5px;margin-bottom:5px;max-width:210px;padding: 5px;border-color: lightseagreen;'>"
																									+ $(
																											v)
																											.html()
																									+ "</div>");
																			$(
																					'#messages')
																					.append(
																							'<div style="clear:both;"></div>');
																			$(
																					"#messages")
																					.animate(
																							{
																								scrollTop : $(
																										document)
																										.height()
																							},
																							"slow");
																		} else {
																			$(
																					'#messages')
																					.append(
																							"<div style='margin-right:15px;float:right;text-align:right;border: solid 1px;border-radius: 4px;margin-top:5px;margin-bottom:5px;max-width:210px;padding: 5px;border-color: lightseagreen;'>"
																									+ $(
																											v)
																											.html()
																									+ "</div>");
																			$(
																					'#messages')
																					.append(
																							'<div style="clear:both;"></div>');
																			$(
																					"#messages")
																					.animate(
																							{
																								scrollTop : $(
																										document)
																										.height()
																							},
																							"slow");
																		}
																	}
																});
											});

							$('#SendMsg')
									.click(
											function() {
												var textlength = document
														.getElementById("msg_input").value;
												if (textlength < 1) {
													alert("Text not entered..!")
												} else {
													$
															.ajax({
																url : "sendMessageToUser",
																type : "POST",
																data : $('.msg')
																		.serialize(),
																success : function(
																		result) {
																	//$('#messages').append("<p>" + result + "</p>");
																}
															});
												}
												document
														.getElementById("msg_input").value = "";
											});//on click of send message		       	
							//end of Poll message
							setTimeout(PollMessage, 1000);
						});//end of document.ready function
	</script>

</body>
</html>