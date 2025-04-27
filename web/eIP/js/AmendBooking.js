function reset() 
{
	parent.frames[2].frames[1].frames[0].document.forms[0].reset();

	if (parent.frames[2].frames[1].frames[0].document.forms[0].searchby != null)
	{
		if (parent.frames[2].frames[1].frames[0].document.forms[0].soundex != null)
		{
			if (parent.frames[2].frames[1].frames[0].document.forms[0].soundex.value!='')
			{
				parent.frames[2].frames[1].frames[0].document.forms[0].searchby.value="";
				parent.frames[2].frames[1].frames[0].document.forms[0].searchby.disabled=true;
			}
			else
			{
				parent.frames[2].frames[1].frames[0].document.forms[0].searchby.disabled=false;
				parent.frames[2].frames[1].frames[0].document.forms[0].searchby.value="S";
			}
		}
		else
		{
			parent.frames[2].frames[1].frames[0].document.forms[0].searchby.disabled=false;
			parent.frames[2].frames[1].frames[0].document.forms[0].searchby.value="S";
		}
	}
	parent.frames[2].frames[1].frames[1].location.href ='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].document.forms[0].search.disabled=false;
}

async function PatInsModalWindow(){//For the CRF- RUT-CRF-013 23396
	var booking_ref_no=document.amend_booking.bkg_lst_ref_no.value;
	var patient_id=document.amend_booking.patient_id.value;
	var nursingunitcode=document.amend_booking.nursing_unit.value;
	var features    = "dialogHeight:84vh; dialogWidth:54vw; scroll=no; status:no;";
	var arguments = '';	

	var url="../../eIP/jsp/IPBkgPatientInstructionsMain.jsp?nursing_unit_code="+nursingunitcode+"&from_page=amendBooking&patient_id="+patient_id+"&NUInsYN=N&booking_ref_no="+booking_ref_no+"&addInstructionYN=N";
	var retVal = await window.showModalDialog(url,arguments,features);	
	//Changes for RUT-CRF-13.1 IN035825 - start
	/*if(retVal=="true"){
		document.forms[0].NUInstsExist.style.visibility='visible';
	}else{
		document.forms[0].NUInstsExist.style.visibility='hidden';
	}*/
	//Changes for RUT-CRF-13.1 IN035825 - end
}
//Changes for RUT-CRF-13.1 IN035825 - start
function checkPatInstns(){
	var booking_ref_no=document.amend_booking.bkg_lst_ref_no.value;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH step='nine'  bookingref=\""+booking_ref_no+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText= trimString(responseText)
	if (responseText>=1)
	{
		document.forms[0].NUInstsExist.style.visibility='visible';
	}
}
//Changes for RUT-CRF-13.1 IN035825 - end
//Changes for 39700 - start
function onAbortCancellation(){
	var booking_ref_no=document.amend_booking.bkg_lst_ref_no.value;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH step='eleven'  bookingref=\""+booking_ref_no+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
}
//Changes for 39700 - end
