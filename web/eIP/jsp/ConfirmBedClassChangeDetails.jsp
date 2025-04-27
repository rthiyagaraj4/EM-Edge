<!DOCTYPE html>
<!--
	Developed by 	:	Chitra 
	Created on 	:	13/07/2001
	Module		:	ip
-->

<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" %>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;	
	ResultSet rs_opn		= null;	

	String bl_operational =	(String)session.getValue("bl_operational");
	String billing_group_id		= "";
	String billing_group_desc	= "";
	//String loginUser			= (String)session.getValue("login_user");
	String facilityId			= (String)session.getValue("facility_id");
	String modified_date_val	= "";
	String frnursingunitcode	= "";
	String frbedno				= "";
	String frpractitionerid		= "";
	String frpractdesc			= "";
	String frspecialitycode		= "";   
	String frspecialitydesc		= "";
	String frbedclass			= ""; 
	String frbedclassdesc		= ""; 
	String frnursingunitdesc	= "";
	String frroomno				= "";
	String frbedtype			= "";
	String frbedtypedesc		= "";
	int    frdailycharge		= 0;
	String age					= "";
	String gender				= "";
	String frservicecode		= "";
	String frservicedesc		= "";
	String frsubservcode		= "";
	String frsubservdesc		= "";
	String patient_class		= "";
	String frmeddesc			= "";
	String frmedid				= "";

	// Following Code is to Check the Module with Billing Interface 
	String install_yn			= "";

	StringBuffer SqlSB = new StringBuffer();
	int bed_block_period_max=0;
	String max_blk_type="";
	String bed_class_allowed ="";
	String block_period_max = "";


	try
	{
		con =ConnectionManager.getConnection(request);
		stmt		= con.createStatement();	
	
	
			
				install_yn=checkForNull(request.getParameter("bl_interfaced_yn"));
			    block_period_max=checkForNull(request.getParameter("bed_block_period_max"));
			    max_blk_type=checkForNull(request.getParameter("bed_block_period_max_type"));
			    bed_class_allowed=checkForNull(request.getParameter("change_bed_class_yn"));

				bed_block_period_max = Integer.parseInt(block_period_max);
				if(max_blk_type.equals("D"))
				 bed_block_period_max=(bed_block_period_max)*24; 
		
		/*
		SqlSB.append(" select nvl(bl_interfaced_yn,'N') bl_interfaced_yn , BED_BLOCK_PERIOD_MAX,BED_BLOCK_PERIOD_MAX_TYPE,CHANGE_BED_CLASS_YN from ip_param where facility_id='"+facilityId+"' ");
		try
		{
			stmt_bl=con.createStatement();
			rs_bl=stmt_bl.executeQuery(SqlSB.toString());
			if(rs_bl.next())
			{
				install_yn=rs_bl.getString("bl_interfaced_yn");
				BED_BLOCK_PERIOD_MAX=rs_bl.getInt("BED_BLOCK_PERIOD_MAX");
			    max_blk_type=rs_bl.getString("BED_BLOCK_PERIOD_MAX_TYPE");
			    bed_class_allowed=rs_bl.getString("CHANGE_BED_CLASS_YN");
			    if(max_blk_type.equals("D"))
				BED_BLOCK_PERIOD_MAX=(BED_BLOCK_PERIOD_MAX)*24; 
			}
			
		//added by kishore on 8/21/2004
			if(rs_bl		!= null)   rs_bl.close();
			if(stmt_bl   != null)   stmt_bl.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception @try1"+e);
		}
	
	if(SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());
	

	SqlSB.append(" select  from ip_param where facility_id='"+facilityId+"' ");

	*/

	
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../js/ConfirmBedClass.js" language="javascript"></script>
	<script src="../js/IPPractitionerComponent.js" language="javascript"></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	
	<script>


// Added by Sridhar on 2 JULY 2004
// Function chkPractRole will check whether the selected Practitioner is an Consultant Practitioner or not...IF 'Yes'.. then user will have to select another practitioner..
function chkPractRole(practID)
{
	var encounterId = document.forms[0].encounter_id.value;
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='practRole' id='practRole' method='post' action='../../eIP/jsp/PractIncompleteError.jsp?criteria=chkPractRole&encounter_ID="+encounterId+"&pract_ID="+practID+"'></form></BODY></HTML>";
	parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.forms[0].submit();
}


//By Annadurai 2/6/2004., to use Common Lookup starts.,
var flag = 0;
function clearRoom()
{
	if (document.forms[0].to_bed_no.value=="")
	document.forms[0].to_room_no.value="";
}

function popDynamicValues_confirm(obj)
{
	//dummy function added to stop the exceptions
}


function disableselect()
{	if(document.getElementById('reqstat').value=='2')
	{

		document.forms[0].Bedcode.disabled=true;
		document.forms[0].bed_type_code.disabled=true;

		document.getElementById('legend2').innerHTML	    =	getLabel('Common.ReasonforRejection.label','Common')+"&nbsp;&nbsp;";
		document.getElementById('select2').style.visibility	    =	"Visible";
		document.getElementById('rejection').style.visibility	    =	"Visible";
		document.forms[0].to_bed_no.value=document.forms[0].hid_tobedno.value;
		document.forms[0].to_room_no.value=document.forms[0].hid_toroomno.value;
		document.forms[0].to_bed_no.disabled=true;
		document.forms[0].to_room_no.disabled=true;
		document.getElementById('bedlookkup').disabled=true;
		document.getElementById('bedoimg').style.visibility	    =	"Hidden";
	}
	else if(document.getElementById('reqstat').value=='1')
	{
		document.forms[0].Bedcode.disabled=false;
		document.forms[0].bed_type_code.disabled=false;
		document.getElementById('legend2').innerHTML	    =	"";
		document.getElementById('select2').style.visibility	    =	"Hidden";
		document.getElementById('rejection').style.visibility	    =	"Hidden";
		document.forms[0].to_bed_no.disabled=false;
		document.forms[0].to_room_no.disabled=false;
		document.forms[0].to_room_no.readOnly=true;
		document.getElementById('bedlookkup').disabled=false;
	if(document.forms[0].tfr_type.value=='ET')
		document.getElementById('bedoimg').style.visibility	    =	"Visible";
	}
	else
	{
		document.getElementById('legend2').innerHTML	    =	"";
		document.getElementById('select2').style.visibility	    =	"Hidden";
		document.forms[0].Bedcode.disabled=true;
		document.forms[0].bed_type_code.disabled=true;
		document.getElementById('rejection').style.visibility	    =	"Hidden";
		document.forms[0].to_bed_no.value=document.forms[0].hid_tobedno.value;
		document.forms[0].to_room_no.value=document.forms[0].hid_toroomno.value;
		document.forms[0].to_bed_no.disabled=true;
		document.forms[0].to_room_no.disabled=true;
		document.getElementById('bedlookkup').disabled=true;
		document.getElementById('bedoimg').style.visibility	    =	"Hidden";
	}
}

async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	var nursingUnit		= aNursingUnit.value;
	var facilityId		= aFacilityId;
	var loginUserId		= aLoginUser;
	var	operStnID		= pOperStnID;

	var retVal			= new String();

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit a, am_os_user_locn_access_vw b where a.facility_id  like ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.oper_stn_id  like ? and b.appl_user_id  like ? and emergency_tfr_yn='Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";
	
	dataNameArray[0]	= "a.facility_id" ;
	dataValueArray[0]	= facilityId;
	dataTypeArray[0]	= STRING ;
	
	dataNameArray[1]	= "b.oper_stn_id" ;
	dataValueArray[1]	= operStnID;
	dataTypeArray[1]	= STRING ;
	
	dataNameArray[2]	= "b.appl_user_id" ;
	dataValueArray[2]	= loginUserId;
	dataTypeArray[2]	= STRING ;

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "4, 5";
	argumentArray[5]	= nursingUnit;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	var tit=getLabel('Common.nursingUnit.label','common');;

	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].nursing_unit.value		=	arr[0];
		document.forms[0].nursing_unit_desc.value	=	arr[1];
		popDynamicValues_confirm(document.forms[0].nursing_unit);
		document.forms[0].Splcode_desc.value='';
		document.forms[0].Splcode.value='';
		document.forms[0].practid.value='';
		document.forms[0].pract_desc.value='';
		document.forms[0].team_id.value='';
		PopulateService();
	}
	else
	{
		document.forms[0].nursing_unit_desc.value='';
		document.forms[0].nursing_unit.value='';
		document.forms[0].Splcode_desc.value='';
		document.forms[0].Splcode.value='';
		document.forms[0].practid.value='';
		document.forms[0].pract_desc.value='';
		document.forms[0].team_id.value='';
		document.forms[0].to_bed_no.value='';
		document.forms[0].to_room_no.value='';
		document.forms[0].service.value='';
	}
}
// To check the presence of Nursing Unit.
function checkForNursing() 
{
	if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 1;
		alert(getMessage('NU_NOTNULL','IP'));
		document.forms[0].nursing_unit_desc.focus();
	}
} // End of checkForNursing.


// Added by Sridhar on 7 APR 2004
// To Display the chief Practitioner if Medical Team is selected when pratitioner is empty.
function getMedicalTeamHead(Obj)
{
	if (Obj.value == "")
	{
		document.EmergencyTransfer_form.pract_desc.value = "";
	}
	else if (document.EmergencyTransfer_form.pract_desc.value == "")
	{
		 var teamId = document.EmergencyTransfer_form.team_id.value;
		 var sqlString = "SELECT pract_role, PRACTITIONER_ID FROM am_pract_for_team WHERE team_id = '"+ document.EmergencyTransfer_form.team_id.value + "' AND pract_role='C'";
		
		document.EmergencyTransfer_form.selecTeam.value=sqlString;

		var HTMLValue = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' 							action='../../eIP/jsp/TransferValidation.jsp'>";
			HTMLValue += " <input type='hidden' name='selectedTeam' id='selectedTeam' value='"+teamId+"'>";
			HTMLValue += " <input type='hidden' name='reqParam' id='reqParam' value= 'executeQuery' >";
			HTMLValue +=" <input type='hidden' name='sqlQuery' id='sqlQuery' value='"+sqlString+"'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLValue);
		parent.frames[2].document.dum_form.submit();
	}
}

function checkTxtVal(obj1,obj2)
{
	if(document.forms[0].Splcode_desc.value == "")
		getSpecialty(obj1,obj2);
}

function checkPractTxtVal(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc.value == "")
		getPractitionerLocal(obj,target, aFacilityID);
}

// Function will check for empty values before calling up the common lookup func..

function BeforeGetSpecialty(obj1,obj2)
{
	if(document.forms[0].spec_desc_hid.value != document.forms[0].Splcode_desc.value)
	{
		if(document.forms[0].Splcode_desc.value!="")
			getSpecialty(obj1,obj2);
		else
			document.forms[0].pract_desc.value = "";	
	}
}
function BeforeGetPractitioner(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_desc.value)
	{
		if(document.forms[0].pract_desc.value!= "")
			getPractitionerLocal(obj,target, aFacilityID);
		else
		{	
			
			var obj =document.forms[0].team_id;
			var length  = obj.length;
			
			for(i=0;i<length;i++) 
				obj.remove(0);
			var opt = document.createElement('OPTION'); 
			opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt.value= '';
			obj.add(opt);
		}
	}
}

async function getSpecialty(aSpecialtID, Facility_ID)
{
	checkForNursing(); // To check for Nursing Unit.
	var target			= document.forms[0].Splcode_desc;
	var code			= document.forms[0].nursing_unit.value;
	var FacilityID		= Facility_ID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	sql	=	"Select a.speciality_code code,a.short_desc description from am_speciality a, ip_nurs_unit_for_specialty b where eff_status='E' and a.speciality_code=b.specialty_code and b.facility_id like ? and b.nursing_unit_code like ? and upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?) ";
	
	var tit=getLabel('Common.speciality.label','common');
	
	dataNameArray[0]	= "b.facility_id" ;
	dataValueArray[0]	= FacilityID;
	dataTypeArray[0]	= STRING ;
	
	dataNameArray[1]	= "b.nursing_unit_code" ;
	dataValueArray[1]	= code;
	dataTypeArray[1]	= STRING ;
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "3, 4";
	argumentArray[5]	= aSpecialtID.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].Splcode_desc.value=arr[1];
		document.forms[0].pract_desc.value='';
		document.forms[0].practid.value='';
		document.forms[0].team_id.value="";
		document.forms[0].spec_desc_hid.value = document.forms[0].Splcode_desc.value;
		PopulateMedicalTeam();
	}
	else
	{
		document.forms[0].Splcode_desc.value="";
		document.forms[0].Splcode.value="";
		document.forms[0].pract_desc.value="";
		document.forms[0].practid.value="";
		document.forms[0].team_id.value="";
	} 
} // End of getSpecialty().

// By Annadurai ends.,

	function fetchValForBedClass(obj){}
	
// To check the Nursing Unit and Specialty when selecting Practitioner.  
function checkForValues()
{
	if ((document.forms[0].nursing_unit_desc.value=="") && (document.forms[0].Splcode_desc.value==""))
	{
		flag = 2;
		var errorMsg = getMessage('NU_NOTNULL','IP')+"\n"+getMessage('SPLTY_NOTNULL','IP'); 
		alert(errorMsg);
		document.forms[0].nursing_unit_desc.focus();
	}
	else if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 2;
		alert(getMessage('NU_NOTNULL','IP'));
		document.forms[0].nursing_unit_desc.focus();
	}
	else if (document.forms[0].Splcode_desc.value=="")
	{
		flag = 2;
		alert(getMessage('SPLTY_NOTNULL','IP'));
		document.forms[0].Splcode_desc.focus();
	}
} // End of checkForValues.



function getPractitionerLocal(obj,target, aFacilityID)
{
	checkForValues();
	var practName_FName		= "";
	var practName_FValue	= "";
	var practId_FName		= "";
	
	practName_FName			= target.name;
	practName_FValue		= target.value;
	practId_FName			= document.forms[0].practid.name;
	var nursing_unit_code	= document.forms[0].nursing_unit.value;
	var spl_code			= document.forms[0].Splcode.value;
	var locale			= document.forms[0].locale.value;
	var facility_id			= aFacilityID;
	
	getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");
	
	/*
	var sql = " SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.specialty_code, am_get_desc.AM_SPECIALITY(a.SPECIALITY_CODE,'"+locale+"',2 ) primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"'  AND a.specialty_code = '"+spl_code+"'  AND e.facility_id = a.facility_id  AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id  AND a.pract_type LIKE (?)  AND a.specialty_code LIKE UPPER (?) AND (    UPPER (a.practitioner_id) LIKE UPPER (NVL (?,a.practitioner_id)) AND UPPER (am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) ";

	var sql2 = " SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+locale+"',2) practitioner_type, a.specialty_code, am_get_desc.AM_SPECIALITY(a.SPECIALITY_CODE,'"+locale+"',2 ) primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"'  AND a.specialty_code = '"+spl_code+"'  AND e.facility_id = a.facility_id  AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id  AND a.pract_type LIKE (?)  AND a.specialty_code LIKE UPPER (?) AND (    UPPER (a.practitioner_id) LIKE UPPER (NVL (?,a.practitioner_id)) and UPPER (am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) ";

	var xmlDoc		 = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp		 = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	xmlStr			 = "<root><SEARCH " ;
	xmlStr			+= " practName_FName=\"" +practName_FName + "\"";
	xmlStr			+= " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr			+= " practId_FName=\"" + practId_FName + "\"";
	xmlStr			+= " sql=\"" +escape(sql)+ "\"";
	xmlStr			+= " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr			+= " practitioner_type=\"" + "" + "\"";
	xmlStr			+= " specialty_code=\"" + spl_code+ "\"";
	xmlStr			+= " job_title=\"" + "" + "\"";
	xmlStr			+= " gender=\"" + "" + "\"";
	xmlStr			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText	 =xmlHttp.responseText;
	responseText	 = trimString(responseText);
	eval(responseText);	

	*/


} // End of getPractitioner();

// To set the values to Attending Practitioner when using  
// GeneralPratitionerLookup. It's called by the GeneralPratitionerLookup.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].pract_desc.value=arr[1];	
		document.forms[0].pract_desc_hid.value = document.forms[0].pract_desc.value;
		chkPractRole(document.forms[0].practid.value);
		PopulateMedicalTeam();
	}
	else
	{
		document.forms[0].practid.value="";
		document.forms[0].pract_desc.value="";			
	}
} // End of PractLookupRetVal().

	async function getPractID()
	{
		var facility_id="";
		var nursing_unit_code	= "`"+document.forms[0].nursing_unit.value+"`";
		var spl_code			= "`"+document.forms[0].Splcode.value+"`";

		facility_id				="`"+"<%=facilityId%>"+"`";
		if(nursing_unit_code != "")
		{
			if(spl_code != "")
			{
				var target				= document.forms[0].practid;
				var retVal				=    new String();
				var dialogTop			= "40";
				var dialogHeight		= "10" ;
				var dialogWidth			= "40" ;
				var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var sql="";
				var search_desc="";
				var tit="";

				sql="select practitioner_id, practitioner_name from ip_nursing_unit_for_pract_vw where facility_id="+facility_id+" and nursing_unit_code="+nursing_unit_code+" and practitioner_id in (select practitioner_id from am_practitioner  where primary_speciality_code="+spl_code+" and eff_status = `E` union select practitioner_id from  am_pract_specialities where facility_id = "+facility_id+" and speciality_code ="+spl_code+")";

				search_code="practitioner_id";
				search_desc="practitioner_name";
				var tit=getLabel('Common.practitioner.label','common');

				retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&dispDescFirst=dispDescFirst&title="+encodeURIComponent(tit),arguments,features);

				if (!(retVal == null))
				{
					if (!(unescape(retVal) == null))
					{
						arr=unescape(retVal).split("::");
						document.forms[0].pract_desc.value=arr[0];
						document.forms[0].practid.value=arr[1];
						PopulateMedicalTeam();
					}
				}
				else
				{
						document.forms[0].pract_desc.value="";
						document.forms[0].practid.value="";
						document.forms[0].team_id.value="";
				}
			}
			else
			{
				var error = getMessage('CAN_NOT_BE_BLANK','common');
				error = error.replace('$',getLabel("Common.speciality.label","Common"));
				alert(error);	
			}
		}
		else
		{
			var error = getMessage('CAN_NOT_BE_BLANK','common');
			error = error.replace('$',getLabel("Common.nursingUnit.label","Common"));
			alert(error);	
		}
	}

	function PopulateMedicalTeam()
	{ 	
		// Nanda 01/10/2002 
		var selected = document.forms[0].team_id;
		while ( selected.options.length > 0 )
			selected.remove(selected.options[0]);
		var	str1 = "" ;
		var	str2 = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---"
		var element = parent.frames[1].document.createElement('OPTION');
		element.text = str2; 
		element.value= str1;
		document.forms[0].team_id.add(element);

		var ippractid  = document.forms[0].practid.value;
		var getservice = document.forms[0].practid.value;
		var spl_code = document.forms[0].Splcode.value;
		if (ippractid != null && ippractid != "")
		{
			var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='booking' id='booking' value='AssignBed'><input type='hidden' name='spy_code' id='spy_code' value='"+spl_code+"'></form></body></html>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.querydept.submit();
		}
	}

	function ClearPractMedDtls()
	{
		document.forms[0].practid.value='';
		var selected = EmergencyTransfer_form.team_id;
		while ( selected.options.length > 0 )
			selected.remove(selected.options[0]);

		var	str1 = "" ;
		var	str2 = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		var element = parent.frames[1].document.createElement('OPTION');
		element.text = str2; 
		element.value= str1;
		document.forms[0].team_id.add(element);
	}

	//added by kishore on 8/21/2004
	function validSpecialChars(obj)
	{	
		var val = obj.value.toUpperCase();			
		obj.value = val;	
		var fields=new Array();
		var names=new Array();
		fields[0]=obj;
		names[0]="Bed Blocking Period";
		if(SpecialCharCheck( fields, names,'',"A",''))
		{
			checkForMaxPeriod();
			return true;
		}
		else
		{
			obj.select();
			obj.focus();
			return false;
		}
	}

function specialChar(obj,val)
{
	if(obj.value!='')
	{
		var fields1 = new Array(obj);
		var names1 = new Array(obj.name.toUpperCase());
		var messageFrame = ""; var error_page = "";
		if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
		{
			if(val=="Num")
			{
				if(CheckNum(obj))
					{
						 return true;
					}
					else 
					{
						 obj.focus();
						 obj.value='';
						 return false;
					}
			}
			else if(val=="Char")
			{
				return true;
			}
			return true;
		}
		else
		{
		   obj.focus()
		   obj.value='';
		   return false;
		}
	}

}

//added by kishore on 7/8/2004
function checkForMaxPeriod()
{
	 if(document.forms[0].bed_blocking_period.value=='' ||document.forms[0].bed_blocking_period.value =='0')
	{
		document.forms[0].bed_block_until.value='';
	}
	var period_no=eval(document.forms[0].bed_blocking_period.value);
	if(period_no>0)
	{
		if (eval(document.forms[0].bed_blocking_period.value) > eval(document.forms[0].def_max_period.value))
		{
			var error = getMessage('BED_BLK_PRD_CANT_EXCEED','IP');
			error = error.replace('$',getLabel("eIP.BlockPeriod.label","IP"));
			alert(error);
			document.forms[0].bed_blocking_period.select();
		}
		else
			getBlockBedDate1();
	}
	
}
function allowOnlyNumbers(event)
{
	if (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 46))
		return true;
	else return false;
}


function PopulateSubService()
{

}


function setDesable()
{
	document.getElementById('legend2').innerHTML	    =	"";
	document.getElementById('select2').style.visibility	    =	"Hidden"; 
}

</script>
</head>

 <body onload='getOnload_tfrDtls();'onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 

	<%
			java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt						= new java.util.Date();
			String d			= dateFormat.format( dt ) ;
			String min			= String.valueOf(dt.getMinutes()) ;
            if(min.length() == 1)   min = "0"+min ;

			d=d + " "+String.valueOf(dt.getHours())+":"+min;

			String patientid		= checkForNull(request.getParameter("patient_id"));			
			String eid				= checkForNull(request.getParameter("encounter_id"));

			session.putValue("encounter_id",eid);
			session.putValue("patientid",patientid);
	
			long encounterid = 0;
			String admissiondate	= "";
			String admissiontype	= "";
			String transfer_date2 = "";
			String transfer_type2 = "";
			String transfer_type_desc = "";

			String tonursingunitcode	= "" ;
			String tonursingunitdesc	= "" ;
			String toservicecode		= "" ;
			String tobedclass			= "" ;
			String tobedtype			= "" ;
			String tobedtypedesc		= "" ;
			String tobedclassdesc		= "" ;
			String tobedno				= "" ;
			String toroomno			= "" ;
			String tospecialitycode	= "" ;
			String tospecialitydesc	= "" ;
			String topractitionerid	= "" ;
			String topractdesc			= "" ;
			String toteamid			= "" ;
			String tosubservcode		= "" ;
			String TRN_TYPE 			= "" ;
			String blocking_period 	= "" ;
			String blocking_remark 	= "" ;
			String blocking_type_code 	= "" ;
			String mother_bed_status	= "" ;

			if(bl_operational.equals("Y"))
			{
				if(SqlSB.length() > 0)
					SqlSB.delete(0, SqlSB.length());

				SqlSB.append(" select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a, BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+eid+"' ");
				rs_opn = stmt.executeQuery(SqlSB.toString());
				while(rs_opn.next())
				{
					billing_group_id = rs_opn.getString("BLNG_GRP_ID");
					billing_group_desc = rs_opn.getString("SHORT_DESC");
				}
			}	

			if(rs_opn != null) rs_opn.close();
			if(stmt != null) stmt.close();
			
			if(SqlSB.length() > 0)
				SqlSB.delete(0, SqlSB.length());
/*
			SqlSB.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
			stmt_opn = con.createStatement();
			rs_opn = stmt_opn.executeQuery(SqlSB.toString());

			if (rs_opn.next())
			{
			}

*/
			
			%>
	<form name="EmergencyTransfer_form" id="EmergencyTransfer_form"  method="post" action="../../servlet/eIP.EmergencyTransferServlet" target="parent.frames[1]">
	<table border=0 width="100%" cellpadding=0 cellspacing=0>
		
	<%--<%
		if(install_yn.equals("N"))
		{%>
		<br><br><br>
		<%}
	%><tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>--%>
		<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>	


<%
	//ragha 9/6/2004

		if(SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());
		SqlSB.append(" select to_char(admission_date_time,'dd/mm/rrrr hh24:MI') admission_date, admission_short_desc,nursing_unit_code,nursing_unit_short_desc, specialty_code, specialty_short_desc, practitioner_id, practitioner_name,room_no,bed_no,bed_class_code,bed_class_short_desc, null dly_charge,  nursing_unit_type_code, bed_type_code,BED_TYPE_SHORT_DESC,gender,to_char (date_of_birth, 'dd/mm/rrrr') date_of_birth, service_code, service_short_desc,SUBSERVICE_CODE,SUBSERVICE_SHORT_DESC,subservice_short_desc,patient_class,team_desc,team_id, to_char(modified_date,'dd/mm/rrrr hh24:mi') modified_date from IP_OPEN_ENCOUNTER_VW where facility_id = '"+facilityId+"' and encounter_id = "+eid ); 
		
		stmt  = con.createStatement();
		rset  = stmt.executeQuery(SqlSB.toString());
		if(rset.next())
		{
			admissiondate		= checkForNull(rset.getString("admission_date"));
			admissiontype		= checkForNull(rset.getString("admission_short_desc"));
			frnursingunitcode	= checkForNull(rset.getString("nursing_unit_code")); 
			modified_date_val	= checkForNull(rset.getString("modified_date"));				
			frbedno				= checkForNull(rset.getString("bed_no"));
			frpractitionerid	= checkForNull(rset.getString("practitioner_id")); 
			frpractdesc			= checkForNull(rset.getString("practitioner_name"));
			frspecialitycode	= checkForNull(rset.getString("specialty_code"));   
			frspecialitydesc	= checkForNull(rset.getString("specialty_short_desc"));
			frbedclass			= checkForNull(rset.getString("bed_class_code"));  
			frbedclassdesc		= checkForNull(rset.getString("bed_class_short_desc")); 
			frnursingunitdesc	= checkForNull(rset.getString("nursing_unit_short_desc")); 
			frroomno			= checkForNull(rset.getString("room_no"));
			frbedtype			= checkForNull(rset.getString("bed_type_code")); 
			frbedtypedesc		= checkForNull(rset.getString("BED_TYPE_SHORT_DESC"));
			frdailycharge		= rset.getInt("dly_charge");
			age					= checkForNull(rset.getString("date_of_birth"));
			gender				= checkForNull(rset.getString("gender"));
			frservicecode		= checkForNull(rset.getString("service_code"));
			frservicedesc		= checkForNull(rset.getString("service_short_desc"));
			frsubservcode		= checkForNull(rset.getString("SUBSERVICE_CODE"));
			frsubservdesc		= checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
			patient_class		= checkForNull(rset.getString("PATIENT_CLASS"));
			frmeddesc			= checkForNull(rset.getString("TEAM_DESC"));
			frmedid				= checkForNull(rset.getString("TEAM_ID"));

		}
	
			if(rset != null) rset.close();
			if(rs_opn != null) rs_opn.close();
			if(stmt != null) stmt.close();	
%>

		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			 <td width="30%" class='querydata'><input type="hidden" name="admission_date" id="admission_date" value="<%=admissiondate%>" ><%=admissiondate%></td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
			<td width="35%" class='querydata'><input type="hidden" name="admission_type" id="admission_type" value="<%=admissiontype%>" >&nbsp;&nbsp;<%=admissiontype%></td> 
		</tr>

<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
<%
	if(SqlSB.length() > 0)
		SqlSB.delete(0, SqlSB.length());
			

	SqlSB.append(" select to_char(REQUEST_DATE,'dd/mm/rrrr hh24:MI') request_date, TRANSFER_TYPE_SHORT_DESC, TRANSFER_TYPE_CODE,req_nursing_unit_code,ip_get_desc.ip_nursing_unit (facility_id, req_nursing_unit_code, 'en', '2') req_nursing_unit_short_desc,to_service_code, am_get_desc.am_service (to_service_code, 'en', '2') to_service_short_desc, to_subservice_code,am_get_desc.am_subservice (to_service_code, to_subservice_code, 'en', '2') to_subservice_short_desc,       req_bed_class_code, ip_get_desc.ip_bed_class (req_bed_class_code, 'en', '2') req_bed_class_short_desc,req_bed_type_code, ip_get_desc.ip_bed_type (req_bed_type_code, 'en', '2') req_bed_type_short_desc, req_bed_no,req_room_no, to_specialty_code, am_get_desc.am_speciality (to_specialty_code, 'en', '2') to_specialty_short_desc,to_practitioner_id, am_get_desc.am_practitioner (to_practitioner_id, 'en', '1') to_practitioner_name, to_team_id,am_get_desc.am_medical_team (facility_id, to_team_id, 'en', '2') to_team_short_desc, trn_type, blocking_period,blocking_remarks, blocking_type_code, delink_baby_yn from ip_bed_class_request_vw where encounter_id ='"+eid+"' and facility_id = '"+facilityId+"' and request_status='0' ");
	stmt  = con.createStatement();
	
	rset  = stmt.executeQuery(SqlSB.toString());
	if(rset.next())
	{
			transfer_date2	= checkForNull(rset.getString("request_date"));
			transfer_type_desc	= checkForNull(rset.getString("TRANSFER_TYPE_SHORT_DESC"));
			transfer_type2		= checkForNull(rset.getString("TRANSFER_TYPE_CODE"));

			tonursingunitcode	= checkForNull(rset.getString("REQ_NURSING_UNIT_CODE"));
			tonursingunitdesc	= checkForNull(rset.getString("REQ_NURSING_UNIT_SHORT_DESC"));
			toservicecode		= checkForNull(rset.getString("TO_SERVICE_CODE"));
			tobedclass			= checkForNull(rset.getString("REQ_BED_CLASS_CODE"));
			tobedtype			= checkForNull(rset.getString("REQ_BED_TYPE_CODE"));
			tobedtypedesc		= checkForNull(rset.getString("REQ_BED_TYPE_SHORT_DESC"));
			tobedclassdesc		= checkForNull(rset.getString("REQ_BED_CLASS_SHORT_DESC"));
			tobedno				= checkForNull(rset.getString("REQ_BED_NO"));
			toroomno			= checkForNull(rset.getString("REQ_ROOM_NO"));
			tospecialitycode	= checkForNull(rset.getString("TO_SPECIALTY_CODE"));
			tospecialitydesc	= checkForNull(rset.getString("TO_SPECIALTY_SHORT_DESC"));
			topractitionerid	= checkForNull(rset.getString("TO_PRACTITIONER_ID"));
			topractdesc			= checkForNull(rset.getString("TO_PRACTITIONER_NAME"));
			toteamid			= checkForNull(rset.getString("TO_TEAM_ID"));
			tosubservcode		= checkForNull(rset.getString("TO_SUBSERVICE_CODE"));
			TRN_TYPE 			= checkForNull(rset.getString("TRN_TYPE"));
			blocking_period 	= checkForNull(rset.getString("BLOCKING_PERIOD"));
			blocking_remark 	= checkForNull(rset.getString("BLOCKING_REMARKS"));
			blocking_type_code 	= checkForNull(rset.getString("BLOCKING_TYPE_CODE"));
			mother_bed_status	= checkForNull(rset.getString("DELINK_BABY_YN"));
	}

	if(rset != null) rset.close();
	if(stmt != null) stmt.close();	

%>

		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td class='querydata' width="30%"><input type="hidden" name="transfer_date" id="transfer_date"  value="<%=transfer_date2%>"> <%=transfer_date2%> </td>
			<td align="right" class="label" width="25%" ><fmt:message key="eIP.ReasonforTransfer.label" bundle="${ip_labels}"/></td>
			<td width="35%" class='querydata'>&nbsp;&nbsp;<%=transfer_type_desc%>
			<input type="hidden" name="transfer_type_code" id="transfer_type_code"  value="<%=transfer_type2%>">

				
</td>
</tr>
<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>

<tr>
		<td align="right" class="label"><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/> &nbsp;</td>
		<td class='querydata' width="30%">

		<SELECT name="reqstat" id="reqstat" onchange='disableselect()'>
		<option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option> 
		<option value="1"><fmt:message key="Common.confirm.label" bundle="${common_labels}"/></option>
		<option value="2"><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></option>
		</SELECT>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
		<td align="right" class="label" width="25%">&nbsp;&nbsp;</td>
		<td></td>
			</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
		<tr>
	
		<td align="right" class="label" width="20%"  id='legend2'></td>
		 <td width="20%" class='querydata' colspan=4>
		<SELECT name="resnforrej" id="resnforrej" id='select2' style='visibility:hidden' >
		<option value="" align='center'>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option> 
 
	<%
		 String contact_reason="";
		String contact_reason_code="";
	try{
		stmt = con.createStatement();
	    rset = stmt.executeQuery("select contact_reason_code, contact_reason from am_contact_reason where eff_status = 'E' and cancel_transfer_yn = 'Y' order by 2");   
        if( rset != null ) {
	      while(rset.next()) {
			 contact_reason   = rset.getString("contact_reason") ;
			 contact_reason_code   = rset.getString("contact_reason_code") ;
		%><OPTION VALUE="<%=contact_reason_code %>" ><%=contact_reason%><%
          }
	    }
	}catch(Exception e) {out.println(e.toString()); e.printStackTrace();}
	
%>

	 	</SELECT>
			<img align="center" id='rejection' src="../../eCommon/images/mandatory.gif">
		</td> 


	
</tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>

		</table>



<jsp:include page="../../eIP/jsp/TransferDetails.jsp" flush="true">
<jsp:param name ="call_function"  value="Change_Bedclass" />

		<jsp:param name ="admissiondate"  value="<%=admissiondate%>" />
		<jsp:param name ="frnursingunitcode"  value="<%=frnursingunitcode%>" />
		<jsp:param name ="frbedno"  value="<%=frbedno%>" />
		<jsp:param name ="frpractitionerid"  value="<%=frpractitionerid%>" />
		<jsp:param name ="frpractdesc"  value="<%=frpractdesc%>" />
		<jsp:param name ="frspecialitycode"  value="<%=frspecialitycode%>" />
		<jsp:param name ="frspecialitydesc"  value="<%=frspecialitydesc%>" />
		<jsp:param name ="frbedclass"  value="<%=frbedclass%>" />
		<jsp:param name ="frbedclassdesc"  value="<%=frbedclassdesc%>" />
		<jsp:param name ="frnursingunitdesc"  value="<%=frnursingunitdesc%>" />
		<jsp:param name ="frroomno"  value="<%=frroomno%>" />
		<jsp:param name ="frbedtype"  value="<%=frbedtype%>" />
		<jsp:param name ="frbedtypedesc"  value="<%=frbedtypedesc%>" />
		<jsp:param name ="frdailycharge"  value="<%=frdailycharge%>" />
		<jsp:param name ="age"  value="<%=age%>" />
		<jsp:param name ="gender"  value="<%=gender%>" />
		<jsp:param name ="frservicecode"  value="<%=frservicecode%>" />
		<jsp:param name ="frservicedesc"  value="<%=frservicedesc%>" />
		<jsp:param name ="frsubservcode"  value="<%=frsubservcode%>" />
		<jsp:param name ="frsubservdesc"  value="<%=frsubservdesc%>" />
		<jsp:param name ="patient_class"  value="<%=patient_class%>" />
		<jsp:param name ="frmeddesc"  value="<%=frmeddesc%>" />
		<jsp:param name ="frmedid"  value="<%=frmedid%>" />
		
		<jsp:param name ="tonursingunitcode"  value="<%=tonursingunitcode%>" />
		<jsp:param name ="tonursingunitdesc"  value="<%=tonursingunitdesc%>" />
		<jsp:param name ="toservicecode"  value="<%=toservicecode%>" />
		<jsp:param name ="tobedclass"  value="<%=tobedclass%>" />
		<jsp:param name ="tobedtype"  value="<%=tobedtype%>" />
		<jsp:param name ="tobedtypedesc"  value="<%=tobedtypedesc%>" />
		<jsp:param name ="tobedclassdesc"  value="<%=tobedclassdesc%>" />
		<jsp:param name ="toroomno"  value="<%=toroomno%>" />
		<jsp:param name ="tobedno"  value="<%=tobedno%>" />
		<jsp:param name ="tospecialitycode"  value="<%=tospecialitycode%>" />
		<jsp:param name ="tospecialitydesc"  value="<%=tospecialitydesc%>" />
		<jsp:param name ="topractitionerid"  value="<%=topractitionerid%>" />
		<jsp:param name ="topractdesc"  value="<%=topractdesc%>" />
		<jsp:param name ="toteamid"  value="<%=toteamid%>" />
		<jsp:param name ="tosubservcode"  value="<%=tosubservcode%>" />
		<jsp:param name ="TRN_TYPE"  value="<%=TRN_TYPE%>" />
		<jsp:param name ="blocking_period"  value="<%=blocking_period%>" />
		<jsp:param name ="blocking_remark"  value="<%=blocking_remark%>" />
		<jsp:param name ="blocking_type_code"  value="<%=blocking_type_code%>" />
		<jsp:param name ="mother_bed_status"  value="<%=mother_bed_status%>" />		
		 
	
</jsp:include> 

	<TABLE border=0 width="100%" cellpadding=0 cellspacing=0>
	<tr>
        
	<% if(install_yn.equals("Y")) {%><td><input type="hidden" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Compute.label","common_labels")%>" onclick="ComputeBlDtl();"></td> <%}%>
		<td align='right'><input type="button" class="button" name="transfer" id="transfer" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="submitForm_confirm();">&nbsp;<input type="button" class="button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="cancel();">&nbsp;</td>
	</tr>
	
	</table>	
		<input type="hidden" name="modified_date_val" id="modified_date_val" value="<%=modified_date_val%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
		<input type="hidden" name="call_function" id="call_function" value="Change_Bedclass">
		<input type='hidden' name='modified_bed_type_code' id='modified_bed_type_code' value=''>
		<input type='hidden' name='billing_group_id' id='billing_group_id' value="<%=billing_group_id%>">
		<input type='hidden' name='billing_group_desc' id='billing_group_desc' value="<%=billing_group_desc%>">
		<input type="hidden" name="tobedtype" id="tobedtype" value="">
		<input type="hidden" name="fr_team_id" id="fr_team_id" value="">
		<input type="hidden" name="open_enctr_gender" id="open_enctr_gender" value="<%=gender%>">
		<input type="hidden" name="open_enctr_age" id="open_enctr_age" value="<%=age%>">
		<input type="hidden" name="bl_interface_yn" id="bl_interface_yn" value="<%=install_yn%>">
		<input type="hidden" name="fr_daily_rate" id="fr_daily_rate" value="0">
		<input type="hidden" name="to_daily_rate" id="to_daily_rate" value="0">
		<input type="hidden" name="bill_type_code" id="bill_type_code" value="">
		<input type="hidden" name="blng_class_code" id="blng_class_code" value="">
		<input type="hidden" name="blng_serv_code" id="blng_serv_code" value="">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
		<input type="hidden" name="continue_yn" id="continue_yn" value="">
		<input type='hidden' name = 'bl_operational' value='<%=bl_operational%>'>
		<input type="hidden" name="def_max_period" id="def_max_period" value="<%=bed_block_period_max%>">
		<input type="hidden" name="blocking_type_code" id="blocking_type_code" value="">
		<input type="hidden" name="bed_class_allowed" id="bed_class_allowed" value="<%=bed_class_allowed%>">	
		<input type="hidden" name="reqRadioBtn" id="reqRadioBtn" value=""><!--Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866-->
	<%
	if(install_yn.equals("Y"))
	{
	%>
		<input type='hidden' name='transfer_chargeable_yn' id='transfer_chargeable_yn' value='Y'>
		<input type='hidden' name='transfer_serv_charge' id='transfer_serv_charge' value=''>
		<input type='hidden' name='surgery_reqd_yn' id='surgery_reqd_yn' value='Y' >
		<input type='hidden' name='addnl_dep_amt' id='addnl_dep_amt' value=''>

	<%
	}
	%>
	<table border=0 cellpadding=0 cellspacing=0 align="right" height='100%' width=100%>
	<tr>
		<!-- MOD#06 Button is changed to hidden -->
		<% if(install_yn.equals("Y")) {%><td><input type="hidden" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Compute.label","common_labels")%>" onclick="ComputeBlDtl();"></td> <%}%>
				
	     <td class="label">&nbsp;</td>
         
	</tr>
	</table>
<script>

		var count=0
			if(count==0)
			{
				popDynamicValues_confirm(document.forms[0].nursing_unit);
				count++;
			}

function cancel()
{
	window.close();
}


</script>
	</form>
<%		
		if(rset		!= null)   rset.close();
		if(stmt		!= null)   stmt.close();
	
	}catch(Exception e)
	{
		out.print("Exception :"+e);
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
	 %>
	 

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


