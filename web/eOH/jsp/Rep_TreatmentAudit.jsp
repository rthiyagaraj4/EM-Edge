<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
   String facility_id = (String)session.getValue("facility_id");
   String user_id = (String)session.getValue("login_user");
   String locale = (String)session.getAttribute("LOCALE"); 
   request.setCharacterEncoding("UTF-8");
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/><Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language='javascript' src='../../eOH/js/MasterReports.js'></script> 
 	<script language='javascript' src='../../eOH/js/OHReports.js'></script> 
 	<script language='javascript' src='../../eOH/js/OHReportsLkupSQL.js'></script> 
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

 </head>

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
 
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rst=null;
String Present_Date="";
String sql = "";
String FromTreatment  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FromTreatment.label","common_labels");
String ToTreatment  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ToTreatment.label","common_labels");
String fromdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromdate.label","common_labels");
String todate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.todate.label","common_labels");


 sql = "SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') DATE_TIME, TO_CHAR(SYSDATE,'MM/YYYY') MON_YEAR, TO_CHAR(SYSDATE,'HH24:MI') HOURS_MTS FROM DUAL";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			Present_Date = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);  
		}	
%>
  <form name="OHReportOptionsForm" id="OHReportOptionsForm" onload='FocusFirstElement()'  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" method="" > 
  <table border=0 cellspacing=0 cellpadding=3  width='100%'  align='center'>
	
<tr> 
	<td class='label' width='25%'>
		<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		 <input type='text' name='P_FROM_DATE' id='P_FROM_DATE' size='10'  value='<%=Present_Date%>' onBlur="CheckDate(this);checkDateNotGraterThanSysDate(this);">
		<input type='image' src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('P_FROM_DATE');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		 
	<td class='label' width='25%'><fmt:message key="Common.todate.label" bundle="${common_labels}"/>  </td>
	<td class='fields' width='25%'>
		 <input type='text' name='P_TO_DATE' id='P_TO_DATE' size='10'  value='<%=Present_Date%>' onBlur="CheckDate(this);checkDateNotGraterThanSysDate(this);">
		<input type='image' src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('P_TO_DATE');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	 
</tr>
<tr>
	<td class='label' width='25%'><fmt:message key="Common.FromTreatment.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='hidden' name="P_FROM_TRMT_CODE" id="P_FROM_TRMT_CODE" value=""> 
		<input type='text' name='param3_desc' id='param3_desc' size='25'  value=''  maxlength='7' title='<%=FromTreatment%>' param1 = 'P_FROM_TRMT_CODE'  param2 = 'param4' key ='TRMT' onBlur="if(this.value!='')callCommonLookup(this); else P_FROM_TRMT_CODE.value='',param4.value='' "> 
	    <input type='button' class='button' value='?' name='FromTreatment LookUp' id='FromTreatment LookUp' onClick="callCommonLookup(param3_desc);"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='label' width='25%'><fmt:message key="Common.ToTreatment.label" bundle="${common_labels}"/>
	</td>
      <td class='fields' width='25%'>
		<input type='hidden' name='param6' id='param6' value=""> 
		<input type='hidden' name="P_TO_TRMT_CODE" id="P_TO_TRMT_CODE" value=""> 
		<input type='text' name='param5_desc' id='param5_desc' size='25'  value=''  maxlength='7' title='<%=ToTreatment%>'  param1 = 'P_TO_TRMT_CODE'  param2 = 'param6' key ='TRMT' onBlur="if(this.value!='')callCommonLookup(this); else P_TO_TRMT_CODE.value='',param6.value='' "> 
		<input type='button' class='button' value='?' name='ToTreatmentLookUp' id='ToTreatmentLookUp' onClick="callCommonLookup(param5_desc);" ><img src='../../eCommon/images/mandatory.gif'></img>
		
	</td></tr>
	<!-- <tr>
			<td class='fields' width='25%'><fmt:message key="eOH.EarlierThanTreatmentPlanDate.Label" bundle="${oh_labels}"/><input type='radio' name='E' id='E'  ></td>
			<td class='fields' width='25%'><fmt:message key="eOH.LaterThanTreatmentPlanDate.Label" bundle="${oh_labels}"/><input type='radio' name='E' id='E' ></td>
				</td><td></td><td></td></tr>
 -->

 <tr>
   <td class='label' width='25%'>
		<fmt:message key="Common.view.label" bundle="${common_labels}"/>
		</td>
	  <td class='fields' width='25%'>
		  <select name="P_EARLIER" id="P_EARLIER">  
		  <!-- <option value="E" ><fmt:message key="eOH.EarlierThanTreatmentPlanDate.Label" bundle="${oh_labels}"/>
			</option>
		  <option value="L" ><fmt:message key="eOH.LaterThanTreatmentPlanDate.Label" bundle="${oh_labels}"/>
			 </option> -->
		 <option value="A" ><fmt:message key="eOH.AllTasks.Label" bundle="${oh_labels}"/>
			</option>
		  <option value="D" ><fmt:message key="eOH.DelayedTasks.Label" bundle="${oh_labels}"/> </option>
		  <option value ="O" ><fmt:message key="eOH.OntimeTasks.Label" bundle="${oh_labels}"/> </option>
		 
		  </select>
	  	  
	 </td>
	 <td>
	 </td>
	 <td>
	 </td>
</tr>

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
			<input type="hidden" name="p_report_id" id="p_report_id" value="OHRAUDIT" >
			<input type="hidden" name="pgm_id" id="pgm_id" value="OHRAUDIT" >
			<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
			 
			 <input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
			<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="P_FROM_DATE##From_Date" disabled>
			<input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="P_TO_DATE" disabled>
			
			 <input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="4" disabled>
			<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="P_FROM_DATE##<%=fromdate%>" disabled>
			<input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="P_TO_DATE##<%=todate%>" disabled>
			<input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="param3_desc##<%=FromTreatment%>" disabled>
			<input type="hidden" name="mandatory_fm_4" id="mandatory_fm_4" value="param5_desc##<%=ToTreatment%>" disabled>
      </form>
   </body>
 </html>


