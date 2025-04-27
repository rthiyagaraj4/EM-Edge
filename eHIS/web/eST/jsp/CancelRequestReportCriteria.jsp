<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/CancelRequestReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
 		
	</head>
	<%
		
		 
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
		 
        	
	%>
	<body onLoad="FocusFirstElement()">
		<form name="formCancelRequestReportCriteria" id="formCancelRequestReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			   <tr>
			   <td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
				</tr>
                 <tr>
				 </tr>
				 <tr>
				 </tr>
                   <tr>
					<td  class="label"><fmt:message key="eST.RequestbyStore.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_req_by_store_code" id="p_req_by_store_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeStore(p_req_by_store_code);" type="button" value="?"></td>
					<td class="label"><fmt:message key="eST.RequestOnStore.label" bundle="${st_labels}"/></td>
					<td class=fields  colspan = 5>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_req_on_store_code" id="p_req_on_store_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeStore(p_req_on_store_code);" type="button" value="?"></td>
				   </tr>  

                 <tr>
				 </tr>
				 <tr>
				 </tr>
				 <tr>
				  <td class=label >Req.Date From</td>
				  <td>&nbsp;
				  <input type=text name="p_req_date_from" id="p_req_date_from" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_req_date_from');" ></img>&nbsp;</td>
                   <td class=label >Req.Date To</td>
				   <td class=fields colspan = "5">&nbsp;&nbsp;<input type=text name="p_req_date_to" id="p_req_date_to" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);checkDocDate(document.forms[0]);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_req_date_to');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				  </tr>      
				  </table>
				  </td>  
				</tr>
			</table>

			
		 
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="fm_date" id="fm_date" 						value="">
			<input type="hidden" name="to_date" id="to_date" 						value="">
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
			<input type="hidden" name="p_report_id" id="p_report_id"						value="STBCANREQ">
			</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
           
			
	 
	</body>
</html>	

