/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
21/02/2012	  IN036181		Chowminya G	reports which has special characters such as an airstrisk (*) or a semicolon 		
19/03/2013    IN038773      Chowminya G Issue on the Result link doc in clinical notes for the Result Category 	
28/11/2014	IN052716		Ramesh G		Result Link In Template Based Section In  Clinical Notes For "Table" And "Text".						 
24/05/2016	IN055439		Karthi L										MO_CRF_20102		
25/07/2016	IN060688		Ramesh G										AAKH-CRF-0088.1
31/03/2017	IN061907	Krishna Gowtham J							ML-MMOH-CRF-0559
---------------------------------------------------------------------------------------------------------------
*/
function clearClick()
{	
var patient_id=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].patient_id.value;	
var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;	
var encounter_id=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].encounter_id.value;	
var result_linked_rec_type=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].result_linked_rec_type.value;	
	
	parent.RecClinicalNotesLinkMedCriteriaFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMedCriteria.jsp?patient_id="+patient_id+"&return_format="+return_format+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type;
}

String.prototype.replaceAll=function(s1, s2) {return this.split(s1).join(s2)}//IN036181

function checkIsNull(obj)
{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
}

/*
function checkDateWithCurrentDate(toDateTime)
{
	var toDate = toDateTime.split(" ");
	var toarray = toDate[0].split("/");
	var enteredDate = new Date(toarray[2],toarray[1],toarray[0]);

	var today = new Date();
	var date= today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getYear();
	today = new Date(year,month,date);
	if(enteredDate > today)
	{
		return true;
	}
	return false;
}
*/




/*function checkPeriodFromTo()
{
	
	var from_date_time	=	document.forms[0].from_date_time;
	var to_date_time	=	document.forms[0].to_date_time;
	if(checkIsNull(from_date_time) && checkIsNull(to_date_time) ) 
	{
		return true;
	}

	if(checkIsNull(from_date_time)==false)
	if(!doDateTimeChk(from_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		from_date_time.select();
		from_date_time.focus();
		return false;
	}
    if(checkIsNull(to_date_time)==false)
	if(!doDateTimeChk(to_date_time)) 
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	if(checkIsNull(to_date_time)==false)
	if(checkDateWithCurrentDate(to_date_time.value))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("FROM_DATE_GREATER_SYSDATE","CA");		
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	if(!checkIsNull(to_date_time) && !checkIsNull(from_date_time))
	if(!ValidateDateTime(from_date_time,to_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("TO_DT_GR_EQ_FM_DT","CA");		
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	
	
	
	parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	return true;
}*/
function chkDateTime(toDate,format,locale)
{
	if(toDate.value != "") 
	{
		/*if(!(doDateTimeChk(toDate)) )
		{
			msg = getMessage("INVALID_DATE_TIME",'CA');
			alert(msg);
			toDate.focus();
			toDate.select();
			return false;
		}*/
		if(validDate(toDate.value,format,locale)==false)
		{	
			alert(getMessage("INVALID_DATE_TIME","CA"));
			toDate.focus();
			toDate.select();
			return false;
		}
	}
}

function checkPeriodFromTo(from_date,to_date,format,locale)
{
	if (!(from_date.value == "" ))
		{
			if(!isBeforeNow(from_date.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					from_date.select();
					from_date.focus();
					return false;
				}
			else
			{
				if (!(to_date.value == "" ))
					{
						if(isBeforeNow(to_date.value, format, locale))
							{
								if(isAfter(to_date.value, from_date.value, format, locale))
									return true;
								else
									{
										alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
										return false;
									}
							}
						else
							{
								alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
								to_date.select();
								to_date.focus();
								return false;
							}
					}
			}
		}
		else
			{
			  if(!(to_date.value==""))
					{
					  if(!isBeforeNow(to_date.value, format, locale))
						{
							alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
							to_date.select();
							to_date.focus();
							return false;
						}
					}
			}

}


function showCalendarValidate(str){
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}


function showSearchLinkResult()
{
	
	var patient_id      = document.forms[0].patient_id.value;
	var encounter_id      = document.forms[0].encounter_id.value;
	var result_linked_rec_type = document.forms[0].result_linked_rec_type.value;
	var sec_hdg_code = document.forms[0].sec_hdg_code.value;
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time	=	document.forms[0].to_date_time.value;
	
	var radio="";
	if (parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.order[0].checked)
	radio=parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.order[0].value;
	else
	radio=parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.order(1).value;
	var ord_status		=		document.forms[0].ord_status.value;
	var patient_class		=	document.forms[0].patient_class.value;
	if(parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.current_encounter.checked==true)
	parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.current_encounter.value='Y';
	else
	parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.current_encounter.value='N';
	
	var current_encounter	=	parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.current_encounter.value
	
			
	parent.RecClinicalNotesLinkMedResultFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkMedResult.jsp?sec_hdg_code="+sec_hdg_code+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type+"&order="+radio+"&ord_status="+ord_status+"&patient_class="+patient_class+"&current_encounter="+current_encounter+"";
	
}

//var prevobj='';
var ret_str='';
function Reassaign(obj)
{
	
	var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;	
	var sec_hdg_code=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].sec_hdg_code.value;	
	var result_linked_rec_type=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].result_linked_rec_type.value;
	
	if(obj.checked)
	{
		var chkval = obj.value;
		//ret_str=parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ret_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ret_value"+chkval+".value")+"^";
 				
		parent.RecClinicalNotesLinkMedSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&ret_str="+encodeURIComponent(ret_str,"UTF-8")+"";
		parent.RecClinicalNotesLinkMedSelectButtonsFrame.document.RecClinicalNotesLinkMedSelectButtonsForm.select.disabled=false;
	}
	else
	{
			var chkval=obj.value;
			var remval=eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chk_value"+chkval+".value")
			//alert("remval"+remval);
			//parent.ret_str=parent.ret_str+parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ret_value[parseInt(remval)].value+"@";
			parent.RecClinicalNotesLinkMedSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&remval="+encodeURIComponent(remval,"UTF-8")+"&ret_str="+escape(ret_str)+"&removebean=Y";
			
	}	
}


//Functions for the file name RecClinicalNotesLinkMedSelectButtons.jsp-start

function clearFormApprove()
{
	if(parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm != null)
	{
	var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].result_linked_rec_type.value;


	parent.RecClinicalNotesLinkMedSelectedTextFrame.document.location = '../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?sec_hdg_code='+sec_hdg_code+'&result_linked_rec_type='+result_linked_rec_type+'&return_format="+return_format+"&flag=clear&ret_str=';
	
	/*var obj = parent.RecClinicalNotesLinkMedResultFrame.document.getElementById("chkbox");
	alert(obj.length);
	for(i=0;i<obj.length;i++)
	obj[i].checked = false;*/
	for(cnt=0; cnt<parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chk_value"+cnt+".value");
						
            val.checked = false

	}

	parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ctrlChkBox.checked=false
	document.forms[0].select.disabled = true;
	}
}

function returnDataApprove()
{
	var dispResLinkHYMLYN = parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].dispResLinkHYMLYN.value; //IN061907
	//  MO_CRF_20102[IN055439] - Start
	//IN061907 start
	/*if(document.getElementById("chkt").checked) {
		//parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
	}*/
	if(dispResLinkHYMLYN == "Y")
	{
		if(parent.RecClinicalNotesLinkMedSelectButtonsFrame.document.RecClinicalNotesLinkMedSelectButtonsForm.chkl.checked) 
		{
			parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value='HTML';
		}
		else
		{	
			parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
		}
	}
	else
	{
		if(parent.RecClinicalNotesLinkMedSelectButtonsFrame.document.RecClinicalNotesLinkMedSelectButtonsForm.chkl.checked) 
		{
			parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value='';
		}
		else
		{	
			parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value='TEXT';
		}
	}
		//IN061907 ends
	//  MO_CRF_20102[IN055439] - End	
	//var returnValue = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].temp.value;
	var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;
	//var str_header = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].innerhtml_header.value;
	var form = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0];
	if (form && form.innerhtml_header) {
	  var str_header = form.innerhtml_header.value;
	} else {
	  console.error("Form or innerhtml_header not found");
	}

	//alert("return_format"+return_format);
	var returnValue='';
	
	if(return_format=="TEXTLINK")
	{
		//IN052716 Start.
		//returnValue = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].temp.value;
		var strText = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].innertext.value;
		var strText_header = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].innertext_header.value;
		if(strText!=null || strText != '' || strText != " ")
		{
			if(strText_header==null || strText_header == '' || strText_header == " ")
			{
				//IN060688 Start.
				//strText="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td class='' align=left width='22%' style='font-size:12'><b>"+getLabel("Common.DrugName.label","COMMON")+"</b></td><td class=''  width='22%' style='font-size:12'><b>"+getLabel("eCA.DosageDetails.label","CA")+"</b></td><td class='' align=left nowrap width='18%' style='font-size:12'><b>"+getLabel("Common.StartDate.label","Common")+"</b></td><td class=''  nowrap style='font-size:12'><b>"+getLabel("Common.enddate.label","Common")+"</b></td></tr>"+strText+"</table>";
				strText="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td class='' align=left width='22%' style='font-size:12'><b>"+getLabel("Common.DrugName.label","COMMON")+"</b></td><td class='' align=left width='22%' style='font-size:12'><b>"+getLabel("Common.GenericName.label","COMMON")+"</b></td><td class=''  width='22%' style='font-size:12'><b>"+getLabel("eCA.DosageDetails.label","CA")+"</b></td><td class='' align=left nowrap width='18%' style='font-size:12'><b>"+getLabel("Common.StartDate.label","Common")+"</b></td><td class=''  nowrap style='font-size:12'><b>"+getLabel("Common.enddate.label","Common")+"</b></td></tr>"+strText+"</table>";
				//IN060688 End.
			}
			else
			{
				strText= strText_header+" "+strText+"</table>";
			}

			returnValue=strText;
			returnValue=encodeURIComponent(returnValue,"UTF-8");//IN038773	
		}
		//IN052716 End.
	}
	else if(return_format=="TEXT")
	{
		//var retval = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].temp.value; //IN038773
		var retval=parent.RecClinicalNotesLinkMedSelectedTextFrame.document.getElementById('finalDiv1').innerText;//IN038581
		retval = retval.replace("</font>","");
		retval = retval.replace("<font color=red>","");
		returnValue = encodeURIComponent(retval,"UTF-8");
		
	}
	else
	{
		var str = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].innerhtml.value;

		if(str==null || str == '' || str == " ")
		{
			//returnValue='';	
		}
		else
		{

			if(str_header==null || str_header == '' || str_header == " ")
			{

				////IN060688 Start. 
				//str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td class='columnheadercenter' align=left width='32%' style='font-size:12'><b>"+getLabel("Common.DrugName.label","COMMON")+"</b></td><td class='columnheadercenter'  width='32%' style='font-size:12'><b>"+getLabel("eCA.DosageDetails.label","CA")+"</b></td><td class='columnheadercenter' align=left nowrap width='18%' style='font-size:12'><b>"+getLabel("Common.StartDate.label","Common")+"</b></td><td class='columnheadercenter'  nowrap style='font-size:12'><b>"+getLabel("Common.enddate.label","Common")+"</b></td></tr>"+str+"</table>";
				str="<table  border=\"1\"  cellpadding=\"3\" cellspacing=\"0\" width='100%'><tr><td class=\"columnheadercenter\" align=\"left\" width='32%' style='font-size:12'><b>"+getLabel("Common.DrugName.label","COMMON")+"</b></td><td class=\"columnheadercenter\" align=\"left\" width='22%' style='font-size:12'><b>"+getLabel("Common.GenericName.label","COMMON")+"</b></td><td class=\"columnheadercenter\"  width='32%' style='font-size:12'><b>"+getLabel("eCA.DosageDetails.label","CA")+"</b></td><td class=\"columnheadercenter\" align=\"left\" nowrap width='18%' style='font-size:12'><b>"+getLabel("Common.StartDate.label","Common")+"</b></td><td class=\"columnheadercenter\"  nowrap style='font-size:12'><b>"+getLabel("Common.enddate.label","Common")+"</b></td></tr>"+str+"</table>";
				//IN060688 End.
			}
			else
			{
				str= str_header+" "+str+"</table>";
			}

			returnValue=str;
			returnValue=encodeURIComponent(returnValue,"UTF-8");//IN038773

		}
		
	}
	
	returnValue = returnValue.replaceAll("+","%20");//IN036181
	if(returnValue=='')
	 alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));
	else
	{	
		parent.window.returnValue=decodeURIComponent(returnValue,"UTF-8");//IN036181
	//	parent.window.returnValue = returnValue; //IN038773
		parent.window.close();	
	}
	
}

//Functions for the file name RecClinicalNotesLinkMedSelectButtons.jsp-end

/*function clearBean()
	{
		alert("inside if");
		parent.messageFrameReference.location.href = "../../eCA/jsp/RecClinicalNotesLinkMedClearBean.jsp?";
	}*/


function perform(ctrlChkBoxObj)
{
	var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].result_linked_rec_type.value;

	
	var val ="";
	var retstr2="";
    var strval="";
	parent.messageFrameReference.location.href="../../eCommon/html/blank.html"
	if(ctrlChkBoxObj.checked==true)
	{
		
		for(cnt=0; cnt<parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.count.value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chkbox"+cnt);
			if(!val.checked)
            {
				val.checked = true;
            strval=eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"^";
			}
			
			//alert(retstr2)
		}
 		HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'></form>";
		parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		
		parent.messageFrameReference.document.dummy_form.target = "RecClinicalNotesLinkMedSelectedTextFrame";
		parent.messageFrameReference.document.dummy_form.submit();
		parent.RecClinicalNotesLinkMedSelectButtonsFrame.document.RecClinicalNotesLinkMedSelectButtonsForm.select.disabled=false;
		
	}
	
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.count.value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chkbox"+cnt);
			val.checked = false;
		}
		
		parent.RecClinicalNotesLinkMedSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&flag=clear&ret_str= ";
	}

}





function chkunchk(objCheck)
{
	
	var index = 0;
	if(objCheck.checked==false)
	{
		parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.count.value; cnt++)
		{
			val = eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ctrlChkBox.checked=true
		}
	}	
}



function selText(obj1)
{
	var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;
	var clearchkval='';
	var clearremval='';

	var sec_hdg_code=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].result_linked_rec_type.value;

	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.RecClinicalNotesLinkMedSelectedTextFrame.document.RecClinicalNotesLinkMedSelectedTextForm.clear"+clearchkval+".value");

		
	 	parent.RecClinicalNotesLinkMedSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?return_format="+return_format+"&remval="+escape(clearremval)+"&removebean=Y&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type;
		
		makeresultcheck(clearremval)

	}
	
}
function makeresultcheck(remval)
{
	
	for(cnt=0; cnt<parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chk_value"+cnt+".value");
					
			if(strval==remval)
            val.checked = false

	}


}
	
	
/*function scrollTitle()
{

  var x = document.body.scrollTop;

  if(x == 0){
	 
   document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  = 0;
   document.getElementById("head2").style.position='static';
   document.getElementById("head2").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;
   document.getElementById("head4").style.position='static';
   document.getElementById("head4").style.posTop  = 0;
   document.getElementById("head5").style.position='static';
   document.getElementById("head5").style.posTop  = 0;

  }else{
	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-35;
	document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  = x-35;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-35;
	document.getElementById("head4").style.position = 'relative';
	document.getElementById("head4").style.posTop  = x-35;
	document.getElementById("head5").style.position = 'relative';
	document.getElementById("head5").style.posTop  = x-35;

	
  
  }

}*/

function scrollTitle()
{
	//alert(parent.RecClinicalNotesLinkMedResultFrame.RecClinicalNotesLinkMedResultForm.name);
  var y = parent.RecClinicalNotesLinkMedResultFrame.RecClinicalNotesLinkMedResultForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkMedResultFrame.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkMedResultFrame.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkMedResultFrame.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkMedResultFrame.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}

function scrollTitle1()
{
	//alert(parent.RecClinicalNotesLinkMedResultFrame.RecClinicalNotesLinkMedResultForm.name);
  var y = parent.RecClinicalNotesLinkMedSelectedTextFrame.RecClinicalNotesLinkMedSelectedTextForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkMedSelectedTextFrame.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkMedSelectedTextFrame.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkMedSelectedTextFrame.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkMedSelectedTextFrame.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}


/*function alignWidth()
{
	var totalRows =  parent.RecClinicalNotesLinkMedResultForm.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.RecClinicalNotesLinkMedResultForm.document.getElementById("dataTitleTable").rows(0).cells.length;
	for(var i=0;i<temp;i++) 
	{
	parent.RecClinicalNotesLinkMedResultForm.document.getElementById("dataTitleTable").rows(0).cells(i).width=parent.RecClinicalNotesLinkMedResultForm.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
	}
}*/

function chgretn(Obj)
{

if(Obj.value == 't'){
parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
}
else{
parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value='';
}
document.getElementById('chkt').checked = (Obj.value == 't');
document.getElementById('chkl').checked = (Obj.value == 'l');
}
 	


