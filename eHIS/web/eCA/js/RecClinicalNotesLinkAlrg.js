/*
-----------------------------------------------------------------------
Date       		Edit History      Name        	Description
-----------------------------------------------------------------------
?             	100            ?           	 created
28/11/2014		IN052716		Ramesh G		Result Link In Template Based Section In  Clinical Notes For ?Table? And ?Text?.
24/05/2016	  	IN055439		 Karthi L		MO_CRF_20102
31/03/2017	IN061907	Krishna Gowtham J							ML-MMOH-CRF-0559
-----------------------------------------------------------------------

*/
function clearClick()
{	
var patient_id=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].patient_id.value;	
var return_format=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value;	
var encounter_id=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].encounter_id.value;	
var result_linked_rec_type=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].result_linked_rec_type.value;	
parent.RecClinicalNotesLinkAlrgCriteriaFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkAlrgCriteria.jsp?patient_id="+patient_id+"&return_format="+return_format+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type;
}


function checkIsNull(obj)
{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
}

function aligntable(index)
{
	//alert("index"+index);
	//var totalRows =  document.getElementById("tableData").length;
	//alert(document.getElementById("third0").rows.length);
	if(document.getElementById("third0"))
	{
		document.getElementById("record").width=eval(document.getElementById("third0").offsetWidth);
		document.getElementById("finalDiv").width=eval(document.getElementById("third0").offsetWidth);
			
	}
	/*else
	{
		//alert("else");
		document.getElementById("first").width=eval(document.getElementById("record").offsetWidth);
	}*/
	//alert("totalRows"+totalRows);
	/*var counter = totalRows-1;
	var temp = top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("dataTitleTable").rows(0).cells.length;
	for(var i=0;i<temp;i++) {
		top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("dataTitleTable").rows(0).cells(i).width=top.content.workAreaFrame.ResearchPatientQueryframe.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
	}*/


	//alert(colspan)
	/*var colwidth=98/colspan;
	var temp = colspan;
	//for(var i=0;i<temp;i++) 
	//{
		alert(document.getElementById("record").rows(0).cells(1).width);
		document.getElementById("record").rows(0).cells(1).width=colwidth+'%';
		alert(document.getElementById("record").rows(0).cells(1).width);
		document.getElementById("record").rows(0).cells(3).width=colwidth+'%';
		alert(document.getElementById("record").rows(0).cells(3).width);		
	//}
//record*/
//document.getElementById("first").offsetWidt=document.getElementById("record").offsetWidth;
//document.getElementById("first")[0].cells(0).width=document.getElementById("record").rows(0).cells(0).offsetWidth;
//document.getElementById("first")[0].cells(1).width=document.getElementById("record").rows(0).cells(1).offsetWidth;
//document.getElementById("first")[0].cells(2).width=document.getElementById("record").rows(0).cells(2).offsetWidth;
//document.getElementById("first")[0].cells(3).width=document.getElementById("record").rows(0).cells(3).offsetWidth;
//document.getElementById("inner").offsetWidth=document.getElementById("record").offsetWidth
//alert(document.getElementById("first")[0].cells.length);
//alert(document.getElementById("first")[0].cells(2).width);


	
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

/*
function checkPeriodFromTo()
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

function checkPeriodFromTo(fromDate,toDate,currDate,format,locale)
{
	if(checkIsNull(fromDate)==false)

	if(!doDateTimeChk(fromDate))
	{
		alert(getMessage("INVALID_DATE_TIME","CA"));
		fromDate.select();
		fromDate.focus();
		return false;
	}

	if(checkIsNull(toDate)==false)
	
	if(!doDateTimeChk(toDate)) 
	{
		alert(getMessage("INVALID_DATE_TIME","CA"));
		toDate.select();
		toDate.focus();
		return false;
	}
	
	if( (!fromDate.value=="") && (!toDate.value=="") )
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
}


function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}
function populateAllergyItem()
{
	
	var length  =parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.allergy_item.length;	
			
			for(i=1;i<length;i++)
			{
			  parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.allergy_item.remove(1);
			}

		var allergy_type     = document.forms[0].allergy_type.value;
		
		HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../../eCA/jsp/RecClinicalNotesLinkAlrgPopulate.jsp'><input type=hidden name='allergy_type' id='allergy_type' value='"+allergy_type+"'></form></body></html>";
		parent.messageFrameReference.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrameReference.document.dummy_form1.submit();
		
}

function showSearchLinkResult()
{
	
	var patient_id      = parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.patient_id.value;
	
	var encounter_id      = document.RecClinicalLinkAlrgCriteriaForm.encounter_id.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.result_linked_rec_type.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.sec_hdg_code.value;
	
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time	=	document.forms[0].to_date_time.value;
	
	var radio="";

	if (parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.status[0].checked)
	radio=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.status[0].value;
	else
	radio=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.status[1].value;
	
	
	
	
	
	var allergy_type	=document.forms[0].allergy_type.value;
	//var allergy_item	=	document.forms[0].allergy_item.value;
	//var search_criteria	=	document.forms[0].search_criteria.value;
	var order_by1	=	document.forms[0].order_by1.value;
	var order_by2	=	document.forms[0].order_by2.value;
	var url="../../eCA/jsp/RecClinicalNotesLinkAlrgResult.jsp?from_date_time="+escape(from_date_time)+"&to_date_time="+escape(to_date_time)+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type+"&status="+radio+"&allergy_type="+allergy_type+"&order_by1="+order_by1+"&order_by2="+order_by2+"&sec_hdg_code="+sec_hdg_code;
			
	parent.RecClinicalNotesLinkAlrgResultFrame.location.href =url ;
}



function ReassaignAlrg(obj)
{
	parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.RecClinicalNotesLinkAlrgSelectButtonsForm.select.disabled=false;
	  var return_format=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value;	
	  var count=document.getElementById("count").value;	
	  var chkcount=document.getElementById("chkcount").value;	
	  var patient_id=document.getElementById("patient_id").value;	
	  var from_date_time=document.getElementById("from_date_time").value;	
	  var to_date_time=document.getElementById("to_date_time").value;	
	  var status1=document.getElementById("status1").value;	
	  var allergy_class=document.getElementById("allergy_class").value;	
	  var allergy_item=document.getElementById("allergy_item").value;	
	  var order_by1=document.getElementById("order_by1").value;	
	  var order_by2=document.getElementById("order_by2").value;	
	  var rowids =	 document.getElementById("finalString").value;
	  var sec_hdg_code =	 document.getElementById("sec_hdg_code").value;
	  var result_linked_rec_type =	 document.getElementById("result_linked_rec_type").value;

	   var ret_str='';
	  var rows= rowids.split(",");
	  		

for(i=0;i<chkcount;i++)
{
 //alert(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ret_value"+i+".value"));
 // if(obj.checked)
	
reccount=eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+i).value;
		//alert(reccount);
		if(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chkbox"+i+".checked")==true)
	{
		//alert(rows[i]);

var chkval = obj.value;
if((i+1)<chkcount)
		{
if((eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+(i+1)).value)-(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+i).value)>1)
		{
		for(s=((eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+i).value)-1);s<((eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+(i+1)).value)-1);s++)
			{
						 ret_str+=trimString(rows[s])+"','";
			}
		}else
		{
		
			 ret_str+=trimString(rows[(reccount-1)])+"','"; 
		}
	}
	else
		{
		
		for(h=(reccount-1);h<((rows.length));h++)
		ret_str+=trimString(rows[h])+"','"; 
		}
	}
	
 }
	 
	//alert("ret_str"+ret_str);
	parent.RecClinicalNotesLinkAlrgSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?patient_id="+patient_id+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&status1="+status1+"&allergy_class="+allergy_class+"&allergy_item="+allergy_item+"&order_by1="+order_by1+"&order_by1="+order_by1+"&order_by2="+order_by2+"&ret_str="+encodeURIComponent(ret_str,"UTF-8")+"&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type;
 	   
 // alert(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.row_value"+chkval+".value"));
	//if(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ret_value"+i+".value"))
	//{
	//}


	/*if(obj.checked)
	{
		var chkval = obj.value;
		 //ret_str=parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chk_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ret_value0.value")+"@";
		
		alert("ret_str======="+ret_str)
		parent.RecClinicalNotesLinkAlrgSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?return_format="+return_format+"&ret_str="+encodeURIComponent(ret_str,"UTF-8")+"";
		parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.RecClinicalNotesLinkAlrgSelectButtonsForm.select.disabled=false;
	
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chk_value"+chkval+".value")
			//alert("remval"+remval);
			//parent.ret_str=parent.ret_str+parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ret_value[parseInt(remval)].value+"@";
			parent.RecClinicalNotesLinkAlrgSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?return_format="+return_format+"&remval="+escape(remval)+"&ret_str="+encodeURIComponent(ret_str,"UTF-8")+"&removebean=Y";
			
		}	  */
}

	function ReassaignAlrg1(obj)
 {
	
	parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.RecClinicalNotesLinkAlrgSelectButtonsForm.select.disabled=false;
	  var return_format=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value;	
	  var count=document.getElementById("count").value;	
	  var chkcount=document.getElementById("chkcount").value;	
	  var patient_id=document.getElementById("patient_id").value;	
	  var from_date_time=document.getElementById("from_date_time").value;	
	  var to_date_time=document.getElementById("to_date_time").value;	
	  var status1=document.getElementById("status1").value;	
	  var allergy_class=document.getElementById("allergy_class").value;	
	  var allergy_item=document.getElementById("allergy_item").value;	
	  var order_by1=document.getElementById("order_by1").value;	
	  var order_by2=document.getElementById("order_by2").value;	
	  var rowids =	 document.getElementById("finalString").value;
	   var ret_str='';
	  var rows= rowids.split(",");
		

for(i=0;i<chkcount;i++)
{
			
  //alert(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ret_value"+i+".value"));
 // if(obj.checked)
	
	if(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chkbox"+i+".checked")==true)
	{
		//alert(rows[i]);
		var chkval = obj.value;
		 //ret_str=parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chk_value[parseInt(chkval)].value+"@";
		//ret_str=eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ret_value0.value")+"@";
		
		//alert("chkval======="+chkval)

		//alert(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.row_value"+chkval+".value"));
		
			
			 ret_str+=trimString(rows[i])+"','"; 
	}
	
 }
	 
	//alert("ret_str======="+ret_str)
		 parent.RecClinicalNotesLinkAlrgSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?patient_id="+patient_id+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&status1="+status1+"&allergy_class="+allergy_class+"&allergy_item="+allergy_item+"&order_by1="+order_by1+"&order_by1="+order_by1+"&order_by2="+order_by2+"&ret_str="+encodeURIComponent(ret_str,"UTF-8")+"";
 	   
 // alert(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.row_value"+chkval+".value"));
	//if(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ret_value"+i+".value"))
	//{
	//}


	/*if(obj.checked)
	{
		var chkval = obj.value;
		 //ret_str=parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.chk_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ret_value0.value")+"@";
		
		alert("ret_str======="+ret_str)
		parent.RecClinicalNotesLinkAlrgSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?return_format="+return_format+"&ret_str="+encodeURIComponent(ret_str,"UTF-8")+"";
		parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.RecClinicalNotesLinkAlrgSelectButtonsForm.select.disabled=false;
	
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chk_value"+chkval+".value")
			//alert("remval"+remval);
			//parent.ret_str=parent.ret_str+parent.RecClinicalNotesLinkMedResultFrame.document.RecClinicalNotesLinkMedResultForm.ret_value[parseInt(remval)].value+"@";
			parent.RecClinicalNotesLinkAlrgSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?return_format="+return_format+"&remval="+escape(remval)+"&ret_str="+encodeURIComponent(ret_str,"UTF-8")+"&removebean=Y";
			
		}	  */
}



function selText(obj1)
{
  	var return_format=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value;	

	var clearchkval='';
	var clearremval='';
	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.RecClinicalNotesLinkAlrgSelectedTextFrame.document.RecClinicalNotesLinkAlrgSelectedTextForm.clear"+clearchkval+".value");

		parent.RecClinicalNotesLinkAlrgSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?return_format="+return_format+"&remval="+encodeURIComponent(clearremval,"UTF-8")+"&removebean=Y";
		makeresultcheck(clearremval)

	}
}
function makeresultcheck(remval)
{
	//alert("375");
	for(cnt=0; cnt<parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chk_value"+cnt+".value");
					
			if(strval==remval)
            val.checked = false

	}

}

function perform(ctrlChkBoxObj)
{
	  
	parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.RecClinicalNotesLinkAlrgSelectButtonsForm.select.disabled=false;
	  var count=document.getElementById("count").value;	
	  var chkcount=document.getElementById("chkcount").value;	
	  var patient_id=document.getElementById("patient_id").value;	
	  var from_date_time=document.getElementById("from_date_time").value;	
	  var to_date_time=document.getElementById("to_date_time").value;	
	  var status1=document.getElementById("status1").value;	
	  var allergy_class=document.getElementById("allergy_class").value;	
	  var allergy_item=document.getElementById("allergy_item").value;	
	  var order_by1=document.getElementById("order_by1").value;	
	  var order_by2=document.getElementById("order_by2").value;
	  var rowids =	 document.getElementById("finalString").value;
	  var ret_str='';
	  var rows= rowids.split(",");

	  var result_linked_rec_type = parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.result_linked_rec_type.value;
	  
	  var sec_hdg_code = parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.sec_hdg_code.value;

	/*alert(rows.length);
	for(j=0;j<rows.length;j++)
	{
		alert("408"+rows[j]);
	}*/
	//var return_format=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value;	
	
	var val ="";
	var retstr2="";
    var strval="";
	parent.messageFrameReference.location.href="../../eCommon/html/blank.html"
	if(ctrlChkBoxObj.checked==true)
	{
		
		for(cnt=0; cnt<document.getElementById("chkcount").value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chkbox"+cnt);
			reccount=eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+cnt).value;
		
			if(!val.checked)
			{
				val.checked = true;
			 }
			if(val.checked)
			{
				if((cnt+1)<chkcount)
				{
					if((eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+(cnt+1)).value)-(eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+cnt).value)>1)
					{
						for(s=((eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+cnt).value)-1);s<((eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.checking_value"+(cnt+1)).value)-1);s++)
						{
							ret_str+=trimString(rows[s])+"','";
						}
					}else
					{
		
						 ret_str+=trimString(rows[(reccount-1)])+"','"; 
					}
		}
		else
		{
			//ret_str+=trimString(rows[(reccount-1)])+"','"; 
			for(h=(reccount-1);h<((rows.length));h++)
			ret_str+=trimString(rows[h])+"','"; 
		}
				//ret_str+=trimString(rows[cnt])+"','"; 
	            //strval=eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ret_value"+cnt);
				//retstr2 = retstr2 + strval.value+"','";
				 retstr2=ret_str;
			}
		}
	
		//alert("retstr2===="+retstr2);
		
		parent.RecClinicalNotesLinkAlrgSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&patient_id="+patient_id+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&status1="+status1+"&allergy_class="+allergy_class+"&allergy_item="+allergy_item+"&order_by1="+order_by1+"&order_by1="+order_by1+"&order_by2="+order_by2+"&ret_str="+encodeURIComponent(retstr2,"UTF-8")+"";
		/*HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'></form>";
		parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		
		parent.messageFrameReference.document.dummy_form.target = "RecClinicalNotesLinkAlrgSelectedTextFrame";
		parent.messageFrameReference.document.dummy_form.submit();  */
		//parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.RecClinicalNotesLinkAlrgSelectButtonsForm.select.disabled=false;
		
	}
	
	else
	{
		parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.RecClinicalNotesLinkAlrgSelectButtonsForm.select.disabled=false;
		for(cnt=0; cnt<document.getElementById("chkcount").value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chkbox"+cnt);
			val.checked = false;
		}
		
		parent.RecClinicalNotesLinkAlrgSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&flag=clear&ret_str=";
	}


}

function chkunchk(objCheck)
{
	var index = 0;
	if(objCheck.checked==false)
	{
		
		parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ctrlChkBox.checked=false
	}
	else
	{
		
		for(cnt=0; cnt<parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.count.value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ctrlChkBox.checked=true
		}
	}	
}



function scrollTitle1()
{
	
  var y = parent.RecClinicalNotesLinkAlrgSelectedTextFrame.RecClinicalNotesLinkAlrgSelectedTextForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkAlrgSelectedTextFrame.RecClinicalNotesLinkAlrgSelectedTextForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkAlrgSelectedTextFrame.RecClinicalNotesLinkAlrgSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkAlrgSelectedTextFrame.RecClinicalNotesLinkAlrgSelectedTextForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkAlrgSelectedTextFrame.RecClinicalNotesLinkAlrgSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}
function scrollTitle()
{
	
  var y = parent.RecClinicalNotesLinkAlrgResultFrame.RecClinicalNotesLinkAlrgResultForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkAlrgResultFrame.RecClinicalNotesLinkAlrgResultForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkAlrgResultFrame.RecClinicalNotesLinkAlrgResultForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.parent.RecClinicalNotesLinkAlrgResultFrame.RecClinicalNotesLinkAlrgResultForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.parent.RecClinicalNotesLinkAlrgResultFrame.RecClinicalNotesLinkAlrgResultForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}


//Functions for the file name RecClinicalNotesLinkAlrgSelectButtons.jsp-start

function clearFormApprove()
{
	if(parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm!=null)
	{
	  var obj=	 parent.RecClinicalNotesLinkAlrgResultFrame;
	  var chkcount=obj.document.getElementById("chkcount").value;	
	  var patient_id=obj.document.getElementById("patient_id").value;	
	  var from_date_time=obj.document.getElementById("from_date_time").value;	
	  var to_date_time=obj.document.getElementById("to_date_time").value;	
	  var status1=obj.document.getElementById("status1").value;	
	  var allergy_class=obj.document.getElementById("allergy_class").value;	
	  var allergy_item=obj.document.getElementById("allergy_item").value;	
	  var order_by1=obj.document.getElementById("order_by1").value;	
	  var order_by2=obj.document.getElementById("order_by2").value;
	  var rowids =	 obj.document.getElementById("finalString").value;
	  var ret_str='';
	  var rows= rowids.split(",");

	  var result_linked_rec_type = parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.result_linked_rec_type.value;
	  
	  var sec_hdg_code = parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.RecClinicalLinkAlrgCriteriaForm.sec_hdg_code.value;

	if(parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm != null)
	{
	var return_format=parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value;	
	parent.RecClinicalNotesLinkAlrgSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkAlrgSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&flag=clear&ret_str=";
	
	/*var obj = parent.RecClinicalNotesLinkMedResultFrame.document.getElementById("chkbox");
	alert(obj.length);
	for(i=0;i<obj.length;i++)
	obj[i].checked = false;*/
	for(cnt=0; cnt<parent.RecClinicalNotesLinkAlrgResultFrame.document.getElementById("chkcount").value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.chkbox"+cnt);
			ret_str+=trimString(rows[cnt])+"','"; 
						
            val.checked = false

	}

	parent.RecClinicalNotesLinkAlrgResultFrame.document.RecClinicalNotesLinkAlrgResultForm.ctrlChkBox.checked=false
	}

	}
	
}

function returnDataApprove()
{
	var dispResLinkHYMLYN = parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].dispResLinkHYMLYN.value; //IN061907
	//  MO_CRF_20102[IN055439] - Start
	//IN061907 start
	/*if(document.getElementById("chkt").checked) {
		
		//parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
	}*/
	if(dispResLinkHYMLYN == "Y")
	{
		if(parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.RecClinicalNotesLinkAlrgSelectButtonsForm.chkl.checked) 
		{
			parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value='HTML';
		}
		else
		{
			parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
		}
	}
	else
	{
		if(parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.RecClinicalNotesLinkAlrgSelectButtonsForm.chkl.checked) 
		{
			parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value='';
		}
		else
		{
			parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value='TEXT';
		}
	}
	//IN061907 ends
	//  MO_CRF_20102[IN055439] - End	
if(document.getElementById("returnformat").value!="TEXT")
	{
	var radio="";

	 if(parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.forms[0].format(0).checked==true)
	 radio=parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.forms[0].format(0).value;
	 else
	   radio=parent.RecClinicalNotesLinkAlrgSelectButtonsFrame.document.forms[0].format(1).value;

	  if(radio=="t")
		return_format="TEXTLINK";
	  else
	   return_format="table";
	}
	else
	{
		return_format="TEXT";
	}
	
	//alert("return_format"+return_format);
	var returnValue='';
	
	if(return_format=="TEXTLINK")
	{
		//IN052716 Start
		//returnValue=parent.RecClinicalNotesLinkAlrgSelectedTextFrame.document.getElementById("temp1").value;
		var str = parent.RecClinicalNotesLinkAlrgSelectedTextFrame.document.getElementById("innertext").value;
		var str_header = parent.RecClinicalNotesLinkAlrgSelectedTextFrame.document.getElementById("innertext_header").value;
		
		if(str!=null || str != '' || str != " "){			
		
			if(str_header==null || str_header == '' || str_header == " ")
			{
				
				str="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel('Common.EventType.label','common')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel('eMR.Allergen.label','MR')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel('Common.onsetdate.label','common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel('Common.status.label','common')+"</b></td></tr>"+str+"</table>";
			}
			else
			{
				str= str_header+" "+str+"</table>";
			}
		    returnValue=str;
		}
		//IN052716 End.
	}
	
	else if(return_format=="TEXT")
	{
		returnValue=parent.RecClinicalNotesLinkAlrgSelectedTextFrame.document.getElementById("temp").value;
		
	}
	else
	{
	
	var str = parent.RecClinicalNotesLinkAlrgSelectedTextFrame.document.getElementById("innerhtml").value;
	var str_header = parent.RecClinicalNotesLinkAlrgSelectedTextFrame.document.getElementById("innerhtml_header").value;
	//alert('str_header...'+str_header);

	if(str==null || str == '' || str == " "){
		//returnValue='';	
	}
	else
		{
		
	if(str_header==null || str_header == '' || str_header == " ")
	{
		
		str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel('Common.EventType.label','common')+"</b></td><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel('eMR.Allergen.label','MR')+"</b></td><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel('Common.onsetdate.label','common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel('Common.status.label','common')+"</b></td></tr>"+str+"</table>";
	}
	else
	{
		str= str_header+" "+str+"</table>";
	}
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

function chgretn(Obj)
{

if(Obj.value == 't')
parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
else
parent.RecClinicalNotesLinkAlrgCriteriaFrame.document.forms[0].return_format.value='';

}
function performonload()
{
	//perform(document.getElementById("ctrlChkBox"));
}
//Functions for the file name RecClinicalNotesLinkAlrgSelectButtons.jsp-end

function alignWidth()
{
	if(document.getElementById("record")!=null)
	{
				
	}
		
}

