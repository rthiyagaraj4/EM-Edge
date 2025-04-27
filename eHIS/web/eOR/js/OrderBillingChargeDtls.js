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
?             100            ?           created
14/09/2012    IN034785      Chowminya G     Incident No: IN034785 <In the multi-facility scenario -  Charge details display> 
26/03/2013    Aplha(IN038960)         Chowminya G     Billing paid amount displayed 0.0
---------------------------------------------------------------------------------------------------------------
*/
var result = false;
var message = "" ;
var flag = "" ;
var invalidCode = "" ;



// Call the Revise Billing Related Informations . if present
async function callReviseBilling(row_value,called_from,patient_id,encounter_id,service_panel_ind,service_panel_code,episode_type,episode_id,visit_id,order_id,order_line_no,ord_facility)
{
	var practitioner_id	= "";
	var bean_id		 = "";
	var bean_name	 = "";
	if(called_from=="NEW_ORDER" || called_from=="AMEND_ORDER"){
		var formObj		= document.placeOrderForm;
	//var localeName			= document.placeOrderForm.localeName.value;
	}else{
		var formObj		= document.billing_details;
	}
	practitioner_id	= formObj.ordering_practitioner.value;
	bean_id 		= formObj.bean_id.value;
	bean_name 		= formObj.bean_name.value;
	
	
	var key_ref		= "";
	var key_line_no	= "";
	
	if(called_from=="NEW_ORDER")
	{
		quantity		= eval("document.placeOrderForm.quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.cat_desc"+row_value+".value");
		key_ref			= patient_id+encounter_id+catalog_code;
		key_line_no		= "";
		//start_date_time = start_date_time.substr(0, (start_date_time.indexOf(" ") ) );
	}else if(called_from=="AMEND_ORDER") 
	{
		quantity		= eval("document.placeOrderForm.amend_quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.amend_start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.amend_catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.amend_cat_desc"+row_value+".value");
		key_ref			= order_id;
		key_line_no		= order_line_no;
	}else {
		quantity		= eval("document.billing_details.order_qty"+row_value+".value");
		start_date_time	= eval("document.billing_details.start_date_time"+row_value+".value");
		catalog_code	= eval("document.billing_details.order_catalog_code"+row_value+".value");
		cat_desc		= eval("document.billing_details.order_catalog_desc"+row_value+".value");
		key_ref			= order_id;
		key_line_no		= order_line_no;
		bean_id			= ""; //On purpose it is passed as  null
	}
	

/*	alert('bean_id'+bean_id);
	alert('bean_name'+bean_name);
	alert('quantity'+quantity);
	alert('start_date_time'+start_date_time);
	alert('catalog_code'+catalog_code);
	alert('key_line_no'+key_line_no);*/


	var query_string = "title="+encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"))+"&bean_id="+bean_id+"&module_id=OR&patient_id="+patient_id+"&encounter_id="+encounter_id+"&key="+key_ref+"&order_catalog_code="+catalog_code+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+start_date_time+"&episode_type="+episode_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&pract_staff_ind=P&pract_staff_id="+practitioner_id+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&called_from="+called_from+"&ord_facility="+ord_facility; // --[IN034785]
//alert('query_string===='+query_string);	
	var retVal ;
	var dialogTop		= "10";
	var dialogLeft		= "10";
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:'+dialogLeft+'; dialogTop:'+dialogTop +'; scroll=no; status=no';
	var arguments		= "";
	//alert("query_string="+query_string);
	retVal	 			= await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+query_string,arguments,features);	//alert("retVal[0]="+retVal[0])

	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal!=null && retVal != undefined)
	{
		if(retVal[0]=="Y")
		{
		//	alert("Updated Successfully");
		/*	etArray[0]="Y";
			retArray[1]=total_payable;
			retArray[2]=patient_payable;
			retArray[3]=patient_paid;
			retArray[4]=quantity;
			retArray[5]=rate;
			retArray[6]=incl_excl_action;
			
			alert("row_value="+row_value);
			alert("called_from="+called_from);
			alert("retVal[1]="+retVal[1]);
			alert("retVal[2]="+retVal[2]);
			alert("retVal[3]="+retVal[3]);
			alert("retVal[6]="+retVal[6]);*/
			

			
			//loadRevisedBillDtls(row_value,called_from,retVal[1],retVal[2],retVal[3],retVal[6]);
			loadRevisedBillDtls(row_value,called_from,retVal[1],retVal[2],retVal[3],retVal[8]);
			
		}
				
	}
	
		
	
} // End of callBilling

function reviseBillingchrgs(row_value,called_from)
{
	
	var formObj		= document.placeOrderForm;
		
	bean_id 		= formObj.bean_id.value;
	bean_name 		= formObj.bean_name.value;
	var localeName	= formObj.localeName.value;
	var order_id	= "";
	var order_line_no= "";

	if(called_from=="NEW_ORDER")
	{
		
		if(eval("document.placeOrderForm.billing_call_yn"+row_value).value == 'N' || eval("document.placeOrderForm.billing_call_yn"+row_value).value == '')
			return false;
		
		quantity		= eval("document.placeOrderForm.quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.cat_desc"+row_value+".value");
		
	}
	else if(called_from=="AMEND_ORDER") // For New Orders or orderset
	{
		if(eval("document.placeOrderForm.amend_billing_call_yn"+row_value).value == 'N' || eval("document.placeOrderForm.amend_billing_call_yn"+row_value).value == '')
			return false;
		
		quantity		= eval("document.placeOrderForm.amend_quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.amend_start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.amend_catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.amend_cat_desc"+row_value+".value");
		order_id		= eval("document.placeOrderForm.amend_order_id"+row_value+".value");
		order_line_no	= eval("document.placeOrderForm.amend_order_line_num"+row_value+".value");
	}else {
		quantity		= eval("document.billing_details.order_qty"+row_value+".value");
		start_date_time	= eval("document.billing_details.start_date_time"+row_value+".value");
		catalog_code	= eval("document.billing_details.order_catalog_code"+row_value+".value");
		cat_desc		= eval("document.billing_details.order_catalog_desc"+row_value+".value");
		key_ref			= order_id;
		key_line_no		= order_line_no;
		bean_id			= ""; //On purpose it is passed as  null
	}

/*	alert('bean_id'+bean_id);
	alert('bean_name'+bean_name);
	alert('quantity'+quantity);
	alert('start_date_time'+start_date_time);
	alert('catalog_code'+catalog_code);
*/

	if(start_date_time!="" && quantity!="" && catalog_code!="")
	{
		var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
		var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
		xmlHttp.open("POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&quantity="+quantity+"&catalog_code="+escape(catalog_code)+"&start_date_time="+start_date_time+"&cat_desc="+escape(cat_desc)+"&order_id="+order_id+"&order_line_no="+order_line_no+"&row_value="+row_value+"&called_from="+called_from+"&localeName="+localeName+"&func_mode=GETREVISEDBILLINGDETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	} 
} // End of callBilling

function loadRevisedBillDtls(row_value,called_from,actual_amt,pat_payable_amt,pat_paid_amt,inc_excl_actn){

	
	if(called_from=="NEW_ORDER" || called_from== "EXIST_ORDER")
	{
		
		eval(document.getElementById("actual_"+row_value)).innerText	= actual_amt;
		eval(document.getElementById("payable_"+row_value)).innerText	= pat_payable_amt;
		eval(document.getElementById("paid_"+row_value)).innerText	= pat_paid_amt;
		if(eval(document.getElementById("included_"+row_value)))
		eval(document.getElementById("included_"+row_value)).innerText	= (inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":"");
		
	}else  if(called_from=="AMEND_ORDER"){
		eval(document.getElementById('amend_actual_'+row_value)).innerText		= actual_amt;
		eval(document.getElementById("amend_payable_"+row_value)).innerText		= pat_payable_amt;
		eval(document.getElementById("paid_"+row_value)).innerText	= pat_paid_amt;
		eval(document.getElementById("amend_included_"+row_value)).innerText	= (inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":"");
	
	}
	showBillingTable();


}

//to calulate the total billing charges for the select orderables.
function showBillingTable()
{
	
	var bill_show	 = false;
	var actual_amt	 = 0.0;
	var payable_amt	 = 0.0;
	var paid_amt     = 0.0; //Alpha
	var billing_call_yn = "";
	
	
   
	if(document.placeOrderForm)
	{
		for(var i=0;i<document.placeOrderForm.amend_total_rows.value;i++)
		{
			if(eval("document.placeOrderForm.amend_billing_call_yn"+i))
			{
				var amend_billing_call_yn = eval("document.placeOrderForm.amend_billing_call_yn"+i).value ;
			
				if(amend_billing_call_yn =="Y")
				{
					bill_show = true;
					if(eval(document.getElementById("amend_actual_"+i)))
					{
						var temp_act = eval(document.getElementById("amend_actual_"+i)).innerText;
					}
					if(eval(document.getElementById("amend_payable_"+i)))
					{
						var temp_pay = eval(document.getElementById("amend_payable_"+i)).innerText;
					}
					if(eval(document.getElementById("amend_paid_"+i))) //Aplha
					{ 
						var temp_paid = eval(document.getElementById("amend_paid_"+i)).innerText;
					}		
					actual_amt	 += parseFloat(eval(temp_act));
					payable_amt	 += parseFloat(eval(temp_pay));
					paid_amt	 += parseFloat(eval(temp_paid));
					
					//alert("actual_amt==="+actual_amt+"==temp_act==="+temp_act +"payable_amt===="+payable_amt+"==temp_pay==="+temp_pay+"=="+i+"==")
				 }
			 }
		}
		
		for(var i=0;i<document.placeOrderForm.total_rows.value;i++)
		{
			if(eval("document.placeOrderForm.billing_call_yn"+i))
			{
				var billing_call_yn = eval("document.placeOrderForm.billing_call_yn"+i).value ;			
				if(billing_call_yn =="Y")
				{
					bill_show = true;
					if(eval(document.getElementById("actual_"+i)))
						var temp_act = eval(document.getElementById("actual_"+i)).innerText;
					if(eval(document.getElementById("payable_"+i)))
						var temp_pay = eval(document.getElementById("payable_"+i)).innerText;
					if(eval(document.getElementById("paid_"+i)))
						var temp_paid = eval(document.getElementById("paid_"+i)).innerText;	//Aplha
					
					actual_amt	 += parseFloat(eval(temp_act));
					payable_amt	 += parseFloat(eval(temp_pay));
					paid_amt	 += parseFloat(eval(temp_paid)); //Aplha
					
				}
			}
		}
		
		if(bill_show)
		{
			if(parent.criteriaDetailFrame.document.getElementById("billing_dtl"))
				parent.criteriaDetailFrame.document.getElementById("billing_dtl").style.visibility  = "visible" ;
			actual_amt	 += "";
			payable_amt	 += "";
			paid_amt	 += ""; //Aplha
			if(actual_amt.indexOf(".") == -1)
				actual_amt	 += ".0";
			if(payable_amt.indexOf(".") == -1)
				payable_amt	 += ".0";
			if(payable_amt.indexOf(".") == -1)
				paid_amt	 += ".0"; //Aplha	
			if(parent.criteriaDetailFrame.document.getElementById("actual_"))
				parent.criteriaDetailFrame.document.getElementById("actual_").innerText	  = actual_amt;
			if(parent.criteriaDetailFrame.document.getElementById("payable_"))
				parent.criteriaDetailFrame.document.getElementById("payable_").innerText	  = payable_amt;
			if(parent.criteriaDetailFrame.document.getElementById("paid_"))
				parent.criteriaDetailFrame.document.getElementById("paid_").innerText	  = paid_amt; //Aplha			


		}
		else
		{
			if(parent.criteriaDetailFrame.document.getElementById("billing_dtl"))
				parent.criteriaDetailFrame.document.getElementById("billing_dtl").style.visibility  = "hidden";
			if(parent.criteriaDetailFrame.document.getElementById("actual_"))
				parent.criteriaDetailFrame.document.getElementById("actual_").value	  = "0.0";
			if(parent.criteriaDetailFrame.document.getElementById("payable_"))
				parent.criteriaDetailFrame.document.getElementById("payable_").value	  = "0.0";  
			if(parent.criteriaDetailFrame.document.getElementById("paid_"))
				parent.criteriaDetailFrame.document.getElementById("paid_").value	  = "0.0"; //Aplha	
		}
	}
	else
	{
		
		for(var i=0;i<document.getElementById("total_rows").value;i++)
		{
			if(eval(document.getElementById("billing_call_yn"+i)))
			{
				var billing_call_yn = eval(document.getElementById("billing_call_yn"+i)).value ;			
				if(billing_call_yn =="Y")
				{
					bill_show = true;
					if(eval(document.getElementById("actual_"+i)))
						var  temp_act = eval(document.getElementById("actual_"+i)).innerText;
					if(eval(document.getElementById("payable_"+i)))
						var temp_pay = eval(document.getElementById("payable_"+i)).innerText;
					if(eval(document.getElementById("paid_"+i)))
						var temp_paid = eval(document.getElementById("paid_"+i)).innerText;		//Aplha
					
					actual_amt	 += parseFloat(eval(temp_act));
					payable_amt	 += parseFloat(eval(temp_pay));	
					paid_amt	 += parseFloat(eval(temp_paid));	//Aplha
					
				}
			}

		}
		
		if(bill_show)
		{
			if(parent.OrderBillChargBtn.document.getElementById("total_"))
				parent.OrderBillChargBtn.document.getElementById("total_").style.visibility	  = "visible";
			if(parent.OrderBillChargBtn.document.getElementById("actual_"))
				parent.OrderBillChargBtn.document.getElementById("actual_").style.visibility	  = "visible";
			if(parent.OrderBillChargBtn.document.getElementById("payable_"))
				parent.OrderBillChargBtn.document.getElementById("payable_").style.visibility	  = "visible";
			if(parent.OrderBillChargBtn.document.getElementById("paid_"))
				parent.OrderBillChargBtn.document.getElementById("paid_").style.visibility	  = "visible";
			actual_amt	 += "";
			payable_amt	 += "";
			paid_amt	 += ""; //Aplha
			if(actual_amt.indexOf(".") == -1)
				actual_amt	 += ".0";
			if(payable_amt.indexOf(".") == -1)
				payable_amt	 += ".0";
			if(paid_amt.indexOf(".") == -1)  
				paid_amt	 += ".0";  //Aplha
			if(parent.OrderBillChargBtn.document.getElementById("actual_"))
				parent.OrderBillChargBtn.document.getElementById("actual_").innerText	  = actual_amt;
			if(parent.OrderBillChargBtn.document.getElementById("payable_"))
				parent.OrderBillChargBtn.document.getElementById("payable_").innerText  = payable_amt;
			if(parent.OrderBillChargBtn.document.getElementById("paid_"))
				parent.OrderBillChargBtn.document.getElementById("paid_").innerText  = paid_amt; //Aplha


		}
		else
		{
			if(parent.OrderBillChargBtn.document.getElementById("total_"))
				parent.OrderBillChargBtn.document.getElementById("total_").style.visibility	  = "hidden";
			if(parent.OrderBillChargBtn.document.getElementById("actual_"))
				parent.OrderBillChargBtn.document.getElementById("actual_").style.visibility	  = "hidden";
			if(parent.OrderBillChargBtn.document.getElementById("payable_"))
				parent.OrderBillChargBtn.document.getElementById("payable_").style.visibility	  = "hidden";
			if(parent.OrderBillChargBtn.document.getElementById("paid_"))
				parent.OrderBillChargBtn.document.getElementById("paid_").style.visibility	  = "hidden";
			if(parent.OrderBillChargBtn.document.getElementById("actual_"))
				parent.OrderBillChargBtn.document.getElementById("actual_").innerText			  = "0.0";
			if(parent.OrderBillChargBtn.document.getElementById("payable_"))
				parent.OrderBillChargBtn.document.getElementById("payable_").innerText		  = "0.0";  
			if(parent.OrderBillChargBtn.document.getElementById("paid_"))
				parent.OrderBillChargBtn.document.getElementById("paid_").innerText		      = "0.0";  	//Aplha
		}

	}
}

function recordBillCharges(){
	
	
	eval(formApply( parent.OrderBillChargeDetail.document.billing_details,OR_CONTROLLER)) ;
	alert(getMessage(message,"SM"));
		
	if( result ) {
		//onSuccess();
		window.close();
	} 
}

function assignResult( _result, _message, _flag, _code){
	
	result		 = _result ;
	message		 = _message ;
	flag		 = _flag ;
	invalidCode	 = _code ;

}

function onSuccess() {
	
	window.close();
	 
	
}
