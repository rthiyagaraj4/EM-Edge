
function reset()
{
	 BLCashChequeHandoverReqDtlsFrame.document.location.reload();
}

function create()
{	
	commontoolbarFrame.document.getElementById("apply").disabled=false;
	commontoolbarFrame.document.getElementById("query").disabled=true;
	BLCashChequeHandoverReqDtlsFrame.location.href="../../eBL/jsp/BLCashChequeHandoverReqFrame.jsp?mode=insert";
}

function query()
{
	commontoolbarFrame.document.getElementById("reset").disabled=false;
	commontoolbarFrame.document.getElementById("apply").disabled=false;
	commontoolbarFrame.document.getElementById("create").disabled=true;
	//var formObj = document.forms[0];
	//BLCashChequeHandoverReqDtlsFrame.location.href="../../eBL/jsp/BLCashChequeHandoverCriteria.jsp"
	BLCashChequeHandoverReqDtlsFrame.location.href="../../eBL/jsp/BLCashChequeHandoverReqFrame.jsp?mode=modify";
}


// For adding multiple cash and cheque 
function addRow(tableID,function_id,mode)
{
	var noofdecimal =document.getElementById("noofdecimal").value;
	var table="";
	var rowCount="";
	var index="";
	var row="";				
	if(function_id=="CASH_DTL")
	{
			table = document.getElementById('"+tableID+"');	
			rowCount = table.rows.length;		
			index = rowCount-2;			
		
				row=document.getElementById('"+tableID+"').insertRow(rowCount);		
			if(mode=='modify'){
				if(document.getElementById("cashHandedOver").value!=""){
					document.getElementById("cashHandedOver").value="";}


			
				var cell1=row.insertCell[0];
				var cell2=row.insertCell[1];
				var cell3=row.insertCell[2];
				var cell4=row.insertCell[3];
				cell1.innerHTML="<input type='checkbox' name = 'cashSelect_"+index+"' id = 'cashSelect_"+index+"' size='10' style='text-align:right' maxlength='10' value='Y' checked onClick=\"selectCash('"+index+"');\" />"
				cell2.innerHTML="<input type='text' name = 'currDeno_"+index+"' id = 'currDeno_"+index+"' size='10' style='text-align:right' maxlength='10' onkeypress='return allowValidNumber1_temp(this,event,\"2\");' onBlur='checkForDuplicate(this,\""+index+"\")';/>"
				cell3.innerHTML="<input type='text' name = 'currNumber_"+index+"' id = 'currNumber_"+index+"' size='10'  style='text-align:right' maxlength='10' onkeypress='return ChkNumberInput(this,event,\"0\");' onBlur='calctotAmt(this,\""+index+"\")'; />"
				cell4.innerHTML="<input type='text' name = 'currAmt_"+index+"' id = 'currAmt_"+index+"' size='15' style='text-align:right' maxlength='10' onkeypress='return allowValidNumber1_temp(this,event,\"2\");' onBlur= \"putdeci_temp(this,'"+noofdecimal+"');\" />"	
			}else{
				var cell1=row.insertCell[0];
				var cell2=row.insertCell[1];
				var cell3=row.insertCell[2];
				cell1.innerHTML="<input type='text' name = 'currDeno_"+index+"' id = 'currDeno_"+index+"' size='10' style='text-align:right' maxlength='10' onkeypress='return allowValidNumber1_temp(this,event,\"2\");' onBlur='checkForDuplicate(this,\""+index+"\")';/>"
				cell2.innerHTML="<input type='text' name = 'currNumber_"+index+"' id = 'currNumber_"+index+"' size='10' style='text-align:right' maxlength='10' onkeypress='return ChkNumberInput(this,event,\"0\");' onBlur='calctotAmt(this,\""+index+"\")'; />"
				cell3.innerHTML="<input type='text' name = 'currAmt_"+index+"' id = 'currAmt_"+index+"' size='15' style='text-align:right' maxlength='10' onkeypress='return allowValidNumber1_temp(this,event,\"2\");' onBlur=putdeci_temp(this,'2'); />"	
				}
				
				document.cashCollectionForm.totalRecordsCash.value=rowCount-1;		
	}else if(function_id=="CHQ_DTL")
			{
			table = document.getElementById('"+tableID+"');	
			rowCount = table.rows.length;		
			
			index = rowCount-1;	
	

		
				row=document.getElementById('"+tableID+"').insertRow(rowCount);		

				var cell1=row.insertCell[0];
				var cell2=row.insertCell[1];
				var cell3=row.insertCell[2];
				var cell4=row.insertCell[3];
				var cell5=row.insertCell[4];
				var cell6=row.insertCell[5];
				var cell7=row.insertCell[6];

			cell1.innerHTML="<input type='checkbox' name = 'chkSelect_"+index+"' id = 'chkSelect_"+index+"' size='10' maxlength='10' value='Y' checked onClick=\"selectChk('"+index+"');\"/>"


				cell2.innerHTML="<input type='text' name = 'chqNum_"+index+"' id = 'chqNum_"+index+"' size='10' maxlength='10' onBlur='chequeLookup(this,\""+index+"\",\"B\")' /><input type='button' class='button' name='chequeLookupBtn_"+index+"' id='chequeLookupBtn_"+index+"' value='?'  onClick =\"chequeLookup('chqNum_"+index+"','"+index+"','C');\" />"

				cell3.innerHTML="<input type='text' name = 'chqDate_"+index+"' id = 'chqDate_"+index+"' size='20' maxlength='10'  readonly/>"

				cell4.innerHTML="<input type='text' name = 'bank_"+index+"' id = 'bank_"+index+"' size='12' maxlength='10' readonly />"	

				cell5.innerHTML="<input type='text' name = 'payer_"+index+"' id = 'payer_"+index+"' size='12' maxlength='10' readonly />"	

				cell6.innerHTML="<input type='text' name = 'patientId_"+index+"' id = 'patientId_"+index+"' size='10' maxlength='10' readonly/>"	

				cell7.innerHTML="<input type='text' name = 'chqAmount_"+index+"' id = 'chqAmount_"+index+"' size='10' style='text-align:right' maxlength='10' readonly/>"	


				document.chqCollectionForm.totalRecordsChq.value=rowCount;	
				
			}
}





function CheckForSpecChars_loc(event,obj){
	
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(obj.value.length==0)
	{

		if('_'.indexOf(key)!=-1)
			return false;
	}

    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


function chkSpecial(event,obj)
{
	return CheckForSpecChars_loc(event,obj);

}
function putdeci(object)
	{	
		if(object.value!='')
		{
		//var decimal=parent.PkgDefHeader.document.forms[0].noofdecimal.value;
		var decimal=eval("document.frmPkgSubs.noofdecimal").value;
	
		putDecimal(object,17,decimal);
		}
	}

function apply()
{	
	var frmObj="";	
	var frmObj1="";	
	var err_mess="";
	var rec_found_flag="";
	var function_id=BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.getElementById('mode').value;
	

		var tot_rec_cash = frames[1].frames[2].frames[0].document.getElementById('totalRecordsCash').value	;
		var totalRecordsChq = frames[1].frames[2].frames[1].document.getElementById('totalRecordsChq').value	;	

		var cashHandedOver = eval("frames[1].frames[2].frames[0].document.getElementById('cashHandedOver')").value;	
		if(cashHandedOver!="")
		{
			rec_found_flag="Y";
		}else{
			rec_found_flag="N";
		}
	if(rec_found_flag=="N")
		{
		for(var i=0;i<tot_rec_cash;i++)
		{
			 var curr_deno = eval('frames[1].frames[2].frames[0].document.forms[0].currDeno_'+i).value;	 
			 
			 if(curr_deno!="")
				{
					rec_found_flag="Y";
					break;
				}else{
					rec_found_flag="N";
				}

		}
		}
		
		if(rec_found_flag=="N")
		{
			for(var i=0;i<totalRecordsChq;i++)
			{				
			 if(eval("frames[1].frames[2].frames[1].document.forms[0].chkSelect_"+i).checked)
				{
				 rec_found_flag="Y";
					break;
				}else{
					rec_found_flag="N";
				}
			}

		}
		
		if (rec_found_flag=="N")
		{
			if(function_id=='modify'){
				err_mess=getMessage("BL7305","BL")
				//err_mess="Enter Cash or Select Cheque Details";
			}else{
				err_mess=getMessage("NO_CHANGE_TO_SAVE","Common")
			}
		}

		for(var i=0;i<tot_rec_cash;i++)
		{

			 var curr_deno = eval("frames[1].frames[2].frames[0].document.forms[0].currDeno_"+i).value;			 
			 var curr_nums = eval("frames[1].frames[2].frames[0].document.forms[0].currNumber_"+i).value;
			 var curr_amt  = eval("frames[1].frames[2].frames[0].document.forms[0].currAmt_"+i).value;
			 if (curr_deno!="")
			 {
				 
				 if (curr_nums=="" || curr_amt=="")
				 {
					  
					var msg1	= getMessage("CAN_NOT_BE_BLANK","Common")				
					msg1		= msg1.replace('$', getLabel("eBL.NOS.label","BL"));						
					err_mess=msg1;
					
				 }
			 }

		}



	var cashinhand=BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashChqCollFrame.document.getElementById("cashInHand").value;
	var cheqinhand=BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashChqCollFrame.document.getElementById("chequeInHand").value;
	BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.getElementById("cashInHand").value=cashinhand;	
	BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.getElementById("chequeInHand").value=cheqinhand;

//alert("1:"+BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].handoverrequestamt.value);
	if(BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.getElementById("handoverrequestamt").value=="")
	{
		var handoverrequestamt = frames[1].frames[2].frames[0].document.getElementById("cash_total").value	;	
	//alert("2: "+handoverrequestamt);	
	BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.getElementById("handoverrequestamt").value=handoverrequestamt;
	}
	//alert(BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].handoverrequestamt.value);

	//frmObj =BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashChqCollDtlsFrame.document.cashCollectionForm;	
	frmObj=frames[1].frames[2].frames[0].document.forms[0];	
	frmObj1=frames[1].frames[2].frames[1].document.forms[0];
	
  if(frmObj.name=="cashCollectionForm"){
    if( frmObj!=null && frmObj != "undefined" )
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
			    {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
	            }
		        val= val.substring(0,val.lastIndexOf('~'))
			    if(arrObj[i].name != null && arrObj[i].name != "")
				    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		    else
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		}
	}
	}

	xmlStr +=" /></root>";
	//alert("xmlStr :"+xmlStr);
	var updation=formValidation(xmlStr,"STORE_VALUES","CASH_DTLS");	
  }

  if(frmObj1.name=="chqCollectionForm"){
    if( frmObj1!=null && frmObj1 != "undefined" )
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj1.elements;
		
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
			    {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
	            }
		        val= val.substring(0,val.lastIndexOf('~'))
			    if(arrObj[i].name != null && arrObj[i].name != "")
				    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		    else
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		}
	}
	}

	xmlStr +=" /></root>";
	//alert("xmlStr :"+xmlStr);
	var updation=formValidation(xmlStr,"STORE_VALUES","CHEQ_DTLS");	
  }
if(err_mess=="")
	{
		BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].target='messageFrame';
		BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].method='post';
		BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].action="../../servlet/eBL.BLCashChequeHandOverServlet";
		BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].submit();	
	}else{
		frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
	}
}

function cancelRecord(function_mode)
{
	/*BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].mode.value=function_mode;
	BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].target='messageFrame';
	BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].method='post';		BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].action="../../servlet/eBL.BLCashChequeHandOverServlet";
	BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].submit();	*/

	if(confirm(getMessage("BL7353","BL"))) 
	{
		parent.parent.frames[0].document.getElementById("mode").value=function_mode;
		parent.parent.frames[0].document.forms[0].target='messageFrame';
		parent.parent.frames[0].document.forms[0].method='post';		parent.parent.frames[0].document.forms[0].action="../../servlet/eBL.BLCashChequeHandOverServlet";
		parent.parent.frames[0].document.forms[0].submit();
	}
}
	 
	
function onSuccess()
{	
		BLCashChequeHandoverReqDtlsFrame.location.reload();							
}



async function cashCounterLookup(obg,clng_evnt,mode)
{		
//alert("mode"+mode);
//alert("bl");
		var tt="";
		var target			= obg;		
		var retVal			=  new String();
		if(clng_evnt == 'B')
		{
			if( target.value == "")
			{
				target.value = "";		
				eval("document.cashCounterForm.loginDateTime").value="";
				eval("document.cashCounterForm.reqDateTime").value="";
				eval("document.cashCounterForm.inUseBy").value="";
				return;
			}
		}
	
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("eBL.CASH_COUNTER.label",'BL');
		var locale		 = document.forms[0].locale.value;			
		var userID		 = document.forms[0].userId.value;			
		var facility_id  = document.forms[0].facility_id.value;				
		var sql1="select  CASH_COUNTER_CODE code,SHORT_DESC description from BL_CASH_COUNTER_LANG_VW where OPERATING_FACILITY_ID ='"+facility_id+"' and  CASH_CTR_IN_USE_BY='"+userID+"' and language_id = '"+locale+"' AND nvl(status,'x') != 'S'  and upper(CASH_COUNTER_CODE) like upper(?) and upper(SHORT_DESC) like upper(?)"; 		
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql1;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;				
		retArray = await CommonLookup( title, argArray );	
		 var ret1=unescape(retArray);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")
		{
			document.cashCounterForm.cashCounterDesc.value=arr[1];			
			document.cashCounterForm.cashCounterCode.value=arr[0];	
			if(mode=="modify"){
				
				callvalidate(arr[0],"GET_DB_VALUES");
			}
			else			{
				alert("else");
				callvalidate(arr[1],"GET_DETAILS");
				alert("out");
			}
			
		}

}


function callvalidate(cashCounterCode,function_id,func_mode)
{	
	
			var xmlString=formXMLString(cashCounterCode,function_id);
			var updation=formValidation(xmlString,function_id,func_mode);
	
}


function formXMLString(cashCounterCode,function_id)
{	
		var noofdecimal = document.getElementById("noofdecimal").value;

	var xmlStr ="<root><SEARCH ";	
	xmlStr+= "cashCounterCode=\"" + cashCounterCode + "\" " ;	
	xmlStr+= "noofdecimal=\"" + noofdecimal + "\" " ;	
	xmlStr +=" /></root>";		
	return xmlStr;
}

function formValidation(xmlStr,function_id,func_mode)
{	 
	
	var temp_jsp="BLCashChequeHandoverValidation.jsp?function_id="+function_id+"&func_mode="+func_mode;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	alert("responseText :"+responseText);
	eval(responseText);
	return true;
}

function calltodisplaydetails(strLoginTime,strsysdate,loginUser,cashInHand,chequeInHand,mode)
{
	
	//parent.frames[1].location.href='../../eBL/jsp/BLCashChequeHandoverCashChqCollectionDtls.jsp';
	//alert("strLoginTime :"+strLoginTime);
	document.cashCounterForm.loginDateTime.value=strLoginTime;	
	document.cashCounterForm.reqDateTime.value=strsysdate;	
	document.cashCounterForm.inUseBy.value=loginUser;	
	parent.frames[1].document.cashCheqinHandForm.cashInHand.value=cashInHand;	
	parent.frames[1].document.cashCheqinHandForm.chequeInHand.value=chequeInHand;	

	var cashCounterCode=document.cashCounterForm.cashCounterCode.value;		parent.frames[2].location.href="../../eBL/jsp/BLCashChequeHandoverReqDtlsFrame.jsp?cashCounterCode="+cashCounterCode+"&strLoginTime="+strLoginTime+"&strsysdate="+strsysdate+"&mode="+mode;
//	BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverTransDtlsFrame.location.href="../../eBL/jsp/BLCashChequeHandoverTransDtls.jsp"


	parent.frames[3].location.href="../../eBL/jsp/BLCashChequeHandoverTransDtls.jsp?cashCounterCode="+cashCounterCode+"&strLoginTime="+strLoginTime;
}


function putdeci_temp(object,noofdecimal){	
	var decimal="";
	decimal=noofdecimal;
	if(object.value!='')
	{		
		putDecimal(object,17,decimal);
	}
}

function calctotAmt(obj,index)
{
		
	var noofdecimal =document.getElementById("noofdecimal").value;	
	var curr_deno=0.00;
	var curr_num=0.00;
	var v_totAmt=0;
	var cu_totAmt=0;
	if(obj.value!="" && obj.value==0)
	{

		alert(getMessage("CANNOT_BE_ZERO","Common"));
		obj.select();

	}
	curr_deno=eval("document.forms[0].currDeno_"+index).value;
	if((obj.value!="" && parseFloat(obj.value)>0)&& (curr_deno==""))
	{
	
		var msg1	= getMessage("CAN_NOT_BE_BLANK","Common")				
		msg1		= msg1.replace('$', getLabel("eBL.DENO.label","BL"));
				
			alert(msg1);
			return false;
			eval("document.forms[0].currDeno_"+index).focus();
	}

	curr_num=obj.value;
	//var cashinhand=BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashChqCollFrame.document.forms[0].cashInHand.value;
	var cashinhand=parent.parent[1].document.getElementById("cashInHand").value;	
	var tot_rec =document.forms[0].totalRecordsCash.value;
	
	if(curr_deno!="" && curr_num!=""){

	eval("document.forms[0].currAmt_"+index).value=	((parseFloat(curr_deno)) * (parseFloat(curr_num)));	
	//v_totAmt=eval("document.forms[0].total").value;
for(i=0;i<tot_rec;i++)
	{
	
	if(v_totAmt=="")v_totAmt=0;
		cu_totAmt=eval("document.forms[0].currAmt_"+i).value;
	if(cu_totAmt=="")cu_totAmt=0.00;	
		v_totAmt=parseFloat(v_totAmt)+ parseFloat(cu_totAmt);
		

	}
	if (parseFloat(v_totAmt) > parseFloat(cashinhand))
	{		
		//alert("cash in hand is less");		
		alert(getMessage("BL7330","BL"));
		obj.value="";
		eval("document.forms[0].currAmt_"+index).value="";
		eval("document.forms[0].currDeno_"+index).select();
		return;
	}
		eval("document.forms[0].cash_total").value=v_totAmt;
		parent.parent.frames[0].document.getElementById("handoverrequestamt").value =v_totAmt;
	}else{
		eval("document.forms[0].currAmt_"+index).value="";	
		for(i=0;i<tot_rec;i++)
			{			
			if(v_totAmt=="")v_totAmt=0;
				cu_totAmt=eval("document.forms[0].currAmt_"+i).value;
			if(cu_totAmt=="")cu_totAmt=0.00;	
				v_totAmt=parseFloat(v_totAmt)+ parseFloat(cu_totAmt);
				eval("document.forms[0].cash_total").value=v_totAmt;
				parent.parent.frames[0].document.getElementById("handoverrequestamt").value =v_totAmt;
				

			}
		}

	

putdeci_temp(eval("document.forms[0].cash_total"),noofdecimal)
	

}

function checkForDuplicate(cashDeno,index)
{
	var noofdecimal =document.getElementById("noofdecimal").value;
	if(cashDeno.value!="" && cashDeno.value==0)
	{
		alert(getMessage("CANNOT_BE_ZERO","Common"));
		cashDeno.select();

	}
	
	var temp_index=0;
	if( parseFloat(index)!=0) {
	if(eval("document.forms[0].currDeno_"+index).value!="") {
		
		temp_index =  parseFloat(index)-1;
		if(eval("document.forms[0].currDeno_"+temp_index).value==""){

		var msg1	= getMessage("CAN_NOT_BE_BLANK","Common")				
		msg1		= msg1.replace('$', getLabel("Common.previous.label","Common"));
		alert(msg1);
		// alert("Enter prev row");
		eval("document.forms[0].currDeno_"+index).focus();
		}
	}

}

putdeci_temp(cashDeno,noofdecimal)
	
	var total_records = 0;
	total_records = document.getElementById("totalRecordsCash").value;
//	alert("total_records :"+total_records);
	if(eval("document.forms[0].currDeno_"+index).value!="") {
	if(total_records>1)
	{
		var xmlStr ="<root><SEARCH ";
		for(var i=0;i<total_records; i++)
		{
			xmlStr+= "code_"+i+"=\"" + eval("document.forms[0].currDeno_"+i).value + "\" " ;

		}
		xmlStr+= "item=\"" + cashDeno.value + "\" " ;		
		xmlStr+= "index=\"" + index + "\" " ;		
		xmlStr+= "total_records=\"" + total_records + "\" " ;
		xmlStr +=" /></root>";
		//alert("xmlStr:"+xmlStr)
		var updation=formValidation(xmlStr,"DUPLICATE_CHECK");
	}
	}

}

function duplicateAlert(index)
{		
	alert(getMessage("CODE_ALREADY_EXISTS",'common'));
	eval("document.forms[0].currDeno_"+index).value="";		
	eval("document.forms[0].currDeno_"+index).focus();	
	/*eval("document.forms[0].mode").value;	
	if (mode="modify")
	{
		eval("document.forms[0].cashSelect_"+index).checked=false;
	}*/
	
}

function allowValidNumber1_temp(obj,event,noofdecimal){	

	
	if(allowValidNumber(obj,event,noofdecimal))
		return true;
	else
		return false
	//ChkNumberInput(obj,event,parent.PkgDefHeader.document.frmPkgDefHeader.noofdecimal.value));

}

function selectChk(rec_cnt)
{
	var chk_amt = 0.00;
	var tot_chk_amt=0.00;
	if(eval("document.forms[0].chkSelect_"+rec_cnt).checked){

		eval("document.forms[0].chkSelect_"+rec_cnt).value='Y';

		chk_amt =eval("document.forms[0].chqAmount_"+rec_cnt).value;					
		//alert("chk_amt "+chk_amt);
		if(document.forms[0].cheque_total.value!=""){
			tot_chk_amt =document.forms[0].cheque_total.value		}
			if(chk_amt!="")	{
				tot_chk_amt=parseFloat(tot_chk_amt) + parseFloat(chk_amt);
			}
			document.forms[0].cheque_total.value  =  parseFloat(tot_chk_amt );
			//var temp_tot_value=eval("document.forms[0].cheque_total");
			//putDecimal(temp_tot_value,17,"2");
			

	}else{
		
		eval("document.forms[0].chkSelect_"+rec_cnt).value='N';
		chk_amt =eval("document.forms[0].chqAmount_"+rec_cnt).value;
		if(document.forms[0].cheque_total.value!=""){
			tot_chk_amt =document.forms[0].cheque_total.value		}
			if(chk_amt!="")	{
				tot_chk_amt=parseFloat(tot_chk_amt) - parseFloat(chk_amt);
			}
			if(tot_chk_amt!=0){
			document.forms[0].cheque_total.value  =  parseFloat(tot_chk_amt );
			}else{
				document.forms[0].cheque_total.value  =  "";
			}
	}	
	
		var noofdecimal =document.getElementById("noofdecimal").value;
	
var obj = (eval("document.forms[0].cheque_total"));
putdeci_temp(obj,noofdecimal);

}

function selectCash(rec_cnt)
{
	var v_totAmt=0.0;
	var tot_rec =document.getElementById("totalRecordsCash").value;
	if(eval("document.forms[0].cashSelect_"+rec_cnt).checked){
		eval("document.forms[0].cashSelect_"+rec_cnt).value='Y';
		
	}else{
		eval("document.forms[0].cashSelect_"+rec_cnt).value='N';
		eval("document.forms[0].currDeno_"+rec_cnt).value="";
		eval("document.forms[0].currNumber_"+rec_cnt).value="";
		eval("document.forms[0].currAmt_"+rec_cnt).value="";
	for(i=0;i<tot_rec;i++)
	{
		if(v_totAmt=="")v_totAmt=0;
			cu_totAmt=eval("document.forms[0].currAmt_"+i).value;
		if(cu_totAmt=="")cu_totAmt=0.00;	
			v_totAmt=parseFloat(v_totAmt)+ parseFloat(cu_totAmt);		

	}
		var noofdecimal =document.forms[0].noofdecimal.value;
	eval("document.forms[0].cash_total").value=v_totAmt;
	parent.parent.frames[0].document.getElementById("handoverrequestamt").value =v_totAmt;
	putdeci_temp(eval("document.forms[0].cash_total"),noofdecimal)



	}


}


function callTotAmt(obj,totalRecordsCash)
{
	var noofdecimal =document.getElementById("noofdecimal").value;
	putdeci_temp(obj,noofdecimal);		
	var tot_recs=(eval("document.forms[0].totalRecordsCash").value);
	var mode=(eval("document.forms[0].mode").value);
	
	//eval("document.forms[0].cash_total").value=obj.value;
	//BLCashChequeHandoverReqDtlsFrame.BLCashChequeHandoverCashCounterFrame.document.forms[0].handoverrequestamt.value =obj.value;
	if(obj.value!="" && obj.value==0)
	{
		alert(getMessage("CANNOT_BE_ZERO","Common"));
		obj.select();

	}
	var cashinhand=parent.parent[1].document.getElementById("cashInHand").value;		
	if(obj.value!="" && obj.value!=0){		
		
		if(parseFloat(obj.value) >parseFloat(cashinhand)){
			alert(getMessage("BL7330","BL"));
			obj.select();}
	}

	parent.parent.frames[0].document.getElementById("handoverrequestamt").value =obj.value;
	if(obj.value!=""){
		for(i=0;i<tot_recs;i++)
		{			
			if(eval("document.forms[0].currDeno_"+i).value!="")
			{
				eval("document.forms[0].currDeno_"+i).value="";
				eval("document.forms[0].currNumber_"+i).value="";
				eval("document.forms[0].currAmt_"+i).value="";
				eval("document.forms[0].cash_total").value="";
				if(mode=='modify')
				{
					eval("document.forms[0].cashSelect_"+i).checked= false;
				}
			}

			eval("document.forms[0].currDeno_"+i).disabled=true;			
			eval("document.forms[0].currNumber_"+i).readOnly=true;
			eval("document.forms[0].currAmt_"+i).readOnly=true;
			document.forms[0].addBtn.disabled=true; 
		}
	//	eval("document.forms[0].cash_total").focus();
	}else{
		
		for(i=0;i<tot_recs;i++)
		{
			eval("document.forms[0].currDeno_"+i).disabled=false;
			eval("document.forms[0].currNumber_"+i).readOnly=false;
			eval("document.forms[0].currAmt_"+i).readOnly=false;
			document.getElementById("addBtn").disabled=false; 
		}
		}
		
}


function chkRequestYn(reqYn)
{
	if (reqYn=='X')
	{
		//alert("Only one request can exist at a time");
		alert(getMessage("BL7331",'BL'));
		document.location.reload();
		
	}
}

async function chequeLookup(obj,rec_cnt,cl_event)
{
		var target			=  eval("document.forms[0].chqNum_"+rec_cnt);		

		if(cl_event == 'B')
		{
			if( target.value == "")
			{
				target.value = "";		
					eval("document.forms[0].chqNum_"+rec_cnt).value		= ""; 
					eval("document.forms[0].chqDate_"+rec_cnt).value	= "";
					eval("document.forms[0].bank_"+rec_cnt).value		= ""; 
					eval("document.forms[0].payer_"+rec_cnt).value		= ""; 
					eval("document.forms[0].patientId_"+rec_cnt).value	= ""; 
					eval("document.forms[0].chqAmount_"+rec_cnt).value	= ""; 
				return;
			}
		}
		var retVal			= new String();	
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var sql3				= "";		

		var title=getLabel("eBL.CHEQ_DTLS.label","BL");
		title=encodeURIComponent(title);
		var column_sizes = escape("10%,10%,10%,10%,10%,10%");
		var locale = document.forms[0].locale.value;
		var facility_id = document.forms[0].facility_id.value;	
		var cheq_no		=	getLabel("eBL.CHEQ_NUM.label","BL");
		cheq_no=encodeURIComponent(cheq_no);
		var cdate		=	getLabel("eBL.CHEQ_DATE.label","BL");
		cdate			=	encodeURIComponent(cdate);
		var bank		=	getLabel("eBL.BANK_NAME.label","BL");
		bank			=	encodeURIComponent(bank);
		var payer		=	getLabel("Common.Payer.label","common");
		payer			=	encodeURIComponent(payer);
		var patient		=	getLabel("Common.patient.label","common");
		patient			=	encodeURIComponent(patient);
		var cAmt		=	getLabel("Common.amount.label","common");
		cAmt			=	encodeURIComponent(cAmt);


		var login_date		 =   document.forms[0].logigDateTime.value;
		var req_date		 =   document.forms[0].reqDateTime.value;  
		var cash_counter_code=	 document.forms[0].cashCounterCode.value;
		

		var column_descriptions = cheq_no+","+cdate+","+bank+","+payer+","+patient+","+cAmt;
		var message = '';		
		var locale = document.forms[0].locale.value;
		var sql1 = "select CHEQUE_NUMBER CHEQUE_NUMBER,to_char(CHEQUE_DATE,'dd/mm/yyyy') CHEQUE_DATE,BANK_DETAIL BANK_DETAIL,CUST_CODE CUST_CODE,PATIENT_ID PATIENT_ID,CQ_AMOUNT CQ_AMOUNT from bl_cheques_coll_vw where acc_entity_id = '"+facility_id+"'  AND cash_counter_facility_id = '"+facility_id+"'  AND cash_counter_code = '"+cash_counter_code+"' AND nvl(doc_date, to_date('"+login_date+"','dd/mm/yyyy HH24:MI:SS')) BETWEEN nvl(to_date('"+login_date+"','dd/mm/yyyy HH24:MI:SS'), trunc(SYSDATE)) AND SYSDATE   AND nvl(cancelled_date, to_date('"+login_date+"','dd/mm/yyyy HH24:MI:SS')) BETWEEN       nvl(TO_DATE('"+login_date+"','dd/mm/yyyy HH24:MI:SS'), trunc(SYSDATE)) AND  nvl(TO_DATE('"+req_date+"','dd/mm/yyyy HH24:MI:SS'), trunc(SYSDATE))";
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql1+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYYYYY";
		
		retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
		
		var arr=new Array();	

	    if(retVal == null) retVal='';
		if (retVal != null || retVal!="")
		 {
			  var retVal=unescape(retVal);

			  if(retVal != null && retVal.length>0)
			  {
					arr=retVal.split("^~^");	
					eval("document.forms[0].chqNum_"+rec_cnt).value		= arr[0]; 
					arr[1]=convertDate(arr[1],"DMY","en",locale);
					eval("document.forms[0].chqDate_"+rec_cnt).value	= arr[1]; 
					eval("document.forms[0].bank_"+rec_cnt).value		= arr[2]; 
					eval("document.forms[0].payer_"+rec_cnt).value		= arr[3]; 
					eval("document.forms[0].patientId_"+rec_cnt).value	= arr[4]; 
					eval("document.forms[0].chqAmount_"+rec_cnt).value	= arr[5]; 				
					
					
			  }else{
					eval("document.forms[0].chqNum_"+rec_cnt).value		= ""; 					
					eval("document.forms[0].chqDate_"+rec_cnt).value	= "";
					eval("document.forms[0].bank_"+rec_cnt).value		= "";
					eval("document.forms[0].payer_"+rec_cnt).value		= "";
					eval("document.forms[0].patientId_"+rec_cnt).value	= "";
					eval("document.forms[0].chqAmount_"+rec_cnt).value	= "";
			  }
		 }
		  var totalRecordsChq = document.getElementById("totalRecordsChq").value;	
		for(var i=0;i<rec_cnt;i++)
		{	
			var cheq_num = eval("document.forms[0].chqNum_"+i).value
			if( eval("document.forms[0].chqNum_"+rec_cnt).value == cheq_num)
			{
				alert(getMessage("CODE_ALREADY_EXISTS",'common'));
				eval("document.forms[0].chkSelect_"+rec_cnt).value		= "N"; 
				eval("document.forms[0].chkSelect_"+rec_cnt).checked = false; 

				eval("document.forms[0].chqNum_"+rec_cnt).value		= ""; 
				eval("document.forms[0].chqDate_"+rec_cnt).value	= "";
				eval("document.forms[0].bank_"+rec_cnt).value		= ""; 
				eval("document.forms[0].payer_"+rec_cnt).value		= ""; 
				eval("document.forms[0].patientId_"+rec_cnt).value	= ""; 
				eval("document.forms[0].chqAmount_"+rec_cnt).value	= ""; 
				return false;
			}
		}
		 var cheq_num1 = eval("document.forms[0].chqNum_"+rec_cnt).value			
		 if(cheq_num1!=""){
		var tot_cheq_amt=0;tot_amt=0;
		 var noofdecimal = document.getElementById("noofdecimal").value;	
		 var obj1 =  eval("document.forms[0].chqAmount_"+rec_cnt)
		 putdeci_temp(obj1,noofdecimal);

		 tot_cheq_amt=eval("document.forms[0].cheque_total").value;		
		 if(tot_cheq_amt=="")tot_cheq_amt=0.00;	
		 //alert(tot_cheq_amt);
		
		 if(rec_cnt!=0){
			 //for(var i=0;i<rec_cnt;i++)//{	
				tot_cheq_amt=parseFloat(tot_cheq_amt)+ parseFloat(eval("document.forms[0].chqAmount_"+rec_cnt).value)
			 //}		
			eval("document.forms[0].cheque_total").value	= tot_cheq_amt;
		}else{ 
			eval("document.forms[0].cheque_total").value =eval("document.forms[0].chqAmount_"+rec_cnt).value	
		}
	var obj = (eval("document.forms[0].cheque_total"));
	putdeci_temp(obj,noofdecimal);
		 }
}

function modifyRequestYn(recfoundYN)
{	
//alert("recfoundYN "+recfoundYN);
	if (recfoundYN!='X')
	{
		alert(getMessage("NO_RECORD_FOUND",'common'));
		document.location.reload();

	}

}


function callAlertFunction(hand_without_counter_chk_out) {
	//alert("not applicable");
//	parent.content.frames[0].document.forms[0].home.click();
//	parent.content.location.href='../../eCommon/jsp/maindisplay.jsp';
alert(getMessage("BL7312",'BL'));
document.location.href='../../eCommon/jsp/dmenu.jsp';

}

