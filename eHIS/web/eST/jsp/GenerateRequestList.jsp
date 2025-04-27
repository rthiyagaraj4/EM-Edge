<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ page import ="eST.GenerateRequestBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
<%
		String sStyle			  =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eST/js/GenerateRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String bean_id				=			 "generateRequestBean";
		String bean_name			=			"eST.GenerateRequestBean";
%>
<body onload='FocusFirstElement();'>
<form name="GenerateRequestListFrame" id="GenerateRequestListFrame" onReset="FocusFirstElement();">
	<table border="0" cellspacing="0" width="100%">
	  <tr>
		<td >&nbsp;</td>
		<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td  >&nbsp;</td>
		<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td >&nbsp;</td>
	  </tr>
	  <tr>
		<td class=label ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
		<td class=fields>&nbsp;&nbsp;<input type="text" maxLength=20 size=20 name="item_from_code" id="item_from_code" value= "" ><input type=hidden name="item_from_desc" id="item_from_desc" value=""><input type='button' class='BUTTON' value='?' onClick='callItemSearchScreen(item_from_code,item_from_desc);' name="item_search_1" id="item_search_1"></td>
		<td class=label ></td>
		<td class=fields>&nbsp;&nbsp;<input type="text" maxLength=20 size=20 name="item_to_code" id="item_to_code" value= "" ><input type=hidden name="item_to_desc" id="item_to_desc" value=""><input type='button' class='BUTTON' value='?' onClick='callItemSearchScreen(item_to_code,item_to_desc);' name="item_search_2" id="item_search_2"></td>
		<td >&nbsp;</td>
	  </tr>
	  <tr>
		<td class=label ><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
		<td class=fields>&nbsp;&nbsp;<input type="text" maxLength=10 size=10 name="alpha_from_code" id="alpha_from_code" value= "" >&nbsp;</td>
		<td class=label ></td>
		<td class=fields>&nbsp;&nbsp;<input type="text" maxLength=10 size=10 name="alpha_to_code" id="alpha_to_code" value= "" >&nbsp;</td>
		<td >&nbsp;</td>
	  </tr>
	  <tr>
		<td class=label ><fmt:message key="Common.ItemClassCode.label" bundle="${common_labels}"/></td>
		<td class=fields>&nbsp;&nbsp;<input type="text" maxLength=4 size=4 name="item_class_from_code" id="item_class_from_code" value= "" ><input type=hidden name="item_class_from_desc" id="item_class_from_desc" value=""><input type='button' class='BUTTON' value='?' onClick='searchItemClassCode(item_class_from_code,item_class_from_desc);' name="item_class_search_1" id="item_class_search_1"></td>
		<td class=label ></td>
		<td class=fields>&nbsp;&nbsp;<input type="text" maxLength=4 size=4 name="item_class_to_code" id="item_class_to_code" value= "" ><input type=hidden name="item_class_to_desc" id="item_class_to_desc" value=""><input type='button' class='BUTTON' value='?' onClick='searchItemClassCode(item_class_to_code,item_class_to_desc);' name="item_class_search_2" id="item_class_search_2"></td>
		<td class=fields>&nbsp;<input type="button" class="button" name="search" id="search" value="  Search  " onClick="getItemRecord();"></td>
	  </tr>
		 <input type='hidden' name="request_by_store" id="request_by_store" value="">
		<input type='hidden' name="effective_date" id="effective_date" value="">
	</table>
	<input type="hidden"	 name="bean_id" id="bean_id"		value="<%=bean_id%>">
	<input type="hidden"	 name="bean_name" id="bean_name"	value="<%= bean_name %>">
	</form>
	</body>
</html>

