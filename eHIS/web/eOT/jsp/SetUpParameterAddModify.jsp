<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/SetUpParameter.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="SetUpParameterForm" id="SetUpParameterForm"  onload='FocusFirstElement()'  action="../../servlet/eOT.SetUpParameterServlet" method="post" target="messageFrame"> 

<%
Connection con=null;
PreparedStatement stmt=null;
PreparedStatement icd_stmt=null;
ResultSet rs=null;
ResultSet icd_rs=null;
String mode=request.getParameter("mode");
String chk_checked="";
String chk_value="N";
String chk_checked1="";
String chk_value1="N";
//CRF-004 Authorize Slots for Booking - Rajesh V
String checkedYnSlots = "";
String chkValueSlots = "N";
String scheduleRestrictYn = "";
//CRF-004 Authorize Slots for Booking - Rajesh V
String disable_flag="";
String diag_code_scheme="";
String oper_code_scheme_db = "";
String oper_num_date_prefix_yn="";
String operative_records_note_type = "";    
String note_type = "";
String note_type_desc = "";
String build_anaesthesia_into_cr_yn="";
String sql="";
String mr_term_code="";
String mr_term_desc="";
String diag_code_desc="";
//Added for BRU-CRF-004 Starts & IN050472
PreparedStatement pstmt=null;
String customer_id="";
String sql_sm_cust="select customer_id from SM_SITE_PARAM where rownum = 1";
//Added for BRU-CRF-004 Ends & IN050472
int total_records=0;

	try{
		con=ConnectionManager.getConnection(request);
		sql=" Select count(*) as total_records_existing from OT_PARAM";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
	    rs.next();
		
		total_records=rs.getInt(1);
			
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}

		if(total_records==1)
		{
		   mode="modify";
		   disable_flag="disabled";
		}
		else
		{
		   mode="insert";
		   disable_flag="";
		}

		if(mode.equals("modify"))
{

	try{
		con=ConnectionManager.getConnection(request);
		//CRF-004 Authorize Slots for Booking - Rajesh V
		//Added for site specific IN050472
			pstmt=con.prepareStatement(sql_sm_cust); 
			rs=pstmt.executeQuery();
			if(rs !=null && rs.next())
			{
			customer_id=checkForNull(rs.getString("customer_id"));
			}	
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		//Added for site specific IN050472
		sql="Select A.OPER_CODE_SCHEME, NVL(A.OPER_NUM_DATE_PREFIX_YN, 'N') OPER_NUM_DATE_PREFIX_YN , A.DIAG_CODE_SCHEME,    A.OPERATIVE_RECORDS_NOTE_TYPE, NVL(B.NOTE_TYPE,'') NOTE_TYPE, A.BUILD_ANAESTHESIA_INTO_CR_YN, GET_DESC(?,'MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',A.OPER_CODE_SCHEME) DIAG_CODE_DESC, A.SCHEDULE_RESTRICT_YN  from OT_PARAM A, CA_NOTE_TYPE B WHERE A.OPERATIVE_RECORDS_NOTE_TYPE = B.NOTE_TYPE(+)";
		//CRF-004 Authorize Slots for Booking - Rajesh V
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		rs=stmt.executeQuery();

		if(rs!=null && rs.next())
		{

			oper_code_scheme_db=rs.getString("OPER_CODE_SCHEME");
			oper_num_date_prefix_yn=rs.getString("OPER_NUM_DATE_PREFIX_YN");
			diag_code_scheme=checkForNull(rs.getString("DIAG_CODE_SCHEME"));
			operative_records_note_type=rs.getString("OPERATIVE_RECORDS_NOTE_TYPE");			
			//note_type_desc=rs.getString("NOTE_TYPE_DESC");
			note_type=rs.getString("NOTE_TYPE");
			build_anaesthesia_into_cr_yn=checkForNull(rs.getString("BUILD_ANAESTHESIA_INTO_CR_YN"));
			diag_code_desc=checkForNull(rs.getString("DIAG_CODE_DESC"));
			//CRF-004 Authorize Slots for Booking - Rajesh V
			scheduleRestrictYn = checkForNull(rs.getString("SCHEDULE_RESTRICT_YN"));
			//CRF-004 Authorize Slots for Booking - Rajesh V
		}
		if(note_type!=null && !note_type.equals("")){
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

			sql="Select NOTE_TYPE_DESC from CA_NOTE_TYPE_LANG_VW WHERE LANGUAGE_ID = ? AND NOTE_TYPE=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,locale);
			stmt.setString(2,note_type);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				note_type_desc=rs.getString("NOTE_TYPE_DESC");
			}
		}
		if(oper_num_date_prefix_yn.equals("Y"))
		{
			chk_checked="checked";
			chk_value = "Y";
		}
		else
		{
			chk_checked="";
			chk_value = "N";
		}

		if(build_anaesthesia_into_cr_yn.equals("Y"))
		{
			chk_checked1="checked";
			chk_value1 = "Y";
		}
		else
		{
			chk_checked1="";
			chk_value1 = "N";
		}

		if (note_type_desc==null) {
		  note_type_desc = "";
		}

		//CRF-004 Authorize Slots for Booking - Rajesh V
		if(scheduleRestrictYn.equals("Y"))
		{
			checkedYnSlots="checked";
			chkValueSlots = "Y";
		}
		else
		{
			checkedYnSlots="";
			chkValueSlots = "N";
		}
		//CRF-004 Authorize Slots for Booking - Rajesh V
		
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		//out.println(note_type);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
}

%>
<br><br><br><br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='80%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
   
<tr> 
	<%
	if((mode.equals("insert")) || total_records==0){
	%>
		  <td class='label' nowrap>
			<fmt:message key="eOT.ProcedureCodingScheme.Label" bundle="${ot_labels}"/>
		  </td>
		  <td class='fields'>
		  <select name="oper_code_scheme" id="oper_code_scheme" >  
<%
	  	try{
		//Newly added by rajesh for CRF 303.1
		con=ConnectionManager.getConnection(request);
		/*Commented by Suma as told by Dilip to show more coding scheme's*/

		//String icd_sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND EFF_STATUS='E'";	

		String icd_sql="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4') AND PROC_SPEC_YN  ='Y' and A.eff_status='E' AND LANGUAGE_ID = ? union SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('OTH') AND PROC_SPEC_YN  ='Y'  AND LANGUAGE_ID = ? " ;
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
		//out.println("Exception in SetupPrameterAddModify.jsp : "+e);
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Exception in SetupPrameterAddModify.jsp MR Term CSet List Item "+e);
		}		
	}

%>
			
		  </select>
				<img src='../../eCommon/images/mandatory.gif'></img>
		
	<% }else if (mode.equals("modify"))	{
		%>
		
		  <td class='label'nowrap>
			<fmt:message key="eOT.ProcedureCodingScheme.Label" bundle="${ot_labels}"/> 
		</td>
		  <input type="hidden" name="oper_code_scheme1" id="oper_code_scheme1" value="<%=oper_code_scheme_db%>">
		  <td> 
			<select name="oper_code_scheme" id="oper_code_scheme" <%=disable_flag%>>
    <%
	  	try{
		//Newly added by rajesh for CRF 303.1
		con=ConnectionManager.getConnection(request);
		
		/*Commented by Suma as told by Dilip to show more coding scheme's*/

		//String icd_sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and term_set_id in('ICD10PCS','ICD9CMP','CPT4','OTH')";	

		String icd_sql="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4') AND PROC_SPEC_YN  ='Y' and A.eff_status='E' AND LANGUAGE_ID = ? union SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('OTH') AND PROC_SPEC_YN  ='Y'  AND LANGUAGE_ID = ? " ;

		icd_stmt=con.prepareStatement(icd_sql);
		icd_stmt.setString(1,locale);
		icd_stmt.setString(2,locale);
		icd_rs=icd_stmt.executeQuery();
		while(icd_rs.next()){
			mr_term_code=icd_rs.getString(1);
			mr_term_desc=icd_rs.getString(2);
			if(oper_code_scheme_db.equals(mr_term_code))
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
		//System.err.println("Exception in SetupParameterAddModify: "+e);
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Exception in SetupParameterAddModify.jsp MR Term CSet List Item "+e);
		}		
	}

%>
			</select>
				<img src='../../eCommon/images/mandatory.gif'></img><%} %>
	</td>			 
</tr> 

<tr> 
 	<%
	if ((mode.equals("insert")) || total_records==0){
	%>
		  <td class='label' nowrap>
			<fmt:message key="Common.DiagnosisCodingScheme.label" bundle="${common_labels}"/> 
		</td>
		  <td>
				<select name="diag_code_scheme" id="diag_code_scheme" > 			  
	    <%
	  	try{
			/*Added by Suma as told by Dilip to show more coding scheme's*/

		con=ConnectionManager.getConnection(request);
		
	String icd_sql2="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4','OTH') AND DIAG_SPEC_YN  ='Y' AND LANGUAGE_ID  = ? " ;

		icd_stmt=con.prepareStatement(icd_sql2);
		icd_stmt.setString(1,locale);
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
		//System.err.println("Exception in SetupParameterAddModify: "+e);
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Exception in SetupParameterAddModify.jsp MR Term CSet List Item "+e);
		}		
	}

%>
			  </select>
			  </td>
	<% }else if (mode.equals("modify"))
	{%>
		  <td class='label' nowrap>
				<fmt:message key="Common.DiagnosisCodingScheme.label" bundle="${common_labels}"/> 
		   </td>
		  <td> <select name="diag_code_scheme" id="diag_code_scheme">
		     	    <%
	  	try{
			/*Added by Suma as told by Dilip to show more coding scheme's*/

		con=ConnectionManager.getConnection(request);
		
	String icd_sql2="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4','OTH') AND DIAG_SPEC_YN  ='Y' AND LANGUAGE_ID  = ? " ;

		icd_stmt=con.prepareStatement(icd_sql2);
		icd_stmt.setString(1,locale);
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
		//System.err.println("Exception in SetupParameterAddModify: "+e);
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Exception in SetupParameterAddModify.jsp MR Term CSet List Item "+e);
		}		
	}

%>
			</select>
			  
		 </td>
		
		<%} %>
</tr> 

<% if (mode.equals("modify"))
{%>
<tr>
	<td class=label nowrap>
		<fmt:message key="eOT.PrefixDateOperationNumber.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="oper_num_date_prefix_yn" id="oper_num_date_prefix_yn" disabled value='<%=chk_value%>' <%=chk_checked%> >

	</td>
</tr>
<%}else {%>
<tr>
	<td class=label nowrap>
		<fmt:message key="eOT.PrefixDateOperationNumber.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="oper_num_date_prefix_yn" id="oper_num_date_prefix_yn" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<%}%>
<tr>
	<td class=label nowrap>
		<fmt:message key="eOT.OperativeRecordsNoteType.Label" bundle="${ot_labels}"/>
	</td>
	<td align='left' nowrap>
		
		<input type='text' name='operative_records_note_type_desc' id='operative_records_note_type_desc' size='30' value="<%=note_type_desc%>"  onBlur="if(this.value!='')searchOperativeRecordNoteType(operative_records_note_type,operative_records_note_type_desc); else operative_records_note_type.value=''"> 
		<input type='hidden' name='operative_records_note_type' id='operative_records_note_type'  value="<%=operative_records_note_type%>"> 
		<input type='button' class='button' value='?' name='notetypelkp' id='notetypelkp' onClick="searchOperativeRecordNoteType(operative_records_note_type,operative_records_note_type_desc);" >

	</td>

</tr>
<tr> 
	<td class=label nowrap>
		<fmt:message key="eOT.BuildAnaesthesiaIntoCR.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="build_anaesthesia_into_cr_yn" id="build_anaesthesia_into_cr_yn" onClick='setCheckValue1();' value='<%=chk_value1%>' <%=chk_checked1%> >
	</td>
</tr>
<!-- CRF-004 Authorize Slots for Booking - Rajesh V & IN050472-->
<% if(customer_id.equalsIgnoreCase("MOHBR")){%>
<tr> 
	<td class=label nowrap>
		<fmt:message key="eOT.RestrictBookingYN.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="schedule_restrict_yn" id="schedule_restrict_yn" onClick='setCheckValueSlots();' value='<%=chkValueSlots%>' <%=checkedYnSlots%> >
	</td>
</tr>
<%}%>
<!-- CRF-004 Authorize Slots for Booking - Rajesh V & IN050472 -->
  <tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name="tot_records" id="tot_records" value="<%=total_records %>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type="hidden" name="oper_num_date_prefix_yn_dup" id="oper_num_date_prefix_yn_dup" value='<%=chk_value%>' <%=chk_checked%> >
</form>
</body>
</html>

