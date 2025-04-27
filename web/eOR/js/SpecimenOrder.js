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
16/02/2012	  IN031200		 Menaka V	 Leap Year-Manage Specimens, System throws warning message and unable to
										 proceed. 
03/02/2012	  IN:030168	  	 VIJAY R	introduced new filter parameter 'ordering practitiner' in manage specimens page, search functionality.		 
12/7/2012	  IN33889	  	 DineshT	Modified the selectAll functionality to add the records to the bean	
12/7/2012	  IN33979	  	 DineshT	Increased the window size to show the complete dropdown contents and button	
20/07/2012    IN33869        vijayK     Changes made for Search issue reported in IE9
14/08/2012	IN034365	Dinesh T		Script Error occurs in the Redirect order window
16/10/2012    IN035780		Chowminya G   After record New List, System do not refresh specimen status	
02/01/2013    IN035884		 Karthi L  	 Avoid blank  Pop up message box is prompted when we Record Specimen in Task List
03/06/2013	  IN035837		 Karthi L 		Requirement for managing future order and specimen number generation.[Bru-HIMS-CRF-320]
12/06/2013    IN040726       Nijitha S   CRF-CA-Bru-HIMS-CRF-320/01- Manage Specimen->No Prompt Message displayed for future Orders
25/06/2013	  IN041127		 Karthi L	 Wrong message prompt is displayed
26/06/2013	  IN041191		 Karthi L	The Date is not refreshed for the first order alone	
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date   Rev.By    Description
--------------------------------------------------------------------------------------------------------------
05/02/2014    IN00000		Chowminya  05/02/2014 Chowminya   Date format validation wrong Prompt Message displayed for Orders
28/04/2014	  IN048703		 Nijitha S						  GHL-SCF-807
29/08/2014	  IN050209		 Chowminya	 					   Unbilled services will be regrouped into a new order
27/05/2015	  	IN052230	Karthi L							Order Management-Missing specimens-Dispatch Slip
29/05/2015		IN055672 	Karthi L							HSA-CRF-0250_IN052230 : Unit Test Issue/01
29/05/2015		IN055674/55694 	Karthi L							HSA-CRF-0250_IN052230:Unit Test Issue/03 
12/08/2015	IN056883		Karthi L							SRR20056-SCF-9392_IN037492-RF	
06/10/2015		IN055737		Karthi L							IN055737 HSA-CRF-0250.1 - Dispatch Slip
20/10/2015		IN058099		Karthi L							HSA-CRF-0250.1/02- System does not Select All when a record is Unselected and Selected again using scanner..
22/08/2016		IN059646		Raja S								ML-BRU-SCF-1676
02/01/2017		IN061888	Karthi L							To record collection all at 1 go
26/07/2017		IN064835		Vijayakumar K					ML-MMOH-CRF-0578.1 [IN:064835]	
24/11/2017		IN063974	Prakash C							SS-CRF-0059[IN:063974]
08/07/2020     IN072994          Chandrashekar raju    	08/07/2020			Ramesh G              Modified for MMS-DM-CRF-0170.1
08/07/2020     IN072184          Chandrashekar raju     	08/07/2020       Ramesh G      Modified for MMS-DM-CRF-0157.2
11/05/2022		16601		Ramesh GHL-SCF-807					NMC-JD-SCF-0173
03/10/2022      34898          Twinkle Shah                         TH-KW-CRF-0020.5
11/10/2023      36727         Krishna Pranay   12/10/2023     Ramesh Goli           NMC-JD-CRF-0190

--------------------------------------------------------------------------------------------------------------
*/ 
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var invalidCode = "" ;
var qry_string = "";
var templocale="";
var disp_slip_checked_count = ""; //IN052230
var g_disp_slip_checked_counter = "7"; //IN055674
function clearOrderedList(docObj)
{
	document.specimen_order_search.ordered_location_val.value="";
	document.specimen_order_search.ordered_location_val_desc.value="";
}

function populateOrderSelection(ordered_type)
{
	var formObj = document.specimen_order_search;
	var localeName=formObj.localeName.value;

	if( ordered_type.value == "" ) 
	{
		clearOrderedList("document");
		document.specimen_order_search.orderedSearch.disabled=true;
		document.specimen_order_search.ordered_location_val_desc.disabled=true;
		document.specimen_order_search.ordered_location_val_desc.value="";
		document.specimen_order_search.ordered_location_val.value="";
	}
	else
	{
		document.specimen_order_search.orderedSearch.disabled=false;
		document.specimen_order_search.ordered_location_val_desc.disabled=false;
		document.specimen_order_search.ordered_location_val_desc.value="";
		document.specimen_order_search.ordered_location_val.value="";
	}
}

async function populateOrderLocation1(target,code)
{
	if(target.value!="")
	{
		await populateOrderLocation(target,code);
	}
	else
	{
		parent.SpecimenOrderSearch.document.specimen_order_search.ordered_location_val.value="";
	}
}

async function populateOrderLocation(target,code)
{
	
	
	ordered_location=parent.SpecimenOrderSearch.document.specimen_order_search.ordered_location.value;
	if(ordered_location!='')
	{
		facility_id = parent.SpecimenOrderSearch.document.specimen_order_search.facility_id.value;
		var sql = "";

		if(ordered_location=="W")
		{
			sql = parent.SpecimenOrderSearch.document.specimen_order_search.wing_sql.value;
		}	
		else if(ordered_location=="O")
		{
			sql = parent.SpecimenOrderSearch.document.specimen_order_search.theatre_sql.value;
		}

		sql=sql.replace('?',"'"+facility_id+"'");
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0]   =sql;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal = await CommonLookup(getLabel("eOR.DeptLocation.label","OR") , argumentArray );
		var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal !=null && retVal != "")
		{
			code.value=arr[0];
			target.value=arr[1];		
		}
		else
		{
   			target.value = "";
   			code.value = "" ;
			//target.value=getLabel("Common.all.label","Common");
 		}
	}	
}

function populateLocation(location_type)
{
	var formObj = document.specimen_order_search;
	var localeName=formObj.localeName.value;
	if( location_type.value == "" ) 
	{
		clearSourceLocationList("document");
		document.specimen_order_search.SourceSearch.disabled=true;
		document.specimen_order_search.locn.disabled=true;
		document.specimen_order_search.locn.value="";
		document.specimen_order_search.locn_code.value="";
	}
	else
	{
		document.specimen_order_search.SourceSearch.disabled=false;
		document.specimen_order_search.locn.disabled=false;
		document.specimen_order_search.locn.value="";
		document.specimen_order_search.locn_code.value="";
	}
}

function populateMoveLoaction1(target,code)
{
	if(target.value!="")
	{
		populateMoveLocation(target,code);
	}
	else
		parent.SpecimenOrderSearch.document.specimen_order_search.locn_code.value="";
}

async function populateMoveLocation(target,code)
{

	
	location_type=parent.SpecimenOrderSearch.document.specimen_order_search.location_type.value;

	if(location_type!='')
	{
		localeName=parent.SpecimenOrderSearch.document.specimen_order_search.localeName.value;
		var sql="";

		if(location_type=="C")
		{
			//sql="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(CLINIC_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
			sql=parent.SpecimenOrderSearch.document.specimen_order_search.clinic_sql.value;
		}
		else if(location_type=="N")
		{
		//sql="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
			sql=parent.SpecimenOrderSearch.document.specimen_order_search.nursing_sql.value;
		}
		else if(location_type=="R")
		{
		//sql="select REFERRAL_CODE code ,LONG_DESC description from AM_REFERRAL_LANG_VW where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(REFERRAL_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
			sql=parent.SpecimenOrderSearch.document.specimen_order_search.referral_sql.value;
		}

		sql=sql.replace('?',"'"+localeName+"'");
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		
		argumentArray[0]   =sql;
		
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal = await CommonLookup(getLabel("Common.SourceType.label","COMMON") , argumentArray );
		var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal !=null && retVal != "")
		{
			code.value=arr[0];
			target.value=arr[1];		
		}
		else
		{
   			target.value = "";
   			code.value = "" ;
		//target.value=getLabel("Common.all.label","Common");
 		}
	}	
}

function clearSourceLocationList( docObj ) 
{	
	document.specimen_order_search.locn_code.value="";
	document.specimen_order_search.locn.value="";
}

function clearPrintLocationList( docObj ) 
{
	document.specimen_order_search.print_loc.value="";
	document.specimen_order_search.print_loc_desc.value="";
}

function populatePrintLocation(location_type)
{
	var formObj="";

	if(document.specimen_order_search)
	{
		formObj = document.specimen_order_search;
	}
	else if(document.specimenRemarks)
	{
		formObj = document.specimenRemarks;
	}

	var templocale=formObj.language.value;
	if( location_type.value == "" ) 
	{
		clearPrintLocationList("document");
		formObj.PrintSearch.disabled=true;
		formObj.print_loc_desc.disabled=true;
		formObj.print_loc_desc.value="";
		formObj.print_loc.value="";
	}
	else 
	{
		formObj.PrintSearch.disabled=false;
		formObj.print_loc_desc.disabled=false;
		formObj.print_loc_desc.value="";
		formObj.print_loc.value="";
	}
	/*{
		var bean_id = ""
		if(option_from == 'DISPATCH') {
			bean_id = document.specimenRemarks.bean_id.value ;
		} else {
			bean_id = document.specimen_order_search.bean_id.value ;
		}
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
		xmlStr +=" /></root>" ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if(option_from == 'DISPATCH') {
			xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id +"&localeName="+templocale+ "&default_val=''&validate=prn_disp_ord_cat&location_type="+location_type.value, false ) ;
		} else {
			xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id +"&localeName="+templocale+ "&default_val=''&validate=prn_ord_cat&location_type="+location_type.value, false ) ;
		}

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText )
	}*/
}

function populatePrintLoaction1(target,code)
{
	if(target.value!="")
	{
		populatePrintLoaction(target,code);
	}
	else
	{
		if(parent.SpecimenOrderSearch)
		{
			parent.SpecimenOrderSearch.document.specimen_order_search.print_loc.value="";
		}
		else if(document.specimenRemarks)
		{
			document.specimenRemarks.print_loc.value="";
		}
	}
}

async function populatePrintLoaction(target,code)
{
	var formObj="";
	
	if(parent.SpecimenOrderSearch)
	{
		formObj=parent.SpecimenOrderSearch.document.specimen_order_search;
	}
	else if(document.specimenRemarks)
	{
		formObj=document.specimenRemarks;
	}
	location_type=formObj.loctype.value;
	if(location_type!='')
	{
		if(parent.SpecimenOrderSearch)
		{
			localeName=formObj.localeName.value;
		}
		else if(document.specimenRemarks)
		{
			localeName=formObj.language.value;
		}
		var sql="";

		if(location_type=="C")
		{
			//sql="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(CLINIC_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
			var sql=formObj.clinic_sql.value;
		}
		else if(location_type=="N")
		{
			//sql="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' AND LANGUAGE_ID='?'  and upper(NURSING_UNIT_CODE) like upper(?) and upper(LONG_DESC) like upper(?)"
			var sql=formObj.nursing_sql.value;
		}
		sql=sql.replace('?',"'"+localeName+"'");
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		
		argumentArray[0]   =sql;	
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal = await CommonLookup(getLabel("eOR.PrintLocation.label","OR") , argumentArray );
			var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal !=null && retVal != "")
		{
			code.value=arr[0];
			target.value=arr[1];		
		}
		else
		{
			target.value = "";
			code.value = "" ;
	//target.value=getLabel("Common.all.label","Common");
		}
	}
}

function addLocationList(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.specimen_order_search.locn.add(element);
}

function clearList( docObj ) 
{
	var len = eval(docObj+".specimen_order_search.locn.options.length") ;

	for(var i=0;i<len;i++)
	{
		eval(docObj+".specimen_order_search.locn.remove(\"atc_class_l2_code\")") ;
	}

	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".specimen_order_search.locn.add(opt)") ;
}

function addLocationList1(code,value)
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.specimen_order_search.locn1.add(element);
}

function clearList1( docObj ) 
{
	var len = eval(docObj+".specimen_order_search.locn1.options.length") ;

	for(var i=0;i<len;i++) 
	{
		eval(docObj+".specimen_order_search.locn1.remove(\"atc_class_l2_code\")") ;
	}

	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".specimen_order_search.locn1.add(opt)") ;
}

function addLocationList2(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.specimen_order_search.print_loc.add(element);
}

function clearList2( docObj ) 
{
	var len = eval(docObj+".specimen_order_search.print_loc.options.length") ;

	for(var i=0;i<len;i++)
	{
		eval(docObj+".specimen_order_search.print_loc.remove(\"atc_class_l2_code\")") ;
	}

	var tp = "  ---"+getLabel("Common.defaultSelect.label","Common")+"---   " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".specimen_order_search.print_loc.add(opt)") ;
}

function addDispatchLocationList(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.specimenRemarks.print_loc.add(element);
}

function clearDispatchList( docObj )
{
	var len = eval(docObj+".specimenRemarks.print_loc.options.length") ;
	for(var i=0;i<len;i++) 
	{
		eval(docObj+".specimenRemarks.print_loc.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "  ---"+getLabel("Common.defaultSelect.label","Common")+"---   " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".specimenRemarks.print_loc.add(opt)") ;
}

//this fucntion is used to clear the entries of search criteria
function resetValues()
{
}

//this is used for patient ID search
function callPatientSearch()
{
	var pat_id =  PatientSearch();
	if(pat_id != null)
		document.getElementById("patientId").value = pat_id;
}

function checkFieldLocal( field, name ) 
{
    var errors = '' ;
    if( trimCheck(field.value) )
    {
        field.value = trimString(field.value);
        return true;
    }
    else
    {
		errors = errors + getMessage("CAN_NOT_BE_BLANK","Common");
		errors = errors.replace('$',name);
        alert(errors) ;
        return false ;
    }
}

//called on click of search in the criteria page
function populateValues()
{
	//34898 Start.
	if(parent.SpecimenOrderSearch.document.specimen_order_search.pkiSiteSpecificYN.value == 'Y'  && parent.SpecimenOrderSearch.document.specimen_order_search.patientId.value =='')
	{
		alert(getMessage("SHD_NOT_BE_BLANK", "OR"));
		document.specimen_order_search.patientId.focus();
		return false;
	}
	//34898 End.
	if(top.content)
	    top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	if(checkLocationType()==false)
		return ;
	if(checkOrderType()==false)
		return ;
	var result  = true;
	formObj = parent.SpecimenOrderSearch.document.specimen_order_search;
	var flds=new Array(formObj.patientId,formObj.order_id);
	var name=new Array(getLabel("Common.patientId.label","Common"),getLabel("Common.OrderID.label","COMMON"));
	/*if(formObj.select_specific_order.value == 'S') {
		if(!checkFieldLocal( formObj.order_id, getLabel("eOR.OrderId.label","OR"))) {
			return false;
		}
	}*/
	var p_option_id = formObj.option_id.value;
	
	if(formObj.collection_list.value == 'Y' || formObj.option_list.value == 'S') 
	{
	//if(formObj.option_list.value == 'S') {
		
		if(!checkFieldLocal(formObj.print_loc,getLabel("eOR.PrintLocation.label","OR"))) 
		{			
			//parent.SpecimenOrderHeader.location.href='../../eCommon/html/blank.html';
			parent.SpecimenOrderResult.location.href='../../eCommon/html/blank.html';
			parent.SpecimenOrderBtn.location.href='../../eCommon/html/blank.html';
			formObj.loctype.focus(); //IN055737 HSA-CRF-0250.1
			return false;
		}
	}
	
	if(formObj.encounter_id.value!="") 
	{
	  	if(CheckForNumber(formObj.encounter_id.value)==true) 
		{
			result = true;
		}
		else result = false;
  	}

	//Modified for IN33869
	//if(SpecialCharCheck(flds,name,parent.messageFrame,"A","../../eCommon/jsp/MstCodeError.jsp"))
	if(SpecialCharCheck(flds,name,parent.document.messageFrame,"A","../../eCommon/jsp/MstCodeError.jsp"))
	//ends here IN33869
	{
		
		//if(doDatetimeCheckAlert(parent.SpecimenOrderSearch.document.specimen_order_search.date_from.value,parent.SpecimenOrderSearch.document.specimen_order_search.date_to.value)) {// removed on 14/02/2007 while doing thai date validations
		if(!isAfter(formObj.date_to.value,formObj.date_from.value,"DMYHM",parent.SpecimenOrderSearch.formObj.language.value))
		{//this function is available in eCommon/js/DateUtils.js
		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			//parent.SpecimenOrderHeader.location.href='../../eCommon/html/blank.html';
			parent.SpecimenOrderResult.location.href='../../eCommon/html/blank.html';
			parent.SpecimenOrderBtn.location.href='../../eCommon/html/blank.html';
			return false;
		}

		if((formObj.patientId.value=="")&&(formObj.encounter_id.value=="")&&(formObj.order_id.value=="")&&((formObj.option_list.value != 'N')&&(formObj.specimen_no.value=="")||((formObj.option_list.value == 'N'))))
		{	
			
			var days = daysBetween(formObj.date_from.value,formObj.date_to.value,"DMYHM",formObj.localeName.value);
			var param_value = parseInt((formObj.specimen_collect_hrs_behind.value),10) + parseInt((formObj.specimen_collect_hrs_ahead.value),10);
			if(days>param_value)
			{
				if(formObj.option_list.value=="N")
				{
					alert(getMessage("SPECIMEN_ORDER_SEARCH_VALIDATE_NEW_LIST","OR"));
				}
				else
				{
					alert(getMessage("SPECIMEN_ORDER_SEARCH_VALIDATE","OR"));					
				}
				parent.SpecimenOrderResult.location.href='../../eCommon/html/blank.html';
				parent.SpecimenOrderBtn.location.href='../../eCommon/html/blank.html';
				return false;
			}			
		}

		var insButtVal = "";
		if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "R" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "S")
		{
			insButtVal = getLabel("Common.Reprint.label","COMMON");
		}
		if(parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time.value==undefined)
		{
			parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time.value="N";
		}
		
		if(result) 
		{			
			QRY_STRING = "date_from="+parent.SpecimenOrderSearch.document.specimen_order_search.date_from.value+"&date_to="+parent.SpecimenOrderSearch.document.specimen_order_search.date_to.value+"&priority="+parent.SpecimenOrderSearch.document.specimen_order_search.priority.value+"&location_type="+parent.SpecimenOrderSearch.document.specimen_order_search.location_type.value+"&locn="+parent.SpecimenOrderSearch.document.specimen_order_search.locn_code.value+"&locn1="+parent.SpecimenOrderSearch.document.specimen_order_search.locn_code1.value+"&order_type="+parent.SpecimenOrderSearch.document.specimen_order_search.order_type.value+"&option="+parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value+"&select_specific_order="+"&collection_list="+parent.SpecimenOrderSearch.document.specimen_order_search.collection_list.value+"&patientId="+parent.SpecimenOrderSearch.document.specimen_order_search.patientId.value+"&order_id="+parent.SpecimenOrderSearch.document.specimen_order_search.order_id.value+"&encounter_id="+parent.SpecimenOrderSearch.document.specimen_order_search.encounter_id.value+"&curr_sys_date="+parent.SpecimenOrderSearch.document.specimen_order_search.curr_sys_date.value ;
			//if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "N" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "R" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "S" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "V"){
				QRY_STRING = QRY_STRING+"&prn_loctype="+parent.SpecimenOrderSearch.document.specimen_order_search.loctype.value+"&prn_loc="+parent.SpecimenOrderSearch.document.specimen_order_search.print_loc.value;
			//}
			if((parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "C" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "D" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "S" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "V" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "R") && parent.SpecimenOrderSearch.document.specimen_order_search.specimen_no)
			{
				QRY_STRING = QRY_STRING+"&specimen_no="+parent.SpecimenOrderSearch.document.specimen_order_search.specimen_no.value;
			}
			QRY_STRING = QRY_STRING+"&auto_collect="+parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time.value;
			QRY_STRING +="&ordering_facility="+parent.SpecimenOrderSearch.document.specimen_order_search.ordering_facility.value;
			// [IN030168] Start
			QRY_STRING +="&ordering_pract="+parent.SpecimenOrderSearch.document.specimen_order_search.ordering_pract.value;
			// [IN030168] End
			QRY_STRING +="&performing_facility="+parent.SpecimenOrderSearch.document.specimen_order_search.performing_facility.value;
			QRY_STRING +="&status="+parent.SpecimenOrderSearch.document.specimen_order_search.status.value+"&p_function_from="+parent.SpecimenOrderSearch.document.specimen_order_search.p_function_from.value;
			//QRY_STRING +="&ordered_location="+parent.SpecimenOrderSearch.document.specimen_order_search.ordered_location.value+"&ordered_location_val="+parent.SpecimenOrderSearch.document.specimen_order_search.ordered_location_val.value;//IN052230
			//QRY_STRING +="&ordered_location="+parent.SpecimenOrderSearch.document.specimen_order_search.ordered_location.value+"&ordered_location_val="+parent.SpecimenOrderSearch.document.specimen_order_search.ordered_location_val.value+"&multiSelect=LOAD_ON_FIRST";//IN052230
			QRY_STRING +="&ordered_location="+parent.SpecimenOrderSearch.document.specimen_order_search.ordered_location.value+"&ordered_location_val="+parent.SpecimenOrderSearch.document.specimen_order_search.ordered_location_val.value+"&multiSelect=LOAD_ON_FIRST"+"&option_id="+p_option_id;// ML-MMOH-CRF-0540 [IN061888]
			parent.SpecimenOrderSearch.document.specimen_order_search.search_btn.disabled = true;
			//parent.SpecimenOrderHeader.location.href = "../jsp/SpecimenCollectionListAndLabelHeader.jsp?option="+parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value;
			parent.SpecimenOrderResult.location.href = "../jsp/SpecimenCollectionListAndLabelsSearchResult.jsp?"+QRY_STRING;
			parent.SpecimenOrderBtn.location.href = "../jsp/SpecimenCollectionListAndLabelBttn.jsp?p_function_from="+parent.SpecimenOrderSearch.document.specimen_order_search.p_function_from.value+"&option="+parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value+"&insButtVal="+insButtVal;
      	}
	}
}

//called on click of clear button in search criteria
function clearValues()
{
	top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	document.specimen_order_search.search_btn.disabled = false;
	document.specimen_order_search.reset();
	changeOption(document.specimen_order_search.option_list);
	//parent.SpecimenOrderHeader.location.href = "../../eCommon/html/blank.html"
	parent.SpecimenOrderResult.location.href = "../../eCommon/html/blank.html"
	parent.SpecimenOrderBtn.location.href = "../../eCommon/html/blank.html"
}

// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll(Obj)
{
	// IN052230 - Start
	var start 		= 	parseInt(parent.SpecimenOrderResult.document.specimen_reporting_dtl.from.value);
	var end 		= 	parseInt(parent.SpecimenOrderResult.document.specimen_reporting_dtl.to.value);
	var totalResult	=	parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value; // moved to  IN052230
	var isSpecBarCodeSearchYN =	parent.SpecimenOrderResult.document.specimen_reporting_dtl.isSpecBarCodeSearchYN.value; // IN055737 / IN058099
	var selected = "";
	if(Obj.checked == true){
		selected = "Y";
		g_disp_slip_checked_counter = totalResult;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.selectedRecords.value = g_disp_slip_checked_counter;
		if(isSpecBarCodeSearchYN == 'Y') {
			parent.SpecimenOrderResult.document.specimen_reporting_dtl.selectedRecords.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.clonedMapcount.value;
		}
	}
	else {
		selected = "N";
		g_disp_slip_checked_counter = 0;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.selectedRecords.value = g_disp_slip_checked_counter;
	}
	// IN052230 - End
	if(Obj.checked==true)
	{
		//var totalResult=parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value; - IN052230
		var disableCount = 0;

		for(cnt=0; cnt<parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+cnt);
			if (val.disabled == true) 
			{
				disableCount++;
			} 
			else 
			{
				val.checked = true;
				val.value = "Y"
			}
		}
		
		if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="D" && totalResult > 0) 
		{
			if (disableCount < totalResult)
			{
				displayHeaderDate();
			}
		}
		
		if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N" && totalResult > 0) 
		{	
			for(cnt=0; cnt<parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value; cnt++)
			{
				var old_start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value;
				var	curr_sys_date_un  = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value
				var start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value.split(' ');
				var s_year = start_date[0].split('/');
				var s_time = start_date[1].split(':');
				//var start_date_= new Date(s_year[2],s_year[1],s_year[0],s_time[0],s_time[1]);
				var start_date_= new Date(s_year[2],s_year[1]-1,s_year[0],s_time[0],s_time[1]);//IN00000
				var curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value.split(' ');
				var c_year = curr_sys_date[0].split('/');
				var c_time = curr_sys_date[1].split(':');
				//var curr_sys_date_ = new Date(c_year[2],c_year[1],c_year[0],c_time[0],c_time[1]);
				var curr_sys_date_ = new Date(c_year[2],c_year[1]-1,c_year[0],c_time[0],c_time[1]);//IN00000
				if(start_date_ > curr_sys_date_) {
					var confirm_val= window.confirm(getMessage("UPDATE_FUTDAT_CURRDAT_SPECIMEN","OR") );
					if(confirm_val) {
						eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+cnt).value = 	curr_sys_date_un;	
						document.getElementById("start_date"+cnt).innerHTML= eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+cnt).value;
						var myPara = document.getElementById("start_date"+cnt);
						myPara.style.backgroundColor = "yellow";
					}else {
						document.getElementById("select"+cnt).checked = false;
						if( document.getElementById("totalChecked").value > 0 ) {
							document.getElementById("totalChecked").value = parseInt(parent.SpecimenOrderResult.document.getElementById("totalChecked").value) - 1; // added for ALPHA ISSUE 41127
						}
					}
				}
			}
		}
		// IN052230 - Start
		if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="S" && totalResult > 0) 
		{	//alert(' START '+ start + ' END ' + end + ' Count ' + cnt + " totalResult "+ totalResult);
			//var rec_start = start;
			//start = start -1;
			var i=0;
			//alert(' TOTAL RECORDS ' + totalResult + ' i ' + i);
			for(var rds=start; rds<end; start++)
			{	//alert('START ' + start + ' RDS ' + rds);
				if(i<totalResult){
				
					var order_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.rds_order_id"+start).value;
					var patient_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.rds_patient_id"+start).value;
					var specimen_no = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.rds_specimen_no"+start).value;
					rds = start;
					i++;
						//alert(' SPECIMEN ID ' + specimen_no + selected);
					addOrRemoveAllSpeicmen(patient_id, specimen_no, order_id, selected, start, end);
				}
				else {
					break;
				}
			}
			//alert('START 2' + start + ' RDS 2' + rds + ' END 2 ' + end);
		}
		// IN052230 -End
	}
	else
	{
		for(cnt=0; cnt<parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+cnt);
			val.checked = false;
			val.value = "N"
			eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode"+cnt).value = "";
			//eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_collect_date_time"+cnt).value = "";
			eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks"+cnt).value = "";
			eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+cnt).value = "";
		}
		// added for CRF 320
		if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N") 
		{	
			for(cnt=0; cnt<parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value; cnt++)
			{
				// modified for IN041191
				var old_start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value;
				var start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value.split(' ');
				var s_year = start_date[0].split('/');
				var s_time = start_date[1].split(':');
				var start_date_= new Date(s_year[2],s_year[1],s_year[0],s_time[0],s_time[1]);
				var curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value.split(' ');
				var c_year = curr_sys_date[0].split('/');
				var c_time = curr_sys_date[1].split(':');
			
				var curr_sys_date_ = new Date(c_year[2],c_year[1],c_year[0],c_time[0],c_time[1]);
						
				if(start_date_ > curr_sys_date_) {
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+cnt).value = old_start_date;
					document.getElementById("start_date"+cnt).innerHTML = old_start_date;
					var myPara = document.getElementById("start_date"+cnt);
					myPara.style.backgroundColor = "";
					document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) - 1; // added for ALPHA ISSUE 41127
				}
			}
		}
		// IN052230 - Start
		if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="S" ) 
		{	
			var totalResult=parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value;
			var i=0;
			/*for(var rds=start; rds<end; start++)
			{
				if(i<totalResult){
					var order_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.rds_order_id"+start).value;
					var patient_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.rds_patient_id"+start).value;
					var specimen_no = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.rds_specimen_no"+start).value;
					rds = start;
					i++;
					addOrRemoveAllSpeicmen(patient_id, specimen_no, order_id, selected, start, end);
				}
				else {
					break;
				}
			}*/
			addOrRemoveAllSpeicmen('', '', '', selected, '', '');
		}
		// IN052230 - End
		//parent.SpecimenOrderHeader.specimen_order_hdg.specimen_date_time.value = '';
		//parent.SpecimenOrderHeader.specimen_order_hdg.dispatch_mode.value = '';
		//parent.SpecimenOrderHeader.specimen_order_hdg.collected_by.value = '';
		//parent.SpecimenOrderHeader.specimen_order_hdg.specimen_remarks.value = '';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time.value = '';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode.value = '';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by.value = '';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks.value = '';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value='N';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value='';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value='';
	}
}

function clearAll()
{	
	//if (parent.SpecimenOrderHeader.document.specimen_order_hdg.check_all && parent.SpecimenOrderHeader.document.forms[0].check_all.checked==true) {
	if (parent.SpecimenOrderResult.document.specimen_reporting_dtl.check_all && parent.SpecimenOrderResult.document.specimen_reporting_dtl.check_all.checked==true)
	{
	//parent.SpecimenOrderHeader.document.specimen_order_hdg.check_all.checked=false;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.check_all.checked=false;

		for(cnt=0; cnt<parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value; cnt++)
		{
			
			val = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+cnt);
			val.checked = false;
			eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode"+cnt).value = "";
			eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_collect_date_time"+cnt).value = "";
			eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks"+cnt).value = "";
			eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+cnt).value = "";
			// added for CRF 320
			if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N") 
			{	
				var old_start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value;
				var start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value.split(' ');
				var s_year = start_date[0].split('/');
				var s_time = start_date[1].split(':');
				var start_date_= new Date(s_year[2],s_year[1],s_year[0],s_time[0],s_time[1]);
				var curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value.split(' ');
				var c_year = curr_sys_date[0].split('/');
				var c_time = curr_sys_date[1].split(':');
				var curr_sys_date_ = new Date(c_year[2],c_year[1],c_year[0],c_time[0],c_time[1]);
				if(start_date_ > curr_sys_date_){
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+cnt).value = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value;
					eval("parent.SpecimenOrderResult.document.getElementById('start_date"+cnt+"')").innerHTML = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value;
					var myPara = eval("parent.SpecimenOrderResult.document.getElementById('start_date"+cnt+"')");
					myPara.style.backgroundColor = "";
					document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) - 1; // added for ALPHA ISSUE 41127
				}
			}
		}
		
	} 
	else
	{
		for(cnt=0; cnt<parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+cnt);

			if (val.checked == true)
			{
				val.checked = false;
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode"+cnt).value = "";
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_collect_date_time"+cnt).value = "";
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks"+cnt).value = "";
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+cnt).value = "";
				if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N") 
				{	
					var old_start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value;
					var start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value.split(' ');
					var s_year = start_date[0].split('/');
					var s_time = start_date[1].split(':');
					var start_date_= new Date(s_year[2],s_year[1],s_year[0],s_time[0],s_time[1]);
					var curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value.split(' ');
					var c_year = curr_sys_date[0].split('/');
					var c_time = curr_sys_date[1].split(':');
					var curr_sys_date_ = new Date(c_year[2],c_year[1],c_year[0],c_time[0],c_time[1]);
					if(start_date_ > curr_sys_date_){
						eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+cnt).value = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value;
						eval("parent.SpecimenOrderResult.document.getElementById('start_date"+cnt+"')").innerHTML = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+cnt).value;
						var myPara = eval("parent.SpecimenOrderResult.document.getElementById('start_date"+cnt+"')");
						myPara.style.backgroundColor = "";
					}
				}
			}
		}
	}
}

function clearChecked()
{
	//parent.SpecimenOrderHeader.document.specimen_order_hdg.reset()
	parent.SpecimenOrderResult.document.specimen_order_dtl.reset()
}

function checkDate(obj)
{
	if(!(trimCheck(obj.value)))
	{
		obj.value = "";
		return false;
	}

	if(!(checkDt(obj.value)))
	{
		alert(getMessage("INVALID_DATE_FMT","SM"));
		obj.select();
		obj.focus();
		return false;
	}
}

function checkDate1(obj)
{
	var dt = new Date()
	var fromDate = document.specimen_order_search.date_from
	var toDate = document.specimen_order_search.date_to

	if(!(trimCheck(obj.value))) 
	{
		obj.value = "";
		return false;
	}

	if(!(checkDt(obj.value)))
	{
		obj.select();
		obj.focus();
		return false;
	}

	if(!(doDateCheck(fromDate,toDate,parent.parent.messageFrame)))
		return false
}

function insert(templocale)
{
	
	var no_of_checked = 0;
	var retval="";//Added for IN072184
	var formObj = parent.SpecimenOrderResult.document.specimen_reporting_dtl
	bean_id = formObj.bean_id.value
	bean_name = formObj.bean_name.value
   var bar_code_site_yn=parent.SpecimenOrderSearch.document.specimen_order_search.bar_code_scan_site_YN.value;//Added for IN072184
   var bar_code_scaned_yn=parent.SpecimenOrderSearch.document.specimen_order_search.bar_code_scaned_YN.value;//Added for IN072184
	formObj.option_list.value 		= parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value
	//formObj.specimen_hdr_date_time.value = parent.SpecimenOrderHeader.document.specimen_order_hdg.specimen_date_time.value;
	formObj.specimen_hdr_date_time.value = formObj.specimen_date_time.value;
	//var pat_list_size = formObj.pat_class_list_size.vlaue;//Added for IN072994
	var patClassList = new Array();//Added for IN072994
    var patClassEncList =new Array();//Added for IN072994
	var  temp_pat_class ="";//Added for IN072994
	var  temp_encounter_id ="";//Added for IN072994
	 
	if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N"  && parent.SpecimenOrderSearch.document.specimen_order_search.pkiSiteSpecificYN.value == 'Y'){
		if(parent.SpecimenOrderSearch.document.getElementById("quePkiToken").value==""){
			var confVal=confirm("Primary key of queue number is blank. Do you wish to proceed");
			if(!confVal){
				parent.SpecimenOrderSearch.document.getElementById("quePkiId").focus();
				return false;
			}
		}
	}
	if(parent.SpecimenOrderSearch.document.specimen_order_search.collection_list.value == 'Y' || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == 'S')
	{
	
		if(!checkFieldLocal(parent.SpecimenOrderSearch.document.specimen_order_search.print_loc,getLabel("eOR.PrintLocation.label","OR"))) 
		{			
			//parent.SpecimenOrderHeader.location.href='../../eCommon/html/blank.html';
			parent.SpecimenOrderResult.location.href='../../eCommon/html/blank.html';
			parent.SpecimenOrderBtn.location.href='../../eCommon/html/blank.html';
			return false;
		}
	}
	
	for(cnt=0; cnt<formObj.total_recs.value; cnt++)
	{
	
		val = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+cnt);
 		if(val.checked == true)
		{
			
		    val.value = 'Y';
			no_of_checked++;
			//Adding start foor MMS-DM-CRF--0170.1
			if(parent.SpecimenOrderSearch.document.specimen_order_search.patientId.value !="" && bar_code_site_yn== 'Y' ){
            temp_pat_class =eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.patient_class"+cnt).value;
			temp_encounter_id =eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.encounter_id"+cnt).value;
			pat_class_encounter =temp_pat_class+"~"+temp_encounter_id;
			if(patClassList != "" && patClassList.indexOf(temp_pat_class) == -1){
				patClassList += ","+temp_pat_class;
				patClassEncList[no_of_checked-1]= ","+pat_class_encounter
			 }
			 if(patClassList == ""){
				patClassList += temp_pat_class;
			    patClassEncList[0]= pat_class_encounter
			}
			}
			 //Adding end for MMS-DM-CRF--0170.1

		}
	}
	
	if(no_of_checked == 0)
	{
		alert(getMessage("CLICK_ANY_ONE","OR"))
		return false
	}
	
	//if (parent.SpecimenOrderHeader.specimen_order_hdg.check_all && parent.SpecimenOrderHeader.specimen_order_hdg.check_all.checked) {
	if (parent.SpecimenOrderResult.document.specimen_reporting_dtl.check_all && parent.SpecimenOrderResult.document.specimen_reporting_dtl.check_all.checked)
	{
		
		//parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_date_time.value = parent.SpecimenOrderHeader.specimen_order_hdg.specimen_date_time.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_date_time.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time.value;
		//parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_collected_by.value = parent.SpecimenOrderHeader.specimen_order_hdg.collected_by.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_collected_by.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by.value;
		//parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_specimen_remarks.value = parent.SpecimenOrderHeader.specimen_order_hdg.specimen_remarks.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_specimen_remarks.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks.value;
		//parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_dispatch_mode.value = parent.SpecimenOrderHeader.specimen_order_hdg.dispatch_mode.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_dispatch_mode.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode.value;
		
	} 
	else 
	{
	
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_date_time.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_collected_by.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_specimen_remarks.value = "" ;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_dispatch_mode.value = "";
	
	}
	
	if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N" && parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time.value=="Y")
	{
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_new_list_date_time.value = parent.SpecimenOrderSearch.document.specimen_order_search.specimen_date_time.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_new_list_collected_by.value = parent.SpecimenOrderSearch.document.specimen_order_search.collected_by.value;	parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_new_list_specimen_remarks.value = parent.SpecimenOrderSearch.document.specimen_order_search.specimen_remarks.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_new_list_seq_no.value = parent.SpecimenOrderSearch.document.specimen_order_search.seq_no.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.auto_collect.value = parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time.value;
	
	}
	else if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N" && parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time.value!="Y")
	{
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_new_list_date_time.value =""; 
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_new_list_collected_by.value =""; parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_new_list_specimen_remarks.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_new_list_seq_no.value ="-1"; 
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.auto_collect.value ="N"; 
	
	}
	
	if(((parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N") || (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="C"))&& parent.SpecimenOrderSearch.document.specimen_order_search.collection_list.value=="Y")
	{
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value = parent.SpecimenOrderSearch.document.specimen_order_search.collection_list.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value=	parent.SpecimenOrderSearch.document.specimen_order_search.loctype.value;	parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value=parent.SpecimenOrderSearch.document.specimen_order_search.print_loc.value;
	
	}
	else if(((parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N") || (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="C")) && parent.SpecimenOrderSearch.document.specimen_order_search.collection_list.value!="Y")
	{
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value ="N"; 
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value="";		parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value="";
	
	}
	//IN064835 starts
	if(parent.SpecimenOrderSearch.document.specimen_order_search.reroutePrinter != null)
	{
		var reroute_printer_id =parent.SpecimenOrderSearch.document.specimen_order_search.reroutePrinter.value;
		if(reroute_printer_id!='')
			parent.SpecimenOrderResult.document.specimen_reporting_dtl.reRoutePrinterId.value = reroute_printer_id;
	}
	//IN064835 ends
	//Adding start for IN072184
//return false;
	if(parent.SpecimenOrderSearch.document.specimen_order_search.patientId.value !="" && (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="C" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="D") && bar_code_site_yn=='Y'){
		callBarCodeCount(parent.SpecimenOrderSearch.document.specimen_order_search.patientId.value,parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value,patClassList,patClassEncList,bar_code_scaned_yn);//Added and commented below if and else ffor IN072994 		 //retval=callManualScanRemarks(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value);
	//}else if(bar_code_site_yn =="Y" &&parent.SpecimenOrderSearch.document.specimen_order_search.patientId.value !="") {
      //   retval =scanBarcodeCount(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value);
	}
		//Adding end for IN072184
	if(retval!= undefined){//Added only if condition for MMS-DM-SCF-0157.2

	eval(formApply( parent.SpecimenOrderResult.document.specimen_reporting_dtl,OR_CONTROLLER)) ;

	if(parent.SpecimenOrderResult.document.specimen_reporting_dtl.p_function_from.value!="CP") 
	{
		if( invalidCode != "" && invalidCode !=null)//"OR_STATUS_CHANGED"
		{ 
			parent.SpecimenOrderResult.document.getElementById("status"+invalidCode).className="orcancel";
			alert(getMessage(message,"OR"));
			populateValues();
			return false;
		}else
		{
		
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			//parent.SpecimenOrderResult.location.reload();
		}
	}
	else 
	{
 		if (message != "")
		{
			/*if( getMessage(message,"OR") != "" )
				message = getMessage(message,"OR");
			else if (message.indexOf("<br>") != -1) {
					message = message.substring(0,message.indexOf("<br>"))
			}*/
			if( (getMessage(message,"OR") == "") || (getMessage(message,"OR") == null)) //IN035884 - Start
			{
				alert(message);
				
			}
			else
			{
				alert(getMessage(message,"OR"));//--[IN035780]
			} //IN035884 - End
		
		//alert(message); //--[IN035780] commented
			//parent.SpecimenOrderResult.location.reload();
		}
	}
	if( result ) 
	{
	
 		if(parent.SpecimenOrderResult.document.specimen_reporting_dtl.p_function_from.value!="CP")
		{	
			onSuccess();
		}
		else 
		{
			window.close();
		}			
		if(parent.SpecimenOrderSearch.document.specimen_order_search.pkiSiteSpecificYN.value == 'Y'){
			submitPKIDDetails(bean_id,bean_name,templocale);
		}
		printValues(bean_id,bean_name,templocale);
	}
 }
}

function assignResult(_result, _message, _flag, _code)
{
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _code ;
}

function onSuccess() 
{
	//parent.SpecimenOrderHeader.location.reload();
	populateValues();
	if(parent.SpecimenOrderResult.document.specimen_reporting_dtl.p_function_from.value!="CP") 
	{
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	} 
	//parent.SpecimenOrderResult.location.reload();
}

function submitPKIDDetails(bean_id, bean_name,templocale){
	
//	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	//var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH/></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&option_list="+parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value+"&localeName="+templocale+"&validate=GET_SEPECIMEN_VALUES", false ) ;  
	xmlHttp.send( xmlDoc ) ;
	responseText	= (xmlHttp.responseText).replace(/^\s+|\s+$/gm,'');
	var specArr = responseText.split("|");	
	var facility_id=parent.SpecimenOrderSearch.document.getElementById("ordering_facility").value;		
	var queue_pkid=parent.SpecimenOrderSearch.document.getElementById("quePkiId").value;
	var token_num=parent.SpecimenOrderSearch.document.getElementById("quePkiNumber").value;
	var issued_date_time=parent.SpecimenOrderSearch.document.getElementById("quePkiIsueDateTime").value;
	var called_date_time=parent.SpecimenOrderSearch.document.getElementById("quePkiCallDateTime").value;
	var patient_id=parent.SpecimenOrderSearch.document.getElementById("patientId").value;
	var encounter_id=parent.SpecimenOrderSearch.document.getElementById("encounter_id").value;	
	var status_code=parent.SpecimenOrderSearch.document.getElementById("quePkiStatus").value;
	var status_text=parent.SpecimenOrderSearch.document.getElementById("quePkiStatusText").value;
	var user_id=parent.SpecimenOrderSearch.document.getElementById("userId").value;
	
	//alert(responseText+"<--->"+facility_id+"<--->"+queue_pkid+"<--->"+token_num+"<--->"+issued_date_time+"<--->"+called_date_time+"<--->"+patient_id+"<--->"+encounter_id+"<--->"+status_code+"<--->"+status_text+"<--->"+user_id);
	for(var i=0;i<specArr.length;i++){
		insertIntoXhQmsTable ("SPECOL",
				facility_id,
				queue_pkid,
				token_num,
				issued_date_time,
				called_date_time,
				patient_id,
				encounter_id,
				specArr[i],
				status_code,
				status_text,
				user_id);
	}
	
	
		
}
function printValues(bean_id, bean_name,templocale) 
{

	// Call the intermediate jsp, to make the values print.......
	//var tmplocale= document.specimen_order_search.templocale.value;
	//var tmplocale=templocale.value;// document.specimen_order_search.templocale.value;
//	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	//var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH/></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&option_list="+parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value+"&localeName="+templocale+"&validate=PRINT_VALUES", true ) ;  //16601  Option_list  added
	xmlHttp.send( xmlDoc ) ;
	//responseText	= xmlHttp.responseText ;
	//eval( responseText ) ;
}


function printDispatchValues(templocale) 
{	
 	// Call the intermediate jsp, to make the values print.......
	
	// added for IN052230 - Start
	var option_list= ""; 
	var formObj	 = parent.SpecimenOrderSearch.document.specimen_order_search; // moved for IN052230
	option_list	= formObj.option_list.value; // moved for IN052230
	if(option_list == 'S') {
		var bean_id = "Or_SpecimenOrder" ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;	
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id +"&validate=UPDATE_MAP_SIZE", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText)
		//55672 - Start
		if(disp_slip_checked_count == 0)
		{
			alert(getMessage("CLICK_ANY_ONE","OR"))
			return false
		}
		//55672 - End
	}
	//IN052230 - End
	//var formObj			= parent.SpecimenOrderSearch.document.specimen_order_search; -- commented for IN052230
	var period_from		= "";  var patient_id		= "";
	var period_to		= "";  var location_type	= "";
	var print_locn_type = "";  var locn				= "";
	var print_locn		= "";  var locn1			= "";
	var priority		= "";  var facility_id		= "";
	var ordered_location= ""; 
	var total_recs= ""; 
	//var option_list= ""; -- IN052230
	var bean_id			= formObj.bean_id.value;
	var bean_name		= formObj.bean_name.value;
	period_from			= formObj.date_from.value;
	period_to			= formObj.date_to.value;
	print_locn_type		= formObj.loctype.value;	
	print_locn			= formObj.print_loc.value;
	patient_id			= formObj.patientId.value;
	location_type		= formObj.location_type.value;
	//locn				= formObj.locn.value;
	locn				= formObj.locn_code.value;
	//locn1				= formObj.locn1.value;
	locn1				= formObj.locn_code1.value;
	priority			= formObj.priority.value;
	facility_id			= formObj.ordering_facility.value;
	ordered_location	= formObj.ordered_location.value;
	//option_list	= formObj.option_list.value; -- commented for IN052230
	/*if(option_list=="R")
	{
	total_recs	= parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value;
	for(i=0;i<parseInt(total_recs);i++)
		eval(" parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+i).checked=false;
	}*/

	//var tmplocale= document.specimen_order_search.templocale.value;
	//var tmplocale= templocale.value;//document.specimen_order_search.templocale.value;
//	var xmlDoc 			= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 		= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	//var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	xmlStr				= "<root><SEARCH ";
	xmlStr				+= "period_from=\""+ period_from +"\" " ;
	xmlStr				+= "period_to=\""+ period_to +"\" " ;
	xmlStr				+= "print_locn_type=\""+ print_locn_type +"\" " ;
	xmlStr				+= "print_locn=\""+ print_locn +"\" " ;

	xmlStr				+= "patient_id=\""+ patient_id +"\" " ;
	xmlStr				+= "location_type=\""+ location_type +"\" " ;
	xmlStr				+= "locn=\""+ locn +"\" " ;
	xmlStr				+= "locn1=\""+ locn1 +"\" " ;
	xmlStr				+= "priority=\""+ priority +"\" " ;
	xmlStr				+= "facility_id=\""+ facility_id +"\" " ;
	xmlStr				+= "ordered_location=\""+ ordered_location +"\" " ;
 
	xmlStr				+= "/></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
 	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&localeName="+templocale+"&option_list="+option_list+"&validate=PRINT_DISPATCH_SLIP", true ) ; // added new param option_list for IN052230
	alert(getMessage("RPT_SUBMIT_TO_PRINTER","OR"));
	xmlHttp.send( xmlDoc ) ;
	//parent.SpecimenOrderResult.location.reload();
	//IN052230 - Start
	if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="S")
	{
		parent.SpecimenOrderSearch.document.specimen_order_search.specimen_no.value = '';	// IN055737 HSA-CRF-0250.1
		populateValues();
	}
	//IN052230 - End
	if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="R")
	{
			insertValues(templocale);
	}
}


//this function will give the final xml string on click of apply
function beforePost(str) 
{
}

function setCollection(thisObj)
{
	if(thisObj.checked)
	{
		document.specimen_order_search.collection_list.value="Y";
		parent.SpecimenOrderSearch.document.getElementById("imgmand").style.visibility='visible';
		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:visible' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";
	}
	else
	{
		document.specimen_order_search.collection_list.value="N";
		parent.SpecimenOrderSearch.document.getElementById("imgmand").style.visibility='hidden';
		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:hidden' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";
	}
}

function setAutoUpdateCollection(thisObj)
{
	if(thisObj.checked)
	{
		document.specimen_order_search.collection_list_date_time.value="Y";
		clickOfAutoCollect(thisObj);
	}
	else
	{
		document.specimen_order_search.collection_list_date_time.value="N";
		clickOfAutoCollect(thisObj);
	}
}

async function callMenuFunctions(colval1,colval,orderId,sex,patient_id,patient_class,encounter_id)
{
	var dialogHeight ='64vh' ;
	var dialogWidth = '52vw' ;
	var dialogTop	= '100';
	var dialogLeft = '30' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	var arguments = "";
	var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class;
	var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}
function changeOption(thisObj)
{
	if(thisObj.value=="C")
	{
		//document.specimen_order_search.select_specific_order.selectedIndex=1;
		optionSpecificValues(thisObj.value);

		//document.getElementById("specimen_no_lbl_td").innerHTML=getLabel("eOR.SpecimenNo.label","OR");
		//document.getElementById("specimen_no_td").innerHTML="<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16' onKeyPress=\"return(ChkNumberInput(this,event,'0'))\"><input type='hidden' name='collection_list_date_time' id='collection_list_date_time' value='N' onClick='setAutoUpdateCollection(this);'><input name=collection_list type='hidden'  value='N'>";

		//document.getElementById("id_collection_chk").innerHTML='&nbsp;';
		//document.getElementById("id_collection").innerHTML="&nbsp;<input name=collection_list type='hidden'  value='N'>";
		//document.getElementById("print_location_type").innerHTML="&nbsp;";
		//document.getElementById("location_id").innerHTML="&nbsp;";
		//document.getElementById("location_id").innerHTML=getLabel("eOR.PrintLocation.label","OR");
		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:hidden' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";			document.getElementById("id_collection").innerHTML=getLabel("eOR.CollectionList.label","OR");
		document.getElementById("id_collection_chk").innerHTML="<input name=collection_list1 type='checkbox' align='left' value='N' onClick='setCollection(this);'><input name=collection_list type='hidden'  value='N'>";
		document.getElementById("coll_list_date_time_lbl_td").innerHTML = "&nbsp;";
		document.getElementById("coll_list_date_time_td").innerHTML = "<input name=collection_list_date_time type='hidden'  value='N'>";
		if(parent.SpecimenOrderBtn.document.getElementById("redirectOrder")!=null)//IN33979
			parent.SpecimenOrderBtn.document.getElementById("redirectOrder").style.display = 'none';//IN33979
		//IN064835 starts
		if(document.getElementById("reroute_printer_lbl_td") != null)
		document.getElementById("reroute_printer_lbl_td").style.display = 'none';
		if(document.getElementById("reroute_printer_opt_td") != null)
		document.getElementById("reroute_printer_opt_td").style.display = 'none';
		//IN064835 ends
	}
	else if (thisObj.value=='R')
	{
        optionSpecificValues(thisObj.value);
		//document.getElementById("id_collection").innerHTML=getLabel("eOR.CollectionList.label","OR");
        //document.getElementById("id_collection_chk").innerHTML="<input name=collection_list1 type='checkbox' align='left' value='N' onClick='setCollection(this);'><input name=collection_list type='hidden'  value='N'>";
 		//document.getElementById("location_id").innerHTML=getLabel("eOR.PrintLocation.label","OR");
 		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:hidden' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";
		document.getElementById("id_collection_chk").innerHTML='&nbsp;';
		document.getElementById("id_collection").innerHTML="<input name=collection_list type='hidden'  value='N'>";
		document.getElementById("coll_list_date_time_lbl_td").innerHTML = "&nbsp;";
		document.getElementById("coll_list_date_time_td").innerHTML = "<input name=collection_list_date_time type='hidden'  value='N'>";
		if(parent.SpecimenOrderBtn.document.getElementById("redirectOrder")!=null)//IN33979
			parent.SpecimenOrderBtn.document.getElementById("redirectOrder").style.display = 'none';//IN33979
		//IN064835 starts
		if(document.getElementById("reroute_printer_lbl_td") != null)
		document.getElementById("reroute_printer_lbl_td").style.display = 'inline';
		if(document.getElementById("reroute_printer_opt_td") != null)
		document.getElementById("reroute_printer_opt_td").style.display = 'inline';
		//IN064835 ends
	}
	else if (thisObj.value=='N')
	{
        optionSpecificValues(thisObj.value);
		if(document.getElementById("id_collection"))
		document.getElementById("id_collection").innerHTML=getLabel("eOR.CollectionList.label","OR");
		if(document.getElementById("id_collection_chk"))
        document.getElementById("id_collection_chk").innerHTML="<input name=collection_list1 type='checkbox' align='left' value='N' onClick='setCollection(this);'><input name=collection_list type='hidden'  value='N'>";
 		//document.getElementById("location_id").innerHTML=getLabel("eOR.PrintLocation.label","OR");
 		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:hidden' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";
		if(parent.SpecimenOrderBtn.document.getElementById("redirectOrder")!=null)//IN33979
			parent.SpecimenOrderBtn.document.getElementById("redirectOrder").style.display = 'inline';//IN33979
		//IN064835 starts
		if(document.getElementById("reroute_printer_lbl_td") != null)
		document.getElementById("reroute_printer_lbl_td").style.display = 'none';
		if(document.getElementById("reroute_printer_opt_td") != null)
		document.getElementById("reroute_printer_opt_td").style.display = 'none';
		//IN064835 ends
	} 
	else if (thisObj.value=='D')
	{
		optionSpecificValues(thisObj.value);
		//document.getElementById("id_collection").innerHTML="Print Dispatch List&nbsp;";

        //document.getElementById("id_collection_chk").innerHTML="<input name=collection_list1 type='checkbox' align='left' value='Y' onClick='setCollection(this);' checked><input name=collection_list type='hidden'  value='Y'>";
 		//document.getElementById("location_id").innerHTML="Print Location&nbsp;";
 		//document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--Select--</Option><Option value='C'>Clinic</Option><Option value='N'>Nursing Unit</Option></Select><select name='print_loc' id='print_loc' ><option value=''>&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;</option></Select>";
		//document.getElementById("location_id").innerHTML=getLabel("eOR.PrintLocation.label","OR");
 		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:hidden' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";
 		document.getElementById("id_collection_chk").innerHTML='&nbsp;';
		document.getElementById("id_collection").innerHTML="<input name=collection_list type='hidden'  value='N'>";
		document.getElementById("coll_list_date_time_lbl_td").innerHTML = "&nbsp;";
		document.getElementById("coll_list_date_time_td").innerHTML = "<input name=collection_list_date_time type='hidden'  value='N'>";
		//document.getElementById("print_location_type").innerHTML="&nbsp;";
		//document.getElementById("location_id").innerHTML="&nbsp;";
		if(parent.SpecimenOrderBtn.document.getElementById("redirectOrder")!=null)//IN33979
			parent.SpecimenOrderBtn.document.getElementById("redirectOrder").style.display = 'none';//IN33979
		//IN064835 starts
		if(document.getElementById("reroute_printer_lbl_td") != null)
		document.getElementById("reroute_printer_lbl_td").style.display = 'none';
		if(document.getElementById("reroute_printer_opt_td") != null)
		document.getElementById("reroute_printer_opt_td").style.display = 'none';
		//IN064835 ends
	}
	else if (thisObj.value == 'S' || thisObj.value == 'V' )
	{
		//document.getElementById("location_id").innerHTML=getLabel("eOR.PrintLocation.label","OR");
 		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:visible' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";
		document.getElementById("id_collection_chk").innerHTML='&nbsp;';
		document.getElementById("id_collection").innerHTML="<input name=collection_list type='hidden'  value='N'>";
		document.getElementById("coll_list_date_time_lbl_td").innerHTML = "&nbsp;";
		document.getElementById("coll_list_date_time_td").innerHTML = "<input name=collection_list_date_time type='hidden'  value='N'>";
		if(parent.SpecimenOrderBtn.document.getElementById("redirectOrder")!=null)//IN33979
			parent.SpecimenOrderBtn.document.getElementById("redirectOrder").style.display = 'none';//IN33979
		//IN064835 starts
		if(document.getElementById("reroute_printer_lbl_td") != null)
		document.getElementById("reroute_printer_lbl_td").style.display = 'none';
		if(document.getElementById("reroute_printer_opt_td") != null)
		document.getElementById("reroute_printer_opt_td").style.display = 'none';
		//IN064835 ends
	}
	enableDisableSpecNo();
}

function optionSpecificValues(option) 
{
	if (option == 'D') 
	{
		//document.getElementById("patientId_lbl_td").innerHTML = getLabel("Common.patientId.label","Common");
		/*
		document.getElementById("patientId_td").innerHTML = "<input type='text' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size='20' maxlength='<%=patient_id_length%>' ><input align='right' type=button name=search value='?'  class=button tabIndex='4' onClick=\"callPatientSearch()\"><input type='hidden'  name='select_specific_order' id='select_specific_order' value='A'>";
		document.getElementById("encounter_lbl_td").innerHTML =getLabel("Common.encounterid.label","Common");
		document.getElementById("encounter_id_td").innerHTML = "<input type=text name='encounter_id' id='encounter_id' size='12' maxlength='12' onKeyPress=\"return(ChkNumberInput(this,event,'0'))\">";
		*/
		//document.getElementById("order_id_lbl_td").innerHTML =getLabel("Common.OrderID.label","COMMON");
		//document.getElementById("order_id_td").innerHTML = "<input name='order_id' id='order_id' type=text size='15' maxlength='15' onKeyPress='return CheckForSpecChars(event)'>";
		document.getElementById("coll_list_date_time_lbl_td").innerHTML = "&nbsp;";
		document.getElementById("coll_list_date_time_td").innerHTML = "&nbsp;";
		/*document.getElementById("specimen_no_lbl_td").innerHTML = getLabel("eOR.SpecimenNo.label","OR");
		document.getElementById("specimen_no_td").innerHTML = "<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16' onKeyPress=\"return(ChkNumberInput(this,event,'0'))\"><input type='hidden' name='collection_list_date_time' id='collection_list_date_time' value='N' onClick='setAutoUpdateCollection(this);'>";
		*/
		//document.getElementById("rcd_collect").innerHTML = "&nbsp;";
	} 
	else if (option == 'C' || option == 'R' || option == 'N') 
	{
		//document.getElementById("select_specific_order_lbl_td").innerHTML = getLabel("eOR.SelectAllSpecificOrder.label","OR");
		//document.getElementById("select_specific_order_td").innerHTML = "<select name='select_specific_order' id='select_specific_order'><option value='A'>"+getLabel("Common.all.label","Common")+"</option><option value='S'>"+getLabel("Common.specific.label","Common")+"</option></select>";
		/*document.getElementById("patientId_lbl_td").innerHTML = getLabel("Common.patientId.label","Common");
		document.getElementById("patientId_td").innerHTML = "<input type='text' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size='20' maxlength='<%=patient_id_length%>' ><input type=button name=search value='?'  class=button tabIndex='4' onClick=\"callPatientSearch()\">";
		*/
		if(option == 'N')
		{
			document.getElementById("coll_list_date_time_lbl_td").innerHTML = getLabel("eOR.AutoUpdateCollectionDateTime.label","OR");
		}

		if(option == 'C') 
		{
			//document.getElementById("coll_list_date_time_lbl_td").innerHTML = "Specimen No&nbsp;";
			//document.getElementById("rcd_collect").innerHTML = "Specimen No&nbsp;<input type=text name='specimen_no' id='specimen_no' size='16' maxlength='16' onKeyPress=\"return(ChkNumberInput(this,event,'0'))\">&nbsp;<input type='hidden' name='collection_list_date_time' id='collection_list_date_time' value='N' onClick='setAutoUpdateCollection(this);'>";
			//if(document.getElementById("rcd_collect"))
			//document.getElementById("rcd_collect").innerHTML = "<input type='hidden' name='collection_list_date_time' id='collection_list_date_time' value='N' onClick='setAutoUpdateCollection(this);'>";
		}
		else
		{
			//document.getElementById("rcd_collect").innerHTML = "&nbsp;";
		}

		if(option == 'N') 
		{
				//document.getElementById("rcd_collect").innerHTML = "&nbsp;";
				document.getElementById("coll_list_date_time_td").innerHTML = "<input name=collection_list_date_time1 type='checkbox' value='N' onClick='setAutoUpdateCollection(this);' ><input name=collection_list_date_time type='hidden' value='N'>";
							
		} else 
		{
			//document.getElementById("coll_list_date_time_td").innerHTML = "<input name=collection_list_date_time type='checkbox' value='Y' checked onClick='setAutoUpdateCollection(this);'>";
			document.getElementById("coll_list_date_time_lbl_td").innerHTML = "&nbsp;";
			document.getElementById("coll_list_date_time_td").innerHTML = "&nbsp;";
		}
		//document.getElementById("encounter_lbl_td").innerHTML = getLabel("Common.encounterid.label","Common");
		//document.getElementById("encounter_id_td").innerHTML = "<input type=text name='encounter_id' id='encounter_id' size='12' maxlength='12' onKeyPress=\"return(ChkNumberInput(this,event,'0'))\">"; 		
	}
}

function checkLocationType()
{
	/*if(((parent.SpecimenOrderSearch.document.specimen_order_search.locn.selectedIndex==0) || (parent.SpecimenOrderSearch.document.specimen_order_search.locn1.selectedIndex==0)) || ( parent.SpecimenOrderSearch.document.specimen_order_search.locn.selectedIndex == parent.SpecimenOrderSearch.document.specimen_order_search.locn1.selectedIndex))	  {
		return true;
	} else if( (parent.SpecimenOrderSearch.document.specimen_order_search.locn.selectedIndex ) >( parent.SpecimenOrderSearch.document.specimen_order_search.locn1.selectedIndex)){
		alert(getOrMessage("TO_LOCATION_GR_EQ_FROM_LOCATION"));
		parent.SpecimenOrderSearch.document.specimen_order_search.locn1.focus();
		return false;
	}*/
	return true;

}

function checkOrderType()
{
	
}

function OrCheckTimeFormat(obj) 
{
   	var sequence = "1234567890:";
   	var obj_value = obj.value;
   	var obj_length = obj_value.length;
   	var firstString="";
   	var  lastString="";
	var len="";

   	for (i=0; i<obj_length; i++)   
	{
    	if(sequence.indexOf(obj_value.charAt(i))==-1)
		{
			alert(getMessage('ONLY_POSITIVE_NUM','OR'));
			obj.focus();
			return false;
		}
   	}

   	if (!( sequence.indexOf(":")  == -1) )
	{
		len= obj_value.indexOf(":");
		if(len!=-1)
		{
			firstString=obj_value.substr(0 ,len ) ;
			if(firstString>=24)
			{
				alert(getMessage("INVALID_TIME_FORMAT","SM"));
				obj.focus();
			}
	    	lastString=obj_value.substr(len+1 ,obj_length ) ;
			if (lastString>=60)
			{
				alert(getMessage("INVALID_TIME_FORMAT","SM"));
				obj.focus();
			}
	 	}
   	} 
	else
	{
   		if(obj_value>=24)
		{
			alert(getMessage("INVALID_TIME_FORMAT","SM"));
   		}
   	}
}
// Included by MOHAMED
async function displayHeaderDate() 
{
	var flag = false;
	if (parent.SpecimenOrderResult.document.specimen_reporting_dtl) 
	{
		formObj = parent.SpecimenOrderResult.document.specimen_reporting_dtl
		//var specimen_date_time 	= parent.SpecimenOrderHeader.specimen_order_hdg.specimen_date_time.value
		var specimen_date_time 	=  parent.SpecimenOrderResult.document.getElementById("specimen_date_time").value;
		var collected_by		= formObj.collected_by.value
		//var collected_by		= parent.SpecimenOrderHeader.specimen_order_hdg.collected_by.value
		//var dispatch_mode		= parent.SpecimenOrderHeader.specimen_order_hdg.dispatch_mode.value
		var dispatch_mode		= formObj.dispatch_mode.value
		//var specimen_remarks	= parent.SpecimenOrderHeader.specimen_order_hdg.specimen_remarks.value
		var specimen_remarks	= formObj.specimen_remarks.value
		var collection_list		= formObj.collection_list.value
		var loc_type			= formObj.print_locn_type.value
		var location			= formObj.print_locn.value
		var bean_id				= formObj.bean_id.value
		var bean_name			= formObj.bean_name.value
		var curr_sys_date = "";

		for (i = 0;i < formObj.total_recs.value;i++) 
		{
			//alert(eval("formObj.specimen_collect_date_time"+i).value);
			if(eval("formObj.specimen_collect_date_time"+i).value!=null && eval("formObj.specimen_collect_date_time"+i).value!="" && eval("formObj.specimen_collect_date_time"+i).value!="null")
			{
				if ((formObj.specimen_hdr_date_time.value == "") || (ValidateDateTime(formObj.specimen_hdr_date_time,eval("formObj.specimen_collect_date_time"+i)))) 
				{
					formObj.specimen_hdr_date_time.value = eval("formObj.specimen_collect_date_time"+i).value
				}
			}
		}

		//var dispatch_mode = parent.SpecimenOrderHeader.specimen_order_hdg.dispatch_mode.value;
		var dispatch_mode = formObj.dispatch_mode.value;
		var specimen_collect_date_time = formObj.specimen_hdr_date_time.value;
        var returnVal = "";
		returnVal = await displayDispatchDate(specimen_collect_date_time,specimen_date_time,curr_sys_date,dispatch_mode,collected_by,specimen_remarks,bean_id,bean_name,"ALL",collection_list,loc_type,location);
		if(returnVal != null )	
		{
			if (returnVal.length != 0) 
			{
				//parent.SpecimenOrderHeader.specimen_order_hdg.dispatch_mode.value = returnVal[0];
				formObj.dispatch_mode.value = returnVal[0];
				//parent.SpecimenOrderHeader.specimen_order_hdg.specimen_date_time.value = returnVal[1];
				formObj.specimen_date_time.value = returnVal[1];
				//parent.SpecimenOrderHeader.specimen_order_hdg.specimen_remarks.value = returnVal[2];
				formObj.specimen_remarks.value = returnVal[2];
				//parent.SpecimenOrderHeader.specimen_order_hdg.collected_by.value = returnVal[3];
				formObj.collected_by.value = returnVal[3];

				for (i = 0;i < formObj.total_recs.value;i++) 
				{
					eval("formObj.dispatch_mode"+i).value = returnVal[0];
					eval("formObj.specimen_date_time"+i).value = returnVal[1];
					eval("formObj.specimen_remarks"+i).value = returnVal[2];
					eval("formObj.collected_by"+i).value = returnVal[3];
				}
				parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value = returnVal[4];
				parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value = returnVal[5];
				parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value = returnVal[6];
				flag = true;
				document.getElementById("hdr").href="javascript:displayHeaderDate()" ;
				document.getElementById("hdr").style.cursor="auto" ;
				document.getElementById("hdr").title="View Dispatch Dtls.";
			}
		}
	}

	if (!flag) 
	{
		document.getElementById("select_td").innerHTML = "<a  class='gridLink' id='hdr' title=''><font color='white' size=1>"+getLabel("Common.defaultSelect.label","Common")+"</a><input type=checkbox name='check_all' id='check_all' onClick='clickAll(this)'>";
		//document.getElementById("hdr").href="#";
		document.getElementById("hdr").title="";
		clearAll();
		//parent.SpecimenOrderHeader.specimen_order_hdg.specimen_date_time.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time.value = "";
		//parent.SpecimenOrderHeader.specimen_order_hdg.dispatch_mode.value = '';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode.value = '';
		//parent.SpecimenOrderHeader.specimen_order_hdg.collected_by.value = '';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by.value = '';
		//parent.SpecimenOrderHeader.specimen_order_hdg.specimen_remarks.value = '';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks.value = '';
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value = 'N';
	}
}

async function displayDate(specimen_date_time)
{
	curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value;
	var dialogHeight= '50vh' ;
	var dialogWidth = '70vw' ;
	var dialogTop	= '290';
	var dialogLeft 	= '280' ;
	var title 	= ''
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments 	= "";
	var retVals = await window.showModalDialog("../../eOR/jsp/SpecimenCollectionDate.jsp?&specimen_date_time="+specimen_date_time+"&curr_sys_date="+curr_sys_date,arguments,features);
	return retVals
}
//Added by Siva Kumar - 17/9/2003
async function displayDate(specimen_date_time,collected_by,specimen_remarks,order_date_time,order_id,order_type_code,bean_id,bean_name,pat_name,labvalues)
{
	curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value;
	var dialogHeight= '50vh' ;
	var dialogWidth = '30vw' ;
	var dialogTop	= '290';
	var dialogLeft 	= '280' ;
	var title 	= ''
	var from_function = "SearchResult"
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments 	= "";
	//var retVals = window.showModalDialog("../../eOR/jsp/SpecimenCollectionDate.jsp?&specimen_date_time="+specimen_date_time+"&curr_sys_date="+curr_sys_date+"&order_date_time="+order_date_time+"&order_id="+order_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&from_function="+from_function,arguments,features);
	var retVals = await window.showModalDialog("../../eOR/jsp/SpecimenCollectionDateFrameset.jsp?&specimen_date_time="+specimen_date_time+"&collected_by="+collected_by+"&specimen_remarks="+specimen_remarks+"&curr_sys_date="+curr_sys_date+"&order_date_time="+order_date_time+"&order_id="+order_id+"&order_type_code="+order_type_code+"&bean_id="+bean_id+"&bean_name="+bean_name+"&pat_name="+pat_name+"&from_function="+from_function+"&labvalues="+labvalues,arguments,features);
	return retVals
}
//End of Addition - 17/9/2003

function closeDate() 
{
	if (parent.SpecimenCollectionDate.specimenDate)
	{
		if (parent.SpecimenCollectionDate.document.getElementById("size").value == -1) 
		{
			if (parent.SpecimenCollectionDate.document.getElementById("specimen_date_time0").value == "") 
			{
				alert(getMessage("SPECIMEN_COLLECTION_DATE_BLANK","OR"));
				parent.SpecimenCollectionDate.document.getElementById("specimen_date_time0").focus();
				return false;
			}
		} 
		else 
		{
			for (var i=0;i<parent.SpecimenCollectionDate.document.getElementById("size").value;i++) 
			{
				if (parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+i).value == "") 
				{
					alert(getMessage("SPECIMEN_COLLECTION_DATE_BLANK","OR"));
					parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+i).focus();
					return false;
				}
			}
		}
	}

    if(parent.SpecimenCollectionRemarks.specimenRemarks)
	{
		if (parent.SpecimenCollectionRemarks.document.getElementById("collected_by").value == "") 
		{
			alert(getMessage("SPECIMEN_COLLECTION_COLLECTION_BY_BLANK","OR"));
			parent.SpecimenCollectionRemarks.document.getElementById("collected_by").focus();
			return false;
		}
	}
	/*if (parent.SpecimenCollectionRemarks.specimenRemarks.document.getElementById("specimen_remarks").value == "") {
		alert(getOrMessage("SPECIMEN_COLLECTION_DISPATCH_REMARKS_BLANK"));
		parent.SpecimenCollectionRemarks.specimenRemarks.document.getElementById("specimen_remarks").focus();
		return false;
	}*/
	retArray = new Array();
	var interval_test_yn = "N";
	if(parent.SpecimenCollectionDate.specimenDate)
	{
		if (parent.SpecimenCollectionDate.document.getElementById("seq_no0")==null) 
		{
			retArray[0] = -1;
			retArray[1] = parent.SpecimenCollectionDate.document.getElementById("specimen_date_time0").value;
			retArray[2] = parent.SpecimenCollectionRemarks.document.getElementById("specimen_remarks").value;
			retArray[3] = parent.SpecimenCollectionRemarks.document.getElementById("collected_by").value;
			retArray[4] = interval_test_yn;
			
			if (parent.SpecimenCollectionDate.document.getElementById("specimen_date_time0").value == "") 
			{			
				alert(getMessage("SPECIMEN_COLLECTION_DATE_BLANK","OR"));			
				parent.SpecimenCollectionDate.document.getElementById("specimen_date_time0").focus();
				return false;
			}

			if(parent.SpecimenCollectionRemarks.document.getElementById("called_from").value!="New_List")
			{
				if(!validateSpecimenDate(parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+0), interval_test_yn)) 
				{
					parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+0).focus();
					return false;
				}
			}
			window.returnValue = retArray;
		} 
		else 
		{
			var seq_no = "";
			var specimen_date_time = "";
			interval_test_yn = parent.SpecimenCollectionDate.document.getElementById("interval_test_yn").value;
			//interval_test_yn = "Y";

			for (var i=0;i<parent.SpecimenCollectionDate.document.getElementById("size").value;i++) 
			{
				//seq_no = seq_no + "~" + eval("parent.SpecimenCollectionDate.specimenDate.document.getElementById("seq_no")"+i).value;
				seq_no +=   parent.SpecimenCollectionDate.document.getElementById("seq_no"+i).value+ "~";
				//specimen_date_time = specimen_date_time+ "~" + eval("parent.SpecimenCollectionDate.specimenDate.document.getElementById("specimen_date_time")"+i).value;
				specimen_date_time +=  parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+i).value+ "~";
	 
				if(!validateSpecimenDate(parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+i),interval_test_yn)) 
				{
					parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+i).focus();
					return false;
				}

				if (i >= 1) 
				{
					var j = i - 1;
					first = parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+j);
					second = parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+i);
					
					if(!validateSpecimenDate1(first,second)) 
					{
						parent.SpecimenCollectionDate.document.getElementById("specimen_date_time"+i).focus();
						return false;
					}
				}		
			}

			retArray[0] = seq_no;
			retArray[1] = specimen_date_time;
			retArray[2] = parent.SpecimenCollectionRemarks.document.getElementById("specimen_remarks").value;
			retArray[3] = parent.SpecimenCollectionRemarks.document.getElementById("collected_by").value;
			retArray[4] = interval_test_yn;
			window.returnValue = retArray;
		}
	}
	window.close();
}

async function clickLine(obj,rec_num)
{
	// moved top for IN052230 - Start
	var specimen_num = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_no"+rec_num).value;
	var patient_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.patient_id"+rec_num).value;
	var order_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_id"+rec_num).value;
	var clonedMapCount = parent.SpecimenOrderResult.document.specimen_reporting_dtl.clonedMapcount.value;
	// IN052230 - End
	if(obj.checked == true )
	{
		obj.value = "Y";
		var specimen_date_time = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value
		var specimen_remarks	= eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks"+rec_num).value
		var collected_by		= eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+rec_num).value
		var order_date_time = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_date_time"+rec_num).value
		//var order_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_id"+rec_num).value - Commented for IN052230
		var order_type_code = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_type_code"+rec_num).value
		var bean_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.bean_id").value
		var bean_name = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.bean_name").value
		var returnVal = "";
		var totalResult=parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value;
		var order_catalog_code = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_catalog_code"+rec_num).value;
		var labvalues=eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.lab_chking"+rec_num).value;//added on 7/16/2007 for lb_module by uma
		var order_catalog_desc = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.catalogDesc"+rec_num).value;
		var order_type_code = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_type_code"+rec_num).value;//IN034365
		//IN050209 - Start
		var patient_class = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.patient_class"+rec_num).value;
		//var patient_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.patient_id"+rec_num).value; - Commented for IN052230
		var encounter_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.encounter_id"+rec_num).value;
		var split_yn = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.split_yn"+rec_num).value;
		//IN050209 - End
		if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="C" && totalResult > 0) 
		{
			var ord_detail =parent.SpecimenOrderResult.document.getElementById("ord_detail"+rec_num).innerText;
			var index = 0;
			var i=0;
			var tmp_ord_detail = ord_detail;
			
			while((tmp_ord_detail.indexOf(",")))
			{
				tmp_ord_detail = tmp_ord_detail.replace(","," ");
				i++;
				if (i==1)
				{
					index =	eval(tmp_ord_detail.indexOf(","));
					break;
				}
			}
			
			//var pat_name = ord_detail.substring(0,(ord_detail.indexOf(",")));
			var pat_name = escape(ord_detail.substring(0,index));
			
            returnVal = await displayDate(specimen_date_time,collected_by,specimen_remarks,order_date_time,order_id,order_type_code,bean_id,bean_name,pat_name,labvalues);
			
			if (returnVal != null) 
			{
				if (returnVal.length != 0) 
				{
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.seq_no"+rec_num).value = returnVal[0]
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = returnVal[1]
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks"+rec_num).value = encodeURIComponent(returnVal[2]);
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+rec_num).value = returnVal[3]

					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.interval_test_yn"+rec_num).value = returnVal[4]
					
				}
			} 
			else 
			{
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+rec_num).checked = false
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.seq_no"+rec_num).value = ""
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = ""
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.interval_test_yn"+rec_num).value = "N";
			}
		} 
		else if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="D" && totalResult > 0) 
		{
			
            var curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value;
			var collection_list		= parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value
			var loc_type			= parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value
			var location			= parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value
			var specimen_collect_date_time = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_collect_date_time"+rec_num).value;
			var dispatch_mode = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode"+rec_num).value;
	
			returnVal = await displayDispatchDate(specimen_collect_date_time,specimen_date_time,curr_sys_date,dispatch_mode,collected_by,specimen_remarks,bean_id,bean_name,"LINE",collection_list,loc_type,location);
			if (returnVal != null) 
			{
				if (returnVal.length != 0) 
				{
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode"+rec_num).value = returnVal[0];
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = returnVal[1];
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks"+rec_num).value = encodeURIComponent(returnVal[2]);
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+rec_num).value = returnVal[3];
					parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value = returnVal[4];
					parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value = returnVal[5];
					parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value = returnVal[6];
				}
			} 
			else 
			{
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+rec_num).checked = false;
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.seq_no"+rec_num).value = "";
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode"+rec_num).value = "";
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = "";
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks"+rec_num).value = "";
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+rec_num).value = "";
				parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value = "";
				parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value = "";
				parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value = "N";
			}
		}// added for IN052230 - Start
		else if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="S" && totalResult > 0) 
		{	
			//IN055674 - Start
			g_disp_slip_checked_counter = parent.SpecimenOrderResult.document.specimen_reporting_dtl.selectedRecords.value;
			g_disp_slip_checked_counter++; 
			parent.SpecimenOrderResult.document.specimen_reporting_dtl.selectedRecords.value = g_disp_slip_checked_counter;
			if(g_disp_slip_checked_counter == clonedMapCount) { 
				parent.SpecimenOrderResult.document.specimen_reporting_dtl.check_all.checked=true;
			}
			//IN055674 End
			updateSelectedPatientList(patient_id,obj, specimen_num, order_id);
		}
		// added for IN052230 - End
		if((eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value != "") && ((parent.SpecimenOrderResult.document.specimen_reporting_dtl.option.value == 'C') || (parent.SpecimenOrderResult.document.specimen_reporting_dtl.option.value == 'D')))
		{		 
            document.getElementById("lins" + rec_num).href = "javascript:clickLine(document.getElementById('select" + rec_num + "'), " + rec_num + ")";

 
			document.getElementById("lins"+rec_num).innerHTML=getLabel("eOR.Dtls.label","OR");
		}
		else
		{
			//obj.value = "N";
			document.getElementById("lins"+rec_num).href="#";
			document.getElementById("lins"+rec_num).innerHTML=" " ;
			//eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.seq_no"+rec_num).value = "";
			//eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode"+rec_num).value = "";
			//eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = "";
			//eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks"+rec_num).value = "";
			//eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+rec_num).value = "";
			//parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value = "";
			//parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value = "";
			//parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value = "N";
		}
		// added for CRF 320
		if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N" && totalResult > 0) 
		{
			//IN040726 Starts
			//var start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+rec_num).value;
			var curr_sys_date_prev = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value;
			var start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+rec_num).value.split(' ');
			var s_year = start_date[0].split('/');
			var s_time = start_date[1].split(':');
			//var start_date_= new Date(s_year[2],s_year[1],s_year[0],s_time[0],s_time[1]);
			var start_date_= new Date(s_year[2],s_year[1]-1,s_year[0],s_time[0],s_time[1]);//IN00000
			var curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value.split(' ');
			var c_year = curr_sys_date[0].split('/');
			var c_time = curr_sys_date[1].split(':');
			//var curr_sys_date_ = new Date(c_year[2],c_year[1],c_year[0],c_time[0],c_time[1]);
			var curr_sys_date_ = new Date(c_year[2],c_year[1]-1,c_year[0],c_time[0],c_time[1]);//IN00000
		//	if(start_date > curr_sys_date) {
			if(start_date_ > curr_sys_date_) {
				var confirm_val;
				//IN059646 Starts
				if(parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time1.checked)
				{
					confirm_val=window.confirm(getMessage("UPDATE_FUTDAT_CURR_SPECIMEN_DATE","OR") );
				}//IN059646 Ends
				else
				{
				//IN040726 Ends
				confirm_val= window.confirm(getMessage("UPDATE_FUTDAT_CURRDAT_SPECIMEN","OR") );
				}
				if(confirm_val) {
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+rec_num).value = 	curr_sys_date_prev;	
					//document.getElementById("start_date"+rec_num).innerHTML= eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+rec_num).value; //commented for IN059646
					//IN059646 Starts
					if(parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time1.checked)
					document.getElementById("start_date"+rec_num).innerHTML=parent.SpecimenOrderSearch.document.specimen_order_search.specimen_date_time.value;
					else
					document.getElementById("start_date"+rec_num).innerHTML= eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+rec_num).value;
					//IN059646 Ends
					var myPara = document.getElementById("start_date"+rec_num);
					myPara.style.backgroundColor = "yellow";
				} else {
					document.getElementById("select"+rec_num).checked = false;
					document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) - 1; // added for ALPHA ISSUE 41127
				}
			}	
		}
		//IN050209 - Start
		if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N" && split_yn=="Y")
		{	
			checkBillSettlementforCatalog(obj,order_id,order_catalog_code,order_catalog_desc,order_type_code,patient_class,patient_id,encounter_id,rec_num);
		}	
		//IN050209 - End
		
		if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value !="S") { // added for IN052230
			updateSpecimenPerfLocn(obj,order_id,order_catalog_code,order_catalog_desc,order_type_code);
		}	
		document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) + 1;
	}
	else
	{
		// added for CRF 320
		if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N") 
		{	// modified for IN041191
			var old_start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+rec_num).value;
			//var curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value;
			var start_date = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.old_start_date_time"+rec_num).value.split(' ');
			var s_year = start_date[0].split('/');
			var s_time = start_date[1].split(':');
			var start_date_= new Date(s_year[2],s_year[1],s_year[0],s_time[0],s_time[1]);
			var curr_sys_date = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value.split(' ');
			var c_year = curr_sys_date[0].split('/');
			var c_time = curr_sys_date[1].split(':');
			
			var curr_sys_date_ = new Date(c_year[2],c_year[1],c_year[0],c_time[0],c_time[1]);
			
			if(start_date_ > curr_sys_date_) {
				eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.start_date_time"+rec_num).value = old_start_date;
				document.getElementById("start_date"+rec_num).innerHTML = old_start_date;
				var myPara = document.getElementById("start_date"+rec_num);
				myPara.style.backgroundColor = "";
			}
		}
		
		var order_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_id"+rec_num).value
		var order_catalog_code = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_catalog_code"+rec_num).value;
		var order_catalog_desc = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.catalogDesc"+rec_num).value;
		if (parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="S") 
		{	
			//IN055674 - Start
			g_disp_slip_checked_counter = parent.SpecimenOrderResult.document.specimen_reporting_dtl.selectedRecords.value;
			g_disp_slip_checked_counter--; 
			parent.SpecimenOrderResult.document.specimen_reporting_dtl.selectedRecords.value = g_disp_slip_checked_counter;
			if(parent.SpecimenOrderResult.document.specimen_reporting_dtl.check_all.checked==true){
				parent.SpecimenOrderResult.document.specimen_reporting_dtl.check_all.checked=false;
			}
			//IN055674
			updateSelectedPatientList(patient_id,obj, specimen_num, order_id);
		}
		else  { // added for IN052230
			updateSpecimenPerfLocn(obj,order_id,order_catalog_code,order_catalog_desc,order_type_code);	
		}
		document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) - 1;
		obj.value = "N";
		document.getElementById("lins"+rec_num).href="#";
		document.getElementById("lins"+rec_num).innerHTML=" " ;
		//eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.seq_no"+rec_num).value = "";
		eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode"+rec_num).value = "";
		eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.curr_sys_date.value;
		eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks"+rec_num).value = "";
		eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+rec_num).value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn_type.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.print_locn.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.collection_list.value = "N";
	}
}

async function displayDispatchDate (specimen_date_time,dispatch_date_time,curr_sys_date,dispatch_mode,dispatched_by,dispatch_remarks,bean_id,bean_name,calledFrom,collection_list,loc_type,location) 
{

	
	//	for(cnt=0; cnt<parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value; cnt++){
	var dialogHeight= '24vh' ;
	var dialogWidth = '67vh' ;
	if (calledFrom == 'ALL')
		dialogWidth = '70vh' ;
	var dialogTop	= '290';
	var dialogLeft 	= '280' ;
	if (calledFrom == 'ALL')
		dialogLeft	= '220';
	var title 	= ''
	var from_function = "SearchResult"
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments 	= "";
	var retVals = await top.window.showModalDialog("../../eOR/jsp/SpecimenDispatchDetailFrameset.jsp?&specimen_date_time="+specimen_date_time+"&curr_sys_date="+curr_sys_date+"&dispatch_date_time="+dispatch_date_time+"&dispatch_mode="+dispatch_mode+"&collected_by="+dispatched_by+"&specimen_remarks="+dispatch_remarks+"&bean_id="+bean_id+"&bean_name="+bean_name+"&from_function="+from_function+"&calledFrom="+calledFrom+"&collection_list="+collection_list+"&loc_type="+loc_type+"&location="+location,arguments,features);
	//if (retVals==undefined)
	//{
		//retVals="";
	//}
	return retVals
		
}

function selectDispatchLoc(obj)
{
	if (obj.checked == true)
	{
		parent.SpecimenDispatchRemarks.specimenRemarks.print_location_type.innerHTML = "<input type='checkbox' name='print_loc_chk' id='print_loc_chk' value='Y' onClick='selectDispatchLoc(this)' checked><Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"DISPATCH\")'><Option value=''>--Select--</Option><Option value='C'>Clinic</Option><Option value='N'>Nursing Unit</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);' style='width:98px'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:inline' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";
	} 
	else 
	{
		parent.SpecimenDispatchRemarks.specimenRemarks.print_location_type.innerHTML = "<input type='checkbox' name='print_loc_chk' id='print_loc_chk' value='N' onClick='selectDispatchLoc(this)'><input type='hidden' name='loctype' id='loctype' value=''><input type='hidden' name='print_loc' id='print_loc' value=''>";
	}
}

function closeDispatchDetail()
{
	if(parent.SpecimenDispatchDetail.specimenDispatchDetail)
	{
		for (var i=0;i<parent.SpecimenDispatchDetail.document.getElementById("size").value;i++) 
		{
			if (parent.SpecimenDispatchDetail.document.getElementById("dispatch_date_time"+i).value == "")
			{			
				alert(getMessage("SPECIMEN_COLLECTION_DISPATCH_DATE_BLANK","OR"));		
				parent.SpecimenDispatchDetail.document.getElementById("dispatch_date_time"+i).focus();
				return false;
			}

			if ((parent.SpecimenDispatchDetail.document.getElementById("dispatch_mode"+i).value == "") || (parent.SpecimenDispatchDetail.document.getElementById("dispatch_mode"+i).value==null )|| (parent.SpecimenDispatchDetail.document.getElementById("dispatch_mode"+i).value=="null")||(parent.SpecimenDispatchDetail.document.getElementById("dispatch_mode"+i).value == " ")) 
			{		
				alert(getMessage("SPECIMEN_COLLECTION_DISPATCH_MODE_BLANK","OR"));		
				parent.SpecimenDispatchDetail.document.getElementById("dispatch_mode"+i).focus();
				return false;
			}
		}
	}

	if(parent.SpecimenDispatchRemarks.specimenRemarks)
	{
		if (parent.SpecimenDispatchRemarks.document.getElementById("collected_by").value == "")
		{
		
			alert(getMessage("SPECIMEN_COLLECTION_DISPATCH_BY_BLANK","OR"));		
			parent.SpecimenDispatchRemarks.document.getElementById("collected_by").focus();
			return false;
		}
	
	/*if (parent.SpecimenDispatchRemarks.specimenRemarks.document.getElementById("specimen_remarks").value == "") {
		alert(getOrMessage("SPECIMEN_COLLECTION_DISPATCH_REMARKS_BLANK"));
		parent.SpecimenDispatchRemarks.specimenRemarks.document.getElementById("specimen_remarks").focus();
		return false;
	}*/

		if (parent.SpecimenDispatchRemarks.document.getElementById("print_loc_chk").value == 'Y' && parent.SpecimenDispatchRemarks.document.getElementById("print_loc").value == '') 
		{
			alert(getMessage("SPECIMEN_COLLECTION_DISPATCH_LOCN_BLANK","OR"));		
			parent.SpecimenDispatchRemarks.document.getElementById("print_loc_desc").focus();
			return false;
		}
	}

	var dispatch_mode = "";
	var dispatch_date_time = "";
	var retArray	= new Array();

	if(parent.SpecimenDispatchDetail.specimenDispatchDetail)
	{
		for (var i=0;i<parent.SpecimenDispatchDetail.document.getElementById("size").value;i++) 
		{
			dispatch_mode = dispatch_mode + "~" + parent.SpecimenDispatchDetail.document.getElementById("dispatch_mode"+i).value;
			dispatch_date_time = dispatch_date_time+ "~" + parent.SpecimenDispatchDetail.document.getElementById("dispatch_date_time"+i).value;
			var sys_date = parent.SpecimenDispatchDetail.document.getElementById("curr_sys_date0");
			var specimen_collect_date_time = parent.SpecimenDispatchDetail.document.getElementById("specimen_date_time0");
			if(!validateDispatchDate(parent.SpecimenDispatchDetail.document.getElementById("dispatch_date_time"+i),sys_date,specimen_collect_date_time,'DISPATCH')) 
			{
				parent.SpecimenDispatchDetail.document.getElementById("dispatch_date_time"+i).focus();
				return false;
			}

			if (i >= 1) 
			{
				var j = i - 1;
				first = parent.SpecimenDispatchDetail.document.getElementById("dispatch_date_time"+j);
				second = parent.SpecimenDispatchDetail.document.getElementById("dispatch_date_time"+i);
				
				if(!validateSpecimenDate1(first,second,'DISPATCH')) 
				{
				parent.SpecimenDispatchDetail.document.getElementById("dispatch_date_time"+i).focus();
					return false;
				}
			}
			retArray[0] = dispatch_mode;
			retArray[1] = dispatch_date_time;
			retArray[2] = parent.SpecimenDispatchRemarks.document.forms[0].specimen_remarks.value;
			retArray[3] = parent.SpecimenDispatchRemarks.document.forms[0].collected_by.value;
			retArray[4] = parent.SpecimenDispatchRemarks.document.forms[0].loctype.value;
			retArray[5] = parent.SpecimenDispatchRemarks.document.forms[0].print_loc.value;
			retArray[6] = parent.SpecimenDispatchRemarks.document.forms[0].print_loc_chk.value;
		}
	}
		window.returnValue = retArray;
		window.close();
}
/*Removed while Thai date Validations 16/02/2007 start*/
// Date Validation
/*function checkValidDateTime(obj){
	if(obj.value!='') {
		if(!doDateTimeChk(obj)) {
	    	alert(getMessage("INVALID_DATE_TIME","SM"));
	    	obj.focus();
	    	obj.select();
	    }
    }
}*/
/*Removed while Thai date Validations 16/02/2007 end*/

function validateSpecimenDate(obj , interval_test_yn)
{
	var order_date_time=" ";
	var sys_date=" ";
	var specimen_date= " ";

	sys_date = parent.SpecimenCollectionDate.document.getElementById("curr_sys_date0").value;
	order_date_time = parent.SpecimenCollectionDate.document.getElementById("order_date_time0").value;
	var locale				=	parent.SpecimenCollectionDate.document.getElementById("localeName").value;
	specimen_date = obj.value;

	if(locale.value!='en')
	{
		// if (order_date_time.equals(" ") || order_date_time.equals("null")) order_date_time="";
		//if (period_to.equals(" ") || period_to.equals("null")) period_to="";
		order_date_time				=	convertDate(order_date_time,'DMYHM',locale,"en"); 
		specimen_date				=	 convertDate(specimen_date,'DMYHM',locale,"en");
		sys_date= convertDate(sys_date,'DMYHM',locale,"en");
	}

	if(specimen_date.length > 0)
	{
		//var specimen_date = obj;
		//if(!doDateTimeChk(obj))//IN031200
		if(!doDateTimeChk(specimen_date))//IN031200
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			obj.value="";
			obj.focus();
			return false;
		}
		else 
		{
			//date should not be lesser than ordered date
			if (!ValidateDateTime(order_date_time,specimen_date)) 				
			{
				alert(getMessage("SPECIMEN_COLLECTION_ORDER_DATE","OR"));				
				//obj.select();
				obj.value="";
				return false;
			   //
			} 
			else if(interval_test_yn=="N") 
			{
			   if(!ValidateDateTime(specimen_date,sys_date)) 
			   { // date should not be greater than sysdate
						alert(getMessage("DATE_LESS_SYS_DATE","OR"));
						//obj.select();
						obj.value="";
						return false;
				//
				}
			 }
		}
	}//IN031200 Starts
	else if(specimen_date.length == 0)
	{
		sys_date = parent.SpecimenCollectionDate.document.getElementById("curr_sys_date0").value;
		order_date_time = parent.SpecimenCollectionDate.document.getElementById("order_date_time0").value;
		if (!ValidateDateTime(order_date_time,obj)) 				
		{
			alert(getMessage("SPECIMEN_COLLECTION_ORDER_DATE","OR"));				
			//obj.select();
			obj.value="";
			return false;
		} 
		else if(interval_test_yn=="N") 
		{
			if(!ValidateDateTime(obj,sys_date)) 
			{ // date should not be greater than sysdate
				alert(getMessage("DATE_LESS_SYS_DATE","OR"));
				//obj.select();
				obj.value="";
				return false;
			}
		}
	}	
	//IN031200 Ends
	return true;
}

function validateSpecimenDate1(first,second) 
{
	var locale				=	parent.SpecimenCollectionDate.document.getElementById("localeName").value;
//var first= " ";
//var second=" ";
 //first=first.value;
// second=second.value;

//if(locale.value!='en'){
		//first				=	convertDate(first,'DMYHM',locale,"en"); 
		//second				=	 convertDate(second,'DMYHM',locale,"en");
		
//}
	if (!ValidateDateTime(first,second)) 
	{		
		alert(getMessage("SPECIMEN_COLLECTION_PREV_COLLECTION_DATE","OR"));		
		//second.select();
		second.value="";
		return false;
	}
	return true;
}

function validateDispatchDate(obj,sys_date,order_date_time,option_from)
{
	var locale=parent.SpecimenDispatchDetail.document.getElementById("localeName").value;
	//var order_date_time= " ";
	var sys_date= "";
	var specimen_date="";
// order_date_time=order_date_time.value;
// if(order_date_time==undefined)
	//{
	//	order_date_time="";
	//}
 //sys_date=sys_date.value;
	specimen_date=obj.value;

	if(sys_date==null||sys_date==" "||sys_date=='undefined')sys_date="";
		sys_date=getCurrentDate("DMYHM",'en');
	if(locale!='en')
	{
		//order_date_time				=	convertDate(order_date_time,'DMYHM',locale,"en"); 	
		specimen_date= convertDate(specimen_date,'DMYHM',locale,"en");
	}

	if(specimen_date.length > 0)
	{
	 	//var specimen_date = obj;
		//if(!doDateTimeChk(obj))//IN031200
		if(!doDateTimeChk(specimen_date))//IN031200		
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			//obj.focus();
			obj.value="";
			return false;
		}
		else 
		{
		 	//date should not be lesser than specimen collection date
			if(order_date_time.value==null || order_date_time.value=='undefined')order_date_time.value="";
			if(order_date_time.value!=null && order_date_time.value!="null") 
			{
				if(order_date_time.value!="" &&order_date_time.value!=" ")
				{	
			//}else{				
					if (!ValidateDateTime(order_date_time,specimen_date)) 
					{
					
						alert(getMessage("SPECIMEN_COLLECTION_COLLECTION_DATE","OR"));					
						//obj.select();
						obj.value="";
						return false;
					}	
				}
			}	
			else 
			{
				//sys_date=getCurrentDate("DMYHM",'en');
				if(specimen_date.value==null || specimen_date.value=='undefined')specimen_date.value="";
				if(sys_date.value==null || sys_date.value=='undefined')sys_date.value="";
				if(specimen_date.value=="" || specimen_date.value==" ")specimen_date.value="";
				if(sys_date.value=="" || sys_date.value==" ")sys_date.value="";


				if(!ValidateDateTime(specimen_date,sys_date)) 
				{// date should not be greater than sysdate
		
					alert(getMessage("DATE_LESS_SYS_DATE","OR"));
					//obj.select();
					obj.value="";					
					return false;
				}
	
			}
		}
	}
	return true;
}

function validateDispatchDate1(first,second,option_from) 
{
	var locale=parent.SpecimenDispatchDetail.document.getElementById("localeName").value;
	var first=" ";
	var second=" ";
	first=first.value;
	second=second.value;

	if(locale.value!='en')
	{
			first				=	convertDate(first,'DMYHM',locale,"en"); 
			second				=	 convertDate(second,'DMYHM',locale,"en");		
	}

	if (!ValidateDateTime(first,second)) 
	{
		
		alert(getMessage("SPECIMEN_COLLECTION_PREV_COLLECTION_DATE","OR"));		
		//second.select();
		second.value="";
		return false;
	}
	return true;
}

 // Till here
 //Added by Siva Kumar for Stopping Enter key functionality on 25/08/2003
function enterCheck() 
{
	if (event.keyCode == 13) 
	{
 		event.keyCode = "";
 	}
}

function clearOrderList( docObj ) 
{
	var len = eval(docObj+".specimen_order_search.ordered_location_val.options.length") ;
	for(var i=0;i<len;i++) 
	{
		eval(docObj+".specimen_order_search.ordered_location_val.remove(\"ordered_location_val\")") ;
	}
	var tp = "  ---"+getLabel("Common.defaultSelect.label","Common")+"---   " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".specimen_order_search.ordered_location_val.add(opt)") ;
}

function addOrderList(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.specimen_order_search.ordered_location_val.add(element);
}


function populateOrderLocation_temp(location_order,templocale)
{
	
 	var formObj = document.specimen_order_search;
	if(  location_order.value == "" ) 
	{
  		clearOrderList( "document" )
	}
	else 
	{
		var bean_id = document.specimen_order_search.bean_id.value ;
		//var tmplocale= document.specimen_order_search.templocale.value;
		//var tmplocale=templocale.value;// document.specimen_order_search.templocale.value;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlStr ="<root><SEARCH " ;
		xmlStr += "location_order=\""+ location_order.value +"\" " ;
		xmlStr += "facility_id=\""+ document.specimen_order_search.facility_id.value +"\" " ;
		
		xmlStr +=" /></root>" ;
	 	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id +"&localeName="+templocale+ "&default_val=''&validate=POPULATE_LOCATION_ORDER", false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText )
	}
}
 //End of Addition by Siva Kumar

 async function populateMoveLoaction(target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	
	dataNameArray[0] = "LOCN_TYPE";
	dataValueArray[0] = document.specimen_order_search.location_type.value;
	dataTypeArray[0] = STRING;

	dataNameArray[1] = "LOCN_TYPE";
	dataValueArray[1] = document.specimen_order_search.location_type.value;
	dataTypeArray[1] = STRING;

	argumentArray[0]   =document.specimen_order_search.location_sql.value;
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "3,4";
	argumentArray[5]   = target.value == 'All'?"":target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup(getLabel("eOR.MovementLocation.label","OR") , argumentArray );

	if(retVal != null && retVal != "")
	{
		if(target.name == "locn")
			document.specimen_order_search.locn_code.value=retVal[0];
		else
			document.specimen_order_search.locn_code1.value=retVal[0];
		target.value = retVal[1];
	}
	else
	{
		target.value=getLabel("Common.all.label","Common");
		if(target.name == "locn")
			document.specimen_order_search.locn_code.value=retVal[0];
		else
			document.specimen_order_search.locn_code1.value=retVal[0];
	}
}

/*function convertDate(date,format,from,to){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = xhr.responseText
	return(xhr.responseText);
}
function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
}*/

function ondetail()
{
	if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="D")
	{
		//if(parent.SpecimenOrderHeader.specimen_order_hdg){
		//if(parent.SpecimenOrderHeader.specimen_order_hdg.check_all){
					//parent.SpecimenOrderHeader.specimen_order_hdg.check_all.disabled=false;
		//}
		//}
		if(document.getElementById("check_all"))
		{
			document.getElementById("check_all").disabled=false;
		}
	}else if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value=="N")
	{
		//if(parent.SpecimenOrderHeader.specimen_order_hdg){
		//if(parent.SpecimenOrderHeader.specimen_order_hdg.check_all){
		//parent.SpecimenOrderHeader.specimen_order_hdg.check_all.disabled=false;
		//}
		//}
		if(document.getElementById("check_all"))
		{
			//IN050209 - Start
			if(parent.SpecimenOrderSearch.document.specimen_order_search.disCheck)
			{
				if(parent.SpecimenOrderSearch.document.specimen_order_search.disCheck.value == "Y")
					document.getElementById("check_all").disabled=true;
				else
					document.getElementById("check_all").disabled=false;
			}else //IN050209 - End
				document.getElementById("check_all").disabled=false;
		}
	}

}

function alignHeading()
{
	if(parent.SpecimenOrderHeader.document.getElementById("tableheader")!=null)
	{
				parent.SpecimenOrderHeader.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				for (j=0; j < document.getElementById("tableresult").rows(1).cells.length; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows(1).cells(j).offsetWidth);
					
					if(parent.SpecimenOrderHeader.document.getElementById("tableheader").rows(0).cells(j) != null)
					{
						if(parseInt(wid)>0)
						parent.SpecimenOrderHeader.document.getElementById("tableheader").rows(0).cells(j).width=wid;
					}
				}
		}
		
	}

function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.SpecimenOrderHeader.location.href.indexOf(".jsp") != -1)
	{
		parent.SpecimenOrderHeader.document.body.scrollLeft=temp;
	}
}

function chkStage(obj)
{	
	if(obj.value=="S")
	{
		parent.SpecimenOrderSearch.document.getElementById("imgmand").style.visibility='visible';
		
	}
	else
	{
		parent.SpecimenOrderSearch.document.getElementById("imgmand").style.visibility='hidden';
	}
}

function insertValues(templocale)
{
	var no_of_checked = 0;
	var formObj = parent.SpecimenOrderResult.document.specimen_reporting_dtl
	bean_id = formObj.bean_id.value
	bean_name = formObj.bean_name.value
	formObj.option_list.value 		= parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value
	//formObj.specimen_hdr_date_time.value = parent.SpecimenOrderHeader.document.specimen_order_hdg.specimen_date_time.value
	formObj.specimen_hdr_date_time.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time.value
	for(cnt=0; cnt<formObj.total_recs.value; cnt++)
	{
		val = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+cnt);
 		if(val.checked == true) 
		{
		    val.value = 'Y';
			no_of_checked++;
		}
	}

	if(no_of_checked == 0)
	{
		alert(getMessage("CLICK_ANY_ONE","OR"))
		return false
	}
	//if (parent.SpecimenOrderHeader.specimen_order_hdg.check_all && parent.SpecimenOrderHeader.specimen_order_hdg.check_all.checked) {
	if (document.getElementById("check_all") &&document.getElementById("check_all").checked) 
	{
		//parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_date_time.value = parent.SpecimenOrderHeader.specimen_order_hdg.specimen_date_time.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_date_time.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time.value;
		//parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_collected_by.value = parent.SpecimenOrderHeader.specimen_order_hdg.collected_by.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_collected_by.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by.value;
		//parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_specimen_remarks.value = parent.SpecimenOrderHeader.specimen_order_hdg.specimen_remarks.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_specimen_remarks.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_remarks.value;
		//parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_dispatch_mode.value = parent.SpecimenOrderHeader.specimen_order_hdg.dispatch_mode.value;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_dispatch_mode.value = parent.SpecimenOrderResult.document.specimen_reporting_dtl.dispatch_mode.value;
	} 
	else 
	{
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_date_time.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_collected_by.value = "";
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_specimen_remarks.value = "" ;
		parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_hdr_dispatch_mode.value = "";
	}
	eval(formApply( parent.SpecimenOrderResult.document.specimen_reporting_dtl,OR_CONTROLLER)) ;
 
	if(parent.SpecimenOrderResult.document.specimen_reporting_dtl.p_function_from.value!="CP") 
	{
		if( invalidCode != "" && invalidCode !=null)//"OR_STATUS_CHANGED"
		{ 
			parent.SpecimenOrderResult.document.getElementById("status"+invalidCode).className="orcancel";
			alert(getMessage(message,"OR"));
			populateValues();
			return false;
		}
		else
		{
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			//parent.SpecimenOrderResult.location.reload();
		}
	} 
	else 
	{
 		if (message != "") 
		{
			/*if( getMessage(message,"OR") != "" )
				message = getMessage(message,"OR");
			else if (message.indexOf("<br>") != -1) {
					message = message.substring(0,message.indexOf("<br>"))
			}*/
			
			if( (getMessage(message,"OR") == "") || (getMessage(message,"OR") == null)) //IN035884 - Start
			{
				alert(message);
				
			}
			else
			{
				alert(getMessage(message,"OR"));//--[IN035780]
			} //IN035884 - End
			
			//alert(message);//--[IN035780] commented
			//parent.SpecimenOrderResult.location.reload();
		}
	}
	
	if( result ) 
	{
 		if(parent.SpecimenOrderResult.document.specimen_reporting_dtl.p_function_from.value!="CP") {
			onSuccess();
		}
		else {
			window.close();
		}		
		//printValues(bean_id,bean_name,templocale);
	}
	
}

async function clickOfAutoCollect(obj)
{
	if(obj.checked == true )
	{
		obj.value = "Y";
        var specimen_date_time =""; 
		var specimen_remarks	=""; 
		var collected_by		=""; 
		var order_date_time =""; 
		var order_id =""; 
		var order_type_code =""; 
		var bean_id = eval("document.specimen_order_search.bean_id").value
		var bean_name = eval("document.specimen_order_search.bean_name").value
		var returnVal = "";
		var labvalues="";
		if(document.specimen_order_search.option_list.value=="N")
		{		
			var ord_detail = "";
			var index = 0;
			var i=0;
					
			var pat_name = "";
			
            returnVal = await CollectDate(specimen_date_time,collected_by,specimen_remarks,order_date_time,order_id,order_type_code,bean_id,bean_name,pat_name,labvalues);
			if (returnVal != null) 
			{
				if (returnVal.length != 0) 
				{
					parent.SpecimenOrderSearch.document.specimen_order_search.seq_no.value = returnVal[0]
					parent.SpecimenOrderSearch.document.specimen_order_search.specimen_date_time.value = returnVal[1]
					parent.SpecimenOrderSearch.document.specimen_order_search.specimen_remarks.value = encodeURIComponent(returnVal[2]);
					parent.SpecimenOrderSearch.document.specimen_order_search.collected_by.value = returnVal[3]
				}
			} 
			else 
			{				
				parent.SpecimenOrderSearch.document.specimen_order_search.seq_no.value= "";
				parent.SpecimenOrderSearch.document.specimen_order_search.specimen_date_time.value="";
				parent.SpecimenOrderSearch.document.specimen_order_search.specimen_remarks.value ="";
				parent.SpecimenOrderSearch.document.specimen_order_search.collected_by.value="";
			}
		} 
	}
}

async function CollectDate(specimen_date_time,collected_by,specimen_remarks,order_date_time,order_id,order_type_code,bean_id,bean_name,pat_name,labvalues)
{
	curr_sys_date = parent.SpecimenOrderSearch.document.specimen_order_search.curr_sys_date.value;
	var dialogHeight= '50vh' ;
	var dialogWidth = '60vw' ;
	var dialogTop	= '290';
	var dialogLeft 	= '280' ;
	var title 	= ''
	var from_function = "SearchResult"
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments 	= "";

	var retVals = await window.showModalDialog("../../eOR/jsp/SpecimenCollectionDateFrameset.jsp?&specimen_date_time="+specimen_date_time+"&collected_by="+collected_by+"&specimen_remarks="+specimen_remarks+"&curr_sys_date="+curr_sys_date+"&order_date_time="+order_date_time+"&order_id="+order_id+"&order_type_code="+order_type_code+"&bean_id="+bean_id+"&bean_name="+bean_name+"&pat_name="+pat_name+"&from_function="+from_function+"&labvalues="+labvalues+"&called_from=New_List",arguments,features);
	return retVals
}

function enableDisableCollectionList()
{	
	var operatorVal=document.specimen_order_search.option_list.value;
	if(operatorVal=='C')
	{	
		optionSpecificValues(operatorVal);		
		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:hidden' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";			document.getElementById("id_collection").innerHTML=getLabel("eOR.CollectionList.label","OR");
		document.getElementById("id_collection_chk").innerHTML="<input name=collection_list1 type='checkbox' align='left' value='N' onClick='setCollection(this);'><input name=collection_list type='hidden'  value='N'>";
		document.getElementById("coll_list_date_time_lbl_td").innerHTML = "&nbsp;";
		document.getElementById("coll_list_date_time_td").innerHTML = "<input name=collection_list_date_time type='hidden'  value='N'>";		
	}
	else if(operatorVal=='N')
	{
		optionSpecificValues(operatorVal);
		if(document.getElementById("id_collection"))
		document.getElementById("id_collection").innerHTML=getLabel("eOR.CollectionList.label","OR");
		if(document.getElementById("id_collection_chk"))
        document.getElementById("id_collection_chk").innerHTML="<input name=collection_list1 type='checkbox' align='left' value='N' onClick='setCollection(this);'><input name=collection_list type='hidden'  value='N'>"; 		
 		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:hidden' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";

	}
	else if(operatorVal=='D')
	{
		optionSpecificValues(operatorVal);		
 		document.getElementById("print_location_type").innerHTML="<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,\"SEARCH\")'><Option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"---</Option><Option value='C'>"+getLabel("Common.clinic.label","Common")+"</Option><Option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</Option></Select><input type='text' value='' name='print_loc_desc' id='print_loc_desc' onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name='PrintSearch' id='PrintSearch' value='?'  class=button tabIndex='4' onClick='populatePrintLoaction(print_loc_desc,print_loc);' disabled><img src='../../eCommon/images/mandatory.gif' align=center style='visibility:hidden' id='imgmand'><input type='hidden' name='print_loc' id='print_loc' value=''>";
 		document.getElementById("id_collection_chk").innerHTML='&nbsp;';
		document.getElementById("id_collection").innerHTML="<input name=collection_list type='hidden'  value='N'>";
		document.getElementById("coll_list_date_time_lbl_td").innerHTML = "&nbsp;";
		document.getElementById("coll_list_date_time_td").innerHTML = "<input name=collection_list_date_time type='hidden'  value='N'>";
	}
	enableDisableSpecNo();
}
function enableDisableSpecNo()
{
	var operatorVal=document.specimen_order_search.option_list.value;

	if(operatorVal=="N")
	{
		document.getElementById("specimen_no").disabled=true;
		//34898 Start
		document.specimen_order_search.pkiSiteSpecificYN.value = document.specimen_order_search.pkiSiteSpecificYNOrg.value;
		if(document.specimen_order_search.pkiSiteSpecificYNOrg.value=='Y'){
			document.specimen_order_search.patientIdManImage.style.visibility='visible';
			document.getElementById("quepkiRow").style.visibility='visible';
			document.getElementById("quepkiRow1").style.visibility='visible';
			document.getElementById("quePkiIdRow2").style.visibility='visible';
			document.getElementById("quePkiIdMessage").innerHTML="&nbsp;";
		}
		//34898 End.
	}
	else
	{
		document.getElementById("specimen_no").disabled=false;
		//34898 Start.
		if(document.specimen_order_search.pkiSiteSpecificYNOrg.value=='Y'){
		document.specimen_order_search.pkiSiteSpecificYN.value = 'N';
		document.specimen_order_search.patientIdManImage.style.visibility='hidden';
		document.getElementById("quepkiRow").style.visibility='hidden';
		document.getElementById("quepkiRow1").style.visibility='hidden';
		document.getElementById("quePkiIdRow2").style.visibility='hidden';
		document.getElementById("quePkiIdMessage").innerHTML="&nbsp;";
		}
		//34898 End.
	}
}
// [IN030168] Start 
async function callpractSearchSpecimenSearch1(target,code)
{ 
if(target.value!="")
	{
	await callpractSearchSpecimenSearch(target,code);
	}
	else
	specimen_order_search.ordering_pract.value="";
}


async function callpractSearchSpecimenSearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var localeName=specimen_order_search.localeName.value;
	var sql=specimen_order_search.specimen_Orderby_pract.value;
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]   =sql;
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retval=await CommonLookup(getLabel("Common.OrderingPractitioner.label","COMMON"),argumentArray);

	if(retval !=null && retval != ""){
		code.value=retval[0];
		target.value=retval[1];
		
		}else{
   		target.value = "";
   		code.value = "" ;
 	}
}
// [IN030168] End 
async function openRedirectWindow()
{
	var dialogHeight ='32vh' ;
	var dialogWidth = '34vw' ;//IN33979
	var dialogTop	= '250';
	var dialogLeft = '30' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

	var arguments = "";
	bean_id = document.getElementById("bean_id").value;
	bean_name = document.getElementById("bean_name").value;
	
	//if(parent.SpecimenOrderResult.document.getElementById("check_all").checked == false && parseInt(parent.SpecimenOrderResult.document.getElementById("totalChecked").value) == 0)
	if(parseInt(parent.SpecimenOrderResult.document.getElementById("totalChecked").value) <= 0)
	{
		alert(getMessage("CLICK_ANY_ONE","OR"));
		return;
	}
	
	//if(parseInt(parent.SpecimenOrderResult.document.getElementById("totalChecked").value) > 1)//36727
	if(parseInt(parent.SpecimenOrderResult.document.getElementById("totalChecked").value) > 1 && parent.SpecimenOrderResult.document.specimen_reporting_dtl.isAllowRedirectMulRecord.value == 'N')//36727
	{
		
		alert("APP-OR0177 Maximum of one order can be directed at a time");
		return;
	}
	
	order_line_num = "1";//Check the order line num concept
	var finalString = "bean_id="+bean_id+"&bean_name="+bean_name;
	var retVals = await window.showModalDialog("../../eOR/jsp/RegisterOrderPerformLocn.jsp?"+finalString,arguments,features);

	if(retVals == 'Y')
		parent.SpecimenOrderSearch.document.getElementById("search_btn").click();
}

function updateChangePerformLocn() 
{
    var formObj = document.register_order_perform_locn;
    var localeName=formObj.localeName.value;
	var bean_id = formObj.bean_id.value ;
	
    if (formObj.performing_facility.value == '') 
	{
    	alert(getMessage("PERFORMING_FACILITY_BLANK","OR"));
    	return false;
    }
	
	formObj.perf_facility.value = formObj.performing_facility.value;
	formObj.perf_location.value = formObj.performing_location.value;
	eval(formApply( document.register_order_perform_locn,OR_CONTROLLER)) ;

	if(message!='')
	{
		for(i=0;i<7;i++)
		{
			message=message.replace("<br>","\n");
			message=message.replace("<br />"," ")
		}
	}
	if(result)
	{
		alert(getMessage("RECORD_MODIFIED","SM")+"\n"+message);
	}
	else
	{
		alert(getMessage("OPERATION_PARTIAL","OR")+"\nFollowing orders are not redirected to the selected facility"+'\n'+message);
	}
	
	window.returnValue = "Y";
	window.close();
}

function updateSpecimenPerfLocn(orderChkObj,orderId,catalogCode,catalogDesc,orderTypeCode)
{
	var bean_id = "Or_SpecimenOrder" ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	if(orderChkObj.checked == true)
	{
		operation = "ADD";
		//document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) + 1;
	}
	else if(orderChkObj.checked == false)
	{
		operation = "REMOVE";
		//document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) - 1;
	}
	
	xmlStr ="<root><SEARCH " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id +"&p_order_id="+orderId+"&validate=UPDATE_PERF_LOCN&p_operation="+operation+"&p_catalog_code="+catalogCode+"&p_catalog_desc="+catalogDesc+"&p_order_type_code="+orderTypeCode, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )
}

function fillPerformingLocation(facilityObj) 
{
    if (facilityObj.value == "") 
	{
		clearChangePerformLocnList('document') ;
    } 
	else 
	{
        var formObj = document.register_order_perform_locn;
		var localeName=formObj.localeName.value;
        var validate = "";
    	var bean_id = formObj.bean_id.value ;
    	validate = "CHANGE_PERFORM_LOCN";   
		
		var xmlDoc = "" ;
    	var xmlHttp = new XMLHttpRequest() ;
    	xmlStr ="<root><SEARCH " ;
        xmlStr += "p_performing_facility=\""+ facilityObj.value +"\" " ;
    	xmlStr +=" /></root>" ;
    	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    	
		flag='true';
    	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate="+validate+'&flag='+flag+"&localeName="+localeName, false ) ;
    	xmlHttp.send( xmlDoc ) ;
    	responseText=xmlHttp.responseText ;
    	eval(responseText );
	}
}

function clearChangePerformLocnList( docObj )
{
	var len = eval(docObj+".register_order_perform_locn.performing_location.options.length") ;
	
	for(var i=0;i<len;i++)
	{
		eval(docObj+".register_order_perform_locn.performing_location.remove(\"atc_class_l2_code\")") ;
	}
	
	var tp = "   ---"+getLabel("Common.defaultSelect.label","Common")+"---      " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;

	eval(docObj+".register_order_perform_locn.performing_location.add(opt)") ;
}	

function addChangePerformLocnList(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.register_order_perform_locn.performing_location.add(element);
}

//IN33889,starts
function selectAllForLocnUpdate()
{
	totalRecs = document.getElementById("total_recs").value;
	var total = 0;
	
	for(rec_num=0;rec_num<totalRecs;rec_num++)
	{
		chkBoxObj = document.getElementById("select"+rec_num);
		
		if(chkBoxObj.disabled == false)
		{
			var order_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_id"+rec_num).value
			var order_catalog_code = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_catalog_code"+rec_num).value;
			var order_catalog_desc = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.catalogDesc"+rec_num).value;
			var order_type_code = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.order_type_code"+rec_num).value;
			updateSpecimenPerfLocn(chkBoxObj,order_id,order_catalog_code,order_catalog_desc,order_type_code);	
			total = parseInt(total) + 1;
		}
	}
	
	if(document.getElementById("check_all").checked == true)
	{
		document.getElementById("totalChecked").value = total;
	}
	else
	{
		document.getElementById("totalChecked").value = 0;
	}
}
//IN33889,ends
//IN048703 Starts
function updatePeriod()
{	
	var bean_id = document.specimen_order_search.bean_id.value ;
	var bean_name = document.specimen_order_search.bean_name.value ;
	var localeName = document.specimen_order_search.localeName.value ;
	
//	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	//var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH/></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&localeName="+templocale+"&validate=UPDATE_PERIOD", false ) ; //[SRR20056-SCF-9392 ] - IN037492 - IN056883
	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&localeName="+localeName+"&validate=UPDATE_PERIOD", false ) ; //[SRR20056-SCF-9392 ] - IN037492	- IN056883
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
function setPeriodValues(fromDate, toDate)
{
	document.specimen_order_search.date_from.value =fromDate;
	document.specimen_order_search.date_to.value =toDate;
}
//IN048703 End
//IN050209 - Start
function checkBillSettlementforCatalog(obj,order_id,order_catalog_code,order_catalog_desc,order_type_code,patient_class,patient_id,encounter_id,cnt)
{
	var bean_id = document.specimen_reporting_dtl.bean_id.value ;
	var bean_name = document.specimen_reporting_dtl.bean_name.value ;
	var localeName = document.specimen_reporting_dtl.localeName.value ;
	var ordering_facility = document.specimen_reporting_dtl.ordering_facility.value ;

//	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	//var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
    xmlStr += "ordering_facility=\""+ ordering_facility +"\" " ;
    xmlStr += "order_id=\""+ order_id +"\" " ;
    xmlStr += "order_type_code=\""+ order_type_code +"\" " ;
    xmlStr += "patient_class=\""+ patient_class +"\" " ;
    xmlStr += "patient_id=\""+ patient_id +"\" " ;
    xmlStr += "encounter_id=\""+ encounter_id +"\" " ;
    xmlStr += "rec_num=\""+ cnt +"\" " ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&localeName="+templocale+"&validate=CHECK_BILLSETTLEMENT", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

}
async function settlementPendingMsg(message,details,patient_id,encounter_id,facility_id,cnt)
{
	var dialogHeight ='60vh' ;
	var dialogWidth = '50vw' ;
	var dialogTop	= '250';
	var dialogLeft = '30' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

	var arguments = "";
	var finalString = "message="+escape(message)+"&details="+escape(details)+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&rec_num="+cnt;
	var result = await window.showModalDialog("../../eOR/jsp/SpecimenOrderBillDetails.jsp?"+finalString,arguments,features);	
	if(result)
	{	
		onSuccess();
	}	
	else
		deSelChkbox(cnt);
}
function amendUnbillLineRecord()
{
	eval(formApply( document.bill_unsettled_order,OR_CONTROLLER)) ;
	document.bill_unsettled_order.rec_res.value = true;
    window.close();
}
function deSelChkbox(cnt)
{
	var val = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+cnt);
	
	if(val.checked == true)
	{
		val.checked = false;
		parent.SpecimenOrderResult.document.getElementById("totalChecked").value = parseInt(parent.SpecimenOrderResult.document.getElementById("totalChecked").value) - 1; 
	}
}
function windowRet()
{
 	window.returnValue = document.bill_unsettled_order.rec_res.value;
}
//IN050209 - End
// added for IN052230
function setLatestDispSlipMapSize(selected_record){
	disp_slip_checked_count = selected_record; //IN0 55672 
}
function updateSelectedPatientList(patient_id, patientChkObj, specimen_num, order_id){
	var bean_id = "Or_SpecimenOrder" ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	if(patientChkObj.checked == true)
	{
		operation = "ADD";
		//document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) + 1;
	}
	else if(patientChkObj.checked == false)
	{
		operation = "REMOVE";
		//document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) - 1;
	}
		
	xmlStr ="<root><SEARCH " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id +"&p_patient_id="+patient_id+"&p_operation="+operation+"&p_specimen_num="+specimen_num+"&p_order_id="+order_id+"&validate=PRINT_DISPSLIP_SELECTED", false ) ;
	
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )
	
}
function addOrRemoveAllSpeicmen(patient_id, specimen_num, order_id, patientChkObj, start, end){
	//specimen_num = start+'|'+specimen_num;
	//alert(' Patient id ' + patient_id + " specimen_num " + specimen_num);
	var bean_id = "Or_SpecimenOrder" ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	if(patientChkObj == 'Y')
	{
		operation = "ADDALL";
		//document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) + 1;
	}
	else if(patientChkObj == 'N')
	{
		operation = "REMOVEALL";
		//document.getElementById("totalChecked").value = parseInt(document.getElementById("totalChecked").value) - 1;
	}
	xmlStr ="<root><SEARCH " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id +"&p_patient_id="+patient_id+"&p_operation="+operation+"&p_specimen_num="+specimen_num+"&p_order_id="+order_id+"&p_start="+start+"&p_end="+end+"&validate=PRINT_DISPSLIP_SELECTED", false ) ;
	
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText)
	
}
function displayDispatchSlipRecords(start, end, form_name, qryString){
	var formObj					= eval("document."+form_name);
	if(formObj){
		formObj.from.value		= start;
		formObj.to.value		= end;
		if (qryString != undefined && qryString != '')
		{
			parent.ConsentOrdersBottomRight1.document.location.href = '../../eOR/jsp/ConsentOrdersBottomRightDtl.jsp?'+qryString+'&from='+start+'&to='+end;
		}
		else
		{	
			formObj.submit();
		}
		//ends here.
 	} // End of formObj
} // End of displayRecords
//IN052230 - End
//IN055737 HSA-CRF-0250.1 - Start
function specimenBarCodeSearch() {
	if(top.content)
	    top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	if(checkLocationType()==false)
		return ;
	if(checkOrderType()==false)
		return ;
	var result  = true;
	formObj = parent.SpecimenOrderSearch.document.specimen_order_search;
	var specimen_num = formObj.specimen_no.value;
	var flds=new Array(formObj.patientId,formObj.order_id);
	var name=new Array(getLabel("Common.patientId.label","Common"),getLabel("Common.OrderID.label","COMMON"));
	
	if(formObj.collection_list.value == 'Y' || formObj.option_list.value == 'S') 
	{
		if(!checkFieldLocal(formObj.print_loc,getLabel("eOR.PrintLocation.label","OR"))) 
		{			
			parent.SpecimenOrderResult.location.href='../../eCommon/html/blank.html';
			parent.SpecimenOrderBtn.location.href='../../eCommon/html/blank.html';
			formObj.loctype.focus();
			return false;
		}
	}
	
	if(formObj.encounter_id.value!="") 
	{
	  	if(CheckForNumber(formObj.encounter_id.value)==true) 
		{
			result = true;
		}
		else result = false;
  	}
	if(SpecialCharCheck(flds,name,parent.document.messageFrame,"A","../../eCommon/jsp/MstCodeError.jsp"))
	{
		if(!isAfter(formObj.date_to.value,formObj.date_from.value,"DMYHM",parent.SpecimenOrderSearch.formObj.language.value))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			parent.SpecimenOrderResult.location.href='../../eCommon/html/blank.html';
			parent.SpecimenOrderBtn.location.href='../../eCommon/html/blank.html';
			return false;
		}

		var insButtVal = "";
		if(parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "R" || parent.SpecimenOrderSearch.document.specimen_order_search.option_list.value == "S")
		{
			insButtVal = getLabel("Common.Reprint.label","COMMON");
		}
		if(parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time.value==undefined)
		{
			parent.SpecimenOrderSearch.document.specimen_order_search.collection_list_date_time.value="N";
		}
		
		if(result) 
		{			
			var bean_id = "Or_SpecimenOrder" ;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			operation = "SPECIMEN_BARCODE_SEARCH";
			xmlStr ="<root><SEARCH " ;	
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id +"&p_specimen_num="+specimen_num+"&validate=SPECIMEN_BARCODE_SEARCH", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText )
      	}
	}
}
function isBarCodeSpecimenAdded(specimenAdded, specimenNo, cloneMapSize){
	if(cloneMapSize > 0) {
		if(specimenAdded == 'SPECIMEN_ADDED'){
			message = getMessage("SPECIMENNO_SELECTED","OR");
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			for(var i=0; i<7; i++){ 
				if(!(typeof(parent.SpecimenOrderResult.document.specimen_reporting_dtl) == 'undefined')) { 
					if(!(typeof(eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_no" + i))=='undefined')) {  
						if(eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_no" + i).value == specimenNo) { 
							eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select" + i).checked = true;
						}
					}
				}	
			}
			
		} else if(specimenAdded == 'SPECIMEN_NA') {
			message = getMessage("SPECIMENNO_IS_NOT_AVAIL","OR");
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		}  else if(specimenAdded == 'SPECIMEN_EXIST') {
			message = getMessage("SPECIMENNO_ALREADY_SELECTED","OR");
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		}
	}	
}
//IN055737 HSA-CRF-0250.1 - End
// ML-MMOH-CRF-0540 [IN061888] - Start 
function checkAllRecCollection(obj){
	var localeName = parent.SpecimenOrderResult.document.specimen_reporting_dtl.localeName.value;
	var total_recs = parent.SpecimenOrderResult.document.specimen_reporting_dtl.total_recs.value;
	if(obj.checked == true ) {
		for(var rec_num = 0; rec_num<total_recs; rec_num++){
			val = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+rec_num);
			var specimen_date_time = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value
			var collected_by		= eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+rec_num).value
			var bean_id = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.bean_id").value
			var bean_name = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.bean_name").value
			var returnVal = "";
			var rec_coll_individual_check_yn = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.rec_coll_individual_check_yn"+rec_num).value;
			if(rec_coll_individual_check_yn=="Y") 
			{	
				val.checked = true;
				val.value = "Y"
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlStr ="<root><SEARCH " ;	 
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?specimen_date_time=" + specimen_date_time +"collected_by="+collected_by+"&bean_id="+bean_id+"&bean_name="+bean_name+"&localeName="+localeName+"&validate=MULTI_CHECK_REC_COL", false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				var returnVal =  eval(responseText );
				if (returnVal != null) 
				{
					if (returnVal.length != 0) 
					{	
						var spec_details = returnVal.split(',');
						eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.collected_by"+rec_num).value = spec_details[0]
						eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = spec_details[1]
					}
				} 
				else 
				{
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+rec_num).checked = false
					eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.specimen_date_time"+rec_num).value = ""
				}
			}
		}
	} else{
		for(var rec_num = 0; rec_num<total_recs; rec_num++){
			val = eval("parent.SpecimenOrderResult.document.specimen_reporting_dtl.select"+rec_num);
			val.checked = false;
			val.value = "N"
		}		
	}	
}
//ML-MMOH-CRF-0540 [IN061888] - End
//IN063974 starts
async function showPhoto(count)
{
	var patient_id=eval("document.specimen_reporting_dtl.patient_id"+count+".value");
	if(BrowserVersion()<=6){
				var center = "1" ;
				var dialogHeight= "30vh" ;
				var dialogWidth = "40vw" ;
			}else{
				var center = "1" ;
				var dialogHeight= "40vh" ;
				var dialogWidth = "50vw" ;
			}
			var myFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";center: " + center + ";status=no; scroll=no";
			var arguments = "" ;
			var imageWindow =await  top.window.showModalDialog( '../../eMP/jsp/ViewPatientImage.jsp?patient_id='+patient_id+"&BrowserVersion="+BrowserVersion()+"&title=Photo", 'eHISMain', myFeatures ) ;

}
//IN063974 ends
//Adding start for IN072184

function barcodeScan(evnt,pat_id){
	var keyVal	= parseInt(evnt.keyCode);
	 var bar_code_site_yn = document.specimen_order_search.bar_code_scan_site_YN.value;
	   if(bar_code_site_yn =="Y" && pat_id.value!="" && pat_id.value.length>1 && keyVal==17){
		  document.specimen_order_search.bar_code_scaned_YN.value="Y";
	   }else{
		    if(document.specimen_order_search.bar_code_scaned_YN.value == "" )//Added for testing issue Raised by IN072994
		   document.specimen_order_search.bar_code_scaned_YN.value="N";
		   }
		 
}

async function callManualScanRemarks(patient_id,encounter_id,patient_class,remarks_mandetory_yn,option_list){//patient_id,encounter_id,patient_class,entry_type added for IN072994
	var formObj = parent.SpecimenOrderResult.document.specimen_reporting_dtl;
	var bean_id      =  formObj.bean_id.value;
	var bean_name    =  formObj.bean_name.value;
	var module_id    = "OR";
	var menu_id      = "SPECIMEN_ORDERS"
	var sub_menu_id  = "";
	if(option_list == 'N')
		sub_menu_id ="NEW_LIST";
	else if( option_list == 'C')
		sub_menu_id ="RECORD_COLLECTION";
	else if (option_list == 'D')
		sub_menu_id = "RECOD_DISPATCH";
	var entry_type   ="M";

	var retVal = new String();
	var dialogHeight= "90vh" ;                                                 
	
	var dialogWidth              = "80vh" ;

	var status = "no";                                             
	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status; 
	retVal =await window.showModalDialog("../../eOR/jsp/BarCodeManualEntryReason.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&module_id="+module_id+"&menu_id="+menu_id+"&sub_menu_id="+sub_menu_id+"&entry_type="+entry_type+"&remarks_mandetory_yn="+remarks_mandetory_yn+"&patient_class="+patient_class,arguments,features);
	//alert("retVal@@@111==="+retVal)//+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&module_id="+module_id+"&sub_menu_id="+sub_menu_id
		return retVal;

}
function scanBarcodeCount(patient_id,encounter_id,patient_class,entry_type,option_list){//patient_id,encounter_id,patient_class,entry_type added for IN072994
	var retVal = "";
	var formObj = parent.SpecimenOrderResult.document.specimen_reporting_dtl;
	//var patient_id   =  formObj.patientId.value;//Coomented foor IN072994
	//var encounter_id  =	formObj.encounter_id.value;//Coomented foor IN072994
	var bean_id      =  formObj.bean_id.value;
	var bean_name    =  formObj.bean_name.value;
	var module_id    = "OR";
	var menu_id      = "SPECIMEN_ORDERS"
	//var entry_type   ="S";
	var sub_menu_id  = "";
	if(option_list == 'N')
		sub_menu_id ="NEW_LIST";
	else if( option_list == 'C')
		sub_menu_id ="RECORD_COLLECTION";
	else if (option_list == 'D')
		sub_menu_id = "RECOD_DISPATCH";


		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " patient_id=\""+patient_id+"\"";
		xmlStr += " encounter_id=\""+encounter_id+"\"";
		xmlStr += " menu_id=\""+menu_id+"\"";
		xmlStr += " module_id=\""+module_id+"\"";
        xmlStr += " entry_type=\""+entry_type+"\"";
		xmlStr += " sub_menu_id=\""+sub_menu_id+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr += " patient_class=\""+patient_class+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open("POST","../../eOR/jsp/BarCodeManualEntryReasonSave.jsp?",false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText;
		return true;
}


//Adding emd for IN072184
//Added forr IN072994
function callBarCodeCount(patient_id,option,patClassList,patClassEncList,barcode_scaned_yn){

    var bean_id = parent.SpecimenOrderResult.document.specimen_reporting_dtl.bean_id.value ;
	var bean_name = parent.SpecimenOrderResult.document.specimen_reporting_dtl.bean_name.value ;
//	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
    xmlStr += "patient_id=\""+ patient_id +"\" " ;
    xmlStr += "patClassList=\""+ patClassList +"\" " ;
    xmlStr += "barcode_scaned_yn=\""+ barcode_scaned_yn +"\" " ;
    xmlStr += "option=\""+ option +"\" " ;
    xmlStr += "patClassEncList=\""+ patClassEncList +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SpecimenCollectionListAndLabelValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&patClassEncList="+patClassEncList+"&validate=BARCODE_SCANCOUNT", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}//Adding end for IN072994


function getQUEPKICode(obj){
	
	if(obj.value!=null && obj.value!=""){
		//var responseToken = "S$!^SUCCESS$!^1$!^105$!^09/11/2022 10:05:00$!^ 9/11/2022 10:05:00"; 
		var responseToken = getTokenDetails("SPECOL", document.getElementById("ordering_facility").value, document.getElementById("quePkiId").value, document.getElementById("patientId").value,document.getElementById("encounter_id").value,document.getElementById("userId").value)
		document.getElementById("quePkiToken").value=responseToken;
		var queArr=responseToken.split("$!^");
		document.getElementById("quePkiStatus").value=queArr[0];
		document.getElementById("quePkiStatusText").value=queArr[1];
		document.getElementById("quePkiNumber").value=queArr[3];
		document.getElementById("quePkiIsueDateTime").value=queArr[4];
		document.getElementById("quePkiCallDateTime").value=queArr[5];
		if(queArr[0]=="S"){
			document.getElementById("quePkiIdMessage").innerHTML="<B style='color:green;'> ( Info : Token dispensed details received successfully )</B>";
		}else if(queArr[0]=="F"){
			document.getElementById("quePkiIdMessage").innerHTML="<B style='color:red;'> ( Info : Invalid primary key. Token dispensed details could not be received )</B>";
		}
	}else{
		document.getElementById("quePkiStatus").value="";
		document.getElementById("quePkiStatusText").value="";
		document.getElementById("quePkiToken").value="";
		document.getElementById("quePkiNumber").value="";
		document.getElementById("quePkiIsueDateTime").value="";
		document.getElementById("quePkiCallDateTime").value="";
		document.getElementById("quePkiIdMessage").innerHTML="<B style='color:red;'> ( Info : Token dispensed details could not be received )</B>";
		alert ("Token dispensed details cannot be captured as primary key of queue no is blank.");
	}
}

