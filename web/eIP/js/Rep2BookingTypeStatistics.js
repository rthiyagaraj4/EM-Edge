function reset()
{	
	f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.document.getElementById("label").innerHTML = getLabel('Common.BookingDate.label','common');
	f_query_add_mod.document.getElementById("dtfrm").innerHTML = "<td align='left' width='25%' id = 'fr_bkg_date'><input type='text' id='bkgndatefrom'  name='p_fr_bkg_date' id='p_fr_bkg_date' size='10' maxlength='10' onblur=\"validDateObj(this,'DMY',localeName);\"><img src='../../eCommon/images/CommonCalendar.gif'  id = 'fromdatecal'  onClick=\"return showCalendar('bkgndatefrom', 'dd/mm/yyyy', null);\" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif' id = 'fromman'></img></td>";
	f_query_add_mod.document.getElementById("dtto").innerHTML = "<td align='left' width='25%' id = 'to_bkg_date'><input type='text' id='bkgndateto' name='p_to_bkg_date' id='p_to_bkg_date' size='10' maxlength='10' onblur=\"DateCompare(bkgndatefrom,'DMY',this);\" id = 'todatecal'><img src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('bkgndateto', 'dd/mm/yyyy', null);\" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif' id = 'toman'></img></td>";
}

function run()
{
	var report_type = f_query_add_mod.document.RepBookingTypeStatistics.p_report_type.value;
	var from_date   = "";
	var to_date     = "";
	var fields      = "";
	var names       = "";
	if (report_type == 'D')
	{
		from_date   = f_query_add_mod.document.RepBookingTypeStatistics.bkgndatefrom
		to_date     = f_query_add_mod.document.RepBookingTypeStatistics.bkgndateto

		fields      = new Array(from_date,to_date);
		names       = new Array(getLabel('Common.date.label','Common')+"/"+getLabel('Common.month.label','Common')+"/"+getLabel('Common.year.label','Common')+" "+getLabel('Common.from.label','Common'),getLabel('Common.date.label','Common')+"/"+getLabel('Common.month.label','Common')+"/"+getLabel('Common.year.label','Common')+" "+getLabel('Common.to.label','Common'));

			
	}else if (report_type == 'M')
	{
		from_date   = f_query_add_mod.document.RepBookingTypeStatistics.bkgnmonthfrom
		to_date     = f_query_add_mod.document.RepBookingTypeStatistics.bkgnmonthto
		fields      = new Array(from_date,to_date);
		names       = new Array(getLabel('Common.month.label','Common')+"/"+getLabel('Common.year.label','Common')+" "+getLabel('Common.from.label','Common'),getLabel('Common.month.label','Common')+"/"+getLabel('Common.year.label','Common')+" "+getLabel('Common.to.label','Common'));
	}
	else if (report_type == 'Y')
	{
		from_date   = f_query_add_mod.document.RepBookingTypeStatistics.bkgnyearlyfrom
		to_date     = f_query_add_mod.document.RepBookingTypeStatistics.bkgnyearlyto
		fields      =  new Array(from_date,to_date);
		names       = new Array(getLabel('Common.year.label','Common')+" "+getLabel('Common.from.label','Common'),getLabel('Common.year.label','Common')+" "+getLabel('Common.to.label','Common'));
		
	}
   
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.RepBookingTypeStatistics.submit() ;
	}
}
function hiddendiv()
{
	document.getElementById("monthly").style.visibility    = "hidden";
		document.getElementById("yearly").style.visibility = 'hidden';

}
function changeBookingDate()
{
	var localeName = document.forms[0].locale.value;
	var report_type = document.forms[0].p_report_type.value;
	var p_fr_bkg_date = document.forms[0].p_fr_bkg_date;
	if(report_type == 'D')
	{
		document.getElementById("label").innerHTML=getLabel('Common.BookingDate.label','common');
		document.getElementById("dtfrm").innerHTML="<td align='left' width='25%' id = 'fr_bkg_date'><input type='text' id='bkgndatefrom'  name='p_fr_bkg_date' id='p_fr_bkg_date' size='10' maxlength='10' onblur=\"validDateObj(this,'DMY',localeName);DateCompare(this,'DMY',bkgndateto);\"><img src='../../eCommon/images/CommonCalendar.gif'  id = 'fromdatecal'  onClick=\"return showCalendar('bkgndatefrom', 'dd/mm/yyyy', null);\" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif' id = 'fromman'></img></td>";
		document.getElementById("dtto").innerHTML="<td align='left' width='25%' id = 'to_bkg_date'><input type='text' id='bkgndateto' name='p_to_bkg_date' id='p_to_bkg_date' size='10' maxlength='10' onblur=\"DateCompare(bkgndatefrom,'DMY',this);\" id = 'todatecal'><img src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('bkgndateto', 'dd/mm/yyyy', null);\" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif' id = 'toman'></img></td>";
	}
	else if(report_type == 'M')
	{
		
		document.getElementById("label").innerHTML=getLabel('Common.booking.label','common')+" "+getLabel('Common.month.label','common');
		document.getElementById("dtfrm").innerHTML="<td align='left' width='25%' ><input type='text' id='bkgnmonthfrom'  name='p_fr_bkg_date' id='p_fr_bkg_date' size='7' maxlength='7' onblur=\"validDateObj(this,'MY',localeName);DateCompare(this,'MY',bkgnmonthto);\"><img src='../../eCommon/images/CommonCalendar.gif'    onClick=\"return showCalendar('bkgnmonthfrom', 'mm/y', null);\" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif' ></img></td>";
		document.getElementById("dtto").innerHTML ="<td align='left' width='25%' ><input type='text' id='bkgnmonthto' name='p_to_bkg_date' id='p_to_bkg_date' size='7' maxlength='7' onblur=\"DateCompare(bkgnmonthfrom,'MY',this);\" ><img src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('bkgnmonthto', 'mm/y', null);\" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif' ></img></td>";
		
	}
	else if(report_type == 'Y')
	{
		
		document.getElementById("label").innerHTML=getLabel('Common.booking.label','common')+" "+getLabel('Common.year.label','common');
		document.getElementById("dtfrm").innerHTML="<td align='left' width='25%' ><input type='text' id='bkgnyearlyfrom'  name='p_fr_bkg_date' id='p_fr_bkg_date' size='4' maxlength='4' onblur=\"validDateObj(this,'YY',localeName);DateCompare(this,'YY',bkgnyearlyto);\"><img src='../../eCommon/images/CommonCalendar.gif'  id = 'fromyearlycal'  onClick=\"return showCalendar('bkgnyearlyfrom', 'y', null);\" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif' ></img></td>";
		document.getElementById("dtto").innerHTML ="<td align='left' width='25%' id = 'to_bkg_date'><input type='text' id='bkgnyearlyto' name='p_to_bkg_date' id='p_to_bkg_date' size='4' maxlength='4' onblur=\"DateCompare(bkgnyearlyfrom,'YY',this);\" ><img src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('bkgnyearlyto', 'y', null);\" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif' id = 'toman'></img></td>";
	}

}

function validDate(date, format, locale){
	var dateFlag=true;
	var dateArr;
	var dateArr1;
	if(format=="YY"){
		if(date==0000){
			dateFlag=false;
		}
	}

	if(dateFlag){
		var xhr =  getXHR();
		var url = "../../eCommon/jsp/DateUtils.jsp?methodName=validDate&format="+format+"&locale="+locale+"&date="+date;
		xhr.open("POST", url, false);
		xhr.setRequestHeader("Content-Type","text/plain")
		xhr.send("");
		var xmlText = xhr.responseText
		if (TrimStr(xmlText) == "true"){
			dateFlag=true;
		}else{
			dateFlag=false;
		}
	}
	return dateFlag;
}

function DateCompare(from,format,to) 
{
	var fromdate = from.value ;
	var todate = to.value ;

	var flg2 = validDateObj(to,format,localeName);
	if(flg2 && fromdate != '')
	{
		var greg_fromdate = convertDate(from.value,format,localeName,"en");
		var greg_todate = convertDate(to.value,format,localeName,"en");
		
		if(!isBefore(greg_fromdate,greg_todate,format,'en'))
		{
			if(format == 'DMY')
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				//to.select();
				//to.focus();
				to.value = "";
				return false;
			}
			else if(format == 'MY')
			{
				var msg = getMessage("REMARKS_MUST_GR_EQUAL","COMMON");
				var replace1 = getLabel('Common.to.label','common')+" "+getLabel('Common.month.label','common');
				var replace2 = getLabel('Common.month.label','common');
				msg=msg.replace('$',replace1);
				msg=msg.replace('#',replace2);
				alert(msg);
				//to.select();
				//to.focus();
				to.value = "";
				return false;
			}
			else if(format == 'YY')
			{
				var msg = getMessage("REMARKS_MUST_GR_EQUAL","COMMON");
				var replace1 = getLabel('Common.to.label','common')+" "+getLabel('Common.year.label','common');
				var replace2 = getLabel('Common.year.label','common');
				msg=msg.replace('$',replace1);
				msg=msg.replace('#',replace2);
				alert(msg);
				//to.select();
				//to.focus();
				to.value = "";
				return false;
			}
			
		}	
	}
	return true;
}

function validDate(date, format, locale){
	var dateFlag=true;
	var dateArr;
	var dateArr1;
	if(format=="DMY"){
		dateArr=date.split("/");
		if(dateArr[2]==0){
			dateFlag=false;
		}
	}else if(format=="DMYHM"){
		dateArr1=date.split(" ");
		dateArr=(dateArr1[0]).split("/");
		if(dateArr[2]==0){
			dateFlag=false;
		}
	}else if(format=="YY"){
		if(date==0){
			dateFlag=false;
		}
	}else if(format=="MY"){
		dateArr=date.split("/");
		if(dateArr[1]==0){
			dateFlag=false;
		}
	}
	if(dateFlag){
		var xhr =  getXHR();
		var url = "../../eCommon/jsp/DateUtils.jsp?methodName=validDate&format="+format+"&locale="+locale+"&date="+date;
		xhr.open("POST", url, false);
		xhr.setRequestHeader("Content-Type","text/plain")
		xhr.send("");
		var xmlText = xhr.responseText
		if (TrimStr(xmlText) == "true"){
			dateFlag=true;
		}else{
			dateFlag=false;
		}
	}
	return dateFlag;
}

function validDateObj(date, format, locale){
	if(date.value != ''){
		var dateValue=date.value;
		var dateArray="";
		var dateArray1;
		var checkFlag=true;
		if(format=="DMY"){
			dateArray=dateValue.split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="DMYHM"){
			dateArray1=dateValue.split(" ");
			dateArray=(dateArray1[0]).split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="YY"){
			if(date==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="MY"){
			dateArray=dateValue.split("/");
			if(dateArray[1]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}	
		if(checkFlag){
			if(!validDate(date.value,format,locale)){
				if(top.header != null){
					alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
				}else{
					alert(getMessage("INVALID_DATE_FMT", "SM"));
				}
				//date.select();
				//date.focus();
				date.value = "";
				return false;
			}else{
				return true;
			}
		}else{
			var msg=getMessage("INVALID_VALUE", "COMMON");
			alert(msg.replace('#',getLabel("Common.date.label","Common")));
			//date.select();
			//date.focus();
			date.value = "";
			return false;
		}
	}
}

