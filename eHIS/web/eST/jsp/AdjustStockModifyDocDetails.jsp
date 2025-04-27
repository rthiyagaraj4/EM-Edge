<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eST.ModifyDocumentDetails.label" bundle="${st_labels}"/></title>
		<meta name="Author" content="Geetha CR">
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 

		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->		<!-- <script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/AdjustStock.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
			StHeaderBean bean = (StHeaderBean) getBeanObject( "stHeaderBean","eST.StHeaderBean",request);
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
		<td class=label ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><select name=doc_type><%=bean.getDoc_type_code_List()%></select></td>
		<td class=label ><fmt:message key="Common.Document.label" bundle="${common_labels}"/> #&nbsp;&nbsp;</td>
		<td class='fields'><input type=text name=doc_no size=8 maxlength=8></td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	<tr>
		<td  class=label><fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><!-- Modified for IN:074037  -->
		<td class='fields'><select name=store_code><option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option></select></td>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><input type=text name=doc_date size=10 maxlength=10></td>
		<td class=label ><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class='fields'><input type=text name=doc_ref size=10 maxlength=15></td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
		<td class='fields'><input type=button name=Record value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  class=button><input type=button name=Reset value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'  class=button><input type=button name=Close value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class=button onclick='close_modal()'></td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	</table>
</form>
<%
//putObjectInBean("stHeaderBean",bean,request);
%>
</body>

</html>


