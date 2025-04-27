<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                   
 <% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.Connection,
	java.sql.PreparedStatement,
	java.sql.ResultSet,
	webbeans.eCommon.ConnectionManager,
	eOT.*,
	eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>                

<html>
 <head>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String fromdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromdate.label","common_labels");
	String todate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.todate.label","common_labels");
	String surgerytype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SurgeryType.label","common_labels");
	
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOT/js/OtReports.js"> </script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String booking_date = "";
	
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";

	if(facility_id == null) facility_id="";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			rst = pstmt.executeQuery();
			while(rst.next()){
				booking_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			}


			pstmt = con.prepareStatement(sql_surgery_type);
		rst = pstmt.executeQuery();

		
%>

<body OnMouseDown="CodeArrest()">
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0' width='100%'>
<br>
<tr> 
	  <td class='label' width='25%'><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8' value='<%=booking_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"> <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <td class='label' width='25%'><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8' value='<%=booking_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr> 
	<td class='label' width='25%'><fmt:message key="eOT.WaitingTimeBy.Label" bundle="${ot_labels}"/></td>
	<td class='fields' width='25%'>
	<!-- <select name="type" id="type" onchange="assignReportId(this);">   -->
	<select name="param3" id="param3">  
		<option value='OP'> <fmt:message key="eOT.OperationRoom.Label" bundle="${ot_labels}"/> </option>
		<option value='PR'> <fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> </option>
		<option value='SP'> <fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </option>
		
	</select>
	</td>
	<td class='label' width='25%'>
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
	 <select name="param11" id="param11" >  
     <option value="" >
		<fmt:message key="Common.all.label" bundle="${common_labels}"/>
	 </option>
	<% while(rst.next()){ %>
	  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
<%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg OperationListReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
%>
	 </select>
	
</tr>
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="P_facility_id" id="P_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRWATOR">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRWATOR">
	<input type="hidden" name="header" id="header" value="">
    <input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2"> 
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=todate%>" disabled>
	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Booking Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
    <input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>" >

</form>
</body>
</html>




