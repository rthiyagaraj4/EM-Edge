<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				42063			        Suresh R						27/02/2014           Suresh R       AMS-CRF-0054(Added Item Based IssueReturn)

27/10/2014				HSA-CRF-0171			Sakti Sankar		48543											In Issue Return,Remove the validation 
																													of Issue Doc.Type.Users just need to 
																													find the Issue Doc No. Once user select item 
																													to be returned in the list, system should 
																													auto default the value of Issue Doc. Type
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*,eST.IssueReturnBean,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
			request.setCharacterEncoding("UTF-8");
			String locale				=		 (String)session.getAttribute("LOCALE");
		
			String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
        <script language="JavaScript" src="../../eST/js/IssueReturn.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<body>
<form name="formIssueReturnHeader" id="formIssueReturnHeader">
<%
try {	
		String mode						=		 request.getParameter("mode");
		String	item_class_desc			=		(request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
		String	item_class_code			=		(request.getParameter( "item_class_code" )!=null ? (request.getParameter("item_class_code").trim()):"" );

		if(item_class_desc==null)
		{
			item_class_desc				=		"";
		}
		String trn_type					=		"RET";
		String bean_id					=		"issueReturnBean";
		String bean_name				=		"eST.IssueReturnBean";
		String sql_from_store			=		"SQL_ST_ISSUE_RET_FROM_STORE";
		String sql_to_store				=		"SQL_ST_ISSUE_RET_TO_STORE";
		String Modal_Window_Open		=		"Yes";
		String preview_disabled			=		 "disabled" ;
		eST.IssueReturnBean bean		=		(eST.IssueReturnBean) getBeanObject( bean_id , bean_name,request );
		bean.setLanguageId(locale);
		bean.setItem_class_code(item_class_code);
		String iss_ret_based_on=bean.getIssueRetBasedOn(); //Added by suresh.r on 23-01-2014 against AMS-CRF-0054
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			Modal_Window_Open			=		"No";
			preview_disabled			=		"";
		}
String ret_delete_yn="";
		//Added for GHL-CRF-0413 starts
		Connection con				= null;
		con						= ConnectionManager.getConnection(request);
		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
		bean.setSite_spec_yn(site_main);
		//Added for GHL-CRF-0413 ends

%>
		<jsp:include page="../../eST/jsp/StDuoHeader.jsp" > 
		<jsp:param		name="mode"					value="<%=mode%>" />
		<jsp:param		name="doc_type_code"		value="<%=bean.checkForNull(bean.getDoc_type_code())%>" />
		<jsp:param		name="doc_no"				value="<%=bean.checkForNull(bean.getDoc_no())%>" />
		<jsp:param		name="doc_date"				value="<%=bean.checkForNull(bean.getDoc_date())%>" />
		<jsp:param		name="doc_ref"				value="<%=bean.checkForNull(bean.getDoc_ref())%>" />
		<jsp:param		name="from_store_code"		value="<%=bean.checkForNull(bean.getFrom_store_code())%>" />
		<jsp:param		name="to_store_code"		value="<%=bean.checkForNull(bean.getTo_store_code())%>" />
		<jsp:param		name="item_class_code"		value="<%=bean.checkForNull(bean.getItem_class_code())%>" />
		<jsp:param		name="trn_type"				value="<%=trn_type%>" />
		<jsp:param		name="sql_from_store"		value="<%=sql_from_store%>" />
		<jsp:param		name="sql_to_store"			value="<%=sql_to_store%>" />
		<jsp:param		name="Modal_Window_Open"	value="<%=Modal_Window_Open%>" />
		</jsp:include>
       <%--param name="item_class_code" value="item_class_code" --%> 


<%


ret_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  ret_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(bean.getFrom_store_code()),(String) session.getValue( "login_user" )}).get("RET_DELETE_YN"),"N");
%>
	<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name%>">
		<input type="hidden" name="item_class_desc1" id="item_class_desc1"		value="<%=item_class_desc%>">
		<input type="hidden" name="item_class_code1" id="item_class_code1"		value="<%=item_class_code%>">
		<input type="hidden" name="mode" id="mode"					value="<%=mode%>" >
		<input type="hidden" name="records_to_delete" id="records_to_delete"		value="" >
		<input type="hidden" name="finalize_allowed_yn" id="finalize_allowed_yn"	value="N">
		<input type="hidden" name="finalized_yn" id="finalized_yn"			value="N">
		<input type="hidden" name="ret_delete_yn" id="ret_delete_yn"			value="<%=ret_delete_yn%>">
		<input type="hidden" name="trn_type" id="trn_type"				value="<%=trn_type%>"> 
        <input type="hidden"  name="locale" id="locale"				value="<%=locale%>">
        <input type="hidden"  name="iss_ret_based_on" id="iss_ret_based_on"		value="<%=iss_ret_based_on%>"> <!-- Added by suresh.r on 23-01-2014 against AMS-CRF-0054 -->   		
<!--Added against GHL-CRF-0413 starts-->
        <input type="hidden"    name="site" id="site"	 value="<%=site_main%>">
        <input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
	<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" >
	<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value="">
	<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" >
<!--Added against GHL-CRF-0413 ends-->
		<table border='0' cellpadding=0 cellspacing=0  width='100%' align=center>
		<tr>
		<%if (!mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
%>
			<td class="label" align="left" id="docno_ret_based">Issue Doc.Type &nbsp;&nbsp;&nbsp;
				<select name="issue_doc_type" id="issue_doc_type" onchange="LoadDocNo(this);" onkeydown="return isNumberKey(event);"><%=bean.getIssueDocType()%>
			    </select>
			&nbsp;&nbsp;&nbsp;Issue Doc.No&nbsp;&nbsp;&nbsp;
			<!-- Inc# 48543	Comented by Sakti against HSA-CRF-0171 to remove disabled to issue_doc_no_search button Inc# 48543
			<input type=text name="issue_doc_no" id="issue_doc_no" size=8 maxlength=8 readonly><input type=button name="issue_doc_no_search" id="issue_doc_no_search" class="button" onClick="IssueDocSearch(issue_doc_type);"  value='?'disabled><%=bean.getImage("M")%>  -->
			<input type=text name="issue_doc_no" id="issue_doc_no" size=8 maxlength=8 readonly onkeydown="return isNumberKey(event);"><input type=button name="issue_doc_no_search" id="issue_doc_no_search" class="button" onClick="IssueDocSearch(issue_doc_type);"  value='?' onkeydown="return isNumberKey(event);"><%=bean.getImage("M")%>

			</TD>
<%}else{%>
			<td class="label" id="docno_ret_based">Issue Doc.Type &nbsp;&nbsp;&nbsp;
				<select name="issue_doc_type" id="issue_doc_type" disabled><%=bean.getIssueDocTypeList()%>
			    </select>
			&nbsp;&nbsp;&nbsp;Issue Doc.No&nbsp;&nbsp;&nbsp;
				<input type=text name="issue_doc_no" id="issue_doc_no" size=8 maxlength=8 readonly value="<%=bean.getIssueDocNo()%>" onkeydown="return isNumberKey(event);"><input type=button name="issue_doc_no_search" id="issue_doc_no_search" class="button" value='?' disabled><%=bean.getImage("M")%>
			</TD>
<%}%>

			<td class='fields'><input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class=button style='width:53' style='height:14pt'  onclick="previewDetails();" <%=preview_disabled%> onkeydown="return isNumberKey(event);"></td>
		</tr>
		<tr>
			<td class="label" colspan=3>&nbsp;</td>
		</tr>
		</table>
</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>
<!-- Added by suresh.r on 23-01-2014 against AMS-CRF-0054 beg-->
<script type="text/javascript">
<%if(iss_ret_based_on.equals("D")){ %>
	document.getElementById("docno_ret_based").style.visibility="visible";
<%}else{ %>
	document.getElementById("docno_ret_based").style.visibility="hidden";
<%} %>
callBarCodeApplicable('RET','formIssueReturnHeader','issueReturnBean','eST.IssueReturnBean');//Added against GHL-CRF-0413 
</script>
<!-- Added by suresh.r on 23-01-2014 against AMS-CRF-054 end-->
<%
//Added for GHL-CRF-0413 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413 ends
%>
<%
}
catch (Exception ex) {
	ex.printStackTrace();
}
%>

