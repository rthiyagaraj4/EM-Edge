<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="MedicalReportReq" class="webbeans.eCommon.RecordSet" scope="session"/>
<%	String locale = (String)session.getAttribute("LOCALE"); %>

<script>

async function patientValuables(encID, PatID, locn_code, splty_code)
{
	
		var function_name=document.forms[0].call_function.value;
		 document.forms[0].PatientId.value=PatID;
	    if(function_name== "MR_REC_PAT_VAL")
		{
			 document.forms[0].PatientId.value="";
			var call_function = "MR_REC_PAT_VAL";
			var FacilityId = document.forms[0].FacilityId.value;
			var dialogHeight= "25" ;
			var dialogWidth = "50" ;
			var dialogTop 	= "70";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;

			retVal =await  	window.showModalDialog("../../eMR/jsp/PatientValuablesMain.jsp?encounterId="+encID+"&FacilityId="+FacilityId+"&patientId="+PatID+"&locn_code="+locn_code+"&splty_code="+splty_code+"&call_function="+call_function,arguments,features);
		}
		else
		{
			document.forms[0].Enc_id.value	= encID;
			document.forms[0].Pat_id.value	= PatID;
			document.forms[0].target="messageFrame";
			document.forms[0].action='../../servlet/eMR.PatientValuablesServlet';
			document.forms[0].submit();
		}
}


</script>

<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
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
	String finalSelect="",temp1="";
	String selectAll_yn=request.getParameter("selectAll_yn")==null?"":request.getParameter("selectAll_yn");

	if(selectAll_yn == null) selectAll_yn="";
	finalSelect=request.getParameter("finalSelect")==null?"":request.getParameter("finalSelect");
 	if(finalSelect == null) finalSelect="";
	
	String Enc_Type = request.getParameter("lstPatientClass")==null?"":request.getParameter("lstPatientClass");

	String orderBy=request.getParameter("orderBy");
	if(orderBy == null || orderBy.equals("ET")) 
		orderBy = " to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') desc";
	else if(orderBy.equals("ED")) 
		orderBy = "a.visit_adm_date_time desc";
    String Patient_ID="";
	String SystemDate	=	request.getParameter("SystemDate")==null?"":request.getParameter("SystemDate");
	String alt_id1_exp_date=request.getParameter("alt_id1_exp_date")==null?"":request.getParameter("alt_id1_exp_date");
	if(alt_id1_exp_date == null) alt_id1_exp_date="";
	else
		alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY",locale,"en");

	String alt_id2_exp_date=request.getParameter("alt_id2_exp_date")==null?"":request.getParameter("alt_id2_exp_date");
	
	if((alt_id2_exp_date == null)|| alt_id2_exp_date.equals("")) 
		alt_id2_exp_date=SystemDate;
	else
		alt_id2_exp_date = DateUtils.convertDate(alt_id2_exp_date,"DMY",locale,"en");

	String p_discharge_date_from=request.getParameter("p_discharge_date_from")==null?"":request.getParameter("p_discharge_date_from");
	if(!(p_discharge_date_from==null || p_discharge_date_from.equals("")))
	{
		if(p_discharge_date_from.length() >10)
			p_discharge_date_from = DateUtils.convertDate(p_discharge_date_from,"DMYHM",locale,"en");
		else
			p_discharge_date_from = DateUtils.convertDate(p_discharge_date_from,"DMY",locale,"en");
	}

	String p_discharge_date_to=request.getParameter("p_discharge_date_to")==null?"":request.getParameter("p_discharge_date_to");	
	if(!(p_discharge_date_to==null || p_discharge_date_to.equals("")))
	{
		if(p_discharge_date_to.length() >10)
			p_discharge_date_to = DateUtils.convertDate(p_discharge_date_to,"DMYHM",locale,"en");
		else
			p_discharge_date_to = DateUtils.convertDate(p_discharge_date_to,"DMY",locale,"en");
	}

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
	String Encounter_ID="";
	
	String p_practitioner_id=request.getParameter("practitioner_id");
	if( p_practitioner_id == null) p_practitioner_id="";

	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";

	String no_of_days			=request.getParameter("no_of_days");
	if(no_of_days == null) no_of_days="";
	
	String PatientId		=	request.getParameter("PatientId") ;
	if(PatientId	== null || PatientId.equals("null"))		
		PatientId = "";		

		if(call_function.equals("REPRINT_PAT_VAL"))
		{
			PatientId= "";
		}

	String EncounterId		=	request.getParameter("p_encounter_id") ;

	if(EncounterId	== null || EncounterId.equals("null"))		
		EncounterId = "";

	String AdmissionDate	=	request.getParameter("AdmissionDate")==null?"":request.getParameter("AdmissionDate") ;
	if(AdmissionDate == null || AdmissionDate.equals("null"))	AdmissionDate = "";
	if(!(AdmissionDate==null || AdmissionDate.equals("")))
	{
		if(AdmissionDate.length() >10)
			AdmissionDate = DateUtils.convertDate(AdmissionDate,"DMYHM",locale,"en");
		else
			AdmissionDate = DateUtils.convertDate(AdmissionDate,"DMY",locale,"en");
	}
	
	String DischargeDate	=	request.getParameter("DischargeDate") ;
	if(DischargeDate	== null || DischargeDate.equals("null"))DischargeDate = "";
	if(!(DischargeDate==null || DischargeDate.equals("")))
	{
		if(DischargeDate.length() >10)
			DischargeDate = DateUtils.convertDate(DischargeDate,"DMYHM",locale,"en");
		else
			DischargeDate = DateUtils.convertDate(DischargeDate,"DMY",locale,"en");
	}

	String Discharge	=	request.getParameter("discharge_val") ;
	if(Discharge	== null || Discharge.equals("null"))Discharge = "";


	String whereClause = request.getParameter("whereclause");
	if(whereClause	== null || whereClause.equals("null"))	
	{
		whereClause= "";
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

	Statement stmt_bl			= null;
	ResultSet rs_bl				= null;
	Connection conn = ConnectionManager.getConnection(request);	

try
{
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

		//String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from ip_param where facility_id='"+FacilityId+"'";//common-icn-0180
		String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from ip_param where facility_id=?";//common-icn-0180
		try
		{
			//stmt_bl=conn.createStatement();//common-icn-0180
			pstmt=conn.prepareStatement(query_bl_interface);//common-icn-0180
			pstmt.setString(1, FacilityId);//common-icn-0180
			rs_bl=pstmt.executeQuery();//common-icn-0180
			//rs_bl=stmt_bl.executeQuery(query_bl_interface);//common-icn-0180
			if(rs_bl.next())
			{
				install_yn=rs_bl.getString("bl_interfaced_yn");
			}
		
		if(rs_bl != null) rs_bl.close();
		if(stmt_bl != null) stmt_bl.close(); 
		}
		catch(Exception e)
		{
			//out.println("Exception @try1"+e);//COMMON-ICN-0181
			 e.printStackTrace();//COMMON-ICN-0181
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
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src="../js/EncSearchMain.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body OnMouseDown='CodeArrest();' onLoad='//chkForSelectAll(<%=start%>,<%=end%>)' onKeyDown='lockKey()'>
<form name='EncSearchResult' id='EncSearchResult'  action="../../eOR/jsp/EncSearchResult.jsp" method="post"  >
<%
	String Where  = "";

	Where  = " where a.patient_id=b.patient_id and a.facility_id='"+FacilityId+"' ";

	if(!PatientId.equals(""))
	{ 		
		Where  = Where +" and b.patient_id like '"+PatientId+"%' ";
	}

	/**********/
	if(call_function.equals("GEN_PLACE_ORDER") ) 
	{	
		Where  = Where +" and a.attend_practitioner_id is not null ";
		if(Enc_Type.equals("IP") || Enc_Type.equals("DC"))
			Where  = Where +" and a.adt_status in ('00','01')";
		else if(Enc_Type.equals("EM") || Enc_Type.equals("OP"))
			Where  = Where +" and a.visit_status < '07' ";
	}

	if (!(Enc_Type == null || Enc_Type.equals("")) )
	{
	 
		Where = Where + " and upper(PATIENT_CLASS) like upper('"+Enc_Type+"') ";
	}

	if ( !(EncounterId == null || EncounterId.equals("")) )
	{
		Where = Where + " and a.encounter_id like '"+EncounterId+"%'";
	}
	if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && !(alt_id2_exp_date == null || alt_id2_exp_date.equals("")))
	{
		Where = Where + " and trunc(a.visit_adm_date_time) between to_date('"+alt_id1_exp_date+"','dd/mm/yyyy') and to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')";
	}

	if ( !(p_discharge_date_from == null || p_discharge_date_from.equals("")) )
	{
	
		Where = Where + " and trunc(a.discharge_date_time) >= to_date('"+p_discharge_date_from+"','dd/mm/yyyy ')";
	}

	if ( !(p_discharge_date_to == null || p_discharge_date_to.equals("")) )
	{
	 
		Where = Where + " and trunc(a.discharge_date_time) <= to_date('"+p_discharge_date_to+"','dd/mm/yyyy ')";
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
		
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
		

		pstmt = conn.prepareStatement(sqlbuff.toString());
		rs = pstmt.executeQuery();

		if(rs.next())
		   maxRecord = rs.getInt(1);
	}
	if (maxRecord==0 && !modal_yn.equals("Y"))
	{			
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));//document.location.href='../../eCommon/html/blank.html'</script>");
	}
	else
	{

	    if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
		//sqlbuff.append(" select a.VISIT_ADM_TYPE, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) Patient_Name, ");//common-icn-0180
		sqlbuff.append(" select a.VISIT_ADM_TYPE, a.patient_id, decode(?,'en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) Patient_Name, ");//common-icn-0180
		
		sqlbuff.append(" b.Sex Gender, ");
		sqlbuff.append(" to_char(b.date_of_birth,'dd/mm/yy')birth_date, ");
		sqlbuff.append(" to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') encounter_date,");
		//sqlbuff.append(" a.encounter_id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2') END) Speciality_desc,");//common-icn-0180
		sqlbuff.append(" a.encounter_id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,?,'2') END) Speciality_desc,");//common-icn-0180
		
		sqlbuff.append(" a.specialty_code specialty_code,");
		//sqlbuff.append("DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,'"+locale+"','1')) Locn_desc,");//common-icn-0180
		sqlbuff.append("DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,?,'2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,?,'1')) Locn_desc,");//common-icn-0180
		
		sqlbuff.append(" a.assign_care_locn_code locn_code, a.attend_practitioner_id,");
		//sqlbuff.append(" (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,'"+locale+"','1') END) Practitioner_Name, a.assign_room_num room_no, a.assign_bed_num bed_no,AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,'"+locale+"','1') Locn_Type, a.assign_care_locn_type, b.alt_id1_no alt_id1_no, b.alt_id2_no alt_id2_no, b.alt_id3_no alt_id3_no, b.alt_id4_no alt_id4_no,AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,'"+locale+"','1') Patient_Class, a.patient_class patient_class_code, TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time FROM PR_ENCOUNTER a, MP_PATIENT b ");//common-icn-0180
		sqlbuff.append(" (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,?,'1') END) Practitioner_Name, a.assign_room_num room_no, a.assign_bed_num bed_no,AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,?,'1') Locn_Type, a.assign_care_locn_type, b.alt_id1_no alt_id1_no, b.alt_id2_no alt_id2_no, b.alt_id3_no alt_id3_no, b.alt_id4_no alt_id4_no,AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,?,'1') Patient_Class, a.patient_class patient_class_code, TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time FROM PR_ENCOUNTER a, MP_PATIENT b ");//common-icn-0180

		sqlbuff.append(Where);
		//out.println(sqlbuff.toString());

		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
		pstmt = conn.prepareStatement(sqlbuff.toString());
		//common-icn-0180 starts
		pstmt.setString(1, locale);
		pstmt.setString(2, locale);
		pstmt.setString(3, locale);
		pstmt.setString(4, locale);
		pstmt.setString(5, locale);
		pstmt.setString(6, locale);
		pstmt.setString(7, locale);
		//common-icn-0180 starts
		rs = pstmt.executeQuery();

		if(!flag.equals("true"))
		{
			if(!PatientId.equals(""))
			{	%>
				<table border="1" cellpadding="0" cellspacing="0" align='center' width="100%">
				<tr>
				<%	
				if(!call_function.equals("QUERY_MATERNAL_REPORT"))
				{	
				%>
					<td>	
					<jsp:include page="../../eCommon/jsp/pline.jsp" flush="true">
					<jsp:param name="Patient_ID" value="<%=PatientId%>" />				
					</jsp:include> 			
					</td>
				<%
				}
				%>
				</tr>
			</table>
		<%
			}	
			%>		
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

		<%	
		if(!call_function.equals("QUERY_MATERNAL_REPORT"))
		{	 
		%>
			<th class='columnheadercenter' nowrap></th>
		<%	
		}	
	   %>
		<% 
		 if(	!call_function.equals("MARK_MLC_OSCC") && 
		!call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("REPRINT_PAT_VAL") &&  !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")&&
		!call_function.equals("QUERY_MARK_MLC_OSCC") &&
		!call_function.equals("QUERY_MATERNAL_REPORT") &&
		!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS") )
		{	 
		 %>
			<th class='columnheadercenter' nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><BR><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,"<%=start%>","<%=end%>");'></th>
		<%
		}	
		 %>
		<th class='columnheadercenter' nowrap><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th>
		<%	
		if(!call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE")&& !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS")) 
		{	
		%>
			<th class='columnheadercenter' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
		<%
		}
		%>
		<th class='columnheadercenter' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<%
		if(call_function.equals("QUERY_MARK_MLC_OSCC") || call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL") || call_function.equals("DIAG_RECODE")|| call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{
	  
			if (PatientId.equals("")) 
			{	
			%>
 				<th class='columnheadercenter' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th> 
			<%
			} 
		}	
		if(call_function.equals("QUERY_MATERNAL_REPORT") || call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{	
		%>
			<th class='columnheadercenter' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<%
		}	
		if(!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL")  && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("QUERY_MARK_MLC_OSCC")&& !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS"))
		{	
		%>
			<th class='columnheadercenter' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
		<%
		}	
		if( call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{	
		%>
			<th class='columnheadercenter' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<%
		}  
		%>
		<th class='columnheadercenter' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		<th class='columnheadercenter' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
		<th class='columnheadercenter' nowrap><fmt:message key="Common.room.label" bundle="${common_labels}"/></th>
		<th class='columnheadercenter' nowrap><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></th>
		<th class='columnheadercenter' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<%
		String chkAttribute		= "";
		String P_DEP_APPL_YN	= "";
		String Patient_Class_code = "";
		String Encounter_Date_display = "";
		

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

					Patient_ID=rs.getString("patient_id");		

					Patient_Class_code= rs.getString("patient_class_code");
				
					Encounter_ID=rs.getString("encounter_id");	

					String Patient_Name=rs.getString("Patient_Name");				
					String conGender=rs.getString("Gender");				
					String Date_of_Birth=rs.getString("birth_date");				
					String Patient_Class=rs.getString("Patient_class");	
					String Encounter_Date=rs.getString("encounter_date");				
					String con_Speciality=rs.getString("Speciality_desc");				
					String specialty_code=rs.getString("specialty_code");				
					String con_Location=rs.getString("Locn_desc");				
					String locn_code=rs.getString("locn_code");				
					String con_Practitioner=rs.getString("Practitioner_Name");				
					String attend_practitioner_id=rs.getString("attend_practitioner_id");				
					String room_no=rs.getString("room_no");				
					String bed_no=rs.getString("bed_no");				
					String locn_type=rs.getString("Locn_type");		
					String Encounter_Type = rs.getString("Locn_type");
					String assign_care_locn_type = rs.getString("assign_care_locn_type");
					String visit_adm_type= checkForNull(rs.getString("visit_adm_type"));

		if(MedicalReportReq.containsObject(Encounter_ID))  
			chkAttribute = "CHECKED";
		else
			chkAttribute="";

		int recordIndex = MedicalReportReq.indexOfObject(Encounter_ID);
		if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED"))    									    	
			MedicalReportReq.removeObject(recordIndex);

					if(Patient_ID==null	      || Patient_ID.equals("null"))		    
						Patient_ID = "";
					if(Patient_Name==null	  || Patient_Name.equals("null"))				Patient_Name = "";
					if(conGender==null	      || conGender.equals("null"))		    
						conGender = "";

					if(conGender.equals("M"))
					{
						conGender =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					}
					else if (conGender.equals("F"))
					{
						conGender =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					}
					 else 
					{
						conGender =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					}

					if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
						Date_of_Birth = "";
					if(Patient_Class==null	  || Patient_Class.equals("null"))
						Patient_Class = "";
					if(Encounter_Date==null	  || Encounter_Date.equals("null"))
					{
						Encounter_Date = "";
						Encounter_Date_display = "";
					}
					else
						Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
					if(Encounter_ID==null	  || Encounter_ID.equals("null"))
						Encounter_ID = "";
					if(con_Speciality==null	  || con_Speciality.equals("null"))
						con_Speciality = "&nbsp;";
					if(con_Location==null	  || con_Location.equals("null"))
						con_Location = "&nbsp;";
					if(con_Practitioner==null || con_Practitioner.equals("null"))
						con_Practitioner = "&nbsp;";
					if(attend_practitioner_id==null || attend_practitioner_id.equals("null"))
						attend_practitioner_id = "";
					if(room_no==null || room_no.equals("null"))
						room_no = "&nbsp;";
					if(bed_no==null || bed_no.equals("null"))
						bed_no = "&nbsp;";
					if(locn_type==null || locn_type.equals("null"))
						locn_type = "&nbsp;";
					if(Encounter_Type==null || Encounter_Type.equals("null"))
						Encounter_Type = "&nbsp;";
					if(assign_care_locn_type==null || assign_care_locn_type.equals("null"))
						assign_care_locn_type = "";

		out.println("<tr>");
		if(!call_function.equals("QUERY_MATERNAL_REPORT"))
		{
			 
			out.println("<td align='left' class='"+classValue+"'>");
			out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"')\">");	
			out.print("+</a></td>");				
		}

		if(!call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")  && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT")  &&!call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS"))
		{
			
			out.println("<td align=middle nowrap class='"+classValue+"'><input type=checkbox name='chk"+i+"' id='chk"+i+"' value='"+i+"' onClick='javascript:RemSelectAll();chkServices(this);' /></td>");
		}
        
		
		out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");

		if(!call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE")&& !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS"))
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
			
			
		 if(PatientId.equals(""))
			{	
			out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecodeDiagnosis('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
			out.println("<td nowrap class='"+classValue+"'>" +Patient_ID+"</td>");
			}
		else if(!PatientId.equals(""))
			{ out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecodeDiagnosis('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");  
			}
		}
		else if(call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL"))
		{
				
		
			if (!PatientId.equals(""))
			{
					
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:patientValuables('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+specialty_code+"')>"+Encounter_ID+"</a></td>");
			}
			else if(PatientId.equals(""))
			{
					
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:patientValuables('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+specialty_code+"')>"+Encounter_ID+"</a></td>");
				out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+"</td>");
			}
		}

		else if(call_function.equals("TRANSMIT_NOTIFY_REP"))
		{
			 

			out.println("<td nowrap class='"+classValue+"'><a href=javascript:DiagnososTransmissionDtls('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
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
				
			if(call_function.equals("GEN_PLACE_ORDER"))
			{	
					
				if (!PatientId.equals(""))
			   {
					out.println("<td nowrap class='"+classValue+"'><a href=javascript:callWin('"+Patient_Class_code+"','ORDER_ENTRY','"+Encounter_ID+"','"+Patient_ID+"','"+visit_adm_type+"','"+P_DEP_APPL_YN+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");

			    } 
			  
				else if(PatientId.equals(""))
			     { 
					  out.println("<td nowrap class='"+classValue+"'><a href=javascript:callWin('"+Patient_Class_code+"','ORDER_ENTRY','"+Encounter_ID+"','"+Patient_ID+"','"+visit_adm_type+"','"+P_DEP_APPL_YN+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>"); 
					  out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+"</td>");
				  }
			}
			else if(call_function.equals("MR_DIAGNOSIS"))
			{

              if (!PatientId.equals(""))
			   {
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:recordDiagnosis('MR_DIAGNOSIS','"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+conGender+"','"+attend_practitioner_id+"','"+Date_of_Birth+"','"+assign_care_locn_type+"','"+Patient_Class_code+"')>"+Encounter_ID+"</a></td>");
			   }
			     else if(PatientId.equals(""))
			     { 


				out.println("<td nowrap class='"+classValue+"'><a href=javascript:recordDiagnosis('MR_DIAGNOSIS','"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+conGender+"','"+attend_practitioner_id+"','"+Date_of_Birth+"','"+assign_care_locn_type+"','"+Patient_Class_code+"')>"+Encounter_ID+"</a></td>");
				out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+"</td>");
			
				 }
			 }
			else
			{
		
				out.println("<td nowrap class='"+classValue+"'>"+Encounter_ID+"</td>");
			}
		}
		if(call_function.equals("QUERY_MATERNAL_REPORT")||call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{	
			
			out.println("<td nowrap class='"+classValue+"'>" +Patient_Name+"</td>");
		}
		if(call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{	
			out.println("<td nowrap class='"+classValue+"'>" +conGender+"</td>");
		}
		if(!call_function.equals("QUERY_MATERNAL_REPORT")&&!call_function.equals("MEDICAL_REPORT_REQUEST")&&!call_function.equals("MARK_MLC_OSCC")&& !call_function.equals("DIAG_RECODE") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("QUERY_MARK_MLC_OSCC")&& !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS"))
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
		<table align='right'>
			<tr>
			<jsp:include page="../../eCommon/jsp/pline.jsp" flush="true">
				<jsp:param name="Patient_ID" value="<%=PatientId%>" />
			</jsp:include> 
			</tr>
		</table> 
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<TR><td colspan=6 class="white">&nbsp;</td></TR>
		</table>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<TR>
<!-- 		<th align='center' nowrap>Patient ID</th> -->
			<th class='columnheadercenter' nowrap>Encounter Type</th> 
			<th class='columnheadercenter' nowrap>Admission Date</th> 
			<th class='columnheadercenter' nowrap>Encounter ID</th>
			<th class='columnheadercenter' nowrap>Location Type</th>
			<th class='columnheadercenter' nowrap>Location</th>
			<th class='columnheadercenter' nowrap>Practitioner</th>
			<th class='columnheadercenter' nowrap>Speciality</th>
			<th class='columnheadercenter' nowrap>Discharge Date</th>
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

		if (rs != null)
		{
			
			int clsCnt=1;

		while(rs.next())
		{
			if(ssm.containsKey(new String(i+"")))
			{
				
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				 Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");
				String Encounter_Date_display="";
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))
				{
						Encounter_Date = "";
						Encounter_Date_display = "";
				}
				else
					Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
				
				 Encounter_ID=rs.getString("encounter_id");				
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
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
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

		</script>
	<%
				}
				i++;
			}
			if(clsCnt == 1)
			{
				out.println("<script>alert(getMessage('ENC_CANNOT_BLANK','MR'));parent.window.close();</script>");
				
			}
		}
	}
	else if(finalSelect.equals("SELECTALL"))
	{
		
		if (rs != null)
		{
			int clsCnt=1;
			while(rs.next())
			{
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				 Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				 Encounter_ID=rs.getString("encounter_id");				
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
	<input type='hidden' name='PatientId' id='PatientId' value="<%=PatientId%>">
	<input type='hidden' name='from' id='from' value="<%=start%>" >
	<input type='hidden' name='to' id='to' value="<%=end%>" >
	<input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect%>'>
	<input type='hidden' name='temp1' id='temp1' value='<%=temp1%>'>
	<input type='hidden' name='criteria' id='criteria' value='<%=criteria%>'>

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
	<input type='hidden' name='encounterId' id='encounterId' value="<%=Encounter_ID%>" >

	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name="selectAll_yn" id="selectAll_yn" value="<%=selectAll_yn%>">
	<input type='hidden' name="hddEncID" id="hddEncID" value="">
	
	<input type='hidden' name="p_encounter_id" id="p_encounter_id" value="<%=EncounterId%>">
	<input type='hidden' name="FacilityId" id="FacilityId" value="<%=FacilityId%>">
	<input type='hidden' name="marked_status" id="marked_status" value="<%=mlc_oscc%>">

	<input type='hidden' name="Enc_id" id="Enc_id" value="">
	<input type='hidden' name="Pat_id" id="Pat_id" value="">

	<br><center>
<%
}
if(!finalSelect.equals("SELECTALL"))
{
	
	
	StringTokenizer st=new StringTokenizer(finalSelect,"~");
	String objName="";
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
	//out.println("Expection in EncSearchResult.jsp : "+e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}

finally
{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(conn,request);
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

