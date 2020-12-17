<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../_include/head.jsp" %>
</head>
<body>
    <h2>Détail du projet</h2>

    <ul>
        <li>ID : <s:property value="projet.id" /></li>
        <li>Nom : <s:property value="projet.nom" /></li>
        <li>Date création : <s:date name="projet.dateCreation" /></li>
        <li>
            Responsable :
            <s:a action="utilisateur_detail">
                <s:param name="id" value="projet.responsable.id" />
                <s:property value="projet.responsable.prenom"/> <s:property value="projet.responsable.nom"/>
            </s:a>
        </li>
        <li>Cloturé : <s:property value="projet.cloture" /></li>
    </ul>
</body>
</html>