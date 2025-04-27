<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eSS.*,java.util.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
		 
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle				 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale				 = 		(String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
		<script language="javascript" src="../../eSS/js/LoanReturnGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()">
	<%
		String bean_id				=		"LoanReturnGroupBean";
		String bean_name			=		"eSS.LoanReturnGroupBean";
		
		LoanReturnGroupBean bean		=		(LoanReturnGroupBean) getBeanObject( bean_id, bean_name,  request ) ;	
		String fr_store_code		=		request.getParameter("fr_store_code");
		String to_store_code		=		request.getParameter("to_store_code");
		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
		String classvalue			=		"";
		String patient_order		=		request.getParameter("patient_order");
		
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			
			HashMap sqlMap					=	new HashMap();
			
			String sql = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRAY_DTLS_RTL_QUERY_RESULT");
			if(patient_order.equals("A")){
				sql = sql+"ORDER BY 1, 3, 4, 5";
			}else if(patient_order.equals("Y")){
				sql = sql+"AND patient_id IS NOT NULL ORDER BY 1, 3, 4, 5";
			}else if(patient_order.equals("N")){
					sql = sql+"AND patient_id IS  NULL ORDER BY 1, 3, 4, 5";
			}
			sqlMap.put("sqlData", sql );

			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			displayFields.add("owner_store_code");
			displayFields.add("bin_location_code");
			displayFields.add("curr_store_code");
			displayFields.add("group_code");
			displayFields.add("tray_no");
			displayFields.add("group_desc");
			displayFields.add("expired_yn");
			displayFields.add("non_returnable_yn");
			displayFields.add("from_store_desc");
			displayFields.add("to_store_desc");
			displayFields.add("bin_desc");
			displayFields.add("sterilize_reqd_yn");
			displayFields.add("wash_reqd_yn");
			displayFields.add("pack_reqd_yn");
			displayFields.add("isl_doc_type_code");
			displayFields.add("isl_doc_no");
			displayFields.add("patient_id");

			ArrayList chkFields		=		new ArrayList();
			chkFields.add(fr_store_code);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);

			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
			ArrayList result		=		(ArrayList) CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,14);
			
			String checked			=		"";
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {
			%>
			<form name="formLoanReturnGroupSelectTrayResult" id="formLoanReturnGroupSelectTrayResult">
			<br>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%>&nbsp;</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<th><fmt:message key="eSS.OwnerStore.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="eSS.CurrentStore.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eSS.IssueDocNo.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.used.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				</tr>		
		<%
			//String disableUse = "";
			String selectUsed,selectUse;
			int index=0, recCount=2;
			ArrayList records=new ArrayList();
			for(index=0, recCount=2; recCount<result.size(); recCount++,index++) {
				//disableUse = "";
				selectUsed = "";
				selectUse ="";
				checked = "";
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr>
		<%
				records = (ArrayList) result.get( recCount );
				String groupCode_trayNo = records.get(3)+"-"+records.get(4);
				if (bean.isAlreadySelected(groupCode_trayNo)) {
					checked = "checked";
				}
				/* This block is commented and added below by Ganga For Used and Unused should be depends upon patient link or not link  BRU-HIMS-CRF-360 39364
				if (((String)records.get(6)).equals("Y")) {
					selectUsed = "selected";
				}

				if (((String)records.get(7)).equals("Y")) {
					disableUse = "disabled";
					selectUse = "selected";
				}
				else {
					selectUse = "";
					selectUsed = "selected";
					disableUse = "disabled";
				}*/

				if(CommonBean.checkForNull((String)records.get(16)).equals("")){
					selectUse = "selected";
				}
				else{
					selectUsed = "selected";
				}

				%>
					<td class="<%=classvalue%>"><%=records.get(8)%></td>
					<td class="<%=classvalue%>"><%=records.get(10)%></td>
					<td class="<%=classvalue%>"><%=records.get(9)%></td>
					<td class="<%=classvalue%>"><%=records.get(5)%></td>
					<td class="<%=classvalue%>" ><%=records.get(4)%></td>
					<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(16),"&nbsp;")%></td>
					<td class="<%=classvalue%>" ><%=records.get(15)%></td>
					<td class="<%=classvalue%>">
						<select name="used_status_<%=index%>" id="used_status_<%=index%>"  >
						<option value="Y" <%=selectUsed%> ><fmt:message key="Common.used.label" bundle="${common_labels}"/></option>
						<option value="N" <%=selectUse%>><fmt:message key="Common.unused.label" bundle="${common_labels}"/></option>
						</select></td>
					<td class="<%=classvalue%>" ><input type="checkbox" name="tray_<%=index%>" id="tray_<%=index%>" <%=checked%>></td>
					<input type="hidden" name="table_index_<%=index%>" id="table_index_<%=index%>"		 value="<%=index%>">
					<input type="hidden" name="group_code_<%=index%>" id="group_code_<%=index%>"		value="<%=records.get(3)%>">
					<input type="hidden" name="group_desc_<%=index%>" id="group_desc_<%=index%>"		value="<%=records.get(5)%>">
					<input type="hidden" name="tray_no_<%=index%>" id="tray_no_<%=index%>"			value="<%=records.get(4)%>">
					<input type="hidden" name="bin_location_code_<%=index%>" id="bin_location_code_<%=index%>" value="<%=records.get(1)%>">
					
					<input type="hidden" name="bin_desc_<%=index%>" id="bin_desc_<%=index%>"				value="<%=records.get(10)%>">
					<input type="hidden" name="expiry_date_<%=index%>" id="expiry_date_<%=index%>"			value="<%=records.get(6)%>">
					<input type="hidden" name="non_returnable_yn_<%=index%>" id="non_returnable_yn_<%=index%>"	value="<%=records.get(7)%>">
					<input type="hidden" name="sterilize_yn_<%=index%>" id="sterilize_yn_<%=index%>"			value="<%=CommonBean.checkForNull((String)records.get(11),"N")%>">
					<input type="hidden" name="wash_yn_<%=index%>" id="wash_yn_<%=index%>"				value="<%=CommonBean.checkForNull((String)records.get(12),"N")%>">
					<input type="hidden" name="pack_yn_<%=index%>" id="pack_yn_<%=index%>"				value="<%=CommonBean.checkForNull((String)records.get(13),"N")%>">
					<input type="hidden" name="iss_doc_type_code_<%=index%>" id="iss_doc_type_code_<%=index%>"	value="<%=CommonBean.checkForNull((String)records.get(14),"")%>">
					<input type="hidden" name="iss_doc_no_<%=index%>" id="iss_doc_no_<%=index%>"			value="<%=CommonBean.checkForNull((String)records.get(15),"")%>">
					<input type="hidden" name="patient_id_<%=index%>" id="patient_id_<%=index%>"			value="<%=CommonBean.checkForNull((String)records.get(16),"")%>">
				</tr>
		<%
			}
		%>
		</table>
		<br>
		<div align='right'>
		<input type="button" value="Close" name="cmdClose" id="cmdClose" class="BUTTON" onClick="closeActionPerformed(this);">&nbsp;&nbsp;
		</div>
		<input type="hidden" name="chkdIndices" id="chkdIndices"			value="" %>
		<input type="hidden" name="total_trays" id="total_trays"			value="<%=index%>">
		<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
		<input type="hidden" name="unchkdIndices" id="unchkdIndices"		value="" >
		</form>	
		<%
			out.flush();
		}
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				window.close();
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/LoanReturnGroupSelectTrayResult.jsp", searched) );
	}
	catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}
%>
	<%
putObjectInBean(bean_id,bean,request); 
%>

</body>
</html>

