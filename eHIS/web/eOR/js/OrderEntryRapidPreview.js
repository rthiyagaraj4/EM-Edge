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
Date			Edit History	Name			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?			created
08/11/2011		IN28273		 	Dinesh T	 		?				?			Added the change event to that control
25/09/2012	 	IN030279		Ramesh G			?				?			Bru-HIMS-CRF-160
21/09/2012	  	IN036383		Ramesh G			?				?			MO->When we Release Order from preview screen we get script error. When we Click on Preview button in New Orders we get script error.
31/05/2013		IN039584		Ramesh G										External Orders-System does not redirect to place order screen when preview window is closed. Please see the attached ppt.
21/01/2014		IN046263		Karthi L		22/01/2014			Dinesh		Preview order screen displayed directly while placing the external Order
11/02/2019		IN069657		Dinesh  T		11/02/2019			Ramesh G	IN069657	
14/06/2021		17139			Ramesh Get		14/06/2021			Ramesh G	ML-MMOH-SCF-1789 
---------------------------------------------------------------------------------------------------------
*/
// Used for the Preview, from any of the tabs and the user can change the values and record them
async function  rapidPreview(function_from, order_category){
//	alert("radpid");
var called_from;
var winRevert=""; //IN039584
 	var formObj;
	if(parent.tabFrame){		
		formObj			= parent.tabFrame.formTab;
  		// call the bean method if checked or unchecked
		if(function_from=="EXTERNAL_ORDER" || function_from=="CP" || function_from=="MO" || function_from=="REPLACE_ADD")
			
		storeCheckedValues("formTab","YES"); // Store the checked catalogs into bean
		called_from=formObj.called_from.value;
		
	}
	else if(parent.parent.criteriaMainFrame) 
	{		// For Recently Accessed List
	
 		if(parent.parent.criteriaMainFrame.criteriaMainSearchFrame){			
	 			formObj			= parent.parent.criteriaMainFrame.criteriaMainSearchFrame.recentlyAccessedForm;
  				// call the bean method if checked or unchecked
 				storeCheckedValues("recentlyAccessedForm","YES"); // Store the checked catalogs into bean
 		}
	}	
	else if(parent.criteriaMainFrame.addlSearchCriteriaForm)
	{
			formObj		= parent.criteriaMainFrame.addlSearchCriteriaForm;
 			// call the bean method if checked or unchecked
 			storeCheckedValues("orderSetResultForm","YES"); // Store the checked catalogs into bean
			
			order_category = document.addlSearchCriteriaForm.order_category.value;
	}
	else if(parent.criteriaMainFrame.tickSheetForm) 
	{
			formObj	= parent.criteriaMainFrame.tickSheetForm;
			// call the bean method if checked or unchecked
 			storeCheckedValues("tickSheetItemsForm","YES"); // Store the checked catalogs into bean
			order_category = document.tickSheetForm.order_category.value;
	}	
	var query_string = buildQueryString(); // call the function to build the query string
	//17139 Start.
	//if(order_category=="PH") || order_category=="CN" || called_from=="OH"){
	if(order_category!="PH"){
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//xmlHttp.open( "POST", "ORSecurePINValidate.jsp?order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=SecurePIN", false ) ;
			xmlHttp.open( "POST", "OrderEntryRapidPreviewValidation.jsp?bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
			xmlHttp.send( xmlDoc ) ;
			var order_category_temp=trimString(xmlHttp.responseText);
			if(order_category_temp=="PH")
				order_category="PH";
	}
	if(order_category=="PH"){
		alert("Pharmacy orders shall not be allowed to place from preview orders.");
	}else if(order_category=="CN" || called_from=="OH"){
	// 17139 End.
			var tab_name	 = "PlaceOrder";
			if(parent.DetailFrame)
	 			parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryFrameSet.jsp?tab_name="+tab_name+query_string;
			else if(parent.parent.DetailFrame)
	 			parent.parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryFrameSet.jsp?tab_name="+tab_name+query_string;

			if(parent.tabFrame)
				frameObj		= parent.tabFrame;
			else 
				frameObj		= parent.parent.tabFrame;
			frameObj.document.formTab.flag.value = tab_name; // SEt the tab
	}else
	{
		//IN031198 Starts
		/*var	dialogHeight 		= "45" ;
		var	dialogWidth 		= "60" ;
		var	dialogTop 			= "100" ;
		var	dialogLeft	 		= "124" ;
		var arguments			= "";
		var retVal 				= "";
		var features 			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=no; status=no";
		
		// new parameter added, order_category by Murthy - 15-05-2007
		var retVal 				= window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreview.jsp?tab_name="+tab_name+"&order_category="+order_category+query_string ,arguments,features);*/
			//IN029143 starts
		if(function_from != "AMEND_ORDER")
		{
				var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
				xmlStr			= "<root><SEARCH " ;
				xmlStr 			+=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				//xmlHttp.open( "POST", "ORSecurePINValidate.jsp?order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=SecurePIN", false ) ;
				xmlHttp.open( "POST", "ORPlaceOrderSecurePINValidation.jsp?order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=SecurePIN", false ) ;
				xmlHttp.send( xmlDoc ) ;
				if(trimString(xmlHttp.responseText)=="AL")
				{
					var retVal=new Array();
					var dialogHeight= "10" ;
					var dialogWidth	= "22" ;
					var dialogTop = "225" ;
					var center = "1" ;														   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	
					var called_frm="NewOrders";
					//[IN030566] Start
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
						xmlStr			= "<root><SEARCH " ;
						xmlStr 			+=" /></root>" ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Get&keyObj="+patient_id+"_AL_"+order_category+"&patient_id="+patient_id, false ) ;
						xmlHttp.send( xmlDoc ) ;
						if(trimString(xmlHttp.responseText)!="false")
						{
							retVal="true";
						}else{
							retVal = await window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&keyObj="+patient_id+"_AL_"+order_category+"&patient_id="+patient_id+"",arguments,features);
						}
						//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"",arguments,features);
					
					//[IN030566] Ends
					
					if(retVal == "true")
					{
						var	dialogHeight 		= "89vh" ;
						//var	dialogWidth 		= "60" ;
						var	dialogWidth 		= "91vw" ;
						var	dialogTop 			= "100" ;
						var	dialogLeft	 		= "124" ;
						var arguments			= "";
						var retVal 				= "";
						var features 			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=no; status=no";
						var retVal 				=await  top.window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreview.jsp?tab_name="+tab_name+"&order_category="+order_category+query_string ,arguments,features);
					}
				}
				else if(trimString(xmlHttp.responseText)=="ML")
				{
					var retVal=new Array();
					var dialogHeight= "10" ;
					var dialogWidth	= "22" ;
					var dialogTop = "225" ;
					var center = "1" ;														   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	
					var called_frm="NewOrders";
				
				var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Get&keyObj="+patient_id+"_ML"+"&patient_id="+patient_id, false ) ;
					xmlHttp.send( xmlDoc ) ;
					if(trimString(xmlHttp.responseText)!="false")
					{
						retVal="true";
					}else{
						retVal = await window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&keyObj="+patient_id+"_ML"+"&patient_id="+patient_id+"",arguments,features);
					}
			//[IN030566] End
					if(retVal == "true")
					{
						var	dialogHeight 		= "89vh" ;
						//var	dialogWidth 		= "60" ;
						var	dialogWidth 		= "91vw" ;
						var	dialogTop 			= "100" ;
						var	dialogLeft	 		= "124" ;
						var arguments			= "";
						var retVal 				= "";
						var features 			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=no; status=no";
						var retVal 				= await top.window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreview.jsp?tab_name="+tab_name+"&order_category="+order_category+query_string ,arguments,features);
					}
				}
				else if(trimString(xmlHttp.responseText)=="AO")
				{
					var retVal=new Array();
					var dialogHeight= "10" ;
					var dialogWidth	= "22" ;
					var dialogTop = "225" ;
					var center = "1" ;														   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	
					var called_frm="NewOrders";
				//[IN030566] Start
					if(pract_id=="" && pract_name==""){
					var xmlDoc = "";
						var xmlHttp = new XMLHttpRequest();
						xmlStr			= "<root><SEARCH " ;
						xmlStr 			+=" /></root>" ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=getLoginPraName&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
						xmlHttp.send( xmlDoc ) ;
						if(trimString(xmlHttp.responseText)!="false")
						{
							var str=(trimString(xmlHttp.responseText)).split("^") ;
							pract_id=str[0];
							pract_name=str[1];
						}
					}
				var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Get&keyObj="+patient_id+"_"+pract_id+"_AO_"+order_category+"&patient_id="+patient_id, false ) ;
					xmlHttp.send( xmlDoc ) ;
					if(trimString(xmlHttp.responseText)!="false")
					{
						retVal="true";
					}else{					
						retVal = await window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&keyObj="+patient_id+"_"+pract_id+"_AO_"+order_category+"&patient_id="+patient_id+"&pract_name="+pract_name+"&pract_id="+pract_id+""+"",arguments,features);
					}
					
					if(retVal == "true")
					{
						var	dialogHeight 		= "89vh" ;
						//var	dialogWidth 		= "60" ;
						var	dialogWidth 		= "91vw" ;
						var	dialogTop 			= "100" ;
						var	dialogLeft	 		= "124" ;
						var arguments			= "";
						var retVal 				= "";
						var features 			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=no; status=no";
						var retVal 				=await  top.window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreview.jsp?tab_name="+tab_name+"&order_category="+order_category+query_string ,arguments,features);
					}
				}
				else if(trimString(xmlHttp.responseText)=="MO")
				{
					var retVal=new Array();
					var dialogHeight= "10" ;
					var dialogWidth	= "22" ;
					var dialogTop = "225" ;
					var center = "1" ;														   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	
					var called_frm="NewOrders";
					//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"",arguments,features);
				/*[IN030566] Start	
					//[IN030563] Start
					//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&pract_name="+pract_name+"&pract_id="+pract_id+"",arguments,features);
					if(temp_pass==""){
						retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&pract_name="+pract_name+"&pract_id="+pract_id+"",arguments,features);
					}else
					retVal="true";
					//[IN030563] end
				*/
					if(pract_id=="" && pract_name==""){
						var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
						xmlStr			= "<root><SEARCH " ;
						xmlStr 			+=" /></root>" ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=getLoginPraName&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
						xmlHttp.send( xmlDoc ) ;
						if(trimString(xmlHttp.responseText)!="false")
						{
							var str=(trimString(xmlHttp.responseText)).split("^") ;
							pract_id=str[0];
							pract_name=str[1];
						}
					}
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Get&keyObj="+patient_id+"_"+pract_id+"_MO"+"&patient_id="+patient_id, false ) ;
					xmlHttp.send( xmlDoc ) ;
					if(trimString(xmlHttp.responseText)!="false")
					{
						retVal="true";
					}else{					
						retVal = await window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&keyObj="+patient_id+"_"+pract_id+"_MO"+"&patient_id="+patient_id+"&pract_name="+pract_name+"&pract_id="+pract_id+""+"",arguments,features);
					}
				//[IN030566] Ends
					if(retVal == "true")
					{
						var	dialogHeight 		= "89vh" ;
						//var	dialogWidth 		= "60" ;
						var	dialogWidth 		= "91vw" ;
						var	dialogTop 			= "100" ;
						var	dialogLeft	 		= "124" ;
						var arguments			= "";
						var retVal 				= "";
						var features 			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=no; status=no";
						var retVal 				= await top.window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreview.jsp?tab_name="+tab_name+"&order_category="+order_category+query_string ,arguments,features);
					}
				}
				// else 												//[IN030563]
				else  if(trimString(xmlHttp.responseText)=="NA")		//[IN030563]
				{
				// IN029143 Ends
					var	dialogHeight 		= "89vh" ;
					//var	dialogWidth 		= "60" ;
					var	dialogWidth 		= "91vw" ;
					var	dialogTop 			= "100" ;
					var	dialogLeft	 		= "124" ;
					var arguments			= "";
					var retVal 				= "";
					var features 			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=no; status=no";
					//var retVal 				= window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreview.jsp?tab_name="+tab_name+"&order_category="+order_category+query_string ,arguments,features); //IN039584
					winRevert				=await  top.window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreview.jsp?tab_name="+tab_name+"&order_category="+order_category+query_string ,arguments,features);//IN039584
				}
		}
		else
		{
					var	dialogHeight 		= "90vh" ;
					//var	dialogWidth 		= "60" ;
					var	dialogWidth 		= "80vw" ;
					var	dialogTop 			= "100" ;
					var	dialogLeft	 		= "124" ;
					var arguments			= "";
					var retVal 				= "";
					var features 			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=no; status=no";
					var retVal 				= await top.window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreview.jsp?tab_name="+tab_name+"&order_category="+order_category+query_string ,arguments,features);
		}//IN029143 
		//Menaka Ends
		
		if(function_from=="EXTERNAL_ORDER") 
		{ // For Preview and from external order with one catalog 
				//externalOrders.formExternalOrdersPatient.selected_patient_id
				//Modified by Uma on 2/17/2010 for IN019351
				if(top.content)
				{
					if(winRevert=="RELOAD"){  //IN039584
					top.content.workAreaFrame.location.href="../../eOR/jsp/ExternalOrdersFrameset.jsp";
					}  //IN039584
				}
				/* Commented by Uma on 3/1/2010 for IN019499
				else
				{
					window.close();
				}
				/*Ends Here*/
				if(parent.parent.mainFrame!=null)
				{	
					if(function_from != "EXTERNAL_ORDER" ) // added for IN046263
						parent.parent.mainFrame.location.reload();
				}
				//?"+query_string; //EXTERNAL Order Function
		}else if(function_from=="CP" || function_from=="MO" || function_from=="REPLACE_ADD") 
		{ // For Preview and from external order with one catalog 
				//IN036383 Start.
				//parent.parent.mainFrame.location.reload();				
				if(parent.parent.parent.mainFrame!=undefined  && parent.parent.parent.mainFrame.location!=null){  //26826   added undefined validation
					parent.parent.parent.mainFrame.location.reload();
				}else{
					parent.parent.mainFrame.location.reload();
				}
				//IN036383 End.
				//window.close();

    
			parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
				//top.content.workAreaFrame.location.href="../../eCommon/html/blank.html";
		}
		else
		{
			window.close();
			//parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
			 
		}
		
		if(retVal!=null) 
		{
			if(function_from=="EXTERNAL_ORDER" || function_from=="CP" || function_from=="MO"  || function_from=="REPLACE_ADD")
			{
				if(parent.parent.mainFrame!=null )
				{	
					if(function_from != "EXTERNAL_ORDER" ) // added for IN046263
						parent.parent.mainFrame.location.reload();
				}
			}
			else 
			{
				// from additionalsearch or ticksheets
				if(parent.parent.parent.parent.orderMainTab)
					 parent.parent.parent.parent.orderMainTab.location.reload();
				/*else if(parent.parent.parent.parent.mainFrame) // for recently accesed list
					 parent.parent.parent.parent.mainFrame.location.reload();
				*/		

				/*	qry_string		 = parent.parent.parent.parent.parent.location.href
					qry_string_arr	 = qry_string.split("?");
					qry_string		 = qry_string_arr[1];
					parent.parent.parent.parent.parent.location.href = "../../eOR/jsp/EnterOrder.jsp?"+qry_string;
				*/
			}
		}	
	}// End of category!= "PH"	
} // End of rapidPreview
// Function called from OrderEntryTab.js on click of the buttons, additional search,place order etc or from external order when category="PH"
function buildQueryString(){
	var frameObj			= "";

 	if(parent.tabFrame)
			frameObj		= parent.tabFrame;
	else if(parent.parent.tabFrame) //(From Additional Search, Tick Sheets,etc)
			frameObj		= parent.parent.tabFrame;
	else if(parent.parent.parent.tabFrame) //(From Recenlty accessed List)
			frameObj		= parent.parent.parent.tabFrame;
 	patient_id 				= frameObj.document.formTab.patient_id.value;
	encounter_id			= frameObj.document.formTab.encounter_id.value;
	bean_id 				= frameObj.document.formTab.bean_id.value;
	bean_name 				= frameObj.document.formTab.bean_name.value;
	ammend_called_from 		= frameObj.document.formTab.ammend_called_from.value;
	function_from	 		= frameObj.document.formTab.function_from.value;
	//IN030279 Start
	deceased_yn	 			= frameObj.document.formTab.deceased_yn.value;
	medico_legal_yn	 		= frameObj.document.formTab.medico_legal_yn.value;
	postmortem_status	 	= frameObj.document.formTab.postmortem_status.value;
	body_part_yn	 		= frameObj.document.formTab.body_part_yn.value;
	registration_no	 		= frameObj.document.formTab.registration_no.value;	
	//IN030279 End
	p_order_catalog_code	= frameObj.document.formTab.p_order_catalog_code.value; 
	p_start_date_time		= frameObj.document.formTab.p_start_date_time.value;  
	p_task_code 	 		= frameObj.document.formTab.p_task_code.value;  
	p_task_srl_no 			= frameObj.document.formTab.p_task_srl_no.value;    
	//p_option_function_name	= frameObj.document.formTab.p_option_function_name.value;
	order_id				    = frameObj.document.formTab.order_id.value;
	iv_prep_yn				= frameObj.document.formTab.iv_prep_yn.value;
	location_code			= frameObj.document.formTab.location_code.value;
	location_type			= frameObj.document.formTab.location_type.value;
	bed_num				    = frameObj.document.formTab.bed_num.value;
	room_num				= frameObj.document.formTab.room_num.value;
	function_id				= frameObj.document.formTab.function_id.value;
	episode_id				= frameObj.document.formTab.episode_id.value;
	pract_reln_id				= frameObj.document.formTab.pract_reln_id.value;
	p_called_from_ca				= frameObj.document.formTab.p_called_from_ca.value;
	Sex				= frameObj.document.formTab.Sex.value;
	Age				= frameObj.document.formTab.Age.value;
	Dob				= frameObj.document.formTab.Dob.value;
	visit_adm_date				= frameObj.document.formTab.visit_adm_date.value;
	licence_key				= frameObj.document.formTab.licence_key.value;
	called_from				= frameObj.document.formTab.called_from.value;
	pract_id				= frameObj.document.formTab.pract_id.value;
	pract_name				= frameObj.document.formTab.pract_name.value;
	order_mode				= frameObj.document.formTab.order_mode.value;
	bt_module_install				= frameObj.document.formTab.bt_module_install.value;
	/*Added by Uma on 2/24/2010 for IN019470*/
	existing_order_called_from				= frameObj.document.formTab.existing_order_called_from.value;
	multi_called_from				= frameObj.document.formTab.multi_called_from.value;
	/*Modified by Uma on 1/3/2010 for IN019654*/
	reject_order				= frameObj.document.formTab.reject_order.value;
	/*Modified for  IN019470*/
	//alert(function_id+" in 136");
	/*Modified by Uma on 1/3/2010 for IN019654*/
	var query_string		= "&patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&ammend_called_from="+ammend_called_from+"&function_from="+function_from+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&p_order_catalog_code="+p_order_catalog_code+"&p_start_date_time="+p_start_date_time+"&p_task_code="+p_task_code+"&p_task_srl_no="+p_task_srl_no+"&location_code="+location_code+"&location_type="+location_type+"&bed_num="+bed_num+"&room_num="+room_num+"&function_id="+function_id+"&episode_id="+episode_id+"&pract_reln_id="+pract_reln_id+"&p_called_from_ca="+p_called_from_ca+"&Sex="+Sex+"&Age="+Age+"&Dob="+Dob+"&visit_adm_date="+visit_adm_date+"&licence_key="+licence_key+"&called_from="+called_from+"&pract_id="+pract_id+"&pract_name="+pract_name+"&order_mode="+order_mode+"&bt_module_install="+bt_module_install+"&existing_order_called_from="+existing_order_called_from+"&multi_called_from="+multi_called_from+"&reject_order="+reject_order;
	/*Ends Here IN019470*/
	//IN030279 Start
	query_string		= query_string+"&deceased_yn="+deceased_yn+"&medico_legal_yn="+medico_legal_yn+"&postmortem_status="+postmortem_status+"&body_part_yn="+body_part_yn+"&registration_no="+registration_no;
	//IN030279 End.
	return query_string;
}

// To change, the priority in the preview, On click of the Hyperlink
function changePriority(priority_val){
	var selectedIndex	= "";
	var font_start_val  =":&nbsp;<font size='1'>";
	var font_end_val	="</font>";
	//var hyper_link_val	="&nbsp;<a href=\"javascript:changePriority('R')\" title=\"Routine\"><fmt:message key=\"eOR.R.label\" bundle=\"${or_labels}\"/></a>&nbsp;<a href=\"javascript:changePriority('U')\" title=\"Urgent\">[U]</a>&nbsp;<a href=\"javascript:changePriority('S')\" title=\"Stat\">[S]</a>&nbsp;</font>";
	var hyper_link_val="&nbsp;<a class='gridLink' href=\"javascript:changePriority('R')\" title=\"Routine\">"+getLabel('eOR.R.label','OR')+"</a>&nbsp;<a class='gridLink' href=\"javascript:changePriority('U')\" title=\"Urgent\">"+getLabel('eOR.U.label','OR')+"</a>&nbsp;<a class='gridLink' href=\"javascript:changePriority('S')\" title=\"Stat\">"+getLabel('eOR.S.label','OR')+"</a>&nbsp;</font>"
	
	if(priority_val!=null && priority_val=="R") {
		parent.criteriaMainFrame.document.getElementById('priority_id').innerHTML=font_start_val+getLabel("Common.routine.label","Common")+hyper_link_val+font_end_val;
		parent.criteriaMainFrame.document.getElementById('priority').value = "R";
		selectedIndex	= "0";
	} else if(priority_val!=null && priority_val=="U") { 
		parent.criteriaMainFrame.document.getElementById('priority_id').innerHTML=font_start_val+getLabel("Common.urgent.label","Common")+hyper_link_val+font_end_val;
		parent.criteriaMainFrame.document.getElementById('priority').value = "U";
		selectedIndex	= "1";
	} else if(priority_val!=null && priority_val=="S") {
		parent.criteriaMainFrame.document.getElementById('priority_id').innerHTML=font_start_val+getLabel("Common.Stat.label","COMMON")+hyper_link_val+font_end_val; 
		parent.criteriaMainFrame.document.getElementById('priority').value = "S";
		selectedIndex	= "2";
	}

	if(priority_val!=null && parent.criteriaMainFrame.document.placeOrderHeaderForm.priority)
		changeLinePriorites(priority_val);
} // End of changePriority

// change the priority in all the line levels.
function changeLinePriorites(priority_val){
	var totalCount		= parseInt(eval("parent.placeOrderDetailFrame.document.placeOrderForm.total_rows.value;"));
	
	for(i=0;i<totalCount;i++){
		if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.group_order_category"+i)){
		var group_order_category = eval("parent.placeOrderDetailFrame.document.placeOrderForm.group_order_category"+i+".value");
 		if(parent.placeOrderDetailFrame.document.getElementById('priority_id'+i)){
			parent.placeOrderDetailFrame.document.getElementById('priority'+i).value=priority_val;
			priority_appl = parent.placeOrderDetailFrame.document.getElementById('priority_appl'+i).value; //Priority applicable or not 
			
			var href_val	= "";
			if(group_order_category!="OT")
				href_val	= "href=javascript:changePriorityLineLevel('"+i+"')";  
			else 
				href_val	= "";
			if(priority_val=="U" && (priority_appl==null  || priority_appl=="" || priority_appl=="2")) {
				eval("parent.placeOrderDetailFrame.document.getElementById('priority_id'+i).innerHTML=\"&nbsp;<font size='1'><a class='gridLink' "+href_val+" title='Urgent'><b>"+getLabel('Common.urgent.label','Common')+"&nbsp;</b></a></font>\" ");
			} else if(priority_val=="S" && (priority_appl==null  || priority_appl=="" || priority_appl=="3")) {
				eval("parent.placeOrderDetailFrame.document.getElementById('priority_id'+i).innerHTML=\"&nbsp;<font size='1'><a class='gridLink' "+href_val+" title='Stat'><b>"+getLabel('Common.Stat.label','COMMON')+"&nbsp;</b></a></font>\" ");
			} else if(priority_appl!="3") {
				eval("parent.placeOrderDetailFrame.document.getElementById('priority_id'+i).innerHTML=\"&nbsp;<font size='1'><a class='gridLink' "+href_val+" title='Routine'><b>"+getLabel('Common.routine.label','Common')+"&nbsp;</b></a></font>\" ");
			} 
			skipAuthIndicator();//IN048467 - HSA-CRF-0150
		} // End of if
		}
	} // End of For
} // End of changeLinePriorites

// FOR THE Header Level, get the Common Calendar and then check for the date
/*function changeHeaderDateTime(){
	var order_date_time = document.placeOrderHeaderForm.order_date_time.value;
	showCommonCalendar("order_date_time_id");
	if(parent.criteriaMainFrame.document.placeOrderHeaderForm){
		if(document.placeOrderHeaderForm.order_date_time) {
			document.placeOrderHeaderForm.all.order_date_time_href_id.innerHTML= "&nbsp;<font size=\"1\"><a href=\"#\" onClick=\"javascript:return changeHeaderDateTime()\" title=\"OrderDateTime\">&nbsp;"+document.placeOrderHeaderForm.order_date_time.value+"</a></font>";
		}
	}
	if(changeDateTime(document.placeOrderHeaderForm.order_date_time,"")==false)
	{
		document.placeOrderHeaderForm.order_date_time.value = order_date_time;
		document.placeOrderHeaderForm.all.order_date_time_href_id.innerHTML= "&nbsp;<font size=\"1\"><a href=\"#\" onClick=\"javascript:return changeHeaderDateTime()\" title=\"OrderDateTime\">&nbsp;"+order_date_time+"</a></font>";	
	}
} // End of changeHeaderDateTime
*/
// For the Line Level, get the Common Calendar and then check for the date
/*function changeLineLevelDateTime(disp_obj,row_value){
	var start_date_time = 	eval("document.placeOrderForm.start_date_time"+row_value+".value");
	showCommonCalendar(disp_obj);
	var latest_start_date_time = eval("document.placeOrderForm.start_date_time"+row_value+".value");
	if(parent.placeOrderDetailFrame.document.placeOrderForm){
		//if(changeDateTime(eval("document.placeOrderForm.start_date_time"+row_value),"")==false)
		//{
		//	eval("document.placeOrderForm.start_date_time"+row_value+".value=start_date_time"); // put the old value back
		//	eval("document.placeOrderForm.all.start_date_time_href_id"+row_value+".innerHTML=\"&nbsp;<font size='1'><a href=javascript:changeLineLevelDateTime('"+disp_obj+"','"+row_value+"') title='OrderDateTime'>"+start_date_time+"</font>\" ");
		//}
		//else	
		//{
			if(eval("document.placeOrderForm.start_date_time"+row_value)) {
				if(changeDateTime(eval("document.placeOrderForm.start_date_time"+row_value),"")==false) {
					eval("document.placeOrderForm.start_date_time"+row_value+".value=start_date_time"); // put the old value back
					eval("document.placeOrderForm.all.start_date_time_href_id"+row_value+".innerHTML=\"&nbsp;<font size='1'><a href=javascript:changeLineLevelDateTime('"+disp_obj+"','"+row_value+"') title='OrderDateTime'>"+start_date_time+"</font>\" ");
				}else {
					eval("document.placeOrderForm.start_date_time"+row_value+".value=latest_start_date_time"); // put the latest value
					eval("document.placeOrderForm.all.start_date_time_href_id"+row_value+".innerHTML=\"&nbsp;<font size='1'><a href=javascript:changeLineLevelDateTime('"+disp_obj+"','"+row_value+"') title='OrderDateTime'>"+latest_start_date_time+"</font>\" ");
				}		
			}
		//}
	}
} // End of changeLineLevelDateTime
*/
// Method called to show the Common Calendar Interface
function showCommonCalendar(display_id){
	showCalendar( display_id ,null,'hh:mm',true);// call the Calendar Interface, to display the Calendar, and it will set the date to the hidden field
} // End of showCommonCalendar

// To change the priorities of the Header level, if the line levels r changed and they r same.
function changePriorityLineLevel(row_value,catcode){

	var priority_val	= eval("document.placeOrderForm.priority"+row_value+".value"); 
	var priority_appl	= eval("document.placeOrderForm.priority_appl"+row_value+".value"); 
	var order_category	= eval("document.placeOrderForm.group_order_category"+row_value+".value"); 
	if((priority_val!=null && priority_val=="R") && (priority_appl==null  || priority_appl=="" || priority_appl=="2") && order_category!="OT") { // Change the next level -- urgent
		eval("document.getElementById('priority_id'+row_value).innerHTML=\"&nbsp;<font size='1'><a class='gridLink' href=javascript:changePriorityLineLevel('"+row_value+"') title='Urgent'><b>"+getLabel('Common.urgent.label','Common')+"&nbsp;</b></a></font>\" ");
		eval("document.placeOrderForm.priority"+row_value+".value='U'");
	} else if( (priority_val!=null && priority_val=="U") && (priority_appl==null  || priority_appl=="" || priority_appl=="3") && order_category!="OT"){ // Change the next level -- stat
		eval("document.getElementById('priority_id'+row_value).innerHTML=\"&nbsp;<font size='1'><a class='gridLink' href=javascript:changePriorityLineLevel('"+row_value+"') title='Stat'><b>"+getLabel('Common.Stat.label','COMMON')+"&nbsp;</b></a></font>\" ");
		eval("document.placeOrderForm.priority"+row_value+".value='S'");
	} else if(priority_appl!="3" && order_category!="OT") {
		eval("document.getElementById('priority_id'+row_value).innerHTML=\"&nbsp;<font size='1'><a class='gridLink' href=javascript:changePriorityLineLevel('"+row_value+"') title='Routine'><b>"+getLabel('Common.routine.label','Common')+"&nbsp;</b></a></font>\" ");
		eval("document.placeOrderForm.priority"+row_value+".value='R'");
	} else { // if OT category, same value should be there not allowed to change 
		eval("document.getElementById('priority_id'+row_value).innerHTML=\"&nbsp;<font size='1'><a class='gridLink' href=javascript:changePriorityLineLevel('"+row_value+"') title='Routine'><b>"+getLabel('Common.routine.label','Common')+"&nbsp;</b></a></font>\" ");
		eval("document.placeOrderForm.priority"+row_value+".value='R'");
	}
	setOrderPriority('priority',catcode,row_value); // call the existing function, to change the header if all the lines have same priority
} // End of changePriorityLineLevel

// To increase or decrease the value without entering
function changeValue(move_direction, code, row_value){
	var value = eval("document.placeOrderForm."+code+".value"); 
	if(value!=null && value!=0)
	{
		if(move_direction!=null && move_direction=="P")
		{
			value = parseFloat(value)-1;
		}
		else if(move_direction!=null && move_direction=="N")
		{
			value = parseFloat(value) +1;
		}
		if(code.indexOf("duration_value")!=-1)   // For Duration
		{
			if(value!=0 && value>0 && value<1000) // Not more than 999 and should not be 0 or lesser than it
			{
				eval("document.placeOrderForm."+code+".value=value"); 
				eval("document.placeOrderForm."+code+".focus()");
			}
		}
		else if(code.indexOf("quantity")!=-1)   // For Quantity (length has been increased to 6)
		{
			if(value!=0 && value>0 && value<1000000) // Not more than 99999 and should not be 0 or lesser than it
			eval("document.placeOrderForm."+code+".value=value"); 
		}
	}
	reviseBillingchrgs(row_value,"OP_NEW_ORDER"); //IN28273
} // End of changeValue


// Will open a dialog box, and can select the frequency
async function changeRapidFrequency(i , catalog_code, order_category, facility_id){
	eval("document.placeOrderForm.end_date_time"+i+".value=''");
	eval("document.placeOrderForm.duration_code"+i+".value=''");
	eval("document.placeOrderForm.duration_value"+i+".value=''");
	eval("document.placeOrderForm.frequency_val"+i+".value=''");
	eval("document.placeOrderForm.freq_nature"+i+".value=''");

	eval("document.getElementById('duration_code_id'+i).innerHTML=\"&nbsp;\"");
	
	var bean_id 	= document.placeOrderForm.bean_id.value ;
	var bean_name 	= document.placeOrderForm.bean_name.value ;

	/*eval("document.placeOrderForm.start_date_time"+i+".readOnly=false");
	// Call the dynamic jsp to remove the value (Schedule Frequency) from the bean.
	
	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+= obj.name+"=\""+ obj.value +"\" " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&catalog_code="+catalog_code+"&row_value="+i+"&func_mode=REMOVE_SCHEDULE", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText	= xmlHttp.responseText ;
	eval( responseText ) ;
	*/
	var codedesc=new Array();
	var duration_desc		= "";
	var	dialogHeight 		= "50vh" ;
	var	dialogWidth 		= "45vw" ;
	var	dialogTop 			= "160" ;
	var	dialogLeft	 		= "140" ;
	var arguments			= "";
	var retVal 				= "";
	var features 			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop+'; dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var retVal 				= await top.window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreviewSelectFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&title_hdg=Frequency Applicable&func_mode=FREQUENCY&order_category="+order_category+"&order_catalog_code="+catalog_code,arguments,features);
	if(retVal!=undefined)
	{
		if(retVal.length>0){
		//if(obj.value!='')
		//{
		//	if(val=="onChange")
		//		eval("document.placeOrderForm.duration_value"+i+".value=''");
			for(len=0;len<retVal.length;len++)
			{
					codedesc[len] = retVal[len];
			}
		
			if(codedesc[0]==null) codedesc[0] = "";
			if(codedesc[1]==null) codedesc[1] = "";
			if(codedesc[0]!=null){
				var value	 = codedesc[0].split("~~");
				if(value[0]==null) value[0] = "";
				if(value[1]==null) value[1] = "";	
				if(value[1]=="M" )		duration_desc = "<font size='1'>Minute(S)</font>";
				else if(value[1]=="H" ) duration_desc = "<font size='1'>Hour(S)</font>";
				else if(value[1]=="D" ) duration_desc = "<font size='1'>Day(S)</font>";
				else if(value[1]=="W" ) duration_desc = "<font size='1'>Week(S)</font>";
				else if(value[1]=="L" ) duration_desc = "<font size='1'>Month(S)</font>";
				else duration_desc = "";

				if(value[2]==null) value[2] = "";if(value[5]==null) value[5] = "N";//Schedule_yn
				if(value[6]==null) value[6] = "F"; //freq_nature
				if(codedesc[1]!=null){
					eval("document.getElementById('frequency_id'+i).innerHTML=\"&nbsp;<font size='1'><a class='gridLink' href=javascript:changeRapidFrequency('"+i+"','"+catalog_code+"','"+order_category+"','"+facility_id+"') title='Frequency'>"+codedesc[1]+"</a></font>\" ");
				} // End of value[0] !=null

				eval("document.getElementById('frequency_val'+i).value=value[0]");
				eval("document.getElementById('duration_code'+i).value=value[1]");

				eval("document.getElementById('duration_code_id'+i).innerHTML=duration_desc");
				//eval("document.placeOrderForm.duration_value"+i+".value=value[2]");
				eval("document.getElementById('duration_def_value'+i).value=value[2]");
				eval("document.getElementById('freq_nature'+i).value= value[6]");
				if(value[0]==null || value[0]=="" || value[1]== null || value[1]=="")
				{
					//eval("document.placeOrderForm.duration_value"+i+".value=''");
					eval("document.getElementById('duration_value'+i).readOnly=true");
				}
				else
					eval("document.getElementById('duration_value'+i).readOnly=false");
				if(value[5]=="Y")
				{
					document.getElementById('schedule_yn'+i).value = value[5];
					eval("document.getElementById('schedule'+i).innerHTML = \"<a class='gridLink' href=javascript:DisplaySchedule('"+catalog_code+"','Schedule"+catalog_code+"','"+i+"','"+facility_id+"','')  title='Schedule Frequency'><font size='1'>Schd</font></a>&nbsp;<img 	src='../../eCommon/images/mandatory.gif'></img>\" ");
				}
				else
				{
					document.getElementById("schedule"+i).innerHTML="&nbsp";
					document.getElementById("schedule_yn"+i).value = value[5];
				}
				// If start_date_time, duration_code and duration_value is not null it should calculate the end_date_time
				start_date_time =document.getElementById('start_date_time'+i).value;
				duration_code	= document.getElementById('duration_code'+i).value;
				duration_value  = document.getElementById('duration_value'+i).value;
				calculateEndDateTime(start_date_time,duration_code,duration_value,i,'');			//start_date_time,Duration Code,Duration Value,called_from is null
				} // End of codedesc[0]!=null
		} // End of retVal!=null
	}
} // End of changeRapidFrequency

function retCodeDescription(code,obj)
{ // Pass the value back to the window.
	var retCodeDescArray=new Array();
	retCodeDescArray[0]=code;
	retCodeDescArray[1]=(obj.innerText);
	//window.returnValue = retCodeDescArray;
	//window.close();
	
	parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = retCodeDescArray;
	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
} // End of returnCodeDescription
//function changePerformingDeptLoc(i , performing_facility_id, order_catalog_code, order_category, lb_instal_yn, rd_instal_yn){changed on 7/9/2007 for lb_instal_yn logic by uma
async function changePerformingDeptLoc(i , performing_facility_id, order_catalog_code, order_category, order_type_code, rd_instal_yn){
	var bean_id 			= document.placeOrderForm.bean_id.value ;
	var bean_name 			= document.placeOrderForm.bean_name.value ;
	performing_facility_id = eval("document.placeOrderForm.performing_facility_id"+i).value;
	var	dialogHeight 		= "55vh" ;
	var	dialogWidth 		= "45vw" ;
	var	dialogTop 			= "5vh" ;
	var	dialogLeft	 		= "140" ;
	var arguments			= "";
	var retVal 				= "";
	var value					= new Array();
	var features 			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+"; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=no; status=no";
	//var retVal 				= window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreviewSelectFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&title_hdg=PerformingDepartmentLocation&func_mode=PERFORMING_DEPT_LOC&performing_facility_id="+performing_facility_id+"&order_catalog_code="+order_catalog_code+"&order_category="+order_category+"&lb_instal_yn="+lb_instal_yn+"&rd_instal_yn="+rd_instal_yn,arguments,features);changed on 7/9/2007 for lb_instal_yn logic by uma
	var retVal 				= await top.window.showModalDialog("../../eOR/jsp/OrderEntryRapidPreviewSelectFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&title_hdg=PerformingDepartmentLocation&func_mode=PERFORMING_DEPT_LOC&performing_facility_id="+performing_facility_id+"&order_catalog_code="+order_catalog_code+"&order_category="+order_category+"&order_type_code="+order_type_code+"&rd_instal_yn="+rd_instal_yn,arguments,features);
	if(retVal!=undefined)
	{
		if(retVal.length>0)
		{
			for(len=0;len<retVal.length;len++)
			{
				value[len] = retVal[len];
			}
			document.getElementById('performing_dept_loc_code'+i).value=value[0];
			//eval("document.placeOrderForm.all.performing_dept_loc_code_id"+i+".innerHTML = \"<a href=javascript:changePerformingDeptLoc('"+i+"','"+performing_facility_id+"','"+order_catalog_code+"','"+order_category+"','"+lb_instal_yn+"','"+rd_instal_yn+"')><font size='1'>"+value[1]+"</font></a>\" ");changed on 7/9/2007 for lb_instal_yn logic by uma
			eval("document.getElementById('performing_dept_loc_code_id'+i).innerHTML = \"<a class='gridLink' href=javascript:changePerformingDeptLoc('"+i+"','"+performing_facility_id+"','"+order_catalog_code+"','"+order_category+"','"+order_type_code+"','"+rd_instal_yn+"')><font size='1'>"+value[1]+"</font></a>\" ");
			getApptReqdYN(order_catalog_code,document.getElementById('performing_dept_loc_code'+i),i);
		}
	}
} // End of changePerformingDeptLoc

// Order Format For the Header in the Preview
async function orderFormatForPreviewHeader(format_id,order_category,catalog_code,count,chk_mand)
{
	var dialogFrameObj = parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1];
	
	if (dialogFrameObj)		
		dialogFrameObj = dialogFrameObj.contentWindow;
	
	if(parent.DetailFrame)	// On Press of record, if mandatorily and not entered
	 	formObj			= parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
	else if(document.placeOrderForm)// on press of the header level format hyperlink
	  	formObj			= document.placeOrderForm;
	else if(dialogFrameObj.criteriaPlaceOrderFrame.placeOrderDetailFrame)
		formObj			= dialogFrameObj.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
		
   	var bean_id 		= formObj.bean_id.value;
	var bean_name 		= formObj.bean_name.value;
	var sys_date		= formObj.sys_date.value;
	var sex				= formObj.sex.value;
	var dob				= formObj.dob.value;
	var order_date_time = "";
	if(parent.criteriaMainFrame)
		order_date_time				= parent.criteriaMainFrame.document.getElementById("order_date_time").value;
	//var perf_facility_id= eval("formObj.performing_facility_id0.value"); // Get the first performing facility id
	var perf_facility_id= ""; 
	var total_rows		= formObj.total_rows.value;
	for(var i=0;i<total_rows;i++){
		if(eval("formObj.performing_facility_id"+i)){// Get the first performing facility id
		perf_facility_id= eval("formObj.performing_facility_id"+i+".value");
		break;
		}
	}
    var row_value		= "0"; 					// since it is a header ,it is passed as a 0
    var catalog_code	= order_category;   	// since it is entry in the header,the order_category is passed as same
    var retVal;
  	var dialogHeight 	= "40vh" ;
	//var dialogWidth  	= "50" ;
	var dialogWidth  	= "65vw" ;
	var dialogTop   	= "100";
	var dialogLeft   	= "170";
	var features    	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
  	var arguments;
  	var url 			= "";
  	url 				= "../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?from_header=Y&called_from=PREVIEW_HEADER&order_category="+order_category+"&format_id="+escape(format_id)+"&row_value="+row_value+"&catalog_code="+escape(catalog_code)+"&care_set_catalog_code="+escape(catalog_code)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&performing_facility_id="+perf_facility_id+"&sys_date="+escape(sys_date)+"&sex="+escape(sex)+"&dob="+escape(dob)+"&chk_mand="+chk_mand+"&order_date_time="+order_date_time;
	retVal = await window.showModalDialog(url,arguments,features);
	var formatIdYn = eval("formObj.format_id_yn"+count);
  	if(retVal!=null){
  		formatIdYn.value =  retVal;

	}
} // End of orderFormatForPreviewHeader

//keygetRecentResult()
// Called after entering the no of occurances in a text box and hitting the enter key
//function keygetRecentResult(){
//	if(ChkNumberInput(obj,event, '0')==true) {
//	 	if(window.event.keyCode==13) {    // if it is an enter key, then call the method for population of the catalogs
 //	 		getRecentResult();   // Call the getRecentResult Function
//		}
//	}  
//}

function getRecentResult() { // Get the catalogs display if it is for the practitioner
 
	//var frmObj			= document.recentlyAccessedCriteriaForm;
  	var query_string		= ""; var detail_query_string = "";
 	if(parent.parent.criteriaMainFrame.criteriaMainSearchFrame) {
		var frmObj			= parent.parent.criteriaMainFrame.criteriaMainSearchFrame.document.recentlyAccessedCriteriaForm;
		query_string		= frmObj.query_string.value;
	 	query_string		+= "&no_of_occurances="+frmObj.no_of_occurances.value
 	}
	if(parent.parent.criteriaDetailFrame.criteriaMainSearchFrame) {
		var frmObjDetail	= parent.parent.criteriaDetailFrame.criteriaMainSearchFrame.document.recentlyAccessedCriteriaForm;
		detail_query_string	= frmObjDetail.query_string.value;
		detail_query_string	+= "&no_of_occurances="+frmObj.no_of_occurances.value; //As of now take from the practitioner frame only
	 	//detail_query_string	+= "&no_of_occurances="+frmObjDetail.no_of_occurances.value
 	}
 	//var search_by			= frmObj.search_by.value;
 	//if(search_by=="practitioner")
 		parent.parent.criteriaMainFrame.criteriaDetailResultsFrame.location.href="../../eOR/jsp/OrderEntryRecentlyAccessedList.jsp?"+query_string 
	//else if(search_by=="patient")	 
		parent.parent.criteriaDetailFrame.criteriaDetailResultsFrame.location.href="../../eOR/jsp/OrderEntryRecentlyAccessedList.jsp?"+detail_query_string 

}

function previewRefresh() { //Refresh the Preview  Function in New Order
	
	formObj = criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
	var form =criteriaPlaceOrderFrame.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	var count = formObj.total_rows.value;
	var old_cat_count= "" ;var cat_count = 0,tmp_cat_count=0;
	var order_cat = new Array();
	var temp_order_cat = new Array();var temp_cat_count= ""; 
	//for(var i=0;i<formObj.length;i++)
	for(var i=0;i<count;i++)
	{
		if(eval("formObj.catalog_code"+i))
		{
			catalog_code_val = eval("formObj.catalog_code"+i+".value");
			checked_yn		 =form["ck"+catalog_code_val].value;
			if(eval("formObj.group_order_category"+i)){
				
				if( eval("formObj.group_order_category"+i+".value") != temp_cat_count){
					temp_cat_count = eval("formObj.group_order_category"+i+".value");
					temp_order_cat[tmp_cat_count] = temp_cat_count ;
					tmp_cat_count++;
				}
			}
		    if(checked_yn=="N") //Then only remove the row
			{
		    	//IN069657, starts
		    	if(eval("formObj.format_id_mandatory_yn"+i).value=='Y'){
		    		var fomat_mand_cnt_unchecked = parseInt(criteriaPlaceOrderFrame.placeOrderDetailFrame.document.getElementById('format_mandatory_count').value)-1;
					formObj.format_mandatory_count.value = fomat_mand_cnt_unchecked;	
					setFormatLegendsLineLevel(fomat_mand_cnt_unchecked);
				}
		    	//IN069657, ends
				console.log(parent);
				//console.log(parent.criteriaPlaceOrderFrame);
				console.log(frames[0].frames[1]);
				if(frames[0].frames[1].document.getElementById("row"+catalog_code_val))
				{
					var index_val =frames[0].frames[1].document.getElementById("row"+catalog_code_val).rowIndex;
					//var index_val = eval("parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.all.row"+catalog_code_val+".rowIndex");
					//eval("frames[0].frames[1].document.placeOrderForm.all.detailTab.deleteRow("+index_val+")");
					frames[0].frames[1].document.getElementById("detailTab").deleteRow(index_val);

				}
			}
			if(eval("formObj.group_order_category"+i)){
			//	alert("=group_order_category==="+eval("formObj.group_order_category"+i+".value"));
			}
			//alert(catalog_code_val);
			//alert(formObj.total_order_cat_count.value);
			if(formObj.total_order_cat_count)
			{
				var ord_cat_count= formObj.total_order_cat_count.value;
			}
			var new_cat_count= "" ;
			if(eval("formObj.group_order_category"+i))
				new_cat_count= eval("formObj.group_order_category"+i+".value");
			//alert(formObj.total_rows.value);
			if( new_cat_count != "" && new_cat_count != old_cat_count ){
				order_cat[cat_count] = new_cat_count ;
				old_cat_count= new_cat_count ;
				cat_count++;
			}
		} //End of if catalog_code
		
	} // End of for 
	
	var del_category = "";
	if(temp_order_cat.length > order_cat.length){
	for(var i=0;i<temp_order_cat.length;i++){
		var tmp_incr=0;
		for(var j=0;j<order_cat.length;j++){
			if(temp_order_cat[i] == order_cat[j]){
				tmp_incr++;
			}
		}
		if(tmp_incr == 0){
			del_category = temp_order_cat[i];
			for(var k=0;k<formObj.length;k++){
				if(eval("parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm."+del_category)){
				var index_val = eval("parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm."+del_category+".rowIndex");
				eval("parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.all.detailTab.deleteRow("+index_val+")");
				var index_val1 = eval("parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.head"+del_category+".rowIndex");
				eval("parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.detailTab.deleteRow("+index_val1+")");
				break;
				}
			}
		}
	}
	}
	
} //End of previewRefresh

function loadPreview(function_from, order_catalog_code, order_category){
	//alert("function_from"+function_from+"order_catalog_code"+order_catalog_code+"order_category"+order_category);
  	if(order_catalog_code!=""){
  		// Store it in a Js Global Variable // Ck to represent the checkbox, which is the same way used to put it in the bean
		check_box_length 	= parent.tabFrame.check_box_val.length;//Global Variable in OrderEntryTab.jsp
  		// Get the Length of the Array of the variable and set the code to it
		parent.tabFrame.check_box_val[check_box_length] = "ck"+order_catalog_code // Store it in a JS Global Variable (OrderEntryGloabal.js)in the OrderEntryTab.jsp
 		rapidPreview(function_from,order_category); // function_from will be "EXTERNAL_ORDERS" / "CP"
	} // End of order_catalog_code
} // End of loadPreview
//IN069657, starts
function setFormatLegendsLineLevel(format_mandatory_count){	
	if(parseInt(format_mandatory_count) > 0){		
	//console.log(criteriaPlaceOrderFrame);
	 criteriaPlaceOrderFrame.criteriaDetailFrame.document.getElementById('order_mandatory').innerHTML	= "<a class='gridLink' href='javascript:parent.parent.orderFormatForLineLevel()'><img src='../../eOR/images/Flex_red.gif' align='center'></a>"+getLabel("eOR.AddlInfo(Mandatory).label","OR");
	}else	
		criteriaPlaceOrderFrame.criteriaDetailFrame.document.getElementById('order_mandatory').innerHTML	= "<a class='gridLink' href='javascript:parent.parent.orderFormatForLineLevel()'><img src='../../eOR/images/Flex_blue.gif' align='center'></a>"+getLabel("eOR.AddlInfo(Optional).label","OR");
}
//IN069657, ends

