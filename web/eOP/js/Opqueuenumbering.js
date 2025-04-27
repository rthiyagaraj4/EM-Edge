function create()
{
    f_query_add_mod.location.href = "../../eOP/jsp/addModifyOpqueuenumbering.jsp?&source=Insert" ;
}

function edit()
{
    formToolbarFrame.location.href = "formToolbar.html" ;
}

function query()
{
    f_query_add_mod.location.href ="../../eOP/jsp/OpqueuenumberingQueryCriteria.jsp?function=Opqueuenumbering";
}

function onBlurgetLoc(fac_id,objval,target)
{

		
		if(target.value == "")
		{
			target.value="";
			document.forms[0].locn_code.value="";
			return;
		}

 getLocn(fac_id,objval,target);

}

async function getLocn(fac_id,objval,target)
{
	
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";	
   
  
   tit=getLabel('Common.Location.label','Common');

   sql ="select clinic_code code ,long_desc description from op_clinic where facility_id = '"+fac_id+"' and clinic_type='"+objval+"' and eff_status = 'E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by long_desc ";	
   
	
  				
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;				
				retVal = await CommonLookup( tit, argumentArray );			
				
				
				if(retVal != null && retVal != "" )
                {

	             var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];					
				document.forms[0].locn_code.value=arr[0];

          }
		  PopulatePractitioner();
}
function selectResource(obj)
{
document.forms[0].other_resource.value=obj.value;
var loccode = opqueuenumbering_form.locn_code.value;
var length = parent.f_query_add_mod.document.opqueuenumbering_form.room_no.length;
var otherres=parent.f_query_add_mod.document.opqueuenumbering_form.other_resource.value;

	for(var i=1;i<length;i++)
     parent.f_query_add_mod.document.opqueuenumbering_form.room_no.remove(1);

	

if (loccode != null && loccode != "")
{
var HTML = "<html><body onKeyDown='lockKey();'><form name='queryprac' id='queryprac' method='post' action='../../eOP/jsp/OpqueuenumberingPopulate.jsp?getoption=three'><input type='hidden' name='locn_code' id='locn_code' value='"+loccode+"'><input type='hidden' name='other_res' id='other_res' value='"+obj.value+"'></form></body></html>";

//Code added/modified by Tushar .T. Bhat on 19-Feb-04


}
parent.dummyframe.document.body.insertAdjacentHTML('afterbegin',HTML);
		parent.dummyframe.document.queryprac.submit();

		

	      }



function apply()
{
   
	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	

	var fields = new Array (    f_query_add_mod.document.forms[0].locn_type,
                        f_query_add_mod.document.forms[0].locn_code
                        
                        );

	var names = new Array ( getLabel("Common.locationtype.label","Common"),
                         getLabel("Common.Location.label","Common")
                         
                        );

	

	//Code added/modified by Tushar .T. Bhat on 19-Feb-04 ends


    if(f_query_add_mod.checkFields( fields, names, messageFrame))
    {
        f_query_add_mod.document.forms[0].room_no.disabled=false;
		f_query_add_mod.document.forms[0].other_resource.disabled=false;
        f_query_add_mod.document.forms[0].room_no1.disabled=false;
		//f_query_add_mod.document.forms[0].roomdisp.disabled=false;

		var fn_status = f_query_add_mod.document.forms[0].function_name.value ;
        
		//Code added by Tushar .T. Bhat on 19-Feb-04

		
		if(f_query_add_mod.trimString(f_query_add_mod.document.forms[0].practitioner_id.value) == '')
				f_query_add_mod.document.forms[0].practitioner_id.value = '*ALL';


		//Code added by Tushar .T. Bhat on 19-Feb-04 ends
		//if(resetqno.value =='0')    resetqno.value=''
		
		f_query_add_mod.document.forms[0].submit();

        
    }

}

function onSuccess()
{
    if(f_query_add_mod.document.forms[0].function_name.value == "insert")
    {
		f_query_add_mod.document.location.reload();
		f_query_add_mod.document.forms[0].locn_type.value  = "" ;
	    f_query_add_mod.document.forms[0].locn_code.value = "" ;
		f_query_add_mod.document.forms[0].practitioner_id.value     = "" ;
	    f_query_add_mod.document.forms[0].practitioner_name.value     = "" ;
		//f_query_add_mod.document.forms[0].start_queue_num.value     = "" ;
	    //f_query_add_mod.document.forms[0].next_queue_num.value  = "" ;
		//f_query_add_mod.document.forms[0].reset_queue_num.value = "" ;
	    f_query_add_mod.document.forms[0].open_to_all_pract_yn.value = "" ;

		/*var selected = f_query_add_mod.document.forms[0].locn_code;
	    while ( selected.options.length > 0 )
		    selected.remove(selected.options[0]);
		    var opt=f_query_add_mod.document.createElement("Option");
		    opt.text="   ----- "+getLabel("Common.defaultSelect.label","Common")+" -----   "
		    opt.value="";
		    f_query_add_mod.document.getElementById("locn_code").add(opt);*/

		/*if(f_query_add_mod.document.forms[0].reset_queue_num.value == '0')
			f_query_add_mod.document.forms[0].reset_queue_num.value = '';*/

		
		//Code added/modified by Tushar .T. Bhat on 19-Feb-04

		
	/*	var length = f_query_add_mod.document.forms[0].room_no.length;

		for(var i=2;i<length;i++)
			f_query_add_mod.document.forms[0].room_no.remove(2);
		
		f_query_add_mod.document.forms[0].room_no.options[0].selected = true;*/

		f_query_add_mod.opqueuenumbering_form.pname.disabled = true;
		f_query_add_mod.opqueuenumbering_form.practitioner_name.readOnly = true;
				
		//Code added/modified by Tushar .T. Bhat on 19-Feb-04 ends


    }
}


function reset()
{
	// f_query_add_mod.location.reload() ;
   
   /* if(f_query_add_mod.document.forms[0].name == "opqueuenumbering_form"){
    
		ClearList(f_query_add_mod.document.forms[0].locn_code);
		
		
		//Code added/modified by Tushar .T. Bhat on 19-Feb-04
		
		var length = f_query_add_mod.document.opqueuenumbering_form.room_no.length;

		for(var i=2;i<length;i++)
			f_query_add_mod.document.opqueuenumbering_form.room_no.remove(2);

		f_query_add_mod.document.opqueuenumbering_form.room_no.options[0].selected = true;
		f_query_add_mod.document.opqueuenumbering_form.identifyPractitionerAtCheckIn.value = "N";

		f_query_add_mod.document.opqueuenumbering_form.practitionerMandatoryGIF.style.visibility = "hidden";

		f_query_add_mod.opqueuenumbering_form.pname.disabled = true;
		f_query_add_mod.opqueuenumbering_form.practitioner_name.readOnly = true;

		//Code added/modified by Tushar .T. Bhat on 19-Feb-04 ends

		f_query_add_mod.document.opqueuenumbering_form.reset() ;
	
	
	}
    else{
        f_query_add_mod.document.query_form.reset() ;
	}*/

    if(f_query_add_mod.location.href.indexOf("OpqueuenumberingQueryResult.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;

}

function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
  return true;
 else
  return false;
}


function disablePract()
{
	opqueuenumbering_form.locn_code1.value = "";
	opqueuenumbering_form.locn_code.value = "";

	opqueuenumbering_form.practitioner_name.value = "";
	opqueuenumbering_form.pname.disabled = true;
	opqueuenumbering_form.practitioner_id.value = "";
	opqueuenumbering_form.practitioner_name.readOnly = true;

	opqueuenumbering_form.identifyPractitionerAtCheckIn.value = 'N';
	opqueuenumbering_form.practitionerMandatoryGIF.style.visibility = 'hidden';

}

/*function PopulateLocation()
{
    var selected = opqueuenumbering_form.locn_code;
    while ( selected.options.length > 0 )
        selected.remove(selected.options[0]);

	//Code added by Tushar .T. Bhat on 05-Feb-04 for clearing practitioner text box  and disabling it on change on location code

	opqueuenumbering_form.practitioner_name.value = "";
	opqueuenumbering_form.pname.disabled = true;
	opqueuenumbering_form.practitioner_id.value = "";
	opqueuenumbering_form.practitioner_name.readOnly = true;
	
	//Code added by Tushar .T. Bhat on 05-Feb-04 ends

	//Code added by Tushar .T. Bhat on 19-Feb-04

	opqueuenumbering_form.identifyPractitionerAtCheckIn.value = 'N';
	opqueuenumbering_form.practitionerMandatoryGIF.style.visibility = 'hidden';
	
//	var length = parent.f_query_add_mod.document.opqueuenumbering_form.room_no.length;

	//for(var i=2;i<length;i++)
	//	parent.f_query_add_mod.document.opqueuenumbering_form.room_no.remove(2);

	//Code added by Tushar .T. Bhat on 19-Feb-04 ends
	   

    var loctype = opqueuenumbering_form.locn_type.value;
    if (loctype != null && loctype != "")
    {
        var HTMLVal = "<html><body><form name='queryloc' id='queryloc' method='post' action='../../eOP/jsp/OpqueuenumberingPopulate.jsp?getoption=one'><input type='hidden' name='locn_type' id='locn_type' value='"+loctype+"'></form></body></html>";
        
		
		//Code added/modified by Tushar .T. Bhat on 19-Feb-04

		if(	!parent.messageFrame.document.queryloc)
		{		
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.queryloc.submit();
		
		}

		//Code added/modified by Tushar .T. Bhat on 19-Feb-04 ends
    }
    else
    {
        var opt=parent.frames[1].document.createElement("Option");
        opt.text="   ----- "+getLabel("Common.defaultSelect.label","Common")+" -----   "
        opt.value="";
        parent.frames[1].document.getElementById("locn_code").add(opt);
    }
}*/


function PopulatePractitioner()
{
    var loccode = opqueuenumbering_form.locn_code.value;
/*	var length = parent.f_query_add_mod.document.opqueuenumbering_form.room_no.length;
	for(var i=2;i<length;i++)
		parent.f_query_add_mod.document.opqueuenumbering_form.room_no.remove(2);*/

	if (loccode != null && loccode != "")
    {  
        var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='queryprac' id='queryprac' method='post' action='../../eOP/jsp/OpqueuenumberingPopulate.jsp?getoption=two'><input type='hidden' name='locn_code' id='locn_code' value='"+loccode+"'></form></body></html>";
        
		//Code added/modified by Tushar .T. Bhat on 19-Feb-04

		if(!parent.messageFrame.document.queryprac)
		{ 
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.queryprac.submit();

		}

		//Code added/modified by Tushar .T. Bhat on 19-Feb-04 ends

		opqueuenumbering_form.practitioner_name.value = "";
		opqueuenumbering_form.pname.disabled = false;
		opqueuenumbering_form.practitioner_name.readOnly = false;
		

		//Code added by Tushar .T. Bhat on 05-Feb-04 

		//During submission of form apply() checks for practitioner_id and hence it should be reset
		
		opqueuenumbering_form.practitioner_id.value = "";
		//opqueuenumbering_form.practitioner_name.readOnly = false;

		//Code added by Tushar .T. Bhat on 05-Feb-04 ends

		//Code added by Tushar .T. Bhat on 19-Feb-04

		opqueuenumbering_form.identifyPractitionerAtCheckIn.value = 'N';
		opqueuenumbering_form.practitionerMandatoryGIF.style.visibility = 'hidden';
	
    }
	else
	{
	//	opqueuenumbering_form.practitioner_name.value = "";
	//	opqueuenumbering_form.pname.disabled = true;

		//Code added by Tushar .T. Bhat on 05-Feb-04 

		//During submission of form apply() checks for practitioner_id and hence it should be reset
		
		//opqueuenumbering_form.practitioner_id.value = "";
		//opqueuenumbering_form.practitioner_name.readOnly = false;

		//Code added by Tushar .T. Bhat on 05-Feb-04 ends

		//Code added by Tushar .T. Bhat on 19-Feb-04
		opqueuenumbering_form.identifyPractitionerAtCheckIn.value = 'N';
		opqueuenumbering_form.practitionerMandatoryGIF.style.visibility = 'hidden';
	
		//Code added by Tushar .T. Bhat on 19-Feb-04 ends
	
	}

}

/********** added on 11/26/2003******************/
function ClearList(object)
{
    
    
	if (object)
	var length  =object.length;

	var element = f_query_add_mod.document.opqueuenumbering_form.document.createElement('OPTION');
    element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
    element.value="";
   

	
    for(i=1;i<length;i++)
		object.remove(1);
   

}
/**********************************************************/
//JS functions used in OPQueueNumbering control

function assign(val)
	{
		opqueuenumbering_form.next_queue_num.value=val;
	}

function NumberCheck(obj)
{
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)
	{   }
	else
	{
		if ( obj.value.length > 0 )
		{
			var errors = getMessage("NUM_ALLOWED","SM");
			alert(errors);
			obj.value="0";
			obj.select();
			obj.focus();
		}
	}
}

function onBlurCallPractitionerSearch(obj,target_name)
	{
		target_name.value = trimString(target_name.value);
		 
		if(target_name.value == "")
		{
			document.forms[0].practitioner_id.value="";
			return;
		}

		callPractSearch(obj,target_name);

	}


	function callPractSearch(obj,target)
	{
		//var practName_FName="";
		//var practName_FValue="";
		var locncode		= opqueuenumbering_form.locn_code.value;
		var allpractyn		= opqueuenumbering_form.open_to_all_pract_yn.value;
		var res_class		= opqueuenumbering_form.res_class.value;
		var loginfacilityid = document.forms[0].loginfacilityid.value;

		
		/*var sql="";
		var sqlSec="";
				
		target.value=trimString(target.value);
		practName_FName=target.name;
		practName_FValue=target.value;*/
				
		/* The sql and sqlsec queries are used to fetch the practitioner names and id's where the practitioners are belongs to certain location and speciality. By making an xml string these queries are being passed to "callGeneralPractitionerSearch.jsp" to display the search results --- Srijagadeesh. */

		if((allpractyn == "Y" && res_class =='P') || (res_class != 'P'))
		{
			getPractitioner(obj,target,loginfacilityid,'','',locncode,'','','','',"Q5");

			/*sql="select DISTINCT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name,B.PRACT_TYPE_DESC practitioner_type, decode(b.position_code, 'CC', 'Chief Consultant', 'CO','Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.position_code) job_title, b.GENDER gender,B.PRIMARY_SPLTY_SHORT_DESC primary_specialty  from  op_clinic a, AM_PRACT_ALL_SPLTY_VW b where a.facility_id='"+loginfacilityid+"' and a.clinic_code='"+locncode+"' and a.specialIty_code = b.PRIMARY_SPECIALITY_CODE and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.PRIMARY_SPECIALITY_CODE) like upper(nvl(?,b.PRIMARY_SPECIALITY_CODE)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) order by 2";
	 

			sqlSec="select DISTINCT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name,B.PRACT_TYPE_DESC practitioner_type, decode(b.position_code, 'CC', 'Chief Consultant', 'CO','Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.position_code) job_title, b.GENDER   gender,B.PRIMARY_SPLTY_SHORT_DESC primary_specialty  from  op_clinic a, AM_PRACT_ALL_SPLTY_VW b where a.facility_id='"+loginfacilityid+"' and a.clinic_code='"+locncode+"' and a.specialIty_code = b.PRIMARY_SPECIALITY_CODE and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.PRIMARY_SPECIALITY_CODE) like upper(nvl(?,b.PRIMARY_SPECIALITY_CODE)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) order by 2";
			*/


		}
		else if(allpractyn == "N" && res_class =='P')
		{
			getPractitioner(obj,target,loginfacilityid,'','',locncode,'','','','',"Q6");

			/*sql="select b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, nvl(d.desc_sysdef,d.desc_userdef) practitioner_type, decode(b.position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.position_code) job_title, decode(b.gender,'M','Male','F','Female','U','Unknown') gender, e.short_desc primary_specialty from op_pract_for_clinic a, am_practitioner b, op_clinic c, am_pract_type d, am_speciality e where a.practitioner_id = b.practitioner_id and a.clinic_code=c.clinic_code and b.pract_type=nvl(c.pract_type,b.pract_type) and a.clinic_code='"+locncode+"' and c.facility_id = a.facility_id and a.facility_id='"+loginfacilityid+"' and a.eff_status = 'E' and d.pract_type=b.pract_type and e.speciality_code=b.primary_speciality_code and upper(d.pract_type) like upper(nvl(?,d.pract_type)) and upper(c.speciality_code) like upper(nvl(?,c.speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) order by 2";


			sqlSec="select b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, nvl(d.desc_sysdef,d.desc_userdef) practitioner_type, decode(b.position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.position_code) job_title, decode(b.gender,'M','Male','F','Female','U','Unknown') gender, e.short_desc primary_specialty from op_pract_for_clinic a, am_practitioner b, op_clinic c, am_pract_type d, am_speciality e where a.practitioner_id = b.practitioner_id and a.clinic_code=c.clinic_code and b.pract_type=nvl(c.pract_type,b.pract_type) and a.clinic_code='"+locncode+"' and c.facility_id = a.facility_id and a.facility_id='"+loginfacilityid+"' and a.eff_status = 'E' and d.pract_type=b.pract_type and e.speciality_code=b.primary_speciality_code and upper(d.pract_type) like upper(nvl(?,d.pract_type)) and upper(c.speciality_code) like upper(nvl(?,c.speciality_code)) and upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name)) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) order by 2";
			*/

		}

		/*var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practName_FName + "\""	;
		xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue) + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sqlSec)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + ""+ "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
				
		eval(responseText);	*/
	}



	function PractLookupRetVal(retVal,objName)
	{

		var arr;
		if (retVal != null && trimString(retVal) !="" )
		{
			arr=retVal.split("~");
				document.forms[0].practitioner_id.value=arr[0];
				document.forms[0].practitioner_name.value=arr[1];			
		}
		else
		{
				document.forms[0].practitioner_id.value="";		document.forms[0].practitioner_name.value="";			
		}
	
	}

