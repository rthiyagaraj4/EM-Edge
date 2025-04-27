<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import=" eMM.*,eMM.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alTradeNameForItemList" scope="session" class="java.util.ArrayList" />
<%-- Mandatory declarations end --%>  
<html>
	<head>
		<title> </title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<% 
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
//		String primary_lang		=	(String)session.getAttribute("PRIMARY_LANG");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
		<script language="javascript" src="../../eMM/js/TradeNameForItem.js"></script>
		<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
	<!--<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
	<body onload="FocusFirstElement();">
<%
	/** Used to indicate whether fields other than the key code is disabled or not*/
	String disabled						=			"";

	/** Used to indicate whether the key field is disabled or not. */
	String codeDisabled					=			"";
	String mode							=			"";
	String bean_id						=			"";
	String bean_name					=			"";
//	String item_code					=			request.getParameter( "item_code" ) ==null?"":request.getParameter( "item_code" );
//	String item_desc					=			request.getParameter( "item_desc" ) ==null?"":request.getParameter( "item_desc" );
	mode								=			request.getParameter( "mode" ) ;

	bean_id								=			"TradeNameForItemBean" ;
	bean_name							=			"eMM.TradeNameForItemBean";

	if ( mode == null || mode.equals("") ) {
		return ;
	}

	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) ) {
		return ;
	}
		
	TradeNameForItemBean bean			=			(TradeNameForItemBean)getBeanObject( bean_id,bean_name,request ) ;  
	bean.setLanguageId(locale);
	boolean site_mohe = bean.getSite();//Added for MOHE-CRF-0167 US001
	bean.clear() ;

	ServletContext context				=			getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	

	if ( mode.equals( 	  
	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {   
		codeDisabled					=			"disabled";
		if ( request.getParameter( "item_code" )==null )
		return;		
		bean.setItem_code(request.getParameter( "item_code" ));
		bean.setItem_desc(request.getParameter( "item_desc" ));
	}
	else {
		bean.clear();
	}
%>
		<form name="formTradeNameForItemHeader" id="formTradeNameForItemHeader" onReset="FocusFirstElement();">
			<table border="0" cellpadding="2" cellspacing="0" width='70%' align=center >
				<tr>
					<td colspan="3">
					</td>
				</tr>
				<tr>
					<td colspan="3">
					</td>
				</tr>
				<tr>
					<td colspan="3">
					</td>
				</tr>
				<br>
				<tr class="QRYODD">										
					<td >
						&nbsp;
					</td>
					<td  class="label">
						<fmt:message key="Common.item.label" bundle="${common_labels}"/>
					</td>
					<td class=fields >
						&nbsp;&nbsp;
						<% if(site_mohe){ //Added for MOHE-CRF-0167 US001 starts%>
						<input type='text' name="item_desc" id="item_desc" value="<%=bean.getItem_desc()%>" maxLength='60' size='70' <%=codeDisabled%>><input type='button' class='BUTTON' name="item_search" id="item_search" value='?' onClick="searchItem_MOHE(item_code,item_desc);"  <%=codeDisabled%> <%=disabled%>>
						<%}else{ %>
						<input type='text' name="item_desc" id="item_desc" value="<%=bean.getItem_desc()%>" maxLength='60' size='70' <%=codeDisabled%>><input type='button' class='BUTTON' name="item_search" id="item_search" value='?' onClick="searchItem(item_code,item_desc);"  <%=codeDisabled%> <%=disabled%>>
						 <%} //Added for MOHE-CRF-0167 US001 ends%>
						<img src="../../eCommon/images/mandatory.gif" >
						</img>
						<input type="hidden" name="item_code" id="item_code" value="<%=bean.getItem_code()%>">
					</td>
				</tr>	
				<tr>
					<td colspan="3">
					</td>
				</tr>
				<tr>
					<td colspan="3">
					</td>
				</tr>
				<tr>
					<td colspan="3">
					</td>
				</tr>

				<br><br>
			</table>
			<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%= locale %>">
			<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="SQL_MM_ITEM_LOOKUP" id="SQL_MM_ITEM_LOOKUP"  value="<%= bean.getMmRepositoryValue("SQL_MM_ITEM_LOOKUP")%>">
<%
	putObjectInBean(bean_id,bean,request);
%>
		</form>
	</body>
</html>


