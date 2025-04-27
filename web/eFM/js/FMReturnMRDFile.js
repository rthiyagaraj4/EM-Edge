/*var  added_volumes  = new ActiveXObject("Scripting.Dictionary");
var  added_records  = new ActiveXObject("Scripting.Dictionary");
var  p_file_volu_val     = new ActiveXObject("Scripting.Dictionary");

var added_patfile_vol = new ActiveXObject("Scripting.Dictionary");
var added_rem_remarks= new ActiveXObject("Scripting.Dictionary");*/
let addedVolumes = new Map();
let addedRecords = new Map();
let pFileVoluVal = new Map();

let addedPatfileVol = new Map();
let addedRemRemarks = new Map();
function addFiles(vol_cnt)
{
    var accept_out_intransit_yn = parent.frames[1].document.getElementById("accept_out_intransit_yn").value;
	var doc_or_file			= parent.frames[2].document.forms[0].doc_or_file.value;
	var p_fs_location		= parent.frames[2].document.forms[0].p_out_fsloc.value;
	var p_file_stat			= parent.frames[1].document.forms[0].FILE_STAT.value;
	var accept_out_intransit_yn	= parent.frames[1].document.forms[0].accept_out_intransit_yn.value;
    var p_stored_val                 =parent.frames[2].document.forms[0].p_stored_val.value;
	var flag                         =parent.frames[2].document.forms[0].flag.value;
	var un_defcny            =parent.frames[2].document.forms[0].un_defcny.value;
	var  p_stored_val_old="";
	var patientid=parent.frames[2].document.forms[0].patientid.value; 
	var fileno=parent.frames[2].document.forms[0].fileno.value; 
	var volno=parent.frames[2].document.forms[0].volno.value; 
	var volume_no1 = parent.frames[2].document.forms[0].volume_no.value;
	var p_out_fcy =document.forms[0].p_out_fcy.value;
    var patient_id=parent.frames[2].document.forms[0].patient_id.value;
	var patfilevolno_new="";
   	var patfilevolno_old="";
	var errors = "";
	var messag = "";
    var file_num="";
   var buttonVal ="A";
   
	
	if(doc_or_file == 'D') 
	{
			
		/*if(accept_out_intransit_yn == "Y")
		{
		var fields = new Array (parent.frames[1].document.forms[0].p_curr_fs_loc, parent.frames[2].document.forms[0].doc_folder_id, parent.frames[2].document.forms[0].doc_type_id,parent.frames[1].document.forms[0].FILE_STAT);
		var names = new Array (getLabel("eFM.ReceivingFSLocation.label","FM"), getLabel("eFM.DocumentFolder.label","FM"), getLabel("Common.documenttype.label","common"),getLabel('eFM.FileStatus.label','FM'));
		}
		else
		{*/
			var fields = new Array (parent.frames[1].document.forms[0].p_curr_fs_loc, parent.frames[2].document.forms[0].doc_folder_id, parent.frames[2].document.forms[0].doc_type_id);
			var names = new Array (getLabel("eFM.ReceivingFSLocation.label","FM"), getLabel("eFM.DocumentFolder.label","FM"), getLabel("Common.documenttype.label","common"));
		//}
	}
	else if(doc_or_file == 'F') 
	{
		if (parent.frames[2].document.forms[0].file_type_appl_yn.value == "N") 
		{
			
			/*if(accept_out_intransit_yn == "Y")
			{
			var fields = new Array (parent.frames[1].document.forms[0].p_curr_fs_loc, parent.frames[2].document.forms[0].patient_id, parent.frames[2].document.forms[0].file_no,parent.frames[1].document.forms[0].FILE_STAT);
			var names = new Array (getLabel("eFM.ReceivingFSLocation.label","FM"), getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"),getLabel('eFM.FileStatus.label','FM'));
			}
			else
			{*/
			var fields = new Array (parent.frames[1].document.forms[0].p_curr_fs_loc, parent.frames[2].document.forms[0].patient_id, parent.frames[2].document.forms[0].file_no);
			var names = new Array (getLabel("eFM.ReceivingFSLocation.label","FM"), getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"));
			//}

		}
		else if(parent.frames[2].document.forms[0].file_type_appl_yn.value == "Y") 
		{
			
			
			/*if(accept_out_intransit_yn == "Y")
			{
			var fields = new Array (parent.frames[1].document.forms[0].p_curr_fs_loc, parent.frames[2].document.forms[0].patient_id, parent.frames[2].document.forms[0].patient_file_type,parent.frames[1].document.forms[0].FILE_STAT);
			var names = new Array (getLabel("eFM.ReceivingFSLocation.label","FM"), getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"),getLabel('eFM.FileStatus.label','FM'));
			}
			else
			{*/
				var fields = new Array (parent.frames[1].document.forms[0].p_curr_fs_loc, parent.frames[2].document.forms[0].patient_id, parent.frames[2].document.forms[0].patient_file_type);
				var names = new Array (getLabel("eFM.ReceivingFSLocation.label","FM"), getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"));
			//}
		}
	}
	
	for(var i=0; i<fields.length; i++)
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		else 
		{
			errors = errors + getMessage("CAN_NOT_BE_BLANK","common") + "<br>";
			//"APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			errors=errors.replace('$',names[i]);
			
		}
	}
	if(errors.length != 0) {
		parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		to_proceed = false;
		return false ;
	     parent.frames[2].document.forms[0].Add.disabled =true;
			parent.frames[2].document.forms[0].show_files.disabled =true;
			parent.frames[2].document.forms[0].Clear.disabled =true;
	}
	var p_old_string		= parent.frames[1].document.forms[0].p_select_values.value;
	var p_receiving_fs_locn = parent.frames[1].document.forms[0].p_curr_fs_loc.value;
	var p_search_type;
	var file_type_appl_yn	= parent.frames[2].document.forms[0].file_type_appl_yn.value;
	var file_no			=	"";
	var file_type		=	"";
	var p_pat_file_type = "";
     file_num  =parent.frames[2].document.forms[0].file_no.value;
	file_no		=	Math.abs(parent.frames[2].document.forms[0].file_no.value.length);

	if(file_type_appl_yn == "Y")
	{
		file_type	=	Math.abs(parent.frames[2].document.forms[0].patient_file_type.value.length);
	}
	
	var p_pat_file_no = parent.frames[2].document.forms[0].file_no.value;
	p_search_type	  = 'F';

	
	if((file_type_appl_yn == "Y") && (file_type>0))
	{
		p_pat_file_type = parent.frames[2].document.forms[0].patient_file_type.value;
		p_search_type	  = 'F'; 
	}

		 
	//  if(flag!="true" && patient_id!=patientid && file_num!=fileno && volume_no1!=volno)
	
	patfilevolno_new=patient_id+"`"+file_num+"`"+volume_no1;
	if(patientid!="" && fileno!="" && volno!=""  )
	{
	patfilevolno_old=patientid+"`"+fileno+"`"+volno;
	}
	if(flag!="true" & patfilevolno_old!=patfilevolno_new)
	{
	parent.frames[2].document.forms[0].p_stored_val_old.value=p_stored_val;
	
	}	
		
	if(doc_or_file == 'D')
	{
		var volume_no = '';
	}
	else if(doc_or_file == 'F') 
	{
		var volume_no = parent.frames[2].document.forms[0].volume_no.value;
	    var curfista = parent.frames[1].document.forms[0].FILE_STAT.value;
	  if(file_no=="")
		{
          

		}else
		{
     
		
		 
		 if(curfista=="" && p_out_fcy=="")
			{
                if(flag=="true"){
				p_stored_val_old=parent.frames[2].document.forms[0].p_stored_val_old.value;
				if(patfilevolno_new!=patfilevolno_old || (un_defcny=="true" && patfilevolno_new==patfilevolno_old))
				{
				 p_stored_val_old=p_stored_val_old+"/"+patient_id+"`"+file_num+"`"+volume_no;
					}
				parent.frames[2].document.forms[0].p_stored_val_old.value=p_stored_val_old;
				}else{
		       if(patfilevolno_new!=patfilevolno_old)
					{
				p_stored_val=p_stored_val+"/"+patient_id+"`"+file_num+"`"+volume_no;
					}
				}
			}else if(curfista!="" && p_out_fcy!=""){	
			if(flag=="true"){
				p_stored_val_old=parent.frames[2].document.forms[0].p_stored_val_old.value
				if(patfilevolno_new!=patfilevolno_old || (un_defcny=="true" && patfilevolno_new==patfilevolno_old))
				{
				
				p_stored_val_old=p_stored_val_old+"/"+patient_id+"`"+file_num+"`"+curfista+"`"+p_out_fcy+"`"+volume_no;
						}
				parent.frames[2].document.forms[0].p_stored_val_old.value=p_stored_val_old;
				}else{
				if(patfilevolno_new!=patfilevolno_old)
					{
				p_stored_val=p_stored_val+"/"+patient_id+"`"+file_num+"`"+curfista+"`"+p_out_fcy+"`"+volume_no;
					}
					}
				}
				
			else if(curfista=="" || p_out_fcy=="" ){
                
				if(curfista=="")
				{
				curfista="curfista";
				if(flag=="true" ){
				p_stored_val_old=parent.frames[2].document.forms[0].p_stored_val_old.value;
				if(patfilevolno_new!=patfilevolno_old || (un_defcny=="true" && patfilevolno_new==patfilevolno_old) )
					{
				p_stored_val_old=p_stored_val_old+"/"+patient_id+"`"+file_num+"`"+curfista+"`"+p_out_fcy+"`"+volume_no;
					}
					parent.frames[2].document.forms[0].p_stored_val_old.value=p_stored_val_old;
				}else{
		        if(patfilevolno_new!=patfilevolno_old)
					{
				p_stored_val=p_stored_val+"/"+patient_id+"`"+file_num+"`"+curfista+"`"+p_out_fcy+"`"+volume_no;
					}
				}
				}else if(p_out_fcy==""){
               p_out_fcy="p_out_fcy";
				if(flag=="true"){
				p_stored_val_old=parent.frames[2].document.forms[0].p_stored_val_old.value;
				if(patfilevolno_new!=patfilevolno_old || (un_defcny=="true" && patfilevolno_new==patfilevolno_old))
					{
				p_stored_val_old=p_stored_val_old+"/"+patient_id+"`"+file_num+"`"+curfista+"`"+p_out_fcy+"`"+volume_no;
					}
				parent.frames[2].document.forms[0].p_stored_val_old.value=p_stored_val_old;
				}else{
		        if(patfilevolno_new!=patfilevolno_old)
					{
				p_stored_val=p_stored_val+"/"+patient_id+"`"+file_num+"`"+curfista+"`"+p_out_fcy+"`"+volume_no;
					}
				}
				}
			}
			 	}
		if(p_stored_val=="")
		{
        parent.frames[2].document.forms[0].p_stored_val.value = "";
		}else{
   	 parent.frames[2].document.forms[0].p_stored_val.value =p_stored_val;
		
		}
	 	 if(flag=="true" && p_stored_val_old!="")
		{
           parent.frames[2].document.forms[0].p_stored_val.value =p_stored_val_old;
		}
	
	}
	
	var remove_volume = parent.frames[2].document.forms[0].remove_volume.value;
	if(remove_volume == "ALL")
		addedVolumes.clear();
	var volume_value = "";
	if(volume_no != "") 
	{
	    volume_value = "'"+volume_no+"'";
		if(!addedVolumes.has(volume_value))
		{
			addedVolumes.set(volume_value, volume_value);
		document.forms[0].remove_volume.value="";
		}
		if((remove_volume != "") && ((remove_volume!="ALL"))) 
		{
			volume_value = "'"+remove_volume+"'";
			if (addedVolumes.has(volume_value))
				addedVolumes.remove(volume_value);
		}
		volume_value = Array.from(addedVolumes.keys()).toString();
			}
	
	var record_value  = "";
	record_value = file_no+"$$"+volume_no;
		if (!addedRecords.has(record_value))
			addedRecords.set(record_value, record_value);
		record_value = Array.from(addedRecords.keys()).toString();
	var p_display ;
	p_stored_val_old= parent.frames[2].document.forms[0].p_stored_val_old.value;
	if(flag=="true" && p_stored_val_old!="")
	{
	p_stored_val=parent.frames[2].document.forms[0].p_stored_val_old.value;
		
	//parent.frames[2].document.forms[0].p_stored_val_old.value="";
	parent.frames[2].document.forms[0].flag.value="";
	parent.frames[2].document.forms[0].un_defcny.value="";
	}
   	parent.frames[2].document.forms[0].patientid.value=""; 
	parent.frames[2].document.forms[0].fileno.value=""; 
	parent.frames[2].document.forms[0].volno.value=""; 
if(doc_or_file == 'D')
	{
		HTMLVal = "<html><head></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/DTBuildQuery.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_old_string' id='p_old_string' type='hidden' value='"+p_old_string+"'><input name='p_search_type' id='p_search_type' type='hidden' value='"+p_search_type+"'><input name='p_display' id='p_display' type='hidden' value='"+p_display+"'><input name='p_pat_file_type' id='p_pat_file_type' type='hidden' value='"+p_pat_file_type+"'><input type='Hidden' name='volume_no' id='volume_no' value='"+volume_no+"'><input type='Hidden' name='p_receiving_fs_locn' id='p_receiving_fs_locn' value='"+p_receiving_fs_locn+"'><input type='Hidden' name='addedVolumes' id='addedVolumes' value='"+escape(volume_value)+"'><input type='Hidden' name='record_value' id='record_value' value='"+record_value+"'><input type='Hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='"+file_type_appl_yn+"'><input name='doc_or_file' id='doc_or_file' type='hidden' value='"+doc_or_file+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value='"+p_fs_location+"'><input name='p_file_stat' id='p_file_stat' type='hidden' value='"+p_file_stat+"'><input name='p_out_fcy' id='p_out_fcy' type='hidden' value='"+p_out_fcy+"'><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'><input name='file_num' id='file_num' type='hidden' value='"+file_num+"'><input name='patient_id' id='patient_id' type='hidden' value='"+patient_id+"'></form></BODY></HTML>";

	}
	else if(doc_or_file == 'F') 
	{
		HTMLVal = "<html><head></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMBuildQuery.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_old_string' id='p_old_string' type='hidden' value='"+p_old_string+"'><input name='p_search_type' id='p_search_type' type='hidden' value='"+p_search_type+"'><input name='p_display' id='p_display' type='hidden' value='"+p_display+"'><input name='p_pat_file_type' id='p_pat_file_type' type='hidden' value='"+p_pat_file_type+"'><input type='Hidden' name='volume_no' id='volume_no' value='"+volume_no+"'><input type='Hidden' name='p_receiving_fs_locn' id='p_receiving_fs_locn' value='"+p_receiving_fs_locn+"'><input type='Hidden' name='addedVolumes' id='addedVolumes' value='"+escape(volume_value)+"'><input type='Hidden' name='record_value' id='record_value' value='"+record_value+"'><input type='Hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='"+file_type_appl_yn+"'><input name='doc_or_file' id='doc_or_file' type='hidden' value='"+doc_or_file+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value='"+p_fs_location+"'><input name='p_file_stat' id='p_file_stat' type='hidden' value='"+p_file_stat+"'><input name='accept_out_intransit_yn' id='accept_out_intransit_yn' type='hidden' value='"+accept_out_intransit_yn+"'><input name='vol_cnt' id='vol_cnt' type='hidden' value='"+vol_cnt+"'><input name='p_stored_val' id='p_stored_val' type='hidden' value='"+p_stored_val+"'><input name='p_out_fcy' id='p_out_fcy' type='hidden' value='"+p_out_fcy+"'><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'><input name='file_num' id='file_num' type='hidden' value='"+file_num+"'><input name='patient_id' id='patient_id' type='hidden' value='"+patient_id+"'></form></BODY></HTML>";

	}
//	HTMLVal = "<html><head></head><BODY><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMBuildQuery.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_old_string' id='p_old_string' type='hidden' value='"+p_old_string+"'><input name='p_search_type' id='p_search_type' type='hidden' value='"+p_search_type+"'><input name='p_display' id='p_display' type='hidden' value='"+p_display+"'><input name='p_pat_file_type' id='p_pat_file_type' type='hidden' value='"+p_pat_file_type+"'><input type='Hidden' name='volume_no' id='volume_no' value='"+volume_no+"'><input type='Hidden' name='p_receiving_fs_locn' id='p_receiving_fs_locn' value='"+p_receiving_fs_locn+"'><input type='Hidden' name='added_volumes' id='added_volumes' value='"+escape(volume_value)+"'><input type='Hidden' name='record_value' id='record_value' value='"+record_value+"'><input type='Hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='"+file_type_appl_yn+"'><input name='doc_or_file' id='doc_or_file' type='hidden' value='"+doc_or_file+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value='"+p_fs_location+"'><input name='p_file_stat' id='p_file_stat' type='hidden' value='"+p_file_stat+"'></form></BODY></HTML>";

        	 parent.frames[5].document.write(HTMLVal);
             parent.frames[2].document.forms[0].Add.disabled =true;
             parent.frames[2].document.forms[0].show_files.disabled  =true;
	         parent.frames[2].document.forms[0].Clear.disabled =true;
	       	 parent.frames[5].document.form1.submit();
}
function apply()
{
	var p_file_no = "";
	var rem_recnum_value="";
	var p_req_select;
	var p_total_cnt = parent.frames[2].frames[2].document.forms[0].p_total_select.value;
	var to_proceed = true;
	
	var Obj = parent.frames[2].frames[1].document.forms[0]
	var fields = new Array(Obj.p_return_date_time,Obj.p_ret_by, Obj.p_curr_fs_loc);

	var names = new Array ( getLabel("Common.returndatetime.label","common"), getLabel("Common.returnedby.label","common"), getLabel("eFM.ReceivingFSLocation.label","FM"));

	var errors = "";
	var messag ="";
	for(var i=0; i<fields.length; i++) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	
		{
//			errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			errors = errors + getMessage("CAN_NOT_BE_BLANK","common") + "<br>" ;
			errors = errors.replace('$',names[i]);

		}
	}
	if ( errors.length != 0 )
	{
	parent.frames[2].frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		to_proceed = false;
		return false ;
	}
	
	var p_rec_count=0;
	var bool ;
	for(var counter=0;counter<p_total_cnt;counter++){
			
		if(eval("parent.frames[2].frames[3].document.forms[0].req_select"+counter+".disabled") == false){

			bool =	eval("parent.frames[2].frames[3].document.forms[0].req_select"+counter+".checked");
			if(bool == true) {
					p_rec_count++;
			}
		}
    }//End of For
	
    if(p_rec_count>0){
 		to_proceed == true;
    }else{
		to_proceed = false;
//		messag = "APP-FM0074 No files selected for Return ";
		messag = getMessage("NO_FILES_SEL_FOR_RET","FM");
		parent.frames[2].frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
    }	
 if (to_proceed == true)
 {
	 if (parseInt(p_total_cnt) > 0)
	 {
		for(var counter=0;counter<p_total_cnt;counter++)
		{
		p_req_select =
		eval("parent.frames[2].frames[3].document.forms[0].req_select"+counter+".checked");
		if (p_req_select==true)
		{
			if (p_file_no.length==0)
			{
		
				p_file_no = eval("parent.frames[2].frames[3].document.forms[0].file_no"+counter+".value")+"$$"+
				eval("parent.frames[2].frames[3].document.forms[0].volume_no"+counter+".value")+"$$"+eval("parent.frames[2].frames[3].document.forms[0].cur_facility_id"+counter+".value")+"$$"+eval("parent.frames[2].frames[3].document.forms[0].patient_id"+counter+".value");
				}
			else
			{
				p_file_no = p_file_no + "|" + eval("parent.frames[2].frames[3].document.forms[0].file_no"+counter+".value")+"$$"+
				eval("parent.frames[2].frames[3].document.forms[0].volume_no"+counter+".value")+"$$"+eval("parent.frames[2].frames[3].document.forms[0].cur_facility_id"+counter+".value")+"$$"+eval("parent.frames[2].frames[3].document.forms[0].patient_id"+counter+".value");
				
			}
			if (rem_recnum_value.length==0)
			{
			 var pat_file_volume=eval("parent.frames[2].frames[3].document.forms[0].patient_id"+counter+".value")+"`"+eval("parent.frames[2].frames[3].document.forms[0].file_no"+counter+".value")+"`"+eval("parent.frames[2].frames[3].document.forms[0].volume_no"+counter+".value"); 

			 if(addedRemRemarks.has(pat_file_volume))
				{
				 	var conuterValue = eval("parent.frames[2].frames[3].document.forms[0].rem_recnum_"+counter)
					conuterValue.value = addedRemRemarks.Item(pat_file_volume)
				}

				

				if (eval("parent.frames[2].frames[3].document.forms[0].rem_recnum_"+counter+".value") != "") {


					rem_recnum_value = eval("parent.frames[2].frames[3].document.forms[0].rem_recnum_"+counter+".value");
				}
				else {
					//rem_recnum_value = rem_recnum_value + "¡" + ':|:';
					rem_recnum_value = '#';
				}
			}
			else {
				 var pat_file_volume=eval("parent.frames[2].frames[3].document.forms[0].patient_id"+counter+".value")+"`"+eval("parent.frames[2].frames[3].document.forms[0].file_no"+counter+".value")+"`"+eval("parent.frames[2].frames[3].document.forms[0].volume_no"+counter+".value"); 

			 if(addedRemRemarks.has(pat_file_volume))
				{
				    var conuterValue1 = eval("parent.frames[2].frames[3].document.forms[0].rem_recnum_"+counter);
					conuterValue1.value = addedRemRemarks.Item(pat_file_volume);
				}

				//alert(eval("parent.frames[2].frames[3].document.forms[0].rem_recnum_"+counter+".value"));

				if (eval("parent.frames[2].frames[3].document.forms[0].rem_recnum_"+counter+".value") != "") {
					//rem_recnum_value = rem_recnum_value + "¡" + eval("parent.frames[2].frames[3].document.forms[0].rem_recnum_"+counter+".value");
					rem_recnum_value = rem_recnum_value + "~" + eval("parent.frames[2].frames[3].document.forms[0].rem_recnum_"+counter+".value");
				}
				else {
					rem_recnum_value = rem_recnum_value + "~" + '#';
					//rem_recnum_value = rem_recnum_value + "¡" + '#';
				}
			}
		}
	}
 }
 else
 {
	 errors="";
	parent.frames[2].frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
 }

if (p_file_no.length>0)
{

	//parent.frames[1].frames[1].document.forms[0].file_nos.value = p_file_no;
	parent.frames[2].frames[1].document.forms[0].p_file_nos.value = p_file_no;
	
	////////////// New Block Added
	parent.frames[2].frames[1].document.forms[0].rem_recnum_value.value = rem_recnum_value;
	//////////////////////

	parent.frames[2].frames[1].document.forms[0].p_returndatetime.value = 	parent.frames[2].frames[1].document.forms[0].p_return_date_time.value;

	parent.frames[2].frames[1].document.forms[0].p_returned_by.value = parent.frames[2].frames[1].document.forms[0].p_ret_by.value;

	parent.frames[2].frames[1].document.forms[0].p_narration_code.value = parent.frames[2].frames[1].document.forms[0].p_narration.value;

	parent.frames[2].frames[1].document.forms[0].submit();
	
	parent.parent.frames[2].frames[1].location.href='../../eFM/jsp/FMReceiveFileMRDDefault.jsp';
	parent.parent.frames[2].frames[2].location.href='../../eFM/jsp/FMReceiveFileMRDSearch.jsp';
	parent.parent.frames[2].frames[3].location.href='../../eCommon/html/blank.html';

}
else
 {
	 errors="";
	parent.frames[2].frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;

 }
 }

}
function ValidateDate(obj) {
	if (doDateTimeChk(obj)==false) {
		alert(getMessage('INVALID_DATE_TIME','FM'));
	}
}

function PopulateOutFSLoc(obj) {
	var p_locn_code =obj.value;
	var p_facility_id = parent.frames[2].document.forms[0].p_out_fcy.value;
	var p_curr_fs_loc = parent.frames[1].document.forms[0].p_curr_fs_loc.value;

	if (p_locn_code == "" && p_facility_id != "" && p_curr_fs_loc != "") {
		var len = parent.frames[2].document.forms[0].p_out_fsloc.length;
		for (var i=0; i<=len; i++) {
			parent.frames[2].document.forms[0].p_out_fsloc.remove("p_out_fsloc");
		}
		var opt	= parent.frames[2].document.forms[0].document.createElement('OPTION');
		opt.value =	"";
		opt.text = "--- "+getLabel("Common.defaultSelect.label","common")+" ---";
		parent.frames[2].document.forms[0].p_out_fsloc.add(opt);
	}
	if (p_locn_code != "" && p_facility_id != "" && p_curr_fs_loc != "") {
		var sel = parent.frames[2].document.forms[0].p_out_fsloc;
		while(sel.options.length>1) {
			sel.remove(1);
		}
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='populateFSLoc' id='populateFSLoc' method='post' action='../../eFM/jsp/FMReturnPopFSLoc.jsp?p_facility_id="+p_facility_id+"&p_curr_fs_loc="+p_curr_fs_loc+"&param_num=1&locn_code="+p_locn_code+"'></form></body></html>" ;

		/*parent.frames[5].document.write(HTMLVal) ;
		console.log(parent.frames[5].document.getElementById("populateFSLoc"));
		console.log(parent.frames[5].document.forms[0]);
		console.log(document.getElementById("populateFSLoc"));*/
		parent.frames[5].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.frames[5].document.populateFSLoc.submit() ;
	}
}
function ChangeOutstanding() {
	var p_curr_fs_loc = parent.frames[1].document.forms[0].p_curr_fs_loc.value;

	if (p_curr_fs_loc.length>0)
	{
	if (parent.frames[2].document.forms[0].file_no != null)
		parent.frames[2].document.forms[0].file_no.disabled=false;
	parent.frames[2].document.forms[0].p_out_fcy.disabled=false;
	parent.frames[2].document.forms[0].p_out_fsloc.disabled=false;

	var sel = parent.frames[2].document.forms[0].p_out_fcy;

	while(sel.options.length>1) {
		sel.remove(1);
	}
	var sel1 = parent.frames[2].document.forms[0].p_out_fsloc;
	while(sel1.options.length>1) {
		sel1.remove(1);
	}
	var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='populateFSLoc' id='populateFSLoc' method='post' action='../../eFM/jsp/FMReturnPopFSLoc.jsp?p_curr_fs_loc="+p_curr_fs_loc+"&param_num=2'></form></body></html>" ;
	//parent.frames[5].document.write(HTMLVal) ;
	parent.frames[5].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.frames[5].document.populateFSLoc.submit() ;
	}
	else {
		if (parent.frames[2].document.forms[0].file_no != null) {
			parent.frames[2].document.forms[0].file_no.disabled=true;
			parent.frames[2].document.forms[0].file_no.value='';
		}
		parent.frames[2].document.forms[0].p_out_fcy.value='';
		parent.frames[2].document.forms[0].p_out_fsloc.value='';
		parent.frames[2].document.forms[0].p_out_fcy.disabled=true;
		parent.frames[2].document.forms[0].p_out_fsloc.disabled=true;
	}
	parent.frames[2].document.forms[0].patient_id.value='';
parent.frames[2].document.forms[0].patient_id.onblur();
}
function showfiles() {
	var p_out_fcy	= parent.frames[2].document.forms[0].p_out_fcy.value;
	var p_out_fsloc	= parent.frames[2].document.forms[0].p_out_fsloc.value;
	var file_type_appl_yn	= parent.frames[2].document.forms[0].file_type_appl_yn.value;
	var p_receiving_fs_locn = parent.frames[1].document.forms[0].p_curr_fs_loc.value;
	var doc_or_file			= parent.frames[2].document.forms[0].doc_or_file.value;
	var buttonVal ="S";
	var to_proceed =true;
	var accept_out_intransit_yn			= parent.frames[1].document.forms[0].accept_out_intransit_yn.value;
	var errors ="";
	
	if (p_receiving_fs_locn.length == 0) {
//		errors = "APP-000001 Receiving FS Location cannot be blank..." + "<br>" ;
		errors = getMessage("REC_FS_LOCN_BLANK","FM") + "<br>" ;
		//parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		to_proceed=false;
	}

	/*if(accept_out_intransit_yn == "Y")
	{
		if(parent.frames[1].document.forms[0].FILE_STAT.value == "")
		{
		var msg = getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace('$',getLabel('eFM.FileStatus.label','FM'));
		errors = errors + msg + "<br>" ;
		//parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		to_proceed=false;
		}
	}*/
	if(to_proceed == false)
	{
		parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	}
	if(to_proceed==true) {
		//if (p_out_fcy.length>0) {
			var p_old_string  = parent.frames[1].document.forms[0].p_select_values.value;
			var p_fs_location= parent.frames[1].document.forms[0].p_curr_fs_loc.value;

			var p_search_type ='LF' ;
			var p_pat_file_no ;
			var p_display ;
			if(doc_or_file == 'D') {
				HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMBuildQuery.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_old_string' id='p_old_string' type='hidden' value='"+p_old_string+"'><input name='p_search_type' id='p_search_type' type='hidden' value='"+p_search_type+"'><input name='p_out_fcy' id='p_out_fcy' type='hidden' value='"+p_out_fcy+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value='"+p_fs_location+"'><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value='"+p_out_fsloc+"'><input name='p_receiving_fs_locn' id='p_receiving_fs_locn' type='hidden' value='"+p_receiving_fs_locn+"'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='doc_or_file' id='doc_or_file' type='hidden' value='"+doc_or_file+"'><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'></form></BODY></HTML>";
			}
			else  {
				
				HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMBuildQuery.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_old_string' id='p_old_string' type='hidden' value='"+p_old_string+"'><input name='p_search_type' id='p_search_type' type='hidden' value='"+p_search_type+"'><input name='p_out_fcy' id='p_out_fcy' type='hidden' value='"+p_out_fcy+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value='"+p_fs_location+"'><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value='"+p_out_fsloc+"'><input name='p_receiving_fs_locn' id='p_receiving_fs_locn' type='hidden' value='"+p_receiving_fs_locn+"'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'></form></BODY></HTML>";
			
			}
			parent.frames[5].document.write(HTMLVal);
			parent.frames[5].document.form1.submit();

			parent.frames[1].document.forms[0].p_curr_fs_loc.disabled = true;
			parent.frames[1].document.forms[0].FILE_STAT.disabled = true;
			if(parent.frames[2].document.forms[0].file_no != null)
				parent.frames[2].document.forms[0].file_no.readOnly = true;
			parent.frames[2].document.forms[0].p_out_fcy.disabled = true;
			parent.frames[2].document.forms[0].FS_LOCN_ID.disabled = true;
			parent.frames[2].document.forms[0].p_out_fsloc.disabled = true;
			parent.frames[2].document.forms[0].Add.disabled = true;
			parent.frames[2].document.forms[0].show_files.disabled = true;
			parent.frames[2].document.forms[0].Clear.disabled = true;
	
		//}
	}
}
function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}
async function callPatDetails(Patient_ID) {
	var dialogHeight	= "42" ;
	var dialogWidth		= "80" ;
	var dialogTop		= "61" ;
	var dialogLeft		= "55" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Patient_ID), arguments, features );
}

function Clearval() {
	document.forms[0].p_file_no.value='';
	document.forms[0].p_patient_id.value='';
}
async function searchCode(target,facilityid) {
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
	
	tit=getLabel("Common.user.label","common");
	sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facilityid+"` ";
	search_code="APPL_USER_ID";
	search_desc= "APPL_USER_NAME";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

	var arr=new Array();

	if(!(retVal == null)) {
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		document.forms[0].p_ret_by_name.value=arr[0];
		document.forms[0].p_ret_by.value=arr[1];
	}
}

function ClearAllval() {

	// code added for clear the remarks

	addedRemRemarks.clear();
	parent.frames[2].document.forms[0].added_rem_remarks.value="";
	parent.frames[2].document.forms[0].added_rem_remarks_values.value="";

	document.getElementById("hdr_tab").style.visibility = 'Hidden';
	if(document.forms[0].file_no!=undefined)
	document.forms[0].file_no.value='';
	document.forms[0].remove_volume.value = "ALL";
    parent.frames[2].document.forms[0].p_stored_val.value="";
	 parent.frames[2].document.forms[0].flag.value="";
	parent.frames[2].document.forms[0].un_defcny.value="";
	parent.frames[2].document.forms[0].patientid.value="";
   parent.frames[2].document.forms[0].fileno.value="";
   parent.frames[2].document.forms[0].volno.value="";
	parent.frames[2].document.forms[0].p_stored_val_old.value="";
	parent.frames[1].document.forms[0].p_select_values.value = "";
	parent.frames[3].location.href = "../../eCommon/html/blank.html";
}
function validateFSLoc() {
	if (document.forms[0].p_return_all.checked==true) {
		document.forms[0].p_curr_fs_loc.disabled=true;
		document.forms[0].file_no.value='';
		document.forms[0].r_facility[0].checked=false;
		document.forms[0].r_facility[1].checked=false;
		document.forms[0].r_facility[0].disabled=true;
		document.forms[0].r_facility[1].disabled=true;
	}
	else {
		document.forms[0].p_curr_fs_loc.disabled=false;
		document.forms[0].r_facility[0].disabled=false;
		document.forms[0].r_facility[1].disabled=false;
	}
}
function chkFileObj() {
	if(document.FMReceiveFileMRDSearch.file_no != null)
		document.FMReceiveFileMRDSearch.file_no.disabled=false;

    if(document.FMReceiveFileMRDSearch.accept_out_intransit_yn != null){
	  var accept_out_intransit_yn =  document.FMReceiveFileMRDSearch.accept_out_intransit_yn.value;
	  if (accept_out_intransit_yn=="N")
	  {
		  document.FMReceiveFileMRDSearch.show_files.disabled  =false; 
	  }else if (accept_out_intransit_yn=="Y")
	  {
		  document.FMReceiveFileMRDSearch.show_files.disabled  =true; 
	  }
	}

	/*if(document.FMReceiveFileMRDSearch.file_type != null)
		document.FMReceiveFileMRDSearch.file_type.disabled=false;*/
}
/////******** js files of FMReturnMRDSelectedFiles.jsp ****************//
function GetRemarks(recnum) {

	// code added for icn:19422 date:Wednesday, February 24, 2010 


	var file_no=eval(document.getElementById("file_no"+recnum)).value;
	var vol_no=eval(document.getElementById("volume_no"+recnum)).value;
	var pat_id=eval(document.getElementById("patient_id"+recnum)).value;

	 var pat_file_volume=pat_id+"`"+file_no+"`"+vol_no; 
	 
	 var  pat_file_vol    =parent.frames[2].document.forms[0].pat_file_vol.value;
	 var  added_rem_rem  =parent.frames[2].document.forms[0].addedRemRemarks.value;
	var added_rem_rem_val  =parent.frames[2].document.forms[0].added_rem_remarks_values.value;

	var patarray="";
	var patfilevol="";
	var patfilevol_item="";
	var tempobj="";
	var  patarray_val="";
	var tempobj			= "";


	 if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	   patarray =added_rem_rem.split(",");
	   patarray_val =added_rem_rem_val.split(",");
			}


			for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!addedRemRemarks.Exists(patfilevol) && patfilevol!=undefined)
		   {	
			 addedRemRemarks.add(patfilevol,patfilevol_item);
		     }
		}

		if (addedRemRemarks.Exists(pat_file_volume))
		{
		tempobj=addedRemRemarks.Item(pat_file_volume);
		}
	if(tempobj==undefined || tempobj==null) tempobj="";

	



	/*var dialogHeight	= "9" ;
	var dialogWidth		= "30" ;
	var dialogTop		= "230" ;
	var dialogLeft		= "180" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;*/
	var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE " )
	if ( msie > 0 )     
        brow_ver_no=parseInt (ua.substring (msie+5, ua.indexOf (".", msie )));
	  
	var dialogHeight	= "9.3" ;
	var dialogWidth		= "30" ;
	if(brow_ver_no > '6'){
			dialogHeight	= "7.4" ;
			dialogWidth		= "28.5" ;
	  }
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';

	var arguments		= "" ;
	
	
	var retVal			= window.showModalDialog('../../eFM/jsp/FMShowRemarks.jsp?title='+encodeURIComponent(getLabel("eFM.ReturnRemarks.label","FM"))+'&curr_remarks='+encodeURIComponent(tempobj),arguments,features);

	

	if(!(retVal == null)) 
	{

		 tempobj	= unescape(retVal);

		  if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	     patarray =added_rem_rem.split(",");
		  patarray_val =added_rem_rem_val.split(",");
			}

			for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!addedRemRemarks.Exists(patfilevol) && patfilevol!=undefined)
		   {	
			 addedRemRemarks.add(patfilevol,patfilevol_item);
		    eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=patfilevol_item; 
			 }
		}

		if (!addedRemRemarks.Exists(pat_file_volume))
		   {	
			addedRemRemarks.add(pat_file_volume,tempobj);
		   eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=tempobj; 
		   }
	if (addedRemRemarks.Exists(pat_file_volume))
		   {	
		addedRemRemarks.remove(pat_file_volume);
		addedRemRemarks.add(pat_file_volume,tempobj);
		eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=tempobj; 		
			  }

			  var str=((addedRemRemarks.Items()).toArray()).toString();
			var str1=str.replace(",,",",");
			var str2=((addedRemRemarks.Keys()).toArray()).toString();
			var str3=str2.replace(",,",",");
			parent.frames[2].document.forms[0].added_rem_remarks.value=str3;
			 parent.frames[2].document.forms[0].added_rem_remarks_values.value=str1;
	}
	else if( retVal==undefined || retVal=="undefined")
	{
		
     
	  tempobj	="" ;
	     if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	   patarray =added_rem_rem.split(",");
	   patarray_val =added_rem_rem_val.split(",");
		}
	for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!addedRemRemarks.Exists(patfilevol))
		   {	
			 addedRemRemarks.add(patfilevol,patfilevol_item);
		   eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=patfilevol_item; 
		   }
		}
	 
	 pat_file_volume=pat_file_volume;
	 if (!addedRemRemarks.Exists(pat_file_volume))
		   {	
			if(tempobj!=""){
				addedRemRemarks.add(pat_file_volume,tempobj);
			}
		   eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=""; 
		   }
	 if (addedRemRemarks.Exists(pat_file_volume))
		   {	
		 
		 addedRemRemarks.remove(pat_file_volume);
		// added_rem_remarks.add(pat_file_volume,tempobj);
		eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=""; 
		}
	 parent.frames[2].document.forms[0].added_rem_remarks.value=((addedRemRemarks.Keys()).toArray()).toString();
	 parent.frames[2].document.forms[0].added_rem_remarks_values.value=((addedRemRemarks.Items()).toArray()).toString();
	 
	 addedRemRemarks.clear()();
	
		 }


}
function GetShowRemarks(name,remarksvalue,remarkstype) {
	var comments;
	var inputArr = document.getElementsByTagName("input");
	for (u=0;u<inputArr.length;u++) {
		if (inputArr[u].name == name) {
			comments = inputArr[u].value;
		}
	}
	var retVal;
	var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE " )
	if ( msie > 0 )     
        brow_ver_no=parseInt (ua.substring (msie+5, ua.indexOf (".", msie )));
	  
	var dialogHeight	= "9.3" ;
	var dialogWidth		= "30" ;
	if(brow_ver_no > '6'){
			dialogHeight	= "7.4" ;
			dialogWidth		= "28.5" ;
	  }
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;

   if(comments=='' || comments == "null")
	  comments ='';
	arguments = comments ;

	retVal = window.showModalDialog('../../eFM/jsp/GetShowRemarks.jsp?RemarksValue='+encodeURIComponent(remarksvalue)+'&RemarksType='+remarkstype,arguments,features);

	if (remarkstype=='I') {
		for (u=0;u<inputArr.length;u++){
			if (inputArr[u].name == name){
				inputArr[u].value = ''+retVal+'';
			}
		}
	}
}
function checkbox_value(obj)
{
	if (obj.checked == true) {
		obj.value='Y';
	}
	else {
		obj.value='N';
	}
}
////********* End if js files of FMReturnMRDSelectedFiles.jsp ***************//
function reset() {
	parent.parent.frames[2].frames[1].location.reload();
	parent.parent.frames[2].frames[2].location.reload();
	parent.parent.frames[2].frames[3].location.href='../../eCommon/html/blank.html';
	parent.parent.frames[2].frames[4].location.href='../../eFM/jsp/FMColorFile.jsp?&p_param=RET';
}
function onSuccess() {
//	var messag="APP-SM0001 Operation Completed Successfully ....";
	var messag=getMessage("RECORD_INSERTED","SM");
	alert(messag);
//	parent.frames[2].frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?access=NYNNY&function_name=Receive File at MRD';
//	parent.frames[2].frames[1].location.href='../../eFM/jsp/FMReceiveFileMRDDefault.jsp';
//	parent.frames[2].frames[2].location.href='../../eFM/jsp/FMReceiveFileMRDSearch.jsp';
//	parent.frames[2].frames[3].location.href='../../eCommon/html/blank.html';
	parent.parent.frames[2].location.reload();
	
//	parent.parent.frames[2].frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
	
}


function showEncounter(enc,patid,fileno,Patient_Class)
{
	
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name="FMCurrentEncounterMain.jsp";
	var win_height = "30.8";
	var win_width= "50";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "58" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = window.showModalDialog("../../eFM/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&fileNo="+fileno+"&Patient_Class="+Patient_Class,arguments,features);
}

function confrmtransit()
{   
	if(parent.frames[1].document.forms[0].accept_out_intransit_yn.value == "N")
	{
		if (parent.frames[1].document.forms[0].FILE_STAT.value !='')
		{
		   parent.frames[2].document.forms[0].show_files.disabled =false;
		}else
		{
		  parent.frames[2].document.forms[0].show_files.disabled =true;
		}
    }else if(parent.frames[1].document.forms[0].accept_out_intransit_yn.value == "Y")
	{
        parent.frames[2].document.forms[0].show_files.disabled =true;
	}
	if(parent.frames[1].document.forms[0].accept_out_intransit_yn.value == "Y" && parent.frames[1].document.forms[0].FILE_STAT.value == 'T' )
	{
		alert(getMessage('IN_TRANSIT_SELECTED','FM'));
	}
}

 function clearValues()
{	
		parent.frames[2].document.forms[0].FS_LOCN_ID.value="";
		parent.frames[2].document.forms[0].p_out_fsloc.value="";
		var p_out_fsloc=parent.frames[2].document.forms[0].p_out_fsloc;
		while(p_out_fsloc.options.length > 1)
		p_out_fsloc.remove(1);

}

function callerrorpage1(error) {

	alert(error)
	parent.parent.frames[2].location.reload();
	
}

