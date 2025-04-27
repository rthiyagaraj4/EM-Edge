<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
 <head>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
    <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085   
	String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../js/NewProcedure.js' language='javascript'></script>
<script src='../js/NewProcedureMain.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	Connection con      = null;
	Statement stmt		= null;
	ResultSet rset		= null;
	
	PreparedStatement stmt2	= null;
	PreparedStatement pstmt	= null;
	ResultSet rs2	= null;
	String Practitioner_Id="";	String relationship_id	="";
	String Locn_Code	="";	String Locn_Type	="";
	String Patient_Id	="";	String Encounter_Id	="";
	String currentdate	="";	String facilityId ="";
	String dob = ""; String age = "";
	String sex = ""; String associate_codes ="";
	String notifiable_yn;
	
	String term_code = "";	String term_set_id = "";
	String nature = "";  	String onset_date = "";
	String status = "";  	String srl_no = "";     
	
	String	severity = "";	String	onset_type = "";
	String	priority = "";	String	accuracy_code = "";
	String	remarks = "";	String	status_date = "";
	String patient_class	="";	
	String disimage = "display:none";
	//String disimage = "display:inline";
	
	String def_status	=""; String date_status	="";
	String def_disable	="";  String occur_srl_no="";
	String style_def = "";		String mode="";
	String modal_yn="";	
	
	String facility_id=checkForNull((String)session.getValue("facility_id"));
	String practitioner_type=checkForNull((String)session.getValue("practitioner_type"));
	String ca_practitioner_id=(String) session.getAttribute("ca_practitioner_id") == null?"" :(String) session.getAttribute("ca_practitioner_id");
	StringBuffer sql=new StringBuffer(); 

	try
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
		currentdate				= dateFormat.format(new java.util.Date()) ;
		onset_date				= currentdate;
		status_date				= currentdate;
		occur_srl_no			= checkForNull(request.getParameter("occur_srl_no"));
		srl_no					= checkForNull(request.getParameter("srl_no"));
		Practitioner_Id			= checkForNull(request.getParameter("Practitioner_Id"));	
		relationship_id			= checkForNull(request.getParameter("relationship_id"));
		Locn_Code				= checkForNull(request.getParameter("location_code"));			
		Locn_Type				= checkForNull(request.getParameter("location_type"));
		Patient_Id				= checkForNull(request.getParameter("patient_id"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		Encounter_Id			= checkForNull(request.getParameter("encounter_id"));
		associate_codes			= checkForNull(request.getParameter("associate_codes"));		
		age						= checkForNull(request.getParameter("Age"));	
		dob						= checkForNull(request.getParameter("Dob"));	
		sex						= checkForNull(request.getParameter("Sex"));	
		mode					= checkForNull(request.getParameter("mode"));
		modal_yn				= checkForNull(request.getParameter("modal_yn"));
		notifiable_yn			= checkForNull(request.getParameter("notifiable_yn"));
		
		if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
			Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
		}
		//modal_yn="Y";
		term_set_id			=checkForNull(request.getParameter("term_set_id"));
		if(!term_set_id.equals(""))
			disimage = "display:inline";
		term_code				=checkForNull(request.getParameter("term_code"));

		String term_short_desc = "";
		String codes = "";			String Aselect ="";			String Pselect ="";
		String Wselect ="";			String pri_N_select ="";	String pri_H_select ="";
		String pri_C_select ="";	String sevr_L_select ="";	String sevr_D_select ="";
		String sevr_S_select ="";	String sevr_E_select ="";	String stus_A_select ="";
		String stus_R_select ="";	String stus_X_select ="";	String stus_E_select ="";

		String type_A_select = "";	String type_C_select = "";	String mandatory_status	=""; 
		String code_ind	="";		String mandatory_disable	=""; String diff_group_id	="";
		String def_select = "";
		
		con = ConnectionManager.getConnection(request);

	if(modal_yn.equals("Y"))
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("select OCCUR_SRL_NO from pr_diagnosis  where patient_id = ? ");
		sql.append(" and TERM_SET_ID=? and TERM_CODE=?  and CURR_STATUS ='A' ");
		pstmt = con.prepareStatement( sql.toString() ) ;
		pstmt.setString( 1, Patient_Id) ;
		pstmt.setString( 2, term_set_id) ;
		pstmt.setString( 3, term_code) ;
		rset = pstmt.executeQuery() ;
		while(rset.next())
		{
			occur_srl_no=checkForNull(rset.getString("OCCUR_SRL_NO"));
			//System.out.println("occur_srl_no--------"+occur_srl_no);
		}if (pstmt!=null) pstmt.close();
		 if(rset!=null) rset.close();
		if(!occur_srl_no.equals(""))
			mode="modify";
	}	
		
	if(mode.equals("modify"))
	{
		disimage = "display:inline";
		mandatory_status="readonly";
		mandatory_disable	="disabled";
		def_select = "";
		
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("select a.patient_id,a.term_set_id,a.term_code,");
		sql.append("B.long_desc term_short_desc,a.code_indicator,");
		sql.append("to_char(a.onset_date,'dd/mm/yyyy') onset_date ,a.curr_severity, ");
		sql.append("a.curr_onset_type,a.curr_facility_id,"); 
		sql.append("a.curr_encounter_id,a.curr_practitioner_id ,a.curr_practitioner_reln_id,"); sql.append("a.curr_locn_type,a.curr_locn_code,a.curr_nature,a.curr_priority,");
		sql.append("a.curr_accuracy_code,a.curr_accuracy_ind, a.curr_remarks, a.curr_status,"); sql.append("to_char(a.curr_status_date,'dd/mm/yyyy') status_date ,nvl(c.diff_group_id,'0') diff_group_id ");
		sql.append(" from pr_diagnosis a, mr_term_code b,");
		sql.append(" pr_differential_diagnosis c where a.term_code=b.term_code  ");
		sql.append(" and a.term_set_id=b.term_set_id  and "); 
		sql.append(" c.term_code(+)=a.term_code ");
		sql.append(" and c.OCCUR_SRL_NO(+)=a.OCCUR_SRL_NO and c.term_set_id(+) = a.term_set_id and ");
		sql.append(" c.patient_id(+)=a.patient_id and ");
		sql.append(" a.patient_id=? and a.term_set_id=? and a.term_code=? "); 
		sql.append(" and a.OCCUR_SRL_NO=?");

		stmt2 = con.prepareStatement(sql.toString());
		stmt2.setString(1,Patient_Id);
		//System.out.println(Patient_Id);
		stmt2.setString(2,term_set_id);
		//System.out.println(term_set_id);
		stmt2.setString(3,term_code);
		//System.out.println(term_code);
		stmt2.setString(4,occur_srl_no);
		//System.out.println(occur_srl_no);
		rs2 = stmt2.executeQuery();

		while(rs2.next())
		{
			status					= checkForNull(rs2.getString("curr_status"));
			Patient_Id				= checkForNull(rs2.getString("patient_id"));
			term_set_id				= checkForNull(rs2.getString("term_set_id"));
			term_code				= checkForNull(rs2.getString("term_code"));
			term_short_desc			= checkForNull(rs2.getString("term_short_desc"));
			onset_date				= checkForNull(rs2.getString("onset_date"));
			severity				= checkForNull(rs2.getString("curr_severity"));
			onset_type				= checkForNull(rs2.getString("curr_onset_type"));
			Practitioner_Id			= checkForNull(rs2.getString("curr_practitioner_id"));
			relationship_id			= checkForNull(rs2.getString("curr_practitioner_reln_id"));
			Locn_Type				= checkForNull(rs2.getString("curr_locn_type"));
			Locn_Code				= checkForNull(rs2.getString("curr_locn_code"));
			nature					= checkForNull(rs2.getString("curr_nature"));
			priority				= checkForNull(rs2.getString("curr_priority"));
			accuracy_code			= checkForNull(rs2.getString("curr_accuracy_code"));
			remarks					= checkForNull(rs2.getString("curr_remarks"));
			diff_group_id			= checkForNull(rs2.getString("diff_group_id"));
			status_date				= checkForNull(rs2.getString("status_date"));
			code_ind				= checkForNull(rs2.getString("code_indicator"));
			//Encounter_Id			= checkForNull(rs2.getString("curr_encounter_id"));
			
		}
		
		if(rs2!=null) rs2.close();
		if(stmt2!=null) stmt2.close();
		
		if(nature.equals("A"))
			Aselect = "selected";
		else if(nature.equals("P"))
			Pselect = "selected";
		else if(nature.equals("W"))
			Wselect = "selected";

		if(priority.equals("N"))
			pri_N_select = "selected";
		else if(priority.equals("H"))
			pri_H_select = "selected";
		else if(priority.equals("C"))
			pri_C_select = "selected";

		if(severity.equals("L"))
			sevr_L_select = "selected";
		else if(severity.equals("D"))
			sevr_D_select = "selected";
		else if(severity.equals("S"))
			sevr_S_select = "selected";
		else if(severity.equals("E"))
			sevr_E_select = "selected";
	
		if(status.equals("A"))
		{	
			stus_A_select = "selected";
			def_status="";
			date_status="readOnly";
			def_disable	="";
		}
		else if(status.equals("R"))
		{
			stus_R_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
		else if(status.equals("X"))
		{
			stus_X_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
		else if(status.equals("E"))
		{
			stus_E_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
	
		if(onset_type.equals("A"))
			type_A_select = "selected";
		else if(onset_type.equals("C"))
			type_C_select = "selected";

	//For Supprot Diiagnosis.......
	if(sql.length() > 0) sql.delete(0,sql.length());
	int temp=0;
	String supp_term_code=""; String supp_term_desc ="";
	StringBuffer temp_associate_codes=new StringBuffer();
	sql.append(" select a.supp_term_code ,b.short_desc from pr_support_diagnosis a , ");
	sql.append(" mr_term_code b where b.term_code = a.supp_term_code and a.patient_id =? and ");
	sql.append(" a.term_code = ? and b.term_set_id = ? and occur_srl_no=? and srl_no=");
	sql.append("(select max(srl_no) from pr_support_diagnosis where patient_id=a.PATIENT_ID and "); 
	sql.append("term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and occur_srl_no=a.occur_srl_no) ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,Patient_Id);
		pstmt.setString(2,term_code);
		pstmt.setString(3,term_set_id);
		pstmt.setString(4,occur_srl_no);
		rset = pstmt.executeQuery();

		temp = 0;
		while(rset.next())
		{
			supp_term_code = rset.getString(1);
			supp_term_desc = rset.getString(2);
							
			if(temp == 0)
				temp_associate_codes.append(supp_term_code + "~" + supp_term_desc);
				else
					temp_associate_codes.append("|" + supp_term_code + "~" + supp_term_desc);	
				temp++;
		}
		
		if(associate_codes.equals(""))
			associate_codes=temp_associate_codes.toString();
		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
	}
	else
	{
		def_disable="";			def_status	="";
		mandatory_status="";	mandatory_disable	="";
		def_select = "selected";
	}
%>

<form name='multipract_form' id='multipract_form'  action='' method='get' target='messageFrame'>

<table border=0 cellpadding='3' cellspacing='0' width="100%" align=center>
<tr>
	<td class='label' width='10%' align='right' colspan='' nowrap>Medical Team</td>
	<td class='label' width='30%' colspan=''><SELECT name="med_team" id="med_team">
	<option>-----Select-----</option>
	<%
		
	String sql1 = "select team_id, short_desc from am_medical_team where facility_id = ? and eff_status='E' order by 2";
    try
	{
		pstmt =con.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1,facility_id);
		rset=pstmt.executeQuery();
		String name="",id="",sel="";
		String med_code="";	
		while(rset!=null && rset.next())
		{
			name=rset.getString(2);
			id =rset.getString(1);
			if(mode.equals("update")){
				if (id.trim().equalsIgnoreCase(med_code))
					sel="selected";
				else sel="";
			}else{
				sel="";
			}
			out.println("<option value='"+id+"' " + sel +">"+name+"</option>");
		}
		
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
		System.out.println("Exception in medteam.jsp"+e.toString());
	}

    %>
	</SELECT>
	</td>
	<td class='label' align='center' width='20%'>Practitioner</td>
	<td class='label' align='30%' width=''><input type="text"  name="pract_description" id="pract_description" value="" size=13 ><input type='button' class='button' name="pract_btn" id="pract_btn" value='?' onclick="displayMultiPract()"></td> 
		<input type="hidden"  name="pract_code" id="pract_code" value="">
		<input type="hidden" name="postn_description" id="postn_description" value="" >
		<input type="hidden" name="postn_code" id="postn_code" value="" >
	<td class='label' align='right' width=''><!-- Priority<select name="priority" id="priority"><option value="1">Elective</option><option value="5">Emergency</option><option value="7">Semi-Critical</option><option value="9">Critical</option></select></td>
	<td class='label' align='center' colspan='3'>&nbsp ;<input type='button' class='button' name="notes_btn" id="notes_btn" value='Notes' onclick="callClinicalNotes('','<%=Patient_Id%>','<%=patient_class%>','<%=Encounter_Id%>','')"> --></td>
		
</tr>
<tr>
	<td class='label' width='' colspan='6'>
		<table border=1 cellspacing=0 cellpadding = 3 width='100%' align='center' style='<%//=disimage%>' id=''>
		<tr>
			<td class=columnheader width='5%'></td>
			<td class=columnheader width='50%'>Practitioner</td>
			<td class=columnheader width='35%'>Role</td>
			<td class=columnheader width='10%'>Select</td>
		</tr>
		<tr>
			<td colspan='' class='QRYEVEN' align='center'><font size=1><a href="javascript:showPractWindow('<%=ca_practitioner_id%>')">+</a></font></td>
			<td colspan='' class='QRYEVEN' ><font size=1><%=ca_practitioner_id%></font></td>
			<td colspan='' class='QRYEVEN' ><select name='role_desc0' id='role_desc0' onchange=''>
				<option value=''>--- Select ---</option>
				<option value='01' selected>Main Surgeon</option>
				<option value='11'>Assisting Surgeon	</option>
				<option value='21'>Anaesthetist</option>
				<option value='41'>Consultant</option>
				<option value='51'>Scrub Nurse	</option>
				</select></td>
			<td colspan='' class='QRYEVEN'  align='center'><input type='checkbox' name='pract_chk0' id='pract_chk0' checked readonly></td>
			<input type='hidden' value='<%=ca_practitioner_id%>' name='pract_code0'>
			<input type='hidden' value='' name='pract_type_code0' id='pract_type_code0'><input type='hidden' value='' name='postn_code0' id='postn_code0'><input type='hidden'  name='postn_desc0' id='postn_desc0' value=''>
		</tr> 
		<tr style='height:1pt'>
			<td colspan='4' class='QRYEVEN' id='pract_val'></td>
		</tr>
		</table>
	</td>
</tr>
<tr style='display:none'>
	<td align="right" valign="middle" class="label">Intra - Procedural Complications</td>
	<td colspan='5'><textarea name="findings" rows='1' cols='60'
	onBlur="makeValidString(this);" maxlength=500  onFocus='' onKeyPress=''></textarea></td>
</tr>
<tr style='display:none'>
	<td align="right" valign="middle" class="label">Actions taken to resolve complications</td>
	<td colspan='5'><textarea name="impression" rows='2' cols='60'
	onBlur="makeValidString(this);" maxlength=500  onFocus='' onKeyPress=''></textarea></td>
</tr>
<tr style='display:none'>
	<td align="right" valign="middle" class="label">Remarks</td>
	<td colspan='5'><textarea name="disposition" rows='3' cols='60' onBlur="makeValidString(this);" maxlength=500  onFocus='' onKeyPress='' ></textarea></td>
</tr>
</table>

<input type="hidden" name = "Practitioner_Id" value ="<%=Practitioner_Id%>">
<input type="hidden" name = "relationship_id" value ="<%=relationship_id%>">
<input type="hidden" name = "Locn_Code" value ="<%=Locn_Code%>">
<input type="hidden" name = "Locn_Type" value ="<%=Locn_Type%>">
<input type="hidden" name = "Patient_Id" value ="<%=Patient_Id%>">
<input type="hidden" name = "Encounter_Id" value ="<%=Encounter_Id%>">
<input type="hidden" name = "currentdate" value ="<%=currentdate%>">
<input type="hidden" name = "as_evidenced_by_hid" value ="">
<input type="hidden" name = "accry_code" value ="">
<input type="hidden" name = "accry_code_ind" value ="">
<!-- Params for Code Set up...Get papulate from Script file. -->
<input type="hidden" name = "term_set_id" value ="">
<input type="hidden" name = "priority_appl_yn" value ="">
<input type="hidden" name = "nature_appl_yn" value ="">
<input type="hidden" name = "severity_appl_yn" value ="">
<input type="hidden" name = "onset_type_appl_yn" value ="">
<input type="hidden" name = "factors_appl_yn" value ="">
<input type="hidden" name = "notification_appl_yn" value ="">
<input type="hidden" name = "notifiable_yn" value ="<%=notifiable_yn%>">
<!-- hidden fields for search -->
<input type="hidden" name = "dob" value ="<%=dob%>">
<input type="hidden" name = "age" value ="<%=age%>">
<input type="hidden" name = "sex" value ="<%=sex%>">
<input type="hidden" name = "facilityId" value ="<%=facilityId%>">
<input type="hidden" name = "mode" value ="<%=mode%>">
<input type="hidden" name = "modal_yn" value ="<%=modal_yn%>">
<input type='hidden' name='text5' id='text5' value=''>
<input type='hidden' name='text6' id='text6' value=''>
<input type='hidden' name='onset_date_temp' id='onset_date_temp' value='<%=onset_date%>'>	
<input type='hidden' name='status_date_temp' id='status_date_temp' value='<%=status_date%>'>
<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
<input type='hidden' name='status_srl_no' id='status_srl_no' value='<%=srl_no%>'>
<input type='hidden' name='onset_date1' id='onset_date1' value='<%=onset_date%>'>
<input type='hidden' name='pract_retval' id='pract_retval' value=''>
<input type='hidden' name='accession_num' id='accession_num' value=''>
<input type='hidden' name='anesthesia' id='anesthesia' value=''>
<input type='hidden' name='anesthesia_det' id='anesthesia_det' value=''>
<input type='hidden' name='indication' id='indication' value=''>
<input type='hidden' name='record_type' id='record_type' value='O'>
<input type='hidden' name='ca_practitioner_id' id='ca_practitioner_id' value='<%=ca_practitioner_id%>'>
<input type='hidden' name='totalRecords' id='totalRecords' value='1'>
<input type='hidden' name='priority' id='priority' value=''>
<input type='hidden' name='nature' id='nature' value=''>
<input type='hidden' name='start_dt' id='start_dt' value=''>
<input type='hidden' name='end_dt' id='end_dt' value=''>
<input type='hidden' name='multi_session' id='multi_session' value=''>
<input type='hidden' name='consent' id='consent' value=''>
<input type='hidden' name='multi_proc_records' id='multi_proc_records' value=''>
<input type='hidden' name='remarks' id='remarks' value=''>
<input type='hidden' name='reason' id='reason' value=''>
<input type='hidden' name='outcome' id='outcome' value=''>
<input type='hidden' name='status' id='status' value=''>


<%

} 
catch(Exception sqle)
{
	//out.println(sqle.getMessage());//COMMON-ICN-0181
    sqle.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>

</form>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

