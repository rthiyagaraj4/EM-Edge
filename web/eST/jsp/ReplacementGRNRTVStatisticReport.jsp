<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.*, eCommon.Common.*"%>
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
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/ReplacementGRNRTVStatistics.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "ReplacementGRNRTVStatisticReport";
		String bean_name = "eST.ReplacementGRNRTVStatisticReport";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		ReplacementGRNRTVStatisticReport bean = (ReplacementGRNRTVStatisticReport) getBeanObject( bean_id, bean_name, request );  
		bean.clear();
		bean.setLanguageId(locale);
		
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="ReplacementGRNRTVStatisticReport" id="ReplacementGRNRTVStatisticReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="" width='75%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				 <th colspan=4 align=left>
				 <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th> 
				
				<tr>
					<td align="right" class="label">
					<fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
					<td align="left"  colspan="1">&nbsp;&nbsp;<select name="p_supp_code" id="p_supp_code" ><option value="">&nbsp;&nbsp;&nbsp;-----
					<fmt:message  key="Common.defaultSelect.label"bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
					<%
					
					ArrayList	arrStore		=	null;
					HashMap		hmStore			=	null;	
					String code = "",	desc		=	"";
					//String store_select				=	"";

					arrStore		=	bean.getStoreList();
					int arrLength	=	arrStore.size();
					for(int i=0;i<arrLength; i++)
					{
						hmStore      		=	(HashMap) arrStore.get(i);

						code				=	(String)hmStore.get("code");
						desc				=	(String)hmStore.get("description");
						%>
							<option value="<%=code%>" ><%=desc%></option>
							
						<%
					}
					%>
					</select></td>
					<td class = "label" align = "right">
					<fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td align="left	"  >&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" onchange ="reportType()" >
					<option value="S">&nbsp;
					<fmt:message key="Common.Summary.label" bundle="${common_labels}"/>&nbsp;&nbsp;</option>
					<option value="D">&nbsp;
					<fmt:message key="Common.Detail.label" bundle="${common_labels}"/>&nbsp;&nbsp;</option>
					</td>
					</tr>
				
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;
					<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" ></td>
					<td class="fields" >&nbsp;&nbsp;
					<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				

 				<tr>
					<td align="right" class="label">
					<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
					</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label"  align=right></td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>

				<tr>
					<td class=label ><fmt:message key="eST.ReturnPeriod.label" bundle="${st_labels}"/></td>
					<td class=fields colspan =1>&nbsp;&nbsp;<input type='text' name='p_fr_doc_date' id='p_fr_doc_date' size=10 maxlength=10 class="DATE" value=""  onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_doc_date');"></img></td>
					<td class="label" align=right></td>
					<td class=fields >&nbsp;&nbsp;<input type='text' name='p_to_doc_date' id='p_to_doc_date' size=10 maxlength=10 class="DATE" value=""  onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date');"></img></td>
				</tr>
			
				<tr>
				<td class=label ><fmt:message key="Common.ReplacementStatus.label" bundle="${common_labels}"/>
				<td class=fields colspan =4>&nbsp;&nbsp;<select name="p_rep_option" id="p_rep_option" onchange ="reportType()" >
				<!-- <option value="">&nbsp;&nbsp;&nbsp;-----Select-----&nbsp;&nbsp;&nbsp;</option> -->
					<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="P"><fmt:message key="Common.Pending.label" bundle="${common_labels}"/> </option>
					<option value="F"><fmt:message key="Common.completed.label" bundle="${common_labels}"/> </option>
					</td>

				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>

				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 	value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBRPSTA">
			<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
           <input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
		</form>
		 <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" 
		 value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

