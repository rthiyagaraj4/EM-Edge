	var linkContent = "";

	function create()
	{
		f_query_add_mod.location.href='../../eCA/jsp/SpecialtyEventAddModify.jsp?';
	}

	function reset(){
	f_query_add_mod.frames[0].document.forms[0].reset();
	}

	function query(){
		f_query_add_mod.location.href="../../eCA/jsp/SpecialtyEventQueryCriteria.jsp";
	}

	function apply(){
		   if (! (f_query_add_mod.document.specialityeventaddmodifyForm) )
         {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
        }
	var mode= f_query_add_mod.document.specialityeventaddmodifyForm.mode.value;
	var fields = new Array(f_query_add_mod.document.specialityeventaddmodifyForm.module,f_query_add_mod.document.specialityeventaddmodifyForm.code,f_query_add_mod.document.specialityeventaddmodifyForm.description,f_query_add_mod.document.specialityeventaddmodifyForm.agegroupDes,f_query_add_mod.document.specialityeventaddmodifyForm.orderSequence)
		
	var names = new Array(getLabel("Common.Module.label",'COMMON'),getLabel("Common.code.label",'COMMON'),getLabel("Common.description.label",'COMMON'),getLabel("Common.agegroup.label",'COMMON'),getLabel("eCA.OrderSequence.label",'CA'));
    if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
   {
		//var autoClsPeriodType=	f_query_add_mod.document.specialityeventaddmodifyForm.autoClosePeriodType.value;
		//var autoClsPeriod=	f_query_add_mod.document.specialityeventaddmodifyForm.autoClosePeriod.value;
		
	//if(checkValue(autoClsPeriodType,autoClsPeriod))	
	   //{		
			
	      if(mode != null)
	      {
			if(mode =="insert"  || mode =="modify" )
			{
				if(f_query_add_mod.document.specialityeventaddmodifyForm.enabled.checked == true)
				f_query_add_mod.document.specialityeventaddmodifyForm.enabled.value="E";
				else
				f_query_add_mod.document.specialityeventaddmodifyForm.enabled.value="D";

			}

		if(mode =="insert")
		{
		  	
			f_query_add_mod.document.specialityeventaddmodifyForm.submit();
			
		}
		if(mode=="modify")
		{
			   
			f_query_add_mod.document.specialityeventaddmodifyForm.mode.disabled=false;
			f_query_add_mod.document.specialityeventaddmodifyForm.code.disabled=false;
			f_query_add_mod.document.specialityeventaddmodifyForm.description.disabled=false;
			f_query_add_mod.document.specialityeventaddmodifyForm.agegroupDes.disabled=false;
			f_query_add_mod.document.specialityeventaddmodifyForm.orderSequence.disabled=false;
			f_query_add_mod.document.specialityeventaddmodifyForm.definitionType.disabled=false;
			//f_query_add_mod.document.specialityeventaddmodifyForm.autoCloseType.disabled=false;
			//alert(f_query_add_mod.document.specialityeventaddmodifyForm.enabled.value);
			f_query_add_mod.document.specialityeventaddmodifyForm.submit(); 
		}
		
	}
	   //}
	  // else
	   //{
	   	  //var error=getMessage("RECORD_CANNOT_DELETE",'CA');	
	//		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	   //}
   }
		
 }

function deleterecord()
  {
	  
	if(f_query_add_mod.document.specialityeventaddmodifyForm!=null && f_query_add_mod.document.specialityeventaddmodifyForm.mode!=null)
	{
		var mode = f_query_add_mod.document.specialityeventaddmodifyForm.mode.value;

		if(mode != "insert"){
			var chkJsp = f_query_add_mod.location.href;
			var mode1="delete";
			var msg=getMessage("DELETE_RECORD",'common');
			if(confirm(msg) == true)
			{				
				f_query_add_mod.document.specialityeventaddmodifyForm.code.disabled=false;
				f_query_add_mod.document.specialityeventaddmodifyForm.mode.value=mode1;
				f_query_add_mod.document.specialityeventaddmodifyForm.submit();
			}
			else
			{
				commontoolbarFrame.location.reload();
			}
		}
		else
		{
		
			var error=getMessage("RECORD_CANNOT_DELETE",'CA');	
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error
		}
	  }
	else
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
   }
	
	function reset()
   {
		if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.forms[0].reset();
   }
	

	function callFunctionButton(sql,title,target)
	{
		var serviceVal   ="";
		var search_desc	= "";
		target.value='';
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
		retArray = CommonLookup( title, argArray );
		return retArray;
	}
	function getageGroup()
	{
		var sql="Select AGE_GROUP_CODE code, SHORT_DESC description from  AM_AGE_GROUP where	 EFF_STATUS = 'E'  and upper(AGE_GROUP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 2 ";
		 retArray = callFunctionButton(sql,getLabel("Common.agegroup.label","Common"),document.specialityeventaddmodifyForm.agegroupDes)
		if(retArray != null && retArray !="")	
				{
						document.specialityeventaddmodifyForm.agegroupDes.value = retArray[1];
						document.specialityeventaddmodifyForm.agegroupCode.value = retArray[0];
						
				}
				else
				{
					document.specialityeventaddmodifyForm.agegroupDes.value = "";
					document.specialityeventaddmodifyForm.agegroupCode.value ="";
					
				}
	}
	function onSuccess()
  {
	 	// alert(f_query_add_mod.document.forms[0].mode.value);
		if(f_query_add_mod.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href='../../eCA/jsp/SpecialtyEventAddModify.jsp?mode=insert';
		else if(f_query_add_mod.document.forms[0].mode.value=="modify")
	   { 
			//alert("reload");
			f_query_add_mod.location.reload();
			//f_query_add_mod.location.href='../../eCA/jsp/SpecialtyEventAddModify.jsp?mode=modify';
	   }
		else
	  {//alert("reload");
			f_query_add_mod.location.href='../../eCA/jsp/SpecialtyEventAddModify.jsp?mode=insert';
	  }
  }
	
	function numOnly()
	  {
		 if(((event.keyCode>=48)&&(event.keyCode<=57)))
		 {
			event.keyCode=event.keyCode;
		 }
		 
		 else
		 {
		   event.keyCode=0;
		  
		 }
	  }
 function checkPositiveNumber(obj) {  
    var obj_value = obj.value;    // checks for positive number greater than zero
   var obj_length = obj_value.length;
	if(obj.value == ""){
		return true;
	}
	if(obj != null ){

		if(obj_value > 0){
			return true;
		}else{
			alert(getMessage("POSITIVE_NUMBER_ALLOWED",'CA'));
			obj.value= ""
			obj.focus();
			return false;
		}
	}else{
		return true;
	}
}

	function checkValue(autoClsPeriodType,autoClsPeriod)
	{
		 if(autoClsPeriodType == "" &&  autoClsPeriod == "")
		{
			 return true;
		}


	  	  if((autoClsPeriodType != "" &&  autoClsPeriod == "") ||  (autoClsPeriodType == "" &&  autoClsPeriod != ""))
		{
	   		  var msg = getMessage("AUTO_CLOSE_PERIOD_NOT_BLANK","CA");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
	   
	   if(autoClsPeriodType != "" &&  autoClsPeriod != "")
		{
			if(autoClsPeriodType == "D")
			{
				if(autoClsPeriod > 31)
				{
				var msg = getMessage("DAYS_SHOULD_NOT_EXCEED","CA");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				return false;
				}
				else
				 return true;
			}

			 else  if(autoClsPeriodType == "W")
				{
				if(autoClsPeriod > 52)
				{
				var msg = getMessage("WEEKS_SHOULD_NOT_EXCEED","CA");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				return false;
				}
				else
				 return true;
			  }
			else if(autoClsPeriodType == "M")	
			 {
				if(autoClsPeriod >12)
				{
				var msg = getMessage("MONTHS_SHOULD_NOT_EXCEED","CA");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				return false;
				}
				else
				return true;
			}
			else
			return true;
		}

	}
	 function getageGroup1(target,code)	 
   {
//	   alert("--"+code.value+"--");
	//   alert("--"+target.value+"--");
	var retVal			=  new String();
	var title			= getLabel("Common.agegroup.label","Common");
	//alert("target===="+target.value	 );
	var sql="Select AGE_GROUP_CODE code, SHORT_DESC description from  AM_AGE_GROUP where	 EFF_STATUS = 'E'  and upper(AGE_GROUP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 2 ";
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
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		code.value = retArray[0];
		document.specialityeventaddmodifyForm.agegroupCode.value=retArray[0];
		
		target.value= retArray[1];
	}
	else
	{
		code.value ="";
		target.value= "";
	}
	
}
