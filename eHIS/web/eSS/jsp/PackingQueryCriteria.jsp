<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%try{%>
<html>
	<head>
<%
		
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onLoad='FocusFirstElement();formPackingQueryCriteria.submit();'onMouseDown='CodeArrest();'>
	<%

		String mode				=	request.getParameter( "mode" ) ;
		String bean_id			=	 "packingBean" ;
		String bean_name		=	"eSS.PackingBean";

		PackingBean bean		=	(PackingBean) getBeanObject( bean_id, bean_name,request );  
		bean.clear();


		bean.setMode(mode) ;
		bean.setLanguageId(locale);
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setLoginById((String)session.getAttribute("login_user")) ;
		bean.setMode(mode) ;
		bean.initSsParameter();
		bean.initDoc_type_code();
		bean.initService_location_code();

	%>
		<form name="formPackingQueryCriteria" id="formPackingQueryCriteria" action="../../eSS/jsp/PackingQueryResult.jsp" method="post" target="framePackingQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code">
							<%=bean.getDoc_type_code_List()%></select>
							</td>
					<td align="right" class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_no" id="doc_no" value="" size='8' maxLength='8' class="NUMBER" onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);"></td>
					<td align="right" class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_date" id="doc_date" value="" size='10' maxLength='10' onBlur='CheckDate(this);'  >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="store_code" id="store_code" >
							<%=bean.getStore_code_List()%></select>
							</td>
					<td align="right" class="label"><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="service_location_code" id="service_location_code" >
							<%=bean.getService_location_code_List()%></select>
							</td>
					<td>&nbsp;</td>
					<td>&nbsp;<input type='button' class='BUTTON' value='Search' name='search' id='search' onClick='searchResult();'></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="doc_type_code,doc_no">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
<% 
}
catch (Exception exception) {
// 	out.println(exception);
	exception.printStackTrace();
}
finally {
}%>	</body>
</html>

