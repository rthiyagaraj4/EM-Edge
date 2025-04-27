<!DOCTYPE html>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/PORequest.js"></script>
	<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id				=		 "<%= request.getParameter("function_id") %>"
		
		menu_id					=		 "<%= request.getParameter("menu_id") %>"
		module_id				=		 "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%

	String	mode				=		request.getParameter("mode");
	String	item_class_code		=		 (request.getParameter( "item_class_code" )!=null ? (request.getParameter("item_class_code").trim()):"" );
	String	item_class_desc		=		 (request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
	
	request.setCharacterEncoding("UTF-8");
	String locale				=		(String)session.getAttribute("LOCALE");
	mode						=		mode.trim();
	
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;


	String bean_id				=		"porequestBean";
	String bean_name			=		"eST.PORequestBean";

	String codeDisabled			=		"";
	PORequestBean bean			=		(PORequestBean) getBeanObject(bean_id, bean_name, request  );  
	StDuoHeaderBean StDuoBean	=		(StDuoHeaderBean) getBeanObject( "stDuoHeaderBean","eST.Common.StDuoHeaderBean",request);
	bean.setLanguageId(locale);
	
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		bean.initialize();
		//java.util.HashMap defaultParameter	=	bean.getDefaultStParameter();
		//String default_doc_type_code		=	(String)defaultParameter.get("DEF_ISS_DOC_TYPE_CODE");
		//bean.setDefaultDocType(default_doc_type_code);
	}
	else {
		bean.setDefaultDocType(bean.getDoc_type_code());
		codeDisabled						=	 "Disabled";
		bean.setItem_class_code(item_class_code);
		bean.setItem_class_Desc(item_class_desc);
	}
	ServletContext context					=	getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 

	bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	StDuoBean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	String doc_type_code				  =		bean.getDoc_type_code();	
	String doc_no						  =		bean.checkForNull(bean.getDoc_no()) ;
	String doc_date						  =		bean.checkForNull(bean.getDoc_date()) ;
	String doc_ref						  =		bean.checkForNull(bean.getDoc_ref()) ;
	String from_store_code				  =		bean.checkForNull(bean.getRequest_by_store()) ;
	String to_store_code				  =		bean.checkForNull(bean.getRequest_on_store()) ;
	item_class_code						  =		bean.checkForNull(bean.getItem_class_code()) ;
	bean.setItem_class_Desc(item_class_desc);

String prq_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  prq_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{from_store_code,(String) session.getValue( "login_user" )}).get("PRQ_DELETE_YN"),"N");



	%>
	<body onLoad="updateValues();">
		<%
			String trn_type				=		"PRQ";
			String sql_from_store		=		"SQL_ST_PO_REQUEST_FROM_STORE_SELECT";
			String sql_to_store			=		"SQL_ST_PO_REQUEST_TO_DEPT_SELECT";
			String Modal_Window_Open	=		"No";
		
			if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				 Modal_Window_Open		 =		"Yes";
				 item_class_code		 =		"";
				 bean.setItem_class_code(item_class_code);
				 
			}
		%>
		<form name="formPORequestHeader" id="formPORequestHeader">
		
			 <jsp:include page="../../eST/jsp/StDuoHeader.jsp" >  
				<jsp:param name="mode"					value="<%=mode%>" />
				<jsp:param name="trn_type"				value="<%=trn_type%>" />
				<jsp:param name="sql_from_store"		value="<%=sql_from_store%>" />
				<jsp:param name="sql_to_store"			value="<%=sql_to_store%>" />
				<jsp:param name="Modal_Window_Open"		value="<%=Modal_Window_Open%>" />
				<jsp:param name="doc_type_code"			value="<%=doc_type_code%>" />
				<jsp:param name="doc_no"				value="<%=doc_no%>" />
				<jsp:param name="doc_date"				value="<%=doc_date%>" />
				<jsp:param name="doc_ref"				value="<%=doc_ref%>" />
				<jsp:param name="from_store_code"		value="<%=from_store_code%>" />
				<jsp:param name="to_store_code"			value="<%=to_store_code%>" />
				<jsp:param name="item_class_code"		value="<%=bean.getItem_class_code()%>" />
				<jsp:param name="from_store_legend"		value="Req By Store" />
				<jsp:param name="to_store_legend"		value="Req On Store" />
				<jsp:param name="item_class_desc"		value="<%=item_class_desc%>" />
					
				
			</jsp:include>
			<%
			doc_type_code=StDuoBean.getDoc_type_code();
				
			%>
			<input type="hidden" name="request_by_store" id="request_by_store"	value="">
			<input type="hidden" name="request_on_store" id="request_on_store"	value="">
			<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name%>">
			<input type='hidden' name="trn_type" id="trn_type"			value="PRQ">
			
			<input type="hidden" name="item_class" id="item_class"			value="">
			<input type="hidden" name="item_class_des" id="item_class_des"		value="">
			<input type="hidden" name="item_class_code1" id="item_class_code1"	value="<%=bean.getItem_class_code()%>">
			<input type="hidden" name="doc_type_code1" id="doc_type_code1"		value="<%=doc_type_code%>">
			<input type="hidden" name="prq_delete_yn" id="prq_delete_yn"		value="<%=prq_delete_yn%>">
			
			<table border='0' cellpadding=0 cellspacing=0  width='100%' align="center">
			<tr>
				<td class='label' width='15%' ><b>&nbsp;&nbsp;<fmt:message key="eST.ReqType.label" bundle="${st_labels}"/>&nbsp;&nbsp;:</b></td>
				<td class=fields width='15%' >&nbsp;<select name='request_type' id='request_type' <%=codeDisabled%> >
				<option value="R" <%=bean.getRequestType().equals("R")?"Selected":""%>>Routine</option>
				<option value="U"  <%=bean.getRequestType().equals("U")?"Selected":""%>>Urgent</option></select></td>
				<td class=label >&nbsp;</td>
			</tr>
			</table>
		</form>
<% putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>



