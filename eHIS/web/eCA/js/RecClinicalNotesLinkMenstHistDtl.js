/*
---------------------------------------------------------------------------------------------------------------
Date		 Edit History	   Name			  Rev.Date	           Rev.Name	           	Description
---------------------------------------------------------------------------------------------------------------
22/10/2024	 70704	   Gunasekar R	 22/10/2024	    Ashwini Ragupathi          ML-MMOH-CRF-1759
---------------------------------------------------------------------------------------------------------------
*/

String.prototype.replaceAll=function(s1, s2) {return this.split(s1).join(s2)}
function Clear_Allnew()
{
	parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.reset();
}


function showCalendarValidate(str){
			var flg = showCalendar(str,null,null);
			document.getElementById(str).focus();
			return flg;
}

function funSearchnew()
{
	parent.messageFrameReference.location.href="../../eCommon/html/blank.html";
	var patient_id = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.patient_id.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.result_linked_rec_type.value;
	var p_from_date = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.from_date_time.value;
	var p_to_date = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.to_date_time.value;

	var event_status_a = "";
	var event_status_ac = "";
	var event_status_c = "";
	if(parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.event_status_a.checked==true)
	event_status_a = "A";
		
	if(parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.event_status_ac.checked==true)
	event_status_ac = "AC";
		
	if(parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.event_status_c.checked==true)
	event_status_c = "C";
		
	if(event_status_a=="" && event_status_ac=="" && event_status_c==""){
		alert(getMessage("AT_LEAST_ONE_EVENT_SELECT","CA"));
		parent.RecClinicalNotesLinkMenstResultFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMenstResult.jsp?eveStsAllUnchecked=Y";
		parent.RecClinicalNotesLinkMenstSelectedTextFrame.location.href="../../eCommon/html/blank.html";
	return;}
	
	var event_type="";

	if (parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.event_type(0).checked)
	event_type=parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.event_type(0).value;
	else
	event_type=parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.event_type(1).value;	

	var order_by = "";
	if(parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.order_by(0).checked)
    order_by = "A";
	else
    order_by = "D";
     
	var htmlVal = "";

	parent.RecClinicalNotesLinkMenstSelectedTextFrame.location.href="../../eCommon/html/blank.html";
	htmlVal = "<form name=tempForm3 id=tempForm3 method=post target= RecClinicalNotesLinkMenstResultFrame action='../../eCA/jsp/RecClinicalNotesLinkMenstResult.jsp'><input type=hidden name=patient_id id=patient_id value='"+patient_id+"'><input type=hidden name=sec_hdg_code id=sec_hdg_code value='"+sec_hdg_code+"'><input type=hidden name=result_linked_rec_type id=result_linked_rec_type value='"+result_linked_rec_type+"'><input type=hidden name=result_sub_category id=result_sub_category value='"+event_type+"'><input type=hidden name=event_status_a id=event_status_a value='"+event_status_a+"'><input type=hidden name=event_status_ac id=event_status_ac value='"+event_status_ac+"'><input type=hidden name=event_status_c id=event_status_c value='"+event_status_c+"'><input type=hidden name=p_from_date id=p_from_date value='"+p_from_date+"'><input type=hidden name=p_to_date id=p_to_date value='"+p_to_date+"'><input type=hidden name=order_by id=order_by value='"+order_by+"'></form>"
	parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',htmlVal);           
	parent.messageFrameReference.document.tempForm3.submit();
}
 

var ret_str='';
function Reassaign(obj)
{
	var return_format=parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code=parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type=parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].result_linked_rec_type.value;
	var result_sub_category=parent.RecClinicalNotesLinkMenstResultFrame.document.forms[0].result_sub_category.value;

	if(obj.checked)
	{
		var chkval = obj.value;
			
		ret_str=eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.ret_value"+chkval+".value")+"�";
			if(result_sub_category == 'LMP'){
				parent.RecClinicalNotesLinkMenstSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMenstLmpSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&ret_str="+ret_str+"&result_sub_category="+result_sub_category+"";
			}
			else if(result_sub_category == 'USOD'){
				parent.RecClinicalNotesLinkMenstSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMenstUsodSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&ret_str="+ret_str+"&result_sub_category="+result_sub_category+"";
			}
		parent.RecClinicalNotesLinkMenstSelectButtonsFrame.document.RecClinicalNotesLinkMenstSelectButtonsForm.select.disabled=false;
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.chk_value"+chkval+".value")
			if(result_sub_category == 'LMP'){
				parent.RecClinicalNotesLinkMenstSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMenstLmpSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&remval="+encodeURIComponent(remval,"UTF-8")+"&ret_str="+ret_str+"&removebean=Y"+"&result_sub_category="+result_sub_category;
				}
			if(result_sub_category == 'USOD'){
				parent.RecClinicalNotesLinkMenstSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMenstUsodSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&remval="+encodeURIComponent(remval,"UTF-8")+"&ret_str="+ret_str+"&removebean=Y"+"&result_sub_category="+result_sub_category;
				}
		}	
}

function chkunchk(objCheck)
{
	var index = 0;
	if(objCheck.checked==false)
	{
		parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.count.value; cnt++)
		{
			val = eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.ctrlChkBox.checked=true
		}
	}	
}

function perform(ctrlChkBoxObj)
{
	var return_format=parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].result_linked_rec_type.value;
	var result_sub_category=parent.RecClinicalNotesLinkMenstResultFrame.document.forms[0].result_sub_category.value;
	var val ="";
	var retstr2="";
    var strval="";
    
	parent.messageFrameReference.location.href="../../eCommon/html/blank.html"
	if(ctrlChkBoxObj.checked==true)
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.count.value; cnt++)
		{
			val = eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.chkbox"+cnt);
			if(!val.checked)
            {
				val.checked = true;
            strval=eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"�";
			}

		}
	
		if(result_sub_category == 'LMP')
		{
			HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkMenstLmpSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'><input type=hidden name='result_sub_category' id='result_sub_category' value='"+result_sub_category+"'></form>";
			parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		}
		else if(result_sub_category == 'USOD')
		{
			HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkMenstUsodSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'><input type=hidden name='result_sub_category' id='result_sub_category' value='"+result_sub_category+"'></form>";
			parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
			}

		parent.messageFrameReference.document.dummy_form.target = "RecClinicalNotesLinkMenstSelectedTextFrame";
		parent.messageFrameReference.document.dummy_form.submit();
        parent.RecClinicalNotesLinkMenstSelectButtonsFrame.document.RecClinicalNotesLinkMenstSelectButtonsForm.select.disabled=false;
	 } 
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.count.value; cnt++)
		{
			val = eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.chkbox"+cnt);
			val.checked = false;
			strval=eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"�";
		}
		if(result_sub_category == 'LMP'){
			parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkMenstLmpSelectedText.jsp?sec_hdg_code=&result_linked_rec_type=&return_format=&flag=clear&ret_str=";
			}
			else if(result_sub_category == 'USOD'){
				parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkMenstUsodSelectedText.jsp?sec_hdg_code=&result_linked_rec_type=&return_format=&flag=clear&ret_str=";
			}
		}
}


function selText(obj1)
{
	var return_format=parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].result_linked_rec_type.value;
	var result_sub_category=parent.RecClinicalNotesLinkMenstResultFrame.document.forms[0].result_sub_category.value;

	var clearchkval='';
	var clearremval='';
	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.RecClinicalNotesLinkMenstSelectedTextForm.clear"+clearchkval+".value");
		if(result_sub_category == 'LMP'){
		parent.RecClinicalNotesLinkMenstSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMenstLmpSelectedText.jsp?return_format="+return_format+"&remval="+encodeURIComponent(clearremval,"UTF-8")+"&removebean=Y&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&result_sub_category="+result_sub_category;
		}
		else if(result_sub_category == 'USOD'){
	 	parent.RecClinicalNotesLinkMenstSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkMenstUsodSelectedText.jsp?return_format="+return_format+"&remval="+encodeURIComponent(clearremval,"UTF-8")+"&removebean=Y&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&result_sub_category="+result_sub_category;
		}
		makeresultcheck(clearremval)
	}
}
function makeresultcheck(remval)
{	
	for(cnt=0; cnt<parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.chk_value"+cnt+".value");
					
			if(strval==remval)
			{
			val.checked = false
			parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.ctrlChkBox.checked = false 
			}
	} 
}
	

function returnDataApprove()
{
		var dispResLinkHYMLYN = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].dispResLinkHYMLYN.value;
		if(dispResLinkHYMLYN == "Y")
		{
			if(parent.RecClinicalNotesLinkMenstSelectButtonsFrame.document.RecClinicalNotesLinkMenstSelectButtonsForm.chkl.checked) 
			{
				parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value='HTML';
			}
			else
			{
				parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
			}
		}
		else
		{
			if(parent.RecClinicalNotesLinkMenstSelectButtonsFrame.document.RecClinicalNotesLinkMenstSelectButtonsForm.chkl.checked) 
			{
				parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value='';
			}
			else
			{
				parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value='TEXT';
			}
		}
	var str = parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.getElementById('innerhtml').value;
	var str_header = parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.getElementById('innerhtml_header').value;
	var result_sub_category=parent.RecClinicalNotesLinkMenstResultFrame.document.forms[0].result_sub_category.value;
	var return_format=parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value;
	var returnValue='';
	if(return_format=="TEXTLINK")
	{
		var strtext = parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.getElementById('innertext').value;
		var strtext_header = parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.getElementById('innertext_header').value;
		
		if(strtext!=null || strtext != '' || strtext!= " "){
			if(result_sub_category == 'LMP')
			{ 
				if(strtext_header==null || strtext_header == '' || strtext_header == " ")
				{ 

				strtext="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel("eCA.LMP.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.EDD.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.GestationPOA.label",'ca')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel("eCA.DeliveryDate.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.MiscarriageDate.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.Remarks.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.EventStatus.label",'ca')+"</td></tr>"+strtext+"</table>";
				}
				else
				{
					strtext= strtext_header+" "+strtext+"</table>";
				}
				
			}
			else
			{
			if(strtext_header==null || strtext_header == '' || strtext_header == " ")
			{
			    strtext="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel("eCA.ScanGestation.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.LMP.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.REDD.label",'ca')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel("eCA.GestationPOG.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.DeliveryDate.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.MiscarriageDate.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.Remarks.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.EventStatus.label",'ca')+"</b></td></tr>"+strtext+"</table>";

			}
			else
			{
				strtext= strtext_header+" "+strtext+"</table>";
			}
		}     
			returnValue=strtext;
			returnValue=encodeURIComponent(returnValue,"UTF-8");
		}
	}
	else if(return_format=="TEXT")
	{
		returnValue=encodeURIComponent(parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.getElementById('finalDiv1').innerText,"UTF-8");
	}
	else
	{

	if(str==null || str == '' || str == " "){
		//returnValue='';	
	}
	else
		{
		   if(result_sub_category == 'LMP')
			{ 
			   if(str_header==null || str_header == '' || str_header == " ")
				{ 
					str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel("eCA.LMP.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.EDD.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.GestationPOA.label",'ca')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel("eCA.DeliveryDate.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.MiscarriageDate.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.Remarks.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.EventStatus.label",'ca')+"</td></tr>"+str+"</table>";
				}
				else
				{
					str= str_header+" "+str+"</table>";
				}
			}  
		   else
		   {
	      if(str_header==null || str_header == '' || str_header == " ")
	         {
			    str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel("eCA.ScanGestation.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.LMP.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.REDD.label",'ca')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel("eCA.GestationPOG.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.DeliveryDate.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.MiscarriageDate.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.Remarks.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.EventStatus.label",'ca')+"</b></td></tr>"+str+"</table>";
	}
	else
	{
		str= str_header+" "+str+"</table>";
	}
     }
	returnValue=str;
	returnValue=encodeURIComponent(returnValue,"UTF-8");
	}
	}
	returnValue = returnValue.replaceAll("+","%20");
	if(returnValue=='')
	alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));
	else
	{
		parent.window.returnValue=decodeURIComponent(returnValue,"UTF-8");
		parent.window.close();	
	}
}

function clearFormApprove()
{

	if(parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm != null)
	{
	var return_format=parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.result_linked_rec_type.value;
	var result_sub_category=parent.RecClinicalNotesLinkMenstResultFrame.document.forms[0].result_sub_category.value;
	
	if(result_sub_category == 'LMP'){
		parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkMenstLmpSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&flag=clear&ret_str=&result_sub_category="+result_sub_category;
		}
	
	else if(result_sub_category == 'USOD'){
		parent.RecClinicalNotesLinkMenstSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkMenstUsodSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&flag=clear&ret_str=&result_sub_category="+result_sub_category;
		}
	
	for(cnt=0; cnt<parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.chk_value"+cnt+".value");		
            val.checked = false
	}
	parent.RecClinicalNotesLinkMenstResultFrame.document.RecClinicalNotesLinkMentsResultForm.ctrlChkBox.checked=false
	}
}

function chgretn(Obj)
{
	if(Obj.value == 't')
		parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
	else
		parent.RecClinicalNotesLinkMenstCriteriaFrame.document.forms[0].return_format.value='';
}

function alignWidthIcd()
{
	var totalRows =  document.getElementById('dataTable').rows.length;
	var counter = totalRows-1;
	var temp = document.getElementById('dataTitleTable').rows(0).cells.length;
	for(var i=0;i<temp;i++) 
	{
		document.getElementById('dataTitleTable').rows(0).cells(i).width=document.getElementById('dataTable').rows(counter).cells(i).offsetWidth;
	}
}

function scrollTitleIcd()
{
   var y = document.body.scrollTop;
   if(y == 0){
		document.getElementById('divDataTitle').style.position = 'static';
   }else{
		document.getElementById('divDataTitle').style.position = 'relative';
		document.getElementById('divDataTitle').style.posTop  = y-2;
   }
}

function CheckForSpecCharsNoCaps(event)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*. ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function closew(code)
{
	window.returnValue = code;
	window.close();
}


function radio(obj)
{
	parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.event_status_a.checked=true
	parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.event_status_ac.checked=true
	parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.event_status_c.checked=true
    parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.order_by[0].checked = true;
	parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.from_date_time.value="";
	parent.RecClinicalNotesLinkMenstCriteriaFrame.document.RecClinicalLinkMenstCriteriaForm.to_date_time.value="";
		funSearchnew();
}

function checkingDate(obj,format,locale)
{
	var from =document.forms[0].from_date_time;
	var todate =document.forms[0].to_date_time;
	if(obj.value !="")
	{
		if(validDate(obj.value,"DMY",locale)==false)
		{	
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value='';
			return false;
		}
		if(!isBeforeNow(obj.value,format,locale))
		{
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
			msg = msg.replace('$$',"Date");
			alert(msg);
			obj.value='';
			return false;
		}
		if(from.value !=''){
		if (!(isBefore(from.value, obj.value, "DMY", locale))){
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			obj.value='';
			return false;
		}
		}
		return true;
	}
}

function Check_Date(obj,format,locale){
  	var toDate =document.forms[0].to_date_time;
  	if(obj.value !="")
  	{
  		if(validDate(obj.value,"DMY",locale)==false)
  		{	
  			alert(getMessage("INVALID_DATE_FMT","SM"));
  			obj.value='';
  			return false;
  		}
  		
  		if(!isBeforeNow(obj.value,format,locale))
  		{
  			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");			
  			msg = msg.replace('$$',"Date");
  			alert(msg);
  			obj.value='';
  			return false;
  		}
  	if(toDate.value !=''){
  		if (!(isBefore(obj.value, toDate.value, "DMY", locale))){
  			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
  			obj.value='';
  			return false;
  		}
  }
  }
  }


