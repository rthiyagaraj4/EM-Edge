/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559        DineshT      Record consent criteria in TaskList function
26/10/2012    IN032816       Chowminya G     Result Reporting > Record Clinical Note > Mark Error 
09/01/2014	  IN045571		Nijitha S	 TTM-SCF-0060	
21/04/2014	  IN047658		Vijayakumar K		14/03/2014		Chowminya G		Reopen - Result Reporting > Result Entry ?Comments-webpage
12/24/2015    IN058157      ManojKumar KV      Task list - currently the task list is displaying by one day. Users want to view by a range of dates
02/12/2023               Srinivasa N T                     Ramesh G                        AAKH-crf-0165
---------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 			10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
19/10/2017	IN065324			Dinesh T				19/10/2017		Ramesh G		To display the price in OR screen and 																						the billing status in Manage Specimen 																						screen
15/12/2017	IN065942	Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
03/01/2018	IN066125			Dinesh T				03/01/2017		Ramesh G		EM run on window 10 and IE 11
																						Vaccine course display schedule before select, displayed wrong icon symbol, unscheduled displayed in pending Rx for MAR
14/03/2019	IN068778			Selvin M				14/03/2019		Ramesh G         TBMC-CRF-0011
25/03/2019      IN069244             Ramya Maddena            25/03/2019       Ramesh G
14/10/2019  IN071315	    	Nijitha S   			14/10/2019  	Ramesh G		GHL-CRF-0607
13/04/2020	IN072674		Ramesh Goli				13/04/2020		Ramesh G		MMS-KH-CRF-0032
23/04/2020	  IN071618	     Nijitha S					23/04/2020  	Ramesh G		PMG2019-MMS-CRF-0004
31/05/2021  IN017999            ChandraShekar a                                         AAKH-CRF-0132.1
27/06/2021  IN020763           Chandrashekar a                                          AAKH-CRF-132.1
27/07/2022	26826			Ramesh G											MMS-DM-CRF-0197
-------------------------------------------------------------------------------------------------------------------------------
*/ 

var currClass;
var prev_anchor="";

var disappeardelay= 250;
var headTop = -1;
var FloatHead1;

// Added by Sridhar Reddy on 08/12/2008
var prevObjID;
var prevImgObj;
var interval=0;//aakh-crf-0165
//end
//IN072674 Start.
function dateCheckingNew(from,to,locale,selectedSubFunciton){
	if(selectedSubFunciton=="V"){
		if(dateCheckNew(from,locale) && dateCheckNew(to,locale))
		{
			if(!isAfter(to.value,from.value,"DMYHM",locale))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); 
				//to.select();
				to.value="";
				to.focus();
				return false;
			}
		}
	}else{
		dateChecking(from,to,locale);
	}
}
//IN072674 End.
function dateChecking(from,to,locale)
{

	if(dateCheck(from,locale) && dateCheck(to,locale))
	{
		if(!isAfter(to.value,from.value,"DMY",locale))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); 
			//to.select();
			to.value="";
			to.focus();
			return false;
		}
	}
}

function dateCheck(obj,locale)
{
	if(obj.value != '')
	{
		if(!validDateObj(obj,"DMY",locale))
		{
			return false;
		}
		else
			return true;
		/*{
			if(!(isBeforeNow(obj.value,"DMY",locale) ))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				obj.select();
				obj.focus();
				return false;
			}
		}
		return true;*/
	}
}
//IN072674 Start.
function dateCheckNew(obj,locale)
{
	if(obj.value != '')
	{
		if(!validDateObj(obj,"DMYHM",locale))
		{
			return false;
		}
		else
			return true;
		
	}
}
//IN072674 End.
function processScroll()
	{
		if (headTop < 0)
		{
			saveHeadPos();
			
		}
		if (headTop>0)
		{
			if (document.documentElement && document.documentElement.scrollTop)
				theTop = document.documentElement.scrollTop;
			else if (document.body)
				theTop = document.body.scrollTop;

			if (theTop>headTop)
				FloatHead1.style.top = (theTop-headTop) + 'px';
			else
				FloatHead1.style.top = '0px';
		}
	}

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead1 = document.getElementById("heading");
			FloatHead1.style.position = "relative";
		}
	}

function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	//document.getElementById(str).focus();
	return flg;
}

function checkgroupby()
{
	populateValues();
}

function taskTypeBold(code)
{  
	var field ="";
	var taskTypeArr = new Array();
	taskTypeArr[0] = "A";
	taskTypeArr[1] = "I";
	taskTypeArr[2] = "M";
	taskTypeArr[3] = "O";
	taskTypeArr[4] = "S";
	taskTypeArr[5] = "R";		
	taskTypeArr[6] = "B";		
	taskTypeArr[7] = "C"; //Chowminya
	taskTypeArr[7] = "V";//IN069244

	if (document.TaskStatusForm.c_task_Select.value != "")
	{		
		prev_anchor = document.TaskStatusForm.c_task_Select.value;	
		document.TaskStatusForm.c_task_Select.value = "";
		prev_anchor = document.getElementById(prev_anchor);
	}	
	for (var i=0;i<taskTypeArr.length ;i++ )
	{		
		if(code=="" && taskTypeArr[i] == "A")
		{	
			field = document.getElementById(taskTypeArr[i]);
			field.style.color='#0000FF';
			field.style.fontWeight='bold';

			if(prev_anchor!=null&&prev_anchor!="")
			{
				if(field!=prev_anchor)
				{
					prev_anchor.style.color='#000066';
					prev_anchor.style.fontWeight='normal';							
				}
			}
			prev_anchor = document.getElementById("A");
			
		  }
		  else if (code == taskTypeArr[i])		
		  {	
			field = document.getElementById(taskTypeArr[i]);
			field.style.color='#0000FF';
			field.style.fontWeight='bold';
			if(prev_anchor!=null&&prev_anchor!="")
			{
				if(field!=prev_anchor)
				{
					prev_anchor.style.color='#000066';
					prev_anchor.style.fontWeight='normal';						
				}
			}
			document.getElementById("A").style.color='#000066';
			document.getElementById("A").style.fontWeight='normal';
			prev_anchor = field;
		  }

	 }	
}

function applycode(code)
{
	
     //IN069244 Starts
    var pat_id = parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_id.value;
	if(pat_id==null)
        pat_id ="";
     //IN069244 Ends
	if(code == '')
	{
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.style.display = 'inline';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("enc_id").style.display = 'none'//IN069244 
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("Group_by").style.display = 'inline'//IN069244
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.style.display = 'inline';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.style.display = 'inline';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.value = '';
	//IN069244 Starts	
		if(pat_id== "")
		{
			parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search[0].disabled=false;
		}
	//IN069244 Ends	
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.disabled = false;
	}
	else if(code == 'B')
	{
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.style.display = 'inline';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("enc_id").style.display = 'none'//IN069244
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("Group_by").style.display = 'inline'//IN069244
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.style.display = 'none';
       //IN069244 Starts
       if(pat_id== "")
       {
		parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search[0].disabled=false;
       }//IN069244 Ends
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.value = '';

		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.disabled = false;
	}
	//IN069244 starts
	else if(code == 'V')
	{
		
		var search ="";
     
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("enc_id").style.display = 'inline'//IN069244 
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("Group_by").style.display = 'none'//IN069244 
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.style.display = 'none';

	   if(pat_id== "")
         {
		parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search[0].checked=false;
		parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search[0].disabled=true;
		parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search[1].checked=true; 
		checkSearch1(parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search[1])
        }

		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.disabled = true;

		var chkFlag = validateFormFields("onButtonClick");
		if (chkFlag == "chkNull")
		{	
			enableBtn('');	
		}else{	
			parent.parent.TaskListRightFrame.TaskListRightResultFrame.location.href="../jsp/TaskListRightResult.jsp?";
		}

	}
	//IN069244 ends
	else if(code == 'O' || code == 'M')
	{
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.style.display = 'inline';
     //IN069244 Starts
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("enc_id").style.display = 'none'
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("Group_by").style.display = 'inline'
        
        if(pat_id== "")
         {
			parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search[0].disabled=false;
          }
	//IN069244 Ends
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.style.display = 'inline';
		if(code == 'M')
			parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.style.display = 'inline';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.value = '';

		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.disabled = false;
		if(code == 'O')
		{
			/*****MODIFIED BY Deepa on 9/21/2009 at 11:38 AM for IN012629 ***********************/
			//parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked = true;
			//parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.disabled = false;

			parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked = false;
			parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.disabled = true;
		}
		else
		{
			parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked = false;
			parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.disabled = true;
		}
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.disabled = true;
	}
	else if(code == 'I')
	{
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.style.display = 'none';
         //IN069244 Starts
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("enc_id").style.display = 'none'
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("Group_by").style.display = 'inline'
          
        if(pat_id== "")
         {
		parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search[0].disabled=false;
          }//IN069244 Ends
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.style.display = 'inline';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.style.display = 'inline';
		
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.disabled = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.disabled = true;
	}
	else
	{
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.style.display = 'inline';
     //IN069244 Starts
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("enc_id").style.display = 'none'
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("Group_by").style.display = 'inline'
        
       if(pat_id== "")
         {
		parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search[0].disabled=false;
         }
	//IN069244 Ends
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.style.display = 'inline';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.style.display = 'none';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.value = '';

		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked = false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.disabled = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked = true;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.disabled = false;
	}

	taskTypeBold(code);
	document.TaskStatusForm.task_code.value = code;	
	var order_cat =  parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value;
	if((order_cat == 'PH' || order_cat == '') && (code == '' || code == 'M'))
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.style.display = 'inline';
	else
	{
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.value = '';
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.style.display = 'none';
	}
	populateValues();

}

function checkSearch(obj)
{	
document.TaskPatientSearchForm.search_T.value=obj.value;
if(obj.value=='A')
	{
	document.TaskPatientSearchForm.patient_search.disabled=true;
	document.TaskPatientSearchForm.patient_search.value="";
	document.TaskPatientSearchForm.patientname.value="";
	document.TaskPatientSearchForm.ActSearch.disabled=true;
	document.TaskPatientSearchForm.patient_id_img.style.display="none";
	}
	else
	{
	document.TaskPatientSearchForm.patient_search.disabled=false;
	document.TaskPatientSearchForm.ActSearch.disabled=false;
	document.TaskPatientSearchForm.patient_id_img.style.display="inline";
	}
}
//IN069244 Starts
function checkSearch1(obj)
{	
	parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search_T.value=obj.value;
      	if(obj.value=='A')
		{
		parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_search.disabled=true;
		parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_search.value="";
		parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patientname.value="";
		parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.ActSearch.disabled=true;
		parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_id_img.style.display="none";
		}
		else
		{
		parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_search.disabled=false;
		parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.ActSearch.disabled=false;
		parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_id_img.style.display="inline";
		}
}

function isNumeric(obj) {
	var numb = '0123456789';
	var inputparam = obj.value;
	var blnVal = isValid(inputparam,numb);
	if(blnVal == false)
	{
	obj.value = '';
	alert(getMessage("CHARACTER_NOT_ALLOWED",'CA')); 
	obj.focus();
	return blnVal;
	}
	else
	{
	return blnVal;
	}
	}
//IN069244 Ends
//IN072674 Start.
//function openFilterWindow(to,from,pat_discharge,onclickS)
async function openFilterWindow(to,from,pat_discharge,onclickS,selectedSubFunciton)
//IN072674 End.
{
	
	var to_Date = eval("document.TaskListFilterForm."+to);
	var from_Date = eval("document.TaskListFilterForm."+from);
	var pat_discharge = eval("document.TaskListFilterForm."+pat_discharge);
	var selectedSubFunciton = eval("document.TaskListFilterForm."+selectedSubFunciton).value; //
	var intrvl=eval("document.TaskListFilterForm.interval"); //aakh-crf-0165
	//  modified for IN058157 start  
	var location_type=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.location_type.value;
    //	  modified for IN058157 end
	
	var dialogHeight ='38vh' ;
	var dialogWidth = '33.5vw' ;
	var dialogTop	= '25';
	var dialogLeft = '30' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	//modified for IN058157 start
	//var finalString="Discharge="+pat_discharge.value+"&to_date="+to_Date.value+"&from_date="+from_Date.value;
	//IN072674 Start	
	//var finalString="Discharge="+pat_discharge.value+"&to_date="+to_Date.value+"&from_date="+from_Date.value+"&location_type="+location_type;
	var finalString="Discharge="+pat_discharge.value+"&to_date="+to_Date.value+"&from_date="+from_Date.value+"&location_type="+location_type+"&selectedSubFunciton="+selectedSubFunciton;
	//IN072674 end.
	//modified for IN058157 end
	var retVals = await window.showModalDialog("../../eCA/jsp/TaskListFilter.jsp?"+finalString,arguments,features);
		 
	var onclickS = eval("document.TaskListFilterForm."+onclickS);
	if(retVals!=null){
		to_Date.value = retVals[1];
		from_Date.value = retVals[0];
		pat_discharge.value = retVals[2];
		intrvl.value=retVals[4];//aakh-crf-0165
		onclickS.value = retVals[3];
	}
		 
}

function populateSourceLocation(source_location_type){
	var formObj = document.TaskPatientSearchForm;
	if( source_location_type.value == "" ) {
		clearSourceLocationList("document");
		document.TaskPatientSearchForm.searchLook.disabled=true;
		document.TaskPatientSearchForm.locn_code.disabled=true;
		document.TaskPatientSearchForm.locn.value="";
		document.TaskPatientSearchForm.locn_code.value="";
	}
	else
	{
	//var bean_id = formObj.bean_id.value ;
	document.TaskPatientSearchForm.searchLook.disabled=false;
	document.TaskPatientSearchForm.locn_code.disabled=false;
	document.TaskPatientSearchForm.locn.value="";
	document.TaskPatientSearchForm.locn_code.value="";
	
	}
}

function clearSourceLocationList( docObj ) {
	
	document.TaskPatientSearchForm.locn_code.value="";
	document.TaskPatientSearchForm.locn.value="";
}

async function populateMoveLoaction1(target,code)
{
	if(target.value!="")
	{
		await populateMoveLoaction(target,code);
	}
	else
	{
		parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn_code.value="";
		
		target.value = "";
   		code.value = "" ;
	}
}

async function populateMoveLoaction(target,code)
{
	
	
	location_type=parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.location_type.value;
if(location_type!='')
	{
	localeName=parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.localeName.value;
	var sql="";

	if(location_type=="C")
	{
		//sql="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(CLINIC_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.clinic_sql.value;
		
	}else if(location_type=="N")
	{
		//sql="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.nursing_sql.value;
		
	}else if(location_type=="R")
	{
		//sql="select REFERRAL_CODE code ,LONG_DESC description from AM_REFERRAL_LANG_VW where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(REFERRAL_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
		var sql=parent.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.referral_sql.value;
	}
	//sql=sql.replace('?',"'"+localeName+"'");
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	argumentArray[0]   =sql;
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await tasklistCommonLookup(getLabel("eOR.SourceType.label","OR") , argumentArray );
	if(retVal !=null && retVal != ""){
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		code.value=arr[0];
		target.value=arr[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
		//target.value=getLabel("Common.all.label","Common");
 	}
	}
	
}

async function tasklistCommonLookup(title, pArgumentArray) {

    var retVal = new String();
    /*
    var dialogHeight= "30" ;
    var dialogWidth = "50" ;
    */
    
    var dialogTop   = "10px";
    var dialogHeight= "450px" ;
    var dialogWidth = "700px" ;
    
    var status = "no";
	//var fin_Val=pArgumentArray.split(",");
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

	firstCodeVal = "" ;
	firstDescVal = "" ;

    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;
    
    // added for PE on 26th April 2010
    
    if (pArgumentArray[5] != "")
    {
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "GET", "../../eCommon/jsp/CommonLookupResult.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		responseText = trimString(responseText);
		eval(responseText) ;
	}
    if(firstCodeVal == "")
    {

		var dialogUrl       = "../../eCommon/jsp/CommonLookup.jsp?title="+title;
		
		pArgumentArray[9] = title;

		var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
        
		//var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
        
        var returnVal = "";  
        
        returnVal =   await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
        
        if( returnVal == null || returnVal == "" )
            return "";
        else
            return returnVal.split("\"") ;
		
     }
	 
     else
     {
         if(pArgumentArray[7] == CODE_DESC )
         {
            var temp = firstCodeVal
            firstCodeVal = firstDescVal
            firstDescVal = temp
         }
		 
          returnVal = firstCodeVal + "\"" + firstDescVal

         return returnVal.split("\"") ;
     }
}
async function callPatientSearch(){
	var pat_id =  await PatientSearch();
	if(pat_id != null)
	document.getElementById("patient_id").value = pat_id;

}

function checkTask(obj)
{
	document.TaskListFilterForm.status_code.value=obj.value;
	populateValues();
}
function populateOrderType1(obj)
{
var obj = eval("document.TaskListFilterForm."+obj);
populateOrderType(obj);
}
function populateOrderType(obj)
{
	var code = "";
	if(parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm != null)
		code = parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.task_code.value;
	if((code == 'M' || code == '') && (obj.value == 'PH' || obj.value == ''))
		document.TaskListFilterForm.AdminRoute.style.display = 'inline';
	else
	{
		document.TaskListFilterForm.AdminRoute.value = '';
		document.TaskListFilterForm.AdminRoute.style.display = 'none';
	}
	var formObj = document.TaskListFilterForm;
	var localeName=formObj.localeName.value;
	var c_OrderType=formObj.c_OrderType.value;	
	var validate = "";
	var bean_id = formObj.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += obj.name+"=\""+ obj.value +"\" " ;
	xmlStr += "c_OrderType=\""+ c_OrderType +"\" " ;
	validate = "ord_cat";
	 xmlStr +=" /></root>" ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='';
	xmlHttp.open( "POST", "TaskListValidate.jsp?bean_id=" + bean_id + "&validate="+validate+"&flag="+flag+"&localeName="+localeName, false ) ;
	xmlHttp.send(xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function addOrderTypeList(code,value,selected) {	
	var element = document.createElement('OPTION') ;
	var c_OrderType=document.TaskListFilterForm.c_OrderType.value;
	//alert(c_OrderType);
	element.value =  code ;
	element.text = value ;
	//alert(selected);
	if (c_OrderType == element.value)
	{
		element.selected = selected;
	}
//	element.selected = selected;
	document.TaskListFilterForm.OrderType.add(element);
}

function populateInterventionType(obj)
{
	var formObj = document.TaskListFilterForm;
	var localeName=formObj.localeName.value;
	var c_OrderType=formObj.c_OrderType.value;	
	var validate = "";
	var bean_id = formObj.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += obj.name+"=\""+ obj.value +"\" " ;
	validate = "definition";
	 xmlStr +=" /></root>" ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='';
	xmlHttp.open( "POST", "TaskListValidate.jsp?bean_id=" + bean_id + "&validate="+validate+"&flag="+flag+"&localeName="+localeName, false ) ;
	xmlHttp.send(xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function addInterventionType(code,value)
{	
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	
	document.TaskListFilterForm.interventionType.add(element);
}

function checkAll(obj)
{
	if(obj.name == 'chkAll')
	{
		if(obj.checked == true)
		{
			if(document.TaskListFilterForm.ckhDue.disabled == false)
				document.TaskListFilterForm.ckhDue.checked = true;
			if(document.TaskListFilterForm.chkOverdue.disabled == false)
				document.TaskListFilterForm.chkOverdue.checked = true;
			if(document.TaskListFilterForm.chkElapsed.disabled == false)
				document.TaskListFilterForm.chkElapsed.checked = true;
			if(document.TaskListFilterForm.chkPerformed.disabled == false)
				document.TaskListFilterForm.chkPerformed.checked = true;
			if(document.TaskListFilterForm.chkFuture.disabled == false)
				document.TaskListFilterForm.chkFuture.checked = true;
			if(document.TaskListFilterForm.chkUnclassify.disabled == false)
				document.TaskListFilterForm.chkUnclassify.checked = true;
		}
		else if(obj.checked == false)
		{
			document.TaskListFilterForm.ckhDue.checked = false;
			document.TaskListFilterForm.chkOverdue.checked = false;
			document.TaskListFilterForm.chkElapsed.checked = false;
			document.TaskListFilterForm.chkPerformed.checked = false;
			document.TaskListFilterForm.chkFuture.checked = false;
			document.TaskListFilterForm.chkUnclassify.checked = false;
		}
	}
	else
	{
		if(obj.checked == false)
			document.TaskListFilterForm.chkAll.checked = false;
		else
		{
			if(document.TaskListFilterForm.ckhDue.checked == true && document.TaskListFilterForm.chkOverdue.checked == true && document.TaskListFilterForm.chkElapsed.checked == true && document.TaskListFilterForm.chkPerformed.checked == true && document.TaskListFilterForm.chkFuture.checked == true && document.TaskListFilterForm.chkUnclassify.checked == true)
				document.TaskListFilterForm.chkAll.checked = true;
		}
	}
}

function populateValues(){	
//Left PatientSearchFrame
var chkAll="";
var ckhDue="";
var chkOverdue="";
var chkElapsed="";
var chkPerformed="";
var chkFuture="";
var chkReg="";
var chkUnclassify="";
var from ="1";
var to = "50";
var encounter_id =parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("encounter_id").value;//IN069244 
var locn_desc=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn_code.value;
var locn_code=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn.value;
var location_type=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.location_type.value;
var patient_id=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_id.value;
var isVitalSearchByBedNo =parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.isVitalSearchByBedNo.value;//Added for IN017999
var enc_change_flag =parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.enc_change_flag.value;//IN017999
var interval_val =parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interval.value;//AAKH-CRF-0165

//if(patient_id != null && patient_id != '')
	//locn_code = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.locn_code.value;

var localeName=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.localeName.value;
var taskListFlag=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.TaskListFlag.value;

//Left StatusFrame
//var status_code=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.status_code.value;

/**
	modified by Deepa on 5/14/2010 at 3:16 PM for IN021020
	added Dob and sex as part of queryString to handle multiple reference range
**/
var dob=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.dob.value;
var sex=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.sex.value;

var taskSelect=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.task_code.value;
var taskSelectAll=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.str_appl_task.value;

//Right FilterFrame
var status_code=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.statusCode.value;
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked)
{
	//chkAll=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.value;
	chkAll="Y";
}else{
	chkAll="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked)
{
	ckhDue="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.value;
}else{
	ckhDue="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked)
{
	chkOverdue="Y";   //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.value;
}else{
	chkOverdue="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked)
{
	chkElapsed="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.value;
}else{
	chkElapsed="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked)
{
	chkPerformed="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.value;
}else{
	chkPerformed="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked)
{
	chkFuture="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.value;
}else{
	chkFuture="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked)
{
	chkUnclassify="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.value;
}else{
	chkUnclassify="N";
}
/*if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkReg.checked)
{
	chkReg=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkReg.value;
}
 */
//var taskSelect=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.taskSelect.value;

var OrderCategory=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value;
var OrderType=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.value;
var Groupby=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.Groupby.value;
// IN072674 Start.
//Date Conversion done by Archana Dhal related to IN18772 and IN18781.
//var To_date = convertDate(parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.To_date.value,'DMY',localeName,'en');
//Date Conversion done by Archana Dhal related to IN18772 and IN18781.
//var From_date = convertDate(parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.From_date.value,'DMY',localeName,'en');

var taskSelect=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.task_code.value;
var To_date = "";
var From_date = "";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "Todate=\""+ parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.To_date.value +"\" " ;
	xmlStr += "Fromdate=\""+ parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.From_date.value +"\" " ;
	xmlStr += "interval=\""+ parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interval.value +"\" " ;//aakh-crf-0165
	
	if(taskSelect == "V"){	
		xmlStr += "taskSelect=\""+ taskSelect +"\" " ;
	}else{
		xmlStr += "taskSelect=\""+ taskSelect +"\" " ;
	}
	xmlStr +=" /></root>" ;
 	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TaskListIntermediate.jsp", false ) ;	
	xmlHttp.send( xmlDoc ) ;
	responseText=(xmlHttp.responseText).replace(/^\s+|\s+$/gm,'') ;
	
	var dates = responseText.split("|");	
	
	if(taskSelect == "V"){
		To_date = convertDate(dates[1],'DMYHM',localeName,'en');
		From_date = convertDate(dates[0],'DMYHM',localeName,'en');
	}else{
		To_date = convertDate(dates[1],'DMY',localeName,'en');
		From_date = convertDate(dates[0],'DMY',localeName,'en');
	}
//IN072674 End.
var pat_discharge=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.pat_discharge.value;
var onclickS=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.onclickS.value;
var clickdate=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.clickdate.value;
var AdminRoute=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.value;
var bt_status=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bt_status.value;
var definition=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.definition.value;
var interventionType=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interventionType.value;
var relationship_id=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.relationship_id.value;

//IN069244 Starts
parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.selectedSubFunciton.value=taskSelect; //IN072674
if (taskSelect == "V"){
	if(isVitalSearchByBedNo =="true" && patient_id!=""){//Adding start for IN017999
	    if(enc_change_flag =="N")
           populateEncounters(patient_id,encounter_id);
	}else{//Adding end for IN017999
	if(encounter_id== ""){
		var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
		msg = msg.replace("$", getLabel("Common.encounterid.label",'Common'));
		alert(msg);
		return;
	 } 
	}
	//IN072674 Start.
	if(onclickS=="Y")
	{
		From_date = clickdate+" 00:00";
		To_date = clickdate+" 23:59";		
	}
}else{ 
//IN069244 Ends
	if(onclickS=="Y")
	{
		To_date = clickdate;
		From_date = clickdate;
	}
} //IN072674 end.
var l_isBTViewBillDtls = parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.getElementById("isBTViewBillDtls").value;//IN065324
//Adding start for IN017999
parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.patient_id.value  = patient_id;

//Adding start for IN017999
var enc_id ="";
if(parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.en_id!=undefined)
   enc_id = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("en_id").value;//IN017999 
if(parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bed_no !=undefined)//adding start for IN017999
    var bed_no=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.bed_no.value;
else 
	var bed_no="";//adding end for IN017999


if(isVitalSearchByBedNo!=undefined){
	if(isVitalSearchByBedNo=="true")
		encounter_id =enc_id;
}//Adding end for IN017999


var qry_string="locn_code="+locn_code;
qry_string += "&location_type="+location_type;
qry_string += "&patient_id="+patient_id;
qry_string += "&localeName="+localeName;
qry_string += "&status_code="+status_code;
qry_string += "&taskSelect="+taskSelect;
qry_string += "&OrderCategory="+OrderCategory;
qry_string += "&OrderType="+OrderType;
qry_string += "&Groupby="+Groupby;
qry_string += "&To_date="+To_date;
qry_string += "&From_date="+From_date;
qry_string += "&pat_discharge="+pat_discharge;
qry_string += "&chkAll="+chkAll;
qry_string += "&ckhDue="+ckhDue;
qry_string += "&chkOverdue="+chkOverdue;
qry_string += "&chkElapsed="+chkElapsed;
qry_string += "&chkPerformed="+chkPerformed;
qry_string += "&chkFuture="+chkFuture;
qry_string += "&chkReg="+chkReg;
qry_string += "&chkUnclassify="+chkUnclassify;
qry_string += "&taskListFlag="+taskListFlag;
qry_string += "&taskSelectAll="+taskSelectAll;
qry_string += "&AdminRoute="+AdminRoute;
qry_string += "&bt_status="+bt_status;
qry_string += "&definition="+definition;
qry_string += "&interventionType="+interventionType;
qry_string += "&from="+from;
qry_string += "&to="+to;
qry_string += "&relationship_id="+relationship_id;
qry_string += "&isBTViewBillDtls="+l_isBTViewBillDtls;//IN065324
/**
	modified by Deepa on 5/14/2010 at 3:16 PM for IN021020
	added Dob and sex as part of queryString to handle multiple reference range
**/
qry_string += "&dob="+dob;
qry_string += "&sex="+sex;
qry_string += "&encounter_id="+encounter_id;//IN069244
qry_string += "&bed_no="+bed_no;//IN017999
qry_string += "&interval="+interval_val;// AAKH-crf-0165
//Commented for IN069244
//parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.searchbutton.disabled= true; 
//parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.go.disabled= true;

var chkFlag = validateFormFields("onButtonClick");
if (chkFlag == "chkNull")
{					
/*		Modified by Kishore Kumar N on Sept08-09 for CRF 691					*/
	enableBtn('');	
	/*ends here. */
}else{
    //IN069244 Starts	
	if(taskSelect=="V"){
		parent.parent.TaskListRightFrame.TaskListRightBottomFrame.location.href="../../eCA/jsp/ChartRecordingColorBar.jsp?"+qry_string;
		parent.parent.TaskListRightFrame.TaskListRightResultFrame.location.href="../jsp/VitalSignFrameSet.jsp?"+qry_string;		
	}else{ 
		parent.parent.TaskListRightFrame.TaskListRightBottomFrame.location.href="../../eCA/jsp/TaskListRightBottom.jsp?"+qry_string;//IN069244 Ends
		parent.parent.TaskListRightFrame.TaskListRightHeaderFrame.location.href="../jsp/TaskListRightResultHeader.jsp?"+qry_string;
		
	}
}


}

function saveValues()
{
var chkAll="";
var ckhDue="";
var chkOverdue="";
var chkElapsed="";
var chkPerformed="";
var chkFuture="";
var chkReg="";
var chkUnclassify="";
	//Left PatientSearchFrame
var locn_desc=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn_code.value;
var locn_code=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn.value;
var location_type=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.location_type.value;
var patient_id=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_id.value;
var localeName=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.localeName.value;
var taskListFlag=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.TaskListFlag.value;
var search=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search_T.value;
var patientname=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patientname.value;

//Left StatusFrame
var taskSelect=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.task_code.value;
var taskSelectAll=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.str_appl_task.value;
//var status_code=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.status_code.value;

//Right FilterFrame
var status_code=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.statusCode.value;

if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked)
{
	chkAll="Y"; //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.value;
}else {
	chkAll="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked)
{
	ckhDue="Y"; //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.value;
}else {
	ckhDue="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked)
{
	chkOverdue="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.value;
}else {
	chkOverdue="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked)
{
	chkElapsed="Y"; //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.value;
}else {
	chkElapsed="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked)
{
	chkPerformed="Y"; //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.value;
}else {
	chkPerformed="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked)
{
	chkFuture="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.value;
}else {
	chkFuture="N";
}
if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked)
{
	chkUnclassify="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.value;
}else {
	chkUnclassify="N";
}
/*if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkReg.checked)
{
	chkReg=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkReg.value;
}*/
//var taskSelect=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.taskSelect.value;
var OrderCategory=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value;
var OrderType=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.value;
var Groupby=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.Groupby.value;
var To_date=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.To_date.value;
var From_date=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.From_date.value;
var pat_discharge=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.pat_discharge.value;
var onclickS=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.onclickS.value;
var clickdate=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.clickdate.value;
if(onclickS=="Y")
{
To_date=clickdate;
From_date=clickdate;
}
	var formObj = document.TaskListFilterForm;
	var validate = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	//xmlStr += "c_locn_desc=\""+ locn_desc +"\" " ;//Commented for IN045571
	xmlStr += "c_locn_desc=\""+ encodeURIComponent(locn_desc) +"\" " ;//IN045571
	xmlStr += "c_locn_code=\""+ locn_code +"\" " ;
	xmlStr += "c_location_type=\""+ location_type +"\" " ;
	xmlStr += "c_patient_id=\""+ patient_id +"\" " ;
	xmlStr += "c_status_code=\""+ status_code +"\" " ;
	xmlStr += "c_taskSelect=\""+ taskSelect +"\" " ;
	xmlStr += "c_OrderCategory=\""+ OrderCategory +"\" " ;
	xmlStr += "c_OrderType=\""+ OrderType +"\" " ;
	xmlStr += "c_Groupby=\""+ Groupby +"\" " ;
	xmlStr += "c_To_date=\""+ To_date +"\" " ;
	xmlStr += "c_From_date=\""+ From_date +"\" " ;
	xmlStr += "c_pat_discharge=\""+ pat_discharge +"\" " ;
	xmlStr += "c_onclickS=\""+ onclickS +"\" " ;
	xmlStr += "c_clickdate=\""+ clickdate +"\" " ;
	xmlStr += "c_search=\""+ search +"\" " ;
	xmlStr += "c_patientname=\""+ patientname +"\" " ;
	xmlStr += "c_chkAll=\""+ chkAll +"\" " ;
	xmlStr += "c_ckhDue=\""+ ckhDue +"\" " ;
	xmlStr += "c_chkOverdue=\""+ chkOverdue +"\" " ;
	xmlStr += "c_chkElapsed=\""+ chkElapsed +"\" " ;
	xmlStr += "c_chkPerformed=\""+ chkPerformed +"\" " ;
	xmlStr += "c_chkReg=\""+ chkReg +"\" " ;
	xmlStr += "c_chkFuture=\""+ chkFuture +"\" " ;
	xmlStr += "c_taskListFlag=\""+ taskListFlag +"\" " ;
	xmlStr += "c_taskSelectAll=\""+ taskSelectAll +"\" " ;
	xmlStr += "c_chkUnclassify=\""+ chkUnclassify +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 validate = "save";

	flag='';
	xmlHttp.open( "POST", "TaskListValidate.jsp?bean_id=patTask&validate="+validate+"&flag="+flag, false ) ;
	xmlHttp.send(xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}
/*	Modified by Kishore Kumar N on Sept08-09 for CRF 691					*/
function enableBtn(obj)
{
	if (obj != 'IM')
	{
		parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.searchbutton.disabled= false;
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.go.disabled= false;
	}

}
/*ends here.*/

function setDate()
{
	var date_from=parent.TaskListFilterSet.document.TaskListFilterSet.date_from.value;	
	var date_to=parent.TaskListFilterSet.document.TaskListFilterSet.date_to.value;	
	interval = parent.TaskListFilterSet.document.TaskListFilterSet.time_interval.value;// AAKH-crf-0165
	//modified for IN058157 start
	var location_type=parent.TaskListFilterSet.document.TaskListFilterSet.location_type.value;
    var language_id=parent.TaskListFilterSet.document.TaskListFilterSet.language_id.value;
	 var max_days=daysBetween(date_from,date_to,"DMY",language_id);
	//modified for IN058157 end   
	if(date_from=="" || date_to== "")
	{		
		var msgalert=getLabel("Common.Period.label","Common")+" "+getLabel("Common.Cannotbeblank.label","Common")
		alert(msgalert);
		return false;
	}
	else
	{
			//modified for IN058157 start	
			if(location_type != null && location_type != '') {
				//var max_days=daysBetween(date_from,date_to,"DMY",language_id);
				
				if(max_days > 7) {
					alert("Difference between from date and to date should be 7 Days");
					//alert(getMessage("PERIOD_SHOULD_LESS_THAN_YEAR","OR")); 
						return false;
				}
			}			
			//modified for IN058157 end	
		if(parent.TaskListFilterSet.document.TaskListFilterSet.DischargePat.checked)
			var dis_charge='true';
		else
			var dis_charge='false';
	       // var returnVal =new Array(3);//AAKH-crf-0165
		var returnVal =new Array(4);//AAKH-crf-0165
		returnVal[0]=date_from;
		returnVal[1]=date_to;
		returnVal[2]=dis_charge;
		returnVal[3]="N";
		returnVal[4]=interval;//AAKH-crf-0165
		window.returnValue=returnVal;		
		window.close();
	}
}

function getDate(objButton,localeName)
{
	var dateValue=document.TaskListTopForm.currentDate.value;
	var currdateValue=document.TaskListTopForm.currDate.value;
	
	var flag=''
	if(objButton.name=='buttonPrevDate')
	{

		flag = 'PrevMonth'
	}
	else
	{
			flag = 'NextMonth'
	}
	if(flag != '' && dateValue != '')
	{
		var HtmlVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form action='../../eCA/jsp/TaskListCalendarIntermediate.jsp' method='post' name='tempForm' id='tempForm'><input type='hidden' name='flag' id='flag' value=\""+flag+"\"><input type='hidden' name='currdateValue' id='currdateValue' value=\""+currdateValue+"\"></form></body></html>"
		parent.blankFrame.document.write(HtmlVal);
		parent.blankFrame.document.tempForm.submit();
	}
}
function setDatecal1(date){		
	if (parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm)
	{
		parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.clickdate.value=date;
		parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.onclickS.value="Y";
	}
	else
	{
		setTimeout(date, 4000);	
	}
}
function setDatecal(day,date,localeName)
{	
	var chkAll="";
	var ckhDue="";
	var chkOverdue="";
	var chkElapsed="";
	var chkPerformed="";
	var chkFuture="";
	var chkReg="";
	var chkUnclassify="";
    var localeName = document.TaskListCalendarForm.localeName.value
	if(day=="")
		return false;
	var nDays = 0;
	
	var dateArray = date.split("/");	
	var year  = parseInt(dateArray[2]);	
	var month = dateArray[1];	
	if ((month == 1) || (month == 3) || (month ==5) || (month ==7) || (month ==8) || (month ==10) || (month ==12))
	{
		nDays = 31;
	}else if ((month == 4) || (month == 6) || (month ==9) || (month ==11)){
		nDays = 30;
	}else if (month == 2){				
		if (((year % 4) == 0) && (((year % 100) != 0) || ((year %400) == 0)))
		{
			nDays = 29;
		}else{
			nDays = 28;	
		}
	}

	for(var d=0;d<=nDays;d++)
	{
		if(d>0)
		{		
			if(d==day)
			{
				document.getElementById('d_'+day).style.fontWeight='bold';
				document.getElementById('d_'+day).style.fontSize='10pt';
				document.getElementById('d_'+day).style.color='#000000';
				document.getElementById('d_'+day).style.background='#9E9E9E';
				document.getElementById('d_'+day).style.cursor='pointer';
			//break;
			}
			else 
			{
				document.getElementById("d_"+d).style.fontWeight='normal';
				document.getElementById("d_"+day).style.fontSize='8pt';
				document.getElementById("d_"+d).style.color='#000000';
				document.getElementById("d_"+d).style.background='#FFFFFF';			
				document.getElementById("d_"+d).style.cursor='pointer';
			}			
			
		}
		
	}
	parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.clickdate.value=date;	
	parent.TaskListCalendarFrameTop.document.getElementById("systemDate").innerText=convertDate(date,"DMY","en",localeName);
	parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.onclickS.value="Y";
	
var locn_desc=parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn_code.value;
var locn_code=parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn.value;
var location_type=parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.location_type.value;
var patient_id=parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_id.value;
var taskListFlag=parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.TaskListFlag.value;

//Left StatusFrame
var taskSelect=parent.parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.task_code.value;
var taskSelectAll=parent.parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.str_appl_task.value;
//var status_code=parent.parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.status_code.value;

//Right FilterFrame
var status_code=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.statusCode.value;

if (parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked)
{
	chkAll="Y";  //parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.value;
}else{
	chkAll="N";
}
if (parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked)
{
	ckhDue="Y";  //parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.value;
}else{
	ckhDue="N";
}
if (parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked)
{
	chkOverdue="Y";  //parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.value;
}else{
	chkOverdue="N";
}
if (parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked)
{
	chkElapsed="Y";  //parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.value;
}else{
	chkElapsed="N";
}
if (parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked)
{
	chkPerformed="Y";  //parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.value;
}else{
	chkPerformed="N";
}
if (parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked)
{
	chkFuture="Y";  //parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.value;
}else{
	chkFuture="N";
}
if (parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked)
{
	chkUnclassify="Y";  //parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.value;
}else{
	chkUnclassify="N";
}
/*if (parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkReg.checked)
{
	chkReg=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkReg.value;
}*/
//var taskSelect=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.taskSelect.value;
var OrderCategory=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value;
var OrderType=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.value;
var Groupby=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.Groupby.value;
var To_date=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.To_date.value;
var From_date=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.From_date.value;
var pat_discharge=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.pat_discharge.value;
var onclickS=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.onclickS.value;
var clickdate=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.clickdate.value;
var AdminRoute=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.value;
var localeName = parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.localeName.value;
var relationship_id=parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.relationship_id.value;
var encounter_id =parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("encounter_id").value;//IN069244 	
//var taskSelect=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.task_code.value;
//IN069244 Starts
if (taskSelect == "V"){
	if(encounter_id== "")
		{
			var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
			msg = msg.replace("$", getLabel("Common.encounterid.label",'Common'));
			alert(msg);
			return;
	} 
}//IN069244 Ends
if(onclickS == "Y")
{
	To_date = clickdate;
	From_date = clickdate;
}

var qry_string="locn_code="+locn_code;
qry_string += "&location_type="+location_type;
qry_string += "&patient_id="+patient_id;
qry_string += "&status_code="+status_code;
qry_string += "&taskSelect="+taskSelect;
qry_string += "&OrderCategory="+OrderCategory;
qry_string += "&OrderType="+OrderType;
qry_string += "&Groupby="+Groupby;
qry_string += "&To_date="+To_date;
qry_string += "&From_date="+From_date;
qry_string += "&pat_discharge="+pat_discharge;
qry_string += "&chkAll="+chkAll;
qry_string += "&ckhDue="+ckhDue;
qry_string += "&chkOverdue="+chkOverdue;
qry_string += "&chkElapsed="+chkElapsed;
qry_string += "&chkPerformed="+chkPerformed;
qry_string += "&chkFuture="+chkFuture;
qry_string += "&chkReg="+chkReg;
qry_string += "&taskListFlag="+taskListFlag;
qry_string += "&taskSelectAll="+taskSelectAll;
qry_string += "&AdminRoute="+AdminRoute;
qry_string += "&chkUnclassify="+chkUnclassify;
qry_string += "&relationship_id="+relationship_id;
qry_string += "&encounter_id="+encounter_id;

parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.searchbutton.disabled= true;
parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.go.disabled= true;
var chkFlag = validateFormFields("onDateClick");
if (chkFlag == "chkNull")
{
	parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.searchbutton.disabled= false;
parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.go.disabled= false;
	
}else{
	parent.parent.parent.TaskListRightFrame.TaskListRightHeaderFrame.location.href="../jsp/TaskListRightResultHeader.jsp?"+qry_string
	
}
parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.From_date.value = convertDate(date,"DMY","en",localeName);//IN29559

parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.To_date.value = convertDate(date,"DMY","en",localeName);//IN29559

parent.parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.interval.value="0";//AAKH-crf-0165
}
/*
	Modified by Kishore Kumar N on Sept08-09 for CRF 691
*/
function clearValuesfor(obj)
{
	if (obj != 'IM')
	{
		parent.parent.TaskListRightFrame.TaskListRightHeaderFrame.location.href="../../eCommon/html/blank.html";
		parent.parent.TaskListRightFrame.TaskListRightResultFrame.location.href="../../eCommon/html/blank.html";
		enableBtn(obj);
	}
	else if (obj == 'IM')
	{
		if (parent.VaccinationFrame)
		{
			parent.VaccineTabResult.location.href='../../eCommon/html/blank.html';
		}
		
	}
}

/*
	ends here.
*/
function alignHeading()
{

	if(parent.TaskListRightHeaderFrame.document.getElementById("tableheader")!=null)
	{		
				parent.TaskListRightHeaderFrame.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				for (j=0; j < document.getElementById("tableresult").rows[1].cells.length; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows[1].cells[j].offsetWidth);
					
					if(parent.TaskListRightHeaderFrame.document.getElementById("tableheader").rows[0].cells[j] != null)
					{
						parent.TaskListRightHeaderFrame.document.getElementById("tableheader").rows[0].cells[j].width=wid;
					}
				}
		}
		
	}

function moveFrame(obj)
{
	if (obj != 'IM')
	{
		var temp=document.body.scrollLeft;
		scrollValue=temp;

		if(parent.TaskListRightHeaderFrame.location.href.indexOf(".jsp") != -1)
		{
			parent.TaskListRightHeaderFrame.document.body.scrollLeft=temp;
		}

	}
}


/**
	modified by Deepa on 13/05/2010 for IN021020
	added dob to the function to handle multiple reference range
**/	
async function callMenuFunctions(colval1,colval,orderId,encounterId,sex,patient_id,procedure_code,patient_class,image_ref,ord_cat,order_status,order_line_num,performing_facility,performing_location_type,performing_location,int_or_ext,sent_out_flag,patient_dtls,discr_msr_id,proc_code_scheme,order_type_code,order_set_id,dob,accssion_num,practname,patientDtls,patName,ord_pract_id,date_time,index,task_categ){//Chowminya
	
		ord_id1=orderId;
		
 		var dialogHeight ='90vh' ;
		var dialogWidth = '80vw' ;
		var dialogTop	= '100';
		var dialogLeft = '11' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var finalString="";

		if(colval1=="Discontinue")
		{
			finalString	= "from=line&colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&patient_class="+ patient_class+"&order_type_code="+ order_type_code+"&from=TaskList&order_category="+ord_cat+"&order_line_num="+order_line_num;
		}
		else
		{
			finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&patient_class="+ patient_class+"&order_line_num="+ order_line_num+"&order_type_code="+ order_type_code+"&from=TaskList&order_category="+ord_cat+"&dob="+dob;
		}

		var arguments = "";
		/*if(colval1=="ResultEntry" || colval1=="Completion"){
		finalString	= finalString+"&image_ref="+image_ref+"&patient_dtls="+unescape(patient_dtls)+"&patient_class="+patient_class+"&order_type_code="+order_type_code;
		}*/

 		if(colval1=="ResultEntry" || colval1=="Notes")
		{
			//if (top.content) {
			    // taskListURL = top.content.workAreaFrame.location.href;
            //} else {
			     taskListURL = parent.location.href;
           // }

			var encounter_dtls;
			if(encounterId == ""){
				
				patient_dtls = unescape(patient_dtls)
				encounter_dtls = patient_dtls.split(":");
				var ind = encounter_dtls[2].indexOf(",");
				encounterId = encounter_dtls[2].substring(0,ind);
				
			}
			
			taskListURL = taskListURL.substr((taskListURL.indexOf("?")+1),taskListURL.length-1)

			if((taskListURL.indexOf("p_called_from_ca"))!= -1){
				taskListURL = taskListURL.substr((taskListURL.indexOf("p_called_from_ca")),taskListURL.length-1);

				/*if(resultReportingURL.indexOf("&CanelFlag=Y") != -1)
					resultReportingURL = resultReportingURL.substr(0,resultReportingURL.indexOf("&CanelFlag=Y"));*/
								
				if(taskListURL.indexOf("&orderId=") != -1)
					taskListURL = taskListURL.substr(0,taskListURL.indexOf("&orderId=")+1);
				
				taskListURL = taskListURL.substr(0,taskListURL.length-1);
			}

			taskListURL += '&encounter_id='+encounterId
			
			
			/*finalString = finalString + "&order_category="+ord_cat;//parent.ResultReportingResult.order_category.value;
			finalString += "&can_location_type="+parent.ResultReportingResult.document.result_reporting.can_location_type.value;
			finalString += "&can_location="+parent.ResultReportingResult.document.result_reporting.can_location.value;
			finalString += "&can_order_category="+parent.ResultReportingResult.document.result_reporting.can_order_category.value;
			finalString += "&can_single_multi="+parent.ResultReportingResult.document.result_reporting.can_single_multi.value;
			finalString += "&can_priority="+parent.ResultReportingResult.document.result_reporting.can_priority.value;
			finalString += "&can_date_from="+parent.ResultReportingResult.document.result_reporting.can_date_from.value;
			finalString += "&can_date_to="+parent.ResultReportingResult.document.result_reporting.can_date_to.value;
			finalString += "&can_patient_id="+parent.ResultReportingResult.document.result_reporting.can_patient_id.value;
			finalString += "&can_order_id="+parent.ResultReportingResult.document.result_reporting.can_order_id.value;
			finalString += "&can_encounter_id="+parent.ResultReportingResult.document.result_reporting.can_encounter_id.value;
			finalString += "&can_patient_id_found="+parent.ResultReportingResult.document.result_reporting.can_patient_id_found.value;
			finalString += "&can_order_type="+parent.ResultReportingResult.document.result_reporting.can_order_type.value;
			finalString += "&can_performing_location_code="+parent.ResultReportingResult.document.result_reporting.can_performing_location_code.value;
			finalString += "&can_specimen_no="+parent.ResultReportingResult.document.result_reporting.can_specimen_no.value;

			finalString += "&can_catalog_desc="+parent.ResultReportingResult.document.result_reporting.can_catalog_desc.value;
			finalString += "&can_search_criteria="+parent.ResultReportingResult.document.result_reporting.can_search_criteria.value;
			finalString += "&can_source_location_type="+parent.ResultReportingResult.document.result_reporting.can_source_location_type.value;
			finalString += "&can_source_locn="+parent.ResultReportingResult.document.result_reporting.can_source_locn.value;
			finalString += "&can_group_by="+parent.ResultReportingResult.document.result_reporting.can_group_by.value;
			finalString += "&can_task_status="+parent.ResultReportingResult.document.result_reporting.can_task_status.value;*/
			//alert("Frame Name = "+resultReportingURL+" -- "+unescape(resultReportingURL));
			//alert(">>>"+resultReportingURL );
			//alert(">>>"+finalString );
			
			if (top.content) {						
				if (parent.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked)
				{
					performed_only = "Y";
					finalString += '&performed_only='+performed_only+"&accession_num="+accssion_num
				}				
				finalString += "&report_srl_no="+order_line_num+"&order_status="+order_status;	//IN032816
				saveValues();
				top.content.workAreaFrame.location.href="../../eOR/jsp/ResultEntry.jsp?"+finalString+"&"+taskListURL
			} 
		} else if (colval1=="RecordProcedure") {
			//alert(proc_code_scheme);
			finalString += "&code="+procedure_code+"&patient_class="+patient_class+"&episode_id="+encounterId+"&modal_yn=Y&mode=OR&term_set_id="+proc_code_scheme;//"&term_set_id=ICD10"  term_Set_id need to be passed ...
           //alert(finalString);
			//var retVals = window.showModalDialog("../../eCA/jsp/AddModifyOPProc.jsp?"+finalString,arguments,features);
			//top.content.workAreaFrame.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+finalString

			//var retVals = window.showModalDialog("RecordProcedureFrameset.jsp?"+finalString,arguments,features);
			var retVals = await top.window.showModalDialog("../../eCA/jsp/PatProcRecord.jsp?"+finalString,arguments,features);
			populateValues();
		} else if(colval1=="Image")
		{
  			 var retVals =await top.window.showModalDialog("../../eOR/jsp/ResultEntryDrawingToolFrameSet.jsp?called_from=RESULT&patient_id="+patient_id+"&encounter_id="+"&order_id="+escape(orderId), arguments,features);
  			 rePopulateValues();
		//Chowminya starts	
		}
		else if(colval1 == "RecordConsent")
		{
		var fromDate = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.From_date.value;//IN29559
		var toDate = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.To_date.value;//IN29559
		var orderCategory = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value;//IN29559
		var calledFrom  = "TASK_LIST";//IN29559
		var dialogTop   = "100";
		var dialogLeft   = "100";
		var dialogHeight= "90vh" ;
		var dialogWidth = "80vw" ;
		var bean_id = "Or_ConsentOrders";
		var bean_name = "eOR.ConsentOrders";
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&ord_id="+orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&encounter_id="+encounterId+"&patient_class="+patient_class+"&order_type_code="+order_type_code+"&location_type="+performing_location_type+"&location_code="+performing_location+"&patientdetails="+patientDtls+"&practitioner_name="+unescape(practname)+"&patient_name="+unescape(patName)+"&pat_name_def="+unescape(patName)+"&pract_id="+unescape(ord_pract_id)+"&curr_sys_date="+unescape(date_time)+"&index="+index+"&bean_id="+bean_id+"&bean_name="+bean_name+"&task_categ="+task_categ+"&calledFrom="+calledFrom+"&fromDate="+encodeURIComponent(fromDate)+"&toDate="+encodeURIComponent(toDate)+"&orderCategory="+orderCategory;
		
			 var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
			 document.location.href = document.location.href;//IN29559
		}//Chowminya Ends
		/* else if(colval1=="Notes"){
			if (top.content) {
				var encounter_dtls;
				if(encounterId == ""){
					//alert(unescape(patient_dtls));
					patient_dtls = unescape(patient_dtls)
					encounter_dtls = patient_dtls.split(":");
					var ind = encounter_dtls[2].indexOf(",");
					encounterId = encounter_dtls[2].substring(1,ind);
				}//alert("note type=="+discr_msr_id);
				var assess_note_id	 = discr_msr_id ;
				note_type			 = assess_note_id;
				var accession_num	 = parent.ResultReportingResult.accession_num.value;
				var patient_id		 = patient_id;
				var note_signed		 = '';
				var patient_class	 = patient_class;
				
				var dialogTop	 = "97";
				var dialogHeight = "445";
				var dialogWidth	 = "790";
				var features = "top="+dialogTop+",height="+dialogHeight+",width="+dialogWidth+",status=no,left=0";
				var arguments = "Window_for_"+patient_id;
				var action_url	="../../eCA/jsp/RecClinicalNotesModal.jsp?title=Clinical Note&note_type="+assess_note_id+"&patient_id="+patient_id+"&patient_class="+patient_class+"&episode_id="+encounterId+"&encounter_id="+encounterId+ "&Field_Ref=parent.ResultReportingResult.accession_num&function_id=SPCL_NOTE&event_class=PHY$&accession_num="+accession_num+"&window_close=Y&note_signed="+ note_signed+"&appl_task_id=CLINICAL_NOTES";
				
				if(window_obj != null)
					window_obj.close();
				else
					window_obj = window.open(action_url,arguments,features);
				
				setInterval('updateAccession();', 2500);
					
			}
		}	*/
		//IN068778 Start.
		else if(colval1 == "UploadImageVideo"){ 
		var fromDate = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.From_date.value;
		var toDate = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.To_date.value;
		var orderCategory = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value;
		var calledFrom  = "TASK_LIST";
		var dialogTop   = "100";
		var dialogLeft   = "100";
		var dialogHeight= "90vh" ;
		var dialogWidth = "80vw" ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&ord_id="+orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&encounter_id="+encounterId+"&patient_class="+patient_class+"&order_type_code="+order_type_code+"&location_type="+performing_location_type+"&location_code="+performing_location+"&patientdetails="+patientDtls+"&practitioner_name="+unescape(practname)+"&patient_name="+unescape(patName)+"&pat_name_def="+unescape(patName)+"&pract_id="+unescape(ord_pract_id)+"&curr_sys_date="+unescape(date_time)+"&index="+index+"&task_categ="+task_categ+"&calledFrom="+calledFrom+"&fromDate="+encodeURIComponent(fromDate)+"&toDate="+encodeURIComponent(toDate)+"&orderCategory="+orderCategory;		
			
		//var retVals = window.showModalDialog("../../eOR/jsp/ImageVideosFileUploadMain.jsp?"+finalString,arguments,features);
		//document.location.href = document.location.href;
		var accession_num="";
		var note_type="";
		var contr_mod_accession_num="";
		window_id = window.open("../../eOR/jsp/ImageVideosFileUploadMain.jsp?accession_num="+accession_num+"&note_type="+note_type+"&call_from=window&patient_id="+patient_id+"&encounter_id="+encounterId+"&order_id="+orderId+"&order_line_num="+order_line_num+"&contr_mod_accession_num="+contr_mod_accession_num,'Document1',"height=550,width=650,top=80,left=130,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
		} //IN068778 end.	//IN70146			
		else {
			
             if(colval1 == "Instructions"){

			var dialogHeight ='90vh' ;
			//IN047658 starts
			//var dialogWidth = '35' ;
			var dialogWidth = '80vw' ;
			//IN047658 ends
			var dialogTop	= '189';
			var dialogLeft = '167' ;
			//IN061903 start
			//}else if( colval1 == "Discontinue"){
			 }else if( colval1 == "Discontinue" || colval1 == "NotDone"){
			//IN061903 end
			  var dialogHeight ='90vh' ;
			  //IN047658 starts
			  //var dialogWidth = '24' ;
			  var dialogWidth = '80vw' ;
			  //IN047658 ends
			  var dialogTop	= '189';
			  var dialogLeft = '167' ;
		    }else if (colval1 == "Preps" || colval1 == "Comments" || colval1 == "Hold" || colval1 == "Resule" || colval1 == "Renew") {
		      var dialogHeight ='90vh' ;
			  //IN047658 starts
			  //var dialogWidth = '25' ;
			  var dialogWidth = '80vw' ;
			  //IN047658 starts
			  var dialogTop	= '189';
			  var dialogLeft = '200' ;
		    }
			var p_called_from_ca = parent.TaskListRightFilterFrame.document.TaskListFilterForm.p_called_from_ca.value;//Added for IN071315
		    //finalString += "&from=header&cont_order_ind=CO&cancel_type=CN&ord_cat="+ord_cat+"&order_status="+order_status+"&val1="+ord_cat+"&ord_cat_id="+ord_cat+"&performing_facility="+performing_facility+"&patient_class="+patient_class+"&encounter_id="+encounterId+"&order_set_id="+order_set_id+"&accssion_num="+accssion_num+"&patientdetails="+patientDtls;//Chowminya//Commented for IN071315
			finalString += "&from=header&cont_order_ind=CO&cancel_type=CN&ord_cat="+ord_cat+"&order_status="+order_status+"&val1="+ord_cat+"&ord_cat_id="+ord_cat+"&performing_facility="+performing_facility+"&patient_class="+patient_class+"&encounter_id="+encounterId+"&order_set_id="+order_set_id+"&accssion_num="+accssion_num+"&patientdetails="+patientDtls+"&p_called_from_ca="+p_called_from_ca;//Added for IN071315
             
			 var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
			
		 // alert("finalString=============#################"+finalString);
			 var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
			 //alert(retVals);
			 
			 if(retVals!=null ){
			     if (top.content) {
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+retVals;
				} else {
				    alert(retVals);
				}

			}
				if (colval1 != "View") {
				reloadValues();  // because of next and prev
				}
			  // document.location.reload();
 		}
}

//function callPerfMenuFunctions(colval1,colval,orderId,encounter_id,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performing_location_type,performing_location,int_or_ext,sent_out_flag,priority,order_type_code,source_type,source_code,cont_order_ind,appt_ref_num,ord_pract_id,date_time,consent_status,order_set_id,dob){//IN065942
async function callPerfMenuFunctions(colval1,colval,orderId,encounter_id,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performing_location_type,performing_location,int_or_ext,sent_out_flag,priority,order_type_code,source_type,source_code,cont_order_ind,appt_ref_num,ord_pract_id,date_time,consent_status,order_set_id,dob,prn_reg_ord,split_order_yn){//IN065942//IN071618
	var bean_id		= document.TaskListFilterResultForm.bean_id.value;
	var bean_name	= document.TaskListFilterResultForm.bean_name.value;
    if (colval1 == "View") {
		var dialogHeight ='90vh' ;
		var dialogWidth = '80vw' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;
    } else if (colval1 == "ChangePerformLocn") {

       var dialogHeight ='90vh' ;
	   //IN047658 reopen starts
		//var dialogWidth = '20' ;
		var dialogWidth = '80vw' ;
		//IN047658 reopen ends
		var dialogTop	= '250';
		var dialogLeft = '141' ;
    }
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";

        var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+ord_cat+"&order_line_num="+order_line_num;
		finalString += "&performing_facility=" + performing_facility;
		finalString += "&performing_location=" + performing_location;
		finalString += "&performing_location_type=" + performing_location_type;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&int_or_ext=" + int_or_ext;
		finalString += "&priority=" + priority;
		finalString += "&patient_class=" + patient_class;
		finalString += "&order_type_code=" + order_type_code;
		finalString += "&source_type=" + source_type;
		finalString += "&source_code=" + source_code;
		finalString += "&dob=" + dob;
		finalString += "&bean_id=" + bean_id;
		finalString += "&bean_name=" + bean_name;
	
        if (colval1 == "View") {
		  var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		}
		if (colval1 == "ChangePerformLocn") {
		  var retVals = await top.window.showModalDialog("../../eOR/jsp/RegisterOrderPerformLocn.jsp?"+finalString,arguments,features);
        }
		
		if (colval1 == "SentOut" || ((colval1 == "ResultEntry" || colval1 == "Completion") && (sent_out_flag == 'S')) ) {
			
			var dialogHeight ='90vh' ;
			var dialogWidth = '80vw' ;
			var dialogTop	= '250';
			var dialogLeft = '141' ;

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

			var retVals = await top.window.showModalDialog("../../eOR/jsp/RegisterOrderSentOut.jsp?"+finalString,arguments,features);
        }
		if (colval1 == "ReceiveResult"  || ((colval1 == "ResultEntry" || colval1 == "Completion") && (sent_out_flag == 'R')) ) {
		
			var dialogHeight ='90vh' ;
			var dialogWidth = '80vw' ;
			var dialogTop	= '129';
			var dialogLeft = '71' ;
		  var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		  //alert(finalString);
		  var retVals =await top.window.showModalDialog("../../eOR/jsp/RegisterOrderReceiveResult.jsp?"+finalString,arguments,features);
		}

		if (colval1 == "RegisterOrder") {
		
			if(consent_status == "P")
			{
				alert(getMessage("CONSENT_TO_BE_OBTAINED","OR"));
			}
			else
				//registerOrder(encounter_id,order_line_num,orderId,cont_order_ind,appt_ref_num,ord_pract_id,order_set_id);//IN065942
				registerOrder(encounter_id,order_line_num,orderId,cont_order_ind,appt_ref_num,ord_pract_id,order_set_id,ord_cat,prn_reg_ord,patient_id,patient_class,order_type_code,performing_facility,split_order_yn);//IN065942//Added new arguments for IN071618
		}
		
		var isBTViewBillDtls = document.getElementById("isBTViewBillDtls").value;//IN065324

		if ((colval1 == "NewList") || (colval1 == "SpecimenCollection") || (colval1=="SpecimenDispatch") ) 
		{
			if (colval1=="NewList")
			{
				option_list="N";
			}
			else if(colval1=="SpecimenCollection")
			{
				option_list="C";
			}
			else if(colval1=="SpecimenDispatch")
			{
				option_list="D";
			}

		     var dialogTop		=	"100px" ;
			 var dialogHeight= "90vh" ;
			 var dialogWidth = "80vw" ;
			 var status			=	"no";
			 arguments		=	"" ;
			features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
			//var action_url		=	'p_function_from=CP&p_patient_id='+patient_id+'&p_encounter_id='+encounter_id+'&p_order_id='+orderId+'&p_start_date_time='+date_time+'&options='+option_list;//IN065324
			var action_url		=	'p_function_from=CP&p_patient_id='+patient_id+'&p_encounter_id='+encounter_id+'&p_order_id='+orderId+'&p_start_date_time='+date_time+'&options='+option_list+"&isBTViewBillDtls="+isBTViewBillDtls+"&calling_from=TASK_LIST";//IN065324
			
			var retVals =await top.window.showModalDialog("../../eOR/jsp/SpecimenOrder.jsp?"+action_url,arguments,features);
		}

		if (colval1 != "View") {
		reloadValues();
		}
        //document.location.reload();
		//document.register_order_dtl.reset();
}

async function callBTMenuFunctions(colval1,colval,orderId,encounter_id,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performing_location_type,performing_location,int_or_ext,sent_out_flag,priority,order_type_code,source_type,source_code,cont_order_ind,appt_ref_num,ord_pract_id,date_time,consent_status,order_set_id,specimen_no, order_facility_id, unit_no, product_code, product_desc, blood_group, rhesus_code, row_id)
{
	var bean_id		= document.TaskListFilterResultForm.bean_id.value;
	var bean_name	= document.TaskListFilterResultForm.bean_name.value;
	
	if(colval1 == "ANDIBODY")
	{
		var dialogHeight = '90vh';
		var dialogWidth  = '80vw';
		var dialogTop	 = '150';
		var dialogLeft   = '150';

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var retVals = await top.window.showModalDialog("../../eCA/jsp/TaskListBTAntiBodyFrameSet.jsp?patient_id="+patient_id,arguments,features);
    }

	else if(colval1 == "REQRMENT")
	{
		var dialogHeight = '90vh';
		var dialogWidth  = '80vw';
		var dialogTop	 = '150';
		var dialogLeft   = '150';

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var retVals = await window.showModalDialog("../../eCA/jsp/TaskListBTRequirementFrameSet.jsp?patient_id="+patient_id,arguments,features);
    }

	else if(colval1 == "TRANSHIST")	
	{
		var dialogHeight = '90vh' ;
    	var dialogWidth  = '80vw' ;
    	var dialogTop	 = '129';
    	var dialogLeft	 = '30' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
        var arguments 	= "";
		var retVals =await window.showModalDialog("../../eCA/jsp/FlowSheet.jsp?p_patient_id="+patient_id+"&p_hist_rec_type=BLTF&p_called_from=OR",arguments,features);
	}
	else if(colval1 == "ORDDTL")
	{
		var dialogHeight ='90vh' ;
		var dialogWidth = '80vw' ;
		var dialogTop	= '90';
		var dialogLeft = '11' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";

		var finalString	= "colval1=View&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+ord_cat+"&order_line_num="+order_line_num;
		finalString += "&performing_facility=" + performing_facility;
		finalString += "&performing_location=" + performing_location;
		finalString += "&performing_location_type=" + performing_location_type;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&int_or_ext=" + int_or_ext;
		finalString += "&priority=" + priority;
		finalString += "&patient_class=" + patient_class;
		finalString += "&order_type_code=" + order_type_code;
		finalString += "&source_type=" + source_type;
		finalString += "&source_code=" + source_code;
		finalString += "&bean_id=" + bean_id;
		finalString += "&bean_name=" + bean_name;
	
		var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
	}
	else if(colval1 == "RECCONS")	
	{
		var dialogHeight = '90vh' ;
    	var dialogWidth  = '80vw' ;
    	var dialogTop	 = '230';
    	var dialogLeft	 = '30' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
        var arguments 	= "";
        //Added by Archana Dhal related to IN022960 start.
		var xmlStr ="<root><SEARCH ";
			xmlStr += "patient_id=\""+ patient_id +"\" " ;
			xmlStr += "order_facility_id=\""+ order_facility_id +"\" " ;
			xmlStr += "specimen_no=\""+ specimen_no +"\" " ;			
			xmlStr += "product_code=\""+ product_code +"\" " ;			
			xmlStr += "unit_no=\""+ unit_no +"\" " ;			
			xmlStr += "product_desc=\""+ product_desc +"\" " ;			
			xmlStr += "blood_group=\""+ blood_group +"\" " ;			
			xmlStr += "rhesus_code=\""+ rhesus_code +"\" " ;			
			xmlStr +=" /></root>" ;					
			var xmlHttp = new XMLHttpRequest() ;
			var xmlDoc = "" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "TaskListBTRecordConsumptionIntermediate.jsp", false) ;
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			var restext = eval(responseText);//end
			
		   if(restext)//If condition is added by Archana Dhal related to IN022960.
		  {
			var action_url = "../../eCA/jsp/TaskListBTRecordConsumptionMain.jsp?patient_id="+patient_id+"&specimen_no="+specimen_no+"&order_facility_id="+order_facility_id+"&unit_no="+unit_no+"&product_code="+product_code+"&product_desc="+product_desc+"&blood_group="+blood_group+"&rhesus_code="+rhesus_code;
			
			var retVals = await window.showModalDialog(action_url,arguments,features);
			//var retVals = window.open(action_url,arguments,features);
		}
	}

	else if(colval1 == "RQSTPRNT" || colval1 == "RQSTREPRNT")	
	{
		var print_mode;

		if(colval1 == "RQSTPRNT")
			print_mode = "REQUEST";
		else
			print_mode = "REPRINT";

		//var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
		//var xmlHttp = new XMLHttpRequest() 
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc = "";
		xmlStr ="<root><SEARCH patient_id=\""+patient_id+"\"  facility_id=\""+order_facility_id+"\" specimen_no=\""+specimen_no+"\" unit_no=\""+unit_no+"\"	product_code=\""+product_code+"\" print_mode=\""+print_mode+"\" rowid=\""+row_id+"\" /></root>"
	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST", "../../servlet/eCA.TaskListBTRequestServlet", false);
		xmlHttp.send(xmlDoc);
		//alert(getMessage("REQUEST_PRINT","CA"));//Commented by Archana Dhal related to IN023348
		alert(getBTMessage('BT0208','BT'));//Added by Archana Dhal related to IN023348
	}
	if(colval1 == "RQSTPRNT" || colval1 == "RQSTREPRNT" || colval1 == "RECCONS")
	{
		reloadValues();
	}
}

async function viewHistory(patient_id)
{
	var dialogHeight = '90vh' ;
	var dialogWidth  = '80vw' ;
	var dialogTop	 = '129';
	var dialogLeft	 = '30' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments 	= "";
	var retVals = await window.showModalDialog("../../eCA/jsp/FlowSheet.jsp?p_patient_id="+patient_id+"&p_hist_rec_type=BLTF&p_called_from=OR",arguments,features);
	
}

async function viewRequest(request_date,request_by)
{
	var dialogHeight = '90vh';
	var dialogWidth  = '80vw';
	var dialogTop	 = '200';
	var dialogLeft   = '150';

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

	var retVals =await  window.showModalDialog("../../eCA/jsp/TaskListBTViewRequestFrameSet.jsp?request_date="+request_date+"&request_by="+encodeURIComponent(request_by),arguments,features);
}

//function registerOrder(encounter_id,order_line_num,orderId,cont_order_ind,appt_ref_num,ord_pract_id,order_set_id){//IN065942
function registerOrder(encounter_id,order_line_num,orderId,cont_order_ind,appt_ref_num,ord_pract_id,order_set_id,order_category,prn_reg_ord,patient_id,patient_class,order_type_code,performing_facility,split_order_yn){//IN065942//Added new arguments for IN071618
	var formObj = document.TaskListFilterResultForm;
	formObj.bean_id.value ="Or_RegisterOrder";
	formObj.bean_name.value ="eOR.RegisterOrder";
	formObj.total_recs.value ="1";
	formObj.chk0.value ="on";
	formObj.ord_id0.value =orderId;
	formObj.cont_order_ind0.value =cont_order_ind;
	formObj.appt_ref_num0.value =appt_ref_num;
	formObj.encounter_id0.value =encounter_id;
	formObj.view_by0.value ="H";
	formObj.practitioner_id.value =ord_pract_id;
	formObj.mode.value ="1";
	formObj.line_id0.value =order_line_num;
	formObj.order_set_id0.value =order_set_id;
	formObj.order_category0.value =order_category;//IN065942
	formObj.prn_reg_ord0.value =prn_reg_ord;//IN065942
	// IN071618 Starts

    if("Y"==split_order_yn){
    	var retVal = checkBillSettlementforCatalog(orderId,order_type_code,patient_class,patient_id,encounter_id,"0",performing_facility);
    
    	if(undefined!=retVal)
    	{
    		eval(formApply(formObj,OR_CONTROLLER ));
    	}
    }
    else{
    	eval(formApply(formObj,OR_CONTROLLER ));
   	if(!result)
   	  alert(message);
    }

	// IN071618 Ends

	prnRegLabel();//IN065942
	populateValues();
	
}
function assignResult(_result, _message, _flag, _code)
{
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _code ;

}



function reloadValues(){
	if (parent.TaskListRightResultFrame)
	{
		parent.TaskListRightResultFrame.location.reload();
	}
}

function clearOrderTValues(docObj)
{
	var len = eval(docObj+".TaskListFilterForm.OrderType.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".TaskListFilterForm.OrderType.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.OrderType.label","Common")+" - "+getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".TaskListFilterForm.OrderType.add(opt)") ;
}

function clearIntervention(docObj)
{
	var len = eval(docObj+".TaskListFilterForm.interventionType.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".TaskListFilterForm.interventionType.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("eCA.InterventionType.label","CA")+" - "+getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".TaskListFilterForm.interventionType.add(opt)") ;
}

async function resultViewOrder(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat){

		var dialogHeight ='100vh' ;
		var dialogTop	= '0vh';
		var dialogLeft = '0vh' ;
		var dialogWidth = '80vw' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat;
		//alert(finalString)
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}

function displayToolTip_int(index,obj)
{
	//alert("here  "+index)
	callMouseOverOnTD_oth(obj);
	//var obj1=document.getElementById("tooltiplayer");
/*	var count = document.patTaskListResultForm.count.value
	for(var indexI =0 ;indexI < parseInt(count);indexI++)
		{
			if(index != indexI)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexI);
					obj.style.visibility='hidden'
			}
		}*/
	//	alert(obj1);
	//if(obj1 != null)
	//{

			buildTable_int(index)
		/*	bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' */
	//}
}

function buildTable_int(index)
{
	var p='P'
	var N='N'
	var status = eval("document.forms[0].status"+index);
	var adminStatus = eval("document.forms[0].adminStatus"+index);
	//alert("adminStatus    "+adminStatus.value);
	if(adminStatus.value=='D' || adminStatus.value == 'O')
	{
		 if(status.value=='Pending')
		{
			performTask_int(index)
		}
	}
/*	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTask("+index+",\""+p+"\")' ><font color='blue'>Performed</font></a></td>";
			
			tab_dat     += "</tr>";
				tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTask(\""+index+"\",\""+N+"\")'><font color='blue'> Not Performed</font></a></td>";
			tab_dat     += "</tr>";
			tab_dat     += "</table>";
			var td = eval("document.getElementById("t")"+index);
			td.innerHTML = tab_dat;
			*/
}

async function performTask_int(index)
{
	hideToolTip_int(index)
	var rowId = document.getElementById("rowId")+index;

	var dateTime =  eval("document.forms[0].scheduleDate"+index+".value")
	var taskType =   eval("document.forms[0].taskCode"+index);
	var task =  eval("document.forms[0].taskType"+index);
	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);
	var patientId = eval("document.forms[0].patientId"+index);;
	var remarks = eval("document.forms[0].remarks"+index);
	var performedId  = eval("document.forms[0].performedId"+index);
	var dialogTop		=	"200px" ;
	var dialogHeight= "90vh" ;
    var dialogWidth = "80vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListPerformFrameSet.jsp?dateTime='+dateTime+'&taskType='+taskType.value+'&task='+task.value+'&patientId='+patientId.value+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value;
	var retVal=await window.showModalDialog(action_url,arguments,features);		
	//	SearchTaskCriteriaForPerform()
	reloadValues();
}

function hideToolTip_int(index)
{

	var td= document.getElementById("tooltiplayer"+index)
	if(td != null)
	{
		td.style.visibility = 'hidden'
	}
}
/*The below trans_pract_id parameter is replaced by req_pract_id parameter on 4/27/2010 at 10:30 AM for IN020723 by Archana Dhal.*/
function displayToolTipForEvents_int(index,resultType,resultId,patient_class,accession_num,req_pract_id,note_type,obj)
{
	callMouseOverOnTD_oth(obj);
	var resultDescription = "";
	var jsp = "";
	var orderCategory = eval("document.forms[0].taskCategory"+index);
	//alert("orderCategory="+orderCategory.value);
	//alert("resultType="+resultType);
	//alert("index="+index);
	//alert("resultId="+resultId);
	//alert("i am in function ");
	var dxChkBfrPlaceOrderYN = true;  //26826
	if(orderCategory.value=='I')
	{	
		//26826 start.
		if((eval("document.forms[0].dxChkBfrPlaceOrderYN"+index).value)=="N"){
			dxChkBfrPlaceOrderYN=false;
		}
		//26826 End.
		if(resultType=='CH')
		{
				resultDescription = "Chart"
				jsp = "ChartRecording.jsp"
		}
		else if(resultType=='DA' || resultType=='DP')
		{
				resultDescription = "Discrete Measure Atomic"
				jsp = "PatTaskListDiscrMeasureAtomicFrameSet.jsp"
		}
		else if (resultType=='NT')
		{
				resultDescription = "Note Type"
				//jsp = "PatTaskListNoteType.jsp"
				jsp = "RecClinicalNotesModal.jsp"
		}
		else if (resultType=='PR')
		{
				resultDescription = "Procedure"
				jsp = "PatTaskListProcedure.jsp"
		}
		else if(resultType=='OR')
		{	
				resultDescription = "Place Order"
				jsp = "EnterOrder.jsp"
		}
		else
		{
			resultDescription = "Result Matrix"
			jsp = "PatTaskListResultMatrix.jsp"
		}
	}
	else if(orderCategory.value=='M')
	{
			resultDescription = "Admin Medication"
		jsp="MedicationAdministrationFTDrugDtls.jsp"

	}
	else if(orderCategory.value=='O')
	{
				resultDescription = "Result Entry"
				jsp="ResultEntry.jsp"
	}
	else if(orderCategory.value=='S')
	{
			resultDescription = "Specimen's Order"
			jsp="SpecimenOrder.jsp"
	}

	//var obj1=eval("document.getElementById("tooltiplayer")"+index);
/*	var count = document.patTaskListResultForm.count.value
	for(var indexI =0 ;indexI < parseInt(count);indexI++)
	{
			if(index != indexI)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexI);
					obj.style.visibility='hidden'
			}
	}*/
	if(dxChkBfrPlaceOrderYN){ //26826
		buildTableForEvents_int(index,resultDescription,resultId,jsp,resultType,patient_class,accession_num,req_pract_id,note_type)
	}else{ //26826
		alert(getMessage("DIAG_NOT_RECORDED","OR"));  //26826
	}	
/*	if(obj1 != null)
	{

			
			bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' 
	}	*/

}

function buildTableForEvents_int(index,resultDescription,resultId,jsp,resultType,patient_class,accession_num,req_pract_id,note_type)
{
	var p='P'
	performTaskForEvents_int(index,p,resultId,jsp,resultType,patient_class,accession_num,req_pract_id,note_type)
/*	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
	tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskForEvents("+index+",\""+p+"\",\""+resultId+"\",\""+jsp+"\",\""+resultType+"\")' ><font color='blue'>"+resultDescription+"</font></a></td>";
	tab_dat     += "</tr>";
	tab_dat     += "</table>";
	var td = eval("document.getElementById("t")"+index);
	td.innerHTML = tab_dat;
	*/
}

async function performTaskForEvents_int(index,Status,resultId,jsp,resultType,patient_class,accession_num,req_pract_id,note_type)
{
	//alert("=index="+index +"=Status="+Status+"=resultId="+resultId+"=jsp="+jsp+"=resultType="+resultType);
	//var rowId = eval("document.getElementById("rowId")"+index);hideToolTipPopulationCriteria(index)
	var dateTime = eval("document.forms[0].scheduleDate"+index+".value")
	var taskType =   eval("document.forms[0].taskCode"+index);
	var task =  eval("document.forms[0].taskType"+index);
	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);
	var patient_id = eval("document.forms[0].patientId"+index+".value");;
	var scheduledDate= eval("document.forms[0].scheduleDate"+index);
	var orderCategory =  eval("document.forms[0].taskCategory"+index);
	var orderId =  eval("document.forms[0].orderId"+index);

	var orderNum =  eval("document.forms[0].orderNum"+index);
	var patId =patient_id.split(" ") 
	var OrderId = eval("document.forms[0].orderId"+index+".value")
	var remarks = eval("document.forms[0].remarks"+index);
	var performedId  = eval("document.forms[0].performedId"+index);
	
	//alert('taskType...'+taskType.value+'..task..'+task.value+'..taskSrlNo..'+taskSrlNo.value+'...patient_id...'+patient_id.value+'..orderCategory....'+orderCategory.value+'..orderId..'+orderId.value+'...performedId...'+performedId.value+'...patId...'+patId);
	var dialogTop		=	"200" ;
	var dialogHeight= "90vh" ;
    var dialogWidth = "80vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		
	
	var encounter_id = eval("document.forms[0].encounterId"+index+".value")
	var facility_id  = eval("document.forms[0].facilityId"+index+".value")
	
	if(orderCategory.value=='I')
	{
		if(resultType=='OR' ||resultType=='CH' )
		{
			 dialogTop		=	"74" ;
			 dialogHeight= "90vh" ;
			 dialogWidth = "80vh" ;
			status			=	"no";
			 arguments		=	"" ;
		 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		 if(encounter_id != "")
			{
					 if(resultType=='OR')
					var action_url		=	'../../eOR/jsp/'+jsp+'?p_task_code='+taskType.value+'&patient_id='+patient_id+'&p_task_srl_no='+taskSrlNo.value+'&function_from=CP&p_start_date_time='+trimString(dateTime)+'&p_order_catalog_code='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			 else
				var action_url		=	'../../eCA/jsp/'+jsp+'?patient_id='+patient_id+'&function_from=CP&p_start_date_time='+dateTime+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&taskCode='+taskType.value+'&task_srl_no='+taskSrlNo.value;
			}
		}
		else
		{

			if(resultType=='DA' || resultType=='DP')
			{
			
				 if(resultType=='DA')
				{
					dialogTop		=	"200" ;	
					dialogHeight= "90vh" ;
					dialogWidth = "80vw" ;
					status			=	"no";
					arguments		=	"" ;
				}
			else
				{
				dialogTop		=	"100" ;
				 dialogHeight= "90vh" ;
				 dialogWidth = "80vw" ;
				status			=	"no";
				 arguments		=	"" ;
				}
				 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;	
				var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patient_id+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
			else if(resultType=='NT')
			{

				
					dialogTop		=	"200" ;
					dialogHeight= "90vh" ;
					dialogWidth = "80vw" ;
					status			=	"no";
					arguments		=	"" ;
					// features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
					 features		=	"modal =yes,height=680,width=1000,top=10,left=5,resizable=no,status=no,location=no,scrollbars=no";
					
				var action_url		=	'../../eCA/jsp/'+jsp+'?title=Transcribe notes&note_type='+note_type+'&patient_id='+patient_id+'&performedId='+req_pract_id+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&contr_mod_accession_num='+accession_num+'&patient_class='+patient_class+'&function_id=TASK_LIST';
				

				 //var action_url ="../../eCA/jsp/RecClinicalNotesModal.jsp?title=Task List Notes&note_type="+resultId+"&patient_id="+patientId+"&function_id=SPCL_NOTE&episode_id="+encounter_id+"&encounter_id="+encounter_id+"&patient_class=IP&facility_id="+facility_id;
				//'taskType='+taskType.value+'&patient_id='+patient_id+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;



			
			}
			else{
					
					dialogTop		=	"200" ;
					dialogHeight= "90vh" ;
					dialogWidth = "80vw" ;
					status			=	"no";
					arguments		=	"" ;
					 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
				var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patient_id+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
		}
	}
	else if(orderCategory.value=='M')
	{
	
		dialogTop		=	"100" ;
			 dialogHeight= "90vh" ;
			 dialogWidth = "80vw" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../ePH/jsp/'+jsp+'?&patient_id='+patient_id+'&function_from=CP&p_start_date_time='+dateTime+'&p_ord_drug_code='+taskType.value+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&p_dosage_seq_no='+taskSrlNo.value+'&order_id='+OrderId;
	}
	else if(orderCategory.value=='O')
	{
			dialogTop		=	"100" ;
			 dialogHeight= "90vh" ;
			 dialogWidth = "80vw" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url	='../../eOR/jsp/'+jsp+'?colval1=CP&orderId='+OrderId+'&report_srl_no='+taskSrlNo.value+'&patient_id='+patient_id+'&order_category='+orderCategory.value
	}
	else if(orderCategory.value=='S')
	{
			
		dialogTop		=	"100" ;
			 dialogHeight= "90vh" ;
			 dialogWidth = "80vw" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../eOR/jsp/'+jsp+'?p_function_from=CP&p_patient_id='+patient_id+'&p_encounter_id='+encounter_id+'&p_order_id='+OrderId+'&p_start_date_time='+dateTime;
	}
	
		if(resultType=='NT')
		{
			var window_obj = null;
			arguments = 'TRANSCRIBER';
			window_obj =	window.open(action_url,arguments,features);
			if(window_obj != null)
			{
				window_obj.focus();
			}
		}else{
			//alert("action_url="+action_url);
			var retVal=await window.showModalDialog(action_url,arguments,features);	
			//var retVal=window.open(action_url,arguments,features);	
		}
		reloadValues();
		if(resultType=='NT')
		{
			/*if (window.opener && !window.opener.closed) 
			{
				alert("window.opener    :   "+window.opener);
				window.opener.location.reload();
			} */
			//alert(getMessage('RELOAD_CHANGES','CA'));
			//parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.go.click();
		}
	//SearchTaskCriteriaForPerform()

	
}

//function displayToolTipForEventsPopulation(index,resultType,resultId,obj)//IN066125
function displayToolTipForEventsPopulation(index,resultType,resultId,obj,dob)//IN066125
{	
	callMouseOverOnTD_oth(obj)
	var resultDescription = "";
	var jsp = "";
	var orderCategory =  eval("document.forms[0].taskCategory"+index);
	
	if(orderCategory.value=='I')
	{
		if(resultType=='CH')
		{
				resultDescription = "Chart"
				jsp = "ChartRecording.jsp"
		}
		else if(resultType=='DA' || resultType=='DP')
		{
				resultDescription = "Discrete Measure Atomic"
				jsp = "PatTaskListDiscrMeasureAtomicFrameSet.jsp"
		}
		else if (resultType=='NT')
		{
				resultDescription = "Note Type"
				jsp = "RecClinicalNotesModal.jsp"
		}
		else if (resultType=='PR')
		{
				resultDescription = "Procedure"
				jsp = "PatTaskListProcedure.jsp"
		}
		else if(resultType=='OR')
		{	
				resultDescription = "Place Order"
				jsp = "EnterOrder.jsp"
		}
		else
		{
			resultDescription = "Result Matrix"
			jsp = "PatTaskListResultMatrix.jsp"
		}
	}
	else if(orderCategory.value=='M')
	{
					resultDescription = "Admin Medication"
		jsp="MedicationAdministrationFTDrugDtls.jsp"

	}
	else if(orderCategory.value=='O')
	{
				resultDescription = "Result Entry"
				jsp="ResultEntry.jsp"
	}
	else if(orderCategory.value=='S')
	{
			resultDescription = "Specimen's Order"
			jsp="SpecimenOrder.jsp"
	}else if(orderCategory.value=='R')
	{
		//	resultDescription = "Register Order"
		//	jsp="SpecimenOrder.jsp"
	}


	//var obj1=eval("document.getElementById("tooltiplayer")"+index);
/*	var count = document.patTaskListResultForm.count.value;
	for(var indexI =0 ;indexI < parseInt(count);indexI++)
	{
		if(index != indexI)
		{
			var obj = eval("document.getElementById("tooltiplayer")"+indexI);
				obj.style.visibility='hidden'
		}
	}
*///alert(obj1)
	//if(obj1 != null)
	//{

			//buildTableForEventsPopulation(index,resultDescription,resultId,jsp,resultType)//IN066125
			buildTableForEventsPopulation(index,resultDescription,resultId,jsp,resultType,dob)//IN066125
	/*		bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' 
			*/
	//}	

}

//function buildTableForEventsPopulation(index,resultDescription,resultId,jsp,resultType)//IN066125
function buildTableForEventsPopulation(index,resultDescription,resultId,jsp,resultType,dob)//IN066125
{
	var p='P'
//performTaskForEventsPopulation(index,p,resultId,jsp,resultType)//IN066125
performTaskForEventsPopulation(index,p,resultId,jsp,resultType,dob)//IN066125
/*	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
	tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskForEventsPopulation("+index+","+indexK+","+noOfRows+",\""+p+"\",\""+resultId+"\",\""+jsp+"\",\""+resultType+"\")' ><font color='blue'>"+resultDescription+"</font></a></td>";
	tab_dat     += "</tr>";
	tab_dat     += "</table>";
	var td = eval("document.getElementById("t")"+index);
	td.innerHTML = tab_dat;
	*/
}
//function performTaskForEventsPopulation(index,Status,resultId,jsp,resultType)//IN066125
async function performTaskForEventsPopulation(index,Status,resultId,jsp,resultType,dob)//IN066125
{
//hideToolTipPopulationCriteria(index)
	//var rowId =  eval("document.getElementById("trRowId")"+indexK+noOfRows);
	var dateTime =  eval("document.forms[0].scheduleDate"+index+".value")
	//var dateTime =  "17/03/2008 15:15";
	var taskType =   eval("document.forms[0].taskCode"+index);
	var task =  eval("document.forms[0].taskType"+index);
	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);
	var patientId = eval("document.forms[0].patientId"+index+".value");;
	
	var remarks = eval("document.forms[0].remarks"+index);
	var performedId  = eval("document.forms[0].performedId"+index);
	var dialogTop		=	"200px" ;
	var dialogHeight= "90vh" ;
    var dialogWidth = "80vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var encounter_id = eval("document.forms[0].encounterId"+index+".value")
	var facility_id  = eval("document.forms[0].facilityId"+index+".value")
	var orderCategory =  eval("document.forms[0].taskCategory"+index);
	var OrderId = eval("document.forms[0].orderId"+index+".value")
	var scheduleDate = eval("document.forms[0].scheduleDate"+index+".value")
	var route_admin = document.forms[0].route_admin.value
	var nursing_unit = document.forms[0].nursing_unit.value

	
if(orderCategory.value=='I')
{
		if(resultType=='OR' ||resultType=='CH' )
		{
			 dialogTop		=	"10px" ;
			 dialogHeight= "100vh" ;
//			 dialogWidth = "50" ;
			 dialogWidth = "90vw" ;
			status			=	"no";
			 arguments		=	"" ;
		 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		 if(encounter_id != "")
			{
					 if(resultType=='OR')
					var action_url		=	'../../eOR/jsp/'+jsp+'?p_task_code='+taskType.value+'&patient_id='+patientId+'&p_task_srl_no='+taskSrlNo.value+'&function_from=CP&p_start_date_time='+trimString(dateTime)+'&p_order_catalog_code='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			 else
				var action_url		=	'../../eCA/jsp/'+jsp+'?patient_id='+patientId+'&function_from=CP&p_start_date_time='+dateTime+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&taskCode='+taskType.value+'&task_srl_no='+taskSrlNo.value;
			}
		}
		else if(resultType=='NT')
		{
			   dialogTop = "94";
			  dialogHeight = "100vh";
			  dialogWidth = "90vw";
			 features = "top="+dialogTop+",height="+dialogHeight+",width="+dialogWidth+",status=no,left=0";

			 var action_url ="../../eCA/jsp/RecClinicalNotesModal.jsp?title=Task List Notes&note_type="+resultId+"&patient_id="+patientId+"&function_id=SPCL_NOTE&episode_id="+encounter_id+"&encounter_id="+encounter_id+"&patient_class=IP&facility_id="+facility_id;
			 
			// var action_url ="../../eCA/jsp/RecClinicalNotes.jsp?title=Task List Notes&appl_task_id=&note_type="+resultId+"&patient_id="+patientId+"&episode_id="+encounter_id+"&patient_class="++"&function_id="++"&event_class="++"&accession_num="++"&window_close="++"&ot_speciality_code="+ot_s+"&hide_header="++"&tab_yn="++"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+;
		}
		else
		{
			if(resultType=='DA' || resultType=='DP')
			{

				 if(resultType=='DA')
				{
				 dialogTop		=	"200" ;	
					dialogHeight= "90vh" ;
				  dialogWidth = "80vw" ;
					 status			=	"no";
				 arguments		=	"" ;
				}
			else
				{
				dialogTop		=	"100" ;
				 dialogHeight= "90vh" ;
				 dialogWidth = "80vw" ;
				status			=	"no";
				 arguments		=	"" ;
				}
			 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patientId+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
			else
			{
				dialogTop		=	"200" ;
					dialogHeight= "100vh" ;
					dialogWidth = "90vw" ;
//					dialogWidth = "30" ;
					status			=	"no";
					arguments		=	"" ;
					 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
				var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patientId+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
		}
	}
	else if(orderCategory.value=='M')
	{

		dialogTop		= "100";
		dialogHeight	= "100vh";
//		dialogWidth		= "60";
		dialogWidth		= "90vw";
		status			= "no";
		arguments		= "" ;
		
		features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		//var action_url		=	'../../ePH/jsp/'+jsp+'?&patient_id='+patientId+'&function_from=CP&p_start_date_time='+dateTime+'&p_ord_drug_code='+taskType.value+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&p_dosage_seq_no='+taskSrlNo.value+'&order_id='+OrderId+'&route_admin='+route_admin+'&nursing_unit='+nursing_unit;//IN066125
		var action_url		=	'../../ePH/jsp/'+jsp+'?&patient_id='+patientId+'&function_from=CP&p_start_date_time='+dateTime+'&p_ord_drug_code='+taskType.value+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&p_dosage_seq_no='+taskSrlNo.value+'&order_id='+OrderId+'&route_admin='+route_admin+'&nursing_unit='+nursing_unit+'&dob='+dob;//IN066125
	}
	else if(orderCategory.value=='O')
	{
			dialogTop		=	"140" ;
			 dialogHeight= "100vh" ;
			 dialogWidth = "90vw" ;
			 dialogLeft = "0" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"Height=" + dialogHeight + "; Width=" + dialogWidth + "; Top=" + dialogTop + "; Left=" + dialogLeft + ";scroll=no; status:" + status;
		var action_url	='../../eOR/jsp/'+jsp+'?colval1=CP&orderId='+OrderId+'&report_srl_no='+taskSrlNo.value+'&patient_id='+patientId+'&order_category='+orderCategory.value+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&patient_class='+document.getElementById("patient_class").value+ '&TLchild_order_index=1&TLchild_reporting_date='+scheduleDate;
	}
	else if(orderCategory.value=='S')
	{
		dialogTop		=	"100" ;
			 dialogHeight= "100vh" ;
//			 dialogWidth = "50" ;
			 dialogWidth = "90vw" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../eOR/jsp/'+jsp+'?p_function_from=CP&p_patient_id='+patientId+'&p_encounter_id='+encounter_id+'&p_order_id='+OrderId+'&p_start_date_time='+dateTime;
	}

	if(resultType=='NT')
	{
		var window_obj = null;
		window_obj =	window.open(action_url,arguments,features);
		if(window_obj != null)
		{
			window_obj.focus();
		}
		//reloadValues();
		parent.TaskListRightResultFrame.location.reload();
	}
	else if(orderCategory.value=='O')
	{
		//child =	window.open(action_url,arguments,features);
		parent.patTaskListResultFrame.newWindow(action_url,arguments,features);
	}
	else
	{
		var retVal=await top.window.showModalDialog(action_url,arguments,features);	
	}
	//var retVal=window.open(action_url,arguments,features);		

	/* modified by Kishore kumar N on Sept-08-09 for CRF 691*/
	var callFrom = document.getElementById("callFrom").value;
	if (callFrom != 'IM')
	{
			reloadValues();
		if(resultType=='NT')
		{

		}
	}
	else if (callFrom == 'IM')
	{		
		 parent.parent.VaccineTabResult.PendingRxResultFrm.location.reload();
		 if (top.content.workAreaFrame.ExistScheduleTreeFrame)
		{
			top.content.workAreaFrame.ExistScheduleTreeFrame.location.reload();
		}
	}
	/*ends here.*/
}

/*function loadpage()
{
	if (child != null)
	{
		if(child.closed == false)
		{
			child.focus();
			window.onblur = loadpage;
			//parent.window.onfocus = loadpage();
			//loadpage();
		}
	} 
}*/

function validateFormFields(paramVal)
{
	var locn_code = "";
	var location_type = "";
	var patient_id = "";
	var search1 = "";
	var chkFlag = "";
	var errorMsg = "";
	var tlFlag = "";
if (paramVal == "onButtonClick")
{
 locn_code=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn.value;
 location_type=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.location_type.value;
 patient_id=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_id.value;
 search1=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search_T.value;

 tlFlag = parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.TaskListFlag.value;
}else if (paramVal == "onDateClick")
{
	locn_code=parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn.value;
 	location_type=parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.location_type.value;
 	patient_id=parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_id.value;
 	search1=parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.search_T.value;

	tlFlag = parent.parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.TaskListFlag.value;
}
if (tlFlag == "T")
{
	if (locn_code== "" || locn_code == null)
	{
		errorMsg = getMessage("LOCATION_CODE_NOTNULL","CA");	
		chkFlag = "chkNull";
		alert(errorMsg);	
	}
	if (search1 == "S" && (patient_id == "" || patient_id == null))
	{	
		errorMsg = getMessage("PATIENT_ID_NOTNULL","CA");
		chkFlag = "chkNull";
		alert(errorMsg);	
	}
}

return chkFlag;

}

// For the Next and Prev Logic
// Parameters to be passed are start, end, checkbox_name, form_name
function displayRecords(start, end, form_name)
	{
 		var formObj					= eval("document."+form_name);
		var ckhDue="";
		var chkOverdue="";
		var chkElapsed="";
		var chkPerformed="";
		var chkFuture="";
		var chkReg="";
		var chkAll="";
		var chkUnclassify="";

 		if(formObj)
			{
				formObj.from.value		= start;
				formObj.to.value		= end;   	
				
				var locn_desc=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn_code.value;
				var locn_code=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.locn.value;
				var location_type=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.location_type.value;
				var patient_id=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.patient_id.value;
				var localeName=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.localeName.value;
				var taskListFlag=parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.TaskListFlag.value;

				//Left StatusFrame
				//var status_code=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.status_code.value;
				var taskSelect=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.task_code.value;
				var taskSelectAll=parent.parent.TaskListLeftFrame.TaskListleftStatusFrame.document.TaskStatusForm.str_appl_task.value;

				//Right FilterFrame
				var status_code=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.statusCode.value;
				if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.checked)
				{
					//chkAll=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkAll.value;
					chkAll="Y";
				}else{
					chkAll="N";
				}
				if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.checked)
				{
					ckhDue="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.ckhDue.value;
				}else{
					ckhDue="N";
				}
				if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.checked)
				{
					chkOverdue="Y";   //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.value;
				}else{
					chkOverdue="N";
				}
				if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.checked)
				{
					chkElapsed="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkElapsed.value;
				}else{
					chkElapsed="N";
				}
				if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.checked)
				{
					chkPerformed="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkPerformed.value;
				}else{
					chkPerformed="N";
				}
				if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.checked)
				{
					chkFuture="Y";  //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkFuture.value;
				}else{
					chkFuture="N";
				}
				if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkUnclassify.checked)
				{
					chkUnclassify ="Y";   //parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkOverdue.value;
				}else{
					chkUnclassify ="N";
				}
				/*if (parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkReg.checked)
				{
					chkReg=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.chkReg.value;
				}
				 */
				//var taskSelect=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.taskSelect.value;

				var OrderCategory=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value;
				var OrderType=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.value;
				var Groupby=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.Groupby.value;
				var To_date=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.To_date.value;
				var From_date=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.From_date.value;
				var pat_discharge=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.pat_discharge.value;
				var onclickS=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.onclickS.value;
				var clickdate=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.clickdate.value;
				var AdminRoute=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.AdminRoute.value;
				var from=parent.parent.TaskListRightFrame.TaskListRightResultFrame.document.TaskListFilterResultForm.from.value;
				var to=parent.parent.TaskListRightFrame.TaskListRightResultFrame.document.TaskListFilterResultForm.to.value;
				
				var relationship_id=parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.relationship_id.value;

				//alert("clickdate  "+parent.parent.TaskListLeftFrame.TaskListCalendarFrameBottom.document.TaskListCalendarForm.clickdate.value);
				//alert("onclickS  "+parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.onclickS.value);
				if(onclickS=="Y")
				{
				To_date=clickdate;
				From_date=clickdate;
				}



				var qry_string="locn_desc="+locn_desc;
				qry_string += "&locn_code="+locn_code;
				qry_string += "&location_type="+location_type;
				qry_string += "&patient_id="+patient_id;
				qry_string += "&localeName="+localeName;
				qry_string += "&status_code="+status_code;
				qry_string += "&taskSelect="+taskSelect;
				qry_string += "&OrderCategory="+OrderCategory;
				qry_string += "&OrderType="+OrderType;
				qry_string += "&Groupby="+Groupby;
				qry_string += "&To_date="+To_date;
				qry_string += "&From_date="+From_date;
				qry_string += "&pat_discharge="+pat_discharge;
				qry_string += "&chkAll="+chkAll;
				qry_string += "&ckhDue="+ckhDue;
				qry_string += "&chkOverdue="+chkOverdue;
				qry_string += "&chkUnclassify="+chkUnclassify;
				qry_string += "&chkElapsed="+chkElapsed;
				qry_string += "&chkPerformed="+chkPerformed;
				qry_string += "&chkFuture="+chkFuture;
				qry_string += "&chkReg="+chkReg;
				qry_string += "&taskListFlag="+taskListFlag;
				qry_string += "&taskSelectAll="+taskSelectAll;
				qry_string += "&AdminRoute="+AdminRoute;
				qry_string += "&from="+from;
				qry_string += "&to="+to;
				qry_string += "&relationship_id="+relationship_id;


				parent.parent.TaskListLeftFrame.TaskListLeftPatientSearchFrame.document.TaskPatientSearchForm.searchbutton.disabled= true;
				parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.TaskListFilterForm.go.disabled= true;

				var chkFlag = validateFormFields("onButtonClick");
				if (chkFlag == "chkNull")
				{	
					/*		Modified by Kishore Kumar N on Sept08-09 for CRF 691					*/
					enableBtn('');	
					/*ends here.*/
				}else{	
					//alert("qry_string::::"+qry_string);
					parent.parent.TaskListRightFrame.TaskListRightResultFrame.location.href="../jsp/TaskListRightResult.jsp?"+qry_string
				}
	 	} // End of formObj
 } // End of displayRecords

async function callMednDetails(patient_id,nursing_unit,admin_date,patient_class){
	/*var dialogHeight	= "40";
	var dialogWidth	= "65"; //modified by Arvind @ 04-12-2008
	//var dialogTop		= "60";
	var dialogTop		= "78";
	var dialogLeft		= "00";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				= window.showModalDialog("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_date="+admin_date+"&patient_class="+patient_class+"&called_from=MEDADMIN",arguments,features);*/ // commenteed for PMG2014-CRF-0026 [IN:052701]
	var dialogHeight	= "100vh";// Added for PMG2014-CRF-0026 [IN:052701] -start
	var dialogWidth		= "100vw";
	var dialogTop		= "0";
	//dialogWidth		= (window.innerHeight);
	//win_width		= (window.innerWidth);	
	/*if(win_width==undefined){
		dialogHeight		= (document.documentElement.clientHeight);
		dialogWidth		= (document.documentElement.clientWidth);			
		if(dialogWidth==0){				
			dialogHeight		= (parseInt(document.body.clientHeight));
			dialogWidth		= (parseInt(document.body.clientWidth));				
		}			 
	}
*/	
	dialogTop			= "0px"; 
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight+ "; dialogWidth:" + dialogWidth  + "; status: " + status + "; dialogTop :" + dialogTop+";resizable=yes;maximize:yes;minimize:no;";
	var arguments		= "";
	retVal 				= await top.window.showModalDialog("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_date="+admin_date+"&patient_class="+patient_class+"&called_from=MEDADMIN",arguments,features);// Added for PMG2014-CRF-0026 [IN:052701]
}

// Added by Sridhar Reddy On 03/12/2008	
	function callMouseOverOnTD(obj,imgObj){
		
		 if (prevObjID != null && prevObjID != obj.id)
		 {			 
			 document.getElementById(prevObjID).className = 'gridDataBlue';
			 document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
		 }		 
		obj.className = 'selectedTDData';
		document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
		prevObjID = obj.id;
		prevImgObj = imgObj;		
	}

	function callMouseOverOnTD_oth(obj){
		
		 if (prevObjID != null)
		 {			 
			 document.getElementById(prevObjID).className = 'gridDataBlue';
			 document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
		 }		 		
	}
	
	
//function for restricting OT-ordercategory
function setOTvalue(OTinstall_yn)
{	
	parent.TaskListRightFilterFrame.document.TaskListFilterForm.isOTInstalled_yn.value=OTinstall_yn;
	if (parent.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value == "OT" && parent.TaskListRightFilterFrame.document.TaskListFilterForm.isOTInstalled_yn.value == "Y") 
	{
		alert(getMessage('OT_MODULE_INSTALLED','OR'));
		parent.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value = "";
		parent.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.value = "";
	}
}

function setRDvalue(RDinstall_yn)
{	
	parent.TaskListRightFilterFrame.document.TaskListFilterForm.isRDInstalled_yn.value=RDinstall_yn;
	if (parent.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value == "RD" && parent.TaskListRightFilterFrame.document.TaskListFilterForm.isRDInstalled_yn.value == "Y") 
	{
		alert(getMessage('RADIOLOGY_MODULE_INSTALLED','OR'));
		parent.TaskListRightFilterFrame.document.TaskListFilterForm.OrderCategory.value = "";
		parent.TaskListRightFilterFrame.document.TaskListFilterForm.OrderType.value = "";
	}
}
	
// end
//Added by Archana Dhal related to IN022960 start.
function validateBT(strstat,msgtxt)
{
	if(strstat=='Y'|| strstat=='y'||strstat=='0' )	
	{	
	   alert(msgtxt);
	   return false;
	}
	else if(strstat=='X'||strstat=='x')
	{
	  var dt=window.confirm(msgtxt);
	  return dt;		
	}
	else
	return true;

}//end


function validatePatId(obj)
{					   
	var string = obj.value
	var iChars = "*|,\":<>[]{}`\'; ()@&$#%";
	
	for (var i = 0; i < string.length; i++) 
	{
		if (iChars.indexOf(string.charAt(i)) != -1)	// || string.charAt(i) == " "
		{
			alert (getMessage('INVALID_VALUE','COMMON').replace('#','PATIENT ID')); 
			//obj.select();
			obj.value="";
			obj.focus();
			return;
		}
	}
	populatePatientDetails(obj,"");
}


function populatePatientDetails(getpatientId,target)
{
		var frmObj		= document.TaskPatientSearchForm;
		var localeName  = document.TaskPatientSearchForm.localeName.value;

		if( getpatientId.value != "" ) 
		{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr += "patientId=\""+ getpatientId.value +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eOR/jsp/RefusalOrdersValidate.jsp?"+"&default_val=''&validate=pat_details_tasklist&localeName="+localeName, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}		
}

function callClear1()
{
 
	message = getMessage('INVALID_PATIENT','OR');
	alert(message);
}
//IN034973
async function viewPatientInstructions(patientId,encounterId,facilityId,interventionId,consentFormId){
	var dialogHeight	= "90vh";
	var dialogWidth	= "80vw"; 
	var dialogTop		= "60";
	var dialogLeft		= "250";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	await window.showModalDialog("../../eOR/jsp/PatientInterventionsFrameSet.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&facility_id="+facilityId+"&intervention_id="+interventionId+"&consentform_id="+consentFormId,arguments,features);
}
//IN034973

//IN065942, starts
function prnRegLabel()
{
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
	var bean_id = "Or_RegisterOrder";
	
    var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var params = "validate=PRINT_REG_ORDER_LABEL&flag=true&bean_id="+bean_id;
    xmlHttp.open("POST", "../../eOR/jsp/RegisterOrderValidate.jsp?"+params, true);
    xmlHttp.send(xmlDoc);
}
//IN065942, ends
// IN071618 Starts
function checkBillSettlementforCatalog(order_id,order_type_code,patient_class,patient_id,encounter_id,cnt,ordering_facility)
{
	 cnt =0;
	var bean_id		= document.TaskListFilterResultForm.bean_id.value;
	var bean_name	= document.TaskListFilterResultForm.bean_name.value;
	var localeName = document.TaskListFilterResultForm.localeName.value ;
	var xmlHttp 	=  new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
    xmlStr += "ordering_facility=\""+ ordering_facility +"\" " ;
    xmlStr += "order_id=\""+ order_id +"\" " ;
    xmlStr += "order_type_code=\""+ order_type_code +"\" " ;
    xmlStr += "patient_class=\""+ patient_class +"\" " ;
    xmlStr += "patient_id=\""+ patient_id +"\" " ;
    xmlStr += "encounter_id=\""+ encounter_id +"\" " ;
    xmlStr += "rec_num=\""+ cnt +"\" " ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "../../eOR/jsp/RegisterOrderValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&localeName="+localeName+"&validate=CHECK_BILLSETTLEMENT&flag=true", false ) ;
	xmlHttp.send( xmlDoc ) ;
	// IN071618 Starts
	if(""==trimString(xmlHttp.responseText))
	{
		return false;
	}
	else{
		eval(xmlHttp.responseText);
	}
	// IN071618 Ends

}
// IN071618 Starts
function amendUnbillLineRecord()
{
	eval(formApply( document.bill_unsettled_order,OR_CONTROLLER)) ;
	document.bill_unsettled_order.rec_res.value = true;
    window.close();
}
// IN071618 Ends
async function settlementPendingMsg(message,details,patient_id,encounter_id,facility_id,cnt)
{
	var dialogHeight ='90vh' ;
	var dialogWidth = '80vw' ;
	var dialogTop	= '250';
	var dialogLeft = '30' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

	var arguments = "";
	var finalString = "message="+escape(message)+"&details="+escape(details)+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&rec_num="+cnt;
	var retVal = await window.showModalDialog("../../eOR/jsp/RegisterOrderBillDetails.jsp?"+finalString,arguments,features);
	
}
// IN071618 Ends
//Adding start for IN017999
function populateEncounters(patient_id,encounter_id){
	var formObj = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document;
	var validate = "";
	var bean_id = formObj.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	validate = "encounter_list";
	 xmlStr +=" /></root>" ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='';
	xmlHttp.open( "POST", "TaskListValidate.jsp?bean_id=" + bean_id + "&validate="+validate+"&flag="+flag+"&patient_id="+patient_id+"&encounter_id="+encounter_id, false ) ;
	xmlHttp.send(xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}
function addEncounterList(encounter_id,sel_encounter_id) {	
	var element = document.createElement('OPTION') ;
var temp_encounter_id = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("en_id").value;

	element.value =  encounter_id ;
	element.text = encounter_id ;
	if (sel_encounter_id == element.value)
	{
		element.selected = "selected";
	}
	
	parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById("en_id").add(element);
}
function clearEncounterList(docObj)
{
	var len = parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById('en_id').options.length;
	for(var i=0;i<len;i++)
	{
		parent.parent.TaskListRightFrame.TaskListRightFilterFrame.document.getElementById('en_id').remove("atc_class_l2_code");
	}
}

function setChangeFlag(){
	 document.TaskListFilterForm.enc_change_flag.value ="Y";
}
//Adding end for IN017999

