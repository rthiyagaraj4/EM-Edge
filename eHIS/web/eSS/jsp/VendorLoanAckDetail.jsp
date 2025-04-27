<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.VendorLoanAckBean,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8"%> 
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
		<script language='javascript' src='../../eSS/js/VendorLoanAck.js'></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" >
	<%
		int i = 0;
		String group_code		=	request.getParameter("group_code");
		String mode				=	request.getParameter("mode");
		String table = "";
		String group_code_dynamic = "";
		StringBuffer final_short_desc = null;
		StringBuffer groupCodes = null;
		String Short_desc = "";
		String bin_locn_code					=		"";
		String classvalue = "";
		VendorLoanAckBean bean	=	(VendorLoanAckBean) getBeanObject( "VendorLoanAckBean","eSS.VendorLoanAckBean",request );
		bean.setLanguageId(locale);
		
		ArrayList alRecords	= new ArrayList();
		HashMap	  hmResult =  new HashMap();

		
	%>
	<form name="formAcknowledgeDetail" id="formAcknowledgeDetail">
	<%
		ArrayList result = (ArrayList)bean.getTFRDtlRecords();
		if(result.size()<=0){
			
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>"); %>
			<script> 
			var formObj = parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader;
			formObj.fm_vendor_code.disabled	=	false;
			formObj.to_store_code.disabled	=	false;
			formObj.doc_type_code.disabled	=	false;
			
			</script>
		<%	
		}else{
	%>
		<table border='1' cellpadding='0' cellspacing='0' width=100% align=center>
		<tr>
		<th><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSS.FromVendor.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></th>
		<th width="15%"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/><input type="checkbox" value="Y" name="selectAll" id="selectAll"   onClick="return toggleCheck(formAcknowledgeDetail);" ></th>
		<th><fmt:message key="Common.BinLocation.label" bundle="${mm_labels}"/></th>
		<th></th>
		</tr>
		<%	HashMap hmRecord = new HashMap();
			for( i=0;i<result.size();i++){
				if (i % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

				hmRecord = (HashMap)result.get(i);

		%>
				<tr id="tr_<%=i%>">
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="loadExpDetail(<%=i%>);"><font class="HYPERLINK"><%=hmRecord.get("SHORT_DESC")%></font></td>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="loadExpDetail(<%=i%>);"><font class="HYPERLINK"> <%=hmRecord.get("DOC_NO")%></font></td>
				<td class="<%=classvalue%>"><%=com.ehis.util.DateUtils.convertDate((String)hmRecord.get("DOC_DATE"),"DMY","en",locale)%></td> 
				<td class="<%=classvalue%>"><%=hmRecord.get("REQ_TO_SUPP_DESC")%></td>
				<td class="<%=classvalue%>"><%=hmRecord.get("REQ_BY_STORE_DESC")%></td>
				
		<%
		 ArrayList alParameters = new ArrayList();

		 group_code = bean.checkForNull(group_code,"%");

		 alParameters.add(bean.getLoginFacilityId());
		 alParameters.add(hmRecord.get("DOC_NO"));
		 alParameters.add(hmRecord.get("DOC_TYPE_CODE"));
		 alParameters.add(locale);
		 alParameters.add(group_code);
		 
		 alRecords = (ArrayList)bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_VENDOR_LOAN_ACK_REQ_GRP_SELECT"),alParameters);
		 final_short_desc = new StringBuffer();
		 groupCodes = new StringBuffer();
		 Short_desc = "";
			 for( int j=0; j<alRecords.size();j++){
						hmResult = (HashMap) alRecords.get(j);
						Short_desc = (String)hmResult.get("SHORT_DESC");
						if(j==0){
							final_short_desc.append(Short_desc);
							groupCodes.append((String)hmResult.get("GROUP_CODE"));
						}
						else{
							final_short_desc.append(","+Short_desc);
							groupCodes.append(","+(String)hmResult.get("GROUP_CODE"));
						}
				}
		%>
			<td class="<%=classvalue%>"><%=final_short_desc.toString()%></td>
			<td class="<%=classvalue%>" align='center'><div align="center"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" onclick="updateSelection('<%=i%>')" value="<%=(String)hmRecord.get("DOC_NO")%>" ></div></td>
			<td class="<%=classvalue%>" nowrap ><center><select name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" onChange="" onkeydown="return isNumberKey(event);" > <%=bean.getBinLocation((String)hmRecord.get("REQ_BY_STORE_CODE"))%> </select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></IMG></center></td>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showRemarks('<%=i%>','Detail');"><font class="HYPERLINK"><fmt:message key="eSS.Remarks.label" bundle="${ss_labels}"/></font></td>
			
		 
				</tr>
				<input type="hidden" name="doc_no_<%=i%>" id="doc_no_<%=i%>" value="<%=hmRecord.get("DOC_NO")%>">
				<input type="hidden" name="groupCodes_<%=i%>" id="groupCodes_<%=i%>" value="<%=groupCodes.toString()%>">
				<input type="hidden" name="fm_vendor_code_<%=i%>" id="fm_vendor_code_<%=i%>" value="<%=(String)hmRecord.get("REQ_TO_SUPP_CODE")%>">
				<input type="hidden" name="to_store_code_<%=i%>" id="to_store_code_<%=i%>" value="<%=(String)hmRecord.get("REQ_BY_STORE_CODE")%>">
				<input type="hidden" name="new_saved_<%=i%>" id="new_saved_<%=i%>" value="N"> 
				<input type="hidden" name="doc_type_code_<%=i%>" id="doc_type_code_<%=i%>" value="<%=(String)hmRecord.get("DOC_TYPE_CODE")%>">
		 		<input type="hidden" name="bin_location_code<%=i%>" id="bin_location_code<%=i%>" 			value="<%=bean.checkForNull((String)hmRecord.get("BIN_LOCATION_CODE"))%>"/> 
				<input type="hidden" name="remarks_<%=i%>" id="remarks_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("REMARKS"))%>">
				
				
		<%	}

		}
		%>
		<input type="hidden" name="total_records" id="total_records" value="<%=i%>">
		<input type="hidden" name="checkedIndices" id="checkedIndices" >
		<input type="hidden" name="bean_id" id="bean_id"		value="VendorLoanAckBean">
		<input type="hidden" name="bean_name" id="bean_name"	value="eSS.VendorLoanAckBean">
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

