<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*"%>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale		=	(String)session.getAttribute("LOCALE");

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
 	<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
	<script language="javascript" src="../../eSS/js/PostVariance.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

	String mode			=		request.getParameter("mode");

	if ((mode == null) || (mode.equals(""))) 
		return;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	mode								 =		mode.trim();
	java.util.HashMap defaultParameter   =		null;
	String bean_id						 =		"postVarianceBean";
	String bean_name					 =		"eSS.PostVarianceBean";

	PostVarianceBean bean				 =		(PostVarianceBean) getBeanObject( bean_id, bean_name,request );  
	bean.clear();
	
	bean.setMode(mode.trim());
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String disabled							=		"";
	boolean editMode						=		false;	
	defaultParameter						=		bean.getSSParameter();
	String default_doc_type_code			=		(String)defaultParameter.get("DEF_VAR_DOC_TYPE_CODE");
	String default_write_off_reason_code	=		(String)defaultParameter.get("DEF_WRITE_OFF_REASON_CODE");

	bean.setDefaultDocType(default_doc_type_code);
	bean.setDefaultWriteOffReasonCode(default_write_off_reason_code);
%>
<body onload='FocusFirstElement();' onMouseDown="CodeArrest()">
	<form name="formPostVariance" id="formPostVariance" onReset='FocusFirstElement();'>
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellspacing=0 cellpadding=1 width="55%" align="center" border=0>
				  <tr>
					<td width="40%">&nbsp;</td>
					<td>&nbsp;</td>
				 </tr>
				  <tr>
					<td class=label align=right><fmt:message key="eSS.PhyInvID.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<select name="phy_inv_id" id="phy_inv_id" onblur=""> <%=bean.getPhyInvIDs()%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
				  </tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				  </tr>
				  <tr>
					<td class=label align=right><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;<select name="doc_type_code" id="doc_type_code" onBlur="validateDocNo(this);" <%=editMode?disabled:""%>><%=bean.getDocTypes()%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
				  </tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				  </tr>
				  <tr>
					  <!-- On Selection of Doc Type, Check needs to be made  for Document No Enable/Disable -->
					<td class=label align=right><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<input CLASS="NUMBER" maxLength=8 size=8 name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" disabled value="<%=bean.getDoc_no()%>" onBlur="return checkIntegerFormat(this);">&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center ></td>
					</tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				  </tr>
				  <tr>
					<td class=label align=right><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<!-- onBlur="CheckDate(this);" -->
					<td class=label>&nbsp;<input type="text" maxLength=10 size=10 name="doc_date" id="doc_date" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" onBlur="CheckDate(this);">&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
				 </tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				 </tr>
				  <tr>
					<td class=label align=right><fmt:message key="eSS.WriteoffReason.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<select name="write_off_reason_code" id="write_off_reason_code"><%=bean.getDiscrepancyReasons()%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
				  </tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				  </tr>
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="facility_id" id="facility_id"			value="<%=bean.getLoginFacilityId() %>">
			<input type='hidden' name="autono_yn" id="autono_yn"			value="No">
			<input type='hidden' name="trn_type" id="trn_type"			value="VAR">
			<input type='hidden' name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="locale" id="locale"				value="<%=locale%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

