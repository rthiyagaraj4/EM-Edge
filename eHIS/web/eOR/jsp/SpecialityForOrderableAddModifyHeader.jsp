<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOR/js/SpecialityForOrderable.js"></script>

	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	 function lockKey()
	  {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }
	</script>

<STYLE TYPE="text/css">

	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 

	</STYLE>

</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" onload="FocusFirstElement();loadHeaderDtl(document.getElementById('group_by'));">

<%
	try{
	/* Mandatory checks start */
	
	String mode	   = request.getParameter("mode") ;
	String bean_id = "Or_Speciality_For_Orderable" ;
	String bean_name = "eOR.SpecialityForOrderable";
	/* Mandatory checks end */
	 SpecialityForOrderable bean = (SpecialityForOrderable)getBeanObject( bean_id,  bean_name, request ) ;
	 bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	bean.clearDBRec();
	String catalog_desc=request.getParameter("catalog_desc");
	String order_catalog_code=request.getParameter("order_catalog_code");

	if (catalog_desc==null) catalog_desc="";
	if (order_catalog_code==null) order_catalog_code="";
//	out.println("order_catalog_code"+order_catalog_code);
	/* Initialize Function specific end */
%>

	<form name="SpecialityForOrderableHeader" id="SpecialityForOrderableHeader" method="post" >
	
	<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%">
   	<tr>
	<td class='label' width="25%"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
	<td class='fields' width="75%">
	<select name="group_by" id="group_by" onChange="loadHeaderDtl(this);">
	<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<option value="O" selected><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></option>
	<option value="S"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
	</select>
	</td>
	</tr>
	</table>
 <input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="tabVal" id="tabVal" value="">
<input type="hidden" name="function_id" id="function_id" value="Speciality_For_Orderable">
	
 <%
 putObjectInBean(bean_id,bean,request);
 }
		 
	catch(Exception e){
	e.printStackTrace();
	System.err.print("exception in SpecialityForOrderableAddModifyHeader.jsp="+e);
	}
 %>

</form>
</body>
</html>


