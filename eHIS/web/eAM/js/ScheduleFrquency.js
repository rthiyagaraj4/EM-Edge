/**************Global Variable for all function ****************/
var function_id      = ""   ;
var resultGlobal	 = false;
var messageGlobal	 = ""   ;
var durationType	 = ""   ;
var repeatValue		 = ""   ;
var freqLegend		 = ""   ;
var startTimeRound	 = ""   ;
var startTimeAssign  = ""   ;
//Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
var max_no_of_cycle  = ""   ; 
var dayHTML	         = ""   ; 
var s;
/***************************************************************/
var flagChk          = false; //Only to DiBug
/*************Handle to the Frame 's and the form Object ****************/
var doc		= null	;
var formObj	= null ;
/********************Intialise function*************************************/
function intialisation(){
function_id      = "" ;
resultGlobal	 = false;
messageGlobal	 = "" ;
durationType	 = "" ;
repeatValue		 = "" ;
freqLegend		 = "" ;
startTimeRound	 = ""   ;
startTimeAssign  = ""   ;
}
/***************************************************************/
function create() {
f_query_add_mod.location.href = "../../eAM/jsp/ScheduleFrequencyAddModify.jsp?mode=1&function_id="+function_id;
}
/***************************************************************/
function query() {
f_query_add_mod.location.href="../../eAM/jsp/ScheduleFrequencyQueryCriteria.jsp?function_id="+function_id;
}
/***************************************************************/

function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
/***********************************************************************************/
function apply(){
	
	var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) ) // checking if it is query criteria or result page
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	getHandle();

	var	fields = new Array (formObj.freq_code,
						formObj.admin_facility_id
						);
	var	names =	new	Array (getLabel("Common.Frequency.label","Common"),getLabel("Common.facility.label","Common"));	

if(!f_query_add_mod.checkFieldsofMst(fields,	names, messageFrame))
			return ;	
repeatValue=formObj.repeat.value;
var noTime = parseInt(repeatValue) ;
durationType = f_query_add_mod.document.forms[0].durationType.value;

var noTimeEntered	=  0;
var max_no_of_cycle = formObj.max_no_of_cycle.value;
if(max_no_of_cycle == ""){
for(i = 1; i <= noTime ; i++)  // checking if all the time fields are entered
	{
		var time = eval("doc.all.time"+ i );

		if(time.value == "")
		{
			var message  = getMessage("MAND_TIME_CHK","AM"); 
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		
			eval(time).focus();
			return ;
		}
	}	
}
else{ //Added by Sangeetha on 10th Jul 2017 for ML-MMOH-CRF-0345.2

  for(k = 1; k <= max_no_of_cycle ; k++)  
   {
	   if(durationType == "D"){ // checking if all the cycle day fields are entered
			var cycle_days = eval("f_query_add_mod.document.forms[0].repeat_D"+k);
			if(cycle_days.value == "")
			{
				var message  = getMessage('CAN_NOT_BE_BLANK','Common'); 
				message = message.replace('$',getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.day.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				eval(cycle_days).focus();
				return ;
			}
	   }
	   if(durationType == "W"){ // checking if all the cycle week fields are entered
			var cycle_weeks = eval("f_query_add_mod.document.forms[0].repeat_W"+k);
			if(cycle_weeks.value == "")
			{
				var message  = getMessage('CAN_NOT_BE_BLANK','Common'); 
				message = message.replace('$',getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.Week.label","Common")); 
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				eval(cycle_weeks).focus();
				return ;
			}
	   }
   }
  for(j = 1; j <= max_no_of_cycle ; j++)  // checking if all the time fields are entered
   {
		for(i = 1; i <= noTime ; i++)  
		{
			var time = eval("f_query_add_mod.document.forms[0].row_"+j+"_time_"+i );
			if(time.value == "")
			{
				var message  = getMessage("MAND_TIME_CHK","AM"); 
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				eval(time).focus();
				return ;
			}
		}
   }
}
if(max_no_of_cycle == "")
	{
if(durationType!="W" && durationType!="L") // checking if times are entered in ascending order only for day frequency
	{
		for(i = 1; i < noTime ; i++)
			{	
				var time1 = eval("f_query_add_mod.document.forms[0].time"+i );
				var time2 = eval("f_query_add_mod.document.forms[0].time"+(i+1) );
	
					if(compareTime(time1.value,time2.value))
						{
							var message  = getMessage("INVALID_TIME_ENTRY_FORMAT","AM"); 
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
							return ;
						}
				}
		}
	}
	else{ //Added by Sangeetha on 10th Jul 2017 for ML-MMOH-CRF-0345.2
		for(j = 1; j <= max_no_of_cycle ; j++)  // checking if all the time fields are entered
		{
			for(i = 1; i < noTime ; i++)
			{	
				var time1 = eval("f_query_add_mod.document.forms[0].row_"+j+"_time_"+i );
				var time2 = eval("f_query_add_mod.document.forms[0].row_"+j+"_time_"+(i+1) );
				if(compareTime(time1.value,time2.value))
					{
						var message  = getMessage("INVALID_TIME_ENTRY_FORMAT","AM"); 
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						return ;
					}
			}
		}
	}

var noTimeEntered	=  0;

/*for(i = 1; i <= noTime ; i++) // checking if all the time fields are entered
	{
		var time = eval("doc.all.time"+ i );

		if(time.value == "")
		{
			var message  = getMessage("MAND_TIME_CHK","AM"); 
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		
			eval(time).focus();
			return ;
		}
	
	}	*/

if(max_no_of_cycle == "")
{
if(durationType == "W" || durationType == "L") // checking whether any value for day/time is repeated
	{
		for(i = 1; i < noTime ; i++)
			{	
				var day1 = eval("f_query_add_mod.document.forms[0].repeat_"+i +".value");
				for(j=i+1; j<= noTime;j++)
					{
						var day2 =  eval("f_query_add_mod.document.forms[0].repeat_"+j+".value");
						if(day1==day2)
							{
								var time1 = eval("f_query_add_mod.document.forms[0].time"+i+".value" );
								var time2 = eval("f_query_add_mod.document.forms[0].time"+j+".value" );
															
								if(compareTime1(time1,time2))
									{
										alert(getMessage("REPEAT_DAY_TIME","AM"));
										var dat = "f_query_add_mod.document.forms[0].repeat_"+j ;
										var tim = "f_query_add_mod.document.forms[0].time"+j ; 
										eval(tim).select();
										eval(tim).focus();
										messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
										return;
									}
							}
					}
			}
	}
  }
  else{ //Added by Sangeetha on 10th Jul 2017 for ML-MMOH-CRF-0345.2
	if(durationType == "D") // checking whether any value for day is repeated
	{
		for(i = 1; i < max_no_of_cycle ; i++)
			{	
				var day1 = eval("f_query_add_mod.document.forms[0].repeat_D"+i +".value");
				for(j=i+1; j<= max_no_of_cycle;j++)
					{
						var day2 =  eval("f_query_add_mod.document.forms[0].repeat_D"+j+".value");
						if(parseInt(day1) == parseInt(day2)) 
							{
										alert(getMessage("REPEAT_DAY_TIME","AM"));
										var dat = "f_query_add_mod.document.forms[0].repeat_D"+j ;
										eval(dat).select();
										eval(dat).focus();
										messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
										return;
							}
							if(parseInt(day1) >= parseInt(day2)) 
							{
										var msg = getMessage("INVALID_TIME_ENTRY_FORMAT","AM");
										msg = msg.replace("Time",getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.day.label","Common"));
										alert(msg);
										var dat = "f_query_add_mod.document.forms[0].repeat_D"+j ;
										eval(dat).select();
										eval(dat).focus();
										messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
										return;
							}
					}
			}
		}
	if(durationType == "W") // checking whether any value for week is repeated
	{
		for(i = 1; i < max_no_of_cycle ; i++)
			{	
				var day1 = eval("f_query_add_mod.document.forms[0].repeat_W"+i +".value");
				for(j=i+1; j<= max_no_of_cycle;j++)
					{
						var day2 =  eval("f_query_add_mod.document.forms[0].repeat_W"+j+".value");
						if(parseInt(day1) == parseInt(day2)) 
							{
										alert(getMessage("REPEAT_DAY_TIME","AM"));
										var dat = "f_query_add_mod.document.forms[0].repeat_W"+j ;
										eval(dat).select();
										eval(dat).focus();
										messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
										return;
							}
							if(parseInt(day1) >= parseInt(day2)) 
							{
										var msg = getMessage("INVALID_TIME_ENTRY_FORMAT","AM");
										msg = msg.replace("Time",getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.Week.label","Common"));
										alert(msg);
										var dat = "f_query_add_mod.document.forms[0].repeat_W"+j ;
										eval(dat).select();
										eval(dat).focus();
										messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
										return;
							}
					}
			}
		}
	if(durationType == "L") // checking whether any value for Month is repeated
	{
		for(i = 1; i < max_no_of_cycle ; i++)
			{	
				var day1 = eval("f_query_add_mod.document.forms[0].repeat_L"+i +".value");
				for(j=i+1; j<= max_no_of_cycle;j++)
					{
						var day2 =  eval("f_query_add_mod.document.forms[0].repeat_L"+j+".value");
						if(parseInt(day1) == parseInt(day2)) 
							{
										alert(getMessage("REPEAT_DAY_TIME","AM"));
										var dat = "f_query_add_mod.document.forms[0].repeat_L"+j ;
										eval(dat).focus();
										messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
										return;
							}
							if(parseInt(day1) >= parseInt(day2)) 
							{
										var msg = getMessage("INVALID_TIME_ENTRY_FORMAT","AM");
										msg = msg.replace("Time",getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.month.label","Common"));
										alert(msg);
										var dat = "f_query_add_mod.document.forms[0].repeat_L"+j ;
										eval(dat).focus();
										messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
										return;
							}
					}
			}
		}
	} //end of else
	
	formObj.submit();
}
/***************************************************************/
function fillLegend(obj){
	getHandle();
	removeOptions();
	var  freq_code = "";
	
	if(obj.value == "" ){
		removeOptions();
		return ;		
	}else{
		freq_code = obj.value ;	
	 }
		
	var tempJsp ='<form name="temp" id="temp" method="post" action="../../eAM/jsp/ScheduleFrequencyComboFill.jsp">' ;
	tempJsp	   +='<input type="hidden" name="freq_code" id="freq_code" value="'+freq_code+'">' ;	
	tempJsp	   +="</form>"	
	messageFrame.document.body.insertAdjacentHTML('afterbegin',tempJsp);
	messageFrame.document.forms[0].submit();
}
/***********************************************************************/
function assignFrqeuncyGlobal(durationType_P , repeatValue_P , freqLegend_P , start_time_round_p , start_time_assign_p, daysHtml_P, max_no_of_cycle_p, monthdaysHtml_p){  //Modified by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
getHandle();
durationType					= durationType_P ;
formObj.durationType.value		= durationType_P ;

formObj.daysHtml.value = daysHtml_P;
repeatValue						= repeatValue_P ;
formObj.repeat.value			= repeatValue ;

freqLegend						 = freqLegend_P ;
startTimeRound					 = start_time_round_p ;
startTimeAssign					 = start_time_assign_p ;
//Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
max_no_of_cycle					 = max_no_of_cycle_p ; 
formObj.max_no_of_cycle.value	 = max_no_of_cycle_p ; 
formObj.monthdaysHtml.value		 = monthdaysHtml_p;
addOptions(durationType,repeatValue,freqLegend,max_no_of_cycle);
}
/*********************Show Days Legend and ****************************/
function addOptions(durationType,repeatValue,freqLegend,max_no_of_cycle) //Modified by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
	{
		getHandle();
		document.getElementById("freqLegend").innerHTML = "&nbsp;" + freqLegend;  //display freq Legend
		if(repeatValue != "")
		{  
			var time = parseInt(repeatValue);
			var max_cycle = parseInt(max_no_of_cycle);

		 if(max_no_of_cycle == null || max_no_of_cycle == ""){ 
			if(durationType == 'L' ) // month
				{
					var timeHtml="";
					var frmObj =doc.forms[0];
					for(i=1 ; i <= time ; i++)
						{
							timeHtml += "<TR><TD align='center' class='label'>  "+i + "</TD><TD>"+"<SELECT name='repeat_"+i+"' id='repeat_"+i+"'>"+frmObj.daysHtml.value+"</SELECT></TD><TD>"+"<INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' name='time"+i+"' id='time"+i+"' value=''>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></TD></TR>";
						}

					document.getElementById("timeLegend").innerHTML = "<table border='0' width='100%' align='center'><tr><th align='left'>"+getLabel("eAM.TimeRoundedto.label","AM")+":"+decodeLocal(startTimeAssign) + " " + decodeLocal(startTimeRound) + "</th></tr><tr><td>&nbsp;</td></tr><tr><td><table border='1' width='50%' align='center'><th align='center'>Repeat</th><th align='center'>"+getLabel("Common.day.label","Common")+"</th><th align='center'>"+getLabel("Common.time.label","Common")+"</th><tr>"+ timeHtml +"</tr></table></td></tr></table>";
				}

			else if(durationType == 'W' ) //week
				{
					var timeHtml="";
					var frmObj =doc.forms[0];
					for(i=1 ; i <= time ; i++)
						{
							timeHtml += "<TR><TD  class='label'>  "+i + "</TD><TD>"+"<SELECT name='repeat_"+i+"' id='repeat_"+i+"'>"+frmObj.daysHtml.value+"</SELECT></TD><TD>"+"<INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' name='time"+i+"' id='time"+i+"' value=''>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></TD></TR>";
						}

					document.getElementById("timeLegend").innerHTML = "<table border='0' width='100%' align='center'><th align='left'>"+getLabel("eAM.TimeRoundedto.label","AM")+":"+decodeLocal(startTimeAssign) + " " + decodeLocal(startTimeRound) + "</th><tr><td>&nbsp;</td></tr><tr><td><table border='1' width='50%' align='center'><th align='center'>Repeat</th><th align='center'>"+getLabel("Common.day.label","Common")+"</th><th align='center'>"+getLabel("Common.time.label","Common")+"</th>"+ timeHtml +"</table></td></tr></table>" ;
				}
				
			else // day or hour
				{
					var timeHtml ="<TR>";
					for(i=1 ; i <= time ; i++)
						{
							timeHtml += "<TD  class='label'>"+i + "</TD><TD>"+'<INPUT class="label" TYPE="text" onBlur="parent.timeChk(this);" size="5" maxlength="5" name="time'+i+'" id="time'+i+'" value="">&nbsp;'
							timeHtml +="<img src='../../eCommon/images/mandatory.gif'></img>";
					        timeHtml +="</TD>";

							if(i%6 == 0)
								timeHtml +="</TR><TR>";
						}
					timeHtml  += "</TR></TABLE><input type='hidden' name='noTime' id='noTime' value="+i+">";

					document.getElementById("timeLegend").innerHTML = "<table border='0' width='100%'><th  colspan='"+(time*2) +"' align='left'>"+getLabel("eAM.TimeRoundedto.label","AM")+":"+decodeLocal(startTimeAssign) + " " + decodeLocal(startTimeRound) + "</th>"+ timeHtml ;
				}
		     }
			 //Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
			 else{

				 if(durationType == 'D' ) //Day
				{
					var timeHtml ="";
					var maxHtml  ="";
					var frmObj   =doc.forms[0];
					for(i=1 ; i <= max_cycle ; i++) {
							timeHtml	= "";
							for(j=1 ; j <= time ; j++)
								{
									timeHtml += "<TD><INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' name='row_"+i+"_time_"+j+"' id='row_"+i+"_time_"+j+"' value=''>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></TD>";
								}
								maxHtml += "<TR><TD  class='label'>  "+i + "</TD><TD>"+"<INPUT class='label' TYPE='text' size='5' maxlength='2' name='repeat_D"+i+"' id='repeat_D"+i+"' value='' onkeypress='return CheckForNumber(event);' onBlur='CheckPositiveNumber(this)' ></TD>"+ timeHtml +"</TR>";
						}
					/*for(i=1 ; i <= max_cycle ; i++)
						{
							maxHtml += "<TR><TD align='right' class='label'>  "+i + "</TD><TD>"+"<INPUT class='label' TYPE='text' size='5' maxlength='2' name='repeat_D"+i+"' id='repeat_D"+i+"' value='' onkeypress='return CheckForNumber(event);' onBlur='CheckPositiveNumber(this)' ></TD>"+ timeHtml +"</TR>";
						}*/
					document.getElementById("timeLegend").innerHTML = "<table border='0' width='100%' align='center'><th align='left'>&nbsp;</th><tr><td>&nbsp;</td></tr><tr><td><table border='1' width='50%' align='center'><th align='center'>SI No</th><th align='center'>"+getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.day.label","Common")+"</th><th colspan= "+j+" align='center'>"+getLabel("Common.time.label","Common")+"</th>"+ maxHtml +"</table></td></tr></table>" ;
				}
				else if(durationType == 'W' ) //week
				{
					var timeHtml ="";
					var maxHtml  ="";
					var frmObj   =doc.forms[0];
				 for(i=1 ; i <= max_cycle ; i++)
				  {
					 timeHtml	= "";
					for(j=1 ; j <= time ; j++)
						{
							timeHtml += "<TD><INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' name='row_"+i+"_time_"+j+"' id='row_"+i+"_time_"+j+"' value=''>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></TD>"
						}
							maxHtml += "<TR><TD  class='label'>  "+i + "</TD><TD>"+"<INPUT class='label' TYPE='text' size='5' maxlength='2' name='repeat_W"+i+"' id='repeat_W"+i+"' value='' onkeypress='return CheckForNumber(event);' onBlur='CheckPositiveNumber(this)' ></TD><TD>"+"<SELECT name='repeat_D"+i+"' id='repeat_D"+i+"'>"+frmObj.daysHtml.value+"</SELECT></TD>"+ timeHtml +"</TR>";
						}
					document.getElementById("timeLegend").innerHTML = "<table border='0' width='100%' align='center'><th align='left'>&nbsp;</th><tr><td>&nbsp;</td></tr><tr><td><table border='1' width='50%' align='center'><th align='center'>SI No</th><th align='center'>"+getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.Week.label","Common")+"</th><th align='center'>"+getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.day.label","Common")+"</th><th colspan= "+j+" align='center'>"+getLabel("Common.time.label","Common")+"</th>"+ maxHtml +"</table></td></tr></table>" ;
				}
				else if(durationType == 'L' ) //Month
				{
					var timeHtml ="";
					var maxHtml  ="";
					var monthHTML="";
					var frmObj   =doc.forms[0];			
					for( k=1; k<=12;k++)
						{
							monthHTML =monthHTML+"<OPTION value='"+k+"'>"+k+"</OPTION>";
						}
					for(s=1 ; s <= max_cycle ; s++)
						{
						 timeHtml	= "";
						for(j=1 ; j <= time ; j++)
							{
								timeHtml += "<TD><INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' name='row_"+s+"_time_"+j+"' id='row_"+s+"_time_"+j+"' value=''>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></TD>"
							}
							maxHtml += "<TR><TD  class='label'>  "+s + "</TD><TD>"+"<SELECT id='month' name='repeat_L"+s+"' id='repeat_L"+s+"' onChange='populateMonths(this,"+s+")'>"+monthHTML+"</SELECT></TD><TD>"+"<SELECT id='frq_day"+s+"' name='repeat_D"+s+"' id='repeat_D"+s+"'>"+frmObj.monthdaysHtml.value+"</SELECT></TD>"+ timeHtml +"</TR>";	
						}					
					document.getElementById("timeLegend").innerHTML = "<table border='0' width='100%' align='center'><th align='left'>&nbsp;</th><tr><td>&nbsp;</td></tr><tr><td><table border='1' width='50%' align='center'><th align='center'>SI No</th><th align='center'>"+getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.month.label","Common")+"</th><th align='center'>"+getLabel("eAM.Cycle.label","am_labels")+" "+getLabel("Common.day.label","Common")+"</th><th colspan= "+j+" align='center'>"+getLabel("Common.time.label","Common")+"</th>"+ maxHtml +"</table></td></tr></table>" ;
				}
			 }//END of else
			} // end of if(repeatValue != "")

	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;

}

/***********************************************************************************/
//Added by Sangeetha on 5th Jul 2017 for ML-MMOH-CRF-0345.2 - START
function populateMonths(obj, count){
	var cyDay = "";
	if(obj.value == 2){	  
		cyDay = 29;	
	}else if(obj.value == 1 || obj.value == 3 || obj.value == 5 || obj.value == 7 || obj.value == 8 || obj.value == 10 || obj.value == 12){
		cyDay = 31;	
	}else if(obj.value == 4 || obj.value == 6 || obj.value == 9 || obj.value == 11){
		cyDay = 30;
    }
    if(cyDay!=""){
		var obj2 =eval(document.getElementById('frq_day'+count));
		var length1  = obj2.length;	  
		for(var i=length1-1; i>=0; i--) { 
				obj2.remove(i);
		} 		
		for(var i=1; i<=cyDay; i++){  			
			var opt=document.createElement("OPTION");
			opt.text=i;
			opt.value=i;
			obj2.add(opt);		
		}
    }
}
function CheckForNumber(event)
{
    var strCheck = '1234567890';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}
function CheckPositiveNumber(obj) {
    if ( obj.value > 0) {
    }
    else {
			if(obj.value != ""){
            alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.select();
            obj.focus();
			}
        }
    }
// END
function decodeLocal(objVal){

	if(objVal == "" || objVal == null || objVal == "null")    return	"";
	if(objVal == "N")    return	getLabel("Common.next.label","Common");
	if(objVal == "C")    return	getLabel("eAM.Closest.label","AM");
	if(objVal == "P")    return	getLabel("Common.previous.label","Common");
	if(objVal == "TM")   return	getLabel("eAM.10thminute.label","AM");
	if(objVal == "FM")   return	getLabel("eAM.5thminute.label","AM");
	if(objVal == "QH")   return	getLabel("eAM.QuarterHour.label","AM");
	if(objVal == "H")    return	getLabel("eAM.Hourly.label","AM");
	if(objVal == "M")    return	getLabel("Common.Minute.label","Common");
}

/***********************************************************************************/
function compareTime(time1,time2){//if time1 > time2  true or else false
var tem1 = time1.replace(":",".");
var tem2 = time2.replace(":",".");
return parseFloat(tem1) >= parseFloat(tem2);
}

/***********************************************************************************/
function compareTime1(time1,time2){//if time1 > time2  true or else false

 tem1 = time1.replace(":",".");
tem2 = time2.replace(":",".");
 b=parseFloat(tem1) == parseFloat(tem2);

return b;
}

/***********************************************************************************/
function removeOptions(){
getHandle();
document.getElementById("freqLegend").innerHTML = "&nbsp;";
    document.getElementById("timeLegend").innerHTML = "&nbsp;";
    document.getElementById("timeLegend").innerHTML = "&nbsp;";
//doc.all.days.innerHTML		 ="&nbsp";
}

/***********************************************************************************/
function showSelected(){
getHandle();
htmlStr = "<b>Times for " 

for(i = 1; i <= 7 ; i++){

	var day			  = eval("formObj.daySM"+ i );	
	

	var dayDisplayObj = document.getElementById("dayDisplay" + i);

	
	if(day.checked == true)//showDaySelect feild is dynamically inserted in the form when days is seleted
	htmlStr += dayDisplayObj.value + "/";
}

	var indx =  htmlStr.lastIndexOf("/");
	if(parseInt(indx) != -1)
	document.getElementById("showDaySelect").innerHTML = htmlStr.substring(0, indx);
	else
	document.getElementById("showDaySelect").innerHTML = "&nbsp;";

}

/***********************************************************************************/
function timeChk(time1){

var time = time1.value;

var	retFlag = true ;

if(time == "" || time ==null)
return ;

getHandle();


if(durationType == "H" || durationType == "M" ){
	if(!chkTimeLocal(time))
	retFlag = false
}else{//This Validation when duration Type is Day or Week 
	if(!chkTime(time))
	retFlag = false	
}


if(!retFlag){
	time1.value="";	
	time1.focus();

	if(durationType == "H" || durationType == "M") //Plx get Message from eCommom/messages.js ---Odl architexture
	var message  = getMessage("VALID_TIME_SLOTS","AM"); 
	else
	var message  = getMessage("INVALID_TIME_FMT","SM"); 
	
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	return false ;
}else{
	roundOf(time1) ;
	var message  = "";	
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
}	


}

/***********************************************************************************/
function roundOf(obj){
	var round	= 0 ;
	var time	= obj.value ;
	
	

	if(time == "")
		return ;
		

	var indx	= time.indexOf(":");
	var hrs		= time.substring(0,indx);
	var mins	= time.substring(indx+1,time.length);





	var i=parent.frames[2].frames[1].document.forms[0].chkval.value;
	var temp=parent.frames[2].frames[1].document.forms[0].chkvaltemp.value
		var tempvalue=parent.frames[2].frames[1].document.forms[0].chkvaltemp1.value
	
	var split1=temp.split("|"); var dec;
	var split2=tempvalue.split("~");
	for (var z=0;z<split1.length;z++)
	{
		if(split1[z]==obj.name && split2[z]==obj.value)
		{
		  dec=10;
		 
		}
	}
	
	 if(dec!=10)
		 i=1;
	
	if(startTimeRound == "" || startTimeRound == null)//if no round of
		return ;

	if(startTimeAssign == "" || startTimeAssign == null)//if no round of
		startTimeAssign = "C" ;


	mins = formatMin(mins);
	obj.value = hrs + ":" + mins;

		
	if(startTimeRound == "FM")
	round = 5;
	
	if(startTimeRound == "TM")
	round = 10;
	
	if(startTimeRound == "QH")
	round = 15;
	
	if(startTimeRound == "H")
	round = 60;
	
	if(startTimeRound == "M")
	{
		if(parseFloat(mins%5)==0)
			round=59;
		else
		round=5;
	}
																

	

 if(parseFloat(mins%round) != 0 && i==1)  { //i:e value is to be rounded off

		if(startTimeRound == "M")//Change to min----------->>unusal requirement
		round = 1;	
	
		var dif = parseFloat(mins) - parseFloat(mins%round) ;
		
		var i=1;

	if(startTimeRound == "M" ) //round -off for minute start
		{
			
			if(startTimeAssign == "N" ){
				mins = dif  + 1 ;
			}
		
		
			if(startTimeAssign == "P"){
				mins = dif  - 1;	
			}
		

			if(startTimeAssign == "C" ){
				if(parseFloat(mins%5) < 3  ){
				mins = dif  - 1;
				}else{
				mins = dif  + 1 ;
			    }
		 	}

	}else{//round -off other than minute 

				
				if(startTimeAssign == "N" ){
				mins = dif +  round ;
				}
		
				if(startTimeAssign == "P")
				mins = dif ;	


				if(startTimeAssign == "C" ){

					var chkVal = "";

					if(startTimeRound == "FM")
					chkVal = 3;
					if(startTimeRound == "TM")
					chkVal = 6;
					if(startTimeRound == "QH")
					chkVal = 3;
					if(startTimeRound == "H")
					chkVal = 3;

			
					if(parseFloat(mins%round) < parseFloat(chkVal)   )
					mins = dif ;
					else
					mins = dif +  round ;
				
				}

		  }//End of rounding of other than min


   if(mins == 60 ){//if min comes to 60 add hrs

			if(durationType == "H" || durationType == "M"){
			obj.value = "00" + ":" + "59";
			return ;
			}

			obj.value = parseFloat(hrs) + 1 + ":" + "00";

			if(obj.value == "24:00")//if time comes to 24:00 make it to 23:59
			obj.value = "23:59";
		
	 }else{
			mins = formatMin(mins);
			obj.value = hrs + ":" + mins;
	 }

	}//End of rounding alogoritm
	i=eval(i+1);
	parent.frames[2].frames[1].document.forms[0].chkval.value=i;
	parent.frames[2].frames[1].document.forms[0].chkval.value;
	var temp1=parent.frames[2].frames[1].document.forms[0].chkvaltemp.value;
	parent.frames[2].frames[1].document.forms[0].chkvaltemp.value=temp+obj.name+"|";
    parent.frames[2].frames[1].document.forms[0].chkvaltemp1.value=tempvalue+obj.value+"~";

	
	//var temp=obj.name;
}
/**********************Detail Handle**********************************/
function getHandle(){
 doc		 =f_query_add_mod.document ;	
 formObj	 =doc.scheduleFreqencyAddMod ;
}
/********************On Success*********************************/
function onSuccess(){
getHandle();
mode = formObj.mode.value ;
if(mode == MODE_INSERT){
	intialisation();
	removeOptions();
	formObj.reset();
}else{
f_query_add_mod.document.location.href="../../eAM/jsp/ScheduleFrequencyAddModify.jsp?"+formObj.qry_str.value ;
}
}
/**********called on load of page meant for update mode to chk days already in the dataBase********************/
/*function chkCheckedBox (){
getHandle();
var  mode = formObj.mode.value;


if(mode == "2"){

	durationType					= formObj.durationType.value ;
	repeatValue						= formObj.repeat.value;
	startTimeRound					= formObj.start_time_round_p.value ;
	startTimeAssign					= formObj.start_time_assign_p.value;

	var updateString = formObj.chkDaysUpdate.value ;
	
	if(updateString == "")
	return ;

	var arrDays = updateString.split("|");

	for( i=0 ; i<arrDays.length;i++){//Chk those which  are already in the database
		for(j = 1; j <= 7 ; j++)
		{
			var day = eval("formObj.daySM"+ j );

			 if(arrDays[i] == day.value)
				day.checked = true ;
		}
	}
	showSelected();
	}

}*/
/**************************************************************************/
function reset() {
	if(f_query_add_mod.document.forms[0].name == "scheduleFreqencyAddMod"){//add Modify mode
		getHandle();
		formObj.reset();
		if(formObj.mode.value == MODE_INSERT){//insert mode
		removeOptions();
		}else{
		//chkCheckedBox();
		}
	}else{
		f_query_add_mod.document.forms[0].reset()//Query Mode

	}
}
/***********************************************************************/
function formatMin(objValO){
var objVal = "" + objValO ; //this assign to make parseFloat to String
	if(parseFloat(objVal) < 10){
		if( ("" + objVal.length) < 2  )
			return	("0" + objVal);
		else
			return objVal ;
	}else
		return	 objVal ;
}
/*****************************************************************************/
function chkTimeLocal(time1) //This Cheking Only when duration type is hours
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

					time1hr=parseFloat(time1hr)
					time1min=parseFloat(time1min)

					if(parseFloat(time1hr) <= 0)
					{
						if(time1min>=60)
						{
								retval=false;
					  	}
					}else{
						retval=false;
						}
				}else{
					retval=false;
					}
			}else{
				retval=false;
			}

			return retval
}




function delValue()
{
	
	parent.frames[1].document.forms[0].chkvaltemp1.value="";
		parent.frames[1].document.forms[0].chkval.value="";
}

