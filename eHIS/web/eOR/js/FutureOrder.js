/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var invalidCode = "" ;
var qry_string = "";
var qry_string_fr_print = "";
var querystring="";


// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll()
{
	if(document.future_order_hdg.select_all.checked == true)
	{
		for(cnt=0; cnt<parent.future_order_dtl.future_order_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.future_order_dtl.future_order_dtl.chk"+cnt);
			if(eval("parent.future_order_dtl.future_order_dtl.chk"+cnt).disabled==false)
			{
				val.checked = true;	 
			}
		}
	}
	else
	{
		for(cnt=0; cnt<parent.future_order_dtl.future_order_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.future_order_dtl.future_order_dtl.chk"+cnt);
			val.checked = false;
		}
	}
}

function clearChecked()
{
	//parent.future_order_dtl.future_order_dtl.reset()
	window.close();
}

function checkDateRange(obj,from)
{
	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")
	var localeName = eval("document."+from+".localeName")
		
	//if(chckDate2(obj)){ // removed on 14/02/2007 while doing thai date validations
	if(validDateObj(obj,"DMY",localeName)){// function in DateUtils.js added for thai date validations
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js// removed on 14/02/2007 while doing thai date validations
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	}else{
		parent.AuthoriseOrderTop.document.authorise_order.period_to.value=parent.AuthoriseOrderTop.document.authorise_order.temp_last_week_date.value;
	
	}


}

function future()
{
	var no_of_checked = 0;
	var formObj = parent.future_order_dtl.future_order_dtl;
	var arguments = "";
	flag = false
	for(cnt=0; cnt<formObj.total_recs.value; cnt++)
	{
		val = eval("parent.future_order_dtl.future_order_dtl.chk"+cnt);
		patient_class = eval("parent.future_order_dtl.future_order_dtl.patient_class"+cnt);
		ord_id = eval("parent.future_order_dtl.future_order_dtl.ord_id"+cnt);
		
		if(eval("parent.future_order_dtl.future_order_dtl.chk"+cnt))
		{
			if(val.checked == true)
			{
				no_of_checked++;
			}
		}
	}
		
	if(parseInt(no_of_checked) == 0)
	{
		if(parent.future_order_dtl.future_order_dtl.recordedSize.value==0)
		{
			alert(getMessage('CLICK_ANY_ONE','OR'));
			return false
		}
	}
	if((parseInt(no_of_checked,10) > 0) || (parseInt(parent.future_order_dtl.future_order_dtl.recordedSize.value,10)>0))
	{
		var multi_message="";
		if(document.future_order_btn.FutureOrderConfirm.name=="Confirm")
		{
			var confirm_val = window.confirm(getMessage("RECORD_CONFIRM","OR"));
			if(confirm_val)
			{
				eval(formApply( parent.future_order_dtl.future_order_dtl,OR_CONTROLLER)) ;				
				if(message.indexOf("|")!=-1)
				{
					msg_array=message.split("|");
					for(m=0;m<msg_array.length;m++)
					{
						multi_message=multi_message+msg_array[m]+"\n";
					}
					alert(multi_message);
				}
				else
				{
					alert(message);
				}
				if(result) 
				{
					onSuccess();
				}
			}
			else
			{
				window.close();
			}
		}
		else
		{
			eval(formApply( parent.future_order_dtl.future_order_dtl,OR_CONTROLLER)) ;
			if(message.indexOf("|")!=-1)
			{
				msg_array=message.split("|");
				for(m=0;m<msg_array.length;m++)
				{
					multi_message=multi_message+msg_array[m]+"\n";
				}
				alert(multi_message);
			}
			else
			{
				alert(message);
			}
			 if(result) 
			{
				 onSuccess();
			}
		}
	}
}
		
function assignResult(_result, _message, _flag, _invalidCode){
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode;
}

function onSuccess() {
	/*querystring=parent.future_order_dtl.future_order_dtl.querystring.value;
	
//querystring=parent.future_order_dtl.querystring.value;
alert(querystring);
parent.future_order_dtl.document.location.href="../../eOR/jsp/FutureOrderBottomRightDtl.jsp?querystring";

//parent.future_order_dtl.document.future_order_dtl.submit();
//document.getElementById("reset")();*/
window.close();
}




/*******/
function getNext(flagSelect){
var formObj= parent.AuthorizeOrdersBottomRight1.document.authorise_order_dtl
top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
formObj.nextPrevFlag.value=flagSelect;//set the Flag to next or Prevoius
formObj.action.value="nextPrev";//var late=applyupdate();
}

function chckDate(Object2,focusflag)
{
	var localeName = parent.AuthoriseOrderTop.document.authorise_order.localeName.value
if(validDateObj(Object2,"DMY",localeName)==false)// thai date validations 16/02/2007. function from DateUtils.js
	{	parent.AuthoriseOrderTop.document.authorise_order.period_from.value=parent.AuthoriseOrderTop.document.authorise_order.temp_curr_week_date.value;
	}
}

async function callMenuFunctions(colval1,colval,orderId,sex,patient_id,encounter_id,patient_class){
	var dialogHeight ='80vh' ;
	var dialogWidth = '70vw' ;
	var dialogTop	= '100';
	var dialogLeft = '100' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	var arguments = "";

	var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class;
	var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}
function FutureOrder(querystring)
{
	/*var p_patient_id="SD00000866";
	var p_episode_id="10002544";
	var p_encounter_id="10002544";
	var p_source_type="N";
	var p_source_code="GNSU";
	var p_episode_visit_num="";
	var p_patient_class="IP";*/
	//if(parent.window){parent.window.close();}
	//var query_string = "title="+encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"))+"&bean_id="+bean_id+"&module_id=OR&patient_id="+patient_id+"&encounter_id="+encounter_id+"&key="+key_ref+"&order_catalog_code="+catalog_code+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+start_date_time+"&episode_type="+episode_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&pract_staff_ind=P&pract_staff_id="+practitioner_id+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no;*/
			//var queryString = "p_patient_id=SD00000866&p_episode_id=10002544&p_encounter_id=10002544&p_source_type=N&p_source_code=GNSU&p_episode_visit_num=""&p_patient_class=IP";
			//alert(queryString);
			var queryString =querystring; 
			var retVal = 	new String();
			var dialogHeight= "37.5" ;
			var dialogWidth	= "50" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
			queryString+="&modal_yn=Y";
			retVal=window.showModalDialog("../../eOR/jsp/FutureOrderDtl.jsp?"+queryString,arguments,features);
			
			//document.location.reload();
}
async function callReviseBilling(row_value,called_from,patient_id,encounter_id,service_panel_ind,service_panel_code,episode_type,episode_id,visit_id,order_id,order_line_no,practitioner_id,keybill)
{
	/*alert ("row_value		 	"+row_value						);
	alert ("called_from			"+called_from						);
	alert ("patient_id			"+patient_id						);
	alert ("encounter_id			"+encounter_id						);
	alert ("service_panel_ind	"+service_panel_ind				);
	alert ("service_panel_code	"+service_panel_code			);
	alert ("episode_type			"+episode_type						);
	alert ("episode_id			"+episode_id						);
	alert ("visit_id				"+visit_id							);
	alert ("order_id				"+order_id							);
	alert ("order_line_no		"+order_line_no					);
	alert ("practitioner_id		"+practitioner_id					);*/
								                  
	var formObj		= parent.future_order_dtl.future_order_dtl;
	//bean_id 		= formObj.bean_id2.value;
	bean_id 		= "Or_FutureOrder";//+patient_id+encounter_id;
	//bean_id 		= "";
	bean_name 		= formObj.bean_name2.value;
	//var practitioner_id	= parent.future_order_dtl.future_order_dtl.ordering_practitioner.value;
	//var practitioner_id="NAREN";
	var key_ref		= "";
	var key_line_no	= "";
	
	
	if(called_from=="NEW_ORDER")
	{
		quantity		= eval("parent.future_order_dtl.future_order_dtl.quantity"+row_value+".value");
		start_date_time	= eval("parent.future_order_dtl.future_order_dtl.start_date_time"+row_value+".value");
		catalog_code	= eval("parent.future_order_dtl.future_order_dtl.catalog_code"+row_value+".value");
		cat_desc		= eval("parent.future_order_dtl.future_order_dtl.catalog_desc"+row_value+".value");
		key_ref			= patient_id+encounter_id+catalog_code;
		key_line_no		= "";
		//key_ref			= order_id;
		//key_line_no		= order_line_no;
	}
	

	var query_string = "title="+encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"))+"&bean_id="+bean_id+"&module_id=OR&patient_id="+patient_id+"&encounter_id="+encounter_id+"&key="+keybill+"&order_catalog_code="+catalog_code+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+start_date_time+"&episode_type="+episode_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&pract_staff_ind=P&pract_staff_id="+practitioner_id+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no;
	//alert(query_string);
	var retVal ;
	var dialogTop		= "360";
	var dialogHeight	= "80vh" ;
	var dialogWidth		= "87vw" ;
	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
	var arguments		= "";
	retVal	 			= await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+query_string,arguments,features);
	
	
	if(retVal!=null && retVal != undefined)
	{
		if(retVal[0]=="Y")
		{
		

			//loadRevisedBillDtls(row_value,called_from,retVal[1],retVal[2],retVal[3],retVal[6]);
			loadRevisedBillDtls(row_value,called_from,retVal[1],retVal[2],retVal[3],retVal[8]);
			
		}
				
	}
	
		
	
} // End of callBilling
function loadRevisedBillDtls(row_value,called_from,actual_amt,pat_payable_amt,pat_paid_amt,inc_excl_actn){

	if(called_from=="NEW_ORDER")
	{
		if(eval(document.getElementById("actual_"+row_value)))
		{
			eval(document.getElementById("actual_"+row_value)).innerText	= actual_amt;
		}
		if(eval(document.getElementById("payable_"+row_value)))
		{
			eval(document.getElementById("payable_"+row_value)).innerText	= pat_payable_amt;
		}
		//eval("document.getElementById("paid_")"+row_value).innerText	= pat_paid_amt;
		if(eval(document.getElementById("included_"+row_value)))
		{
			eval(document.getElementById("included_"+row_value)).innerText	= (inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":"");
		}
		
	}
	else
	{
		if(eval(document.getElementById("amend_actual_"+row_value)))
		{
			eval(document.getElementById("amend_actual_"+row_value)).innerText		= actual_amt;
		}
		if(eval(document.getElementById("amend_payable_"+row_value)))
		{
			eval(document.getElementById("amend_payable_"+row_value)).innerText		= pat_payable_amt;
		}
		if(eval(document.getElementById("amend_included_"+row_value)))
		{
			eval(document.getElementById("amend_included_"+row_value)).innerText	= (inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":"");
		}
	}
	showBillingTable();  

}

//to calulate the total billing charges for the select orderables.
function showBillingTable(){
	
	var bill_show	 = false;
	var actual_amt	 = 0.0;
	var payable_amt	 = 0.0;

	
	
	for(var i=0;i<parent.future_order_dtl.future_order_dtl.total_recs.value;i++){
		var billing_call_yn = eval("parent.future_order_dtl.future_order_dtl.billing_call_yn"+i).value ;
		
		if(billing_call_yn =="Y"){
			//bill_show = true;
			var temp_act = eval(document.getElementById("actual_"+i)).innerText;
			var temp_pay = eval(document.getElementById("payable_"+i)).innerText;
			
			actual_amt	 += parseFloat(eval(temp_act));
			payable_amt	 += parseFloat(eval(temp_pay));
			
			
		}

	}
	
	if(bill_show){
		parent.future_order_btn.future_order_btn.document.getElementById("billing_dtl").style.visibility  = "visible" ;
		actual_amt	 += "";
		payable_amt	 += "";
		if(actual_amt.indexOf(".") == -1)
			actual_amt	 += ".0";
		if(payable_amt.indexOf(".") == -1)
			payable_amt	 += ".0";

		parent.future_order_btn.future_order_btn.document.getElementById("actual_").innerText	  = actual_amt;
		parent.future_order_btn.future_order_btn.document.getElementById("payable_").innerText	  = payable_amt;


	}else{
		parent.future_order_btn.future_order_btn.document.getElementById("billing_dtl").style.visibility  = "hidden";
		parent.future_order_btn.future_order_btn.document.getElementById("actual_").value	  = "0.0";
		parent.future_order_btn.future_order_btn.document.getElementById("payable_").value	  = "0.0";  
	}
}


// Call the Billing Related Informations . if present
/*function callBilling(row_value,called_from)
{
	var formObj		= document.placeOrderForm;
	//var localeName			= document.placeOrderForm.localeName.value;

	

	bean_id 		= formObj.bean_id.value;
	bean_name 		= formObj.bean_name.value;
	if(called_from=="NEW_ORDER")
	{
		quantity		= eval("parent.future_order_dtl.future_order_dtl.quantity"+row_value+".value");
		start_date_time	= eval("parent.future_order_dtl.future_order_dtl.start_date_time"+row_value+".value");
		catalog_code	= eval("parent.future_order_dtl.future_order_dtl.catalog_code"+row_value+".value");
		cat_desc		= eval("parent.future_order_dtl.future_order_dtl.catalog_desc"+row_value+".value");
	}
	else // For New Orders or orderset
	{
		quantity		= eval("document.placeOrderForm.amend_quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.amend_start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.amend_catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.amend_cat_desc"+row_value+".value");
	}

/*	alert('bean_id'+bean_id);
	alert('bean_name'+bean_name);
	alert('quantity'+quantity);
	alert('start_date_time'+start_date_time);
	alert('catalog_code'+catalog_code);

	if(start_date_time!="" && quantity!="" && catalog_code!="")
	{
		var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
		var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
		xmlHttp.open("POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&quantity="+quantity+"&catalog_code="+escape(catalog_code)+"&start_date_time="+start_date_time+"&cat_desc="+escape(cat_desc)+"&func_mode=GETBILLINGDETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	} 
}  End of callBilling*/
async function loadBillingDetails(day_type_code,day_type_desc,time_type_code,time_type_desc,base_qty,base_rate,addl_factor,base_charge_amt,gross_charge_amt,disc_amt,net_charge_amt,disc_perc,pat_gross_charge_amt,pat_disc_amt,pat_net_charge_amt,cust_gross_charge_amt,cust_disc_amt,cust_net_charge_amt,split_ind,curr_availed,credit_auth_ref, catalog_code, cat_desc,serv_panel_ind,serv_panel_code,service_panel_name,error_text)
{
	if(error_text!=null && error_text!="")
	{
		alert(error_text);
	}
	else
	{
		var query_string = "insind="+escape(split_ind)+"&baseqty="+base_qty+"&basechargeamt="+base_charge_amt+"&grosschargeamt="+gross_charge_amt+"&discountper="+disc_perc+"&discountamt="+disc_amt+"&daytypecode="+escape(day_type_code)+"&daytypedesc="+escape(day_type_desc)+"&timetypecode="+time_type_code+"&timetypedesc="+time_type_desc+"&addlfactor="+addl_factor+"&patgrosschargeamt="+pat_gross_charge_amt+"&patdiscamt="+pat_disc_amt+"&patnetamt="+pat_net_charge_amt+"&custgrosschargeamt="+cust_gross_charge_amt+"&custdiscamt="+cust_disc_amt+"&custnetamt="+cust_net_charge_amt+"&ordercatalogcode="+escape(catalog_code)+"&ordercatalogdesc="+escape(cat_desc)+"&netchargeamt="+net_charge_amt+"&blngrule="+escape(serv_panel_ind)+"&blngservcode="+escape(serv_panel_code)+"&blngservdesc="+escape(service_panel_name)
		var retVal;
		var dialogTop   = "260";
		var dialogHeight= "37.5" ;
		var dialogWidth = "50" ;
		var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments	= "";
		retVal 			= await window.showModalDialog("../../eBL/jsp/BLBillDetailsMain.jsp?"+query_string,arguments,features);
	} // End of Else
} // End of loadBillingDetails

function alignHeading()
{
	if(parent.frames[1].document.getElementById("tableheader")!=null)
	{
				parent.frames[1].document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				if(document.getElementById("tableresult").rows.length>1)
				{
					for (j=1; j < document.getElementById("tableresult").rows[1].cells.length; j++) 
					{
						var wid=eval(document.getElementById("tableresult").rows[1].cells[j].offsetWidth);
					
						if(parent.frames[1].document.getElementById("tableheader").rows[0].cells[j] != null)
						{
							parent.frames[1].document.getElementById("tableheader").rows[0].cells[j].width=wid;
						}
					}
				}
		}
		
}

function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.frames[1].location.href.indexOf(".jsp") != -1)
	{
		parent.frames[1].document.body.scrollLeft=temp;
	}
}

function selectedRow()
{
	var chkcount = 0;
	var total_recs = parseInt(parent.future_order_dtl.future_order_dtl.total_recs.value,10);
	if(parent.future_order_dtl)
	{
		for(cnt=0; cnt<parent.future_order_dtl.future_order_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.future_order_dtl.future_order_dtl.chk"+cnt);
			if(val.checked == true)
			{
				chkcount ++;
			}
		}
	}
	if(chkcount==total_recs)
	{
		if(parent.future_order_hdr.document.future_order_hdg.select_all)
		{
			parent.future_order_hdr.document.future_order_hdg.select_all.checked = true;
		}
	}
	else
	{
		if(parent.future_order_hdr.document.future_order_hdg.select_all)
		{
			parent.future_order_hdr.document.future_order_hdg.select_all.checked = false;
		}
	}
}

function selectedrecorddisable(rownum)
{
	eval("parent.future_order_dtl.future_order_dtl.chk"+rownum).value ="N";
	eval("parent.future_order_dtl.future_order_dtl.chk"+rownum).checked = false;
	eval("parent.future_order_dtl.future_order_dtl.chk"+rownum).disabled = true;
}

function showToolTip(catalogcode,form,obj) 
{

 	var form = document.getElementById(document.forms[0].name);

	if(form["explanatory_text"+catalogcode])
	 	explanatory_text	= form["explanatory_text"+catalogcode].value;
	

	if(explanatory_text!=null && explanatory_text!="")
    {
		buildToolTable(explanatory_text,obj);
 	}
}
function buildToolTable(val,obj) 
{
	var tab_dat  = "<table class='grid' id='tooltiptable1'  width='' height='100%' align='center'>"
	tab_dat   =  tab_dat+"<tr bgcolor='lightyellow' >" ;
	tab_dat    = tab_dat+ "<td class = 'contextMenuItem' style='padding-left:10px;padding-right:10px' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>"+val+"</td>" ;
	tab_dat     =tab_dat+ "</tr>" ;		
	tab_dat     =tab_dat+ "</table> ";	
	document.getElementById("descLink").innerHTML = tab_dat;
	document.getElementById("descLink").style.top  = obj.offsetTop-2;
	document.getElementById("descLink").style.left  = obj.offsetLeft-50;
	document.getElementById("descLink").style.visibility='visible' ;
}

function hideToolTable()	
{
  document.getElementById("descLink").style.visibility = 'hidden'
}

function displaycolor(rowcnt)
{

}
function callMouseOver(obj)	
{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';

}

function callOnMouseOut(obj){
	obj.className = 'contextMenuItem';
}

function refreshHeader()
{
	if(parent.future_order_hdr.document.future_order_hdg)
	{
		if(parent.future_order_hdr.document.future_order_hdg.select_all)
		{
			if(parent.future_order_hdr.document.future_order_hdg.select_all.checked == true)
			{
				parent.future_order_hdr.document.future_order_hdg.select_all.checked = false;
			}
		}
	}
}

function displayRecords(start, end, checkbox_name, form_name)
{
	var formObj					= eval("document."+form_name);
	if(formObj){

		formObj.from.value		= start;
		formObj.to.value		= end;
		var checked_items		= 0;
		var get_confirmation	= true;

		if(checkbox_name!="")
		{
			for(cnt=0; cnt<formObj.total_recs.value; cnt++)
			{
				if( eval("formObj"+"."+checkbox_name+cnt))
				{
					val = eval("formObj"+"."+checkbox_name+cnt);
					if(val.checked == true)
					{
						checked_items++;
					}
				}
			}
				//if(parseInt(checked_items) > 0)
				//{
					//get_confirmation = confirm(getMessage("VIEW_CONFIRM","OR"))
			doSync(formObj);
			refreshHeader();
			formObj.submit();
 				//}  
		} // End of if checkbox_name

			//if(get_confirmation)
			//{
				//refreshHeader();
				//formObj.submit();
			//}
	 } // End of formObj		
		//refreshHeader();
 } // End of displayRecords


function doSync(frmObj)
{
	if(frmObj == null)
		return ;
	 var xmlDoc="";
	 var xmlHttp = new XMLHttpRequest();
	 var  xmlString = buildXml(frmObj);
	 xmlDoc.loadXML(xmlString);
	 xmlHttp.open("POST","../../eOR/jsp/FutureOrderSync.jsp",false);
	 xmlHttp.send(xmlDoc);
	 return xmlHttp.responseText  ;
}

function buildXml(frmObj)
{
    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
    var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) 
	{
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) 
		{
			var val = "" ;
			if(arrObj[i].type == "checkbox") 
			{
				if(arrObj[i].checked)
					val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else if(arrObj[i].type == "radio") 
			{
				if(arrObj[i].checked) 
				{
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			}
			else if(arrObj[i].type == "select-multiple" )
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

    xmlStr +=" /></root>";
	return xmlStr;

}

function syncStatus(flag) 
{
	return flag ;
}

