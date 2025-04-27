function reset() 
{ 
	f_query_add_mod.document.location.reload();
}

function run() 
{
 var repAMPractListForm= f_query_add_mod.document.repAMPractListForm;
if(repAMPractListForm)
{
 var fields = new Array( repAMPractListForm.p_fm_practitioner_id,repAMPractListForm.p_to_practitioner_id );
  var names = new Array((getLabel("Common.practitionerid.label","Common")+" "+getLabel("Common.from.label","Common")), (getLabel("Common.practitionerid.label","Common")+" "+getLabel("Common.to.label","Common")));
  if(CheckString(getLabel("Common.practitionerid.label","Common"),repAMPractListForm.p_fm_practitioner_id,repAMPractListForm.p_to_practitioner_id, messageFrame )) 
  repAMPractListForm.submit() ;
 }
}

function searchCode(obj,target)
				{
				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit="";
				var sql="";

				if(obj.name=="fm_practitioner" || obj.name=="to_practitioner")
			{
				tit=getLabel("Common.practitioner.label","Common");
				sql="select practitioner_id code, practitioner_name description from am_practitioner where upper(practitioner_id) like upper (nvl(?,practitioner_id)) and upper(practitioner_name) like upper (nvl(?,practitioner_name)) order by 2";
			
			}	

			if(obj.name=="rep_facility1")
			{
				tit=getLabel("Common.facility.label","Common");	
				sql="select facility_id code,facility_name description from sm_facility_param where upper (facility_id) like upper(nvl(?,facility_id)) and upper(facility_name) like upper(nvl(?,facility_name)) order by 2";	
				
			}
					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;

				var retVal=CommonLookup(tit,argumentArray);
	            if(retVal==null || retVal=="")
	            target.value="";
	            else
	            target.value=retVal[0];
			}


	     
function checkVal(obj,target)
{
 if(obj.value=="Y")
	{
	 target.disabled=false;
}else 
{
	 target.value="";
	 target.disabled=true;

}
}


function RepFacilityVal(obj2,rep_facility1,p_rep_facility_value)
{
 if(obj2.value=="Y")
	{ 
      rep_facility1.disabled=false;
	  p_rep_facility_value.disabled=false;
}else 
{    
	 p_rep_facility_value.value ="";
	 rep_facility1.disabled=true;
	 p_rep_facility_value.disabled=true;
}
}



function CheckString(str,fromobj,toobj,messageFrame) {
var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) { 
            return true;
        }
        else {
var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
error=error.replace("#",str);
messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}





