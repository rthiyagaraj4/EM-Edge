/*
	Developed By       :  NANDA KUMAR R.
	Developed on   	   :  22/02/2002
	Module Name 	   :  DR
	Function Name	   :  Enter Duplicates
*/
//when query is called
var p_string_val ;
var p_old_val ;
var p_string_newval ;
var p_delete_patient_val ='';
function query()
{
	parent.frames[2].frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode=modify';
}
// WHEN THE CREATE BUTTON IS PRESSED
function create()
{
     var flag='create'; 
	 parent.frames[2].frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode='+"addition"+'&flag='+flag;

}

function checkIsValidForProceed(frameName)
{
 var url = frameName.location.href;
 url = url.toLowerCase();
  if ( (url.indexOf("blank.html")==-1))
  return true;
 else
  return false;
}

function deleterecord()
{
		if (! (checkIsValidForProceed(enterDuplicatePatients)) )
    {
		
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
        return false;
    }		
	 var p_function_name = frames[1].frames[0].document.forms[0].function_name.value;	
      	if(p_function_name !="modify") p_function_name="insert";

	//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
	var merge_reason_yn = "";
	var requested_by_yn = "";
	var merge_reason = "";
	var requested_by_name = "";
	var requested_by = "";
	var fields = new Array();
	var names = new Array();

	 if(p_function_name == "insert")	
	 { 					 		
	   
	   messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
        return false;
	 }	
	 else if(p_function_name == "modify")
	 {
		if (! (checkIsValidForProceed(frames[1].frames[1])))
		{ 
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
			return false;
		}
		else 
			var p_string_val = frames[1].frames[1].frames[2].document.forms[0].p_string_val.value ;
			if(p_string_val!="")	
	
			p_no_of_records = frames[1].frames[1].frames[2].document.forms[0].no_of_records.value ;
			
			else
				p_no_of_records="";

			//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
			merge_reason_yn = frames[1].frames[1].frames[2].document.forms[0].merge_reason_yn.value;
			requested_by_yn = frames[1].frames[1].frames[2].document.forms[0].requested_by_yn.value;
			merge_reason = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
			requested_by_name = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;			
			requested_by = frames[1].frames[1].frames[2].document.forms[0].requested_by.value;
			
			frames[1].frames[1].frames[0].document.forms[0].merge_reason.value = merge_reason;		
			frames[1].frames[1].frames[0].document.forms[0].requested_by.value = requested_by;

			frames[1].frames[1].frames[0].document.forms[0].p_pat_count.value = p_no_of_records;	
	 
	 }		

	var p_D_position =0;
	var p_V_position =0;	
	
    if (p_function_name == 'modify')
	{
			var p_del_string_val = '';
			var p_check_for_delete = '';
			var p_previous_patient_flag = '';
			var p_previous_patient_value = '';
			var p_current_patient_flag ='';
			var p_loop_for_valid_check = false;
			var p_dup_group_id ='';
			var p_no_of_records_to_delete = 0;
			var p_position = 0;
			var for_submit=true;
		
			p_dup_group_id = frames[1].frames[1].frames[2].document.forms[0].dupgroupid.value;
          	
			frames[1].frames[1].frames[0].document.forms[0].dupgroupid.value = p_dup_group_id; 

			p_D_position =0;
			p_V_position =0;

			for(var counter=1;counter<=p_no_of_records;counter++)
			{			
				p_previous_patient_flag = eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value") ;

				if (p_previous_patient_flag == 'D')
				{				
					p_D_position++;
				}
				else
				{
					p_V_position++;
				}

			}
		

		if (for_submit==true)
		{
	
			for(var counter=1;counter<=p_no_of_records;counter++)
			{
				p_check_for_delete = eval("frames[1].frames[1].frames[2].document.forms[0].deletePatient"+counter+".checked") ;
			
				if (p_check_for_delete) {				
					p_del_string_val = p_del_string_val + eval("frames[1].frames[1].frames[2].document.forms[0].patient_id"+counter+".value") + '`' + eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value") + '`' + eval("frames[1].frames[1].frames[2].document.forms[0].remarks"+counter+".value")+"~" ;				
					p_no_of_records_to_delete = p_no_of_records_to_delete + 1;        
				
					if(eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value")== 'V') 	{
						p_V_position--;						
					} else if(eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value")== 'D') {
						p_D_position--;						
					}
				}
			}
			 	

				if(p_no_of_records_to_delete==0)  {							
					if(p_D_position >=1) {
						var ErrorText = getMessage("ATLEAST_ONE_SELECTED","Common");
						document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
						for_submit=false;						
					} else {
						document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_num= ";
						for_submit=false;				
				    }
				}

				var delete_all = false;				
				if(p_no_of_records_to_delete != 0) {
				if(p_V_position == p_no_of_records - p_no_of_records_to_delete ) {	
					for(var c=1;c<=p_no_of_records;c++) {
						if(eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+c+".value") == 'V') {
							p_del_string_val = p_del_string_val + eval("frames[1].frames[1].frames[2].document.forms[0].patient_id"+c+".value") + '`' + eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+c+".value") + '`' + eval("frames[1].frames[1].frames[2].document.forms[0].remarks"+c+".value")+"~" ;
							p_no_of_records_to_delete = p_no_of_records_to_delete + 1;
							delete_all = true;
					   }
        		    }
			     }
				}
				var p_pat_count=p_no_of_records - p_no_of_records_to_delete;		
				frames[1].frames[1].frames[0].document.forms[0].p_pat_count.value = p_pat_count;				
				frames[1].frames[1].frames[0].document.forms[0].delete_string.value = p_del_string_val ;
				p_string_val = 	frames[1].frames[1].frames[2].document.forms[0].p_string_old_val_new.value;
				frames[1].frames[1].frames[0].document.forms[0].p_string_value.value = p_string_val;

		}
		
		if (delete_all==true) {				
			for_submit = false;
			if (confirm(getMessage("DELETE_BOTH_MAIN_AND_DUPLICATE","DR"))) {  
				frames[1].frames[1].frames[0].document.forms[0].mode.value = 'update';		
				frames[1].frames[1].frames[0].document.forms[0].submit();		
				frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode=modify';				
			}
			else
				parent.parent.parent.frames[2].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_num= ";

		}

		if (for_submit==true)
		{				
			if (confirm(getMessage("DELETE_RECORD","Common"))) {  
				//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
				if(merge_reason_yn == "Y" && requested_by_yn == "Y"){
					if(merge_reason == "" && requested_by_name == ""){
						fields[0] = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
						fields[1] = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;
						names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
						names[1] = getLabel("Common.RequestedBy.label","Common");
					}else if(merge_reason == ""){
						fields[0] = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
						names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
					}else if(requested_by_name == ""){
						fields[0] = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;
						names[0] = getLabel("Common.RequestedBy.label","Common");
					}
				}else if(merge_reason_yn == "Y" && merge_reason == ""){
					fields[0] = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
					names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
				}else if(requested_by_yn == "Y" && requested_by_name == ""){
					fields[0] = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;
					names[0] = getLabel("Common.RequestedBy.label","Common");
				}

				if(checkFields(fields, names, messageFrame)){
					frames[1].frames[1].frames[0].document.forms[0].mode.value = 'update';		
					frames[1].frames[1].frames[0].document.forms[0].submit();		
					frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode=modify';
				}
			}
			else
				parent.parent.parent.frames[2].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_num= ";

		}


	}
	
}
function callPatientLine(obj,function_name)
{
	
	obj.value = obj.value.toUpperCase();
	p_patient_id = obj.value ;
	if (p_patient_id.length>0)
	{
		p_string_oldval =  parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value ;
		p_flag_value =  parent.parent.frames[1].frames[0].document.forms[0].p_flag_value.value ;
		p_patient_line =  parent.parent.frames[1].frames[0].document.forms[0].p_patient_line.value ;

		 if (p_patient_line.length>0){
			if(p_patient_line.indexOf(p_patient_id)!=-1)					
					return false;		
			}

		p_string_val=parent.parent.frames[1].frames[2].document.forms[0].p_string_val.value;

				if(p_flag_value=="N")
					if(p_string_val=='')					
						 parent.parent.frames[1].frames[0].document.forms[0].p_flag_value.value='';	
				

		if(parent.parent.frames[1].frames[2].document.forms[0]){
		var Pat_id=obj.value;
		if(p_string_oldval.indexOf(Pat_id)!=-1)	{		
			document.forms[0].patient_id.select();
			document.forms[0].patient_id.focus();			
			var ErrorText = getMessage("DUPLICATE_PATIENT_ENTRY","DR");			
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
			return false;
		}
		
		/*Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815*/
		var isMergeDeceasedPatIdAppl = parent.parent.frames[1].frames[0].document.forms[0].isMergeDeceasedPatIdAppl.value;

		if(isMergeDeceasedPatIdAppl == 'true'){

			var xmlDoc=""
			var xmlHttp = new XMLHttpRequest()
			xmlStr = "<root><SEARCH patient_id=\""+Pat_id+"\" action='getPatDeceasedYN' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../jsp/DRIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText = xmlHttp.responseText
			var sel_pat_deceased_yn = trimString(responseText);

			var segments = p_string_oldval.split('~');
			var patientIds = [];
			var index = 0;

			for (var i = 0; i < segments.length; i++) {
				if (segments[i]) {
					var parts = segments[i].split('`');
					var patientId = parts[0];
					patientIds[index] = patientId;
					index++;
				}
			}

			if(patientIds[0] == 'undefined' || patientIds[0] == null) patientIds[0] = '';
			
			if(patientIds[0] != ''){
				var xmlDoc=""
				var xmlHttp = new XMLHttpRequest()
				xmlStr = "<root><SEARCH patient_id=\""+patientIds[0]+"\" action='getPatDeceasedYN' /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../jsp/DRIntermediate.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText = xmlHttp.responseText
				var first_pat_deceased_yn = trimString(responseText);

				if(first_pat_deceased_yn == 'Y' && sel_pat_deceased_yn == 'N'){
					document.forms[0].patient_id.select();
					document.forms[0].patient_id.focus();			
					var ErrorText = getMessage("ENTER_ONLY_DECEASED_PATIENT","DR");			
					parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
					return false;
				}else if(first_pat_deceased_yn == 'N' && sel_pat_deceased_yn == 'Y'){
					document.forms[0].patient_id.select();
					document.forms[0].patient_id.focus();			
					var ErrorText = getMessage("ENTER_ONLY_VALID_PATIENT","DR");			
					parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
					return false;
				}
			}
		}
		/*End ML-MMOH-CRF-1815*/
	}
	//parent.parent.frames[1].frames[0].location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?patient_id='+p_patient_id+'&p_string_val='+p_string_oldval+'&function_name='+function_name;
		 //parent.parent.frames[2].location.href='../../eDR/jsp/ValidatePopulatePatient.jsp?Patient_ID='+p_patient_id;
	   var xmlDoc="";
	   var xmlHttp = new XMLHttpRequest();
	   xmlStr ="<root><SEARCH Patient_ID=\""+p_patient_id+"\"  function_id='ENTER_DUPLICATES' /></root>";
	   xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
	   xmlHttp.open("POST","ValidatePopulatePatient.jsp",false) ;
	   xmlHttp.send(xmlDoc) ;
	   responseText=xmlHttp.responseText;
	   responseText = trimString(responseText) ;
//	   alert("responseText==>" +responseText)
	   eval(responseText);
	}
}

function callPatientSearch(function_name)
{
	
//	var p_patient_id = PatientSearch('','','','','','','','','','','DR_ENTER_DUPLICATES');
	
	//Modified by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
	var p_patient_id = "";
	var isMergeDeceasedPatIdAppl = parent.parent.frames[1].frames[0].document.forms[0].isMergeDeceasedPatIdAppl.value;
	if(isMergeDeceasedPatIdAppl == 'true'){
		p_patient_id = await PatientSearch('','','','','','','Y','','','VIEW');
	}else{
	 p_patient_id = await PatientSearch();
	}
    p_string_val = parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value;
    p_flag_value = parent.parent.frames[1].frames[0].document.forms[0].p_flag_value.value;
	
	//var ch=parent.frames[0].document.forms[0].record.value;
//parent.parent.frames[1].frames[0].location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?patient_id='+p_patient_id+'&function_name='+function_name+'&p_string_val='+p_string+'&val&record='+ch;
parent.parent.frames[1].frames[0].location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?patient_id='+p_patient_id+'&p_flag_value='+p_flag_value+'&function_name='+function_name+'&p_string_val='+encodeURIComponent(p_string_val);
}


function callDetails(function_name)
{
	var p_before_dup ;
	

	p_patient_id = parent.parent.frames[1].frames[0].document.forms[0].patient_id.value;
	p_remarks_test    = parent.parent.frames[1].frames[0].document.forms[0].remarks.value;
	

	if (p_patient_id.length==0 )
	{
		
		var ErrorText = getMessage('CAN_NOT_BE_BLANK','Common');
		ErrorText = ErrorText.replace("$",getLabel("Common.patientId.label","Common"));
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	}
	else if (p_remarks_test.length==0)
	{
		var ErrorText = getMessage('REMARKS_CANNOT_BE_BLANK','DR');
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	}
	else if (p_remarks_test.length >500)
	{
		var ErrorText = getMessage('REMARKS_NOT_EXCEED_500_CH','DR');
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	}
	else
	{
		var ErrorText = '';
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

		p_dup_ind    = parent.parent.frames[1].frames[0].document.forms[0].dup_ind.value;
		remarks      = parent.parent.frames[1].frames[0].document.forms[0].remarks.value;

		p_string_val = parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value ;
		p_before_dup = p_string_val;
		
		if (p_string_val == null)
		{
			p_string_val = '';
		}

		p_string_val = p_string_val + p_patient_id + '`' + p_dup_ind + '`' + remarks + '~' ;
     			
		parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value = p_string_val;

		parent.parent.frames[1].frames[2].location.href="../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?p_string_val="+encodeURIComponent(p_string_val)+"&p_mode=add&check=Show&p_before_dup="+p_before_dup+"&function_name="+function_name;
//		parent.parent.frames[1].frames[0].location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?p_string_val='+p_string_val+'&function_name='+function_name;
	}
}

function modifyDetails(function_name,dup_group_id)
{
		
	p_old_val = parent.parent.frames[1].frames[0].document.forms[0].p_string_old_value.value;
	
	p_patient_id = parent.parent.frames[1].frames[0].document.forms[0].patient_id.value;
	p_remarks_test  = parent.parent.frames[1].frames[0].document.forms[0].remarks.value;
	
	if (p_patient_id.length==0 )
	{
		var ErrorText = getMessage('SHOULD_NOT_BE_BLANK','Common');
		if(function_name=="insert"){
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
		else{
			parent.parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
	}
	else if (p_remarks_test.length==0)
	{
		var ErrorText = getMessage('REMARKS_CANNOT_BE_BLANK','DR');
		//parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		if(function_name=="insert"){
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
		else{
		parent.parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
	}
	else if (p_remarks_test.length >500)
	{
		var ErrorText = getMessage('REMARKS_NOT_EXCEED_500_CH','DR');
		if(function_name=="insert"){
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
		else{
			parent.parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}

	}
	else
	{
		
		var ErrorText = '';
		//parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		if(function_name=="insert")
		{
		parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}
		else
		{
		parent.parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		}

		p_dup_ind    = parent.parent.frames[1].frames[0].document.forms[0].dup_ind.value;
		remarks      = parent.parent.frames[1].frames[0].document.forms[0].remarks.value;
		p_string_newval = parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value ;

		p_string_newval = p_patient_id + '`' + p_dup_ind + '`' +remarks+ '~' ;
		p_string_val = 	parent.parent.frames[1].frames[2].document.forms[0].p_string_old_val_new.value;	
		
		p_string_newval = encodeURIComponent(p_string_newval);
		p_string_val = encodeURIComponent(p_string_val);
		p_old_val = encodeURIComponent(p_old_val);
      
		parent.parent.frames[1].frames[1].location.href = "../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_string_newval="+p_string_newval+"&p_string_value="+p_string_val+"&p_old_value="+p_old_val+"&function_name="+function_name+"&p_dup_group_id="+dup_group_id;
	
		parent.parent.frames[1].frames[0].document.forms[0].dup_ind.focus();

	}
}

function callHeader(p_patient_id,p_dup_ind,p_remarks)
{
	p_string_val = 	parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value;
	
	p_old_val = p_patient_id + '`' + p_dup_ind + '`' + p_remarks + '~' ;

	parent.parent.frames[1].frames[0].location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?p_string_val='+p_string_val+'&patient_id='+p_patient_id+'&p_dup_ind='+p_dup_ind+'&p_mode=mod'+'&p_remarks='+p_remarks+'&p_old_val='+p_old_val;	

	p_string_val = 	parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value;

	p_old_val = p_patient_id + '`' + p_dup_ind + '`' + p_remarks + '~' ;

	parent.parent.frames[1].frames[0].document.forms[0].p_string_old_value.value = p_old_val;

}

function callHeaderScreen(p_patient_id,p_dup_ind,p_no,function_name,dup_group_id)
{	 
	   p_string_val = parent.parent.frames[1].frames[1].document.forms[0].for_mod_val.value ;
	   p_remarks = eval("document.forms[0].remarks"+p_no).value;
   	   parent.parent.frames[1].frames[0].location.href = "../../eDR/jsp/EnterDuplicatesAddPatId.jsp?p_string_val="+encodeURIComponent(p_string_val)+"&patient_id="+p_patient_id+"&p_dup_ind="+p_dup_ind+"&p_mode=mod"+"&p_remarks="+encodeURIComponent(p_remarks)+"&p_old_val="+p_patient_id + "`" + p_dup_ind + "`" +encodeURIComponent(p_remarks) +"~" +"&function_name="+function_name+"&p_dup_group_id="+dup_group_id+"&pat_click=Y";	
}

function changeDupIndicator(p_patient_id,p_dup_ind,p_remarks,dupval)
{
	var test ;
	test = p_patient_id + '`' + p_dup_ind + '`' + p_remarks + '`' + dupval + '~';

		p_string_newval = p_patient_id + '`' + dupval + '`' + p_remarks + '~' ;

		p_old_val = p_patient_id + '`' + p_dup_ind + '`' + p_remarks + '~' ;

		p_string_val = 	parent.parent.frames[1].frames[2].document.forms[0].p_string_old_val_new.value;

		parent.parent.frames[1].frames[1].location.href = '../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_string_newval='+p_string_newval+'&p_string_value='+p_string_val+'&p_old_value='+p_old_val;
	
		parent.parent.frames[1].frames[0].location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?p_string_val='+p_string_val+'&patient_id='+p_patient_id+'&p_dup_ind='+dupval+'&p_mode=mod'+'&p_remarks='+p_remarks+'&p_old_val='+p_old_val;	


}


function apply()
{
	if (! (checkIsValidForProceed(enterDuplicatePatients)) )
    {
		
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
        return false;
    }	
	
	 var p_function_name = frames[1].frames[0].document.forms[0].function_name.value;	
      	if(p_function_name !="modify") p_function_name="insert";
	
	//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
	var merge_reason_yn = "";
	var requested_by_yn = "";
	var merge_reason = "";
	var requested_by_name = "";
	var requested_by = "";
	var fields = new Array();
	var names = new Array();
		
	 if(p_function_name == "insert" )	
	 { 	
				 		
		var p_string_val = frames[1].frames[2].document.forms[0].p_string_val.value ;
       
		if(p_string_val!="")	
		{
			p_no_of_records = frames[1].frames[2].document.forms[0].no_of_records.value ;
		}
		else
			p_no_of_records="";	      
		
		//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
		merge_reason_yn = frames[1].frames[2].document.forms[0].merge_reason_yn.value;
		requested_by_yn = frames[1].frames[2].document.forms[0].requested_by_yn.value;
		merge_reason = frames[1].frames[2].document.forms[0].merge_reason.value;
		requested_by_name = frames[1].frames[2].document.forms[0].requested_by_name.value;
		requested_by = frames[1].frames[2].document.forms[0].requested_by.value;
	 }	
	 else if(p_function_name == "modify")
	 {
		if (! (checkIsValidForProceed(frames[1].frames[1])))
		{ 
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
			return false;
		}
		else 
			var p_string_val = frames[1].frames[1].frames[2].document.forms[0].p_string_val.value ;
			if(p_string_val!="")	
				p_no_of_records = frames[1].frames[1].frames[2].document.forms[0].no_of_records.value ;
			else
				p_no_of_records="";

		//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
		merge_reason_yn = frames[1].frames[1].frames[2].document.forms[0].merge_reason_yn.value;
		requested_by_yn = frames[1].frames[1].frames[2].document.forms[0].requested_by_yn.value;
		merge_reason = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
		requested_by_name = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;			
		requested_by = frames[1].frames[1].frames[2].document.forms[0].requested_by.value;

		if(requested_by_name == ""){
			requested_by = "";
		}
	 }
	 
	if(p_function_name == "insert")
	{
	frames[1].frames[0].document.forms[0].p_pat_count.value = p_no_of_records;
	//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
	frames[1].frames[0].document.forms[0].merge_reason.value = merge_reason;
	frames[1].frames[0].document.forms[0].requested_by.value = requested_by;
	}
	
	else if(p_function_name == "modify")
	{
		frames[1].frames[1].frames[0].document.forms[0].p_pat_count.value = p_no_of_records;		
		//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
		frames[1].frames[1].frames[0].document.forms[0].merge_reason.value = merge_reason;		
		frames[1].frames[1].frames[0].document.forms[0].requested_by.value = requested_by;
	}
	var p_D_position =0;
	var p_V_position =0;	

	if (p_function_name == 'insert')
	{
			var p_previous_patient = '';
			var p_current_patient ='';
			var for_submit = true;
			
			var p_previous_patient_flag = '';
			var p_previous_patient_value= '';
			var p_current_patient_flag ='';
			var p_position = 0;
			var p_check_patient_id1 = 'first';
			var p_check_patient_id2 = 'second';

			if (for_submit==true)
			{

			/*
					if(p_no_of_records-1==p_no_of_records_to_delete){ 
					var ErrorText = getMessage("ATLEAST_ONE_VALID_EXISTS","DR");
					document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
					for_submit=false;		}	
					
					if (p_no_of_records < 2)
					{					
						var ErrorText = getMessage("MINIMUM_TWO_PATIENTS","DR");
						document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
						for_submit=false;
					}
			*/
			}

		if (for_submit==true)
		{
			for(var counter=1;counter<=p_no_of_records;counter++)
			{
				if (for_submit){
					p_check_patient_id1 = eval("frames[1].frames[2].document.forms[0].patient_id"+counter+".value");
					for (var counter1=1;counter1<=p_no_of_records;counter1++ )
					{
					  if (counter1!=counter)
					  {
						p_check_patient_id2 = eval("frames[1].frames[2].document.forms[0].patient_id"+counter1+".value");               
						if (p_check_patient_id1 == p_check_patient_id2)
						{
							var ErrorText = getMessage("DUPLICATE_PATIENT_ENTRY","DR");
							document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
							for_submit=false;
							break;
						}
					  }
					}							
				}
				else
					break;
			}	
		}

		if (for_submit == true)
		{
			
			for(var counter=1;counter<=p_no_of_records;counter++)
			{
				p_previous_patient_flag = eval("frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value") ;

				if (p_previous_patient_flag == 'D')
				{
					p_D_position++;
				}
				else
				{
					p_V_position++;
				}

			}

			if(p_V_position==0)
			{
				var ErrorText = getMessage("ATLEAST_ONE_VALID","DR");
				document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
				for_submit=false;
			}
			else if(p_V_position>1)
			{
				var ErrorText = getMessage("ONLY_ONE_MAIN","DR");
				document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
				for_submit=false;
			}
			else if(p_V_position == 1)
			{
				if(p_D_position <1)
				{
					var ErrorText = getMessage("ATLEAST_ONE_DUPLICATE","DR");
					document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
					for_submit=false;
				}
			}	
			
		}
  
		
		if (for_submit==true)
		{ 			
			//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
			if(merge_reason_yn == "Y" && requested_by_yn == "Y"){
				if(merge_reason == "" && requested_by_name == ""){
					fields[0] = frames[1].frames[2].document.forms[0].merge_reason.value;
					fields[1] = frames[1].frames[2].document.forms[0].requested_by_name.value;
					names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
					names[1] = getLabel("Common.RequestedBy.label","Common");
				}else if(merge_reason == ""){
					fields[0] = frames[1].frames[2].document.forms[0].merge_reason.value;
					names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
				}else if(requested_by_name == ""){
					fields[0] = frames[1].frames[2].document.forms[0].requested_by_name.value;
					names[0] = getLabel("Common.RequestedBy.label","Common");
				}
			}else if(merge_reason_yn == "Y" && merge_reason == ""){
				fields[0] = frames[1].frames[2].document.forms[0].merge_reason.value;
				names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
			}else if(requested_by_yn == "Y" && requested_by_name == ""){
				fields[0] = frames[1].frames[2].document.forms[0].requested_by_name.value;
				names[0] = getLabel("Common.RequestedBy.label","Common");
			}

			if(checkFields(fields, names, messageFrame)){
			frames[1].frames[0].document.forms[0].submit();
			}
		}
	}
	else if (p_function_name == 'modify')
	{
			var p_del_string_val = '';
			var p_check_for_delete = '';
			var p_previous_patient_flag = '';
			var p_previous_patient_value = '';
			var p_current_patient_flag ='';
			var p_loop_for_valid_check = false;
			var p_dup_group_id ='';
			var p_no_of_records_to_delete = 0;
			var p_position = 0;
			var for_submit=true;

		
			p_dup_group_id = frames[1].frames[1].frames[2].document.forms[0].dupgroupid.value;       
			frames[1].frames[1].frames[0].document.forms[0].dupgroupid.value = p_dup_group_id; 

			p_D_position =0;
			p_V_position =0;
       
			for(var counter=1;counter<=p_no_of_records;counter++) {				
				p_previous_patient_flag = eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value") ;
				if (p_previous_patient_flag == 'D') {					
					p_D_position++;
				} else {
					p_V_position++;
				}
			}


		if (for_submit==true)
		{	
			for(var counter=1;counter<=p_no_of_records;counter++)
			{				
				p_check_for_delete = eval("frames[1].frames[1].frames[2].document.forms[0].deletePatient"+counter+".checked") ;
			
				if (p_check_for_delete)
				{					
				p_del_string_val = p_del_string_val + eval("frames[1].frames[1].frames[2].document.forms[0].patient_id"+counter+".value") + '`' + eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value") + '`' + eval("frames[1].frames[1].frames[2].document.forms[0].remarks"+counter+".value") + "~" ;
				
				p_no_of_records_to_delete = p_no_of_records_to_delete + 1;        
					
				if(eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value")== 'V')
				{
					p_V_position--;						
				}
				else if(eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value")== 'D')
				{
					p_D_position--;						
				}
				}
			}

	
			var delete_all = false;
			if(p_no_of_records_to_delete != 0) {
				if(p_V_position == p_no_of_records - p_no_of_records_to_delete  ) {					
					for(var c=1;c<=p_no_of_records;c++) {
						if(eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+c+".value") == 'V') {
							p_del_string_val = p_del_string_val + eval("frames[1].frames[1].frames[2].document.forms[0].patient_id"+c+".value") + '`' + eval("frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+c+".value") + '`' + eval("frames[1].frames[1].frames[2].document.forms[0].remarks"+c+".value")+"~" ;
							p_no_of_records_to_delete = p_no_of_records_to_delete + 1;
							delete_all = true;
					   }
        		    }
			    }
			}
			if((p_V_position==0) && (p_no_of_records_to_delete == 0))	{
				var ErrorText = getMessage("ATLEAST_ONE_VALID","DR");
				document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
				for_submit=false;
			} else if(p_V_position>1) {
				var ErrorText = getMessage("ONLY_ONE_MAIN","DR");
				document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
				for_submit=false;
			} else if(p_V_position == 1) {
				if(p_D_position <1) 	{
					var ErrorText = getMessage("ATLEAST_ONE_DUPLICATE","DR");
					document.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
					for_submit=false;
				}
			}	



			    var p_pat_count=p_no_of_records - p_no_of_records_to_delete;			
				frames[1].frames[1].frames[0].document.forms[0].p_pat_count.value = p_pat_count;
				frames[1].frames[1].frames[0].document.forms[0].delete_string.value = p_del_string_val ;
				p_string_val = 	frames[1].frames[1].frames[2].document.forms[0].p_string_old_val_new.value;
				frames[1].frames[1].frames[0].document.forms[0].p_string_value.value = p_string_val;

				if (delete_all==true) {				
					for_submit = false;
					if (confirm(getMessage("DELETE_BOTH_MAIN_AND_DUPLICATE","DR"))) {  
						frames[1].frames[1].frames[0].document.forms[0].mode.value = 'update';		
						frames[1].frames[1].frames[0].document.forms[0].submit();		
						frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode=modify';						
					}
				else
					parent.parent.parent.frames[2].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_num= ";
				}

		}


		if (for_submit==true)
		{
			if(p_no_of_records_to_delete == 0) {
				//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
				if(merge_reason_yn == "Y" && requested_by_yn == "Y"){
					if(merge_reason == "" && requested_by_name == ""){
						fields[0] = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
						fields[1] = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;
						names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
						names[1] = getLabel("Common.RequestedBy.label","Common");
					}else if(merge_reason == ""){
						fields[0] = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
						names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
					}else if(requested_by_name == ""){
						fields[0] = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;
						names[0] = getLabel("Common.RequestedBy.label","Common");
					}
				}else if(merge_reason_yn == "Y" && merge_reason == ""){
					fields[0] = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
					names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
				}else if(requested_by_yn == "Y" && requested_by_name == ""){
					fields[0] = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;
					names[0] = getLabel("Common.RequestedBy.label","Common");
				}

				if(checkFields(fields, names, messageFrame)){
					frames[1].frames[1].frames[0].document.forms[0].mode.value = 'update';	
					frames[1].frames[1].frames[0].document.forms[0].submit();		
					frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode=modify';
				}
			} else {
	
			if (confirm(getMessage("DELETE_RECORD","Common"))) {  
				//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
				if(merge_reason_yn == "Y" && requested_by_yn == "Y"){
					if(merge_reason == "" && requested_by_name == ""){
						fields[0] = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
						fields[1] = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;
						names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
						names[1] = getLabel("Common.RequestedBy.label","Common");
					}else if(merge_reason == ""){
						fields[0] = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
						names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
					}else if(requested_by_name == ""){
						fields[0] = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;
						names[0] = getLabel("Common.RequestedBy.label","Common");
					}
				}else if(merge_reason_yn == "Y" && merge_reason == ""){
					fields[0] = frames[1].frames[1].frames[2].document.forms[0].merge_reason.value;
					names[0] = getLabel("eDR.Merge.label","DR")+" "+getLabel("Common.reason.label","Common");
				}else if(requested_by_yn == "Y" && requested_by_name == ""){
					fields[0] = frames[1].frames[1].frames[2].document.forms[0].requested_by_name.value;
					names[0] = getLabel("Common.RequestedBy.label","Common");
				}

				if(checkFields(fields, names, messageFrame)){
					frames[1].frames[1].frames[0].document.forms[0].mode.value = 'update';		
					frames[1].frames[1].frames[0].document.forms[0].submit();		
					frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode=modify';
				}
			}
			else
				parent.parent.parent.frames[2].frames[2].location.href ="../../eCommon/jsp/error.jsp?err_num= ";
			}

		}

	}


}


function callGroupDetails(p_patient_id,p_dup_group_id,p_pat_count,function_name)
{

parent.parent.frames[1].frames[2].location.href='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?p_dup_group_id='+p_dup_group_id+'&function_name='+function_name+'&check=Show';
}



function changeRowColor1(obj,n)
{
	for(i=0;i<n;i++)
		parent.parent.frames[1].frames[0].document.getElementById("tb1").rows(prev).cells(i).style.backgroundColor=obj.bgColor;
	for(i=0;i<n;i++)
		obj.cells(i).style.backgroundColor="#B2B6D7";
	prev	=obj.rowIndex;
	

}
async function callPatientSearch1()
{
	/*var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
*/

	//Modified by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
	var p_patient_id = "";

	var isMergeDeceasedPatIdAppl = parent.frames[0].document.forms[0].isMergeDeceasedPatIdAppl.value;

	if(isMergeDeceasedPatIdAppl == 'true'){
		p_patient_id = await PatientSearch('','','','','','','Y','','','VIEW');
	}else{
		p_patient_id = await PatientSearch();
	}

	if (p_patient_id != null)
	{
		document.location.href='../../eDR/jsp/EnterDuplicateQueryCriteria.jsp?patient_id='+p_patient_id;

	}
	/*else
	{
			var ErrorText = getMessage('PATIENT_NOT_SELECTED');
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	}
}*/
}
function callResult()
{
	var mode=parent.frames[0].document.forms[0].mode.value;
	var patient_id=	parent.frames[0].document.forms[0].patient_id1.value;
	
parent.frames[1].location.href='../../eDR/jsp/DfltSearchCriteriaMenu.jsp?mode=first&patient_id='+patient_id;
}

function callPatientLine1(obj,function_name)
{
	obj.value = obj.value.toUpperCase();
	p_patient_id = obj.value ;

	if (p_patient_id.length>0)
	{
		
	   var xmlHttp = new XMLHttpRequest();
	   xmlStr ="<root><SEARCH Patient_ID9=\""+p_patient_id+"\" step='1' function_id='ENTER_DUPLICATES1' /></root>";
	   var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	   xmlHttp.open("POST","ValidatePopulatePatient.jsp",false);

	   xmlHttp.send(xmlDoc);
	   responseText=xmlHttp.responseText;
	   responseText = trimString(responseText);
	   eval(responseText);
	}
}


function callClear()
{
	
	var patient_id=	parent.frames[0].document.forms[0].patient_id1.value='';
	document.forms[0].search.disabled=false;
	parent.parent.frames[1].frames[1].frames[2].location.href='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?p_mode=add+&function_name=modify';
	//parent.parent.frames[1].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
	/*if(parent.frames[0].document.forms[0].merge.checked==true)
	{

parent.frames[0].document.forms[0].merge.checked=false;
}*/
//var err_num='';
//parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
//parent.parent.frames[1].frames[2].location.href='../../eCommon/html/blank.html';
//parent.frames[1].location.href='../../eCommon/html/blank.html';
parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num= ';
parent.frames[0].document.forms[0].patient_id1.select();
parent.frames[0].document.forms[0].patient_id1.focus();
}


// this is called when the previous button is pressed	
function call_previous(startVar,endVar){
var start=parent.frames[1].document.forms[0].start.value;
var end=parent.frames[1].document.forms[0].end.value;
var patient_id=parent.frames[0].document.forms[0].patient_id.value;

if(start=="")start="0";
if(end=="")end="0";
if(startVar=="")startVar="0";
if(endVar=="")endVar="0";

parent.frames[1].document.location.href='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?from='+(parseInt(start)-parseInt(endVar))+"&to="+(parseInt(end)-parseInt(endVar))+"&patient_id="+patient_id+"&criteria=query";  
}

// this is called when the next button is pressed
function call_next(startVar,endVar){
var start=parent.frames[1].document.forms[0].start.value;
var end=parent.frames[1].document.forms[0].end.value;
var patient_id=parent.frames[0].document.forms[0].patient_id.value;
if(start=="")start="0";
if(end=="")end="0";
if(startVar=="")startVar="0";
if(endVar=="")endVar="0";

parent.frames[1].document.location.href="../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?from="+(parseInt(start)+parseInt(endVar))+"&to="+(parseInt(end)+parseInt(endVar))+"&patient_id="+patient_id+"&criteria=query";  
}

// this is called when the search button is pressed
function call_search(startVar,endVar){
var patient_id=parent.frames[0].document.forms[0].patient_id.value;
parent.frames[1].document.location.href="../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?from="+startVar+"&to="+endVar+"&patient_id="+patient_id+"&criteria=query"; 
}


// this function is called on load of the valid patient frame

function button_disable(start,end,max_record,startVar,endVar){
if(parseInt(max_record) > 0){ // if there is no record next and previous should not be enabled
		//cond:1
		if((parseInt(start)==parseInt(startVar)) && (parseInt(end)< parseInt(max_record))) {
				parent.frames[0].document.forms[0].previous.disabled=true;
				parent.frames[0].document.forms[0].next.disabled=false;
			}
		//cond:2
		if(parseInt(start)==parseInt(startVar) && parseInt(end) >= parseInt(max_record)) {
				parent.frames[0].document.forms[0].previous.disabled=true;
				parent.frames[0].document.forms[0].next.disabled=true;
		}
		//cond:3
		 if((parseInt(start)>parseInt(endVar) )&& (parseInt(end) < parseInt(max_record)) ){
					parent.frames[0].document.forms[0].previous.disabled=false;
					parent.frames[0].document.forms[0].next.disabled=false;
		}
		//cond:4
		if((parseInt(start)>parseInt(endVar) )&&(parseInt(end) >= parseInt(max_record))){
				parent.frames[0].document.forms[0].previous.disabled=false;
				parent.frames[0].document.forms[0].next.disabled=true;
		}


	} else {if(parseInt(max_record) <= 0){
				parent.frames[0].document.forms[0].previous.disabled=true;
				parent.frames[0].document.forms[0].next.disabled=true;
			}
	}

	
}
		
				//HTMLVal = "<html><BODY onKeyDown='lockKey();'><form name='EnterDuplicateAddModDel' id='EnterDuplicateAddModDel' method='post' action='../../eDR/jsp/EnterDuplicateAddModDel.jsp'>"+
					  "<input name='p_string_newval' id='p_string_newval' type='hidden' value="+p_string_newval+"><input name='p_string_value' id='p_string_value' value="+p_string_val+" type='hidden'><input name='p_old_value' id='p_old_value' value="+p_old_val+" type='hidden'></form></BODY></HTML>";
			//parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			//parent.parent.frames[2].document.EnterDuplicateAddModDel.submit();

		//p_string_val = parent.parent.frames[1].frames[1].document.forms[0].p_string_old_val_new.value ;

//parent.parent.frames[1].frames[1].location.href='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?p_string_val='+p_string_val+'&p_mode=add';

/*			for(var counter=1;counter<=p_no_of_records;counter++)
			{

				if (p_previous_patient.length == 0)
				{	
					p_previous_patient = eval("parent.parent.frames[1].frames[1].frames[2].document.forms[0].patient_id"+counter+".value") ;
				}
				else
				{
					p_current_patient = eval("parent.parent.frames[1].frames[1].frames[2].document.forms[0].patient_id"+counter+".value") ;
						if (p_previous_patient == p_current_patient)
						{
							
							for_submit=false;
						}
						else
						{
							for_submit=true;
						}
				}
			}*/


		/*	if (for_submit == true)
			{
			for(var counter=1;counter<=p_no_of_records;counter++)
			{

				if (p_previous_patient_flag.length == 0)
				{	
					p_previous_patient_flag = eval("parent.parent.frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value") ;
				}
				else
				{
					p_current_patient_flag = eval("parent.parent.frames[1].frames[1].frames[2].document.forms[0].dup_indicator"+counter+".value") ;
						if (p_previous_patient_flag == p_current_patient_flag)
						{
							
							for_submit=false;
						}
						else
						{
							for_submit=true;
						}
				}
			}

			}
		*/

function reset()
{
	if (! (checkIsValidForProceed(enterDuplicatePatients)) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
        return false;
    }
	var xxx=parent.parent.frames[2].frames[1].frames[0].name;
	if(xxx=='criteria')
	{
	
		parent.parent.frames[2].frames[1].frames[0].document.forms[0].reset();
		parent.parent.parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
		parent.parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		
			}
	else
		{
	   var flag='create'; 
	   parent.frames[2].frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode='+"addition"+'&flag='+flag;
	  // parent.frames[2].frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode=addition';
	//parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	var p_function_name = parent.parent.frames[2].frames[1].frames[0].document.forms[0].function_name.value;

//	{
		parent.parent.frames[2].frames[1].frames[0].document.forms[0].reset();
		parent.parent.frames[2].frames[1].frames[2].document.forms[0].reset();
		parent.parent.frames[2].frames[1].frames[1].location.href='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?check=Show&p_mode=add+&function_name=insert'
//	}
	}
}

function onSuccess()
{	

 var xxx=parent.parent.frames[2].frames[1].frames[0].name;
 if(xxx=='criteria')
	{
	 parent.parent.frames[2].frames[1].frames[0].location.href="../../eDR/jsp/EnterDuplicateQueryCriteria.jsp?function_name=modify";
	// parent.parent.parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
	 parent.parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	}
     else
	{
		 parent.frames[2].frames[1].location.href='../../eDR/jsp/EnterDuplicatePatientIDManual.jsp?p_mode=addition';
	
	    var p_function_name = parent.parent.frames[2].frames[1].frames[0].document.forms[0].function_name.value;


		parent.parent.frames[2].frames[1].frames[0].document.forms[0].reset();
		parent.parent.frames[2].frames[1].frames[2].document.forms[0].reset();
		parent.parent.frames[2].frames[1].frames[1].location.href='../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?check=Show&p_mode=add+&function_name=insert'
	}
}


async function viewPatientDetails(p_patient_id)
{

	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "100" ;
	var dialogWidth	= "100" ;
	var dialogTop="0";
	var dialogLeft="1";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight +"vh; dialogWidth:" + dialogWidth+ "vw; dialogLeft:" +dialogLeft+ "px; dialogTop:" +dialogTop+ "px; status=no" ;
	var p_string_val = parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value;
	parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value=p_string_val ;
	await window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}





function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}

function chkLength(Obj)
{
	if(Obj.value.length >500)
	{
		alert(getMessage('REMARKS_NOT_EXCEED_500_CH','DR'));
		Obj.focus();
	}
}

function cancelDetails(function_name,dup_group_id)
{
  var function_name=document.forms[0].function_name.value;
    var chkcancel=parent.parent.frames[1].frames[2].document.forms[0].chkcancel.value
 if(chkcancel>0)
	{
if (document.forms[0].function_name.value=="insert")
{
	document.forms[0].reset();
		var p_dup_ind    = parent.parent.frames[1].frames[0].document.forms[0].dup_ind.value;
		var remarks      = parent.parent.frames[1].frames[0].document.forms[0].remarks.value;
		var p_string_newval = parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value ;
		var p_patient_id = parent.parent.frames[1].frames[0].document.forms[0].p_patient_id.value ;

		var p_string_newval = p_patient_id + '`' + p_dup_ind + '`' + remarks + '~' ;
		var p_string_val = 	parent.parent.frames[1].frames[2].document.forms[0].p_string_old_val_new.value;
		var p_flag_value = 	document.forms[0].p_flag_value.value;
	 	document.location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?function_name=insert&p_flag_value='+encodeURIComponent(p_flag_value);
	//document.location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?p_string_val ='+encodeURIComponent(p_string_val) ;
	
		parent.parent.frames[1].frames[1].location.href = '../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_string_newval='+encodeURIComponent(p_string_newval)+'&p_string_value='+encodeURIComponent(p_string_val)+'&p_old_value='+encodeURIComponent(p_old_val)+'&function_name='+function_name+'&p_dup_group_id='+dup_group_id;
        
	/* document.forms[0].patient_id.value="";
     document.getElementById('pat_name').innerHTML="&nbsp;";
     document.forms[0].dup_ind.value="V";
      document.forms[0].remarks.value=""; */

}
else{ 		
		 document.location.reload();
	  /* document.forms[0].reset();
		var p_dup_ind    = parent.parent.frames[1].frames[0].document.forms[0].dup_ind.value;
		var remarks      = parent.parent.frames[1].frames[0].document.forms[0].remarks.value;
    	var p_string_newval = parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value ;

		var p_string_newval = p_patient_id + '`' + p_dup_ind + '`' + remarks + '~' ;
		var p_string_val = 	parent.parent.frames[1].frames[2].document.forms[0].p_string_old_val_new.value;
		document.location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?function_name=modify';
		 parent.parent.frames[1].frames[1].location.href = '../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_string_newval='+encodeURIComponent(p_string_newval)+'&p_string_value='+encodeURIComponent(p_string_val)+'&p_old_value='+encodeURIComponent(p_old_val)+'&function_name='+function_name+'&p_dup_group_id='+dup_group_id;*/
	/*	document.forms[0].patient_id.value="";
		document.forms[0].all.pat_name.innerHTML="&nbsp;";
		document.forms[0].dup_ind.value="V";
		document.forms[0].remarks.value=""; */
		 /*parent.parent.frames[1].frames[1].location.href = '../../eDR/jsp/EnterDuplicateAddModDel.jsp?function_name='+function_name+'&p_dup_group_id='+dup_group_id+'&Patient_ID='+p_patient_id;*/
			 }
	}
	   else
		document.location.href='../../eDR/jsp/EnterDuplicatesAddPatId.jsp?function_name=insert'
	   //parent.parent.parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
       
    }



	function CheckForAlphaCharsRemarks(event){ 

	var strCheck = '~`';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		//return (event.keyCode -= 32);
	return true ;
}  

//Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102
async function searchCode(obj,target)
{
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var tit = getLabel("Common.RequestedBy.label","Common");

	var sql = "SELECT appl_user_id code, appl_user_name description FROM sm_appl_user WHERE eff_status = 'E' AND UPPER (appl_user_id) LIKE UPPER (NVL (?, appl_user_id)) AND UPPER (appl_user_name) LIKE UPPER (NVL (?, appl_user_name)) ORDER BY 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	var retVal = await CommonLookup(tit,argumentArray);

	if(retVal==null || retVal==""){
		obj.value = "";
		target.value = "";
	}else{
		var ret = unescape(retVal);
		arr = ret.split(",");
		obj.value = arr[0];
		target.value = arr[1];
	}
}

