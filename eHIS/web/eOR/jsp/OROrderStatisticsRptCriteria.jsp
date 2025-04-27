<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
15/03/2016	IN055027		Raja S			Ramesh G		06/04/2016			MMS-QH-CRF-0216

--------------------------------------------------------------------------------------------------------
*/
%>
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
	<script language="JavaScript" src="../js/OROrderStatisticsRpt.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%
	request.setCharacterEncoding("UTF-8");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");	
	String curr_sys_date = "";
	String temp_sys_date = "";
	String curr_week_date  = "";	
	String temp_week_date  = "";
	String prev_date  = "";	
	Properties properties		= (Properties) session.getValue( "jdbc" );  
	bean.setLanguageId(localeName); 	
	curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
	curr_week_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,7,"d");
	if (!localeName.equals("en"))
	{
		temp_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY",localeName,"en");
		temp_week_date= com.ehis.util.DateUtils.convertDate(curr_week_date,"DMY",localeName,"en");
	}
	else
	{
		temp_sys_date=curr_sys_date;
		temp_week_date=curr_week_date;
	}
	prev_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,1,"d");

	ArrayList order_category = bean.getOrderCategoryWithoutCareSet(properties);
%>
<form name='Or0rderStatisticsRptForm' id='Or0rderStatisticsRptForm' target='messageFrame' action=''>
<table cellpadding=3 cellspacing=0  width="100%" align="center" border='0'>
<tr>
	  <th colspan="6" align="left"><fmt:message key="eOR.ReportCriteria.label" bundle="${or_labels}"/></th> 
</tr>
<tr>
	<td colspan="4">&nbsp;</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eOR.practitionerfrom.label" bundle="${or_labels}"/></option></td>
	<td class='fields' > <input type="text" name="from_pract_desc" id="from_pract_desc" value="" onblur='frompractSearch1(from_pract_desc,p_fm_ord_pract_id);'><input type=button name='practSearch' id='practSearch' value='?'  class=button tabIndex="4" onClick="frompractSearch(from_pract_desc,p_fm_ord_pract_id);"><input type="hidden" name="p_fm_ord_pract_id" id="p_fm_ord_pract_id" value=""><img src="../../eCommon/images/mandatory.gif"></img></td>
	<td class='label' ><fmt:message key="eOR.practitionerto.label" bundle="${or_labels}"/></option></td>
	<td class='fields' > <input type="text" name="to_pract_desc" id="to_pract_desc" value="" onblur='topractSearch1(to_pract_desc,p_to_ord_pract_id);'><input type=button name='practSearch1' id='practSearch1' value='?'  class=button tabIndex="4" onClick="topractSearch(to_pract_desc,p_to_ord_pract_id);"><input type="hidden" name="p_to_ord_pract_id" id="p_to_ord_pract_id" value=""><img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td  class=label ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>
	<td class=fields >
		<select name="p_order_category" id="p_order_category" onChange="FillStatsticsOrderType(this);">
		<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%if(order_category.size()>0){
			for(int i=0;i<order_category.size();i++){
				String[] ordertype = (String[])order_category.get(i);
		%>
				<option value="<%=ordertype[0]%>" ><%=ordertype[1]%></option>
				
		<%  }
		}%>
		</select></td>
	<td class=label><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td class=fields >
		<select name="p_order_type_code" id="p_order_type_code">
			<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		</select>
	</td>	
</tr>
<tr>
	<td class=label ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<td class=fields ><input type='text'  name='p_order_catalog_code' id='p_order_catalog_code' value='' maxlength='20' size="15" >
		<select name="P_CAT_FILTER_CRITERIA" id="P_CAT_FILTER_CRITERIA">
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
		</select>
	</td>
	<td  class=label id='period_td' ><fmt:message key="eOR.OrderDateFrom.label" bundle="${or_labels}"/></td> 
	<td class=fields ><input type="text" name="temp_fm_date" id="temp_fm_date" value="<%=curr_week_date%>" size="12" maxlength="10" onBlur="CheckDate(this);val_from_date();chkDatefrm(this)"><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('temp_fm_date');" style='cursor:pointer'><input type="hidden" name="p_fm_date" id="p_fm_date" value="<%=temp_week_date%>"><img src="../../eCommon/images/mandatory.gif"></img>&nbsp;&nbsp;&nbsp; <fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;<input type="text" name='temp_to_date' id='temp_to_date' value='<%=curr_sys_date%>' size="12" maxlength="10" onBlur="CheckDate(this);val_to_date();chkDateto(this)" ><img id="common_calander" src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('temp_to_date');" style='cursor:pointer'><input type="hidden" name="p_to_date" id="p_to_date" value="<%=temp_sys_date%>"><img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
	<td class=fields >
		<select name="p_report_id" id="p_report_id">
					<option value="ORSTBYPR_MMS"><fmt:message key="eOR.rptshift1.label" bundle="${or_labels}"/></option>
					<option value="ORSTBYYM_MMS"><fmt:message key="eOR.rptshift2.label" bundle="${or_labels}"/></option>
		</select>
	</td>
</tr>
</table>
<input type="hidden" name="to_date" id="to_date" value="<%=curr_sys_date%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="OR">
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"> 
<input type="hidden" name="p_user_name" id="p_user_name" value="<%=user_id%>"> 
<input type="hidden" name="language_id" id="language_id" value="<%=localeName.toLowerCase()%>"> 
<input type="hidden" name="p_language_id" id="p_language_id" value="<%=localeName.toLowerCase()%>"> 
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<input type="hidden" name="tempdate" id="tempdate" value="<%=curr_week_date%>">
<input type="hidden" name="prev_date" id="prev_date" value="<%=prev_date%>">
</form>
</body>
</html>

