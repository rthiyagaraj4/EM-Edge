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
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	
 <%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/QAPReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
	<%
		
		String bean_id		 = "QAPReportBean";
		String bean_name = "eST.QAPReportBean";
		String facility_id		 =  (String) session.getValue( "facility_id" ) ;
		String user_name	 =  (String) session.getValue( "login_user" ) ;

		QAPReportBean bean = (QAPReportBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
	%>

	<body onLoad="FocusFirstElement();">
	<form name="formQAPReport" id="formQAPReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<br></br>
			<br></br>
			<br></br>
			<tr>
			<td width='100%' align='center' class="WHITE">
			<table cellpadding="2" cellspacing="0" width="70%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					 <td align="right" class="label" >&nbsp;</td>
					 <td align="right" class="label" >&nbsp;</td>
					 <td align="right" class="label" >&nbsp;</td>
					 <td align="right" class="label" >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" width='20%'><fmt:message key="Common.QAPReport.label" bundle="${common_labels}"/></td>
					<td align="left"  colspan ="3">&nbsp;<select name="qapreportoption" id="qapreportoption" onchange="setreportid();"><option value="" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------&nbsp;&nbsp;</option><option value="A"><fmt:message key="eST.QAP13AnnualTurnoverRateofStock.label" bundle="${st_labels}"/></option><option value="B"><fmt:message key="eST.QAP14Proportionofvalueofstockswrittenoff.label" bundle="${st_labels}"/> </option></select><%=bean.getImage("M")%></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td align="left" colspan ="3">&nbsp;<SELECT name="p_facility_id" id="p_facility_id"><OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------&nbsp;&nbsp;</OPTION>
					<%
						ArrayList	arraylist		 =	null;
						HashMap	hmFacility =	null;
						String facility				 = "";
						String	desc					 =	"";
						arraylist		=	bean.getFacility();
						int arrLength		=	arraylist.size();
						for(int i=0;i<arrLength; i++)
						{
							hmFacility   	=	(HashMap) arraylist.get(i);
							facility			=	(String)hmFacility.get("facility");
							desc				=	(String)hmFacility.get("desc");
				%> 
						<option value="<%=facility%>"><%=desc%></option> 	
				<% 	} %>
					</select><%=bean.getImage("M")%></td>
					
                </tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td  class='fields' colspan ="3">&nbsp;<input maxLength=6 size=6 name="p_store_code" id="p_store_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_store_code);"  type="button" value="?"><%=bean.getImage("M")%></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eST.PeriodFrom.label" bundle="${st_labels}"/></td>
					<td  class=fields colspan ="3">&nbsp;<input maxLength=2 class=number size=4 name="P_FM_MOVE_MONTH" id="P_FM_MOVE_MONTH" value="" onKeyPress="numbervalidation();"> &nbsp;/&nbsp; <input maxLength=4 class=number size=4 name="P_FM_YEAR" id="P_FM_YEAR" value="" onKeyPress="numbervalidation();"><%=bean.getImage("M")%> &nbsp;&nbsp;To&nbsp;&nbsp;<input maxLength=2 class=number size=4 name="P_TO_MOVE_MONTH" id="P_TO_MOVE_MONTH" value="" onKeyPress="numbervalidation();">&nbsp;&nbsp;/&nbsp;<input maxLength=4 class=number size=4  name="P_TO_YEAR" id="P_TO_YEAR" value="" onKeyPress="numbervalidation();"><%=bean.getImage("M")%> </td>
					
				</tr>
				<tr>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
                </tr>

				</table>
				</td>
				</tr>
			</table>
			    <input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			    <input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>">
			    <input type="hidden" name="p_module_id" id="p_module_id" 	value="ST">
			    <input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_name%>">
			    <input type="hidden" name="p_facility_id_1" id="p_facility_id_1"	value="<%=facility_id %>">
			    <input type="hidden" name="p_report_id" id="p_report_id"     value="" >
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">					
			</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
		<%putObjectInBean(bean_id,bean,request);%>
	</body>
</html>

