/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.  
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------------------------------------
23/09/2011	  28806			 Menaka		 Incident No: 28806 - <Radiology order-> setup schedule 
                                         applicable=Checked , it can?t change start date by click on ?Start date? header and can?t click on ?calendar icon? but user can change start date by typing new date and time on that field.>		 
29/11/2012	  IN031304		Karthi L	To load three tier waiting list screen when RD_OA_INTEGRATION_YN param is Y	and order_category is RD (IN035976)										RD(IN035976)		
20/12/2013	  IN045109		Vijayakumar K Alpha-OR-Unable to book appt for multi facility orders					 
02/07/2014	  IN048467 		Nijitha S		HSA-CRF-0150
-------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Review Date 		Review Name 		Description
-------------------------------------------------------------------------------------------------------------------------------------
27/12/2022		37051			Ramesh Goli		27/12/2022			Ramesh G 			ML-MMOH-CRF-1939.1

-------------------------------------------------------------------------------------------------------------------------------------
*/

function getOrderDesc(obj) 
{ // for the modal window search
	 if(obj.value!='')
	{
		val = obj.value.split("::");
		document.formPractDtl.order_mode_value.value  		= val[0];
		document.formPractDtl.order_mode_desc.value  		= val[1];
	}
	else
	{
		document.formPractDtl.order_mode_desc.value="";
	}
}//getOrderDesc

// Method Not used now, only if OT (OrderEntryFormat.jsp)
async function showOTCalendar(field_obj,pref_obj,performing_facility_id,patient_id){
	var form_obj 		= document.OrderFormatForm
	var formObj			= "document.OrderFormatForm."
	var cur_obj			= eval(formObj+field_obj);
	var form_obj_value;
	// Get the Perform Team Surgeon ie(Practitioner_id-->PERFORM_TEAM_SURGEON)
	// Current field_mnemonic is PREF_SURG_DATE, should replace with PERFORM_TEAM_SURGEON
	var perform_surgeon	= pref_obj.replace("PREF_SURG_DATE","PERFORM_TEAM_SURGEON");
	for(var i=0;i<form_obj.length;i++)	//To get the concerned Perform Team Surgeon
	{
		 if(form_obj[i].type=="select-one") // For select box
		 {
			 if(form_obj[i].name.indexOf(perform_surgeon)!=-1)
			 {
				form_obj_value	= form_obj[i].value; //For One Order type code, only one value will be there, so need to check for other list box
				break;
			 }
		} // End of if form_obj[i].type
	 } // End of for i
	// Remove the *P/ or *T/ from the code of the practitioner_id
	form_obj_value	=  form_obj_value.substring(3, form_obj_value.length);
	// Till here to get the perform_surgeon id
	if(form_obj_value!=null && form_obj_value!="")
	{
		var retVal;
		var dialogTop   = "180";
		var dialogHeight= "19" ;
		var dialogWidth = "16" ;
		var features	= "Width:" + dialogWidth +"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop +"; scroll=no; status=no";
		var arguments	= "";
		retVal 			= await window.showModalDialog("../../eOR/jsp/OrderEntryCalendarFrameSet.jsp?performing_facility_id="+performing_facility_id+"&patient_id="+patient_id+"&practitioner_id="+form_obj_value,arguments,features);
		//alert(retVal);
		if(retVal!=null && retVal!=""){
			cur_obj.value = retVal;
		}
	}
	else
		alert(getMessage("PERF_SURGEON_BLANK","OR"));
	return false;
} // End of showOTCalendar

function moveDirection(obj, total, patient_id, performing_facility_id, practitioner_id)
{
	direction			= obj.name
	if(obj.name=="next")
	{
		total			= total+1;
		status			= "PR";			//PR-->Previous
	}
	else if(obj.name=="prev")
	{
		total			= total-1;
		status			= "NE";			//NE --> Next
	}
	var param			= "OrderEntryCalendar.jsp?performing_facility_id="+performing_facility_id+"&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&status="+status+"&total="+total	//PR-->Previous  && NE --> Next
	self.location.href	= param

	if(top.calendarButtonFrame.document.calendarButtonForm) {
		top.calendarButtonFrame.document.calendarButtonForm.date_id.innerHTML="&nbsp;";
		top.calendarButtonFrame.document.calendarButtonForm.date_value.value="";
	}
} // End of moveDirection

function closeModal()
{
	//alert(top.calendarButtonFrame.document.calendarButtonForm.date_value.value);
  //  window.returnValue = top.calendarButtonFrame.document.calendarButtonForm.date_value.value;
	//window.close();
let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = top.calendarButtonFrame.document.calendarButtonForm.date_value.value;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
} // End of closeModal

// Clear the pref_surg-date
function callClearPrefSurgDate(perform_obj){
	var form_obj 		= document.OrderFormatForm
	var formObj			= "document.OrderFormatForm."
	// Get the PREF_SURG_DATE
	// Current field_mnemonic is PREF_SURG_DATE, should replace with PERFORM_TEAM_SURGEON
	var pref_surg_date	= perform_obj.replace("PERFORM_TEAM_SURGEON","PREF_SURG_DATE");
	var pre_op_days		= perform_obj.replace("PERFORM_TEAM_SURGEON","PRE_OP_DAYS");
	for(var i=0;i<form_obj.length;i++)	//To get the concerned Perform Team Surgeon
	{
		 if(form_obj[i].type=="text") // For Text box
		 {
			 if(form_obj[i].name.indexOf(pref_surg_date)!=-1 || form_obj[i].name.indexOf(pre_op_days)!=-1 )
			 {  // clear the value
				//form_obj[i].value="";
			 }
		} // End of if form_obj[i].type
	 } // End of for i
} // End of callClearPrefSurgDate

function populateDate(month, year, day, patient_id,active_bookings){
	var date = buildStrDate(month, year, day);
	if(date!=null && date!="") {
	top.calendarButtonFrame.document.calendarButtonForm.date_id.innerHTML="<b>"+date+"</b>";
		activeBookingHtml(patient_id, active_bookings, date);
	}
}// End of populateDate

/*  Not Needed
	function loadDefaultDateDetail() {
    //alert(this.parent.calendarFrame.name);
    day = this.parent.calendarFrame.document.calendarForm.default_booking.value;
    month = this.parent.calendarFrame.document.calendarForm.month_count.value;
    year = this.parent.calendarFrame.document.calendarForm.year.value;
    patient_id = this.parent.calendarFrame.document.calendarForm.patient_id.value;
    active_bookings = this.parent.calendarFrame.document.calendarForm.active_bookings.value;

    var date = "";
	if(day!="")
	{
		date = buildStrDate(month, year, day);
		if(date!=null && this.document.calendarButtonForm){
			this.document.calendarButtonForm.date_id.innerHTML="<b>"+date+"</b>";
		}
	}
	else
	{
			this.document.calendarButtonForm.date_id.innerHTML="&nbsp;";
			// Populate the Hyperlink
	}
	//alert(top.calendarButtonFrame.document.calendarButtonForm.date_id.id);
	activeBookingHtml(patient_id, active_bookings, date)
}*/

// To load the default Booking date (greater than current date)
function loadDefaultDate(month, year, day, patient_id,active_bookings,qry_string) {
	//top.calendarButtonFrame.location.href = '../../eOR/jsp/OrderEntryCalendarButton.jsp?'+qry_string;
	if(top.calendarButtonFrame && top.calendarButtonFrame.document.calendarButtonForm) {
	    var date = "";
		if(day!="")
		{
			date = buildStrDate(month, year, day);
			if(date!=null){
				top.calendarButtonFrame.document.calendarButtonForm.date_id.innerHTML="<b>"+date+"</b>";
			}
		} //commented for not getting the script error
		else
		{
				top.calendarButtonFrame.document.calendarButtonForm.date_id.innerHTML="&nbsp;";
				// Populate the Hyperlink
		}
		//alert(top.calendarButtonFrame.document.calendarButtonForm.date_id.id);
		activeBookingHtml(patient_id, active_bookings, date)	
	} // End of object
} // End of loadDefaultDate


function activeBookingHtml(patient_id, active_bookings, date){
    //alert(patient_id+","+active_bookings+","+date);
    if(active_bookings!=null && active_bookings!=""  && active_bookings!=0)
	{
		// Populate the Hyperlink
		top.calendarButtonFrame.document.calendarButtonForm.active_id.innerHTML="<b><font size='1'><a class='gridLink' href='javascript:showOtDetails("+patient_id+")'>&nbsp;"+active_bookings+"</a></font></b>";
		// Populate the hidden field
		top.calendarButtonFrame.document.calendarButtonForm.active_legends.innerHTML="&nbsp;Active Bookings";
		top.calendarButtonFrame.document.calendarButtonForm.date_value.value=date;
	}
	else
	{
		top.calendarButtonFrame.document.calendarButtonForm.active_id.innerHTML="&nbsp;"+active_bookings;
		top.calendarButtonFrame.document.calendarButtonForm.active_legends.innerHTML="&nbsp;Active Bookings";
		//parent.document.calendarButtonForm.active_id.innerHTML="&nbsp;"+active_bookings;
		// Populate the hidden field
		//top.calendarButtonFrame.document.calendarButtonForm.date_value.value="";  //Commented for showing the date
		top.calendarButtonFrame.document.calendarButtonForm.date_value.value=date;
	}
} // End of activeBookingHtml

function buildStrDate(month, year, day){
	if(month.length==1)
		month	= "0"+month
	if(day.length==1)
		day		= "0"+day
	var date	= day+"/"+month+"/"+year;
	return date;
} // End of buildStrDate

async function showOtDetails(patient_id) {
		var retVal;
		var dialogTop	= "130";
		var dialogHeight ="20" ;
		var dialogWidth = "43" ;
		var features	= "Width:" + dialogWidth +"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop +"; scroll=no; status=no";
		var arguments	= "";
		retVal 			= await window.showModalDialog("../../eOR/jsp/OrderEntryOTFrameSet.jsp?patient_id="+patient_id,arguments,features);
} // End of showOtDetails

// Hiding the respective gifs from the Preview 
function hideGifs(count,ord_cat,display_auth_count,display_cosign_count,display_special_count){
	if(display_auth_count==0 && display_cosign_count==0 && display_special_count==0)
	{
		if(eval(document.getElementById("hdg"+ord_cat+count)))
		document.getElementById("hdg"+ord_cat+count).innerHTML='';
	}
	if(display_auth_count==0) {
		if(document.getElementById("imageId"+ord_cat+count))
			document.getElementById("imageId"+ord_cat+count).innerHTML='';
		if(document.getElementById("authorizedId"+ord_cat+count))
		   document.getElementById("authorizedId"+ord_cat+count).innerHTML='';
	}
	if(display_cosign_count==0) {
		if(document.getElementById("imageCosignId"+ord_cat+count))
			document.getElementById("imageCosignId"+ord_cat+count).innerHTML='';
		if(document.getElementById("cosignId"+ord_cat+count))
		   document.getElementById("cosignId"+ord_cat+count).innerHTML='';
	}
	if(display_special_count==0) {
		if(document.getElementById("imageSpecialId"+ord_cat+count))
			document.getElementById("imageSpecialId"+ord_cat+count).innerHTML='';
		if(document.getElementById("specialId"+ord_cat+count))
		 document.getElementById("specialId"+ord_cat+count).innerHTML='';
	}
} // End of hideGifs

// When the Auth is required, User has to confirm in the Preview (Preview)
function CheckMultipleAuth(ord_cat,auth_reqd)
{
	 	if(parent.placeOrderDetailFrame)
		total_order_cat_count =parent.placeOrderDetailFrame.document.placeOrderForm.total_order_cat_count.value;
		total_rows		   = parent.placeOrderDetailFrame.document.placeOrderForm.total_rows.value;
	if (auth_reqd)
	{
			var yes = window.confirm(getMessage("AUTH_REQD_CONFIRM","OR"));
		if (yes)
		{
			MultipleAuthHideLink(ord_cat, total_rows, total_order_cat_count);   // change the html text
			parent.criteriaMainFrame.document.placeOrderHeaderForm.authorized.value = "true";
			for(i=0;i<total_rows;i++)
			{
				if(parent.placeOrderDetailFrame)
				{
					if(eval(parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+ord_cat+i)))  
						auth_reqd	= parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+ord_cat+i).value;
 					if(auth_reqd=="X") {
						if(parent.placeOrderDetailFrame.document.getElementById("care_set_authorized"+ord_cat+i))
						parent.placeOrderDetailFrame.document.getElementById("care_set_authorized"+ord_cat+i).value = 'true' ;
					}
					else
					{
						if(parent.placeOrderDetailFrame.document.getElementById("care_set_authorized"+ord_cat+i))
							parent.placeOrderDetailFrame.document.getElementById("care_set_authorized"+ord_cat+i).value = 'false' ;
					}

				}
			}
		}
	}
	else
	{
		parent.criteriaMainFrame.document.placeOrderHeaderForm.authorized.value = "false";
		for(i=0;i<total_rows;i++) {
				if(parent.placeOrderDetailFrame.document.getElementById("care_set_authorized"+ord_cat+i))
				document.getElementById("care_set_authorized"+ord_cat+i).value = 'false' ;
		}	
	}
} // End of CheckMultipleAuth

// Hiding the cosigned multiple (Preview)
function MultipleAuthHideLink(ord_cat, total_rows, total_order_cat_count)
{
 	for(i=0;i<total_order_cat_count;i++)
	{
		if(parent.placeOrderDetailFrame)
		{
			if(eval(parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+ord_cat+i)))
				auth_reqd	= parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+ord_cat+i).value;
			if(parent.placeOrderDetailFrame.document.getElementById("authorizedId"+ord_cat+i) && auth_reqd=="X")
				parent.placeOrderDetailFrame.document.getElementById("authorizedId"+ord_cat+i).innerHTML=getLabel("Common.Authorized.label","Common");

 			if(parent.placeOrderDetailFrame.document.getElementById("textimg"+ord_cat+i)  && auth_reqd=="X") //For Header
				parent.placeOrderDetailFrame.document.getElementById("textimg"+ord_cat+i).src='../../eOR/images/Authorized.gif';
			else if(parent.placeOrderDetailFrame.document.getElementById("textimg"+ord_cat+i) )
				parent.placeOrderDetailFrame.document.getElementById("textimg"+ord_cat+i).src='../../eOR/images/Authorization.gif';

 		} // End of placeOrderDetailFrame
	}  // End of total_order_cat_count

	// To hide in the line level
	for(i=0;i<total_rows;i++)
	{
		if(parent.placeOrderDetailFrame)
		{
			if(parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+ord_cat+i)) // only for category row will be there 
				auth_reqd	=parent.placeOrderDetailFrame.document.getElementById("auth_reqd"+ord_cat+i).value;
 			if(parent.placeOrderDetailFrame.document.getElementById("authorization"+ord_cat+i) && auth_reqd=="X") //For Line Level
				parent.placeOrderDetailFrame.document.getElementById("authorization"+ord_cat+i).src='../../eOR/images/Authorized.gif';
			else if(parent.placeOrderDetailFrame.document.getElementById("authorization"+ord_cat+i) )
				parent.placeOrderDetailFrame.document.getElementById("authorization"+ord_cat+i).src='../../eOR/images/Authorization.gif';
				/*Added by Uma on 8/26/2009 for PMG20089 -CRF 641*/
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
				if(auth_reqd_yn =="Y" && prac_can_auth_yn =="Y" )
				{
					if(parent.criteriaMainFrame)
						imgArr = parent.placeOrderDetailFrame.document.getElementsByTagName("img");
					for(var p=0;p<imgArr.length;p++)
					{
						if(imgArr[p].src.indexOf("mandatory")==-1 && imgArr[p].src.indexOf("Flex_blue")==-1 && imgArr[p].src.indexOf("Flex_red")==-1  && imgArr[p].src.indexOf("Cosign")==-1 && imgArr[p].src.indexOf("Cosign_click")==-1  && imgArr[p].src.indexOf("SpecialApproval")==-1 &&  imgArr[p].src.indexOf("SpecialApproval_click")==-1 && imgArr[p].src.indexOf("SecondaryOrder")==-1 && imgArr[p].src.indexOf("CommonCalendar")==-1)
						{
							//var rowindex = imgArr[p].id.substring(13,(imgArr[p].id.length-1));
							var rowindex = imgArr[p].id.substring(14,(imgArr[p].id.length-1));//IN048467
							if((eval(parent.placeOrderDetailFrame.document.getElementById("ord_auth_reqd_yn"+rowindex)).value=="Y") && (eval(parent.placeOrderDetailFrame.document.getElementById("auth_yn"+rowindex)).value=="Y"))
							{
								eval(parent.placeOrderDetailFrame.document.getElementById("authorised_yn"+rowindex)).value="Y";
							imgArr[p].src = "../../eOR/images/Authorized.gif";
							}
						}
					}
				}
			/*End Here*/
		} // End of placeOrderDetailFrame
	} // End of total_rows
} // End of MultipleAuthHideLink


// When the Cosign is required, User has to confirm in the Preview (Preview)
function CheckMultipleCosign(ord_cat,auth_reqd){
 
	if(parent.placeOrderDetailFrame) {
		total_order_cat_count =parent.placeOrderDetailFrame.document.placeOrderForm.total_order_cat_count.value;
		total_rows		   = parent.placeOrderDetailFrame.document.placeOrderForm.total_rows.value;
	}
 		//total_rows =parent.placeOrderDetailFrame.document.placeOrderForm.total_rows.value;
	if (auth_reqd){
		var yes = window.confirm(getMessage("COSIGN_REQD_CONFIRM","OR"));
		if (yes){
			MultipleCosignHideLink(ord_cat, total_rows, total_order_cat_count);   // change the html text
			parent.criteriaMainFrame.document.placeOrderHeaderForm.cosigned.value = "true";
			for(i=0;i<total_rows;i++)
			{
				if(parent.placeOrderDetailFrame)
				{
					if(parent.placeOrderDetailFrame.document.getElementById("cosign_reqd"+ord_cat+i))
						cosign_reqd	= parent.placeOrderDetailFrame.document.getElementById("cosign_reqd"+ord_cat+i).value;
 					if(cosign_reqd=="X") {
						if(parent.placeOrderDetailFrame.document.getElementById("multiple_cosigned"+ord_cat+i))
						parent.placeOrderDetailFrame.document.getElementById("multiple_cosigned"+ord_cat+i).value = 'true';
					}
					else{
						if(parent.placeOrderDetailFrame.document.getElementById("multiple_cosigned"+ord_cat+i))
							parent.placeOrderDetailFrame.document.getElementById("multiple_cosigned"+ord_cat+i).value = 'false';
					}

				}
			}
		}
	}else{
		parent.criteriaMainFrame.document.placeOrderHeaderForm.cosigned.value = "false";
		for(i=0;i<total_rows;i++) {
				if(parent.placeOrderDetailFrame.document.getElementById("multiple_cosigned"+ord_cat+i))
					document.getElementById("multiple_cosigned"+ord_cat+i).value = 'false' ;
		}	
	}
} // End of CheckMultipleCosign


// Hiding the cosigned multiple (Preview)
function MultipleCosignHideLink(ord_cat, total_rows, total_order_cat_count)
{
	for(i=0;i<total_order_cat_count;i++)
	{
		if(parent.placeOrderDetailFrame)
		{
			if(parent.placeOrderDetailFrame.document.getElementById("cosign_reqd"+ord_cat+i))
				cosign_reqd	= parent.placeOrderDetailFrame.document.getElementById("cosign_reqd"+ord_cat+i).value;
			if(parent.placeOrderDetailFrame.document.getElementById("cosignId"+ord_cat+i) && cosign_reqd=="X")
				parent.placeOrderDetailFrame.document.getElementById("cosignId"+ord_cat+i).innerHTML=getLabel("Common.Cosigned.label","COMMON");
			if(parent.placeOrderDetailFrame.document.getElementById("textcosignimg"+ord_cat+i)  && cosign_reqd=="X") //For Header
				parent.placeOrderDetailFrame.document.getElementById("textcosignimg"+ord_cat+i).src='../../eOR/images/Cosign.gif';
			else if(parent.placeOrderDetailFrame.document.getElementById("textcosignimg"+ord_cat+i))
				parent.placeOrderDetailFrame.document.getElementById("textcosignimg"+ord_cat+i).src='../../eOR/images/Cosign_click.gif';
		} // End of placeOrderDetailFrame
	} // End of total_order_cat_count
	// To hide in the line level

	for(i=0;i<total_rows;i++){
		if(parent.placeOrderDetailFrame)
		{
			if(parent.placeOrderDetailFrame.document.getElementById("cosign_reqd"+ord_cat+i)) // only for category row will be there 
				cosign_reqd	= parent.placeOrderDetailFrame.document.getElementById("cosign_reqd"+ord_cat+i).value;

 			if(parent.placeOrderDetailFrame.document.getElementById("cosign"+ord_cat+i)  && cosign_reqd=="X") //For Line Level
				parent.placeOrderDetailFrame.document.getElementById("cosign"+ord_cat+i).src='../../eOR/images/Cosign.gif';
			else if(parent.placeOrderDetailFrame.document.getElementById("cosign"+ord_cat+i)) 
				parent.placeOrderDetailFrame.document.getElementById("cosign"+ord_cat+i).src='../../eOR/images/Cosign_click.gif';
 		} // End of placeOrderDetailFrame
	} // End of total_rows

} // End of MultipleCosignHideLink

// When the Cosign is required, User has to confirm in the Preview (Preview)
function CheckMultipleSpecialApproval(ord_cat,auth_reqd){
	if(parent.placeOrderDetailFrame) {
		total_order_cat_count =parent.placeOrderDetailFrame.document.placeOrderForm.total_order_cat_count.value;
		total_rows		   = parent.placeOrderDetailFrame.document.placeOrderForm.total_rows.value;
	}
	if (auth_reqd){
		var yes = window.confirm(getMessage("SPECIAL_APPROVAL_REQD_CONFIRM","OR"));
		if (yes){
			MultipleSpecialApprovalHideLink(ord_cat, total_rows, total_order_cat_count);   // change the html text
			parent.criteriaMainFrame.document.placeOrderHeaderForm.special_approved.value = "true";
			for(i=0;i<total_rows;i++)
			{
				if(parent.placeOrderDetailFrame)
				{
					if(parent.placeOrderDetailFrame.document.getElementById("special_approval_reqd"+ord_cat+i))
						special_approval_reqd	= parent.placeOrderDetailFrame.document.getElementById("special_approval_reqd"+ord_cat+i).value;
					if(special_approval_reqd=="X") {
						if(parent.placeOrderDetailFrame.document.getElementById("multiple_special_approved"+ord_cat+i))
							parent.placeOrderDetailFrame.document.getElementById("multiple_special_approved"+ord_cat+i).value = 'true' ;
					}
					else{
						if(parent.placeOrderDetailFrame.document.getElementById("multiple_special_approved"+ord_cat+i))
						parent.placeOrderDetailFrame.document.getElementById("multiple_special_approved"+ord_cat+i).value = 'false' ;
					}
				}
			}
		}
	}else{
		parent.criteriaMainFrame.document.placeOrderHeaderForm.special_approved.value = "false";
		for(i=0;i<total_rows;i++) {
			if(parent.placeOrderDetailFrame.document.getElementById("multiple_special_approved"+ord_cat+i))
				document.getElementById("multiple_special_approved"+ord_cat+i).value = 'false' ;
		}
	}
} // End of CheckMultipleSpecialApproval

// Hiding the Speical Approval multiple (Preview)
function MultipleSpecialApprovalHideLink(ord_cat, total_rows, total_order_cat_count)
{
	for(i=0;i<total_order_cat_count;i++)
	{
		if(parent.placeOrderDetailFrame)
		{
			if(parent.placeOrderDetailFrame.document.getElementById("special_approval_reqd"+ord_cat+i))
				special_approval_reqd	= parent.placeOrderDetailFrame.document.getElementById("special_approval_reqd"+ord_cat+i).value;
			if(parent.placeOrderDetailFrame.document.getElementById("specialId"+ord_cat+i) && special_approval_reqd=="X")
				parent.placeOrderDetailFrame.document.getElementById("specialId"+ord_cat+i).innerHTML=getLabel("Common.Approved.label","COMMON");
			if(parent.placeOrderDetailFrame.document.getElementById("textspecialimg"+ord_cat+i)  && special_approval_reqd=="X") //For Header
				parent.placeOrderDetailFrame.document.getElementById("textspecialimg"+ord_cat+i).src='../../eOR/images/SpecialApproval_click.gif';
			else if(parent.placeOrderDetailFrame.document.getElementById("textspecialimg"+i) )
				parent.placeOrderDetailFrame.document.getElementById("textspecialimg"+ord_cat+i).src='../../eOR/images/SpecialApproval.gif';
		} // End of placeOrderDetailFrame
	} // End of total_order_cat_count

	for(i=0;i<total_rows;i++){
		if(parent.placeOrderDetailFrame)
		{
			if(parent.placeOrderDetailFrame.document.getElementById("special_approval_reqd"+ord_cat+i)) // only for category row will be there 
				special_approval_reqd	= parent.placeOrderDetailFrame.document.getElementById("special_approval_reqd"+ord_cat+i).value;

 			if(parent.placeOrderDetailFrame.document.getElementById("special_approval"+ord_cat+i)  && special_approval_reqd=="X") //For Line Level
				parent.placeOrderDetailFrame.document.getElementById("special_approval"+ord_cat+i).src='../../eOR/images/SpecialApproval_click.gif';
			else if(parent.placeOrderDetailFrame.document.getElementById("special_approval"+ord_cat+i)) 
				parent.placeOrderDetailFrame.document.getElementById("special_approval"+ord_cat+i).src='../../eOR/images/SpecialApproval.gif';
 		} // End of placeOrderDetailFrame
	} // End of total_rows
} // End of MultipleSpecialApprovalHideLink



// Function to Validate the Date and Time in the Place order screen and to change the end date time if the duration is not null
function checkAmendStartDateTime(obj,i,CDate,localeName,str,amendcatcode,onload,facilityId,order_category,amend_appt_reqd_yn)//28806 modified by Menaka
{	
	if((onload)!=("onLoad"))
	{
		var amendFreqObject = (parent.placeOrderDetailFrame.document.getElementById("amend_frequency_code"+i));
		setAmendFrequency(amendFreqObject,i,amendcatcode,facilityId,'onDateChange',order_category,amend_appt_reqd_yn);//28806 modified by Menaka
	}
	/*var currentdate=getCurrentDate("DMYHM",localeName);
	var Currentdatefloor=currentdate.substring(0,10);
	var Startdatefloor=obj.value.substring(0,10);
	if(obj.value.length==16)
	{
		if(!(isAfter(Currentdatefloor,Startdatefloor,"DMY",localeName)))
		{
			obj.value=obj.value.substring(0,11)+"00:00";
		}
		else
		{	
			obj.value=obj.value.substring(0,11)+currentdate.substring(11);
		}
	}*/
	
	if(validateDateWithTime(obj)==true)
	{  // if duration is not null, then change the date in the end_date_time
		var amend_appt_reqd_yn = eval("document.placeOrderForm.amend_appt_reqd_yn"+i+".value");
		checkWithCurrent(obj,i,CDate,localeName,amendcatcode,amend_appt_reqd_yn);
		var duration_code 		= eval("document.placeOrderForm.amend_duration_code"+i+".value");
		var duration_value 		= eval("document.placeOrderForm.amend_duration_value"+i+".value");
		var catalog_code 		= eval("document.placeOrderForm.amend_catalog_code"+i+".value");
		if(duration_value!='' && duration_code!='')
			calculateEndDateTime(obj.value,duration_code,duration_value,i,'AMEND');

		removeSchedule(i, catalog_code ); // To remove the Schedule Frequency
	}
	setValue(str,obj.value);
}
function checkAmendStartDateTimes(obj,i,CDate,localeName,str,amendcatcode)
{	
	eval("document.placeOrderForm.amend_schedule_mandatorily_yn"+i+".value='N'");
	var currentdate=getCurrentDate("DMYHM",localeName);
	var Currentdatefloor=currentdate.substring(0,10);
	var Startdatefloor=obj.value.substring(0,10);
	if(obj.value.length==16)
	{
		if((isAfter(Currentdatefloor,Startdatefloor,"DMY",localeName)))
		{
			obj.value=obj.value.substring(0,11)+currentdate.substring(11);
		}
	}
	eval("document.placeOrderForm.amend_end_date_time"+i+".value=''");
	if(validateDateWithTime(obj)==true)
	{  // if duration is not null, then change the date in the end_date_time
		var amend_appt_reqd_yn = eval("document.placeOrderForm.amend_appt_reqd_yn"+i+".value");
		checkWithCurrent(obj,i,CDate,localeName,amendcatcode,amend_appt_reqd_yn);
		var duration_code 		= eval("document.placeOrderForm.amend_duration_code"+i+".value");
		var duration_value 		= eval("document.placeOrderForm.amend_duration_value"+i+".value");
		var catalog_code 		= eval("document.placeOrderForm.amend_catalog_code"+i+".value");
		if(duration_value!='' && duration_code!='')
			calculateEndDateTime(obj.value,duration_code,duration_value,i,'AMEND');

		removeSchedule(i, catalog_code ); // To remove the Schedule Frequency
	}
	setValue(str,obj.value);
}


// OA Appointment to be called as an Modal window
function getAppointmentBooking(formObj){
	// To Pass it to OA Booking Appointment
	
	var bean_id					= formObj.bean_id.value;
	var bean_name				= formObj.bean_name.value;
	var localeName              = formObj.localeName.value;
	var order_category			= formObj.order_category.value;
	var func_mode				= "";
	var rd_oa_integration_yn	= parent.criteriaMainFrame.document.placeOrderHeaderForm.rd_oa_integration_yn.value; // added for IN031304
	if(order_category=="OT" && formObj.ot_install_yn.value =="Y")
		func_mode				= "CALL_OT_APPT";
		
	/*else if(order_category=="RD" && formObj.rd_install_yn.value=="Y" // commented for IN031304
		func_mode				= "CALL_RD_APPT";	*/
		
	else if(order_category=="RD" && formObj.rd_install_yn.value=="Y" && rd_oa_integration_yn == "Y") // added for IN031304
		func_mode				= "CALL_OA_APPT"; // added for IN031304
	else if(order_category=="RD" && formObj.rd_install_yn.value=="Y" && rd_oa_integration_yn == "N")// added for IN031304
		func_mode				= "CALL_RD_APPT";	// added for IN031304
	else 
		func_mode				= "CALL_OA_APPT";  // for Other orders

	var query_string			= "bean_id=" + bean_id + "&bean_name="+ bean_name+"&localeName="+localeName;
		query_string			+= "&func_mode="+func_mode;
 	 //	var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//	var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		//var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();
		xmlStr					= "<root><SEARCH " ;
		xmlStr					+= "patient_id=\"" + formObj.patient_id.value +"\" ";
		xmlStr					+= "location_code=\"" +  formObj.location_code.value +"\" ";
		xmlStr					+= "location_type=\"" + formObj.location_type.value +"\" ";
		xmlStr					+= "ordering_practitioner=\"" + formObj.ordering_practitioner.value +"\" ";
		xmlStr					+= "specialty_code=\"" + formObj.specialty_code.value +"\" ";
		xmlStr					+=" /></root>" ;
  		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryBookingAppointment.jsp?"+query_string, false ) ;
		xmlHttp.send( xmlDoc ) ;
 		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
} // End of function getAppointmentBooking

//37051 Start.
//function callAppointmentBooking(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time, catalog_code_dc,performing_facility_id,facility_id)
async function callAppointmentBooking(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time, catalog_code_dc,performing_facility_id,facility_id,fpp_yn,fpp_category)
//37051 End.
{
	if(performing_facility_id==facility_id)
	{
		var appt_confirm = window.confirm(getMessage("BOOK_APPT_CATALOG","OR") +" "+ catalog_code_dc +"?");
		if(appt_confirm)
		{	
			//alert( "patient_id"+patient_id	+"location_code"+location_code+"ordering_practitioner"+ordering_practitioner+"order_id"+order_id	+"order_line_num"+order_line_num+"order_catalog_code"+order_catalog_code+"start_date_time"+start_date_time);
			//37051 Start.
			//OABookAppointment(patient_id, location_code, "", ordering_practitioner, "", order_id, order_line_num, order_catalog_code, start_date_time,"","","","","","","","");
			await OABookAppointment(patient_id, location_code, "", ordering_practitioner, "", order_id, order_line_num, order_catalog_code, start_date_time,"","","","","","","","",fpp_yn,fpp_category);
			//37051 End.
		} // End of appt_confirm
	}
} // End of function callAppointmentBooking

//37051 Start.
//function callOTAppointment(order_id, practitioner_id, practitioner_name, pref_surg_date){
async function callOTAppointment(order_id, practitioner_id, practitioner_name, pref_surg_date,fpp_yn,fpp_category){	
//37051 End.	
	// Call a modal window and ask whether the user want to book an appointment, or call an Waiting List, or cancel


	var retVal 			= ""
	var dialogHeight 	= "11" ;
	var dialogWidth  	= "20" ;
	var dialogTop    	= "300";
	var dialogLeft		= "240" 
	var center			= "1" ;
	var status 			= "no";
	var arguments		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=no; status:no";
	var finalString		= "order_id="+order_id+"&practitioner_id="+escape(practitioner_id)+"&pref_surg_date="+escape(pref_surg_date)+"&practitioner_name="+escape(practitioner_name);		
 	finalString	+= "&fpp_yn="+fpp_yn+"&fpp_category="+fpp_category;  //37051 Start.
	//alert("finalString"+finalString);
	// change the file name for the OT Appointment.
	retVal				= await window.showModalDialog("../../eOR/jsp/OrderEntryOTAppointment.jsp?"+finalString,arguments,features);
} // End of function callOTAppointment

async function bookOTAppointment(){
//alert('in bookOTAppointment ');
	var order_id			= document.OTWaitingListAppointment.order_id.value;
	var pref_surg_date		= document.OTWaitingListAppointment.pref_surg_date.value;

	//alert(pref_surg_date);
	var practitioner_id		= document.OTWaitingListAppointment.practitioner_id.value;
	var practitioner_name	= document.OTWaitingListAppointment.practitioner_name.value;
	if(pref_surg_date == "null")
		pref_surg_date ="";
	if(practitioner_id == "null")
		practitioner_id="";
	var fpp_yn	= document.OTWaitingListAppointment.fpp_yn.value;   //37051
	var fpp_category	= document.OTWaitingListAppointment.fpp_category.value;   //37051
	
 	var retVal 				= ""
	var dialogHeight 		= "38" ;
	var dialogWidth  		= "50" ;
	var dialogTop    		= "200";
	var dialogLeft			= "100" 
	var center				= "1" ;
	var status 				= "no";
	var arguments			= "";
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=auto; status:no";
	var finalString			= "orderid="+order_id+"&surgeonCode="+escape(practitioner_id)+"&prefDate="+escape(pref_surg_date)+"&funflag=2&booking_called_from=OR&surgeonName="+escape(practitioner_name);		
	// change the file name for the OT Appointment.
	finalString	+= "&fpp_yn="+fpp_yn+"&fpp_category="+fpp_category;  //37051 Start.
	retVal					= await window.showModalDialog("../../eOT/jsp/CalendarModalFrame.jsp?"+finalString,arguments,features);
	//parent.window.close();  //close the existing one

    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
 } 	// End of bookOTAppointment


function  callOTwaitingList(){ // Call a procedure on click of the Waiting List
	var order_id			= document.OTWaitingListAppointment.order_id.value;
	var pref_surg_date		= document.OTWaitingListAppointment.pref_surg_date.value;
	var practitioner_id		= document.OTWaitingListAppointment.practitioner_id.value;
	var practitioner_name	= document.OTWaitingListAppointment.practitioner_name.value;
	var finalString			= "order_id="+order_id+"&practitioner_id="+escape(practitioner_id)+"&pref_surg_date="+escape(pref_surg_date)+"&practitioner_name="+escape(practitioner_name);	
 	//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc = "";
		xmlStr				= "<root><SEARCH " ;
		xmlStr				+=" /></root>" ;
		//alert(xmlStr);
  		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryOTWaitingList.jsp?"+finalString, false ) ;
		xmlHttp.send( xmlDoc ) ;
 		responseText=xmlHttp.responseText ;
		//alert(responseText);
	    eval(responseText);

//	parent.window.close();  //close the existing one
 const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
} 	// End of bookOTAppointment

// Display the OT Waitint List Error, if the procedure is throwing any error
function displayOTWaitingError(error){	// (Called from OrderEntryOTWaitingList.jsp)
	alert(error)
}	// End of displayOTWaitingError

// Code from OA Module
//37051 Start.
//function OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,module_id,resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc){
async function OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,module_id,resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc,fpp_yn,fpp_category){
//37051 End.
		var referral_id = ""; //passed as null from OR
		var condition	=  "i_practitioner_id="//+ordering_practitioner;
			 condition	+= "&patient_id="+patient_id+"&i_clinic_code="//+location_code;
			condition	+= "&clinic_code="+clinic_code+"&recall_date="+start_date_time;
			condition	+= "&location_code="+location_code+"&care_locn_ind="+location_type;
			//condition	+= "&specialty_code=&selectedPractId="//+ordering_practitioner;
			condition	+= "&specialty_code="+specialty_code+"&selectedPractId="//+ordering_practitioner;
			condition	+= "&selectedLocnCode=&referral_id="; 
			condition	+= "&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code; 
			condition	+= "&callingMode=OR&from_AE=N&module_id="+module_id+"&resource_class="+resource_class+"&practitioner_id="+practitioner_id+"&quer_date_end="+quer_date_end+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&order_category="+order_id.substring(0,2);
			condition	+= "&fpp_yn="+fpp_yn+"&fpp_category="+fpp_category; //37051
			
  			var retVal 			= ""
  			var returnVal 			= ""
			var dialogHeight 	= "40" ;
			var dialogWidth  	= "50" ;
			var dialogTop    	= "100";
			var dialogLeft		= "100" ;
			var status 			= "no";
			var arguments		= "";
			var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
			//alert('condition :' +condition);
			retVal				= await window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?"+condition,arguments,features);
			
			if(retVal != null && retVal != "")
			{
				var Val				= retVal.split("^");
				var mode			= Val[0];
				var oa_query_string	= Val[1];
				oa_query_string		+= "&title="+getLabel("Common.bookappointment.label","Common"); 
				
				if (mode=="1"){
					returnVal		= await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+oa_query_string,arguments,features);
					if((returnVal != null && returnVal != "")){
						var Val1		= returnVal.split("^");
						var mode1		= Val1[0];
						if (mode1=="1"){
							//37051 Start.
							//OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,module_id,resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc);
							await OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,module_id,resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc,fpp_yn,fpp_category);
							//37051 End.
						}
					}
				} else if (mode=="2"){
					returnVal		=await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+oa_query_string,arguments,features);;OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,module_id,resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc);
					if((returnVal != null && returnVal != "")){
						var Val1		= returnVal.split("^");
						var mode1		= Val1[0];
						if (mode1=="1"){
							//37051 Start.
							//OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,module_id,resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc);
							await OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,module_id,resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc,fpp_yn,fpp_category);
							//37051 End.
						}
					}
				} else if (mode=="3"){
					returnVal		= await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+oa_query_string,arguments,features);
					if((returnVal != null && returnVal != "")){
						var Val1		= returnVal.split("^");
						var mode1		= Val1[0];
						if (mode1=="1"){
							//37051 Start.
							//OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,module_id,resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc);
							await OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,module_id,resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc,fpp_yn,fpp_category);
							//37051 End.
						}
					}
				}
								
			
				if(	returnVal != undefined  && returnVal.length > 16 && returnVal != "")
				{
					var result	= returnVal.split("*");
					if(result.length==3){//Added on 15/03/2010 By sudhakar for IN019794
					}else{
					//alert("Val========================="+returnVal);
					var  returnOA=	 returnVal.split("&");
					var  location_type =returnOA[2].substring(returnOA[2].indexOf("=")+1,returnOA[2].length) ;
					var  specialty_code	=returnOA[3].substring(returnOA[3].indexOf("=")+1,returnOA[3].length) ;
					var  practitioner_id= returnOA[4].substring(returnOA[4].indexOf("=")+1,returnOA[4].length) ;
					var  clinic_code=returnOA[5].substring(returnOA[5].indexOf("=")+1,returnOA[5].length) ;
					var  resource_class=returnOA[6].substring(returnOA[6].indexOf("=")+1,returnOA[6].length) ;
					var  quer_date_end=returnOA[9].substring(returnOA[9].indexOf("=")+1,returnOA[9].length) ;
					 var  no_dwm=returnOA[11].substring(returnOA[11].indexOf("=")+1,returnOA[11].length) ;
					 var  visittype=returnOA[12].substring(returnOA[12].indexOf("=")+1,returnOA[12].length) ;
					 var  dwm_desc=returnOA[13].substring(returnOA[13].indexOf("=")+1,returnOA[13].length) ;
					/*alert("clinic_code"+clinic_code) ;
						alert("resource_class"+resource_class);
						alert("quer_date_end"+quer_date_end);*/
					//if(returnVal=="OP")
					//{ 
						//37051 Start.
						//OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,"OA",resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc)
						await OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time,"OA",resource_class,clinic_code,practitioner_id,quer_date_end,no_dwm,visittype,dwm_desc,fpp_yn,fpp_category)
						//37051 End.
					//}
					/*else if(returnVal != null && returnVal != "")
					{
						var result	= returnVal.split("*");
						if(result[0] != "OP")
						{
							var ApptNo		= result[0];
							//eval("document.getElementById("apptLabel")"+i).innerText	= ApptNo;
							//parent.frames[0].document.forms[0].Refresh.onclick();
						}
					} // End of else */
					}
				} // End of returnVal
					
			} // End of retVal
} // End of  OABookAppointment
	
// displays an alert message if any error is thrown.
function callRDAlert(error_message){
	if(error_message!=null)
		alert(error_message);
} // End of callRDAlert

// Get an Confirmation for RD(if RD is installed), in the forms
//IN045109 starts
//function getRDAppointmentConfirm(bean_id, bean_name, patient_id, performing_dept_loc_code, catalog_code_dc){
function getRDAppointmentConfirm(bean_id, bean_name, patient_id, performing_dept_loc_code, catalog_code_dc,performing_facility_id){
//IN045109 ends

	var rd_appt_confirm = window.confirm(getMessage("BOOK_APPT_CATALOG","OR") +" "+ catalog_code_dc +"?");
	func_mode				= "CALL_RD_INSTAL_APPT";   
	if(rd_appt_confirm)
	{	
		var query_string		= "bean_id=" + bean_id + "&bean_name="+ bean_name;
		query_string			+= "&func_mode="+func_mode;

		//IN045109 starts		
		query_string			+= "&performing_facility_id="+performing_facility_id;
		//IN045109 ends
 	 	
		//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc = "";
		xmlStr					= "<root><SEARCH " ;
		xmlStr					+= "patient_id=\"" + patient_id +"\" ";
		xmlStr					+= "performing_dept_loc_code=\"" +  performing_dept_loc_code +"\" ";
		xmlStr					+=" /></root>" ;
  		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
 		xmlHttp.open( "POST", "OrderEntryBookingAppointment.jsp?"+query_string, false ) ;
		xmlHttp.send( xmlDoc ) ;
 		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}

} // End of getRDAppointmentConfirm

// Call an Appointment for RD(if RD is installed), in the forms
async function callRDAppointment(build_form_string){
	//, catalog_code_dc
//	var rd_appt_confirm = window.confirm(getOrMessage("BOOK_APPT_CATALOG") +" "+ catalog_code_dc +"?");
//	if(rd_appt_confirm)
//	{		
		var retVal 			= ""
		var dialogHeight 	= "38" ;
		var dialogWidth  	= "50" ;
		var dialogTop    	= "200";
		var dialogLeft		= "100" 
		var center			= "1" ;
		var status 			= "no";
		var arguments		= "";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=auto; status:no";
 		retVal				= await window.showModalDialog("../../eOR/jsp/OrderEntryRDBookingAppointment.jsp?"+build_form_string,arguments,features);
 	 //	} 
} // End of callRDAppointment
/*function PharmacyDetails(){

	var	formObj	 	 	 	=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	var headerformObj	 	=  parent.criteriaMainFrame.document.placeOrderHeaderForm ;
	var buttonObj	 		=  parent.criteriaDetailFrame.document.buttonForm;
	var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;

	var bean_id				= formObj.bean_id.value;
	var bean_name			= formObj.bean_name.value;
	xmlStr					= "<root><SEARCH " ;
	for(var i=0;i<formObj.length;i++)
	{
		xmlStr+= formObj[i].name+"=\"" + checkSpl(formObj[i].value) + "\" " ;
 	} // End of for
	xmlStr	+=" /></root>" ;
 	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PHOrderSetController.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=PH_ORDER_SET_VALUES", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
} // End of PharmacyDetails

	
function loadPharmacyWin(bean_id, bean_name){
 
	var condition					= "";
	var retVal 						= ""
	var dialogHeight 				= "22" ;
	var dialogWidth  				= "40" ;
	var dialogTop    				= "150";
	var status 						= "no";
	var arguments					= "";
	var features					= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal							= window.showModalDialog("../../eOR/jsp/PHOrderSetDetailsFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name ,arguments,features);
} // End of loadPharmacyWin	

// when closing the window for the PH Details
function closePhWindow(){
	var formObj	 		=  parent.phOrderSetDtls.document.PHDetails;
 	// Submit to the controller to set the values
	var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;

	var bean_id				= formObj.bean_id.value;
	var bean_name			= formObj.bean_name.value;
 	xmlStr					= "<root><SEARCH " ;
	for(var i=0;i<formObj.length;i++)
	{
		xmlStr+= formObj[i].name+"=\"" + checkSpl(formObj[i].value) + "\" " ;
 	} // End of for
	xmlStr	+=" /></root>" ;
  	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PHOrderSetController.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=PH_ORDER_UPDATE_VALUES", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	window.close();
}
*/
function changeDosage(obj, row){
	strength_value = eval("document.placeOrderForm.strength_value"+row+".value");
	quantity	   = eval("document.placeOrderForm.quantity"+row+".value");	
 	 if(obj.value=="A") {
 		eval("document.placeOrderForm.dosage_id"+row+".innerHTML = 'Absolute' ");
		eval("document.placeOrderForm.dosage"+row+".value = '' ");
	 } else if(obj.value=="S") {
		eval("document.placeOrderForm.dosage_id"+row+".innerHTML = 'Strength' ");
		eval("document.placeOrderForm.dosage"+row+".value = strength_value ");
		populateUOM(row);
	 } else if(obj.value=="Q") {
		eval("document.placeOrderForm.dosage_id"+row+".innerHTML = 'Dose' ");
		eval("document.placeOrderForm.dosage"+row+".value = quantity ");
		populateUOM(row);
	 }
} // End of changeDosage

// Population of the UOM on change of the Dosage By (quantity or strength )
function populateUOM(row){
	var formObj	 		=  document.placeOrderForm;
	var localeName      = document.placeOrderForm.localeName.value;
 	// Submit to the controller to set the values
	//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc = "";
	var bean_id				= formObj.bean_id.value;
	var bean_name			= formObj.bean_name.value;
	var form_code			= eval("document.placeOrderForm.form_code"+row+".value");
	var dosage_by			= eval("document.placeOrderForm.dosage_by"+row+".value");
	var strength_uom_desc	= eval("document.placeOrderForm.strength_uom_desc"+row+".value");
	
 	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "form_code=\"" + form_code +"\" ";
	xmlStr					+= "dosage_by=\"" + dosage_by +"\" ";
	xmlStr					+= "strength_uom_desc=\"" +strength_uom_desc +"\" ";
	xmlStr					+= "row=\"" +row +"\" ";
	xmlStr	+=" /></root>" ;
  	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryPHValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=PH_POPULATE_UOM&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}

// To clear the list box UOM 
function clearUOMList( form_name, row ) {
	var len = eval(form_name+".uom"+row+".options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(form_name+".uom"+row+".remove(\"uom\")") ;
	}
	var tp 		= " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	eval(form_name+".uom"+row+".add(opt)") ;
} // End of clearUOMList

// To add in the List box UOM
function addUOMList(form_name,row, code,value) {
	var element 	= document.createElement('OPTION') ;
	element.value 	=  code ;
	element.text 	= value ;
	element.selected= true;
	form_name = eval(form_name+".uom"+row);
	form_name.add(element);
} // End of addUOMList
 

// To calculate the dosage for PH
function calculateDosage(row){
		
	var group_order_category = eval("document.placeOrderForm.group_order_category"+row+".value");
	if(group_order_category=="PH") {
	
		var dosage_by = eval("document.placeOrderForm.dosage_by"+row+".value");
		if(dosage_by=="S") {
			strength_value	= eval("document.placeOrderForm.strength_value"+row+".value");
			quantity		= eval("document.placeOrderForm.quantity"+row+".value");
			if(strength_value!=null && strength_value > 0 && quantity!=null && quantity > 0){
 				eval("document.placeOrderForm.dosage"+row+".value =   truncate(quantity*strength_value)  ");
			} // End of if strength_value
		} // End of if dosage_type
	} // End of group_order_category
}// End of calculateDosage

// To calculate the quantity for PH
function calculatePHQuantity(row){
	var group_order_category = eval("document.placeOrderForm.group_order_category"+row+".value");
	if(group_order_category=="PH") {
		var dosage_by = eval("document.placeOrderForm.dosage_by"+row+".value");
		if(dosage_by=="S") {
			strength_value	= eval("document.placeOrderForm.strength_value"+row+".value");
			dosage			= eval("document.placeOrderForm.dosage"+row+".value");
			if(strength_value!=null && strength_value > 0 && dosage!=null && dosage > 0){
				eval("document.placeOrderForm.quantity"+row+".value =  truncate(dosage/strength_value) ");
			} // End of if strength_value
		}// End of if dosage_type
	} // End of group_order_category
}// End of calculatePHQuantity

// Population of the Activity Type in AdditionalSearch, TickSheet, Image and Order care Set In Order Entry
// To populate the Order Type List box, based upon the order - category in addn'. search
function populateActivityType( obj , form_name ) {
		var form_obj			= eval("document."+form_name);
 		var bean_id 			= form_obj.bean_id.value ;
		var localeName          = form_obj.localeName.value;
		var bean_name 			= form_obj.bean_name.value ;
		var order_category		= form_obj.order_category.value ;
 		//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc = "";
 		xmlStr					= "<root><SEARCH " ;
		xmlStr 					+= "order_category=\""+ order_category +"\" " ;
		xmlStr 					+= "order_type_code=\""+obj.value+"\" " ;
		xmlStr 					+= "form_name=\""+form_name+"\" " ;
		xmlStr 					+=" /></root>" ;
  		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&func_mode=ACTIVITY_TYPE_POPULATE&localeName="+localeName , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval( responseText ) ;
} // End of populateActivityType

// Truncate to two digits
function truncate(number){
	var str = number + "";
 	if(str.indexOf(".") != -1) {
		dot = str.length - str.indexOf(".");
		if(dot>2){
			str = str.substring(0, str.length-dot+3);
		} else {
			str= str+"0";
		}
	} // End of  if
	if(str!=null)
		str = str.substring(0,7);
	return str;
}

