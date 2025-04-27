function reset() 
{ 
	f_query_add_mod.document.location.reload();
}


function run() 
{
  var repApptReservationForm= f_query_add_mod.document.repApptReservationForm;
  if(repApptReservationForm)
  {
    var fields = new Array( repApptReservationForm.p_fm_appt_date,repApptReservationForm.p_to_appt_date,repApptReservationForm.p_staff_type);
    var names = new Array((getLabel("eOA.ApptDateFrom.label","OA")), (getLabel("eOA.ApptDateTo.label","OA")), (getLabel("Common.StaffType.label","Common")));

    if(repApptReservationForm.p_staff_type.value=='A')
    {
      var fields = new Array (repApptReservationForm.p_fm_appt_date,repApptReservationForm.p_to_appt_date,repApptReservationForm.p_staff_type,repApptReservationForm.p_oth_staff_type);
      var names = new Array((getLabel("eOA.ApptDateFrom.label","OA")), (getLabel("eOA.ApptDateTo.label","OA")), (getLabel("Common.StaffType.label","Common")), (getLabel("Common.OtherStaffType.label","Common")));
    }

    else
	{
      var fields = new Array( repApptReservationForm.p_fm_appt_date,repApptReservationForm.p_to_appt_date,repApptReservationForm.p_staff_type);
      var names = new Array((getLabel("eOA.ApptDateFrom.label","OA")), (getLabel("eOA.ApptDateTo.label","OA")), (getLabel("Common.StaffType.label","Common")));
	}
  if(f_query_add_mod.checkFields( fields, names, messageFrame))
  {
	  f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
	  f_query_add_mod.document.forms[0].target="messageFrame"
      repApptReservationForm.submit() ;
   }
 }
}


  function OthStaffType(obj1,oth_staff_type,p_oth_staff_type,oth_label,oth_mand)
  {

   if(obj1.value=="A")
	{ 
      oth_staff_type.style.visibility	  =	  "visible";
	  p_oth_staff_type.style.visibility	  =	  "visible";
	  oth_label.style.visibility	      =	  "visible";
	  oth_mand.style.visibility	          =	  "visible";
    }
	else 
    {   
	  p_oth_staff_type.value ="";
	  oth_staff_type.style.visibility	  =	  "hidden";
	  p_oth_staff_type.style.visibility   =	  "hidden";
	  oth_label.style.visibility	      =	  "hidden";
	  oth_mand.style.visibility        	  =	  "hidden";
	 
    }
   }				
		               


function reporttypeselec(obj2,user_label,user_text,user_button,orderby_label,orderby_opt)
{
 if(obj2.value=='D')
	{ 
     
	 user_label.style.visibility	    =	"visible";
	 user_text.style.visibility	        =	"visible";
	 user_button.style.visibility	    =	"visible";
	 orderby_label.style.visibility	    =	"visible";
	 orderby_opt.style.visibility	    =	"visible";
     }
    else
    { 
	 user_text.value ="";
	 orderby_opt.value ="";
	 user_label.style.visibility	    =	"hidden";
	 user_text.style.visibility	        =	"hidden";
	 user_button.style.visibility	    =	"hidden";
	 orderby_label.style.visibility	    =	"hidden";
	 orderby_opt.style.visibility	    =	"hidden";
     }
 }

  function reportopt(obj3)
	{
      var report=obj3.value;
	  if(report=='D')
      document.forms[0].p_report_id.value="OAAPTRED";
	  else
	  document.forms[0].p_report_id.value="OAAPTRES";
   }



  async function searchCode(obj,target,func)
  {
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	var sql="";
	var func=document.forms[0].p_staff_type.value;

	if(obj.name=="rep_facility1")
	{
		tit=getLabel("Common.facility.label","Common");	
		sql="select facility_id code,facility_name description from sm_facility_param where upper(facility_id) like upper(nvl(?,facility_id)) and upper(facility_name) like upper(nvl(?,facility_name)) order by 2";	
				
	}

	if(obj.name=="oth_staff_type")
	{
		tit=getLabel("Common.OtherStaffType.label","Common");	
		sql="select other_staff_type code,short_desc description from am_other_staff_type where upper(other_staff_type) like upper(nvl(?,other_staff_type)) and upper(short_desc) like upper(nvl(?,short_desc)) and eff_status='E' order by 2";	
				
	}

    if(obj.name=="p_sm_user" && func=='') 
	{			
		tit=encodeURIComponent(getLabel('Common.user.label','Common'));
		sql="select APPL_USER_ID code,APPL_USER_NAME description from sm_appl_user where upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) and eff_status='E' order by 2";
	}

    else if(obj.name=="p_sm_user" && func=='A') 
	{			
		tit=encodeURIComponent(getLabel('Common.user.label','Common'));
		sql="select APPL_USER_ID code,APPL_USER_NAME description from sm_appl_user where upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) and func_role='O' and eff_status='E' order by 2";
	}
	
	else if(obj.name=="p_sm_user" && func=='B')
	{
		tit=encodeURIComponent(getLabel('Common.user.label','Common'));
		sql="select APPL_USER_ID code,APPL_USER_NAME description from sm_appl_user where upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) and func_role='P' and eff_status='E' order by 2";
				
	}
				
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK ;
			argumentArray[7] = CODE_DESC ;
				
			var retVal=await CommonLookup(tit,argumentArray);
			var ret1=unescape(retVal);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	        if(retVal==null || retVal=="")
	        target.value="";
	        else
	        target.value=arr[0];
		
	}

	
	function DateCompare_apply(from,to)
	{
	  if(from.value!="" && to.value!="" )
	  {
		var max_days=daysBetween(from.value,to.value,"DMY");
		if(max_days>=31) 
		{
			alert(getMessage("DATE_CHECK","Common"));	
			to.value="";
			to.select();
			return false;
		}
		else
		{
			return true;
		}
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


function ValidateDate(obj4)
	{
	if(obj4.value!="")
	{
	if(!validDateObj(obj4,"DMY",localeName))
		{
			obj4.value="";
			return ;
		}
	}
}
