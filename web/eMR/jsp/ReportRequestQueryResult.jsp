<!DOCTYPE html>
<!-- 
/**
* Added by SRIDHAR R on 3/31/2005 ...
* Indication of Function ID with thier REQUEST_STATUS inserted into MR_REPORT_REQUEST_HDR table after each transaction is complete... 
* Query is fired based on the foll function id & req status as where clauses...
* All the following functions use this page for displaying records in result page...

* @Transaction Name = "MEDICAL REPORT"
 **************************************************************************************
			Function name				|		Function ID			| REQUEST_STATUS 
 ************************************************************************************** 
	Medical Report Request				|	MEDICAL_REPORT_REQUEST	|		1
	Status of Medical Report Request	|	MEDICAL_REPORT_STATUS	|		2 
	Forward Medical Report Request		|	FORWARD_MEDICAL_REPORT	|		3 
	Prepare Med Report By Practitioner	|	PREPARE_MEDICAL_REPORT	|		4 
	Receive Medical Report				|	RECEIVE_MEDICAL_REPORT	|		5 
	Deliver Medical Report				|	DELIVER_MEDICAL_REPORT	|		6 
	Revise Medical Report				|	REVISE_MEDICAL_REPORT	|		0
	Status of Medical Report Request
	Incomplete							|	INCOMPLETE_REPORT_STATUS|		7
	Medical Report Cancelled			|	CANCELLED_MEDICAL_REPORT|		8
	Medical Report Auto Cancelled		|							|		99
 **************************************************************************************

* @Transaction Name = "MEDICAL BOARD"
 **************************************************************************************
			Function name				|		Function ID			| REQUEST_STATUS 
 **************************************************************************************
	Request For Medical Board			| MEDICAL_BOARD_REQUEST		|		1
	Status of Medical Board Request		| MEDICAL_BOARD_STATUS		|		2
	Formation of Medical Board			| MEDICAL_BOARD_FORMATION	|		4
	Forward Medical Board Request		| FORWARD_MEDICAL_BOARD		|		4
	Appointment for Med Board request	| MEDICAL_BOARD_APPT		|		5
	Intimate Appointment of Med Board	| MEDICAL_BOARD_INT_APPT	|		6
	Prepare Medical Report by Board		| PREPARE_MEDICAL_BOARD		|		7
	Receive Medical Report				| RECEIVE_MEDICAL_BOARD		|		8
	Deliver/Dispatch Medical Report		| DELIVER_MEDICAL_REPORT	|		9
	Revise Medical Board				| REVISE_MEDICAL_BOARD		|		0
 **************************************************************************************
*/
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.ConnectionManager,java.sql.Statement,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.net.URLEncoder,org.json.simple.*,java.util.*" %>
<%	
	String locale = (String)session.getAttribute("LOCALE"); 
	String call_function	= checkForNull(request.getParameter("call_function"));
	String title	= checkForNull(request.getParameter("title"));
	String loginUser = ((String)session.getValue("login_user")==null)?"":(String)session.getValue("login_user"); // added by mujafar for ML-MMOH-CRF-1280
	String loginPractId  = ((String)session.getValue("ca_practitioner_id")==null)?"":(String)session.getValue("ca_practitioner_id"); 
%>
<%! 
public String singleToDoubleQuotes(String strDB)
{
    /*
	StringBuffer stringbuffer = new StringBuffer(strDB);
    String strModified="";
	int i = 0;
	
	for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
	{
		i = strDB.indexOf('\'', i);
		stringbuffer.insert(i + j, "'");
		i++;
	}
	strModified=stringbuffer.toString();
	return strModified;
	*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
 
<%	if(title.equals("PREV_DEL_REPORT"))
	{	%>
		<title><fmt:message key="eMR.PrevDelMedReport.label" bundle="${mr_labels}"/></title>
<%	}	%>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>

	<script>
	async function callModalWindow(revise_stat, req_id, call_func, pat_id, appointment_date, med_board_type, enc_id, appt_ref_no, req_status, overdue_yn,curr_dt,request_status ) // request_status added by mujafar for ML-MMOH-CRF-0714
	{	
		var req_type = document.forms[0].request_type.value;
		request_status = request_status.replace("_"," "); // request_status added by mujafar for ML-MMOH-CRF-0714
		
		var isMedicalTeamApplicable= document.forms[0].isMedicalTeamApplicable.value; //  added by mujafar for ML-MMOH-CRF-0710
		var isAcceptRequestByPractAppl = document.forms[0].isAcceptRequestByPractAppl.value;
		// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
		
		
		if(req_type == "MB"){
			if(req_status == "1")	{
				call_func = "MEDICAL_BOARD_STATUS";
			//dialogHeight= "31";	
			}else if(req_status == "2" ){
				call_func = "MEDICAL_BOARD_FORMATION";
			//dialogHeight= "32";	
			}else if(req_status == "3"){
				call_func = "FORWARD_MEDICAL_BOARD";
			//dialogHeight= "30";	
			}else if(req_status == "4"){
				call_func = "MEDICAL_BOARD_APPT";
			//dialogHeight= "34";	
			}else if(req_status == "5"){
			call_func = "MEDICAL_BOARD_INT_APPT";
			//dialogHeight= "32";	
			}else if(req_status == "6"){
				call_func = "PREPARE_MEDICAL_BOARD";
			//dialogHeight= "32";	
			}else if(req_status == "7"){
				call_func = "RECEIVE_MEDICAL_BOARD";
			//dialogHeight= "30";	
			}else if(req_status == "8"){
				call_func = "DELIVER_MEDICAL_BOARD";
			//dialogHeight= "32";	
			}if(overdue_yn == "Y" ){ // do not add this in IfElse loop..
				call_func = "REVISE_MEDICAL_BOARD";
			//dialogHeight= "30";	
			}
			if(req_status == "9"){ // do not add this in IfElse loop..
				call_func = "MEDICAL_BOARD_COMPLETED";
			//dialogHeight= "32";	
			}
		}
		if(req_type == "MR" && overdue_yn == "Y" ){
			call_func = "REVISE_MEDICAL_REPORT";
			//dialogHeight= "30";	
		}		
	
		if(call_func == 'MEDICAL_BOARD_APPT' ){
			//getApptDetails(req_id, call_func, pat_id, appointment_date );
			getApptDetails(req_id, call_func, pat_id, appointment_date,"","","","","","","","","MR","","","","",curr_dt);
		}else{
			var called_from = parent.criteriaFrame.document.forms[0].called_from.value;
			var jsp_name	= "";
			if(call_func == 'MEDICAL_BOARD_STATUS' || call_func == 'FORWARD_MEDICAL_BOARD' || call_func == 'PREPARE_MEDICAL_BOARD' || call_func == 'RECEIVE_MEDICAL_BOARD' || call_func == 'MEDICAL_BOARD_INT_APPT' || call_func == 'DELIVER_MEDICAL_BOARD' || call_func == 'MEDICAL_BOARD_COMPLETED' || call_func == 'REVISE_MEDICAL_BOARD'){
				jsp_name	= "MedBoardTransactionsFrames.jsp";
			}else if(call_func == 'MEDICAL_BOARD_FORMATION'){
				jsp_name	= "MedBoardRequestFormation.jsp";
			}else{
				jsp_name	= "MedRecRequestRecordMain.jsp";
			}
			if(call_func == 'PREPARE_MEDICAL_BOARD'){
				if(appt_ref_no != ''){
					if(pat_id ==''){
						alert(getMessage('PATIENT_NOT_REGISTERED','MR')); 
						return;
					}else if(enc_id ==''){
						var err = getMessage('PATIENT_NOT_REGISTERED','MR'); 
						err= err.replace(getLabel("Common.patient.label","Common"), getLabel("Common.encounter.label","Common"));
						alert(err);
						return;
					}
				}else{
					alert(getMessage('APPT_NOT_GIVEN','MR')); 
					return;
				}
			}
			
			
						
			var dialogHeight= "94vh";	
			var dialogWidth	= "90vw";				
			//Added for this CRF ML-MMOH-CRF-0716
            if(isMedicalTeamApplicable=="true")	dialogWidth	= "90vw";	
			
			var dialogTop	= "72";
			var retVal		= new String();
			var center		= "1" ;
			var status		= "no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			if(called_from == 'CA'){
				if(call_func == 'PREPARE_MEDICAL_REPORT' || call_func == 'PREPARE_MEDICAL_BOARD'){ 
					//retVal			= window.open("../../eMR/jsp/"+jsp_name+"?revise_stat="+revise_stat+"&call_function="+call_func+"&request_id="+req_id+"&PatientId="+pat_id+"&called_from="+called_from+"&med_board_type="+med_board_type+"&req_status="+req_status+"&overdue_status="+overdue_yn,'MR','height=600,width=1100,top=72,left=0,resizable=no,toolbar=no,menubar=no');
					retVal			= await top.window.showModalDialog("../../eMR/jsp/"+jsp_name+"?isAcceptRequestByPractAppl="+isAcceptRequestByPractAppl+"&revise_stat="+revise_stat+"&call_function="+call_func+"&request_id="+req_id+"&PatientId="+pat_id+"&called_from="+called_from+"&med_board_type="+med_board_type+"&req_status="+req_status+"&overdue_status="+overdue_yn,arguments,features);/*Modified on 18-Nov-15 against IN058304*/
					// modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316		
				}
			}else{ 
			
				retVal			= await top.window.showModalDialog("../../eMR/jsp/"+jsp_name+"?isAcceptRequestByPractAppl="+isAcceptRequestByPractAppl+"&revise_stat="+revise_stat+"&call_function="+call_func+"&request_id="+req_id+"&PatientId="+pat_id+"&called_from="+called_from+"&med_board_type="+med_board_type+"&req_status="+req_status+"&overdue_status="+overdue_yn+"&request_status_des="+request_status,arguments,features); // request_status added by mujafar for ML-MMOH-CRF-0714
				// modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				
			}
		}
		if(called_from == 'CA'){
			parent.resultFrame.document.location.reload();
		}
		if(parent.frames[3].name == "resultFrame"){
				parent.frames[3].document.location.reload();
		}else{
			parent.resultFrame.document.location.reload();
		}
	}
	//function getApptDetaisl added by kishore on 3/30/2005
	async function getApptDetails(req_id, call_func, pat_id, appt_date,P_practitioner_id,P_locn_code,recall_date,P_locn_code,P_locn_type,splty_code,selectedPractId,selectedLocnCode,callingMode,module_id,no_dwm,visittype,dwm_desc,curr_dt){

		var retVal		= 	new String();
		var dialogHeight= "40vh" ;
		var dialogWidth = "65vw" ;
		var dialogTop 	= "71";
		var center		= "1" ;
		var status		= "no";

		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

		//var P_practitioner_id,P_practitioner_id,P_patient_id,P_locn_code,P_locn_code,recall_date,P_locn_code,P_locn_type,splty_code,selectedPractId,selectedLocnCode;
		//var referral_id = "N" ;
		var referral_id = "" ;

		var parameters	= "i_practitioner_id="+P_practitioner_id+"&practitioner_id="+P_practitioner_id+"&patient_id="+pat_id+"&i_clinic_code="+P_locn_code+"&clinic_code="+P_locn_code+"&recall_date="+recall_date+"&location_code="+P_locn_code+"&care_locn_ind="+P_locn_type+"&specialty_code="+splty_code+"&selectedPractId="+selectedPractId+"&selectedLocnCode="+selectedLocnCode+"&referral_id="+referral_id+"&request_id="+req_id+"&appt_date="+appt_date+"&callingMode=MR&module_id="+module_id+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc;


		var splitdate1	=appt_date.split("/")
		var splitsysdate	= curr_dt.split("/")
		var mon = eval(splitdate1[1]) - 1; // because in the date constructor, months must be specified in the range  0 - 11

		var from_date  =new Date(splitdate1[2], mon, splitdate1[0])
		mon = eval(splitsysdate[1]) - 1;

		var to_date  =new Date(splitsysdate[2], mon,splitsysdate[0])


		//condition modified for the incident ML-BRU-SCF-0055 [31055] by Shanthi on 15-2-2012

		if(Date.parse(to_date) > Date.parse(from_date)){
//		if(Date.parse(to_date) < Date.parse(from_date)){
		//if(isBeforeNow(appt_date,'DMY','en')){
		//if(isBefore(appt_date,'30/03/2010',"DMY",'en')){
			alert(getMessage('APPT_LESS_THAN_SYSDATE_CANT_PROCEED','MR'));
		}
		else{
			retVal =await window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?"+parameters,arguments,features);
		}
		if(retVal != null && retVal != ""){
			var Val = retVal.split("^");
			var mode = Val[0];
			parameters = Val[1];
			if (mode=="1"){
				
				parameters=parameters+ "&title="+encodeURIComponent(getLabel("eMR.AppointmentforMedicalBoardRequest.label","MR"));
				returnVal =await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+parameters,arguments,features);
			}else if (mode=="2"){
				
				parameters=parameters+ "&title="+encodeURIComponent(getLabel("eMR.AppointmentforMedicalBoardRequest.label","MR"));
				returnVal =await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+parameters,arguments,features);
			}else if (mode=="3"){
				
				parameters=parameters+ "&title="+encodeURIComponent(getLabel("eMR.AppointmentforMedicalBoardRequest.label","MR"));
				returnVal =await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+parameters,arguments,features);
			}
			if(returnVal != null && returnVal != ""){
				var arr=new Array();
				 arr=returnVal.split("&");
				 var i=0;
				 while(arr[i]!=null){
					 var arrayElement =arr[i];
					 if(arrayElement.indexOf("specialty_code")!=-1)
					{
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 splty_code = arrayOfValue[1];
					}
					 if(arrayElement.indexOf("practitioner_id")!=-1)
					{
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 P_practitioner_id = arrayOfValue[1];
					}
					if(arrayElement.indexOf("clinic_code")!=-1)
					{
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 P_locn_code = arrayOfValue[1];
					}
					if(arrayElement.indexOf("recall_date")!=-1)
					{
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 recall_date = arrayOfValue[1];
					} 
					if(arrayElement.indexOf("care_locn_ind")!=-1)
					{
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 P_locn_type = arrayOfValue[1];
					} 
					if(arrayElement.indexOf("no_dwm")!=-1)
					{
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 no_dwm = arrayOfValue[1];
					} 
					if(arrayElement.indexOf("visittype")!=-1)
					{
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 visittype = arrayOfValue[1];
					} 
					if(arrayElement.indexOf("dwm_desc")!=-1)
					{
						 var arrayOfValue = new Array();
						 arrayOfValue = arrayElement.split("=");
						 dwm_desc = arrayOfValue[1];
					} 
					i++;
				}

				//parameters	= "i_practitioner_id="+P_practitioner_id+"&practitioner_id="+P_practitioner_id+"&patient_id="+pat_id+"&i_clinic_code="+P_locn_code+"&clinic_code="+P_locn_code+"&recall_date="+recall_date+"&location_code="+P_locn_code+"&care_locn_ind="+P_locn_type+"&specialty_code="+splty_code+"&referral_id="+referral_id+"&request_id="+req_id+"&appt_date="+appt_date+"&callingMode=MR&module_id=OA";

				if(returnVal !="")
				{
					//retVal = window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?"+parameters,arguments,features);
					getApptDetails(req_id, call_func, pat_id, appt_date,P_practitioner_id,P_locn_code,recall_date,P_locn_code,P_locn_type,splty_code,selectedPractId,selectedLocnCode,callingMode,"OA",no_dwm,visittype,dwm_desc);

				
					
				}else {
					var result = returnVal.split("*");
					if(result[0] != "MR")
					{
						var ApptNo		= result[0];
						//eval("document.getElementById("apptLabel")"+i).innerText	= ApptNo;
						//alert("ApptNo : "+ApptNo);
						//parent.frames[1].document.forms[0].Refresh.onclick();
					}
				}
			}
		}
	}

	</script>
	<%
		request.setCharacterEncoding("UTF-8");
		//CallableStatement	Cs_book = null;
		Connection			con		= null;
		Statement			stmt	= null;
		PreparedStatement pstmt=null;
		Statement			dtlStmt	= null;
		//Statement			ipstmt	= null;
		ResultSet			rs		= null;
		ResultSet			dtlRs	= null;
		//ResultSet			iprs	= null;
		Statement			srlStmt	= null;
		ResultSet			srlRS	= null;
		

		Boolean isIncompReqCancelApplicable = false;//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
		Boolean isRejectRequestAppl = false; //Added by mujafar  for ML-MMOH-CRF-0713
		Boolean isRejectReportApplicable = false; // added by mujafar for ML-MMOH-CRF-0714
		
		Boolean isMedicalTeamApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0716
		Boolean isDuedateAppl = false; // added by mujafar for ML-MMOH-CRF-706		
		boolean isSpecialtyDefaultApp = false;//Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454

		
		//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233
		Boolean isDeliveredRepModifyAppl = false;
		String modificationRemarks = "";
		String modificationYN = "N";

		StringBuffer where_criteria	= new StringBuffer();
//		StringBuffer sql		= new StringBuffer();
		String overdue_status	= "N";
		String class_val		= "QRYEVEN";
		String booking_stat		= "";
		String encounter_id		= ""; 
		String facility_id		= (String)session.getValue("facility_id");
		String param			= checkForNull(request.getParameter("param"));
		String status_to_show	= checkForNull(request.getParameter("status_to_show"));
		String called_from		= checkForNull(request.getParameter("called_from"));
		String request_type		= checkForNull(request.getParameter("request_type"));
		String whereClause		= request.getParameter("whereclause");
		String from				= request.getParameter("from") ;
		String to				= request.getParameter("to");
		String requestor_code	= checkForNull(request.getParameter("requestor_code"));
		String requestor_type	= checkForNull(request.getParameter("requestor_type"));
		String due_date_sel     = checkForNull(request.getParameter("due_date_sel")); // added by mujafar for ML-MMOH-CRF-706
		String soundex_type		= checkForNull(request.getParameter("soundex"));
		String from_date		= checkForNull(request.getParameter("from_date"));
		if(!from_date.equals(""))
			from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
		String to_date			= checkForNull(request.getParameter("to_date"));
		if(!to_date.equals(""))
			to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 

		String patient_id		= checkForNull(request.getParameter("PatientId"));
		String gender			= checkForNull(request.getParameter("gender"));
		String name_prefix		= checkForNull(request.getParameter("name_prefix"));
		String name_suffix		= checkForNull(request.getParameter("name_suffix"));
		String first_name		= checkForNull(request.getParameter("first_name"));
		String second_name		= checkForNull(request.getParameter("second_name"));
		String third_name		= checkForNull(request.getParameter("third_name"));
		String family_name		= checkForNull(request.getParameter("family_name"));
		String national_id_no	= checkForNull(request.getParameter("national_id_no"));
		String alt_id1_no		= checkForNull(request.getParameter("alt_id1_no"));
		String alt_id2_no		= checkForNull(request.getParameter("alt_id2_no"));
		String alt_id3_no		= checkForNull(request.getParameter("alt_id3_no"));
		String alt_id4_no		= checkForNull(request.getParameter("alt_id4_no"));
		String other_alt_type	= checkForNull(request.getParameter("other_alt_type"));
		String other_alt_Id		= checkForNull(request.getParameter("other_alt_Id"));
		String loc_lang			= checkForNull(request.getParameter("loc_lang"));

		//Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701
		String sum_comp_id		= checkForNull(request.getParameter("sum_comp_id"));

		//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331
		String nav_menu_id		= checkForNull(request.getParameter("nav_menu_id"));

		/*Added by Ashwini on 25-Feb-2019 for MO-CRF-20149*/
		String speciality				= checkForNull(request.getParameter("speciality"));
		String fwd_practitioner_id		= checkForNull(request.getParameter("fwd_practitioner_id"));
		String prep_practitioner_id		= checkForNull(request.getParameter("prep_practitioner_id"));
		String rep_prep_date			= checkForNull(request.getParameter("rep_prep_date"));
		if(!rep_prep_date.equals(""))
		rep_prep_date = DateUtils.convertDate(rep_prep_date,"DMY",locale,"en");
		/*End MO-CRF-20149*/

		booking_stat = checkForNull(request.getParameter("booking_stat"));
		String searchby = checkForNull(request.getParameter("searchby"));
		if (searchby.equals("")) searchby="S";
		String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
		
		String isAcceptRequestByPractAppl = checkForNull(request.getParameter("isAcceptRequestByPractAppl"));
		// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		
		
		String isMRConfigurationAppl = checkForNull(request.getParameter("isMRConfigurationAppl"));  // added by mujafar for ML-MMOH-CRF-1280
		JSONObject fieldOrderJSON	= new JSONObject();
		int recCnt = 0;
		ArrayList arrList = new ArrayList();
		
		if(name_prefix != null)
		name_prefix=singleToDoubleQuotes(name_prefix);

		if(name_suffix != null)
		name_suffix=singleToDoubleQuotes(name_suffix);              

		if (booking_stat==null) booking_stat="";

		String request_id				= "";
		String med_board_type_code		= "";
		String prepare_pract_id			= "";
		String team_id					= "";
		String request_status			= "";
		String revise_status			= "";
		String patient_name_from_vw		= "";
		String appointment_date_from_vw	= "";
		String patient_id_from_vw		= "";
		String gender_from_vw			= "";
		String revised_dt				= "";
		String appt_ref_no_from_vw		= "";
		String request_type_desc		= "";

		/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
		String cancelledDate			= "";
		String cancelReason				= "";
		String cancelledBy				= "";
		String reqStatusNum				= "";
		/*End*/
		
		// Added by mujafar for ML-MMOH-CRF-0713 start
		String reject_date = "";
		String rejected_by = "";
		String reason_rejection="";		
		// end
		// added by mujafar for ML-MMOH-CRF-0714 start
		String received_date = "";
		String mrp_rejected_by = "";
		String mrp_reason_rejection = "";
		String due_days = ""; // added by mujafar for ML-MMOH-CRF-706
		int pract_days = 0; // added by mujafar for ML-MMOH-CRF-1278
		
		// end
		int	p_max_rec_cnt=0;
		//Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705
		String forwarded_hod_date		 = "";
		Boolean IsPendingAssignPractAvbl = false;

	%>
	</head>
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name = 'ReportRequestResult_form'>
	<%
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		//ipstmt	= con.createStatement();
		Boolean isRequestStatus_YN	= eCommon.Common.CommonBean.isSiteSpecific(con, "MR","REQUEST_STATUS_VISIBLE");//Manivannan added for the ML-MMOH-CRF 0715
		isIncompReqCancelApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","AUTO_CANCEL_INCOMPLETE_REQUEST");//Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719
		IsPendingAssignPractAvbl    =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","PENDING_ASSIGN_TO_PRACT"); //Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705
		isRejectRequestAppl         =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REQUEST_MRP"); //Added by mujafar  for ML-MMOH-CRF-0713
		isRejectReportApplicable=eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REPORT_MRP"); //Added by mujafar  for ML-MMOH-CRF-0714
		//Below line added for this CRF ML-MMOH-CRF-0712
		Boolean isMedicalReportRequest = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CANCEL_MEDICAL_REQUEST");	 
		
		isDeliveredRepModifyAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MODIFY_ISSUED_MEDICAL_REPORT");//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233

		Boolean isOverduePractitionerApplicable =eCommon.Common.CommonBean.isSiteSpecific(con,"MR","OVERDUE_PRACT_APPL"); //Added by Shaik Mujafar for ML-MMOH-CRF-0710
		
		isMedicalTeamApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MEDICAL_TEAM_APPLICABLE"); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
		isDuedateAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DUE_DATE_APPL"); // added by mujafar for ML-MMOH-CRF-706
		isSpecialtyDefaultApp	= 	eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MR_SPECIALTY_DEF_APPL_YN"); //Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454
	if(whereClause==null)
	{
/// Added by Sridhar R for Medical Board & Medical Report...
		if(call_function.equals("") && request_type.equals("MB"))
			where_criteria.append(" where REQUEST_TYPE='MB' ");
		else if(call_function.equals("") && request_type.equals("MR"))
			where_criteria.append(" where REQUEST_TYPE='MR' ");
	
		
		if(call_function.equals("") && request_type.equals("MR"))
		{
			
			if(status_to_show.equals(""))
			{
				if(isRejectReportApplicable)
				{ // below if-else added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				if(isAcceptRequestByPractAppl.equals("true"))
				where_criteria.append(" and (request_status <= 11 or (request_status>=13 and request_status<=15) or request_status = 99 or request_status = 98 ) "); 
				else
				where_criteria.append(" and (request_status <= 11 or request_status = 99 or request_status = 98 ) "); 
				
				}
				else
				where_criteria.append(" and (request_status <= 11 or request_status = 99) ");
				
				
				
				
			}
			else if(status_to_show.equals("0-4"))
			{
				if(isAcceptRequestByPractAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				where_criteria.append(" and ((request_status <= 5) or (request_status = 7) or (request_status >=9 and request_status <= 11) or (request_status>=13 and request_status<=15) or request_status = 98 )");	
				else
				where_criteria.append(" and ((request_status <= 5) or (request_status = 7) or (request_status >=9 and request_status <= 11) or request_status = 98 )");	
			}
			else if(status_to_show.equals("0")){
				where_criteria.append(" and (overdue_status = 'Y' and request_status NOT IN ('6','99','8')) "); 
			//and  request_status = 98 added by mujafar for ML-MMOH-CRF-0714
			}
			else if(status_to_show.equals("2")){
				where_criteria.append(" and request_status = '"+status_to_show+"' /*and (collect_date > sysdate or revised_collect_date > sysdate)*/ ");}
			else if(status_to_show.equals("3")){
				where_criteria.append(" and request_status in ('3','0')/* and (collect_date > sysdate or revised_collect_date > sysdate)*/");
			/*Added by Thamizh selvi on 17th July 2017 against ML-MMOH-CRF-0719 Start*/
			}
			else if(status_to_show.equals("8")){
			where_criteria.append(" and request_status in ('8','99') ");}
			/*End*/
			else
			{where_criteria.append(" and request_status = '"+status_to_show+"' ");}
		}
		else if(call_function.equals("") && request_type.equals("MB"))
		{
			if(status_to_show.equals(""))
				where_criteria.append(" and request_status <= 9 ");
			else if(status_to_show.equals("0"))
				where_criteria.append(" and overdue_status = 'Y' and request_status < '9' ");
			else if(status_to_show.equals("1"))
				where_criteria.append(" and request_status = '"+status_to_show+"' ");
			else if(status_to_show.equals("2") || status_to_show.equals("3") || status_to_show.equals("4") || status_to_show.equals("5") || status_to_show.equals("6") || status_to_show.equals("7") || status_to_show.equals("8"))
				where_criteria.append(" and request_status = '"+status_to_show+"' and (collect_date > sysdate or revised_collect_date > sysdate) ");
			else if(status_to_show.equals("0-9"))
				where_criteria.append(" and request_status <= 8 /* and (collect_date > sysdate or revised_collect_date > sysdate) */ ");
			else
				where_criteria.append(" and request_status = '"+status_to_show+"'  ");
		}

		/// Added by Sridhar R on 3/29/2005..
		/// Criteria for MEDICAL BOARD ...
		if(call_function.equals("MEDICAL_BOARD_STATUS"))//Status of Medical Board Request
			where_criteria.append(" where REQUEST_TYPE='MB'");	
		if(call_function.equals("FORWARD_MEDICAL_BOARD"))//Forward Medical Board Request
			where_criteria.append(" where REQUEST_TYPE='MB' ");	

		if(call_function.equals("RECEIVE_MEDICAL_BOARD"))//Receive Medical Report
			where_criteria.append(" where and REQUEST_TYPE='MB'");		
		if(call_function.equals("MEDICAL_BOARD_FORMATION"))//Formation of Medical Board
			where_criteria.append(" where REQUEST_TYPE='MB'");	
		if(call_function.equals("MEDICAL_BOARD_APPT"))//Formation of Medical Board
			where_criteria.append(" where REQUEST_TYPE='MB' and trunc(appt_date) >= trunc(sysdate)");	
		if(call_function.equals("MEDICAL_BOARD_INT_APPT"))//Intimate Appointment of Medical Board
			where_criteria.append(" where REQUEST_TYPE='MB'");	
		if(call_function.equals("DELIVER_MEDICAL_BOARD"))//Deliver of Medical Board
			where_criteria.append(" where REQUEST_TYPE='MB'");	

		
		/// Criteria for MEDICAL REPORT ...
		if(call_function.equals("MEDICAL_REPORT_STATUS"))
			where_criteria.append(" where REQUEST_TYPE='MR'");	
		if(call_function.equals("FORWARD_MEDICAL_REPORT"))
			where_criteria.append(" where REQUEST_TYPE='MR' ");	

		// Common Criteria for Both MEDICAL BOARD && MEDICAL REPORT ...
		if(call_function.equals("RECEIVE_MEDICAL_REPORT"))
			where_criteria.append(" where REQUEST_TYPE='MR'");		
		if(call_function.equals("DELIVER_MEDICAL_REPORT"))
			where_criteria.append(" where REQUEST_TYPE='MR'");
		
		/// Criteria for MEDICAL REPORT ...
		if(call_function.equals("REVISE_MEDICAL_REPORT"))
			where_criteria.append(" where REQUEST_TYPE='MR' and ( COLLECT_DATE < sysdate or revised_collect_date < sysdate ) ");	
		
		if(called_from.equals("CA") && call_function.equals("PREPARE_MEDICAL_BOARD"))
		{
			where_criteria.append(" where request_status = '6' and  REQUEST_TYPE='MB' and ( COLLECT_DATE >= sysdate or revised_collect_date >= sysdate)");	
		}
		else if(called_from.equals("CA") )
		{
			//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331
			//sumCompQry Added By Dharma on 5th Dec 2019 against ML-MMOH-CRF-1454 & Status 15 added for 1451 
			String sumCompQry = " WHERE request_status IN ('3', '98', '9', '11')  AND request_type = 'MR' AND overdue_status !='Y' ";			
			
			if(nav_menu_id.equals("VW_PREPD_MED_REP"))
			{
				where_criteria.append(" WHERE request_status = '4' AND request_type = 'MR' AND overdue_status !='Y' ");
			}
			// if else block added by mujafar for ML-MMOH-CRF-0716.2 and ML-MMOH-CRF-904	
			else if(isMedicalReportRequest && !(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")))
			{
			//where_criteria.append(" where (request_status = '3' or request_status = 98 or request_status = '9' or request_status = '11' or request_status = '13' )  and ( COLLECT_DATE >= sysdate or revised_collect_date >= sysdate) and  REQUEST_TYPE='MR' "); // 98 status added by mujafar for ML-MMOH-CRF-0714	
			where_criteria.append(" WHERE request_status IN ('3', '98', '9', '11','13','15')  AND request_type = 'MR' AND overdue_status !='Y' and ( COLLECT_DATE >= sysdate or revised_collect_date >= sysdate) ");		
			} // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			/*Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701*/
			else if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28"))
			{
				where_criteria.append(sumCompQry);
				if(sum_comp_id.equals("MR_MED_REPT_15")){
					//where_criteria.append(" WHERE request_status IN ('3', '98', '9', '11') AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) BETWEEN 15 AND 19 AND request_type = 'MR' AND overdue_status !='Y' ");
					where_criteria.append(" AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) BETWEEN 15 AND 19 ");
				}
				else if(sum_comp_id.equals("MR_MED_REPT_20")) {
					//where_criteria.append(" WHERE request_status IN ('3', '98', '9', '11') AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) BETWEEN 20 AND 27 AND request_type = 'MR' AND overdue_status !='Y' ");
					where_criteria.append(" AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) BETWEEN 20 AND 27 ");
				}
				else if(sum_comp_id.equals("MR_MED_REPT_28")) {
				//where_criteria.append(" WHERE request_status IN ('3', '98', '9', '11') AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) >= 28 AND request_type = 'MR' AND overdue_status !='Y' ");
					where_criteria.append(" AND TRUNC (SYSDATE) - TRUNC (appl_completion_date)  >= 28 ");
				}
			}
			/*End ML-MMOH-CRF-0701*/
			else{
				where_criteria.append(" where (request_status = '3' or request_status = 98)  and ( COLLECT_DATE >= sysdate or revised_collect_date >= sysdate) and  REQUEST_TYPE='MR' "); // 98 status added by mujafar for ML-MMOH-CRF-0714
			}
			if(due_date_sel != null && !due_date_sel.equals("") && call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl)
			{ // added by mujafar for ML-MMOH-CRF-0706
				
					where_criteria.append(" and  medcle_rprt_due_dt_calc(facility_id,request_id)<=NVL("+due_date_sel+",9999)");
				
				
			}
			/*Added By Dharma on 5th Dec 2019 against ML-MMOH-CRF-1454 Start*/
			if(isSpecialtyDefaultApp){
				where_criteria.append(" and (forwarded_hod_cord_id = '"+loginPractId+"' or (FORWARDED_PRACT_ID = '"+loginPractId+"' and request_status!=15 ) ");
				where_criteria.append(" or EXISTS ( SELECT a.team_id FROM am_medical_team a, am_pract_for_team b WHERE b.practitioner_id =  '"+loginPractId+"' ");
				where_criteria.append(" AND a.team_id = b.team_id AND a.facility_id = b.facility_id AND appl_for_mr_yn = 'Y' AND a.team_id = forwarded_medical_team ))");
			}
			/*Added By Dharma on 5th Dec 2019 against ML-MMOH-CRF-1454 End*/
		}
		
		/// End of addition by Sridhar R ...
		if(call_function.equals("QUERY_DELAY_IN_MRR"))
		{
			where_criteria.append(" where (request_status < '6'  or request_status = 98) and overdue_status = 'Y' "); // status added for ML-MMOH-CRF-0714
		}


		where_criteria.append(" and facility_id='"+facility_id+"'");

		//requestor code
		if(requestor_code!=null && !requestor_code.equals(""))
			where_criteria.append(" and requestor_code = '"+requestor_code+"'");

		//requestor requestor_type
		if(requestor_type!=null && !requestor_type.equals(""))
			where_criteria.append(" and INDICATOR = '"+requestor_type+"'");


		//from_date
		if(from_date!=null && !from_date.equals(""))
			where_criteria.append(" and trunc(added_date) >= to_date('"+from_date+"' , 'dd/mm/yyyy') ");
		
		//to_date
		if(to_date!=null && !to_date.equals(""))
			where_criteria.append( " and trunc(added_date) <= to_date('"+to_date+"' , 'dd/mm/yyyy') ");

		//patient_id
		if(patient_id!=null && !patient_id.equals(""))
			where_criteria.append( " and patient_id like '"+patient_id+"%' ");

		//gender
		if(gender!=null && !gender.equals(""))
		{
			where_criteria.append( " and sex='"+gender+"' ");
		}

		//name_prefix
		if(name_prefix!=null && !name_prefix.equals(""))
		   where_criteria.append(" and name_prefix='"+name_prefix+"' ");

		//name_suffix
		if(name_suffix!=null && !name_suffix.equals(""))
			where_criteria.append( " and name_suffix='"+name_suffix+"' ");
		
		if(national_id_no!=null && !national_id_no.equals(""))
			where_criteria.append(" and national_id_no='"+national_id_no+"'");
		
		if(alt_id1_no!=null && !alt_id1_no.equals(""))
			where_criteria.append( " and alt_id1_no='"+alt_id1_no+"'");

		if(alt_id2_no!=null && !alt_id2_no.equals(""))
			where_criteria.append(" and alt_id2_no='"+alt_id2_no+"'");

		if(alt_id3_no!=null && !alt_id3_no.equals(""))
			where_criteria.append(" and alt_id3_no='"+alt_id3_no+"'");

		if(alt_id4_no!=null && !alt_id4_no.equals(""))
			where_criteria.append( " and alt_id4_no='"+alt_id4_no+"'");

		if(other_alt_type!=null && !other_alt_type.equals(""))
			where_criteria.append( " and oth_alt_id_type='"+other_alt_type+"'");

		if(other_alt_Id!=null && !other_alt_Id.equals(""))
			where_criteria.append( " and oth_alt_Id_no='"+other_alt_Id+"'");

		/*Added by Ashwini on 25-Feb-2019 for MO-CRF-20149*/
		if(speciality!=null && !speciality.equals(""))
			where_criteria.append( " and specialty_code='"+speciality+"'");

		if(fwd_practitioner_id!=null && !fwd_practitioner_id.equals(""))
			where_criteria.append( " and forwarded_pract_id='"+fwd_practitioner_id+"'");

		if(prep_practitioner_id!=null && !prep_practitioner_id.equals(""))
			where_criteria.append( " and prepare_pract_id='"+prep_practitioner_id+"'");

		if(rep_prep_date!=null && !rep_prep_date.equals(""))
			where_criteria.append(" and trunc(prepared_date)=to_date('"+rep_prep_date+"' , 'dd/mm/yyyy') ");
		/*End MO-CRF-20149*/

	if(soundex_type.equals("E"))
	{
		if(first_name!=null && !first_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(first_name)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(FIRST_NAME_LOC_LANG)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
		}

		if(second_name!=null && !second_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(second_name)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(SECOND_NAME_LOC_LANG)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
		}

		if(third_name!=null && !third_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(third_name)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(THIRD_NAME_LOC_LANG)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
		}

		if(family_name!=null && !family_name.equals(""))
		{
			String fam_name_search = "";
			if (pat_name_as_multipart_yn.equals("N"))
			{
				StringTokenizer stktok = new StringTokenizer(family_name, " ");
				if (stktok.hasMoreTokens())
					fam_name_search = stktok.nextToken();
				else
					fam_name_search = family_name;
			}
			else
				fam_name_search = family_name;

			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(family_name)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(FAMILY_NAME_LOC_LANG)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");
		}
	}
	else if(soundex_type.equals("G"))
	{
		if(first_name!=null && !first_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(soundex(first_name)) like upper(soundex('" +first_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(soundex(FIRST_NAME_LOC_LANG)) like upper(soundex('" +first_name +"')) || '%' ");
		}

		if(second_name!=null && !second_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(soundex(second_name)) like upper(soundex('" + second_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(soundex(SECOND_NAME_LOC_LANG)) like upper(soundex('" + second_name +"')) || '%' ");
		}

		if(third_name!=null && !third_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append(" and upper(soundex(third_name)) like upper(soundex('"+ third_name+"')) || '%' ");
			else
				where_criteria.append(" and upper(soundex(THIRD_NAME_LOC_LANG)) like upper(soundex('"+ third_name+"')) || '%' ");
		}

		if(family_name!=null && !family_name.equals(""))
		{
			String fam_name_search = "";
			if (pat_name_as_multipart_yn.equals("N"))
			{
				StringTokenizer stktok = new StringTokenizer(family_name, " ");
				if (stktok.hasMoreTokens())
					fam_name_search = stktok.nextToken();
				else
					fam_name_search = family_name;
			}
			else
				fam_name_search = family_name;

			if(loc_lang.equals("en"))
				where_criteria.append(" and upper(soundex(family_name)) like upper(soundex('" +fam_name_search+"')) || '%' ");
			else
				where_criteria.append(" and upper(soundex(FAMILY_NAME_LOC_LANG)) like upper(soundex('" +fam_name_search+"')) || '%' ");
		}
	}
	else
	{
		if (pat_name_as_multipart_yn.equals("Y"))
		{
			if(first_name!=null && !first_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(first_name) like upper('" +first_name +"') || '%' ");
				else
					where_criteria.append(" and upper(FIRST_NAME_LOC_LANG) like upper('" +first_name +"') || '%' ");
			}

			if(second_name!=null && !second_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(second_name) like upper('" + second_name +"') || '%' ");
				else
					where_criteria.append(" and upper(SECOND_NAME_LOC_LANG) like upper('" + second_name +"') || '%' ");
			}

			if(third_name!=null && !third_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(third_name) like upper('"+ third_name+"') || '%' ");
				else
					where_criteria.append( " and upper(THIRD_NAME_LOC_LANG) like upper('"+ third_name+"') || '%' ");
			}

			if(family_name!=null && !family_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(family_name) like upper('" +family_name+"') || '%' ");
				else
					where_criteria.append( " and upper(FAMILY_NAME_LOC_LANG) like upper('" +family_name+"') || '%' ");
			}
		}
		else
		{						
			if (searchby.equals("C"))
			{
				if(!family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append( " and upper(family_name) like '%' || upper('" +family_name+"') || '%' ");
					else
						where_criteria.append( " and upper(FAMILY_NAME_LOC_LANG) like '%' || upper('" +family_name+"') || '%' ");
				}
			}
			else if (searchby.equals("E"))
			{
				if(!family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(family_name) like '%' || upper('" +family_name+"') ");
					else
						where_criteria.append(" and upper(FAMILY_NAME_LOC_LANG) like '%' || upper('" +family_name+"') ");
				}
			}
			else
			{
				if(!family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(family_name) like upper('" +family_name+"') || '%' ");
					else
						where_criteria.append(" and upper(FAMILY_NAME_LOC_LANG) like upper('" +family_name+"') || '%' ");
				}
			}
		}
	}
	
	}
	else
	{
		where_criteria.append(whereClause);
	}

		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		
		if ( to == null )
			end = 8 ;
		else
			end = Integer.parseInt( to ) ;

		int maxRecord = 0;
	  
		//sql.append(" SELECT count(*) from MR_REPORT_REQUEST_HDR_VW " +where_criteria);
//out.println("Count Sql : "+sql.toString());

		/*rs = stmt.executeQuery(sql.toString());
		rs.next();
		maxRecord = rs.getInt(1);
		if(rs!=null)rs.close();*/
//out.println("<br> maxRecord : "+maxRecord);

		/*if(maxRecord == 0)
		{*/	%>
			<!--<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>-->
	<%	/*}	 
		else
		{*/
			
			StringBuffer sqlSb = new StringBuffer();
			//sqlSb.append(" SELECT request_type, med_board_type_code, facility_id, request_id, to_char(request_date, 'dd/mm/yyyy') request_date ,patient_name, patient_id, gender, practitioner_name, team_short_desc, to_char(collect_date,'DD/MM/YYYY hh24:mi')collect_date, to_char(appt_date, 'dd/mm/yyyy')appt_date, appt_ref_no, request_status_desc, board_request_status_desc, to_char(prepared_date,'DD/MM/YYYY hh24:mi')prepared_date, request_status, revise_status, overdue_status from MR_REPORT_REQUEST_HDR_VW "+where_criteria+" ");
			
			//Added forwarded_hod_date by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705
			// below line commented and next line added by mujafar on 12-oct-2017 for ML-MMOH-CRF-0713
			//sqlSb.append(" select to_char(sysdate,'dd/mm/yyyy') curr_date,request_type, med_board_type_code, facility_id, request_id, to_char(request_date,'dd/mm/yyyy') request_date, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, patient_id, sex, am_get_desc.AM_PRACTITIONER(forwarded_pract_id,'"+locale+"','1')practitioner_name, am_get_desc.AM_MEDICAL_TEAM(facility_id, prepare_team_id,'"+locale+"','2') team_short_desc, to_char(collect_date,'dd/mm/yyyy hh24:mi') collect_date, to_char(appt_date,'dd/mm/yyyy') appt_date, appt_ref_no, request_status_desc, board_request_status_desc, to_char(prepared_date,'dd/mm/yyyy hh24:mi') prepared_date, request_status, revise_status, overdue_status, sm_get_desc.sm_appl_user(cancelled_by,'"+locale+"','1') cancelled_by, to_char(cancelled_date, 'dd/mm/yyyy hh24:mi') cancelled_date, am_get_desc.am_contact_reason(cancel_reason_code,'"+locale+"','1') cancel_reason_code, trunc(sysdate)-trunc(forwarded_hod_cord_date) forwarded_hod_date from MR_REPORT_REQUEST_HDR_VW "+where_criteria+" ");//Modified by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719	
			
			sqlSb.append(" select to_char(sysdate,'dd/mm/yyyy') curr_date,request_type, med_board_type_code, facility_id, request_id, to_char(request_date,'dd/mm/yyyy') request_date, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, patient_id, sex, am_get_desc.AM_PRACTITIONER(forwarded_pract_id,'"+locale+"','1')practitioner_name, am_get_desc.AM_MEDICAL_TEAM(facility_id, prepare_team_id,'"+locale+"','2') team_short_desc, to_char(collect_date,'dd/mm/yyyy hh24:mi') collect_date, to_char(appt_date,'dd/mm/yyyy') appt_date, appt_ref_no, request_status_desc, board_request_status_desc, to_char(prepared_date,'dd/mm/yyyy hh24:mi') prepared_date, request_status, revise_status, overdue_status, sm_get_desc.sm_appl_user(cancelled_by,'"+locale+"','1') cancelled_by, to_char(cancelled_date, 'dd/mm/yyyy hh24:mi') cancelled_date, am_get_desc.am_contact_reason(cancel_reason_code,'"+locale+"','1') cancel_reason_code, /*trunc(sysdate)-trunc(forwarded_hod_cord_date) */ trunc(forwarded_hod_cord_date) - trunc(REQUEST_DATE) forwarded_hod_date,sm_get_desc.sm_appl_user(rejected_by,'"+locale+"','1') rejected_by, am_get_desc.am_contact_reason(reason_rejection,'"+locale+"','1') reason_rejection,to_char(ACCPT_REJCT_DATE, 'dd/mm/yyyy hh24:mi') reject_date,to_char(received_date, 'dd/mm/yyyy hh24:mi') received_date,mrp_rejected_by,am_get_desc.am_contact_reason(mrp_reason_rejection,'"+locale+"','1')mrp_reason_rejection,medcle_rprt_due_dt_calc(facility_id,request_id)due_days, to_char(appl_completion_date,'dd/mm/yyyy hh24:mi') appl_completion_date, modification_remarks from MR_REPORT_REQUEST_HDR_VW "+where_criteria+" "); // modified by mujafar for ML-MMOH-CRF-0714 and ML-MMOH-CRF-0706
			// appl_completion_date Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701
            
			//sqlSb.append(" SELECT (CASE WHEN( REVISED_COLLECT_DATE IS NOT NULL AND REVISED_COLLECT_DATE < SYSDATE AND A.REQUEST_STATUS < '6'  )   THEN 'Overdue'  WHEN (COLLECT_DATE < SYSDATE AND REVISED_COLLECT_DATE IS NULL AND A.REQUEST_STATUS < '6'  )   THEN 'Overdue'  ELSE   DECODE(A.REQUEST_STATUS, '1','Requested','2','Status Completed','3','Forwarded to Practitioner','4','Prepared by Practitioner','5','Received by Medical Record','6','Report Delivered','7','Delay in Preparation') END ) REQUEST_STATUS_DESC, request_type, med_board_type_code, facility_id, request_id, To_char(Request_Date,'dd/mm/yyyy') Request_Date, Patient_Name, patient_id, gender, AM_GET_DESC.AM_PRACTITIONER(PREPARE_PRACT_ID,'"+locale+"','1')Practitioner_Name, AM_GET_DESC.AM_MEDICAL_TEAM(facility_id, PREPARE_TEAM_ID,'"+locale+"','2') Team_Short_desc, To_char(Collect_Date,'DD/MM/YYYY hh24:mi') Collect_Date, To_char(appt_Date,'dd/mm/yyyy') appt_date, appt_ref_no, request_status_desc, (CASE WHEN(REVISED_COLLECT_DATE IS NOT NULL AND REVISED_COLLECT_DATE < SYSDATE AND REQUEST_STATUS < '9'   )   THEN 'Overdue'  WHEN (COLLECT_DATE < SYSDATE AND REVISED_COLLECT_DATE IS NULL AND REQUEST_STATUS < '9' )THEN 'Overdue' ELSE DECODE(REQUEST_STATUS, '1','Requested','2','Status Completed','3','Medical Board Formed', '4','Forwarded to Practitioner','5','Appointment Given','6','Appointment Intimated','7','Prepared by Practitioner','8','Received by Medical Board','9','Report Delivered') END ) BOARD_REQUEST_STATUS_DESC, To_char(Prepared_Date,'DD/MM/YYYY hh24:mi') prepared_date, request_status, (CASE WHEN REQUEST_STATUS = '3' AND COLLECT_DATE < SYSDATE THEN 'Y' ELSE 'N' END ) REVISE_STATUS, (CASE WHEN(REVISED_COLLECT_DATE IS NOT NULL AND REVISED_COLLECT_DATE > SYSDATE) THEN 'N' WHEN(REVISED_COLLECT_DATE IS NOT NULL AND REVISED_COLLECT_DATE < SYSDATE) THEN 'Y' WHEN (COLLECT_DATE > SYSDATE) THEN 'N' WHEN (COLLECT_DATE < SYSDATE AND REVISED_COLLECT_DATE IS NULL) THEN 'Y' END) overdue_status from MR_REPORT_REQUEST_HDR "+where_criteria+" ");


			if(request_type.equals("MR"))
			{
				if(status_to_show.equals("") || status_to_show.equals("0-4"))
					sqlSb.append(" order by request_status_desc desc");
				else
					sqlSb.append(" order by request_id desc, request_date desc");
			}
			else if(request_type.equals("MB"))
			{
				if(status_to_show.equals("") || status_to_show.equals("0-9"))
					sqlSb.append(" order by board_request_status_desc desc");
				else
					sqlSb.append(" order by request_id desc, request_date desc");
			}

//			if (rs != null) rs.close();
//			if (stmt != null) stmt.close();
			//out.println(sqlSb.toString());
			/*
				Commented for PE  on 6/15/2010
				Statement was changed to Prepared Statement.
				stmt	= con.createStatement();
				rs      = stmt.executeQuery(sqlSb.toString());
			*/
			//out.println("sqlSb.toString(): -------------> "+sqlSb.toString());
			pstmt = con.prepareStatement(sqlSb.toString());


			rs=pstmt.executeQuery();
			if ( start != 1 ){
					for( int j=1; j<start; i++,j++ )	{
						rs.next() ;
					}
			}
			while ( rs!=null && i<=end && rs.next()){
					if(maxRecord==0){
						//if (( !(start <= 1) ) || ( !( (start+8) > maxRecord ) ))
						//{
						out.println("<p><table align='right'><tr>");
						if (!(start <= 1))
						out.println("<td align ='right' id='prev' ><A HREF='../jsp/ReportRequestQueryResult.jsp?called_from="+called_from+"&isDuedateAppl="+isDuedateAppl+"&isMRConfigurationAppl="+isMRConfigurationAppl+"&isAcceptRequestByPractAppl="+isAcceptRequestByPractAppl+"&param="+param+"&from="+(start-8)+"&to="+(end-8)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&call_function="+URLEncoder.encode(call_function)+"&status_to_show="+status_to_show+"&sum_comp_id="+sum_comp_id+"&request_type="+request_type+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>"); // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 & 1280
						//if ( !( (start+8) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/ReportRequestQueryResult.jsp?called_from="+called_from+"&isDuedateAppl="+isDuedateAppl+"&isMRConfigurationAppl="+isMRConfigurationAppl+"&isAcceptRequestByPractAppl="+isAcceptRequestByPractAppl+"&param="+param+"&from="+(start+8)+"&to="+(end+8)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&call_function="+URLEncoder.encode(call_function)+"&status_to_show="+status_to_show+"&sum_comp_id="+sum_comp_id+"&request_type="+request_type+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>"); // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 & 1280
						out.println("</tr></table></p>");
						out.println("<br><br>");
						//}
						if(!(isMRConfigurationAppl.equals("true")) || (isMRConfigurationAppl.equals("true") && call_function.equals("QUERY_DELAY_IN_MRR") ) || (isMRConfigurationAppl.equals("true") && request_type.equals("MB") && !call_function.equals("QUERY_DELAY_IN_MRR") )  )
						{ // added by mujafar for ML-MMOH-CRF-1280 
						
						%>

						<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
						<tr>
							<th nowrap><fmt:message key="eMR.RequestID.label" bundle="${mr_labels}"/></th>
							<th nowrap><fmt:message key="Common.RequestDate.label" bundle="${common_labels}"/></th>
							<%	if(call_function.equals("QUERY_DELAY_IN_MRR")){	%>
								<th wrap><fmt:message key="Common.RequestType.label" bundle="${common_labels}"/></th>
							<%}%>
							<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
							<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
							<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>					   
							<th nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>

							<!--Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701-->
							<%if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")){%>
							<th wrap><fmt:message key="eMR.ApplicationCompletionDates.label" bundle="${mr_labels}"/></th>
							<%}%>
							<!--End ML-MMOH-CRF-0701-->

								<!-- Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705 -->
							<%if(IsPendingAssignPractAvbl && (status_to_show.equals("9") || status_to_show.equals("11"))){%>
							<th nowrap><fmt:message key="eMR.PendingAssgnPract.label" bundle="${mr_labels}"/></th>
							<% } %>

							<th nowrap><fmt:message key="eMR.CollectDate.label" bundle="${mr_labels}"/></th>
							<%if(call_function.equals("PREPARE_MEDICAL_REPORT")){ %>
								<th wrap><fmt:message key="eMR.RevisedDate.label" bundle="${mr_labels}"/></th> 
							<%}%>
							<%if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl){ // added by mujafar for ML-MMOH-CRF-706 %>
							<th nowrap><fmt:message key="eMR.DueDays.label" bundle="${mr_labels}"/></th>
							<%}%>
						<!--Added by Manivannan  for ML-MMOH-CRF-0715 Start-->
						
							<%if(!call_function.equals("PREPARE_MEDICAL_REPORT")||(isRequestStatus_YN==true) ){ // modified by mujafar for ML-MMOH-CRF-0714
								if(isRejectReportApplicable && request_type.equals("MR"))
								{%>
								<th wrap>
								<!--<fmt:message key="Common.Request.label" bundle="${common_labels}"/>/<fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>-->
								<fmt:message key="eMR.RequestOrReportStatus.label" bundle="${mr_labels}"/>
								
								</th>
								<%}
								else{ 
								if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT")&& isDuedateAppl){ // added by mujafar for ML-MMOH-CRF-706
								%>
								<th wrap>
								<!--<fmt:message key="Common.Request.label" bundle="${common_labels}"/>/<fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>-->
								<fmt:message key="eMR.RequestOrReportStatus.label" bundle="${mr_labels}"/> 
								
								</th>
								<%}
								else{
								%>
								
								<th wrap><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></th>
								<%}}%>
							<%}%>
							<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->
							<% if(isIncompReqCancelApplicable == true && !call_function.equals("PREPARE_MEDICAL_REPORT") && !status_to_show.equals("6")){
								if(isRejectRequestAppl && request_type.equals("MR") ) {%> <!-- added by mujafar for ML-MMOH-CRF-0713 -->
								
							<th wrap>
							<!--<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/>/<fmt:message key="Common.Rejected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/>-->
								<fmt:message key="eMR.CancelledOrRejectedStatus.label" bundle="${mr_labels}"/>
								</th>
								<%}
								 } %>
							<!--End-->
						</tr>
						
						<%
					}
					else{ // added by mujafar for ML-MMOH-CRF-1280
					
					fieldOrderJSON = eMR.MRCommonBean.getFieldNames(con,facility_id,loginUser);
	
					arrList		= (ArrayList) fieldOrderJSON.get("fieldNames");

					recCnt		= (Integer) fieldOrderJSON.get("recCnt");
					
					
		
					%>
					<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
					<tr>
					<%
					for(int k=0;k<recCnt;k++)
					{
					String fieldName = "";
					fieldName = (String)arrList.get(k);
				
					  if(fieldName.equals("REQUEST_ID")){
					%>	
					<th nowrap><fmt:message key="eMR.RequestID.label" bundle="${mr_labels}"/></th>	
					  <%}else if(fieldName.equals("PATIENT_ID")){%>	
					<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>	
					<%}else if(fieldName.equals("PATIENT_NAME")){%>	
					<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>	
					  <%}else if(fieldName.equals("GENDER")){%>	
					<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>		
					<%}else if(fieldName.equals("PRACTITIONER")){%>		
					<th nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>	
					<%}else if(fieldName.equals("REQUEST_DATE")){%>		
					<th nowrap><fmt:message key="Common.RequestDate.label" bundle="${common_labels}"/></th>
					<%}else if(fieldName.equals("COLLECT_DATE")){%>		
					<th nowrap><fmt:message key="eMR.CollectDate.label" bundle="${mr_labels}"/></th>
					<%}else if(fieldName.equals("PENDING_ASSIGN_PRACTITIONER")){
						if(IsPendingAssignPractAvbl && (status_to_show.equals("9") || status_to_show.equals("11"))){
						%>		
					<th nowrap><fmt:message key="eMR.PendingAssgnPract.label" bundle="${mr_labels}"/></th>
					<%}}else if(fieldName.equals("REQUEST_TYPE")){
						if(call_function.equals("QUERY_DELAY_IN_MRR")){
						%>	
					<th wrap><fmt:message key="Common.RequestType.label" bundle="${common_labels}"/></th>
					
					<%}}else if(fieldName.equals("APPL_COMP_DATE")){
					if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")){	
						
					%>		
					<th wrap><fmt:message key="eMR.ApplicationCompletionDates.label" bundle="${mr_labels}"/></th>	
					<%}}else if(fieldName.equals("PENDING_ASSIGN_PRACTITIONER")){
						if(IsPendingAssignPractAvbl && (status_to_show.equals("9") || status_to_show.equals("11"))){
						%>	
					<th nowrap><fmt:message key="eMR.PendingAssgnPract.label" bundle="${mr_labels}"/></th>
					<%}}else if(fieldName.equals("REVISE_DATE")){
						if(call_function.equals("PREPARE_MEDICAL_REPORT")){
						%>	
						<th wrap><fmt:message key="eMR.RevisedDate.label" bundle="${mr_labels}"/></th> 
					<%}}else if(fieldName.equals("DUE_DAYS")){
						if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl){ 
						%>
						<th nowrap><fmt:message key="eMR.DueDays.label" bundle="${mr_labels}"/></th>
					<%}}else if(fieldName.equals("REQUEST_STATUS")){
						if(!call_function.equals("PREPARE_MEDICAL_REPORT")||(isRequestStatus_YN==true) ){ 
								if(isRejectReportApplicable && request_type.equals("MR"))
								{%>
								<th wrap>
								<!--<fmt:message key="Common.Request.label" bundle="${common_labels}"/>/<fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>-->
									 <fmt:message key="eMR.RequestOrReportStatus.label" bundle="${mr_labels}"/> 
								
								</th>
								<%}
								else{ 
								if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT")&& isDuedateAppl){ 
								%>
								<th wrap>
								<!--<fmt:message key="Common.Request.label" bundle="${common_labels}"/>/<fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>-->
								 <fmt:message key="eMR.RequestOrReportStatus.label" bundle="${mr_labels}"/>
								</th>
								<%}
								else{
								%>
								
								<th wrap><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></th>

					<%}}}}else if(fieldName.equals("CANCELLED_DETAILS")){ 
					if(isIncompReqCancelApplicable == true && !call_function.equals("PREPARE_MEDICAL_REPORT") && !status_to_show.equals("6")){
								if(isRejectRequestAppl && request_type.equals("MR") ) {
					
					%>

					<th wrap>
					<!--<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/>/<fmt:message key="Common.Rejected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/>-->
					<fmt:message key="eMR.CancelledOrRejectedStatus.label" bundle="${mr_labels}"/>
					</th>	
					<%
					}}}
					}
					%>
					</tr>
					<%
					}
					}
					

					/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
					cancelledBy		= rs.getString("cancelled_by");
					if(cancelledBy == null) cancelledBy="";
					cancelledDate	= rs.getString("cancelled_date");
					if(cancelledDate == null) cancelledDate="";
					cancelReason	= rs.getString("cancel_reason_code");
					if(cancelReason == null) cancelReason="";
					reqStatusNum	= rs.getString("request_status");
					if(reqStatusNum == null) reqStatusNum="";
					/*End*/
					// added by mujafar for ML-MMOH-CRF-0713 start
					  rejected_by = rs.getString("rejected_by");
					  if(rejected_by == null) rejected_by="";
					  reject_date = rs.getString("reject_date");
					  if(reject_date == null) reject_date=""; 
					  reason_rejection = rs.getString("reason_rejection");
					  if(reason_rejection == null) reason_rejection="";  
					// end
					
					modificationRemarks	= checkForNull(rs.getString("MODIFICATION_REMARKS"));//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233
					
					// added by mujafar for ML-MMOH-CRF-0714 start
					received_date = rs.getString("received_date");
					  if(received_date == null) received_date="";
					  mrp_rejected_by = rs.getString("mrp_rejected_by");
					  if(mrp_rejected_by == null) mrp_rejected_by=""; 
					  mrp_reason_rejection = rs.getString("mrp_reason_rejection");
					  if(mrp_reason_rejection == null) mrp_reason_rejection="";
					
					// end
					due_days = rs.getString("due_days"); // added by mujafar for ML-MMOH-CRF-706
					  if(due_days == null) due_days="";

					overdue_status = rs.getString("OVERDUE_STATUS");
					if(overdue_status == null) overdue_status="N";
					request_id = rs.getString("REQUEST_ID");
					if(request_id == null) request_id="&nbsp;";
					med_board_type_code = rs.getString("MED_BOARD_TYPE_CODE");
					if(med_board_type_code == null) med_board_type_code="";
					prepare_pract_id=rs.getString("PRACTITIONER_NAME");
					if(prepare_pract_id == null) prepare_pract_id="&nbsp;";
					team_id=rs.getString("TEAM_SHORT_DESC");
					if(team_id == null) team_id="&nbsp;";
					
					//Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705
					forwarded_hod_date = checkForNull(rs.getString("forwarded_hod_date"));
					
					if(!forwarded_hod_date.equals(""))
					pract_days = Integer.parseInt(forwarded_hod_date);
					
				
					/*Added by Thamizh selvi on 31st Jan 2019 against ML-MMOH-CRF-1233 Start*/
					if(isDeliveredRepModifyAppl && reqStatusNum.equals("98") && !modificationRemarks.equals("") && !mrp_reason_rejection.equals("")){
						modificationYN = eMR.MRCommonBean.getlatestRejectionDate(con,facility_id,request_id);
					}else if(isDeliveredRepModifyAppl && reqStatusNum.equals("98") && !modificationRemarks.equals("") && mrp_reason_rejection.equals("")){
						modificationYN = "Y";
					}else{
						modificationYN = "N";
					}if(modificationYN == null || ("").equals(modificationYN)) modificationYN="N";
					/*End*/

					/*Added by Manivannan  for ML-MMOH-CRF-0715 Start*/
					if(call_function.equals("QUERY_DELAY_IN_MRR")||isRequestStatus_YN==true){ 
						request_type = rs.getString("request_type");
						if(request_type == null) request_type="";
					}
					if(request_type.equals("MR")){ 
						request_status = rs.getString("REQUEST_STATUS_DESC");
						request_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReport.label","mr_labels");
						/*ML-MMOH-CRF-0713 */
						if(request_status.equals("RETURNED REQUEST") && isRejectRequestAppl)
						{
						//request_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");	
						request_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RejectedRequest.label","common_labels");	
						//request_status=request_status.toUpperCase(); 
						}	
						/* ML-MMOH-CRF-0713*/
					}else if(request_type.equals("MB")){
						request_status = rs.getString("BOARD_REQUEST_STATUS_DESC");
					
						request_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalBoard.label","mr_labels");
					}
					if(request_status == null) request_status="&nbsp;";
					if(request_type.equals("MB") && status_to_show.equals("9") )
					request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDelivered.label","mr_labels");
					revise_status=rs.getString("revise_status");
					if(revise_status == null) revise_status="N";

					//						if(revise_status.equals("Y"))
					//							request_status	 = "Overdue";

					patient_name_from_vw=rs.getString("PATIENT_NAME");
					if(patient_name_from_vw == null) patient_name_from_vw="&nbsp;";
					appointment_date_from_vw=rs.getString("APPT_DATE");
					if(appointment_date_from_vw == null) appointment_date_from_vw="";
					appt_ref_no_from_vw=rs.getString("appt_ref_no");
					if(appt_ref_no_from_vw == null) appt_ref_no_from_vw="";
					patient_id_from_vw=rs.getString("PATIENT_ID");
					if(patient_id_from_vw == null) patient_id_from_vw="&nbsp;";
					gender_from_vw=rs.getString("sex");
					if(gender_from_vw == null) gender_from_vw="&nbsp;";
					if(gender_from_vw == null ){
						gender_from_vw="";
					}else if (gender_from_vw.equals("M")){
						gender_from_vw = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					}else if (gender_from_vw.equals("F")){
						gender_from_vw = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					}else{
						gender_from_vw = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
	     			}
					if(call_function.equals("PREPARE_MEDICAL_REPORT") ){
						int srlCount = 0;
						revised_dt = "&nbsp;";
						String Srl_Sql = "select NVL(MAX(srl_no),0) from MR_REPORT_REQUEST_REV_DTL where facility_id ='"+facility_id+"' and patient_id='"+patient_id_from_vw+"' and request_id='"+request_id+"' "; // request_id added by mujafar for ML-MMOH-CRF-706(existing issue)
						if(srlRS != null) 	srlRS = null;
						if(srlStmt != null) srlStmt = null;
						srlStmt	= con.createStatement();
						srlRS   = srlStmt.executeQuery(Srl_Sql);
						if(srlRS != null){
							if(srlRS.next()){
								srlCount = srlRS.getInt(1); 
							}
						}
						String revised_dtSql = "select srl_no, request_id, to_char(revised_date, 'dd/mm/yyyy hh24:mi') revised_dt from MR_REPORT_REQUEST_REV_DTL where facility_id ='"+facility_id+"' and patient_id = '"+patient_id_from_vw+"' and srl_no='"+srlCount+"'and request_id='"+request_id+"' ";
						if(srlRS != null) 	srlRS = null;
						if(srlStmt != null) srlStmt = null;
						srlStmt	= con.createStatement();
						srlRS   = srlStmt.executeQuery(revised_dtSql);
						if(srlRS != null){
							while(srlRS.next()){
								revised_dt = srlRS.getString("revised_dt"); 
							}
						}
						if(revised_dt == null) {
						revised_dt = "&nbsp;";
						}else if(!(revised_dt==null || revised_dt.equals("") || revised_dt.equals("&nbsp;"))){
							revised_dt = DateUtils.convertDate(revised_dt,"DMYHM","en",locale);
						}
					}
					String DtlSql = "select request_id, patient_id, encounter_id from MR_REPORT_REQUEST_DTL where facility_id ='"+facility_id+"' and patient_id='"+patient_id_from_vw+"' and request_id='"+request_id+"'";
					dtlStmt	= con.createStatement();
					dtlRs   = dtlStmt.executeQuery(DtlSql);
					if(dtlRs != null && dtlRs.next()){
						encounter_id = checkForNull(dtlRs.getString("ENCOUNTER_ID")); 
					}
					if(dtlRs != null) dtlRs.close();
					if(dtlStmt != null) dtlStmt.close();
					if(class_val.equals("QRYEVEN")){
						class_val = "QRYODD";
					}else{
						class_val = "QRYEVEN";
					}
		
		if(!(isMRConfigurationAppl.equals("true")) || (isMRConfigurationAppl.equals("true") && call_function.equals("QUERY_DELAY_IN_MRR") ) ||      (isMRConfigurationAppl.equals("true") && request_type.equals("MB") && !call_function.equals("QUERY_DELAY_IN_MRR") ))
			{  // if condition added by mujafar for ML-MMOH-CRF-1280
					
					%>
					<tr>
						<%
						String collect_dt = rs.getString("collect_date") ;
						String collect_dt_display = "";
						if(collect_dt == null) 	{ 
							collect_dt = "&nbsp;";
							collect_dt_display = "&nbsp;";
						}else{
							collect_dt_display = DateUtils.convertDate(collect_dt,"DMYHM","en",locale);
						}
						String prepared_dt = rs.getString("PREPARED_DATE") ;
						if(prepared_dt == null) prepared_dt = "&nbsp;";
						if( (call_function.equals("RECEIVE_MEDICAL_REPORT") && prepared_dt.equals("&nbsp;")) || (call_function.equals("QUERY_DELAY_IN_MRR")) || title.equals("PREV_DEL_REPORT")){	%>					
							<td class='<%=class_val%>' align='center' nowrap><%=request_id%></td>
						<%}else{ 
						
						String request_status_des = request_status.replace(" ","_"); // added by mujafar for ML-MMOH-CRF-0714
						
						
						%>
							<td class='<%=class_val%>' align='center' nowrap>
								<a href=javascript:callModalWindow('<%=revise_status%>','<%=request_id%>','<%=call_function%>','<%=checkForNull(rs.getString("PATIENT_ID"))%>','<%=appointment_date_from_vw%>','<%=med_board_type_code%>','<%=encounter_id%>','<%=appt_ref_no_from_vw%>','<%=checkForNull(rs.getString("request_status"))%>','<%=checkForNull(rs.getString("overdue_status"),"N")%>','<%=rs.getString("curr_date")%>','<%=request_status_des%>')><%=request_id%></a>
							</td>
						<%}%>
						<td class='<%=class_val%>' nowrap>
							<%String req_date_display = rs.getString("request_date");
							if(req_date_display == null){ 
								req_date_display = "&nbsp;";
							}else{
								req_date_display = DateUtils.convertDate(req_date_display,"DMY","en",locale);
							}
							out.println(req_date_display);
							%>
						</td>
						<%if(call_function.equals("QUERY_DELAY_IN_MRR")){%>
							<td class='<%=class_val%>' nowrap><%=request_type_desc%>&nbsp;</td>
						<%}%>
						<td class='<%=class_val%>' nowrap><%=patient_id_from_vw%></td>
						<td class='<%=class_val%>' nowrap><%=patient_name_from_vw%></td>
						<td class='<%=class_val%>' nowrap><%=gender_from_vw%></td>
						<td class='<%=class_val%>' nowrap><%=prepare_pract_id%></td>
						
						<!-- Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705 -->
						<%if(IsPendingAssignPractAvbl == true && (status_to_show.equals("9") || status_to_show.equals("11"))){
							if(pract_days >= 4)
							{ // added by mujafar for ML-MMOH-CRF-1278
							%>
							<td class='<%=class_val%>' nowrap><font color='red'><%=forwarded_hod_date%> <fmt:message key="Common.days.label" bundle="${common_labels}"/></font></td>
							<%
							}
							else{
							%>
							<td class='<%=class_val%>' nowrap><%=forwarded_hod_date%> <fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
							
						<%}}%>

						<!--Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701-->
						<%if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")){

						String appl_comp_dt = rs.getString("appl_completion_date") ;
						String appl_comp_dt_display = "";

						if(appl_comp_dt == null)
						{ 
							appl_comp_dt = "&nbsp;";
							appl_comp_dt_display = "&nbsp;";
						}else
						{
							appl_comp_dt_display = DateUtils.convertDate(appl_comp_dt,"DMYHM","en",locale);
						}%>

						<td class='<%=class_val%>' nowrap><%=appl_comp_dt_display%></td>

						<%}%>
						<!-- End ML-MMOH-CRF-0701-->

					
						<td class='<%=class_val%>' nowrap><%=collect_dt_display%></td>
						<%	if(call_function.equals("PREPARE_MEDICAL_REPORT")){%>
							<td class='<%=class_val%>' nowrap><%=revised_dt%></td>
						<%}%>
						
						<%if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl) { // added by mujafar for ML-MMOH-CRF-706 %>
						<td class='<%=class_val%>' nowrap><%=due_days%></td> 
						
						<%}%>
						
						
						
						<!--Added by Manivannan  for ML-MMOH-CRF-0715 Start-->					
							
						<%
if(!call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("QUERY_DELAY_IN_MRR")||(isRequestStatus_YN==true))
{             
			/*Below line added for this CRF ML-MMOH-CRF-0712*/
				if(isMedicalReportRequest && request_status.equals("MEDICAL REPORT CANCELLED") && reqStatusNum.equals("8")){
					 request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CancelRequestbymrd.label","mr_labels");
				}
			//End this CRF ML-MMOH-CRF-0712
			// below if condition added for ML-MMOH-CRF-713 (label change)
			
			if(reqStatusNum.equals("99"))
				request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AutoCancelRequest.label","mr_labels");
				

 %>
							<%
							
							if(isOverduePractitionerApplicable && request_status.equals("OVERDUE") && request_type.equals("MR") && (reqStatusNum.equals("3")||reqStatusNum.equals("98")))
							{  // if block added by mujafar for ML-MMOH-CRF-0710
							String request_status_dump=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OverduebyPractitioner.label","mr_labels");
							%>
							<td class='<%=class_val%>' nowrap><font color="red"><%=request_status_dump%></font>&nbsp;</td>
							<%}else{
									if(request_type.equals("MR"))
									{
									if(request_status.equals("OVERDUE"))
									{
										request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Overdue.label","common_labels");
									}
									else
									{
										if(reqStatusNum.equals("1"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
										if(reqStatusNum.equals("2"))
										{
											if(isAcceptRequestByPractAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1279
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusCompleted.label","mr_labels");
												//request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels");
											else
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusCompleted.label","mr_labels");
										}
										if(reqStatusNum.equals("3")|| reqStatusNum.equals("0"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoPractitioner.label","mr_labels");
									   if(reqStatusNum.equals("4"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PreparedbyPractitioner.label","mr_labels");	
									   if(reqStatusNum.equals("5"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReceivedbyMedicalRecord.label","mr_labels");
									   if(reqStatusNum.equals("6")){
										   //Below conditoin Added By Dharma on Apr 9th 2020 against Ml-MMOH-CRF-1314
										   if(isAcceptRequestByPractAppl.equals("true")){
										   		request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDeliveredByMR.label","mr_labels");
									   		}else{
									   			request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDelivered.label","mr_labels");	
									   		}
											
									   }
									   if(reqStatusNum.equals("7"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.statusincomplete.label","common_labels");
										if(reqStatusNum.equals("8") && !isMedicalReportRequest)
											//request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
										request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CancelledApplication.label","mr_labels");
										if(reqStatusNum.equals("9"))
										{
											if(isAcceptRequestByPractAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoHOD_Coordinator.label","mr_labels");
											else
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoHOD.label","mr_labels");	
										}
										if(reqStatusNum.equals("10") && !isRejectRequestAppl )
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
										if(reqStatusNum.equals("11"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AcceptedRequest.label","common_labels");
										
										if(reqStatusNum.equals("13")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 start
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AcceptedbyPractitioner.label","mr_labels");
										if(reqStatusNum.equals("14"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoMRD.label","mr_labels");
										if(reqStatusNum.equals("15"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoHOD.label","mr_labels");
										// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 end
									   
										if(reqStatusNum.equals("98"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejectedreport.label","common_labels");	
									}
									}
								%>
							<td class='<%=class_val%>' nowrap><%=request_status%>&nbsp;</td>
							<%}%>
<%}%>
						<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->
						<% if(!call_function.equals("PREPARE_MEDICAL_REPORT") && !status_to_show.equals("6")){
							if(isIncompReqCancelApplicable == true && cancelledBy != "" && reqStatusNum.equals("8")){ %><!-- modified by mujafar for ML-MMOH-CRF-0713 -->
								<td class='<%=class_val%>' nowrap>&nbsp;<%=cancelledBy%> - <%=cancelledDate%>&nbsp;&nbsp;<img alt="Reason - <%=cancelReason%>" src="../../eCommon/images/information.png" width="14" height="14"/>&nbsp;&nbsp;&nbsp;</td>
							<% }
							else
							if(isRejectRequestAppl == true && rejected_by != "" && reqStatusNum.equals("10") && request_status.equals("Rejected Request"))	
							{%>
								<td class='<%=class_val%>' nowrap>&nbsp;<%=rejected_by%> - <%=reject_date%>&nbsp;&nbsp;<img alt="Reason - <%=reason_rejection%>" src="../../eCommon/images/information.png" width="14" height="14"/>&nbsp;&nbsp;&nbsp;</td>
							<%
							}else if(isDeliveredRepModifyAppl && modificationYN.equals("Y") && modificationRemarks != "" && reqStatusNum.equals("98") && request_status.equals("Rejected Report")){//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233
							%>
								<td class='<%=class_val%>' style="text-align: center;" nowrap>
								&nbsp;<%=mrp_rejected_by%> - <%=received_date%>&nbsp;&nbsp;<img align="center" alt="Remarks - <%=modificationRemarks.trim()%>" src="../../eCommon/images/information.png" width="14" height="14"/></td>
							<%
							}
							else
							if(isRejectReportApplicable && mrp_rejected_by!="" && reqStatusNum.equals("98") && request_status.equals("Rejected Report"))
							{  // ADDED BY MUJAFAR FOR ML-MMOH-CRF-0714
							%>
							<td class='<%=class_val%>' nowrap>&nbsp;<%=mrp_rejected_by%> - <%=received_date%>&nbsp;&nbsp;<img alt="Reason - <%=mrp_reason_rejection%>" src="../../eCommon/images/information.png" width="14" height="14"/>&nbsp;&nbsp;&nbsp;</td>
							<%
							}else
							if(isRejectReportApplicable && request_type.equals("MR"))
							{%>
						<td class='<%=class_val%>' nowrap>&nbsp;</td>
							<% }
						} %>
						<!--End-->
					</tr>
					<% 
			}
			else
			{ 
		// added by mujafar for ML-MMOH-CRF-1280 START
			%>	
			<tr>
			
			
			<%
			
					String collect_dt = rs.getString("collect_date") ;
						String collect_dt_display = "";
						if(collect_dt == null) 	{ 
							collect_dt = "&nbsp;";
							collect_dt_display = "&nbsp;";
						}else{
							collect_dt_display = DateUtils.convertDate(collect_dt,"DMYHM","en",locale);
						}
						String prepared_dt = rs.getString("PREPARED_DATE") ;
						if(prepared_dt == null) prepared_dt = "&nbsp;";
					
					for(int k=0;k<recCnt;k++)
					{ 
					String fieldName = "";
					fieldName = (String)arrList.get(k);
					if(fieldName.equals("REQUEST_ID")){
					if( (call_function.equals("RECEIVE_MEDICAL_REPORT") && prepared_dt.equals("&nbsp;")) || (call_function.equals("QUERY_DELAY_IN_MRR")) || title.equals("PREV_DEL_REPORT")){		
					%>
					<td class='<%=class_val%>' align='center' nowrap><%=request_id%></td>
						<%}else{ 
						String request_status_des = request_status.replace(" ","_"); // added by mujafar for ML-MMOH-CRF-0714
						%>
							<td class='<%=class_val%>' align='center' nowrap>
								<a href=javascript:callModalWindow('<%=revise_status%>','<%=request_id%>','<%=call_function%>','<%=checkForNull(rs.getString("PATIENT_ID"))%>','<%=appointment_date_from_vw%>','<%=med_board_type_code%>','<%=encounter_id%>','<%=appt_ref_no_from_vw%>','<%=checkForNull(rs.getString("request_status"))%>','<%=checkForNull(rs.getString("overdue_status"),"N")%>','<%=rs.getString("curr_date")%>','<%=request_status_des%>')><%=request_id%></a>
							</td>
					<%}}else if(fieldName.equals("REQUEST_DATE")){%>
						<td class='<%=class_val%>' nowrap>
							<%String req_date_display = rs.getString("request_date");
							if(req_date_display == null){ 
								req_date_display = "&nbsp;";
							}else{
								req_date_display = DateUtils.convertDate(req_date_display,"DMY","en",locale);
							}
							out.println(req_date_display);
							%>
						</td>
					 <%}else if(fieldName.equals("PATIENT_ID")){%>	
						<td class='<%=class_val%>' nowrap><%=patient_id_from_vw%></td>
					<%}else if(fieldName.equals("PATIENT_NAME")){%>	
					<td class='<%=class_val%>' nowrap><%=patient_name_from_vw%></td>
					  <%}else if(fieldName.equals("GENDER")){%>	
					<td class='<%=class_val%>' nowrap><%=gender_from_vw%></td>		
					<%}else if(fieldName.equals("PRACTITIONER")){%>		
					<td class='<%=class_val%>' nowrap><%=prepare_pract_id%></td>	
					<%}else if(fieldName.equals("PENDING_ASSIGN_PRACTITIONER")){
						if(IsPendingAssignPractAvbl == true && (status_to_show.equals("9") || status_to_show.equals("11"))){
							if(pract_days >= 4)
							{ // added by mujafar for ML-MMOH-CRF-1278 %>
					<td class='<%=class_val%>' nowrap><font color='red'><%=forwarded_hod_date%> <fmt:message key="Common.days.label" bundle="${common_labels}"/></font></td>
							<%
							}
							else{
							%>
							<td class='<%=class_val%>' nowrap><%=forwarded_hod_date%> <fmt:message key="Common.days.label" bundle="${common_labels}"/></td>		
					<%}}}else if(fieldName.equals("APPL_COMP_DATE")){
						if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")){
						String appl_comp_dt = rs.getString("appl_completion_date") ;
						String appl_comp_dt_display = "";
						if(appl_comp_dt == null)
						{ 
							appl_comp_dt = "&nbsp;";
							appl_comp_dt_display = "&nbsp;";
						}else
						{
							appl_comp_dt_display = DateUtils.convertDate(appl_comp_dt,"DMYHM","en",locale);
						}
						%>	
						<td class='<%=class_val%>' nowrap><%=appl_comp_dt_display%></td>
					<%}}else if(fieldName.equals("COLLECT_DATE")){%>
						<td class='<%=class_val%>' nowrap><%=collect_dt_display%></td>	
					<%}else if(fieldName.equals("REVISE_DATE")){
						if(call_function.equals("PREPARE_MEDICAL_REPORT")){
						%>	
						<td class='<%=class_val%>' nowrap><%=revised_dt%></td>
					<%}}else if(fieldName.equals("DUE_DAYS")){
						if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl){%>
						<td class='<%=class_val%>' nowrap><%=due_days%></td> 
						
					<%}}else if(fieldName.equals("REQUEST_STATUS")){
						
						if(!call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("QUERY_DELAY_IN_MRR")||(isRequestStatus_YN==true))
						{  
			/*Below line added for this CRF ML-MMOH-CRF-0712*/
				if(isMedicalReportRequest && request_status.equals("MEDICAL REPORT CANCELLED") && reqStatusNum.equals("8")){
					 request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels");
				}
		
			
			if(reqStatusNum.equals("99"))
				request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AutoCancelApplication.label","mr_labels");
						
				
						%>
		<%
							
							if(isOverduePractitionerApplicable && request_status.equals("OVERDUE") && request_type.equals("MR") && (reqStatusNum.equals("3")||reqStatusNum.equals("98")))
							{  
							String request_status_dump=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OverduebyPractitioner.label","mr_labels");
							%>
							<td class='<%=class_val%>' nowrap><font color="red"><%=request_status_dump%></font>&nbsp;</td>
							<%}else{
									if(request_type.equals("MR"))
									{
									if(request_status.equals("OVERDUE"))
									{
										request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Overdue.label","common_labels");
									}
									else
									{
										if(reqStatusNum.equals("1"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
										if(reqStatusNum.equals("2"))
										{
											if(isAcceptRequestByPractAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1279
											//request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels");
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusCompleted.label","mr_labels");
											else
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusCompleted.label","mr_labels");
										}
										if(reqStatusNum.equals("3")|| reqStatusNum.equals("0"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoPractitioner.label","mr_labels");
									   if(reqStatusNum.equals("4"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PreparedbyPractitioner.label","mr_labels");	
									   if(reqStatusNum.equals("5"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReceivedbyMedicalRecord.label","mr_labels");
									   if(reqStatusNum.equals("6")){
										   //Below conditoin Added By Dharma on Apr 9th 2020 against Ml-MMOH-CRF-1314
										   if(isAcceptRequestByPractAppl.equals("true")){
										   		request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDeliveredByMR.label","mr_labels");
									   		}else{
									   			request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDelivered.label","mr_labels");	
									   		}
									   }
										if(reqStatusNum.equals("7"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.statusincomplete.label","common_labels");
										if(reqStatusNum.equals("8") && !isMedicalReportRequest){ 
										//request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
										request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CancelledApplication.label","mr_labels");
										}
										if(reqStatusNum.equals("9"))
										{
											if(isAcceptRequestByPractAppl.equals("true")) 
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoHOD_Coordinator.label","mr_labels");
											else
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoHOD.label","mr_labels");	
										}
										if(reqStatusNum.equals("10") && !isRejectRequestAppl )
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
										if(reqStatusNum.equals("11"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AcceptedRequest.label","common_labels");
										
										if(reqStatusNum.equals("13")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 start
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AcceptedbyPractitioner.label","mr_labels");
										if(reqStatusNum.equals("14"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoMRD.label","mr_labels");
										if(reqStatusNum.equals("15"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoHOD.label","mr_labels");

									   
										if(reqStatusNum.equals("98"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejectedreport.label","common_labels");	
									}
									}
								%>
							<td class='<%=class_val%>' nowrap><%=request_status%>&nbsp;</td>
					<%}}}else if(fieldName.equals("CANCELLED_DETAILS")){
						 if(!call_function.equals("PREPARE_MEDICAL_REPORT") && !status_to_show.equals("6")){
							if(isIncompReqCancelApplicable == true && cancelledBy != "" && reqStatusNum.equals("8")){ 
						%>
						
						<td class='<%=class_val%>' nowrap>&nbsp;<%=cancelledBy%> - <%=cancelledDate%>&nbsp;&nbsp;<img alt="Reason - <%=cancelReason%>" src="../../eCommon/images/information.png" width="14" height="14"/>&nbsp;&nbsp;&nbsp;</td>
							<% }
							else
							if(isRejectRequestAppl == true && rejected_by != "" && reqStatusNum.equals("10") && request_status.equals("Rejected Request"))	
							{%>
								<td class='<%=class_val%>' nowrap>&nbsp;<%=rejected_by%> - <%=reject_date%>&nbsp;&nbsp;<img alt="Reason - <%=reason_rejection%>" src="../../eCommon/images/information.png" width="14" height="14"/>&nbsp;&nbsp;&nbsp;</td>
							<%
							}else if(isDeliveredRepModifyAppl && modificationYN.equals("Y") && modificationRemarks != "" && reqStatusNum.equals("98") && request_status.equals("Rejected Report")){//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233
							%>
								<td class='<%=class_val%>' style="text-align: center;" nowrap>
								&nbsp;<%=mrp_rejected_by%> - <%=received_date%>&nbsp;&nbsp;
								<img align="center" alt="Remarks - <%=modificationRemarks.trim()%>" src="../../eCommon/images/information.png" width="14" height="14"/></td>
							<%
							}
							else
							if(isRejectReportApplicable && mrp_rejected_by!="" && reqStatusNum.equals("98") && request_status.equals("Rejected Report"))
							{  // ADDED BY MUJAFAR FOR ML-MMOH-CRF-0714
							%>
							<td class='<%=class_val%>' nowrap>&nbsp;<%=mrp_rejected_by%> - <%=received_date%>&nbsp;&nbsp;<img alt="Reason - <%=mrp_reason_rejection%>" src="../../eCommon/images/information.png" width="14" height="14"/>&nbsp;&nbsp;&nbsp;</td>
							<%
							}else
							if(isRejectReportApplicable && request_type.equals("MR"))
							{%>
						<td class='<%=class_val%>' nowrap>&nbsp;</td>
					<% }}}%>

			
  <%}%>	
			</tr>	
			<%	
			} // added by mujafar for ML-MMOH-CRF-1280 END
					
					
					i++;
					p_max_rec_cnt++;
					maxRecord++;
		}
			if ( maxRecord > 5){
			%>
				<script >
					parent.document.getElementById("criteriaFrame").style.height = "44vh";
					parent.document.getElementById("resultFrame").style.height = "37vh";
				</script>
			<%
			}
			else
			{
			%>
				<script >
					parent.document.getElementById("criteriaFrame").style.height = "56vh";
					parent.document.getElementById("resultFrame").style.height = "26vh";
				</script>
			<%
			}
			if ( maxRecord < 8 || (!rs.next())){
				%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
				<%}else{%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>




			<%}
		if(maxRecord == 0 && title.equals("PREV_DEL_REPORT")){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.window.close();</script>");
		}else if(maxRecord == 0){	%>
			<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
	<%}	 
		if (rs != null) rs.close();
        if (pstmt != null) stmt.close();

		%>
    </table>
    <br><center></center>
			<%//}
    }catch(Exception e) {
		//out.println(e.toString());
	e.printStackTrace();}
    finally
    {
	    if(srlRS != null) 	srlRS.close();
		if(srlStmt != null) srlStmt.close();

		if (rs != null) rs.close();
        if (stmt != null) stmt.close();
		//if (iprs != null) iprs.close();
		//if (ipstmt != null) ipstmt.close();
       	//if(Cs_book != null) Cs_book.close();
		 ConnectionManager.returnConnection(con,request);

    }
	%>
 			<input type="hidden" name="request_type" id="request_type" value="<%=request_type%>">
			<input type='hidden' name='param' id='param' value="<%=param%>" >
			<input type='hidden' name='status_to_show' id='status_to_show' value="<%=status_to_show%>" >
			<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>" >
			<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" > 
			<input type='hidden' name='isMedicalTeamApplicable' id='isMedicalTeamApplicable' value="<%=isMedicalTeamApplicable%>" >   <!--Mujafar added ML-MMOH-CRF-0716 -->
			<input type='hidden' name='isAcceptRequestByPractAppl' id='isAcceptRequestByPractAppl' value="<%=isAcceptRequestByPractAppl%>" > <!--  added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 -->
		</form>
	</body>
</html>

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

