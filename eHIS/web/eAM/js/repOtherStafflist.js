function reset() 
{ 
	f_query_add_mod.document.location.reload();
}

function run() 
{
 var repAMOtherStaffListForm= f_query_add_mod.document.repAMOtherStaffListForm;
if(repAMOtherStaffListForm)
{
 var fields = new Array( repAMOtherStaffListForm.p_fm_oth_staff_id,repAMOtherStaffListForm.p_to_oth_staff_id );
  var names = new Array((getLabel("eAM.OtherStaffID.label","eAM")+" "+getLabel("Common.from.label","Common")), (getLabel("eAM.OtherStaffID.label","eAM")+" "+getLabel("Common.to.label","Common")));
  if(CheckString(getLabel("eAM.OtherStaffID.label","eAM"),repAMOtherStaffListForm.p_fm_oth_staff_id,repAMOtherStaffListForm.p_to_oth_staff_id, messageFrame )) 
  repAMOtherStaffListForm.submit() ;
 }
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

function searchCode(obj,target)
				{
				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit="";
				var sql="";

				if(obj.name=="fm_otherstaffID" || obj.name=="to_otherstaffID")
			{
				tit=getLabel("Common.OtherStaff.label","Common");
				sql="select other_staff_id code, other_staff_name description from am_other_staff where upper(other_staff_id) like upper(nvl(?,other_staff_id)) and upper(other_staff_name) like upper(nvl(?,other_staff_name)) order by 2";

				
			}

			if(obj.name=="rep_facility1")
			{
				tit=getLabel("Common.facility.label","Common");	
				sql="select facility_id code,facility_name description from sm_facility_param where upper(facility_id) like upper(nvl(?,facility_id)) and upper(facility_name) like upper(nvl(?,facility_name)) order by 2";	
				
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