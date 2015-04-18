<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Successful</title>
<s:head />
</head>
<body>
	File Name :
	<s:property value="toBeUploadedFileName"></s:property><br>
	Content type:
	<s:property value="toBeUploadedContentType"></s:property><br>
	User file :
	<s:property value="toBeUploaded"></s:property><br>
	Uploaded file:
<%-- 	<img src="<s:property value="toBeUploadedFileName"/>"></img> --%>
	<img src="<s:property value="toBeUploadedFileName"></s:property>" pagespeed_url_hash="3810261691" onload="pagespeed.CriticalImages.checkImageForCriticality(this);">"/>
 
</body>
</html>