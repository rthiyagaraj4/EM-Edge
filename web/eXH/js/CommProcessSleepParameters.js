//********************************************************************************************
//FUNCTION RESET 
//********************************************************************************************
function reset()
{

   if(window.f_query_header.document.forms[0])
    {
	 window.f_query_header.document.forms[0].reset();
	}
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
//********************************************************************************************
//function chkvalidate
//******************************************************************************************/
function chkvalidate(Monthimg_name,Dayimg_name1,yearimage)
{
	var oval=this.document.forms[0].type.value;
	var  monthselectbox=document.getElementById("month");
	var  dayselectbox=document.getElementById("day");
	var  dateselectbox=document.getElementById("datenumber");
	monthselectbox.options[0]=new Option(getLabel("Common.defaultSelect.label","common"),"",  true, false);
		dayselectbox.options[0]=new Option(getLabel("Common.defaultSelect.label","common"),"",  true, false);
		dateselectbox.options[0]=new Option(getLabel("Common.defaultSelect.label","common"),"",  true, false);
	// document[Monthimg_name].src='../../eCommon/images/empty.gif';
	// document[yearimage].src='../../eCommon/images/empty.gif';
	 // document[Dayimg_name1].src='../../eCommon/images/empty.gif';
	if(oval=='D')
	{
		monthselectbox.disabled=true;
		dayselectbox.disabled=true;
	 	dateselectbox.disabled=true;
		document.forms[0].month.options[0]=new Option(getLabel("Common.defaultSelect.label","common"),"",  true, false);
		document.forms[0].day.options[0]=new Option(getLabel("Common.defaultSelect.label","common"),"",  true, false);
		document.forms[0].datenumber.options[0]=new Option(getLabel("Common.defaultSelect.label","common"),"",  true, false)
       
	}
	if(oval=='W')
	{
		dayselectbox.disabled=false;
		dayselectbox.enabled=true;
		monthselectbox.disabled=true;
		dateselectbox.disabled=true;
		 document[Dayimg_name1].src='../../eCommon/images/mandatory.gif';
		 document[Monthimg_name].src='../../eCommon/images/empty.gif';
	 document[yearimage].src='../../eCommon/images/empty.gif';
	}

	if(oval=='M')
	{
		
		dateselectbox.disabled=false;
		dateselectbox.enabled=true;
		monthselectbox.disabled=true;
		dayselectbox.disabled=true;
		document[yearimage].src='../../eCommon/images/mandatory.gif';
		document[Monthimg_name].src='../../eCommon/images/empty.gif';
		document[Dayimg_name1].src='../../eCommon/images/empty.gif';
	}
    if(oval=='Y')
	{
			          	
		monthselectbox.disabled=false;
		monthselectbox.enabled=true;
		dateselectbox.disabled=false;
		dateselectbox.enabled=true;
		dayselectbox.disabled=true;
		document[Monthimg_name].src='../../eCommon/images/mandatory.gif';
  document[yearimage].src='../../eCommon/images/mandatory.gif';
  document[Dayimg_name1].src='../../eCommon/images/empty.gif';
		
	}


}
//******************************************************************************************/
//function checkt
//******************************************************************************************/
function checkN(obj,whichtextfield)
{
var valq=obj.value;
if(valq!='')
    {
if(valq.length==1)
{
obj.value="0"+valq+":00";
		}

	}

}
 function checkt(obj,whichtextfield)
 {
   var valq=obj.value;

    if(valq!='')
    {
          var arr=valq.split(':');


        
		if(arr[0]>24)
		{
alert(getMessage('XH1048','XH'));
obj.value='';
whichtextfield.focus();
  return false;
		}
		if(arr[1]>60)
		{
alert(getMessage('XH1051','XH'));
obj.value='';
whichtextfield.focus();
  return false;
		}
		
	}
}
//******************************************************************************************/
//function checkFormat
//******************************************************************************************/

 function checkFormat(obj)
 {
var valq=obj.value;

if(valq!='')
{
		
if(valq.length==2) 
	{
obj.value=valq+":00";
return true;
	}

else return false;

}

}
//******************************************************************************************/
//function checkvalueFormat
//******************************************************************************************/
/*function checkvalueFormat(obj)
{

var time1=this.document.forms[0].from_sleep_time.value;
var time2=this.document.forms[0].to_sleep_time.value;
var arr1=time1.split(':');
var arr2=time2.split(':');
var fromdt = new Date('2007','10','10',arr1[0],arr1[1]);
var todt = new Date('2007','10','10',arr2[0],arr2[1]);

 if((time1!='')&&(time2!='')){
if(Date.parse(todt) < Date.parse(fromdt))
{
  alert(getMessage('XH1025','XH'));
obj.value='';
  this.document.forms[0].to_sleep_time.focus();
  return false;
}
}

}*/


function checkvalueFormat()
{

var time1=this.document.forms[0].from_sleep_time.value;
var time2=this.document.forms[0].to_sleep_time.value;

var arr1=time1.split(':');
var arr2=time2.split(':');


var fromdt = new Date('2007','10','10',arr1[0],arr1[1]);
var todt = new Date('2007','10','10',arr2[0],arr2[1]);
 
if((time1!='')&&(time2!='')){



if(Date.parse(todt) < Date.parse(fromdt))
{
	 alert(getMessage('XH0052','XH'));
 document.forms[0].to_sleep_time.value='';
  this.document.forms[0].to_sleep_time.focus();
  return false;
}


/*else if(arr2[0]>24 || arr1[0]>24)
	{
alert(getMessage('XH0051','XH'));
 document.forms[0].to_sleep_time.value='';
  this.document.forms[0].to_sleep_time.focus();
  return false;
	}
else if((arr2[1]<60) || (arr1[1]<60))
	{
	alert(getMessage('XH0051','XH'));
 document.forms[0].to_sleep_time.value='';
  this.document.forms[0].to_sleep_time.focus();
  return false;
	}*/
}

}
//******************************************************************************************/
//function addRecord
//******************************************************************************************/

function addRecord()
{

	parent.frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	var oval=this.document.forms[0].type.value;

	if(oval=='D')
	{
		var fields = new Array (this.document.forms[0].from_sleep_time,
					    this.document.forms[0].to_sleep_time				     
					   );

		var names = new Array ( 
						getLabel("eXH.FromSleepTime.Label","XH"),
						getLabel("eXH.ToSleepTime.Label","XH"));
	}
	if(oval=='W')
	{

		var fields = new Array (this.document.forms[0].from_sleep_time,
					    this.document.forms[0].to_sleep_time,this.document.forms[0].day				     
					   );


		var names = new Array ( 
						getLabel("eXH.FromSleepTime.Label","XH"),
						getLabel("eXH.ToSleepTime.Label","XH"),getLabel("Common.day.label","common"));
	}
	
	if(oval=='M')
	{
		var fields = new Array (this.document.forms[0].from_sleep_time,
					    this.document.forms[0].to_sleep_time,this.document.forms[0].datenumber				     
					   );
		var names = new Array ( 
						getLabel("eXH.FromSleepTime.Label","XH"),
						getLabel("eXH.ToSleepTime.Label","XH"),getLabel("eXH.DateNumber.Label","XH"));
	}
	if(oval=='Y')
	{

		var fields = new Array (this.document.forms[0].from_sleep_time,
					    this.document.forms[0].to_sleep_time,this.document.forms[0].datenumber,this.document.forms[0].month				     
					   );


		var names = new Array ( 
						getLabel("eXH.FromSleepTime.Label","XH"),
						getLabel("eXH.ToSleepTime.Label","XH"),getLabel("eXH.DateNumber.Label","XH"),getLabel("Common.month.label","XH"));
	}


	if(!checkFields( fields, names, parent.messageFrame))
	{
	
	}
	else
	{		
		this.document.forms[0].action="../../servlet/eXH.CommunicationProcessSleepParametersServlet";	
		this.document.forms[0].mode.value='I';
		this.document.forms[0].submit();
	}
 
	parent.commontoolbarFrame.document.location.reload();

}
//******************************************************************************************/
//function DeleteRecord
//******************************************************************************************/
function DeleteRecord( value1)
{
 if(this.confirm(getMessage('XH1020','XH'))==true){
this.document.forms[0].action="../../servlet/eXH.CommunicationProcessSleepParametersServlet";	
this.document.forms[0].mode.value='D';
this.document.forms[0].rowid.value=value1;
this.document.forms[0].submit();
 }
}
//******************************************************************************************/

function CheckForSpecCharsforID(event)
{
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
