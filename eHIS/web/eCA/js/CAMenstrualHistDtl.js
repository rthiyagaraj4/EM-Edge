/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
--------------------------------------------------------------------------------------------------------------------
*/

function reset()
{
location.reload();	
}

function isValidInteger(obj) {
	var key = window.event.keyCode;
	if(!(key >= 48 && key <= 57)) {
		return false;
	} else {
		return true;
	}
} 

function zerocheck()
{
var minAge =document.getElementById("Min_Age").value;

if(minAge=='0' || minAge=='00' || minAge=='000')
		{
			alert(getMessage("ZERO_VALIDATE",'CA'));
			document.getElementById("Min_Age").select();
			return false;
		}

var maxAge =document.getElementById("Max_Age").value;

if(maxAge=='0' || maxAge=='00' || maxAge=='000')
		{
			alert(getMessage("ZERO_VALIDATE",'CA'));
			document.getElementById("Max_Age").select();
			return false;
		}

var CutOffDeliveryLmp =document.getElementById("Cut_Off_Delivery_Lmp").value;

if(CutOffDeliveryLmp=='0' || CutOffDeliveryLmp=='00' || CutOffDeliveryLmp=='000')
		{
			alert(getMessage("ZERO_VALIDATE",'CA'));
			document.getElementById("Cut_Off_Delivery_Lmp").select();
			return false;
		}


var CutOffMiscarriage =document.getElementById("Cut_Off_Miscarriage_Lmp").value;

if(CutOffMiscarriage=='0' || CutOffMiscarriage=='00' || CutOffMiscarriage=='000')
		{
			alert(getMessage("ZERO_VALIDATE",'CA'));
			document.getElementById("Cut_Off_Miscarriage_Lmp").select();
			return false;
		}
}



function apply()
{
	formObj = f_query_add_mod.document.CAMenstrualHistoryDtl;
	 var  minAge = formObj.Min_Age.value;
	 var  maxAge = formObj.Max_Age.value;

	 if(parseInt(minAge) > parseInt(maxAge))
	{
		 var error=getMessage("MAX_GRT_EQ_MIN","CA");
		 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
		return false;
	}
	 
	var fields = new Array (formObj.Min_Age,formObj.Max_Age,formObj.Cut_Off_Backdate_Delivery,formObj.Cut_Off_Date_Delivery,formObj.Cut_Off_Delivery_Lmp,formObj.Cut_Off_Miscarriage_Lmp);
	var names = new Array (getLabel("Common.MinimumAge.label","COMMON"),getLabel("eCA.MaximumAge.label","CA"),getLabel("eCA.CutOffBackdateDelivery.label","CA"),getLabel("eCA.CutOffDateDelivery.label","CA"),getLabel("eCA.CutOffDeliveryLmp.label","CA"),getLabel("eCA.CutOffMiscarriageLmp.label","CA"));
	if(checkFieldsofMst( fields, names, messageFrame))
	{
		formObj.action='../../servlet/eCA.CAMenstrualHistDtlServlet';
		formObj.target='messageFrame';
		formObj.method="post";
		formObj.submit();
	}
}


function toEnableMark(obj)
{
	if(obj.checked)
	document.CAMenstrualHistoryDtl.Enable_Mark_As_Error_YN.value = 'Y';
	else
	document.CAMenstrualHistoryDtl.Enable_Mark_As_Error_YN.value = 'N';
}


function onSuccess() 
{
	f_query_add_mod.location.reload();
}


function checkForMinus(obj)
{
	if(obj.value != '')
	{
		if(obj.value.indexOf("-") > -1)
		{
			
			alert(getMessage("ONLY_POSITIVE_NUM","CA"))
			obj.select();
			return false;
		}
	}
	CaCheckTime(obj); 
}


function CaCheckTime(obj) {
   var sequence = "1234567890:";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert(parent.getMessage('ONLY_POSITIVE_NUM','CA'));
			obj.select();
			return false;
		}
   }
}
