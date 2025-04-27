<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script>
 -->		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script>
 -->		<script language="javascript" src="../../eST/js/MfgItemLabel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "StockLevelReportBean";
		String bean_name = "eST.StockLevelReportBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		StockLevelReportBean bean = (StockLevelReportBean) getBeanObject( bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		bean.clear();
		
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="MfgItemLabelCriteria" id="MfgItemLabelCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			
			<td width='100%' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="75%" align="center" border="0">
				<th colspan=4><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
				<tr><td class="label" colspan='4'>&nbsp;&nbsp;</td> </tr>

					<td class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class=label width="10%">&nbsp;&nbsp;<select name="p_doc_type_code" id="p_doc_type_code" ><%=bean.getDoc_type_code_ListOptions("MFG","")%>
					</select><%=bean.getImage("M")%> </td>
					<td class=label>&nbsp;&nbsp;<input maxLength=20 size=10 name="p_doc_no" id="p_doc_no" value="" ><%=bean.getImage("M")%></td>
				</tr> 
				<tr><td class="label" colspan='4'>&nbsp;&nbsp;</td> </tr>
				<tr>
					<td class="label"><fmt:message key="eST.NoofCopies.label" bundle="${st_labels}"/></td>
					<td class=label colspan=7>&nbsp;&nbsp;<input maxLength=20 size=10 name="p_no_labels" id="p_no_labels" value="" ><%=bean.getImage("M")%></td>
				</tr>
				
				<tr><td   class="label" colspan='4'>&nbsp;&nbsp;</td> </tr>            
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBMFGLB">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">

			<input type="hidden" name="SQL_ST_ALPHA_LOOKUP" id="SQL_ST_ALPHA_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ALPHA_LOOKUP")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP")%>">

		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

