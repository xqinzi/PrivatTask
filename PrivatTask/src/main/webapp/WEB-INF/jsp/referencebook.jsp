<%@ page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="app-style.css" type="text/css">
<title>справочники</title></head>
<body>
<div class = "wrapper">
	<span class="description">СПРАВОЧНИКИ</span><br/>
	<div class="table-wrapper">
	<span class="description">УЛИЦЫ</span>
	<table>
		<tr>
			<th>ID</th>
			<th>Название улицы</th>
			<th>удалить</th>
		</tr>
			<c:forEach items="${streets}"  var="str" varStatus="itm">
			<tr>
			<td>${str.id}</td>
			<td>${str.streetName}</td>
			<td><a href="referencebook.htm?type=street&id=${str.id}">удалить</a></td>
		</tr>
	</c:forEach>
	</table>
	</div>
	<div class="table-wrapper">
	<span class="description">ДОМА</span>
	<table>
		<tr>
			<th>ID</th>
			<th>Номер</th>
			<th>Тип дома</th>
			<th>Улица</th>
			<th>Тип матер.</th>
			<th>удалить</th>
		</tr>
			<c:forEach items="${houses}"  var="h" varStatus="itm">
			<tr>
			<td>${h.id}</td>
			<td>${h.houseNumber}</td>
			<td>${h.houseType}</td>
			<td>${h.street.streetName}</td>
			<td>${h.matType}</td>
			<td><a href="referencebook.htm?type=house&id=${h.id}">удалить</a></td>
		</tr>
	</c:forEach>
	</table>
	</div>
	<div class="table-wrapper">
	<span class="description">КВАРТИРЫ</span>
	<table>
		<tr>
			<th>ID</th>
			<th>Улица</th>
			<th>Номер дома</th>
			<th>Номер кв.</th>
			<th>Общая пл.</th>
			<th>Жилая пл.</th>
			<th>Этаж</th>
			<th>Подъезд</th>
			<th>удалить</th>
		</tr>
			<c:forEach items="${flats}"  var="f" varStatus="itm">
			<tr>
			<td>${f.id}</td>
			<td>${f.house.street.streetName}</td>
			<td>${f.house.houseNumber}</td>
			<td>${f.number}</td>
			<td>${f.sqTotal}</td>
			<td>${f.sqLiv}</td>
			<td>${f.floorNum}</td>
			<td>${f.doorWayNum}</td>
			<td><a href="referencebook.htm?type=flat&id=${f.id}">удалить</a></td>
		</tr>
	</c:forEach>
	</table>
	</div>
	
	<div class="table-wrapper">
	<span class="description">ВЛАДЕЛЬЦЫ</span>
	<table>
		<tr>
			<th>ID</th>
			<th>Имя</th>
			<th>Фамилия</th>
			<th>Отчество</th>
			<th>Дата рождения</th>
			<th>Инн</th>
			<th>удалить</th>
		</tr>
			<c:forEach items="${owners}"  var="o" varStatus="itm">
			<tr>
			<td>${o.id}</td>
			<td>${o.firstName}</td>
			<td>${o.patronymic}</td>
			<td>${o.secondName}</td>
			<td><fmt:formatDate value="${o.birthday}" pattern="dd.MM.yyyy" /></td>
			<td>${o.inn}</td>
			<td><a href="referencebook.htm?type=owner&id=${o.id}">удалить</a></td>
		</tr>
	</c:forEach>
	</table>
	</div>				
</div>
</body>
</html>