<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale					=		(String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/RequestGroup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
	function submitForm()
{
	document.getElementById("formRequestGroupQueryCriteria").action ="../../eSS/jsp/RequestGroupQueryResult.jsp";
	document.getElementById("formRequestGroupQueryCriteria").target="frameRequestGroupQueryResult";
	document.getElementById("formRequestGroupQueryCriteria").submit();
}
</script>
	</head>
	<body onLoad='FocusFirstElement();formRequestGroupQueryCriteria.submit()'onMouseDown="CodeArrest();" >
	<%
		String mode					=		request.getParameter( "mode" ) ;
		RequestGroupBean bean		=		(RequestGroupBean)getBeanObject( "requestGroupBean","eSS.RequestGroupBean" , request);  
	
		bean.clear();
		bean.setMode(mode) ;
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setLoginById((String)session.getAttribute("login_user")) ;
		bean.setMode(mode) ;
		bean.initSsParameter();
		bean.initDoc_type_code();
		bean.setLanguageId(locale);

	%>
		<form name="formRequestGroupQueryCriteria" id="formRequestGroupQueryCriteria" action="../../eSS/jsp/RequestGroupQueryResult.jsp" method="post" target="frameRequestGroupQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code">
							<%=bean.getDoc_type_code_List()%></select>
							</td>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_no" id="doc_no" value="" size='8' maxLength='8' class="NUMBER" onKeyPress="return isValidInteger();"></td>
					<td class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_date" id="doc_date" value="" size='10' maxLength='10' onBlur='CheckDate(this);'  >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="req_by_store_code" id="req_by_store_code" >
							<%=bean.getReq_by_store_code_List()%></select>
							</td>
					<td  class="label"><fmt:message key="eSS.RequestedOn.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="req_on_store_code" id="req_on_store_code" >
							<%=bean.getReq_on_store_code_List()%></select>
							</td>
					<td class="label"><fmt:message key="eSS.RequestType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="request_type" id="request_type" >
						<option value="N" ><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
						<option value="U" ><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						<option value="E" ><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.Entry.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="entry_completed_yn" id="entry_completed_yn" >
						<option value='%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>		
						<option value='Y' selected><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>		
						<option value='N'><fmt:message key="eSS.Notcompleted.label" bundle="${ss_labels}"/></option>		
						</select>
					</td>
 					<td  colspan=3 class="label">&nbsp;</td>
					<td class="label" align='right'>&nbsp;<input type='button' class='Button' value='Search' name='search' id='search' onclick='submitForm()'>&nbsp;&nbsp;</td>
				</tr>
			</table>
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="doc_type_code,doc_no">
<%
putObjectInBean("requestGroupBean",bean,request);
%>
	</form>
	</body>
</html>

