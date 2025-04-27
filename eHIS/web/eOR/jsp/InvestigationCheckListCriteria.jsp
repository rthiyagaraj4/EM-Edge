<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.ConnectionManager, eOR.*,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eOR.InvestigationCheckList.label" bundle="${or_labels}"/></title>
<%
 request.setCharacterEncoding("UTF-8");
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="javascript" src="../../eOR/js/InvestigationCheckList.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>

<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="investigationChkListForm" id="investigationChkListForm" target="messageFrame">
<%
String facility_id = (String)session.getValue("facility_id");
String user_id = (String)session.getValue("login_user");
String to_date="";
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;		
try
{
	con=ConnectionManager.getConnection(request);
	String sql_date="Select to_char( sysdate,'dd/mm/yyyy') to_date from dual";
	stmt	=	con.prepareStatement(sql_date);
	rs		=	stmt.executeQuery();
	if(rs!=null)
	{
		if(rs.next()){
			to_date = rs.getString("to_date");
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
}catch(Exception e){
	e.printStackTrace() ;
}

%>
<table  cellpadding='0' cellspacing="0" width="80%" align="center" valign="top">

<tr><th colspan="4" align="left"><fmt:message key="eOR.InvestigationCheckList.label" bundle="${or_labels}"/></th></tr>

<tr><td colspan="4">&nbsp;</td></tr>

<tr>
<td class="label" align="left" nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" nowrap><select name="P_ORDER_CATEGORY" id="P_ORDER_CATEGORY">
<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
	ArrayList Order_Category = getOrderCategory();
	String[] record=null;
	for(int i=0; i<Order_Category.size(); i++){
		record = (String[])Order_Category.get(i);
%>
<option value = "<%=record[0]%>"><%=record[1]%></option>
<%}
 Order_Category= null;
 record=null;
%>

</select></td>
<td class='label' nowrap align="left"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>&nbsp;</td>
<td nowrap align="left"><select name="P_PATIENT_CLASS" id="P_PATIENT_CLASS"><option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
ArrayList patient_class=getPatientClass();
for(int j=0;j<patient_class.size();j++){
record=(String[])patient_class.get(j);
%>
<option value="<%=record[0]%>"><%=record[1]%></option>
<%
}
patient_class=null;
record=null;
%>
</select></td>
</tr>

<tr><td colspan="4">&nbsp;</td></tr>

<tr>
<td class="label" align="left" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" nowrap><input type="text" name="P_PATIENT_ID" id="P_PATIENT_ID" size="11" maxlength="10" value="" onKeyPress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this);"><input align="right" class="button" type="button" name="search" id="search" value="?" onClick="callPatientSearch()"> 
</td>
<td colspan="2">&nbsp;</td>
</tr>

<tr><td colspan="4">&nbsp;</td></tr>

<tr>
<td class="label" align="left" nowrap><fmt:message key="Common.OrderDateFrom.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" nowrap><input type="text" size="11" name="p_fr_date" id="p_fr_date" maxlength="10" value="" onBlur="validate_from_date(this),CheckDate(this)" style="cursor='hand'">&nbsp;<input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarValidate('p_fr_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif"></img></td>
<td class="label" align="left" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" nowrap><input type="text" name="p_to_date" id="p_to_date" size="11" maxlength="10" value="" onBlur="validate_to_date(this)" style="cursor='hand'">&nbsp;<input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarValidate('p_to_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>

<tr><td colspan="4">&nbsp;</td></tr>
<tr>
<td class="label" align="left" nowrap><fmt:message key="eOR.ServiceDateFrom.label" bundle="${or_labels}"/>&nbsp;</td>
<td align="left" nowrap><input type="text" size="11" name="p_service_from_date" id="p_service_from_date" maxlength="10" value="" onBlur="validate_from_date(this),CheckDate(this)" style="cursor='hand'">&nbsp;<input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarValidate('p_service_from_date');"></td>
<td class="label" align="left" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" nowrap><input type="text" name="p_service_to_date" id="p_service_to_date" size="11" maxlength="10" value="" onBlur="validate_to_date(this)" style="cursor='hand'">&nbsp;<input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendarValidate('p_service_to_date');"></td>
</tr>

<tr><td colspan="4">&nbsp;</td></tr>


<tr>
<td class="label" align="left" nowrap><fmt:message key="eOR.IncludeCancelledTests.label" bundle="${or_labels}"/>&nbsp;</td>
<td align="left"><input type="checkbox" name="p_canc" id="p_canc" value="N" onClick="chkCancelTest(this)"></td>
<td class="label" align="left" nowrap><fmt:message key="eOR.IncludedOnlyBilledTests.label" bundle="${or_labels}"/>&nbsp;</td>
<td align="left"><input type="checkbox" name="p_bill" id="p_bill" checked value="Y"  onClick="chkBilledTest(this)"></td>
</tr>

<tr><td colspan="4">&nbsp;</td></tr>

</table>
	<input type="hidden" name="to_date" id="to_date" value="<%=to_date%>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="OR">
	<input type="hidden" name="p_report_id" id="p_report_id" value="ORBINVLST">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"> 
	<input type="hidden" name="p_user_name" id="p_user_name" value="<%=user_id%>"> 
	<input type="hidden" name="p_include_cancelled_orders" id="p_include_cancelled_orders" value="N"> 
	<input type="hidden" name="p_includ_billed_only" id="p_includ_billed_only"  value="Y" >

</form>
</body>
</html>
<%!
public ArrayList getOrderCategory () throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 			= null;
	String[] record			 =		null;

	ArrayList OrderCategory = new ArrayList() ;

	try {
		connection	= ConnectionManager.getConnection();
		pstmt		= connection.prepareStatement("SELECT short_desc,order_category FROM or_order_category order by short_desc") ;
		resultSet	= pstmt.executeQuery() ;

		while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;
				OrderCategory.add(record) ;
			}
			record=null;
			
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database OrderCategory" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();

		}

		return OrderCategory;
	}

public ArrayList getPatientClass() throws Exception{
	Connection connection=null;	
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ArrayList patient_class=new ArrayList();
	try{
		connection=ConnectionManager.getConnection();
		pstmt=	connection.prepareStatement("SELECT patient_class,short_desc FROM am_patient_class");
		rs=pstmt.executeQuery();
		while(rs !=null && rs.next()){
			String[] record=new String[2];
			record[0]=rs.getString("patient_class");
			record[1]=rs.getString("short_desc");
			patient_class.add(record);	
		}
	}catch(Exception e){
	System.out.println("### Exception in InvestigationCheckListCriteria.jsp,e="+e);
	e.printStackTrace();
	}finally{
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(connection !=null) connection.close();
	
	}

return patient_class;
}

%>

