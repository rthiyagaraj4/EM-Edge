<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*,java.sql.*" contentType="text/html;charset=UTF-8"%>  
<jsp:useBean id="alIssueGroupList" scope="session" class="java.util.ArrayList"/>
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
		<script language="javascript" src="../../eSS/js/IssueGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<body onMouseDown="CodeArrest();" >
<form name='formIssueGroupList' id='formIssueGroupList' >
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
		<tr>
			<th width='25'><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.RequestGroup.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.AuthorizedGroup.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.IssueGroup.label" bundle="${ss_labels}"/></th>	
			<th ><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSS.IssueCost.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>   
			<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			 
		</tr>
<%     
	IssueGroupListBean bean		 =		(IssueGroupListBean)getBeanObject( "issueGroupListBean",  "eSS.IssueGroupListBean" ,request) ; 
	IssueGroupBean bean1      	 =		(IssueGroupBean)getBeanObject( "issueGroupBean",  "eSS.IssueGroupBean" ,request) ;
	
	
	bean.setLanguageId(locale) ;
	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));
	//bean1.setSession(session) ;
		 
	HashMap hmRecord			=		new HashMap();
	String className			=		"";
	String disabled				=		"";
	int i;
	String mode					=		request.getParameter( "mode" ) ; 
	String index				=		bean.checkForNull(request.getParameter( "index" ),"") ;
	String fr_store_code		=		request.getParameter( "fr_store_code" ) ; 
	String to_store_code		=		request.getParameter( "to_store_code" ) ; 
	String req_doc_type_code	=		request.getParameter( "req_doc_type_code" ) ;
	String req_doc_no			=		request.getParameter( "req_doc_no" ) ;
	String Re_Issue				=		request.getParameter( "Re_Issue" ) ;
	String modify				=		"";
	String new_mode				=		"";
	
	alIssueGroupList = bean1.getSelectedList();
	session.putValue("alIssueGroupList",alIssueGroupList);

	for	(i	=0;	i<alIssueGroupList.size();i++) {
		hmRecord	=(HashMap)	alIssueGroupList.get(i);

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
		new_mode 		= (String)hmRecord.get("mode");
		if( new_mode == null ){
			disabled			=		"disabled checked";
			className			=		((i%2)==0)?"QRYODD":"QRYEVEN"; 
			modify = "reissue";
		}
		else if( new_mode .equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )){
			disabled			=		"";
			className			=		((i%2)==0)?"QRYODD":"QRYEVEN"; 
			modify ="";
		}else{
			disabled			=		"disabled checked";
			className			=		((i%2)==0)?"QRYODD":"QRYEVEN"; 
			modify = "reissue";
		}
	}
		
%>
	<tr>
		 <td width='30'  class="<%=className%>" ><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%> onkeydown="return isNumberKey(event);"></td>
		<!--<% if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) {	%>
		<td width='200' class="<%=className%>"><a href="javascript:listModify(<%=i%>);"><%=bean.getReq_group_desc()%></a></td>
		<%}else if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && hmRecord.get("mode")==null) {%>
		<td width='125' class="<%=className%>"><%=bean.getReq_group_desc()%></td>  
		<%}else if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && hmRecord.get("mode")=="1" ) {%>
		<td width='125' class="<%=className%>"><a href="javascript:listModify(<%=i%>);"><%=bean.getReq_group_desc()%></a></td>
		<%}%>
		<td width='125' class="<%=className%>"><%=bean.getIssue_group_desc()%></td> -->
		
		<td  class="<%=className%>"><%=bean.getReq_group_desc()%></td>  
		
		<td class="<%=className%>"><%=bean.getAuth_group_desc()%></td>
		<td class="<%=className%>" >&nbsp;<select style="width:100px" name="issue_group_code_<%=i%>" id="issue_group_code_<%=i%>"  onChange="clearTrayDetails('<%=i%>'); ChangeIssueGroup('<%=i%>','<%=fr_store_code %>');" <%=disabled%> onkeydown="return isNumberKey(event);">	<%=bean.getIssue_group_code_List(fr_store_code,to_store_code,bean.getAuth_group_code())%></select><%=bean.getMandatoryImageTag()%> <input type="hidden" name="issue_group_desc_<%=i%>" id="issue_group_desc_<%=i%>" value="" /></td>
		<%if(modify.equals("reissue")) { %>
		<td class="<%=className%>" nowrap ><center><select style="width:110px" name="tray_no_<%=i%>" id="tray_no_<%=i%>"  onBlur="" onChange="" value="<%=bean.getTray_no()%>"  <%=disabled%> onkeydown="return isNumberKey(event);"> <option><%=bean.getTray_no()%> </option> </select><%=bean.getMandatoryImageTag()%></center></td>
		<%}else{ %>
		<td class="<%=className%>" nowrap ><center><select style="width:110px" name="tray_no_<%=i%>" id="tray_no_<%=i%>"  onBlur="validateTrayno('<%=i%>');" onChange="RemoveTrayno('<%=i%>','<%=fr_store_code %>')" value="<%=bean.getTray_no()%>" onkeydown="return isNumberKey(event);"><%=bean1.getTrayNo(bean.getAuth_group_code(),fr_store_code,bean.getTray_no())%>  </select><%=bean.getMandatoryImageTag()%></center></td>
		<%} %>
		<td  class="<%=className%>" >&nbsp;<input type='text' name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=bean.getBin_location_desc()%>" maxLength="15" size="15" onkeydown="return isNumberKey(event);" readonly ></td>
		<td class="<%=className%>">&nbsp;<input type='text' name="expiry_date_<%=i%>" id="expiry_date_<%=i%>" value="<%=com.ehis.util.DateUtils.convertDate(bean.getExpiry_date(),"DMY","en",locale)%>" maxLength="10" size="10" onkeydown="return isNumberKey(event);" readonly></td>
		<td class="<%=className%>">&nbsp;<input type='text' name="issue_cost_<%=i%>" id="issue_cost_<%=i%>" value="<%=bean.getIssue_cost()%>" maxLength="16" size="16" onkeydown="return isNumberKey(event);" readonly class="NUMBER"></td>
		<td class="<%=className%>">&nbsp;<input type='text' name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=bean.getPatient_id()%>" maxLength='20' size='16' onBlur="searchPatientName('<%=i%>')" <%=disabled%>><input type='button' class='BUTTON' value='?' onClick="searchPatient('<%=i%>');" name="patient_search_<%=i%>" <%=disabled%>></td>
		<td class="<%=className%>">&nbsp;<input type='text' name="patient_name_<%=i%>" id="patient_name_<%=i%>" value="<%=bean.checkForNull(bean.getPatient_name(),"")%>" maxLength="20" size="20" onkeydown="return isNumberKey(event);" readonly></td>
    
	</tr>
	<input type="hidden" name="req_group_code_<%=i%>" id="req_group_code_<%=i%>" 		value="<%=bean.getReq_group_code()%>">
	<input type="hidden" name="req_group_desc_<%=i%>" id="req_group_desc_<%=i%>" 		value="<%=bean.getReq_group_desc()%>">
	<input type="hidden" name="auth_group_desc_<%=i%>" id="auth_group_desc_<%=i%>" 	value="<%=bean.getAuth_group_desc()%>">
	<input type="hidden" name="auth_group_code_<%=i%>" id="auth_group_code_<%=i%>" 	value="<%=bean.getAuth_group_code()%>">
	<input type=hidden name="new_mode<%=i%>" id="new_mode<%=i%>"				value="<%=new_mode%>"/>
	<input type=hidden name="tray_num_<%=i%>" id="tray_num_<%=i%>"				value="<%=bean.getTray_no()%>"/>
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
	<input type="hidden" name="bean_id" id="bean_id"					value="issueGroupBean"/>
	<input type="hidden" name="bean_name" id="bean_name" 				value="eSS.IssueGroupBean"/>
	
</form>
</body>

</html>
<%
	
putObjectInBean( "issueGroupBean",  bean1,request);
%>
<script>
	formObj = document.formIssueGroupList
	var total_rec =formObj.total_checkboxes.value;
	
	for(var i =0 ;i<total_rec;i++){ 
				
		var issue_group = eval("document.formIssueGroupList.issue_group_code_"+i);
		var selIndex = issue_group.selectedIndex;
		issue_group.selectedIndex = selIndex ;
			if(issue_group.options.length == 2) {
				issue_group.disabled = true;
			}else{
				issue_group.disabled = false;
			}
	}
	
</script>

