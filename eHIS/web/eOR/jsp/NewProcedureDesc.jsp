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
	//String	priority = "";	String	accuracy_code = "";
	//String	remarks = "";	
	String	status_date = "";
	String patient_class	="";	
	String disimage = "display:none";
		
	String def_status	=""; //String date_status	="";
	String def_disable	="";  String occur_srl_no="";
	//String style_def = "";		
	String mode="";
	String modal_yn="";	
	
	//String facility_id=checkForNull((String)session.getValue("facility_id"));
	//String practitioner_type=checkForNull((String)session.getValue("practitioner_type"));
	StringBuffer sql=new StringBuffer(); 

	try
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		currentdate			= dateFormat.format(new java.util.Date()) ;
		onset_date			=currentdate;
		status_date			=currentdate;
		occur_srl_no			=checkForNull(request.getParameter("occur_srl_no"));
		srl_no					= checkForNull(request.getParameter("srl_no"));
		Practitioner_Id			=checkForNull(request.getParameter("Practitioner_Id"));	
		relationship_id		= checkForNull(request.getParameter("relationship_id"));
		Locn_Code			= checkForNull(request.getParameter("location_code"));			
		Locn_Type			= checkForNull(request.getParameter("location_type"));
		Patient_Id				= checkForNull(request.getParameter("patient_id"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		Encounter_Id			= checkForNull(request.getParameter("encounter_id"));
		associate_codes			=checkForNull(request.getParameter("associate_codes"));		
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

		//String term_short_desc = "";
		//String codes = "";			String Aselect ="";			String Pselect ="";
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

<form name='proc_outcome_form' id='proc_outcome_form'  action='' method='get' target=''>
	<table border=0 cellspacing=0 cellpadding = 3 width='100%' style='' id='DiagTable' align=center>
	<tr>
	<td class='label' align='right' width='30%'>Anesthesia</td>
	<td width='70%'><Select name="anesthesia" id="anesthesia"><option value="">-----Select-----</option>
	<%
	String sql1 = "Select LONG_DESC,ANAESTHESIA_CODE from AM_ANAESTHESIA where eff_status='E' order by 1";
    try
	{
		pstmt =con.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rset=pstmt.executeQuery();
		String name="",id="",sel="";
		String anaesthesia_code="";	
		while(rset!=null && rset.next())
		{
			name=rset.getString(1);
			id =rset.getString(2);
			if(mode.equals("update")){
				if (id.trim().equalsIgnoreCase(anaesthesia_code))
					sel="selected";
				else sel="";
			}else{
				sel="";
			}
			out.println("<option value='"+id+"' " + sel +">"+name+"</option>");
		}

		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	}catch(Exception e){
		System.out.println("Exception in Anesthesia.jsp"+e.toString());
	}
    %>
	</Select>
    </td>
	</tr>
	<tr>
	<td class='label' width='10%' align='right' colspan='' nowrap>Anesthesia Details</td>
	<td class='label' width='70%' colspan=''><textarea name="anesthesia_det" rows='1' cols='38'
	onBlur="makeValidString(this);" maxlength=500  onFocus='' onKeyPress=''></textarea>
	</td>
	</tr>
	<tr>
	<td class='label' align='right' width='' colspan='' >Status</td>
	<td class='label' width='' colspan='' >
	<select name="proc_status" id="proc_status" style=''>
		<!-- <option value="">---Select---</option> -->
		<option value="P">In Progress</option>
		<option value="C">Completed</option>
	</select></td>
	
	</tr>
	
	<tr>
	<td class='label' align='right' width='' colspan=''>Outcome</td>
	<td class='label' width='' colspan=''>
	<select name="proc_outcome" id="proc_outcome" onChange="showReason(this)" style=''>
		<option value="" >---Select---</option>
		<option value="E">Effective</option>
		<option value="EC">Effective With Complications</option>
		<option value="I">Ineffective</option>
		<option value="IC">Ineffective With Complications</option>
	</select></td>
	
	</tr>
	<tr style='display:none;' id='tr_reason'>
	<td class='label' align='right' width='' colspan='' ><label id='td_reason_legend' style='visibility:hidden'>Reason</label></td>
	<td class='label' align='left' width='' colspan=''>
		<label id='td_reason' style='visibility:hidden'>
		<select name="proc_reason" id="proc_reason" style='display:none;'>
		<option value="">---Select---</option>
	<%
	if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append("SELECT CONTACT_REASON_CODE,CONTACT_REASON FROM AM_CONTACT_REASON WHERE EFF_STATUS='E'");
    try
	{
		pstmt =con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rset=pstmt.executeQuery();
		String name="",id="";
		while(rset!=null && rset.next())
		{
			id =rset.getString(1);
			name=rset.getString(2);
			out.println("<option value='"+id+"' >"+name+"</option>");
		}
		
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		if(stmt!=null) stmt.close();
	}catch(Exception e){
		System.out.println("Exception "+e.toString());
	}
	
    %>
	</select><img name='man_reason' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img></label></td>
	
	</tr>
	
	<tr style='display:none;' id='tr_remarks'>
	<td class='label' align='right' width='' colspan='' ><label id='td_remarks_legend' style=''>Remarks</label></td>
	<td class='label' align='left' width='' colspan=''>
	<label id='td_remark' style=''><textarea name="remarks" rows='2' cols='38' onBlur="makeValidString(this);" maxlength=500></textarea></label></td>
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
	//out.println(sqle.getMessage());//common-icn-0181
	 sqle.printStackTrace();//COMMON-ICN-0181
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

