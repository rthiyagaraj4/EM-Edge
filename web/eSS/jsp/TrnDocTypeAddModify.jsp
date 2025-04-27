<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History     Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
05/03/2015	IN051898		Badmavathi B									SS Document Type
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType=
"text/html;charset=UTF-8" import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			 =		(String)session.getAttribute("LOCALE");
	String sStyle			 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/TrnDocType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled			=	"";
	String doc_type_code		=	"";
	 String print_alert_reqd_yn="";
	 String print_alert_reqd_yn_disabled = "";

	mode						=	request.getParameter( "mode" ) ;
	bean_id						=	"trnDocTypeBean" ;
	bean_name					=	"eSS.TrnDocTypeBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
	 return ;
	TrnDocTypeBean bean			=	(TrnDocTypeBean)getBeanObject( bean_id, bean_name,request) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;

	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled			=		"disabled";
		doc_type_code			=		request.getParameter( "doc_type_code" ) ;
		if (doc_type_code == null ) {
			return;		
		}
		bean.setDoc_type_code(doc_type_code,0) ;
		bean.loadData();
	}
	if (!(bean.getTrn_type(0).equals("REQ")||bean.getTrn_type(0).equals("RTG"))) {
		print_alert_reqd_yn_disabled="disabled";
	}
	print_alert_reqd_yn=bean.getPrint_alert_reqd_yn(0);
	String print_app;
	if((bean.getTrn_type(0).equals("REQ"))||(bean.getTrn_type(0).equals("RTG")))
	print_app="visible";
	else
	print_app="hidden";
	bean.setLanguageId(locale);
	
%>
<body onLoad="FocusFirstElement();" onMouseDown='CodeArrest();'>
	<form name="formTrnDocType" id="formTrnDocType" onReset="FocusFirstElement();">
	<table border=0 align='center' width='100%' height='100%'>
		<tr><td align='center' class='WHITE'>
		<table width='60%' cellpadding=5 cellspacing=0>
			<tr><td colspan='2'>&nbsp;</td></tr>
			<tr>	
					<td align='right' class='label'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td><select name="doc_type_code_0" id="doc_type_code_0" <%=codeDisabled%>>
							<%=bean.getDoc_type_code_List()%>
						</select><%=bean.getMandatoryImageTag()%>
					</td>
			</tr>

			<tr>	
					<td align='right' class='label'><fmt:message key="eSS.TRNType.label" bundle="${ss_labels}"/></td>
					<td><select name="trn_type_0" id="trn_type_0" <%=codeDisabled%>>
							<%=bean.getTrn_type_List()%>
						</select><%=bean.getMandatoryImageTag()%>
					</td>
			</tr>
			<tr style="visibility: <%=print_app%>;">	
					<td align='right' class='label'><fmt:message key="eSS.PrintAlertRequired.label" bundle="${ss_labels}"/></td>
					<%if(print_alert_reqd_yn.equals("Y")	){	%>
					<td>&nbsp;<input type='checkbox' name="print_alert_reqd_yn_0" id="print_alert_reqd_yn_0" value='<%=print_alert_reqd_yn%>' <%=print_alert_reqd_yn_disabled %>
					checked onclick="printreqd(this);"  <%=bean.getChecked(bean.getPrint_alert_reqd_yn(0))%>></td>
					<%}
					else
						{%>
                    <td>&nbsp;<input type='checkbox' name="print_alert_reqd_yn_0" id="print_alert_reqd_yn_0" value='<%=print_alert_reqd_yn%>' <%=print_alert_reqd_yn_disabled %>  onclick="printreqd(this);"   ></td>
						<%}%>
			</tr>
			<tr><td colspan='2'>&nbsp;</td></tr>
			
		</table>
		</td></tr>
	</table>
	<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
    <input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

