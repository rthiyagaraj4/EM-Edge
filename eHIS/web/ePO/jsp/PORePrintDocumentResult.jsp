<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.lang.*,java.util.HashMap,java.util.ArrayList,java.util.Properties,ePO.Common.*,ePO.*, eCommon.Common.* "%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../ePO/js/PoCommon.js'></script>
		<script language="javascript" src="../../ePO/js/POReprintDocument.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<form name="RePrintDocumentResult" id="RePrintDocumentResult">
	<%
		String trn_type = request.getParameter("p_trn_type");
		String doc_type_code = request.getParameter("p_doc_type_code");
		String fr_st_code = request.getParameter("store_code")+"%";
		String dt_from = request.getParameter("dt_from");
		String dt_to = request.getParameter("dt_to");
		String doc_no = request.getParameter("p_doc_no");
		String pur_unit = request.getParameter("pur_unit");
		String supp_code = request.getParameter("supp_code");
		
		System.out.println("trn_type======>" +trn_type);
		System.out.println("doc_type_code======>" +doc_type_code);
		System.out.println("fr_st_code======>" +fr_st_code);
		System.out.println("dt_from======>" +dt_from);
		System.out.println("dt_to======>" +dt_to);
		System.out.println("pur_unit======>" +pur_unit);
		System.out.println("supp_code======>" +supp_code);
		
		

		if(trn_type==null) trn_type	=	"";
		if(doc_type_code==null) doc_type_code	=	"";
		if(fr_st_code==null) fr_st_code	=	"";
		if(dt_from==null) dt_from	=	"";
		if(dt_to==null) dt_to	=	"";
		if(doc_no==null) doc_no	=	"";
		if(pur_unit==null) pur_unit	=	"";
		if(supp_code==null) supp_code	=	"";
		 

		boolean searched = (request.getParameter("searched") == null) ?false:true;

		String doc_type					= "";
		String doc_desc					= "";
		String issue_seq				= "";
		String docno					= "";
		String docdate					= "";
		String doc_ref					= "";
		String fm_store_code			= "";
		String fm_store_desc			= "";
		String to_store_code			= "";
		String to_store_desc			= "";
		String store_code				= "";	
		String store_desc				= "";	
		String pur_unit_code			= "";
		String pur_unit_desc			= "";
		String suppl_code				= "";
		String supp_desc				= "";
		String store_code_for_passing	= "";
		try{
		String bean_id = "PORePrintDocReportBean";
		String bean_name = "ePO.PORePrintDocReportBean";
	
		PORePrintDocReportBean bean = (PORePrintDocReportBean) getBeanObject( bean_id, bean_name, request);   
		bean.setLanguageId(locale);
		ArrayList result	=	bean.getResult(trn_type,doc_type_code,fr_st_code,dt_from,dt_to,doc_no,pur_unit,supp_code);
	System.out.println("result==============>" +result);
		String classValue	=	"";
		
		if(result.size()!= 0){
%>

<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="reprint_rep">
<% if ((trn_type.equals("POREQN")))
{ %>

<tr>
<th><fmt:message key="ePO.RequestNo.label" bundle="${po_labels}"/></th>
<th><fmt:message key="ePO.Request Date.label" bundle="${po_labels}"/></th>
<th><fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/></th>
<th> <fmt:message key="Common.Store.label" bundle="${mm_labels}"/> </th>
<th><fmt:message key="ePO.RequestType.label" bundle="${po_labels}"/></th>

</tr>

<% } else if(trn_type.equals("PORDER")) { %>

<tr>
<th><fmt:message key="ePO.PONo.label" bundle="${po_labels}"/></th>
<th><fmt:message key="ePO.PODate.label" bundle="${po_labels}"/></th>
<th><fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/></th>
<th><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/></th>
<th><fmt:message key="ePO.PurchaseType.label" bundle="${po_labels}"/></th>

 </tr>

<% } else if(trn_type.equals("DLVORD")) { %>

<tr>
<th><fmt:message key="ePO.DONo.label" bundle="${po_labels}"/></th>
<th><fmt:message key="ePO.DODate.label" bundle="${po_labels}"/></th>
<th><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/></th>
<th><fmt:message key="ePO.DOType.label" bundle="${po_labels}"/></th>

 </tr>

<% } %>
 
<%	for(int i=0; i<result.size(); i++) {	
	
	int pos				=	0;

	if(i%2==0)
		classValue		=	"QRYEVEN";
	else
		classValue		=	"QRYODD";

	ArrayList record		=	(ArrayList)result.get(i);
	System.out.println("record=118====>" +record);
	doc_type		=	(String)record.get(pos);
	doc_desc		=	(String)record.get(++pos);
	docno			=	(String)record.get(++pos);
	docdate		=	(String)record.get(++pos);
	doc_ref		=	(String)record.get(++pos);
	if (trn_type.equals("POREQN")){
		store_code		=	(String)record.get(++pos);
		store_desc		=	(String)record.get(++pos);
		pur_unit_code =	(String)record.get(++pos);
		pur_unit_desc = (String)record.get(++pos);
		store_code_for_passing=store_code;
	}else if(trn_type.equals("PORDER")){
		 pur_unit_code =	(String)record.get(++pos);
		 pur_unit_desc = (String)record.get(++pos);
		 suppl_code =	(String)record.get(++pos);
		 supp_desc = (String)record.get(++pos);
	 }
	 else if(trn_type.equals("DLVORD")){

	 suppl_code =	(String)record.get(++pos);
     supp_desc = (String)record.get(++pos);
	 }

	
     docdate = com.ehis.util.DateUtils.convertDate(docdate,"DMY","en",locale);

%>
<tr>

<td class="<%=classValue%>"><label style="cursor:pointer;color:blue" onClick="callReport('<%=docno%>','<%=store_code_for_passing%>')"> <%=docno%></label></td>
<td class="<%=classValue%>" align='center'><%=docdate%></td>

<%if(!pur_unit_desc.equals("")){%>
<td class="<%=classValue%>" align='center'><%=pur_unit_desc%></td>
<%}%>

<%if(!store_desc.equals("")){%>
	<td class="<%=classValue%>"><%=store_desc%></td>
<%}else{%>
	<td class="<%=classValue%>"><%=supp_desc%></td>  
<%}%>
	<td class="<%=classValue%>" align='center'><%=doc_desc%></td>
</tr> 
<%}%>
</table>
	<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/PORePrintDocumentQueryResult.jsp", searched));
		putObjectInBean(bean_id,bean,request);

	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>


</form>
</body>
</html>

