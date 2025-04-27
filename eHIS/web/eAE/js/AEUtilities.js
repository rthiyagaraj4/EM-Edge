// For the Modal Window, Error message will be in the alert window

function TraumaCheckTime(obj,getCallFunc) 
{
	document.forms[0].practitioner_desc.disabled=true;
// Added/Modified by Nanda - 10/29/2002
	if (obj.value.length==14 && (obj.value.substring(13,14)==':'))
	{
		obj.value=obj.value + '00';
	}
	var to_proceed = true;

	var from = document.forms[0].assign_tmt_area_time;

	var to   = document.forms[0].exam_date_time;

	var mess = 'A';

	if(obj.value!='' &&  from.value!=null && to.value!='')
	{
		if(monthcheck(obj)==false  || doDateTimeChk(obj) == false ) 
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			obj.select();
			obj.focus();
			to_proceed = false;
			return false;
		}
		else
		{
			if(ValidateDateTime(from,to,obj,mess,getCallFunc)==false)
			{
				obj.focus();
				to_proceed = false;
			}
			else
			{
				to_proceed = true;
			}
		} 
     }
	 else
	 {
		to_proceed = false;
	 }


	 if (to_proceed == true)
	 {
		from = document.forms[0].exam_date_time;
		to   = document.forms[0].sys_date_time;
		mess = 'S';

			if(obj.value!='' &&  from.value!=null && to.value!='')
			{
				if(monthcheck(obj)==false  ) 
				{
					alert(getMessage("INVALID_DATE_TIME",'SM'));
					obj.select();
					obj.focus();
					to_proceed = false;
					return false;
				}
				else
				{
					if(ValidateDateTime(from,to,obj,mess,getCallFunc)==false)
					{
						obj.focus();
						to_proceed = false;
					}
					else
					{
						to_proceed = true;
					}
				} 
			 }
	 }
	 document.forms[0].practitioner_desc.disabled=false;

}

function CheckTime(obj,from,to,mess) 
{
	
	if(obj.value!='' &&  from.value!=null && to.value!='')
	{
		if(monthcheck(obj)==false) 
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			obj.select();
			obj.focus();
			return false;
		}
		else
		{
			if(ValidateDateTime(from,to,obj,mess)==false)
			{
				obj.focus();
			}
		} 
     }
}

function monthcheck(obj) 
{
	var dt=obj.value;
	var strMonth ;
	var strYear;
	var strDays;
	if( dt.length > 0 ) 
	{
		if (dt.indexOf(" ") > -1) 
		{
			var 	arr = new Array();
			var arr1 = new Array();
			var arrTime = new Array();
			arr = dt.split("/");

		   if (arr.length < 3) return false;
			strDays=arr[0];
			strMonth = arr[1];
			strYear = arr[2];

			arrTime=strYear.split(" ");
			var strYear1=arrTime[0];
			var strTime=arrTime[1];
			var  time=strTime.split(":");
			if (time.length < 2) return false;
			var strHr=time[0];
			var  strMi=time[1];
			if (strYear1.length < 4) return false;
			if (isNaN(strMonth)==true) return false;
			if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDays > 31 || strDays < 1)) return false;
			if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDays > 30 || strDays < 1)) return false;
			if (strMonth == 2) 
			{
				if (strDays < 1) return false;
				if (LeapYear(strYear1) == true) 
				{
					if (strDays > 29) return false;
				}
				else 
				{
					if (strDays > 28) return false;
				}
			}
			if (isNaN(strYear1)==true) return false;
			if (strYear1 < 1900) return false;
			if (strMonth>12 || strMonth<1) return false;
			if (strHr > 23 || strHr<0 )  return false;
			if (strMi > 59 || strMi<0)  return false;
		}
		else return false;
	}
	else return true;
	return true;
}


function ValidateDateTime (from,to,obj,mess,getCallFunc)
{
	from	= from.value
	to		= to.value
	if (Date.parse(from) && Date.parse(to))
	{
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

		/*	if(Date.parse(from_date) < Date.parse(to_date))
			{
				alert(getAEMessage('AE_ASSIGN_DATE_TIME_C2'));\
				obj.select();
				obj.focus();
			}*/

			if(Date.parse(to_date) < Date.parse(from_date))
			{
				if(mess=="A")
				{
					if (getCallFunc=="Score")
					{
						alert(getMessage('AE_ASSESSMENT_DATE_TIME_C1','AE'));

					}
					else if (getCallFunc=="Exam")
					{
						alert(getMessage('AE_EXAM_DATE_TIME_C1','AE'));
					}
				
					obj.select();
					obj.focus();
					return false;
				}
				else if(mess=="S")
				{
					if (getCallFunc=="Score")
					{
						alert(getMessage("AE_ASSESSMENT_DATE_TIME_C2",'AE'));
					}
					else if (getCallFunc=="Exam")
					{
						alert(getMessage("AE_EXAM_DATE_TIME_C2",'AE'));
					}
					obj.select();
					obj.focus();
					return false;
				}
				else if(mess=="TA"){
					alert(getMessage("AE_ASSIGN_DATE_TIME_C1",'AE'));
					obj.select();
					obj.focus();
					return false;
				}
				else if(mess=="TS"){
					alert(getMessage("AE_ASSIGN_DATE_TIME_C2",'AE'));
					obj.select();
					obj.focus();
					return false;
				}
			}
			else
				return true;
	}
	else
	{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			obj.select();
			return false;
	}
}

var prevClassName = "";
var prevRowObject = "";

function changeRowColor(obj, changeClassName)
{
	if( changeClassName==null )	changeClassName = "ITEMSELECT";
	if(	prevClassName != "" )
		for(i=0; i<prevRowObject.cells.length; i++)
			if(prevRowObject.cells(i).className==changeClassName)
				prevRowObject.cells(i).className = prevClassName;

	prevRowObject	=	obj;
	prevClassName	=	obj.cells(0).className;

    for(i=0; i<obj.cells.length; i++)
		if(obj.cells(i).className=="QRYODD" || obj.cells(i).className == "QRYEVEN")
			obj.cells(i).className = changeClassName;
}

function callCheckMaxLen(obj,noOfChars,Legend)
{
	makeValidString(obj);
	if(trimCheck(obj.value)=="") return false;
	if(obj.value.length > noOfChars) 
	{
		var error=getMessage("REMARKS_CANNOT_EXCEED",'Common');
		error=error.replace("$",getLabel("Common.remarks.label","Common"));
		error=error.replace("#",noOfChars);
		alert(error);
//		alert("APP-SM0045 - Remarks cannot exceed " + noOfChars  + " characters");
		obj.focus();
		return false;
	}
	else
	{
		parent.frames[5].href="../../eCommon/jsp/error.jsp";
		return true;
	}
}

function setFocus(obj)
{
	setTimeout("setFocusOn('"+obj+"');",1000);
}

function setFocusOn(obj)
{
	eval(obj).focus();
}
