//This file is saved on 18/10/2005


var message="";
/****************************************************************************************/
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/StaffRequirementFrameSet.jsp";
}
/****************************************************************************************/

 function viewAgeGroup1(target,facility_id)
{
	var frmobj=parent.f_query_header.document.form_add_mod 
	
	frmobj.workplace_desc.value="";
	var m=facility_id.value;
	 var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	

 	argumentArray[0] ="Select  workplace_code code,workplace_desc description from rs_workplace where facility_id='"+m+"' and eff_status='E'  AND UPPER(workplace_code) LIKE UPPER(?) AND UPPER(workplace_desc) LIKE UPPER(?) ORDER BY workplace_desc";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = CommonLookup(getLabel("Common.Workplace.label","Common"), argumentArray );
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			document.forms[0].workplace_code.value = retVal[0];
		
			
		}else
			target.value ="";
		

}
/****************************************************************************************/

function searchDetails()
  {
			
		
	   parent.frames[2].location.href='../../eCP/jsp/StaffRequirementDynamicValues.jsp';
	  var frmobj=parent.f_query_header.document.form_add_mod ;
	  var fields = new Array (frmobj.dependency_code,frmobj.workplace_code,frmobj.shift_code);	
	  var names = new Array (getLabel("Common.Dependency.label","Common"),getLabel("Common.Workplace.label","Common"),getLabel("Common.SHIFT.label","Common"));	
	  var	msgFrame=parent.parent.messageFrame;
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
		 
		  parent.frames[1].location.href='../../eCP/jsp/StaffRequirementDetail.jsp?facility_id='+frmobj.facility_id.value+'&workplace_code='+frmobj.workplace_code.value+'&dependency_code='+frmobj.dependency_code.value+'&shift_code='+frmobj.shift_code.value+'&fromSearch=true';
		
		    parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';

			

		}
  }
  /****************************************************************************************/
	function ChangeType(form,target)
	  {
		
			var shift_code1=target.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//to get the period for selected requirement
			xmlHttp.open( "POST","../../eCP/jsp/StaffRequirementLabelIntermediate.jsp?shift_code1="+shift_code1+"&flag=true", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			
			eval(responseText);
				}

/****************************************************************************************/
	function assignDateRange(start_time1,end_time1)
	{
		var frmobj=parent.f_query_header.document.form_add_mod ;
		var  start_time1=start_time1;
		var end_time1=end_time1;
		frmobj.start_time1.value=start_time1;
		frmobj.end_time1.value=end_time1;
	}
/****************************************************************************************/
	function display(obj1,obj2)
	{
	var frmobj=parent.f_query_header.document.form_add_mod ;
	
	var start_time1=frmobj.start_time1.value;
	var end_time1=frmobj.end_time1.value;

	obj1.innerText="   "+start_time1;
	obj2.innerText="   "+ end_time1;
	
	

}

/****************************************************************************************/
function allowPositiveNumber() {
   var key = window.event.keyCode;// allows only numbers to be entered
   if((key<48 )||(key>58)) {
	   return false;
   }
}

/****************************************************************************************/
function CheckMin(target)
{
	var value = target.value;
	
	if(value == "0" || value == "00" || value=="000")
	{
		message=getMessage("VALUE_GT_ZERO","CP");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		target.focus();
		target.select();
	 return false;
	}
	else
		return true;
}
/****************************************************************************************/
function check24(target)
{
	var value = target.value;
	
	
	if(value >24 )
	{
	
		message=getMessage("CODE24_GREATER","CP");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		target.focus();
		target.select();
	 return false;
	}
	else
		return true;
}


/****************************************************************************************/
function apply()
{
	if (! checkIsValidForProceed() ) {
	     message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	 var frmObj=f_query_add_mod.frames[1].document.forms[0];
	var frmName=frmObj.name;
	var cnt;
	var flag='Y';
	var a=frmObj.maxRecord.value;
	 for(cnt=1;cnt<= a; cnt++){
		 
		 var w=eval("frmObj.wday_hours"+cnt).value;
		  
		 var nw=eval("frmObj.nwday_hours"+cnt).value;
		 
		 var hw=eval("frmObj.hday_hours"+cnt).value;
		 
		  if(eval("frmObj.chk"+cnt).checked==true)
		 {
			  if( w=='')
			 {
				var  message=getMessage("WDAY_NOT_BLANK","CP"); 
				 
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				eval("frmObj.wday_hours"+cnt).focus();
				eval("frmObj.wday_hours"+cnt).select();
				
				   return false;
			 }
			 if( nw=='')
			 {
				
				 var  message=getMessage("NWDAY_NOT_BLANK","CP"); 
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				eval("frmObj.nwday_hours"+cnt).focus();
				eval("frmObj.nwday_hours"+cnt).select();
				  return false;
				  
			 }
			  if(hw=='')
			 {
			
			 var  message=getMessage("HDAY_NOT_BLANK","CP"); 
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			eval("frmObj.hday_hours"+cnt).focus();
				eval("frmObj.hday_hours"+cnt).select();
				
				 return false;
			 }
		 }
	 }
		
		
	parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[1].frames[1].frames[2].document.forms[0].E.value;
				
	parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.StaffRequirementServlet";
	parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[1].frames[1].frames[1].document.forms[0].submit();
	
}
/****************************************************************************************/
function query(){

	frames[1].location.href='../../eCP/jsp/StaffRequirementQueryCriteria.jsp';
}
/****************************************************************************************/
function onSuccess() 
{
	parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[1].frames[1].frames[0].location.reload();
}
/****************************************************************************************/

function reset()
{
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
				parent.frames[1].frames[1].f_query_header.document.forms[0].reset();
				parent.frames[1].frames[1].f_query_header.document.forms[0].elements(0).focus();
				parent.frames[1].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
				parent.frames[1].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[1].frames[1].document.forms[0].reset();
	}
}
/****************************************************************************************/
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/****************************************************************************************/
function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
/****************************************************************************************/
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}

