<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="MedicalReportReq" class="webbeans.eCommon.RecordSet" scope="session"/> 

<%	String locale = (String)session.getAttribute("LOCALE");
	//String loginUser = (String)session.getValue("login_user");
%>

<script>

async function RecodeDiagnosis(encID, PatID, ln_code, Patient_Class, sex,dob,FacilityId,practitioner_id)
{
	var call_function = "DIAG_RECODE";
	
	var dialogHeight= "72vh";
	var dialogWidth = "65vw";
	var dialogTop	= "150";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	//RecDiagnosis.jsp
	//retVal = 	window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function+"&location_code="+ln_code+"&patient_class="+Patient_Class+"&Sex="+sex,arguments,features);

	retVal = 	await window.showModalDialog("../../eMR/jsp/DiagRecodePatProblemMain.jsp?modal_yn=Y&Encounter_Id="+encID+"&ip_practitioner_id="+practitioner_id+"&episode_id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function+"&location_code="+ln_code+"&patient_class="+Patient_Class+"&Sex="+sex+"&Dob="+dob,arguments,features);
}

function RecordDiagnosis(encID, PatID, ln_code, Patient_Class, sex,dob,pract_type,speciality_code,bed_num,loc_type,room_num,enc_date,FacilityId,practitioner_id)
{
	
	var call_function = "RECORD_DIAGNOSIS";
	//var FacilityId = document.forms[0].FacilityId.value;
	//var practitioner_id = document.forms[0].attend_practitioner_id.value;
	/*var dialogHeight= "72";
	var dialogWidth = "65";
	var dialogTop	= "150";*/
	var dialogHeight="41vh";
	var dialogWidth="65vw";
	var dialogTop="72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
//RecDiagnosis.jsp
	//retVal = 	window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function+"&location_code="+ln_code+"&patient_class="+Patient_Class+"&Sex="+sex,arguments,features);
	var action_url="../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&encounter_id="+encID+"&practitioner_id="+practitioner_id+"&episode_id="+encID+"&FacilityId="+FacilityId+"&patient_id="+PatID+"&Function="+call_function+"&location_code="+ln_code+"&location_type="+loc_type+"&patient_class="+Patient_Class+"&Sex="+sex+"&Dob="+dob+"&IP_YN=N&practitioner_type="+pract_type+"&speciality_code="+speciality_code+"&bed_num="+bed_num+"&room_num="+room_num+"&visit_adm_date="+enc_date;
	
	//var action_url="../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&encounter_id="+encID+"&practitioner_id="+practitioner_id+"&episode_id="+encID+"&FacilityId="+FacilityId+"&patient_id="+PatID+"&Function="+call_function+"&location_code="+ln_code+"&location_type="+loc_type+"&patient_class="+Patient_Class+"&IP_YN=N&practitioner_type="+pract_type+"&speciality_code="+speciality_code+"&bed_num="+bed_num+"&room_num="+room_num+"&visit_adm_date="+enc_date;

	var title="";


	//retVal = 	window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&encounter_id="+encID+"&practitioner_id="+practitioner_id+"&episode_id="+encID+"&FacilityId="+FacilityId+"&patient_id="+PatID+"&Function="+call_function+"&location_code="+ln_code+"&location_type="+loc_type+"&patient_class="+Patient_Class+"&Sex="+sex+"&Dob="+dob+"&IP_YN=N&practitioner_type="+pract_type+"&speciality_code="+speciality_code+"&bed_num="+bed_num+"&room_num="+room_num+"&visit_adm_date="+enc_date,arguments,features);
	var bodwidth  = window.screen.width+window.screen.width;
	var	bodheight = window.screen.height+window.screen.height;
	

	window.open(action_url,title,"height="+bodheight+",width="+bodwidth+",top=0,status=0,toolbar=no,menubar=no,location=no,left=0,right=0,bottom=0,this.minimise=no");
	
}

function RecordProcedure(encID, PatID, ln_code, Patient_Class, sex,dob,pract_type,speciality_code,bed_num,loc_type,room_num,enc_date,FacilityId,practitioner_id)
{
	
	var call_function = "PROCEDURE_RECORDING";
	//var FacilityId = document.forms[0].FacilityId.value;
	//var practitioner_id = document.forms[0].attend_practitioner_id.value;
	/*var dialogHeight= "72";
	var dialogWidth = "65";
	var dialogTop	= "150";*/
	/*var dialogHeight="41";
	var dialogWidth="65";
	var dialogTop="72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;*/

	//retVal = 	window.showModalDialog("../../eCA/jsp/PatProcRecordWrapper.jsp?modal_yn=Y&mode=R&encounter_id="+encID+"&practitioner_id="+practitioner_id+"&episode_id="+encID+"&FacilityId="+FacilityId+"&patient_id="+PatID+"&Function="+call_function+"&location_code="+ln_code+"&location_type="+loc_type+"&patient_class="+Patient_Class+"&Sex="+sex+"&Dob="+dob+"&IP_YN=N&practitioner_type="+pract_type+"&speciality_code="+speciality_code+"&bed_num="+bed_num+"&room_num="+room_num+"&visit_adm_date="+enc_date,arguments,features);

	
	var queryString = "modal_yn=Y&mode=R&encounter_id="+encID+"&practitioner_id="+practitioner_id+"&episode_id="+encID+"&FacilityId="+FacilityId+"&patient_id="+PatID+"&Function="+call_function+"&location_code="+ln_code+"&location_type="+loc_type+"&patient_class="+Patient_Class+"&Sex="+sex+"&Dob="+dob+"&IP_YN=N&practitioner_type="+pract_type+"&speciality_code="+speciality_code+"&bed_num="+bed_num+"&room_num="+room_num+"&visit_adm_date="+enc_date+"&called_from=MR";

	var HTMLVal = "<html><BODY onKeyDown='lockKey()'>";
	HTMLVal += "<form name='wrapperForm' id='wrapperForm' action='../../eCA/jsp/PatProcRecordWrapper.jsp?"+queryString+"' method='post'>";
	HTMLVal += "</form></BODY>";			
	HTMLVal += "</html>";
	
	//parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	//top.content.messageFrame.document.wrapperForm.submit();	
	
	//parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.dummy_frame.document.write(HTMLVal);
	parent.dummy_frame.document.wrapperForm.submit();		

}

async function patientValuables(encID, PatID, locn_code, splty_code,FacilityId)
{
	//var function_name=document.forms[0].call_function.value;
	//document.forms[0].PatientId.value=PatID;
	//modified for SCR 5008 
	var function_name=parent.frames[1].document.forms[0].call_function.value;
	
	//Tuesday, June 09, 2009 parent.frames[1].document.forms[0].PatientId.value=PatID;
    if(function_name== "MR_REC_PAT_VAL")
	{
		var call_function = "MR_REC_PAT_VAL";
		//modified for SCR 5008 
		//var FacilityId = document.forms[0].FacilityId.value;
		var dialogHeight= "500px";
		var dialogWidth = "1000px";
		var dialogTop	= "175";

		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;

		retVal = await window.showModalDialog("../../eMR/jsp/PatientValuablesMain.jsp?encounterId="+encID+"&FacilityId="+FacilityId+"&patientId="+PatID+"&locn_code="+locn_code+"&splty_code="+splty_code+"&call_function="+call_function,arguments,features);
	}
	else if(function_name=="REPRINT_PAT_VAL")
	{
		
			document.forms[0].Enc_id.value	= encID;
			document.forms[0].Pat_id.value	= PatID;
			document.forms[0].target="messageFrame";
			document.forms[0].action='../../servlet/eMR.PatientValuablesServlet';
			document.forms[0].submit();		
	}
	else if(function_name=="MR_INTERNAL_REPORTS_REPRINT")
	{
		if(document.getElementById("reportname").value=="MRBPATVL")
		{
			//alert(function_name);
			//alert(PatID);
			//alert(encID);
			document.getElementById("Enc_id").value	= encID;
			document.getElementById("Pat_id").value	= PatID;
			document.forms[0].target="messageFrame";
			document.forms[0].action='../../servlet/eMR.PatientValuablesServlet?call_function='+function_name+'&Enc_id='+encID+'&Pat_id='+PatID;
			document.forms[0].submit();

		}
		else
		{
			document.getElementById("EncounterId").value	= encID;
			document.getElementById("Pat_id").value	= PatID;
			document.getElementById("facility_id").value	= FacilityId;
			document.getElementById("p_language_id").value	= document.getElementById("p_language_id").value;
			document.forms[0].target="messageFrame";
			document.forms[0].action='../../servlet/eMR.DRGCalculationServlet?req_mode=report'+'&EncounterId='+encID+'&Pat_id='+PatID;
			document.forms[0].submit();
		}

	}
	//parent.frames[2].location.reload();
}

function sendtomain(encounter_id1){
			/* parent.window.returnValue=encounter_id1;
			parent.window.close(); */
	var dialogBody = parent.parent.document.getElementById('dialog-body');
    
    dialogBody.contentWindow.returnValue = encounter_id1;
    
    var dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
	}


async function showModalCurEnc(enc,patid,changefunc,Patient_Class)
{
	
	var bl_install_yn=document.forms[0].bl_install;
	var call_function = document.forms[0].call_function.value;
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "41vh";
	var dialogWidth = "65vw";
	var dialogTop	= "72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn.value+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
	if(retVal!=null && retVal!='')

	parent.content.document.location.reload();
}

</script>

<%	

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	//StringBuffer recode_where = new StringBuffer();

	StringBuffer where_condition = new StringBuffer();

	String call_from		=checkForNull(request.getParameter("call_from"));
	String title =request.getParameter("title")==null?"":request.getParameter("title");	
	String locn_type="";		
	String locn_code="";		
	String classValue	 = "";
	String attend_practitioner_id  = "";
	StringBuffer sqlbuff = new StringBuffer();
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	
	String criteria =request.getParameter("criteria")==null?"":request.getParameter("criteria");
	if(criteria == null) criteria="";
	String jsp_name =request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");
//	String flagSelect = request.getParameter("fromSelect")==null?"":request.getParameter("fromSelect");
	String finalSelect="",temp1="";
	String temp2="";
	String enc_temp="";
	String pat_temp="";
	String finalSelect1="";
	String status="";
	String stage_no="";
	String search_by="";

	int fetchRecord=0;
	String loc_type="";
    
	String sel_cnt = request.getParameter("sel_cnt")==null?"":request.getParameter("sel_cnt");
	String oper_stn_id = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	String create_file_yn = request.getParameter("create_file_yn")==null?"N":request.getParameter("create_file_yn");

	String speciality_val = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	
	String selectAll_yn=request.getParameter("selectAll_yn")==null?"":request.getParameter("selectAll_yn");
	if(selectAll_yn == null) selectAll_yn="";

	finalSelect=request.getParameter("finalSelect")==null?"":request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";
	String chkSelect=request.getParameter("chkSelect")==null?"":request.getParameter("chkSelect");
	if(chkSelect == null) chkSelect="";
//out.println("<script>alert(\"chkSelect in result"+chkSelect+"\");</script>");

	finalSelect=request.getParameter("finalSelect1")==null?"":request.getParameter("finalSelect1");
	if(finalSelect1 == null) finalSelect1="";

	status=request.getParameter("status")==null?"":request.getParameter("status");
	if(status == null) status="";

	stage_no=request.getParameter("stage_no")==null?"":request.getParameter("stage_no");
	if(stage_no == null) stage_no="";
	search_by=request.getParameter("search_by")==null?"":request.getParameter("search_by");
	if(search_by == null) search_by="";
//



	
	String Enc_Type = request.getParameter("lstPatientClass")==null?"":request.getParameter("lstPatientClass");


	String orderBy_ind=checkForNull(request.getParameter("orderBy"));
	String orderBy="";
	/*Modified on 9/28/2010 for IN024006*/
//	if(orderBy_ind.equals("") || orderBy_ind.equals("ET")){ 
	if(orderBy_ind.equals("ET")){ 
//		orderBy = " to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') asc";
		orderBy = " a.patient_class asc";
	}else if(orderBy_ind.equals("ED")) {
		orderBy = "a.visit_adm_date_time asc";
	}
    String Patient_ID="";
	String cause_ind	=	request.getParameter("cause_ind")==null?"":request.getParameter("cause_ind");
	
	String alt_id1_exp_date=request.getParameter("alt_id1_exp_date")==null?"":request.getParameter("alt_id1_exp_date");

	if(alt_id1_exp_date == null) 
		alt_id1_exp_date="";
	else
		alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY",locale,"en");

	

	String alt_id2_exp_date=request.getParameter("alt_id2_exp_date")==null?"":request.getParameter("alt_id2_exp_date");

	if(alt_id2_exp_date == null) 
		alt_id2_exp_date="";
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

	temp2=request.getParameter("temp2")==null?"":request.getParameter("temp2");
	if(temp2 == null) temp2="";

	enc_temp=request.getParameter("enc_temp")==null?"":request.getParameter("enc_temp");
	if(enc_temp == null) enc_temp="";

	pat_temp=request.getParameter("pat_temp")==null?"":request.getParameter("pat_temp");
	if(pat_temp == null) pat_temp="";

	String mlc_oscc = request.getParameter("marked_status")==null?"":request.getParameter("marked_status");
	String status_to_show = request.getParameter("status_to_show")==null?"":request.getParameter("status_to_show");
	String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date = request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String flag="";
	flag=(request.getParameter("flag")==null) ? "" : request.getParameter("flag");

	String  req_start   =   "", req_end     =   "";
    String  checkedOnes         =   "";

    req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
    req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
	
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
	
	//out.println("call_function" + call_function);

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

	
	//String recode_action = "";

	
	String DischargeDate	=	request.getParameter("DischargeDate") ;
	if(DischargeDate	== null || DischargeDate.equals("null"))DischargeDate = "";

	

	String Discharge	=	request.getParameter("discharge_val") ;
	if(Discharge	== null || Discharge.equals("null"))Discharge = "";

	String reportname	=	request.getParameter("reportname") ;
	if(reportname	== null || reportname.equals("null"))reportname = "";



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

//out.println("<script>alert(\""+end+"\");</script>");

        //if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        //if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }

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

//out.println("<script>alert(\""+start+"\");</script>");
//out.println("<script>alert(\""+end+"\");</script>");

	Statement pstmt				   = null;
	PreparedStatement p_stmt  = null;
	ResultSet rs						   = null;
	Statement stmt_bl				   = null;
	ResultSet rs_bl					   = null;

	Connection conn = ConnectionManager.getConnection(request);	
try{
//Check for bl_interfaced_yn condition.......added by kishore
	if(!modal_yn.equals("Y"))
	{
		String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from IP_PARAM where facility_id='"+FacilityId+"'";
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
			e.printStackTrace();
		}
	}	
	
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<head>
<%
	if(call_function.equals("MEDICAL_REPORT_REQUEST")){
	
	title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewEncounterDetails.label","mr_labels");
	out.println("<title>"+title+"</title>");
	}
%>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>

	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
	<script src="../../eMR/js/MedRecRequestMain.js" language="javascript"></script>
	<script src="../../eOA/js/QueryLocnForDay.js" language="javascript"></script>
	<script src="../../eOP/js/menu.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script src="../../eMR/js/MedRecRequestResult.js" language="javascript"></script>
	<script src="../../eCommon/js/showModalDialog.js" language="javascript"></script>
	
	<style type="text/css">
		table.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}
		table.mt th {border-width: 1px;padding: 1px;white-space: normal; text-align:left;word-wrap:normal;width:8%;}
		table.mt td {white-space:normal;word-wrap: break-word; word-break: break-all;}
	</style>

	<script type="text/javascript">
		$(window).on('load',(function () {
		   /*Below line modified for existing issue fixed*/
			if(document.getElementById("reportname") && document.getElementById("reportname").value=="MR"){
				FnListAllStatus();
			}
		}));
	</script>

</head>
<body OnMouseDown='CodeArrest();' onLoad='chkForSelectAll(<%=start%>,<%=end%>)' onKeyDown='lockKey()'>
<form name='MedRecRequestResult' id='MedRecRequestResult'  action="../../eMR/jsp/MedRecRequestResult.jsp" method="post"  >

<%
int maxRecord = 0;

if(call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && reportname.equals("MR")){%>
	<div id="paginatoinContainer" style="float:right;margin:0 50px 10px 0"></div>
	<div class="cont" id="listReportStatus" style="clear:both"></div>
    
<%}else{

	String flagSelect = checkForNull(request.getParameter("clear"));
			        
			if(!flagSelect.equals(""))
				MedicalReportReq.clearAll();

	if(from != null && to != null)
	{
		 int j=0;
		 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		 {
			 if(request.getParameter("select_chk"+(i)) != null)
			 {
				
				 checkedOnes = request.getParameter("select_val"+(i));
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
	//String Where  = "";
	//Where  = " where a.patient_id=b.patient_id and a.facility_id='"+FacilityId+"' ";
	where_condition.append( " where a.patient_id=b.patient_id and a.facility_id='"+FacilityId+"' ");

	if(!PatientId.equals(""))
	{
		//Where  = Where +" and b.patient_id like '"+PatientId+"' ";
		where_condition.append(" and b.patient_id like '"+PatientId+"' ");
	}

	if(call_function.equals("TRANSMIT_NOTIFY_REP"))
	{
		//Where  = Where +" and exists (select enc_dtl.facility_id, enc_dtl.encounter_id from pr_diagnosis_enc_dtl enc_dtl, mr_term_code m where enc_dtl.term_set_id = m.term_set_id and enc_dtl.term_code = m.term_code and enc_dtl.facility_id = a.facility_id and enc_dtl.encounter_id = a.encounter_id and m.notifiable_yn = 'Y') ";

		where_condition.append("and exists (select enc_dtl.facility_id, enc_dtl.encounter_id from pr_diagnosis_enc_dtl enc_dtl, mr_term_code m where enc_dtl.term_set_id = m.term_set_id and enc_dtl.term_code = m.term_code and enc_dtl.facility_id = a.facility_id and enc_dtl.encounter_id = a.encounter_id and m.notifiable_yn = 'Y') ");
	}

	if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
	{
		//Where  = Where +" and EXISTS (SELECT facility_id, encounter_id FROM mr_diag_transmission WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id ) ";

		where_condition.append("and EXISTS (SELECT facility_id, encounter_id FROM mr_diag_transmission WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id ) ");
	}
	if(call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && reportname.equals("MRDGRCSM"))
	{

		//Where  = Where +" AND EXISTS (select 1	From	Mr_Diagnosis_Recoding_Dtl rec_dtl,Mr_Diag_Proc_Recoding_Hdr rec_hdr Where	rec_dtl.Facility_Id = rec_hdr.Facility_Id And	rec_dtl.Encounter_Id = rec_hdr.Encounter_Id	And	rec_dtl.Facility_Id = a.facility_id	And	rec_dtl.Encounter_Id = a.encounter_id And	rec_dtl.Status != 'E' And	rec_dtl.Trx_No Is Not Null And	(rec_hdr.level1_status = 'A' or rec_hdr.level2_status = 'A' or rec_hdr.level3_status = 'A'))	";

		where_condition.append("AND EXISTS (select 1	From	Mr_Diagnosis_Recoding_Dtl rec_dtl,Mr_Diag_Proc_Recoding_Hdr rec_hdr Where	rec_dtl.Facility_Id = rec_hdr.Facility_Id And	rec_dtl.Encounter_Id = rec_hdr.Encounter_Id	And	rec_dtl.Facility_Id = a.facility_id	And	rec_dtl.Encounter_Id = a.encounter_id And	rec_dtl.Status != 'E' And	rec_dtl.Trx_No Is Not Null And	(rec_hdr.level1_status = 'A' or rec_hdr.level2_status = 'A' or rec_hdr.level3_status = 'A'))	");


	}
	if(call_function.equals("MR_REC_PAT_VAL")){	
		if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and adt_status = '08'";
				where_condition.append(" and adt_status = '08'");
			}else{
				//Where  = Where +" and adt_status not in ('08','09')";
				where_condition.append(" and adt_status not in ('08','09')");
			}
		}else if(Enc_Type.equals("EM") || Enc_Type.equals("OP")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and visit_status in ('07','08', '09')";
				where_condition.append(" and visit_status in ('07','08', '09')");
			}else{
				//Where  = Where +" and visit_status < '07' ";
				where_condition.append(" and visit_status < '07' ");
			}
		}
	}else if(call_function.equals("RECORD_DIAGNOSIS") || call_function.equals("PROCEDURE_RECORDING")){
		// else if block added for  SRR20056-SCF-6679 ---IN026201
		if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and adt_status = '08'";
				where_condition.append(" and adt_status = '08'");
			}else{
				//Where  = Where +" and adt_status not in ('08','09')";
				where_condition.append(" and adt_status not in ('09')");
			}
		}else if(Enc_Type.equals("EM") || Enc_Type.equals("OP")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and visit_status in ('07','08', '09')";
				where_condition.append(" and visit_status in ('07','08', '09')");
			}else{
				//Where  = Where +" and visit_status < '07' ";
				where_condition.append(" and visit_status not in ('99')");
			}
		}else{
				where_condition.append(" AND ((a.patient_class in ('OP','EM') and a.visit_status!=99) OR (a.patient_class in ('IP','DC') and a.adt_status !=09))");
		}

	}else{

		if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and adt_status = '08'";
				where_condition.append(" and adt_status = '08'");
			}else{
				//Where  = Where +" and adt_status not in ('08','09')";
				where_condition.append(" and adt_status not in ('09')");
			}
		}else if(Enc_Type.equals("EM") || Enc_Type.equals("OP")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and visit_status in ('07','08', '09')";
				where_condition.append(" and visit_status in ('07','08', '09')");
			}else{
				//Where  = Where +" and visit_status < '07' ";
				//where_condition.append(" and visit_status < '07' ");
				where_condition.append(" and visit_status!=99 ");/**/
			}
		}else{
				where_condition.append(" AND ((a.patient_class in ('OP','EM') and a.visit_status!=99) OR (a.patient_class in ('IP','DC') and a.adt_status !=09))");
		}
	}


	if(call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	
		if(cause_ind.equals(""))
		{
			//Where = Where + " and disposition_type in ( select discharge_type_code from ip_discharge_type where maternal_death_yn = 'Y' and eff_status = 'E') ";

			where_condition.append(" and disposition_type in ( select discharge_type_code from ip_discharge_type where maternal_death_yn = 'Y' and eff_status = 'E') ");
		}
		else
		{
			//Where = Where + " and disposition_type ='"+cause_ind+"'  ";
			where_condition.append(" and disposition_type ='"+cause_ind+"'  ");
		}
	}

	if ( !(Enc_Type == null || Enc_Type.equals("")) )
	{
		//Where = Where + " and upper(PATIENT_CLASS) like upper('"+Enc_Type+"') ";
		where_condition.append("    and PATIENT_CLASS = '"+Enc_Type+"' ");
	}
	
		if ( !(speciality_val == null || speciality_val.equals("")) )
		{
			
			//Where = Where + " and a.SPECIALTY_CODE like upper('"+speciality_val+"')  ";
			where_condition.append(" and a.SPECIALTY_CODE = '"+speciality_val+"'  ");
		}


		if ( !(location_code == null || location_code.equals("")) )
		{
			
			//Where = Where + " and a.Assign_Care_Locn_Code like upper('"+location_code+"')  ";
			where_condition.append(" and a.Assign_Care_Locn_Code like upper('"+location_code+"')  ");
		}

	/*if ( !(speciality_val == null || speciality_val.equals("")) )
	{
		Where = Where + " and a.SPECIALTY_CODE = '"+speciality_val+"' )";
	}*/

	if ( !(EncounterId == null || EncounterId.equals("")) )
	{
		//Where = Where + " and upper(a.encounter_id) like upper('"+EncounterId+"%') ";
		where_condition.append(" and a.encounter_id ='"+EncounterId+"' ");
	}

	if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && !(alt_id2_exp_date == null || alt_id2_exp_date.equals("")))
	{
		//Where = Where + " and trunc(a.visit_adm_date_time) between to_date('"+alt_id1_exp_date+"','dd/mm/yyyy') and to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')";

		where_condition.append(" and trunc(a.visit_adm_date_time) between to_date('"+alt_id1_exp_date+"','dd/mm/yyyy') and to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')");
	}

	if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && (alt_id2_exp_date == null || alt_id2_exp_date.equals("")))
	{
		//Where = Where + " and trunc(a.visit_adm_date_time) >= to_date('"+alt_id1_exp_date+"','dd/mm/yyyy')";
		where_condition.append(" and trunc(a.visit_adm_date_time) >= to_date('"+alt_id1_exp_date+"','dd/mm/yyyy')");
	}

	if ( (alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && !(alt_id2_exp_date == null || alt_id2_exp_date.equals("")))
	{
		//Where = Where + " and trunc(a.visit_adm_date_time) <= to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')";
		where_condition.append(" and trunc(a.visit_adm_date_time) <= to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')");
	}

	
	/*if ( !(p_discharge_date_from == null || p_discharge_date_from.equals("")) )
	{
		Where = Where + " and a.DISCHARGE_DATE_TIME >= to_date('"+p_discharge_date_from+"','dd/mm/yyyy hh24:mi')";
	}

	if ( !(p_discharge_date_to == null || p_discharge_date_to.equals("")) )
	{
		Where = Where + " and a.DISCHARGE_DATE_TIME <= to_date('"+p_discharge_date_to+"','dd/mm/yyyy hh24:mi')";
	}*/

	if ( !(national_id_no == null || national_id_no.equals("")) )
	{
		//Where = Where + " and upper(b.NATIONAL_ID_NO) like upper('"+national_id_no+"%') ";
		where_condition.append(" and upper(b.NATIONAL_ID_NO) = upper('"+national_id_no+"') ");//Removed '%' after national_id_no on 14th mar 2017 for ML-MMOH-SCF-0666
	}
	if ( !(alt_id1_no == null || alt_id1_no.equals("")) )
	{
		//Where = Where + " and upper(b.alt_id1_no) like upper('"+alt_id1_no+"%') ";
		where_condition.append("  and upper(b.alt_id1_no) like upper('"+alt_id1_no+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}
	if ( !(alt_id2_no == null || alt_id2_no.equals("")) )
	{
		//Where = Where + " and upper(b.alt_id2_no) like upper('"+alt_id2_no+"%') ";
		where_condition.append(" and upper(b.alt_id2_no) like upper('"+alt_id2_no+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}
	if ( !(alt_id3_no == null || alt_id3_no.equals("")) )
	{
		//Where = Where + " and upper(b.alt_id3_no) like upper('"+alt_id3_no+"%') ";
		where_condition.append(" and upper(b.alt_id3_no) like upper('"+alt_id3_no+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}
	if ( !(alt_id4_no == null || alt_id4_no.equals("")) )
	{
		//Where = Where + " and upper(b.alt_id4_no) like upper('"+alt_id4_no+"%') ";
		where_condition.append( " and upper(b.alt_id4_no) like upper('"+alt_id4_no+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}

	if ( !(other_alt_type == null || other_alt_type.equals("")) )
	{
		//Where = Where + " and upper(b.oth_alt_id_type) like upper('"+other_alt_type+"%') ";
		where_condition.append( " and upper(b.oth_alt_id_type) like upper('"+other_alt_type+"%') ");
	}
	if ( !(other_alt_Id == null || other_alt_Id.equals("")) )
	{
		//Where = Where + " and upper(b.oth_alt_Id_no) like upper('"+other_alt_Id+"%') ";
		where_condition.append( " and upper(b.oth_alt_Id_no) like upper('"+other_alt_Id+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}

	if(call_function.equals("QUERY_MARK_MLC_OSCC"))
	{
		if(PatientId.equals("") && EncounterId.equals(""))
		{
			if (mlc_oscc.equals(""))
			{
				//Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";
				where_condition.append(  "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ");
			}	
			else if (mlc_oscc.equals("O"))
			{
				//Where = Where + "and a.oscc_yn = 'Y' ";
				where_condition.append( "and a.oscc_yn = 'Y' ");
			}	
			else if (mlc_oscc.equals("M"))
			{
				//Where = Where + "and a.mlc_yn='Y' ";
				where_condition.append("and a.mlc_yn='Y' ");

			}	
		}
		else if (!PatientId.equals("") && !EncounterId.equals(""))
		{
			if (mlc_oscc.equals("")){
				//Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";
				where_condition.append("and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ");
			}else if (mlc_oscc.equals("O")){
				//Where = Where + "and a.oscc_yn = 'Y' ";
				where_condition.append("and a.oscc_yn = 'Y' ");
			}else if (mlc_oscc.equals("M")){
				//Where = Where + "and a.mlc_yn='Y' ";
				where_condition.append(" and a.mlc_yn='Y' ");
			}	
		}
		else if (!PatientId.equals(""))
		{
			if (mlc_oscc.equals("")){
				//Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";
				where_condition.append("and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ");
			}else if (mlc_oscc.equals("O")){
				//Where = Where + "and a.oscc_yn = 'Y' ";
				where_condition.append("and a.oscc_yn = 'Y' ");
			}else if (mlc_oscc.equals("M")){
				//Where = Where + "and a.mlc_yn='Y'";
				where_condition.append("and a.mlc_yn='Y'");
			}	
		}
	}

	if((call_function.equals("MARK_MLC_OSCC") || call_function.equals("QUERY_MARK_MLC_OSCC")) && (create_file_yn.equals("Y")))
	{
		//Where  = Where +" AND EXISTS (SELECT 1 FROM mr_pat_file_index WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ";
		where_condition.append(" AND EXISTS (SELECT 1 FROM mr_pat_file_index WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ");
	}

	if(call_function.equals("MR_REC_PAT_VAL")) 
	{	
		if (Discharge.equals("Y"))
		{
			//Where = Where +"and exists ( select 1 from pr_patient_valuables where facility_id = a.facility_id and encounter_id = a.encounter_id) ";
			where_condition.append("and exists ( select 1 from pr_patient_valuables where facility_id = a.facility_id and encounter_id = a.encounter_id) ");
		}
		
	}

	if ( !(orderBy == null || orderBy.equals("")) )
	{
		//Where = Where + " order by "+orderBy+" ";
		where_condition.append(" order by "+orderBy+" ");
	}


	//out.println("modal_yn==>" +modal_yn);
	//modal_yn="N";
	if(!modal_yn.equals("Y"))
	{

		//modied the below query for this SCF SKR-SCF-0970 [IN:047716] & SKR-SCF-0971 [IN:047717]
		sqlbuff.append(" SELECT   a.Patient_Id, decode(?,'en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))Patient_Name, b.Sex Gender, To_char(b.Date_Of_Birth,'dd/mm/yyyy') Birth_Date, GET_AGE(b.DATE_OF_BIRTH) AGE, To_char(a.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,?,'2') END) Speciality_desc, a.Specialty_Code Specialty_Code, DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,?,'2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,?,'1')) Locn_desc, a.Assign_Care_Locn_Code Locn_Code, (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,?,'1') END) Practitioner_Name,(CASE WHEN a.Attend_Practitioner_Id IS NOT NULL THEN (select pract_type from am_practitioner where practitioner_id=a.Attend_Practitioner_Id) ELSE '' END) Pract_type,a.attend_practitioner_id, a.Assign_Room_num Room_No, a.Assign_Bed_num Bed_No, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,?,'1') Locn_Type,a.Assign_Care_Locn_Type loc_type, b.alt_Id1_No alt_Id1_No, b.alt_Id2_No alt_Id2_No, b.alt_Id3_No alt_Id3_No, b.alt_Id4_No alt_Id4_No, AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,?,'1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yyyy hh24:mi') Discharge_Date_Time, COUNT(*) OVER () rowCount  FROM PR_ENCOUNTER a, MP_PATIENT b ");
		
		sqlbuff.append(where_condition.toString());
		//if(rs != null)rs.close();
		//if(pstmt  != null)pstmt.close();
		//pstmt = conn.prepareStatement(sqlbuff.toString());
		
		//out.println("sqlbuff.toString()==>"+sqlbuff.toString());

		p_stmt = conn.prepareStatement(sqlbuff.toString());
		p_stmt.setString(1,locale);
		p_stmt.setString(2,locale);
		p_stmt.setString(3,locale);
		p_stmt.setString(4,locale);
		p_stmt.setString(5,locale);
		p_stmt.setString(6,locale);
		p_stmt.setString(7,locale);
		rs = p_stmt.executeQuery();
		/*rs.last();
		fetchRecord = rs.getRow();
		maxRecord=fetchRecord;
		rs.beforeFirst();*/
		//if(rs.next())
		  // maxRecord = rs.getInt(1);
	}
		//if(rs != null)rs.close();
		//if(pstmt  != null)pstmt.close();
	int maxRecords=0;
	int nRowCount =0; // added for this SCF SKR-SCF-0970 [IN:047716] & SKR-SCF-0971 [IN:047717]
	%>
	<script>
		if(parent.document.getElementById("frmst_1"))	
		parent.document.getElementById("frmst_1").rows='0%,0%,15%,*%,10%,0%,0%'
	</script>
	<%
		if(!title.equals(""))	{
				out.println("<title>"+title+"</title>");
			}
			if(call_from.equals("MAIN"))
			{
				title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterdetails.label","common_labels");
				out.println("<title>"+title+"</title>");
			}
	    if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
		if(!flag.equals("true")){%>	
			<table width='100%' id='navigate_table' style="display:none">
				<tr>
					<table align='right' border='0' >
							<tr>
							<%
									if ( !(start <= 1)){%>
										<td align ='right'><A HREF='javascript:submitPrevNext("<%=(start-10)%>","<%=(end-10)%>","<%=fetchRecord%>","Previous")' text-decoration='none'  id='prev'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>					
										<%}%>
										<td align ='right' ><A HREF='javascript:submitPrevNext("<%=(start+10)%>","<%=(end+10)%>","<%=fetchRecord%>","Next")' text-decoration='none' style="display:none;" id='next'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
							</tr>
					</table>
				</tr>
			</table>
			<br>
			
			<%
			if(!PatientId.equals("")){%>
				<table border="1" cellpadding="0" cellspacing="0" align='center' width="100%" id="pat_line" style="display:none">
					<tr>
						<%if(!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("MEDICAL_REPORT_REQUEST")){	%>
						<td>
							<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name="Patient_ID" value="<%=PatientId%>" />				
							</jsp:include> 
						</td>
						<%}%>
					</tr>
				</table>
			<%}%>		
			<table border="1" style="width: 100vw;" cellspacing='0' cellpadding='0' align='center'>
				<thead id="table_header" style="display:none">
					<%if(!call_function.equals("QUERY_MATERNAL_REPORT")){%>
						<th align='center' nowrap>&nbsp;</th>
					<%}%>
					<% if(	!call_function.equals("MARK_MLC_OSCC") && 
					!call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_INTERNAL_REPORTS_REPRINT")&&  !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")&&
					!call_function.equals("QUERY_MARK_MLC_OSCC") &&
					!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("RECORD_DIAGNOSIS") && !call_function.equals("PROCEDURE_RECORDING") && !call_from.equals("MAIN")){%>
						<th align='center' nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><BR><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,"<%=start%>","<%=end%>");'></th>
						<!--<th align='center' nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><BR><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll_S(this);'></th>-->
					<%}
					//if(call_function.equals("DIAG_RECODE"))	{%>
					<!-- <th align='center' nowrap><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></th> -->
					<%//}
					%>
						<th align='center' nowrap><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th>
					<%	if(!call_function.equals("QUERY_MARK_MLC_OSCC")){%>
						<th align='center' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
					<%}	
					//if(call_function.equals("DIAG_RECODE")){%>
					<!-- <th align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th> -->
					<%//}
					%>
						<th align='center' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
					<%if(call_function.equals("QUERY_MARK_MLC_OSCC") || call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL")){
						if (PatientId.equals("")){%>
							<th align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th> 
						<%} 
					}
					if(call_function.equals("MR_INTERNAL_REPORTS_REPRINT")){
						if (PatientId.equals("")){	%>
							<th align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th> 
						<%}
					}
					if(call_function.equals("QUERY_MATERNAL_REPORT")){	%>
						<td class="COLUMNHEADER" nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
					<%}	
					if(!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL")  && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("RECORD_DIAGNOSIS") && !call_function.equals("PROCEDURE_RECORDING")){	%>
						<th align='center' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
					<%}%>
					<th align='center' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
					<th align='center' nowrap><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></th>
					<th align='center' nowrap><fmt:message key="Common.room.label" bundle="${common_labels}"/></th>
					<th align='center' nowrap><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></th>
					<th align='center' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			</thead>
			<%
			String chkAttribute = "";
			if (rs != null){
					if (start !=1){
						for( int j=1; j<start; i++,j++ ){
						rs.next() ;
					}
				}
				while ( rs.next() && i<=end ){
					nRowCount = Integer.parseInt(rs.getString("rowCount"));//Added for SKR-SCF-0970 [IN:047716] & SKR-SCF-0971 [IN:047717]
						if(maxRecords==0){%>
							<SCRIPT LANGUAGE="JavaScript">
							<!--
								document.getElementById("navigate_table").style.display="";
								document.getElementById("table_header").style.display="";
							//-->
							</SCRIPT>
						<%}
						if ( i % 2 == 0 ){
							classValue = "QRYEVENSMALL" ;
						}else{
							classValue = "QRYODDSMALL" ;
						}
						Patient_ID					= rs.getString("patient_id");	
						String Patient_Name		= rs.getString("patient_name");				
						String conGender			= rs.getString("gender");				
						String Date_of_Birth		= rs.getString("birth_date");				
						String Age						= rs.getString("AGE");				
						String Patient_Class		= rs.getString("patient_class");	
						String Encounter_Date	= rs.getString("encounter_date");				
						Encounter_ID				= rs.getString("encounter_id");				
						String con_Speciality		= rs.getString("speciality_desc");				
						String specialty_code	= checkForNull(rs.getString("specialty_code"));				
						String con_Location		= rs.getString("locn_desc");				
						String con_Practitioner	= rs.getString("practitioner_name");				
						attend_practitioner_id	= rs.getString("attend_practitioner_id");				
						String room_no				= checkForNull(rs.getString("room_no"));				
						String bed_no				= checkForNull(rs.getString("bed_no"));				
						locn_type						= checkForNull(rs.getString("locn_type"));		
						locn_code						= rs.getString("locn_code");				
						String Encounter_Type = rs.getString("locn_type");
						String Patient_Class_code	 = rs.getString("patient_class_code");
						String Encounter_Date_display = "";
						String pract_type						= checkForNull(rs.getString("Pract_type"));
						loc_type									= checkForNull(rs.getString("loc_type"));
						String pat_det=Patient_ID+"`"+Encounter_ID;
						if(MedicalReportReq.containsObject(pat_det)){  
							chkAttribute = "CHECKED";
						}else{
							chkAttribute="";
						}
						out.println("<input type='hidden' name='select_val"+i+"' id='select_val"+i+"' value='"+pat_det+"'>");
						int recordIndex = MedicalReportReq.indexOfObject(pat_det);
						if(recordIndex!=-1)
						if(chkAttribute.equals("CHECKED")){
							MedicalReportReq.removeObject(recordIndex);
						}
						//String level1_status = "";
						//String level2_status = "";
						//String level3_status = "";
						//String Lvl_disp="";
						if(Patient_ID==null||Patient_ID.equals("null")){		    
							Patient_ID = "";
						}
						if(Patient_Name==null||Patient_Name.equals("null")){
							Patient_Name = "";
						}
						if(conGender==null|| conGender.equals("null")){
							conGender = "";
						}
						if(Date_of_Birth==null || Date_of_Birth.equals("null")){
							Date_of_Birth = "";
						}
						if(Patient_Class==null|| Patient_Class.equals("null")){
							Patient_Class = "";
						}
						if(Encounter_Date==null || Encounter_Date.equals("null")){
							Encounter_Date = "";
							Encounter_Date_display = "";
						}else{
							Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
						}
						if(Encounter_ID==null|| Encounter_ID.equals("null")){
							Encounter_ID = "";
						}
						if(con_Speciality==null|| con_Speciality.equals("null")){
							con_Speciality = "&nbsp;";
						}
						if(con_Location==null|| con_Location.equals("null")){
							con_Location = "&nbsp;";
						}
						if(con_Practitioner==null || con_Practitioner.equals("null")){
							con_Practitioner = "&nbsp;";
						}
						if(room_no==null || room_no.equals("null")){
							room_no = "&nbsp;";
						}
						if(bed_no==null || bed_no.equals("null")){
							bed_no = "&nbsp;";
						}
						if(locn_type==null || locn_type.equals("null")){
							locn_type = "&nbsp;";
						}
						if(Encounter_Type==null || Encounter_Type.equals("null")){
							Encounter_Type = "&nbsp;";
						}
						out.println("<tr>");

						if(!call_function.equals("QUERY_MATERNAL_REPORT"))	{
							if(call_from!=null && call_from.equals("MAIN")){%>
								<td nowrap class='<%=classValue%>' style="color:blue;cursor:pointer;" onclick="closeWindowval('<%=Encounter_ID%>','<%=Patient_ID%>','N','<%=Patient_Class_code%>');" >+</td>
							<%}else{
								out.println("<td  class='"+classValue+"'>");
								out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"','"+call_function+"','"+install_yn+"')\">");	
								out.print("+</a></td>");
							}
						}
						if(!call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")  && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT")  && !call_function.equals("RECORD_DIAGNOSIS") && !call_function.equals("PROCEDURE_RECORDING") && !call_from.equals("MAIN")){
							out.println("<td nowrap class='"+classValue+"' ><input type=checkbox name='chk"+i+"' id='chk"+i+"' id='check_box' value='"+i+"' onClick='javascript:RemSelectAll();chkServices(this);' /></td>");
						%>
						<!--<td nowrap class=<%=classValue%>><input type = 'checkbox' name = 'chk<%=i%>' id='check_box' value='' onClick="javascript:react_chkbox(this.value,'<%=i%>')"/></td>-->
						<%
						}
						out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
						if(!call_function.equals("QUERY_MARK_MLC_OSCC")){
							out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
						}
						if(call_function.equals("MARK_MLC_OSCC") ){
							out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:calladdmodifyMark('"+Encounter_ID+"','MARK_MLC_OSCC','"+Patient_ID+"','"+FacilityId+"')\">"+Encounter_ID+"</a></td>");
						}else if(call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL") || call_function.equals("MR_INTERNAL_REPORTS_REPRINT")){
							//if(reportname.equals("MRBPATVL"))
							//{
							if (!PatientId.equals("")){
								out.println("<td nowrap class='"+classValue+"'><a href=javascript:patientValuables('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+specialty_code+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
								//added  FacilityId for SCR 5008 
							}else if(PatientId.equals("")){
								out.println("<td nowrap class='"+classValue+"'><a href=javascript:patientValuables('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+specialty_code+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
								out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+"</td>");
							}
							//}
						}else if(call_function.equals("TRANSMIT_NOTIFY_REP")){
							out.println("<td nowrap class='"+classValue+"'><a href=javascript:DiagnososTransmissionDtls('"+Encounter_ID+"','"+Patient_ID+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
							//added FacilityId for SCR 4943
						}else if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
							out.println("<td nowrap class='"+classValue+"'><a href=javascript:DiagnososConfirmationDtls('"+Encounter_ID+"','"+Patient_ID+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
							//added FacilityId for SCR 4943
						}else if(call_function.equals("QUERY_MARK_MLC_OSCC")){
							if (!PatientId.equals("")){
								out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
							}else if(PatientId.equals("")){
								out.println("<td nowrap class='"+classValue+"'>"+Encounter_ID+"</td>");
								out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"','"+FacilityId+"')>"+Patient_ID+"</a></td>");
							}
						}else if(call_function.equals("QUERY_MATERNAL_REPORT")){	
							out.println("<td class='"+classValue+"'>");
							out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+""+"')\">");	
							out.print(""+Encounter_ID+"</a></td>");
						}else if(call_function.equals("RECORD_DIAGNOSIS")){
							//out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecordDiagnosis('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+Patient_Class_code+"','"+conGender+"','"+Date_of_Birth+"','"+pract_type+"','"+specialty_code+"','"+bed_no+"','','"+room_no+"','')>"+Encounter_ID+"</a></td>");
							out.println("<td nowrap class='"+classValue+"'>");
							%><a href="javascript:RecordDiagnosis('<%=Encounter_ID%>','<%=Patient_ID%>','<%=locn_code%>','<%=Patient_Class_code%>','<%=conGender%>','<%=Date_of_Birth%>','<%=pract_type%>','<%=specialty_code%>','<%=bed_no%>','<%=loc_type%>','<%=room_no%>','<%=Encounter_Date%>','<%=FacilityId%>','<%=attend_practitioner_id%>')"><%=Encounter_ID%></a></td>
						<%}else if(call_function.equals("PROCEDURE_RECORDING")){
							//out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecordProcedure('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+Patient_Class_code+"','"+conGender+"','"+Date_of_Birth+"','"+pract_type+"','"+specialty_code+"','"+bed_no+"','','"+room_no+"')>"+Encounter_ID+"</a></td>");
							out.println("<td nowrap class='"+classValue+"'>");
							%><a href="javascript:RecordProcedure('<%=Encounter_ID%>','<%=Patient_ID%>','<%=locn_code%>','<%=Patient_Class_code%>','<%=conGender%>','<%=Date_of_Birth%>','<%=pract_type%>','<%=specialty_code%>','<%=bed_no%>','','<%=room_no%>','<%=Encounter_Date%>','<%=FacilityId%>','<%=attend_practitioner_id%>')"><%=Encounter_ID%></a></td>
						<%
						}else if(call_from.equals("MAIN")){%>
							<!--<a href='javascript:DummyRef()'	onClick="sendtomain('<%=Encounter_ID%>');"><%=Encounter_ID%></a>-->
							<td nowrap class='<%=classValue%>' style="color:blue;cursor:pointer;" onclick="sendtomain('<%=Encounter_ID%>');" ><%=Encounter_ID%></td>
						<%}else{	
							out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
						}
						if(call_function.equals("QUERY_MATERNAL_REPORT")){	
							out.println("<td nowrap class='"+classValue+"'>" +Patient_Name+"</td>");
						}
						if(!call_function.equals("QUERY_MATERNAL_REPORT")&&!call_function.equals("MEDICAL_REPORT_REQUEST")&&!call_function.equals("MARK_MLC_OSCC")&& !call_function.equals("DIAG_RECODE") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("RECORD_DIAGNOSIS") && !call_function.equals("PROCEDURE_RECORDING")){	
							out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"</td>");
						}
						out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"/"+con_Location+"</td>");
						out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
						//out.println("<td nowrap class='"+classValue+"'>" +room_no+"</td>");
						//out.println("<td nowrap class='"+classValue+"'>" +bed_no+"</td>");
						%>
						<td nowrap class='<%=classValue%>'>&nbsp;<%=room_no%></td> 
						<td nowrap class='<%=classValue%>'>&nbsp;<%=bed_no%></td>
						<%
						out.println("<td nowrap class='"+classValue+"'>"+con_Practitioner+"</td>");
						out.println("</tr>");
						i++;
						maxRecords++;
					}//End of while
				}//End of If
				if(maxRecords>0){
				if(!PatientId.equals("")){%>
					<script>
						document.getElementById("pat_line").style.display="";
					</script>
				<%}
				}
			if (maxRecords==0 && !modal_yn.equals("Y")){
					if (call_from.equals("MAIN")){%>
						<script>
							alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
							parent.window.close();
					    </script>	
					<%}else if (call_function.equals("MARK_MLC_OSCC") || call_function.equals("PROCEDURE_RECORDING")){%>
						<script>
							alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
						</script>			
					<%}else{%>
							<script>
								if(parent.document.getElementById("frmst_1")){
									parent.document.getElementById("frmst_1").rows='0%,0%,0%,*%,10%,0%,0%'
								}
								if(document.getElementById("pat_line")){
									document.getElementById("pat_line").style.display="none";
								}
								alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
							</script> <%
							out.println("<script>if(parent.frames[3].name!='messageFrame'  && parent.frames[3].document.forms[0].showPrevDtls)parent.frames[3].document.forms[0].showPrevDtls.disabled=true;</script>");
							}
				}
				//if ( maxRecords<10 || (!rs.next()) ) { 
				//Above line commented and added for SKR-SCF-0970 [IN:047716] & SKR-SCF-0971 [IN:047717]
				if ( maxRecords<10 || (end >= nRowCount) ) { 
				%>
				<script >
					if (document.getElementById("next")){
						document.getElementById("next").style.display='none';
					}
				</script>
				<%}else{%>
				<script >
						if (document.getElementById("next")){
							document.getElementById("next").style.display='';
						}
				</script>



				<%}
					if(rs != null)rs.close();
					if(pstmt  != null)pstmt.close();
				%>
		</table>
	<%}else{ //if(flag.equals("true"))
	/// DISPLAY IN MODAL WINDOW
	if(call_function.equals("MEDICAL_REPORT_REQUEST")){
		sqlbuff.append(" SELECT   a.Patient_Id, decode(?,'en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))Patient_Name, b.Sex Gender, To_char(b.Date_Of_Birth,'dd/mm/yyyy') Birth_Date, GET_AGE(b.DATE_OF_BIRTH) AGE, To_char(a.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,?,'2') END) Speciality_desc, a.Specialty_Code Specialty_Code, DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,?,'2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,?,'1')) Locn_desc, a.Assign_Care_Locn_Code Locn_Code, (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,?,'1') END) Practitioner_Name,(CASE WHEN a.Attend_Practitioner_Id IS NOT NULL THEN (select pract_type from am_practitioner where practitioner_id=a.Attend_Practitioner_Id) ELSE '' END) Pract_type,a.attend_practitioner_id, a.Assign_Room_num Room_No, a.Assign_Bed_num Bed_No, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,?,'1') Locn_Type,a.Assign_Care_Locn_Type loc_type, b.alt_Id1_No alt_Id1_No, b.alt_Id2_No alt_Id2_No, b.alt_Id3_No alt_Id3_No, b.alt_Id4_No alt_Id4_No, AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,?,'1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yyyy hh24:mi') Discharge_Date_Time FROM PR_ENCOUNTER a, MP_PATIENT b ");
		
		sqlbuff.append(where_condition.toString());
		// added by N Munisekhar on 20-AUG-2013 against RUT-SCF-0282 [IN:042499]
		sqlbuff.append(" order by "+orderBy_ind+" ");
		//if(rs != null)rs.close();
		//if(pstmt  != null)pstmt.close();
		//pstmt = conn.prepareStatement(sqlbuff.toString());					
		p_stmt = conn.prepareStatement(sqlbuff.toString());
		p_stmt.setString(1,locale);
		p_stmt.setString(2,locale);
		p_stmt.setString(3,locale);
		p_stmt.setString(4,locale);
		p_stmt.setString(5,locale);
		p_stmt.setString(6,locale);
		p_stmt.setString(7,locale);
		rs = p_stmt.executeQuery();
	}
	%>
	<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
		<TR><td colspan=6 class="white">&nbsp;</td></TR>
		</table>
		<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
		<TR>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td> 
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td> 
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<th class="COLUMNHEADER" nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<th class="COLUMNHEADER" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<th class="COLUMNHEADER" nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
		</TR>
			<input type='hidden' name='tempIDS' id='tempIDS'  >
			<input type='hidden' name='encIDS' id='encIDS' >
		<%

//	out.println("<script>alert(\"chkSelect "+chkSelect+"\");</script>");

	if(!chkSelect.equals("") && !chkSelect.equals("SELECTALL"))
	{
		TreeMap ssm=new TreeMap();
		String selitem="";
		selitem=(request.getParameter("selitem")==null) ? "" : request.getParameter("selitem");
		if(!selitem.equals("")){
		selitem=selitem.substring(1);
		selitem=selitem.substring(0,selitem.length()-1);
		}
		
		StringTokenizer st=new StringTokenizer(chkSelect,"~");	
		

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
//out.println("RS====>" +rs);
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
					classValue = "QRYEVENSMALL" ;
				else
					classValue = "QRYODDSMALL" ;

				 Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Age=rs.getString("AGE");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				 Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
//				String specialty_code=rs.getString("specialty_code");				
				String con_Location=rs.getString("locn_desc");				
//				locn_code=rs.getString("locn_code");				
				String con_Practitioner=rs.getString("practitioner_name");				
				attend_practitioner_id=rs.getString("attend_practitioner_id");		
				//String pract_type = checkForNull(rs.getString("Pract_type"));
				locn_type=rs.getString("locn_type");	
				String Encounter_Date_display = "";
				if(locn_type==null	      || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("discharge_date_time");	
				String Dis_dateTime_display = "";
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
				{
					Dis_dateTime = "&nbsp;";
					Dis_dateTime_display = "&nbsp;";
				}
				else
					Dis_dateTime_display = DateUtils.convertDate(Dis_dateTime,"DMYHM","en",locale);

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))		Patient_Name = "&nbsp";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "&nbsp";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))		Date_of_Birth = "&nbsp;";
				if(Age==null	  || Age.equals("null"))		Age = "&nbsp;";
				if(Patient_Class==null	  || Patient_Class.equals("null"))		Patient_Class = "";
				
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))
				{
					Encounter_Date = "";
					Encounter_Date_display = "";
				}
				else
					Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
				
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
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime_display+"</td>");
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
	else if(chkSelect.equals("") || chkSelect.equals("SELECTALL"))
	{


		if (rs != null)
		{
			int clsCnt=1;
			while(rs.next())
			{
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVENSMALL" ;
				else
					classValue = "QRYODDSMALL" ;

				 Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Age=rs.getString("AGE");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				 Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
//				String specialty_code=rs.getString("specialty_code");				
				String con_Location=rs.getString("locn_desc");				
//				locn_code=rs.getString("locn_code");				
				String con_Practitioner=rs.getString("practitioner_name");			
				attend_practitioner_id=rs.getString("attend_practitioner_id");			
				locn_type=rs.getString("locn_type");
				//String pract_type = checkForNull(rs.getString("Pract_type"));
				
				String Encounter_Date_display = "";
				if(locn_type==null || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("DISCHARGE_DATE_TIME");	
				String Dis_dateTime_display = "&nbsp;";
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
				{
					Dis_dateTime = "&nbsp;";
					Dis_dateTime_display = "&nbsp;";
				}
				else
					Dis_dateTime_display = DateUtils.convertDate(Dis_dateTime,"DMYHM","en",locale);

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))
					Patient_Name = "";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
					Date_of_Birth = "";
				if(Age==null	  || Age.equals("null"))
					Age = "";
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
					con_Speciality = "";
				if(con_Location==null	  || con_Location.equals("null"))
					con_Location = "";
				if(con_Practitioner==null || con_Practitioner.equals("null"))
					con_Practitioner = "";
				out.println("<tr>");				
//				out.println("<td nowrap class='"+classValue+"'>" +Patient_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime_display+"</td>");
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
	%>
	</TABLE>
<%}	}%>
	<input type='hidden' name='stage_no' id='stage_no' value="<%=stage_no%>">
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
	<input type='hidden' name='call_from' id='call_from' value="<%=call_from%>" >
	<input type='hidden' name='to' id='to' value="<%=end%>" >
	<input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect%>'>
	<input type='hidden' name='temp1' id='temp1' value='<%=temp1%>'>
	<input type='hidden' name='criteria' id='criteria' value='<%=criteria%>'>
	<input type='hidden' name='lstPatientClass' id='lstPatientClass' value="<%=Enc_Type%>" >
	<input type='hidden' name='orderBy' id='orderBy' value="<%=orderBy%>" >
	<input type='hidden' name='orderBy_ind' id='orderBy_ind' value="<%=orderBy_ind%>" >
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
	<input type='hidden' name="status_to_show" id="status_to_show" value="<%=status_to_show%>">
	<input type='hidden' name="from_date" id="from_date" value="<%=from_date%>">
	<input type='hidden' name="to_date" id="to_date" value="<%=to_date%>">
	<input type='hidden' name="attend_practitioner_id" id="attend_practitioner_id" value="<%=attend_practitioner_id%>">
	<input type='hidden' name="Enc_id" id="Enc_id" value="">
	<input type='hidden' name="EncounterId" id="EncounterId" value="">
	<input type='hidden' name="Pat_id" id="Pat_id" value="<%=PatientId%>">
	<input type='hidden' name="temp2" id="temp2" value="<%=temp2%>">
	<input type='hidden' name="enc_temp" id="enc_temp" value="<%=enc_temp%>">
	<input type='hidden' name="pat_temp" id="pat_temp" value="<%=pat_temp%>">
	<input type='hidden' name='finalSelect1' id='finalSelect1' value='<%=finalSelect1%>'>
	<input type='hidden' name='status' id='status' value='<%=status%>'>
	<input type='hidden' name='Patient_ID' id='Patient_ID' value='<%=Patient_ID%>'>
	<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_val%>'>
	<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
	<input type='hidden' name='sel_cnt' id='sel_cnt' value='<%=sel_cnt%>'>
	<input type='hidden' name='enc_cnt' id='enc_cnt' value='<%=maxRecord%>'>
	<input type='hidden' name='maxRecord' id='maxRecord' value='<%=maxRecord%>'>
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
	<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
	<input type='hidden' name='reportname' id='reportname' value='<%=reportname%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=FacilityId%>'>
	<input type='hidden' name='start' id='start' value='<%=start%>'>
	<input type='hidden' name='end' id='end' value='<%=end%>'>
	<input type='hidden' name='discharge_val' id='discharge_val' value='<%=Discharge%>'>
	<br>
<%
if(!finalSelect.equals("SELECTALL")){
	
	StringTokenizer st=new StringTokenizer(finalSelect,"~");
	String objName="";
	String enable_dis="";
	int temp=st.countTokens();

	for(int u2=0;u2<temp;u2++)
	{
		String st2=st.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");
		//st1.nextToken();
		objName=st1.nextToken();
		enable_dis=st1.nextToken();

		if(enable_dis.equals("E"))
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=true;</script>");
		//else
			//out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=false;</script>");
	}
}
%>
<%
	if(call_function.equals("DIAG_RECODE") && maxRecord != 0)
	{

%>


<table align='right'>

	<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td class='label' >&nbsp;</td>
	<td class="button"><input type='button' name='select_but' id='select_but' id='select1' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Select.label","mr_labels")%>' onClick="recodeModal('<%=fetchRecord%>');"></td>
	</tr>
	</table>
<%
	}



}catch ( Exception e ){ 
	e.printStackTrace();
}

finally
{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(conn,request);
	session.setAttribute("MedicalReportReq", MedicalReportReq);
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

</form>
</body>
</html>

