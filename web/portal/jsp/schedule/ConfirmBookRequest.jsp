<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Book Request</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css"/>
<script src="../../js/jquery.min.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style scoped>

#bookedpopwrapper
{
	width:575px;
	height:auto;
	background-color:#ffffff;
	-moz-box-shadow: 0px 0px 10px  #ADADAD;
	-webkit-box-shadow: 0px 0px 10px  #ADADAD;
	box-shadow: 0px 0px 10px  #ADADAD;
}

#bookedpopmsgbox
{
	width:564px;
	height:auto;
	margin:5px 5px 5px 4px;
	border:#92b82d solid 1px;
	background-color:#ffffff;
	display:table;
}

</style>
</head>
<body>

<%
String practitionerName = request.getParameter("practitionerName");
if(practitionerName == null){
	practitionerName = "";
}

String specialty = request.getParameter("specialty");
if(specialty == null){
	specialty = "";
}
String preferredDate = request.getParameter("preferredDate");
if(preferredDate == null){
	preferredDate = "";
}

String selectedTimeSlot = request.getParameter("selectedTimeSlot");
if(selectedTimeSlot == null){
	selectedTimeSlot = "";
}


%>
<div id="bookedpopwrapper">
	
<div id="popheader">
<div class="row">
		<div id="poptitle">Confirmation
        </div>
        
		<div id="close" onclick="cancelOperation()">x
        </div>
    
</div>
</div>

<div id="bookedpopmsgbox" >

<div id="resultholder" >
	<div class="row">
    	
        <div id="resultcell">
        <span id="resulttitle">Please confirm the details</span>
		<div class="bookedDetails">
			<div class="bookedcontent">
			<span class="contenbold"><%=practitionerName %>,</span><span class="contentnormal"> <%=specialty %></span><br/>
			<div class="popupoverflow" >
				<div class="floatleft">
					<span class="contentnormalpopup">Appointment Date and Time</span>
				</div>
				<div class="floatleft">
					<span class="contentnormal">:</span><span class="contenbold"><%=preferredDate %>, <%=selectedTimeSlot %></span>
					<!-- <span class="contentnormal">:</span><span class="contenbold">16 Dec 2012, 2:30 - 3:00</span> -->
				</div>
			</div>
			
			</div>
		</div>
        	<span><a href="#" onclick="performOperation()" class="popbtncenter">Confirm</a></span>
			<span><a href="#" onclick="cancelOperation()" class="popbtncenter">Cancel</a></span>
        </div>
         
        
    </div>
    

</div>

</div>
</div>
<!-- #wrapper -->

</body>
</html>

