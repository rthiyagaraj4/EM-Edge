function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/SickLeaveMain.jsp?step=1&call_from=MAIN" ;
}

function onSuccess() { 
	var PatientId = PatientSearch();
	frames[2].location.href='../eCommon/jsp/error.jsp?err_num=';
	if(PatientId !=null)
		frames[1].location.href= '../eMR/jsp/SickLeaveMain.jsp?step=2&call_from=MAIN1&PatientId='+PatientId;
	else
		window.location.href = "../eCommon/jsp/dmenu.jsp";
	
}

function reset() 
	{
		searchFrame.location.href ="../../eMR/jsp/SickLeaveMain1.jsp?step=2&call_from=MAIN";
		patientLine.location.href ='../../eCommon/html/blank.html';
		workAreaFrame.location.href='../../eCommon/html/blank.html';

}

function Clear_vals()
{
		//document.forms[0].reset();
		parent.searchFrame.location.href ="../../eMR/jsp/SickLeaveMain1.jsp?step=2&call_from=MAIN";
		parent.patientLine.location.href ='../../eCommon/html/blank.html';
		parent.workAreaFrame.location.href='../../eCommon/html/blank.html';
}

function query() {
	var PatientId = PatientSearch();
	frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
	if(PatientId !=null)
		frames[1].location.href= '../../eMR/jsp/SickLeaveMain.jsp?step=2&call_from=MAIN1&PatientId='+PatientId;
	else
		window.location.href = "../../eCommon/jsp/dmenu.jsp";

}

//JS functions in SickLeave Main.jsp

function onBlurCallPractitionerSearch(obj,target_name)
	{
		target_name.value = trimString(target_name.value);
 
		if(target_name.value == ""){
			document.forms[0].AuthorizedById.value="";
			 return;
		}

		callPractSearch(obj,target_name);
    }
	
function callPractSearch(obj,target)
 {
		var practName_FName="";
		var practName_FValue="";
		target.value=trimString(target.value);
		practName_FName=target.name;
		practName_FValue=target.value;
		var sql="";
		var sqlsec="";

		getPractitioner(obj, target,"","Q5");
			
		/*
		sql="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

		sqlsec="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";
	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practName_FName + "\"";
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
		xmlStr += " sql=\"" +escape(sql)+"\"";
		xmlStr += " sqlSec=\"" +escape(sqlsec)+"\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + "" + "\"";
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
				
	}
		
function PractLookupRetVal(retVal,objName)
  {							
		var arr;
		if (retVal != null && trimString(retVal) != ""){
			arr=retVal.split("~");
			document.forms[0].AuthorizedById.value=arr[0];
			document.forms[0].auth_by_name.value=arr[1];
		}
		else{
			document.forms[0].AuthorizedById.value="";
			document.forms[0].auth_by_name.value="";	
		}				
					
  }	

  function enablefit(obj){
		if (obj.checked==true){
			document.forms[0].FitonDuty.readOnly = false;
			document.getElementById("FitCal").disabled = false;
			if(obj.name=='CertIssued'){
			document.forms[0].IssuedDate.readOnly=false;
			document.getElementById("IssuedCal").disabled=false;
			}
			
			if(obj.name=='FitForDuty')
			{
				if(document.getElementById("LeaveTo").value != '')
				 {
					var call_from =document.forms[0].call_from.value;
					var finaldate1=nextdateCal(document.getElementById("LeaveTo"),call_from);
					document.forms[0].FitonDuty.value=finaldate1;
					document.forms[0].FitonDuty.focus();
				 }
			}
		}
		else{
			document.forms[0].FitonDuty.readOnly = true;
			document.forms[0].FitonDuty.value="";
			document.getElementById("FitCal").disabled = true;
			document.forms[0].IssuedDate.readOnly=true;
	       document.getElementById("IssuedCal").disabled=true;
		}
	}


	function checkMaxLen(obj){
		if (obj.value.length>500){
			var error = getMessage("REMARKS_CANNOT_EXCEED","common");
			if(obj.name != "employmentDetailsTextArea")
			{
			error = error.replace("$",getLabel("Common.remarks.label","common"));
			}
			else
			{
				error = error.replace("$",getLabel("Common.employmentdetails.label","common"));
			}
			error = error.replace("#","500");
			alert(error)
			obj.focus();
		}
	}


function Close_win()
{
		var call_from =document.forms[0].call_from.value;
		
		if(call_from=="MAIN1")
			parent.frames[1].location.href= '../../eMR/jsp/SickLeaveMain.jsp?step=2&call_from=MAIN';
		else
		{
			var sepPattern="~";
			var remarks = document.forms[0].Remarks.value;
			var IssuedDate = document.forms[0].IssuedDate.value;
			var FitonDuty= document.forms[0].FitonDuty.value;

			if(document.forms[0].employmentDetailsHidden.value=="")
				document.forms[0].employmentDetailsHidden.value="||";

			if(document.forms[0].noOfDays.value == "")
				document.forms[0].noOfDays.value="||";


			if(IssuedDate==""||IssuedDate==null)
				//IssuedDate.value="";
				IssuedDate="||";
				
			else
				IssuedDate = convertDate(IssuedDate,'DMY',localeName,'en');

			if (FitonDuty==""||FitonDuty==null)
				//FitonDuty.value = "";
				FitonDuty= "||";
			else
				FitonDuty = convertDate(FitonDuty,'DMY',localeName,'en');
			
			//var return_val =convertDate(document.forms[0].LeaveFrom.value,'DMY',localeName,'en')+sepPattern+convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en')+sepPattern+document.forms[0].FitForDuty.value+sepPattern+document.forms[0].CertIssued.value+sepPattern+document.forms[0].AuthorizedById.value+sepPattern+document.forms[0].certificate_type.value+sepPattern+ IssuedDate +sepPattern+remarks+sepPattern+FitonDuty+sepPattern+document.forms[0].auth_by_name.value+sepPattern+document.forms[0].mcNo.value+sepPattern+document.forms[0].employmentDetailsHidden.value+sepPattern+document.forms[0].noOfDays.value;

			//var return_val =convertDate(document.forms[0].LeaveFrom.value,'DMY',localeName,'en')+sepPattern+convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en')+sepPattern+document.forms[0].FitForDuty.value+sepPattern+document.forms[0].CertIssued.value+sepPattern+document.forms[0].AuthorizedById.value+sepPattern+document.forms[0].certificate_type.value+sepPattern+ IssuedDate +sepPattern+remarks+sepPattern+FitonDuty+sepPattern+document.forms[0].auth_by_name.value+sepPattern+document.forms[0].mcNo.value+sepPattern+document.forms[0].employmentDetailsHidden.value+sepPattern+document.forms[0].noOfDays.value;

			
			
			parent.window.returnValue = "";//return_val;
			parent.window.close();
		}		
}


function PopulateValues(obj)
 {
   if(obj.value=='O' || obj.value=='')
	 {
	   document.forms[0].employmentDetailsHidden.value="";
	   document.getElementById("enableDisable").style.visibility='hidden';
	   document.forms[0].IssuedDate.readOnly=true;
	   document.getElementById("IssuedCal").disabled=true;
	  document.forms[0].IssuedDate.value="";
	 }
	 else
	 {
      document.getElementById("enableDisable").style.visibility='visible';
	  if(document.forms[0].CertIssued.checked==true){
	  document.forms[0].IssuedDate.readOnly=false;
	  document.getElementById("IssuedCal").disabled=false;
	 }
   }
  }

// OnLoad this function used

function callSearch()
{	
    var	call_from = document.forms[0].call_from.value;
	if (call_from=="MAIN")
	{
		//parent.frames[1].location.href= '../../eMP/jsp/ModelPatientSearch.jsp';
		
		var PatientId = PatientSearch('','','','','','','','','','PAT_REG');
		if(PatientId !=null)
		{
			//parent.frames[1].location.href= '../../eMR/jsp/SickLeaveMain.jsp?step=2&call_from=MAIN1&PatientId='+PatientId;
			parent.frames[1].location.href= '../../eCA/jsp/OpenChartWrapper.jsp?from_module=MR&from_service_yn=Y&patient_id='+PatientId;	
		}
		else
		{
			parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
		}
	}
    else
	{
		//document.forms[0].FitonDuty.readOnly = false;
		//document.getElementById("FitCal").disabled = false;
		document.forms[0].record.value=getLabel("Common.ok.label","common");
		var SickLeaveDetails = document.forms[0].SickLeaveDetails.value;
		SickLeaveDetails=unescape(SickLeaveDetails);		
		if (SickLeaveDetails != "null" && SickLeaveDetails!="")
		{	
			var arr =new Array();
			arr=SickLeaveDetails.split("~");
			if (arr[1] !=null) document.forms[0].LeaveTo.value   = arr[1];
			if (arr[2] !=null) document.forms[0].FitForDuty.value = arr[2];
			if (arr[3] !=null) document.forms[0].CertIssued.value  = arr[3];
			if (arr[4] !=null) document.forms[0].AuthorizedById.value = arr[4];
			if (arr[5] !=null) document.forms[0].certificate_type.value=arr[5];
		
		    if(document.forms[0]){
				 if(document.forms[0].certificate_type.value == "M"){
					 document.forms[0].IssuedDate.readOnly=false;
			         document.getElementById("IssuedCal").disabled=false;
				}
				if(document.forms[0].certificate_type.value == "M")
					document.getElementById("enableDisable").style.visibility='visible';
				else
				    document.getElementById("enableDisable").style.visibility='hidden';
				}	   
				if (arr[6] !=null && arr[6] !="||") document.forms[0].IssuedDate.value=arr[6];
				if (arr[2]=="Y"){
					document.forms[0].FitForDuty.checked=true;
					document.forms[0].FitonDuty.readOnly=false;
					document.getElementById("FitCal").disabled = false;				
				}
				if (arr[3]=="Y") document.forms[0].CertIssued.checked=true;
				if (arr[7] !=null){
					if (arr[7]!="||")
						document.forms[0].Remarks.value = arr[7];               
				}
				if (arr[8] !=null){
					if (arr[8]!="||")
						document.forms[0].FitonDuty.value = arr[8];               
				}
				if (arr[9] !=null) document.forms[0].auth_by_name.value = arr[9];
			
				if(arr[10]!=null && arr[10]!="||") document.forms[0].mcNo.value=arr[10];
				if(arr[11]!=null && arr[11]!="||" && document.forms[0].employmentDetailsTextArea){
				document.forms[0].employmentDetailsHidden.value=arr[11];
			    document.forms[0].employmentDetailsTextArea.value=arr[11];
				}
				document.forms[0].noOfDays.value=arr[12];
			}			
		}
	}



function dispIssuedDate(obj)
 {
   var certificatetype=document.forms[0].certificate_type.value;
   
   if(obj.checked==true && certificatetype=="M")
	 {
	   document.forms[0].IssuedDate.readOnly=false;
	   document.getElementById("IssuedCal").disabled=false;
	 }
	else
	 {
      document.forms[0].IssuedDate.readOnly=true;
	  document.getElementById("IssuedCal").disabled=true;
	  document.forms[0].IssuedDate.value="";
	 }
 }

function calculateNoOfDays()
 {
		
		if(document.getElementById("LeaveFrom").value == null || document.getElementById("LeaveFrom").value == "" || document.getElementById("LeaveTo").value == null || document.getElementById("LeaveTo").value == "")
			return;

		//var from = document.getElementById("LeaveFrom").value;
		//var to   = document.getElementById("LeaveTo").value;
		var from = convertDate(document.getElementById("LeaveFrom").value,'DMY',localeName,'en');
		var to = convertDate(document.getElementById("LeaveTo").value,'DMY',localeName,'en');
		
			
		/*var a=  from.split(" ")
		splitdate=a[0];
        
		var d1=new Date(from);
		var splitdate1 =splitdate.split("/")
		var dateFrom  =new Date(splitdate1[2],splitdate1[1]-1,splitdate1[0])
		a=  to.split(" ")
    	splitdate=a[0];
		splitdate1 =splitdate.split("/")
     
		var dateTo  =new Date(splitdate1[2],splitdate1[1]-1,splitdate1[0])
		var toMilliSeconds=dateTo.getTime();
    	var fromMilliSeconds=dateFrom.getTime();*/

		var noOfDays = parseInt(daysBetween(from,to,'DMY','en')) + 1;
		//document.getElementById("noOfDays").value = Math.round((toMilliSeconds-fromMilliSeconds)/(24*60*60*1000))+1;
		document.getElementById("noOfDays").value = noOfDays;

		return;
	}

function checkDateTime(obj)
 {       
		//var sydate =document.forms[0].sydate;
		//var sydttime = document.forms[0].sydttime;
	var call_from = document.forms[0].call_from.value;
	
	var valid = true;
			
	if(obj.value !="")
		{
           	 if(call_from == "MAIN1")
			 {
					
					/*if(!CheckDate(obj))
					{
					obj.focus();									
					valid = false;
					}*/

					if(!validDateObj(obj,'DMY',localeName))
						valid = false;				 
			  }
			  else
			{
			 
			  		if(obj.name=="LeaveTo")
					{
						
						/*if(!doDateTimeChk(obj))
						{
							obj.focus();
							alert(getMessage("INVALID_DATE_TIME","SM"));					
							valid=false;
						}*/

						if(!validDateObj(obj,'DMY',localeName))
							valid = false;	
					}
					else
					{
						
						/*if(!CheckDate(obj))
						{
							obj.focus();									
							valid = false;
						}*/

						if(!validDateObj(obj,'DMY',localeName))
							valid = false;		
					}
				}

			if(valid == true)
				{			
					
					var greg_ComparedDate = convertDate(obj.value,'DMY',localeName,'en');
					
					if (obj.name=="LeaveTo")
					{	
					
						 var greg_FromDate = convertDate(document.forms[0].LeaveFrom.value,'DMY',localeName,'en');
					
						 if(call_from == "MAIN1")
						 {
								/*if(!doDateCheckAlert(LeaveFrom,obj)){
									obj.focus()
									var dateLessOrEqual = getMessage("LV_END_DATE_EQ_FROM_DATE","common");
									alert(dateLessOrEqual);
									valid = false;
								}*/
								if(isBefore(greg_ComparedDate,greg_FromDate,'DMY','en'))
								{
									obj.focus()
									var dateLessOrEqual = getMessage("LV_END_DATE_EQ_FROM_DATE","common");
									alert(dateLessOrEqual);
									valid = false;
								}
								if(document.forms[0].FitForDuty.checked == true)
								 {
									var finaldate1=nextdateCal(obj,call_from);
									document.forms[0].FitonDuty.value=finaldate1;
									document.forms[0].FitonDuty.focus();

								 }
						 }
						 else
						{
										 
							  /*if(!ValidateDateTime(LeaveFrom,obj))
								  {
									obj.focus()
									var dateLessOrEqual = getMessage("LV_END_DATE_TIME_GR_FROM_DATE_TIME","MP");	
									alert(dateLessOrEqual);
									valid = false;
								  }*/

								if(isBefore(greg_ComparedDate,greg_FromDate,'DMY','en'))
								  {
									obj.focus()
									var dateLessOrEqual = getMessage("LV_END_DATE_TIME_GR_FROM_DATE_TIME","OP");	
									alert(dateLessOrEqual);
									valid = false;
								  } 
								if(document.forms[0].FitForDuty.checked == true)
								 {
									var finaldate1=nextdateCal(obj,call_from);
									document.forms[0].FitonDuty.value=finaldate1;

									document.forms[0].FitonDuty.focus();

								 }
						}
					}
					else if (obj.name=="IssuedDate")
					{
						var call_from = document.forms[0].call_from.value;						
						var leaveFrom="";
						var leaveTo="";					 
						 if (call_from=="MAIN1")
						{
							 //leaveFrom= document.forms[0].LeaveFrom;
							 //leaveTo = document.forms[0].LeaveTo;
							 leaveFrom = convertDate(document.forms[0].LeaveFrom.value,'DMY',localeName,'en');
							 leaveTo = convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en');
						}
						else
						{
							//leaveFrom=document.forms[0].LeaveFrom1;
							//leaveTo = document.forms[0].LeaveTo1;
							leaveFrom=document.forms[0].LeaveFrom1.value;
							leaveTo = document.forms[0].LeaveTo1.value;
						}
					
						/*if(!doDateCheckAlert(obj,sydate)){
							obj.focus()			//ISSUE_DATE_GREATER					
							var error = getMessage("ISSUED_LESS_CURR_DATE","MP");
							alert(error);
							valid = false;
						}*/
						//ISSUE_DATE_GREATER	
						if(!isBeforeNow(greg_ComparedDate,'DMY','en'))
						{
							obj.focus()							
							var error = getMessage("ISSUED_LESS_CURR_DATE","MP");
							alert(error);
							valid = false;
						}
						
						/*if(!doDateCheckAlert(leaveFrom,obj)){
							obj.focus()			//LV_END_DATE_GR_FROM_DATE				
							var error = getMessage("ISSUED_DATE_GR_EQ_LEAVE_FROM_DATE","MP");	
							alert(error);							
							valid = false;
						}*/	
						//LV_END_DATE_GR_FROM_DATE		
						if(isBefore(greg_ComparedDate,leaveFrom,'DMY','en'))
						{
							obj.focus()					
							var error = getMessage("ISSUED_DATE_GR_EQ_LEAVE_FROM_DATE","MP");	
							alert(error);							
							valid = false;
						}
					}
					else if (obj.name=="FitonDuty")
					{
						var call_from = document.forms[0].call_from.value;
						if (call_from!="MAIN1")
						{
							//var dat=document.forms[0].LeaveTo.value;
							//document.forms[0].LeaveTo1.value=dat.substring(0,dat.length-6);
							//LeaveTo =document.forms[0].LeaveTo1;
							document.forms[0].LeaveTo1.value = convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en');
							LeaveTo = convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en');
						}
						else
						{
							//LeaveTo =document.forms[0].LeaveTo;
							LeaveTo = convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en');
						}
						/*if(!doDateCheckAlert1(LeaveTo,obj))
						{
							obj.focus();
							//var error = getMessage("RESUME_ACTIVITY_DATE_GR_EQ_LEAVE_TO_DATE");
							var error = getMessage("RESUME_ACTIVITY_GR_END_DATE","common");		
							alert(error);
							valid = false;
						}*/

						if(isBefore(greg_ComparedDate,LeaveTo,'DMY','en'))
						{
							obj.focus();
							//var error = getMessage("RESUME_ACTIVITY_DATE_GR_EQ_LEAVE_TO_DATE");
							var error = getMessage("RESUME_ACTIVITY_GR_END_DATE","common");		
							alert(error);
							valid = false;
						}
					}
					else
					{
							var greg_LeaveToDate = convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en');

							//var dob = document.forms[0].dob;
							/*if(!doDateCheckAlert(obj,sydate))
							{
								obj.focus()
								var error = getMessage("LV_DATE_EQ_CURR_DATE","common");
								error = error.replace("$",getLabel("Common.from.label","common") );
								alert(error);
								valid = false;
							}*/
							if(isAfterNow(greg_ComparedDate,'DMY','en'))
							{
								obj.focus()
								var error = getMessage("LV_DATE_EQ_CURR_DATE","common");
								error = error.replace("$",getLabel("Common.from.label","common") );
								alert(error);
								valid = false;
							}
							/*if(!doDateCheckAlert(dob,obj))
							{
								obj.focus()
								var error = getMessage("LV_DATE_LESS_DOB","common");
								error = error.replace("$",getLabel("Common.from.label","common") );
								alert(error);
								valid = false;
							}*/
							if(isBefore(greg_ComparedDate,document.forms[0].dob.value,'DMY','en'))
							{
								obj.focus()
								var error = getMessage("LV_DATE_LESS_DOB","common");
								error = error.replace("$",getLabel("Common.from.label","common") );
								alert(error);
								valid = false;
							}
							/*if(!doDateCheckAlert(obj,document.forms[0].LeaveTo))
							{
								obj.focus()
								alert(getMessage("LV_END_DATE_EQ_FROM_DATE","common"));
								valid = false;
							}*/
							if(isBefore(greg_LeaveToDate,greg_ComparedDate,'DMY','en'))
							{
								obj.focus()
								alert(getMessage("LV_END_DATE_EQ_FROM_DATE","common"));
								valid = false;
							}
					}
				}
		}		
		
		if(valid)
			calculateNoOfDays();
		else
		{
			obj.value = "";
			document.getElementById("noOfDays").value = "";
		}
}

// This functoin is used on Click of Apply/ Ok

function Record()
{
		var call_from = document.forms[0].call_from.value;
		var submit ="N";
		
		if(document.getElementById("employmentDetailsTextArea"))
		  document.getElementById("employmentDetailsHidden").value=document.getElementById("employmentDetailsTextArea").value;
       
	   if(document.getElementById("certificate_type").value=="O")
		   document.getElementById("employmentDetailsHidden").value="";
		
		if(call_from=="MAIN1"){  
			var values = new Array(document.forms[0].LeaveFrom,
            document.forms[0].LeaveTo,
           document.forms[0].AuthorizedById,
            document.forms[0].Remarks,
            document.forms[0].certificate_type,
			document.forms[0].mcNo);
			var fields = new Array(getLabel("Common.LeaveFrom.label","Common"),getLabel("Common.LeaveTo.label","Common"),getLabel("Common.authorizedby.label","Common"),getLabel("Common.remarks.label","Common"),getLabel("Common.certificatetype.label","Common"),getLabel("eMP.mcno.label","MP"));
			document.forms[0].target="messageFrame";
 		    if (checkFields(values,fields,parent.frames[2])){
				//if(!doDateCheckAlert(document.forms[0].LeaveFrom,document.forms[0].LeaveTo))
				var greg_FromDate = convertDate(document.forms[0].LeaveFrom.value,'DMY',localeName,'en');
				var greg_ToDate = convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en');
				if(isBefore(greg_ToDate,greg_FromDate,'DMY','en'))
				{
					var dateLessOrEqual = getMessage("LV_END_DATE_EQ_FROM_DATE","common");
					alert(dateLessOrEqual);
					document.forms[0].LeaveTo.focus()
				}					 
              	else
					submit ="Y";
			}

		}
		else{
			var temp="Y";
			if(document.forms[0].LeaveTo.value == ""){
				document.forms[0].LeaveTo.focus();
				var error = getMessage('CAN_NOT_BE_BLANK','common');
				error = error.replace('$',getLabel("Common.todate.label","common"));
				alert(error);
				temp ="N";
			}
			if(document.forms[0].AuthorizedById.value == ""){
				var error = getMessage('CAN_NOT_BE_BLANK','common');
				error = error.replace('$',getLabel("Common.authorizedby.label","common"));
				alert(error);
				temp ="N";
			}
			if(document.forms[0].Remarks.value == ""){
				var error = getMessage('CAN_NOT_BE_BLANK','common');
				error = error.replace('$',getLabel("Common.remarks.label","common"));
				alert(error);
				temp ="N";
			}
			if(document.forms[0].mcNo.value == ""){
				var error = getMessage('CAN_NOT_BE_BLANK','common');
				error = error.replace('$',getLabel("Common.medical.label","common")+getLabel("Common.certificate.label","common")+getLabel("Common.no.label","common"));
				alert(error);
				temp ="N";
			}
			if(document.forms[0].certificate_type.value==""){
				var error = getMessage('CAN_NOT_BE_BLANK','common');
				error = error.replace('$',getLabel("Common.certificatetype.label","common"));
				alert(error);
				temp ="N";
			}
			
			if(temp=="N")
				submit ="N";
			else
				submit ="Y";
		}
		if (submit=="Y"){
			if (document.forms[0].FitForDuty.checked == true)
				document.forms[0].FitForDuty.value = "Y";
			else
				document.forms[0].FitForDuty.value = "N";

			if (document.forms[0].CertIssued.checked == true)
				document.forms[0].CertIssued.value = "Y";
			else
				document.forms[0].CertIssued.value = "N";			
			
			if (call_from=="MAIN1")
				{
				var FitonDuty = document.forms[0].FitonDuty;
				
				if (FitonDuty.value!=""){
					//var LeaveTo = document.forms[0].LeaveTo;
					var greg_LeaveToDate = convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en');
					var greg_FitonDutyDate = convertDate(document.forms[0].FitonDuty.value,'DMY',localeName,'en');
					//if(!doDateCheckAlert(LeaveTo,FitonDuty))
					if(isBefore(greg_FitonDutyDate,greg_LeaveToDate,'DMY','en'))
					{
						var error = getMessage("RESUME_ACTIVITY_GR_END_DATE","common");		
						alert(error);						
						FitonDuty.focus()
					}		
					else
						document.forms[0].submit();
				}
				else
					document.forms[0].submit();
				

			}
			else{
				var remarks = document.forms[0].Remarks.value;
				if (remarks=="")
					remarks = "||";
				var IssuedDate=document.forms[0].IssuedDate;
				var FitonDuty = document.forms[0].FitonDuty;
				
				if (!(FitonDuty.value==""||FitonDuty.value==null))
					{
						  //var dat=document.forms[0].LeaveTo.value;
						  //document.forms[0].LeaveTo1.value=dat.substring(0,dat.length-6);
							//LeaveTo =document.forms[0].LeaveTo1;
						document.forms[0].LeaveTo1.value = convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en');
							
						var greg_LeaveToDate = convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en');
						var greg_FitonDutyDate = convertDate(document.forms[0].FitonDuty.value,'DMY',localeName,'en');
				
						//if(!doDateCheckAlert(LeaveTo,FitonDuty))
						if(isBefore(greg_FitonDutyDate,greg_LeaveToDate,'DMY','en'))
						{
							var error = getMessage("RESUME_ACTIVITY_GR_END_DATE","common");		
							alert(error);
							document.forms[0].FitonDuty.focus();
							document.forms[0].FitonDuty.select();
							submit="N";
						}								
					}							
				if(document.forms[0].mcNo.value=="")
					document.forms[0].mcNo.value="||";

				if(document.forms[0].employmentDetailsHidden.value=="")
					document.forms[0].employmentDetailsHidden.value="||";

				if(document.forms[0].noOfDays.value == "")
					document.forms[0].noOfDays.value="||";

				var sepPattern="~";   
				if (submit=="Y"){
					
					if(IssuedDate.value=="" ||IssuedDate.value==null)
					   //IssuedDate.value="";
						IssuedDate.value="||";
					else
						 IssuedDate.value= convertDate(document.forms[0].IssuedDate.value,'DMY',localeName,'en');

					if (FitonDuty.value=="" || FitonDuty.value==null)
						//FitonDuty.value = "";
						FitonDuty.value = "||";
					else
						FitonDuty.value= convertDate(document.forms[0].FitonDuty.value,'DMY',localeName,'en');

						
					var return_val =convertDate(document.forms[0].LeaveFrom.value,'DMY',localeName,'en')+sepPattern+convertDate(document.forms[0].LeaveTo.value,'DMY',localeName,'en')+sepPattern+document.forms[0].FitForDuty.value+sepPattern+document.forms[0].CertIssued.value+sepPattern+document.forms[0].AuthorizedById.value+sepPattern+document.forms[0].certificate_type.value+sepPattern+ IssuedDate.value +sepPattern+remarks+sepPattern+FitonDuty.value+sepPattern+document.forms[0].auth_by_name.value+sepPattern+document.forms[0].mcNo.value+sepPattern+document.forms[0].employmentDetailsHidden.value+sepPattern+document.forms[0].noOfDays.value;

					
					window.returnValue = return_val;
					window.close();
				}
			}
		}
	}
function doDateCheckAlert1(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) <= Date.parse(fromdt)) {
                return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
return true;
}

function nextdateCal(obj,callfrom)
{
 
 //var dat=obj.value;
 var dat = convertDate(obj.value,'DMY',localeName,'en');

/* if(callfrom != "MAIN1"){
 var leaveDate=dat.substring(0,dat.length-6);
 }else
 {
 var leaveDate=dat;
 }*/

 var finaldate1 = plusDate(dat,'DMY','en','1','d'); 
 /*var datearray=leaveDate.split("/");
 var day = parseInt(datearray[0],10);
 var month = parseInt(datearray[1],10);
 var year = parseInt(datearray[2],10);
 day=day+1;

	if(day<=28)
	{
	}
	else 
	{
		if(day == 30)
		{
			if(month == 2)
			{
				if(LeapYear(year))
				{
					day=1;
					month=3;
				}
				else
				{
					
				}
			}
		}else
		if(day == 29)
		{
			if(month == 2)
			{
				if(LeapYear(year))
				{
					
				}
				else
				{
					day=1;
					month=3;
				}
			}
		}
	    if((month == 4) || (month == 6) || (month == 9) || (month == 11))
		{
			if(day==31)
			{
				day=1;
				month++;
			}
		}
		else
		{
			if(day==32)
			{
				day=1;
				month++;
				if(month > 12){ month-=12;year++;}
			}
		}
	}
	var strday="";
	if(day < 10)
		strday="0"+day;
	else
		strday=day;
	var strmon="";
	if(month < 10)
		strmon="0"+month;
	else
		strmon=month;

	var finaldate1=strday+"/"+strmon+"/"+year;
	*/
		
	finaldate1 = convertDate(finaldate1,'DMY','en',localeName);

	return finaldate1;


}


async function callPatientSearch()
{
	var patient_id	=	document.forms[0].patient_id;
	var retun_value =	"";
	return_value	= await	PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}

async function callSearchScreen(){
	
		var encounter_id = document.forms[0].encounter_id.value;
		var patient_id = document.forms[0].patient_id.value;
		var call_from  = document.forms[0].call_from.value;
		if(patient_id == '')
		{
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.patientId.label","Common"));
			alert(error);
			document.forms[0].patient_id.focus();
		}	
		else
		{
		var retVal =    new String();
		var dialogHeight = "600px" ;
		var dialogWidth  = "900px" ;
		var dialogTop    = "55";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
		var arguments   = "" ;
		
		
		
		
		//retVal = window.open("../../eMR/jsp/MedRecRequestResult.jsp?&PatientId="+patient_id+"&call_from="+call_from,arguments,features);
		//return false;
		//alert('retVal '+retVal);
	

		retVal = await window.showModalDialog("../../eMR/jsp/MedicalCertificateIntermediateFrames.jsp?PatientId="+patient_id+"&call_from="+call_from,arguments+"&PatientId="+document.forms[0].patient_id.value,features);
		
		if(retVal != null) {
			//retVal = retVal.split("|");
			var ret1=unescape(retVal);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			document.forms[0].encounter_id.value = retVal;
		
			document.forms[0].encounter_id.focus();
		}
	}
}

function callNotifiableNotes()
{
	 var patient_id = document.forms[0].patient_id.value;
	var episode_id = document.forms[0].encounter_id.value;
	var facility_id =  document.forms[0].facility_id.value;
	var patient_class = "";
	var conVal="Y";
	if(episode_id == "")
		patient_class = "XT"


	if(document.forms[0].patient_id.value == '')
	{
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.patientId.label","Common"));
			alert(error);
			document.forms[0].patient_id.focus();
			return false;
	}	
	else
	{
	
	var error_jsp="";
	var messageFrame="";
			
	    var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='encounter_id' id='encounter_id' value='"+episode_id+"'><input type='hidden' name='patient_class' id='patient_class' value='"+patient_class+"'><input type='hidden' name='conVal' id='conVal' value='"+conVal+"'></form></BODY></HTML>";
	 
	    parent.messageFrame.document.write(HTMLVal);
	    parent.messageFrame.valid_form.submit();

	}
}


function PatValidations(obj)
{
	if(document.forms[0].patient_id.value!='')
	{
	    var fields = new Array (document.forms[0].patient_id); 
        var names = new Array (getLabel("Common.patientId.label","Common"));
		var patient_id = document.forms[0].patient_id.value;
		var error_jsp="";
		var messageFrame="";
			
	    var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='call_function' id='call_function' value='Medical_Certificate'></form></BODY></HTML>";
	 
	    parent.messageFrame.document.write(HTMLVal);
	    parent.messageFrame.valid_form.submit();
	}
	parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	parent.frames[3].document.location.href='../../eCommon/html/blank.html';
	document.forms[0].encounter_id.value="";

}

function PatEncounterValidations(obj)
{
	/*Tuesday, February 23, 2010 , 19576 to check patient_id before entering encounter_id*/
	if(document.forms[0].patient_id.value == '')
	{
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.patientId.label","Common"));
			alert(error);
			document.forms[0].encounter_id.value="";
			document.forms[0].patient_id.focus();
			return false;
	}	

	if(document.forms[0].encounter_id.value!='')
    {
	    var fields = new Array (document.forms[0].patient_id); 
        var names = new Array (getLabel("Common.patientId.label","Common"));
		var patient_id = document.forms[0].patient_id.value;
		var encounter_id = document.forms[0].encounter_id.value;
		var error_jsp="";
		var messageFrame="";
			
	    var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='encounter_id' id='encounter_id' value='"+encounter_id+"'></form></BODY></HTML>";
	 
	    parent.messageFrame.document.write(HTMLVal);
	    parent.messageFrame.valid_form.submit();
	}
	parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	parent.frames[3].document.location.href='../../eCommon/html/blank.html';

}

