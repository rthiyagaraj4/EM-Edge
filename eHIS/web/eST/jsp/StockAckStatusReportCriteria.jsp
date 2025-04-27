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
		<script language="javascript" src="../../eST/js/StockAckStatusReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id					=		"stHeaderBean";
		String bean_name				=		"eST.Common.StHeaderBean";
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
		String to_date					=  		com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
			
		StHeaderBean bean = (StHeaderBean) getBeanObject( bean_id,  bean_name, request );  

	%>
	<body onLoad="FocusFirstElement()">
		<form name="StockAckStatusReportCriteria" id="StockAckStatusReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
								
				<tr>
					<td align="right">&nbsp;</td>
					<td  class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td  class="fields" colspan=5 width"10%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eST.AcknowledgementDate.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;
					
					<input type=text name="from_acknowledge_date" id="from_acknowledge_date" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_acknowledge_date');" ></img><%=bean.getImage("M")%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="label">&nbsp;</td><td class=fields >&nbsp;&nbsp;<input type=text name="to_acknowledge_date" id="to_acknowledge_date"  size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_acknowledge_date');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20  name="from_item_code" id="from_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(from_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="to_item_code" id="to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(to_item_code);" type="button" value="?"  ></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eST.IssuingStore.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="issuing_store" id="issuing_store"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(issuing_store);"  type="button" value="?"></td>
					<td  class="label">Receiving Store</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6 name="receiving_store" id="receiving_store" value="" ><input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore(receiving_store);"  type="button" value="?" ></td>
				</tr>
				<tr>
					<td  class="label" width="20%"><fmt:message key="eST.AcknowledgementStatus.label" bundle="${st_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<SELECT name="acknowledge_status" id="acknowledge_status" >
					<OPTION VALUE="A"> <fmt:message key="Common.all.label" bundle="${common_labels}"/> </OPTION>
					<OPTION VALUE="F"> <fmt:message key="eST.PendingAckRejZero.label" bundle="${st_labels}"/> </OPTION>
					<OPTION VALUE="P"> <fmt:message key="eST.PendingAckRejNonZero.label" bundle="${st_labels}"/> </OPTION>
					<OPTION VALUE="R"> <fmt:message key="eST.RejectNonZero.label" bundle="${st_labels}"/> </OPTION>
					</select>
					
				</tr>
				           
				</table>
				</td>  

				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="fm_date" id="fm_date" 						value="">
			<input type="hidden" name="to_date" id="to_date" 						value="">
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
			<input type="hidden" name="p_report_id" id="p_report_id"						value="STBSTKACK">

			 
	         
		  	    
</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			
	<%
putObjectInBean(bean_id,bean,request);
    %>	
	</body>
</html>	

