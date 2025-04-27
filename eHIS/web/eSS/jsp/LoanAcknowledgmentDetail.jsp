<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Create History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
11/02/2014	       		BRU-HIMS-CRF-225.1	    Sakti Sankar	   11/02/2014	    Sakti Sankar			 Newly Created
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>


<%@ page import=" eSS.LoanAcknowledgementBean,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html> 
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language='javascript' src='../../eSS/js/LoanAcknowledgment.js'></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" >
	<%
		int i = 0;
		String trn_type			=	request.getParameter("trn_type");
		String group_code		=	request.getParameter("group_code");
		String action_type		=	request.getParameter("action_type");
		String mode				=	request.getParameter("mode");
		String table = "";
		String group_code_dynamic = "";
		String final_short_desc = "";
		String Short_desc = "";
		
		String classvalue = "";
		LoanAcknowledgementBean bean	=	(LoanAcknowledgementBean) getBeanObject( "LoanAcknowledgementBean","eSS.LoanAcknowledgementBean",request );
		bean.setLanguageId(locale);
		
		ArrayList alRecords	= new ArrayList();
		HashMap	  hmResult =  new HashMap();

		
	%>
	<form name="formAcknowledgeDetail" id="formAcknowledgeDetail">
	<%
		ArrayList result = (ArrayList)bean.getTFRDtlRecords();
		if(result.size()<=0){
			
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>"); %>
			<script> 
			var formObj = parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader;//Added by Sakti if no record found not to disable header details
			formObj.trn_type.disabled		=	false;
			formObj.fm_store_code.disabled	=	false;
			formObj.to_store_code.disabled	=	false;
			formObj.action_type.disabled	=	false;
			formObj.doc_type_code.disabled	=	false;
			
			</script>
		<%	
		}else{
	%>
		<table border='1' cellpadding='0' cellspacing='0' width=100% align=center>
		<th><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
		<%if(action_type.equals("C")) {%>
		<th><fmt:message key="eSS.SeqNo.label" bundle="${ss_labels}"/></th>
		<%}%>
		<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
		<%if(action_type.equals("A")) {%>
		<th><fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/><input type="checkbox" value="Y" name="selectAll" id="selectAll"   onClick="return toggleCheck(formAcknowledgeDetail);" ></th>
		<%}
			HashMap hmRecord = new HashMap();
			for( i=0;i<result.size();i++){
				if (i % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

				hmRecord = (HashMap)result.get(i);

		%>
				<tr id="tr_<%=i%>">
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="loadExpDetail(<%=i%>);"><font class="HYPERLINK"><%=hmRecord.get("SHORT_DESC")%></font></td>
				<td class="<%=classvalue%>"> <%=hmRecord.get("DOC_NO")%></td>
			<%if(action_type.equals("C")) {%>
				<td class="<%=classvalue%>"> <%=hmRecord.get("SEQ_NO")%></td>
			<%}%>
				<td class="<%=classvalue%>"><%=com.ehis.util.DateUtils.convertDate((String)hmRecord.get("DOC_DATE"),"DMY","en",locale)%></td> 
				<td class="<%=classvalue%>"><%=hmRecord.get("FR_STORE_DESC")%></td>
				<td class="<%=classvalue%>"><%=hmRecord.get("TO_STORE_DESC")%></td>
				
		<%
		 ArrayList alParameters = new ArrayList();

		 group_code = bean.checkForNull(group_code,"%");

		 alParameters.add(bean.getLoginFacilityId());
		 alParameters.add(hmRecord.get("DOC_NO"));
		 alParameters.add(hmRecord.get("DOC_TYPE_CODE"));
		 alParameters.add(locale);
		 alParameters.add(group_code);
		 
		 //Appending group description with ',' if more than one exist in one document logic starts
		 if(trn_type.equals("ISL")){
			 table = "SS_LOAN_ISSUE_DTL";
			 group_code_dynamic = "ISSUE_GROUP_CODE";
		 }else{
			 table = "SS_LOAN_RETURN_DTL";
			 group_code_dynamic = "RETURN_GROUP_CODE";
		 }
		 
		 alRecords = (ArrayList)bean.fetchRecords("SELECT DISTINCT SHORT_DESC  FROM  "+table+"  A,ss_group_lang_vw B WHERE FACILITY_ID = ? AND DOC_NO = ? AND DOC_TYPE_CODE = ?   AND  " +group_code_dynamic+" = GROUP_CODE  AND LANGUAGE_ID=? AND " +group_code_dynamic+" LIKE ?",alParameters);
		  final_short_desc = "";
		  Short_desc = "";
			 for( int j=0; j<alRecords.size();j++){
						hmResult = (HashMap) alRecords.get(j);
						Short_desc = (String)hmResult.get("SHORT_DESC");
						if(alRecords.size()>1){
							final_short_desc =final_short_desc+Short_desc+",";
						}else{
							final_short_desc =Short_desc+",";
						}
				}
			 //Appending group description with ',' logic ends
		%>
			<td class="<%=classvalue%>"><%=ReplaceCommaAtLast(final_short_desc)%></td> <!-- Displaying Group Description-->
			<%if(action_type.equals("A")) {%>
			<td class="<%=classvalue%>" align='center'><div align="center"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" onclick="updateSelection()" value="<%=(String)hmRecord.get("DOC_NO")%>-<%=(String)hmRecord.get("SEQ_NO")%>" ></div></td>
			<%} %>
			
		 
				</tr>
				<input type="hidden" name="doc_no_<%=i%>" id="doc_no_<%=i%>" value="<%=hmRecord.get("DOC_NO")%>">
				<input type="hidden" name="seq_no_<%=i%>" id="seq_no_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("SEQ_NO"),"1")%>">
				<input type="hidden" name="fm_store_code_<%=i%>" id="fm_store_code_<%=i%>" value="<%=(String)hmRecord.get("FM_STORE_CODE")%>">
				<input type="hidden" name="to_store_code_<%=i%>" id="to_store_code_<%=i%>" value="<%=(String)hmRecord.get("TO_STORE_CODE")%>">
				<input type="hidden" name="new_saved_<%=i%>" id="new_saved_<%=i%>" value="N"> 
				<input type="hidden" name="confirm_yn_<%=i%>" id="confirm_yn_<%=i%>" value="<%=(String)hmRecord.get("CONFIRM_YN")%>">
				<input type="hidden" name="confirm_reqd_yn_<%=i%>" id="confirm_reqd_yn_<%=i%>" value="<%=(String)hmRecord.get("CONFIRM_REQD_YN")%>">
				<input type="hidden" name="req_doc_no_<%=i%>" id="req_doc_no_<%=i%>" value="<%=(String)hmRecord.get("REQ_DOC_NO")%>">
				<input type="hidden" name="req_doc_type_code_<%=i%>" id="req_doc_type_code_<%=i%>" value="<%=(String)hmRecord.get("REQ_DOC_TYPE_CODE")%>">
				<input type="hidden" name="doc_type_code_<%=i%>" id="doc_type_code_<%=i%>" value="<%=(String)hmRecord.get("DOC_TYPE_CODE")%>">
				
				
		<%	}

		}
		%>
		<input type="hidden" name="total_records" id="total_records" value="<%=i%>">
		<input type="hidden" name="action_type" id="action_type" value="<%=action_type%>">
		<input type="hidden" name="trn_type" id="trn_type" value="<%=trn_type%>">
		<input type="hidden" name="checkedIndices" id="checkedIndices" >
		<input type="hidden" name="bean_id" id="bean_id"		value="LoanAcknowledgementBean">
		<input type="hidden" name="bean_name" id="bean_name"	value="eSS.LoanAcknowledgementBean">
		<input type="hidden" name="mode" id="mode"		value=<%=mode%>>
				
		</table>
	<form>
	</body>
</html>
<%!
 public static String ReplaceCommaAtLast(String str) {
      if (str == null) {
          return null;
      }
      int strLen = str.length();
      int lastIdx = strLen - 1;
      String ret = str.substring(0, lastIdx);

      return ret;
  }
%>
<script>

</script> 

