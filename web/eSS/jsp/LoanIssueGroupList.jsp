<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*,java.sql.*" contentType="text/html;charset=UTF-8"%>  
<jsp:useBean id="alLoanIssueGroupList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">  
<%
			request.setCharacterEncoding("UTF-8");
			String locale					=		(String)session.getAttribute("LOCALE");
			String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/LoanIssueGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<body onMouseDown="CodeArrest();" >
<form name='formLoanIssueGroupList' id='formLoanIssueGroupList' >
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
		<tr>
			<th width='30'><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.ReqGroup.label" bundle="${ss_labels}"/></th>
			<th width='150'><fmt:message key="eSS.AuthGroup.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.IssueGroup.label" bundle="${ss_labels}"/></th>	
			<th ><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSS.IssueCost.label" bundle="${ss_labels}"/></th>
			<th width='95'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>   
			<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			 
		</tr>
<%     
	LoanIssueGroupListBean bean		 =		(LoanIssueGroupListBean)getBeanObject( "LoanIssueGroupListBean",  "eSS.LoanIssueGroupListBean" ,request) ; 
	LoanIssueGroupBean bean1      	 =		(LoanIssueGroupBean)getBeanObject( "LoanIssueGroupBean",  "eSS.LoanIssueGroupBean" ,request) ;
	
	bean.setLanguageId(locale) ;
	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));
	bean1.setSession(session) ;
		 
	HashMap hmRecord			=		new HashMap();
	String className			=		"";
	String disabled				=		"";
	int i;
	String mode								=		request.getParameter( "mode" ) ; 
	String index							=		bean.checkForNull(request.getParameter( "index" ),"") ;
	String fr_store_code					=		request.getParameter( "fr_store_code" ) ; 
	String to_store_code					=		request.getParameter( "to_store_code" ) ; 
	String req_doc_type_code				=		request.getParameter( "req_doc_type_code" ) ;
	String req_doc_no						=		request.getParameter( "req_doc_no" ) ;

	for	(i	=0;	i<alLoanIssueGroupList.size();i++) {
		hmRecord	=(HashMap)	alLoanIssueGroupList.get(i);

		bean.initialize(hmRecord); 
		if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )  ){
		/*if(bean.getTray_no().equals("")){
			//if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && index.equals("") ){
			disabled			=		"disabled checked";
			className			=		((i%2)==0)?"QRYODD":"QRYEVEN";
		}*/
		//else
			disabled			=		"";
			className			=		((i%2)==0)?"QRYODD":"QRYEVEN"; 
		//}
	}else if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )  ){
				if( hmRecord.get("mode")==null ){
			disabled			=		"disabled checked";
			className			=		((i%2)==0)?"QRYODD":"QRYEVEN"; 
		}
		else{
			disabled			=		"";
			className			=		((i%2)==0)?"QRYODD":"QRYEVEN"; 
		}
	}		
%>
	<tr>
		 <td width='30'  class="<%=className%>" ><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%> ></td>
		<!--<% if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) {	%>
		<td width='200' class="<%=className%>"><a href="javascript:listModify(<%=i%>);"><%=bean.getReq_group_desc()%></a></td>
		<%}else if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && hmRecord.get("mode")==null) {%>
		<td width='125' class="<%=className%>"><%=bean.getReq_group_desc()%></td>  
		<%}else if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && hmRecord.get("mode")=="1" ) {%>
		<td width='125' class="<%=className%>"><a href="javascript:listModify(<%=i%>);"><%=bean.getReq_group_desc()%></a></td>
		<%}%>
		<td width='125' class="<%=className%>"><%=bean.getIssue_group_desc()%></td> -->
		
		<td width='125' class="<%=className%>"><%=bean.getReq_group_desc()%></td>  
		
		<td width='200' class="<%=className%>"><%=bean.getAuth_group_desc()%></td>
		<td>&nbsp;<select name="issue_group_code_<%=i%>" id="issue_group_code_<%=i%>"  onChange="ChangeIssueGroup('<%=i%>','<%=fr_store_code %>')" >	<%=bean.getIssue_group_code_List(fr_store_code,to_store_code,bean.getAuth_group_code())%></select><%=bean.getMandatoryImageTag()%> <input type="hidden" name="issue_group_desc_<%=i%>" id="issue_group_desc_<%=i%>" value="" /></td>
		
		<td class="<%=className%>" nowrap ><center><select style="width=110px" name="tray_no_<%=i%>" id="tray_no_<%=i%>" onChange="RemoveTrayno('<%=i%>','<%=fr_store_code %>')" onBlur="searchTrayDetail('<%=i%>','<%=fr_store_code %>');" value="<%=bean.getTray_no()%>" onkeydown=""><%=bean1.getTrayNo(bean.getAuth_group_code(),fr_store_code,bean.getTray_no())%>  </select><%=bean.getMandatoryImageTag()%></center></td>
		<td class="<%=className%>">&nbsp;<input type='text' name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=bean.getBin_location_desc()%>" maxLength="15" size="15" readonly></td>
		<td class="<%=className%>">&nbsp;<input type='text' name="expiry_date_<%=i%>" id="expiry_date_<%=i%>" value="<%=com.ehis.util.DateUtils.convertDate(bean.getExpiry_date(),"DMY","en",locale)%>" maxLength="10" size="10" readonly></td>
		<td class="<%=className%>">&nbsp;<input type='text' name="issue_cost_<%=i%>" id="issue_cost_<%=i%>" value="<%=bean.getIssue_cost()%>" maxLength="16" size="16" readonly class="NUMBER"></td>
		<td class="<%=className%>">&nbsp;<input type='text' name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=bean.getPatient_id()%>" maxLength='20' size='20' onBlur="searchPatientName('<%=i%>')" ><input type='button' class='BUTTON' value='?' onClick="searchPatient('<%=i%>');" name="patient_search_<%=i%>" ></td>
		<td class="<%=className%>">&nbsp;<input type='text' name="patient_name_<%=i%>" id="patient_name_<%=i%>" value="<%=bean.getPatient_name()%>" maxLength="20" size="20" readonly></td>
		<!-- <td width='80'  class="<%=className%>" ><%=bean.checkForNull(bean.getTray_no(),"&nbsp;")%></td> 
		<td width='95'  class="<%=className%>"><%=bean.checkForNull(bean.getPatient_id(),"&nbsp;")%></td> -->    
	</tr>
	<input type="hidden" name="req_group_code_<%=i%>" id="req_group_code_<%=i%>" 		value="<%=bean.getReq_group_code()%>">
	<input type="hidden" name="req_group_desc_<%=i%>" id="req_group_desc_<%=i%>" 		value="<%=bean.getReq_group_desc()%>">
	<input type="hidden" name="auth_group_desc_<%=i%>" id="auth_group_desc_<%=i%>" 	value="<%=bean.getAuth_group_desc()%>">
	<input type="hidden" name="auth_group_code_<%=i%>" id="auth_group_code_<%=i%>" 	value="<%=bean.getAuth_group_code()%>">
<%
}
%>
	
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" 		value="<%=i%>">
	<input type="hidden" name="function_id" id="function_id" 			value="<%=request.getParameter("function_id")%>">
	<input type="hidden" name="mode" id="mode" 					value="<%=request.getParameter("mode")%>">
	<input type="hidden" name="locale" id="locale" 					value="<%=locale%>">
	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="req_doc_type_code" id="req_doc_type_code"		value="">
	<input type="hidden" name="fr_store_code" id="fr_store_code"			value="">
	<input type="hidden" name="req_doc_no" id="req_doc_no"				value="">
	<input type="hidden" name="doc_ref" id="doc_ref"					value="">
	<input type="hidden" name="doc_type_code" id="doc_type_code"			value="">
	<input type="hidden" name="doc_no" id="doc_no"					value="">
	<input type="hidden" name="doc_date" id="doc_date"				value="">
	<input type="hidden" name="entry_completed_yn" id="entry_completed_yn"		value="">
	<input type="hidden" name="to_store_code" id="to_store_code"			value="">
	<input type=hidden name=bean_id 					value="LoanIssueGroupBean"/>
	<input type=hidden name=bean_name 					value="eSS.LoanIssueGroupBean"/>
	
</form>
</body>

</html>
<%	
putObjectInBean( "LoanIssueGroupBean",  bean1,request);
%>
<script>
	formObj = document.formLoanIssueGroupList;	
	var total_rec =formObj.total_checkboxes.value;	
	for(var i =0 ;i<total_rec;i++){		
		var issue_group = eval("document.formLoanIssueGroupList.issue_group_code_"+i);		
		var selIndex = issue_group.selectedIndex;
		issue_group.selectedIndex = selIndex ;
		if(issue_group.options.length == 2) {
			issue_group.disabled = true;
		}else{
			issue_group.disabled = false;
		}		
	}
</script>

