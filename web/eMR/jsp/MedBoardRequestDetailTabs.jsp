<!DOCTYPE html>
<%
/**
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 23 MARCH 2005
 			Function name				|		Function ID			| REQUEST_STATUS inserted...
 	Request For Medical Board			| MEDICAL_BOARD_REQUEST		|		1
	Status of Medical Board Request		| MEDICAL_BOARD_STATUS		|		2
	Forward Medical Board Request		| FORWARD_MEDICAL_BOARD		|		3
	Formation of Medical Board			| MEDICAL_BOARD_FORMATION	|		4
	Appointment for Med Board request	| MEDICAL_BOARD_APPT		|		5
	Intimate Appointment of Med Board	| MEDICAL_BOARD_INT_APPT	|		6
	Prepare Medical Report by Board		| PREPARE_MEDICAL_BOARD		|		7
	Receive Medical Report				| RECEIVE_MEDICAL_BOARD		|		8
	Deliver/Dispatch Medical Board		| DELIVER_MEDICAL_BOARD		|		9
	Revise Medical Board				| REVISE_MEDICAL_BOARD		| just update revise collect time...
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*, java.util.*, java.text.*,webbeans.eCommon.*,org.json.simple.*,eCommon.XSSRequestWrapper" %>
<html>
<% 
	
	String Facility_Id = (String) session.getValue("facility_id");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale = (String)session.getAttribute("LOCALE");	
%>

<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eMR/js/MedBoardReqTransaction.js' language='javascript'></script>	
	<script src='../../eMR/js/MRPractitionerComponent.js' language='javascript'></script>	
	<script src='../../eMR/js/MedBoardRequest.js' language='javascript'></script>	
	<script src='../../eOA/js/oamessages.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>

function CheckNumberFormat(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) 
	{
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED","SM"));
            obj.value= "";
            obj.focus();
            return false;
        }
    }
}


function populateRecptDate(obj, dateObj, dateImg)
{
	if(document.forms[0].medrep_pay_int_mode.value == "X")
	{
		if(document.forms[0].call_function.value  == "MEDICAL_BOARD_REQUEST")
		{
			if(obj != "")
			{
				//dateObj.value = document.forms[0].sysdate.value;
				dateObj.value = convertDate(document.forms[0].sysdate.value,'DMYHM','en',localeName);
			}
			else
				dateObj.value = "";
		}
		else if(document.forms[0].call_function.value  == "MEDICAL_BOARD_STATUS")
		{
			if(obj != "")
			{
				dateObj.disabled = false;
				dateImg.disabled = false;
			}
			else
			{
				dateObj.value = "";
				dateObj.disabled = true;
				dateImg.disabled = true;
			}
		}
	}
}


function ValidateRecptDateTime(from,to)
{
	/*from = from.value;
	to   = to.value;
	var a=  from.split(" ");
	splitdate=a[0];
	splittime=a[1];
	var splitdateA =splitdate.split("/");
	var splittimeA= splittime.split(":");
	var from_date  =new Date(eval(splitdateA[2]), eval(splitdateA[1])-1, eval(splitdateA[0]), eval(splittimeA[0]), eval(splittimeA[1]));

	var b=  to.split(" ");
	splitdate=b[0];
	splittime=b[1];
	var splitdateB =splitdate.split("/");
	var splittimeB= splittime.split(":");
	var to_date  =new Date(eval(splitdateB[2]), eval(splitdateB[1])-1, eval(splitdateB[0]), eval(splittimeB[0]), eval(splittimeB[1]));
	*/
	//if(Date.parse(to_date) <= Date.parse(from_date))
	if(isAfter(from,to,'DMYHM','en'))
		return false;
	else
		return true;
}

function recptDateValidations(obj, reqDate, sysDate)
{
	//var result = "Pass";
	//var recptDate = obj.value;
	//var systemDate = sysDate.value;
	var requestDate = reqDate.value;

	/*if(recptDate != '' )
	{
		if(!doDateTimeChk(obj))
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			obj.focus();
			obj.value = "";
			result = "Fail";
			return ;
		}
	}*/

	if(!validDateObj(obj,'DMYHM',localeName))
	{
		obj.focus();
		obj.value = "";
		//result = "Fail";
		return ;
	}
	//if(result == "Pass" && recptDate != '')
	else
	{
			var greg_receiptDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
			//if(ValidateRecptDateTime(sysDate,obj))
			if(isAfterNow(greg_receiptDateTime,'DMYHM','en'))
			{
				var error=getMessage("MRDATE1_GT_DATE2","MR");
				error= error.replace('$',getLabel("eMR.ReceiptDateTime.label","MR"));
				error= error.replace('#',getLabel("Common.SystemDateTime.label","Common"));
				alert(error);
				obj.value = "";
				obj.focus();
				return;
			}
			//else if(ValidateRecptDateTime(obj,reqDate))
			else if(isBefore(greg_receiptDateTime,requestDate,'DMYHM','en'))
			{
				var error=getMessage("MRDATE1_LT_DATE2","MR");
				error= error.replace('$',getLabel("eMR.ReceiptDateTime.label","MR"));
				error= error.replace('#',getLabel("Common.Request.label","Common")+' '+getLabel("Common.datetime.label","Common"));
				alert(error);
				obj.value = "";
				obj.focus();
				return;
			}
	}
}



function CheckZeroVal(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 && obj.value==0) {
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}


function enableOtherDetails(name, value)
{
	medrep_pay_int_mode = document.forms[0].medrep_pay_int_mode.value;
	if(medrep_pay_int_mode == "X")
	{
		if(name == 'charges_appllicable')
		{
			if(value =='Y')
			{
				document.forms[0].amount.value = "";
				document.forms[0].amount.disabled = false;
				document.forms[0].recp_no.value = "";
				document.forms[0].recp_no.disabled = false;
				document.forms[0].recp_dat.value = "";
				document.forms[0].recp_dat.disabled = true;
				document.getElementById("recp_dat_img").disabled = true;
			}
			else if(value =='N' || value =='')
			{
				document.forms[0].amount.value = "";
				document.forms[0].amount.disabled = true;
				document.forms[0].recp_no.value = "";
				document.forms[0].recp_no.disabled = true;
				document.forms[0].recp_dat.value = "";
				document.forms[0].recp_dat.disabled = true;
				document.getElementById("recp_dat_img").disabled = true;
			}
		}
		else if(name == 'additional_charges')
		{
			if(value =='Y')
			{
				document.forms[0].add_amount.value = "";
				document.forms[0].add_amount.disabled = false;
				document.forms[0].add_recp_no.value = "";
				document.forms[0].add_recp_no.disabled = false;
				document.forms[0].add_recp_dat.value = "";
				document.forms[0].add_recp_dat.disabled = true;
				document.getElementById("add_recp_dat_img").disabled = true;
			}
			else if(value =='N' || value =='')
			{
				document.forms[0].add_amount.value = "";
				document.forms[0].add_amount.disabled = true;
				document.forms[0].add_recp_no.value = "";
				document.forms[0].add_recp_no.disabled = true;
				document.forms[0].add_recp_dat.value = "";
				document.forms[0].add_recp_dat.disabled = true;
				document.getElementById("add_recp_dat_img").disabled = true;
			}
		}
	}
	else if(medrep_pay_int_mode == "B")
	{
		if(name == 'charges_appllicable')
		{
			if(value =='Y')
			{
				document.forms[0].amount.value = "";
				document.forms[0].amount.disabled = false;
				document.getElementById("chargeImg3").style.visibility = "visible";
				document.forms[0].recp_no.value = "";
				document.forms[0].recp_no.disabled = true;
				document.forms[0].recp_dat.value = "";
				document.forms[0].recp_dat.disabled = true;
				document.getElementById("recp_dat_img").disabled = true;
			}
			else if(value =='N' || value =='')
			{
				document.forms[0].amount.value = "";
				document.forms[0].amount.disabled = true;
				document.getElementById("chargeImg3").style.visibility = "hidden";
				document.forms[0].recp_no.value = "";
				document.forms[0].recp_no.disabled = true;
				document.forms[0].recp_dat.value = "";
				document.forms[0].recp_dat.disabled = true;
				document.getElementById("recp_dat_img").disabled = true;
			}
		}
		else if(name == 'additional_charges')
		{
			if(value =='Y')
			{
				document.forms[0].add_amount.value = "";
				document.forms[0].add_amount.disabled = false;
				document.getElementById("addtlChargeImg3").style.visibility = "visible";
				document.forms[0].add_recp_no.value = "";
				document.forms[0].add_recp_no.disabled = true;
				document.forms[0].add_recp_dat.value = "";
				document.forms[0].add_recp_dat.disabled = true;
				document.getElementById("add_recp_dat_img").disabled = true;
			}
			else if(value =='N' || value =='')
			{
				document.forms[0].add_amount.value = "";
				document.forms[0].add_amount.disabled = true;
				document.getElementById("addtlChargeImg3").style.visibility = "hidden";
				document.forms[0].add_recp_no.value = "";
				document.forms[0].add_recp_no.disabled = true;
				document.forms[0].add_recp_dat.value = "";
				document.forms[0].add_recp_dat.disabled = true;
				document.getElementById("add_recp_dat_img").disabled = true;
			}
		}	
	}
}

</script>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement appl_typeStmt = null;
	ResultSet appl_typeRS = null;
	Statement oth_stmt = null;
	ResultSet oth_rset = null;
	Statement board_typeStmt = null;
	ResultSet board_typeRS = null;
	boolean isAddressLengthIncAppl = false;//Added by Thamizh selvi on 9th Feb 2018 against ML-MMOH-CRF-0860.2

try 
{
	con = ConnectionManager.getConnection(request);
	String called_from	= checkForNull(request.getParameter("called_from"));
	String call_function= checkForNull(request.getParameter("call_function"));
	isAddressLengthIncAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");//Added by Thamizh selvi on 9th Feb 2018 against ML-MMOH-CRF-0860.2
	String disabledAttribute = "";
	if(call_function.equals("MEDICAL_BOARD_REQUEST") || call_function.equals("MEDICAL_BOARD_STATUS"))
		disabledAttribute = "";
	else
		disabledAttribute = "disabled";

	String disabled = "";
	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		disabled = "";
	else
		disabled = "disabled";

	String dis		= "";
	if(call_function.equals("FORWARD_MEDICAL_BOARD"))
		dis = "";
	else
		dis = "disabled";

	String new_func_id		= checkForNull(request.getParameter("new_func_id"));
	
	String patientId		= checkForNull(request.getParameter("PatientId"));
	String request_id		= checkForNull(request.getParameter("request_id"));
	String patient_id		= "";
	String addr_line1		= "";
	String addr_line2		= "";
	String addr_line3		= "";
	String addr_line4		= "";
	String res_town_code	= "";
	String res_town_desc	= "";
	String res_area_code	= "";
	String res_area_desc	= "";
	String region_code		= "";
	String region_desc		= "";
	String postal_code		= "";
	String res_country_desc = "";
	String res_country_code = "";	
	/*ADDRESS for NKIN*/
	String nkin_addr_line1		= ""; 
	String nkin_addr_line2		= ""; 
	String nkin_addr_line3		= ""; 
	String nkin_addr_line4		= ""; 
	String nkin_res_town_desc	= ""; 
	String nkin_res_town_code	= ""; 
	String nkin_res_area_desc	= ""; 
	String nkin_res_area_code	= ""; 
	String nkin_region_desc		= ""; 
	String nkin_region_code		= ""; 
	String nkin_postal_code		= ""; 
	String nkin_country_desc	= ""; 
	String nkin_country_code	= ""; 
	/*ADDRESS for FTON*/
	String fton_addr_line1		= ""; 
	String fton_addr_line2		= ""; 
	String fton_addr_line3		= ""; 
	String fton_addr_line4		= ""; 
	String fton_res_town_desc	= ""; 
	String fton_res_town_code	= ""; 
	String fton_res_area_desc	= ""; 
	String fton_res_area_code	= ""; 
	String fton_region_desc		= ""; 
	String fton_region_code		= ""; 
	String fton_postal_code		= ""; 
	String fton_country_desc	= ""; 
	String fton_country_code	= ""; 
	/*ADDRESS for EMPLR*/
	String emplr_addr_line1		= ""; 
	String emplr_addr_line2		= ""; 
	String emplr_addr_line3		= ""; 
	String emplr_addr_line4		= ""; 
	String emplr_res_town_desc	= ""; 
	String emplr_res_town_code	= ""; 
	String emplr_res_area_desc	= ""; 
	String emplr_res_area_code	= ""; 
	String emplr_region_desc	= ""; 
	String emplr_region_code	= ""; 
	String emplr_postal_code	= ""; 
	String emplr_country_desc	= ""; 
	String emplr_country_code	= ""; 

	String SystemDate				= "";
	String accession_num			= "";
	String Request_desc				= "";
	String reqDate					= "";
	String reqDate_converted		= "";
	String appl_completion_date		= "";
	String remarks					= "";
	String RecdDate					= "";
	String RecdDate_converted		= "";
	String prepareDate				= "";
	String prepareDate_converted	= "";
	String team_desc				= "";
	String Pract_name				= "";
	String Medical_members			= "";
	String med_board_type_code		= "";
	String med_board_short_desc		= "";
	String CollectDate				= "";
	String CollectDate_Converted	= "";
	String team_code				= "";
	String pract_code				= "";
	String requestor_code			= "";
	String revised_collect_date		= "";
	String revised_collect_date_converted = "";
	String nat_id_prompt			= "";
	String accept_national_id_no_yn	= "";

	String relationship_code	= "";
	String relationship_desc	= "";
	String relationship_type	= ""; 
	String requestor_desc		= ""; 
	String appl_type_code		= ""; 
	String appl_type_desc		= ""; 
	String appl_no				= ""; 
	String applicant_name		= ""; 
	String application_date		= ""; 
	String cons_letter			= ""; 
	String application_ref_no	= ""; 
	String for_attn_of			= ""; 
	String report_type_code		= ""; 
	String specialty_code		= ""; 
	String indicator			= ""; 
	String required_docs		= ""; 
	String forwarded_pract_name = "";
	String requesting_pract_name= "";
	String forwarded_pract_id	= "";
	String requesting_pract_id  = "";
	String amount				= "";
	String receipt_no			= "";
	String receipt_date			= "";
	String receipt_date_converted = "";
	String addl_amount			= "";
	String addl_receipt_no		= "";
	String addl_receipt_date	= "";
	String addl_receipt_date_converted = "";
	String charges_appl_yn		= "";
	String addl_charges_yn		= "";
	String med_board_type		= "";
	String event_status			= "";
	String no_of_days			= "";
	String data					= "";
	String code					= "";
	String sel					= "";
	String ca_install_yn		= "";
	String delivered_date		= "";
	String delivered_date_converted = "";
	String applSubmissionDate	= "";
	String posted_date			= "";
	String posted_date_converted= "";
	String dispatch_mode		= "";
	String sec_file_no			= "";
	String report_taken_by		= "";
	String rtb_national_id_no	= "";
	String rtb_alt_id_type		= "";
	String rtb_alt_id__no		= "";
	String SystemDate_display	= "";

	/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
	String requestor_type_desc	= "";

	StringBuffer sqlBuff=new StringBuffer();
	String medrep_pay_int_mode = "X";

	Statement stmt = null;
	PreparedStatement pstmt1		= null;
	stmt = con.createStatement();

	try
	{	
		try
		{	
			String mrParamSql = " select medrep_pay_int_mode, to_char(sysdate,'dd/mm/yyyy hh24:mi')SystemDate from MR_PARAMETER ";
			if (rs != null) rs.close();
			rs	=	stmt.executeQuery(mrParamSql);


			if (rs.next() && rs != null)
			{
				medrep_pay_int_mode = rs.getString("medrep_pay_int_mode");
				SystemDate			= rs.getString("SystemDate");
			}
			SystemDate_display = DateUtils.convertDate(SystemDate,"DMYHM","en",locale);
			if(medrep_pay_int_mode == null ) medrep_pay_int_mode = "X";
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
		}catch(Exception e) 
		{
			//out.println("Exception in MR_PARAMETER Query : "+e);
			e.printStackTrace();
		}

		String CAinstall = " select install_yn FROM SM_MODULE WHERE module_id = 'CA' ";
		pstmt = con.prepareStatement(CAinstall);
		rs	=	pstmt.executeQuery();

		if ((rs != null) && (rs.next()))
		{
			ca_install_yn = rs.getString("install_yn");
			if(ca_install_yn == null) ca_install_yn ="N";
		}

		if(rs	 != null)   rs.close();
		if(pstmt	 != null)   pstmt.close();

		if((!patientId.equals("")) && (call_function.equals("PREPARE_MEDICAL_BOARD") || call_function.equals("DELIVER_MEDICAL_BOARD")))
		{
			sqlBuff.append("select a.EVENT_STATUS,a.ACCESSION_NUM from CA_ENCNTR_NOTE a ");
			sqlBuff.append(" where a.patient_id=? and a.ACCESSION_NUM = ");
			sqlBuff.append(" (select ACCESSION_NUM from MR_REPORT_REQUEST_HDR where ");
			sqlBuff.append(" facility_id=? and patient_id = ? ");
			sqlBuff.append(" and REQUEST_ID =?) ");

			pstmt = con.prepareStatement(sqlBuff.toString());
			pstmt.setString(1,patientId);
			pstmt.setString(2,Facility_Id);
			pstmt.setString(3,patientId);
			pstmt.setString(4,request_id);

			rs	=	pstmt.executeQuery();
			if (rs.next() && rs != null)
			{
				accession_num	= checkForNull(rs.getString("ACCESSION_NUM"));
				event_status	= checkForNull(rs.getString("EVENT_STATUS"));
			}

			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}

		if(!request_id.equals(""))
		{
						
			String MainSql=" SELECT Addl_Amount, Addl_Charges_yn, Addl_Receipt_No, Am_Get_desc.Am_practitioner(Forwarded_prAct_Id,'"+locale+"','1') Forwarded_prAct_Name, Am_Get_desc.Am_practitioner(RequestIng_prAct_Id,'"+locale+"','1') RequestIng_prAct_Name, Am_Get_desc.Am_speciality(Specialty_Code,'"+locale+"','1') Specialty_Short_desc, Am_Get_desc.Am_medical_team(Prepare_Team_Id,Prepare_Team_Id,'"+locale+"','1') Team_Short_desc, To_char(Addl_Receipt_Date,'dd/mm/yyyy hh24:mi') Addl_Receipt_Date, Amount, apPl_No, apPl_Type_Code, mr_Get_desc.MR_APPL_TYPE(APPL_TYPE_CODE,'"+locale+"','1') apPl_Type_Short_desc, Applicant_Name, Application_ref_No, Charges_apPl_yn, Consent_Letter_apPl, Dispatch_Mode, For_Attn_Of, Forwarded_prAct_Id, c.INDICATOR, (select long_desc from mr_requestor_type where REQUESTOR_TYPE_CODE = c.indicator) indicator_desc, mp_Get_desc.Mp_relationship(Relationship_Code,'"+locale+"','1') rel_Short_desc, Patient_Id,Prepare_prAct_Id, Prepare_Team_Id, Receipt_No, Relationship_Code, Relationship_Type, Remarks, Report_Taken_By, Report_Type_Code,   RequestIng_prAct_Id, a.RequestOr_Code, MR_GET_DESC.MR_REQUESTOR('"+Facility_Id+"',a.RequestOr_Code,'"+locale+"','2')requestor_short_desc, Required_Docs, rTb_alt_Id__No, rTb_alt_Id_Type, rTb_National_Id_No, sec_File_No, med_board_type_code,  MR_GET_DESC.MR_MEDICAL_BOARD_TYPE(a.MED_BOARD_TYPE_CODE,'"+locale+"','2') med_board_short_desc, To_char(apPl_Completion_Date,'dd/mm/yyyy hh24:mi') apPl_Completion_Date, To_char(apPl_Submitted_Date,'dd/mm/yyyy hh24:mi') apPlSubmissionDate, To_char(Application_Date,'dd/mm/yyyy hh24:MI') Application_Date, To_char(Collect_Date,'dd/mm/yyyy hh24:mi') Collect_Date, To_char(Delivered_Date,'dd/mm/yyyy hh24:mi') Delivered_Date, To_char(Posted_Date,'dd/mm/yyyy hh24:mi') Posted_Date, To_char(Prepared_Date,'dd/mm/yyyy hh24:mi') Prepared_Date, To_char(Receipt_Date,'dd/mm/yyyy hh24:mi') Receipt_Date, To_char(Received_Date,'dd/mm/yyyy hh24:mi') Received_Date, To_char(Request_Date,'dd/mm/yyyy hh24:mi') Request_Date,To_char(Revised_Collect_Date,'dd/mm/yyyy hh24:mi') Revised_Collect_Date, Trunc(Prepared_Date - apPl_Completion_Date) No_Of_Days FROM MR_REPORT_REQUEST_HDR a,  MR_REQUESTOR c WHERE a.facility_id = ? AND a.request_id = ? AND c.REQUESTOR_CODE (+) = a.REQUESTOR_CODE ";
			
			/*Query modified by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/ 

			pstmt= con.prepareStatement(MainSql);
			pstmt.setString(1,Facility_Id);
			pstmt.setString(2,request_id);
			rs	= pstmt.executeQuery();
			if (rs.next() && rs != null)
			{
				patient_id				= checkForNull(rs.getString("PATIENT_ID"));
				amount					= checkForNull(rs.getString("AMOUNT"));
				receipt_no				= checkForNull(rs.getString("RECEIPT_NO"));

				receipt_date			= checkForNull(rs.getString("RECEIPT_DATE"));
				if(!(receipt_date==null || receipt_date.equals("")))
					receipt_date_converted = DateUtils.convertDate(receipt_date,"DMYHM","en",locale);

				addl_amount				= checkForNull(rs.getString("ADDL_AMOUNT"));
				addl_receipt_no			= checkForNull(rs.getString("ADDL_RECEIPT_NO"));

				addl_receipt_date		= checkForNull(rs.getString("ADDL_RECEIPT_DATE"));
				if(!(addl_receipt_date==null || addl_receipt_date.equals("")))
				addl_receipt_date_converted = DateUtils.convertDate(addl_receipt_date,"DMYHM","en",locale);

				charges_appl_yn			= checkForNull(rs.getString("CHARGES_APPL_YN"));
				addl_charges_yn			= checkForNull(rs.getString("ADDL_CHARGES_YN"));
				med_board_type			= checkForNull(rs.getString("MED_BOARD_TYPE_CODE"));
				Request_desc			= checkForNull(rs.getString("REQUESTOR_SHORT_DESC"));

				reqDate					= checkForNull(rs.getString("REQUEST_DATE"));
				if(!(reqDate==null || reqDate.equals("")))
					reqDate_converted	= DateUtils.convertDate(reqDate,"DMYHM","en",locale);

				revised_collect_date	= checkForNull(rs.getString("REVISED_COLLECT_DATE"));
				if(!(revised_collect_date==null || revised_collect_date.equals("")))
				revised_collect_date_converted= DateUtils.convertDate(revised_collect_date,"DMYHM","en",locale);


				appl_completion_date	= checkForNull(rs.getString("appl_completion_date"));
				remarks					= checkForNull(rs.getString("REMARKS"));

				application_date		= checkForNull(rs.getString("application_date"));
				if(!(application_date==null || application_date.equals("")))
					application_date	= DateUtils.convertDate(application_date,"DMYHM","en",locale);

				
				RecdDate				= checkForNull(rs.getString("RECEIVED_DATE"));
				if(!(RecdDate==null || RecdDate.equals("")))
					RecdDate_converted	= DateUtils.convertDate(RecdDate,"DMYHM","en",locale);

				

				prepareDate				= checkForNull(rs.getString("PREPARED_DATE"));
				if(!(prepareDate==null || prepareDate.equals("")))
				prepareDate_converted	= DateUtils.convertDate(prepareDate,"DMYHM","en",locale);

				team_desc				= checkForNull(rs.getString("TEAM_SHORT_DESC"));
				med_board_type_code		= checkForNull(rs.getString("MED_BOARD_TYPE_CODE"));
				med_board_short_desc	= checkForNull(rs.getString("MED_BOARD_SHORT_DESC"));

				CollectDate				= checkForNull(rs.getString("COLLECT_DATE"));
				if(!(CollectDate==null || CollectDate.equals("")))
					CollectDate_Converted = DateUtils.convertDate(CollectDate,"DMYHM","en",locale);

				team_code				= checkForNull(rs.getString("PREPARE_TEAM_ID"));
				pract_code				= checkForNull(rs.getString("PREPARE_PRACT_ID"));
				requestor_code			= checkForNull(rs.getString("REQUESTOR_CODE"));
				relationship_type		= checkForNull(rs.getString("RELATIONSHIP_TYPE"));
				relationship_code		= checkForNull(rs.getString("RELATIONSHIP_CODE"));  
				relationship_desc		= checkForNull(rs.getString("REL_SHORT_DESC"));  
				requestor_desc			= checkForNull(rs.getString("REQUESTOR_SHORT_DESC"));
				appl_type_code			= checkForNull(rs.getString("APPL_TYPE_CODE"));
				appl_type_desc			= checkForNull(rs.getString("APPL_TYPE_SHORT_DESC"));
				appl_no					= checkForNull(rs.getString("APPL_NO"));
				applicant_name			= checkForNull(rs.getString("APPLICANT_NAME"));
				cons_letter				= checkForNull(rs.getString("CONSENT_LETTER_APPL"));
				application_ref_no		= checkForNull(rs.getString("APPLICATION_REF_NO"));
				for_attn_of				= checkForNull(rs.getString("FOR_ATTN_OF"));
				report_type_code		= checkForNull(rs.getString("REPORT_TYPE_CODE"));
				specialty_code			= checkForNull(rs.getString("SPECIALTY_SHORT_DESC"));
				indicator				= checkForNull(rs.getString("indicator"));
				/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
				requestor_type_desc		= checkForNull(rs.getString("indicator_desc"));
				required_docs			= checkForNull(rs.getString("required_docs"));
				forwarded_pract_name	= checkForNull(rs.getString("FORWARDED_PRACT_NAME"));
				requesting_pract_name	= checkForNull(rs.getString("REQUESTING_PRACT_NAME"));
				forwarded_pract_id		= checkForNull(rs.getString("FORWARDED_PRACT_ID"));
				requesting_pract_id		= checkForNull(rs.getString("REQUESTING_PRACT_ID"));
				no_of_days				= checkForNull(rs.getString("no_of_days"));

				delivered_date			= checkForNull(rs.getString("DELIVERED_DATE"));
				if(!(delivered_date==null || delivered_date.equals("")))
					delivered_date_converted = DateUtils.convertDate(delivered_date,"DMYHM","en",locale);
				
				applSubmissionDate		= checkForNull(rs.getString("applSubmissionDate"));

				posted_date				= checkForNull(rs.getString("POSTED_DATE"));
				if(!(posted_date==null || posted_date.equals("")))
					posted_date_converted = DateUtils.convertDate(posted_date,"DMYHM","en",locale);
			
				
				dispatch_mode			= checkForNull(rs.getString("DISPATCH_MODE"));
					
				sec_file_no				= checkForNull(rs.getString("SEC_FILE_NO"));
				report_taken_by			= checkForNull(rs.getString("REPORT_TAKEN_BY"));
				rtb_national_id_no		= checkForNull(rs.getString("RTB_NATIONAL_ID_NO"));
				rtb_alt_id_type			= checkForNull(rs.getString("RTB_ALT_ID_TYPE"));
				rtb_alt_id__no			= checkForNull(rs.getString("RTB_ALT_ID__NO"));
			}
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
		}
	}catch(Exception e) 
	{
		//out.println("Exception in Query 2 : "+e);
		e.printStackTrace();
	}



	try
	{
		
		if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());
				
		//sqlBuff.append(" SELECT resi_addr_line1, resi_addr_line2, resi_addr_line3,resi_addr_line4, resi_postal_code, resi_country_code, mp_get_desc.MP_COUNTRY(resi_country_code,'"+locale+"','2') resi_Country_Name, res_area_code, mp_get_desc.MP_RES_AREA(res_area_code,'"+locale+"','2') res_Area_desc, res_town_code, mp_get_desc.MP_RES_TOWN(res_town_code,'"+locale+"','2') res_Town_desc, region_code, mp_get_desc.MP_REGION(region_code,'"+locale+"','1') Region_desc from MP_PAT_DTLS_VW WHERE patient_id = ? ");

		sqlBuff.append(" SELECT PAT_ADDR.PATIENT_ID , pat_addr.addr1_line1 resi_addr_line1, pat_addr.addr1_line2 resi_addr_line2, pat_addr.addr1_line3 resi_addr_line3, pat_addr.addr1_line4 resi_addr_line4, pat_addr.postal1_code resi_postal_code, pat_addr.country1_code resi_country_code, mp_get_desc.MP_COUNTRY(pat_addr.country1_code,'"+locale+"','1') resi_Country_Name, patient.res_area_code res_area_code, mp_get_desc.MP_RES_AREA(patient.res_area_code,'"+locale+"','1') res_Area_desc, patient.res_town_code res_town_code, mp_get_desc.MP_RES_TOWN(patient.res_town_code,'"+locale+"','2') res_Town_desc, patient.region_code region_code, mp_get_desc.MP_REGION(patient.region_code,'"+locale+"','1') Region_desc from MP_PATIENT PATIENT, MP_PAT_ADDRESSES PAT_ADDR WHERE PATIENT.PATIENT_ID = PAT_ADDR.PATIENT_ID AND PATIENT.patient_id = ? ");

		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();

		pstmt= con.prepareStatement(sqlBuff.toString());
		pstmt.setString(1,patientId);
		rs	= pstmt.executeQuery();

		if(rs.next() && rs != null)
		{
			addr_line1	= checkForNull(rs.getString("resi_addr_line1"));
			addr_line2	= checkForNull(rs.getString("resi_addr_line2"));
			addr_line3	= checkForNull(rs.getString("resi_addr_line3"));
			addr_line4	= checkForNull(rs.getString("resi_addr_line4"));

			res_town_code	= checkForNull(rs.getString("res_town_code"));
			res_town_desc	= checkForNull(rs.getString("res_town_desc"));
			
			res_area_code	= checkForNull(rs.getString("res_area_code"));
			res_area_desc	= checkForNull(rs.getString("res_area_desc"));

			region_code		= checkForNull(rs.getString("region_code"));
			region_desc		= checkForNull(rs.getString("region_desc"));

			postal_code = checkForNull(rs.getString("resi_postal_code")); 
			
			res_country_desc = checkForNull(rs.getString("resi_country_name")); 
			res_country_code = checkForNull(rs.getString("resi_country_code")); 


		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
	}catch(Exception e) 
	{
		//out.println("Exception in Query 5 : "+e);
		e.printStackTrace();
	}

	try
	{
		String contactSql=" SELECT nat_id_prompt, accept_national_id_no_yn, alt_id1_type, accept_oth_alt_id_yn FROM mp_param ";
		pstmt= con.prepareStatement(contactSql);
		rs	= pstmt.executeQuery();

		if(rs.next() && rs != null)
		{
			nat_id_prompt			= checkForNull(rs.getString("nat_id_prompt"));
			accept_national_id_no_yn= checkForNull(rs.getString("accept_national_id_no_yn"));
		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();

	}catch(Exception e) 
	{
		//out.println("Exception in Query 4 : "+e);
		e.printStackTrace();
	}
%>
<script>


// Added by Sridhar on 7 AUG 2004
// Function will check for empty values before calling up the common lookup func..
function beforeGetAuthorised(target_id,target)
{
	if(document.forms[0].Authorised_hid.value != document.forms[0].authorised_by.value)
	{
		if(document.forms[0].authorised_by.value != "")
			 getAuthoriser(target_id,target);
	}
}

async function getAuthoriser(target_id,target)
{
	var facility_id = document.forms[0].Facility_Id.value;
	var locale = document.forms[0].locale.value;
	var title="";
	
	var argumentArray=new Array(8);
	title = getLabel("Common.authorizedby.label","Common");
	argumentArray[0]="select Appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where language_id = '"+locale+"' and eff_status like ? and appl_user_id like upper(nvl(?,appl_user_id)) and upper(appl_user_name) like upper(nvl(?,appl_user_name)) ";

	argumentArray[1]=new Array("EFF_STATUS");
	argumentArray[2]=new Array("E");
	argumentArray[3]=new Array(STRING,STRING);
	argumentArray[4]="2,3";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;
	var retVal=await CommonLookup(title,argumentArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Authorised_hid.value	= arr[0];
		document.forms[0].authorised_by.value	= arr[1];
		document.forms[0].authorised_by.focus();
		document.forms[0].Authorised_hid.value	= document.forms[0].authorised_by.value;
	}
	else
	{
		document.forms[0].Authorised_hid.value	= "";		
		document.forms[0].authorised_by.value	= "";
	}
}

async function MedicalBoardFormation()
{
	var req_type		= "MB";
	var revise_stat		= "";
	var req_status		= "3";
	var call_func		= "MEDICAL_BOARD_FORMATION";
	var req_id			= document.forms[0].request_id.value;
	var pat_id			= document.forms[0].patientId.value;
	var called_from		= document.forms[0].called_from.value;
	var med_board_type	= document.forms[0].board_type.value;
	var dialogHeight	= "80vh";	
	var dialogWidth		= "80vw";		
	var dialogTop		= "10";
	var retVal			= new String();
	var center			= "1" ;
	var features		= " dialogHeight:"+dialogHeight+"; scroll=no; dialogWidth:"+dialogWidth+"; center:"+center+"; status=no; dialogTop:"+dialogTop;
	
	var arguments	= "" ;

	sretVal			= await top.window.showModalDialog("../../eMR/jsp/MedBoardRequestFormation.jsp?revise_stat="+revise_stat+"&call_function="+call_func+"&request_id="+req_id+"&PatientId="+pat_id+"&called_from="+called_from+"&med_board_type="+med_board_type+"&req_status="+req_status,arguments,features);
}


async function showDateDetails()
{
	var call_function	= document.forms[0].call_function.value;

	var retVal			= new String();
	var center			= "3" ;
	var dialogTop		= "0vh";
	var dialogHeight	= "39vh";
	var dialogWidth		= "40vw";
	var status			= "no";
	var arguments		= "" ;
	var features		= " dialogHeight:"+dialogHeight+"; scroll=no; dialogWidth:"+dialogWidth+"; center:"+center+"; status=no; dialogTop:"+dialogTop;

	retVal =await window.showModalDialog("../../eMR/jsp/ChargesDetails.jsp?toShow=DateDetails&call_function="+document.forms[0].call_function.value+"&PrepareDate="+document.forms[0].prepareDate.value+"&applCompletionDate="+document.forms[0].applCompletionDate.value+"&RequestDate="+document.forms[0].RequestDate.value+"&applSubmissionDate="+document.forms[0].applSubmissionDate.value+"&ReceivedDate="+document.forms[0].ReceivedDate.value+"&DeliveredDate="+document.forms[0].DeliveredDate.value,arguments,features);
}


async function showChargeDetails()
{
	var call_function	= document.forms[0].call_function.value;

	var retVal			= new String();
	var center			= "3" ;
	var dialogTop		= "0vh";
	var dialogHeight	= "39vh";
	var dialogWidth		= "40vw";
	var status			= "no";
	var arguments	= "" ;
	var features		= " dialogHeight:"+dialogHeight+"; scroll=no; dialogWidth:"+dialogWidth+"; center:"+center+"; status=no; dialogTop:"+dialogTop;

	retVal =await window.showModalDialog("../../eMR/jsp/ChargesDetails.jsp?toShow=ChargeDetails&call_function="+document.forms[0].call_function.value+"&charges_appl_yn="+document.forms[0].hdd_charges_appl_yn.value+"&addl_charges_yn="+document.forms[0].hdd_addl_charges_yn.value+"&receipt_no="+document.forms[0].hdd_receipt_no.value+"&addl_receipt_no="+document.forms[0].hdd_addl_receipt_no.value+"&amount="+document.forms[0].hdd_amount.value+"&addl_amount="+document.forms[0].hdd_addl_amount.value+"&receipt_date="+document.forms[0].hdd_receipt_date.value+"&addl_receipt_date="+document.forms[0].hdd_addl_receipt_date.value,arguments,features);
}

</script>

<!--Onload Added By Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
<body OnMouseDown='CodeArrest();' onSelect = "restrictMovement()" onKeyDown ='lockKey()' onload = 'RequestorTypeValueForBoard()'>
<form name='MedBoardReqDetailTabsForm' id='MedBoardReqDetailTabsForm'  method=post >
<table border="0" width="100%" cellspacing='0' cellpadding='2'>
<%	
	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
	{	%>
		<tr>
			<td colspan='2' class="white">
				<a name="tab1" tabindex='0'></a>  
				<ul id="tablist" class="tablist" style="padding-left:0px">
					<li class="tablistitem" title="Requestor Details">
						<a onclick="tab_click('requestor_details')" class="tabClicked" ><span class="tabSpanclicked" ><fmt:message key="eMR.RequestorDetails.label" bundle="${mr_labels}"/></span></a>
					</li>
					<li class="tablistitem" title="Other Details">
						<a onclick="tab_click('other_details')" class="tabA" ><span class="tabAspan" ><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span></a>
					</li>
				</ul>
			</td>
			<td colspan='2' class="white">&nbsp;</td>
		</tr>
<%	}	%>

<%	if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
	{	%>
	<tr align="left">
		<th class="columnheader" align="left" colspan="4"><fmt:message key="Common.RequestDetails.label" bundle="${common_labels}"/></th>
	</tr>
<%	}	%>
	<tr>
		<td  width="20%"  class='label'><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
		<td  width="20%"  class='fields' ><input type=text name="reg_no" id="reg_no" size=15 maxlength=15 readonly value="<%=request_id%>" ></td>
		<td  width="15%"  class='label'><fmt:message key="Common.regndatetime.label" bundle="${common_labels}"/></td>

	<%	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	%>
		<td  width="40%" class='querydata' ><%=SystemDate_display%></td>
	<%	}else{	%>
		<td  width="40%" class='querydata' ><%=reqDate_converted%></td>
	<%	}	%>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="eMR.ApplicationType.label" bundle="${mr_labels}"/></td>	
		<td class='fields'><select name="appl_type" id="appl_type" <%=disabled%> >
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
		<%
		if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
			appl_typeStmt = con.createStatement();
			appl_typeRS = appl_typeStmt.executeQuery(" select appl_type_code, short_desc from MR_APPL_TYPE_LANG_VW where eff_status = 'E' and language_id='"+locale+"' order by short_desc ");

			if(appl_typeRS!=null)
			{
				sel="";
				while(appl_typeRS.next())
				{
					data = appl_typeRS.getString("SHORT_DESC");
					code = appl_typeRS.getString("APPL_TYPE_CODE");
					if(appl_type_code.equals(code))
						sel = "selected";
					else
						sel="";

					out.println("<option value='"+code+"' "+sel+">"+data+"</option>");
				}
			}	
			if(appl_typeRS != null)appl_typeRS.close();
			if(appl_typeStmt != null)appl_typeStmt.close();
		}
		else
		{
			if(!appl_type_code.equals(""))
				out.println("<option value='"+appl_type_code+"' selected>"+appl_type_desc+"</option>");
		}
	%>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		<td class="label"  ><fmt:message key="eMR.LetterDateTime.label" bundle="${mr_labels}"/></td>
		<td class='fields'>
		<!-- Below line is commented by Akhilesh because unnecessary function is calling -->
		<!--<input type="text" id='applnDt' name="appln_date" id="appln_date" maxlength=16 size=16 onblur='validDateObj(this,"DMYHM","<%=locale%>");CompareRegnDate(this,document.forms[0].sysdate);' onKeyPress="return(ChkDateNumberInput(this,event,2))" value="<%=SystemDate_display%>"> -->

		<input type="text" id='applnDt' name="appln_date" id="appln_date" maxlength=16 size=16 onblur='CompareRegnDate(this,document.forms[0].sysdate);' onKeyPress="return(ChkDateNumberInput(this,event,2))" value="<%=SystemDate_display%>"><img id="ApplnImg" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].appln_date.focus();return showCalendar('applnDt',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif'align='center'  style="visibility:visible"></img></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="eMR.ApplicantName.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type=text name="appl_name" id="appl_name" size=30 maxlength=80 <%=disabled%>  value="<%=applicant_name%>" ></td>
		<td  class='label'><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type=text name="appl_refno" id="appl_refno" size=15 maxlength=15 <%=disabled%>  value="<%=application_ref_no%>" onKeyPress='return(ChkNumberInput(this,event,0))'></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.RelationshipType.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name="relationship_type" id="relationship_type" onchange="populateApplName(this.value);enDisRequestor(this.value);popApplAddress(this.value)" <%=disabled%> >
		<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<option value='0'><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
		<option value='1'><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></option>
		<option value='2'><fmt:message key="Common.employer.label" bundle="${common_labels}"/></option>
		<option value='3'><fmt:message key="Common.self.label" bundle="${common_labels}"/></option>
		<option value='4'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		</select></td>
	<%	
		if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
		{
			if(relationship_type.equals(""))
			out.println("<script>document.getElementById('relationship_type').options[0].selected=true;</script>");
			else if(relationship_type.equals("0"))
			out.println("<script>document.getElementById('relationship_type').options[1].selected=true;</script>");	
			else if(relationship_type.equals("1"))
			out.println("<script>document.getElementById('relationship_type').options[2].selected=true;</script>");
			else if(relationship_type.equals("2"))
			out.println("<script>document.getElementById('relationship_type').options[3].selected=true;</script>");
			else if(relationship_type.equals("3"))
			out.println("<script>document.getElementById('relationship_type').options[4].selected=true;</script>");
			else if(relationship_type.equals("4"))
			out.println("<script>document.getElementById('relationship_type').options[5].selected=true;</script>");
		}	%>

		<td  class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name='relationship' id='relationship' <%=disabled%> >
		<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<%
		if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{
			String rel_sel ="";                                     
			String rel_data ="";                                     
			String rel_code ="";    
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			String rel_sql = " select relationship_code, short_desc from MP_RELATIONSHIP_LANG_VW where language_id='"+locale+"' and eff_status='E' order by short_desc ";

			pstmt = con.prepareStatement(rel_sql);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					rel_data = rs.getString("SHORT_DESC");
					rel_code = rs.getString("relationship_code");
					if(relationship_code.equals(rel_code))
					rel_sel = "selected";
					else
					rel_sel="";

					out.println("<option value='"+rel_code+"' "+rel_sel+">"+rel_data+"</option>");
				}
			}	
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}
		else
		{
			if(!relationship_code.equals(""))
				out.println("<option value='"+relationship_code+"' selected>"+relationship_desc+"</option>");
		}	%>
		</select><img src='../../eCommon/images/mandatory.gif' align='center' id="relationImg" style="visibility:hidden" ></img></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="eMR.RequestorType.label" bundle="${mr_labels}"/></td>
		<td class='fields'><select name="req_type" id="req_type" <%=disabled%> onchange="document.forms[0].requestor_desc.value='';document.forms[0].Requestor_Code.value='';EnDisRelation(this.value);">
		<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
		<%
				JSONArray RequestorTypeJsonArr = new JSONArray();
				RequestorTypeJsonArr  = eMR.MRCommonBean.getRequestorTypeForRequestor(con);

				for(int i = 0 ; i < RequestorTypeJsonArr.size() ; i++) 
				{
					JSONObject json	= (JSONObject)RequestorTypeJsonArr.get(i);
					String requestor_type_code  = (String) json.get("requestor_type_code");
					String long_desc  = (String) json.get("long_desc");
					out.println("<option value='"+requestor_type_code+ "'>"+long_desc+"</option>");	
				}		
		%>
		</select>
		</td> 

		<td class='label'><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type=text name="requestor_desc" id="requestor_desc" size=15 maxlength=15 onblur="beforeLookupSearch()" <%=disabled%>  value="<%=requestor_desc%>" ><input type=button class=button name='search_Requestor' id='search_Requestor' value='?' onclick="LookupSearch()" <%=disabled%>><input type=hidden name="Requestor_desc_hid" id="Requestor_desc_hid" value=''><input type=hidden name="Requestor_Code" id="Requestor_Code" value=""><img src='../../eCommon/images/mandatory.gif' align='center' id="requestorImg" style="visibility:hidden" ></img></td>	
	</tr>
	<tr>
		<td  class='label'><fmt:message key="eMR.ConsentLetter.label" bundle="${mr_labels}"/></td>
		<td class='fields'>
		<SELECT name="cons_letter" id="cons_letter" <%=disabled%>>
		<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<option value='0'><fmt:message key="Common.available.label" bundle="${common_labels}"/></option>
		<option value='1'><fmt:message key="Common.notavailable.label" bundle="${common_labels}"/></option>
		<option value='2'><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
		</SELECT>
		</td>
	<%
		if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
			if(cons_letter.equals(""))
			out.println("<script>document.getElementById('cons_letter').options[0].selected=true;</script>");
			if(cons_letter.equals("0"))
			out.println("<script>document.getElementById('cons_letter').options[1].selected=true;</script>");
			else if(cons_letter.equals("1"))
			out.println("<script>document.getElementById('cons_letter').options[2].selected=true;</script>");
			else if(cons_letter.equals("2"))
			out.println("<script>document.getElementById('cons_letter').options[3].selected=true;</script>");
		}	
		if(call_function.equals("MEDICAL_BOARD_STATUS"))
			out.println("<script>document.getElementById('cons_letter').disabled=false;</script>");
	%>

		<td class='label'><fmt:message key="eMR.Attentionto.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type=text name="for_attn" id="for_attn" size=25 maxlength=50 <%=disabled%>  value="<%=for_attn_of%>" ></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="eMR.TypeofMedicalBoard.label" bundle="${mr_labels}"/></td>
		<td  class='fields'><select name="board_type" id="board_type" onblur="tab_click('requestor_details')" <%=disabled%> ><option value='' >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----<%	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{			
			String board_data = "";
			String board_code = "";
			String board_sel = "";
			board_typeStmt = con.createStatement();
			board_typeRS = board_typeStmt.executeQuery(" select med_board_type_code, short_desc from MR_MEDICAL_BOARD_TYPE_LANG_VW where language_id = '"+locale+"' and eff_status = 'E' order by 2 ");
			if(board_typeRS != null)
			{
				sel="";
				while(board_typeRS.next())
				{
					board_data = board_typeRS.getString("short_desc");
					board_code = board_typeRS.getString("med_board_type_code");
					if(med_board_type_code.equals(board_code))
						board_sel = "selected" ;
					out.println("<option value='"+board_code+"' "+board_sel+">"+board_data+"</option>");
				}
			}	
			if(board_typeRS != null) board_typeRS.close();
			if(board_typeStmt != null) board_typeStmt.close();
		}
		else
		{	
			out.println("<option value='"+med_board_type_code+"' selected>"+med_board_short_desc+"</option>");
		}	%>
		
		</select><img src='../../eCommon/images/mandatory.gif'align='center'  style="visibility:visible"></img>
		<td  class='label'><fmt:message key="eMR.ApplicationNo.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type=text name="appl_no" id="appl_no" size=15 maxlength=15 <%=disabled%>  value="<%=appl_no%>" onKeyPress='return(ChkNumberInput(this,event,0))'></td>
	</tr>

<%	if(!call_function.equals("MEDICAL_BOARD_REQUEST") && !call_function.equals("MEDICAL_BOARD_STATUS"))
	{	%>
	<tr>	
		<td class='label'>&nbsp;</td>
		<td class='button'><input type="button" name="Dates" id="Dates" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DateDetails.label","mr_labels")%>" class='button' onclick="showDateDetails();" ></td>
		<td class='button'><input type="button" name="Charges" id="Charges" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ChargesDetails.label","mr_labels")%>" class='button' onclick="showChargeDetails();" ></td>
		<td class='button'><input type="button" name="appl_addr" id="appl_addr" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicantAddress.label","mr_labels")%>" class='button' onclick="DisplayApplAddress(relationship_type.value);" onblur="tab_click('requestor_details')" disabled></td>
	</tr>
<%	}else{	%>
		<tr>	
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class='button'><input type="button" name="appl_addr" id="appl_addr" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicantAddress.label","mr_labels")%>" class='button' onclick="DisplayApplAddress(relationship_type.value);" onblur="tab_click('requestor_details')" disabled></td>
		</tr>
	<%	}	%>
	<%	if(call_function.equals("MEDICAL_BOARD_STATUS"))
	{	%>
		<tr align="left">
			<th class="columnheader" colspan="4"><fmt:message key="Common.Charges.label" bundle="${common_labels}"/></th>
		</tr>
		<tr>
			<td width="20%" class='label'><fmt:message key="eMR.ChargesApplicable.label" bundle="${mr_labels}"/></td>
			<td width="25%" class='fields'><select name="charges_appllicable" id="charges_appllicable" onchange="enableOtherDetails(this.name,this.value)">
			<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
			<option value='N' selected><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg1"></td>
			<td width="30%" class='label'><fmt:message key="eMR.AdditionalCharges.label" bundle="${mr_labels}"/></td>
			<td width="25%" class='fields'><select name="additional_charges" id="additional_charges" onchange="enableOtherDetails(this.name,this.value)">
			<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
			<option value='N' selected><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif'align='center'  style="visibility:hidden" id="addtlChargeImg1" ></img></td>
		</tr>
		<tr>
			<td class='label'><fmt:message key="Common.receiptno.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text name=recp_no size=15 maxlength=15 disabled value="<%=receipt_no%>" onblur="populateRecptDate(this.value,document.forms[0].recp_dat,document.getElementById(\"recp_dat_img\"));"><img src='../../eCommon/images/mandatory.gif' align='center' style="visibility:hidden" id="chargeImg2" ></td>
			<td class='label'><fmt:message key="Common.receiptno.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text name=add_recp_no size=15 maxlength=15 disabled value="<%=addl_receipt_no%>" onblur="populateRecptDate(this.value,document.forms[0].add_recp_dat,document.getElementById("add_recp_dat_img"));"><img src='../../eCommon/images/mandatory.gif'align='center'  style="visibility:hidden" id="addtlChargeImg2" ></img></td>
		</tr>
		<tr>
			<td  class='label'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text name=amount size=15 maxlength=15  disabled value="<%=amount%>" onKeyPress="return(ChkDateNumberInput(this,event,2))" onBlur="CheckZeroVal(this);CheckNumberFormat(this);"><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg3"></td>
			<td class='label'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text name=add_amount size=15 maxlength=15 disabled value="<%=addl_amount%>" onKeyPress="return(ChkDateNumberInput(this,event,2))" onBlur="CheckZeroVal(this);CheckNumberFormat(this);"><img src='../../eCommon/images/mandatory.gif'align='center'  style="visibility:hidden" id="addtlChargeImg3" ></img></td>
		</tr>
		<tr>
			<td  class='label'><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text id='recpid' name=recp_dat size=16 maxlength=16 onblur="recptDateValidations(this,document.forms[0].request_date,document.forms[0].sysdate)" disabled value="<%=receipt_date_converted%>" ><img disabled src="../../eCommon/images/CommonCalendar.gif" id="recp_dat_img" onClick="document.forms[0].recp_dat.focus();return showCalendar('recpid',null,'hh:mm');" disabled/><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg4"></td>
			<td class='label'><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text id='addrecpid' name=add_recp_dat size=16 maxlength=16 disabled value="<%=addl_receipt_date_converted%>" onblur="recptDateValidations(this,document.forms[0].request_date,document.forms[0].sysdate)" ><img disabled src="../../eCommon/images/CommonCalendar.gif" id="add_recp_dat_img" onClick="document.forms[0].add_recp_dat.focus();return showCalendar('addrecpid',null,'hh:mm');" <%=disabled%>/><img src='../../eCommon/images/mandatory.gif'align='center'  style="visibility:hidden" id="addtlChargeImg4" ></img></td>
		</tr>
		<script>
			document.forms[0].charges_appllicable.value = "<%=charges_appl_yn%>";
			document.forms[0].additional_charges.value = "<%=addl_charges_yn%>";

			if(document.forms[0].charges_appllicable.value == "Y")
			{
				if("<%=medrep_pay_int_mode%>" == "X")
				{
					document.forms[0].amount.disabled = false;
					document.forms[0].recp_no.disabled = false;
					document.forms[0].recp_dat.disabled = false;
					document.getElementById("recp_dat_img").disabled = false;
				}
				else if("<%=medrep_pay_int_mode%>" == "B")
				{
					document.forms[0].amount.disabled = false;
				}
			}

		if(document.forms[0].additional_charges.value == "Y")
		{
			if("<%=medrep_pay_int_mode%>" == "X")
			{
				document.forms[0].add_amount.disabled = false;
				document.forms[0].add_recp_no.disabled = false;
				document.forms[0].add_recp_dat.disabled = false;
				document.getElementById("add_recp_dat_img").disabled = false;
			}
			else if("<%=medrep_pay_int_mode%>" == "B")
			{
				document.forms[0].add_amount.disabled = false;
			}
		}
		</script>
		</tr>
	<%	}	%>
	<tr>
		<th class="columnheader" colspan="4">&nbsp;</th>
	</tr>
	<%
	if(!call_function.equals("MEDICAL_BOARD_STATUS") && !call_function.equals("MEDICAL_BOARD_REQUEST"))
	{	%>
		<tr>
			<td class='label' width="20%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td>
			<td class='fields' width="25%"><SELECT name="rep_type" id="rep_type" <%=dis%> >
			<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
			if(ca_install_yn.equals("Y"))
			{	
			Statement stm = null;
			ResultSet rss = null;
			String repType_sel = "";
			try
			{
			String sqlrep = " select note_type, note_type_desc from CA_NOTE_TYPE_LANG_VW where note_group_id in (select note_group from CA_NOTE_GROUP where appl_task_id = 'PRE_MEDICAL_BOARD') and EFF_STATUS = 'E' and language_id ='"+locale+"' order by NOTE_TYPE_DESC ";
			stm = con.createStatement();
			rss = stm.executeQuery(sqlrep);
			if(rss!=null)
			{
			while(rss.next())
			{
			String repcode = rss.getString("NOTE_TYPE");
			String repdesc = rss.getString("NOTE_TYPE_DESC");

			if(report_type_code.equals(repcode))
			repType_sel = "selected";
			else
			repType_sel="";

			out.println("<option value='"+repcode+"' "+repType_sel+">"+repdesc+"</option>");
			}
			}
			}
			catch(Exception e)
			{
			//out.println("Exception in rep_type : "+e.toString());
			e.printStackTrace();
			}
			finally
			{
			if(rss!=null) rss.close();
			if(stm!=null) stm.close();
			}
			}
			%>
			</SELECT><img src='../../eCommon/images/mandatory.gif'  id='ReportTypeImg' align='center'></img></td>
			<td width="30%" class='label' ><fmt:message key="eMR.DepartmentSpecialty.label" bundle="${mr_labels}"/></td>
			<td width="25%" class='fields'><input type=text name="dept_spl" id="dept_spl" size=15 maxlength=15 <%=dis%>  value="<%=specialty_code%>" onblur="BeforeGetSpecialtyValue(this, '<%=Facility_Id%>');" ><input type=hidden class=label name="Splcode" id="Splcode" ><input type=button class=button name='search_spl' id='search_spl' value='?' onclick="getSpecialtyValue(dept_spl, '<%=Facility_Id%>')" <%=dis%> ><img src='../../eCommon/images/mandatory.gif' id='DeptImg' align='center'></img></td>
		</tr>

	<%	if(new_func_id.equals("APP_FOR_MED_BOARD"))
		{	%>
			<tr>
				<td class='label' width="20%"><fmt:message key="eMR.MedicalBoardMembers.label" bundle="${mr_labels}"/></td>
				<td class='fields' colspan="3" ><textarea name='MedicalMembers' rows=2 cols='60' onblur= "makeValidString(this);chklim(this,200)" <%=disabled%>  value="" ></textarea></td>
			</tr>
	<%	}	%>
		<tr>
			<td class='label' width="20%" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td colspan="3" class='fields'><textarea name='remarks' rows=2 cols='60' onblur="makeValidString(this);chklim(this,200);"  ><%=remarks%></textarea></td>
		</tr>
	<%	}

	if(call_function.equals("FORWARD_MEDICAL_BOARD"))
	{	%>
		<tr>
			<td class='label'  ><fmt:message key="eMR.ApplnSubDate.label" bundle="${mr_labels}"/></td>
			<td nowrap class='querydata' ><%=SystemDate_display%><input type='hidden' name='appl_sub_dt' id='appl_sub_dt' value="<%=SystemDate%>"></td>
			<td  class='label' ><fmt:message key="eMR.ForwardedPractitioner.label" bundle="${mr_labels}"/></td>
			<td  class='fields'><SELECT name="fwd_pract_desc" id="fwd_pract_desc" <%=dis%> >
			<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
			if(rs !=null) rs.close();
			String pract_sel = "";
			try
			{
				String Pract_Sql = " select b.practitioner_name, a.practitioner_id FROM MR_MED_BOARD_MEMBER a, AM_PRACTITIONER_LANG_VW b WHERE a.facility_id =? AND a.practitioner_id = b.practitioner_id and a.request_id=? and b.language_id =?";
				//stmt = con.createStatement();
				pstmt1 = con.prepareStatement(Pract_Sql);
				pstmt1.setString(1,Facility_Id);
				pstmt1.setString(2,request_id);
				pstmt1.setString(3,locale);
				rs = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						String practcode = rs.getString("practitioner_id");
						String practdesc = rs.getString("practitioner_name");

						if(requesting_pract_id.equals(practcode))
							pract_sel = "selected";
						else
							pract_sel="";

						out.println("<option value='"+practcode+"' "+pract_sel+">"+practdesc+"</option>");
					}
				}
			}
			catch(Exception e)
			{
				//out.println("Exception in Forwarded Pract : "+e.toString());
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt1!=null) pstmt1.close();
			}
			%></select><img src='../../eCommon/images/mandatory.gif'  id='fwd_practitionerImg' align='center'></img></td>
		</tr>
		<%	
		for(int j=0;j<10;j++)
		{
			out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
		}
	}	

	if(!call_function.equals("MEDICAL_BOARD_STATUS") && !call_function.equals("FORWARD_MEDICAL_BOARD") && !call_function.equals("PREPARE_MEDICAL_BOARD") && !call_function.equals("RECEIVE_MEDICAL_BOARD") && !call_function.equals("MEDICAL_BOARD_INT_APPT") && !call_function.equals("DELIVER_MEDICAL_BOARD") && !call_function.equals("MEDICAL_BOARD_COMPLETED") && !call_function.equals("REVISE_MEDICAL_BOARD") )
	{	
		for(int j=0;j<10;j++)
		{	
			out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
		}
	}		%>

	<%	if(call_function.equals("MEDICAL_BOARD_STATUS"))
	{	%>
		<tr>
			<td  class='label' width="20%"><fmt:message key="eMR.ApplicationStatus.label" bundle="${mr_labels}"/></td>
			<td  class='fields' width="25%"><select name="appl_status" id="appl_status" onchange="setDate(this.value)">
			<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<option value='2'><fmt:message key="Common.complete.label" bundle="${common_labels}"/></option>
			<option value='1'><fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif'  id='appln_status_Img' align='center'></img></td><td id='appln_col1' class='label'  width="30%"></td><td class='querydata' id='appln_col2' width="25%"><input type=hidden id='applcompdat' name="appl_comp_dat" id="appl_comp_dat" size=15 maxlength=15 value="<%=SystemDate%>"></td>
		</tr>
		<tr>
			<td class="label"  nowrap><fmt:message key="eMR.CollectDate.label" bundle="${mr_labels}"/></td>
			<td class='fields'>
			<!-- Below line is commented by Akhilesh because unnecessary function is calling -->
			<!--<input type="text" id='collectDt' name="collect_date" id="collect_date" maxlength=16 size=16 disabled onblur ='validDateObj(this,"DMYHM","<%=locale%>");CompareSysDate(this,document.forms[0].sysdate);' value ="" onKeyPress="return(ChkDateNumberInput(this,event,2))">-->
			<input type="text" id='collectDt' name="collect_date" id="collect_date" maxlength=16 size=16 disabled onblur ='CompareSysDate(this,document.forms[0].sysdate);' value ="" onKeyPress="return(ChkDateNumberInput(this,event,2))">
			<img id='collect_img' src="../../eCommon/images/CommonCalendar.gif" disabled  onClick="document.forms[0].collect_date.focus();return showCalendar('collectDt',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif' align='center' id="collectImg" style="visibility:hidden"></img></td>		
		<%	if(!call_function.equals("MEDICAL_BOARD_STATUS"))
			{	%>
			<td  class='label'><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/></td>
			<td class='fields'><input type='text' name='pract_desc' id='pract_desc' size='30' maxlength='30' onblur='BeforeGetPractitioner();' value="<%=requesting_pract_name%>" ><input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=requesting_pract_id%>"><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick='getPractID(this);' ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<%	}else{	%>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		<%	}	%>
		</tr>
		<tr>
			<td class='label'  ><fmt:message key="eMR.RequiredDocuments.label" bundle="${mr_labels}"/></td>
			<td class='fields' colspan="3"><textarea name='reqd_docs' rows=2 cols='60' onblur="makeValidString(this);chklim(this,200);tab_click('other_details');"  ><%=required_docs%></textarea></td>
		</tr>
		<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='button'><input type=button class="button" name="Formation_but" id="Formation_but" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FormationofMedicalBoard.label","mr_labels")%>" onClick="MedicalBoardFormation()"></td>
		</tr>	
		<%
			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label'colspan=4>&nbsp;</td></tr>");
			}
		}	

	/////////////////////////////// DISPLAY ONLY ////////////////////////
		if(call_function.equals("PREPARE_MEDICAL_BOARD") || 
		call_function.equals("RECEIVE_MEDICAL_BOARD") || call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED") ||
		call_function.equals("REVISE_MEDICAL_BOARD") || call_function.equals("QUERY_DELAY_IN_MRR") || call_function.equals("MEDICAL_BOARD_INT_APPT"))
		{	%>
			<tr>
			<td class="label" width="20%" ><fmt:message key="eMR.CollectDate.label" bundle="${mr_labels}"/></td>
			<td class='fields' width="25%"><input type="text" name="disp_col_date" id="disp_col_date" maxlength=16 size=16 value ="<%=CollectDate_Converted%>" disabled ><img src="../../eCommon/images/CommonCalendar.gif" disabled/></td>
		<%	if(!revised_collect_date.equals(""))
			{	%>
			<td class=label width="30%"><fmt:message key="eMR.RevisedCollectDate.label" bundle="${mr_labels}"/></td>
			<TD class='querydata' width="25%"><%=revised_collect_date_converted%></td>
		<%	}else{	%>
			<td class=label width="30%">&nbsp;</td>
			<td class=label width="25%">&nbsp;</td>
	<%	}	%>
		</tr>
	<%	}
		
		if(call_function.equals("PREPARE_MEDICAL_BOARD"))
		{	%>
			<tr>
				<td  class='label' ><fmt:message key="eMR.ForwardedPractitioner.label" bundle="${mr_labels}"/></td>
				<td class=querydata ><%=forwarded_pract_name%><input type='hidden' name='disp_prep_pract_desc' id='disp_prep_pract_desc' value="<%=forwarded_pract_name%>" ></td>
				<td class=label >&nbsp;</td>
				<td class=label >&nbsp;</td>
			</tr>
			<tr>
				<td class="label"  ><fmt:message key="Common.PrepareDate.label" bundle="${common_labels}"/></td>
				<td class='fields'>
				<!--Below line is commented by Akhilesh because unnecessary function is calling.-->
				<!--<input type="text" id='prepareDt' name="prepare_date" id="prepare_date" maxlength=16 size=16 onblur='validDateObj(this,"DMYHM","<%=locale%>");CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);' value ="<%=SystemDate_display%>" onKeyPress="return(ChkDateNumberInput(this,event,2))">-->
				<input type="text" id='prepareDt' name="prepare_date" id="prepare_date" maxlength=16 size=16 onblur='CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);' value ="<%=SystemDate_display%>" onKeyPress="return(ChkDateNumberInput(this,event,2))">
				<img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].prepare_date.focus();return showCalendar('prepareDt',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif'  id='prepare_date_Img' align='center'></img></td>
				<td  class='label' ><fmt:message key="eMR.PreparedbyPractitioner.label" bundle="${mr_labels}"/></td>
				<td class='fields'><input type='text' name='prep_pract_desc' id='prep_pract_desc' size='30' maxlength='30' onblur='BeforePrepGetPractitioner();' value="<%=forwarded_pract_name%>" ><input type='hidden' name='prep_practitioner_id' id='prep_practitioner_id' value="<%=forwarded_pract_id%>" ><input type='button' name='prep_pract_id_search' id='prep_pract_id_search' value='?' class='button' onClick='getPractID(this);' ><img src='../../eCommon/images/mandatory.gif'  id='prep_pract_desc_Img' align='center'></img></td>
			</tr>
		<%	for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}
		}
		else if(call_function.equals("RECEIVE_MEDICAL_BOARD")) 
		{	%>
			<tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td  class='label'><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/></td>
				<td class='QueryData' ><%=requesting_pract_name%></td>
			</tr>
			<tr>
				<td class="label"  nowrap><fmt:message key="eMR.ReportPreparedDate.label" bundle="${mr_labels}"/></td>
				<td class='querydata' ><%=prepareDate_converted%></td>
				<td class="label"  nowrap><fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" id='ReceiveDt' name="receive_date" id="receive_date" maxlength=16 size=16 onblur ='chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);' value ="" onKeyPress="return(ChkDateNumberInput(this,event,2))" ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].receive_date.focus();return showCalendar('ReceiveDt',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif'  id='receive_date_Img' align='center'></img></td>
			</tr>
			<tr>
				<td class="label"  nowrap><fmt:message key="eMR.DaystoComplete.label" bundle="${mr_labels}"/></td>
				<td class='querydata' ><%=no_of_days%></td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
			</tr>
			<%	
			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}	
		}else if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED") || call_function.equals("MEDICAL_BOARD_INT_APPT"))
		{	
			if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	%>
				<tr>
					<td class="label"  nowrap><fmt:message key="Common.PrepareDate.label" bundle="${common_labels}"/></td>
					<TD class='querydata' ><%=prepareDate_converted%></td>
					<td class="label"  nowrap><fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/></td>
					<TD class='querydata' ><%=RecdDate_converted%></td>
				</tr>
		<%	}	%>
		<%	if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	%>
				<tr>
					<td class="label"  nowrap><fmt:message key="eMR.DeliveredDate.label" bundle="${mr_labels}"/></td>
					<td class='fields'><input type="text" id='deliveredDt' name="delivered_date" id="delivered_date" maxlength=16 size=16 onblur ='chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);' value ="<%=delivered_date_converted%>" onKeyPress="return(ChkDateNumberInput(this,event,2))" ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].delivered_date.focus();return showCalendar('deliveredDt',null,'hh:mm');" id="del_img"/><img src='../../eCommon/images/mandatory.gif' id='delivered_date_Img' align='center'></img></td>
					<td class=label >&nbsp;</td>
					<td class=label >&nbsp;</td>
				</tr>
		<%	}	%>

	<%	if(call_function.equals("MEDICAL_BOARD_INT_APPT"))
		{	%>
			<tr>
				<td  class='label' ><fmt:message key="eMR.ForwardedPractitioner.label" bundle="${mr_labels}"/> </td>
				<td class=queryData ><%=forwarded_pract_name%></td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
			</tr>
	<%	}	%>
			<tr>
		<%	if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	%>
				<td class='label' nowrap ><fmt:message key="eMR.DeliverMode.label" bundle="${mr_labels}"/></td>
		<%	}
			else
			{	%>
				<td class="label"  nowrap ><fmt:message key="eMR.IntimationMode.label" bundle="${mr_labels}"/></td>
		<%	}	%>
				<td class='fields'><select name="Despatch_mode" id="Despatch_mode" onchange="enableDisableObjs(this.value)" onblur="tab_click('other_details');">
				<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
				<option value='P'><fmt:message key="Common.Personal.label" bundle="${common_labels}"/></option>
				<option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
				</select>
				<script>document.forms[0].Despatch_mode.value = "<%=dispatch_mode%>";</script>
				</td>
				<td  class='label' nowrap><fmt:message key="eMR.DatePosted.label" bundle="${mr_labels}"/></td>
				<td class='fields'><input disabled type="text" id='postedDt' name="posted_date" id="posted_date" maxlength=16 size=16 onblur='chkDateVal(this);' onKeyPress="return(ChkDateNumberInput(this,event,2))" value="<%=posted_date_converted%>"><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].posted_date.focus();return showCalendar('postedDt',null,'hh:mm');" id='postImg' disabled/></td>
			</tr>
		<%	
			
			if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	
			%>
			<tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='button'><input class=button type="button" name="address" id="address" value="Delivery/Dispatch Add" disabled onclick="popAddress();"></td>
			</tr>
		<%	
					
			}
			else
			{	%>
			<tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='button'><input class=button type="button" name="address" id="address" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Address.label","common_labels")%>' disabled onclick="popAddress();"></td>
			</tr>
		<%	}	%>
			<tr>
				<td class='label'><fmt:message key="eMR.SectionFileNo.label" bundle="${mr_labels}"/></td>
				<td class='fields'><input type=text name="file_no" id="file_no" size='20' maxlength="20" value="<%=sec_file_no%>"  disabled onKeyPress='return(ChkNumberInput(this,event,0))' onblur="tab_click('other_details')"></td>
		<%	if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	%>
				<td  class='label' nowrap><fmt:message key="eMR.ReportTakenBy.label" bundle="${mr_labels}"/></td>
		<%	}
			else
			{	%>
				<td  class='label'><fmt:message key="eMR.IntimatedTo.label" bundle="${mr_labels}"/></td>
		<%	}	%>
				<td class='fields'><input type=text name="report_taken" id="report_taken" size='20'   value="<%=report_taken_by%>"  maxlength="30" disabled ></td>
			</tr>
			<tr>
	<%	if(accept_national_id_no_yn.equals("Y"))
		{	%>
			<td  class='label'><%=nat_id_prompt%></td>
			<td class='fields'><input type=text name="del_nric_no" id="del_nric_no" size="20" maxlength="20" value="<%=rtb_national_id_no%>"  onBlur="CheckNumberFormat(this);" onKeyPress='return(ChkNumberInput(this,event,0))' disabled ></td>
	<%	}else{	%>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
	<%	}	%>

			<td  class='label' nowrap><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
			<td  class='fields'><select name="del_oth_alt_type" id="del_oth_alt_type" Disabled onchange='if(this.value!=""){document.forms[0].del_oth_alt_id.value = "";document.forms[0].del_oth_alt_id.disabled=false;}else{document.forms[0].del_oth_alt_id.value = "";document.forms[0].del_oth_alt_id.disabled=true}'> 
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
		<%
			String altIDsql = "select alt_id_type, short_desc from MP_ALTERNATE_ID_TYPE_LANG_VW where alt_id_type not in (select alt_id1_type from MP_PARAM union select nvl(alt_id2_type,1) from MP_PARAM union select nvl(alt_id3_type,2) from MP_PARAM union select nvl(alt_id4_type,3) from MP_PARAM ) and eff_status='E' and language_id ='"+locale+"' order by 2 ";

			oth_stmt = con.createStatement();
			oth_rset = oth_stmt.executeQuery(altIDsql);	
			if(oth_rset != null)
			{
				while (oth_rset.next())
				{
					out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
				}
			}

			if(oth_rset != null) oth_rset.close();
			if(oth_stmt != null) oth_stmt.close();
			%>					  
			<script>
				document.forms[0].del_oth_alt_type.value="<%=rtb_alt_id_type%>";
			</script>
			</select>
		</tr>
		<tr>
			<td  class='label'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>	
			<td  class='fields'><input type=text name="del_oth_alt_id" id="del_oth_alt_id" size='20' maxlength="20"  value="<%=rtb_alt_id__no%>" disabled onblur="tab_click('other_details');validateSplchars(this)" ></td>	<td class=label >&nbsp;</td>
			<td class=label >&nbsp;</td>
		</tr>
			<%
			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}
		}	 
		if(call_function.equals("REVISE_MEDICAL_BOARD"))
		{	%>  
				<tr>
				<td class="label"  nowrap><fmt:message key="eMR.RevisedCollectDate.label" bundle="${mr_labels}"/></td>
				<td class='fields' ><input type="text" id='RevisedCollectdDt' name="revised_collect_date" id="revised_collect_date" maxlength=16 size=16 onblur='chkDateVal(this);validateDate(this);' value ="" onKeyPress="return(ChkDateNumberInput(this,event,2))" ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].revised_collect_date.focus();return showCalendar('RevisedCollectdDt',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				<td class="label"  ><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
				<td class='fields' ><input type="text" name="authorised_by" id="authorised_by" maxlength=16 size=16 value="" onBlur='beforeGetAuthorised(document.forms[0].Authorised_hid,this);'><input type=button class=button name='search_Authorised' id='search_Authorised' value='?' onclick="getAuthoriser(document.forms[0].Authorised_hid,document.forms[0].authorised_by)"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				<input type=hidden name="Authorised_hid" id="Authorised_hid" value=''>
			</tr>
			<%
			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}
		}	%>

	<%	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	%>
			<tr>
				<td colspan='2' class="white">
					<a name="tab3" id="tab3" tabindex='0' ></a>
					<ul id="tablist" class="tablist" style="padding-left:0px">
						<li class="tablistitem" title="Requestor Details">
							<a onclick="tab_click('requestor_details')" class="tabA" ><span class="tabAspan" ><fmt:message key="eMR.RequestorDetails.label" bundle="${mr_labels}"/></span></a>
						</li>
						<li class="tablistitem" title="Other Details">
							<a onclick="tab_click('other_details')" class="tabClicked" ><span class="tabSpanclicked" ><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span></a>
						</li>
					</ul> 
				</td>
				<td colspan='2' class="white">&nbsp;</td>
			</tr>
			<tr>
				<th class="columnheader" align="left" colspan="4" ><fmt:message key="Common.PaymentDetails.label" bundle="${common_labels}"/></th>
			</tr>
			<tr>
				<td  class='label' width="20%"><fmt:message key="eMR.ChargesApplicable.label" bundle="${mr_labels}"/></td>
				<td class='fields' width="25%"><select name="charges_appllicable" id="charges_appllicable"  <%=disabled%> onchange="enableOtherDetails(this.name,this.value)">
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg1"></td>
				<td  class='label' width="30%"><fmt:message key="eMR.AdditionalCharges.label" bundle="${mr_labels}"/></td>
				<td class='fields' width="25%"><select name="additional_charges" id="additional_charges"  <%=disabled%> onchange="enableOtherDetails(this.name,this.value)">
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="addtlChargeImg1"></img></td>
			</tr>
			<tr>
				<td  class='label'><fmt:message key="Common.receiptno.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type=text name=recp_no size=15 maxlength=15 disabled value="<%=receipt_no%>" onblur="populateRecptDate(this.value,document.forms[0].recp_dat,document.getElementById("recp_dat_img"));" ><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg2"></td>
				<td  class='label'><fmt:message key="eMR.AdditionalReceiptNo.label" bundle="${mr_labels}"/></td>
				<td class='fields'><input type=text name=add_recp_no size=15 maxlength=15 disabled value="<%=addl_receipt_no%>" onblur="populateRecptDate(this.value,document.forms[0].add_recp_dat,document.getElementById("add_recp_dat_img"));"><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="addtlChargeImg2"></img></td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type=text name=amount size=15 maxlength=15  disabled value="<%=amount%>" onKeyPress="return(ChkDateNumberInput(this,event,2))" onBlur="CheckZeroVal(this);CheckNumberFormat(this);"><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg3"></td>
				<td  class='label'><fmt:message key="eMR.AdditionalAmount.label" bundle="${mr_labels}"/></td>
				<td class='fields'><input type=text name=add_amount size=15 maxlength=15 disabled value="<%=addl_amount%>" onKeyPress="return(ChkDateNumberInput(this,event,2))" onBlur="CheckZeroVal(this);CheckNumberFormat(this);"><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="addtlChargeImg3"></img></td>
			</tr>
			<tr>
				<td  class='label'><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type=text id='recpid' name=recp_dat size=16 maxlength=16 disabled value="<%=receipt_date_converted%>" ><img disabled src="../../eCommon/images/CommonCalendar.gif" id="recp_dat_img" onClick="document.forms[0].recp_dat.focus();return showCalendar('recpid',null,'hh:mm');"  disabled/><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg4"></td>
				<td  class='label'><fmt:message key="eMR.AdditionalReceiptDate.label" bundle="${mr_labels}"/></td>
				<td class='fields'><input type=text id='addrecpid' name=add_recp_dat size=16 maxlength=16 disabled value="<%=addl_receipt_date_converted%>" ><img disabled src="../../eCommon/images/CommonCalendar.gif" id="add_recp_dat_img" onClick="document.forms[0].add_recp_dat.focus();return showCalendar('addrecpid',null,'hh:mm');" <%=disabled%>/><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="addtlChargeImg4"></img></td>
			</tr>
		<%	}	
			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}
		
		%>
		<input type='hidden' name='patient_class' id='patient_class' value="">
		<input type='hidden' name='patientId' id='patientId' value="<%=patient_id%>">
		<input type='hidden' name='request_id' id='request_id' value="<%=request_id%>">
		<input type='hidden' name='EncounterIDS' id='EncounterIDS' value="">
		<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>">
		<input type='hidden' name='sysdate' id='sysdate' value='<%=SystemDate%>'>
		<input type='hidden' name='request_date' id='request_date' value='<%=reqDate%>'>
		<input type='hidden' name='hdd_Request_desc' id='hdd_Request_desc' value="<%=Request_desc%>">
		<input type='hidden' name='hdd_Medical_members' id='hdd_Medical_members' value="<%=Medical_members%>">
		<input type='hidden' name='hdd_Pract_name' id='hdd_Pract_name' value="<%=Pract_name%>">
		<input type='hidden' name='hdd_team_desc' id='hdd_team_desc' value="<%=team_desc%>">
		<input type='hidden' name='hdd_CollectDate' id='hdd_CollectDate' value="<%=CollectDate%>">
		<input type='hidden' name='hdd_PrepareDate' id='hdd_PrepareDate' value="<%=prepareDate%>">
		<input type='hidden' name='hdd_RecieveDate' id='hdd_RecieveDate' value="<%=RecdDate%>">
		<input type='hidden' name='hdd_remarks' id='hdd_remarks' value="<%=remarks%>">
		<input type='hidden' name='hdd_requestor_code' id='hdd_requestor_code' value="<%=requestor_code%>">
		<input type='hidden' name='hdd_team_code' id='hdd_team_code' value="<%=team_code%>">
		<input type='hidden' name='hdd_pract_code' id='hdd_pract_code' value="<%=pract_code%>">
		<input type='hidden' name='accession_num' id='accession_num' value="<%=accession_num%>">
		<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">
		<input type='hidden' name='new_func_id' id='new_func_id' value="<%=new_func_id%>">
		<input type='hidden' name='event_status' id='event_status' value="<%=event_status%>">
		<input type='hidden' name='old_revised_collect_date' id='old_revised_collect_date' value="<%=revised_collect_date%>">
		<input type='hidden' name='mode' id='mode' value="insert"> <!-- used for address -->
	<%	if(!revised_collect_date.equals(""))
		{	%>
				<input type='hidden' name='hid_revised_collect_date' id='hid_revised_collect_date' value="<%=revised_collect_date%>">
	<%	}	%>

		<!-- ADDRESS FIELDS FOR APPLICANT ... -->
		<input type='hidden' name='appl_addr_line1' id='appl_addr_line1' value="<%=addr_line1%>" >
		<input type='hidden' name='appl_addr_line2' id='appl_addr_line2' value="<%=addr_line2%>" >
		<input type='hidden' name='appl_addr_line3' id='appl_addr_line3' value="<%=addr_line3%>" >
		<input type='hidden' name='appl_addr_line4' id='appl_addr_line4' value="<%=addr_line4%>" >
		<input type='hidden' name='appl_res_town_code' id='appl_res_town_code' value="<%=res_town_code%>" >
		<input type='hidden' name='appl_res_town_desc' id='appl_res_town_desc' value="<%=res_town_desc%>" >
		<input type='hidden' name='appl_res_area_code' id='appl_res_area_code' value="<%=res_area_code%>" >
		<input type='hidden' name='appl_res_area_desc' id='appl_res_area_desc' value="<%=res_area_desc%>" >
		<input type='hidden' name='appl_region_code' id='appl_region_code' value="<%=region_code%>" >
		<input type='hidden' name='appl_region_desc' id='appl_region_desc' value="<%=region_desc%>" >
		<input type='hidden' name='appl_postal_code' id='appl_postal_code' value="<%=postal_code%>" >
		<input type='hidden' name='appl_postal_desc' id='appl_postal_desc' value="<%=postal_code%>" >
		<input type='hidden' name='appl_country_desc' id='appl_country_desc' value="<%=res_country_desc%>" >
		<input type='hidden' name='appl_country_code' id='appl_country_code' value="<%=res_country_code%>" >

		<!-- ADDRESS FIELDS FOR OTHERS ... -->
		<input type='hidden' name='Oth_appl_addr_line1' id='Oth_appl_addr_line1' value="">
		<input type='hidden' name='Oth_appl_addr_line2' id='Oth_appl_addr_line2' value="">
		<input type='hidden' name='Oth_appl_addr_line3' id='Oth_appl_addr_line3' value="">
		<input type='hidden' name='Oth_appl_addr_line4' id='Oth_appl_addr_line4' value="">
		<input type='hidden' name='Oth_appl_res_town_desc' id='Oth_appl_res_town_desc' value="">
		<input type='hidden' name='Oth_appl_res_town_code' id='Oth_appl_res_town_code' value="">
		<input type='hidden' name='Oth_appl_res_area_desc' id='Oth_appl_res_area_desc' value="">
		<input type='hidden' name='Oth_appl_res_area_code' id='Oth_appl_res_area_code' value="">
		<input type='hidden' name='Oth_appl_region_desc' id='Oth_appl_region_desc' value="">
		<input type='hidden' name='Oth_appl_region_code' id='Oth_appl_region_code' value="">
		<input type='hidden' name='Oth_appl_postal_desc' id='Oth_appl_postal_desc' value="">
		<input type='hidden' name='Oth_appl_postal_code' id='Oth_appl_postal_code' value="">
		<input type='hidden' name='Oth_appl_country_desc' id='Oth_appl_country_desc' value="">
		<input type='hidden' name='Oth_appl_country_code' id='Oth_appl_country_code' value="">

		<!-- ADDRESS FIELDS FOR NKIN ...  -->
		<input type='hidden' name='nkin_addr_line1' id='nkin_addr_line1' value="<%=nkin_addr_line1%>">
		<input type='hidden' name='nkin_addr_line2' id='nkin_addr_line2' value="<%=nkin_addr_line2%>">
		<input type='hidden' name='nkin_addr_line3' id='nkin_addr_line3' value="<%=nkin_addr_line3%>">
		<input type='hidden' name='nkin_addr_line4' id='nkin_addr_line4' value="<%=nkin_addr_line4%>">
		<input type='hidden' name='nkin_res_town_desc' id='nkin_res_town_desc' value="<%=nkin_res_town_desc%>">
		<input type='hidden' name='nkin_res_town_code' id='nkin_res_town_code' value="<%=nkin_res_town_code%>">
		<input type='hidden' name='nkin_res_area_desc' id='nkin_res_area_desc' value="<%=nkin_res_area_desc%>">
		<input type='hidden' name='nkin_res_area_code' id='nkin_res_area_code' value="<%=nkin_res_area_code%>">
		<input type='hidden' name='nkin_region_desc' id='nkin_region_desc' value="<%=nkin_region_desc%>">
		<input type='hidden' name='nkin_region_code' id='nkin_region_code' value="<%=nkin_region_code%>">
		<input type='hidden' name='nkin_postal_desc' id='nkin_postal_desc' value="<%=nkin_postal_code%>"> 
		<input type='hidden' name='nkin_postal_code' id='nkin_postal_code' value="<%=nkin_postal_code%>"> 
		<input type='hidden' name='nkin_country_desc' id='nkin_country_desc' value="<%=nkin_country_desc%>"> 
		<input type='hidden' name='nkin_country_code' id='nkin_country_code' value="<%=nkin_country_code%>"> 

		<!-- ADDRESS FIELDS FOR FTON ...  -->
		<input type='hidden' name='fton_addr_line1' id='fton_addr_line1' value="<%=fton_addr_line1%>">
		<input type='hidden' name='fton_addr_line2' id='fton_addr_line2' value="<%=fton_addr_line2%>">
		<input type='hidden' name='fton_addr_line3' id='fton_addr_line3' value="<%=fton_addr_line3%>">
		<input type='hidden' name='fton_addr_line4' id='fton_addr_line4' value="<%=fton_addr_line4%>">
		<input type='hidden' name='fton_res_town_desc' id='fton_res_town_desc' value="<%=fton_res_town_desc%>">
		<input type='hidden' name='fton_res_town_code' id='fton_res_town_code' value="<%=fton_res_town_code%>">
		<input type='hidden' name='fton_res_area_desc' id='fton_res_area_desc' value="<%=fton_res_area_desc%>">
		<input type='hidden' name='fton_res_area_code' id='fton_res_area_code' value="<%=fton_res_area_code%>">
		<input type='hidden' name='fton_region_desc' id='fton_region_desc' value="<%=fton_region_desc%>">
		<input type='hidden' name='fton_region_code' id='fton_region_code' value="<%=fton_region_code%>">
		<input type='hidden' name='fton_postal_desc' id='fton_postal_desc' value="<%=fton_postal_code%>"> 
		<input type='hidden' name='fton_postal_code' id='fton_postal_code' value="<%=fton_postal_code%>"> 
		<input type='hidden' name='fton_country_desc' id='fton_country_desc' value="<%=fton_country_desc%>"> 
		<input type='hidden' name='fton_country_code' id='fton_country_code' value="<%=fton_country_code%>"> 

		<!-- ADDRESS FIELDS FOR EMPLR ...  -->
		<input type='hidden' name='emplr_addr_line1' id='emplr_addr_line1' value="<%=emplr_addr_line1%>">
		<input type='hidden' name='emplr_addr_line2' id='emplr_addr_line2' value="<%=emplr_addr_line2%>">
		<input type='hidden' name='emplr_addr_line3' id='emplr_addr_line3' value="<%=emplr_addr_line3%>">
		<input type='hidden' name='emplr_addr_line4' id='emplr_addr_line4' value="<%=emplr_addr_line4%>">
		<input type='hidden' name='emplr_res_town_desc' id='emplr_res_town_desc' value="<%=emplr_res_town_desc%>">
		<input type='hidden' name='emplr_res_town_code' id='emplr_res_town_code' value="<%=emplr_res_town_code%>">
		<input type='hidden' name='emplr_res_area_desc' id='emplr_res_area_desc' value="<%=emplr_res_area_desc%>">
		<input type='hidden' name='emplr_res_area_code' id='emplr_res_area_code' value="<%=emplr_res_area_code%>">
		<input type='hidden' name='emplr_region_desc' id='emplr_region_desc' value="<%=emplr_region_desc%>">
		<input type='hidden' name='emplr_region_code' id='emplr_region_code' value="<%=emplr_region_code%>">
		<input type='hidden' name='emplr_postal_desc' id='emplr_postal_desc' value="<%=emplr_postal_code%>"> 
		<input type='hidden' name='emplr_postal_code' id='emplr_postal_code' value="<%=emplr_postal_code%>"> 
		<input type='hidden' name='emplr_country_desc' id='emplr_country_desc' value="<%=emplr_country_desc%>"> 
		<input type='hidden' name='emplr_country_code' id='emplr_country_code' value="<%=emplr_country_code%>"> 

	<!-- ADDRESS FIELDS FOR Requestor DELIVERY ... -->
		<input type='hidden' name='requestor_addr_line1' id='requestor_addr_line1' value="<%=addr_line1%>">
		<input type='hidden' name='requestor_addr_line2' id='requestor_addr_line2' value="<%=addr_line2%>">
		<input type='hidden' name='requestor_addr_line3' id='requestor_addr_line3' value="<%=addr_line3%>">
		<input type='hidden' name='requestor_addr_line4' id='requestor_addr_line4' value="<%=addr_line4%>">
		<input type='hidden' name='requestor_res_town_desc' id='requestor_res_town_desc' value="<%=res_town_desc%>">
		<input type='hidden' name='requestor_res_town_code' id='requestor_res_town_code' value="<%=res_town_code%>">
		<input type='hidden' name='requestor_res_area_desc' id='requestor_res_area_desc' value="<%=res_area_desc%>">
		<input type='hidden' name='requestor_res_area_code' id='requestor_res_area_code' value="<%=res_area_code%>">
		<input type='hidden' name='requestor_region_desc' id='requestor_region_desc' value="<%=region_desc%>">
		<input type='hidden' name='requestor_region_code' id='requestor_region_code' value="<%=region_code%>">
		<input type='hidden' name='requestor_postal_desc' id='requestor_postal_desc' value="<%=postal_code%>">
		<input type='hidden' name='requestor_postal_code' id='requestor_postal_code' value="<%=postal_code%>">
		<input type='hidden' name='requestor_country_desc' id='requestor_country_desc' value="<%=res_country_desc%>">
		<input type='hidden' name='requestor_country_code' id='requestor_country_code' value="<%=res_country_code%>">

		<!-- ADDRESS FIELDS FOR OTHER DELIVERY ... -->
		<input type='hidden' name='other_del_addr_line1' id='other_del_addr_line1' value="<%=addr_line1%>">
		<input type='hidden' name='other_del_addr_line2' id='other_del_addr_line2' value="<%=addr_line2%>">
		<input type='hidden' name='other_del_addr_line3' id='other_del_addr_line3' value="<%=addr_line3%>">
		<input type='hidden' name='other_del_addr_line4' id='other_del_addr_line4' value="<%=addr_line4%>">
		<input type='hidden' name='other_del_res_town_desc' id='other_del_res_town_desc' value="<%=res_town_desc%>">
		<input type='hidden' name='other_del_res_town_code' id='other_del_res_town_code' value="<%=res_town_code%>">
		<input type='hidden' name='other_del_res_area_desc' id='other_del_res_area_desc' value="<%=res_area_desc%>">
		<input type='hidden' name='other_del_res_area_code' id='other_del_res_area_code' value="<%=res_area_code%>">
		<input type='hidden' name='other_del_region_desc' id='other_del_region_desc' value="<%=region_desc%>">
		<input type='hidden' name='other_del_region_code' id='other_del_region_code' value="<%=region_code%>">
		<input type='hidden' name='other_del_postal_desc' id='other_del_postal_desc' value="<%=postal_code%>">
		<input type='hidden' name='other_del_postal_code' id='other_del_postal_code' value="<%=postal_code%>">
		<input type='hidden' name='other_del_country_desc' id='other_del_country_desc' value="<%=res_country_desc%>">
		<input type='hidden' name='other_del_country_code' id='other_del_country_code' value="<%=res_country_code%>">

		<!-- ADDRESS FIELDS FOR PERSONAL DELIVERY ... -->
		<input type='hidden' name='personal_del_addr_line1' id='personal_del_addr_line1' value="<%=addr_line1%>">
		<input type='hidden' name='personal_del_addr_line2' id='personal_del_addr_line2' value="<%=addr_line2%>">
		<input type='hidden' name='personal_del_addr_line3' id='personal_del_addr_line3' value="<%=addr_line3%>">
		<input type='hidden' name='personal_del_addr_line4' id='personal_del_addr_line4' value="<%=addr_line4%>">
		<input type='hidden' name='personal_del_res_town_desc' id='personal_del_res_town_desc' value="<%=res_town_desc%>">
		<input type='hidden' name='personal_del_res_town_code' id='personal_del_res_town_code' value="<%=res_town_code%>">
		<input type='hidden' name='personal_del_res_area_desc' id='personal_del_res_area_desc' value="<%=res_area_desc%>">
		<input type='hidden' name='personal_del_res_area_code' id='personal_del_res_area_code' value="<%=res_area_code%>">
		<input type='hidden' name='personal_del_region_desc' id='personal_del_region_desc' value="<%=region_desc%>">
		<input type='hidden' name='personal_del_region_code' id='personal_del_region_code' value="<%=region_code%>">
		<input type='hidden' name='personal_del_postal_desc' id='personal_del_postal_desc' value="<%=postal_code%>">
		<input type='hidden' name='personal_del_postal_code' id='personal_del_postal_code' value="<%=postal_code%>">
		<input type='hidden' name='personal_del_country_desc' id='personal_del_country_desc' value="<%=res_country_desc%>">
		<input type='hidden' name='personal_del_country_code' id='personal_del_country_code' value="<%=res_country_code%>">


		<input type='hidden' name='med_board_type' id='med_board_type' value="<%=med_board_type%>"> 

	<%
		if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	%>
			<input type="hidden" name="patient_id" id="patient_id" value="">
			<input type="hidden" name="patient_name" id="patient_name" value="" >	
			<input type="hidden" name="patient_name_long" id="patient_name_long" value="" >	
			<input type="hidden" name="patient_name_loc_lang_long" id="patient_name_loc_lang_long" value="" >	
			<input type="hidden" name="name_prefix1" id="name_prefix1" value="" > 	
			<input type="hidden" name="family_name" id="family_name" value="" > 	
			<input type="hidden" name="first_name" id="first_name" value="" > 	
			<input type="hidden" name="second_name" id="second_name" value="" >
			<input type="hidden" name="third_name" id="third_name" value="" >
			<input type="hidden" name="name_suffix1" id="name_suffix1" value="" >
			<input type="hidden" name="name_prefix_oth_lang" id="name_prefix_oth_lang" value="" > 	
			<input type="hidden" name="family_name_oth_lang" id="family_name_oth_lang" value="" > 	
			<input type="hidden" name="first_name_oth_lang" id="first_name_oth_lang" value="" > 	
			<input type="hidden" name="second_name_oth_lang" id="second_name_oth_lang" value="" >
			<input type="hidden" name="third_name_oth_lang" id="third_name_oth_lang" value="" >
			<input type="hidden" name="name_suffix_oth_lang" id="name_suffix_oth_lang" value="" >
			<input type="hidden" name="patient_name_local_lang" id="patient_name_local_lang" value="" >			
			<input type="hidden" name="sex" id="sex" value="" >
			<input type="hidden" name="date_of_birth" id="date_of_birth" value="" >
			<input type="hidden" name="Birth_place_code" id="Birth_place_code" value="" >
			<input type="hidden" name="place_of_birth" id="place_of_birth" value="" >
			<input type="hidden" name="birth_place" id="birth_place" value="" >
			<input type="hidden" name="nationality_code1" id="nationality_code1" value="" >
			<input type="hidden" name="nationality_desc" id="nationality_desc" value="" >
			<input type="hidden" name="national_id_no" id="national_id_no" value="" >
			<input type="hidden" name="alt_id1_no" id="alt_id1_no" value="" >
			<input type="hidden" name="alt_id2_no" id="alt_id2_no" value="" >
			<input type="hidden" name="alt_id3_no" id="alt_id3_no" value="" >
			<input type="hidden" name="alt_id4_no" id="alt_id4_no" value="" >
			<input type="hidden" name="alt_id1_exp_date" id="alt_id1_exp_date" value="" >
			<input type="hidden" name="alt_id2_exp_date" id="alt_id2_exp_date" value="" >
			<input type="hidden" name="alt_id3_exp_date" id="alt_id3_exp_date" value="" >
			<input type="hidden" name="alt_id4_exp_date" id="alt_id4_exp_date" value="" >
			<input type="hidden" name="other_alt_type" id="other_alt_type" value="" >
			<input type="hidden" name="other_alt_Id" id="other_alt_Id" value="" >
			<input type="hidden" name="race_code" id="race_code" value="" >
			<input type="hidden" name="ethnic_group" id="ethnic_group" value="" >
			<input type="hidden" name="citizen_yn" id="citizen_yn" value="" >
			<input type="hidden" name="citizen_yn[1]" id="citizen_yn[1]" value="" >
			<input type="hidden" name="legal_yn" id="legal_yn" value="" >
			<input type="hidden" name="legal_yn[1]" id="legal_yn[1]" value="" >
			<input type="hidden" name="addr_line1" id="addr_line1" value="" >
			<input type="hidden" name="addr_line2" id="addr_line2" value="" >
			<input type="hidden" name="addr_line3" id="addr_line3" value="" >
			<input type="hidden" name="addr_line4" id="addr_line4" value="" >
			<input type="hidden" name="res_town_code" id="res_town_code" value="" >
			<input type="hidden" name="res_town_desc" id="res_town_desc" value="" >
			<input type="hidden" name="res_area_code" id="res_area_code" value="" >
			<input type="hidden" name="res_area_desc" id="res_area_desc" value="" >
			<input type="hidden" name="region_code" id="region_code" value="" >
			<input type="hidden" name="region_desc" id="region_desc" value="" >
			<input type="hidden" name="postal_code" id="postal_code" value="" >
			<input type="hidden" name="country_desc" id="country_desc" value="" >
			<input type="hidden" name="country_code" id="country_code" value="" >
			<input type="hidden" name="contact1_name" id="contact1_name" value="" >
			<input type="hidden" name="addr2_type" id="addr2_type" value="" >
			<input type="hidden" name="mail_addr_line1" id="mail_addr_line1" value="" >
			<input type="hidden" name="mail_addr_line2" id="mail_addr_line2" value="" >
			<input type="hidden" name="mail_addr_line3" id="mail_addr_line3" value="" >
			<input type="hidden" name="mail_addr_line4" id="mail_addr_line4" value="" >
			<input type="hidden" name="mail_res_town_code" id="mail_res_town_code" value="" >
			<input type="hidden" name="mail_res_town_desc" id="mail_res_town_desc" value="" >
			<input type="hidden" name="mail_res_area_code" id="mail_res_area_code" value="" >
			<input type="hidden" name="mail_res_area_desc" id="mail_res_area_desc" value="" >
			<input type="hidden" name="mail_postal_code" id="mail_postal_code" value="" >
			<input type="hidden" name="mail_region_code" id="mail_region_code" value="" >
			<input type="hidden" name="mail_region_desc" id="mail_region_desc" value="" >
			<input type="hidden" name="mail_country_code" id="mail_country_code" value="" >
			<input type="hidden" name="mail_country_desc" id="mail_country_desc" value="" >
			<input type="hidden" name="contact2_name" id="contact2_name" value="" >
			<input type="hidden" name="contact1_no" id="contact1_no" value="" >
			<input type="hidden" name="contact2_no" id="contact2_no" value="" >
			<input type="hidden" name="email" id="email" value="" >
			<!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601 Start-->
			<input type='hidden' name='alt_addr_line1' id='alt_addr_line1' value="">
			<input type='hidden' name='alt_addr_line2' id='alt_addr_line2' value="">
			<input type='hidden' name='alt_addr_line3' id='alt_addr_line3' value="">
			<input type='hidden' name='alt_addr_line4' id='alt_addr_line4' value="">
			<input type='hidden' name='alt_town_code' id='alt_town_code' value="">
			<input type='hidden' name='alt_town_desc' id='alt_town_desc' value="">
			<input type='hidden' name='alt_area_code' id='alt_area_code' value="">
			<input type='hidden' name='alt_area_desc' id='alt_area_desc' value="">
			<input type='hidden' name='alt_postal_code' id='alt_postal_code' value="">
			<input type='hidden' name='alt_postal_desc' id='alt_postal_desc' value="">
			<input type='hidden' name='alt_region_code' id='alt_region_code' value="">
			<input type='hidden' name='alt_region_desc' id='alt_region_desc' value="">
			<input type='hidden' name='alt_country_code' id='alt_country_code' value="">
			<input type='hidden' name='alt_country_desc' id='alt_country_desc' value="">
			<!--End-->
	<%	}	%>
	<input type='hidden' name='isAddressLengthIncAppl' id='isAddressLengthIncAppl' value='<%=isAddressLengthIncAppl%>'><!--Added by Thamizh selvi on 9th Feb 2018 against ML-MMOH-CRF-0860.2-->
	<input type="hidden" name="Facility_Id" id="Facility_Id" value="<%=Facility_Id%>" >
	<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
	<input type="hidden" name="revise_stat" id="revise_stat" value="" >
	<input type="hidden" name="med_board_type" id="med_board_type" value="" >
	<input type="hidden" name="req_status" id="req_status" value="" >

	<input type="hidden" name="medrep_pay_int_mode" id="medrep_pay_int_mode" value="<%=medrep_pay_int_mode%>" >
	<input type="hidden" name="prepareDate" id="prepareDate" value="<%=prepareDate%>" >
	<input type="hidden" name="applCompletionDate" id="applCompletionDate" value="<%=appl_completion_date%>" >
	<input type="hidden" name="RequestDate" id="RequestDate" value="<%=reqDate%>" >
	<input type="hidden" name="ReceivedDate" id="ReceivedDate" value="<%=RecdDate%>" >
	<input type="hidden" name="DeliveredDate" id="DeliveredDate" value="<%=delivered_date%>" >
	<input type="hidden" name="applSubmissionDate" id="applSubmissionDate" value="<%=applSubmissionDate%>" >
	<input type="hidden" name="hdd_charges_appl_yn" id="hdd_charges_appl_yn" value="<%=charges_appl_yn%>" >
	<input type="hidden" name="hdd_addl_charges_yn" id="hdd_addl_charges_yn" value="<%=addl_charges_yn%>" >
	<input type="hidden" name="hdd_receipt_no" id="hdd_receipt_no" value="<%=receipt_no%>" >
	<input type="hidden" name="hdd_addl_receipt_no" id="hdd_addl_receipt_no" value="<%=addl_receipt_no%>" >
	<input type="hidden" name="hdd_amount" id="hdd_amount" value="<%=amount%>" >
	<input type="hidden" name="hdd_addl_amount" id="hdd_addl_amount" value="<%=addl_amount%>" >
	<input type="hidden" name="hdd_receipt_date" id="hdd_receipt_date" value="<%=receipt_date%>" >
	<input type="hidden" name="hdd_addl_receipt_date" id="hdd_addl_receipt_date" value="<%=addl_receipt_date%>" >

	<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
	<input type='hidden' name='indicator_req' id='indicator_req' value="<%=indicator%>">

	<!--Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707-->

	<input type='hidden' name='self_contact_no1' id='self_contact_no1' value="">
	<input type='hidden' name='self_contact_no2' id='self_contact_no2' value="">
	<input type='hidden' name='self_appl_email_id' id='self_appl_email_id' value="">

	<input type='hidden' name='nkin_contact_no1' id='nkin_contact_no1' value="">
	<input type='hidden' name='nkin_contact_no2' id='nkin_contact_no2' value="">
	<input type='hidden' name='nkin_appl_email_id' id='nkin_appl_email_id' value="">

	<input type='hidden' name='fton_contact_no1' id='fton_contact_no1' value="">
	<input type='hidden' name='fton_contact_no2' id='fton_contact_no2' value="">
	<input type='hidden' name='fton_appl_email_id' id='fton_appl_email_id' value="">

	<input type='hidden' name='emplr_contact_no1' id='emplr_contact_no1' value="">
	<input type='hidden' name='emplr_contact_no2' id='emplr_contact_no2' value="">
	<input type='hidden' name='emplr_appl_email_id' id='emplr_appl_email_id' value="">

	<input type='hidden' name='other_contact_no1' id='other_contact_no1' value="">
	<input type='hidden' name='other_contact_no2' id='other_contact_no2' value="">
	<input type='hidden' name='other_appl_email_id' id='other_appl_email_id' value="">

	<input type='hidden' name='requestor_contact_no1' id='requestor_contact_no1' value="">
	<input type='hidden' name='requestor_contact_no2' id='requestor_contact_no2' value="">
	<input type='hidden' name='requestor_appl_email_id' id='requestor_appl_email_id' value="">

	<!--ML-MMOH-CRF-0707-->

	<%
	if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
	{	%>
		<script>
			document.forms[0].appln_date.value="<%=application_date%>";
			document.forms[0].appln_date.disabled=true;
			document.getElementById("ApplnImg").disabled=true;
		</script>
	<%	}	

		if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
		{
			out.println("<script>document.forms[0].appl_addr.disabled=false;</script>");
		}

		if(call_function.equals("QUERY_DELAY_IN_MRR") )
		{
			out.println("<script>document.forms[0].search.disabled = true;</script>");
		}	
		
		if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	%>
			<script>
				if("<%=applicant_name%>" == "")
				{
				}
			</script>
	<%
		}

		if(call_function.equals("MEDICAL_BOARD_COMPLETED"))
		{	%>
				<script>
				for(var i=0; i<document.forms[0].length;i++)
				{
					document.forms[0].elements(i).disabled = true;
				}
				document.getElementById("del_img").disabled = true;	
				document.forms[0].appl_addr.disabled = false;
				document.forms[0].Dates.disabled = false;
				document.forms[0].Charges.disabled = false;
				if(document.forms[0].Despatch_mode.value != '')
					document.forms[0].address.disabled = false;
			</script>
	<%	}

		if(call_function.equals("REVISE_MEDICAL_BOARD"))
	{%>
		<script>
			if(document.forms[0].rep_type)
				{
					//if(document.forms[0].rep_type.value=='')
						document.forms[0].ReportTypeImg.style.visibility='hidden';						
				}
			if(document.forms[0].dept_spl)
				{
					//if(document.forms[0].dept_spl.value=='')
						document.forms[0].DeptImg.style.visibility='hidden';						
				}
			if(document.forms[0].fwd_pract_desc)
				{
					//if(document.forms[0].fwd_pract_desc.value=='')
						document.forms[0].fwd_practitionerImg.style.visibility='hidden';						
				}
			if(document.forms[0].appl_status)
				{
					//if(document.forms[0].appl_status.value=='')
						document.forms[0].appln_status_Img.style.visibility='hidden';						
				}
			if(document.forms[0].collect_date)
				{
					
					//if(document.forms[0].collect_date.value=='')
						document.forms[0].collectImg.style.visibility='hidden';
					
				}
			
			if(document.forms[0].prepare_date)
				{
					
					//if(document.forms[0].prepare_date.value=='')
						document.forms[0].prepare_date_Img.style.visibility='hidden';
					
				}

			if(document.forms[0].prep_pract_desc)
				{
					
					//if(document.forms[0].prep_pract_desc.value=='')
						document.forms[0].prep_pract_desc_Img.style.visibility='hidden';
					
				}
			if(document.forms[0].receive_date)
				{
					
					//if(document.forms[0].receive_date.value=='')
						document.forms[0].receive_date_Img.style.visibility='hidden';
					
				}
			if(document.forms[0].delivered_date)
				{
					//if(document.forms[0].delivered_date.value=='')
						document.forms[0].delivered_date_Img.style.visibility='hidden';
				}
			
			
		</script>
<%	}


	}catch(Exception e)
	{
		//out.println("err in try catch : "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
</table>

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

