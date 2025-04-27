<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------
02/07/2015 	IN054381		Akbar Sharif									MMS-QF-CRF-0211
07/08/2015	IN056781		Vijayakumar K	12/08/2015		Dinesh T		RF-OR-MMS-QF-CRF-0211/03-When Special Characters 
																			are used in Order Catalog field, system displays different error messages
----------------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page	import="java.util.*, eOR.*,java.sql.*,webbeans.eCommon.ConnectionManager,eOR.Common.*,eCommon.Common.*" %>
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
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/OROrderStatusTrackingRpt.js"></script>
    <script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
  	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
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
	bean.setLanguageId(localeName); 	
	curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
	curr_week_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,7,"d");
	prev_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,1,"d");

	ArrayList order_category = bean.getOrderCategoryWithoutCareSet(properties);

%>
<form name='Or0rderStatusTrackingRptForm' id='Or0rderStatusTrackingRptForm' target='messageFrame' action=''>
<table cellpadding=3 cellspacing=0  width="100%" align="center" border='0'>
	<tr>
	  <th colspan="4" align="left"><fmt:message key="eOR.ReportCriteria.label" bundle="${or_labels}"/></th>
	  </tr>
	  <tr><td colspan="4">&nbsp;</td></tr>
<tr>
	 <td  class=label id='period_td' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<!-- IN056781 starts -->
	<!--<td class=fields ><input type="text" name="p_frm_date" id="p_frm_date" value="<%=curr_week_date%>" size="12" maxlength="10" onBlur="CheckDate(this);validate_from_date()"><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_frm_date');" style='cursor:pointer'><font size="4">&nbsp;-&nbsp;</font><input type="text" name='p_to_date' id='p_to_date' value='<%=curr_sys_date%>' size="12" maxlength="10" onBlur="CheckDate(this);validate_to_date()" ><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_to_date');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif"></img>
	</td>-->
	<td class=fields ><input type="text" name="p_frm_date" id="p_frm_date" value="<%=curr_week_date%>" size="12" maxlength="10" onBlur="validate_from_date()"><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_frm_date');" style='cursor:pointer'><font size="4">&nbsp;-&nbsp;</font><input type="text" name='p_to_date' id='p_to_date' value='<%=curr_sys_date%>' size="12" maxlength="10" onBlur="validate_to_date()" ><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_to_date');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif"></img>
	</td>
	<!-- IN056781 ends -->
</tr>
<tr>
	 <td  class=label ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>
	 <td class=fields ><select name="p_order_category" id="p_order_category" onChange="FillOrderType(this);">
		<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%if(order_category.size()>0){
			for(int i=0;i<order_category.size();i++){
				String[] ordertype = (String[])order_category.get(i);
		%>
				<option value="<%=ordertype[0]%>" ><%=ordertype[1]%></option>
				
		<%  }
		}%>
	</select>
	</td>
	<td class=label ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name="p_grp_by" id="p_grp_by" onChange="enableOrderType();">
		<option value="O"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option>
		<option value="C" selected><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></option>
	</select></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
	<td class='fields' > <input type="text" name="ordering_pract_desc" id="ordering_pract_desc" value="" onblur='orderingpractSearch1(ordering_pract_desc,p_ord_pract_id);'><input type=button name='practSearch' id='practSearch' value='?'  class=button tabIndex="4" onClick="orderingpractSearch(ordering_pract_desc,p_ord_pract_id);"><input type="hidden" name="p_ord_pract_id" id="p_ord_pract_id" value="">
	<td class=label id = "order_type_label" style='visibility:hidden'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td class=fields id = "order_type_value" style='visibility:hidden'><select name="p_order_type_code" id="p_order_type_code">
		<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	</select>
	</td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class=fields ><select name="p_priority" id="p_priority">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="S"><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
						<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
		</select>
	</td>
	<td class=label id = "order_catalog_label" style='visibility:hidden'>
	<fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<!-- IN056781 starts-->
	<!--<td class=fields id = "order_catalog_value" style='visibility:hidden'><input type='text'  name='p_ord_catalog' id='p_ord_catalog' value='' maxlength='20' size="15" >-->
	<td class=fields id = "order_catalog_value" style='visibility:hidden'><input type='text'  name='p_order_catalog' id='p_order_catalog' value='' maxlength="40" size="15" onBlur="makeValidQueryCriteria(this)">
	<!-- IN056781 ends-->
				<select name="P_CAT_FILTER_CRITERIA" id="P_CAT_FILTER_CRITERIA">
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
				</select>
	</td>
</tr>
</table>

<input type="hidden" name="to_date" id="to_date" value="<%=curr_sys_date%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="OR">
<input type="hidden" name="p_report_id" id="p_report_id" value="">
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"> 
<input type="hidden" name="p_user_name" id="p_user_name" value="<%=user_id%>"> 
<input type="hidden" name="language_id" id="language_id" value="<%=localeName.toLowerCase()%>"> 
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="tempdate" id="tempdate" value="<%=curr_week_date%>">
<input type="hidden" name="prev_date" id="prev_date" value="<%=prev_date%>">
</form>
</body>
</html>

