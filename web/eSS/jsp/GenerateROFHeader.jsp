<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.GenerateROFBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>   

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/GenerateROF.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String mode			=		request.getParameter("mode");
				
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;

		mode				=		mode.trim();			
		String bean_id		=		"generateROFBean";
		String bean_name	=		"eSS.GenerateROFBean";
		String function_id	=		request.getParameter("function_id");
		String doc_no		=		null;
		String doc_type_code =		null;
		String disabled		=		"";


		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			disabled		=		"disabled";
		}
		
		GenerateROFBean bean =		(GenerateROFBean)getBeanObject( bean_id,  bean_name, request);  
		bean.clear();
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(function_id));
		bean.setMode(mode);
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			doc_type_code		= request.getParameter("doc_type_code");
			doc_no				= request.getParameter("doc_no");

		}
		
		String group_type_mandatory_yn = bean.getGroupTypeParameterYn();
	%>
	<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
		<form name="formGenerateROFHeader" id="formGenerateROFHeader" action="../../eSS/jsp/GenerateROFSelectTrayResult.jsp" method="post" target="frameGenerateROFFrameList" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' >
			<tr>
				<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"  <%=disabled%>><%=bean.getDocTypes()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>

				<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" maxLength="10" size="10" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>"  onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
				<td class="label"><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="group_type" id="group_type">
					<%=bean.getGroupType()%>   
				</select>&nbsp;<%if(group_type_mandatory_yn.equalsIgnoreCase("Y")) { %> <img src="../../eCommon/images/mandatory.gif" align=center></img><%}%></td> 
			</tr>
			<tr>
				<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="store_code" id="store_code"><%=bean.getStoreCodes()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td> 
				<td  class="label"><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="service_location" id="service_location"><%=bean.getServiceLocations()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td> 
				<td class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<input type="text" name="doc_ref" id="doc_ref" maxLength="15" size="15" value="<%=CommonBean.checkForNull(bean.getDoc_ref(),"")%>">&nbsp;</td>  
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eSS.Discrepancy.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="discrepancy_code" id="discrepancy_code"><option value='%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option><option value='2'><fmt:message key="eSS.WithDiscrepancy.label" bundle="${ss_labels}"/></option><option value='1'><fmt:message key="eSS.WithoutDiscrepancy.label" bundle="${ss_labels}"/></option></select></td>
				<td  class="label"><fmt:message key="eSS.PrintSterilizationRequest.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;<input type="checkbox" name="entry_completed_yn" id="entry_completed_yn" value="Y"></td> 
				<td>&nbsp;</td>
				<td>&nbsp;</td>				
			</tr>
			
			<tr>
				<td align="left" class="label"><fmt:message key="eSS.Sterilization.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.Required.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;<input type="checkbox" name="sterile_yn" id="sterile_yn" value="Y" checked ></td> 
				<td align="left" class="label"><fmt:message key="eSS.Washing.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.Required.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;<input type="checkbox" name="washing_yn" id="washing_yn" value="Y" checked></td>
				<td align="left" class="label"><fmt:message key="eSS.Packing.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.Required.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;<input type="checkbox" name="packing_yn" id="packing_yn" value="Y" checked></td>
			</tr>
			 
			
			<tr>
				<td colspan='4'>&nbsp;</td>
				<td colspan='2' ><input type="button" value="Select Trays" class="BUTTON" onClick="showSelectTray();"></td>
			</tr>
			</table>
			<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%=bean_name%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"		value="-1">
			<input type="hidden" name="function_id" id="function_id"					value="<%=function_id%>">
			<input type='hidden' name="finalize_yn" id="finalize_yn"					value="No">
			<input type='hidden' name="autono_yn" id="autono_yn"					value="No">
			<input type='hidden' name="selectedTrayDetails" id="selectedTrayDetails"			value="-1">
			<input type='hidden' name="trn_type" id="trn_type"					value="ROF">
			<input type='hidden' name="group_type_mandatory_yn" id="group_type_mandatory_yn"		value="<%=group_type_mandatory_yn%>">
			

		</form>
	</body>
</html>

<%
	putObjectInBean("generateROFBean", bean,request);
%>

