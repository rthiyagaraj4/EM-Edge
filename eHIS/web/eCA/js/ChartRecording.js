 //used for storing the dates - a global array object
 /* 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name           Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------
?             100            ?              created
06/07/2011    101            Dinesh T       Incident No: 27046, Remarks in the Charting 
13/07/2011    102            Chowminya G    Incident No:IN027022 - <MC module Charting -															amend(replace) display issue> 
18/10/2011    IN029309 		 Chowminya G    Incident No: IN029309, Remarks in the Charting before recording
14/11/2011	  IN29392		 Menaka V		Incident No:IN29392 - <Clinical Event History>View Graph?
											Select event result and then click View graph
											(Selected event result name contains a special character (?%?) )
											System Display error message in General graph box. >
11/02/2013    IN033465      Chowminya G     Chart Recorded As? In Error? Remarks Not Displayed For Viewing In View 		
21/02/2013    IN037946      Chowminya G     Remarks -?while marking all the event as error for the ?Formula Component?	
23/05/2013    IN040163		Ramesh G 		ML-BRU-SCF-0856	
08/10/2013	  IN043178		Vijayakumar K	Alpha-CIS->CA->View Chart Summary>Record Charts>Displays a message "APP CA 0224 ? Transaction could not be complete" when entering 'text' data into a field	
26/11/2013    IN045223		Chowminya 		Score value 0 in formula component not displayed	
30/12/2013	  IN045223.1	Chowminya		[Reopen]Score value 0 in formula component not displayed	
14/03/2014	  IN047648		Vijayakumar K	14/03/2014	Chowminya G 	Record Charts 'Enter/Edit Remark webpage dialog'
28/03/2014	  IN047838		Chowminya		AAKH-CRF-0010.1/01 - Chart cannot be recorded	
02/04/2014	  ICN_ADHOC_022 Chowminya		AE Module-Chart Recording>Click Clear button, then click Search button - Script error	
--------------------------------------------------------------------------------------------------------
Date       	Edit History      Name           Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------

21/04/2014	IN047648		Vijayakumar K		14/04/2014		Chowminya G		Reopen - Result Reporting > Result Entry 'Comments-webpage
																				dialog', 'OK' button disappear from the screen.	
07/11/2014	IN052210		Ramesh G			07/11/2014		Akbar S			System display inconsistency while viewing a graph from Charting and Clinical Event History 
																				Refer to attached screen shots.																
24/08/2015	IN057123		Karthi												In Thai screen Date 29/02/2559 when we open Chart screen, the system displays Script Error Message.
04/05/2017	IN064119		Raja S				04/05/2017		Ramesh G		GHL-SCF-1195
23/11/2017	IN061897		Raja S				23/11/2017		Ramesh G		ML-MMOH-CRF-0549
21/09/2018	IN067534		sivabagyam M       	21/09/2018		Ramesh G		ML-MMOH-CRF-1107
29/10/2018	IN068742		Sharanraj							Ramesh G		TBMC-SCF-0006
10/08/2020	IN071339    	SIVABAGYAM M      	10/08/2020		RAMESH G      	OR-COMMON RECORD CHART
--------------------------------------------------------------------------------------------------------
*/
var tempDatesArray = new Array();
var datesArrayForPrevNext = new Array();
var dtArr = new Array();
function getMessageFrame()
{
	if(top.content!=null)
		return top.content.messageFrame;
	else
		return top.messageframe;	
}
var messageFrameReference = getMessageFrame();
function defaultValue()
{
	
/*	if(document.forms[0].detailDate.value=="")
	{
		document.forms[0].detailDate.value
	}*/
}
function ValidateDateTimeOfPeriod(fromDate,toDate)
{

	var locale = document.forms[0].locale.value;	
	var from_date = fromDate.value;	
	var to_date = toDate.value;	

	if(CheckDateTime(fromDate) && CheckDateTime(toDate))
	{
		if(to_date !="" || from_date != "")	
		{
			if(isAfter(to_date,from_date, "DMYHM", locale))
				return true;
			else
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
				toDate.select();
				toDate.focus();
				return false;
			}
		}
	}
	else if(to_date !="")
	{
		CheckDateTime(toDate);
	}
}

/*function ValidateDateTimeOfPeriod(Objfrom,objTo)
{
	if(objTo.value !="" && Objfrom.value != "")
	{
		if(!ValidateDateTime(Objfrom,objTo))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"))
			objTo.select();
			return false
		}
	}
} */
/*function CheckDateTime(objText,format)
{
	var locale = document.forms[0].locale.value;

	if(objText.value !='')
	{
		 if (!validDate(objText.value, format, locale))
		 {
			 alert(getMessage("INVALID_DATE_FMT","CA"))
			 objText.select();
			 return false
		 }
		 else
			return true;
	}
}*/


function CheckDateTime(objText,admDtChk)
{
	var locale		= document.forms[0].locale.value;
	if(objText.value !='')
	{
		// commented for SRR20056-SCF-9434- IN057123 [IN037552] - Start
		/*if(isBeforeNow(objText.value,"DMYHM",locale))
		{
			if(doDateTimeChk(objText.value)==false)	
			{
				alert(getMessage("INVALID_DATE_TIME","CA"));
				objText.select();						
				objText.focus();						
				return false;
			}
		}*/
		// commented for SRR20056-SCF-9434- IN057123 [IN037552] - End
		if(!validDateObj(objText,"DMYHM",locale))
		{
			//alert(getMessage("INVALID_DATE_FMT","CA"))
			//objText.focus();
			return false
		}
		if(!(isBeforeNow(objText.value,"DMYHM",locale) ))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
			objText.select();
			objText.focus();
			return false;
		}
		if(admDtChk == 'Y')
		{
			var adm_date = document.forms[0].adm_date.value;
			if(!(isBefore(adm_date, objText.value, "DMYHM", locale)))
			{
				alert(getMessage("CANNOT_BE_GREATER_THAN_ADM_DATE","CA")); 
				//objText.select();
				objText.value="";
				objText.focus();
				return false;
			}
		}
		else
			return true;
	}
} 

function showButton(){

	//if(parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.summaryText !=null)	
	//{
		//parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonLast.style.visibility='visible'
		//parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.buttonFirst.style.visibility='visible'
	//}
}

function resetCriteria()
{
	parent.ChartRecordingCriteriaFrame.location.reload()
	parent.ChartRecordingControlsFrame.location.reload()
	var function_from = document.ChartLayoutCriteriaForm.function_from.value;
	if(function_from != 'CP')
	{
		if((document.ChartLayoutCriteriaForm.modifyYN.value) == 'Y')
		{
			document.ChartLayoutCriteriaForm.buttonAddItem.style.visibility='hidden'
		}
	}
	
	if(function_from == 'CP')
	{
		//var qs = parent.ChartRecordingCriteriaFrame.location;
		//parent.ChartRecordingCriteriaFrame.location = qs;
		parent.ChartRecordingCriteriaFrame.document.forms[0].reset();
	}
	if(function_from != 'CP')
	{
		//ICN_ADHOC_022 added if condition for clear for AE CRF
		if(function_from == 'AE')
		{
			parent.ChartRecordingCriteriaFrame.document.forms[0].reset();
			parent.ChartRecordingControlsFrame.location.href = "../../eCA/jsp/blank.jsp";
			parent.ChartRecordingDetailFrame.location.href = "../../eCA/jsp/blank.jsp";	
			parent.ChartRecordingListFrame.location.href = "../../eCA/jsp/blank.jsp";	
			parent.ChartRecordingToolBarFrame.location.href = "../../eCA/jsp/blank.jsp";
			parent.ChartRecordingColorFrame.location.href = "../../eCA/jsp/blank.jsp";
		}
		else
		{
			parent.ChartRecordingDetailFrame.location.href = "../../eCommon/html/blank.html";
			parent.ChartRecordingListFrame.location.href = "../../eCommon/html/blank.html";
			parent.ChartRecordingToolBarFrame.location.href = "../../eCommon/html/blank.html";
		}
	}
}
function resizeFrame(objButton)
{
	if(objButton.name=="buttonCriteriaMore")
	{
		if(document.ChartLayoutCriteriaForm.buttonCriteriaMore.value != 'Less Criteria <<')
		{
			document.getElementById("trRowId1").style.display='inline'
			document.getElementById("trRowId1").border='0'
			document.getElementById("trRowId1").bgColor='red'
			document.ChartLayoutCriteriaForm.buttonCriteriaMore.value='Less Criteria <<'
			parent.document.getElementById("chartRecordingFrameSet").rows='44%,75%,8%,6%,0%'
		}
		else
		{
			document.getElementById("trRowId1").style.display='none'
			document.ChartLayoutCriteriaForm.buttonCriteriaMore.value='More Criteria >>'
			parent.document.getElementById("chartRecordingFrameSet").rows='23%,75%,8%,6%,0%'
		}
	}
}

function evalCheckBox(objCheck,objHidden,e)
{
	if(objCheck.checked==true)
		objHidden.value='Y';
	   	else
		objHidden.value=''
}	
/*function allowValidNumberLocal4(fld,e){
	//var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	//var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return false; 
	 else return true;
}*/
function getValueForComp(objHidden,objText)
{
	if(objText != null)
	{
		objHidden.value = objText.value
	}
}
function Continue()
{
  var index = parent.chartRecordingListBottomFrame.document.chartRecordingCriteriaForm.index.value;
  var flag =  parent.chartRecordingListBottomFrame.document.chartRecordingCriteriaForm.flagMsg;
  flag.value = 'continue';
  var indexFlag =0;
   for(var indexCheck = 0 ;indexCheck < parseInt(index,10) ; indexCheck++)
	{
		   var objCheck = eval(" parent.chartRecordingListBottomFrame.document.chartRecordingCriteriaForm.defaultYNCheck"+indexCheck);
	   var objHidden = eval(" parent.chartRecordingListBottomFrame.document.chartRecordingCriteriaForm.defaultYN"+indexCheck);
			if(objCheck.checked == true)
			{
				objHidden.value='Y'
			}
			else
			{
				objHidden.value='N';
				indexFlag++;
			}

	}
	if(indexFlag !=index)
	{
		parent.chartRecordingListBottomFrame.document.chartRecordingCriteriaForm.submit();
	}
	else
	{
		alert(getMessage("CHOOSE_AT_LEAST_ONE_ITEM","CA"))
	}
	
}
async function defineItems()
{
	var encounterId = document.forms[0].encounterId.value
	var chartId =document.forms[0].chartId.value;

	var dialogTop		=	"0vh" ;
	var dialogHeight= "30vh" ;
    var dialogWidth = "40vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/ChartRecordingFrameSet.jsp?chartId='+chartId+'&encounterId='+encounterId;
	var retVal=await top.window.showModalDialog(action_url,arguments,features);		
	parent.window.returnValue=retVal	
	parent.window.close();		
}
function cancel()
{
		alert( getMessage("CANCEL_CHARTING_TRANSACTION","CA"));
		window.returnValue='cancel'
		window.close();
}
function apply()
{
  var index = parent.chartRecordingTopFrame.document.chartRecordingCriteriaForm.index.value;
   var indexFlag =0;
   for(var indexCheck = 0 ;indexCheck < parseInt(index,10) ; indexCheck++)
	{
		   var objCheck = eval(" parent.chartRecordingTopFrame.document.chartRecordingCriteriaForm.defaultYNCheck"+indexCheck);
	   var objHidden = eval(" parent.chartRecordingTopFrame.document.chartRecordingCriteriaForm.defaultYN"+indexCheck);
			if(objCheck.checked == true)
			{
				objHidden.value='Y'
			}
			else
			{
				objHidden.value='N'
					indexFlag++;
			}

	}
	if(indexFlag !=index)
	{
	 parent.chartRecordingTopFrame.document.chartRecordingCriteriaForm.submit();
	}
	else
	{
		alert(getMessage("CHOOSE_AT_LEAST_ONE_ITEM","CA"))
			return false
	}

}
function resetFormObjects()
{
	parent.frames[0].document.forms[0].reset();
}
async function loadPanels()
{
	var encounterId = document.forms[0].encounter_id.value
	var chartId =document.forms[0].chart_id.value;
	var qs = document.forms[0].qs.value;
	var fromDate = document.forms[0].fromDate.value;
	var toDate = document.forms[0].toDate.value;
	var detailDate = document.forms[0].detailDate.value
	var detailYN = document.forms[0].detailYN;
	var summaryYN = document.forms[0].summaryYN;
	var errorAuth = document.forms[0].errorAuth.value;

	if(summaryYN.checked == true)
		qs +="&summaryYN=Y"; 
	else
		qs +="&summaryYN=N"; 

if(detailYN.checked == true)
	qs +="&detailYN=Y"; 

	else
	qs +="&detailYN=N"; 


	if(fromDate!="")
		qs +="&fromDate="+fromDate; 
	if(toDate!="")
		qs +="&toDate="+toDate; 
	if(detailDate!="")
		{
				qs +="&detailDate="+detailDate
				if(document.forms[0].detailSelect!=null)
					qs+="&noOfDays="+document.forms[0].detailSelect.value; 
		}
		/*if(document.ChartLayoutCriteriaForm.summaryText != null)
		{
				qs +="&summaryText="+document.ChartLayoutCriteriaForm.summaryText.value;
		}*/
	
	var dialogTop		=	"80" ;	
	var dialogHeight= "81vh" ;
    var dialogWidth = "40vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/ChartRecordingFrameSet.jsp?chartId='+chartId+'&encounterId='+encounterId;
var retval =await  window.showModalDialog(action_url,arguments,features);
if(retval != null || retval != 'undefined')
{
	parent.ChartRecordingDetailFrame.location.href="../jsp/ChartRecordingDetail.jsp?chartId="+chartId+"&"+qs+"&errorAuth="+errorAuth;
	parent.ChartRecordingToolBarFrame.location.href = "../jsp/ChartRecordingToolBar.jsp?chartId="+chartId+"&errorAuth="+errorAuth+'&'+qs;
}

}
function passValue(tempString)
{

/*	var retVal			=	"";
	var dialogTop		=	"120" ;
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc='+escape(tempString)+'&calledFrom=charting'
	window.showModalDialog(action_url,arguments,features);*/
}
function resetValuesForCriteria(objText,past_scope)
{
	document.forms[0].start.value='0'
	document.forms[0].end.value='0'
	document.forms[0].maxRecord.value=''
	/*document.forms[0].buttonNext.disabled=true
	document.forms[0].buttonPrev.disabled=true
	document.forms[0].buttonLast.disabled = false
	document.forms[0].buttonFirst.disabled = false*/
	var objCheckSummary=document.forms[0].summaryYN;
	var objCheckDetail=document.forms[0].detailYN;
	if(objCheckSummary.checked==true && objCheckDetail.checked==true)
	{
		if(objText.value=="")
		{
			objText.value='1'
		}
		else if(parseInt(objText.value,10) > parseInt(past_scope.value,10))
		{
			alert(getMessage("SCOPE_GREATER_THAN_LIMIT","CA"))
			objText.value=past_scope.value;

		}


	}
	if(objCheckSummary.checked==false && objCheckDetail.checked==true)
	{
		if(objText.value=="")
		{
			objText.value=past_scope.value;
		}
		else if(parseInt(objText.value,10) > parseInt(past_scope.value,10))
		{
			objText.value=past_scope.value;
		}

	}
}
function filterToSummary()
{
	var objCheckSummary=document.forms[0].summaryYN;
	var objCheckDetail=document.forms[0].detailYN;
	var chartId = document.forms[0].chart_id.value;
	//var scope = document.forms[0].past_scope.value;
	//document.forms[0].buttonLast.disabled = true
	//document.forms[0].buttonLast.title = ''
	//document.forms[0].buttonPrev.disabled = true
	//document.forms[0].buttonPrev.title = ''
	//document.forms[0].buttonFirst.disabled = true
	//document.forms[0].buttonFirst.title = ''
	//document.forms[0].buttonNext.disabled = true
	//document.forms[0].buttonNext.title = ''
	document.forms[0].detailDate.value = 	document.forms[0].sysdate.value
	if(chartId !='')
	{
		if(objCheckDetail.checked==false && objCheckSummary.checked==true )
		{
			//document.forms[0].summaryText.value =scope;
			//document.getElementById("imgDate").style.display='none'
			//document.getElementById("dayView").style.display='none'

		}
		if(objCheckDetail.checked==true && objCheckSummary.checked==true )
		{
			//document.forms[0].summaryText.value ='1'
			//document.getElementById("imgDate").style.display='inline'
			//document.getElementById("dayView").style.display='inline'

		}
		if(objCheckDetail.checked==false && objCheckSummary.checked==false)
		{
			//document.getElementById("imgDate").style.display='none'
			//document.getElementById("dayView").style.display='none'
		}
		if(objCheckDetail.checked==false)
		{
			//document.getElementById("imgDate").style.display='none'
			//document.getElementById("dayView").style.display='none'
		}


	}
	else
	{
		return false
	}

/*	var htmlVal="";
	var objCheckSummary=document.forms[0].summaryYN;
	var objCheckDetail=document.forms[0].detailYN;
	var chartId = document.forms[0].chart_id.value;
  	var detailDate= document.forms[0].detailDate.value;
	if(chartId !='')
{
	if(objCheckDetail.checked==true &&objCheckSummary.checked== false)
	{
		document.getElementById("tdId").innerHTML="&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	Date From&nbsp;<a href='javascript:' OnClick='getDay()' title='Click here for other Day Record'>"+detailDate+"</a>&nbsp;&nbsp;for&nbsp;<Select name='detailSelect' id='detailSelect' OnChange='document.forms[0].detailSelectHidden.value=this.value'><option value='1'>1&nbsp;&nbsp;</option> <option value='2'>2&nbsp;&nbsp;</option><option value='3'>3&nbsp;&nbsp;</option></Select>&nbsp;Days"
		for(var index = 0 ;index < document.ChartLayoutCriteriaForm.detailSelect.options.length;index++)
		{
			if(document.ChartLayoutCriteriaForm.detailSelect.options[index].value==document.ChartLayoutCriteriaForm.detailSelectHidden.value)
			{
				document.ChartLayoutCriteriaForm.detailSelect.options[index].selected= true
			}
		}
		document.ChartLayoutCriteriaForm.buttonLast.style.visibility='hidden'
		document.ChartLayoutCriteriaForm.buttonFirst.style.visibility='hidden'
		document.getElementById("label").style.display = 'none'
	}
	else if(objCheckSummary.checked==true &&objCheckDetail.checked==false)
	{
		document.getElementById("tdId").innerHTML="&nbsp;&nbsp;Display Summary&nbsp;&nbsp;<input type='text' name='summaryText' id='summaryText' size='4' maxlength='2' OnClick='return allowValidNumber(this, event,2,0)' value='3' Onchange='resetValuesForCriteria()' OnBlur='checkSequence(this);getToolTipforSummaryButtons()'>&nbsp;days at a time"
			document.ChartLayoutCriteriaForm.buttonLast.style.visibility='visible'
			document.ChartLayoutCriteriaForm.buttonLast.disabled=false
			document.ChartLayoutCriteriaForm.buttonNext.style.visibility='visible'
			document.ChartLayoutCriteriaForm.buttonPrev.style.visibility='visible'
			document.ChartLayoutCriteriaForm.buttonPrev.disabled = true
			document.ChartLayoutCriteriaForm.buttonNext.disabled = true
			document.getElementById("label").style.display = 'inline'
		document.ChartLayoutCriteriaForm.buttonFirst.style.visibility='visible'
		document.ChartLayoutCriteriaForm.buttonFirst.disabled=false
	var 	qs = document.forms[0].qs.value;
	var fromDate = document.forms[0].fromDate.value;
	var toDate = document.forms[0].toDate.value;
	if(fromDate!="")
			qs +="&fromDate="+fromDate; 
	if(toDate!="")
				qs +="&toDate="+toDate; 
	var defaultYN = parent.ChartRecordingDetailFrame.document.forms[0].DEFINE_MODIFIABLE_AT_TRN_YN.value;

parent.ChartRecordingIntermediateFrame.location.href='../../eCA/jsp/ChartRecordingIntermediateForSummary.jsp?&'+qs+'&chartId='+chartId+'&DEFINE_MODIFIABLE_AT_TRN_YN='+defaultYN+'&summaryText='+document.forms[0].summaryText.value
	}
	else if(objCheckSummary.checked==false &&objCheckDetail.checked==false)
	{
		document.getElementById("tdId").innerHTML='&nbsp;'
		document.ChartLayoutCriteriaForm.buttonLast.style.visibility='hidden'
		document.ChartLayoutCriteriaForm.buttonPrev.style.visibility='hidden'
		document.ChartLayoutCriteriaForm.buttonNext.style.visibility='hidden'
		document.ChartLayoutCriteriaForm.buttonFirst.style.visibility='hidden'
		document.getElementById("label").style.display = 'none'
	}
	else
	{
		document.getElementById("tdId").innerHTML="&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	Date From&nbsp;<a href='javascript:' OnClick='getDay()'  title='Click here for other Day Record'>"+detailDate+"</a>&nbsp;&nbsp;for&nbsp;<Select name='detailSelect' id='detailSelect' OnChange='document.forms[0].detailSelectHidden.value=this.value'><option value='1'>1&nbsp;&nbsp;</option> <option value='2'>2&nbsp;&nbsp;</option><option value='3'>3&nbsp;&nbsp;</option></Select>&nbsp;Days"
		for(var index = 0 ;index < document.ChartLayoutCriteriaForm.detailSelect.options.length;index++)
		{

if(document.ChartLayoutCriteriaForm.detailSelect.options[index].value==document.ChartLayoutCriteriaForm.detailSelectHidden.value)
			{
				document.ChartLayoutCriteriaForm.detailSelect.options[index].selected= true
			}
		}
		document.ChartLayoutCriteriaForm.buttonLast.style.visibility='hidden'
		document.ChartLayoutCriteriaForm.buttonPrev.style.visibility='hidden'
		document.ChartLayoutCriteriaForm.buttonNext.style.visibility='hidden'
		document.ChartLayoutCriteriaForm.buttonFirst.style.visibility='hidden'
		document.getElementById("label").style.display = 'none'
	}
}
else
{
	return false
}*/

}
function CheckForNumsAndColon(event){
    var strCheck = '0123456789:/ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
function ValidateTime(objDate)
{
/*		if(objDate.value!='')
		{
		 if(objDate.value.indexOf(":")!=-1){
			 var arrayTime = objDate.value.split(":");
			 var currDate  = new Date();
			 var minutes = currDate.getMinutes();
			 var hr = currDate.getHours();
			if(objDate.value.length !=5)
			{
				alert(getMessage("INVALID_TIME"));
				objDate.select();
				return false;
			}
			else
			 {
				if(arrayTime[0] > hr)	
				{
					alert(getMessage("INVALID_TIME_HOUR_GR"));
							objDate.select();
							return false;
				}
				else if (arrayTime[0] < hr )
				{
							alert(getMessage("INVALID_TIME_HOUR_LESS"));
							objDate.select();
							return false;

				}
				else 
				{
					if(arrayTime[1] > minutes)
					{
						alert(getMessage("INVALID_TIME_HOUR_GR"));
						objDate.select();
						return false;
					}
				else
				 {
					if(parent.ChartRecordingListFrame.document.forms[0] != null)
					 {	 
						var tableId = parent.ChartRecordingListFrame.document.getElementById("titleTable")
						var sysdate = document.forms[0].detailDate.value
							
						for(var indexN = 0 ;indexN <tableId.rows[0].cells.length;indexN++)
						 {
							if(tableId.rows[0].cells[indexN].innerText == sysdate)
							 {
								if(parseInt(arrayTime[0],10) == parseInt(hr,10))	
								{	 
									
								var idCount = parent.ChartRecordingListFrame.document.ChartLayoutListForm.idCount
								if(idCount != null)
								 {	 
									if(parseInt(idCount.value,10) != 0)
									{
										for(var  indexI = 0;indexI < parseInt(idCount.value,10);indexI++)
										 {
											var sysdate1 = 	sysdate;
											for(var dummyVar = 0 ;dummyVar < sysdate1.length;dummyVar++)
											 {
												sysdate1= sysdate1.replace('/','_');
											 }
											var thRowId = eval("parent.ChartRecordingListFrame.document.getElementById("thId")"+sysdate1+indexI);
											if(thRowId != undefined)
											 {
											var tempString =  thRowId.innerText
											var arrayThTime =tempString.split(":");

											if(thRowId.id.indexOf(sysdate1) !=-1)
											 {
												
												if(parseInt(arrayTime[1],10) <= parseInt(arrayThTime[1],10))
												{
												
													alert(getMessage("INPUT_GREATER_THAN_TABLE_TIME"));
													objDate.select();
													return false
												}
											 }
										}
		 							 }
					
								  }
								}
							}
							 }
						 }
					
					 
					 }
			   }

			}

		}
	 }
	 else
	{
				alert(getMessage("INVALID_TIME"));
					objDate.select();
			return false;

	}
	}
*/
}

function checkForNaN(objText,formula,objHidden)
{
	var flag
	var objTextValue  = "";
	/*IN068742 Starts*/
	var numdec=parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.numdecimal.value;
	numdec=parseInt(numdec);
	/*IN068742 Ends*/
	if(formula != 'X')	
	{
		var number = parseFloat(eval(formula))
		flag = 	isFinite(number)
		var index = 0;
		if(flag == true)
		{
			number = number * 1000
			//number = Math.round(number);//IN068742
			number = number /1000;
			number=number.toFixed(numdec);//IN068742
			//IN040163 - added if n else condition
			if(number!=0)
			{
				objText.value = number
				objHidden.value = number
			}
			else if(number==0){
					objText.value= "";
					objHidden.value = "";
				}
		}
		else
		{
			objText.value = ""
			objHidden.value = ""
		}
	}
}
function recording()
{	
	if(parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm == null)
	{
		var proceed = "T";
		var cntValues = 0;
		if(parent.ChartRecordingCriteriaFrame != null && parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.rec_time.value=="")
		{
			alert(getMessage("RECORD_TIME_NOT_BLANK","CA"));
		}
		else
		{
			var count = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.count.value;

			var objRef = "parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm";
			var flag1 = 0;//IN045223
			
			/*IN068742 Starts*/
			var numdec=parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.numdecimal.value;
			numdec=parseInt(numdec);
			/*IN068742 Ends*/
			for(var n=0;n<count;n++)
			{
				var mandatoryyn = eval(objRef+".mandatory_yn_"+n+".value");
				var objHidden =  eval(objRef+".comp_"+n);
				var associateScoreYN =  eval(objRef+".associate_score_yn"+n+".value");
				var objHiddenName = eval(objRef+".discr_msr_id_grp_id"+n);

				var objType = eval(objRef+".dis_msr_type_"+n+".value");
				var compFormula = eval(objRef+".comp_formula"+n);
				var objRefText = objRef+"."+objHiddenName.value
				var listItemValue = "";
				var objText = eval(objRefText);
				//IN045223 - Start
				var data_sel = eval(objRef+".comp_"+n+".value");
				if (data_sel != "" && associateScoreYN != 'N') //IN045223.1 Added && condition
				{
					flag1++;
				}	
				//IN045223 - End
				if(compFormula != undefined)
				{
					var flag
					var formula = eval(compFormula.value)
					var number = parseFloat(formula);
					flag = 	isFinite(number)
					var index = 0;
					if(flag == true)
					{
						number = number * 1000
						//number = Math.round(number);//IN068742
						number = number /1000;
						number=number.toFixed(numdec);//IN068742
						//IN040163 - added if n else condition
						if(number!=0)
						{
							objText.value= number
							objHidden.value = number
						}
						else if(number==0){
							//IN045223 - Modified Start
							if(flag1 > 0)
							{
								objText.value= number;
								objHidden.value = number;
							}
							else
							{	
								objText.value= "";
								objHidden.value = "";
							}
							//IN045223 - Modified End
						}
					}
					else
					{
						objHidden.value = ""
					}
					
				}
				
				if(objType == "N" || objType == "I")
				{
					var hidval = objHidden.value;
					if(hidval.indexOf("+") == 0)
					{
						var hidval1 = eval("parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.result_prefix"+n);
						hidval1.value = "+";
					}
				}

				var grpDiscrMsrID = eval(objRef+".discr_msr_id_grp_id"+n+".value");
				var textObj = "";
				var usrselection=""; //IN064119
				if(objType == "L")
				{
					textObj = eval(objRef+"."+"list_"+n);
					usrselection=textObj.selectedIndex //IN064119
				}
				else
				{
					textObj = eval(objRef+"."+grpDiscrMsrID);
				}
				
				
				if(eval(objRef+".dis_msr_type_"+n+".value")!='LS' && eval(objRef+".dis_msr_type_"+n+".value")!='LN' && eval(objRef+".dis_msr_type_"+n+".value")!='LF')
				{
					var strval = eval(objRef+".comp_"+n+".value");
					var strobj = eval(objRef+".comp_"+n);
					var desc = eval(objRef+".event_grp_desc_"+n+".value");
					
				//alert('mandatoryyn ->'+mandatoryyn+'strval ->'+strval+'strobj ->'+strobj+'desc ->'+desc);
					//if(mandatoryyn == 'Y' && strval == '') //IN064119 Commented
					if(mandatoryyn == 'Y' && strval == '' && objType != "L" ) //IN064119 Added Condition
					{
						var message=getMessage("SHOULD_NOT_BE_BLANK","Common");
						 message=message.replace('{1}',desc);

						alert(message);						
						strobj.select();
						if(objType != "C")
						{
							//textObj.select();
							textObj.focus();
						}
						proceed = "F";
						break;
					}
					//IN064119 changes starts
					if(mandatoryyn == 'Y' && objType == "L" && usrselection ==0)
					{
						var message=getMessage("SHOULD_NOT_BE_BLANK","Common");
						 message=message.replace('{1}',desc);

						alert(message);						
						strobj.select();
						if(objType != "C")
						{
							//textObj.select();
							textObj.focus();
						}
						proceed = "F";
						break;
					}
					//IN064119 changes ends
					if(mandatoryyn != 'Y' && strval == '')
					{
						//cntValues++;
						if(objType == "L")
						{
							listItemValue = eval(objRef+".listItemValue"+n+".value");
							if(listItemValue == "------Select------" || listItemValue == "")
							{
								cntValues++;
							}
						}
						else
						{
							cntValues++;
						}
					}
				}				
			}
			
			//alert("count ="+count+"= cntValues ="+cntValues);

			if(cntValues == count)
			{
				var tempOneVal = "";
				var tempOneVal1 = "";
				alert(getMessage("ATLEAST_ONE_VAL","CA"));
				if(parent.ChartRecordingDetailFrame != null)
				{
					objType = eval(objRef+".dis_msr_type_0.value");
					if(objType == 'L')
					{
						tempOneVal1 = eval(objRef+"."+"list_0");
					}
					else
					{
						tempOneVal = eval(objRef+".discr_msr_id_grp_id0.value");
						tempOneVal1 = eval(objRef+"."+tempOneVal);
					}
					tempOneVal1.focus();
				}
				return false;
				proceed = "F";
			}

			if(proceed == "T"){
				if(parent.ChartRecordingCriteriaFrame != null)
				{
					parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.rec_time.value = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.rec_time.value;

					//alert(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.rec_time.value);
				}
				else
				{
					parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.rec_time.value = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.detDate.value
				}
				if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.formula_btn!=null)
					parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.formula_btn.click();

				if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.sum_button!=null)
					parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.sum_button.click();
					document.F.record.disabled=true	
					var function_from = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.function_from.value;
					if(function_from=='CP')
					{
						parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.target='ChartRecordingIntermediateFrame'
					}
				parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.submit();
			}
		}
	}//end of if
	else
	{
		var cnt = parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.numOfRecs.value;

		parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.encounter_id.value = parent.ChartRecordingToolBarFrame.document.F.encounter_id.value;

		//alert("enc_id = "+parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.encounter_id.value+"=");

		parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.patient_class.value = parent.ChartRecordingToolBarFrame.document.F.patient_class.value;
		parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.patient_id.value = parent.ChartRecordingToolBarFrame.document.F.patient_id.value;

		var accessionNum = "";
		var obj = "";
		var objectName = "";
		var hiddenObj = "";
		var hiddenRemarksObj = "";
		var temp = "";
		var temp2 = "";
		var temp3 = "";
		var selObj = "";
		var listStringValue  = "";
		var discrMsrType  = "";
		var tempTemp = "";
		var tempCount = 0;

		for(var i=0;i<parseInt(cnt,10);i++)
		{
			hiddenObj = eval(parent.ChartRecordingDetailFrame.document.getElementById("hidErrYN"+i));
			//hiddenObject = eval("document.chartRecordingAmendErrorForm.errorYN"+i);
			selObj = eval(parent.ChartRecordingDetailFrame.document.getElementById("selectObject"+i));

			if(selObj.value == '')
			{
				tempCount++;
			}

			if(selObj.disabled == true)
			{
				selObj.disabled = false;
				hiddenObj.value = selObj.value;
			}
			discrMsrType = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.discrTypeHidden"+i);//IN037946
			//hiddenObj = eval("parent.ChartRecordingDetailFrame.document.getElementById("accessNumHidden")"+i);
			if(hiddenObj.value == "R")
			{
				//discrMsrType = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.discrTypeHidden"+i);//IN037946 - Commentted
				obj = eval(parent.ChartRecordingDetailFrame.document.getElementById("object"+i));
				objectName = eval("parent.ChartRecordingDetailFrame.document.forms[0].objectName"+i);
				if(discrMsrType.value == "C")
				{
					if(obj.checked == true)
					{
						objectName.value = "Y";
					}
					else
					{
						objectName.value = "N";
					}
				}
			}
			
			if(hiddenObj.value == "R" || hiddenObj.value == "E")
			{
				hiddenRemarksObj = eval(parent.ChartRecordingDetailFrame.document.getElementById("errorRem"+i));
		
				//if(discrMsrType.value != "A" && hiddenRemarksObj.value == "")//IN033465 Commentted
				if(discrMsrType.value != "A" && trimCheck(hiddenRemarksObj.value)=="") //IN033465
				{
					alert(getMessage("REMARKS_CANNOT_BLANK","CA"));
					hiddenRemarksObj.value = "";//IN033465
					hiddenRemarksObj.focus();
					if(discrMsrType.value == "A")
					{
						selObj.disabled = true;
					}
					/*else if(hiddenObj.value == "E")
					{
						selObj.disabled = true;
					}*/
					return false;
				}
			}
			if(hiddenObj.value == "R")
			{
				temp = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.object"+i);
				temp2 = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.prevDisplayStringValue"+i);
				temp3 = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i);				
				if(temp != null || temp != undefined)
				{
					if(discrMsrType.value != "L" && temp.value == '')
					{
						alert(getMessage("VAL_NOT_BLANK","CA"));
						temp.focus();
						return false;
					}
					else if(discrMsrType.value != "L" && temp.value == 0)
					{
						//alert(discrMsrType.value);
						alert(getMessage("VAL_NOT_ZERO","CA"));
						temp.focus();
						return false;
					}
					else 
					{
						/*if(discrMsrType.value == "L")
						{
							if(temp.value == temp3.value)
							{
								alert(getCAMessage("VAL_NOT_MODIFIED"));
								temp.focus();
								return false;
							}
						}*/
						//else
						if(discrMsrType.value != "L")
						{
							if(temp.value == temp2.value)
							{
								alert(getMessage("VAL_NOT_MODIFIED","CA"));
								temp.focus();
								return false;
							}
						}
					}
				}
			}

			discrMsrType = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.discrTypeHidden"+i);
			listStringValue = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.listStringValue"+i);
			tempTemp = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.object"+i);
			if(discrMsrType.value == "N" || discrMsrType.value == "I")
			{
				var hidval = tempTemp.value;
				if(hidval.indexOf("+") == 0)
				{
					var hidval1 = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.result_prefix"+i);
					hidval1.value = "+";
				}
			}
			if(discrMsrType.value == "L")
			{
				if(tempTemp.style.display == "inline")
				{
					listStringValue.value = tempTemp.options[temp.options.selectedIndex].text;
				}				
			}
			else
			{
				listStringValue.value = "";
			}
		}
		if(tempCount != cnt)
		{
			
			var function_from = parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.functionFrom.value;

			if(function_from=='CP')
			{
				parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.target='ChartRecordingIntermediateFrame'
			}
			parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.submit();
			parent.ChartRecordingToolBarFrame.document.F.record.disabled = true;
		}
		else
		{
			parent.ChartRecordingToolBarFrame.document.F.record.disabled = false;
			for(var t=0;t<parseInt(cnt,10);t++)
			{
				discrMsrType = eval("parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.discrTypeHidden"+t);
				if(discrMsrType.value == "A")
				{
					selObj = eval(parent.ChartRecordingDetailFrame.document.getElementById("selectObject"+t));
					selObj.disabled = true;
				}
			}
			alert(getMessage("ATLEAST_ONE_VAL","CA"));
			return;
		}
	}//end of else
}
function loadChart(obj,fromservlet)
{	
	var module_id = document.forms[0].module_id.value;
	if(top.content != null)
	{
		if((document.forms[0].modifyYN.value) == 'N')
		{
			top.content.workAreaFrame.chartRecordingFrameSet.rows = "28%,*%,6%,4%,0%,0%";
			top.content.workAreaFrame.colBarID.cols = "40%,*";
			top.content.workAreaFrame.AEID.cols = "40%,*";
		}
		else
		{
			top.content.workAreaFrame.chartRecordingFrameSet.rows = "24%,*%,6%,4.8%,0%,0%";
			if(module_id  == 'MC')
			{
				top.content.workAreaFrame.AEID.cols = "50%,50%";
				top.content.workAreaFrame.colBarID.cols = "50%,50%";
			}
			else
			{
				top.content.workAreaFrame.AEID.cols = "40%,*";
				top.content.workAreaFrame.colBarID.cols = "40%,*";
			}
		}
	}
	else
	{
		if((document.forms[0].modifyYN.value) == 'N')
		{
			
			parent.chartRecordingFrameSet.rows = "37%,*%,6%,4%,0%,0%";
			parent.colBarID.cols = "0%,*%";
			parent.AEID.cols = "40%,*";
		}
		else
		{
			
			parent.chartRecordingFrameSet.rows = "24%,*%,6%,4%,0%,0%";
			if(module_id  == 'MC')
			{
				parent.AEID.cols = "40%,*";
				parent.colBarID.cols = "40%,*";
			}
			else
			{
				parent.AEID.cols = "40%,*";
				parent.colBarID.cols = "40%,*";
			}
		}
	}
	var chartId = document.forms[0].chart_id.value;
	var sort_by = document.forms[0].sort_by_asc_desc.value;
	var errorAuth = document.forms[0].errorAuth.value;
	var fromDate = document.forms[0].fromDate.value;
	var toDate =document.forms[0].toDate.value;
	var fromDateForExt =document.forms[0].fromDateForExt.value;
	var toDateForExt =document.forms[0].toDateForExt.value;
	var qs = document.forms[0].qs.value;
	var encounterId = document.forms[0].encounter_id.value;
	var patient_id = document.forms[0].patient_id.value;
	var function_from = document.forms[0].function_from.value;
	//var scope = document.forms[0].scope.value;
	var sysdate	=  document.forms[0].sysdate.value;	
	var locale		= document.forms[0].locale.value;
	
	document.forms[0].summaryYN.checked = true;
	document.forms[0].detailYN.checked = true;
	document.forms[0].detailYN.value='Y'
	document.forms[0].summaryYN.value='Y'
	if((document.forms[0].modifyYN.value) == 'Y')
	{
		document.forms[0].buttonAddItem.style.visibility = 'hidden';
	}
	var tableId = parent.ChartRecordingCriteriaFrame.document.getElementById("tdIdForClassCriteria");
	//document.getElementById("dayView").style.display='none';
	//document.getElementById("imgDate").style.display='none';	
	//document.getElementById("label").style.display='none';	
	//document.forms[0].buttonLast.style.visibility='hidden'
	//document.forms[0].buttonFirst.style.visibility='hidden'
	//document.forms[0].buttonNext.style.visibility='hidden'
	//document.forms[0].buttonPrev.style.visibility='hidden'
	//document.getElementById("buttonVisible").style.visibility='hidden'
	
	//var daySummary= document.forms[0].summaryText.value
	var daySummary = "1";
	sort_by = "D";
	if(encounterId == "0")
	{
		fromDate = fromDateForExt;
		toDate = toDateForExt;
	}
	else
	{
		fromDate = "";
		toDate = "";
	}

	//document.getElementById("summaryText").value = "1";
	document.getElementById("fromDate").value = fromDate;
	document.getElementById("toDate").value = toDate;
	document.forms[0].sort_by_asc_desc.value = "D";

	
	if(chartId !=""){
	var path1 = "";
	var path2 = "";
	
	if(fromservlet == "fromservlet")
	{
		//Modified IN047838 - Start	
		if(function_from == "AE")
		{
			path1 = "../eCA/jsp/blank.jsp";	
			path2 = "../eCA/jsp/ChartRecordingIntermediate.jsp";	
		}		
		else{	
			path2 = "../eCA/jsp/ChartRecordingIntermediate.jsp";
			path1 = "../eCommon/html/blank.html";	
		}	
		//IN047838 - End
	}
	else if(fromservlet == undefined)
	{
		path1 = "../../eCommon/html/blank.html";
		path2 = "../../eCA/jsp/ChartRecordingIntermediate.jsp";
	}
	parent.ChartRecordingDetailFrame.location.href = path1;
	parent.ChartRecordingListFrame.location.href = path1;
	parent.ChartRecordingToolBarFrame.location.href = path1;
	var HtmlVal = "<html><head></head><form name='tempForm' id='tempForm' method='post' action="+path2+"><input type='hidden' name='chartId' id='chartId' value='"+chartId+"'><input type='hidden' name='qs' id='qs' value='"+qs+"'><input type='hidden' name='fromDate' id='fromDate' value='"+fromDate+"'><input type='hidden' name='fromDateForExt' id='fromDateForExt' value='"+fromDateForExt+"'><input type='hidden' name='toDateForExt' id='toDateForExt' value='"+toDateForExt+"'><input type='hidden' name='toDate' id='toDate' value='"+toDate+"'><input type='hidden' name='encounter_id' id='encounter_id' value='"+encounterId+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='detailYN' id='detailYN' value='"+document.forms[0].detailYN.value+"'><input type='hidden' name='summaryYN' id='summaryYN' value='"+document.forms[0].summaryYN.value+"'><input type='hidden' name='dateDefault' id='dateDefault' value='sysdate'><input type='hidden' name='summaryText' id='summaryText' value='"+daySummary+"'><input type='hidden' name='sort_by' id='sort_by' value='"+sort_by+"'><input type='hidden' name='errorAuth' id='errorAuth' value='"+errorAuth+"'><input type='hidden' name='function_from' id='function_from' value='"+function_from+"'><input type='hidden' name='modifyYN' id='modifyYN' value='"+document.forms[0].modifyYN.value+"'><input type='hidden' name='module_id' id='module_id' value='"+module_id+"'><input type='hidden' name='locale' id='locale' value='"+locale+"'></form></html>";
	
	parent.ChartRecordingIntermediateFrame.document.write(HtmlVal);
	parent.ChartRecordingIntermediateFrame.document.tempForm.submit();
	}
	else
	{
		parent.ChartRecordingDetailFrame.location.href = "../../eCommon/html/blank.html";
		parent.ChartRecordingListFrame.location.href = "../../eCommon/html/blank.html";
		parent.ChartRecordingToolBarFrame.location.href = "../../eCommon/html/blank.html";
		parent.ChartRecordingControlsFrame.location.href = "../../eCommon/html/blank.html";
		parent.ChartRecordingColorFrame.location.href = "../../eCommon/html/blank.html";
	}			
}
function alignUnitsAndData(){
	var totalRows = document.getElementById("titleTable").rows[1].cells.length;
	var flag = false;
	var flag2 = false;
	var counter = eval(totalRows);
	var summaryYN = document.forms[0].summaryYN.value
	var detailYN = document.forms[0].detailYN.value
	if((summaryYN=="" && detailYN =="" )||(summaryYN=="Y" && detailYN =="Y" ))
	{	
	for(var j=0;j< parseInt(counter,10);j++)
	{
		var count = document.getElementById("titleTable").rows.length
		for(var i=2;i<parseInt(count,10);i++)
		{
			do
			{
				if(document.getElementById("titleTable").rows[i].cells[j].className == 'CASUMMARY')
				{
					flag= true;
					break;
				}
				else
				{
					flag=false
				}
				i++;
			}while(i < count)
			if(flag==true)
				{
					i=2;							
					do
					{

					if(document.getElementById("titleTable").rows[i].cells[j].className != 'CAFOURTHLEVELCOLOR')
						{
							document.getElementById("titleTable").rows[i].cells[j].className= 'CASUMMARY'
						}
						i++;
					}while(i < count)
				}
		}
	}
	for(var j=0;j< parseInt(counter,10);j++)
	{
		var count = document.getElementById("titleTable").rows.length
		for(var i=2;i<parseInt(count);i++)
		{
				var classValue = document.getElementById("titleTable").rows[i].cells[j].className
						//	alert(classValue)
						switch(classValue)
						{
							
							case 'CRITICALLOW' :
											break;
							case 'LOW' :
											break;
							case 'HIGH' :
											break;
							case 'ABNORMAL' :
											break;
							case 'CRITICAL' :
											break;
							case 'CRITICALHIGH' :
											break;
							case 'CASUMMARY' :
											break;
							default : 
					/*	if(parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[i].cells[0].className == "CAQRYEVEN")
							{
								document.getElementById("titleTable").rows[i].cells[j].className= "QRYODD"
							}
							else if(parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[i].cells[0].className == "CAQRYODD")
							{
								document.getElementById("titleTable").rows[i].cells[j].className= "QRYEVEN"
							}
							else
							{
								document.getElementById("titleTable").rows[i].cells[j].className= 	parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[i].cells[0].className
							}*/

								break;
						}
		}
	}
}
else 
{
	if(summaryYN =="Y" && detailYN=="N")
	{
		for(var j=0;j< parseInt(counter,10);j++)
		{
			var count = document.getElementById("titleTable").rows.length
			for(var i=2;i<parseInt(count,10);i++)
			{
				do
				{
					if(document.getElementById("titleTable").rows[i].cells[j].className == 'CASUMMARY')
					{
						flag= true;
						break;
					}
					else
					{
						flag=false
					}
					i++;
				}while(i < count)
				if(flag==true)
					{
						i=2;							
						do
						{

						if(document.getElementById("titleTable").rows[i].cells[j].className != 'CAFOURTHLEVELCOLOR')
							{
								document.getElementById("titleTable").rows[i].cells[j].className= 'CASUMMARY'
							}
							i++;
						}while(i < count)
					}
			}
		}
	}
	else if(summaryYN =="N" && detailYN=="Y")
	{
		for(var j=0;j< parseInt(counter,10);j++)
		{
			var count = document.getElementById("titleTable").rows.length
			for(var i=2;i<parseInt(count,10);i++)
			{
					var classValue = document.getElementById("titleTable").rows[i].cells[j].className
							//	alert(classValue)
							switch(classValue)
							{
								
								case 'CRITICALLOW' :
												break;
								case 'LOW' :
												break;
								case 'HIGH' :
												break;
								case 'ABNORMAL' :
												break;
								case 'CRITICAL' :
												break;
								case 'CRITICALHIGH' :
												break;
								case 'CASUMMARY' :
												break;
								default : 
						/*	if(parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[i].cells[0].className == "CAQRYEVEN")
								{
									document.getElementById("titleTable").rows[i].cells[j].className= "QRYODD"
								}
								else if(parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[i].cells[0].className == "CAQRYODD")
								{
									document.getElementById("titleTable").rows[i].cells[j].className= "QRYEVEN"
								}
								else
								{
									document.getElementById("titleTable").rows[i].cells[j].className= 	parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[i].cells[0].className
								}*/

									break;
							}
			}
		}
	}

}

}
function alignUnitsAndDataforDetail()
{  
	var totalRows =  document.getElementById("titleTable").rows.length-1;
	var temp = document.getElementById("titleTable").rows[0].cells.length;
	document.getElementById("titleTable").rows[1].height =	(2*document.getElementById("titleTable").rows[1].offsetHeight); 
	for(var i=0;i<temp;i++) 
	{
		document.getElementById("titleTable").rows[1].cells[i].width=document.getElementById("titleTable").rows[totalRows].cells[i].offsetWidth;				
	}
}
function scrollTitle(){
  var x = document.body.scrollTop;
  if(x == 0){
   document.getElementById("divTitleTable").style.position = 'relative';
   document.getElementById("divTitleTable").style.posTop  = 0;
    document.getElementById("divTitleTable1").style.position = 'relative';
   document.getElementById("divTitleTable1").style.posTop  = 0;
  }else{
	document.getElementById("divTitleTable").style.position = 'relative';
	document.getElementById("divTitleTable").style.posTop  = x-2;
	document.getElementById("divTitleTable1").style.position = 'relative';
	document.getElementById("divTitleTable1").style.posTop  = x-2;

  }

}
function scrollListFrame()
{
	parent.ChartRecordingDetailFrame.document.body.scrollTop=parent.ChartRecordingListFrame.document.body.scrollTop;
	setTimeout("scrollListTitle()",50);
}
function scrollListTitle()
{
	var x = parent.ChartRecordingListFrame.document.body.scrollTop;
	var y = parent.ChartRecordingDetailFrame.document.body.scrollTop;
	if(y == 0)
	{
		parent.ChartRecordingListFrame.document.getElementById("divTitleTable").style.position = 'relative';
		parent.ChartRecordingListFrame.document.getElementById("divTitleTable").style.posTop  = 0;
		parent.ChartRecordingListFrame.document.getElementById("divTitleTable1").style.position = 'relative';
		parent.ChartRecordingListFrame.document.getElementById("divTitleTable1").style.posTop  = 0;
		parent.ChartRecordingDetailFrame.document.getElementById("divTitleTable").style.position = 'relative';
		parent.ChartRecordingDetailFrame.document.getElementById("divTitleTable").style.posTop  = 0;
		parent.ChartRecordingDetailFrame.document.getElementById("divTitleTable1").style.position = 'relative';
		parent.ChartRecordingDetailFrame.document.getElementById("divTitleTable1").style.posTop  = 0;

	}
	else
	{
		parent.ChartRecordingDetailFrame.document.getElementById("divTitleTable").style.position = 'relative';
		parent.ChartRecordingDetailFrame.document.getElementById("divTitleTable").style.posTop  = y-2;
		parent.ChartRecordingDetailFrame.document.getElementById("divTitleTable1").style.position = 'relative';
		parent.ChartRecordingDetailFrame.document.getElementById("divTitleTable1").style.posTop  = y-2;
		parent.ChartRecordingListFrame.document.getElementById("divTitleTable").style.position = 'relative';
		parent.ChartRecordingListFrame.document.getElementById("divTitleTable").style.posTop  = y-2;
		parent.ChartRecordingListFrame.document.getElementById("divTitleTable1").style.position = 'relative';
		parent.ChartRecordingListFrame.document.getElementById("divTitleTable1").style.posTop  = y-2;

	}
}

function validateNumber(obj,lowlevel,highlevel,rownumber,numdigitsdec,critlow,crithigh,mindigits,minValue,maxValue)
{
	var val = obj.value;

	if(isNaN(val))
	{
		obj.value = "";
		return;
	}
	if(val.indexOf(".") != -1)
	{
		var str = val.substring(val.indexOf(".")+1, val.length);
		
		if (parseInt(numdigitsdec) != 0 && (str.length) > parseInt(numdigitsdec) )
		{	
			var msg = getMessage('VARIABLE_DEC_DIGIT','CA');
			msg = msg.replace('@',numdigitsdec);
			alert(msg);
			obj.value = '';
			obj.focus();
			return;
		}
	}
	if(val != null && val != '' && minValue != '' && maxValue != '')
	{
		if(parseFloat(minValue) > val || parseFloat(maxValue) < val)
		{
			var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
			msg =msg.replace('(1)',minValue);
			msg =msg.replace('(2)',maxValue);
			alert(msg);

			obj.select();
			obj.focus();
			return false;
		}

	}
	if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm != null)
	{
		var highStr = document.ChartLayoutDetailForm.highStr.value
		var lowStr = document.ChartLayoutDetailForm.lowStr.value
		var cricHighStr = document.ChartLayoutDetailForm.cricHighStr.value
		var cricLowStr = document.ChartLayoutDetailForm.cricLowStr.value
		var colorIndicator = ""
	}
	else
	{
		var highStr = document.chartRecordingAmendErrorForm.highStr.value
		var lowStr = document.chartRecordingAmendErrorForm.lowStr.value
		var cricHighStr = document.chartRecordingAmendErrorForm.cricHighStr.value
		var cricLowStr = document.chartRecordingAmendErrorForm.cricLowStr.value
		var colorIndicator = ""
	}


	if(val != null && val != '')
	{
		if((lowlevel != '' && parseFloat(lowlevel) != 0) && (highlevel != '' &&  parseFloat(highlevel) != 0)   && (critlow != '' && parseFloat(critlow) != 0) &&  (crithigh != 0 && parseFloat(crithigh) != ''))
		{
			if(parseFloat(val) >= parseFloat(critlow) && parseFloat(val) < parseFloat(lowlevel))
				colorIndicator = lowStr;
			else if(parseFloat(val) > parseFloat(crithigh))
				colorIndicator = cricHighStr;
			else if(parseFloat(val) < parseFloat(critlow))
				colorIndicator = cricLowStr;
			else if(parseFloat(val) > parseFloat(highlevel) && parseFloat(val) <= parseFloat(crithigh))
				colorIndicator = highStr;
		}// end of if
		else
		{
			if((lowlevel != '' && parseFloat(lowlevel) != 0))
			{
				if((critlow != '' && parseFloat(critlow) != 0))
				{
					if(parseFloat(val) < parseFloat(critlow)) 
						colorIndicator = cricLowStr;
					else if((parseFloat(val) >= parseFloat(critlow)) && (parseFloat(val) < parseFloat(lowlevel))) 
						colorIndicator = lowStr;
				}
				else if(parseFloat(val) < parseFloat(lowlevel)) 
					colorIndicator = lowStr;
			}

			if((highlevel != '' &&  parseFloat(highlevel) != 0))
			{
				if((crithigh != '' && parseFloat(crithigh) != 0))
				{
					if(parseFloat(val) > parseFloat(crithigh)) 
						colorIndicator = cricHighStr;
					else if((parseFloat(val) <= parseFloat(crithigh)) && (parseFloat(val) > parseFloat(highlevel))) 
						colorIndicator = highStr;
				}
				else if(parseFloat(val) > parseFloat(highlevel)) 
					colorIndicator = highStr;
			}
		}// end of else

		if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm != null)
		{
			var normal_abnormal_ind = eval("document.ChartLayoutDetailForm.normal_abnormal_ind_"+rownumber);
			normal_abnormal_ind.value=colorIndicator;
		}
		else
		{
			var normal_abnormal_ind = eval("document.chartRecordingAmendErrorForm.normal_abnormal_ind_"+rownumber);
			normal_abnormal_ind.value=colorIndicator ;
		}
	}
    var normabnormind = '';
	var normabnorminddesc = '';
	if ( val != null && val != '')
	{
		var val1=val;
		if(eval(mindigits) != 0) {
			
			if(val1.indexOf("-")>=0)
			{
				val1 = val1.substr(val1.indexOf("-")+1,val1.length);
			}
			
			if(val1.indexOf(".")>=0)
			{
				val1 = val1.substr(0, val1.indexOf("."));
			}
			if(val1.length < eval(mindigits))  {
				var short_desc_alert;

				if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm != null)
				{
					short_desc_alert = eval("document.ChartLayoutDetailForm.event_grp_desc_"+rownumber);
				}
				else
				{
					short_desc_alert = eval("document.chartRecordingAmendErrorForm.event_grp_desc_"+rownumber);
				}

				var message_alert=getMessage("MINIMUM_DIGITS","CA");
				message_alert=message_alert.replace('$',short_desc_alert.value);
				alert(message_alert+' '+mindigits);						
				obj.value='';
				obj.focus();
				//obj.select();
			}
		}
		if(!CheckForNumber1(val)) 
		{
			obj.focus();
		}
		else
		{
		    var n = obj.value;
			if((n.indexOf(".")) >= 0)
			{
				if(numdigitsdec !=0 )  {
					var arr =  new Array();
					arr = n.split(".");
					var num = arr[0].length;
					var frac = arr[1].length;

	                if (frac > numdigitsdec )
					{
						var msg = getMessage("VARIABLE_DEC_DIGIT","CA");
						msg = msg.replace("@",numdigitsdec);
						alert(msg);
						obj.value='';
						obj.focus();
					}
				}else {
					alert(getMessage("NO_DECIMAL","CA"));
					obj.value='';
					obj.focus();
				}
			}

		}
	}
	var tempHiddenString = "";
	if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm != null)
	{
		tempHiddenString = eval("document.forms[0].comp_"+rownumber);
		tempHiddenString.value = val;
	}
}
function CheckForNumber1(val) {
   /* if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 )
		{
            alert(getMessage("NUM_ALLOWED", "SM"));
            return false;
        }*/
		return true;
}
function validateDateTime(obj,val)
{
    if(obj.value != ''){
        if(val == 'E'){
            if(!doDateTimeChk(obj)){
                alert(getMessage("INVALID_DATE_TIME","CA"));
				obj.select();
                obj.focus();
            }
        }
        else if(val == 'D'){
            if(CheckDate(obj)){}
        }
        else if(val == 'T')
        {
            if(!chkTime(obj.value))
            {
                alert(getMessage("INVALID_TIME_FMT","CA"));
				obj.select();
                obj.focus();
            }
        }
		else if(val == 'F')
		{
			obj.value = obj.value.replace("'"," ");
			obj.value = obj.value.replace("\""," ");
		}
    }
}
function alignHeight(){
	parent.ChartRecordingListFrame.document.getElementById("titleTable").rows[0].height = ((parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[1].offsetHeight / 2)+1)
	parent.ChartRecordingListFrame.document.getElementById("titleTable").rows[1].height = ((parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[1].offsetHeight / 2)+1)
	
	var totalRows =  parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows.length;
	var counter = eval(totalRows);
	/*for(var i=2;i<parseInt(counter,10);i++){
		var hgt=parent.ChartRecordingListFrame.document.getElementById("titleTable").rows[i].offsetHeight;
		var hgt1=parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[i].offsetHeight;
		if(eval(hgt) > eval(hgt1)){
			parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[i].height = parseInt(hgt,10);
		}else if(eval(hgt1) > eval(hgt)){
			parent.ChartRecordingListFrame.document.getElementById("titleTable").rows[i].height = parseInt(hgt1,10);
		}				
	}*/
	for (var i = 0; i < parseInt(counter, 10); i++) {
	    // Ensure the rows exist in both frames before accessing them
	    var row1 = parent.ChartRecordingListFrame.document.getElementById("titleTable").rows[i];
	    var row2 = parent.ChartRecordingDetailFrame.document.getElementById("titleTable").rows[i];
	    
	   // Ensure both rows are valid
	        var hgt = row1.offsetHeight;
	        var hgt1 = row2.offsetHeight;

	        // Compare the heights and set the row height accordingly
	        if (hgt > hgt1) {
	            row2.style.height = hgt + "px";  // Set height as a style
	        } else if (hgt1 > hgt) {
	            row1.style.height = hgt1 + "px";  // Set height as a style
	        }
	   
	}
}
function limitTheGraphs(val)
{
	document.forms[0].selected_growth_event.value=val;
}
function openGraph(grpDetails,noOfGroups,allDatesForGraph)
{
	//alert(document.forms[0].episode_id.value);
	var encounterId = document.forms[0].episode_id.value
	//alert(parent.frames[1].document.forms[0].chkGraph.name+"=="+document.forms[0].chkGraph.name);
	//var counter = document.forms[0].chkGraph.length;
	var counter = document.getElementById("chkGraph").length;
	var index;
	var index1;
	var selected_events_no= "";
	var selected_events_desc ="";
	var selected_events_uom ="";
	var no_of_selections ="";
	var uom="";
	var count=0;
	if(document.forms[0].chkGraph.length != undefined || document.forms[0].chkGraph.length != null){
		for(var i=0;i<counter;i++){
			if(document.forms[0].chkGraph[i].checked){
				index =document.forms[0].chkGraph[i].value;
				index1 = document.forms[0].chkGraph[i].className;

				uom = eval("document.forms[0].uom_"+index1+".value")==""?" ":eval("document.forms[0].uom_"+index1+".value");

				selected_events_no +=index+"|";
				selected_events_desc +=eval("document.forms[0].event_grp_desc_"+index1+".value")+",";
				selected_events_uom +=uom+",";
				count++;
			}
		}
	}else{
			index = document.forms[0].chkGraph.value;
			index1 = document.forms[0].chkGraph.className;
			selected_events_no +=index+"|";
			selected_events_desc +=eval("document.forms[0].event_grp_desc_"+index1+".value")+",";
			selected_events_uom +=eval("document.forms[0].uom_"+index1+".value")+",";
			count++;
	}
	no_of_selections = count;
	//selected_events_uom = selected_events_uom.substring(0,selected_events_uom.length-1);
	//selected_events_desc = selected_events_desc.substring(0,selected_events_desc.length-1);
	document.forms[0].selected_events_no.value=selected_events_no;
	document.forms[0].selected_events_desc.value=selected_events_desc;
	document.forms[0].selected_events_uom.value=selected_events_uom;
	document.forms[0].no_of_selections.value=no_of_selections;

	
	//alert(selected_events_no);
	//alert(selected_events_desc);
	//alert(selected_events_uom);
	//alert(no_of_selections);
	if(count>0)
	{
		if(top.content != null)
		{
			if(top.content.messageFrame.location.href.indexOf("ChartRecordingServlet") !=-1)
			{
				var htmlValue = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form action='../eCA/jsp/ChartRecordingGraphFrameMain.jsp' method='post' name='frmEvent' id='frmEvent'><input type='hidden' name='selected_events_no' id='selected_events_no' value=\""+selected_events_no+"\"><input type='hidden' name='selected_events_desc' id='selected_events_desc' value=\""+selected_events_desc+"\"><input type='hidden' name='selected_events_uom' id='selected_events_uom' value=\""+selected_events_uom+"\"><input type='hidden' name='no_of_selections' id='no_of_selections' value=\""+no_of_selections+"\"><input type='hidden' name='encounterId' id='encounterId' value='"+encounterId+"'><input type='hidden' name='grpDetails' id='grpDetails' value=\""+grpDetails+"\"><input type='hidden' name='noOfGroups' id='noOfGroups' value=\""+noOfGroups+"\"><input type='hidden' name='allDatesForGraph' id='allDatesForGraph' value=\""+allDatesForGraph+"\"></form></body></html>"
			
			}
			else
			{
				var htmlValue = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form action='../../eCA/jsp/ChartRecordingGraphFrameMain.jsp' method='post' name='frmEvent' id='frmEvent'><input type='hidden' name='selected_events_no' id='selected_events_no' value=\""+selected_events_no+"\"><input type='hidden' name='selected_events_desc' id='selected_events_desc' value=\""+selected_events_desc+"\"><input type='hidden' name='selected_events_uom' id='selected_events_uom' value=\""+selected_events_uom+"\"><input type='hidden' name='no_of_selections' id='no_of_selections' value=\""+no_of_selections+"\"><input type='hidden' name='encounterId' id='encounterId' value='"+encounterId+"'><input type='hidden' name='grpDetails' id='grpDetails' value=\""+grpDetails+"\"><input type='hidden' name='noOfGroups' id='noOfGroups' value=\""+noOfGroups+"\"><input type='hidden' name='allDatesForGraph' id='allDatesForGraph' value=\""+allDatesForGraph+"\"></form></body></html>"
			}
		}
		else
		{
			var htmlValue = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form action='../../eCA/jsp/ChartRecordingGraphFrameMain.jsp' method='post' name='frmEvent' id='frmEvent'><input type='hidden' name='selected_events_no' id='selected_events_no' value=\""+selected_events_no+"\"><input type='hidden' name='selected_events_desc' id='selected_events_desc' value=\""+selected_events_desc+"\"><input type='hidden' name='selected_events_uom' id='selected_events_uom' value=\""+selected_events_uom+"\"><input type='hidden' name='no_of_selections' id='no_of_selections' value=\""+no_of_selections+"\"><input type='hidden' name='encounterId' id='encounterId' value='"+encounterId+"'><input type='hidden' name='grpDetails' id='grpDetails' value=\""+grpDetails+"\"><input type='hidden' name='noOfGroups' id='noOfGroups' value=\""+noOfGroups+"\"><input type='hidden' name='allDatesForGraph' id='allDatesForGraph' value=\""+allDatesForGraph+"\"></form></body></html>"
		}
		if(top.content != null){
			top.content.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			top.content.messageFrame.document.forms[0].submit();
		}else{
			parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			parent.messageFrame.document.forms[0].submit();
		}
	}
	else
	{
		alert(getMessage("NO_GRAPH_SELECTED","CA"));
	}
}

function resetForm(obj,function_from)
{
	if(obj.value != " Back ")
	{
		if(function_from != "SECONDARY_TRIAGE")
		{
			parent.chartRecordingFrameSet.rows = "40%,*,10%,4%,0%,0%";
			parent.colBarID.cols = "40%,60%";
		}

		if(parent.ChartRecordingCriteriaFrame != null)
		{
			parent.ChartRecordingCriteriaFrame.location.reload();
		}
		if(parent.ChartRecordingListFrame != null)
		{
			parent.ChartRecordingListFrame.location.href = "../../eCommon/html/blank.html";
		}
		parent.ChartRecordingDetailFrame.location.href = "../../eCommon/html/blank.html";
		parent.ChartRecordingToolBarFrame.location.href = "../../eCommon/html/blank.html";
		if(function_from != "SECONDARY_TRIAGE")
		{
			parent.ChartRecordingControlsFrame.location.href = "../../eCommon/html/blank.html";
			parent.ChartRecordingColorFrame.location.href = "../../eCommon/html/blank.html";
		}

		if(function_from == "SECONDARY_TRIAGE" || function_from == 'CP')
		{
			window.close();
		}
	}
	else
	{	
		var confirmSelect = window.confirm(getMessage("ACTION_CLEARS_VALUES","CA"));
		if(confirmSelect == true)
		{
			parent.chartRecordingFrameSet.rows = "36%,*,10%,4%,0%,0%";
			parent.colBarID.cols = "40%,60%";	parent.ChartRecordingCriteriaFrame.loadChart(parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.chart_id);
		}
	}

}
async function callSchedule()
{
	var chartId = document.forms[0].chart_id.value;
	var qs = document.forms[0].qs.value;
	var retVal			=	"";
	var dialogTop		=	"120" ;
	var dialogHeight	=	"25" ;
	var dialogWidth		=	"25" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/ChartRecordingSchedulerMain.jsp';
	action_url			+=	"?chartId="+chartId+"&"+qs;
	retVal				=	await window.showModalDialog(action_url,arguments,features);
}
function showCalendarValidate(str){
	
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
    return flg;
}
function showCalendarValidateForDate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
function callNewGraph()
{
	var chart_type = parent.ChartRecordingDetailFrame.document.forms[0].selected_growth_event.value;
	var patient_id = parent.ChartRecordingDetailFrame.document.forms[0].patient_id.value;
	if(chart_type=="H")
		chart_type = "HEIGHT";
	else if(chart_type=="W")
		chart_type = "WEIGHT";
	else if(chart_type=="C")
		chart_type = "CIRC";
	
	var arguments	= "" ;
	var queryString = "patientId="+patient_id+"&chart_type="+chart_type;
	retVal=window.open("../../eSP/jsp/CircumferenceChart.jsp?"+queryString,arguments,'height=470,width=790,top=50,left=0,resizable=yes');

}
function checkSequence(objSequence)
{
	//var errorMessage =""
	 if(parseInt(objSequence.value,10) <= 0)
			{
				var messsage=getMessage("SCOPE_NOT_ZERO","CA");
				//errorMessage= messageArray[messsage];
				alert(messsage);
				objSequence.value=''
				objSequence.focus()
				return false
			}
	 if(objSequence.value.charAt(0) == '-'||objSequence.value.charAt(1) == '-')
			{
				var messsage=getMessage("SEQUENCE_NOT_ZERO","CA");
				//errorMessage= messageArray[messsage];
				alert(messsage);
				objSequence.value=''
				objSequence.focus()
				return false
			}

}
function SearchChart(flag,daySummary,flagString)
{
	var chartId = document.forms[0].chart_id.value;

	var define_modifiable_at_trn_yn = "";
	
	if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm != null)
		define_modifiable_at_trn_yn = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.DEFINE_MODIFIABLE_AT_TRN_YN.value;
	else define_modifiable_at_trn_yn = "";

	if(chartId == "")
	{
		alert(getMessage("CHART_CANNOT_BLANK","CA"));
		return;
	}

	if(daySummary==undefined)
	{
			daySummary  = "1"
	}

	objCheckSummary = document.ChartLayoutCriteriaForm.summaryYN;
	objCheckDefault = document.ChartLayoutCriteriaForm.detailYN;
	if(objCheckSummary.checked == true && objCheckDefault.checked==true)
	{
		objCheckSummary.value='Y';
		objCheckDefault.value='Y';
	}
	else if(objCheckSummary.checked == true)
	{
		objCheckSummary.value='Y';
		objCheckDefault.value='N';
	}
	else if(objCheckDefault.checked == true)
	{
		objCheckSummary.value='N';
		objCheckDefault.value='Y';
	}
	else
	{
		objCheckSummary.value='N';
		objCheckDefault.value='N';
	}
					

			var fromDate = document.forms[0].fromDate.value;
			var toDate = document.forms[0].toDate.value;
			var encounterID = document.ChartLayoutCriteriaForm.encounter_id.value;
			if(encounterID == "0")
			{
				if(fromDate == "" && toDate == "")
				{
					alert(getMessage("FROM_TO_DATE_NOT_BLANK","CA"));
					return;
				}
				else if(fromDate == "")
				{
					alert(getMessage("FROM_DATE_NOT_BLANK","CA"));
					return;
				}
				else if(toDate == "")
				{
					alert(getMessage("TO_DATE_NOT_BLANK","CA"));
					return;
				}
			}
			var qs = document.forms[0].qs.value;
			var sort_by = document.ChartLayoutCriteriaForm.sort_by_asc_desc.value;
			var errorAuth = document.ChartLayoutCriteriaForm.errorAuth.value;
			var flagStringValue = document.ChartLayoutCriteriaForm.flagStringValue.value;
			//flagStringValue = flagString;
			var function_from = 		document.forms[0].function_from.value;
			var detailDate = document.forms[0].detailDate.value
			//SRR20056-SCF-9434-IN057123 [IN037552] - Start
			var locale = document.forms[0].locale.value;
			if(locale != 'en')
			{
				//fromDate = convertDate(fromDate,"DMYHM",locale,"en");//COMMENTED FOR IN071339
				//toDate = convertDate(toDate,"DMYHM",locale,"en");//COMMENTED FOR IN071339
			}
			//SRR20056-SCF-9434-IN057123 [IN037552] - End
			if(function_from != "")
	         {
				qs+="&function_from="+function_from;
			 }
			if(fromDate!="")
				qs +="&fromDate="+fromDate; 
			if(toDate!="")
				qs +="&toDate="+toDate; 
			if(detailDate!="")
			{
				qs +="&detailDate="+detailDate
				if(document.forms[0].detailSelect!=null)
					qs+="&noOfDays=0"
			}
			
			if(flagString=="getDay")
			{
				qs+="&flagString="+flagString;
				//qs+="&summaryText=1";
			}
			/*if(daySummary != '0')
			{
				if(document.ChartLayoutCriteriaForm.summaryText != null)
				{
					if(objCheckSummary.checked == true && objCheckDefault.checked==false)
					{
						if(document.ChartLayoutCriteriaForm.summaryText.value=="")
						qs +="&summaryText=10000"
						else
						qs +="&summaryText="+document.ChartLayoutCriteriaForm.summaryText.value;

					}
					else
					{
						qs +="&summaryText="+document.ChartLayoutCriteriaForm.summaryText.value;
					}
				}
			}*/
			
			if(chartId!="")	{
				
		if(flag=='jsp')	{
			
			//alert('chartId...'+chartId+'...qs....'+qs+'...objCheckDefault.value...'+objCheckDefault.value+'...objCheckSummary.value..'+objCheckSummary.value+'..sort_by..'+sort_by+'.....errorAuth...'+errorAuth+'.......define_modifiable_at_trn_yn....'+define_modifiable_at_trn_yn);
			parent.ChartRecordingControlsFrame.location.href="../jsp/ChartRecordingControls.jsp?Chart_Id="+chartId+"&"+qs+"&detailYN="+objCheckDefault.value+"&summaryYN="+objCheckSummary.value+"&sort_by="+sort_by+"&errorAuth="+errorAuth+"&DEFINE_MODIFIABLE_AT_TRN_YN="+define_modifiable_at_trn_yn;	
			parent.ChartRecordingListFrame.location.href="../jsp/ChartRecordingListPopulation.jsp?chartId="+chartId+"&"+qs+"&detailYN="+objCheckDefault.value+"&summaryYN="+objCheckSummary.value+"&sort_by="+sort_by+"&errorAuth="+errorAuth+"&DEFINE_MODIFIABLE_AT_TRN_YN="+define_modifiable_at_trn_yn;
			
		}
		else
		{
		   parent.ChartRecordingControlsFrame.location.href="../eCA/jsp/ChartRecordingControls.jsp?Chart_Id="+chartId+"&"+qs+"&detailYN="+objCheckDefault.value+"&summaryYN="+objCheckSummary.value+"&sort_by="+sort_by+"&errorAuth="+errorAuth+"&DEFINE_MODIFIABLE_AT_TRN_YN="+define_modifiable_at_trn_yn;
		   parent.ChartRecordingListFrame.location.href="../eCA/jsp/ChartRecordingListPopulation.jsp?chartId="+chartId+"&"+qs+"&detailYN="+objCheckDefault.value+"&summaryYN="+objCheckSummary.value+"&sort_by="+sort_by+"&errorAuth="+errorAuth+"&DEFINE_MODIFIABLE_AT_TRN_YN="+define_modifiable_at_trn_yn;
		}

			}
			else{ 
					parent.ChartRecordingDetailFrame.location.href = "../../eCommon/html/blank.html";
					parent.ChartRecordingListFrame.location.href = "../../eCommon/html/blank.html";
					parent.ChartRecordingToolBarFrame.location.href = "../../eCommon/html/blank.html";
			}

}
function getRecords(objButton)
{
		
		//alert('here..');
		//return false;
		var start=0;
		var end =0;
		var flagValue="";
		var sort_by = document.ChartLayoutCriteriaForm.sortValue.value;
		objCheckSummary = document.ChartLayoutCriteriaForm.summaryYN;
		objCheckDefault = document.ChartLayoutCriteriaForm.detailYN;
		var errorAuth = document.ChartLayoutCriteriaForm.errorAuth.value;
		if(objCheckSummary.checked == true && objCheckDefault.checked==true)
		{
			objCheckSummary.value='Y';
			objCheckDefault.value='Y';
		}
		else if(objCheckSummary.checked == true)
		{
			objCheckSummary.value='Y';
			objCheckDefault.value='N';
		}
		else if(objCheckDefault.checked == true)
		{
			objCheckSummary.value='N';
			objCheckDefault.value='Y';
		}
		else
		{
			objCheckSummary.value='N';
			objCheckDefault.value='N';
		}
		var chartId = document.forms[0].chart_id.value;
		var fromDate = document.forms[0].fromDate.value;
		var toDate = document.forms[0].toDate.value;
		var detailDate = document.forms[0].detailDate.value;
		var qs = document.forms[0].qs.value;
		//var summaryText = document.forms[0].summaryText.value;
		var summaryText = "";
		var flagStringValue = document.forms[0].flagStringValue.value;
		if(fromDate!="")
			qs +="&fromDate="+fromDate; 
		if(toDate!="")
				qs +="&toDate="+toDate; 
		if(objButton.name=='buttonFirst' )
		{	
			flagValue="first"
		parent.ChartRecordingListFrame.location.href="../jsp/ChartRecordingListPopulation.jsp?chartId="+chartId+"&"+qs+"&detailYN="+objCheckDefault.value+"&summaryYN="+objCheckSummary.value+"&start="+start+"&end="+end+"&flagValue="+flagValue+"&summaryText="+summaryText+"&sort_by="+sort_by+"&errorAuth="+errorAuth;
		}
		if(objButton.name=='buttonLast')
		{	
			
		flagValue="last"
	parent.ChartRecordingListFrame.location.href="../jsp/ChartRecordingListPopulation.jsp?chartId="+chartId+"&"+qs+"&detailYN="+objCheckDefault.value+"&summaryYN="+objCheckSummary.value+"&start="+start+"&end="+end+"&flagValue="+flagValue+"&summaryText="+summaryText+"&sort_by="+sort_by+"&errorAuth="+errorAuth;
		}
		else	if(objButton.name=='buttonPrev')
		{
			start = parseInt(document.forms[0].start.value)-parseInt(summaryText);
			end = parseInt(document.forms[0].end.value) - parseInt(summaryText);
			flagValue="Prev"
	
		parent.ChartRecordingListFrame.location.href="../jsp/ChartRecordingListPopulation.jsp?chartId="+chartId+"&"+qs+"&detailYN="+objCheckDefault.value+"&summaryYN="+objCheckSummary.value+"&start="+start+"&end="+end+"&flagValue="+flagValue+"&summaryText="+summaryText+"&sort_by="+sort_by+'&flagString='+flagStringValue+"&errorAuth="+errorAuth;

		}
		else	if(objButton.name=='buttonNext')
		{
			count = document.forms[0].maxRecord.value;
			start = parseInt(document.forms[0].start.value)+parseInt(summaryText);
			end = parseInt(document.forms[0].end.value) + parseInt(summaryText);
			flagValue="Next"

			//alert('count...'+count+'..start...'+start+'...end....'+end+'....flagValue...'+flagValue+'...summaryText...'+summaryText+'..sort_by....'+sort_by+'...flagStringValue...'+flagStringValue+'....errorAuth....'+errorAuth);
		parent.ChartRecordingListFrame.location.href="../jsp/ChartRecordingListPopulation.jsp?chartId="+chartId+"&"+qs+"&detailYN="+objCheckDefault.value+"&summaryYN="+objCheckSummary.value+"&start="+start+"&end="+end+"&flagValue="+flagValue+"&summaryText="+summaryText+"&sort_by="+sort_by+'&flagString='+flagStringValue+"&errorAuth="+errorAuth;
		}
}
async function getDay()
{
	
	/*document.forms[0].buttonLast.disabled = true
	document.forms[0].buttonLast.title = ''
	document.forms[0].buttonPrev.disabled = true
	document.forms[0].buttonPrev.title = ''
	document.forms[0].buttonFirst.disabled = true
	document.forms[0].buttonFirst.title = ''
	document.forms[0].buttonNext.disabled = true
	document.forms[0].buttonNext.title = ''*/

	var functionFrom = document.forms[0].function_from.value
	var chart_id = document.forms[0].chart_id.value
	var encounterId= document.forms[0].encounter_id.value
	var patient_id = document.forms[0].patient_id.value
	var adm_date = document.forms[0].adm_date.value
	var fromDate = document.forms[0].fromDate.value
	var toDate = document.forms[0].toDate.value
	var facility_id = document.forms[0].facility_id.value
	var module_id = document.forms[0].module_id.value
	var detailDate = "";
	if(functionFrom == "CP")
	{
		if(module_id == 'OR')
		{
			detailDate = document.forms[0].detailDate.value;
		}
		else
		{
			var tempDetailDate = document.forms[0].detDate.value
			var splitDetailDate = tempDetailDate.split(" ");
			detailDate = splitDetailDate[0];
		}
	}
	else
	{
		detailDate = document.forms[0].detailDate.value
	}
	
	var detailSelect = "0"
	var dialogTop		=	"200" ;
	var dialogHeight= "12" ;
	var dialogWidth = "32" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var qs = "";
	if(toDate !="")
		qs=qs+"&toDate="+toDate;
	if(fromDate)
		qs=qs+"&fromDate="+fromDate;
	
	if(chart_id)
	{
		var action_url		=	'../../eCA/jsp/ChartRecordingDiaryCalendarFrameSet.jsp?chartId='+chart_id+'&encounterId='+encounterId+'&patient_id='+patient_id+'&adm_date='+adm_date+'&facility_id='+facility_id+qs+"&detailDate="+detailDate+"&detailSelect=0";
		var retVal=await window.showModalDialog(action_url,arguments,features);		
		
		
		if(retVal != undefined)
		{
			document.ChartLayoutCriteriaForm.detailDate.value=retVal
			//if(detailDate != retVal)
				SearchChart('jsp','0','getDay');			
		}
	}
}
function getDate(objButton)
{
	var dateValue=document.ChartRecordingDiaryTopForm.currentDate.value;
	var currdateValue=document.ChartRecordingDiaryTopForm.currDate.value;
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
		var HtmlVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form action='../../eCA/jsp/ChartRecordingDiaryCalendarIntermediate.jsp' method='post' name='tempForm' id='tempForm'><input type='hidden' name='flag' id='flag' value=\""+flag+"\"><input type='hidden' name='currdateValue' id='currdateValue' value=\""+currdateValue+"\"></form></body></html>"
		parent.blankFrame.document.write(HtmlVal);
		parent.blankFrame.document.tempForm.submit();
	}
}
function getDetailDate(day,monthYear)
{
	if(day.length < 2) day = "0" + day;
	var dateSplit = monthYear.split("/");
	var date = day + "/" +dateSplit[1]+ "/" +dateSplit[2]
	window.returnValue =  date
	window.close();
}
function clickOK()
{

	if (document.forms[0].selectCriteria[0].checked == true)
	{
		
		Continue();
	}
	else
	{
		defineItems();
	}
}
function getToolTipforSummaryButtons()
{

	var htmlVal="";
	var objCheckSummary=document.forms[0].summaryYN;
	var objCheckDetail=document.forms[0].detailYN;
	var chartId = document.forms[0].chart_id.value;
  	var detailDate= document.forms[0].detailDate.value;
		var 	qs = document.forms[0].qs.value;
	var fromDate = document.forms[0].fromDate.value;
	var toDate = document.forms[0].toDate.value;
	if(fromDate!="")
			qs +="&fromDate="+fromDate; 
	if(toDate!="")
				qs +="&toDate="+toDate; 
	var defaultYN = parent.ChartRecordingDetailFrame.document.forms[0].DEFINE_MODIFIABLE_AT_TRN_YN.value;
parent.ChartRecordingIntermediateFrame.location.href='../../eCA/jsp/ChartRecordingIntermediateForSummary.jsp?&'+qs+'&chartId='+chartId+'&DEFINE_MODIFIABLE_AT_TRN_YN='+defaultYN

}

function checkForCurrentDate(obj,format)
{
	var locale		= document.forms[0].locale.value;
	var fromDate1	= obj.value;

	if(fromDate1 != "")
	{
		  if(!isBeforeNow(fromDate1,format,locale))
		  {
				alert(getMessage("DATE_TIME_GREATER_SYSDATE","CA"))			
				obj.value = getCurrentDate("DMYHM",locale);
				obj.select();
				return false
		  }
		  else
				return true;
	}
}

/*function checkForCurrentDate()
{
	var currDate = document.forms[0].sysdate.value
	var fromDate1 = document.forms[0].fromDate.value

	if(fromDate1 !="")
	{
		fromDate = fromDate1.split(" ");
	
		var retVal = checkDt(fromDate[0]);
		
	 if(retVal)
		{
		  
		  var splitdate =fromDate[0].split("/")
		  var splitdate1 =currDate.split("/")
		   var from_date  =new Date(eval(splitdate[2]), eval(splitdate[1])-1, eval(splitdate[0]))
		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]))
			if(Date.parse(to_date) < Date.parse(from_date))
			{
					alert(getMessage("FROM_DATE_GREATER_SYSDATE","CA"))			
					document.forms[0].fromDate.select();
					return false		   
			}
			else
				return true;
		}
		else
		{
			return true;
		}
	}
 
} */

function chkValidityOfTime(strfromTime)
{
	if(strfromTime.value != '')
	{
		strfromTimeVal = strfromTime.value;
		strTemp = strfromTimeVal.indexOf(":");
		if(strTemp == -1 || strTemp != 2){
			alert(getMessage("INVALID_TIME_FMT","CA"));
			strfromTime.select();
			return false;
		}
		else
		{
			checkTimeForDetail(strfromTime);
		}
	}
}
function checkTimeForDetail(strfromTime)
{
	strfromTimeVal = strfromTime.value;
	strSplitTime = strfromTimeVal.split(":");
	hr = strSplitTime[0];
	min = strSplitTime[1];

	if(strfromTime.value.length !=5)
	{
		alert(getMessage("INVALID_TIME_FMT","CA"));
				strfromTime.select();
		return false;
	}
	
	if(!(hr.charCodeAt(0) >= 48 && hr.charCodeAt(0) <=57 &&
		hr.charCodeAt(1) >= 48 && hr.charCodeAt(1) <=57 &&
		min.charCodeAt(0) >= 48 && min.charCodeAt(0) <=57 &&
		min.charCodeAt(1) >= 48 && min.charCodeAt(1) <=57  ))
		{
			alert(getMessage("INVALID_TIME_FMT","CA"));
			strfromTime.select();
			return false;
		}



	if(hr>23){
		alert(getMessage("INVALID_TIME_HOUR","CA"));
		strfromTime.select();
		return false;
	}
	if(min>59){
				alert(getMessage("INVALID_TIME_MINUTE","CA"));
		strfromTime.select();
		return false;
	}
	return true;
}
function checkDateForDetail(objDate)
{

	if(objDate.value != '')
	{
		var retVal= checkDt(objDate.value)
		if(retVal == false)
		{
			alert(getMessage("INVALID_DATE_FMT","CA"))
			objDate.select();
		}
		else
		{
				var dateArray = objDate.value.split("/")

				if(dateArray[1] == 0)
				{
						alert(getMessage("INVALID_DATE_FMT","CA"))
						objDate.select();
				}
		}
	}
}
function alignHeightWidth()
{
	var totalRows =  document.getElementById("tableId2").rows.length;
	var counter = eval(totalRows);

    for(var i=0;i<parseInt(counter,10);i++)
		{
			
			var hgt2= document.getElementById("tableId2").rows[i].offsetHeight;
			var hgt1=document.getElementById("tbId").rows[i].offsetHeight;
			if(parseInt(hgt2) > parseInt(hgt1))
			{	
				document.getElementById("tbId").rows[i].height = hgt2;
			}
			else if(parseInt(hgt2) < parseInt(hgt1))
			{
				document.getElementById("tableId2").rows[i].height = hgt1;
			}

		}
		
}
function Close()
{
	var qs = document.forms[0].qs.value
	parent.blankFrame.location.href ='../../eCA/jsp/ChartRecordingCriteriaForAddingItemsIntermediate.jsp?'+qs

}

function displayListForAE()
{
	var qs = document.ChartLayoutDetailForm.qs.value;
	var chart_id = document.ChartLayoutDetailForm.chart_id.value;
	var detDate = document.ChartLayoutDetailForm.detDate.value;
	qs += "&fromDate="+detDate+"&toDate="+detDate;
	parent.ChartRecordingListFrame.location.href="../jsp/ChartRecordingListPopulation.jsp?chartId="+chart_id+"&detailDate="+detDate+"&"+qs;
}
var form_grp_id = ""; //IN045223.1
function displayFormula()
{
	var count = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.count.value;
	var objRef = "parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm";
	var flag1 = 0; //IN045223
	/*IN068742 Starts*/
	var numdec=parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.numdecimal.value;
	numdec=parseInt(numdec);
	/*IN068742 Ends*/
	for(var n=0;n<count;n++)
	{
		var mandatoryyn = eval(objRef+".mandatory_yn_"+n+".value");
		var objHidden =  eval(objRef+".comp_"+n);
		var objHiddenName = eval(objRef+".discr_msr_id_grp_id"+n);
		var compFormula = eval(objRef+".comp_formula"+n);
		var associate_score_yn = eval(objRef+".associate_score_yn"+n+".value"); //IN045223.1
		var objRefText = objRef+"."+objHiddenName.value
		//IN045223 - Start
		var data_sel = eval("document.forms[0].comp_"+n+".value");
		var grp_id = eval(objRef+".chat_grp_id_"+n+".value"); //IN045223.1
		//IN045223.1 Added if condition to check chart grp
		if(grp_id == form_grp_id)
		{
			if (data_sel != "")
			{
				if(compFormula == undefined && associate_score_yn != 'N') //IN045223.1
					flag1++;
			}	
		}	
		//IN045223 - End

		var objText = eval(objRefText);
		if(compFormula != undefined)
		{
			var flag
			var formula = eval(compFormula.value);
			var number = parseFloat(formula);
			flag = 	isFinite(number)
			var index = 0;
			form_grp_id = eval(objRef+".chat_grp_id_"+n+".value"); //IN045223.1

			if(flag == true)
			{ 
				number = number * 1000
				number = number /1000;
				number=number.toFixed(numdec);//IN068742
				//IN040163 - added if n else condition
				if(number!=0)
				{
					objText.value= number
					objHidden.value = number
				}else if(number==0)
				{
					//IN045223 - Modified Start
					if(flag1>0)
					{
						objText.value= number;
						objHidden.value = number;
					}
					else
					{
						objText.value= "";
						objHidden.value = "";
					}
					//IN045223 - Modified End
				}
			}
			else
			{
				objHidden.value = ""
			}		
		}
	}
}

function addToGroups(obj,shortDesc,discrMsrID)
{
	//alert('shortDesc...'+shortDesc);
	//alert('shortDesc..enc.'+encodeURIComponent(shortDesc,"UTF-8"));
	if(parent.ChartRecordingListFrame.document.forms[0] != null)
	{
		var noOfChkdBoxes =  parseInt(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value);

		var patientId = parent.ChartRecordingListFrame.document.ChartLayoutListForm.patientId.value;
		var encounterId = parent.ChartRecordingListFrame.document.ChartLayoutListForm.encounterId.value;

		if(obj.checked == true)
		{
			if(noOfChkdBoxes > 8)
			{
				var message = getMessage("MAX_CHART_EVENTS","CA");
				message = message.replace('$$','9');
				alert(message);
				obj.checked = false;
				return false;
			}
			else
				parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value = noOfChkdBoxes+1;
		}
		else if(obj.checked == false)
			parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value = noOfChkdBoxes-1;
				
		var datesAndVals = "";
		var numOfDates = parent.ChartRecordingListFrame.document.forms[0].numOfDates.value;

		var objRowNum = obj.className;
		var tdObjectValues = "";
		var concTdObjValues = "";

		var uom = eval("document.ChartLayoutDetailForm.uom_"+objRowNum);
		if(uom.value == "")
		{
			uom.value = " ";
		}

		for(var t=0;t<parseInt(numOfDates,10);t++)
		{
			tdObjectValues = eval(parent.ChartRecordingListFrame.document.getElementById("values"+parseInt(objRowNum,10)+"ForGraphs"+t)).value;
			concTdObjValues = concTdObjValues + tdObjectValues +">";
		}
		// IN29392 Starts
		//parent.ChartRecordingAddToGrpFrame.document.write("<html><form name='chartRecAddToGrpFrom' id='chartRecAddToGrpFrom' action='../../eCA/jsp/ChartRecordingAddToGrpIntermediate.jsp'><input type='hidden' name='ChkdBoxes' id='ChkdBoxes' value = '"+obj.checked+"'><input type='hidden' name='desc' id='desc' value = '"+shortDesc+"'><input type='hidden' name='code' id='code' value = '"+discrMsrID+"'><input type='hidden' name='concTdObjValues' id='concTdObjValues' value = '"+concTdObjValues+"'><input type='hidden' name='uom' id='uom' value = '"+uom.value+"'><input type='hidden' name='encounter_id' id='encounter_id' value = '"+encounterId+"'><input type='hidden' name='patient_id' id='patient_id' value = '"+patientId+"'></form></html>");
		parent.ChartRecordingAddToGrpFrame.document.write("<html><form name='chartRecAddToGrpFrom' id='chartRecAddToGrpFrom' action='../../eCA/jsp/ChartRecordingAddToGrpIntermediate.jsp'><input type='hidden' name='ChkdBoxes' id='ChkdBoxes' value = '"+obj.checked+"'><input type='hidden' name='desc' id='desc' value = '"+encodeURIComponent(shortDesc,"UTF-8")+"'><input type='hidden' name='code' id='code' value = '"+discrMsrID+"'><input type='hidden' name='concTdObjValues' id='concTdObjValues' value = '"+concTdObjValues+"'><input type='hidden' name='uom' id='uom' value = '"+uom.value+"'><input type='hidden' name='encounter_id' id='encounter_id' value = '"+encounterId+"'><input type='hidden' name='patient_id' id='patient_id' value = '"+patientId+"'></form></html>");
		// IN29392 Ends
		parent.ChartRecordingAddToGrpFrame.document.chartRecAddToGrpFrom.submit();
	}
	else
	{	
		obj.checked = false;
		alert(getMessage("NO_DATA_AVAILABLE","CA"));
		return;
	}
}

/*function closeWindow(obj)
{
	if(parent.groupNamesAndDetailsFrame != null)
	{
		var group1 = parent.groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.group1.value;
		var group2 = parent.groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.group2.value;
		var group3 = parent.groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.group3.value;
		var group4 = parent.groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.group4.value;
		if(obj.name == "grpButtonClose")
		{
			document.ChartRecordingButtonsForm.forRetValue.value = 'C';
		}
		else if(obj.name == "grpButtonOK")
		{
			if(group1 > 10 || group2 > 10 || group3 > 10 || group4 > 10)
			{
				alert(getMessage("NO_GRAPH_EVENTS_MORE","CA"));
				return;
			}
			else
			{
				document.ChartRecordingButtonsForm.forRetValue.value = 'O';
			}
		}
	}
	window.close();
}*/

function closeWindow(obj)
{
	document.chartRecordingGrpDetailsForm.graph.disabled = true;
	var selected_events_uom = document.forms[0].selected_events_uom.value;
	var no_of_selections = document.forms[0].no_of_selections.value;
	var numOfchkedBoxes = document.forms[0].numOfchkedBoxes.value;
	//alert("numOfchkedBoxes"+numOfchkedBoxes);
	//var noOfGroups = document.forms[0].noOfGroups.value;
	var noOfGroups = document.forms[0].grpCount.value;

	var grpDetails = document.forms[0].grpDetails.value;
	var patient_id = document.forms[0].patient_id.value;
	var facility_id = document.forms[0].facility_id.value;
	var encounterId = document.forms[0].encounterId.value;
	var flowsheetGraph = document.forms[0].flowsheetGraph.value;

	var axis_range;
	if(document.chartRecordingGrpDetailsForm.axis_range[0].checked == true)
		axis_range = document.chartRecordingGrpDetailsForm.axis_range[0].value;
	else if(document.chartRecordingGrpDetailsForm.axis_range[1].checked == true)
		axis_range = document.chartRecordingGrpDetailsForm.axis_range[1].value;
	
		var group1 = document.chartRecordingGrpDetailsForm.group1.value;
		var group2 = document.chartRecordingGrpDetailsForm.group2.value;
		var group3 = document.chartRecordingGrpDetailsForm.group3.value;
		var group4 = document.chartRecordingGrpDetailsForm.group4.value;
		if(obj != null)
		{
			if(obj.name == "grpButtonClose")
			{
				document.ChartRecordingButtonsForm.forRetValue.value = 'C';
			}
		}
		else
		{
			// IN29392 Starts
			//parent.parent.parent.graphDisplayFrame.location.href = '../../eCA/jsp/ChartRecordingGraphFrameMain.jsp?selected_events_uom='+selected_events_uom+'&no_of_selections='+no_of_selections+'&noOfGroups='+noOfGroups+'&grpDetails='+grpDetails+'&allDatesForGraph='+document.chartRecordingGrpDetailsForm.allDatesForGraph.value+'&encounterId='+encounterId+'&facility_id='+facility_id+'&patient_id='+patient_id+'&axis_range='+axis_range+'&flowsheetGraph='+flowsheetGraph+'&numOfchkedBoxes='+numOfchkedBoxes;
			parent.parent.parent.graphDisplayFrame.location.href = '../../eCA/jsp/ChartRecordingGraphFrameMain.jsp?selected_events_uom='+selected_events_uom+'&no_of_selections='+no_of_selections+'&noOfGroups='+noOfGroups+'&grpDetails='+encodeURIComponent(grpDetails,"UTF-8")+'&allDatesForGraph='+document.chartRecordingGrpDetailsForm.allDatesForGraph.value+'&encounterId='+encounterId+'&facility_id='+facility_id+'&patient_id='+patient_id+'&axis_range='+axis_range+'&flowsheetGraph='+flowsheetGraph+'&numOfchkedBoxes='+numOfchkedBoxes;// IN29392 Ends			
				
		}

}

function loadDetailsPage(obj)
{
	var chkBox = "";
	var statusChecked = "";
	var statChk = "";
	var chkedCount = 0;
	var grpCount = document.chartRecordingGrpDetailsForm.grpCount.value;
	var grpDetails = document.chartRecordingGrpDetailsForm.grpDetails.value;
	var count = document.chartRecordingGrpDetailsForm.noOfRecs.value;
	var facility_id = document.chartRecordingGrpDetailsForm.facility_id.value;
	var encounterId = document.chartRecordingGrpDetailsForm.encounterId.value;
	var patient_id = document.chartRecordingGrpDetailsForm.patient_id.value;
	var flowsheetGraph = document.chartRecordingGrpDetailsForm.flowsheetGraph.value;
	var numOfchkedBoxes = document.forms[0].numOfchkedBoxes.value;
	//alert("numOfchkedBoxes"+numOfchkedBoxes);

	var group1 = document.chartRecordingGrpDetailsForm.group1.value;
	var group2 = document.chartRecordingGrpDetailsForm.group2.value;
	var group3 = document.chartRecordingGrpDetailsForm.group3.value;
	var group4 = document.chartRecordingGrpDetailsForm.group4.value;

	var grp1Val = document.chartRecordingGrpDetailsForm.grp1Val.value;
	var grp2Val = document.chartRecordingGrpDetailsForm.grp2Val.value;
	var grp3Val = document.chartRecordingGrpDetailsForm.grp3Val.value;
	var grp4Val = document.chartRecordingGrpDetailsForm.grp4Val.value;

	var GroupName1 = document.chartRecordingGrpDetailsForm.GroupName1.value = "Group 1";
	var GroupName2 = document.chartRecordingGrpDetailsForm.GroupName2.value = "Group 2";
	var GroupName3 = document.chartRecordingGrpDetailsForm.GroupName3.value = "Group 3";
	var GroupName4 = document.chartRecordingGrpDetailsForm.GroupName4.value = "Group 4";

	/*alert("GroupName1 ="+GroupName1+"= GroupName1");
	alert("GroupName2 ="+GroupName2+"= GroupName2");
	alert("GroupName3 ="+GroupName3+"= GroupName3");
	alert("GroupName4 ="+GroupName4+"= GroupName4");*/

	/*alert("grp1Val --"+grp1Val+"-- grp1Val");
	alert("grp2Val --"+grp2Val+"-- grp2Val");
	alert("grp3Val --"+grp3Val+"-- grp3Val");
	alert("grp4Val --"+grp4Val+"-- grp4Val");*/

	for(var i=0;i<count;i++)
	{
		chkBox = eval("document.chartRecordingGrpDetailsForm.chkDiscrMsr"+i);
		if(chkBox.checked)
		{
			chkedCount = parseInt(chkedCount) +1;
			statChk = chkBox.id;
		}
		if(statChk != "")
		{
			if(statusChecked == "")
				statusChecked += statChk ;
			else
				statusChecked += "!!"+statChk;
		}
	}
	statusChecked += "!!";

	var GroupName = "";
	var totalCount = parseInt(group1,10) + parseInt(group2,10) + parseInt(group3,10) + parseInt(group4,10);
	var totalGrps = parseInt(grp2Val,10) + parseInt(grp3Val,10) + parseInt(grp4Val,10); //grps except grp1
	var totalGrps2And3 = parseInt(grp2Val,10) + parseInt(grp3Val,10); //grps except grp1 and grp4
	
	/*if(count == 4 && grpCount == 4)
	{
		document.chartRecordingGrpDetailsForm.reset();
	}
	else
	{*/
		if(obj == "Group 1")
		{
			GroupName = "Group 1";
			if((parseInt(totalCount,10) - parseInt(totalGrps,10)) == parseInt(group1,10))
			{
				GroupName = "Group 1";
			}			
			else if(parseInt(group3,10) != 0 && parseInt(group4,10) != 0)
			{
				if(grpCount != '4')
				{
					if((parseInt(group2,10) - parseInt(grp2Val,10)) == 0) GroupName = "Group 2";
					else if((parseInt(group3,10) - parseInt(grp3Val,10)) == 0) GroupName = "Group 3";
				}
				else
				{
					if((parseInt(grp4Val,10) >= 1 && ((parseInt(group2,10) - parseInt(grp2Val,10)) != 0) && (parseInt(group3,10) - parseInt(grp3Val,10)) != 0) || (parseInt(grp2Val,10) >= 1 &&  (parseInt(group2,10) - parseInt(grp2Val,10)) != 0) || (parseInt(grp3Val,10) >= 1 && (parseInt(group3,10) - parseInt(grp3Val,10)) != 0)) GroupName = "Group 1";
					else return;
				}
			}
			else if(parseInt(group3,10) != 0 && parseInt(group4,10) == 0 && grpCount != '3')
			{
				if((parseInt(group3,10) - parseInt(grp3Val,10)) == 0) GroupName = "Group 3";
			}
			else if(parseInt(group3,10) == 0 && parseInt(group4,10) != 0)
			{
				if((parseInt(group4,10) - parseInt(grp4Val,10)) == 0) GroupName = "Group 4";
			}
		}		
		else if(obj == "Group 2")
		{
			GroupName = "Group 2";
			if((parseInt(group1,10) - parseInt(grp1Val,10)) == 0) GroupName = "Group 1";

			else if(parseInt(group4,10) != 0)
			{
				if((parseInt(group3,10) - parseInt(grp3Val,10)) == 0) GroupName = "Group 3";
			}

			else if(parseInt(grp3Val,10) != 0 && parseInt(grp4Val,10) != 0)
			{
				GroupName = "Group 2";
			}
		}
		else if(obj == "Group 3")
		{
			GroupName = "Group 3";

			if((parseInt(group1,10) - parseInt(grp1Val,10)) == 0) GroupName = "Group 1";
			else if((parseInt(group2,10) - parseInt(grp2Val,10)) == 0) GroupName = "Group 2";
		}		
		else if(obj == "Group 4")
		{
			GroupName = "Group 4";
			if((parseInt(group1,10) - parseInt(grp1Val,10)) == 0) GroupName = "Group 1";
			else if((parseInt(group2,10) - parseInt(grp2Val,10)) == 0) GroupName = "Group 2";
			else if((parseInt(group3,10) - parseInt(grp3Val,10)) == 0) GroupName = "Group 3";
		}
		else if(obj == "New Group")
		{
			if(grpCount == '1')
			{
				if(grp1Val != group1)
				{
					GroupName = "Group 2";
				}
				else
				{
					GroupName = "Group 1";
				}
			}
			else if(grpCount == '2')
			{
				GroupName = "Group 3";
				if((parseInt(group1,10) - parseInt(grp1Val,10)) == 0) GroupName = "Group 1";
				else if((parseInt(group2,10) - parseInt(grp2Val,10)) == 0) GroupName = "Group 2";
			}
			else if(grpCount == '3')
			{
				GroupName = "Group 4";
				if((parseInt(group1,10) - parseInt(grp1Val,10)) == 0) GroupName = "Group 1";
				else if((parseInt(group2,10) - parseInt(grp2Val,10)) == 0) GroupName = "Group 2";
				else if((parseInt(group3,10) - parseInt(grp3Val,10)) == 0) GroupName = "Group 3";
			}
		}

		if(grpCount == '4')
		{
			if(grp4Val != 0 && obj == 'Group 4')
			{
				GroupName = "Group 4";
			}
		}
	//}
	
	if(chkedCount == count)
	{
		GroupName = "Group 1";
	}

	var allDatesForGraph = document.forms[0].allDatesForGraph.value;

	var val = "radBtn";
	location.href = "../../eCA/jsp/ChartRecordingGroupDetails.jsp?sentFrom="+val+"&groupName="+GroupName+"&statusChecked="+statusChecked+"&grpCountFromRad="+grpCount+"&count="+count+"&allDatesForGraph="+allDatesForGraph+"&patient_id="+patient_id+"&encounterId="+encounterId+"&facility_id="+facility_id+"&flowsheetGraph="+flowsheetGraph+"&numOfchkedBoxes="+numOfchkedBoxes;	

}

function addToGrpLink(code,groupName)
{
	//alert(groupName);
	//alert(document.getElementById("tdID").id);
	var tr1 = "";
	var tr2 = "";
	var tr3 = "";

	if(groupName == "Group 1")
	{
		tr2 = "Group 2";
		tr3 = "Group 3";
	}
	else if(groupName == "Group 2")
	{
		tr2 = "Group 1";
		tr3 = "Group 3";
	}
	else if(groupName == "Group 3")
	{
		tr2 = "Group 1";
		tr3 = "Group 2";
	}
	var tableVar = "<table id='toolTipTable' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'><tr><td><a href='javascript:' onclick='addToSelectedGroup(\""+code+"\",\""+groupName+"\")'>"+tr2+"</a></td></tr><tr><td><a href='javascript:' onclick='addToSelectedGroup(\""+code+"\",\""+groupName+"\")'>"+tr3+"</a></td></tr>";
	
	document.getElementById("tdID").innerHTML = tableVar;
	//alert(document.getElementById("tdID").innerHTML);

	var bodwidth  = document.body.offsetWidth
	var bodheight = document.body.offsetHeight
	var x 	  = event.x
	var y 	  = event.y;
	x 	  = x + (document.getElementById("toolTipDiv").offsetWidth)
	y 	  = y + (document.getElementById("toolTipDiv").offsetHeight)

	if(x<bodwidth)
		x = event.x 
	else
		x = x - (document.getElementById("toolTipDiv").offsetWidth*2)
	if(y<bodheight)
		y = event.y
	else
		y = y - (document.getElementById("toolTipDiv").offsetHeight*2)
	
	y+=document.body.scrollTop
	x+=document.body.scrollLeft
	document.getElementById("toolTipDiv").style.posLeft= x
	document.getElementById("toolTipDiv").style.posTop = y

	document.getElementById("toolTipDiv").style.visibility = "visible";
}

function addToSelectedGroup(code,groupName)
{
//	alert(location.href);
	location.href = '../../eCA/html/blank.html';
}


/*function openWinForGrouping()
{
	var allDatesForGraph = parent.ChartRecordingListFrame.document.forms[0].allDatesForGraph.value;
	var noOfChkdBoxes = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value;
	var sentFromGraph = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.sentFromGraph.value;
	var flagGraph = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.flagGraph.value;
	if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value > 1)
	{
		var dialogTop		=	"80" ;
		var dialogHeight= "25" ;
		var dialogWidth = "40" ;
		var status			=	"no";
		var arguments		=	"" ;
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../eCA/jsp/ChartRecordingGroupsFrame.jsp?sentFromGraph='+sentFromGraph+'&flagGraph='+flagGraph+'&allDatesForGraph='+allDatesForGraph;
		var retVal=window.showModalDialog(action_url,arguments,features);		
		if(retVal != undefined)
		{
			retVal = retVal.split("%||%");
			openGraph(retVal[0],retVal[1],retVal[2]);
		}
	}
	else if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value == 1)
	{
		openGraph(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.grpDetails.value,'1',allDatesForGraph);
	}
	else if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value == 0)
	{
		alert(getMessage("NO_GRAPH_SELECTED","CA"));
		return;
	}
}*/

async function openWinForGrouping()
{
	var splChartType = parent.ChartRecordingCriteriaFrame.document.forms[0].splChartType.value;
	var patient_id = parent.ChartRecordingCriteriaFrame.document.forms[0].patient_id.value;
	var chart_id = parent.ChartRecordingCriteriaFrame.document.forms[0].chart_id.value;
	var Sex = parent.ChartRecordingCriteriaFrame.document.forms[0].Sex.value;
	
	if((splChartType != 'GR' && parent.ChartRecordingListFrame.document.forms[0] == null) || parent.ChartRecordingDetailFrame.document.forms[0].chkGraph == null)
	{
		alert(getMessage("NO_DATA_AVAILABLE","CA"));
		return;	
	}

	if(splChartType != "GR" && parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value == 0)
	{
		alert(getMessage("NO_GRAPH_SELECTED","CA"));
		return;
	}
	
	var encounterId = parent.ChartRecordingDetailFrame.document.forms[0].encounter_id.value
	var facility_id = parent.ChartRecordingDetailFrame.document.forms[0].facility_id.value
	
	/*****Modified by Deepa on 12/2/2009 at 12:09 PM for IN016745 ******************************/
	//var encounterId = parent.ChartRecordingDetailFrame.document.forms[0].episode_id.value
	// changed episode_id to encounter_id since there is no special reason to use episode_id in place of encounter_id
	if(encounterId == '') encounterId = '0';
	/*****Modified by Deepa on 12/2/2009 at 12:09 PM for IN016745 ******************************/

	//var counter = parent.ChartRecordingDetailFrame.document.getElementById("chkGraph").length;
	var counter = parent.ChartRecordingDetailFrame.document.querySelectorAll('input[type=checkbox] ').length;
	var index;
	var index1;
	var selected_events_no= "";
	var selected_events_desc ="";
	var selected_events_uom ="";
	var no_of_selections ="";
	var uom="";
	var count=0;
	if(parent.ChartRecordingDetailFrame.document.forms[0].chkGraph.length != undefined || parent.ChartRecordingDetailFrame.document.forms[0].chkGraph.length != null){
		for(var i=0;i<counter;i++){
			if(parent.ChartRecordingDetailFrame.document.forms[0].chkGraph[i].checked){
				index =parent.ChartRecordingDetailFrame.document.forms[0].chkGraph[i].value;
				index1 = parent.ChartRecordingDetailFrame.document.forms[0].chkGraph[i].className;
				var code =eval("parent.ChartRecordingDetailFrame.document.forms[0].dis_msr_id_"+i+".value"); //IN052210
				var desc =eval("parent.ChartRecordingDetailFrame.document.forms[0].event_grp_desc_"+i+".value");//IN052210
				uom = eval("parent.ChartRecordingDetailFrame.document.forms[0].uom_"+index1+".value")==""?" ":eval("parent.ChartRecordingDetailFrame.document.forms[0].uom_"+index1+".value");

				selected_events_no +=index+"|";
				//selected_events_desc +=eval("document.forms[0].event_grp_desc_"+index1+".value")+",";
				selected_events_uom +=uom+",";
				count++;
				//IN052210 Start
				var numOfDates = parent.ChartRecordingListFrame.document.forms[0].numOfDates.value;				
				var tdObjectValues = "";
				var concTdObjValues = "";			

				for(var t=0;t<parseInt(numOfDates,10);t++)
				{
					tdObjectValues = eval(parent.ChartRecordingListFrame.document.getElementById("values"+parseInt(index1,10)+'ForGraphs'+t)).value;
					concTdObjValues = concTdObjValues + tdObjectValues +">";
				}
				try{
				/*var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
				var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc='';
				xmlStr			= "<root><SEARCH " ;
				xmlStr 			+=" /></root>" ;
				if(uom=='%') uom='#$';
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "ChartRecordingRemoveAddToGrpIntermediate.jsp?ChkdBoxes=false&code="+code+"&desc="+encodeURIComponent(desc,"UTF-8")+"&concTdObjValues="+encodeURIComponent(concTdObjValues,"UTF-8")+"&encounter_id="+encounterId+"&patient_id="+patient_id+"&uom="+uom, false ) ;
				xmlHttp.send( xmlDoc ) ;
				xmlStr			= "<root><SEARCH " ;
				xmlStr 			+=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				xmlHttp.open( "POST", "ChartRecordingRemoveAddToGrpIntermediate.jsp?ChkdBoxes=true&code="+code+"&desc="+encodeURIComponent(desc,"UTF-8")+"&concTdObjValues="+encodeURIComponent(concTdObjValues,"UTF-8")+"&encounter_id="+encounterId+"&patient_id="+patient_id+"&uom="+uom, false ) ;
				xmlHttp.send( xmlDoc ) ;
				}catch(err){
					alert(err.message);
				}
				parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.grpDetails.value ='';
				//IN052210 End.
			}
		}
	}else{
			index = parent.ChartRecordingDetailFrame.document.forms[0].chkGraph.value;
			index1 = parent.ChartRecordingDetailFrame.document.forms[0].chkGraph.className;
			selected_events_no +=index+"|";
			//selected_events_desc +=eval("document.forms[0].event_grp_desc_"+index1+".value")+",";
			selected_events_uom +=eval("parent.ChartRecordingDetailFrame.document.forms[0].uom_"+index1+".value")+",";
			count++;
	}

	no_of_selections = count;
	parent.ChartRecordingDetailFrame.document.forms[0].selected_events_no.value=selected_events_no;
	parent.ChartRecordingDetailFrame.document.forms[0].selected_events_desc.value=selected_events_desc;
	parent.ChartRecordingDetailFrame.document.forms[0].selected_events_uom.value=selected_events_uom;
	parent.ChartRecordingDetailFrame.document.forms[0].no_of_selections.value=no_of_selections;
	
	var allDatesForGraph = "";

	if(parent.ChartRecordingListFrame.document.forms[0] != null)
		allDatesForGraph = parent.ChartRecordingListFrame.document.forms[0].allDatesForGraph.value;

	var noOfGroups = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfGroups.value;
	var noOfChkdBoxes = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value;
	var sentFromGraph = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.sentFromGraph.value;
	var flagGraph = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.flagGraph.value;
	var numOfchkedBoxes = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value;
	
	var dialogTop		=	"90" ;
	var dialogHeight= "90vh" ;
	var dialogWidth = "80vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	/*alert("sentFromGraph="+sentFromGraph);
	alert("flagGraph="+flagGraph);
	alert("allDatesForGraph="+allDatesForGraph);
	alert("selected_events_no="+selected_events_no);
	alert("selected_events_desc="+selected_events_desc);
	alert("selected_events_uom="+selected_events_uom);
	alert("no_of_selections="+no_of_selections);
	alert("numOfchkedBoxes="+numOfchkedBoxes);
	alert("splChartType="+splChartType);
	alert("noOfGroups="+noOfGroups);
	alert("chart_id="+chart_id);
	alert("patient_id="+patient_id);
	alert("Sex="+Sex);
	alert("encounterId="+encounterId);
	alert("facility_id="+facility_id);*/
	var action_url		=	'../../eCA/jsp/ChartRecordingGroupGraphMain.jsp?sentFromGraph='+sentFromGraph+'&flagGraph='+flagGraph+'&allDatesForGraph='+allDatesForGraph+'&selected_events_no='+selected_events_no+'&selected_events_desc='+selected_events_desc+'&selected_events_uom='+selected_events_uom+'&no_of_selections='+no_of_selections+"&numOfchkedBoxes="+numOfchkedBoxes+"&splChartType="+splChartType+"&noOfGroups="+noOfGroups+"&chart_id="+chart_id+"&patient_id="+patient_id+'&Sex='+Sex+'&encounterId='+encounterId+'&facility_id='+facility_id;
	var retVal= await top.window.showModalDialog(action_url,arguments,features);		
	//document.forms[0].reset();
	if(retVal != undefined)
	{
		parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfGroups.value = retVal;
		//retVal = retVal.split("%||%");
		//openGraph(retVal[0],retVal[1],retVal[2]);
	}
/*	else if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value == 1)
	{
		openGraph(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.grpDetails.value,'1',allDatesForGraph);
	}
	else if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value == 0)
	{
		alert(getCAMessage("NO_GRAPH_SELECTED"));
		return;
	}*/
}

function retValue()
{
	//alert(groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.grpDetails.value);
	//window.returnValue = 	groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.grpCount.value;

	var temp = parent.grpButtonsFrame.document.ChartRecordingButtonsForm.forRetValue.value;
	if(temp == "O")
	{
		window.returnValue = 	groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.grpDetails.value+"%||%"+groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.grpCount.value+"%||%"+groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.allDatesForGraph.value;
	}
}

//function refreshValuesFrame()
{
	//alert(top.content.workAreaFrame.frames[2].name);
}

function addToNewGrp(i,groupNo,obj)
{
	var noOfRecs = document.chartRecordingGrpDetailsForm.noOfRecs.value;
	var checked = false;
	var grp1Val = document.chartRecordingGrpDetailsForm.grp1Val.value;
	var grp2Val = document.chartRecordingGrpDetailsForm.grp2Val.value;
	var grp3Val = document.chartRecordingGrpDetailsForm.grp3Val.value;
	var grp4Val = document.chartRecordingGrpDetailsForm.grp4Val.value;

	var grp1ValTemp = document.chartRecordingGrpDetailsForm.grp1ValTemp.value;
	var grp2ValTemp = document.chartRecordingGrpDetailsForm.grp2ValTemp.value;
	var grp3ValTemp = document.chartRecordingGrpDetailsForm.grp3ValTemp.value;
	var grp4ValTemp = document.chartRecordingGrpDetailsForm.grp4ValTemp.value;

	if(obj.checked == true)	
	{
		//document.chartRecordingGrpDetailsForm.graph.disabled = true;
		if(groupNo == "Group 1")
		{
			grp1Val = parseInt(grp1Val) + 1;
			grp1ValTemp = parseInt(grp1ValTemp) - 1;
			document.chartRecordingGrpDetailsForm.grp1Val.value = grp1Val;
			document.chartRecordingGrpDetailsForm.grp1ValTemp.value = grp1ValTemp;
		}
		else if(groupNo == "Group 2")
		{
			grp2Val = parseInt(grp2Val) + 1;
			grp2ValTemp = parseInt(grp2ValTemp) - 1;
			document.chartRecordingGrpDetailsForm.grp2Val.value = grp2Val;
			document.chartRecordingGrpDetailsForm.grp2ValTemp.value = grp2ValTemp;
		}
		else if(groupNo == "Group 3")
		{
			grp3Val = parseInt(grp3Val) + 1;
			grp3ValTemp = parseInt(grp3ValTemp) - 1;
			document.chartRecordingGrpDetailsForm.grp3Val.value = grp3Val;
			document.chartRecordingGrpDetailsForm.grp3ValTemp.value = grp3ValTemp;
		}
		else if(groupNo == "Group 4")
		{
			grp4Val = parseInt(grp4Val) + 1;
			grp4ValTemp = parseInt(grp4ValTemp) - 1;
			document.chartRecordingGrpDetailsForm.grp4Val.value = grp4Val;
			document.chartRecordingGrpDetailsForm.grp4ValTemp.value = grp4ValTemp;
		}

		if(grp1Val > 0)
			document.chartRecordingGrpDetailsForm.GroupName1.value = "Group 1";
		else
			document.chartRecordingGrpDetailsForm.GroupName1.value = "";
		if(grp2Val > 0)
			document.chartRecordingGrpDetailsForm.GroupName2.value = "Group 2";
		else
			document.chartRecordingGrpDetailsForm.GroupName2.value = "";
		if(grp3Val > 0)
			document.chartRecordingGrpDetailsForm.GroupName3.value = "Group 3";
		else
			document.chartRecordingGrpDetailsForm.GroupName3.value = "";
		if(grp4Val > 0)
			document.chartRecordingGrpDetailsForm.GroupName4.value = "Group 4";
		else
			document.chartRecordingGrpDetailsForm.GroupName4.value = "";
	}
	else
	{
		for(var i=0;i<noOfRecs;i++)
		{
			var chkObj = eval("document.chartRecordingGrpDetailsForm.chkDiscrMsr"+i);

			if(chkObj.checked == true)
			{
				checked = true;
				break;
			}
			else
				checked = false;
			
		}
		if(checked == false)
			document.chartRecordingGrpDetailsForm.graph.disabled = false;
	}
}

function showGrowthChart(obj)
{
	parent.viewsFrmId.rows = '50%,50%';
	obj.style.display = 'none';
}

function getPos(inputElement)
{
	var coords =  new Object();
	coords.x = 0;
	coords.y = 0;
	try
	{
		targetElement = inputElement;
		if(targetElement.x && targetElement.y)
		{
			coords.x = targetElement.x;
			coords.y = targetElement.y;
		}
		else
		{
			if(targetElement.offsetParent)
			{
				coords.x += targetElement.offsetLeft;
				coords.y += targetElement.offsetTop;
				while(targetElement = targetElement.offsetParent)
				{
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
				}
			}
		}
		return coords;
	}
	catch(error)
	{
		return coords;
	}
}
function displayToolTip(toolTip,obj)
{
	var tdObj = obj;
	if(toolTip != '')
	{
		tdObj.className = 'gridDataHover';
		document.getElementById("t").innerHTML = toolTip;

		var wdth 	  = tdObj.offsetWidth;
		var hght1 	  = tdObj.offsetHeight;

		var wdth1 = getPos(tdObj).x ;
		var hght = getPos(tdObj).y + hght1;

		var bodwidth  = document.body.offsetWidth
		var bodheight = document.body.offsetHeight

		var x 	  = event.x;
		var y 	  = event.y;

		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);

		/*if((wdth1+document.getElementById("tooltiplayer").offsetWidth) < document.getElementById("titleTable").offsetWidth)
		{*/
			x = wdth1;	
		/*}
		else
		{			
			x = document.getElementById("titleTable").offsetWidth - document.getElementById("tooltiplayer").offsetWidth;
		}

		if((hght+document.getElementById("tooltiplayer").offsetHeight ) < document.getElementById("titleTable").offsetHeight)
		{*/		
			y = hght;
		/*}
		else
		{
			y = document.getElementById("titleTable").offsetHeight - (document.getElementById("tooltiplayer").offsetHeight+hght1);	
		}*/
	
		document.getElementById("tooltiplayer").style.posLeft = x;
		document.getElementById("tooltiplayer").style.posTop = y;
		document.getElementById("tooltiplayer").style.visibility = 'visible';
	}
}
function hideToolTip(obj)
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
	obj.className = 'gridDataChart';
}
function callAmend(currDatime)
{
	parent.ChartRecordingDetailFrame.location.href = "../../eCommon/html/blank.html";
	//---[102]/start---
	var moduleId = parent.ChartRecordingDetailFrame.document.forms[0].module_id.value;
	var modifyYN = parent.ChartRecordingDetailFrame.document.forms[0].modifyYN.value;
	var qs = parent.ChartRecordingDetailFrame.document.forms[0].qs.value;
	//---[102]/end---
	var encounterId = parent.ChartRecordingListFrame.document.forms[0].encounter_id.value;
	var facilityID = parent.ChartRecordingListFrame.document.forms[0].facility_id.value;
	var defaultYN = parent.ChartRecordingListFrame.document.forms[0].defaultYN.value;
	var chartID = parent.ChartRecordingDetailFrame.document.forms[0].chart_id.value;
	var functionFrom = parent.ChartRecordingDetailFrame.document.forms[0].function_from.value;
	var patientId = parent.ChartRecordingListFrame.document.forms[0].patientId.value;

	//parent.ChartRecordingDetailFrame.location.href = "../../eCA/jsp/ChartRecordingAmendError.jsp?currentDate="+currDatime+"&defaultYN="+defaultYN+"&chartID="+chartID+"&encounterId="+encounterId+"&facilityID="+facilityID+"&functionFrom="+functionFrom+"&patientId="+patientId;
	//---[102]/Modified - above statment to below - included moduleID,modifyYN,qs---
	parent.ChartRecordingDetailFrame.location.href = "../../eCA/jsp/ChartRecordingAmendError.jsp?currentDate="+currDatime+"&defaultYN="+defaultYN+"&chartID="+chartID+"&encounterId="+encounterId+"&facilityID="+facilityID+"&functionFrom="+functionFrom+"&patientId="+patientId+"&moduleId="+moduleId+"&modifyYN="+modifyYN+"&qs="+qs;
	if(top.content != null)
	{
		top.content.workAreaFrame.AEID.cols = "100%,0%";
		top.content.workAreaFrame.colBarID.cols = "100%,0%";
		top.content.workAreaFrame.chartRecordingFrameSet.rows = "0%,*,5%,0%,0%,0%";
		top.content.workAreaFrame.ChartRecordingToolBarFrame.document.getElementById("errorBtn").style.display = "inline";
		//top.content.workAreaFrame.ChartRecordingToolBarFrame.document.getElementById("backToCon").value = " Back ";
		top.content.workAreaFrame.ChartRecordingToolBarFrame.document.getElementById("cancel").value = " Back ";
		top.content.workAreaFrame.ChartRecordingToolBarFrame.document.getElementById("view_graph").style.display = "none";
	}
	else
	{
		parent.AEID.cols = "100%,0%";
		parent.colBarID.cols = "100%,0%";
		parent.chartRecordingFrameSet.rows = "0%,*,5%,0%,0%,0%";
		parent.ChartRecordingToolBarFrame.document.getElementById("errorBtn").style.display = "display";
//		parent.ChartRecordingToolBarFrame.document.getElementById("backToCon").value = " Back ";
		parent.ChartRecordingToolBarFrame.document.getElementById("cancel").value = " Back ";
		parent.ChartRecordingToolBarFrame.document.getElementById("view_graph").style.display = "none";
	}
}

function enableObject(obj,i,objHid,formulaCount)
{
	i = parseInt(i,10);
	var hiddenObject = "";
	var count = document.chartRecordingAmendErrorForm.numOfRecs.value;
	var tempCountError = 0;
	var formulaString = "";
	var grpDiscrMsrId = "";
	var grpDiscrMsrIdValue = "";
	var summationFormula = "";
	var stringArray = "";
	var textObject = eval("document.chartRecordingAmendErrorForm.object"+i);
	hiddenObject = eval("document.chartRecordingAmendErrorForm.errorYN"+i);
	//hiddenObject =chartRecordingAmendErrorForm.document.getElementById("errorYN"+i);*/

	var formMember = eval("document.chartRecordingAmendErrorForm.FormulaMember"+formulaCount+"Form"+i);

	var formCount = eval("document.chartRecordingAmendErrorForm.numOfCompsForm"+formulaCount);

	grpDiscrMsrId = eval("document.chartRecordingAmendErrorForm.grpDiscrMsrIds"+i);
	grpDiscrMsrIdValue = grpDiscrMsrId.value;
	formulaString = eval("document.chartRecordingAmendErrorForm.formulaString"+grpDiscrMsrIdValue);
	//stringArray = eval("document.chartRecordingAmendErrorForm.tempStringArray"+i);
	var tempDiscrMsrVals = "";
	var tempFormulaValue = "";
	var cntofErrorObjs = document.chartRecordingAmendErrorForm.numOfRecsFormError;
	var cntOfSelObjs = document.chartRecordingAmendErrorForm.numOfSelObjects;
	var cntOfReplaceObjs = document.chartRecordingAmendErrorForm.numOfReplaceObjects;
	var objDiscrType = eval("document.chartRecordingAmendErrorForm.discrTypeHidden"+i);
	var countFormMem = 0;
	var errorFormulaMemberYN = "";
	var countNumOfFormula = 0;
	var formulaObject = "";
	var listValue = "";
	
	for(var y=0;y<parseInt(count,10);y++)
	{
		tempDiscrMsrVals = eval("document.chartRecordingAmendErrorForm.grpDiscrMsrIds"+y);
		tempFormulaValue = eval("document.chartRecordingAmendErrorForm.formulaString"+tempDiscrMsrVals.value);
		formulaObject = eval("document.chartRecordingAmendErrorForm.formulaObject"+y);
		if(tempFormulaValue.value != "")
		{
			formulaObject.value = tempFormulaValue.value;
			countNumOfFormula++;
		}
		else
		{
			formulaObject.value = "";
		}
	}

	//alert("countNumOfFormula"+countNumOfFormula);
	
	for(var t=0;t<parseInt(count,10);t++)
	{
		formulaObject = eval("document.chartRecordingAmendErrorForm.formulaObject"+t);
		//alert(formulaObject.value);
		if(formulaObject.value != "")
		{
			countFormMem = 0;
			for(var x=0;x<parseInt(count,10);x++)
			{
				stringArray = eval("document.chartRecordingAmendErrorForm.tempStringArray"+x);
				if(formulaObject.value.indexOf(stringArray.value) != -1)
				{
					errorFormulaMemberYN = eval("document.forms[0].errorFormulaMemberYN"+x);
					errorFormulaMemberYN.value = "Y";
					countFormMem = parseInt(countFormMem,10)+1;
				}
			}
		}
	}

	//alert("countFormMem"+countFormMem);
	if(formCount != null)
	{
		countFormMem = formCount.value;
	}
	else
	{
		countFormMem = countFormMem;
	}

	//alert(countFormMem);
	if(obj.value == "R")
	{
		textObject.style.display = "inline";
		hiddenObject.value = "R";
		document.getElementById("newValID").style.display = "inline";
		if(objDiscrType.value == "L")
		{
			/*listValue = (eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value);
			if(listValue == "0")
			{
				textObject.options
			}*/

		
			if((eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value) != '')
			{
				textObject.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value);	
			}
			else
			{
				//commented by Deepa on 12/4/2008 3:47 PM for 7014 (SCF # SRR20056-SCF-2579)
				//textObject.options(textObject.selectedIndex).text = (eval("document.chartRecordingAmendErrorForm.prevDisplayStringValue"+i).value);
			}
			//alert(textObject.options(textObject.selectedIndex).text);
			

		}
		else
		{
			textObject.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayStringValue"+i).value);
			eval("document.forms[0].displayStringValue"+i).value = (eval("document.forms[0].prevDisplayStringValue"+i).value);
		}
		if(objDiscrType.value == "N" || objDiscrType.value == "I" || objDiscrType.value == "L")
		{		
			textObject.onchange();
			textObject.onblur();
		}
		for(var t=0;t<parseInt(count,10);t++)
		{
			formulaObject = eval("document.chartRecordingAmendErrorForm.formulaObject"+t);
			if(formulaObject.value != "")
			{
				stringArray = eval("document.chartRecordingAmendErrorForm.tempStringArray"+i);
				if(formulaObject.value.indexOf(stringArray.value) != -1)
				{
					cntOfReplaceObjs.value = parseInt(cntOfReplaceObjs.value,10) + 1; 

					if(cntofErrorObjs.value > 0)
					{
						cntofErrorObjs.value = parseInt(cntofErrorObjs.value,10) - 1;

					}
				}
				
			}
		}
		if(tempCountError > 0)
		{
			tempCountError--;
		}
	}
	else if(obj.value == "E")
	{	
		for(var t=0;t<parseInt(count,10);t++)
		{
			formulaObject = eval("document.chartRecordingAmendErrorForm.formulaObject"+t);
			if(formulaObject.value != "")
			{
				stringArray = eval("document.chartRecordingAmendErrorForm.tempStringArray"+i);
				if(formulaObject.value.indexOf(stringArray.value) != -1)
				{
					cntofErrorObjs.value = parseInt(cntofErrorObjs.value,10) + 1;
				}
				if(cntOfReplaceObjs.value > 0)
				{
					cntOfReplaceObjs.value = parseInt(cntOfReplaceObjs.value,10) - 1;
				}
				
			}
			
		}

		textObject.style.display = "none";
		hiddenObject.value = "E";
		textObject.value = "";
		if(objDiscrType.value == "N" || objDiscrType.value == "I" || objDiscrType.value == "L")
		{		
			textObject.onchange();
			textObject.onblur();
		}
		tempCountError++;
		
	}
	else if(obj.value == "")
	{		
		for(var t=0;t<parseInt(count,10);t++)
		{
			formulaObject = eval("document.chartRecordingAmendErrorForm.formulaObject"+t);
			if(formulaObject.value != "")
			{
				stringArray = eval("document.chartRecordingAmendErrorForm.tempStringArray"+i);
				if(formulaObject.value.indexOf(stringArray.value) != -1)
				{
					if(cntofErrorObjs.value > 0)
					{
						cntofErrorObjs.value = parseInt(cntofErrorObjs.value,10) - 1;
					}
					if(cntOfReplaceObjs.value > 0)
					{
						cntOfReplaceObjs.value = parseInt(cntOfReplaceObjs.value,10) - 1;
					}

					cntOfSelObjs.value = parseInt(cntOfSelObjs.value,10) + 1;
				}
			}
			
		}

		textObject.style.display = "none";
		if(objDiscrType.value == "L")
		{
			//textObject.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value);			
			if((eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value) != '')
			{
				textObject.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value);	
			}
			else
			{
				textObject.options(textObject.selectedIndex).text = (eval("document.chartRecordingAmendErrorForm.prevDisplayStringValue"+i).value); 
			}
		}
		else
		{
			textObject.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayStringValue"+i).value);
			eval("document.forms[0].displayStringValue"+i).value = (eval("document.forms[0].prevDisplayStringValue"+i).value);
		}
		//textObject.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayStringValue"+i).value);
		hiddenObject.value = "";
		if(objDiscrType.value == "N" || objDiscrType.value == "I" || objDiscrType.value == "L")
		{		
			textObject.onchange();
			textObject.onblur();
		}
		if(tempCountError > 0)
		{
			tempCountError--;
		}
	}

	var tempObj = "";
	var objectText = "";
	var objectErrAmend = "";
	var tempTextObj = "";

	if(cntofErrorObjs.value == countFormMem)
	{
		//alert(1);
		for(var ii=0;ii<parseInt(count,10);ii++)
		{
			objectErrAmend = eval("document.chartRecordingAmendErrorForm.selectObject"+ii);
			tempObj = eval("document.chartRecordingAmendErrorForm.grpDiscrMsrIds"+ii);
			objectText = eval("document.chartRecordingAmendErrorForm.formulaObjectName"+tempObj.value);
			if(objectText != null)
			{
				objectErrAmend.value = "E";
				objectText.style.display = "none";
			}
		}		
	}
	else if(cntofErrorObjs.value != countFormMem && cntofErrorObjs.value != 0)
	{
		//alert(2);
		for(var ii=0;ii<parseInt(count,10);ii++)
		{
			objectErrAmend = eval("document.chartRecordingAmendErrorForm.selectObject"+ii);
			tempObj = eval("document.chartRecordingAmendErrorForm.grpDiscrMsrIds"+ii);
			objectText = eval("document.chartRecordingAmendErrorForm.formulaObjectName"+tempObj.value);
			if(objectText != null)
			{
				objectErrAmend.value = "R";
				objectText.style.display = "none";				
			}			
		}

		/*if(cntOfReplaceObjs.value > 0)
		{
			textObject.style.display = "inline";
			hiddenObject.value = "R";			
		}
		else*/
		{
			textObject.style.display = "none";
			hiddenObject.value = "E";
			textObject.value = "";		
		}
		if(objDiscrType.value == "N" || objDiscrType.value == "I" || objDiscrType.value == "L")
		{		
			textObject.onchange();
			textObject.onblur();
		}
	}
	else if(cntOfSelObjs.value == countFormMem)
	{
		//alert(3);
		for(var ii=0;ii<parseInt(count,10);ii++)
		{
			objectErrAmend = eval("document.chartRecordingAmendErrorForm.selectObject"+ii);
			tempObj = eval("document.chartRecordingAmendErrorForm.grpDiscrMsrIds"+ii);
			objectText = eval("document.chartRecordingAmendErrorForm.formulaObjectName"+tempObj.value);
			if(objectText != null)
			{
				objectErrAmend.value = "";
				objectText.style.display = "none";
			}
		}
		cntOfSelObjs.value = 0;
	}
	//else if(cntofErrorObjs.value != countFormMem && cntOfSelObjs.value != countFormMem)
	else if(cntofErrorObjs.value == 0 && cntOfSelObjs.value == 1)
	{
		
	}
	
	if(cntofErrorObjs.value <= 0 && cntOfSelObjs.value == 1 && cntOfReplaceObjs.value == 0)
	{
		for(var ii=0;ii<parseInt(count,10);ii++)
		{
			objectErrAmend = eval("document.chartRecordingAmendErrorForm.selectObject"+ii);
			tempObj = eval("document.chartRecordingAmendErrorForm.grpDiscrMsrIds"+ii);
			objectText = eval("document.chartRecordingAmendErrorForm.formulaObjectName"+tempObj.value);
			if(objectText != null)
			{
				objectErrAmend.value = "";
				objectText.style.display = "none";
			}
		}
		cntOfSelObjs.value = 0;
	}
	else if(cntofErrorObjs.value == 1 && cntOfSelObjs.value == 0 && cntOfReplaceObjs.value == 0)
	{
		textObject.style.display = "none";
		textObject.value = "";
		if(objDiscrType.value == "N" || objDiscrType.value == "I" || objDiscrType.value == "L")
		{		
			textObject.onchange();
			textObject.onblur();
		}
		cntOfSelObjs.value = 0;
		cntOfReplaceObjs.value = 0;
	}
	
	else if(cntofErrorObjs.value == 0 && cntOfSelObjs.value == 0 && cntOfReplaceObjs.value == 1)
	{
		textObject.style.display = "inline";
		if(objDiscrType.value == "L")
		{
			//textObject.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value);	
			if((eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value) != '')
			{
				textObject.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value);	
			}
			else
			{
				textObject.options(textObject.selectedIndex).text = (eval("document.chartRecordingAmendErrorForm.prevDisplayStringValue"+i).value);	 
			}
		}
		else
		{
			textObject.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayStringValue"+i).value);
			eval("document.forms[0].displayStringValue"+i).value = (eval("document.forms[0].prevDisplayStringValue"+i).value);
		}
		if(objDiscrType.value == "N" || objDiscrType.value == "I" || objDiscrType.value == "L")
		{		
			textObject.onchange();
			textObject.onblur();
		}
		cntOfSelObjs.value = 0;
		cntofErrorObjs.value = 0;
	}


	var cntForDisp = 0;
	for(var yy=0;yy<parseInt(count,10);yy++)
	{
		var selObj = eval("document.forms[0].selectObject"+yy);
		if(selObj.value == "E" || selObj.value == "")
		{
			cntForDisp = parseInt(cntForDisp,10) +1;
		}
	}
	if(cntForDisp == count)
	{
		document.getElementById("newValID").style.display = "none";
	}
	else
	{
		document.getElementById("newValID").style.display = "inline";
	}

	if(tempCountError >= count)
	{
		document.chartRecordingAmendErrorForm.allError.checked = true;
	}
	else
	{
		document.chartRecordingAmendErrorForm.allError.checked = false;
	}
	

}//end of function enableObject

function markAllError(object)
{
	var cntofErrorObjs = document.chartRecordingAmendErrorForm.numOfRecsFormError;
	var cntOfSelObjs = document.chartRecordingAmendErrorForm.numOfSelObjects;
	var cntOfReplaceObjs = document.chartRecordingAmendErrorForm.numOfReplaceObjects;
	var discrTypeHidden = "";
	cntofErrorObjs.value = 0;
	cntOfSelObjs.value = 0;
	cntOfReplaceObjs.value = 0;
	var cnt = document.chartRecordingAmendErrorForm.numOfRecs.value;
	var selObj = "";
	var selHiddenObj = "";
	var i = 0;
	var obj = "";
	var formObj = "";
	if(object.checked == true)
	{
		for(i=0;i<parseInt(cnt,10);i++)
		{
			selObj = eval(document.getElementById("selectObject"+i));
			selHiddenObj = eval(document.getElementById("hidErrYN"+i));
			selObj.value = 'E';
			//selObj.disabled = true;
			selHiddenObj.value = 'E';
			obj = eval(document.getElementById("object"+i));
			formObj = eval(document.getElementById("formObject"+i));
			if(obj != null || obj != undefined)
			{
				obj.style.display = "none";
				obj.value = "";
			}
			if(formObj != null || formObj != undefined)
			{
				formObj.style.display = "none";
				formObj.value = "";
			}
		}
		document.getElementById("newValID").style.display = "none";
		//document.forms[0].numOfRecsFormError.value = parseInt(cnt,10);
	}
	else
	{
		var cntForDisp = 0;
		for(i=0;i<parseInt(cnt,10);i++)
		{
			selObj = eval(document.getElementById("selectObject"+i));
			selHiddenObj = eval(document.getElementById("hidErrYN"+i));
			//discrTypeHidden = eval("document.chartRecordingAmendErrorForm.discrTypeHidden"+i);
			selObj.value = '';
			/*if(discrTypeHidden.value != "A")
			{
				selObj.disabled = false;
			}
			else
			{
				selObj.disabled = true;
			}*/
			selHiddenObj.value = '';
			obj = eval(document.getElementById("object"+i));
			formObj = eval(document.getElementById("formObject"+i));
			if(obj != null || obj != undefined)
			{
				obj.style.display = "none";
				obj.value = "";
			}
			if(formObj != null || formObj != undefined)
			{
				formObj.style.display = "none";
				formObj.value = "";
			}
		}
		document.getElementById("newValID").style.display = "none";
		//document.forms[0].numOfRecsFormError.value = 0;
	}
}

function remarksToAll(obj)
{
	var cnt = document.chartRecordingAmendErrorForm.numOfRecs.value;
	var selObj = "";
	var i = 0;
	if(obj.text != "")
	{
		for(i=0;i<parseInt(cnt,10);i++)
		{
			//IN037946 - Start
			if(eval(document.getElementById("discrTypeHidden"+i)).value == 'A')
			{
				selObj = eval(document.getElementById("errorRem"+i));
				if(obj.value != "")
					selObj.value = "";
				else
					selObj.value = obj.value;
			} //IN037946 - End
			else
			{
				selObj = eval(document.getElementById("errorRem"+i));
				selObj.value = obj.value;
			}
		}
	}
}

async function showErrosOnClick()
{
	if(parent.ChartRecordingToolBarFrame.document.forms[0]!=null){
	var chartID = parent.ChartRecordingToolBarFrame.document.forms[0].chartId.value;
	//var recDateTime = parent.ChartRecordingDetailFrame.document.chartRecordingAmendErrorForm.recordedDatime.value;
	var encounterId = parent.ChartRecordingToolBarFrame.document.forms[0].encounter_id.value;
	var dialogTop		=	"80" ;
	var dialogHeight= "84vh" ;
    var dialogWidth = "50vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/ChartRecordingViewErrorsMain.jsp?chartID='+chartID+'&encounterId='+encounterId;
	var retVal=await top.window.showModalDialog(action_url,arguments,features);		
	}


}

function displayFormulaForError(summationFormula,t,formulaCount)
{	
	//alert("here 1");
	//alert(summationFormula);
	var count = document.chartRecordingAmendErrorForm.numOfRecs.value;
	//var summationFormula = eval("document.chartRecordingAmendErrorForm.evaluatedForm"+formulaCount);
	//alert(formulaCount);
	//alert(eval(summationFormula.value));

	var stringArray = "";
	var tempString = "";
	var tempDiscrMsrVals = "";
	var tempFormulaValue = "";

	var tempObj = "";
	var tempFormulaObj = "";
	var tempConstructedFormulaObj = "";
	var countString = 0;

	var objDiscrType = "";
	var objectText = "";
	var objectErrAmend = "";
	var errorYN = "";
	var listStringValue = "";
	var custHiddenVal = "";
	var number = 0;

	for(var y=0;y<parseInt(count,10);y++)
	{
		tempDiscrMsrVals = eval("document.chartRecordingAmendErrorForm.grpDiscrMsrIds"+y);
		stringArray = eval("document.chartRecordingAmendErrorForm.tempStringArray"+t);
		tempFormulaValue = eval("document.chartRecordingAmendErrorForm.formulaString"+tempDiscrMsrVals.value);
		if(tempFormulaValue != null && tempFormulaValue.value != undefined)
		{
			if(tempFormulaValue.value.indexOf(stringArray.value) != -1)
			{
				countString++;
			}
		}
	}

	if(countString > 0)
	{
		for(var i=0;i<parseInt(count,10);i++)
		{
			objDiscrType = eval("document.chartRecordingAmendErrorForm.discrTypeHidden"+i);
			objectTextTemp = eval("document.chartRecordingAmendErrorForm.object"+i);

			if(objDiscrType.value == "L")
			{
				listStringValue = eval("document.chartRecordingAmendErrorForm.listStringValue"+i);
				//objectTextTemp.value = (eval("document.chartRecordingAmendErrorForm.prevDisplayNumValue"+i).value);
			}

			objectErrAmend = eval("document.chartRecordingAmendErrorForm.selectObject"+i);
			errorYN = eval("document.chartRecordingAmendErrorForm.errorYN"+i);
			tempObj = eval("document.chartRecordingAmendErrorForm.grpDiscrMsrIds"+i);
			objectText = eval("document.chartRecordingAmendErrorForm.formulaObjectName"+tempObj.value);
			tempFormulaObj = eval("document.chartRecordingAmendErrorForm.formulaString"+tempObj.value);
			tempConstructedFormulaObj = eval('document.chartRecordingAmendErrorForm.constructedFormula'+tempObj.value);
			//alert("tempFormulaObj =="+tempFormulaObj.value+"===");
			//alert('tempConstructedFormulaObj =='+eval(tempConstructedFormulaObj.value)+'===');
			if(tempConstructedFormulaObj.value != "" && objectText != null)
			{		
				objectText.style.display = "inline";
				if(summationFormula != "Infinity")
				{
					objectErrAmend.value = "R";
					//objectText.value = eval(tempConstructedFormulaObj.value);
					number = parseFloat(eval(tempConstructedFormulaObj.value));
					//number = eval(tempConstructedFormulaObj.value);
					number = number * 1000
					number = Math.round(number);
					number = number /1000;
					objectText.value = number;
					custHiddenVal = eval("document.chartRecordingAmendErrorForm.custom_"+tempObj.value);
					if(custHiddenVal != null && custHiddenVal != undefined)
					{
						custHiddenVal.value = objectText.value;
					}
				}
				else
				{
					objectText.value = '';
				}
			}			
		}
	}
}

function allowValidNumberLocal(fld, e, maxInt, deci)
{
	
	var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}

	if(count<maxInt)
	{
		var dotOccurance = fld.value.indexOf('.');

		if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
		{
			if(whichCode!=46)
			{
			   fld.value = fld.value+".";
				return false;
			}
		}
	}

	var dotOccurance = fld.value.indexOf('.');

	if(dotOccurance != -1)
	{
	    var count=fld.value.length;
		if(count > deci)
			return false;
	}
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789';

//	alert(e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
   // if (whichCode == 13) return true;  // Enter 
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

function allowValidNumberLocal2(fld, e, maxInt, deci)
{

    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	var minusOccurance = fld.value.indexOf('-');
	var plusOccurance = fld.value.indexOf('+');
	if(minusOccurance != -1 || plusOccurance != -1)
	{
		maxInt++;
		fld.setAttribute("maxLength",maxInt);
	}
	else
	{
		fld.setAttribute("maxLength",maxInt);
	}
	if((whichCode == 45 && count>0) || (whichCode == 43 && count>0))
	{
		return false
	}

    if(count >= maxInt)
    {
        /*if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                    //alert("APP-0001 Reached Maximum Integer value");
                    //return false;
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            //alert(objectValue.charAt(maxInt));
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }*/
		return false;
    }
	
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789-+';

//	alert(e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-+';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
  // if (whichCode == 13) return true;  // Enter     commented by Channaveer B
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
	var count = 0;
    if(dotIndex!=-1){
       /* if( fldLength > (parseInt(dotIndex)+parseInt(deci)) )
			return false;*/
	}


	key = String.fromCharCode(whichCode);  // Get key value from key code
  
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if((key == "-" && fldValue.indexOf(key) != -1) || (key == "+" && fldValue.indexOf(key) != -1) )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}
//....ADDED BY Channaveer B For IN19301----
function allowValidNumberLocal3(fld,e){
	var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	//var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return false; 
	 else return true;
}
function valForSort(object)
{
	document.ChartLayoutCriteriaForm.sortValue.value = object.value;
	//top.content.messageFrame.location.href="../../eCA/jsp/ChartRecordingRemoveObjects.jsp";
}


async function selectPractName()
{
	var target = document.chartRecordingAmendErrorForm.markedErrorBy;
	var retVal = new String();
	var dialogTop = "40";
	var dialogHeight = "30";
	var dialogWidth = "40";
	var features = "dialogTop:"+dialogTop+"dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";status=no;";
	var arguments = "";
	var search_code = "";
	var search_desc = "";
	var title = getLabel("eCA.ErrorMarkedBy.label","CA");
	var locale =document.forms[0].locale.value;
	//var sql = " select APPL_USER_ID, APPL_USER_NAME from SM_APPL_USER where EFF_STATUS=`E` and FUNC_ROLE_ID is not null ";
	var sql = "select 	APPL_USER_ID, APPL_USER_NAME from 	SM_APPL_USER_LANG_VW where 	EFF_STATUS=`E`  AND LANGUAGE_ID = `"+locale+"`	and 	FUNC_ROLE_ID is not null";
	search_code = 'APPL_USER_ID';
	search_desc = 'APPL_USER_NAME';
	var pract = document.chartRecordingAmendErrorForm.markedErrorBy.value;
	retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&pract="+pract+ "&search_code="+search_code+"&title="+encodeURIComponent(title,"UTF-8")+"&search_desc="+search_desc+"&dispDescFirst=dispDescFirst",arguments,features);
	var ch_arr = new Array();
	if(retVal!=null && retVal!=''){
		var retVal = unescape(retVal);
		ch_arr = retVal.split("::");
		document.chartRecordingAmendErrorForm.markedErrorBy.value = ch_arr[0];
		document.chartRecordingAmendErrorForm.userIDHidden.value = ch_arr[1];		
	}
}

function loadPrevNextTen(obj)
{
	var sort_by = parent.ChartRecordingListFrame.document.ChartLayoutListForm.sort_by.value;
	var datesForArray = parent.ChartRecordingListFrame.document.forms[0].datesForArray.value;
	var datesForPrevNext = parent.ChartRecordingListFrame.document.forms[0].datesForPrevNext.value;

	var numOfPages = parent.ChartRecordingListFrame.document.forms[0].numOfPages.value;
	var tempCountOfRecs = parent.ChartRecordingListFrame.document.forms[0].tempCountOfRecs.value;

	var numOfDates = parent.ChartRecordingListFrame.document.forms[0].numOfDates.value;
	var fromDate = parent.ChartRecordingListFrame.document.ChartLayoutListForm.fromDate.value;
	var toDate = parent.ChartRecordingListFrame.document.ChartLayoutListForm.toDate.value;
	var prevFirstDate = parent.ChartRecordingListFrame.document.ChartLayoutListForm.prevFirstDate.value;
	var constFromDate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.fromDate.value;
	var constToDate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.toDate.value;
	var detailDate = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.detailDate.value;
	var pageNo = parent.ChartRecordingListFrame.document.ChartLayoutListForm.pageNo.value;
	
	var tempPrevDatArray = new Array();

	tempPrevDatArray = prevFirstDate.split("~");

	var newToDate = "";
	var newFromDate = "";
	var flagFromNext = "";
	var flagFromPrev = "";
	
	var curidxval	= eval(parent.ChartRecordingControlsFrame.document.forms[0].cur_idx_value.value);
	var totalidx	= eval(parent.ChartRecordingControlsFrame.document.forms[0].idx_value.value);

	if(obj.id == 'nextTenRecs')
	{
		/*flagFromNext = "flagFromNext";
		flagFromPrev = "";
		if(sort_by == 'D')
		{
			newToDate = datesForArray;
			newFromDate = constFromDate;
		}
		else if(sort_by == 'A')
		{
			newFromDate = datesForArray;
			newToDate = constToDate;
		}
		tempCountOfRecs = parseInt(tempCountOfRecs,10)+1;
		pageNo = parseInt(pageNo,10)+1; */

		if(curidxval < totalidx)
		{
			curidxval++;
			uptoidxval = curidxval+1;
		
			if(uptoidxval > totalidx)
				uptoidxval = curidxval;
		}
	}
	else if(obj.id == 'prevTenRecs')
	{
		/*if(sort_by == 'D')
		{
			newFromDate = parent.ChartRecordingListFrame.document.ChartLayoutListForm.toDate.value;
			newToDate = tempPrevDatArray[parseInt(tempCountOfRecs,10)-1];
		}
		else
		{
			newFromDate = tempPrevDatArray[parseInt(tempCountOfRecs,10)-1];
			newToDate = parent.ChartRecordingListFrame.document.ChartLayoutListForm.toDate.value;
		}
		flagFromNext = "";
		flagFromPrev = "flagFromPrev";
		tempCountOfRecs = parseInt(tempCountOfRecs,10)-1;
		pageNo = parseInt(pageNo,10)-1;*/

		if(curidxval > 0)
		{
			curidxval--;
			uptoidxval = eval(curidxval)+1;
			
			if(uptoidxval < 0)
				uptoidxval = 0;
		}
	}
	else if(obj.id == 'first')
	{
		curidxval = 0;
		uptoidxval = eval(curidxval)+1;
	}
	else if(obj.id == 'last')
	{
		curidxval = totalidx - 1;
		uptoidxval = totalidx;
		
	}

	var displstart	= eval(curidxval) + 1;
	var displend	= eval(totalidx); 

	parent.ChartRecordingControlsFrame.document.getElementById("labelCaption").innerText = "Page "+ displstart + " of " + displend;
	parent.ChartRecordingControlsFrame.document.forms[0].cur_idx_value.value = curidxval;

	//Added by Jyothi.G to fix IN024667 on 15/11/2010
	if(curidxval == 0)
	{
		parent.ChartRecordingControlsFrame.document.forms[0].prevTenRecs.disabled = true;
		parent.ChartRecordingControlsFrame.document.forms[0].first.disabled = true;
	}
	else if(curidxval > 0)
	{
		parent.ChartRecordingControlsFrame.document.forms[0].prevTenRecs.disabled = false;
		parent.ChartRecordingControlsFrame.document.forms[0].first.disabled = false;
	}

	if((curidxval+1) >= totalidx)
	{
		parent.ChartRecordingControlsFrame.document.forms[0].nextTenRecs.disabled = true;
		parent.ChartRecordingControlsFrame.document.forms[0].last.disabled = true;
	}
	else 
	{
		parent.ChartRecordingControlsFrame.document.forms[0].nextTenRecs.disabled = false;
		parent.ChartRecordingControlsFrame.document.forms[0].last.disabled = false;
	}

	var firstDateTime;
	var lastDateTime;

	if(sort_by == "A")
	{
		firstDateTime	= dtArr[curidxval]
		lastDateTime	= dtArr[uptoidxval]
	}
	else if (sort_by == "D")
	{
		firstDateTime	= dtArr[uptoidxval]
		lastDateTime	= dtArr[curidxval]
	}

	var encounterId = parent.ChartRecordingListFrame.document.ChartLayoutListForm.encounterId.value;
	var function_from = parent.ChartRecordingListFrame.document.ChartLayoutListForm.function_from.value;
	var detailDate = parent.ChartRecordingListFrame.document.ChartLayoutListForm.detailDate.value;
	var errorAuth = parent.ChartRecordingListFrame.document.ChartLayoutListForm.errorAuth.value;
	var flagValue = parent.ChartRecordingListFrame.document.ChartLayoutListForm.flagValue.value;	
	var flagString = parent.ChartRecordingListFrame.document.ChartLayoutListForm.flagString.value;
	var adm_date = parent.ChartRecordingListFrame.document.ChartLayoutListForm.adm_date.value;
	var noOfDays = parent.ChartRecordingListFrame.document.ChartLayoutListForm.noOfDays.value;
	var daySummary = parent.ChartRecordingListFrame.document.ChartLayoutListForm.daySummary.value;
	var summaryYN = parent.ChartRecordingListFrame.document.ChartLayoutListForm.summaryYN.value;
	var detailYN = parent.ChartRecordingListFrame.document.ChartLayoutListForm.detailYN.value;
	var from = parent.ChartRecordingListFrame.document.ChartLayoutListForm.from.value;
	var to = parent.ChartRecordingListFrame.document.ChartLayoutListForm.to.value;
	var patientId = parent.ChartRecordingListFrame.document.ChartLayoutListForm.patientId.value;
	var chartId = parent.ChartRecordingListFrame.document.ChartLayoutListForm.chartId.value;
	toDate = newToDate;
	fromDate = newFromDate;
	var defaultYN = parent.ChartRecordingListFrame.document.ChartLayoutListForm.defaultYN.value;
	var modifyYN = parent.ChartRecordingListFrame.document.ChartLayoutListForm.modifyYN.value;
	
	parent.ChartRecordingListFrame.location.href = '../../eCA/jsp/ChartRecordingListPopulation.jsp?episode_id='+encounterId+'&function_from='+function_from+'&detailDate='+detailDate+'&errorAuth='+errorAuth+'&flagValue=&sort_by='+sort_by+'&flagString='+flagString+'&visit_adm_date='+adm_date+'&noOfDays='+noOfDays+'&summaryText='+daySummary+'&summaryYN='+summaryYN+'&detailYN='+detailYN+'&start='+from+'&end='+to+'&patient_id='+patientId+'&chartId='+chartId+'&fromDate='+firstDateTime+'&toDate='+lastDateTime+'&DEFINE_MODIFIABLE_AT_TRN_YN='+defaultYN+"&datesForArray="+datesForArray+'&flagFromNext='+flagFromNext+'&flagFromPrev='+flagFromPrev+'&prevNextTen=prevNextTen&numOfDates='+numOfDates+'&datesForPrevNext='+datesForPrevNext+'&tempCountOfRecs='+tempCountOfRecs+'&numOfPages='+numOfPages+"&prevFirstDate="+prevFirstDate+"&pageNo="+pageNo+"&modifyYN="+modifyYN+"&detailDate="+detailDate;
	
}

async function openWiinForRecording()
{
	var splChartType = document.forms[0].splChartType.value;
	var patient_id = document.forms[0].patient_id.value;
	var chart_id = document.forms[0].chart_id.value;
	var dialogTop		=	"80" ;	
	var dialogHeight= "90vh" ;
    var dialogWidth = "80vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/ChartRecordingSplChtRecordDetailsMain.jsp?splChartType='+splChartType+'&chart_id='+chart_id+'&patient_id='+patient_id;
	var retval = await window.showModalDialog(action_url,arguments,features);
}

function loadKeyValPage(obj)
{
	var chart_id = document.forms[0].chart_id.value;
	var patient_id = document.forms[0].patient_id.value;
	var splChtType = document.forms[0].splChtType.value;
	var splChtGrpId = obj.value;

	
	if(splChtGrpId != '')
	{
		parent.chartRecordingEntryFrame.location.href = '../../eCA/jsp/ChartRecordingSplChtDtlEntry.jsp?chart_id='+chart_id+'&patient_id='+patient_id+'&splChtType='+splChtType+'&splChtGrpId='+splChtGrpId;
		parent.chartRecordingSplChtBtnFrame.location.href= '../../eCA/jsp/ChartRecordingSplChtDtlBtn.jsp';
	}
	else
	{
		parent.chartRecordingEntryFrame.location.href = '../../eCA/jsp/blank.jsp';
		parent.chartRecordingSplChtBtnFrame.location.href= '../../eCA/jsp/blank.jsp';
	}
}

function alignKeyValHdg()
{
	var rowsLength = document.getElementById("valuesTab").rows.length;
	var colsLength = document.getElementById("tdHeadingTab").rows[0].cells.length;

	for(var i=0;i<parseInt(colsLength,10);i++)
	{
		document.getElementById("tdHeadingTab").rows[0].cells[i].width = (100/parseInt(colsLength,10)) + "%";
	}

	for(var i=0;i<parseInt(rowsLength,10);i++)
	{
		for(var j=0;j<parseInt(colsLength,10);j++)
		{
			document.getElementById("valuesTab").rows[i].cells[j].width = eval(document.getElementById("tdHeadingTab").rows[0].cells[j].offsetWidth) ;
		}
	}

	if(rowsLength != 0)
	{
		rowsLength = parseInt(rowsLength,10) - 1;

		for(var i=0;i<parseInt(colsLength,10);i++)
		{
			document.getElementById("tdHeadingTab").rows[0].cells[i].width = eval(document.getElementById("valuesTab").rows[rowsLength].cells[i].offsetWidth);
		}
	}
}

function validateNums(obj,minNums,maxNums,decNums)
{

	if(eval(minNums) != 0 && obj.value.length != 0) 
	{
		if(obj.value.length < eval(minNums))  
		{
			alert(getMessage("MINIMUM_DIGITS","CA")+minNums);
			obj.focus();
		}
	}

	if((obj.value.indexOf(".")) >= 0)
	{
		if(decNums !=0 )  {
			var arr =  new Array();
			arr = obj.value.split(".");
			var num = arr[0].length;
			var frac = arr[1].length;

			if (frac > decNums ){
			alert(getMessage("INVALID_PRECISION","CA"));
			obj.focus();
			}

			if(num > maxNums)
			{
				alert(getMessage("INVALID_PRECISION","CA"));
				obj.focus();
			}
		}
		else
		{
			alert(getMessage("NO_DECIMAL","CA"));
			obj.focus();
		}
	}
	else
	{
		if(obj.value.length > eval(maxNums))
		{
			alert(getMessage("INVALID_PRECISION","CA"));
			obj.focus();
		}
	}
}

function returnNumOfGroups()
{
	if(parent.viewsFrame.splChtStandardViewFrame.groupNamesAndDetailsFrame != null)
		window.returnValue = parent.viewsFrame.splChtStandardViewFrame.groupNamesAndDetailsFrame.document.chartRecordingGrpDetailsForm.grpCount.value
}

/*function loadSplGraphs(graphDesc,xAxisElementType,yAxisElementType,splChartType,splChtGrp)
{
	var patient_id = document.splChartLinksForm.patient_id.value;
	var facility_id = document.splChartLinksForm.facility_id.value;
	var encounterId = document.splChartLinksForm.encounterId.value;
	var chart_id = document.splChartLinksForm.chart_id.value;
	var Sex = document.splChartLinksForm.Sex.value;
	//parent.specialChartGraphFrame.location.href = "../../eCA/jsp/TestJFreeChart.jsp?graphDesc="+graphDesc+"&xAxisElementType="+xAxisElementType+"&yAxisElementType="+yAxisElementType+"&splChartType="+splChartType;
	parent.parent.graphDisplayFrame.location.href = "../../eCA/jsp/ChartRecordingSplChtDisplayGraph.jsp?graphDesc="+graphDesc+"&xAxisElementType="+xAxisElementType+"&yAxisElementType="+yAxisElementType+"&splChartType="+splChartType+"&chart_id="+chart_id+"&patient_id="+patient_id+"&Sex="+Sex+"&splChtGrp="+splChtGrp+"&encounterId="+encounterId+"&facility_id="+facility_id;
}*/

function loadSplGraphs()
{
	if(document.splChartLinksForm.splChrt !=undefined){
	var index = document.splChartLinksForm.index.value;
	var graphDesc = eval("document.splChartLinksForm.graphDesc"+index).value;
	var xAxisElementType = eval("document.splChartLinksForm.xAxisElementType"+index).value;
	var yAxisElementType = eval("document.splChartLinksForm.yAxisElementType"+index).value;
	var splChartType = eval("document.splChartLinksForm.splChartType"+index).value;
	var splChtGrp = eval("document.splChartLinksForm.splChartTypeGrpId"+index).value;
	var patient_id = document.splChartLinksForm.patient_id.value;
	var facility_id = document.splChartLinksForm.facility_id.value;
	var encounterId = document.splChartLinksForm.encounterId.value;
	var chart_id = document.splChartLinksForm.chart_id.value;
	var Sex = document.splChartLinksForm.Sex.value;
	parent.parent.graphDisplayFrame.location.href = "../../eCA/jsp/ChartRecordingSplChtDisplayGraph.jsp?graphDesc="+graphDesc+"&xAxisElementType="+xAxisElementType+"&yAxisElementType="+yAxisElementType+"&splChartType="+splChartType+"&chart_id="+chart_id+"&patient_id="+patient_id+"&Sex="+Sex+"&splChtGrp="+splChtGrp+"&encounterId="+encounterId+"&facility_id="+facility_id;
	}
	else
		alert(getMessage("NO_GRAPH_AVAILABLE","CA"));
}

function setIndex(obj)
{
	if(obj.checked == true)
		document.splChartLinksForm.index.value = obj.value;
	else
		document.splChartLinksForm.index.value = '';
}

function tab_click(eventName)
{
	var qryStr = document.forms[0].qryStr.value;
	var noOfGroups = document.forms[0].noOfGroups.value;
	
	if(eventName == "grouping")
	{
		parent.groupGraphDisplayFrame.cols = "*,0%";	
		parent.groupsUserInputFrame.rows = "*,0%";	
	//	parent.graphDisplayFrame.location.href = '../../eCA/jsp/ChartRecordingGraphFrameMain.jsp?'+qryStr;
		parent.groupDisplayFrame.location.href = '../../eCA/jsp/ChartRecordingGroupsFrame.jsp?'+qryStr;	
		if(parent.closeGroupFrame.document.groupCloseForm.grpButtonOK != null)
		{
			parent.closeGroupFrame.document.groupCloseForm.grpButtonOK.style.display = "inline";
		}
	}
	else if(eventName == "splChart")
	{
		parent.groupsUserInputFrame.rows='87%,13%';
		parent.groupDisplayFrame.location.href = '../../eCA/jsp/ChartRecordingSplChtLinks.jsp?'+qryStr;
		parent.graphDisplayFrame.location.href = '../../eCommon/html/blank.html';
		if(parent.closeGroupFrame.document.groupCloseForm.grpButtonOK != null)
			parent.closeGroupFrame.document.groupCloseForm.grpButtonOK.style.display = "none";
	}
}

function loadGraph()
{
	document.splChartUserInputForm.graph.disabled = true;
	var xAxisElementType = document.splChartUserInputForm.xaxisValue.value;
	var yAxisElementType = document.splChartUserInputForm.yaxisValue.value;

	var xAxisDesc = document.splChartUserInputForm.xaxisValue.options[document.splChartUserInputForm.xaxisValue.selectedIndex].text;
	var yAxisDesc = document.splChartUserInputForm.yaxisValue.options[document.splChartUserInputForm.yaxisValue.selectedIndex].text;
	if(xAxisElementType == '')
	{
		alert(getMessage("VALUE_FOR_X_NOT_BLANK","CA"));
		document.splChartUserInputForm.graph.disabled = false;
		return false;
	}
	if(yAxisElementType == '')
	{
		alert(getMessage("VALUE_FOR_Y_NOT_BLANK","CA"));
		document.splChartUserInputForm.graph.disabled = false;
		return false;
	}
	var splChartType = document.splChartUserInputForm.splChartType.value;
	var patient_id = document.splChartUserInputForm.patient_id.value;
	var encounterId = document.splChartUserInputForm.encounterId.value;
	var facility_id = document.splChartUserInputForm.facility_id.value;
	var chart_id = document.splChartUserInputForm.chart_id.value;
	var Sex = document.splChartUserInputForm.Sex.value;
	var splChrtGrp = document.splChartUserInputForm.splChrtGrp;
	var splGrpIdVal = "";

	for(var i=0;i<splChrtGrp.length;i++)
	{
		if(splChrtGrp[i].checked == true) 
		{
			splGrpIdVal = splChrtGrp[i].value;
			break;
		}
	}

	parent.parent.parent.graphDisplayFrame.location.href = '../../eCA/jsp/ChartRecordingSplChtDisplayGraph.jsp?sentFrom=userInput&xAxisVal='+xAxisElementType+'&yAxisVal='+yAxisElementType+'&splChartType='+splChartType+"&chart_id="+chart_id+"&patient_id="+patient_id+"&Sex="+Sex+"&xAxisDesc="+xAxisDesc+"&yAxisDesc="+yAxisDesc+'&splChtGrp='+splGrpIdVal+'&facility_id='+facility_id+'&encounterId='+encounterId;
	document.splChartUserInputForm.graph.disabled = false;
}

function loadLinks(obj)
{
	var splChartType = document.splChartLinksForm.splChartType.value;
	var Sex = document.splChartLinksForm.Sex.value;
	var patient_id = document.splChartLinksForm.patient_id.value;
	var chart_id = document.splChartLinksForm.chart_id.value;
	var splGrpId = obj.value;

	location.href='../../eCA/jsp/ChartRecordingSplChtLinks.jsp?splChartType='+splChartType+'&Sex='+Sex+'&patient_id='+patient_id+'&chart_id='+chart_id+'&fromSplGrp=Y&splGrpId='+splGrpId;
}

function clearTextBoxValues()
{
	parent.chartRecordingEntryFrame.document.splChtPatDtlRecForm.reset();
}

async function openSplGraphInModal(splChartType,yAxisElementType,xAxisElementType,graphDesc)
{
	var dialogTop		=	"80" ;
	var dialogHeight= "30" ;
    var dialogWidth = "40" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;

	var action_url		=	"../../eCA/jsp/ChartRecordingSplChtDisplayGraph.jsp?xAxisElementType="+xAxisElementType+"&yAxisElementType="+yAxisElementType+"&splChartType="+splChartType+"&FromModal=Y&graphDesc="+graphDesc;

	var retVal=await window.showModalDialog(action_url,arguments,features);			
}

function submitPatRecDtlForm()
{
	var numOfRows = parent.chartRecordingEntryFrame.document.splChtPatDtlRecForm.numOfRows.value;
	var numOfCols = parent.chartRecordingEntryFrame.document.splChtPatDtlRecForm.numOfCols.value;
	var numOfTextBoxes = parent.chartRecordingEntryFrame.document.splChtPatDtlRecForm.numOfTextBoxes.value;
	var textBoxVals = "";
	var count = 0;
	for(var t=0;t<parseInt(numOfRows,10);t++)
	{
		for(var s=0;s<parseInt(numOfCols,10);s++)
		{
			textBoxVals = eval("parent.chartRecordingEntryFrame.document.splChtPatDtlRecForm.txt"+t+"Vals"+s);
			if(textBoxVals != null)
				if(textBoxVals.value == "") count++;
		}
	}

	if(count == numOfTextBoxes)
	{
		alert(getMessage("ATLEAST_ONE_VAL","CA"));
		return;
	}
	parent.chartRecordingEntryFrame.document.splChtPatDtlRecForm.target = 'blankRecFrame';
	parent.chartRecordingEntryFrame.document.splChtPatDtlRecForm.submit();
}

function loadYaxisValue(obj)
{
	var code = obj.value;
	var patient_id = document.stdChartUserInputForm.patient_id.value;
	var Sex = document.stdChartUserInputForm.Sex.value;
	var facility_id = document.stdChartUserInputForm.facility_id.value;
	var encounterId = document.stdChartUserInputForm.encounterId.value;
	var chart_id = document.stdChartUserInputForm.chart_id.value;
	var allDatesForGraph = document.stdChartUserInputForm.allDatesForGraph.value;
	var splChartType = document.stdChartUserInputForm.splChartType.value;

	if(code != '')
	{
		location.href = "../../eCA/jsp/ChartRecordingStdChtUserInput.jsp?code="+code+"&patient_id="+patient_id+"&Sex="+Sex+"&facility_id="+facility_id+"&encounterId="+encounterId+"&chart_id="+chart_id+"&allDatesForGraph="+allDatesForGraph+"&splChartType="+splChartType;
	}
}

function loadStdGraph()
{
	document.stdChartUserInputForm.graph.disabled = true;
	var xAxisElementType = document.stdChartUserInputForm.xaxisValue.value;
	var yAxisElementType = document.stdChartUserInputForm.yaxisValue.value;

	var xAxisDesc = document.stdChartUserInputForm.xaxisValue.options[document.stdChartUserInputForm.xaxisValue.selectedIndex].text;
	var yAxisDesc = document.stdChartUserInputForm.yaxisValue.options[document.stdChartUserInputForm.yaxisValue.selectedIndex].text;
	if(xAxisElementType == '')
	{
		alert(getMessage("VALUE_FOR_X_NOT_BLANK","CA"));
		document.stdChartUserInputForm.graph.disabled = false;
		return false;
	}
	if(yAxisElementType == '')
	{
		alert(getMessage("VALUE_FOR_Y_NOT_BLANK","CA"));
		document.stdChartUserInputForm.graph.disabled = false;
		return false;
	}
	
	var patient_id = document.stdChartUserInputForm.patient_id.value;
	var encounterId = document.stdChartUserInputForm.encounterId.value;
	var facility_id = document.stdChartUserInputForm.facility_id.value;
	var chart_id = document.stdChartUserInputForm.chart_id.value;
	var Sex = document.stdChartUserInputForm.Sex.value;
	var allDatesForGraph = document.stdChartUserInputForm.allDatesForGraph.value;
	// IN29392 Starts
	//parent.parent.parent.graphDisplayFrame.location.href = '../../eCA/jsp/ChartRecordingStdChtDisplayGraph.jsp?sentFrom=userInput&xAxisVal='+xAxisElementType+'&yAxisVal='+yAxisElementType+"&chart_id="+chart_id+"&patient_id="+patient_id+"&Sex="+Sex+"&xAxisDesc="+xAxisDesc+"&yAxisDesc="+yAxisDesc+'&facility_id='+facility_id+'&encounterId='+encounterId+'&allDatesForGraph='+allDatesForGraph;
//parent.parent.parent.graphDisplayFrame.location.href = '../../eCA/jsp/ChartRecordingStdChtDisplayGraph.jsp?sentFrom=userInput&xAxisVal='+xAxisElementType+'&yAxisVal='+yAxisElementType+"&chart_id="+chart_id+"&patient_id="+patient_id+"&Sex="+Sex+"&xAxisDesc="+encodeURIComponent(xAxisDesc,"UTF-8")+"&yAxisDesc="+encodeURIComponent(yAxisDesc,"UTF-8")+'&facility_id='+facility_id+'&encounterId='+encounterId+'&allDatesForGraph='+allDatesForGraph;
	parent.parent.graphDisplayFrame.location.href = '../../eCA/jsp/ChartRecordingStdChtDisplayGraph.jsp?sentFrom=userInput&xAxisVal='+xAxisElementType+'&yAxisVal='+yAxisElementType+"&chart_id="+chart_id+"&patient_id="+patient_id+"&Sex="+Sex+"&xAxisDesc="+encodeURIComponent(xAxisDesc,"UTF-8")+"&yAxisDesc="+encodeURIComponent(yAxisDesc,"UTF-8")+'&facility_id='+facility_id+'&encounterId='+encounterId+'&allDatesForGraph='+allDatesForGraph;
	// IN29392 Ends
}

function getYaxisValue(obj)
{
	var Xaxis = obj.value;
	var patient_id = document.splChartUserInputForm.patient_id.value;
	var Sex = document.splChartUserInputForm.Sex.value;
	var facility_id = document.splChartUserInputForm.facility_id.value;
	var encounterId = document.splChartUserInputForm.encounterId.value;
	var chart_id = document.splChartUserInputForm.chart_id.value;
	var splChartType = document.splChartUserInputForm.splChartType.value;

	if(Xaxis != '')
	{
		location.href = "../../eCA/jsp/ChartRecordingSplChtUserInput.jsp?Xaxis="+Xaxis+"&patient_id="+patient_id+"&Sex="+Sex+"&facility_id="+facility_id+"&encounterId="+encounterId+"&chart_id="+chart_id+"&splChartType="+splChartType;
	}
}

async function printing()
{	
	if(parent.graphDisplayFrame.frmset==undefined){
		if(parent.graphDisplayFrame.document.forms[0]==null){
			alert(getMessage("NO_DATA_AVAILABLE_TO_PRINT","CA"));	
		}
	}
		if(parent.graphDisplayFrame==null){
		alert(getMessage("NO_DATA_AVAILABLE_TO_PRINT","CA"));			
	}	
	if(parent.graphDisplayFrame != null)
	{
		var filenames = new Array();
		var patient_id = document.groupCloseForm.patient_id.value;
		var pat_line = document.groupCloseForm.pat_line.value;
		var noOfGroups = "";
		if(parent.graphDisplayFrame.frmset != null)
		{
			noOfGroups = parent.graphDisplayFrame.chart_frame1.document.forms[0].noOfGroups.value;
			for(var i=0;i<noOfGroups;i++)
			{
				filenames[i] = parent.graphDisplayFrame.frames[i].document.getElementById("filename").value;
			}
		}
		else
		{
			if(parent.graphDisplayFrame.document.forms[0] != null)
				filenames[0] = parent.graphDisplayFrame.document.getElementById("filename").value;
		}

		if(filenames.length > 0)
		{
			var url ='../../eCA/jsp/ChartRecordingPrint.jsp?callOn=callOnPrint&filename='+filenames+'&patient_id='+patient_id+'&pat_line='+pat_line;
			//window.open(url,null,'height=600,width=900,top=100,left=100,resizable=yes,scrollbars=yes' ); 
			var dialogTop		= "0vh" ;	
			var dialogHeight	= "90vh" ;
			var dialogWidth		= "60vw" ;
			var status			= "no";
			var arguments		= "" ;
			var features		=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
			var retval = await top.window.showModalDialog(url,arguments,features);
		}
	}
}

function callOnExit(noOfGroups)
{
	var filename = new Array();

	if(noOfGroups != undefined && noOfGroups != '')
	{
		for(var i=0;i<noOfGroups;i++)
		{
			if(document.frames[i] != null)
			{
				if(document.frames[i].document.forms[0] != null && document.frames[i].document.forms[0].filename != null)
				{
					if(document.frames[i].document.forms[0].filename.value != '' && document.frames[i].document.forms[0].filename.value != null)
						filename[i] = document.frames[i].document.forms[0].filename.value;
				}
			}
		}
	}
	else
	{
		filename[0] = document.forms[0].filename.value;
	}
	
	var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='PrintForm' id='PrintForm' "+
						" action='../../eCA/jsp/ChartRecordingPrint.jsp' method='post'>"+
						"<input type='hidden' name='filename' id='filename' value='"+filename+"'>"+
						"<input type='hidden' name='callOn' id='callOn' value='callOnExit'>"+
						"</form></body></html>";
	parent.parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.frames[3].document.forms[0].submit();
	
}

async function PrintData()
{
	if(parent.ChartRecordingListFrame.document.ChartLayoutListForm == null)
	{
		alert(getMessage("NO_DATA_AVAILABLE_TO_PRINT","CA"));
		return;	
	}
	else if(parent.ChartRecordingListFrame.document.ChartLayoutListForm != null)
	{
		var qs = parent.ChartRecordingListFrame.document.ChartLayoutListForm.qs.value;
		var allDatesForGraph = parent.ChartRecordingListFrame.document.ChartLayoutListForm.allDatesForGraph.value;

		var url ='../../eCA/jsp/ChartRecordingPrintData.jsp?'+qs+'&allDatesForGraph='+allDatesForGraph;
		//window.open(url,'Document','height=600,width=900,top=100,left=100,resizable=yes,scrollbars=yes' );

		var dialogTop		= "0vh" ;	
		var dialogHeight	= "67vh" ;
		var dialogWidth		= "50vw" ;
		var status			= "no";
		var arguments		= "" ;
		var features		=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var retval =await top.window.showModalDialog(url,arguments,features);

	}
}

function initListVals()
{
	var countRecs = document.forms[0].count.value;
	var listDfltCnt;
	var listObjForDflt;
	for(var t=0;t<parseInt(countRecs,10);t++)
	{
		listObjForDflt = eval("document.forms[0].list_"+t);
		if(listObjForDflt != null)
		{
			listDfltCnt = eval("document.forms[0].cntDflt_"+t);
			if(listDfltCnt != null)
			{
				listDfltCnt = listDfltCnt.value;
				if(parseInt(listDfltCnt,10) > 0)
					listObjForDflt.onchange();
			}
		}
	}
}

function activateLink(obj,groupNo)
{
	obj.className = 'ActiveGroup';
	obj.innerHTML = '<IMG id=group'+groupNo+' src="../../eCommon/images/iGridNextNOR16.gif" align=left>'+obj.innerText;
}

function deactivateLink(obj,groupNo)
{
	obj.className = 'NormalGroup';
	obj.innerHTML = '<IMG id=group'+groupNo+' src="../../eCommon/images/iGridNextDIS16.gif" align=left>'+obj.innerText;
}

async function callRecordComment(index)
{
	var remObj = '';
	var anchorObj = '';

	var remarks = eval("document.forms[0].remarksField"+index);
	var shortDesc = eval("document.forms[0].event_grp_desc_"+index);
	shortDesc = shortDesc.value;
	if(remarks != null)
	{
		remarks =	 remarks.value;
	}
	else remarks = "";

	var dialogTop		=	"350" ;
	var dialogHeight= "36vh" ;
	//IN047648 starts
    	//var dialogWidth = "20" ;
	//IN047648 -reopen starts
	//var dialogWidth = "23" ;
	//IN047648 ends
	var dialogWidth = "62vw" ;
	//IN047648 -reopen ends
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll:no; status:" + status;
	var action_url		=	'../../eCA/jsp/ChartRecordingRecordComments.jsp?index='+index+'&remarks='+encodeURIComponent(remarks)+'&sentFrom=recordComments&shortDesc='+shortDesc; //[IN029309], added the encodeURIComponent 
	var retVal=await window.showModalDialog(action_url,arguments,features);	
	if(retVal != undefined)
	{
		remObj = eval("document.ChartLayoutDetailForm.remarksField"+index);
		if(remObj != null)
			remObj.value = retVal;

		anchorObj = eval(document.getElementById("comment"+index));
		if(retVal != '')
		{
			if(anchorObj != null)
				anchorObj.style.color = "maroon";
		}
		else if(retVal == '')
		{
			if(anchorObj != null)
				anchorObj.style.color = "blue";
		}
	}
}

function setRemarksField(index)
{
	window.returnValue = document.chartRecordingCommentsForm.textComments.value;
	window.close();
}

function chkLength(obj)
{
	if(obj.value.length > 200)
	{
		alert("Remarks should not exceed 200 characters.");
		//obj.select();
		obj.value="";
		return false;
	}	
	else return true;
}

async function showRemarks(rowInt,colInt)
{
	var remDispObj = eval("document.ChartLayoutListForm.remarks"+rowInt+"ForDisp"+colInt);
	var shortDesc = eval("parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.event_grp_desc_"+rowInt);
	if(shortDesc != null) shortDesc =shortDesc.value;
	else shortDesc = '';

	var dialogTop		=	"0vh" ;
	var dialogLeft		=	"0vw" ;
	var dialogHeight= "10" ;
	//IN047648 starts
    	//var dialogWidth = "20" ;
	//IN047648 -reopen starts
	//var dialogWidth = "23" ;
	//IN047648 ends
	var dialogWidth = "27" ;
	//IN047648 -reopen ends
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll:no; status:" + status + "; dialogLeft:"+ dialogLeft;
	var action_url		=	'../../eCA/jsp/ChartRecordingRecordComments.jsp?remarks='+encodeURIComponent(remDispObj.value)+'&sentFrom=viewComments&shortDesc='+shortDesc;	//[101], added the encodeURIComponent 
	var retVal=await window.showModalDialog(action_url,arguments,features);
	var chngColorAnc = eval(document.getElementById("anc"+rowInt+"ID"+colInt));
	if(chngColorAnc != null)
			chngColorAnc.style.color = "maroon";
}
//IN043178 starts
function allowValidNumberOnKeyPress(fld,e)
{

	var patt = new RegExp('[0-9-.]', 'ig');
	var count=fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	key = String.fromCharCode(whichCode);
	var pattrnbln = patt.test(key);
	return pattrnbln;
}

function allowValidNumberOnBlur(objmsg)
{

	var val=objmsg.value;
	var validnumbers = ".0123456789-";
	var charval = "";
	
	for(i=0;i<val.length;i++)
	{
     charval = val.charAt(i);
	 if (validnumbers.indexOf(charval) == -1)
	 {
		var msg = getMessage("ONLY_NUMBER_ALLOWED","CA");
		alert(msg);
		objmsg.focus();
		return;
	 }
	}
}
//IN043178 End.
function validateElementType(obj,obj1){		
	var xElementyType = document.forms[0].xaxisValue.value;
	var yElementyType = document.forms[0].yaxisValue.value;
	if(xElementyType==yElementyType){
		alert(getMessage('XAXI_YAXI_NOT_SAME','CA'));
		obj.value=obj1.value;		
	}else{
		//checkChartType();
		obj1.value=obj.value;
	}
}
//IN061897 changes starts
function addChartToDefault(obj){	
var chartId =document.forms[0].chart_id.value;
var facility_id = document.forms[0].facility_id.value
var clinician_id = document.forms[0].clinician_id.value	
var clientIpAddress = document.forms[0].clientIpAddress.value	
	if(chartId == null || chartId == "")
	{
		alert(getMessage('SELECT_DEFAULT_CHART','CA'))
		return;
	}

	if(chartId!=null){
			var query_string="Mode=SetChartToDefault&PractiotionerID="+clinician_id+"&Chart_Id="+chartId+"&facility_id="+facility_id+"&clientIpAddress="+clientIpAddress;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr  = "<root><SEARCH ";
			xmlStr +=" /></root>";
		
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
			xmlHttp.open("POST","ViewChartRecordingIntermediate.jsp?"+query_string, false ) ;
			xmlHttp.send(xmlDoc);
			if(trimString(xmlHttp.responseText)!="Success")
			{
				alert(trimString(xmlHttp.responseText));									
			}
	}
}//IN061897 Changes Ends
//IN067534 starts
function showPopUp(tooltip, obj)
{
	
	if (tooltip==undefined){
			return false;
	}
	var temp="<DIV STYLE='BACKGROUND-COLOR:yellow'>";
	temp+=obj;
	temp +="</DIV>";
	
	if(top.content!=null){
	messageFrameReference.document.body.innerHTML = temp;	
	}
	else if (top.messageFrame!=null)
	{   
		 top.messageFrame.document.body.innerHTML = temp;
		
	}
}

function hidePopUp()
{
	if(top.content!=null)
	messageFrameReference.document.body.innerHTML = "";
	else if(top.messageFrame!=null)
	{  

		top.messageFrame.document.body.innerHTML = "";
	}
}
//IN067534 ends

