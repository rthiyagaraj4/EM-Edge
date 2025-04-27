<!DOCTYPE html>
 <%@ page import="eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList,eST.Common.StDuoHeaderBean,eCommon.XSSRequestWrapper"contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script> 
		<script language="JavaScript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
        function_id				=		 "<%= request.getParameter("function_id") %>"
		
		</script>
</head>
<body onLoad="updateValues();">
	<%
		//System.out.println("request.getParameter item_class_code ===>"+request.getParameter( "item_class_code" ));
		//System.out.println("request.getParameter item_class_desc ===>"+request.getParameter( "item_class_code" ));
	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String	item_class_code			=		(request.getParameter( "item_class_code" )!=null ? (request.getParameter("item_class_code").trim()):"" );
		String	item_class_desc			=		(request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
		
		
		String locale					=		(String)session.getAttribute("LOCALE");
		String mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		String trn_type					=		"ISS";
		String sql_from_store			=		"SQL_ST_REQUEST_FROM_STORE_SELECT_FOR_AUTH_AT_ISS";
		String sql_to_store				=		"SQL_ST_REQ_BY_STORE_SELECT_FOR_AUTH_AT_ISS";
		String Modal_Window_Open		=		"No";

		String bean_id					=		"authorizeAtIssueStoreBean";
		String bean_name				=		"eST.AuthorizeAtIssueStoreBean";

		AuthorizeAtIssueStoreBean bean  =		(AuthorizeAtIssueStoreBean)getBeanObject(bean_id,bean_name,request);  
		StDuoHeaderBean StDuoBean		=		(StDuoHeaderBean) getBeanObject( "stDuoHeaderBean","eST.Common.StDuoHeaderBean",request);
		bean.setLanguageId(locale);
		StDuoBean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
		String closeRemarks = "";//added for MO-CRF-20173
		
		ServletContext context			=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode(mode.trim());
		

		String doc_type_code			=		bean.checkForNull(bean.getDoc_type_code());
		String doc_no					=		bean.checkForNull(bean.getDoc_no()) ;
		String doc_date					=		bean.checkForNull(bean.getDoc_date()) ;
		String doc_ref					=		bean.checkForNull(bean.getDoc_ref()) ;
		String from_store_code			=		bean.checkForNull(bean.getRequest_on_store()) ;
		String to_store_code			=		bean.checkForNull(bean.getRequest_by_store()) ;
		//String item_class_code		=		bean.checkForNull(bean.getItem_class_code()) ;
		mode							=		request.getParameter("mode");

		bean.setItem_class_desc(item_class_desc);	

		/*System.out.println("mode ===>"+mode);
		System.out.println("trn_type ===>"+trn_type);
		System.out.println("sql_from_store ===>"+sql_from_store);
		System.out.println("sql_to_store ===>"+sql_to_store);
		System.out.println("Modal_Window_Open ===>"+Modal_Window_Open);
		System.out.println("doc_type_code ===>"+doc_type_code);
		System.out.println("doc_no ===>"+doc_no);
		System.out.println("doc_date ===>"+doc_date);
		System.out.println("doc_ref ===>"+doc_ref);
		System.out.println("from_store_code ===>"+from_store_code);
		System.out.println("to_store_code ===>"+to_store_code);
		System.out.println("item_class_code ===>"+item_class_code);
		System.out.println("item_class_desc ===>"+item_class_desc);*/
		
	%>
	<form name="formAuthorizeAtIssueStoreHeader" id="formAuthorizeAtIssueStoreHeader">
		<jsp:include page="../../eST/jsp/StDuoHeader.jsp" > 
			<jsp:param		name="mode"					value="<%=mode%>" />
			<jsp:param		name="trn_type"				value="<%=trn_type%>" />
			<jsp:param		name="sql_from_store"		value="<%=sql_from_store%>" />
			<jsp:param		name="sql_to_store"			value="<%=sql_to_store%>" />
			<jsp:param		name="Modal_Window_Open"	value="<%=Modal_Window_Open%>" />
			<jsp:param		name="doc_type_code"		value="<%=doc_type_code%>" />
			<jsp:param		name="doc_no"				value="<%=doc_no%>" />
			<jsp:param		name="doc_date"				value="<%=doc_date%>" />
			<jsp:param		name="doc_ref"				value="<%=doc_ref%>" />
			<jsp:param		name="from_store_code"		value="<%=from_store_code%>" />
			<jsp:param		name="to_store_code"		value="<%=to_store_code%>" />
			<jsp:param		name="item_class_code"		value="<%=item_class_code%>" />	 
			<jsp:param		name="item_class_desc"		value="<%=item_class_desc%>" />
			<jsp:param		name="item_class"			value="<%=item_class_desc%>" />
			<jsp:param		name="from_store_legend"	value="Req On Store"  />
			<jsp:param		name="to_store_legend"		value="Req By Store"/>	 
		</jsp:include> 
		<table cellspacing="0" width="100%" align=center>
		 <tr>
			<td  class="label"><fmt:message key="eST.CloseUponIssue.label" bundle="${st_labels}"/> 
			&nbsp;&nbsp;<input type="checkbox" name="close_upon_issue_yn" id="close_upon_issue_yn" value="Y"  onclick="mandatorygif();setValueCloseUponIssue(this);">&nbsp;&nbsp;</td><!-- modified for MO-CRF-20173 -->
			<td><label onMouseOver="changeCursor(this);"  class="label" onClick = "showRemarks();"><font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></label>&nbsp;&nbsp;<b id="mgif" style="display:none"><img src="../../eCommon/images/mandatory.gif" align=center></b></td>
			<td> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>																
			</tr>
		</table>
		<input type="hidden"	name="request_by_store_code" id="request_by_store_code"		value="">
		<input type="hidden"	name="request_on_store_code" id="request_on_store_code"		value="">
		<input type="hidden"	name="mode" id="mode"							value="<%=mode%>">
		<input type="hidden"	name="bean_id" id="bean_id"						value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"					value="<%= bean_name %>">
		<input type="hidden"	name="item_class_code1" id="item_class_code1"				value="<%= item_class_code %>">
		<input type="hidden"	name="item_class_desc1" id="item_class_desc1"				value="<%= item_class_desc %>">
		<input type="hidden"	name="locale" id="locale"				value="<%=locale%>"> 
		<input type="hidden" name="trn_type" id="trn_type"				value="<%=trn_type%>">
		<input type="hidden" name="closeRemarks" id="closeRemarks"				value="<%=closeRemarks%>"><!-- added for MO-CRF-20173 -->
		</form>

		<%
		
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

