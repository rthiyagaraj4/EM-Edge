/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
02/11/2011	  IN029422		 Chowminya G	Incident No: IN029422 - <Remove the check on the PH orders for IV orders> 
03/01/2012	  IN028417		Menaka V		The registered lab samples can be discontinued from CA-OR even though
											the discontinuation reasons are not defined for lab module.
15/02/2013	  IN037926		vijayakumar k	Existing Orders->Select any Registered Order->Discontinue->In the Discontinue Reason Web page Enter many lines of Text->Record->We get Exception Error and cannot proceed
14/03/2014	  IN047658		Vijayakumar K	17/03/2014	Chowminya G		Clinician Access ? Webpage dialog Some webpage dialog displays 
21/04/2014	  IN047658		Vijayakumar K		14/03/2014		Chowminya G		Reopen - Result Reporting > Result Entry ?Comments-webpage
---------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 			10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
13/06/2019     IN070698              sivabagyam	          13/06/2019          Ramesh G		SKR-SCF-1227
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";

// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll()
{
	if(document.cancel_order_dtl.select_all.checked == true)
	{
		for(cnt=0; cnt<parent.CancelOrderDtl.document.getElementById('total_recs').value; cnt++)
		{
			val = parent.CancelOrderDtl.document.getElementById('chk'+cnt);
			if(val) {
				val.checked = true;
			}
		}
		clickHeader();
	}
	else
	{
		for(cnt=0; cnt<parent.CancelOrderDtl.document.cancel_order_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.CancelOrderDtl.document.cancel_order_dtl.chk"+cnt);
			if(val)
				val.checked = false;
		}
		document.getElementById("hdr").style.display="none";
		document.getElementById("display_hdr").style.display="inline";
		parent.CancelOrderDtl.cancel_order_dtl.cancel_all_desc.value="";
		parent.CancelOrderDtl.cancel_order_dtl.cancel_all_description.value="";
	} 
}

async function clickHeader()
{
	var reason_desc="";
	var cancel_reason="";
	if(document.getElementById("select_all").checked==true)
	{
		reason_desc = parent.CancelOrderDtl.cancel_order_dtl.cancel_all_desc.value;
		cancel_reason = parent.CancelOrderDtl.cancel_order_dtl.cancel_all_description.value;
	}
	else
	{
		reason_desc="";
		parent.CancelOrderDtl.cancel_order_dtl.cancel_all_desc.value="";
		parent.CancelOrderDtl.cancel_order_dtl.cancel_all_description.value="";
		document.getElementById("hdr").href="#";
		document.getElementById("hdr").style.display="none" ;
		document.getElementById("display_hdr").style.display="inline" ;
	}

	var ord_cat = parent.CancelOrderDtl.document.cancel_order_dtl.ord_category.value;
	var cancelled_at = "header"

	var returnVal = await addCancelComments(ord_cat,cancelled_at,reason_desc,cancel_reason);
	if(returnVal != null && returnVal != "" )
	{
		var ret1=unescape(returnVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}										 			  
	}

	parent.CancelOrderDtl.cancel_order_dtl.cancel_all_desc.value = arr[0];
	parent.CancelOrderDtl.cancel_order_dtl.cancel_all_description.value = arr[1];
	reason_desc = arr[0];


	if(reason_desc != "" && reason_desc!="undefined" && reason_desc!=undefined)	
	{
		document.getElementById("hdr").style.display="inline" ;
		document.getElementById("hdr").href="javascript:clickHeader()" ;
		document.getElementById("display_hdr").style.display="none" ;
	}
	else
	{
		document.getElementById("hdr").href="#";
		document.getElementById("hdr").style.display="none" ;
		document.getElementById("display_hdr").style.display="inline" ;
		parent.CancelOrderDtl.cancel_order_dtl.cancel_all_desc.value = "";
		parent.CancelOrderDtl.cancel_order_dtl.cancel_all_description.value = "";
		if(document.getElementById("select_all").checked==true)
		{
			document.getElementById("select_all").checked=false;
		}
		for(cnt=0; cnt<document.getElementById("total_recs").value; cnt++)
		{
			val = parent.CancelOrderDtl.document.getElementById('chk'+cnt);
      
			if(val)
			{
				if(val.checked == true)
				{
					val.checked=false;
				}
			}
		}
	}
}	

async function clickLine(obj,rec_num)
{
	if(obj.checked == true || obj == "document")
	{
		var reason_desc = parent.CancelOrderDtl.document.getElementById('cancel_desc'+rec_num).value
		var cancel_reason = parent.CancelOrderDtl.document.getElementById('cancel_reason'+rec_num).value
		var ord_cat = parent.CancelOrderDtl.document.getElementById('ord_category').value;
		var cancelled_at = "line"
		var returnVal="";
		returnVal = await addCancelComments(ord_cat,cancelled_at,reason_desc,cancel_reason)

		if(returnVal != null )	
		{
			if (returnVal.length != 0) 
			{
				parent.CancelOrderDtl.document.getElementById('cancel_desc'+rec_num).value = returnVal[0];
				parent.CancelOrderDtl.document.getElementById('cancel_reason'+rec_num).value = returnVal[1];
			}
			else
			{
				val = parent.CancelOrderDtl.document.getElementById('chk'+rec_num);
				if(val)
				{
					if(val.checked == true)
					{
						val.checked=false
					}
				}
			}
		}
		if(parent.CancelOrderDtl.document.getElementById('cancel_desc'+rec_num).value != "" )
		{
			document.getElementById("lins"+rec_num).style.display="inline" ;
			document.getElementById("lins"+rec_num).href="javascript:clickLine(\"document\","+rec_num+")" ;
			document.getElementById("display_lins"+rec_num).style.display="none" ;
			//parent.CancelOrderDtl.cancel_order_dtl.all.hdr.href="javascript:clickHeader()" ;
		}
	}
	else
	{
		document.getElementById("lins"+rec_num).href="#";
		document.getElementById("display_lins"+rec_num).style.display="inline" ;
		document.getElementById("lins"+rec_num).style.display="none" ;
		parent.CancelOrderDtl.document.getElementById('cancel_desc'+rec_num).value = "";
		parent.CancelOrderDtl.document.getElementById('cancel_reason'+rec_num).value = "";
		parent.CancelOrderDtl.document.getElementById('hdr').href="#";
		parent.CancelOrderDtl.document.getElementById('hdr').style.display="none";
		parent.CancelOrderDtl.document.getElementById('display_hdr').style.display="inline";
		parent.CancelOrderDtl.document.getElementById('select_all').value="N";
		parent.CancelOrderDtl.document.getElementById('select_all').checked=false;
 	}
}
   
async function addCancelComments(ord_cat,cancelled_at,reason_desc,cancel_reason)
{
//IN070698 STARTS
	var retArray=new Array();
	var dialogHeight ='36vh' ; //changed from 18.75-20
	var dialogWidth = '30vw' ;//changed form 25-28
	var dialogTop	= '10';
	var dialogLeft = '10' ;
  //IN070698 ENDS
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
	retArray[0]=reason_desc;
	retArray[1]=cancel_reason;
	var arguments = retArray;
	var finalString	= "ord_cat="+ord_cat+"&cancelled_at="+cancelled_at+"&reason_desc="+reason_desc;

	var retVals = await top.window.showModalDialog("../../eOR/jsp/CancelComment.jsp?"+finalString,arguments,features);
/*		if(cancelled_at == "line"){
		eval("parent.CancelOrderDtl.document.cancel_order_dtl.cancel_desc"+rec_num).value = retVals
	}else{
		parent.CancelOrderDtl.cancel_order_dtl.cancel_all_desc.value = retVals
	}		*/
	return retVals
}


//this is to display the description of the reason in the text area
// the code selected in te option box  -in the file - CancelComment.jsp
//this is also used while cancelling the line level document in another file - CancelLineComment.jsp
// and thats the reason of making hte file name as forms[0] instead of for the form name
function displayDesc(obj)
{
	document.forms[0].reason_desc.value = obj.value;
}
  
function CheckMaxLength(obj,max) 
{  
	if(obj.value.length >= max) 
	{
		alert(getMessage('MAX_255_CHARS','OR'))
		obj.focus();
		return false;
	}
	else 
		return true;
}

function selectReason()
{
	var retArray	= new Array();
	if(document.cancel_comment.reason_desc.value == "")
	{
		alert(getMessage('REASON_CANNOT_BLANK','OR'))
		return false;
	} 
	else if(document.cancel_comment.reason_desc.value.length >= 255) 
	{
		alert(getMessage('MAX_255_CHARS','OR'))
		return false;
	}
	else
	{
		retArray[0]= document.cancel_comment.reason_desc.value;
		retArray[1]=document.cancel_comment.cancel_reason.selectedIndex;
		
		window.returnValue = retArray;
		window.close();
		
	}
}
	
function closeWindow()
{
	var retArray	= new Array();
	if(document.cancel_comment.reason_desc.value == "")
	{
		window.returnValue = "";
		
		return false;
	}
	else if(document.cancel_comment.reason_desc.value.length >= 255) 
	{
		alert(getMessage('MAX_255_CHARS','OR'))
		window.returnValue = "";
		
		return false;
	}
	else
	{
		retArray[0]= document.cancel_comment.reason_desc.value;
		retArray[1]=document.cancel_comment.cancel_reason.selectedIndex;
		window.returnValue = retArray;
		
	}
	window.close();
	
}
  
//called when the cancel button is pressed (Record Cancellation Button)
function cancelOrder()
{
	var no_of_checked = 0;
	var formObj = parent.CancelOrderDtl.document.cancel_order_dtl
	var cancel_desc =  "";
	var cancel_desc_chk =  "";
	var bean_id = parent.CancelOrderDtl.document.cancel_order_dtl.bean_id.value;
	var bean_name = parent.CancelOrderDtl.document.cancel_order_dtl.bean_name.value;
	var iv_prep_yn = parent.CancelOrderDtl.document.cancel_order_dtl.iv_prep_yn.value;
	var ord_category = parent.CancelOrderDtl.document.cancel_order_dtl.ord_category.value;
	var ord_status = parent.CancelOrderTop.document.view_order_top.order_status.value;//IN043143
	var v_total_recs = formObj.total_recs.value;
	if (v_total_recs == "")v_total_recs="0";

	//IN043143 Starts
	if (ord_category == "PH" && (ord_status == "RG" || ord_status == "VF" || ord_status == "AL" || ord_status == "IP" || ord_status == "DP" || 	ord_status == "DF"))
	{
		alert(getMessage('ORDER_ALREADY_VERIFIED','OR'))
		return false;
	}
	//IN043143 Ends
	if (ord_category == "PH" && iv_prep_yn != "")
	{
		var no_of_unchecked = 0;
		if(parent.CancelOrderDtl.document.cancel_order_dtl.select_all.checked)
		{				
			cancel_desc_chk  = parent.CancelOrderDtl.cancel_order_dtl.cancel_all_desc.value
			if(cancel_desc_chk == "")
			{
				alert(getMessage('REASON_CANNOT_BLANK','OR'))
				return false
			}
		}
		else
		{
			for(cnt=0; cnt<formObj.total_recs.value; cnt++)
			{
				val = eval("parent.CancelOrderDtl.document.cancel_order_dtl.chk"+cnt);
				if(val)
				{
					if(val.checked == true)
					{
						// the following check is done if the "X" mark of modal window is
						// clicked without specifying the reson -- BEGIN
						cancel_desc_chk  = eval("parent.CancelOrderDtl.document.cancel_order_dtl.cancel_desc"+cnt).value
						if(cancel_desc_chk == "")
						{
							alert(getMessage('REASON_CANNOT_BLANK','OR'))
							return false
						}
						// -- END
						no_of_checked++;
					}
					else
					{
						no_of_unchecked++;
					}
				}
			}				
			/*if(parseInt(no_of_unchecked) != parseInt(v_total_recs) && parseInt(no_of_checked) > 0)
			{
				var v_msg = getMessage('CANCEL_DISCONTINUE_ADD_MIXTURE_ORDER','OR');
				v_msg = v_msg.replace("#","Cancel");
				v_msg = v_msg.replace("$","Cancel");
				alert(v_msg);
				return false
			}*/ //Commented  - [IN029422]
			if(parseInt(no_of_checked) == 0)
			{
				alert(getMessage('CLICK_ANY_ONE','OR'))
				return false
			}
		}
	}
	else
	{
		if(parent.CancelOrderDtl.document.cancel_order_dtl.select_all.checked)
		{
			cancel_desc_chk  = parent.CancelOrderDtl.cancel_order_dtl.cancel_all_desc.value

			if(cancel_desc_chk == "")
			{
				alert(getMessage('REASON_CANNOT_BLANK','OR'))
				return false
			}
		}
		else
		{
			for(cnt=0; cnt<formObj.total_recs.value; cnt++)
			{
				val = eval("parent.CancelOrderDtl.document.cancel_order_dtl.chk"+cnt);
				if(val)
				{
					if(val.checked == true)
					{
						// the following check is done if the "X" mark of modal window is
						cancel_desc_chk  = eval("parent.CancelOrderDtl.document.cancel_order_dtl.cancel_desc"+cnt).value
						if(cancel_desc_chk == "")
						{
							alert(getMessage('REASON_CANNOT_BLANK','OR'))
							return false
						}
						no_of_checked++;
					}
				}
			}
			if(parseInt(no_of_checked) == 0)
			{
				alert(getMessage('CLICK_ANY_ONE','OR'))
				return false
			}
		}
	}

	//the fg for loop is used to check the Imediate orderstatus of the order
	//while cancelling the line level record  -------- Begin
	var found = 0;
	var ord_st_val = "";
	for(cnt=0; cnt<formObj.total_recs.value; cnt++)
	{
		val = eval("parent.CancelOrderDtl.document.cancel_order_dtl.chk"+cnt);

		if(val)
		{
			if(val.checked == true)
			{
				//no_of_checked++;
			}
			else
			{
				if(found == 0)
				{
					var ord_st =  eval("parent.CancelOrderDtl.document.cancel_order_dtl.line_status"+cnt);
					found++
					ord_st_val = ord_st.value
					parent.CancelOrderDtl.document.cancel_order_dtl.line_stat_to_updt.value = ord_st_val
				}
				else
				{
					continue
				}
			}
		}
		else
		{
			if(found == 0)
			{
				ord_st =  eval("parent.CancelOrderDtl.document.cancel_order_dtl.line_status"+cnt);
				found++
				ord_st_val = ord_st.value
				parent.CancelOrderDtl.document.cancel_order_dtl.line_stat_to_updt.value = ord_st_val
			}
			else
			{
				continue
			}
		}
	}  

	if(parseInt(no_of_checked) == 1)
	{
		ord_st =  parent.CancelOrderDtl.document.cancel_order_dtl.line_status0
		found++
		ord_st_val = ord_st.value
		parent.CancelOrderDtl.document.cancel_order_dtl.line_stat_to_updt.value = ord_st_val
	}
	
	for(cnt=0; cnt<parent.CancelOrderDtl.document.cancel_order_dtl.total_recs.value; cnt++)
	{
		cancel_desc += ""+ eval("parent.CancelOrderDtl.document.cancel_order_dtl.cancel_desc"+cnt).value
	}

	if(cancel_desc == "")
		cancel_desc =	parent.CancelOrderDtl.cancel_order_dtl.cancel_all_desc.value

	parent.CancelOrderDtl.cancel_order_dtl.cancel_desc.value = cancel_desc

	if(parent.CancelOrderDtl.document.cancel_order_dtl.select_all.checked == true)
		parent.CancelOrderDtl.cancel_order_dtl.cancel_type.value = "H";
	else 
		parent.CancelOrderDtl.cancel_order_dtl.cancel_type.value = "L";

	eval(formApply( parent.CancelOrderDtl.document.cancel_order_dtl,OR_CONTROLLER)) ;
	
	if( result ) 
	{
		alert(getMessage("RECORD_MODIFIED","SM"))//s will display "operation compelted successfully" - message
		printValues(bean_id, bean_name); // Call a method to print the orders
		onSuccess();
	}
	else
	{		
		if( getMessage(message,"OR") != "" )
		{
			message = getMessage(message,"OR");
			if(invalidCode != "" && eval(parent.CancelOrderDtl.document.getElementById("status"+invalidCode)))
			eval(parent.CancelOrderDtl.document.getElementById("status"+invalidCode)).className = "orcancel";
		}
		if (message.indexOf("<br>") != -1) 
		{
			message = message.substring(0,message.indexOf("<br>"))
		}
		alert(message)
	}
}		   

function assignResult(_result, _message, _flag)
{
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function onSuccess() 
{
	window.close();
  
}

function cancelLineRecord()
{
	var bean_id = document.cancel_line.bean_id.value;
	var bean_name = document.cancel_line.bean_name.value;
	//IN043143 Starts
	var ord_cat = document.cancel_line.ord_cat.value;
	var order_status = document.cancel_line.order_status.value;
	
	if (ord_cat == "PH" && (order_status == "RG" || order_status == "VF" || order_status == "AL" || order_status == "IP" || order_status == "DP" || 	order_status == "DF"))
	{
		alert(getMessage('ORDER_ALREADY_VERIFIED','OR'))
		return false;
	}
	//IN043143 Ends
	if(document.cancel_line.reason_desc.value == "")
	{
		alert(getMessage('REASON_CANNOT_BLANK',"OR"))
		return false;
	}

	if(document.cancel_line.reason_desc.value.length >= 255) 
	{
		alert(getMessage('MAX_255_CHARS',"OR"))
		window.returnValue = "";
		return false;
	}
	eval(formApply( document.cancel_line,OR_CONTROLLER)) ;

	if( result ) 
	{
		alert(getMessage("RECORD_MODIFIED","SM"))
		printValues(bean_id, bean_name);
		onSuccess();		
	}
	else
	{
		if( getMessage(message,"OR") != "" )
			message = getMessage(message,"OR");
		if (message.indexOf("<br>") != -1) 
		{
			message = message.substring(0,message.indexOf("<br>"))
		}
		alert(message);
		onSuccess();
   	}
}
  
function discontinueLineRecord()
{
	var bean_id = document.discontinue_line.bean_id.value;
	var bean_name = document.discontinue_line.bean_name.value;
	var maxlengthcheck = false;//IN037926
	
	//IN028417 Starts
	if((document.discontinue_line.ReasonCodeHoldDisYN.value=="Y")&&(document.discontinue_line.ReasonCodeHoldDiscatYN.value=="Y"))
	{
		
	 if(document.discontinue_line.cancel_reason.value =="")
	 {
		alert(getMessage('REASON_CANNOT_BLANK','OR'))
		//alert("New -> Reason cannot be blank")
		return false;
	 }
	 else if(trimCheck(document.discontinue_line.reason_desc.value)){//IN037926 starts
	 maxlengthcheck = CheckMaxLength(document.discontinue_line.reason_desc,255);
	 if(maxlengthcheck ==  false)
		return false;
	}//IN037926 ends
	}
	else
	{
	if(!trimCheck(document.discontinue_line.reason_desc.value))
	{
//	if(document.discontinue_line.reason_desc.value == ""){
		alert(getMessage('REASON_CANNOT_BLANK','OR'))
		return false;
	}
	else if(trimCheck(document.discontinue_line.reason_desc.value)){//IN037926 starts
	 maxlengthcheck = CheckMaxLength(document.discontinue_line.reason_desc,255);
	 if(maxlengthcheck ==  false)
		return false;
	}
	}//IN037926 ends
	//IN028417 ends
	eval(formApply( document.discontinue_line,OR_CONTROLLER)) ;
	if( result ) 
	{
		alert(getMessage("RECORD_MODIFIED","SM"))
		printValues(bean_id, bean_name); // Call a method to print the orders
		onSuccess();		
	}
	else
	{
		if( getMessage(message,"OR") != "" )
			message = getMessage(message,"OR");

		if (message.indexOf("<br>") != -1) 
		{
			message = message.substring(0,message.indexOf("<br>"))
		}
		alert(message)
		window.close();
	}

}  

function resumeOrder()
{
	eval(formApply( document.resume_order,OR_CONTROLLER)) ;
	if( result ) 
	{
		alert(getMessage("RECORD_MODIFIED","SM"))
		onSuccess();
	}
	else
	{
		if( getMessage(message,"OR") != "" )
			message = getMessage(message,"OR");
	   	alert(message);
		onSuccess();
	}
}
  
//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}

*/

async function viewCancelOrderFormatLineCmts(can_reason, line,order_line_num,orderId)
{
	var instrn_type = eval("document.cancel_order_dtl.instrn_type"+line+".value");//IN64543
	
	if(can_reason=="Comments")
	{
		var dialogHeight ='12' ;
		//IN047658 starts
		//var dialogWidth = '29' ;
		//IN047658 - reopen starts
		//var dialogWidth = '35' ;
		//IN047658 ends
		var dialogWidth = '40' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		//IN64543, starts
    if("E" == instrn_type)
		{
			dialogHeight ='30' ;			
			dialogWidth = '40' ;
		}
    //IN64543, ends
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//var narration = eval("parent.CancelOrderDtl.document.cancel_order_dtl.Cmts"+line+".value");//IN64543
	}
	else
	{
		var dialogHeight ='14' ;
		//IN047658 - reopen starts
		//var dialogWidth = '29' ;
		var dialogWidth = '40' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
    
		//IN64543, starts
    if("E" == instrn_type)
		{
			dialogHeight ='30' ;			
			dialogWidth = '40' ;
		}
    //IN64543, ends
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//var narration = eval("parent.CancelOrderDtl.document.cancel_order_dtl.Cancel"+line+".value");//IN64543
	}
	var arguments = "";
	//var finalString	= "can_reason="+encodeURIComponent(can_reason)+"&order_line_num="+order_line_num+"&orderId="+orderId;//IN64543
	var finalString	= "can_reason="+encodeURIComponent(can_reason)+"&order_line_num="+order_line_num+"&orderId="+orderId+"&instrn_type="+instrn_type;//IN64543
	var retVals =await  window.showModalDialog("../../eOR/jsp/ViewLineComment.jsp?"+finalString,arguments,features);
}

async function viewCancelPrepsData(line)
{
	var instrn_type = eval("document.cancel_order_dtl.instrn_type"+line+".value");//IN64543
	var dialogHeight ='11' ;
	//IN047658 starts
	//var dialogWidth = '30' ;
	//IN047658 - reopen starts
	//var dialogWidth = '35' ;
	//IN047658 ends
	var dialogWidth = '40' ;
	//IN047658 - reopen ends
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
  
  //IN64543, starts
	if("E" == instrn_type)
	{
		dialogHeight ='30' ;			
		dialogWidth = '40' ;
	}
  //IN64543, ends
  
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	//var preps_data = eval("parent.CancelOrderDtl.document.cancel_order_dtl.Preps"+line+".value");
	//var finalString	= 'preps_data='+ encodeURIComponent(preps_data);
	//var finalString	= 'line='+line;//IN64543
	var finalString	= 'line='+line+"&instrn_type="+instrn_type;//IN64543
	var retVals = await window.showModalDialog("../../eOR/jsp/ViewPrepsData.jsp?"+finalString,arguments,features);
}

async function viewCancelDeptData(line)
{
	var instrn_type = eval("document.cancel_order_dtl.instrn_type"+line+".value");//IN64543
	var dialogHeight ='11' ;
	//IN047658 starts
	//var dialogWidth = '30' ;
	//IN047658 - reopen starts
	//var dialogWidth = '35' ;
	//IN047658 ends
	var dialogWidth = '40' ;
	//IN047658 - reopen ends
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
		
	//IN64543, starts
  if("E" == instrn_type)
	{
		dialogHeight ='30' ;			
		dialogWidth = '40' ;
	}
  //IN64543, ends
	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	//var dept_data = eval("parent.CancelOrderDtl.document.cancel_order_dtl.Depts"+line+".value");
	//var finalString	= 'dept_data='+ encodeURIComponent(dept_data);
	//var finalString	= 'line='+line;//IN64543
	var finalString	= 'line='+line+"&instrn_type="+instrn_type;//IN64543
	var retVals = await window.showModalDialog("../../eOR/jsp/ViewDeptData.jsp?"+finalString,arguments,features);
}

async function viewCancelApptData(line)
{
	var dialogHeight ='27' ;
	var dialogWidth = '36' ;
	var dialogTop	= '249';
	var dialogLeft = '167' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments = "";
	var appt_ref_num 			= eval("parent.CancelOrderDtl.document.cancel_order_dtl.Appt"+line+".value");
	var appt_date 				= eval("parent.CancelOrderDtl.document.cancel_order_dtl.Appt_date"+line+".value");
	var appt_locn	 			= eval("parent.CancelOrderDtl.document.cancel_order_dtl.appt_locn"+line+".value");
	var appt_resched_yn			= eval("parent.CancelOrderDtl.document.cancel_order_dtl.appt_resched_yn"+line+".value");
	var appt_resched_reason		= eval("parent.CancelOrderDtl.document.cancel_order_dtl.appt_resched_reason"+line+".value");
	var no_of_reschedules		= eval("parent.CancelOrderDtl.document.cancel_order_dtl.no_of_reschedules"+line+".value");
	var order_category			= eval("parent.CancelOrderDtl.document.cancel_order_dtl.order_category"+line+".value");
	var cont_order_ind 			= eval("parent.CancelOrderDtl.document.cancel_order_dtl.cont_order_indicator"+line+".value");
	var parent_order_id 		= eval("parent.CancelOrderDtl.document.cancel_order_dtl.parent_order_id"+line+".value");
	var parent_order_line_num 	= eval("parent.CancelOrderDtl.document.cancel_order_dtl.parent_order_line_num"+line+".value");
	var bean_id 				= parent.CancelOrderDtl.document.cancel_order_dtl.bean_id1.value;
	var bean_name 				= parent.CancelOrderDtl.document.cancel_order_dtl.bean_name1.value;
	var function_from 			= parent.CancelOrderDtl.document.cancel_order_dtl.function_from.value;
	//Modifed by Uma on 3/17/2010 for IN020017
	var finalString				= "appt_ref_num="+ escape(appt_ref_num)+"&appt_date="+escape(appt_date)+"&cont_order_ind="+escape(cont_order_ind)+"&parent_order_id="+escape(parent_order_id)+"&parent_order_line_num="+escape(parent_order_line_num)+"&appt_locn="+escape(appt_locn)+"&appt_resched_yn="+escape(appt_resched_yn)+"&appt_resched_reason="+escape(appt_resched_reason)+"&no_of_reschedules="+escape(no_of_reschedules)+"&order_category="+escape(order_category);
	finalString					+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&function_from="+escape(function_from)
	var retVals = await window.showModalDialog("../../eOR/jsp/ViewApptFrameset.jsp?"+finalString,arguments,features);
}

async function viewOACancelApptData(line)
{
	var dialogHeight ='37.5' ;
	var dialogWidth = '50' ;
	var dialogTop	= '100';
	var dialogLeft = '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var appt_ref_num 			= eval("parent.CancelOrderDtl.document.cancel_order_dtl.Appt"+line+".value");
	var appt_date 				= eval("parent.CancelOrderDtl.document.cancel_order_dtl.Appt_date"+line+".value");
	var cont_order_ind 			= eval("parent.CancelOrderDtl.document.cancel_order_dtl.cont_order_indicator"+line+".value");
	var parent_order_id 		= eval("parent.CancelOrderDtl.document.cancel_order_dtl.parent_order_id"+line+".value");
	var parent_order_line_num 	= eval("parent.CancelOrderDtl.document.cancel_order_dtl.parent_order_line_num"+line+".value");
	var bean_id 				= parent.CancelOrderDtl.document.cancel_order_dtl.bean_id1.value;
	var bean_name 				= parent.CancelOrderDtl.document.cancel_order_dtl.bean_name1.value;
	var function_from 			= parent.CancelOrderDtl.document.cancel_order_dtl.function_from.value;
	var patient_id 			= parent.CancelOrderDtl.document.cancel_order_dtl.patient_id.value;
	var finalString				= 'i_appt_ref_no='+ escape(appt_ref_num)+'&i_appt_date='+escape(appt_date)+'&cont_order_ind='+escape(cont_order_ind)+'&parent_order_id='+escape(parent_order_id)+'&parent_order_line_num='+escape(parent_order_line_num);
	finalString					+= '&bean_id='+escape(bean_id)+'&bean_name='+escape(bean_name)+'&function_from='+escape(function_from)+'&patient_id='+patient_id+'&flag=Visit_Reg'
	var retVals = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?"+finalString,arguments,features);
}

function printValues(bean_id, bean_name) 
{
	// Call the intermediate jsp, to make the values print.......
//	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	//var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var func_mode = "PRINT_VALUES";
	var called_from = "CANCELORDER";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " FUNC_MODE=\""+ func_mode + "\" ";
	xmlStr += " CALLED_FROM=\""+ called_from + "\" ";
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CancelOrderValidate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}
//IN061903 start
function notDoneLineRecord()
{
	var bean_id = document.not_done_line.bean_id.value;
	var bean_name = document.not_done_line.bean_name.value;
	var maxlengthcheck = false;

	if(document.not_done_line.ReasonCodeNotDoneYN.value=="Y")
	{
		 if(document.not_done_line.cancel_reason.value =="")
		 {
			alert(getMessage('REASON_CANNOT_BLANK','OR'))
			return false;
		 }
		 else if(trimCheck(document.not_done_line.reason_desc.value)){
		 maxlengthcheck = CheckMaxLength(document.not_done_line.reason_desc,255);
		 if(maxlengthcheck ==  false)
			return false;
		}
	}
	else
	{
		if(!trimCheck(document.not_done_line.reason_desc.value))
		{
			alert(getMessage('REASON_CANNOT_BLANK','OR'))
			return false;
		}
		else if(trimCheck(document.not_done_line.reason_desc.value)){
		 maxlengthcheck = CheckMaxLength(document.not_done_line.reason_desc,255);
		 if(maxlengthcheck ==  false)
			return false;
		}
	}
	eval(formApply( document.not_done_line,OR_CONTROLLER)) ;
	if( result ) 
	{
		alert(getMessage("RECORD_MODIFIED","SM"))
		printValues(bean_id, bean_name); // Call a method to print the orders
		onSuccess();		
	}
	else
	{
		if( getMessage(message,"OR") != "" )
			message = getMessage(message,"OR");

		if (message.indexOf("<br>") != -1) 
		{
			message = message.substring(0,message.indexOf("<br>"))
		}
		alert(message)
		window.close();
	}
}
//IN061903 ends


//IN64543, starts
async function viewPatientData(orderId,order_line_num,line){
	
	var instrn_type = eval("document.cancel_order_dtl.instrn_type"+line+".value");
		var dialogHeight ='12' ;		
		var dialogWidth = '40' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		
		if("E"==instrn_type)
		{
			var dialogHeight ='30' ;	
			var dialogWidth = '40' ;
		}
		
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
	

		var arguments = "";	
	var finalString	= "orderId="+ orderId+"&order_line_num="+order_line_num+"&instrn_type="+instrn_type;//IN64543
		var retVals = await window.showModalDialog("../../eOR/jsp/viewPatientData.jsp?"+finalString,arguments,features);
}
//IN64543, ends

