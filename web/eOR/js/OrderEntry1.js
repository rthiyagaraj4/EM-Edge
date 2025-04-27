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
22/6/2011     101            Chowminya      Incident No: IN027797 - <Clinical comments, order format not shown in 
																	the view mode> 
11/08/2011	  IN00747		 Chowminya		Incident No: IN00747 - <Clinical comments mandatory check in Preview  
																	 mode> 		
12/10/2011	  IN029202		 Chowminya		Incident No: IN029202 - <Clinical comments thai data shown incorrectly>
12/11/2013	  IN045005		 Chowminya		LMP Date validation issue
08/01/2014	  IN044757		 Vijayakumar K	Clinical comments displayed as hyper link at result-Completed stage, even though clinical 
											comments  not recorded while placing the order.
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
01/08/2014	  IN049133	   	 Chowminya												CRF:Disallow user to enter the future date in the LMP date field
30/07/2015	  IN037472		 Karthi													[SRR20056-SCF-9377] , [SRR20056-SCF-9373 ] - IN037471			
01/11/2016	  IN060565		 Raja S													ML-MMOH-SCF-0412
30/11/2016	  IN062319	     Karthi L													ML-MMOH-CRF-0508.1 [IN062319]		
13/12/2016	  IN062834		 Karthi													ML-MMOH-CRF-0508.1/02- System does not Clear the values when Cancel button is pressed in Order Format Window 
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
24/05/2019	 IN070534		Prakash C			24/05/2019	Ramesh G        BSP-SCF-0068
27/05/2019    IN068553     Ramya Maddena  06/06/2019    Ramesh G    	    GHL-CRF-0554
28/04/2020	  IN072511		Durga				28/04/2020	Ramesh G				MO-GN-5552
-----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
//var flagchecking="correct";
// On click of the Blood Transfusion hyperlink, History is displayed
async function callBloodHistory()
{
	var patient_id      = document.formTab.patient_id.value;
	var encounter_id	= document.formTab.encounter_id.value;
	var finalString		= "patient_id="+patient_id+"&encounter_id="+encounter_id
	var retVal 			= new String();
	var dialogHeight 	= "25" ;
	var dialogWidth  	= "50" ;
	var dialogTop    	= "170";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal				= await window.showModalDialog("../../eOR/jsp/OrderEntryBloodTransfusionFrameset.jsp?"+finalString,arguments,features);
} // End of callBloodHistory

// On Blur if the field mnemonic is same and no value entered, it will copy the value to those  filed mnemonic
function copySameMnemonic(obj,field_mnemonic,val) // Added to copy the text box value if it is of same mnemonic
{	
	var set=true;
   //if(obj.value!="")
   //{
    	while(field_mnemonic.indexOf('|')!=-1)
    	{
    		field_mnemonic 		= field_mnemonic.replace('|','\'');
    	}
		field_mnemonic			+= "ORDERFORMAT";
  
    	var form_obj 			= parent.OrderFormat.document.OrderFormatForm;
    	row_count 				= form_obj.row_count.value;
    	for(var i=0; i<row_count; i++)
		{
			if(eval("form_obj.field_validation"+i))
			{
				field_val		= eval("form_obj.field_validation"+i+".value")
 
				//if(eval("form_obj."+field_val)) incase of the  special characters this fails.
				if(parent.OrderFormat.document.getElementById(field_val))
				{
					//field_name	= eval("form_obj."+field_val+".name");
					
					var form = parent.OrderFormat.document.getElementById("OrderFormatForm");
					field_name	= form[field_val].name;
					if(set)
					{			
						form[field_val].name=field_val;
						field_name=form[field_val].name;
					}
					if(obj.value!="")
					{
						//alert("field_name"+field_name);
					if(field_name.indexOf(field_mnemonic)!=-1)
					{
					//alert(eval("parent.OrderFormat.document.OrderFormatForm."+field_name+".value"))
					 	if(form[field_name].value == "") {
 							form[field_name].name = obj.value;
						}
					
					//	if(eval("form_obj."+field_name+".value")=="") {
 					//		eval("form_obj."+field_name+".value= obj.value");
 					//	}
					}
				}
			}
		} // End of for i
	}	// End of obj.value
	set=false;
} // End of function copySameMnemonic

// On Blur if the field mnemonic is PRE_OP_DAYS then prefer_surgery_Date - Pre_op_days , u should default it to that day AdmissionDate
// It should not less than the sysdate 
function calculateAdmissionDate(obj, field_obj, sys_date_obj){
	
	var pre_op_days					= obj.value;
  	if(pre_op_days!=null && pre_op_days > 0)
	{
		var form_obj 				= document.OrderFormatForm
		var formObj					= "document.OrderFormatForm."
  		var pref_surg_date			= field_obj.replace("PRE_OP_DAYS","PREF_SURG_DATE");
		//alert("pref_surg_date"+pref_surg_date);
		var admission_surg_date		= field_obj.replace("PRE_OP_DAYS","ADMISSION_DATE");
		//alert("admission_surg_date"+admission_surg_date);
   		var pref_surg_date_value	= "";
		var pref_surg_date_name		= "";
 		var admission_surg_date_name= "";
  		for(var i=0;i<form_obj.length;i++)	//To get the concerned Perform Team Surgeon
		{
			if(form_obj[i].type=="text") // For Text box
			{
 				if(form_obj[i].name.indexOf(pref_surg_date)!=-1 )
				{  // clear the value
					pref_surg_date_name  = form_obj[i].name;
					pref_surg_date_value = form_obj[i].value; 
					break; // come out of the loop because only one pref_surg_date will be there for the order_type
 				}
			} // End of if form_obj[i].type
 		} // End of for i
 		for(var j=0;j<form_obj.length;j++)	//To get the concerned Admission Date & object
		{
			 if(form_obj[j].type=="text") // For Text box
			{//alert(form_obj[j].name);
				if(form_obj[j].name.indexOf(admission_surg_date)!=-1 )
				{  // clear the value
				
					admission_surg_date_name	= form_obj[j].name;
  					break; // come out of the loop because only one pref_surg_date will be there for the order_type
				}
			} // End of if form_obj[i].type
		} // End of for i
 		if(pref_surg_date_value!=null && pref_surg_date_value!= "" && pre_op_days!=null && pre_op_days!="")
		{   // call a method to calculate the date after subtracting
			return checkAdmissionDate(formObj, pref_surg_date_value, pref_surg_date_name, admission_surg_date_name, sys_date_obj, pre_op_days);
		} // End of pref_surg_date_value!=null &&  pre_op_days!=null
	} // End of pre_op_days!=null
} // End of calculateAdmissionDate

// On Blur if the field mnemonic is PREF_SURGERY_DATE then prefer_surgery_Date - ADMISSION_DATE , u should default it to that day 
// It should not less than the sysdate 
 function calculatePreOpDays(obj, field_obj, field_mnemonic){
 	if(obj.value!=null && obj.value!="")
	{
		var form_obj 				= document.OrderFormatForm
		var formObj					= "document.OrderFormatForm."
		var pre_op_days				= "";
		var admission_surg_date		= "";
		var pref_surg_date_value	= "";
		var pref_surg_date			= "";
		var admission_date_value	= "";
		var pre_op_days_name		= "";
		if(field_mnemonic=="PREF_SURG_DATE") { 
			pref_surg_date_value	= obj.value;
			pre_op_days				= field_obj.replace("PREF_SURG_DATE","PRE_OP_DAYS"); 
			admission_surg_date		= field_obj.replace("PREF_SURG_DATE","ADMISSION_DATE"); 
		} else {	// For Admission Date
			admission_date_value	= obj.value;	
			pre_op_days				= field_obj.replace("ADMISSION_DATE","PRE_OP_DAYS"); 
			pref_surg_date			= field_obj.replace("ADMISSION_DATE","PREF_SURG_DATE"); 
 		}
   		
 		if(field_mnemonic=="PREF_SURG_DATE") { 
  			for(var i=0;i<form_obj.length;i++)	//To get the concerned Admission Date & object
			{
				 if(form_obj[i].type=="text") // For Text box
				{
					if(form_obj[i].name.indexOf(admission_surg_date)!=-1 )
					{  // clear the value
  						admission_date_value		= form_obj[i].value;
 						break; // come out of the loop because only one pref_surg_date will be there for the order_type
					}
				} // End of if form_obj[i].type
			} // End of for i
		} // End of if field_mnemonic=PREF_SURG_DATE
		else  // for Admission Date changes then get the object for pref_surg_date
		{
			for(var j=0;j<form_obj.length;j++)	//To get the concerned Admission Date & object
			{
				 if(form_obj[j].type=="text") // For Text box
				{
					if(form_obj[j].name.indexOf(pref_surg_date)!=-1 )
					{  // clear the value
 						pref_surg_date_value		= form_obj[j].value;
 						break; // come out of the loop because only one pref_surg_date will be there for the order_type
					}
				} // End of if form_obj[i].type
			} // End of for i
		}
		for(var k=0;k<form_obj.length;k++)	//To get the concerned pre_op_days & object
		{
			 if(form_obj[k].type=="text") // For Text box
			{
				if(form_obj[k].name.indexOf(pre_op_days)!=-1 )
				{  // clear the value
					pre_op_days_name			= form_obj[k].name;
  					break; // come out of the loop because only one pre_op_days will be there for the order_type
				}
			} // End of if form_obj[i].type
		} // End of for i
   		if(pref_surg_date_value!=null && pref_surg_date_value!= "" && admission_date_value!=null && admission_date_value!=""&&pre_op_days_name!=null && pre_op_days_name!= "" &&pre_op_days!=null && pre_op_days!="")
		{   // call a method to calculate the date after subtracting
			return calculatePreOpDaysValue(form_obj, pref_surg_date_value, admission_date_value, pre_op_days_name, pre_op_days);
		} // End of pref_surg_date_value!=null &&  pre_op_days!=null
	} // End of pref_surg_date!=null
 } // End of calculatePreOpDays

 function calculatePreOpDaysValue(form_obj, pref_surg_date_value, admission_date_value,  pre_op_days_name, pre_op_days){
 	  var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
 		xmlStr 			+= "pref_surg_date_value=\""+ checkSpl(pref_surg_date_value) +"\" " ;
		xmlStr 			+= "admission_date_value=\""+ checkSpl(admission_date_value) +"\" " ;
		xmlStr 			+= "pre_op_days_name=\""+ checkSpl(pre_op_days_name) +"\" " ;
		
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + form_obj.bean_id.value + "&bean_name="+ form_obj.bean_name.value +"&func_mode=CALCULATE_PRE_OP_DAYS", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ; 
  } // End of calculatePreOpDaysValue

 function preOPDays(pre_op_days, pre_op_days_name){
	 if(pre_op_days!=null && pre_op_days!="" &&  pre_op_days>0)
		eval("document.OrderFormatForm."+pre_op_days_name+".value=pre_op_days")
 } // End of preOPDays

function prefAdmissionDate(obj_value,pre_op_days) {
	datearray 			= obj_value.split("/");
	var dt 				= new Date(datearray[2],datearray[1]-1,datearray[0]) // Without date
	var day 			= dt.getDate();
	day 				= parseInt(day) - parseInt(pre_op_days); // Subtract the Pref_surg_date with pre_op_days
	date				= dt.setDate(day);
	date				= new Date(date);
	dtString			= buildDateWithoutHrsMin(date);
	return dtString;
} // End of prefAdmissionDate

// to do the calculation
function checkAdmissionDate(formObj, pref_surg_date_value, pref_surg_date_name, admission_surg_date_name ,sys_date_obj, pre_op_days){
	
  	if(pre_op_days!="")
	{		
		dtString						= prefAdmissionDate(pref_surg_date_value, pre_op_days); // Will subtract from the pre_op_days and give the date
		if(admission_surg_date_name!="")
		{
  		admission_surg_date_name		= eval(formObj+admission_surg_date_name);
 		if(doDateCheckAlert(sys_date_obj,admission_surg_date_name)==false) // Date should not be lesser than sysdate.
		{
			admission_surg_date_name.value = "";
			admission_surg_date_name.focus();	
			top.message_frame.location.href = "../../eOR/jsp/MstCodeErrorLocalModal.jsp?err_num="+getMessage("ADMISSION_DATE_LESSER_SYSDATE","OR");
			return false;
		}
		else {
 			if(dtString!=null && dtString!="")
				admission_surg_date_name.value = dtString;

			top.message_frame.location.href = "../../eOR/jsp/MstCodeErrorLocalModal.jsp?err_num=";
		}
	}
} // End of checkAdmissionDate
}

function checkValidRange(obj)  // To check the valid range for the numeric and integer
{

	/*if(CheckNum(obj)==false)
	{
		return false;
	}*/
	if(checkIsNull(obj))
		return false;

	var min_max_value = 0;
	var max_num_value = 0;
	var min_max_array = new Array();
	//min_max_value	  = eval("document.OrderFormatForm.min_max"+obj.name).value;
	var form = document.getElementById("OrderFormatForm");
	min_max_value = form["min_max"+obj.name].value;

	//alert("min_max_value"+min_max_value);
	min_max_array	  = min_max_value.split("#");
	min_num_value	  = min_max_array[0];
	max_num_value	  = min_max_array[1];
	entered_value	  = obj.value;
	if(entered_value=="") entered_value = "0";
	if(parseFloat(max_num_value)==0) return false;

	if( parseFloat(entered_value)<parseFloat(min_num_value) || parseFloat(entered_value)>parseFloat(max_num_value) )
	{
		//alert("APP-OR0007 Entered value should be between " +min_num_value+" and "+max_num_value);
		var msg = getMessage("MIN_MAX_VALUE_RANGE",'CA');
		msg=msg.replace('(1)',min_num_value);
		msg=msg.replace('(2)',max_num_value);
		alert(msg);

		
		//var valueMessage = getOrMessage("VALUE_BETWEEN_RANGE")+ min_num_value+" and "+max_num_value;
		//alert(valueMessage); //obj.value = "";
		//obj.select();
		//obj.focus();
		obj.value = "";
		return false;
	}
}  // End of checkValidRange

// Call the common method, if it exceeds, clear and focus
function CheckMax(lab, obj, max, messageFrame)
{
	var txt_name = obj.name;
	var catalogStartIndex = "";//IN64543
	if(txt_name.indexOf("CMTS") == 0){//By default u will have 2000 characters for comments only 500
		lab = "Comments";max = 500;
		catalogStartIndex = txt_name.indexOf("CMTS")+4;//IN64543
	}else if(txt_name.indexOf("PREPS") == 0){
		lab = "Preparatory Instruction";
		catalogStartIndex = txt_name.indexOf("PREPS")+5;//IN64543
	}else if(txt_name.indexOf("DEPT") == 0){
		lab = "Department Instruction";
		catalogStartIndex = txt_name.indexOf("DEPT")+4;//IN64543
	}else if(txt_name.indexOf("PATIENT")==0){
		lab = "Patient Instruction";
		catalogStartIndex = txt_name.indexOf("PATIENT")+7;//IN64543
	}
	
	//IN64543, starts
	//IN070534 starts		
	//var catalog_code = txt_name.substring(catalogStartIndex);
	var catalog_code = (txt_name.substring(catalogStartIndex)).replace('\.','_');
	//IN070534 ends	
	//IN072511 Start.
	//if(eval("parent.OrderFormat.document.getElementById("instrn_content_type")"+catalog_code).value == 'E')
	if(eval("parent.OrderFormat.document.getElementById(\"instrn_content_type"+catalog_code+"\")").value == 'E'){
	//IN072511 End.
		return true;
	}
	//IN64543, ends
		
	if(CheckMaxLen(lab, obj, max, messageFrame))
	  return true;
	else
	{
		//obj.value = "";
		obj.select();
		return false;
	}
} // End of CheckMax
function checkMaxLimit1(obj,maxSize) {
	var txt_name = obj.name;
	if(txt_name.indexOf("CMTS") == 0){//By default u will have 2000 characters for comments only 500
		lab = "Comments";maxSize = 500;
	}else if(txt_name.indexOf("PREPS") == 0){
		lab = "Preparatory Instruction";
	}else if(txt_name.indexOf("DEPT") == 0){
		lab = "Department Instruction";
	}else if(txt_name.indexOf("PATIENT")==0){
		lab = "Patient Instruction";
	}
	checkMaxLimit(obj,maxSize);
}
function callCheckDate(dateObj, field_mnemonic, field_obj, sys_date) // To check for the valid date
{
	var loc= document.OrderFormatForm.localeName.value;  //[IN031257]
	if(dateObj.value!="")
	{
		// [IN031257] Start
		var format_date = dateObj.value ;
		if(loc!='en')
		{
			//format_date	=	 convertDate(format_date,'DMYHM',loc,"en");//IN049133
			format_date	=	 convertDate(format_date,'DMY',loc,"en");//IN049133
		}
		// [IN031257] End
		while(field_mnemonic.indexOf('|')!=-1)
    	{
    		field_mnemonic 		= field_mnemonic.replace('|','\'');
    	}
		// [IN031257] if(CheckDate(format_date)==false)
		if(CheckDate(format_date)==false)
		{	
			//IN045005 - Start
			dateObj.value = "";
			dateObj.select();
			dateObj.focus();
			//IN045005 - End
			//flagchecking="notcorrect";
			return false;	
		}
		/*else
		{
			flagchecking="correct";
		}*/
/*		if(field_mnemonic=="PREF_SURG_DATE") // Field Mnemonic in OT
		{

			var form_obj 				= document.OrderFormatForm
			var formObj					= "document.OrderFormatForm.field_type"
			var pre_op_days				= field_obj.replace("PREF_SURG_DATE","PRE_OP_DAYS");
			var admission_surg_date_name= field_obj.replace("PREF_SURG_DATE","ADMISSION_DATE"); 
  			var pre_op_days_value		= "";
			var pre_op_days_name		= "";
 			for(var i=0;i<form_obj.length;i++)	//To get the concerned pre_op_days
			{
				 if(form_obj[i].type=="text") // For Text box
				 {
  					 if(form_obj[i].name.indexOf(pre_op_days)!=-1 )
					 {  // Get the  value 
 						pre_op_days_value	 = form_obj[i].value;	
						break; // come out of the loop because only one pre_op_days will be there for the order_type
					 }
				 } // End of if form_obj[i].type
			} // End of for i
  			for(var i=0;i<form_obj.length;i++)	//To get the concerned Admission Date & object
			{
				 if(form_obj[i].type=="text") // For Text box
				{
 					if(form_obj[i].name.indexOf(admission_surg_date_name)!=-1 )
					{  // clear the value
						admission_surg_date_name	= form_obj[i].name;
 						break; // come out of the loop because only one pref_surg_date will be there for the order_type
					}
				} // End of if form_obj[i].type
			} // End of for i

   			//if(dateObj.value!="")
			//	return checkAdmissionDate(formObj, dateObj.value, dateObj.name, admission_surg_date_name, sys_date, pre_op_days_value);
		} // End of  field_mnemonic PREF_SURG_DATE
*/
	} // End of dateObj.value
} // End of callCheckDate

function callCheckDateTime(dateTimeObj) //To check for the date and time
{
	l_locale = document.getElementById("localeName").value; //SRR20056-SCF-9377 [IN037472] - [SRR20056-SCF-9373 ] - IN037471			
	
	if(checkIsNull(dateTimeObj))
	{
		return false;
	}
	if(validateDateObj(dateTimeObj,"DMYHM",l_locale)==false) //SRR20056-SCF-9377 [IN037472] - [SRR20056-SCF-9373 ] - IN037471			

	//if(doDateTimeChk(dateTimeObj)==false)
	{
		dateTimeObj.select();
		dateTimeObj.value = "";
		dateTimeObj.focus();
		top.message_frame.location.href = "../../eOR/jsp/MstCodeErrorLocalModal.jsp?err_num="+getMessage("INVALID_DATE_TIME_FMT","OR");
		//flagchecking="notcorrect";
 		return false;
	}
	else
	{
		//flagchecking="correct";
		top.message_frame.location.href = "../../eOR/jsp/MstCodeErrorLocalModal.jsp";
	}
} // End of callCheckDateTime

function callCheckTime(timeObj) //To check for the time
{
	if(checkIsNull(timeObj))
	{
		//top.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		return false;
	}
	if(chkTime(timeObj.value)==false)
	{
		timeObj.value = "";
		timeObj.select();
		timeObj.focus();
		top.message_frame.location.href = "../../eOR/jsp/MstCodeErrorLocalModal.jsp?err_num="+getMessage("INVALID_TIME_FMT","OR");
		return false;
	}
	else
	{
		top.message_frame.location.href = "../../eOR/jsp/MstCodeErrorLocalModal.jsp";
	}
} // End of callCheckTime

function checkIsNull(obj)  // To check for the Null
{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
} // End of checkIsNull


function recordOrderFormatValues() // on click of the Ok button
{	
	form_obj					= parent.OrderFormat.document.OrderFormatForm;
	form_obj.close_yn.value		="Y"; // not to remove the contents from the bean
 	var mandatory_fields 		= form_obj.mandatory_fields.value;
	var mandatory_names  		= form_obj.mandatory_names.value;
	var list_item_fields 		= form_obj.list_item_fields.value;
	var field_mnemonic_fields  	= form_obj.field_mnemonic_fields.value;
 	var lab_install_yn  		= form_obj.lab_install_yn.value;
    var label_text 				= form_obj.label_text_value.value;
	var ord_formt_multi_chk_nonmand_yn	= form_obj.ord_formt_multi_chk_nonmand_yn.value;

   	var fields			 		= new Array();
	var names 			 		= new Array();
//	var field_mnemonic 	 		= new Array();
	var arrVal			 		= null;
	//if(lab_install_yn=="Y")changed on 7/3/2007
	//{
		
 		if(field_mnemonic_fields.length>0 && list_item_fields.length>0)
		{
			var arr_field_mnemonic	=	field_mnemonic_fields.split("$");			
			var list_item_value		=	list_item_fields.split("$");
			var label_text_value	=   label_text.split("$");				
			var lab_install_yn_value	=   lab_install_yn.split("$");
			
   			// Check only for Request Comments..Value should not be same
 			for(var i=0; i<arr_field_mnemonic.length; i++)
			{
				for(var j=i+1;j<arr_field_mnemonic.length;j++)
				{
					if(lab_install_yn_value[i]=="Y"){//added on 7/3/2007
					if(arr_field_mnemonic[i]==arr_field_mnemonic[j])
					{
						arr_fields_name		= eval("parent.OrderFormat.document.OrderFormatForm."+list_item_value[i]+".name")
						arr_fields_value	= eval("parent.OrderFormat.document.OrderFormatForm."+list_item_value[i]+".value")
						arr_fields_name1	= eval("parent.OrderFormat.document.OrderFormatForm."+list_item_value[j]+".name")
						arr_fields_value1	= eval("parent.OrderFormat.document.OrderFormatForm."+list_item_value[j]+".value")
						// don't check for the duplicate check for these field mnenomics ANATOMY_SITE, FIXATIVE, TISSUE_DESC
						if(arr_fields_value!="" && arr_fields_value1!="" && (arr_field_mnemonic[i].indexOf("ANATOMY_SITE")!=-1)  && (arr_field_mnemonic[i].indexOf("FIXATIVE")!=-1) && (arr_field_mnemonic[i].indexOf("TISSUE_DESC")!=-1) )
						{
							if(arr_fields_value==arr_fields_value1)
							{
								alert(getMessage("DUPLICATE_FIELD_MNEMONIC","OR")+label_text_value[i]);
								return false;
							}
						}
					}
				}//added on 7/3/2007 for Lab_install_yn
				}
				//alert(duplicateExists)
			} // End of for var i=0
		} // End of field_mnemonic_fields
	//} //End of Lab_install_yn
	//} 
	 if(mandatory_fields.length>0)
	{	
 		var arr_mandatory_fields	=	mandatory_fields.split("#");
		var arr_mandatory_names		=	mandatory_names.split("#");
		for(var i=0; i<arr_mandatory_fields.length; i++)
		{
 			//if(eval("parent.OrderFormat.document.OrderFormatForm."+arr_mandatory_fields[i])) {
			var form = parent.OrderFormat.document.getElementById("OrderFormatForm"); 
			if(form[arr_mandatory_fields[i]]) 
			{
		  		//fields[i] = eval("parent.OrderFormat.document.OrderFormatForm."+arr_mandatory_fields[i]);
				if(arr_mandatory_fields[i].indexOf("REQUEST_COMMENT")!=-1)
				{	
					var name_field_value=arr_mandatory_fields[i];
					name_field_value=name_field_value+"_request_comment_oth_desc";
					var name_field_value_chk=arr_mandatory_fields[i]+"_request_comment_chkbox";
					if(form[name_field_value_chk])
					{
						if(form[name_field_value_chk].checked==true)
						{	
							fields[i] = form[name_field_value]; 
						}
						else
						{
							fields[i] = form[arr_mandatory_fields[i]]; 
						}
					}
					else
					{
						fields[i] = form[arr_mandatory_fields[i]]; 
					}

				}
				else
				{
		  			fields[i] = form[arr_mandatory_fields[i]]; 
				}
				names[i]  = arr_mandatory_names[i];
				//alert(fields+names);
			}
 		}
 		//if(checkFields(fields,names,top.message_frame)==false)
		if(checkFormatFields(fields,names,top.message_frame)==false)
		{
 /*			if(form_obj.chk_mand.value=="RECORD") //Then increase the size to show the user to enter the mandatorily fields
			{
				parent.dialogHeight   = "29" ;
				parent.dialogWidth    = "52" ;
				parent.dialogTop      = "100";
				parent.dialogLeft     = "280";
			}
*/
			form_obj.mandatory_check.value = "N";
 			return false;
		}
		else { 
			form_obj.mandatory_check.value = "Y";
		}	
	}
	else {
		 form_obj.mandatory_check.value = "Y";
	// added to make the disabled value to be passed

	}

	for(var i=0;i<form_obj.length;i++)
	{		
		if(form_obj[i].type == "textarea")
		{
			if(!CheckMax('Comments',form_obj[i],2000,top.message_frame))
				return false;	
		}
		if(form_obj[i].disabled)
	  		form_obj[i].disabled = false;
    } // Till Here 
	//var mode = parent.OrderFormat.document.OrderFormatForm.mode.value; // ML-MMOH-CRF-0508.1
	//parent.OrderFormat.document.OrderFormatForm.mode.value = mode;// ML-MMOH-CRF-0508.1
	parent.OrderFormat.document.OrderFormatForm.method = "POST";
	parent.OrderFormat.document.OrderFormatForm.action = "../../eOR/jsp/OrderEntryOrderFormatControl.jsp";
	parent.OrderFormat.document.OrderFormatForm.submit();
}  // End of recordOrderFormatValues

// Header-->toolbar frame is not there and to avoid duplication of the common...
// Since using the common method, will call the common\error.jsp where it will try to load
// the toolbar frame, and will give script error......
function checkFormatFields( fields, names, messageFrame) 
{
    var errors = "" ;
    var ord_formt_multi_chk_nonmand_yn	= form_obj.ord_formt_multi_chk_nonmand_yn.value;
    var bean_id	=	 form_obj.bean_id.value;
    var bean_name =   form_obj.bean_name.value;
    var isMultiCheckCompPresent = '';
    //alert('625. OrderEntry1.js ' + ord_formt_multi_chk_nonmand_yn + '  ' + bean_id);
    for( var i=0; i<fields.length; i++ ) 
	{
 		if(fields[i]!=null) 
		{
	        if(trimCheck(fields[i].value)) 
			{
				 
		         fields[i].value = trimString(fields[i].value);
			}
	        else 
			{   //errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
	        	
		        	if(ord_formt_multi_chk_nonmand_yn == 'Y'){
		        		isMultiCheckCompPresent = validateMultiSelectComp(fields[i].name, bean_id, bean_name);
		        		isMultiCheckCompPresent = isMultiCheckCompPresent.replace(/^\s+|\s+$/g,'');
						
		        		
		        		if(isMultiCheckCompPresent == 'N'){
			        		if(names[i].indexOf(".")!=-1)
							{
								errors += "APP-000005 " + names[i] + " Cannot be Blank" +"<br>";
							}
							else
							{
								errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
							}
		        		} else if(isMultiCheckCompPresent == '') {
							if(names[i].indexOf(".")!=-1)
							{
								errors += "APP-000005 " + names[i] + " Cannot be Blank" +"<br>";
							}
							else
							{
								errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
							}
						}		
		        	} else {
	        	
		        	if(names[i].indexOf(".")!=-1)
					{
						errors += "APP-000005 " + names[i] + " Cannot be Blank" +"<br>";
					}
					else
					{
						errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
					}
	        	}	
			}
		}
    }
    if ( errors.length != 0 ) 
	{
    parent.message_frame.document.location.href="../../eOR/jsp/MstCodeErrorLocalModal.jsp?err_num="+encodeURIComponent(errors) ;
        return false ;
    }
    addRemValidationBean('ADDTEMPUTILS');
    form_obj.frm_unld_multichk_yn.value = "N";
    return true ;
}  // End of checkFormatFields
//ML-MMOH-CRF-0508.1 [IN062319] 
function validateMultiSelectComp(field_mnemonic_comp, bean_id, bean_name) {
	
	func_mode = 'CHECK_LISTFLD_MNEMONIC_MANDATE';
	
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+= "field_mnemonic_comp=\""+field_mnemonic_comp+"\" " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode="+ func_mode, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText	= xmlHttp.responseText ;
	return responseText	;
	
}
function removeOrderFormatValues()  // on click of the cancel button
{
	var ord_formt_multi_chk_nonmand_yn = parent.OrderFormat.document.OrderFormatForm.ord_formt_multi_chk_nonmand_yn.value; // IN062834 - Start
	var l_frm_unld_multichk_yn = parent.OrderFormat.document.OrderFormatForm.frm_unld_multichk_yn.value;
	if(ord_formt_multi_chk_nonmand_yn == 'Y' && l_frm_unld_multichk_yn == 'Y'){
		//updateDupeMultiSelectBean();
		addRemValidationBean('UPDATETEMPUTILS');
		
	} // IN062834 - End
  /*	if(parent.OrderFormat.document.OrderFormatForm.mode.value=="INSERT")
		removeBeanValues();
	else 
	{*/   //Removed If Else condition IN060565
	  	parent.OrderFormat.document.OrderFormatForm.close_yn.value="Y" // not to remove the contents from the bean
		//window.close();
	  		parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
	/*}*/   //Removed If Else condition IN060565
} // End of removeOrderFormatValues
 function addRemValidationBean(multichk_validate){ // IN062834 - Start
	/*var bean_id = parent.OrderFormat.document.getElementById('bean_id').value;
	var bean_name = parent.OrderFormat.document.getElementById('bean_name').value;
var xmlDoc = ""; 
var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+= "multichk_validate=\""+multichk_validate+"\" " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST", "../../eOR/jsp/OrderEntryFormatMultiSelectControl.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&multichk_validate="+ multichk_validate, false ) ;
	  //xmlHttp.send(xmlDoc) ;
	  xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	    var responseText = xmlHttp.responseText;*/
		
		var bean_id = parent.OrderFormat.document.getElementById('bean_id').value;
    var bean_name = parent.OrderFormat.document.getElementById('bean_name').value;

    var xmlStr = "<root><SEARCH ";
    xmlStr += "multichk_validate=\"" + multichk_validate + "\" ";
    xmlStr += "/></root>";
    
    var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    var xmlHttp = new XMLHttpRequest();

    // Open the request as asynchronous (default is true)
    xmlHttp.open("POST", "../../eOR/jsp/OrderEntryFormatMultiSelectControl.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&multichk_validate=" + multichk_validate, true);

    // Set a callback function for when the request completes
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
            // Handle the response here, e.g., logging the response
          //  console.log("Response:", xmlHttp.responseText);
        }
    };

    // Send the XML data
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(xmlDoc);  // Send the XML document as the body of the request
		
	
} 
// IN062834 - End
function removeBeanValues()
{
	parent.OrderFormat.document.OrderFormatForm.mode.value = "REMOVE";
	parent.OrderFormat.document.OrderFormatForm.method	  =  "POST";
	/**
		modified by Deepa on 7/7/2010 at 2:31 PM for IN021079
		added the target attribute, since IE8 does not take the target as self by default
	**/
	parent.OrderFormat.document.OrderFormatForm.target	  =  "flex_fields_button";
	parent.OrderFormat.document.OrderFormatForm.action 	  = "../../eOR/jsp/OrderEntryOrderFormatControl.jsp";
	parent.OrderFormat.document.OrderFormatForm.submit();
} // End of removeBeanValues

function removeAll()
{	
	var ord_formt_multi_chk_nonmand_yn = parent.OrderFormat.document.OrderFormatForm.ord_formt_multi_chk_nonmand_yn.value; // IN062834 - Start
	var l_frm_unld_multichk_yn = parent.OrderFormat.document.OrderFormatForm.frm_unld_multichk_yn.value;
	if(ord_formt_multi_chk_nonmand_yn == 'Y' && l_frm_unld_multichk_yn == 'Y'){
		addRemValidationBean('UPDATETEMPUTILS');
	} // IN062834 - End
	if(parent.OrderFormat.document.OrderFormatForm.mode.value=="INSERT")
	{
		if(parent.OrderFormat.document.OrderFormatForm.close_yn.value!="Y") // Depending upon this to remove or not to remove the contents from the bean
		{
			removeBeanValues();
		}
	}
} // End of removeAll

// Clinical Comments for the Header level....(New Order and Care Set) & Preview
// On Click of the Clinical Comments in the header(in Place Order Tab) and the other comments
async function DisplayClinicalComments(field_name, hdg_name, order_category)
{
	var comments;
	var order_cat			= "";
	var inputArr 			= document.getElementsByTagName("input");
	var lineInputArr 		= parent.placeOrderDetailFrame.document.getElementsByTagName("input");
	for (u=0;u<inputArr.length;u++){
		if (inputArr[u].name == field_name){
			comments 		= inputArr[u].value;
		}
	}
//	if(parent.criteriaMainFrame.document.placeOrderHeaderForm.bean_id.value){ //--[IN00747]--	Added
	var bean_id 			= parent.criteriaMainFrame.document.placeOrderHeaderForm.bean_id.value ;
	var bean_name 			= parent.criteriaMainFrame.document.placeOrderHeaderForm.bean_name.value ;
	//var localeName          =parent.criteriaMainFrame.document.placeOrderHeaderForm.localeName.value;
	/*if(parent.criteriaMainFrame.document.placeOrderHeaderForm.all.cl_cmt_mand.style.visibility=="visible")
		{
		
			parent.criteriaMainFrame.document.placeOrderHeaderForm.clin_cmts_reqd_yn.value="Y";
		}
		else
		{
			parent.criteriaMainFrame.document.placeOrderHeaderForm.clin_cmts_reqd_yn.value="N";
		}*/
	var clin_cmts_reqd_yn 	= parent.criteriaMainFrame.document.placeOrderHeaderForm.clin_cmts_reqd_yn.value ;
//	}
	if(parent.placeOrderDetailFrame.document.placeOrderForm.clin_category_comments_reqd_yn){
		var clin_category_comments_reqd_yn 	= parent.placeOrderDetailFrame.document.placeOrderForm.clin_category_comments_reqd_yn.value ;// --[IN00747]-- Added
	}
	
	var retVal;
	var dialogHeight		= "42vh" ;
	//var dialogWidth 		= "30" ;
	var dialogWidth 		= "42vw" ;
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status=no";
	var arguments; //--[101]-- uncommented 
	arguments 			= comments ; //Value will be taken from the Bean, but stored it in the hidden field
	//retValue 				= window.showModalDialog("../../eOR/jsp/OrderEntryClinicalComments.jsp?hdg_name="+hdg_name+"&bean_id=" + bean_id + "&bean_name="+ bean_name+"&order_category="+order_category+"&clin_cmts_reqd_yn="+clin_cmts_reqd_yn+ "&arguments="+arguments+ "&clin_category_comments_reqd_yn="+clin_category_comments_reqd_yn+"&flg="+flg,"",features); //--[101]--Modified [IN00747]
	retValue 				= await window.showModalDialog("../../eOR/jsp/OrderEntryClinicalComments.jsp?hdg_name="+hdg_name+"&bean_id=" + bean_id + "&bean_name="+ bean_name+"&order_category="+order_category+"&clin_cmts_reqd_yn="+clin_cmts_reqd_yn+ "&arguments="+arguments,"",features);
	/*if(retValue==null)
	retValue="Y"+"||"+comments;*/

	
	var retVal				= ""; 
	var clin_cmts_value_entered_yn;
	if(retValue!=null){
		retValArr					= retValue.split("||");
		//IN044757 starts
	 	//retVal						= retValArr[1];	
		retVal						= trimString(retValArr[1]);	
		//IN044757 ends
		
		clin_cmts_value_entered_yn  = retValArr[0]; // Willbe always Y
	} 
	if(retValue!=null)
	{
		for (u=0;u<inputArr.length;u++){
			if (inputArr[u].name == field_name){
				inputArr[u].value = ''+encodeURIComponent(retVal)+'';
			}  // End of if
		} // End of for

		if(order_category==null || order_category=="")		// Only for Preview
		{
			// Tben copy to all the clinical comments of all the other categories, so get the categories from the line level	
			// If it is preview, it has to be copied to all the other header comments category wise
				for (u=0;u<lineInputArr.length;u++){
				if (field_name== "header_comments"){ // Header comments name
					if(lineInputArr[u].name.indexOf("hdr_care_set_order_category")!=-1) // for all header comments it will be clinical_comments+order_category
					{
						order_cat += lineInputArr[u].value+",";	
					} 
				} // End of if clinical_comments
			} // End of for	
		}
		// Set it in the hidden variable // Only to display it back...
		// Set it in the hidden variable
 		parent.criteriaMainFrame.document.placeOrderHeaderForm.header_comments.value =encodeURIComponent(retVal);
		//Added by channaveer B fOR Issue ICN24842 and icn 25262 on 29/11/2010
        if(parent.placeOrderDetailFrame.document.placeOrderForm)
		{
			
 			parent.placeOrderDetailFrame.document.placeOrderForm.header_comments.value =encodeURIComponent(retVal);
		}
		//alert("after"+parent.criteriaMainFrame.document.placeOrderHeaderForm.header_comments.value);
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		xmlStr 			+= field_name +"=\""+ checkSpl(retVal) +"\" " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&order_category="+order_category+"&order_cat="+order_cat+"&field_name="+field_name+"&func_mode=Clinical_Comments"+"&localeName="+localeName, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;
	} else 
		clin_cmts_value_entered_yn = "N";
	// to check the mandatory or not 
	parent.criteriaMainFrame.document.placeOrderHeaderForm.clin_cmts_value_entered_yn.value = clin_cmts_value_entered_yn;
	parent.criteriaMainFrame.document.placeOrderHeaderForm.header_comments.value = decodeURIComponent(parent.criteriaMainFrame.document.placeOrderHeaderForm.header_comments.value); //--[IN029202]--
 } // End of DisplayClinicalComments

// Called from OrderEntry.js, apply Method.
// Check for any mandatory is there for the Line Level, at the time of apply (For New Orders, Amend Orders and for Order Set)
function checkLineFormat(buttonObj){
	var result = true;
	if(buttonObj.format_id_yn)
	{
		var format_id_yn 			= buttonObj.format_id_yn.value;
		var format_id_mandatory_yn 	= buttonObj.line_level_mandatory_yn.value;
		if(format_id_mandatory_yn=="Y")    //If it is mandatory
		{
			if(format_id_yn!="Y")
			{
				result = false;
			}
		} // End of format_id_mandatory_yn=="Y"
	} // End of Object buttonObj.format_id_yn
	return result;
} // End of checkLineFormat

function checkLineFormatOpen(buttonObj){
	var result = true;
	if(buttonObj.format_id_yn)
	{
		var format_id_yn 			= buttonObj.format_id_yn.value;
		var format_id_mandatory_yn 	= buttonObj.line_level_mandatory_yn.value;
		if(format_id_mandatory_yn=="N")    //If it is not mandatory
		{
			if(format_id_yn!="Y")
			{
				result = false;
			}
		}// End of format_id_mandatory_yn=="N"
	} // End of Object buttonObj.format_id_yn
	return result;
} // End of checkLineFormatOpen


// Called from OrderEntry.js, apply Method.
// Check for any mandatory is there for the Header Level, at the time of apply (For New Orders, Amend Orders and for Order Set)
function checkHeaderFormat(headerformObj, new_order_checked, ammend_called_from){
	
	var result 	= true;
	if(headerformObj.format_id_mandatory_yn.value=="N" ) //New Orders & Existing Orders
   		result	= true;
   	else if(headerformObj.format_id_mandatory_yn.value=="Y" && headerformObj.format_id_yn.value=="Y" && new_order_checked != true) //New Orders
   		result	= true;
   	else if(headerformObj.format_id_mandatory_yn.value=="Y" && headerformObj.format_id_yn.value=="Y" && new_order_checked == true && ammend_called_from=="existing_order") // For Existing Orders
   		result	= true;
   	else if(headerformObj.format_id_mandatory_yn.value=="Y" && headerformObj.format_id_yn.value=="N" && new_order_checked != true && ammend_called_from=="existing_order") // For Existing Orders
   		result	= true;
   	else
   	{
		result 	= false;
    }
    return result;
} // End of checkHeaderFormat

function checkHeaderFormatOpen(headerformObj, new_order_checked, ammend_called_from){
	var result 	= true;
	if(headerformObj.format_id_mandatory_yn.value=="N" ) //New Orders & Existing Orders
   		result	= false;

    return result;
} // End of checkHeaderFormatOpen

// Called from OrderEntry.js, apply Method.
// Check for any mandatory is there for the Line Level, at the time of apply (For New Orders, Amend Orders and for Order Set)
function checkHeaderCareSetFormat(formObj,count ){
	var result 	= true;
	if(eval("formObj.hdr_format_id_mandatory_yn"+count+".value=='N'")) //New Orders & Existing Orders
   		result	= true;
   	else if(eval("formObj.hdr_format_id_mandatory_yn"+count+".value=='Y'") && eval("formObj.format_id_yn"+count+".value=='Y'")) //New Orders
   		result	= true;
   	else
   	{
		result = false;
    }
    return result;
} // End of checkHeaderCareSetFormat

//if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
function checkValidNumber(str,obj){
	
	if(obj!=undefined)
	{
	if(obj==null || obj.value==0 )
	 {
	   obj.value = "";
	   obj.focus();
	 }
	 else if(CheckValidNum(str,obj)==false)
	 {
	 	obj.value = "";
	 	obj.focus();
	 }
	}
} // End of checkValidNumber

function CheckValidNum(str,obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		setValue(str,obj.value);
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED","OR"));
            obj.select();
            obj.focus();
            return false;
        }
    }
} // End of CheckValidNum

async function rapidOrders()  // On click of the Rapid Ordes in the additional search
{
	var formObj				= parent.criteriaMainFrame.addlSearchCriteriaForm;
	// call the bean method if checked or unchecked
	storeCheckedValues("orderSetResultForm","YES");
	var bean_id   			= formObj.bean_id.value
	var bean_name 			= formObj.bean_name.value
	var order_category		= formObj.order_category.value
	var hdg_name			= "RapidOrders";
	var retVal;
	var dialogHeight 		= '12' ;
	var dialogWidth			= '30' ;
	var features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;	
	retVal 					= await window.showModalDialog("../../eOR/jsp/RapidOrderReason.jsp?hdg_name="+hdg_name+"&bean_id=" + bean_id + "&bean_name="+ bean_name+"&order_category="+order_category,arguments,features);
	var htmlText			= "";
	if(retVal!=null &&  retVal!="null" && retVal!="")
	{
		htmlText			= "";
		htmlText			+= "<html><head></head><body><form name=\"dummyForm\" id=\"dummyForm\" >";
		htmlText			+= " <input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" 	value=\""+bean_id+"\">";
		htmlText			+= " <input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\""+bean_name+"\">";
		htmlText			+= " <input type=\"hidden\" name=\"clinical_comments\" id=\"clinical_comments\" value=\""+retVal+"\">";
	//eval(formApply(parent.placeOrderDetailFrame.document.placeOrderForm,OR_CONTROLLER)) ;
	// Call the intermediate jsp, to make the values print.......
	var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();
			xmlStr		= "<root><SEARCH " ;
			xmlStr		+= "clinical_comments=\"" + checkSpl(retVal) +"\" "
			xmlStr		+=" /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "RapidOrdersValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=rapid_orders", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText	= xmlHttp.responseText ;
			eval( responseText ) ;
	}
	else if(retVal==null)
	{
		formObj				= parent.parent.tabFrame.document.formTab;
		patient_id 			= formObj.patient_id.value;
		encounter_id		= formObj.encounter_id.value;
		bean_id 			= formObj.bean_id.value;
		bean_name 			= formObj.bean_name.value;
		ammend_called_from 	= formObj.ammend_called_from.value;
		order_id			= formObj.order_id.value;
		iv_prep_yn			= formObj.iv_prep_yn.value;
		query_string		= "&patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&ammend_called_from="+ammend_called_from+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn;
  		parent.parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryFrameSet.jsp?tab_name=PlaceOrder"+query_string;
  		parent.parent.tabFrame.document.formTab.flag.value = "PlaceOrder";
  		if(ammend_called_from!="existing_order" && top.content.messageframe)
  			top.content.messageframe.location.href="../../eCommon/jsp/error.jsp";
	}
}	// End of rapidOrders

function doRapidClose() {
	var comments = document.rapidReason.comments.value
	if(comments!=null && comments!="")
	{
		//window.returnValue = document.rapidReason.comments.value;
		//window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = document.rapidReason.comments.value;
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
	}
	else
	{
		alert(getMessage("REASON_CANNOT_BLANK","OR"));
	}
} // End of doRapidClose

function doRapidCancel(){
	var comments		= document.rapidReason.comments.value
	//window.returnValue	= null;
	//window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = null;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
} // End of doRapidCancel

function dispMessage(message){ // display the alert message
	if(message.indexOf("<br>") != -1)
	   message = message.replace("<br>","");
	alert(message)
} // End of dispMessage
function onSuccessRapidOrder(){
	parent.parent.parent.parent.orderDetailFrame.location.reload();
} // End of onSuccessRapidOrder

// Used to RePopulate the (field_mnemoic) Study Location List Box if available in the Line Level
function populateStudyLocation(val, name,contr_msr_panel_id, contr_msr_mod_id, performing_facility_id,code,order_category){
	if(val!='')
	{	//If MOBILE_REQUIRED_YN is there for the field_mnemonic , it will remove it
		// Call the dynamic jsp to RePopulate the Study Location List Box
		var bean_id 	= document.OrderFormatForm.bean_id.value ;
		var bean_name 	= document.OrderFormatForm.bean_name.value ;
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		xmlStr 			+= "mobile_required_yn=\""+ val +"\" " ;
		xmlStr 			+= "contr_msr_panel_id=\""+ contr_msr_panel_id+"\" " ;
		xmlStr 			+= "contr_msr_mod_id=\""+ contr_msr_mod_id+"\" " ;
		xmlStr 			+= "performing_facility_id=\""+ performing_facility_id+"\" " ;
		xmlStr 			+= "code=\""+ code+"\" " ;
		xmlStr 			+= "order_category=\""+ order_category+"\" " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryOrderFormatValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=POPULATE_STUDY_LOCATION", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;
	}
} // End of populateStudyLocation

// To clear the list box
function clearStudyLocationList( cur_field_mnemonic, code) {
	form_obj 		= document.OrderFormatForm
	formObj 		= "document.OrderFormatForm."
	cur_field_mnemonic	+= "ORDERFORMAT";
	for(var i=0;i<form_obj.length;i++)
	{
		 if(form_obj[i].type=="select-one") // For select box
		 {
			if(form_obj[i].name.indexOf(cur_field_mnemonic)!=-1 && form_obj[i].name.indexOf(code)!=-1) //Only for Study Location
			{   //Clear the List Box of Study Location
				if(eval(formObj+form_obj[i].name))
				{
					var len = eval(formObj+form_obj[i].name+".options.length") ;
					for(var l=0;l<len;l++)
					{
						eval(formObj+form_obj[i].name+".remove(\""+form_obj[i].name+"\")") ;
					}	// End of for var
					var tp 		= " --- "+getLabel("Common.defaultSelect.label","Common")+" ---";
					var opt  	= eval("document.createElement(\"OPTION\")") ;
					opt.text 	= tp ;
					opt.value 	= "" ;
					eval(formObj+form_obj[i].name+".add(opt)") ;
			    } // End of if eval
			} // end of if name.
		 } // End of if form_obj[i].type
	 } // End of for i
}  // End of clearStudyLocationList

// To add in the List box
function addStudyLocationList(cur_field_mnemonic,code,value) {
	form_obj 		= document.OrderFormatForm
	formObj 		= "document.OrderFormatForm."
	cur_field_mnemonic	+= "ORDERFORMAT";
	var element 	= document.createElement('OPTION') ;
	element.value 	= code ;
	element.text 	= value ;
	for(var i=0;i<form_obj.length;i++)	//Only one study Location will be there in whole form, since it is single
	{
		 if(form_obj[i].type=="select-one") // For select box
		 {
			if(form_obj[i].name.indexOf(cur_field_mnemonic)!=-1 && form_obj[i].name.indexOf(code)!=-1) //Only for Study Location
			{   //Clear the List Box of Study Location
				if(eval(formObj+form_obj[i].name))
				{
					form_name 		= eval(formObj+form_obj[i].name);
					form_name.add(element);
			    } // End of if eval
			} // end of if name.
		 } // End of if form_obj[i].type
	 } // End of for i
 } // End of addStudyLocationList

//Place Order Screen, to populate the Performing Location
/*function setPerformingLocation(obj, order_category, contr_msr_panel_id,contr_msr_mod_id,lb_instal_yn,rd_instal_yn) {
	if(obj.value!='')
	{
		// Call the dynamic jsp to populate the Performing Location for the Facility
		var bean_id 	= document.placeOrderForm.bean_id.value ;
		var bean_name 	= document.placeOrderForm.bean_name.value ;
		var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		xmlStr			= "<root><SEARCH " ;
		xmlStr 			+= obj.name+"=\""+ obj.value +"\" " ;
		xmlStr 			+= "contr_msr_panel_id=\""+ contr_msr_panel_id +"\" " ;
		xmlStr 			+= "contr_msr_mod_id=\""+ contr_msr_mod_id +"\" " ;
		xmlStr 			+= "order_category=\""+ order_category +"\" " ;
		xmlStr 			+= "rd_instal_yn=\""+ rd_instal_yn +"\" " ;
		xmlStr 			+= "lb_instal_yn=\""+ lb_instal_yn +"\" " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=POPULATE_PERFORMING_LOCATION", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;
	}
} // End of setPerfomingLocation

function clearPeformingLocationList( docObjForm) {
alert(docObjForm)
	var len 	= eval(docObjForm+".options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObjForm+".remove(\"order_type\")") ;
	}
	var tp 		= "----------- Select -----------" ;
	var opt  	= eval(docObj+".createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	eval(docObjForm+".add(opt)") ;
}

// To add in the List box
function addPeformingLocationList(docObjForm,code,value) {
	var element 	= document.createElement('OPTION') ;
	element.value 	=  code ;
	element.text 	= value ;
	form_name 		= eval(docObjForm);
	form_name.add(element);
}
/*function preview() // Previously Used for Preview
{
	var dialogHeight; var dialogWidth; var dialogTop; var dialogLeft;
	var order_no 		= 1;
	var htmlText 		= new Array();
	var dt 		 		= new Date();
	var month 	 		= (dt.getMonth()+1);
	if (parseInt(month)<10){
		month='0'+month;
	}
	var arrInd 	 		= 0;
	var dtString 		= dt.getDate()+'/'+month+'/'+dt.getYear();
	var facility_name	= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.facility_name.value;
	htmlText[arrInd++] = "<html>";
	htmlText[arrInd++] = "	<head>";
	htmlText[arrInd++] = "		<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>";
	htmlText[arrInd++] = "	</head>";
	htmlText[arrInd++] = "	<body>";
	htmlText[arrInd++] = "		<table  width='100%' border='0' cellspacing='2' cellpadding='2' align=center height='auto'>";
	htmlText[arrInd++] = "			<tr>";
	htmlText[arrInd++] = "				<td colspan=4 class='BODYCOLORFILLED' align=right  width='auto'><b>"+facility_name+"</b>";
	htmlText[arrInd++] = "				</td>";
	htmlText[arrInd++] = "				<td align='right' class='BODYCOLORFILLED'  width='auto'><b>"+dtString+"</b>";
	htmlText[arrInd++] = "				</td>";
	htmlText[arrInd++] = "			</tr>";
	htmlText[arrInd++] = "			<tr>";
	htmlText[arrInd++] = "				<td colspan=5 class='BODYCOLORFILLED' align=center width='auto'>&nbsp;&nbsp;";
	htmlText[arrInd++] = "				</td>";
	htmlText[arrInd++] = "			</tr>";
	htmlText[arrInd++] = "			<tr>";
	htmlText[arrInd++] = "				<td colspan=5 class='BODYCOLORFILLED' align=center width='auto'>&nbsp;&nbsp;";
	htmlText[arrInd++] = "				</td>";
	htmlText[arrInd++] = "			</tr>";
	var patient_id 			= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.patient_id.value;
	var encounter_id 		= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.encounter_id.value;
	var physicianName 		= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.physician_name.value;
	var clinical_comments 	= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.header_comments.value;
	var order_date_time		= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.order_date_time.value;

	var sex					= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.sex.value;
	var age					= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.age.value;
	var dob 				= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.dob.value;
	var location_type		= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.location_type.value;
	var location_code		= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.location_code.value;
	var location_name		= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.location_name.value;
	var nationality			= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.nationality.value;
	var patient_name		= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.patient_name.value;
	//var pat_line = parent.frames[0].document.forms[0].pat_line.value.split("|");
	var ammend_called_from  = criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.ammend_called_from.value;
	var priority_code		= "";
	var priority 	  		= "";
if(ammend_called_from!="existing_order")
{
	 priority_code 			= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.priority.item(criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.priority.selectedIndex);
	 priority 		  		= priority_code.text;
}
else
{
	priority	 			= criteriaPlaceOrderFrame.criteriaMainFrame.document.placeOrderHeaderForm.priority.value;
	if(priority=="R")	priority = "Routine";
	else if(priority=="U")	priority = "Urgent";
	else if(priority=="S")	priority = "Stat";

}

	var facilityArr			= new Array();
	var catalogArr			= new Array();
	var priorityArr 		= new Array();
	var startDateArr		= new Array();
	var endDateArr			= new Array();
	var frequencyArr		= new Array();
	var lineComsArr 		= new Array();

	var orderTypeDescArr	= new Array();
	var freq_value_Arr		= new Array();

	var dur_value_Arr		= new Array();
	var dur_desc_Arr		= new Array();
	var prior_value_Arr		= new Array();

	var orderTypeArr 		= new Array();
	var oldOrderSortArr	 	= new Array();
	var oldOrderArr			= new Array();
	var u					= 0;
		u 					= criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.total_rows.value;
	var r					= 0;
	if(u > 0)
	{
		for (v=0;v<u;v++)
		{
		  	if(eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.catalog_code"+v))
		  	{
				var catalog_code_val = eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.catalog_code"+v+".value");
				var checked_yn		 = eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.ck"+catalog_code_val+".value")
				if(checked_yn=="Y") // Only if it is checked
				{
		  			facilityArr[r] 		= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.performing_facility_id"+v+".value;");
		 			catalogArr[r] 		= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.cat_desc"+v+".value;");
		 			pr_value 			= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.priority"+v+".value;");
		 			prior_value_Arr[r]	= pr_value;
		  			if(pr_value!=null && pr_value!="")
		 			{
						var prSelIndex 	= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.priority"+v+".selectedIndex;");
						var prOption 	= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.priority"+v+".item("+prSelIndex+");");
						priorityArr[r]	= prOption.text;
					}
					else priorityArr[r]	= "";
		  			startDateArr[r] 	= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.start_date_time"+v+".value;");
		  			endDateArr[r] 		= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.end_date_time"+v+".value;");
		 			lineComsArr[r] 		= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.line_comments"+v+".value;");
					orderTypeArr[r] 	= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.order_type_code"+v+".value ")
					if(orderTypeArr[r]!=null && orderTypeArr[r]!="")
					{
						var orSelIndex	= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.order_type_code"+v+".selectedIndex;");
						var OrderOption	= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.order_type_code"+v+".item("+orSelIndex+");");
						orderTypeDescArr[r]	= OrderOption.text;
					}
					else
						orderTypeDescArr[r]	= "";
					freq_value 			= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.frequency_val"+v+".value;");
					freq_value_Arr[r]	= freq_value;
					if(freq_value!=null && freq_value!="")
		 			{
						var freqSelIndex= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.frequency_code"+v+".selectedIndex;");
						var freqOption 	= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.frequency_code"+v+".item("+freqSelIndex+");");
						frequencyArr[r]	= freqOption.text;
					}
					else
						frequencyArr[r]	= "";
					dur_value_Arr[r]	= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.duration_value"+v+".value;");
					duration_value		= eval("criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.duration_code"+v+".value;");
					if(duration_value=="M")			duration_value = "Minute(S)";
					else if(duration_value=="H")	duration_value = "Hour(S)";
					else if(duration_value=="D")	duration_value = "Day(S)";
					else if(duration_value=="W")	duration_value = "Week(S)";
					else if(duration_value=="L")	duration_value = "Month(S)";
					dur_desc_Arr[r]		= duration_value;
		 			r++;
		 	 	} // End of checked_yn == "Y"
		  	} // End of catalog_code object
		} // End of for
		// Sorting Done here
*/
/*		var oldOrderType	= "";
		var oldFrequency	= "";
		var oldPriority		= "";
		var oldStartDate	= "";
		var oldEndDate		= "";
		var oldDuration		= "";
		var srl_no 			= 1;
		//for (r=0;r<serTypArr.length;r++)
		for (r=0;r<orderTypeArr.length;r++)
		{
			var OrderType 		= orderTypeArr[r];	//if ((ser_typ == old_ser_typ) &&(ser_loc == old_ser_loc))
			var freq_value		= freq_value_Arr[r];
			var dur_value		= dur_desc_Arr[r];
			var priority_value	= prior_value_Arr[r];
			var start_date_value= startDateArr[r];
			var end_date_value	= endDateArr[r];
			if((OrderType==oldOrderType) && (priority_value==oldPriority) && (freq_value==oldFrequency)  && (duration_value==oldDuration) && (start_date_value==oldStartDate) && (end_date_value==oldEndDate) )
			{	//if (ser_loc != '')if(OrderType !='') //{
					htmlText[arrInd++] = "			<tr>";
					htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap>"+srl_no+"";
					htmlText[arrInd++] = "				</td>";
					htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap>"+catalogArr[r]+"";
					htmlText[arrInd++] = "				</td>";
					if((priorityArr[r]=="") || (priorityArr[r]==null))
					 priorityArr[r] = "";
					htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap>"+priorityArr[r]+"";
					htmlText[arrInd++] = "				</td>";
					htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap>"+startDateArr[r]+"";
					htmlText[arrInd++] = "				</td>";
					htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=right width='auto' nowrap>"+endDateArr[r]+"";
					htmlText[arrInd++] = "				</td>";
					htmlText[arrInd++] = "			</tr>";
					if((frequencyArr[r]!="") &&  (frequencyArr[r]!=null))
					{
						htmlText[arrInd++] = "			<tr>";
						htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Frequency :-</b>";
						htmlText[arrInd++] = "              </td>";
						htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' colspan=2>"+frequencyArr[r]+"";
						htmlText[arrInd++] = "				</td>";
						if((dur_value_Arr[r]!="") && (dur_value_Arr[r]!=null))
						{
							htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' colspan=3 align=left width='auto'>"+dur_value_Arr[r]+"";
							if(dur_desc_Arr[r]!=null && dur_desc_Arr[r]	!='')
								htmlText[arrInd++] = "&nbsp;&nbsp;"+dur_desc_Arr[r];
							htmlText[arrInd++] = "				</td>";
						}
						else
						{
							htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' colspan=3 align=left width='auto'>&nbsp;";
							htmlText[arrInd++] = "				</td>";
						}
						htmlText[arrInd++] = "			</tr>";
					}
					if (lineComsArr[r] != "" && lineComsArr[r] !=null && lineComsArr[r] !='null' )
					{
						htmlText[arrInd++] = "			<tr>";
						htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Catalog Comments:-</b>";
						htmlText[arrInd++] = "				</td>";
						htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' colspan=4 align=left width='auto'>"+lineComsArr[r]+"";
						htmlText[arrInd++] = "				</td>";
						htmlText[arrInd++] = "			</tr>";
					}
					srl_no++;
				//}
			 }else{
				//if (ser_loc != '') if(OrderType!='')	{
				if (order_no >= 1){
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td colspan=5 class='BODYCOLORFILLED'>";
				htmlText[arrInd++] = "					<hr style='color=black' size='1'>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "		</table>";
				srl_no = 1;
				}
				htmlText[arrInd++] = "		<table  width='100%' border='0' cellspacing='2' cellpadding='2' align=center height='auto'>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td colspan=5 class='BODYCOLORFILLED' align=center width='auto'><b> Order Request for "+orderTypeDescArr[r] +"</b>";

			//	htmlText[arrInd++] = "				<td colspan=4 class='BODYCOLORFILLED' align=center width='auto'><b>"+ser_typ+" Request - "+orderTypeLongDesc+" </b>";

				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td colspan=4 class='BODYCOLORFILLED'>";
				htmlText[arrInd++] = "					<hr style='color=black' size='1'>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Order No</b>";
				htmlText[arrInd++] = "				</td>";
				//htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+order_no+"";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;[To be generated]";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=right width='auto' nowrap><b>Order Date</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+order_date_time+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Practitioner</b>";
				htmlText[arrInd++] = "				</td>";
			//	htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+pract+"";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+physicianName+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=right width='auto' nowrap><b>Priority</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+priority+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td  class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Patient</b>";
				htmlText[arrInd++] = "				</td>";
		//		htmlText[arrInd++] = "				<td  colspan=3 class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+pat_line[1]+","+pat_line[0]+"";
				htmlText[arrInd++] = "				<td  colspan=3 class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+patient_name+","+patient_id+","+age+","+sex+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Date of Birth</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+dob+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=right width='auto' nowrap><b>Nationality</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+nationality+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Encounter ID</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+encounter_id+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=right width='auto' nowrap><b>Order Location</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+location_name+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td  class='BODYCOLORFILLED' align=left width='auto' valign=top nowrap><b>Clinical Comments</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td  colspan=3 class='BODYCOLORFILLED' align=left width='auto'>:&nbsp;"+clinical_comments+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td colspan=5 class='BODYCOLORFILLED'>";
				htmlText[arrInd++] = "					<hr style='color=black' size='1'>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "		</table>";
				htmlText[arrInd++] = "		<table  width='100%' border='0' cellspacing='2' cellpadding='2' align=center height='auto'>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Srl No</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Catalog Name</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Priority</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Start Date Time</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=RIGHT width='auto' nowrap><b>End Date Time</b>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td colspan=5 class='BODYCOLORFILLED'>";
				htmlText[arrInd++] = "					<hr style='color=black' size='1'>";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				htmlText[arrInd++] = "			<tr>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap>"+srl_no+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap>"+catalogArr[r]+"";
				htmlText[arrInd++] = "				</td>";
				if((priorityArr[r]=="") || (priorityArr[r]==null))
				   priorityArr[r] = "";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap>"+priorityArr[r]+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap>"+startDateArr[r]+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=right width='auto' nowrap>"+endDateArr[r]+"";
				htmlText[arrInd++] = "				</td>";
				htmlText[arrInd++] = "			</tr>";
				if((frequencyArr[r]!="") &&  (frequencyArr[r]!=null))
				{
					htmlText[arrInd++] = "			<tr>";
					htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Frequency :-</b></td>";
					htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' colspan=2>"+frequencyArr[r]+"";
					htmlText[arrInd++] = "				</td>";
					if((dur_value_Arr[r]!="") && (dur_value_Arr[r]!=null))
					{
						htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' colspan=3 align=left width='auto'>"+dur_value_Arr[r]+"";
						if(dur_desc_Arr[r]!=null && dur_desc_Arr[r]	!='')
							htmlText[arrInd++] = "&nbsp;&nbsp;"+dur_desc_Arr[r];
						htmlText[arrInd++] = "				</td>";
					}
					else
					{
						htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' colspan=4 align=left width='auto'>&nbsp;";
						htmlText[arrInd++] = "				</td>";
					}
						htmlText[arrInd++] = "			</tr>";
				}
				if (lineComsArr[r] != '' && lineComsArr!=null &&  lineComsArr[r] !='null' ){
					htmlText[arrInd++] = "			<tr>";
					htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' align=left width='auto' nowrap><b>Catalog Comments:-</b>";
					htmlText[arrInd++] = "				</td>";
					htmlText[arrInd++] = "				<td class='BODYCOLORFILLED' colspan=4 align=left width='auto'>"+lineComsArr[r]+"";
					htmlText[arrInd++] = "				</td>";
					htmlText[arrInd++] = "			</tr>";

				}

				order_no = order_no+1;
				srl_no++;
			//}
		}
			oldOrderType 	= OrderType;
			oldFrequency	= freq_value;
			oldPriority		= priority_value;
			oldStartDate	= start_date_value;
			oldEndDate		= end_date_value;
			oldDuration		= duration_value;
		}
		if (srl_no > 1){
					//For closing the last table
					htmlText[arrInd++] = "			<tr>";
					htmlText[arrInd++] = "				<td colspan=5 class='BODYCOLORFILLED'>";
					htmlText[arrInd++] = "					<hr style='color=black' size='1'>";
					htmlText[arrInd++] = "				</td>";
					htmlText[arrInd++] = "			</tr>";
					htmlText[arrInd++] = "		</table>";
			}
			htmlText[arrInd++] = "	</body>";
			htmlText[arrInd++] = "</html>";
			dialogHeight 	= "25" ;
			dialogWidth 	= "50" ;
			dialogTop 		= "140" ;
			dialogLeft	 	= "124" ;
			var arguments = htmlText;
			var retVal 		= "";
			var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop+'; dialogLeft:'+dialogLeft+'; scroll=no; status=no';
			// Atleast one item is checked, then display the details other wise no need
			var	formObj		=  criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm
			result_val 		= checkToSubmit("criteriaPlaceOrderFrame.placeOrderDetailFrame",formObj); //Pass the formObj and the frame ref, Fn is in OrderEntry.js
			if(u >0 && result_val)
				retVal 		= window.showModalDialog("../../eOR/jsp/OrderEntryPreviewFrames.jsp?windowTitle=OrderPreview",arguments,features);
			else
			     alert(getOrMessage("CLICK_ONE_ORDERABLE"))
	} // End of u(if count for the new orders > 0)
	else
	     alert(getOrMessage("CLICK_ONE_NEW_ORDERABLE")) // Amend Orders
}
*/
function checkingbtspec(obj,field_mnemonic,start_date,localeName)
{
	//if(flagchecking=="correct")
	//{	
		
		var start_date_chk=start_date;
		if(isBefore(obj.value,start_date_chk,"DMYHM",localeName))
		{
			for(var i=0;i<document.OrderFormatForm.length;i++)	
			{
				if(document.OrderFormatForm[i].type=="text")
				{
					if(document.OrderFormatForm[i].name.indexOf('BLOOD_TRANS_EXP_DATE')!=-1 )
					{ 
						//if condition Added by Ambiga.M for 18043
						if(document.OrderFormatForm[i].name==obj.name)
						{
							if(document.OrderFormatForm[i].value!="")
							{
								document.OrderFormatForm[i].focus();
								document.OrderFormatForm[i].select();
								alert(getMessage("DATE_SHOULD_BE_MORE_THAN_START_DATE_TIME","OR"));
							}
						}
					}
				}
			}
		return false;
	}
	if(field_mnemonic=='BLOOD_TRANS_EXP_DATE')
	{
		var form_obj=document.OrderFormatForm;
var xmlDoc = ""; 
var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
 		xmlStr 			+= "start_date=\""+start_date_chk+"\" " ;
		//objname Added by Ambiga.M for 18043
 		xmlStr 			+= "objname=\""+obj.name+"\" " ;
		xmlStr 			+= "obj=\""+obj.value+"\" " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + form_obj.bean_id.value + "&bean_name="+ form_obj.bean_name.value +"&func_mode=BLOOD_TRANS_EXP_DATE", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ; 
   }
//}
}
function validBTDays(valid_days,objname){	
	 if(valid_days!=null && valid_days!="") 
		 if(valid_days=="Y"){}else{
		
		for(var i=0;i<document.OrderFormatForm.length;i++)	
			{
				if(document.OrderFormatForm[i].type=="text")
				{
					if(document.OrderFormatForm[i].name.indexOf('BLOOD_TRANS_EXP_DATE')!=-1 )
					{ 
						//if condition--Added by Ambiga.M for 18043
						if(document.OrderFormatForm[i].name==objname)
						{
							if(document.OrderFormatForm[i].value!="")
							{
								document.OrderFormatForm[i].focus();
								document.OrderFormatForm[i].select();
								//alert("INVALID_BLOOD_TRANS_EXPECTED_DATE");
								alert(getMessage("INVALID_BLOOD_TRANS_EXPECTED_DATE","OR"));
							}
						}
					}
				}
			}
		return false;
		}
 } 
 async function showDiagnosis(obj_name, obj, field_mnemonic)  //Called on click of the patient_id or Patient_name (field_mnemonic NM_PATIENT_ID, NM_PATIENT_NAME)
{ 
	var patient_id              = document.OrderFormatForm.patient_id.value;
	var function_id		= "";
	var no_of_items		= "3";
	var option_type		= "";
	//var module_id		= document.OrCommonForm.module_id.value
	//if(module_id=="PH")   //Used only For Pharmacy Orders
	//{
		 function_id	= "PH";
		 no_of_items 	= "1";
		 option_type	= "ACTIVE";

	//}
	var query_string	= "patient_id="+patient_id+"&P_function_id="+function_id+"&P_no_of_items="+no_of_items+"&P_option_type="+option_type
	var retVal 			= new String();
	var dialogHeight 	= "95vh" ;
	var dialogWidth  	= "60vw" ;
	var dialogTop    	= "";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await top.window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&"+query_string,arguments,features);
	
	if(retVal!="" && retVal!=null)
	{
		//Call the PH Js Function (internally will call the jsp and set it into the bean), which will be in PH MOdule
		
		var value=new Array();
		var value1=new Array();
		//alert("retVal"+retVal);
		value=retVal.split("||");
		//alert("arrvalue"+value[0]);
		value1=value[0].split("|");
		//alert("arrvalue"+value1[1]);

		/*for (var j=0;j<value.length;j++)
		{
			alert("arrvalue"+value[j]);
		}*/
		if(field_mnemonic=="PATIENT_DIAGNOSIS") // Field Mnemonic in OT
			{
				var form_obj 	= document.OrderFormatForm
 				for(var i=0;i<form_obj.length;i++)	//To get the concerned field_mnemonic and disabled
				{
					 if(form_obj[i].type=="text") // For Text box
					 {
  						//if(form_obj[i].name.indexOf(field_mnemonic)!=-1 )
						//{   
 							//form_obj[i].value	 = value1[0];		// set the patient_id
							//form_obj[i].readOnly = true;
						//}
						//else 
						if (form_obj[i].name.indexOf("PATIENT_DIAGNOSIS")!=-1 ) {// for the patient_name to be made readonly
						//{  
 				 			form_obj[i].value	 = value1[1];//retVal[1];		// set the patient_name
							//form_obj[i].readOnly = true;
						}
					 } // End of if form_obj[i].type
					 /*else if(form_obj[i].type=="button") // For Button
					 {
						if(form_obj[i].name.indexOf("PATIENT_DIAG_BTN")!=-1 ) // for the button to be disabled
						{ 
 				 			form_obj[i].disabled = true;
						}
					 }*/
				} // End of for i
			} // End of Field Mnemonic 
		//callActiveProblems(patient_id,encounter_id,retVal); //(in ePH/js/Prescription.js)

	}
}
function checkNumberRange(obj,min_num_value,max_num_value)  // To check the valid range for the numeric and integer
{
	if(CheckNumOR(obj)==false)
	{
		return false;
	}
	if(checkIsNull(obj))
		return false;

	var entered_value	  = obj.value;
	if(entered_value=="") entered_value = "0";
	if(parseFloat(max_num_value)==0) return false;
	if( parseFloat(entered_value)<parseFloat(min_num_value) || parseFloat(entered_value)>parseFloat(max_num_value) )
	{
		var msg = getMessage("MIN_MAX_VALUE_RANGE",'CA');
		msg=msg.replace('(1)',min_num_value);
		msg=msg.replace('(2)',max_num_value);
		alert(msg);		
		//obj.select();
		//obj.focus();
		obj.value = "";
		return false;
	}
}  // End of checkValidRange

var dotOccur = 0;
function allowNumbers(fld, e, maxInt, deci)
{
    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	var minusOccurance = fld.value.indexOf('-');
	var plusOccurance = fld.value.indexOf('+');
	if(minusOccurance != -1 || plusOccurance != -1)
	{
		maxInt++;
		fld.setAttribute("maxLength",maxInt);
	}
	else
	{
		fld.setAttribute("maxLength",maxInt);
	}
	if((whichCode == 45 && count>0) || (whichCode == 43 && count>0))
	{
		return false
	}

    if(count >= maxInt)
    {
       	return false;
    }
	
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789-+';


    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-+';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
	var count = 0;
    if(dotIndex!=-1)
	{			
		/*var val = fldValue.substring(dotIndex+1, fldValue.length);

		if (val.length >= parseInt(deci))
		{
			return false;
		}else
		{
			return true;
		}*/
			
		
		/*if( fldLength > (parseInt(dotIndex) + parseInt(deci)) )
		{	
			
			return false;
		}*/
	}

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if((key == "-" && fldValue.indexOf(key) != -1) || (key == "+" && fldValue.indexOf(key) != -1) )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

/* Added by Kishore kumar N on 15-Sept-09 for ICN 14360*/
function validateDiscreetMeasure(obj, maxVal, minVal,  noDecimals, maxDigits, minDigits, fldName)
{
	maxVal = parseInt(maxVal);
	minVal = parseInt(minVal);
	noDecimals = parseInt(noDecimals);
	maxDigits = parseInt(maxDigits);
	minDigits = parseInt(minDigits);
	
	if (fldName == undefined)
	{
		fldName = '';
	}


	if (obj.value != '')
	{	
		
		var val = obj.value;
		var str = val.lastIndexOf(".");
		var symbol = val.lastIndexOf("-");
		var symbol1 = val.lastIndexOf("+");

		if (obj.value.length == 1)
		{
			if (str == 0 || symbol == 0 || symbol1 == 0)
			{
				obj.value = '';
				return;
			}
		}

		if (symbol == 0 || symbol1 == 0)
		{
			maxDigits++;
		}
		
		if (str != -1 )
		{
			str = val.substring(val.lastIndexOf(".")+1, val.length);
			var len = val.substring(0, val.lastIndexOf("."));
			if (len.length < minDigits)
			{
				var msg = getMessage("MINIMUM_DIGITS","CA");
				msg = msg.replace('$', fldName);
				alert(msg +' '+ minDigits);	
				obj.value = '';
				obj.focus();
				return;
			}
			if (noDecimals != -1 && str.length > noDecimals )
			{	
				var msg = getMessage('VARIABLE_DEC_DIGIT','OR');
				msg = msg.replace('@',noDecimals);
				alert(msg);
				obj.value = '';
				obj.focus();
				return;
			}
		}/*else if(noDecimals > 0)
		{
			if ((val.length) > maxDigits)
			{
				var msg = getMessage("MAXIMUM_DIGITS","CA");
				msg = msg.replace('$','');
				 alert(msg+' '+ maxDigits );
				obj.value = '';
				obj.focus();
				return;
			}
		
		}*/

		/*if (maxDigits != -1 && val.length > maxDigits)
		{
			var msg = getMessage("MAXIMUM_DIGITS","CA");
			msg = msg.replace('$','');
			alert(msg+' '+ maxDigits);	
			obj.value = '';
			obj.focus();
			return;
		}*/

		if (minDigits != -1 && val.length < minDigits)
		{
			var msg = getMessage("MINIMUM_DIGITS","CA");
			msg = msg.replace('$',fldName);
			alert(msg+' '+ minDigits);	
			obj.value = '';
			obj.focus();
			return;
		}
		if (maxVal != -1 && val > maxVal)
		{
			if (minVal != -1)
			{
				var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
				msg = msg.replace('(1)',minVal);
				msg = msg.replace('(2)',maxVal);
				alert(msg);
			}
			else
			{
				var msg = getMessage("MAX_VAL_LESS_OR_EQL_TO","OR");
				alert(msg +' '+ minVal);
			}			
			obj.value = '';
			//obj.focus();
			return;
		}

		if (minVal != -1 && val < minVal)
		{
			if (maxVal != -1)
			{
				var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
				msg = msg.replace('(1)',minVal);
				msg = msg.replace('(2)',maxVal);
				alert(msg);
			}
			else
			{
				var msg = getMessage("MIN_VAL_GRT_OR_EQL_TO","OR");
				alert(msg +' '+ minVal);
			}
			obj.value = '';
			//obj.focus();
			return;
		}
	}
	/*ends here.*/
}

function populateTissueDetails(obj,catalog_code,count)
{
	var bean_id		= document.OrderFormatForm.bean_id.value;
	var bean_name	= document.OrderFormatForm.bean_name.value;
	var tissueDescField = eval("document.OrderFormatForm.tissueDescField"+count);
	if(tissueDescField!=null)
	{
		tissueDescField = eval("tissueDescField.value");
	}
	else
	{
		tissueDescField = "";
	}
	var fixativeField = eval("document.OrderFormatForm.fixativeField"+count);
	if(fixativeField!=null)
	{
		fixativeField = eval("fixativeField.value");
	}
	else
	{
		fixativeField = "";
	}
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH ";
	xmlStr += "anatomy_site_code=\""+ obj.value +"\" " ;
	xmlStr += "anatomy_site_name=\""+ obj.name +"\" " ;
	xmlStr += "catalog_code=\""+ catalog_code +"\" " ;
	xmlStr += "tissueDescField=\""+ tissueDescField +"\" " ;
	xmlStr += "fixative_field=\""+ fixativeField +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderFormatPopulateTissueFields.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function clearTissueDetails( docObj,tissueKey ) 
{
	var len = eval(docObj+".OrderFormatForm."+tissueKey+".options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".OrderFormatForm."+tissueKey+".remove(\""+tissueKey+"\")") ;
	}
	var tp = "       --- Select ---       " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".OrderFormatForm."+tissueKey+".add(opt)") ;
}

function addTissueDetailsData2List(code,value,tissueKey)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	eval("document.OrderFormatForm."+tissueKey+".add(element)");
}

function clearFixativeDetails( docObj,fixativeField ) 
{
	var len = eval(docObj+".OrderFormatForm."+fixativeField+".options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".OrderFormatForm."+fixativeField+".remove(\""+fixativeField+"\")") ;
	}
	var tp = "       --- Select ---       " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".OrderFormatForm."+fixativeField+".add(opt)") ;
}

function addFixativeDetailsData2List(code,value,fixativeField,code1)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	if(code==code1)
	{
		element.selected = true;
	}
	eval("document.OrderFormatForm."+fixativeField+".add(element)");
}
function CheckNumOR(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            //obj.select();
            //obj.focus();
            return false;
        }
    }
}
//SRR20056-SCF-9377 [IN037472] - [SRR20056-SCF-9373 ] - IN037471	 - Start
function validateDateObj(date, format, locale){
	if(date.value != ''){
		var dateValue=date.value;
		var dateArray="";
		var dateArray1;
		var checkFlag=true;
		
		if(format=="DMY"){
			dateArray=dateValue.split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="DMYHM"){
			dateArray1=dateValue.split(" ");
			dateArray=(dateArray1[0]).split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}

			if(dateArray1.length >1){
				var time1arr=dateArray1[1].split(":")
				if(time1arr.length==2)
				{
					var time1hr=time1arr[0]
					var time1min=time1arr[1]

					if (time1hr.length != 2 || time1min.length != 2)
					{
						 checkFlag=false;
					}
				}
			}
			
		}else if(format=="DMYHMS"){			
			dateArray1=dateValue.split(" ");
			dateArray=(dateArray1[0]).split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
			var time1arr=dateArray1[1].split(":")
			if(time1arr.length==3)
            {
				var time1hr=time1arr[0]
				var time1min=time1arr[1]
				var time1sec=time1arr[2]

				if (time1hr.length != 2 || time1min.length != 2 || time1sec.length != 2)
				{
					 checkFlag=false;
				}
			}
			
		}else if(format=="YY"){
			if(date==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="MY"){
			dateArray=dateValue.split("/");
			if(dateArray[1]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}	
		if(checkFlag){
			if(!validDate(date.value,format,locale)){
				if(top.header != null){
					//alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
				}else{
					//alert(getMessage("INVALID_DATE_FMT", "SM"));
				}
				date.select();
				date.focus();
				return false;
			}else{
				return true;
			}
		}else{
			//var msg=getMessage("INVALID_VALUE", "COMMON");
			//alert(msg.replace('#',getLabel("Common.date.label","Common")));
			date.select();
			date.focus();
			return false;
		}
	}
}
//SRR20056-SCF-9377 [IN037472] - End

//IN64543, starts
function loadEditorContent(tabType,catalog_code, currTabObj)
{	
	l_order_category = document.getElementById("order_category")+catalog_code.value;
	var readOnly = "";
	
	if(currTabObj == undefined)
			currTabObj = "commentsInstrnTab"+catalog_code;
	else	
		document.getElementById("currSelectedTab"+catalog_code).value = currTabObj.name;
		
	var currTab = document.getElementById("currSelectedTab")+catalog_code.value;
	
	if("commentsInstrnTab"+catalog_code ==currTab)
		currTabName = "Comments";
	else if("prepInstrnTab"+catalog_code ==currTab)
		currTabName = "Preparatory Instruction";
	else if("deptInstrnTab"+catalog_code ==currTab)
		currTabName = "Department Instruction";
	else if("patInstrnTab"+catalog_code ==currTab)
		currTabName = "Patient Instruction";

	highlightTabs(currTabObj,catalog_code);
document.getElementById('saveMsg"+catalog_code+"').innerHTML="Click "+"<img src='../../eOR/images/Save.png'></img></a>"+" in Editor to Save "+ currTabName;

	if(tabType == 'DEPT' && l_order_category=='LB')
	{
		readOnly = "Y";
		disableToolbar(catalog_code,'Y');
	}
	else
	{
		disableToolbar(catalog_code,'N');	
	}
	
	obj = document.getElementById(tabType + catalog_code);
	callInstantiateEditor(obj,catalog_code,readOnly);
}

function disableToolbar(catalog_code,disableFlag)
{
	if(disableFlag=='Y')
	{
		eval("document.getElementById('format_mode"+catalog_code+"')").disabled=true;
		eval("document.getElementById('font"+catalog_code+"')").disabled=true;
		eval("document.getElementById('size"+catalog_code+"')").disabled=true;
		eval("document.getElementById('img_tpaint"+catalog_code+"')").disabled=true;
		eval("document.getElementById('img_parea"+catalog_code+"')").disabled=true;
		eval("document.getElementById('img_clear"+catalog_code+"')").disabled=true;
	}
	else
	{
		eval("document.getElementById('format_mode"+catalog_code+"')").disabled=false;
		eval("document.getElementById('font"+catalog_code+"')").disabled=false;
		eval("document.getElementById('size"+catalog_code+"')").disabled=false;
		eval("document.getElementById('img_tpaint"+catalog_code+"')").disabled=false;
		eval("document.getElementById('img_parea"+catalog_code+"')").disabled=false;
		eval("document.getElementById('img_clear"+catalog_code+"')").disabled=false;		
	}
}

/*function saveEditorContent(obj,catalog_code)
{	
	var changingObjValue;
	var changingObjTabValue = eval("document.getElementById("currSelectedTab")"+catalog_code).value;
	eval("document.getElementById('saveMsg"+catalog_code+"')").innerHTML=getMessage("EDITOR_INSTRUCTION_SAVED","OR");

	highlightTabs(obj,catalog_code);
	
	if("commentsInstrnTab"+catalog_code ==changingObjTabValue)
		changingObjValue = "CMTS"+catalog_code;
	else if("prepInstrnTab"+catalog_code ==changingObjTabValue)
		changingObjValue =  "PREPS"+catalog_code;
	else if("deptInstrnTab"+catalog_code ==changingObjTabValue)
		changingObjValue =  "DEPT"+catalog_code;
	else if("patInstrnTab"+catalog_code ==changingObjTabValue)
		changingObjValue =  "PATIENT"+catalog_code;

	document.getElementById(changingObjValue).value = EditorGetHTML(catalog_code);

	if(eval("document.getElementById("prevSelectedTab")"+catalog_code).value!=eval("document.getElementById("currSelectedTab")"+catalog_code).value)
		eval("document.getElementById("prevSelectedTab")"+catalog_code).value = eval("document.getElementById("currSelectedTab")"+catalog_code).value;

	eval("document.getElementById("currSelectedTab")"+catalog_code).value = obj.name;
}*/

function saveCurrentContent(catalog_code)
{
	//eval("document.getElementById('saveMsg"+catalog_code+"')").innerHTML=getMessage("EDITOR_INSTRUCTION_SAVED","OR");
	
	var currTabObj = "";
	var currTab = document.getElementById("currSelectedTab"+catalog_code).value;
	var currTabName = "";

	if("commentsInstrnTab"+catalog_code ==currTab)
		currTabObj = "CMTS"+catalog_code;
	else if("prepInstrnTab"+catalog_code ==currTab)
		currTabObj =  "PREPS"+catalog_code;
	else if("deptInstrnTab"+catalog_code ==currTab)
		currTabObj =  "DEPT"+catalog_code;
	else if("patInstrnTab"+catalog_code ==currTab)
		currTabObj =  "PATIENT"+catalog_code;
	
	document.getElementById(currTabObj).value = EditorGetHTML(catalog_code);	
}

function highlightTabs(obj, catalogCode)
{
	if(obj.name=='commentsInstrnTab'+catalogCode)
	{
		changeTabCSSClassName('commentsInstrnTab'+catalogCode,'clicked');
		changeTabCSSClassName('prepInstrnTab'+catalogCode,'normal');
		changeTabCSSClassName('deptInstrnTab'+catalogCode,'normal');
		changeTabCSSClassName('patInstrnTab'+catalogCode,'normal');
	}
	else if(obj.name=='prepInstrnTab'+catalogCode)
	{
		changeTabCSSClassName('commentsInstrnTab'+catalogCode,'normal');
		changeTabCSSClassName('prepInstrnTab'+catalogCode,'clicked');
		changeTabCSSClassName('deptInstrnTab'+catalogCode,'normal');
		changeTabCSSClassName('patInstrnTab'+catalogCode,'normal');
	}
	else if(obj.name=='deptInstrnTab'+catalogCode)
	{
		changeTabCSSClassName('commentsInstrnTab'+catalogCode,'normal');
		changeTabCSSClassName('prepInstrnTab'+catalogCode,'normal');
		changeTabCSSClassName('deptInstrnTab'+catalogCode,'clicked');
		changeTabCSSClassName('patInstrnTab'+catalogCode,'normal');
	}
	else if(obj.name=='patInstrnTab'+catalogCode)
	{
		changeTabCSSClassName('commentsInstrnTab'+catalogCode,'normal');
		changeTabCSSClassName('prepInstrnTab'+catalogCode,'normal');
		changeTabCSSClassName('deptInstrnTab'+catalogCode,'normal');
		changeTabCSSClassName('patInstrnTab'+catalogCode,'clicked');
	}
}

function changeTabCSSClassName(tabId,cssClassName)
{
	document.getElementById(tabId).className = cssClassName;
}
//IN64543, ends
//IN068553 Starts
function CheckForNums(event){
	var strCheck = '+0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	return true ;	
}
 //IN068553 Ends


