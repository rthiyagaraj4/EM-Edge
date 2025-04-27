function reset() {
	 f_query_add_mod.document.forms[0].reset() ;
	 f_query_add_mod.location.href ='../../eSM/jsp/repUserPractStaffFacilityListForm.jsp';


}



function run() 
	{ 
	var repUserPractStaffFacilityList= f_query_add_mod.document.repUserPractStaffFacilityList;
	if(repUserPractStaffFacilityList)
	{
    
    
	var labels = new Array(getLabel('Common.userid.label','Common'),getLabel('Common.practitionerid.label','Common'),getLabel('Common.StaffID.label','Common'));
	var fm = new Array(repUserPractStaffFacilityList.p_from_appl_user_id,repUserPractStaffFacilityList.p_fm_practitioner_id,repUserPractStaffFacilityList.p_fm_staff_id);
	var to = new Array(repUserPractStaffFacilityList.p_to_appl_user_id,repUserPractStaffFacilityList.p_to_practitioner_id,repUserPractStaffFacilityList.p_to_staff_id);
	
	    
    
   
	   if(f_query_add_mod.CheckStringUserPractStaff(labels,fm,to,messageFrame))
   repUserPractStaffFacilityList.submit() ;
        
		
}
	}
	 

function CheckStringUserPractStaff(labels,fromobj,toobj,messageFrame) {
	
	var errors = "" ;
	for( var i=0; i<labels.length; i++ ) {
		
		var arr = new Array(toobj[i].value,fromobj[i].value);
    if( trimCheck(fromobj[i].value) && trimCheck(toobj[i].value) ) {
        if(fromobj[i].value <= toobj[i].value) { 
            
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +labels[i]);
			error=error.replace("#",labels[i]);
			errors += error+"<br>";   
        }
    }	
	}
if ( errors.length != 0 )
		{
        
		   messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
           return false ;
        }
    return true ;
	 
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

				if(obj.name=="from_user_id" ||obj.name=="to_user_id")
			{
				tit=getLabel("Common.user.label","Common");

				
				sql="select APPL_USER_ID code,APPL_USER_NAME description from sm_appl_user where upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) order by 2";
				
			}

				if(obj.name=="fm_practitioner" || obj.name=="to_practitioner")
			{
				tit=getLabel("Common.practitioner.label","Common");
				
				sql="select practitioner_id code, practitioner_name description from am_practitioner where upper(practitioner_id) like upper (nvl(?,practitioner_id)) and upper(practitioner_name) like upper (nvl(?,practitioner_name)) order by 2";
			
				
			}
				
               if(obj.name=="from_staff_id"||obj.name=="to_staff_id")
			{
				tit=getLabel("Common.Staff.label","Common");

				
				sql="select OTHER_STAFF_ID code, OTHER_STAFF_NAME description from am_other_staff where upper(OTHER_STAFF_ID) like upper(?) and upper(OTHER_STAFF_NAME) like upper(?) order by 2";
				
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

function ChangeState(obj)
{
 if (obj.checked == true)
  {
	  
	  document.forms[0].p_pract_staff_id_yn.value='Y';
  }
  else
  {
	   document.forms[0].p_pract_staff_id_yn.value="N";
  }
} 

function checkVal()
{
	

var search_by_value=document.repUserPractStaffFacilityList.p_search_by.value;
var search_by = document.repUserPractStaffFacilityList;
if( search_by_value== "U")
	{
	
	
	search_by.p_fm_practitioner_id.value="";
	search_by.p_to_practitioner_id.value="";
    search_by.p_fm_practitioner_id.disabled= true;
	search_by.fm_practitioner.disabled= true;
	search_by.p_to_practitioner_id.disabled= true;
	search_by.to_practitioner.disabled= true;
	


    search_by.p_fm_staff_id.value="";
	search_by.p_to_staff_id.value="";
	search_by.p_fm_staff_id.disabled= true;
	search_by.from_staff_id.disabled= true;
	search_by.p_to_staff_id.disabled= true;
	search_by.to_staff_id.disabled= true;
    

	search_by.p_from_appl_user_id.disabled= false;
	search_by.from_user_id.disabled= false;
	search_by.p_to_appl_user_id.disabled= false;
	search_by.to_user_id.disabled= false;
		
	}
	else if(search_by_value=="P")
	{
    search_by.p_from_appl_user_id.value="";
	search_by.p_to_appl_user_id.value="";
    search_by.p_from_appl_user_id.disabled= true;
	search_by.from_user_id.disabled= true;
	search_by.p_to_appl_user_id.disabled= true;
	search_by.to_user_id.disabled= true;

    search_by.p_fm_staff_id.value="";
	search_by.p_to_staff_id.value="";
	search_by.p_fm_staff_id.disabled= true;
	search_by.from_staff_id.disabled= true;
	search_by.p_to_staff_id.disabled= true;
	search_by.to_staff_id.disabled= true;

	search_by.p_fm_practitioner_id.disabled= false;
	search_by.fm_practitioner.disabled= false;
	search_by.p_to_practitioner_id.disabled= false;
	search_by.to_practitioner.disabled= false;
	}

	else if(search_by_value =="S")
	{
    search_by.p_from_appl_user_id.value="";
	search_by.p_to_appl_user_id.value="";
    search_by.p_from_appl_user_id.disabled= true;
	search_by.from_user_id.disabled= true;
	search_by.p_to_appl_user_id.disabled= true;
	search_by.to_user_id.disabled= true;

    search_by.p_fm_practitioner_id.value="";
	search_by.p_to_practitioner_id.value="";
	search_by.p_fm_practitioner_id.disabled= true;
	search_by.fm_practitioner.disabled= true;
	search_by.p_to_practitioner_id.disabled= true;
	search_by.to_practitioner.disabled= true;

	search_by.p_fm_staff_id.disabled= false;
	search_by.from_staff_id.disabled= false;
	search_by.p_to_staff_id.disabled= false;
	search_by.to_staff_id.disabled= false;



	}

	}

	













	


