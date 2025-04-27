<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script>
 -->	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="javaScript" src="../../eST/js/ProductTransfer.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>

<%
	//java.util.HashMap defaultParameter = null;
	//String bean_id = "ProductTransferBean";
	//String bean_name = "eST.ProductTransferBean";
	
	ProductTransferBean bean = (ProductTransferBean) getBeanObject( "ProductTransferBean", "eST.ProductTransferBean" ,request );
	bean.setLanguageId(locale);
	
	//String facility_id = (String) session.getValue("facility_id");
	//String user_name  =  (String) session.getValue( "login_user" ) ;
	//String store_code= request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;

%>

<body onload='FocusFirstElement();' >
<form name="ProductTransferRequestSearchCriteria_Form" id="ProductTransferRequestSearchCriteria_Form" >
<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
	<form name="formProductTransferRequestSearch" id="formProductTransferRequestSearch" onSubmit= 'return submitPage();' >
		<table border=0 cellspacing=0 cellpadding=0 width='100%' align="center">
		<th   colspan=10><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
		
		<tr>
			<td  class=label><fmt:message key="eST.ReqStore.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
			<td class='fields'><b> <select name='r_store_code' id='r_store_code' disabled><%=bean.getStoreCode()%></select>&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
			<td  class=label >&nbsp;&nbsp;</td>
			<td  class="label"><fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/></td>
			<td class='fields'>&nbsp;&nbsp;<input type='text' name="r_request_no" id="r_request_no" value="" size='9' maxLength='8'  class="NUMBER" onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);"></td>
			<td class='fields'><input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='RequestsearchVals();'><input type=button class=button name="Close" id="Close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="returnVals();"></td>
   	    </tr>

		</table>
		<input type="hidden" name="flag1" id="flag1" value="1">
		<script>
			RequestsearchVals();
		</script>
     </form>
	  <%
putObjectInBean("ProductTransferBean",bean,request);
%>
	  </body>
	
	
</table>

