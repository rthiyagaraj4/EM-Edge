function apply() 
{
    var fields = new Array(frames[1].document.forms[0].hmis_hospital,frames[1].document.forms[0].hmis_state,frames[1].document.forms[0].hmis_file_type);
     var names  = new Array (getLabel("Common.Hospital.label","Common"),getLabel("Common.State.label","Common"),getLabel("eMR.ExternalFile.label","MR"));
	 if(frames[1].checkFields( fields,names,messageFrame))
     {

		if(frames[1].document.forms[0].date_of_birth != null)
		 {
			 if(frames[1].document.forms[0].date_of_birth.value=="")
			 {
				var msg = getMessage("CAN_NOT_BE_BLANK",'Common');
				msg = msg.replace("$", getLabel("Common.dischargedate.label","Common"))
				alert(msg);
				frames[0].location.reload();
				return false;
			 }

			var strDate;
			var strDay;
			var strMonth;
			var strYear;
			var strDateArray = new Array();

			strDate = frames[1].document.forms[0].date_of_birth.value;
			strDateArray = strDate.split("/");

			strDay = strDateArray[0];
			strMonth = strDateArray[1];
			strYear = strDateArray[2];

			if(strDay==01||strDay==1)
			strDay="01"
			else
			if(strDay==02||strDay==2)
			strDay="02"

			else
			if(strDay==03||strDay==3)
			strDay="03"

			else
			if(strDay==04||strDay==4)
			strDay="04"

			else
			if(strDay==05||strDay==5)
			strDay="05"

			else
			if(strDay==06||strDay==6)
			strDay="06"

			else
			if(strDay==07||strDay==7)
			strDay="07"

			else
			if(strDay==08||strDay==8)
			strDay="08"

			else
			if(strDay==09||strDay==9)
			strDay="09"
				else{}

			if(strMonth==01||strMonth==1)
			strMonth="01"
			else
			if(strMonth==02||strMonth==2)
			strMonth="02"

			else
			if(strMonth==03||strMonth==3)
			strMonth="03"

			else
			if(strMonth==04||strMonth==4)
			strMonth="04"

			else
			if(strMonth==05||strMonth==5)
			strMonth="05"

			else
			if(strMonth==06||strMonth==6)
			strMonth="06"

			else
			if(strMonth==07||strMonth==7)
			strMonth="07"

			else
			if(strMonth==08||strMonth==8)
			strMonth="08"

			else
			if(strMonth==09||strMonth==9)
			strMonth="09"
			else{}

			frames[1].document.forms[0].discharge_date.value = strDay+'/'+strMonth + '/' + strYear
		 }



		if(frames[1].document.forms[0].date_of_birth2 != null)
		 {
			 
		 if(frames[1].document.forms[0].date_of_birth2.value=="")
			 {
				var msg = getMessage("CAN_NOT_BE_BLANK",'Common');
				msg = msg.replace("$", getLabel("eIP.CensusDate.label","IP"))
				alert(msg);
				frames[0].location.reload();
				return false;
			 }
				var strDate;
				var strDay;
				var strMonth;
				var strYear;
				var strDateArray = new Array();

			strDate = frames[1].document.forms[0].date_of_birth2.value;
			strDateArray = strDate.split("/");

			strDay = strDateArray[0];
			strMonth = strDateArray[1];
			strYear = strDateArray[2];
			if(strDay==01||strDay==1)
			strDay="01"
			else
			if(strDay==02||strDay==2)
			strDay="02"

			else
			if(strDay==03||strDay==3)
			strDay="03"

			else
			if(strDay==04||strDay==4)
			strDay="04"

			else
			if(strDay==05||strDay==5)
			strDay="05"

			else
			if(strDay==06||strDay==6)
			strDay="06"

			else
			if(strDay==07||strDay==7)
			strDay="07"

			else
			if(strDay==08||strDay==8)
			strDay="08"

			else
			if(strDay==09||strDay==9)
			strDay="09"
				else{}

			if(strMonth==01||strMonth==1)
			strMonth="01"

			else
			if(strMonth==02||strMonth==2)
			strMonth="02"

			else
			if(strMonth==03||strMonth==3)
			strMonth="03"

			else
			if(strMonth==04||strMonth==4)
			strMonth="04"

			else
			if(strMonth==05||strMonth==5)
			strMonth="05"

			else
			if(strMonth==06||strMonth==6)
			strMonth="06"

			else
			if(strMonth==07||strMonth==7)
			strMonth="07"

			else
			if(strMonth==08||strMonth==8)
			strMonth="08"

			else
			if(strMonth==09||strMonth==9)
			strMonth="09"
			else{}

			frames[1].document.forms[0].census_date.value = strDay+'/'+strMonth + '/' + strYear
		}

		if((frames[1].document.forms[0].maternitymonth != null)&&(frames[1].document.forms[0].maternityyear != null))
		 {
		if((frames[1].document.forms[0].maternitymonth.value==""))
			 {
				var msg = getMessage("CAN_NOT_BE_BLANK",'Common');
				msg = msg.replace("$", getLabel("Common.month.label","Common"))
				alert(msg);
				frames[0].location.reload();
				frames[1].document.forms[0].maternitymonth.focus();
				 return false;

			 }
		if(frames[1].document.forms[0].maternityyear.value=="")
			 {
			var msg = getMessage("CAN_NOT_BE_BLANK",'Common');
			msg = msg.replace("$", getLabel("Common.year.label","Common"))
			alert(msg);
			frames[0].location.reload();
			frames[1].document.forms[0].maternityyear.focus();
			return false;
			 }


			var strMnth;

			strMnth = frames[1].document.forms[0].maternitymonth.value;

			if(strMnth==01||strMnth==1)
			strMnth="01"

			else
			if(strMnth==02||strMnth==2)
			strMnth="02"

			else
			if(strMnth==03||strMnth==3)
			strMnth="03"

			else
			if(strMnth==04||strMnth==4)
			strMnth="04"

			else
			if(strMnth==05||strMnth==5)
			strMnth="05"

			else
			if(strMnth==06||strMnth==6)
			strMnth="06"

			else
			if(strMnth==07||strMnth==7)
			strMnth="07"

			else
			if(strMnth==08||strMnth==8)
			strMnth="08"

			else
			if(strMnth==09||strMnth==9)
			strMnth="09"
			else{}

			frames[1].document.forms[0].maternity_month.value = strMnth;

		 }
	frames[1].document.forms[0].submit();
     }
}

function onSuccess() 
{
	frames[1].location.reload();
}

function reset() 
{
   frames[1].document.forms[0].reset();
}


function checkyear(obj)
{
	var len=obj.value.length;
	if((obj.value != ""))
	{
		if(len<4)
		{
			var msg = getMessage("INVALID_YR_FORMAT",'SM');
			alert(msg);
			obj.focus();
		return false;
		}
		else
		if((len==4)&&(obj.value == 0000))
		{
			var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO",'Common');
			alert(msg);
			obj.focus();
			return false;
		}
	}
}

function checkmonth(obj)
{
	var t1 =obj;
	if(obj.value != "")
	{
		if((obj.value>0) && (obj.value<=12))
		{
		return true;
		}
	else
		if(obj.value==0)
		{
			var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO",'Common');
			alert(msg);
			obj.focus();
			return false;
		}
	else
		if(obj.value>12)
		{
			var msg = getMessage("MONTH_IS_GR_12",'Common');
			alert(msg);
			obj.focus();
			return false;
		}
	}
}

function datefun(obj)
{
		var t1 = ChkDate(obj);		
		if(!t1)
			{
			//obj.value=""; 
			var msg = getMessage("INVALID_DATE_FMT",'SM');
			alert(msg);
			obj.focus();
			return;
			}
}
/*function onloadfun()
{
	document.getElementById("bar1").innerHTML="<td colspan='2' class='label'>&nbsp;</td>"
	
}*/

function chooseobj()
{

	if (document.forms[0].hmis_file_type.value == "PD301")
	{
		document.forms[0].filetype_flag.value="pd301";

		document.getElementById("bar1").style.backgroundColor = "navy";
		document.getElementById("bar1").style.Fontfamily = "verdana";
		document.getElementById("bar1").style.color = "#FFFFFF";
		document.getElementById("bar1").style.size = "10";

		document.getElementById("bar1").innerHTML="<th align='center' colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<B>"+getLabel("Common.daily.label","Common")+"&nbsp;"+getLabel("Common.Discharge.label","Common")+"</B></th>";
		document.getElementById("label2").innerText= getLabel("Common.dischargedate.label","Common");	 
		// document.getElementById("dateofbirth").value="";
		document.getElementById("obj2").innerHTML = "&nbsp;<input type='text' name='date_of_birth' id='date_of_birth' id='dateofbirth' maxlength='10' size='8' onkeypress='return Valid_DT(event);' onblur='datefun(this);'>&nbsp;<input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].date_of_birth.select();return showCalendar('dateofbirth')\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	}
	else
	if (document.forms[0].hmis_file_type.value == "PD103")
	{
	  document.getElementById("bar1").innerHTML="<th  align='left' colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<B>"+getLabel("Common.daily.label","Common")+"&nbsp;"+getLabel("eMR.InpatientCensus.label","MR")+"<B></th>";
	  document.forms[0].filetype_flag.value="pd103";

	document.getElementById("bar1").style.backgroundColor = "navy";
	document.getElementById("bar1").style.Fontfamily = "verdana";
	document.getElementById("bar1").style.color = "#FFFFFF";
	document.getElementById("bar1").style.size = "10";

	  document.getElementById("label2").innerText=getLabel("eIP.CensusDate.label","IP");	
	  document.getElementById("obj2").innerHTML = "&nbsp;<input type='text' name='date_of_birth2' id='date_of_birth2' id='dateofbirth2' maxlength='10' size='8' onkeypress='return Valid_DT(event)' onblur='datefun(this);'>&nbsp;<input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].date_of_birth2.select();return showCalendar('dateofbirth2')\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	
	  //document.getElementById("label1").innerText="Causes date";	 
	  // document.getElementById("dateofbirth").value="";
	}
	else
	if (document.forms[0].hmis_file_type.value == "PD205")
	{
	// document.getElementById("dateofbirth").value="";

	document.getElementById("bar1").style.backgroundColor = "navy";
	document.getElementById("bar1").style.Fontfamily = "verdana";
	document.getElementById("bar1").style.color = "#FFFFFF";
	document.getElementById("bar1").style.size = "10";

	document.getElementById("bar1").innerHTML="<th  align='left' colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<B>"+getLabel("eMR.MonthlyMaternityCensus.label","MR")+"</B></th>";
	document.forms[0].filetype_flag.value="pd205";
	document.getElementById("label2").innerText=getLabel("Common.month.label","Common");

	document.getElementById("obj2").innerHTML = "&nbsp;<input type='text' name='maternitymonth' id='maternitymonth' id='matmonth' maxlength='02' size='2' onkeypress='return Valid_DT2(event)' onblur='checkmonth(this);'>&nbsp;&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;"+getLabel("Common.year.label","Common")+"&nbsp;&nbsp;<input type='text' name='maternityyear' id='maternityyear' onkeypress='return Valid_DT2(event)' id='matyear' maxlength='04' size='4'  onblur='checkyear(this);'>&nbsp;&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	}
	else
	if (document.forms[0].hmis_file_type.value == "")
	{
		
		document.getElementById("bar1").innerHTML="&nbsp;";
		document.getElementById("bar1").style.backgroundColor = "#E2E3F0";

		document.forms[0].filetype_flag.value="";
		// document.getElementById("dateofbirth").value="";
		document.getElementById("label2").innerText="";
		document.getElementById("obj2").innerHTML = "&nbsp;"
	}
}

function Valid_DT(event)
	{
		var strCheck = '0123456789:/';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	} 

	function Valid_DT2(event)
	{
		var strCheck = '0123456789';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	} 


