<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="alWriteOffGroupList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Geetha">
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/WriteOffGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()">
<%
	WriteOffGroupListBean bean = (WriteOffGroupListBean)getBeanObject( "WriteOffGroupListBean",   "eSS.WriteOffGroupListBean", request);  
	bean.clear();
	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));
	String disabled				=	"";
	String codeDisabled			=	"";
	String doc_type_code		=	request.getParameter("doc_type_code");
	String doc_no				=	request.getParameter("doc_no");
	String index				=	bean.checkForNull(request.getParameter("index"),"-1");
	String strButtonLegend		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	
	String mode					=	index.equals("-1")? bean.getCommonRepositoryValue("MODE_INSERT"):bean.getCommonRepositoryValue("MODE_MODIFY");
	if(mode.equals(bean.getCommonRepositoryValue("MODE_MODIFY"))){
		bean.initialize((HashMap)alWriteOffGroupList.get(Integer.parseInt(index)));
		strButtonLegend			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		codeDisabled			=	"disabled";
	}
	if(!((doc_no==null)||(doc_type_code==null))){
		disabled				=	bean.isEntryCompleted(doc_type_code,doc_no)?"disabled":disabled;
	}
	bean.setLanguageId(locale);
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn =false;
	try{
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); 
		if(linen_applicable_yn){
			bean.setLinen_applicable_yn("Y");
		}else{
			bean.setLinen_applicable_yn("N");     
		}
	} 
	catch(Exception e){
		e.printStackTrace();
		System.out.println("Exception in WriteOffGroupDetail.jsp..");    
	} 
	finally{
		if(con != null)
    		ConnectionManager.returnConnection(con,request);
	}//end 
%>
	<body>
		<form name="formWriteOffGroupDetail" id="formWriteOffGroupDetail" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
			<table border="0" cellpadding="3" cellspacing="0" width='100%' align='center'>

			    <tr>
				   <td  class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
				   <td>&nbsp;<select name="group_type" id="group_type"  onChange="clearGroupDetail();" <%=disabled%> <%=codeDisabled%>><%=bean.getGroup_type_List()%>	   </select></td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="description" id="description" value="<%=bean.getDescription()%>" maxLength='15' size='15'  <%=disabled%> <%=codeDisabled%>><input type='button' class='BUTTON' value='?' onClick="searchGroupCode(group_code, description);"  name="group_search" id="group_search" <%=disabled%> <%=codeDisabled%>><%=bean.getMandatoryImageTag()%><input type="hidden" name="group_code" id="group_code" value="<%=bean.getGroup_code()%>"></td>
				</tr>

				<tr>
					<td class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="tray_no" id="tray_no"  value="<%=bean.getTray_no()%>" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onKeyPress="return isValidInteger();"  onBlur="searchTrayDetail();"  class="NUMBER" <%=disabled%> <%=codeDisabled%>><input type='button' class='BUTTON' value='?' onClick="searchTrayNo();"  name="tray_search" id="tray_search" <%=disabled%> <%=codeDisabled%>><%=bean.getMandatoryImageTag()%></td>
				</tr>

				<tr>
				<%
				   Double write_off = new Double ( (CommonBean.checkForNull(bean.getWrite_off_cost() , "0")) );
				%>
					<td  class="label"><fmt:message key="eSS.WriteOffCost.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="write_off_cost" id="write_off_cost" value="<%=write_off%>" class="NUMBER" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" disabled></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.WriteoffReason.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="writeoff_reason" id="writeoff_reason" <%=disabled%>> <%=bean.getWrite_off_reason_code_List()%></select><%=bean.getMandatoryImageTag()%></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<textarea style=" resize:none; " name="remarks"  cols=24 rows=8 onKeyPress="return setTextAreaMaxLength(this,200);" onBlur="checkSetTextAreaMaxLength(this,200);"  <%=disabled%>><%=bean.getRemarks()%></textarea></td>
				</tr>

                <% 
					if(strButtonLegend.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels"))) { %>

                  <tr>
					<td  class="label" colspan='2'>
						<input type='button' class='BUTTON' name="apply" id="apply" onClick="clickAdd();" 
						value="Add"<%=disabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="resetGroupDetail();" value="Cancel" <%=disabled%>>		
					</td>
				  </tr>

                <%	} else { %>

				<tr>
					<td  class="label" colspan='2'>
						<input type='button' class='BUTTON' name="apply" id="apply" onClick="clickModify();" value="Modify" <%=disabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="resetGroupDetail();" value="Cancel" <%=disabled%>>		
					</td>
				</tr>

                <% } %>

				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="index" id="index"								value="<%=index%>">
			<input type='hidden' name="locale" id="locale"								value="<%=locale%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE"	value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE")%>">
			<input type="hidden" name="SS_WRITE_OFF_REASON_LOOKUP" id="SS_WRITE_OFF_REASON_LOOKUP"			value="<%= bean.getSsRepositoryValue("SS_WRITE_OFF_REASON_LOOKUP")%>">

			

		</form>
<%
	putObjectInBean("WriteOffGroupListBean",bean,request);
%>
	</body>
</html>

