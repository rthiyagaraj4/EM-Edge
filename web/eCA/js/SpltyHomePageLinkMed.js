function clearClick()
{	
var patient_id=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].patient_id.value;	
var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;	
var encounter_id=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].encounter_id.value;	
var result_linked_rec_type=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].result_linked_rec_type.value;	
	
	parent.RecClinicalNotesLinkMedCriteriaFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMedCriteria.jsp?patient_id="+patient_id+"&return_format="+return_format+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type;
}


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
function chkDateTime(toDate)
{
	if(toDate.value != '') 
	{
		if(!(doDateTimeChk(toDate)) )
		{
			msg = getMessage("INVALID_DATE_TIME",'CA');
			alert(msg);
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
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time	=	document.forms[0].to_date_time.value;
	
	var radio="";
	if (parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.order(0).checked)
	radio=parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.order(0).value;
	else
	radio=parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.order(1).value;
	var ord_status		=		document.forms[0].ord_status.value;
	var patient_class		=	document.forms[0].patient_class.value;
	if(parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.current_encounter.checked==true)
	parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.current_encounter.value='Y';
	else
	parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.current_encounter.value='N';
	
	var current_encounter	=	parent.RecClinicalNotesLinkMedCriteriaFrame.document.RecClinicalLinkMedCriteriaForm.current_encounter.value
	
			
	parent.RecClinicalNotesLinkMedResultFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkMedResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type+"&order="+radio+"&ord_status="+ord_status+"&patient_class="+patient_class+"&current_encounter="+current_encounter+"";
	
}

//var prevobj='';
var ret_str='';
function Reassaign(obj)
{
	
	var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;	
	if(obj.checked)
	{
		var chkval = obj.value;
		//ret_str=parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ret_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ret_value"+chkval+".value")+"@";
 				
		parent.RecClinicalNotesLinkMedSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?return_format="+return_format+"&ret_str="+escape(ret_str)+"";
	parent.RecClinicalNotesLinkMedSelectButtonsFrame.document.RecClinicalNotesLinkMedSelectButtonsForm.select.disabled=false;
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chk_value"+chkval+".value")
			//alert("remval"+remval);
			//parent.ret_str=parent.ret_str+parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ret_value[parseInt(remval)].value+"@";
			parent.RecClinicalNotesLinkMedSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?return_format="+return_format+"&remval="+escape(remval)+"&ret_str="+escape(ret_str)+"&removebean=Y";
			
		}	
}


//Functions for the file name RecClinicalNotesLinkMedSelectButtons.jsp-start

function clearFormApprove()
{
	if(parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm != null)
	{
	var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;
	parent.RecClinicalNotesLinkMedSelectedTextFrame.document.location = '../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?return_format="+return_format+"&flag=clear&ret_str=';
	
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
	}
}

function returnDataApprove()
{

	//var returnValue = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].temp.value;
	var return_format=parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value;
	//alert("return_format"+return_format);
	var returnValue='';
	if(return_format=="TEXTLINK")
	{
		returnValue=parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].temp.value;
	}
	else if(return_format=="TEXT")
	{
		returnValue=parent.RecClinicalNotesLinkMedSelectedTextFrame.document.forms[0].temp.value;
		
	}
	else
	{
	var str = parent.RecClinicalNotesLinkMedSelectedTextFrame.document.getElementById("innerhtml").value;

	if(str==null || str == '' || str == " ")
	{
		//returnValue='';	
	}else{
		str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td class='columnheadercenter' align=left width='32%' style='font-size:12'><b>"+getLabel("Common.DrugName.label","COMMON")+"</b></td><td class='columnheadercenter'  width='32%' style='font-size:12'><b>"+getLabel("eCA.DosageDetails.label","CA")+"</b></td><td class='columnheadercenter' align=left nowrap width='18%' style='font-size:12'><b>"+getLabel("Common.StartDate.label","Common")+"</b></td><td class='columnheadercenter'  nowrap style='font-size:12'><b>"+getLabel("Common.enddate.label","Common")+"</b></td></tr>"+str+"</table>";
	    returnValue=str;

	}
		
	}
	if(returnValue=='')
	 alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));
	else
	{		
	parent.window.returnValue=returnValue;
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
			retstr2 = retstr2 + strval.value+"@";
			}
			
			//alert(retstr2)
		}
 		HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+escape(retstr2)+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'></form>";
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
		
		parent.RecClinicalNotesLinkMedSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?return_format="+return_format+"&flag=clear&ret_str= ";
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
	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.RecClinicalNotesLinkMedSelectedTextFrame.document.RecClinicalNotesLinkMedSelectedTextForm.clear"+clearchkval+".value");

		
	 	parent.RecClinicalNotesLinkMedSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMedSelectedText.jsp?return_format="+return_format+"&remval="+escape(clearremval)+"&removebean=Y";
		
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

if(Obj.value == 't')
parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
else
parent.RecClinicalNotesLinkMedCriteriaFrame.document.forms[0].return_format.value='';

}
 	


