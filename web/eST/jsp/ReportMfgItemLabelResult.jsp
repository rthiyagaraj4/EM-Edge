<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.Common.*,eST.*, eCommon.Common.* "%>

<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/StTransaction.js'></script>
		<script language="javascript" src="../../eST/js/ReportMfgItemLabel.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
	<form name="ReportMfgItemLabelResult" id="ReportMfgItemLabelResult">
	<%
		String p_doc_type_code = request.getParameter("p_doc_type_code");
		String store_code = request.getParameter("store_code");
		String dt_from = request.getParameter("dt_from");
		String dt_to = request.getParameter("dt_to");
		String p_doc_no = request.getParameter("p_doc_no");
		String p_label_type = request.getParameter("p_label_type");
		String p_no_labels = request.getParameter("p_no_labels");
		String Report_type = request.getParameter("Report_type");

		if(p_doc_type_code==null) p_doc_type_code	=	"";
		if(store_code==null) store_code	=	"";
		if(dt_from==null) dt_from	=	"";
		if(dt_to==null) dt_to	=	"";
		if(p_doc_no==null) p_doc_no	=	"";
		if(p_label_type==null) p_label_type	=	"";
		if(p_no_labels==null) p_no_labels	=	"";
		
		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String   doc_type		= "";
		String   doc_desc		= "";
		String   docno			= "";
		String   docdate = "";
		String   doc_ref = "";
		String   p_store_code = "";	
		String   p_store_desc = "";	
		try{
			String bean_id = "StockLevelReportBean";
		String bean_name = "eST.StockLevelReportBean";
	
	 StockLevelReportBean bean = (StockLevelReportBean) getBeanObject( bean_id, bean_name, request);   
bean.setLanguageId(locale);
		ArrayList result	=	bean.getResult(Report_type,p_doc_type_code,store_code,dt_from,dt_to,p_doc_no);
String classValue	=	"";
		if(result.size()!= 0){
%>

<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="reprint_rep">
<tr>
<th> <fmt:message key="Common.DocType.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>  </th>
<th> <fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
</tr>
<%	
	ArrayList record		=	null;
	for(int i=0; i<result.size(); i++) {	
	
	int pos				=	0;
	if(i%2==0)
		classValue		=	"QRYEVEN";
	else
		classValue		=	"QRYODD";

	record				=	(ArrayList)result.get(i);
	doc_type			=	(String)record.get(pos);
	doc_desc			=	(String)record.get(++pos);
	docno				=	(String)record.get(++pos);
	docdate				=	(String)record.get(++pos);
	doc_ref				=	(String)record.get(++pos);
	p_store_code		=	(String)record.get(++pos);
	p_store_desc		=	(String)record.get(++pos);
	docdate				=	com.ehis.util.DateUtils.convertDate(docdate,"DMY","en",locale);
%>
<tr>
<td class="<%=classValue%>"><label style="cursor:pointer;color:blue" 
onClick="callReport('<%=doc_type%>','<%=docno%>','<%=p_store_code%>')"> <%=doc_desc%></label></td>
<td class="<%=classValue%>" align='right'><label style="cursor:pointer;color:blue" 
onClick="callReport('<%=doc_type%>','<%=docno%>','<%=p_store_code%>')" ><%=docno%></label></td>
<td class="<%=classValue%>" align='center'><%=docdate%></td>
<td class="<%=classValue%>"><%=CommonBean.checkForNull(doc_ref,"&nbsp;")%></td>
<%if(!p_store_desc.equals("")){%>
<td class="<%=classValue%>"><%=p_store_desc%></td>
	<%}%>
</tr>
	<%
			out.flush();
		}%>
		</table>

	<%	}
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/ReportMfgItemLabelResult.jsp", searched));
		putObjectInBean(bean_id,bean,request);

	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</form>
</body>
</html>

