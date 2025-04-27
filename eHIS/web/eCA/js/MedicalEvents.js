function reset()
{
	frames[1].frames[2].document.forms[0].reset();
}

function onSuccess()
{
	//top.secondframe.thirdframe.MedicalEventsResultFrame.location.reload();
	//top.secondframe.thirdframe.MedicalEventsDtlFrame.document.location.href="../../eCA/jsp/MedicalEventsDetail.jsp";
}

function apply()
{	
	
	if (document.forms[0].event_details.value.length > 2000)
	{
		var error = getMessage("OBJ_CANNOT_EXCEED",'Common');
		error = error.replace("$","2000");
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" +  error ;
		return false;
	}
	
	if (document.forms[0].event_confirmed_flag.checked== true)
		document.forms[0].confirmed.value='Y';
	else
		document.forms[0].confirmed.value='N';

	var fields = new Array (
	document.forms[0].med_event_type_code,
	document.forms[0].event_sdate,
	document.forms[0].event_details

	);
	
	var names = new Array ( 
	getLabel("eCA.MedicalEventType.label",'CA'),
	getLabel("eCA.EventStartDate.label",'CA'),
	getLabel("eCA.EventDetails.label",'CA')
	);

	if(checkFieldsofMst( fields, names, top.content.messageFrame)) 
	{
		if(doDateChecknew(document.forms[0].event_sdate,document.forms[0].event_edate,top.content.messageFrame))
		{
			document.forms[0].target = 'messageFrame';
			document.forms[0].action = '../../servlet/eCA.MajorMedicalEventsServlet';
			document.forms[0].submit();
		}
	}
}

function aa()
{
	top.secondframe.thirdframe.MedicalEventsResultFrame.location.reload();
}

function doDateChecknew(from,to,messageFrame) 
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			var message=getMessage("TO_DT_GR_EQ_FM_DT",'CA');
			messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+message;		
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
	return true;
}

function clearme()
{
	var patient_id	=	document.forms[0].patient_id.value;
	top.content.workAreaFrame.MedicalEventsDtlFrame.location.href='../../eCA/jsp/MedicalEventsDetail.jsp?patient_id='+patient_id;
	top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
}

function cancelOperation()
{
	top.content.workAreaFrame.document.location.href='../../eCommon/html/blank.html';
}


function DateValidation(obj)
{
	curdate = document.forms[0].sys_date;
	var msg = getMessage("FROM_DATE_GREATER_SYSDATE",'Common');
	if(doDateCheckAlert(curdate,obj) == false	 ) 
	{
		obj.focus();
		obj.select();
		alert(msg);
	}
}

function CheckStartDate(obj)
{
	if(obj.value.length>0)
	CheckDate(obj); // checks for valid date
	if(!doDateCheck1(document.forms[0].dob,obj))
	{
		var msg=getMessage("EVENT_START_GREATER_DOB",'CA');
		alert(msg);
		//obj.select();
		obj.value='';
		obj.focus();
	}
	if(!doDateCheck1(obj,document.forms[0].sys_date))
	{
		var msg=getMessage("EVENT_START_LESS_SYSDATE",'CA');
		alert(msg);
		//obj.select();
		obj.value='';
		obj.focus();
	}
}

function CheckEndDate(obj)
{
	if(obj.value.length>0)
	{
		CheckDate(obj);
		if(!doDateCheck1(document.forms[0].event_sdate,obj))
		{
			alert( getMessage("EVENT_END_DATE_VALID",'CA') );
			//obj.select();
			obj.value="";
			obj.focus();					
		}

		if(!doDateCheck1(obj,document.forms[0].sys_date))
		{
			var msg=getMessage("DATE_TIME_GREATER_SYSDATE",'CA');
			alert(msg);
			//obj.select();
			obj.value="";
			obj.focus();
		}
	}
}

function doDateCheck1(from,to,messageframe,val) 
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			if(val=="1")  
			{
				alert( getMessage("FROM_DATE_GREAT_EFF",'CA'));
				to.select();
				to.focus();
			}
			else if(val=="2") 
			{
				alert( getMessage("TO_DATE_LESS_EFF_DATE",'CA'));
				from.select();
				from.focus();
			}
			else if(val=="3")
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT",'CA') );
				to.select();
				to.focus();
			}
			else if(val=="4")
			{
				alert( getMessage("FROM_DATE_GREAT_SYS",'CA') );
				to.select();
				to.focus();
			}
			else if(val=="5")
			{
				alert( getMessage("END_DATE_VALIDATION",'CA') );
				to.select();
				to.focus();
			}
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
	return true;
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

	function scrollTitle(){
	  var y = parent.MedicalEventsResultFrame.document.body.scrollTop;

	  if(y == 0){
		parent.MedicalEventsResultFrame.document.getElementById("divDataTitle").style.position = 'static';
		parent.MedicalEventsResultFrame.document.getElementById("divDataTitle").style.posTop  = 0;
	  }else{
		parent.MedicalEventsResultFrame.document.getElementById("divDataTitle").style.position = 'relative';
		parent.MedicalEventsResultFrame.document.getElementById("divDataTitle").style.posTop  = y-2;
	  }

	}
	function alignWidth(){
		var totalRows =  parent.MedicalEventsResultFrame.document.getElementById("dataTable").rows.length;
		var counter = totalRows-1;
		var temp = parent.MedicalEventsResultFrame.document.getElementById("dataTitleTable").rows[0].cells.length;
		for(var i=0;i<temp;i++) {
			parent.MedicalEventsResultFrame.document.getElementById("dataTitleTable").rows[0].cells[i].width=parent.MedicalEventsResultFrame.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
			
		}
	}
