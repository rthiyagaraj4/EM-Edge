<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

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

<script>
function reportid()
{
	
if(document.forms[0].param11.value=="0")
	{
	document.forms[0].p_report_id.value="OHRDGCLG";
	}
	else if(document.forms[0].param11.value=="1")
	{
	document.forms[0].p_report_id.value="OHRDGDEN";
	}
	
}
</script>
   
	 
</head>

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="reportid()">
<%
 
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rst=null;
String Present_Date="";
String sql = "";
String FromClinicalGroup = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.FromClinicalGroup.Label","oh_labels");
String ToClinicalGroup = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToClinicalGroup.Label","oh_labels");
String FromDentist  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.FromDentist.Label","oh_labels");
String ToDentist  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToDentist.Label","oh_labels");
String fromdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromdate.label","common_labels");
String todate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.todate.label","common_labels");
String groupby = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.groupby.label","common_labels");
//String report_id1=checkForNull(request.getParameter( "report_id1" )) ;
//if( report_id1.equals("") ){report_id1="OHRDGCLG";}

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
<!--  <tr>
<td width='25%'>&nbsp;</td>
<td width='25%'>&nbsp;</td>
<td width='25%'>&nbsp;</td>
<td width='25%'>&nbsp;</td>
</tr>  -->

<tr> 
	<td class='label' width='25%'>
		<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>
	</td>
	 <td class='fields' width='25%'>
		 <input type='text' name='P_FROM_DATE' id='P_FROM_DATE' size='10'  value='<%=Present_Date%>' onBlur="CheckDate(this);checkDateNotGraterThanSysDate(this);">
		<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_FROM_DATE');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		 
		<td class='label' width='25%'>
		  <fmt:message key="Common.todate.label" bundle="${common_labels}"/>
		  </td>
		<td class='fields' width='25%'>
		 <input type='text' name='P_TO_DATE' id='P_TO_DATE' size='10'  value='<%=Present_Date%>' onBlur="CheckDate(this);checkDateNotGraterThanSysDate(this);">
		<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_TO_DATE');">
			<img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 
	 
</tr>
<tr>
   <td class='label' width='25%'>
		<fmt:message key="Common.groupby.label" bundle="${common_labels}"/>
		</td>
	  <td class='fields' width='25%'>
		  <select name="param11" id="param11" onChange='reportid()' >  
		  <option value="0" ><fmt:message key="eOH.ClinicalGroup.Label" bundle="${oh_labels}"/>
			</option>
		  <option value="1" ><fmt:message key="eOH.Dentist.Label" bundle="${oh_labels}"/>
			 </option>
		 
		 
		  </select>
	  	  
	 </td>
	 <td>
	 </td>
	 <td>
	 </td>
</tr>
<tr>
	<td class='label' width='25%'>
		 <fmt:message key="eOH.FromClinicalGroup.Label" bundle="${oh_labels}"/> 
		
	</td>
	<td class='fields' width='25%'>
		    <input type='hidden' name="param2" id="param2" value=""> 
			 <input type='hidden' name='P_CLNCL_GRP_FRM' id='P_CLNCL_GRP_FRM' value=""> 
			<input type='text' name='param1_desc' id='param1_desc' size='25'  title='<%=FromClinicalGroup%>' value=''  maxlength='7' param1 = 'P_CLNCL_GRP_FRM'  param2 = 'param2' onBlur="if(this.value!='')callCommonLookup(this); else P_CLNCL_GRP_FRM.value='',param2.value='' " 
			key ='CLINICAL_GROUP'>
			<input type='button' class='button' value='?' name='FromClinicalGroupLookUp' id='FromClinicalGroupLookUp' onClick="callCommonLookup(param1_desc);">
			
	</td>	
	<td class='label' width='25%'>
		 <fmt:message key="eOH.ToClinicalGroup.Label" bundle="${oh_labels}"/> 
         
	</td>
	<td class='fields' width='25%'>
	        <input type='hidden' name='param4' id='param4' value=""> 
		    <input type='hidden' name="P_CLNCL_GRP_TO" id="P_CLNCL_GRP_TO" value=""> 
			<input type='text' name='param3_desc' id='param3_desc' size='25'  title='<%=ToClinicalGroup%>' value=''  maxlength='7' param1 = 'P_CLNCL_GRP_TO'  param2 = 'param4'  onBlur="if(this.value!='')callCommonLookup(this); else P_CLNCL_GRP_TO.value='',param4.value='' " 
			key ='CLINICAL_GROUP'>
			<input type='button' class='button' value='?' name='FromClinicalGroupLookUp' id='FromClinicalGroupLookUp' onClick="callCommonLookup(param3_desc);">
		
	</td>	
</tr>

<tr>
	<td class='label' width='25%'>
	 <fmt:message key="eOH.FromDentist.Label" bundle="${oh_labels}"/> 
	
	</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param6' id='param6' value=""> 
		<input type='hidden' name="P_FRM_DENTIST" id="P_FRM_DENTIST" value=""> 
		<input type='text' name='param5_desc' id='param5_desc' size='25' title='<%=FromDentist%>'   param1 = 'P_FRM_DENTIST'  param2 = 'param6' key ='DENTIST' onBlur="if(this.value!='')callCommonLookup(this); else P_FRM_DENTIST.value='',param6.value='' "> 
	<input type='button' class='button' value='?' name='FromDentistLookUp' id='FromDentistLookUp' onClick="callCommonLookup(param5_desc);">
	</td>

	<td class='label' width='25%'>
	<fmt:message key="eOH.ToDentist.Label" bundle="${oh_labels}"/> 
	
	</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param8' id='param8' value=""> 
		<input type='hidden' name="P_TO_DENTIST" id="P_TO_DENTIST" value=""> 
		<input type='text' name='param7_desc' id='param7_desc' size='25' title='<%=ToDentist%>' param1 = 'P_TO_DENTIST'  param2 = 'param8' key ='DENTIST' onBlur="if(this.value!='')callCommonLookup(this); else P_TO_DENTIST.value='',param8.value='' "> 
		<input type='button' class='button' value='?' name='ToDentistLookUp' id='ToDentistLookUp' onClick="callCommonLookup(param7_desc);" >
		
	</td>
</tr>   




		
	<% 
	}catch(Exception e){
		out.println("exp"+e);
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

</td>

</tr>
 <tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr> 
</table>

<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>" >
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>" >
<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>" >
<input type="hidden" name="p_module_id" id="p_module_id"  value="OH" >
<input type="hidden" name="p_report_id" id="p_report_id" value=" " >


<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
<!-- <input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1_desc##<%=FromClinicalGroup%>" disabled>
<input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param3_desc##<%=ToClinicalGroup%>" disabled>
<input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="param5_desc##<%=FromDentist%>" disabled>
<input type="hidden" name="mandatory_fm_4" id="mandatory_fm_4" value="param7_desc##<%=ToDentist%>" disabled>  -->
<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="P_FROM_DATE##<%=fromdate%>" disabled>
<input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="P_TO_DATE##<%=todate%>" disabled>
<!-- <input type="hidden" name="mandatory_fm_7" id="mandatory_fm_7" value="param11##<%=groupby%>" disabled> -->

<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="P_FROM_DATE##Booking Date" disabled>
<input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="P_TO_DATE" disabled>


</form>
</body>
</html>


