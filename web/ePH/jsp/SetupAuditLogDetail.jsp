<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%request.setCharacterEncoding("UTF-8");
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
	String log_id	            = request.getParameter("log_id");
	String log_bean_id			= "SetupAuditLogBean" ;
	String log_bean_name		= "ePH.SetupAuditLogBean";
	String classValue		    = "";
	String image				= "";
	SetupAuditLogBean log_bean  = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
    log_bean.setLanguageId(locale);
	ArrayList detail_values	    = (ArrayList) log_bean.getDetailvalues(table_id,log_id);
   %>	
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="patientiddisplaytable">
			<tr id="header">
				<th width="20%"align="center"><fmt:message key="Common.Field.label" bundle="${common_labels}"/></th>
				<th width="20%"align="center"><fmt:message key="Common.OldValue.label" bundle="${common_labels}"/></th>
				<th width="25%"align="center"><fmt:message key="Common.NewValue.label" bundle="${common_labels}"/> </th>
			</tr>
			<% for(int i=0;i<detail_values.size();i=i+9){
					if(i%2==0)
						classValue	=	"QRYEVEN";
					else
						classValue	=	"QRYODD";
			%>
				  <tr>
					  <td align="left" width="20%"class="<%=classValue%>"><label> <%=detail_values.get(i+1)%> </label></td>	
				     <% if(!detail_values.get(i+6).equals("C")){
						  if(detail_values.get(i+6).equals("S")){%>	
							  <td align="left" width="25%"class="<%=classValue%>"><label> <%=detail_values.get(i+5)%> </label></td>
							  <td align="left" width="35%"class="<%=classValue%>"><label> <%=detail_values.get(i+3)%> </label></td> 
						<%}else{%>
							 <td align="left" width="25%"class="<%=classValue%>"><label> <%=detail_values.get(i+7)%> </label></td>
							  <td align="left" width="35%"class="<%=classValue%>"><label> <%=detail_values.get(i+8)%> </label></td> 
					<%	 }
			          }else{%>
						  <td align="left" width="25%"class="<%=classValue%>"><%
					       if(detail_values.get(i+7).equals("E")||detail_values.get(i+7).equals("Y")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(detail_values.get(i+7).equals("D")||detail_values.get(i+7).equals("N")){%><img src="../../eCommon/images/disabled.gif"></img> <%}%></td>

						   <td align="left" width="25%"class="<%=classValue%>"><%
					       if(detail_values.get(i+8).equals("E")||detail_values.get(i+8).equals("Y")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(detail_values.get(i+8).equals("D")||detail_values.get(i+8).equals("N")){%><img src="../../eCommon/images/disabled.gif"></img> <%}%></td>	

				    <%}%>
				  </tr>	
		  <%}%>
	   </table>  

</form>
</body>
</html>
<%
putObjectInBean(log_bean_id,log_bean,request);
%>

