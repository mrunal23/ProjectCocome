<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="includes/css/bootstrap-glyphicons.css" rel="stylesheet">

<title>My Posts</title>
</head>
<body>
	
		<table class="table table-striped table-bordered">
			<thead>
				<tr class="info">
					<th>Question</th>
					<th>Topic</th>
					<th>Visibility</th>
					<th>Date</th>


				</tr>
			</thead>
			<tbody>
				<s:iterator value="questions" status="stat">
					<tr>
						<td class="success">
							<%-- <s:a
								name="question_no" href="javascript:;" onclick="document.getElementById('form1').submit();"
								theme="simple">
								<s:property value="%{content}" />
							</s:a> --%>
							<a href="viewDiscussionThreadAction?question_No=<s:property value='%{question_No}'/>"><s:property value="%{content}" /></a>
							
							
							</td>
						<td class="warning">
							<s:label
								name="questions[%{#stat.index}].topic" value="%{topic}"
								theme="simple" /></td>
						

						<td class="active"><s:label
								name="questions[%{#stat.index}].visibility"
								value="%{visibility}" theme="simple" /></td>
						<td class="danger"><s:date name="%{timestamp}"
								format="dd-MMM-YYYY hh:mm:ss a" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	
</body>
</html>