<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/UserForReportingOrderable.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


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
 <body  STYLE="" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
 
<%
	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
	String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	//String Alphabets ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String AlphabetsHtml =  "";
	//String readOnly = "" ;
	//String disabled = "" ;

	String ord_category_text = request.getParameter("ord_category_text");
	String ord_category_value = request.getParameter("ord_category_value");
	String ord_type_value = request.getParameter("ord_type_value");
	String ord_type_text = request.getParameter("ord_type_text");

	if (ord_category_text == null || ord_category_text.equals("null")  ) ord_category_text=""; else ord_category_text = ord_category_text.trim();
	if (ord_category_value == null || ord_category_value.equals("null")  ) ord_category_value=""; else ord_category_value = ord_category_value.trim();
	if (ord_type_value == null || ord_type_value.equals("null")  ) ord_type_value=""; else ord_type_value = ord_type_value.trim();
	if (ord_type_text == null || ord_type_text.equals("null")  ) ord_type_text=""; else ord_type_text = ord_type_text.trim();

%>

<form name="detailUpperForm" id="detailUpperForm" method="post" >

<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" align="left">
<%try {%>

<tr>
	<td colspan='2' align='left'>
	<table align='left' cellspacing='o' id="innerCellTab" cellpadding='0' width="30%" border='1' style="">
		<tr>
			<td align="center" id="SelectTab" class="clicked" width="15%" height="20" onClick='display("S")'><a href="#"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
			<td align="center" id="AssociateTab" class="normal" width="15%" height="20" onClick='display("A")'><a href="#"><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
		</tr>
	</table>
	</td>
</tr>



<tr>
	<td colspan="2" class="COLUMNHEADER">
	<table align='left' cellspacing='0' id="alphabet" cellpadding='0' width='100%' border='0' style="">
	<tr>
		<td id='linkId'><jsp:include page="OrCommonAlphaLink.jsp" flush="true"/></td>
	</tr>
	</table>
	</td>
</tr>


</table>


<!-- <input type="hidden" name="mode" id="mode" value="<%=mode%>"> -->
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="alphabetsHtml" id="alphabetsHtml" value='<%=AlphabetsHtml%>'>
<input type="hidden" name="ord_category_value" id="ord_category_value" value='<%=ord_category_value%>'>
<input type="hidden" name="ord_type_value" id="ord_type_value" value='<%=ord_type_value%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type='hidden' value='1' name='mode' id='mode'>
<input type="hidden" name="tabVal" id="tabVal" value="">
<input type='hidden' value='N' name='detailPageMode' id='detailPageMode'>
<input type="hidden" name="function_id" id="function_id" value="">


<%}catch(Exception e){
	System.out.println("here" + e.getMessage());

}%>
</form>

</body>
</html>

