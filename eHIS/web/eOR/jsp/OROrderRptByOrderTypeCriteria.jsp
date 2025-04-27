<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
29/07/2013    IN038751      Karthi L    New report to display the number of orders placed by each practitioner under an Order Type

08/01/2014 	  LICN_1			MMS Internal Issue.
---------------------------------------------------------------------------------------------------------------
-->

<%@page  import="java.util.*, eOR.* , webbeans.eCommon.ConnectionManager ,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.PatOrderByPrivRelQueryBean"/>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
    <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
  	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../js/OROrderRptByOrderType.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"> <!-- onMouseDown="CodeArrest()" onKeyDown="lockKey()" >  -->
<%
/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");

	
	String bean_id = "Or_PatOrderByPrivRelnBean" ;
	String bean_name = "eOR.PatOrderByPrivRelnBean";	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");	

	

	String curr_sys_date = "";
	String curr_week_date  = "";	
	String prev_date  = "";	
	Properties properties		= (Properties) session.getValue( "jdbc" );  
	
	//String localeName =(String) properties.getProperty("LOCALE");	
	bean.setLanguageId(localeName); 	
	curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
	curr_week_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,7,"d");
	prev_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,1,"d");

	ArrayList order_category = bean.getOrderCategoryWithoutCareSet(properties);
	ArrayList practitioners_code = bean.getPractitionerID(properties);

	

%>
<form name='Or0rderRptByOrderTypeForm' id='Or0rderRptByOrderTypeForm' target='messageFrame' action=''>
<table cellpadding=3 cellspacing=0  width="100%" align="center" border='0'>
	<tr>
	  <th colspan="4" align="left">Order Report by Order Type</th>
	  </tr>
	  <tr><td colspan="4">&nbsp;</td></tr>

<tr>
	<td  class=label id='period_td' ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td> <!-- label- LICN_1 -->
<td class=fields ><input type="text" name="p_fm_date" id="p_fm_date" value="<%=curr_week_date%>" size="12" maxlength="10" onBlur="CheckDate(this);validate_from_date()"><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_fm_date');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif"></img>&nbsp;&nbsp;&nbsp; <fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;<input type="text" name='p_to_date' id='p_to_date' value='<%=curr_sys_date%>' size="12" maxlength="10" onBlur="CheckDate(this);validate_to_date()" ><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_to_date');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif"></img><!-- CheckDate() function have been added  // LICN_1 -->
</td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	<td class="fields" > &nbsp; IP &nbsp;<INPUT TYPE="checkbox" name="inpatient" id="inpatient" value="IP" > &nbsp; OP &nbsp;<INPUT TYPE="checkbox" name="outpatient" id="outpatient" value="OP" > &nbsp; DC &nbsp;<INPUT TYPE="checkbox" name="daycare" id="daycare" value="DC" > &nbsp; EM &nbsp;<INPUT TYPE="checkbox" name="emergency" id="emergency" value="EM" > &nbsp; XT &nbsp;<INPUT TYPE="checkbox" name="external" id="external" value="XT" ><img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr> 
	<td class=label ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name="p_ord_pract_id" id="p_ord_pract_id">
		<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%if(practitioners_code.size()>0){
			for(int i=0;i<practitioners_code.size();i++){
				String[] pract_code = (String[])practitioners_code.get(i);
		%>
				<option value="<%=pract_code[0]%>" ><%=pract_code[1]%></option>
				
		<%  }
		}%>
	</select> </td>
</tr>
<tr>
	 <td  class=label ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	 <td class=fields ><select name="p_order_catagory" id="p_order_catagory" onChange="FillOrderType(this);">
		<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%if(order_category.size()>0){
			for(int i=0;i<order_category.size();i++){
				String[] ordertype = (String[])order_category.get(i);
		%>
				<option value="<%=ordertype[0]%>" ><%=ordertype[1]%></option>
				
		<%  }
		}%>
	</select>
	</td>
</tr>
<tr>	
	<td class=label><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name="p_order_type_code" id="p_order_type_code">
		<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	</select></td>	
</tr>

</table>
<input type="hidden" name="to_date" id="to_date" value="<%=curr_sys_date%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="OR">
<input type="hidden" name="p_report_id" id="p_report_id" value="ORORBYOT">
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"> 
<input type="hidden" name="p_user_name" id="p_user_name" value="<%=user_id%>"> 
<input type="hidden" name="language_id" id="language_id" value="<%=localeName.toLowerCase()%>"> 
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="tempdate" id="tempdate" value="<%=curr_week_date%>">
<input type="hidden" name="prev_date" id="prev_date" value="<%=prev_date%>">
<input type="hidden" name="p_patient_class" id="p_patient_class" value="">
<input type="hidden" name="p_from_date_en" id="p_from_date_en" value="">
<input type="hidden" name="p_to_date_en" id="p_to_date_en" value="">

</form>
</body>
</html>

