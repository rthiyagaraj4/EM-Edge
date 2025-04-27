function submitPage()
{
	var condition=""
	for(var i=0; i<document.forms[0].elements.length; i++)
		condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
	document.forms[0].search.disabled=true;
	oper_stn = document.forms[0].oper_stn_id.value;
	routine_tfr_yn = document.forms[0].routine_tfr_yn.value;
	call_function =document.forms[0].call_function.value;

	if(call_function == "ManageCurrIP" )
	{
		if(document.forms[0].include_yn)
		{
			if(document.forms[0].include_yn.checked == true && document.forms[0].no_of_days.value == "")
			{
				var error = getMessage('GENERAL_CNT_BE_BLANK','IP');
				error = error.replace('$',getLabel("Common.noofdays.label","Common"));  
				alert(error);					
				document.forms[0].no_of_days.focus();
				document.forms[0].search.disabled = false;
				return false;
			}
		}
	}
	if(document.forms[0].modal.value == 'yes')
	{
		{
			parent.frames[1].location.href= '../../eIP/jsp/ManageCurrentInPatientsQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&call_function='+call_function+'&show_bed_yn=Y&opst='+oper_stn+'';
		}
	}
	else
	{
			parent.frames[2].location.href= '../../eIP/jsp/ManageCurrentInPatientsQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&show_bed_yn=Y&opst='+oper_stn+'';

			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		}
	}
 
function BeforeGetPractID1(obj1,obj2)
{
	if(document.forms[0].cancel_pract.value!="")
		getPractitioner(obj1,obj2,'','Q7');	
}



async function getNursingUnitValue(aNursingUnit, getFacilitID, details)
{	
	var msg					= "";
	var nursingUnitCode		= aNursingUnit.value;
	var facility_id			= getFacilitID;
	var loginUser			= document.forms[0].loginUser.value;
	var operstn				= document.forms[0].oper_stn_id.value;
	var retVal				= new String();
	var sql					= "";
	var tit					= "";
	var wherecondn			= document.forms[0].wherecondn.value;
	var retVal				= new String();
	var call_function		= document.forms[0].call_function.value;
	var tit					= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight		= "28" ;
	var dialogWidth			= "43" ;
	var status				= "no";
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var retVal =    new String();

	var jsp_name = "";
	{
		if(details == 'from')
		{
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&open_location_yn=N";
		}
		else
		{
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode);
		}

	}


	var retVal =  await window.showModalDialog(jsp_name,arguments,features);
	var arr=new Array();
	
	if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");

		if(details == "from")
		{
			document.forms[0].from_nursing_unit.value=arr[0];
			document.forms[0].from_nursing_unit_desc.value=arr[1];
		}
		else
		{
			document.forms[0].nursing_unit.value=arr[0];
			document.forms[0].nursing_unit_desc.value=arr[1];
		}
	}
	else
	{
		if(details == "from")
		{
			document.forms[0].from_nursing_unit.value		="";
			document.forms[0].from_nursing_unit_desc.value	="";
		}
		else
		{
			document.forms[0].nursing_unit.value		="";
			document.forms[0].nursing_unit_desc.value	="";
		}
	}
}
// To get the Specialty using common lookup.
async function getSpecialtyValue(aSpecialty, getFacilitID, details)
{

	var facility_id	   = getFacilitID;
	var target		   = document.forms[0].specialty_desc;
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale = document.forms[0].locale.value;

	sql=" Select speciality_code code,short_desc description from AM_SPECIALITY_LANG_VW where eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";
	tit=getLabel("Common.speciality.label","Common");
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = aSpecialty.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		
		if(details == "from")
		{
			document.forms[0].from_Splcode.value=arr[0];
			document.forms[0].from_specialty_desc.value=arr[1];
		}
		else
		{
			document.forms[0].Splcode.value=arr[0];
			document.forms[0].specialty_desc.value=arr[1];
		}
	}
	else
	{
		if(details == "from")
		{
			document.forms[0].from_specialty_desc.value = "";
			document.forms[0].from_Splcode.value = "";
		}
		else
		{
			document.forms[0].specialty_desc.value = "";
			document.forms[0].Splcode.value = "";
		}
	}
} // End of getSpecialtyValue.



//Pls note.. This function is not moved to IPLookup.js as many Java variables are directly used in this function...    
function clearAll()
{
	call_function =document.forms[0].call_function.value;
	{	
	document.forms[0].reset();
	parent.frames[2].location.href ='../../eCommon/html/blank.html';
	}

	if(parent.messageFrame)
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	document.forms[0].search.disabled=false;
}


function BeforeGetPractitioner(obj, target, details)
{
	if(details == 'from')
	{
		if(document.forms[0].from_practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].from_practid.value =""
	}
	else
	{
		if(document.forms[0].practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].practid.value =""
	}
}


//, to use Common Lookup. starts.,
function getPractitionerLocal(obj, target, details)
{
	
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";

	practName_FName=target.name;
	practName_FValue=target.value;

	if(details == 'from')
		practId_FName=document.forms[0].from_practid.name;
	else
		practId_FName=document.forms[0].practid.name;


	var facility_id			= document.forms[0].facilityID.value;
	var locale			= "<%=locale%>";
	getPractitioner(obj, target, facility_id, "","","Q3");

}
// End of getToPractitioner.

// To be called by the GeneralPractitionerSearch to set Practitioner.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName == "from_practid_desc")
		{
			document.forms[0].from_practid.value=arr[0];
			document.forms[0].from_practid_desc.value=arr[1];			
		}
		else if(objName=='cancel_pract')
		{
			document.forms[0].cancel_pract_id.value=arr[0];
			document.forms[0].cancel_pract.value=arr[1];

		}	
		else
		{
			document.forms[0].practid.value=arr[0];
			document.forms[0].practid_desc.value=arr[1];			
		}
	}
	else
	{
		if(objName.name == "practid_desc")
		{
			document.forms[0].from_practid.value="";
			document.forms[0].from_practid_desc.value="";			
		}
		else if(objName=='cancel_pract'){
		
			document.forms[0].cancel_pract_id.value="";
			document.forms[0].cancel_pract.value="";
		}
		else
		{
			document.forms[0].practid.value="";
			document.forms[0].practid_desc.value="";			
		}
	}
}


async function getDescriptions(aCode, getFacilitID, details)
{	
	var facility_id		= getFacilitID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var locale			= document.forms[0].locale.value;
	var sql				= "";
	var tit				= "";
	if(details == 'S')
	{
		sql = " Select SERVICE_CODE code,short_desc description from AM_SERVICE_LANG_VW where eff_status like 'E' and upper(SERVICE_CODE) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";
		tit = getLabel("Common.service.label","Common");

	}
	else if(details == 'SS')
	{
		sql = " Select SUBSERVICE_CODE code,short_desc description from AM_SUBSERVICE_LANG_VW where eff_status like 'E' and upper(SUBSERVICE_CODE) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";
		tit = getLabel("Common.subservice.label","Common");
	}


	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = aCode.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");

		if(details == 'S')
		{
			document.forms[0].ServiceCode.value=arr[0];
			document.forms[0].Service_desc.value=arr[1];

		}
		else if(details == 'SS')
		{
			document.forms[0].SubServiceCode.value=arr[0];
			document.forms[0].SubService_desc.value=arr[1];
		}

	}
	else
	{
		if(details == 'S')
		{
			document.forms[0].ServiceCode.value = "";
			document.forms[0].Service_desc.value = "";
		}
		else if(details == 'SS')
		{
			document.forms[0].SubServiceCode.value = "";
			document.forms[0].SubService_desc.value = "";
		}
	}
} 
// These Function's will check for empty values before calling up the common lookup func..
function BeforeGetNursingUnit(obj1,obj2,obj3)
{
	if(obj3 == 'from')
	{
		if(document.forms[0].from_nursing_unit_desc.value != "")
			getNursingUnitValue(obj1,obj2,obj3);
		else
			document.forms[0].from_nursing_unit.value = "";
	}
	else
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			getNursingUnitValue(obj1,obj2,obj3);
		else
			document.forms[0].nursing_unit.value = "";
	}
}


function BeforeGetSpecialtyValue(obj1,obj2,obj3)
{
	if(obj3 == 'from')
	{
		if(document.forms[0].from_specialty_desc.value != "")
			getSpecialtyValue(obj1,obj2,obj3);
		else
			document.forms[0].from_Splcode.value = "";
	}
	else
	{
		if(document.forms[0].specialty_desc.value != "")
			getSpecialtyValue(obj1,obj2,obj3);
		else
			document.forms[0].Splcode.value = "";
	}
}
	
function BeforeGetServiceValue(obj1,obj2)
{
	if(document.forms[0].Service_desc.value != "")
		getDescriptions(obj1,obj2,'S');
	else
		document.forms[0].ServiceCode.value = "";
}

	function BeforeGetSubServiceValue(obj1,obj2)
{
	if(document.forms[0].SubService_desc.value != "")
		getDescriptions(obj1,obj2,'SS');
	else
		document.forms[0].SubServiceCode.value = "";
}
 

function CheckZeroVal(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{
        return true;
    }
    else 
	{
		if(obj.value.length > 0 && obj.value==0) 
		{
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

function compareDates()
{
	var from = document.forms[0].from_date;
	var to = document.forms[0].to_date;
	
	if(from.value !='' && to.value !='')// DateUtils.js
	{
		if(validDate(from.value,"DMY",localeName) && validDate(to.value,"DMY",localeName))
		{
			var fromDt	= convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
			var toDt	= convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");
			if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date.select();
			}
		}
	}
}

function enableDisableDays(Obj)
{
	if(Obj.checked)
	{
		document.forms[0].no_of_days.readOnly = false;
		document.forms[0].include_yn.value = "Y";
		document.getElementById("daysImg").style.visibility = "visible";
	}
	else
	{
		document.forms[0].no_of_days.value = "";
		document.forms[0].include_yn.value = "N";
		document.forms[0].no_of_days.readOnly = true;
		document.getElementById("daysImg").style.visibility = "hidden";
	}
}

function closeWin(enc,patid,changefunc)
{
	showModalCurEnc(enc,patid,changefunc);
}
var locn;

async function showModalBabyDetails(encounterid,facilityid,mother_patient_id,pract_id,nursing_code,sex,bed_no,patient_class)
{

	var retVal1;
	var call_function = document.forms[0].call_function.value;
	var arguments="";
	var dialogHeight= "700px";
	var dialogWidth = "900px";
	var dialogTop	= "230";

	var dialogLeft	= "65";

	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	retVal1 = await window.showModalDialog("../jsp/LinkBabytoMotherFrames.jsp?encounterid="+encounterid+"&facilityid="+facilityid+"&call_function="+call_function+"&nursing_code="+nursing_code+"&sex="+sex+"&bed_no="+bed_no+"&patient_class="+patient_class+"&mother_patient_id="+mother_patient_id,arguments,features);

}

async function showModalCurEnc(enc,patid,changefunc)
{
	
	var bl_install_yn=document.forms[0].bl_install;
	var call_function = document.forms[0].call_function.value;
	var jsp_name="CurrentEncounterMain.jsp";

	if(changefunc == "Y")
	//	call_function = "QueryDischarge";

	var retVal = 	new String();

	var dialogHeight= "700px";
	var dialogWidth = "1200px";
	var dialogTop	= "72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eIP/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn.value+"&call_function="+call_function+"&patientId="+patid,arguments,features);
	if(retVal!=null && retVal!='')
	parent.frames[2].document.location.reload();
}


function submitPrevNext(from, to)
{

	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

function validSplchars1(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Encounter ID";
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

function hideToolTip()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden'

}

function callDummy()
{

}

function callMouseOver(obj)
{
	currClass = obj.className ;
	obj.className = 'OASUSPENDED';
}

function callOnMouseOut(obj)
{
	obj.className = currClass; 
}


function displayToolTip(facility_id, encounter_id, patient_id, oper_stn_id,login_user, nursing_unit, bed_no)

{  
			
	buildTable(facility_id, encounter_id, patient_id, oper_stn_id,login_user, nursing_unit, bed_no) ;
		
		bodwidth  = parent.parent.frames[1].document.body.offsetWidth
		bodheight = parent.parent.frames[1].document.body.offsetHeight
		var x 	  = event.x
		var y 	  = event.y;
		
		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth)
		y 	  = y + (document.getElementById("tooltiplayer").offsetHeight)

		if(x<bodwidth)
			x = event.x 
		else
			x = x - (document.getElementById("tooltiplayer").offsetWidth)
		if(y<bodheight)
			y = event.y
		else
			y = y - (document.getElementById("tooltiplayer").offsetHeight)
				
		y+=document.body.scrollTop
		x+=document.body.scrollLeft
			
		document.getElementById("tooltiplayer").style.posLeft= x-9;
		document.getElementById("tooltiplayer").style.posTop = y-7;
		document.getElementById("tooltiplayer").style.visibility='visible' 
		
}
function buildTable(facility_id, encounter_id, patient_id, oper_stn_id,login_user, nursing_unit_code, bed_no)
{  
			 var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='allow_form' id='allow_form' method='post'  action='../../eIP/jsp/ManageCurrentAllowedOperation.jsp' ><input type='hidden' name='encounter_id' id='encounter_id' value='"+encounter_id+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='oper_stn_id' id='oper_stn_id' value='"+oper_stn_id+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='"+nursing_unit_code+"'><input type='hidden' name='bed_no' id='bed_no' value='"+bed_no+"'></form></BODY></HTML>";
		     parent.messageFrame.document.write(HTMLVal);
		     parent.messageFrame.allow_form.submit();
	 }

/* function MPClearAll() {
with (document.forms[thisForm]) {
for (var n=0; n<defaultVals.length; n++) {
var thisField = defaultVals[n][0];
var thisDefault = defaultVals[n][1];
if (elements[thisField].value == thisDefault)
elements[thisField].value = '';
}}} */

async function CallFunction(P_FACILITY_ID,P_ENCOUNTER_ID,P_PATIENT_ID,P_OPER_STN_ID,P_USER_ID,P_NURSING_UNIT,P_BED_NO,Function_st)

{
	if(Function_st=="BOOKING")
    {
        var dialogHeight= "60vh" ;
        var dialogWidth = "70vw" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
        var arguments   = "" ;
		var parameters="";
		var retVal = await window.showModalDialog("../../eIP/jsp/Booking.jsp"+parameters,arguments,features);

        if (retVal=="ok")
        {
            window.close();
        }
    }


}


