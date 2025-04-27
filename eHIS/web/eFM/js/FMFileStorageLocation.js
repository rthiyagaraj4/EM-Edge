function create()
{
	frames[1].location.href = '../../eFM/jsp/FMFileStorageLocnAddMod.jsp?operation=insert';
	frames[2].location.href = '../../eCommon/jsp/error.jsp';
}

function query()
{
	frames[1].location.href = '../../eFM/jsp/FMFileStorageLocnQueryCriteria.jsp?';
	frames[2].location.href = '../../eCommon/jsp/error.jsp';
}

function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href; 	
	 url = url.toLowerCase();
	 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("locnquery")==-1) )  {			 
		return true;
	 } else {	 		 
		return false;
	 }
}

function apply()
{
	
	if (! (checkIsValidForProceed()) )
    {
        frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	
	var obj = frames[1].document.forms[0]
	var single_or_multi_files_ind = obj.single_or_multi_files_ind.value;

	var to_proceed = true;
	if(obj.effstatus.checked == true)
		obj.effstatus.value = "E";
	else
		obj.effstatus.value = "D";

	if(obj.mrlocation.checked == true)
		obj.mrlocation.value = "Y";
	else
		obj.mrlocation.value = "N";

	if(obj.permlocation.checked == true)
		obj.storagelocation.value = "Y";
	else
		obj.storagelocation.value = "N";

	obj.locationidentity.value = obj.locnidentity.options[obj.locnidentity.selectedIndex].value;
	obj.mr_section_code.value = obj.mr_section_code.options[obj.mr_section_code.selectedIndex].value;

	if(obj.narrationcode.selectedIndex != 0)
		obj.narration.value = obj.narrationcode.options[obj.narrationcode.selectedIndex].value;

		var fields1			=	new Array(f_query_add_mod.document.forms[0].stglocncode);
		var names1			=	new Array(getLabel('Common.code.label','common'));
		//var messageFrame1	=	parent.frames[1].frames[2];
		var messageFrame1	=	frames[2];
		var error_page1		=	'../../eCommon/jsp/MstCodeError.jsp';
		var fields			= "";
		var names			= "";

		if(SpecialCharCheck(fields1,names1,messageFrame1,"M",error_page1))
		{
			if(single_or_multi_files_ind == 'M')
			{
				 fields = new Array ( obj.stglocncode, obj.stglongdesc, obj.stgshortdesc,obj.mr_section_code,obj.locnidentity );
				 names = new Array ( getLabel('Common.code.label','common'),getLabel('Common.longdescription.label','common'),getLabel('Common.shortdescription.label','common'),getLabel("Common.MRSection.label","common"), getLabel("Common.FileStorageLocation.label","common")+ " " +getLabel("Common.Identity.label","common") );
			}
			else if(single_or_multi_files_ind == 'S')
			{
				 fields = new Array ( obj.stglocncode, obj.stglongdesc, obj.stgshortdesc,obj.locnidentity );
				 names = new Array ( getLabel('Common.code.label','common'),getLabel('Common.longdescription.label','common'),getLabel('Common.shortdescription.label','common'),getLabel("Common.FileStorageLocation.label","common")+ " " + getLabel("Common.Identity.label","common") );
			}
			if(f_query_add_mod.checkFieldsofMst( fields, names, frames[2])) 
			{
				if(obj.mrlocation.disabled == true)		obj.mrlocation.disabled = false;
				if(obj.p_holder_name.disabled == true)	obj.p_holder_name.disabled = false;
							
				to_proceed = true;
			}
			else
			{
				to_proceed = false;
			}
		}
	if (to_proceed==true)
	{
		if(obj.mrlocation.value == "N" && obj.locationidentity.value == "D")
		{			
			var errors = getMessage("FS_LOCN_IDENTITY_DEPT","FM");
			messageFrame.location.href="../jsp/MstCodeError.jsp?err_num="+errors ;
			return false;
			obj.locnidentity.focus();
			to_proceed=false;
		}
		else
			to_proceed=true;
	}

	if(frames[1].document.forms[0].retcriteria[0].checked){		
		frames[1].document.forms[0].returncriteria.value = "D"
	}else if (frames[1].document.forms[0].retcriteria[1].checked){
		frames[1].document.forms[0].returncriteria.value = "I"
	}
	
	

	if (to_proceed==true)
	{
		if(obj.mr_section_code.disabled == true) obj.mr_section_code.disabled = false;
		obj.submit();
	}
	
}

function reset()
{

	if(f_query_add_mod.document.location.href.indexOf("FMFileStorageLocnQueryResult.jsp") != -1)
		return false;
	else {

		if(f_query_add_mod.document.forms[0].name == "FileStorageLocn_form")
			{
				if(f_query_add_mod.document.FileStorageLocn_form.operation.value =="insert")
				{					
					frames[1].document.location.reload();				
				}
				else					
				f_query_add_mod.location.reload() ;
			}
			  
			if(f_query_add_mod.document.forms[0].name == "query_form")
			{
				f_query_add_mod.document.query_form.reset() ;
			
			}
	}
}

function onSuccess()
{
	frames[1].document.location.reload();

}

function MRLocnClick(Obj)
{
	var opt_text  = "";
	var opt_value = "";

	var sel	= document.forms[0].locnidentity;
	while(sel.options.length>1)
		sel.remove(1);
	if(Obj.checked == true)
	{
		FileStorageLocn_form.permlocation.disabled = false;
		/*FileStorageLocn_form.locnidentity.value = "D";
		FileStorageLocn_form.locnidentity.disabled = true;*/
		opt_text  = new Array(getLabel("Common.clinic.label","common"),getLabel("Common.nursingUnit.label","common"),getLabel("Common.ProcedureUnit.label","common"),getLabel("Common.DaycareUnit.label","common"),getLabel("Common.department.label","common"));
		opt_value = new Array("C","N","E","Y","D");
		for(var i=0;i<opt_text.length;i++)
		{
			var opt	  = document.createElement("OPTION");
			opt.text  =  opt_text[i];
			opt.value = opt_value[i];
			document.forms[0].locnidentity.add(opt);
		}
	}
	else
	{
		opt_text  = new Array(getLabel("Common.clinic.label","common"),getLabel("Common.nursingUnit.label","common"),getLabel("Common.ProcedureUnit.label","common"),getLabel("Common.DaycareUnit.label","common"),getLabel("Common.practitioner.label","common"),getLabel("Common.department.label","common"));
		opt_value = new Array("C","N","E","Y","T","D");
		
		for(var i=0;i<opt_text.length;i++)
		{
			var opt	  = document.createElement("OPTION");
			opt.text  = opt_text[i];
			opt.value = opt_value[i];
			document.forms[0].locnidentity.add(opt);
		}
		FileStorageLocn_form.permlocation.checked		= false;
		FileStorageLocn_form.permlocation.disabled		= true;
		FileStorageLocn_form.locnidentity.disabled		= false;
		FileStorageLocn_form.retcriteria[0].disabled	= false;
		FileStorageLocn_form.retcriteria[1].disabled	= false;
		FileStorageLocn_form.noofdays.disabled			= false;
		FileStorageLocn_form.duration_type[0].disabled	= false;
		FileStorageLocn_form.duration_type[1].disabled	= false;
		FileStorageLocn_form.noofdays_ip.disabled		= false;
		FileStorageLocn_form.noofdays_op.disabled		= false;
		FileStorageLocn_form.noofdays_em.disabled		= false;
		FileStorageLocn_form.noofdays_dc.disabled		= false;
	}
}

function RadioOptions(Obj)
{
	if(Obj.value == "D")
	{
		FileStorageLocn_form.returncriteria.value = "D";
		FileStorageLocn_form.noofdays.value		  = "";
		FileStorageLocn_form.noofdays.disabled	  = true;
	}
	else
	{
		FileStorageLocn_form.returncriteria.value = "I";
		FileStorageLocn_form.noofdays.disabled	  = false;
	}
}

async function searchUser(target,fac_id)
{
	var retVal		 = 	new String();
	var sql			 = "";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var val=target.value;
	if(val==undefined) val="";
	var tit			 = getLabel("Common.user.label","common");
	
	sql = "Select a.appl_user_id code, a.appl_user_name description from SM_FACILITY_FOR_USER_VW a where a.facility_id='"+fac_id+"' and  upper(a.appl_user_id) like upper(?) and upper(a.appl_user_name) like upper(?) order by 2 ";
	     
		   argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] =val ;
			argumentArray[6] = DESC_LINK  ;
			argumentArray[7] = DESC_CODE ;

		retVal = await CommonLookup( tit, argumentArray );
		
		var arr = new Array();
		if(retVal != null && retVal != "" ) 
		{
			var retVal=unescape(retVal);
		    arr=retVal.split(",");
			document.forms[0].p_holder_name1.value  = arr[1];
			document.forms[0].p_holder_name.value	=arr[0];
		}
		else
		{
			document.forms[0].p_holder_name1.value = "";
			document.forms[0].p_holder_name.value  = "";
		}
}

function showIdentity(obj,objval)
{
		if(objval == "C"){
			if ((obj.value=="D")   ){
				document.getElementById("td1").style.display="none";
				document.getElementById("td2").style.display="inline";
				document.getElementById("td2").style.visibility="visible";		
			}
			else if((obj.value=="H")){
		 
				 document.getElementById("td2").style.display="none";
				 document.getElementById("td1").style.display="inline";
				 document.getElementById("td1").style.visibility="visible";
			}else{
				 document.getElementById("td1").style.display="none";
				 document.getElementById("td2").style.display="inline";
				 document.getElementById("td2").style.visibility="visible";
			}
			document.forms[0].noofdays_op.focus();
		
	}else{
			if ( objval == "D" ){
				document.getElementById("td1").style.display="none";
				document.getElementById("td2").style.display="inline";
				document.getElementById("td2").style.visibility="visible";		
			}
			else if(objval =="H"){
		 
				 document.getElementById("td2").style.display="none";
				 document.getElementById("td1").style.display="inline";
				 document.getElementById("td1").style.visibility="visible";
		}else{
				 document.getElementById("td1").style.display="none";
				 document.getElementById("td2").style.display="inline";
				 document.getElementById("td2").style.visibility="visible";
		}
	
	}
}//End of FUnc


function CheckNumber(obj) 
{		
	
		if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
			if(obj.value == 0){			
				alert(getMessage("NUM_GT_ZERO","OA"));
				obj.value = "";
				obj.focus();
				return false;
			}
			return true;
		}
		else {
			if ( obj.value.length > 0 ) {
				alert(getMessage("NUM_ALLOWED","SM"));
				obj.value = "";
				obj.select();
				obj.focus();
				return false;
			}
		}//End of ELse
}//END of Function 
function chkNumber(event)
{
	if (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 45))
		return true;
	else return false;
}

function valReturnCriteria(obj)
{
	if (obj.checked == true)	
	{
		FileStorageLocn_form.retcriteria[0].disabled   = true;
		FileStorageLocn_form.retcriteria[1].disabled   = true;
		FileStorageLocn_form.noofdays.value			   = "";
		FileStorageLocn_form.noofdays.disabled	       = true;
		FileStorageLocn_form.duration_type[0].disabled = true;
		FileStorageLocn_form.duration_type[1].disabled = true;
		FileStorageLocn_form.noofdays_op.value		   = "";
		FileStorageLocn_form.noofdays_ip.value		   = "";
		FileStorageLocn_form.noofdays_em.value		   = "";
		FileStorageLocn_form.noofdays_dc.value		   = "";
		FileStorageLocn_form.noofdays_op.disabled	   = true;
		FileStorageLocn_form.noofdays_ip.disabled      = true;
		FileStorageLocn_form.noofdays_em.disabled      = true;
		FileStorageLocn_form.noofdays_dc.disabled      = true;
	}
	else if (obj.checked == false)	
	{
		FileStorageLocn_form.retcriteria[0].disabled   = false;
		FileStorageLocn_form.retcriteria[1].disabled   = false;
		FileStorageLocn_form.noofdays.disabled		   = false;
		FileStorageLocn_form.duration_type[0].disabled = false;
		FileStorageLocn_form.duration_type[1].disabled = false;
		FileStorageLocn_form.noofdays_op.disabled	   = false;
		FileStorageLocn_form.noofdays_ip.disabled	   = false;
		FileStorageLocn_form.noofdays_em.disabled	   = false;  
		FileStorageLocn_form.noofdays_dc.disabled      = false;
	}
}
