
    function Clear()
	{
		document.dischargeadvice_form.dischgsumsigned.checked=false;
		document.dischargeadvice_form.newmedicine.checked=false;
		document.dischargeadvice_form.stockmedicine.checked=false;
		document.dischargeadvice_form.lab.checked=false;
		document.dischargeadvice_form.xray.checked=false;
		document.dischargeadvice_form.scan.checked=false;
		document.dischargeadvice_form.ultrasound.checked=false;
		document.dischargeadvice_form.mri.checked=false;
		document.dischargeadvice_form.rt.checked=false;
		document.dischargeadvice_form.physio.checked=false;
		document.dischargeadvice_form.ecg.checked=false;
		document.dischargeadvice_form.diet.checked=false;
		document.dischargeadvice_form.pharmacy.checked=false;
		document.dischargeadvice_form.pmrequested.checked=false;
	}

	function Record()
    {
    	document.forms[0].submit();
    }

    function changeVal(obj)
	{
		var val = obj.name;

		if(val == "pmrequested")
			document.dischargeadvice_form.pmrequested.value="Y";
		if(val == "dischgsumsigned")
			document.dischargeadvice_form.dischgsumsigned.value="Y";
		if(val == "newmedicine")
			document.dischargeadvice_form.newmedicine.value="Y";
		if(val == "stockmedicine")
			document.dischargeadvice_form.stockmedicine.value="Y";
		if(val == "lab")
			document.dischargeadvice_form.lab.value="Y";
		if(val == "xray")
			document.dischargeadvice_form.xray.value="Y";
		if(val == "scan")
			document.dischargeadvice_form.scan.value="Y";
		if(val == "ultrasound")
			document.dischargeadvice_form.ultrasound.value="Y";
		if(val == "ultrasound")
			document.dischargeadvice_form.ultrasound.value="Y";
		if(val == "mri")
			document.dischargeadvice_form.mri.value="Y";
		if(val == "rt")
			document.dischargeadvice_form.rt.value="Y";
		if(val == "physio")
			document.dischargeadvice_form.physio.value="Y";
		if(val == "ecg")
			document.dischargeadvice_form.ecg.value="Y";
		if(val == "diet")
			document.dischargeadvice_form.diet.value="Y";
		else
			document.dischargeadvice_form.pharmacy.value="Y";
	}

  function valDate(obj,val)
  {
     var dateVal = obj.value;
     if(dateVal != '')
     {
      if(doDateTimeChk(obj))
      {
    	if(val == 'A')
		{
    	    var currdate = self.document.booking_form.currdate;
    	    if(!ValidateDateTime(obj,currdate))
    	    {
    	       alert(getMessage("FUTURE_DATE_NOT_ALLOWED","IP"));
    	       obj.focus();
    	       obj.select();
    	    }
    	  }
        }
      	else
    	{
    	      alert(getMessage("INVALID_DATE_TIME","SM"));
    	      obj.focus();
    	      obj.select();
    	}
   }
  }

function validDate(obj,val)
{
	var admdatetimeval  = self.dischargeadvice_form.admissiondatetime.value;
	var admdatetime     = admdatetimeval.substring(0,10);
	var ExpTime 	      = obj.value.substring(0,10);
	if(doDatetimeCheckAlert(admdatetime,ExpTime))
	{
		alert(getMessage("DIS_DATE_LT_EXCEEDED","IP"));
		obj.focus();
		obj.select();
	}
	else
	{	
		if(obj.value != '')
		{
			if(self.doDateTimeChk(obj))
			{
				if(val == 'A')
				{
					var currdate = self.document.booking_form.currdate;
					if(!ValidateDateTime(obj,currdate))
					{
						alert(getMessage("PT_CANT_BE_ADMT_FUT_DT","IP"));
						obj.focus();
						obj.select();
					}
				}
			}
			else
			{
				alert(getMessage("INVALID_DATE_TIME","SM"));
				obj.focus();
				obj.select();
			}
		}
	}
}



function CloseWin(obj)
{
	var closeVal = obj.value;
	if(closeVal == getLabel("Common.close.label","Common"))
	{
		//parent.window.close();  
		const dialogTag = parent.parent.document.getElementById("dialog_tag");
        dialogTag.close();
	}
	else if(closeVal == getLabel("eIP.AbortCancellation.label","IP"))
	{
		document.getElementById("u").innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;";
		document.getElementById("v").innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;";

		document.canceldischarge_form.cancel_discharge.value = getLabel("Common.CancelDischargeAdvice.label","Common");

		document.canceldischarge_form.close.value=getLabel("Common.close.label","Common");
	}
}
