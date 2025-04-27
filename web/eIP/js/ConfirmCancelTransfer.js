function submitForm_confmCncl(val)
{
	if (val=='CONFIRM' && document.forms[0].allow_transfer_yn.value=="N")
	{
	   alert(getMessage('FILE_IN_TRASIT','IP'));
	}
	else
	{
		if(val == 'CONFIRM')
		{
			//Maheshwaran added for GHL-CRF-0362
			var fields = new Array();
			fields[0] = parent.frames[1].document.ConfirmCancelTransfer_form.nursing_unit_desc;
			fields[1] = parent.frames[1].document.ConfirmCancelTransfer_form.service;
			fields[2] = parent.frames[1].document.ConfirmCancelTransfer_form.Splcode_desc;
			fields[3] = parent.frames[1].document.ConfirmCancelTransfer_form.pract_desc;
			fields[4] = parent.frames[1].document.ConfirmCancelTransfer_form.Bedcode;
			fields[5] = parent.frames[1].document.ConfirmCancelTransfer_form.bed_type_code;
			fields[6] = parent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no;
			var names = new Array (
			getLabel("Common.nursingUnit.label","Common"),
			getLabel("Common.service.label","Common"),	
     		getLabel("Common.speciality.label","Common"),					
			getLabel("Common.practitioner.label","Common"),		
			getLabel("Common.BedClass.label","common"),
			getLabel("Common.bedtype.label","Common"),
			getLabel("Common.bedno.label","Common"));
			if(checkFields1( fields, names)) 
				{
				//End
			//parent.frames[1].document.forms[0].document.ConfirmCancelTransfer_form.confirm_or_cancel.value =getLabel("Common.confirm.label","Common");
			/*Thursday, August 19, 2010 , commnted since for thai confirm request for transfer this values is passed in thai.*/
			document.getElementById('confirm_or_cancel').value ="Confirm";
			var BedcodeVal = document.getElementById('Bedcode').value;
			var to_bed_noVal = document.getElementById('to_bed_no').value;
			if(document.getElementById('block_bed').checked==true)
			{
				var bed_blk_period =document.getElementById('bed_block_periond').value;
			}
			//Maheshwaran commented for GHL-CRF-0362
			/*if(BedcodeVal == "")
			{
				var error = getMessage('BED_CLASS_NOT_NULL','IP');
				alert(error);
				return;
			}
			else if(to_bed_noVal == "")
			{
				var error = getMessage('BED_NO_NOTNULL','IP');
				alert(error);
				return
			}
			else*/
			//End
			if(bed_blk_period =="")
			{	
				var errors = getMessage('CAN_NOT_BE_BLANK','COMMON');
				/*Wednesday, December 30, 2009 , IN017775*/
				errors = errors.replace('$',getLabel("eIP.BlockPeriod.label","IP"));
				alert(errors);
				return
			}
			var bed_no=document.getElementById('to_bed_no').value;
			if(bed_no =! null)
			{
				if(document.getElementById('to_room_no').value == "")
				{
					return;
				}

				var nursingunit = self.document.ConfirmCancelTransfer_form.nursing_unit.value;
				var to_bed_no = self.document.ConfirmCancelTransfer_form.to_bed_no.value;
				var bedno = bed_no.value;
				var url = parent.frames[2].location.href;
				var action_url="";
				if(url.indexOf("/servlet")!=-1)
				{
					var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/TransferValidation.jsp'>"+
					" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
					" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Confirm_transfer'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
				}
				else
				{
					var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form1' id='dum_form1' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
					" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
					" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='c_field4' id='c_field4' value='Confirm_transfer'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
				}
			}
			document.getElementById('confirm_or_cancel').disabled = true;	

			var vals="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.ConfirmCancelTransferServlet' >";
			for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++)
			{
				vals += "<input type='hidden' name='"+ parent.frames[1].document.forms[0].elements[i].name +"' id='"+ parent.frames[1].document.forms[0].elements[i].name +"' value=\""+ parent.frames[1].document.forms[0].elements[i].value +"\">"
			}
			vals += "</form></body><html>";
			parent.frames[2].document.write(vals);
			parent.frames[2].document.Dummy_form.submit();
			}
		}
		else
		{
			
			parent.window[1].ConfirmCancelTransfer_form.confirm_or_cancel.value = getLabel("Common.cancel.label","Common");;
			var vals="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.ConfirmCancelTransferServlet' >";
			for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++)
			{
				vals += "<input type='hidden' name='"+ parent.frames[1].document.forms[0].elements[i].name +"' id='"+ parent.frames[1].document.forms[0].elements[i].name +"' value=\""+ parent.frames[1].document.forms[0].elements[i].value +"\">"
			}
			vals += "</form></body><html>";
			parent.frames[2].document.write(vals);	
			parent.frames[1].document.forms[0].confirm_or_cancel.disabled = true;		
			parent.frames[2].document.Dummy_form.submit();
		}
	}
}

function applyone(difframe)
{	
	
	var vals="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.ConfirmCancelTransferServlet' >";
	for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++)
	{
	  vals += "<input type='hidden' name='"+ parent.frames[1].document.forms[0].elements[i].name +"' id='"+ parent.frames[1].document.forms[0].elements[i].name +"' value=\""+ parent.frames[1].document.forms[0].elements[i].value +"\">"
	}
	vals += "</form></body><html>";
	parent.frames[2].document.write(vals);	
	parent.frames[2].document.Dummy_form.submit();
}	

function BLCheckElig()
{
	var bed_ref = "parent.frames[1].document.forms[0].to_bed_type";
	var modified_bed_type_ref = "parent.frames[1].document.forms[0].modified_bed_type_code";
	var url = parent.frames[2].location.href;
	
	var action_url="";
		if(url.indexOf("/servlet")!=-1)
		{
			var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.forms[0].to_bed_type.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.forms[0].billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.forms[0].to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value=\""+bed_ref+"\"><input type='hidden' name='field6' id='field6' value=\""+modified_bed_type_ref+"\"><input type='hidden' name='field7' id='field7' value='../js/ConfirmCancelTransfer.js'></form></body></html>";
		}
		else
		{
			var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[1].document.forms[0].to_bed_type.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[1].document.forms[0].billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[1].document.forms[0].to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value=\""+bed_ref+"\"><input type='hidden' name='field6' id='field6' value=\""+modified_bed_type_ref+"\"><input type='hidden' name='field7' id='field7' value='../js/ConfirmCancelTransfer.js'></form></body></html>";
		}

	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.dummy_form1.submit();
}

//pasted from ConfirmBookBedTransfer.jsp

function changebedclass()
{
	parent.frames[1].document.ConfirmCancelTransfer_form.to_room_no.value="";
	parent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no.value="";	
}


function enableInform()
{
	if (document.forms[0].block_bed.checked==true)
	{

		if(document.forms[0].pseudo_bed.value == "Y" && document.forms[0].deactivate_pseudo_bed.value == "Y")
		{
			var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
			error = error.replace('$',getLabel("Common.blocked.label","Common"));		
			alert(error);
			document.forms[0].block_bed.checked=false;
			document.forms[0].block_bed.value='N';
			document.forms[0].bed_block_periond.value='';
			document.forms[0].bed_block_periond.disabled= true;
			document.forms[0].override.checked=false;
			document.forms[0].override.disabled	= true;
			document.getElementById("img_m").style.visibility	= "hidden";

		}
		else
		{
			document.forms[0].bed_block_periond.disabled= false;
			document.forms[0].override.disabled	= false;
			document.getElementById("img_m").style.visibility	= "Visible";
		}
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

function checkValues()
{
	if (document.forms[0].override.checked == true)
		document.forms[0].override.value = "Y";
	else
		document.forms[0].override.value = "N";
}

function allowOnlyNumbers(event)
{
	if (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 46))
		return true;
	else return false;
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

function clearRoom()
{
	if (document.forms[0].to_bed_no.value=="")
	document.forms[0].to_room_no.value="";
}

function checkForMaxPeriod()
{
	var period_no=eval(document.forms[0].bed_block_periond.value);
	if(period_no>0)
	{
		if (eval(document.forms[0].bed_block_periond.value) > eval(document.forms[0].def_max_period.value))
		{
			var error = getMessage('BED_BLK_PRD_CANT_EXCEED','IP');
			error = error.replace('$',getLabel("eIP.BlockPeriod.label","IP"));
			alert(error);
			document.forms[0].bed_block_periond.select();
		}
	}
	else if(period_no == 0)
	{
	var error = getMessage('VALUE_SHOULD_BE_GR_ZERO','common');
		error = error.replace('Value',getLabel("eIP.BlockPeriod.label","IP"));
		alert(error);
   document.forms[0].bed_block_periond.select();
	}
}

function seDef()
{
	if (document.getElementById("img_m"))
	{
		document.getElementById("img_m").style.visibility	= "hidden";
	}
}

//function common for both cancel and confirm function

override_yn = new Array();

function setOverride(object)
{
	var i = object.selectedIndex;
	if (i > 0)
	{
			if(override_yn[i-1]=='Y')
			{
				document.getElementById("overrides").checked = true;
				document.getElementById("override").value = 'Y';							
			}
			else
			{
				document.getElementById("overrides").checked = false;
				document.getElementById("override").value = 'N';
			}
	}
	else
	{
		document.getElementById("overrides").checked = false;
		document.getElementById("override").value = 'N';
	}
}
//this function is common for cancel,confirm and AccompanyingPersonDetails function 
function objChk(obj)
{
	if (obj.checked)
		document.forms[0].overrides.value = 'Y';
	else
		document.forms[0].overrides.value = 'N';
}

function OffsetDate(sysdatetime,strPri1,strDftUnts1)
{
	var result = "";
	var days= strPri1;
	if(days!=''){
	var sysdate = sysdatetime.substring(0,10);
	var systime = sysdatetime.substring(11,16);

	/***building current date object from sysdate to avoid local machine date setting errors **/
	var dateArray = sysdate.split("/");
	sysdate1=dateArray[1]+"/"+dateArray[0]+"/"+dateArray[2]
	var tempdate = Date.parse(sysdate1);
	var currentDate=new Date(tempdate);
	var timeArray = systime.split(":");
	systime1=dateArray[1]+"/"+dateArray[0]+"/"+dateArray[2]+" "+timeArray[0]+":"+timeArray[1]
	var tempdatetime = Date.parse(systime1);
	var currentDateTime=new Date(tempdatetime);

	var dwm= strDftUnts1;
	var currentMonth=currentDate.getMonth();
	var presentDate=currentDate.getDate();
	var presentTime=currentDateTime.getHours();
	var finaldate;

		if(dwm=='D')
		{
			finaldate=presentDate+eval(days);
			currentDate.setDate(finaldate);
			result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
		}
		else if(dwm=='W')
		{
			finaldate=presentDate+eval(days*7);
			currentDate.setDate(finaldate);
			result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
		}
		else if(dwm=='H') 
		{
			finaldate=presentTime+eval(days);
			currentDateTime.setHours(finaldate);
			result = currentDateTime.getDate()+"/"+eval(currentDateTime.getMonth()+1)+"/"+currentDateTime.getFullYear()+" "+currentDateTime.getHours()+":"+currentDateTime.getMinutes();
		}
		else
		{
			currentDate.setMonth(eval(currentMonth+eval(days)));
			result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
		}
			document.ConfirmCancelTransfer_form.pri_target.value = result;
	}
	else
	{
		document.ConfirmCancelTransfer_form.pri_target.value = "";
	}
	return result;
}

function getRoomNo1(bedno)
{
	obj=bedno;
	self.document.ConfirmCancelTransfer_form.to_bed_no.focus();
	self.document.ConfirmCancelTransfer_form.to_bed_no.select();
	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
		self.document.ConfirmCancelTransfer_form.to_room_no.value = '';	
		var nursingunit = self.document.ConfirmCancelTransfer_form.to_nursing_unit_code.value;
		var to_bed_no = self.document.ConfirmCancelTransfer_form.to_bed_no.value;
		var bedno = obj.value;
		var url = parent.frames[2].location.href;
		var action_url="";
			if(url.indexOf("/servlet")!=-1){
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
			}
			else{
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
			}		
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
	  }
   }
}

function checkForBedNo(obj)
{
	if (document.ConfirmCancelTransfer_form.to_bed_no.value=="")
		document.ConfirmCancelTransfer_form.to_room_no.value="";
	
} // End of checkForBedNo.

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



function ComputeBlDtl()
{
	var fm_nur_code	=	document.forms[0].fr_nursing_unit_code;
	var to_nur_code	=	document.forms[0].to_nursing_unit_code;
	var fm_bed_no	=	document.forms[0].fr_bed_no;
	var to_bed_no	=	document.forms[0].to_bed_no;
	var fm_bed_class=	document.forms[0].fr_bed_class;
	var to_bed_class=	document.forms[0].to_bed_class;
	var trans_code	=	document.forms[0].transfer_type;
	var encount_id	=	document.forms[0].encounter_id;

	if(trans_code.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
			error = error.replace('$',getLabel("eIP.TransferType.label","IP"));
			alert(error);					
		trans_code.focus();
		return false;
	}

	if(to_nur_code.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
	error = error.replace('$',getLabel("Common.TransfertoNursingUnit.label","Common"));
	alert(error);					
		to_nur_code.focus();
		return false;
	}

	if(to_bed_class.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
	error = error.replace('$',getLabel("Common.TransfertoBed.label","Common"));
	alert(error);					
	to_bed_class.focus();
	return false;
	}

	if(to_bed_no.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
	error = error.replace('$',getLabel("Common.TransfertoRoomCubicleNo.label","Common"));
	alert(error);					
	to_bed_no.focus();
	return false;
	}

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='BLBedTrans' id='BLBedTrans' method='post' action='../../eBL/jsp/BLBedTrans.jsp' >"+
	"<input type='hidden' name='fm_nur_code' id='fm_nur_code' value='"+fm_nur_code.value+"'>"+
	"<input type='hidden' name='to_nur_code' id='to_nur_code' value='"+to_nur_code.value+"'> "+
	"<input type='hidden' name='fm_bed_no' id='fm_bed_no' value='"+fm_bed_no.value+"'> "+
	"<input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no.value+"'> "+
	"<input type='hidden' name='fm_bed_class' id='fm_bed_class' value='"+fm_bed_class.value+"'> "+
	"<input type='hidden' name='to_bed_class' id='to_bed_class' value='"+to_bed_class.value+"'> "+
	"<input type='hidden' name='trans_code' id='trans_code' value='"+trans_code.value+"'> "+
	"<input type='hidden' name='encount_id' id='encount_id' value='"+encount_id.value+"'> "+
	"</form></body></html>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.BLBedTrans.submit();
}

function getRoomNo(obj)
{
	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
		self.document.ConfirmCancelTransfer_form.to_room_no.value = '';	
		var nursingunit = self.document.ConfirmCancelTransfer_form.to_nursing_unit_code.value;
		var to_bed_no = self.document.ConfirmCancelTransfer_form.to_bed_no.value;
		var bedno = obj.value;
		var url = parent.frames[2].location.href;
		var action_url="";
			if(url.indexOf("/servlet")!=-1){
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
			}
			else{
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
			}
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
		}
	}
}

//pasted from CancelBookBedTransfer.jsp
async function callBedAvailChart()
{
	var nursingunit		 = parent.frames[1].document.ConfirmCancelTransfer_form.to_nursing_unit_code.value;
	var practitionerid	 = parent.frames[1].document.ConfirmCancelTransfer_form.to_practitioner_id.value;
	var specialitycode	 = parent.frames[1].document.ConfirmCancelTransfer_form.to_speciality_code.value;
	var bedclasscode	 = parent.frames[1].document.ConfirmCancelTransfer_form.Bedcode.value;
	var gender			 = parent.frames[1].document.ConfirmCancelTransfer_form.patient_gender.value;
	var agevalue		 = parent.frames[1].document.ConfirmCancelTransfer_form.age.value;
	var age				 = "" ;
	var yr				 = eval(agevalue.indexOf("Y"));
	var mon				 = eval(agevalue.indexOf("M"));

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
	var dialogHeight= "50vh" ;
	var dialogWidth	= "49vw" ;
	var dialogTop	= "66" ;
	var status = "no";
	var arguments	= "" ;
	var wherecondn  = "EMERGENCY_TFR_YN"; 
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?nursing_unit_code="+escape(nursingunit)+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);

	if(retVal!=null)
	{
		var arr = retVal.split("^");
		if(arr.length > 2)
		{
			var arr1 = arr[1].split("/");
			parent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no.value = arr1[0];

			var arrsplty = arr[11].split("*All SPLTY*");
			if (arrsplty.length==1)
			{
				parent.frames[1].document.ConfirmCancelTransfer_form.to_speciality_code.value=arr[10];
			}

			p = parent.frames[1].document.ConfirmCancelTransfer_form.Bedcode.options;
			for (i=0; i<p.options.length; i++) 
			{
				if(p.options[i].value ==arr[3])
					p.options[i].selected = true;
			}
			
			if(arr[4] ==null )  	arr[4] ='';
			
			parent.frames[1].document.ConfirmCancelTransfer_form.to_room_no.value=arr[4];
			getRoomNo(parent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no);
		}
	}
}

	function BeforeGetPractitioner(obj,target, aFacilityID)
	{
		if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_descn.value)
		{
			if(document.forms[0].pract_descn.value!= "")
			  getPractitionerLocal(obj,target, aFacilityID)
		}
	}
		//Added by kishore for Practioner on 4/27/2004
	function checkPractTxtVal(obj,target, aFacilityID)
	{
		if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_descn.value)
		{
			getPractitionerLocal(obj,target, aFacilityID);
		}
	}

	function getPractitionerLocal(obj,target, aFacilityID)
	{
		var practName_FName="";
		var practName_FValue="";
		var practId_FName="";
		practName_FName=target.name;
		practName_FValue=target.value;
		practId_FName=document.forms[0].authorized_practid.name;
		var nursing_unit_code	= document.forms[0].nursing_unit.value;
		var spl_code			= document.forms[0].fr_speciality_code.value;
		var facility_id = aFacilityID;
        locale=document.forms[0].locale1.value;

		getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");
/*
	
		var sql = " SELECT a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position(b.position_code,'"+locale+"',1)  job_title FROM ip_nursing_unit_for_pract_vw a, am_pract_all_splty_vw b WHERE a.practitioner_id = b.practitioner_id AND a.facility_id = '"+facility_id+"' and a.facility_id = b.facility_id AND nursing_unit_code = '"+nursing_unit_code+"' and b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER (?) AND (UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL) ";

		var sql2 = " SELECT a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position(b.position_code,'"+locale+"',1)  job_title FROM ip_nursing_unit_for_pract_vw a, am_pract_all_splty_vw b WHERE a.practitioner_id = b.practitioner_id AND a.facility_id = '"+facility_id+"' and a.facility_id = b.facility_id AND nursing_unit_code = '"+nursing_unit_code+"' and b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER (?) AND (UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) and  UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL) ";

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
	} // End of getPractitioner();
	
	// To set the values to Attending Practitioner when using GeneralPratitionerLookup. It's called by the GeneralPratitionerLookup.
	function PractLookupRetVal(retVal,objName)
	{
		var arr;
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


	function checkForValues()
		{
	
		document.forms[0].pract_desc.focus();
		}
	//Added by kishore on 4/28/2004
	async function checkForMandatory()
	{
		if (document.forms[0].reason_for_cancel.value=="")
		 {
			alert(getMessage('CANCEL_REAS_NOT_BLNK','IP'));
			document.forms[0].reason_for_cancel.focus();
			return false;
		}
		if (document.forms[0].pract_descn.value=="")
		{
			var error = getMessage('AUTH_PRACT_NOTNULL','IP');
			alert(error);
			document.forms[0].pract_descn.focus();
			return false;
		}
		else
		{
			await submitForm_confmCncl('CANCEL');
		}
	
	} // End of checkForValues.

function setdefault()
{
	if (document.forms[0].Bedcode != null)
		document.forms[0].Bedcode.disabled = true;
}


//functions moved from AccompanyingPersonDetails.jsp

function objChk(obj)
{
	if (obj.checked)
		document.forms[0].overrides.value = 'Y';
	else
		document.forms[0].overrides.value = 'N';
}


function OffsetDate(sysdatetime,strPri1,strDftUnts1)
{
	
	var result = "";
	var days= strPri1;
	if(days!=''){
	var sysdate = sysdatetime.substring(0,10);
	var systime = sysdatetime.substring(11,16);
	
	/***building current date object from sysdate to avoid local machine date setting errors **/
	var dateArray = sysdate.split("/");
	sysdate1=dateArray[1]+"/"+dateArray[0]+"/"+dateArray[2]
	var tempdate = Date.parse(sysdate1);
	var currentDate=new Date(tempdate);

	var timeArray = systime.split(":");
	systime1=dateArray[1]+"/"+dateArray[0]+"/"+dateArray[2]+" "+timeArray[0]+":"+timeArray[1]
	var tempdatetime = Date.parse(systime1);
	var currentDateTime=new Date(tempdatetime);
	
	var dwm= strDftUnts1;
	var currentMonth=currentDate.getMonth();
	var presentDate=currentDate.getDate();
	var presentTime=currentDateTime.getHours();
			
	var finaldate;

		if(dwm=='D'){
			finaldate=presentDate+eval(days);
			currentDate.setDate(finaldate);
			result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
		}
		else if(dwm=='W'){
			finaldate=presentDate+eval(days*7);
			currentDate.setDate(finaldate);
			result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
		}
		else if(dwm=='H') {
			finaldate=presentTime+eval(days);
			currentDateTime.setHours(finaldate);
			result = currentDateTime.getDate()+"/"+eval(currentDateTime.getMonth()+1)+"/"+currentDateTime.getFullYear()+" "+currentDateTime.getHours()+":"+currentDateTime.getMinutes();
		}
		else{
			currentDate.setMonth(eval(currentMonth+eval(days)));
			result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
		}
	document.ConfirmCancelTransfer_form.pri_target.value = result;
	}
	else
	{
		document.ConfirmCancelTransfer_form.pri_target.value = "";
	}
	
	return result;
}


function getRoomNo(obj)
{
	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
		self.document.ConfirmCancelTransfer_form.to_room_no.value = '';	
		var nursingunit = self.document.ConfirmCancelTransfer_form.to_nursing_unit_code.value;
		var to_bed_no = self.document.ConfirmCancelTransfer_form.to_bed_no.value;
		var bedno = obj.value;
		var url = parent.frames[2].location.href;
		var action_url="";
			if(url.indexOf("/servlet")!=-1){
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/GetValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Emergency_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
			}
			else{
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/GetValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Emergency_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
			}

		
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
		}
	}
}

function checkForBedNo()
{
	if (document.ConfirmCancelTransfer_form.to_bed_no.value=="")
		document.ConfirmCancelTransfer_form.to_room_no.value="";
} // End of checkForBedNo.


async function callBedAvailChart()
{
	var nursingunit = parent.frames[1].document.ConfirmCancelTransfer_form.to_nursing_unit_code.value;
	var practitionerid = parent.frames[1].document.ConfirmCancelTransfer_form.to_practitioner_id.value;
	var specialitycode = parent.frames[1].document.ConfirmCancelTransfer_form.to_speciality_code.value;
	var bedclasscode = parent.frames[1].document.ConfirmCancelTransfer_form.Bedcode.value;
	var gender = parent.frames[1].document.ConfirmCancelTransfer_form.patient_gender.value;
	var agevalue = parent.frames[1].document.ConfirmCancelTransfer_form.age.value;
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
	var dialogHeight= "60vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop	= "72" ;
	var status = "no";
	var arguments	= "" ;
	var wherecondn  = "EMERGENCY_TFR_YN"; 
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?nursing_unit_code="+escape(nursingunit)+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);

	if(retVal!=null)
	{
		var arr = retVal.split("^");
		if(arr.length > 2)
		{
			var arr1 = arr[1].split("/");
			parent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no.value = arr1[0];

			
			var arrsplty = arr[11].split("*All SPLTY*");
			if (arrsplty.length==1)
			{
				parent.frames[1].document.ConfirmCancelTransfer_form.to_speciality_code.value=arr[10];
			}

			p = parent.frames[1].document.ConfirmCancelTransfer_form.Bedcode.options;
			for (i=0; i<p.options.length; i++) {
				if(p.options[i].value ==arr[3])
					p.options[i].selected = true;
			}

			
			if(arr[4] ==null )  	arr[4] ='';
			
			parent.frames[1].document.ConfirmCancelTransfer_form.to_room_no.value=arr[4];
			getRoomNo(parent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no);
		}
	}

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
function ComputeBlDtl()
{
	

	var fm_nur_code	=	document.forms[0].fr_nursing_unit_code;
	var to_nur_code	=	document.forms[0].to_nursing_unit_code;
	var fm_bed_no	=	document.forms[0].fr_bed_no;
	var to_bed_no	=	document.forms[0].to_bed_no;
	var fm_bed_class=	document.forms[0].fr_bed_class;
	var to_bed_class=	document.forms[0].to_bed_class;
	var trans_code	=	document.forms[0].transfer_type;
	var encount_id	=	document.forms[0].encounter_id;

	if(trans_code.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
			error = error.replace('$',getLabel("eIP.TransferType.label","IP"));
			alert(error);					
		trans_code.focus();
		return false;
	}

	if(to_nur_code.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
	error = error.replace('$',getLabel("Common.TransfertoNursingUnit.label","Common"));
	alert(error);					
		to_nur_code.focus();
		return false;
	}

	if(to_bed_class.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
	error = error.replace('$',getLabel("Common.TransfertoBed.label","Common"));
	alert(error);					
	to_bed_class.focus();
	return false;
	}

	if(to_bed_no.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
	error = error.replace('$',getLabel("Common.TransfertoRoomCubicleNo.label","Common"));
	alert(error);					
	to_bed_no.focus();
	return false;
	}

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='BLBedTrans' id='BLBedTrans' method='post' action='../../eBL/jsp/BLBedTrans.jsp' >"+
	"<input type='hidden' name='fm_nur_code' id='fm_nur_code' value='"+fm_nur_code.value+"'>"+
	"<input type='hidden' name='to_nur_code' id='to_nur_code' value='"+to_nur_code.value+"'> "+
	"<input type='hidden' name='fm_bed_no' id='fm_bed_no' value='"+fm_bed_no.value+"'> "+
	"<input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no.value+"'> "+
	"<input type='hidden' name='fm_bed_class' id='fm_bed_class' value='"+fm_bed_class.value+"'> "+
	"<input type='hidden' name='to_bed_class' id='to_bed_class' value='"+to_bed_class.value+"'> "+
	"<input type='hidden' name='trans_code' id='trans_code' value='"+trans_code.value+"'> "+
	"<input type='hidden' name='encount_id' id='encount_id' value='"+encount_id.value+"'> "+
	"</form></body></html>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.BLBedTrans.submit();
}

