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
	String p_report_id		= "XIEXCSUD" ;
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
<script language="JavaScript" src='../../eXI/js/ExceptionReport.js'></script> 
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>





</HEAD>

<BODY  onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<% 
	String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
%>
<br>
<br>
<form name="exceptionReport" id="exceptionReport" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th  class='columnheader' align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center'  >

				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
					<td width='50%'  >
						<input type="text" name="p_item_code" id="p_item_code" size=10  value="">
						<input type=text id="p_item_desc"  name =p_item_desc size=25 value=''> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=itemSearch value='?'    onClick='searchItemCode();'>
					</td>
				</tr>

				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/> &nbsp;</td>
					<td width='50%'  >
						<input type="text" name="p_store_code" id="p_store_code" size=10  value="">
						<input type=text id="p_store_desc"  name =p_store_desc size=25 value=''> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=storeCodeSearch value='?'    onClick='searchStoreCode();'>
					</td>
				</tr>

				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/> &nbsp;</td>
					<td width='50%'  >
						<input type="text" name="p_itemclass_code" id="p_itemclass_code" size=10  value="">
						<input type=text id="p_itemclass_desc"  name =p_itemclass_desc size=25 value=''> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=itemClassSearch value='?'    onClick='searchItemClass();'>
					</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type="hidden" name="sysdate" id="sysdate" value="<%=Sysdate%>">


</form>
</BODY>
</HTML>

