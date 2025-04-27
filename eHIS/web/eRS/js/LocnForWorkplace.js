/*********************************************************/
var flag="0";
function apply()
{
		if (! checkIsValidForProceed() ) {

		message  = " "
		
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	if (!checkIsValidForProceed1()){
		message  = getMessage("NOT_VALID","Common");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
	    // message  = getMessage("WORKPLACE_NOT_BLANK","RS");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		//alert(f_query_add_mod.f_query_header.document.form_add_mod.name);
	var frmobj=f_query_add_mod.f_query_header.document.form_add_mod;

	var fields = new Array (frmobj.workplace_desc,frmobj.location_code);
	var names = new Array (getLabel("eRS.WorkPlace.label","RS"),getLabel("Common.locationtype.label","Common"));
	if(f_query_add_mod.f_query_header.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		
		
   	 return false ;
    }
	
	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eRS.LocnForWorkplaceServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
}
/*********************************************************/
function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	{	
			return true;
	}
	else
	{	
		
		return false;
	}
}
/*********************************************************/
function checkIsValidForProceed1()
		
{
	var url = f_query_add_mod.f_query_header.location.href;
	
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
			{
				
				return true;
			}
		else
		{
			
			return false;
		}
}
/*********************************************************/
function checkIsValidForProceed2()
{		
	var url = f_query_add_mod.f_query_detail.location.href;
	
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
		{
				return true;
			
		}
		else
		{
			return false;
		}
}
/*********************************************************/
function create()
{
	f_query_add_mod.location.href="../../eRS/jsp/LocnForWorkplaceFrameSet.jsp";
}


/*********************************************************/
function query(){

	frames[1].location.href='../../eRS/jsp/LocnForWorkplaceQueryCriteria.jsp';
}

/*********************************************************/
function searchDetails()
  {
	//(parent.name)		
	
		parent.frames[2].location.href='../../eRS/jsp/LocnForWorkplaceDynamicValues.jsp';
		
	  var frmobj=parent.f_query_header.document.form_add_mod ;
	 // alert("frmobj---->" +frmobj.name);
	  var fields = new Array (frmobj.workplace_code,frmobj.location_code);	
	 
	  var names = new Array (getLabel("eRS.Workplace.label","RS"),getLabel("Common.locationtype.label","Common"));	
	  var	msgFrame=parent.parent.messageFrame;
	  //alert("msgFrame---->" +msgFrame.name);
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
				
		  //parent.frames[1].location.href='../../eCP/jsp/LocnForWorkplaceNoteDetail.jsp?workplace_code='+frmobj.assess_note_id.value+'&fromSearch=true';
		  parent.frames[1].location.href='../../eRS/jsp/LocnForWorkplaceNoteDetail.jsp?facility_id='+frmobj.facility_id.value+'&workplace_code='+frmobj.workplace_code.value+'&locn_code='+frmobj.location_code.value+'&fromSearch=true';
			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
		  

			

		}
		


  }

/*********************************************************/
function viewworkplace(target)
{ 

	var frmobj=parent.f_query_header.document.form_add_mod ;
	
	frmobj.workplace_desc.value="";
	var facility_id=frmobj.facility_id.value
		
				
	var locale=frmobj.locale.value
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

 	//argumentArray[0] ="Select workplace_code code, workplace_desc description from rs_workplace where facility_id ='"+facility_id+"' AND UPPER(workplace_code) LIKE UPPER(?) AND UPPER(workplace_desc) LIKE UPPER(?) ORDER BY workplace_desc";
 	argumentArray[0] ="SELECT workplace_code code, workplace_desc description FROM rs_workplace_lang_vw WHERE facility_id ='"+facility_id+"' AND UPPER(workplace_code) LIKE UPPER(?) AND UPPER(workplace_desc) LIKE UPPER(?) and language_id ='"+locale+"' ORDER BY workplace_desc";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = CommonLookup(getLabel("eRS.WorkPlace.label","RS"),argumentArray);
	//	alert("retVal  ="+retVal);
		if(retVal != null && retVal != "") {
			flag="1";
			target.value = retVal[1] ;
			document.forms[0].workplace_code.value = retVal[0];
			
		}else
		{   
			
			if(target.value=="" || target.value==null)
			{	
				 flag="0";
				
			}
		}
		
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
}

/*********************************************************/
function clearList(){
	var location_len=parent.frames[2].frames[1].f_query_header.document.form_add_mod.location_code.options.length;
	for(var i=0;i<location_len;i++) {
	parent.frames[2].frames[1].f_query_header.form_add_mod.location_code.remove("location_code") ;
	}
}

function addOption(code,desc){
	var tp = "  ---Select---  " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	parent.frames[2].frames[1].f_query_header.form_add_mod.location_code.add(opt);

}


function reset()
{	//alert("entering into reset:")
	var url=f_query_add_mod.location.href;
	//alert("url:----->"+url);
	if(url.indexOf("blank")==-1) {
		
		if(url.indexOf("Query")==-1){
					
				parent.frames[2].frames[1].f_query_header.document.forms[0].reset();
				parent.frames[2].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
				parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
					clearList();
					addOption();
		}else
		{
			
			//parent.frames[1].frames[1].document.forms[0].reset();
			f_query_add_mod.document.forms[0].reset();
		}
	}
}
/*********************************************************/
function onSuccess() 
{
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
}

function populateworkplace(form)
	  {		
			
	
			var workplace_code=document.forms[0].workplace_code.value;
			var facility_id=document.forms[0].facility_id.value;
			//var location_code=document.forms[0].location_code;
			removeitems(form.location_code);
			if(flag=="1")
			{
			
			var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE'>";
				HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eRS/jsp/LocnForWorkplaceFetchWorkplaceDetails.jsp'>";
				HTMLVal = HTMLVal +"<input name='workplace_code' id='workplace_code' type='hidden' value= '"+workplace_code+"'><input name='flag' id='flag' type='hidden' value= '"+flag+"'> <input name='facility_id' id='facility_id' type='hidden' value= '"+facility_id+"'>";
				//HTMLVal = HTMLVal +"<input name='workplace_code' id='workplace_code' type='hidden' value= '"+workplace_code+"'><input name='flag' id='flag' type='hidden' value= '"+flag+"'> <input name='facility_id' id='facility_id' type='hidden' value= '"+facility_id+"'> <input name='location_code' id='location_code' type='hidden' value= '"+location_code+"'>";
				HTMLVal = HTMLVal +"</form></BODY></HTML>";
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.form1.submit();
				//parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
					
			}
			//parent.parent.frames[2].document.forms[0].elements(0).focus();
			//changeTerminology();
					
}				
		
			
	  

		function removeitems(obj)
			{	
			
				var len=obj.length;
			
				
				var i=1;
				
				while(i<len)
				{
					len=obj.length
					
					
					
				}
				
					
			}  

			
function changeTerminology(){
	parent.frames[1].location.href='../../eCommon/html/blank.html';
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
}




    



 

