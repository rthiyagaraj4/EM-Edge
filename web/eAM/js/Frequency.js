function checkIsValidForProceed( )
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!=-1) || (url.indexOf("querycriteria")!=-1) )
		return false;
	else
		return true;
}

function create() 
{
	f_query_add_mod.location.href =  "../../eAM/jsp/FrequencyAddModify.jsp?mode=insert&function_id=Frequency";
}
function query()
{
	f_query_add_mod.location.href="../../eAM/jsp/FrequencyQueryCriteria.jsp?function_id=Frequency";
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }

function apply()
{
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */

var messageFrame = frames[2]; 

	if(f_query_add_mod.document.frequency_form.mode.value=="insert")
	{
		if (!checkIsValidForProceed( ) )
		{
			var message  = getMessage("NOT_VALID","Common"); 
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		}
		else
		{	
			var fields = new Array (f_query_add_mod.document.frequency_form.code);
			var names  =  new Array (getLabel("Common.code.label","Common"));
		//	var messageFrame = parent.frames[1].frames[2]; 
			
			var error_page = "../../eCommon/jsp/MstCodeError.jsp";
			if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
			{  
				var	formObj	= f_query_add_mod.document.frequency_form ;				
				if(formObj.freq_nature.value=="F")
				{
				
				var fields = new Array ( formObj.code,formObj.freq_desc,formObj.repeat,formObj.repeatC,formObj.every,formObj.everyC);
				var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"),getLabel("eAM.RepeatFrequencyValue.label","am"),getLabel("eAM.RepeatFrequencyType.label","am"),getLabel("eAM.EveryFrequencyValue.label","am"),getLabel("eAM.EveryFrequencyType.label","am"));
				if(f_query_add_mod.checkFieldsofMst(fields, names, messageFrame))
				{
					formObj.everyC.value=formObj.repeatC.value;
					if(formObj.enable.checked==true)formObj.enable.value="E";
					else formObj.enable.value="";
					/*if(formObj.repeat.value==0&&formObj.every.value==0)
					{
						//var message  =" In Repeat Frequency value and Interval Freqency value   zero can not be entered..." ;
						var message  =getMessage("AM0111","AM") ;
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						return false ;
					}
					if(formObj.repeat.value==0)
					{
						//var message  ="Repeat Duration value zero can not be entered..." ;
						var message  =getMessage("AM0110","AM") ;
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						return false ;
					}
					if(formObj.every.value==0)
					{
						//var message  ="Interval Duration value zero can not be entered..." ;
						var message  =getMessage("AM0109","AM") ;
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						return false ;
					}*/
					
					f_query_add_mod.document.frequency_form.submit();
				}
			}
			else if(formObj.freq_nature.value=='I')
			{
				var fields = new Array ( formObj.code,formObj.freq_desc,formObj.every,formObj.everyC);
				var names = new Array ( getLabel("Common.FrequencyCode.label","Common"),getLabel("Common.FrequencyDescription.label","Common"),getLabel("eAM.EveryIntervalValue.label","am"),getLabel("eAM.EveryIntervalType.label","am"));
				if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
				{

				
					if(formObj.enable.checked)
						formObj.enable.value="E";
					else
						formObj.enable.value="";
					formObj.repeat.value="1";
   					formObj.scheduled_yn.value="N";	
					formObj.start_time_assign.value="T";
					formObj.repeatC.value=formObj.everyC.value;
					
					f_query_add_mod.document.frequency_form.submit();
				}
			}
			// Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
			else if(formObj.freq_nature.value=='Y')
			{	
				var MaxCycle = parseInt(formObj.MaxCycle.value);
				var fields = new Array ( formObj.code,formObj.freq_desc,formObj.MaxCycle,formObj.repeat,formObj.repeatC);
				var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"),getLabel("eAM.MaxCycle.label","am"),getLabel("eAM.RepeatFrequencyValue.label","am"),getLabel("eAM.RepeatFrequencyType.label","am"));
				if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
				{	
					// Added by Sangeetha on 7th Aug 2017 for ML-MMOH-CRF-0345.2 US003
					if(formObj.repeatC.value == "L" && MaxCycle > 12){
						alert(getMessage("MAX_REPEATS_ALLOWED_FOR_MONTH","AM"));
						formObj.MaxCycle.focus();
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
						return;
					}
					else
					{
						f_query_add_mod.document.frequency_form.submit();
					}
				}
			}
			else
			{
				if(formObj.enable.checked)
					formObj.enable.value="E";
				else
					formObj.enable.value="";
				var fields = new Array ( formObj.code,formObj.freq_desc);
				var names = new Array ( getLabel("Common.FrequencyCode.label","Common"),getLabel("Common.FrequencyDescription.label","Common"));
				if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
				{
					f_query_add_mod.document.frequency_form.submit();

				}
			}
		}
		}	
	}// for insert end

	//modify start
	if(f_query_add_mod.document.frequency_form.mode.value=="modify")
	{


		var	formObj	= f_query_add_mod.document.frequency_form ;
	//	var messageFrame = parent.frames[1].frames[2]; 
		if(formObj.enable.checked)
  			formObj.enable.value="E";
		else 
			formObj.enable.value="";

		var fields = new Array( formObj.code,formObj.freq_desc);
		var names = new Array(getLabel("Common.FrequencyCode.label","Common"),getLabel("Common.description.label","Common"));
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		if(formObj.freq_nature.value=="F")
		{
			//var fields = new Array ( formObj.freq_desc);
			//var names = new Array ( getLabel("Common.description.label","Common"));
			//if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			//{
				formObj.everyC.value=formObj.repeatC.value;
				f_query_add_mod.document.frequency_form.start_time_assign.disabled=false;
				f_query_add_mod.document.frequency_form.round_to.disabled=false;
				f_query_add_mod.document.frequency_form.submit();
			//}
		}
		else if(formObj.freq_nature.value=="I")
		{
			//var fields = new Array ( formObj.freq_desc);
			//var names = new Array (getLabel("Common.description.label","Common"));
			//if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			//{
				formObj.repeatC.value=formObj.everyC.value;
				f_query_add_mod.document.frequency_form.start_time_assign.disabled=false;
				f_query_add_mod.document.frequency_form.round_to.disabled=false;
				f_query_add_mod.document.frequency_form.submit();
			//}
		}
		//Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
		else if(formObj.freq_nature.value=="Y")
		{
				f_query_add_mod.document.frequency_form.start_time_assign.disabled=false;
				f_query_add_mod.document.frequency_form.round_to.disabled=false;
				f_query_add_mod.document.frequency_form.submit();
			
		}
		else
		{
			//var fields = new Array ( formObj.freq_desc);
			//var names = new Array (getLabel("Common.description.label","Common"));
			//if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			//{
				f_query_add_mod.document.frequency_form.start_time_assign.disabled=false;
				f_query_add_mod.document.frequency_form.round_to.disabled=false;
				f_query_add_mod.document.frequency_form.submit();
			//}
		}
	}
	//	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}//modify ends here
		
}//apply ends here

function reset()
{
	
	
	if(f_query_add_mod.document.forms[0].name == "frequency_form" ) 
	{
		var mode= f_query_add_mod.document.frequency_form.mode.value;
   		if(mode == "modify")
		{
			f_query_add_mod.document.frequency_form.reset() ;
		}
		else
		{
			f_query_add_mod.location.href =  "../../eAM/jsp/FrequencyAddModify.jsp?mode=insert&function_id=Frequency";
		}
		
	}
	
	else 
	{
		f_query_add_mod.document.forms[0].reset();
	}
}

// function that check the number r only  numeric
function CheckForNumber(event)
{
    var strCheck = '1234567890';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

// function that set the default time 
function setStart1Time(obj)
{
	if(parent.f_query_add_mod.document.frequency_form.freq_nature.value=="F" && parent.f_query_add_mod.document.frequency_form.checkit.checked==true)
	{
		document.frequency_form.start_time_assign.remove("4");
	}
	if(obj.checked==true)
	{
		var sch=parent.f_query_add_mod.document.frequency_form.scheduled.value;
		sch="Y";
		setStartTime(sch);
		document.frequency_form.scheduled_yn.value="Y";
	}
	else
	{
		
		var sch=parent.f_query_add_mod.document.frequency_form.scheduled.value;
		sch="N";
		setStartTime(sch);
		document.frequency_form.scheduled_yn.value="N";
	}
}

function setStartTime(sch)
{
	
		
	if(sch=='N')
	{
		var opt=document.createElement("OPTION");
		opt.text=getLabel("eAM.CurrentTime.label","AM");
		opt.value="C";
		opt.index='1';
		document.frequency_form.start_time_assign.add(opt);
		var  check= document.getElementById('frequency_form').freq_nature;
		document.getElementById('frequency_form').start_time_assign.selectedIndex= '1';
		document.getElementById('frequency_form').start_time_assign.disabled=true;
		document.getElementById('frequency_form').round_to.value="";	
		document.getElementById('frequency_form').round_to.disabled=true;
		document.getElementById('frequency_form').scheduled.checked=false;
		document.frequency_form.scheduled_yn.value="N";
		if(check.value=='F')
			document.getElementById('frequency_form').start_time_assign.selectedIndex='4';
		if(check.value=='I')
		{
			document.getElementById('frequency_form').scheduled.disabled=true;
			document.getElementById('frequency_form').start_time_assign.selectedIndex='4';
		}
	}//if end here 
	else
	{
		var  check= document.getElementById('frequency_form').freq_nature;
		document.getElementById('frequency_form').scheduled1.checked=false;
		document.getElementById('frequency_form').start_time_assign.selectedIndex='1';
		document.frequency_form.scheduled_yn.value="Y";
		if((check.value=='C')||(check.value=='P')||(check.value=='O'))
		{
			document.getElementById('frequency_form').start_time_assign.selectedIndex= '1';
			document.getElementById('frequency_form').start_time_assign.disabled=true;
			document.getElementById('frequency_form').round_to.disabled=true;
		}
		else
		{
			document.frequency_form.start_time_assign.remove("4");
			document.getElementById('frequency_form').start_time_assign.disabled=false;
			document.getElementById('frequency_form').scheduled1.checked=false;
			document.getElementById('frequency_form').round_to.disabled=false;
		}
	}

}

function setEvery1(obj)
{
	if(obj.value=='I')
	{
		
		
		document.getElementById('frequency_form').scheduled_yn.value='N';
		var opt=document.createElement("OPTION");
		opt.text=getLabel("eAM.CurrentTime.label","AM");
		opt.value="C";
		if(document.getElementById('frequency_form').scheduled1.value=="N")
		{
			document.frequency_form.start_time_assign.add(opt);
		}

		// Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
		document.getElementById("TimeAssign").style.visibility='visible';
		document.getElementById("RoundTo").style.visibility='visible';

		document.getElementById('tab_max').innerHTML=""; // Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
		document.getElementById('tab1').innerHTML=getLabel("Common.Every.label","Common");
		document.getElementById('tab2').innerHTML="<input type='text'  maxlength=6 name='every' id='every' size='6' onkeypress='return CheckForNumber(event);' style='text-align:right'>&nbsp;<input type='hidden' name='repeat' id='repeat' value='1'><input type='hidden' name='repeatC' id='repeatC' value=''><select name='everyC' id='everyC'  onChange='setIntervals(this);'><option value=''>&nbsp;&nbsp;--- "+getLabel("Common.defaultSelect.label","Common")+" ---&nbsp;&nbsp;</option><option value=M>"+getLabel("Common.Minute.label","Common")+"(s)</option><option value=H selected>"+getLabel("Common.hours.label","Common")+"(s)</option></select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
		document.getElementById("tab3").innerHTML="";
		if(document.getElementById('frequency_form').scheduled.value=="Y")
		{
		  document.getElementById('frequency_form').scheduled.value="N";
		  document.getElementById('frequency_form').scheduled.disabled=true;
		}
		if(document.getElementById('frequency_form').scheduled1.value=="Y")
		{
			document.getElementById('frequency_form').scheduled1.value="Y";
			document.getElementById('frequency_form').scheduled1.disabled=true;
			document.getElementById('frequency_form').scheduled.disabled=true;
		}
		if(document.getElementById('frequency_form').scheduled1.value=="N")
		{
			document.getElementById('frequency_form').scheduled1.value="Y";
			document.getElementById('frequency_form').scheduled1.disabled=true;
		}
		document.getElementById('frequency_form').round_to.disabled=true;
		document.getElementById('frequency_form').start_time_assign.selectedIndex='1';
		document.getElementById('frequency_form').start_time_assign.disabled=true;	
		document.getElementById('frequency_form').scheduled_yn.value='N';
		document.getElementById('frequency_form').checkit.checked=false;
		document.getElementById('frequency_form').checkit.disabled=true;
		if(document.getElementById('frequency_form').checkit.checked==true)setStartTime(parent.f_query_add_mod.document.frequency_form.scheduled);
		else
			setStartTime(parent.f_query_add_mod.document.frequency_form.scheduled1);
		
		
		var opt = document.createElement("OPTION");
		opt.text = getLabel("eAM.CurrentTime.label","AM") ;
		opt.value = "T" ;
		document.getElementById('frequency_form').start_time_assign.add(opt);
		document.getElementById('frequency_form').start_time_assign.selectedIndex = 4;
		document.getElementById('frequency_form').start_time_assign.disabled=true;
		document.getElementById('start_time_assign_temp').value="T";
		document.getElementById('frequency_form').round_to.disabled=true;
		
		
	}
	else if(obj.value=='F')
	{
		document.frequency_form.start_time_assign.remove("4");
		if(document.frequency_form.checkit.checked==false)
		{	
			document.frequency_form.checkit.checked=true;
		}

		// Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
		document.getElementById('TimeAssign').style.visibility='visible';
		document.getElementById('RoundTo').style.visibility='visible';

		document.getElementById('tab1').innerHTML="";
		document.getElementById('tab_max').innerHTML=""; // Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
		document.getElementById("tab2").innerHTML="<input id='repeat'  type='text' name='repeat' size='6' maxlength=6  onkeypress='return CheckForNumber(event);' style='text-align:right'><img src='../../eCommon/images/mandatory.gif'></img> Repeat Per&nbsp;<select id='repeatC'  name='repeatC' onchange='setInterval(this)'><option value=''>&nbsp;&nbsp;--- "+getLabel("Common.defaultSelect.label","Common")+" ---&nbsp;&nbsp;</option><option value=M>"+getLabel("Common.Minute.label","Common")+"(s)</option><option value=H>"+getLabel("Common.hours.label","Common")+"(s)</option><option value=D>"+getLabel("Common.day.label","Common")+"(s)</option><option value=W>"+getLabel("Common.Week.label","Common")+"(s)</option><option value=L>"+getLabel("Common.month.label","Common")+"(s)</option></select><img src='../../eCommon/images/mandatory.gif'></img>";
		document.getElementById('tab3').innerHTML=getLabel("Common.Every.label","Common")+"&nbsp;&nbsp;<input id='every'  type='text' name='every' size='6' maxlength=6 onkeypress='return CheckForNumber(event);' style='text-align:right'>&nbsp;<input id=everyC  type=text name=everyC onChange='setInterval(this)' size=8 maxlength=8><img src='../../eCommon/images/mandatory.gif'></img>";
		document.getElementById('frequency_form').round_to.disabled=false;
		document.getElementById('frequency_form').scheduled_yn.value='Y';
		document.getElementById('frequency_form').start_time_assign.disabled=false;
		document.getElementById('frequency_form').start_time_assign.selectedIndex=1;
		if(document.getElementById('frequency_form').scheduled.value=="N")
		{
			document.getElementById('frequency_form').scheduled.disabled=false;
			document.getElementById('frequency_form').scheduled.value="Y";
		}
		if(document.getElementById('frequency_form').scheduled1.value=="Y")
		{
			document.getElementById('frequency_form').scheduled1.disabled=false;
			document.getElementById('frequency_form').scheduled1.value="N";
		}
			document.getElementById('frequency_form').checkit.checked=true;
			document.getElementById('frequency_form').checkit.disabled=false;
	
		if(document.getElementById('frequency_form').checkit.checked==true)
			setStartTime(parent.f_query_add_mod.document.frequency_form.scheduled);
		else
			setStartTime(parent.f_query_add_mod.document.frequency_form.scheduled1);
	}
	//Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2 - START
	else if(obj.value=='Y')
	{
		if(document.frequency_form.checkit.checked==false)
		{	
			document.frequency_form.checkit.checked=true;
		}
		document.getElementById("TimeAssign").style.visibility='hidden';
		document.getElementById("RoundTo").style.visibility='hidden';
		document.getElementById('start_time_assign').value="";
		
		document.getElementById('tab1').innerHTML="";

		document.getElementById("tab_max").innerHTML="<input type='text'  maxlength=2 name='MaxCycle' id='MaxCycle' value='' size='6' onkeypress='return CheckForNumber(event);' onBlur='CheckNum(this);return valid_dat(this);' style='text-align:right'><img src='../../eCommon/images/mandatory.gif'></img>&nbsp;"+getLabel('eAM.MaxCycle.label','am_labels')+"";

		document.getElementById('tab2').innerHTML="<input type='text' name='repeat' id='repeat' size='6' maxlength=2  onkeypress='return CheckForNumber(event);' onBlur='CheckNum(this);return valid_dat(this);' style='text-align:right'><img src='../../eCommon/images/mandatory.gif'></img> Repeat(s) Per&nbsp;<select name='repeatC' id='repeatC'><option value=''>&nbsp;&nbsp;--- "+getLabel("Common.defaultSelect.label","Common")+" ---&nbsp;&nbsp;</option><option value=D>"+getLabel("Common.day.label","Common")+"(s)</option><option value=W>"+getLabel("Common.Week.label","Common")+"(s)</option><option value=L>"+getLabel("Common.month.label","Common")+"(s)</option></select><img src='../../eCommon/images/mandatory.gif'></img>";
		document.getElementById('tab3').innerHTML="";
		
			document.getElementById('frequency_form').checkit.checked=true;
			document.getElementById('frequency_form').checkit.disabled=false;
	

	}
	//END
	else
	{
		// Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
		document.getElementById("TimeAssign").style.visibility='visible';
		document.getElementById("RoundTo").style.visibility='visible';

		document.getElementById('tab1').innerHTML="";
		document.getElementById("tab_max").innerHTML=""; // Added by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
		document.getElementById('tab2').innerHTML="";
		document.getElementById('tab3').innerHTML="";
		if(document.getElementById('frequency_form').scheduled.value=="Y")
		{
		  document.getElementById('frequency_form').scheduled.value="N";
  		  document.getElementById('frequency_form').scheduled.disabled=true;
		}
		if(document.getElementById('frequency_form').scheduled1.value=="N")
		{
			document.getElementById('frequency_form').scheduled1.value="Y";
			document.getElementById('frequency_form').scheduled1.disabled=true;
		}
		document.getElementById('frequency_form').round_to.disabled=true;
		document.getElementById('frequency_form').start_time_assign.selectedIndex='4';
		document.getElementById('frequency_form').start_time_assign.disabled=true;
		

		/* Added on 31st Jan 2003 by Prakash.S**/
		var opt = document.createElement("OPTION");
		opt.text = getLabel("eAM.CurrentTime.label","AM") ;
		opt.value = "T" ;
		document.getElementById('frequency_form').start_time_assign.add(opt);
		document.getElementById('frequency_form').start_time_assign.selectedIndex = 4;
		document.getElementById('frequency_form').start_time_assign.disabled=true;
		document.getElementById('start_time_assign_temp').value="T";
		document.getElementById('frequency_form').round_to.disabled=true;
		/* Ends**/

		document.getElementById('frequency_form').scheduled_yn.value='N';
		document.getElementById('frequency_form').checkit.checked=false;
		document.getElementById('frequency_form').checkit.disabled=true;
		document.getElementById('frequency_form').start_time_assign.selectedIndex = 4;
		/**/
	}
}


////////////////////////////////////////
function setSchedule(start)
{
	if((document.getElementById('frequency_form').scheduled.value=="Y")||
		(document.getElementById('frequency_form').freq_nature.selectedIndex=='1'))
	{
		if(	document.getElementById('frequency_form').start_time_assign.selectedIndex=='4')
		{
			document.getElementById('frequency_form').start_time_assign.selectedIndex='0';
		}
	}

}
///////////////////////////
function setInterval(obj)
{
	
	var check = document.getElementById('frequency_form').checkit.checked;
	constructOptions(obj,check);
	if(document.getElementById('frequency_form').freq_nature.value=='F')
	{
		document.getElementById('frequency_form').everyC.disabled=false;
		document.getElementById('frequency_form').everyC.selectedIndex=document.getElementById('frequency_form').repeatC.selectedIndex
		document.getElementById('frequency_form').everyC.disabled=true;
	}
	if(document.getElementById('frequency_form').repeatC.value=="")
	{
		document.getElementById('frequency_form').everyC.value="";
		document.getElementById('frequency_form').everyC.disabled=true;
	}
	else
	{
		
	}
	var string;//</option><option value=M>Minute(s)</option><option value=H>Hour(s)</option><option value=D>Day(s)</option><option value=W>Week(s)</option><option value=L>Month(s)</option>
	if(obj.value=="M"){string="Minute(s)";}
		else if(obj.value=="H"){string="Hour(s)";}
		else if(obj.value=="D"){string="Day(s)";}
		else if(obj.value=="W"){string="Week(s)";}
		else if(obj.value=="L"){string="Month(s)";}
		else string="";

		document.getElementById('frequency_form').everyC.value=string;
}



function onSuccess()
{

f_query_add_mod.location.reload() ;
}

function setIntervals(obj){

}


function constructOptions(obj, obj2){
	var optionString ="<select name='round_to' id='round_to'> "+
					  " <option value=''>&nbsp;&nbsp;&nbsp;--- "+getLabel("Common.defaultSelect.label","Common")+" ---&nbsp;&nbsp;&nbsp;</option> "+
					  " <option value='M'>"+getLabel("Common.Minute.label","Common")+"</option> "+
					  " <option value='FM'>"+getLabel("eAM.5thminute.label","AM")+"</option> "+
					  " <option value='TM'>"+getLabel("eAM.10thminute.label","AM")+"</option> "+
					  " <option value='QH'>"+getLabel("eAM.QuarterHour.label","AM")+"</option>";
					  
	if((obj.value == "M") ){

		
		document.getElementById('frequency_form').checkit.checked=false;
		document.getElementById('frequency_form').checkit.disabled=true;
		document.frequency_form.scheduled_yn.value="N";
		document.getElementById("round_to").disabled=true;
		//document.forms[0].all.round_to.disabled=true;
		document.getElementById('frequency_form').start_time_assign.disabled=true;
	}
	else if((obj.value == "H")){
		document.getElementById('frequency_form').checkit.checked=true;
		document.getElementById('frequency_form').checkit.disabled=false;
		document.frequency_form.scheduled_yn.value="Y";
		document.getElementById("round_to").disabled=false;
		//document.forms[0].all.round_to.disabled=false;
		document.getElementById('frequency_form').start_time_assign.disabled=false;
		optionString  += "	</select> ";
		document.getElementById("roundID").innerHTML = optionString;
		//document.forms[0].all.roundID.innerHTML = optionString;
	}
	else if((obj.value =="D") || (obj.value=="W") || (obj.value == "L") ){
		document.getElementById('frequency_form').checkit.checked=true;
		document.getElementById('frequency_form').checkit.disabled=false;
		document.frequency_form.scheduled_yn.value="Y";
		document.getElementById("round_to").disabled=false;
		//document.forms[0].all.round_to.disabled=false;
		document.getElementById('frequency_form').start_time_assign.disabled=false;
		optionString  += " <option value='H'>"+getLabel("eAM.Hour.label","AM")+"</option>";
		optionString  += " </select> ";
		document.getElementById("roundID").innerHTML = optionString;
	}else if(obj.value==""){
		document.getElementById('frequency_form').checkit.checked=true;
		document.getElementById('frequency_form').checkit.disabled=false;
		document.frequency_form.scheduled_yn.value="Y";
		document.getElementById("round_to").disabled=false;
		//document.forms[0].all.round_to.disabled=false;
		document.getElementById('frequency_form').start_time_assign.disabled=false;
		optionString = "<select id='round_to'  name='round_to'> "+
					  " <option value=''>&nbsp;&nbsp;&nbsp;--- "+getLabel("Common.defaultSelect.label","Common")+" ---&nbsp;&nbsp;&nbsp;</option>"; 
		document.getElementById("roundID").innerHTML = optionString;
		//document.forms[0].all.roundID.innerHTML = optionString;
	}
	if(!obj2){
		document.getElementById("round_to").value="";
		//document.forms[0].all.round_to.value="";
		//document.forms[0].all.round_to.disabled=true;
	}
}

