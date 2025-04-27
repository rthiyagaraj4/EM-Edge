function selarea(obj)
   {
	var areaval = obj.value;
		HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form1' id='dum_form1' method='post' action='../../eMO/jsp/MOPopAreaAvail.jsp'><input type='hidden' name='areaval' id='areaval' value='"+areaval+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form1.submit();
    }

	function focusField()
	{
	document.AreaAvailForm.Area_Type.focus();
	}
	
	function submitPage()
	{
	document.forms[0].search.disabled=true;
	var atype = document.forms[0].Area_Type.value;
	var area = document.forms[0].area_code.value;
	parent.result.location.href= "../jsp/MOAreaAvailabilityQueryResult.jsp?atype="+atype+"&area="+area;
	}	
	
	function clearAll()
	{
		parent.frames[1].document.location.href ='../../eMO/jsp/MOAreaAvailabilityQueryCriteria.jsp'; 
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html'; 
	}

 function showAllowedOperations(obj,obj1)
  {
	var retVal              = "";
	var retVal1             ="";
	var sucfai              = ""; 
	retVal                  = obj;
	retVal1                 = obj1;
	var dialogTop			= "160";
	var dialogHeight		= "20" ;
	var dialogWidth			= "40" ;
	var status				= "no";
	var arguments			= "" ;
	var action_url			= "../../eMO/jsp/MOAreaAvailPopulate.jsp?acode="+retVal+"&AREA_DESC="+retVal1;
	var features			= "dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:yes; dialogTop:"+dialogTop+";";
	
	sucfai	=	window.showModalDialog(action_url,arguments,features);
		if(sucfai!=null)
		{
			if(sucfai=="Success")
			{
				parent.MOAreaAvailabilityQueryResult_form.location.reload();
			}
		}
}

function cancelOperation()
	{
		parent.window.returnValue = "";
		parent.window.close();
	}

