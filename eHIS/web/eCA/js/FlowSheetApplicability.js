function create() {
	
f_query_add_mod.location.href='../../eCA/jsp/FlowSheetApplicabilityIntermediate.jsp?mode=insert';
	//parent.parent.frames[1].frames[1].document.getElementById("assignChart").rows = "42,*,235,50"
	//assignChart.rows = "42,*,0,50";
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="39vh";
	document.getElementById("f_query_add_mod_display").style.height="45vh";
	document.getElementById("messageFrame").style.height="9vh";
	
}

function query()
{
	f_query_add_mod_display.location.href='../../eCommon/html/blank.html';
	f_query_add_mod.location.href='../../eCA/jsp/FlowSheetApplicabilityQueryCriteria.jsp';
	//parent.parent.frames[1].frames[1].document.getElementById("assignChart").rows = "42,*,0,50"
	//assignChart.rows = "42,*,0,50";
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="83vh";
	document.getElementById("f_query_add_mod_display").style.height="0vh";
	document.getElementById("messageFrame").style.height="9vh";
}

function apply(){
	if (f_query_add_mod.location.href.indexOf("FlowSheetApplicabilityQueryResult.jsp") != -1) {	
		commontoolbarFrame.location.reload()
		return false;
	}
	if (f_query_add_mod.location.href.indexOf("FlowSheetApplicabilityIntermediate.jsp") != -1)
	{
		var mode= f_query_add_mod.document.forms[0].mode.value;
		if(mode=="modify")
		{
			commontoolbarFrame.location.reload()
			return false;
		}
	}

	var fields = new Array(f_query_add_mod.document.forms[0].lookup);
    var names = new Array (getLabel("eCA.FlowSheet.label",'CA'));
	if(f_query_add_mod.document.forms[0].mode != null)
	{
		if(checkFieldsofMst(fields, names, messageFrame)){	
			f_query_add_mod.document.forms[0].patclass.disabled = false;
			f_query_add_mod.document.forms[0].speciality.disabled = false;
			f_query_add_mod.document.forms[0].pctr.disabled = false;

			f_query_add_mod.document.forms[0].submit();
		}
	}
	else
	{
		
		commontoolbarFrame.location.reload()
	}
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0] != null)
	{
		if(f_query_add_mod.document.forms[0].mode.value == "delete")
		{
			f_query_add_mod.location.href='../../eCommon/html/blank.html';
			f_query_add_mod_display.location.href='../../eCommon/html/blank.html';

		}
		else if(f_query_add_mod.document.forms[0].mode.value == "insert")
		{
			f_query_add_mod.location.reload();
			f_query_add_mod_display.location.href='../../eCommon/html/blank.html';
		}
		else
		{
			f_query_add_mod.location.href='../../eCommon/html/blank.html';
			f_query_add_mod_display.location.href = '../../eCommon/html/blank.html'
		}
	}
}
function deleterecord()
{
	if(f_query_add_mod.document.forms[0]!=null){
	var status =f_query_add_mod.document.forms[0].mode.value;
	if(status=="insert")
		{
			commontoolbarFrame.location.reload()
			return false;
		}
	if(status != "insert")
    {
		f_query_add_mod.document.forms[0].patclass_del.disabled = false;
		f_query_add_mod.document.forms[0].speciality_del.disabled = false;
		f_query_add_mod.document.forms[0].pctr_del.disabled = false;
		f_query_add_mod.document.forms[0].lookup_del.disabled = false;
		var model="delete";
		if(window.confirm(getMessage("DELETE_RECORD",'common')) == true)
		{
			f_query_add_mod.document.forms[0].mode.value = model;
			f_query_add_mod.document.forms[0].submit();
		}
		else
		{
			
				commontoolbarFrame.location.reload();
				return false;
		}	
	}
	}
	else
	{
			var messsage=getMessage("RECORD_CANNOT_DELETE",'CA')
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+messsage;
	}
}



function reset()
{
	if(f_query_add_mod.location.href.indexOf("AssignChartSummCriteria.jsp") != -1){	
					f_query_add_mod.location.reload();
					return false;
	}
	if(f_query_add_mod.location.href.indexOf("FlowSheetApplicabilityQueryResult.jsp") != -1){	
					
					return false;
	}
	
	 if(f_query_add_mod.document.forms[0] != null)
	 {
	  //if(f_query_add_mod.document.forms[0].mode.value=="insert")
	   f_query_add_mod.location.reload();
	  //  if(f_query_add_mod.document.forms[0].mode.value=="modify")
		//{
		//	f_query_add_mod.location.reload();
		//	 f_query_add_mod_display.location.reload();
		//}
	 
	}
	 messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
}
function change()
{
		var selectObj = document.getElementsByTagName("SELECT").item(0);
		var selIndex = document.forms[0].patclass.selectedIndex;
		var selOptionValue = selectObj.options[document.forms[0].patclass.selectedIndex].text;
	    // alert(selOptionValue);
}
function change1()
{
		var selectObj = document.getElementsByTagName("SELECT").item(1);
		var selIndex = document.forms[0].summary.selectedIndex;
		var selOptionValue = selectObj.options(document.forms[0].summary.selectedIndex).text;
}

/*function CheckForSpecCharsSpaceBlur()
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}*/

function resetValues()
{
   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}

async function checkFlow(flowObject)
{
	if(flowObject.name=='lookup')
		{
			var target  = document.forms[0].lookup;
		
			if((target.value) == "null" || (target.value ==""))
			{
				return false;			
			}
			else
			{
				await showFlowWindow();
			}
		}
		else if(flowObject.name=='searchsp2')
		{		
			await showFlowWindow();
		}
		
}

async function showFlowWindow()
{
		var target	= document.forms[0].lookup;
		var practr=document.forms[0].pctr.value;	
		var sql="Select flow_sheet_id code, short_desc description from ca_flow_sheet where eff_status = 'E'  and upper(flow_sheet_id) like upper(?) and upper(short_desc) like upper(?) order by 2";
		//and practr_txt= '"+practr+"'
		var title	= getLabel("eCA.FlowSheet.label","CA");
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title,argArray );
		
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")	
		{
			document.forms[0].lookup.value = arr[1];
			document.forms[0].flowsheet1.value = arr[0];
		}
		else
		{
			document.forms[0].lookup.value=arr[1];
			document.forms[0].flowsheet1.value=arr[0];
			//target.focus();
		}
}
/*function getFlowsheetId()
{
		var target= document.forms[0].pctr;
		var retVal	=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var title=getLabel("eCA.FlowSheet.label","CA");
		var sql="Select flow_sheet_id, short_desc from ca_flow_sheet where eff_status = `E`"; //order by short_desc"; 
 

        var practr=document.forms[0].pctr.value;		
		search_code="flow_sheet_id";
		search_desc="short_desc";
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&practr_txt="+practr+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
		   	 arr=retVal.split("::");
		    document.forms[0].lookup.value=arr[0];
			document.forms[0].flowsheet1.value=arr[1];
			document.forms[0].lookup.focus();
		}
	}*/

async function showPract(practObject)
{
	
		if(practObject.name=='pctr')
		{
			var target  = document.forms[0].pctr;
		
			if((target.value) == "null" || (target.value ==""))
			{
				return false;			
			}
			else
			{
				await showPractWindow();
			}
		}
		else if(practObject.name=='searchsp2')
		{		
			await showPractWindow();
		}
	
}
async function showPractWindow()
{
		var target	= document.forms[0].pctr;
		var pract_type=document.forms[0].patclass.value;
		var sql="Select practitioner_id code, practitioner_name description from am_practitioner where eff_status = 'E' and pract_type= '"+pract_type+"' and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
		var title	= getLabel("Common.practitioner.label","COMMON");
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		if(target.value!="All")
	    {
			retArray =await  CommonLookup( title,argArray );
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retArray != null && retArray !="")	
			{
				document.forms[0].pctr.value = arr[1];
				document.forms[0].practitioner.value = arr[0];
			}
			else
			{
				document.forms[0].pctr.value="All";
				document.forms[0].practitioner.value="*ALL";
				//target.focus();
			}
		}
}




async function showSpecialtyWindow(specialtyObject)
{
	if(specialtyObject.name=='speciality')
	{
		var target  = document.forms[0].speciality;
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			await showSection();
		}
	}
	else if(specialtyObject.name=='searchspl')
	{		
		await showSection();
	}

}

async function showSection(){
		var target	= document.forms[0].speciality;					
		var sql="Select speciality_code code, short_desc description from am_speciality where eff_status ='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
		var title	= getLabel("Common.speciality.label","COMMON");
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		if(target.value!="All")
	    {
			retArray = await CommonLookup( title,argArray );
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retArray != null && retArray !="")	
			{
				document.forms[0].speciality.value = arr[1];
				document.forms[0].spl.value = arr[0];
			}
			else
			{
				document.forms[0].speciality.value="All";
				document.forms[0].spl.value="*ALL";
				//target.focus();
			}
		}
}



/*function getSpecialityCode2()
	{
		
		var target			= document.forms[0].speciality;
		var retVal			=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("Common.speciality.label","COMMON");
		//var pract_type=document.forms[0].patclass.value;

        var sql="Select speciality_code, short_desc from am_speciality where eff_status =`E`"; //order by 2";		
        //var sql="Select practitioner_id, practitioner_name from am_practitioner where eff_status = `E` and pract_type= `"+pract_type+"` ";

		
		search_code="speciality_code";
		search_desc="short_desc";
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			//alert("retval"+retVal);
		   	arr=retVal.split("::");
		   	document.forms[0].speciality.value=arr[0];
			document.forms[0].spl.value=arr[1];
			document.forms[0].speciality.focus();
		}
	}*/
function CheckForSpeChar(event)
{
 var strCheck=
'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
  var whichCode = (window.Event) ? event.which : event.keyCode;
 key = String.fromCharCode(whichCode);  
    if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key

}	

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function enableSearch(event)
{
	if(parent.frames[1].document.forms[0].speciality.value){	
	searchEnable(parent.frames[1].document.forms[0].searchspl);
    } 
}

function searchEnable(obj){
	if(parent.frames[1].document.forms[0].searchspl.disabled==true){
	parent.frames[1].document.forms[0].searchspl.disabled=false;
	
	}
}

function enableSearch1(event)
{
 if(parent.frames[1].document.forms[0].pctr.value){
	searchEnable1(parent.frames[1].document.forms[0].searchsp2);
	}
}

function searchEnable1(obj){
 
	//alert("HI there");
	if(parent.frames[1].document.forms[0].searchsp2.disabled==true){
	parent.frames[1].document.forms[0].searchsp2.disabled=false;
	}
}


function callfunction(){
var target=parent.frames[1].document.forms[0].pctr;
var practval= parent.frames[1].document.forms[0].pctr.value;
var retVal=  new String();
var dialogTop	= "40";
var dialogHeight= "10" ;
var dialogWidth= "40" ;
var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
var arguments	= "" ;
var search_desc	= "";
var title=getLabel("Common.practitioner.label","common");
var sql="SELECT practitioner_id code,short_name description FROM am_practitioner where EFF_STATUS ='E' and upper(short_name) like upper(?) and upper(practitioner_id) like upper(?)";
var argArray = new Array();
var namesArray = new Array();
var valuesArray = new Array();
var datatypesArray = new Array();
argArray[0] = sql;
argArray[1] = namesArray;
argArray[2] = valuesArray;
argArray[3] = datatypesArray;
argArray[4] = "2,1";
argArray[5] = target.value;
argArray[6] = DESC_LINK;
argArray[7] = DESC_CODE;
if(parent.frames[1].document.forms[0].pctr.value!="ALL" && parent.frames[1].document.forms[0].pctr.value!=""){
retArray = CommonLookup(encodeURIComponent(title,"UTF-8"),argArray);
if(retArray != null && retArray !=""){
parent.frames[1].document.forms[0].pctr.value = retArray[1];
parent.frames[1].document.forms[0].practitioner.value=retArray[0];
parent.frames[1].document.forms[0].searchsp2.disabled=false;

}//if
else {
parent.frames[1].document.forms[0].pctr.value = "ALL";
parent.frames[1].document.forms[0].practitioner.value = "*ALL";
parent.frames[1].document.forms[0].searchsp2.disabled=false;

}
}//if
//alert("Practitioner="+parent.frames[1].document.forms[0].practitioner.value);
parent.frames[3].location.href='../../eCommon/jsp/error.jsp';
}//callfunction


//Functions for the file name AssignChartSumm.jsp-start

function setValue()
{
	document.forms[0].flag.value='false'
}
function setValueSpecialty()
{
	document.forms[0].flagSpecialty.value='false'
}
function getValueSpecialty()
{
	if(document.forms[0].speciality.value=='ALL')
	{
		document.forms[0].flagSpecialty.value='true'
	}
		if(document.forms[0].mode.value=='modify')
	{
		document.forms[0].flagSpecialty.value='true'
	}
}
function getValue()
{
	if(document.forms[0].pctr.value=='ALL')
	{
		document.forms[0].flag.value='true'
	}
		if(document.forms[0].mode.value=='modify')
	{
		document.forms[0].flag.value='true'
	}
}
function disableSummary(objSummary)
	{
		if(objSummary.selectedIndex==0)
		{
			parent.f_query_add_mod_display.location.href='../../eCommon/html/blank.html'
		}
		else
		{
			parent.f_query_add_mod_display.location.href ="../../eCA/jsp/AssignChartSummPreview.jsp?summaryId="+document.Assign.summary.value+"&summaryDesc="+objSummary.options[objSummary.selectedIndex].text
		}
		getValue()
}
function checkRec(obj)
{
   if(obj.value=="" || obj.value=="null")
	{
	    obj.value="ALL";
		document.forms[0].practitioner.value="*ALL";
		document.forms[0].flag.value='true'
	}
	 if (obj.value!="" && obj.value!= "ALL" ){
	HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='AssignChartSummSearch.jsp'><input type=hidden name='pract' id='pract' value='"+obj.value+"' </form></body></html>"
	//top.frames[1].frames[1].frames[3].document.write(HTMLVal);
	//top.frames[1].frames[1].frames[3].document.tempForm.submit();
	top.content.master_pages.messageFrame.document.write(HTMLVal);
	top.content.master_pages.messageFrame.document.tempForm.submit();

	
	}
}
function checkSpl(obj)
{
	if(obj.value=="" || obj.value=="null")
	{
	    obj.value="ALL";
		document.forms[0].spl.value="*ALL";
		document.forms[0].flagSpecialty.value='true'
	}
	if (obj.value!="" && obj.value!= "ALL" ){
	HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='splForm' id='splForm' method='post' action='AssignChartSummSearchCriteria.jsp'><input type=hidden name='speci' id='speci' value='"+obj.value+"' </form></body></html>"
	//top.frames[1].frames[1].frames[3].document.write(HTMLVal);
	//top.frames[1].frames[1].frames[3].document.splForm.submit();


	top.content.master_pages.messageFrame.document.write(HTMLVal);
	top.content.master_pages.messageFrame.document.splForm.submit();
   }
   else
	{
	   return false
	}
}

function func_assign()
{
	document.forms[0].short_desc1.value=document.forms[0].short_desc.value;
	document.forms[0].long_desc1.value=document.forms[0].long_desc.value;
}

//Functions for the file name FlowsheetApplicability.jsp-end

