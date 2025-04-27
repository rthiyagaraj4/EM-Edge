<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
05/02/2021      TFS id:6938        B Haribabu          05/02/2021                     MMS-DM-CRF-0174.3
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.AcknowledgmentBean,java.util.ArrayList,java.util.HashMap,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language='javascript' src='../../eST/js/Acknowledgment.js'></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String classvalue = "";
		AcknowledgmentBean bean	=	(AcknowledgmentBean) getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
		bean.setLanguageId(locale);
		int i = 0;
	%>
	<form name="formAcknowledgeDetail" id="formAcknowledgeDetail">
	<%
		ArrayList result = (ArrayList)bean.getTFRDtlRecords();
		if(result.size()<=0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}else{
		//Added for TFS id:6938 start
			if(((String)bean.getAction_type()).equals("A")){
		bean.setBarcodeApplForAckYN();
			}
			//Added for TFS id:6938 end
	%>
		<table border='1' cellpadding='0' cellspacing='0' width=100% align=center>
		<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></th>
		<%if(((String)bean.getAction_type()).equals("C")){%>
			<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		<%}%>
		<%
			HashMap hmRecord = new HashMap();
			for(i=0;i<result.size();i++){
				if (i % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				hmRecord = (HashMap)result.get(i);
		%>
				<tr id="tr_<%=i%>">
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="loadExpDetail(<%=i%>);"><font class="HYPERLINK"><%=hmRecord.get("DOC_NO")%></font></td>
			<td class="<%=classvalue%>"><%=com.ehis.util.DateUtils.convertDate((String)hmRecord.get("DOC_DATE"),"DMY","en",locale)%></td> 
					<!--<td class="<%=classvalue%>"><%=hmRecord.get("DOC_DATE")%></td>-->
					<td class="<%=classvalue%>"><%=hmRecord.get("FM_STORE_DESC")%></td>
					<td class="<%=classvalue%>"><%=hmRecord.get("TO_STORE_DESC")%></td>
					<%if(((String)bean.getAction_type()).equals("C")){%>
						<td class="<%=classvalue%>"><input type="checkbox" name="confirm_<%=i%>" id="confirm_<%=i%>" <%=bean.getChecked(bean.checkForNull((String)hmRecord.get("CONFIRM_YN"),"N"))%> onclick="confirmRecord(<%=i%>);"></td>
					<%}%>
				</tr>
				<input type="hidden" name="doc_no_<%=i%>" id="doc_no_<%=i%>" value="<%=hmRecord.get("DOC_NO")%>">
				<input type="hidden" name="seq_no_<%=i%>" id="seq_no_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("SEQ_NO"),"1")%>">
				<input type="hidden" name="fm_store_code_<%=i%>" id="fm_store_code_<%=i%>" value="<%=(String)hmRecord.get("FM_STORE_CODE")%>">
				<input type="hidden" name="to_store_code_<%=i%>" id="to_store_code_<%=i%>" value="<%=(String)hmRecord.get("TO_STORE_CODE")%>">
				<input type="hidden" name="new_saved_<%=i%>" id="new_saved_<%=i%>" value="N"> 
		<%	}
		}
		%>
				<input type="hidden" name="total_records" id="total_records" value="<%=i%>">
		</table>
	<form>
</html>

