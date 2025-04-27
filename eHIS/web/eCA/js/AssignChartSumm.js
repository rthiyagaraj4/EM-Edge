 function create() {
f_query_add_mod.location.href='../../eCA/jsp/AssignChartSumm.jsp?mode=insert';
	//parent.parent.frames[1].frames[1].document.getElementById("assignChart").rows = "42,*,235,50"
	//assignChart.rows = "42,*,0,50";
}
function query()
{
	f_query_add_mod_display.location.href='../../eCommon/html/blank.html';
	f_query_add_mod.location.href='../../eCA/jsp/AssignChartSummCriteria.jsp';
	//parent.parent.frames[1].frames[1].document.getElementById("assignChart").rows = "42,*,0,50"
	//assignChart.rows = "42,*,0,50";
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="70vh";
	document.getElementById("f_query_add_mod_display").style.height="10vh";
	document.getElementById("messageFrame").style.height="12vh";
}
function apply(){

	if(f_query_add_mod.document.Assign != null) //CHL-CRF [Ramesh]
	{											//CHL-CRF [Ramesh]
		var fields = new Array(f_query_add_mod.document.forms[0].summary);
		var names = new Array (getLabel("Common.Summary.label",'common'));
		if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.checkFieldsofMst(fields, names, messageFrame)){
				//CHL-CRF Start.[Nijitha]
				if(f_query_add_mod.document.forms[0].pctr.value!="" && f_query_add_mod.document.forms[0].speciality.value!="")//nIJI
				{			
				//CHL-CRF End.[Nijitha] 
				f_query_add_mod.document.forms[0].patclass.disabled = false;
				f_query_add_mod.document.forms[0].speciality.disabled = false;
				f_query_add_mod.document.forms[0].pctr.disabled = false;
				f_query_add_mod.document.forms[0].submit();
				//CHL-CRF Start.[Nijitha]
				}
				else
				{
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=Practitioner/Speciality Cannot Be Empty";
				return false ;
				}
				//CHL-CRF End.[Nijitha]
			}
		}
		else
		{
			commontoolbarFrame.location.reload()
		}
	}//CHL-CRF Start.[Ramesh]
	else
	{
		message  = getMessage("NOT_VALID","CA");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}	//CHL-CRF End.[Ramesh]
}//apply
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
	if(f_query_add_mod.document.forms[0]!=null && f_query_add_mod.document.forms[0].mode!=null){
	var status =f_query_add_mod.document.forms[0].mode.value;
	
	if(status != "insert")
    {
		f_query_add_mod.document.forms[0].patclass.disabled = false;
		f_query_add_mod.document.forms[0].speciality.disabled = false;
		f_query_add_mod.document.forms[0].pctr.disabled = false;
		var model="delete";
		if(window.confirm(getMessage("DELETE_RECORD","Common")) == true)
		{
			f_query_add_mod.document.forms[0].mode.value = model;
			f_query_add_mod.document.forms[0].submit();
		}
		else
		{
			f_query_add_mod.document.forms[0].patclass.disabled = true;
			f_query_add_mod.document.forms[0].speciality.disabled = true;
			f_query_add_mod.document.forms[0].pctr.disabled = true;
			commontoolbarFrame.location.reload();
		}	
	}
	else
		{
			//CHL-CRF Start.[Nijitha]
			var error=getMessage("RECORD_CANNOT_DELETE",'CA');	
			//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+messageArray["RECORD_CANNOT_DELETE"]
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
			//CHL-CRF End.[Nijitha]
		}
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function reset()
{
	if(f_query_add_mod.location.href.indexOf("AssignChartSummCriteria.jsp") != -1){	
					f_query_add_mod.location.reload();
					return false;
	}
	 if(f_query_add_mod.document.forms[0] != null)
	{
	  if(f_query_add_mod.document.forms[0].mode.value=="insert")
	   f_query_add_mod.location.reload();
	    if(f_query_add_mod.document.forms[0].mode.value=="modify")
		{
			f_query_add_mod.location.reload();
			 f_query_add_mod_display.location.reload();
		}
	 
	}
	 messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
}
function change()
{
		var selectObj = document.getElementsByTagName("SELECT").item[0];
		var selIndex = document.forms[0].patclass.selectedIndex;
		var selOptionValue = selectObj.options(document.forms[0].patclass.selectedIndex).text;
	    // alert(selOptionValue);
}
function change1()
{
		var selectObj = document.getElementsByTagName("SELECT").item[1];
		var selIndex = document.forms[0].summary.selectedIndex;
		var selOptionValue = selectObj.options(document.forms[0].summary.selectedIndex).text;
}
function checkBlur()
{
	if(document.forms[0].flag.value !="true")
	{
		return false
	}
	else
	{
		getPractitionerId()
	}
}

async function getPractitionerId()
{
		var target= document.forms[0].pctr;
		var retVal	=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var title=getLabel("Common.practitioner.label","common");
		var sql="SELECT practitioner_id,short_name from am_practitioner where eff_status=`E`";
        var practr=document.forms[0].pctr.value;
		search_code="practitioner_id";
		search_desc="short_name";
	retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&practr_txt="+practr+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
		   	 arr=retVal.split("::");
		    document.forms[0].pctr.value=arr[0];
			document.forms[0].practitioner.value=arr[1];
			document.forms[0].pctr.focus();
		}
	}

function validateSpecialty()
{
	if(document.forms[0].flagSpecialty.value !="true")
	{
		return false;
	}
	else
	{
		getSpecialityCode()
	}
}
async function getSpecialityCode()
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
		var sql="SELECT speciality_code, short_desc from am_speciality where eff_status=`E`";
		search_code="speciality_code";
		search_desc="short_desc";
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
		   	arr=retVal.split("::");
		   	document.forms[0].speciality.value=arr[0];
			document.forms[0].spl.value=arr[1];
			document.forms[0].speciality.focus();
		}
	}
function CheckForSpeChar(event)
{
 var strCheck=
'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
  var whichCode = (window.Event) ? event.which : event.keyCode;
 key = String.fromCharCode(whichCode);  
    if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key

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
 
	if(parent.frames[1].document.forms[0].searchsp2.disabled==true){
	parent.frames[1].document.forms[0].searchsp2.disabled=false;
	}
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


function resetValues()
{
   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}
async function callfunction(){
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
if(parent.frames[1].document.forms[0].pctr.value!=getLabel("Common.all.label","Common") && parent.frames[1].document.forms[0].pctr.value!=""){
retArray = await CommonLookup(title,argArray);
var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
if(retArray != null && retArray !=""){
parent.frames[1].document.forms[0].pctr.value = arr[1];
parent.frames[1].document.forms[0].practitioner.value=arr[0];
parent.frames[1].document.forms[0].searchsp2.disabled=false;

}//if
else {
parent.frames[1].document.forms[0].pctr.value = getLabel("Common.all.label","Common");
parent.frames[1].document.forms[0].practitioner.value = "*ALL";
parent.frames[1].document.forms[0].searchsp2.disabled=false;

}
}//if

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
	if(document.forms[0].speciality.value==getLabel("Common.all.label","Common"))
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
	if(document.forms[0].pctr.value==getLabel("Common.all.label","Common"))
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
		//CHL-CRF Start.[Nijitha]
		var patClass = document.Assign.patclass.value;
		var speciality = document.Assign.spl.value;
		var practitioner = document.Assign.practitioner.value;
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AssignChartSummIntermediate.jsp",false ) ;	
		xmlHttp.send( xmlDoc ) ;
		//parent.f_query_add_mod_display.location.href ="../../eCA/jsp/AssignChartSummPreview.jsp?summaryId="+document.Assign.summary.value+"&summaryDesc="+objSummary.options[objSummary.selectedIndex].text
		parent.f_query_add_mod_display.location.href ="../../eCA/jsp/AssignChartSummPreview.jsp?summaryId="+document.Assign.summary.value+"&summaryDesc="+objSummary.options[objSummary.selectedIndex].text+"&patClass="+patClass+"&speciality="+speciality+"&practitioner="+practitioner+"&called_from=CREATE";
		//CHL-CRF Ends.[Nijitha]
		
		}
		getValue();
}
function checkRec(obj)
{
   if(obj.value=="" || obj.value=="null")
	{
	    obj.value=getLabel("Common.all.label","Common");
		document.forms[0].practitioner.value="*ALL";
		document.forms[0].flag.value='true'
	}
	 if (obj.value!="" && obj.value!= getLabel("Common.all.label","Common") ){
	HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='AssignChartSummSearch.jsp'><input type=hidden name='pract' id='pract' value='"+obj.value+"' </form></body></html>"
	//top.frames[1].frames[1].frames[3].document.write(HTMLVal);
	//top.frames[1].frames[1].frames[3].document.tempForm.submit();
	parent.messageFrame.document.write(HTMLVal);
	parent.messageFrame.document.tempForm.submit();

	
	}
}

function showPctr(pctrObject)
{
	if(pctrObject.name=='pctr')
		{
			var target  = document.forms[0].pctr;
		
			if((target.value) == "null" || (target.value ==""))
			{
				 //pctrObject.value=getLabel("Common.all.label","Common");
				 //document.forms[0].spl.value="*ALL";
				 //document.forms[0].flagSpecialty.value='true'
				return false;			
			}
			else
			{
				showPctrWindow();
			}
		}
		else if(pctrObject.name=='searchsp2')
		{		
			showPctrWindow();
		}
		
}

async function showPctrWindow()
{
		var target	= document.forms[0].pctr;
		var practr=document.forms[0].pctr.value;	
		var sql="SELECT practitioner_id code,short_name description FROM am_practitioner where EFF_STATUS ='E'  and upper(practitioner_id) like upper(?) and upper(short_name) like upper(?) order by 2";
		//and practr_txt= '"+practr+"'
		var title=getLabel("Common.practitioner.label","common");
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
		if(target.value!= getLabel("Common.all.label","Common"))
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
				document.forms[0].pctr.value = arr[1];
				document.forms[0].practitioner.value = arr[0];
			}
			else
			{
				document.forms[0].pctr.value=getLabel("Common.all.label","Common");
				document.forms[0].practitioner.value = "*ALL";
				document.forms[0].searchsp2.disabled=false;
				//target.focus();
			}
		}
}





function checkSpl(obj)
{
	if(obj.value=="" || obj.value=="null")
	{
	    //obj.value=getLabel("Common.all.label","Common");
		document.forms[0].spl.value="*ALL";
		//document.forms[0].flagSpecialty.value='true'
	}
	if (obj.value!="" && obj.value!= getLabel("Common.all.label","Common") ){
	HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='splForm' id='splForm' method='post' action='AssignChartSummSearchCriteria.jsp'><input type=hidden name='speci' id='speci' value='"+obj.value+"' </form></body></html>"
	//top.frames[1].frames[1].frames[3].document.write(HTMLVal);
	//top.frames[1].frames[1].frames[3].document.splForm.submit();


	parent.messageFrame.document.write(HTMLVal);
	parent.messageFrame.document.splForm.submit();
   }
   else
	{
	   return false
	}
}

//Functions for the file name AssignChartSumm.jsp-end

