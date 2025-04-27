<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
			request.setCharacterEncoding("UTF-8");
			String locale		=	(String)session.getAttribute("LOCALE");
			String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
	    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../js/SsCommon.js"></script>
		<script language="JavaScript" src="../js/GroupForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest();" >
<jsp:useBean id="bean" scope="page" class="eSS.GroupForStoreBean"/>
<%
	String bean_id								=	"groupforstore" ;
	String bean_name							=	"eSS.GroupForStoreBean";
	String facility_id							=	(String)session.getValue( "facility_id" );
	String sql_ss_group_for_store_group_lookup	=	 "";
	String sql_ss_group_for_store_store_lookup	=	"";
	String from_source							=	request.getParameter( "from_source" );
	// GroupForStoreBean bean						=	(GroupForStoreBean)getBeanObject( bean_id,bean_name, request   ) ;

//	Clear the bean
	bean.clear();
	sql_ss_group_for_store_group_lookup = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_NAME_LOOKUP");
	sql_ss_group_for_store_store_lookup = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_SELECT_LIST");
	//set the login facility id for qry execution
	bean.setLoginFacilId((String)session.getValue( "facility_id" ));
	bean.setLanguageId(locale);


%>
<form name="groupforstore_header" id="groupforstore_header" >
  <table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
	<tr><td colspan="2"></td></tr><tr><td colspan="2"></td></tr><tr><td colspan="2"></td></tr>
<%
if(from_source.equals( "bystore" )){
%>
	<tr>
		<td align="right" class="label" width="30%"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td align="left" width="60%">&nbsp;
			<input type="hidden" name="store_code" id="store_code" value="">
			<input type="text" name="store_desc" id="store_desc" value="" size="15" maxlength="15" ><input type="button" class="button" name="storeCodeSearch" id="storeCodeSearch" value="?" onClick="searchCode(store_desc)" align="left">&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
			
		</td>
	</tr>
	<script>document.groupforstore_header.store_desc.focus();</script>
			
	<%
	}else{
	%>
		<tr>
		<td align="right" class="label" width="30%"><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
		<td align="left" width="60%">&nbsp;
			<input type="hidden" name="group_code" id="group_code" value="" >
			<input type="text" name="group_name" id="group_name" value="" size="15" maxlength="15" ><input type="button" class="button" name="groupCodeSearch" id="groupCodeSearch" value="?" onClick="searchCode(group_name)" align="left">&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
	 </tr>
	 <script>document.groupforstore_header.group_name.focus();</script>
	<%
		}
	%>
	<tr>
		<td colspan="2"></td></tr><tr><td colspan="2"></td></tr><tr><td colspan="2"></td>
	</tr>
  </table>
	  <input type="hidden" value="<%=from_source%>" name="from_source">
	  <input type="hidden" name="sql_ss_group_for_store_group_lookup" id="sql_ss_group_for_store_group_lookup" value="<%=sql_ss_group_for_store_group_lookup%>">
	  <input type="hidden" name="sql_ss_group_for_store_store_lookup" id="sql_ss_group_for_store_store_lookup" value="<%=sql_ss_group_for_store_store_lookup%>">
	  <input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	  <input type="hidden" name="locale" id="locale" value="<%=locale%>">
 </form>
</body>
</html>
<%
	putObjectInBean( bean_id,bean,request);
%>

