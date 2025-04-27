<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.lang.*,java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.Common.*,eST.*, eCommon.Common.* "%>

<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
String facility_id			=		(String) session.getValue( "facility_id" ) ;
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
<!-- 		<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
		<script language="javascript" src="../../eST/js/ReprintDocument.js"></script>
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
		String p_seq_chk = request.getParameter("p_seq_chk");
		String p_include_ack	=	request.getParameter("p_include_ack"); //Added By Sakti Sankar on 11/02/2013 against SCF#ML-BRU-SCF-0640 inc#36859
		

		if(trn_type==null) trn_type	=	"";
		if(doc_type_code==null) doc_type_code	=	"";
		if(fr_st_code==null) fr_st_code	=	"";
		if(dt_from==null) dt_from	=	"";
		if(dt_to==null) dt_to	=	"";
		if(doc_no==null) doc_no	=	"";
		if(p_seq_chk==null) p_seq_chk	=	"N";
		if (trn_type.equals("CON")) {trn_type="SAL";
		}

		boolean searched = (request.getParameter("searched") == null) ?false:true;
//pmd 29/01/05
//		String classvalue		= "";
		String   doc_type		= "";
		String   doc_desc		= "";
		String   issue_seq		= "";
		String   docno			= "";
		String   docdate = "";
		String   doc_ref = "";
		String   fm_store_code = "";
		String   fm_store_desc	= "";
		String   to_store_code	= "";
		String   to_store_desc	= "";
		String   store_code = "";	
		String   store_desc = "";	
		String   patient_id  = "";
		String store_code_for_passing="";
		try{
		String bean_id = "RePrintDocReportBean";
		String bean_name = "eST.RePrintDocReportBean";
	
	 RePrintDocReportBean bean = (RePrintDocReportBean) getBeanObject( bean_id, bean_name, request);   
	bean.setLanguageId(locale);
		//ArrayList result	=	bean.getResult(trn_type,doc_type_code,fr_st_code,dt_from,dt_to,doc_no);
		//Added new parameter p_include_ack By Sakti Sankar on 11/02/2013 against SCF#ML-BRU-SCF-0640 inc#36859
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID")); //HSA GOLIVE Performance

System.err.println("=====ML-MMOH-SCF-2173=====trn_type=="+trn_type+"doc_type_code=="+doc_type_code+"==fr_st_code=="+fr_st_code+"==dt_from===="+dt_from+"==dt_to=="+dt_to+"==doc_no=="+doc_no+"==p_include_ack=="+p_include_ack);

		ArrayList result	=	bean.getResult(trn_type,doc_type_code,fr_st_code,dt_from,dt_to,doc_no,p_include_ack);
		String classValue	=	"";

System.err.println("=====ML-MMOH-SCF-2173===result=="+result.size());

		if(result.size()!= 0){
%>

<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="reprint_rep">
<% if ((trn_type.equals("ADJ"))||  (trn_type.equals("CEB"))  ||  (trn_type.equals("MFG"))||  (trn_type.equals("VAR")) ||   (trn_type.equals("RTV"))||  (trn_type.equals("GRN")) || (trn_type.equals("PRT"))) 
{ %>

<tr>
<th> <fmt:message key="Common.DocType.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>  </th>
<th> <fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.Store.label" bundle="${common_labels}"/> </th>
</tr>

<% } else if(trn_type.equals("REQ")) { %>

<tr>
<th> <fmt:message key="Common.DocType.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocNo.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/> </th>
</tr>

<% } else if(trn_type.equals("ISS")||trn_type.equals("REQPIC")) { %>

<tr>
<th> <fmt:message key="Common.DocType.label" bundle="${common_labels}"/>  </th>
<th> <fmt:message key="Common.DocNo.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="eST.IssueSequence.label"   bundle="${st_labels}"/></th>
<th> <fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.FromStore.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.ToStore.label" bundle="${common_labels}"/> </th>
</tr>
<% } else if(trn_type.equals("URG")) { %>

<tr>
<th> <fmt:message key="Common.DocType.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocNo.label" bundle="${common_labels}"/> </th>
<th><fmt:message key="eST.IssueSequence.label" bundle="${st_labels}"/>  </th>
<th> <fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.FromStore.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.ToStore.label" bundle="${common_labels}"/> </th>
</tr>
<% } else if(trn_type.equals("RET")) { %>

<tr>
<th> <fmt:message key="Common.DocType.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocNo.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.FromStore.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.ToStore.label" bundle="${common_labels}"/> </th>
</tr>

<% } else if(trn_type.equals("TFR")) { %>

<tr>
<th> <fmt:message key="Common.DocType.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocNo.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.FromStore.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.ToStore.label" bundle="${common_labels}"/> </th>
</tr>
<% } else if(trn_type.equals("SAL") || trn_type.equals("SRT") ) { 	%>

<th> <fmt:message key="Common.DocType.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>  </th>
<th> <fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.patientId.label"   bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.Store.label" bundle="${common_labels}"/> </th>
<% } %>
<%	for(int i=0; i<result.size(); i++) {	
	
	int pos				=	0;

	if(i%2==0)
		classValue		=	"QRYEVEN";
	else
		classValue		=	"QRYODD";

	ArrayList record		=	(ArrayList)result.get(i);
	doc_type		=	(String)record.get(pos);
	doc_desc		=	(String)record.get(++pos);
	docno			=	(String)record.get(++pos);
	
	//Added by Rabbani # Inc no:35591 on 05/10/2012  
	String sal_trn_type = "";

	if (trn_type!=null && trn_type.equals("SAL")) { //ML-MMOH-SCF-2173 -- Only for SAL it is required, currently it is firing for all.
		sal_trn_type = CommonBean.checkForNull((String)bean.fetchRecord("SELECT SAL_TRN_TYPE FROM st_sal_hdr WHERE FACILITY_ID = ? AND  DOC_TYPE_CODE = ?  AND  DOC_NO =?" ,new String[]{facility_id,doc_type,docno}).get("SAL_TRN_TYPE"));

System.err.println("===ML-MMOH-SCF-2173 ====sal_trn_type"+sal_trn_type);
	}


	if (trn_type.equals("ISS")||trn_type.equals("URG")||trn_type.equals("REQPIC"))
	{
	 issue_seq		=	(String)record.get(++pos);
	}
	docdate		=	(String)record.get(++pos);
	doc_ref		=	(String)record.get(++pos);

	if (trn_type.equals("ISS")||trn_type.equals("REQ")||trn_type.equals("TFR")||trn_type.equals("URG") ||trn_type.equals("RET")||trn_type.equals("REQPIC")) 
	{
	fm_store_code		=	(String)record.get(++pos);
	fm_store_desc		=	(String)record.get(++pos);
	to_store_code		=	(String)record.get(++pos);
	to_store_desc		=	(String)record.get(++pos);
	store_code_for_passing=fm_store_code;
	} else {
	store_code		=	(String)record.get(++pos);
	store_desc		=	(String)record.get(++pos);
	store_code_for_passing=store_code;
	if (trn_type.equals("SAL")||trn_type.equals("SRT"))
	{
     patient_id = (String)record.get(++pos);
	}

	}
docdate = com.ehis.util.DateUtils.convertDate(docdate,"DMY","en",locale);
%>
<tr>


<% if(p_seq_chk.equals("Y")){%>
<td class="<%=classValue%>"><label style="cursor:pointer;color:blue" 
onClick="callReport('<%=doc_type%>','<%=docno%>','<%=store_code_for_passing%>','<%=issue_seq%>','<%=p_seq_chk%>','<%=sal_trn_type%>')"> <%=doc_desc%></label></td>
<%
}else{
%>
<td class="<%=classValue%>"><label style="cursor:pointer;color:blue" 
onClick="callReport('<%=doc_type%>','<%=docno%>','<%=store_code_for_passing%>','<%=issue_seq%>','','<%=sal_trn_type%>')"> <%=doc_desc%></label></td>
<%}%>


<% if(p_seq_chk.equals("Y")){%>
<td class="<%=classValue%>" align='right'><label style="cursor:pointer;color:blue" 
onClick="callReport('<%=doc_type%>','<%=docno%>','<%=store_code_for_passing%>','<%=issue_seq%>','<%=p_seq_chk%>','<%=sal_trn_type%>')" ><%=docno%></label></td>
<%
}else{
%>
<td class="<%=classValue%>" align='right'><label style="cursor:pointer;color:blue" 
onClick="callReport('<%=doc_type%>','<%=docno%>','<%=store_code_for_passing%>','<%=issue_seq%>','','<%=sal_trn_type%>')" ><%=docno%></label></td>
<%}%>


<% if (trn_type.equals("ISS")||trn_type.equals("URG")||trn_type.equals("REQPIC")) { %>

	<td class="<%=classValue%>" align='right'><%=issue_seq%></td>
      <% } %>

<td class="<%=classValue%>" align='center'><%=docdate%></td>
<% if (trn_type.equals("SRT")||trn_type.equals("SAL")) { %>
<td class="<%=classValue%>"><%=CommonBean.checkForNull(patient_id,"&nbsp;")%></td>
<% }else   { %>
<td class="<%=classValue%>"><%=CommonBean.checkForNull(doc_ref,"&nbsp;")%></td>
<% }%>
<% if (trn_type.equals("ISS")||trn_type.equals("REQ") ||trn_type.equals("TFR")||trn_type.equals("URG") ||trn_type.equals("RET")||trn_type.equals("REQPIC")) 
{ %>
<td class="<%=classValue%>"><%=fm_store_desc%></td>
<td class="<%=classValue%>"><%=to_store_desc%></td>
<%  } %>
<%if(!store_desc.equals("")){%>
<td class="<%=classValue%>"><%=store_desc%></td>
	<%}%>


</tr>
<%	}	%>
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/RePrintDocumentQueryResult.jsp", searched));
		putObjectInBean(bean_id,bean,request);

	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>


</form>
</body>
</html>

