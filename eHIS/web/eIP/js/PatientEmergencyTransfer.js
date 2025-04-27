
function cancel()
{
	window.parent.close();
}
function Confirm()
{	 
	parent.frames[1].document.forms[0].confirm.disabled = true;


		if(parent.frames[1].document.Emergency_Transfer_form.continue_yn.value != "N")
		{
			var flag = "F";
		
			if((parent.frames[1].document.Emergency_Transfer_form.fr_nursing_unit_code.value != parent.frames[1].document.Emergency_Transfer_form.nursing_unit.value)||			(parent.frames[1].document.Emergency_Transfer_form.fr_bed_class.value != parent.frames[1].document.Emergency_Transfer_form.Bedcode.value)||				(parent.frames[1].document.Emergency_Transfer_form.fr_bed_no.value != parent.frames[1].document.Emergency_Transfer_form.to_bed_no.value))
				flag = "T";

				
			if(flag == 'T')
			{
				var fields = new Array();
				fields[0] = parent.frames[1].document.Emergency_Transfer_form.transfer_date;
				fields[1] = parent.frames[1].document.Emergency_Transfer_form.transfer_type;
				fields[2] = parent.frames[1].document.Emergency_Transfer_form.nursing_unit_desc;
				fields[3] = parent.frames[1].document.Emergency_Transfer_form.service;
				fields[4] = parent.frames[1].document.Emergency_Transfer_form.Bedcode;
				fields[5] = parent.frames[1].document.Emergency_Transfer_form.bed_type_code;
				fields[6] = parent.frames[1].document.Emergency_Transfer_form.to_bed_no;
				fields[7] = parent.frames[1].document.Emergency_Transfer_form.Splcode_desc;
				fields[8] = parent.frames[1].document.Emergency_Transfer_form.pract_desc;
				
				var names = new Array();
				var date	= getLabel("eIP.EmergencyTransfer.label","IP")+" "+getLabel("Common.datetime.label","Common");
				names[0]	= date;
				names[1]	= getLabel("eIP.ReasonforTransfer.label","IP");
				names[2]	= getLabel("Common.nursingUnit.label","Common");
				names[3]	= getLabel("Common.service.label","Common");
				names[4]	= getLabel("Common.BedClass.label","common");
				names[5]	= getLabel("Common.bedtype.label","Common");
				names[6]	= getLabel("Common.bedno.label","Common");
				names[7]	= getLabel("Common.speciality.label","Common");
				names[8]	= getLabel("Common.practitioner.label","Common"); 

				if(checkFields1( fields, names)) 
				{
					
					if(parent.frames[1].document.Emergency_Transfer_form.bl_operational.value == 'Y')
					{	
						if(parent.frames[1].document.forms[0].bed_class_allowed.value=='Y' && parent.frames[1].document.forms[0].change_bed_class_yn.value=='Y')
						{
							BLCheckElig_emp();
						}
						else if(parent.frames[1].document.forms[0].bed_class_allowed.value=='N')
							BLCheckElig_emp();
						else
						applyone_emp('Y','N','');//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
					}
					else
						applyone_emp('Y','N','');//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
				}else{
					parent.frames[1].document.forms[0].confirm.disabled = false;
				}
			}
			else
			{
				parent.frames[1].document.forms[0].confirm.disabled = false;
				alert(self.getMessage('ATLEAST_BED_CHANGE','IP'));
			}
		}
		else
		{
			parent.frames[1].document.forms[0].confirm.disabled = false;
			parent.frames[1].document.Emergency_Transfer_form.continue_yn.value = "";
		}
	
}

function BLCheckElig_emp()
{
	var bed_ref = "parent.frames[1].document.Emergency_Transfer_form.transfer_type";
	var modified_bed_type_ref = "parent.frames[1].document.Emergency_Transfer_form.modified_bed_type_code";
	var url = parent.frames[2].location.href;
	var action_url="";
	var reasonForTransfer = parent.frames[1].document.Emergency_Transfer_form.transfer_type.value;//Added by Dharma on 24th Oct 2017 against ML-MMOH-CRF-0865.1 [IN:065405]

	if(url.indexOf("/servlet")!=-1)
		var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.Emergency_Transfer_form.tobedtype.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.Emergency_Transfer_form.billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.Emergency_Transfer_form.to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/PatientEmergencyTransfer.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
	else
		var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.Emergency_Transfer_form.tobedtype.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.Emergency_Transfer_form.billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.Emergency_Transfer_form.to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/PatientEmergencyTransfer.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.dummy_form1.submit();
}
function applyone_emp(difframe,bed_class_chk,reqRadioBtn)
{
	//call_function == 'EMERGENCY_TRANSFER'
	parent.frames[1].document.Emergency_Transfer_form.reqRadioBtn.value = reqRadioBtn;//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
	parent.frames[1].document.Emergency_Transfer_form.confirm.disabled = true;
	parent.frames[1].document.Emergency_Transfer_form.bed_class_chk.value = bed_class_chk;
	var val = "";
	if(parent.frames[1].document.Emergency_Transfer_form.call_function.value=='EMERGENCY_TRANSFER')
	{
		val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.PatientEmergencyTransferServlet' >";
		
	}
	
	var proceed = 'true';
	var mother_status = parent.frames[1].document.forms[0].mother_status.value;
	var transfer_wo_delink_yn = parent.frames[1].document.forms[0].transfer_wo_delink_yn.value;//Added for the CRF HSA-CRF-0035
	if (mother_status != '0' && transfer_wo_delink_yn=='Y') {		
		proceed=validateMotherBabyBed(parent.frames[1].document.forms[0].fr_nursing_unit_code.value,parent.frames[1].document.forms[0].nursing_unit.value,parent.frames[1].document.forms[0].to_bed_no.value,parent.frames[1].document.forms[0].patient_id2.value)
	}
		
	
	if(proceed!='true'){
		if(confirm(getMessage("TRANSFER_NOT_POSSIBLE","IP"))){	
			parent.frames[1].document.forms[0].transfer_wo_delink_yn.value='N';
			proceed='true';
		}
	}
			
	if(proceed=='true'){				
		for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++){
			val += "<input type='hidden' name='"+ parent.frames[1].document.forms[0].elements[i].name +"' id='"+ parent.frames[1].document.forms[0].elements[i].name +"' value=\""+ parent.frames[1].document.forms[0].elements[i].value +"\">"
		}
		val += "</form></body><html>";
		parent.frames[2].document.write(val);
		parent.frames[2].document.Dummy_form.submit();		
	}else{		
			parent.frames[1].document.Emergency_Transfer_form.confirm.disabled = false;
		}		
}
function enableInform()
{
	if (document.forms[0].block_bed.checked==true)
	{
		document.forms[0].bed_block_periond.disabled= false;
		document.forms[0].override.disabled	= false;
		document.getElementById("img_m").style.visibility	= "Visible";
	}
	else if(document.forms[0].block_bed.checked==false)
	{
		document.forms[0].bed_block_periond.value='';
		document.forms[0].bed_block_periond.disabled= true;
		document.forms[0].override.checked=false;
		document.forms[0].override.disabled	= true;
		document.getElementById("img_m").style.visibility	= "hidden";
	}
}

function validSpecialChars(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Bed Blocking Period";
	if(SpecialCharCheck( fields, names,'',"A",''))
	{
		checkForMaxPeriod();
		return true;
	}
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

function allowOnlyNumbers(event)
{
	if (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 46))
		return true;
	else return false;
}

function seDef()
{
	if (document.getElementById("img_m"))
	{
		document.getElementById("img_m").style.visibility	= "hidden";
	}
}

function setDesable_tfrDtls()
{
	if(document.forms[0].bed_class_allowed.value=='Y')
	{
	document.forms[0].Bedcode.disabled=true;
	document.forms[0].bed_type_code.disabled=true;
	}
}

function getOnload_tfrDtls() 
{
	var selected = document.forms[0].bed_type_code;
	while ( selected.options.length > 1 )
	selected.remove(selected.options[0]);
	var obj =document.forms[0].bed_type_code;
	var opt= document.createElement('Option');
	opt.text=document.forms[0].hid_tobedtypedesc.value; 
	opt.value=document.forms[0].hid_bed_type.value;
	obj.add(opt)
	opt.selected = true;

	//if(document.forms[0].bed_class_allowed.value=='Y')
	{
		document.forms[0].Bedcode.disabled=true;
		document.forms[0].bed_type_code.disabled=true;
	}

	if(document.forms[0].reason_for_reserved_bed!=null)
		document.forms[0].reason_for_reserved_bed.disabled=true;

}
function specialChar(obj,val)
{
	if(obj.value!='')
	{
		var fields1 = new Array(obj);
		var names1 = new Array(obj.name.toUpperCase());
		var messageFrame = ""; var error_page = "";
		if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
		{
			if(val=="Num")
			{
				if(CheckNum(obj))
					{
						 return true;
					}
					else 
					{
						 obj.focus();
						 obj.value='';
						 return false;
					}
			}
			else if(val=="Char")
			{
				return true;
			}
			return true;
		}
		else
		{
		   obj.focus()
		   obj.value='';
		   return false;
		}
	}
}
function focusFirst()
{
	document.forms[0].transfer_type.focus();

}
function checkForValues()
{
	if ((document.forms[0].nursing_unit_desc.value=="") && (document.forms[0].Splcode_desc.value==""))
	{
		flag = 2;
		var errorMsg = getMessage('NU_NOTNULL','IP') + getMessage('SPLTY_NOTNULL',"IP");
		alert(errorMsg);
		document.forms[0].nursing_unit_desc.focus();
	}
	else if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 2;
		var error = getMessage('NU_NOTNULL','IP');
		alert(error);
		document.forms[0].nursing_unit_desc.focus();
	}
	else if (document.forms[0].Splcode_desc.value=="")
	{
		flag = 2;
		var error = getMessage('SPLTY_NOTNULL',"IP");
		alert(error);
		document.forms[0].Splcode_desc.focus();
	}
}
function CheckNursingUnit()
	{		
		var call_function =document.forms[0].call_function.value
		if(call_function == 'EMERGENCY_TRANSFER'){
		var nursingunit=document.forms[0].nursing_unit_desc.value;
		if(nursingunit == '')
		{
		document.forms[0].service.value='';
		document.forms[0].sub_service.value='';
		var obj =document.forms[0].service;		
			var length  = obj.length;
			for(i=0;i<length;i++) 
			{
			obj.remove(1);
			}
		var obj1 =document.forms[0].sub_service;
			var length1  = obj1.length;
			for(i=0;i<length1;i++) 
			{
			obj1.remove(1);
			}
		}
		//if(document.Emergency_Transfer_form.nursing_unit_desc.value ==document.Emergency_Transfer_form.fr_nursing_unit_desc.value)
		if(document.forms[0].nursing_unit_desc.value ==document.forms[0].fr_nursing_unit_desc.value)
		{
		var error = getMessage('TFR_SAME_NU_NOT_ALLOW',"IP");
		error = error.replace('$',getLabel('Common.nursingUnit.label','Common'));
		alert(error);
		var obj =document.forms[0].service;		
		var length  = obj.length;
		for(i=0;i<length;i++) 
		{
			obj.remove(1);
		}
		var obj1 =document.forms[0].sub_service;
			var length1  = obj1.length;
			for(i=0;i<length1;i++) 
			{
			obj1.remove(1);
			}
		document.forms[0].nursing_unit_desc.value ="";

		document.forms[0].nursing_unit_desc.focus();
		return false;
		}
		}
	}

function popDynamicValues_emp()
{
	var call_function =document.forms[0].call_function.value;
	if(call_function == 'EMERGENCY_TRANSFER'){
	var fr_nursing_unit =	self.document.Emergency_Transfer_form.fr_nursing_unit_code.value;
	var to_nursing_unit=self.document.Emergency_Transfer_form.nursing_unit.value;
	
		if(fr_nursing_unit != to_nursing_unit)
		{
			self.document.Emergency_Transfer_form.to_daily_rate.value = '';
		}
	}
}
function PopulateService_emp()
{

	var call_function =document.forms[0].call_function.value;
	if(call_function == 'EMERGENCY_TRANSFER'){
	var nursingunit = self.document.Emergency_Transfer_form.nursing_unit.value;
	var patient_id=self.document.Emergency_Transfer_form.patient_id2.value;
	var change_bed_class_yn = '';
	if(self.document.Emergency_Transfer_form.change_bed_class_yn)
	change_bed_class_yn = self.document.Emergency_Transfer_form.change_bed_class_yn.value;

	var operStaionId = self.document.Emergency_Transfer_form.p_oper_stn_id.value;
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value='request_tfr'><input type='hidden' name='field2' id='field2' value='"+patient_id+"'> "+
	" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field9' id='field9' value='"+operStaionId+"' ><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.dum_form.submit();
	}
}

function beforeGetNursingUnit(aFacilityId, aLoginUser, aPatientClass)
{
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			NursingUnitLookup(aFacilityId, aLoginUser,aPatientClass);
	}
}

async function NursingUnitLookup(aFacilityId, aLoginUser, aPatientClass)
{
	var nursingUnitCode = document.forms[0].nursing_unit_desc.value;
	var Facility_ID	= aFacilityId;
	var Login_User	= aLoginUser;
	var patientclass = aPatientClass;
	var splty_code="";
	var pract_id="";
	var Operator_Station_ID="";
	var call_function =document.forms[0].call_function.value;
    var tit	= getLabel("Common.nursingUnit.label","Common");	
	var dialogHeight			= "400px" ;
	var dialogWidth				= "700px" ;
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var retVal =    new String();

	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&splty_cd="+splty_code+"&pract_id="+pract_id+"&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&patientclass="+patientclass+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&statics_yn=N"+"&call_function="+call_function+"&open_location_yn=Y";
	
	var retVal =  await window.showModalDialog(jsp_name,arguments,features);
	
	var arr=new Array();
	if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");

		document.forms[0].nursing_unit.value		=	arr[0];
		document.forms[0].nursing_unit_desc.value	=	arr[1];
		document.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value;
		popDynamicValues_emp(document.forms[0].nursing_unit);
		document.forms[0].nursing_unit_desc.focus();
		document.forms[0].Splcode.value='';
		document.forms[0].service.value='';
		document.forms[0].Splcode_desc.value='';
		document.forms[0].pract_desc.value='';
		document.forms[0].practid.value='';
		document.forms[0].sub_service.value='';
		PopulateService_emp();
	}
	else
	{
		document.forms[0].nursing_unit_desc.value='';
		document.forms[0].nursing_unit.value='';
		document.forms[0].Splcode_desc.value='';
		document.forms[0].service.value='';
		document.forms[0].Splcode_desc.value='';
		document.forms[0].pract_desc.value='';
		document.forms[0].practid.value='';
		document.forms[0].sub_service.value='';
	}
}
function enbldisbchk_tfrDtls(obj1)
{
	if(obj1.value!="")
	{ if(parent.frames[1].document.forms[0].bed_class_allowed.value=="Y")
		parent.frames[1].document.forms[0].bed_change.disabled = false;
	}
	else
 if(obj1.value=="")
	{
		if(parent.frames[1].document.forms[0].bed_class_allowed.value=="Y")
		{
		  parent.frames[1].document.forms[0].bed_change.disabled = true;
		  parent.frames[1].document.forms[0].bed_change.checked = false;
		}
		setEnable_tfrDtls();
	}
}
function setEnable_tfrDtls() 
{
	var call_function = document.forms[0].function_ID.value;
	if(parent.frames[1].document.forms[0].bed_class_allowed.value=="Y")
	{
	if (document.forms[0].bed_change.checked==true)
	{
		document.forms[0].bed_change.value="Y";
		document.forms[0].Bedcode.disabled=false;
		document.forms[0].bed_type_code.disabled=false;
		
			if(call_function == 'EMERGENCY_TRANSFER')
			{
				getBedClass();
			}
			else
				getBedtype_tfrDtls();
	}
	else
	{
		document.forms[0].bed_change.value="N";
		document.forms[0].Bedcode.disabled=true;

			if(call_function == 'EMERGENCY_TRANSFER')
			{
			var obj_bedcode = document.forms[0].Bedcode;
					var length  = obj_bedcode.length;
					for(i=0;i<length;i++) 
					{
						obj_bedcode.remove(1);
					}
					var opt_bedcode= document.createElement('Option');
					opt_bedcode.text=document.forms[0].hid_bed_class_descn.value; 
					opt_bedcode.value=document.forms[0].hid_bed_class.value;
					obj_bedcode.add(opt_bedcode)
					opt_bedcode.selected = true;			
			}
			else
			{
					document.forms[0].Bedcode.value=document.forms[0].hid_bed_class.value;
			}

		var obj = document.forms[0].bed_type_code;
		var length  = obj.length;
		for(i=0;i<length;i++) 
		{
			obj.remove(1);
		}
		var opt= document.createElement('Option');
		opt.text=document.forms[0].hid_tobedtypedesc.value; 
		opt.value=document.forms[0].hid_bed_type.value;
		obj.add(opt)
		opt.selected = true;
		document.forms[0].bed_type_code.disabled=true;
		document.forms[0].to_bed_no.value='';
		document.forms[0].to_room_no.value='';
	}
	}
	else
	if(parent.frames[1].document.forms[0].bed_class_allowed.value=="N")
	{
		document.forms[0].Bedcode.disabled=true;

			if(call_function == 'EMERGENCY_TRANSFER')
			{
			var obj_bedcode = document.forms[0].Bedcode;
					var length  = obj_bedcode.length;
					for(i=0;i<length;i++) 
					{
						obj_bedcode.remove(1);
					}
					var opt_bedcode= document.createElement('Option');
					opt_bedcode.text=document.forms[0].hid_bed_class_descn.value; 
					opt_bedcode.value=document.forms[0].hid_bed_class.value;
					obj_bedcode.add(opt_bedcode)
					opt_bedcode.selected = true;			
			}
			else
			{
					document.forms[0].Bedcode.value=document.forms[0].hid_bed_class.value;
			}

		var obj = document.forms[0].bed_type_code;
		var length  = obj.length;
		for(i=0;i<length;i++) 
		{
			obj.remove(1);
		}
		var opt= document.createElement('Option');
		opt.text=document.forms[0].hid_tobedtypedesc.value; 
		opt.value=document.forms[0].hid_bed_type.value;
		obj.add(opt)
		opt.selected = true;
		document.forms[0].bed_type_code.disabled=true;
		document.forms[0].to_bed_no.value='';
		document.forms[0].to_room_no.value='';
	}
}
function getBedClass()
{
	var obj1 = parent.frames[1].document.forms[0].nursing_unit;
	if((obj1.value!=null)&&(obj1.value!=""))
	{
	var bed_class = parent.frames[1].document.forms[0].Bedcode.value;
	
		var obj2 = parent.frames[1].document.forms[0].Bedcode;
		var length  = obj2.length;
		for(i=0;i<length;i++) 
		{
			obj2.remove(1);
		}

		var obj = parent.frames[1].document.forms[0].bed_type_code;
		length  = obj.length;


		for(i=0;i<length;i++) 
		{
			obj.remove(0);
		}

		var opt = parent.frames[1].document.createElement('OPTION'); 
		opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		opt.value= '';
		obj.add(opt);

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form1' id='dum_form1' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field4' id='field4' value='getBedClass'><input type='hidden' name='function_Id' id='function_Id' value='REQUEST_TRANSFER'><input type='hidden' name='nursingunitcode' id='nursingunitcode' value='"+obj1.value+"'></form></body></html>";
	parent.frames[2].document.write(HTMLVal);
	parent.frames[2].document.dum_form1.submit();
}
}
function PopulateSubService()
{
	var nursingunit = self.document.forms[0].nursing_unit.value;
	var serviceCode = self.document.forms[0].service.value;
	var change_bed_class_yn = '';
	if(self.document.forms[0].change_bed_class_yn)
	change_bed_class_yn = self.document.forms[0].change_bed_class_yn.value;
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form2' id='dum_form2' method='post'  action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='serviceCode' id='serviceCode' value='"+serviceCode+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
        parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);        
        parent.frames[2].document.dum_form2.submit();
 }
 function getBedtype_tfrDtls()
{
	var bed_class = self.document.forms[0].Bedcode.value;
	var nursing_unit = self.document.forms[0].nursing_unit.value;
	self.document.forms[0].to_bed_no.value='';
	self.document.forms[0].to_room_no.value='';
	var obj =document.forms[0].bed_type_code;
	var length  = obj.length;
	var bed_type_code = document.forms[0].bed_type_code.value;
/*	for(i=0;i<length;i++) 
	{
		obj.remove(1);


	}*/	
		for(i=0;i<length;i++) 
		{
			obj.remove(0);
		}

	var opt = parent.frames[1].document.createElement('OPTION'); 
	opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value= '';
	obj.add(opt);

	var change_bed_class_yn = '';
	if(self.document.forms[0].change_bed_class_yn)
		change_bed_class_yn = self.document.forms[0].change_bed_class_yn.value;
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
	" <input type='hidden' name='field3' id='field3' value='"+nursing_unit+"'><input type='hidden' name='field4' id='field4' value='getBedType'><input type='hidden' name='bed_class' id='bed_class' value='"+bed_class+"'><input type='hidden' name='bed_type_code' id='bed_type_code' value='"+bed_type_code+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'> </form></body></html>";
	parent.frames[2].document.write(HTMLVal);
	parent.frames[2].document.dum_form.submit();
}

function ChangeBedtype_tfrDtls()
{
	self.document.forms[0].to_bed_no.value='';
	self.document.forms[0].to_room_no.value='';
	
	var from_bed_class	= document.forms[0].fr_bed_class.value;
	var to_bed_class	= document.forms[0].Bedcode.value;
	var from_bed_type	= document.forms[0].from_bed_type.value;
	var to_bed_type		= document.forms[0].bed_type_code.value;

	if( (from_bed_class == to_bed_class) && (from_bed_type == to_bed_type) )
	{
		self.document.forms[0].bed_change.checked = false;
		self.document.forms[0].bed_change.value = "N";
		self.document.forms[0].bed_change.onclick();
	}

}

function getRoomNo_tfrDtls(obj)
{
	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
			document.forms[0].to_room_no.value = '';	
			document.forms[0].to_daily_rate.value = '';
			var bed_change_YN =self.document.forms[0].bed_class_allowed.value;
			var nursingunit = document.forms[0].nursing_unit.value;
			var fr_bed_no = document.forms[0].fr_bed_no.value;
			var bedno = obj.value;
			if(self.document.forms[0].bed_class_allowed.value=='Y')
			{
			var Bedcode = self.document.forms[0].Bedcode.value;
			var bed_type_code = self.document.forms[0].bed_type_code.value;
			}

			var url = parent.frames[2].location.href;
			var action_url="";
			if(url.indexOf("/servlet")!=-1){
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value='"+Bedcode+"'><input type='hidden' name='field2' id='field2' value='"+bed_type_code+"'> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='fr_bed_no' id='fr_bed_no' value='"+fr_bed_no+"'><input type='hidden' name='field9' id='field9' value='"+bed_change_YN+"'></form></body></html>";
			}
			else
			{
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value='"+Bedcode+"'><input type='hidden' name='field2' id='field2' value='"+bed_type_code+"'> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='fr_bed_no' id='fr_bed_no' value='"+fr_bed_no+"'><input type='hidden' name='field9' id='field9' value='"+bed_change_YN+"'></form></body></html>";
			}

		
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.dum_form.submit();
		}
	}
	
}

function clearRoom()
{
	if (document.forms[0].to_bed_no.value=="")
	document.forms[0].to_room_no.value="";
}
function checkForNursing()
{
	if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 1;
		var error = getMessage('NU_NOTNULL','IP');
		alert(error);
		document.forms[0].nursing_unit_desc.focus();
	}
}
function clearVal_tfrDtls(obj)
{
	if(obj.name=='Splcode_desc')
	{
		if(self.document.forms[0].Splcode_desc.value == '')
		{
			self.document.forms[0].Splcode.value='';
			self.document.forms[0].spec_desc_hid.value='';

			self.document.forms[0].practid.value='';
			self.document.forms[0].pract_desc.value='';
			self.document.forms[0].pract_desc_hid.value='';
		}
	}
}
function checkTxtVal(aSpecialtID, Facility_ID)
{
	if(document.forms[0].Splcode_desc.value == "")
		getSpecialty(aSpecialtID, Facility_ID)
}
function checkPractTxtVal(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc.value == "")
		getPractitionerLocal(obj,target, aFacilityID);
}
function BeforeGetSpecialty(aSpecialtID, Facility_ID)
{
	if(document.forms[0].spec_desc_hid.value != document.forms[0].Splcode_desc.value)
	{
		if(document.forms[0].Splcode_desc.value!="")
			getSpecialty(aSpecialtID, Facility_ID);
	}
}

function BeforeGetPractitioner(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_desc.value)
	{
		if(document.forms[0].pract_desc.value!= "")
			getPractitionerLocal(obj,target, aFacilityID)
	}
}
async function getSpecialty(aSpecialtID, Facility_ID)
{
	checkForNursing();
	var target			= document.forms[0].Splcode_desc;
	var locale			= document.forms[0].locale1.value;
	var code			= document.forms[0].nursing_unit.value;
	var FacilityID		= Facility_ID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	sql	=	"Select a.speciality_code code,a.short_desc description from AM_SPECIALITY_LANG_VW a, IP_NURS_UNIT_FOR_SPECIALTY b where a.language_id='"+locale+"' and a.eff_status like ? and a.speciality_code=b.specialty_code and b.facility_id like ? and b.nursing_unit_code='"+code+"' and upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?) ";
    tit=getLabel("Common.speciality.label","Common");

	dataNameArray[0]	= "eff_status" ;
	dataValueArray[0]	= "E";
	dataTypeArray[0]	= STRING;

	dataNameArray[1]	= "b.facility_id" ;
	dataValueArray[1]	= FacilityID;
	dataTypeArray[1]	= STRING;

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "3, 4";
	argumentArray[5] = aSpecialtID.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].Splcode_desc.value=arr[1];
		document.forms[0].spec_desc_hid.value = document.forms[0].Splcode_desc.value;
		document.forms[0].pract_desc.value='';
		document.forms[0].practid.value='';
		PopulateMedicalTeam();
		document.forms[0].Splcode_desc.focus();
	}
	else
	{
		document.forms[0].Splcode_desc.value="";
		document.forms[0].Splcode.value="";
		document.forms[0].pract_desc.value="";
		document.forms[0].practid.value="";
		document.forms[0].team_id.value="";
	}
}
function getPractitionerLocal(obj,target, aFacilityID)
{
	checkForValues();
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";

	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].practid.name;

	var nursing_unit_code	= document.forms[0].nursing_unit.value;
	var spl_code			= document.forms[0].Splcode.value;
	var facility_id = aFacilityID;
    var locale = "";
	if(document.forms[0].additional_locale)
		locale = document.forms[0].additional_locale.value;
	else
		locale = document.forms[0].locale.value;

	getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");

} 

function validateMotherBabyBed(frnursingunit,nursing_unit,bed_no,patId){

	var xmlStr ="<root><SEARCH step='Delink' ";
	xmlStr +=" /></root>";
	 
	var param="&frnursingunitcode="+frnursingunit+"&tonursingunitcode="+nursing_unit+"&to_bed_no="+bed_no+"&patient_id="+patId;
	
	var temp_jsp="../../eIP/jsp/BookingGetExpDaysDate.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	//responseText= trimString(responseText);
	return responseText;
	
}

