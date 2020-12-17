<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
    
<!DOCTYPE html>
<html>
<head>
	<%@ include file="_include/head.jsp" %>
</head>
<body>
	<!-- <h2>Bienvenue sur l'application Ticket utilisant Apache Struts !</h2> -->
	<h2>
		<s:text name="home.welcome"></s:text>
	</h2>
	
	<%--  <s:a action="projet_list">Liste des projets</s:a> --%>
	<s:a action="projet_list">
		<s:text name="nav.listProjet"></s:text>
	</s:a>
</body>
</html>