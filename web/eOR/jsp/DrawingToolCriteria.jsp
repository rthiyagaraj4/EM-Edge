<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
 <%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
 <jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%
	String bean_id 			= request.getParameter("bean_id");
	String bean_name 		= request.getParameter("bean_name");
	/* Mandatory checks end */
// 	Properties properties	= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
%>

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head><title><fmt:message key="eOR.OrderEntryDrawingToolItems.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
  	<script language="javascript" src="../../eOR/js/DrawingTool.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name ="drawingToolCriteria">
<table class="BOX" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
<tr>
<%
		ArrayList DrawingTools	= null;
		String[] record			= null;
%>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
		     <td width="10%"  align="right" class="label" nowrap><fmt:message key="Common.Image.label" bundle="${common_labels}"/></td>
			 <td align="left" width="20%" class="label">
		   	 <select name="image_ref" id="image_ref"  width="15" onChange="populateCatalogs(this)">
			 <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${or_labels}"/>---</option>
<%				//DrawingTools	 =  beanQueryObj.getDrawingImage(properties);
				DrawingTools	 =  null; //No longer used (this was done for the tabs)
			    for(int i=0; i<DrawingTools.size(); i++)
			    {
					record	= (String[])DrawingTools.get(i);
 					out.println("<option value = '"+record[0]+"' > "+record[1]+" </option>");
			    }
%>
			</select>
			</td>
			</table>
<%			 
		// Nullifying the objects
 		DrawingTools			= null;			record				= null;
%>
	</table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">

  </form>
	<script>
		populateCatalogs(document.drawingToolCriteria.image_ref);
	</script>
</body>
</html>

