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

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language='javascript' src='../../eOH/js/MasterReports.js'></script> 
 	<script language='javascript' src='../../eOH/js/OHReports.js'></script> 
 	<script language='javascript' src='../../eOH/js/OHReportsLkupSQL.js'></script> 
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function changeRepId(){
	var frmObj=document.forms[0];
	var opt_val=frmObj.param11.value
	if(opt_val=="0"){
		frmObj.p_report_id.value="OHRTRCTY";
	}else if(opt_val=="1"){
		frmObj.p_report_id.value="OHRTRDEN";
	}
	//alert(frmObj.p_report_id.value);
}
</script>
   
	 
</head>

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="changeRepId()">
<%
 
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rst=null;
//String mode=request.getParameter("mode");
String Present_Date="";
String sql = "";
String fromdate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromdate.label","common_labels");
String fromDentist = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.FromDentist.Label","oh_labels");
String toDentist = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToDentist.Label","oh_labels");
String todate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.todate.label","common_labels");
String sql_trmt_category = "SELECT A.TRMT_CATEGORY_CODE CODE, A.TRMT_CATEGORY_DESC DESCRIPTION FROM OH_TREATMENT_CATEGORY_LANG A WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";
 sql = "SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') DATE_TIME, TO_CHAR(SYSDATE,'MM/YYYY') MON_YEAR, TO_CHAR(SYSDATE,'HH24:MI') HOURS_MTS FROM DUAL";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			Present_Date = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);  
		}
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		pstmt = con.prepareStatement(sql_trmt_category );
		rst = pstmt.executeQuery();
%>
<form name="OHReportOptionsForm" id="OHReportOptionsForm" onload='FocusFirstElement()'  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" method="" > 
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align='center'>
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
	 <fmt:message key="eOH.FromDentist.Label" bundle="${oh_labels}"/> 
	
	</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param6' id='param6' value=""> 
		<input type='hidden' name="P_FROM_DENTIST" id="P_FROM_DENTIST" value=""> 
		<input type='text' name='param5_desc' id='param5_desc' size='25' title='<%=fromDentist%>'  param1 = 'P_FROM_DENTIST'  param2 = 'param6' key ='DENTIST' onBlur="if(this.value!='')callCommonLookup(this); else P_FROM_DENTIST.value='',param6.value='' "> 
	<input type='button' class='button' value='?' name='FromDentistLookUp' id='FromDentistLookUp' onClick="callCommonLookup(param5_desc);">
	</td>

	<td class='label' width='25%'>
	 <fmt:message key="eOH.ToDentist.Label" bundle="${oh_labels}"/> 
	
	</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param8' id='param8' value=""> 
		<input type='hidden' name="P_TO_DENTIST" id="P_TO_DENTIST" value=""> 
		<input type='text' name='param7_desc' id='param7_desc' size='25' title='<%=toDentist%>' param1 = 'P_TO_DENTIST'  param2 = 'param8' key ='DENTIST' onBlur="if(this.value!='')callCommonLookup(this); else P_TO_DENTIST.value='',param8.value='' "> 
		<input type='button' class='button' value='?' name='ToDentistLookUp' id='ToDentistLookUp' onClick="callCommonLookup(param7_desc);" >
	</td>
</tr>   



<tr>
<td class='label' width='25%'><fmt:message key="Common.TreatmentCategory.label" bundle="${common_labels}"/> </td>
	<td class='fields' width='25%'>
	 <select name="P_CATEGORY_TYPE" id="P_CATEGORY_TYPE">  
	 <option value="">
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	</option>
    <% while(rst.next()){ %>
		  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
<%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg Rep_TimePerfDateDentist.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
%>
	 </td>

   <td class='label' width='25%'>
		<fmt:message key="Common.groupby.label" bundle="${common_labels}"/>
		</td>
	  <td class='fields' width='25%'>
		  <select name="param11" id="param11" onchange="changeRepId();">  
		  <option value="0" ><fmt:message key="Common.TreatmentCategory.label" bundle="${common_labels}"/> 
			</option>
		  <option value="1" ><fmt:message key="eOH.Dentist.Label" bundle="${oh_labels}"/>
			 </option>
		  </select>
	 </td>
	
</tr>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>" >
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>" >
<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>" >
<input type="hidden" name="p_module_id" id="p_module_id"  value="OH" >
<input type="hidden" name="p_report_id" id="p_report_id" value="" >

<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="P_FROM_DATE##<%=fromdate%>" disabled>
<input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="P_TO_DATE##<%=todate%>" disabled>


<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="P_FROM_DATE##Booking Date" disabled>
<input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="P_TO_DATE" disabled>

</form>
</body>
</html>


