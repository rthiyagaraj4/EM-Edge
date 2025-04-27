<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/AutoclaveWashingUnitTest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	

<%
	String mode;
	String bean_id;
	String bean_name;
	String unit_type			=	request.getParameter( "unit_type" ) ==null?"":request.getParameter( "unit_type" );
	String unit_status			=	request.getParameter( "unit_status" ) ==null?"":request.getParameter( "unit_status" );
	String autoclave_wash_unit_code;
	String test_date;
	if(unit_type==null || unit_type.equals("Autoclave")) unit_type="A";
	if(unit_type=="W" || unit_type.equals("Washing")) unit_type="W";
	
	String codeDisabled			=	"";
	String disabled				=	"";
	
	mode						=	request.getParameter( "mode" ) ;
	bean_id						=	"autoclaveWashingUnitTestBean" ;
	bean_name					=	"eSS.AutoclaveWashingUnitTestBean";
	
	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	AutoclaveWashingUnitTestBean bean	= (AutoclaveWashingUnitTestBean) getBeanObject( bean_id,  bean_name, request );
	bean.clear() ;
	bean.setLanguageId(locale);
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setLoginById((String)session.getAttribute("login_user")) ;
	bean.setFunctionId(request.getParameter("function_id"));
	bean.setMode(mode) ;
	bean.setSession(session) ;
	bean.initSsParameter();
	bean.initTest_date();
	bean.setUnit_type(unit_type);
	bean.setAdded_by_id(bean.getLoginById());
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		
		codeDisabled				=	"disabled";
		autoclave_wash_unit_code	=	request.getParameter("autoclave_wash_unit_code");
		autoclave_wash_unit_code	=	autoclave_wash_unit_code.trim();
		
		test_date					=	request.getParameter("test_date");
		test_date					=	test_date.trim();

		if ( autoclave_wash_unit_code== null ) {
			return;		
		}
	
		
		
	    bean.setUnit_type(unit_type) ;
		bean.setAutoclave_wash_unit_code(autoclave_wash_unit_code.trim());
		bean.setTest_date(test_date.trim());
		bean.setUnit_type(unit_type.trim());
		bean.setUnit_Status(unit_status.trim());
		
		bean.loadData() ;
		if(bean.getEntry_completed_yn().equals("Y")) disabled="disabled";
		
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
<script language="JavaScript" >
var varmode="<%=mode%>";
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onload="FocusFirstElement();populate_codeonCreate(varmode)" onMouseDown="CodeArrest()">
		<form name="formAutoclaveWashingUnitTestHeader" id="formAutoclaveWashingUnitTestHeader"onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="eSS.UnitType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="unit_type" id="unit_type" <%=codeDisabled%>  onChange="populate_code(this); clearList();"><%=bean.getUnit_type_List()%></select><%=bean.getMandatoryImageTag()%></td>
					<td class="label"><fmt:message key="eSS.AutoclaveWashUnit.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="autoclave_wash_unit_code" id="autoclave_wash_unit_code" <%=codeDisabled%> ><%=bean.getAutoclave_wash_unit_code_List(unit_type)%></select><%=bean.getMandatoryImageTag()%></td>
					<td colspan=2>&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.TestDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getTest_date(),"DMY","en",locale)%>" name="test_date"  id="test_date" maxLength="10" size="10" <%=disabled%> <%=codeDisabled%> onBlur="CheckDate(this,null);">&nbsp;
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('test_date');"></img>
					<%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.EnteredBy.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="hidden" value="<%=bean.getAdded_by_id()%>" name="added_by_id" maxLength="10" size="10" disabled>
					<input type="text" value="<%=strEnterdByName%>" name="added_by_name" maxLength="10" size="10" disabled>
					</td>
					<td  class="label"><fmt:message key="eSS.EntryCompleted.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="checkbox" value="Y" name="entry_completed_yn" id="entry_completed_yn" <%=disabled%> <%=bean.getChecked(bean.getEntry_completed_yn())%>></td>
				</tr>			
			</table>
			<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
			<input type="hidden" name="finalized" id="finalized"				value="N">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%= bean.getFunctionId() %>">
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
					hidden filed is removed SS_AUTCL_WU_TEST_FINALIZE from here
			}
			*/
		}
		catch (Exception exception) {
			out.println(exception);
			exception.printStackTrace();
		}
%>
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>

</html>

