<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,java.io.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

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
<script language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../js/NewProcedure.js' ></script>
<script language='javascript' src='../js/NewProcedureMain.js' ></script>
<script language='javascript' src='../../eOR/js/OrCommonFunction.js' ></script>
<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	Connection con      = null;
	//Statement stmt		= null;
	ResultSet rset		= null;
	
	//PreparedStatement stmt2	= null;
	PreparedStatement pstmt	= null;
	//ResultSet rs2	= null;
	String Practitioner_Id="";	String relationship_id	="";
	String Locn_Code	="";	String Locn_Type	="";
	String Patient_Id	="";	String Encounter_Id	="";
	String currentdate	="";	String facilityId ="";
	String dob = ""; String age = "";
	String sex = ""; String associate_codes ="";
	String notifiable_yn;
	
	String term_code = "";	String term_set_id = "";
	//String nature = "";  	
	String onset_date = "";
	String status = "";  	String srl_no = "";     
	
	//String	severity = "";	
	//String	onset_type = "";
	//String	priority = "";	
	//String	accuracy_code = "";
	//String	remarks = "";	
	String	status_date = "";
	String patient_class	="";	
	String disimage = "display:none";
		
	String def_status	=""; //String date_status	="";
	String def_disable	="";  String occur_srl_no="";
	//String style_def = "";		
	String mode="";
	String modal_yn="";	
	
	String facility_id=checkForNull((String)session.getValue("facility_id"));
	String practitioner_type=checkForNull((String)session.getValue("practitioner_type"));
	StringBuffer sql=new StringBuffer(); 
		
	try
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy H:mm" ) ;
		currentdate			= dateFormat.format(new java.util.Date()) ;
		onset_date			=currentdate;
		status_date			=currentdate;
		occur_srl_no		= checkForNull(request.getParameter("occur_srl_no"));
		srl_no				= checkForNull(request.getParameter("srl_no"));
		Practitioner_Id		=checkForNull(request.getParameter("Practitioner_Id"));	
		relationship_id		= checkForNull(request.getParameter("relationship_id"));
		Locn_Code			= checkForNull(request.getParameter("location_code"));			
		Locn_Type			= checkForNull(request.getParameter("location_type"));
		Patient_Id			= checkForNull(request.getParameter("patient_id"));
		patient_class		= checkForNull(request.getParameter("patient_class"));
		Encounter_Id		= checkForNull(request.getParameter("encounter_id"));
		associate_codes		= checkForNull(request.getParameter("associate_codes"));		
		age					= checkForNull(request.getParameter("Age"));	
		dob					= checkForNull(request.getParameter("Dob"));	
		sex					= checkForNull(request.getParameter("Sex"));	
		mode				= checkForNull(request.getParameter("mode"));
		modal_yn			= checkForNull(request.getParameter("modal_yn"));
		notifiable_yn		= checkForNull(request.getParameter("notifiable_yn"));
		
		if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
			Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
		}

		//modal_yn="Y";
		term_set_id			=checkForNull(request.getParameter("term_set_id"));
		if(!term_set_id.equals(""))
			disimage = "display:inline";
		term_code				=checkForNull(request.getParameter("term_code"));

		//String term_short_desc = "";
		//String codes = "";			
		//String Aselect ="";			String Pselect ="";
		//String Wselect ="";			String pri_N_select ="";	String pri_H_select ="";
		//String pri_C_select ="";	String sevr_L_select ="";	String sevr_D_select ="";
		//String sevr_S_select ="";	String sevr_E_select ="";	String stus_A_select ="";
		//String stus_R_select ="";	String stus_X_select ="";	String stus_E_select ="";

		//String type_A_select = "";	String type_C_select = "";	
		String mandatory_status	=""; 
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
		
	
	
	
		def_disable="";			def_status	="";
		mandatory_status="";	mandatory_disable	="";
		def_select = "selected";
	
%>

<form name='RecDaignosis_form' id='RecDaignosis_form'  action='' method='get' target='messageFrame'>

<table border=0 cellspacing=3 cellpadding = 0 width='100%' style='<%//=disimage%>' id='DiagTable' align=center>
	<!-- <tr height='1'> 
	<th colspan='10' align='left' style='BACKGROUND-COLOR: #ffc5b5;COLOR: black;'><font='verdana' size=2 align='top'>New Procedure</font></th></th>
	</tr> -->
<tr>
		<td class='label' align='right' width='10%'>Code</td>
		<td width='20%'><input type='text' value='' onClick="" name='proc_text' id='proc_text'><input type='button' class='button' value='?' onClick="callTermCode()" name='procedure' id='procedure'>
	<select name="code_set" id="code_set" <%if(mode.equals("modify") ||modal_yn.equals("Y"))%><%=mandatory_disable%>  onChange="showProcedure(this)" >
		<option value=''>----- Select -----</option>
		<%
			//stmt = con.createStatement();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select a.term_set_id,priority_appl_yn||'='||nature_appl_yn||'='||severity_appl_yn||'='||onset_type_appl_yn||'='||factors_appl_yn||'='||notification_appl_yn term_set_id1,term_set_desc "); 
			sql.append("from mr_term_set a where exists (select 1 from mr_term_set_for_facility where FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from "); sql.append("mr_term_set_for_pract_type where PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from mr_term_set_for_specialty where"); 
			sql.append(" SPECIALTY_CODE in (select SPECIALTY_CODE from pr_encounter where "); sql.append(" facility_id=? and encounter_id=?) AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from mr_term_set_for_pract ib  where PRACTITIONER_ID=? AND "); 
			sql.append(" TERM_SET_ID=A.TERM_SET_ID or not exists (select 1 from "); 
			sql.append(" mr_term_set_for_pract  where PRACTITIONER_ID=ib.PRACTITIONER_ID) ) and "); sql.append(" Eff_status='E' and diag_spec_yn='Y' order by term_set_desc");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,practitioner_type);
			//System.out.println("practitioner_type--------->>>"+practitioner_type);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,Encounter_Id);
			//System.out.println("Encounter_Id--------->>>"+Encounter_Id);
			pstmt.setString(5,Practitioner_Id);
			//System.out.println("Practitioner_Id--------->>>"+Practitioner_Id);
					
			rset = pstmt.executeQuery();
			//System.out.println("rset--------->>>"+rset.next());
			while(rset.next())
			{
				String desc = rset.getString("term_set_desc");
				String code = rset.getString("term_set_id");
				
				String code1 = rset.getString("term_set_id1");
				String sel = "";
					
				if(term_set_id.equals(code))
				{
					out.print("<option value='"+code+"' id='"+code1+"' selected >"+desc+"</option>");
				}
				else
				{
					out.print("<option value='"+code+"'"+sel+" id='"+code1+"'>"+desc+"</option>");
				}
			}
			if(rset	!= null)   rset.close();
			if(pstmt  != null)   pstmt.close();		
		%>
        </select><img align='center' src='../../eCommon/images/mandatory.gif'> -->
    </td>
	
	<td class='label' width='20%' align='right' colspan=''>Multi-Session</td>
	<td class='label' width='20%' colspan=''><input type='checkbox' value='N' onClick="showSession(multi_session)" name='multi_session' id='multi_session'><input type='button' class='button' value='?' onClick="" name='multi_session_btn' id='multi_session_btn' style="visibility:hidden">
		Consent<input type='checkbox' value='N' name='consent' id='consent'>
	</td>
	<td class='label' width='30%'align='' colspan=''>Nature<select name="nature" id="nature" onchange='showNature(this)'>
			<option value=''>-----Select-----</option>
			<option value='D'>Diagnostic </option>
			<option value='T'>Therapeutic</option>
		</select><input type='button' class='button' value='?' onClick="" name='nature_btn' id='nature_btn' style="visibility:hidden">
	</td>
	
	</tr>
	<tr>
	<td class='label' align='right' width='' nowrap>Start From</td>
	<td class='label' width=''><input type='text' name='onset_date' id='onset_date' value='<%=currentdate%>' size="14" maxlength="16" onBlur="checkValidDateTime(this);calEndDate('')" onKeyPress='return AllowDateFormat()'><img" src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('onset_date',null,'hh:mm');" onblur='onset_date.focus()' style='cursor:pointer'>
    </td>
	
	<td class='label' width='' align='' colspan='2' nowrap>Duration<!-- </td>
	<td class='label' width='30%' colspan=''> --><input type="text" name="hrs" id="hrs"  maxlength="2" size="2" value='' onBlur="calEndDate('')" onKeyPress='return OrAllowPositiveNumber()' ><font size="1">Hrs.</font><input type="text" name="mins" id="mins"  maxlength="2" value='' size="2" onKeyPress='return OrAllowPositiveNumber()'  onBlur="calEndDate('')" ><font size="1">Mins.</font>
	To<input type='text' name='end_date' id='end_date' value='<%//=currentdate%>' size="14" maxlength="16" onBlur="checkValidDateTime(this);CalculateDuration('')" onKeyPress='return AllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('end_date',null,'hh:mm');" onblur='end_date.focus()' style='cursor:pointer'>
	</td>
	<td class='label' width=''align='' colspan=''>Priority<select name="priority" id="priority">
			<option value="1">Elective</option>
			<option value="5">Emergency</option>
			<option value="7">Semi-Critical</option>
			<option value="9">Critical</option>
	</select>
	</td>
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

<!--  hidden fields requeried to populate external diag -->
<input type='hidden' name='associate_codes' id='associate_codes' value='<%=associate_codes%>'>
<input type='hidden' name='associate_codes_modify' id='associate_codes_modify' value='<%=associate_codes%>'>
<input type='hidden' name='code_indicator' id='code_indicator' <%if(mode.equals("modify")){ %>value='<%=code_ind%>'<%} else{%> value='' <%}%>>
<input type='hidden' name='diff_group_id_hid' id='diff_group_id_hid' value='<%=diff_group_id%>'>
<input type='hidden' name='occur_srl_no_hid' id='occur_srl_no_hid' value='<%=occur_srl_no%>'>
<input type='hidden' name='expandcollapse' id='expandcollapse' value='C'></input>
<input type='hidden' name='curr_encr_flag' id='curr_encr_flag' value=''></input>
<input type='hidden' name='diff_group_vals' id='diff_group_vals' value=''></input>

<%

} 
catch(Exception sqle)
{
	out.println(sqle.getMessage());
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>
<!-- <script>setTimeout("getCodeSet()",300);</script> -->
<script>//getAccuracy_code();</script>
<%if(mode.equals("modify") && status.equals("A")) {%>
<script>setStatus();getCodeSet();</script>
<%}%>
<%if(!mode.equals("modify")){%>
<script>//check_enc();getCodeSet();</script>
<%}%> 
<%if(mode.equals("modify")){%>
<script>expandColapseframe('E');onload_display();</script>
<%}%>
<%if(modal_yn.equals("Y"))
{%>
<script>getDescription();</script>
<%}%>
</font>
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

