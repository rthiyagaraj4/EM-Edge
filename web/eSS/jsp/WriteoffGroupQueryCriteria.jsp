<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*"  contentType="text/html;charset=UTF-8" %>  
<html>
	<head>
<%
		String locale		=	(String)session.getAttribute("LOCALE");
		request.setCharacterEncoding("UTF-8");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eSS/js/WriteOffGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onLoad='FocusFirstElement();formWriteOffGroupQueryCriteria.submit();'onMouseDown="CodeArrest()">
	<%
		String mode			=	request.getParameter( "mode" ) ;
		String bean_id		=	"WriteOffGroupBean" ;
		String bean_name	=	"eSS.WriteOffGroupBean";

		WriteOffGroupBean bean = (WriteOffGroupBean) getBeanObject( bean_id, bean_name,request);  
		bean.clear();
		bean.setMode(mode) ;
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setLoginById((String)session.getAttribute("login_user")) ;
		bean.setMode(mode) ;
		bean.initSsParameter();
		bean.initDoc_type_code();
		bean.initStore_code();
		bean.setLanguageId(locale);

	%>
		<form name="formWriteOffGroupQueryCriteria" id="formWriteOffGroupQueryCriteria" action="../../eSS/jsp/WriteOffGroupQueryResult.jsp" method="post" target="frameWriteOffGroupQueryResult" onreset="FocusFirstElement();" >
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code">
							<%=bean.getDoc_type_code_List()%></select>
							</td>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_no" id="doc_no" value="" size='8' maxLength='8' class="NUMBER" onKeyPress="return isValidInteger();"></td>
					<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_date" id="doc_date" value="" size='10' maxLength='10' onBlur="CheckDate(this,'<%=locale%>');">&nbsp<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="store_code" id="store_code" >
							<%=bean.getStore_code_List()%></select>
							</td>
					<td  class="label"><fmt:message key="eSS.Entry.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="entry_completed_yn" id="entry_completed_yn" >
						<option value='%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>		
						<option value='Y' selected><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>		
						<option value='N'><fmt:message key="eSS.Notcompleted.label" bundle="${ss_labels}"/></option>		
						</select>
					</td>

 					<td  class="label"> </td>
					<td class="label">&nbsp;<input type='button' class='Button' value='Search' name='search' id='search' onClick='searchResult();'></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="doc_type_code,doc_no">
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>

