<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.ROFEntryBean,java.util.*,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*," contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="weeee"  scope="page" class="eSS.ROFEntryBean"/>

<html>
	<head>
	
<%		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ROFEntry.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String mode				=		request.getParameter("mode");
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		mode					 =		mode.trim();
		String bean_id			 =		"rofEntryBean";
		String bean_name		 =		"eSS.ROFEntryBean";
		String function_id		 =		request.getParameter("function_id");

		String disabled			 =		"";

		
		ROFEntryBean bean		 =		(ROFEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(function_id));
		bean.setMode(mode);
		String docdate			=		bean.getDoc_date();
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			docdate				=		bean.getDocdate();
			disabled			=		"disabled";
		}
		if (!mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			
			bean.clear();
		}

	%>
	<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()">

		<form name="formROFEntryHeader" id="formROFEntryHeader" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' >
			<tr>
				<td class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"  <%=disabled%>><%=bean.getDocTypes()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
				<td class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type="text" name="doc_no" id="doc_no" class="NUMBER" maxLength="8" size="8" onKeyPress="return isValidInteger();" disabled value="<%=bean.getDoc_no()%>">&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
				<td class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" maxLength="10" size="10" value="<%=com.ehis.util.DateUtils.convertDate(docdate,"DMY","en",locale)%>" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="store_code" id="store_code" <%=disabled%>><%=bean.getStoreCodes()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td> 
				<td class="label"><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="service_location_code" id="service_location_code"><%=bean.getServiceLocations()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td> 
				<td class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type="text" name="doc_ref" id="doc_ref" maxLength="15" size="15" value="<%=CommonBean.checkForNull(bean.getDoc_ref(),"")%>">&nbsp;</td>  
			</tr>
			<tr>
				<td class="label"><fmt:message key="eSS.Sterilize.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;<input type="checkbox" name="sterilize_yn" id="sterilize_yn" value="Y" <%=disabled%> <%=bean.getSterilizedChecked()%> onClick="disableStrType();"></td> 
				<td class="label"><fmt:message key="eSS.Wash.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;<input type="checkbox" name="wash_yn" id="wash_yn" value="Y" <%=disabled%> <%=bean.getWashChecked()%> onClick="disableWashType();"></td>
				<td class="label"><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;<input type="checkbox" name="pack_yn" id="pack_yn" value="Y" <%=disabled%> <%=bean.getPackChecked()%>></td>
			</tr>
			</table>
			<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
			<input type="hidden" name="locale" id="locale"		value="<%=locale%>">
			<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission" value="-1">
			<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
			<input type='hidden' name="finalized_yn" id="finalized_yn" value="No">
			<input type='hidden' name="autono_yn" id="autono_yn"	value="No">
			<input type='hidden' name="selectedTrayDetails" id="selectedTrayDetails" value="-1">
			<input type='hidden' name="trn_type" id="trn_type"	value="ROF">
<%
	try{
		/*  Commented by Sakti  since we have finalize in function level AAKH_SCF_158

			ArrayList alParameters = new ArrayList();
			alParameters.add(request.getParameter("module_id"));

			alParameters.add(request.getParameter("function_id"));
			alParameters.add(session.getAttribute("responsibility_id"));
			ArrayList alRequestGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SM_MENU_TRANS_SUB_FUNCTION_SELECT"),alParameters);
			for (int i=0;i<alRequestGroupRecords.size();i++){
				HashMap hmRequestGroupSubFunc=(HashMap)alRequestGroupRecords.get(i);
					hidden filed is removed SS_ROF_ENTRY_FINALIZE from here

			}
			*/
		}
		catch (Exception exception) {
			out.println(exception);
			exception.printStackTrace();
		}
%>
		</form>
	</body>
	<%	putObjectInBean(bean_id,bean,request);%>

</html>

