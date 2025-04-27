//Created by Ashwini on 16-Dec-2019 for AAKH-CRF-0079.11
function reset() {
	if(frames[1].document.forms[0].function_id.value=="UPLOAD_DOC"){
		parent.frames[1].document.forms[0].search.onclick();
	}else
	{
		f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.forms[0].PatientId.onblur();
	}
}

async function callSearchScreen()
{
	var patientid = await PatientSearch('','','','','','','Y','','','OTHER');;
	if(patientid !=null)
	document.forms[0].PatientId.value = patientid;
	document.forms[0].PatientId.focus();		 
}

function validatePatientId(obj) 
{
	var patId = obj.value;
	if(parent.content !=null) {
		f = parent.content.frames[1];
	}else {
		f = parent.frames[1];
	}

	if(patId!=""){ 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatIdStatus' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		 var pat_status	= TrimStr(responseText);
		 var ErrorMessage	= ""; 
		 if ( pat_status=="INVALID_PATIENT"){
				 ErrorMessage	= getMessage('INVALID_PATIENT','MP');
			  }
		 if(ErrorMessage!=''){
			alert(ErrorMessage);
			obj.focus();
			obj.value='';
			parent.frames[2].location = "../../eCommon/html/blank.html";
		}
	}
}

function clearResult(obj)
{
	if(obj.value == "")
	{
		parent.frames[2].document.location.href="../../eCommon/html/blank.html";
		parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp";
	}
}

function searchResult()
{
	var patient_id = document.forms[0].PatientId.value;
	var function_id = document.forms[0].function_id.value;
	var encounter_id = document.forms[0].encounter_id.value;

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH patient_id=\""+patient_id+"\" action='PatDemographicDtls'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/MPIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText

	var returnVal = trimString(responseText);
	var arr = returnVal.split("#");
	var patient_name = arr[0];
	var contact_no = arr[1];
	var date_of_birth = arr[2];
	var gender = arr[3];

	if(patient_id == "")
	{
		error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.patientId.label","Common"));	
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
		alert(error);	
	}else{
		parent.frames[2].document.location.href='../../eMP/jsp/MPUploadDocumentResult.jsp?patient_id='+patient_id+'&patient_name='+patient_name+'&contact_no='+contact_no+'&date_of_birth='+date_of_birth+'&gender='+gender+'&function_id='+function_id+'&encounter_id='+encounter_id;
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
	}				
}

function FieldsDisplayOrder()
{
	var enc_arr_size = eval("parent.frames[2].document.forms[0].enc_arr_size").value;

	for(var i = 0; i < enc_arr_size; i++)
	{
		for(var k = 1 ; k < 5 ; k++) 
		{
			var insurance_type = eval("parent.frames[2].document.forms[0].insurance_type"+i+"_"+k).value;
			var result_style = document.getElementById("result_tr"+i+"_"+k).style;

			if(insurance_type != ""){
				result_style.display = 'table-row';
				if( k == 1 || k == 2 || k == 3 || k == 4)
				{
					var hide_button = k-1;
					document.getElementById("add_row"+i+"_"+hide_button).style.visibility = 'hidden';
					if(k == 4)
					{
						document.getElementById("add_row"+i+"_"+k).style.visibility = 'hidden';
					}
				}
			}else
			{
				result_style.display = 'none';
			}
		}
	}
}

function ValidateFileType(obj_i, obj_k)
{
	var field_num_i	= obj_i;
	var field_num_k	= obj_k;
	
	var field_name	= eval("parent.frames[2].document.forms[0].upload_doc_name"+field_num_i+"_"+field_num_k).name;
	var field_value = eval("parent.frames[2].document.forms[0].upload_doc_name"+field_num_i+"_"+field_num_k).value;
	var insurance_type = eval("parent.frames[2].document.forms[0].insurance_type"+field_num_i+"_"+field_num_k).value;

 	var condition	= "";
	
	if(insurance_type == "")
	{
		error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.Insurance.label","Common"));	
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
		alert(error);	
	}
	else if(field_value == "")
	{
		error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.UploadInsDoc.label","Common"));	
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
		alert(error);	
	}
	else
	{	
		var fileTypeArr = field_value.split(/[\s.]+/);
		var fileType	= fileTypeArr[fileTypeArr.length-1].toUpperCase();
		condition		= (fileType!='JPG' && fileType!='JPEG' && fileType!='GIF' && fileType!='PDF');
		
		if(condition){			
			alert(getMessage("INVALID_FILE_TYPE","MP"));
			if(field_name == "upload_doc_name"+field_num_i+"_"+field_num_k){
				eval("parent.frames[2].document.getElementById('upload_doc_id"+field_num_i+"_"+field_num_k + "')").innerHTML = eval("parent.frames[2].document.getElementById('upload_doc_id" +field_num_i+"_"+field_num_k + "')").innerHTML;
			}
			return false;
		}else{
			// var fso, f;
			// fso = new ActiveXObject("Scripting.FileSystemObject");	 
			var file = document.getElementById("upload_doc_name"+obj_i+"_"+obj_k).files[0];
			if(file){ 			
				if(file.size > 2147483648){
					alert(getMessage("FILE_GREATER_2GB","MP"));										
					if(field_name == "upload_doc_name"+field_num_i+"_"+field_num_k){
						eval("parent.frames[2].document.getElementById('upload_doc_id"+field_num_i+"_"+field_num_k + "')").innerHTML = eval("parent.frames[2].document.getElementById('upload_doc_id"+field_num_i+"_"+field_num_k + "')").innerHTML;
					}
					return false;
		        }
            } else {
				return false;
			}
			UploadDoc(field_num_i, field_num_k);
		}
	}
}

function UploadDoc(obj_i, obj_k)
{
	var field_num_i = obj_i;
	var field_num_k	= obj_k;

	var encounter_id = eval("parent.frames[2].document.forms[0].encounter_id"+field_num_i+"_"+field_num_k).value;
	var insurance_type = eval("parent.frames[2].document.forms[0].insurance_type"+field_num_i+"_"+field_num_k).value;
	var serial_no = eval("parent.frames[2].document.forms[0].serial_no"+field_num_i+"_"+field_num_k).value;
	var operation = eval("parent.frames[2].document.forms[0].oper"+field_num_i+"_"+field_num_k).value;
	
		parent.frames[2].document.forms[0].hidd_encounter_id.value = encounter_id;
		parent.frames[2].document.forms[0].hidd_insurance_type.value = insurance_type;
		parent.frames[2].document.forms[0].hidd_serial_no.value = serial_no;
		parent.frames[2].document.forms[0].operation.value = operation;

		parent.frames[2].document.forms[0].action="../../servlet/eMP.MPUploadDocumentServlet";
		parent.frames[2].document.forms[0].submit();
}

async function ViewDocument(obj_i, obj_k)
{
	var field_num_i = obj_i;
	var field_num_k	= obj_k;

	var patient_id = parent.frames[2].document.forms[0].patient_id.value;
	var encounter_id = eval("parent.frames[2].document.forms[0].encounter_id"+field_num_i+"_"+field_num_k).value;
	var serial_no = eval("parent.frames[2].document.forms[0].serial_no"+field_num_i+"_"+field_num_k).value;
	
	var dialogHeight = '800px' ;
	var dialogWidth  = '1700px' ;
	var features     = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;'
	var arguments    = '' ;
	var retVal = await window.showModalDialog("../../eMP/jsp/MPUploadedDocumentViewFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&serial_no="+serial_no,arguments,features); 
}

function AddAnotherRow(obj_i, obj_k)
{
	var field_num_i = obj_i;
	var field_num_k	= obj_k+1;
	
	if(document.getElementById("add_row"+obj_i+"_"+obj_k).style.visibility == 'visible')
	{
		var result_style = document.getElementById("result_tr"+field_num_i+"_"+field_num_k).style;
		result_style.display = 'table-row';
		document.getElementById("add_row"+obj_i+"_"+obj_k).style.visibility = 'hidden';
		document.getElementById("remove_row"+obj_i+"_"+obj_k).style.visibility = 'visible';
	}else
	{
		var result_style = document.getElementById("result_tr"+field_num_i+"_"+field_num_k).style;
		result_style.display = 'none';
		document.getElementById("add_row"+obj_i+"_"+obj_k).style.visibility = 'visible';
		document.getElementById("remove_row"+obj_i+"_"+obj_k).style.visibility = 'hidden';
	}
}

function onSuccess(){ 
	if(frames[2].document.forms[0].function_id.value=="UPLOAD_DOC"){
		alert(frames[2].getMessage("RECORD_INSERTED",'SM'));
		//parent.window.close();
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close(); 
	}else{
		frames[2].document.location.reload();
	}
}

function LoadEncResult()
{
	parent.frames[1].document.forms[0].search.onclick();
}

function FieldsDisplayForEnc(enc_id)
{
	var revise_vst_enc = enc_id;

	var enc_arr_size = eval("parent.frames[2].document.forms[0].enc_arr_size").value;

	for(var i = 0; i < enc_arr_size; i++)
	{
		for(var k = 0 ; k < 5 ; k++) 
		{
			var insurance_type = eval("parent.frames[2].document.forms[0].insurance_type"+i+"_"+k).value;
			var encounter_id = eval("parent.frames[2].document.forms[0].encounter_id"+i+"_"+k).value;
			var result_style = document.getElementById("result_tr"+i+"_"+k).style;

			if(revise_vst_enc == encounter_id){
				if(k == 0)
				{
					result_style.display = 'table-row';
				}else
				{
					if(insurance_type != "")
					{
						result_style.display = 'table-row';

						if( k == 1 || k == 2 || k == 3 || k == 4)
						{
							var hide_button = k-1;
							document.getElementById("add_row"+i+"_"+hide_button).style.visibility = 'hidden';
							if(k == 4)
							{
								document.getElementById("add_row"+i+"_"+k).style.visibility = 'hidden';
							}
						}
					}else
					{
						result_style.display = 'none';
					}
				}
			}else
			{
				result_style.display = 'none';
			}
		}
	}
}
