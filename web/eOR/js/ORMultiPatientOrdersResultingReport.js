/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// Setting the default Location Type
function defaultLocationType()
{
	//document.forms[0].location_type.value="N";
	document.forms[0].location_type.value="";
	populateLocation(document.forms[0].location_type);
}
//This function will Dyanmically populate the location type 
function populateLocation(location_type)
{
	// Clear the location list
	clearList();
	// removing all the frames
	removeFrames();
	var bean_id = document.multiPatientOrdersResultingHdr.bean_id.value ;
	var bean_name = document.multiPatientOrdersResultingHdr.bean_name.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
 	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ORMultiPatientOrdersResultingFillTypes.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=locn_type", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	/*Commented by Uma on 1/25/2010 for IN018345*/
	/*if(location_type.value=="" || location_type.value==null)
		document.multiPatientOrdersResultingHdr.locn.selectedIndex = 0;
	else
		document.multiPatientOrdersResultingHdr.locn.selectedIndex = 1;*/
	/*Ends Here*/
}

//This function is used to clear the location used on change of location_type 
function clearList( ) 
{
	var len = eval("document.multiPatientOrdersResultingHdr.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.multiPatientOrdersResultingHdr.locn.remove(\"atc_class_l2_code\")") ;
	}
	//var tp 		= "---All--- " ;
	var tp = "     --- "+getLabel("Common.all.label","Common")+" ---     " ;	
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.multiPatientOrdersResultingHdr.locn.add(opt)") ;
}

//This function is used to add the location used on change of location_type dynamically
function addLocationList(code,value) 
{
	var element = document.createElement('OPTION') ;	
	element.value =  code ;
	element.text = value ;
	document.multiPatientOrdersResultingHdr.locn.add(element);
}


//This will Dyanmically populate the Order Types on change of the Order Type
function fillOrderTypes(order_category)
{
	clearOrderTypeList();
	var bean_id = document.multiPatientOrdersResultingHdr.bean_id.value ;
	var bean_name = document.multiPatientOrdersResultingHdr.bean_name.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
 	xmlStr ="<root><SEARCH " ;
	xmlStr += order_category.name+"=\""+ order_category.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ORMultiPatientOrdersResultingFillTypes.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=order_type", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	clearFields();
	removeFrames();
}

//This function is used to clear the Order Type used on change of order_category 
function clearOrderTypeList( ) 
{
	var len = eval("document.multiPatientOrdersResultingHdr.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.multiPatientOrdersResultingHdr.order_type.remove(\"atc_class_l2_code\")") ;
	}	
	var tp = "     --- "+getLabel("Common.all.label","Common")+" ---     " ;	
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.value 	= "" ;
	opt.text 	= tp ;
	eval("document.multiPatientOrdersResultingHdr.order_type.add(opt)") ;
}

//This function is used to add the Order Type used on change of order_category dynamically
function addOrderTypeList(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.multiPatientOrdersResultingHdr.order_type.add(element);
}

// This function is used to clear the fields
function clearFields()
{
	document.multiPatientOrdersResultingHdr.order_catalog.value="";
	document.multiPatientOrdersResultingHdr.order_catalog_code.value="";
	document.multiPatientOrdersResultingHdr.temp_order_catalog.value="";
	document.multiPatientOrdersResultingHdr.result_format.value="";
	document.multiPatientOrdersResultingHdr.order_resultFormat_code.value="";
	document.multiPatientOrdersResultingHdr.temp_resultFormat.value="";
}

// This function is used to clear all the frames
function removeFrames()
{
	parent.multiPatientOrdersResultingHdrDtl.location.href="../../eCommon/html/blank.html";
	parent.multiPatientOrdersResultingHdrResult.location.href="../../eCommon/html/blank.html";
	parent.multiPatientOrdersResultingHdrButtons.location.href="../../eCommon/html/blank.html";
}
// function for catalog look-up 
function show_catalog_lookup(target,code,tempdesc)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var title= getLabel("Common.ordercatalog.label","COMMON");
	var order_category = document.forms[0].order_category.value;
	var localeName =document.multiPatientOrdersResultingHdr.localeName.value;
	var message="";
	if(order_category=='')
	{
		message=getMessage( "ORDER_CATEGORY","OR" );
		alert(message);
		return;
	}
	var order_type = document.forms[0].order_type.value;
	var sql = document.forms[0].catalog_lookup_sql.value;
	sql = sql.replace("?","'"+localeName+"'");
	sql = sql.replace("?","'"+order_category+"'");
	sql = sql.replace("?","'"+trimString(order_type)+"'");

	argumentArray[0] = sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	if(target.value=="?")
	{
		argumentArray[5]= "";
	}
	else
	{
		argumentArray[5]=target.value;
	}
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;
	
	//retval=CommonLookup("Catalog",argumentArray);
	retval=CommonLookup(title,argumentArray);
	if(retval !=null && retval != "")
	{
		code.value=retval[0];
		target.value=retval[1];
		tempdesc.value=retval[1];
	}
}

// function for onblur of catalog look-up
function before_show_catalog_lookup(target,code,tempdesc)
{
	 
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	if(target.value != tempdesc.value) 
	{
		if(target.value!="")
		{
			show_catalog_lookup(target,code,tempdesc);
		}
		else
		{
			target.value="";
			code.value="";
			tempdesc.value="";
		}
	}
}

// function for result_format look up
function show_resultFormat_lookup(target,code,tempdesc)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var title= getLabel("eOR.ResultFormat.label","OR");
	var order_category = document.forms[0].order_category.value;
	var message="";
	if(order_category=='')
	{
		message=getMessage( "ORDER_CATEGORY","OR" );
		alert(message);
		return;
	}

	var order_type = document.forms[0].order_type.value;

	var sql = document.forms[0].result_format_lookup_sql.value;
	sql = sql.replace("?","'"+order_category+"'");
	sql = sql.replace("?","'"+trimString(order_type)+"'");

	argumentArray[0] = sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	if(target.value=="?")
	{
		argumentArray[5]= "";
	}
	else
	{
		argumentArray[5]=target.value;
	}
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;
	
	//retval=CommonLookup("Catalog",argumentArray);
	retval=CommonLookup(title,argumentArray);
	if(retval !=null && retval != "")
	{
		code.value=retval[0];
		target.value=retval[1];
		tempdesc.value=retval[1];
	}
}
// function for onblur of result_format look-up
function before_show_resultFormat_lookup(target,code,tempdesc)
{
	 
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	if(target.value != tempdesc.value) 
	{
		if(target.value!="")
		{
			show_resultFormat_lookup(target,code,tempdesc);
		}
		else
		{
			target.value="";
			code.value="";
			tempdesc.value="";
		}
	}
}

// function for date check range
function checkDateRange(obj,from)
{
	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")

	if(doDateCheckOR(fromDate,toDate) == 1) 
	{ // this function is available in eOR/js/orCommonFunctions.js
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
		obj.focus()
		return false
	}
}

// function for search
function searchValues()
{
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	document.getElementById("result_check_boxes").innerText='';

	var message="";
	var location_type = formObj.location_type.value;
	/*var locn = formObj.locn.value;*/
	var locn = parent.multiPatientOrdersResultingHdr.document.getElementById('locn').value;
	//console.log(locn);
	locn='';
	var period_from = formObj.period_from.value;
	var period_to = formObj.period_to.value;
	var order_category = formObj.order_category.value;
	var order_type = formObj.order_type.value;
	var result_format = formObj.order_resultFormat_code.value;
	var order_catalog = formObj.order_catalog_code.value;
	var group_by = formObj.group_by.value;
	var count = 0;
	var bean_id = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value;
	
	if(period_from==null || period_from=="")
	{
		message=getMessage("FROM_DATE_CANNOT_BE_BLANK","SM")+ "<BR>";
		count++;
	}
	if(period_to==null || period_to=="")
	{
		message=message + getMessage("TO_DT_NOT_BLANK","SM") + "<BR>";
		count++;
	}
	if(order_category==null || order_category=="")
	{
		message= message + getMessage( "ORDER_CATEGORY","OR")  ;
		count++;
	}
	if(count > 0)
	{
		top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+ message;
		return;
	}
	else
	{
		top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp";
	
		if(result_format==null || result_format=="")
		{
			//parent.document.all.main_frame.rows = '19%,5%,74%, 4%';
			parent.document.getElementById("multiPatientOrdersResultingHdr").style.height="18vh";
			parent.document.getElementById("multiPatientOrdersResultingHdrDtl").style.height="5vh";
			parent.document.getElementById("multiPatientOrdersResultingHdrResult").style.height="71vh";
			parent.document.getElementById("multiPatientOrdersResultingHdrButtons").style.height="22vh";

			parent.multiPatientOrdersResultingHdrDtl.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingHdrDtl.jsp?location_type="+location_type+"&locn="+locn+"&period_from="+period_from+"&period_to="+period_to+"&order_category="+order_category+"&order_type="+order_type+"&result_format="+result_format+"&order_catalog="+order_catalog+"&group_by="+group_by;
		}
		else
		{
			parent.document.main_frame.rows = '19%,0%,77%, 4%';
			parent.multiPatientOrdersResultingHdrDtl.location.href="../../eCommon/html/blank.html";
		}
		parent.multiPatientOrdersResultingHdrResult.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingHdrResult.jsp?location_type="+location_type+"&locn="+locn+"&period_from="+period_from+"&period_to="+period_to+"&order_category="+order_category+"&order_type="+order_type+"&result_format="+encodeURIComponent(result_format)+"&order_catalog="+encodeURIComponent(order_catalog)+"&group_by="+group_by;
		parent.multiPatientOrdersResultingHdrButtons.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingHdrButtons.jsp"
	}
	document.multiPatientOrdersResultingHdr.search.disabled = true;		
}

function clearValues()
{
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp";
	parent.multiPatientOrdersResultingHdrDtl.location.href="../../eCommon/html/blank.html";
	parent.multiPatientOrdersResultingHdrResult.location.href="../../eCommon/html/blank.html";
	parent.multiPatientOrdersResultingHdrButtons.location.href="../../eCommon/html/blank.html";
	formObj.submit();
}

function clickAll()
{
	var formObj = parent.multiPatientOrdersResultingHdrResult.document.multiPatientOrdersResultingHdrResult;
	var count = formObj.page_count.value;
	var groupCount = formObj.group_count.value;
	
	var fm_disp = document.forms[0].fm_disp.value;
	var to_disp = document.forms[0].to_disp.value;
	count = eval(count);
	groupCount = eval(groupCount);

	if(formObj.CheckMultiOrderPatient1.checked==true)
	{
		var message = '';
		for(i=parseInt(fm_disp);i<=parseInt(to_disp);i++)
		{
			val = eval("formObj.CheckMultiPatientOrdersResulting"+i);
			val.checked=true;

			var order_id = eval("document.forms[0].order_id"+i);
			var order_line_num = eval("document.forms[0].order_line_num"+i);
			//message = getBillingMessage(val,order_id.value,order_line_num.value);
			if(message!='')
			{
				val.checked=false;
				formObj.CheckMultiOrderPatient1.checked=false;
				break;
			}
		}
		if(message=='')
		{
			for(i=1;i<=groupCount;i++)
			{
				val = eval("formObj.select_group"+i);
				val.checked=true;
			}
		}
	}
	else
	{
		for(i=parseInt(fm_disp);i<=parseInt(to_disp);i++)
		{
			val = eval("formObj.CheckMultiPatientOrdersResulting"+i);
			val.checked=false;
		}
		for(i=1;i<=groupCount;i++)
		{
			val = eval("formObj.select_group"+i);
			val.checked=false;
		}
	}
}

function selectGroup(count)
{
	var check = eval("document.forms[0].select_group"+count);	
	var tot = eval("document.forms[0].indGrpCount"+count);
	var indGrpCount = eval(tot.value); 
	if(check.checked==true)
	{
		for(i=1;i<=indGrpCount;i++)
		{
			
			var val = eval("document.forms[0].checkId"+count+i);
			val.checked=true;
			var order_id = eval("document.forms[0].order_check_id"+count+i);
			var order_line_num = eval("document.forms[0].order_line_num_check_id"+count+i);			
			var message = '';//getBillingMessage(val,order_id.value,order_line_num.value);
			if(message!='')
			{
				val.checked=false;
				check.checked=false;
				break;
			}
		}
	}
	else
	{
		for(i=1;i<=indGrpCount;i++)
		{
			var val = eval("document.getElementById('checkId')"+count+i)
			val.checked=false;
		}
		//added for deselecting the selectAll chkbox
		deselectAllChk(count);
	}
		
		//added for autoselecting the selectAll chkbox--starts
		autoSelectAll();
		//added for autoselecting the selectAll chkbox--ends
}
function autoSelectAll()
{
		var groupCount = document.forms[0].group_count.value;	
		groupCount = eval(groupCount);
		var tmpCount=0;
		for(i=1;i<=groupCount;i++)
		{
		val = eval("document.forms[0].select_group"+i);			
		if(val.checked==true)
			tmpCount++;
		}		
		if(tmpCount==groupCount)
		{
			var check = eval("document.forms[0].CheckMultiOrderPatient1");
			if(check.checked==false)
				check.checked=true;
		}
}

//function for deselecting the header chkboxes
function deselectHeaderChk(count)
{
	var tot = eval("document.forms[0].indGrpCount"+count);
	var indGrpCount = eval(tot.value);	
	var tempCount=0;
	for(i=1;i<=indGrpCount;i++)
	{
		var val=eval("document.forms[0].checkId"+count+i);
		if(val.checked==true)
			tempCount++;
	}	
	var check = eval("document.forms[0].select_group"+count);
	if(tempCount<indGrpCount)
	{		
		if(check.checked==true)
			check.checked=false;
	}else if(tempCount==indGrpCount)
	{
		if(check.checked==false)
		{
			check.checked=true;
			autoSelectAll();
		}
	}
	deselectAllChk(count);
}


//function for deselecting the selectAll chkboxes
function deselectAllChk(count)
{
	var check = eval("document.forms[0].select_group"+count);	
	var groupCount = document.forms[0].group_count.value;	
	groupCount = eval(groupCount);
	var tempCount=0;
	for(i=1;i<=groupCount;i++)
	{
		val = eval("document.forms[0].select_group"+i);			
		if(val.checked==true)
			tempCount++;
	}
	if(tempCount<groupCount)
	{			
		var check = eval("document.forms[0].CheckMultiOrderPatient1");
		if(check.checked==true)
			check.checked=false;
	}
}

// function for loading the result frame
function loadResultFrame(result_format,count,result_type)
{
	var formObj = parent.multiPatientOrdersResultingHdrDtl.document.multiPatientOrdersResultingHdrDtl;

	var headerObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	parent.multiPatientOrdersResultingHdr.document.getElementById('result_check_boxes').innerText='';

	var location_type = headerObj.location_type.value;
	var locn = headerObj.locn.value;
	var period_from = headerObj.period_from.value;
	var period_to = headerObj.period_to.value;
	var order_category = headerObj.order_category.value;
	var order_type = headerObj.order_type.value;
	var order_catalog = headerObj.order_catalog.value;
	var group_by = headerObj.group_by.value;
	var result_format_count = formObj.result_format_count.value;
	result_format_count=eval(result_format_count);
	if(order_type=='null')
		order_type="";
	for(i=0;i<result_format_count;i++)
	{
		if(! (i > 2))
		{
			val = parent.multiPatientOrdersResultingHdrDtl.document.getElementById('tab'+i);
			if(i==count)
			{
				val.className = "CASECONDSELECTHORZ";
				if(result_format_count > 3)
				{
					formObj.result_format.value = "";
				}
			}
			else
			{
				val.className = "CAFIRSTSELECTHORZ";
			}
		}
	}
	parent.multiPatientOrdersResultingHdrResult.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingHdrResult.jsp?location_type="+location_type+"&locn="+locn+"&period_from="+period_from+"&period_to="+period_to+"&order_category="+order_category+"&order_type="+order_type+"&result_format="+encodeURIComponent(result_format)+"&order_catalog="+order_catalog+"&group_by="+group_by+"&result_type="+result_type;
	parent.multiPatientOrdersResultingHdrButtons.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingHdrButtons.jsp"
}

// function for calling the result load frame
function callLoadResultFrame(obj)
{
	val = obj.value.split("::");
	var result_format = val[0];
	var count = val[1];
	var result_type = val[2];
	loadResultFrame(result_format,count,result_type);
}

// function for displaying the records in new page for result entry reporting
function resultValues()
{
	var formObj = parent.multiPatientOrdersResultingHdrResult.document.multiPatientOrdersResultingHdrResult;
	var headerObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;

	var total_records = formObj.total_count.value;
	var result_format = formObj.result_format.value;
	var result_type = formObj.result_type.value;
	total_records = eval(total_records);
	
	HTMLtext='';
	for(j=0;j<parseInt(total_records);j++)
	{
		var header_val = eval("headerObj.select_yn"+j);
		HTMLtext=HTMLtext+'<input type=hidden name=select_yn'+j+ ' value="'+header_val.value+'">';
	}
	parent.multiPatientOrdersResultingHdrResult.document.getElementById('select_yn').insertAdjacentHTML("beforeend",HTMLtext);


	var testCount = 0;
	var params;
	var ivalue;
	var order_values;
	for(i=0;i<total_records;i++)
	{
		var checked_item = eval("headerObj.select_yn"+i);
		if(checked_item.value!="N")
		{
			if(testCount==0)
			{
				order_values = checked_item.value; 
		//		ivalue = i;
			}
			else
			{
				order_values += ","+checked_item.value; 
		//		ivalue+= "||" + i;
			}
			testCount++;
		}
	}
	if(testCount==0)
	{
		alert(getMessage( "CLICK_ANY_ONE","OR" ));
		return;
	}
	else
	{
		ivalue = "Exists";
	}

	var location_type = headerObj.location_type.value;
	var locn_hdr = headerObj.locn.value;
	var header_locn_index	= headerObj.header_locn_index.value;
	if(header_locn_index=='' || header_locn_index==null)
		header_locn_index = "1";
	var period_from = headerObj.period_from.value;
	var period_to = headerObj.period_to.value;
	var order_category = headerObj.order_category.value;
	var order_type = headerObj.order_type.value;
	var order_catalog = headerObj.order_catalog.value;
	var order_catalog_code = headerObj.order_catalog_code.value;
	var temp_order_catalog = headerObj.temp_order_catalog.value;
	var order_resultFormat_code = headerObj.order_resultFormat_code.value;
	var order_resultFormat_desc = headerObj.result_format.value;
	var group_by = headerObj.group_by.value

	var header_values="~~~";

	if(location_type==null || location_type=="")
		header_values += " " + "~~~";
	else
		header_values += location_type + "~~~";

	if(locn_hdr==null || locn_hdr=="")
		header_values += " " + "~~~";
	else
		header_values += locn_hdr + "~~~";

	if(period_from==null || period_from=="")
		header_values += " " + "~~~";
	else
		header_values += period_from + "~~~";

	if(period_to==null || period_to=="")
		header_values += " " + "~~~";
	else
		header_values += period_to + "~~~";

	if(order_category==null || order_category=="")
		header_values += " " + "~~~";
	else
		header_values += order_category + "~~~";

	if(order_type==null || order_type=="")
		header_values += " " + "~~~";
	else
		header_values += order_type + "~~~";

	if(order_catalog==null || order_catalog=="")
		header_values += " " + "~~~";
	else
		header_values += order_catalog + "~~~";

	if(order_catalog_code==null || order_catalog_code=="")
		header_values += " " + "~~~";
	else
		header_values += order_catalog_code + "~~~";

	if(temp_order_catalog==null || temp_order_catalog=="")
		header_values += " " + "~~~";
	else
		header_values += temp_order_catalog + "~~~";

	if(order_resultFormat_code==null || order_resultFormat_code=="")
		header_values += " " + "~~~";
	else
		header_values += order_resultFormat_code + "~~~";

	if(group_by==null || group_by=="")
		header_values += " " + "~~~";
	else
		header_values += group_by + "~~~";

	
	group_by
	
	if(order_resultFormat_desc==null || order_resultFormat_desc=="")
		header_values += " " + "~~~";
	else
		header_values += encodeURIComponent(order_resultFormat_desc) + "~~~";
	header_values = header_values + ivalue;
	header_values = header_values + "~~~" + header_locn_index;
	formObj.target=top.content.workAreaFrame.name;
	formObj.method	= "post";
	formObj.action = "../../eOR/jsp/ORMultiPatientOrdersResultingFrameSet.jsp?count="+testCount+"&result_format="+encodeURIComponent(result_format)+"&result_type="+result_type+"&header_values="+header_values;
	formObj.submit();
}

// function for loading the multiPatientOrdersResultingMainResultData frame
function loadResultingMainResult0(values,text_area_exists)
{
	var buttonObj = parent.multiPatientOrdersResultingMainHdrButtons.document.multiPatientOrdersResultingHdrButtons;
	if(parent.multiPatientOrdersResultingMainHdrButtons.document.getElementById('populate'))
	{
		buttonObj.populate.disabled=true;
	}
	parent.multiPatientOrdersResultingMainResultData.location.href = "../../eOR/jsp/ORMultiPatientOrdersResultingMainResultData.jsp?"+values+"&text_area_exists="+text_area_exists;
}

// function  for loading multiPatientOrdersResultingMainResultValues frame
function loadResultingMainResult1()
{
	var formObj				= parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var resultObj			= parent.multiPatientOrdersResultingMainResultData.document.multiPatientOrdersResultingMainResult;


	var total_values		= formObj.total_values.value;
	var total_records_count = formObj.total_records_count.value;
	var discrete_count		= parseInt(total_values);
	var result_format		= formObj.result_format.value;
	var main_result_type	= formObj.main_result_type.value
//	var params;
	var discrete_desc;
	for (i=0;i<discrete_count ; i++)
	{
		//var discrete_measure_id		= eval("formObj.discrete_measure_id"+i);
		var discrete_measure_desc	= eval("formObj.discrete_measure_desc"+i);
		//var result_type				= eval("formObj.result_type"+i);
		//var max_digits				= eval("formObj.max_digits"+i);
		//var min_digits				= eval("formObj.min_digits"+i);
		//var dec_digits				= eval("formObj.dec_digits"+i);
		//var mandatory				= eval("formObj.mandatory"+i);
		//var unit_of_msr				= eval("formObj.unit_of_measure"+i);*/

		if(i==0)
		{

			discrete_desc = encodeURIComponent(discrete_measure_desc.value);
			//params = "discrete_measure_id"+i+"="+discrete_measure_id.value+"&discrete_measure_desc"+i+"="+encodeURIComponent(discrete_measure_desc.value)+"&result_type"+i+"="+result_type.value+"&max_digits"+i+"="+max_digits.value+"&min_digits"+i+"="+min_digits.value+"&dec_digits"+i+"="+dec_digits.value+"&mandatory"+i+"="+mandatory.value+"&unit_of_msr"+i+"="+unit_of_msr.value;
		}	
		else
		{
			//params += "&discrete_measure_id"+i+"="+discrete_measure_id.value+"&discrete_measure_desc"+i+"="+encodeURIComponent(discrete_measure_desc.value)+"&result_type"+i+"="+result_type.value+"&max_digits"+i+"="+max_digits.value+"&min_digits"+i+"="+min_digits.value+"&dec_digits"+i+"="+dec_digits.value+"&mandatory"+i+"="+mandatory.value+"&unit_of_msr"+i+"="+unit_of_msr.value;

			discrete_desc += ":::" + encodeURIComponent(discrete_measure_desc.value);
		}
	}
	
	var from		= resultObj.temp_from.value;
	var to			= resultObj.temp_to.value;
	var dispMode	= resultObj.temp_dispMode.value;
	//parent.multiPatientOrdersResultingMainResultValues.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingMainResultValues.jsp?discrete_count="+discrete_count+"&total_records_count="+total_records_count+"&discrete_desc="+discrete_desc+"&"+params+"&from="+from+"&to="+to+"&dispMode="+dispMode;
	parent.multiPatientOrdersResultingMainResultValues.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingMainResultValues.jsp?discrete_count="+discrete_count+"&total_records_count="+total_records_count+"&discrete_desc="+discrete_desc+"&from="+from+"&to="+to+"&dispMode="+dispMode+"&result_format="+result_format+"&main_result_type="+main_result_type;
}
// function for clearing the user entered values
function clearHeaderValues()
{
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var total_values = formObj.total_values.value;
	var discrete_count = parseInt(total_values);
	formObj.srv_status.value = "Normal";
	formObj.rslt_type.value = "";
	for (i=0;i<discrete_count ; i++)
	{
		var result_type = eval("formObj.result_type"+i);
		result_type = result_type.value;

		if(result_type == "N" || result_type == "I")
		{
			data_value = eval("formObj.number_type"+i);
			data_value.value = "";
		}
		else if(result_type == "C")
		{
			data_value = eval("formObj.check_type"+i);
			data_value.checked = false;
		}
		else if(result_type == "E")
		{
			data_value = eval("formObj.date_hour_type"+i);
			data_value.value = "";
		}
		else if(result_type == "D")
		{
			data_value = eval("formObj.date_type"+i);
			data_value.value = "";
		}
		else if(result_type == "L")
		{
			data_value = eval("formObj.list_type"+i);
			data_value.value = "";
		}
		else if(result_type == "F")
		{
			data_value = eval("formObj.long_text"+i);
			data_value.value = "";
		}
		else if(result_type == "T")
		{
			data_value = eval("formObj.time_type"+i);
			data_value.value = "";
		}
		else if(result_type == "H")
		{
			data_value = eval("formObj.short_text_type"+i);
			data_value.value = "";
		}

		var srv_stat = eval("formObj.srv_stat"+i);
		srv_stat.value = "N";
	}
}
// function for loading the user entered values in the multiPatientOrdersResultingMainResultValues frame
function loadMainResultFrameValues()
{
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var resultObj = parent.multiPatientOrdersResultingMainResultValues.document.multiPatientORMainResultValues;
	
	var total_values = formObj.total_values.value;
	var total_records_count = formObj.total_records_count.value;
	var discrete_count = parseInt(total_values);
	var params;
	var discrete_desc;
	var old_data_value;
	var fm_disp = resultObj.fm_disp.value;
	var to_disp = resultObj.to_disp.value;
	
	var srv_status = formObj.srv_status.value;
	var rslt_type = formObj.rslt_type.value;
	for (i=0;i<discrete_count ; i++)
	{
		var result_type = eval("formObj.result_type"+i).value;
		if(result_type == "N" || result_type == "I")
		{				
			data_value = eval("formObj.number_type"+i);
			ValidNumber = checkForDecInt(i);		
			if(trimString(data_value.value)=="")
				ValidNumber = true;
		}
		else if(result_type == "D")
		{
			data_value = eval("formObj.date_type"+i);
			ValidNumber =CheckDate(data_value);
			if(trimString(data_value.value)=="")
				ValidNumber = true;
		}
		else if(result_type == "E")
		{
			data_value = eval("formObj.date_hour_type"+i);
			localeName=formObj.localeName.value;			
			ValidNumber =validDateObj1(data_value,'DMYHM',localeName);
			if(trimString(data_value.value)=="")
				ValidNumber = true;
		}
		else if(result_type == "T")
		{
			data_value = eval("formObj.time_type"+i);
			ValidNumber =checkTime(data_value);
			if(trimString(data_value.value)=="")
				ValidNumber = true;
		}
		else
		{
			ValidNumber = true;
		}
	}
	if((ValidNumber!=false) || (ValidNumber==undefined))
	{
		for (i=0;i<discrete_count ; i++)
		{
			var srv_stat = eval("formObj.srv_stat"+i);
			srv_stat = srv_stat.value;
		

			var result_type = eval("formObj.result_type"+i);
			result_type = result_type.value;
			
			old_data_value = eval("formObj.old_data_value"+i);

			var data_value;
			if(result_type == "N" || result_type == "I")
			{			
				data_value = eval("formObj.number_type"+i);				
			}
			else if(result_type == "C")
			{
				data_value = eval("formObj.check_type"+i);
			}
			else if(result_type == "E")
			{
				data_value = eval("formObj.date_hour_type"+i);
			}
			else if(result_type == "D")
			{
				data_value = eval("formObj.date_type"+i);
			}
			else if(result_type == "L")
			{
				data_value = eval("formObj.list_type"+i);
			}
			else if(result_type == "F")
			{
				data_value = eval("formObj.long_text"+i);
			}
			else if(result_type == "T")
			{
				data_value = eval("formObj.time_type"+i);
			}
			else if(result_type == "H")
			{
				data_value = eval("formObj.short_text_type"+i);
			}
			rec = false;
			for (j=parseInt(fm_disp);j<=parseInt(to_disp); j++)
			{
				var srv_stat_rec = eval("resultObj.srv_stat"+j+i);
			
				if(result_type == "N" || result_type == "I")
				{
					var number_type = eval("resultObj.number_type"+j+i);
					if(number_type.value==old_data_value.value || number_type.value=="")
					{
						number_type.value = data_value.value;
						number_type.className='';

						srv_stat_rec.value = srv_stat;
						rec = true;
					}
					else
					{
						number_type.className='DUPLICATE';
					}

					if((number_type.value=="" && old_data_value.value=="") || (number_type.value == data_value.value))
						number_type.className='';
				}
				else if(result_type == "C")
				{					
					var check_type = eval("resultObj.check_type"+j+i);
					if(data_value.checked)
					{
						check_type.checked=true;
						check_type.value="Y";
						check_type.className='';	

						srv_stat_rec.value = srv_stat;
						rec = true;
					}
					else
					{
						check_type.checked=false;
						check_type.value="N";
						check_type.className='';	

						srv_stat_rec.value = srv_stat;
						rec = true;
					}
				}
				else if(result_type == "E")
				{
					var date_hour_type = eval("resultObj.date_hour_type"+j+i);
					if(date_hour_type.value==old_data_value.value || date_hour_type.value=="")
					{
						date_hour_type.value = data_value.value;
						date_hour_type.className='';

						srv_stat_rec.value = srv_stat;
						rec = true;
					}
					else
					{
						date_hour_type.className='DUPLICATE';
					}
					if((date_hour_type.value=="" && old_data_value.value=="") || (date_hour_type.value == data_value.value))
						date_hour_type.className='';
				}
				else if(result_type == "D")
				{
					var date_type = eval("resultObj.date_type"+j+i);
					if(date_type.value==old_data_value.value || date_type.value=="")
					{
						date_type.value = data_value.value;
						date_type.className='';

						srv_stat_rec.value = srv_stat;
						rec = true;
					}
					else
					{
						date_type.className='DUPLICATE';
					}
					if((date_type.value=="" && old_data_value.value=="") || (date_type.value == data_value.value))
						date_type.className='';
				}
				else if(result_type == "L")
				{
					var list_type = eval("resultObj.list_type"+j+i);
					if(list_type.value==old_data_value.value || list_type.value=="")
					{
						list_type.value = data_value.value;
						list_type.className='';

						srv_stat_rec.value = srv_stat;
						rec = true;
					}
					else
					{
						list_type.className='DUPLICATE';
					}

					if((list_type.value=="" && old_data_value.value=="") || (list_type.value == data_value.value))
						list_type.className='';
				}
				else if(result_type == "F")
				{
					
					var long_text_type = eval("resultObj.long_text"+j+i);
					if(trimString(long_text_type.value)==trimString(old_data_value.value) || trimString(long_text_type.value)=="")
					{
						long_text_type.value = data_value.value;
						long_text_type.className='';

						srv_stat_rec.value = srv_stat;
						rec = true;
					}
					else
					{
						long_text_type.className='DUPLICATE';
					}
					if((long_text_type.value=="" && old_data_value.value=="") || (long_text_type.value == data_value.value))
						long_text_type.className='';
				}
				else if(result_type == "T")
				{
					var time_type = eval("resultObj.time_type"+j+i);
					if(time_type.value==old_data_value.value || time_type.value=="")
					{
						time_type.value = data_value.value;
						time_type.className='';

						srv_stat_rec.value = srv_stat;
						rec = true;
					}
					else
					{
						time_type.className='DUPLICATE';
					}
					if((time_type.value=="" && old_data_value.value=="") || (time_type.value == data_value.value))
						time_type.className='';
				}
				else if(result_type == "H")
				{
					var short_text_type = eval("resultObj.short_text_type"+j+i);
					if(short_text_type.value==old_data_value.value || short_text_type.value=="")
					{
						short_text_type.value = data_value.value;
						short_text_type.className='';

						srv_stat_rec.value = srv_stat;
						rec = true;
					}
					else
					{
						short_text_type.className='DUPLICATE';
					}
					if((short_text_type.value=="" && old_data_value.value=="") || (short_text_type.value == data_value.value))
						short_text_type.className='';
				}

				if(rec)
				{
					var srv_status_rec = eval("resultObj.srv_status"+j);
					var rslt_type_rec = eval("resultObj.rslt_type"+j);
					srv_status_rec.value = srv_status;
					rslt_type_rec.value = rslt_type;
				}
			}

			for (j=0;j<parseInt(total_records_count) ; j++)
			{
				var srv_stat_val = eval("formObj.header_srv_stat"+j+i);
				var rec = false;
				if(result_type == "N" || result_type == "I")
				{				
					var number_type = eval("formObj.number_type"+j+i);
					if(number_type.value==old_data_value.value || number_type=="")
					{
						number_type.value = data_value.value;
						srv_stat_val.value = srv_stat;
						rec = true;
					}
				}
				else if(result_type == "C")
				{
					var check_type = eval("formObj.check_type"+j+i);
					if(data_value.checked)
					{
						check_type.checked=true;
						check_type.value = "Y";
						srv_stat_val.value = srv_stat;
						rec = true;
					}
					else
					{
						check_type.value="N";
						srv_stat_val.value = srv_stat;
						rec = true;
					}
				}
				else if(result_type == "E")
				{
					var date_hour_type = eval("formObj.date_hour_type"+j+i);
					if(date_hour_type.value==old_data_value.value || date_hour_type.value=="")
					{
						date_hour_type.value = data_value.value;
						srv_stat_val.value = srv_stat;
						rec = true;
					}
				}
				else if(result_type == "D")
				{
					var date_type = eval("formObj.date_type"+j+i);
					if(date_type.value==old_data_value.value || date_type.value=="")
					{
						date_type.value = data_value.value;
						srv_stat_val.value = srv_stat;
						rec = true;
					}
				}
				else if(result_type == "L")
				{
					var list_type = eval("formObj.list_type"+j+i);
					if(list_type.value==old_data_value.value || list_type.value=="")
					{
						list_type.value = data_value.value;
						srv_stat_val.value = srv_stat;
						rec = true;
					}
				}
				else if(result_type == "F")
				{
					var long_text_type = eval("formObj.long_text_type"+j+i);
					if(long_text_type.value==old_data_value.value || long_text_type.value=="")
					{
						long_text_type.value = data_value.value;
						srv_stat_val.value = srv_stat;
						rec = true;
					}
				}
				else if(result_type == "T")
				{
					var time_type = eval("formObj.time_type"+j+i);
					if(time_type.value==old_data_value.value || time_type.value=="")
					{
						time_type.value = data_value.value;
						srv_stat_val.value = srv_stat;
						rec = true;
					}
				}
				else if(result_type == "H")
				{
					var short_text_type = eval("formObj.short_text_type"+j+i);
					if(short_text_type.value==old_data_value.value || short_text_type.value=="")
					{
						short_text_type.value = data_value.value;
						srv_stat_val.value = srv_stat;
						rec = true;
					}
				}
				if(rec)
				{
					var srv_status_val = eval("formObj.srv_status"+j);
					var rslt_type_val  = eval("formObj.rslt_type"+j);
					srv_status_val.value = srv_status;
					rslt_type_val.value = rslt_type;
				}
			}
			if(result_type!='G')
			{				
				old_data_value.value = data_value.value;
			}
		
		}	
	}
}

// functions for scrolling the two frames - start
function alignUnitsAndTitle()
{
	var temp = parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTitleTable").rows[0].cells.length;
	var total = parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTable").rows.length;
	total = total-1;
	var counter = parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTable").rows[total].cells.length;
	for(var i=0;i<counter;i++)
	{
		parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTitleTable").rows[0].cells[i].width =	parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTable").rows[total].cells[i].offsetWidth;
	}
}

function alignDivs()
{
	var x = document.body.clientHeight;
    var y = document.body.clientWidth;
}

function scrollFrame()
{
	parent.multiPatientOrdersResultingMainResultData.document.body.scrollTop = parent.multiPatientOrdersResultingMainResultValues.document.body.scrollTop;
    setTimeout("scrollTitle()",50);
}

function callScrollLeft()
{
	var x = parent.multiPatientOrdersResultingMainResultValues.document.body.scrollLeft;
	if(x==0)
	{
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("prevNext").style.position = 'static';
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("prevNext").style.posLeft  = 0;
	}
	else
	{
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("prevNext").style.position = 'relative';
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("prevNext").style.posLeft  = x;
	}
}
function scrollTitle()
{
	var x = parent.multiPatientOrdersResultingMainResultValues.document.body.scrollTop;
    var y = parent.multiPatientOrdersResultingMainResultData.document.body.scrollTop;
    if(y == 0)
	{
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("divDataTitle").style.position = 'static';
        parent.multiPatientOrdersResultingMainResultValues.document.getElementById("divDataTitle").style.posTop  = 0;
        parent.multiPatientOrdersResultingMainResultData.document.getElementById("divUnitTitle").style.position = 'static';
        parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTitleTable").style.position = 'static';
        parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTitleTable").style.posTop  = y;
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("prevNext").style.posTop  = y;
	}
	else
	{
		parent.multiPatientOrdersResultingMainResultData.document.getElementById("divUnitTitle").style.position = 'relative';
        parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTitleTable").style.position = 'relative';
        parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTitleTable").style.posTop  = y-2;
        parent.multiPatientOrdersResultingMainResultValues.document.getElementById("divDataTitle").style.position = 'relative';
        parent.multiPatientOrdersResultingMainResultValues.document.getElementById("divDataTitle").style.posTop  = y-2;
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("prevNext").style.position = 'relative';
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("prevNext").style.posTop  = y-2;
	}
}

function alignUnitsAndData()
{
	var totalRows =  parent.multiPatientOrdersResultingMainResultValues.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
    var temp = parent.multiPatientOrdersResultingMainResultValues.document.getElementById("dataTitleTable").rows[0].cells.length;
    for(var i=0;i<temp;i++) 
	{							
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("dataTitleTable").rows[0].cells[i].width=parent.multiPatientOrdersResultingMainResultValues.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;				
	}
	if(temp >= 4)
	{
		parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTitleTable").rows[0].height =   parent.multiPatientOrdersResultingMainResultValues.document.getElementById("dataTitleTable").rows[0].offsetHeight;
	}
	else if(temp < 4)
	{
		parent.multiPatientOrdersResultingMainResultValues.document.getElementById("dataTitleTable").rows[0].height = parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTitleTable").rows[0].offsetHeight;
	}
}

function alignHeight()
{
	var totalRows =  parent.multiPatientOrdersResultingMainResultValues.document.getElementById("dataTable").rows.length;
	var totalRows =  parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTable").rows.length;

	var counter = eval(totalRows);

	for(var i=0;i<counter;i++)
	{
		var hgt=eval(parent.multiPatientOrdersResultingMainResultValues.document.getElementById("dataTable").rows[i].offsetHeight);
		var hgt1=eval(parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTable").rows[i].offsetHeight);
		if(eval(hgt) > eval(hgt1))
		{	
			parent.multiPatientOrdersResultingMainResultData.document.getElementById("unitTable").rows[i].height = hgt;
		}
		else if(eval(hgt) < eval(hgt1))
		{
			parent.multiPatientOrdersResultingMainResultValues.document.getElementById("dataTable").rows[i].height = hgt1;	
		}				
	}
}
// function for scrolling the two frames - end


function cancelFrames()
{
	var get_confirmation	= true;
	get_confirmation = confirm(getMessage("VALUE_ENTERED_LOST","OR"));
	if(get_confirmation)
	{
		var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
		var header_values = formObj.header_values.value;
		var result_format = formObj.result_format.value;
		var result_type = formObj.main_result_type.value;
		if(top.content)
			top.content.workAreaFrame.location.href="ORMultiPatientOrdersResulting.jsp?&header_values="+header_values+"&result_format="+result_format+"&result_type="+result_type;

			top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp";
	}
}

function selectIndex(obj)
{	
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	formObj.header_locn_index.value = obj.selectedIndex;

}
// function for loading the main screen data
function loadMainScreenData()
{
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	var header_location_type			= formObj.header_location_type;
	var header_locn						= formObj.header_locn.value;
	var header_locn_index				= formObj.header_locn_index.value;
	var header_period_from				= formObj.header_period_from;
	var header_period_to				= formObj.header_period_to;
	var header_order_category			= formObj.header_order_category;
	var header_order_type				= formObj.header_order_type;
	var header_order_catalog			= formObj.header_order_catalog;
	var header_order_catalog_code		= formObj.header_order_catalog_code;
	var header_result_format_code		= formObj.header_result_format_code;
	var header_result_format_desc		= formObj.header_result_format_desc;
	var header_temp_order_catalog		= formObj.header_temp_order_catalog;
	var ivalues							= formObj.ivalues.value;
	var group_by						= formObj.header_group_by.value;

	var result_type						= formObj.result_type.value;
	var result_format_value				= formObj.result_format_value;
	if(header_location_type.value!=null && header_location_type.value!="")
	{
		formObj.location_type.value = header_location_type.value;
		//populateLocation(formObj.location_type);
	}
	populateLocation(formObj.location_type);
	if(header_period_from.value!=null && header_period_from.value!="")
	{
		formObj.period_from.value = header_period_from.value;
	}

	if(header_period_to.value!=null && header_period_to.value!="")
	{
		formObj.period_to.value = header_period_to.value;
	}

	if(header_order_category.value!=null && header_order_category.value!="")
	{
		formObj.order_category.value = header_order_category.value;
		fillOrderTypes(formObj.order_category);
		if(header_order_type.value!=null && header_order_type.value!=" ")
		{
			formObj.order_type.value = header_order_type.value;
		}
		else 
		{
			formObj.order_type.selectedIndex = 0;
		}
	}
	

	if(group_by!=null && group_by!="")
	{
		formObj.group_by.value = group_by;
	}
	if(header_order_catalog_code.value!=null && header_order_catalog_code.value!="")
	{
		formObj.order_catalog.value = header_order_catalog.value;
		formObj.order_catalog_code.value = header_order_catalog_code.value;
		formObj.temp_order_catalog.value = header_temp_order_catalog.value;
	}
	if(header_locn!=null && header_locn!="")
	{
		formObj.locn.selectedIndex = parseInt(header_locn_index);

	}
	else 
	{
		formObj.locn.selectedIndex = 0;
	}
	if(header_result_format_code.value!=null && header_result_format_code.value!="")
	{
		formObj.result_format.value = header_result_format_desc.value;
		formObj.order_resultFormat_code.value = header_result_format_code.value;
		formObj.temp_resultFormat.value = header_result_format_desc.value;
		parent.document.getElementById("main_frame").rows = '19%,0%,77%, 4%';
		parent.multiPatientOrdersResultingHdrResult.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingHdrResult.jsp?location_type="+header_location_type.value+"&locn="+header_locn+"&period_from="+header_period_from.value+"&period_to="+header_period_to.value+"&order_category="+header_order_category.value+"&order_type="+header_order_type.value+"&result_format="+header_result_format_code.value+"&order_catalog="+header_order_catalog_code.value+"&group_by="+group_by+"&ivalues="+ivalues+"&result_type="+result_type;
	}
	else
	{
		parent.document.getElementById("main_frame").rows = '19%,5%,74%, 4%';
		parent.multiPatientOrdersResultingHdrDtl.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingHdrDtl.jsp?location_type="+header_location_type.value+"&locn="+header_locn+"&period_from="+header_period_from.value+"&period_to="+header_period_to.value+"&order_category="+header_order_category.value+"&order_type="+header_order_type.value+"&result_format="+result_format_value.value+"&order_catalog="+header_order_catalog_code.value+"&group_by="+group_by;

		parent.multiPatientOrdersResultingHdrResult.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingHdrResult.jsp?location_type="+header_location_type.value+"&locn="+header_locn+"&period_from="+header_period_from.value+"&period_to="+header_period_to.value+"&order_category="+header_order_category.value+"&order_type="+header_order_type.value+"&result_format="+result_format_value.value+"&order_catalog="+header_order_catalog_code.value+"&group_by="+group_by+"&ivalues="+ivalues+"&result_type="+result_type;
	}
	parent.multiPatientOrdersResultingHdrButtons.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingHdrButtons.jsp"	
}

function clearFrames()
{
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	parent.multiPatientOrdersResultingHdrDtl.location.href="../../eCommon/html/blank.html";
	parent.multiPatientOrdersResultingHdrResult.location.href = "../../eCommon/html/blank.html";
	parent.multiPatientOrdersResultingHdrButtons.location.href = "../../eCommon/html/blank.html";
	top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp";
	formObj.submit();
}

function validateDateWithTime(obj)
{
	if(!doDateTimeChk(obj))
	{
		if(obj.value!='')
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			return false;
		}
	}
}

function chckDate(Object2,focusflag,localeName)
{
	
	if(validDateObj(Object2,"DMYHM",localeName)==false){

	var temp;
	if(parent.multiPatientOrdersResultingHdr)
		temp=parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	else
		temp=document.multiPatientOrdersResultingHdr;
	 //  temp.period_from.value= temp.temp_last_month_date.value;
	
	
	}
}



function doDateTimeChk(obj)
{
	if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
	{
		retval= false
		//obj.focus()
	}
	else
	{
		var comp=obj
		obj=obj.value
		var dttime = obj.split(" ");
		var dt
		var time
		var retval=true
		if(dttime.length>1)
		{
			dt=dttime[0]
			time=dttime[1]

			if(!checkDt(dt) )
			{
				retval= false
			   // comp.focus()
			}
			else
			{
				if(time==null || time=="")
				{
					alert(getMessage("INVALID_DATE_TIME","SM"))
					retval= false;
				   // comp.focus()
				}

				else
				{
					if(!chkTime(time))
					{
						retval= false
						//alert(getMessage("INVALID_DATE_TIME"))
					   // comp.focus()
					}
				}
			}
		}
		else
		{
			retval= false
			if(dttime.length==1 && obj!='')
			{
				comp.focus()
			}
			//alert(getMessage("INVALID_DATE_TIME"))
		}

		if(retval)
		{
			//callDateFunction(comp)
		}
	}
	return retval
}
function validateDateTime(obj,val)
		{
			if(obj.value != ''){
				if(val == 'E'){
					if(!doDateTimeChk(obj)){
						alert(getMessage('INVALID_DATE_TIME','SM'));
						obj.select();
						obj.focus();
					}
				}
				else if(val == 'D'){
					if(CheckDate(obj)){}
				}
				else if(val == 'T')
				{
					if(!chkTime(obj.value))
					{
						alert(getMessage('INVALID_TIME_FMT','OR'));
						obj.select();
						obj.focus();
					}
				}
			}
		}
function ValidateDateTimeOfPeriod(Objfrom,objTo,obj)
{
	var dflt_from_date=document.forms[0].header_period_from_valid.value;
	var dflt_to_date=document.forms[0].header_period_to_valid.value;
	if(objTo.value !="" && Objfrom.value != "")
	{
		if(!ValidateDateTime(Objfrom,objTo))
		{
			if(obj.name=='period_to')
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"))
				objTo.value=dflt_to_date;
				objTo.focus();
				return false
			}
			else if(obj.name=='period_from')
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"))
				Objfrom.value=dflt_from_date;
				Objfrom.focus();
				return false
			}
		}
	}
}
function Validate_DateTimeOfPeriod(obj,format,localeVal,objfrom,objto)
{
	var retunvalue=validDateObj1(obj,format,localeVal)
	//var retunvalue=validateDateWithTime(obj)
	if(retunvalue==true)
	{
		ValidateDateTimeOfPeriod(objfrom,objto,obj);
	}
}

// function for loading the drop down values
function loadListValues(field_name, jvalue) 
{
	var formObj =  parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var disc_msr_id = eval("formObj.discrete_measure_id"+jvalue);
		disc_msr_id = disc_msr_id.value;
	
	var count = eval("formObj.list_type"+disc_msr_id);
	count = count.value;
	for(i=0;i<parseInt(count);i++)
	{
		var description = eval("formObj.list_type"+disc_msr_id+i);
		description = description.value;
		
		var element = document.createElement('OPTION') ;
		element.value =  description ;
		element.text = description ;
		var addElem = eval("document.forms[0]."+field_name);
		addElem.add(element);
	}
}
function resetColorCode(obj)
{
	obj.className="";
}


// function for pagination in result page
function checkVal(obj)
{
	setCBValues();
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

// function for pagination in result reporting page
function submitPage(obj)
{
	var formObj = parent.multiPatientOrdersResultingMainResultData.document.multiPatientOrdersResultingMainResult;
	formObj.method = 'POST';
	formObj.dispMode.value = obj;
	formObj.submit();
}

// function for loading the checkboxes
function loadCheckBoxes()
{
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	var total_count = document.forms[0].total_count.value;
	HTMLtext='';
	for(j=0;j<parseInt(total_count);j++)
	{
		HTMLtext=HTMLtext+'<input type=hidden name=select_yn'+j+ ' value="N">';
	}
	 parent.multiPatientOrdersResultingHdr.document.getElementById('result_check_boxes').insertAdjacentHTML("beforeend",HTMLtext);
}

function loadSelectedCheckBoxes(ivalue, desc)
{
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	var header_val = eval("formObj.select_yn"+ivalue);
	header_val.value = desc;
}

function setCheckBoxValues()
{
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	
	var fm_disp = document.forms[0].fm_disp.value;
	var to_disp = document.forms[0].to_disp.value;
	
	var page_records = parseInt(to_disp) - parseInt(fm_disp) + 1;
	var count = 0;
	for(j=parseInt(fm_disp);j<=parseInt(to_disp);j++)
	{
		var header_val = eval("formObj.select_yn"+j);
		header_val = header_val.value;
		var result_val = eval("document.forms[0].CheckMultiPatientOrdersResulting"+j);
		if(header_val!="N")
		{
			result_val.value = header_val;
			result_val.checked=true;
			count++;
		}
		else
		{
			result_val.value = "";
			result_val.checked=false;
		}
	}

	if(count == page_records)
	{
		document.forms[0].CheckMultiOrderPatient1.checked=true;
	}
	else
	{
		document.forms[0].CheckMultiOrderPatient1.checked=false;
	}


	var group_count = document.forms[0].group_count.value;

	for(i=1;i<=parseInt(group_count);i++)
	{
		var tot = eval("document.forms[0].indGrpCount"+i);
		var indGrpCount = eval(tot.value);
		var select_count = 0;
		for(j=1;j<=indGrpCount;j++)
		{
			var val = eval("document.forms[0].checkId"+i+j)
			if(val.checked)
				select_count++;
		}
		var select_group = eval("document.forms[0].select_group"+i);
		if(select_count==indGrpCount)
		{
			select_group.checked = true;
		}
		else
		{
			select_group.checked = false;
		}
	}
	if(formObj.search.disabled == true)
	formObj.search.disabled = false;

}

function enableSearch()
{
	if(parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr.search.disabled==true)
	parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr.search.disabled = false;
}
function setCBValues()
{
	var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;
	var resultObj = parent.multiPatientOrdersResultingHdrResult.document.multiPatientOrdersResultingHdrResult;

	var fm_disp = resultObj.fm_disp.value;
	var to_disp = resultObj.to_disp.value;
	for(j=parseInt(fm_disp);j<=parseInt(to_disp);j++)
	{
		var header_val = eval("formObj.select_yn"+j);
		var result_val = eval("resultObj.CheckMultiPatientOrdersResulting"+j);
		var order_id = eval("resultObj.order_id"+j)
			order_id = order_id.value;
		var order_line_num = eval("resultObj.order_line_num"+j);
			order_line_num = order_line_num.value;
		if(result_val.checked == true)
		{
			header_val.value = "('"+order_id+"','"+order_line_num+"')";
		}
		else
		{
			header_val.value = "N";
		}
		var testval = eval("formObj.select_yn"+j);
	}
}

function loadHiddenParams()
{
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var buttonObj = parent.multiPatientOrdersResultingMainHdrButtons.document.multiPatientOrdersResultingHdrButtons;
	var resultObj = parent.multiPatientOrdersResultingMainResultValues.document.multiPatientORMainResultValues;

	var discrete_count = formObj.total_values.value;
	var records_count  = resultObj.row_count.value;
	HTMLtext='';
	for(i=0;i<parseInt(records_count);i++)
	{
		for(j=0;j<parseInt(discrete_count);j++)
		{
			var result_type = eval("formObj.result_type"+j);
			result_type = result_type.value;
			if(result_type=='E')
			{
				HTMLtext=HTMLtext+'<input type=hidden name=date_hour_type'+i+j+ ' value="">';
			}
			else if(result_type=='D')
			{
				HTMLtext=HTMLtext+'<input type=hidden name=date_type'+i+j+ ' value="">';
			}
			else if(result_type=='N' || result_type == 'I')
			{
				HTMLtext=HTMLtext+'<input type=hidden name=number_type'+i+j+ ' value="">';
			}
			else if(result_type=='C')
			{
				HTMLtext=HTMLtext+'<input type=hidden name=check_type'+i+j+ ' value="N">';
			}
			else if(result_type=='F')
			{
				HTMLtext=HTMLtext+'<input type=hidden name=long_text_type'+i+j+ ' value="">';
			}
			else if(result_type=='L')
			{
				HTMLtext=HTMLtext+'<input type=hidden name=list_type'+i+j+ ' value="">';
			}
			else if(result_type=='T')
			{
				HTMLtext=HTMLtext+'<input type=hidden name=time_type'+i+j+ ' value="">';
			}
			else if(result_type=='H')
			{
				HTMLtext=HTMLtext+'<input type=hidden name=short_text_type'+i+j+ ' value="">';
			}

			HTMLtext=HTMLtext+'<input type=hidden name=header_srv_stat'+i+j+ ' value="">';
		}
		HTMLtext=HTMLtext+'<input type=hidden name=srv_status'+i+ ' value="">';
		HTMLtext=HTMLtext+'<input type=hidden name=rslt_type'+i+ ' value="">';
	}
	parent.multiPatientOrdersResultingMainHdr.document.getElementById('hidden_params').insertAdjacentHTML("beforeend",HTMLtext);
	buttonObj.populate.disabled=false;
}

function loadParamValues()
{
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var resultObj = parent.multiPatientOrdersResultingMainResultValues.document.multiPatientORMainResultValues;

	var discrete_count = formObj.total_values.value;

	var fm_disp = resultObj.fm_disp.value;
	var to_disp = resultObj.to_disp.value;
	
	var srv_status = formObj.srv_status.value;
	var rslt_type = formObj.rslt_type.value;

	for(i=parseInt(fm_disp);i<=parseInt(to_disp);i++)
	{
		for(j=0;j<parseInt(discrete_count);j++)
		{
			var result_type = eval("formObj.result_type"+j);
			var old_data_value = eval("formObj.old_data_value"+j);
			result_type = result_type.value;
			
			var srv_stat = eval("formObj.srv_stat"+j);
			//srv_stat = srv_stat.value;

			var srv_stat_rec = eval("resultObj.srv_stat"+i+j);
			srv_stat_rec.value = srv_stat.value;

			if(result_type=='E')
			{
				var header_date_hour_type = eval("formObj.date_hour_type"+i+j);
				header_date_hour_type = header_date_hour_type.value;
				var result_date_hour_type = eval("resultObj.date_hour_type"+i+j);
				result_date_hour_type.value = header_date_hour_type;

				if(old_data_value.value!=header_date_hour_type)
				{
					result_date_hour_type.className = "DUPLICATE";
				}
				else
				{
					result_date_hour_type.className = '';
				}
			}
			else if(result_type=='D')
			{
				var header_date_type = eval("formObj.date_type"+i+j);
				header_date_type = header_date_type.value;

				var result_date_type = eval("resultObj.date_type"+i+j);
				result_date_type.value = header_date_type;

				if(old_data_value.value!=header_date_type)
				{
					result_date_type.className = "DUPLICATE";
				}
				else
				{
					result_date_type.className = '';
				}
			}
			else if(result_type=='N' || result_type == 'I')
			{
				var header_number_type = eval("formObj.number_type"+i+j);
				header_number_type = header_number_type.value;

				var result_number_type = eval("resultObj.number_type"+i+j);
				result_number_type.value = header_number_type;

				if(old_data_value.value!=header_number_type)
				{
					result_number_type.className = "DUPLICATE";
				}
				else
				{
					result_number_type.className = '';
				}
			}
			else if(result_type=='C')
			{
				var header_check_type = eval("formObj.check_type"+i+j);
				header_check_type = header_check_type.value;

				var result_check_type = eval("resultObj.check_type"+i+j);
				if(header_check_type!="" && header_check_type=='Y')
				{
					result_check_type.checked = true;
					result_check_type.value = header_check_type;
				}
				else
				{
					result_check_type.checked = false;
					result_check_type.value = header_check_type;
				}
			}
			else if(result_type=='F')
			{
				var header_long_text_type = eval("formObj.long_text_type"+i+j);
				header_long_text_type = header_long_text_type.value;

				var result_long_text_type = eval("resultObj.long_text_type"+i+j);
				result_long_text_type.value = header_long_text_type;
				
				if(old_data_value.value!=header_long_text_type)
				{
					result_long_text_type.className = "DUPLICATE";
				}
				else
				{
					result_long_text_type.className = '';
				}
			}
			else if(result_type=='L')
			{
				var header_list_type = eval("formObj.list_type"+i+j);
				header_list_type = header_list_type.value;
				
				if(header_list_type=='')
					header_list_type="";
				var result_list_type = eval("resultObj.list_type"+i+j);
				result_list_type.value = header_list_type;

				if(old_data_value.value!=header_list_type)
				{
					result_list_type.className = "DUPLICATE";
				}
				else
				{
					result_list_type.className = '';
				}
			}
			else if(result_type=='T')
			{
				var header_time_type = eval("formObj.time_type"+i+j);
				header_time_type = header_time_type.value;

				var result_time_type = eval("resultObj.time_type"+i+j);
				result_time_type.value = header_time_type;
				if(old_data_value.value!=header_time_type)
				{
					result_time_type.className = "DUPLICATE";
				}
				else
				{
					result_time_type.className = '';
				}
			}
			else if(result_type=='H')
			{
				var header_short_text_type = eval("formObj.short_text_type"+i+j);
				header_short_text_type = header_short_text_type.value;

				var result_short_text_type = eval("resultObj.short_text_type"+i+j);
				result_short_text_type.value = header_short_text_type;
				if(old_data_value.value!=header_short_text_type)
				{
					result_short_text_type.className = "DUPLICATE";
				}
				else
				{
					result_short_text_type.className = '';
				}
			}
		}
		var srv_status_rec = eval("resultObj.srv_status"+i);
		var rslt_type_rec = eval("resultObj.rslt_type"+i);
		srv_status_rec.value = srv_status;
		rslt_type_rec.value = rslt_type;
	}
}

function setHeaderCheckBoxValue(obj,ival,jval)
{
	var objName=obj.name;	
		if(objName.length>0)
		{
			if(obj.checked)
				obj.value="Y";
			else
				obj.value="N";

			objectName=objName.substring(0,(objName.length)-2);	
			objectName=objectName+jval;
			var topform=parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
			var temp=eval("topform."+objectName);	
			var downObj = parent.multiPatientOrdersResultingMainResultValues.document.multiPatientORMainResultValues;
			var header_obj = eval("downObj."+obj.name);
			var headerchk=header_obj.checked;
			var tmpchk=temp.checked;	
			if(headerchk!=tmpchk)
				obj.className='DUPLICATE';
			else
				obj.className='';
			
			var temp1=eval("topform."+obj.name);
			
			temp1.value=obj.value;			
		}
	
}
function setHeaderValue(obj)
{
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;

	var header_obj = eval("formObj."+obj.name);
	header_obj.value=obj.value;
	obj.className='DUPLICATE';
}

function setHeaderValue1(obj,ival,jval)
{
	var objName=obj.name;	
	//if(obj.value==""){
	//	obj.className='';
	//}else
	//{
	
	if(objName.length>0)
	{
	/****COMMENTED BY Deepa on 12/8/2009 at 2:42 PM for IN016986 ****/
	//objectName=objName.substring(0,(objName.length)-2);	
	//objectName=objectName+jval;	
	objectName = objName;
	/****COMMENTED BY Deepa on 12/8/2009 at 2:42 PM for IN016986 ****/
	var topform=parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var temp=topform+objectName;	
	var downObj = parent.multiPatientOrdersResultingMainResultValues.document.multiPatientORMainResultValues;
	var header_obj = eval("downObj."+obj.name);
	/*if(trimString(header_obj.value)!=trimString(temp.value))
		obj.className='DUPLICATE';
	else
		obj.className='';*/
	/****ADDED BY Deepa on 12/8/2009 at 2:42 PM for IN016986 ****/
		temp.value = obj.value;
	/****ADDED BY Deepa on 12/8/2009 at 2:42 PM for IN016986 ****/
	}
	//}
}
function setHeaderDateValue(obj,result_type,col)
{
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var header_obj = eval("formObj."+obj.name);
	var header_value;
	if(result_type=='D')
	{
		header_value = eval("formObj.date_type"+col);
	}
	else if (result_type=='E')
	{	
		header_value = eval("formObj.date_hour_type"+col);
	}
			
	if((header_value.value=='' && obj.value=='') || (header_value.value==obj.value))
	{
		obj.className='';
	}
	else if (obj.value!='')
	{
		obj.className='DUPLICATE';
	}
	header_obj.value=obj.value;
}

function loadOrderValues()
{
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var resultObj = parent.multiPatientOrdersResultingMainResultData.document.multiPatientOrdersResultingMainResult;

	var count = resultObj.row_count.value;
	
	HTMLtext='';
	for(j=0;j<parseInt(count);j++)
	{
		var order_id			= eval("resultObj.order_id"+j);
		var order_line_num		= eval("resultObj.order_line_num"+j);
		var order_type_code		= eval("resultObj.order_type_code"+j);
		var catalog_code		= eval("resultObj.catalog_code"+j);
		var patient_id			= eval("resultObj.patient_id"+j);
		var encounter_id		= eval("resultObj.encounter_id"+j);
		var patient_class		= eval("resultObj.patient_class"+j);
		order_line_num			= order_line_num.value;
		order_id				= order_id.value;
		order_type_code			= order_type_code.value;
		catalog_code			= catalog_code.value
		patient_id				= patient_id.value
		encounter_id			= encounter_id.value
		patient_class			= patient_class.value
		HTMLtext=HTMLtext+'<input type=hidden name=order_id'+j+ ' value="'+order_id+'">';
		HTMLtext=HTMLtext+'<input type=hidden name=order_line_num'+j+ ' value="'+order_line_num+'">';
		HTMLtext=HTMLtext+'<input type=hidden name=order_type_code'+j+ ' value="'+order_type_code+'">';
		HTMLtext=HTMLtext+'<input type=hidden name=catalog_code'+j+ ' value="'+catalog_code+'">';
		HTMLtext=HTMLtext+'<input type=hidden name=patient_id'+j+ ' value="'+patient_id+'">';
		HTMLtext=HTMLtext+'<input type=hidden name=encounter_id'+j+ ' value="'+encounter_id+'">';
		HTMLtext=HTMLtext+'<input type=hidden name=patient_class'+j+ ' value="'+patient_class+'">';
	}
	parent.multiPatientOrdersResultingMainHdr.document.getElementById('hidden_params').insertAdjacentHTML("beforeend",HTMLtext);
}

// function for recording the values
function recordValues()
{
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var total_values = formObj.total_values.value;
	var total_records_count = formObj.total_records_count.value;
	var discrete_count = parseInt(total_values);
	
	var result1 = true;
	for(j=0;j<parseInt(total_records_count);j++)
	{
		var message = '';
		for (i=0;i<discrete_count ; i++)
		{
			var discrete_measure_id = eval("formObj.discrete_measure_id"+i);
			var discrete_measure_desc = eval("formObj.discrete_measure_desc"+i);
			var result_type = eval("formObj.result_type"+i);
			var max_digits = eval("formObj.max_digits"+i);
			var min_digits = eval("formObj.min_digits"+i);
			var dec_digits = eval("formObj.dec_digits"+i);
			var mandatory = eval("formObj.mandatory"+i);
			var order_id = eval("formObj.order_id"+j);
			var order_line_num = eval("formObj.order_line_num"+j);
			

			result_type = result_type.value;
			order_id	= order_id.value;
			order_line_num	= order_line_num.value;
			mandatory	= mandatory.value;
			discrete_measure_desc = discrete_measure_desc.value;
			if(result_type=='E')
			{
				var header_date_hour_type = eval("formObj.date_hour_type"+j+i);
				header_date_hour_type = header_date_hour_type.value;
				if(mandatory=='Y' && header_date_hour_type=="")
				{
					result1 = false;
					if(message=='')
					{
						message = getMessage("VALUE_NOT_ENTERED","OR") +discrete_measure_desc;
					}
					else
					{
						message += ", " + discrete_measure_desc;
					}
				}
			}
			else if(result_type=='D')
			{
				var header_date_type = eval("formObj.date_type"+j+i);
				header_date_type = header_date_type.value;
				if(mandatory=='Y' && header_date_type=="")
				{
					result1 = false;
					if(message=='')
					{
						message = getMessage("VALUE_NOT_ENTERED","OR") +discrete_measure_desc;
					}
					else
					{
						message += ", " + discrete_measure_desc;
					}
				}
			}
			else if(result_type=='N' || result_type == 'I')
			{
				var header_number_type = eval("formObj.number_type"+j+i);
				header_number_type = header_number_type.value;
				if(mandatory=='Y' && header_number_type=="")
				{
					result1 = false;
					if(message=='')
					{
						message = getMessage("VALUE_NOT_ENTERED","OR") +discrete_measure_desc;
					}
					else
					{
						message += ", " + discrete_measure_desc;
					}
				}
			}
			else if(result_type=='C')
			{
				var header_check_type = eval("formObj.check_type"+j+i);
				header_check_type = header_check_type.value;
				if(mandatory=='Y' && header_check_type=="N")
				{
					result1 = false;
					if(message=='')
					{
						message = getMessage("VALUE_NOT_ENTERED","OR") +discrete_measure_desc;
					}
					else
					{
						message += ", " + discrete_measure_desc;
					}
				}
			}
			else if(result_type=='F')
			{
				var header_long_text_type = eval("formObj.long_text_type"+j+i);
				header_long_text_type = header_long_text_type.value;
				
				if(mandatory=='Y' && header_long_text_type=="")
				{
					result1 = false;
					if(message=='')
					{
						message = getMessage("VALUE_NOT_ENTERED","OR") +discrete_measure_desc;
					}
					else
					{
						message += ", " + discrete_measure_desc;
					}
				}
			}
			else if(result_type=='L')
			{
				var header_list_type = eval("formObj.list_type"+j+i);
				header_list_type = header_list_type.value;
				if(mandatory=='Y' && header_list_type=="")
				{
					result1 = false;
					if(message=='')
					{
						message = getMessage("VALUE_NOT_ENTERED","OR") +discrete_measure_desc;
					}
					else
					{
						message += ", " + discrete_measure_desc;
					}
				}
			}
			else if(result_type=='T')
			{
				var header_time_type = eval("formObj.time_type"+j+i);
				header_time_type = header_time_type.value;
				if(mandatory=='Y' && header_time_type=="")
				{
					result1 = false;
					if(message=='')
					{
						message = getMessage("VALUE_NOT_ENTERED","OR") +discrete_measure_desc;
					}
					else
					{
						message += ", " + discrete_measure_desc;
					}
				}
			}
			else if(result_type=='H')
			{
				var header_short_text_type = eval("formObj.short_text_type"+j+i);
				header_short_text_type = header_short_text_type.value;
				if(mandatory=='Y' && header_short_text_type=="")
				{
					result1 = false;
					if(message=='')
					{
						message = getMessage("VALUE_NOT_ENTERED","OR") +discrete_measure_desc;
					}
					else
					{
						message += ", " + discrete_measure_desc;
					}
				}
			}
		}
		if(message!='')
		{
			//message += " for Order ID "+order_id;
			var tempmsg=getMessage("FOR_ORDER_ID","OR")
			message =message+tempmsg+order_id;
			alert(message);
			result1 = false;
			return;
		}
	}
	//alert(result1+"result1");
	if(result1)
	{
		eval(formApply(formObj,OR_CONTROLLER));
		//alert("resultGlobal is..."+resultGlobal);
		if(resultGlobal) 
		{
			onSuccess();
		}
		else
		{
			if(messageGlobal=='OR_STATUS_CHANGED')
			{
				alert(getMessage("OR_STATUS_CHANGED","OR"));
				var header_values = formObj.header_values.value;
				var result_format = formObj.result_format.value;
				var result_type = formObj.main_result_type.value;
				
				top.content.workAreaFrame.location.href="ORMultiPatientOrdersResulting.jsp?&header_values="+header_values+"&result_format="+result_format+"&result_type="+result_type;
				top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp";
			}
			else
				top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+messageGlobal;
		}
	}
}

function assignResult(res,msg,mod,invCode)
{
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
	invalidCode		= invCode ;
}
function onSuccess()
{
		alert(getMessage("RECORD_INSERTED","SM"));
		top.content.workAreaFrame.location.href="ORMultiPatientOrdersResulting.jsp";
		
		top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp";
}

function recordsNotFound()
{
	//var formObj = parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr;

	parent.multiPatientOrdersResultingHdrResult.location.href="../../eCommon/html/blank.html";
	parent.multiPatientOrdersResultingHdrButtons.location.href="../../eCommon/html/blank.html";
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
	if(parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr.search.disabled==true)
	parent.multiPatientOrdersResultingHdr.document.multiPatientOrdersResultingHdr.search.disabled = false;	
}


// function to display an appropriate msg to the user if the concurrent modification has been happened
function resultingRecordsNotFound()
{
	parent.multiPatientOrdersResultingMainResultData.location.href="../../eCommon/html/blank.html";
	alert(getMessage("OR_STATUS_CHANGED","OR"));
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;

	var header_values = formObj.header_values.value;
	var result_format = formObj.result_format.value;
	var result_type = formObj.main_result_type.value;
	
	top.content.workAreaFrame.location.href="ORMultiPatientOrdersResulting.jsp?&header_values="+header_values+"&result_format="+result_format+"&result_type="+result_type;
	top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp";
}

// Function for displaying the order details on click of +
async function displayOrder(order_id,sex,patient_class,encounter_id,patient_id)
{
	var dialogHeight ='73vh' ;
	var dialogWidth = '50vw' ;
	var dialogTop	= '129';
	var dialogLeft = '100' ;

	var title = 'View';
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";

	var finalString	= "colval1=Order Details&colval=View&orderId="+order_id+"&sex="+sex+"&patient_id="+patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class;
	
	await top.window.showModalDialog("../../eOR/jsp/ViewOrders.jsp?"+finalString,arguments,features);
}


// Function for setting the frame sizes depending on the elements in the header frame
function setFrameSizes(records_size,text_area_exists)
{
	records_size = parseInt(records_size);
	if(records_size <= 2)
	{
		if(text_area_exists==true || text_area_exists=='true')
		{		
			parent.document.getElementById("main_frame").rows = '12%,4%,81%, 4%';
		}
		else
		{
		//	parent.document.getElementById("main_frame").rows = '7.5%,4%,84%, 4%';
			parent.document.getElementById("multiPatientOrdersResultingMainHdr").style.height="10vh";
			parent.document.getElementById("multiPatientOrdersResultingMainHdrButtons").style.height="5vh";
			parent.document.getElementById("multiPatientOrdersResultingMainResultData").style.height="74vh";
			parent.document.getElementById("multiPatientOrdersResultingMainResultValues").style.height="74vh";
			parent.document.getElementById("multiPatientOrdersResultingMainButtons").style.height="5vh";
		}
	}
	else if(records_size <= 4)
	{
		if(text_area_exists==true || text_area_exists=='true')
		{
			parent.document.getElementById("main_frame").rows = '15%,3%,77%, 4%';
		}
		else
		{
			parent.document.getElementById("main_frame").rows = '11%,3%,82%, 4%';
		}
	}
	else if(records_size <= 6 && (text_area_exists!=true && text_area_exists!='true'))
	{
		parent.document.getElementById("main_frame").rows = '15%,3%,77%, 4%';
	}
	else
	{
		parent.document.getElementById("main_frame").rows = '19%,3%,74%, 4%';
	}
}

function checkMaxLimit(obj,maxSize) 
{
	if ( obj.value.length >= maxSize )
	{
		alert(getMessage("MAX_LIMIT","OR"));
		obj.focus();
		return false;
	}
}

function checkTime(obj)
{
	if(obj.readOnly)	return;
	if(obj.value=="")
		return;
	if(!chkTime(obj.value))
	{
		//alert('Invalid Time Format')
		alert(getMessage("INVALID_TIME_FMT","OR"));
		obj.focus();
		return false;
	}
}
function enterCheck() 
{
	if (event.keyCode == 13) 
	{
 		event.keyCode = "";
 	}
	
}
function CheckForSpecChars(event){	
	if (event.keyCode == 13) 
	{
 		event.keyCode = "";
 	}
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
	
}

function OrAllowDateHourFormat()
{
	var key = window.event.keyCode;
	if( ! ( (( key>=48 ) && ( key<=58 ) ) || (key == 47) || key == 32) ) 
	{
       return false;
	}
}

// Method copied from the ResultEntry.js
function checkNumericResult(index,indexI,indexJ)
{
	var formObj = document.forms[0];	
	resultElement = eval("formObj.number_type"+index)
		if(isNaN(resultElement.value))
	{
		resultElement.value = "";
	}
	if(resultElement.readOnly)	return false;
	if(resultElement.value=="") 	return false; 
	result	= parseFloat(trimString(resultElement.value));	
	result = resultElement.value;
	//resultElement.value = result
	IntResult = parseInt(trimString(resultElement.value));
	//IntResult = resultElement.value;
	tempResult = resultElement.value;

	resultFloatStr = "";
	resultIntStr = tempResult;
	if(tempResult.indexOf(".")>=0)
	{
		resultFloatStr = tempResult.substr(tempResult.indexOf(".")+1, tempResult.length-1)
		resultIntStr = tempResult.substr(0, tempResult.indexOf("."))
	}
	if(resultIntStr.length==0)
		resultIntStr="0";
/*Checking for the decimals constraint.*/
	num_digits_dec = parseInt(trimString(eval("formObj.dec_digits"+index).value));
	if(parseInt(resultFloatStr)==0)
	{
		resultFloatStr = "";
		result = IntResult;
		resultElement.value = IntResult;
	}
	if(resultFloatStr.length > num_digits_dec)
	{
		message = getMessage('VARIABLE_DEC_DIGIT','OR');
		alert(message.replace("@",num_digits_dec));
		resultElement.value="";
		resultElement.focus();
		return;
	}

/*Checking for the number of digits constraint.*/
	resultIntLength = resultIntStr.length;
	num_digits_min = parseInt(trimString(eval("formObj.min_digits"+index).value));
	num_digits_max = parseInt(trimString(eval("formObj.max_digits"+index).value));

	if(resultIntLength < num_digits_min)
	{
		message = getMessage('RSLT_NOT_LESS_DIGIT','OR');
		alert(message.replace("@",num_digits_min));
		resultElement.value="";
		resultElement.focus();
		return;
	}
	else if(resultIntLength > num_digits_max)
	{
		message = getMessage('RSLT_NOT_MORE_DIGIT','OR');
		alert(message.replace("@",num_digits_max));
		resultElement.value="";
		resultElement.focus();
		return;
	}

/*Checking for the range constraint and setting the status according to the filled result.*/

	/*num_digits_min_points = parseInt(trimString(eval("formObj.num_crit_low_points_"+index).value));//before 28.12.2004
	num_digits_max_points = parseInt(trimString(eval("formObj.num_crit_high_points_"+index).value));//before 28.12.2004*/

	num_digits_min_points = trimString(eval("formObj.num_crit_low_points"+index).value);
	num_digits_max_points = trimString(eval("formObj.num_crit_high_points"+index).value);


	if(num_digits_min_points=='')	num_digits_min_points='0';
	if(num_digits_max_points=='')	num_digits_max_points='0';
	
	checkSrv = false;
	checkVal = "";
	if(trimString(eval("formObj.num_crit_low"+index).value)!="")
	{
		num_crit_low = trimString(eval("formObj.num_crit_low"+index).value);
		num_crit_high = trimString(eval("formObj.num_crit_high"+index).value);

		selectElement = eval("formObj.srv_stat"+index);
		if(result < num_crit_low)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "K";
				checkVal = "K";
				checkSrv = true;
			}
		}
		else if ((num_crit_low <= result) && (result < num_digits_min_points))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "L";
				checkVal = "L";
				checkSrv = true;
			}
		}
		else if ((num_digits_min_points <= result) && (result <= num_digits_max_points))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "N";
				checkVal = "N";
				checkSrv = true;
			}
		}
		else if ((num_digits_max_points < result) && (result <= num_crit_high))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "H";
				checkVal = "H";
				checkSrv = true;
			}
		}
		else if (num_crit_high < result)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "I";
				checkVal = "I";
				checkSrv = true;
			}
		}
	}
	else
	{
		selectElement = eval("formObj.srv_stat"+index);

		if ((num_digits_min_points <= result) && (result <= num_digits_max_points))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "N";
				checkVal = "N";
				checkSrv = true;
			}
		}
		else if (result < num_digits_min_points)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "L";
				checkVal = "L";
				checkSrv = true;
			}
		}else if (num_digits_max_points < result)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "H";
				checkVal = "H";
				checkSrv = true;
			}
		}
		else
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "I";
				checkVal = "I";
				checkSrv = true;
			}
		}
	}

	if(checkSrv)
	{
		if(indexI != undefined && indexJ != undefined)
		{
			var headerObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
			var header_srv_stat = eval("headerObj.header_srv_stat"+index);
			var srv_stat = eval("formObj.srv_stat"+index);

			srv_stat.value = checkVal;
			header_srv_stat.value = checkVal;
			checkSrvStatusChange1(indexI);
		}
		else
		{
			checkSrvStatusChange()
		}
	}
}


// Method copied from ResultEntry.js
function checkSrvStatusChange()
{
	notApplicable = 0;
	normal = 0;
	abNormal = 0;
	detailFrmObj = document.forms[0];
//	reportFrmObj = parent.ResultEntryReport.document.result_entry_report
	totalRecs = detailFrmObj.total_values.value;

	for(i=0; i<totalRecs; i++)
	{
		selectElement = eval("detailFrmObj.srv_stat"+i)

		if(selectElement.value=='')
			notApplicable++;
		else if(selectElement.value=='N')
			normal++;
		else //if(selectElement.value=='A')
			abNormal++;

	}
	if(notApplicable==totalRecs)
	{	
		if(detailFrmObj && detailFrmObj.srv_status)
			detailFrmObj.srv_status.value="Not Applicable";
		if(detailFrmObj && detailFrmObj.rslt_type)
			detailFrmObj.rslt_type.value='';
	}
	else if (abNormal > 0)
	{
		if(detailFrmObj && detailFrmObj.srv_status)
			detailFrmObj.srv_status.value="Abnormal";
		if(detailFrmObj && detailFrmObj.rslt_type)
			detailFrmObj.rslt_type.value='A';
	}
	else if (normal > 0)
	{
		if(detailFrmObj && detailFrmObj.srv_status)
			detailFrmObj.srv_status.value="Normal";
		if(detailFrmObj && detailFrmObj.rslt_type)
			detailFrmObj.rslt_type.value='N';
	}
	else
	{
		if(detailFrmObj && detailFrmObj.srv_status)
			detailFrmObj.srv_status.value="Abnormal";
		if(detailFrmObj && detailFrmObj.rslt_type)
			detailFrmObj.rslt_type.value='A';
	}
}

// Method replica of above except called onblur of MainResultValues
function checkSrvStatusChange1(indexI)
{
	notApplicable = 0;
	normal = 0;
	abNormal = 0;
	detailFrmObj = document.forms[0];
//	reportFrmObj = parent.ResultEntryReport.document.result_entry_report
	totalRecs = detailFrmObj.total_values.value;

	var headerObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	for(j=0; j<totalRecs; j++)
	{
		selectElement = eval("detailFrmObj.srv_stat"+indexI+j)

		if(selectElement.value=='')
			notApplicable++;
		else if(selectElement.value=='N')
			normal++;
		else //if(selectElement.value=='A')
			abNormal++;

	}
	srv_status = eval("detailFrmObj.srv_status"+indexI);
	rslt_type = eval("detailFrmObj.rslt_type"+indexI);
	
	header_srv_status = eval("headerObj.srv_status"+indexI);
	header_rslt_type = eval("headerObj.rslt_type"+indexI);
	if(notApplicable==totalRecs)
	{	
		srv_status.value = "Not Applicable";
		rslt_type.value = '';
		header_srv_status.value = "Not Applicable";
		header_rslt_type.value = '';
	}
	else if (abNormal > 0)
	{
		srv_status.value = "Abnormal";
		rslt_type.value = 'A';
		header_srv_status.value = "Abnormal";
		header_rslt_type.value = 'A';
	}
	else if (normal > 0)
	{
		srv_status.value = "Normal";
		rslt_type.value = 'N';
		header_srv_status.value = "Normal";
		header_rslt_type.value = 'N';
	}
	else
	{
		srv_status.value = "Abnormal";
		rslt_type.value = 'A';
		header_srv_status.value = "Abnormal";
		header_rslt_type.value = 'A';
	}
}


// function to display the message for the checked order_id if that 
// partiuclar order id is billed or not.
/*function getBillingMessage(obj,orderId,order_line_num)
{
	var billed_trxn_yn = document.forms[0].billed_trxn_yn.value;
	var msg = '';
	if(billed_trxn_yn=='Y')
	{
		var module_id = "OR";
		var facility_id= document.forms[0].facility_id.value;

		var xmlStr ="<root><SEARCH ";
		xmlStr += " order_id=\""+ orderId + "\" ";
		xmlStr += " facility_id=\""+ facility_id + "\" ";
		xmlStr += " module_id=\""+ module_id + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OrBillingValidate.jsp?order_line_num="+order_line_num,false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );
		if(message!='')
		{
			obj.checked=false;
			alert(message);
		}
		return message;
	}
	else
		return msg;
}*/

function CheckDateTime(objText)
{
	var locale		= document.forms[0].localeName.value;
	if(objText.value !='')
	{
		if(!doDateTimeChk(objText))
		{
			alert(getMessage("INVALID_DATE_FMT","CA"))
			objText.select();
			return false;
		}	
		
			var datetimeArray=objText.value.split(" ");			
			var dateArray=datetimeArray[0].split("/");			
			if(dateArray[1]==0)
			{			
				alert(getMessage("INVALID_DATE_FMT","CA"));
				objText.select();
				return false
			}
	}
} 
//checks setup--Allow Multipatient resultreporting--for orgercategory
function chkSetup(size)
{
	if((parseInt(size,10))<1)
	{
		alert(getMessage("ORDER_CATEGORY_NOT_SETUP_FOR_MULTI_PATIENT_RESULT_REPORTING","OR"));
	}
}

/*function valid_DateObj(obj,format,localeVal,ival,jval)
{
var temp=validDateObj1(obj,format,localeVal);
 //var temp=validateDateWithTime(obj);
 if((temp!=false)||(temp==undefined))
	setHeaderValue1(obj,ival,jval);
}*/
/*function Check_Date(obj,ival,jval)
{
	var temp=CheckDate(obj);
	if(temp==true)
		setHeaderValue1(obj,ival,jval);
}*/

function check_NumericResult(obj,ijval,ival,jval)
{
	var validnumber=checkNumericResult(ijval,ival,jval)
	if((validnumber!=false)||(validnumber==undefined))
	{		
		var validdecimal=OrIsValidDecimal(obj);
		if((validdecimal!=false)||(validdecimal==undefined))
		{
			setHeaderValue1(obj,ival,jval);
		}
	}
}

function check_MaxLimit(obj,val,ival,jval)
{
	var temp=checkMaxLimit(obj,val);
	if((temp!=false)||(temp==undefined))
		setHeaderValue1(obj,ival,jval);
}

function check_Time(obj,ival,jval)
{
	var temp=checkTime(obj);
	if((temp!=false)||(temp==undefined))
		setHeaderValue1(obj,ival,jval);
}


function validDateObj1(date, format, locale){	
	if (date.value != '')
	{
		if ( !validDate1(date.value, format, locale) )
		{
			if(top.header != null)
				alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
			else
				alert(getMessage("INVALID_DATE_FMT", "SM"));

			date.select();
			date.focus();
			return false;
		}
		else
			return true;
	}
}

function validDate1(date, format, locale){
	var dateFlag=true;
	var dateArr;
	var dateArr1;
	if(format=="DMY"){
		dateArr=date.split("/");
		if(dateArr[2]==0){
			dateFlag=false;
		}
		if(dateArr[2].length< 4 || dateArr[2].length>4)dateFlag=false;
	}else if(format=="DMYHM"){
		dateArr1=date.split(" ");
		dateArr=(dateArr1[0]).split("/");
		if(dateArr[2]==0){
			dateFlag=false;
		}
		if(dateArr[2].length< 4 || dateArr[2].length>4)dateFlag=false;
		
	}else if(format=="YY"){
		if(date==0){
			dateFlag=false;
		}
		if(date.length< 4 || date.length>4)dateFlag=false;
	}else if(format=="MY"){
		dateArr=date.split("/");
		if(dateArr[1]==0){
			dateFlag=false;
		}
		if(dateArr[1].length< 4 || dateArr[1].length>4)dateFlag=false;
	}
	if(dateFlag){
		var xhr =  getXHR();
		var url = "../../eCommon/jsp/DateUtils.jsp?methodName=validDate&format="+format+"&locale="+locale+"&date="+date;
		xhr.open("POST", url, false);
		xhr.setRequestHeader("Content-Type","text/plain")
		xhr.send("");
		var xmlText = xhr.responseText
		if (TrimStr(xmlText) == "true"){
			dateFlag=true;
		}else{
			dateFlag=false;
		}
	}
	return dateFlag;
}

function checkForDecInt(index,indexI,indexJ)
{
	//var formObj = document.forms[0];
	//var topform=parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var formObj = parent.multiPatientOrdersResultingMainHdr.document.forms[0];	
	resultElement = eval("formObj.number_type"+index)
		if(isNaN(resultElement.value))
	{
		resultElement.value = "";
	}
	if(resultElement.readOnly)	return false;
	if(resultElement.value=="") 	return false; 
	result	= parseFloat(trimString(resultElement.value));	
	result = resultElement.value;
	//resultElement.value = result
	IntResult = parseInt(trimString(resultElement.value));
	//IntResult = resultElement.value;
	tempResult = resultElement.value;

	resultFloatStr = "";
	resultIntStr = tempResult;
	if(tempResult.indexOf(".")>=0)
	{
		resultFloatStr = tempResult.substr(tempResult.indexOf(".")+1, tempResult.length-1)
		resultIntStr = tempResult.substr(0, tempResult.indexOf("."))
	}
	if(resultIntStr.length==0)
		resultIntStr="0";
/*Checking for the decimals constraint.*/
	num_digits_dec = parseInt(trimString(eval("formObj.dec_digits"+index).value));
	if(parseInt(resultFloatStr)==0)
	{
		resultFloatStr = "";
		result = IntResult;
		resultElement.value = IntResult;
	}
	if(resultFloatStr.length > num_digits_dec)
	{
		message = getMessage('VARIABLE_DEC_DIGIT','OR');
		alert(message.replace("@",num_digits_dec));
		resultElement.select();
		resultElement.focus();
		return;
	}

/*Checking for the number of digits constraint.*/
	resultIntLength = resultIntStr.length;
	num_digits_min = parseInt(trimString(eval("formObj.min_digits"+index).value));
	num_digits_max = parseInt(trimString(eval("formObj.max_digits"+index).value));
	if(resultIntLength < num_digits_min)
	{
		message = getMessage('RSLT_NOT_LESS_DIGIT','OR');
		alert(message.replace("@",num_digits_min));		
		resultElement.select();
		resultElement.focus();
		return ;
	}
	else if(resultIntLength > num_digits_max)
	{
		message = getMessage('RSLT_NOT_MORE_DIGIT','OR');
		alert(message.replace("@",num_digits_max));	
		resultElement.select();
		resultElement.focus();
		return ;
	}

/*Checking for the range constraint and setting the status according to the filled result.*/

	/*num_digits_min_points = parseInt(trimString(eval("formObj.num_crit_low_points_"+index).value));//before 28.12.2004
	num_digits_max_points = parseInt(trimString(eval("formObj.num_crit_high_points_"+index).value));//before 28.12.2004*/

	num_digits_min_points = trimString(eval("formObj.num_crit_low_points"+index).value);
	num_digits_max_points = trimString(eval("formObj.num_crit_high_points"+index).value);


	if(num_digits_min_points=='')	num_digits_min_points='0';
	if(num_digits_max_points=='')	num_digits_max_points='0';
	
	checkSrv = false;
	checkVal = "";
	if(trimString(eval("formObj.num_crit_low"+index).value)!="")
	{
		num_crit_low = trimString(eval("formObj.num_crit_low"+index).value);
		num_crit_high = trimString(eval("formObj.num_crit_high"+index).value);

		selectElement = eval("formObj.srv_stat"+index);
		if(result < num_crit_low)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "K";
				checkVal = "K";
				checkSrv = true;
			}
		}
		else if ((num_crit_low <= result) && (result < num_digits_min_points))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "L";
				checkVal = "L";
				checkSrv = true;
			}
		}
		else if ((num_digits_min_points <= result) && (result <= num_digits_max_points))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "N";
				checkVal = "N";
				checkSrv = true;
			}
		}
		else if ((num_digits_max_points < result) && (result <= num_crit_high))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "H";
				checkVal = "H";
				checkSrv = true;
			}
		}
		else if (num_crit_high < result)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "I";
				checkVal = "I";
				checkSrv = true;
			}
		}
	}
	else
	{
		selectElement = eval("formObj.srv_stat"+index);

		if ((num_digits_min_points <= result) && (result <= num_digits_max_points))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "N";
				checkVal = "N";
				checkSrv = true;
			}
		}
		else if (result < num_digits_min_points)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "L";
				checkVal = "L";
				checkSrv = true;
			}
		}else if (num_digits_max_points < result)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "H";
				checkVal = "H";
				checkSrv = true;
			}
		}
		else
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			{
				selectElement.value = "I";
				checkVal = "I";
				checkSrv = true;
			}
		}
	}

	if(checkSrv)
	{
		if(indexI != undefined && indexJ != undefined)
		{
			var headerObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
			var header_srv_stat = eval("headerObj.header_srv_stat"+index);
			var srv_stat = eval("formObj.srv_stat"+index);

			srv_stat.value = checkVal;
			header_srv_stat.value = checkVal;
			checkSrvStatus_Change1(indexI);
		}
		else
		{
			checkSrvStatus_Change()
		}
	}

}


function checkSrvStatus_Change()
{
	notApplicable = 0;
	normal = 0;
	abNormal = 0;	
	detailFrmObj = parent.multiPatientOrdersResultingMainHdr.document.forms[0];
	totalRecs = detailFrmObj.total_values.value;
	for(i=0; i<totalRecs; i++)
	{
		selectElement = eval("detailFrmObj.srv_stat"+i)

		if(selectElement.value=='')
			notApplicable++;
		else if(selectElement.value=='N')
			normal++;
		else //if(selectElement.value=='A')
			abNormal++;

	}
	if(notApplicable==totalRecs)
	{	
		if(detailFrmObj && detailFrmObj.srv_status)
			detailFrmObj.srv_status.value="Not Applicable";
		if(detailFrmObj && detailFrmObj.rslt_type)
			detailFrmObj.rslt_type.value='';
	}
	else if (abNormal > 0)
	{
		if(detailFrmObj && detailFrmObj.srv_status)
			detailFrmObj.srv_status.value="Abnormal";
		if(detailFrmObj && detailFrmObj.rslt_type)
			detailFrmObj.rslt_type.value='A';
	}
	else if (normal > 0)
	{
		if(detailFrmObj && detailFrmObj.srv_status)
			detailFrmObj.srv_status.value="Normal";
		if(detailFrmObj && detailFrmObj.rslt_type)
			detailFrmObj.rslt_type.value='N';
	}
	else
	{
		if(detailFrmObj && detailFrmObj.srv_status)
			detailFrmObj.srv_status.value="Abnormal";
		if(detailFrmObj && detailFrmObj.rslt_type)
			detailFrmObj.rslt_type.value='A';
	}
}

function checkSrvStatus_Change1(indexI)
{
	notApplicable = 0;
	normal = 0;
	abNormal = 0;
	detailFrmObj = parent.multiPatientOrdersResultingMainHdr.document.forms[0];
	totalRecs = detailFrmObj.total_values.value;
	var headerObj = parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	for(j=0; j<totalRecs; j++)
	{
		selectElement = eval("detailFrmObj.srv_stat"+indexI+j)

		if(selectElement.value=='')
			notApplicable++;
		else if(selectElement.value=='N')
			normal++;
		else //if(selectElement.value=='A')
			abNormal++;

	}
	srv_status = eval("detailFrmObj.srv_status"+indexI);
	rslt_type = eval("detailFrmObj.rslt_type"+indexI);
	
	header_srv_status = eval("headerObj.srv_status"+indexI);
	header_rslt_type = eval("headerObj.rslt_type"+indexI);
	if(notApplicable==totalRecs)
	{	
		srv_status.value = "Not Applicable";
		rslt_type.value = '';
		header_srv_status.value = "Not Applicable";
		header_rslt_type.value = '';
	}
	else if (abNormal > 0)
	{
		srv_status.value = "Abnormal";
		rslt_type.value = 'A';
		header_srv_status.value = "Abnormal";
		header_rslt_type.value = 'A';
	}
	else if (normal > 0)
	{
		srv_status.value = "Normal";
		rslt_type.value = 'N';
		header_srv_status.value = "Normal";
		header_rslt_type.value = 'N';
	}
	else
	{
		srv_status.value = "Abnormal";
		rslt_type.value = 'A';
		header_srv_status.value = "Abnormal";
		header_rslt_type.value = 'A';
	}
}

function changeColorIfDiff(obj,iVal,jVal)
{
	var topform=parent.multiPatientOrdersResultingMainHdr.document.multiPatientOrdersResultingMainHdr;
	var objectName;
	var objName = obj.name;
	objectName=objName.substring(0,(objName.length)-2);	
	objectName=objectName+jVal;	
	var temp=eval("topform."+objectName);		
	var downObj = parent.multiPatientOrdersResultingMainResultValues.document.multiPatientORMainResultValues;
	var header_obj = eval("downObj."+obj.name);

	if(trimString(header_obj.value)!=trimString(temp.value))
		obj.className='DUPLICATE';
	else
		obj.className='';
}

