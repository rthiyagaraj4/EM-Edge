//Created by Ashwini on 04-Oct-2017 for ML-MMOH-CRF-0763 and ML-MMOH-CRF-0764
async function callSearchScreen()
{
	var patientid=await PatientSearch('','','','','','','Y','','','OTHER');;
	if(patientid !=null)
	document.forms[0].PatientId.value = patientid;
	document.forms[0].PatientId.focus();		 
}

function validatePatientId(obj) 
{
	var patId = obj.value;
	if(parent.content !=null) {
		f = parent.content.frames[1];
	}else {
		f = parent.frames[1];
	}

	if(patId!=""){ 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatIdStatus' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		 var pat_status	= TrimStr(responseText);
		 var ErrorMessage	= ""; 
		 if ( pat_status=="INVALID_PATIENT"){
				 ErrorMessage	= getMessage('INVALID_PATIENT','MP');
			  }
		 if(ErrorMessage!=''){
			alert(ErrorMessage);
			obj.focus();
			obj.value='';
			parent.frames[2].location = "../../eCommon/html/blank.html";
		}
	}
}

function datechange(){

	 if (document.getElementById("recv_mrd").value=='M')
	 {
		  document.getElementById("date_label").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;";
		  document.getElementById("from_date").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('recv_mrd').value);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		  document.getElementById("to_date").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('recv_mrd').value);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
	 }
	 else  if (document.getElementById("recv_mrd").value=='Y')
	 {
		 document.getElementById("date_label").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;";
		 document.getElementById("from_date").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('recv_mrd').value);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("to_date").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('recv_mrd').value);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 
	 }
	  else  if (document.getElementById("recv_mrd").value=='D')
	 {
		 document.getElementById("date_label").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;";
		 document.getElementById("from_date").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('recv_mrd').value);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("to_date").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='10' size='10' onblur=\"validatefromToWithCurrentDtAlert(this,document.getElementById('recv_mrd').value);\" readonly><img type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\"></img>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
	 }
}

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

		if (type=='D'){

			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			
			if(obj.value!="")
			{
			if(!isBeforeNow(obj.value,"DMY",localeName)) {
				if (obj.name=='p_fm_Date')
					var dischge_date = (getLabel("Common.from.label","Common")+" "+getLabel("Common.date.label","Common"));
				else
					var dischge_date = (getLabel("Common.to.label","Common")+" "+getLabel("Common.date.label","Common"));
				var currentDate  = (getLabel("Common.CurrentDate.label","Common"));
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
}

function doDateCheckAlertLocal(str,from,to,messageFrame){
	    var fromdate = from.value ;
		var todate = to.value ;
		var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
		var greg_toDate = convertDate(todate,"DMY",localeName,"en");
		if(from.value!=""&&to.value!=""){
		if(isBefore(greg_fromDate,greg_toDate,"DMY","en"))
		{
			
			return true;
		}
		else 
		{
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
			
			error=error.replace("$",getLabel("Common.to.label","Common")+" "+str);
			error=error.replace("#",str);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
			return false;
		}
		}
		return true;
}

function ReqIdNumCheck(event)
{
	var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function searchResult()
{
	var recvMrd				= document.forms[0].recv_mrd.value ;
	var from				= document.forms[0].p_fm_Date.value ;
	var to					= document.forms[0].p_to_Date.value ;
	var reqId				= document.forms[0].req_id.value;
	var patientid		    = document.forms[0].PatientId.value;
	var function_id		    = document.forms[0].function_id.value;

	var fields  = new Array(document.forms[0].p_fm_Date,document.forms[0].p_to_Date);

		if(recvMrd=="M")
		{	
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.month.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.month.label","Common"));
		}
		else if(recvMrd=="Y")
		{
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.year.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common"));
		}
		else
		{
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.date.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.date.label","Common"));	
		}

		if(recvMrd=="M")
		{ 		  
			var names1  = new Array (getLabel("Common.month.label","Common"));
			if(checkFields( fields, names, parent.frames[3]))
			{
				if(checkmonths( names1,document.forms[0].p_fm_Date, document.forms[0].p_to_Date, parent.frames[3] ) )
				{
					parent.frames[2].document.location.href='../../eMR/jsp/NoticeofCompRepNotificResult.jsp?recvMrd='+recvMrd+'&from='+from+'&to='+to+'&reqId='+reqId+'&patientid='+patientid+'&function_id='+function_id;	
					parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
				}
			}	
		}
		else if(recvMrd=="Y")
		{  
			var names1  = new Array (getLabel("Common.year.label","Common"));
			if(checkFields( fields, names, parent.frames[3]))
			{
				if(CheckString( names1,document.forms[0].p_fm_Date, document.forms[0].p_to_Date, parent.frames[3] ) )
				{
					parent.frames[2].document.location.href='../../eMR/jsp/NoticeofCompRepNotificResult.jsp?recvMrd='+recvMrd+'&from='+from+'&to='+to+'&reqId='+reqId+'&patientid='+patientid+'&function_id='+function_id;	
					parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
				}
			}
		}
		else
		{  
			if(checkFields( fields, names, parent.frames[3]))
			{
				if( doDateCheckAlertLocal( getLabel("Common.date.label","Common"),document.forms[0].p_fm_Date, document.forms[0].p_to_Date, parent.frames[3] ) )
				{
					parent.frames[2].document.location.href='../../eMR/jsp/NoticeofCompRepNotificResult.jsp?recvMrd='+recvMrd+'&from='+from+'&to='+to+'&reqId='+reqId+'&patientid='+patientid+'&function_id='+function_id;	
					parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
				}
			}
		}							
}

function fnSetvalue(type)
{
	if(type=="P"){
		document.forms[0].isPrevClicked.value="Y";
	}else if(type=="N"){
		document.forms[0].isNextClicked.value="Y";
	}
}

function showReport(request_id, pat_id,amt) 
{
	var report_id = document.forms[0].p_report_id.value;
	
	if(report_id == "MRRDUBLP")
	{
		document.forms[0].p_request_id.value = request_id;
	}else
	{
		document.forms[0].p_req_id.value = request_id;
	}
	/*Added By Dharma on 17th Dec 2019 against ML-MMOH-CRF-1368 Start*/
	var p_function_id	= document.forms[0].p_function_id.value;
	if(p_function_id=="PREPARE_MEDICAL_REPORT"){
		var totAmt	= parseInt(amt);
		if(totAmt > 40){
			document.forms[0].p_report_id.value = "MRBOBBDO";   
		}else{
			document.forms[0].p_report_id.value = "MRBOBBDO1";
		}
	}
	
	/*Added By Dharma on 17th Dec 2019 against ML-MMOH-CRF-1368 End*/
	
	document.forms[0].p_patient_id.value = pat_id;
	document.forms[0].method="GET";
	document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	document.forms[0].submit();
}

//End ML-MMOH-CRF-0763 and ML-MMOH-CRF-0764



