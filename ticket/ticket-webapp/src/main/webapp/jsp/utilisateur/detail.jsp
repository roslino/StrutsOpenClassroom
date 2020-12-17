<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../_include/head.jsp" %>
</head>
<body>
    <h2>Détail de l'utilisateur</h2>

    <ul>
        <li>ID : <s:property value="utilisateur.id" /></li>
        <li>Nom : <s:property value="utilisateur.nom" /></li>
        <li>Prénom : <s:property value="utilisateur.prenom" /></li>
    </ul>
</body>
</html>