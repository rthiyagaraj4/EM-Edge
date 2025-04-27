/*Created by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292*/
function validatefromToWithCurrentDtAlert(obj,type) { 
	
		var from = obj.value;
		var to   = document.forms[0].current_date.value;
        var fromarray = from.split("/");
		var toarray	  = to.split("/");
		var invaldt	  = getMessage("REMARKS_SHOULD_LS_EQUAL",'common') ;

		if (type=='M'){
			
			var fromdt = new Date(fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[1]-1,toarray[0]);

			if (!isBeforeNow(obj.value,"MY",localeName)){

				if(Date.parse(todt) < Date.parse(fromdt)) {
					if (obj.name=='p_fm_Date')
						var dischge_date = (getLabel("Common.from.label","Common")+" "+getLabel("Common.month.label","Common"));
					else
						var dischge_date = (getLabel("Common.to.label","Common")+" "+getLabel("Common.month.label","Common"));
						var currentDate  = (getLabel("Common.current.label","Common")+" "+getLabel("Common.month.label","Common"));
					invaldt=invaldt.replace('$',dischge_date);
					invaldt=invaldt.replace(' #',currentDate);
					alert(invaldt);
					obj.value='';
					obj.focus();
				}
			}
		}

		if (type=='Y'){

			if(parseInt(toarray[2]) < fromarray) {
				if (obj.name=='p_fm_Date')
					var dischge_date = (getLabel("Common.from.label","Common")+" "+getLabel("Common.year.label","Common"));
				else
					var dischge_date = (getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common"));
					var currentDate  = (getLabel("Common.CurrentYear.label","Common"));	
				invaldt=invaldt.replace('$',dischge_date);
				invaldt=invaldt.replace(' #',currentDate);
				alert(invaldt);
				obj.value='';
				obj.focus();
			}	
		}
		/*Added By Dharma on 28th Jan 2021 against ML-MMOH-CRF-1593 Start */
		if (type=='6' || type=='12'){

			if(parseInt(toarray[2]) < fromarray) {
				
				var dischge_date = getLabel("Common.year.label","Common");
				var currentDate  = (getLabel("Common.CurrentYear.label","Common"));	
				invaldt=invaldt.replace('$',dischge_date);
				invaldt=invaldt.replace(' #',currentDate);
				alert(invaldt);
				obj.value='';
				obj.focus();
			}	
		}
		/*Added By Dharma on 28th Jan 2021 against ML-MMOH-CRF-1593 End */
}

function datechange(){
	document.getElementById("p_report_id").value	= "MRNIAREP";
	 if (document.getElementById("report_type").value=='M')
	 {
		 document.getElementById("trFrmTo").style.visibility	= 'visible'; 
		 document.getElementById("MY_label").innerHTML= getLabel("Common.month.label","Common")+"&nbsp;";
		  document.getElementById("MY_frm").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' maxlength='7' size='7' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);calculatePreviousMonthYear(this,document.getElementById('report_type').value,1);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		  document.getElementById("MY_to").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='7' size='7' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);calculatePreviousMonthYear(this,document.getElementById('report_type').value,2);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
		 document.getElementById("trFrmTo").style.visibility	= 'visible';
		 document.getElementById("MY_label").innerHTML= getLabel("Common.year.label","Common")+"&nbsp;";
		 document.getElementById("MY_frm").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);calculatePreviousMonthYear(this,document.getElementById('report_type').value,1);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("MY_to").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='4' size='4' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);calculatePreviousMonthYear(this,document.getElementById('report_type').value,2);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ; 
	 }
	 /*Added By Dharma on 28th Jan 2021 against ML-MMOH-CRF-1593 Start */
	 else  if (document.getElementById("report_type").value=='6' || document.getElementById("report_type").value=='12')
	 {
		 document.getElementById("trFrmTo").style.visibility	= 'hidden';
		 document.getElementById("MY_label").innerHTML= getLabel("Common.year.label","Common")+"&nbsp;";
		 document.getElementById("MY_frm").innerHTML = "<input type='text' name='p_year' id='p_year' maxlength='4' size='4' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);calculatePreviousMonthYear(this,document.getElementById('report_type').value,3);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_year.select();return showCalendar('p_year','y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("MY_to").innerHTML = "" ; 
		 document.getElementById("p_report_id").value	= "MRNIAREPY";
	 }
	 /*Added By Dharma on 28th Jan 2021 against ML-MMOH-CRF-1593 End */
}

function calculatePreviousMonthYear(obj,type,fromTo)
{
	var date_my = obj.value;
	if(type =='6' || type =='12'){
		type	= "Y";
	}
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH type=\""+type+"\" date_my=\""+date_my+"\" action='previousMonthYear' /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../jsp/MRIntermediate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	//var previous_my = trimString(responseText);
	var previous_my = responseText.replace(/<!DOCTYPE html>/,"").trim();

	if (fromTo == '1'){
		document.getElementById("p_from_date_cn").value = previous_my;
	}else if (fromTo == '2'){
		document.getElementById("p_to_date_cn").value = previous_my;
	}else if (fromTo == '3'){
		document.getElementById("p_year_cn").value = previous_my;
	}
}

