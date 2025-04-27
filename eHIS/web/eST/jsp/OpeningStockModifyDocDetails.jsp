<!DOCTYPE html>
 <%@ page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 


<html>
	<head>
		<title><fmt:message key="eST.ModifyDocumentDetails.label" bundle="${st_labels}"/></title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 	
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script language="JavaScript" src="../../eST/js/OpeningStock.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	StHeaderBean bean = (StHeaderBean) getBeanObject( "stHeaderBean", "eST.StHeaderBean",request );
	request.setCharacterEncoding("UTF-8");
	

	String locale			= (String)session.getAttribute("LOCALE");
	
	bean.setLanguageId(locale);
%>
</head>
<body>
<form>
	<table border='0' cellpadding='0' cellspacing='0' width='506' align=center>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><select name=doc_type><%=bean.getDoc_type_code_List()%></select></td>
		<td class=label >documentno<fmt:message key="Common.documentno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  class='fields'><input type=text name=doc_no size=8 maxlength=8></td>
		<td class=label ><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><input type=text name=doc_no size=8 maxlength=8></td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><input type=text name=doc_ref size=10 maxlength=15></td>
		<td class='fields'><select name=store_code><option value=''>----------<fmt:message key="Common.Store.label" bundle="${common_labels}"/>---------</option></select></td>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	<tr>
		<td class='fields'><select name=store_code><option value=''>----------<fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>---------</option></select></td>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
		<td class='fields'><input type=button name=Record value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class=button><input type=button name=Reset value=Reset class=button><input type=button name=Close value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'class=button onclick='close_modal();'></td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	</table>
</form>
<%
putObjectInBean( "stHeaderBean",bean,request);
%>
</body>

</html>


