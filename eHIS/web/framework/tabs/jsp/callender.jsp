<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://ibahealth.com/framework/IBATagLibs" prefix="IBATagLibs"%>

<html>
    <title>Calender.jsp</title>
    <link rel="stylesheet" type="text/css" media="all" href="../../framework/css/calendar-system.css" title="system" />
    <IBATagLibs:initCalendar/>
  <head> </head>
 <body>

		<div style="float: right; margin-left: 1em; margin-bottom: 1em;" id="calendar-container"></div>

		<script type="text/javascript">
		  function dateChanged(calendar) {
		    // Beware that this function is called even if the end-user only
		    // changed the month/year.  In order to determine if a date was
		    // clicked you can use the dateClicked property of the calendar:
		    if (calendar.dateClicked) {
		      // OK, a date was clicked, redirect to /yyyy/mm/dd/index.php
		      var y = calendar.date.getFullYear();
		      var m = calendar.date.getMonth();     // integer, 0..11
		      var d = calendar.date.getDate();      // indbgl-gw02, 1..31
		      var date = calendar.date;
       		  var time = date.getTime();
       		  var date2 = new Date(time);
       		  var id=window.opener.calend;
       		  window.opener.currentDateElement.value=date2.print(window.opener.calend)
		      // redirect...
		      window.close();
		      //window.location = "/" + y + "/" + m + "/" + d + "/index.php";
		    }
		  };
		  Calendar.setup(
		    {
		      flat         : "calendar-container", // ID of the parent element
		      flatCallback : dateChanged ,          // our callback function
		      ifFormat       :    window.opener.calend,
		      showsTime      :    window.opener.time,
	   		  timeFormat     :    "24",
	   		  value 		 :	window.opener.currentDateElement.value,
	   		  weekNumbers    : false
	   		}
		  );
		 
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</body>
	
</html>

