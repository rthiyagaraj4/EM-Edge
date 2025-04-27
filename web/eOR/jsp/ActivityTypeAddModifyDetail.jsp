<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 
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
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eOR/js/ActivityType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
//out.println(request.getParament("mode"));
//out.println(request.getParament("order_category"));
	
	String mode	   = request.getParameter("mode") ;
	String bean_id = "Or_activity_type" ;
	String bean_name = "eOR.ActivityType";
	int totalRecords=0;
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	//String order_category_id=request.getParameter("order_category");
%>
<form name='ActivityTypeDetail' id='ActivityTypeDetail' target='messageFrame' >
<p>
<table class='grid' width='100%'>
<tr>
<td class='COLUMNHEADER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td> 
<td class='COLUMNHEADER'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
</tr>

<%

int i = 0;
//out.println("mode="+mode);
while(i < totalRecords){

	String  classValue = "";

	if ( i % 2 == 0 )
		  	classValue = "gridData" ;
		  else
		  	classValue = "gridData" ;
%>
<tr>
	<td  class='<%=classValue%>' nowrap >
		  <input type=text name="activity_type<%=i%>" id="activity_type<%=i%>" value="" onBlur="ChangeUpperCase(this);resetColorCode(this);" onkeypress="return CheckForSpecChars(event)"  size=10 maxlength=10 value=""
		>
			<%if(i==0){%><img src="../../eCommon/images/mandatory.gif" ></img><%}%></td>
	
	<td  class='<%=classValue%>' nowrap >
		  <input type=text name="long_desc<%=i%>" id="long_desc<%=i%>" value="" onBlur="resetColorCode(this);makeValidString(this);"  size='30' maxlength='30' 
		>
			<%if(i==0){%><img src="../../eCommon/images/mandatory.gif" ></img><%}%></td>

	<td  class='<%=classValue%>' nowrap >
		  <input type=text name="short_desc<%=i%>" id="short_desc<%=i%>" value="" onBlur="resetColorCode(this);makeValidString(this);"  size='15' maxlength='15' 
		>
			<%if(i==0){%><img src="../../eCommon/images/mandatory.gif"  ></img><%}%></td>

	<td  class='<%=classValue%>'>
		  <SELECT name="order_type_code<%=i%>" id="order_type_code<%=i%>" >
				<option value=''>  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
				<option value='*ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		  </SELECT>

	<td  class='<%=classValue%>'>
	<input type="checkbox" name="eff_status<%=i%>" id="eff_status<%=i%>" value="E" checked  ></td>

</tr>
<%
	i++;
}
%>
<table>

<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="function_id" id="function_id" value="Activity_Type">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
<input type="hidden" name="order_category" id="order_category" value="">

</form>
</body>
</html>

