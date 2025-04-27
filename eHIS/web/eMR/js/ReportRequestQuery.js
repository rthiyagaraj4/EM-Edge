

function Valid_DT(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}
	
function submitPage()
{
	var condition="";
	for(var i=0; i<document.forms[0].elements.length; i++)
	{ 		
		condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&" 
	}

	if(parent.frames[3].name == "resultFrame")
	{
		parent.frames[3].location.href="../../eMR/jsp/ReportRequestQueryResult.jsp?"+document.forms[0].queryStr.value+"&"+condition ;
	}
	else
	{
		parent.frames[2].location.href="../../eMR/jsp/ReportRequestQueryResult.jsp?"+document.forms[0].queryStr.value+"&"+condition ;
	}
}

function clear_All()
{
	var callFunction =document.forms[0].call_function.value ;
//	document.ReportRequestQuery_Form.reset();
	parent.resultFrame.document.location.href ='../../eCommon/html/blank.html'; 
	if(parent.messageFrame)
		parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


	
function compareDates(obj)
{
	if(!doDateCheckAlert(document.forms[0].from_date,document.forms[0].to_date))
	{
		alert(getMessage("TO_DT_GR_EQ_FM_DT",'SM'));
		document.forms[0].to_date.select();
		document.forms[0].to_date.focus();
	}
}

async function getRequestor(obj,target) //Function to obtain Procedure classification
{
	var retVal =    new String();               
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale = document.forms[0].locale.value;
	var tit = getLabel("Common.Requestor.label","Common");
	var sql="select requestor_code code, short_name description from MR_REQUESTOR_LANG_VW where LANGUAGE_ID ='"+locale+"' and eff_status='E' and upper(requestor_code) like upper(?) and upper(short_name) like upper(?) order by 2";
	 
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		} 
	if(retVal != null && retVal != "" )
	{					
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].requestor_desc.value=arr[1];					
		document.forms[0].requestor_code.value=arr[0];
	}
	else
	{
		document.forms[0].requestor_desc.value="";					
		document.forms[0].requestor_code.value="";
	}
}
		
function chkGetRequestor() //Call getRequestor function if the description field is empty
{
	if(document.forms[0].requestor_desc.value=="") {}
	else 
	{ 
		getRequestor(document.forms[0].requestor_lookup,document.forms[0].requestor_desc); 
	}
}

function reset()
{	
	criteriaFrame.document.ReportRequestQuery_Form.reset() ;
	resultFrame.document.location.href="../../eCommon/html/blank.html";
}


/*Added by Ashwini on 25-Feb-2019 for MO-CRF-20149*/
function getForwPractLookupVal() 
{
	if(document.forms[0].fwd_pract_desc.value != "")
		getPractLookupID(document.forms[0].fwd_pract_id_search);
	else
		document.forms[0].fwd_practitioner_id.value = "";
}

function getPrepPractLookupVal() 
{
	if(document.forms[0].prep_pract_desc.value != "")
		getPractLookupID(document.forms[0].prep_pract_id_search);
	else
		document.forms[0].prep_practitioner_id.value = "";
}

function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].authorized_practid.value=arr[0];
		document.forms[0].pract_descn.value=arr[1];	
	}
	else
	{
		document.forms[0].authorized_practid.value="";
		document.forms[0].pract_descn.value="";			
	}
}

 function getPractLookupID(obj)
{ 
	var facility_id	= document.forms[0].facility_id.value;
	var target = "";

	if(obj.name == 'prep_pract_id_search'){
	target = document.forms[0].prep_pract_desc;
	}
	else if(obj.name == 'fwd_pract_id_search'){
	target = document.forms[0].fwd_pract_desc;
	}

	getPractitioner(obj,target,facility_id,"Q2");
} 
/*End MO-CRF-20149*/
