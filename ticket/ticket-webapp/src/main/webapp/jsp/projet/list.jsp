<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../_include/head.jsp" %>
</head>
<body>
	<h2>Liste des projets</h2>
	
	<ul>
		<s:iterator value="listProjet">
			<li>
				<s:a action="projet_detail">
					<s:param name="id" value="id" />
					<s:property value="nom"/>
				</s:a>
				
				- Responsable :
				<s:a action="utilisateur_detail">
				<s:param name="id" value="responsable.id" />
				<s:property value="responsable.prenom" />
				<s:property value="responsable.nom"/>
				
				</s:a>
			</li>
		</s:iterator>
	</ul>
</body>
</html>