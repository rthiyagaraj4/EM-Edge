var autoFillSearchList = '';


/*function fnAutoFillLoadCriteria(obj,page){
	var frm = document.forms[0];
	if(obj.checked){
		var xmlStr ="<root><SEARCH ";				
		xmlStr +=" /></root>";
		var temp_jsp="../../eBL/jsp/AutoFillSearchCriteria.jsp?func_mode=LoadCriteria&func_id="+page;						
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);
		var searcfFieldsArr  = responseText.split(":::");
		for(var i=0;i<searcfFieldsArr.length;i++){
			//alert(searcfFieldsArr[i]);
			var searcfIndFieldsArr = searcfFieldsArr[i].split("=");
			if(searcfIndFieldsArr.length == 2){
				//alert(searcfIndFieldsArr[0]);
				if(document.getElementById(searcfIndFieldsArr[0]) != null){
					//alert(searcfIndFieldsArr[1])					
					document.getElementById(searcfIndFieldsArr[0]).value= searcfIndFieldsArr[1];
				}
			}				
		}
		
		if(page == 'EBL_TRANS_ENC_POLICY_DEF'){
			frm.patient_id.focus();
		}
	}
	
}*/

function fnAutoFillLoadCriteria(page){
	var frm = document.forms[0];
	
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var temp_jsp="../../eBL/jsp/AutoFillSearchCriteria.jsp?func_mode=LoadCriteria&func_id="+page;						
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
	var searcfFieldsArr  = responseText.split(":::");
	for(var i=0;i<searcfFieldsArr.length;i++){
		//alert(searcfFieldsArr[i]);
		var searcfIndFieldsArr = searcfFieldsArr[i].split("=");
		if(searcfIndFieldsArr.length == 2){
			//alert(searcfIndFieldsArr[0]);
			if(document.getElementById(searcfIndFieldsArr[0]) != null){
				//alert(searcfIndFieldsArr[1])					
				document.getElementById(searcfIndFieldsArr[0]).value= searcfIndFieldsArr[1];
			}
		}				
	}
		
	/*if(page == 'EBL_TRANS_ENC_POLICY_DEF'){
		frm.patient_id.focus();
	}*/
	
}

function fnAutoFillSaveCriteria(page){
//	alert(autoFillSearchList)
	assignSearchCriteria();
//	alert(autoFillSearchList)
	var frm = document.forms[0];
	//frm.autoFillSaveNewCriteria.disabled = true;
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var temp_jsp="../../eBL/jsp/AutoFillSearchCriteria.jsp?func_mode=SaveCriteria&func_id="+page+'&autoFillSearchList='+autoFillSearchList;						
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
	if(responseText == 'Criteria Saved Successfully'){
		//alert(responseText)
	}
}

function assignSearchCriteria(){
	autoFillSearchList='';
	var frmLen = document.forms.length;
	for(var i=0;i<frmLen;i++){
		autoFillSearchList = autoFillSearchList+formXMLStringMain(document.forms[i]);
		if(document.forms[i].autoFillSaveNewCriteria != null && document.forms[i].autoFillSaveNewCriteria != ""){
			document.forms[i].autoFillSaveNewCriteria.disabled = false;
		}
	}
	/*alert(autoFillSearchList);
	if(page == 'EBL_TRANS_ENC_POLICY_DEF'){
		var frm = document.forms[0];
		frm.autoFillSaveNewCriteria.disabled = false;
		autoFillSearchList = 	'patient_id='+frm.patient_id.value+':::'+
								'episode_type='+frm.episode_type.value+':::'+
								'hdnEpisode_id='+frm.hdnEpisode_id.value+':::'+
								'Effective_from='+frm.Effective_from.value+':::'+
								'episode_id='+frm.episode_id.value;
		
		//alert(autoFillSearchList)
	}*/
	
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function fnClearSearchCriteria(){

	/*if(page == 'EBL_TRANS_ENC_POLICY_DEF'){
		var frm = document.forms[0];
		frm.patient_id.value = '';
		frm.patient_name.value = '';
		frm.episode_type.value = '';
		frm.ageY.value = '';
		frm.ageM.value = '';
		frm.ageD.value = '';
		frm.hdnEpisode_id.value = '';
		frm.episode_id.value = '';	
		frm.gender.value = '';
		frm.Effective_from.value = '';	
		frm.autoFillSaveNewCriteria.disabled = true;
	}*/
	var frmLen = document.forms.length;
	for(var i=0;i<frmLen;i++){
		clearFormElements(document.forms[i]);
	}
}

function formXMLStringMain(frmObj)
{
	var xmlStr ="";
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var arrObj = frmObj.elements;
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].getAttribute("dflt_srch_value") == "Y"){
				if(arrObj[i].type == "checkbox")
				{
					if(arrObj[i].checked)
					{
						val = arrObj[i].value;
						if(arrObj[i].name != null && arrObj[i].name != "")
							xmlStr+= arrObj[i].name+"=Y" + ":::" ;
					}
					else{
						if(arrObj[i].name != null && arrObj[i].name != "")
							xmlStr+= arrObj[i].name+"=N" + ":::" ;
					}
		        }
			    else if(arrObj[i].type == "radio")
				{
					if(arrObj[i].checked)
					{
						val = arrObj[i].value;
				        if(arrObj[i].name != null && arrObj[i].name != "")
							xmlStr+= arrObj[i].name+"="+ checkSpl(val) + ":::" ;
		            }
			    }
				else if(arrObj[i].type == "select-multiple" )
				{
					for(var j=0; j<arrObj[i].options.length; j++)
				    {
						if(arrObj[i].options[j].selected)
							val+=arrObj[i].options[j].value +"~"
		            }
			        val= val.substring(0,val.lastIndexOf('~'))
				    if(arrObj[i].name != null && arrObj[i].name != "")
					    xmlStr+= arrObj[i].name+"=" + checkSpl(val) + ":::" ;
				}
			    else
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=" + checkSpl(val) + ":::" ;
		        }
			}
		}
	}
	return xmlStr;
}

function clearFormElements(frmObj)
{
	var xmlStr ="";
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var arrObj = frmObj.elements;
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].dflt_srch_value == "Y"){
				if(arrObj[i].type == "checkbox")
				{
					 if(arrObj[i].name != null && arrObj[i].name != ""){
						 if(arrObj[i].value == 'Y'){
							 arrObj[i].checked = true;
						 }
						 else{
							 arrObj[i].checked = false;
						 }
					 }				
		        }
			    /*else if(arrObj[i].type == "radio")
				{
					if(arrObj[i].checked)
					{
						val = arrObj[i].value;
				        if(arrObj[i].name != null && arrObj[i].name != "")
							xmlStr+= arrObj[i].name+"="+ checkSpl(val) + ":::" ;
		            }
			    }
				else if(arrObj[i].type == "select-multiple" )
				{
					for(var j=0; j<arrObj[i].options.length; j++)
				    {
						if(arrObj[i].options[j].selected)
							val+=arrObj[i].options[j].value +"~"
		            }
			        val= val.substring(0,val.lastIndexOf('~'))
				    if(arrObj[i].name != null && arrObj[i].name != "")
					    xmlStr+= arrObj[i].name+"=" + checkSpl(val) + ":::" ;
				}
			    else
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=" + checkSpl(val) + ":::" ;
		        }*/
				else if(arrObj[i].type == "text" || arrObj[i].type == "hidden" || arrObj[i].type == "select-one"){
					 if(arrObj[i].name != null && arrObj[i].name != "")
						 arrObj[i].value = ''; 
				}	
			}
					
		}
	}
	return xmlStr;
}
