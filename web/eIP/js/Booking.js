	function populatepatDetails()
{
	document.forms[0].patient_id.onblur();
	document.forms[0].patient_id.disabled= true;
}


async function openBooking(call_func, Patient_Id, medical_service, booking_date_time, medical_speciality_desc, medical_speciality_code, physician_desc, physician_code)
{
	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop	= "10" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eIP/jsp/Booking.jsp?call_func="+call_func+"&Patient_Id="+Patient_Id+"&medical_service="+medical_service+"&booking_date_time="+booking_date_time+"&medical_speciality_desc="+medical_speciality_desc+"&medical_speciality_code="+medical_speciality_code+"&physician_desc="+physician_desc+"&physician_code="+physician_code,arguments,features);
}
async function NursingUnitLookup(Facility_ID, Login_User, Operator_Station_ID)
{

	var locale					= document.booking_form.locale.value;
	if(document.forms[0].Splcode_desc.value != "")
	{
		var Facility_ID				= Facility_ID;
		var Login_User				= Login_User;
		var Operator_Station_ID		= Operator_Station_ID;
		var target					= document.forms[0].nursing_unit_desc;
		var sql						= "";
		var retVal					= new String();
		var argumentArray			= new Array() ;
		var dataNameArray			= new Array() ;
		var dataValueArray			= new Array() ;
		var dataTypeArray			= new Array() ;
		var tmpVar					= document.forms[0].med_service_grp.value.split('#');
		var appPatClass				= document.forms[0].app_pat_class.value;
		var call_function			= document.forms[0].call_function.value
		//Added by kishore on 5/10/2004 for Nursingunit lookup validation
		if (document.forms[0].med_service_grp.value == "")
		{
			
			var msg = getMessage('CAN_NOT_BE_BLANK',"Common");
			msg = msg.replace('$',getLabel("eIP.MedicalServiceGroup.label","IP"));

			if((call_function=='OA_IP_Booking' || call_function=='CA_Task_IP_Booking' || call_function=='CA_Clinician_IP_Booking' || call_function=='OT') && msg != "")
			{
				parent.frames[2].location.href='../../eIP/jsp/IPError.jsp?home_required_yn=N&err_num='+msg;
			}
			else if(msg != "")
				parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"";
			//document.forms[0].med_service_grp.focus();
			return false;
		}

		var tit						= getLabel("Common.nursingUnit.label","Common");
		var dialogHeight			= "400px" ;
		var dialogWidth				= "700px" ;
		var status					= "no";
		var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
		var arguments				= "" ;
		
		var nursingUnitCode			= document.forms[0].nursing_unit_desc.value;
		var splty_code				= document.forms[0].Splcode.value;
		var pract_id				= document.forms[0].practid.value;
		
		var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&specilaty_code="+splty_code+"&pract_id="+pract_id+"&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&patientclass=IP&call_function="+call_function+"&med_ser_grp_code="+tmpVar[0]+"&bkg_type=I";

		
		/*if(document.forms[0].practid.value != "")
		{

			
			sql = " SELECT A.NURSING_UNIT_CODE CODE, A.SHORT_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, IP_MED_SER_GRP_NURS_UT_TYPE B, IP_NURS_UNIT_FOR_SPECIALTY C, IP_NURSING_UNIT_FOR_PRACT D, AM_OS_USER_LOCN_ACCESS_VW E WHERE A.LANGUAGE_ID = '"+locale+"' AND A.FACILITY_ID = '"+Facility_ID+"'  AND A.EFF_STATUS = 'E' AND B.FACILITY_ID = A.FACILITY_ID AND B.MED_SER_GRP_CODE = '"+tmpVar[0]+"' AND B.NURSING_UNIT_TYPE_CODE = A.NURSING_UNIT_TYPE_CODE AND C.FACILITY_ID = A.FACILITY_ID AND C.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND C.SPECIALTY_CODE = '"+document.forms[0].Splcode.value+"' AND D.FACILITY_ID = A.FACILITY_ID AND D.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND D.PRACTITIONER_ID = '"+document.forms[0].practid.value+"' AND E.FACILITY_ID = A.FACILITY_ID AND E.OPER_STN_ID  ='"+Operator_Station_ID+"' AND E.APPL_USER_ID = '"+Login_User+"' AND E.LOCN_TYPE = 'N' AND A.PATIENT_CLASS = 'IP' AND E.LOCN_CODE = A.NURSING_UNIT_CODE AND (E.CREATE_BOOKING_YN = 'Y' OR E.CREATE_BOOKING_WITH_CONF_YN = 'Y') AND UPPER(A.NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(A.SHORT_DESC) LIKE UPPER(?) ";
	
			argumentArray[0]	= sql;
			argumentArray[1]	= dataNameArray ;
			argumentArray[2]	= dataValueArray ;
			argumentArray[3]	= dataTypeArray ;
			argumentArray[4]	= "1,2";
			argumentArray[5]	= document.forms[0].nursing_unit_desc.value;
			argumentArray[6]	= DESC_LINK;
			argumentArray[7]	= DESC_CODE;
			
		}
		else
		{

			
			sql = "SELECT A.NURSING_UNIT_CODE CODE, A.SHORT_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, IP_MED_SER_GRP_NURS_UT_TYPE B, IP_NURS_UNIT_FOR_SPECIALTY C, AM_OS_USER_LOCN_ACCESS_VW E WHERE A.LANGUAGE_ID = '"+locale+"' AND A.FACILITY_ID = '"+Facility_ID+"'  AND A.EFF_STATUS = 'E' AND B.FACILITY_ID = A.FACILITY_ID AND B.MED_SER_GRP_CODE = '"+tmpVar[0]+"' AND B.NURSING_UNIT_TYPE_CODE = A.NURSING_UNIT_TYPE_CODE AND C.FACILITY_ID = A.FACILITY_ID AND C.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND C.SPECIALTY_CODE = '"+document.forms[0].Splcode.value+"' AND E.FACILITY_ID = A.FACILITY_ID  AND E.OPER_STN_ID ='"+Operator_Station_ID+"' AND E.APPL_USER_ID = '"+Login_User+"' AND E.LOCN_TYPE = 'N' AND A.PATIENT_CLASS = 'IP' AND E.LOCN_CODE = A.NURSING_UNIT_CODE AND (E.CREATE_BOOKING_YN = 'Y' OR E.CREATE_BOOKING_WITH_CONF_YN = 'Y') AND UPPER(A.NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(A.SHORT_DESC)  LIKE UPPER(?) ";
	
			argumentArray[0]	= sql;
			argumentArray[1]	= dataNameArray ;
			argumentArray[2]	= dataValueArray ;
			argumentArray[3]	= dataTypeArray ;
			argumentArray[4]	= "1,2";
			argumentArray[5]	= document.forms[0].nursing_unit_desc.value;
			argumentArray[6]	= DESC_LINK;
			argumentArray[7]	= DESC_CODE;
		}*/
		
		//retVal = await CommonLookup( tit, argumentArray );

		retVal =  await window.showModalDialog(jsp_name,arguments, features);


		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			//arr=ret1.split(",");
			arr=ret1.split("~");
			document.forms[0].nursing_unit_desc.value=arr[1];
			document.forms[0].nursing_unit.value=arr[0];
			document.forms[0].nurs_unit_desc_hid.value = document.forms[0].nursing_unit_desc.value

		}
		else
		{
			document.forms[0].nursing_unit_desc.value="";
			document.forms[0].nursing_unit.value="";
			document.forms[0].service_code.value="";
			document.forms[0].service_desc.value="";
		}
		if(document.forms[0].confirm_yn.value == 'Y')
		{
			delete_values(document.getElementById('bed_type_desc'));
			document.forms[0].bed_class_desc.value = '';
			document.forms[0].bed_no.value = '';
			document.forms[0].room_no.value = '';
		}
	}
	else
	{
		alert(getMessage("SPLTY_NOTNULL","IP"));
		document.forms[0].Splcode_desc.focus();
		document.forms[0].nursing_unit_desc.value = "";
	}
	if(document.forms[0].confirm_yn.value == 'Y')
	{
		document.forms[0].bed_no.value = "";
	//	document.forms[0].bed_no.disabled = false;
		document.forms[0].bed_avail_chart.disabled = false;
	}


	if( document.forms[0].nursing_unit_desc.value=="")
	{
// 		document.forms[0].bed_no.disabled=false;
		if(document.forms[0].confirm_yn.value == 'Y')
			document.forms[0].bed_avail_chart.disabled=false;
	}

	PopulateService();
}


function create()
{
	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyBooking.jsp" ;
}

function chkInsure() 
{
	f_query_add_mod.document.booking_form.nationality_code1.disabled=false;
	f_query_add_mod.document.booking_form.nationality_code1.disabled=true;
	f_query_add_mod.document.booking_form.submit();	
}

function CheckProcDtTime(obj) 
{
	if(obj.value!="")
	{
		if(parent.f_query_add_mod.document.forms[0].ot_date_time.value!="")
		parent.f_query_add_mod.document.forms[0].ot_date_time.focus();
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
            //obj.select();
            //obj.focus();
            //return false;
			obj.value = '1';
			return true;
        }
    }
}

function callApply_bl() 
{
	var fields=new Array();
	fields[0]= document.booking_form.pref_adm_date;
	fields[1]= document.booking_form.med_service_grp;
	fields[2]= document.booking_form.sex;
	fields[3]= document.booking_form.date_of_birth;
	fields[4]= document.booking_form.nationality_code1;
	fields[5]= document.booking_form.practid;
	fields[6]= document.booking_form.Splcode;

	var names = new Array (	getLabel("eIP.PrefAdmDateTime.label","IP"),
				getLabel("eIP.MedicalServiceGroup.label","IP"),
				getLabel("Common.gender.label","Common"),
				getLabel("Common.birthDate.label","Common"),
				getLabel("Common.nationality.label","Common"),
				getLabel("Common.practitioner.label","Common"),
				getLabel("Common.speciality.label","Common")
			      ) ;
		var p = 7;

	if (!document.booking_form.booking_ref_no.disabled)
	{
		 fields[p]= document.booking_form.booking_ref_no;
		 names[p] =  getLabel("Common.BookingRefNo.label","Common");
		 p++;
	}

	if (document.booking_form.id2)
	{
		// fields[p]= document.booking_form.name_prefix1;
		 //names[p]= document.booking_form.name_prefix1.name
		 fields[p]= document.booking_form.name_prefix;
		 names[p]= document.booking_form.name_prefix.name
		 p++;
	}

	if (document.booking_form.fid)
	{
		 fields[p]= document.booking_form.first_name;
		 names[p]= document.booking_form.First_Name_Prompt.value;
		 p++;
	





	}

	if (document.booking_form.sid)
	{
		 fields[p]= document.booking_form.second_name;
		 names[p]= document.booking_form.Second_Name_Prompt.value;
		 p++;
	}

	if (document.booking_form.tid)
	{
		 fields[p]= document.booking_form.third_name;
		 names[p]= document.booking_form.Third_Name_Prompt.value;
		 p++;
	}

	if (document.booking_form.faid)
	{
		 fields[p]= document.booking_form.family_name;
		 names[p]= document.booking_form.Family_Name_Prompt.value
		 p++;
	}

	if (document.booking_form.id1)
	{
		 //fields[p]= document.booking_form.name_suffix1;
		 //names[p]= document.booking_form.Name_Suffix_Prompt.value 
		 fields[p]= document.booking_form.name_suffix;
		 names[p]= document.booking_form.Name_Suffix_Prompt.value 
		 p++;
	}

	if(checkFields( fields, names, parent.messageFrame))
	{
		//document.booking_form.name_prefix1.disabled=false;
		document.booking_form.name_prefix.disabled=false;
		document.booking_form.submit();
	}
}

function apply()
{	
	var retFlag = true;

	if(retFlag)
	{		
		//if(f_query_add_mod.document.booking_form.bed_no!=null && f_query_add_mod.document.booking_form.bed_no.value!='')
		//{
			//validateBedNo(f_query_add_mod.document.booking_form.bed_no);
		//}
		//else
			setTimeout('callApply();','500');

	}
	else
	{
		var errors='';
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
	}
}

function populateNursingUnitDtls(getVal)
{

}

function checkFieldsForCA( fields, names, messageFrame) 
{
/*
	if(checkFields( fields, names, messageFrame))
	{
		parent.parent.frames[0].document.forms[0].home.disabled = true;
		return true;
	}
	else
	{
		return false;
	}
*/

	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		else
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
	}
	if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eIP/jsp/IPError.jsp?home_required_yn=N&err_num="+errors ;
		return false ;
	}
	return true ;

}


function checkFieldsForOA( fields, names, messageFrame) 
{
	
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		else
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
	}
	if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eIP/jsp/IPError.jsp?home_required_yn=N&err_num="+errors ;
		return false ;
	}
	return true ;
}

function reset()
{

	//f_query_add_mod.document.forms[0].is_op_pending_referral_booking.value=="Y"
	if(f_query_add_mod.document.forms[0].call_function.value=="CA_Clinician_IP_Booking" || f_query_add_mod.document.forms[0].call_function.value=="CA_Task_IP_Booking"  )
	 {
		f_query_add_mod.document.booking_form.reset();
		//f_query_add_mod.document.booking_form.pref_adm_date.focus();
	 }
	else 
	{	
		parent.content.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?'+f_query_add_mod.document.booking_form.qryString.value;/*16922 Saturday, December 05, 2009 */
		f_query_add_mod.location.reload();
	}
}

// When called from CA
function disableFields()
{
	if(parent.frames[0].document.getElementById('create'))
		parent.frames[0].document.getElementById('create').disabled=true; 
	if(parent.frames[0].document.getElementById('home'))
		parent.frames[0].document.getElementById('home').disabled=true;
}

function onSuccess()
{
	f_query_add_mod.location.reload();
}

function ChangeVal(obj)
{
	
	var sStyle = document.forms[0].sStyle.value;
	var obj_value 	= obj.value;
	var source_type = "";
    var prefadmdate = "";
	var nursunitcode= "";
	if (obj.name == "med_service_grp")
	{
	    var strDateArray = new Array();
	    var gennum;
		var appPatClass;
	    var medcode;
	    strDateArray = obj_value.split("#");

	    medcode = strDateArray[0];
	    gennum  = strDateArray[1];
		appPatClass = strDateArray[2];
		parent.frames[1].document.forms[0].app_pat_class.value = appPatClass;

		//prefadmdate = parent.frames[1].document.forms[0].pref_adm_date.value;
		prefadmdate = convertDate(parent.frames[1].document.forms[0].pref_adm_date.value,"DMYHM",localeName,"en");
		if(gennum == "Y")
	    {
	    	parent.frames[1].document.forms[0].generatenumyn.value='Y';
	    	parent.frames[1].document.forms[0].gifpop.style.visibility="hidden";
	    }
	    else
	    {
			if(obj.value == "")
			{
				parent.frames[1].document.forms[0].generatenumyn.value='Y';
	    		parent.frames[1].document.forms[0].gifpop.style.visibility="hidden";			
			}
			else
			{
				parent.frames[1].document.forms[0].booking_ref_no.value="";
				parent.frames[1].document.forms[0].generatenumyn.value='N';
				parent.frames[1].document.forms[0].gifpop.style.visibility="visible";
			}
	    }

	    source_type = "VAL_MED_GRP";
	    var medservcode= medcode;
		if(document.forms[0].app_pat_class.value != "DC") 
		{
			parent.frames[1].document.forms[0].exp_days_of_stay.disabled = false;;
		}

	}
	else
	{
	    source_type = "VAL_DATE";
	}

	if (obj.name == "pref_adm_date")
	{
		prefadmdate= obj_value;
		//prefadmdate=parent.frames[1].document.forms[0].pref_adm_date.value;
		prefadmdate = convertDate(parent.frames[1].document.forms[0].pref_adm_date.value,"DMYHM",localeName,"en");
	 
	}

	if(obj.name == "med_service_grp" && prefadmdate == "")
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel("eIP.PrefAdmDateTime.label","IP"));
		alert(error);
		if(document.forms[0].call_function.value != "OT")/*Tuesday, December 21, 2010 , added for MO-GN-5329 [IN:025559], med_service_grp field getting cleared when this validation happend*/
			obj.value = "";
	}
	if (obj.name == "bed_no")
	{
		var bed_no= obj_value;
		bed_no=parent.frames[1].document.forms[0].bed_no.value
		source_type="REVISE_VAL_ROOM_NO";
	}
	else
	{
		if (obj_value != null && obj_value != "")
		{
			var isOTFunc = 'N';
			if(parent.frames[1].document.forms[0].call_function.value == 'OT')
				isOTFunc = 'Y';
			
			parent.frames[2].location.href='../../eCommon/jsp/error.jsp';

			var HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onKeyDown='lockKey()'><form name='fetchvalforbooking' id='fetchvalforbooking' method='post' action='../../eIP/jsp/FetchValForBooking.jsp'><input type='hidden' name='med_service_grp' id='med_service_grp' value='"+medservcode+"'><input type='hidden' name='isOTFunc' id='isOTFunc' value='"+isOTFunc+"'><input type='hidden' name='source_type' id='source_type' value='"+source_type+"'><input type='hidden' name='pref_adm_date' id='pref_adm_date' value='"+prefadmdate+"'><input type='hidden' name='bed_no' id='bed_no' value='"+bed_no+"'><input type='hidden' name='nursunitcode' id='nursunitcode' value='"+nursunitcode+"'>";
			
			HTMLVal = HTMLVal+"</form></body></html>";
			
			//parent.frames[2].document.write(HTMLVal);
			//parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.body.innerHTML = HTMLVal; 
			parent.frames[2].document.fetchvalforbooking.submit();			
		}
	}
	if ((obj.name == "bed_no") && (obj_value == null || obj_value == ""))
	{
		parent.frames[1].document.booking_form.bed_no.value="";
		parent.frames[1].document.booking_form.room_no.value="";
	}
}

function validateDatebk(obj,val)
{

	var prefDate  = self.booking_form.pref_adm_date.value;
	var OTtime = obj.value;

	if(obj.value != ''  || obj.value.length > 0)
	{
		if(doDatetimeCheckAlert(prefDate,OTtime))
		{
			obj.focus();
			obj.select();
		}
		else
		{

			if(self.doDateTimeChk(obj))
			{
				if(val == 'A')
				{
					var currdate = self.document.booking_form.currdate;
					if(ValidateDateTime1(obj,currdate))
					{
						obj.focus();
						obj.select();
					}
				}
			}
			else
			{
				alert(parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM"));
				obj.focus();
				obj.select();
			}
		 }
	}//E.O.IF
}

function ValidateDateTime1(from,to)
{
	from = from.value
	to		= to.value

	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]
	
	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	
	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]
	
	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")
	
	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	if(Date.parse(to_date) < Date.parse(from_date))
		return false
	else
		return true;	
}



function doDatetimeCheckAlert(to,from) 
{
	var fromarray;
	var toarray;
	var fromdate = from;
	var todate = to;
		
	if(fromdate.length > 0 && todate.length > 0 )
	{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) < Date.parse(fromdt)) 
				return false;
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}

}


 function PopulateMedicalTeam1()
 { 	
	med_code = document.forms[0].med_service_grp.value.split("#");
	spy_code = document.forms[0].Splcode.value;
	prt_code = document.forms[0].practid.value;

	var selected = booking_form.team_id;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);

	var	str1 = "" ;
	var	str2 = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var element = parent.frames[1].document.createElement('OPTION');
	element.text = str2; 
	element.value= str1;
	document.forms[0].team_id.add(element);

	var ippractid = booking_form.practid.value;
	var getservice=booking_form.practid.value;

	if (ippractid != null && ippractid != "")
	{
		
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='booking' id='booking' value='booking'><input type='hidden' name='med_code' id='med_code' value='"+med_code[0]+"'><input type='hidden' name='spy_code' id='spy_code' value='"+spy_code+"'><input type='hidden' name='prt_code' id='prt_code' value='"+prt_code+"'></form></body></html>";
		parent.messageFrame.document.write(HTMLVal);
		parent.messageFrame.document.querydept.submit();
	}
}

function chkAmbReqd(Obj)
{
	if(document.forms[0].amb_reqd_yn.checked)
	{
		Obj.value="Y";
		document.forms[0].amb_reqd_date_time.disabled = false;
		document.getElementById('ambul').disabled = false;
	}	
	else 
	{
		Obj.value="N";
		document.forms[0].amb_reqd_date_time.value = "";
		document.forms[0].amb_reqd_date_time.disabled = true;
		document.getElementById('ambul').disabled = true;
	}	
}



function bldFunc(Obj)
{
	if(Obj.checked == true)
		Obj.value="Y";
	else
		Obj.value="N";
}

function doOTDateTimeChk2(obj,callobj)
{
	
	var retval=true
	var varBodyFrame = "f_query_add_mod.document.forms[0]";
	if(callobj == "Apply")
	{
		varBodyFrame = "f_query_add_mod.document.forms[0]";
	}
	else
	{
		if(parent.frames[0].document.getElementById('home'))
			varBodyFrame = "parent.frames[1].document.forms[0]";
		else
			varBodyFrame = "parent.frames[1].frames[1].document.forms[0]";
		
	}
	
	


	if(parent.frames[1].document.forms[0].call_function.value == 'CA_Task_IP_Booking')
		varBodyFrame = "parent.frames[1].document.forms[0]";
	if(parent.frames[1].document.forms[0].call_function.value == 'OT')
		varBodyFrame = "parent.frames[1].document.forms[0]";
	if(parent.frames[1].document.forms[0].call_function.value == 'OA_IP_Booking')
		varBodyFrame = "parent.frames[1].document.forms[0]";
	if(parent.frames[1].document.forms[0].is_op_pending_referral_booking.value=='Y')
		varBodyFrame = "parent.frames[1].document.forms[0]";
//modified on 09/07/2008 for SCR 4700
	if(parent.frames[1].document.forms[0].call_function.value == 'CA_Clinician_IP_Booking')
		varBodyFrame = "parent.frames[1].document.forms[0]";
//	
	
	
	if(obj.value != '')
	{
		//if(doDateTimeChk_local(obj))
		if(validDateObj(obj,"DMYHM",localeName))
		{
			retval = true;
		}
		else
		{
			//alert(getMessage("INVALID_DATE_TIME","SM"));
			retval= false;			
			//obj.focus();
		}
		if(retval)	
		{	
			
			//if(parent.frames[1].document.forms[0].call_function.value == 'OT')
			//{
				//calcPrefDateForPreparationDay();

				
				if(callobj!='pref_adm_date' && callobj!='exp_days_of_stay')
				{
					if(document.forms[0].ot_date_time.value!='' && document.forms[0].pref_adm_date.value!='')
					{
						document.forms[0].pre_op_days.value = daysBetween(document.forms[0].pref_adm_date.value,document.forms[0].ot_date_time.value,'DMYHM',localeName);

						if(document.forms[0].pre_op_days.value!='0')
						{

							document.forms[0].exp_days_of_stay.value = document.forms[0].pre_op_days.value;
							
							var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
							document.forms[0].exp_discharge_date.value	= expdischargeDate;
						}
						
					}
					else if(document.forms[0].ot_date_time.value!='')
						document.forms[0].pref_adm_date.value='';
				}

				var flagForOTDate = calcPrefDateForPreparationDay1();
				if(flagForOTDate==false)
					return false;
			//}
			var greg_obj = convertDate(obj.value,"DMYHM",localeName,"en");
			var OTdate = greg_obj; 
			var prefdateobj = eval(varBodyFrame+".pref_adm_date").value; 	
			
			if(prefdateobj.length > 1)	
			{
				var prefdate = convertDate(eval(varBodyFrame+".pref_adm_date").value,"DMYHM",localeName,"en");
				var exp_days_of_stay = eval(varBodyFrame+".exp_days_of_stay").value;
				if(exp_days_of_stay == "" && parent.frames[1].document.forms[0].call_function.value != 'OT') 
				{
					retval = isBefore(prefdate, greg_obj, "DMYHM", 'en');
					//retval = ValidateDateTime(eval(varBodyFrame+".pref_adm_date"),obj);
					if(! retval)
					{
						var err = getMessage("DATE1_LT_DATE2","IP");
						err = err.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
						err = err.replace('#',getLabel("eIP.PrefAdmDateTime.label","IP"));
						alert(err);
						eval(varBodyFrame+".ot_date_time").select();
						eval(varBodyFrame+".ot_date_time").focus();
					
					}

				}
				else
					retval = ValidatePrefOTDateTime(prefdate,OTdate,exp_days_of_stay,varBodyFrame);
			}	
			/*else
			{
				alert(getMessage("PREF_ADMN_DATE_NOTNULL","IP"));			
				eval(varBodyFrame+".ot_date_time").value = "";
				eval(varBodyFrame+".ot_date_time").select();
				eval(varBodyFrame+".ot_date_time").focus();
			}	*/		
		}
		return retval
    }
	else
	{
		document.forms[0].pre_op_days.value		= "0"; 
		/*Below condtion added for this incident [043737]*/
		if(eval(varBodyFrame+".exp_days_of_stay"))
		document.forms[0].exp_days_of_stay.value		= eval(varBodyFrame+".exp_days_of_stay").value; 
	
		document.forms[0].exp_discharge_date.value		= ""; 
		if(document.forms[0].pref_adm_date.value!="")
		{
			var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
			document.forms[0].exp_discharge_date.value	= expdischargeDate;
		}

		
		return false;
		
	}
}

function ValidatePrefOTDateTime(from,to,exp_days_of_stay,varBodyFrame)
{	
	
	var prefDateTime = from;
	var expDaysofStay = exp_days_of_stay;
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

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH step='One' prefDateTime=\""+prefDateTime+"\" expDaysofStay=\""+expDaysofStay+"\" /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)

	a = responseText.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")

	var exp_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	if((Date.parse(from_date) > Date.parse(to_date)) || (Date.parse(to_date) > Date.parse(exp_date)))
	{
		alert(getMessage("INVALID_OT_DATE","IP"));
		eval(varBodyFrame+".ot_date_time").value="";
		eval(varBodyFrame+".ot_date_time").focus();
		eval(varBodyFrame+".ot_date_time").select();
		retval = false;
		return retval
	}
   return retval
}	


/*function doDateTimeChk_local(obj)
{
	if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
	{
		retval= false
		obj.focus()
	}
	else
	{
		var comp=obj
		obj=obj.value
		var dttime = obj.split(" ");
		var dt
		var time
		var retval=true
		if(dttime.length>1)
		{
			dt=dttime[0]
			time=dttime[1]

			if(!checkDt_local(dt) )
			{
				retval= false
				comp.focus()
			}
			else
			{
				if(time==null || time=="")
				{
					retval= false;
					comp.focus()
				}

				else
				{
					if(!chkTime_local(time))
					{
							retval= false
							comp.focus()
					}
				}
			}
		}
		else
		{
			retval= false
			comp.focus()
		}

		if(retval)
		{

		}
	}
	return retval
}*/

/*function checkDt_local(date1)
{
	retval=true
	var date1arr=new Array()

	date1arr=date1.split("/")

	if(date1arr.length==3)
	{
		var date1d=date1arr[0]
		var date1m=date1arr[1]
		var date1y=date1arr[2]

		if (isNaN(date1d)==true) return false;
		if (isNaN(date1m)==true) return false;
		if (isNaN(date1y)==true) return false;

		date1d=eval(date1d)
		date1m=eval(date1m)
		date1yy=eval(date1y);

		if(date1m<=12)
		{

			if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
			{
				retval= false
			}

			if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30))
			{
				retval= false
			}
			if ((date1y.length <4) || (date1y.length >4))
			{
				retval= false
			}
			if (date1m == 2) {
				if (date1d< 1) return false;

				if (LeapYear(date1yy) == true) {
					if (date1d> 29) return false;
				}
				else {
					if (date1d > 28) return false;
				}
			}

			if (isNaN(date1d)==true) retval = false;
			if (isNaN(date1m)==true) retval = false;
			if (isNaN(date1yy)==true) retval = false;
		}
		else
		{
			retval= false;
		}
	}
	else
	{
		retval= false;
	}
	return retval;
}*/

/*function chkTime_local(time1)
{
   var retval=true;
   var strCheck = ':0123456789';
	for(var i=0;i<=time1.length;i++) {
		if (strCheck.indexOf(time1.charAt(i)) == -1){
			retval = false;
			break;
		}
	}
	if (retval)
	{
		if( (time1.charAt(time1.length-1) )!=":")
		{
			var time1arr=new Array()
			time1arr=time1.split(":")

			if(time1arr.length==2)
			{
				var time1hr=time1arr[0]
				var time1min=time1arr[1]

				time1hr=eval(time1hr)
				time1min=eval(time1min)
				if(time1hr<=23)
				{
					if(time1min>59)
					{
						retval=false;
					}
				}
				else
						retval=false;

			}
			else
				retval=false;
		}
		else
				retval=false;

	}
	return retval
}*/



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

async function SpecialtyLookup()
{
	var locale = document.booking_form.locale.value;
	var msg="";
	if(document.forms[0].referral_id.value == "" && document.forms[0].allowed_booking_type.value == "R")
	{
		msg = getMessage('CAN_NOT_BE_BLANK',"Common");
		msg = msg.replace('$',getLabel("Common.referralid.label","common"));
		parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"";

		document.forms[0].Splcode_desc.value ="";
		document.forms[0].Splcode.value ="";
		document.forms[0].referral_id.focus();
	}
	else if(document.forms[0].med_service_grp.value.length > 0)
	{
		ClearBookingDtls();
		var tit				= getLabel("Common.speciality.label","Common");
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;

		sql = " select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW where language_id = '"+locale+"' and eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) ";
		//sql = " select speciality_code code, am_get_desc.AM_SPECIALITY(speciality_code,'"+locale+"',2) description from AM_SPECIALITY where eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) ";
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].Splcode_desc.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		retVal = await CommonLookup( tit, argumentArray );
		
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].Splcode_desc.value=arr[1];
			document.forms[0].Splcode.value=arr[0];
			document.forms[0].Splcode_desc_hid.value = document.forms[0].Splcode_desc.value;
			/*Saturday, June 13, 2009 modified for IN010922*/
			var ot_nursing_unit_short_desc = document.forms[0].ot_nursing_unit_short_desc.value
			if(ot_nursing_unit_short_desc.indexOf("'")!=-1)
			{
				
			ot_nursing_unit_short_desc = ot_nursing_unit_short_desc.replace("'","''");
			}
			if(document.forms[0].call_function.value == "OT")
			{
				document.forms[0].practid_desc.value=document.forms[0].physician_desc.value	
				document.forms[0].practid.value	=document.forms[0].physician_code.value
				document.forms[0].nursing_unit.value	=document.forms[0].ot_nursing_unit_code.value
				document.forms[0].nurs_unit_desc_hid.value	=ot_nursing_unit_short_desc
				document.forms[0].nursing_unit_desc.value	=ot_nursing_unit_short_desc
			}
		}
		else
		{
			document.forms[0].Splcode_desc.value="";
			document.forms[0].Splcode_desc_hid.value = "";
			document.forms[0].Splcode.value="";
		}
	}
	else
	{
		msg = getMessage('CAN_NOT_BE_BLANK',"Common");
		msg = msg.replace('$',getLabel("eIP.MedicalServiceGroup.label","IP"));
		document.forms[0].Splcode_desc.value="";
		document.forms[0].Splcode.value="";
		
		
		if((parent.frames[1].document.booking_form.call_function.value=="CA_Task_IP_Booking" || 				parent.frames[1].document.booking_form.call_function.value=="CA_Clinician_IP_Booking" )&& msg != "")
			parent.frames[2].location.href='../../eIP/jsp/IPError.jsp?home_required_yn=N&err_num='+msg+"";	
		else if(msg != "")
			parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"";

		document.forms[0].med_service_grp.focus();
	}
}

function SpecialtyLookupBlur()
{
	var oldValFlag = false;
	if(document.forms[0].Splcode_desc_hid.value != document.forms[0].Splcode_desc.value)
		oldValFlag = true;

	if(oldValFlag)
	{
		if(document.forms[0].Splcode_desc.value != "")
		{
			SpecialtyLookup();
		}
		else
		{
			document.forms[0].practid.value="";
			document.forms[0].practid_desc.value="";
			document.forms[0].team_id.disabled=true;
			document.forms[0].team_id.value="";
			document.forms[0].nursing_unit_desc.value="";
			document.forms[0].nursing_unit.value="";
			document.forms[0].removePatInstruction.value="Y";
			document.getElementById('NUInstsExist').style.visibility='hidden';//Changes for RUT-CRF-13.1 IN035825 
			NursingUnitLookupBlur();
			if(document.forms[0].confirm_yn.value == 'Y')
			{
			document.forms[0].bed_class_desc.value="";
			document.forms[0].bed_class_code.value="";
			document.forms[0].bed_no.value="";
			document.forms[0].room_no.value="";
			}
			document.forms[0].Splcode_desc.value="";
			document.forms[0].Splcode_desc_hid.value = "";
			document.forms[0].Splcode.value="";
		}
	}
}

function  enableNatId1(callobj)
{
	var varBodyFrame = "";
	if(parent.frames[1])
		varBodyFrame = "parent.frames[1]";
	else
		varBodyFrame = "parent.frames[2].frames[1]";

	if((parent.frames[1].name == "menucontent") && (parent.frames[2].name == "content") && (parent.frames[2].frames[1].name == "f_query_add_mod"))
		varBodyFrame = "f_query_add_mod";

	if(parent.frames[2].frames[1].document.forms[0].birth_place && parent.frames[2].frames[1].document.forms[0].birth_place.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].birth_place.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].ethnic_group && parent.frames[2].frames[1].document.forms[0].ethnic_group.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].ethnic_group.disabled = false;
	}

	if(parent.frames[2].frames[1].document.forms[0].place_of_birth && parent.frames[2].frames[1].document.forms[0].place_of_birth.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].place_of_birth.disabled = false;
	}
	/*
	if(eval(varBodyFrame+".document.getElementById("race_code")") != null)
	{
		eval(varBodyFrame+".document.getElementById("race_code")").disabled = false;
	}
	*/
	if(parent.frames[2].frames[1].document.forms[0].race_desc && parent.frames[2].frames[1].document.forms[0].race_desc.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].race_desc.disabled = false;
		parent.frames[2].frames[1].document.forms[0].race_desc_id.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].patient_name && parent.frames[2].frames[1].document.forms[0].patient_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].patient_name.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].name_prefix1 && parent.frames[2].frames[1].document.forms[0].name_prefix1.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_prefix1.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].name_prefix && parent.frames[2].frames[1].document.forms[0].name_prefix.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_prefix.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].first_name && parent.frames[2].frames[1].document.forms[0].first_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].first_name.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].second_name && parent.frames[2].frames[1].document.forms[0].second_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].second_name.disabled = false
	}
	if(parent.frames[2].frames[1].document.forms[0].third_name && parent.frames[2].frames[1].document.forms[0].third_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].third_name.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].family_name && parent.frames[2].frames[1].document.forms[0].family_name.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].family_name.disabled = false;
	}
	/*Wednesday, January 12, 2011 , IN025850*/
	if(parent.frames[2].frames[1].document.forms[0].name_prefix_oth_lang && parent.frames[2].frames[1].document.forms[0].name_prefix_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_prefix_oth_lang.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].first_name_oth_lang && parent.frames[2].frames[1].document.forms[0].first_name_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].first_name_oth_lang.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].second_name_oth_lang && parent.frames[2].frames[1].document.forms[0].second_name_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].second_name_oth_lang.disabled = false
	}
	if(parent.frames[2].frames[1].document.forms[0].third_name_oth_lang && parent.frames[2].frames[1].document.forms[0].third_name_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].third_name_oth_lang.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].family_name_oth_lang && parent.frames[2].frames[1].document.forms[0].family_name_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].family_name_oth_lang.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].name_suffix_oth_lang && parent.frames[2].frames[1].document.forms[0].name_suffix_oth_lang.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_suffix_oth_lang.disabled = false;
	}
	/**/
	if(parent.frames[2].frames[1].document.forms[0].name_suffix1 && parent.frames[2].frames[1].document.forms[0].name_suffix1.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_suffix1.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].name_suffix && parent.frames[2].frames[1].document.forms[0].name_suffix.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].name_suffix.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].sex && parent.frames[2].frames[1].document.forms[0].sex.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].sex.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].date_of_birth && parent.frames[2].frames[1].document.forms[0].date_of_birth.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].date_of_birth.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].b_age && parent.frames[2].frames[1].document.forms[0].b_age.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].b_age.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].b_months && parent.frames[2].frames[1].document.forms[0].b_months.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].b_months.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].b_days && parent.frames[2].frames[1].document.forms[0].b_days.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].b_days.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].dob && parent.frames[2].frames[1].document.forms[0].dob.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].dob.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].nationality_code1 && parent.frames[2].frames[1].document.forms[0].nationality_code1.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].nationality_code1.disabled = false
	}
	if(parent.frames[2].frames[1].document.forms[0].citizen_yn[0] && parent.frames[2].frames[1].document.forms[0].citizen_yn[0].value != null)
	{
		parent.frames[2].frames[1].document.forms[0].citizen_yn[0].disabled = false;		
	}
	if(parent.frames[2].frames[1].document.forms[0].citizen_yn[1] && parent.frames[2].frames[1].document.forms[0].citizen_yn[1].value != null)
	{
		parent.frames[2].frames[1].document.forms[0].citizen_yn[1].disabled = false;				
	}
	if(parent.frames[2].frames[1].document.forms[0].national_id_no && parent.frames[2].frames[1].document.forms[0].national_id_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].national_id_no.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id1_no && parent.frames[2].frames[1].document.forms[0].alt_id1_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id1_no.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id2_no && parent.frames[2].frames[1].document.forms[0].alt_id2_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id2_no.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id3_no && parent.frames[2].frames[1].document.forms[0].alt_id3_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id3_no.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id4_no && parent.frames[2].frames[1].document.forms[0].alt_id4_no.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id4_no.disabled = false;					
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id1_exp_date && parent.frames[2].frames[1].document.forms[0].alt_id1_exp_date.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id1_exp_date.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id2_exp_date && parent.frames[2].frames[1].document.forms[0].alt_id2_exp_date.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id2_exp_date.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id3_exp_date && parent.frames[2].frames[1].document.forms[0].alt_id3_exp_date.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id3_exp_date.disabled = false;
	}
	if(parent.frames[2].frames[1].document.forms[0].alt_id4_exp_date && parent.frames[2].frames[1].document.forms[0].alt_id4_exp_date.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].alt_id4_exp_date.disabled = false;					
	}

	if(parent.frames[2].frames[1].document.forms[0].other_alt_type && parent.frames[2].frames[1].document.forms[0].other_alt_type.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].other_alt_type.disabled = false;
	}

	if(parent.frames[2].frames[1].document.forms[0].other_alt_Id && parent.frames[2].frames[1].document.forms[0].other_alt_Id.value != null)
	{
		parent.frames[2].frames[1].document.forms[0].other_alt_Id.disabled = false;
	}
  return true;
}


//This function is calling the BookAppointmentValidations jsp  for populating the  referral details
function referralDetails(obj,fromLookup)
{
	if(obj.value != '')
	{
		if(specialChar(obj,'Char')==true)
		{		
			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eIP/jsp/BookAppointmentValidations.jsp?step=Referral'><input type='hidden' name='referral_id' id='referral_id' value='"+obj.value+"'><input type='hidden' name='fromLookup' id='fromLookup' value='"+fromLookup+"'><input type='hidden' name='qryString' id='qryString' value='"+document.forms[0].qryString.value+"'><input type='hidden' name='Unregpatbkgyn' id='Unregpatbkgyn' value='"+document.forms[0].Unregpatbkgyn.value+"'></form></body></html>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			
			
			parent.frames[2].document.forms[0].submit();
		}
		if(document.forms[0].app_pat_class.value != "")
		{
			var patClass = document.forms[0].app_pat_class.value;
			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form2' id='form2' method='post' action='../../eIP/jsp/BookAppointmentValidations.jsp?step1=PatientClass'><input type='hidden' name='patClass' id='patClass' value='"+patClass+"'><input type='hidden' name='p_oper_stn_id' id='p_oper_stn_id' value='"+document.forms[0].p_oper_stn_id.value+"'></form></body></html>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			
			parent.frames[2].document.form2.submit();
		}
	}
	//document.forms[0].pref_adm_date.focus();
}


//This fucntion is used to clear the values
function ClearValues(Objval)
{
	if(Objval == "");
	{
		document.forms[0].patient_id.readOnly = false;
		document.forms[0].Splcode_desc.readOnly = false;
		document.forms[0].alt_id1_no.readOnly = false;
		document.forms[0].date_of_birth.readOnly = false;
		document.forms[0].b_age.readOnly = false;
		document.forms[0].b_months.readOnly = false;
		document.forms[0].b_days.readOnly = false;
		document.forms[0].nationality_code1.disabled = false;
		document.forms[0].sex.disabled = false;
		document.forms[0].Splcode.value = "";
		document.forms[0].patient_id.value = "";
		document.forms[0].Splcode_desc.value = "";
		if(document.forms[0].alt_id1_no)	document.forms[0].alt_id1_no.value = "";
		if(document.forms[0].other_alt_Id)	document.forms[0].other_alt_Id.value = "";
		if(document.forms[0].alt_id1_exp_date)	document.forms[0].alt_id1_exp_date.value = "";
		document.forms[0].patient_name.value = "";
		document.forms[0].date_of_birth.value = "";
		document.forms[0].b_age.value = "";
		document.forms[0].b_months.value = "";
		document.forms[0].b_days.value = "";
		document.forms[0].birth_place.value = "";
		document.forms[0].place_of_birth.value = "";
		document.forms[0].nationality_desc.value = "";
		if(document.forms[0].alt_id2_no)	document.forms[0].alt_id2_no.value = "";
		if(document.forms[0].other_alt_type)document.forms[0].other_alt_type.value = "";
		//if(document.forms[0].name_prefix1)	document.forms[0].name_prefix1.value = "";
		//if(document.forms[0].name_suffix1)	document.forms[0].name_suffix1.value = "";
		if(document.forms[0].name_prefix)	document.forms[0].name_prefix.value = "";
		if(document.forms[0].name_suffix)	document.forms[0].name_suffix.value = "";
	
		document.forms[0].addr_line1.value = "";
		document.forms[0].addr_line2.value = "";
		document.forms[0].addr_line3.value = "";
		document.forms[0].addr_line4.value = "";
		document.forms[0].res_town_code.value = "";
		document.forms[0].res_town_desc.value = "";
		document.forms[0].res_area_code.value = "";
		document.forms[0].res_area_desc.value = "";
		document.forms[0].postal_code.value = "";
		document.forms[0].region_desc.value = "";
		document.forms[0].country_code.value = "";
		document.forms[0].country_desc.value = "";
		document.forms[0].contact1_name.value = "";
		document.forms[0].addr2_type.value = "";
		document.forms[0].invalid1_yn.value = "";
		document.forms[0].mail_addr_line1.value = "";
		document.forms[0].mail_addr_line2.value = "";
		document.forms[0].mail_addr_line3.value = "";
		document.forms[0].mail_addr_line4.value = "";
		document.forms[0].mail_res_town_code.value = "";
		document.forms[0].mail_res_town_desc.value = "";
		document.forms[0].mail_res_area_code.value = "";
		document.forms[0].mail_res_area_desc.value = "";
		document.forms[0].mail_postal_code.value = "";
		document.forms[0].mail_region_desc.value = "";
		document.forms[0].mail_country_code.value = "";
		document.forms[0].mail_country_desc.value = "";
		document.forms[0].contact2_name.value = "";
		document.forms[0].contact1_no.value = "";
		document.forms[0].contact2_no.value = "";
		document.forms[0].email.value = "";
		if(document.forms[0].alt_id2_exp_date)
		document.forms[0].alt_id2_exp_date.value = "";
		document.forms[0].race_code.value = "";
		document.forms[0].race_desc.value = "";
		document.forms[0].nationality_code1.value = "";
		document.forms[0]. national_id_no.value = "";
		document.forms[0].ethnic_group.value = "";
		document.forms[0].sex.value = "";

		if(document.forms[0].name_prefix1 != null)
		{
		   document.forms[0].name_prefix1.disabled = false;
		   document.forms[0].name_prefix1.value = "";
		}

		if(document.forms[0].name_prefix != null)
		{
			document.forms[0].name_prefix.disabled = false;
		   document.forms[0].name_prefix.value = "";
		}

		if(document.forms[0].first_name != null)
		{
		   document.forms[0].first_name.readOnly = false;
		   document.forms[0].first_name.value = "";
		}

		if(document.forms[0].second_name != null)
		{
		   document.forms[0].second_name.readOnly = false;
		   document.forms[0].second_name.value = "";
		}

		if(document.forms[0].third_name != null)
		{
		   document.forms[0].third_name.readOnly = false;
		   document.forms[0].third_name.value = "";
		}

		if(document.forms[0].family_name != null)
		{
		   document.forms[0].family_name.readOnly = false;
		   document.forms[0].family_name.value = "";
		}

		if(document.forms[0].name_suffixz != null)
		{
		   document.forms[0].name_suffixz.disabled = false;
		   document.forms[0].name_suffixz.value = "";
		}
		
		if(document.forms[0].name_suffix != null)
		{
			document.forms[0].name_suffix.disabled = false;
		   document.forms[0].name_suffix.value = "";
		}

		
		if(document.forms[0].name_prefix_oth_lang != null)
		{
			document.forms[0].name_prefix_oth_lang.value = "";
		}


		if(document.forms[0].first_name_oth_lang != null)
		{
			document.forms[0].first_name_oth_lang.value = "";
		}

		if(document.forms[0].second_name_oth_lang != null)
		{
			document.forms[0].second_name_oth_lang.value = "";
		}

		if(document.forms[0].third_name_oth_lang != null)
		{
			document.forms[0].third_name_oth_lang.value = "";
		}

		if(document.forms[0].family_name_oth_lang != null)
		{
				document.forms[0].family_name_oth_lang.value = "";
		}


		if(document.forms[0].name_suffix_oth_lang != null)
		{
			document.forms[0].name_suffix_oth_lang.value = "";
		}


	}
}


// This fucntion is used to chk the ot date time is greater than to systime or not
function ValidateOTSysDateTime(from,to)
{	
	var retval=true
	
	var a=  from.split(" ")
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

	 if(Date.parse(from_date) > Date.parse(to_date))
	 {
		alert(getMessage("LT_CURR_DATE",'IP'));
		document.forms[0].ot_date_time.focus();
		document.forms[0].ot_date_time.select();
		retval =  false;
	 }
	
	 if(retval != false)	
	 {
		var OTdate = to; 
		var admndate = document.forms[0].pref_adm_date.value; 
		ValidateAdmnOTDateTime(admndate,to);
		retval = true;	
	}
	return retval;
}	


// This fucntion is used to validate the ot date time 
function ValidateAdmnOTDateTime(from,to)
{		
	var a=  from.split(" ")
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

	 if(Date.parse(from_date) > Date.parse(to_date))
	 {
		alert(getMessage("INVALID_OT_DATE","IP"));
		document.forms[0].ot_date_time.value="";
		document.forms[0].ot_date_time.focus();
		document.forms[0].ot_date_time.select();
		return false
	}
	else
		return true;		
}	


// This function is used to clear the booking details
function ClearBookingDtls()
{
	
	document.forms[0].practid.value='';
	document.forms[0].practid_desc.value='';
	booking_form.team_id.value="";

	var selected = booking_form.team_id;

	while ( selected.options.length > 0 )
	{
		selected.remove(selected.options[0]);
	}

	var	str1 = "" ;
	var	str2 = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var element = parent.frames[1].document.createElement('OPTION');
	element.text = str2; 
	element.value= str1;
	document.forms[0].team_id.add(element);

}


// This function is used to enabling and disabling the override check box
function enabdisbVal(obj)
{
	if (obj.checked==true)
	{
		obj.value="Y";
		document.forms[0].override_yn.value="Y";
	}
	else
	{
		obj.value="N";
		document.forms[0].override_yn.value="N";
	}
}
//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 22/03/2013
//Start
function IPOrder_Clear()
	{
	eval(varBodyFrame).document.getElementById('surgery_order_id').value="";
	eval(varBodyFrame).document.getElementById('surgery_order_line_no').value="";
	eval(varBodyFrame).document.getElementById('surgery_order').value="";
	eval(varBodyFrame).document.getElementById('surgery_order_code').value="";
	eval(varBodyFrame).document.getElementById('surgery_order_date').value="";
	eval(varBodyFrame).document.getElementById('surgery_order_dt_id').innerHTML="";
	eval(varBodyFrame).document.getElementById('surgery_order_name').disabled=false;
	}
//End	
function gifpop()
{  
	if(document.forms[0].is_ca_yn.value=="Y" || document.forms[0].is_oa_yn.value=="Y")
	{
		if(parent.frames[0].document.getElementById('home'))
			parent.frames[0].document.getElementById('home').disabled=true; 
		if(document.forms[0].is_oa_yn.value=="Y")
		{
		if(parent.frames[0].document.getElementById('reset'))
			parent.frames[0].document.getElementById('reset').disabled=true; 
		}
		if(parent.frames[0].document.getElementById('create'))
			parent.frames[0].document.getElementById('create').disabled=true;
	}
	parent.frames[1].document.forms[0].gifpop.style.visibility="hidden";
}

//This fucntion is used for populating the refferal details        
async function PopRefDetails()
{
	var Unregpatbkgyn = document.forms[0].Unregpatbkgyn.value;
	
	var retVal;
	var dialogHeight= "1000px" ;
	var dialogWidth	= "1500px" ;
	var dialogTop 	= "72" ;
	var center 	= "1" ;														   
	var status	= "no";
	var scroll	= "no";
	var obval   = "";
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
	var arguments	= "" ;
	var p_patient_id_value = document.forms[0].patient_id.value;
	//var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?p_select=YES&p_reg_patient=YES&p_calling_function=IP_BOOKING&calledFrom=Booking";

	var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?p_select=YES&p_reg_patient=YES&p_calling_function=IP_BOOKING&calledFrom=Booking&ca_patient_id="+p_patient_id_value;

	retVal = await window.showModalDialog(url,arguments,features);	
//	parent.commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?'+parent.frames[1].document.forms[0].qryString.value;
	if (retVal != null)
	{
		


		if(Unregpatbkgyn == 'Y')
		{  /*Below line added for this incident [43737]*/
			document.forms[0].referral_id.value=retVal;
			document.forms[0].referral_details.disabled = true;
			document.forms[0].referral_id.disabled = true;
			referralDetails(document.forms[0].referral_id, "Y");
			
		}
		else
		{
			document.forms[0].referral_id.value=retVal;
			//document.forms[0].referral_id.focus();
			document.forms[0].referral_id.onblur(); //above line commented and this line added for the incident[IN043737]
			
			
		}
	}
	else
	{
		document.forms[0].referral_id.value="";		
		//ClearValues(obval);
	}
}    

function setdefault() 
{
	//document.forms[0].confirm_yn.value="Y";
}

function getWaitlist()
{
	
	document.forms[0].patient_id.value	=	document.forms[0].oa_patient_id.value;
	document.forms[0].patient_id.disabled=true;
	document.forms[0].search.disabled=true;
	document.forms[0].patient_name.value	=	document.forms[0].oa_patient_name.value;
	document.forms[0].patient_name.disabled=true;
	//document.forms[0].national_id_no.value	=	document.forms[0].oa_nationality.value;
 	//document.forms[0].Splcode_desc.value	=	document.forms[0].oa_spl_desc.value;
	//document.forms[0].Splcode_desc.readOnly=true;
	//document.forms[0].Splcode.value	=	document.forms[0].oa_spl_code.value;
	//document.forms[0].practid_desc.value	=	document.forms[0].oa_prct_desc.value;
	//document.forms[0].practid_desc.disabled = true;
	//document.forms[0].practid.value	=	document.forms[0].oa_prct_id.value;
	//document.forms[0].date_of_birth.value	=	document.forms[0].oa_date_of_birth.value;
	document.forms[0].pref_adm_date.readOnly	= true;
	document.forms[0].date_of_birth.readOnly	= true;
	document.forms[0].b_age.readOnly			= true;
	document.forms[0].b_months.readOnly			= true;
	document.forms[0].b_days.readOnly			= true;
	document.forms[0].birth_place.value			= document.forms[0].oa_birth_plc.value;
	document.forms[0].birth_place.disabled		= true;
	document.forms[0].b_birth.disabled			= true;
	document.forms[0].sex.value					= document.forms[0].oa_gendar.value;
	document.forms[0].sex.disabled				= true;
	
			
	//document.forms[0].name_prefix1.value		= document.forms[0].oa_name_prfx.value;
	//document.forms[0].name_prefix1.disabled		= true;
	//document.forms[0].name_prefix.value		= document.forms[0].oa_name_prfx.value;
	//document.forms[0].name_prefix.disabled		= true;
	//document.forms[0].name_suffix.disabled		= true;



	//additional fields

	if(document.booking_form.other_alt_type)
	{
		if(document.forms[0].oa_oth_alt_id_type.value!='')
			document.booking_form.other_alt_type.value = document.forms[0].oa_oth_alt_id_type.value;
		document.forms[0].other_alt_type.disabled=true;
	}
	

	if(document.booking_form.national_id_no)
	{
		document.booking_form.national_id_no.value = document.forms[0].oa_nationality.value;
		//if(document.forms[0].oa_nationality.value!='')
			document.forms[0].national_id_no.disabled=true;
	}

	if(document.booking_form.alt_id1_no)
	{
		document.booking_form.alt_id1_no.value = document.forms[0].oa_alt_id1.value;
		//if(document.forms[0].oa_alt_id1.value!='')
			document.forms[0].alt_id1_no.disabled=true;
	}
	if(document.booking_form.alt_id2_no)
	{
		document.booking_form.alt_id2_no.value = document.forms[0].oa_alt_id2.value;
		//if(document.forms[0].oa_alt_id2.value!='')
			document.forms[0].alt_id2_no.disabled=true;
	}
	if(document.booking_form.alt_id3_no)
	{
		document.booking_form.alt_id3_no.value = document.forms[0].oa_alt_id3.value;
		//if(document.forms[0].oa_alt_id3.value!='')
			document.forms[0].alt_id3_no.disabled=true;
	}
	if(document.booking_form.alt_id4_no)
	{
		document.booking_form.alt_id4_no.value = document.forms[0].oa_alt_id4.value;
		//if(document.forms[0].oa_alt_id4.value!='')
			document.forms[0].alt_id4_no.disabled=true;
	}
	if(document.booking_form.alt_id1_exp_date)
	{
		document.booking_form.alt_id1_exp_date.value = document.forms[0].oa_alt_id1_exp_date.value;
		//if(document.forms[0].oa_alt_id1_exp_date.value!='')
			document.forms[0].alt_id1_exp_date.disabled=true;
	}
	if(document.booking_form.alt_id2_exp_date)
	{
		document.booking_form.alt_id2_exp_date.value = document.forms[0].oa_alt_id2_exp_date.value;
		//if(document.forms[0].oa_alt_id2_exp_date.value!='')
			document.forms[0].alt_id2_exp_date.disabled=true;
	}
	if(document.booking_form.alt_id3_exp_date)
	{
		document.booking_form.alt_id3_exp_date.value = document.forms[0].oa_alt_id3_exp_date.value;
		//if(document.forms[0].oa_alt_id3_exp_date.value!='')
			document.forms[0].alt_id3_exp_date.disabled=true;
	}
	if(document.booking_form.alt_id4_exp_date)
	{
		document.booking_form.alt_id4_exp_date.value = document.forms[0].oa_alt_id4_exp_date.value;
		//if(document.forms[0].oa_alt_id4_exp_date.value!='')
			document.forms[0].alt_id4_exp_date.disabled=true;
	}
	if(document.booking_form.other_alt_Id)
	{
		document.booking_form.other_alt_Id.value = document.forms[0].oa_oth_alt_id.value;	
		//if(document.forms[0].oa_oth_alt_id.value!='')
			document.forms[0].other_alt_Id.disabled=true;
	}
	if(document.booking_form.first_name)
	{
		document.booking_form.first_name.value = document.forms[0].oa_first_name.value;
		if(document.forms[0].oa_first_name.value!='')
			document.forms[0].first_name.disabled=true;
	}
	if(document.booking_form.second_name)
	{
		document.booking_form.second_name.value = document.forms[0].oa_second_name.value;
		if(document.forms[0].oa_second_name.value!='')
			document.forms[0].second_name.disabled=true;
	}
	if(document.booking_form.third_name)
	{
		document.booking_form.third_name.value = document.forms[0].oa_third_name.value;
		//if(document.forms[0].oa_third_name.value!='')
		document.forms[0].third_name.disabled=true;
	}
	if(document.booking_form.first_name_oth_lang)	
	{
		document.booking_form.first_name_oth_lang.value = document.forms[0].oa_first_name_loc_lang.value;
		//if(document.forms[0].oa_first_name_loc_lang.value!='')
			document.forms[0].first_name_oth_lang.disabled=true;
	}
	if(document.booking_form.second_name_oth_lang)	
	{
		document.booking_form.second_name_oth_lang.value = document.forms[0].oa_second_name_loc_lang.value;
		//if(document.forms[0].oa_second_name_loc_lang.value!='')
			document.forms[0].second_name_oth_lang.disabled=true;
	}
	if(document.booking_form.third_name_oth_lang)
	{
		document.booking_form.third_name_oth_lang.value = document.forms[0].oa_third_name_loc_lang.value;
		//if(document.forms[0].oa_third_name_loc_lang.value!='')
			document.forms[0].third_name_oth_lang.disabled=true;
	}
	if(document.booking_form.family_name_oth_lang)
	{
		document.booking_form.family_name_oth_lang.value = document.forms[0].oa_family_name_loc_lang.value;
		//if(document.forms[0].oa_family_name_loc_lang.value!='')
			document.forms[0].family_name_oth_lang.disabled=true;
	}
	if(document.booking_form.date_of_birth)
	{
		
		document.booking_form.date_of_birth.value = document.forms[0].oa_date_of_birth.value;
		if(document.forms[0].oa_date_of_birth.value!='')
		{
			document.forms[0].date_of_birth.disabled=true;
			document.forms[0].dob.disabled=true;
		}
	}

	if(document.booking_form.b_age)
	{
		
		document.booking_form.b_age.value = document.forms[0].oa_years.value;
		//if(document.forms[0].oa_years.value!='')
			document.forms[0].b_age.disabled=true;
	}
	if(document.booking_form.b_months)
	{
		
		document.booking_form.b_months.value = document.forms[0].oa_months.value;
		//if(document.forms[0].oa_months.value!='')
			document.forms[0].b_months.disabled=true;
	}
	if(document.booking_form.b_days)
	{
		
		document.booking_form.b_days.value = document.forms[0].oa_days.value;
		//if(document.forms[0].oa_days.value!='')
			document.forms[0].b_days.disabled=true;
	}




	if(document.booking_form.name_prefix)
	{	
		
		if(document.forms[0].oa_name_prfx.value!='')
			document.forms[0].name_prefix.value		= document.forms[0].oa_name_prfx.value;
		document.forms[0].name_prefix.disabled		= true;
	}

	if(document.booking_form.name_suffix)
	{
		
		if(document.forms[0].oa_name_sufx.value!='')
			document.booking_form.name_suffix.value = document.forms[0].oa_name_sufx.value;
		document.forms[0].name_suffix.disabled		= true;
	}


	
	if(document.booking_form.name_prefix_oth_lang)
	{
		if(document.forms[0].oa_name_prefix_loc_lang.value!='')
			document.booking_form.name_prefix_oth_lang.value = document.forms[0].oa_name_prefix_loc_lang.value;
		document.forms[0].name_prefix_oth_lang.disabled=true;
	}
	if(document.booking_form.name_suffix_oth_lang)
	{
		if(document.forms[0].oa_name_suffix_loc_lang.value!='')
			document.booking_form.name_suffix_oth_lang.value = document.forms[0].oa_name_suffix_loc_lang.value;
		document.forms[0].name_suffix_oth_lang.disabled=true;
	}	
	if(document.forms[0].family_name)
	{
		document.forms[0].family_name.value			=	document.forms[0].oa_family_name.value;
		document.forms[0].family_name.disabled		= true;
	}

	if(document.forms[0].nationality_desc)
	{
		if(document.forms[0].oa_race_code.value!='')
		{
			document.forms[0].nationality_desc.disabled		= true;
			document.forms[0].nationality_id.disabled		= true;
			document.forms[0].citizen_yn[0].disabled		= true;
			document.forms[0].citizen_yn[1].disabled		= true;

		}
	}

	if(document.forms[0].ethnic_group)
	{
		document.forms[0].ethnic_group.value			=	document.forms[0].oa_ethic_desc.value;
		if(document.forms[0].oa_ethic_code.value!='')
		{
			document.forms[0].ethnic_group.disabled		= true;			
		}
	}

	

	if(document.getElementById('patient_name1'))
	{
		document.getElementById('patient_name1').innerHTML = "<b>"+document.forms[0].oa_patient_name.value;	
	}

	

	if(document.getElementById('patient_name_local_lang1'))
	{
		document.getElementById('patient_name_local_lang1').innerHTML = "<b>"+document.forms[0].oa_patient_name_loc_lang.value;		
	}

	document.booking_form.addr_line1.value= document.forms[0].oa_addr_line1.value;
	document.booking_form.addr_line2.value= document.forms[0].oa_addr_line2.value;
	document.booking_form.addr_line3.value= document.forms[0].oa_addr_line3.value;
	document.booking_form.addr_line4.value= document.forms[0].oa_addr_line4.value;
	document.booking_form.res_town_code.value= document.forms[0].oa_res_town_code.value;
	document.booking_form.res_area_code.value= document.forms[0].oa_res_area_code.value;
	document.booking_form.postal_code.value= document.forms[0].oa_res_postal_code.value;
	document.booking_form.region_code.value= document.forms[0].oa_res_reg_code.value;
	document.booking_form.country_code.value= document.forms[0].oa_res_country_code.value;
	document.booking_form.mail_addr_line1.value= document.forms[0].oa_mail_addr_line1.value;
	document.booking_form.mail_addr_line2.value= document.forms[0].oa_mail_addr_line2.value;
	document.booking_form.mail_addr_line3.value= document.forms[0].oa_mail_addr_line3.value;
	document.booking_form.mail_addr_line4.value= document.forms[0].oa_mail_addr_line4.value;
	document.booking_form.mail_res_town_code.value= document.forms[0].oa_mail_res_town_code.value;
	document.booking_form.mail_res_area_code.value= document.forms[0].oa_mail_res_area_code.value;
	document.booking_form.mail_postal_code.value= document.forms[0].oa_mail_res_postal_code.value;
	document.booking_form.mail_region_code.value=  document.forms[0].oa_mail_res_reg_code.value;
	document.booking_form.mail_country_code.value=  document.forms[0].oa_mail_res_country_code.value;
	document.booking_form.contact1_no.value=  document.forms[0].oa_res_tel_no.value;
	document.booking_form.contact2_no.value=  document.forms[0].oa_oth_contact_no.value;
	document.booking_form.email.value= document.forms[0].oa_email_id.value;
	document.booking_form.res_town_desc.value =document.forms[0].oa_res_town_desc.value;
    document.booking_form.res_area_desc.value =document.forms[0].oa_res_area_desc.value;
    document.booking_form.region_desc.value =document.forms[0].oa_res_reg_desc.value;
    document.booking_form.mail_res_town_desc.value =document.forms[0].oa_mail_res_town_desc.value;
    document.booking_form.mail_res_area_desc.value =document.forms[0].oa_mail_res_area_desc.value;
    document.booking_form.mail_region_desc.value =document.forms[0].oa_mail_res_reg_desc.value;
	document.booking_form.country_desc.value= document.forms[0].oa_res_country_name.value;
	document.booking_form.mail_country_desc.value= document.forms[0].oa_mail_res_country_name.value;
	document.booking_form.r_postal_code_desc.value= document.forms[0].oa_res_postal_desc.value;
	document.booking_form.m_postal_code_desc.value= document.forms[0].oa_mail_postal_desc.value;

	
//Booking Fields
	if(document.forms[0].Splcode_desc)
	{
		document.forms[0].Splcode_desc.value			=	document.forms[0].oa_spl_desc.value;
		document.forms[0].Splcode.value			=	document.forms[0].oa_spl_code.value;
		if(document.forms[0].oa_spl_desc.value!='')
		{
			document.forms[0].Splcode_desc.disabled		= true;		
			document.forms[0].Splcode_lookup.disabled		= true;	
			
		}
	}

	if(document.forms[0].practid_desc)
	{
		
		document.forms[0].practid_desc.value	=	document.forms[0].oa_prct_desc.value;
		document.forms[0].practid.value			=	document.forms[0].oa_prct_id.value;
		if(document.forms[0].oa_prct_desc.value!='')
		{
			document.forms[0].practid_desc.disabled		= true;
			document.forms[0].pract_id_search.disabled		= true;			
		}
	}

	

	
	
 
	/*if(document.forms[0].nursing_unit_desc)
	{
		document.forms[0].nursing_unit_desc.value			=	document.forms[0].oa_ethic_desc.value;
		if(document.forms[0].oa_ethic_code.value!='')
		{
			document.forms[0].nursing_unit_desc.disabled		= true;		
			document.forms[0].nursing_unit_lookup.disabled		= true;		
		}
	}*/

	opt = document.createElement("OPTION");

	var n = document.forms[0].ethnic_group.options.length;
	for(var i=0;i<n;i++)
		document.forms[0].ethnic_group.remove("ethnic_group");	
	opt.text  =  document.forms[0].oa_ethic_desc.value;
	opt.value =  document.forms[0].oa_ethic_code.value;
	document.getElementById('ethnic_group').add(opt);
	document.getElementById('ethnic_group').options[0].selected	= true;
	document.getElementById('ethnic_group').disabled				= true;

	/*
	document.forms[0].race_code.value = document.forms[0].oa_race_code.value; 	
	var obj  = document.forms[0].race_code;
	var opt  = document.createElement('Option');
	opt.text = document.forms[0].oa_race_desc.value; 
	opt.value=document.forms[0].oa_race_code.value; 
	obj.add(opt);
	opt.selected = true; 
	document.forms[0].race_code.disabled    = true;
	*/

    document.forms[0].race_code.value = document.forms[0].oa_race_code.value; 	
    document.forms[0].race_desc.value = document.forms[0].oa_race_desc.value; 	

	if(document.forms[0].race_desc) {
		document.forms[0].race_desc.disabled    = true;
		document.forms[0].race_desc_id.disabled    = true;
	}

	document.forms[0].ethnic_group.disabled = true;

	document.forms[0].ot_date_time.focus();

}

function calcDate(obj)
{
	
	document.forms[0].exp_discharge_date.value = '';
	//document.forms[0].ot_date_time.value = '';

	if(document.forms[0].ot_date_time.value!='' && document.forms[0].pref_adm_date.value!='')
	{
		//var no_of_days = daysBetween(document.forms[0].pref_adm_date.value,document.forms[0].ot_date_time.value,'DMYHM',localeName);
		//document.forms[0].pre_op_days.value = no_of_days;
		if(document.forms[0].ot_date_time.disabled == false)
			document.forms[0].ot_date_time.value  = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');

	}

	
	if(document.forms[0].exp_days_of_stay.value != '' && document.forms[0].pref_adm_date.value != '')
	{
		var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
		document.forms[0].exp_discharge_date.value	= expdischargeDate;
		//var proc_surg_date_time = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
		//document.forms[0].ot_date_time.value	= proc_surg_date_time;
			
		doOTDateTimeChk2(document.forms[0].ot_date_time,obj.name);
	}
}

function calcDateForExpDisc(obj)
{
	
	document.forms[0].exp_discharge_date.value = '';
	
	if(document.forms[0].exp_days_of_stay.value != '' && document.forms[0].pref_adm_date.value != '')
	{
		var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
		document.forms[0].exp_discharge_date.value	= expdischargeDate;
		//var proc_surg_date_time = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
		//document.forms[0].ot_date_time.value	= proc_surg_date_time;
			
		doOTDateTimeChk2(document.forms[0].ot_date_time, obj.name);
	}
}

function tab_click(obj_name)
{
	if(obj_name == 'booking_tab' )
	{
		if(document.getElementById('tab1') != null){
				//document.getElementById("tab1").scrollIntoView();
				document.getElementById('tab1').scrollIntoView({
				  behavior: "smooth",
				  block: "nearest",
				  inline: "start"
				});
		}

/*
		if(document.forms[0].pref_adm_date.disabled == true)
			document.forms[0].med_service_grp.focus();
		else
			document.forms[0].pref_adm_date.focus();
*/
	}
	else if(obj_name == 'findtl_tab' )
	{
		//document.getElementById("tab1").scrollIntoView();

		document.getElementById('tab1').scrollIntoView({
				  behavior: "smooth",
				  block: "nearest",
				  inline: "start"
				});

		if(document.forms[0].pref_adm_date.value == "")
		{
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common");
			msg	=	msg.replace("{1}",getLabel("eIP.PrefAdmDateTime.label","IP"));
			alert(msg);
		}
		else
		{
			/*if(document.forms[0].patient_id.value=='')
			{
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common");
			msg	=	msg.replace("{1}",getLabel("Common.patientId.label","Common"));
			alert(msg);
			document.forms[0].patient_id.focus();
			return false;
			}*/

			//if(document.forms[0].billing_group.value=='')
			//{
			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='bl_form' id='bl_form' method='post' action='../../eIP/jsp/BookingValidation.jsp'>"+" <input type='hidden' name='patient_id' id='patient_id' value='"+document.forms[0].patient_id.value+"'><input type='hidden' name='blng_grp' id='blng_grp' value='"+document.forms[0].billing_group.value+"'><input type='hidden' name='is_tab_click' id='is_tab_click' value='Y'></form></body></html>";
			//var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='bl_form' id='bl_form' method='post' action='../../eBL/jsp/BLFinDetHiddenFlds.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+document.forms[0].patient_id.value+"'><input type='hidden' name='calling_module' id='calling_module' value='IP'><input type='hidden' name='calling_function_id' id='calling_function_id' value='BOOKING'><input type='hidden' name='episode_type' id='episode_type' value='I'></form></body></html>";
			parent.frames[2].document.write(HTMLVal);
			parent.frames[2].document.bl_form.submit();
			//}
			/*else
			{
			grabFinancialDetails();
			}*/
		}
	}
}


async function grabFinancialDetails()
{
	document.forms[0].bl_success.value = "N";//
	var show_hide_blng_class = "HIDE";//
	var patient_id     = document.forms[0].patient_id.value;//
	var package_flag	= document.forms[0].package_flag.value;//
	//var ins_auth_flag	= "Y";
	var upd_pat_flag	= "Y"; //
	var billing_group			= document.forms[0].billing_group;//
	//var billing_group			= parent.frames[2].document.forms[0].billing_group;//
	var bl_future_admn_YN		= document.forms[0].bl_future_admn_YN.value;//
	//var bl_future_admn_YN		= parent.frames[2].document.forms[0].bl_future_admn_YN.value;//
  	var billing_mode			= document.forms[0].billing_mode;//
	var operation				= document.forms[0].bl_operation.value;//
	//var operation				= parent.frames[2].document.forms[0].bl_operation.value;//
	var pkg_bill_type			= document.forms[0].pkg_bill_type;//
	var pkg_bill_no				= document.forms[0].pkg_bill_no;//

	var practitioner_type_ind = "";
	var att_practid				= ""; 
	att_practid				= document.forms[0].att_practid.value; // need to check
	if(att_practid != '') practitioner_type_ind = "P"; //
	var health_card_expired_yn	= document.forms[0].health_card_expired_yn; //
	var Chg_to_Visitor_Grp		= document.forms[0].Chg_to_Visitor_Grp;	//	
	//if(parent.frames[0].document.Select_form.bkg_type.value=='D')
		//parent.frames[2].document.AdmitPatient_form.patient_class_id.value	='DC'
	var calling_module_id		= document.forms[0].patient_class_id.value;//
	var calling_function_id		= "BOOKING";// 
	var nursingUnitCode = document.forms[0].nursing_unit.value;
	//var admissionType	= document.forms[0].visit_adm_type.value;
	var admissionType	= "";//need to check
	if(document.forms[0].confirm_yn.value == "Y")
	{
		var bedClass		= document.forms[0].bed_class_code.value;//
	}
	
	var financial_detail_ref_id = "";//
	if(document.forms[0].isBlInstalled.value=="Y")
	{
		if(document.forms[0].referral_id.value != "")
			document.forms[0].financial_detail_ref_id.value = document.forms[0].referral_id.value ;
		financial_detail_ref_id = document.forms[0].financial_detail_ref_id.value;
	}//


	
	var episode="";//
	var record="";//

	var bl_interfaced_yn =  document.forms[0].bl_interface_yn.value;
	if ( (bl_interfaced_yn == null) || (bl_interfaced_yn == '') )
	{
		bl_interfaced_yn = 'N';
	}

	var patientclass = document.forms[0].patient_class_id.value;//

		var greg_pref_adm_date = "";
		if(document.forms[0].pref_adm_date.value!='')
			greg_pref_adm_date = convertDate(document.forms[0].pref_adm_date.value,"DMYHM",localeName,"en");

		var qryStr="patientclass="+patientclass+"&operation="+operation+"&package_flag="+package_flag+"&upd_pat_flag="+upd_pat_flag+"&show_hide_blng_class="+show_hide_blng_class+"&patient_id="+patient_id+"&billing_mode="+billing_mode.value+"&billing_group="+billing_group.value;
	
		qryStr += "&pkg_bill_type="+pkg_bill_type.value+"&pkg_bill_no="+pkg_bill_no.value;
		qryStr += "&episode="+episode+"&record="+record;
		qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
		qryStr += "&health_card_expired_yn="+health_card_expired_yn.value+"&Chg_to_Visitor_Grp="+Chg_to_Visitor_Grp.value;
		qryStr += "&bl_interfaced_yn="+bl_interfaced_yn;	
		qryStr += "&bl_future_admn_YN="+bl_future_admn_YN;
		qryStr += "&nursing_unit_code="+nursingUnitCode+"&bed_class_code="+bedClass+"&visit_adm_type="+admissionType;
		qryStr += "&financial_detail_ref_id="+financial_detail_ref_id+"&org_type_ind="+document.forms[0].org_type_ind.value;
		qryStr += "&practitioner_id="+att_practid+"&practitioner_type_ind="+practitioner_type_ind;
		qryStr += "&encounter_date_time="+greg_pref_adm_date;

		var returnArray = new Array();

	
		returnArray = await getFinDtl(qryStr);

		if(returnArray.length>0)
		{
			document.forms[0].billing_group.value     = returnArray[0];
			document.forms[0].billing_mode.value      = "Modify"
			document.forms[0].bl_success.value = "Y";
			document.forms[0].bl_operation.value	= "Update";
			tab_click('booking_tab');
			//document.forms[0].ot_date_time.focus();
			document.forms[0].priority_ind.focus();
			
		}
		else 
		{
			//document.forms[0].billing_mode.value		= "Add";
			//document.forms[0].bl_operation.value		= "Insert";
			tab_click('booking_tab');
			return false;
		}
}

async function getFinDtl(qryStr)
{
	
	var retVal;
	var dialogHeight= "90vh" ;// changed for package billing
	var dialogWidth = "80vw" ;
	var dialogTop = "87" ;
	var center = "1" ;                                                         
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	//var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; dialogTop :" + dialogTop;

	var arguments   = "" ;
	var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
	retVal = await window.showModalDialog(url,arguments,features);
	if(retVal==null) retVal="";
	return retVal;
}


function calcPrefDateForPreparationDay()
{
	document.forms[0].pref_adm_date.value='';
	if(document.forms[0].pre_op_days.value!='' && document.forms[0].ot_date_time.value!='')
	{
		var prefAdmissionDate = minusDate(document.forms[0].ot_date_time.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
		document.forms[0].pref_adm_date.value	= prefAdmissionDate;
		if(document.forms[0].call_function.value!= "OT")
			document.forms[0].pref_adm_date.onblur();		
	}
}

function calcPrefDateForPreparationDay1()
{
	
	/*if(document.forms[0].ot_date_time.value!='')
		document.forms[0].pref_adm_date.value='';
*/

	if(document.forms[0].pre_op_days.value!='' && document.forms[0].ot_date_time.value!='')
	{
		var prefAdmissionDate = minusDate(document.forms[0].ot_date_time.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
		document.forms[0].pref_adm_date.value	= prefAdmissionDate;
		//calcDate(this);

		dateCal(document.forms[0].pref_adm_date);
		
		document.forms[0].exp_discharge_date.value = '';
		if(document.forms[0].exp_days_of_stay.value != '' && document.forms[0].pref_adm_date.value != '')
		{
			var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
			document.forms[0].exp_discharge_date.value	= expdischargeDate;
			//doOTDateTimeChk2(document.forms[0].ot_date_time);

			var greg_obj = convertDate(document.forms[0].ot_date_time.value,"DMYHM",localeName,"en"); 
			var prefdateobj = document.forms[0].pref_adm_date.value; 
			prefdateobj = convertDate(prefdateobj,"DMYHM",localeName,"en");
			var greg_expect_discharge_date = convertDate(document.forms[0].exp_discharge_date.value,"DMYHM",localeName,"en"); 
			var currdate = document.forms[0].sdate2.value; 
			
			var lang_currdate = convertDate(document.forms[0].sdate2.value,"DMYHM","en",localeName); 
			 
				//if(isBefore(greg_obj, prefdateobj, "DMYHM", 'en'))
				if(!isAfter(greg_obj,prefdateobj,'DMYHM','en'))
				{		
						var err = getMessage("DATE1_LT_DATE2","IP");
						err = err.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
						err = err.replace('#',getLabel("eIP.PrefAdmDateTime.label","IP"));
						alert(err);	
						//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
						//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
						//document.forms[0].pref_adm_date.value	= lang_currdate; 
						//document.forms[0].ot_date_time.value	= lang_currdate; 
						if(document.forms[0].call_function.value != "OT"){
							document.forms[0].pref_adm_date.value	= ""; 
							document.forms[0].ot_date_time.value	= ""; 
							document.forms[0].pre_op_days.value		= "0"; 
							//var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
							//document.forms[0].exp_discharge_date.value	= expdischargeDate;
							document.forms[0].exp_days_of_stay.value	= "1";
							document.forms[0].exp_discharge_date.value	= "";
							//document.forms[0].pre_op_days.focus();
							document.forms[0].ot_date_time.focus();
						}else
						{
							document.forms[0].pref_adm_date.value	= ""; 
							document.forms[0].pre_op_days.value		= "0"; 
							document.forms[0].exp_days_of_stay.value	= "1";
							document.forms[0].exp_discharge_date.value	= "";
						}
						return false;
				}
				else if(!isAfter( greg_expect_discharge_date,greg_obj, "DMYHM", 'en'))
				{
						var err = getMessage("DATE1_GT_DATE2","IP");
						err = err.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
						err = err.replace('#',getLabel("eIP.ExpectedDischargeDateTime.label","IP"));
						alert(err);	
						//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
						//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
						//document.forms[0].pref_adm_date.value	= lang_currdate; 
						//document.forms[0].ot_date_time.value	= lang_currdate; 
						if(document.forms[0].call_function.value != "OT"){
						document.forms[0].pref_adm_date.value	= ""; 
						document.forms[0].ot_date_time.value	= ""; 
						document.forms[0].pre_op_days.value		= "0"; 
						//var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
						//document.forms[0].exp_discharge_date.value	= expdischargeDate;
						document.forms[0].exp_days_of_stay.value	=	"1";
						document.forms[0].exp_discharge_date.value	=	"";
						//document.forms[0].pre_op_days.focus();
						document.forms[0].ot_date_time.focus();
						}else
						{
							document.forms[0].pref_adm_date.value	= ""; 
							document.forms[0].pre_op_days.value		= "0"; 
							document.forms[0].exp_days_of_stay.value	= "1";
							document.forms[0].exp_discharge_date.value	= "";
						
						}
						return false;
				}	
				//else if(isBefore(prefdateobj, currdate, "DMYHM", 'en'))
				else if(!isAfter(prefdateobj,currdate,'DMYHM','en'))
				{
					
					alert(getMessage("PREF_ADMDATE_NOT_LESS_SYSDATE","IP"));
					//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
					//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
					//document.forms[0].pref_adm_date.value	= lang_currdate; 
					//document.forms[0].ot_date_time.value	= lang_currdate; 
					if(document.forms[0].call_function.value != "OT"){
						document.forms[0].pref_adm_date.value	= ""; 
						document.forms[0].ot_date_time.value	= ""; 
						document.forms[0].pre_op_days.value		= "0"; 
						//var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
						//document.forms[0].exp_discharge_date.value	= expdischargeDate;
						document.forms[0].exp_days_of_stay.value	= "1";
						document.forms[0].exp_discharge_date.value	= "";
						//document.forms[0].pre_op_days.focus();
						document.forms[0].ot_date_time.focus();
					}else
					{
						document.forms[0].pref_adm_date.value	= ""; 
						document.forms[0].pre_op_days.value		= "0"; 
						document.forms[0].exp_days_of_stay.value	= "1";
						document.forms[0].exp_discharge_date.value	= "";
					
					}
					return false;
				}
				else if(!isBefore(prefdateobj, currdate, "DMYHM", 'en'))
				{
					setTimeout('ChangeVal(document.forms[0].pref_adm_date)',20);					
					//document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
					//document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
					//document.forms[0].pre_op_days.value		= "0"; 
					//var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
					//document.forms[0].exp_discharge_date.value	= expdischargeDate;
					//document.forms[0].pre_op_days.focus();

					/*if(document.forms[0].pref_adm_date.value=="")
					{
						alert('local code');
						document.forms[0].pref_adm_date.value	= document.forms[0].sdate2.value; 
						document.forms[0].ot_date_time.value	= document.forms[0].sdate2.value; 
						document.forms[0].pre_op_days.value		= "0"; 
						var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
						document.forms[0].exp_discharge_date.value	= expdischargeDate;
						document.forms[0].pre_op_days.focus();	
					}*/
					return false;
				}
				else
					return true;

		}
	}
	else if(document.forms[0].pre_op_days.value!='' && document.forms[0].pref_adm_date.value!='' && document.forms[0].ot_date_time.value=='')
	{
		var proc_surg_date_time = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].pre_op_days.value,'d');
		document.forms[0].ot_date_time.value	= proc_surg_date_time;
		    var greg_obj = convertDate(document.forms[0].ot_date_time.value,"DMYHM",localeName,"en"); 
			var prefdateobj = document.forms[0].pref_adm_date.value; 
			prefdateobj = convertDate(prefdateobj,"DMYHM",localeName,"en");
			var greg_expect_discharge_date = convertDate(document.forms[0].exp_discharge_date.value,"DMYHM",localeName,"en"); 
			var currdate = document.forms[0].sdate2.value; 			
			var lang_currdate = convertDate(document.forms[0].sdate2.value,"DMYHM","en",localeName); 


			if(!isAfter(greg_obj,prefdateobj,'DMYHM','en'))
				{		
						var err = getMessage("DATE1_LT_DATE2","IP");
						err = err.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
						err = err.replace('#',getLabel("eIP.PrefAdmDateTime.label","IP"));
						alert(err);	
						document.forms[0].pref_adm_date.value	= ""; 
						document.forms[0].ot_date_time.value	= ""; 
						document.forms[0].pre_op_days.value		= "0"; 
						document.forms[0].exp_days_of_stay.value	= "1";
						document.forms[0].exp_discharge_date.value	= "";
						document.forms[0].ot_date_time.focus();
						return false;
				}
				else if(!isAfter( greg_expect_discharge_date,greg_obj, "DMYHM", 'en'))
				{
						var err = getMessage("DATE1_GT_DATE2","IP");
						err = err.replace('$',getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
						err = err.replace('#',getLabel("eIP.ExpectedDischargeDateTime.label","IP"));
						alert(err);	
						document.forms[0].pref_adm_date.value	= ""; 
						document.forms[0].ot_date_time.value	= ""; 
						document.forms[0].pre_op_days.value		= "0"; 
						document.forms[0].exp_days_of_stay.value	=	"1";
						document.forms[0].exp_discharge_date.value	=	"";
						document.forms[0].ot_date_time.focus();
						return false;
				}				
				else if(!isAfter(prefdateobj,currdate,'DMYHM','en'))
				{
					
					alert(getMessage("PREF_ADMDATE_NOT_LESS_SYSDATE","IP"));
					document.forms[0].pref_adm_date.value	= ""; 
					document.forms[0].ot_date_time.value	= ""; 
					document.forms[0].pre_op_days.value		= "0"; 
					document.forms[0].exp_days_of_stay.value	= "1";
					document.forms[0].exp_discharge_date.value	= "";
					document.forms[0].ot_date_time.focus();
					return false;
				}
				else if(!isBefore(prefdateobj, currdate, "DMYHM", 'en'))
				{					
					setTimeout('ChangeVal(document.forms[0].pref_adm_date)',20);	
					document.forms[0].ot_date_time.value	='';  //for clearing the value of Procedure/Surgery Date/Time  IN018658 Thursday, January 28, 2010
					return false;
				}
				else
					return true;

	}
	else
	{
		
		var msg = getMessage('GENERAL_CNT_BE_BLANK','IP');
		msg = msg.replace('$',getLabel('eIP.ProcedureSurgeryDateTime.label','IP'));
		alert(msg);
		document.forms[0].pre_op_days.value		= "0"; 
		document.forms[0].exp_days_of_stay.value		= "1"; 
		document.forms[0].exp_discharge_date.value		= ""; 
		if(document.forms[0].pref_adm_date.value!="")
		{
			var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
			document.forms[0].exp_discharge_date.value	= expdischargeDate;
		}

		document.forms[0].ot_date_time.focus();
		return true;
	}
}

function setDateValuesForOTFUnc()
{
		var lang_currdate = convertDate(document.forms[0].sdate2.value,"DMYHM","en",localeName); 
		document.forms[0].pref_adm_date.value	= lang_currdate; 
		document.forms[0].ot_date_time.value	= lang_currdate; 
		document.forms[0].pre_op_days.value		= "0"; 
		var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
		document.forms[0].exp_discharge_date.value	= expdischargeDate;
		document.forms[0].pre_op_days.focus();	
}

function displayDefaultValue(obj)
{
	if((obj.value==null || obj.value=="") && obj.name=="pre_op_days")
		obj.value='0';
	else if((obj.value==null || obj.value=="") && obj.name=="exp_days_of_stay")
		obj.value='1';

	if(obj.name=="pre_op_days" && document.forms[0].pre_op_days.value!='0')
	{
		document.forms[0].exp_days_of_stay.value = document.forms[0].pre_op_days.value;

		if(document.forms[0].pref_adm_date.value!='')
		{
			var expdischargeDate = plusDate(document.forms[0].pref_adm_date.value,'DMYHM',localeName,document.forms[0].exp_days_of_stay.value,'d');
			document.forms[0].exp_discharge_date.value	= expdischargeDate;
		}
	}

}


function checkFieldsForPendingBooking( fields, names, messageFrame) 
{
	
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		else
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
	}
	if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eIP/jsp/IPError.jsp?home_required_yn=N&err_num="+errors ;
		return false ;
	}
	return true ;

}

function checkFieldsForOT( fields, names, messageFrame) 
{
	
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		else
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
	}
	if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eIP/jsp/IPError.jsp?call_func=OT&home_required_yn=N&access=NYNNN&err_num="+errors ;
		return false ;
	}
	return true ;
}

function setExpecDischDate(obj)
{
	if(validDateObj(obj,"DMYHM",localeName))
		{
			retval = true;
		}
}
//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
//Start
function GetSurgeryOrder_blank(pat_id,booking_ref_no)
{
	if((document.forms[0].surgery_order.value=="")&&(document.forms[0].surgery_order_date.value!=""))
	{
		//document.forms[0].surgery_order.readOnly=true;
		document.getElementById('surgery_order_dt_id').innerHTML="";
		document.forms[0].surgery_order_date.value="";
		document.forms[0].surgery_order.value="";
		document.forms[0].surgery_order_desc_hid.value="";//Maheshwaran K added for the Inci No : RUT-SCF-0258 [IN:039356]
		document.forms[0].surgery_order_code.value="";
		document.forms[0].surgery_order_line_no.value="";
		document.forms[0].surgery_order_id.value="";
	}
}
async function GetSurgeryOrder(pat_id,booking_ref_no)
{
	if((document.forms[0].surgery_order.value!=document.forms[0].surgery_order_desc_hid.value)
			||(document.forms[0].surgery_order.value==""))//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
	{
		if(pat_id=='')
		{
			alert(getMessage("PATID_NOTNULL","MP"));
			document.forms[0].patient_id.focus();
			document.forms[0].surgery_order.value = "";
		}
	//Maheshwaran K added for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
	//Start	
		else if((document.forms[0].surgery_order.value=="")&&(document.forms[0].surgery_order_date.value!=""))
		{
			//document.forms[0].surgery_order.readOnly=true;
			document.getElementById('surgery_order_dt_id').innerHTML="";
			document.forms[0].surgery_order_date.value="";
			document.forms[0].surgery_order.value="";
			document.forms[0].surgery_order_code.value="";
			document.forms[0].surgery_order_line_no.value="";
			document.forms[0].surgery_order_id.value="";
			document.forms[0].surgery_order_desc_hid.value="";//Maheshwaran K added for the Inci No : RUT-SCF-0258 [IN:039356]
		}
	//End	
		else
		{
			var retVal;
			var dialogHeight= "50vh" ;
			var dialogWidth	= "65vw" ;
			var dialogTop 	= "0vh" ;
			var center 	= "1" ;														   
			var status	= "no";
			var scroll	= "no";
			var obval   = "";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
			var arguments	= "" ;
			var url = "../../eIP/jsp/SurgeryOrderLookUpframe.jsp?patient_id="+pat_id+"&booking_ref_no="+booking_ref_no;
			retVal = await window.showModalDialog(url,arguments,features);	
			if((retVal=='')||(retVal==null))
			{}
			else{
				var details=retVal.split("$");
				document.getElementById('surgery_order_dt_id').innerHTML=details[4];
				document.forms[0].surgery_order_date.value=details[4];
				document.forms[0].surgery_order.value=details[3];
				document.forms[0].surgery_order_desc_hid.value=details[3];//Maheshwaran K added for the Inci No : RUT-SCF-0258 [IN:039356]
				document.forms[0].surgery_order_code.value=details[2];
				document.forms[0].surgery_order_line_no.value=details[1];
				document.forms[0].surgery_order_id.value=details[0];
				//document.forms[0].surgery_order.readOnly=false;//Maheshwaran K added for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
			}
		}
	}
}
//End	

