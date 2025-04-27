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

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" onload="FocusFirstElement()">

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
	String splty_desc=request.getParameter("splty_desc");
	String splty_code=request.getParameter("splty_code");
	String order_catalog_code=request.getParameter("order_catalog_code");
	String group_by=request.getParameter("group_by");

	if (catalog_desc==null) catalog_desc="";
	if (order_catalog_code==null) order_catalog_code="";
	if (group_by==null) group_by="";
	if (splty_desc==null) splty_desc="";
	if (splty_code==null) splty_code="";
//	out.println("order_catalog_code"+order_catalog_code);
	/* Initialize Function specific end */
%>

	<form name="SpecialityForOrderableDtlHeader" id="SpecialityForOrderableDtlHeader" method="post" >
	
	<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" align="center">
	<%if(group_by.equals("O")){%>
   	<tr>
	<td class='label' width="25%"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<td class='fields' width="75%">
	<input type='hidden'  name='order_catalog_code' id='order_catalog_code' value="<%=order_catalog_code%>">
	<input type='text'  name='catalog_desc' id='catalog_desc' value="<%=catalog_desc%>"  size=40 maxlength=40 onBlur="before_show_order_catalog_window(this,order_catalog_code);"><input type='button' name='search' id='search' class='button'   value='?' onClick='show_order_catalog_window(catalog_desc,order_catalog_code);'>
	<img src="../../eCommon/images/mandatory.gif" align=center><input type="hidden" name="temp_catalog_desc" id="temp_catalog_desc" value=""><label  id="splty_speci_ind" style="visibility:hidden"><font COLOR='#A4AE00;'>[<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.specific.label" bundle="${common_labels}"/>]</font></label><input type="hidden" name="order_catalog_sql" id="order_catalog_sql" 	
	value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_SPLTY_FOR_ORDERABLE_CATALOG")%>">
	
	</td>
	</tr>
	<%
	}else if(group_by.equals("S"))
	{
	%>
		<tr>
	<td class='label' width="25%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class='fields' width="75%">
	<input type='hidden'  name='splty_code' id='splty_code' value="<%=splty_code%>">
	<input type='text'  name='splty_desc' id='splty_desc' value="<%=splty_desc%>"  size=40 maxlength=40 onBlur="before_show_splty_window(this,splty_code);"><input type='button' name='search' id='search' class='button'   value='?' onClick='show_splty_window(splty_desc,splty_code);'><img src="../../eCommon/images/mandatory.gif" align=center><input type="hidden" name="temp_splty_desc" id="temp_splty_desc" value=""><input type="hidden" name="splty_sql" id="splty_sql" 	
	value="<%=OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIALITY")%>">
	
	</td>
	</tr>
<%
	}
	%>


	<tr><td colspan='2' align='left'>
			<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
				<tr>
					<td id="SelectTab" class="clicked" width="15%" height="20"><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
					<td id="AssociateTab" class="normal" width="15%" height="20"><a href='javascript:dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
	<td colspan='2' id='linkId' class="COMMONTOOLBARFUNCTION" >
	<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
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
	System.err.print("exception in SpecialityForOrderableAddModifyDtlHeader.jsp="+e);
	}
 %>

</form>
</body>
</html>


