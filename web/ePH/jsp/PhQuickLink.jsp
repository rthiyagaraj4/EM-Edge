<!DOCTYPE html>
<!-- 
Developed by    :Arun Kumar M
Module/Function : Drug Quick Info
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<title>
	</title>
  <%
		request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script> 
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 >
		<form name="PhDrugQuickInfoForm" id="PhDrugQuickInfoForm">
<%
			String	bean_id						=	"PhDrugInfoEnqBean" ;
			String	bean_name					=	"ePH.PhDrugInfoEnqBean";
			PhDrugInfoEnqBean bean		= (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name,request);
			ArrayList getquickDesc =	bean.getQuickLinkDesc(session.getValue("responsibility_id").toString());
			String homepage=request.getParameter("homepage")==null?"":request.getParameter( "homepage" ) ;
%>
			<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0" id="tab" name="tab">
				<tr class="COMMON_TOOLBAR">
					<td class="COMMON_TOOLBAR" align='right' id='quick' >
						<select name='quick_links' id='quick_links'  onchange='openQuickLinkWindow(this)' style='FONT-SIZE:8pt'>
						<option value = ''>-----<fmt:message key="eCA.QuickLinks.label" bundle="${ca_labels}"/>-----</option>
<% 
						for(int i=0;i<getquickDesc.size();i+=2){
%>	
							<option value="<%=(String)getquickDesc.get(i+1)%>"><%=(String)getquickDesc.get(i)%></option>
<%
						}
%>		
						</select>
					</td>			
				</tr>
			</table>
			<INPUT TYPE="hidden" name="homepage" id="homepage" VALUE="<%=homepage%>">
		</form>
	</body>
</html>

