<%@ page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>новый Л.С.</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="app-style.css" type="text/css"/>
<script src="<c:url value='/js/jquery-1.10.2.min.js' />"></script>
<script src="<c:url value='/js/jquery-ui.js' />"></script>
<script>
jQuery(function($){
    $.datepicker.regional['ru'] = {
            closeText: 'Закрыть',
            prevText: '&#x3c;Пред',
            nextText: 'След&#x3e;',
            currentText: 'Сегодня',
            monthNames: ['Январь','Февраль','Март','Апрель','Май','Июнь',
            'Июль','Август','Сентябрь','Октябрь','Ноябрь','Декабрь'],
            monthNamesShort: ['Янв','Фев','Мар','Апр','Май','Июн',
            'Июл','Авг','Сен','Окт','Ноя','Дек'],
            dayNames: ['воскресенье','понедельник','вторник','среда','четверг','пятница','суббота'],
            dayNamesShort: ['вск','пнд','втр','срд','чтв','птн','сбт'],
            dayNamesMin: ['Вс','Пн','Вт','Ср','Чт','Пт','Сб'],
            weekHeader: 'Нед',
            dateFormat: 'dd.mm.yy',
            firstDay: 1,
            isRTL: false,
            showMonthAfterYear: false,
            yearSuffix: ''};
    $.datepicker.setDefaults($.datepicker.regional['ru']);
});
$(function() {
$( "#datepicker" ).datepicker();
});
</script>
</head>
<body>
<div class = "wrapper">
	<span class="description">Добавить ЛИЦЕВОЙ СЧЕТ</span><br/>
<form:form method="POST" commandName="addPersonalAccountForm" >
<form:errors path="*" cssClass="errorblock" element="div" />
	<span class="label-input">номер лицевого счета</span><br/>
	<form:input path="accountNumber" /><br/>
	<span class="label-input">тип л.с. (квартплата, водоснабжение, газоснабжение)</span><br/>
	<form:input path="accountType" /><br/>
	<span class="label-input">дата создания</span><br/>
	<form:input path="createdDate" id="datepicker"></form:input><br/>
	<span class="label-input">адрес</span><br/>
	<form:select path="strFlatID">
		<form:option value="NONE" label="--- Select ---" />
		<form:options items="${flatList}" />
	</form:select><br/>
	<span class="label-input">владелец</span><br/>
	<form:select path="strOwnerID">
		<form:option value="NONE" label="--- Select ---" />
		<form:options items="${ownerList}" />
	</form:select><br/><br/>
	<input type="submit" value="Создать"/>
</form:form>
</div>
</body>
</html>