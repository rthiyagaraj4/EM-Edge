<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %> 
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOR/js/AssignPrivilegeGroup.js'></script>
<script language=javascript   src='../../eCommon/js/CommonLookup.js'></script>

<STYLE TYPE="text/css">

	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 

	</STYLE>

</head>
<%
String label_desc ="", sql_query="" ,sql_query1="",sql_query2="";
String group_by = request.getParameter("group_by")==null?"":request.getParameter("group_by");
String grp_by_code = request.getParameter("grp_by_code")==null?"":request.getParameter("grp_by_code");
String grp_by_desc = request.getParameter("grp_by_desc")==null?"":request.getParameter("grp_by_desc");
String mode = request.getParameter("mode");
String user = request.getParameter("user")==null?"ALL":request.getParameter("user");
//String allUser = request.getParameter("allUser")==null?"":request.getParameter("allUser");
String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
String bean_id = "Or_Assignprevilege_Group" ;
String bean_name = "eOR.AssignPrevilegeGroup";
String  sql_or_order_entry_speciality			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIALITY");
 AssignPrevilegeGroup bean = (AssignPrevilegeGroup)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	bean.clearDBRec();
if(group_by == null || group_by.equals(""))group_by="";

if(group_by.equals("PG"))
{
	label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PrivilegeGroup.label","or_labels");
	//sql_query =OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_GROUP_SELECT") ;
	sql_query =  "Select PRIV_GRP_ID code, PRIV_GRP_DESC description from or_priv_group where EFF_STATUS = 'E' and upper( PRIV_GRP_ID) like upper(?) and  upper( PRIV_GRP_DESC) like upper(?)";
}else if(group_by.equals("RS"))
{
	label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels");
	sql_query = OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_RESP_SELECT") ;
	sql_query1 = "Select PRIV_GRP_ID code, PRIV_GRP_DESC description from or_priv_group where EFF_STATUS = 'E' and upper( PRIV_GRP_ID) like upper(?) and  upper( PRIV_GRP_DESC) like upper(?)";
	//sql_query1 =OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_GROUP_SELECT") ;
}else if(group_by.equals("PR"))
{
	label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	sql_query = OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_PRACTIONER_SELECT") ; 
	//sql_query2 = OrRepositoryExt.getOrKeyValue("SQL_OR_ASSIGN_PRIVILEGE_GROUP_SELECT") ;
	sql_query2 =  "Select PRIV_GRP_ID code, PRIV_GRP_DESC description from or_priv_group where EFF_STATUS = 'E' and upper( PRIV_GRP_ID) like upper(?) and  upper( PRIV_GRP_DESC) like upper(?)";
	%>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
		<td class='label' width='24%'><%=label_desc%></td>
		<td class='fields'><input type='hidden' name='grp_by_code' id='grp_by_code' value="<%=grp_by_code%>" >
		&nbsp;&nbsp;<input type='text' name='grp_by_desc' id='grp_by_desc' value="<%=grp_by_desc%>"   onblur='callGetGroup(this)'><input type='button' name='grp_by_desc_search' id='grp_by_desc_search' value='?' class='button' <%if(group_by.equals("PR") || group_by.equals("RS") ){%> onClick='getGroup();populatePrevgroup(); <%}else{%> onClick='getGroup(); <%}%>' ><img src="../../eCommon/images/mandatory.gif"></img></td>
	<!-- Modified by kishore kumar N on 18-Aug-09 for CRF 641  -->
	</tr> 
	</table>
<%	
}else{
	label_desc = "";
}
//boolean isSpecificUser = false;
//if(bean.isSpecificUserPExists(grp_by_code, "P"))
//{
	//isSpecificUser = true;
//}

/*if(allUser.equals("N"))
{
	user = "P";
}
else if(allUser.equals("Y"))
{
	user = "ALL";
}
*/

///if(bean.getPrivilegeList() != null)
//{
	//bean.getPrivilegeList().clear();
//}


%>
<body onLoad="" class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='AssignPrivilegeGroupDtl' id='AssignPrivilegeGroupDtl'>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
		<td class='label' width='24%'><%=label_desc%></td>
		<td class='fields'><input type='hidden' name='grp_by_code' id='grp_by_code' value="<%=grp_by_code%>" >
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='grp_by_desc' id='grp_by_desc' value="<%=grp_by_desc%>"   onblur='callGetGroup(this)'><input type='button' name='grp_by_desc_search' id='grp_by_desc_search' value='?' class='button' <%if(group_by.equals("PR") || group_by.equals("RS") ){%> onClick='getGroup();populatePrevgroup(); <%}else{%> onClick='getGroup(); <%}%>' ><img src="../../eCommon/images/mandatory.gif"></img></td>
	<!-- Modified by kishore kumar N on 18-Aug-09 for CRF 641  -->
	</tr> 
	<%
		 if(group_by.equals("RS")){%>
	   <tr>
		<td  class="label"  ><fmt:message key="eOR.PrivilegeGroup.label" bundle="${or_labels}"/></td> 
		<td  class='fields'><input type='hidden' name='grp_by_code1' id='grp_by_code1' value="" >
		<input type='text' name='grp_by_desc1' id='grp_by_desc1' value=""  ><input type='button' name='grp_by_desc_search1' id='grp_by_desc_search1' value='?' class='button' onClick='getGroup1();'><img src="../../eCommon/images/mandatory.gif">
       </td>
		<td colspan=2></td>
		</tr>
	<%}if(group_by.equals("PG")&&(!called_from.equalsIgnoreCase("Hdr"))){ //&& !user.equals("ALL") && !user.equals("RALL")){%>
	<tr><td height='25' valign='bottom'  colspan='4' align='left'>
			<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
				<tr>
					<td id="SelectTab" class="clicked" width="15%" height="20"><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
					<td id="AssociateTab" class="normal" width="15%" height="20"><a href='javascript:dispLink("A")'><fmt:message key="eOR.Associate.label" bundle="${or_labels}"/></a></td>
				</tr>
			</table>
		</td>
	</tr>	
	<%
	if(group_by.equals("PG")&&(!called_from.equalsIgnoreCase("Hdr"))) //&& !user.equals("ALL") && !user.equals("RALL"))
	{
	%>
		<tr id="SpecialityTab" name="SpecialityTab" style="display:" "">
			<td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class="fields" >
				<input type="text" name="speciality" id="speciality" maxlength='30' size='25' value="" onBlur='callSpecialityDesc(this)'><input type="button" class="button" name="sp_search" id="sp_search" value="?" onClick='callSpeciality(speciality)'><input type="hidden" name="speciality_code" id="speciality_code" value=''>
			</td>
			<td class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<SELECT name="search_criteria" id="search_criteria">
					<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
					<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
				</SELECT>
				<input type="text" name="practitioner" id="practitioner" maxlength="40"><INPUT TYPE="button" class="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="callPractitionerValues(practitioner,speciality_code,search_criteria)">
			</td>			
		</tr>
	<%
	}
	%>
	<tr>
	<td colspan='4' id='linkId' name='linkId' >
	<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
	</td></tr> <%}%>
</table>
<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
<input type="hidden"  name="dtl_grp_by_code" id="dtl_grp_by_code" value="P">
<input type="hidden" name="user" id="user" value="<%=user%>">
<input type="hidden" name="from" id="from" value="">
<input type="hidden" name="to" id="to" value="">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
<input type="hidden" name="label_desc" id="label_desc" value="<%=label_desc%>">
<input type="hidden" name="sql_query" id="sql_query" value="<%=sql_query%>">
<input type="hidden" name="sql_query1" id="sql_query1" value="<%=sql_query1%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="sql_query2" id="sql_query2" value="<%=sql_query2%>">
<input type="hidden" name="tabVal" id="tabVal" value="">
<input type="hidden" name="insertrec" id="insertrec" value=""> 
<input type="hidden" name="applevel" id="applevel" value="">
<input type="hidden" name="sql_or_order_entry_speciality" id="sql_or_order_entry_speciality" value="<%=sql_or_order_entry_speciality%>">

</form>
<%
	//if(isSpecificUser && user.equals("P") )			 
	//{%>
		<SCRIPT LANGUAGE="JavaScript">
		<!--
			//dispLink("A");
			if("<%=called_from%>"!="Hdr")
			{
				if(document.forms[0])
				{
					var formObjAddMod=	document.forms[0];
					formObjAddMod.grp_by_desc.disabled=true;
					formObjAddMod.grp_by_desc_search.disabled=true;
				}
			}
		//-->
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%//}
%>
</body>
</html>

