<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
12/08/2013 IN037296			Vijayakumark	Alpha-OR-OR Reports->System is displaying Fatal error for leap date in Thai 
29/08/2013 IN030303			Vijayakumark	REGRESSION - OR Reports>Order type is not displayed correctly after cleared for a Category
-----------------------------------------------------------------------
-->
	
	<%@ page contentType="text/html; charset=UTF-8"%>
	<%@page	import="java.util.*, eOR.*,java.sql.*,webbeans.eCommon.ConnectionManager,eOR.Common.*,eCommon.Common.*" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

	<html>
	<head>
		<%
		//Connection con=null;
		//PreparedStatement stmt=null;
		//ResultSet rs=null;
		request.setCharacterEncoding("UTF-8");
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language='javascript' src='../../eCommon/js/dchk.js'></script>
		<script language="javascript" src="../../eOR/js/RepResultCompleteStat.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		
	</head>
	<body onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">  
		<%
		String facility_id = (String)session.getValue("facility_id");
		String user_id = (String)session.getValue("login_user");
			String bean_id      = "RepResultCompleteStatBean" ;
			String bean_name    = "eOR.RepResultCompleteStatBean";
			RepResultCompleteStatBean  bean = (RepResultCompleteStatBean)getBeanObject( bean_id,  bean_name, request ) ; 
			bean.setLanguageId(localeName);
			bean.clear() ;
		%>
	<form name="RepResultCompleteStatForm" id="RepResultCompleteStatForm"  target="messageFrame">
	<table cellpadding=3 cellspacing=0 width='100%' align='center' >
		<tr><th class='columnheader' align="left"><fmt:message key="eOR.ResultCompletionStatistics.label" bundle="${or_labels}"/></td></tr>
		<%
		/*Thai date validations 15/02/2007 start*/
		String to_date = "";
			/*try
				{
				con=ConnectionManager.getConnection(request);
				String sql_date="Select to_char( sysdate,'dd/mm/yyyy') to_date from dual";
				stmt	=	con.prepareStatement(sql_date);
				rs		=	stmt.executeQuery();
				if(rs!=null)
				{
					if(rs.next())
					{
						to_date = rs.getString("to_date");
					}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				}catch(Exception e)
				{
					e.printStackTrace() ;
				}*/
				to_date=com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
		%>

		<tr>

		<td width="100%" class="Border" align='center'>

		<table border=0 width='100%' cellPadding="3" cellSpacing="3"  align='center' >

		<tr>
			<!-- Here on blur we are calling chkDate() in which we call validDateObj() instead of checkDate() for the Thai Date validation-->
			<td class="label"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=textbox size=11 maxlength=10 name='p_fr_date' id='p_fr_date' onBlur='chkDate(this)'  style="cursor='hand'" value=''><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendarValidate('p_fr_date');" ><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
			<td class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=textbox size=11 maxlength=10 name='p_to_date' id='p_to_date' onBlur='chkDate(this)' style="cursor='hand'" value=''><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendarValidate('p_to_date');" ><img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
		</tr>
		<!-- <tr><td colspan='2'></td></tr>

		 <tr>
			<td class=label align=right>Status</td>
			<td align=left colspan="2"><select name='status' id='status' >
				<option value="C" >Completion</option>
				<option value="R" >Resulted</option>
			</select></td>
		</tr>  -->
		<tr>
			<td class="label" ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<!-- IN030303 starts-->
			<!--<td class='fields'><select name="p_ord_cat" id="p_ord_cat" >-->
			<td class='fields'><select name="p_ord_cat" id="p_ord_cat" onchange="clearOrderType()">
			<!-- IN030303 ends-->
			<option value="" >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<%
			  ArrayList Order_Category = bean.getOrderCategory();
			  String[] record=null;
			  for(int i=0; i<Order_Category.size(); i++)
			  {
			    record = (String[])Order_Category.get(i);
				
				out.println("<option value = '"+record[0]+"'> "+record[1]+" ");	 
			  }
			  Order_Category= null;
			%>
		</select>
		</td>
		</tr>

		<tr>
			<td class="label"><fmt:message key="eOR.OrderTypeFrom.label" bundle="${or_labels}"/></td>
			<!-- IN030303 starts -->
			<!--<td class='fields'><input type=textbox size=11 maxlength=10 name='ord_Type' id='ord_Type' value="" onBlur=' if(this.value != "") orderType_lookup(ord_Type,p_fr_ord_type)'><input type=button name='orderType_btn' id='orderType_btn' class='button' value='?' onClick="orderType_lookup(ord_Type,p_fr_ord_type)" ><input type="hidden" name="p_fr_ord_type" id="p_fr_ord_type" value=""></td>-->

			<td class='fields'><input type=textbox size=11 maxlength=10 name='ord_Type' id='ord_Type' value="" onBlur='ordertypefrom(ord_Type,p_fr_ord_type)'><input type=button name='orderType_btn' id='orderType_btn' class='button' value='?' onClick="orderType_lookup(ord_Type,p_fr_ord_type)" ><input type="hidden" name="p_fr_ord_type" id="p_fr_ord_type" value=""></td>
			
			<!--<td class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td class='fields'><input type=textbox size=11 maxlength=10 name='to_ord_Type' id='to_ord_Type' value="" onBlur=' if(this.value != "") orderType_lookup(to_ord_Type,p_to_ord_type)'><input type=button name='to_orderType_btn' id='to_orderType_btn' class='button' value='?' onClick="orderType_lookup(to_ord_Type,p_to_ord_type)" ><input type="hidden" name="p_to_ord_type" id="p_to_ord_type" value=""></td>-->

			<td class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td class='fields'><input type=textbox size=11 maxlength=10 name='to_ord_Type' id='to_ord_Type' value="" onBlur='ordertypeto(to_ord_Type,p_to_ord_type)'><input type=button name='to_orderType_btn' id='to_orderType_btn' class='button' value='?' onClick="orderType_lookup(to_ord_Type,p_to_ord_type)" ><input type="hidden" name="p_to_ord_type" id="p_to_ord_type" value=""></td>
			<!-- IN030303 ends -->
		</tr>

		<!-- <tr><td colspan='2'></td></tr>
		<tr>
			<td align="right"  class="label">Activity Type</td>
			<td><input type='hidden' name='activityType_code' id='activityType_code' value=""><input type=textbox size=11 maxlength=10 name='activityType' id='activityType' value="" ><input type='button' class="button" name="activityType_btn" id="activityType_btn" value="?" onClick="populateValues(),activityType_lookup(activityType,activityType_code)">
			<input type="hidden" name="activityType_desc" id="activityType_desc" value=""></td>
		</tr> -->

		<tr>
		<td class=label><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name='p_group_by' id='p_group_by' >
			<option value="O" ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></option>
			<option value="U" ><fmt:message key="Common.user.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		</tr>
		</table>
		</tr>
		</table>

		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="to_date" id="to_date" value="<%=to_date%>">
		<input type="hidden" name="p_module_id" id="p_module_id" value="OR">
		<input type="hidden" name="p_report_id" id="p_report_id" value="ORRTCMPST">
		<input type="hidden" name="p_facility_id" id="p_facility_id" value='<%=facility_id%>'> 
		<input type="hidden" name="p_user_name" id="p_user_name" value='<%=user_id%>'>
		<input type="hidden" name="localeName" id="localeName" value='<%=localeName%>'> 
		
	</form>
	</body>
	</html>

	<%
		putObjectInBean(bean_id,bean,request);
 
%>

