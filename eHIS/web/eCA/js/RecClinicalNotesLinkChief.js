/*
Date		Edit History	Name				Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------------------------------
26/07/2024    64277		 Gomathi Sivakumar						Ramesh G		File created for MMS-DM-CRF-0260-US005
16/08/2024    64278		 Gomathi Sivakumar						Ramesh G		MMS-DM-CRF-0260-US006
23/08/2024    64279		 Gomathi Sivakumar						Ramesh G		MMS-DM-CRF-0260-US007
-----------------------------------------------------------------------------------------------------------------
*/

function clearClick()
{	
	var patient_id=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].patient_id.value;	
	var return_format=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value;	
	var encounter_id=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].encounter_id.value;	
	var hist_rec_type= parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].hist_rec_type.value;	
	parent.RecClinicalNotesLinkChiefCompCriteriaFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkChiefCompCriteria.jsp?patient_id="+patient_id+"&return_format="+return_format+"&encounter_id="+encounter_id+"&result_linked_rec_type="+hist_rec_type;
}

function showSearchLinkResult()
{
	var patient_id      = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.RecClinicalNotesLinkChiefCompCriteriaForm.patient_id.value;
	var encounter_id      = document.RecClinicalNotesLinkChiefCompCriteriaForm.encounter_id.value;
	var hist_rec_type = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.RecClinicalNotesLinkChiefCompCriteriaForm.hist_rec_type.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.RecClinicalNotesLinkChiefCompCriteriaForm.sec_hdg_code.value; 
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time	=	document.forms[0].to_date_time.value;
	var checkbox="";

	if (parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.RecClinicalNotesLinkChiefCompCriteriaForm.current_encounter.checked)
	checkbox="Y";
	else
	checkbox="N";

	var order_by1	=	document.forms[0].order_by1.value;
	var order_by2	=	document.forms[0].order_by2.value;

	var url="../../eCA/jsp/RecClinicalNotesLinkChiefCompResult.jsp?from_date_time="+escape(from_date_time)+"&to_date_time="+escape(to_date_time)+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&result_linked_rec_type="+hist_rec_type+"&current_encounter="+checkbox+"&order_by1="+order_by1+"&order_by2="+order_by2+"&sec_hdg_code="+sec_hdg_code;
	parent.RecClinicalNotesLinkChiefCompResultFrame.location.href =url ;
}


function perform(ctrlChkBoxObj)
{
	var return_format=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].hist_rec_type.value;
	var val ="";
	var retstr2="";
    var strval="";
	parent.messageFrameReference.location.href="../../eCommon/html/blank.html"
	if(ctrlChkBoxObj.checked==true)
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.count.value; cnt++)
		{
			val = eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.chkbox"+cnt);
			if(!val.checked)
            {
			val.checked = true;
            strval=eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"»";
			}
		}
			HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkChiefCompSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'></form>";
		parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		parent.messageFrameReference.document.dummy_form.target = "RecClinicalNotesLinkChiefCompSelectedTextFrame";
		parent.messageFrameReference.document.dummy_form.submit();
		parent.RecClinicalNotesLinkChiefCompSelectButtonsFrame.document.RecClinicalNotesLinkChiefSelectButtonsForm.select.disabled=false;
		parent.RecClinicalNotesLinkChiefCompSelectButtonsFrame.document.RecClinicalNotesLinkChiefSelectButtonsForm.clear.disabled=false;
			
	}
	
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.count.value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.chkbox"+cnt);
			val.checked = false;
			strval=eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"»";
		}
		
	 	parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkChiefCompSelectedText.jsp?sec_hdg_code=&result_linked_rec_type=CHIC&return_format=&flag=clear&ret_str=";
	
	}


}

function doDateCheck1(fromDate,toDate,currDate,format,locale)
{
	if((!fromDate.value=="")&&(!toDate.value==""))
	{
	if(isBeforeNow(fromDate.value, format, locale))
	{
		if(isBeforeNow(toDate.value, format, locale))
		{
			if(isAfter(toDate.value, fromDate.value, format, locale))
				return true;
			else
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));	
				toDate.focus();
				return false;
			}
		}
		else
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			toDate.select();
			toDate.focus();
			return false;
		}

	}
	else
	{
		alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
		
		fromDate.select();
		fromDate.focus();
		return false;
	}
	}
		else if((toDate.value=="") && (!fromDate.value==""))
		{
			if(!isBeforeNow(fromDate.value, format, locale))
			{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			
			fromDate.select();
			fromDate.focus();
			return false;
			}
		}
	else if((fromDate.value=="") && (!toDate.value==""))
	{
		if(!isBeforeNow(toDate.value, format, locale))
		{
		alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
		
		toDate.select();
		toDate.focus();
		return false;
		}
	}

}

function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}

var ret_str='';
function Reassaign(obj)
{
	var return_format=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].hist_rec_type.value;
	if(obj.checked)
	{
		var chkval = obj.value;
		ret_str=eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.ret_value"+chkval+".value")+"»";
		parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkChiefCompSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&ret_str="+ret_str;
		parent.RecClinicalNotesLinkChiefCompSelectButtonsFrame.document.RecClinicalNotesLinkChiefSelectButtonsForm.select.disabled=false;
		parent.RecClinicalNotesLinkChiefCompSelectButtonsFrame.document.RecClinicalNotesLinkChiefSelectButtonsForm.clear.disabled=false;
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.checking_value"+chkval+".value")
			parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkChiefCompSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&remval="+encodeURIComponent(remval,"UTF-8")+"&ret_str="+ret_str+"&removebean=Y";
		}	
}

function chkunchk(objCheck)
{
	var index = 0;
	if(objCheck.checked==false)
	{
		parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.count.value; cnt++)
		{
			val = eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.ctrlChkBox.checked=true
		}
	}	
}


function selText(obj1)
{
	var return_format=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.RecClinicalNotesLinkChiefCompCriteriaForm.sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.RecClinicalNotesLinkChiefCompCriteriaForm.hist_rec_type.value;
	var clearchkval='';
	var clearremval='';
	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.document.RecClinicalNotesLinkChiefSelectedTextForm.clear"+clearchkval+".value");
		parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkChiefCompSelectedText.jsp?return_format="+return_format+"&remval="+encodeURIComponent(clearremval,"UTF-8")+"&removebean=Y&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type;
		makeresultcheck(clearremval)
	}
}

function makeresultcheck(remval)
{
	for(cnt=0; cnt<parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.checking_value"+cnt+".value");
					
			if(strval==remval)
		{
				val.checked = false
   
			parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.ctrlChkBox.checked = false;
			
		}
	} 
}

function scrollTitle()
{
	
  var y = parent.RecClinicalNotesLinkChiefCompResultFrame.RecClinicalNotesLinkChiefResultForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkChiefCompResultFrame.RecClinicalNotesLinkChiefResultForm.document.getElementById('divDataTitle').style.position = 'static';
	parent.RecClinicalNotesLinkChiefCompResultFrame.RecClinicalNotesLinkChiefResultForm.document.getElementById('divDataTitle').style.posTop  = 0;
  }else{
	parent.parent.RecClinicalNotesLinkChiefCompResultFrame.RecClinicalNotesLinkChiefResultForm.document.getElementById('divDataTitle').style.position = 'relative';
	parent.parent.RecClinicalNotesLinkChiefCompResultFrame.RecClinicalNotesLinkChiefResultForm.document.getElementById('divDataTitle').style.posTop  = y-2;
  }

}

function scrollTitle1()
{
	
  var y = document.body.scrollTop;
  if(y == 0){
	  document.getElementById('divDataTitle').style.position = 'static';
	  document.getElementById('divDataTitle').style.posTop  = 0;
  }else{
	  document.getElementById('divDataTitle').style.position = 'relative';
	  document.getElementById('divDataTitle').style.posTop  = y-2;
  }

}	

//64278 Starts
function returnDataApprove()
{
		var dispResLinkHYMLYN = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].dispResLinkHYMLYN.value; 
		if(dispResLinkHYMLYN == "Y")
		{
			if(parent.RecClinicalNotesLinkChiefCompSelectButtonsFrame.document.RecClinicalNotesLinkChiefSelectButtonsForm.chkl.checked) 
			{
				parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value='HTML';
			}
			else
			{
				
				parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
			}
		}
		else
		{
			if(parent.RecClinicalNotesLinkChiefCompSelectButtonsFrame.document.RecClinicalNotesLinkChiefSelectButtonsForm.chkl.checked) 
			{
				parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value='';
			}
			else
			{
				parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value='TEXT';
			}
		}
		
	var str = parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.document.getElementById('innerhtml').value;
	var str_header = parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.document.getElementById('innerhtml_header').value;
	
	var return_format=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value;
	var returnValue='';
	
	if(return_format=="TEXTLINK")
	{
		var strtext = parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.document.getElementById('innertext').value;
		var strtext_header = parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.document.getElementById('innertext_header').value;
		
		if(strtext!=null || strtext != '' || strtext!= " "){
			if(strtext_header==null || strtext_header == '' || strtext_header == " ")
				{
			strtext="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel("Common.Complaint.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.ComplaintDetails.label",'eCA')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.OnsetDatetime.label",'eCA')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel("eCA.Remarks.label",'eCA')+"</b></td></tr>"+strtext+"</table>";
				}
				else
				{
					strtext= strtext_header+" "+strtext+"</table>";
				}
				
			} 
			returnValue=strtext;
			returnValue=encodeURIComponent(returnValue,"UTF-8");
	}
	else if(return_format=="TEXT")
	{
		returnValue=encodeURIComponent(parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.document.getElementById('finalDiv1').innerText,"UTF-8");
	}
	//64279 Starts
	else
	{
		if(str==null || str == '' || str == " "){
			}
		else{
		 if(str_header==null || str_header == '' || str_header == " ")
			{
			str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("Common.Complaint.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("eCA.ComplaintDetails.label",'eCA')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("eCA.OnsetDatetime.label",'eCA')+"</b></td><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("eCA.Remarks.label",'eCA')+"</b></td></tr>"+str+"</table>";
			}
			else
			{
				str= str_header+" "+str+"</table>";
			}
			
		returnValue=str;
		returnValue=encodeURIComponent(returnValue,"UTF-8");
		}
	}
	//64279 Ends
	returnValue = returnValue.replaceAll("+","%20");
	if(returnValue == '')
	alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));
	else
	{
		parent.window.returnValue=decodeURIComponent(returnValue,"UTF-8");
	parent.window.close();	
	}
	
}

String.prototype.replaceAll=function(s1, s2) {return this.split(s1).join(s2)}

function chgretn(Obj)
{

if(Obj.value == 't')
parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
else
parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value='';

}
//64278 Ends

function clearFormApprove()
{

	if(parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm != null)
	{
	var return_format=parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.forms[0].return_format.value;
	
	var sec_hdg_code = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.RecClinicalNotesLinkChiefCompCriteriaForm.sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkChiefCompCriteriaFrame.document.RecClinicalNotesLinkChiefCompCriteriaForm.hist_rec_type.value;

	parent.RecClinicalNotesLinkChiefCompSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkChiefCompSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&flag=clear&ret_str=";
	
	for(cnt=0; cnt<parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.checking_value"+cnt+".value");
						
            val.checked = false

	}

	parent.RecClinicalNotesLinkChiefCompResultFrame.document.RecClinicalNotesLinkChiefResultForm.ctrlChkBox.checked=false
	}
}

