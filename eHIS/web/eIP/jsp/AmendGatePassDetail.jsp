<!DOCTYPE html>
<%
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> RenewGatePass
/// Developer		:	SRIDHAR R
/// Created On		:	FEB 2004
/// Funtion			:	This File is called from ReleaseBookLodgerDetail.jsp.

// This File will be called when the user want to Renew the Gate Pass..
//	The Details are inserted to IP_LODGER_GATE_PASS & Updated in IP_LODGER_DETAIL table.
%>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
    <head>
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<style>
	    input:disabled , select:disabled {
	      background-color: #d3d3d3;
	      color: #a9a9a9;
	      border: 1px solid #a9a9a9;
	      cursor: not-allowed;
	      opacity: 0.6;
	      pointer-events: none;
	    }
  	</style>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../js/CheckinLodger.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>
function localValidations(obj)
{}

function SubmitPage()
{
	var revise_period_from_val = document.forms[0].revise_period_from.value;
	var revise_period_to_val = document.forms[0].revise_period_to.value;

	if(parseInt(revise_period_from_val.length) <= 0 )
	{

		var error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',getLabel("eIP.reviseperiodfrom.label","IP"));
		alert(error);						
		document.forms[0].revise_period_from.focus();
	}
	else 
	if(parseInt(revise_period_to_val.length) <= 0 )
	{
		var error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',getLabel("eIP.reviseperiodto.label","IP"));
		alert(error);						
		document.forms[0].revise_period_to.focus();
	}
	else 
	if(document.forms[0].Authorised_lookup.readOnly == true && parseInt(document.forms[0].Authorised_text.length) <= 0)
	{
		var error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',getLabel("Common.authorizedby.label","Common"));
		alert(error);						
		document.forms[0].Authorised_text.focus();
	}
	else
	if(document.forms[0].Authorised_text.readOnly == true && parseInt(document.forms[0].Authorised_lookup.value.length) <= 0 )
	{
		var error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',getLabel("Common.authorizedby.label","Common"));
		alert(error);						
		document.forms[0].Authorised_lookup.focus();
	}
	else
	if(document.forms[0].Authorised_lookup.readOnly == false &&  document.forms[0].Authorised_text.readOnly == false)
	{
		var error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',getLabel("Common.authorizedby.label","Common"));
		alert(error);						
		document.forms[0].Authorised_lookup.focus();
	}
	else
	{
		document.forms[0].submit();
	}
}


// Added by Sridhar on 7 AUG 2004
// Function will check for empty values before calling up the common lookup func..
		
function beforeGetAuthorised(target_id,target)
{
	if(document.forms[0].Authorised_hid.value != document.forms[0].Authorised_lookup.value)
	{
		if(document.forms[0].Authorised_lookup.value != "")
			 getAuthoriser(target_id,target);
	}
}

async function getAuthoriser(target_id,target)
{
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray=new Array(8);
	var title = getLabel("Common.authorizedby.label","Common");
 
	argumentArray[0]="select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER_LANG_VW  where language_id='"+localeName+"' and EFF_STATUS like ? and APPL_USER_ID like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) ";

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
		document.forms[0].Authorised_hid.value		=	arr[0];		
		document.forms[0].Authorised_lookup.value	=	arr[1];
		document.forms[0].Authorised_lookup.focus();
		document.forms[0].Authorised_hid.value		= document.forms[0].Authorised_lookup.value;
	}
	else
	{
		document.forms[0].Authorised_hid.value		= "";		document.forms[0].Authorised_lookup.value	= "";
	}
}


function enableDisable(lookup,text)
{
	if(lookup.value == '')
	{
		document.forms[0].Authorised_text.readOnly	= false;
	}
	else
	{
		document.forms[0].Authorised_text.value		= '';
		document.forms[0].Authorised_text.readOnly	= true;
	}
	
	if(text.value == '')
	{
		document.forms[0].Authorised_lookup.readOnly	= false;
		document.forms[0].search_Authorised.disabled	= false;
	}
	else
	{
		document.forms[0].Authorised_lookup.value		= '';
		document.forms[0].Authorised_lookup.readOnly	= true;
		document.forms[0].search_Authorised.disabled	= true;
	}
}


/// CODED ON 26 APR 2004 BY SRIDHAR 
//// Function : This func is called for validating the Maximum Renewal Period . It will add the no of Days/Hours to the [Renew period from] & return the value.

function testMaxPeriod(obj)
{
	//var objchk = obj.value;
	var retval=true
	//if(objchk != 0)
	if(obj.value != '')
	{
		/*if(!doDateTimeChk(obj))
		{
			retval= false;			
			obj.focus();
		}*/
		if(!validDateObj(obj,"DMYHM",localeName))
			retval= false;	

		if(retval)	
		{	
			
			//var OTdate = objchk; 
			var OTdate = convertDate(obj.value,"DMYHM",localeName,"en");
			var renewdate = document.forms[0].revise_period_from.value; 	
			if(renewdate.length > 1)	
			{
				var greg_renewdate = convertDate(document.forms[0].revise_period_from.value,"DMYHM",localeName,"en");
				var gate_pass_period = document.forms[0].gate_pass_period.value;
				retval = ValidateRenewDateTime(greg_renewdate,OTdate,gate_pass_period);
			}
			else
			{
			}
		}
	 return retval;
    }
}

function ValidateRenewDateTime(from,to,gate_pass_period)
{	
  if(gate_pass_period != "")
  {
	var prefDateTime = from;
	var a =  from.split(" ")
	splitdate=a[0];
	splittime=a[1]
	
	var retval=true
	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	a = to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")

	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	if(document.forms[0].hddRenewUnit.value == "D")
	{
		var expDaysofStay = gate_pass_period;
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH criteria='Days' prefDateTime=\""+prefDateTime+"\" expDaysofStay=\""+expDaysofStay+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ValidateRenewPeriod.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
	}
	else
	{
		var expHoursofStay = gate_pass_period;
		expHoursofStay = expHoursofStay / 24;
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH criteria='Hours' prefDateTime=\""+prefDateTime+"\" expHoursofStay=\""+expHoursofStay+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ValidateRenewPeriod.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
	}

	a = responseText.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")

	var exp_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	if((Date.parse(from_date) > Date.parse(to_date)) || (Date.parse(to_date) > Date.parse(exp_date)))
	{
		alert(getMessage("RENEW_DT_LT_MAX_PR","IP") );
		document.forms[0].revise_period_to.focus();
		document.forms[0].revise_period_to.select();
		retval = false;
		return retval
	}
   return retval
  }
}



//// CODED ON 11 MAR 2004 BY SRIDHAR 
//// FUNC USED TO COMPARE [REVISE PERIOD FROM] DATE WITH [REVISE PERIOD TO] 
//// Func will return an alert message if REVISE TO DATE is Less than REVISE FROM DATE
function CompareReviseTime(from,to)
{
	var continue_YN = "";
	if(to.value != '' )
		{
			
			if(validDateObj(to,"DMYHM",localeName))
			{
				continue_YN = "Y";
			}
			else
				return false;
		
			/*if(!doDateTimeChk(to))
				{
					alert( getMessage("INVALID_DATE_TIME","SM") );
					to.focus();
					to.select();
					return ;
				}
			else
				continue_YN = "Y";*/
		}
		if(from.value != '')
			{
				
				if(!validDateObj(from,"DMYHM",localeName))
					return false;

		
				/*if(!doDateTimeChk(from))
					{
						alert( getMessage("INVALID_DATE_TIME","SM") );
						from.focus();
						from.select();
						return ;
					}*/
				
				//var frdt = from.value;
				//var tdt = to.value;
				var greg_fromdate = convertDate(from.value,"DMYHM",localeName,"en");
				var greg_todate = convertDate(to.value,"DMYHM",localeName,"en");
				if(continue_YN == "Y")
					//RevisePeriodcheckDateTime(frdt,tdt);
				{
					if(isAfter(greg_fromdate,greg_todate,"DMYHM","en"))
					{
						alert( getMessage("RENEW_TODT_GT_FRDT","IP") );
						document.forms[0].revise_period_to.value = '' ;
						document.forms[0].revise_period_to.focus();
						document.forms[0].revise_period_to.select();
						return false
					}
					else
					{
						testMaxPeriod(document.forms[0].revise_period_to);
					}	
				}
					
				else
					return false;
			}
			else
				return false;
		
}

function RevisePeriodcheckDateTime(obj1,obj2)
{	
 	var a=obj1.split(" ");
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 = a[0].split("/")
	var splittime1 = a[1].split(":")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));

	 a=obj2.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 = a[0].split("/")
	 splittime1 = a[1].split(":")

	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));

	if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert( getMessage("RENEW_TODT_GT_FRDT","IP") );
		document.forms[0].revise_period_to.focus();
		document.forms[0].revise_period_to.select();
		return false
	}
	else
	{
		testMaxPeriod(document.forms[0].revise_period_to);
	}	
}	


//// CODED ON 11 MAR 2004 BY SRIDHAR 
//// FUNC USED TO COMPARE [REVISE PERIOD FROM] DATE WITH [PERIOD TO] 
//// Func will return an alert message if [REVISE FROM DATE] is Less than [TO DATE]

function compareDate(periodFromobj,periodToObj)
{
	
	if(periodFromobj.value !='' && periodToObj.value !='')
	{
		//if(periodFromobj.value != '' )
		//{
			/*if(!doDateTimeChk(periodFromobj))
			{
				periodFromobj.focus();
				periodFromobj.select();
				return;
			}*/
			if(validDateObj(periodFromobj,"DMYHM",localeName))
			{
				var greg_period_from_date = convertDate(periodFromobj.value,"DMYHM",localeName,"en");

				
				if(isBefore(greg_period_from_date,periodToObj.value,"DMYHM","en"))
				{
					alert( getMessage("RENEW_LT_PR_DT","IP") );
					periodFromobj.focus();
					periodFromobj.select();
					return false;
				}
				else
					return	CompareReviseTime(periodFromobj,document.forms[0].revise_period_to);
				/*if(!ValidateDateTime(periodToObj,periodFromobj))
				{
					alert( getMessage("RENEW_LT_PR_DT","IP") );
					periodFromobj.focus();
					periodFromobj.select();
					return;
				}*/
			}
			else
			{
				return false;
			}

			
			/*else
			{	
			}*/
		//}
		//else return;
	}
	else
		return CompareReviseTime(periodFromobj,document.forms[0].revise_period_to);
	
}


function checkMax(obj)
{
	if(obj.value.length > 200)
	{
		alert(getMessage('REMARKS_NOT_EXCEED_200_CH','SM'));
		obj.focus();
		obj.select();
	}
	else 
	makeValidString(obj);
}


function CheckMaxLength(obj,max) 
{
	if(obj.value.length >= max) 
		return false;
	else 
		return true;
}

</script>
		<%
			request.setCharacterEncoding("UTF-8");
			//MMS-ME-SCF-0096 vulnerability Issue
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//MMS-ME-SCF-0096 vulnerability Issue
			String locale			= (String)session.getAttribute("LOCALE");

			String renewalValid_to ="";
			String  renewalValid_fr ="";
			 

            Connection con = null;

			Statement stmt		= null;
            ResultSet rs		= null ;
			Statement ParamStmt = null; 
			ResultSet ParamRS	= null;
			
			String facility_id	= (String)session.getValue ("facility_id") ;
		
			String mode = request.getParameter("mode") ;
            if( mode == null )  mode = "insert" ;

			String encounter_id = request.getParameter("EncounterId");
            if(encounter_id ==null) encounter_id="";
                
            String Category = request.getParameter("Category");
            if(Category == null) Category = "L" ;

            String pat_id = request.getParameter("lodger_patient_id");
            if(pat_id ==null) pat_id="";

			// DECLARATION OF VARIABLES
			String years	= "";
			String months   = "";
			String days     = "";

			String lodger_patient_name	= "" ;
			String reason_for_stay		= "";
			String alt_long_desc		= "";
			String check_in_date_time	= "";
			String check_in_dis_dat_tim = "";
			String Period_date_time_from= "";
			String Period_date_time_to	= "";
			String Period_dat_dis_tim_fr= "";
			String Period_dat_dis_tim_to= "";
			String authorized_by		= "";  
			String nursing_desc			= "";
			String patientID			= "";
			String lodger_ref_no		= "";			
			String remarks				= "";                			
			String lodger_relation_code = "";

			String nameprefix			= "";
			String firstname			= "";
			String secondname			= "";
			String thirdname			= "";
			String familyname			= "";
			String namesuffix			= "";
			String gender				= "";
			String date_of_birth		= "";
			String place_of_birth_code	= "";
			String place_of_birth_desc	= "";
			String citizen				= "";
			String legal				= "";
			String email_id				= "";
			String national_id_no		= "";
			String alt_id1_no			= "";
			String alt_id2_no			= "";
			String alt_id3_no			= "";
			String alt_id4_no			= "";
			String oth_alt_id_no		= ""; 
			String oth_alt_id_type		= "";
			String res_addr_line1		= "";
			String res_addr_line2		= "";
			String res_addr_line3		= "";
			String res_addr_line4		= "";
			String res_town_code		= "";
			String res_town_desc		= "";
			String res_area_code		= "";
			String res_area_desc		= "";
			String res_region_code		= "";
			String res_region_desc		= "";
			String postal_code			= "";
			String country_code			= "";
			String mail_addr_line1		= "";
			String mail_addr_line2		= "";
			String mail_addr_line3		= "";
			String mail_addr_line4		= "";
			String mail_country_code	= "";
			String mail_country_desc	= "";
			String mail_town_code		= "";
			String mail_town_desc		= "";
			String mail_area_code		= "";
			String mail_area_desc		= "";
			String mail_region_code		= "";	
			String mail_region_desc		= "";
			String mail_postal_code		= "";
			String other_tel_no			= "";
			String oth_contact_no		= "";
			String eth_grp				= "";
			String eth_sub_grp			= "";
			String nationality_code		= "";
			String alt_id1_exp_date		= "";
			String alt_id2_exp_date		= "";
			String alt_id3_exp_date		= "";
			String alt_id4_exp_date		= "";
			String Acc_person_age		= "";
			String name_prefix_loc_lang	= "";
			String first_name_loc_lang	= "";
			String second_name_loc_lang	= "";
			String third_name_loc_lang	= "";
			String family_name_loc_lang	= "";
			String name_suffix_loc_lang	= "";
			String patient_name_loc_lang= "";

			/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			String alt_addr_line1	= "";
			String alt_addr_line2	= "";
			String alt_addr_line3	= "";
			String alt_addr_line4	= "";
			String alt_postal_code  = "";
			String alt_postal_desc  = "";
			String alt_country_code = "";
			String alt_country_desc = "";
			String alt_area_code	= "";
			String alt_area_desc	= "";
			String alt_town_code	= "";
			String alt_town_desc	= "";
			String alt_region_code	= "";
			String alt_region_desc	= "";
			/*End*/

            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
            java.util.Date dt=new java.util.Date();
            String currDate = dateFormat.format( dt ) ;
            
            String min = String.valueOf(dt.getMinutes()) ;
            if(min.length() == 1)   min = "0"+min ;
            currDate=currDate + " "+String.valueOf(dt.getHours())+":"+min;
            check_in_date_time = currDate ;   
try
{
	con = ConnectionManager.getConnection(request);

	String gate_pass_period = "";
	String gate_pass_unit = "";
	String label	= "";

	if( mode.equals("update") )
	{

	String paramSql="select DFLT_GATE_PASS_PERIOD, DFLT_GATE_PASS_UNIT from ip_param where facility_ID='"+facility_id+"'";

		ParamStmt = con.createStatement();
		ParamRS = ParamStmt.executeQuery( paramSql );

		if(ParamRS!=null)
		{
			if ( ParamRS.next() )
			{
				gate_pass_period = ParamRS.getString("DFLT_GATE_PASS_PERIOD");
				gate_pass_unit = ParamRS.getString("DFLT_GATE_PASS_UNIT"); 
			}
		}
	
	if(gate_pass_period == null) gate_pass_period ="";
	if(gate_pass_unit == null) gate_pass_unit ="";


	if(gate_pass_period.equals("") || gate_pass_period.equals("0"))
	{
		out.println("<script>alert(getMessage('RENEW_GATE_PASS_NOT_DEF','IP'));parent.window.close();</script>");
	}

	lodger_ref_no = request.getParameter("lodger_ref_no") ;
    if(lodger_ref_no.equals("null"))  lodger_ref_no ="" ;

	nursing_desc = request.getParameter("nursing_desc") ;
	if(nursing_desc.equals("null"))  nursing_desc ="" ;

	patientID = request.getParameter("PatID") ;
    if(patientID.equals("null"))  patientID ="" ;

	StringBuffer ExeSQL = new StringBuffer();
		
	ExeSQL.append(" SELECT a.PATIENT_ENCOUNTER_ID,");
	ExeSQL.append(" a.LODGER_RELATION_CODE,");
	ExeSQL.append(" a.REASON_FOR_STAY_CODE,");
	ExeSQL.append(" a.LODGER_NAME,");
	ExeSQL.append(" to_char(a.check_in_date_time,'dd/mm/rrrr hh24:mi') CHECK_IN_DATE_TIME,");
	ExeSQL.append(" to_char(a.PERIOD_FROM_DATE,'dd/mm/rrrr hh24:mi') PERIOD_FROM_DATE,");
	ExeSQL.append(" to_char(a.PERIOD_TO_DATE,'dd/mm/rrrr hh24:mi') PERIOD_TO_DATE,");
	ExeSQL.append(" to_char(a.period_to_date+ (1 / 1440), 'dd/mm/rrrr hh24:mi') renewal_valid_from_date,");	ExeSQL.append("TO_CHAR(decode('"+gate_pass_unit+"','H',a.period_to_date+('"+gate_pass_period+"'/24),'D',a.period_to_date+'"+gate_pass_period+"'),'dd/mm/rrrr hh24:mi') renewal_valid_to_date,");
	ExeSQL.append(" a.ATTACHED_TO_INPATIENT_YN,");
	ExeSQL.append(" a.NURSING_UNIT_CODE,a.REMARKS,a.AUTHORISED_BY,a.LODGER_GENDER,");
	ExeSQL.append(" to_char(a.LODGER_DOB,'dd/mm/rrrr') LODGER_DOB,");
	ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),1)years, ");
	ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),2)months, ");
	ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),3)days, ");
	ExeSQL.append(" get_age(a.LODGER_DOB) Acc_person_age,");
	ExeSQL.append(" a.NAME_PREFIX, a.FIRST_NAME, a.SECOND_NAME, a.THIRD_NAME,");
	ExeSQL.append(" a.FAMILY_NAME, a.NAME_SUFFIX,");
	ExeSQL.append(" a.CITIZEN_YN, a.LEGAL_YN,");
	ExeSQL.append(" a.ALT_ID1_TYPE,a.ALT_ID1_NO,");
	ExeSQL.append(" to_char(a.ALT_ID1_EXP_DATE,'dd/mm/rrrr') ALT_ID1_EXP_DATE,");
	ExeSQL.append(" a.ALT_ID2_TYPE,a.ALT_ID2_NO,");
	ExeSQL.append(" to_char(a.ALT_ID2_EXP_DATE,'dd/mm/rrrr') ALT_ID2_EXP_DATE,");
	ExeSQL.append(" a.ALT_ID3_TYPE, a.ALT_ID3_NO,");
	ExeSQL.append(" to_char(a.ALT_ID3_EXP_DATE,'dd/mm/rrrr') ALT_ID3_EXP_DATE,");
	ExeSQL.append(" a.ALT_ID4_TYPE, a.ALT_ID4_NO,");
	ExeSQL.append(" to_char(a.ALT_ID4_EXP_DATE,'dd/mm/rrrr')ALT_ID4_EXP_DATE,");
	ExeSQL.append(" a.OTH_ALT_ID_TYPE OTH_ALT_ID_TYPE,");
	ExeSQL.append(" (CASE WHEN a.OTH_ALT_ID_TYPE IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(a.OTH_ALT_ID_TYPE,'"+locale+"',1)) END) alt_short_desc,");
	ExeSQL.append(" a.OTH_ALT_ID_NO OTH_ALT_ID_NO,");
	ExeSQL.append(" a.LN1_LODGER_ADD, a.LN2_LODGER_ADD,");
	ExeSQL.append(" a.LN3_LODGER_ADD, a.LN4_LODGER_ADD,");
	ExeSQL.append(" a.LODGER_RES_TEL_NUM, a.LODGER_OFF_TEL_NUM,"); 
	ExeSQL.append(" a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2,");
	ExeSQL.append(" a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4,");
	ExeSQL.append(" a.lodger_patient_id, a.national_id_no,");
	ExeSQL.append(" a.BIRTH_PLACE_CODE BIRTH_PLACE_CODE, (CASE WHEN a.BIRTH_PLACE_CODE IS NOT NULL THEN (mp_get_desc.MP_BIRTH_PLACE(a.BIRTH_PLACE_CODE,'"+locale+"',1)) END) birth_place_desc,");
	ExeSQL.append(" a.ETHNIC_GROUP_CODE, (CASE WHEN a.ETHNIC_GROUP_CODE IS NOT NULL THEN (mp_get_desc.MP_ETHNIC_GROUP(a.ETHNIC_GROUP_CODE,'"+locale+"',1)) END) ETHNIC_DESCRIPTION,");
	ExeSQL.append(" a.RACE_CODE, ");
	ExeSQL.append("(CASE WHEN a.race_code IS NOT NULL THEN (mp_get_desc.mp_race(a.race_code,'"+locale+"',1)) END) RACE_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_AREA_CODE MAIL_AREA_CODE, (CASE WHEN a.MAIL_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"',1)) END) MAIL_AREA_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_TOWN_CODE MAIL_TOWN_CODE, (CASE WHEN a.MAIL_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"',1)) END) MAIL_TOWN_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_REGION_CODE MAIL_REGION_CODE,  (CASE WHEN a.MAIL_REGION_CODE IS NOT NULL THEN (mp_get_desc.MP_REGION(a.MAIL_REGION_CODE,'"+locale+"',1)) END) MAIL_REGION_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_POSTAL_CODE MAIL_POSTAL_CODE, ");
	ExeSQL.append(" a.MAIL_COUNTRY_CODE, (CASE WHEN a.MAIL_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.MAIL_COUNTRY_CODE,'"+locale+"',1)) END) MAIL_COUNTRY_DESCRIPTION,");
	ExeSQL.append(" a.RES_AREA_CODE RES_AREA_CODE , (CASE WHEN a.RES_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.RES_AREA_CODE,'"+locale+"',1)) END) RES_AREA_DESCRIPTION,");
	ExeSQL.append(" a.RES_TOWN_CODE RES_TOWN_CODE, (CASE WHEN a.RES_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.RES_TOWN_CODE,'"+locale+"',1)) END) RES_TOWN_DESCRIPTION,");
	ExeSQL.append(" a.RES_REGION_CODE RES_REGION_CODE, (CASE WHEN a.RES_REGION_CODE IS NOT NULL THEN (mp_get_desc.MP_REGION(a.RES_REGION_CODE,'"+locale+"',1)) END) RES_REGION_DESCRIPTION,");
	ExeSQL.append(" a.RES_POSTAL_CODE RES_POSTAL_DESCRIPTION,");
	ExeSQL.append(" a.RES_COUNTRY_CODE, (CASE WHEN a.RES_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.RES_COUNTRY_CODE,'"+locale+"',1)) END) RES_COUNTRY_DESCRIPTION,");
	ExeSQL.append(" a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc,");//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
	ExeSQL.append(" a.LODGER_EMAIL,");
	ExeSQL.append(" (CASE WHEN a.NATIONALITY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.NATIONALITY_CODE,'"+locale+"',1)) END) NATIONALITY_DESC, a.NATIONALITY_CODE NATIONALITY_CODE");  
	ExeSQL.append("  , NAME_PREFIX_LOC_LANG ");
	ExeSQL.append("  , FIRST_NAME_LOC_LANG ");
	ExeSQL.append("  , SECOND_NAME_LOC_LANG ");
	ExeSQL.append("  , THIRD_NAME_LOC_LANG ");
	ExeSQL.append("  , FAMILY_NAME_LOC_LANG ");
	ExeSQL.append("  , NAME_SUFFIX_LOC_LANG ");
	ExeSQL.append("  , LODGER_NAME_LOC_LANG ");
	ExeSQL.append(" FROM ");
	ExeSQL.append(" ip_lodger_detail a");
	ExeSQL.append(" WHERE ");
	ExeSQL.append(" a.facility_id = '"+facility_id+"' AND");
	ExeSQL.append(" a.lodger_ref_no ='"+lodger_ref_no+"' "); 

	

    stmt = con.createStatement();
	rs = stmt.executeQuery(ExeSQL.toString());

	if(rs!=null)
	{
		if ( rs.next() )
		{
			Category = rs.getString("ATTACHED_TO_INPATIENT_YN") ; 
			if(Category.equals("Y"))
				Category = "A" ;
			else
				Category = "L" ;


			years	= rs.getString( "years" );
				if(years ==null)	years ="";
			months  = rs.getString( "months" );
				if(months ==null)	months ="";
			days    = rs.getString( "days" );
				if(days ==null)	days ="";

			encounter_id         = String.valueOf( rs.getLong("patient_encounter_id") );
			if(encounter_id ==null)	encounter_id ="";

			lodger_relation_code     = rs.getString( "lodger_relation_code" );
			if(lodger_relation_code ==null)	lodger_relation_code ="";

			reason_for_stay      = rs.getString( "reason_for_stay_code" );
			if(reason_for_stay ==null) 	reason_for_stay ="";

			lodger_patient_name  = rs.getString( "lodger_name" );
			if(lodger_patient_name ==null)	lodger_patient_name ="";

			check_in_date_time   = rs.getString( "check_in_date_time" );
			 if(check_in_date_time == null)  check_in_date_time = "";

			Period_date_time_from = rs.getString("PERIOD_FROM_DATE"); 
			if(Period_date_time_from == null)	Period_date_time_from = "";

			Period_date_time_to = rs.getString("PERIOD_TO_DATE"); 
			if(	Period_date_time_to == null)	Period_date_time_to = "";

			renewalValid_fr = rs.getString("renewal_valid_from_date"); 
			if(	renewalValid_fr == null)	renewalValid_fr = "";
			renewalValid_fr  = DateUtils.convertDate(renewalValid_fr,"DMYHM","en",locale);
			renewalValid_to = rs.getString("renewal_valid_to_date"); 
			if(	renewalValid_to == null)	renewalValid_to = "";
			renewalValid_to  = DateUtils.convertDate(renewalValid_to,"DMYHM","en",locale);
			
			if(!(check_in_date_time==null || check_in_date_time.equals("")))
				check_in_dis_dat_tim  = DateUtils.convertDate(check_in_date_time,"DMYHM","en",locale);
			if(!(Period_date_time_from==null || Period_date_time_from.equals("")))
				Period_dat_dis_tim_fr = DateUtils.convertDate(Period_date_time_from,"DMYHM","en",locale);
			if(!(Period_date_time_to==null || Period_date_time_to.equals("")))
				Period_dat_dis_tim_to = DateUtils.convertDate(Period_date_time_to,"DMYHM","en",locale);

			remarks   = rs.getString( "REMARKS" );
			if(remarks ==null)     remarks ="";
			if (!remarks.equals("")) 
			{
				if (remarks.length() == 200)
					remarks = remarks.substring(0,70)+"\n"+remarks.substring(71,140)+"\n"+remarks.substring(141,200);
				else if (remarks.length() > 140)
					remarks = 	remarks.substring(0,70)+"\n"+remarks.substring(71,140)+"\n"+remarks.substring(141,remarks.length());
				else if (remarks.length() > 70)
					remarks = remarks.substring(0,70)+"\n"+remarks.substring(71,remarks.length());	
			}
		
			authorized_by        = rs.getString( "authorised_by" );
			if(authorized_by ==null)		authorized_by ="";  

			gender       = rs.getString( "lodger_gender" );
			if(gender==null) gender="";

			Acc_person_age    = rs.getString("Acc_person_age");
			if(Acc_person_age==null) Acc_person_age="";

			date_of_birth    = rs.getString( "LODGER_DOB" );
			if(date_of_birth==null) date_of_birth = "";

			nameprefix= rs.getString( "NAME_PREFIX" );
			if(nameprefix==null) nameprefix = "";

			firstname= rs.getString( "FIRST_NAME" );
			if(firstname==null) firstname="";

			secondname= rs.getString( "SECOND_NAME");
			if(secondname==null) secondname="";

			thirdname= rs.getString( "THIRD_NAME" );
			if(thirdname==null) thirdname="";

			familyname = rs.getString( "FAMILY_NAME" );
			if(familyname == null) familyname = "";

			namesuffix= rs.getString( "NAME_SUFFIX" );
			if(namesuffix==null) namesuffix="";

			citizen = rs.getString("CITIZEN_YN");
			if(citizen == null) citizen = "";

			legal = rs.getString("LEGAL_YN");
			if(legal == null) legal = "";

			alt_id1_exp_date= rs.getString( "ALT_ID1_EXP_DATE");
			if(alt_id1_exp_date==null) alt_id1_exp_date="";

			if(!(alt_id1_exp_date==null || alt_id1_exp_date.equals("")))
				alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY","en",locale);

			alt_id2_exp_date= rs.getString( "ALT_ID2_EXP_DATE" );
			if(alt_id2_exp_date==null) alt_id2_exp_date="";

			if(!(alt_id2_exp_date==null || alt_id2_exp_date.equals("")))
				alt_id2_exp_date = DateUtils.convertDate(alt_id2_exp_date,"DMY","en",locale);


			alt_id3_exp_date= rs.getString( "ALT_ID3_EXP_DATE" );
			if(alt_id3_exp_date==null) alt_id3_exp_date="";

			if(!(alt_id3_exp_date==null || alt_id3_exp_date.equals("")))
				alt_id3_exp_date = DateUtils.convertDate(alt_id3_exp_date,"DMY","en",locale);


			alt_id4_exp_date= rs.getString( "ALT_ID4_EXP_DATE" );
			if(alt_id4_exp_date==null) alt_id4_exp_date="";

			if(!(alt_id4_exp_date==null || alt_id4_exp_date.equals("")))
				alt_id4_exp_date = DateUtils.convertDate(alt_id4_exp_date,"DMY","en",locale);


			alt_id1_no= rs.getString( "ALT_ID1_NO" );
			if(alt_id1_no==null) alt_id1_no="";

			alt_id2_no	= rs.getString( "ALT_ID2_NO" );
			if(alt_id2_no==null) alt_id2_no="";
			
			alt_id3_no= rs.getString( "ALT_ID3_NO" );
			if(alt_id3_no==null) alt_id3_no="";

			alt_id4_no= rs.getString( "ALT_ID4_NO" );
			if(alt_id4_no==null) alt_id4_no="";

			oth_alt_id_no = rs.getString( "OTH_ALT_ID_NO" );
			if(oth_alt_id_no==null) oth_alt_id_no = "";
			
			oth_alt_id_type = rs.getString( "OTH_ALT_ID_TYPE" );
			if(oth_alt_id_type == null) oth_alt_id_type = "";

			alt_long_desc = rs.getString( "alt_short_desc" );
			if(alt_long_desc == null) alt_long_desc = "";

			place_of_birth_desc = rs.getString( "birth_place_desc" );
			if(place_of_birth_desc == null) place_of_birth_desc = "";

			place_of_birth_code = rs.getString( "BIRTH_PLACE_CODE" );
			if(place_of_birth_code == null) place_of_birth_code = "";

			eth_grp= rs.getString( "ETHNIC_GROUP_CODE" );
			if(eth_grp==null) eth_grp="";

			eth_sub_grp= rs.getString( "RACE_DESCRIPTION" );
			if(eth_sub_grp==null) eth_sub_grp="";

			national_id_no= rs.getString( "NATIONAL_ID_NO" );
			if(national_id_no==null) national_id_no="";

			nationality_code = rs.getString( "NATIONALITY_CODE" );
			if(nationality_code==null) nationality_code="";


//++++++++++++++++++++++++ RESIDENCE ADDRESS DETAILS ++++++++++++++++++++++++++++

			res_addr_line1  = rs.getString( "LN1_LODGER_ADD" );
			if(res_addr_line1==null) res_addr_line1="";

			res_addr_line2  = rs.getString( "LN2_LODGER_ADD" );
			if(res_addr_line2==null) res_addr_line2="";

			res_addr_line3  = rs.getString( "LN3_LODGER_ADD" );
			if(res_addr_line3==null) res_addr_line3="";

			res_addr_line4  = rs.getString( "LN4_LODGER_ADD" );
			if(res_addr_line4==null) res_addr_line4="";
	
			res_town_code= rs.getString( "RES_TOWN_CODE" );
			if(res_town_code==null) res_town_code="";

			res_town_desc= rs.getString( "RES_TOWN_DESCRIPTION" );
			if(res_town_desc==null) res_town_desc="";

			res_area_code= rs.getString( "RES_AREA_CODE" );
			if(res_area_code==null) res_area_code="";

			res_area_desc= rs.getString( "RES_AREA_DESCRIPTION" );
			if(res_area_desc==null) res_area_desc="";

			res_region_code		= rs.getString("RES_REGION_CODE");
			if(res_region_code==null) res_region_code="";

			res_region_desc		= rs.getString("RES_REGION_DESCRIPTION");
			if(res_region_desc==null) res_region_desc="";

			postal_code= rs.getString( "RES_POSTAL_DESCRIPTION" );
			if(postal_code==null) postal_code="";

			country_code= rs.getString( "RES_COUNTRY_DESCRIPTION" );
			if(country_code==null) country_code="";

//++++++++++++++++++++++++ MAILING ADDRESS DETAILS ++++++++++++++++++++++++++++

			mail_addr_line1= rs.getString( "MAIL_ADDR_LINE1" );
			if(mail_addr_line1==null) mail_addr_line1="";

			mail_addr_line2= rs.getString( "MAIL_ADDR_LINE2" );
			if(mail_addr_line2==null) mail_addr_line2="";

			mail_addr_line3= rs.getString( "MAIL_ADDR_LINE3" );
			if(mail_addr_line3==null) mail_addr_line3="";

			mail_addr_line4= rs.getString( "MAIL_ADDR_LINE4" );
			if(mail_addr_line4==null) mail_addr_line4="";

			mail_town_code		= rs.getString("MAIL_TOWN_CODE");
			if(mail_town_code==null) mail_town_code="";

			mail_town_desc		= rs.getString("MAIL_TOWN_DESCRIPTION");
			if(mail_town_desc==null) mail_town_desc="";

			mail_area_code		= rs.getString("MAIL_AREA_CODE");
			if(mail_area_code==null) mail_area_code="";

			mail_area_desc		= rs.getString("MAIL_AREA_DESCRIPTION");
			if(mail_area_desc==null) mail_area_desc="";

			mail_region_code	= rs.getString("MAIL_REGION_CODE");
			if(mail_region_code==null) mail_region_code="";

			mail_region_desc	= rs.getString("MAIL_REGION_DESCRIPTION");
			if(mail_region_desc==null) mail_region_desc="";

			mail_postal_code	= rs.getString("MAIL_POSTAL_CODE");
			if(mail_postal_code==null) mail_postal_code="";

			mail_country_code	= rs.getString("MAIL_COUNTRY_CODE");
			if(mail_country_code==null) mail_country_code="";

			mail_country_desc	= rs.getString("MAIL_COUNTRY_DESCRIPTION");
			if(mail_country_desc==null) mail_country_desc="";

			oth_contact_no       = rs.getString( "lodger_off_tel_num" );
			if(oth_contact_no ==null)		oth_contact_no ="";  

			other_tel_no       = rs.getString( "lodger_res_tel_num" );
			if(other_tel_no ==null)		other_tel_no ="";  

			email_id= rs.getString( "LODGER_EMAIL" );
			if(email_id==null) email_id="";

			/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(rs.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(rs.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(rs.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(rs.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(rs.getString("alt_area_code"));
			alt_area_desc		= checkForNull(rs.getString("alt_area_desc"));
			alt_town_code		= checkForNull(rs.getString("alt_town_code"));
			alt_town_desc		= checkForNull(rs.getString("alt_town_desc"));
			alt_region_code		= checkForNull(rs.getString("alt_region_code"));
			alt_region_desc		= checkForNull(rs.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(rs.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(rs.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(rs.getString("alt_country_code"));
			alt_country_desc	= checkForNull(rs.getString("alt_country_desc"));
			/*End*/


			name_prefix_loc_lang	= checkForNull(rs.getString("name_prefix_loc_lang"));
			first_name_loc_lang		= checkForNull(rs.getString("first_name_loc_lang"));
			second_name_loc_lang	= checkForNull(rs.getString("second_name_loc_lang"));
			third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang"));
			family_name_loc_lang	= checkForNull(rs.getString("family_name_loc_lang"));
			name_suffix_loc_lang	= checkForNull(rs.getString("name_suffix_loc_lang"));
			patient_name_loc_lang	= checkForNull(rs.getString("lodger_name_loc_lang"));
		}//E.o RS
	}// E.o RS !null
}
%>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='BlockLodgerForm' id='BlockLodgerForm' method='post' action='../../servlet/eIP.BookLodgerServlet' target='messageFrame'>
	<input type="hidden" name="hddCitizen" id="hddCitizen" value="<%=citizen%>" >
	<input type="hidden" name="hddLegal" id="hddLegal" value="<%=legal%> ">
	<input type="hidden" name="hddRenewUnit" id="hddRenewUnit" value="<%=gate_pass_unit%>" >
	

<table border="0" cellspacing="0" cellpadding="3" width="100%" align='center'>
	<tr>
	   <%if(Category.equals("A")){
	   out.println( "<td colspan='4' align='left' class=\"COLUMNHEADER\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonDetails.label","ip_labels")+"</td>" ) ;
	   }else{
	   out.println( "<td colspan='4'class= \"COLUMNHEADER\" align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.LodgerDetails.label","ip_labels")+"</td>" ) ;
	   }
	%>
	</tr>
<!--  ADDED TO DISPLAY [ ACCOMPANYING DETAILS ] FRAME FROM eMP -->
<!--  ADDED BY SRIDHAR ON 17 FEB 2004 -->
	<tr> 
		<td colspan='4'> 
<%
	if(mode.equals("insert"))
	{
%>
		<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="function_id" value= "RENEW_GATE_PASS" />
			<jsp:param name ="lodger_relation_code" value= "<%=lodger_relation_code%>" />
			<jsp:param name ="patient_id" value= "" /> 	
			<jsp:param name ="alert_reqd_yn" value= "Y" /> 	
			<jsp:param name ="readonly_yn" value= "Y" /> 		
			<jsp:param name ="bodyFrame" value= "top.frames[0]" /> 	
			<jsp:param name ="submitFrame" value= "top.frames[1]" /> 	
		</jsp:include>
<%	}
	else
	{
%>		<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="function_id" value= "CHECK_IN_ACCMP_PERSON" /> 	
			<jsp:param name ="lodger_relation_code" value= "<%=lodger_relation_code%>" />
			<jsp:param name ="patient_id" value= "" /> 	
			<jsp:param name ="alert_reqd_yn" value= "Y" /> 	
			<jsp:param name ="readonly_yn" value= "Y" /> 		
			<jsp:param name ="bodyFrame" value= "top.frames[0]"  /> 	
			<jsp:param name ="submitFrame" value= "top.frames[1]"  />   
		</jsp:include>
<%	}
%>
		<input type='hidden' name='ageschk' id='ageschk' value= "<%=Acc_person_age%>">
		</td>  
	</tr>   
</table>

<!-- ADDED FOR LOCALLY ASIGNING THE VALUES TO THE MP FORM IN THE UPDATE MODE  -->
<!-- ADDED BY SRIDHAR ON 9th FEB 2004   -->

<%
if(!mode.equals("insert"))
{	%>
  <script>
		document.BlockLodgerForm.patient_id.value 	= "<%=patientID%>";
		document.BlockLodgerForm.patient_id.disabled = true;
		document.BlockLodgerForm.search.disabled = true;

		document.getElementById("patient_name1").innerHTML = "<%=lodger_patient_name%>";
		document.getElementById("patient_name1").disabled = true; 

		/*if(document.BlockLodgerForm.name_prefix1)
		{
			document.BlockLodgerForm.name_prefix1.value		= "<%=nameprefix%>";
			document.BlockLodgerForm.name_prefix1.disabled	= true;
		}*/
		
		if(document.BlockLodgerForm.name_prefix)
		{
			document.BlockLodgerForm.name_prefix.value		= "<%=nameprefix%>";
			document.BlockLodgerForm.name_prefix.disabled	= true;
		}

		if(document.BlockLodgerForm.family_name)
		{
			document.BlockLodgerForm.family_name.value 	= "<%=familyname%>";
			document.BlockLodgerForm.family_name.disabled = true;
			if(document.BlockLodgerForm.bfam)
			document.BlockLodgerForm.bfam.disabled = true;
		}

		if(document.BlockLodgerForm.first_name)
		{
			document.BlockLodgerForm.first_name.value 	= "<%=firstname%>";
			document.BlockLodgerForm.first_name.disabled = true;
			if(document.BlockLodgerForm.bf)
			document.BlockLodgerForm.bf.disabled = true;
		}

		if(document.BlockLodgerForm.second_name)
		{
			document.BlockLodgerForm.second_name.value 	= "<%=secondname%>";
			document.BlockLodgerForm.second_name.disabled = true;
			if(document.BlockLodgerForm.bs)
			document.BlockLodgerForm.bs.disabled = true;
		}

		if(document.BlockLodgerForm.third_name)
		{
			document.BlockLodgerForm.third_name.value 	= "<%=thirdname%>";
			document.BlockLodgerForm.third_name.disabled = true;
			if(document.BlockLodgerForm.bt)
			document.BlockLodgerForm.bt.disabled = true;
		}

		/*if(document.BlockLodgerForm.name_suffix1)
		{
			document.BlockLodgerForm.name_suffix1.value 	= "<%=namesuffix%>";
			document.BlockLodgerForm.name_suffix1.disabled = true;
		}*/

		if(document.BlockLodgerForm.name_suffix)
		{
			document.BlockLodgerForm.name_suffix.value 	= "<%=namesuffix%>";
			document.BlockLodgerForm.name_suffix.disabled = true;
		}

		if(document.BlockLodgerForm.name_prefix_oth_lang)
	    {
			document.BlockLodgerForm.name_prefix_oth_lang.value 	= "<%=name_prefix_loc_lang%>";
			document.BlockLodgerForm.name_prefix_oth_lang.disabled = true;
		}

		if(document.BlockLodgerForm.first_name_oth_lang)
	    {
			document.BlockLodgerForm.first_name_oth_lang.value 	= "<%=first_name_loc_lang%>";
			document.BlockLodgerForm.first_name_oth_lang.disabled = true;
			if(document.BlockLodgerForm.bfo)
			document.BlockLodgerForm.bfo.disabled = true;
		}

		if(document.BlockLodgerForm.second_name_oth_lang)
	    {
			document.BlockLodgerForm.second_name_oth_lang.value 	= "<%=second_name_loc_lang%>";
			document.BlockLodgerForm.second_name_oth_lang.disabled = true;
			if(document.BlockLodgerForm.bso)
			document.BlockLodgerForm.bso.disabled = true;
		}

		if(document.BlockLodgerForm.third_name_oth_lang)
	    {
			document.BlockLodgerForm.third_name_oth_lang.value 	= "<%=third_name_loc_lang%>";
			document.BlockLodgerForm.third_name_oth_lang.disabled = true;
			if(document.BlockLodgerForm.bto)
			document.BlockLodgerForm.bto.disabled = true;
		}

		if(document.BlockLodgerForm.family_name_oth_lang)
	    {
			document.BlockLodgerForm.family_name_oth_lang.value 	= "<%=family_name_loc_lang%>";
			document.BlockLodgerForm.family_name_oth_lang.disabled = true;
			if(document.BlockLodgerForm.bfamo)
			document.BlockLodgerForm.bfamo.disabled = true;
		}

		if(document.BlockLodgerForm.name_suffix_oth_lang)
	    {
			document.BlockLodgerForm.name_suffix_oth_lang.value 	= "<%=name_suffix_loc_lang%>";
			document.BlockLodgerForm.name_suffix_oth_lang.disabled = true;
		}

		document.getElementById("patient_name_local_lang1").innerText 	= "<%=patient_name_loc_lang%>";
		document.BlockLodgerForm.patient_name_local_lang.value 	= "<%=patient_name_loc_lang%>";

		document.BlockLodgerForm.sex.value 	= "<%=gender%>";
		document.BlockLodgerForm.sex.disabled = true;

		var ages = "<%=Acc_person_age%>";

		//// Alternative for date of bith ...using sql function...
		document.BlockLodgerForm.b_age.value	= "<%=years%>";
		document.BlockLodgerForm.b_months.value	= "<%=months%>";
		document.BlockLodgerForm.b_days.value	= "<%=days%>";

		if(document.BlockLodgerForm.b_birth)
			document.BlockLodgerForm.b_birth.disabled = true;

		if(document.getElementById("dob"))
			document.getElementById("dob").disabled = true;

		if(document.BlockLodgerForm.b_age)
		{
			document.BlockLodgerForm.b_age.disabled = true;
			document.BlockLodgerForm.b_months.disabled = true;
			document.BlockLodgerForm.b_days.disabled = true;
		}
		document.BlockLodgerForm.national_id_no.value 	= "<%=national_id_no%>";
		document.BlockLodgerForm.national_id_no.disabled =true;

		if(document.BlockLodgerForm.myKadBtn)
		{			
			document.BlockLodgerForm.myKadBtn.disabled = true;
		}

		if(document.BlockLodgerForm.alt_id1_no)
		{
			document.BlockLodgerForm.alt_id1_no.value 	= "<%=alt_id1_no%>";
			document.BlockLodgerForm.alt_id1_no.disabled = true;
		}
		if(document.BlockLodgerForm.alt_id2_no)
		{
			document.BlockLodgerForm.alt_id2_no.value 	= "<%=alt_id2_no%>";
			document.BlockLodgerForm.alt_id2_no.disabled = true;
		}
		if(document.BlockLodgerForm.alt_id3_no)
		{
			document.BlockLodgerForm.alt_id3_no.value 	= "<%=alt_id3_no%>";
			document.BlockLodgerForm.alt_id3_no.disabled = true;
		}
		if(document.BlockLodgerForm.alt_id4_no)
		{
			document.BlockLodgerForm.alt_id4_no.value 	= "<%=alt_id4_no%>";
			document.BlockLodgerForm.alt_id4_no.disabled = true;
		}
		if(document.BlockLodgerForm.alt_id1_exp_date)
		{
			document.BlockLodgerForm.alt_id1_exp_date.value 	= "<%=alt_id1_exp_date%>";
			document.BlockLodgerForm.alt_id1_exp_date.disabled = true;
		}
		
		if(document.BlockLodgerForm.alt_id2_exp_date)
		{
			document.BlockLodgerForm.alt_id2_exp_date.value 	= "<%=alt_id2_exp_date%>";
			document.BlockLodgerForm.alt_id2_exp_date.disabled = true;
		}
		if(document.BlockLodgerForm.alt_id3_exp_date)
		{	
			document.BlockLodgerForm.alt_id3_exp_date.value = "<%=alt_id3_exp_date%>";
			document.BlockLodgerForm.alt_id3_exp_date.disabled = true;
		}
		if(document.BlockLodgerForm.alt_id4_exp_date)
		{
			document.BlockLodgerForm.alt_id4_exp_date.value = "<%=alt_id4_exp_date%>";
			document.BlockLodgerForm.alt_id4_exp_date.disabled = true;
		}

		if(document.BlockLodgerForm.other_alt_type)
		{
			document.BlockLodgerForm.other_alt_type.value = "<%=oth_alt_id_type%>";
			document.BlockLodgerForm.other_alt_type.disabled = true;
		}

		if(document.BlockLodgerForm.other_alt_Id)
		{
			document.BlockLodgerForm.other_alt_Id.value = "<%=oth_alt_id_no%>";
			document.BlockLodgerForm.other_alt_Id.disabled = true;
		}

		// ================== Patient contact details popup ================ 
		// to diable the Contact Detail Button
		//	document.BlockLodgerForm.contact_details.disabled = true;

		document.BlockLodgerForm.addr_line1.value="<%=res_addr_line1%>";
		document.BlockLodgerForm.addr_line1.disabled = true;

		document.BlockLodgerForm.addr_line2.value="<%=res_addr_line2%>";
		document.BlockLodgerForm.addr_line2.disabled = true;

		document.BlockLodgerForm.addr_line3.value="<%=res_addr_line3%>";
		document.BlockLodgerForm.addr_line3.disabled = true;

		document.BlockLodgerForm.addr_line4.value="<%=res_addr_line4%>";
		document.BlockLodgerForm.addr_line4.disabled = true;

		document.BlockLodgerForm.res_town_code.value="<%=res_town_code%>";
		document.BlockLodgerForm.res_town_desc.value="<%=res_town_desc%>";

		document.BlockLodgerForm.res_area_code.value="<%=res_area_code%>";
		document.BlockLodgerForm.res_area_desc.value="<%=res_area_desc%>";

		document.BlockLodgerForm.region_code.value="<%=res_region_code%>";
		document.BlockLodgerForm.region_desc.value="<%=res_region_desc%>";		

		document.BlockLodgerForm.postal_code.value="<%=postal_code%>";

		document.BlockLodgerForm.country_desc.value="<%=country_code%>";

		document.BlockLodgerForm.contact1_name.value="";

		document.BlockLodgerForm.addr2_type.value="";

		document.BlockLodgerForm.mail_addr_line1.value="<%=mail_addr_line1%>";
		document.BlockLodgerForm.mail_addr_line1.disabled = true;

		document.BlockLodgerForm.mail_addr_line2.value="<%=mail_addr_line2%>";
		document.BlockLodgerForm.mail_addr_line2.disabled = true;

		document.BlockLodgerForm.mail_addr_line3.value="<%=mail_addr_line3%>";
		document.BlockLodgerForm.mail_addr_line3.disabled = true;

		document.BlockLodgerForm.mail_addr_line4.value="<%=mail_addr_line4%>";
		document.BlockLodgerForm.mail_addr_line4.disabled = true;

		document.BlockLodgerForm.mail_res_town_code.value="<%=mail_town_code%>";
		document.BlockLodgerForm.mail_res_town_desc.value="<%=mail_town_desc%>";
		
		document.BlockLodgerForm.mail_res_area_code.value="<%=mail_area_code%>";
		document.BlockLodgerForm.mail_res_area_desc.value="<%=mail_area_desc%>";
		
		document.BlockLodgerForm.mail_postal_code.value="<%=mail_postal_code%>";

		document.BlockLodgerForm.mail_region_code.value="<%=mail_region_code%>";
		document.BlockLodgerForm.mail_region_desc.value="<%=mail_region_desc%>";
		document.BlockLodgerForm.mail_region_desc.readOnly = true; 

		document.BlockLodgerForm.mail_country_code.value="<%=mail_country_code%>";
		document.BlockLodgerForm.mail_country_desc.value="<%=mail_country_desc%>";
		document.BlockLodgerForm.contact2_name.value='';
		document.BlockLodgerForm.contact1_no.value="<%=other_tel_no%>";
		document.BlockLodgerForm.contact2_no.value="<%=oth_contact_no%>";
		document.BlockLodgerForm.email.value="<%=email_id%>";

		/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
		document.BlockLodgerForm.alt_addr_line1.value	= "<%=alt_addr_line1%>";
		document.BlockLodgerForm.alt_addr_line1.disabled = true;
		document.BlockLodgerForm.alt_addr_line2.value	= "<%=alt_addr_line2%>";
		document.BlockLodgerForm.alt_addr_line2.disabled = true;
		document.BlockLodgerForm.alt_addr_line3.value	= "<%=alt_addr_line3%>";
		document.BlockLodgerForm.alt_addr_line3.disabled = true;
		document.BlockLodgerForm.alt_addr_line4.value	= "<%=alt_addr_line4%>";
		document.BlockLodgerForm.alt_addr_line4.disabled = true;
		document.BlockLodgerForm.alt_area_code.value		= "<%=alt_area_code%>";
		document.BlockLodgerForm.alt_area_desc.value		= "<%=alt_area_desc%>";
		document.BlockLodgerForm.alt_town_code.value		= "<%=alt_town_code%>";
		document.BlockLodgerForm.alt_town_desc.value		= "<%=alt_town_desc%>";
		document.BlockLodgerForm.alt_postal_code.value	= "<%=alt_postal_code%>";
		document.BlockLodgerForm.alt_postal_desc.value	= "<%=alt_postal_desc%>";
		document.BlockLodgerForm.alt_region_code.value	= "<%=alt_region_code%>";
		document.BlockLodgerForm.alt_region_desc.value	= "<%=alt_region_desc%>";
		document.BlockLodgerForm.alt_country_code.value	= "<%=alt_country_code%>";
		document.BlockLodgerForm.alt_country_desc.value	= "<%=alt_country_desc%>";
		/*End*/

</script>

<table border="0" cellspacing="0" cellpadding="4" width="100%" align='center'>
	<tr><td colspan='4' align='left' class= "COLUMNHEADER"><fmt:message key="eIP.CurrentValidityDetails.label" bundle="${ip_labels}"/></td></tr>
	<input type='hidden' name='PeriodToVal' id='PeriodToVal' value="<%=Period_date_time_to%>">	
	<tr>
		<td class="label" width="20%"><fmt:message key="eIP.CheckInDateTime.label" bundle="${ip_labels}"/></td>
		<td class='QUERYDATA' width="30%"><%=check_in_dis_dat_tim%></td>
		<td width="25%" class="label"><fmt:message key="Common.nursingUnit.label"  bundle="${common_labels}"/></td>  
		<td width="25%" class='QUERYDATA'><%=nursing_desc%></td>
	</tr>
	<tr>
		<!-- PERIOD FROM --> 
		<td class="label"><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td nowrap class='QUERYDATA' ><%=Period_dat_dis_tim_fr%></td>  
		<td class="label"><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'><%=Period_dat_dis_tim_to%><input type="hidden" name="gate_pass_period" id="gate_pass_period" value="<%=gate_pass_period%>" ></td>
		
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'><%=remarks%></td>
		<td class="label"><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'><%=authorized_by%></td>
	</tr>

	<tr><td align='left' colspan='4' class= "COLUMNHEADER"><fmt:message key="eIP.RenewalValidityDetails.label" bundle="${ip_labels}"/></td></tr>
	<tr>
		<td class="label"><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<!--<input type="text" id='reviseperiodfrom' name="revise_period_from" id="revise_period_from" maxlength=16 size=16 value ="<%=Period_date_time_to%>" onblur="compareDate(this,PeriodToVal);CompareReviseTime(this,revise_period_to);" > -->
			
			<input type="text" id='reviseperiodfrom' name="revise_period_from" id="revise_period_from" maxlength=16 size=16 value ="<%=renewalValid_fr%>" onblur="compareDate(this,PeriodToVal);" ><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].revise_period_from.focus();return showCalendar('reviseperiodfrom',null,'hh:mm');"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
		<td class="label"><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<!--<input type="text" id='reviseperiodto' name="revise_period_to" id="revise_period_to" maxlength=16 size=16 onblur="CompareReviseTime(revise_period_from,this);" value ="<%=Period_date_time_to%>" >-->
		
		<input type="text" id='reviseperiodto' name="revise_period_to" id="revise_period_to" maxlength=16 size=16 onblur="CompareReviseTime(revise_period_from,this);" value ="<%=renewalValid_to%>" ><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].revise_period_to.focus();return showCalendar('reviseperiodto',null,'hh:mm');"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
	</tr>

	<tr>
		<td class="label" ><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="Authorised_lookup" id="Authorised_lookup" maxlength=16 size=16 value="" onBlur='beforeGetAuthorised(document.forms[0].Authorised_hid,this);enableDisable(this,Authorised_text);'><input type=button class=button name='search_Authorised' id='search_Authorised' value='?' onclick="getAuthoriser(document.forms[0].Authorised_hid,document.forms[0].Authorised_lookup)"><img src='../../eCommon/images/mandatory.gif'align='center'></img><input type="text" name="Authorised_text" id="Authorised_text" maxlength=16 size=16 value="" onBlur='makeValidString(this);enableDisable(Authorised_lookup,this);'><input type=hidden name="Authorised_hid" id="Authorised_hid" value=''></td>
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='2'><textarea style="resize:none" name="ReviseRemarks" rows="4" cols="50" maxLength='200' onKeypress="return CheckMaxLength(this,200);" onBlur="checkMax(this);"></textarea></td>        
		<td valign="bottom" class='fields'><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.renewgatepass.label","ip_labels")%>' name='Revise' class='button' onClick="SubmitPage()"><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='cancel' class='button' onclick='parent.parent.document.getElementById("dialog_tag").close();'>
		</td>

	</tr>     
		
		<input type="hidden" name="ReviseGatePass" id="ReviseGatePass" value="PASS">		

<% } %>
  </table>
        <input type="hidden" name='locale' id='locale' value = "<%=locale%>"> 
		<input type="hidden" name='Category' id='Category' value = "<%=Category%>"> 
		<input type="hidden" name='lodger_ref_no' id='lodger_ref_no' value = "<%=lodger_ref_no%>"> 
		<input type="hidden" name='encounter_id' id='encounter_id' value = "<%=encounter_id%>"> 
		<input type="hidden" name="to_chk_in_dt_time" id="to_chk_in_dt_time" maxlength=16 size=16 onblur="dateVal(this)" value ="<%=currDate%>"> 
		<input type='hidden' name='mode' id='mode' value= "<%=mode%>">
		<input type='hidden' name='label' id='label' value= "<%=label%>">
		<input type='hidden' name='facility_id' id='facility_id' value= "<%=facility_id%>">

</form>
<%
}catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();
	}
finally
{
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (ParamRS != null) ParamRS.close();
	if (ParamStmt != null) ParamStmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

