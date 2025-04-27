<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<% request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="frmauditlogheader" id="frmauditlogheader" >
<%
	String table_id	            = request.getParameter("table_id");	
	String pkey_value			= request.getParameter("pkey_value");
	String log_bean_id			= "SetupAuditLogBean" ;
	String log_bean_name		= "ePH.SetupAuditLogBean";
	String classValue		    = "";
	SetupAuditLogBean log_bean  = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	ArrayList header_values	    = (ArrayList) log_bean.getHeadervalues(table_id,pkey_value);
		
   %>	
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="patientiddisplaytable">
			<tr id="header">
				<th width="20%"align="center"><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
				<th width="20%"align="center"><fmt:message key="Common.user.label" bundle="${common_labels}"/></th>
				<th width="25%"align="center"><fmt:message key="Common.facility.label" bundle="${common_labels}"/> </th>
	<th width="35%"align="center"><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></th>			
			</tr>
			<% for(int i=0;i<header_values.size();i=i+5){
					if(i%2==0)
						classValue	=	"QRYEVEN";
					else
						classValue	=	"QRYODD";
			%>
				  <tr>
					  <td align="left" width="20%"class="<%=classValue%>"><label id="object_<%=i%>" style="cursor:pointer" class="HYPERLINK1" onClick="showDetails('<%=table_id%>','<%=header_values.get(i+1)%>')"> <%=header_values.get(i)%></label></td>
					  <td align="left" width="20%"class="<%=classValue%>"><label> <%=header_values.get(i+2)%> </label></td>	
					  <td align="left" width="25%"class="<%=classValue%>"><label> <%=header_values.get(i+3)%> </label></td>
					  <td align="left" width="35%"class="<%=classValue%>"><label> <%=header_values.get(i+4)%> </label></td>
				  </tr>	
		  <%}%>
	   </table>
       
		<script>
             if(document.getElementById("object_0")!=null)
					document.getElementById("object_0").click();
       </script>			  

</form>
</body>

</html>
	
<%
putObjectInBean(log_bean_id,log_bean,request);
%>

