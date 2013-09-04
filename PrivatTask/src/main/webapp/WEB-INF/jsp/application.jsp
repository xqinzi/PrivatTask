<%@ page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="app-style.css" type="text/css">
<title>тестовое задание</title></head>
<body>
<div class = "wrapper">
	<span class="description">ЛИЦЕВЫЕ СЧЕТА ИЗ БД</span>
	<div>
	<table>
		<tr>
			<th>Номер Л.С.</th>
			<th>Тип Л.С.</th>
			<th>Дата создания</th>
			<th>Адрес</th>
			<th>Владелец</th>
			<th>ИНН владельца</th>
		</tr>
			<c:forEach items="${tableData}"  var="personalAccount" varStatus="itm">
			<tr>
			<td>${personalAccount.accountNumber}</td>
			<td>${personalAccount.accountType}</td>
			<td>${personalAccount.createdDate}</td>
			<td>${personalAccount.flat.house.street.streetName} ${personalAccount.flat.house.houseNumber}/${personalAccount.flat.number}</td>
			<td>${personalAccount.owner.firstName} ${personalAccount.owner.patronymic} ${personalAccount.owner.secondName}</td>
			<td>${personalAccount.owner.inn}</td>
		</tr>
	</c:forEach>
	</table>
	</div>
	<a href="referencebook.htm">Перейти на страницу <span class="bold-blue">СПРАВОЧНИКИ</span></a><br/>
	<a href="addPersonalAccount.htm">Создать ЛИЦЕВОЙ СЧЕТ</a>
</div>
</body>
</html>