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
 -->	 <%

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
	<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/StockHandledByMedStoreReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
	<%
		
		String bean_id = "stockHandledByMedStoreBean";
		String bean_name = "eST.StockHandledByMedStoreBean";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		StockHandledByMedStoreBean bean = (StockHandledByMedStoreBean) getBeanObject( bean_id, bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockHandledByMedStoreReport" id="formStockHandledByMedStoreReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<BR></br>
			<BR></br>
			<BR></br>

			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="2" cellspacing="0" width="65%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
                </tr>
				<tr>
					<td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td><td align="left" class="fields" colspan ="2">&nbsp;&nbsp;<SELECT name="p_facility_id" id="p_facility_id" ><OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------&nbsp;&nbsp;</OPTION>		
		  <%
					ArrayList	arraylist		=	null;
					HashMap		hmFacility		=	null;
					String facility = "";String	desc	=	"";
					arraylist		=	bean.getFacility();
					int arrLength		=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmFacility   	=	(HashMap) arraylist.get(i);
						
						facility				=	(String)hmFacility.get("facility");

						desc				=	(String)hmFacility.get("desc");
					
					%> 	<option value="<%=facility%>"><%=desc%></option> 	
				<% 	} %>
						</select><%=bean.getImage("M")%></td>
						<td class="label">&nbsp;</td>
				
                </tr>
										
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td class="fields" ><fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=label>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					
					<td class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td  class="fields">&nbsp;&nbsp;<input maxLength=6 size=10 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_fm_store_code);" type="button" value="?"><%=bean.getImage("M")%> </td>
					<td  class="fields"><input maxLength=6 size=10 name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeStore(p_to_store_code);" type="button" value="?"><%=bean.getImage("M")%>
					</td>
					<td class=label>&nbsp;&nbsp;</td>
				</tr>
					
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
					<td  align="left" class="fields" >&nbsp;&nbsp;<input maxLength=4 class=number size=10 name="p_fm_year" id="p_fm_year" value="" onKeyPress="numbervalidation();" onblur="disptoyear();"><%=bean.getImage("M")%> </td>
					<td align="left" class="fields"><input maxLength=4 size=10 class=number name="p_to_year" id="p_to_year" value="" onKeyPress="numbervalidation();"><%=bean.getImage("M")%></td>
					<td class=label>&nbsp</td>
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
			    <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			    <input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			    <input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			    <input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			    <input type="hidden" name="p_facility_id_1" id="p_facility_id_1"			value="<%=facility_id %>">
			    <input type="hidden" name="p_report_id" id="p_report_id"         value="STBSTKMS">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">					
			</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">			
				<%putObjectInBean(bean_id,bean,request);%>

	</body>
</html>

