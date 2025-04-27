<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eST.*, eST.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html> 
<head>

<% 
	request.setCharacterEncoding("UTF-8");
	String locale						=	(String)session.getAttribute("LOCALE");
	String sStyle						=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

	 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
	 <script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	 <script language="JavaScript" src="../../eST/js/ParentStoreForStore.js"></script>
	 <script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>

	
<%
	
	String	mode							=	 (request.getParameter( "mode" ) !=null ? (request.getParameter("mode").trim()):"" );
	String	store_code						=	 (request.getParameter( "store_code" ) !=null ? (request.getParameter("store_code").trim()):"" );
	String	parent_store_code				=	 (request.getParameter( "parent_store_code" ) !=null ? (request.getParameter("parent_store_code").trim()):"" );
	String	parent_store_desc				=	 (request.getParameter( "parent_store_desc" ) !=null ? (request.getParameter("parent_store_desc").trim()):"" );
	String	store_desc						=	 (request.getParameter( "store_desc" ) !=null ? (request.getParameter("store_desc").trim()):"" );
	//String	item_class_code				=	 (request.getParameter( "item_class_code" ) !=null ? (request.getParameter("item_class_code").trim()):"" );
	//String	eff_status					=	 (request.getParameter( "eff_status" ) !=null ? (request.getParameter("eff_status").trim()):"D" );
	String	bean_id							=	  "ParentStoreForStoreBean" ;
	String	bean_name						=	  "eST.ParentStoreForStoreBean";
	String  codeDisabled					=	  "";
	ParentStoreForStoreBean bean			=     (ParentStoreForStoreBean)getBeanObject(bean_id,bean_name ,request);
	bean.setLanguageId(locale);
	bean.setMode(mode);

	

	if ( mode == null || mode.equals("") )
		return ;

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || 
	       mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
		{
			codeDisabled = "disabled";
						
		}
		else
		{
			codeDisabled="";
		}
	
%>
<body onload='FocusFirstElement();'>
<form name="formParentAddModify" id="formParentAddModify" onreset="FocusFirstElement()">
	 <!-- <table border="0" cellpadding="0" cellspacing="0" width='100%'  height='100%' align="center">
	<tr>
	<td width='100%'  class="WHITE">  -->
	<table border="0" cellpadding="1" cellspacing="0" width='100%'  align='center'>
		<tr>
			<td width='20%'>&nbsp;</td>
			<td width='45%'>&nbsp;</td>
			<td width='15%'>&nbsp;</td>
		</tr>

		<tr>
			<td  class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="Common.Store.label" bundle="${common_labels}"/> </td>
			<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>

			<td><input type="text"  name="store_desc" id="store_desc" size='40' maxLength='40'  value="<%=store_desc%>"   <%=codeDisabled%> >
			<input class='Button' type="button" name="searchStore" id="searchStore" onClick="return searchStoreDetails(store_code,store_desc);" value="?"  <%=codeDisabled%> >
			<input type="hidden" name="store_code" id="store_code" value = "<%=store_code%>" >
			<%}
		 else {%>
			<td><input type="text"  name="store_desc" id="store_desc" size='40' maxLength='40'  value=""   >
			<input class='Button' type="button" name="searchStore" id="searchStore" onClick="return searchStoreDetails(store_code,store_desc);" value="?"  >
			<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			<input type="hidden" name="store_code" id="store_code" value = "<%=store_code%>" >
			<%}%>
		</td>
		<td >&nbsp;</td>
		</tr>
		
<!--		<tr>
			<td  class="label"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="eST.ParentStore.label" bundle="${st_labels}"/></td>
				<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
			<td><input type="text"   name="parent_store_desc" id="parent_store_desc" size='40'' maxLength='40'  value="<%=parent_store_desc%>"  <%=codeDisabled%> >
			<input class='Button' type="button" name='searchParentStore' id='searchParentStore' onClick="return searchParentStoreDetails(parent_store_code,parent_store_desc);" value="?" <%=codeDisabled%>  onBlur="return searchDetails();">
					<input type="hidden" name="parent_store_code" id="parent_store_code" value = "<%=parent_store_code%>" >
				<%}
		 else {%>
			<td><input type="text"   name="parent_store_desc" id="parent_store_desc" size='40' maxLength='40'  value="" >
			<input class='Button' type="button" name='searchParentStore' id='searchParentStore' onClick="return searchParentStoreDetails(parent_store_code,parent_store_desc);" value="?"   >
			<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			<input type="hidden" name="parent_store_code" id="parent_store_code" value = "<%=parent_store_code%>" >
			<%}%>
			</td>
			<td >&nbsp;</td>
		</tr>
	-->	
		<tr>
			 
			<td colspan="3" align="center">&nbsp;</tr>
			<td align="right" colspan="2">
			<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
			<input type="button" name='search' id='search' value="Search" class='Button' onBlur="return searchDetails();" >
			<%}
		 else {%>
			<input type="button" name='search' id='search' value="Search" class='Button' onClick="checkStores();return searchDetails();"  <%=codeDisabled%>>
			</td>
				<%}%>
		</tr>
</table> 

	<input type="hidden"   name="SQL_ST_PARENT_STORE_STORE_LOOKUP" id="SQL_ST_PARENT_STORE_STORE_LOOKUP" 	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_PARENT_STORE_STORE_LOOKUP")%>">
	<input type="hidden"   name="SQL_ST__PARENT_STORE_PARENT_STORE_LOOKUP" id="SQL_ST__PARENT_STORE_PARENT_STORE_LOOKUP" 	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST__PARENT_STORE_PARENT_STORE_LOOKUP")%>">
	<input type="hidden"   name="p_language_id" id="p_language_id" 		 value="<%=locale%>">
	<input type="hidden"   name="store_desc1" id="store_desc1" 		     value="<%=store_desc%>">
	<input type="hidden"   name="parent_store_desc1" id="parent_store_desc1"     value="<%=parent_store_desc%>">
	<input type="hidden"   name="mode" id="mode" 		             value="<%=mode%>">
	<input type="hidden"   name="bean_id" id="bean_id" 		         value="<%=bean_id%>">
	<input type="hidden"   name="bean_name" id="bean_name" 		     value="<%=bean_name%>">
	<input type="hidden"   name="store_result" id="store_result" 		     value="">
	</form>
<%
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
%>
	<script>searchDetails();</script> 
<%}%>
</html>

