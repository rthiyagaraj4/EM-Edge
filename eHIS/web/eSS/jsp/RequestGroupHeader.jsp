<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*,java.sql.*,webbeans.eCommon.*,eOT.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="we" class="eSS.RequestGroupBean"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title> 
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String locale					=		(String)session.getAttribute("LOCALE");
		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/RequestGroup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	String mode="";
	String bean_id="";
	String bean_name="";
	String doc_type_code="";
	String doc_no="";
	String codeDisabled					=		"";
	String disabled						=		"";
	String docNoDisabled				=		"";
	String entryDisabled				=		"";
	String entry_checked				=		"";
	mode								=		request.getParameter( "mode" ) ;
	bean_id								=		"RequestGroupBean" ;
	bean_name							=		"eSS.RequestGroupBean";
	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	RequestGroupBean bean				=		(RequestGroupBean) getBeanObject( bean_id, bean_name,  request );
	
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
	bean.clear() ;
	}
	
	bean.setLanguageId(locale);
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setLoginById((String)session.getAttribute("login_user")) ;
	bean.setFunctionId(request.getParameter("function_id"));
	bean.setMode(mode) ;
	bean.setSession(session) ;
	bean.initSsParameter();
	bean.initDoc_type_code();
	bean.initDoc_date();
	bean.setAdded_by_id(bean.getLoginById());


	// Added Starts For OT CRF 35660	Bru-HIMS-CRF-268.1 by Ganga 

		String module_id = (String)request.getParameter("module_id")==null?"SS":(String)request.getParameter("module_id");

	// Added Ended For OT CRF 35660	Bru-HIMS-CRF-268.1
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			 entry_checked			=		"checked";
		}

	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled					=		"disabled";
		disabled						=		"disabled";
		doc_type_code					=		request.getParameter("doc_type_code");
		doc_no							=		request.getParameter("doc_no");
			if (( doc_type_code== null )||( doc_no== null )) {
			return;		
		}
		bean.setDoc_no(doc_no) ;
		bean.setDoc_type_code(doc_type_code) ;
		bean.loadData() ;
		if(bean.getEntry_completed_yn().equals("Y")) entryDisabled="disabled";
	}else if(module_id.equals("OT")){// Added Starts For OT CRF 35660	Bru-HIMS-CRF-268.1 by Ganga 
		
		doc_type_code					= (String)request.getParameter("doc_type_code")==null?"":(String)request.getParameter("doc_type_code");
		doc_no							= (String)request.getParameter("doc_no")==null?"":(String)request.getParameter("doc_no");;

		String OTbeanid					= (String)request.getParameter("beanid")==null?"":(String)request.getParameter("beanid");;
		String OTbeanName				= (String)request.getParameter("beanName")==null?"":(String)request.getParameter("beanName");;
		String req_by_store_code		= (String)request.getParameter("req_by_store_code")==null?"":(String)request.getParameter("req_by_store_code");;
		String req_on_store_code		= (String)request.getParameter("req_on_store_code")==null?"":(String)request.getParameter("req_on_store_code");;
		String entry_completed_yn		= (String)request.getParameter("entry_completed_yn")==null?"":(String)request.getParameter("entry_completed_yn");;
		String request_type				= (String)request.getParameter("request_type")==null?"":(String)request.getParameter("request_type");;
		
		bean.setDoc_type_code(doc_type_code) ;
  		bean.setReq_by_store_code(req_by_store_code);      
		bean.setReq_on_store_code(req_on_store_code);      
		bean.setEntry_completed_yn(entry_completed_yn);      
		bean.setRequest_type(request_type);    
		
		codeDisabled					=		"disabled";
		disabled						=		"disabled";

		

	}// Added Ended For OT CRF 35660	Bru-HIMS-CRF-268.1

	if (bean.getDoc_type_code() != null && bean.getDoc_type_code().trim().length()>0 && mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){
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
			String surg_nature_link_to_OT_yn = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_SURG_NATURE_LINK_OT_YN_SELECT"),bean.getLoginFacilityId())).get("SURG_NATURE_LINK_OT_YN"));
%>
	<body onload="FocusFirstElement();"onMouseDown="CodeArrest();" >
		<form name="formRequestGroupHeader" id="formRequestGroupHeader"onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" <%=codeDisabled%> onChange="checkDoc_type_code()" onkeydown="return isNumberKey(event);">
						<%=bean.getDoc_type_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" class="NUMBER" <%=docNoDisabled%> value="<%=bean.getDoc_no().trim()%>"   name="doc_no" maxLength="8" size="8" onKeyPress="return isValidInteger();"    onBlur="checkIntegerFormat(this);"><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" name="doc_date"  maxLength="10" size="10" <%=disabled%> onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');" <%=disabled%>></img><%=bean.getMandatoryImageTag()%></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="req_by_store_code" id="req_by_store_code" onkeydown="return isNumberKey(event);" <%=disabled%>><%=bean.getReq_by_store_code_List()%></select><%=bean.getMandatoryImageTag()%></td>
					<td class="label"><fmt:message key="eSS.RequestedOn.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="req_on_store_code" id="req_on_store_code" onkeydown="return isNumberKey(event);" <%=disabled%>><%=bean.getReq_on_store_code_List()%></select><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getDoc_ref()%>" name="doc_ref"  maxLength="15" size="15"  <%=disabled%>></td>
				</tr>			
				<tr>
					<td class="label"><fmt:message key="eSS.EntryCompleted.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="checkbox" value="Y"  name="entry_completed_yn" id="entry_completed_yn" onkeydown="return isNumberKey(event);" <%=entryDisabled%> <%=entry_checked%> <%=bean.getChecked(bean.getEntry_completed_yn())%>></td>
					<td class="label"><fmt:message key="eSS.EnteredBy.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="hidden" value="<%=bean.getAdded_by_id()%>" name="added_by_id" maxLength="10" size="10" disabled>
					<input type="text" value="<%=strEnterdByName%>" name="added_by_name" maxLength="10" size="10" disabled>
					</td>
					<td class="label"><fmt:message key="eSS.RequestType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="request_type" id="request_type" onkeydown="return isNumberKey(event);" <%=disabled%>><%=bean.getRequest_type_List()%>
					</select></td>
				<tr>
				<tr>
								
				<td class="label"></td>
				<td class="label"></td>
				<td class="label"></td>
				<td class="label"></td>
				<td class="label"><fmt:message key="eSS.RequestGroup.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<input type=button onkeydown="return isNumberKey(event);" name=grouphsearch value='Group Search' class=button onclick="callGroupSearch();" >&nbsp;</td>
				
							
				</tr>			
			</table>
			<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
			<input type="hidden" name="authorized" id="authorized"				value="N">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%= bean.getFunctionId() %>">
			<input type="hidden" name="module_id" id="module_id"				value="<%= module_id %>">
			<input type="hidden" name="trn_type" id="trn_type"				value="REQ">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST")%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_SURGERY_TYPE_FOR_REQUEST" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_SURGERY_TYPE_FOR_REQUEST" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_SURGERY_TYPE_FOR_REQUEST")%>">
			
			
<%
	try{
		/* Commented by Ganga  since we have authorize in function level ML-BRU-SCF-0813 [IN:039420]
			ArrayList alParameters = new ArrayList();
			//alParameters.add(request.getParameter("module_id"));
			alParameters.add("SS");
			alParameters.add(request.getParameter("function_id"));
			alParameters.add(session.getAttribute("responsibility_id"));
			ArrayList alRequestGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SM_MENU_TRANS_SUB_FUNCTION_SELECT"),alParameters);
			for (int i=0;i<alRequestGroupRecords.size();i++){
				HashMap hmRequestGroupSubFunc=(HashMap)alRequestGroupRecords.get(i);
							hidden filed is removed SS_REQUEST_GROUP_AUTHORIZE
			}
			*/
		}
		catch (Exception exception) {
			out.println(exception);
			exception.printStackTrace();
		}finally{
			rset.close();
			stmt.close();
			ConnectionManager.returnConnection(con,request);
		}
putObjectInBean(bean_id,bean,request);

%>
		</form>
	</body>

</html>
  

