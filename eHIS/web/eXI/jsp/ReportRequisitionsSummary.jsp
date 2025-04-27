<!DOCTYPE html>
<%@ page import ="java.util.*,java.text.*,java.sql.*,webbeans.eCommon.*, eXI.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 <%-- Mandatory declarations end --%>
<html>
<head>
<html>
<TITLE></TITLE>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>

<%
	String p_module_id		= "XI" ;
//	String p_report_id		= "" ;
	String p_passing_local_date="";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
//		System.out.println("ReportRequisitionsSummary Locale : "+locale);
	if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src='../../eXI/js/RequisitionsSummary.js'></script> 
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


 

</HEAD>

<BODY  onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<% 
	String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
%>
<br>
<br>
<form name="repRequisitionsSumm" id="repRequisitionsSumm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<td  class='columnheader' align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</td>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center'  >

				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="eXI.RequestedOrg.Label" bundle="${xi_labels}"/></td>
					<td width='50%'  >
						<input type="text" name="org_id" id="org_id" size=10  value="">
						<input type=text id="org_desc"  name =org_desc size=25 value=''> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=orgIDSearch value='?'    onClick='searchOrgID();'>
					</td>
				</tr>

				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/> &nbsp;</td>
					<td width='50%'  >
						<input type="text" name="store_code" id="store_code" size=10  value="">
						<input type=text id="store_desc"  name =store_desc size=25 value=''> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=storeCodeSearch value='?'    onClick='searchStoreCode();'>
					</td>
				</tr>

					<tr>
						<td  width="30%">&nbsp;</td>
						<td class="fields" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td align='right' width='30%' class="label"> <fmt:message key="Common.requesteddate.label" bundle="${common_labels}"/><!--Requisition Date Range &nbsp; --></td>
						<td width='30%' >
							<input type=text size=12 maxlength="12"  value='' align="center"  name='dt_from' id='dt_from' onBlur="sysDateCheck(sysdate,dt_from);validate_date(this,'TO_DATE_LESS_FROM')"> <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dt_from','dd/mm/y');"  >
							<input type=text size=12 maxlength="12"  value='' name='dt_to' id='dt_to' align="center" onBlur="sysDateCheck(sysdate,dt_to);validate_date(this,'TO_DATE_LESS_FROM')"> <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dt_to','dd/mm/y');"  >
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				
                 <tr>												
					<td align='right' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> &nbsp;</td>
					<td  width='20%' align="left">
					<select name='report_type' id='report_type'>
							<!--	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option> -->
							<option value='U' ><fmt:message key="eXI.PendingApproval.Label" bundle="${xi_labels}"/></option> 
							<option value='A' ><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></option> 
							<option value='L' ><fmt:message key="eXI.PartialReceipt.Label" bundle="${xi_labels}"/></option> 
							<option value='C' ><fmt:message key="eXI.FullReceipt.Label" bundle="${xi_labels}"/></option> 						
							<option value='XI' ><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
							<option value='ALL' >Consolidated</option> 
							<option value='XE' ><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option> 
					</select>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr>
				<!-- <fmt:message key="eXI.Summary/DetailBy.Label" bundle="${xi_labels}"/>  -->
					<td align='right' width='30%' class="label"><fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/>
					</td>
					<td  width='20%' align="left">
					<select name ='view_by'  >
						<!--	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option> -->
						<option value='SC' ><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></option> 
						<option value='RO' ><fmt:message key="eXI.RequestedOrg.Label" bundle="${xi_labels}"/></option> 
					</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type="hidden" name="sysdate" id="sysdate" value="<%=Sysdate%>">


</form>
</BODY>
</HTML>

