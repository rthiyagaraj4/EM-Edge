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
var boolType = false;
var boolCode = false;
 
function OrderCategoryDesc()
{
	//removeListItems(document.frmOrderablesBySource.p_fr_order_type_code,document.frmOrderablesBySource.p_to_order_type_code);
	var n= document.frmOrderablesBySource.p_fr_order_type_code.options.length;	
	var n1= document.frmOrderablesBySource.p_to_order_type_code.options.length;
	for(var i=0;i<n;i++){
		document.frmOrderablesBySource.p_fr_order_type_code.remove("p_fr_order_type_code");			
	}
	for(var i=0;i<n1;i++){
		document.frmOrderablesBySource.p_to_order_type_code.remove("p_to_order_type_code");			
	}
	

	var order_category = document.frmOrderablesBySource.p_order_category.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/OROrderablesBySourceValidate.jsp?order_category=" + order_category , false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}

function OrderCode()
{
	
	var n= document.frmOrderablesBySource.p_fr_source_code.options.length;	
	var n1= document.frmOrderablesBySource.p_to_source_code.options.length;
	for(var i=0;i<n;i++){
		document.frmOrderablesBySource.p_fr_source_code.remove("p_fr_source_code");			
	}
	for(var i=0;i<n1;i++){
		document.frmOrderablesBySource.p_to_source_code.remove("p_to_source_code");			
	
	}
	 
	var order_code = document.frmOrderablesBySource.p_source_type.value;

	if (order_code=="")
	{
		var oOption = document.createElement("OPTION");
		oOption.text = getLabel("Common.all.label","Common");
		oOption.value = "";
		document.frmOrderablesBySource.p_fr_source_code.add(oOption);
		var oOption1 = document.createElement("OPTION");
		oOption1.text = getLabel("Common.all.label","Common");
		oOption1.value = "";
		document.frmOrderablesBySource.p_to_source_code.add(oOption1);

		return;
	}
	
	var facility_id = document.frmOrderablesBySource.p_facility_id.value;
		//alert(order_code);
		//alert(facility_id);
	
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
	
		xmlStr ="<root><SEARCH /></root>" ;
	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
		xmlHttp.open( "POST", "../../eOR/jsp/OROrderablesBySourceValidateTemp.jsp?order_code=" + order_code + "&facility_id=" + facility_id, false ) ;
		
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		//alert(responseText);
		eval(responseText);
		
}

function fillOrderTypeValues(type, desc)
{
	//boolType = 
	//var oOption;
	//if(boolType == true)
	//{
		var oOption = document.createElement("OPTION");
		oOption.text = desc;
		oOption.value = type;
		document.frmOrderablesBySource.p_fr_order_type_code.add(oOption);
		var oOption1 = document.createElement("OPTION");
		oOption1.text = desc;
		oOption1.value = type;
		document.frmOrderablesBySource.p_to_order_type_code.add(oOption1);
	//}
}

function fillSourceCodeValues(type,desc)
{
	//boolCode = 
	//var oOption;
	//if(boolCode == true)
	//{
		
		var ele = document.createElement("OPTION");
		ele .text = desc;
		ele .value = type;
		document.frmOrderablesBySource.p_fr_source_code.add(ele);
		var ele1 = document.createElement("OPTION");
		ele1.text = desc;
		ele1.value = type;
		document.frmOrderablesBySource.p_to_source_code.add(ele1);
		
	//}
}

/*function fillSourceCodeValues1(type,desc)
{
	//boolCode = 
	//var oOption;
	//if(boolCode == true)
	//{
		var ede = document.createElement("OPTION");
		ede .text = desc;
		ede .value = type;
		document.frmOrderablesBySource.p_fr_source_code.add(ede);
		var ede1 = document.createElement("OPTION");
		ede1.text = desc;
		ede1.value = type;
		document.frmOrderablesBySource.p_to_source_code.add(ede1);
		
	//}
}*/
function removeListItems(targetFrom,targetTo)
{
	//alert("in remove");
	var length1 = targetFrom.length;
	var length2 = targetTo.length;

	for(var i=1;i<length1;i++)
	{
		targetFrom.remove(i);
	}
	for(var i=1;i<length2;i++)
	{
		targetTo.remove(i);
	}
	return true;
}

function run()
{
	if(searchResultFrame.document.frmOrderablesBySource) 
	{
		if(searchResultFrame.document.frmOrderablesBySource.p_source_type.value == '')
		{
			message = getMessage("SOURCE_TYPE_BLANK","OR");
			messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
			searchResultFrame.document.frmOrderablesBySource.p_source_type.focus();
		}
		else
		{
			//if(CheckString("Orderable By Source", searchResultFrame.document.frmOrderablesBySource.source_type, searchResultFrame.document.frmOrderablesBySource.from_period,searchResultFrame.document.frmOrderablesBySource.to_period, messageFrame)) 
			searchResultFrame.document.frmOrderablesBySource.p_fr_date.focus();
			var from_period = searchResultFrame.document.frmOrderablesBySource.p_fr_date.value;
			var fr_date = from_period.split("/");
			var fr_month = fr_date[0];
			var fr_year = fr_date[1];
			var to_period = searchResultFrame.document.frmOrderablesBySource.p_to_date.value;
			var to_date = to_period.split("/");
			var to_month = to_date[0];
			var to_year = to_date[1];
			
			if(fr_year == to_year)
			{
				if(fr_month > to_month)
				{
					message = getMessage("TO_DT_GR_EQ_FM_DT","SM");
					messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
					searchResultFrame.document.frmOrderablesBySource.p_fr_date.focus();
				}
				
				else
				{	//alert(searchResultFrame.document.frmOrderablesBySource.p_fr_source_code.value)
				//alert(searchResultFrame.document.frmOrderablesBySource.p_to_source_code.value)

					searchResultFrame.document.frmOrderablesBySource.submit(); 
				}
			}
			else
			{
				if(fr_year < to_year)
				{
					if( (to_year - fr_year) >=2)
					{
						message = getMessage("MAX_LMT_PERIOD_MONTH","OR");
						messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
						searchResultFrame.document.frmOrderablesBySource.p_fr_date.focus();
					}
					else
					{
						var tot = (12 - Math.abs(fr_month)) + Math.abs(to_month);
						if( tot >= 12)
						{
							message = getMessage("MAX_LMT_PERIOD_MONTH","OR");
							messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
							searchResultFrame.document.frmOrderablesBySource.p_fr_date.focus();
						}
						else
						{
							//alert(searchResultFrame.document.frmOrderablesBySource.p_fr_order_type_code.value)
							//alert(searchResultFrame.document.frmOrderablesBySource.p_to_order_type_code.value)

							searchResultFrame.document.frmOrderablesBySource.submit(); 
						}
					}
				}
				else
				{
					message = getMessage("TO_DT_GR_EQ_FM_DT","SM");
					messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
					searchResultFrame.document.frmOrderablesBySource.p_fr_date.focus();
				}
			}
		}
		
	}
}

function reset()
{
	parent.frames[1].frames[1].location.href="../../eOR/jsp/OROrderablesBySource.jsp";
}

function checkDate(target)
{
	var date = target.value;
	var temp = date.split("/");
	if(temp == '' || temp == null || temp == ' ')
	{
		
		message = getMessage("MONTH_YEAR_INVALID","SM");
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		target.focus();
	}
	else
	{
		var mon = temp[0];
		var year = temp[1];
		if( mon>=1)
		{
			if(mon>=13)
			{
				
				message = getMessage("MONTH_YEAR_INVALID","SM");
				parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+message;
				target.focus();
			}
			else
			{
				if(year <= 999 && year > 9999)
				{
					
					message = getMessage("MONTH_YEAR_INVALID","SM");
					parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+message;
					target.focus();
				}
				else
				{
					//message = "";
					//parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+message;
				}
			}
		}
		else
		{
			
			message = getMessage("MONTH_YEAR_INVALID","SM");
			parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+message;
			target.focus();
		}
	}	
}

function CheckForSpecChars(event){
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) 
	{
		message = getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM"); // Not a valid key
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		return false;
	}
	else
	{
		message = "";
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+message;
	}
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);

}
