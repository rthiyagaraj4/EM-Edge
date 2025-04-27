
function ChkNumberInput1(fld, e, deci)
{
	if (	parseInt(deci)>0)
		var strCheck = '.0123456789 /:';
	else
   var strCheck = '0123456789 /:';
	
   var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

}

function ValidateDischargeDate(from,to,val)
{

	from = from.value;
	to   = to.value;
	var  maxhrs = 0;
	var  maxdays	= 0;
	var mon = 0;
	if(val == 'A')
	maxdays = self.document.expecteddischarge_form.disdatechkdays.value;
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]
	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	var hrs =eval(splittime1[0])+eval(maxhrs);
	mon = eval(splitdate1[1]) - 1;
	var from_date  =new Date(splitdate1[2], mon, splitdate1[0], hrs,splittime1[1])
	a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]
	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")
	mon = eval(splitdate1[1]) - 1;
	var days = eval(maxdays)+eval(splitdate1[0]);
	var to_date  =new Date(splitdate1[2], mon,days, splittime1[0], splittime1[1])
	if(Date.parse(to_date) >= Date.parse(from_date))
		return false;
	else
		return true;	
}
function doDateTimeChk(obj)
{
	
	var comp=obj
	obj=obj.value
	var dttime = obj.split(" ");
	var dt
	var time
	var retval=true
	
	if(dttime.length>1)
	{
		dt=dttime[0]
		time=dttime[1]
		if(!checkDt(dt) )
		{
			retval= false
			comp.focus()
		}
		else
		{
			if(time==null || time=="")
			{
				retval= false;
				comp.focus()
			}

			else
			{
				if(!chkTime(time))
				{
					retval= false
					comp.focus()
				}
			}
		}
	}
	else
	{
		retval= false
		comp.focus()
	}

return retval
}


function chkTime(time1)
{
	var retval=true;
	if( (time1.charAt(time1.length-1) )!=":")
	{
		var time1arr=new Array()
		time1arr=time1.split(":")
		if(time1arr.length==2)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]
			var strCheck = ':0123456789';
			for(var i=0;i<=time1min.length;i++) {
                if (strCheck.indexOf(time1min.charAt(i)) == -1){
					retval=false;
                    break;
                }
            }
			time1hr=parseInt(time1hr)
			time1min=parseInt(time1min)
			if(time1hr<=23)
			{
				if(time1min>60)
					retval=false;
			}
			else
				retval=false;
		}
		else
			retval=false;
	}
	else
		retval=false;
	return retval
}
//============ function for ExpectedDischarge.jsp ==========
function reset()
{
	frames[1].document.forms[0].reset();
	if (frames[1].document.forms[0].searchby != null)
	{
		if (frames[1].document.forms[0].soundex.value!='')
		{
			frames[1].document.forms[0].searchby.value="";
			frames[1].document.forms[0].searchby.disabled=true;
		}
		else
		{
			frames[1].document.forms[0].searchby.disabled=false;
			frames[1].document.forms[0].searchby.value="S";
		}
	}
	frames[2].location.href = '../../eCommon/html/blank.html';
	frames[1].document.forms[0].search.disabled=false;
}
//============ function for ExpectedDischarge.jsp *** End==========
//============ functions from addModifyExpectedDischarge.jsp ==========

function validateDate1(obj,val)
{
	if(obj.value != '')
	{
		if(self.doDateTimeChk(obj))
		{	
			if(val == 'A')
			{
			
				var currdate = self.document.expecteddischarge_form.currdate;
			
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
		}
	}
}
function validateDateTime11(obj,val)
{
	if(obj.value != '')
	{
		if(!self.doDateTimeChk(obj))
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			obj.focus();
		}
		else if(val == 'A')
		{	
			self.document.expecteddischarge_form.block_until_date.value = '';
			fr = self.document.expecteddischarge_form.admissiondatetime;
			to = self.document.expecteddischarge_form.expected_discharge_date;
			if(ValidateDischargeDate(fr,to,'D'))
			{
				alert(self.getMessage('DIS_DATE_LT_EXCEEDED','IP'))
				obj.focus();
			}
		}
	}
}
function ValidateDischargeDate(from,to,val)
{
	
	from = from.value;
	to   = to.value;
	var maxhrs = 0;
	var maxdays	= 0;

	if(val == 'A')
		maxdays = self.document.DischargePatient_form.disdatechkdays.value;
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]
	
	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	var hrs =eval(splittime1[0])+eval(maxhrs);

	 var from_date  =new Date(splitdate1[2], splitdate1[1], splitdate1[0], hrs,splittime1[1])
	 a=  to.split(" ")
	 splitdate=a[0];
	 splittime=a[1]
	
	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")

	 var days		= eval(maxdays)+eval(splitdate1[0]);
	 var to_date	= new Date(splitdate1[2], splitdate1[1],days, splittime1[0], splittime1[1])

	 if(Date.parse(to_date) >= Date.parse(from_date))
		return false;
	else
		return true;	
}


function CancelAdm(obj)
{
	
	var	call_function	=	document.expecteddischarge_form.call_function.value;	
	if(call_function == 'REC_EXP_PROC_DATE')
	{
		if(document.expecteddischarge_form.proc_surgery_date.value == "") 
		{
			var error = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace("$",getLabel("eIP.ProcedureSurgeryDateTime.label",'IP'));
			alert(error);
			document.expecteddischarge_form.proc_surgery_date.select();
		}
		else
		{
			//document.forms[0].action="../../servlet/eIP.ExpectedDischargeServlet";
    		//document.forms[0].target="messageFrame";
			document.forms[0].action="../../servlet/eIP.ExpectedDischargeServlet";
			document.forms[0].submit();
			
		}
	}
	else if(call_function == 'MODIFY_SERVICE_FOR_INPATIENT')
	{
		if(document.expecteddischarge_form.service.value == "") 
		{
			var error = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace("$",getLabel("Common.service.label","Common"));
			alert(error);			
		}
		else 
		{	
			
			document.forms[0].action="../../servlet/eIP.ModifyServiceServlet";
			document.forms[0].submit();
		}
		
	}
	else
	{

		 var canval = obj.name;  
		 var	Disdate	=	document.expecteddischarge_form.expected_discharge_date.value;
		// var	Disdate_greg = convertDate(Disdate.value,'DMYHM',localeName,'en')
		 var	sdate	=	document.expecteddischarge_form.sdate;	
		if (canval == "apply")
		{	
			if ((document.expecteddischarge_form.expected_discharge_date.value == "null") || (document.expecteddischarge_form.expected_discharge_date.value == "")) 
			{
			  alert(getMessage("EXP_DIS_DATE_NOT_NULL",'IP')) ;	      
			}
			else
			{
				if(document.forms[0].patient_class.value == "DC")
				{
					document.forms[0].action="../../servlet/eIP.ExpectedDischargeServlet";
					document.forms[0].submit();
				}
				else
				{
					//retval	=	ValidateDateTime(Disdate,sdate);
				//	retval	= isBefore(Disdate,sdate.value,'DMYHM','en');

//					if(!isBeforeNow(Disdate,'DMYHM',localeName))
//					if(isAfter(Disdate,sdate.value,'DMYHM','en'))
					if(!isBeforeNow(Disdate,'DMYHM',localeName))
					{
						
						document.forms[0].action="../../servlet/eIP.ExpectedDischargeServlet";
						//document.forms[0].target="messageFrame";
						document.forms[0].submit();
					}
					else
					{
						var error = getMessage("DATE1_SHD_GT_DATE2",'IP');
						error = error.replace('$',getLabel("eIP.ExpectedDischargeDateTime.label",'IP'));
						error = error.replace('#',getLabel("Common.CurrentDateTime.label",'Common'));
						alert(error);
						document.expecteddischarge_form.expected_discharge_date.focus();
					}
					/*Thursday, January 27, 2011 ,above comment reverted and below part commented for SRR20056-SCF-6542 [IN:026017] issue 1*/
					/*Tuesday, August 31, 2010 , commented for IN023563
					document.forms[0].action="../../servlet/eIP.ExpectedDischargeServlet";
					document.forms[0].submit();
					*/
				}
			}	
		 }  
	}
}
    
    
function CloseWin(obj)
{	
	var closeVal = obj.value;
	//parent.window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = closeVal;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}


function ValidateDateTime(from,to)
{
    from	= from.value
    to      = to.value
	var a=  from.split(" ")
    splitdate=a[0];
    splittime=a[1]

    var splitdate1 =a[0].split("/")
    var splittime1= a[1].split(":")
    var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

    a=  to.split(" ")
    splitdate=a[0];
    splittime=a[1]

    splitdate1 =a[0].split("/")
    splittime1= a[1].split(":")
	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	
	
	if(Date.parse(to_date) <= Date.parse(from_date))
		return false
	else
		return true;
	
}
//Added from the addmodifyExpectedDischarger.jsp
function ValidateDateTime_local(from,to)
{
    from = from.value
    to      = to.value

    var a=  from.split(" ")
    splitdate=a[0];
    splittime=a[1]

    var splitdate1 =splitdate.split("/")
    var splittime1= splittime.split(":")

     var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     a=  to.split(" ")
    splitdate=a[0];
    splittime=a[1]

     splitdate1 =splitdate.split("/")
     splittime1= splittime.split(":")

     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     if(Date.parse(from_date) <= Date.parse(to_date))
    {
        return true
    }
    else
        return false;
}


function valSurgeryDate(obj, val)
{
	
	//var admissiondatetime		= document.forms[0].admissiondatetime;
	var expecteddischargedate	= document.forms[0].tempexpdischargedatetime;
		
	//var system_date_time		= document.forms[0].sdate;
	if(obj.value != '')
	{
		//if(!doDateTimeChk(obj))
		if(!validDateObj(obj,"DMYHM",localeName))
		{
			//alert(getMessage("INVALID_DATE_TIME","SM"));
			//obj.select();
			obj.value="";
			return;
		}
		else
		{
			if(isBeforeNow(obj.value,"DMYHM",localeName))
			//if(!ValidateDateTime(system_date_time, obj))
			{
				var sys_error = getMessage("DATE1_LT_DATE2",'IP');
				sys_error = sys_error.replace("$",getLabel("eIP.ProcedureSurgeryDateTime.label",'IP'));
				sys_error = sys_error.replace("#",getLabel("Common.SystemDateTime.label",'Common'));
				alert(sys_error);
				//obj.select();
				obj.value="";
				return;
			}
			
			if(expecteddischargedate.value != '' )
			{
				//if(!ValidateDateTime(obj, expecteddischargedate))
				var greg_procedure_surgery_datetime = convertDate(obj.value,"DMYHM",localeName,"en")
				if(isAfter(greg_procedure_surgery_datetime, expecteddischargedate.value,"DMYHM",'en'))
				{
					var param_error = getMessage("DATE1_GT_DATE2",'IP');
					param_error = param_error.replace("$",getLabel("eIP.ProcedureSurgeryDateTime.label",'IP'));
					param_error = param_error.replace("#",getLabel("eIP.ExpectedDischarge.label",'IP'));
					alert(param_error);
					//obj.select();
					obj.value="";
					return;
				}	
			}
		}
	}
}

function validateTimeDate(obj,val)
{  
	if(document.forms[0].patient_class.value == "DC")
	{
		var valid					= document.forms[0].valid.value;
		var admissiondatetime		= document.forms[0].admissiondatetime;
		var expecteddischargedate	= document.forms[0].expected_discharge_date;
		var system_date_time		= document.forms[0].sdate;
		var max_param_date			= document.forms[0].max_param_date;
		var valid_date				= document.forms[0].valid_date;
		var from_time				= document.forms[0].from_time;

		if(expecteddischargedate.value != '')
		{
			if(!validDateObj(obj,"DMYHM",localeName))
			//if(!doDateTimeChk(obj))
			{
				//alert(self.getMessage("INVALID_DATE_TIME","SM"));
				//obj.select();
				return;
			}
			else
			{
				var greg_expecteddischargedate = convertDate(expecteddischargedate.value,"DMYHM",localeName,"en");
				if(valid == "N")
				{
					//if(ValidateDateTime_local(expecteddischargedate, valid_date))
					/*if(isBefore(greg_expecteddischargedate, valid_date.value,"DMYHM",'en'))
					{
					}
					else */
					//Modified for AAKH-SCF-0093
					if(isAfter(greg_expecteddischargedate, valid_date.value,"DMYHM", localeName))
					{
						var xceed_error = getMessage("GENERAL_CANNOT_EXCEED",'IP');
						xceed_error = xceed_error.replace("$",getLabel("eIP.ExpectedDischarge.label",'IP'))
						xceed_error = xceed_error.replace("#",valid_date.value);
						alert(xceed_error);
						obj.value="";
						//obj.select();
						return;
					}

					//if(!ValidateDateTime(admissiondatetime, expecteddischargedate))
					if(isBefore(greg_expecteddischargedate,admissiondatetime.value,"DMYHM",'en'))
					{
						var max_error = getMessage("DATE1_LT_DATE2",'IP');
						max_error = max_error.replace("$",getLabel("eIP.ExpectedDischarge.label",'IP'))
						max_error = max_error.replace("#",getLabel("Common.AdmissionDateTime.label",'Common'))
						alert(max_error);
						obj.value="";
						//obj.select();
						return;
					}
				}
				else if(valid == "Y")
				{
					//if(!ValidateDateTime(system_date_time, expecteddischargedate))
					if(isAfter(from_time.value, greg_expecteddischargedate,"DMYHM",localeName))
					
					{
						var trn_error = getMessage("DATE1_LT_DATE2","IP");
						trn_error = trn_error.replace("$",getLabel('eIP.ExpectedDischargeDateTime.label','IP'));
						trn_error = trn_error.replace("#",getLabel("eIP.LastTransactionDateTime.label","IP"));
						alert(trn_error);
						obj.value='';
						//obj.select();
						return false;
					}

					//if(!ValidateDateTime(expecteddischargedate, max_param_date))
					if(isAfter(greg_expecteddischargedate,max_param_date.value,"DMYHM",'en'))
					{
						var param_error = getMessage("DATE1_GT_DATE2",'IP');
						param_error = param_error.replace("$",getLabel("eIP.ExpectedDischarge.label",'IP'))
						param_error = param_error.replace("#",getLabel("eIP.MaximumParameterValue.label","IP"));
						alert(param_error);
					    obj.value="";
						//obj.select();
						return;
					}
				}
			}
		}
	}
	else
	{
		var val_disc_date = self.document.expecteddischarge_form.val_disc_date;
		var len = obj.value;
		if(len.length > 0)
		{
			var admdate 	  = self.document.expecteddischarge_form.admissiondatetime.value;
			var dischgdate = self.document.expecteddischarge_form.expected_discharge_date.value;
			//var greg_admdate = convertDate(admdate,"DMYHM",localeName,"en");
			var greg_dischgdate = convertDate(dischgdate,"DMYHM",localeName,"en");
			if(obj.value != '')
			{
				//if(!doDateTimeChk(obj))
				if(!validDateObj(obj,"DMYHM",localeName))
				{ 
					//alert(getMessage("INVALID_DATE_TIME","SM"));
					//obj.focus();
					//obj.select();
					return false;
				}
				else //if(!ValidateDateTime(document.expecteddischarge_form.admissiondatetime,document.expecteddischarge_form.expected_discharge_date))
				if(isBefore(greg_dischgdate,admdate,"DMYHM",'en'))
				{
					//alert(getMessage("DIS_DATE_NOT_LESS_ADM_DATE",'IP'));
					/*Wednesday, December 23, 2009 IN017598*/
					var msg = getMessage("DATE1_SHD_GT_DATE2",'IP');
					msg = msg.replace('$',getLabel("eIP.ExpectesDischargeDate.label","IP"));
					msg = msg.replace("#",getLabel("Common.AdmissionDateTime.label",'Common'))
					alert(msg);
					obj.value = "";
					obj.focus();
					obj.select();	
					return false;
				}	  
				else if(val == 'DC')
				{
				//if(!ValidateDateTime(document.expecteddischarge_form.expected_discharge_date,val_disc_date))
				if(isAfter(greg_dischgdate,val_disc_date.value,"DMYHM",'en'))
					{
						var msg = getMessage("CANNOT_EXCEED_P_VALUE",'IP');
						msg = msg.replace('$',getLabel("eIP.ExpectesDischargeDate.label","IP"));
						alert(msg);
						obj.focus();
						obj.select();
						return false;
					}
				}
				else if(val == 'D')
				{
					self.document.dischargeadvice_form.block_until_date.value = '';
					fr = self.document.expecteddischarge_form.currdate;
					var to = convertDate(self.document.expecteddischarge_form.expecteddischargedate.value,"DMYHM",localeName,"en");
					//to = self.document.expecteddischarge_form.expecteddischargedate;
					//if(ValidateDischargeDate(fr,to,'D'))
					if(isAfter(fr.value,to,"DMYHM",'en'))
					{
						alert(getMessage("DIS_DATE_LT_EXCEEDED",'IP'));
						obj.focus();
						obj.select();
						return false;
					}
				}
			}
		}
	}
}

function PopulateSubService()
{
	var serviceCode = self.document.expecteddischarge_form.service.value;
	if (serviceCode =="")
	{
		self.document.expecteddischarge_form.sub_service.value="";
		var obj1 =document.forms[0].sub_service;
			var length1  = obj1.length;
			for(i=0;i<length1;i++) 
			{
			obj1.remove(1);
			}
	}
	else
	{
		
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/ServerValidation.jsp'><input type='hidden' name='function_id' id='function_id' value='"+self.document.expecteddischarge_form.call_function.value+"'><input type='hidden' name='serviceCode' id='serviceCode' value='"+serviceCode+"'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
	}
}




