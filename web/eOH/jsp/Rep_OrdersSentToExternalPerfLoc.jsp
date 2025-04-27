<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
String facility_id = (String)session.getValue("facility_id");
String user_id = (String)session.getValue("login_user");
String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
request.setCharacterEncoding("UTF-8");
String fromdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromdate.label","common_labels");
String todate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.todate.label","common_labels");
  String ExternalPerformingLocation  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ExternalPerformingLocation.Label","oh_labels");
  
	
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/><Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	
	<script language='javascript' src='../../eOH/js/OHReports.js'></script> 
 	<script language='javascript' src='../../eOH/js/OHReportsLkupSQL.js'></script> 
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		//String mode=request.getParameter("mode");
		//String master_code_desc="";
		String Present_Date="";
		String sql = "";
       

       sql = "SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') DATE_TIME, TO_CHAR(SYSDATE,'MM/YYYY') MON_YEAR, TO_CHAR(SYSDATE,'HH24:MI') HOURS_MTS FROM DUAL";
try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			Present_Date = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);  
		}	
%>
  <form name="OHReportOptionsForm" id="OHReportOptionsForm" onload='FocusFirstElement()'  action="../../eCommon/jsp/report_options.jsp"   target="messageFrame" method="" > 
  <table border=0 cellspacing=0 cellpadding=3  width='100%'  align='center'>
	
<tr> 
	<td class='label' width='25%'>
		<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		 <input type='text' name='P_FROM_DATE' id='P_FROM_DATE' size='8'  value='<%=Present_Date%>' onBlur="CheckDate(this);">
		<input type='image' src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		 
	<td class='label' width='25%'><fmt:message key="Common.todate.label" bundle="${common_labels}"/>    </td>
	<td class='fields' width='25%'>
		 <input type='text' name='P_TO_DATE' id='P_TO_DATE' size='8'  value='<%=Present_Date%>' onBlur="CheckDate(this);">
		<input type='image' src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	 
</tr>
<tr>
	<td class='label' width='25%'>
	   <fmt:message key="eOH.ExternalPerformingLocation.Label" bundle="${oh_labels}"/>
	</td>
      <td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='hidden' name="EXT_PERF_LOCN" id="EXT_PERF_LOCN" value=""> 
		<input type='text' name='EXT_PERF_LOCN_desc' id='EXT_PERF_LOCN_desc' size='25'  value=''  title='<%=ExternalPerformingLocation%>'maxlength='7' param1 = 'EXT_PERF_LOCN'  param2 = 'param4' key ='EXT_PERF_LOCN' onBlur="if(this.value!='')callCommonLookup(this); else EXT_PERF_LOCN.value='',param4.value='' "> 
	    <input type='button' class='button' value='?' name='FromTreatment LookUp' id='FromTreatment LookUp' onClick="callCommonLookup(EXT_PERF_LOCN_desc);"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	</td><td></td><td></td></tr>
<% 
}catch(Exception e){
		System.err.println("Err Msg  "+e.getMessage());
  }finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			out.println("exp"+e);
		}
	}
%>
</table>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>" >
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>" >
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>" >
	 <input type="hidden" name="p_module_id" id="p_module_id"  value="OH" >
	<input type="hidden" name="p_report_id" id="p_report_id" value="OHREXTLB">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OHREXTLB" >
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	
	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="P_FROM_DATE##From Date" disabled>
	<input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="P_TO_DATE" disabled>
	
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="3" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="P_FROM_DATE##<%=fromdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="P_TO_DATE##<%=todate%>" disabled>
    <input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="EXT_PERF_LOCN_desc##<%=ExternalPerformingLocation%>" disabled>

</form>
</body>
</html>


