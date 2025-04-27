function retValue(code,desc)
{	
/*	for(var i=0;i<desc.length;i++)
	{
		if(desc.indexOf("+") != -1)
		{
			desc = desc.replace("+"," ");
		}
		if(desc.indexOf("%60%60%60*%24%24%24") != -1)
		{
			desc = desc.replace("%60%60%60*%24%24%24","+");
		}
	}*/
	var retVal  = new Array();	
	retVal[0] = code;
	retVal[1] = desc;
	window.returnValue = retVal;
	window.close();
}

function valtext(code)
{
	var patient_id = document.CriteriaForm.patient_id.value;
	var encounter_id = document.CriteriaForm.encounter_id.value;
	var speciality_code = document.CriteriaForm.speciality_code.value;
	var facility_id = document.CriteriaForm.facility_id.value;

	var search_text = document.CriteriaForm.search_text.value;
	var search_criteria = document.CriteriaForm.search_criteria.value;
	var radBtnVal = document.CriteriaForm.radBtnVal.value;
	parent.lookup_detail.document.location.href = "../../eCA/jsp/CommonLookUpResult.jsp?std_comp_id="+code+"&search_text="+encodeURIComponent(search_text,"UTF-8")+"&search_criteria="+search_criteria+"&radBtnVal="+radBtnVal+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&speciality_code="+speciality_code+"&facility_id="+facility_id;
}
function encodeToISOLatinCharSet(inputString)
{
	var tempString = inputString;
	var validSpecialChars = "'%+-*\" ";
	var replacementForValidSpecialChars = "&#39;|&#37;|&#43;|&#45;|&#42;|&#34|&#160;";
	replacementArray = replacementForValidSpecialChars.split("|");
	for(i=0;i<validSpecialChars.length;i++)
		tempString = tempString.split(validSpecialChars.charAt(i)).join(replacementArray[i]);
	return tempString;
}

function closew()
{	
	window.close();
}

function resetForm(obj)
{
	obj.reset();
	parent.lookup_detail.document.location.href = "../../eCommon/html/blank.html";
	document.CriteriaForm.search_text.value="";
}