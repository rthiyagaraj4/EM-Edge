<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001  
---------------------------------------------------------------------------------------------------------------
*/ %>  
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*,webbeans.eCommon.*,java.sql.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String locale		=		(String)session.getAttribute("LOCALE");
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/InstrUsageDiscrepancyUnits.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>

<%

	String mode;
	String bean_id;
	String bean_name;
	String doc_type_code;
	String doc_no;
	String default_store_code			=	"";
	String disabled						=	"";
	String groupName					=	"";
	String store_code					=	"";
	String group_code					=	"";
	String default_doc_type_code		=	"";
	java.util.HashMap defaultParameter  =	null;
	String tray_no						=	request.getParameter("tray_no");
	mode								=	request.getParameter( "mode" ) ;
	group_code							=	request.getParameter("group_code");	
	doc_type_code						=	(request.getParameter( "doc_type_code" ) !=null ? (request.getParameter("doc_type_code").trim()):"" );
	doc_no								=	(request.getParameter( "doc_no" ) !=null ? (request.getParameter("doc_no").trim()):"" );
	
	

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	
	bean_id								=	"instrUsageDiscrepancyUnitsDetailBean" ;
	bean_name							=	"eSS.InstrUsageDiscrepancyUnitsDetailBean";

	InstrUsageDiscrepancyUnitsDetailBean bean =		(InstrUsageDiscrepancyUnitsDetailBean) getBeanObject( bean_id,  bean_name,request );
	bean.clear();
	bean.setFunctionId(request.getParameter("function_id"));
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setMode(mode) ;
	bean.setSession(session) ;
	bean.setLanguageId(locale);
	groupName							=	bean.getGroup_desc();
	tray_no								=	bean.getTray_no();
	group_code							=	bean.getGroup_code();
	if (tray_no == null) {tray_no = "";}
	if(groupName==null){groupName="";}
	if(group_code==null){group_code="";}
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn =false;
	try{
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); 
		if(linen_applicable_yn){
			bean.setLinenApplicableYN("Y");  
		}else{
			bean.setLinenApplicableYN("N");  
		}
	}
	catch(Exception e){
		e.printStackTrace();
		System.out.println("Exception in InstrUsageDiscrepancyUnitsHeader.jsp..");  
	} 
	finally{
		if(con != null)
    		ConnectionManager.returnConnection(con,request);
	}//end 
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			defaultParameter			=	 bean.getSSParameter();
			bean.setMode(mode.trim());
			bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
			bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;

			default_doc_type_code		=	(String)defaultParameter.get("DEF_PRE_DOC_TYPE_CODE");
			default_store_code			=	(String)defaultParameter.get("DEF_STORE_CODE_FOR_PRE");
			doc_type_code				=	default_doc_type_code;
			bean.setDefaultDocType(default_doc_type_code);
			bean.setDefaultStoreCode(default_store_code);
			bean.setStore_code(store_code);
			if(store_code==null){store_code="";}

		
		}
		
	
%>
	<body onload="FocusFirstElement();" onMouseDown="CodeArrest();">
		<form name="formInstrUsageDiscrepancyUnitsHeader" id="formInstrUsageDiscrepancyUnitsHeader" onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>

					<td>&nbsp;&nbsp;
					<select name="store_code" id="store_code" onBlur="validateStore(this);" >
						<%=bean.getStores(store_code)%>
					</select><%=bean.getMandatoryImageTag()%></td>

					<td  class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;
					<select name="group_type" id="group_type">
						<%=bean.getGroupTypes()%>
					</select></td>

					<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td >&nbsp;&nbsp;<input type='text' name="group_desc" id="group_desc" value="<%=groupName%>" maxLength='15' size='15' >
					
					<input type='button' class='BUTTON' value='?' onBlur="validateGroup(group_code,group_desc);" onClick="return searchGroupCode(group_code, group_desc);"  name="group_search" id="group_search" >
					
					<%=bean.getMandatoryImageTag()%><a style = "CURSOR:DEFAULT" href='javascript:details();'  disabled id='details'><fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp&nbsp</a></td>
					<td  class="label"><fmt:message key="eSS.TrayNo.label" bundle="${common_labels}"/></td>

					<td>&nbsp;&nbsp;
					<input type='text' name="tray_no" id="tray_no"  value="<%=tray_no%>" name="tray_no" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onKeyPress="return isValidInteger();"  onBlur="checkTrayNo(this);" onBlur="searchTrayDetail();"  class="NUMBER" <%=disabled%> >
					<input type='button' class='BUTTON' value='?' onClick="searchTrayNo();"  name="tray_search" id="tray_search" <%=disabled%>><%=bean.getMandatoryImageTag()%></td>

				</tr>			
			</table>


			<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%= bean.getFunctionId() %>">
			<input type='hidden' name="store_desc" id="store_desc"				value="">
			<input type="hidden" name="group_code" id="group_code"				value="<%=group_code%>">
			<input type="hidden" name="groupDesValue" id="groupDesValue"			value="<%=bean.getGroup_desc()%>">
			<input type='hidden' name="default_store" id="default_store"			value="<%=(String)defaultParameter.get("DEF_STORE_CODE_FOR_PRE")%>">
			<input type='hidden' name="tray_code" id="tray_code"				value="">
			<input type="hidden" name="store_code1" id="store_code1"				value="<%=default_store_code%>">
			<input type="hidden" name="SQL_SS_INSTR_USAGE_GROUP_LOOKUP" id="SQL_SS_INSTR_USAGE_GROUP_LOOKUP"		value="<%=bean.getSsRepositoryValue("SQL_SS_INSTR_USAGE_GROUP_LOOKUP")%>"> 
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="params" id="params"					value="<%=request.getQueryString()%>"><!--added for KDAH-SCF-0329-->

			
		</form>
	<%
	putObjectInBean(bean_id,bean,request);
	%>

	</body>
</html>

