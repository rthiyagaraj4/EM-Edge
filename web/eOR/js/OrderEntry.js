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
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created
22/6/2011     101            Chowminya      ?				?				Incident No: IN027797 - <Clinical comments, order format not shown in the view mode> 
14/6/2011    IN28074         Jayashree    	?				?				IN28074 - < encoded the clinical comments value when % is given>
30/08/2011  IN27327  		 Menaka		  	?				?				<New Order 
			IN26921															After click record ,System display	duplicate alert message. Then check box in discard and click continue. System display empty pop up message.
20/01/2012	IN029143		Menaka V		?				?				<JD-CRF-0111 This option is available in HIS 2.x and KAUH needs to be in EM version. In the current workflow the option is being used frequently. When a physician selects the patient, system will ask to enter the PIN Code. Physician needs to authenticate in the Prescription screen using the PIN code. This will prevent from unauthorised access while the physician is on rounds>.		
23/01/2012  IN030563    	Ramesh G   		?				?				The Pin No. for placing ordering is selected as Logged in Practitioner s Pin ? Prompt once for all categories. But the Pin No. is prompted each time we Place a Category and also when we record the category.											
25/01/2012	IN030566		Ramesh G		?				?				When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.
13/9/2012	KAUH Lock		Dinesh T		?				?				KAUH message handing in OR place Order in OR and CIS responsibility
25/09/2012	IN030279		Ramesh G		?				?				Bru-HIMS-CRF-160
04/12/2012	IN036533		Ramesh G		?				?				In the Duplicate Check webpage click ?Cancel?  and we get a empty pop up message box.
17/12/2012	IN036673		Ramesh G		?				?				Multi Orders cannot be placed from Additional Search
13/08/2013	IN042045		Chowminya G	    ?				?				System should not allow to copy for the drugs for which Verbal Order Applicable is not selected		
17/10/2014	IN041069		Karthi L	    ?				?				System display clinical comment hyperlink in view menu eventhough there was not data inserted.
23/10/2015	IN044520		Karthi L	    ?				?				Clinical comments is displayed by deleting previous entered data while amend Order at Clinical comments.
01/12/2013	IN038787		Ramesh G		?				?				Bru-HIMS-CRF-358
16/12/2013	BS_INTN0001 	Vijayakumar K	?				?				reloading continuously when click on cancel in confirm dialog.
06/01/2014	IN044014		Chowminya		?				?				System is not defaulting the Department if users selecting the performing location
08/01/2014	IN044757		Vijayakumar K	?				?				Clinical comments displayed as hyper link at result-Completed stage, even though clinical comments  not recorded while placing the order.
24/01/2014	IN046592		Ramesh G		?				?				Manage Specimen is taking more than 40 seconds to complete after clicking on Record when multiple records are selected. The response time is very slow.		
20/02/2014	  IN024984		Karthi		21/02/2014			Ramesh			Conditional reordering by clinician		
10/03/2014	  IN024984		Chowminya										Duplicate order recording with reason - new mandatory option							
13/03/2014	  IN047632		Karthi											System popup Duplicate check window with Override Reason Text box for Reject Duplicate check Action							
13/03/2014	  IN047644		Karthi											Duplicate Override check box is still displayed and enabled even though order catalog is disabled
14/03/2014    IN041644		Nijitha S		 								Prescription Authorization of Drugs Based on Rules						
18/03/2014	  IN047867		Karthi							  				By deleting the entered Override reason is not updated.				
18/03/2014	  IN047605		Karthi							  				Alignment format of Duplicate Override reason text is differed		
21/03/2014	  IN047686		Karthi											While placing Duplicate Orders for Multiple patients through 'Multi Patient Order', System not asking to capture the duplicate Override Reason.		
26/03/2014	  IN048065		Nijitha											The order status is displayed incorrectly for an order catalog for which multiple definitons exist with different duration types
22/04/2014    IN042962		Chowminya      									CRF:Print Order Sheet From Existing Orders	
06/05/2014    IN048942		Chowminya      									Performing Location and wing code defaulting issue	
02/07/2014	  IN048467 		Nijitha S										HSA-CRF-0150
26/08/2014    IN050607		Nijitha S										KDAH-SCF-0255	
21/10/2015	  IN057196		Ramesh G										Recording Of Consent Form
31/05/2016	  IN060463		Ramesh G										Alpha-CIS-OR-Place Order - Order Sheet is not getting printed while releasing the order from Order Preview screen
01/11/2016	  IN061988		Vijayakumar K									AAKH-CRF-0088.3 [IN:061988]
15/05/2017	IN064122		Dinesh T										Header Format is missing when header is not 																				having any mandatory fields
03/07/2017    IN062607		Raja S		03/07/2017			Ramesh G		ML-MMOH-CRF-0727
09/10/2017	  IN063973		Raja S		10/10/2017		Ramesh G			SS-CRF-0058	
19/10/2017	IN065324		Dinesh T	26/10/2017		Ramesh G			To display the price in OR screen and the billing 																				status in Manage Specimen screen
08/01/2018	IN066070		Vijayakumar K 08/01/2018		Ramesh G			ML-MMOH-SCF-0898 [IN:066070]
17/07/2018	  IN064543		Kamalakannan		 17/07/2018	Ramesh G		ML-MMOH-CRF-0776
06/07/2018	  IN067246		Raja S			06/07/2018	Ramesh G		GHL-CRF-0516
16/10/2018	IN066709		Prakash C 	 	 16/10/2018	Ramesh G 		ML-MMOH-CRF-1101
09/01/2019  IN066377  		Kamalakannan G	09/01/2019		Ramesh G			AMS-CRF-0139
21/04/2019	IN070295		Ramesh G		ML-BRU-SCF-1939
27/05/2019	IN069027	Ramesh G								MMS-DM-CRF-0150
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
17/02/2020	IN071260	Nijitha S	17/02/2020	Ramesh G	MMS-KH-CRF-0029.3
02/03/2020	IN072595	Nijitha S	02/03/2020	Ramesh G	MMS-KH-CRF-0029.3
03/17/2020	IN072721	Nijitha S	03/17/2020	Ramesh G	ML-MMOH-CRF-1229
25/06/2020	IN073309	Nijitha S     		25/06/2020		Ramesh G		ML-MMOH-CRF-1229.2/02
28/07/2020	IN073455	Nijitha S     		28/07/2020		Ramesh G		ML-MMOH-CRF-1229.2/14
31/05/2023	44884		Krishna				31/05/2023		Ramesh G  		MO-CRF-20183
---------------------------------------------------------------------------------------------------------------
*/

var flagchecking="0";
//var counter=0;
var apply_total_count=0;
var HTMLTextS = new Array();
var HTMLPatTextS = new Array();
var HTMLPTextS = new Array();
var HTMLCat = new Array();
var catString = new Array();
//Added by Uma on 3/2/2010 for IN019654
var codeVal = "";
var tempcodeVal ="";//IN062607

var dupeCounter = 0; //IN047605

function getLocation(obj) // to get the location_code if the clinic_type = 'W'
{
  if(obj.value!='')
  {
    val = obj.value.split("::");
	document.formPractDtl.location_code.value  		= val[0];
    document.formPractDtl.open_to_all_pract_yn.value  	= val[1];
	document.formPractDtl.practitioner_name.readOnly	= false;
	document.formPractDtl.practitioner_name.value		= "";
	document.formPractDtl.practitioner_id.value			= "";
  }else{
	document.formPractDtl.practitioner_name.readOnly	= true;
	document.formPractDtl.practitioner_name.value		= "";
	document.formPractDtl.practitioner_id.value			= "";
  }

}
function changeCheckBoxValue(obj)
{
	if(obj.checked == true)
		obj.value = "Y";
	else
	    obj.value = "N";
}
// To clear the list box
function clearList( docObj ) {
	var len = eval(docObj+".tickSheetForm.tick_sheet_id.options.length") ;
	for(var i=0;i<len;i++)
	{
		if(eval(docObj+".tickSheetForm.tick_sheet_id.options.value")!='') 
		{
			eval(docObj+".tickSheetForm.tick_sheet_id.remove(\"tick_sheet_id\")") ;
		}
	}
	
	if(len==0)
	{	
		var tp 		= "---- "+getLabel("Common.defaultSelect.label","Common")+" ----" ;
		var opt  	= eval(docObj+".createElement(\"OPTION\")") ;
		opt.text 	= tp ;
		//opt.text 	="" ;
		opt.value 	= "" ;
		eval(docObj+".tickSheetForm.tick_sheet_id.add(opt)") ;
	}
}
// To add in the List box
function addList(code,value) {
	
	if(document.tickSheetForm.tick_sheet_id.options.value=='') 
	{
		document.tickSheetForm.tick_sheet_id.remove(0) ;
	}
	var element 	= document.createElement('OPTION') ;
	element.value 	=  code ;
	element.text 	=  value ;
	document.tickSheetForm.tick_sheet_id.add(element);
}

function changeBillNow(obj,index,catcode)
{
	if(obj.checked==false)
	{
		setValue(obj,"N");
		setValue("bill_now"+catcode,"N");
		obj.value	= "N";
		setValue("bill_now_check"+catcode+"chk","UnChecked");
		setValue("bill_now_check_Df"+catcode,"N");
		eval("document.placeOrderForm.bill_now"+index).value="N";
	}
	else 
	{
		obj.value	= "Y";
		setValue(obj,"Y");
		setValue("bill_now"+catcode,"Y");
		setValue("bill_now_check"+catcode+"chk","Checked");
		setValue("bill_now_check_Df"+catcode,"Y");
		eval("document.placeOrderForm.bill_now"+index).value="Y";
	}
}
function amendChangeBillNow(obj,index,catcode)
{
	if(obj.checked==false)
	{
		setValue(obj,"N");
		setValue("amend_bill_now"+catcode,"N");
		obj.value	= "N";
		setValue("amend_bill_now_check"+catcode+"chk","UnChecked");
		setValue("amend_bill_now_check_Df"+catcode,"N");
		eval("document.placeOrderForm.amend_bill_now"+index).value="N";
	}
	else 
	{
		obj.value	= "Y";
		setValue(obj,"Y");
		setValue("amend_bill_now"+catcode,"Y");
		setValue("amend_bill_now_check"+catcode+"chk","Checked");
		setValue("amend_bill_now_check_Df"+catcode,"Y");
		eval("document.placeOrderForm.amend_bill_now"+index).value="Y";
	}
}

function checkWithCurrent(obj,index,currentDate,localeName,catcode,appt_reqd_yn)
{
	var Future_date = "";
	var Round_Off_Start_Time = "";
	var checkdate = "";
	if((appt_reqd_yn=='')||(appt_reqd_yn=='N'))
	{
		if((document.placeOrderForm.billing_call_yn+index) && (document.getElementById('bill_now_'+index))  )
		{
			Future_date = eval(document.getElementById("future_date"+index)).value;
			if(localeName!="en")
			{ 
				currentDate = convertDate(currentDate,'DMYHM',localeName,"en");
			}
			var Currentdateforfloor=currentDate.substring(0,10);
			var Futuredateforfloor=Future_date.substring(0,10);
			if(!(isAfter(Currentdateforfloor,Futuredateforfloor,"DMY",localeName)))
			{
				Round_Off_Start_Time=document.getElementById('round_off_start_time'+index).value;
				if(Round_Off_Start_Time=="Y")
				{
					Future_date=Future_date.substring(0,11)+"00:00";
					eval(document.getElementById("future_date"+index)).value=Future_date;
				}
			}
		}
		else if((eval("document.placeOrderForm.amend_billing_call_yn"+index) && eval(document.getElementById("amend_bill_now_"+index))))
		{

		   Future_date=eval(document.getElementById("amend_future_date"+index)).value;
		   var Currentdateforfloor=currentDate.substring(0,10);
			var Futuredateforfloor=Future_date.substring(0,10);
			if(!(isAfter(Currentdateforfloor,Futuredateforfloor,"DMY",localeName)))
			{
				 Round_Off_Start_Time=eval(document.getElementById("amend_round_off_start_time"+index)).value;
				if(Round_Off_Start_Time=="Y")
				{
					Future_date=Future_date.substring(0,11)+"00:00";
					eval(document.getElementById("amend_future_date"+index)).value=Future_date;
				}
			}
		}
	   else
		{
		   Future_date=currentDate;
		}
	}
	if(localeName!="en")
	{
		checkdate = convertDate((obj.value),'DMYHM',localeName,"en");
	}
	else
	{
		checkdate = obj.value;
	}
	if((!(isAfter(Future_date,checkdate,"DMYHM",localeName)))||(Future_date==checkdate))
	{
		if(eval("document.placeOrderForm.schedule_mandatorily_yn"+index))
		{
			eval("document.placeOrderForm.schedule_mandatorily_yn"+index+".value='N'");
		}
		else if(eval("document.placeOrderForm.amend_schedule_mandatorily_yn"+index))
		{
			eval("document.placeOrderForm.amend_schedule_mandatorily_yn"+index+".value='N'");
		}
		if((appt_reqd_yn=='')||(appt_reqd_yn=='N'))
		{
			if((eval("document.placeOrderForm.billing_call_yn"+index) && eval("document.placeOrderForm.billing_call_yn"+index).value=="Y" ))
			{
				eval(document.getElementById("bill_now_"+index)).style.visibility="visible";
				setValue("bill_now_"+catcode,"visible");
					  
			  if (eval("document.placeOrderForm.bill_now_check_Df"+index).value == 'Y')
			  {
				  
					  setValue("bill_now"+catcode,"Y");
					  setValue("bill_now_check_Df"+catcode,"Y");
					  setValue("bill_now_check"+catcode+"chk","Checked");
					  eval("document.placeOrderForm.bill_now"+index).value='Y';
					  eval("document.placeOrderForm.bill_now_check"+index).checked=true;
			  }
			  else
			 {
					setValue("bill_now"+catcode,"");
					eval("document.placeOrderForm.bill_now"+index).value=''; 
					setValue("bill_now_"+catcode,"hidden");
					eval(document.getElementById("bill_now_"+index)).style.visibility="hidden";
			 }
		  }
		  else if( (eval("document.placeOrderForm.amend_billing_call_yn"+index) && eval("document.placeOrderForm.amend_billing_call_yn"+index).value=="Y"))
		 {
				
			  eval(document.getElementById("amend_bill_now_"+index)).style.visibility="visible";
			  setValue("amend_bill_now_"+catcode,"visible");
			 
			  
			  if (eval("document.placeOrderForm.amend_bill_now_check_Df"+index).value == 'Y')
			  {
					setValue("amend_bill_now"+catcode,"Y");
					setValue("amend_bill_now_check_Df"+catcode,"Y");
					setValue("amend_bill_now_check"+catcode+"chk","Checked");
					eval("document.placeOrderForm.amend_bill_now"+index).value='Y';
					eval("document.placeOrderForm.amend_bill_now_check"+index).checked=true;
			  }
			  else
			 {
					setValue("amend_bill_now"+catcode,"");
					eval("document.placeOrderForm.amend_bill_now"+index).value=''; 
					setValue("amend_bill_now_"+catcode,"hidden");
					eval(document.getElementById("amend_bill_now_"+index)).style.visibility="hidden";
			 }
		  }
	   }
	}
	else
	{				
		if((appt_reqd_yn=='')||(appt_reqd_yn=='N'))
		{
			 if((eval("document.placeOrderForm.billing_call_yn"+index) && eval("document.placeOrderForm.billing_call_yn"+index).value == "Y" )	)
			{
				eval(document.getElementById("bill_now_"+index)).style.visibility="hidden";
				setValue("bill_now_"+catcode,"hidden");
	
				if(eval("document.placeOrderForm.bill_now_check_Df"+index).value=="Y")
				{
					setValue("bill_now_check"+catcode+"chk","Checked");
					eval("document.placeOrderForm.bill_now_check"+index).checked=true;
				}
				else
				{
					setValue("bill_now_check"+catcode+"chk","UnChecked");
					eval("document.placeOrderForm.bill_now_check"+index).checked=false;
				}
				if(eval(document.getElementById("bill_now_"+index)).style.visibility=="hidden")
				{
					if(eval("document.placeOrderForm.bill_now"+index))
					{
						eval("document.placeOrderForm.bill_now"+index+".value='N'");
					}
				}
				else
				{
					if(eval("document.placeOrderForm.bill_now"+index))
					{
						eval("document.placeOrderForm.bill_now"+index+".value='Y'");
					}
				}

			}
			else if ((eval("document.placeOrderForm.amend_billing_call_yn"+index) && eval("document.placeOrderForm.amend_billing_call_yn"+index).value == "Y"))
			{
				document.getElementById('amend_bill_now_'+index).style.visibility="hidden";
				setValue("amend_bill_now_"+catcode,"hidden");

				if(eval("document.placeOrderForm.amend_bill_now_check_Df"+index).value=="Y")
				{
					setValue("amend_bill_now_check"+catcode+"chk","Checked");
					eval("document.placeOrderForm.amend_bill_now_check"+index).checked=true;
				}
				else
				{
					setValue("amend_bill_now_check"+catcode+"chk","UnChecked");
					eval("document.placeOrderForm.amend_bill_now_check"+index).checked=false;
				}
				if(document.getElementById('amend_bill_now_'+index).style.visibility=="hidden")
				{
					if(eval("document.placeOrderForm.amend_bill_now"+index))
					{
						eval("document.placeOrderForm.amend_bill_now"+index+".value='N'");
					}
				}
				else
				{
					if(eval("document.placeOrderForm.amend_bill_now"+index))
					{
						eval("document.placeOrderForm.amend_bill_now"+index+".value='Y'");
					}
				}
			}
		}
	}
			
} 

// To populate the list item values for the Tick Sheets
function popTickSheetValues(obj)
{ 
	var result = true;
	if((document.tickSheetForm.order_category.value=="") && (document.tickSheetForm.order_category_yn.value=="Y"))
	{
		alert(getMessage("ORDER_CATEGORY","OR"));
		result = false;
	}
	if(document.tickSheetForm.order_category.value!="" && document.tickSheetForm.order_category_yn.value=='Y' && document.tickSheetForm.order_type_yn.value=="Y")
	{
		if(document.tickSheetForm.order_type.value=="" )
		{
			result = false;
			alert(getMessage("ORDER_TYPE","OR"));
		}
	}
	if(result)
	{
		
		bean_id 	= document.tickSheetForm.bean_id.value;
		bean_name 	= document.tickSheetForm.bean_name.value;
		var order_dispaly_verticalYN = document.tickSheetForm.order_dispaly_verticalYN.value;  // IN038787
		if(document.tickSheetForm.order_category.value!="" && document.tickSheetForm.order_category_yn.value=="Y" && document.tickSheetForm.order_type_yn.value=="Y")
		{
			document.tickSheetForm.order_category.disabled 	= true;
			document.tickSheetForm.order_type.disabled 		= true;
		}
		else if(document.tickSheetForm.order_category_yn.value =="N" && document.tickSheetForm.order_type_yn.value =="N")
		{
			document.tickSheetForm.order_category.disabled 	= false;
			document.tickSheetForm.order_type.disabled 		= false;
		}
		else
		{
			if(document.tickSheetForm.order_category.value!="")
				document.tickSheetForm.order_category.disabled 	= true;
			document.tickSheetForm.order_type.disabled 		= false;
		}

		if(document.tickSheetForm.ammend_called_from.value=="existing_order")
		{
			document.tickSheetForm.order_category.disabled 	= true;
			document.tickSheetForm.order_type.disabled 		= true;
			// Disable the Order type also in amend mode
		}
		/*Added by Uma on 8/24/2009 for PMG0089 CRF-641*/
		var Applicability_yn = "";
		if(document.tickSheetForm.ApplicableCatalogs)
		  Applicability_yn = document.tickSheetForm.ApplicableCatalogs.value;
		/*Modified by Uma on 8/24/2009 for PMG0089 CRF-641 added Applicability_yn*/
		if( obj.value !='')
		{
			//IN038787 Start.
			//parent.criteriaDetailFrame.location.href		="../../eOR/jsp/OrderEntrySectionDisplay.jsp?tick_sheet_id="+obj.value+"&order_category="+document.tickSheetForm.order_category.value+"&function_from="+document.tickSheetForm.function_from.value+"&order_type="+document.tickSheetForm.order_type.value+"&activity_type="+document.tickSheetForm.activity_type.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&priv_applicability_yn="+Applicability_yn;
			parent.criteriaDetailFrame.location.href		="../../eOR/jsp/OrderEntrySectionDisplay.jsp?tick_sheet_id="+obj.value+"&order_category="+document.tickSheetForm.order_category.value+"&function_from="+document.tickSheetForm.function_from.value+"&order_type="+document.tickSheetForm.order_type.value+"&activity_type="+document.tickSheetForm.activity_type.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&priv_applicability_yn="+Applicability_yn+"&order_dispaly_verticalYN="+order_dispaly_verticalYN;
			//IN038787 End.
			parent.criteriaTickSheetsFrame.location.href	="../../eCommon/html/blank.html"
		}
		else
		{
			parent.criteriaDetailFrame.location.href		="../../eCommon/html/blank.html"
			parent.criteriaTickSheetsFrame.location.href	="../../eCommon/html/blank.html"
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		}
	}

}

function popTickSheetValuesActivity(obj)
{
 	var result = true;
	if(document.tickSheetForm.order_category.value!="" && document.tickSheetForm.order_category_yn.value=='Y' && document.tickSheetForm.order_type_yn.value=="Y")
	{
		if(document.tickSheetForm.order_type.value=="" )
		{
			result = false;
			alert(getMessage("ORDER_TYPE","OR"));
		}
	}
	if(result)
	{
		bean_id 	= document.tickSheetForm.bean_id.value;
		bean_name 	= document.tickSheetForm.bean_name.value;
		if(document.tickSheetForm.order_category.value!="" && document.tickSheetForm.order_category_yn.value=="Y" && document.tickSheetForm.order_type_yn.value=="Y")
		{
			document.tickSheetForm.order_category.disabled 	= true;
			document.tickSheetForm.order_type.disabled 		= true;
		}
		else if(document.tickSheetForm.order_category_yn.value =="N" && document.tickSheetForm.order_type_yn.value =="N")
		{
			document.tickSheetForm.order_category.disabled 	= false;
			document.tickSheetForm.order_type.disabled 		= false;
		}
		else
		{
			if(document.tickSheetForm.order_category.value!="")
				document.tickSheetForm.order_category.disabled 	= true;
			document.tickSheetForm.order_type.disabled 		= false;
		}

		if(document.tickSheetForm.ammend_called_from.value=="existing_order")
		{
			document.tickSheetForm.order_category.disabled 	= true;
			document.tickSheetForm.order_type.disabled 		= true;
			// Disable the Order type also in amend mode
		}
		/*Added by Uma on 8/24/2009 for PMG0089 CRF-641*/
		var Applicability_yn = ""; 
		if(document.tickSheetForm.ApplicableCatalogs)
		{
			Applicability_yn = document.tickSheetForm.ApplicableCatalogs.value;
		}
		/*Modified by Uma on 8/24/2009 for PMG0089 CRF-641 added Applicability_yn*/
		
		parent.criteriaDetailFrame.location.href		="../../eOR/jsp/OrderEntrySectionDisplay.jsp?tick_sheet_id="+obj.value+"&order_category="+document.tickSheetForm.order_category.value+"&order_type="+document.tickSheetForm.order_type.value+"&activity_type="+document.tickSheetForm.activity_type.value+"&function_from="+document.tickSheetForm.function_from.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&priv_applicability_yn="+Applicability_yn;
		parent.criteriaTickSheetsFrame.location.href	="../../eCommon/html/blank.html"
		
	}
}
// TO POPULATE THE SECTIONS WHEN ORDER TYPE IS CHANGED
function popSections(obj)
{

	if( obj.value == "" )
	{
	   // document.tickSheetForm.reset();
	    parent.criteriaDetailFrame.location.href		="../../eCommon/html/blank.html"
		parent.criteriaTickSheetsFrame.location.href	="../../eCommon/html/blank.html"
	}

	bean_id 	= document.tickSheetForm.bean_id.value;
	bean_name 	= document.tickSheetForm.bean_name.value;
	if(document.tickSheetForm.order_category_yn.value=="Y" && document.tickSheetForm.order_type_yn.value=="Y")
	{
		document.tickSheetForm.order_category.disabled 	= true;
		document.tickSheetForm.order_type.disabled 		= true;
	}
	else if(document.tickSheetForm.order_category_yn.value =="N" && document.tickSheetForm.order_type_yn.value =="N")
	{
		document.tickSheetForm.order_category.disabled 	= false;
		document.tickSheetForm.order_type.disabled 		= false;
	}
	else
	{
		document.tickSheetForm.order_category.disabled 	= true;
		document.tickSheetForm.order_type.disabled 		= false;
	}
	// Even for null it should populate
	if(document.tickSheetForm.order_type.value!="" )
	{
	/*Added by Uma on 8/24/2009 for PMG0089 CRF-641*/
	var Applicability_yn = "";
	if(document.tickSheetForm.ApplicableCatalogs)
		Applicability_yn = document.tickSheetForm.ApplicableCatalogs.value;
	/*Modified by Uma on 8/24/2009 for PMG0089 CRF-641 added Applicability_yn*/
	parent.criteriaDetailFrame.location.href		="../../eOR/jsp/OrderEntrySectionDisplay.jsp?tick_sheet_id="+document.tickSheetForm.tick_sheet_id.value+"&order_category="+document.tickSheetForm.order_category.value+"&function_from="+document.tickSheetForm.function_from.value+"&order_type="+obj.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&priv_applicability_yn="+Applicability_yn;
	parent.criteriaTickSheetsFrame.location.href	="../../eCommon/html/blank.html"
	}else
		return false;
}

 function SubmitLink(from, to) {   //Over writing the method in the common for the result screen in the additional search
	//IN038787 Start.

	//document.orderSetResultForm.from.value 	= from;
	//document.orderSetResultForm.to.value 	= to;
	//storeValues(document.orderSetResultForm,"orderSetResultForm");  // Calling the dynamic jsp to set the values in the bean
	//document.orderSetResultForm.submit();

	if(document.orderSetResultForm!=undefined){
		document.orderSetResultForm.from.value 	= from;
		document.orderSetResultForm.to.value 	= to;
		storeValues(document.orderSetResultForm,"orderSetResultForm");  // Calling the dynamic jsp to set the values in the bean
		document.orderSetResultForm.submit();
	}else if(document.tickSheetItemsForm!=undefined){
		document.tickSheetItemsForm.from.value 	= from;
 		document.tickSheetItemsForm.to.value 	= to;
 		storeValues(document.tickSheetItemsForm,"tickSheetItemsForm");  // Calling the dynamic jsp to set the values in the bean
 		document.tickSheetItemsForm.submit();
	}
	//IN038787 End.
}

function callOnMouseOver(obj){
	currClass = obj.className ;
		obj.className = 'CASECONDSELECTHORZ';
}

function callOnMouseOut(obj){
	obj.className = currClass;
}

//IN038787 Start.
//function setCheckBoxVal(obj,prompt_yn,catalog_code,form_name,order_category)
function setCheckBoxVal(obj,prompt_yn,catalog_code,form_name,order_category,from_obj)
//IN038787 End.
{
	
	var bean_id = ""; var bean_name = "";var counter=0;
	
	var fun_from = "";
   	if(form_name == "recentlyAccessedForm_practitioner")   // For Recently Accessed (Practitioner Frame)
	{
		tab_frame_name 			= parent.tabFrame	 // Get the frame reference , since global js is  
 		care_set_check_box_val 	= criteriaMainFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm.care_set_check_box_val.value;
		//frame_name				= criteriaMainFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm
		frame_name				= criteriaMainFrame.criteriaDetailResultsFrame.document.getElementById("recentlyAccessedForm");
  	}
	else if(form_name == "recentlyAccessedForm_patient")   // For Recently Accessed (Patients Frame)
	{
 		tab_frame_name 			= parent.tabFrame	 // Get the frame reference , since global js is  
 		care_set_check_box_val 	= criteriaDetailFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm.care_set_check_box_val.value;
		//frame_name				= criteriaDetailFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm
		frame_name				= criteriaDetailFrame.criteriaDetailResultsFrame.document.getElementById("recentlyAccessedForm");		
  	}
/*	else if(form_name == "drawingToolResults")   // For Drawing Tool Results
	{
 		tab_frame_name 			= parent.parent.tabFrame	 // Get the frame reference , since global js is included
		//order_category 			= criteriaTickSheetsFrame.document.tickSheetItemsForm.order_category.value;
		care_set_check_box_val 	= document.drawingToolResults.care_set_check_box_val.value;
 		frame_name				= document.drawingToolResults
 	}
*/
	else if(form_name == "careSetMatrixForm")
		fun_from 	=document.careSetMatrixForm.function_from.value;
 	else if(form_name == "tickSheetItemsForm")   // For Tick Sheets
	{
		//IN038787 Start.
		/*tab_frame_name 			= parent.tabFrame	 // Get the frame reference , since global js is included
		care_set_check_box_val 	= criteriaTickSheetsFrame.document.tickSheetItemsForm.care_set_check_box_val.value;
		fun_from 	= criteriaTickSheetsFrame.document.tickSheetItemsForm.function_from.value;
		frame_name				= criteriaTickSheetsFrame.document.getElementById("tickSheetItemsForm");
		*/
		tab_frame_name 				= parent.parent.tabFrame;
		if(from_obj=="resultHdrFrame"){
			care_set_check_box_val  = parent.criteriaTickSheetsFrame.resultHdrFrame.document.tickSheetItemsForm.care_set_check_box_val.value;
			fun_from 				= parent.criteriaTickSheetsFrame.resultHdrFrame.document.tickSheetItemsForm.function_from.value;
			frame_name				= parent.criteriaTickSheetsFrame.resultHdrFrame.document.getElementById("tickSheetItemsForm");
		}else if(from_obj=="resultListFrame"){
			care_set_check_box_val  = parent.criteriaTickSheetsFrame.resultListFrame.document.tickSheetItemsForm.care_set_check_box_val.value;
			fun_from 				= parent.criteriaTickSheetsFrame.resultListFrame.document.tickSheetItemsForm.function_from.value;
			frame_name				= parent.criteriaTickSheetsFrame.resultListFrame.document.getElementById("tickSheetItemsForm");
		}else if(from_obj=="resultDtlFrame"){
			care_set_check_box_val  = parent.criteriaTickSheetsFrame.resultDtlFrame.document.tickSheetItemsForm.care_set_check_box_val.value;
			fun_from 				= parent.criteriaTickSheetsFrame.resultDtlFrame.document.tickSheetItemsForm.function_from.value;
			frame_name				= parent.criteriaTickSheetsFrame.resultDtlFrame.document.getElementById("tickSheetItemsForm");
		}
		//IN038787 End.
	}
	else if(form_name == "imagePanelsForm") // For Image Screen
	{
		order_category 			= DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.order_category.value;
		tab_frame_name 			= tabFrame	 // Get the frame reference , since global js is included
		//frame_name				= DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm;
		frame_name				= DetailFrame.displayTransaction.imageOrderCatalogs.document.getElementById("imagePanelsForm");
		fun_from 	= DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.function_from.value;
	}
	else		// For Addnl .Search
	{
		tab_frame_name 			= parent.parent.parent.tabFrame // Get the frame reference, since global js is included
 		order_category 			= document.orderSetResultForm.order_category.value;
		care_set_check_box_val 	= document.orderSetResultForm.care_set_check_box_val.value;
		fun_from				= document.orderSetResultForm.function_from.value;
		//frame_name			= document.orderSetResultForm
		frame_name				= document.getElementById("orderSetResultForm");
	}
	fun_from=trimString(fun_from);	
	/*Added by Ambiga.M on 3/11/2010 for 19656 (if condition added to restrict orderset in amend mode) */
	if(fun_from=="AMEND_ORDER" && obj.checked==true && order_category == "CS")
	{	
		alert(getMessage("ORDERSET_NOT_ALLOWED_IN_AMEND","OR"));
		obj.checked=false;		
		obj.value = "N";
	}
	else
	{
   	prompt_msg				= frame_name["prompt_desc"+catalog_code].value;
 	//bill_warn_message		= frame_name["bill_warn"+catalog_code].value;
 	//bill_warn_err_message	= frame_name["bill_warn_err"+catalog_code].value;
 	//bill_error_message	    = frame_name["bill_error"+catalog_code].value;
   	
/*	prompt_msg				= eval("frame_name.prompt_desc"+catalog_code+".value");
 	bill_warn_message		= eval("frame_name.bill_warn"+catalog_code+".value");
 	bill_warn_err_message	= eval("frame_name.bill_warn_err"+catalog_code+".value");
 	bill_error_message	    = eval("frame_name.bill_error"+catalog_code+".value"); */

	//bean_id					= eval("frame_name.bean_id.value");
	//bean_name				= eval("frame_name.bean_name.value");
 
		
 	if(obj.checked==true && order_category == "CS")	//Only used for the Care sets, at a time only one to be selected
	{	
		var returnedValue=getOrderSetChecked();		
		/*Added by Uma on 3/1/2010 for IN019691*/
		/*if(returnedValue>0)
		{
			alert(getMessage("ORDER_SET_SELECTED","OR"));
			obj.checked = false;
			return;
		}*/
		if(care_set_check_box_val=="Y"&&returnedValue>0&&returnedValue!="null"&& returnedValue!=null)
		{
			alert(getMessage("ORDER_SET_SELECTED","OR"));
			obj.checked = false;
			return; // Don't allow the user to select more than one
		}
		else
		{
			/*Ends Here by Uma for IN019691*/
			if(obj.checked==true && order_category == "CS")
			{			
				counter++;			
				setOrderSetChecked("OrderSetChecked",counter);			
			}
			eval("frame_name.care_set_check_box_val.value ='Y'");
		}
		

	}
	else if(obj.checked==false && order_category == "CS")
	{
		counter=0;		
		setOrderSetChecked("OrderSetChecked",counter);
		eval("frame_name.care_set_check_box_val.value ='N'");
		
	}
 	if(obj.checked == true)
	{
		//if(unescape(bill_warn_message)!="")
		//{
			//var mess = confirm(unescape(bill_warn_message));   //show the confirm with the billing message
			//if(mess==true)
				//obj.checked = true;
			//else
			//{
				//obj.checked = false;
				//return;
			//}
		//}
		//if(unescape(bill_warn_err_message)!="")
		//{
		//	alert(unescape(bill_warn_err_message));
			//obj.checked = true;
		//}
		//else if(unescape(bill_error_message)!="")
		//{
			//alert(unescape(bill_error_message));
			//obj.checked = false;
			//return;
		//}
		if(unescape(prompt_yn)=="Y")
		{
			var mess = confirm(unescape(prompt_msg));   //show the confirm with the message
			if(mess==true)
				obj.checked = true;
			else
			 	obj.checked = false;
		}
	}
 	// Call a method to keep track of the code selected, it is an global script variable in OrderEntryTab.jsp
	setCatalogCode(obj,tab_frame_name,"OR"); // Method is in OrderEntrySearch.js,When calling from module OR
	// Till here
	 // Setting the check box value -- "Y",
	 // This will help in submitting the values to the bean or not, if the user has not checked or not changed any thing, no need to submit the values to the bean
     if(form_name == "recentlyAccessedForm_practitioner") 
		criteriaMainFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm.check_box_val.value		= "Y";
	 else if(form_name == "recentlyAccessedForm_patient") {
		criteriaDetailFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm.check_box_val.value	= "Y";
 	 }
/*	 else if(form_name == "drawingToolResults")  {  // for drawingToolResults
		document.drawingToolResults.check_box_val.value = "Y";
		if(obj.checked == true)
			populateDrawingTools(catalog_code);
		//Load the below frame and put it in the bean
	}	
*/
 	 else if(form_name == "tickSheetItemsForm"){   // for Tick Sheets
		//IN038787 Start.
		//criteriaTickSheetsFrame.document.tickSheetItemsForm.check_box_val.value = "Y";
		if(from_obj=="resultHdrFrame"){
			parent.criteriaTickSheetsFrame.resultHdrFrame.document.tickSheetItemsForm.check_box_val.value = "Y";
		}else if(from_obj=="resultListFrame"){
			parent.criteriaTickSheetsFrame.resultListFrame.document.tickSheetItemsForm.check_box_val.value = "Y";
		}else if(from_obj=="resultDtlFrame"){
			parent.criteriaTickSheetsFrame.resultDtlFrame.document.tickSheetItemsForm.check_box_val.value = "Y";
		}
		//IN038787 End.
	 }else if(form_name == "imagePanelsForm") // For Image Screen
		DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.check_box_val.value = "Y";
	 else  // For Additional Search
		document.orderSetResultForm.check_box_val.value = "Y";
 
 	   /* if(parent.parent.parent.secondFrame) {
			parent.parent.parent.secondFrame.location.href="OrderEntry.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&check_box_value="+escape(tab_frame_name.check_box_val);
		}
	  */
	/* if(parent.parent.parent.secondFrame) {
			
			var htmlText= "<html><body><form action='../../eOR/jsp/OrderEntry.jsp' method='post' name='temp_form' id='temp_form'>";
			htmlText	+="<input type='hidden' name='bean_id' id='bean_id' value=\""+bean_id+"\">";
 			htmlText	+="<input type='hidden' name='bean_name' id='bean_name' value=\""+bean_name+"\">";
			htmlText	+="<input type='hidden' name='check_box_value' id='check_box_value' value=\""+tab_frame_name.check_box_val+"\">";
			htmlText	+="</form></body></html>";
  			parent.parent.parent.secondFrame.document.body.insertAdjacentHTML('afterbegin',htmlText);
			parent.parent.parent.secondFrame.document.temp_form.submit();				
			//parent.parent.parent.secondFrame.document.temp_form.method	  =  "POST";
			//parent.parent.parent.secondFrame.document.temp_form.action 	  = "../../eOR/jsp/OrderEntry.jsp";
			//parent.parent.parent.secondFrame.document.temp_form.submit();
		}
	*/ 
	}
 }

/*
 *  This Function is called on click of the Next / Previous HyperLinks In Addnl. Search
 *  and this is also called in the Tick Sheets Tab, where on change of the Order Type or
 *  Tick Sheet or at the time of changing the sections
 */
function storeValues(form_object,form_name)
{ 
	var bean_id 		= "";
	var bean_name 		= "";
	var form_obj 		= "";
	var tab_frame_name	= "";
	var check_box_value	= "";
 	if(form_name == "placeOrderForm")			//If called on click of the refresh button in Place Order
	{
		/*Commented by Uma on 1/28/2010 for IN018383*/
		//if(criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.check_box_val.value!="Y")
		//return ;
		/*Ends Here*/
		bean_id 			= criteriaPlaceOrderFrame.placeOrderDetailFrame.document.getElementById('bean_id').value ;
		bean_name 			= criteriaPlaceOrderFrame.placeOrderDetailFrame.document.getElementById('bean_name').value ;
		form_obj			= form_object.elements;
		tab_frame_name		= parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
	}
	else if(form_name == "orderSetResultForm")  // When called from Addnl.Search
	{
		/*Commented by Uma on 1/28/2010 for IN018383*/
		//if(document.orderSetResultForm.check_box_val.value!="Y")
		//return ;
		/*Ends Here*/
		bean_id 			= document.getElementById('bean_id').value ;
		bean_name 			= document.getElementById('bean_name').value ;
		form_obj			= form_object.elements;
		tab_frame_name		= parent.parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
	}
	else  if(form_name == "tickSheetItemsForm")// when called from Tick Sheets
	{
		//IN038787 Start.
		/*	
		if(parent.criteriaTickSheetsFrame==null || parent.criteriaTickSheetsFrame.document.tickSheetItemsForm==null) //If there is no frame for panels
		return;
		//Commented by Uma on 1/28/2010 for IN018383/
		//if(parent.criteriaTickSheetsFrame.document.tickSheetItemsForm.check_box_val.value!="Y")
		//return ;
		//Ends Here/
		bean_id 			= parent.criteriaTickSheetsFrame.document.tickSheetItemsForm.bean_id.value ;
		bean_name 			= parent.criteriaTickSheetsFrame.document.tickSheetItemsForm.bean_name.value ;
		form_obj			= parent.criteriaTickSheetsFrame.document.tickSheetItemsForm;
		tab_frame_name		= parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
		*/
		
		bean_id 			= form_object.bean_id.value ;
		bean_name 			= form_object.bean_name.value ;
		form_obj			= form_object.elements;
		if(parent.parent.tabFrame!=undefined){
			tab_frame_name		= parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
		}else if(parent.parent.parent.tabFrame!=undefined){
			tab_frame_name		= parent.parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
		}
		//IN038787 End.
	}
	else if(form_name=="imagePanelsForm") // When called from the Image frame (Search Button)
	{
		if(parent.imageOrderCatalogs==null || parent.imageOrderCatalogs.document.imagePanelsForm==null) //If there is no frame for panels
		return;
		/*Commented by Uma on 1/28/2010 for IN018383*/
		//if(parent.imageOrderCatalogs.document.imagePanelsForm.check_box_val.value!="Y")
		//return ;
		/*Ends Here*/
		bean_id 			= parent.imageOrderCatalogs.document.imagePanelsForm.bean_id.value ;
		bean_name 			= parent.imageOrderCatalogs.document.imagePanelsForm.bean_name.value ;
		form_obj			= parent.imageOrderCatalogs.document.imagePanelsForm;
	}
	else if(form_name=="image_form") // When called from the Image frame (on click of the radio button front/back)
	{
		if(parent.displayTransaction.imageOrderCatalogs==null || parent.displayTransaction.imageOrderCatalogs.document.imagePanelsForm==null) //If there is no frame for panels
		return;
		/*Commented by Uma on 1/28/2010 for IN018383*/
		//if(parent.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.check_box_val.value!="Y")
		//return ;
		/*Ends Here*/
		bean_id 			= parent.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.bean_id.value ;
		bean_name 			= parent.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.bean_name.value ;
		form_obj			= parent.displayTransaction.imageOrderCatalogs.document.imagePanelsForm;
		tab_frame_name		= parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
	}
	else if(form_name=="careSetButtonForm") // When called from the care sets buttonform
	{
		if(parent.criteriaButtonFrame==null || parent.criteriaButtonFrame.document.getElementById('careSetButtonForm')==null) //If there is no frame for panels
		return;
		/*Commented by Uma on 1/28/2010 for IN018383*/
		//if(parent.criteriaButtonFrame.document.careSetButtonForm.check_box_val.value!="Y")
		//return ;
		/*Ends Here*/
		bean_id 			= parent.criteriaButtonFrame.document.careSetButtonForm.bean_id.value ;
		bean_name 			= parent.criteriaButtonFrame.document.careSetButtonForm.bean_name.value ;
		form_obj			= parent.criteriaButtonFrame.document.careSetButtonForm;
		tab_frame_name		= parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)

	}
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	for(var i=0;i<form_obj.length;i++)
	{
		var value = "" ;
	    if(form_obj[i].type == "checkbox")
	    {
		  	if(form_obj[i].checked && !form_obj[i].disabled)
		       	value = form_obj[i].value;
	        if(form_obj[i].name != null && form_obj[i].name != "" && !form_obj[i].disabled)
	            xmlStr+= form_obj[i].name+"=\"" + checkSpl(value) + "\" " ;
	    }
	    else if(form_obj[i].type == "hidden")
	    {
	    	// Call a function addStatus() to add the necessary parameters no need to add bean-id,bean_name,from,to.etc
	  		if(addStatus(form_obj[i].name)==true)
	    	{
	    		value = form_obj[i].value;
	    	    xmlStr+= form_obj[i].name+"=\"" + checkSpl(value) + "\" " ;
		    }
	    }
    }
    xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	// Only on click of the place order tab, send the array to the bean, where it is set
    if(tab_frame_name!="")
    {
    	check_box_value = tab_frame_name.check_box_val  // Get the Global JavaScript variable Stored  (OrderEntryTab.jsp)
    } // End of if tab_frame_name
	xmlHttp.open( "POST", "OrderEntryStoreValues.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&check_box_value="+check_box_value, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}


// This Function is called on change of the tabs, to store the values in the bean if checked or unchecked

function storeCheckedValues(form_name,search_from)
{  
	var bean_id 		= "";var chk_box_val_group = "";
	var bean_name 		= "";var chk_box_val_atomic = "";var chk_box_val_profile = "";
	var tab_frame_name 	= "";
	var check_box_value	= "";
	var form_obj 		= new Array();
 	if(form_name == "orderSetResultForm")  // When called from Addnl.Search
	{
		if(search_from=="NO")
		{
			if(parent.DetailFrame.criteriaMainFrame == null)
			return ;
			frame_name 			= "parent.DetailFrame";
			if(parent.DetailFrame.criteriaMainFrame.document.addlSearchCriteriaForm)
			{
				bean_id 			= parent.DetailFrame.criteriaMainFrame.document.addlSearchCriteriaForm.bean_id.value;
				bean_name 			= parent.DetailFrame.criteriaMainFrame.document.addlSearchCriteriaForm.bean_name.value;
			}
				tab_frame_name		= parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
		}
		else
		{
			frame_name			= "parent";
			if(document.addlSearchCriteriaForm)
			{
				bean_id 			= document.addlSearchCriteriaForm.bean_id.value;
				bean_name 			= document.addlSearchCriteriaForm.bean_name.value
			}
				tab_frame_name		= parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
		}
		frame					= eval(frame_name+".search_frames");
		if(frame=="")
			frame = "All";
		if(frame=="All")
		{
			if(eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm"))
			{
				form_obj[0]			= eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm");
				chk_box_val_group	= eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm.check_box_val.value");
			}
			if(eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm"))
			{
				form_obj[1]			= eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm");
				chk_box_val_profile	= eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm.check_box_val.value");
			}
			if(eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm"))
			{
				form_obj[2]			= eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm");
				chk_box_val_atomic	= eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm.check_box_val.value");
			}
			if(chk_box_val_group!="Y" && chk_box_val_profile!="Y" &&  chk_box_val_atomic!="Y")
				return ;
		}
		else if(frame=="Atomic_Profile")
		{
			if(eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm"))
			{
			  	form_obj[0]			= eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm");
			  	chk_box_val_atomic	= eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm.check_box_val.value");
			}
		  	if(eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm"))
		  	{
				form_obj[1]			= eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm");
				chk_box_val_profile	= eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm.check_box_val.value");
			}
			if(chk_box_val_atomic!="Y" && chk_box_val_profile!="Y")
				return ;
		}
		else if(frame=="Group_Atomic")
		{
			if(eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm"))
			{
				form_obj[0]			= eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm");
				chk_box_val_group	= eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm.check_box_val.value");
			}
			if(eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm"))
			{
				form_obj[1]			= eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm");
				chk_box_val_profile = eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm.check_box_val.value");
			}
			if(chk_box_val_group!="Y" && chk_box_val_profile!="Y")
				return ;
		}
		else if(frame=="Group_Profile")
		{
			if(eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm"))
			{
				form_obj[0]			= eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm");
				chk_box_val_group	= eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm.check_box_val.value");
			}
			if(eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm"))
			{
				form_obj[1]			= eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm");
				chk_box_val_profile = eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm.check_box_val.value");
			}
			if(chk_box_val_group!="Y"  && chk_box_val_profile!="Y")
			return ;
		}
		else if(frame=="Group")
		{
			if(eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm"))
			{
				form_obj[0]			= eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm");
				chk_box_val 		= eval(frame_name+".criteriaDetailFrame.resultHdrFrame.document.orderSetResultForm.check_box_val.value");
				if(chk_box_val!="Y")
					return ;
			}
		}
		else if(frame=="Atomic")
		{
			if(eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm"))
			{
				form_obj[0]			= eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm");
				chk_box_val 		= eval(frame_name+".criteriaDetailFrame.resultDtlFrame.document.orderSetResultForm.check_box_val.value");
				if(chk_box_val!="Y")
					return ;
			}
		}
		else if(frame=="Profile")
		{
			if(eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm"))
			{
				form_obj[0]			= eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm");
				chk_box_val 		= eval(frame_name+".criteriaDetailFrame.resultListFrame.document.orderSetResultForm.check_box_val.value");
				if(chk_box_val!="Y")
					return;
			}
		}
	}
	else if(form_name == "recentlyAccessedForm") // When called from PREVIEW Button (recentlyAccessedForm on click)
	{
		var frame_obj				= "";var chk_box_val_pract = ""; var chk_box_val_patient = "";
		var second_frame_obj		= "";
		// Submit both the frames, Recently Accessed by Practitioner and Recently Accessed by Patients
 
 		if(parent.DetailFrame){
			if(parent.DetailFrame.criteriaMainFrame)
				frame_obj				= parent.DetailFrame.criteriaMainFrame
 			if(parent.DetailFrame.criteriaDetailFrame)
				second_frame_obj		= parent.DetailFrame.criteriaDetailFrame
		}else if(parent.parent.parent.DetailFrame) {
				frame_obj				= parent.parent.parent.DetailFrame.criteriaMainFrame
 			if(parent.parent.parent.DetailFrame.criteriaDetailFrame)
				second_frame_obj		= parent.parent.parent.DetailFrame.criteriaDetailFrame
		}
  		if(frame_obj) {
				new_frame_obj		= frame_obj.criteriaDetailResultsFrame //Practitioner Frame
 				if(new_frame_obj) {
 					form_obj[0]			= new_frame_obj.document.recentlyAccessedForm;
   					chk_box_val_pract	= new_frame_obj.document.recentlyAccessedForm.check_box_val.value 
 				}
				
				new_frame_obj			= second_frame_obj.criteriaDetailResultsFrame  // Patient Frame
 				if(new_frame_obj) {
 					form_obj[1]			= new_frame_obj.document.recentlyAccessedForm;
   					chk_box_val_patient	= new_frame_obj.document.recentlyAccessedForm.check_box_val.value
 
 				}
 				// If in the two frames (recently accessed bypractitioner, recently acessed by patient) none of the order catalog is not cheched
				// then no need to submit it.
 				if(chk_box_val_pract!="Y" && chk_box_val_patient!="Y")
					return;
				bean_id 				= new_frame_obj.document.recentlyAccessedForm.bean_id.value;
 				bean_name 				= new_frame_obj.document.recentlyAccessedForm.bean_name.value
				if(parent.tabFrame)	
					tab_frame_name		= parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
				else 
	  				tab_frame_name		= parent.parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
  		} 
		else
			return;   //When no reference is there. 
    }
	else if(form_name == "formTab") // When called from PREVIEW Button on Load(that is if the catalog_code is already selected, From ExternalOrders or CP)
	{
 		// Submit both the frames, Recently Accessed by Practitioner and Recently Accessed by Patients
 		if(parent.tabFrame) {
			bean_id 			= document.formTab.bean_id.value;
 			bean_name 			= document.formTab.bean_name.value
 			form_obj[0]			= document.formTab;
   			tab_frame_name		= parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
 		} 
		else
			return;   //When no reference is there. 
    }
/*	else  if(form_name == "drawingToolResults") // when called from Drawing Tools
	{
 		if(parent.DetailFrame)
			frame_obj	= parent.DetailFrame.criteriaMainFrame
		else
			frame_obj	= parent.parent.DetailFrame.criteriaMainFrame
 
 		if(frame_obj==null || frame_obj.document.drawingToolResults==null) //If there is no frame for panels
		return;
		if(frame_obj.document.drawingToolResults.check_box_val.value!="Y")
		return ;
		bean_id 			= frame_obj.document.drawingToolResults.bean_id.value ;
		bean_name 			= frame_obj.document.drawingToolResults.bean_name.value ;
		form_obj[0]			= frame_obj.document.drawingToolResults;
 		if(parent.tabFrame)
			tab_frame_name		= parent.tabFrame;
		else 
			tab_frame_name		= parent.parent.tabFrame;
 		// frame reference for the tab frame (OrderEntryTab.jsp)
	}
*/
	else  if(form_name == "tickSheetItemsForm") // when called from Tick Sheets
	{
		//IN038787 Start.
		/*
 		if(parent.DetailFrame)
			frame_obj	= parent.DetailFrame.criteriaTickSheetsFrame
		else
			frame_obj	= parent.parent.DetailFrame.criteriaTickSheetsFrame
		
		
 		if(frame_obj==null || frame_obj.document.tickSheetItemsForm==null) //If there is no frame for panels
		return;
		if(frame_obj.document.tickSheetItemsForm.check_box_val.value!="Y")
		return ;
		bean_id 			= frame_obj.document.tickSheetItemsForm.bean_id.value ;
		bean_name 			= frame_obj.document.tickSheetItemsForm.bean_name.value ;
		form_obj[0]			= frame_obj.document.tickSheetItemsForm;
		if(parent.tabFrame)
			tab_frame_name		= parent.tabFrame;
		else 
			tab_frame_name		= parent.parent.tabFrame;
		// frame reference for the tab frame (OrderEntryTab.jsp)
		*/
		var frame_name1 = "";
		var frame_name2 = "";
		chk_box_val_group ="N";
		chk_box_val_profile ="N";
		chk_box_val_atomic ="N";
		if(parent.DetailFrame){			
			frame_name1 ="parent.DetailFrame.criteriaTickSheetsFrame";
			frame_name2 = "parent.DetailFrame.criteriaMainFrame";
		}else{			
			frame_name1 ="parent.parent.DetailFrame.criteriaTickSheetsFrame";
			frame_name2 = "parent.parent.DetailFrame.criteriaMainFrame";
		}
		
		if(eval(frame_name1+".resultHdrFrame")!=undefined)
		{
			form_obj[0]			= eval(frame_name1+".resultHdrFrame.document.tickSheetItemsForm");
			chk_box_val_group	= eval(frame_name1+".resultHdrFrame.document.tickSheetItemsForm.check_box_val.value");
		}
		if(eval(frame_name1+".resultListFrame")!=undefined)
		{
			form_obj[1]			= eval(frame_name1+".resultListFrame.document.tickSheetItemsForm");
			chk_box_val_profile	= eval(frame_name1+".resultListFrame.document.tickSheetItemsForm.check_box_val.value");
		}
		if(eval(frame_name1+".resultDtlFrame")!=undefined)
		{
			form_obj[2]			= eval(frame_name1+".resultDtlFrame.document.tickSheetItemsForm");
			chk_box_val_atomic	= eval(frame_name1+".resultDtlFrame.document.tickSheetItemsForm.check_box_val.value");
		}
		
		if(chk_box_val_group!="Y" && chk_box_val_profile!="Y" &&  chk_box_val_atomic!="Y")
			return ;
		
		bean_id 			= eval(frame_name2+".document.tickSheetForm.bean_id.value") ;
		bean_name 			= eval(frame_name2+".document.tickSheetForm.bean_name.value") ;
		if(parent.tabFrame)
			tab_frame_name		= parent.tabFrame;
		else 
			tab_frame_name		= parent.parent.tabFrame;
			
		//IN038787 End.
	}
	else if(form_name == "imagePanelsForm")
	{
		if(parent.DetailFrame.displayTransaction==null || parent.DetailFrame.displayTransaction.imageOrderCatalogs==null || parent.DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm==null) //If there is no frame for panels
		return;

		if(parent.DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.check_box_val.value!="Y")
		return ;
		bean_id 			= parent.DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.bean_id.value ;
		bean_name 			= parent.DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.bean_name.value ;
		form_obj[0]			= parent.DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm;
		tab_frame_name		= parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
	}
	else if(form_name == "PlaceOrder")
	{
		if(parent.DetailFrame)
		{
			if(parent.DetailFrame.criteriaPlaceOrderFrame)
			if(parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame==null )
				return;  // If the frame is not there..
		}
		else if(parent.parent.parent.DetailFrame)
		{
			if(parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame==null )
				return;  // If the frame is not there..
		}

		if(parent.DetailFrame)
		{
			if(parent.DetailFrame.criteriaPlaceOrderFrame)
				if((parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm)!=undefined)
					if(parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.check_box_val)
						if(parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.check_box_val.value!="Y")
							return ;
		}
		else if(parent.parent.parent.DetailFrame)
		{		
			if(parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame)
				if((parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm)!=undefined)
					if(parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.check_box_val)
						if(parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.check_box_val.value!="Y")
						{
							return ;
						}
					
		}

		if(parent.DetailFrame)
		{
			if(parent.DetailFrame.criteriaPlaceOrderFrame)
			{
				if(parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm)
				{
					bean_id 			= parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.bean_id.value ;
					bean_name 			= parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.bean_name.value ;
					form_obj[0]			= parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
				}			
			}
			tab_frame_name		= parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
		}
		else if(parent.parent.parent.DetailFrame)
		{
			if(parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame)
			{
				if(parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm)
				{
					bean_id 			= parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.bean_id.value ;
					bean_name 			= parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.bean_name.value ;
					form_obj[0]			= parent.parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
				}
			}
			tab_frame_name		= parent.parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)

		}

	}
	var xmlDoc = ""; 
var xmlHttp = new XMLHttpRequest();
 	xmlStr					= "<root><SEARCH " ;
 	for(var form_count=0; form_count<form_obj.length; form_count++) //Like the Apply
    {
    	var frmObj 	 			= form_obj[form_count]
    	var formObj 			= frmObj.elements;
    	for(var i=0;i<formObj.length;i++)
		{
 			var value 		= "" ;
		    if(formObj[i].type == "checkbox")
		    {
		      	if(formObj[i].checked && !formObj[i].disabled)
		      	  	value 	= formObj[i].value;

		        if(formObj[i].name != null && formObj[i].name != "" && !formObj[i].disabled)
		            xmlStr	+= formObj[i].name+"=\"" + checkSpl(value) + "\" " ;
 		    }
		   	else if(formObj[i].type == "hidden")
	    	{
	    		// Call a function addStatus() to add the necessary parameters no need to add bean-id,bean_name,from,to.etc
 	       		if(addStatus(formObj[i].name)==true)
	    		{
	    			value	= formObj[i].value;
	    			xmlStr	+= formObj[i].name+"=\"" + checkSpl(value) + "\" " ;
		        }
	    	}
    	}
	} // End of for frmCount
     // Only on click of the place order tab, put it
    if(tab_frame_name!="")
    {
    	check_box_value = tab_frame_name.check_box_val
		if(check_box_value != null && check_box_value != "")
			check_box_value = (check_box_value);
    } // End of if tab_frame_name
	//xmlStr			+= " CHECK_BOX_VALUE=\""+ check_box_value + "\" ";
    xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryStoreValues.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&check_box_value="+check_box_value, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}



// To not to add the below parameters like bean_id,bean_name etc
function addStatus(name)
{
	if(name == "bean_id")						return false;
	else if(name == "bean_name")				return false;
	else if(name == "from")     				return false;
	else if(name == "to")       				return false;
	else if(name == "order_category")			return false;
	else if(name == "order_type")           	return false;
	else if(name == "activity_type")           	return false;
	else if(name == "order_catalog_nature") 	return false;
	else if(name == "order_nature")         	return false;
	else if(name == "orderable_text")       	return false;
	else if(name == "criteria")             	return false;
	else if(name == "restrict_by")          	return false;
	else if(name == "check_box_val")        	return false;
	else if(name == "group_frame_count")    	return false;
	else if(name == "atomic_frame_count")   	return false;
	else if(name == "profile_frame_count")  	return false;
	else if(name == "display_records")      	return false;
	else if(name == "care_set_check_box_val") 	return false;
	else if(name == "encounter_id")			 	return false;
	else if(name == "patient_class")			return false;
	else if(name == "admission_date")			return false;
	else if(name == "discharge_date_time") 		return false;
	else if(name == "sys_date")   // for place order details
		return false;
	else if(name == "total_rows")   // for place order details
		return false;
	else if(name == "authorized")       // for place order details
		return false;
	else if(name == "patient_id")       // for place order details
		return false;
	else if(name == "encounter_id")     // for place order details
		return false;
	else if(name == "location_type")    // for place order details
		return false;
	else if(name == "location_code")    // for place order details
		return false;
	else if(name == "patient_id")   	// for place order details
		return false;
	else if(name == "priority_hdr")		// for place order details
		return false;
	else if(name == "order_date_time")		// for place order details
		return false;
	else if(name == "header_comments")		// for place order details
		return false;
	else if(name == "validated_status")		// for place order details
		return false;
	else if(name == "mode")		// for place order details
		return false;
	else if(name == "order_category	")		// for place order details
		return false;
	else if(name == "consented")		// for place order details
		return false;
	else if(name == "amend_count")		// for place order details
		return false;
	else if(name == "function_name")		// for place order details
		return false;
	else if(name == "display_auth_count")	// for place order details
		return false;
	else if(name == "rd_install_yn")	// for place order details
		return false;
	else if(name == "ot_install_yn")	// for place order details
		return false;
	else if(name == "new_order_reqd")	// for place order details(Amend)
		return false;
  	else if(name == "function_from")	// for place order details(CP/CA)
		return false;
	else if(name == "p_task_code")	// for place order details(CP/CA)
		return false;
	else if(name == "p_task_srl_no")	// for place order details(CP/CA)
		return false;
	else if(name == "localeName")
		return false;
	else if(name.length > 6 && name.substring(0,5)=="prompt")	// for place order details(Amend)
		return false;
	else if(name.length > 4 && name.substring(0,3)=="bill")	// for place order details(Amend)
		return false;
	//IN038787 Start.
	else if(name=="tick_sheet_id")
		return false;
	else if(name=="section_code")
		return false;
	else if(name=="priv_applicability_yn")
		return false;
	else if(name=="order_dispaly_verticalYN")
		return false;
	//IN038787 End.
	else return true;
}
// To populate the tick sheets on click of the sections
//IN038787 Start.
//function populateTickSheets(order_type,order_category,tick_sheet_id,section_code,bean_id,bean_name,activity_type,priv_applicability_yn,fun_from)
function populateTickSheets(order_type,order_category,tick_sheet_id,section_code,bean_id,bean_name,activity_type,priv_applicability_yn,fun_from,order_dispaly_verticalYN)
//IN038787 End.
{
	//Before Reloading the panels, if any check box has been checked , set the value into the bean
	//IN038787 Start.
	//storeValues(document.tickSheetItemsForm,"tickSheetItemsForm");  // Calling the dynamic jsp to set the values in the bean
	if(parent.criteriaTickSheetsFrame.resultHdrFrame!=undefined)
		storeValues(parent.criteriaTickSheetsFrame.resultHdrFrame.document.tickSheetItemsForm,"tickSheetItemsForm");  // Calling the dynamic jsp to set the values in the bean
	if(parent.criteriaTickSheetsFrame.resultListFrame!=undefined)
		storeValues(parent.criteriaTickSheetsFrame.resultListFrame.document.tickSheetItemsForm,"tickSheetItemsForm");  // Calling the dynamic jsp to set the values in the bean
	if(parent.criteriaTickSheetsFrame.resultDtlFrame!=undefined)
		storeValues(parent.criteriaTickSheetsFrame.resultDtlFrame.document.tickSheetItemsForm,"tickSheetItemsForm");  // Calling the dynamic jsp to set the values in the bean
	//IN038787 End.
   /*Modified by Uma on 8/24/2009 for PMG20089 -CRF 641 added priv_applicability_yn*/	
   parent.criteriaTickSheetsFrame.location.href="../../eOR/jsp/OrderEntryTickSheetPanels.jsp?order_type="+order_type+"&order_category="+order_category+"&activity_type="+activity_type+"&tick_sheet_id="+tick_sheet_id+"&section_code="+section_code+"&bean_id="+bean_id+"&bean_name="+bean_name+"&function_from="+fun_from+"&priv_applicability_yn="+priv_applicability_yn+"&order_dispaly_verticalYN="+order_dispaly_verticalYN;
}

//IN042045 included pract_type
//IN038787 Start
//function displayToolTip(measure_id,contr_msr_panel_id,order_catalog_nature,category,bean_id,bean_name,catalog_code,i,form_name,pract_type){
async function displayToolTip(measure_id,contr_msr_panel_id,order_catalog_nature,category,bean_id,bean_name,catalog_code,i,form_name,pract_type,frame_name){
//IN038787 End.
    if(form_name == "recentlyAccessedForm_practitioner") // Recently Accessed Practitioner Frame 
	       form_name = "criteriaMainFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm";
	else if(form_name == "recentlyAccessedForm_patient") // Recently Accessed Patient Frame  
	       form_name = "criteriaDetailFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm";
    //else if (form_name == "drawingToolResults")
	//	form_name = "document.drawingToolResults";
    else if(form_name == "orderSetResultForm")
	  form_name = "document.orderSetResultForm";
	else if(form_name == "tickSheetItemsForm"){
		// IN038787 Start.
		//form_name = "criteriaTickSheetsFrame.document.tickSheetItemsForm";
		if(frame_name == "resultHdrFrame" ){
			form_name = "parent.criteriaTickSheetsFrame.resultHdrFrame.document.tickSheetItemsForm";
		}else if(frame_name == "resultListFrame" ){
			form_name = "parent.criteriaTickSheetsFrame.resultListFrame.document.tickSheetItemsForm";
		}else if(frame_name == "resultDtlFrame" ){
			form_name = "parent.criteriaTickSheetsFrame.resultDtlFrame.document.tickSheetItemsForm";
		}
		//IN038787 End.
	}else if(form_name == "imagePanelsForm")
    	form_name = "DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm";
    //var catalog_desc	= eval(form_name+".catalog_desc"+order_catalog_nature+i+".value");
 	var catalog_desc	= eval(form_name+".catalog_desc"+catalog_code+i+".value");
	var encounter_id	= "",patient_class="",admission_date="",discharge_date_time="";
	form_name = eval(form_name);
	if(form_name.encounter_id){
		encounter_id = form_name.encounter_id.value;
		patient_class = form_name.patient_class.value;
		admission_date = form_name.admission_date.value;
		discharge_date_time = form_name.discharge_date_time.value;
	}
    //var finalString 	= "measure_id="+measure_id +"&contr_msr_panel_id="+contr_msr_panel_id+"&order_catalog_nature="+order_catalog_nature+"&category="+category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&catalog_desc="+encodeURIComponent(catalog_desc)+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&admission_date="+admission_date+"&discharge_date_time="+discharge_date_time;changed on 7/10/2007 to add catalog_code
    var finalString 	= "measure_id="+measure_id +"&contr_msr_panel_id="+contr_msr_panel_id+"&order_catalog_nature="+order_catalog_nature+"&category="+category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&catalog_desc="+encodeURIComponent(catalog_desc)+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&admission_date="+admission_date+"&discharge_date_time="+discharge_date_time+"&catalog_code="+catalog_code+"&pract_type="+pract_type;//IN042045
    var retVal 			= new String();
	var dialogHeight 	= "45vh" ;
	var dialogWidth  	= "24vw" ;
	var dialogTop    	= "300";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal				= await top.window.showModalDialog("../../eOR/jsp/OrderEntryToolTipFrameSet.jsp?"+finalString,arguments,features);
}


function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

// Called on click of the Allergies button
async function callAllergies(patient_id)
{
	var retVal 			= 	new String();
	var dialogHeight 	= "90vh" ;
	var dialogWidth  	= "100vw" ;
	var dialogTop    	= "10px";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal =await  top.window.showModalDialog("../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&patient_id="+patient_id,arguments,features);
}

// Called on click of the Vitals button in the Place Order
function callVitals()
{
}

// Called on click of the Vitals button in the Place Order
async function callActive(patient_id,encounter_id)
{
	var function_id		= "";
	var no_of_items		= "";
	var option_type		= "";
	var module_id		= document.OrCommonForm.module_id.value
	if(module_id=="PH")   //Used only For Pharmacy Orders
	{
		 function_id	= "PH";
		 no_of_items 	= "3";
		 option_type	= "ACTIVE";

	}
	var query_string	= "patient_id="+patient_id+"&P_function_id="+function_id+"&P_no_of_items="+no_of_items+"&P_option_type="+option_type
	var retVal 			= new String();
	var dialogHeight 	= "90vh" ;
	var dialogWidth  	= "100vw" ;
	var dialogTop    	= "10px";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=no; status:no";
	retVal =await  top.window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&"+query_string,arguments,features);
	if(module_id=="PH" && retVal!=null)
	{
		//Call the PH Js Function (internally will call the jsp and set it into the bean), which will be in PH MOdule
		callActiveProblems(patient_id,encounter_id,retVal); //(in ePH/js/Prescription.js)
	}
}

// Called on click of the Demographic button in the Place Order
async function callDemographic(patient_id)
{
	var retVal 			= 	new String();
	var dialogHeight 	= "90vh" ;
	var dialogWidth  	= "100vw" ;
	var dialogTop    	= "10px";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await top.window.showModalDialog("../../eCA/jsp/DemographicsView.jsp?patient_id="+patient_id,arguments,features);
}

// Called on click of the Drug Profile button in the Place Order
//IN061988 Start.
//function callDrugProfile(patient_id)
async function callDrugProfile(patient_id,pat_class,encounter_id)
//IN061988 End.
{
	
	var retVal 			= new String();
	var dialogHeight 	= "90vh" ;
	var dialogWidth  	= "100vw" ;
	var dialogTop    	= "10px";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	//IN061988 Start.
	//retVal = window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+patient_id+"&called_frm=Prescription",arguments,features);
	retVal = await top.window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+patient_id+"&pat_class="+pat_class+"&encounter_id="+encounter_id+"&called_frm=Prescription",arguments,features);
	//IN061988 End.
}

// To disable the Order Category
function disableOrderCategory(form_name)
{
	if(form_name=='tickSheetForm')
		document.tickSheetForm.order_category.disabled = true;
	else if(form_name=='imageSearchForm')  // If called from the Image
		document.imageSearchForm.order_category.disabled = true;
	else if(form_name=='careSetSearchForm')  // From Care Sets
		document.careSetSearchForm.order_category.disabled = true;
	else
		document.addlSearchCriteriaForm.order_category.disabled = true;
}

// To disable the Order Category
function disableOrderType(form_name)
{
	if(form_name=='tickSheetForm')
	{
		document.tickSheetForm.order_type.disabled=true;
		document.tickSheetForm.ordertypesearch.disabled=true;
	}
	else if(form_name=='imageSearchForm')  // If called from the Image
	{
		document.imageSearchForm.order_type.disabled=true;
		document.imageSearchForm.ordertypesearch.disabled=true;
	}
	else if(form_name=='careSetSearchForm')  // From Care Sets
	{
		document.careSetSearchForm.order_type.disabled = true;
		document.careSetSearchForm.ordertypesearch.disabled = true;
	}
	else
	{
		document.addlSearchCriteriaForm.order_type_desc.disabled=true;
		document.addlSearchCriteriaForm.ordertypesearch.disabled=true;
	}
}
	
// On Click of the Lab,Rad,.. buttons(TD's), to change the color
// Or on click of the Existing or New orders (TD's)
function changeColor(obj,from_name)
{
	if(from_name=="OR_BUTTONS")
		cellref = criteriaCategoryButtonFrame.document.getElementById("tab").rows[0].cells
	else if(from_name=="COMMON")
		cellref = document.getElementById("tab").rows[0].cells;
	for(i=0; i<cellref.length; i++)
	{
		if(i!=2 && i!=3)
		 cellref[i].className = 'CAFIRSTSELECTHORZ';
	}
	obj.className = "CASECONDSELECTHORZ";
	currClass ="CASECONDSELECTHORZ";
}

/*
 * Function called on click of the order_category buttons in the place order
 */
 async function change_tab_buttons(obj)
 {
	var frmObj			= criteriaCategoryButtonFrame.document.categoryForm;
	/*[IN030566] Start
	//[IN030563] Starts
	var temp_pass		=frmObj.tempPass.value;		
	if(temp_pass==null) temp_pass="";					
	if(temp_pass==""){
		var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		xmlStr			= "<root><SEARCH " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ORPlaceOrderSecurePINTEMPPASSValidation.jsp", false ) ;
		xmlHttp.send( xmlDoc ) ;
		if(trimString(xmlHttp.responseText)!="")
		{
			temp_pass = trimString(xmlHttp.responseText);
			frmObj.tempPass.value=temp_pass;
		}
	}
	//[IN030563] Ends
	[IN030566] Ends */
	
 	patient_id 			= frmObj.patient_id.value;
	encounter_id		= frmObj.encounter_id.value;
	bean_id 			= frmObj.bean_id.value;
	bean_name 			= frmObj.bean_name.value;
	location_type		= frmObj.location_type.value;
	location_code		= frmObj.location_code.value;
	ammend_called_from	= frmObj.ammend_called_from.value;
	function_from		= frmObj.function_from.value;
	patient_class		= frmObj.patient_class.value;
	lb_instal_yn		= frmObj.lb_instal_yn.value;
	session_id 			= frmObj.session_id.value;
	iv_prep_yn 			= frmObj.iv_prep_yn.value;
	order_id 			= frmObj.order_id.value;
	p_order_catalog_code= frmObj.p_order_catalog_code.value;
	p_start_date_time	= frmObj.p_start_date_time.value;
	p_task_code 	 	= frmObj.p_task_code.value;
	p_task_srl_no 		= frmObj.p_task_srl_no.value;
	function_id 		= frmObj.function_id.value;
	episode_id 		= frmObj.episode_id.value;
	pract_reln_id 		= frmObj.pract_reln_id.value;
	p_called_from_ca 		= frmObj.p_called_from_ca.value;
	Sex 		= frmObj.Sex.value;
	Age 		= frmObj.Age.value;
	Dob 		= frmObj.Dob.value;
	visit_adm_date 		= frmObj.visit_adm_date.value;
	licence_key 		= frmObj.licence_key.value;
	called_from 		= frmObj.called_from.value;
	pract_id 		= frmObj.pract_id.value;
	pract_name 		= frmObj.pract_name.value;
	order_mode 		= frmObj.order_mode.value;
	bt_module_install 		= frmObj.bt_module_install.value;


	if(obj=="Laboratory")			order_category	= "LB";
	else if(obj=="Radiology")		order_category	= "RD";
	else if(obj=="RadiologyDept")	order_category	= "RX";
	else if(obj=="Treatment")		order_category	= "TR";
	else if(obj=="Nursing")			order_category	= "NC";
	else if(obj=="PatientCare")		order_category	= "PC";
	else if(obj=="Miscellaneous")	order_category	= "MI";
	else if(obj=="Pharmacy")		order_category	= "PH";
	else if(obj=="OrderSets")		order_category	= "CS";
	else if(obj=="Surgical")		order_category	= "OT";
	else if(obj=="DietaryService")	order_category	= "DS";
	else if(obj=="Consults")	    order_category	= "CN";
	else if(obj=="OralHealth")	    order_category	= "OH";

	// Set the Module Id in the first frame --Useful when clicking the Active Problems
	//parent.parent.parent.orderMainFrame.OrCommonForm.module_id.value  = order_category;
	parent.parent.parent.orderMainTab.OrCommonForm.module_id.value  = order_category;
    bed_num  =	parent.parent.parent.orderMainTab.OrCommonForm.bed_num.value;
	room_num  =	parent.parent.parent.orderMainTab.OrCommonForm.room_num.value;
	var query_string ="";
	if(obj=="Pharmacy")
 	{
		query_string	= "order_category=PH&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&p_order_catalog_code="+p_order_catalog_code+"&p_start_date_time="+p_start_date_time+"&p_task_code="+p_task_code+"&p_task_srl_no="+p_task_srl_no+"&function_from="+function_from+"&bed_num="+bed_num+"&room_num="+room_num+"&function_id="+function_id+"&episode_id="+episode_id+"&pract_reln_id="+pract_reln_id+"&p_called_from_ca="+p_called_from_ca+"&Sex="+Sex+"&Age="+Age+"&Dob="+Dob+"&visit_adm_date="+visit_adm_date+"&licence_key="+licence_key+"&called_from="+called_from+"&pract_id="+pract_id+"&pract_name="+pract_name+"&order_mode="+order_mode+"&bt_module_install="+bt_module_install+"&func_mode=LOAD_PH_TAB";
	}
 	else
 	{
 		//query_string	= "order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&location_type="+location_type+"&location_code="+location_code+"&ammend_called_from="+ammend_called_from+"&function_from="+function_from+"&lb_instal_yn="+lb_instal_yn+"&session_id="+session_id+"&p_order_catalog_code="+p_order_catalog_code+"&p_start_date_time="+p_start_date_time+"&p_task_code="+p_task_code+"&p_task_srl_no="+p_task_srl_no+"&function_from="+function_from+"&func_mode=LOAD_TABS"//IN065324
		//IN066070 starts
 		//query_string	= "order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&location_type="+location_type+"&location_code="+location_code+"&ammend_called_from="+ammend_called_from+"&function_from="+function_from+"&lb_instal_yn="+lb_instal_yn+"&session_id="+session_id+"&p_order_catalog_code="+p_order_catalog_code+"&p_start_date_time="+p_start_date_time+"&p_task_code="+p_task_code+"&p_task_srl_no="+p_task_srl_no+"&function_from="+function_from+"&func_mode=LOAD_TABS"+"&patient_class="+patient_class;//IN065324
		query_string	= "order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&location_type="+location_type+"&location_code="+location_code+"&ammend_called_from="+ammend_called_from+"&function_from="+function_from+"&lb_instal_yn="+lb_instal_yn+"&session_id="+session_id+"&p_order_catalog_code="+p_order_catalog_code+"&p_start_date_time="+p_start_date_time+"&p_task_code="+p_task_code+"&p_task_srl_no="+p_task_srl_no+"&function_from="+function_from+"&func_mode=LOAD_TABS"+"&patient_class="+patient_class+"&called_from="+called_from;
		//IN066070 ends
 	}

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
					// To Synchronize and to avoid Script Error.
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
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
			/*[IN030566] starts	
				//[IN030563] Start
				//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"",arguments,features);
				if(temp_pass==""){
					retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecurePIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"",arguments,features);
				}else
				retVal="true";
				//[IN030563] Ends			
			*/
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
					// To Synchronize and to avoid Script Error.
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
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
					retVal =await window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&keyObj="+patient_id+"_"+pract_id+"_AO_"+order_category+"&patient_id="+patient_id+"&pract_name="+pract_name+"&pract_id="+pract_id+""+"",arguments,features);
				}
				//retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&pract_id="+pract_id+"",arguments,features);
			/*	retVal = window.showModalDialog("../../eOR/jsp/ORPlaceOrderSecureUserPIN.jsp?mode=s&called_frm="+called_frm+"&order_category="+order_category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&pract_name="+pract_name+"&pract_id="+pract_id+"",arguments,features);
			[IN030566] End */
				if(retVal == "true")
				{
					// To Synchronize and to avoid Script Error.
					var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
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
					// To Synchronize and to avoid Script Error.
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
				}
			}
			// else 												//[IN030563]
			else  if(trimString(xmlHttp.responseText)=="NA")		//[IN030563]
			{
			// IN029143 Ends
			// To Synchronize and to avoid Script Error.
				var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
			}
	}
	else
	{
					// To Synchronize and to avoid Script Error.
					var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
					xmlStr			= "<root><SEARCH " ;
					xmlStr 			+=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "OrderEntryValidate.jsp?"+query_string, false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					eval( responseText ) ;
	}//IN029143 
}


// When Refresh Button is clicked
function refresh()
{
	storeValues(criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm,"placeOrderForm"); 
	
	/*criteriaCategoryButtonFrame.location.reload();					//reload the button frame(Lab,Radialogy,etc)
	criteriaPlaceOrderFrame.legendsFrame.location.reload();			// refreshes the Legends frame
	criteriaPlaceOrderFrame.criteriaMainFrame.location.reload(); // refreshes/reload the Header frame in place order
	criteriaPlaceOrderFrame.placeOrderDetailFrame.location.reload(); // refreshes/reload the details frame in place order
	*/
	criteriaCategoryButtonFrame.location.href 					=  criteriaCategoryButtonFrame.location.href;
	criteriaPlaceOrderFrame.legendsFrame.location.href 			=  criteriaPlaceOrderFrame.legendsFrame.location.href;
	criteriaPlaceOrderFrame.criteriaMainFrame.location.href 	=  criteriaPlaceOrderFrame.criteriaMainFrame.location.href;
	criteriaPlaceOrderFrame.placeOrderDetailFrame.location.href =  criteriaPlaceOrderFrame.placeOrderDetailFrame.location.href;
}

function setCheckValue(obj)
{
	// Call a method to store the value in the global variable in OrderEntryGlobal.js which is included in OrderEntryTab.jsp, When calling from Module OR

	setCatalogCode(obj,parent.parent.parent.tabFrame,"OR");
	if(obj.checked==false)
	{
		obj.value	= "N";
		document.placeOrderForm.check_box_val.value = "Y";
	}
	else  obj.value	= "Y";
}
// On Click of the Apply or on click of Record in the place order screen
async function apply() 
{	
	var result_val 					=  true;
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	
	var form				= parent.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	var headerformObj	 			=  parent.criteriaMainFrame.document.placeOrderHeaderForm ;
	var buttonObj	 				=  parent.criteriaDetailFrame.document.buttonForm;
	var ordPlacingWithConsentRecord = "N"; //IN057196
	if(headerformObj)
	{
		//IN067246 starts
		if(headerformObj.total_size&&formObj.total_size)
		{
			formObj.total_size.value		=  headerformObj.total_size.value;
		}
		//IN067246 ends
		if(headerformObj.authorized&&formObj.authorized)
		{
			formObj.authorized.value		=  headerformObj.authorized.value;
		}
		if(headerformObj.special_approved&&formObj.special_approved)
		{
			formObj.special_approved.value	=  headerformObj.special_approved.value;
		}
		if(headerformObj.cosigned&&formObj.cosigned)
		{
			formObj.cosigned.value			=  headerformObj.cosigned.value;
		}
		if(headerformObj.patient_id&&formObj.patient_id)
		{
			formObj.patient_id.value		=  headerformObj.patient_id.value;
		}
		if(headerformObj.encounter_id&&formObj.encounter_id)
		{
			formObj.encounter_id.value		=  headerformObj.encounter_id.value;
		}
		if(headerformObj.location_type&&formObj.location_type)
		{
			formObj.location_type.value		=  headerformObj.location_type.value;
		}
		if(headerformObj.location_code&&formObj.location_code)
		{
			formObj.location_code.value		=  headerformObj.location_code.value;
		}
		if((headerformObj.priority)&&(formObj.priority_hdr))
		{
			formObj.priority_hdr.value		=  headerformObj.priority.value;
		}
		if(headerformObj.order_date_time&&formObj.order_date_time)
		{
			formObj.order_date_time.value	=  headerformObj.order_date_time.value;
		}
		//commented by channaveer B fOR Issue ICN24842 and icn 25262 on 29/11/2010
		/*if(headerformObj.header_comments&&formObj.header_comments)
		{
			formObj.header_comments.value	=  headerformObj.header_comments.value;
		}*/
		if(headerformObj.order_category&&formObj.order_category)
		{
			if(headerformObj.order_category.value !="")
			formObj.order_category.value	=  headerformObj.order_category.value;
			else
			formObj.order_category.value	=  formObj.order_category.value;
		}
		if(headerformObj.rd_install_yn&&formObj.rd_install_yn)
		{
			formObj.rd_install_yn.value 	=  headerformObj.rd_install_yn.value;
		}
		if(headerformObj.ot_install_yn&&formObj.ot_install_yn)
		{
			formObj.ot_install_yn.value 	=  headerformObj.ot_install_yn.value;
		}
		if(headerformObj.cosign_reqd_yn&&formObj.cosign_reqd_yn)
		{
			formObj.cosign_reqd_yn.value	=  headerformObj.cosign_reqd_yn.value;
		}
		var ammend_called_from			=  headerformObj.ammend_called_from.value;
		var patient_class				=  headerformObj.patient_class.value;
		var clin_cmts_reqd_yn			=  headerformObj.clin_cmts_reqd_yn.value;
		var clin_cmts_value_entered_yn  =  headerformObj.clin_cmts_value_entered_yn.value;
		var commentsclinic  = trimString( headerformObj.header_comments.value);
		
		//formObj.header_comments.value   = encodeURIComponent(headerformObj.header_comments.value); //--[IN28074]-- commented for IN041069 // uncommented for IN044520 comment for IN044757
		formObj.header_comments.value   = encodeURIComponent(commentsclinic); // added for IN041069 commented for IN044520 uncommented for IN044757
		
	}

	if(formObj)
	{	
		if(formObj.function_name)
		{
			var called_function_name		=  formObj.function_name.value;
		}
		//IN067246
		if(formObj.called_function)
		{
			var called_function		=  formObj.called_function.value;
		}
		//IN067246
		if(formObj.bean_id)
		{
			var bean_id 					=  formObj.bean_id.value;
		}
		if(formObj.bean_name)
		{
			var bean_name 					=  formObj.bean_name.value;
		}
		if(formObj.total_rows)
		{
			var total_count					=  formObj.total_rows.value;
		}
		if(formObj.validated_status)
		{
			formObj.validated_status.value  =  "validation_reqd"; // First time when submitting to check for the validation.
		}
		//IN067246 starts
		if(formObj.orset_ind_flag)
		{
			var orset_ind_flag		=  formObj.orset_ind_flag.value;
		}
		//IN067246 ends
		var consent_reqd				=  "N";
		var consent_stage				=  "";
		var checked_yn					=  "N", new_order_checked 	= false;
		//var hdr_format_result 			= true;//IN064122
		var hdr_format_result 			= false;//IN064122
		line_format_result  = true;
		var hdr_format_result_previewHeader = true; 
		var hdr_care_set_format_result = new Array();	// For care sets header format check
		var auth_count					= 0;

		if(formObj.checkCount)
			 apply_total_count=formObj.checkCount.value;	
	}
	
		// Check for Clinical comments
	if(headerformObj)
	{
		if (headerformObj.cl_cmt_mand!=null)
		{
			if(headerformObj.cl_cmt_mand.style.visibility=="visible")
			{
				headerformObj.clin_cmts_reqd_yn.value="Y";
			}
			else
			{
				headerformObj.clin_cmts_reqd_yn.value="N";
			}
		}
	}
	var clin_cmts_reqd_yn="";

	if(headerformObj)
	{
		if (headerformObj.clin_cmts_reqd_yn!=null)
		{
			clin_cmts_reqd_yn=headerformObj.clin_cmts_reqd_yn.value;
		}
	}		
	// Call a function to check whether atleast one item has been checked,otherwise no need to submit

	if( ammend_called_from!="existing_order")
	{
		result_val 	=await checkToSubmit("parent.placeOrderDetailFrame",formObj);

	} // otherwise it will come as undefined., send the frame reference "parent.placeOrderDetailFrame".		

	if(result_val) // Atleast one item is checked, then proceed
	{
		if(clin_cmts_reqd_yn=="Y" && clin_cmts_value_entered_yn=="N") 
		{ 		
			if(commentsclinic==null||commentsclinic==""||commentsclinic=="null")
			{
				alert(getMessage("CLINICAL_COMMENTS_BLANK","OR"));
				result_val = false;
				return;// Do not submit
			}
			else
			{				
				if(commentsclinic.length>500)
				{
					var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
					msg = msg.replace("$","Clinical Comments");
					msg = msg.replace("#","500");
					alert(msg) ;
					result_val = false;
					return;
				}

			}
		}else if(clin_cmts_reqd_yn=="Y" && clin_cmts_value_entered_yn=="Y") {		
			if(commentsclinic==null||commentsclinic==""||commentsclinic=="null"||(commentsclinic.length==0))
				{
				alert(getMessage("CLINICAL_COMMENTS_BLANK","OR"));
				result_val = false;
				return;// Do not submit
			}
			else
			{
				if(commentsclinic.length>500)
				{
					var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
					msg = msg.replace("$","Clinical Comments");
					msg = msg.replace("#","500");
					alert(msg) ;
					result_val = false;
					return;
				}

			}
		}

		for(var i=0;i<apply_total_count;i++)
		//for(var i=0;i<formObj.length;i++)
		{
			checked_yn					=  "N";
			if(eval("formObj.catalog_code"+i))
			{
				catalog_code_val = eval("formObj.catalog_code"+i+".value");
				//checked_yn		 = eval("formObj.ck"+catalog_code_val+".value");
				checked_yn		 = form["ck"+catalog_code_val].value;
				if(formObj.special_approved.value == "true") //Make all the special_approved_yn as 'N'
				{
					if(eval("formObj.ord_spl_appr_reqd_yn"+i))
						eval("formObj.ord_spl_appr_reqd_yn"+i+".value='N'");
				}
			} // End of if catalog_code
			if(eval("formObj.amend_catalog_code"+i))
			{
				amend_catalog_code_val = eval("formObj.amend_catalog_code"+i+".value");
				//checked_yn		 = eval("formObj.ck"+catalog_code_val+".value");
				checked_yn		 = form["ck"+amend_catalog_code_val].value;
			} // End of if catalog_code
			// If authorization is there, increase the count
			if(formObj.function_name&&formObj.care_set_count)
			{
				if(checked_yn=="Y"&&((formObj.function_name.value == "PREVIEW")&&(formObj.care_set_count.value=="0"))&&(clin_cmts_value_entered_yn=="N"))
				{
					temp_order_cat=eval("formObj.group_order_category"+i).value;
					if(parent.placeOrderDetailFrame.document.getElementById('cl_cmt_mand'+temp_order_cat).style.visibility=="visible")
					{							
						alert(getMessage("CLINICAL_COMMENTS_BLANK","OR"));
						result_val = false;
						return;// Do not submit
					}
				}
			}
			if(eval("formObj.ord_auth_reqd_yn"+i))
			{
				if(checked_yn=="Y" && eval("formObj.ord_auth_reqd_yn"+i))
				{
					var auth_reqd_yn = eval("formObj.ord_auth_reqd_yn"+i+".value");
					if(auth_reqd_yn=="Y")
						auth_count++;
				}
			}
			//To get the consent stage value in order to call the appointment.
			if(eval("formObj.consent_stage"+i) && (consent_reqd == "N" && (consent_stage==""||consent_stage=="R")))
			{
				consent_reqd=eval("formObj.ord_consent_reqd_yn"+i+".value");
				consent_stage=eval("formObj.consent_stage"+i+".value");
			}
			else if(eval("formObj.amend_consent_stage"+i) &&(consent_reqd == "N" &&  (consent_stage==""||consent_stage=="R")))
			{
				consent_reqd=eval("formObj.amend_ord_consent_reqd_yn"+i+".value");
				consent_stage=eval("formObj.amend_consent_stage"+i+".value");
			}
			
			
			// For Amend
			if(eval("formObj.amend_frequency_code"+i))
			{
				var amend_frequency_code = eval("formObj.amend_frequency_code"+i+".value");
				//var amend_frequency_val=eval("formObj.amend_frequency_val"+i+".value");
					
				eval("formObj.amend_frequency_val"+i+".value=amend_frequency_code");
			}			
			// Till here

			if(checked_yn=="Y" && eval("formObj.duration_code"+i))
			{
				var duration_value = eval("formObj.duration_code"+i+".value")
				eval("formObj.duration"+i+".value=duration_value");
			}
			// Validations for the Start Date Time
			if(checked_yn=="Y" && result_val) 
			{
				var mess	= getMessage("CANNOT_BE_BLANK","OR");
				mess		= mess.replace("@","Start Date and Time");
				if(ammend_called_from=="")
					result_val	=await checkMandField(formObj, "start_date_time", "", mess, i);
				else
					result_val	=await checkMandField(formObj, "amend_start_date_time", "", mess, i);
									
			} // End of if checked_yn && result_val
			// Validations for the Frequency, if the freq_applicable_yn = "Y" , then the frequency is mandatory
			if(checked_yn=="Y" &&  result_val && eval("formObj.frequency_val"+i))
			{
				var freq_value	 	= eval("formObj.freq_applicable_yn"+i+".value");
				var frequency_val 	= eval("formObj.frequency_val"+i+".value");
				if(frequency_val=="" && freq_value=="Y")
				{
					result_val		=await displayErrMessage("FREQ_NOT_BLANK", "");
				}
			} // End of if checked_yn && frequency_val
			if(checked_yn=="Y" &&  result_val && eval("formObj.amend_frequency_val"+i))
			{
				var freq_value	 	= eval("formObj.amend_freq_applicable_yn"+i+".value");
				var frequency_val 	= eval("formObj.amend_frequency_val"+i+".value");
				if(frequency_val=="" && freq_value=="Y")
				{
					result_val		=await displayErrMessage("FREQ_NOT_BLANK", "");
				}
			} // End of if checked_yn && frequency_val

			// check for the order_type, the line level should not be blank, it is mandatory
			if(checked_yn=="Y" && result_val && eval("formObj.order_type_code"+i) )
			{
				var order_type 	= eval("formObj.order_type_code"+i+".value");
				result_val	=await checkMandField(formObj, "order_type_code", "ORDER_TYPE","",i);  // message is null,pass the message_id
				if(result_val)
					eval("formObj.order_type"+i+".value=order_type");
			} // End of if checked_yn && order_type_code

			if(checked_yn=="Y" && result_val && eval("formObj.quantity"+i))	// For Quantity should not be null or zero
			{
				var quantity 	= eval("formObj.quantity"+i+".value");
				if(quantity == "null" || quantity == null ||  quantity=="" || quantity==0)
					result_val		=await displayErrMessage("QTY_CANNOT_BE_BLANK", "");// Pass the message_id
			} // End of if checked_yn && result_val 
			// Check for the duration not blank
			if(checked_yn=="Y" && result_val && eval("formObj.duration_value"+i))
			{
				var soft_stop_yn 	= eval("formObj.soft_stop_yn"+i+".value");
				var duration_value 	= eval("formObj.duration_value"+i+".value");
				var duration_code 	= eval("formObj.duration_code"+i+".value");
				var frequency_val 	= eval("formObj.frequency_val"+i+".value");
				if(soft_stop_yn=="Y" && duration_value=="" && frequency_val!="")
				{
				
					if(patient_class!="IP" && duration_code!="")
					
						result_val		=await displayErrMessage("DURATION_CANNOT_BE_BLANK", "");// Pass the message_id
				}
				else
				{
					if(duration_value=="" && frequency_val!="" && duration_code!="")
					
						result_val		=await displayErrMessage("DURATION_CANNOT_BE_BLANK", "");// Pass the message_id
				
				}
				
			} // End of if checked_yn && result_val
			
			
			//IN069674 start
			if(formObj.perfLocnMandFlag != undefined && formObj.call_function !=undefined && formObj.bt_order_type_code !=undefined){
				if("Y"==formObj.perfLocnMandFlag.value && formObj.call_function.value=="ORCAT"){
				
					if(formObj.order_category.value=="RD"){//only for radiology
						if(formObj.order_category&&formObj.rd_install_yn)
						{	
							if( checked_yn=="Y" && result_val && formObj.order_category.value=="RD" && formObj.rd_install_yn.value=="Y")
							{
								if((eval("formObj.performing_dept_loc_code"+i)!=undefined)){
									var performing_dept_loc_code = eval("formObj.performing_dept_loc_code"+i+".value")
									if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
										result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");// Pass the message_id
								}
								if((eval("formObj.amend_perform_loc_code"+i)!=undefined)){
									var performing_dept_loc_code = eval("formObj.amend_perform_loc_code"+i+".value")
									if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
										result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");// Pass the message_id
								}
							}
						}
					}else{//except radiology
						//NEW ORDER
						if(eval("formObj.performing_dept_loc_code"+i)!=undefined){
							var order_type 	= eval("formObj.order_type_code"+i+".value");
							if((formObj.order_category.value!="LB" && result_val && checked_yn=="Y")){
								var performing_dept_loc_code = eval("formObj.performing_dept_loc_code"+i+".value")
								if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
									result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
							}
							if((formObj.order_category.value=="LB" && result_val && checked_yn=="Y") && (order_type!=formObj.bt_order_type_code.value)){
								var performing_dept_loc_code = eval("formObj.performing_dept_loc_code"+i+".value")
								if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
									result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
							}
						}
						//AMEND ORDER
						if(eval("formObj.amend_perform_loc_code"+i)!=undefined ){
							var order_type 	= eval("formObj.amend_order_type"+i+".value");
							if((formObj.order_category.value!="LB" && result_val)){
								var amend_perform_loc_code = eval("formObj.amend_perform_loc_code"+i+".value")
								if(amend_perform_loc_code == "null" || amend_perform_loc_code == null ||  amend_perform_loc_code=="" )
									result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
							}	
							if((formObj.order_category.value=="LB" && result_val) && (order_type!=formObj.bt_order_type_code.value)){
								var amend_perform_loc_code = eval("formObj.amend_perform_loc_code"+i+".value")
								if(amend_perform_loc_code == "null" || amend_perform_loc_code == null ||  amend_perform_loc_code=="" )
									result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
							}	
						}
						
					}
				}
			}
		  //IN069674 end
			//IN066377 start
			if(eval("formObj.perfLocnMandFlag"+i) != undefined && formObj.call_function !=undefined && formObj.bt_order_type_code !=undefined){
				if("Y"==eval("formObj.perfLocnMandFlag"+i+".value") && formObj.call_function.value=="ORSET"){
					var order_type 	= eval("formObj.order_type_code"+i+".value");
						if(formObj.function_name)
						{
						// For OrderSets , Performing Location check
							if(checked_yn=="Y" && result_val &&   (formObj.function_name.value == "ORDER_SET"||formObj.function_name.value == "PREVIEW")&& eval("formObj.group_order_category"+i)  && eval("formObj.performing_dept_loc_code"+i) )
							{ 
								if(eval("formObj.group_order_category"+i+".value=='RD'") && formObj.rd_install_yn.value=="Y" )
								{//RADIOLOGY
									var performing_dept_loc_code = eval("formObj.performing_dept_loc_code"+i+".value")
									if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
										result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
								}else if(eval("formObj.group_order_category"+i+".value!='RD'")){
								//EXCEPT RADIOLOGY
									if(eval("formObj.group_order_category"+i+".value!='LB'")){
										var performing_dept_loc_code = eval("formObj.performing_dept_loc_code"+i+".value")
										if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
											result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
									}	
									if(eval("formObj.group_order_category"+i+".value=='LB'") && (order_type!=formObj.bt_order_type_code.value)){
										var performing_dept_loc_code = eval("formObj.performing_dept_loc_code"+i+".value")
										if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
											result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
									}	
								}
							}
						}
				}
			}
			//IN066377 end
			//IN066377 start PREVIEW
			if(eval("formObj.perfLocnMandFlag"+i)!= undefined && formObj.call_function !=undefined && formObj.bt_order_type_code !=undefined){
				if(eval("formObj.perfLocnMandFlag"+i+".value=='Y'") && formObj.call_function.value=="ORSET"){
					var order_type 	= eval("formObj.order_type_code"+i+".value");
						if(formObj.function_name)
						{
							if(checked_yn=="Y" && result_val &&   (formObj.function_name.value == "PREVIEW")&& eval("formObj.group_order_category"+i)  && eval("formObj.performing_dept_loc_code"+i) )
							{ 
								if(eval("formObj.group_order_category"+i+".value=='RD'") && formObj.rd_install_yn.value=="Y" )
								{//RADIOLOGY
									var performing_dept_loc_code = eval("formObj.performing_dept_loc_code"+i+".value")
									if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
										result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
								}else if(eval("formObj.group_order_category"+i+".value!='RD'")){
								//EXCEPT RADIOLOGY
									if(eval("formObj.group_order_category"+i+".value!='LB'")){
										var performing_dept_loc_code = eval("formObj.performing_dept_loc_code"+i+".value")
										if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
											result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
									}	
									if(eval("formObj.group_order_category"+i+".value=='LB'") && (order_type!=formObj.bt_order_type_code.value)){
										var performing_dept_loc_code = eval("formObj.performing_dept_loc_code"+i+".value")
										if(performing_dept_loc_code == "null" || performing_dept_loc_code == null ||  performing_dept_loc_code=="" )
											result_val		=await displayErrMessage("PERF_LOCN_CANNOT_BLANK", "");
									}	
								}
							}
						}
				}
			}
			//IN066377 end
			// If Schedule hyperlink is there, then the informations have to be entered mandatorily
			//result_val		= displayErrMessage("SCHEDULE_CANNOT_BE_BLANK", "");
			//if(schedule_yn=="Y" && schedule_mandatorily_yn=="Y")
			//{
			//	alert(result_val);
			//}
			
			if(eval("formObj.schedule_yn"+i))
			{
				if(checked_yn=="Y" && result_val && eval("formObj.schedule_yn"+i))
				{
					var schedule_yn 			= eval("formObj.schedule_yn"+i+".value")
					var schedule_mandatorily_yn = eval("formObj.schedule_mandatorily_yn"+i+".value")
					

					if(schedule_yn=="Y" && schedule_mandatorily_yn!="Y")    //If Schedule is present, then the mandatorily should be "Y"
					{
						result_val		=await displayErrMessage("SCHEDULE_CANNOT_BE_BLANK", "");// Pass the message_id
							
							//DisplaySchedule('Schedule'+catalog_code_val,i,formObj.facility_id.value,'apply')		// Invoke the Schedule Frequency modal window
					}
				} // End of if checked_yn == "Y" && result_val
			}
		
		   if(eval("formObj.amend_schedule_yn"+i))
			{
				   
				var amend_schedule_yn 			= eval("formObj.amend_schedule_yn"+i+".value")
				var amend_schedule_mandatorily_yn = eval("formObj.amend_schedule_mandatorily_yn"+i+".value")
				if(amend_schedule_yn=="Y" && amend_schedule_mandatorily_yn!="Y")    //If Schedule is present, then the mandatorily should be "Y"
				{
					result_val		=await displayErrMessage("SCHEDULE_CANNOT_BE_BLANK", "");// Pass the message_id
					//DisplaySchedule('Schedule'+catalog_code_val,i,formObj.facility_id.value,'apply')		// Invoke the Schedule Frequency modal window
				}
			
			}
		/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/
			if((eval("formObj.ord_consent_reqd_yn"+i))&&(eval("formObj.consent_form_list"+i))&&(eval("formObj.multiConsentList"+i)))
			{ 
				if(checked_yn=="Y" && ((eval("formObj.ord_consent_reqd_yn"+i+".value")=="Y") && (eval("formObj.consent_form_list"+i+".value")=="F") ) && result_val && (eval("formObj.multiConsentList"+i+".value")>0))
				{
					await storeFixedConsentVal(i,'NEW_ORDER');
				}
				//IN057196 Start.
				if(checked_yn=="Y" && eval("formObj.ord_consent_reqd_yn"+i+".value")=="Y")
					ordPlacingWithConsentRecord = "Y";
				//IN057196 End.
			}
			if(eval("formObj.amend_ord_consent_reqd_yn"+i))
			{
				if(((eval("formObj.amend_ord_consent_reqd_yn"+i+".value")=="Y") && (eval("formObj.amend_consent_form_list"+i+".value")=="F") ) && result_val  && (eval("formObj.amend_MultiConsentList"+i+".value")>0))
				{
					await storeFixedConsentVal(i,'AMEND_ORDER');
				}
				//IN057196 Start.
				if(checked_yn=="Y" && eval("formObj.amend_ord_consent_reqd_yn"+i+".value")=="Y")
					ordPlacingWithConsentRecord = "Y";
				//IN057196 End.
			}
			/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/					
			
		} // END OF FOR I
	} // End of if result_val
	else
	{
		 alert(getMessage("CLICK_ONE_ORDERABLE","OR"))
		 return false;
	}
	
	//IN064122, starts
	/*if(result_val && formObj.care_set_count && formObj.care_set_count.value > 0)
	{
		hdr_care_set_format_result[formObj.care_set_count] = true; // Initializing the Array for the Header format level
		for(i=0;i<formObj.care_set_count.value;i++)
		{
			// Call this method to check the mandatory or not
			hdr_care_set_format_result[i] = checkHeaderCareSetFormat(formObj,i);
			if(hdr_format_result && hdr_care_set_format_result[i]==false)
				hdr_format_result = false;
		}
	}*/
	//IN064122, ends

	// For Line Level, Order Format Fields, to check if the user has entered or not
	// The Below Method checkLineFormat() is in OrderEntry1.js
	if(result_val)
		line_format_result	=await checkLineFormat(buttonObj);
		
	if(result_val)
	{  // For the Header Order Format
		if( ammend_called_from=="existing_order")
			new_order_checked 	=await checkToSubmit("parent.placeOrderDetailFrame",formObj); // otherwise it will come as undefined., send the frame reference "parent.placeOrderDetailFrame".
		// For Header Level, Order Format Fields check
		// The Below Method checkHeaderFormat() is in OrderEntry1.js
		if(formObj.care_set_count)
		{
			if(formObj.care_set_count.value == 0) //Only for New Orders and Amend Orders
				hdr_format_result 		=await checkHeaderFormat(headerformObj,new_order_checked, ammend_called_from);
			if( formObj.called_from) //--[101]--
			{
				if(formObj.care_set_count.value == 0 && formObj.called_from) //--[101]--
				hdr_format_result = false;
			}
		}
	} // End of if result_val

	if(result_val && !hdr_format_result ||  !line_format_result)
		{
	       if(!hdr_format_result)	// Method is in OrderEntryPreview.js
	       {
				if(formObj.care_set_count && formObj.care_set_count.value > 0)
		   		{
		   			for(i=0;i<formObj.care_set_count.value;i++)
		   		 	{
		   		 		// Call this method to check the mandatory or not
		   		 		hdr_care_set_format_result[i] =await checkHeaderCareSetFormat(formObj,i);
						//if(hdr_care_set_format_result[i]==false)//IN064122
	   		 			{	   		 				
							hdr_format_id_mandatory		 	= eval("formObj.hdr_format_id_mandatory_yn"+i+".value");
					 		hdr_care_set_order_category  	= eval("formObj.hdr_care_set_order_category"+i+".value");
					 		hdr_order_catalog_code  		= eval("formObj.hdr_order_catalog_code"+i+".value");
							hdr_format_id					= eval("formObj.hdr_format_id"+i+".value");
						 	await parent.parent.orderFormatForCareSetsHeader(hdr_format_id,hdr_care_set_order_category,hdr_order_catalog_code,i,"","RECORD");
							
	 					} // End of i
		 		 	} // End of for
				}else if(formObj.total_order_cat_count && formObj.total_order_cat_count.value > 0 && formObj.care_set_count.value == 0){
					for(i=0;i<formObj.total_order_cat_count.value;i++)
					{
		   		 		// Call this method to check the mandatory or not in the preview mode 
		   		 		hdr_care_set_format_result[i] =await checkHeaderCareSetFormat(formObj,i);						
						//if(hdr_care_set_format_result[i]==false)//IN064122
	   		 			{
					 		hdr_format_id_mandatory		 	= eval("formObj.hdr_format_id_mandatory_yn"+i+".value");
					 		hdr_care_set_order_category  	= eval("formObj.hdr_care_set_order_category"+i+".value");
					 		hdr_order_catalog_code  		= eval("formObj.hdr_order_catalog_code"+i+".value");
							hdr_format_id					= eval("formObj.hdr_format_id"+i+".value");	
							await parent.parent.orderFormatForPreviewHeader(hdr_format_id,hdr_care_set_order_category,hdr_order_catalog_code,i,"RECORD");
							//hdr_format_result_previewHeader = checkHeaderCareSetFormat(formObj,i);//to chk if cancel is clicked from the order entry format window in the preview mode. //IN064122
	 					} // End of i						
		 		 	} // End of for
				}
				else  // For New Order for Amend Order
				 await parent.parent.orderFormatForHeader(headerformObj.format_id.value,headerformObj.order_category.value,headerformObj.amend_order_id.value,"RECORD")		//Invoke the Order Formats for the Header Level.
	
		 }

 	    if(!line_format_result) // Method is in OrderEntryPreview.js
		{
			await parent.parent.orderFormatForLineLevel("RECORD");// Invoking the Modal Window, for the Order Format Fields at Line Level.
		}
		// Checks again, so that if mandatory format items have not entered, it will not allow to record the order
		/************************************* CHECKING AGAIN *******************************/
		// Line Level Order Format		
		if(result_val)
		{
			line_format_result	=await checkLineFormat(buttonObj);
		}
		// Header Level
		if(result_val)
		{  // For the Header Order Format		
		    if( ammend_called_from=="existing_order")
				new_order_checked 	=await checkToSubmit("parent.placeOrderDetailFrame",formObj); // otherwise it will come as undefined., send the frame reference "parent.placeOrderDetailFrame".
			// For Header Level, Order Format Fields check
			// The Below Method checkHeaderFormat() is in OrderEntry1.js
			
			//if (formObj.care_set_count.value == 0 && formObj.record_from)// for preview mode
			if(formObj.record_from)
			{
				hdr_format_result=hdr_format_result_previewHeader;
			}
			else if(formObj.care_set_count.value == 0) //Only for New Orders and Amend Orders
			{
					hdr_format_result 		=await checkHeaderFormat(headerformObj,new_order_checked, ammend_called_from);
			}		
			if(hdr_format_result && line_format_result)
			{
				 if(formObj.care_set_count && formObj.care_set_count.value > 0)
		   		 {	
					for(i=0;i<formObj.care_set_count.value;i++)
		   		 	{
		   		 		// Call this method to check the mandatory or not is entered or not in care sets
						hdr_care_set_format_result[i] =await checkHeaderCareSetFormat(formObj,i);
						//if(hdr_format_result && hdr_care_set_format_result[i]==true)
						if(hdr_care_set_format_result[i]==true)//since hdr_format_result is false it chk s again for the mandatory chk 
							hdr_format_result = true;
						else 
							hdr_format_result = false;
 		 		 	} // End of for
 				} // End of formObj.care_set_count
				else if(formObj.total_order_cat_count && formObj.total_order_cat_count.value > 0  && formObj.care_set_count.value == 0)//IN064122, starts
				{	
					for(i=0;i<formObj.total_order_cat_count.value;i++)
		   		 	{
		   		 		// Call this method to check the mandatory or not is entered or not in care sets
						hdr_care_set_format_result[i] =await checkHeaderCareSetFormat(formObj,i);
						//if(hdr_format_result && hdr_care_set_format_result[i]==true)
						if(hdr_care_set_format_result[i]==true)//since hdr_format_result is false it chk s again for the mandatory chk 
							hdr_format_result = true;
						else 
							hdr_format_result = false;
 		 		 	} // End of for
 				} // End of formObj.care_set_count
				else
				{
					
					hdr_care_set_format_result[i] =await checkLineFormat(formObj);//This is a function which finds mandatory is available or not, here it is used for the header format checking
					
					if(hdr_care_set_format_result[i]==true)//since hdr_format_result is false it chk s again for the mandatory chk 
						hdr_format_result = true;
					else 
						hdr_format_result = false;
				}//IN064122, ends
	 		} // End of (hdr_format_result && line_format_resul
		} // End of if result_val
		/************************************* END ORDER FORMAT CHECK ***********************/
	  if(hdr_format_result && line_format_result)
		  result_val = true;
	  else // Do not proceed
		  result_val = false;
	   } // End of hdr_format_result || line_format_result
	   if(result_val)
	  {// this is called in order to open up the LineLevel Order Foramts
			//hdr_format_result 		= checkHeaderFormatOpen(headerformObj,new_order_checked, ammend_called_from);
			//if(!hdr_format_result)
			//parent.parent.orderFormatForHeader(headerformObj.format_id.value,headerformObj.order_category.value,headerformObj.amend_order_id.value,"RECORD")

			line_format_result =await checkLineFormatOpen(buttonObj);
			if(!line_format_result)
			{
				await parent.parent.orderFormatForLineLevel("RECORD");
		   }
	   }
	  
  		if(result_val && total_count > 1  && formObj.order_category.value=="OT" ){
			// If it is an OT Category and OT Install, then get the primary Order Type
			await getPrimaryOrderType(formObj);
 		}
		// New Orders and for Amend Orders
		
		/*for(var z=0;z<(form.length);z++)
		{	
			if(eval("form.catalog_code"+z))
			{
				if(eval(form).document.getElementById("ck"+eval("form.catalog_code"+z).value).checked==true)
				{
					auth_yn = eval("form.auth_yn"+z).value;
					if(auth_yn=="N")
					{	
						z=form.length;
					}
				}
			}
			
			if(eval("form.amend_catalog_code"+z))
			{							if(eval(form).document.getElementById("ck"+eval("form.amend_catalog_code"+z).value).checked==true)
				{
					auth_yn= eval("form.amend_auth_yn"+z).value;
					if(auth_yn=="N")
					{	
						z=form.length;
					}
				}
			}
		}*/
  		//IN071260 STARTS
  	  	var interactionDrugsCnt=0;
	
		if(null!=document.getElementById("interactionDrugsCnt") && undefined!=document.getElementById("interactionDrugsCnt"))
		interactionDrugsCnt = document.getElementById("interactionDrugsCnt").value;
  	  	if(interactionDrugsCnt>0){
  	  		result_val = await showDrugInteractionDtls('RECORD');
  	  	}
  	  	//IN071260 ENDS
		for(var z=0;z<(apply_total_count);z++)
		//for(var z=0;z<(form.length);z++)
		{	
			 var catalogCodeElement = form["catalog_code" + z];
			    var amendCatalogCodeElement = form["amend_catalog_code" + z];
			if(catalogCodeElement)
			{
				
				if((form).querySelector("#ck"+(form["catalog_code"+z].value)).checked==true)
				{
					 auth_reqd_yn = form["ord_auth_reqd_yn" + z].value;						
			            prac_can_auth_yn = form["auth_yn" + z].value;
					if(auth_reqd_yn =="Y" && prac_can_auth_yn =="Y" )
					{	
						z=apply_total_count;
					}
				}
			}
			if(amendCatalogCodeElement)
			{		
				 var amendCheckbox = document.getElementById("ck" + amendCatalogCodeElement.value);
				if(amendCheckbox && amendCheckbox.checked)
				{			
					auth_reqd_yn = form["amend_ord_auth_reqd_yn" + z].value;
		            prac_can_auth_yn = form["amend_auth_yn" + z].value;		
					if(auth_reqd_yn =="Y" && prac_can_auth_yn =="Y" )
					{	
						z=apply_total_count;
					}
				}
			}
	}
	
				
		//if(result_val && headerformObj.auth_reqd.value=="X" && headerformObj.authorized.value=="false" && auth_count>0 && (auth_yn=="Y" || auth_yn==""))
		//IN041644 Starts
		/*if(result_val  && headerformObj.authorized.value=="false" && auth_count>0 && (auth_reqd_yn =="Y" && prac_can_auth_yn =="Y"))
		{
			getConfirmSubmit(formObj, headerformObj)
		}*/
		if(result_val  && headerformObj.authorized.value=="false" && auth_count>0)
		{
			if(auth_reqd_yn =="Y" && prac_can_auth_yn =="Y")
			{	
				await getConfirmSubmit(formObj, headerformObj)
			}
			else 
			{
				for(var index=0;index<(apply_total_count);index++)
					{	
						if(eval("form.catalog_code"+index))
						{
							
							if((form).querySelector("#ck"+form["catalog_code"+index].value).checked==true)
							{
								auth_reqd_yn = eval("form.ord_auth_reqd_yn"+index).value;						
								prac_can_auth_yn = eval("form.auth_yn"+index).value;		
								if(auth_reqd_yn =="Y" && prac_can_auth_yn =="N" )
								{	
									await checkOverruleAuthor(formObj, headerformObj,index);
								}
							}
						}
					}
			
			}
		}
		//IN041644 Ends
		//Before Submitting , If it is an Amend Order check whether it is going as a new order, display the message
		if( result_val && ammend_called_from=="existing_order")
		{
			result_val =await confirmNewOrder(formObj);
			//sig_flag = true;
		} 
  		//if(result_val && sig_flag)
		if(result_val)
		{	// If any record has consented and any record priority has been changed to Stat,
			// Make it as consent reqd. all for.
		
			if(consent_reqd=="Y")     	
				formObj.consented.value		=  "true";
		    else
				formObj.consented.value		=  "false";

			//formObj.mode.value  			= MODE_INSERT;		
			eval(formApply(parent.placeOrderDetailFrame.document.placeOrderForm,OR_CONTROLLER));
			//var orderCateg=formObj.order_category.value;
			if(result==false) // it won't come here
			{
				var function_from   = formObj.function_from.value;
				if( flag=="1")// && function_from != "MULTI_PATIENT_ORDERS") 
				{  //Show in a modal window
					var retVal 				= 	new Array();
					var dialogHeight	= "";
					var dialogWidth		= "";
					if(function_from == "MULTI_PATIENT_ORDERS")
					{
						dialogHeight 			= "35" ;
						dialogWidth  		= "40" ;
						dialogTop    		= "300";//Added for IN063973
					}
					else
					{
						//IN063973 changes starts
						/*
						dialogHeight 			= "20" ;
						dialogWidth  		= "30" ;
						*/ 
						dialogHeight 			= "90vh" ;
						dialogWidth  		= "80vw" ;
						dialogTop    		= "105";
						//IN063973 changes ends
					}
					//var dialogTop    		= "300";//Commented for IN063973
					var status 					= "no";
					var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
					//retVal = window.showModalDialog("../../eOR/jsp/OrderEntryDuplicateFrameset.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);//Commented for IN062607
					if(formObj.twicedupchkflg.value=='N')
					retVal =await window.showModalDialog("../../eOR/jsp/OrderEntryDuplicateFrameset.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&emptyContent=Y",arguments,features);
					else
					retVal = await window.showModalDialog("../../eOR/jsp/OrderEntryDuplicateFrameset.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&fwin=Y",arguments,features); //Modified for IN062607
					//IN062607 Starts
					if(retVal!="undefined" && retVal!=undefined)
					{
							if(retVal!='N' && formObj.twicedupchkflg.value=='Y')
							{

								if(retVal.indexOf("#$")!=-1)
								{
									HTMLTextS=retVal.split("#$");
									for(dr=0;dr<((HTMLTextS.length)-1);dr++)
									{
										checked_yn		 = eval(formObj).document.getElementById("ck"+HTMLTextS[dr]).value;
										if(checked_yn=="Y")
										{
											eval(formObj).document.getElementById("ck"+HTMLTextS[dr]).value="N";
											eval(formObj).document.getElementById("ck"+HTMLTextS[dr]).checked=false;
											tempcodeVal = codeVal+HTMLTextS[dr]+"$$";
										}
									}
									var checktosubmit= await checkToSubmit("parent.placeOrderDetailFrame",formObj);									
									if(checktosubmit)
									{
										eval(formApply(parent.placeOrderDetailFrame.document.placeOrderForm,OR_CONTROLLER));
										retVal =await window.showModalDialog("../../eOR/jsp/OrderEntryDuplicateFrameset.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&discardyn="+tempcodeVal,arguments,features);
									}
									else
									{
										if(parent.parent.parent.parent.parent)
										{
											if(parent.parent.parent.parent.parent.orderMainTab)
											{
												var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
												var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
												var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
												querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key+"&reject_order=Y";
												parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
											}
										}
									}
								}else if(retVal.indexOf("##")!=-1)
								{
									var HTMLPatTextS=retVal.split("##");
									HTMLTextS = HTMLPatTextS[0];
									avalCatalogs = HTMLPatTextS[1];
									totPat			= HTMLPatTextS[2];
									if(HTMLTextS=="P")
									{
										if((avalCatalogs>0) && (totPat>0))
										{
											eval(formApply(parent.placeOrderDetailFrame.document.placeOrderForm,OR_CONTROLLER))
											retVal = 	await window.showModalDialog("../../eOR/jsp/OrderEntryDuplicateFrameset.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
										}
										else
										{
											
											if(totPat==0)
											{
												var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
												var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
												var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
												querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
												top.content.workAreaFrame.location.href="../../eOR/jsp/MultiPatientOrders.jsp?"+querystring;
											}
											else
											{
												await countCategory(parent.placeOrderDetailFrame.document.placeOrderForm);
											}
										}	
									}else if(HTMLTextS.indexOf("$$")!=-1)
									{
										HTMLPTextS=HTMLTextS.split("$$");
										for(dr=0;dr<((HTMLPTextS.length)-1);dr++)
										{
											checked_yn		 = eval(formObj).document.getElementById("ck"+HTMLPTextS[dr]).value;
											if(checked_yn=="Y")
											{
												eval(formObj).document.getElementById("ck"+HTMLPTextS[dr]).value="N";
												eval(formObj).document.getElementById("ck"+HTMLPTextS[dr]).checked=false;
											}
										}
										storeValuesForOrders(parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm,"placeOrderForm",HTMLTextS);
										if((avalCatalogs>0) && (totPat>0))
										{
											var checktosubmit=await checkToSubmit("parent.placeOrderDetailFrame",formObj);	
											if(checktosubmit)
											{
												eval(formApply(parent.placeOrderDetailFrame.document.placeOrderForm,OR_CONTROLLER));
												retVal = 	await window.showModalDialog("../../eOR/jsp/OrderEntryDuplicateFrameset.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
											}
											else
											{
												if(parent.parent.parent.parent.parent)
												{
													if(parent.parent.parent.parent.parent.orderMainTab)
													{
														var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
														var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
														var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
														querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
														parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
													}
												}
											}
									
										}
										else
										{
											if(totPat==0)
											{
												var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
												var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
												var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
												querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
												top.content.workAreaFrame.location.href="../../eOR/jsp/MultiPatientOrders.jsp?"+querystring;
											}
											else
											{
												await countCategory(parent.placeOrderDetailFrame.document.placeOrderForm);
											}
										}
									}
								}
								else{
									retVal = await window.showModalDialog("../../eOR/jsp/OrderEntryDuplicateFrameset.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
								}
							}
					}
					//IN062607 Ends
					if(retVal!="undefined" && retVal!=undefined)
					{
						if(retVal.length>=0)
						{
							if(retVal=="Y")
							{
								formObj.validated_status.value = "validation_not_reqd";
								eval(formApply(parent.placeOrderDetailFrame.document.placeOrderForm,OR_CONTROLLER))
							}
							else if(retVal=="N")
							{
								if(parent.parent.parent.parent.parent)
								{
									if(parent.parent.parent.parent.parent.orderMainTab)
									{
										var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
										var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
										var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
										querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
										parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
									}
								}
								else
								{			
								}
							}
							else if(retVal=="CANCEL")
							{
							}
							else if(retVal.indexOf("#$")!=-1)
							{
								HTMLTextS=retVal.split("#$");
								for(dr=0;dr<((HTMLTextS.length)-1);dr++)
								{
									checked_yn		 = eval(formObj).document.getElementById("ck"+HTMLTextS[dr]).value;
									if(checked_yn=="Y")
									{
										eval(formObj).document.getElementById("ck"+HTMLTextS[dr]).value="N";
										eval(formObj).document.getElementById("ck"+HTMLTextS[dr]).checked=false;
										//Added by Uma on 3/2/2010 for IN019654
										codeVal = codeVal+HTMLTextS[dr]+"$$";
									}
								}
								//Added by Uma on 3/2/2010 for IN019654
								//storeValuesForOrders(parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm,"placeOrderForm",codeVal);
								formObj.validated_status.value = "validation_not_reqd";
								var checktosubmit=await checkToSubmit("parent.placeOrderDetailFrame",formObj);									
								if(checktosubmit)
								{
									eval(formApply(parent.placeOrderDetailFrame.document.placeOrderForm,OR_CONTROLLER));
								}
								else
								{
									if(parent.parent.parent.parent.parent)
									{
										
										if(parent.parent.parent.parent.parent.orderMainTab)
										{
											var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
											var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
											var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
										   /*Modified by Uma on 1/3/2010 for IN019654*/	
											querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key+"&reject_order=Y";
											parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
										}
									}
								}
							}
							else if(retVal.indexOf("##")!=-1)
							{
								var HTMLPatTextS=retVal.split("##");
								HTMLTextS = HTMLPatTextS[0];
								avalCatalogs = HTMLPatTextS[1];
								totPat			= HTMLPatTextS[2];
								if(HTMLTextS.indexOf("$$")!=-1)
								{
									HTMLPTextS=HTMLTextS.split("$$");
									for(dr=0;dr<((HTMLPTextS.length)-1);dr++)
									{
									
										checked_yn		 = eval(formObj).document.getElementById("ck"+HTMLPTextS[dr]).value;
										if(checked_yn=="Y")
										{
											eval(formObj).document.getElementById("ck"+HTMLPTextS[dr]).value="N";
											eval(formObj).document.getElementById("ck"+HTMLPTextS[dr]).checked=false;
											//var retStroreValues =  storeValuesForOrders(parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm,"placeOrderForm",("ck"+HTMLPTextS[dr]));
										}
									}
									storeValuesForOrders(parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm,"placeOrderForm",HTMLTextS);
									formObj.validated_status.value = "validation_not_reqd";
									if((avalCatalogs>0) && (totPat>0))
									{
										var checktosubmit= await checkToSubmit("parent.placeOrderDetailFrame",formObj);	
										if(checktosubmit)
										{
											eval(formApply(parent.placeOrderDetailFrame.document.placeOrderForm,OR_CONTROLLER));
										}
										else
										{
											if(parent.parent.parent.parent.parent)
											{
											
												if(parent.parent.parent.parent.parent.orderMainTab)
												{
													
													var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
													var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
													var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
													querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
													parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
												}
											}
										}
									}
									else
									{
										if(totPat==0)
										{
											var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
											var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
											var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
											querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
											top.content.workAreaFrame.location.href="../../eOR/jsp/MultiPatientOrders.jsp?"+querystring;
										}
										else
										{
											//var retStroreValues =  storeValuesForOrders(parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm,"placeOrderForm");

											//if(parent.parent.criteriaCategoryButtonFrame)
											//{
												//parent.parent.criteriaCategoryButtonFrame.location.href 					=  //parent.parent.criteriaCategoryButtonFrame.location.href;
											//}
											await countCategory(parent.placeOrderDetailFrame.document.placeOrderForm);
											/*if(parent.parent.parent.parent.parent)
											{
												if(parent.parent.parent.parent.parent.orderMainTab)
												{
													var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
													var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
													var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
													querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
													parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
												}
											}*/
										}
									}
							}
							else if(HTMLTextS=="P")
							{
								if((avalCatalogs>0) && (totPat>0))
								{
									formObj.validated_status.value = "validation_not_reqd";
									eval(formApply(parent.placeOrderDetailFrame.document.placeOrderForm,OR_CONTROLLER))
								}
								else
								{
									if(totPat==0)
									{
										
									
										var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
										var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
										var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
										querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
										top.content.workAreaFrame.location.href="../../eOR/jsp/MultiPatientOrders.jsp?"+querystring;
									}
									else
									{
										
										await countCategory(parent.placeOrderDetailFrame.document.placeOrderForm);
										/*if(parent.parent.parent.parent.parent)
										{
											if(parent.parent.parent.parent.parent.orderMainTab)
											{
												var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
												var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
												var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
												querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
												parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
											}
										}*/
									}
								}
							}
						  }
					   }
					}
				  } // end of flag==1
				  /*else if (flag=="1" && function_from == "MULTI_PATIENT_ORDERS")
				  {
						alert(getMessage("DUPLICATE_ORDERS_FOUND","OR"));
						var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
						var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
						var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
						querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
						parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;

				  }*/
			} // End of result==false
			var orderCateg=formObj.order_category.value;
 			if(result) 
			{
 				await clearPlacedOrderClinicalComments(orderCateg);
				if(orderCateg=="CS")
				{
					await clearTempvalues();
				}	
				if(consent_reqd == "Y" )
				{	
					if( consent_stage !="A")
					{
						await getAppointmentBooking(formObj); 
					}// To call the Appointment in eOA,if appt is there
				}else {					
					await getAppointmentBooking(formObj); // To call the Appointment in eOA,if appt is there				
				}	
 			}
			if(result)
			{			
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlStr					= "<root><SEARCH " ;
				xmlStr 					+=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../eOR/jsp/OrderEntryValidate.jsp?bean_id=" + formObj.bean_id.value + 	"&bean_name="+ formObj.bean_name.value+"&func_mode=BILL_SETTLEMENT_DISCOUNT", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				await eval(responseText);				
			}	
			if(result)
			{					
				await printReportValues(bean_id, bean_name);
			}
			modalWindowContent="";//KAUH Lock

			if(ammend_called_from!="existing_order") 
			{   // New Orders
				 if (top.content && !top.document.getElementById('dialog-body') && called_function_name!="PREVIEW") 
				 {
					refreshWindow( message);
	             } 
				 else if(called_function_name=="PREVIEW") 
				 { // For Preview(New Orders)
					window.returnValue="RELOAD";
					//IN060463 Start.
					//modalWindowClose(message); //show alert and close the modal window
					if(message.indexOf("<br>") != -1)
					   message = message.replace("<br>","");
					if(message!=null && message!="")
					{      
						alert(message);
					}
					//IN060463 End.
				} 
				else 
				{
					modalWindowContent = "true";//KAUH Lock
				    if(message.indexOf("<br>") != -1)
					  message = message.replace("<br>","");
					if(message!=null && message!="")
					{
				/*if(formObj.called_from)
				{
					if((formObj.called_from.value)="OH")
						{
								var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
								var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
								xmlStr			= "<root><SEARCH/></root>" ;
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open( "POST", "OrderEntryValidate.jsp?func_mode=OH_ORDER_ID",false ) ;
								xmlHttp.send( xmlDoc ) ;
								var retVal = trimString(xmlHttp.responseText);
								alert(retVal);
								alert("responseText"+retVal);
						}
				}*/
						if(formObj.called_from)
						{
							if((formObj.called_from.value)=="OH")
							{
								var ohmessage=message;
								var vals=ohmessage.split("<BR1>");
								var message1=vals[0];
								var order_id=vals[1];
								alert(message1);
								window.returnValue=order_id;
							}
						}
						else
						{
							alert(message);
						}
								
						if(formObj.called_from)
						{
							if((formObj.called_from.value)=="OH")
							{
								window.close();
							}
						}
					}
					qry_string		 = parent.parent.parent.parent.parent.location.href
					qry_string_arr	 = qry_string.split("?");
					qry_string		 = qry_string_arr[1];
					if(formObj.called_from)
					{	
						if((formObj.called_from.value)!="OH")
						{
							//parent.parent.parent.parent.parent.location.href = "../../eOR/jsp/EnterOrder.jsp?"+qry_string;
						}
					}
			    } // End of else ammend_called_from
			} 
			else
			{  	
				// Existing/Amend Order
				await modalWindowClose(message); //show alert and close the modal window
			}
			//IN030279 Start.
			
			if(( (formObj.function_from.value)=null?"":(formObj.function_from.value))=="MO"){
				//IN066709 Starts
					var cnsnt_with_order_yn="Y";
					await onSucess_New(bean_id, bean_name,ordPlacingWithConsentRecord,cnsnt_with_order_yn);
				//IN066709 Ends
				
				if(message!="")
					alert(message); //IN036533
				//window.close();  //36673
			}
				
			//IN030279 End.
			if(result) 
			{  // Call the onSuccess Method, to refresh the screen 				
						
					//printValues(bean_id, bean_name); // Call a method to print the orders(Order Form/Consent Form)  //IN046592
					//printReportValues(bean_id, bean_name); // Call a method to print the orders(Order Form/Consent Form)
					await printCheck(bean_id, bean_name);//IN042962
					if(ammend_called_from=="COPY_ORDER")
					{
						await onSuccess();
					}
					else if(ammend_called_from=="") 
					{
						if (formObj.function_from.value == "EXTERNAL_ORDER" && formObj.called_from.value != "DIS_ADVICE")
						{
							await modalWindowClose(message);
							if(top.content!=null)
							{
								await onSuccess(); 
							}
						}
						else
						{
							//IN057196 Start.
								//onSuccess(); // For New Orders Only 
								var cnsnt_with_order_yn = "N";
								if(parent.parent.parent.parent.parent.orderMainTab != undefined && parent.parent.parent.parent.parent.orderMainTab != null) {  //IN060463
									if(parent.parent.parent.parent.parent.orderMainTab.OrCommonForm)
										cnsnt_with_order_yn = parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.cnsnt_with_order_yn.value;
								}
								//IN066709 Starts
									if(( (formObj.function_from.value)=null?"":(formObj.function_from.value))!="MO"){
										await onSucess_New(bean_id, bean_name,ordPlacingWithConsentRecord,cnsnt_with_order_yn);
									}
								//IN066709 Ends	
							//IN057196 End.
						}
					}
					printValues(bean_id, bean_name); // Call a method to print the orders(Order Form/Consent Form)	//IN046592		
					//IN060463 Start.
					if(called_function_name=="PREVIEW"){
						parent.window.returnValue="TRUE";
						//IN067246 starts
							//parent.window.close();
						if(orset_ind_flag=="true" && "OP_VISIT_REG"==called_function){
							if(formObj.order_category.value!="CS")
								parent.window.close();
							else if(formObj.order_category.value=="CS" && formObj.total_size.value=="3")
								parent.window.close();
							else
								parent.criteriaMainFrame.location.href=parent.criteriaMainFrame.location;
						}else{
							parent.window.close();
						}
						//IN067246 ends
					}
					//IN060463 End.
			} // End of if result
			else
			{	//Modification starts for IN27327 & IN26921 by Menaka
				//if(message!="")//KAUH Lock
				if(modalWindowContent!='' && message!="")//KAUH Lock
				{
				if(message!=null)
				{
					alert(message);
				}	
				}//Modification end for IN27327  & IN26921 by Menaka
				//window.close();//KAUH Lock
			}
	}  // End of if result_val 
		await colorChange1();		
		
} // End of apply()
function colorChange1() 
{
			var frameobj = top.document.getElementById('dialog-body').contentWindow?.frames[0];
			if(frameobj.document.getElementById('existingOrders'))
				frameobj.document.getElementById('existingOrders').className  = "CASECONDSELECTHORZ";
			if(frameobj.document.getElementById('newOrders'))
				frameobj.document.getElementById('newOrders').className		= "CAFIRSTSELECTHORZ";
}
function assignResult(_result, _message, _flag)
{
	result	= _result ;
	message = _message ;
	flag	= _flag ;
}
//IN057196 Start.
async function onSucess_New(p_bean_id, p_bean_name,ordPlacingWithConsentRecord,cnsnt_with_order_yn){
	
	var dialogHeight 	= "90vh" ;
	var dialogWidth  	= "90vw" ;
	var dialogTop    	= "250";
	var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth;
	var retValNew		= undefined;
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	if(ordPlacingWithConsentRecord=="Y" && cnsnt_with_order_yn=="Y"){
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH " ;	
		xmlStr += " p_bean_id=\""+p_bean_id+ "\" ";
		xmlStr += " p_bean_name=\""+p_bean_name+ "\" ";
		xmlStr += " p_action=\"RECORD_CONSENT_FORM_WITH_ORDER\"";
		xmlStr += "/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "OrderLineIntermediate.jsp", false );
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		responseText = responseText.replace(/^\s+|\s+$/gm,'');
	
		if(responseText == "Y" ){
			var res = confirm("APP-OR0459 Do you want to record Consent ?");
			if(res)
				retValNew 			   = await  window.showModalDialog("../../eOR/jsp/ConsentOrders.jsp?patient_id="+formObj.patient_id.value,arguments,features);
		}
	}

	if(retValNew==undefined){	
		
		if(parent.criteriaMainFrame)
		{
			parent.criteriaMainFrame.location.href			= "../../eCommon/html/blank.html";
		}
		if(parent.legendsFrame) 
		{
			parent.legendsFrame.location.href				= "../../eCommon/html/blank.html"; 	// For the Legends
		}
		if(parent.placeOrderDetailFrame) 
		{
				if(parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm)
				{
					if(parent.parent.criteriaCategoryButtonFrame)				
						parent.parent.criteriaCategoryButtonFrame.location.href 	=  parent.parent.criteriaCategoryButtonFrame.location.href;
						
				}
			
				parent.placeOrderDetailFrame.location.href		= "../../eCommon/html/blank.html";  // For the Place Order
		
		}	
		
		/*Added by Uma on 2/15/2010 for IN019310*/
		if((formObj.called_from.value)!="OH")
		{
			if((formObj.function_from.value)!="MULTI_PATIENT_ORDERS")
			{
				if((formObj.function_name.value)!="PREVIEW")
				{
					if(top.document.getElementById('dialog-body'))
					{
						await countCategory(formObj);	
					}
				}
			}
		}
	
	}
}
//IN057196 End.
function onSuccess()
{
	//window.close();
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	if(parent.criteriaMainFrame)
	{
		parent.criteriaMainFrame.location.href			= "../../eCommon/html/blank.html";
	}
	if(parent.legendsFrame) 
	{
		parent.legendsFrame.location.href				= "../../eCommon/html/blank.html"; 	// For the Legends
	}
	if(parent.placeOrderDetailFrame) 
	{
			if(parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm)
			{
				//Commented by Ambiga.M on 1/21/2010 for 18285(when select 2 order and unselect one of them after success it is not going to the intended page instead it is comin gback to the place order screen)--starts here 
			   //var retStroreValues =  storeValuesForOrders(parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm,"placeOrderForm");
			     //Commented by Ambiga.M---ends here
			   //if(retStroreValues!=false)
				//{
					if(parent.parent.criteriaCategoryButtonFrame)
					{
						parent.parent.criteriaCategoryButtonFrame.location.href 					=  parent.parent.criteriaCategoryButtonFrame.location.href;
					}
					//parent.parent.criteriaPlaceOrderFrame.legendsFrame.location.href 			=  //parent.parent.criteriaPlaceOrderFrame.legendsFrame.location.href;
					//parent.parent.criteriaPlaceOrderFrame.criteriaMainFrame.location.href 	=  //parent.parent.criteriaPlaceOrderFrame.criteriaMainFrame.location.href;
					//parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.location.href =  //parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.location.href;
			}
		//}
	//}
	//}
	parent.placeOrderDetailFrame.location.href		= "../../eCommon/html/blank.html";  // For the Place Order
	/*if(parent.parent.parent.parent.parent)
	{
		if(parent.parent.parent.parent.parent.orderMainTab)
		{
			var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
			var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
			var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
			querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
			parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
		}
	}*/
//}	
	}
	if(parent.criteriaDetailFrame)
	{
		//parent.criteriaDetailFrame.location.href		= "../../eCommon/html/blank.html";
	}
	if(parent.parent.criteriaCategoryButtonFrame)
	{
		//parent.parent.criteriaCategoryButtonFrame.location.reload();
	}
	/*result_val 	= checkToSubmit("parent.placeOrderDetailFrame",formObj);
	if(!result_val)
	{
		if(parent.parent.parent.parent.parent)
		{
			if(parent.parent.parent.parent.parent.orderMainTab)
			{
				var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
				var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
				var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
				querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
				parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
			}
		}	
	}*/
	/*var result_value	= checkToSubmit("parent.placeOrderDetailFrame",formObj); 
	if(!result_value)
	{
		if(parent.parent.parent.parent.parent)
		{
			if(parent.parent.parent.parent.parent.orderMainTab)
			{
				var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
				var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
				var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
				querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
				parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;
			}
		}
		else
		{
			
		}
	}
	else
	{
		
	}*/
	/*Added by Uma on 2/15/2010 for IN019310*/
	if((formObj.called_from.value)!="OH")
	{
		if((formObj.function_from.value)!="MULTI_PATIENT_ORDERS")
		{
			if((formObj.function_name.value)!="PREVIEW")
			{
				if(top.content==null)
				{
					countCategory(formObj);	
				}
			}
		}
	}
	/*Ends Here*/
}

function refreshWindow( message)
{
	 if (top.content && top.content.messageFrame) 
	{
		// alert(message);
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	 }
}  // End of refreshWindow

function modalWindowClose(message)
{

		if(message.indexOf("<br>") != -1)
		   message = message.replace("<br>","");
		if(message!=null && message!="")
		{      
			alert(message);
		}
		parent.window.close();
		//top.window.document.getElementById('dialog_tag').close();
	    //toCloseTopShowModal();
	    //const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    //dialogTag.close(); 
		//top.opener.window.close();
} // End of modalWindowClose

// On click of the modal dialog window, to cancel the duplicate records
function cancelDuplicateRecord()
{
//	window.returnValue = "N";
//	window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = "N";

	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	dialogTag.close(); 
}
function cancelDuplicateRecords()
{
//	window.returnValue = "CANCEL";
//	window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "CANCEL";
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}
function DiscardDuplicates()
{
	var formObj=parent.OrderEntryDuplicate.document.duplicateForm;
	var total_dup_records=formObj.total_dupl_count_records.value;
	var HTMLText=new Array();
	var arrInd=0;
	for(var i=0;i<total_dup_records;i++)
	{
		if(eval("formObj.chk"+i).checked)
		{
			HTMLText[arrInd++]=eval("formObj.chk"+i).value;
		}

	}
	return HTMLText;
}

// On click of the modal window to view the records
async function viewDuplicateRecords(catalog_code)
{
	var formObj;
	if(document.duplicateForm)
	{
		formObj=document.duplicateForm;
	}
	else if(document.duplicateFormButton)
	{
		formObj=document.duplicateFormButton;
	}
	var bean_id 		= formObj.bean_id.value;
	var bean_name 		= formObj.bean_name.value;
	var retVal 			= new String();
	/*var dialogHeight 	= "15" ;
	var dialogWidth  	= "40" ;*/
	var dialogHeight 	= "25" ;
	var dialogWidth  	= "35" ;
	var dialogTop    	= "250";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	if(catalog_code=='')
	{
		retVal 				= await window.showModalDialog("../../eOR/jsp/OrderEntryViewDuplicateRecords.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
		if(retVal=="Y"){
			window.returnValue = "Y";
		}
		else if(retVal=="CANCEL"){
			window.returnValue = "CANCEL";
			}
		else{
			window.returnValue = "N";
			window.close();
		}
			 
	}
	else
	{
		retVal 				= await window.showModalDialog("../../eOR/jsp/OrderEntryViewDuplicateRecords.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&called_from=DUPLICATE&cat_code="+catalog_code,arguments,features);
		if((retVal!="VIEW") && (retVal!=undefined && retVal!="undefined")){
		window.close();
		}
	}
	
}

//on click of the modalwindow when the alert has to be shown when viewing the duplicate records
function proceedInsertions()
{
	var formObj=parent.OrderEntryDuplicate.document.duplicateForm;
	var total_dup_records=formObj.total_dupl_count_records.value;
 	var dupfirstwin=formObj.firstDupWindow.value;//Added for IN062607
	var codeVal="";
	var p_dupe_catalog_list="";	
	var arrInd=0;
	for(var i=0;i<total_dup_records;i++)
	{
		if(eval("formObj.chk"+i))
		{
			if(eval("formObj.chk"+i).checked)
			{
				HTMLTextS[arrInd++]=eval("formObj.chk"+i).value;
				codeVal=codeVal+eval("formObj.chk"+i).value+"#$";
			}else
			{
				p_dupe_catalog_list = p_dupe_catalog_list+eval("formObj.chk"+i).value+"#"+eval("formObj.mand"+i).value+"#";
			}
		}
	}
	// IN024984 - Start
	var dup_override_reason = formObj.dup_override_reason.value;
	var p_bean_id   =  formObj.bean_id.value;
	var p_bean_name =  formObj.bean_name.value;
	//var p_dupe_catalog_list = formObj.dupe_catalogcode_list.value;
	//var result = manipulateOverrideHashMap(dup_override_reason, p_dupe_catalog_list, p_bean_id, p_bean_name);//Commented for IN062607
	var result = manipulateOverrideHashMap(dup_override_reason, p_dupe_catalog_list,dupfirstwin, p_bean_id, p_bean_name);//Modified for IN062607
	// IN024984 - End
	if(HTMLTextS.length==0&&total_dup_records>0)
	{
		window.returnValue="Y";
		
	}
	else
	{
		window.returnValue=codeVal;
		
	}
	if(result == true){
		window.close();
		 }
		
	else
		alert(getMessage("DUP_REASON_REQD","OR"));
	
}

//on click of the modalwindow when the alert has to be shown when viewing the duplicate records
function proceedInsertion()
{
//	window.returnValue = "Y";
//	window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "Y";
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}

//To check whether to submit the form or not
function checkToSubmit(frame_ref,formObj)
{
	var form		= eval(frame_ref).document.getElementById("placeOrderForm");

	if(formObj)
		if(formObj.checkCount)
				var chkToSub_total_count=formObj.checkCount.value;
	for(var i=0;i<chkToSub_total_count;i++)
	//for(var i=0;i<formObj.length;i++)
	{

	if(eval(frame_ref+".document.placeOrderForm.catalog_code"+i))
	
		{
			catalog_code_val = eval(frame_ref+".document.placeOrderForm.catalog_code"+i+".value");
			//checked_yn		 = eval(frame_ref+".document.placeOrderForm.ck"+catalog_code_val+".value")
			checked_yn		 = form["ck"+catalog_code_val].value;
		if(checked_yn=="Y")   // At least one item is cheched, then can continue submitting the form
			{
			  return true; // Atleast one is checked, then proceed
		 	}
		}
	} // End of for
}

// For care set to check the authorization at the submit time
function checkOrderSetAuthorization(formObj, auth_count,headerformObj){
	var result = true;
	
	for(var i=0;i<formObj.length;i++)
	{
		checked_yn					=  "N";
		if(eval("formObj.catalog_code"+i))
		{
			catalog_code_val = eval("formObj.catalog_code"+i+".value");
			//checked_yn		 = eval("formObj.ck"+catalog_code_val+".value")
			checked_yn		 = eval(formObj).document.getElementById("ck"+catalog_code_val).value
			if(checked_yn=="Y")
			{
				if(eval("formObj.auth_reqd"+i) )
				{
					auth_reqd = eval("formObj.auth_reqd"+i+".value")
					if(auth_reqd=="X")
					{
						if(eval("formObj.care_set_authorized"+i))
						{
							care_set_authorized = eval("formObj.care_set_authorized"+i+".value")
							if((care_set_authorized=="" || care_set_authorized=="false") && auth_reqd =="X")
							{
								result = false;
								break;
							}
						}
					}	// End of auth_reqd="Y"
				} // End of auth_reqd
			} // End of if checked_yn
		} // End of if catalog_code
 	} // End of for
	
    if(!result)
	{
        getConfirmSubmit(formObj,headerformObj);
    }
} // End of checkOrderSetAuthorization

function closeConfirm() {
   window.returnValue = true;
 window.close();
	

}

function getConfirmSubmit(formObj, headerformObj) 
{
	//IN048467 - HSA-CRF-0150 Starts
	var skip_auth		="";
	var totalCount		= parseInt(eval("parent.placeOrderDetailFrame.document.placeOrderForm.total_rows.value;"))
	var priority ="";
	var authorize = true;
	var yes;
	for(i=0;i<totalCount;i++)
	{
		skip_auth =  eval("parent.placeOrderDetailFrame.document.placeOrderForm.skip_auth"+i+".value;");//nIJI
		priority = eval("parent.placeOrderDetailFrame.document.placeOrderForm.priority"+i+".value;");
		//if(skip_auth == priority)
		if(skip_auth!="NA")
		{
			if(skip_auth.search(priority) != -1 || (skip_auth == "*A")) 
			{	
				authorize = false;
			}
		}
	}
	if(authorize)
	{
		 //var yes = window.confirm(getMessage("AUTH_REQD_CONFIRM","OR"));
		 yes = window.confirm(getMessage("AUTH_REQD_CONFIRM","OR"));
	} 
	//IN048467 - HSA-CRF-0150 Ends
	
	if (yes && authorize)
	{
        headerformObj.authorized.value = "true";
		if(parent.criteriaMainFrame)
			imgArr = parent.placeOrderDetailFrame.document.getElementsByTagName("img");
		for(var p=0;p<imgArr.length;p++)
		{
			if(imgArr[p].src.indexOf("mandatory")==-1 && imgArr[p].src.indexOf("Flex_blue")==-1 && imgArr[p].src.indexOf("Flex_red")==-1  && imgArr[p].src.indexOf("Cosign")==-1 && imgArr[p].src.indexOf("Cosign_click")==-1  && imgArr[p].src.indexOf("SpecialApproval")==-1 &&  imgArr[p].src.indexOf("SpecialApproval_click")==-1 && imgArr[p].src.indexOf("SecondaryOrder")==-1 && imgArr[p].src.indexOf("CommonCalendar")==-1)
			{
				//var rowindex = imgArr[p].id.substring(13,(imgArr[p].id.length-1));//IN048467
				var rowindex = imgArr[p].id.substring(14,(imgArr[p].id.length-1));//IN048467
				if((eval(parent.placeOrderDetailFrame.document.getElementById("ord_auth_reqd_yn"+rowindex)).value=="Y") && (eval(parent.placeOrderDetailFrame.document.getElementById("auth_yn"+rowindex)).value=="Y"))
				{
					eval(parent.placeOrderDetailFrame.document.getElementById("authorised_yn"+rowindex)).value="Y";
				}
				else
				{
					eval(parent.placeOrderDetailFrame.document.getElementById("authorised_yn"+rowindex)).value="N";
				}
			}
		}
    }
	else
	{
		headerformObj.authorized.value = "false";
	}
	 formObj.authorized.value		=  headerformObj.authorized.value;
	 
}

// For Amend Orders, If the order is going as a New Order
function confirmNewOrder(formObj){
	//Built the Grouping to check for Amend(Take the First one, it will be same for all amend)
	var amend_grouping = formObj.amend_performing_facility_id0.value+formObj.amend_order_type0.value+formObj.amend_priority0.value+formObj.ord_appr_reqd_yn0.value+formObj.amend_specimen_type0.value+formObj.amend_nurse_collect0.value+formObj.amend_start_date_time0.value+formObj.amend_frequency_val0.value+formObj.amend_duration_value0.value+formObj.amend_performing_dept_loc_code0.value


	var count 				= 0;
	var new_order_reqd_yn 	= "N"; var result = true;
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
	xmlStr					= "<root><SEARCH " ;

	for(var i=0;i<formObj.length;i++)
	{
		checked_yn					=  "N";
		if(eval("formObj.catalog_code"+i))
		{
			catalog_code_val = eval("formObj.catalog_code"+i+".value");
			//checked_yn		 = eval("formObj.ck"+catalog_code_val+".value")
			checked_yn		 = eval(formObj).document.getElementById("ck"+catalog_code_val).value
			if(checked_yn=="Y")
			{
				// Check for the objects
				if(eval("formObj.performing_facility_id"+i) && eval("formObj.order_type"+i) && eval("formObj.priority"+i) && eval("formObj.ord_spl_appr_reqd_yn"+i) && eval("formObj.specimen_type"+i) && eval("formObj.nurse_collect"+i) && eval("formObj.start_date_time"+i) && eval("formObj.frequency_val"+i) && eval("formObj.duration_value"+i) && eval("formObj.performing_dept_loc_code"+i) )
				{
	    			xmlStr	+= eval("formObj.performing_facility_id"+i+".name") +"=\"" + checkSpl(eval("formObj.performing_facility_id"+i+".value")) + "\" " + eval("formObj.order_type"+i+".name") +"=\"" + checkSpl(eval("formObj.order_type"+i+".value")) + "\" " + eval("formObj.priority"+i+".name") +"=\"" + checkSpl(eval("formObj.priority"+i+".value")) + "\" " + eval("formObj.ord_spl_appr_reqd_yn"+i+".name") +"=\"" + checkSpl(eval("formObj.ord_spl_appr_reqd_yn"+i+".value")) + "\" " + eval("formObj.specimen_type"+i+".name") +"=\"" + checkSpl(eval("formObj.specimen_type"+i+".value")) + "\" " + eval("formObj.nurse_collect"+i+".name") +"=\"" + checkSpl(eval("formObj.nurse_collect"+i+".value")) + "\" " + eval("formObj.start_date_time"+i+".name") +"=\"" + checkSpl(eval("formObj.start_date_time"+i+".value")) + "\" " + eval("formObj.frequency_val"+i+".name") +"=\"" + checkSpl(eval("formObj.frequency_val"+i+".value")) + "\" " + eval("formObj.duration_value"+i+".name") +"=\"" + checkSpl(eval("formObj.duration_value"+i+".value")) +"\" " + eval("formObj.performing_dept_loc_code"+i+".name") +"=\"" + checkSpl(eval("formObj.performing_dept_loc_code"+i+".value")) +"\" "+ eval("formObj.catalog_code"+i+".name") +"=\"" + checkSpl(eval("formObj.catalog_code"+i+".value")) +"\" "
	    			count++;
				}
			} // End of 'Y'
		}	// End of catalog obj
	} // End of for
	xmlStr	+= "row_amend_count=\"" + count + "\" " ;
	xmlStr	+= "amend_grouping=\"" + checkSpl(amend_grouping) +"\" "
	xmlStr	+=" /></root>" ;
    if(count > 0)
    {
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + formObj.bean_id.value + 	"&bean_name="+ formObj.bean_name.value+"&func_mode=NEW_GROUPING", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
	new_order_reqd_yn = formObj.new_order_reqd.value
 	if(new_order_reqd_yn=="Y")
	{
		result = getConfirmation(formObj);
	}
	return result;
} // End of confirmNewOrder

// Setting for Amend Order, Based upon the flag 'Y'/'N', the confirm dialog will be called
function setNewOrder(val){
	if(parent.placeOrderDetailFrame.document.placeOrderForm.new_order_reqd)
		parent.placeOrderDetailFrame.document.placeOrderForm.new_order_reqd.value = val;
}

function getConfirmation() {
	var confirm_val = window.confirm(getMessage("NEW_ORDER_CONFIRM","OR") );
	if (confirm_val) return true;
	else 			 return false;
}

function printValues(bean_id, bean_name) {
	// Call the intermediate jsp, to make the values print.......
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=PRINT_VALUES", true ) ;
	xmlHttp.send( xmlDoc ) ;
}
//IN042962 - Added Start 
async function printCheck(bean_id, bean_name){
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=PRINT_CONFIRM", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	await eval( responseText ) ;
} 

async function confirmPrint()
{
	
	var formObj = parent.placeOrderDetailFrame.document.placeOrderForm;
	var total_rows = formObj.total_rows.value;
	var bean_id = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value;	
	if(total_rows > 0)
	{
		var finalString 	= "count="+total_rows
		var retVal 			= new String();
		var dialogHeight= "10" ;
		var dialogWidth	= "20" ;
		var dialogTop = "225" ;
		var center = "1" ;
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=no; status:no; ";
		if(( (formObj.function_from.value)=null?"":(formObj.function_from.value))!=="MO"){//IN066709
			var retVal1 	= await window.showModalDialog("../../eOR/jsp/OrderEntryPrintOption.jsp?"+finalString,arguments,features);
		}//IN066709
	var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		xmlStr			+= "chk_yn=\"" + retVal1 + "\" " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=PRINT_CONFIRM_VALUES", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;		
		eval( responseText ) ;
	}
}
function selallOrdertype(obj)//Currently ordertype wise checking is not included
{
	if(obj.checked){
		obj.checked = true;
		obj.value	= "Y";
	}	
	else{
		obj.checked = false;
		obj.value	= "N";
	}
		
}
function closeOrderType(obj){
	var chk_yn		= document.OrderTypeForm.chk.value;
	
	//if(chk_yn == "Y" && obj.value == 'OK')
	if(chk_yn == "Y" && obj.name == 'ok')
		chk_yn = "Y";
	else
		chk_yn = "N";
	window.returnValue		= chk_yn;
	window.close();

}  
//IN042962 -added End
// function called from OrderEntry.js
 // Used to get the Open a Modal window and get the Primary Order Type, if the Order Category is OT and OT Install
 async function getPrimaryOrderType(formObj){
	//var total_rows		= formObj.total_rows.value;
	var order_type			= ""; var count = 0;
 	for(var i=0;i<formObj.length;i++)
	{
		checked_yn			=  "N";
		if(eval("formObj.catalog_code"+i))
		{
			catalog_code_val = eval("formObj.catalog_code"+i+".value");
			//checked_yn		 = eval("formObj.ck"+catalog_code_val+".value")
			checked_yn		 = eval(formObj).document.getElementById("ck"+catalog_code_val).value;
			if(checked_yn=="Y")
			{
				// Check for the objects
				if(eval("formObj.order_type"+i))
				{
					order_type += eval("formObj.order_type"+i+".value")+"||";
					count++;
 				}
			} // End of 'Y'
		}	// End of catalog obj
	} // End of for
	if(order_type!="")
		order_type = order_type.substring(0,order_type.length-2); //remove the last symbol
 
    if(count > 1) // Atleast one is Y, that means it is checked
    {
 
		var finalString 	= "order_type="+escape(order_type)  
		var retVal 			= new String();
		var dialogHeight 	= "8" ;
		var dialogWidth  	= "16" ;
		var dialogTop    	= "210";
	    var status 			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no; ";
 		retVal				= await window.showModalDialog("../../eOR/jsp/OrderEntryPrimaryOrderType.jsp?"+finalString,arguments,features);
 		if(retVal!=null)
			formObj.primary_order_type.value = retVal;

	}
  	//new_order_reqd_yn = formObj.new_order_reqd.value
 	//if(new_order_reqd_yn=="Y")
	//{
	//	result = getConfirmation(formObj);
	//}
	//return result;

 }// End of getPrimaryOrderType

// Called on click of the Close BUtton in the Primary Order Type Modal Window
function closePrimary(){
 	//window.returnValue		= document.primaryOrderTypeForm.order_type_code.value;
	//window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = document.primaryOrderTypeForm.order_type_code.value;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}  //End of closePrimary

// Common Validations for the mandatory Field check, will return true or false
function checkMandField(formObj, object_name, message_id, message, i){
	var result_val = true;
    if(eval("formObj."+object_name+i))
	{
		var object_value 	= eval("formObj."+object_name+i+".value")
		if(object_value == "null" || object_value == null ||  object_value== "" ){
			result_val		= displayErrMessage(message_id, message);
		} // else the result_val will be true
 	} // End of if object
	return result_val;
} // End of checkMandStartDateTime

/* To display the alert Message and Stop from further proceeding
 * First Parameter will accept the message_id and the second parameter will be the message 
 */
function displayErrMessage(message_id, message){
	if(message=="")
		alert(getMessage(message_id,"OR")); // Will get the Message from OrMessages.js
	else 
	{  
		alert(message);
	}
	return false;
} // End of  displayErrMessage

// To arrest the enter key in the search criteria in additional search
function lockEnterKey()
{
	if(event.keyCode==13)
	{
	    event.returnValue=false;
	}
}
function billchecking(catalogcode)
{
	catalog_code_val =catalogcode;
	
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	var form				= parent.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	
	//checked_yn		 = eval(formObj).document.getElementById('ck'+catalog_code_val).value;
	checked_yn		 = (formObj).querySelector('#ck'+catalog_code_val).value;
	if(checked_yn=="Y"){
	(formObj).querySelector("#ck"+catalog_code_val).checked=false;
	(formObj).querySelector("#ck"+catalog_code_val).value="N";
	//eval(formObj).document.getElementById("ck"+catalog_code_val).value	= "N";
	}
	setCatalogCode(((formObj).querySelector("#ck"+catalog_code_val)),parent.parent.parent.tabFrame,"OR");
}
//IN068314 Starts
function billcheckingfpp(catalogcode)
{
	catalog_code_val =catalogcode;
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	var form				= parent.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	checked_yn		 =(formObj).querySelector("#ck"+catalog_code_val).value;
	if(checked_yn=="N"){
	(formObj).querySelector("#ck"+catalog_code_val).checked=true;
	(formObj).querySelector("#ck"+catalog_code_val).value="Y";
	}
	setCatalogCode(((formObj).querySelector("#ck"+catalog_code_val)),parent.parent.parent.tabFrame,"OR");
}

//IN068314 Ends
function setCheckValue(obj,catalogcode,index)
{
	// Call a method to store the value in the global variable in OrderEntryGlobal.js which is included in OrderEntryTab.jsp, When calling from Module OR
		//parent.placeOrderDetailFrame.document.location.reload();
	flag==true;
	var catalogcode=catalogcode;
	var catalog_val;
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	var form				= parent.placeOrderDetailFrame.document.getElementById("placeOrderForm");

	var total_count					=  formObj.total_rows.value;
	
	//for(var i=0;i<total_count;i++)
	//{
	catalog_code_val = eval("formObj.catalog_code"+index+".value");
	if(catalog_code_val==catalogcode)	
	{
		if(eval("formObj.billing_interface"+index+".value")=="interface")
		{
			if(eval("formObj.service_panel"+index+".value")=="" && eval("formObj.service_panel_code"+index+".value")=="")
			{
					
				flagchecking="1";
				checked_yn		 = (formObj).querySelector("#ck"+catalogcode).value;
				
				//if(checked_yn=="Y"){
					
				var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
				msg=msg.replace('{1}',catalogcode);
				alert(msg);
							
				(formObj).querySelector("#ck"+catalog_code_val).checked=false;
				(formObj).querySelector("#ck"+catalog_code_val).value="N";
				//eval(formObj).document.getElementById("ck"+catalog_code_val).value	= "N";
				//}
				setCatalogCode(((formObj).querySelector("#ck"+catalog_code_val)),parent.parent.parent.tabFrame,"OR");

			}
			if(eval("formObj.FinBill"+index+".value")=="Billing")
			{
				flagchecking="1";
				checked_yn		 = (formObj).querySelector("#ck"+catalogcode).value;
						
				alert(getMessage("BL1103","BL"));
							
				(formObj).querySelector("#ck"+catalog_code_val).checked=false;
				(formObj).querySelector("#ck"+catalog_code_val).value="N";
				//eval(formObj).document.getElementById("ck"+catalog_code_val).value	= "N";
				//}
				setCatalogCode(((formObj).querySelector("#ck"+catalog_code_val)),parent.parent.parent.tabFrame,"OR");
			}
		}/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
		else if(eval("formObj.billing_interface"+index+".value")=="auth_interface")
		{
			flagchecking="1";
			checked_yn		 = (formObj).querySelector("#ck"+catalogcode).value;
			var msg=getMessage("PRIV_ORDER_AUTH_RIGHTS","OR");
			msg=msg.replace('{1}',catalogcode);
			alert(msg);
						
			(formObj).querySelector("#ck"+catalog_code_val).checked=false;
			(formObj).querySelector("#ck"+catalog_code_val).value="N";
			setCatalogCode(((formObj).querySelector("#ck"+catalog_code_val)),parent.parent.parent.tabFrame,"OR");
		  }
		  else if(eval("formObj.billing_interface"+index+".value")=="operational_interface")
		  {
			flagchecking="1";
			checked_yn		 = (formObj).querySelector("#ck"+catalogcode).value;
			var msg=getMessage("CATALOG_OPERATIONAL_MODULE","OR");
			msg=msg.replace('{1}',catalogcode);
			alert(msg);
						
			(formObj).querySelector("#ck"+catalog_code_val).checked=false;
			(formObj).querySelector("#ck"+catalog_code_val).value="N";
			setCatalogCode(((formObj).querySelector("#ck"+catalog_code_val)),parent.parent.parent.tabFrame,"OR");
		  }
		  else if(eval("formObj.billing_interface"+index+".value")=="or_ordering_rule_chk")//IN050607 Starts
		  {
			flagchecking="1";
			checked_yn		 = (formObj).querySelector("#ck"+catalogcode).value;
			var msg=getMessage("OR_ORDERING_RULE_CHK","OR");
			msg=msg.replace('{1}',catalogcode);
			alert(msg);
						
			(formObj).querySelector("#ck"+catalog_code_val).checked=false;
			(formObj).querySelector("#ck"+catalog_code_val).value="N";
			setCatalogCode(((formObj).querySelector("#ck"+catalog_code_val)),parent.parent.parent.tabFrame,"OR");
		  }//IN050607 Ends
		}/*Ends Here*/
	
	
	//}
		if(flagchecking=="0")
		{
		
			setCatalogCode(obj,parent.parent.parent.tabFrame,"OR");
			if(obj.checked==false)
			{
				obj.value	= "N";
				document.placeOrderForm.check_box_val.value = "Y";
			}
			else  obj.value	= "Y";
		}
		ClinicalComment();
		
		drugInteraction(total_count,catalogcode,index);//IN072595
}
//IN072595 Starts
function drugInteraction(total_count,catalogcode,index){
	var form				= parent.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	var interactionDrugsCnt=(form).querySelector("#interactionDrugsCnt").value;
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	var catalog_chk_unchk = "";
	  
	  	if(interactionDrugsCnt>0){
	  		
	  		if((formObj).querySelector("#ck"+catalogcode).checked==false)
	  			catalog_chk_unchk = "H";
	  		if((formObj).querySelector("#ck"+catalogcode).checked==true)
	  			catalog_chk_unchk = "";
	  		
	  		var xmlDoc="";
	  		var xmlHttp = new XMLHttpRequest();
	  		xmlStr ="<root><SEARCH " ;	
	  		xmlStr += " p_bean_id=\""+document.getElementById("bean_id").value+ "\" ";
	  		xmlStr += " p_bean_name=\""+document.getElementById("bean_name").value+ "\" ";
	  		xmlStr += " catalog_code=\""+catalogcode+ "\" ";
	  		xmlStr += " catalog_chk_unchk=\""+catalog_chk_unchk+ "\" ";
	  		xmlStr += " p_action=\"DRUG_INTERACTION_HIDE_UNHIDE\"";
	  		xmlStr += "/></root>";
	  		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	  		xmlHttp.open("POST", "OrderLineIntermediate.jsp", false );
	  		xmlHttp.send(xmlDoc);
	  		responseText = xmlHttp.responseText; 
	  	}
	  		
}
//IN072595 Ends
function displaycolor(index)
{
	if(eval(document.getElementById("billing"+index))&&eval(document.getElementById("billing"+index)).style!=undefined){
	eval(document.getElementById("billing"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing1"+index))&&eval(document.getElementById("billing1"+index)).style!=undefined){
	eval(document.getElementById("billing1"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing2"+index))&&eval(document.getElementById("billing2"+index)).style!=undefined){
	eval(document.getElementById("billing2"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing3"+index))&&eval(document.getElementById("billing3"+index)).style!=undefined)
	{
		eval(document.getElementById("billing3"+index)).style.background='#FF7DD0';
	}
	if(eval(document.getElementById("priority_id"+index))&&eval(document.getElementById("priority_id"+index)).style!=undefined){
	eval(document.getElementById("priority_id"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing4"+index))&&eval(document.getElementById("billing4"+index)).style!=undefined){
	eval(document.getElementById("billing4"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing5"+index))&&eval(document.getElementById("billing5"+index)).style!=undefined){
	eval(document.getElementById("billing5"+index)).style.background='#FF7DD0';}
	if(document.getElementById('frequency_id'+index)&&document.getElementById('frequency_id'+index).style!=undefined){
	document.getElementById('frequency_id'+index).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing6"+index))&&eval(document.getElementById("billing6"+index)).style!=undefined){
	eval(document.getElementById("billing6"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("duration_code_id"+index))&&eval(document.getElementById("duration_code_id"+index)).style!=undefined){
	eval(document.getElementById("duration_code_id"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing7"+index))&&eval(document.getElementById("billing7"+index)).style!=undefined){
	eval(document.getElementById("billing7"+index)).style.background='#FF7DD0';}
	//eval("document.getElementById("billing8")"+index).style.background='#FF7DD0';
	if(eval(document.getElementById("billing9"+index))&&eval(document.getElementById("billing9"+index)).style!=undefined){
	eval(document.getElementById("billing9"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing10"+index))&&eval(document.getElementById("billing10"+index)).style!=undefined){
	eval(document.getElementById("billing10"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing11"+index))&&eval(document.getElementById("billing11"+index)).style!=undefined){
	eval(document.getElementById("billing11"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("billing12"+index))&&eval(document.getElementById("billing12"+index)).style!=undefined){
	eval(document.getElementById("billing12"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("order"+index))&&eval(document.getElementById("order"+index)).style!=undefined){
	
		eval(document.getElementById("order"+index)).innerHTML= '';//IN068314
		eval(document.getElementById("order"+index)).style.background='#FF7DD0';//IN068314
	}	 
	if(eval(document.getElementById("order2"+index))&&eval(document.getElementById("order2"+index)).style!=undefined){//IN073309 Starts
			eval(document.getElementById("order2"+index)).innerHTML= '';
			eval(document.getElementById("order2"+index)).style.background='#FF7DD0';
	}//IN073309 Ends
	if(eval(document.getElementById("schedule"+index))&&eval(document.getElementById("schedule"+index)).style!=undefined){
	eval(document.getElementById("schedule"+index)).style.background='#FF7DD0';}
	if(eval(document.getElementById("order1"+index))&&eval(document.getElementById("order1"+index)).style!=undefined){
	eval(document.getElementById("order1"+index)).style.background='#FF7DD0';}
	if(document.getElementById('performing_dept_loc_code_id'+index)&&document.getElementById('performing_dept_loc_code_id'+index).style!=undefined){
	document.getElementById('performing_dept_loc_code_id'+index).style.background='#FF7DD0';}
}
function setOrderID(orderid)
{
	
}
function setPerforming(key,obj)
{
	var value=obj.value;
	setValue(key,value);
}

function setFrequencyCode(key, obj)
{
	var value=obj.value;
	setValue(key,value);
}

function setcheckMaxValue(key, obj)
{
	var value=obj.value;
	setValue(key,value);
}

function setValue(key,value)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var bean_id ="";
	var bean_name ="";

	
	if(document.forms[0])
	{
		bean_id=document.forms[0].bean_id.value;
		bean_name=document.forms[0].bean_name.value;
	}
	//IN038787 Start.
	else if(parent.document.frames[1])
	{
		bean_id = parent.document.frames[1].bean_id.value;
		bean_name = parent.document.frames[1].bean_name.value;
	}
	//IN038787 End.
	else if(document.frames[1])
	{
		bean_id = document.frames[1].bean_id.value;
		bean_name = document.frames[1].bean_name.value;
	}
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
}

function callamend_duration_value(key,obj)
{
	var value=obj.value;
	setValue(key,value);
}

function OrderTypedisable(form_name)
{
	if(form_name=='addlSearchCriteriaForm')
	{
		formobj=document.addlSearchCriteriaForm;
	}
	else if(form_name=='tickSheetForm')
	{
		formobj=document.tickSheetForm;
	}else if(form_name=="careSetSearchForm")
	{
		formobj=document.careSetSearchForm;
	}else if(form_name=="imageSearchForm")
	{
		formobj=document.imageSearchForm;
	}

	if(formobj.order_category.value=="")
		{
			formobj.order_type_desc.disabled=true;
			formobj.ordertypesearch.disabled=true;
		}
}
/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/

function storeFixedConsentVal(index,from)
{	
	var formObj=parent.placeOrderDetailFrame.document.placeOrderForm;
	var consent_form_list="";
	var amend_consent_form_list="";
	if(eval("formObj.consent_form_list"+index))
		consent_form_list =  eval("formObj.consent_form_list"+index+".value");
	if(eval("formObj.amend_consent_form_list"+index))
		amend_consent_form_list =  eval("formObj.amend_consent_form_list"+index+".value");
	var ord_catalog_code = "";
	var order_category = "";
	var num_of_consent_req_bo = 0;
	var num_of_consent_req_br = 0;
	var record		 = false;
	var tmp_cnt_bo	 = 0;
	var tmp_cnt_br	 = 0;
	var atleast_one	 = 0;
	var consent_chk	 = "N";
	var bean_id		 = formObj.bean_id.value
	var bean_name	 =  formObj.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	xmlStr			+= "bean_id=\"" +bean_id +"\" ";
	xmlStr			+= "bean_name=\"" +bean_name +"\" ";
	xmlStr			+= "index=\"" +index +"\" ";
	if(eval("formObj.total_recs"+index)!=null && consent_form_list == 'F' && from=='NEW_ORDER')
	{
		var total_recs	 = eval("formObj.total_recs"+index+".value");	
		if(eval("formObj.catalog_code"+index))
		{//new order
			ord_catalog_code=eval("formObj.catalog_code"+index+".value");
			order_category =eval("formObj.group_order_category"+index+".value");
			if(formObj.care_set_count.value>0)
			{
				order_category=formObj.order_category.value;
			}
			if(eval("formObj.num_of_consent_req_bo"+index+".value"))
			{
				num_of_consent_req_bo = eval("formObj.num_of_consent_req_bo"+index+".value");
				num_of_consent_req_br =eval("formObj.num_of_consent_req_br"+index+".value");
			}
		}
		xmlStr			+= "ord_catalog_code=\"" +ord_catalog_code +"\" ";
		xmlStr			+= "order_category=\"" +order_category +"\" ";
		xmlStr			+= "count=\"" +total_recs +"\" ";
		for(var m=0;m<total_recs;m++)
		{
			if(eval("formObj.consent_chk"+index+m))
			{
				 if (eval("formObj.consent_chk"+index+m).type == 'hidden')
				{
					record		= true;
					consent_chk = "Y";
				}
			}
			var consent_form_id	 = "";
			var consent_stage	 = "";
			if(eval("formObj.consent_form_id"+index+m))
				consent_form_id	 = eval("formObj.consent_form_id"+index+m).value;
			if(eval("formObj.consent_stages"+index+m))
				consent_stage	 = eval("formObj.consent_stages"+index+m).value;

			xmlStr		+= "consent_chk"+m+"=\"" +consent_chk+"\" ";
			xmlStr		+= "consent_form_id"+m+"=\""+consent_form_id+"\" ";
			xmlStr		+= "consent_stage"+m+"=\""+consent_stage+"\" ";
		}
	}
	if(eval("formObj.amend_total_recs"+index)!=null && amend_consent_form_list == 'F' && from=='AMEND_ORDER')
	{
		var total_recs	 = eval("formObj.amend_total_recs"+index+".value");	
		if(eval("formObj.amend_catalog_code"+index))
		{// amend Order
			ord_catalog_code=eval("formObj.amend_catalog_code"+index+".value");
			order_category =eval("formObj.amend_order_category"+index+".value");
			if(eval("formObj.amend_num_of_consent_req_bo"+index+".value"))
			{
				num_of_consent_req_bo = eval("formObj.amend_num_of_consent_req_bo"+index+".value");
				num_of_consent_req_br =eval("formObj.amend_num_of_consent_req_br"+index+".value");
			}
		}	
		xmlStr			+= "ord_catalog_code=\"" +ord_catalog_code +"\" ";
		xmlStr			+= "order_category=\"" +order_category +"\" ";
		xmlStr			+= "count=\"" +total_recs +"\" ";
		for(var m=0;m<total_recs;m++)
		{
			if(eval("formObj.amend_consent_chk"+index+m))
			{
				 if (eval("formObj.amend_consent_chk"+index+m).type == 'hidden')
				{
					record		= true;
					consent_chk = "Y";
				}
			}
			var consent_form_id	 = "";
			var consent_stage	 = "";
			if(eval("formObj.amend_consent_form_id"+index+m))
				consent_form_id	 = eval("formObj.amend_consent_form_id"+index+m).value;
			if(eval("formObj.amend_consent_stages"+index+m))
				consent_stage	 = eval("formObj.amend_consent_stages"+index+m).value;

			xmlStr		+= "consent_chk"+m+"=\"" +consent_chk+"\" ";
			xmlStr		+= "consent_form_id"+m+"=\""+consent_form_id+"\" ";
			xmlStr		+= "consent_stage"+m+"=\""+consent_stage+"\" ";
		}
	}
	xmlStr 					+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?&bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=MULTICONSENT_DTLS", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;	
}
/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/

function ClinicalComment()
{
	
	EnableEmail();
	var form				        = parent.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;
	var headerformObj	 			= parent.criteriaMainFrame.document.placeOrderHeaderForm ;
	var function_from				="";
	var ammend_called_from = "";
	if(headerformObj.ammend_called_from)
	{
		ammend_called_from			=  headerformObj.ammend_called_from.value;
	}
	var result_val = "true";
		// Call a function to check whether atleast one item has been checked,otherwise no need to submit
	if( ammend_called_from!="existing_order")
		result_val 	= checkToSubmit("parent.placeOrderDetailFrame",formObj); // otherwise it will come as undefined., send the frame reference "parent.placeOrderDetailFrame".
        
	if(!result_val) // Atleast one item is checked, then proceed
	{
		//alert(getMessage("CLICK_ONE_ORDERABLE","OR"))
	 	 return false;
	}
	if(form.function_name)
	{
		function_from				=form.function_name.value;
	}
	var clin_cmts_reqd_yn="";
	if(headerformObj.clin_cmts_reqd_yn!=null){
		clin_cmts_reqd_yn		= headerformObj.clin_cmts_reqd_yn.value;
	}
	/*if(parseInt(form.total_rows.value)==0)
	{
		alert("APP-OR0158	Atleast one item should be selected to place order.Select and continue.");
		return false;
	}*/

	var j=0;
	var temp_order_cat="";
	var order_cat="";
	var cl_cmts_yn="N";
	if(formObj)
			if(formObj.checkCount)
				var Clinical_total_count=formObj.checkCount.value;
								
	if((function_from=='PREVIEW')&&(form.care_set_count.value==0))
	{
		for(var z=0;z<(form.total_rows.value);z++)
		{	
			if(eval("form.catalog_code"+z))
			{
				order_category=eval(document.getElementById("group_order_category"+z)).value;
				var catalog_codezval = document.getElementById("ck"+eval("form.catalog_code"+z).value);
				if(catalog_codezval.checked==true)
				{
					temp_order_cat=eval(document.getElementById("group_order_category"+z)).value;
					clin_cmts_reqd_yn1 = eval("form.clin_cmts_reqd_yn"+z).value;
					j++;
					if(order_cat!=temp_order_cat)
					{
						cl_cmts_yn="N";
						order_cat=eval(document.getElementById("group_order_category"+z)).value;
					}
			/*		if (eval("form.clin_category_comments_reqd_yn"+temp_order_cat))
					{		*/			
						if(eval("form.clin_category_comments_reqd_yn"+temp_order_cat).value=="Y")
						{
							cl_cmts_yn="Y";
						}
						else
						{
							if(clin_cmts_reqd_yn1=="Y")
							{
								cl_cmts_yn="Y";
							}
						}	
						if (eval(document.getElementById("cl_cmt_mand"+order_cat))!=null)
						{
						
							if(cl_cmts_yn=="Y")
							{
								eval(document.getElementById("cl_cmt_mand"+order_cat)).style.visibility="visible";
							}
							else
							{
								eval(document.getElementById("cl_cmt_mand"+order_cat)).style.visibility="hidden";
							}
						}
					//}
				}
				else
				{
					if(order_category!=temp_order_cat)
					{
						if (eval(document.getElementById("cl_cmt_mand"+order_category))!=null )
						{
							eval(document.getElementById("cl_cmt_mand"+order_category)).style.visibility="hidden";
						}
					}
				}
			}
		}
		if(j==0)
		{
			if(headerformObj.cl_cmt_mand!=null){
				headerformObj.cl_cmt_mand.style.visibility="hidden";
			}
		}
	}
	else
	{
		if(clin_cmts_reqd_yn!="Y")
		{
			for(var z=0;z<(Clinical_total_count);z++)
			//for(var z=0;z<(form.length);z++)
			{	
				var catlog1=form["catalog_code"+z];
				if(catlog1)
				{
					if(document.getElementById("ck"+catlog1.value).checked==true)
					{
						var catlog2=form["clin_cmts_reqd_yn"+z];
						if(catlog2)
						{
							clin_cmts_reqd_yn = catlog2;
						}
					
						if(catlog2.value=="Y")
						{	
							j++;
							if(headerformObj)
							{
								if(headerformObj.cl_cmt_mand)
								{
									headerformObj.cl_cmt_mand.style.visibility="visible";
									z=Clinical_total_count;								
								}
							}
						}
					}
				}
			
				if(eval("form.amend_catalog_code"+z))
				{	
					var temp = eval("form.amend_catalog_code"+z).value;
					if(document.getElementById("ck"+temp).checked==true)
					{
						clin_cmts_reqd_yn = eval("form.amend_clin_cmts_reqd_yn"+z);
						if(clin_cmts_reqd_yn.value=="Y")
						{	
							j++;
							if(headerformObj)
							{
								if(headerformObj.cl_cmt_mand)
								{
									headerformObj.cl_cmt_mand.style.visibility="visible";
									z=Clinical_total_count;
								}
							}
						}
					}
				}
			}
			if(j==0)
			{
				parent.criteriaMainFrame.document.placeOrderHeaderForm.cl_cmt_mand.style.visibility="hidden";
			}
		}
	}
	//DisableAuthorise();
	AuthoriseCatalogs();
}

function DisableAuthorise()
{
		var form				                = parent.placeOrderDetailFrame.document.getElementById("placeOrderForm");
		var headerformObj	 			=  parent.criteriaMainFrame.document.placeOrderHeaderForm ;
		var auth_yn="Y";
		var prac_auth_reqd            = headerformObj.auth_reqd.value;
		var select_count=0;
		
		for(var z=0;z<(form.length);z++)
		{	
			if(eval("form.catalog_code"+z))
			{
				if(eval(form).document.getElementById("ck"+eval("form.catalog_code"+z).value).checked==true)
				{
					select_count++;
					auth_yn = eval("form.auth_yn"+z).value;						
					if(auth_yn=="N")
					{	
						z=form.length;
					}
				}
			}
			if(eval("form.amend_catalog_code"+z))
			{
				select_count++;				if(eval(form).document.getElementById("ck"+eval("form.amend_catalog_code"+z).value).checked==true)
				{			
					auth_yn = eval("form.amend_auth_yn"+z).value;				
					if(auth_yn=="N")
					{	
						z=form.length;
					}
				}
			}
	}
	
	if((auth_yn=="Y" || auth_yn=="") && prac_auth_reqd == "Y" )
	{
		if(headerformObj.auths)
		{
			if(headerformObj.auths.style!=undefined)
			{
				headerformObj.auths.style.visibility="visible";
			}
			if(headerformObj.auth)
			{
				if(headerformObj.auth.style!=undefined)
				{
					headerformObj.auth.style.visibility="hidden";					
				}
			}
		}
		
		if(form.auths)
		{
			if(form.auths.style!=undefined)
			{
				form.auths.style.visibility="visible";
			}
			if(form.auth)
			{
				if(form.auth.style!=undefined)
				{
					form.auth.style.visibility="hidden";
				}
			}
		}
		
		if(headerformObj.press_links)
		{
			if(headerformObj.press_links.style!=undefined)
			{
				headerformObj.press_links.style.visibility="visible";
			}
			if(headerformObj.press_link)
			{
				if(headerformObj.press_link.style!=undefined)
				{
					headerformObj.press_link.style.visibility="hidden";
				}
			}
		}
		
		if(form.press_links)
		{
			if(form.press_links.style!=undefined)
			{
				form.press_links.style.visibility="visible";
			}
			if(form.press_link)
			{
				if(form.press_link.style!=undefined)
				{
					form.press_link.style.visibility="hidden";
				}
			}
		}
	}
	else if(auth_yn=="N")
	{
		if(headerformObj.auths)
			headerformObj.auths.style.visibility="hidden";
		if(headerformObj.auth)
			headerformObj.auth.style.visibility="visible";
		if(form.auths)
		{
			if(form.auths.style)
			{
				form.auths.style.visibility="hidden";
			}
		}
		if(form.auth)
		{
			if(form.auths.style)
			{
				form.auth.style.visibility="visible";
			}
		}

		if(headerformObj.press_links)
			headerformObj.press_links.style.visibility="hidden";
		if(headerformObj.press_link)
			headerformObj.press_link.style.visibility="visible";
		if(form.press_links)
			form.press_links.style.visibility="hidden";
		if(form.press_link)
			form.press_link.style.visibility="visible";

	}
	if(select_count==0)
	{
		//if(parent.criteriaPlaceOrderFrame.criteriaDetailFrame)
		//{
			parent.criteriaDetailFrame.document.getElementById("EmailPreview").style.display="none";
			if(form.email_yn)
			form.email_yn.value="N";
		//}
	}
}

async function email(bean_id,bean_name)
{
	var retVal;
 	var dialogTop   = "150";
 	var dialogHeight= "30" ;
 	var dialogWidth = "45" ;
 	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments	= "";

 	var qryString = "";
 	var	formObj	 	 	 	= criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
	var form				= criteriaPlaceOrderFrame.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	var HTMLText			=  new Array();
   	var arrInd 	 			= 0;
	var count=0;
   	HTMLText[arrInd++]	     = "<html><head><script>function submitFn(){ }</script></head><body><form name=\"dummyForm\" id=\"dummyForm\" >";
	for(var i=0;i<formObj.length;i++)
	{
		checked_yn					=  "N";
		if(eval("formObj.amend_catalog_code"+i))
		{
			catalog_code_val = eval("formObj.amend_catalog_code"+i+".value");
			checked_yn		 = form["ck"+catalog_code_val].value
			if(checked_yn == "Y")
			{
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"catalog_code"+count+"\" id=\"catalog_code"+count+"\" value=\""+eval("formObj.amend_catalog_code"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"pat_instrn_age_sex_yn"+count+"\" id=\"pat_instrn_age_sex_yn"+count+"\" value=\""+eval("formObj.amend_pat_instrn_age_sex_yn"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"priority"+count+"\" id=\"priority"+count+"\" value=\""+eval("formObj.amend_priority"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_comments"+count+"\" id=\"amend_line_comments"+count+"\" value=\""+eval("formObj.amend_line_comments"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_preps"+count+"\" id=\"amend_line_preps"+count+"\" value=\""+eval("formObj.amend_line_preps"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_pat_instrn"+count+"\" id=\"amend_line_pat_instrn"+count+"\" value=\""+eval("formObj.amend_line_pat_instrn"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_dept_instrn"+count+"\" id=\"amend_line_dept_instrn"+count+"\" value=\""+eval("formObj.amend_line_dept_instrn"+i+".value")+"\">";
				count++;
			} // end of checked_yn
		} // for Amend_orders
	} // End of for
	
	for(var i=0;i<formObj.length;i++)
	{
		if(eval("formObj.catalog_code"+i))
		{
			catalog_code_val = eval("formObj.catalog_code"+i+".value");
			checked_yn		 = form["ck"+catalog_code_val].value
			if(checked_yn=="Y")
			{
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"catalog_code"+count+"\" id=\"catalog_code"+count+"\" value=\""+eval("formObj.catalog_code"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"pat_instrn_age_sex_yn"+count+"\" id=\"pat_instrn_age_sex_yn"+count+"\" value=\""+eval("formObj.pat_instrn_age_sex_yn"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"priority"+count+"\" id=\"priority"+count+"\" value=\""+eval("formObj.priority"+i+".value")+"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_comments"+count+"\" id=\"amend_line_comments"+count+"\" value=\"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_preps"+count+"\" id=\"amend_line_preps"+count+"\" value=\"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_pat_instrn"+count+"\" id=\"amend_line_pat_instrn"+count+"\" value=\"\">";
				HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"amend_line_dept_instrn"+count+"\" id=\"amend_line_dept_instrn"+count+"\" value=\"\">";
				count++;
			}  // End of checked_yn='Y'
		} // end of if
	} // End of for
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\""+bean_id+"\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\""+bean_name+"\">";
	HTMLText[arrInd++]	     = "<input type=\"hidden\" name=\"total_rows\" id=\"total_rows\" value=\""+count+"\">";
	HTMLText[arrInd++]			 = "</form>";
	var arguments	   = HTMLText;
	 retVal 			= await window.showModalDialog("../../eOR/jsp/EmailFrameset.jsp?"+qryString,arguments,features);
	 
}

async function discountAllowed(allow_yn,patient_id,bill_doc_type,bill_doc_num,bill_group_id,called_from,patient_class,episode_id,visit_id,encounter_id)
{
	var retVal = "";
	var dialogHeight = "90vh";
	var dialogWidth = "90vw";
	var dialogTop = "100";
	var center = "1";
	var status = "no";
	var l_bill_doc_type="";
	var l_bill_doc_num="";
	var l_blng_grp="";
	if(called_from=="STLMT")
	{
		l_bill_doc_type=bill_doc_type;
		l_bill_doc_num=bill_doc_num;
		l_blng_grp=bill_group_id;
	}
	//var encounter_id="";
	//var episode_id="";
	//var visit_id="";
	var module_id="OR";
	var episode_type="";
	if(patient_class=='OP')
	{
		episode_type = 'O';
	}
	else if (patient_class=='EM')
	{
		episode_type = 'E';
	}
	else if (patient_class=='XT')
	{
		episode_type = 'R';
	}
	var call_disc_function_yn=allow_yn;
	var l_slmt_reqd_yn="Y";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	
	var url = "../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code="+l_bill_doc_type + "&bill_doc_num="+l_bill_doc_num + "&blng_grp="+l_blng_grp+"&module_id="+module_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&call_disc_function_yn="+call_disc_function_yn+"&episode_id="+episode_id+"&visit_id="+visit_id+"&slmt_reqd_yn="+l_slmt_reqd_yn+"&episode_type="+episode_type;

	retVal = await top.window.showModalDialog(url, arguments, features);
	while(retVal==undefined)
	{
		retVal = await top.window.showModalDialog(url, arguments, features);
	}
}
function closeViewRecords()
{
//	window.returnValue="VIEW";
//	window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "VIEW";
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}
function EnableEmail()
{
	
	var form				                = parent.placeOrderDetailFrame.document.getElementById("placeOrderForm");
	var headerformObj	 			=  parent.criteriaMainFrame.document.placeOrderHeaderForm ;
	
	var patient_email_yn="";
	if(form.patient_email_id)
	{
		patient_email_yn=form.patient_email_id.value;
	
		if(patient_email_yn!=undefined && patient_email_yn!="undefined"&&patient_email_yn!="")
		{
				patient_email_yn="Y";
		}
	}
	var j=0;
	
	if(patient_email_yn=="Y")
	{
		for(var z=0;z<(form.length);z++)
		{	
			if(eval("form.catalog_code"+z))
			{
				if(eval(form).document.getElementById("ck"+eval("form.catalog_code"+z).value).checked==true)
				{
			
					enable_mail = eval("form.enable_email"+z);
				
					if(enable_mail.value=="Y")
					{	
						j++;
						z=form.length;
					}
				}
			}
			
			if(eval("form.amend_catalog_code"+z))
			{	
				if(eval(form).document.getElementById("ck"+eval("form.amend_catalog_code"+z).value).checked==true)
				{
					enable_mail = eval("form.amend_enable_email"+z);
					if(enable_mail.value=="Y")
					{	
						j++;
						
						z=form.length;
							
					}
				}
			}
		}
		if(j==0)
		{
			parent.criteriaDetailFrame.document.getElementById("EmailPreview").style.display="none";
			form.email_yn.value="N";
		}
		else
		{
			parent.criteriaDetailFrame.document.getElementById("EmailPreview").style.display="inline";
			form.email_yn.value="Y";
		}
	}
}
function clearDepLocn(index,order_catalog_code,order_category,order_type_code,rd_install,obj)
{
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;	
	if(formObj.function_name.value!="PREVIEW")
	{
		var len = eval("formObj.performing_dept_loc_code"+index+".options.length");
		var performing_location = obj.value;
		for(var i=0;i<len;i++)
		{
			eval("formObj.performing_dept_loc_code"+index+".remove(\"atc_class_l2_code\")") ;
		}
		var tp = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
		var opt=document.createElement('OPTION');
		opt.text = tp ;
		opt.value = "" ;
		eval("formObj.performing_dept_loc_code"+index+".add(opt)");
		bean_id 			= formObj.bean_id.value;
		bean_name 			= formObj.bean_name.value; 	
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr		 = "<root><SEARCH " ;
		xmlStr		+= "index=\"" + index +"\" ";
		xmlStr		+= "performing_location=\"" + performing_location +"\" ";
		xmlStr		+= "order_catalog_code=\"" + order_catalog_code +"\" ";
		xmlStr		+= "order_category=\"" + order_category +"\" ";
		xmlStr		+= "order_type_code=\"" + order_type_code +"\" ";
		xmlStr		+= "rd_install=\"" + rd_install +"\" ";
		xmlStr 					+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=deptlocation",false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText ) ;
	}else//IN048942 - for preview screen performing location issue - Start
	{
		var formObj = document.placeOrderForm;
		bean_id 			= formObj.bean_id.value;
		bean_name 			= formObj.bean_name.value; 	
var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr		 = "<root><SEARCH " ;
		xmlStr		+= "index=\"" + index +"\" ";
		xmlStr		+= "performing_location=\"" + obj.value +"\" ";
		xmlStr		+= "order_catalog_code=\"" + order_catalog_code +"\" ";
		xmlStr		+= "order_category=\"" + order_category +"\" ";
		xmlStr		+= "order_type_code=\"" + order_type_code +"\" ";
		xmlStr		+= "rd_install=\"" + rd_install +"\" ";
		xmlStr 					+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=deptlocation_preview",false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText ) ;
	}//IN048942 - for preview screen performing location issue - End
}
//IN048942 - for preview screen performing location issue - Start
function setpreviewdeptloc(sel,index,performing_location,rd_install,order_type_code,order_category,order_catalog_code,code,value)
{
		var em = "";
		if(sel != "" && sel !=undefined)
		{
			eval("document.placeOrderForm.performing_dept_loc_code"+index+".value=code");	
			eval("document.placeOrderForm.performing_dept_loc_code_id"+index+".innerHTML = \"<a class='gridLink' href=javascript:changePerformingDeptLoc('"+index+"','"+performing_location+"','"+order_catalog_code+"','"+order_category+"','"+order_type_code+"','"+rd_install+"')><font size='1'>"+value+"</font></a>\" ");
		}else
		{
			var tp = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
			eval("document.placeOrderForm.performing_dept_loc_code"+index+".value=em");	
			eval("document.placeOrderForm.performing_dept_loc_code_id"+index+".innerHTML = \"<a class='gridLink' href=javascript:changePerformingDeptLoc('"+index+"','"+performing_location+"','"+order_catalog_code+"','"+order_category+"','"+order_type_code+"','"+rd_install+"')><font size='1'>"+tp+"</font></a>\" ");
		}	
}
//IN048942 - for preview screen performing location issue - End
//IN044014 included sel param
function addPerformingLocnList(code,value,index,sel) 
{
	var	formObj	 	 	 			=  parent.placeOrderDetailFrame.document.placeOrderForm ;	
	var element = parent.placeOrderDetailFrame.document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	//IN044014 added condition
	if(sel != "" && sel !=undefined)
	{
		element.selected = "selected";
	}	
	eval("formObj.performing_dept_loc_code"+index).add(element);
}

function setPerformingFacility(key,obj)
{
	var value=obj.value;
	setValue(key,value);
}


function setOrderSetChecked(key,obj)
{
	//var value=obj.value;
	setValue(key,obj);

}
function getOrderSetChecked()
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var bean_id ="";
	var bean_name ="";

	if(document.forms[0])
	{
		bean_id=document.forms[0].bean_id.value;
		bean_name=document.forms[0].bean_name.value;
	}
	//IN038787 Start.
	else if(parent.document.frames[1])
	{
		bean_id = parent.document.frames[1].bean_id.value;
		bean_name = parent.document.frames[1].bean_name.value;
	}
	//IN038787 End.
	else if(document.frames[1])
	{
		bean_id = document.frames[1].bean_id.value;
		bean_name = document.frames[1].bean_name.value;
	}
	var func_mode="getTempvalues";
	xmlStr ="<root><SEARCH " ;
	//xmlStr += " key=\""+ key +"\" " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode="+func_mode,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	var temp=eval(responseText );
	return temp;
}

function clearTempvalues()
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
   	var bean_id= parent.frames[0].document.forms[0].bean_id.value;
	var bean_name=parent.frames[0].document.forms[0].bean_name.value;
	var func_mode="clearTempvalues";
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode="+func_mode,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function clearPlacedOrderClinicalComments(orderCateg)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
   	var bean_id= parent.frames[0].document.forms[0].bean_id.value;
	var bean_name=parent.frames[0].document.forms[0].bean_name.value;
		//var bean_id=document.getElementById("bean_id").value;
	//var bean_name=document.getElementById("bean_name").value;
	var func_mode="clearPlacedOrderClinicalComments";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " order_category=\""+ orderCateg +"\" " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode="+func_mode,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

/*Added by Uma on 8/24/2009 for PMG20089 - CRF 641*/
function AuthoriseCatalogs()
{
		var form				                = parent.placeOrderDetailFrame.document.getElementById("placeOrderForm");
		var headerformObj	 			=  parent.criteriaMainFrame.document.placeOrderHeaderForm ;
		var auth_reqd_yn							= "";
		var prac_can_auth_yn				= "";
		var select_count=0;
		
		if(form)
			if(form.checkCount)
				var authorise_total_count=form.checkCount.value;
		
		//for(var z=0;z<(form.length);z++)
		for(var z=0;z<authorise_total_count;z++)
		{	
			var catalogCodeElement = form["catalog_code" + z];
		    var amendCatalogCodeElement = form["amend_catalog_code" + z];
			if(catalogCodeElement)
			{
				  var catalogCheckbox = parent.placeOrderDetailFrame.document.getElementById("ck" + catalogCodeElement.value);
				if(catalogCheckbox && catalogCheckbox.checked)
				{
					select_count++;
					auth_reqd_yn = form["ord_auth_reqd_yn" + z].value;
		            prac_can_auth_yn = form["auth_yn" + z].value;	
					if(auth_reqd_yn =="Y" && prac_can_auth_yn =="Y" )
					{	
						z=authorise_total_count;
					}
				}
			}
			if(amendCatalogCodeElement)
			{					
				  var amendCheckbox = parent.placeOrderDetailFrame.document.getElementById("ck" + amendCatalogCodeElement.value);
				if(amendCheckbox && amendCheckbox.checked)
				{			
					select_count++;	
					auth_reqd_yn = form["amend_ord_auth_reqd_yn" + z].value;
		            prac_can_auth_yn = form["amend_auth_yn" + z].value;		
					if(auth_reqd_yn =="Y" && prac_can_auth_yn =="Y" )
					{	
						z=authorise_total_count;
					}
				}
			}
	}
	
	if((auth_reqd_yn=="Y" || auth_reqd_yn =="") && prac_can_auth_yn == "Y" )
	{
		if(headerformObj.auths)
		{
			if(headerformObj.auths.style!=undefined)
			{
				if(headerformObj.auths)
					headerformObj.auths.style.display="inline";
				if(headerformObj.hdg)
					headerformObj.hdg.style.display="inline";
				if(headerformObj.textimg)
					headerformObj.textimg.style.display="inline";
				if(headerformObj.links1)
					headerformObj.links1.style.display="inline";
			}
		}
	}
	else
	{
		if(headerformObj.auths)
		{
			if(headerformObj.auths.style!=undefined)
			{
				if(headerformObj.auths)
					headerformObj.auths.style.display="none";
				if(headerformObj.hdg)
					headerformObj.hdg.style.display="none";
				if(headerformObj.textimg)
					headerformObj.textimg.display="none";
				if(headerformObj.links1)
					headerformObj.links1.display="none";
			}
		}
	}
	if(select_count==0)
	{
		parent.criteriaDetailFrame.document.getElementById("EmailPreview").style.display="none";
		if(form.email_yn)
		form.email_yn.value="N";
	
	}
}
/*function printReportValues(bean_id, bean_name) 
{
	
	// Call the intermediate jsp, to make the values print.......
	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var func_mode = "PRINT_REPORT_VALUES";
	//var func_mode = "PRINT_VALUES";
	var called_from = "PLACEORDER";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	//xmlStr += " func_mode=\""+ func_mode + "\" ";
	xmlStr += " CALLED_FROM=\""+ called_from + "\" ";
	xmlStr +=" /></root>" ;
	alert("printReportValues    :    "+xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?func_mode="+func_mode, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//responseText	= xmlHttp.responseText ;
	eval( responseText ) ;
}*/
function printReportValues(bean_id, bean_name) 
{
	// Call the intermediate jsp, to make the values print.......
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH/></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=PRINT_REPORT_VALUES", true ) ;
	xmlHttp.send( xmlDoc ) ;
	//responseText	= xmlHttp.responseText ;
	//eval( responseText ) ;
}

function chkCount()
{
	var formObj=parent.placeOrderDetailFrame.document.placeOrderForm;
	var j=0;
	for(i=0;i<formObj.elements.length;i++)
	{
		
		if(formObj.elements[i].type=="checkbox" )
		{
			var temp=(formObj.elements[i].name).substring(0,2);
			if(temp=="ck")
				j++;					
		}
	}			
	if(formObj)
		formObj.checkCount.value=j;			
}
/*Added by Uma 20/02/2010 for IN017231*/
function storeValuesForOrders(form_object,form_name,catalogs)
{
	
 	var bean_id 		= "";
	var bean_name 		= "";
	var form_obj 		= "";
	var tab_frame_name	= "";
	var check_box_value	= "";
 	if(form_name == "placeOrderForm")			//If called on click of the refresh button in Place Order
	{

		bean_id 			= parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.bean_id.value ;
		bean_name 			= parent.parent.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.bean_name.value ;
		form_obj			= form_object.elements;
		tab_frame_name		= parent.parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
	}
	else if(form_name == "orderSetResultForm")  // When called from Addnl.Search
	{
		bean_id 			= parent.parent.document.orderSetResultForm.bean_id.value ;
		bean_name 			= parent.parent.document.orderSetResultForm.bean_name.value ;
		form_obj			= form_object.elements;
		tab_frame_name		= parent.parent.parent.parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
	}
	else  if(form_name == "tickSheetItemsForm")// when called from Tick Sheets
	{
		bean_id 			= parent.parent.parent.criteriaTickSheetsFrame.document.tickSheetItemsForm.bean_id.value ;
		bean_name 			= parent.parent.parent.criteriaTickSheetsFrame.document.tickSheetItemsForm.bean_name.value ;
		form_obj			= parent.parent.parent.criteriaTickSheetsFrame.document.tickSheetItemsForm;
		tab_frame_name		= parent.parent.parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
	}
	else if(form_name=="imagePanelsForm") // When called from the Image frame (Search Button)
	{
		bean_id 			= parent.parent.parent.imageOrderCatalogs.document.imagePanelsForm.bean_id.value ;
		bean_name 			= parent.parent.parent.imageOrderCatalogs.document.imagePanelsForm.bean_name.value ;
		form_obj			= parent.parent.parent.imageOrderCatalogs.document.imagePanelsForm;
	}
	else if(form_name=="image_form") // When called from the Image frame (on click of the radio button front/back)
	{
		bean_id 			= parent.parent.parent.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.bean_id.value ;
		bean_name 			= parent.parent.parent.displayTransaction.imageOrderCatalogs.document.imagePanelsForm.bean_name.value ;
		form_obj			= parent.parent.parent.displayTransaction.imageOrderCatalogs.document.imagePanelsForm;
		tab_frame_name		= parent.parent.parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
	}
	else if(form_name=="careSetButtonForm") // When called from the care sets buttonform
	{
		bean_id 			= parent.parent.parent.criteriaButtonFrame.document.careSetButtonForm.bean_id.value ;
		bean_name 			= parent.parent.parent.criteriaButtonFrame.document.careSetButtonForm.bean_name.value ;
		form_obj			=parent.parent.parent.criteriaButtonFrame.document.careSetButtonForm;
		tab_frame_name		= parent.parent.parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)

	}
var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	HTMLPTextS=catalogs.split("$$");
	for(drs=0;drs<((HTMLPTextS.length)-1);drs++)
	{
		catalog = "ck"+HTMLPTextS[drs];
		if(tab_frame_name!="")
       {
			check_box_value = tab_frame_name.check_box_val  // Get the Global JavaScript variable Stored  (OrderEntryTab.jsp)				
			var count = 0;
			for(dr=0;dr<((check_box_value.length));dr++)
			{
				if(check_box_value[dr]!=catalog)
				{
					catString[count] = check_box_value[dr];
					count ++;				
				}						
			}
			check_box_value = catString;
			tab_frame_name.check_box_val = check_box_value;
	    } // End of if tab_frame_name	
    }

    xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	 // Only on click of the place order tab, send the array to the bean, where it is set
	xmlHttp.open( "POST", "OrderEntryStoreValues.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&check_box_value="+check_box_value, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	return true;
}

/*Added by Uma on 1/12/2010 for IN017231 PMG20089-CRF-0830*/
function closeDuplicateRecord()
{
	//window.returnValue = "N";
	//window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "N";
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}

function insertRecord()
{
	var formObj					= parent.OrderEntryDuplicate.document.duplicateForm;
	var total_dup_records	= formObj.total_dup_catalogs.value;
	var total_dup_patients	= formObj.total_dup_patients.value;
	var patient_count			= formObj.patient_count.value;
	var dupfirstwin=formObj.firstDupWindow.value;//Added for IN062607
	var chk_records_count	= formObj.chk_records_count.value;
	var chk_records_count1	= formObj.chk_records_count.value;//IN062607
	var codeVal					=	"";	
	var patVal						=	"";	
	var arrInd						=	0;
	var patArrInd				= 0;
	var avalCatalogs			= 0;
	var totPat						= 0;	
	var p_dupe_catalog_list		= ""; //IN024984
	for(var i=0;i<total_dup_patients;i++)
	{
		for(var j=0;j<total_dup_records;j++)
		{
			if(eval(parent.OrderEntryDuplicate.document.getElementById("pat"+i).checked==true)&&(eval("formObj.chk"+j).checked))
			{
				if(eval("formObj.patRejectOrder"+i+j).value=="R")
				{
					alert(getMessage("REJECT_ORDERS_EXISTS","OR"));
					return false;				
				}
			}
		}
	}
	if(total_dup_records>0)
	{
		for(var i=0;i<total_dup_records;i++)
		{
			if(eval("formObj.chk"+i))
			{
				if(!eval("formObj.chk"+i).checked)
				{
					HTMLTextS[arrInd++]=eval("formObj.hd"+i).value;
					codeVal=codeVal+eval("formObj.hd"+i).value+"$$";
					chk_records_count--;
				}
				else {
					p_dupe_catalog_list = p_dupe_catalog_list+eval("formObj.chk"+i).value+"#"+eval("formObj.mand"+i).value+"#";
				}
			}
		}
	}
	formObj.chk_records_count.value = chk_records_count;
	for(var i=0;i<total_dup_patients;i++)
	{
		if(eval(parent.OrderEntryDuplicate.document.getElementById("pat"+i).checked!=true))
		{
			HTMLPatTextS[patArrInd++]=eval("formObj.pat_id"+i).value;
			patVal=patVal+eval("formObj.pat_id"+i).value+"!~!";
		}
	}
	if(HTMLPatTextS.length>0)
	{
		var bean_id 				= formObj.bean_id.value;
		var bean_name 			= formObj.bean_name.value;
		var patientString 			= patVal;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr					= "<root><SEARCH " ;
		xmlStr 					+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=UNLOAD_PATIENTS"+"&patientString="+patientString, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
	avalCatalogs = formObj.chk_records_count.value;
	totPat			= formObj.patient_count.value;
	if(HTMLTextS.length>0)
	{
		//window.returnValue = codeVal+"##"+avalCatalogs+"##"+totPat;
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = codeVal+"##"+avalCatalogs+"##"+totPat;
	}
	else 
	{
		//window.returnValue="P"+"##"+avalCatalogs+"##"+totPat;;
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = codeVal+"##"+avalCatalogs+"##"+totPat;
	}
	
	// IN024984 - Start
	var dup_override_reason = formObj.dup_override_reason.value;
	
	var p_bean_id   =  formObj.bean_id.value;
	var p_bean_name =  formObj.bean_name.value;
	//var p_dupe_catalog_list = formObj.dupe_catalogcode_list.value;
//	var result = manipulateOverrideHashMap(dup_override_reason, p_dupe_catalog_list, p_bean_id, p_bean_name);//Commented for IN062607
	var result = manipulateOverrideHashMap(dup_override_reason, p_dupe_catalog_list,dupfirstwin, p_bean_id, p_bean_name);//Modified for IN062607
	// IN024984 - End

	if(result == true) {// IN024984 	
		//window.close();
		 
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();}  
	else{
		alert(getMessage("DUP_REASON_REQD","OR"));
		formObj.chk_records_count.value = chk_records_count1;//IN062607
	}
	
	
}

function continuePatSize(patSize)
{
	parent.OrderEntryDuplicate.document.duplicateForm.patient_count.value = patSize;
}

function validateCatalogs(obj)
{
	if(!obj.checked)
	{
		var mess = confirm(getMessage("CATALOGS_NOT_AVAIL_TO_PROCEED","OR"));
		if(mess)
		{
			obj.checked = false;
		}
		else
		{
			obj.checked = true;
		}
	}
}

function validatePatients(obj)
{
	if(!obj.checked)
	{
		var mess = confirm(getMessage("PATIENT_NOT_AVAIL_TO_PROCEED","OR"));
		if(mess)
		{
			obj.checked = false;
		}
		else
		{
			obj.checked = true;
		}
	}
}
/*Ends Here*/
/*Added by Uma on 2/12/2010 for IN019033*/
async function countCategory(formObj)
{
	var bean_id 		= formObj.bean_id.value;
	var bean_name 		= formObj.bean_name.value;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr					= "<root><SEARCH " ;
	xmlStr 					+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&func_mode=NEXT_CATEGORY", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	await eval(responseText);
}

function categoryCount(categoryCount)
{
	var formObj = parent.placeOrderDetailFrame.document.placeOrderForm;
	var frameObj = parent.placeOrderDetailFrame;
	var catCount = 0;
	catCount = categoryCount;
	if(catCount==0)
	{
		/*Added by Uma on 3/1/2010 for IN019657*/
		if(frameObj.document.getElementById('called_from.value') == "DIS_ADVICE")
		{
			modalWindowClose(message);
		}
		else if((frameObj.document.getElementById('function_from').value)=="MULTI_PATIENT_ORDERS")
		{
		
			var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
			var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
			var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
			querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
			top.content.workAreaFrame.location.href="../../eOR/jsp/MultiPatientOrders.jsp?"+querystring;
		}
		else if((frameObj.document.getElementById('function_from').value)=="MO")
		{ 
			//window.close();
			 
		    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();  
		}
		else
		{
			/*Ends Here for IN019657*/
			if(parent.parent.parent.parent.parent)
			{
				qry_string		 = parent.parent.parent.parent.parent.location.href;
				if(qry_string!=null)
				{
					if(qry_string.indexOf("&encounter_id=null") != -1)
					{
					}
					else
					{
						if(qry_string.indexOf("&patient_class=XT") != -1)
						{
							if(top.content)
							{
								top.content.workAreaFrame.location.href="../../eOR/jsp/ExternalOrdersFrameset.jsp?"+qry_string;
							}
							else
							{
								modalWindowClose(message);
							}
						}
						else
						{
						//Modified by Ambiga.M for 19623 (below line commented and next if block added)
						//parent.parent.parent.parent.parent.location.href = "../../eOR/jsp/EnterOrder.jsp?"+qry_string;
							if(parent.parent.parent.parent.parent)
							{
								if(parent.parent.parent.parent.parent.orderMainTab)
								{
									//if(parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.all.existingOrders)
									if(parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.existingOrders)
									{
										//parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.all.existingOrders.className  = "CASECONDSELECTHORZ";
										parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.existingOrders.className  = "CASECONDSELECTHORZ";
									}
									//if(parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.all.newOrders)
									if(parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.newOrders)	
									{
										//parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.all.newOrders.className		= "CAFIRSTSELECTHORZ";
										parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.newOrders.className		= "CAFIRSTSELECTHORZ";
									}
									var querystring=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.params.value;
									var called_from=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.called_from.value;
									var licence_key=parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.licence_key.value;
									querystring=querystring+"&called_from="+called_from+"&licence_key="+licence_key;
									parent.parent.parent.parent.location.href = "../../eOR/jsp/ExistingOrder.jsp?"+querystring;
									//parent.parent.parent.parent.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+querystring;*/
								}
							}
						}
					}
				}
			}
		}//Added for IN019657
	}
	else
	{
		if(parent.parent.criteriaCategoryButtonFrame)
		{
			parent.parent.criteriaCategoryButtonFrame.location.href =  parent.parent.criteriaCategoryButtonFrame.location.href;
		}
		//onSuccess();
	}
}
/*Ends Here Uma*/

//IN038787 Start
function checkFrameMembersTickSheet(orderSetVal, panelVal, individualVal)
{	
	var formobj = parent.document.getElementById("sectionFrame");
	
	if(formobj!=null)
	{
		if (individualVal == '' && orderSetVal == '' && panelVal != '')
		{
			formobj.rows="0%,100%,0%";
		}
		else if (individualVal == '' && orderSetVal != '' && panelVal == '')
		{
			formobj.rows="100%,0%,0%";
		}
		else if (individualVal != '' && orderSetVal == '' && panelVal == '')
		{
			formobj.rows="0%,0%,100%";
		}
		else if (individualVal == '' && orderSetVal != '' && panelVal != '')
		{
			formobj.rows="50%,50%,0%";
		}
		else if (individualVal != '' && orderSetVal == '' && panelVal != '')
		{
			formobj.rows="0%,50%,50%";
		}
		else if (individualVal != '' && orderSetVal != '' && panelVal == '')
		{
			formobj.rows="50%,0%,50%";
		}
	}
	if (individualVal == '' && orderSetVal == '' && panelVal == '')
	{
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
	}	
	
}
function tickSheetOnChanges()
{
	if(parent.criteriaTickSheetsFrame.resultHdrFrame!=undefined)
	storeValues(parent.criteriaTickSheetsFrame.resultHdrFrame.document.tickSheetItemsForm,"tickSheetItemsForm");  // Calling the dynamic jsp to set the values in the bean
	if(parent.criteriaTickSheetsFrame.resultListFrame!=undefined)
	storeValues(parent.criteriaTickSheetsFrame.resultListFrame.document.tickSheetItemsForm,"tickSheetItemsForm");  // Calling the dynamic jsp to set the values in the bean
	if(parent.criteriaTickSheetsFrame.resultDtlFrame!=undefined)
	storeValues(parent.criteriaTickSheetsFrame.resultDtlFrame.document.tickSheetItemsForm,"tickSheetItemsForm");  // Calling the dynamic jsp to set the values in the bean
}
//IN038787 End.

//BS_INTN0001 - This below function has been moved from OrderEntryByPractitioner.jsp 
async function callPractitioner(p_patientClass, p_requestString, p_bean_id, p_bean_name, p_pharmacy_scope)
{   // To call the Modal Window conditionally and to pass the query string to the main files	
	var retVal = 	new String();
	var dialogHeight= "43vh" ;
	var dialogWidth	= "48vw" ;
	var dialogTop	= "-125px" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await top.window.showModalDialog("../../eOR/jsp/OrderEntrySearchPractMain.jsp?"+p_requestString+"&bean_id="+p_bean_id+"&bean_name="+p_bean_name+"&patient_class="+p_patientClass,arguments,features);
	
	if(retVal != null)
	{
		val = retVal.split("~");
		
		if(val[0]=="ok")
		{
			//mainFrame.location.href="../../eOR/jsp/OrderEntryMain.jsp?<%=request.getQueryString()%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>&pract_id="+val[1]+"&pract_name="+val[2]+"&order_mode="+val[3]+"&pharmacy_scope=<%=pharmacy_scope%>";//IN039001
			mainFrame.location.href="../../eOR/jsp/OrderEntryMain.jsp?"+p_requestString+"&pract_name="+encodeURIComponent(val[2],'UTF-8')+"&bean_id="+p_bean_id+"&bean_name="+p_bean_name+"&pract_id="+val[1]+"&order_mode="+val[3]+"&pharmacy_scope="+p_pharmacy_scope;//IN039001
		}
	}
}
// IN024984 - Start
async function addDupeCodeReason(p_catalog_code, p_bean_id, p_bean_name, p_catalog_desc)
{	
	p_catalog_desc = encodeURIComponent(p_catalog_desc,"UTF-8")
	var dialogHeight	= "43vh" ;
	var dialogWidth	= "34vw" ;
	var status = "no";
	var scroll = "yes";
	var dialogTop = "140";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll+";";	
	var urlTxt = "../../eOR/jsp/DuplicateOrderRemarksDialog.jsp?p_catalog_code="+p_catalog_code+"&p_catalog_desc="+p_catalog_desc+"&bean_id="+p_bean_id+"&bean_name="+p_bean_name;// IN047605
	retVal 			= await window.showModalDialog(urlTxt,arguments,features); // IN047605
	//retVal 			= window.showModalDialog("../../eOR/jsp/DuplicateOrderRemarksDialog.jsp?p_catalog_code="+p_catalog_code+"&p_catalog_desc="+p_catalog_desc+"&bean_id="+p_bean_id+"&bean_name="+p_bean_name,arguments,features); // IN047605
}
function doRemarksClose(p_catalog_code, p_bean_id, p_bean_name){
	var p_dupe_override_remarks = document.getElementById("indi_dup_override_remarks").value; 
	
	if(trimCheck(p_dupe_override_remarks)=="") // added for IN047867
		p_dupe_override_remarks = ""; // added for IN047867
	
	p_dupe_override_remarks = escape(p_dupe_override_remarks); // IN047605
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " p_bean_id=\""+p_bean_id+ "\" ";
	xmlStr += " p_bean_name=\""+p_bean_name+ "\" ";
	xmlStr += " p_action=\"DUPLICATE_ORDER_REASON\"";  
	xmlStr += " p_catalog_code=\""+p_catalog_code+ "\" ";
	xmlStr += " p_dupe_override_remarks=\""+p_dupe_override_remarks+ "\" ";
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "OrderLineIntermediate.jsp", false );
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//window.close();
	 
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}
//function manipulateOverrideHashMap(p_dupe_common_remarks, p_dupe_catalog_list, p_bean_id, p_bean_name) {//Commented for IN062607
function manipulateOverrideHashMap(p_dupe_common_remarks, p_dupe_catalog_list,fdupwin, p_bean_id, p_bean_name) {//Modified for IN062607
	if(trimCheck(p_dupe_common_remarks)=="") // added for IN047867
		p_dupe_common_remarks = ""; // added for IN047867
	
	p_dupe_common_remarks = escape(p_dupe_common_remarks); //IN047605
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " p_bean_id=\""+p_bean_id+ "\" ";
	xmlStr += " p_bean_name=\""+p_bean_name+ "\" ";
	xmlStr += " p_action=\"DUPLICATE_REASON_VALIDATION\"";  
	xmlStr += " p_dupe_common_remarks=\""+p_dupe_common_remarks+ "\" ";
	xmlStr += " p_dupe_catalog_list=\""+p_dupe_catalog_list+ "\" ";
	xmlStr += " p_fdupwin=\""+fdupwin+ "\" ";//IN062607
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "OrderLineIntermediate.jsp", false );
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	if(eval(responseText) == false)
	{
		return false;
	}	
	else 
		return true;
	
}
function enableDupeReason(p_index){
	// added for IN047644 - Start
	var p_dupe_reject_count = "0";
	var p_total_dup_catalogs = "0";
	var p_total_checked = "0";
	p_dupe_reject_count = document.getElementById("dupe_reject_count").value;
	p_total_dup_catalogs = document.getElementById("total_dupl_count_records").value;
	// added for IN047644 - End
	if(document.getElementById("chk"+p_index).checked == true) {
		document.getElementById("order_dupe_reason"+p_index).style.display = 'none';
		dupeCounter++; //IN047644
		p_total_checked = parseInt(p_dupe_reject_count) + parseInt(dupeCounter); //IN047644
		showDupeReasonText(p_total_dup_catalogs, p_total_checked); //IN047644
	}
	else {
		document.getElementById("order_dupe_reason"+p_index).style.display = 'inline';
		dupeCounter--; //IN047644
		p_total_checked = p_dupe_reject_count + dupeCounter;//IN047644
		showDupeReasonText(p_total_dup_catalogs, p_total_checked);//IN047644
	}
}
function validatedHashMap()
{
	return false;
}
// added for IN047632 - Start
function showDupeReasonText(p_total_recs, p_rejected_recs)
{
	if(p_total_recs != p_rejected_recs) 
	{
		document.getElementById("dupe_reason_header_title").style.display = 'inline';
		document.getElementById("dupe_reason_header_text").style.display = 'inline';
	}
	else 
	{
		document.getElementById("dupe_reason_header_title").style.display = 'none';
		document.getElementById("dupe_reason_header_text").style.display = 'none';
	}
}
//added for IN047632 - End
//IN047686 - Start
function enableMultiDupeReason(p_index){
	
	var p_dupe_reject_count = "0";
	var p_total_dup_catalogs = "0";
	var p_total_checked = "0";
	
	p_total_dup_catalogs = document.getElementById("multi_pat_catalog_count").value;
	
	if(document.getElementById("chk"+p_index).checked == true) {
		document.getElementById("order_dupe_reason"+p_index).style.display="inline";
		document.getElementById("dup_mand"+p_index).style.display="inline";
		dupeCounter--;
		showDupeReasonText(p_total_dup_catalogs, dupeCounter);//IN047644
		
	}
	else {
		document.getElementById("order_dupe_reason"+p_index).style.display="none";
		document.getElementById("dup_mand"+p_index).style.display="none";
		dupeCounter++;
		showDupeReasonText(p_total_dup_catalogs, dupeCounter);//IN047644
	}
}
//IN047686 - End
// IN024984 - End
//IN041644 Starts
function checkOverruleAuthor(formObj,headerObj,index)
{
	
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var order_catalog_code = "";
	var order_date_time = "";	
	var retVal = false;
	
	if(eval("formObj.order_catalog_code"+index)!=null || eval("formObj.order_catalog_code"+index)!=undefined)
	{
		order_catalog_code = eval("formObj.order_catalog_code"+index).value;
	}
	else if(eval("formObj.catalog_code"+index)!=null || eval("formObj.catalog_code"+index)!=undefined)//Fix for Order Set With authorisation not working.
	{
		order_catalog_code = eval("formObj.catalog_code"+index).value;
	}
 	order_date_time =  eval("formObj.start_date_time"+index).value;
 	xmlStr ="<root><SEARCH " ;	
	xmlStr += " patient_id=\""+formObj.patient_id.value+ "\" ";
	xmlStr += " order_catalog_code=\""+order_catalog_code+ "\" ";
	xmlStr += " order_date_time=\""+order_date_time+ "\" ";
	xmlStr += " ordering_practitioner=\""+formObj.ordering_practitioner.value+ "\" ";
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AuthorisationOverruleValidate.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	retVal = xmlHttp.responseText;
	
	if(trimString(retVal)== "Y")
	{
		eval(parent.placeOrderDetailFrame.document.getElementById("authorised_yn"+index)).value="Y";
		formObj.authorized.value		= "true";//IN048065
	}
	else//IN048065 Starts
	{
		eval(parent.placeOrderDetailFrame.document.getElementById("authorised_yn"+index)).value="N";
		formObj.authorized.value		= "false";
	}//IN048065 Ends
}
//IN041644 Ends

//IN064543 Start
async function showEditor(obj,catalog_code,order_catalog_nature,category,bean_id,bean_name,measure_id,prep_instrn_content_type,catalog_desc){
	if(obj.checked){
		var finalString 	= "&catalog_code="+catalog_code+"&order_catalog_nature="+order_catalog_nature+"&category="+category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&measure_id="+measure_id+"&prep_instrn_content_type="+prep_instrn_content_type+"&catalog_desc="+catalog_desc;
		var retVal 			= new String();
		var dialogHeight 	= "73vh" ;
		var dialogWidth  	= "43vw" ;
		var dialogTop    	= "300";
	    var status 			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=no; status:no";
		retVal				= await top.window.showModalDialog("../../eOR/jsp/OrderEntryInstruction.jsp?"+finalString,arguments,features);
	}	
}
function sendKey(key,queryString){
	parent.InstrnFrame.document.location.href = "../jsp/OrderEntryInstruction.jsp?"+queryString+"&key="+key;
}
function sendKeyForEditor(id){
	if(id=="PR"){
		 var pr ;
		 var dr ;
		 var is;
		 var textVal;
		 if(document.getElementById("PR") != undefined){
			 pr=document.getElementById("PR");
			 pr.style.display = "block";
		 }
		 if(document.getElementById("DR") != undefined){
			 dr=document.getElementById("DR");
			 dr.style.display = "none";
		 }
		 if(document.getElementById("IM") != undefined){
			 is=document.getElementById("IM");
			 is.style.display = "none";
		}
		 else if(document.getElementById("IS") != undefined){
			 is=document.getElementById("IS");
			 is.style.display = "none";
		 }
		 if(document.getElementById("ageSexInstrnFrame") != undefined){
			 document.getElementById("ageSexInstrnFrame").height="0";
			 document.getElementById("ageSexInstrnFrame").src = "../../eCommon/html/blank.html";
		 }
	}else if(id=="DR"){
		 var pr ;
		 var dr ;
		 var is;
		 var textVal;
		 if(document.getElementById("PR") != undefined){
			 pr=document.getElementById("PR");
			 pr.style.display = "none";
		 }
		 if(document.getElementById("DR") != undefined){
			 dr=document.getElementById("DR");
			 dr.style.display = "block";
		 }
		 if(document.getElementById("IM") != undefined){
			 is=document.getElementById("IM");
			 is.style.display = "none";
		}
		 else if(document.getElementById("IS") != undefined){
			 is=document.getElementById("IS");
			 is.style.display = "none";
		 }
		 if(document.getElementById("ageSexInstrnFrame") != undefined){
			 document.getElementById("ageSexInstrnFrame").height="0";
			 document.getElementById("ageSexInstrnFrame").src = "../../eCommon/html/blank.html";
		 }
	}else if(id=="IS"){
		 var pr ;
		 var dr ;
		 var is;
		 var textVal;
     var isTab;
		 var prTab;
		 var drTab;
		 if(document.getElementById("PR") != undefined){
			 pr=document.getElementById("PR");
			 pr.style.display = "none";
		 }
		 if(document.getElementById("DR") != undefined){
			 dr=document.getElementById("DR");
			 dr.style.display = "none";
		 }
		 if(document.getElementById("IM") != undefined){
			 is=document.getElementById("IM");
			 is.style.display = "block";
		}
		 else if(document.getElementById("IS") != undefined){
			 is=document.getElementById("IS");
			 is.style.display = "block";
		 }
		 if(document.getElementById("ageSexInstrnFrame") != undefined){
			 document.getElementById("ageSexInstrnFrame").height="425";
			 document.getElementById("ageSexInstrnFrame").src = "../../eCommon/html/blank.html";
		 }
	}
}

function displayToolTipForInstructions(obj,measure_id,contr_msr_panel_id,order_catalog_nature,category,bean_id,bean_name,catalog_code,i,form_name,pract_type,frame_name){
	if(obj.checked){
		    if(form_name == "recentlyAccessedForm_practitioner") // Recently Accessed Practitioner Frame 
			       form_name = "criteriaMainFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm";
			else if(form_name == "recentlyAccessedForm_patient") // Recently Accessed Patient Frame  
			       form_name = "criteriaDetailFrame.criteriaDetailResultsFrame.document.recentlyAccessedForm";
		    else if(form_name == "orderSetResultForm")
			  form_name = "document.orderSetResultForm";
			else if(form_name == "tickSheetItemsForm"){
				if(frame_name == "resultHdrFrame" ){
					form_name = "parent.criteriaTickSheetsFrame.resultHdrFrame.document.tickSheetItemsForm";
				}else if(frame_name == "resultListFrame" ){
					form_name = "parent.criteriaTickSheetsFrame.resultListFrame.document.tickSheetItemsForm";
				}else if(frame_name == "resultDtlFrame" ){
					form_name = "parent.criteriaTickSheetsFrame.resultDtlFrame.document.tickSheetItemsForm";
				}
			}else if(form_name == "imagePanelsForm")
		    form_name = "DetailFrame.displayTransaction.imageOrderCatalogs.document.imagePanelsForm";
		 	var catalog_desc	= eval(form_name+".catalog_desc"+catalog_code+i+".value");
			var encounter_id	= "",patient_class="",admission_date="",discharge_date_time="";
			form_name = eval(form_name);
			if(form_name.encounter_id){
				encounter_id = form_name.encounter_id.value;
				patient_class = form_name.patient_class.value;
				admission_date = form_name.admission_date.value;
				discharge_date_time = form_name.discharge_date_time.value;
			}
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr += " action=\"VALIDATE_FOR_WINDOW_INVOKE\" " ;
			xmlStr += " measure_id=\""+ measure_id +"\" " ;
			xmlStr += " contr_msr_panel_id=\""+ contr_msr_panel_id + "\" ";
			xmlStr += " order_catalog_nature=\""+ order_catalog_nature + "\" ";
			xmlStr += " category=\""+ category + "\" ";
			xmlStr += " bean_id=\""+ bean_id + "\" ";
			xmlStr += " bean_name=\""+ bean_name + "\" ";
			xmlStr += " catalog_code=\""+ catalog_code + "\" ";
			xmlStr += " catalog_desc=\""+ catalog_desc + "\" ";
			xmlStr += " encounter_id=\""+ encounter_id + "\" ";
			xmlStr += " patient_class=\""+ patient_class + "\" ";
			xmlStr += " admission_date=\""+ admission_date + "\" ";
			xmlStr += " discharge_date_time=\""+ discharge_date_time + "\" ";
			xmlStr += " pract_type=\""+ pract_type + "\" ";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "IntermediateForInstructions.jsp",false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
	}
async function openInstructionModal(count,measure_id,contr_msr_panel_id,order_catalog_nature,category,bean_id,bean_name,catalog_desc,encounter_id,patient_class,admission_date,discharge_date_time,catalog_code,pract_type){
		var finalString 	= "count="+count +"&measure_id="+measure_id +"&contr_msr_panel_id="+contr_msr_panel_id+"&order_catalog_nature="+order_catalog_nature+"&category="+category+"&bean_id="+bean_id+"&bean_name="+bean_name+"&catalog_desc="+encodeURIComponent(catalog_desc)+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&admission_date="+admission_date+"&discharge_date_time="+discharge_date_time+"&catalog_code="+catalog_code+"&pract_type="+pract_type+"&Instrn_flag=Y";
	 	var retVal 			= new String();
		var dialogHeight 	= "900px" ;
		var dialogWidth  	= "800px" ;
		var dialogTop    	= "300";
	    var status 			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=no; status:no";
	if(count>0){
		retVal = await window.showModalDialog("../../eOR/jsp/OrderEntryToolTipFrameSet.jsp?"+finalString,arguments,features);
	}
}
function showMultIns(index,catalogCode,key){
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"INVOKE_MULTIPLE_INSTRN\" " ;
	xmlStr += " index=\""+ index +"\" " ;
	xmlStr += " catalogCode=\""+ catalogCode +"\" " ;
	xmlStr += " key=\""+ key +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IntermediateForInstructions.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function change_common_tab(obj)
{ 
	var colorFlag = "";
	if(obj=="PRTAB")
	{
		colorFlag = "PRTAB"
		colorChange(colorFlag,obj);
	}
	else if(obj=="DRTAB")
	{
		colorFlag = "DRTAB"
		colorChange(colorFlag,obj);
	}
	else if(obj=="ISTAB")
	{
		colorFlag = "ISTAB"
		colorChange(colorFlag,obj);
	}
}

function colorChange(colorFlag,obj) 
{
	if(colorFlag=="PRTAB"){
		document.getElementById('PRTAB').className    = "CASECONDSELECTHORZ";
		document.getElementById('DRTAB').className	   = "CAFIRSTSELECTHORZ";
		document.getElementById('ISTAB').className	   = "CAFIRSTSELECTHORZ";
		obj.className
	}
	if(colorFlag=="DRTAB"){
		document.getElementById('DRTAB').className		= "CASECONDSELECTHORZ";
		document.getElementById('PRTAB').className		= "CAFIRSTSELECTHORZ";
		document.getElementById('ISTAB').className		= "CAFIRSTSELECTHORZ"
	}
	if(colorFlag=="ISTAB"){
		document.getElementById('ISTAB').className		= "CASECONDSELECTHORZ";
		document.getElementById('PRTAB').className 	= "CAFIRSTSELECTHORZ";
		document.getElementById('DRTAB').className		= "CAFIRSTSELECTHORZ"
	}
	currClass ="CASECONDSELECTHORZ";
}
/*function callOnMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'CASECONDSELECTHORZ';
}
function callOnMouseOut(obj){
	obj.className = currClass
}*/
//IN064543 end
var currVal;
function toggleTabColor(cnt){
	var total =document.getElementById("totalCount").value;
	for(var i=0; i<parseInt(total); i++){
			if(parseInt(i)==parseInt(cnt)){			
			eval("document.getElementById('cat"+i+"')").className = "CASECONDSELECTHORZ";
		}else{
			eval("document.getElementById('cat"+i+"')").className = "CAFIRSTSELECTHORZ";
		}
	}
	currVal = "CASECONDSELECTHORZ";
}
function toggleTabColorForPanel(cnt){
	var total =document.getElementById("totalCount").value;
	for(var i=0; i<parseInt(total); i++){
			if(parseInt(i)==parseInt(cnt)){			
			eval("document.getElementById('catPanel"+i+"')").className = "CASECONDSELECTHORZ";
		}else{
			eval("document.getElementById('catPanel"+i+"')").className = "CAFIRSTSELECTHORZ";
		}
	}
	currVal = "CASECONDSELECTHORZ";
}
function leftpaneMouseOver(obj){
	currVal = obj.className;
	obj.className = 'CASECONDSELECTHORZ'
}
function leftpaneMouseOut(obj){
	obj.className = currVal
}
function loadValueInIntermediate(index,key,catalogCode){
	var finalString =  "index="+index +"&key="+key+"&catalogCode="+catalogCode;
	document.getElementById("ageSexInstrnFrame").height="420";
	document.getElementById("ageSexInstrnFrame").src = "../../eOR/jsp/OrderEntryAgeSexInstrnViewFrame.jsp?"+finalString;
}
//IN069027 starts
function allowNewOrders(obj,called_from){
	if(obj.value!=""){
		var dxChkBfrPlaceOrderYN="";
		if("imageSearchForm"==called_from)
			dxChkBfrPlaceOrderYN = eval("parent.parent.parent.parent.parent.orderMainTab.document.OrCommonForm.dxChkBfrPlaceOrder"+obj.value).value
		else
			dxChkBfrPlaceOrderYN =eval("parent.parent.parent.parent.orderMainTab.document.OrCommonForm.dxChkBfrPlaceOrder"+obj.value).value;
		if("N"==dxChkBfrPlaceOrderYN){
			alert(getMessage("DIAG_NOT_RECORDED","OR"));
			//alert('Patient Diagnosis not recorded, please complete to proceed further.');
			obj.value="";
		}
		//44884 Start.
		var practitionerRel="N";
		var restOrdersSelf="N";
		var restOrdersFamily="N";
		if("imageSearchForm"==called_from){
			practitionerRel = parent.parent.parent.tabFrame.document.formTab.practitionerRel.value;
			restOrdersSelf=parent.parent.parent.tabFrame.document.getElementById('restBfrPlaceOrderS'+obj.value).value;
			restOrdersFamily=parent.parent.parent.tabFrame.document.getElementById('restBfrPlaceOrderF'+obj.value).value;
		}else{
			practitionerRel =parent.parent.tabFrame.document.getElementById('practitionerRel').value;
			restOrdersSelf=parent.parent.tabFrame.document.getElementById('restBfrPlaceOrderS'+obj.value).value;
			restOrdersFamily=parent.parent.tabFrame.document.getElementById('restBfrPlaceOrderF'+obj.value).value;
		}
		if("N"!=practitionerRel){
			if("S"==practitionerRel && "Y"==restOrdersSelf ){
				if("PH"==obj.value)
					alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
				else
					alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
				obj.value="";
			}
			if("F"==practitionerRel && "Y"==restOrdersFamily ){
				if("PH"==obj.value)
					alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
				else
					alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
				obj.value="";
			}
		}
		//44884 End.
	}
	clearvalues(called_from);
	if("addlSearchCriteriaForm"==called_from)
		populateOrderType(obj);
	else if("tickSheetForm"==called_from)
		populateOrder(obj);
	else if("careSetSearchForm"==called_from)
		populateOrderTypeCareSet(obj);
	else if("imageSearchForm"==called_from)
		populateImageOrderType(obj);
			
}
function checkDiagnosis(orderCategory,obj){
	var dxChkBfrPlaceOrderYN = eval("parent.parent.parent.parent.parent.orderMainTab.document.OrCommonForm.dxChkBfrPlaceOrder"+orderCategory).value;
	if("N"==dxChkBfrPlaceOrderYN){
		alert(getMessage("DIAG_NOT_RECORDED","OR"));
			//alert('Patient Diagnosis not recorded, please complete to proceed further.');
			obj.checked=false;
			return false;
	}	
	//44884 Start.
	var practitionerRel="N";
	var restOrdersSelf="N";
	var restOrdersFamily="N";
	
	practitionerRel = parent.parent.parent.tabFrame.document.formTab.practitionerRel.value;
	restOrdersSelf=eval("parent.parent.parent.tabFrame.document.formTab.restBfrPlaceOrderS"+orderCategory).value;
	restOrdersFamily=eval("parent.parent.parent.tabFrame.document.formTab.restBfrPlaceOrderF"+orderCategory).value;
	
	if("N"!=practitionerRel){
		if("S"==practitionerRel && "Y"==restOrdersSelf ){
			if("PH"==orderCategory)
				alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
			else
				alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
			obj.checked=false;
		return false;
		}
		if("F"==practitionerRel && "Y"==restOrdersFamily ){
			if("PH"==orderCategory)
				alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
			else
				alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
			obj.checked=false;
			return false;
		}
	}
	//44884 End.
	
}
function checkOrderSet(obj){
	
	var record=obj.value.split("::")
	orderCategory=record[1].replace(/^\s+|\s+$/gm,'');
	var dxChkBfrPlaceOrderYN = eval("parent.parent.parent.parent.orderMainTab.document.OrCommonForm.dxChkBfrPlaceOrder"+orderCategory).value;
	if("N"==dxChkBfrPlaceOrderYN){
			alert(getMessage("DIAG_NOT_RECORDED","OR"));
			//alert('Patient Diagnosis not recorded, please complete to proceed further.');	
			obj.value="";	
			return false;
	}else{
		//44884 Start.
		var practitionerRel="N";
		var restOrdersSelf="N";
		var restOrdersFamily="N";
		
		practitionerRel = parent.parent.tabFrame.document.formTab.practitionerRel.value;
		restOrdersSelf=eval("parent.parent.tabFrame.document.formTab.restBfrPlaceOrderS"+orderCategory).value;
		restOrdersFamily=eval("parent.parent.tabFrame.document.formTab.restBfrPlaceOrderF"+orderCategory).value;
		
		if("N"!=practitionerRel){
			if("S"==practitionerRel && "Y"==restOrdersSelf ){
				if("PH"==orderCategory){
					alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
				}else{
					alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
				}	
				obj.value="";
			return false;
			}
			if("F"==practitionerRel && "Y"==restOrdersFamily ){
				if("PH"==orderCategory){
					alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
				}else{
					alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
				}	
				obj.value="";
				return false;
			}
		}else{
			//44884 End.
			getCareSetValue(obj);careSetSearch();//Exisiting onChange method
		}
	}	
}
function checkPharmacy(obj){
		change_tab('PlaceOrder');
		display(obj);//Existing methods	
}
//IN069027 ends
//IN068314 Starts
function displaycolorfpp(index)
{
	if(eval(document.getElementById("billing"+index))&&eval(document.getElementById("billing"+index)).style!=undefined ){
		//IN073455 Starts
		if(eval(document.getElementById("ord_consent_reqd_yn"+index)) && eval(document.getElementById("ord_consent_reqd_yn"+index))!=undefined &&eval(document.getElementById("ord_consent_reqd_yn"+index)).value=='Y'){
			eval(document.getElementById("billing"+index)).style.background='#FFDAB9';
		}
		else if (eval(document.getElementById("amend_ord_consent_reqd_yn"+index)) && eval(document.getElementById("amend_ord_consent_reqd_yn"+index)) != undefined && eval(document.getElementById("amend_ord_consent_reqd_yn"+index)).value=='Y' ){
			eval(document.getElementById("billing"+index)).style.background='#FFDAB9';
		}
		else{
			eval(document.getElementById("billing"+index)).style.background='';
		}		//IN073455 Ends
		
	
	}//Commented for IN072721//Uncommented for IN073455 
	if(eval(document.getElementById("billing1"+index))&&eval(document.getElementById("billing1"+index)).style!=undefined){
	eval(document.getElementById("billing1"+index)).style.background='';}
	if(eval(document.getElementById("billing2"+index))&&eval(document.getElementById("billing2"+index)).style!=undefined){
	eval(document.getElementById("billing2"+index)).style.background='';}
	if(eval(document.getElementById("billing3"+index))&&eval(document.getElementById("billing3"+index)).style!=undefined)
	{
		eval(document.getElementById("billing3"+index)).style.background='';
	}
	if(eval(document.getElementById("priority_id"+index))&&eval(document.getElementById("priority_id"+index)).style!=undefined){
	eval(document.getElementById("priority_id"+index)).style.background='';}
	if(eval(document.getElementById("billing4"+index))&&eval(document.getElementById("billing4"+index)).style!=undefined){
	eval(document.getElementById("billing4"+index)).style.background='';}
	if(eval(document.getElementById("billing5"+index))&&eval(document.getElementById("billing5"+index)).style!=undefined){
	eval(document.getElementById("billing5"+index)).style.background='';}
	if(document.getElementById("frequency_id"+index)&& document.getElementById("frequency_id"+index).style!=undefined){
	document.getElementById("frequency_id"+index).style.background='';}
	if(eval(document.getElementById("billing6"+index))&&eval(document.getElementById("billing6"+index)).style!=undefined){
	eval(document.getElementById("billing6"+index)).style.background='';}
	if(document.getElementById('duration_code_id'+index)&& document.getElementById('duration_code_id'+index).style!=undefined){
	document.getElementById("duration_code_id"+index).style.background='';}
	if(eval(document.getElementById("billing7"+index))&&eval(document.getElementById("billing7"+index)).style!=undefined){
	eval(document.getElementById("billing7"+index)).style.background='';}
	if(document.getElementById('billing9'+index)&&document.getElementById('billing9'+index).style!=undefined){
	document.getElementById('billing9'+index).style.background='';}
	if(eval(document.getElementById("billing10"+index))&&eval(document.getElementById("billing10"+index)).style!=undefined){
	eval(document.getElementById("billing10"+index)).style.background='';}
	if(eval(document.getElementById("billing11"+index))&&eval(document.getElementById("billing11"+index)).style!=undefined){
	eval(document.getElementById("billing11"+index)).style.background='';}
	if(eval(document.getElementById("billing12"+index))&&eval(document.getElementById("billing12"+index)).style!=undefined){
	eval(document.getElementById("billing12"+index)).style.background='';}
	if(eval(document.getElementById("order"+index))&&eval(document.getElementById("order"+index)).style!=undefined){
		

		eval(document.getElementById("order"+index)).style.background='';
		
	}
	if(document.getElementById('order2'+index)&&document.getElementById('order2'+index).style!=undefined){//IN073309 Starts
		
			document.getElementById('order2'+index).style.background='';
	}//IN073309 ENDS
	if(eval(document.getElementById("schedule"+index))&&eval(document.getElementById("schedule"+index)).style!=undefined){
	eval(document.getElementById("schedule"+index)).style.background='';}
	if(document.getElementById('order1'+index)&&document.getElementById('order1'+index).style!=undefined){
	document.getElementById('order1'+index).style.background='';}
	if(document.getElementById('performing_dept_loc_code_id'+index)&&document.getElementById('performing_dept_loc_code_id'+index).style!=undefined){
	document.getElementById('performing_dept_loc_code_id'+index).style.background='';}
}
//IN068314 Ends

