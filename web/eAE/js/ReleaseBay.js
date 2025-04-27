function query()
{
	//self.f_query_add_mod.document.frames[0].location.href="../../eAE/jsp/ReleaseBayCriteria.jsp";
	self.f_query_add_mod.document.ReleaseBed_criteria.location.href="../../eAE/jsp/ReleaseBayCriteria.jsp";
	//self.f_query_add_mod.document.frames[1].location.href="../../eCommon/html/blank.html";
	self.f_query_add_mod.document.ReleaseBed_result.location.href="../../eCommon/html/blank.html";
}
function CheckNumberInput(fld, e, deci)
{
	if (	parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';
	
   var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function DateCompare(from,to) 
{
	//var todate = to.value; Commented and below line added by Rameswar on 05-Oct-15 for Leap Year Issue
	var todate = convertDate(to.value,"DMYHM",localeName,"en");
	if (todate != "")
	{
	
		//if(!doDateTimeChk(to)) Commented and below line added by Rameswar on 05-Oct-15 for Leap Year Issue
		if(!doDateTimeChk(todate))
		{			
			alert(getMessage("INVALID_DATE_TIME",'SM'));					
			to.focus();
			to.select();
			return
		}
	}
}

function checkFields1( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
		
        if(trimCheck1(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else    errors = errors + "APP-000001 " + names[i] + "<br>" ;
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}

function trimCheck1(inString) {
    var startPos;
    var ch;
    startPos = 0;
    strlength = inString.length;
    for(var i=0;i<=strlength;i++) {
        ch = inString.charAt(startPos);
        if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
            startPos++;
        }
    }
    if(startPos == inString.length) return false;
    else return true;
}

function apply()
{
	
	var fields =  new Array();
	var names= new Array();
	
    //alert('f_query_add_mod.document.frames[1].document.forms[0].releasebed_hid.value'+f_query_add_mod.document.frames[1].document.forms[0].releasebed_hid.value);
    //var releasebedval=f_query_add_mod.document.frames[1].document.forms[0].releasebed_hid.value;	
	  var releasebedval= f_query_add_mod.ReleaseBed_result.document.getElementById("releasebed_hid").value;
	if((releasebedval != "") && (releasebedval != ","))
	{
		f_query_add_mod.frames[1].document.forms[0].method = "POST";
		f_query_add_mod.frames[1].document.forms[0].action = "../../servlet/eAE.ReleaseBedServlet";
		f_query_add_mod.frames[1].document.forms[0].target = "messageFrame";
		f_query_add_mod.frames[1].document.forms[0].submit()
	}
	else
	{		
		var fields = new Array (f_query_add_mod.document.frames[1].document.forms[0].releasebed_hid);
		var names = new Array (getLabel("eAE.OneBed.label","AE"));		

		checkFields1( fields, names, messageFrame)

	}

}

function GetLookupBlur(target_id,target)
{
	if(target.value != "")
	{
		GetLookup(target_id,target);
	}
	else
	{
		target_id.value="";
	}
}

function popTreatmentCode(objVal){
    
	
//	document.getElementById("treatment_area_lookup").style.visibility='visible';
	var clinic_code=releasebed_criteriaform.clinic_code;
	//var treatment_area_desc=releasebed_criteriaform.document.forms[0].treatment_area_desc;
	var treatment_area_desc=document.getElementById("treatment_area_desc");
	var bay_type_desc=releasebed_criteriaform.bay_type_desc.value;
	document.forms[0].treatment_area_lookup.disabled=false;
	
	if(objVal.value =='')
	{
	   document.releasebed_criteriaform.treatment_area_desc.value		= '';
	}
	
}

async function GetLookup(target_id,target)
{
	
	var sql="";
	
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var cliniccode=parent.frames[0].document.forms[0].clinic_code.value;
	var facilityid=parent.frames[0].document.forms[0].fac_id.value;
	if(target.name == "treatment_area_desc")
	{
		var tit				= getLabel("Common.treatmentarea.label",'Common');

		sql="select treatment_area_code code, short_desc description from ae_tmt_area_for_clinic_lang_vw where LANGUAGE_ID ='"+localeName+"' and clinic_code = '"+cliniccode+"' and facility_id = '"+facilityid+"' and eff_status='E' and upper(treatment_area_code) like upper(?) and upper(short_desc)  like upper(?) ";
	}
	else if(target.name == "bay_type_desc")
	{
		var tit				= getLabel("eAE.BedBayType.label","AE");
		sql="select bay_type_code code,short_desc description from ae_bay_type_lang_vw where  LANGUAGE_ID ='"+localeName+"' and  eff_status='E' and upper(bay_type_code) like upper(?) and upper(short_desc)  like upper(?) "

	}

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		target_id.value=arr[0];
		
	}
	else
	{
		target.value="";
		target_id.value="";
	}
	
}

function onSuccess()
{
	//self.f_query_add_mod.document.frames[1].location.reload();
	//self.f_query_add_mod.document.frames[0].location.reload();
	self.f_query_add_mod.document.ReleaseBed_criteria.location.reload();
	//self.f_query_add_mod.document.frames[1].location.href="../../eCommon/html/blank.html";
	self.f_query_add_mod.document.ReleaseBed_result.location.href="../../eCommon/html/blank.html";

}

function reset()
{
	self.f_query_add_mod.document.frames[0].location.reload();
	self.f_query_add_mod.document.frames[1].location.href="../../eCommon/html/blank.html";

}

			function showresult()
			{
				var cliniccode=document.forms[0].clinic_code.value;
				var treatmentarea =  document.forms[0].treatment_area.value;
				var baytype = document.forms[0].bay_type.value;			
				var reserveuntil = convertDate(document.forms[0].reserve_until.value,"DMYHM",localeName,"en")
				parent.frames[1].location.href="../../eAE/jsp/ReleaseBayResult.jsp?clinic_code="+cliniccode+"&treatment_area="+treatmentarea+"&bay_type="+baytype+"&reserve_until="+reserveuntil;
			}

			function clearValues()
			{
				self.location.reload();
				parent.frames[1].location.href = "../../eCommon/html/blank.html";				
			}


			function submitPrevNext(from, to)
			{
				
				document.forms[0].from.value = from;
				document.forms[0].to.value = to; 

				document.forms[0].submit();
			}
		/*	function releasevalues(objval,ival)
			{
			  var releasebeds = new ActiveXObject("Scripting.Dictionary");
		      var unreleasebeds = new ActiveXObject("Scripting.Dictionary");	
				
				var assval;
				var rarr = new Array();
				var assvalarr;
				
				
				var curval=document.getElementById("releasebed_hid").value;
				if(curval != "")
				{							
					rarr=curval.split(",");
					var arrlen=Math.abs(rarr.length) ;
				}			
				

				for (j=0; j<arrlen; j++)
				{
					assval	=	rarr[j];	
					
				
					if (!releasebeds.Exists(assval))
					releasebeds.add(assval,assval);
				}	

				
					var insval=ival+"^^"+objval;
					if(releasebeds.Exists(insval) == false)
						releasebeds.add(insval,insval);	

					document.getElementById("releasebed_hid").value = ((releasebeds.Keys()).toArray()).toString();
					document.getElementById("bool").value="true";			
					

			}*/
	function releaseValues(objval, ival) {
			    
			    var releasebeds = new Set();

			    var curval = document.getElementById("releasebed_hid").value;
			    var rarr = [];

			    if (curval !== "") {
			        rarr = curval.split(",");
			    }

			   rarr.forEach(function(assval) {
			        releasebeds.add(assval);
			    });

			    var insval = ival + "^^" + objval;
			    releasebeds.add(insval);

			    document.getElementById("releasebed_hid").value = Array.from(releasebeds).toString();
			    document.getElementById("bool").value = "true";
			}

function unrelease(obj,ival)
			{	
				//var releasebeds = new ActiveXObject("Scripting.Dictionary");
		        //var unreleasebeds = new ActiveXObject("Scripting.Dictionary");	
                var releasebeds = new Map();
                var unreleasebeds = new Map();
				var assval;
				var rarr = new Array();
				var assvalarr;
				
				
				var curval=document.getElementById("releasebed_hid").value;
				if(curval != "")
				{							
					rarr=curval.split(",");
					var arrlen=Math.abs(rarr.length) ;
				}			
				

				for (j=0; j<arrlen; j++)
				{
					assval	=	rarr[j];				
				
					if (!releasebeds.Exists(assval))
					releasebeds.add(assval,assval);
				}	
				
			
				if(obj.checked == false)
				{
					var insval=ival+"^^"+obj.value;			
					
					if(releasebeds.Exists(insval) == true)
					{
						releasebeds.remove(insval);							
					}			
					
				}
				else
				{
					var insval=ival+"^^"+obj.value;			
					
					if(releasebeds.Exists(insval) == false)
					{
						releasebeds.add(insval,insval);							
					}	
				}
				document.getElementById("releasebed_hid").value = ((releasebeds.Keys()).toArray()).toString();	
					
			}

			  function setfocus()
			 {
				 if(document.forms[0].reserve_yn0 != null)
					document.forms[0].reserve_yn0.focus();
			 }
 function dateVal(from,to)
	{
		var todate = to.value;
		if (todate != "")
		{
			if(validDate(to.value,"DMYHM",localeName))
			{
				if(isBeforeNow(to.value,"DMYHM",localeName))
				 {
					alert(getMessage("RES_UNTIL_LESS_SYSDATE",'AE'));
					to.value="";
					to.focus();
					return 
				 }
			}
			else
		    {
				alert(getMessage("INVALID_DATE_TIME",'SM'));					
				to.value="";
				to.focus();
				return
		    }
        }
	}
