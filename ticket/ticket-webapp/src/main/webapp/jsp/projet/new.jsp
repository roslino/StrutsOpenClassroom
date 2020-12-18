<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../_include/head.jsp" %>
</head>
<body>
	<s:actionerror/>
	<s:actionmessage/>

	<h2>Création d'un Projet</h2>
	
	<s:form action="projet_new">
		<s:textfield name="projet.nom" label="Nom" requiredLabel="true" />
		<s:select name="projet.responsable.id" label="Responsable" 
				  list="listUtilisateur" listKey="id" listValue="prenom" 
				  emptyOption="true" requiredLabel="true" />
	
		<s:checkbox name="projet.cloture" label="Cloture" />
		
		<s:submit value="OK" />
	</s:form>
</body>
</html>