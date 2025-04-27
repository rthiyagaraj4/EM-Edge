function create()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/AlertEventAddModify.jsp?mode=insert';
}

function query()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/AlertEventQuery.jsp';
}


function apply()
 {
	 if(f_query_add_mod.document.alertevent_form)
  {
	if(f_query_add_mod.document.alertevent_form.byselect[0].checked == true)
		f_query_add_mod.document.alertevent_form.byselect.value = "O";
	else
		f_query_add_mod.document.alertevent_form.byselect.value = "C";

	var mode = f_query_add_mod.document.alertevent_form.mode
	var eff_status =  f_query_add_mod.document.alertevent_form.enabled;
	if(eff_status.checked == true)
		f_query_add_mod.document.alertevent_form.eff_status.value = "E";
	else
		f_query_add_mod.document.alertevent_form.eff_status.value = "D";

	//alert("mode="+mode);
	var fields = new Array (f_query_add_mod.document.alertevent_form.event_id,
							f_query_add_mod.document.alertevent_form.event_desc,
							f_query_add_mod.document.alertevent_form.txtCategoryCode
													
							);

	var names = new Array ( getLabel("eCA.AlertEventCode.label","CA"),
							getLabel("eCA.AlertEventDescription.label","CA"),
							getLabel("eCA.AlertCategoryCode.label","CA")
														
							);

	var tttt =  f_query_add_mod.document.alertevent_form.event_id.value;
	if(f_query_add_mod.document.alertevent_form != null)
	 {
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{			
			if(mode != null)
			{
				if(mode.value=='update')
				{
					f_query_add_mod.document.alertevent_form.event_id.value= f_query_add_mod.document.alertevent_form.event_id.value
					f_query_add_mod.document.alertevent_form.event_desc.value= f_query_add_mod.document.alertevent_form.event_desc.value
					f_query_add_mod.document.alertevent_form.txtCategoryCode.value= f_query_add_mod.document.alertevent_form.txtCategoryCode.value					
				}
			}
			f_query_add_mod.document.alertevent_form.event_id.disabled=false;
			//document.alertevent_form.event_desc.disabled=false;
			f_query_add_mod.document.alertevent_form.txtCategoryCode.disabled=false;
			f_query_add_mod.document.alertevent_form.submit();
		}
	 }
  }
  else
   {
		message  = getMessage("NOT_VALID","CA");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;

  }
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/AlertEventAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{   
		f_query_add_mod.location.href='../../eCA/jsp/AlertEventAddModify.jsp?mode=update&event_id='+f_query_add_mod.document.forms[0].event_id.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function reset()
{
	if(f_query_add_mod.document.forms[0]!=null)
	f_query_add_mod.document.forms[0].reset();

}

 function getCode(obj)
  {

	  if (obj.value!="")
	  { 
			populateCategoryLookup();
	  }
	  else
	  {
		  document.alertevent_form.txtCategoryCode.value = "";
		  document.alertevent_form.CategoryCode.value  = "";		 
		  
	  }
  }
  function CheckForSpeChar(event)
{
   var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}

  function populateCategoryLookup()
{
	    var target=document.alertevent_form.txtCategoryCode;
		//alert("target"+target.value);
		var retVal=  new String();
		var dialogTop	= "40";
		var dialogHeight= "10" ;
		var dialogWidth= "40" ;
		var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc	= "";
		var title = getLabel("eCA.AlertCategoryCode.label","CA");

		var sql="select DISTINCT ALERT_CATEG_CODE code, ALERT_CATEG_DESC description from CA_ALERT_CATEG where upper(ALERT_CATEG_CODE) like upper(?) and upper(ALERT_CATEG_DESC) like upper(?)";

	
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
				
				
				retArray = CommonLookup(title,argArray);
				//alert("retArray"+retArray);
				
				if(retArray != null && retArray !="")
				{
					document.alertevent_form.CategoryCode.value = retArray[0];
					document.alertevent_form.txtCategoryCode.value = retArray[1];
				}
				else
				{
					document.alertevent_form.txtCategoryCode.value = "";
		            document.alertevent_form.CategoryCode.value  = "";
				}
				document.alertevent_form.buttonCategory.disabled=false;
} 

function hideShowRowPeriod(obj)
{		   
	var selectedValue=document.getElementById("byselect")[1].checked;	
	if(selectedValue==true){			
		document.getElementById("in_every").style.display='inline';
		document.getElementById("with_in").style.display='none';
	}
	else{
		document.getElementById("in_every").style.display='none';
		document.getElementById("with_in").style.display='inline';
	}
}

function IsNumeric(strString)  
{	
	var strValidChars = "0123456789";
	var strChar;
	var blnResult = true;	
	 if (strString.length == 0) return false;  
	for (i = 0; i < strString.length && blnResult == true; i++)
	 {
		strChar = strString.charAt(i);
		if (strValidChars.indexOf(strChar) == -1)
		 {
			  blnResult = false;
		 }
	}
	 return blnResult;
}

function chkNumeric(){
	if (IsNumeric(document.getElementById("action_within").value) == false) 
      {
      alert("Please check - non numeric value!");
      }	  
}

function CheckForNums(event){
    var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;	
}
