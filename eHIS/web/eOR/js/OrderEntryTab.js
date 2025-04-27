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
Date       Edit History     	 Name      		Rev. Date	Rev. Name     Description 
--------------------------------------------------------------------------------------------------------------
?             100          	  ?           		    ?		   ?		created
22/6/2011     101            	Chowminya     		    ?		   ?		Incident No: IN027797 - <Clinical comments, order format not shown in 
																	the view mode> 
11/08/2011	  IN00747	Chowminya	       	    ?		   ?		Incident No: IN00747 - <Clinical comments mandatory check in Preview  
																	 mode> 
12/10/2011	  IN029202	Chowminya		    ?		   ?		Incident No: IN029202 - <Clinical comments thai data shown incorrectly>																	 

03/01/2013	  IN036868	Ramesh G		    ?		   ?		New Orders window we don?t have Tick Sheets, Order Sets, Image/Radiology tabs				
13/08/2013	  IN042045	Chowminya G		    ?		   ?		System should not allow to copy for the drugs for which Verbal Order Applicable is not selected											 
02/07/2014	  IN048467 	Nijitha S		    ?		   ?													HSA-CRF-0150	
30/10/2017	  IN061906	Kamalakannan G	 	30/10/2017	Ramesh G	System should not show orderset if order category is mandatory & resets the values while calling clearCareSetList										 
10/11/2017	  IN065705	Kamalakannan G	 	10/11/2017	Ramesh G	System should disable select button until user selects orderset	
26/07/2018	  IN064543	Kamalakannan		26/07/2018	Ramesh G		ML-MMOH-CRF-0776	
17/02/2020	 IN071260	Nijitha S			17/02/2020	Ramesh G	`MMS-KH-CRF-0029.3
29/02/2020	  IN072592		Nijitha S	29/02/2020		Ramesh G	OR-MMS-KH-CRF-0029.3/03-Place order								 
---------------------------------------------------------------------------------------------------------------
*/

var care_set_value = "";
// Function is called to change the tabs and it respective screens
function change_tab(obj)  // To change the tabs(td )
{  

	var tab_name			= "";
	var  query_string		= buildQueryString();

 	//parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryFrameSet.jsp?tab_name=AdditionalSearch"+query_string;
	if(obj=="FrequentOrders") tab_name = "FrequentOrders";
 	else if(obj=="AdditionalSearch") tab_name = "AdditionalSearch";
 	else if(obj=="TickSheet")	tab_name = "TickSheet";
  	else if(obj=="Image")		tab_name = "Image";
  	else if(obj=="CareSet")		tab_name = "CareSet";
  	else if(obj=="PlaceOrder")
	{
		tab_name = "PlaceOrder";
		//if(function_from!="AMEND_ORDER" && function_from!="RENEW_ORDER")
  		//if(ammend_called_from!="existing_order" && top.messageframe)
  		//	top.messageframe.location.href="../../eCA/jsp/error1.jsp";
  	}
  	// Call the bean to store the values , if checked or unchecked
	if(obj=="CareSet")
	{
		if(function_from!="RENEW_ORDER")
		{
			if(parent.tabFrame.document.formTab.flag.value == "FrequentOrders")
  				storeCheckedValues("recentlyAccessedForm","NO");
			//else if(parent.tabFrame.document.formTab.flag.value == "DrawingTools")
  			//	storeCheckedValues("drawingToolResults","NO");
	  		else if(parent.tabFrame.document.formTab.flag.value == "AdditionalSearch")
  				storeCheckedValues("orderSetResultForm","NO");
  			else if(parent.tabFrame.document.formTab.flag.value == "TickSheet")
  				storeCheckedValues("tickSheetItemsForm","NO");
	  		else if(parent.tabFrame.document.formTab.flag.value == "Image")
  				storeCheckedValues("imagePanelsForm","NO");
		}
		//else alert(getOrMessage("CLICK_RENEW_ORDER"))
	}
	else
	{
		if(function_from!="RENEW_ORDER")
		{
			if(parent.tabFrame)
			{
				if(parent.tabFrame.document.formTab.flag.value == "FrequentOrders")
					storeCheckedValues("recentlyAccessedForm","NO");
				//else if(parent.tabFrame.document.formTab.flag.value == "DrawingTools")
				//	storeCheckedValues("drawingToolResults","NO");
				else if(parent.tabFrame.document.formTab.flag.value == "AdditionalSearch")
					storeCheckedValues("orderSetResultForm","NO");
				else if(parent.tabFrame.document.formTab.flag.value == "TickSheet")
					storeCheckedValues("tickSheetItemsForm","NO");
				else if(parent.tabFrame.document.formTab.flag.value == "Image")
					storeCheckedValues("imagePanelsForm","NO");
				else if(parent.tabFrame.document.formTab.flag.value == "PlaceOrder")
					storeCheckedValues("PlaceOrder","NO");
			}
			else if(parent.parent.parent.tabFrame)
			{
				if(parent.parent.parent.tabFrame.document.formTab.flag.value == "FrequentOrders")
					storeCheckedValues("recentlyAccessedForm","NO");
				//else if(parent.tabFrame.document.formTab.flag.value == "DrawingTools")
				//	storeCheckedValues("drawingToolResults","NO");
				else if(parent.parent.parent.tabFrame.document.formTab.flag.value == "AdditionalSearch")
					storeCheckedValues("orderSetResultForm","NO");
				else if(parent.parent.parent.tabFrame.document.formTab.flag.value == "TickSheet")
					storeCheckedValues("tickSheetItemsForm","NO");
				else if(parent.parent.parent.tabFrame.document.formTab.flag.value == "Image")
					storeCheckedValues("imagePanelsForm","NO");
				else if(parent.parent.parent.tabFrame.document.formTab.flag.value == "PlaceOrder")
					storeCheckedValues("PlaceOrder","NO");
			}
		}
		//else alert(getOrMessage("CLICK_RENEW_ORDER"))
	}
	/*
	if(obj=="PlaceOrder" && parent.orderentry) {
		var tempCols		=	"*,0%"  
 	 	parent.orderentry.cols  = tempCols;
 	}*/
	if(obj=="Image")
	{
		parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryImage.jsp?tab_name=Image"+query_string;
	}
	else
	{
		if(parent.DetailFrame)
		{			
			
			var activity_type_code= document.formTab.exist_activity_type_code.value;
			var activity_type_desc=document.formTab.exist_activity_type_desc.value;
			//parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryFrameSet.jsp?tab_name="+tab_name+query_string+"&activity_type_code="+escape(activity_type_code)+"&activity_type_desc="+escape(activity_type_desc);
			parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryFrameSet.jsp?tab_name="+tab_name+query_string+"&activity_type_code="+activity_type_code+"&activity_type_desc="+activity_type_desc;
		}
		else if(parent.parent.parent.DetailFrame)
		{			
			parent.parent.parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryFrameSet.jsp?tab_name="+tab_name+query_string;
		}
	}

	if(parent.tabFrame)
		parent.tabFrame.document.formTab.flag.value = tab_name;
	else if(parent.parent.parent.tabFrame)
		parent.parent.parent.tabFrame.document.formTab.flag.value = tab_name;
} // End of change_tab

function display(obj)
{	
	cellref = document.getElementById("tab").rows[0].cells;
	for(i=0; i<cellref.length; i++)
	{
		if(cellref[i].id!="empty_tab" && cellref[i].id!="bloodTransfusion"  && cellref[i].id!="patientDetails") // For Empty Cell
			cellref[i].className = "CAFIRSTSELECTHORZ"
	}
	obj.className 	= "CASECONDSELECTHORZ"
	currClass 		="CASECONDSELECTHORZ";
} // End of display

// Function to display the Clinical Comments in the Header(Amend/Review Function)
 async function DisplayAmendComments(field_name,hdg_name,order_id,order_category)
 {
	var comments;
	var retVal;
 	var dialogHeight;
 	dialogHeight 		= '35vh' ;
 	var dialogWidth 	= '53vw' ;
 	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=yes; status=no';
	//--[101]--/start---
	var inputArr 			= document.getElementsByTagName("input");
	var lineInputArr 		= parent.placeOrderDetailFrame.document.getElementsByTagName("input");
	for (u=0;u<inputArr.length;u++){
		if (inputArr[u].name == field_name){
			comments 		= inputArr[u].value;
		}
	}
	//--[101]--/end---
	bean_id				= document.placeOrderHeaderForm.bean_id.value;
 	bean_name			= document.placeOrderHeaderForm.bean_name.value;
	if(document.placeOrderHeaderForm.cl_cmt_mand.style.visibility=="visible")
		{
		
			document.placeOrderHeaderForm.clin_cmts_reqd_yn.value="Y";
		}
		else
		{
			document.placeOrderHeaderForm.clin_cmts_reqd_yn.value="N";
		}
	clin_cmts_reqd_yn	= document.placeOrderHeaderForm.clin_cmts_reqd_yn.value;
	retValue 			= await window.showModalDialog("../../eOR/jsp/OrderEntryAmendClinicalComments.jsp?hdg_name="+hdg_name+"&order_id="+order_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&clin_cmts_reqd_yn="+clin_cmts_reqd_yn+ "&comments="+comments,"",features);
		var retVal			= "";
 	//Call a dynamic jsp and set the value in the bean
	var clin_cmts_value_entered_yn;
	if(retValue!=null)
 	{
		retValArr					= retValue.split("||");
		retVal						= retValArr[1];
		clin_cmts_value_entered_yn  = retValArr[0]; // Willbe always Y		
 		// Set it in the hidden variable
		//--[101]--/start---
		for (u=0;u<inputArr.length;u++){
			if (inputArr[u].name == field_name){
				inputArr[u].value = ''+encodeURIComponent(retVal)+'';
			}  // End of if
		} 
		if(order_category==null || order_category=="")		// Only for Preview
		{
			for (u=0;u<lineInputArr.length;u++){
				if (field_name== "header_comments"){ // Header comments name
					if(lineInputArr[u].name.indexOf("hdr_care_set_order_category")!=-1) // for all header comments it will be clinical_comments+order_category
					{
						order_cat += lineInputArr[u].value+",";	
					} 
				} // End of if clinical_comments
			} // End of for	
		}
		parent.criteriaMainFrame.document.placeOrderHeaderForm.header_comments.value =encodeURIComponent(retVal);
		//--[101]--/end---
 		//document.placeOrderHeaderForm.header_comments.value = retVal; 
		//Added By by channaveer B fOR Issue ICN24842 and ICN25262 on 29/11/2010
		if(parent.placeOrderDetailFrame.document.placeOrderForm)
		parent.placeOrderDetailFrame.document.placeOrderForm.header_comments.value = encodeURIComponent(retVal);
		var bean_id 	= document.placeOrderHeaderForm.bean_id.value ;
		var bean_name 	= document.placeOrderHeaderForm.bean_name.value ;
		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();

		xmlStr			= "<root><SEARCH " ;
		//xmlStr 			+= obj.name +"=\""+ checkSpl(obj.value) +"\" " ;
		xmlStr 			+= field_name+"=\""+ checkSpl(retVal) +"\" " ;//--[101]--Modified
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&order_category="+order_category+"&field_name="+field_name+"&func_mode=Amend_Clinical_Comments"+"&localeName="+localeName, false ) ;//--[101]--Modified
		xmlHttp.send( xmlDoc );
		responseText	= xmlHttp.responseText ;
		eval( responseText );
		
		}
	else 
		clin_cmts_value_entered_yn = "N";
		// TO check the mandatory or not 
		parent.criteriaMainFrame.document.placeOrderHeaderForm.clin_cmts_value_entered_yn.value = clin_cmts_value_entered_yn;
	parent.criteriaMainFrame.document.placeOrderHeaderForm.header_comments.value = decodeURIComponent(parent.criteriaMainFrame.document.placeOrderHeaderForm.header_comments.value); //--[IN029202]--
} // End of DisplayAmendComments

function doAmendClose(flg)
{

	var clin_cmts_reqd_yn	= "N";
	var clin_category_comments_reqd_yn = "N";
	 //--[IN00747]-- Start	
	/* if(flg =="Y"){
	 if(document.getElementById("clin_cmts_reqd_yn"))
		clin_cmts_reqd_yn = document.getElementById("clin_cmts_reqd_yn").value;

	}else{
	 
	if(document.getElementById("clin_category_comments_reqd_yn").value != "undefined"){
		clin_category_comments_reqd_yn = document.getElementById("clin_category_comments_reqd_yn").value;
		}
	//--[IN00747]--  End
	else */
	if(document.getElementById("clin_cmts_reqd_yn"))
		clin_cmts_reqd_yn = document.getElementById("clin_cmts_reqd_yn").value;
	//}	
	//if((clin_cmts_reqd_yn=="Y" || clin_category_comments_reqd_yn=="Y")&& trimCheck(document.getElementById("comments").value)=="")//Modifed --[IN00747]
		if((clin_cmts_reqd_yn=="Y")&& trimCheck(document.getElementById("comments").value)=="")//Modifed --[IN00747]
		{
		//commentSetValue("comments","N");
		window.returnValue = "N"+"||"+document.getElementById("comments").value;
		alert(getMessage("CLINICAL_COMMENTS_BLANK","OR"))
		return;
		}
		else 
		{
		//commentSetValue("comments","Y");
		if(document.getElementById("comments").value=="")		//[IN032614]
			document.getElementById("comments").value=" ";	//[IN032614]
		window.returnValue = "Y"+"||"+document.getElementById("comments").value; // since comments is entered//
		window.close();
		
		//parent.document.querySelectorAll("#dialog-body")[parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = "Y";
		//parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();
   
		}

} // End of doAmendClose
function makeValidString1(obj)
{
	if((trimString(obj.value)==null)||(trimString(obj.value)==""))
	{		
		obj.value=document.getElementById("commentsadd").value;
		makeValidString(obj);
	}
	else
	{
		makeValidString(obj);		
	}
}

function checkMaxLimitLocal(obj,maxSize){

		if ( obj.value.length >= maxSize )
		{
			event.returnValue = false;
		}
}


function doAmendCloseClinic()
{

	var clin_cmts_reqd_yn	= "N";
	if(document.getElementById("clin_cmts_reqd_yn"))
		clin_cmts_reqd_yn = document.getElementById("clin_cmts_reqd_yn").value;
	if(clin_cmts_reqd_yn=="Y" && trimCheck(document.getElementById("comments").value)=="")
	{
		//commentSetValue("comments","N");
		window.returnValue = "Y"+"||"+document.getElementById("comments").value;
		alert(getMessage("CLINICAL_COMMENTS_BLANK","OR"))
		return;
	}else {
		//commentSetValue("comments","Y");
		if(document.getElementById("comments").value=="")			//[IN032614]
			document.getElementById("comments").value=" ";		//[IN032614]
		window.returnValue = "Y"+"||"+document.getElementById("comments").value; // since comments is entered
		window.close();
/**let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "Y"+"||"+document.getElementById("comments").value;
    
    const dialogTag =parent.document.getElementById("dialog_tag");    
    dialogTag.close();  */
	}

}
function doAmendonClose(flg)
{

	var clin_cmts_reqd_yn	= "N";
	var clin_category_comments_reqd_yn = "N";
	 //--[IN00747]-- Start	
	 
	/* if(flg =="Y"){
	if(document.getElementById("clin_cmts_reqd_yn"))
		clin_cmts_reqd_yn = document.getElementById("clin_cmts_reqd_yn").value;
	}else{
	 
	if(document.getElementById("clin_category_comments_reqd_yn").value != "undefined"){
		clin_category_comments_reqd_yn = document.getElementById("clin_category_comments_reqd_yn").value;
		}
	//--[IN00747]--  End
	else */
	if(document.getElementById("clin_cmts_reqd_yn"))
		clin_cmts_reqd_yn = document.getElementById("clin_cmts_reqd_yn").value;
	//}	
	//if((clin_cmts_reqd_yn=="Y" || clin_category_comments_reqd_yn=="Y")&& trimCheck(document.getElementById("comments").value)=="")//Modifed --[IN00747]
	if((clin_cmts_reqd_yn=="Y")&& trimCheck(document.getElementById("comments").value)=="")
	{
		//commentSetValue("comments","N");
		window.returnValue = "N"+"||"+document.getElementById("comments").value;
		alert(getMessage("CLINICAL_COMMENTS_BLANK","OR"))
		return;
	}else {
		//commentSetValue("comments","Y");
		if(document.getElementById("comments").value=="")			//[IN032614]
			document.getElementById("comments").value=" ";		//[IN032614]
		//window.returnValue = "Y"+"||"+document.getElementById("comments").value; // since comments is entered
		//window.close();
let dialogBody =parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "Y"+"||"+document.getElementById("comments").value;
    
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
	}

} // End of doAmendonClose




 // For the population of the order type in the image tab
 // To populate the order_type in the tick sheets
 function populateImageOrderType(obj)
 {
 	if( obj.value == "" )
 	{
		if(document.imageForm)
	 	    document.imageForm.reset();
 	}
 	else
 	{
 		var bean_id 			= document.imageSearchForm.bean_id.value ;
 		var bean_name 			= document.imageSearchForm.bean_name.value ;
		var localeName			= document.imageSearchForm.localeName.value;
 		var order_category_yn 	= document.imageSearchForm.order_category_yn.value;
 		var order_type_yn 		= document.imageSearchForm.order_type_yn.value;

 		var xmlDoc = "";
 	var xmlHttp = new XMLHttpRequest();
 		xmlStr					= "<root><SEARCH " ;
 		xmlStr 					+= obj.name+"=\""+ obj.value +"\" " ;
 		xmlStr 					+=" /></root>" ;
 		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
 		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&order_type_yn="+order_type_yn+"&func_mode=IMAGE_ORDER_TYPE_POPULATE&localeName="+localeName, false ) ;
 		xmlHttp.send( xmlDoc ) ;
 		responseText=xmlHttp.responseText ;
 		eval( responseText ) ;
 	}
 	imageSearch(); // Call the search to load the image
} // End of populateImageOrderType

// on click of the hot spot or hyperlink,
function populatePanels(image_id,hotspot_id)
{
	order_type_code = document.image_form.order_type_code.value;
	order_category  = document.image_form.order_category.value;
	activity_type	= document.image_form.activity_type.value;
 	bean_id	 		= document.image_form.bean_id.value;
	bean_name  		= document.image_form.bean_name.value;
	/*Added by Uma on 8/24/2009 for PMG0089 CRF-641*/
	var priv_applicability_yn = "";
	if(parent.displayTransaction.imageOrderCategory.imageSearchForm.ApplicableCatalogs)
	{
		priv_applicability_yn = parent.displayTransaction.imageOrderCategory.imageSearchForm.ApplicableCatalogs.value;
	}
	/*Modified by Uma on 8/24/2009 for PMG0089 CRF-641 added Applicability_yn*/
	// Call the bean  to store the values if any checkbox has been checked or unchecked
	storeValues(document.imagePanelsForm,"image_form"); // When already panels are there again he is clicking search
	parent.displayTransaction.imageOrderCatalogs.document.location.href="../../eOR/jsp/OrderEntryImagePanels.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&order_type_code="+escape(order_type_code)+"&order_category="+escape(order_category)+"&activity_type="+escape(activity_type)+"&image_id="+escape(image_id)+"&hotspot_id="+escape(hotspot_id)+"&priv_applicability_yn="+priv_applicability_yn;
	// Enabled the Order Category and the Order Type  based upon the conditions for the presel select
	if(parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_category_yn.value == "Y" && parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_type_yn.value == "Y")
	{
		parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_category.disabled 	= true;
		parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_type.disabled 		= true;
	}
	else if(parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_category_yn.value =="N" && parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_type_yn.value =="N")
	{
		parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_category.disabled 	= false;
		parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_category.disabled 	= false;
	}
	else
	{
		parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_category.disabled 	= true;
		parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_type.disabled 		= false;
	}

	if(parent.displayTransaction.imageOrderCategory.document.imageSearchForm.ammend_called_from.value=="existing_order")
		parent.displayTransaction.imageOrderCategory.document.imageSearchForm.order_category.disabled=true;
} // End of populatePanels

// On click of the radio buttons
function changeImage(obj)
{
	var order_type_code 	= document.image_form.order_type_code.value;
	var order_category  	= document.image_form.order_category.value;
	var activity_type	  	= document.image_form.activity_type.value;
 	var bean_id				= document.image_form.bean_id.value;
	var bean_name  			= document.image_form.bean_name.value;
	/*Added by Uma on 8/24/2009 for PMG0089 CRF-641*/
	var priv_applicability_yn = "";
	if(parent.displayTransaction.imageOrderCategory.imageSearchForm.ApplicableCatalogs)
		priv_applicability_yn = parent.displayTransaction.imageOrderCategory.imageSearchForm.ApplicableCatalogs.value;
	/*Modified by Uma on 8/24/2009 for PMG0089 CRF-641 added Applicability_yn*/
	var query_string 		= "bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&order_type_code="+escape(order_type_code)+"&order_category="+escape(order_category)+"&activity_type="+escape(activity_type)+"&priv_applicable_yn="+priv_applicability_yn;
	// Call the bean  to store the values
	//storeCheckedValues("imagePanelsForm","NO");
	storeValues(document.imagePanelsForm,"image_form"); // When already panels are there again he is clicking search
	// Make the Panel Frame as blank
	parent.displayTransaction.imageOrderCatalogs.location.href="../../eCommon/html/blank.html";
	var image_id = "";
	var image_link_id = "";
	var image_url = "";

 	if(obj.value!="" && obj.name == "image") {

		value = obj.value.split("||");
		image_id		= value[0];
		image_link_id	= value[1];
		image_url		= value[2];
  		document.location.href		="../../eOR/jsp/OrderEntryImageTransaction.jsp?image_id="+escape(image_id)+"&image_link_id="+escape(image_link_id)+"&image_url="+escape(image_url)+"&"+query_string
	}else{

		if(obj.name == "front"){
			image_id		= order_category+"FRNT";
			image_link_id	= "";
			image_url		= "skeleton_front.gif";
		}else if(obj.name == "back"){
			image_id		= order_category+"BACK";
			image_link_id	= "";
			image_url		= "skeleton_back.gif";
		}
		if(order_category == "")
			image_id = "";
		document.location.href		="../../eOR/jsp/OrderEntryImageTransaction.jsp?image_id="+escape(image_id)+"&image_link_id="+escape(image_link_id)+"&image_url="+escape(image_url)+"&"+query_string
		
	}
 	/*if(obj.name == "front")
	{
		document.getElementById("back").checked	= false;
		document.getElementById("front").checked	= true;

		document.getElementById("tb1").background	="../../eOR/images/skeleton_front.gif"
		document.location.href		="../../eOR/jsp/OrderEntryImageTransaction.jsp?image_position=FRNT"+query_string
	}
	else
	{
		document.getElementById("back").checked	= true;
		document.getElementById("front").checked	= false;

		document.getElementById("tb1").background	="../../eOR/images/skeleton_back.gif"
		document.location.href		="../../eOR/jsp/OrderEntryImageTransaction.jsp?image_position=BACK&"+query_string
	}*/
} //End of changeImage

// on change of the order_type or order_category or on load of the form for Image search
function imageSearch()
{
	var order_category_yn	= document.imageSearchForm.order_category_yn.value;
	var order_type_yn  		= document.imageSearchForm.order_type_yn.value;
	var result = true;
	if(order_category_yn=="Y" && order_type_yn=="Y")
	{
		if(document.imageSearchForm.order_type.value=="")
		{
			result = false;
			alert(getMessage("ORDER_TYPE","OR"));
		}
	}
	if(result)
	{
		var order_type_code 	= document.imageSearchForm.order_type.value;
		var order_category  	= document.imageSearchForm.order_category.value;
		var activity_type	  	= document.imageSearchForm.activity_type.value;
		var bean_id				= document.imageSearchForm.bean_id.value;
		var bean_name  			= document.imageSearchForm.bean_name.value;
		/*Added by Uma on 8/24/2009 for PMG0089 CRF-641*/
		var Applicability_yn = ""; 
		if(document.imageSearchForm.ApplicableCatalogs)
		{
			Applicability_yn = document.imageSearchForm.ApplicableCatalogs.value;
		}
		/*Modified by Uma on 8/24/2009 for PMG0089 CRF-641 added Applicability_yn*/
		storeValues(document.imagePanelsForm,"imagePanelsForm"); // When already panels are there again he is clicking search
		parent.imageOrderCatalogs.location.href		= "../../eCommon/html/blank.html";
		parent.parent.displayImage.location.href 	= "OrderEntryImageTransaction.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&order_category="+order_category+"&order_type_code="+order_type_code+"&activity_type="+activity_type+"&order_category_yn="+order_category_yn+"&order_type_yn="+order_type_yn+"&priv_applicable_yn="+Applicability_yn;
	}
} // End of imageSearch

 // In the Care Set Button, on change of the order_category to populate the order_type and care sets
 // To populate the Order Type List box, based upon the order - category in addn'. search
function populateOrderTypeCareSet( obj ) 
{
	document.careSetSearchForm.diagnosis.value 			= "";
	document.careSetSearchForm.orderable_text.value 	= "";
	document.careSetSearchForm.orderable_text_id.value 	= "";
	var localeName          = document.careSetSearchForm.localeName.value;
 	var bean_id 			= document.careSetSearchForm.bean_id.value ;
	var bean_name 			= document.careSetSearchForm.bean_name.value ;
	var order_category_yn 	= document.careSetSearchForm.order_category_yn.value;
	var order_type_yn	 	= document.careSetSearchForm.order_type_yn.value;
 	var order_type_code	 	= document.careSetSearchForm.order_type.value;
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
	//IN061906 starts 
	clearCareSetList('document','document.careSetSearchForm') ;  
	if(order_category_yn=='Y' && obj.value!='' || order_category_yn!='Y') 
	{//IN061906 ends	
	xmlStr					= "<root><SEARCH " ;
	xmlStr 					+= obj.name+"=\""+ obj.value +"\" " ;		//order_category
 	xmlStr 					+= "order_type_code=\""+ order_type_code +"\" " ;
 	xmlStr 					+=" /></root>" ;

 	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&order_category_yn="+order_category_yn+"&order_type_yn="+order_type_yn+"&func_mode=CARE_SET_ORDER_TYPE_POPULATE&localeName="+localeName, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	}//IN061906
} // End of populateOrderTypeCareSet

// Populate the care set 
function populateActivityCareSet(obj){
	clearCareSetList( "document","document.careSetSearchForm")
	var localeName          = document.careSetSearchForm.localeName.value;
 	var bean_id 			= document.careSetSearchForm.bean_id.value ;
	var bean_name 			= document.careSetSearchForm.bean_name.value ;
   	var order_category	 	= document.careSetSearchForm.order_category.value;
	var orderable_text_id	= document.careSetSearchForm.orderable_text_id.value;
	var order_type_code		= document.careSetSearchForm.order_type.value;
 	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr					= "<root><SEARCH " ;
	xmlStr 					+= "activity_type=\""+ obj.value +"\" " ;		//order_category
 	xmlStr 					+= "order_category=\""+ order_category +"\" " ;
 	xmlStr 					+= "orderable_text_id=\""+ orderable_text_id +"\" " ;
 	xmlStr 					+= "order_type_code=\""+ order_type_code +"\" " ;
	xmlStr 					+=" /></root>" ;
 	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=CARE_SET_POPULATE&localeName="+localeName, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
} // End of populateActivityCareSet

// To clear the care set list box
// To clear the list box
function clearCareSetList( docObj,form_name ) {
	var len = eval(form_name+".care_sets.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(form_name+".care_sets.remove(\"care_sets\")") ;
	}
	var tp 		= " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt  	= eval(docObj+".createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	eval(form_name+".care_sets.add(opt)") ;
	parent.criteriaDetailFrame.location.href="../../eCommon/html/blank.html"; //IN061906
	parent.criteriaButtonFrame.location.href="../../eCommon/html/blank.html"; //IN065705
} // End of clearCareSetList
/*IN065705 starts*/
function clearCategoryList(form_name){
	eval(form_name+".order_category.options(0).selected=true;");
}
/*IN065705 ends*/
// To add in the List box  Care Sets
function addCareSetList(form_name,code,value,obj) {
	object_name 		= eval(form_name+".temp_care_set_val");
	val 				= object_name.value;

	var element 		= document.createElement('OPTION') ;
	element.value 		= code ;
	element.text 		= value ;
	// Split and get the care_sets and Order_category
	care_set_code		= code.split("::");
	// Add the  List Box Values
	if(care_set_code[0]==val)    // If it is equal to the code, store it in a JS variable (Global to this file)
		care_set_value = code;
	object_name 		= eval(form_name+".care_sets");
	object_name.add(element);
	// Store the Order Category and the care sets
	object_name 		= eval(form_name+".care_set_val");
	object_name.value 	= care_set_code[0]; // Store the Care sets
	// If there are more categories, then also it will be same.
	object_name 		= eval(form_name+".care_set_order_category");
	object_name.value 	= care_set_code[1]; // Store the Order Category for the Order Set selected in a Hidden Field
} // End of addCareSetList

// To default the care set value in the list box
function DefaultCareSetList(form_name) {
	// Global variable in this JS
	var len = eval(form_name+".care_sets.options.length") ;
	for(var i=0;i<len;i++)
	{
		value = eval(form_name+".care_sets.options[i].value")
		if(care_set_value==value)
			eval(form_name+".care_sets.options[i].selected=true;")
	}
	/*IN061906 starts( populate data if order set has only one value)*/
	if(len==2){
		eval(form_name+".care_sets.options[1].selected=true;"); 
		careSetSearch();
	}/*IN061906 ends */
} // End of DefaultCareSetList
// On change of the diagnosis to populate the CareSets
function populateCareSet( obj ) {
	var bean_id 			= document.careSetSearchForm.bean_id.value ;
	var bean_name 			= document.careSetSearchForm.bean_name.value ;
	var activity_type		= document.careSetSearchForm.activity_type.value ;
	var order_type_code		= document.careSetSearchForm.order_type.value ;
	var diag_code_scheme	= document.careSetSearchForm.diag_code_scheme.value ;
	var localeName          = document.careSetSearchForm.localeName.value;

	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();

	xmlStr					= "<root><SEARCH " ;
	xmlStr 					+= obj.name+"=\""+ obj.value +"\" " ;
	xmlStr 					+= "activity_type=\""+activity_type +"\" " ;
	xmlStr 					+= "diag_code_scheme=\""+diag_code_scheme +"\" " ;
	xmlStr 					+= "order_type_code=\""+order_type_code +"\" " ;
	xmlStr 					+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=CARE_SET_POPULATE&localeName="+localeName, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
} // End of populateCareSet

// On click of the button in the Care sets
async function showDiagnosis(obj,scheme,scheme_code)
{
//	alert("dia");
	if(document.careSetSearchForm.diagnosis.value=="P")
	{
		var dataNameArray 		= new Array() ;
		var dataValueArray 		= new Array() ;
		var dataTypeArray 		= new Array() ;

			dataNameArray[0]	= "a.patient_id" ;
			dataValueArray[0]	=  document.careSetSearchForm.patient_id.value;
			dataTypeArray[0]	= STRING ;
			dataNameArray[1]	= "B.TERM_SET_ID" ;
			dataValueArray[1]	=  document.careSetSearchForm.diag_code_scheme.value;
			dataTypeArray[1]	= STRING ;
			var sql_query			= document.careSetSearchForm.sql_or_order_entry_diagnosis.value;
			//var sql_query			= "select A.TERM_CODE code, B.short_desc  description from pr_diagnosis A, mr_term_code b where a.patient_id like ? AND  A.CURR_STATUS='A'   AND B.TERM_SET_ID like upper(?)  AND B.TERM_CODE=A.TERM_CODE and upper(A.TERM_CODE) like upper(?) and upper(B.short_desc) like upper(?)";
		
			var argumentArray 		= new Array() ;
			argumentArray[0] 	= sql_query;
			argumentArray[1]   	= dataNameArray ;
			argumentArray[2]   	= dataValueArray ;
			argumentArray[3]   	= dataTypeArray ;
			argumentArray[4]   	= "3,4";
			argumentArray[5]   	= document.careSetSearchForm.orderable_text.value ; //Target
			argumentArray[6]   	= CODE_LINK; // DESC_LINK ;
  			argumentArray[7]   	= CODE_DESC ; // DESC_CODE display part
  			var title 			= getLabel("Common.diagnosis.label","Common");
  			retVal 				=await CommonLookup(title,argumentArray);
			var ret1=unescape(retVal);
	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal!=null && retVal!='')
			{
				document.careSetSearchForm.orderable_text.value 	 = arr[1] ;
				document.careSetSearchForm.orderable_text_id.value	 = arr[0];
			}
	}/* else if(document.careSetSearchForm.diagnosis.value=="D")
	{
		var argumentArray  = new Array() ;
    	var dataNameArray  = new Array() ;
    	var dataValueArray = new Array() ;
    	var dataTypeArray  = new Array() ;



    	argumentArray[0]   = document.careSetSearchForm.sql_or_order_entry_pat_diagnosis.value;
    	argumentArray[1]   = dataNameArray ;
    	argumentArray[2]   = dataValueArray ;
    	argumentArray[3]   = dataTypeArray ;
    	argumentArray[4]   = "1,2";
    	//argumentArray[5]   = target.value ;
    	argumentArray[5]   = "" ;
    	argumentArray[6]   = CODE_LINK ;
    	argumentArray[7]   = CODE_DESC ;


    	retVal = await CommonLookup( getLabel("eOR.PatientDiagnosis.label","OR"),argumentArray );

    	if(retVal != null && retVal != ""){
           document.careSetSearchForm.orderable_text_id.value=retVal[0];
    	   document.careSetSearchForm.orderable_text.value=retVal[1];
        }


	}*/
	else if(document.careSetSearchForm.diagnosis.value=="A")  // When the diagnosis selected is ALL
	{
		var scheme="";
		var scheme_desc = document.careSetSearchForm.diag_code_scheme.value;
	
		if(scheme_desc=="ICD10")
		{
			scheme=1;
		}
		else
		{
			scheme=2;
		}
		var Encounter_Id= document.careSetSearchForm.encounter_id.value;
		var practitioner_id= document.careSetSearchForm.practitioner_id.value;
		function_id="ca_diagnosis";
		var p_auth_yn="N";

		if (scheme == 5)
		{
			var retVal = "test Value";
			var dialogHeight= "37.5" ;
			var dialogWidth = "50" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
			var arguments   = "" ;
			retVal = await window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);

			var arr = new Array();
			arr = retVal.split("|");
			var stra = arr[0];
			var strc = arr[1];
			var strb = arr[2];
	
		}

		if (scheme == 1 || scheme == 2)
		{
			var retVal =    new String();
			var dialogHeight= "37.5" ;
			var dialogWidth = "50" ;
			var status = "no";

			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
			retVal = await window.showModalDialog("../../eMR/jsp/PaintConsultationFrame.jsp?title="+scheme_desc+"&CodeList&p_diag_code="+scheme+"&term_set_id="+scheme_desc+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&function_id="+function_id+"&practitioner_id="+practitioner_id+"&cause_indicator=",arguments,features);
			if (!(retVal == null))
			{
				var retdata;
				if(scheme=="2")
				{
					retdata	= retVal.split("/") ;
					retVal	= retdata[0];
				}

				document.careSetSearchForm.orderable_text_id.value=retVal;
				var bean_id 			= document.careSetSearchForm.bean_id.value ;
				var bean_name 			= document.careSetSearchForm.bean_name.value ;
				var  xmlAppend = "";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlStr ="<root><SEARCH " ;
				xmlStr =xmlStr + xmlAppend ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&term_code="+retVal+"&func_mode=TERMDESC",false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval(responseText ) ;

			}
		}
	}

	if(document.careSetSearchForm.orderable_text_id.value!='')
	{
		clearCareSetList("document","document.careSetSearchForm");
		populateCareSet(document.careSetSearchForm.orderable_text_id);
	}
} // End of showDiagnosis

async function show_notes_window(){
    if(getHandleDetailLower()) {
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0]   = detailLowerForm.notes_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	//argumentArray[5]   = target.value ;
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( getLabel("Common.notes.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){
       detailLowerForm.discr_msr_panel_id.value=arr[0];
	   detailLowerForm.discr_msr_panel_id_desc.value=arr[1];
    } // End of retVal
   }
} // End of show_notes_window

// Set the Diagnosis Desc
function addCareSetDiagnosisDesc(form_name,diag_desc)
{
	eval(form_name+".orderable_text.value=diag_desc");
} // End of addCareSetDiagnosisDesc

// on change of the diagnosis clear the orderable and care sets
function clearOrderable(obj)
{
		document.careSetSearchForm.orderable_text.value 	 = "";
		document.careSetSearchForm.orderable_text_id.value	 = "";
		if(obj.value=="")
			populateCareSet(document.careSetSearchForm.orderable_text_id)
} // End of clearOrderable

// Used for the Clear Button in the care set search screen
function clearCareSetSearch()  // on click of the clear button in the care set
{
	if(!document.careSetSearchForm.order_category.disabled)
	{
		document.careSetSearchForm.order_category.disabled 	= false;
		document.careSetSearchForm.order_category.value	   	= "";
	}
	if(!document.careSetSearchForm.order_type.disabled)
	{
		document.careSetSearchForm.order_type.disabled 		= false;
		document.careSetSearchForm.order_type.value	   		= "";
	}
	if(!document.careSetSearchForm.diagnosis.disabled)
		document.careSetSearchForm.diagnosis.value	  		= "";

	if(document.careSetSearchForm.order_type_mand)
		document.careSetSearchForm.order_type_mand.style.visibility = "hidden";
 	document.careSetSearchForm.orderable_text.value	  		= "";
	document.careSetSearchForm.orderable_text_id.value	  	= "";
	if(!document.careSetSearchForm.care_sets.disabled)
		document.careSetSearchForm.care_sets.value	  		= "";
	time_frame	 											= document.careSetSearchForm.time_frame;
	time_frame[1].checked									= true
	parent.criteriaMainFrame.location.reload();
	populateOrderTypeCareSet(document.careSetSearchForm.order_category)
	if(parent.criteriaDetailFrame)
		parent.criteriaDetailFrame.location.href = "../../eCommon/html/blank.html"
	if(parent.criteriaButtonFrame)
		parent.criteriaButtonFrame.location.href = "../../eCommon/html/blank.html"
} // End of clearCareSetSearch

// When search button is clicked in the care set search screen
function careSetSearch()
{
	var result = true;
	var practitioner_type = "";//IN042045
	care_set_order_category = document.careSetSearchForm.care_set_order_category.value;
	//Check if presel_order_category is "Y" and order_category not selected , then give an alert
	/*IN061906 starts*/
	 if(document.careSetSearchForm.diagnosis.value!= "" && document.careSetSearchForm.order_category_yn.value=='Y' && document.careSetSearchForm.order_category.value== ""){
		result = true;
	}/*IN061906 ends*/
	else if(document.careSetSearchForm.order_category_yn.value=='Y' && document.careSetSearchForm.order_category.value== "")
	{
			result = false;
			alert(getMessage('ORDER_CATEGORY','OR'));
	}
	else if (document.careSetSearchForm.order_type_yn.value =="Y" && document.careSetSearchForm.order_type.value=="")
	{
			result = false;
			alert(getMessage('ORDER_TYPE','OR'));
	}

	if(result)
	{
		if(document.careSetSearchForm.care_sets.value!="") // List Box val
		{
			bean_id		 		= document.careSetSearchForm.bean_id.value
			bean_name	 		= document.careSetSearchForm.bean_name.value
			patient_id			= document.careSetSearchForm.patient_id.value
			encounter_id		= document.careSetSearchForm.encounter_id.value
			care_sets			= document.careSetSearchForm.care_set_val.value
			time_frame	 		= document.careSetSearchForm.time_frame;
			facility_id	 		= document.careSetSearchForm.facility_id.value;
			patient_class	 	= document.careSetSearchForm.patient_class.value;
			admission_date	 	= document.careSetSearchForm.admission_date.value;
			discharge_date_time	= document.careSetSearchForm.discharge_date_time.value;
			practitioner_type	= document.careSetSearchForm.practitioner_type.value;//IN042045
			function_from	= document.careSetSearchForm.function_from.value;
			if(time_frame[0].checked==true)
				time_frame		= "T";
			else if(time_frame[1].checked==true)
				time_frame		= "C";
			else if(time_frame[2].checked==true)
				time_frame		= "M";
			var query_string	= "";
			//Modified by Uma on 2/22/2010 for IN017231*/ //IN042045 included practitioner_type 
			query_string		= "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&care_sets="+care_sets+"&time_frame="+time_frame+"&order_category="+care_set_order_category+"&facility_id="+facility_id+"&patient_class="+patient_class+"&admission_date="+admission_date+"&discharge_date_time="+discharge_date_time+"&function_from="+function_from+"&practitioner_type="+practitioner_type;
			/*Ends Here*/
      //IN064543 start
			var enbDis = validateInstrn();
			enbDis=trimString(enbDis);
			if(enbDis == 'ENABLE'){
				query_string= query_string+"&enbDis="+enbDis;
			}
      //IN064543 end
			parent.criteriaButtonFrame.location.href = "../../eOR/jsp/OrderEntryCareSetButton.jsp?"+query_string;
			parent.criteriaDetailFrame.location.href = "../../eOR/jsp/OrderEntryCareSetMatrix.jsp?"+query_string;
		}
		else
			alert(getMessage("ORDER_SET_BLANK","OR"));
	} // End of if result
} // End of careSetSearch
//IN064543 start
function validateInstrn(){
	care_sets			= document.careSetSearchForm.care_set_val.value
	var xmlDoc = ""; 
var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"VALIDATE_ORDERSET_TAB\" " ;
	xmlStr += " care_sets=\""+ care_sets +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IntermediateForInstructions.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	return responseText;
}
async function openInstructionModalForOrderSet(care_sets,order_catalog_nature,order_category,bean_id,bean_name,encounterid,patientclass,admission_date,discharge_date_time,practitioner_type){
	var finalString 	= "measure_id="+care_sets+"&order_catalog_nature="+order_catalog_nature+"&category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&encounter_id="+encounterid+"&patient_class="+patientclass+"&admission_date="+admission_date+"&discharge_date_time="+discharge_date_time+"&pract_type="+practitioner_type+"&Instrn_flag=Y";
	var retVal 			= new String();
	var dialogHeight 	= "35" ;
	var dialogWidth  	= "63" ;
	var dialogTop    	= "300";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=no; status:no";
	retVal = await window.showModalDialog("../../eOR/jsp/OrderEntryToolTipFrameSet.jsp?"+finalString,arguments,features);
}
//IN064543 end
function setCareSet()
{
	if(document.careSetButtonForm.care_set_check_box_val.value=="Y")
	{
			alert(getMessage("ORDER_SET_SELECTED","OR"));
	}
	else
	{
		// Set the value(catalog_codes) into the bean
		document.careSetButtonForm.check_box_val.value 			= "Y";
		// Store it in a Js Global Variable // Ck to represent the checkbox, which is the same way used to put it in the bean
		check_box_length 	= parent.parent.tabFrame.check_box_val.length;//Global Variable in OrderEntryTab.jsp
		// Get the Length of the Array of the variable and set the code to it
		parent.parent.tabFrame.check_box_val[check_box_length] = "ck"+parent.criteriaMainFrame.document.careSetSearchForm.care_set_val.value // Store it in a JS Global Variable (OrderEntryTab.jsp)
		storeValues(parent.criteriaButtonFrame.document.careSetButtonForm,"careSetButtonForm");
		document.careSetButtonForm.care_set_check_box_val.value = "Y";
		//change_tab(document.careSetButtonForm.);
		patient_id 			= parent.criteriaMainFrame.document.careSetSearchForm.patient_id.value; //From the Search Critiera screen
		encounter_id 		= parent.criteriaMainFrame.document.careSetSearchForm.encounter_id.value;
		bean_id 			= parent.criteriaMainFrame.document.careSetSearchForm.bean_id.value;
		bean_name 			= parent.criteriaMainFrame.document.careSetSearchForm.bean_name.value;
		function_from 			= parent.criteriaButtonFrame.document.careSetButtonForm.function_from.value;
		time_frame 			= parent.criteriaMainFrame.document.careSetSearchForm.time_frame;
		//[IN036868] Start.
		var deceased_yn = parent.criteriaMainFrame.document.careSetSearchForm.deceased_yn.value;
		var medico_legal_yn = parent.criteriaMainFrame.document.careSetSearchForm.medico_legal_yn.value;
		var postmortem_status = parent.criteriaMainFrame.document.careSetSearchForm.postmortem_status.value;
		var body_part_yn = parent.criteriaMainFrame.document.careSetSearchForm.body_part_yn.value;
		var registration_no = parent.criteriaMainFrame.document.careSetSearchForm.registration_no.value;
		//[IN036868] End.
		if(time_frame[0].checked==true)
			time_frame		= "T";
		else if(time_frame[1].checked==true)
			time_frame		= "C";
		else if(time_frame[2].checked==true)
			time_frame		= "M";
		ammend_called_from 	= parent.criteriaMainFrame.careSetSearchForm.ammend_called_from.value;
		query_string		= "&patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&ammend_called_from="+ammend_called_from+"&time_frame="+time_frame+"&function_from="+function_from;
		query_string		= query_string+"&deceased_yn="+deceased_yn+"&medico_legal_yn="+medico_legal_yn+"&postmortem_status="+postmortem_status+"&body_part_yn="+body_part_yn+"&registration_no="+registration_no;   //[IN036868]
		parent.parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryFrameSet.jsp?tab_name=PlaceOrder"+query_string;
		// Changing the COLOR of the tab in the Tab Frame(OrderEntryTab) for the OrderSets button and Place Order button
		parent.parent.tabFrame.document.getElementById("tab").rows[0].cells[3].className="CAFIRSTSELECTHORZ"
		parent.parent.tabFrame.document.getElementById("tab").rows[0].cells[4].className="CASECONDSELECTHORZ"
		// Till here
	}
} // End of setCareSet

// On Click of the Cmts in the header(in Place Order Tab) and the other comments
// like line cmts,preps, pat instrns, dept instrns ,etc
async function DisplayComments(name,hdg_name)
{

	var comments;
	var inputArr 			= document.getElementsByTagName("input");
	for (u=0;u<inputArr.length;u++){
		if (inputArr[u].name == name){
			comments 			= inputArr[u].value;
		}
	}
	var retVal;
	var dialogHeight;
	dialogHeight 		= '12' ;
	var dialogWidth 	= '30' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;
	if(comments == "" || comments == "null")   comments 			="";
	arguments 				= comments ;
	retVal 					=await  window.showModalDialog("../../eOR/jsp/OrderEntryComments.jsp?hdg_name="+hdg_name,arguments,features);
	for (u=0;u<inputArr.length;u++){
		if (inputArr[u].name == name){
			inputArr[u].value = ''+retVal+'';
		}
	}
} // End of Display Comments

//If the Order Format in the line level is mandatory, the legends to be changed in the Button Frame
 function setFormatLegends(format_mandatory_count,format_count){	
 	if(parent.criteriaDetailFrame.document.getElementById('hdr_format_mandatory_count')!=null)
 		hdr_format_mandatory_count = parent.criteriaDetailFrame.document.getElementById('hdr_format_mandatory_count').value
 	if(parent.criteriaDetailFrame.document.getElementById('hdr_format_count')!=null)
 		order_format = parent.criteriaDetailFrame.document.getElementById('hdr_format_count').value
	
 	//Commented by Jerome since this chk is to display the legend at the line level.. hdr mandatory chk is not required to be considered.
	//if(parseInt(format_mandatory_count) > 0 || (parseInt(hdr_format_mandatory_count) > 0))
	
 	if(parseInt(format_mandatory_count) > 0)
 	{		
	 	parent.criteriaDetailFrame.document.getElementById('line_level_mandatory_yn').value	= "Y";
	  	parent.criteriaDetailFrame.document.getElementById('order_mandatory').innerHTML	= "<a class='gridLink' href='javascript:parent.parent.orderFormatForLineLevel()'><img src='../../eOR/images/Flex_red.gif' align='center'></a>"+getLabel("eOR.AddlInfo(Mandatory).label","OR");
	}
	else	
		parent.criteriaDetailFrame.document.getElementById('order_mandatory').innerHTML	= "<a class='gridLink' href='javascript:parent.parent.orderFormatForLineLevel()'><img src='../../eOR/images/Flex_blue.gif' align='center'></a>"+getLabel("eOR.AddlInfo(Optional).label","OR");
	//parent.criteriaDetailFrame.document.buttonForm.all.order_mandatory.innerHTML	= "<a href='javascript:dummy()'><img src='../../eOR/images/Flex_red.gif' align='center'></a>&nbsp;Addl. Info. (Mandatory)"
 	//else if((parseInt(format_count) > 0) ||  (parseInt(order_format) > 0))
 	//{}
 }

 // on click of the hyperlink in the button frame,nothing should happen
 function dummy(){
 }
 function setFormatHdr(format_mandatory_count){ // Setting the value if the hdr has order format
  	//if(order_category=="CS") // For Care Sets Order
 	//	parent.placeOrderDetailFrame.document.location.href = "OrderEntryPlaceOrderCareSetResults.jsp?"+unescape(query_string);
 	//else
 	//	parent.placeOrderDetailFrame.document.location.href = "../../eOR/jsp/OrderEntryPlaceOrderResult.jsp?"+unescape(query_string);
 	//if(parent.criteriaDetailFrame.document.buttonForm.hdr_format_mandatory_count!=null)
	//	parent.criteriaDetailFrame.document.buttonForm.hdr_format_mandatory_count.value=format_mandatory_count;
	//if(parent.criteriaDetailFrame.document.buttonForm.hdr_format_count!=null)
 	//	parent.criteriaDetailFrame.document.buttonForm.hdr_format_count.value=format_count;
 } // End of setFormatHdr


  // Display the modal window on click of the schedule
 async function DisplaySchedule(catcode,code,row_value,facility_id,called_from)
 {
	bean_id 			= parent.placeOrderDetailFrame.document.placeOrderForm.bean_id.value;
 	bean_name 			= parent.placeOrderDetailFrame.document.placeOrderForm.bean_name.value;
	//freq_code			= eval("parent.placeOrderDetailFrame.document.placeOrderForm.frequency_val"+row_value+".value");
 	//start_date_time	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+row_value+".value");
 	
	if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.frequency_val"+row_value))
	{
		freq_code			= eval("parent.placeOrderDetailFrame.document.placeOrderForm.frequency_val"+row_value+".value");

		
		
		start_date_time	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+row_value+".value");

		duration	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.duration_value"+row_value+".value");	
		pr_duration_type	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.duration_code"+row_value+".value");	
		quantity    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.quantity"+row_value+".value");	
	}
	else if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_frequency_val"+row_value))
	{
		freq_code			= eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_frequency_val"+row_value+".value");
		freq_code=freq_code.split("~~");
		freq_code=freq_code[0];
		start_date_time	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_start_date_time"+row_value+".value");
		
		duration	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_duration_value"+row_value+".value");
		pr_duration_type	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_duration_code"+row_value+".value");	
		quantity	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_quantity"+row_value+".value");	
		


	}
	visit_adm_date		= parent.criteriaMainFrame.document.placeOrderHeaderForm.visit_adm_date.value;
 	future_order_date	= parent.criteriaMainFrame.document.placeOrderHeaderForm.future_order_date.value;
 	past_order_date		= parent.criteriaMainFrame.document.placeOrderHeaderForm.past_order_date.value;


 	query_string 		= "bean_id="+bean_id+"&bean_name="+bean_name+"&catalog_code="+catcode+"&code="+code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&start_time_day_param="+start_date_time+"&visit_adm_date="+visit_adm_date+"&future_order_date="+future_order_date+"&past_order_date="+past_order_date+"&called_from="+called_from+"&mode=1&pr_duration="+duration+"&pr_duration_type="+pr_duration_type+"&split_qty="+quantity;

	//if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.group_order_category"+row_value+".value")=="PH"){
	//	var uom = "";
	//	if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.uom"+row_value))
	//		uom = eval("parent.placeOrderDetailFrame.document.placeOrderForm.uom"+row_value+".value")
	//	query_string += "&module_id=PH"+"&uom_desc="+uom
	//} else { // OR 
    query_string += "&module_id=OR";	
	//}

	if(called_from=="apply")		// When called on press of record, make it small...
	{
		var dialogHeight   = "0" ;
		var dialogWidth    = "0" ;
		var dialogTop      = "0" ;
	}
	else
	{
		var dialogTop   	= "0px";
	 	//var dialogHeight	= "35" ;
 		//var dialogWidth 	= "50" ;
		var dialogHeight	= "70vh" ;
		var dialogWidth		= "79vw" ;
	}

	var retVal;
 	var features	= ' dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments	= "";

	if (start_date_time == "")
	{
		alert(getMessage("START_DATE","OR"))		
	}else{
 	
	retVal 			= await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?"+query_string,arguments,features);

	
 	if(retVal!=null)
 	{
		if (retVal.length != 0) 
		{
 		//retVal 		= retVal.split("|");
			
		// Set the hidden field schedule_mandatorily_yn to Y
 	/*	eval("parent.placeOrderDetailFrame.document.placeOrderForm.schedule_mandatorily_yn"+row_value+".value='Y'");
 		//changeStartDateTime(start_date_time,row_value,retVal[0],retVal[1]);
 		//Make the field as readonly
 		eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+row_value+".value=retVal");
 		eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+row_value+".readOnly=true");
 		// Calculate the End Date Time based upon the duration_value and start_date_time
 		start_date_time = eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+row_value+".value");
		duration_code	= eval("parent.placeOrderDetailFrame.document.placeOrderForm.duration_code"+row_value+".value");
		duration_value = eval("parent.placeOrderDetailFrame.document.placeOrderForm.duration_value"+row_value+".value");*/

		if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.schedule_mandatorily_yn"+row_value)){
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.schedule_mandatorily_yn"+row_value+".value='Y'");
		
 		//changeStartDateTime(start_date_time,row_value,retVal[0],retVal[1]);
 		//Make the field as readonly
 		eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+row_value+".value=retVal[0]");
		var catcode 		= eval("parent.placeOrderDetailFrame.document.placeOrderForm.catalog_code"+row_value+".value");
		var localename 		= parent.placeOrderDetailFrame.document.placeOrderForm.localeName.value;
		var sysdate		= parent.placeOrderDetailFrame.document.placeOrderForm.sys_date.value;

				
		var obj=eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time_id"+row_value);	
		var appt_reqd_yn =eval("parent.placeOrderDetailFrame.document.placeOrderForm.appt_reqd_yn"+row_value);	
					
		checkWithCurrentDate(obj,row_value,sysdate,localename,catcode,"schedule",appt_reqd_yn);
 		setValueforlegend("start_date_time"+catcode,retVal);	eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+row_value+".readOnly=true");
 		// Calculate the End Date Time based upon the duration_value and start_date_time
 		start_date_time = eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+row_value+".value");
		duration_code	= eval("parent.placeOrderDetailFrame.document.placeOrderForm.duration_code"+row_value+".value");
		duration_value = eval("parent.placeOrderDetailFrame.document.placeOrderForm.duration_value"+row_value+".value");
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.frequency_code"+row_value+".value=retVal[1]");
		var value =new Array();
		value      = retVal[1].split("~~");
		if(value[0]==null) value[0] = "";
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.frequency_val"+row_value+".value=value[0]");
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.duration_def_value"+row_value+".value=retVal[2]");
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.duration_value"+row_value+".value=retVal[2]");
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.duration_code"+row_value+".value=retVal[3]");
	
	}else if (eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_schedule_mandatorily_yn"+row_value)){
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_schedule_mandatorily_yn"+row_value+".value='Y'");
 		//changeStartDateTime(start_date_time,row_value,retVal[0],retVal[1]);
 		//Make the field as readonly
 		eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_start_date_time"+row_value+".value=retVal[0]");
 		eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_start_date_time"+row_value+".readOnly=true");
 		// Calculate the End Date Time based upon the duration_value and start_date_time
 		start_date_time = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_start_date_time"+row_value+".value");
		duration_code	= eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_duration_code"+row_value+".value");
		duration_value = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_duration_value"+row_value+".value");
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_frequency_code"+row_value+".value=retVal[1]");
		var value =new Array();
		value      = retVal[1].split("~~");
		if(value[0]==null) value[0] = "";
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_frequency_val"+row_value+".value=value[0]");
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_frequency_val"+row_value+".value=value[0]");
		//eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_duration_def_value"+row_value+".value=retVal[2]");
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_duration_value"+row_value+".value=retVal[2]");
		eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_duration_code"+row_value+".value=retVal[3]");
	}
		
		
		
		if(called_from=="apply"){			
			parent.parent.calculateEndDateTime(start_date_time,retVal[3],retVal[2],row_value,called_from);
		}else{ 	// Direct on click of hyperlink
		
			calculateEndDateTime(start_date_time,retVal[3],retVal[2],row_value,called_from);
		}
	 }
 	}
 	else
 	{
	}
 }
} // End of DisplaySchedule
// Till here

// Calculation for the changing the start date time
/*function changeStartDateTime(start_date_time,row_value,duration,start_time_assign)
{
	var dt 	 		= start_date_time
	var date 		= dt.split(" ");
	datearray 		= date[0].split("/");
	minarray 		= date[1].split(":");
	duration		= duration.split(":");
	dt 				= new Date(datearray[2],datearray[1],datearray[0],minarray[0],minarray[1])
	var hrs 	 	= dt.getHours();

	if(start_time_assign=="N")
		hrs 		= parseInt(hrs) + parseInt(duration[0]);
	else // For previous or closest
		hrs 		= parseInt(hrs) - parseInt(duration[0]);

		hrs			= duration[0]
	date 		 	= dt.setHours(hrs);
	var mins	 	= dt.getMinutes();
	if(start_time_assign=="N")
		mins 		 = parseInt(mins) + parseInt(duration[1]);
	else
		mins 		 = parseInt(mins) - parseInt(duration[1]);

		mins		= duration[1]
	date 		 	= dt.setMinutes(mins);
	date		 	= new Date(date);
	dtString 		= buildDate(date,row_value);
	eval("document.placeOrderForm.start_date_time"+row_value+".value=dtString");
} // End of changeStartDateTime
*/
 //function loadDetails(display_auth_count,format_mandatory_count,format_count,display_cosign_count,display_special_count,function_from, total_rows, p_start_date_time)//	IN071260
function loadDetails(display_auth_count,format_mandatory_count,format_count,display_cosign_count,display_special_count,function_from, total_rows, p_start_date_time,drugintercnt)//	IN071260
{		
		if(display_auth_count == 0 )	// To Hide the Authorization if no items have any authorization
			hideAuthorization()
		if(display_cosign_count == 0 )  // To Hide the Cosign if no items have any cosigned reqd
			hideCosign()
		if(display_special_count == 0 )  // To Hide the Special Approval if no items have any Special Approval reqd
			hideSpecialApproval()
		
		
		
		disableFPPCategoryOrder(total_rows);//IN068314
		
		// Any Fields needed Format (mandatory) in the line level, legend has to be displayed in the button frame
		setFormatLegends(format_mandatory_count,format_count)

	    setCPStartDateTime(function_from, total_rows, p_start_date_time);
		setDrugInteraction(total_rows,drugintercnt);	//IN071260
} // End of loadDetails
//IN068314 Starts
function disableFPPCategoryOrder(total_rows){
	
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm;
	var non_billing_numbering=0;
	for(var n=0;n<=total_rows;n++){
		if(null!=document.getElementById('non_billing_numbering'+n) && undefined!=document.getElementById('non_billing_numbering'+n))
		{ 
		non_billing_numbering = document.getElementById('non_billing_numbering'+n).value;
		if(non_billing_numbering>0){
			if(null!=document.getElementById('fpp_category'+n) && undefined!=document.getElementById('fpp_category'+n))
				document.getElementById('fpp_category'+n).disabled=true;
		}
			
		}
	}	
}
function disableFPPCategoryOrderset(index){
	if(null!=document.getElementById("fpp_category"+index) && undefined!=document.getElementById("fpp_category"+index))
		document.getElementById("fpp_category"+index).disabled=true;
}	
//IN068314 Ends
//	IN071260 Starts 
function labdruginterchk(catalogcode){
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	eval(formObj).document.getElementById("ck"+catalogcode).checked=false;
	eval(formObj).document.getElementById("ck"+catalogcode).disabled=true;
	eval(formObj).document.getElementById("ck"+catalogcode).value="N";
}

function setDrugInteraction(total_rows,drugintercnt){
 	if(parseInt(drugintercnt) > 0)
 	{			
	  	parent.criteriaDetailFrame.document.getElementById('drug_interaction').innerHTML	= "<a class='gridLink' href='javascript:showDrugInteractionDtls(\"L_DRUG_INTERACTION\")'><img src='../../eOR/images/LabDrugInteraction.png' align='center'></a>Drug Interaction";
	}	
}

async function showDrugInteractionDtls(druginter_called_from)
{
	var dialogHeight   = "70vh" ;
	var dialogWidth    = "60vw" ;
	var dialogTop      = "100";
	var dialogLeft     = "100";


	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments;
	var bean_id 			= parent.placeOrderDetailFrame.document.placeOrderForm.bean_id.value;
 	var bean_name 			= parent.placeOrderDetailFrame.document.placeOrderForm.bean_name.value;
	
	
	//var retVal = window.showModalDialog("../../eOR/jsp/OrderEntryDrugInteractionLine.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&druginter_called_from="+druginter_called_from,arguments,features);
 	
 	var retVal=await top.window.showModalDialog("../../eOR/jsp/OrderEntryDrugInteractionLine.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&druginter_called_from="+druginter_called_from,arguments,features);
 	return retVal;
 	
}
//IN071260 Ends
function setCPStartDateTime(function_from, total_rows, p_start_date_time) {
 	if(function_from=="CP" && p_start_date_time!="") { // if it is CP, module change the start_date_time for all.
 		//var confirm_date = window.confirm(getOrMessage("CP_START_DATE_TIME"));
 		//if(confirm_date){
 			for(i=0;i<total_rows;i++) {
				if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+i)) {
					eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+i+".value=p_start_date_time");	
				}
				eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time0.focus()");	
			} // End of for
 		//} // End of confirm_date
	} // End of function_from
	
} // End of setCPStartDateTime

// When the Authorization is required, User has to confirm
// Used for the Care Set
function CareSetCheckAuthorization(auth_reqd)
{
	if(parent.placeOrderDetailFrame)
	{
		total_rows =parent.placeOrderDetailFrame.document.placeOrderForm.total_rows.value;
		if(total_rows>0)
		{
			if (auth_reqd)
			{
				var yes = window.confirm(getMessage("AUTH_REQD_CONFIRM","OR"));
				if (yes)
				{
					CareSetHideLink(total_rows);   // change the html text
					parent.criteriaMainFrame.document.placeOrderHeaderForm.authorized.value = "true";
					for(i=0;i<total_rows;i++)
					{
						if(parent.placeOrderDetailFrame)
						{
							if(eval(parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+i)))
								auth_reqd	= parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+i).value;
							if(auth_reqd=="X")
								parent.placeOrderDetailFrame.document.getElementById("care_set_authorized"+i).value = 'true' ;
							else
								parent.placeOrderDetailFrame.document.getElementById("care_set_authorized"+i).value = 'false' ;
							/*Added by Uma on 8/26/2009 for PMG20089 - CRF 641*/
							if(parent.placeOrderDetailFrame.document.getElementById("catalog_code"+i))
							{							   
							   if(eval(parent.placeOrderDetailFrame).document.getElementById("ck"+eval(parent.placeOrderDetailFrame.document.getElementById("catalog_code"+i)).value).checked==true)
								{
									auth_reqd_yn = eval(parent.placeOrderDetailFrame.document.getElementById("ord_auth_reqd_yn"+i)).value;	prac_can_auth_yn = eval(parent.placeOrderDetailFrame.document.getElementById("auth_yn"+i)).value;	
									if(auth_reqd_yn =="Y" && prac_can_auth_yn =="Y" )
									{	
										i = total_rows;
									}
								}
							}
						}
					}
					if(auth_reqd_yn =="Y" && prac_can_auth_yn =="Y" )
					{
						if(parent.criteriaMainFrame)
							imgArr = parent.placeOrderDetailFrame.document.getElementsByTagName("img");
						for(var p=0;p<imgArr.length;p++)
						{
							if(imgArr[p].src.indexOf("mandatory")==-1 && imgArr[p].src.indexOf("Flex_blue")==-1 && imgArr[p].src.indexOf("Flex_red")==-1  && imgArr[p].src.indexOf("Cosign")==-1 && imgArr[p].src.indexOf("Cosign_click")==-1  && imgArr[p].src.indexOf("SpecialApproval")==-1 &&  imgArr[p].src.indexOf("SpecialApproval_click")==-1 && imgArr[p].src.indexOf("SecondaryOrder")==-1 && imgArr[p].src.indexOf("CommonCalendar")==-1)
							{
								var rowindex = imgArr[p].id.substring(13,(imgArr[p].id.length-1));
								if((eval(parent.placeOrderDetailFrame.document.getElementById("ord_auth_reqd_yn"+rowindex)).value=="Y") && (eval(parent.placeOrderDetailFrame.document.getElementById("auth_yn"+rowindex)).value=="Y"))
								{
									eval(parent.placeOrderDetailFrame.document.getElementById("authorised_yn"+rowindex)).value="Y";
									imgArr[p].src = "../../eOR/images/Authorized.gif";
								}
							}
						}
					}
					/*End Here*/
				}
			}
			else
			{
				parent.criteriaMainFrame.document.placeOrderHeaderForm.authorized.value = "false";
				for(i=0;i<total_rows;i++)
						document.getElementById("care_set_authorized"+i).value = 'false' ;
			}
		}
		else
		{
			return;
		}
	}
	else
	{
		return;
	}
}
// End of CareSetCheckAuthorization
// Used for the Care Set
function CareSetHideLink(total_row)
{
	for(i=0;i<total_rows;i++)
	{
		if(parent.placeOrderDetailFrame)
		{ 
			if(parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+i))
			{
				auth_reqd	= parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+i).value;
			if(parent.placeOrderDetailFrame.document.getElementById("authorizedId"+i) && auth_reqd=="X")
				parent.placeOrderDetailFrame.document.getElementById("authorizedId"+i).innerHTML='<b>Authorized</b>';
			}
			if(parent.placeOrderDetailFrame.document.getElementById("textimg"+i)  && auth_reqd=="X") //For Header
				parent.placeOrderDetailFrame.document.getElementById("textimg"+i).src='../../eOR/images/Authorized.gif';
			else if(parent.placeOrderDetailFrame.document.getElementById("textimg"+i) )
				parent.placeOrderDetailFrame.document.getElementById("textimg"+i).src='../../eOR/images/Authorization.gif';
			if(parent.placeOrderDetailFrame.document.getElementById("authorization"+i)  && auth_reqd=="X") //For Line Level
				parent.placeOrderDetailFrame.document.getElementById("authorization"+i).src='../../eOR/images/Authorized.gif';
			else if(parent.placeOrderDetailFrame.document.getElementById("authorization"+i))
				parent.placeOrderDetailFrame.document.getElementById("authorization"+i).src='../../eOR/images/Authorization.gif';
		} // End of placeOrderDetailFrame
	}
	//	document.getElementById("authorizedId").innerHTML="<b>Authorized</b>"
	//if(document.getElementById("textimg"))
	//	document.getElementById("textimg").src='../../eOR/images/Authorized.gif'
} // End of CareSetHideLink

// To get the Order Category when the Care Set is selected
function getCareSetValue(obj)
{
	if(obj.value!='')
	{
		val = obj.value.split("::");
		document.careSetSearchForm.care_set_val.value 				= val[0];
		document.careSetSearchForm.care_set_order_category.value 	= (val[1]);
	}
	if(parent.criteriaDetailFrame)
		parent.criteriaDetailFrame.location.href = "../../eCommon/html/blank.html"
	if(parent.criteriaButtonFrame)
		parent.criteriaButtonFrame.location.href = "../../eCommon/html/blank.html"
} // End of getCareSetValue

function termdesc(desc)
{
		
		document.careSetSearchForm.orderable_text.value=desc;
}
function disablefield(obj)
{
		//document.careSetSearchForm.orderable_text.value 	 = "";
		//document.careSetSearchForm.orderable_text_id.value	 = "";
		//if(obj.value=="")
}



/*function commentSetValue(key,value)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var bean_id=document.getElementById("+bean_id+").value;
	var bean_name=document.getElementById("bean_name").value;
	//var bean_id	 		= document.image_form.bean_id.value;
	//var	bean_name  		= document.image_form.bean_name.value;


	var func_mode="Tempvalues";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " key=\""+ key +"\" " ;
	xmlStr += " value=\""+ value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode="+func_mode,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}*/


// For the Panels to be displayed
/*function displayToolTip(val,val1,form_name)
{	val = unescape(val);
	val1 = unescape(val1);
	var display_records = 10 ; 		// Display 10 records at a time
	buildTable (val,val1,display_records,form_name);
	if(form_name == "tickSheetItemsForm") 		frame_name = criteriaTickSheetsFrame;
	else if(form_name == "imagePanelsForm")
		frame_name = parent.mainFrame.DetailFrame.displayTransaction.imageOrderCatalogs;
	else 		frame_name = parent.criteriaDetailFrame;
	//bodwidth = parent.parent.frames[1].document.body.offsetWidth
	bodheight =  frame_name.document.body.offsetHeight
	bodwidth  =  frame_name.document.body.offsetWidth
	var x = frame_name.event.x;
	var y = frame_name.event.y;
	x = x + (frame_name.document.getElementById("tooltiplayer").offsetWidth)
	y = y + (frame_name.document.getElementById("tooltiplayer").offsetHeight)
	if(x<bodwidth)   		x =frame_name.event.x
	else  		x = x - (frame_name.document.getElementById("tooltiplayer").offsetWidth*2)
	if(y<bodheight) 		y =frame_name.event.y
	else   		y = y - (frame_name.document.getElementById("tooltiplayer").offsetHeight*2)
	y+=frame_name.document.body.scrollTop
	x+=frame_name.document.body.scrollLeft
	frame_name.document.getElementById("tooltiplayer").style.posLeft= x
	frame_name.document.getElementById("tooltiplayer").style.posTop = y
   	frame_name.document.getElementById("tooltiplayer").style.visibility='visible'
} // End of displayToolTip
function buildTable(val,val1,display_records,form_name)
{	var rowval = val.split (",");
	var start_var 			 	= 0;
	var disp_val				= 0;
	var next_display_records 	= parseInt(display_records) + 10;
	var prev_display_records 	= parseInt(display_records) - 10;
	start_var 					= parseInt(display_records) - 10;
	if(display_records > rowval.length) 	disp_val				= parseInt(rowval.length);   // In first scenario it will be useful
	else  				disp_val				= parseInt(display_records);
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  class='BOX' width='100%' height='100%' align='center'>"
		tab_dat += "<tr>"
		tab_dat += "<td class='SENPAT' nowrap>"+val1+"</td>"
		tab_dat += "</tr> "
		tab_dat += "<td class ='LABEL' nowrap align='right'><font size='1'>";
		if(parseInt(start_var)!=0)
			tab_dat += "<input type='BUTTON' class='BUTTON' name='prev_button' id='prev_button' value='<' onClick=\"parent.buildTable('"+val+"','"+val1+"','"+prev_display_records+"','"+form_name+"')\"> "
		if(parseInt(display_records) < parseInt(rowval.length))
			tab_dat += "<input type='BUTTON' class='BUTTON' name='next_button' id='next_button' value='>' onClick=\"parent.buildTable('"+val+"','"+val1+"','"+next_display_records+"','"+form_name+"')\"> "
		tab_dat += "</font></td>";
		for( var i=start_var; i<disp_val; i++ )	//for( var i=0; i<rowval.length; i++ )
		{
			var colval = rowval[i]
			tab_dat += "<tr>"
			tab_dat += "<td class ='ORPANEL' nowrap>"+colval+"</td>"
			tab_dat += "</tr> "
		}
	tab_dat += "</table> "
	if(form_name == "tickSheetItemsForm") frame_name = criteriaTickSheetsFrame;
	else if(form_name == "imagePanelsForm") frame_name = parent.mainFrame.DetailFrame.displayTransaction.imageOrderCatalogs; // For the Image Frame
	else								  frame_name = parent.criteriaDetailFrame;
	frame_name.document.getElementById("t").innerHTML = tab_dat
} // End of buildTable
function hideToolTip(form_name)
{
	if(form_name == "tickSheetItemsForm") frame_name = criteriaTickSheetsFrame;
	else if(form_name == "imagePanelsForm") frame_name = parent.mainFrame.DetailFrame.displayTransaction.imageOrderCatalogs;
	else								 frame_name =  parent.criteriaDetailFrame;
	frame_name.document.getElementById("tooltiplayer").style.visibility='hidden'
 }// End of hideToolTip */

 function skipAuthIndicator(){
		//IN048467 - HSA-CRF-0150 Starts
		var skip_auth		="";
		var totalCount		= parseInt(eval("parent.placeOrderDetailFrame.document.placeOrderForm.total_rows.value;"))
		var function_name = parent.placeOrderDetailFrame.document.placeOrderForm.function_name.value;
		var priority ="";var group_order_category="";
		for(i=0;i<totalCount;i++)
		 {
			    priority = parent.placeOrderDetailFrame.document.getElementById('priority'+i).value;;
				skip_auth		=parent.placeOrderDetailFrame.document.getElementById('skip_auth'+i).value;
				var tempObj=parent.placeOrderDetailFrame.document.getElementById('authorization'+i);
				group_order_category =  parent.placeOrderDetailFrame.document.getElementById('group_order_category'+i).value;
				
				if(skip_auth!="NA")
				{
					if(skip_auth.search(priority) == -1  && skip_auth != "*A") 
					{	
							parent.placeOrderDetailFrame.document.getElementById('ord_auth_reqd_yn'+i).value = 'Y';
							if(function_name == "PREVIEW")
							{	
								parent.placeOrderDetailFrame.document.getElementById("imageId"+group_order_category+i).style.display = 'inline';
							parent.placeOrderDetailFrame.document.getElementById("authorizedId"+group_order_category+i).style.display = 'inline';
								if(null!=tempObj && undefined != tempObj)
									tempObj.style.display='inline';
								else if (null!= parent.placeOrderDetailFrame.document.placeOrderForm.authorization+group_order_category+i && undefined!=parent.placeOrderDetailFrame.document.placeOrderForm.authorization+group_order_category+i)
									eval("parent.placeOrderDetailFrame.document.placeOrderForm.authorization"+group_order_category+i+".style.display='inline'");
							}
							else
							{
								parent.criteriaMainFrame.document.getElementById("imageId").style.display='inline';
								parent.criteriaMainFrame.document.getElementById("authorizedId").style.display='inline';
								tempObj.style.display='inline';
							}
							
					}
					else {
						parent.placeOrderDetailFrame.document.getElementById('ord_auth_reqd_yn'+i).value = '';
						if(function_name == "PREVIEW")
						{
							parent.placeOrderDetailFrame.document.getElementById("imageId"+group_order_category+i).style.display = 'none';
						parent.placeOrderDetailFrame.document.getElementById("authorizedId"+group_order_category+i).style.display = 'none';
							if(null!=tempObj && undefined != tempObj)
								tempObj.style.display='none';
							else if (null!=parent.placeOrderDetailFrame.document.placeOrderForm.authorization+group_order_category+i && undefined!= parent.placeOrderDetailFrame.document.placeOrderForm.authorization+group_order_category+i)
								eval("parent.placeOrderDetailFrame.document.placeOrderForm.authorization"+group_order_category+i+".style.display='none'");
							
						}
						else
						{
							parent.criteriaMainFrame.document.getElementById("imageId").style.display='none';
							parent.criteriaMainFrame.document.getElementById("authorizedId").style.display='none';
							tempObj.style.display='none';
						}	
					}
				}
			}
		//IN048467 - HSA-CRF-0150 Ends
 }

