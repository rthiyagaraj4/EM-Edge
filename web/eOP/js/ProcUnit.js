var valser="";
var fn_status="";
function create() {
    f_query_add_mod.location.href = "../../eOP/jsp/AddClinicResource.jsp?function_id="+document.forms[0].function_id.value+"&call_func=ProcedureUnit" ;
}

 
function edit() {
    formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
    f_query_add_mod.location.href ="../../eOP/jsp/queryProcUnitPage.jsp?function_id="+document.forms[0].function_id.value+"&function=ProcedureUnit" ;
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

// This function is for the apply button when the form is submitted to the servlet
function apply()
{
	var i = 9;

if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
var isAlertApplicableforBookAppt = f_query_add_mod.clinic_sub.document.getElementById("isAlertApplicableforBookAppt").value; // added by mujafar for GHL-CRF-0527
 var fields = new Array ( f_query_add_mod.clinic_main.document.clinic_main_resource_form.clinic_code,
                f_query_add_mod.clinic_main.document.clinic_main_resource_form.long_desc,
                f_query_add_mod.clinic_main.document.clinic_main_resource_form.short_desc,
                f_query_add_mod.clinic_main.document.clinic_main_resource_form.clinic_type,
                f_query_add_mod.clinic_sub.document.clinic_resource_form.department,
                f_query_add_mod.clinic_sub.document.clinic_resource_form.speciality,
                f_query_add_mod.clinic_sub.document.clinic_resource_form.service,
				f_query_add_mod.clinic_sub.document.clinic_resource_form.primary_res_class,
                f_query_add_mod.clinic_sub.document.clinic_resource_form.ident_at_checkin
                );

    var names = new Array ( getLabel("Common.code.label","Common"),
                getLabel("Common.longdescription.label","Common"),
                getLabel("Common.shortdescription.label","Common"),
                getLabel("Common.type.label","Common"),
                getLabel("Common.acctdept.label","Common"),
                getLabel("Common.speciality.label","Common"),
                getLabel("Common.service.label","Common"),
				getLabel('eOP.PrimaryResourceClass.label','OP'),
                getLabel('eOP.CheckinIdentification.label','OP')
                  );
	if(isAlertApplicableforBookAppt=="true") // added by mujafar for GHL-CRF-0527
	{
	 var alert_req_book_appt_yn = f_query_add_mod.clinic_main.document.getElementById("alert_req_book_appt_yn").value;
	 if(alert_req_book_appt_yn == 'Y')
	 {
		var popup_desc = f_query_add_mod.clinic_main.document.getElementById("popup_desc").value; 
		if(popup_desc == "")
		{
			fields[i]=f_query_add_mod.clinic_main.document.clinic_main_resource_form.popup_desc;
			names[i]=getLabel("Common.Alert.label",'Common')+" "+getLabel("Common.popup.label",'Common')+" "+getLabel("Common.description.label",'Common');
			i = i+1;
		}
	 }
	}				  
	 if(f_query_add_mod.clinic_main.document.clinic_main_resource_form.isSlotStartMidEndAppl.value == "true")
	 {
		 if(f_query_add_mod.clinic_main.document.clinic_main_resource_form.clinic_type_sub){
			f_query_add_mod.clinic_sub.document.clinic_resource_form.clinic_type_sub.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.clinic_type_sub.value;
  		 }
	 }
//Added by Ajay H. for MMS-DM-CRF-0209.4
if(f_query_add_mod.clinic_main.document.getElementById("isClinicCategory").value == 'true'){
var categoryYN  = f_query_add_mod.clinic_main.document.getElementById("categoryYN").value;
	var categoryMandYN  = f_query_add_mod.clinic_main.document.getElementById("categoryMand").value;

	if(categoryMandYN == "Y"){
		fields[i]=f_query_add_mod.clinic_main.document.clinic_main_resource_form.CATEGORY;
			names[i]=getLabel("Common.category1.label",'Common');		
	}	
}

/*f_query_add_mod.clinic_sub.document.clinic_resource_form.disp_in_ca_queue_after.disabled=false;
f_query_add_mod.clinic_sub.document.clinic_resource_form.primary_res_class.disabled=false;
f_query_add_mod.clinic_sub.document.clinic_resource_form.primary_res_type.disabled=false;
f_query_add_mod.clinic_sub.document.clinic_resource_form.level_of_care.disabled=false;*/

if(f_query_add_mod.clinic_sub.document.getElementById("function_name").value == "insert")
{
	f_query_add_mod.clinic_sub.document.clinic_resource_form.ident_at_checkin.disabled=false;
	f_query_add_mod.clinic_sub.document.clinic_resource_form.primary_res_class.disabled=false;
	f_query_add_mod.clinic_sub.document.clinic_resource_form.primary_res_type.disabled=false;
}

var sttime=f_query_add_mod.clinic_sub.document.clinic_resource_form.start_time.value;
var edtime=f_query_add_mod.clinic_sub.document.clinic_resource_form.end_time.value;
	if(sttime != "" && edtime != "")	
	{	
		if( isAfter(sttime,edtime,"HM",localeName) == true )		
		{
			var errors = getMessage("ED_TIME_LESS_EQL_ST_TIME","OP");			
			f_query_add_mod.clinic_sub.document.clinic_resource_form.end_time.select();			
		
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
		}		
		
		if(f_query_add_mod.clinic_sub.document.clinic_resource_form.base_slot_slab_time.value != "")
		{
					var dt=new Date();
					var fromarray= sttime.split(":") ;
					var toarray  = edtime.split(":") ;
					var fromtime = new Date(dt.getFullYear(),dt.getMonth(),dt.getDate(),fromarray[0],fromarray[1],0,0) ;
					var totime   = new Date(dt.getFullYear(),dt.getMonth(),dt.getDate(),toarray[0],toarray[1],0,0) ;
					var aa=Date.parse(fromtime);
					var bb=Date.parse(totime);
					var cc=bb-aa;
					
					var slottime=f_query_add_mod.clinic_sub.document.clinic_resource_form.base_slot_slab_time.value;
					var slotarray=slottime.split(":");
					var givenHours= (slotarray[0]).valueOf();
					var givenMinites=(slotarray[1]).valueOf();
					var givenHourMilli=(givenHours*60*60*1000);
					var givenMiniMilli=(givenMinites*60*1000);
					var givenMilliSec=(givenHourMilli+givenMiniMilli);		
				
					if(givenMilliSec==0)
					{   
						var errors=getMessage('BASE_SLOT_TIME_FOR_ZERO','COMMON');						
						f_query_add_mod.clinic_sub.document.clinic_resource_form.base_slot_slab_time.select();				
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors ;
						return false;			
					}

					var modu=cc%givenMilliSec;
					if(modu>0)
					{
					   var errors=getMessage('BSE_SLT_SHD_BE_MUITPLE','OP');
						f_query_add_mod.clinic_sub.document.clinic_resource_form.base_slot_slab_time.select();		
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors ;
						return false;
						
					}
				
				
		}		
	}
var error_page = "../../eCommon/jsp/error.jsp";
 if(f_query_add_mod.clinic_sub.checkFields( fields, names, messageFrame)) 
	{
	 
		f_query_add_mod.clinic_sub.document.clinic_resource_form.clinic_code.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.clinic_code.value;
		f_query_add_mod.clinic_sub.document.clinic_resource_form.long_desc.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.long_desc.value;
		f_query_add_mod.clinic_sub.document.clinic_resource_form.short_desc.value =  f_query_add_mod.clinic_main.document.clinic_main_resource_form.short_desc.value;
		 f_query_add_mod.clinic_sub.document.clinic_resource_form.clinic_type.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.clinic_type.value;
		
			 f_query_add_mod.clinic_sub.document.clinic_resource_form.eff_status.value =    f_query_add_mod.clinic_main.document.clinic_main_resource_form.eff_status.value;
			f_query_add_mod.clinic_sub.document.clinic_resource_form.eff_status.checked = f_query_add_mod.clinic_main.document.clinic_main_resource_form.eff_status.checked;

		f_query_add_mod.clinic_sub.document.clinic_resource_form.physical_locn.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.physical_locn.value;
		f_query_add_mod.clinic_sub.document.clinic_resource_form.rd_appl_yn.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.rd_appl_yn.value;
		
		var centralValue=f_query_add_mod.clinic_sub.document.getElementById("centralValue").value;
		f_query_add_mod.clinic_sub.document.clinic_resource_form.isAlertApplicableforBookAppt.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.isAlertApplicableforBookAppt.value; // added by mujafar for GHL-CRF-0527
		if(f_query_add_mod.clinic_sub.document.clinic_resource_form.isAlertApplicableforBookAppt.value=="true")
		{
		f_query_add_mod.clinic_sub.document.clinic_resource_form.popup_desc.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.popup_desc.value;
		f_query_add_mod.clinic_sub.document.clinic_resource_form.alert_req_book_appt_yn.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.alert_req_book_appt_yn.value;
		}
		// Added by Ajay for MMS-DM-CRF-0209.4
				  if(f_query_add_mod.clinic_main.document.getElementById("isClinicCategory").value == 'true'){
		if(categoryYN=="Y"){
		  f_query_add_mod.clinic_sub.document.clinic_resource_form.CATEGORY.value = f_query_add_mod.clinic_main.document.clinic_main_resource_form.CATEGORY.value;
		}
				  }
		
		if(f_query_add_mod.clinic_sub.document.getElementById("function_name").value == "modify")
		{
			
				 var HTMLVal = new String();
				  var mrsecttype="";

				  if(f_query_add_mod.clinic_sub.document.getElementById("mr_section_type").disabled == false)
					{

					mrsecttype=f_query_add_mod.clinic_sub.document.getElementById("mr_section_type").value ;
					}
					f_query_add_mod.clinic_sub.document.clinic_resource_form.disp_in_ca_queue_after.disabled=false;
f_query_add_mod.clinic_sub.document.clinic_resource_form.primary_res_class.disabled=false;
f_query_add_mod.clinic_sub.document.clinic_resource_form.primary_res_type.disabled=false;
f_query_add_mod.clinic_sub.document.clinic_resource_form.level_of_care.disabled=false;
f_query_add_mod.clinic_sub.document.clinic_resource_form.ident_at_checkin.disabled=false;

				//Added for the CRF - Bru-HIMS-CRF-0198 -- start
				if(f_query_add_mod.clinic_sub.document.getElementById("multi_speciality_yn").value=='Y'){
					 f_query_add_mod.clinic_sub.document.clinic_resource_form.primary_res_class.disabled=false;
					 f_query_add_mod.clinic_sub.document.clinic_resource_form.speciality.disabled=false;						 
				}
				//Added for the CRF - Bru-HIMS-CRF-0198 -- End

				 HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey();'><form name='formloc' id='formloc' method='post' action='../../eOP/jsp/CheckFSLocationResource.jsp'><input name='mr_location_code' id='mr_location_code' type='hidden' value='"+f_query_add_mod.clinic_sub.document.getElementById("mr_location_code").value + "'><input name='mr_section_type' id='mr_section_type' type='hidden' value='"+mrsecttype+ "'><input name='centralValue' id='centralValue' type='hidden' value='"+centralValue + "'></form></BODY></HTML>";
					 
				 messageFrame.document.write(HTMLVal);	
				 messageFrame.document.formloc.submit();		
			
		}	
		else
		{ 
			
			    var field = new Array ( f_query_add_mod.clinic_main.document.clinic_main_resource_form.clinic_code );	
			    var name = new Array ( getLabel("Common.code.label","Common") );
				if (f_query_add_mod.clinic_sub.SpecialCharCheck (field,name,messageFrame,'M',error_page))
				{		
					
					 var HTMLVal = new String();
					  var mrsecttype="";

					 if(f_query_add_mod.clinic_sub.document.getElementById("mr_section_type").disabled == false)
					{

					mrsecttype=f_query_add_mod.clinic_sub.document.getElementById("mr_section_type").value ;
					}
					 HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey();'><form name='formloc' id='formloc' method='post' action='../../eOP/jsp/CheckFSLocationResource.jsp'><input name='mr_location_code' id='mr_location_code' type='hidden' value='"+f_query_add_mod.clinic_sub.document.getElementById("mr_location_code").value + "'><input name='mr_section_type' id='mr_section_type' type='hidden' value='"+mrsecttype+ "'><input name='centralValue' id='centralValue' type='hidden' value='"+centralValue + "'></form></BODY></HTML>";
					 messageFrame.document.write(HTMLVal);			
					 messageFrame.document.formloc.submit();
				
				
					
				}
		}
		fn_status = f_query_add_mod.clinic_sub.document.getElementById("function_name").value ;
	  
    }
}


// After the insertion and modification is carried out the following function is called from the servlet to reload the initial page.This happens only in case of insert mode.
function onSuccess() {     
		f_query_add_mod.location.reload() ; 
}

function reset()
{
	if(f_query_add_mod.location.href.indexOf("queryProcUnit.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;

		
}
// The clearlist function is used to clear the existing values ina drop down. This function is called when certain dropdowns are populated depending on certain other fields dynamically through an intermediate jsp.
function clearlist(obj)
{
	if(obj.name=="department")
	{
		
		var length  =parent.frames[1].document.forms[0].section.length;	
		
		for(i=1;i<length;i++)
		{
		  parent.frames[1].document.forms[0].section.remove(1);
		}

		length=parent.frames[1].document.forms[0].service.length;
		for(i=1;i<length;i++)
		{
		  parent.frames[1].document.forms[0].service.remove(1);
		}
	}
	else if(obj.name == "mr_section_type")
	{			
		var length  =parent.frames[1].document.forms[0].mr_location_code.length;	
		var length1= parent.frames[1].document.forms[0].mr_section.length;	
		for(i=0;i<length1;i++)
		{
			parent.frames[1].document.forms[0].mr_section.remove(1);
		}
		for(i=0;i<length;i++)
		{
		  parent.frames[1].document.forms[0].mr_location_code.remove(1);
		}	
		
	}else if(obj.name=="level_of_care")
	{
     var length=parent.frames[1].document.forms[0].dflt_file_type.length;
		 for(i=0;i<length;i++)
		{
			 parent.frames[1].document.forms[0].dflt_file_type.remove(1);
		}
	}
	else if(obj.name=="mr_location_code")
	{
         var length=parent.frames[1].document.forms[0].dflt_file_type.length;
		 for(i=0;i<length;i++)
		{
			 parent.frames[1].document.forms[0].dflt_file_type.remove(1);
		}

	}

	else if(obj.name == "speciality")
	{	
		  parent.frames[1].document.forms[0].vitalsignsb.item(0).selected = true;			
		  parent.frames[1].document.forms[0].multi_speciality_yn.value = 'N';	
		  parent.frames[1].document.forms[0].primary_res_class.disabled=false;
		  parent.frames[1].document.forms[0].primary_res_class.item(0).selected = true;

	}
	else if(obj.name == "primary_res_class")
	{
		var length  =parent.frames[1].document.forms[0].primary_res_type.length;	
		
		for(i=1;i<length;i++)
		{
		  parent.frames[1].document.forms[0].primary_res_type.remove(1);
		}
	}
}
//This variable is let to show that by default on load Arrived tab is enabled.
var currentTab = new String();
currentTab = "char_tab";

// This function is used for calling the function for changing the tab img displays and also the function for corresponding page displays for that particular tab.
function tab_click(objName)
{	
	selectTab(objName)
	if (objName == "char_tab")
	{		
		 //changeTab(objName);
		 moveToTab(1);
	}
	else if(objName == "others_tab")
	{		
		//changeTab(objName);		
		moveToTab(2);
	}
	else if(objName == "patinstructions_tab")
	{	
		moveToTab(3);
	}
}
// function to change the tab display images according to functionality.
function changeTab(TabName) 
{
	if(parent.frames[1].document.forms[0]){
	if (parent.frames[1].document.forms[0].ct_tab_name.value == "char_tab")
	{
		currentTab = parent.frames[1].document.forms[0].ct_tab_name.value;
		parent.frames[1].document.forms[0].ct_tab_name.value = "";
	}
	}

	// RESET THE OLD TAB WHICH IS SELECTED FIRST .............	
	if (currentTab == 'char_tab')
	{
		 if(parent.frames[0].document.forms[0])
		 parent.frames[0].document.forms[0].char_tab.src = '../images/Characteristics_click.gif';
	}
	 else if (currentTab == 'others_tab')
	{
		 if(parent.frames[0].document.forms[0])
		 parent.frames[0].document.forms[0].others_tab.src = '../images/Others_click.gif';
	}	
	 // CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............	 

	if (TabName == 'char_tab')
	{
		if(parent.frames[0].document.forms[0]){
		parent.frames[0].document.forms[0].char_tab.src = '../images/Characteristics.gif';
		parent.frames[0].document.forms[0].char_tab.disabled = true;
	    }
	}
	else if (TabName == 'others_tab')
	{
		if(parent.frames[0].document.forms[0]){
		parent.frames[0].document.forms[0].others_tab.src = '../images/Others.gif';
		parent.frames[0].document.forms[0].others_tab.disabled = true;
	    }
	}

	// FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
	currentTab = TabName;
}

function moveToTab(TabIndex) {
	
	if(parent.frames[1].document.forms[0])
	   fn_status = parent.frames[1].document.getElementById("function_name").value ;
	

	if ( TabIndex == 1 )
	{      
		if(parent.frames[0].document.getElementById("isAlertApplicableforBookAppt").value=="true"){
		//parent.parent.frames[1].pat_frame.rows="165,*,0";  // from 130 to 165 modified by mujafar for GHL-CRF-0527 //this line modified for this incident  [IN:038056] 
		parent.parent.frames[1].document.getElementById("clinic_main").style.height="25vh";
		parent.parent.frames[1].document.getElementById("clinic_sub").style.height="75vh";
		parent.parent.frames[1].document.getElementById("dummyframe").style.height="0vh";
		}
		else
		{
		//parent.parent.frames[1].pat_frame.rows="130,*,0";
		parent.parent.frames[1].document.getElementById("clinic_main").style.height="25vh";
		parent.parent.frames[1].document.getElementById("clinic_sub").style.height="75vh";
		parent.parent.frames[1].document.getElementById("dummyframe").style.height="0vh";
		}
		//if(parent.frames[1].document.forms[0])
		 // parent.frames[1].document.getElementById("chars").scrollIntoView();
		parent.frames[1].document.getElementById("chars_div").style.visibility='visible';
		parent.frames[1].document.getElementById("chars_div").style.display='';
		parent.frames[1].document.getElementById("others_div").style.visibility='hidden';
		parent.frames[1].document.getElementById("others_div").style.display='none';
		parent.frames[1].document.getElementById("pat_ins_div").style.visibility='hidden';
		parent.frames[1].document.getElementById("pat_ins_div").style.display='none';


		if(parent.frames[0].document.forms[0]){
		if((fn_status =="modify" && parent.frames[0].document.forms[0].eff_status.value !="D") || (fn_status == "insert" && parent.frames[1].document.getElementById("working_week_1_day_1").disabled == false))
		{
			if(parent.frames[1].document.getElementById("working_weeks_appt1"))
				parent.frames[1].document.getElementById("working_weeks_appt1").focus();
		}
		}
	}
	else if ( TabIndex == 2 )
	{		
		if(parent.frames[0].document.getElementById("isAlertApplicableforBookAppt").value=="true"){
		//parent.parent.frames[1].pat_frame.rows="165,*,0";  // from 130 to 165 modified by mujafar for GHL-CRF-0527 //this line modified for this incident  [IN:038056]
		parent.parent.frames[1].document.getElementById("clinic_main").style.height="25vh";
		parent.parent.frames[1].document.getElementById("clinic_sub").style.height="75vh";
		parent.parent.frames[1].document.getElementById("dummyframe").style.height="0vh";
		}
		else{
		//parent.parent.frames[1].pat_frame.rows="130,*,0";
		parent.parent.frames[1].document.getElementById("clinic_main").style.height="25vh";
		parent.parent.frames[1].document.getElementById("clinic_sub").style.height="75vh";
		parent.parent.frames[1].document.getElementById("dummyframe").style.height="0vh";
		}
    	//if(parent.frames[1].document.forms[0])
			//parent.frames[1].document.getElementById("others").scrollIntoView();
		parent.frames[1].document.getElementById("chars_div").style.visibility='hidden';
		parent.frames[1].document.getElementById("chars_div").style.display='none';
		parent.frames[1].document.getElementById("others_div").style.visibility='visible';
		parent.frames[1].document.getElementById("others_div").style.display='';
		parent.frames[1].document.getElementById("pat_ins_div").style.visibility='hidden';
		parent.frames[1].document.getElementById("pat_ins_div").style.display='none';

		if(parent.frames[0].document.forms[0]){
		if((fn_status =="modify" && parent.frames[0].document.forms[0].eff_status.value !="D") || (fn_status == "insert"))
		{
			if(parent.frames[1].document.getElementById("speciality") && parent.frames[1].document.getElementById("speciality").disabled==false)//modified for the CRF - Bru-HIMS-CRF-0198
				parent.frames[1].document.getElementById("speciality").focus();
		}
		}
	}
	else
	{  
	  if(parent.frames[0].document.getElementById("isAlertApplicableforBookAppt").value=="true"){
	  //parent.parent.frames[1].pat_frame.rows="27%,10%,*"; // from 21 to 27 modified by mujafar for GHL-CRF-0527 //this line Modified for this incident  [IN:038056]
	  parent.parent.frames[1].document.getElementById("clinic_main").style.height="25vh";
	  parent.parent.frames[1].document.getElementById("clinic_sub").style.height="75vh";
	  parent.parent.frames[1].document.getElementById("dummyframe").style.height="0vh";
	  }
	  else{
	  //parent.parent.frames[1].pat_frame.rows="21%,10%,*";
	  parent.parent.frames[1].document.getElementById("clinic_main").style.height="25vh";
	  parent.parent.frames[1].document.getElementById("clinic_sub").style.height="75vh";
	  parent.parent.frames[1].document.getElementById("dummyframe").style.height="0vh";
	  }
      if(parent.frames[1].document.forms[0]){			
				//parent.frames[1].document.getElementById("pat_instructions").scrollIntoView();	
		parent.frames[1].document.getElementById("chars_div").style.visibility='hidden';
		parent.frames[1].document.getElementById("chars_div").style.display='none';
		parent.frames[1].document.getElementById("others_div").style.visibility='hidden';
		parent.frames[1].document.getElementById("others_div").style.display='none';
		parent.frames[1].document.getElementById("pat_ins_div").style.visibility='visible';
		parent.frames[1].document.getElementById("pat_ins_div").style.display='';
		parent.frames[1].document.forms[0].serial_no.focus();
	  }
	}
}


// JS functions used in ClinicMain resource.jsp..

function assignvalspec(obj)
	{
		
		if(obj.checked==true)
		{
			if(obj.name=="eff_status")
			{
				 obj.value="E";
			}
			else
			{
				if(parent.frames[0].document.forms[0])
				{
		      parent.frames[0].document.forms[0].specialist_clinic.value="Y";
			  parent.frames[0].document.forms[0].specialist_clinic_yn.value="Y";
				}
			}
	     }else if(obj.checked==false)
		{
			  if(obj.name=="eff_status")
				  obj.value="D";
			  else
			{
				 if(parent.frames[0].document.forms[0])
				  {
				  parent.frames[0].document.forms[0].specialist_clinic.value="N";
			      parent.frames[0].document.forms[0].specialist_clinic_yn.value="N";
				  }
			}
		}
	  
	}
 function setfocus()
	 {
		 if(parent.frames[0].document.forms[0])
		 {
			 if(parent.frames[0].document.forms[0].clinic_code.readOnly==false)
			     parent.frames[0].document.forms[0].clinic_code.focus();
	     }
	 }
// JS functions used in AddModifyClinicResource.jsp

function assigndays(obj)
	{
	if(obj.checked == true)
		{
			obj.value = "W";
			eval("parent.frames[1].document.forms[0]."+obj.name+"1").value="W";	
		}
		else
		{
			obj.value="N";
			eval("parent.frames[1].document.forms[0]."+obj.name+"1").value="N";	
				
		for(i=1;i<=5;i++)
		{
			for(j=1;j<=7;j++)
			{
				if (obj.name=="working_week_"+i+"_day_"+j)
				{	
					if(parent.frames[1].document.forms[0].function_name.value=="modify")
					{
					var cliniccode=parent.frames[0].document.forms[0].clinic_code.value;
					var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='polsecserv' id='polsecserv' method='post' action='../../eOP/jsp/GetValResource.jsp'>";
					HTMLVal+="<input type='hidden' name='pract_obj' id='pract_obj' value='"+obj.name+"'>";
					HTMLVal+="<input type='hidden' name='toPopulatefs' id='toPopulatefs' value='pract_check'>";
					HTMLVal+="<input type='hidden' name='cliniccode' id='cliniccode' value='"+cliniccode+"'>";
					HTMLVal+= "</form></body></html>";
					parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.parent.messageFrame.polsecserv.submit();
					}

			/*	if (eval("parent.frames[1].document.forms[0].pract_working_week"+i+"_day"+j).value=="W")
					{
					 alert(getMessage('PRACT_WORKING_CAN_NOT_UNCHECK'));
					 obj.checked =true;
					 obj.value   = "Y";					
					eval("parent.frames[1].document.forms[0]."+obj.name+"1").value="W";
					}*/
				}						
			}
		}			
	}			
		     
	}
function checkuncheck(obj,svalue)
		{
			var j;
			var selval=obj.value;
			var selname=obj.name;
			var str=selname.substring(10,11);
          if(selval=="A")
			{
			for(i=1;i<=5;i++)
				{
			eval("parent.frames[1].document.forms[0].working_week_"+i+"_day_"+svalue).checked=true;
			eval("parent.frames[1].document.forms[0].working_week_"+i+"_day_"+svalue+"1").value="W";	
				}
			}else if(selval="W")
			{				
				if(parent.frames[1].document.forms[0].function_name.value=="modify")
				{
				var cliniccode=parent.frames[0].document.forms[0].clinic_code.value;
				var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='polsecserv' id='polsecserv' method='post' action='../../eOP/jsp/GetValResource.jsp'>";
				HTMLVal+="<input type='hidden' name='pract_obj' id='pract_obj' value='"+svalue+"'>";
				HTMLVal+="<input type='hidden' name='toPopulatefs' id='toPopulatefs' value='pract_check1'>";
				HTMLVal+="<input type='hidden' name='cliniccode' id='cliniccode' value='"+cliniccode+"'>";
				HTMLVal+= "</form></body></html>";
				parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.parent.messageFrame.polsecserv.submit();
				}else
				{
				for(i=1;i<=5;i++)
				{	eval("parent.frames[1].document.forms[0].working_week_"+i+"_day_"+svalue).checked=false;
				eval("parent.frames[1].document.forms[0].working_week_"+i+"_day_"+svalue+"1").value="N";
				}
				}
		 	 /* for(i=1;i<=5;i++)
				{
			if(eval("parent.frames[1].document.forms[0].pract_working_week"+i+"_day"+svalue).value=="W")
				{
			  eval("parent.frames[1].document.forms[0].working_week_"+i+"_day_"+svalue).checked=true;
			  eval("parent.frames[1].document.forms[0].working_week_"+i+"_day_"+svalue+"1").value="W";
				}
				else
				{
			eval("parent.frames[1].document.forms[0].working_week_"+i+"_day_"+svalue).checked=false;
			eval("parent.frames[1].document.forms[0].working_week_"+i+"_day_"+svalue+"1").value="N";	
				}
				}*/
		}
} 

/*function chkGrtrTime(obj,fld)
{
	
	if(document.forms[0].start_time.value != "" && document.forms[0].end_time.value != "")	
	{		
		
		var sttime=document.forms[0].start_time.value;
		var edtime=document.forms[0].end_time.value;
						
		if( isBefore(sttime,edtime,"HM",localeName) == false )
		{
			var errors = getMessage("ED_TIME_LESS_EQL_ST_TIME","OP");			
			alert(errors);
			document.forms[0].end_time.select();			
			return false;
		}

		if(document.forms[0].base_slot_slab_time.value != "")
		{
					var sttime=document.forms[0].start_time.value;
					var edtime=document.forms[0].end_time.value;
					var dt=new Date();
					var fromarray= sttime.split(":") ;
					var toarray  = edtime.split(":") ;
					var fromtime = new Date(dt.getFullYear(),dt.getMonth(),dt.getDate(),fromarray[0],fromarray[1],0,0) ;
					var totime   = new Date(dt.getFullYear(),dt.getMonth(),dt.getDate(),toarray[0],toarray[1],0,0) ;
					var aa=Date.parse(fromtime);
					var bb=Date.parse(totime);
					var cc=bb-aa;
					
					var slottime=document.forms[0].base_slot_slab_time.value;
					var slotarray=slottime.split(":");
					var givenHours= (slotarray[0]).valueOf();
					var givenMinites=(slotarray[1]).valueOf();
					var givenHourMilli=(givenHours*60*60*1000);
					var givenMiniMilli=(givenMinites*60*1000);
					var givenMilliSec=(givenHourMilli+givenMiniMilli);		
				
					if(givenMilliSec==0)
					{   
						var msg=getMessage('BASE_SLOT_TIME_FOR_ZERO','COMMON');
						alert(msg);
						document.forms[0].base_slot_slab_time.select();				
						return false;							
					}

					var modu=cc%givenMilliSec;
					if(modu>0)
					{
					   alert(getMessage('BSE_SLT_SHD_BE_MUITPLE','OP'));
						document.forms[0].base_slot_slab_time.select();			
						return false;
					}
				
		}		
	}	
}*/

function CheckTime(obj,fld)
{
			
		var timefield 	= obj;
		if (obj.value!="")
		{
			
			if (!(validDate(obj.value,"HM",localeName)&&checkColon(obj.value)))
			{		
				var errors = getMessage("INVALID_TIME_FMT","SM");
				alert(errors);
				obj.value='';	// Thursday, March 25, 2010 20280	
				//obj.select();				
				return false;				
			}	
			
		}
}
		/*function CheckTime(obj,fld)
		{
			
			var timefield 	= obj;
			if (obj.value!="")
			{
				var flag=true;					
				if (!(validDate(obj.value,"HM",localeName)&&checkColon(obj.value))) {		
					var errors = getMessage("INVALID_TIME_FMT","SM");
					alert(errors);
					obj.select();
					obj.focus();
					flag=false;
					}
			  if(flag)
				{
				  if(fld == 'E')
			       {
				var sttime=document.forms[0].start_time.value;
				var edtime=document.forms[0].end_time.value;
				
				var fromarray= sttime.split(":") ;
				var toarray  = edtime.split(":") ;

				var fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
				var totime   = new Date(1,1,1,toarray[0],toarray[1],0,0) ;

				if(fromtime >= totime)
				{
					var errors = getMessage("ED_TIME_LESS_EQL_ST_TIME","OP");
					status1 = 'Y' ;
					alert(errors);
					obj.focus();
				}
			}
				if(fld=="SL")
			{
			var sttime=document.forms[0].start_time.value;
			var edtime=document.forms[0].end_time.value;
			var dt=new Date();
			var fromarray= sttime.split(":") ;
			var toarray  = edtime.split(":") ;
			var fromtime = new Date(dt.getFullYear(),dt.getMonth(),dt.getDate(),fromarray[0],fromarray[1],0,0) ;
			var totime   = new Date(dt.getFullYear(),dt.getMonth(),dt.getDate(),toarray[0],toarray[1],0,0) ;
			var aa=Date.parse(fromtime);
			var bb=Date.parse(totime);
			var cc=bb-aa;
			
            var slottime=document.forms[0].base_slot_slab_time.value;
			var slotarray=slottime.split(":");
			var givenHours= (slotarray[0]).valueOf();
			var givenMinites=(slotarray[1]).valueOf();
			var givenHourMilli=(givenHours*60*60*1000);
			var givenMiniMilli=(givenMinites*60*1000);
			var givenMilliSec=(givenHourMilli+givenMiniMilli);		
		
			if(givenMilliSec==0)
					{   
				    var msg=getMessage('BASE_SLOT_TIME_FOR_ZERO','COMMON');
					alert(msg);
					obj.select();
					obj.focus();
				    
					}

			var modu=cc%givenMilliSec;
			if(modu>0)
				{
			      alert(getMessage("BSE_SLT_SHD_BE_MUITPLE","OP"));
                obj.select();
				obj.focus();
				}
			
			}
				}
			
			}
 }*/
function checkColon(dt)
 {
    var charAtpos3=dt.charAt(2);
    if(charAtpos3 == ':')
        return true;
	 else
        return false;
}

function assignval(obj)
		{
		var levelofcare=parent.frames[1].document.forms[0].level_of_care.value;
		if(obj.name != "eff_status")
		{
			var chkfunction=parent.frames[1].document.forms[0].call_function.value;
			if(obj.checked == true)
			{
				
				obj.value="Y";
				if(obj.name !=="diagnosis_not_mndt") //Added by Shanmukh for ML-MMOH-CRF-1007 on 19-APR-2018
				eval("parent.frames[1].document.forms[0]."+obj.name+"1").value="Y";	
				
				if(obj.name == "allow_walk_in_yn")
				{
					for(i=1;i<=7;i++)
					{
						eval("document.forms[0].max_walkin_for_day_"+i).readOnly=false;	
					}					
				}
			  
				if(obj.name == "allow_visit_regn_yn")
				{
					
					parent.frames[1].document.forms[0].allow_walk_in_yn.value='N';
					parent.frames[1].document.forms[0].allow_walk_in_yn1.value='N';
					parent.frames[1].document.forms[0].allow_walk_in_yn.disabled=false;			
			
					if(parent.frames[1].document.forms[0].level_of_care.value=='A'){
					 
					parent.frames[1].document.forms[0].allow_unassign_queue.disabled=false;
					parent.frames[1].document.forms[0].allow_unassign_queue1.value="N";
					parent.frames[1].document.forms[0].allow_unassign_queue.value="N";
					parent.frames[1].document.forms[0].allow_unassign_queue.checked=false;
					
					  parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;
				
					}else
					{
						
					parent.frames[1].document.forms[0].allow_unassign_queue.disabled=true;
					parent.frames[1].document.forms[0].allow_unassign_queue1.value="Y";
					parent.frames[1].document.forms[0].allow_unassign_queue.value="Y";
					parent.frames[1].document.forms[0].allow_unassign_queue.checked=true;
					}
					if(levelofcare != null && (levelofcare != "E"))
					{
						if(chkfunction=="Clinic"){
						parent.frames[1].document.forms[0].allow_appt_yn.value='N';
						parent.frames[1].document.forms[0].allow_appt_yn1.value='N';
						parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;
					    }else{
						if(parent.frames[1].document.forms[0].allow_appt_yn1.value=="Y")
						{
								
					     parent.frames[1].document.forms[0].allow_appt_yn.value='Y';
					     parent.frames[1].document.forms[0].allow_appt_yn1.value='Y';
					     parent.frames[1].document.forms[0].allow_appt_yn.checked=true;
					 	 }
						}

					}
					parent.frames[1].document.forms[0].allow_referral_yn.value='N';
					parent.frames[1].document.forms[0].allow_referral_yn1.value='N';
					parent.frames[1].document.forms[0].allow_referral_yn.disabled=false;

					parent.frames[1].document.forms[0].allow_non_referral_yn.value='N';
					parent.frames[1].document.forms[0].allow_non_referral_yn1.value='N';
					parent.frames[1].document.forms[0].allow_non_referral_yn.disabled=false;
					
				}
			}
			else
			{
				obj.value="N";
				if(obj.name !=="diagnosis_not_mndt") //Added by Shanmukh for ML-MMOH-CRF-1007 on 19-APR-2018
				eval("parent.frames[1].document.forms[0]."+obj.name+"1").value="N";	

				if(obj.name == "allow_walk_in_yn")
				{
					for(i=1;i<=7;i++)
					{
						eval("document.forms[0].max_walkin_for_day_"+i).readOnly=true;	
						eval("document.forms[0].max_walkin_for_day_"+i).value="";
					}					
				}

				if(obj.name == "allow_visit_regn_yn")
				{
					
					parent.frames[1].document.forms[0].allow_walk_in_yn.value='N';
					parent.frames[1].document.forms[0].allow_walk_in_yn1.value='N';
					parent.frames[1].document.forms[0].allow_walk_in_yn.checked=false;
					parent.frames[1].document.forms[0].allow_walk_in_yn.disabled=true;

					if(parent.frames[1].document.forms[0].level_of_care.value=='A'){
											
					parent.frames[1].document.forms[0].allow_unassign_queue.disabled=true;
					parent.frames[1].document.forms[0].allow_unassign_queue1.value="N";
					parent.frames[1].document.forms[0].allow_unassign_queue.value="N";
					parent.frames[1].document.forms[0].allow_unassign_queue.checked=false;
					}else{
											
					parent.frames[1].document.forms[0].allow_unassign_queue.disabled=true;
					parent.frames[1].document.forms[0].allow_unassign_queue1.value="Y";
					parent.frames[1].document.forms[0].allow_unassign_queue.value="Y";
					parent.frames[1].document.forms[0].allow_unassign_queue.checked=true;
					}
			         if(chkfunction=="Clinic"){
					parent.frames[1].document.forms[0].allow_appt_yn.value='N';
					parent.frames[1].document.forms[0].allow_appt_yn1.value='N';
					parent.frames[1].document.forms[0].allow_appt_yn.checked=false;
					parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
					 }else{
						 					
					if(parent.frames[1].document.forms[0].allow_appt_yn1.value=="Y")
						 {
										
					parent.frames[1].document.forms[0].allow_appt_yn.value='Y';
					parent.frames[1].document.forms[0].allow_appt_yn1.value='Y';
					parent.frames[1].document.forms[0].allow_appt_yn.checked=true;
						 }
					
					if(parent.frames[1].document.forms[0].level_of_care.value=='A')
					  parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;
					 }
					 					
					parent.frames[1].document.forms[0].allow_referral_yn.value='N';
					parent.frames[1].document.forms[0].allow_referral_yn1.value='N';
					parent.frames[1].document.forms[0].allow_referral_yn.checked=false;
					parent.frames[1].document.forms[0].allow_referral_yn.disabled=true;
					
					   parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;

					parent.frames[1].document.forms[0].allow_non_referral_yn.value='N';
					parent.frames[1].document.forms[0].allow_non_referral_yn1.value='N';
					parent.frames[1].document.forms[0].allow_non_referral_yn.checked=false;
					parent.frames[1].document.forms[0].allow_non_referral_yn.disabled=true;
					
				}
			}			
		}
		else 
		{
			if(obj.checked == true)
			{
				obj.value="E";
			}
			else
			{
				obj.value="D";
			}
		}
        if(obj.name == "allow_visit_regn_yn")
			{
			if(obj.checked==false)
				{
				parent.frames[1].document.forms[0].vitalsignsb.disabled=true;
				parent.frames[1].document.forms[0].disp_in_ca_queue_after.disabled=true;
				
				}
			else
				{
				parent.frames[1].document.forms[0].vitalsignsb.disabled=false;
				parent.frames[1].document.forms[0].disp_in_ca_queue_after.disabled=false;
				}
			}
	}

function GetValues(obj)
	{
		/*
			This function is called in following cases :
				1. When Acct department value changes,depending on it the drop down values for Section     and Service changes.
				2. When mr_section type value changes the mr section drop down enables and disables        accrodingly and values are changed.The auto file request checkbox also enables and      disables accordingly.
				3. When the speciality changes accordingly the corresponding value for Vital sign gets     selected from the existing drop down.

			An intermediate jsp called GetvalResource.jsp is used for the validations and this is carried out in the messageframe.
		*/
			
		//alert();
		var callfunction=parent.frames[1].document.forms[0].call_function.value;
		var levelofcare=parent.frames[1].document.forms[0].level_of_care.value;
		
		var centralValue=parent.frames[1].document.forms[0].centralValue.value;
	
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='polsecserv' id='polsecserv' method='post' action='../../eOP/jsp/GetValResource.jsp'>";
		if(obj.name == "department")
		{	
			clearlist(obj);
			HTMLVal+= "<input name='Common_Text' id='Common_Text' type='hidden' value='"+parent.frames[1].document.getElementById("department").value + "'><input name='sectionpop' id='sectionpop' type='hidden' value='sectionPop'>";
		}
		else if(obj.name == "mr_section_type")
		{
			clearlist(obj);
			var seperatefile=parent.frames[1].document.forms[0].SEPARATE_FILE_NO_YN.value;
			var sormid=parent.frames[1].document.forms[0].sormfiles.value;
			
			parent.frames[1].document.forms[0].mr_section.disabled=false;
			HTMLVal+= "<input name='sectionType' id='sectionType' type='hidden' value='"+obj.value + "'><input type='hidden' name='mrsectionName' id='mrsectionName' value='"+obj.name+"'><input name='centralValue' id='centralValue' type='hidden' value='"+centralValue+"'><input name='fminstall' id='fminstall' type='hidden' value='"+parent.frames[1].document.forms[0].fm_install.value+"'>";
			if(obj.value=="C"){
			if(seperatefile=="N" && sormid=="M"){
			HTMLVal+="<input type='hidden' name='seperatefile' id='seperatefile' value='"+seperatefile+"'><input type='hidden' name='sormfiles' id='sormfiles' value='"+sormid+"'>";
			}else{
			  parent.frames[1].document.forms[0].mr_section.disabled=true;
				}
			}
			
			if(parent.frames[1].document.getElementById("fm_install").value == "Y")
			{
				
				HTMLVal+="<input name='toPopulatefs' id='toPopulatefs' type='hidden' value='populatefs'> ";

				if (obj.value=="D")
				{   alert("ProcUnit 1001");
					parent.frames[1].document.getElementById("popUp").style.visibility='visible';
					parent.frames[1].document.forms[0].online_mr_notfn_yn.value="N";
					parent.frames[1].document.forms[0].online_mr_notfn_yn1.value="N";
					parent.frames[1].document.forms[0].online_mr_notfn_yn.disabled=true;
					parent.frames[1].document.forms[0].online_mr_notfn_yn.checked=false;
				}
				else
				{
							alert("ProcUnit 1010");
							parent.frames[1].document.getElementById("popUp").style.visibility='hidden';

							if(parent.frames[1].document.forms[0].create_file_yn.value=='Y')
								parent.frames[1].document.forms[0].online_mr_notfn_yn.disabled=false;	
							else
								parent.frames[1].document.forms[0].online_mr_notfn_yn.disabled=true;	
				}
			}
			
		}else if(obj.name=="mr_location_code")
		{
			var fm_installyn=parent.frames[1].document.forms[0].fm_install.value;
			clearlist(obj);

			HTMLVal+= "<input name='defaultlocn' id='defaultlocn' type='hidden' value='"+obj.value + "'><input name='toPopulatefs' id='toPopulatefs' type='hidden' value='populateDF'><input name='fminstall' id='fminstall' type='hidden' value='"+fm_installyn+ "'>";
		}
		else if(obj.name == "speciality")
		{
			clearlist(obj);
			HTMLVal+= "<input name='speciality' id='speciality' type='hidden' value='"+obj.value + "'><input name='toPopulatefs' id='toPopulatefs' type='hidden' value='populatevs'>";
		}
		else if(obj.name == "primary_res_class")
		{
		    clearlist(obj);
			HTMLVal+= "<input name='primary_res_class' id='primary_res_class' type='hidden' value='"+obj.value + "'><input name='toPopulatefs' id='toPopulatefs' type='hidden' value='populatept'>";
		}
		/*else if(obj.name == "other_res")
		{
			
			clearlist(obj);
			HTMLVal+= "<input name='oth_class' id='oth_class' type='hidden' value='"+obj.value+"'><input name='toPopulatefs' id='toPopulatefs' type='hidden' value='populateOther'>";
		}*/
			HTMLVal+="<input type='hidden' name='callfunction' id='callfunction' value='"+callfunction+"'>";
		    HTMLVal+="<input type='hidden' name='levelfcare' id='levelfcare' value='"+levelofcare+"'>";
		
          
		HTMLVal+= "</form></body></html>";

		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.polsecserv.submit();

	}

function dragdown(obj)
	{
		alert(getMessage("WELCOME","COMMON"));
	}
function getfocus(obj)
	{
		if(parent.frames[1].document.forms[0])
		{ 
			
		   //parent.frames[1].document.getElementById("chars").scrollIntoView();
		   parent.frames[1].document.getElementById("working_week_1_day_1").focus();
	    }
	}
function setfocus()
	 {
		 if(parent.frames[0].document.forms[0])
		 {
			 if(parent.frames[0].document.forms[0].clinic_code.readOnly==false)
			     parent.frames[0].document.forms[0].clinic_code.focus();
	     }
	 }

function assignchecks(val)
	{	
		var chkfunction=parent.frames[1].document.forms[0].call_function.value;
		var levelofcare=parent.frames[1].document.forms[0].level_of_care.value;
		var lname=parent.frames[1].document.forms[0].level_of_care;
		var fm_installyn=parent.frames[1].document.forms[0].fm_install.value;
		
		if(fm_installyn=="N"){
			clearlist(lname);
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='polsecserv' id='polsecserv' method='post' action='../../eOP/jsp/GetValResource.jsp'>";
		HTMLVal+="<input type='hidden' name='callfunction' id='callfunction' value='"+chkfunction+"'>";
		    HTMLVal+="<input type='hidden' name='levelfcare' id='levelfcare' value='"+levelofcare+"'><input name='toPopulatefs' id='toPopulatefs' type='hidden' value='populateDF'><input name='fminstall' id='fminstall' type='hidden' value='"+fm_installyn+ "'>";
		

		HTMLVal+= "</form></body></html>";

		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.polsecserv.submit();
        }
			if(parent.frames[1].document.getElementById("function_name").value == "insert")
			{
				
				if(val == 'load')
				{
					if(parent.frames[1].document.forms[0].allow_visit_regn_yn.checked == true)
					{
						parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;
						parent.frames[1].document.forms[0].allow_walk_in_yn.disabled=false;
						parent.frames[1].document.forms[0].allow_referral_yn.disabled=false;
						parent.frames[1].document.forms[0].allow_non_referral_yn.disabled=false;
					}
				}

				if(parent.frames[1].document.forms[0].level_of_care != null)
				{
				 
					if(parent.frames[1].document.forms[0].level_of_care.value=='E')
					{
						
						parent.frames[1].document.forms[0].ident_at_checkin.disabled=true;
						if(parent.frames[1].document.forms[0].ident_at_checkin.options(0).value=="X")
						{
						parent.frames[1].document.forms[0].ident_at_checkin.value='X';					
						parent.frames[1].document.forms[0].ident_at_checkin.disabled=true;
						}else{
						
						var length=parent.frames[1].document.forms[0].ident_at_checkin.length;
						for(i=1;i<length;i++)
		                       parent.frames[1].document.forms[0].ident_at_checkin.remove(1);
						var 
opt=document.createElement("OPTION");
					   opt.text=getLabel("eOP.NotIdentifiable.label","Op");
				       opt.value="X";
					   opt.selected=true;
					   opt.disabled=true;
					   parent.frames[1].document.forms[0].ident_at_checkin.add(opt);
						}

						var len=parent.frames[1].document.forms[0].primary_res_class.length;
						for(i=1;i<len;i++)
						  parent.frames[1].document.forms[0].primary_res_class.remove(1);
						var opt1=document.createElement("OPTION");
						opt1.text=getLabel("Common.practitioner.label","Common");
						opt1.value="P";
						
						parent.frames[1].document.forms[0].primary_res_class.add(opt1);

						
						parent.frames[1].document.forms[0].allow_unassign_queue.checked=true;
						parent.frames[1].document.forms[0].allow_unassign_queue.disabled=true;
						parent.frames[1].document.forms[0].allow_unassign_queue.value='Y';
					    parent.frames[1].document.forms[0].allow_unassign_queue1.value='Y';
						
						parent.frames[1].document.forms[0].allow_appt_yn.checked=false;
						parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_appt_yn.value='N';
						parent.frames[1].document.forms[0].allow_appt_yn1.value='N';
											
						if(chkfunction=="Clinic"){
						parent.frames[1].document.forms[0].emergency.checked = true;
						parent.frames[1].document.forms[0].emergency.value="Y";
						parent.frames[1].document.forms[0].emergency1.value="Y";
						
						parent.frames[1].document.forms[0].first.checked = false;
						parent.frames[1].document.forms[0].first.value="N";
						parent.frames[1].document.forms[0].first1.value="N";
						parent.frames[1].document.forms[0].first.disabled = false;
						parent.frames[1].document.forms[0].followup.checked = false;
						parent.frames[1].document.forms[0].followup.value="N";
						parent.frames[1].document.forms[0].followup1.value="N";
						parent.frames[1].document.forms[0].followup.disabled = false;
						}
						parent.frames[1].document.forms[0].routine.checked = false;
						parent.frames[1].document.forms[0].routine.value="N";
						parent.frames[1].document.forms[0].routine1.value="N";
						parent.frames[1].document.forms[0].routine.disabled = false;
						parent.frames[1].document.forms[0].series.checked = false;
						parent.frames[1].document.forms[0].series.value="N";
						parent.frames[1].document.forms[0].series1.value="N";
						parent.frames[1].document.forms[0].series.disabled = false;
						if(chkfunction=="Clinic"){
						parent.frames[1].document.forms[0].consult.checked = false;
						parent.frames[1].document.forms[0].consult.value="N";
						parent.frames[1].document.forms[0].consult1.value="N";
						parent.frames[1].document.forms[0].consult.disabled=false;
						}
						parent.frames[1].document.forms[0].open_to_all_pract_yn.checked=true;
						parent.frames[1].document.forms[0].open_to_all_pract_yn1.value='Y';
						parent.frames[1].document.forms[0].open_to_all_pract_yn.value='Y';
						parent.frames[1].document.forms[0].open_to_all_pract_yn.disabled=true;				
					}
					else
					{
						var length=parent.frames[1].document.forms[0].ident_at_checkin.length;

						
						
						if(chkfunction=="Clinic"){
						var len=parent.frames[1].document.forms[0].primary_res_class.length;
						for(i=1;i<len;i++)
						  parent.frames[1].document.forms[0].primary_res_class.remove(1);
						var opt1=document.createElement("OPTION");
						var opt2=document.createElement("OPTION");
						opt1.text=getLabel("Common.practitioner.label","Common");
						opt1.value="P";
						opt2.text=getLabel("Common.room.label","Common");
						opt2.value="R";
						parent.frames[1].document.forms[0].primary_res_class.add(opt1);
						parent.frames[1].document.forms[0].primary_res_class.add(opt2);
						}else
						{
						var len=parent.frames[1].document.forms[0].primary_res_class.length;
						for(i=1;i<len;i++)
						  parent.frames[1].document.forms[0].primary_res_class.remove(1);
						var opt1=document.createElement("OPTION");
						var opt2=document.createElement("OPTION");
						var opt3=document.createElement("OPTION");
						var opt4=document.createElement("OPTION");
						opt1.text=getLabel("Common.practitioner.label","Common");
						opt1.value="P";
						opt2.text=getLabel("Common.room.label","Common");
						opt2.value="R";
						opt3.text=getLabel("Common.equipment.label","Common");
						opt3.value="E";
						opt4.text=getLabel("Common.other.label","Common");
						opt4.value="O";
						parent.frames[1].document.forms[0].primary_res_class.add(opt1);
						parent.frames[1].document.forms[0].primary_res_class.add(opt2);
						parent.frames[1].document.forms[0].primary_res_class.add(opt3);
						parent.frames[1].document.forms[0].primary_res_class.add(opt4);
					}
						if(parent.frames[1].document.forms[0].primary_res_class.value==""||parent.frames[1].document.forms[0].primary_res_class.value=="P")
						{
							for(i=1;i<length;i++)
		                      parent.frames[1].document.forms[0].ident_at_checkin.remove(1);
						var opt=document.createElement("OPTION");
						var opt1=document.createElement("OPTION");
						opt1.text=getLabel("eOP.NotIdentifiable.label","Op");
						opt1.value="X";
					   opt.text=getLabel("Common.resource.label","Common");
				       opt.value="P";
					  
					   parent.frames[1].document.forms[0].ident_at_checkin.add(opt1);
					  parent.frames[1].document.forms[0].ident_at_checkin.add(opt);
						}else if(parent.frames[1].document.forms[0].primary_res_class.value=="R")
						{
						if(chkfunction!="DaycareUnit"){
						for(i=1;i<length;i++)
		                      parent.frames[1].document.forms[0].ident_at_checkin.remove(1);
						var opt=document.createElement("OPTION");
						opt.text=getLabel("Common.resource.label","Common");
				       opt.value="P";
					    parent.frames[1].document.forms[0].ident_at_checkin.add(opt);
						}
						}
					  	
						if((parent.frames[1].document.forms[0].allow_visit_regn_yn.checked==true)){
						parent.frames[1].document.forms[0].allow_unassign_queue.checked=false;
						parent.frames[1].document.forms[0].allow_unassign_queue.disabled=false;
						parent.frames[1].document.forms[0].allow_unassign_queue.value="N";
						parent.frames[1].document.forms[0].allow_unassign_queue1.value="N";
						}else{
							parent.frames[1].document.forms[0].allow_unassign_queue.checked=false;
						parent.frames[1].document.forms[0].allow_unassign_queue.disabled=true;
						parent.frames[1].document.forms[0].allow_unassign_queue.value="N";
						parent.frames[1].document.forms[0].allow_unassign_queue1.value="N";
						}
						
						if(chkfunction=="DaycareUnit")
						   parent.frames[1].document.forms[0].ident_at_checkin.disabled=true;
						else
						   parent.frames[1].document.forms[0].ident_at_checkin.disabled=false;
											
						if((chkfunction=="ProcedureUnit")||(chkfunction=="DaycareUnit"))
						{
						parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;
						parent.frames[1].document.forms[0].allow_appt_yn.value='N';
						parent.frames[1].document.forms[0].allow_appt_yn1.value='N';
						}

						if(chkfunction=="Clinic"){

						if((parent.frames[1].document.forms[0].allow_visit_regn_yn.checked==true))
						{
							parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;
							parent.frames[1].document.forms[0].allow_appt_yn.value='N';
							parent.frames[1].document.forms[0].allow_appt_yn1.value='N';
						}else
							{
						parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_walk_in_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_referral_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_non_referral_yn.disabled=true;

							}

						
						parent.frames[1].document.forms[0].emergency.checked = false;
						parent.frames[1].document.forms[0].emergency.value="N";
						parent.frames[1].document.forms[0].emergency1.value="N";
						
						parent.frames[1].document.forms[0].first.checked = true;
						parent.frames[1].document.forms[0].first.value="Y";
						parent.frames[1].document.forms[0].first1.value="Y";
						parent.frames[1].document.forms[0].first.disabled = false;
						parent.frames[1].document.forms[0].followup.checked = true;
						parent.frames[1].document.forms[0].followup.value="Y";
						parent.frames[1].document.forms[0].followup1.value="Y";
						parent.frames[1].document.forms[0].followup.disabled = false;
						}
						parent.frames[1].document.forms[0].routine.checked = true;
						parent.frames[1].document.forms[0].routine.value="Y";
						parent.frames[1].document.forms[0].routine1.value="Y";
						parent.frames[1].document.forms[0].routine.disabled = false;
						
						parent.frames[1].document.forms[0].series.checked = true;
						parent.frames[1].document.forms[0].series.value="Y";
						parent.frames[1].document.forms[0].series1.value="Y";
						parent.frames[1].document.forms[0].series.disabled = false;
						if(chkfunction=="Clinic"){
						parent.frames[1].document.forms[0].consult.checked = true;
						parent.frames[1].document.forms[0].consult.value="Y";
						parent.frames[1].document.forms[0].consult1.value="Y";
						parent.frames[1].document.forms[0].consult.disabled=false;
						}
						if(chkfunction!="DaycareUnit")
						{
						parent.frames[1].document.forms[0].open_to_all_pract_yn.checked=false;
						parent.frames[1].document.forms[0].open_to_all_pract_yn1.value='N';
						parent.frames[1].document.forms[0].open_to_all_pract_yn.value='N';
						parent.frames[1].document.forms[0].open_to_all_pract_yn.disabled=false;	
					    }
					}
				
				}
			  	}
			else
			{
				if(parent.frames[1].document.forms[0].level_of_care.value != null)
				{
          			if(parent.frames[1].document.forms[0].level_of_care.value == "E")
					{
									
					if(chkfunction=="Clinic"){
				
						var length=parent.frames[1].document.forms[0].ident_at_checkin.length;
						for(i=1;i<length;i++)
		                       parent.frames[1].document.forms[0].ident_at_checkin.remove(1);
						var 
opt=document.createElement("OPTION");
					   opt.text=getLabel("eOP.NotIdentifiable.label","Op");
				       opt.value="X";
					   opt.selected=true;
					   opt.disabled=true;
					   parent.frames[1].document.forms[0].ident_at_checkin.add(opt);
						
					}

						
						
									
						parent.frames[1].document.forms[0].ident_at_checkin.value='X';					
						parent.frames[1].document.forms[0].ident_at_checkin.disabled=true;
											
						parent.frames[1].document.forms[0].allow_appt_yn.checked=false;
						parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_appt_yn.value='N';
						parent.frames[1].document.forms[0].allow_appt_yn1.value='N';
						if(parent.frames[1].document.forms[0].allow_visit_regn_yn.checked==false){

						parent.frames[1].document.forms[0].allow_walk_in_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_referral_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_non_referral_yn.disabled=true;
						}
											
						parent.frames[1].document.forms[0].allow_unassign_queue.checked=true;
						parent.frames[1].document.forms[0].allow_unassign_queue.disabled=true;
						parent.frames[1].document.forms[0].allow_unassign_queue.value='Y';
						parent.frames[1].document.forms[0].allow_unassign_queue1.value='Y';

						parent.frames[1].document.forms[0].open_to_all_pract_yn.checked=true;
						parent.frames[1].document.forms[0].open_to_all_pract_yn1.value='Y';
						parent.frames[1].document.forms[0].open_to_all_pract_yn.value='Y';
						parent.frames[1].document.forms[0].open_to_all_pract_yn.disabled=true;	
						
					  
					
					}
					else if(parent.frames[1].document.forms[0].level_of_care.value=='A')
					{
					
						var length=parent.frames[1].document.forms[0].ident_at_checkin.length;

						
								
					if(chkfunction!="DaycareUnit")
						{
							if(parent.frames[1].document.forms[0].primary_res_class.value==""||document.forms[0].primary_res_class.value=="P")
						{
						for(i=1;i<length;i++)
		                      parent.frames[1].document.forms[0].ident_at_checkin.remove(1);
						var opt=document.createElement("OPTION");
						var opt1=document.createElement("OPTION");
						opt1.text=getLabel("eOP.NotIdentifiable.label","Op");
						opt1.value="X";
					   opt.text=getLabel("Common.resource.label","Common");
				       opt.value="P";
					   parent.frames[1].document.forms[0].ident_at_checkin.add(opt1);
					   parent.frames[1].document.forms[0].ident_at_checkin.add(opt);
						}else if(parent.frames[1].document.forms[0].primary_res_class.value=="R")
						{
						for(i=1;i<length;i++)
		                      parent.frames[1].document.forms[0].ident_at_checkin.remove(1);
						var opt=document.createElement("OPTION");
						opt.text=getLabel("Common.resource.label","Common");
				       opt.value="P";
					    parent.frames[1].document.forms[0].ident_at_checkin.add(opt);
						}
                    
						parent.frames[1].document.forms[0].ident_at_checkin.disabled=false;
					
						parent.frames[1].document.forms[0].ident_at_checkin.value='';
						}	
					
					if(parent.frames[1].document.forms[0].allow_visit_regn_yn.checked==true) 
						{						
						parent.frames[1].document.forms[0].allow_walk_in_yn.disabled=false;
						parent.frames[1].document.forms[0].allow_referral_yn.disabled=false;
						parent.frames[1].document.forms[0].allow_non_referral_yn.disabled=false;
						parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;					
					
					    parent.frames[1].document.forms[0].allow_unassign_queue.checked=false;
						parent.frames[1].document.forms[0].allow_unassign_queue.disabled=false;
						parent.frames[1].document.forms[0].allow_unassign_queue.value='N';
						parent.frames[1].document.forms[0].allow_unassign_queue1.value='N';
				  									
						if(parent.frames[1].document.forms[0].allow_appt_yn.value != 'Y')
							{
								parent.frames[1].document.forms[0].allow_appt_yn.checked=false;
								parent.frames[1].document.forms[0].allow_appt_yn.value='N';
								parent.frames[1].document.forms[0].allow_appt_yn1.value='N';
							}
							else
							{
									
									parent.frames[1].document.forms[0].allow_appt_yn.checked=true;
									parent.frames[1].document.forms[0].allow_appt_yn.value='Y';
									parent.frames[1].document.forms[0].allow_appt_yn1.value='Y';
							}			
						}else{
							if((chkfunction=="ProcedureUnit")||(chkfunction=="DaycareUnit"))		   parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;	
							else
						       parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
						
						parent.frames[1].document.forms[0].allow_walk_in_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_referral_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_non_referral_yn.disabled=true;

						parent.frames[1].document.forms[0].allow_unassign_queue.checked=false;
						parent.frames[1].document.forms[0].allow_unassign_queue.disabled=true;
						parent.frames[1].document.forms[0].allow_unassign_queue.value='N';
						parent.frames[1].document.forms[0].allow_unassign_queue1.value='N';
						
					}
					}

				}
			}	
		
		}

		
	/*	function clinicResource()
		{
	
		 parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
			
		} 
		function uncheck(obj)
		{ 
			 var assingvalue=obj.value;
			 
			 if(assingvalue=='N')
			{
				
				  parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
			}
			
		} */

		
function vitalenable()
		{
		   var effstatus;
           if(parent.frames[0].document.forms[0])
		   effstatus=parent.frames[0].document.forms[0].eff_status.value;
		   
		   var callfunc=parent.frames[1].document.forms[0].call_function.value;
			  
			if(effstatus=="E")
			{
			if(callfunc!="DaycareUnit"){
             if(parent.frames[1].document.forms[0].primary_res_class.value=="R"||parent.frames[1].document.forms[0].primary_res_class.value=="E"||parent.frames[1].document.forms[0].primary_res_class.value=="O")
				{
			      parent.frames[1].document.forms[0].open_to_all_pract_yn1.value='N';
				parent.frames[1].document.forms[0].open_to_all_pract_yn.value='N';
				parent.frames[1].document.forms[0].open_to_all_pract_yn.disabled=true;
				}
				else
				{
					if(parent.frames[1].document.forms[0].ident_at_checkin.value!="X")
          				   parent.frames[1].document.forms[0].open_to_all_pract_yn.disabled=false;
				}
				if(parent.frames[1].document.forms[0].level_of_care.value=='E')
					parent.frames[1].document.forms[0].allow_unassign_queue.disabled=true;
				else
					parent.frames[1].document.forms[0].allow_unassign_queue.disabled=false;
			}
			 if(parent.frames[1].document.forms[0].function_name.value=="modify")
				{
                           
			 if(parent.frames[1].document.forms[0].mr_section_type.value=="D")
					{
						
					parent.frames[1].document.forms[0].online_mr_notfn_yn.value="N";
					parent.frames[1].document.forms[0].online_mr_notfn_yn1.value="N";
					parent.frames[1].document.forms[0].online_mr_notfn_yn.disabled=true;
					parent.frames[1].document.forms[0].online_mr_notfn_yn.checked=false;
					}else
					{		
					//	if(parent.frames[1].document.forms[0].create_file_yn.value=='Y')
					//		parent.frames[1].document.forms[0].online_mr_notfn_yn.disabled=false;	
				//		else
					//		parent.frames[1].document.forms[0].online_mr_notfn_yn.disabled=true;

					}
				}
			 if(parent.frames[1].document.forms[0].allow_visit_regn_yn.checked==false)
			{
				  				
			     parent.frames[1].document.forms[0].vitalsignsb.disabled=true;		
				 parent.frames[1].document.forms[0].disp_in_ca_queue_after.disabled=true;
					  
				parent.frames[1].document.forms[0].allow_unassign_queue.disabled=true;
				 parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
				parent.frames[1].document.forms[0].allow_unassign_queue.value="N";
				parent.frames[1].document.forms[0].allow_unassign_queue1.value="N";

			   if(parent.frames[1].document.forms[0].function_name.value=="modify")
				{ 
				   		
				   		parent.frames[1].document.forms[0].allow_walk_in_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_referral_yn.disabled=true;
						parent.frames[1].document.forms[0].allow_non_referral_yn.disabled=true;
									
					if((callfunc=="ProcedureUnit")||(callfunc=="DaycareUnit"))
					{
					   if(parent.frames[1].document.forms[0].level_of_care.value=='A' && parent.frames[1].document.forms[0].allow_visit_regn_yn.checked==true)
					        parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;
					   else
						    parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
					if(parent.frames[1].document.forms[0].allow_appt_yn1.value=="Y")
						{
									
					
						 parent.frames[1].document.forms[0].allow_appt_yn1.value="Y";
					     parent.frames[1].document.forms[0].allow_appt_yn.checked=true;
						 parent.frames[1].document.forms[0].allow_appt_yn.value="Y";
					    }
					}
					else
					{
					 	 			
                        parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
					
					}
				}
			}else
			{
				
				parent.frames[1].document.forms[0].vitalsignsb.disabled=false;	
				parent.frames[1].document.forms[0].disp_in_ca_queue_after.disabled=false;
				
				if(parent.frames[1].document.forms[0].function_name.value=="modify")
				{
						
				if(parent.frames[1].document.forms[0].level_of_care.value=='A')
					{
				     parent.frames[1].document.forms[0].allow_appt_yn.disabled=false;
					 if(parent.frames[1].document.forms[0].allow_appt_yn1.value=="Y")
						{
						 parent.frames[1].document.forms[0].allow_appt_yn1.value="Y";
					     parent.frames[1].document.forms[0].allow_appt_yn.checked=true;
						 parent.frames[1].document.forms[0].allow_appt_yn.value="Y";
					    }
					}
				else	
					
				    parent.frames[1].document.forms[0].allow_appt_yn.disabled=true;
				     
				parent.frames[1].document.forms[0].allow_walk_in_yn.disabled=false;
				parent.frames[1].document.forms[0].allow_referral_yn.disabled=false;
				parent.frames[1].document.forms[0].allow_non_referral_yn.disabled=false;
				
				}
			}
		
			}
}
function assignVisitval(obj)
	{
		if(obj.checked == true)
		{
			parent.frames[0].document.forms[0].visit_pract.value="Y";
			parent.frames[0].document.forms[0].visit_pract_yn.value="Y";
		}
		else
		{
			parent.frames[0].document.forms[0].visit_pract.value="N";
			parent.frames[0].document.forms[0].visit_pract_yn.value="N";
		}
	}



	function queCheckVal(obj)
{
	if(obj.name == "num_appl")
	{
	if(obj.checked)
	{
		//document.forms[0].by_pract.disabled=false;
		//document.forms[0].by_room.disabled=false;

		//document.forms[0].by_res.disabled=false;
		//document.forms[0].by_pract.checked=false;
		//document.forms[0].by_room.checked=false;

		//document.forms[0].by_res.checked=false;
		document.forms[0].num_appl.value='Y';
		document.forms[0].num_appl_yn.value='Y';
	
	}
	else
	{
		//document.forms[0].by_pract.disabled=true;
		//document.forms[0].by_room.disabled=true;
		//document.forms[0].by_res.disabled=true;
		//document.forms[0].by_pract.checked=false;
		//document.forms[0].by_room.checked=false;
		//document.forms[0].by_res.checked=false;
		//document.forms[0].other_res.disabled=true;
		//document.forms[0].other_type.disabled=true;
		//document.forms[0].other_res.value='';
		//document.forms[0].other_type.value='';
		document.forms[0].num_appl.value='N';
		document.forms[0].num_appl_yn.value='N';
	
	}
	}
	/*else if(obj.name == "by_pract")
	{
		if(obj.checked)
		{
		 document.forms[0].by_pract.value='Y';
		 document.forms[0].by_pract_yn.value='Y';
		}else
		{
	   	 document.forms[0].by_pract.value='N';
		 document.forms[0].by_pract_yn.value='N';
		}
		
	}
	else if(obj.name == "by_room")
	{
	
		if(obj.checked)
		{
		 document.forms[0].by_room.value='Y';
		 document.forms[0].by_room_yn.value='Y';
		}else
		{
	   	 document.forms[0].by_room.value='N';
		 document.forms[0].by_room_yn.value='N';
		}

	}
	else if(obj.name =="by_res")
	{
		if(obj.checked)
		{
			document.forms[0].other_res.disabled=false;
			document.forms[0].other_type.disabled=false;
			document.forms[0].by_res.value='Y';
			document.forms[0].by_res_yn.value='Y';
		}else
		{
			document.forms[0].other_res.disabled=true;
			document.forms[0].other_type.disabled=true;
			document.forms[0].other_res.value='';
			document.forms[0].other_type.value='';
			document.forms[0].by_res.value='N';
			document.forms[0].by_res_yn.value='N';
		}

	}*/
}

function assignValue(obj) 
{ 
	if (obj.checked == true){
		clinic_main_resource_form.rd_appl_yn.value="Y"; 
		parent.frames[1].document.clinic_resource_form.mr_section_type.value="";
		parent.frames[1].document.clinic_resource_form.mr_section_type.disabled=true;
		parent.frames[1].document.clinic_resource_form. mr_section.value="";
		parent.frames[1].document.clinic_resource_form. mr_section.disabled=true;
		parent.frames[1].document.clinic_resource_form.mr_location_code.value="";
		parent.frames[1].document.clinic_resource_form.mr_location_code.disabled=true;
		parent.frames[1].document.clinic_resource_form.dflt_file_type.value="";
		parent.frames[1].document.clinic_resource_form.dflt_file_type.disabled=true;		
		parent.frames[1].document.clinic_resource_form.online_mr_notfn_yn.checked=false;
		parent.frames[1].document.clinic_resource_form.online_mr_notfn_yn.disabled=true;
		parent.frames[1].document.clinic_resource_form.primary_res_class.selectedIndex=3;
		parent.frames[1].document.clinic_resource_form.primary_res_class.onchange();
		parent.frames[1].document.clinic_resource_form.primary_res_class.disabled=true;
		parent.frames[1].document.clinic_resource_form.ident_at_checkin.disabled=true;
		//Changes for Bru-HIMS-CRF 192.1 - start
		if(parent.frames[1].document.clinic_resource_form.qms_appl_yn){
		parent.frames[1].document.clinic_resource_form.qms_appl_yn.checked=false;
		parent.frames[1].document.clinic_resource_form.qms_appl_yn.disabled=true;		
		}
		//Changes for Bru-HIMS-CRF 192.1 - end
	}else{
    	clinic_main_resource_form.rd_appl_yn.value="N";
		parent.frames[1].document.clinic_resource_form.mr_section_type.disabled=false;
		parent.frames[1].document.clinic_resource_form. mr_section.disabled=false;
		parent.frames[1].document.clinic_resource_form. mr_location_code.disabled=false;
		parent.frames[1].document.clinic_resource_form. dflt_file_type.disabled=false;
		parent.frames[1].document.clinic_resource_form. online_mr_notfn_yn.disabled=false;
		parent.frames[1].document.clinic_resource_form.primary_res_class.disabled=false;
		parent.frames[1].document.clinic_resource_form.primary_res_class.selectedIndex=0;
		parent.frames[1].document.clinic_resource_form.primary_res_class.onchange();
		parent.frames[1].document.clinic_resource_form.primary_res_class.disabled=false;
		parent.frames[1].document.clinic_resource_form.ident_at_checkin.disabled=false;
		//Changes for Bru-HIMS-CRF 192.1 - start
		if(parent.frames[1].document.clinic_resource_form.qms_appl_yn){
		parent.frames[1].document.clinic_resource_form.qms_appl_yn.checked=false;		
		parent.frames[1].document.clinic_resource_form.qms_appl_yn.disabled=false;			
		}		
		//Changes for Bru-HIMS-CRF 192.1 - end
	}
}
//Changes for Bru-HIMS-CRF 192.1 
function queueNumbering(obj){
	if(obj.name == "qms_appl_yn")
	{
		if(obj.checked)
		{
			document.forms[0].qms_appl_yn.value='Y';
			document.forms[0].qms_interfaced_yn.value='Y';
		}
		else
		{
			document.forms[0].qms_appl_yn.value='N';
			document.forms[0].qms_interfaced_yn.value='N';
		}
	}
}
function PopupHide(obj) // added by mujafar for GHL-CRF-0527
{  
	if(obj.checked ==true)
	{  
		document.clinic_main_resource_form.alert_req_book_appt_yn.value='Y';
		document.getElementById('popup_hide').style.display  = '';
	}
	else
	{  
		document.clinic_main_resource_form.alert_req_book_appt_yn.value='N';
		document.getElementById('popup_hide').style.display	= 'none';
		document.clinic_main_resource_form.popup_desc.value='';
	}
}

