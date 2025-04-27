<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<%@ page import ="java.text.*,webbeans.eCommon.*,eCommon.Common.CommonBean" %>
<% 	
	String facility_id	= CommonBean.checkForNull(request.getParameter("facility_id"));
	String patient_id	= CommonBean.checkForNull(request.getParameter("patient_id"));
	String order_id		= CommonBean.checkForNull(request.getParameter("order_id"));
	String booking_num	= CommonBean.checkForNull(request.getParameter("booking_num"));
	//String booking_no	= CommonBean.checkForNull(request.getParameter("booking_no"));		
try{	
%>
<title><fmt:message key="eOT.AssignTheatre.Label" bundle="${ot_labels}"/> </title>
<head>
<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language='javascript'></script>
 	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eOT/js/Booking.js' language='javascript'></SCRIPT>
	<script src='../../eOT/js/AssignAnaesthetist.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="assigntheatreForm" id="assigntheatreForm">
<table border='0' cellpadding=3 cellspacing='0' align='center'  width='100%' >
<tr>
	<td class="label" width="25%">
		<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	</td>
<!-- 	<td class="fields" width="25%" colspan="3">
		
		<input type='text'   name='theatre' id='theatre' maxlength='15' size='15' value= "" onblur="if(this.value!='')AssignTheatre(theatre); else theatre_code.value='' ">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick=" return AssignTheatre(theatre);">
 -->
<td class="fields" width="25%" colspan="3">
		<input type='hidden' name='theatre_code' id='theatre_code' value=""> 
		<input name='theatre' id='theatre' maxlength='15' size='15' value= "" onkeypress ="return enterKeyCheck(event);" onBlur="if(this.value!='')return AssignTheatre(theatre); else theatre_code.value=''">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="return AssignTheatre(theatre);" >
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class="fields" width="25%" ></td>
	<td class="button" width="25%">
		<input type="button" class="button" name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'	onclick="savetheatre();">
	
		<input type="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.close();">
	</td>
</tr>
</table>
<%	
}catch(Exception e){
	System.err.println("208: Exception in AssignTheatreFrame.jsp "+e);
}
%>
	<input type='hidden' name='facility_id_1' id='facility_id_1' value="<%=facility_id%>" >	
	<input type='hidden' name='patient_id_1' id='patient_id_1' value="<%=patient_id%>" >
	<input type='hidden' name='order_id_1' id='order_id_1' value="<%=order_id%>" >
	<input type='hidden' name='booking_num_1' id='booking_num_1' value="<%=booking_num%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

