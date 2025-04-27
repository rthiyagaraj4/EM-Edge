<!DOCTYPE html>
<%@ page import=" ePO.*, ePO.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
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
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/STPORequest.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
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


	String bean_id				=		"stporequestBean";
	String bean_name			=		"ePO.STPORequestBean";

	String codeDisabled			=		"";
	STPORequestBean bean			=		(STPORequestBean) getBeanObject(bean_id, bean_name, request  );  
	bean.setLanguageId(locale);
	
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		bean.initialize();
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
	
	String doc_type_code				  =		bean.getDoc_type_code();	
	String doc_no						  =		bean.checkForNull(bean.getDoc_no()) ;
	String doc_date						  =		bean.checkForNull(bean.getDoc_date()) ;
	String doc_ref						  =		bean.checkForNull(bean.getDoc_ref()) ;
	String from_store_code				  =		bean.checkForNull(bean.getRequest_by_store()) ;
	String to_store_code				  =		bean.checkForNull(bean.getRequest_on_store()) ;
	item_class_code						  =		bean.checkForNull(bean.getItem_class_code()) ;
	String codeDisbled ="";
	bean.setItem_class_Desc(item_class_desc);

	String prq_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  REQ_DELETE_ALLOWED_YN  from  PO_USER_FOR_PUNIT where PUR_UNIT_CODE=? and USER_ID=?",new String[]{to_store_code,(String) session.getValue( "login_user" )}).get("REQ_DELETE_ALLOWED_YN"),"N");

	String master_type			=		"POREQN";	

	bean.setMasterType(master_type);

	
	 if(!locale.equals("en")){
	 doc_date							=			com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
	 }
	
	String docNoDisable			=		"";	
	String docNoGenMethod		=		"";
	docNoGenMethod	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_DOC_TYPE_SELECT_FLAG_FROM_CONTROL_TABLE")).get("REQ_DOC_NO_GEN_METHOD");
	
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		if(bean.checkForNull(docNoGenMethod).equals("A")){
			docNoDisable="disabled";
		}else if(bean.checkForNull(docNoGenMethod).equals("M")){
			docNoDisable="";
		}
	}else{
		docNoDisable="disabled";
	}	
	
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) 
	codeDisbled ="disabled";

	%>
	<body> 
		<form name="formPORequestHeader" id="formPORequestHeader">
				
		<table border='0' cellpadding='2' cellspacing='0' width='102%' height='100%' align=center>
			<tr>
				
				<td  class="label"><fmt:message key="ePO.PORaisedBy.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;
					<select name="purchase_unit" id="purchase_unit" onchange="docnoEnableYN(this)" <%=codeDisbled%>>
					<%=bean.getPurchaseUnitList()%>
					</select><%=bean.getImage("M")%>
				</td>	
				
				<td  class="label"><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
				<td class="fields">&nbsp;
					<select name="request_by_store" id="request_by_store" <%=codeDisbled%>>					
					<%=bean.getRequestByStoreList()%> 
					</select><%=bean.getImage("M")%>
				</td>
				
				<td  class="label"><fmt:message key="ePO.RequestType.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;
					<select name="purchase_type" id="purchase_type" <%=codeDisbled%>>
					<%=bean.getPurchaseTypeList()%>
					</select><%=bean.getImage("M")%>
				</td>

			</tr>	
				
			<tr>
				
				
				<td  class="label">	<fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>	</td>
				<td class="fields">&nbsp;&nbsp;&nbsp;<input type="text"  name="doc_date" id="doc_date"  maxLength="10" size="10" value="<%=doc_date%>"  onBlur="CheckDate(this);">&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');" <%=codeDisbled%> ></img><%=bean.getImage("M")%>
				</td>
					
				<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
				<td class="fields">&nbsp;&nbsp;<input type="text" class="NUMBER" value="<%=bean.getDoc_no()%>" name="doc_no" maxLength="20" size="20" onKeyPress="return CheckForSpecialChars(event);" onBlur="checkSpecialChars(this);" <%=docNoGenMethod%> >
				</td>
					
				<td  class="label"><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/></td>
				<td class="fields">&nbsp;&nbsp;<input type="text" value="<%=bean.getDoc_ref()%>" name="doc_ref"  maxLength="20" size="20">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label onMouseOver="changeCursor(this);"  class="label" onClick = "showRemarks(remarks.value,'');"><font class='HYPERLINK'><fmt:message key="ePO.RequestRemarks.label" bundle="${po_labels}"/></font></label></td>
			</tr>		
			
				
		</table>
			
			<input type="hidden" name="request_on_store" id="request_on_store"	value="<%=bean.getRequest_on_store()%>">
			<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name%>">
			<input type='hidden' name="trn_type" id="trn_type"			value="PRQ">
			<input type="hidden" name="item_class" id="item_class"			value="">
			<input type="hidden" name="item_class_des" id="item_class_des"		value="">
			<input type="hidden" name="item_class_code1" id="item_class_code1"	value="">
			<input type="hidden" name="authorize_yn" id="authorize_yn"		value="">
			<input type="hidden" name="autono_yn" id="autono_yn"		value="">
			<input type="hidden" name="remarks" id="remarks"			value="<%=bean.checkForNull(bean.getHeaderRemarks())%>">
			<input type="hidden" name="prq_delete_yn" id="prq_delete_yn"			value="<%=prq_delete_yn%>">

			
		</form>
<% putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>



