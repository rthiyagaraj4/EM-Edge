/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Review			Date 		Description							
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
21/07/2016		IN052254		Ramesh G										MMS-QH-CRF-0204		
--------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
01/11/2017		IN065070	Raja S		02/11/2017		Ramesh G			ML-MMOH-CRF-0623.1
--------------------------------------------------------------------------------------------------------------------
*/
function checkSequence(objSequence)
{
	var errorMessage =""
	 if(parseInt(objSequence.value) <= 0)
			{
				errorMessage= getMessage("SEQUENCE_NOT_ZERO",'CA');
				alert(errorMessage);
				objSequence.value=''
				objSequence.focus()
				return false
			}
}

function CheckPositiveNumberLocal(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{		
	}
	else 
	{
  		if ( obj.value.length > 0 ) 
		{
  			alert(getMessage("POSITIVE_NUMBER_ALLOWED",'CA'));
  			obj.select();
  			obj.focus();
  		}
  	}
}



function apply()
{
		var isAESiteSpecific = f_query_add_mod.document.forms[0].isAESiteSpecific.value; //Added for IN065070
		var fields = new Array (
							f_query_add_mod.document.ca_consultation_param_form.max_consultation_practitioner,
							f_query_add_mod.document.ca_consultation_param_form.back_date_consultation,
			                f_query_add_mod.document.ca_consultation_param_form.max_consultation_speciality,
							f_query_add_mod.document.ca_consultation_param_form.amend_consultation_list, 
		                    f_query_add_mod.document.ca_consultation_param_form.min_duration_recquired		          
							);

		var names = new Array (
							 f_query_add_mod.getLabel("eCA.MaxConsultationPractitioner.label",'CA'),							 f_query_add_mod.getLabel("eCA.BackDateConsultationList.label",'CA'),							 f_query_add_mod.getLabel("eCA.MaxConsultationSpeciality.label",'CA'),
		                     f_query_add_mod.getLabel("eCA.AmendConsultationList.label",'CA'),
		                     f_query_add_mod.getLabel("eCA.MinDurationRecquired.label",'CA')		
							);


							  
		var splField = new Array (
							f_query_add_mod.document.ca_consultation_param_form.max_consultation_practitioner,
							f_query_add_mod.document.ca_consultation_param_form.back_date_consultation,
			                f_query_add_mod.document.ca_consultation_param_form.max_consultation_speciality,
							f_query_add_mod.document.ca_consultation_param_form.amend_consultation_list, 
		                    f_query_add_mod.document.ca_consultation_param_form.min_duration_recquired		          
							);


		var splFieldName = new Array (
							 f_query_add_mod.getLabel("eCA.MaxConsultationPractitioner.label",'CA'),							 f_query_add_mod.getLabel("eCA.BackDateConsultationList.label",'CA'),							 f_query_add_mod.getLabel("eCA.MaxConsultationSpeciality.label",'CA'),
		                     f_query_add_mod.getLabel("eCA.AmendConsultationList.label",'CA'),
		                     f_query_add_mod.getLabel("eCA.MinDurationRecquired.label",'CA')		
							);

		if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{	
			
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				msg = "";

				if(f_query_add_mod.document.getElementById('managePatQueue').value=='Y')
				{
					if(!radioGroupValue('mngType'))
					{
						msg = msg+"APP-CA0373 Please select chart type for the Manage Patient Queue<br>";
					}
				}

				if(f_query_add_mod.document.getElementById('CAPatByLocn').value=='Y')
				{
					if(!radioGroupValue('CAType'))
					{
						msg = msg+"APP-CA0374 Please select chart type for the Clinician Access<br>";
					}	
				}
				//IN065070 starts
				if(isAESiteSpecific =='true')
				{
					if(f_query_add_mod.document.getElementById('aemanagePatQueue').value=='Y')
					{
						if(!radioGroupValue('aemngType'))
						{
							msg = msg+getMessage("SELECT_AEMANAGE_PATQUEUE",'CA');
						}
					}
					if(f_query_add_mod.document.getElementById('aeCAPatByLocn').value=='Y')
					{
						if(!radioGroupValue('aeCAType'))
						{
							msg = msg+getMessage("SELECT_CHARTTYPE_CA",'CA');
						}	
					}
				}
				//IN065070 ends			
				if(msg!='')
				{
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;			
					return
				}

				f_query_add_mod.document.ca_consultation_param_form.submit();
				f_query_add_mod.document.ca_consultation_param_form.action="../../servlet/eCA.CAConsultationParamServlet";
				f_query_add_mod.document.ca_consultation_param_form.target="messageFrame";
				f_query_add_mod.document.ca_consultation_param_form.method="post";
				f_query_add_mod.document.ca_consultation_param_form.submit();
		    }
	   }
	}

function onSuccess()
{
	f_query_add_mod.location.reload();
}
function reset()
{
	f_query_add_mod.document.ca_consultation_param_form.reset();	
	var isAESiteSpecific = f_query_add_mod.document.forms[0].isAESiteSpecific.value; //Added for IN065070

	if(f_query_add_mod.document.getElementById("CAPatByLocn").checked)
	{
		f_query_add_mod.document.getElementById("CAPatByLocn").value='Y';
		enableRadios(f_query_add_mod.document.getElementsByName('CAType'));
	}
	else
	{
		f_query_add_mod.document.getElementById("CAPatByLocn").value='N';
		disableRadios(f_query_add_mod.document.getElementsByName('CAType'));
	}

	if(f_query_add_mod.document.getElementById("managePatQueue").checked)
	{
		f_query_add_mod.document.getElementById("managePatQueue").value='Y';
		enableRadios(f_query_add_mod.document.getElementsByName('mngType'));
	}
	else
	{
		f_query_add_mod.document.getElementById("managePatQueue").value='N';
		disableRadios(f_query_add_mod.document.getElementsByName('mngType'));
	}
//IN065070 starts
	if(isAESiteSpecific =='true')
	{
		if(f_query_add_mod.document.getElementById("aeCAPatByLocn").checked)
		{
			f_query_add_mod.document.getElementById("aeCAPatByLocn").value='Y';
			enableRadios(f_query_add_mod.document.getElementsByName('aeCAType'));
		}
		else
		{
			f_query_add_mod.document.getElementById("aeCAPatByLocn").value='N';
			disableRadios(f_query_add_mod.document.getElementsByName('aeCAType'));
		}
	
		if(f_query_add_mod.document.getElementById("aemanagePatQueue").checked)
		{
			f_query_add_mod.document.getElementById("aemanagePatQueue").value='Y';
			enableRadios(f_query_add_mod.document.getElementsByName('aemngType'));
		}
		else
		{
			f_query_add_mod.document.getElementById("aemanagePatQueue").value='N';
			disableRadios(f_query_add_mod.document.getElementsByName('aemngType'));
		}
	}
//IN065070 ends
}	


function validateLimit(val)
{
	var ip_consult = 0;
	var reg_consult = document.ca_consultation_param_form.reg_consult.value ;
	var ref_consult = document.ca_consultation_param_form.ref_consult.value ;

	if(ip_consult==null||ip_consult=='')
	{
		ip_consult=0;
	}
	if(reg_consult==null||reg_consult=='')
	{
		reg_consult=0;
	}
	if(ref_consult==null||ref_consult=='')
	{
		ref_consult=0;
	}
   
	if(reg_consult!=0&&ref_consult!=0)
	{
		ip_consult = parseInt(reg_consult)+parseInt(ref_consult);
		document.ca_consultation_param_form.ip_consult.value = ip_consult;
	}
	else
	{
		document.ca_consultation_param_form.ip_consult.value = '';
	}
}

function CAPatByLocnClick()
{
	if(document.getElementById("CAPatByLocn").checked)
	{
		document.getElementById("CAPatByLocn").value='Y';
		enableRadios(document.getElementsByName('CAType'));
	}
	else
	{
		document.getElementById("CAPatByLocn").value='N';
		disableRadios(document.getElementsByName('CAType'));
	}
}

function managePatQueueClick()
{
	if(document.getElementById("managePatQueue").checked)
	{
		document.getElementById("managePatQueue").value='Y';
		enableRadios(document.getElementsByName('mngType'));
	}
	else
	{
		document.getElementById("managePatQueue").value='N';
		disableRadios(document.getElementsByName('mngType'));
	}
}

function selectedmngTypes(obj)
{
	document.getElementById("selectedmngType").value=obj.value;
}

function selectedCATypes(obj)
{
	document.getElementById("selectedCAType").value=obj.value;
}

function radioGroupValue(objName)
{
	var radList = f_query_add_mod.document.getElementsByName(objName);
	
	for (var i = 0; i < radList.length; i++) 
	{
		if(radList[i].checked)
			return true;
	}
}


//These are ok
function enableRadios(radList)
{
	//alert('216,radList=>'+radList.length);
	for (var i = 0; i < radList.length; i++) 
	{
		radList[i].disabled = false;
		//radList[i].checked = false;
	}
}

function disableRadios(radList)
{
	//alert('216,radList=>'+radList.length);
	for (var i = 0; i < radList.length; i++) 
	{
		radList[i].disabled = true;
		//radList[i].checked = false;
	}
}

function enableRadiosOnLoad(radList)
{
	//alert('radList=>'+radList.length);
	for (var i = 0; i < radList.length; i++) 
	{
		radList[i].disabled = false;
		//radList[i].checked = false;
	}
}

function disableRadiosOnLoad(radList)
{
	//alert('radList=>'+radList.length);
	for (var i = 0; i < radList.length; i++) 
	{
		radList[i].disabled = true;
		//radList[i].checked = false;
	}
}
//IN052254 Start.
function caRestUnBilledClick()
{
	if(document.getElementById("caRestUnBilled").checked)
	{
		document.getElementById("caRestUnBilled").value='Y';
	}
	else
	{
		document.getElementById("caRestUnBilled").value='N';
	}	
}
//IN052254 End.
//IN065070 start
function aeManagePatQueueClick()
{
	if(document.getElementById("aemanagePatQueue").checked)
	{
		document.getElementById("aemanagePatQueue").value='Y';
		enableRadios(document.getElementsByName('aemngType'));
	}
	else
	{
		document.getElementById("aemanagePatQueue").value='N';
		disableRadios(document.getElementsByName('aemngType'));
	}
}
function aeCAPatByLocnClick()
{
	if(document.getElementById("aeCAPatByLocn").checked)
	{
		document.getElementById("aeCAPatByLocn").value='Y';
		enableRadios(document.getElementsByName('aeCAType'));
	}
	else
	{
		document.getElementById("aeCAPatByLocn").value='N';
		disableRadios(document.getElementsByName('aeCAType'));
	}
}
//IN065070 ends
