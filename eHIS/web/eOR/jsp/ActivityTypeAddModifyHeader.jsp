<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ActivityTypeHeader.jsp --> 

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/ActivityType.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	 function lockKey()
	  {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }
	</script>
</head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" onload="FocusFirstElement()">

<%try{
	/* Mandatory checks start */
	
	String mode	   = request.getParameter("mode") ;
	String bean_id = "Or_activity_type" ;
	String bean_name = "eOR.ActivityType";
	/* Mandatory checks end */
	
	/*	Initialize Function specific start */
	
	ActivityType bean = (ActivityType)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setMode( mode ) ;   
	ArrayList orderCategory=new ArrayList();
	/* Initialize Function specific end */
%>
	<form name="ActivityTypeHeader" id="ActivityTypeHeader" method="post" >
	<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" height='100%' align="center">
	<tr>
	<td class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	<td class="fields">
	<select name='order_category' id='order_category' onChange="fillOrderType(this)">
	<option>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	
<%
	orderCategory=bean.getActivityTypeOrderCategory();
	String[] record=null;
	for(int i=0;i<orderCategory.size(); i++){
		record = (String [])orderCategory.get(i);
		

%>	
		<option value="<%=record[0]%>" ><%=record[1]%></option>  
<%
	}orderCategory=null;
%>
	</select>
	<img src="../../eCommon/images/mandatory.gif"></img>
	</td>
	</tr>

	
	</table>

	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="Activity_Type">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="order_category_desc" id="order_category_desc" value="">
		
<%
		putObjectInBean(bean_id,bean,request);
 
}catch(Exception e){
	e.printStackTrace();
	System.err.print("exception in ActivityTypeHeader.jsp="+e);
}
	%>

</form>
</body>
</html>

