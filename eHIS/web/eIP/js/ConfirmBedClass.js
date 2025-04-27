function submitForm_confirm()
{
	setTimeout('submitForm1_confirm()',500);	
}
function BLCheckElig_confirm()
{
	var bed_ref = "parent.frames[1].document.forms[0].reqstat";
	var modified_bed_type_ref = "parent.frames[1].document.forms[0].modified_bed_type_code";
	var url = parent.frames[2].location.href;
	var action_url="";

	var reasonForTransfer = parent.frames[1].document.forms[0].transfer_type_code.value;//Added by Dharma on 24th Oct 2017 against ML-MMOH-CRF-0865.1 [IN:065405]

	if(url.indexOf("/servlet")!=-1)
		var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.forms[0].bed_type_code.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.forms[0].billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.forms[0].to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/ConfirmBedClass.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
	else
		var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.forms[0].bed_type_code.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.forms[0].billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.forms[0].to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/ConfirmBedClass.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.dummy_form1.submit();
}
function submitForm1_confirm()
{	  
	if(parent.frames[1].document.forms[0].continue_yn.value != "N")
	{
		var flag = "F";
	
		if((parent.frames[1].document.forms[0].fr_nursing_unit_code.value != parent.frames[1].document.forms[0].nursing_unit.value)||			(parent.frames[1].document.forms[0].fr_bed_class.value != parent.frames[1].document.forms[0].Bedcode.value)||				(parent.frames[1].document.forms[0].fr_bed_no.value != parent.frames[1].document.forms[0].to_bed_no.value))
			flag = "T";

		if(flag == 'T')
		{
			var fields = new Array();

			fields[0] = parent.frames[1].document.forms[0].reqstat;
			fields[1] = parent.frames[1].document.forms[0].nursing_unit;
			fields[2] = parent.frames[1].document.forms[0].service;
			fields[3] = parent.frames[1].document.forms[0].Bedcode;
			fields[4] = parent.frames[1].document.forms[0].bed_type_code;
			fields[5] = parent.frames[1].document.forms[0].Splcode_desc;
			fields[6] = parent.frames[1].document.forms[0].pract_desc;
			if(parent.frames[1].document.forms[0].reqstat.value=='2')
			{
				fields[7] = parent.frames[1].document.forms[0].resnforrej;//Reason For Rejection

			var names = new Array (	getLabel('Common.RequestStatus.label','common'),
									getLabel('Common.nursingUnit.label','common'),
									getLabel('Common.service.label','common'),
									getLabel('Common.BedClass.label','common'),
									getLabel('Common.bedtype.label','common'),
									getLabel('Common.speciality.label','common'),
									getLabel('Common.practitioner.label','common'),
									getLabel('Common.ReasonforRejection.label','Common'));
			}
			else
			{
				var tfr_type = parent.frames[1].document.forms[0].tfr_type.value;

				if(tfr_type=='ET')
				{
					fields[7] = parent.frames[1].document.forms[0].to_bed_no;
				var names = new Array (	getLabel('Common.RequestStatus.label','common'),
									getLabel('Common.nursingUnit.label','common'),
									getLabel('Common.service.label','common'),
									getLabel('Common.BedClass.label','common'),
									getLabel('Common.bedtype.label','common'),
									getLabel('Common.speciality.label','common'),
									getLabel('Common.practitioner.label','common'),getLabel('Common.bedno.label','common') );
				}
				else
				{
					var names = new Array (	getLabel('Common.RequestStatus.label','common'),
									getLabel('Common.nursingUnit.label','common'),
									getLabel('Common.service.label','common'),
									getLabel('Common.BedClass.label','common'),
									getLabel('Common.bedtype.label','common'),
									getLabel('Common.speciality.label','common'),
									getLabel('Common.practitioner.label','common') );

				}
			}
			
			if(checkFields1( fields, names)) 
			{	
				parent.frames[1].document.forms[0].transfer.disabled = false;
				
				if(parent.frames[1].document.forms[0].bl_operational.value == 'Y')
				{
					if(parent.frames[1].document.forms[0].reqstat.value == '1')
						BLCheckElig_confirm();
					else
						applyone_confirm('Y', '');//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
				}
				else
					applyone_confirm('Y', '');//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
			}
		}
		else
			alert(self.getMessage('ATLEAST_BED_CHANGE ','IP'));
	}
	else
		parent.frames[1].document.forms[0].continue_yn.value = "";
}
function applyone_confirm(difframe,reqRadioBtn)
{
	parent.frames[1].document.forms[0].reqRadioBtn.value = reqRadioBtn;//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
	var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.EmergencyTransferServlet' >";
	for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++)
		   val += "<input type='hidden' name='"+ parent.frames[1].document.forms[0].elements[i].name +"' id='"+ parent.frames[1].document.forms[0].elements[i].name +"' value='"+ parent.frames[1].document.forms[0].elements[i].value +"'>"
	
	val += "</form></body><html>";
	
	parent.frames[2].document.write(val);
	parent.frames[2].document.Dummy_form.submit();
	
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

