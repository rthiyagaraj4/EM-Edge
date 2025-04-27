function reset() 
{ 
	f_query_add_mod.document.repSMDisInaUserMenuForm.reset() ;
}

function run()
	{
		var repSMDisInaUserMenuForm=f_query_add_mod.document.repSMDisInaUserMenuForm;
		if(repSMDisInaUserMenuForm)
		{
		var fields = new Array( repSMDisInaUserMenuForm.p_fm_user_id,
		repSMDisInaUserMenuForm.p_to_user_id );
		var names = new Array((getLabel("Common.userid.label","Common")+" "+getLabel("Common.from.label","Common")), (getLabel("Common.userid.label","Common")+" "+getLabel("Common.to.label","Common")));
		
			if(CheckString(getLabel("Common.userid.label","Common"),repSMDisInaUserMenuForm.p_fm_user_id, repSMDisInaUserMenuForm.p_to_user_id, messageFrame ) ){
			repSMDisInaUserMenuForm.submit() ;
		}	
		}
		
	}


function searchCode(obj,target)
{
	var facilityid	   = document.forms[0].p_facility_id.value;
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	var sql="";	

			if(obj.name=="from_user_id" || obj.name=="to_user_id")
			{
				tit=encodeURIComponent(getLabel('Common.user.label','Common'));
				sql="select APPL_USER_ID code,APPL_USER_NAME description from sm_appl_user where upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) order by 2 ";
			
				
			}

    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK  ;
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
        else 
		{
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

function DateCompare1(from,to){
	if(from.value!="" && to.value!="" ){
		if(isBefore(from.value,to.value,'DMY',localeName)==false){
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value="";
			to.select();	
			return false;
		}else{
			return true;
		}
	}
}


