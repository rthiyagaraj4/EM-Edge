<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="MedicalReportReq" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

String title =request.getParameter("title")==null?"":request.getParameter("title");	

if(!title.equals(""))
{
	out.println("<title>"+title+"</title>");
}

	String classValue	 = "";
	StringBuffer sqlbuff = new StringBuffer();
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	
	String criteria =request.getParameter("criteria")==null?"":request.getParameter("criteria");	
	String jsp_name =request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");	
//	String flagSelect = request.getParameter("fromSelect")==null?"":request.getParameter("fromSelect");
	String finalSelect="",temp1="";

	String selectAll_yn=request.getParameter("selectAll_yn")==null?"":request.getParameter("selectAll_yn");
	if(selectAll_yn == null) selectAll_yn="";
	finalSelect=request.getParameter("finalSelect")==null?"":request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";
	
	String Enc_Type=request.getParameter("lstPatientClass")==null?"":request.getParameter("lstPatientClass");

	String orderBy=request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	if(orderBy == null || orderBy.equals("ET")) 
		orderBy = " to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') desc";
	else if(orderBy.equals("ED")) 
		orderBy = "a.visit_adm_date_time desc";

	String cause_ind	=	request.getParameter("cause_ind")==null?"":request.getParameter("cause_ind");
	String alt_id1_exp_date=request.getParameter("alt_id1_exp_date")==null?"":request.getParameter("alt_id1_exp_date");
	if(alt_id1_exp_date == null) alt_id1_exp_date="";

	String alt_id2_exp_date=request.getParameter("alt_id2_exp_date")==null?"":request.getParameter("alt_id2_exp_date");
	if(alt_id2_exp_date == null) alt_id2_exp_date="";
	
	String p_discharge_date_from=request.getParameter("p_discharge_date_from")==null?"":request.getParameter("p_discharge_date_from");

	String p_discharge_date_to=request.getParameter("p_discharge_date_to")==null?"":request.getParameter("p_discharge_date_to");
	

	String national_id_no=request.getParameter("national_id_no")==null?"":request.getParameter("national_id_no");
	if(national_id_no == null) national_id_no="";

	String alt_id1_no=request.getParameter("alt_id1_no")==null?"":request.getParameter("alt_id1_no");
	if(alt_id1_no == null) alt_id1_no="";
	
	String alt_id2_no=request.getParameter("alt_id2_no")==null?"":request.getParameter("alt_id2_no");
	if(alt_id2_no == null) alt_id2_no="";
	
	String alt_id3_no=request.getParameter("alt_id3_no")==null?"":request.getParameter("alt_id3_no");
	if(alt_id3_no == null) alt_id3_no="";
	
	String alt_id4_no=request.getParameter("alt_id4_no")==null?"":request.getParameter("alt_id4_no");
	if(alt_id4_no == null) alt_id4_no="";

	String other_alt_type	=request.getParameter("other_alt_type")==null?"":request.getParameter("other_alt_type");
	if(other_alt_type == null) other_alt_type="";
	String other_alt_Id		=request.getParameter("other_alt_Id")==null?"":request.getParameter("other_alt_Id");
	if(other_alt_Id == null) other_alt_Id="";

	temp1=request.getParameter("temp1")==null?"":request.getParameter("temp1");
	if(temp1 == null) temp1="";


	String mlc_oscc = request.getParameter("marked_status")==null?"":request.getParameter("marked_status");
	String flag="";
	flag=(request.getParameter("flag")==null) ? "" : request.getParameter("flag");

	String  req_start   =   "", req_end     =   "";
    String  checkedOnes         =   "";

    req_start       =   (request.getParameter("from")==null)   ?   "0" :   request.getParameter("from");
    req_end         =   (request.getParameter("to")==null)     ?   "0" :   request.getParameter("to");

	if( jsp_name == null) jsp_name="";
	String window_styl=request.getParameter("window_styl");
	if( window_styl == null) window_styl="";
	String close_yn	=request.getParameter("close_yn");
	if( close_yn == null) close_yn="";
	String win_top =request.getParameter("win_top");
	if( win_top == null) win_top="";
	String win_height =request.getParameter("win_height");
	if(win_height ==null) win_height="";
	String dialogTop =request.getParameter("dialogTop");
	if(dialogTop ==null) dialogTop="";
	String win_width =request.getParameter("win_width");
	if( win_width == null) win_width="";
	String modal=request.getParameter("modal");
	if(modal == null) modal="";
	String module=request.getParameter("module");
	if(module == null) module="";
	String model_window=request.getParameter("model_window");
	if( model_window == null) model_window="";
	String function_id=request.getParameter("function_id");
	if( function_id == null) function_id="";

	String prog_id=request.getParameter("prog_id");
	if( prog_id == null) prog_id="";
	String p_practitioner_id=request.getParameter("practitioner_id");
	if( p_practitioner_id == null) p_practitioner_id="";
	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";

	String no_of_days			=request.getParameter("no_of_days");
	if(no_of_days == null) no_of_days="";
	
//	String sql = "";
	String PatientId		=	request.getParameter("PatientId") ;
	if(PatientId	== null || PatientId.equals("null"))		
		PatientId = "";		
	
	String EncounterId		=	request.getParameter("p_encounter_id") ;
	if(EncounterId	== null || EncounterId.equals("null"))		
		EncounterId = "";

	String AdmissionDate	=	request.getParameter("AdmissionDate")==null?"":request.getParameter("AdmissionDate") ;
	
	String DischargeDate	=	request.getParameter("DischargeDate") ;

	if(AdmissionDate == null || AdmissionDate.equals("null"))	AdmissionDate = "";
	if(DischargeDate	== null || DischargeDate.equals("null"))DischargeDate = "";

	String whereClause = request.getParameter("whereclause");
	if(whereClause	== null || whereClause.equals("null"))	
	{
		whereClause= "";
	}
	else
	{
		//sql = whereClause;
	}

	String from = checkForNull(request.getParameter( "from" )) ;
	String to = checkForNull(request.getParameter( "to" )) ;
	String modal_yn = checkForNull(request.getParameter("modal_yn")) ;
	String install_yn="";
	if(modal_yn.equals("Y"))
		install_yn =checkForNull(request.getParameter( "bl_install_yn" )) ;


	int start = 0 ;
	int end = 0 ;
    int i=1;


	if ( from == null )
		start = 1 ;
	else
	{
		if(from.equals(""))start=1;
		else
		start = Integer.parseInt( from ) ;
	}

	if ( to == null )
		end = 10 ;
	else
	{
		if(to.equals(""))end=10;
		else
		end = Integer.parseInt( to ) ;
	}

	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	Statement stmt_bl = null;
	ResultSet rs_bl=null;

	Connection conn = ConnectionManager.getConnection(request);	
try
{
//	int recordCount			=	0;
	if(from != null && to != null)
	{
		 int j=0;
		 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		 {
			 if(request.getParameter("chk"+(i)) != null)
			 {
				 checkedOnes = request.getParameter("chk"+(i));
				 if(!(MedicalReportReq.containsObject(checkedOnes)))
				 {
					 MedicalReportReq.putObject(checkedOnes);
				 }
				 j++;
			 }
		 }	
		 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
		i = 1 ;
//Check for bl_interfaced_yn condition.......added by kishore
	if(!modal_yn.equals("Y"))
	{
		String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from ip_param where facility_id='"+FacilityId+"'";
		try
		{
			stmt_bl=conn.createStatement();
			rs_bl=stmt_bl.executeQuery(query_bl_interface);
			if(rs_bl.next())
			{
				install_yn=rs_bl.getString("bl_interfaced_yn");
			}
		
		if(rs_bl != null) rs_bl.close();
		if(stmt_bl != null) stmt_bl.close();
		}
		catch(Exception e)
		{
			//out.println("Exception @try1"+e);
			e.printStackTrace();
		}
	}
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<head>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eOA/js/QueryLocnForDay.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	 <script language='javascript' src="../js/MedRecRequestMain.js"></script>
  <script language='javascript' src="../js/RecordAdverseEventCriteria.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	
</head>
<body OnMouseDown='CodeArrest();' onLoad='chkForSelectAll(<%=start%>,<%=end%>)' onKeyDown='lockKey()'>
<form name='MedRecRequestResult' id='MedRecRequestResult'  action="../../eMR/jsp/MedRecRequestResult.jsp" method="post"  >
<%
		String Where  = "";

		Where  = " where a.patient_id=b.patient_id and b.patient_id like '"+PatientId+"%' and a.facility_id='"+FacilityId+"' ";

if(call_function.equals("QUERY_MATERNAL_REPORT")) 
{	
	if(cause_ind.equals(""))
	{
		Where = Where + " and disposition_type in ( select discharge_type_code from ip_discharge_type where maternal_death_yn = 'Y' and eff_status = 'E') ";
	}
	else
	{
		Where = Where + " and disposition_type ='"+cause_ind+"'  ";
	}
}

if ( !(Enc_Type == null || Enc_Type.equals("")) )
{
	Where = Where + " and upper(PATIENT_CLASS) like upper('"+Enc_Type+"%') ";
}

if ( !(EncounterId == null || EncounterId.equals("")) )
{
	Where = Where + " and upper(a.encounter_id) like upper('"+EncounterId+"%') ";
}

if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) )
{
	Where = Where + " and a.visit_adm_date_time >= to_date('"+alt_id1_exp_date+"','dd/mm/yyyy hh24:mi')";
}


if ( !(alt_id2_exp_date == null || alt_id2_exp_date.equals("")) )
{
	Where = Where + " and a.visit_adm_date_time <= to_date('"+alt_id2_exp_date+"','dd/mm/yyyy hh24:mi')";
}

if ( !(p_discharge_date_from == null || p_discharge_date_from.equals("")) )
{
	Where = Where + " and a.DISCHARGE_DATE_TIME >= to_date('"+p_discharge_date_from+"','dd/mm/yyyy hh24:mi')";
}

if ( !(p_discharge_date_to == null || p_discharge_date_to.equals("")) )
{
	Where = Where + " and a.DISCHARGE_DATE_TIME <= to_date('"+p_discharge_date_to+"','dd/mm/yyyy hh24:mi')";
}

if ( !(national_id_no == null || national_id_no.equals("")) )
{
	Where = Where + " and upper(b.NATIONAL_ID_NO) like upper('"+national_id_no+"%') ";
}
if ( !(alt_id1_no == null || alt_id1_no.equals("")) )
{
	Where = Where + " and upper(b.alt_id1_no) like upper('"+alt_id1_no+"%') ";
}
if ( !(alt_id2_no == null || alt_id2_no.equals("")) )
{
	Where = Where + " and upper(b.alt_id2_no) like upper('"+alt_id2_no+"%') ";
}
if ( !(alt_id3_no == null || alt_id3_no.equals("")) )
{
	Where = Where + " and upper(b.alt_id3_no) like upper('"+alt_id3_no+"%') ";
}
if ( !(alt_id4_no == null || alt_id4_no.equals("")) )
{
	Where = Where + " and upper(b.alt_id4_no) like upper('"+alt_id4_no+"%') ";
}

if ( !(other_alt_type == null || other_alt_type.equals("")) )
{
	Where = Where + " and upper(b.oth_alt_id_type) like upper('"+other_alt_type+"%') ";
}
if ( !(other_alt_Id == null || other_alt_Id.equals("")) )
{
	Where = Where + " and upper(b.oth_alt_Id_no) like upper('"+other_alt_Id+"%') ";
}

if(call_function.equals("QUERY_MARK_MLC_OSCC"))
{
	if(PatientId.equals("") && EncounterId.equals(""))
	{
		if (mlc_oscc.equals(""))
		{
			Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";
		}	
		else if (mlc_oscc.equals("O"))
		{
			Where = Where + "and a.oscc_yn = 'Y' ";
		}	
		else if (mlc_oscc.equals("M"))
		{
			Where = Where + "and a.mlc_yn='Y' ";
		}	
	}
	else if (!PatientId.equals("") && !EncounterId.equals(""))
	{
		if (mlc_oscc.equals("")){Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";}	
		else if (mlc_oscc.equals("O")){Where = Where + "and a.oscc_yn = 'Y' ";}	
		else if (mlc_oscc.equals("M")){Where = Where + "and a.mlc_yn='Y' ";}	
	}
	else if (!PatientId.equals(""))
	{
		if (mlc_oscc.equals("")){Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";}	
		else if (mlc_oscc.equals("O")){Where = Where + "and a.oscc_yn = 'Y' ";}	
		else if (mlc_oscc.equals("M")){Where = Where + "and a.mlc_yn='Y'";}	
	}
}


if ( !(orderBy == null || orderBy.equals("")) )
{
	Where = Where + " order by "+orderBy+" ";
}
	int maxRecord = 0;
	if(!modal_yn.equals("Y"))
	{
			if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
			sqlbuff.append("select count(1) from  pr_encounter a, mp_patient b");
			sqlbuff.append(Where);
		/*sql = "select count(1) from  pr_encounter a,mp_patient b,am_speciality d,am_practitioner e,op_clinic f,ip_nursing_unit g,am_patient_class h " + Where;*/

		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();

		pstmt = conn.prepareStatement(sqlbuff.toString());
		rs = pstmt.executeQuery();

		if(rs.next())
		   maxRecord = rs.getInt(1);
	}
	if (maxRecord==0 && !modal_yn.equals("Y"))
	{			
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));//document.location.href='../../eCommon/html/blank.html'</script>");
	}
	else
	{
	    if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
		sqlbuff.append("select a.patient_id,b.patient_name,decode (b.sex,'M','Male','F','Female','U','Unknown')gender,");
		sqlbuff.append("to_char(b.date_of_birth,'dd/mm/yy')birth_date,  ");
		sqlbuff.append("to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') encounter_date,");
		sqlbuff.append("a.encounter_id, (CASE WHEN a.specialty_code IS NOT NULL THEN (SELECT short_desc FROM am_speciality WHERE speciality_code = a.specialty_code)END) speciality_desc,");
		sqlbuff.append("(CASE WHEN a.assign_care_locn_type = 'C' THEN (SELECT short_desc FROM op_clinic WHERE facility_id = a.facility_id AND clinic_code = a.assign_care_locn_code) WHEN assign_care_locn_type = 'N' THEN (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = a.assign_care_locn_code) END ) locn_desc,");
		sqlbuff.append("(CASE WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner  WHERE practitioner_id = a.attend_practitioner_id) END) practitioner_name,(CASE WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT PRACT_TYPE FROM am_practitioner  WHERE practitioner_id = a.attend_practitioner_id) END) practitioner_type, a.assign_room_num room_no, a.assign_bed_num bed_no, DECODE (a.assign_care_locn_type,'C', 'Clinic','N', 'Nursing Unit') locn_type, b.alt_id1_no alt_id1_no, b.alt_id2_no alt_id2_no, b.alt_id3_no alt_id3_no, b.alt_id4_no alt_id4_no,(CASE WHEN a.patient_class IS NOT NULL THEN (SELECT short_desc FROM am_patient_class WHERE patient_class = a.patient_class) END ) patient_class, a.patient_class patient_class_code, TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time,a.attend_practitioner_id FROM pr_encounter a, mp_patient b ");

		sqlbuff.append(Where);

 
	if(rs != null)rs.close();
	if(pstmt  != null)pstmt.close();
	pstmt = conn.prepareStatement(sqlbuff.toString());
	rs = pstmt.executeQuery();

	if(!flag.equals("true"))
	{
		if(!PatientId.equals(""))
		{	%>
			<table border="1" cellpadding="0" cellspacing="0" align='center' width="100%">
			<tr>
		<%	if(!call_function.equals("QUERY_MATERNAL_REPORT"))
			{	%>
				<td>	
				<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="Patient_ID" value="<%=PatientId%>" />				
				</jsp:include> 			
				</td>
		<%	}	%>
			</tr></table>
	<%	}	%>		
		<table align='right'>
		<tr>
		<td>
		<%
		if ( !(start <= 1) )
			out.println("<A HREF=\"javascript:submitPrevNext("+(start-10)+","+(end-10)+")\" text-decoration='none'>Previous</A>");
		if ( !( (start+10) > maxRecord ) )
			out.println("<A HREF=\"javascript:submitPrevNext("+(start+10)+","+(end+10)+")\" text-decoration='none'>Next</A>");
		%>
			</td>
		</tr>
		</table><br><br>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>

<%	if(!call_function.equals("QUERY_MATERNAL_REPORT"))
	{	%>
			<th align='center' nowrap>&nbsp;</th>
<%	}	%>
<% if(	!call_function.equals("MARK_MLC_OSCC") && 
		!call_function.equals("DIAG_RECODE") && !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")&&
		!call_function.equals("QUERY_MARK_MLC_OSCC") &&
		!call_function.equals("QUERY_MATERNAL_REPORT") )
		{	%>
			<th align='center' nowrap>&nbsp;Select All&nbsp;<BR><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,"<%=start%>","<%=end%>");'></th>
	<%	}	%>
			<th align='center' nowrap>Encounter Date</th>
<%	if(!call_function.equals("QUERY_MARK_MLC_OSCC")) 
	{	%>
			<th align='center' nowrap>Encounter Type</th>
<%	}	%>		<th align='center' nowrap>Encounter ID</th>
<%	if(call_function.equals("QUERY_MARK_MLC_OSCC"))
	{
		if (PatientId.equals("")) 
		{	%>
 			<th align='center' nowrap>Patient ID</th> 
<%		} 
	}	
	if(call_function.equals("QUERY_MATERNAL_REPORT"))
	{	%>
			<th align='left' nowrap>Patient Name</th>
<%	}	
	if(!call_function.equals("QUERY_MATERNAL_REPORT")&&!call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE")&&!call_function.equals("QUERY_MARK_MLC_OSCC"))
	{	%>
			<th align='center' nowrap>Location Type</th>
<%	}	%>
			<th align='center' nowrap>Location</th>
			<th align='center' nowrap>Speciality</th>
			<th align='center' nowrap>Room</th>
			<th align='center' nowrap>Bed</th>
			<th align='center' nowrap>Practitioner</th>
		<%
//		String classValue	 = "";
		String chkAttribute = "";
		if ( rs != null )
		{
			if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

				while ( rs.next() && i<=end )
				{
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					String Patient_ID=rs.getString("patient_id");				
					String Patient_Name=rs.getString("patient_name");				
					String conGender=rs.getString("gender");				
					String Date_of_Birth=rs.getString("birth_date");				
					String Patient_Class=rs.getString("patient_class");	
					String Encounter_Date=rs.getString("encounter_date");				
					String Encounter_ID=rs.getString("encounter_id");				
					String con_Speciality=rs.getString("speciality_desc");				
					String con_Location=rs.getString("locn_desc");				
					String con_Practitioner=rs.getString("practitioner_name");				
					String practitioner_type=rs.getString("practitioner_type");	
					String patient_class=rs.getString("PATIENT_CLASS");	
					String room_no=rs.getString("room_no");				
					String bed_no=rs.getString("room_no");				
					String locn_type=rs.getString("locn_type");		
					String Encounter_Type = rs.getString("locn_type");
					String Patient_Class_code= rs.getString("patient_class_code");
					String attend_practitioner_id= rs.getString("attend_practitioner_id");

//		recordCount =	MedicalReportReq.getSize();
		if(MedicalReportReq.containsObject(Encounter_ID))  
			chkAttribute = "CHECKED";
		else
			chkAttribute="";

		int recordIndex = MedicalReportReq.indexOfObject(Encounter_ID);
		if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED"))    									    	MedicalReportReq.removeObject(recordIndex);


/*
					String alt_id1_no=rs.getString(15);				
					String alt_id2_no=rs.getString(16);				
					String alt_id3_no=rs.getString(17);				
					String alt_id4_no=rs.getString(18);				
					//String con_Select=rs.getString(10);				
*/


					if(Patient_ID==null	      || Patient_ID.equals("null"))		    
						Patient_ID = "";
					if(Patient_Name==null	  || Patient_Name.equals("null"))				Patient_Name = "";
					if(conGender==null	      || conGender.equals("null"))		    
						conGender = "";
					if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
						Date_of_Birth = "";
					if(Patient_Class==null	  || Patient_Class.equals("null"))
						Patient_Class = "";
					if(Encounter_Date==null	  || Encounter_Date.equals("null"))
						Encounter_Date = "";
					if(Encounter_ID==null	  || Encounter_ID.equals("null"))
						Encounter_ID = "";
					if(con_Speciality==null	  || con_Speciality.equals("null"))
						con_Speciality = "&nbsp;";
					if(con_Location==null	  || con_Location.equals("null"))
						con_Location = "&nbsp;";
					if(con_Practitioner==null || con_Practitioner.equals("null"))
						con_Practitioner = "&nbsp;";
					if(room_no==null || room_no.equals("null"))
						room_no = "&nbsp;";
					if(bed_no==null || bed_no.equals("null"))
						bed_no = "&nbsp;";
					if(locn_type==null || locn_type.equals("null"))
						locn_type = "&nbsp;";
					if(Encounter_Type==null || Encounter_Type.equals("null"))
						Encounter_Type = "&nbsp;";
		out.println("<tr>");
		if(!call_function.equals("QUERY_MATERNAL_REPORT"))
		{
			out.println("<td align='left' class='"+classValue+"'>");
			out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"')\">");	
			out.print("+</a></td>");				
		}

		if(!call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")  && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT") )
		{
			out.println("<td align=middle nowrap class='"+classValue+"'><input type=checkbox name='chk"+i+"' id='chk"+i+"' value='"+i+"' onClick='javascript:RemSelectAll();chkServices(this);' /></td>");
		}

		out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");

		if(!call_function.equals("QUERY_MARK_MLC_OSCC"))
		{
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				//Patient_Class--Encounter_Type
		}
		if(call_function.equals("MARK_MLC_OSCC") )
		{
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','MARK_MLC_OSCC','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
		}
		else if(call_function.equals("DIAG_RECODE"))
		{
			out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecodeDiagnosis('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
		}		
		else if(call_function.equals("MR_ALLERGY_RECORDING"))
		{
			out.println("<td nowrap class='"+classValue+"'><a href=javascript:AdverseEvent('"+Encounter_ID+"','"+Patient_ID+"','"+attend_practitioner_id+"','"+practitioner_type+"','"+Patient_Class_code+"')>"+Encounter_ID+"</a></td>");
		}
		else if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
		{
			out.println("<td nowrap class='"+classValue+"'><a href=javascript:DiagnososConfirmationDtls('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
		}
		else if(call_function.equals("QUERY_MARK_MLC_OSCC"))
		{
			if (!PatientId.equals(""))
			{
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
			}
			else if(PatientId.equals(""))
			{
				out.println("<td nowrap class='"+classValue+"'>"+Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"')>"+Patient_ID+"</a></td>");
			}
		}
		else if(call_function.equals("QUERY_MATERNAL_REPORT"))
		{	
			out.println("<td align='left' class='"+classValue+"'>");
			out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+""+"')\">");	
			out.print(""+Encounter_ID+"</a></td>");
		}
		else
		{
			out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
		}
		if(call_function.equals("QUERY_MATERNAL_REPORT"))
		{	
			out.println("<td nowrap class='"+classValue+"'>" +Patient_Name+"</td>");
		}
		if(!call_function.equals("QUERY_MATERNAL_REPORT")&&!call_function.equals("MEDICAL_REPORT_REQUEST")&&!call_function.equals("MARK_MLC_OSCC")&&!call_function.equals("DIAG_RECODE")&&!call_function.equals("QUERY_MARK_MLC_OSCC"))
		{	
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"</td>");
				//Encounter_Type-Patient_Class
		}

				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"/"+con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +room_no+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +bed_no+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+con_Practitioner+"</td>");
				out.println("</tr>");
				i++;
			}
		}

	%>
	</table>
<%	}
	else //if(flag.equals("true"))
	{
	/// DISPLAY IN MODAL WINDOW
	%>
		<!-- <table align='right'>
			<tr>
			<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="Patient_ID" value="<%=PatientId%>" />
			</jsp:include> 
			</tr>
		</table> -->
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<TR><td colspan=6 class="white">&nbsp;</td></TR>
		</table>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<TR>
<!-- 		<th align='center' nowrap>Patient ID</th> -->
			<th align='center' nowrap>Encounter Type</th> 
			<th align='center' nowrap>Admission Date</th> 
			<th align='center' nowrap>Encounter ID</th>
			<th align='center' nowrap>Location Type</th>
			<th align='center' nowrap>Location</th>
			<th align='center' nowrap>Practitioner</th>
			<th align='center' nowrap>Speciality</th>
			<th align='center' nowrap>Discharge Date</th>
		</TR>
			<input type='hidden' name='tempIDS' id='tempIDS'  >
			<input type='hidden' name='encIDS' id='encIDS' >
		<%

	if(!finalSelect.equals("SELECTALL"))
	{
		TreeMap ssm=new TreeMap();
		String selitem="";
		selitem=(request.getParameter("selitem")==null) ? "" : request.getParameter("selitem");
		selitem=selitem.substring(1);
		selitem=selitem.substring(0,selitem.length()-1);
		
		StringTokenizer st=new StringTokenizer(finalSelect,"~");

		int temp=st.countTokens();
		String practId="";
		/*String objName="";*/
		String enable_dis="";
		for(int u2=0;u2<temp;u2++)
		{
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			practId=st1.nextToken();
			st1.nextToken();
			enable_dis=st1.nextToken();
			if(enable_dis.equals("E"))
			ssm.put(practId,practId);
			else
			{
				if(ssm.containsKey(practId))
				ssm.remove(practId);
			}
		}


		//StringTokenizer st=new StringTokenizer(selitem,",");
		/*st=new StringTokenizer(selitem,",");
		while(st.hasMoreTokens())
		{
			String key=st.nextToken();			
			ssm.put(key,key);
		}*/

		if (rs != null)
		{
			//if (start != 1 )
			//for(int j=1; j<start; i++,j++ )
			//rs.next() ;
			int clsCnt=1;

		while(rs.next())
		{
			if(ssm.containsKey(new String(i+"")))
			{
				
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				String Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				String Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
				String con_Location=rs.getString("locn_desc");				
				String con_Practitioner=rs.getString("practitioner_name");				
				String locn_type=rs.getString("locn_type");	
				if(locn_type==null	      || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("discharge_date_time");	
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
					Dis_dateTime = "&nbsp;";

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))		Patient_Name = "&nbsp";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "&nbsp";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))		Date_of_Birth = "&nbsp;";
				if(Patient_Class==null	  || Patient_Class.equals("null"))		Patient_Class = "";
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))		Encounter_Date = "";
				if(Encounter_ID==null	  || Encounter_ID.equals("null"))		Encounter_ID = "";
				if(con_Speciality==null	  || con_Speciality.equals("null"))		con_Speciality = "&nbsp;";
				if(con_Location==null	  || con_Location.equals("null"))		con_Location = "&nbsp;";
				if(con_Practitioner==null || con_Practitioner.equals("null"))	con_Practitioner = "&nbsp;";
				out.println("<tr>");				
//			out.println("<td nowrap class='"+classValue+"'>" +Patient_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime+"</td>");
				out.println("</tr>");
				clsCnt++;
	%>
		<script>
			enc_id	= '<%=rs.getString("encounter_id")%>';
			document.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+"|";
//			alert("encIDS.value after adding : "+document.forms[0].encIDS.value)
		</script>
	<%
				}
				i++;
			}
			if(clsCnt == 1)
			{
				out.println("<script>alert('Encouter has to be selected for Medical Report Request');parent.window.close();</script>");
				//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));parent.window.close();</script>");
			}
		}
	}
	else if(finalSelect.equals("SELECTALL"))
	{
//		out.println("<script>alert('SelectAll is Checked...Page Under Construction')</script>");

		if (rs != null)
		{
			int clsCnt=1;
			while(rs.next())
			{
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				String Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				String Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
				String con_Location=rs.getString("locn_desc");				
				String con_Practitioner=rs.getString("practitioner_name");			
				String locn_type=rs.getString("locn_type");		
				if(locn_type==null || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("DISCHARGE_DATE_TIME");	
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
					Dis_dateTime = "&nbsp;";

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))
					Patient_Name = "";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
					Date_of_Birth = "";
				if(Patient_Class==null	  || Patient_Class.equals("null"))
					Patient_Class = "";
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))
					Encounter_Date = "";
				if(Encounter_ID==null	  || Encounter_ID.equals("null"))
					Encounter_ID = "";
				if(con_Speciality==null	  || con_Speciality.equals("null"))
					con_Speciality = "";
				if(con_Location==null	  || con_Location.equals("null"))
					con_Location = "";
				if(con_Practitioner==null || con_Practitioner.equals("null"))
					con_Practitioner = "";
				out.println("<tr>");				
//				out.println("<td nowrap class='"+classValue+"'>" +Patient_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime+"</td>");
				out.println("</tr>");

%>
		<script>
			enc_id	= "<%=Encounter_ID%>";
			document.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+"|";
//			alert("encIDS.value after adding : "+document.forms[0].encIDS.value)
		</script>
	<%	

				clsCnt++;
				i++;
			}
		}
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
	}// E.O SelectAll
	%></TABLE>
<%	}
	%>
	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
	<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
	<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
	<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
	<input type='hidden' name='module' id='module' value="<%=module%>" >
	<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='no_of_days' id='no_of_days' value="<%=no_of_days%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
	<input type='hidden' name='bl_install' id='bl_install' value="<%=install_yn%>" >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=p_practitioner_id%>" >
	<input type='hidden' name='total_count' id='total_count' value="<%=(i-1)%>" >
	<input type='hidden' name='PatientId' id='PatientId' value="<%=PatientId%>" >
	<input type='hidden' name='from' id='from' value="<%=start%>" >
	<input type='hidden' name='to' id='to' value="<%=end%>" >
	<input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect%>'>
	<input type='hidden' name='temp1' id='temp1' value='<%=temp1%>'>
	<input type='hidden' name='criteria' id='criteria' value='<%=criteria%>'>

	<!-- <input type='hidden' name='EncounterId' id='EncounterId' value='<%=EncounterId%>'> -->
	<input type='hidden' name='lstPatientClass' id='lstPatientClass' value="<%=Enc_Type%>" >
	<input type='hidden' name='orderBy' id='orderBy' value="<%=orderBy%>" >
	<input type='hidden' name='alt_id1_exp_date' id='alt_id1_exp_date' value="<%=alt_id1_exp_date%>" >
	<input type='hidden' name='alt_id2_exp_date' id='alt_id2_exp_date' value="<%=alt_id2_exp_date%>" >

	<input type='hidden' name='p_discharge_date_from' id='p_discharge_date_from' value="<%=p_discharge_date_from%>" >
	<input type='hidden' name='p_discharge_date_to' id='p_discharge_date_to' value="<%=p_discharge_date_to%>" >

	<input type='hidden' name='national_id_no' id='national_id_no' value="<%=national_id_no%>" >
	<input type='hidden' name='alt_id1_no' id='alt_id1_no' value="<%=alt_id1_no%>" >
	<input type='hidden' name='alt_id2_no' id='alt_id2_no' value="<%=alt_id2_no%>" >
	<input type='hidden' name='alt_id3_no' id='alt_id3_no' value="<%=alt_id3_no%>" >
	<input type='hidden' name='alt_id4_no' id='alt_id4_no' value="<%=alt_id4_no%>" >
	<input type='hidden' name='other_alt_type' id='other_alt_type' value="<%=other_alt_type%>" >
	<input type='hidden' name='other_alt_Id' id='other_alt_Id' value="<%=other_alt_Id%>" >

	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name="selectAll_yn" id="selectAll_yn" value="<%=selectAll_yn%>">
	<input type='hidden' name="hddEncID" id="hddEncID" value="">
	<input type='hidden' name="PatientId" id="PatientId" value="<%=PatientId%>">
	<input type='hidden' name="p_encounter_id" id="p_encounter_id" value="<%=EncounterId%>">
	<input type='hidden' name="FacilityId" id="FacilityId" value="<%=FacilityId%>">
	<input type='hidden' name="marked_status" id="marked_status" value="<%=mlc_oscc%>">


	<br><center>
<%
}
if(!finalSelect.equals("SELECTALL"))
{
	
	StringTokenizer st=new StringTokenizer(finalSelect,"~");
	/*String practId="";*/ String objName="";
	String enable_dis="";
	int temp=st.countTokens();

	for(int u2=0;u2<temp;u2++)
	{
		String st2=st.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");
		st1.nextToken();
		objName=st1.nextToken();
		enable_dis=st1.nextToken();

		if(enable_dis.equals("E"))
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=true;</script>");
		else
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=false;</script>");
	}
}
}catch ( Exception e )
{ 
	//out.println("Expection in MedRecRequestResult.jsp : "+e);
	e.printStackTrace();
}

finally
{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(conn,request);
//	session.setAttribute("MedicalReportReq", MedicalReportReq);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</center>
</form>
</body>
</html>

