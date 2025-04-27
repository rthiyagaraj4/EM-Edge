
function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=2";
	plineFrame.location.href ="../../eCommon/html/blank.html";
}
function blank(lab) 
{
	    var error='';
		error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',lab);
		error = error + "<br>" ;

	return error;
}
function apply()   
{	
	var Patient_Id = f_query_add_mod.document.getElementById("Patient_Id").value;
	var fromarray = new Array(); 
	var toarray =  new Array();
	var visitarray = new Array();
	var dobarray = new Array();
	var fields;
	var names;
	var Deceased_Yn= f_query_add_mod.RecordRevokeDeath.Deceased_Yn.value;
	var localeName=parent.frames[2].frames[1].localeName;
	if(Deceased_Yn == 'N')
	{
		fields = new Array(f_query_add_mod.RecordRevokeDeath.Deceased_Date,f_query_add_mod.RecordRevokeDeath.Deceased_Remarks);
		names  = new Array(getLabel("Common.DeceasedDate.label","Common"), getLabel("eMP.deceasedremarks.label","MP"));
	}
	else if(Deceased_Yn == 'Y') 
	{
		fields = new Array(f_query_add_mod.RecordRevokeDeath.Remarks_on_Revoking);
		names  = new Array(getLabel("eMP.remarksonrevoking.label","MP"));
	}
	if(checkFields(fields,names,messageFrame))
	{
		var acn = f_query_add_mod.RecordRevokeDeath.Action.value;	
		var visit_adm_date_time = f_query_add_mod.RecordRevokeDeath.visit_adm_date_time.value;
		var dob = f_query_add_mod.RecordRevokeDeath.DOB.value;
		var dob_2 = f_query_add_mod.RecordRevokeDeath.DOB_2.value;
		var dob_obj = f_query_add_mod.RecordRevokeDeath.DOB;
		var dt = f_query_add_mod.RecordRevokeDeath.Deceased_Date.value;
		var dt_obj = f_query_add_mod.RecordRevokeDeath.Deceased_Date;		
		var d_remarks = f_query_add_mod.RecordRevokeDeath.Deceased_Remarks.value;
		var r_remarks = f_query_add_mod.RecordRevokeDeath.Remarks_on_Revoking.value;
		var sysdt= f_query_add_mod.RecordRevokeDeath.Deceased_Date_Hidden.value;
		var Deceased_Yn= f_query_add_mod.RecordRevokeDeath.Deceased_Yn.value;
		var regn_date= f_query_add_mod.RecordRevokeDeath.regn_date.value;
			
		var errors ="";
		if(acn == "Record_Patient_Death")  
		{
			if(dt == "") 
			{
				errors = errors + blank(getLabel("Common.DeceasedDate.label","Common"));
			}
			else 
			{
				fromarray = dt.split("/");
				toarray = sysdt.split("/");
				visitarray = visit_adm_date_time.split("/");
				dobarray = dob.split("/");
				

				var fromdt			= new Date(fromarray[2],fromarray[1],fromarray[0]);
				var todt			= new Date(toarray[2],toarray[1],toarray[0]);	
				var visit			= new Date(visitarray[2],visitarray[1],visitarray[0]);
				var date_of_birth	= new Date(dobarray[2],dobarray[1],dobarray[0]);
				//if( Date.parse(fromdt) > Date.parse(todt) ) 
				if (!isBeforeNow(dt,"DMYHM", localeName))
				{
					errors = errors + getMessage("DECEASED_DT_NOT_GR_TODAY",'MP'); 
				}
				else
				{				
					//if(Date.parse(fromdt) < Date.parse(visit))
					if (isBefore(dt,visit_adm_date_time,"DMYHM", localeName))
					{
						errors = errors + getMessage("CANNOT_LESS_ENC_DATE",'MP'); 
					}
					//else if(!frames[1].ValidateDateTime(dob_obj,dt_obj))
					else if(isBefore(dt_obj.value,dob_obj.value,"DMYHM", localeName))
					{			
						var msg = getMessage("CANNOT_LESSER",'MP');
                        msg = msg.replace('#',getLabel("Common.DeceasedDate.label","Common"))
		                msg = msg.replace('$',getLabel("Common.birthDate.label","Common"))
                        msg = msg + dob_2;
						errors = errors + msg;
					}
					else {
						if(f_query_add_mod.RecordRevokeDeath.proceed.value == 'false')
						{
							errors = errors + getMessage("CANNOT_REC_DEATH_DTLS",'MP'); 
						}
					}				
				}
			}
			if(d_remarks == "") errors = errors + blank(getLabel("eMP.deceasedremarks.label","MP"));
		}
		else if(acn == "Revoke_Patient_Death") 
		{
			if(r_remarks == "") errors = errors + blank(getLabel("eMP.remarksonrevoking.label","MP"));
		}	
		else errors = errors + blank('Action');
		if(errors.length > 0) 
		{
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		} 
		if(errors.length == 0 && acn.length > 0) 
		{
			if(dt == "") 
			{
				f_query_add_mod.RecordRevokeDeath.Deceased_Date_Hidden.value = "";
			}
			else 
			{
				var arr = new Array();
				arr = dt.split("/");
				var strDay = arr[0];
				var strMonth = arr[1];
				var strYear = arr[2];
				var dt1= strYear + "-" + strMonth + "-" + strDay;
				f_query_add_mod.RecordRevokeDeath.Deceased_Date_Hidden.value=dt1;
			}
			if(f_query_add_mod.CheckMaxLen(getLabel("Common.remarks.label","Common"),f_query_add_mod.document.RecordRevokeDeath.Deceased_Remarks,250,messageFrame) && f_query_add_mod.CheckMaxLen(getLabel("Common.remarks.label","Common"),f_query_add_mod.document.RecordRevokeDeath.Remarks_on_Revoking,250,messageFrame)) 
			{
				if(validDateObj(f_query_add_mod.document.RecordRevokeDeath.Deceased_Date,'DMYHM',localeName))
				{
					var a = dt.split(" ");

					var splitdtdate = a[0].split("/")
					var splitdttime	= a[1].split(":")

					var dscdt = new Date(eval(splitdtdate[2]),eval(splitdtdate[1]),eval(splitdtdate[0]),eval(splitdttime[0]),eval(splitdttime[1]));
					
					var b = regn_date.split(" ");

					var splitregndate	= b[0].split("/")
					var splitregntime	= b[1].split(":")

					var regnarray = new Date(eval(splitregndate[2]),eval(splitregndate[1]),eval(splitregndate[0]),eval(splitregntime[0]),eval(splitregntime[1]));	
						
					///if(Date.parse(dscdt) < Date.parse(regnarray))
					if (isBefore(dt,regn_date,"DMYHM", localeName))
					{
						if(confirm(getMessage("DECEASED_REGN_DATE_CHK",'MP'))) 
						{
							f_query_add_mod.RecordRevokeDeath.action="../../servlet/eMP.RecordRevokeDeathServlet?Patient_Id="+Patient_Id;
							f_query_add_mod.RecordRevokeDeath.target="messageFrame";
							f_query_add_mod.RecordRevokeDeath.submit();
						}
						else messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
					else
					{
						f_query_add_mod.RecordRevokeDeath.action="../../servlet/eMP.RecordRevokeDeathServlet?Patient_Id="+Patient_Id;
						f_query_add_mod.RecordRevokeDeath.target="messageFrame";
						f_query_add_mod.RecordRevokeDeath.submit();
					}
				}
			}
	    }
    }	
}
/*function doDateTimeChk(obj)
{
	if(obj.value!='')
	{
		if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
        {
			retval= false
            obj.focus();
         }
         else
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

                    if(!(frames[1].checkDt(dt)))
                    {
						retval= false
						alert(getMessage("INVALID_DATE_TIME",'SM'))
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						comp.focus();
                    }
                    else
                    {
                        if(time==null || time=="")
                        {
							alert(getMessage("INVALID_DATE_TIME",'SM'))
							messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
                            retval= false;
                            comp.focus();
                        }

                        else
                        {
                            if(!(frames[1].chkTime(time)))
                            {
                                    retval= false
                                    alert(getMessage("INVALID_DATE_TIME",'SM'))
									messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
                                    comp.focus();
                            }
                        }
                    }
                }
                else
                {
                    retval= false
                    alert(getMessage("INVALID_DATE_TIME",'SM'))
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
                    comp.focus();
                }
                if(retval)
                {
                    if(TimeChk())
						retval = true;
					else
						retval = false;
                }
            }
			}
            return retval
        }
		*/
		
		/*function TimeChk()
		{
			from =f_query_add_mod.document.forms[0].system_date.value;
		to = f_query_add_mod.document.forms[0].Deceased_Date.value;
		if(f_query_add_mod.localeName=="th")
			{
			to=f_query_add_mod.convertDate(to,"DMYHM","th","en");
			}

		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1];

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1];


		 splitdate1 =splitdate.split("/");
		 splittime1= splittime.split(":");

		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 if(Date.parse(to_date) > Date.parse(from_date))
		{
			alert(getMessage('START_DATE_GREATER_SYSDATE','Common'));
			f_query_add_mod.document.forms[0].Deceased_Date.focus();
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			return false;
		}
		else
		{
			return true;
		}
	}
	*/
function reset() {
	parent.content.frames[2].document.forms[0].reset();
	f_query_add_mod.fieldFocus();
}
function onSuccess() 
{
	
	alert(getMessage("RECORD_INSERTED",'SM'));
	query();
	messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function chk_with_sysdate(obj)
{

	if(obj.value!='')
	{
	var to = document.forms[0].system_date;
		if(!ValidateDateTime(obj,to))
		{
			var str = getMessage("DATE_NOT_GREATER_SYSDATE",'Common');
			alert(str);	
			obj.select();
			obj.focus();			
		}
	}
}

function Valid_DT(event){
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

/*function calldoDateTimeChk(obj)
{
	if(obj.value!='')
	{
	if(!doDateTimeChk(obj))
	{
		alert(getMessage("INVALID_DATE_TIME",'SM'));
		obj.value='';
		obj.focus();
	}
	}
}
*/
/*function doDateTimeChk1(obj)
{
	if(obj.value!='')
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
		if(!checkDt1(dt) )
		{
			retval= false
		}
		else
		{
			if(time==null || time=="")
			{
				retval= false;
			}
			else
			{
				if(!chkTime1(time))
				{
					retval= false
				}
			}
		}
	}
	else
	{
		retval= false
	}
	if(retval)
	{
		//callDateFunction(comp)
	}
	else 
	{
		alert(getMessage("INVALID_DATE_TIME",'SM'));
		comp.focus();
	}
	}else{
	retval= false;
	}
	return retval
}
*/
function checkDt1(date1)
{
	retval=true
	var date1arr=new Array()

    date1arr=date1.split("/")
	if(date1arr.length==3)
	{
		var date1d=date1arr[0]
		var date1m=date1arr[1]
		var date1y=date1arr[2]

		date1d=eval(date1d)
		date1m=eval(date1m)
		date1yy=eval(date1y);

		if(date1m<=12)
		{
			if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
			{
				retval= false
			}
			if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30))
			{
	 			retval= false
			}
			if ((date1y.length <4) || (date1y.length >4))
			{
				retval= false
			}
		}
		else
		{
			retval= false;
		}
	}
	else
	{
		retval= false;
	}
	return retval;
}
function chkTime1(time1)
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
            
			time1hr=eval(time1hr)
			time1min=eval(time1min)
			
			if(time1hr<=23)
			{
				if(time1min>60)
				{
					retval=false;
				}
				

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
function ValidateDateTimesp (obj)
{
  var from= document.forms[0].system_date;
  if(obj.value=='')
	{ 
	  return false;
	}

  // else if(doDateTimeChk1(obj))   
   else if(validDateObj(obj,"DMYHM",localeName))
   {
			
	 if(obj.value=='')
	 {
		obj.value='';
	 } 
	 else 
	 {
		to   = obj.value
		if (!isBeforeNow(to,"DMYHM", localeName))
			{
				var str = getMessage("CANNOT_GREATER","MP");
				str=str.replace('#',getLabel("Common.deceaseddatetime.label","Common"));
				str=str.replace('$',getLabel("Common.SystemDateTime.label","Common"));
				alert(str);
				obj.value='';
				obj.focus();
			}
		/*if(localeName=="th")
		 {
		to=convertDate(to,"DMYHM","th","en");
		 }
	    from = from.value
			
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
		var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]),eval(splittime1[1]))
		if(Date.parse(to_date) >= Date.parse(from_date))
		{
				
			var str = getMessage("DATE_NOT_GREATER_SYSDATE",'Common');
			alert(str);
			obj.focus();
		}*/
	}
   }
}

/*below method added by venkatesh.s on 19/Sep/2012 against 35188 */
function calender()
{
 showCalendar('DeceasedDate','','hh:mm');
var DeceasedDate=self.document.RecordRevokeDeath.DeceasedDate.value;
var server_date_time=convertDate(self.document.RecordRevokeDeath.system_date.value,"DMYHM","en", localeName);

   if (!(server_date_time==null))
		{
			var DeceasedDate1=DeceasedDate.split(' ');
			var time=server_date_time.split(' ');
			self.document.RecordRevokeDeath.DeceasedDate.value=DeceasedDate1[0]+" "+time[1];
			
		}

} 
/* end for incident 35188 */
