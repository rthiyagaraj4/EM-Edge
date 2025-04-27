function clickOK()
{
	//var valOfBtn = parent.buttonsFrame.document.refDetToolsForm.valOfBtn.value;
	var valOfBtn;
	if(parent.radBtnsFrame.document.refDetRadBtnsForm.encBtn[0].checked == true)
		valOfBtn = 'C';
	else if(parent.radBtnsFrame.document.refDetRadBtnsForm.encBtn[1].checked == true)
		valOfBtn = 'N';
	var finalValueArray = new Array();

	if(valOfBtn == "N")
	{
		var refType = "";
		var finalVal = "";

		var selIndex1 = parent.detailsFrame.document.refDetailsForm.referralType.selectedIndex;
		if(parent.detailsFrame.document.refDetailsForm.referralType.value != '')
		{
			refType = parent.detailsFrame.document.refDetailsForm.referralType.options(selIndex1).text;
			finalVal += refType;
		}
		else
			refType = "";

		var HCSType = "";
		var selIndex2 = parent.detailsFrame.document.refDetailsForm.healthCareSettingType.selectedIndex;
		if(parent.detailsFrame.document.refDetailsForm.healthCareSettingType.value != '')
		{
			HCSType = parent.detailsFrame.document.refDetailsForm.healthCareSettingType.options(selIndex2).text;
			if(finalVal != '')
				finalVal += " , "+HCSType;
			else
				finalVal += HCSType;
		}
		else
			HCSType = "";

		var refSource = "";
		var selIndex3 = parent.detailsFrame.document.refDetailsForm.referralSource.selectedIndex;
		if(parent.detailsFrame.document.refDetailsForm.referralSource.value != '')
		{
			refSource = parent.detailsFrame.document.refDetailsForm.referralSource.options(selIndex3).text;
			if(finalVal != '')
				finalVal += " , "+refSource;
			else
				finalVal += refSource;
		}
		else
			refSource = "";

		var specialty = "";
		var selIndex4 = parent.detailsFrame.document.refDetailsForm.specialty.selectedIndex;
		if(parent.detailsFrame.document.refDetailsForm.specialty.value != '')
		{
			specialty = parent.detailsFrame.document.refDetailsForm.specialty.options(selIndex4).text;
			if(finalVal != '')
				finalVal += " , "+specialty;
			else
				finalVal += specialty;
		}
		else
			specialty = "";
		
		if(parent.detailsFrame.document.refDetailsForm.referralType.value == 'X')
		{
			locn = parent.detailsFrame.document.refDetailsForm.locnText.value;
		}
		else
		{
			var locationVal = "";
			var selIndex5 = parent.detailsFrame.document.refDetailsForm.locationVal.selectedIndex;
			if(parent.detailsFrame.document.refDetailsForm.locationVal.value != '')
				locationVal = parent.detailsFrame.document.refDetailsForm.locationVal.options(selIndex5).text;
			else
				locationVal = "";

			var locationValues2 = "";
			var selIndex6 = parent.detailsFrame.document.refDetailsForm.locationValues2.selectedIndex;
			if(parent.detailsFrame.document.refDetailsForm.locationValues2.value != '')
				locationValues2 = parent.detailsFrame.document.refDetailsForm.locationValues2.options(selIndex6).text;
			else
				locationValues2 = "";

			var locn = "";
			if(parent.detailsFrame.document.refDetailsForm.locationValues2.options(selIndex6).value != "")
				locn = locationValues2+"/"+locationVal;
			else
				locn = locationVal;
		}

		if(locn != '')
		{
			if(finalVal != '')
				finalVal += " , "+locn;
			else
				finalVal += locn;
		}
		
		//var finalVal = refType + ", " +  HCSType + ", " + refSource + ", " + specialty + ", " + locn+ ";";		

	}
	else
	{
		var i = 0;
		var count = parent.detailsFrame.document.refDetailsForm.count.value;
		var chkVals = "";
		var tdVals = "";
		var finalVal = "";		
		for(i=0;i<parseInt(count,10);i++)
		{
			chkVals = eval("parent.detailsFrame.document.refDetailsForm.chk"+i);
			if(chkVals.checked)
			{
				for(var j=1;j<=5;j++)
				{
					tdVals = eval("parent.detailsFrame.document.getElementById("tdID")"+j+i);
					finalVal += tdVals.innerText;
					if(j != 5)
						finalVal += ", ";
				}
				finalVal += " ;";
			}
		}		
	}
	finalValueArray[0] = "";
	finalValueArray[1] = finalVal;		
	window.returnValue = finalValueArray;	
	window.close();
}

function closeWindow()
{
	var finalValueArray = new Array();
	finalValueArray[0] = "";
	finalValueArray[1] = "";
	window.returnValue = finalValueArray;
	window.close();
}

function loadDetailPage(object)
{
	var encounter_id = parent.radBtnsFrame.document.refDetRadBtnsForm.encounter_id.value;
	var facility_id = parent.radBtnsFrame.document.refDetRadBtnsForm.facility_id.value;

	if(object.value == 'C')
		parent.detailsFrame.location.href = "../../eCA/jsp/STDCompReferralDetails.jsp?facility_id="+facility_id+"&encounter_id="+encounter_id;
	else
		parent.detailsFrame.location.href = '../../eCA/jsp/STDCompReferralDetails.jsp?radBtnVal='+object.value+"facility_id="+facility_id+"&encounter_id="+encounter_id;
}

function changeRefSource(object)
{
	var len = parent.detailsFrame.document.refDetailsForm.referralSource.options.length;
	
	for(var i = 0;i<len;i++){
		parent.detailsFrame.document.refDetailsForm.referralSource.remove("referralSource");
	}
	var opt = parent.detailsFrame.document.createElement('OPTION');
	var labelSelect = getLabel("Common.defaultSelect.label","COMMON");
	opt.text = '---------'+labelSelect+'---------';
		//opt.text = '---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------';
		opt.value ='';
		parent.detailsFrame.document.refDetailsForm.referralSource.add(opt);

	if(object.value =="L" || object.value == "E")
	{
		parent.detailsFrame.document.refDetailsForm.locnText.style.display='none'
		parent.detailsFrame.document.refDetailsForm.locationVal.style.display='inline'
		parent.detailsFrame.document.refDetailsForm.locationValues2.style.display='inline'
	}
	clear_Locn(object);

	var fac_id = parent.detailsFrame.document.refDetailsForm.facility_id.value;
	//parent.intermediateFrame.document.write("<html><form name='tempForm' id='tempForm' action='../../eCA/jsp/STDCompReferralDetailsIntermediate.jsp'><input type='hidden' name='listVal' id='listVal' value='"+object.value+"'><input type='hidden' name='facility_id' id='facility_id' value='"+fac_id+"'><input type='hidden' name='called_from' id='called_from' value='refSource'></form></html>");
	//parent.intermediateFrame.document.tempForm.submit();

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "listVal=\""+ object.value +"\"" ;
	xmlStr += " specialty=\"\"";
	xmlStr += " location_type=\"\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/STDCompReferralDetailsIntermediate.jsp?called_from=refSource", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
}

function populateLocnVals(object)
{
	//alert(object.value);
	var fac_id = parent.detailsFrame.document.refDetailsForm.facility_id.value;
	var specialty = parent.detailsFrame.document.refDetailsForm.specialty.value;
	var referralType = parent.detailsFrame.document.refDetailsForm.referralType.value;
	
	 if(specialty == ""){
		alert(getMessage("SPECIALITY_NOT_BLANK","CA"));
		parent.detailsFrame.document.refDetailsForm.locationVal.options(0).selected= true;	
		return false
	}
	else{
	
	//parent.intermediateFrame.document.write("<html><form name='tempForm' id='tempForm' action='../../eCA/jsp/STDCompReferralDetailsIntermediate.jsp'><input type='hidden' name='listVal' id='listVal' value='"+referralType+"'><input type='hidden' name='facility_id' id='facility_id' value='"+fac_id+"'><input type='hidden' name='called_from' id='called_from' value='popuLocn'><input type='hidden' name='specialty' id='specialty' value='"+specialty+"'><input type='hidden' name='location_type' id='location_type' value='"+object.value+"'></form></html>");
	//parent.intermediateFrame.document.tempForm.submit();

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "listVal=\""+ referralType +"\"" ;
	xmlStr += " specialty=\""+specialty+"\"";
	xmlStr += " location_type=\""+object.value+"\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/STDCompReferralDetailsIntermediate.jsp?called_from=popuLocn", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);

	}
}

function clear_Locn(obj)
{
	if(obj!=null)
	{
		if(obj.name == "specialty")
		parent.detailsFrame.document.refDetailsForm.locationVal.options(0).selected= true;	
		else if(obj.name == "referralType")
		{
			var len1 = parent.detailsFrame.document.refDetailsForm.locationVal.options.length;
	
			for(var j = 0;j<len1;j++){
				parent.detailsFrame.document.refDetailsForm.locationVal.remove("locationVal");
			}
				var opt1 = parent.detailsFrame.document.createElement('OPTION');
				var labelSelect = getLabel("Common.defaultSelect.label","COMMON");
				opt1.text = '---------'+labelSelect+'---------';
				//opt1.text = '---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------';
				opt1.value ='';
				parent.detailsFrame.document.refDetailsForm.locationVal.add(opt1);
		}
	}

	var len = parent.detailsFrame.document.refDetailsForm.locationValues2.options.length;

	for(var i = 0;i<len;i++){
		parent.detailsFrame.document.refDetailsForm.locationValues2.remove("locationValues2");
}
		var opt = parent.detailsFrame.document.createElement('OPTION');
		var labelSelect = getLabel("Common.defaultSelect.label","COMMON");
		opt.text = '---------'+labelSelect+'---------';
		//opt.text = '---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------';
		opt.value ='';
		parent.detailsFrame.document.refDetailsForm.locationValues2.add(opt);

}

function change_frame()
{
	window.dialogHeight = "15";
	window.dialogWidth = "40";
	window.dialogTop = "150";
	window.dialogLeft = "70";
	

}

