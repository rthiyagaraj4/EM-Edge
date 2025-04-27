<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="eAlert/css/Style.css" rel="stylesheet" type="text/css" />

<script language="javascript">
var alertList = [];
var currIndex;
var interval = null;
var groupCode;
var groupText;
var filtered;
var startAlertId;
var endAlertId;
var currentAlertId;

function setAlertList(alertobject)
{
	if(alertList == null || typeof(alertList) == "undefined")
	{
		alertList = [];
	} 
	alertList.push(alertobject);
}

function getAlertList()
{
	return alertList;
}

function clearAlertList()
{
	alertList = null;
	
	if(alertList == null || typeof(alertList) == "undefined")
	{
		alertList = [];
	} 
}

function displayAlertDetails(totalcount, alertId)
{
	var frame = document.getElementById("AlertContainer");
	
	for(var i=0; i < alertList.length; i++)
	{
		if(alertList[i].alertId == alertId)
		{
			currIndex = alertList[i].count;
			break;
		}
	}
	if(interval != null)
		window.clearTimeout(interval);
	frame.src = "../../AlertDetailServlet?alertId=" + alertId +"&count=" + totalcount;
	currentAlertId = alertId;
}

function loadUserAlert()
{
	alertList = null;
	var frame = document.getElementById("AlertContainer");
	if(groupCode != null && groupCode != "undefined" && groupCode != "NONE")
	{
		setGroupBy(groupCode, groupText);
		return;
	}
	else if(filtered != null && filtered != "undefined" && filtered == true)
	{
		filterUserList(filtered);
	}
	else
		frame.src = "../../AlertByUserServlet";
	window.clearTimeout(interval);
	interval = window.setTimeout("loadUserAlert()", 60000);
}

function traverseDetails(alertId, count)
{
	var frame = document.getElementById("AlertContainer");
	if(interval != null)
		window.clearTimeout(interval);
	frame.src = "../../AlertDetailServlet?alertId=" + alertId +"&count=" + count;
}

function setGroupBy(code, grouptext)
{
	groupCode = code;
	groupText = grouptext;
	var frame = document.getElementById("AlertContainer");
	if(groupCode == "NONE")
	{
		loadUserAlert();
	}
	else{
		if(filtered == true){
			frame.src = "../../AlertUserGroupByServlet?groupCode=" + code + "&groupText=" + grouptext + "&filter=Y";
		}
		else
			frame.src = "../../AlertUserGroupByServlet?groupCode=" + code + "&groupText=" + grouptext + "&filter=N";
	}
	window.clearTimeout(interval);
	interval = window.setTimeout("loadUserAlert()", 60000);
}

function filterUserList(isFiltered)
{
	filtered = isFiltered;
	var frame = document.getElementById("AlertContainer");
	if(filtered == true){
		if(groupCode != "NONE" && groupCode != null && groupCode != "undefined")
			frame.src = "../../AlertUserGroupByServlet?groupCode=" + groupCode + "&groupText=" + groupText + "&filter=Y";
		else
			frame.src = "../../AlertFilterServlet?filter=Y";
	}
	else
	{
		loadUserAlert();
	}
	window.clearTimeout(interval);
	interval = window.setTimeout("loadUserAlert()", 60000);
}

/*function LoadNotification()
{
	var n = $('div#notificaton').noty({
  		text: 'alert',
  		type: 'alert',
      dismissQueue: true,
  		layout: 'bottom',
  		theme: 'defaultTheme',
  			 animation: {
  		        open: {height: 'toggle'},
  		        close: {height: 'toggle'},
  		        easing: 'swing',
  		        speed: 500 // opening & closing animation speed
  		    },
  		    timeout: false, // delay for closing event. Set false for sticky notifications
  		    force: false, // adds notification to the beginning of queue when set to true
  		    modal: false
  	});
} */
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="loadUserAlert()"> 

<div>

<iframe id="AlertContainer"  src="../../AlertByUserServlet" frameborder="0"  height="470" width="330" scrolling="no" frameborder="0"  ></iframe> 

</div>
</body>
</html>

