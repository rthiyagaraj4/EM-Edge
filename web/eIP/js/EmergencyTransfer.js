function BLCheckElig_em()
{
	var bed_ref = "parent.frames[1].document.EmergencyTransfer_form.transfer_type";
	var modified_bed_type_ref = "parent.frames[1].document.EmergencyTransfer_form.modified_bed_type_code";
	var url = parent.frames[2].location.href;
	/*Added by Dharma on 25th Oct 2017 against ML-MMOH-CRF-0865.1 [IN:065405] Start*/
	var reasonForTransferArr = parent.frames[1].document.EmergencyTransfer_form.transfer_type.value;
	var reasonForTransfer	 = "";
	if(reasonForTransferArr!=""){
		reasonForTransferArr = reasonForTransferArr.split("=");
		reasonForTransfer	= reasonForTransferArr[0];
	}
	/*Added by Dharma on 25th Oct 2017 against ML-MMOH-CRF-0865.1 [IN:065405] End*/
	var action_url="";
	if(url.indexOf("/servlet")!=-1)
		var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.EmergencyTransfer_form.tobedtype.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.EmergencyTransfer_form.billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.EmergencyTransfer_form.to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/EmergencyTransfer.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
	else
		var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.EmergencyTransfer_form.tobedtype.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.EmergencyTransfer_form.billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.EmergencyTransfer_form.to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/EmergencyTransfer.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
	//if(parent.frames[2].document.body != null)
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	//if(parent.frames[2].document.dummy_form1 != null)
	parent.frames[2].document.dummy_form1.submit();
}

function submitForm_em()
{	  
	
	parent.frames[1].document.forms[0].transfer.disabled = true;
	if(parent.frames[1].document.EmergencyTransfer_form.func_id.value=='MODIFY_SERVICE_INPATIENT')
	{
		var fields = new Array();
			fields[0] = parent.frames[1].document.EmergencyTransfer_form.service;
		var names = new Array();
			names[0]	= getLabel("Common.service.label","Common");

		if(checkFields1( fields, names)) 
		{	
			applyone_em('Y','N','');//Modified by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
		}
		else
			parent.frames[1].document.forms[0].transfer.disabled = false;
	}
	else 
	{
		if(parent.frames[1].document.EmergencyTransfer_form.continue_yn.value != "N")
		{
			var flag = "F";
		
			if((parent.frames[1].document.EmergencyTransfer_form.fr_nursing_unit_code.value != parent.frames[1].document.EmergencyTransfer_form.nursing_unit.value)||			(parent.frames[1].document.EmergencyTransfer_form.fr_bed_class.value != parent.frames[1].document.EmergencyTransfer_form.Bedcode.value)||				(parent.frames[1].document.EmergencyTransfer_form.fr_bed_no.value != parent.frames[1].document.EmergencyTransfer_form.to_bed_no.value))
				flag = "T";

				
			if(flag == 'T')
			{
				var fields = new Array();
				fields[0] = parent.frames[1].document.EmergencyTransfer_form.transfer_type;
				fields[1] = parent.frames[1].document.EmergencyTransfer_form.nursing_unit;
				fields[2] = parent.frames[1].document.EmergencyTransfer_form.service;
				fields[3] = parent.frames[1].document.EmergencyTransfer_form.Bedcode;
				fields[4] = parent.frames[1].document.EmergencyTransfer_form.bed_type_code;
				fields[5] = parent.frames[1].document.EmergencyTransfer_form.to_bed_no;
				fields[6] = parent.frames[1].document.EmergencyTransfer_form.Splcode_desc;
				fields[7] = parent.frames[1].document.EmergencyTransfer_form.pract_desc;
				
				var names = new Array();
				
				names[0]	= getLabel("eIP.ReasonforTransfer.label","IP");
				names[1]	= getLabel("Common.nursingUnit.label","Common");
				names[2]	= getLabel("Common.service.label","Common");
				names[3]	= getLabel("Common.BedClass.label","common");
				names[4]	= getLabel("Common.bedtype.label","Common");
				names[5]	= getLabel("Common.bedno.label","Common");
				names[6]	= getLabel("Common.speciality.label","Common");
				names[7]	= getLabel("Common.practitioner.label","Common"); 

				if(parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked && parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked.value=='Y')
				{
					fields[8]	= parent.frames[1].document.EmergencyTransfer_form.reason_for_reserved_bed;
					names[8]	= getLabel("eIP.ReasonforReserveBed.label","IP"); 
				}


				if(checkFields1( fields, names)) 
				{	

					if(parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked && parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked.value=='Y' && parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value!='' && parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value== parent.frames[1].document.EmergencyTransfer_form.to_bed_no.value && parseInt(parent.frames[1].document.EmergencyTransfer_form.reserved_bed_cont.value) > 0)
					{
						
						/*var msg = getMessage("BED_RESERVED","IP");
						msg = msg.replace("$",parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value);
						alert(msg);
						*/

						/*var msg = getMessage("BED_RESERVED","IP");
						msg = msg.replace("$",parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value);
						msg = msg + getMessage("RESERVE_OR_RETAIN","IP");
						msg = msg.replace("$",parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value);
						

						var confirmation_YN = confirm(msg);


						if(confirmation_YN)
						{
							parent.frames[1].document.EmergencyTransfer_form.confirm_yn.value = "Y"; 
							parent.frames[1].document.EmergencyTransfer_form.is_to_bed_equals_reserve_bed.value = "N"; 
						}
						else
						{
							parent.frames[1].document.EmergencyTransfer_form.confirm_yn.value = "N"; 
							parent.frames[1].document.EmergencyTransfer_form.is_to_bed_equals_reserve_bed.value = "Y"; 
						}*/

						var msg = getMessage("BED_RESERVED","IP");
						msg = msg.replace("$",parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value);
						msg = msg + getMessage("REMOVE_RESERVE_BED","IP") + "and Reserve "+parent.frames[1].document.EmergencyTransfer_form.fr_bed_no.value;
						alert(msg);
						parent.frames[1].document.EmergencyTransfer_form.is_to_bed_equals_reserve_bed.value = "Y"; 	
						parent.frames[1].document.EmergencyTransfer_form.confirm_yn.value = "N";
						parent.frames[1].document.EmergencyTransfer_form.remove_bed.value = "Y";
						
						
					}
					else if(parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked && parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked.value=='Y' && parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value!='' && parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value!= parent.frames[1].document.EmergencyTransfer_form.fr_bed_no.value && parseInt(parent.frames[1].document.EmergencyTransfer_form.reserved_bed_cont.value) > 0)
					{
						//var msg = getMessage("BED_RESERVED","IP");
						//msg = msg.replace("$",parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value);
						var msg =  getMessage("RESERVE_OR_RETAIN","IP");
						msg = msg.replace("$",parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value);
						msg = msg.replace("?",parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value);
					
					
						//var confirmation_YN = confirm(getMessage("RESERVE_BED_EXISTS","IP")+" "+parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value);
						var confirmation_YN = confirm(msg);


						if(confirmation_YN)
						{
							parent.frames[1].document.EmergencyTransfer_form.confirm_yn.value = "Y"; 
							
						/*Friday, September 03, 2010 , SRR20056-SCF-5138 [IN:023627]*/					
							parent.frames[1].document.EmergencyTransfer_form.retain_res_bed.value = "Y"; 
						}
						else
							parent.frames[1].document.EmergencyTransfer_form.confirm_yn.value = "N"; 
					}



					if((parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked && parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked.value=='N' && parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value!='' && parseInt(parent.frames[1].document.EmergencyTransfer_form.reserved_bed_cont.value) > 0) || (parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked && parent.frames[1].document.EmergencyTransfer_form.is_reserved_bed_checked.value=='N' && parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value!='' && parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value== parent.frames[1].document.EmergencyTransfer_form.to_bed_no.value && parseInt(parent.frames[1].document.EmergencyTransfer_form.reserved_bed_cont.value) > 0))
					{
						parent.frames[1].document.EmergencyTransfer_form.is_to_bed_equals_reserve_bed.value = "Y"; 
						alert(getMessage("RESERVE_BED_EXISTS","IP")+" "+parent.frames[1].document.EmergencyTransfer_form.reserve_bed_no.value+"\n"+getMessage("REMOVE_RESERVE_BED","IP"));

						parent.frames[1].document.EmergencyTransfer_form.remove_bed.value = "Y";	
					}

					if(parent.frames[1].document.EmergencyTransfer_form.bl_operational.value == 'Y')
					{	
						if(parent.frames[1].document.forms[0].bed_class_allowed.value=='Y' && parent.frames[1].document.forms[0].change_bed_class_yn.value=='Y') {
							//BLCheckElig_em();
							setTimeout("BLCheckElig_em()", 300);
						} else if(parent.frames[1].document.forms[0].bed_class_allowed.value=='N') {
							//BLCheckElig_em();
							setTimeout("BLCheckElig_em()", 300);
						} else {
							applyone_em('Y','N','');//Modified by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
						}
					}
					else
						applyone_em('Y','N','');//Modified by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
				}
				else
					parent.frames[1].document.forms[0].transfer.disabled = false;
			}
			else
			{
				parent.frames[1].document.forms[0].transfer.disabled = false;
				alert(self.getMessage('ATLEAST_BED_CHANGE','IP'));
			}
		}
		else
		{
			parent.frames[1].document.forms[0].transfer.disabled = false;
			parent.frames[1].document.EmergencyTransfer_form.continue_yn.value = "";
		}
	}
}


function applyone_em(difframe,bed_class_chk,reqRadioBtn)
{
	parent.frames[1].document.EmergencyTransfer_form.reqRadioBtn.value = reqRadioBtn;//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
	parent.frames[1].document.EmergencyTransfer_form.transfer.disabled = true;
	parent.frames[1].document.EmergencyTransfer_form.bed_class_chk.value = bed_class_chk;
	var val = "";

	if(parent.frames[1].document.EmergencyTransfer_form.func_id.value=='MODIFY_SERVICE_INPATIENT')
	{
		val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.ModifyServiceServlet' >";
		
	}
	else
	{
		val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.EmergencyTransferServlet' >";
	}
	
	var proceed = 'true';
	var mother_status = parent.frames[1].document.forms[0].mother_status.value;
	var transfer_wo_delink_yn = parent.frames[1].document.forms[0].transfer_wo_delink_yn.value;//Added for the CRF HSA-CRF-0035
	//Added for the CRF - HSA-CRF-0035 - Begin
	
	if (mother_status != '0' && transfer_wo_delink_yn=='Y') {		
		proceed=validateMotherBabyBed(parent.frames[1].document.forms[0].nursing_unit.value,parent.frames[1].document.forms[0].to_bed_no.value,parent.frames[1].document.forms[0].patient_id2.value)
	}
	
	if(proceed!='true'){
		if(confirm(getMessage("TRANSFER_NOT_POSSIBLE","IP"))){	
			parent.frames[1].document.forms[0].transfer_wo_delink_yn.value='N';
			proceed='true';
		}		
	}	

	if(proceed=='true'){		
		for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++)
			val += "<input type='hidden' name='"+ parent.frames[1].document.forms[0].elements[i].name +"' id='"+ parent.frames[1].document.forms[0].elements[i].name +"' value=\""+ parent.frames[1].document.forms[0].elements[i].value +"\">";
					
		val += "</form></body><html>";
		parent.frames[2].document.write(val);
		parent.frames[2].document.Dummy_form.submit();		
	}else{		
			parent.frames[1].document.EmergencyTransfer_form.transfer.disabled = false;		
	}
	//Added for the CRF - HSA-CRF-0035 - End
}

function onBedClassChange(obj)
{
	document.forms[0].to_bed_no.value = '';
	document.forms[0].to_room_no.value = '';	
}

function cancel()
{
	window.parent.close();
}

function getRoomNo(obj)
{
	
	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
		
			self.document.EmergencyTransfer_form.to_room_no.value = '';	
			self.document.EmergencyTransfer_form.to_daily_rate.value = '';
			var nursingunit = self.document.EmergencyTransfer_form.nursing_unit.value;
			var change_bed_class_yn = '';
			if(self.document.EmergencyTransfer_form.change_bed_class_yn)
			change_bed_class_yn = self.document.EmergencyTransfer_form.change_bed_class_yn.value;
			var fr_bed_no = self.document.EmergencyTransfer_form.fr_bed_no.value;
			var bedno = obj.value;
			var url = parent.frames[2].location.href;
			var action_url="";
			if(url.indexOf("/servlet")!=-1){
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='fr_bed_no' id='fr_bed_no' value='"+fr_bed_no+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
			}
			else{
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='fr_bed_no' id='fr_bed_no' value='"+fr_bed_no+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
			}

			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.dum_form.submit();
		}
	}
	
}
var onload	= 0;
function popDynamicValues_em(obj)
{
	var nurs_unit_fr=self.document.EmergencyTransfer_form.fr_nursing_unit_code.value ;
	var nurs_unit_to=self.document.EmergencyTransfer_form.nursing_unit.value;
	var bed_class_to=self.document.EmergencyTransfer_form.Bedcode.value;
	var spl_fr=self.document.EmergencyTransfer_form.fr_speciality_code.value;
	var team_fr=self.document.EmergencyTransfer_form.fr_team_id.value;
	var bed_class_fr=self.document.EmergencyTransfer_form.fr_bed_class.value;
	
	if(nurs_unit_to != nurs_unit_fr)
	{
		self.document.EmergencyTransfer_form.to_bed_no.value = '';
		self.document.EmergencyTransfer_form.to_room_no.value = '';	
		self.document.EmergencyTransfer_form.to_daily_rate.value = '';
		//self.document.EmergencyTransfer_form.Bedcode.options[0].selected=true;
		self.document.EmergencyTransfer_form.practid.value = '';
		self.document.EmergencyTransfer_form.team_id.options[0].selected=true;
		spl_fr='';
		tem_fr='';
	}
	else
	{
		document.forms[0].nursing_unit_desc.value=self.document.EmergencyTransfer_form.fr_nursing_unit_desc.value ;
		if(onload ==1)
		spl_fr='';
	}
	var val = obj.value;
	if (val != null && val != "")
	{
		onload=	1	;
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='query_spec' id='query_spec' method='post' action='../../eIP/jsp/IPPopSpecPract.jsp'><input type='hidden' name='code' id='code' value='"+val+"'><input type='hidden' name='funct' id='funct' value='spec'><input type ='hidden'  name='spl_fr' id='spl_fr' value=\""+spl_fr+"\"><input type ='hidden'  name='team_fr' id='team_fr' value=\""+team_fr+"\"></form></body></html>";

		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.forms[0].submit();


	}
}

function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck1(fields[i].value)) {}
		else	
            var error = getMessage('GENERAL_CNT_BE_BLANK',"IP");
		        error = error.replace('$',getLabel('eIP.TransferType.label','IP'));	}
	if ( errors.length != 0 ) 
	{
		alert(errors) ;
		parent.frames[1].document.forms[0].transfer.disabled = false;
		return false ;
	}
	return true ;
}
function trimCheck1(inString)
{
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
	
	var fm_nur_code	=	document.forms[0].fr_nursing_unit_code;
	var to_nur_code	=	document.forms[0].nursing_unit;
	var fm_bed_no	=	document.forms[0].fr_bed_no;
	var to_bed_no	=	document.forms[0].to_bed_no;
	var fm_bed_class=	document.forms[0].fr_bed_class;
	var to_bed_class=	document.forms[0].Bedcode;
	var trans_code	=	document.forms[0].transfer_type;
	var encount_id	=	document.forms[0].encounter_id;
	
	if(trans_code.value=="")
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
			 error	= error.replace('$',getLabel("eIP.TransferType.label",'IP'));
		alert(error);
		trans_code.focus();
		return false;
	}

	if(to_nur_code.value=="")
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error	= error.replace('$',getLabel("Common.TransferToNursingUnit.label",'Common'));
		alert(error);
		to_nur_code.focus();
		return false;
	}

	if(to_bed_class.value=="")
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		var temp = getLabel("Common.TransferTo.label",'Common')+' '+getLabel("eIP.BedClass.label",'IP')
		//error = error.replace('$','Transfer to Bed Class');
		error	= error.replace('$',temp);
		alert(error);
		to_bed_class.focus();
		return false;
	}

	if(to_bed_no.value=="")
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error	= error.replace('$',getLabel("Common.TransferToBed.label",'Common'));
		alert(error);
		to_bed_no.focus();
		return false;
	}

	

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='BLBedTrans' id='BLBedTrans' method='post' action='../../eBL/jsp/BLBedTrans.jsp' ><input type='hidden' name='fm_nur_code' id='fm_nur_code' value='"+fm_nur_code.value+"'><input type='hidden' name='to_nur_code' id='to_nur_code' value='"+to_nur_code.value+"'><input type='hidden' name='fm_bed_no' id='fm_bed_no' value='"+fm_bed_no.value+"'> "+
	"<input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no.value+"'> "+
	"<input type='hidden' name='fm_bed_class' id='fm_bed_class' value='"+fm_bed_class.value+"'> "+
	"<input type='hidden' name='to_bed_class' id='to_bed_class' value='"+to_bed_class.value+"'> "+
	"<input type='hidden' name='trans_code' id='trans_code' value='"+trans_code.value+"'> "+
	"<input type='hidden' name='encount_id' id='encount_id' value='"+encount_id.value+"'> "+
	"</form></body></html>";

	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.BLBedTrans.submit();

	
}

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
function validatePractID(obj0, obj1, obj2)
{
	var val		= obj0.value;

	if(val != "")
	{
		var nur_code	= obj1.value;
		var spec_code	= obj2.value;

		if(nur_code != "")
		{
			if(spec_code != "")
			{
				if ((val != "") && (nur_code != "") && (spec_code != ""))
				{
					var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='query_spec' id='query_spec' method='post' action='../../eIP/jsp/IPPopSpecPract.jsp'><input type='hidden' name='code' id='code' value='"+val+"'><input type='hidden' name='funct' id='funct' value='pract'><input type='hidden' name='nur_code' id='nur_code' value='"+nur_code+"'><input type='hidden' name='spec_code' id='spec_code' value='"+spec_code+"'></form></body></html>";
					parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.frames[2].document.query_spec.submit();
				}
			}
			else 
			{
				var error = getMessage('CAN_NOT_BE_BLANK',"Common");
				error = error.replace('$',getLabel('Common.speciality.label','common'));
				alert(error);
			}
		}
		else 
		{
				var error = getMessage('CAN_NOT_BE_BLANK',"Common");
				error = error.replace('$',getLabel('Common.nursingUnit.label','common'));
				alert(error);
		}
	}
}


function PopulateService()
{
	var nursingunit = self.document.EmergencyTransfer_form.nursing_unit_code.value;
	var change_bed_class_yn = '';
	if(self.document.EmergencyTransfer_form.change_bed_class_yn)
	change_bed_class_yn = self.document.EmergencyTransfer_form.change_bed_class_yn.value;
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
	" <input type='hidden' name='field3' id='field3' value=\""+nursingunit+"\"><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
							
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.dum_form.submit();
}
function PopulateSubService()
{
	var nursingunit = self.document.EmergencyTransfer_form.nursing_unit.value;
	var serviceCode = self.document.EmergencyTransfer_form.service.value;
	var change_bed_class_yn = '';
	if(self.document.EmergencyTransfer_form.change_bed_class_yn)
	change_bed_class_yn = self.document.EmergencyTransfer_form.change_bed_class_yn.value;
	if (serviceCode =="")
	{
		self.document.EmergencyTransfer_form.sub_service.value="";
		var obj1 =document.forms[0].sub_service;
			var length1  = obj1.length;
			for(i=0;i<length1;i++) 
			{
			obj1.remove(1);
			}
	}
	else
	{
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='serviceCode' id='serviceCode' value=\""+serviceCode+"\"><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
	}
}

function onServiceChange()
{
	PopulateSubService();

}

function getBlockBedDate1()
{
	var change_bed_class_yn = '';
	if(self.document.EmergencyTransfer_form.change_bed_class_yn)
		change_bed_class_yn = self.document.EmergencyTransfer_form.change_bed_class_yn.value;
	
	var blocking_hrs = self.document.EmergencyTransfer_form.bed_blocking_period.value;

	if(self.document.EmergencyTransfer_form.transfer_type.value != '')
	{

		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=\""+blocking_hrs+"\"><input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='block_date1'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value=\""+change_bed_class_yn+"\"></form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.dum_form.submit();
	}
}

function getBlockBedparam()
{
	var blocking_hrs = self.document.EmergencyTransfer_form.bed_blocking_period.value;
	var change_bed_class_yn = '';
	if(self.document.EmergencyTransfer_form.change_bed_class_yn)
	change_bed_class_yn = self.document.EmergencyTransfer_form.change_bed_class_yn.value;
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
		" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value='"+blocking_hrs+"'> "+
		" <input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='block_date1'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
								
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
	
}
function getBedtype()
{
	var bed_class = self.document.EmergencyTransfer_form.Bedcode.value;
	self.document.EmergencyTransfer_form.bed_type_code.value='';
	var change_bed_class_yn = '';
	if(self.document.EmergencyTransfer_form.change_bed_class_yn)
	change_bed_class_yn = self.document.EmergencyTransfer_form.change_bed_class_yn.value;
	var obj =document.forms[0].bed_type_code;		
			var length  = obj.length;
	for(i=0;i<length;i++) 
	{
		obj.remove(1);
	}
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
	" <input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='bed_class' id='bed_class' value='"+bed_class+"'><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
							
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.dum_form.submit();
}
// Added by Sridhar on 2 JULY 2004

function chkPractRole(practID)
{
	var sStyle = document.forms[0].sStyle.value;
	var encounterId = document.forms[0].encounter_id.value;
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='practRole' id='practRole' method='post' action='../../eIP/jsp/PractIncompleteError.jsp?criteria=chkPractRole&encounter_ID="+encounterId+"&pract_ID="+practID+"'></form></BODY></HTML>";
	parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.forms[0].submit();
}


// By Annadurai 2/6/2004., to use Common Lookup starts.,
var flag = 0;
function clearRoom()
{
	if (document.forms[0].to_bed_no.value=="")
	document.forms[0].to_room_no.value="";
}

async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	var nursingUnit		= aNursingUnit.value;
	var facilityId		= aFacilityId;
	var loginUserId		= aLoginUser;
	var	operStnID		= pOperStnID;

	var retVal			= new String();

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit a, am_os_user_locn_access_vw b where a.facility_id  like ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.oper_stn_id  like ? and b.appl_user_id  like ? and emergency_tfr_yn='Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";
	
	dataNameArray[0]	= "a.facility_id" ;
	dataValueArray[0]	= facilityId;
	dataTypeArray[0]	= STRING ;
	
	dataNameArray[1]	= "b.oper_stn_id" ;
	dataValueArray[1]	= operStnID;
	dataTypeArray[1]	= STRING ;
	
	dataNameArray[2]	= "b.appl_user_id" ;
	dataValueArray[2]	= loginUserId;
	dataTypeArray[2]	= STRING ;

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "4, 5";
	argumentArray[5]	= nursingUnit;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	var tit=getLabel("Common.nursingUnit.label","Common");
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].nursing_unit.value		=	arr[0];
		document.forms[0].nursing_unit_desc.value	=	arr[1];
		popDynamicValues_em(document.forms[0].nursing_unit);
		document.forms[0].Splcode_desc.value='';
		document.forms[0].Splcode.value='';
		document.forms[0].practid.value='';
		document.forms[0].pract_desc.value='';
		document.forms[0].team_id.value='';
		PopulateService();
	}
	else
	{
		document.forms[0].nursing_unit_desc.value='';
		document.forms[0].nursing_unit.value='';
		document.forms[0].Splcode_desc.value='';
		document.forms[0].Splcode.value='';
		document.forms[0].practid.value='';
		document.forms[0].pract_desc.value='';
		document.forms[0].team_id.value='';
		document.forms[0].to_bed_no.value='';
		document.forms[0].to_room_no.value='';
		document.forms[0].service.value='';
	}
}

function checkForNursing() 
{
	if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 1;
		alert(getMessage('NU_NOTNULL','IP'));
		document.forms[0].nursing_unit_desc.focus();
	}
} 

// Added by Sridhar on 7 APR 2004
function getMedicalTeamHead(Obj)
{
	if (Obj.value == "")
	{
		document.EmergencyTransfer_form.pract_desc.value = "";
	}
	else if (document.EmergencyTransfer_form.pract_desc.value == "")
	{
		 var teamId = document.EmergencyTransfer_form.team_id.value;
		 var sqlString = "SELECT pract_role, PRACTITIONER_ID FROM am_pract_for_team WHERE team_id = '"+ document.EmergencyTransfer_form.team_id.value + "' AND pract_role='C'";
		
		document.EmergencyTransfer_form.selecTeam.value=sqlString;
		var change_bed_class_yn = '';
			if(document.EmergencyTransfer_form.change_bed_class_yn)
			change_bed_class_yn = document.EmergencyTransfer_form.change_bed_class_yn.value;
		var HTMLValue = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' 							action='../../eIP/jsp/TransferValidation.jsp'>";
			HTMLValue += " <input type='hidden' name='selectedTeam' id='selectedTeam' value='"+teamId+"'>";
			HTMLValue += " <input type='hidden' name='reqParam' id='reqParam' value= 'executeQuery' >";
			HTMLValue +=" <input type='hidden' name='sqlQuery' id='sqlQuery' value=\""+sqlString+"\"><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='"+change_bed_class_yn+"'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLValue);
		parent.frames[2].document.dum_form.submit();
	}
}



function checkTxtVal(obj1,obj2)
{
	if(document.forms[0].Splcode_desc.value == "")
		getSpecialty(obj1,obj2);
}

function checkPractTxtVal(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc.value == "")
		getPractitioner(obj,target, aFacilityID);
}

// Added by Sridhar on 2 FEB 2004

function BeforeGetSpecialty(obj1,obj2)
{
	if(document.forms[0].spec_desc_hid.value != document.forms[0].Splcode_desc.value)
	{
		if(document.forms[0].Splcode_desc.value!="")
			getSpecialty(obj1,obj2);
		else
			document.forms[0].pract_desc.value = "";	
	}
}


function BeforeGetPractitioner(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_desc.value)
	{
		if(document.forms[0].pract_desc.value!= "")
			getPractitioner(obj,target, aFacilityID);
		else
		{	
			
			var obj =document.forms[0].team_id;
			var length  = obj.length;
			
			for(i=0;i<length;i++) 
				obj.remove(0);
			var opt = document.createElement('OPTION'); 
			opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt.value= '';
			obj.add(opt);
		}
	}
}


async function getSpecialty(aSpecialtID, Facility_ID)
{
	checkForNursing(); // To check for Nursing Unit.
	var target			= document.forms[0].Splcode_desc;
	var code			= document.forms[0].nursing_unit.value;
	var FacilityID		= Facility_ID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	sql	=	"Select a.speciality_code code,a.short_desc description from am_speciality a, ip_nurs_unit_for_specialty b where eff_status like ? and a.speciality_code=b.specialty_code and b.facility_id like ? and b.nursing_unit_code='"+code+"' and upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?) ";
	
	var tit=getLabel("Common.speciality.label","Common");
	
	dataNameArray[0]	= "eff_status" ;
	dataValueArray[0]	= "E";
	dataTypeArray[0]	= STRING;

	dataNameArray[1]	= "b.facility_id" ;
	dataValueArray[1]	= FacilityID;
	dataTypeArray[1]	= STRING;
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "3, 4";
	argumentArray[5]	= aSpecialtID.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].Splcode_desc.value=arr[1];
		document.forms[0].pract_desc.value='';
		document.forms[0].practid.value='';
		document.forms[0].team_id.value="";
		document.forms[0].spec_desc_hid.value = document.forms[0].Splcode_desc.value;
		PopulateMedicalTeam();
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
// By Annadurai ends.,

function fetchValForBedClass(obj){}
	
function checkForValues()
{
	if ((document.forms[0].nursing_unit_desc.value=="") && (document.forms[0].Splcode_desc.value==""))
	{
		flag = 2;
		var error = getMessage('NU_NOTNULL','IP') + getMessage('SPLTY_NOTNULL',"IP");
		    error = error.replace('$',getLabel("Common.nursingUnit.label","Common"));
            error = error.replace('$',getLabel("Common.speciality.label","Common"));
		    alert(error);
		document.forms[0].nursing_unit_desc.focus();  
	}
	else if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 2;
		alert(getMessage('NU_NOTNULL','IP'));
		document.forms[0].nursing_unit_desc.focus();
	}
	else if (document.forms[0].Splcode_desc.value=="")
	{
		flag = 2;
		alert(getMessage('SPLTY_NOTNULL','IP'));
		document.forms[0].Splcode_desc.focus();
	}
} 


function getPractitionerToDELETE(obj,target, aFacilityID)
{
	checkForValues();
	var practName_FName		= "";
	var practName_FValue	= "";
	var practId_FName		= "";
	
	practName_FName			= target.name;
	practName_FValue		= target.value;
	practId_FName			= document.forms[0].practid.name;

	var nursing_unit_code	= document.forms[0].nursing_unit.value;
	var spl_code			= document.forms[0].Splcode.value;
	var facility_id			= aFacilityID;	

	locale=document.forms[0].locale1.value
	var sql= " SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.PRIMARY_SPECIALITY_CODE,am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)  primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND (   UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) ";

	var sql2= " SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.PRIMARY_SPECIALITY_CODE,am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)  primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND (   UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) and UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL)  ";

	// var xmlDoc		 = new ActiveXObject( "Microsoft.XMLDom" ) ;
	// var xmlHttp		 = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	// xmlStr			 = "<root><SEARCH " ;
	// xmlStr			+= " practName_FName=\"" +practName_FName + "\"";
	// xmlStr			+= " practName_FValue=\"" + practName_FValue + "\"";
	// xmlStr			+= " practId_FName=\"" + practId_FName + "\"";
	// xmlStr			+= " sql=\"" +escape(sql)+ "\"";
	// xmlStr			+= " sqlSec=\"" +escape(sql2)+ "\"";
	// xmlStr			+= " practitioner_type=\"" + "" + "\"";
	// xmlStr			+= " specialty_code=\"" + spl_code+ "\"";
	// xmlStr			+= " job_title=\"" + "" + "\"";
	// xmlStr			+= " gender=\"" + "" + "\"";
	// xmlStr			+=" /></root>" ;
	// xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	// xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	// xmlHttp.send(xmlDoc);
	// responseText	 =xmlHttp.responseText;
	// responseText	 = trimString(responseText);
	// eval(responseText);	

// } 
//	<---- VEDESH A D 21/05/24 ---->
	   xmlStr			 = "<root><SEARCH " ;
	xmlStr			+= " practName_FName=\"" +practName_FName + "\"";
	xmlStr			+= " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr			+= " practId_FName=\"" + practId_FName + "\"";
	xmlStr			+= " sql=\"" +escape(sql)+ "\"";
	xmlStr			+= " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr			+= " practitioner_type=\"" + "" + "\"";
	xmlStr			+= " specialty_code=\"" + spl_code+ "\"";
	xmlStr			+= " job_title=\"" + "" + "\"";
	xmlStr			+= " gender=\"" + "" + "\"";
	xmlStr			+=" /></root>" ;	
 // Parse the XML string
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "text/xml");
    // Create an XMLHttpRequest object
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", "../../eAM/jsp/callGeneralPractitionerSearch.jsp", false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    // Send the XML
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
    // Handle the response
    var responseText = xmlHttp.responseText;
    responseText = trimString(responseText); 
    eval(practSearch(practName_FName,encodeURIComponent(practitionerValue),splty,responseText));	  
}

async function practSearch(practName_FName,practName_FValue,spl_code,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}



function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].pract_desc.value=arr[1];	
		document.forms[0].pract_desc_hid.value = document.forms[0].pract_desc.value;
		chkPractRole(document.forms[0].practid.value);
		PopulateMedicalTeam();
	}
	else
	{
		document.forms[0].practid.value="";
		document.forms[0].pract_desc.value="";			
	}
} 
async function getPractID()
{

	var nursing_unit_code	= "`"+document.forms[0].nursing_unit.value+"`";
	var spl_code			= "`"+document.forms[0].Splcode.value+"`";

	var facility_id			= "`"+document.forms[0].facilityId.value+"`";
	if(nursing_unit_code != "")
	{
		if(spl_code != "")
		{
			var target				= document.forms[0].practid;
			var retVal				=    new String();
			var dialogTop			= "40";
			var dialogHeight		= "70vh" ;
			var dialogWidth			= "50vw" ;
			var features			="dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments			= "" ;
			var sql="";
			var search_desc="";
			var tit="";

			sql="select practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1) practitioner_name from ip_nursing_unit_for_pract where facility_id="+facility_id+" and nursing_unit_code="+nursing_unit_code+" and practitioner_id in (select practitioner_id from am_practitioner  where primary_speciality_code="+spl_code+" and eff_status = `E` union select practitioner_id from  am_pract_specialities where facility_id = "+facility_id+" and speciality_code ="+spl_code+")";

			search_code="practitioner_id";
			search_desc="practitioner_name";
			tit=getLabel("Common.practitioner.label","Common");

			retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&dispDescFirst=dispDescFirst&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				if (!(unescape(retVal) == null))
				{
					arr=unescape(retVal).split("::");
					document.forms[0].pract_desc.value=arr[0];
					document.forms[0].practid.value=arr[1];
					PopulateMedicalTeam();
				}
			}
			else
			{
					document.forms[0].pract_desc.value="";
					document.forms[0].practid.value="";
					document.forms[0].team_id.value="";
			}
		}
		else
		{
			var error = getMessage('CAN_NOT_BE_BLANK',"Common");
			error = error.replace('$',getLabel('Common.speciality.label','common'));
			alert(error);	
		}
	}
	else
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel('Common.nursingUnit.label','common'));
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
	if (ippractid != null && ippractid != "")
	{
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='booking' id='booking' value='AssignBed'><input type='hidden' name='spy_code' id='spy_code' value='"+spl_code+"'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.querydept.submit();
	}

}

function ClearPractMedDtls()
{
	document.forms[0].practid.value='';
	var selected = EmergencyTransfer_form.team_id;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);

	var	str1 = "" ;
	var	str2 = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var element = parent.frames[1].document.createElement('OPTION');
	element.text = str2; 
	element.value= str1;
	document.forms[0].team_id.add(element);
}

function focusFirst()
{
	document.forms[0].transfer_type.focus();

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


function checkForMaxPeriod()
{
	if(document.forms[0].bed_blocking_period.value=='' ||document.forms[0].bed_blocking_period.value =='0')
	{
		document.forms[0].bed_block_until.value='';
	}
	var period_no=eval(document.forms[0].bed_blocking_period.value);
	if( eval(period_no) > 0)
	{
		if (eval(document.forms[0].bed_blocking_period.value) > eval(document.forms[0].def_max_period.value))
		{
			var error = getMessage('BED_BLK_PRD_CANT_EXCEED','IP');
			error = error.replace('$',getLabel('eIP.BlockPeriod.label','IP'));
			alert(error);
			document.forms[0].bed_blocking_period.select();
		}
		else
			getBlockBedDate1();
	}
	
}
function allowOnlyNumbers(event)
{
	if (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 46))
		return true;
	else return false;
}
function setEnable()
{
	if (document.forms[0].bed_change.checked==true)
	{
	document.forms[0].Bedcode.disabled=false;
	document.forms[0].bed_type_code.disabled=false;
	}
	else
	{
	document.forms[0].Bedcode.value=document.forms[0].hid_bed_class.value;
	document.forms[0].Bedcode.disabled=true;
	document.forms[0].bed_type_code.value=document.forms[0].hid_bed_type.value;
	document.forms[0].bed_type_code.disabled=true;
	}
}

function getBlockBedDate()
{
	var tranfer_type ;
	if(document.forms[0].transfer_type.value !='')
	{
		var retVal = 	new String();
		retVal = document.forms[0].transfer_type.value;
		var arr = retVal.split("=");

		var arr1=arr[0];
		/*Monday, September 13, 2010 SRR20056-SCF-5155 [IN:023680]*/
		if(document.forms[0].pseudo_bed.value == "Y" && document.forms[0].deact_pseudo_bed.value == "Y" && arr[2] != "")
		{
			var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
			error = error.replace('$',getLabel("Common.blocked.label","Common"));
					
			alert(error);
			document.forms[0].transfer_type_code.value=arr[0];
			document.forms[0].blocking_type_code.value=arr[1];
			document.forms[0].blocking_type.value=arr[2];
			document.forms[0].bed_blocking_period.value = "";
			document.forms[0].bed_block_until.value="";

		}/**/else
		{
			document.forms[0].transfer_type_code.value=arr[0];
			document.forms[0].blocking_type_code.value=arr[1];
			document.forms[0].blocking_type.value=arr[2];
			document.forms[0].bed_blocking_period.value=arr[3];
			
			document.forms[0].bed_block_until.value='';
			if(arr[4]!='')
				document.forms[0].bed_block_until.value=convertDate(arr[4],"DMYHM","en",localeName);
			document.forms[0].override_yn.value=arr[6];
			document.forms[0].bed_block_remarks.value='';
			document.forms[0].bed_block_remarks.readOnly=false;
			if(document.forms[0].blocking_type.value !='' && document.forms[0].bed_blocking_period.value=='')
			{
				document.forms[0].bed_blocking_period.value=arr[7];
				getBlockBedparam();
			}

			if(document.forms[0].bed_blocking_period.value =='')
				document.forms[0].bed_blocking_period.readOnly=true;
			else
				document.forms[0].bed_blocking_period.readOnly=false;
		
			if(document.forms[0].bed_blocking_period.value !='')
				document.forms[0].bed_blocking_period.focus();
		}
		var change_bed_class_yn = '';
		if(document.forms[0].change_bed_class_yn)
			change_bed_class_yn = document.forms[0].change_bed_class_yn.value;

		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field3' id='field3' value=\""+document.forms[0].transfer_type_code.value+"\"><input type='hidden' name='field4' id='field4' value='block_date'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value=\""+change_bed_class_yn+"\"></form></body></html>";
	}
	else
	{
		document.forms[0].bed_blocking_period.value ='';
		document.forms[0].bed_block_until.value='';
		document.forms[0].blocking_type.value ='';
		document.forms[0].bed_block_remarks.value='';
		document.forms[0].bed_block_remarks.readOnly=true;
		document.forms[0].bed_blocking_period.readOnly=true;
	}
}

function reset()
{
	parent.frames[2].frames[1].document.forms[0].reset();
	if (frames[1].document.forms[0].searchby != null)
	{
		if (frames[1].document.forms[0].soundex.value!='')
		{
			frames[1].document.forms[0].searchby.value="";
			frames[1].document.forms[0].searchby.disabled=true;
		}
		else
		{
			frames[1].document.forms[0].searchby.disabled=false;
			frames[1].document.forms[0].searchby.value="S";
		}
	}
	parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[1].document.forms[0].search.disabled=false;
}


function setReserveBedDtls()
{
	if (document.forms[0].reserved_bed_yn.checked==true)
	{
		document.forms[0].is_reserved_bed_checked.value='Y';
		document.forms[0].reason_for_reserved_bed.disabled=false;
		document.forms[0].reserved_bed_img.style.visibility='visible';
		alert(getMessage("OVERRIDE_BLOCK_PERIOD","IP"));
	}
	else
	{
		document.forms[0].is_reserved_bed_checked.value='N';		
		document.forms[0].reason_for_reserved_bed.options[0].selected = true;
		document.forms[0].reason_for_reserved_bed.disabled=true;
		document.forms[0].reserved_bed_img.style.visibility='hidden';

	}
	
}

//Added for the CRF - HSA-CRF-0035
function validateMotherBabyBed(nursing_unit,bed_no,patId){

	var xmlStr ="<root><SEARCH step='Delink' ";
	xmlStr +=" /></root>";
	 
	var param="&frnursingunitcode="+nursing_unit+"&tonursingunitcode="+nursing_unit+"&to_bed_no="+bed_no+"&patient_id="+patId;
	
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

