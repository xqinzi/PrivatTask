<%@ page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="app-style.css" type="text/css">
<title>новый Л.С.</title></head>
<body>
<div class = "wrapper">
	<span class="description">Добавить ЛИЦЕВОЙ СЧЕТ</span><br/>
	<form:form method="POST" commandName="PersAcntForm">
	<form:input path="accountNumber" /><br/>
	<form:input path="accountType" /><br/>
	<input type="submit" value="Создать"/>
	</form:form>
</div>
</body>
</html>