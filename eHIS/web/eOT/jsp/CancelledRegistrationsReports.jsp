<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" %>          
<% String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

<%
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String fromsurgerydate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromSurgeryDate.Label","ot_labels");
	String tosurgerydate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToSurgeryDate.Label","ot_labels");
	String surgerytype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SurgeryType.label","common_labels");
	String surgeon_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String speciality_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  ORDER BY 2";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//surgery_date = rst.getString("CURRENT_DATE");
			//Buddhist date conversion (Thai Locale)
			surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);

		}
		pstmt.close();
		rst.close();
		pstmt = con.prepareStatement(sql_surgery_type);
		rst = pstmt.executeQuery();

%>

<html>
<head><title></title>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script language="JavaScript" src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%' align="centre" > 

<tr> 
	  <td class='label' width='25%'>
		<fmt:message key="eOT.FromSurgeryDate.Label" bundle="${ot_labels}"/>
	  </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='p1' id='p1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('p1');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	  <td class='label' width='25%'>
			<fmt:message key="eOT.ToSurgeryDate.Label" bundle="${ot_labels}"/>
	  </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='p2' id='p2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('p2');">
			<img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 
</tr>


<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
</td>
    <td class='fields' width='25%'>
		<input type='hidden' name='p4' id='p4'> 
		<input type='hidden' name='p3' id='p3'> 
		<input type='text' name='from_oper_room_desc' id='from_oper_room_desc' size='20' title='<%=operationRoom_title%>' param1 = 'p3'  param2 = 'p4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else callClearParam(p3,p4); " maxlength='70'> 
		<input type='button' class='button' value='?' name='OperRoomLookUp' id='OperRoomLookUp' onClick="callCommonLookup(from_oper_room_desc);" >
	</td>
	
	<td class='label' width='25%'>
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
	 <select name="p6" id="p6" >  
	<option value= "*ALL" >
		<fmt:message key="Common.all.label" bundle="${common_labels}"/> </option> 
	<% while(rst.next()){ %>
		  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
<%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg CancelledRegistrationsReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
%>
	 </select>
	 <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 
</tr>
<!--/* this Code is only for Siriraj Purpose*/ <tr>
	<td class='label' width='25%'>
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='p7' id='p7'> 
		<input type='hidden' name='p8' id='p8'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' title='<%=surgeon_title%>' param1 = 'p7'  param2 = 'p8' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else p7.value='',pp8.value='' " > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param7_desc);" >
	</td>

	<td class='label' width='25%'>
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='p9' id='p9'> 
		<input type='hidden' name='p10' id='p10'> 
		<input type='text' name='param9_desc' id='param9_desc' size='20' title='<%=speciality_title%>' param1 = 'p9'  param2 = 'p10' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else p9.value='',p10.value='' " > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param9_desc);" >
	</td> 
</tr>
<tr>
	<td class='label' width='25%'><fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/> </td>
	   <td class='fields' width='25%'>
		  <select name="p5" id="p5" >  
		  <option value="ALL" ><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
		  <option value="Y" ><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/> </option>
		  <option value="N" ><fmt:message key="eOT.Unscheduled.Label" bundle="${ot_labels}"/> </option>
		  </select>
	 </td>
</tr> -->

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="P_facility_id" id="P_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRCNREG"> 
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRCNREG">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text" id="sql_text" value="<%=sql_surgery_type%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="3" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="p1##<%=fromsurgerydate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="p2##<%=tosurgerydate%>" disabled>
    <input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="p6##<%=surgerytype%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="p1##Surgery Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="p2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="1" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="p3##Operation Room" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="p4" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

