/*Created by Thamizh selvi on 16th Nov 2016 against HSA-CRF-0213*/
function validatefromToWithCurrentDtAlert(obj,type) {
	
		var from = obj.value;
		var to   = document.forms[0].current_date.value;
        var fromarray = from.split("/");
		var toarray	  = to.split("/");
		var invaldt		 = getMessage("REMARKS_SHOULD_LS_EQUAL",'common') ;

		if (type=='M'){
			
			var fromdt = new Date(fromarray[1],fromarray[0]);
			var todt = new Date(toarray[1],toarray[0]);

			if (!isBeforeNow(obj.value,"MY",localeName)){

				if(Date.parse(todt) < Date.parse(fromdt)) {
					if (obj.name=='p_fm_Date')
						var dischge_date = (getLabel("Common.from.label","Common")+" "+getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.month.label","Common"));
					else
						var dischge_date = (getLabel("Common.to.label","Common")+" "+getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.month.label","Common"));
					var currentDate  = "Current month";	
					invaldt=invaldt.replace('$',dischge_date);
					invaldt=invaldt.replace('#',currentDate);
					alert(invaldt);
					obj.value='';
					obj.focus();
				}
			}
		}

		if (type=='D'){

			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);

			if(Date.parse(todt) < Date.parse(fromdt)) {
				if (obj.name=='p_fm_Date')
					var dischge_date = (getLabel("Common.from.label","Common")+" "+getLabel("Common.dischargedate.label","Common"));
				else
					var dischge_date = (getLabel("Common.to.label","Common")+" "+getLabel("Common.dischargedate.label","Common"));
				var currentDate  = "Current date";
				invaldt=invaldt.replace('$',dischge_date);
				invaldt=invaldt.replace('#',currentDate);
				alert(invaldt);
				obj.value='';
				obj.focus();
			}
		}

		if (type=='Y'){

			if(parseInt(toarray[2]) < fromarray) {
				if (obj.name=='p_fm_Date')
					var dischge_date = (getLabel("Common.from.label","Common")+" "+getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.year.label","Common"));
				else
					var dischge_date = (getLabel("Common.to.label","Common")+" "+getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.year.label","Common"));
				var currentDate  = "Current year";	
				invaldt=invaldt.replace('$',dischge_date);
				invaldt=invaldt.replace('#',currentDate);
				alert(invaldt);
				obj.value='';
				obj.focus();
			}	
		}

}

function datechange(){

	 if (document.getElementById("report_type").value=='M')
	 {
		 
		  document.getElementById("MY1").innerHTML=getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
		 
		 document.getElementById("MY1").innerHTML=getLabel("Common.Discharge.label","Common")+"&nbsp;"+getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='4' size='4' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
		 
		 document.getElementById("MY1").innerHTML=getLabel("Common.dischargedate.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('report_type').value);\" readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
	 }
}

function clearValues(){

	document.forms[0].p_from_termcode.value = '';
	document.forms[0].p_to_termcode.value = '';
	document.getElementById('p_from_chap').selectedIndex = 0;
	document.getElementById('p_to_chap').selectedIndex = 0;

}

function radioChange(){
	
	clearValues();
	if (document.getElementById('chapIcd1').checked) {
	  document.getElementById('p_chap_icd').value = 'Chapter';
	}
	else if (document.getElementById('chapIcd2').checked) {
	  document.getElementById('p_chap_icd').value = 'ICD10';
	}
	
	if(document.getElementById('p_chap_icd').value == 'Chapter')
	{
		if(document.getElementById('p_function_id').value == "LEADING_MORBIDITY_REPORT"){
			document.getElementById('p_report_id').value = 'MRMORBCHE';
		}
		else {
			document.getElementById('p_report_id').value = 'MRMORTCHE';
		}
		document.getElementById('ICD10').style.display = "none";
		document.getElementById('Chapter').style="display" 

	}
	else if (document.getElementById('p_chap_icd').value == 'ICD10')
	{
		if(document.getElementById('p_function_id').value == "LEADING_MORBIDITY_REPORT"){
			document.getElementById('p_report_id').value = 'MRMORBICD';
		}
		else {
			document.getElementById('p_report_id').value = 'MRMORTICD';
		}
		document.getElementById('ICD10').style="display";
		document.getElementById('Chapter').style.display = "none";
	}

}

function labelVisible(){

	if(document.getElementById('p_function_id').value == 'LEADING_MORBIDITY_REPORT'){
		document.getElementById('morb').style="display";
		document.getElementById('mort').style="display";
	}
	else{
		document.getElementById('mort').style="display";
		document.getElementById('morb').style.display = "none";
	}
}
async function ICD10Lookup(obj,target){
	     
    var retVal =    new String();
    var dialogHeight= "400px" ;
    var dialogWidth = "700px" ;
    var status = "no";
    var arguments   = "" ;
    var sql="";
    var search_code="";
    var search_desc="";
    var tit="";
	var term_set_id = "ICD10";
			
	if(obj.name == 'from_term_code' || obj.name == 'to_term_code'){
		tit=getLabel("Common.TermCode.label","Common");
		sql="select TERM_CODE, short_desc FROM MR_TERM_CODE_LANG_VW where term_set_id=`"+term_set_id+"` and language_id = `"+localeName+"` AND term_code != `*OTH` ";
		search_code="TERM_CODE"; 
        search_desc= "short_desc";
	}
	     
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
    retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
	if (!(retVal == null))
    {
		target.value=retVal;
    }
    else
		target.focus();
}

