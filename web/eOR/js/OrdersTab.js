/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//Global Variables
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var isApplied ="";
var isAnyNull = "N";
var isSeqUnique = "Y";
var isCreate = "N";
var isQuery = "N";

//Toolbar buttons methods

function create() 
{
	f_query_add_mod.location.href = "../../eOR/jsp/OrdersTabClientArea.jsp?mode=1&function_id="+function_id;
	isCreate = "Y";
	isQuery = "N";
}
function query()
{
	//alert("query button pressed");
	f_query_add_mod.location.href = "../../eOR/jsp/OrdersTabQueryCriteria.jsp?function_id="+function_id;
	isQuery = "Y";
	isCreate = "N";
}
function apply()
{

	if (! checkIsValidForProceed() )
    {
		
			var message  = getMessage("NOT_VALID","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}
	
	//alert("apply pressed - valid");
	message = "";
	var func_id = f_query_add_mod.patientClassFrame.document.frmPatientClass.func_id.value;
	var patient_class_desc = f_query_add_mod.patientClassFrame.document.frmPatientClass.patient_class_desc.value;
	var patient_class = f_query_add_mod.patientClassFrame.document.frmPatientClass.patient_class.value;
	//history.go(-1);
	var practitioner_id = f_query_add_mod.practitionerFrame.document.frmLookupPractitioner.practitioner_id.value;
	//alert("practitioner_id="+practitioner_id);
	if((practitioner_id == "") || (practitioner_id == null))
	{
		
		message = getMessage("PRACT_NOT_BLANK","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	}
	else
	{
	f_query_add_mod.placeOrderFrame.document.frmOrder.func_id.value = func_id;
	f_query_add_mod.placeOrderFrame.document.frmOrder.patient_class_desc.value = patient_class_desc;
	f_query_add_mod.placeOrderFrame.document.frmOrder.patient_class.value = patient_class;
	f_query_add_mod.placeOrderFrame.document.frmOrder.practitioner_id.value = practitioner_id;
	//f_query_add_mod.placeOrderFrame.document.frmOrder.team_id.value = team_id;
	//alert("mode="+f_query_add_mod.practitionerFrame.document.frmLookupPractitioner.mode.value);
	var install_yn = f_query_add_mod.placeOrderFrame.document.frmOrder.install_yn.value;
	var exist_order = f_query_add_mod.placeOrderFrame.document.frmOrder.exist_order.value;
	var new_order = f_query_add_mod.placeOrderFrame.document.frmOrder.new_order.value;
	var Frequent_Orders = f_query_add_mod.placeOrderFrame.document.frmOrder.Frequent_Orders.value;
	var addl_search = f_query_add_mod.placeOrderFrame.document.frmOrder.addl_search.value;
	var tick_sheet = f_query_add_mod.placeOrderFrame.document.frmOrder.tick_sheets.value;
	var order_sets = f_query_add_mod.placeOrderFrame.document.frmOrder.order_sets.value;
	var image = f_query_add_mod.placeOrderFrame.document.frmOrder.image.value;
	var place_order = f_query_add_mod.placeOrderFrame.document.frmOrder.place_order.value;

	var tabNameExistOrder = f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForExistOrder.value;
	var seqNoExistOrder = f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForExistOrder.value;
	var tabNameNewOrder = f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForNewOrder.value;
	var seqNoNewOrder = f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForNewOrder.value;
// uncomment for frequent orders
	var  seqNoFrequentOrders="";
/*	var tabNameFrequentOrders = f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForFrequentOrders.value;
	 seqNoFrequentOrders = f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForFrequentOrders.value;
*/
	var tabNameSearch = f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForSearch.value;
	var seqNoSearch = f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForSearch.value;
	var tabNameTickSheet = f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForTickSheet.value;
	var seqNoTickSheet = f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForTickSheet.value;
	var tabNameOrderSet = f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForOrderSets.value;
	var seqNoOrderSet = f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForOrderSets.value;
	var tabNameImage = f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForImage.value;
	var seqNoImage = f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForImage.value;
	var tabNamePlaceOrder = f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForPlaceOrder.value;
	var seqNoPlaceOrder = f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForPlaceOrder.value;
	//install_yn="N"
	if(install_yn == "N")
	{
		if (exist_order=="N" && new_order == "N"  )
		{
				var message  = getMessage("ATLEAST_ONE_TAB_SELECTED","OR");
			//	var message  = "Any of the existing or new orders should be selected";
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return false ;
		}
	}else{
		if(new_order == "N"){
		//	var message  = getOrMessage("ATLEAST_ONE_TAB_SELECTED");
			var message  = getMessage("NEW_ORDERS_SHOULD_BE_SELECTED","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;}
	}
	//alert("Install Y/N " + install_yn);
	//install_yn="N";
	/*if(install_yn == "Y")
	{	
		//if( exist_order=="Y" || new_order == "Y" || addl_search == "Y" || tick_sheet == "Y" || order_sets == "Y" || image == "Y")
		//{	alert()
			var mode = f_query_add_mod.placeOrderFrame.document.frmOrder.mode.value;
			eval( formApply( f_query_add_mod.placeOrderFrame.document.frmOrder,OR_CONTROLLER ) );
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if(message == "" || message == null)
			{
				if(mode == "1")
				{
					message = getMessage("RECORD_INSERTED");
				}
				else
				{
					message = getMessage("RECORD_MODIFIED");
				}
			}
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) 
			{
				onSuccess();
			}
		}

		else
		{
			message = getOrMessage("CLICK_ANY_ONE_USER_DEFINED_TABS");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		}*/
	//}
//	else
//	{
	if(exist_order == "Y")
	{
		if(tabNameExistOrder == "" || tabNameExistOrder == null || tabNameExistOrder == " ")
			{	
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForExistOrder.focus();
				isAnyNull = "Y";
			}
				msg = getMessage("EXISTING_ORDERS_TABNAME_NOT_BLANK","OR") + "<br>";
				message = message.concat(msg);
			}
		if(seqNoExistOrder == "" || seqNoExistOrder == null)
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForExistOrder.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("EXISTING_ORDER_SEQNO_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
		
	}
	if(new_order == "Y")
	{
		if(tabNameNewOrder == "" || tabNameNewOrder == null || tabNameNewOrder == " ")
			{	
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForNewOrder.focus();
				isAnyNull = "Y";
			}
				msg = getMessage("NEW_ORDERS_TABNAME_NOT_BLANK","OR") + "<br>";
				message = message.concat(msg);
			}
		if(seqNoNewOrder == "" || seqNoNewOrder == null)
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForNewOrder.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("NEW_ORDER_SEQNO_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
		
	}
	if(Frequent_Orders == "Y")
	{
		if(tabNameFrequentOrders == "" || tabNameFrequentOrders == null || tabNameFrequentOrders == " ")
			{	
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForFrequentOrders.focus();
				isAnyNull = "Y";
			}
				msg = getMessage("FREQUENT_ORDERS_TABNAME_NOT_BLANK","OR") + "<br>";
				message = message.concat(msg);
			}
		if(seqNoFrequentOrders == "" || seqNoFrequentOrders == null)
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForFrequentOrders.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("FREQUENT_ORDERS_SEQNO_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
		
	}
	if(addl_search == "Y")
	{
		if(tabNameSearch == "" || tabNameSearch == null || tabNameSearch == " ")
			{	
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForSearch.focus();
				isAnyNull = "Y";
			}
				msg = getMessage("ADDITIONAL_SEARCH_TABNAME_NOT_BLANK","OR") + "<br>";
				message = message.concat(msg);
			}
		if(seqNoSearch == "" || seqNoSearch == null)
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForSearch.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("ADDITIONAL_SEARCH_SEQNO_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
		
	}
	if(tick_sheet == "Y")
	{
		if(tabNameTickSheet == "" || tabNameTickSheet == null || tabNameTickSheet == " ")
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForTickSheet.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("TICK_SHEETS_TABNAME_NOT_BLANK","OR")  + "<br>";
			message = message.concat(msg);
		}
		if(seqNoTickSheet == "" || seqNoTickSheet == null)
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForTickSheet.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("TICK_SHEETS_SEQNO_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
	}
	if(order_sets == "Y")
	{
		if(tabNameOrderSet == "" || tabNameOrderSet == null || tabNameOrderSet == " ")
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForOrderSets.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("ORDER_SETS_TABNAME_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
		if(seqNoOrderSet == "" || seqNoOrderSet == null)
		{	
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForOrderSets.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("ORDER_SETS_SEQNO_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
	}
	if(image == "Y")
	{
		if(tabNameImage == "" || tabNameImage == null || tabNameImage == " ")
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForImage.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("IMAGE_TABNAME_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
		if(seqNoImage == "" || seqNoImage == null)
		{	
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForImage.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("IMAGE_SEQNO_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
	}
	
	if(place_order  == "Y")
	{
		if(tabNamePlaceOrder == "" || tabNamePlaceOrder == null || tabNamePlaceOrder == " ")
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.tabNameForPlaceOrder.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("PLACE_ORDER_TABNAME_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
		if(seqNoPlaceOrder == "Y")
		{
			if(isAnyNull == "N")
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.seqNumForPlaceOrder.focus();
				isAnyNull = "Y";
			}
			msg = getMessage("PLACE_ORDER_SEQNO_NOT_BLANK","OR") + "<br>";
			message = message.concat(msg);
		}
	}
	if(isAnyNull == "Y")
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message;	
	}
	else
	{
		if(seqNoExistOrder != " " && seqNoExistOrder != null && seqNoExistOrder != "" && exist_order == "Y")
		{
			if( seqNoExistOrder == seqNoNewOrder && new_order == "Y" )
			{
				isSeqUnique = "N";
			}
		}
		if(seqNoNewOrder != " " && seqNoNewOrder != null && seqNoNewOrder != "" && exist_order == "Y")
		{
			if(seqNoNewOrder == seqNoExistOrder && exist_order == "Y")
			{
				isSeqUnique = "N";
			}
		}
		if(seqNoFrequentOrders != " " && seqNoFrequentOrders != null && seqNoFrequentOrders != "" && Frequent_Orders == "Y" )
		{
			if((seqNoFrequentOrders == seqNoSearch && addl_search == "Y" ) || (seqNoFrequentOrders == seqNoTickSheet && tick_sheet == "Y" )|| (seqNoFrequentOrders == seqNoOrderSet && order_sets == "Y") || (seqNoFrequentOrders == seqNoImage && image == "Y") || (seqNoFrequentOrders == seqNoPlaceOrder && place_order == "Y") )
			{
				isSeqUnique = "N";
			}
		}
		if(seqNoSearch != " " && seqNoSearch != null && seqNoSearch != "" && addl_search == "Y" )
		{
			if((seqNoSearch == seqNoFrequentOrders && Frequent_Orders == "Y" ) || (seqNoSearch == seqNoTickSheet && tick_sheet == "Y" )|| (seqNoSearch == seqNoOrderSet && order_sets == "Y") || (seqNoSearch == seqNoImage && image == "Y") || (seqNoSearch == seqNoPlaceOrder && place_order == "Y") )
			{
				isSeqUnique = "N";
			}
		}
		if(seqNoTickSheet != " " && seqNoTickSheet != null  && seqNoTickSheet != "" && tick_sheet == "Y")
		{
			if((seqNoTickSheet == seqNoFrequentOrders && Frequent_Orders == "Y" ) || (seqNoTickSheet == seqNoSearch && addl_search == "Y")|| (seqNoTickSheet == seqNoOrderSet && order_sets == "Y")|| (seqNoTickSheet == seqNoImage && image == "Y") || (seqNoTickSheet == seqNoPlaceOrder && place_order == "Y"))
			{
				isSeqUnique = "N";
			}
		}
		if(seqNoOrderSet != " " && seqNoOrderSet != null && seqNoOrderSet != "" && order_sets == "Y")
		{
			if((seqNoOrderSet == seqNoFrequentOrders && Frequent_Orders == "Y" ) || (seqNoOrderSet == seqNoFrequentOrders && Frequent_Orders == "Y" )||(seqNoOrderSet == seqNoSearch && addl_search == "Y") ||( seqNoOrderSet == seqNoTickSheet && tick_sheet == "Y" )|| (seqNoOrderSet == seqNoImage && image == "Y") || (seqNoOrderSet == seqNoPlaceOrder && place_order == "Y"))
			{
				isSeqUnique = "N";			
			}
		}
		if(seqNoImage != " " && seqNoImage != null && seqNoImage != "" && image == "Y")
		{
			if((seqNoImage == seqNoFrequentOrders && Frequent_Orders == "Y" ) || (seqNoImage == seqNoSearch && addl_search == "Y")|| (seqNoImage == seqNoTickSheet && tick_sheet == "Y" ) || (seqNoImage == seqNoOrderSet && order_sets == "Y")|| (seqNoImage == seqNoPlaceOrder && place_order == "Y"))
			{
				isSeqUnique = "N";
			}
		}
		if(seqNoPlaceOrder != " " && seqNoPlaceOrder != null && seqNoPlaceOrder != "" && place_order =="Y")
		{
			if((seqNoPlaceOrder == seqNoFrequentOrders && Frequent_Orders == "Y" ) || (seqNoPlaceOrder == seqNoSearch && addl_search == "Y")|| (seqNoPlaceOrder == seqNoTickSheet && tick_sheet == "Y" )|| (seqNoPlaceOrder == seqNoOrderSet && order_sets == "Y")|| (seqNoPlaceOrder == seqNoImage && image == "Y"))
			{
				isSeqUnique = "N";
			}
		}
			
		if(isSeqUnique == "N")
		{
			message = getMessage("DUP_SEQ_NUM","OR");
			//alert("Sequence Number Cannot Be Repeated");
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message;	
			isSeqUnique = "Y";
		}
		else
		{
			var mode = f_query_add_mod.placeOrderFrame.document.frmOrder.mode.value;
			eval( formApply( f_query_add_mod.placeOrderFrame.document.frmOrder,OR_CONTROLLER) );
			//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		//	if(message == "" || message == null)
		//	{
				if(mode == "1")
				{
					message = getMessage("RECORD_INSERTED","SM");
				}
				else
				{
					message = getMessage("RECORD_MODIFIED","SM");
				}
			//}
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) 
			{
				onSuccess();
			}
		}
	}
	//}
   }// end of else condition practitioner id check
    isAnyNull = "N";
	isApplied = "Y";
 
}
function reset()
{
	// reset the form objects/controls to their default values
	if(isCreate == "Y")
	{	
		if( isApplied == "Y")
		{
			f_query_add_mod.patientClassFrame.location.href = "../../eOR/jsp/OrdersTabPatientClass.jsp?patient_class= &mode=1&function_id="+function_id;
			f_query_add_mod.practitionerFrame.location.href = "../../eOR/jsp/OrdersTabPractitioner.jsp?patient_class= &practitioner_id= ";
			//f_query_add_mod.placeOrderFrame.location.href = "../../eOR/jsp/OrdersTabPlaceOrder.jsp";
			f_query_add_mod.placeOrderFrame.location.href = "../../eOR/jsp/OrdersTabPlaceOrderModify.jsp?patient_class=*A&mode=1&func_id="+function_id+"&practitioner_id=*A";
			isApplied = "N";
		}
		else
		{
			f_query_add_mod.location.href = "../../eOR/jsp/OrdersTabClientArea.jsp?mode=1&function_id="+function_id;
		}
	}
	else if(isQuery == "Y")
	{
		if(checkIsValidForReset())
		{	
			var wholeString = f_query_add_mod.frmAddModify.wholeString.value;
			var wholeStringArray = wholeString.split("$");
			var mode = wholeStringArray[0];
			var patient_class = wholeStringArray[1];
			var practitioner_id = wholeStringArray[2];
			var patient_class_desc = wholeStringArray[3];
			var practitioner_name = wholeStringArray[4];
			var func_id = wholeStringArray[5];
			var func_name = wholeStringArray[6];
			f_query_add_mod.location.href = "../../eOR/jsp/OrdersTabAddModify.jsp?patient_class="+patient_class+"&"+"practitioner_id="+practitioner_id+"&"+"mode="+mode+"&"+"patient_class_desc="+patient_class_desc+"&practitioner_name="+practitioner_name+"&func_id="+func_id+"&func_name="+func_name;
			
		/*	f_query_add_mod.document.forms[0].reset();
			f_query_add_mod.placeOrderFrame.frmOrder.reset();*/
		}
		else
		{
			f_query_add_mod.document.forms[0].reset();
		//	f_query_add_mod.location.href = "../../eOR/jsp/OrdersTabQueryCriteria.jsp?function_id="+function_id;	
		}
	}
	else
	{	
	}
}
function update()
{
	////////////
}
function deleterecord()
{
	if (! checkIsValidForProceed() )
    {
			var message  = getMessage("NOT_VALID_DELETE","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}
		//alert("delete pressed - valid");
		message="";
		var func_id;
		var patient_class;
		var practitioner_id;
		//alert("Deleted");
		var mode = f_query_add_mod.placeOrderFrame.document.frmOrder.mode.value;
	 if(mode == "1") ////mode equal to "1" (insert mode)
	  {
		  message = getMessage("CANNOT_DELETE","SM");
          messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	  }
	  else //mode not equal to "1" (modify mode)
		{
			func_id = f_query_add_mod.patientClassFrame.document.frmPatientClass.func_id.value;
			patient_class = f_query_add_mod.patientClassFrame.document.frmPatientClass.patient_class.value;
			practitioner_id = f_query_add_mod.practitionerFrame.document.frmLookupPractitioner.practitioner_id.value;
			if((practitioner_id == "") || (practitioner_id == " ") || (practitioner_id == null))
			{
				message = getMessage("PRACT_NOT_BLANK","OR");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			}
			else
			{
				f_query_add_mod.placeOrderFrame.document.frmOrder.func_id.value = func_id;
				f_query_add_mod.placeOrderFrame.document.frmOrder.patient_class.value = patient_class;
				f_query_add_mod.placeOrderFrame.document.frmOrder.practitioner_id.value = practitioner_id;
				f_query_add_mod.placeOrderFrame.document.frmOrder.mode.value = MODE_DELETE;
				
				var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
				if(confirm_val){
					eval( formApply( f_query_add_mod.placeOrderFrame.document.frmOrder,OR_CONTROLLER ) );
					//alert("result for delete   " + result);
					if(message == "" || message == null)
					{
						message = getMessage("RECORD_DELETED","SM");
					}
				
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

					if( result ) 
					{
							onSuccess();
					}
					f_query_add_mod.patientClassFrame.location.href = "../../eOR/jsp/OrdersTabPatientClass.jsp?patient_class= &mode=1&function_id="+function_id;
					f_query_add_mod.practitionerFrame.location.href = "../../eOR/jsp/OrdersTabPractitioner.jsp?patient_class= &practitioner_id= ";
					f_query_add_mod.placeOrderFrame.location.href = "../../eOR/jsp/OrdersTabPlaceOrder.jsp";
				}else
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}	
	    }
	
}
function onSuccess() 
{
	//f_query_add_mod.location.href = "../../eOR/jsp/MessageFrame.jsp";
	//alert("in onsuccess");
	
	var mode = f_query_add_mod.placeOrderFrame.document.frmOrder.mode.value;
	
	if(mode == "1"){
		//alert("onsuccess in insert mode")
		f_query_add_mod.location.href = "../../eOR/jsp/OrdersTabClientArea.jsp?mode=1&function_id="+function_id;
	}else{
		//alert("onsuccess modify mode,isQuery="+isQuery);
		if(isQuery == "N")
		{
			
			var mode = f_query_add_mod.placeOrderFrame.document.frmOrder.mode.value;
			//alert("if isQuery==N,mode= "+f_query_add_mod.placeOrderFrame.document.frmOrder.mode.value);
			var patient_class = f_query_add_mod.placeOrderFrame.document.frmOrder.patient_class.value;
			var patient_class_desc = f_query_add_mod.placeOrderFrame.document.frmOrder.patient_class_desc.value;
			if(patient_class == "*A")
				patient_class_desc = getLabel("Common.all.label","Common");
			var practitioner_name = f_query_add_mod.practitionerFrame.document.frmLookupPractitioner.selectedPractitioner.value;
			var practitioner_id = f_query_add_mod.placeOrderFrame.document.frmOrder.practitioner_id.value;
			if(practitioner_id == "*A")
				practitioner_name = getLabel("Common.all.label","Common");
			var func_id = f_query_add_mod.placeOrderFrame.document.frmOrder.func_id.value; 
			f_query_add_mod.location.href = "../../eOR/jsp/OrdersTabAddModify.jsp?patient_class="+patient_class+"&"+"practitioner_id="+practitioner_id+"&"+"mode="+mode+"&patient_class_desc="+patient_class_desc+"&practitioner_name="+practitioner_name+"&func_id="+func_id;
		
		}else{
			var wholeString = f_query_add_mod.frmAddModify.wholeString.value;
			var wholeStringArray = wholeString.split("$");
			var mode = wholeStringArray[0];
			var patient_class = wholeStringArray[1];
			var practitioner_id = wholeStringArray[2];
			var patient_class_desc = wholeStringArray[3];
			var practitioner_name = wholeStringArray[4];
			var func_id = wholeStringArray[5];
			var func_name = wholeStringArray[6];
			f_query_add_mod.location.href = "../../eOR/jsp/OrdersTabAddModify.jsp?patient_class="+patient_class+"&"+"practitioner_id="+practitioner_id+"&"+"mode="+mode+"&"+"patient_class_desc="+patient_class_desc+"&practitioner_name="+practitioner_name+"&func_id="+func_id+"&func_name="+func_name;
		}
	}
}
function assignResult(_result, _message, _flag)
{
//	alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function ClearAll(frmOrder)
{
//	frmOrder.existOrderCheck.checked = false;
//	frmOrder.newOrderCheck.checked = false;
	frmOrder.FrequentOrdersCheck.checked = false;
	frmOrder.addnlSearchCheck.checked = false;
	frmOrder.tickSheetCheck.checked = false;
	frmOrder.orderSetsCheck.checked = false;
	frmOrder.imageCheck.checked = false;
}
function validatePractitioner()
{
	document.frmPatientClass.practitioner.checked = true;
	document.frmPatientClass.team.checked = false;
	//loadPage("Practitioner");
	//document.submit();
	//window.alert("Practitioner");
	parent.frames[2].location.href="../../eOR/jsp/OrdersTabPractitioner.jsp";
}
function validateTeam()
{
	document.frmPatientClass.practitioner.checked = false;
	document.frmPatientClass.team.checked = true;
	//loadPage("Team");
	//document.submit();
	//window.alert("Team");
	parent.frames[2].location.href="../../eOR/jsp/OrdersTabTeam.jsp";
}
function loadPage(pageName)
{
	//alert(pageName);
	//var frms = document.frames;
	//frms(2).location = pageName+".html";
	//alert(frms.length);
}
function CheckAll(frmOrder)
{
	frmOrder.FrequentOrdersCheck.checked = true;
	frmOrder.addnlSearchCheck.checked = true;
	frmOrder.tickSheetCheck.checked = true;
	frmOrder.orderSetsCheck.checked = true;
	frmOrder.imageCheck.checked = true;
}
function validateExistOrder(frmOrder)
{
	if(frmOrder.existOrderCheck.checked == false)
	{
		frmOrder.tabNameForExistOrder.value = getLabel("eOR.ExistingOrders.label","OR");
		frmOrder.seqNumForExistOrder.value = "";
		frmOrder.existOrderCheck.checked = false;
		frmOrder.exist_order.value = "N";
	}
	else
	{
		frmOrder.existOrderCheck.checked = true;	
		frmOrder.exist_order.value = "Y";
	}// end of else
}
function validateNewOrder(frmOrder)
{
	if(frmOrder.newOrderCheck.checked == false)
	{
		frmOrder.tabNameForNewOrder.value = getLabel("eOR.NewOrders.label","OR");
		frmOrder.seqNumForNewOrder.value = "";
		frmOrder.newOrderCheck.checked = false;
		frmOrder.new_order.value = "N";
	}
	else
	{
		frmOrder.newOrderCheck.checked = true;	
		frmOrder.new_order.value = "Y";
	}// end of else
}
function validateFrequentOrders(frmOrder)
{
	if(frmOrder.FrequentOrdersCheck.checked == false)
	{
		frmOrder.tabNameForFrequentOrders.value = getLabel("eOR.FrequentOrders.label","OR");
		frmOrder.seqNumForFrequentOrders.value = "";
		frmOrder.FrequentOrdersCheck.checked = false;
		frmOrder.Frequent_Orders.value = "N";
	}
	else
	{
		frmOrder.FrequentOrdersCheck.checked = true;	
		frmOrder.Frequent_Orders.value = "Y";
	}// end of else
}

function validateAddnlSearch(frmOrder)
{
	if(frmOrder.addnlSearchCheck.checked == false)
	{
		frmOrder.tabNameForSearch.value = getLabel("eOR.AdditionalSearch.label","OR");
		frmOrder.seqNumForSearch.value = "";
		frmOrder.addnlSearchCheck.checked = false;
		frmOrder.addl_search.value = "N";
	}
	else
	{
		frmOrder.addnlSearchCheck.checked = true;	
		frmOrder.addl_search.value = "Y";
	}// end of else
}
function validateTickSheet(frmOrder)
{
	if(frmOrder.tickSheetCheck.checked == false)
	{
		frmOrder.tabNameForTickSheet.value = getLabel("eOR.TickSheets.label","OR");
		frmOrder.seqNumForTickSheet.value = "";
		frmOrder.tickSheetCheck.checked = false;
		frmOrder.tick_sheets.value = "N";
	}
	else
	{
		frmOrder.tickSheetCheck.checked = true;	
		frmOrder.tick_sheets.value = "Y";
	}// end of else
}
function validateOrderSets(frmOrder)
{
	if(frmOrder.orderSetsCheck.checked == false)
	{
		frmOrder.tabNameForOrderSets.value = getLabel("eOR.OrderSets.label","OR");
		frmOrder.seqNumForOrderSets.value = "";
		frmOrder.orderSetsCheck.checked = false;
		frmOrder.order_sets.value = "N";
	}
	else
	{
		frmOrder.orderSetsCheck.checked = true;	
		frmOrder.order_sets.value = "Y";
	}// end of else
}
function validateImage(frmOrder)
{
	if(frmOrder.imageCheck.checked == false)
	{
		frmOrder.tabNameForImage.value = getLabel("eOR.Image.label","OR");
		frmOrder.seqNumForImage.value = "";
		frmOrder.imageCheck.checked = false;
		frmOrder.image.value = "N";
	}
	else
	{
					frmOrder.imageCheck.checked = true;	
					frmOrder.image.value = "Y";
				
	}// end of else
}

function clearApplicable( checkedApplicable )
{
	checkedApplicable.checked = false;
}
function validateTextBox( txtRef )
{
	if(txtRef.value == "*")
	{
		//alert("Special Characters Should Not Be Entered");
		txtRef.value="";
		txtRef.focus();
	}
}

async function searchCodeForTeam( target ) 
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	dataNameArray[0] = "facility_id" ;

	dataValueArray[0] = "C1";

	dataTypeArray[0] = STRING ;

	argumentArray[0] = document.frmLookupTeam.SQL_OR_USER_FOR_REVIEW_TEAM_LOOKUP.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK ;
	argumentArray[7] = CODE_DESC ;

	
	retVal = await CommonLookup( getLabel("eOR.FindTeam.label","OR"), argumentArray );

	if(retVal != null && retVal != "" )  
	{
 		target.value = retValArr[0] ; /* if code(team_id) need to be returned */
 		//target.value = retValArr[1] ; /* if desc(team_desc) need to be returned */
	}
}
function before_searchCodeForPractitioner(target){
		//alert("target.value="+target.value);
	if(target.value!=""){
		if(target.value !=  document.frmLookupPractitioner.temp_selectedPractitioner.value) 	
			searchCodeForPractitioner(target);
	}else{
			//alert("blank");
			target.value="";		
			document.frmLookupPractitioner.practitioner_id.value=""
			document.frmLookupPractitioner.temp_selectedPractitioner.value="";
		}

}

function searchCodeForPractitioner( target ) 
{
	/*************/
	var practName_FName	= "";
	var practName_FValue= "";
	var practId_FName	= "";

	practName_FName		= target.name;		// object name
	practName_FValue	= encodeURIComponent(target.value);
	practId_FName		= document.frmLookupPractitioner.practitioner_id.value;
	if(practName_FValue == "All")
		practName_FValue = "";
//alert(practName_FValue);
	var sql				= frmLookupPractitioner.SQL_OR_PRACTITIONER_LOOKUP.value;
	var sql2			= frmLookupPractitioner.SQL_OR_PRACTITIONER_LOOKUP2.value;
	var splty			= "";
	var facility_id		= "";

	sql = sql.replace("!~locale~!","en");
	sql2 = sql2.replace("!~locale~!","en");

	for(var x=0;x<3;x++)
	{
	sql=sql.replace('?',"'"+localeName+"'");
	sql2=sql2.replace('?',"'"+localeName+"'");
	}
	//facility_id		= facilityID;
	// here not needed job_title , gender, practitioner_type, specialty-code
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + splty+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
 

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText	= xmlHttp.responseText;
	responseText	= trimString(responseText);
//	alert("864"+responseText);
	//alert("responseText value: "+responseText);
	eval(practSearch(practName_FName,practName_FValue,splty,responseText));

	/************/
/*	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=parent.frames[2].document.frmLookupPractitioner;
	var patient_class_desc;
	var patient_class;
	var mode;
	var facility_id;
	var practitioner_id;

	argumentArray[0] = frmObj.SQL_OR_PRACTITIONER_LOOKUP.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = CommonLookup("Find Practitioner", argumentArray );
		
	if(retVal != null && retVal != "" )  
	{
		frmObj.practitioner_id.value = retVal[0] ;
			 // if code(practitioner_id) need to be returned 
 		frmObj.selectedPractitioner.value = retVal[1] ; // if desc(practitioner_name) need to be returned 
		
		var frameObj = parent.frames[1].document.frmPatientClass;

	patient_class_desc = frameObj.patient_class_desc.value;
	patient_class = frameObj.patient_class.value;
	func_id = frameObj.func_id.value;
	//alert("patient_class " + patient_class);
	mode = frameObj.mode.value;
	practitioner_id = parent.frames[2].document.frmLookupPractitioner.practitioner_id.value;
	parent.frames[3].location.href="../../eOR/jsp/OrdersTabPlaceOrderModify.jsp?patient_class="+patient_class+"&"+"practitioner_id="+practitioner_id+"&"+"mode="+mode+"&func_id="+func_id;
	message = "";
	parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	}
	else
	{
		frmObj.selectedPractitioner.value = "";
		//frmObj.selectedPractitioner.focus();
		message = getOrMessage("PRACT_NOT_BLANK");
		parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	}*/
	
}
async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	//alert("parct");
	var retVal = 	new String();
	var dialogTop = "60" ;
	var dialogHeight= "97vh" ;
	var dialogWidth	= "69vw" ;
	/*Below line added for this CRF ML-MMOH-CRF-0862*/
	if("<%=cernerIdSiteSpecific%>" =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	var objName="<%=practName_FName%>";
    arguments='';

	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);


	//alert("retVal "+retVal);

	PractLookupRetVal(retVal,objName);
}
function PractLookupRetVal(retVal,target)
{
 	if(retVal != null && retVal != "")
		{
			arr=retVal.split("~");
			document.frmLookupPractitioner.practitioner_id.value=arr[0];
			document.frmLookupPractitioner.selectedPractitioner.value = arr[1];
			var frameObj = parent.frames[1].document.frmPatientClass;
			patient_class_desc = frameObj.patient_class_desc.value;
			patient_class = frameObj.patient_class.value;
			func_id = frameObj.func_id.value;
			//alert("patient_class " + patient_class);
			mode = frameObj.mode.value;
			practitioner_id = parent.frames[2].document.frmLookupPractitioner.practitioner_id.value;
			parent.frames[3].location.href="../../eOR/jsp/OrdersTabPlaceOrderModify.jsp?patient_class="+patient_class+"&"+"practitioner_id="+practitioner_id+"&"+"mode="+mode+"&func_id="+func_id;
			message = "";
			parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
 		}
		else
		{
			document.frmLookupPractitioner.selectedPractitioner.value="";
			//document.frmLookupPractitioner.selectedPractitioner.focus();
			message = getMessage("PRACT_NOT_BLANK","OR");
			parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		}
 }

function allowPositiveNumber() { 
   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}
function checkPositiveNumber(obj) {  
   var obj_value = obj.value;    // checks for positive number greater than zero
   var obj_length = obj_value.length;
	if(obj.value == ""){
		return true;
	}
	if(obj != null ){
		if(obj_value > 0){
			return true;
		}else{
			//alert(getOrMessage("ONLY_POSITIVE_NUM"));
			message	= getMessage("ONLY_POSITIVE_NUM","OR") ;
			parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			obj.value= ""
			obj.focus();
			return false;
		}
	}else{
		return true;
	}
}
function PatientClassDesc()
{
	var selectObj = document.getElementsByTagName("SELECT").item(1);
	var selIndex = document.frmPatientClass.patient_short_desc.selectedIndex;
	var selOptionValue = selectObj.options(document.frmPatientClass.patient_short_desc.selectedIndex).text;
	parent.frames[1].document.frmPatientClass.patient_class_desc.value = selOptionValue;
	var temp = document.frmPatientClass.temp.value;
	//alert("temp "+ temp);
	var temp1 = temp.split(",");
	parent.frames[1].document.frmPatientClass.patient_class.value = temp1[selIndex - 1]; 
	//to get the patient class corresponding to the patient_class_desc
	var patient_class = parent.frames[1].document.frmPatientClass.patient_class.value;
	//alert(patient_class);
	var mode = parent.frames[1].document.frmPatientClass.mode.value; 
	//var facility_id = parent.frames[1].document.frmPatientClass.facility_id.value;
	var function_id = parent.frames[1].document.frmPatientClass.function_id.value;
	var patient_class_desc = parent.frames[2].document.frmLookupPractitioner.patient_class_desc.value;
	parent.frames[2].location.href="../../eOR/jsp/OrdersTabPractitioner.jsp?patient_class="+patient_class+"&"+"mode="+mode+"&"+"practitioner_id=";
	var practitioner_id = parent.frames[2].document.frmLookupPractitioner.practitioner_id.value;
	//parent.frames[3].location.href="../../eOR/jsp/OrdersTabPlaceOrder.jsp";
	message = "";
	parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	//}
}
function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	  return true;
	 else
	  return false;
}

function checkIsValidForReset()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( url.indexOf("addmodify.jsp") != -1 )
		{
			return true;
		}
	 else
		{
 		 	return false;
		}
}

function clearField(target)
{
	target.value = "";
}
