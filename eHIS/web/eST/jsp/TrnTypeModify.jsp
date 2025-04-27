<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*, java.sql.*, java.util.Properties, java.util.ArrayList,java.util.HashMap,  eCommon.Common.OptionValues,eST.Common.*, eST.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>
	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/TrnType.js"></script>
</head>

<%
    String bean_id			=	"";
	String bean_name		=	"";
	String disble		=	"";


try { 
    bean_id = "trnTypeBean" ;
	bean_name = "eST.TrnTypeBean";
	TrnTypeBean bean = (TrnTypeBean)getBeanObject( bean_id,bean_name,request ) ; 
	bean.setLanguageId(locale);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	bean.clear() ;
	ArrayList alRecords	=	bean.loadData();
	boolean finalizedcount = bean.getRecordCountForTransactionTables(); //Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record
 %>
	 <%
putObjectInBean(bean_id,bean,request);
%>
<body >
<form name="formTrnType" id="formTrnType">
<BR><BR>
<table border="1" cellpadding="0" cellspacing="0" width="85%" align="center" id='tb1'>
<tr>
 <th><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/><BR><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
 <th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
 <th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
 <th>No. of records <br>per Transaction</th>
 <th><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/><BR> <fmt:message key="eST.BasedYN.label" bundle="${st_labels}"/></th>
<!-- <th><fmt:message key="eST.ItemClassWiseDocuments.label" bundle="${st_labels}"/></th>-->
<th><fmt:message key="eST.ItemClassWise.label" bundle="${st_labels}"/><BR> <fmt:message key="Common.documents.label" bundle="${common_labels}"/></th>
 <th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> <BR><fmt:message key="eST.ModifiableYN.label" bundle="${st_labels}"/></th>
</tr>
<%
	HashMap hmRecord	=	null;
	for (int i=0;i<alRecords.size() ;i++ ) {
	hmRecord			=	(HashMap)alRecords.get(i);
	String trn_type		=	(String)hmRecord.get("TRN_TYPE");
	if(trn_type.equals("PRT")||trn_type.equals("MFG")||trn_type.equals("CEB")||trn_type.equals("VAR"))
		disble = "disabled";
	else
		disble = "";
	String records_per_trn		=	(String)hmRecord.get("RECORDS_PER_TRN")==null?"":(String)hmRecord.get("RECORDS_PER_TRN");
	//String long_desc	=	(String)hmRecord.get("LONG_DESC");
	//String short_desc	=	(String)hmRecord.get("SHORT_DESC");
	String className	=	(i%2==0)?"QRYODD":"QRYEVEN";
	%>
		<tr>
		    <td class="<%=className%>"><%=trn_type%></td>
			<td class="<%=className%>"><%=hmRecord.get("LONG_DESC")%></td>
			<td class="<%=className%>"><%=hmRecord.get("SHORT_DESC")%></td>
		    <td class="<%=className%>" style="text-align:RIGHT"><input type=text size=4 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger() " onblur="checkZero(this,'<%=finalizedcount%>','<%=records_per_trn%>','<%=trn_type%>');" name="<%=trn_type.toLowerCase()%>_records_per_trn" value="<%=records_per_trn%>" <%=disble%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="<%=className%>" align='center' ><input type=checkbox  name="<%=trn_type.toLowerCase()%>_item_class_based_yn" id="<%=trn_type.toLowerCase()%>_item_class_based_yn" <%=bean.getChecked((String)hmRecord.get("ITEM_CLASS_BASED_YN"))%> value='Y' <%=(trn_type.toLowerCase().equals("var")||trn_type.toLowerCase().equals("mfg")||trn_type.toLowerCase().equals("ceb"))?"disabled":""%>></td>
			<td class="<%=className%>" align='center' ><input type=checkbox  name="<%=trn_type.toLowerCase()%>_item_class_wise_documents_yn" id="<%=trn_type.toLowerCase()%>_item_class_wise_documents_yn" <%=bean.getChecked((String)hmRecord.get("ITEM_CLASS_WISE_DOCUMENTS_YN"))%> value='Y' <%=disble%>></td>
			<td class="<%=className%>" align='center' ><input type=checkbox  name="<%=trn_type.toLowerCase()%>_doc_date_modifiable_yn" id="<%=trn_type.toLowerCase()%>_doc_date_modifiable_yn" <%=bean.getChecked((String)hmRecord.get("DOC_DATE_MODIFIABLE_YN"))%> value='Y'></td>
        </tr>  
<%
	}
}
catch (Exception exception) {
		exception.printStackTrace();
}
finally {} %>
</table>
	<input type="hidden" name="mode" id="mode" value="<%=eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">

</form>

</body>

