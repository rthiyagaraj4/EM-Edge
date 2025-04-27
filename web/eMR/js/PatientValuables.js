
async function callRecord(obj)
{
   //Added for this CRF HSA-CRF-0222 [IN:050567]	
        var arguments = "";
		var dialogHeight = "8vh";
		var dialogWidth = "36vw";
		var status = "no";
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;		
	//End HSA-CRF-0222 [IN:050567]	
	if((document.PatientValuables.remarks.value != null) && (document.PatientValuables.remarks.value != ""))    
	{
		if(document.PatientValuables.remarks.value.length > 2000)
		{
			alert(getMessage("PAT_VAL_MAX_2000",'IP'));
		}
		else if(document.PatientValuables.call_function.value == 'MR_REC_PAT_VAL')
		{
			var returned=document.forms[0].returned.value;
			var returnedby=document.forms[0].returnedby_desc.value;
			var returned_datetime=document.forms[0].returned_datetime.value;
			 var received_witness_desc=document.forms[0].received_witness_desc.value; //Added for this CRF HSA-CRF-0222 [IN:050567]
			 var retVal =""; //Added for this CRF HSA-CRF-0222 [IN:050567]
			 //var received_witnessid=document.forms[0].received_witnessid.value;
			if(returned=="Y"){
				 if(returned_datetime==''){
					var error  = getMessage("CAN_NOT_BE_BLANK","Common");
					error = error.replace('$', getLabel("Common.returndatetime.label","Common"));
					alert(error);

				}else if(returnedby==''){
					var error  = getMessage("CAN_NOT_BE_BLANK","Common");
					error = error.replace('$', getLabel("Common.returnedby.label","Common"));
					alert(error);
				}else if(document.PatientValuables.witness_desc.value == ''){
					var error  = getMessage("CAN_NOT_BE_BLANK","Common");
					//error = error.replace('$', getLabel("Common.Witness.label","Common"));
					error= error.replace('$',getLabel("Common.returned.label","Common")+" "+getLabel("Common.Witness.label","Common"));		
					alert(error);
			    }else{				
		             var received_witnessid=document.forms[0].witnessid.value;
					 var witness_pass_validate_check=document.forms[0].witness_pass_validate_check.value;              		 
					 var received_pract_name=document.forms[0].witness_desc.value;
					 var tit=getLabel("Common.returned.label","Common")+" "+getLabel("Common.Witness.label","Common");
					 if(!document.forms[0].witness_desc.disabled && witness_pass_validate_check=="Y")
						 retVal = await window.showModalDialog("../../eMP/jsp/ChangePatAcceptPassword.jsp?tit="+tit+"&received_witnessid="+received_witnessid+"&received_pract_name="+encodeURIComponent(received_pract_name),arguments,features);
					 
					 if(retVal || retVal==""){			
						document.forms[0].returned.disabled=false;
						document.forms[0].returnedby.disabled=false;
						document.forms[0].returned_datetime.disabled=false;
						document.forms[0].witness_desc.disabled=false;
						document.forms[0].target = 'messageFrame';
						document.forms[0].action = '../../servlet/eMR.PatientValuablesServlet';
						document.forms[0].submit();
					}	
			    }
			}
			else
			{				
			  //Added for this CRF HSA-CRF-0222 [IN:050567]
			  //var received_witness_desc=document.forms[0].received_witness_desc.value;
			  if(received_witness_desc==''){
				  var error=getMessage("CAN_NOT_BE_BLANK","Common");
			      error= error.replace('$',getLabel("Common.received.label","Common")+" "+getLabel("Common.Witness.label","Common"));			  
			      alert(error);
			  } else{	  
		          var received_witnessid=document.forms[0].received_witnessid.value;
		          var witness_pass_validate_check=document.forms[0].witness_pass_validate_check.value;
		          var tit=getLabel("Common.received.label","Common")+" "+ getLabel("Common.Witness.label","Common");	
		          if(!document.forms[0].received_witness_desc.disabled && witness_pass_validate_check=="Y") 
		        	  retVal = await window.showModalDialog("../../eMP/jsp/ChangePatAcceptPassword.jsp?tit="+tit+"&received_witnessid="+received_witnessid+"&received_pract_name="+encodeURIComponent(received_witness_desc),arguments,features);
				  
		          if(retVal || retVal==""){							  
				      document.forms[0].target = 'messageFrame';
				      document.forms[0].action = '../../servlet/eMR.PatientValuablesServlet';
					  document.forms[0].submit();
				  }
			  }
			}
		}
		else if(document.PatientValuables.call_function.value != 'MR_REC_PAT_VAL')
		{
			if(document.PatientValuables.witness_desc.value == '')
			{
				var error  = getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$', getLabel("Common.Witness.label","Common"));
				alert(error);
			}
			else
			{
				document.forms[0].target = 'messageFrame';
				document.forms[0].submit();
			}
		}
	}
	else
	{
		var error=getMessage("CAN_NOT_BE_BLANK","Common");
		error= error.replace('$',getLabel("Common.PatientValuables.label","Common"));
		alert(error);
	}
	
}

