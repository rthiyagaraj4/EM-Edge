<!DOCTYPE html>
<%
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckInLodger && Lodger -> CheckOutLodger
/// Developer		:	SRIDHAR R
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
    <head>
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
        <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
        
        <script src='../../eCommon/js/dchk.js' language='javascript'></script>
        <script src='../js/BookLodger.js' language='javascript'></script>
        <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
        <script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>


function SubmitPage()
{
	var chk_out_dt_time =document.forms[0].chk_out_dt_time.value;

	if (parseInt(chk_out_dt_time.length) <= 0 )
	{
		var error = getMessage('CAN_NOT_BE_BLANK','common');
		error = error.replace('$',getLabel("eIP.checkoutdatetime.label","IP"));
		alert(error);						
		document.forms[0].chk_out_dt_time.focus();
	}
	else
	{
		document.forms[0].submit();
	}
}



// Function will check for empty values before calling up the common lookup func..
function beforeGetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
		if(document.forms[0].nursing_unit_desc.value != "")
			getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID);
}


//// CODED ON 21 FEB 2004 BY SRIDHAR 
//// FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
//// Func will return an alert message if TO DATE is Less than FROM DATE
function ComparePeriodTime(from,to)
{
	if(to.value == '' || to.value == '')
		return ;
	else
	{
		if(to.value != '' )
		{
			if(!doDateTimeChk(to))
				{
					alert( getMessage("INVALID_DATE_TIME","SM") );
					to.focus();
					to.select();
					return ;
				}
		}

		if(from.value != '' )
		{
			if(!doDateTimeChk(from))
				{
					alert( getMessage("INVALID_DATE_TIME","SM") );
					from.focus();
					from.select();
					return ;
				}
			var frdt = from.value;
			var tdt = to.value;

			PeriodcheckDateTime(frdt,tdt);
		}
		else
			return ;
	}
}


function PeriodcheckDateTime(obj1,obj2)
{	
	var a=obj1.split(" ")
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
		alert( getMessage("TO_DT_GR_EQ_FM_DT","SM") );
		document.forms[0].period_to.focus();
		document.forms[0].period_to.select();
		return false;
	}
	else
	{
		var Category = document.forms[0].Category.value;
		if(Category == 'A')
		{
			var discharge_period = document.forms[0].Acc_Disc_Period;
			var discharge_period_unit = document.forms[0].Acc_Disc_Period_unit;
		}
		else if(Category == 'L')
		{
			var discharge_period = document.forms[0].Lodger_Disc_Period;
			var discharge_period_unit = document.forms[0].Lodger_Disc_Period_unit;
		}

		ValidateDischargeDateTime(obj1,obj2,discharge_period,discharge_period_unit )
	}	
}	
/* END OF PERIOD VALIDTION */


//// CODED ON 17 MAY 2004 BY SRIDHAR 
//// Func will test the Period To value with Maximum Period of Stay after Discharge from IP param & return an alert message if TO DATE is greated than Discharge Time..
function ValidateDischargeDateTime(from, to, discharge_period, unit)
{	
	if(discharge_period.value != "")
	{
		var prefDateTime = from;
		var retval = true;
		
		var a =  from.split(" ")
		splitdate=a[0];
		splittime=a[1];
		var splitdate1 =a[0].split("/");
		var splittime1= a[1].split(":");

		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		a = to.split(" ")
		splitdate=a[0];
		splittime=a[1];
		splitdate1 =a[0].split("/");
		splittime1= a[1].split(":");

		var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	
		if(unit.value == 'D')
		{
			var expDaysofStay = discharge_period.value;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH criteria='Days' prefDateTime=\""+prefDateTime+"\" expDaysofStay=\""+expDaysofStay+"\" /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ValidateRenewPeriod.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)

		}
		else if(unit.value == 'H')
		{
			var expHoursofStay = discharge_period.value;
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
			var Category = document.forms[0].Category.value;
			if(Category == 'A')
			{
				var error	= getMessage("LODGER_PERIOD_CHECK","IP") ;
				error		= error.replace("Lodger", getLabel("eIP.AccompanyingPerson.label","IP"));
				alert(error);
			}
			else if(Category == 'L')
			{
				alert( getMessage("LODGER_PERIOD_CHECK","IP") );
			}

			document.forms[0].period_to.focus();
			document.forms[0].period_to.select();
			retval = false;
			return retval
		}
	   return retval
	}
}


//// CODED ON 23 FEB 2004 BY SRIDHAR 
//// FUNC USED TO COMPARE [PERIOD FROM DATE TIME] WITH [CHECK IN DATE TIME] 
//// Func will return an alert message if FROM DATE is Less than CHDCKIN DATE
function CompareCheckInTime(from,to)
{
	var str = new Object(from.value);
	if(from.value != '' && to.value != '')
	{
		if(!doDateTimeChk(from))
		{
			from.focus();
			from.select();
			alert( getMessage("INVALID_DATE_TIME","SM") );
			return;
		}
		else
		if(!doDateTimeChk(to))
		{
			to.focus();
			to.select();
			alert( getMessage("INVALID_DATE_TIME","SM") );
			return;
		}

	CheckInDateTime(from.value,to.value);
	}
	else return;
}

function CheckInDateTime(obj1,obj2)
{	
	var a=obj1.split(" ")
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
		alert(getMessage("PR_GT_CHK_DT","IP"));
		document.forms[0].period_from.focus();
		document.forms[0].period_from.select();
		return false;
	}
	else
	{
		return true;
	}	
}	
/* END OF PERIOD VALIDTION */

function localValidations(obj)
{}


function CompareCheckTime(Obj)
{
	var dateTo=Obj;
	var dateFrom=document.forms[0].period_from;
	if(!doDateCheckAlert(dateTo,dateFrom))
	{
		alert(getMessage("PR_GT_CHK_DT","IP"));
		document.forms[0].period_from.focus();
		document.forms[0].period_from.select();
	}
}	

//// FUNC USED TO COMPARE [CHECK IN DATE TIME] WITH [SYSTEM DATE]
//// Func will return an alert message if CheckinTime is Less than System date
function CompareCheckinTime(obj,sysdateTime)
{
	var str = new Object(obj.value);
	if(obj.value !=	'' )
	{
		if(!doDateTimeChk(obj))
			{
				obj.focus();
				obj.select();
				alert( getMessage("INVALID_DATE_TIME","SM") );
				return;
			}
				checkDateTime(obj.value,sysdateTime);
	}
	else return;
}


function checkDateTime(from,to)
{	
	var a = from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	 a=  to.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")

	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	 if(Date.parse(to_date) > Date.parse(from_date))
	{
		alert(getMessage("CHKIN_TIME_GR_SYSDATE","IP"));
//		("Check-In Date Time should be Greater than System Time");
		document.forms[0].chk_in_dt_time.focus();
		document.forms[0].chk_in_dt_time.select();

		return false
	}
	else
	{
		return true;
	}	
}	
/* End of check in time validation*/

function compareDate(obj,checkinTimeObj,sysdateTime)
{
	var str = new Object(obj.value);
	if(obj != null && checkinTimeObj != null)
	{
		if(obj.value !=	'' )
		{
			if(!doDateTimeChk(obj))
			{
				obj.focus();
				obj.select();
				alert( getMessage("INVALID_DATE_TIME","SM") );
				return;
			}
			if(!ValidateDateTime(checkinTimeObj,obj))
			{
				alert(getMessage("CHKOUT_TIME_GT_CHKIN_TIME","IP"));
				obj.focus();
				obj.select();
			}
			else
				checkOutDateTime(obj.value,sysdateTime);
		}
		else return;
	}
}


function checkOutDateTime(from,to)
{	
	var a = from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	 a=  to.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")

	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	 if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert(getMessage("CHKOUT_TIME_SH_LESS_SYSTIME","IP"));
		document.forms[0].chk_out_dt_time.focus();
		document.forms[0].chk_out_dt_time.select();
		return false ; 
	}
	else
	{
		return true ;
	}	
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
            String facility_id = (String)session.getValue ( "facility_id" ) ;
			String p_oper_stn_id="";
			String loginUser = (String)session.getValue("login_user");

            Connection con = null;

			Statement PatIDStmt = null;
			ResultSet PatIDRS	= null ;			
			Statement stmt		= null;
            ResultSet rs		= null ;
			Statement stmt_opn	= null;
			ResultSet rs_opn	= null;
			Statement ParamStmt = null;
            ResultSet ParamRS	= null ;

            String encounter_id = request.getParameter("EncounterId");
            if(encounter_id ==null)
                encounter_id="";

            String Category = request.getParameter("Category");
            if(Category == null)
                Category = "L" ;
			
			String pat_id = request.getParameter("lodger_patient_id");
            if(pat_id ==null)    pat_id="";

/*DECLARATION OF VARIABLES */
			
			String lodger_patient_name	= "" ;
			String reason_for_stay		= "";
			String alt_long_desc		= "";
			String check_in_date_time	= "";
			String Period_date_time_from= "";
			String Period_date_time_to	= "";
			String authorized_by		= "";  
			String nursing_desc			="";
			String patientID			= "";
			String sql					="";
			String rdonly				="";
			String disabled				=""; 
			String sysdateTime			= "";
			String lodger_ref_no		= "";			
			String remarks				= "";                			
			String patient_id			= "";
			String lodger_relation_code ="";
			String pat_name_as_multipart_yn = "";
			String nameprefix		= "";
			String firstname		= "";
			String secondname		="";
			String thirdname		= "";
			String familyname		= "";
			String namesuffix		= "";
			String gender			= "";
			String date_of_birth	= "";
			String place_of_birth_code = "";
			String place_of_birth_desc = "";
			String citizen			= "";
			String legal			= "";
			String email_id			= "";
			String national_id_no	= "";
			String alt_id1_no		= "";
			String alt_id2_no		= "";
			String alt_id3_no		= "";
			String alt_id4_no		= "";
			String oth_alt_id_no	= ""; 
			String oth_alt_id_type	= "";
			String res_addr_line1	= "";
			String res_addr_line2	= "";
			String res_addr_line3	= "";
			String res_addr_line4	= "";
			String res_town_code	= "";
			String res_town_desc	= "";
			String res_area_code	= "";
			String res_area_desc	= "";
			String res_region_code	= "";
			String res_region_desc	= "";
			String postal_code		= "";
			String country_code		= "";
			String mail_addr_line1	= "";
			String mail_addr_line2	= "";
			String mail_addr_line3	= "";
			String mail_addr_line4	= "";
			String mail_country_code= "";
			String mail_country_desc= "";
			String mail_town_code	= "";
			String mail_town_desc	= "";
			String mail_area_code	= "";
			String mail_area_desc	= "";
			String mail_region_code	= "";	
			String mail_region_desc	= "";
			String mail_postal_code	= "";
			String other_tel_no		= "";
			String oth_contact_no	= "";
			String eth_grp			= "";
			String eth_sub_grp		= "";
			String nationality_code = "";
			String alt_id1_exp_date = "";
			String alt_id2_exp_date = "";
			String alt_id3_exp_date = "";
			String alt_id4_exp_date = "";
			String lod_pat_id		= "";
			String revised_yn		= "";
			String nationality_long_desc = "";

           
           java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
            java.util.Date dt=new java.util.Date();
            String currDate = dateFormat.format( dt ) ;
            
            String min = String.valueOf(dt.getMinutes()) ;
            if(min.length() == 1)   min = "0"+min ;
            currDate=currDate + " "+String.valueOf(dt.getHours())+":"+min;
            check_in_date_time = currDate ;   
			
            String mode = request.getParameter("mode") ;
			 if( mode == null )  mode = "insert" ;

	try{
		con = ConnectionManager.getConnection(request);

		String Lodger_Max_RefNo = "";
		String Lodger_Next_RefNo = "";

		String Lodger_Period	= "";	
		String Acc_Period		= "";
		String Acc_Period_unit	= "";

		String paramSql="select LODGER_MAX_SRL_NO, LODGER_NEXT_SRL_NO, MAX_STAY_OF_LODGER_AFTER_DISC, DFLT_GATE_PASS_PERIOD, DFLT_GATE_PASS_UNIT from ip_param where facility_ID='"+facility_id+"'";

		ParamStmt = con.createStatement();
		ParamRS = ParamStmt.executeQuery( paramSql );

		if(ParamRS!=null)
		{
			if ( ParamRS.next() )
			{
				Lodger_Max_RefNo = ParamRS.getString("LODGER_MAX_SRL_NO");
				Lodger_Next_RefNo = ParamRS.getString("LODGER_NEXT_SRL_NO");

				Lodger_Period	= ParamRS.getString("MAX_STAY_OF_LODGER_AFTER_DISC");
				Acc_Period		= ParamRS.getString("DFLT_GATE_PASS_PERIOD");
				Acc_Period_unit	= ParamRS.getString("DFLT_GATE_PASS_UNIT");
			}
		}

			if(Lodger_Max_RefNo == null) Lodger_Max_RefNo="";	
			if(Lodger_Next_RefNo == null) Lodger_Next_RefNo="";	
			if(Lodger_Period == null) Lodger_Period="";
	    	if(Acc_Period == null) Acc_Period = "";
	    	if(Acc_Period_unit == null) Acc_Period_unit = "";

			if(ParamStmt == null) ParamStmt.close();
			if(ParamRS == null) ParamRS.close();

		int count=0;
		String patIDSql="select a.LODGER_PATIENT_ID LODGER_PATIENT_ID,a.LODGER_REF_NO LODGER_REF_NO, b.REVISED_YN REVISED_YN from IP_LODGER_DETAIL a, IP_LODGER_GATE_PASS b where a.facility_ID='"+facility_id+"' and a.facility_ID=b.facility_ID and a.LODGER_REF_NO=b.LODGER_REF_NO and a.LODGER_PATIENT_ID is not null";

		PatIDStmt = con.createStatement();
		PatIDRS = PatIDStmt.executeQuery( patIDSql );

		if(PatIDRS != null)
		{
			while( PatIDRS.next() )
			{
				lod_pat_id = PatIDRS.getString("lodger_patient_id");
				revised_yn = PatIDRS.getString("REVISED_YN");
				count++;
			}
		}
	
		if(PatIDStmt != null) PatIDStmt.close();
		if(PatIDRS != null)   PatIDRS.close();

		if(lod_pat_id == null) lod_pat_id = "";
		if(revised_yn == null) revised_yn = "";

		
		String operSql =" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facility_id+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ";
	
		stmt_opn = con.createStatement();
		rs_opn = stmt_opn.executeQuery(operSql);

		if (rs_opn.next())
		{
			p_oper_stn_id = rs_opn.getString("oper_stn_id");
		}

		if(rs_opn!=null)    rs_opn.close();
		if(stmt_opn!=null)  stmt_opn.close();

		stmt = con.createStatement();

		sql = "select patient_id_length, to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, pat_name_as_multipart_yn from mp_param ";

		rs  = stmt.executeQuery(sql);

		if (rs.next())
		{
			sysdateTime				= rs.getString(2);
			pat_name_as_multipart_yn = rs.getString(3);
		}
		if(rs!=null)    rs.close();
		if(stmt!=null)  stmt.close();

		sql="";

		// Get the Patient_id, if it is for Attendant
		if(Category!=null && !Category.equals("L"))
		{
			sql  = " select PATIENT_ID from PR_ENCOUNTER where encounter_id = '"+encounter_id+"' and FACILITY_ID ='"+facility_id+"' " ;    
			stmt = con.createStatement();
			rs = stmt.executeQuery( sql );
			if(rs!=null && rs.next())
			{
				patient_id = rs.getString(1);
			}
			if(rs!=null)    rs.close();
		   if(stmt!=null)  stmt.close();
		}

if( mode.equals("update") )
{
	lodger_ref_no = request.getParameter("lodger_ref_no") ;
    if(lodger_ref_no .equals("null"))  lodger_ref_no ="" ;

	nursing_desc = request.getParameter("nursing_desc") ;
	if(nursing_desc.equals("null"))  nursing_desc ="" ;

	patientID = request.getParameter("PatID") ;
    if(patientID .equals("null"))  patientID ="" ;
	
	StringBuffer ExeSQL = new StringBuffer();

ExeSQL.append(" SELECT a.PATIENT_ENCOUNTER_ID,");
ExeSQL.append(" a.LODGER_RELATION_CODE,");
ExeSQL.append(" a.REASON_FOR_STAY_CODE,");
ExeSQL.append(" a.LODGER_NAME,");
ExeSQL.append(" to_char(a.check_in_date_time,'dd/mm/rrrr hh24:mi')CHECK_IN_DATE_TIME,");
ExeSQL.append(" to_char(a.PERIOD_FROM_DATE,'dd/mm/rrrr hh24:mi')PERIOD_FROM_DATE,");
ExeSQL.append(" to_char(a.PERIOD_TO_DATE,'dd/mm/rrrr hh24:mi')PERIOD_TO_DATE,");
ExeSQL.append(" a.ATTACHED_TO_INPATIENT_YN,");
ExeSQL.append(" a.NURSING_UNIT_CODE,a.REMARKS,a.AUTHORISED_BY,a.LODGER_GENDER,");
ExeSQL.append(" to_char(a.LODGER_DOB,'dd/mm/rrrr ')LODGER_DOB,");
ExeSQL.append(" a.NAME_PREFIX, a.FIRST_NAME, a.SECOND_NAME, a.THIRD_NAME,");
ExeSQL.append(" a.FAMILY_NAME, a.NAME_SUFFIX,");
ExeSQL.append(" a.CITIZEN_YN, a.LEGAL_YN,");
ExeSQL.append(" a.ALT_ID1_TYPE,a.ALT_ID1_NO,");
ExeSQL.append(" to_char(a.ALT_ID1_EXP_DATE,'dd/mm/rrrr')ALT_ID1_EXP_DATE,");
ExeSQL.append(" a.ALT_ID2_TYPE,a.ALT_ID2_NO,");
ExeSQL.append(" to_char(a.ALT_ID2_EXP_DATE,'dd/mm/rrrr')ALT_ID2_EXP_DATE,");
ExeSQL.append(" a.ALT_ID3_TYPE, a.ALT_ID3_NO,");
ExeSQL.append(" to_char(a.ALT_ID3_EXP_DATE,'dd/mm/rrrr')ALT_ID3_EXP_DATE,");
ExeSQL.append(" a.ALT_ID4_TYPE, a.ALT_ID4_NO,");
ExeSQL.append(" to_char(a.ALT_ID4_EXP_DATE,'dd/mm/rrrr')ALT_ID4_EXP_DATE,");
ExeSQL.append(" a.OTH_ALT_ID_TYPE OTH_ALT_ID_TYPE,");
ExeSQL.append(" p.short_desc alt_short_desc,");
ExeSQL.append(" a.OTH_ALT_ID_NO OTH_ALT_ID_NO,");
ExeSQL.append(" a.LN1_LODGER_ADD, a.LN2_LODGER_ADD,");
ExeSQL.append(" a.LN3_LODGER_ADD, a.LN4_LODGER_ADD,");
ExeSQL.append(" a.LODGER_RES_TEL_NUM, a.LODGER_OFF_TEL_NUM,");
ExeSQL.append(" a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2,");
ExeSQL.append(" a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4,");
ExeSQL.append(" a.lodger_patient_id, a.national_id_no,");
ExeSQL.append(" a.BIRTH_PLACE_CODE BIRTH_PLACE_CODE, b.LONG_DESC birth_place_desc,");
ExeSQL.append(" a.ETHNIC_GROUP_CODE, c.short_Desc ETHNIC_DESCRIPTION,");
ExeSQL.append(" a.RACE_CODE, d.LONG_DESC RACE_DESCRIPTION,");
ExeSQL.append(" a.MAIL_AREA_CODE MAIL_AREA_CODE, e.short_desc MAIL_AREA_DESCRIPTION,");
ExeSQL.append(" a.MAIL_TOWN_CODE MAIL_TOWN_CODE, f.short_desc MAIL_TOWN_DESCRIPTION,");
ExeSQL.append(" a.MAIL_REGION_CODE MAIL_REGION_CODE,  g.long_desc MAIL_REGION_DESCRIPTION,");
ExeSQL.append(" a.MAIL_POSTAL_CODE MAIL_POSTAL_CODE, q.POSTAL_CODE MAIL_POSTAL_DESCRIPTION,");
ExeSQL.append(" a.MAIL_COUNTRY_CODE, i.short_name MAIL_COUNTRY_DESCRIPTION,");
ExeSQL.append(" a.RES_AREA_CODE RES_AREA_CODE , j.short_desc RES_AREA_DESCRIPTION,");
ExeSQL.append(" a.RES_TOWN_CODE RES_TOWN_CODE, f.short_desc RES_TOWN_DESCRIPTION,");
ExeSQL.append(" a.RES_REGION_CODE RES_REGION_CODE, g.long_desc RES_REGION_DESCRIPTION,");
ExeSQL.append(" a.RES_POSTAL_CODE , h.POSTAL_CODE RES_POSTAL_DESCRIPTION,");
ExeSQL.append(" a.RES_COUNTRY_CODE, i.short_name RES_COUNTRY_DESCRIPTION,");
ExeSQL.append(" a.LODGER_EMAIL,");
ExeSQL.append(" o.long_desc NATIONALITY_DESC, a.NATIONALITY_CODE NATIONALITY_CODE");
ExeSQL.append(" FROM ");
ExeSQL.append(" ip_lodger_detail a,");
ExeSQL.append(" mp_birth_place b,");
ExeSQL.append(" mp_ethnic_group c,");
ExeSQL.append(" mp_race d,");
ExeSQL.append(" mp_res_area e,");
ExeSQL.append(" mp_res_town f,");
ExeSQL.append(" mp_region g,");
ExeSQL.append(" mp_postal_code h,");
ExeSQL.append(" mp_country i,");
ExeSQL.append(" mp_res_area j,");
ExeSQL.append(" mp_res_town k,");
ExeSQL.append(" mp_region l,");
ExeSQL.append(" mp_postal_code m,");
ExeSQL.append(" mp_country n,");
ExeSQL.append(" mp_country o,");
ExeSQL.append(" MP_ALTERNATE_ID_TYPE p,");
ExeSQL.append(" mp_postal_code q");
ExeSQL.append(" WHERE ");
ExeSQL.append(" a.birth_place_code = b.birth_place_code (+) AND");
ExeSQL.append(" a.ethnic_group_code = c.ethnic_group_code (+) AND");
ExeSQL.append(" a.race_code = d.race_code (+) AND");
ExeSQL.append(" a.mail_area_code = e.res_area_code (+) AND");
ExeSQL.append(" a.mail_town_code = f.res_town_code (+) AND");
ExeSQL.append(" a.mail_region_code = g.region_code (+) AND");
ExeSQL.append(" a.mail_postal_code = q.postal_code (+) AND");
ExeSQL.append(" a.mail_country_code = i.country_code (+) AND");
ExeSQL.append(" a.res_area_code = j.res_area_code (+) AND");
ExeSQL.append(" a.res_town_code = k.res_town_code (+) AND");
ExeSQL.append(" a.res_region_code = l.region_code (+) AND");
ExeSQL.append(" a.res_postal_code = m.postal_code (+) AND");
ExeSQL.append(" a.res_country_code = n.country_code (+) AND");
ExeSQL.append(" a.nationality_code = o.country_code (+) AND");
ExeSQL.append(" a.oth_alt_id_no = p.alt_id_type (+) AND");
ExeSQL.append(" facility_id = '"+ facility_id +"' AND");
ExeSQL.append(" lodger_ref_no ='"+ lodger_ref_no +"' ");

    stmt = con.createStatement();
	rs = stmt.executeQuery(ExeSQL.toString());

	if(rs!=null)
	{
		if ( rs.next() )
		{
			rdonly = "readonly" ;
			disabled ="disabled" ;

			Category = rs.getString("ATTACHED_TO_INPATIENT_YN") ; 
			if(Category.equals("Y"))
				Category = "A" ;
			else
				Category = "L" ;


			encounter_id         = String.valueOf( rs.getLong("patient_encounter_id") );
			if(encounter_id ==null)
				encounter_id ="";

			lodger_relation_code     = rs.getString( "lodger_relation_code" );
			if(lodger_relation_code ==null)
				lodger_relation_code ="";

			reason_for_stay      = rs.getString( "reason_for_stay_code" );
			if(reason_for_stay ==null)
				reason_for_stay ="";
	
			lodger_patient_name  = rs.getString( "lodger_name" );
			if(lodger_patient_name ==null)
				lodger_patient_name ="";

			check_in_date_time   = rs.getString( "check_in_date_time" );
			 if(check_in_date_time == null)  check_in_date_time = "";


			Period_date_time_from = rs.getString("PERIOD_FROM_DATE"); 
				if(Period_date_time_from == null)	Period_date_time_from = "";


			Period_date_time_to = rs.getString("PERIOD_TO_DATE"); 
				if(	Period_date_time_to == null)	Period_date_time_to = "";

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

				alt_id2_exp_date= rs.getString( "ALT_ID2_EXP_DATE" );
				if(alt_id2_exp_date==null) alt_id2_exp_date="";

				alt_id3_exp_date= rs.getString( "ALT_ID3_EXP_DATE" );
				if(alt_id3_exp_date==null) alt_id3_exp_date="";

				alt_id4_exp_date= rs.getString( "ALT_ID4_EXP_DATE" );
				if(alt_id4_exp_date==null) alt_id4_exp_date="";

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

				nationality_long_desc = rs.getString( "NATIONALITY_DESC" );
				if(nationality_long_desc  == null) nationality_long_desc  = "";

				// RESIDENCE ADDRESS & CONTACT DETAILS ==========

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
			
			//	MAILING ADDRESS & CONTACT DETAILS ==========
				
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

				//	TEL NO & EMAIL-ID DETAILS ==========
				
				oth_contact_no       = rs.getString( "lodger_off_tel_num" );
				if(oth_contact_no ==null)		oth_contact_no ="";  

				other_tel_no       = rs.getString( "lodger_res_tel_num" );
				if(other_tel_no ==null)		other_tel_no ="";  

				email_id= rs.getString( "LODGER_EMAIL" );
				if(email_id==null) email_id="";

		}//E.o RS
	}// E.o RS !null
}
%>

</head>

<body onLoad= 'FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='BlockLodgerForm' id='BlockLodgerForm' method='post' action='../../servlet/eIP.BookLodgerServlet' target='messageFrame'>
	
	<input type="hidden" name="hddCitizen" id="hddCitizen" value=<%=citizen%>>
	<input type="hidden" name="hddLegal" id="hddLegal" value=<%=legal%>>

	<input type='hidden' name='Lodger_Disc_Period' id='Lodger_Disc_Period' value= "<%=Lodger_Period%>">
	<input type='hidden' name='Lodger_Disc_Period_unit' id='Lodger_Disc_Period_unit' value= "H">

	<input type='hidden' name='Acc_Disc_Period' id='Acc_Disc_Period' value= "<%=Acc_Period%>">
	<input type='hidden' name='Acc_Disc_Period_unit' id='Acc_Disc_Period_unit' value= "<%=Acc_Period_unit%>">

<table border="0" cellspacing="0" cellpadding="0" width="100%" >
	<tr>
		<th colspan='7' align='left'><%out.println(( Category.equals("A") ? "&nbsp;Accompanying Person Details" : "&nbsp;Lodger Details"));%></th>
	</tr>

<!-- ###### ADDED TO DISPLAY [ ACCOMPANYING DETAILS ] FRAME FROM eMP ####### -->
<!--  ADDED BY SRIDHAR ON 17 FEB 2004 -->
<tr>
	<td align='left' colspan='7'>
<%		
	if(mode.equals("insert"))
	{
%>
		<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name ="patient_id" value= "" /> 	
		<jsp:param name ="alert_reqd_yn" value= "Y" /> 		
		<jsp:param name ="bodyFrame" value= "top.frames[1].frames[1].frames[2]" /> 	
		<jsp:param name ="submitFrame" value= "top.frames[1].frames[2]" /> 	
		</jsp:include>
<%	}
	else
	{
%>	
		<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name ="patient_id" value= "" /> 	
		<jsp:param name ="alert_reqd_yn" value= "Y" /> 		
		<jsp:param name ="bodyFrame" value= "top.frames[0]"  /> 	
		<jsp:param name ="submitFrame" value= "top.frames[1]"  />   
		</jsp:include>
<%	}
%>
	</td>  
</tr>   
</table>

<!-- ADDED FOR LOCALLY ASIGNING THE VALUES TO THE MP FORM IN THE UPDATE MODE  -->
<!-- ADDED BY SRIDHAR ON 9th FEB 2004   -->
<%
if(!mode.equals("insert"))
{
%>
  <script>

		document.BlockLodgerForm.patient_id.value 	= "<%=patientID%>";
		document.BlockLodgerForm.patient_id.disabled = true;
		document.BlockLodgerForm.search.disabled = true;
		
		document.BlockLodgerForm.patient_name.value = "<%=lodger_patient_name%>";
		document.BlockLodgerForm.patient_name.disabled = true; 
		
		if(document.BlockLodgerForm.name_prefix1)
		{
			document.BlockLodgerForm.name_prefix1.value 	= "<%=nameprefix%>";
			document.BlockLodgerForm.name_prefix1.disabled = true;
		}
		
		if(document.BlockLodgerForm.family_name)
		{
		document.BlockLodgerForm.family_name.value 	= "<%=familyname%>";
		document.BlockLodgerForm.family_name.disabled = true;
		}

		if(document.BlockLodgerForm.first_name)
		{
			document.BlockLodgerForm.first_name.value 	= "<%=firstname%>";
			document.BlockLodgerForm.first_name.disabled = true;
		}

		if(document.BlockLodgerForm.second_name)
		{
			document.BlockLodgerForm.second_name.value 	= "<%=secondname%>";
			document.BlockLodgerForm.second_name.disabled = true;
		}

		if(document.BlockLodgerForm.third_name)
		{
			document.BlockLodgerForm.third_name.value 	= "<%=thirdname%>";
			document.BlockLodgerForm.third_name.disabled = true;
		}

		if(document.BlockLodgerForm.name_suffix1)
		{
			document.BlockLodgerForm.name_suffix1.value 	= "<%=namesuffix%>";
			document.BlockLodgerForm.name_suffix1.disabled = true;
		}
		
		document.BlockLodgerForm.sex.value 	= "<%=gender%>";
		document.BlockLodgerForm.sex.disabled = true;

		// DATE OD BIRTH 
		document.BlockLodgerForm.date_of_birth.value = "<%=date_of_birth%>";
		document.BlockLodgerForm.date_of_birth.disabled = true;

		document.BlockLodgerForm.b_birth.disabled = true;
		document.getElementById('dob').disabled = true;
		document.BlockLodgerForm.b_age.disabled = true;
		document.BlockLodgerForm.b_months.disabled = true;
		document.BlockLodgerForm.b_days.disabled = true;

		document.BlockLodgerForm.Birth_place_code.value 	= "<%=place_of_birth_code%>";
	
		if((document.BlockLodgerForm.Birth_place_code.value == null) || (document.BlockLodgerForm.Birth_place_code.value == ""))
		{	
			document.BlockLodgerForm.place_of_birth.value = "<%= place_of_birth_desc%>";
		}else
		document.BlockLodgerForm.birth_place.value = "<%= place_of_birth_desc%>";

		document.BlockLodgerForm.birth_place.disabled= true;
		document.BlockLodgerForm.place_of_birth.disabled= true;

		document.BlockLodgerForm.nationality_code1.value = "<%=nationality_code%>";
		document.BlockLodgerForm.nationality_desc.value = "<%=nationality_long_desc%>";
		document.BlockLodgerForm.nationality_desc.disabled= true;
		document.BlockLodgerForm.nationality_id.disabled = true;

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
	
		document.BlockLodgerForm.ethnic_group.value = "<%=eth_grp%>";
		document.BlockLodgerForm.ethnic_group.disabled = true;

		document.BlockLodgerForm.race_code.value = "<%=eth_sub_grp%>";

		if(document.BlockLodgerForm.race_desc) {
			document.BlockLodgerForm.race_desc.value="<%=eth_sub_grp%>";
			document.BlockLodgerForm.race_desc.disabled = true;
			document.BlockLodgerForm.race_desc_id.disabled = true;
		}

// For populating EthnicSubGrp..

		/*
		var obj =document.forms[0].race_code;
		var opt= document.createElement('Option');
		opt.text="<%=eth_sub_grp%>"; 
		opt.value="<%=eth_sub_grp%>"; 
		obj.add(opt)
		opt.selected = true;
		document.BlockLodgerForm.race_code.disabled = true;
		*/
		
		
		if(document.BlockLodgerForm.hddCitizen.value == "Y")
			document.BlockLodgerForm.citizen_yn[0].checked = true;
		else
			document.BlockLodgerForm.citizen_yn[1].checked = true;

		document.BlockLodgerForm.citizen_yn[0].disabled = true;		
		document.BlockLodgerForm.citizen_yn[1].disabled = true;		


		if(document.BlockLodgerForm.hddLegal.value == "Y")
			document.BlockLodgerForm.legal_yn[0].checked = true;
		else
			document.BlockLodgerForm.legal_yn[1].checked = true;

		document.BlockLodgerForm.legal_yn[0].disabled = true;		
		document.BlockLodgerForm.legal_yn[1].disabled = true;		

		//	Patient contact details popup ================ 
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

		document.BlockLodgerForm.contact1_name.value='';

		document.BlockLodgerForm.addr2_type.value='';

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
 </script>

<% } %>
	

<table border="0" cellspacing="0" cellpadding="0" width="100%" >
	<%  String label ="";
	%>
	<tr><th align='left' colspan='8' >&nbsp;<fmt:message key="Common.staydetails.label" bundle="${common_labels}"/> </th><th></th></tr> 

<!--  ADDED BY SRIDHAR ON 13 FEB 2004 -->
<!--****************** CHECK IN DATE / TIME  ******************-->
<tr>
<td class="label" align="right" >
	<%	if(Category.equals("L"))
		out.println("Lodger");
	%>
Check in Date/time&nbsp;&nbsp;</td>
<td nowrap class='QUERYDATA' >
	<%  
		if(mode.equals("insert"))
	{%>
		<input type="text" id='blockfrom' name="chk_in_dt_time" id="chk_in_dt_time" maxlength=16 size=16 onblur ="CompareCheckinTime(this,'<%=sysdateTime%>');" value ="<%=check_in_date_time%>" ><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].chk_in_dt_time.focus();return showCalendar('blockfrom',null,'hh:mm');">
	<%}
	else
	{
		out.println( check_in_date_time ) ;
	}%>     
</td> 

<!--****************** RELATION WITH PATIENT ******************-->
<!--  ADDED BY SRIDHAR ON 20 FEB 2004 -->
</td>
	<% if(Category.equals("A")) { %> 
	<td class="label" align="right"  nowrap size ='15' maxlength = '15'><fmt:message key="eMP.relationshipwithpatient.label" bundle="${mp_labels}"/>&nbsp;</td>
	<td class='QUERYDATA' >

	<%
		String sel ="";                                     
		StringBuffer sqlBuff  = new StringBuffer();
		sqlBuff.append(" select relationship_code, short_desc from mp_relationship where eff_status = 'E' ");
		if(mode.equals ("insert"))
		{
			out.println( "<select name='reln_with_patient' id='reln_with_patient' "+ disabled +" >" ); 
			out.println("<option value=''>------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----------</option>") ;
		}
		else
			sqlBuff.append(" and relationship_code ='"+ lodger_relation_code +"' ");

		sqlBuff.append(" order by short_desc ");

		stmt = con.createStatement();
		rs = stmt.executeQuery (sql) ;
		while ( rs.next() )
		{
			if(mode.equals("insert"))
			{
				if(reason_for_stay.equals(rs.getString(1)))
				sel = "selected" ;
				out.println( "<option value= '"+ rs.getString(1) +"' "+ sel +">" + rs.getString(2) + "</option>" ) ;
				sel = "";
			}
			else
			{
				out.println( rs.getString(2) ) ; 
				out.println("</td><td colspan='2'>&nbsp;</td>");
			}
		}
		out.println("</td><td colspan='4'>&nbsp;</td>");
	}
	else if(Category.equals("L"))
		{
			/*	REASON FOR STAY	  */			
			out.println("<td colspan='4' class='label' align='right' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforStay.label","ip_labels")+"&nbsp;</td><td nowrap class='QUERYDATA'>");
		
			sql = "   select reason_for_stay_code, short_desc from ip_reason_for_lodger_stay where eff_status = 'E'"  ;

			if (mode.equals("update"))
				sql = sql + " and reason_for_stay_code='"+ reason_for_stay +"' " ;
			
			sql = sql + " order by short_desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql) ;

			if(rs!=null)
			{
				if(mode.equals ("insert"))
				{
					out.println( "<select name='reason_for_stay' id='reason_for_stay' >" ); 
					out.println("<option value=''>------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----------</option>") ;
				}
					
				while ( rs.next() )
				{
					if(mode.equals("insert"))
					{
						out.println( "<option value= \""+ rs.getString(1) +"\" >" + rs.getString(2) + "</option>" ) ;
					}
					else
					{
						out.println(rs.getString(2)) ; 
						out.println(" <td colspan='4'>&nbsp;</td> ");
					}
				}
			}

			if(mode.equals("insert"))
				out.println( "</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>");
			out.println("</td>");
	}

	if(mode.equals("update"))
		{
			out.println(" <tr><td colspan='8' align='left' >&nbsp;</td><td></td></tr>");
		}
	%>
									
</td>
<!--******************* PERIOD FROM ********************-->
<tr>
<td class="label" align="right" nowrap> <fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td nowrap class='QUERYDATA' >
<%if(mode.equals("insert"))
		{%>
			<input type="text" id='periodfrom' name="period_from" id="period_from" maxlength=16 size=16 onblur ="CompareCheckInTime(chk_in_dt_time,this);ComparePeriodTime(this,period_to);" value ="<%=sysdateTime%>"><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].period_from.focus();return showCalendar('periodfrom',null,'hh:mm');" >&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>  
		<%}
		else
		{
			out.println( Period_date_time_from ) ;
		}
		%>   
</td>  

<!--****************** PERIOD TO *********************-->
<td class="label" align="right" nowrap> <fmt:message key="Common.periodto.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td colspan="4" nowrap class='QUERYDATA' >
<%if(mode.equals("insert"))
	{%>
			<input type="text" id='periodto' align= "left" name="period_to" id="period_to" maxlength=16 size=16 onblur="ComparePeriodTime(period_from,this);" value ="<%=Period_date_time_to%>" ><input type="image" 	src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].period_to.focus();return showCalendar('periodto',null,'hh:mm');">&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>  
	<%}
	else
	{
		if(mode.equals("update"))
			{
				out.println(Period_date_time_to) ;
				out.println(" <td colspan='4' >&nbsp;</td>");
				out.println(" <tr><td colspan='8' align='left' >&nbsp;</td><td></td></tr> ");
			}
	}
%>
</tr>

<!--****************** NURSING UNIT **************-->
<tr>
	<td class="label" align="right" nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap class='QUERYDATA' >
	<%if(mode.equals("insert"))
	{%>
		<input type=text name="nursing_unit_desc" id="nursing_unit_desc" width="16" maxlength=16 size=16  onblur="beforeGetNursingUnit(this, '<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup'  value='?' onClick="getNursingUnit(nursing_unit_desc, '<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" >
		<input type=hidden name="lodger_nursing_unit" id="lodger_nursing_unit" width="15" >
	<%}
	else
	{
	out.println (nursing_desc) ;
	}
%>
</td>

<!--*************** AUTHORIZED BY ************************-->

<td class="label" align="right" ><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/>&nbsp;</td>
	<td colspan=4 nowrap class='QUERYDATA' >
		<%if(mode.equals("insert"))
		{%>
			<input type="text" name="authorised_by" id="authorised_by" maxlength=16 size=16 value="<%=authorized_by%>" <%=rdonly%> onBlur='makeValidString(this);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		<%}
		else
		{
			out.println( authorized_by ) ;
			out.println(" <td colspan='4' >&nbsp;</td>");
			out.println(" <tr><td colspan='8' align='right' >&nbsp;&nbsp;</td><td></td></tr> ");
		}%> 
	</td>
</tr>

<!--******************** REMARKS *******************-->
<tr>
	<td class="label" align="right" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<%if(mode.equals("insert"))
		{%>
			<td class='QUERYDATA' colspan=6 wrap>
			<textarea name="remarks" rows=3  cols=84 maxLength='200' onKeypress="return CheckMaxLength(this,200)" onBlur="checkMax(this);"<%=rdonly%> ><%=remarks%></textarea>
		<%}
		else
		{%>
			<td class='QUERYDATA' colspan='8'><%=remarks%></td></tr>
			<tr><td class='blankRowDisp' colspan='8' align='left'>&nbsp;</td><td></td></tr>
		<%}%> 
		</td>
</tr>

<%if(mode.equals("update"))	{%>
<!--**************** CHECK OUT DATE / TIME ************-->
	 <tr>
		 <td class="label" align="right" nowrap><%=label%> Check Out Date/time&nbsp;&nbsp;</td>
		<input type="hidden" name="chk_in_dt_time" id="chk_in_dt_time" maxlength=16 size=16 onblur ="dateVal(this)" value ="<%=check_in_date_time%>"></td>
		<td><input type="text" id='chkoutdttime' name="chk_out_dt_time" id="chk_out_dt_time" maxlength=16 size=16 onblur ="compareDate(this,document.forms[0].chk_in_dt_time,'<%=sysdateTime%>');" value ="<%=currDate%>" ><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].chk_out_dt_time.select();return showCalendar('chkoutdttime', null, 'hh:mm' );">&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		<td colspan='8'>&nbsp;</td>

		</tr>  

	<%}%>
  </td>
</tr>
	<%if(mode.equals("update")){%>
<tr><td colspan='10' align='left' class='button'>&nbsp;</td></tr>
	<tr>
			<td colspan='10' align='right' class='button'>
				<input type='button' value='Release Lodger/ Attendant' name='release_lodger' id='release_lodger' class='button' onClick="SubmitPage()">
				<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='cancel' class='button' onclick='parent.window.close();'>
			</td>
		</tr>
<tr><td colspan='10' align='left' class='button'>&nbsp;</td></tr>
<tr><td colspan='10' align='left' class='button'>&nbsp;</td></tr>
<tr><td colspan='10' align='left' class='button'>&nbsp;</td></tr>
<tr><td colspan='10' align='left' class='button'>&nbsp;</td></tr>

	<%}
	else
	{
		out.println("<tr rowspan='20'>");
		out.println(" <td class='blankRowDisp' colspan='10' align='left' height='100' >&nbsp;</td> ");
		out.println("</tr>");
	}
	%> 
</table>
            <input type="hidden" name='Category' id='Category' value = "<%=Category%>"> 
            <input type="hidden" name='lodger_ref_no' id='lodger_ref_no' value = "<%=lodger_ref_no%>"> 
	        <input type="hidden" name='pat_id' id='pat_id' value = "<%=patient_id%>">  
            <input type="hidden" name='encounter_id' id='encounter_id' value = "<%=encounter_id%>"> 
			<input type="hidden" name="to_chk_in_dt_time" id="to_chk_in_dt_time" maxlength=16 size=16 onblur ="dateVal(this)" value ="<%=currDate%>"> 
            <input type='hidden' name='mode' id='mode' value= "<%=mode%>">
			<input type='hidden' name='label' id='label' value= "<%=label%>">
			<input type='hidden' name='pLine_Pat_id' id='pLine_Pat_id' value= "<%=patient_id%>">
			<input type='hidden' name='Lodger_Max_RefNo' id='Lodger_Max_RefNo' value= "<%=Lodger_Max_RefNo%>">
			<input type='hidden' name='Lodger_Next_RefNo' id='Lodger_Next_RefNo' value= "<%=Lodger_Next_RefNo%>">

        </form>
        <script>
		if(("<%=mode%>" == "insert") && ("<%=Category%>" == "L"))
        {
			parent.frames[0].document.getElementById('attendant').disabled=true;
        }
        </script>

        <%
}catch(Exception e) {out.println(e.toString());}
 finally
  {
	if (rs != null)			rs.close();
	if (stmt != null)		stmt.close();
	if (rs_opn != null)		rs_opn.close();
	if (stmt_opn != null)	stmt_opn.close();
	if (PatIDRS != null)	PatIDRS.close();
	if (PatIDStmt != null)	PatIDStmt.close();

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

