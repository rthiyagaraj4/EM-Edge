<!DOCTYPE html>
<%@ page import=" eST.AcknowledgmentBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/Acknowledgment.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

		<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
	</head>
<%
		String bean_id	=	"acknowledgmentBean";
		String bean_name=	"eST.AcknowledgmentBean";
		//String remarks		=	"";
		String remarks		=	(String)request.getParameter("remarks")==null?"":(String)request.getParameter("remarks");	
		//String doc_no		=	(String)request.getParameter("doc_no")==null?"":(String)request.getParameter("doc_no");	
		//String item_code	=	(String)request.getParameter("item_code")==null?"":(String)request.getParameter("item_code");	
		//String seq_no		=	(String)request.getParameter("seq_no")==null?"":(String)request.getParameter("seq_no");	
		//String doc_type_code=	(String)request.getParameter("doc_type_code")==null?"":(String)request.getParameter("doc_type_code");	
		//String batch_id		=	(String)request.getParameter("batch_id")==null?"":(String)request.getParameter("batch_id");	
		//String expiry_date	=	(String)request.getParameter("expiry_date")==null?"":(String)request.getParameter("expiry_date");	
		//String bin_location_code	=	(String)request.getParameter("bin_location_code")==null?"":(String)request.getParameter("bin_location_code");	
		eST.AcknowledgmentBean bean = (eST.AcknowledgmentBean)getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
		bean.setLanguageId(locale);
/*		ArrayList<String> alParam	= new ArrayList();
		alParam.add(doc_no);
		alParam.add(item_code);
		alParam.add(seq_no);
		alParam.add(doc_type_code);
		alParam.add(batch_id);
		alParam.add(bin_location_code);
		alParam.add(expiry_date);
		try{
			remarks	= (String)((HashMap)bean.fetchRecord("SELECT ITEM_CODE,EXPIRY_DATE_OR_RECEIPT_DATE,DOC_SRL_NO,BATCH_ID,BIN_LOCATION_CODE,DOC_NO,SEQ_NO,DOC_TYPE_CODE,MODIFIED_DATE,REMARKS FROM ST_ACKNOWLEDGE_TRN_DTL_LOG WHERE MODIFIED_DATE = (SELECT MAX(MODIFIED_DATE) FROM ST_ACKNOWLEDGE_TRN_DTL_LOG WHERE DOC_NO = ? AND REJECTED_QTY > 0 AND ITEM_CODE = ? AND SEQ_NO = ? AND DOC_TYPE_CODE = ? AND BATCH_ID = ? AND BIN_LOCATION_CODE = ? AND TO_CHAR(EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') = ?)",alParam)).get("REMARKS");
		}catch(Exception e){
			e.printStackTrace();
		}*/
	%>
<body onload='FocusFirstElement();'>
	<form name= "formAcknowledgeRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			&nbsp;&nbsp;
			<%if(((String)bean.getAction_type()).equals("C")) {%>
			<textarea name="remarks" rows="3" cols="40" readonly><%=remarks%></textarea>&nbsp;
			<%}else{%>
			<textarea name="remarks" rows="3" cols="40" ><%=remarks%></textarea>&nbsp;
			<%}%>
			&nbsp;
		</td>
	  </tr>
	  <tr>
		<td  colspan="2" align="right"><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="updateRemarks();"></td>
	  </tr>
	</table>
		<input type="hidden"	name="bean_id" id="bean_id"		value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"	value="<%=bean_name %>">
	</form>
	</body>
</html>

