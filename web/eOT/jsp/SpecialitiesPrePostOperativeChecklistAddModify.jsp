<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<% 
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

<html>
<head>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language='javascript' src='../../eOT/js/Specialities.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
//out.println("<script>alert()</script>");
Connection con=null;
PreparedStatement stmt=null;
PreparedStatement icd_stmt=null;
ResultSet rs=null;
ResultSet icd_rs=null;
String mode=request.getParameter("mode");

String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter( "speciality_code" );
String chk_checked="checked";
String chk_checked1="";
String chk_value1="";
String chk_value="E";
String disable_flag="";
String speciality_code_disable="";
String diag_code_scheme="";
String speciality_desc="";
String chart_id="";
String chart_desc="";
String pre_op_checklist="";
String pre_op_checklist_desc="";
String pre_op_no_of_verifications="";
String pre_op_verify1_user_role="";
String pre_op_verify1_user_role_desc="";
String pre_op_verify2_user_role="";
String pre_op_verify2_user_role_desc="";
String pre_op_verify3_user_role="";
String pre_op_verify3_user_role_desc="";
String pre_op_verify4_user_role="";
String pre_op_verify4_user_role_desc="";
String post_op_checklist="";
String post_op_checklist_desc="";
String post_op_no_of_verifications="";
String post_op_verify1_user_role="";
String post_op_verify1_user_role_desc="";
String post_op_verify2_user_role="";
String post_op_verify2_user_role_desc="";
String post_op_verify3_user_role="";
String post_op_verify3_user_role_desc="";
String post_op_verify4_user_role="";
String post_op_verify4_user_role_desc="";
String swab_instr_tmpl_id="";
String swab_instr_tmpl_desc="";
String med_ser_grp_code="";
String med_ser_grp_desc="";
String anaesthesia_review_reqd_yn="";
String status="";
String sql="";
String pre_op_verify1_disable="";
String pre_op_verify2_disable="";
String pre_op_verify3_disable="";
String pre_op_verify4_disable="";
String post_op_verify1_disable="";
String post_op_verify2_disable="";
String post_op_verify3_disable="";
String post_op_verify4_disable="";
String pre_op_no_of_verifications_disable="";
String post_op_no_of_verifications_disable="";
String ca_module_yn="";
String mr_term_code="";
String mr_term_desc="";
ca_module_yn=request.getParameter("ca_module_yn");
//ca_module_yn="N"; // For testing purpose
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		if (ca_module_yn.equals("Y")) {
			//Maheshwaran K modified the query for the incident no :38452 as on 14/03/2013
			sql="select A.SPECIALITY_CODE,GET_DESC(?,'AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',B.SPECIALITY_CODE) LONG_DESC, A.DISCR_MSR_ID, GET_DESC(?,'CA_CHART_LANG_VW','SHORT_DESC','CHART_ID',C.CHART_ID) SHORT_DESC, A.PRE_OP_CHECK_LIST, GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',D.CHECKLIST_CODE) PRE_DESCRIPTION, A.PRE_OP_NO_OF_VERIFICATIONS,A.PRE_OP_VERIFY1_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',E.ROLE_ID) PRE_ROLE_DESC1, A.PRE_OP_VERIFY2_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',F.ROLE_ID) PRE_ROLE_DESC2, A.PRE_OP_VERIFY3_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',G.ROLE_ID) PRE_ROLE_DESC3, A.PRE_OP_VERIFY4_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',H.ROLE_ID) PRE_ROLE_DESC4, A.POST_OP_CHECK_LIST, GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',N.CHECKLIST_CODE) POST_DESCRIPTION, A.POST_OP_NO_OF_VERIFICATIONS,A.POST_OP_VERIFY1_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',I.ROLE_ID) POST_ROLE_DESC1, A.POST_OP_VERIFY2_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',J.ROLE_ID) POST_ROLE_DESC2, A.POST_OP_VERIFY3_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',K.ROLE_ID) POST_ROLE_DESC3, A.POST_OP_VERIFY4_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',L.ROLE_ID) POST_ROLE_DESC4, A.SWAB_INSTR_TMPL_ID, GET_DESC(?,'OT_SWAB_INSTR_TMPL_HDR_LANG_VW','DESCRIPTION','TEMPLATE_ID',M.TEMPLATE_ID) TEMP_DESCRIPTION, nvl(A.ANAESTHESIA_REVIEW_REQD_YN,'N') ANAESTHESIA_REVIEW_REQD_YN,nvl(A.STATUS,'E') STATUS,A.MED_SER_GRP_CODE, GET_DESC(?,'IP_MEDICAL_SERVICE_GRP_LANG_VW','SHORT_DESC','MED_SER_GRP_CODE',A.MED_SER_GRP_CODE) MED_SERVICE,A.DIAG_CODE_SCHEME FROM OT_SPECIALITIES A,AM_SPECIALITY B,CA_CHART C,OT_CHECKLIST_HDR D,OT_CHECKLIST_HDR N,OT_ROLES E,OT_ROLES F,OT_ROLES G,OT_ROLES H,OT_ROLES I,OT_ROLES J,OT_ROLES K,OT_ROLES L,OT_SWAB_INSTR_TMPL_HDR M where A.SPECIALITY_CODE=? AND A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.DISCR_MSR_ID=C.CHART_ID(+) AND A.PRE_OP_CHECK_LIST=D.CHECKLIST_CODE(+) AND A.PRE_OP_VERIFY1_USER_ROLE=E.ROLE_ID(+) AND A.PRE_OP_VERIFY2_USER_ROLE=F.ROLE_ID(+)  AND A.PRE_OP_VERIFY3_USER_ROLE=G.ROLE_ID(+)  AND A.PRE_OP_VERIFY4_USER_ROLE=H.ROLE_ID(+)  AND A.POST_OP_CHECK_LIST=N.CHECKLIST_CODE(+) AND A.POST_OP_VERIFY1_USER_ROLE=I.ROLE_ID(+)  AND A.POST_OP_VERIFY2_USER_ROLE=J.ROLE_ID(+)  AND A.POST_OP_VERIFY3_USER_ROLE=K.ROLE_ID(+)  AND A.POST_OP_VERIFY4_USER_ROLE=L.ROLE_ID(+)  AND A.SWAB_INSTR_TMPL_ID=M.TEMPLATE_ID(+) ORDER BY A.SPECIALITY_CODE";
			}else{
		//Maheshwaran K modified the query for the incident no :38452 as on 14/03/2013
			sql="select A.SPECIALITY_CODE,GET_DESC(?,'AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',B.SPECIALITY_CODE) LONG_DESC, A.DISCR_MSR_ID,NULL SHORT_DESC,A.PRE_OP_CHECK_LIST, GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',D.CHECKLIST_CODE) PRE_DESCRIPTION, A.PRE_OP_NO_OF_VERIFICATIONS, A.PRE_OP_VERIFY1_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',E.ROLE_ID) PRE_ROLE_DESC1, A.PRE_OP_VERIFY2_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',F.ROLE_ID) PRE_ROLE_DESC2, A.PRE_OP_VERIFY3_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',G.ROLE_ID) PRE_ROLE_DESC3, A.PRE_OP_VERIFY4_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',H.ROLE_ID) PRE_ROLE_DESC4, A.POST_OP_CHECK_LIST, GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',N.CHECKLIST_CODE) POST_DESCRIPTION, A.POST_OP_NO_OF_VERIFICATIONS,A.POST_OP_VERIFY1_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',I.ROLE_ID) POST_ROLE_DESC1, A.POST_OP_VERIFY2_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',J.ROLE_ID) POST_ROLE_DESC2, A.POST_OP_VERIFY3_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',K.ROLE_ID) POST_ROLE_DESC3, A.POST_OP_VERIFY4_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',L.ROLE_ID) POST_ROLE_DESC4, A.SWAB_INSTR_TMPL_ID, GET_DESC(?,'OT_SWAB_INSTR_TMPL_HDR_LANG_VW','DESCRIPTION','TEMPLATE_ID',M.TEMPLATE_ID) TEMP_DESCRIPTION, nvl(A.ANAESTHESIA_REVIEW_REQD_YN,'N') ANAESTHESIA_REVIEW_REQD_YN,nvl(A.STATUS,'E') STATUS, A.MED_SER_GRP_CODE, GET_DESC(?,'IP_MEDICAL_SERVICE_GRP_LANG_VW','SHORT_DESC','MED_SER_GRP_CODE',MED_SER_GRP_CODE) MED_SERVICE,A.DIAG_CODE_SCHEME FROM OT_SPECIALITIES  A,AM_SPECIALITY B,OT_CHECKLIST_HDR D,OT_CHECKLIST_HDR N,OT_ROLES E,OT_ROLES F,OT_ROLES G,OT_ROLES H,OT_ROLES I,OT_ROLES J,OT_ROLES K,OT_ROLES L,OT_SWAB_INSTR_TMPL_HDR M where A.SPECIALITY_CODE=? AND A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.PRE_OP_CHECK_LIST=D.CHECKLIST_CODE(+) AND A.PRE_OP_VERIFY1_USER_ROLE=E.ROLE_ID(+) AND A.PRE_OP_VERIFY2_USER_ROLE=F.ROLE_ID(+)  AND A.PRE_OP_VERIFY3_USER_ROLE=G.ROLE_ID(+)  AND A.PRE_OP_VERIFY4_USER_ROLE=H.ROLE_ID(+)  AND A.POST_OP_CHECK_LIST=N.CHECKLIST_CODE(+) AND A.POST_OP_VERIFY1_USER_ROLE=I.ROLE_ID(+)  AND A.POST_OP_VERIFY2_USER_ROLE=J.ROLE_ID(+)  AND A.POST_OP_VERIFY3_USER_ROLE=K.ROLE_ID(+)  AND A.POST_OP_VERIFY4_USER_ROLE=L.ROLE_ID(+)  AND A.SWAB_INSTR_TMPL_ID=M.TEMPLATE_ID(+) ORDER BY A.SPECIALITY_CODE";
					}
		stmt=con.prepareStatement(sql);
			stmt.setString(1,locale);
			stmt.setString(2,locale);
			stmt.setString(3,locale);
			stmt.setString(4,locale);
			stmt.setString(5,locale);
			stmt.setString(6,locale);
			stmt.setString(7,locale);
			stmt.setString(8,locale);
			stmt.setString(9,locale);
			stmt.setString(10,locale);
			stmt.setString(11,locale);
			stmt.setString(12,locale);
			stmt.setString(13,locale);
		if (ca_module_yn.equals("Y")) {
			stmt.setString(14,locale);
			stmt.setString(15,speciality_code);
		}else{
			stmt.setString(14,speciality_code);
		}

		rs=stmt.executeQuery();
		while(rs.next()){
			speciality_code=checkForNull(rs.getString(1));
			speciality_desc=checkForNull(rs.getString(2));
			chart_id=checkForNull(rs.getString(3));
			chart_desc=checkForNull(rs.getString(4));
			pre_op_checklist=checkForNull(rs.getString(5));
			pre_op_checklist_desc=checkForNull(rs.getString(6));
			pre_op_no_of_verifications=checkForNull(rs.getString(7));
			pre_op_verify1_user_role=checkForNull(rs.getString(8));
			pre_op_verify1_user_role_desc=checkForNull(rs.getString(9));
			pre_op_verify2_user_role=checkForNull(rs.getString(10));
			pre_op_verify2_user_role_desc=checkForNull(rs.getString(11));
			pre_op_verify3_user_role=checkForNull(rs.getString(12));
			pre_op_verify3_user_role_desc=checkForNull(rs.getString(13));
			pre_op_verify4_user_role=checkForNull(rs.getString(14));	
			pre_op_verify4_user_role_desc=checkForNull(rs.getString(15));
			post_op_checklist=checkForNull(rs.getString(16));
			post_op_checklist_desc=checkForNull(rs.getString(17));
			post_op_no_of_verifications=checkForNull(rs.getString(18));
			post_op_verify1_user_role=checkForNull(rs.getString(19));
			post_op_verify1_user_role_desc=checkForNull(rs.getString(20));
			post_op_verify2_user_role=checkForNull(rs.getString(21));
     		post_op_verify2_user_role_desc=checkForNull(rs.getString(22));
			post_op_verify3_user_role=checkForNull(rs.getString(23));
			post_op_verify3_user_role_desc=checkForNull(rs.getString(24));
			post_op_verify4_user_role=checkForNull(rs.getString(25));
			post_op_verify4_user_role_desc=checkForNull(rs.getString(26));
			swab_instr_tmpl_id=checkForNull(rs.getString(27));
     		swab_instr_tmpl_desc=checkForNull(rs.getString(28));
	        anaesthesia_review_reqd_yn=checkForNull(rs.getString(29));
			status=checkForNull(rs.getString(30));
			med_ser_grp_code=checkForNull(rs.getString(31));
			med_ser_grp_desc=checkForNull(rs.getString(32));
			diag_code_scheme=checkForNull(rs.getString(33));
		}
		
		chk_checked1 = (anaesthesia_review_reqd_yn.equals("Y"))?"checked":"";
		chk_value1 = (anaesthesia_review_reqd_yn.equals("Y"))?"Y":"N";
		if(status.equals("E")){
			chk_checked="checked";
			disable_flag="";
		}else{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}

		 if(pre_op_no_of_verifications.equals("1")){
		   pre_op_verify1_disable="";
		   pre_op_verify2_disable="disabled";
		   pre_op_verify3_disable="disabled";
		   pre_op_verify4_disable="disabled";
		}else if(pre_op_no_of_verifications.equals("2")){
		   pre_op_verify1_disable="";
		   pre_op_verify2_disable="";
		   pre_op_verify3_disable="disabled";
		   pre_op_verify4_disable="disabled";
		}else if(pre_op_no_of_verifications.equals("3")){
		   pre_op_verify1_disable="";
		   pre_op_verify2_disable="";
		   pre_op_verify3_disable="";
		   pre_op_verify4_disable="disabled";
		}else if(pre_op_no_of_verifications.equals("4")){
		   pre_op_verify1_disable="";
		   pre_op_verify2_disable="";
		   pre_op_verify3_disable="";
		   pre_op_verify4_disable="";
		}else{
		   pre_op_no_of_verifications_disable="disabled";
		   pre_op_verify1_disable="disabled";
		   pre_op_verify2_disable="disabled";
		   pre_op_verify3_disable="disabled";
		   pre_op_verify4_disable="disabled";
		  }  
        
		 
		 if(post_op_no_of_verifications.equals("1")){
          post_op_verify1_disable="";
		  post_op_verify2_disable="disabled";
		  post_op_verify3_disable="disabled";
		  post_op_verify4_disable="disabled";
		 }else if(post_op_no_of_verifications.equals("2")){
          post_op_verify1_disable="";
		  post_op_verify2_disable="";
		  post_op_verify3_disable="disabled";
		  post_op_verify4_disable="disabled";
		 }else if(post_op_no_of_verifications.equals("3")){
          post_op_verify1_disable="";
		  post_op_verify2_disable="";
		  post_op_verify3_disable="";
		  post_op_verify4_disable="disabled";
		 }else if(post_op_no_of_verifications.equals("4")){
          post_op_verify1_disable="";
		  post_op_verify2_disable="";
		  post_op_verify3_disable="";
		  post_op_verify4_disable="";
		 }else{
		  post_op_no_of_verifications_disable="disabled";
          post_op_verify1_disable="disabled";
		  post_op_verify2_disable="disabled";
		  post_op_verify3_disable="disabled";
		  post_op_verify4_disable="disabled";
		 }
		speciality_code_disable="disabled";	

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
System.err.println("mode====>"+mode);
%>
<form name="SpecialitiesPrePostOperativeChecklist" id="SpecialitiesPrePostOperativeChecklist"  onload='FocusFirstElement();'  action="../../servlet/eOT.SpecialitiesServlet" method="post" target="messageFrame"> 
<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center id='t' >
<% if(mode.equals("insert")){ 
%>
<tr>
	<td class='label' width="25%">
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td width="25%" class="fields" >
		<input type="text" name="speciality_desc" id="speciality_desc" value="" onBlur="if(this.value!='') callSpeciality_Code(speciality_code,speciality_desc); else speciality_code.value=''"><input type="hidden" name="speciality_code" id="speciality_code" value=""><input type="button" class="button" name="generic_searchForSpecialityCode" id="generic_searchForSpecialityCode" value="?" onclick="callSpeciality_Code(speciality_code,speciality_desc);"><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td width="20%" class="label" nowrap>
		<fmt:message key="eOT.ProcedureCodingScheme.Label" bundle="${ot_labels}"/> 
	</td>
		  <td width="20%">
				<select name="diag_code_scheme" id="diag_code_scheme" value="<%=diag_code_scheme%>"> 
<%
	try{
	//Newly added by rajesh for CRF 303.1
		con=ConnectionManager.getConnection(request);

		/*Commented by Suma as told by Dilip to show more coding scheme's*/

		//String icd_sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and term_set_id in('ICD10PCS','ICD9CMP','CPT4','OTH')";	

		String icd_sql="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4') AND PROC_SPEC_YN  ='Y' and A.eff_status='E' AND LANGUAGE_ID = ? union  SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('OTH') AND PROC_SPEC_YN  ='Y' AND LANGUAGE_ID = ? ";

		icd_stmt=con.prepareStatement(icd_sql);
		icd_stmt.setString(1,locale);
		icd_stmt.setString(2,locale);
		icd_rs=icd_stmt.executeQuery();
		while(icd_rs.next()){
			mr_term_code=icd_rs.getString(1);
			mr_term_desc=icd_rs.getString(2);
	%>
			<option value='<%=mr_term_code%>' > <%=mr_term_desc%>  </option>
			<%
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

%>
		</select>
		</td>
</tr>
<% if (ca_module_yn.equals("Y")){%>
		<tr>
			<td class=label width="25%">
				<fmt:message key="Common.ChartID.label" bundle="${common_labels}"/>
			</td>
			<td width="25%" class="fields">
				<input type="text" name="chart_desc" id="chart_desc" value="" onBlur="if(this.value!='')callChartID(chart_id,chart_desc); else chart_id.value=''"><input type="hidden" name="chart_id" id="chart_id" value=""><input type="button" class="button" name="generic_searchForChartID" id="generic_searchForChartID" value="?" onclick="callChartID(chart_id,chart_desc);">
				</td><td></td><td></td>
		</tr>
<%}%>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOT.SwabandInstrumentCount.Label" bundle="${ot_labels}"/>
	</td>
	<td width="25%" class="fields">
		<input type="text" name="swamb_instrument" id="swamb_instrument" value="" onBlur="if(this.value!='')callSwabAndInstrID(template_id,swamb_instrument); else template_id.value=''"><input type="hidden" name="template_id" id="template_id" value="" ><input type="button" class="button" name="generic_searchForswamb_instrument_id" id="generic_searchForswamb_instrument_id" value="?" onclick="callSwabAndInstrID(template_id,swamb_instrument);">
	</td><td></td><td></td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/>
	</td>
	<td width="25%" class="fields">
		<input type="text" name="med_ser_group" id="med_ser_group" value="" onBlur="if(this.value!='')callMedicalServiceGroup(service_id,med_ser_group); else service_id.value=''"><input type="hidden" name="service_id" id="service_id" value="" ><input type="button" class="button" name="generic_searchFormed_ser_group" id="generic_searchFormed_ser_group" value="?" onclick="callMedicalServiceGroup(service_id,med_ser_group);">
	</td><td></td><td></td>
</tr>

<%} else if(mode.equals("modify")){
%>
<tr>
	<td class=label width="25%">
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields">
	<input type="text" name="speciality_desc" id="speciality_desc" value="<%=speciality_desc%>"  <%=speciality_code_disable%> > 
	<input type="hidden" name="speciality_code" id="speciality_code" value="<%=speciality_code%>"><input type="button" class="button" name="generic_searchForSpecialityCode" id="generic_searchForSpecialityCode" value="?" onclick="callSpeciality_Code(speciality_code,speciality_desc);"><img src='../../eCommon/images/mandatory.gif' img id="img2"></td>
	<td width="20%" class="label" nowrap>
		<fmt:message key="eOT.ProcedureCodingScheme.Label" bundle="${ot_labels}"/> 
	</td>
		  <td width="20%">
				<select name="diag_code_scheme" id="diag_code_scheme" value="<%=diag_code_scheme%>"> 
<%
	try{
	//Newly added by rajesh for CRF 303.1
		con=ConnectionManager.getConnection(request);
				/*Commented by Suma as told by Dilip to show more coding scheme's*/

		//String icd_sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and term_set_id in('ICD10PCS','ICD9CMP','CPT4','OTH')";	

		String icd_sql="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4') AND PROC_SPEC_YN  ='Y' and A.eff_status='E' AND LANGUAGE_ID = ? union  SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('OTH') AND PROC_SPEC_YN  ='Y' AND LANGUAGE_ID = ? ";


		icd_stmt=con.prepareStatement(icd_sql);
		icd_stmt.setString(1,locale);
		icd_stmt.setString(2,locale);
		icd_rs=icd_stmt.executeQuery();
		while(icd_rs.next()){
			mr_term_code=icd_rs.getString(1);
			mr_term_desc=icd_rs.getString(2);
			
			if(diag_code_scheme.equals(mr_term_code))
			{
				out.println("<option selected value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
			else
			{
				out.println("<option value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
			
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

%>			

			  </select>
	  </td>
</tr>

<%	if (ca_module_yn.equals("Y")) { %>
		<tr>
			<td class=label width="25%">
			<fmt:message key="Common.ChartID.label" bundle="${common_labels}"/></td>
			<td width="25%" class="fields">
			<input type="text" name="chart_desc" id="chart_desc" value="<%=chart_desc%>" onBlur="if(this.value!='')callChartID(chart_id,chart_desc); else chart_id.value=''"><input type="hidden" name="chart_id" id="chart_id" value="<%=chart_id%>" ><input type="button" class="button" name="generic_searchForChartID" id="generic_searchForChartID" value="?" <%=disable_flag%> onclick="callChartID(chart_id,chart_desc);">
			</td><td></td><td></td>
		</tr>
<%}%>



<tr>
	<td class=label width="25%">
	<fmt:message key="eOT.SwabandInstrumentCount.Label" bundle="${ot_labels}"/></td>
	<td width="25%" class="fields">
	<input type="text" name="swamb_instrument" id="swamb_instrument" value="<%=swab_instr_tmpl_desc%>" onBlur="if(this.value!='')callSwabAndInstrID(template_id,swamb_instrument); else template_id.value=''" ><input type="hidden" name="template_id" id="template_id" value="<%=swab_instr_tmpl_id%>" ><input type="button" class="button" name="generic_searchForswamb_instrument_id" id="generic_searchForswamb_instrument_id" value="?" <%=disable_flag%> onclick="callSwabAndInstrID(template_id,swamb_instrument);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/></td>
	<td width="25%" class="fields">
	<input type="text" name="med_ser_group" id="med_ser_group" value="<%=med_ser_grp_desc%>" onBlur="if(this.value!='')callMedicalServiceGroup(service_id,med_ser_group); else service_id.value=''" >
	<input type="hidden" name="service_id" id="service_id" value="<%=med_ser_grp_code%>"><input type="button" class="button" name="generic_searchForswamb_instrument_id" id="generic_searchForswamb_instrument_id" value="?" <%=disable_flag%> onclick="callMedicalServiceGroup(service_id,med_ser_group);">
	</td><td></td><td></td>
</tr>

<% }%>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOT.AnaesthesiaReviewRequired.Label" bundle="${ot_labels}"/>
	</td>
	<td width="25%" class="fields" >
		<input type="checkbox" name="anaesthesia_required_yn" id="anaesthesia_required_yn" onClick='setAnaestheiaYN();' value='<%=chk_value1%>' <%=chk_checked1%> >
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/> 
	</td>
	<td width="25%" class="fields" >
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td><td></td><td></td>
</tr>
<!--</table>-->

<!-- <table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center > -->
<tr>
<th class='columnHeaderCenter' width='100%' colspan=4 >
	<fmt:message key="eOT.PreOperativeCheckList.Label" bundle="${ot_labels}"/> 
</th>
</tr>
<% 
	if (mode.equals("insert")){
%>
<tr>
	<td class=label width="25%">
		<fmt:message key="eOT.Checklist.Label"  bundle="${ot_labels}"/> 
	</td>
	<td width="25%" class="fields" >
		<input type="hidden" name="pre_op_checklist_code" id="pre_op_checklist_code" value="">
		<input type="text" name="pre_op_checklist_desc" id="pre_op_checklist_desc" value="" size=25 maxlength=60 onblur="checkEmpty(this,no_of_verifications); " ><input type="button" class="button" name="generic_searchForChecklistCode" id="generic_searchForChecklistCode" value="?" onclick="callPreOPChecklist_Code(pre_op_checklist_code,pre_op_checklist_desc);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
		<fmt:message key="eOT.NoOfVerifications.Label" bundle="${ot_labels}"/>
	</td>
	<td width="25%" class="fields" >
	<select name="no_of_verifications" id="no_of_verifications" onchange="displayAppRole(this,'PRE');" disabled >
		<option value='' selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		<option value='1'>1</option>
		<option value='2'>2</option>
		<option value='3'>3</option>
		<option value='4'>4</option>
	</select>
	<img id="img1" src='../../eCommon/images/Blank1.gif' >
	<!--<td width="25%" class="fields" name='image1' style="display:none">
	<img src='../../eCommon/images/mandatory.gif'></td>-->
	</td><td></td><td></td>
</tr>
<tr>
	<td class=label width="25%">
		<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 1	</td>
	<td width="25%" class="fields" >
	<input type="text" name="role_desc1" id="role_desc1" value=""  size='20' maxlength='60' onBlur="if(this.value!='')callRole(role_id1,role_desc1); else role_id1.value='' " disabled><input type="hidden" name="role_id1" id="role_id1" value=""><input type="button" class="button" name="generic_searchForRole1" id="generic_searchForRole1" value="?"  onclick="callRole(role_id1,role_desc1);"disabled>
	<!--<img src='../../eCommon/images/mandatory.gif'>-->
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 2 </td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc2" id="role_desc2" value=""   size='20' maxlength='60'  disabled onBlur="if(this.value!='')callRole(role_id2,role_desc2); else role_id2.value='' "><input type="hidden" name="role_id2" id="role_id2" value=""><input type="button" class="button" name="generic_searchForRole2" id="generic_searchForRole2" value="?" disabled onclick="callRole(role_id2,role_desc2);">
	<!--<img src='../../eCommon/images/mandatory.gif'>-->
	</td><td></td><td></td>
</tr>

<tr>	 
	<td class=label width="25%">
		 <fmt:message key="Common.Role.label" bundle="${common_labels}"/> 3	</td>
	<td class="field" width='25%'>
	<input type="text" name="role_desc3" id="role_desc3" value=""   size='20' maxlength='60' disabled onBlur="if(this.value!='')callRole(role_id3,role_desc3); else role_id3.value=''"><input type="hidden" name="role_id3" id="role_id3" value=""><input type="button" class="button" name="generic_searchForRole3" id="generic_searchForRole3" value="?" disabled onclick="callRole(role_id3,role_desc3);">
	</td><td></td><td></td>
</tr>
<tr>
	<td class="label" width='25%'>
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 4	</td>
	<td class="field" width='25%'>
		<input type="text" name="role_desc4" id="role_desc4" value=""  size='20' maxlength='60' onBlur="if(this.value!='')callRole(role_id4,role_desc4); else role_id4.value='' " disabled><input type="hidden" name="role_id4" id="role_id4" value=""><input type="button" class="button" name="generic_searchForRole4" id="generic_searchForRole4" value="?" disabled onclick="callRole(role_id4,role_desc4);">
	</td><td></td><td></td>
</tr>
<%}else if(mode.equals("modify")){%>
<tr>
	<td class=label width="25%">
	<fmt:message key="eOT.Checklist.Label"  bundle="${ot_labels}"/> </td>
	<td width="25%" class="fields">
	<input type="text" name="pre_op_checklist_desc" id="pre_op_checklist_desc" value="<%=pre_op_checklist_desc%>" size=25 maxlength=60 onBlur="checkEmpty(this,no_of_verifications); " ><input type="hidden" name="pre_op_checklist_code" id="pre_op_checklist_code" value="<%=pre_op_checklist%>" ><input type="button" class="button" name="generic_searchForChecklistCode" id="generic_searchForChecklistCode" value="?"  onclick="callPreOPChecklist_Code(pre_op_checklist_code,pre_op_checklist_desc);" <%=disable_flag%> >
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="eOT.NoOfVerifications.Label" bundle="${ot_labels}"/></td>
	<td width="25%" class="fields">
	<select name="no_of_verifications" id="no_of_verifications" onchange="displayAppRole(this,'PRE');" <%=pre_op_no_of_verifications_disable%>>
	<% if(pre_op_no_of_verifications.equals("1")){%>
	<option value=''> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	<option value='1' selected>1</option>
	<option value='2'>2</option>
	<option value='3'>3</option>
	<option value='4'>4</option>
<% }else if(pre_op_no_of_verifications.equals("2")){%>
	<option value=''> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	<option value='1'>1</option>
	<option value='2' selected>2</option>
	<option value='3'>3</option>
	<option value='4'>4</option>
<% }else if(pre_op_no_of_verifications.equals("3")){%>
	<option value=''> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	<option value='1'>1</option>
	<option value='2'>2</option>
	<option value='3' selected>3</option>
	<option value='4'>4</option>
<% }else if(pre_op_no_of_verifications.equals("4")){%>
	<option value=''> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	<option value='1'>1</option>
	<option value='2'>2</option>
	<option value='3'>3</option>
	<option value='4' selected>4</option>
<% }else{%>
	<option value='' selected >
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	</option>
	<option value='1'>1</option>
	<option value='2'>2</option>
	<option value='3'>3</option>
	<option value='4'>4</option>
<%}//end of if else
%>
</select>
	<% 
if(pre_op_checklist.equals("")){%>
		<img id="img1" src='../../eCommon/images/Blank1.gif' ></td><td></td><td></td>
	<%}else{%>
		<img id="img1" src='../../eCommon/images/mandatory.gif' ></td><td></td><td></td>
	<%}%>
</tr>


<tr>
	<td class=label width="25%">
		<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 1	</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc1" id="role_desc1" value="<%=pre_op_verify1_user_role_desc%>"  size='20' maxlength='60' <%=pre_op_verify1_disable%> onBlur="if(this.value!='')callRole(role_id1,role_desc1); else role_id1.value='' " ><input type="hidden" name="role_id1" id="role_id1" value="<%=pre_op_verify1_user_role%>"><input type="button" class="button" name="generic_searchForRole1" id="generic_searchForRole1" value="?" <%=pre_op_verify1_disable%> <%=disable_flag%> onclick="callRole(role_id1,role_desc1);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 2</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc2" id="role_desc2" value="<%=pre_op_verify2_user_role_desc%>"   size='20' maxlength='60' <%=pre_op_verify2_disable%> onBlur="if(this.value!='')callRole(role_id2,role_desc2); else role_id2.value='' "><input type="hidden" name="role_id2" id="role_id2" value="<%=pre_op_verify2_user_role%>"><input type="button" class="button" name="generic_searchForRole2" id="generic_searchForRole2" value="?" <%=pre_op_verify2_disable%> <%=disable_flag%> onclick="callRole(role_id2,role_desc2);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 3</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc3" id="role_desc3" value="<%=pre_op_verify3_user_role_desc%>"   size='20' maxlength='60' <%=pre_op_verify3_disable%> onBlur="if(this.value!='')callRole(role_id3,role_desc3); else role_id3.value=''"><input type="hidden" name="role_id3" id="role_id3" value="<%=pre_op_verify3_user_role%>"><input type="button" class="button" name="generic_searchForRole3" id="generic_searchForRole3" value="?" <%=pre_op_verify3_disable%> <%=disable_flag%> onclick="callRole(role_id3,role_desc3);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 4</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc4" id="role_desc4" value="<%=pre_op_verify4_user_role_desc%>"  size='20' maxlength='60' <%=pre_op_verify4_disable%>  onBlur="if(this.value!='')callRole(role_id4,role_desc4); else role_id4.value=''" ><input type="hidden" name="role_id4" id="role_id4" value="<%=pre_op_verify4_user_role%>" ><input type="button" class="button" name="generic_searchForRole4" id="generic_searchForRole4" value="?"  <%=pre_op_verify4_disable%> <%=disable_flag%> onclick="callRole(role_id4,role_desc4);">
	</td><td></td><td></td>
</tr>
<%}%>
<th class='columnHeaderCenter' width='100%' colspan='4' >
<fmt:message key="eOT.PostOperativeCheckList.Label" bundle="${ot_labels}"/> </th>

<tr>
<% if(mode.equals("insert")){%>
<tr>
	<td class=label width="25%">
	<fmt:message key="eOT.Checklist.Label"  bundle="${ot_labels}"/>
	</td>
	<td width="25%" class="fields">
	<input type="text" name="post_op_checklist_desc" id="post_op_checklist_desc" value="" size=25 maxlength=60 onblur="checkEmpty(this,no_of_verifications1); " ><input type="hidden" name="post_op_checklist_code" id="post_op_checklist_code" value=""><input type="button" class="button" name="generic_searchForChecklistCode" id="generic_searchForChecklistCode" value="?" onclick="callPostOPChecklist_Code(post_op_checklist_code,post_op_checklist_desc);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%"><fmt:message key="eOT.NoOfVerifications.Label" bundle="${ot_labels}"/> </td>
	<td width="25%" class="fields">
	<select name="no_of_verifications1" id="no_of_verifications1" onchange="displayAppRole(this,'POST');" disabled>
	<option value='' selected >
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	</option>
	<option value='1'>1</option>
	<option value='2'>2</option>
	<option value='3'>3</option>
	<option value='4'>4</option>
	</select>
	<img id="img2" src='../../eCommon/images/Blank1.gif'>
	</td><td></td><td></td>
</tr>
<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 1 </td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc5" id="role_desc5" value=""  size='20' maxlength='60' disabled onBlur="if(this.value!='')callRole(role_id5,role_desc5); else role_id5.value='' "><input type="button" class="button" name="generic_searchForRole5" id="generic_searchForRole5" value="?" disabled onclick="callRole(role_id5,role_desc5);"><input type="hidden" name="role_id5" id="role_id5" value="">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 2</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc6" id="role_desc6" value="" size='20' maxlength='60' disabled	onBlur="if(this.value!='')callRole(role_id6,role_desc6); else role_id6.value='' "><input type="hidden" name="role_id6" id="role_id6" value=""><input type="button" class="button" name="generic_searchForRole6" id="generic_searchForRole6" value="?" disabled onclick="callRole(role_id6,role_desc6);">
	</td><td></td><td></td>
	
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 3</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc7" id="role_desc7" value=""   size='20' maxlength='60' disabled onBlur="if(this.value!='')callRole(role_id7,role_desc7); else role_id7.value='' "><input type="hidden" name="role_id7" id="role_id7" value=""><input type="button" class="button" name="generic_searchForRole7" id="generic_searchForRole7" value="?" disabled onclick="callRole(role_id7,role_desc7);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 4 </td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc8" id="role_desc8" value=""  size='20' maxlength='60' disabled onBlur="if(this.value!='')callRole(role_id8,role_desc8); else role_id8.value='' "><input type="hidden" name="role_id8" id="role_id8" value=""><input type="button" class="button" name="generic_searchForRole8" id="generic_searchForRole8" value="?" disabled onclick="callRole(role_id8,role_desc8);">
	</td><td></td><td></td>
</tr>
		
	<%}else if(mode.equals("modify")){%>
<tr>
	<td class=label width="25%"><fmt:message key="eOT.Checklist.Label"  bundle="${ot_labels}"/> </td>
	<td width="25%" class="fields">
	<%
		System.err.println("630,post_op_checklist_desc========>"+post_op_checklist_desc);
		System.err.println("631,post_op_checklist========>"+post_op_checklist);
	%>
	<input type="text" name="post_op_checklist_desc" id="post_op_checklist_desc" value="<%=post_op_checklist_desc%>" size=25 maxlength=60 onblur="checkEmpty(this,no_of_verifications1); " ><input type="hidden" name="post_op_checklist_code" id="post_op_checklist_code" value="<%=post_op_checklist%>"><input type="button" class="button" name="generic_searchForChecklistCode" id="generic_searchForChecklistCode" value="?"  onclick="callPostOPChecklist_Code(post_op_checklist_code,post_op_checklist_desc);" <%=disable_flag%> >
</td></td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="eOT.NoOfVerifications.Label" bundle="${ot_labels}"/> </td>
	<td width="25%" class="fields">
		<select name="no_of_verifications1" id="no_of_verifications1" onchange="displayAppRole(this,'POST');" <%=post_op_no_of_verifications_disable%>>
			<% if(post_op_no_of_verifications.equals("1")){%>
				<option value=''> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value='1' selected>1</option>
				<option value='2'>2</option>
				<option value='3'>3</option>
				<option value='4'>4</option>
			<%}else if(post_op_no_of_verifications.equals("2")){%>
				<option value=''> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<option value='1'>1</option>
				<option value='2' selected>2</option>
				<option value='3'>3</option>
				<option value='4'>4</option>
			<%}else if(post_op_no_of_verifications.equals("3")){%>
				<option value=''> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<option value='1'>1</option>
				<option value='2'>2</option>
				<option value='3' selected>3</option>
				<option value='4'>4</option>
			<% }else if(post_op_no_of_verifications.equals("4")){%>
				<option value=''> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<option value='1'>1</option>
				<option value='2'>2</option>
				<option value='3'>3</option>
				<option value='4' selected>4</option>
			<%} else{%>
				<option value='' selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value='1'>1</option>
				<option value='2'>2</option>
				<option value='3'>3</option>
				<option value='4'>4</option>
			<%}%>
		</select>
			<% 
if(post_op_checklist.equals("")){%>
				<img id="img2" src='../../eCommon/images/Blank1.gif'>
			<%}else{%>
				<img id="img2" src='../../eCommon/images/mandatory.gif'>
			<%}%>
	 </td><td></td><td></td>

</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 1</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc5" id="role_desc5" value="<%=post_op_verify1_user_role_desc%>"  size='20' maxlength='60' <%=post_op_verify1_disable%>  onBlur="if(this.value!='')callRole(role_id5,role_desc5); else role_id5.value=''"><input type="hidden" name="role_id5" id="role_id5" value="<%=post_op_verify1_user_role%>"><input type="button" class="button" name="generic_searchForRole5" id="generic_searchForRole5" value="?" <%=post_op_verify1_disable%> <%=disable_flag%> onclick="callRole(role_id5,role_desc5);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 2</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc6" id="role_desc6" value="<%=post_op_verify2_user_role_desc%>"   size='20' maxlength='60' <%=post_op_verify2_disable%> onBlur="if(this.value!='')callRole(role_id6,role_desc6); else role_id6.value='' "><input type="hidden" name="role_id6" id="role_id6" value="<%=post_op_verify2_user_role%>"><input type="button" class="button" name="generic_searchForRole6" id="generic_searchForRole6" value="?"  <%=post_op_verify2_disable%> <%=disable_flag%> onclick="callRole(role_id6,role_desc6);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">	
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 3</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc7" id="role_desc7" value="<%=post_op_verify3_user_role_desc%>" size='20' maxlength='60' <%=post_op_verify3_disable%>  onBlur="if(this.value!='')callRole(role_id7,role_desc7); else role_id7.value='' "><input type="hidden" name="role_id7" id="role_id7" value="<%=post_op_verify3_user_role%>"><input type="button" class="button" name="generic_searchForRole7" id="generic_searchForRole7" value="?"  <%=post_op_verify3_disable%> <%=disable_flag%> onclick="callRole(role_id7,role_desc7);">
	</td><td></td><td></td>
</tr>

<tr>
	<td class=label width="25%">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/> 4</td>
	<td width="25%" class="fields">
	<input type="text" name="role_desc8" id="role_desc8" value="<%=post_op_verify4_user_role_desc%>"  size='20' maxlength='60' <%=post_op_verify4_disable %> onBlur="if(this.value!='')callRole(role_id8,role_desc8); else role_id8.value='' "><input type="hidden" name="role_id8" id="role_id8" value="<%=post_op_verify4_user_role%>"><input type="button" class="button" name="generic_searchForRole8" id="generic_searchForRole8" value="?"  <%=post_op_verify4_disable%> <%=disable_flag%> onclick="callRole(role_id8,role_desc8);">
	</td><td></td><td></td>
</tr>
<%}%>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='pre_op_no_of_verifications' id='pre_op_no_of_verifications' value='<%=pre_op_no_of_verifications%>'>
<input type="hidden" name='post_op_no_of_verifications' id='post_op_no_of_verifications' value='<%=post_op_no_of_verifications%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</body>
</html>


