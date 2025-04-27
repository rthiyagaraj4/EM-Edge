<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alRequestGroupList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/RequestGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body>
<%
	try{
	RequestGroupListBean bean		=		(RequestGroupListBean)getBeanObject( "requestGroupListBean", "eSS.RequestGroupListBean", request ) ;
	bean.setLanguageId(locale) ;
	bean.clear();
	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));

	String surgery_type				=		"";
	String surgery_name				=		"";
	String surg_name_disabled		=		"";
	String disabled					=		"";
	String codeDisabled				=		"";
	String doc_type_code			=		request.getParameter("doc_type_code");
	String doc_no					=		request.getParameter("doc_no");
	String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	String strButtonLegend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels"); 

	String mode	=index.equals("-1")? bean.getCommonRepositoryValue("MODE_INSERT"):bean.getCommonRepositoryValue("MODE_MODIFY");

	if(mode.equals(bean.getCommonRepositoryValue("MODE_MODIFY"))){
		bean.initialize((HashMap)alRequestGroupList.get(Integer.parseInt(index)));
		strButtonLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels"); 
		codeDisabled				=		"disabled";
	}

	//Added against KDAH_CRF_0247
	 	String surg_nature_link_to_OT_yn = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_SURG_NATURE_LINK_OT_YN_SELECT"),bean.getLoginFacilityId())).get("SURG_NATURE_LINK_OT_YN"));
		if(surg_nature_link_to_OT_yn.equals("Y")){
			surgery_name = bean.checkForNull(bean.getOTSurg_Description());
			surgery_name = java.net.URLEncoder.encode(surgery_name,"UTF-8");
		}
		surgery_type = bean.checkForNull(bean.getSurg_Description());
		surgery_type = java.net.URLEncoder.encode(surgery_type,"UTF-8");
		
		//Added ends
		//Added By Rabbani against KDAH-CRF-0247(Inc no : 35861) on 26-AUG-13
		String  display_flag					= "visibility:visible";
		if(surg_nature_link_to_OT_yn.equals("N")){
		display_flag					= "visibility:hidden";
		}
		//ends
%>
	<body onMouseDown="CodeArrest();" >
		<form name="formRequestGroupDetail" id="formRequestGroupDetail" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
			<table border="0" cellpadding="3" cellspacing="0" width='100%' align='center'>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<!-- Added By Sakti against KDAH-CRF-0247 -->
				<tr>
					<td class="label"><fmt:message key="eSS.SurgeryType/Name.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="surg_description" id="surg_description" value="" maxLength='15' size='15'  <%=codeDisabled%> onkeydown="return isNumberKey(event);" onBlur="if(document.formRequestGroupDetail.surg_description.value != '' && document.formRequestGroupDetail.surgery_type.value == ''){callSurgeryTypeSearchWindow(surgery_type, surg_description,surg_code,ot_surg_description);}"><input type='button' class='BUTTON' value='?' onClick="callSurgeryTypeSearchWindow(surgery_type, surg_description,surg_code,ot_surg_description);"  name="surgery_type_search" id="surgery_type_search"  <%=codeDisabled%> onkeydown="return isNumberKey(event);"><input type="hidden" name="surgery_type" id="surgery_type" value="">&nbsp;<input type='text' name="ot_surg_description" id="ot_surg_description" style =  "<%=display_flag%>" value="" maxLength='15' size='15'  readonly onkeydown="return isNumberKey(event);"><input type="hidden" name="surg_code" id="surg_code" value=""><input type="hidden" name="temp_surgery_type" id="temp_surgery_type" value="<%= surgery_type %>"><input type="hidden" name="temp_surgery_name" id="temp_surgery_name" value="<%= surgery_name %>">
					</td>
							
				</tr>
				<!-- Added ends -->
				<tr>
				<td  class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;<select name="group_type" id="group_type"  onChange="clearGroupDetail();" <%=disabled%> <%=codeDisabled%> onkeydown="return isNumberKey(event);">
					<%=bean.getGroup_type_List()%>
				</select></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSS.ReqGroup.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="description" id="description" value="<%=bean.getDescription()%>" maxLength='15' size='15'  <%=disabled%> <%=codeDisabled%> onkeydown="return isNumberKey(event);"><input type='button' class='BUTTON' value='?' onClick="searchGroupCode(req_group_code, description);"  name="group_search" id="group_search" <%=disabled%> <%=codeDisabled%> onkeydown="return isNumberKey(event);"><%=bean.getMandatoryImageTag()%><input type="hidden" name="req_group_code" id="req_group_code" value="<%=bean.getReq_group_code()%>"></td>
				</tr>
				<tr>
				<td  class="label" ><fmt:message key="eSS.AuthGroup.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;<select name="auth_group_code" id="auth_group_code" onkeydown="return isNumberKey(event);">
				<%if(codeDisabled.equals("disabled")){%>
					<%=bean.getAuth_group_code_List()%>
				<%}else{%>
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<%}%>
				</select><%=bean.getMandatoryImageTag()%></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSS.ReqQuantity.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="request_qty" id="request_qty" value="<%=bean.getRequest_qty()%>" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER" <%=disabled%>><%=bean.getMandatoryImageTag()%></td>
				</tr>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" colspan='2'>
						<input type='button' class='BUTTON' name="apply" id="apply" onClick="addToList();" value="<%=strButtonLegend%>" <%=disabled%> onkeydown="return isNumberKey(event);">
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="resetGroupDetail();" value="Cancel" <%=disabled%> onkeydown="return isNumberKey(event);">					
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="index" id="index" value="<%=index%>">
			<input type='hidden' name="mode" id="mode" value="<%=mode%>">
			<input type='hidden' name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST")%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_SURGERY_TYPE_FOR_REQUEST" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_SURGERY_TYPE_FOR_REQUEST" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_SURGERY_TYPE_FOR_REQUEST")%>">
			<input type="hidden" name="surg_nature_link_to_OT_yn" id="surg_nature_link_to_OT_yn" value="<%=surg_nature_link_to_OT_yn%>">
<%		
		putObjectInBean("requestGroupListBean",bean,request);
		}catch(Exception e){
			e.printStackTrace();
		}
%>
		</form>
	</body>
</html>
 <script>
Setsurgdesc(document.formRequestGroupDetail.temp_surgery_type,document.formRequestGroupDetail.temp_surgery_name);
</script>

