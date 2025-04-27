
function onSuccess()
{
     f_query_add_mod.frames[0].document.forms[0].reset();
	f_query_add_mod.frames[1].document.location.href = '../../eCommon/html/blank.html';
	f_query_add_mod.frames[2].document.location.href = '../../eCommon/html/blank.html';
} 
function apply() 
{
	
	if (checknull())
	{
		if(f_query_add_mod.frames[0].document.forms[0].opt.value=='V')
			f_query_add_mod.frames[0].document.forms[0].cutoff_date.value = f_query_add_mod.frames[1].document.forms[0].CUTOFF_DATE1.value;

		if(f_query_add_mod.frames[0].document.forms[0].opt.value=='E')
			f_query_add_mod.frames[0].document.forms[0].service_code.value = f_query_add_mod.frames[1].document.forms[0].service.value;
		else
			f_query_add_mod.frames[0].document.forms[0].service_code.value = ''; 

		f_query_add_mod.frames[0].document.forms[0].target='messageFrame';
		f_query_add_mod.frames[0].document.forms[0].submit();
	}
}

async function callChkOut(enc_id,pat_id,loc_type,loc_code,pract_id,queue_date,module_id,episode_id,visit_id,allow_chkout_with_bill_stmt_yn) 
{			
	var dialogHeight= "95vh" ;
	var dialogWidth = "75vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arguments   = "" ;
	var parameters	= "?p3="+enc_id+"&p6="+pract_id+"&p4="+loc_type+"&p5="+loc_code+"&p2="+
					  pat_id+"&P_Queue_Date="+queue_date+"&module_id="+module_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn;			
	
	var retVal =await window.showModalDialog("../../eOP/jsp/PatCheckoutCall.jsp"+parameters,arguments,features);
   
            parent.frames[1].frames[2].document.location.reload();
      //parent.frames[0].document.forms[0].submit();
      }	

function checknull() {
	var errors = "" ;
	var choice = f_query_add_mod.frames[0].document.forms[0].opt.value;
	if(choice=="")
	{
		var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
			err = err.replace('$',getLabel('Common.Process.label','Common'));			
		    errors = errors + err + "<br>" ;
	}

	if ( errors.length != 0 ) 
	{
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false ;
	}
	return true ;
}


function reset() {
    f_query_add_mod.frames[0].document.forms[0].reset();
	f_query_add_mod.frames[1].document.location.href = '../../eCommon/html/blank.html';
	f_query_add_mod.frames[2].document.location.href = '../../eCommon/html/blank.html';
 }


//performing_facility_desc= formObjBottom.performing_facility_id.options(formObjBottom.performing_facility_id.selectedIndex).text;

//Functions used in main jsp page

function callme(obj,bl_interfaced_yn,bl_install_yn,allow_chkout_with_bill_stmt_yn)
{
	
	var module_id=document.forms[0].module_id.value;			
	
	if(obj.value=='V')
	{
		parent.frames[1].location.href='BatchProcessCutoffDate.jsp?module_id='+module_id+'&bl_interfaced_yn='+bl_interfaced_yn+'&bl_install_yn='+bl_install_yn;		
	
		if( bl_install_yn == "Y" && bl_interfaced_yn == "Y" ) {				
			parent.frames[2].location.href='AssignPractForAutoClose.jsp?module_id='+module_id+'&bl_interfaced_yn='+bl_interfaced_yn+'&allow_chkout_with_bill_stmt_yn='+allow_chkout_with_bill_stmt_yn+'&bl_install_yn='+bl_install_yn;				
		}		

	}
	else if(obj.value=='E')
	{
		parent.frames[1].location.href='BatchProcessCutoffDateEpisodes.jsp?module_id='+module_id;
		parent.frames[2].location.href = '../../eCommon/html/blank.html';
	}
	else if(obj.value=='')
	{
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		parent.frames[2].location.href = '../../eCommon/html/blank.html';
	}
}

function dtValue(obj)
{
	var episode_closure_by = parent.frames[1].document.forms[0].episode_closure_by.value; 
	var callfunc='batchProcess';
	parent.frames[1].document.forms[0].cutoffdate.value="";
	parent.frames[1].document.forms[0].cutoffdate1.value="";
	parent.frames[2].location.href='RoomValidationYN.jsp?service_code='+obj.value+'&callfunc='+callfunc+'&episode_closure_by='+episode_closure_by;
}
