function submitForm()
{
	setTimeout('submitForm1()',500);	
}
function submitForm1()
{
	if(parent.frames[1].document.CancelTransfer_Form.cont.value != "N")
	{
		var fields = new Array();
		fields[0] = parent.frames[1].document.CancelTransfer_Form.fr_bed_no;
		fields[1] = parent.frames[1].document.CancelTransfer_Form.sltReasonForCancel;
		
		var names = new Array (	getLabel('Common.bedno.label','common'),getLabel("eIP.ReasonforCancel.label","IP"));
		var url = parent.frames[1].location.href;
		var cont =parent.frames[1].document.CancelTransfer_Form.cont.value;
		if(checkFields1( fields, names) == true) 
		{
			
				var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.CancelTransferServlet' >";
				for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++)
				{
				   val += "<input type='hidden' name='"+ parent.frames[1].document.forms[0].elements[i].name +"' id='"+ parent.frames[1].document.forms[0].elements[i].name +"' value=\""+ parent.frames[1].document.forms[0].elements[i].value +"\">"
				}
			
				val += "</form></body><html>";
				parent.frames[2].document.write(val);
				parent.frames[2].document.Dummy_form.submit();
			
		}
	}
	else
	{	
	parent.frames[1].document.CancelTransfer_Form.cont.value = "";
	}
}
async function callBedAvailChart()
{
	var nursingunit = parent.frames[1].document.CancelTransfer_Form.nursing_unit.value;
	var practitionerid = parent.frames[1].document.CancelTransfer_Form.practid.value;
	var specialitycode = parent.frames[1].document.CancelTransfer_Form.Splcode.value;
	var bedclasscode = parent.frames[1].document.CancelTransfer_Form.fr_bed_class.value;
	var gender = parent.frames[1].document.CancelTransfer_Form.gender.value;
	var agevalue = parent.frames[1].document.CancelTransfer_Form.age.value;

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
	var dialogHeight= "50vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop	= "72" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?nursing_unit_code="+escape(nursingunit)+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender),arguments,features);

	if(retVal!=null)
	{
		var arr = retVal.split("¤");
		var arr1 = arr[1].split("/");
		
			if(arr[0] != nursingunit )
			{
				alert(getMessage("SELECT_PREV_NURS_UNIT_BED","IP"))
				return;
			}
		parent.frames[1].document.CancelTransfer_Form.btnConfirm.disabled = false;
		parent.frames[1].document.CancelTransfer_Form.fr_bed_no.value = arr1[0];
		parent.frames[1].document.getElementById("frroomno").innerHTML=arr[4];

	}
}

function onBedClassChange(obj)
{

}

function cancel()
{
	window.parent.close();
}

function callPopulateRoomNo(obj)
{
	if(specialChar(obj,'Char')==true)
	{
		
		if(obj.value!='')
		{
		var nursingunit = self.document.CancelTransfer_Form.nursing_unit.value;
		var fr_bed_no   = self.document.CancelTransfer_Form.fr_bed_no.value;
		var to_practitioner_vlaue = self.document.CancelTransfer_Form.practid.value;
		document.CancelTransfer_Form.cont.value = "N";
		var url = parent.frames[2].location.href;
		
		
			if(url.indexOf("/servlet")!=-1){
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/CancelTransferPopulate.jsp'><input type='hidden' name='hdnNursingUnit' id='hdnNursingUnit' value='"+nursingunit+"'><input type='hidden' name='hdnBedNo' id='hdnBedNo' value='"+fr_bed_no+"'><input type='hidden' name ='object' value='"+obj.name+"'></form></body></html>";
			}
			else{
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/CancelTransferPopulate.jsp'><input type='hidden' name='hdnNursingUnit' id='hdnNursingUnit' value='"+nursingunit+"'><input type='hidden' name='hdnBedNo' id='hdnBedNo' value='"+fr_bed_no+"'><input type='hidden' name ='object' value='"+obj.name+"'></form></body></html>";
			}
			
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal) 
			parent.frames[2].document.dum_form.submit();
			
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

function confirm()
{
	if(parent.frames[1].document.CancelTransfer_Form.sltReasonForCancel.value != "")
	{
		document.forms[0].action="../../servlet/eIP.CancelTransferServlet";
		document.forms[0].target="Dummy_frame";
		document.forms[0].submit();	
		//parent.frames[1].document.CancelTransfer_Form.submit();
	}
	else
	{
		alert(getMessage("CANCEL_REAS_NOT_BLNK","IP"));
		parent.frames[1].document.CancelTransfer_Form.sltReasonForCancel.focus();
	}
}





