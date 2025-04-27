/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100           ?           	?				?				created
24/05/2016	  IN055439		Karthi L										MO_CRF_20102
31/03/2017	IN061907	Krishna Gowtham J							ML-MMOH-CRF-0559		
---------------------------------------------------------------------------------------------------------------
*/
/*function checkPeriodFromTo()
{
	 var result_cat          =   document.forms[0].result_cat.value; 
	/*if(result_cat == 'APPT')
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
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME");
		//from_date_time.select();
		from_date_time.value='';
		from_date_time.focus();
		return false;
	}
    if(checkIsNull(to_date_time)==false)
	if(!doDateTimeChk(to_date_time)) 
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME");
		//to_date_time.select();
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	if(checkIsNull(to_date_time)==false)
	if(checkDateWithCurrentDate(to_date_time.value))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("DATE_GREATER_SYSDATE");		
		//to_date_time.select();
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	if(!checkIsNull(to_date_time) && !checkIsNull(from_date_time))
	if(!ValidateDateTime(from_date_time,to_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("TO_DT_GR_EQ_FM_DT");		
		//to_date_time.select();
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	
	
	
	parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	return true;
	}*/
	/*if(result_cat == 'ORDR' || result_cat == 'REFR' || result_cat == 'APPT' )
	{
	var from_date_time	=	document.forms[0].txtFromDate;
	var to_date_time	=	document.forms[0].txtToDate;
	
	if(checkIsNull(from_date_time) && checkIsNull(to_date_time) ) 
	{
		return true;
	}

	if(checkIsNull(from_date_time)==false)
	if(!doDateTimeChk(from_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME");
		from_date_time.select();
		//from_date_time.value='';
		from_date_time.focus();
		return false;
	}
    if(checkIsNull(to_date_time)==false)
	if(!doDateTimeChk(to_date_time)) 
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME");
		to_date_time.select();
		//to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	if(checkIsNull(to_date_time)==false)
	if(!checkDateWithCurrentDateTime(from_date_time.value) && from_date_time.value!='')
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("DATE_GT_EQ_SYS_DATE");		
		//to_date_time.select();
		from_date_time.value='';
		from_date_time.select();
		from_date_time.focus();
		return false;
	}
	if(!checkDateWithCurrentDateTime(to_date_time.value)&& to_date_time.value!='')
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("DATE_GT_EQ_SYS_DATE");		
		//to_date_time.select();
		to_date_time.select();
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	if(!checkIsNull(to_date_time) && !checkIsNull(from_date_time))
	if(!ValidateDateTime(from_date_time,to_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("TO_DT_GR_EQ_FM_DT");		
		//to_date_time.select();
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	
	
	
	parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	return true;
	}

}*/
function checkIsNull(obj)
{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
}

function checkDateWithCurrentDate1(obj)
{
	var from = document.forms[0].txtFromDate.value;
	var to = document.forms[0].txtToDate.value;
	var format='DMY';
	var locale = document.forms[0].locale.value;
	if(obj.value !="")
	{
		if(!CheckDate(obj))
		{
			obj.select();
			obj.focus();
			return false;	
		}
			if(obj.name == "txtFromDate")
			{
				if(!isAfterNow(from,format,locale))
				{
					parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("DATE_GT_EQ_SYS_DATE","FM");		
					obj.select();
					obj.focus();
					return false;		
				}
				else
				{
					parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp"
					return true;
				}
			 }
			 if(obj.name == "txtToDate")
			 {
				if(!isBefore(from,to,format,locale))
				{
					var msg=getMessage("TO_DT_GR_EQ_FM_DT","CA");
					parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+msg;		
					obj.select();
					obj.focus();
					return false;
				}
				else
				{
					parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp"
					return true;
				}
			 }
	}
	return true;
}

function checkDateWithCurrentDate2(obj)
{
	var from = document.forms[0].rfrdFromDate.value;
	var to = document.forms[0].rfrdToDate.value;
	var format='DMY';
	var locale = document.forms[0].locale.value;
	if(obj.value !="")
	{
		if(!CheckDate(obj))
		{
			obj.select();
			obj.focus();
			return false;	
		}
			
			if(obj.name == "rfrdFromDate")
			{
				
				if(!isBeforeNow(from,format,locale))
				{
					parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("DATE_GT_EQ_SYS_DATE","FM");		
					obj.select();
					obj.focus();
					return false;		
				}
				else
				{
					parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp"
					return true;
				}
			 }
				
			 if(obj.name == "rfrdToDate")
			 {
				
				if(!isBeforeNow(to,format,locale))
				{
					parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("DATE_GT_EQ_SYS_DATE","FM");		
					obj.select();
					obj.focus();
					return false;		
				}
				
				if(!isBefore(from,to,format,locale))
				{
					var msg=getMessage("TO_DT_GR_EQ_FM_DT","CA");
					parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+msg;		
					obj.select();
					obj.focus();
					return false;
				}
				else
				{
					parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp"
					return true;
				}
			 }
	}
	return true;
}

/*function checkDateWithCurrentDate(toDateTime)
{
	var toDate = toDateTime.value;
	var toarray = toDate.split("/");


	var enteredDate = new Date(toarray[2],toarray[1],toarray[0]);
   
	var today = new Date();
	var date= today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getYear();
	today = new Date(year,month,date);
	if(enteredDate < today)
	{
	
	parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("DATE_GT_EQ_SYS_DATE","FM");		
	toDateTime.select();
	toDateTime.focus();
	return false;
	}
	else
	{
	parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp"
	return true;
	}
}
*/
/*function doDateCheck1(from,to,obj,obj1){
	var format='DMY';
	var locale = document.forms[0].locale.value;
	
	if(from!=null&&to!=null&&from.value.length>0&&to.value.length>0){
		if(!isBefore(from.value, to.value,format,locale)){
		
		var msg=getMessage("TO_DT_GR_EQ_FM_DT","CA");
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+msg;		
		obj.select();
	    obj.focus();
		return false;
		}
		else{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp"
		return true;	
		}
	
	}
}*/


/*function doDateCheck(from,to,obj,obj1) {
			if(CheckSystemDateLesserDiag(obj,obj1)){
				if(!doDateCheckAlert(from,to)){
				var msg="APP-SM0005 From Date Should Be Less than To Date";
                parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+msg;		
				obj.select();
	    		obj.focus();
				return false;
				}
			}
			else
	{
    parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp"
	return true;
	}
		}
		*/
function showCalendarValidate(str){
	var flg = showCalendar(str,null,null);
	document.getElementById(str).focus();
	return flg;
}




function call_result(val,link)
{

var patient_id=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].patient_id.value;
var nature=parent.RecClinicalNotesLinkFutureApptTreeFrame.document.forms[0].nature.value;
var order=parent.RecClinicalNotesLinkFutureApptTreeFrame.document.forms[0].order.value;

var result_linked_rec_type = parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_linked_rec_type.value;
	
var sec_hdg_code = parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].sec_hdg_code.value;
	

parent.RecClinicalNotesLinkFutureApptResultFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureApptResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&val="+encodeURIComponent(val)+"&link="+link+"&patient_id="+patient_id+"&nature="+nature+"&order="+order;
}

function scrollTitle()
{
	//alert(parent.RecClinicalNotesLinkFutureApptResultFrame.RecClinicalNotesLinkFutureApptResultForm.name);
  var y = parent.RecClinicalNotesLinkFutureApptResultFrame.RecClinicalNotesLinkFutureApptResultForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkFutureApptResultFrame.RecClinicalNotesLinkFutureApptResultForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkFutureApptResultFrame.RecClinicalNotesLinkFutureApptResultForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkFutureApptResultFrame.RecClinicalNotesLinkFutureApptResultForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkFutureApptResultFrame.RecClinicalNotesLinkFutureApptResultForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}
 function perform(ctrlChkBoxObj)
{
	
	var return_format=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value;

	var result_linked_rec_type = parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_linked_rec_type.value;
	
	var sec_hdg_code = parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].sec_hdg_code.value;
	
	
	var val ="";
	var retstr2="";
    var strval="";
	parent.messageFrameReference.location.href="../../eCommon/html/blank.html"
	if(ctrlChkBoxObj.checked==true)
	{
		
		for(cnt=0; cnt<parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.count.value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.chkbox"+cnt);
			if(!val.checked)
            {
				val.checked = true;
            strval=eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.ret_value"+cnt);
			//alert("strval......."+strval.value);
			retstr2 = retstr2 + strval.value+"@";
			}
			
			//alert(retstr2)
		}
		var result_cat=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_cat.value;
		//Below 'encodeURIComponent(retstr2)' is removed and only 'retstr2' is passed,modified by Archana Dhal on 10/27/2010 related to incident IN024711.

        if(result_cat == 'APPT')
	   {
 		HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkFutureApptSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'></form>";
		parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
	   }
	   else if(result_cat == 'ORDR')
	    {
		HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkFutureOrdSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'></form>";
		parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		}
		else if(result_cat == 'REFR')
		{
        HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkFutureReferralSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'></form>";
		parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		}
		
		parent.messageFrameReference.document.dummy_form.target = "RecClinicalNotesLinkFutureApptSelectedTextFrame";
		parent.messageFrameReference.document.dummy_form.submit();
		parent.RecClinicalNotesLinkFutureApptSelectButtonsFrame.document.RecClinicalNotesLinkFutureApptSelectButtonsForm.select.disabled=false;
		
	}
	
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.count.value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.chkbox"+cnt);
			val.checked = false;
		}
		var result_cat=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_cat.value;		
		 if(result_cat == 'APPT')
	   {
	   parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkFutureApptSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&flag=clear&ret_str= ";
	   }
	    else if(result_cat == 'ORDR')
	    {
		parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkFutureOrdSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&flag=clear&ret_str= ";
		}
		else if(result_cat == 'REFR')
	    {
		parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkFutureReferralSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&flag=clear&ret_str= ";
		}

	}

}
var ret_str='';
function Reassaign(obj)
{
	
	var return_format=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value;	
	var result_linked_rec_type = parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_linked_rec_type.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].sec_hdg_code.value;
	
	if(obj.checked)
	{
		var chkval = obj.value;
		//ret_str=parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.ret_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.ret_value"+chkval+".value")+"@";

		var result_cat=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_cat.value;	
 				
	   if(result_cat == 'APPT')
	   {

 		parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureApptSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&ret_str="+encodeURIComponent(ret_str)+"";
	   }
	   else if(result_cat == 'ORDR')
	    {	
		 parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureOrdSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&ret_str="+encodeURIComponent(ret_str)+"";
		}
		else if(result_cat == 'REFR')
	    {
		 parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureReferralSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&ret_str="+encodeURIComponent(ret_str)+"";
		}
		parent.RecClinicalNotesLinkFutureApptSelectButtonsFrame.document.RecClinicalNotesLinkFutureApptSelectButtonsForm.select.disabled=false;
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.chk_value"+chkval+".value")
			//alert("remval"+remval);
			//parent.ret_str=parent.ret_str+parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.ret_value[parseInt(remval)].value+"@";
			var result_cat=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_cat.value;	
	   if(result_cat == 'APPT')
	   {
	   parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureApptSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&remval="+encodeURIComponent(remval)+"&ret_str="+encodeURIComponent(ret_str)+"&removebean=Y";
	   }
	   else if(result_cat == 'ORDR')
	   {
		parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureOrdSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&remval="+encodeURIComponent(remval)+"&ret_str="+encodeURIComponent(ret_str)+"&removebean=Y";	
		}
		else if(result_cat == 'REFR')
	    {
		parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureReferralSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&remval="+encodeURIComponent(remval)+"&ret_str="+encodeURIComponent(ret_str)+"&removebean=Y";	
		}
		
		}
}

function chkunchk(objCheck)
{
	
	var index = 0;
	if(objCheck.checked==false)
	{
		parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.count.value; cnt++)
		{
			val = eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.ctrlChkBox.checked=true
		}
	}	
}

function scrollTitle1()
{
	//alert(parent.RecClinicalNotesLinkFutureApptResultFrame.RecClinicalNotesLinkFutureApptResultForm.name);
  var y = parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.RecClinicalNotesLinkFutureApptSelectedTextForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.RecClinicalNotesLinkFutureApptSelectedTextForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.RecClinicalNotesLinkFutureApptSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.RecClinicalNotesLinkFutureApptSelectedTextForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.RecClinicalNotesLinkFutureApptSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}
function selText(obj1)
{
	var return_format=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value;

	var result_linked_rec_type = parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_linked_rec_type.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var clearchkval='';
	var clearremval='';
	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.RecClinicalNotesLinkFutureApptSelectedTextForm.clear"+clearchkval+".value");
		var result_cat=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_cat.value;	
		
	 if(result_cat == 'APPT')
	   {
	 	parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureApptSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&remval="+encodeURIComponent(clearremval)+"&removebean=Y";
	   }
	 else if(result_cat == 'ORDR')
	    {
	  	parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureOrdSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&remval="+encodeURIComponent(clearremval)+"&removebean=Y";
		}
	 else if(result_cat == 'REFR')
		{
     	parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureReferralSelectedText.jsp?result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&return_format="+return_format+"&remval="+encodeURIComponent(clearremval)+"&removebean=Y";   
		}

		makeresultcheck(clearremval)

	}
	
}
function chgretn(Obj)
{

if(Obj.value == 't')
parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
else
parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value='';

}

function clearFormApprove()
{
	if(parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm != null)
	{
	var return_format=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value;

	var result_cat=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_cat.value;	

	var sec_hdg_code=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_linked_rec_type.value;

	 if(result_cat == 'APPT')
	   {
 	   parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.location = '../../eCA/jsp/RecClinicalNotesLinkFutureApptSelectedText.jsp?result_linked_rec_type='+result_linked_rec_type+'&sec_hdg_code='+sec_hdg_code+'&return_format='+return_format+'&flag=clear&ret_str=';
	   }else if(result_cat == 'ORDR')
	    {
		 parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.location = '../../eCA/jsp/RecClinicalNotesLinkFutureOrdSelectedText.jsp?result_linked_rec_type='+result_linked_rec_type+'&sec_hdg_code='+sec_hdg_code+'&return_format='+return_format+'&flag=clear&ret_str=';
		}
		else if(result_cat == 'REFR')
		{
        parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.location = '../../eCA/jsp/RecClinicalNotesLinkFutureReferralSelectedText.jsp?result_linked_rec_type='+result_linked_rec_type+'&sec_hdg_code='+sec_hdg_code+'&return_format='+return_format+'&flag=clear&ret_str=';
		}

	
	/*var obj = parent.RecClinicalNotesLinkFutureApptResultFrame.document.getElementById("chkbox");
	alert(obj.length);
	for(i=0;i<obj.length;i++)
	obj[i].checked = false;*/
	for(cnt=0; cnt<parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.chk_value"+cnt+".value");
						
            val.checked = false

	}

	parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.ctrlChkBox.checked=false
	}
	
}

function returnDataApprove()
{
	var dispResLinkHYMLYN = parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].dispResLinkHYMLYN.value; //IN061907
	//  MO_CRF_20102[IN055439] - Start
	//IN061907 start
	/*if(document.getElementById("chkt").checked) {
		//parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
	}*/
		if(dispResLinkHYMLYN == "Y")
		{
			if(parent.RecClinicalNotesLinkFutureApptSelectButtonsFrame.document.RecClinicalNotesLinkFutureApptSelectButtonsForm.chkl.checked) 
			{
				parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value='HTML';
			}
			else
			{
				parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
			}
		}
		else
		{
			if(parent.RecClinicalNotesLinkFutureApptSelectButtonsFrame.document.RecClinicalNotesLinkFutureApptSelectButtonsForm.chkl.checked) 
			{
				parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value='';
			}
			else
			{
				parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value='TEXT';
			}
		}
		//IN061907 ends
	//  MO_CRF_20102[IN055439] - End
	//var returnValue = parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.forms[0].temp.value;\
	if(parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.forms[0] != null)
	{
	var return_format=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value;
	//alert("return_format"+return_format);
	var returnValue='';
	
	
	if(return_format=="TEXTLINK")
	{
		returnValue=parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.forms[0].temp.value;
	}
	else if(return_format=="TEXT")
	{
		returnValue=parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.forms[0].temp.value;
		
	}
	else
	{
	var str = parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.document.getElementById("innerhtml").value;

	
	if(str==null || str == '' || str == " "){
		//returnValue='';	
	}else{
		str="<table  border='1'  cellpadding='0' cellspacing='0' width='100%'>"+str+"</table>";
	    returnValue=str;

	}
		
	}
	}
	
	if(returnValue=='')
     alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));
	//alert('APP-CA02000 Atleast one item should be selected...');
	else
	{		
	parent.window.returnValue=returnValue;
	parent.window.close();	
	}
	
}

function makeresultcheck(remval)
{
	
	for(cnt=0; cnt<parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.chk_value"+cnt+".value");

			
					
			if(strval==remval)
		{
				
				val.checked = false;
			
				parent.RecClinicalNotesLinkFutureApptResultFrame.document.RecClinicalNotesLinkFutureApptResultForm.ctrlChkBox.checked=false;

		}


	}


}

function showSearch()
{
	//if(checkPeriodFromTo())
	{
	var patient_id      = document.forms[0].patient_id.value;
	var encounter_id      = document.forms[0].encounter_id.value;
	var result_linked_rec_type = document.forms[0].result_linked_rec_type.value;
	var sec_hdg_code = document.forms[0].sec_hdg_code.value;
	var from_date_time	=	document.forms[0].txtFromDate.value;
	var to_date_time	=	document.forms[0].txtToDate.value; 
	
	
	var radio="";
	if (document.RecClinicalLinkFutureEventCriteriaForm.order(0).checked)
	radio=document.RecClinicalLinkFutureEventCriteriaForm.order(0).value;
	else
	radio=document.RecClinicalLinkFutureEventCriteriaForm.order(1).value;
	
	var result_cat          =   document.forms[0].result_cat.value;  
	var nature	            =   document.forms[0].nature.value;
	var result_cat=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_cat.value;	
	if(result_cat == 'APPT')
	{
	    parent.tree.cols="14%,86%";	parent.RecClinicalNotesLinkFutureApptResultFrame.location.href="../../eCommon/html/blank.html";
		parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCommon/html/blank.html";
	   	parent.RecClinicalNotesLinkFutureApptTreeFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkFutureApptTree.jsp?from_date="+from_date_time+"&to_date="+to_date_time+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type+"&order="+radio+"&result_cat="+result_cat+"&nature="+nature+"";
	}
	else if(result_cat == 'REFR')
	{
 	
	parent.tree.cols="0%,100%";
 	parent.RecClinicalNotesLinkFutureApptResultFrame.location.href="../../eCommon/html/blank.html";
    parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCommon/html/blank.html";
	parent.RecClinicalNotesLinkFutureApptTreeFrame.location.href ="../../eCommon/html/blank.html";

	var rfrdFromDate          =   document.forms[0].rfrdFromDate.value; 
	var rfrdToDate          =   document.forms[0].rfrdToDate.value; 

	   
   /*	parent.RecClinicalNotesLinkFutureApptTreeFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkFutureReferralTree.jsp?from_date="+from_date_time+"&to_date="+to_date_time+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type+"&order="+radio+"&result_cat="+result_cat+"&nature="+nature+""; */

   parent.RecClinicalNotesLinkFutureApptResultFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureReferralResult.jsp?from_date="+from_date_time+"&to_date="+to_date_time+"&rfrdFromDate="+rfrdFromDate+"&rfrdToDate="+rfrdToDate+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&order="+radio+"&result_cat="+result_cat+"&nature="+nature+"";
	}
	else if(result_cat == 'ORDR')
	{
    parent.tree.cols="14%,86%";	parent.RecClinicalNotesLinkFutureApptResultFrame.location.href="../../eCommon/html/blank.html";
    parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCommon/html/blank.html";
   	parent.RecClinicalNotesLinkFutureApptTreeFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkFutureOrdTree.jsp?from_date="+from_date_time+"&to_date="+to_date_time+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type+"&order="+radio+"&result_cat="+result_cat+"&nature="+nature+"";
	}

	}
}
function clearClick()
{	

var patient_id=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].patient_id.value;	
var return_format=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].return_format.value;	
var encounter_id=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].encounter_id.value;	
var result_linked_rec_type=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_linked_rec_type.value;	
parent.RecClinicalNotesLinkFutureApptTreeFrame.location.href="../../eCommon/html/blank.html";
parent.RecClinicalNotesLinkFutureApptResultFrame.location.href="../../eCommon/html/blank.html";
parent.RecClinicalNotesLinkFutureApptSelectedTextFrame.location.href="../../eCommon/html/blank.html"
;
parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
parent.RecClinicalNotesLinkFutureApptSelectButtonsFrame.document.getElementById("select").disabled=true;
parent.RecClinicalNotesLinkFutureEventCriteriaFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureEventCriteria.jsp?patient_id="+patient_id+"&return_format="+return_format+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type;
}	



function call_resultord(val,link)
{
var patient_id=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].patient_id.value;
var sec_hdg_code=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].sec_hdg_code.value;
var result_linked_rec_type=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].result_linked_rec_type.value;

var nature=parent.RecClinicalNotesLinkFutureApptTreeFrame.document.forms[0].nature.value;
var order=parent.RecClinicalNotesLinkFutureApptTreeFrame.document.forms[0].order.value;
parent.RecClinicalNotesLinkFutureApptResultFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureOrdResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&val="+encodeURIComponent(val)+"&link="+link+"&patient_id="+patient_id+"&nature="+nature+"&order="+order;
}

function checkDateWithCurrentDateTime(toDateTime)
{
	var toDate = toDateTime.split(" ");
	var toarray = toDate[0].split("/");
	var enteredDate = new Date(toarray[2],toarray[1],toarray[0]);
	
	var today = new Date();
	var date= today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getYear();
	today = new Date(year,month,date);
	//alert('enteredDate'+enteredDate);
	//alert('today'+today);
	if(enteredDate >= today)
	{
		return true;
	}
	return false;
}

function call_resultref(val,link)
{
var patient_id=parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.forms[0].patient_id.value;
var nature=parent.RecClinicalNotesLinkFutureApptTreeFrame.document.forms[0].nature.value;
var order=parent.RecClinicalNotesLinkFutureApptTreeFrame.document.forms[0].order.value;
parent.RecClinicalNotesLinkFutureApptResultFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkFutureReferralResult.jsp?val="+encodeURIComponent(val)+"&link="+link+"&patient_id="+patient_id+"&nature="+nature+"&order="+order;
}

function resCatChange(obj)
{
	
	if(obj.value=="REFR")
	{
		parent.event1.rows="26%,*,3%";
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("dateNormal").style.display = "none";
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("dateToNormal").style.display = "none";
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("datePrefer").style.display = "inline";
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("dateToPrefer").style.display = "inline";
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("rfrdDate").style.display = "inline";
	}
	else
	{
		parent.event1.rows="20%,*,3%";
		
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("dateNormal").style.display = "inline";
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("dateToNormal").style.display = "inline";
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("datePrefer").style.display = "none";
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("dateToPrefer").style.display = "none";
		parent.RecClinicalNotesLinkFutureEventCriteriaFrame.document.getElementById("rfrdDate").style.display = "none";

	}

}

