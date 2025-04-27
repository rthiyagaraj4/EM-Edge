<!DOCTYPE html>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
          
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromBookingDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToBookingDate.Label","ot_labels");
	String theatre_code= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Theatre.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date = com.ehis.util.DateUtils.convertDate(rst.getString("DATE_TIME"),"DMYHM","en",locale);
		}

			if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		
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
	<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding=3 cellspacing='0' width='100%'>
<tr> 
	<td class='label' width='25%'>
		<fmt:message key="eOT.FromBookingDate.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='14'  value='<%=surgery_date%>' onBlur="isValidDateTime(this);" maxlength='16'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1','DD/MM/YYYY HH24:MI');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	  <td class='label' width='25%'>
		<fmt:message key="eOT.ToBookingDate.Label" bundle="${ot_labels}"/>
		</td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='14'  value='<%=surgery_date%>' onBlur="isValidDateTime(this);" maxlength='16'> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2','DD/MM/YYYY HH24:MI');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
</tr>

<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4' >
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=theatre_code%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " > 
		 <input type='button' class='button' value='?' name='OperRoomLookUp' id='OperRoomLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
   
 
	<td class='label' width='25%'>
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param6' id='param6' >
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=surgeon_title%>' param1 = 'param5'  param2 = 'param6' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " > 
		 <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
</tr>
<%
}
	catch(Exception e){
		System.err.println("Err Msg OTScheduleReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }

%>
	
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRETEST">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRETEST">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >	

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param3##Code" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param4" disabled>
    <input type="hidden" name="qry_sql" id="qry_sql" value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='<%=locale%>' AND OPERATING_FACILITY_ID ='<%=facility_id%>' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2" >

	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param3#param4#param5#param6#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>
</body>
</html>

