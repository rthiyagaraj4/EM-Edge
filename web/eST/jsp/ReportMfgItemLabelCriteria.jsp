<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*"%>
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

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eST/js/ReportMfgItemLabel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "StockLevelReportBean";
		String bean_name = "eST.StockLevelReportBean";
		//String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		String code = request.getParameter("sum_code");
		
		StockLevelReportBean bean = (StockLevelReportBean) getBeanObject( bean_id,bean_name ,request );  
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement(),setChangeReport();">
		<form name="MfgItemLabelCriteria" id="MfgItemLabelCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		
				<table cellpadding="0" cellspacing="0" width="74%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
				
				<tr><td  class="label" colspan='4'>&nbsp;&nbsp;</td> </tr>

					<td class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class=fields align="left" width="30%">&nbsp;&nbsp;<select name="p_doc_type_code" id="p_doc_type_code" >
					<% if (code.equals("A"))
							{%>
							
							<%=bean.getDoc_type_code_ListOptions("MFG","")%>
								<%}
									else
								{%>

							<%=bean.getDoc_type_code_ListOptions("PRT","")%>
								
							<%}
							%>
					</select><%=bean.getImage("M")%> </td>
				<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=7 name="store_code" id="store_code"><input class="button" onClick="return searchCodeStore(store_code);" type="button" value="?"></td>
					
				</tr> 
				<tr><td   class="label" colspan='4'>&nbsp;&nbsp;</td> </tr>
				<tr>
				<td class=label><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>.</td>
				<td class=fields  width="10%">&nbsp;&nbsp;<input maxLength=20 size=10 name="p_doc_no" id="p_doc_no" value=""></td>
					<td  class="label" width="10%" nowrap>&nbsp;&nbsp;<fmt:message key="eST.NoofCopies.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=10 name="p_no_labels" id="p_no_labels" value="" ><%=bean.getImage("M")%></td>
				</tr>
				<tr>
						<td>&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;</td>
						</tr>
				<tr>
					<td class=label align=left><fmt:message key="eST.PeriodFromDate.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name="p_fr_doc_date" id="p_fr_doc_date" size=10 maxlength=10 class="DATE" value=""  onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_doc_date');"></img></td>
					<td class="label" align=left><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name="p_to_doc_date" id="p_to_doc_date" size=10 maxlength=10 class="DATE" value=""  onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date');"></img></td>
				</tr>  				
				<% 
					if(code.equals("A")) {%> 
				<tr>
					<td  class="label" colspan='4'>&nbsp;&nbsp;</td> 
				</tr>						
					<tr>
					<td class="label"><fmt:message key="Common.labelType.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<select name="p_label_type" id="p_label_type" onChange ="ChangeReport(document.MfgItemLabelCriteria);">
					<option value="A"><fmt:message key="eST.WithFormulary.label" bundle="${st_labels}"/></option>
					<option value="B"><fmt:message key="eST.WithoutFormulary.label" bundle="${st_labels}"/></option></select></td>
				<%
					}
				else {
				%>
						<input type="hidden" name="p_label_type" id="p_label_type" 		value="A">		
					<%
					}
					%>
				</tr>
				<tr>
				<td>&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;</td>
				 <td align='right' colspan=4><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage();"></td>  
		        </tr> 
				</table>		
				<input type="hidden" name="p_report_id" id="p_report_id">
			<input type = "hidden" name ="Report_type" value ="<%=code%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" 
			value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
		</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	


