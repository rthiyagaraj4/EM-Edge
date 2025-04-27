function submitForm()
{
	var priorty_value=parent.frames[1].document.BedBookingTransfer_form.cnt_pririty.value;
	
	if(eval(priorty_value)>0)
	{
		PopulateExphrs();
	}
	var pref_date_time = convertDate(document.forms[0].pref_date_time.value,'DMYHM',localeName,'en');
	var sysdate = document.forms[0].sysdate.value;

	/*Monday, July 26, 2010 , added for 22884*/
	if(!isAfter(pref_date_time,sysdate,'DMYHM','en'))
	{
		error = getMessage("DATE1_LT_DATE2","IP") ;
		error = error.replace("#", getLabel("Common.SystemDate.label","Common"));
		error = error.replace("$", getLabel("eIP.PreferredDateTime.label","IP"));
		alert(error);
		pref_date_time.select();
		return false;
	}
	setTimeout('submitForm1()',100);
		
}

function submitForm1()
{
	var allow_transfer=document.BedBookingTransfer_form.allow_transfer.value;
	var reserve_bed_on_tfr_yn=document.BedBookingTransfer_form.reserve_bed_on_tfr_yn.value;
	if(parent.frames[1].document.BedBookingTransfer_form.fr_nursing_unit_code.value != parent.frames[1].document.BedBookingTransfer_form.nursing_unit.value)
	{
		flag = "T";
	}

	if(flag == "T")
	{
		var fields = new Array();
		
		if(allow_transfer == 'Y'){
		fields[0] = parent.frames[1].document.BedBookingTransfer_form.nursing_unit_desc;
		fields[1] = parent.frames[1].document.BedBookingTransfer_form.transfer_type;
		fields[2] = parent.frames[1].document.BedBookingTransfer_form.pref_date_time;
		fields[3] = parent.frames[1].document.BedBookingTransfer_form.service;
		fields[4] = parent.frames[1].document.BedBookingTransfer_form.Splcode_desc;
		fields[5] = parent.frames[1].document.BedBookingTransfer_form.pract_desc;
		fields[6] = parent.frames[1].document.BedBookingTransfer_form.Bedcode;
		fields[7] = parent.frames[1].document.BedBookingTransfer_form.bed_type_code;
		var names = new Array (
			getLabel("Common.nursingUnit.label","Common"),
			getLabel("eIP.ReasonforTransfer.label","IP"),
			getLabel("Common.PreferredDate.label","Common"),
			getLabel("Common.service.label","Common"),	
     		getLabel("Common.speciality.label","Common"),					
			getLabel("Common.practitioner.label","Common"),		
			getLabel("Common.BedClass.label","common"),
			getLabel("Common.bedtype.label","Common"));
		}else
		{
			if(reserve_bed_on_tfr_yn == 'Y'){

				if(parent.frames[1].document.BedBookingTransfer_form.reserved_bed_yn.checked == true ){

				fields[0] = parent.frames[1].document.BedBookingTransfer_form.nursing_unit_desc;
				fields[1] = parent.frames[1].document.BedBookingTransfer_form.transfer_type;
				fields[2] = parent.frames[1].document.BedBookingTransfer_form.pref_date_time;
				fields[3] = parent.frames[1].document.BedBookingTransfer_form.service;
				fields[4] = parent.frames[1].document.BedBookingTransfer_form.Splcode_desc;
				fields[5] = parent.frames[1].document.BedBookingTransfer_form.pract_desc;
				fields[6] = parent.frames[1].document.BedBookingTransfer_form.Bedcode;
				fields[7] = parent.frames[1].document.BedBookingTransfer_form.bed_type_code;
				fields[8] = parent.frames[1].document.BedBookingTransfer_form.reason_for_reserved_bed;
				var names = new Array (
					getLabel("Common.nursingUnit.label","Common"),
					getLabel("eIP.ReasonforTransfer.label","IP"),
					getLabel("Common.PreferredDate.label","Common"),
					getLabel("Common.service.label","Common"),	
					getLabel("Common.speciality.label","Common"),					
					getLabel("Common.practitioner.label","Common"),		
					getLabel("Common.BedClass.label","common"),
					getLabel("Common.bedtype.label","Common"),
					getLabel("eIP.ReasonforReserveBed.label","IP"));
				}
				else{

					fields[0] = parent.frames[1].document.BedBookingTransfer_form.nursing_unit_desc;
					fields[1] = parent.frames[1].document.BedBookingTransfer_form.transfer_type;
					fields[2] = parent.frames[1].document.BedBookingTransfer_form.pref_date_time;
					fields[3] = parent.frames[1].document.BedBookingTransfer_form.service;
					fields[4] = parent.frames[1].document.BedBookingTransfer_form.Splcode_desc;
					fields[5] = parent.frames[1].document.BedBookingTransfer_form.pract_desc;
					fields[6] = parent.frames[1].document.BedBookingTransfer_form.Bedcode;
					fields[7] = parent.frames[1].document.BedBookingTransfer_form.bed_type_code;
					var names = new Array (
						getLabel("Common.nursingUnit.label","Common"),
						getLabel("eIP.ReasonforTransfer.label","IP"),
						getLabel("Common.PreferredDate.label","Common"),
						getLabel("Common.service.label","Common"),	
						getLabel("Common.speciality.label","Common"),					
						getLabel("Common.practitioner.label","Common"),		
						getLabel("Common.BedClass.label","common"),
						getLabel("Common.bedtype.label","Common"));
				}
			}
			else
			{
				
				fields[0] = parent.frames[1].document.BedBookingTransfer_form.nursing_unit_desc;
				fields[1] = parent.frames[1].document.BedBookingTransfer_form.transfer_type;
				fields[2] = parent.frames[1].document.BedBookingTransfer_form.pref_date_time;
				fields[3] = parent.frames[1].document.BedBookingTransfer_form.service;
				fields[4] = parent.frames[1].document.BedBookingTransfer_form.Splcode_desc;
				fields[5] = parent.frames[1].document.BedBookingTransfer_form.pract_desc;
				fields[6] = parent.frames[1].document.BedBookingTransfer_form.Bedcode;
				fields[7] = parent.frames[1].document.BedBookingTransfer_form.bed_type_code;
				var names = new Array (
					getLabel("Common.nursingUnit.label","Common"),
					getLabel("eIP.ReasonforTransfer.label","IP"),
					getLabel("Common.PreferredDate.label","Common"),
					getLabel("Common.service.label","Common"),	
					getLabel("Common.speciality.label","Common"),					
					getLabel("Common.practitioner.label","Common"),		
					getLabel("Common.BedClass.label","common"),
					getLabel("Common.bedtype.label","Common"));
			}
		}
		

		if(checkFields1( fields, names)) 
		{
	
			parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = true;
			/*10/9/2008 CRF 3698 SRR20056-CRF-0228*/
	
	var bed_no=document.BedBookingTransfer_form.fr_bed_no.value;
	var r_bed_no=document.BedBookingTransfer_form.r_bed_no.value;
	var r_nursing_unit=document.BedBookingTransfer_form.r_nursing_unit.value;
	var r_nursing_unit_desc=document.BedBookingTransfer_form.r_nursing_unit_desc.value;
	var allow_transfer=document.BedBookingTransfer_form.allow_transfer.value;
	var allow_multiple_bed_for_resv_yn=document.BedBookingTransfer_form.allow_multiple_bed_for_resv_yn.value;
	var reserve_bed_on_tfr_yn=document.BedBookingTransfer_form.reserve_bed_on_tfr_yn.value;
	var to_nursing_unit=document.BedBookingTransfer_form.nursing_unit.value;
	var reserved_bed_cont=parseInt(document.BedBookingTransfer_form.reserved_bed_cont.value);
	
if(reserve_bed_on_tfr_yn == 'Y'){
	if(allow_multiple_bed_for_resv_yn == 'N'){
		if (allow_transfer=='N'){
			if(r_bed_no=='' ){
				if(document.BedBookingTransfer_form.reserved_bed_yn.checked == true){
					var valid=confirm(getMessage("RESERVED_BED_CONFIRM","IP"));
					if(valid){
						document.forms[0].res_bed_no.value=bed_no;
						document.forms[0].res_room_no.value=document.BedBookingTransfer_form.fr_room_no.value;
						document.forms[0].res_nursing_unit.value=document.BedBookingTransfer_form.fr_nursing_unit_code.value;
					}else{
					parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = false;
					return false;
					}
				}else{
					document.forms[0].res_bed_no.value='';
					document.forms[0].res_room_no.value='';
					document.forms[0].res_nursing_unit.value='';
				}
			}else{
				if(document.BedBookingTransfer_form.reserved_bed_yn.checked == true && reserved_bed_cont > 0){
					var valid = getMessage("RESERV_BED_CONFIRM_CANCELLED","IP");
					valid = valid.replace("$",r_nursing_unit_desc);
					valid = valid.replace("#",r_bed_no);
					valid = confirm(valid);
					if(valid){
						document.forms[0].res_bed_no.value='';
						document.forms[0].res_room_no.value='';
						document.forms[0].res_nursing_unit.value='';
					}else{
						/*document.forms[0].res_bed_no.value=bed_no;
						document.forms[0].res_room_no.value=document.BedBookingTransfer_form.fr_room_no.value;
						document.forms[0].res_nursing_unit.value=document.BedBookingTransfer_form.fr_nursing_unit_code.value;*/
						parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = false;
						return false;
					}
				}else{
					
					if(to_nursing_unit != r_nursing_unit && reserved_bed_cont > 0){
			
						var valid = getMessage("RESERV_BED_CANCELLED","IP");
						valid = valid.replace("$",r_nursing_unit_desc);
						valid = valid.replace("#",r_bed_no);
						valid = confirm(valid);
						if(valid){
							document.forms[0].res_bed_no.value='';
							document.forms[0].res_room_no.value='';
							document.forms[0].res_nursing_unit.value='';
						}else{
							window.close();
						}
					}
				}
				
			}
		}
	}	
}/*10/9/2008 CRF 3698 SRR20056-CRF-0228*/
			if(parent.frames[1].document.BedBookingTransfer_form.bl_interfaced_yn.value == 'Y')
			{
				if(parent.frames[1].document.forms[0].bed_class_allowed.value=='Y' && parent.frames[1].document.forms[0].change_bed_class_yn.value=='Y')
				{	
				
					BLCheckElig();
				} 
				else if(document.forms[0].bed_class_allowed.value=='Y' && document.forms[0].change_bed_class_yn.value=='N')
				{  
				
					if(document.forms[0].bed_change.checked==false)
						{  
						
							BLCheckElig();

						}
					else{
						
						applyone('Y','N','');//Modified by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
					}
				}
				else
				{  
				
					applyone('Y','N','');//Modified by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
				}
			}
			else
			{
				applyone('Y','N','');//Modified by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
			}
			parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = false;
		}
		else
		{
			
			parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = false;
		}
	}
	else
		parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = false;
}

function BLCheckElig()
{
	var bed_ref = "parent.frames[1].document.forms[0].transfer_type";
	var modified_bed_type_ref = "parent.frames[1].document.forms[0].modified_bed_type_code";
	var url = parent.frames[2].location.href;
	var reasonForTransfer = parent.frames[1].document.forms[0].transfer_type.value;//Added by Dharma on 24th Oct 2017 against ML-MMOH-CRF-0865.1 [IN:065405]
	var action_url="";
	if(url.indexOf("/servlet")!=-1)
	{
		var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.forms[0].bed_type_code.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.forms[0].billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.forms[0].to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/BedBookingTransfer.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
	}
	else
	{
		var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.forms[0].bed_type_code.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.forms[0].billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.forms[0].to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/BedBookingTransfer.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
	}
	/*parent.frames[1].document.forms[0].action="../../servlet/eIP.BedBookingTransferServlet?res_bed_no="+res_bed_no;
	parent.frames[1].document.forms[0].target="Dummy_frame";*/
	
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.dummy_form1.submit();
}

function applyone(difframe, obj, reqRadioBtn)
{
	parent.frames[1].document.forms[0].reqRadioBtn.value = reqRadioBtn;//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
	parent.frames[1].document.forms[0].confirmValue.value = obj;
	var function_name =parent.frames[1].document.forms[0].call_function.value;
	if(function_name=='Request_Trasnfer')
	{
		CheckNUnitBedClass();
	}
	else
	{
		parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = true;
		
		var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.BedBookingTransferServlet'>";
		for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++)
		{
		   val += "<input type='hidden' name='"+ parent.frames[1].document.forms[0].elements[i].name +"' id='"+ parent.frames[1].document.forms[0].elements[i].name +"' value=\""+ parent.frames[1].document.forms[0].elements[i].value +"\">"
		}
		val += "</form></body><html>";
		parent.frames[2].document.write(val);			
		//parent.frames[2].document.Dummy_form.submit();
	}
}
function CheckNUnitBedClass() 
{
	parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = true;
	var to_bed_class = parent.frames[1].document.forms[0].Bedcode.value;
	var to_bed_type = parent.frames[1].document.forms[0].bed_type_code.value;
	var fr_nursing_unit_code = parent.frames[1].document.forms[0].nursing_unit.value;
	var function_name =parent.frames[1].document.forms[0].call_function.value;
	var deactivate_pseudo_bed_yn =parent.frames[1].document.forms[0].deactivate_pseudo_bed_yn.value;
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field9' id='field9' value='validateNUnitBedClass'><input type='hidden' name='to_bed_class' id='to_bed_class' value='"+to_bed_class+"'><input type='hidden' name='fr_nursing_unit_code' id='fr_nursing_unit_code' value='"+fr_nursing_unit_code+"'><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='to_bed_type' id='to_bed_type' value='"+to_bed_type+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'></form></body></html>";

	parent.frames[2].document.write(HTMLVal);
	parent.frames[2].document.dum_form.submit();
}

function onBedClassChange(obj)
{
}

function cancel()
{
	window.close();
}

function getRoomNo(obj)
{
	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
		self.document.BedBookingTransfer_form.to_daily_rate.value = '';
		var nursingunit = self.document.BedBookingTransfer_form.nursing_unit.value;
		var change_bed_class_yn = '';
		if(self.document.BedBookingTransfer_form.change_bed_class_yn)
		change_bed_class_yn = self.document.BedBookingTransfer_form.change_bed_class_yn.value;
		var bedno = obj.value;
		var url = parent.frames[2].location.href;
		var action_url="";
		if(url.indexOf("/servlet")!=-1){
			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/TransferValidation.jsp'>"+
			" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
			" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+bedno+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
			}
			else{
			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
			" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
			" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+bedno+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
			}
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
		}
	}
}

function popDynamicValues()
{
	var call_function =document.forms[0].call_function.value;
	if(call_function == 'Request_Trasnfer'){
		var fr_nursing_unit =	self.document.BedBookingTransfer_form.fr_nursing_unit_code.value;
		var to_nursing_unit=self.document.BedBookingTransfer_form.nursing_unit.value;
	
	
		if(fr_nursing_unit != to_nursing_unit)
		{
			self.document.BedBookingTransfer_form.to_daily_rate.value = '';
		}
	}
	else if(call_function == 'Request_Trasnfer'){
		var fr_nursing_unit =	self.document.Emergency_Transfer_form.fr_nursing_unit_code.value;
		var to_nursing_unit=self.document.Emergency_Transfer_form.nursing_unit.value;
		if(fr_nursing_unit != to_nursing_unit)
		{
			self.document.Emergency_Transfer_form.to_daily_rate.value = '';
		}
	}
}

function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck1(fields[i].value)) {}
		else	
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n";
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}



function trimCheck1(inString)
{
	if((inString == null) || (inString == null))
		return false;
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}

function ComputeBlDtl()
{

	var fm_nur_code	= document.forms[0].fr_nursing_unit_code;
	var to_nur_code	= document.forms[0].nursing_unit;

	var fm_bed_no	= document.forms[0].fr_bed_no;
	var to_bed_no	= document.forms[0].to_bed_no;
	
	var fm_bed_class= document.forms[0].fr_bed_class;
	var to_bed_class= document.forms[0].Bedcode;

	var frm_bed_type= document.forms[0].fr_bed_type1;
	var to_bed_type	= document.forms[0].bed_type_code;

	var trans_code	= document.forms[0].transfer_type;
	var encount_id	= document.forms[0].encounter_id1;
	var facility_id	= document.forms[0].facility_id;
	
	var fields = new Array();
	fields[0] = document.forms[0].transfer_type;
	fields[1] = document.forms[0].Bedcode;
	fields[2] = document.forms[0].bed_type_code;
	fields[3] = document.forms[0].to_bed_no;

	var names = new Array (
		getLabel("eIP.ReasonforTransfer.label","IP"),
		getLabel("Common.BedClass.label","common"),
		getLabel("Common.bedtype.label","Common"),
		getLabel("Common.bedno.label","Common") );

	if(checkFields1( fields, names)) 
	{
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='BLBedTrans' id='BLBedTrans' method='post' action='../../eBL/jsp/BLBedTrans.jsp'>"+
		"<input type='hidden' name='fm_nur_code' id='fm_nur_code' value='"+fm_nur_code.value+"'>"+
		"<input type='hidden' name='to_nur_code' id='to_nur_code' value='"+to_nur_code.value+"'> "+
		"<input type='hidden' name='fm_bed_no' id='fm_bed_no' value='"+fm_bed_no.value+"'> "+
		"<input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no.value+"'> "+
		"<input type='hidden' name='fm_bed_class' id='fm_bed_class' value='"+fm_bed_class.value+"'> "+
		"<input type='hidden' name='to_bed_class' id='to_bed_class' value='"+to_bed_class.value+"'> "+
		"<input type='hidden' name='from_bed_type' id='from_bed_type' value='"+frm_bed_type.value+"'> "+
		"<input type='hidden' name='to_bed_type' id='to_bed_type' value='"+to_bed_type.value+"'> "+
		"<input type='hidden' name='trans_code' id='trans_code' value='"+trans_code.value+"'> "+
		"<input type='hidden' name='encount_id' id='encount_id' value='"+encount_id.value+"'> "+
		"<input type='hidden' name='facility_id' id='facility_id' value='"+facility_id.value+"'> "+
		"</form></body></html>";
		
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.BLBedTrans.submit();
	}
}

function fetchValForBedClass(obj){}
// Added by Mohamed
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


// By Annadurai 2/6/2004., to use Common Lookup starts.,
var flag = 0;
//Added param PatientClass, Modified by kishore on 5/11/2004
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
	if(call_function == 'EMERGENCY_TRANSFER')
	{
		var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&splty_cd="+splty_code+"&pract_id="+pract_id+"&login_user="+Login_User+"&oper_id="+document.forms[0].p_oper_stn_id.value+"&patientclass="+patientclass+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&statics_yn=N"+"&call_function="+call_function+" ";

	}else
	{
		var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&splty_cd="+splty_code+"&pract_id="+pract_id+"&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&patientclass="+patientclass+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&statics_yn=N"+"&call_function="+call_function+"&open_location_yn=Y";
	}
	
	var retVal =  await window.showModalDialog(jsp_name,arguments,features);
	
	var arr=new Array();
	if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");
		document.forms[0].nursing_unit.value		=	arr[0];
		document.forms[0].nursing_unit_desc.value	=	arr[1];
		document.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value;
		popDynamicValues(document.forms[0].nursing_unit);
		document.forms[0].nursing_unit_desc.focus();
		//Added for this CRF GHL-CRF-0340
		var facilityId="";
		if(call_function=="Request_Trasnfer")facilityId=document.forms[0].request_facilityId.value;
		if(call_function=="EMERGENCY_TRANSFER")facilityId=document.forms[0].facility_id.value;		
		if((call_function=="Request_Trasnfer")||(call_function=="EMERGENCY_TRANSFER")){
		Specialitycheck(document.forms[0].nursing_unit.value,facilityId,document.forms[0].Splcode.value);
		Practitionercheck(document.forms[0].nursing_unit.value,facilityId,document.forms[0].practid.value);
		}						
		if((call_function=="Request_Trasnfer"&&parseInt(document.forms[0].specialtyCheck.value)==0) || (call_function=="EMERGENCY_TRANSFER"&&parseInt(document.forms[0].specialtyCheck.value)==0)){ 
		document.forms[0].Splcode.value='';		
		document.forms[0].Splcode_desc.value='';		
		}if((call_function=="Request_Trasnfer"&&parseInt(document.forms[0].practitionerCheck.value)==0) || (call_function=="EMERGENCY_TRANSFER"&&parseInt(document.forms[0].practitionerCheck.value)==0)){ 
		document.forms[0].pract_desc.value='';
		document.forms[0].practid.value='';
		}if(!(document.forms[0].call_function.value=="Request_Trasnfer")&&!(document.forms[0].call_function.value=="EMERGENCY_TRANSFER")){  
		document.forms[0].Splcode.value='';		
		document.forms[0].Splcode_desc.value='';
		document.forms[0].pract_desc.value='';
		document.forms[0].practid.value='';
		}
		//End GHL-CRF-0340
		
		document.forms[0].service.value='';
		document.forms[0].sub_service.value='';
		PopulateService();
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
function PopulateService()
{
	var call_function =document.forms[0].call_function.value;
	//Maheshwaran added for GHL-CRF-0362
	//Start
	if(call_function == 'confirm_request')
	{
	var nursingunit = self.document.ConfirmCancelTransfer_form.nursing_unit.value;
	var patient_id=self.document.ConfirmCancelTransfer_form.patient_id2.value;
	var change_bed_class_yn = '';
	if(self.document.ConfirmCancelTransfer_form.change_bed_class_yn)
	change_bed_class_yn = self.document.ConfirmCancelTransfer_form.change_bed_class_yn.value;

	var operStaionId = self.document.ConfirmCancelTransfer_form.p_oper_stn_id.value;
	//End
	}
	else if(call_function == 'Request_Trasnfer'){
	var nursingunit = self.document.BedBookingTransfer_form.nursing_unit.value;
	var patient_id=self.document.BedBookingTransfer_form.patient_id2.value;
	var change_bed_class_yn = '';
	if(self.document.BedBookingTransfer_form.change_bed_class_yn)
	change_bed_class_yn = self.document.BedBookingTransfer_form.change_bed_class_yn.value;

	var operStaionId = self.document.BedBookingTransfer_form.p_oper_stn_id.value;
	}else if(call_function == 'EMERGENCY_TRANSFER'){
	var nursingunit = self.document.Emergency_Transfer_form.nursing_unit.value;
	var patient_id=self.document.Emergency_Transfer_form.patient_id2.value;
	var change_bed_class_yn = '';
	if(self.document.Emergency_Transfer_form.change_bed_class_yn)
	change_bed_class_yn = self.document.Emergency_Transfer_form.change_bed_class_yn.value;

	var operStaionId = self.document.Emergency_Transfer_form.p_oper_stn_id.value;
	}
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value='request_tfr'><input type='hidden' name='field2' id='field2' value='"+patient_id+"'> "+
	" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field9' id='field9' value='"+operStaionId+"' ><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.dum_form.submit();
}


	function defaultFields()
	{
		document.forms[0].nursing_unit.value=document.forms[0].fr_nursing_unit_code.value;
	}
	function focusFirst()
	{
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

function beforeGetNursingUnit(aFacilityId, aLoginUser, aPatientClass)
{
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			NursingUnitLookup(aFacilityId, aLoginUser,aPatientClass);
	}
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

function compareSystemDate(prefDate)
{
	var max_trn_date_time = document.forms[0].max_trn_date_time.value;
	if (prefDate.value != "" || prefDate.value != '')
	{
		/*if(prefDate.value != '' )
		{
			if(!doDateTimeChk(prefDate))
				{
					alert( getMessage("INVALID_DATE_TIME","SM") );
					prefDate.focus();
					prefDate.select();
					return ;
				}
		}*/
		if(!validDateObj(prefDate,"DMYHM",localeName))
		{
			return ;
		}
		
		/*if(!(ValidatePrefDateTime(document.forms[0].sysdate, prefDate)))
		{
			alert( getMessage("DATE1_LT_DATE2","IP") );
			error = error.replace("#", getLabel("eIP.ProcedureSurgeryDateTime.label","IP"));
			error = error.replace("$", getLabel("eIP.PrefAdmDateTime.label","IP"));
			alert(error);
			document.forms[0].pref_date_time.value =  document.forms[0].sysdate.value;
		}*/
		var greg_procedureSurgeryDateTime = convertDate(prefDate.value,'DMYHM',localeName,'en');
		var greg_maxtfrDateTime = convertDate(max_trn_date_time,'DMYHM',localeName,'en');
		var pref_date_time = convertDate(document.forms[0].pref_date_time.value,'DMYHM',localeName,'en');
		var sysdate = document.forms[0].sysdate.value;

		//if(isBefore(pref_date_time,sysdate,'DMYHM','en'))
		if(!isAfter(pref_date_time,sysdate,'DMYHM','en'))
		{
			error = getMessage("DATE1_LT_DATE2","IP") ;
			error = error.replace("#", getLabel("Common.SystemDate.label","Common"));
			error = error.replace("$", getLabel("eIP.PreferredDateTime.label","IP"));
			alert(error);
			document.forms[0].pref_date_time.value = convertDate(document.forms[0].sysdate.value,'DMYHM','en',localeName); 
		}//modified for 12/15/2008 6021  MF-SCF-0051
		else if(!isBefore(greg_maxtfrDateTime,pref_date_time,'DMYHM','en')){
	
			var error = getMessage('DATE1_LT_DATE2','IP');
			//var last_encounter = getLabel("Common.Last.label","Common")+" "+getLabel("Common.encounterdate.label","Common");
			/*Monday, December 06, 2010 , SRR20056-SCF-6173 [IN:025371]*/
			var last_encounter = getLabel("eIP.LastTransactionDateTime.label","ip_labels");
			error = error.replace('$',getLabel("Common.transferdate.label",'Common'));
			error = error.replace('#',last_encounter);
			alert(error);
			pref_date_time.select();
		}
	}
}

function ChkNumberInput(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789 /:';
else
   var strCheck = '0123456789 /:';

   var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;				
	key = String.fromCharCode(whichCode);			
    if (strCheck.indexOf(key) == -1) return false;  
}

function ValidatePrefDateTime(from,to)
{
    from = from.value
    to   = to.value

    var a=  from.split(" ")
    splitdate=a[0];
    splittime=a[1]

    var splitdate1 =splitdate.split("/")
    var splittime1= splittime.split(":")

     var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     a=  to.split(" ")
    splitdate=a[0];
    splittime=a[1]

     splitdate1 =splitdate.split("/")
     splittime1= splittime.split(":")
	 time3=splittime1[1]
	 var strCheck = ':0123456789';

	  for(var i=0;i<=time3.length;i++) {
                if (strCheck.indexOf(time3.charAt(i)) == -1){
					alert(getMessage("INVALID_DATE_TIME","SM"));
                    return false;
                    break;
                }
            }
     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	if(Date.parse(to_date) < Date.parse(from_date))
    {
        return false;
    }
    else
        return true;
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

function checkForNursing()
{
	if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 1;
		var error = getMessage('NU_NOTNULL','IP');
		alert(error);
		document.forms[0].nursing_unit_desc.focus();
	}
} // End of checkForNursing.

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

	/*
	var sql= " SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)  primary_specialty, a.gender gender, am_get_desc.AM_POSITION(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a,ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL(?,a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.sex LIKE (?) AND (a.POSITION_CODE  LIKE (?) OR a.POSITION_CODE  IS NULL) ";

	var sql2= "SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)  primary_specialty, a.gender gender, am_get_desc.AM_POSITION(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a,ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL(?,a.practitioner_id)) and UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.sex LIKE (?) AND (a.POSITION_CODE  LIKE (?) OR a.POSITION_CODE  IS NULL)  ";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	= "<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + spl_code+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);

	*/

} 
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if(objName == 'pract_descn')
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].authorized_practid.value=arr[0];
			document.forms[0].pract_descn.value=arr[1];	
		}
		else
		{
			document.forms[0].authorized_practid.value="";
			document.forms[0].pract_descn.value="";			
		}
	}
	else
	{
		if (retVal != null)
		{
			arr=retVal.split("~");
			//Maheshwaran added for GHL-CRF-0362
			if(document.forms[0].call_function.value=='confirm_request')
				{
				document.forms[0].practid4.value=arr[0];
				}
			//End
			document.forms[0].practid.value=arr[0];
			document.forms[0].pract_desc.value=arr[1];
			document.forms[0].pract_desc_hid.value = document.forms[0].pract_desc.value;
			PopulateMedicalTeam();
		}
		else
		{//Maheshwaran added for GHL-CRF-0362
			if(document.forms[0].call_function.value=='confirm_request')
				{
				document.forms[0].practid4.value="";
				}
				//End
			document.forms[0].practid.value="";
			document.forms[0].pract_desc.value="";
		}
	}
} 
		function callMe()
		{
			if (document.BedBookingTransfer_form.pract_desc.value == "")
			{
				var facId = document.BedBookingTransfer_form.facilityId.value;
				var teamId = document.BedBookingTransfer_form.team_id.value;
				var change_bed_class_yn = '';
				if(document.BedBookingTransfer_form.change_bed_class_yn)
					change_bed_class_yn = document.BedBookingTransfer_form.change_bed_class_yn.value;
				var sqlString = "SELECT pract_role, PRACTITIONER_ID FROM am_pract_for_team WHERE team_id = '"+ document.BedBookingTransfer_form.team_id.value + "' AND pract_role='C' and facility_id = '"+facId+"'";
				document.BedBookingTransfer_form.selecTeam.value=sqlString;
				var HTMLValue = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>";
				HTMLValue += " <input type='hidden' name='selectedTeam' id='selectedTeam' value='"+teamId+"'>";
				HTMLValue += " <input type='hidden' name='reqParam' id='reqParam' value= 'executeQuery' >";
				HTMLValue +=" <input type='hidden' name='sqlQuery' id='sqlQuery' value='"+sqlString+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
				parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLValue);
				parent.frames[2].document.dum_form.submit();
			}
		}
		function getMedicalTeam()
		{
			if (document.BedBookingTransfer_form.pract_desc.value != "")
			{
				 var facId = document.BedBookingTransfer_form.facilityId.value;
				 var Spl_code = document.BedBookingTransfer_form.Splcode.value;
				 var change_bed_class_yn = '';
				 if(document.BedBookingTransfer_form.change_bed_class_yn)
				 change_bed_class_yn = document.BedBookingTransfer_form.change_bed_class_yn.value;
				 var sqlString = "SELECT pract_role, PRACTITIONER_ID FROM am_pract_for_team WHERE team_id = '"+ document.BedBookingTransfer_form.team_id.value + "' AND pract_role='C' and facility_id = '"+facId+"'";

				document.BedBookingTransfer_form.selecTeam.value=sqlString;

				var HTMLValue = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' 							action='../../eIP/jsp/TransferValidation.jsp'>";
				HTMLValue += " <input type='hidden' name='Splcode' id='Splcode' value='"+Spl_code+"'>";
				HTMLValue += " <input type='hidden' name='reqParam' id='reqParam' value= 'getMedicalTeam' >";
				HTMLValue +=" <input type='hidden' name='sqlQuery' id='sqlQuery' value=\""+sqlString+"\"><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
				parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLValue);
				parent.frames[2].document.dum_form.submit();
			}
		}

		async function getPractID()
		{
			var nursing_unit_code	= "`"+document.forms[0].nursing_unit.value+"`";
			var spl_code			= "`"+document.forms[0].Splcode.value+"`";
			var facility_id			="`"+document.forms[0].facilityId.value+"`";

			if(nursing_unit_code != "")
			{
				if(spl_code != "")
				{
					var target				= document.forms[0].practid;
					var retVal				=    new String();
					var dialogTop			= "40";
					var dialogHeight		= "10" ;
					var dialogWidth			= "40" ;
					var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
					var arguments			= "" ;
					var sql="";
					var search_desc="";
					var tit="";

					sql="select practitioner_id, practitioner_name from ip_nursing_unit_for_pract_vw where facility_id="+facility_id+" and nursing_unit_code="+nursing_unit_code+" and practitioner_id in (select practitioner_id from am_practitioner  where primary_speciality_code="+spl_code+" and eff_status = `E` union select practitioner_id from  am_pract_specialities where facility_id = "+facility_id+" and speciality_code ="+spl_code+")";

					search_code="practitioner_id";
					search_desc="practitioner_name";
					tit=getLabel("Common.practitioner.label","Common");

					retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&dispDescFirst=dispDescFirst&title="+encodeURIComponent(tit),arguments,features);

					if (!(retVal == null))
					{
						if (!(unescape(retVal) == null))
						{
							arr=unescape(retVal).split("::");
							document.forms[0].pract_desc.value=arr[0];
							document.forms[0].fr_practitioner_id.value=arr[1];
							PopulateMedicalTeam();
						}
					}
					else
					{
							document.forms[0].pract_desc.value="";
							document.forms[0].fr_practitioner_id.value="";
							document.forms[0].team_id.value="";
					}
				}
				else
				{
					var error = getMessage('CAN_NOT_BE_BLANK','Common');
					error = error.replace('$',getLabel('Common.speciality.label','Common'));
					alert(error);	
				}
			}
			else
			{
				var error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',getLabel('Common.nursingUnit.label','Common'))
				alert(error);	
			}
		}

		function PopulateMedicalTeam()
		{ 	
				var selected = document.forms[0].team_id;
				while ( selected.options.length > 0 )
					selected.remove(selected.options[0]);
				var	str1 = "" ;
				var	str2 = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
				var element = parent.frames[1].document.createElement('OPTION');
				element.text = str2; 
				element.value= str1;
				document.forms[0].team_id.add(element);

			var ippractid  = document.forms[0].practid.value;
			var getservice = document.forms[0].practid.value;
			var spl_code = document.forms[0].Splcode.value;

				var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='booking' id='booking' value='AssignBed'><input type='hidden' name='med_code' id='med_code' value=''><input type='hidden' name='spy_code' id='spy_code' value='"+spl_code+"'><input type='hidden' name='prt_code' id='prt_code' value=''></form></body></html>";

				parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.frames[2].document.querydept.submit();
				
		}

	function PopulateExphrs()
	{   
		prioritycode=document.BedBookingTransfer_form.priority.value;
		var pref_date_time = convertDate(document.BedBookingTransfer_form.pref_date_time.value,'DMYHM',localeName,'en');//document.BedBookingTransfer_form.pref_date_time.value;

		var change_bed_class_yn = '';
		if(document.BedBookingTransfer_form.change_bed_class_yn)
		change_bed_class_yn = document.BedBookingTransfer_form.change_bed_class_yn.value;
		
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value='patientid'><input type='hidden' name='pref_date_time' id='pref_date_time' value='"+pref_date_time+"'><input type='hidden' name='priority_form' id='priority_form' value='priority_value'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='prioritycode' id='prioritycode' value='"+prioritycode+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
	}

	function CheckNursingUnit()
	{		
		
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
		//if(document.BedBookingTransfer_form.nursing_unit_desc.value ==document.BedBookingTransfer_form.fr_nursing_unit_desc.value)
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
function setBooleanValue_reqforTrnsfr(flag)
{
	if(flag)
	{
		var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.BedBookingTransferServlet'>";
		for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++)
		{
		   val += "<input type='hidden' name='"+ parent.frames[1].document.forms[0].elements[i].name +"' id='"+ parent.frames[1].document.forms[0].elements[i].name +"' value=\""+ parent.frames[1].document.forms[0].elements[i].value +"\">"
		}
		val += "</form></body><html>";
		parent.frames[3].document.write(val);	
		parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = true;
		parent.frames[3].document.Dummy_form.submit();
	}
	else
	{
		alert(getMessage("BED_CLASS_NOT_MATC_NURS","IP"));
		parent.frames[1].document.BedBookingTransfer_form.confirm.disabled = false;
		parent.frames[1].document.forms[0].nursing_unit_desc.select();
		return false;
	}
}


function setEnable_tfrDtls(){
	var call_function = document.forms[0].function_ID.value;
	if(parent.frames[1].document.forms[0].bed_class_allowed.value=="Y"){
	if (document.forms[0].bed_change.checked==true){
		document.forms[0].bed_change.value="Y";
		document.forms[0].Bedcode.disabled=false;
		document.forms[0].bed_type_code.disabled=false;
			if(call_function == 'Request_Trasnfer'||call_function =='EMERGENCY_TRANSFER'){
				getBedClass();
			}
			else{
//				getBedtype_tfrDtls();
				getIntraBedClass();
			}
	}
	else{
	//Maheshwaran added for GHL-CRF-0362
	if(call_function!='confirm_request')
		{
		document.forms[0].bed_change.value="N";
		document.forms[0].Bedcode.disabled=true;
		}
		if(call_function=='confirm_request')
			{
			getBedClass();
			document.forms[0].to_bed_no.value='';
			document.forms[0].to_room_no.value='';
			}
	//End
			if(call_function == 'Request_Trasnfer' ||call_function =='EMERGENCY_TRANSFER')
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
//Maheshwaran if condition added for GHL-CRF-0362			
if(call_function!='confirm_request'){
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
	}
	else
	if(parent.frames[1].document.forms[0].bed_class_allowed.value=="N")
	{
		document.forms[0].Bedcode.disabled=true;

			if(call_function == 'Request_Trasnfer')
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
	//{
	//	document.forms[0].Bedcode.disabled=true; //Maheshwaran commented for GHL-CRF-0362
	//	document.forms[0].bed_type_code.disabled=true; //Maheshwaran commented for GHL-CRF-0362
	//	}
	//}

	if(document.forms[0].reason_for_reserved_bed!=null){
		document.forms[0].reason_for_reserved_bed.disabled=true;
	}

}

function enbldisbchk_tfrDtls(obj1)
{
	if(obj1.value!="")
	{ if(parent.frames[1].document.forms[0].bed_class_allowed.value=="Y")
		parent.frames[1].document.forms[0].bed_change.disabled = false;
		//Maheshwaran added if condition for GHL-CRF-0362
		if(document.forms[0].call_function.value=='confirm_request')
			{
			setEnable_tfrDtls();
			}
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

function getBedtype_tfrDtls()
{
	var bed_class =  parent.Transfer_frame.document.forms[0].Bedcode.value;
	var nursing_unit =  parent.Transfer_frame.document.forms[0].nursing_unit.value;
	var deactivate_pseudo_bed_yn =  parent.Transfer_frame.document.forms[0].deactivate_pseudo_bed_yn.value;
	 parent.Transfer_frame.document.forms[0].to_bed_no.value='';
	 parent.Transfer_frame.document.forms[0].to_room_no.value='';
	var obj = parent.Transfer_frame.document.forms[0].bed_type_code;
	var length  = obj.length;
	var bed_type_code =  parent.Transfer_frame.document.forms[0].bed_type_code.value;
	for(i=0;i<length;i++) 
	{
		obj.remove(1);


	}	
		for(i=0;i<length;i++) 
		{
			obj.remove(0);
		}

	var opt = parent.frames[1].document.createElement('OPTION'); 
	opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value= '';
	obj.add(opt);
	var change_bed_class_yn = '';
	if( parent.Transfer_frame.document.forms[0].change_bed_class_yn)
		change_bed_class_yn =  parent.Transfer_frame.document.forms[0].change_bed_class_yn.value;

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
	" <input type='hidden' name='field3' id='field3' value='"+nursing_unit+"'><input type='hidden' name='field4' id='field4' value='getBedType'><input type='hidden' name='bed_class' id='bed_class' value='"+bed_class+"'><input type='hidden' name='bed_type_code' id='bed_type_code' value='"+bed_type_code+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'> <input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'></form></body></html>";
	//Maheshwaran added for GHL-CRF-0362
	if(parent.Transfer_frame.document.forms[0].call_function.value=='confirm_request')
		{
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.dum_form.submit();
		}
	else
		{
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.dum_form.submit();
		}
}

function ChangeBedtype_tfrDtls()
{
	self.document.forms[0].to_bed_no.value='';
	self.document.forms[0].to_room_no.value='';
	
	var from_bed_class	= document.forms[0].fr_bed_class.value;
	var to_bed_class	= document.forms[0].Bedcode.value;
	var from_bed_type	= document.forms[0].from_bed_type.value;
	var to_bed_type		= document.forms[0].bed_type_code.value;
	//Maheshwaran added if condition for GHL-CRF-0362
	var call_function= document.forms[0].call_function.value;
	if(call_function !="confirm_request")
	{
	if( (from_bed_class == to_bed_class) && (from_bed_type == to_bed_type) )
	{
		self.document.forms[0].bed_change.checked = false;
		self.document.forms[0].bed_change.value = "N";
		self.document.forms[0].bed_change.onclick();
	}
	}

}

function setDesable_tfrDtls()
{
	/*if(document.forms[0].bed_class_allowed.value=='Y')
	{*/
	document.forms[0].Bedcode.disabled=true;
	document.forms[0].bed_type_code.disabled=true;
	//}
}
async function callBedAvailChart_tfrDtls()
{
	var call_function= top.window[2].window[2].document.forms[0].call_function.value;
	if(call_function !="Change_Bedclass")
		var ipparam_bed_yn	=document.forms[0].ipparam_bed_yn.value;

	var nursingunit =document.forms[0].nursing_unit.value;
	var practitionerid = document.forms[0].practid.value;
	var specialitycode =document.forms[0].Splcode.value;
	var bedclasscode = document.forms[0].Bedcode.value;
	var bedtypecode = document.forms[0].bed_type_code.value;
	
	var patient_id = document.forms[0].patient_id2.value;
	var gender = document.forms[0].gender.value;
	var agevalue = document.forms[0].age.value;
	var age = "";
	var yr = eval(agevalue.indexOf("Y"));
	var mon = eval(agevalue.indexOf("M"));
	

	if(mon>=0 && yr>=0)
	{
		age = agevalue.substring(0,yr);
		agevalue = "Y";
	}
	else if(mon >= 0)
	{
		age = agevalue.substring(0,mon);
		agevalue = "M";
	}
	else
	{
		age = agevalue.substring(0,yr);
		agevalue = "Y";
	}
	var retVal = 	new String();
	var dialogHeight= "90vh";
	var dialogWidth = "95vw";
	var dialogTop	= "10";
	var status = "no";
	var arguments	= "" ;
	var wherecondn  = "EMERGENCY_TFR_YN"; 
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
    
	if(document.forms[0].call_function!=null && document.forms[0].call_function.value=='Transfer_Patient' && document.forms[0].bed_change!=null && document.forms[0].bed_change.checked==true)
	{
		
		retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?reserve_bed_selectable=Y&disable_field=NursingUnit&patient_id="+patient_id+"&nursing_unit_code="+escape(nursingunit)+"&ipparam_bed_yn="+ipparam_bed_yn+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&bed_type="+escape(bedtypecode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);
	}
	else if(document.forms[0].call_function!=null && document.forms[0].call_function.value=='Transfer_Patient' && document.forms[0].bed_change!=null && document.forms[0].bed_change.checked==false)
	{
		
		retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?reserve_bed_selectable=Y&disable_field=NuBcBt&patient_id="+patient_id+"&nursing_unit_code="+escape(nursingunit)+"&ipparam_bed_yn="+ipparam_bed_yn+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&bed_type="+escape(bedtypecode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);
	}
	/*3/3/2009 Incident IN008671*/
	else if(document.forms[0].call_function!=null && document.forms[0].call_function.value=='Transfer_Patient')
	{
		
		retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?reserve_bed_selectable=Y&disable_field=NuBcBt&patient_id="+patient_id+"&nursing_unit_code="+escape(nursingunit)+"&ipparam_bed_yn="+ipparam_bed_yn+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&bed_type="+escape(bedtypecode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);
	}
	/**/
	else if(document.forms[0].call_function!=null && document.forms[0].call_function.value=='confirm_request')
	{
		
		retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?reserve_bed_selectable=Y&disable_field=NuSyBcBt&patient_id="+patient_id+"&nursing_unit_code="+escape(nursingunit)+"&ipparam_bed_yn="+ipparam_bed_yn+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&bed_type="+escape(bedtypecode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);
	}
	else if(document.forms[0].call_function!=null && document.forms[0].call_function.value=='Change_Bedclass')
	{
		retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?reserve_bed_selectable=Y&disable_field=NuSyBcBt&patient_id="+patient_id+"&nursing_unit_code="+escape(nursingunit)+"&ipparam_bed_yn="+ipparam_bed_yn+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&bed_type="+escape(bedtypecode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);
	}
	/*2/20/2009 7067-MF-CRF-0059-IP Emergency Transfer*/
	else if(document.forms[0].call_function!=null && document.forms[0].call_function.value=='EMERGENCY_TRANSFER')
	{
		
		retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?reserve_bed_selectable=Y&disable_field=NuSyBcBt&patient_id="+patient_id+"&nursing_unit_code="+escape(nursingunit)+"&ipparam_bed_yn="+ipparam_bed_yn+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&bed_type="+escape(bedtypecode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);
	}
	if(retVal!=null)
	{
		var arr = retVal.split('^');
		if(arr.length > 2)
		{
			/* Added By Dharma on 24th Jan 2014 for MMS-SCF-0231 [IN:046587] Start*/
			/*document.forms[0].nursing_unit_lookup!=null added by Dharma on 13th Feb 2014 for IN:047018*/
			if(document.forms[0].nursing_unit_desc!=null && document.forms[0].nurs_desc_hid!=null && document.forms[0].nursing_unit!=null && document.forms[0].nursing_unit_lookup!=null && document.forms[0].nursing_unit_desc.disabled==false){
				document.forms[0].nursing_unit_desc.value	 = arr[9];
				document.forms[0].nurs_desc_hid.value	 = arr[9];
				document.forms[0].nursing_unit.value	 = arr[0];
				//document.forms[0].nursing_unit_desc.focus(); //Maheshwaran commented for GHL-CRF-0362
				//PopulateService(); //Maheshwaran commented for GHL-CRF-0362
			}
			/* Added By Dharma on 24th Jan 2014 for MMS-SCF-0231 [IN:046587] End*/

			var arr1 = arr[1].split("/");
			document.forms[0].to_bed_no.value = arr1[0];
			document.forms[0].tobedtype.value = arr[2];
			var arrsplty = arr[11].split("*All SPLTY*");
			if (arrsplty.length==1)
			{
				document.forms[0].Splcode_desc.value=arr[11];
				parent.frames[1].document.forms[0].document.forms[0].Splcode.value=arr[10];
			}
        			p = document.getElementById('Bedcode');
			for (i=0; i<p.options.length; i++) {
				if(p.options[i].value ==arr[3])
				{
				p.options[i].selected = true;
				}
			}

			if(arr[4] ==null )  	arr[4] ='';
			
			document.forms[0].to_room_no.value=arr[4];
			var bedtypecode = document.forms[0].bed_type_code.value;
			var obj =document.forms[0].bed_type_code;		
			var length  = obj.length;
			for(i=0;i<length;i++) 
			{
				obj.remove(1);
			}
			var obj =document.forms[0].bed_type_code;
			if(arr[13] != null && arr[2] !=null)
			{
				var opt= document.createElement('Option');
				opt.text=arr[13]
				opt.value=arr[2]; 
				obj.add(opt);
				opt.selected = true;
			}
			document.forms[0].to_daily_rate.value=arr[8];
			if(arr[14] =='Pseudo Bed')
			var pseudo_yn='Y';
			else
			var pseudo_yn='N';
			document.forms[0].pseudo_bed_yn.value=pseudo_yn;
		}
		else
		{
			
			document.forms[0].nursing_unit.value=arr[0];
			if (arr.length == 2)
				document.forms[0].nursing_unit_desc.value=arr[1];
		}

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
			var bed_change_YN = self.document.forms[0].bed_class_allowed.value;
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


function getBedClass(){
	var obj1 = parent.frames[1].document.forms[0].nursing_unit;
	var deactivate_pseudo_bed_yn = parent.frames[1].document.forms[0].deactivate_pseudo_bed_yn;
	if((obj1.value!=null)&&(obj1.value!="")){
	var bed_class = parent.frames[1].document.forms[0].Bedcode.value;
		var obj2 = parent.frames[1].document.forms[0].Bedcode;
		var length  = obj2.length;
		for(i=0;i<length;i++){
			obj2.remove(1);
		}
		var obj = parent.frames[1].document.forms[0].bed_type_code;
		length  = obj.length;
		for(i=0;i<length;i++){
			obj.remove(0);
		}
		var opt = parent.frames[1].document.createElement('OPTION'); 
		opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		opt.value= '';
		obj.add(opt);
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form1' id='dum_form1' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field4' id='field4' value='getBedClass'><input type='hidden' name='function_Id' id='function_Id' value='REQUEST_TRANSFER'><input type='hidden' name='nursingunitcode' id='nursingunitcode' value='"+obj1.value+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn.value+"'></form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.dum_form1.submit();
	}
}
function getIntraBedClass(){
		var fr_nursing_unit_code = parent.frames[1].document.forms[0].fr_nursing_unit_code.value;
		var function_id				   = parent.frames[1].document.forms[0].function_ID.value;
		var fr_bed_class_code	   = parent.frames[1].document.forms[0].fr_bed_class.value;
		var deactivate_pseudo_bed_yn	   = parent.frames[1].document.forms[0].deactivate_pseudo_bed_yn.value;
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form1' id='dum_form1' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='c_field4' id='c_field4' value='INTRA_WARD_N_OTHERS'><input type='hidden' name='nursingunitcode' id='nursingunitcode' value='"+fr_nursing_unit_code+"'><input type='hidden' name='function_Id' id='function_Id' value='"+function_id+"'><input type='hidden' name='fr_bed_class_code' id='fr_bed_class_code' value='"+fr_bed_class_code+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'></form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.dum_form1.submit();

}
/*10/20/2008 FS102IPSRRCRF0228V2.0*/
function setReserveBedDtls(){
		if(document.forms[0].call_function.value=='Transfer_Patient'){
			if (document.forms[0].reserved_bed_yn.checked==true){
				/*Monday, September 13, 2010 SRR20056-SCF-5155 [IN:023680]*/
				if(document.forms[0].pseudo_bed.value == "Y" && document.forms[0].deact_pseudo_bed.value == "Y")
				{
					var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
					error = error.replace('$',getLabel("Common.Reserved.label","Common"));
					
					alert(error);
					document.forms[0].reserved_bed_yn.checked = false;
					document.forms[0].is_reserved_bed_checked.value = 'N';
				}/**/
				else
				{
					var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='c_field4' id='c_field4' value='INTRA_WARD_TFR'></form></body></html>";
					//parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.frames[2].document.write(HTMLVal);
					parent.frames[2].document.dum_form.submit();
					document.forms[0].is_reserved_bed_checked.value='Y';
					document.forms[0].reason_for_reserved_bed.disabled=false;
					document.forms[0].reserved_bed_img.style.visibility='visible';
				}
			}else{
					var obj =parent.Transfer_frame.document.EmergencyTransfer_form.reason_for_reserved_bed;
					var length  = obj.length;
					for(i=0;i<length;i++){obj.remove(1);}
					document.forms[0].is_reserved_bed_checked.value='N';
					document.forms[0].reason_for_reserved_bed.options[0].selected = true;
					document.forms[0].reason_for_reserved_bed.disabled=true;	
					document.forms[0].reserved_bed_img.style.visibility='hidden';
			}
		}
		else if(document.forms[0].call_function.value=='Request_Trasnfer'){
			if (document.forms[0].reserved_bed_yn.checked==true){
				/*Monday, September 13, 2010 SRR20056-SCF-5155 [IN:023680]*/
					if(document.forms[0].pseudo_bed.value == "Y" && document.forms[0].deact_pseudo_bed.value == "Y")
					{
						var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
						error = error.replace('$',getLabel("Common.Reserved.label","Common"));
					
						alert(error);
						document.forms[0].reserved_bed_yn.checked = false;
						document.forms[0].is_reserved_bed_checked.value = 'N';
					}/**/
					else
					{
						document.forms[0].is_reserved_bed_checked.value='Y';
						document.forms[0].reason_for_reserved_bed.disabled=false;
						document.forms[0].reserved_bed_img.style.visibility='visible';
					}
			}else{
					document.forms[0].is_reserved_bed_checked.value='N';
					document.forms[0].reason_for_reserved_bed.options[0].selected = true;
					document.forms[0].reason_for_reserved_bed.disabled=true;	
					document.forms[0].reserved_bed_img.style.visibility='hidden';
			}
		}
	}

//Added by Sangeetha on 23/05/17 for GDOH-CRF-0151
function chkforVacantNormalBed(){
	var bed_no			  = document.forms[0].to_bed_no.value;
	var nursing_unit_code = document.forms[0].nursing_unit.value;
	var facility_id		  = document.forms[0].request_facilityId.value;
	var Bedcode			  = document.forms[0].Bedcode.value;
	var bed_type		  = document.forms[0].bed_type_code.value;

 if(bed_no!="" && nursing_unit_code!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH bed_no=\""+bed_no+"\"  nursing_unit_code=\""+nursing_unit_code+"\" action='chkforVacantNormalBed' facility_id=\""+facility_id+"\" Bedcode=\""+Bedcode+"\" bed_type=\""+bed_type+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)

		if(responseText == "Y"){
			var msg = getMessage("RESTRICT_PSEUDO_BED","IP");
			alert(msg);
			document.forms[0].to_bed_no.value  ="";
			document.forms[0].to_room_no.value ="";
			document.forms[0].bed_avail_chart.focus();
		}
	}

}

