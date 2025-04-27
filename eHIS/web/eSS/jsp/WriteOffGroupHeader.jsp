<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*, eSS.Common.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
	request.setCharacterEncoding("UTF-8");
	String locale	 =		(String)session.getAttribute("LOCALE");
	String sStyle	 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/WriteOffGroup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	String mode;
	String bean_id;
	String bean_name;
	String doc_type_code;
	String doc_no;

	
	String codeDisabled			=		"";
	String disabled				=		"";
    String disabledStore		=		"";
	String docNoDisabled		=		"";
	
	mode						=		request.getParameter( "mode" ) ;
	bean_id						=		"WriteOffGroupBean" ;
	bean_name					=		"eSS.WriteOffGroupBean";


	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	WriteOffGroupBean bean		 =		(WriteOffGroupBean) getBeanObject( bean_id,  bean_name, request);

	bean.clear() ;
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setLoginById((String)session.getAttribute("login_user")) ;
	bean.setFunctionId(request.getParameter("function_id"));
	bean.setMode(mode) ;
	bean.setLanguageId(locale);
	bean.setSession(session) ;
	bean.initSsParameter();
	bean.initDoc_type_code();
	bean.initDoc_date();
	bean.initStore_code();
	bean.setAdded_by_id(bean.getLoginById());

	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled		=	"disabled";
		disabledStore		=	"disabled";
		doc_type_code		=	request.getParameter("doc_type_code");
		doc_no				=	request.getParameter("doc_no");
		if (( doc_type_code== null )||( doc_no== null )) {
			return;		
		}
		bean.setDoc_no(doc_no) ;
		bean.setDoc_type_code(doc_type_code) ;
		bean.loadData() ;
		if(bean.getEntry_completed_yn().equals("Y")) disabled="disabled";
	}
	//Modified by Martin on Thursday, April 17, 2003 1:58:32 PM
	if (bean.getDoc_type_code() != null && bean.getDoc_type_code().trim().length()>0){
		docNoDisabled=bean.isDocNoAutoGenYN(bean.getDoc_type_code())?"disabled":docNoDisabled;
	}
	else {
		docNoDisabled = "disabled";
	}

	//To get Entered By User Name from User ID
			String strEnterdByName="";
			String strEnterdById=bean.getAdded_by_id();
			String strLocale=(String) session.getValue( "LOCALE" ) ;
			Connection con=ConnectionManager.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rset=null;
			rset = stmt.executeQuery("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = '"+strLocale+"' and APPL_USER_ID='"+strEnterdById+"'") ;
			
			if(rset !=null)	{
				if(rset.next()) {
					strEnterdByName = rset.getString("APPL_USER_NAME");
				}
			}
%>
	<body onload="FocusFirstElement();"onMouseDown="CodeArrest()">
		<form name="formWriteOffGroupHeader" id="formWriteOffGroupHeader" onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" <%=codeDisabled%> onChange="checkDoc_type_code()">
						<%=bean.getDoc_type_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" class="NUMBER" value="<%=bean.getDoc_no()%>" name="doc_no" maxLength="8" size="8" onKeyPress="return isValidInteger();" <%=codeDisabled%> <%=docNoDisabled%>><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" name="doc_date" id="doc_date" maxLength="10" size="10" <%=disabled%> onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img><%=bean.getMandatoryImageTag()%></td>
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="store_code" id="store_code" <%=disabledStore%>><%=bean.getStore_code_List()%></select><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getDoc_ref()%>" name="doc_ref"  maxLength="15" size="15"  <%=disabled%>></td>
					<td class="label"><fmt:message key="eSS.EntryCompleted.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="checkbox" value="Y" name="entry_completed_yn" id="entry_completed_yn" <%=disabled%> <%=bean.getChecked(bean.getEntry_completed_yn())%>></td>
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="eSS.EnteredBy.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="hidden" value="<%=bean.getAdded_by_id()%>" name="added_by_id" maxLength="10" size="10" disabled>
					<input type="text" value="<%=strEnterdByName%>" name="added_by_name" maxLength="10" size="10" disabled>
					</td>
					<td colspan=4>&nbsp;</td>
				<tr>			
			</table>
			<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
			<input type="hidden" name="finalized" id="finalized"				value="N">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%= bean.getFunctionId() %>">
			<input type="hidden" name="locale" id="locale"					value="<%= locale %>">
<%
	try{
		/* Commented by Sakti  since we have finalize in function level AAKH_SCF_158
			ArrayList alParameters = new ArrayList();
			alParameters.add(request.getParameter("module_id"));
			alParameters.add(request.getParameter("function_id"));
			alParameters.add(session.getAttribute("responsibility_id"));
			ArrayList alRequestGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SM_MENU_TRANS_SUB_FUNCTION_SELECT"),alParameters);

			for (int i=0;i<alRequestGroupRecords.size();i++){
				HashMap hmRequestGroupSubFunc=(HashMap)alRequestGroupRecords.get(i);
					hidden filed is removed SS_WRITE_OFF_GROUP_FINALIZE from here
			}
			*/
		}
		catch (Exception exception) {
			out.println(exception);
			exception.printStackTrace();
		}
		finally{
				rset.close();
				stmt.close();
				ConnectionManager.returnConnection(con,request);
		}
%>
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>

	</body>

</html>

